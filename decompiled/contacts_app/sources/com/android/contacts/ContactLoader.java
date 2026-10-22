package com.android.contacts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.loader.content.Loader;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountTypeWithDataSet;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.ContactLoaderUtils;
import com.android.contacts.util.DataStatus;
import com.android.contacts.util.StreamItemEntry;
import com.android.contacts.util.StreamItemPhotoEntry;
import com.android.internal.telephony.IccCardConstants;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import com.google.android.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.obric.cloudsdk.kv.base.KvConstant;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: loaded from: classes.dex */
public class ContactLoader extends Loader<Result> {
    private static final String TAG = "ContactLoader";
    private Result mContact;
    private boolean mDestroyed;
    private boolean mLoadGroupMetaData;
    private final boolean mLoadInvitableAccountTypes;
    private boolean mLoadStreamItems;
    private Uri mLookupUri;
    private final Set<Long> mNotifiedRawContactIds;
    private Loader<Result>.ForceLoadContentObserver mObserver;
    private final Uri mRequestedUri;

    /* JADX INFO: renamed from: com.android.contacts.ContactLoader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class AsyncPhotoLoader extends AsyncTask<String, Void, byte[]> {
        private static final int BUFFER_SIZE = 16384;
        final /* synthetic */ ContactLoader this$0;

