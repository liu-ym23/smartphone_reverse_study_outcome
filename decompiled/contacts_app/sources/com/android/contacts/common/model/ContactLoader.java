package com.android.contacts.common.model;

import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.GlobalProxyLancet;
import com.android.contacts.ContactSaveService;
import com.android.contacts.common.GeoUtil;
import com.android.contacts.common.GroupMetaData;
import com.android.contacts.common.compat.CompatUtils;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.common.model.account.AccountTypeWithDataSet;
import com.android.contacts.common.model.dataitem.DataItem;
import com.android.contacts.common.model.dataitem.PhoneDataItem;
import com.android.contacts.common.model.dataitem.PhotoDataItem;
import com.android.contacts.common.util.ContactLoaderUtils;
import com.android.contacts.common.util.DataStatus;
import com.android.contacts.common.util.UriUtils;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.util.BytedanceContactContract;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.obric.cloudsdk.kv.base.KvConstant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import obric.widget.search.data.GloableSearchConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ContactLoader extends AsyncTaskLoader<Contact> {
    private static final boolean DEBUG = false;
    private static final String TAG = "ContactLoader";
    private static Contact sCachedResult;
    private boolean mComputeFormattedPhoneNumber;
    private Contact mContact;
    private boolean mLoadGroupMetaData;
    private boolean mLoadInvitableAccountTypes;
    private Uri mLookupUri;
    private final Set<Long> mNotifiedRawContactIds;
    private Loader<Contact>.ForceLoadContentObserver mObserver;
    private boolean mPostViewNotification;
    private final Uri mRequestedUri;

    private static class AccountKey {
        private final String mAccountName;
        private final String mAccountType;
        private final String mDataSet;

        public AccountKey(String r1, String r2, String r3) {
            this.mAccountName = r1;
            this.mAccountType = r2;
            this.mDataSet = r3;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mAccountName, this.mAccountType, this.mDataSet});
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof AccountKey) == true) goto L5;
            return false;
        L5:
            AccountKey r5 = (AccountKey) r4;
            if (Objects.equals(this.mAccountName, r5.mAccountName) == true) goto L8;
            return false;
        L8:
            if (Objects.equals(this.mAccountType, r5.mAccountType) == true) goto L10;
            return false;
        L10:
            if (Objects.equals(this.mDataSet, r5.mDataSet) == false) goto L15;
            return true;
        L15:
            return false;
        }
    }

    private static class ContactQuery {
        public static final int ACCOUNT_NAME = 15;
        public static final int ACCOUNT_TYPE = 16;
        public static final int ALT_DISPLAY_NAME = 4;
        public static final int CARRIER_PRESENCE = 64;
        public static final int CHAT_CAPABILITY = 52;
        static final String[] COLUMNS = null;
        static final String[] COLUMNS_INTERNAL = null;
        public static final int CONTACT_ID = 13;
        public static final int CONTACT_PRESENCE = 8;
        public static final int CONTACT_STATUS = 9;
        public static final int CONTACT_STATUS_LABEL = 12;
        public static final int CONTACT_STATUS_RES_PACKAGE = 11;
        public static final int CONTACT_STATUS_TIMESTAMP = 10;
        public static final int CUSTOM_RINGTONE = 60;
        public static final int DATA1 = 27;
        public static final int DATA10 = 36;
        public static final int DATA11 = 37;
        public static final int DATA12 = 38;
        public static final int DATA13 = 39;
        public static final int DATA14 = 40;
        public static final int DATA15 = 41;
        public static final int DATA2 = 28;
        public static final int DATA3 = 29;
        public static final int DATA4 = 30;
        public static final int DATA5 = 31;
        public static final int DATA6 = 32;
        public static final int DATA7 = 33;
        public static final int DATA8 = 34;
        public static final int DATA9 = 35;
        public static final int DATA_ID = 26;
        public static final int DATA_SET = 17;
        public static final int DATA_SYNC1 = 42;
        public static final int DATA_SYNC2 = 43;
        public static final int DATA_SYNC3 = 44;
        public static final int DATA_SYNC4 = 45;
        public static final int DATA_VERSION = 46;
        public static final int DELETED = 25;
        public static final int DIRTY = 18;
        public static final int DISPLAY_NAME = 3;
        public static final int DISPLAY_NAME_SOURCE = 1;
        public static final int GROUP_SOURCE_ID = 50;
        public static final int IS_PRIMARY = 47;
        public static final int IS_SUPERPRIMARY = 48;
        public static final int IS_USER_PROFILE = 61;
        public static final int LAST_TIME_USED = 63;
        public static final int LOOKUP_KEY = 2;
        public static final int MIMETYPE = 49;
        public static final int NAME_RAW_CONTACT_ID = 0;
        public static final int PHONETIC_NAME = 5;
        public static final int PHOTO_ID = 6;
        public static final int PHOTO_URI = 58;
        public static final int PRESENCE = 51;
        public static final int RAW_CONTACT_ID = 14;
        public static final int SEND_TO_VOICEMAIL = 59;
        public static final int SOURCE_ID = 20;
        public static final int STARRED = 7;
        public static final int STATUS = 53;
        public static final int STATUS_ICON = 55;
        public static final int STATUS_LABEL = 56;
        public static final int STATUS_RES_PACKAGE = 54;
        public static final int STATUS_TIMESTAMP = 57;
        public static final int SYNC1 = 21;
        public static final int SYNC2 = 22;
        public static final int SYNC3 = 23;
        public static final int SYNC4 = 24;
        public static final int TIMES_USED = 62;
        public static final int VERSION = 19;

        private ContactQuery() {
        }

        static {
            String[] r0 = {"name_raw_contact_id", "display_name_source", "lookup", "display_name", "display_name_alt", "phonetic_name", "photo_id", ContactSaveService.EXTRA_STARRED_FLAG, "contact_presence", "contact_status", "contact_status_ts", "contact_status_res_package", "contact_status_label", "contact_id", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "account_name", "account_type", "data_set", "dirty", GloableSearchConfig.KEY_VERSION, "sourceid", "sync1", "sync2", "sync3", "sync4", "deleted", KvConstant.KV_DATA_ID, "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME, BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN, "data14", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, "data_sync1", "data_sync2", "data_sync3", "data_sync4", "data_version", "is_primary", "is_super_primary", "mimetype", "group_sourceid", "mode", "chat_capability", "status", "status_res_package", "status_icon", "status_label", "status_ts", "photo_uri", "send_to_voicemail", "custom_ringtone", "is_user_profile", "times_used", "last_time_used"};
            COLUMNS_INTERNAL = r0;
            ArrayList r1 = Lists.newArrayList(r0);
            if (CompatUtils.isMarshmallowCompatible() == false) goto L5;
            r1.add("carrier_presence");
        L5:
            COLUMNS = (String[]) r1.toArray(new String[r1.size()]);
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
        public static final int AUTO_ADD = 5;
        static final String[] COLUMNS = null;
        public static final int DATA_SET = 2;
        public static final int FAVORITES = 6;
        public static final int ID = 3;
        public static final int TITLE = 4;

        private GroupQuery() {
        }

        static {
            COLUMNS = new String[]{"account_name", "account_type", "data_set", "_id", "title", "auto_add", "favorites"};
        }
    }

    @Override // android.content.Loader
    public /* bridge */ /* synthetic */ void deliverResult(Object r1) {
        deliverResult((Contact) r1);
    }

    @Override // android.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Contact loadInBackground() {
        return loadInBackground();
    }

    static {
        DEBUG = Log.isLoggable("ContactLoader", 3);
        sCachedResult = null;
    }

    public ContactLoader(Context r8, Uri r9, boolean r10) {
        this(r8, r9, false, false, r10, false);
    }

    public ContactLoader(Context r1, Uri r2, boolean r3, boolean r4, boolean r5, boolean r6) {
        super(r1);
        this.mNotifiedRawContactIds = Sets.newHashSet();
        this.mLookupUri = r2;
        this.mRequestedUri = r2;
        this.mLoadGroupMetaData = r3;
        this.mLoadInvitableAccountTypes = r4;
        this.mPostViewNotification = r5;
        this.mComputeFormattedPhoneNumber = r6;
    }

    public void setLookupUri(Uri r1) {
        this.mLookupUri = r1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.content.AsyncTaskLoader
    public Contact loadInBackground() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "loadInBackground=" + this.mLookupUri);
        ContentResolver r0 = getContext().getContentResolver();     // Catch: Exception -> L37
        Uri r1 = ContactLoaderUtils.ensureIsContactUri(r0, this.mLookupUri);     // Catch: Exception -> L37
        Contact r2 = sCachedResult;     // Catch: Exception -> L37
        sCachedResult = null;     // Catch: Exception -> L37
        if (r2 == null) goto L9;
        if (UriUtils.areEqual(r2.getLookupUri(), this.mLookupUri) == false) goto L9;
        Contact r3 = new Contact(this.mRequestedUri, r2);     // Catch: Exception -> L37
        boolean r4 = true;
    L16:
        if (r3.isLoaded() == true) goto L18;
    L36:
        return r3;
    L18:
        if (r3.isDirectoryEntry() == false) goto L22;
        if (r4 == true) goto L27;
        loadDirectoryMetaData(r3);     // Catch: Exception -> L37
    L27:
        if (this.mComputeFormattedPhoneNumber == false) goto L29;
        computeFormattedPhoneNumbers(r3);     // Catch: Exception -> L37
    L29:
        if (r4 == true) goto L32;
        loadPhotoBinaryData(r3);     // Catch: Exception -> L37
    L32:
        if (this.mLoadInvitableAccountTypes == false) goto L36;
        if (r3.getInvitableAccountTypes() != null) goto L36;
        loadInvitableAccountTypes(r3);     // Catch: Exception -> L37
        goto L36
    L22:
        if (this.mLoadGroupMetaData == false) goto L27;
        if (r3.getGroupMetaData() != null) goto L27;
        loadGroupMetaData(r3);     // Catch: Exception -> L37
    L9:
        if (r1.getLastPathSegment() != null) goto L11;
    L13:
        r3 = loadContactEntity(r0, r1);     // Catch: Exception -> L37
    L14:
        r4 = false;
        goto L16
    L11:
        if (r1.getLastPathSegment().equals("encoded") == false) goto L13;
        r3 = loadEncodedContactEntity(r1, this.mLookupUri);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error loading the contact: " + this.mLookupUri, e);
        return Contact.forError(this.mRequestedUri, e);
    }

    public static Contact parseEncodedContactEntity(Uri r0) {
        return loadEncodedContactEntity(r0, r0);
    L4:
        return null;
    }

    private static Contact loadEncodedContactEntity(Uri r25, Uri r26) throws JSONException {
        JSONObject r13 = new JSONObject(r25.getEncodedFragment());
        long r4 = Long.valueOf(r25.getQueryParameter("directory")).longValue();
        String r0 = r13.optString("display_name");
        String r16 = r13.optString("display_name_alt", r0);
        Contact r10 = new Contact(r25, r25, r26, r4, null, -1, -1, r13.getInt("display_name_source"), 0, r13.optString("photo_uri", null), r0, r16, null, false, null, false, null, false);
        r10.setStatuses(new ImmutableMap.Builder().build());
        String r20 = r13.optString("account_name", null);
        String r18 = r25.getQueryParameter("displayName");
        if (r20 == null) goto L5;
        r10.setDirectoryMetaData(r18, null, r20, r13.getString("account_type"), r13.optInt("exportSupport", 1));
    L6:
        ContentValues r1 = new ContentValues();
        r1.put("_id", -1);
        r1.put("contact_id", -1);
        RawContact r3 = new RawContact(r1);
        JSONObject r2 = r13.getJSONObject("vnd.android.cursor.item/contact");
        Iterator<String> r5 = r2.keys();
    L8:
        if (r5.hasNext() == false) goto L16;
        String r6 = r5.next();
        JSONObject r7 = r2.optJSONObject(r6);
        if (r7 == null) goto L11;
        processOneRecord(r3, r7, r6);
        goto L8
    L11:
        JSONArray r8 = r2.getJSONArray(r6);
        int r9 = 0;
    L13:
        if (r9 >= r8.length()) goto L8;
        processOneRecord(r3, r8.getJSONObject(r9), r6);
        r9 = r9 + 1;
        goto L13
    L16:
        r10.setRawContacts(new ImmutableList.Builder().add(r3).build());
        return r10;
    L5:
        r10.setDirectoryMetaData(r18, null, null, null, r13.optInt("exportSupport", 2));
        goto L6
    }

    private static void processOneRecord(RawContact r4, JSONObject r5, String r6) throws JSONException {
        ContentValues r0 = new ContentValues();
        r0.put("mimetype", r6);
        r0.put("_id", -1);
        Iterator<String> r7 = r5.keys();
    L4:
        if (r7.hasNext() == false) goto L11;
        String r1 = r7.next();
        Object r2 = r5.get(r1);
        if ((r2 instanceof String) == true) goto L7;
        if ((r2 instanceof Integer) == false) goto L4;
        r0.put(r1, (Integer) r2);
        goto L4
    L7:
        r0.put(r1, (String) r2);
        goto L4
    L11:
        r4.addDataItemValues(r0);
    }

    private Contact loadContactEntity(ContentResolver r10, Uri r11) {
        if (ContentUris.parseId(r11) > 0) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid contactId in URI: " + r11);
        return Contact.forNotFound(this.mRequestedUri);
    L8:
        Cursor r12 = r10.query(Uri.withAppendedPath(r11, "entities"), ContactQuery.COLUMNS, null, null, GroupSelectionActivity.EXTRA_RAW_CONTACT_ID);
        if (r12 != null) goto L39;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "No cursor returned in loadContactEntity");
        return Contact.forNotFound(this.mRequestedUri);
    L39:
    L33:
        th = move-exception;
        r12.close();
        throw th;
    L13:
        if (r12.moveToFirst() == true) goto L17;
        r12.close();     // Catch: Throwable -> L33
        Contact r9 = Contact.forNotFound(this.mRequestedUri);     // Catch: Throwable -> L33
        r12.close();
        return r9;
    L17:
        Contact r13 = loadContactHeaderData(r12, r11);     // Catch: Throwable -> L33
        ImmutableList.Builder r0 = new ImmutableList.Builder();     // Catch: Throwable -> L33
        ImmutableMap.Builder r1 = new ImmutableMap.Builder();     // Catch: Throwable -> L33
        long r2 = -1;
        RawContact r4 = null;
    L18:
        long r5 = r12.getLong(14);     // Catch: Throwable -> L33
        if (r5 == r2) goto L22;
        RawContact r3 = new RawContact(loadRawContactValues(r12));     // Catch: Throwable -> L33
        r0.add(r3);     // Catch: Throwable -> L33
        r4 = r3;
        r2 = r5;
    L22:
        if (r12.isNull(26) == true) goto L29;
        r4.addDataItemValues(loadDataValues(r12));     // Catch: Throwable -> L33
        if (r12.isNull(51) == true) goto L26;
    L27:
        r1.put(Long.valueOf(r12.getLong(26)), new DataStatus(r12));     // Catch: Throwable -> L33
        goto L29
    L26:
        if (r12.isNull(53) == false) goto L27;
    L29:
        if (r12.moveToNext() == true) goto L18;
        r13.setRawContacts(r0.build());     // Catch: Throwable -> L33
        r13.setStatuses(r1.build());     // Catch: Throwable -> L33
        r12.close();
        return r13;
    L36:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid contactId in URI: " + r11, e);
        return Contact.forNotFound(this.mRequestedUri);
    }

    private void loadPhotoBinaryData(Contact r6) {
        loadThumbnailBinaryData(r6);
        String r0 = r6.getPhotoUri();
        if (r0 != null) goto L30;
    L25:
        r6.setPhotoBinaryData(r6.getThumbnailPhotoBinaryData());
        return;
    L30:
        Uri r1 = Uri.parse(r0);     // Catch: IOException -> L27
        String r2 = r1.getScheme();     // Catch: IOException -> L27
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(r2) == false) goto L7;
    L10:
        InputStream r3 = new URL(r0).openStream();     // Catch: IOException -> L27
        AssetFileDescriptor r5 = null;
    L11:
        byte[] r4 = new byte[16384];     // Catch: IOException -> L27
        ByteArrayOutputStream r7 = new ByteArrayOutputStream();     // Catch: IOException -> L27
    L28:
        int r8 = r3.read(r4);     // Catch: Throwable -> L20
        if (r8 == (-1)) goto L15;
        r7.write(r4, 0, r8);     // Catch: Throwable -> L20
        goto L28
    L15:
        r6.setPhotoBinaryData(r7.toByteArray());     // Catch: Throwable -> L20
        r3.close();     // Catch: IOException -> L27
        if (r5 == null) goto L32;
        r5.close();     // Catch: IOException -> L27
        return;
    L32:
        return;
    L20:
        th = move-exception;
        r3.close();     // Catch: IOException -> L27
        if (r5 == null) goto L24;
        r5.close();     // Catch: IOException -> L27
    L24:
        throw th;     // Catch: IOException -> L27
    L7:
        if ("https".equals(r2) == true) goto L10;
        r5 = getContext().getContentResolver().openAssetFileDescriptor(r1, "r");     // Catch: IOException -> L27
        r3 = r5.createInputStream();     // Catch: IOException -> L27
        goto L11
    }

    private void loadThumbnailBinaryData(Contact r7) {
        long r0 = r7.getPhotoId();
        if (r0 > 0) goto L5;
        return;
    L5:
        UnmodifiableIterator<RawContact> r6 = r7.getRawContacts().iterator();
    L7:
        if (r6.hasNext() == false) goto L17;
        Iterator<DataItem> r2 = r6.next().getDataItems().iterator();
    L10:
        if (r2.hasNext() == false) goto L7;
        DataItem r3 = r2.next();
        if (r3.getId() != r0) goto L10;
        if ((r3 instanceof PhotoDataItem) == false) goto L7;
        r7.setThumbnailPhotoBinaryData(((PhotoDataItem) r3).getPhoto());
        goto L7
    }

    private void loadInvitableAccountTypes(Contact r5) {
        ImmutableList.Builder r0 = new ImmutableList.Builder();
        if (r5.isUserProfile() == true) goto L11;
        Map<AccountTypeWithDataSet, AccountType> r4 = AccountTypeManager.getInstance(getContext()).getUsableInvitableAccountTypes();
        if (r4.isEmpty() == true) goto L11;
        HashMap r6 = Maps.newHashMap(r4);
        UnmodifiableIterator<RawContact> r1 = r5.getRawContacts().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        RawContact r2 = r1.next();
        r6.remove(AccountTypeWithDataSet.get(r2.getAccountTypeString(), r2.getDataSet()));
        goto L8
    L10:
        r0.addAll(r6.values());
    L11:
        r5.setInvitableAccountTypes(r0.build());
    }

    private Contact loadContactHeaderData(Cursor r28, Uri r29) {
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
        String r2 = r28.getString(58);
        if (r28.getInt(7) == 0) goto L9;
        boolean r22 = true;
    L11:
        if (r28.isNull(8) == false) goto L13;
        Integer r3 = null;
    L14:
        Integer r23 = r3;
        if (r28.getInt(59) != 1) goto L17;
        boolean r24 = true;
    L18:
        String r25 = r28.getString(60);
        if (r28.getInt(61) != 1) goto L21;
        boolean r0 = true;
    L23:
        if (r6 != 0) goto L25;
    L28:
        Uri r5 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, r8), r9);
    L30:
        return new Contact(this.mRequestedUri, r29, r5, r6, r8, r9, r11, r13, r14, r2, r17, r18, r19, r22, r23, r24, r25, r0);
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

    private ContentValues loadRawContactValues(Cursor r4) {
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
        cursorColumnToContentValues(r4, r0, 13);
        cursorColumnToContentValues(r4, r0, 7);
        return r0;
    }

    private ContentValues loadDataValues(Cursor r4) {
        ContentValues r0 = new ContentValues();
        r0.put("_id", Long.valueOf(r4.getLong(26)));
        cursorColumnToContentValues(r4, r0, 27);
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
        cursorColumnToContentValues(r4, r0, 52);
        cursorColumnToContentValues(r4, r0, 62);
        cursorColumnToContentValues(r4, r0, 63);
        if (CompatUtils.isMarshmallowCompatible() == false) goto L5;
        cursorColumnToContentValues(r4, r0, 64);
    L5:
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

    private void loadDirectoryMetaData(Contact r11) {
        Cursor r1 = getContext().getContentResolver().query(ContentUris.withAppendedId(ContactsContract.Directory.CONTENT_URI, r11.getDirectoryId()), DirectoryQuery.COLUMNS, null, null, null);
        if (r1 != null) goto L20;
        return;
    L20:
    L17:
        th = move-exception;
        r1.close();
        throw th;
    L6:
        if (r1.moveToFirst() == false) goto L15;
        String r4 = r1.getString(0);     // Catch: Throwable -> L17
        String r2 = r1.getString(1);     // Catch: Throwable -> L17
        int r3 = r1.getInt(2);     // Catch: Throwable -> L17
        String r6 = r1.getString(3);     // Catch: Throwable -> L17
        String r7 = r1.getString(4);     // Catch: Throwable -> L17
        int r8 = r1.getInt(5);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r2) == false) goto L22;
    L13:
        String r10 = null;
    L14:
        r11.setDirectoryMetaData(r4, r10, r6, r7, r8);     // Catch: Throwable -> L17
        goto L15
    L22:
        r10 = getContext().getPackageManager().getResourcesForApplication(r2).getString(r3);     // Catch: PackageManager.NameNotFoundException -> L12 Throwable -> L17
    L12:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Contact directory resource not found: " + r2 + LibrarianImpl.Constants.DOT + r3);     // Catch: Throwable -> L17
    L15:
        r1.close();
    }

    private void loadGroupMetaData(Contact r13) {
        StringBuilder r0 = new StringBuilder();
        ArrayList r1 = new ArrayList();
        HashSet r2 = new HashSet();
        UnmodifiableIterator<RawContact> r3 = r13.getRawContacts().iterator();
    L4:
        if (r3.hasNext() == false) goto L18;
        RawContact r4 = r3.next();
        String r5 = r4.getAccountName();
        String r6 = r4.getAccountTypeString();
        String r7 = r4.getDataSet();
        AccountKey r8 = new AccountKey(r5, r6, r7);
        if (r5 == null) goto L4;
        if (r6 == null) goto L4;
        if (r2.contains(r8) == true) goto L4;
        r2.add(r8);
        if (r0.length() == 0) goto L13;
        r0.append(" OR ");
    L13:
        r0.append("(account_name=? AND account_type=?");
        r1.add(r5);
        r1.add(r6);
        if (r7 == null) goto L16;
        r0.append(" AND data_set=?");
        r1.add(r7);
    L17:
        r0.append(")");
        goto L4
    L16:
        r0.append(" AND data_set IS NULL");
        goto L17
    L18:
        ImmutableList.Builder r9 = new ImmutableList.Builder();
        Cursor r10 = getContext().getContentResolver().query(ContactsContract.Groups.CONTENT_URI, GroupQuery.COLUMNS, r0.toString(), (String[]) r1.toArray(new String[0]), null);
        if (r10 != null) goto L42;
    L40:
        r13.setGroupMetaData(r9.build());
        return;
    L42:
        if (r10.moveToNext() == false) goto L36;
        String r11 = r10.getString(0);     // Catch: Throwable -> L37
        String r12 = r10.getString(1);     // Catch: Throwable -> L37
        String r14 = r10.getString(2);     // Catch: Throwable -> L37
        long r15 = r10.getLong(3);     // Catch: Throwable -> L37
        String r16 = r10.getString(4);     // Catch: Throwable -> L37
        if (r10.isNull(5) == false) goto L26;
    L24:
        boolean r17 = false;
    L29:
        if (r10.isNull(6) == false) goto L32;
    L30:
        boolean r18 = false;
    L34:
        r9.add(new GroupMetaData(r11, r12, r14, r15, r16, r17, r18));     // Catch: Throwable -> L37
        goto L42
    L32:
        if (r10.getInt(6) == 0) goto L30;
        r18 = true;
        goto L34
    L26:
        if (r10.getInt(5) == 0) goto L24;
        r17 = true;
        goto L29
    L36:
        r10.close();
    L37:
        th = move-exception;
        r10.close();
        throw th;
    }

    private void computeFormattedPhoneNumbers(Contact r9) {
        String r8 = GeoUtil.getCurrentCountryIso(getContext());
        ImmutableList<RawContact> r10 = r9.getRawContacts();
        int r0 = r10.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        List<DataItem> r3 = r10.get(r2).getDataItems();
        int r4 = r3.size();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L10;
        DataItem r6 = r3.get(r5);
        if ((r6 instanceof PhoneDataItem) == false) goto L9;
        ((PhoneDataItem) r6).computeFormattedPhoneNumber(r8);
    L9:
        r5 = r5 + 1;
        goto L5
    L10:
        r2 = r2 + 1;
        goto L3
    }

    public void deliverResult(Contact r4) {
        unregisterObserver();
        if (isReset() == true) goto L19;
        if (r4 == null) goto L20;
        this.mContact = r4;
        if (r4.isLoaded() == false) goto L17;
        this.mLookupUri = r4.getLookupUri();
        if (r4.isDirectoryEntry() == true) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Registering content observer for " + this.mLookupUri);
        if (this.mObserver != null) goto L13;
        this.mObserver = new Loader.ForceLoadContentObserver(this);
    L13:
        getContext().getContentResolver().registerContentObserver(this.mLookupUri, true, this.mObserver);
    L15:
        if (this.mPostViewNotification == false) goto L17;
        postViewNotificationToSyncAdapter();
    L17:
        super.deliverResult(this.mContact);
        return;
    L20:
        return;
    }

    private void postViewNotificationToSyncAdapter() {
        Context r0 = getContext();
        UnmodifiableIterator<RawContact> r1 = this.mContact.getRawContacts().iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        RawContact r2 = r1.next();
        long r3 = r2.getId().longValue();
        if (this.mNotifiedRawContactIds.contains(Long.valueOf(r3)) == true) goto L4;
        this.mNotifiedRawContactIds.add(Long.valueOf(r3));
        AccountType r4 = r2.getAccountType(r0);
        String r5 = r4.getViewContactNotifyServiceClassName();
        String r6 = r4.getViewContactNotifyServicePackageName();
        if (TextUtils.isEmpty(r5) == true) goto L4;
        if (TextUtils.isEmpty(r6) == true) goto L4;
        Uri r7 = ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r3);
        Intent r8 = new Intent();
        r8.setClassName(r6, r5);
        r8.setAction("android.intent.action.VIEW");
        r8.setDataAndType(r7, "vnd.android.cursor.item/raw_contact");
        r0.startService(r8);     // Catch: Exception -> L15
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

    public void upgradeToFullContact() {
        if (this.mLoadGroupMetaData == true) goto L5;
    L11:
        this.mLoadGroupMetaData = true;
        this.mLoadInvitableAccountTypes = true;
        this.mPostViewNotification = true;
        this.mComputeFormattedPhoneNumber = true;
        cacheResult();
        onContentChanged();
        return;
    L5:
        if (this.mLoadInvitableAccountTypes == false) goto L11;
        if (this.mPostViewNotification == false) goto L11;
        if (this.mComputeFormattedPhoneNumber == false) goto L11;
    }

    public Uri getLookupUri() {
        return this.mLookupUri;
    }

    @Override // android.content.Loader
    protected void onStartLoading() {
        Contact r0 = this.mContact;
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

    @Override // android.content.Loader
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override // android.content.Loader
    protected void onReset() {
        super.onReset();
        cancelLoad();
        unregisterObserver();
        this.mContact = null;
    }

    public void cacheResult() {
        Contact r0 = this.mContact;
        if (r0 != null) goto L5;
    L8:
        sCachedResult = null;
        return;
    L5:
        if (r0.isLoaded() == false) goto L8;
        sCachedResult = this.mContact;
    }
}