        private AsyncPhotoLoader(ContactLoader r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AsyncPhotoLoader(ContactLoader r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ byte[] doInBackground(String[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(byte[] r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected byte[] doInBackground2(String... r9) {
            Uri r10 = Uri.parse(r9[0]);
            byte[] r3 = null;
            InputStream r8 = this.this$0.getContext().getContentResolver().openInputStream(r10);     // Catch: IOException -> L18
            if (r8 == null) goto L16;
            ByteArrayOutputStream r4 = new ByteArrayOutputStream();     // Catch: IOException -> L18
            byte[] r5 = new byte[16384];     // Catch: Throwable -> L13
        L8:
            int r6 = r8.read(r5);     // Catch: Throwable -> L13
            if (r6 == (-1)) goto L11;
            r4.write(r5, 0, r6);     // Catch: Throwable -> L13
            goto L8
        L11:
            r3 = r4.toByteArray();     // Catch: Throwable -> L13
            r8.close();     // Catch: IOException -> L18
        L20:
            return r3;
        L13:
            th = move-exception;
            r8.close();     // Catch: IOException -> L18
            throw th;     // Catch: IOException -> L18
        L16:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(ContactLoader.TAG, "Cannot load photo " + r10);     // Catch: IOException -> L18
        L18:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactLoader.TAG, "Cannot load photo " + r10, e);
            goto L20
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(byte[] r5) {
            if (ContactLoader.access$1000(this.this$0) == null) goto L6;
            ContactLoader.access$1002(this.this$0, new Result(ContactLoader.access$1000(this.this$0), null));
            ContactLoader.access$1000(this.this$0).setPhotoBinaryData(r5);
            Result.access$1200(ContactLoader.access$1000(this.this$0), false);
            ContactLoader r4 = this.this$0;
            r4.deliverResult(ContactLoader.access$1000(r4));
            return;
        }
    }

    private static class ContactQuery {
        public static final int ACCOUNT_NAME = 15;
        public static final int ACCOUNT_TYPE = 16;
        public static final int ACCOUNT_TYPE_AND_DATA_SET = 18;
        public static final int ALT_DISPLAY_NAME = 4;
        public static final int CHAT_CAPABILITY = 54;
        static final String[] COLUMNS = null;
        public static final int CONTACT_ID = 13;
        public static final int CONTACT_PRESENCE = 8;
        public static final int CONTACT_STATUS = 9;
        public static final int CONTACT_STATUS_LABEL = 12;
        public static final int CONTACT_STATUS_RES_PACKAGE = 11;
        public static final int CONTACT_STATUS_TIMESTAMP = 10;
        public static final int CUSTOM_RINGTONE = 62;
        public static final int DATA1 = 28;
        public static final int DATA10 = 37;
        public static final int DATA11 = 38;
        public static final int DATA12 = 39;
        public static final int DATA13 = 40;
        public static final int DATA14 = 41;
        public static final int DATA15 = 42;
        public static final int DATA2 = 29;
        public static final int DATA3 = 30;
        public static final int DATA4 = 31;
        public static final int DATA5 = 32;
        public static final int DATA6 = 33;
        public static final int DATA7 = 34;
        public static final int DATA8 = 35;
        public static final int DATA9 = 36;
        public static final int DATA_ID = 27;
        public static final int DATA_SET = 17;
        public static final int DATA_SYNC1 = 43;
        public static final int DATA_SYNC2 = 44;
        public static final int DATA_SYNC3 = 45;
        public static final int DATA_SYNC4 = 46;
        public static final int DATA_VERSION = 47;
        public static final int DELETED = 26;
        public static final int DIRTY = 19;
        public static final int DISPLAY_NAME = 3;
        public static final int DISPLAY_NAME_SOURCE = 1;
        public static final int GROUP_SOURCE_ID = 52;
        public static final int IS_PRIMARY = 48;
        public static final int IS_SUPERPRIMARY = 49;
        public static final int IS_USER_PROFILE = 63;
        public static final int LOOKUP_KEY = 2;
        public static final int MIMETYPE = 50;
        public static final int NAME_RAW_CONTACT_ID = 0;
        public static final int PHONETIC_NAME = 5;
        public static final int PHOTO_ID = 6;
        public static final int PHOTO_URI = 60;
        public static final int PRESENCE = 53;
        public static final int RAW_CONTACT_ID = 14;
        public static final int RES_PACKAGE = 51;
        public static final int SEND_TO_VOICEMAIL = 61;
        public static final int SOURCE_ID = 21;
        public static final int STARRED = 7;
        public static final int STATUS = 55;
        public static final int STATUS_ICON = 57;
        public static final int STATUS_LABEL = 58;
        public static final int STATUS_RES_PACKAGE = 56;
        public static final int STATUS_TIMESTAMP = 59;
        public static final int SYNC1 = 22;
        public static final int SYNC2 = 23;
        public static final int SYNC3 = 24;
        public static final int SYNC4 = 25;
        public static final int VERSION = 20;

        private ContactQuery() {
        }

        static {
            COLUMNS = new String[]{"name_raw_contact_id", "display_name_source", "lookup", "display_name", "display_name_alt", "phonetic_name", "photo_id", ContactSaveService.EXTRA_STARRED_FLAG, "contact_presence", "contact_status", "contact_status_ts", "contact_status_res_package", "contact_status_label", "contact_id", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "account_name", "account_type", "data_set", "account_type_and_data_set", "dirty", GloableSearchConfig.KEY_VERSION, "sourceid", "sync1", "sync2", "sync3", "sync4", "deleted", KvConstant.KV_DATA_ID, "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME, BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN, "data14", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, "data_sync1", "data_sync2", "data_sync3", "data_sync4", "data_version", "is_primary", "is_super_primary", "mimetype", "res_package", "group_sourceid", "mode", "chat_capability", "status", "status_res_package", "status_icon", "status_label", "status_ts", "photo_uri", "send_to_voicemail", "custom_ringtone", "is_user_profile"};
        }
    }

    private static class DirectoryQuery {
        public static final int ACCOUNT_NAME = 4;
        public static final int ACCOUNT_TYPE = 3;
        static final String[] COLUMNS = null;
        public static final int DISPLAY_NAME = 0;
        public static final int EXPORT_SUPPORT = 5;
        public static final int PACKAGE_NAME = 1;
        public static final int TYPE_RESOURCE_ID = 2;

        private DirectoryQuery() {
        }

        static {
            COLUMNS = new String[]{"displayName", "packageName", "typeResourceId", ContactSaveService.EXTRA_ACCOUNT_TYPE, ContactSaveService.EXTRA_ACCOUNT_NAME, "exportSupport"};
        }
    }

    private static class GroupQuery {
        public static final int ACCOUNT_NAME = 0;
        public static final int ACCOUNT_TYPE = 1;
        public static final int ACCOUNT_TYPE_AND_DATA_SET = 3;
        public static final int AUTO_ADD = 6;
        static final String[] COLUMNS = null;
        public static final int DATA_SET = 2;
        public static final int FAVORITES = 7;
        public static final int ID = 4;
        public static final int TITLE = 5;

        private GroupQuery() {
        }

        static {
            COLUMNS = new String[]{"account_name", "account_type", "data_set", "account_type_and_data_set", "_id", "title", "auto_add", "favorites"};
        }
    }

    public interface Listener {
        void onContactLoaded(Result r1);
    }

    private final class LoadContactTask extends AsyncTask<Void, Void, Result> {
        final /* synthetic */ ContactLoader this$0;

        private LoadContactTask(ContactLoader r1) {
            this.this$0 = r1;
        }

        /* synthetic */ LoadContactTask(ContactLoader r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Result doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Result r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Result doInBackground2(Void... r3) {
            ContentResolver r4 = this.this$0.getContext().getContentResolver();     // Catch: Exception -> L19
            Result r5 = loadContactEntity(r4, ContactLoaderUtils.ensureIsContactUri(r4, ContactLoader.access$000(this.this$0)));     // Catch: Exception -> L19
            if (r5.isNotFound() == false) goto L5;
        L18:
            return r5;
        L5:
            if (r5.isDirectoryEntry() == false) goto L8;
            loadDirectoryMetaData(r5);     // Catch: Exception -> L19
        L11:
            if (ContactLoader.access$200(this.this$0) == false) goto L13;
            loadStreamItems(r5);     // Catch: Exception -> L19
        L13:
            ContactLoader.access$300(this.this$0, r5);     // Catch: Exception -> L19
            loadPhotoBinaryData(r5);     // Catch: Exception -> L19
            if (ContactLoader.access$400(this.this$0) == false) goto L18;
            if (r5.isUserProfile() == true) goto L18;
            loadInvitableAccountTypes(r5);     // Catch: Exception -> L19
            goto L18
        L8:
            if (ContactLoader.access$100(this.this$0) == false) goto L11;
            loadGroupMetaData(r5);     // Catch: Exception -> L19
        L19:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactLoader.TAG, "Error loading the contact: " + ContactLoader.access$000(this.this$0), e);
            return Result.access$600(ContactLoader.access$500(this.this$0), e);
        }

        private Result loadContactEntity(ContentResolver r10, Uri r11) {
            if (r11 != null) goto L46;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactLoader.TAG, "contactUri is null returned in loadContactEntity");
            return Result.access$700(ContactLoader.access$500(this.this$0));
        L46:
            if (ContentUris.parseId(r11) > 0) goto L11;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactLoader.TAG, "Invalid contactId in URI: " + r11);
            return Result.access$700(ContactLoader.access$500(this.this$0));
        L11:
            Cursor r12 = r10.query(Uri.withAppendedPath(r11, "entities"), ContactQuery.COLUMNS, null, null, GroupSelectionActivity.EXTRA_RAW_CONTACT_ID);
            if (r12 != null) goto L48;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactLoader.TAG, "No cursor returned in loadContactEntity");
            return Result.access$700(ContactLoader.access$500(this.this$0));
        L48:
        L40:
            th = move-exception;
            r12.close();
            throw th;
        L16:
            if (r12.moveToFirst() == true) goto L20;
            r12.close();     // Catch: Throwable -> L40
            Result r9 = Result.access$700(ContactLoader.access$500(this.this$0));     // Catch: Throwable -> L40
            r12.close();
            return r9;
        L20:
            Result r13 = loadContactHeaderData(r12, r11);     // Catch: Throwable -> L40
            ArrayList<Entity> r0 = r13.getEntities();     // Catch: Throwable -> L40
            HashMap<Long, DataStatus> r1 = r13.getStatuses();     // Catch: Throwable -> L40
            long r2 = -1;
            Entity r4 = null;
        L22:
            if (r12.isAfterLast() == true) goto L38;
            long r5 = r12.getLong(14);     // Catch: Throwable -> L40
            if (r5 == r2) goto L27;
            Entity r3 = new Entity(loadRawContact(r12));     // Catch: Throwable -> L40
            r0.add(r3);     // Catch: Throwable -> L40
            r4 = r3;
            r2 = r5;
        L27:
            if (r12.isNull(27) == true) goto L36;
            ContentValues r6 = loadData(r12);     // Catch: Throwable -> L40
            if (r4 == null) goto L32;
            r4.addSubValue(ContactsContract.Data.CONTENT_URI, r6);     // Catch: Throwable -> L40
        L32:
            if (r12.isNull(53) == true) goto L34;
        L35:
            r1.put(Long.valueOf(r12.getLong(27)), new DataStatus(r12));     // Catch: Throwable -> L40
            goto L36
        L34:
            if (r12.isNull(55) == false) goto L35;
        L36:
            r12.moveToNext();     // Catch: Throwable -> L40
            goto L22
        L38:
            r12.close();
            return r13;
        L43:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactLoader.TAG, "Invalid contactId in URI: " + r11, e);
            return Result.access$700(ContactLoader.access$500(this.this$0));
        }

        private void loadPhotoBinaryData(Result r7) {
            String r0 = r7.getPhotoUri();
            if (r0 != null) goto L33;
        L14:
            long r1 = r7.getPhotoId();
            if (r1 > 0) goto L17;
            return;
        L17:
            Iterator<Entity> r6 = r7.getEntities().iterator();
        L19:
            if (r6.hasNext() == false) goto L29;
            Iterator<Entity.NamedContentValues> r2 = r6.next().getSubValues().iterator();
        L22:
            if (r2.hasNext() == false) goto L19;
            ContentValues r3 = r2.next().values;
            if (r3.getAsLong("_id").longValue() != r1) goto L22;
            if ("vnd.android.cursor.item/photo".equals(r3.getAsString("mimetype")) == false) goto L27;
            r7.setPhotoBinaryData(r3.getAsByteArray(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG));
            goto L19
        L27:
            return;
        L29:
            return;
        L33:
            AssetFileDescriptor r8 = this.this$0.getContext().getContentResolver().openAssetFileDescriptor(Uri.parse(r0), "r");     // Catch: Throwable -> L30
            byte[] r4 = new byte[16384];     // Catch: Throwable -> L30
            FileInputStream r5 = r8.createInputStream();     // Catch: Throwable -> L30
            ByteArrayOutputStream r9 = new ByteArrayOutputStream();     // Catch: Throwable -> L30
        L31:
            int r10 = r5.read(r4);     // Catch: Throwable -> L11
            if (r10 == (-1)) goto L8;
            r9.write(r4, 0, r10);     // Catch: Throwable -> L11
            goto L31
        L8:
            r7.setPhotoBinaryData(r9.toByteArray());     // Catch: Throwable -> L11
            r5.close();     // Catch: Throwable -> L30 Throwable -> L30
            r9.close();     // Catch: Throwable -> L30 Throwable -> L30
            r8.close();     // Catch: Throwable -> L30 Throwable -> L30
            return;
        L11:
            th = move-exception;
            r5.close();     // Catch: Throwable -> L30 Throwable -> L30
            r9.close();     // Catch: Throwable -> L30 Throwable -> L30
            r8.close();     // Catch: Throwable -> L30 Throwable -> L30
            throw th;     // Catch: Throwable -> L30 Throwable -> L30
        }

        private void loadInvitableAccountTypes(Result r5) {
            Map<AccountTypeWithDataSet, AccountType> r4 = AccountTypeManager.getInstance(this.this$0.getContext()).getUsableInvitableAccountTypes();
            if (r4.isEmpty() == false) goto L5;
            return;
        L5:
            HashMap r6 = Maps.newHashMap(r4);
            Iterator<Entity> r0 = r5.getEntities().iterator();
        L7:
            if (r0.hasNext() == false) goto L9;
            ContentValues r1 = r0.next().getEntityValues();
            r6.remove(AccountTypeWithDataSet.get(r1.getAsString("account_type"), r1.getAsString("data_set")));
            goto L7
        L9:
            r5.mInvitableAccountTypes.addAll(r6.values());
        }

        private Result loadContactHeaderData(Cursor r28, Uri r29) {
            String r1 = r29.getQueryParameter("directory");
            if (r1 != null) goto L5;
            long r6 = 0;
        L6:
            long r9 = r28.getLong(13);
            String r8 = r28.getString(2);
            long r11 = r28.getLong(0);
            int r13 = r28.getInt(1);
            String r17 = r28.getString(3);
            String r18 = r28.getString(4);
            String r19 = r28.getString(5);
            long r14 = r28.getLong(6);
            String r2 = r28.getString(60);
            if (r28.getInt(7) == 0) goto L9;
            boolean r22 = true;
        L11:
            if (r28.isNull(8) == false) goto L13;
            Integer r3 = null;
        L14:
            Integer r23 = r3;
            if (r28.getInt(61) != 1) goto L17;
            boolean r24 = true;
        L18:
            String r25 = r28.getString(62);
            if (r28.getInt(63) != 1) goto L21;
            boolean r0 = true;
        L23:
            if (r6 != 0) goto L25;
        L28:
            Uri r5 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, r8), r9);
        L30:
            return new Result(ContactLoader.access$500(this.this$0), r29, r5, r6, r8, r9, r11, r13, r14, r2, r17, r18, r19, r22, r23, r24, r25, r0);
        L25:
            if (r6 == 1) goto L28;
            r5 = r29;
            goto L30
        L21:
            r0 = false;
            goto L23
        L17:
            r24 = false;
            goto L18
        L13:
            r3 = Integer.valueOf(r28.getInt(8));
            goto L14
        L9:
            r22 = false;
            goto L11
        L5:
            r6 = Long.parseLong(r1);
            goto L6
        }

        private ContentValues loadRawContact(Cursor r4) {
            ContentValues r0 = new ContentValues();
            r0.put("_id", Long.valueOf(r4.getLong(14)));
            cursorColumnToContentValues(r4, r0, 15);
            cursorColumnToContentValues(r4, r0, 16);
            cursorColumnToContentValues(r4, r0, 17);
            cursorColumnToContentValues(r4, r0, 18);
            cursorColumnToContentValues(r4, r0, 19);
            cursorColumnToContentValues(r4, r0, 20);
            cursorColumnToContentValues(r4, r0, 21);
            cursorColumnToContentValues(r4, r0, 22);
            cursorColumnToContentValues(r4, r0, 23);
            cursorColumnToContentValues(r4, r0, 24);
            cursorColumnToContentValues(r4, r0, 25);
            cursorColumnToContentValues(r4, r0, 26);
            cursorColumnToContentValues(r4, r0, 13);
            cursorColumnToContentValues(r4, r0, 7);
            return r0;
        }

        private ContentValues loadData(Cursor r4) {
            ContentValues r0 = new ContentValues();
            r0.put("_id", Long.valueOf(r4.getLong(27)));
            cursorColumnToContentValues(r4, r0, 28);
            cursorColumnToContentValues(r4, r0, 29);
            cursorColumnToContentValues(r4, r0, 30);
            cursorColumnToContentValues(r4, r0, 31);
            cursorColumnToContentValues(r4, r0, 32);
            cursorColumnToContentValues(r4, r0, 33);
            cursorColumnToContentValues(r4, r0, 34);
            cursorColumnToContentValues(r4, r0, 35);
            cursorColumnToContentValues(r4, r0, 36);
            cursorColumnToContentValues(r4, r0, 37);
            cursorColumnToContentValues(r4, r0, 38);
            cursorColumnToContentValues(r4, r0, 39);
            cursorColumnToContentValues(r4, r0, 40);
            cursorColumnToContentValues(r4, r0, 41);
            cursorColumnToContentValues(r4, r0, 42);
            cursorColumnToContentValues(r4, r0, 43);
            cursorColumnToContentValues(r4, r0, 44);
            cursorColumnToContentValues(r4, r0, 45);
            cursorColumnToContentValues(r4, r0, 46);
            cursorColumnToContentValues(r4, r0, 47);
            cursorColumnToContentValues(r4, r0, 48);
            cursorColumnToContentValues(r4, r0, 49);
            cursorColumnToContentValues(r4, r0, 50);
            cursorColumnToContentValues(r4, r0, 51);
            cursorColumnToContentValues(r4, r0, 52);
            cursorColumnToContentValues(r4, r0, 54);
            return r0;
        }

        private void cursorColumnToContentValues(Cursor r3, ContentValues r4, int r5) {
            int r2 = r3.getType(r5);
            if (r2 != 0) goto L5;
            return;
        L5:
            if (r2 != 1) goto L7;
            r4.put(ContactQuery.COLUMNS[r5], Long.valueOf(r3.getLong(r5)));
            return;
        L7:
            if (r2 != 3) goto L9;
            r4.put(ContactQuery.COLUMNS[r5], r3.getString(r5));
            return;
        L9:
            if (r2 != 4) goto L12;
            r4.put(ContactQuery.COLUMNS[r5], r3.getBlob(r5));
            return;
        L12:
            throw new IllegalStateException("Invalid or unhandled data type");
        }

        private void loadDirectoryMetaData(Result r11) {
            Cursor r1 = this.this$0.getContext().getContentResolver().query(ContentUris.withAppendedId(ContactsContract.Directory.CONTENT_URI, r11.getDirectoryId()), DirectoryQuery.COLUMNS, null, null, null);
            if (r1 != null) goto L21;
            return;
        L21:
        L18:
            th = move-exception;
            r1.close();
            throw th;
        L6:
            if (r1.moveToFirst() == false) goto L16;
            String r4 = r1.getString(0);     // Catch: Throwable -> L18
            String r2 = r1.getString(1);     // Catch: Throwable -> L18
            int r3 = r1.getInt(2);     // Catch: Throwable -> L18
            String r6 = r1.getString(3);     // Catch: Throwable -> L18
            String r7 = r1.getString(4);     // Catch: Throwable -> L18
            int r8 = r1.getInt(5);     // Catch: Throwable -> L18
            String r9 = null;
            if (TextUtils.isEmpty(r2) == false) goto L23;
        L15:
            r11.setDirectoryMetaData(r4, r9, r6, r7, r8);     // Catch: Throwable -> L18
            goto L16
        L23:
            Resources r10 = this.this$0.getContext().getPackageManager().getResourcesForApplication(r2);     // Catch: PackageManager.NameNotFoundException -> L14 Throwable -> L18
            if (r10 == null) goto L15;
            r9 = r10.getString(r3);     // Catch: PackageManager.NameNotFoundException -> L14 Throwable -> L18
        L14:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ContactLoader.TAG, "Contact directory resource not found: " + r2 + LibrarianImpl.Constants.DOT + r3);     // Catch: Throwable -> L18
        L16:
            r1.close();
        }

        private void loadGroupMetaData(Result r12) {
            StringBuilder r0 = new StringBuilder();
            ArrayList r1 = new ArrayList();
            Iterator<Entity> r2 = r12.mEntities.iterator();
        L4:
            if (r2.hasNext() == false) goto L16;
            ContentValues r3 = r2.next().getEntityValues();
            String r4 = r3.getAsString("account_name");
            String r5 = r3.getAsString("account_type");
            String r6 = r3.getAsString("data_set");
            if (r4 == null) goto L4;
            if (r5 == null) goto L4;
            if (r0.length() == 0) goto L11;
            r0.append(" OR ");
        L11:
            r0.append("(account_name=? AND account_type=?");
            r1.add(r4);
            r1.add(r5);
            if (r6 == null) goto L14;
            r0.append(" AND data_set=?");
            r1.add(r6);
        L15:
            r0.append(")");
            goto L4
        L14:
            r0.append(" AND data_set IS NULL");
            goto L15
        L16:
            Cursor r7 = this.this$0.getContext().getContentResolver().query(ContactsContract.Groups.CONTENT_URI, GroupQuery.COLUMNS, r0.toString(), (String[]) r1.toArray(new String[0]), null);
        L38:
            if (r7.moveToNext() == false) goto L33;
            String r8 = r7.getString(0);     // Catch: Throwable -> L35
            String r9 = r7.getString(1);     // Catch: Throwable -> L35
            String r10 = r7.getString(2);     // Catch: Throwable -> L35
            long r11 = r7.getLong(4);     // Catch: Throwable -> L35
            String r13 = r7.getString(5);     // Catch: Throwable -> L35
            if (r7.isNull(6) == false) goto L23;
        L21:
            boolean r14 = false;
        L26:
            if (r7.isNull(7) == false) goto L29;
        L27:
            boolean r15 = false;
        L31:
            r12.addGroupMetaData(new GroupMetaData(r8, r9, r10, r11, r13, r14, r15));     // Catch: Throwable -> L35
            goto L38
        L29:
            if (r7.getInt(7) == 0) goto L27;
            r15 = true;
            goto L31
        L23:
            if (r7.getInt(6) == 0) goto L21;
            r14 = true;
            goto L26
        L33:
            r7.close();
            return;
        L35:
            th = move-exception;
            r7.close();
            throw th;
        }

        private void loadStreamItems(Result r11) {
            Cursor r0 = this.this$0.getContext().getContentResolver().query(ContactsContract.Contacts.CONTENT_LOOKUP_URI.buildUpon().appendPath(r11.getLookupKey()).appendPath("stream_items").build(), null, null, null, null);
            HashMap r1 = new HashMap();
            ArrayList r2 = new ArrayList();
        L52:
        L44:
            th = move-exception;
            if (r0 == null) goto L47;
            r0.close();
        L47:
            throw th;
        L4:
            if (r0.moveToNext() == false) goto L7;
            StreamItemEntry r3 = new StreamItemEntry(r0);     // Catch: Throwable -> L44
            r1.put(Long.valueOf(r3.getId()), r3);     // Catch: Throwable -> L44
            r2.add(r3);     // Catch: Throwable -> L44
            goto L52
        L7:
            if (r0 == null) goto L10;
            r0.close();
        L10:
            if (r2.isEmpty() == false) goto L12;
        L42:
            Collections.sort(r2);
            r11.mStreamItems.addAll(r2);
            return;
        L12:
            if (r11.isUserProfile() == false) goto L25;
            Iterator r4 = r2.iterator();
        L15:
            if (r4.hasNext() == false) goto L42;
            StreamItemEntry r5 = (StreamItemEntry) r4.next();
            Cursor r6 = this.this$0.getContext().getContentResolver().query(Uri.withAppendedPath(ContentUris.withAppendedId(ContactsContract.StreamItems.CONTENT_URI, r5.getId()), BlackListQueryHandler.KEY_PHOTO), null, null, null, null);
        L50:
        L22:
            th = move-exception;
            r6.close();
            throw th;
        L18:
            if (r6.moveToNext() == false) goto L21;
            r5.addPhoto(new StreamItemPhotoEntry(r6));     // Catch: Throwable -> L22
            goto L50
        L21:
            r6.close();
            goto L15
        L25:
            String[] r7 = new String[r2.size()];
            StringBuilder r8 = new StringBuilder("stream_item_id IN (");
            int r9 = 0;
        L27:
            if (r9 >= r2.size()) goto L31;
            if (r9 <= 0) goto L30;
            r8.append(SimContactsConstants.EMAIL_SEP);
        L30:
            r8.append("?");
            r7[r9] = String.valueOf(((StreamItemEntry) r2.get(r9)).getId());
            r9 = r9 + 1;
            goto L27
        L31:
            r8.append(")");
            Cursor r10 = this.this$0.getContext().getContentResolver().query(ContactsContract.StreamItems.CONTENT_PHOTO_URI, null, r8.toString(), r7, "stream_item_id");
        L48:
        L38:
            th = move-exception;
            if (r10 == null) goto L41;
            r10.close();
        L41:
            throw th;
        L33:
            if (r10.moveToNext() == false) goto L36;
            ((StreamItemEntry) r1.get(Long.valueOf(r10.getLong(r10.getColumnIndex("stream_item_id"))))).addPhoto(new StreamItemPhotoEntry(r10));     // Catch: Throwable -> L38
            goto L48
        L36:
            if (r10 == null) goto L42;
            r10.close();
            goto L42
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Result r4) {
            ContactLoader.access$800(this.this$0);
            if (ContactLoader.access$900(this.this$0) == true) goto L22;
            if (r4 == null) goto L23;
            ContactLoader.access$1002(this.this$0, r4);
            if (r4.isLoaded() == false) goto L20;
            ContactLoader.access$002(this.this$0, r4.getLookupUri());
            if (r4.isDirectoryEntry() == true) goto L15;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ContactLoader.TAG, "Registering content observer for " + ContactLoader.access$000(this.this$0));
            if (ContactLoader.access$1100(this.this$0) != null) goto L13;
            ContactLoader.access$1102(this.this$0, new Loader.ForceLoadContentObserver(this.this$0));
        L13:
            this.this$0.getContext().getContentResolver().registerContentObserver(ContactLoader.access$000(this.this$0), true, ContactLoader.access$1100(this.this$0));
        L15:
            if (ContactLoader.access$1000(this.this$0).getPhotoBinaryData() == null) goto L17;
        L19:
            ContactLoader.access$1400(this.this$0);
            goto L20
        L17:
            if (ContactLoader.access$1000(this.this$0).getPhotoUri() == null) goto L19;
            Result.access$1200(ContactLoader.access$1000(this.this$0), true);
            new AsyncPhotoLoader(this.this$0, null).execute(new String[]{ContactLoader.access$1000(this.this$0).getPhotoUri()});
        L20:
            ContactLoader r3 = this.this$0;
            r3.deliverResult(ContactLoader.access$1000(r3));
            return;
        L23:
            return;
        }
    }

    public static final class Result {
        public String mAltDisplayName;
        public String mCustomRingtone;
        public String mDirectoryAccountName;
        public String mDirectoryAccountType;
        public String mDirectoryDisplayName;
        public int mDirectoryExportSupport;
        public final long mDirectoryId;
        public String mDirectoryType;
        public String mDisplayName;
        public final int mDisplayNameSource;
        public ArrayList<Entity> mEntities;
        public final Exception mException;
        public ArrayList<GroupMetaData> mGroups;
        public final long mId;
        public ArrayList<AccountType> mInvitableAccountTypes;
        public final boolean mIsUserProfile;
        public boolean mLoadingPhoto;
        public final String mLookupKey;
        public Uri mLookupUri;
        public final long mNameRawContactId;
        public final String mPhoneticName;
        public byte[] mPhotoBinaryData;
        public final long mPhotoId;
        public final String mPhotoUri;
        public final Integer mPresence;
        public final Uri mRequestedUri;
        public final boolean mSendToVoicemail;
        public final boolean mStarred;
        public final Status mStatus;
        public HashMap<Long, DataStatus> mStatuses;
        public final ArrayList<StreamItemEntry> mStreamItems;
        public String mStringtoShare;
        public final Uri mUri;

        public static final enum Status extends Enum<Status> {
            private static final /* synthetic */ Status[] $VALUES = null;
            public static final Status DUMMY = null;
            public static final Status ERROR = null;
            public static final Status LOADED = null;
            public static final Status NOT_FOUND = null;

            private static /* synthetic */ Status[] $values() {
                return new Status[]{LOADED, ERROR, NOT_FOUND, DUMMY};
            }

            private Status(String r1, int r2) {
                super(r1, r2);
            }

            public static Status valueOf(String r1) {
                return (Status) Enum.valueOf(Status.class, r1);
            }

            public static Status[] values() {
                return (Status[]) $VALUES.clone();
            }

            static {
                LOADED = new Status(IccCardConstants.INTENT_VALUE_ICC_LOADED, 0);
                ERROR = new Status("ERROR", 1);
                NOT_FOUND = new Status("NOT_FOUND", 2);
                DUMMY = new Status("DUMMY", 3);
                $VALUES = $values();
            }
        }

        /* synthetic */ Result(Result r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$1200(Result r0, boolean r1) {
            r0.setLoadingPhoto(r1);
        }

        static /* synthetic */ Result access$600(Uri r0, Exception r1) {
            return forError(r0, r1);
        }

        static /* synthetic */ Result access$700(Uri r0) {
            return forNotFound(r0);
        }

        public static Result fromDummy() {
            Result r0 = new Result(null, Status.DUMMY, null);
            r0.mEntities = new ArrayList();
            r0.mStatuses = new HashMap();
            r0.mInvitableAccountTypes = new ArrayList();
            return r0;
        }

        private Result(Uri r2, Status r3, Exception r4) {
            this.mStringtoShare = "";
            if (r3 != Status.ERROR) goto L8;
            if (r4 != null) goto L8;
            throw new IllegalArgumentException("ERROR result must have exception");
        L8:
            this.mStatus = r3;
            this.mException = r4;
            this.mRequestedUri = r2;
            this.mLookupUri = null;
            this.mUri = null;
            this.mDirectoryId = -1;
            this.mLookupKey = null;
            this.mId = -1;
            this.mEntities = null;
            this.mStreamItems = new ArrayList();
            this.mStatuses = null;
            this.mNameRawContactId = -1;
            this.mDisplayNameSource = 0;
            this.mPhotoId = -1;
            this.mPhotoUri = null;
            this.mDisplayName = null;
            this.mAltDisplayName = null;
            this.mPhoneticName = null;
            this.mStarred = false;
            this.mPresence = null;
            this.mInvitableAccountTypes = null;
            this.mSendToVoicemail = false;
            this.mCustomRingtone = null;
            this.mIsUserProfile = false;
        }

        public void setShareString(String r3) {
            String r0 = this.mStringtoShare;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.contains(r3) == true) goto L9;
            this.mStringtoShare += r3;
            return;
        }

        public String getShareString() {
            return this.mStringtoShare;
        }

        private static Result forError(Uri r2, Exception r3) {
            return new Result(r2, Status.ERROR, r3);
        }

        private static Result forNotFound(Uri r3) {
            return new Result(r3, Status.NOT_FOUND, null);
        }

        public Result(Uri r4, Uri r5, Uri r6, long r7, String r9, long r10, long r12, int r14, long r15, String r17, String r18, String r19, String r20, boolean r21, Integer r22, boolean r23, String r24, boolean r25) {
            this.mStringtoShare = "";
            this.mStatus = Status.LOADED;
            this.mException = null;
            this.mRequestedUri = r4;
            this.mLookupUri = r6;
            this.mUri = r5;
            this.mDirectoryId = r7;
            this.mLookupKey = r9;
            this.mId = r10;
            this.mEntities = new ArrayList();
            this.mStreamItems = new ArrayList();
            this.mStatuses = new HashMap();
            this.mNameRawContactId = r12;
            this.mDisplayNameSource = r14;
            this.mPhotoId = r15;
            this.mPhotoUri = r17;
            this.mDisplayName = r18;
            this.mAltDisplayName = r19;
            this.mPhoneticName = r20;
            this.mStarred = r21;
            this.mPresence = r22;
            this.mInvitableAccountTypes = Lists.newArrayList();
            this.mSendToVoicemail = r23;
            this.mCustomRingtone = r24;
            this.mIsUserProfile = r25;
        }

        private Result(Result r3) {
            this.mStringtoShare = "";
            this.mStatus = r3.mStatus;
            this.mException = r3.mException;
            this.mRequestedUri = r3.mRequestedUri;
            this.mLookupUri = r3.mLookupUri;
            this.mUri = r3.mUri;
            this.mDirectoryId = r3.mDirectoryId;
            this.mLookupKey = r3.mLookupKey;
            this.mId = r3.mId;
            this.mNameRawContactId = r3.mNameRawContactId;
            this.mDisplayNameSource = r3.mDisplayNameSource;
            this.mPhotoId = r3.mPhotoId;
            this.mPhotoUri = r3.mPhotoUri;
            this.mDisplayName = r3.mDisplayName;
            this.mAltDisplayName = r3.mAltDisplayName;
            this.mPhoneticName = r3.mPhoneticName;
            this.mStarred = r3.mStarred;
            this.mPresence = r3.mPresence;
            this.mEntities = r3.mEntities;
            this.mStreamItems = r3.mStreamItems;
            this.mStatuses = r3.mStatuses;
            this.mInvitableAccountTypes = r3.mInvitableAccountTypes;
            this.mDirectoryDisplayName = r3.mDirectoryDisplayName;
            this.mDirectoryType = r3.mDirectoryType;
            this.mDirectoryAccountType = r3.mDirectoryAccountType;
            this.mDirectoryAccountName = r3.mDirectoryAccountName;
            this.mDirectoryExportSupport = r3.mDirectoryExportSupport;
            this.mGroups = r3.mGroups;
            this.mLoadingPhoto = r3.mLoadingPhoto;
            this.mPhotoBinaryData = r3.mPhotoBinaryData;
            this.mSendToVoicemail = r3.mSendToVoicemail;
            this.mCustomRingtone = r3.mCustomRingtone;
            this.mIsUserProfile = r3.mIsUserProfile;
        }

        public void setDirectoryMetaData(String r1, String r2, String r3, String r4, int r5) {
            this.mDirectoryDisplayName = r1;
            this.mDirectoryType = r2;
            this.mDirectoryAccountType = r3;
            this.mDirectoryAccountName = r4;
            this.mDirectoryExportSupport = r5;
        }

        private void setLoadingPhoto(boolean r1) {
            this.mLoadingPhoto = r1;
        }

        public void setPhotoBinaryData(byte[] r1) {
            this.mPhotoBinaryData = r1;
        }

        public Uri getLookupUri() {
            return this.mLookupUri;
        }

        public String getLookupKey() {
            return this.mLookupKey;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public Uri getRequestedUri() {
            return this.mRequestedUri;
        }

        public long getId() {
            return this.mId;
        }

        public boolean isError() {
            if (this.mStatus != Status.ERROR) goto L5;
            return true;
        L5:
            return false;
        }

        public Exception getException() {
            return this.mException;
        }

        public boolean isNotFound() {
            if (this.mStatus != Status.NOT_FOUND) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isLoaded() {
            if (this.mStatus != Status.LOADED) goto L5;
            return true;
        L5:
            return false;
        }

        public long getNameRawContactId() {
            return this.mNameRawContactId;
        }

        public int getDisplayNameSource() {
            return this.mDisplayNameSource;
        }

        public long getPhotoId() {
            return this.mPhotoId;
        }

        public String getPhotoUri() {
            return this.mPhotoUri;
        }

        public String getDisplayName() {
            return this.mDisplayName;
        }

        public String getAltDisplayName() {
            return this.mAltDisplayName;
        }

        public String getPhoneticName() {
            return this.mPhoneticName;
        }

        public boolean getStarred() {
            return this.mStarred;
        }

        public Integer getPresence() {
            return this.mPresence;
        }

        public ArrayList<AccountType> getInvitableAccountTypes() {
            return this.mInvitableAccountTypes;
        }

        public ArrayList<Entity> getEntities() {
            return this.mEntities;
        }

        public ArrayList<StreamItemEntry> getStreamItems() {
            return this.mStreamItems;
        }

        public HashMap<Long, DataStatus> getStatuses() {
            return this.mStatuses;
        }

        public long getDirectoryId() {
            return this.mDirectoryId;
        }

        public boolean isDirectoryEntry() {
            long r0 = this.mDirectoryId;
            if (r0 != (-1)) goto L5;
        L9:
            return false;
        L5:
            if (r0 == 0) goto L9;
            if (r0 == 1) goto L9;
            return true;
        }

        public int getDirectoryExportSupport() {
            return this.mDirectoryExportSupport;
        }

        public String getDirectoryDisplayName() {
            return this.mDirectoryDisplayName;
        }

        public String getDirectoryType() {
            return this.mDirectoryType;
        }

        public String getDirectoryAccountType() {
            return this.mDirectoryAccountType;
        }

        public String getDirectoryAccountName() {
            return this.mDirectoryAccountName;
        }

        public boolean isLoadingPhoto() {
            return this.mLoadingPhoto;
        }

        public byte[] getPhotoBinaryData() {
            return this.mPhotoBinaryData;
        }

        public ArrayList<ContentValues> getContentValues() {
            if (this.mEntities.size() != 1) goto L19;
            int r1 = 0;
            Entity r0 = this.mEntities.get(0);
            ArrayList<ContentValues> r2 = new ArrayList();
            ArrayList<Entity.NamedContentValues> r3 = r0.getSubValues();
            if (r3 == null) goto L13;
            int r4 = r3.size();
        L7:
            if (r1 >= r4) goto L13;
            Entity.NamedContentValues r5 = r3.get(r1);
            if (ContactsContract.Data.CONTENT_URI.equals(r5.uri) == false) goto L11;
            r2.add(r5.values);
        L11:
            r1 = r1 + 1;
        L13:
            if (this.mPhotoId == 0) goto L15;
        L17:
            return r2;
        L15:
            if (this.mPhotoBinaryData == null) goto L17;
            ContentValues r6 = new ContentValues();
            r6.put("mimetype", "vnd.android.cursor.item/photo");
            r6.put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, this.mPhotoBinaryData);
            r2.add(r6);
            goto L17
        L19:
            throw new IllegalStateException("Cannot extract content values from an aggregated contact");
        }

        public void addGroupMetaData(GroupMetaData r2) {
            if (this.mGroups != null) goto L5;
            this.mGroups = new ArrayList();
        L5:
            this.mGroups.add(r2);
        }

        public List<GroupMetaData> getGroupMetaData() {
            return this.mGroups;
        }

        public boolean isSendToVoicemail() {
            return this.mSendToVoicemail;
        }

        public String getCustomRingtone() {
            return this.mCustomRingtone;
        }

        public boolean isUserProfile() {
            return this.mIsUserProfile;
        }

        public boolean isDummy() {
            if (this.mStatus != Status.DUMMY) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static /* synthetic */ Uri access$000(ContactLoader r0) {
        return r0.mLookupUri;
    }

    static /* synthetic */ Uri access$002(ContactLoader r0, Uri r1) {
        r0.mLookupUri = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(ContactLoader r0) {
        return r0.mLoadGroupMetaData;
    }

    static /* synthetic */ Result access$1000(ContactLoader r0) {
        return r0.mContact;
    }

    static /* synthetic */ Result access$1002(ContactLoader r0, Result r1) {
        r0.mContact = r1;
        return r1;
    }

    static /* synthetic */ Loader.ForceLoadContentObserver access$1100(ContactLoader r0) {
        return r0.mObserver;
    }

    static /* synthetic */ Loader.ForceLoadContentObserver access$1102(ContactLoader r0, Loader.ForceLoadContentObserver r1) {
        r0.mObserver = r1;
        return r1;
    }

    static /* synthetic */ void access$1400(ContactLoader r0) {
        r0.postViewNotificationToSyncAdapter();
    }

    static /* synthetic */ boolean access$200(ContactLoader r0) {
        return r0.mLoadStreamItems;
    }

    static /* synthetic */ void access$300(ContactLoader r0, Result r1) {
        r0.computeFormattedPhoneNumbers(r1);
    }

    static /* synthetic */ boolean access$400(ContactLoader r0) {
        return r0.mLoadInvitableAccountTypes;
    }

    static /* synthetic */ Uri access$500(ContactLoader r0) {
        return r0.mRequestedUri;
    }

    static /* synthetic */ void access$800(ContactLoader r0) {
        r0.unregisterObserver();
    }

    static /* synthetic */ boolean access$900(ContactLoader r0) {
        return r0.mDestroyed;
    }

    private void computeFormattedPhoneNumbers(Result r4) {
        Iterator<Entity> r3 = r4.getEntities().iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Iterator<Entity.NamedContentValues> r5 = r3.next().getSubValues().iterator();
    L7:
        if (r5.hasNext() == false) goto L4;
        ContentValues r0 = r5.next().values;
        if ("vnd.android.cursor.item/phone_v2".equals(r0.getAsString("mimetype")) == false) goto L7;
        r0.put("data1", ContactsUtils.formatNumber(r0.getAsString("data1")));
        goto L7
    }

    private void postViewNotificationToSyncAdapter() {
        Context r0 = getContext();
        Iterator<Entity> r1 = this.mContact.getEntities().iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        ContentValues r2 = r1.next().getEntityValues();
        long r3 = r2.getAsLong("_id").longValue();
        if (this.mNotifiedRawContactIds.contains(Long.valueOf(r3)) == true) goto L4;
        this.mNotifiedRawContactIds.add(Long.valueOf(r3));
        String r5 = r2.getAsString("account_type");
        String r4 = r2.getAsString("data_set");
        AccountType r6 = AccountTypeManager.getInstance(r0).getAccountType(r5, r4);
        String r7 = r6.getViewContactNotifyServiceClassName();
        String r8 = r6.resPackageName;
        if (TextUtils.isEmpty(r7) == true) goto L4;
        if (TextUtils.isEmpty(r8) == true) goto L4;
        Uri r9 = ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r3);
        Intent r10 = new Intent();
        r10.setClassName(r8, r7);
        r10.setAction("android.intent.action.VIEW");
        r10.setDataAndType(r9, "vnd.android.cursor.item/raw_contact");
        r0.startService(r10);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error sending message to source-app", e);
        goto L4
    }

    private void unregisterObserver() {
        if (this.mObserver == null) goto L6;
        getContext().getContentResolver().unregisterContentObserver(this.mObserver);
        this.mObserver = null;
        return;
    }

    public ContactLoader(Context r7, Uri r8) {
        this(r7, r8, false, false, false);
    }

    public ContactLoader(Context r1, Uri r2, boolean r3, boolean r4, boolean r5) {
        super(r1);
        this.mNotifiedRawContactIds = Sets.newHashSet();
        this.mLookupUri = r2;
        this.mRequestedUri = r2;
        this.mLoadGroupMetaData = r3;
        this.mLoadStreamItems = r4;
        this.mLoadInvitableAccountTypes = r5;
    }

    public Uri getLookupUri() {
        return this.mLookupUri;
    }

    @Override // androidx.loader.content.Loader
    protected void onStartLoading() {
        Result r0 = this.mContact;
        if (r0 == null) goto L6;
        deliverResult(r0);
    L6:
        if (takeContentChanged() == false) goto L8;
    L9:
        forceLoad();
        return;
    L8:
        if (this.mContact == null) goto L9;
    }

    @Override // androidx.loader.content.Loader
    protected void onForceLoad() {
        AnonymousClass1 r1 = null;
        Void[] r3 = (Void[]) null;     // Catch: RejectedExecutionException -> L5
        new LoadContactTask(this, r1).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "RejectedExecutionException occurred when execute LoadContactTask.\n" + e);
        Void[] r2 = (Void[]) null;
        new LoadContactTask(this, r1).executeOnExecutor(ContactsApplication.getThreadPoolExecutor(), null);
    }

    @Override // androidx.loader.content.Loader
    protected void onReset() {
        unregisterObserver();
        this.mContact = null;
        this.mDestroyed = true;
    }
}
