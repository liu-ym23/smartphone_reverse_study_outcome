package com.android.contacts.obricsync;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.ContactSaveService;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.interactions.GroupDeletionDialogFragment;
import com.android.contacts.obricsync.contact.ContactParamList;
import com.android.contacts.obricsync.contact.ContactType;
import com.android.contacts.util.BlackListQueryHandler;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.obric.cloudsdk.kv.base.KvSyncManager;
import com.obric.cloudsdk.kv.room.model.DataSyncStateModel;
import com.obric.contactsdk.loader.ContactEntityUtilKt;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.ContactsSyncUploadFieldEvent;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LocalToSyncUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tJ&\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0018\u001a\u00020\u0016H\u0007J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0002J=\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001b\u001a\u00020\u00162\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001dH\u0000¢\u0006\u0002\b\u001eJ(\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0018\u001a\u00020\u0016H\u0007J<\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010%2\b\u0010)\u001a\u0004\u0018\u00010%H\u0007J8\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020,0+2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016J-\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020,0+2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020,0/H\u0000¢\u0006\u0002\b0J \u00101\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u00102\u001a\u00020\tH\u0007¨\u00063"}, d2 = {"Lcom/android/contacts/obricsync/LocalToSyncUtils;", "", "()V", "cleanOrphanedSyncRecords", "", "context", "Landroid/content/Context;", "contactIds", "", "", "createTabLocal2Sync", "delete2Sync", "ids", "getAllSyncIds", ContactSaveService.EXTRA_CONTACT_ID, "getPhotoValue", "", "uri", "Landroid/net/Uri;", "getSyncId", "id", "hasContact", "", "insert2Sync", "useRawId", "isContactExists", "selectContactIdsForSync", "isInsert", "syncIdLookup", "Lkotlin/Function1;", "selectContactIdsForSync$app_QssiCnRelease", "update2Sync", "updateList", "Ljava/util/ArrayList;", "Lcom/android/contacts/obricsync/contact/ContactType;", "Lkotlin/collections/ArrayList;", "value", "", "type", "", GroupDeletionDialogFragment.ARG_LABEL, "str", "updateLocalToSync", "", "Landroid/content/ContentValues;", "updateMap", "contactsMap", "", "updateMap$app_QssiCnRelease", "updateSnapshot2Sync", ContactSaveService.EXTRA_DATA_ID, "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocalToSyncUtils {
    public static final LocalToSyncUtils INSTANCE = null;

    static {
        INSTANCE = new LocalToSyncUtils();
    }

    @JvmStatic
    public static final void update2Sync(Context r3, List<Long> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "ids");
        update2Sync$default(r3, r4, false, 4, null);
    }

    private LocalToSyncUtils() {
    }

    @JvmStatic
    public static final void insert2Sync(Context r13, List<Long> r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "ids");
        Map<Long, ContentValues> r16 = INSTANCE.updateLocalToSync(r13, r14, r15, true);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "insert2Sync#data: " + r14 + ", map = " + r16.size());
        Iterator<T> r17 = r16.values().iterator();
    L4:
        if (r17.hasNext() == false) goto L15;
        ContentValues r18 = (ContentValues) r17.next();
        Uri r1 = r13.getContentResolver().insert(SyncContractKt.getContactSyncUri(), r18);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "insert2Sync#data insertUri: " + r1);
        if (r1 == null) goto L4;
        long r8 = ContentUris.parseId(r1);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "insert2Sync#data insertId: " + r8);
        if (r8 <= (-1)) goto L4;
        KvSyncManager.INSTANCE.setInserted(r8, SyncContractKt.TAB_NAME_SYNC);
        List<DataSyncStateModel> r2 = KvSyncManager.INSTANCE.getByDataIdAndTableName(r8, SyncContractKt.TAB_NAME_SYNC);
        if (r2 == null) goto L4;
        Iterator<T> r10 = r2.iterator();
    L13:
        if (r10.hasNext() == false) goto L4;
        String r3 = ((DataSyncStateModel) r10.next()).getSyncId();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "insert2Sync#id: " + r8 + " , sync_Id = " + r3);
        EventTrackerManager.INSTANCE.track(new ContactsSyncUploadFieldEvent(ContactsSyncUploadFieldEvent.Action.INSERT, r3, r18, null, 8, null));
        goto L13
    }

    @JvmStatic
    public static final void delete2Sync(Context r21, List<Long> r22) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "ids");
        ArrayList r2 = new ArrayList();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "delete2Sync#ids: " + r22);
        Iterator<T> r3 = r22.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        long r5 = ((Number) r3.next()).longValue();
        List<Long> r7 = getAllSyncIds(r21, r5);
        List<Long> r8 = r7;
        if ((!r8.isEmpty()) == false) goto L8;
        r2.addAll(r8);
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "delete2Sync#id: " + r5 + ", syncIds: " + r7);
        goto L4
    L10:
        if ((!r2.isEmpty()) == false) goto L31;
        ArrayList r4 = r2;
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r4, 10)), 16));
        Iterator r9 = r4.iterator();
    L12:
        String r14 = "";
        String r13 = null;
        if (r9.hasNext() == false) goto L23;
        Object r10 = r9.next();
        LinkedHashMap r11 = r6;
        List<DataSyncStateModel> r12 = KvSyncManager.INSTANCE.getByDataIdAndTableName(((Number) r10).longValue(), SyncContractKt.TAB_NAME_SYNC);
        if (r12 == null) goto L19;
        DataSyncStateModel r15 = (DataSyncStateModel) CollectionsKt.firstOrNull(r12);
        if (r15 == null) goto L19;
        r13 = r15.getSyncId();
    L19:
        if (r13 == null) goto L22;
        r14 = r13;
    L22:
        r11.put(r10, r14);
        goto L12
    L23:
        LinkedHashMap r20 = r6;
        r21.getContentResolver().delete(SyncContractKt.getContactSyncUri(), "_id IN (" + CollectionsKt.joinToString$default(r4, SimContactsConstants.EMAIL_SEP, null, null, 0, null, null, 62, null) + ')', null);
        KvSyncManager.INSTANCE.setDeleted(r2, SyncContractKt.TAB_NAME_SYNC);
        Iterator r16 = r4.iterator();
    L25:
        if (r16.hasNext() == false) goto L31;
        long r17 = ((Number) r16.next()).longValue();
        LinkedHashMap r18 = r20;
        String r19 = (String) r18.get(Long.valueOf(r17));
        if (r19 != null) goto L29;
        String r110 = "";
    L30:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "delete2Sync#dataId: " + r17 + " , sync_Id = " + r110);
        EventTrackerManager.INSTANCE.track(new ContactsSyncUploadFieldEvent(ContactsSyncUploadFieldEvent.Action.DELETE, r110, new ContentValues(), null, 8, null));
        r20 = r18;
        goto L25
    L29:
        r110 = r19;
    L31:
        INSTANCE.cleanOrphanedSyncRecords(r21, r22);
    }

    public static /* synthetic */ void update2Sync$default(Context r0, List r1, boolean r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = true;
    L5:
        update2Sync(r0, r1, r2);
    }

    @JvmStatic
    public static final void update2Sync(Context r22, List<Long> r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "ids");
        Map<Long, ContentValues> r2 = INSTANCE.updateLocalToSync(r22, r23, r24, false);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "update2Sync#ids: " + r23 + " , map = " + r2.size());
        Iterator<T> r1 = r2.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L19;
        long r5 = ((Number) r1.next()).longValue();
        ContentValues r7 = r2.get(Long.valueOf(r5));
        if (r7 == null) goto L4;
        long r14 = INSTANCE.getSyncId(r22, r5);
        String r13 = "update2Sync#id: ";
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "update2Sync#id: " + r5 + " , syncId = " + r14);
        if (r14 == (-1)) goto L10;
        int r8 = r22.getContentResolver().update(SyncContractKt.getContactSyncUri(), r7, "contact_id = ?", new String[]{String.valueOf(r5)});
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "update2Sync#id: " + r5 + " , updateId = " + r8);
        if (r8 <= 0) goto L4;
        KvSyncManager.INSTANCE.setUpdated(r14, SyncContractKt.TAB_NAME_SYNC);
        List<DataSyncStateModel> r6 = KvSyncManager.INSTANCE.getByDataIdAndTableName(r14, SyncContractKt.TAB_NAME_SYNC);
        if (r6 == null) goto L4;
        Iterator<T> r9 = r6.iterator();
    L17:
        if (r9.hasNext() == false) goto L4;
        String r10 = ((DataSyncStateModel) r9.next()).getSyncId();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, r13 + r14 + " , sync_Id = " + r10);
        EventTrackerManager.INSTANCE.track(new ContactsSyncUploadFieldEvent(ContactsSyncUploadFieldEvent.Action.UPDATE, r10, r7, null, 8, null));
        r13 = r13;
        r14 = r14;
        goto L17
    L10:
        insert2Sync(r22, CollectionsKt.listOf(Long.valueOf(r5)), false);
        goto L4
    }

    @JvmStatic
    public static final boolean updateSnapshot2Sync(Context r11, long r12, long r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        ContentValues r0 = INSTANCE.updateLocalToSync(r11, CollectionsKt.listOf(Long.valueOf(r12)), false, false).get(Long.valueOf(r12));
        if (r0 != null) goto L5;
        return false;
    L5:
        int r13 = r11.getContentResolver().update(SyncContractKt.getContactSyncUri(), r0, "_id = ?", new String[]{String.valueOf(r14)});
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "updateSnapshot2Sync#contactId: " + r12 + ", dataId: " + r14 + ", updateId = " + r13);
        if (r13 > 0) goto L8;
        return false;
    L8:
        KvSyncManager.INSTANCE.setUpdated(r14, SyncContractKt.TAB_NAME_SYNC);
        List<DataSyncStateModel> r15 = KvSyncManager.INSTANCE.getByDataIdAndTableName(r14, SyncContractKt.TAB_NAME_SYNC);
        if (r15 == null) goto L14;
        Iterator<T> r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        EventTrackerManager.INSTANCE.track(new ContactsSyncUploadFieldEvent(ContactsSyncUploadFieldEvent.Action.UPDATE, ((DataSyncStateModel) r16.next()).getSyncId(), r0, null, 8, null));
    L14:
        return true;
    }

    @JvmStatic
    public static final void createTabLocal2Sync(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Cursor r1 = r7.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"name_raw_contact_id"}, null, null, null);
        ArrayList r2 = new ArrayList();
        if (r1 == null) goto L18;
        Cursor r3 = r1;
        Cursor r4 = r3;     // Catch: Throwable -> L13
    L7:
        if (r1.moveToNext() == false) goto L11;
        long r5 = r1.getLong(r1.getColumnIndexOrThrow("name_raw_contact_id"));     // Catch: Throwable -> L13
        if (r2.contains(Long.valueOf(r5)) == true) goto L7;
        r2.add(Long.valueOf(r5));     // Catch: Throwable -> L13
        goto L7
    L11:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r3, null);
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L18:
        insert2Sync(r7, r2, true);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "createTabLocal2Sync");
    }

    public final long getSyncId(Context r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Cursor r6 = r7.getContentResolver().query(SyncContractKt.getContactSyncUri(), new String[]{"MIN(_id)"}, "contact_id = ?", new String[]{String.valueOf(r8)}, null);
        if (r6 == null) goto L19;
        Cursor r9 = r6;
        Cursor r10 = r9;     // Catch: Throwable -> L14
        if (r10.moveToFirst() == true) goto L8;
    L12:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r9, null);
        return -1;
    L8:
        if (r10.isNull(0) == true) goto L12;
        long r12 = r10.getLong(0);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r9, null);
        return r12;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L19:
        return -1;
    }

    @JvmStatic
    public static final List<Long> getAllSyncIds(Context r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        ArrayList r0 = new ArrayList();
        Cursor r9 = r7.getContentResolver().query(SyncContractKt.getContactSyncUri(), new String[]{"_id"}, "contact_id = ?", new String[]{String.valueOf(r8)}, null);
        if (r9 == null) goto L16;
        Cursor r10 = r9;
        Cursor r11 = r10;     // Catch: Throwable -> L11
    L7:
        if (r11.moveToNext() == false) goto L9;
        r0.add(Long.valueOf(r11.getLong(r11.getColumnIndexOrThrow("_id"))));     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r10, null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L16:
        return r0;
    }

    private final void cleanOrphanedSyncRecords(Context r22, List<Long> r23) {
        if (r23.isEmpty() == false) goto L5;
        return;
    L5:
        Cursor r0 = r22.getContentResolver().query(SyncContractKt.getContactSyncUri(), new String[]{"contact_id", "_id"}, "contact_id IN (" + CollectionsKt.joinToString$default(r23, SimContactsConstants.EMAIL_SEP, null, null, 0, null, null, 62, null) + ')', null, null);
        ArrayList r1 = new ArrayList();
        if (r0 == null) goto L24;
        Cursor r3 = r0;
        Cursor r2 = r3;     // Catch: Throwable -> L16
    L10:
        if (r2.moveToNext() == false) goto L14;
        if (INSTANCE.isContactExists(r22, r2.getLong(r2.getColumnIndexOrThrow("contact_id"))) == true) goto L10;
        r1.add(Long.valueOf(r2.getLong(r2.getColumnIndexOrThrow("_id"))));     // Catch: Throwable -> L16
        goto L10
    L14:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r3, null);
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L24:
        if ((!r1.isEmpty()) == false) goto L36;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "cleanOrphanedSyncRecords: deleted " + r22.getContentResolver().delete(SyncContractKt.getContactSyncUri(), "_id IN (" + CollectionsKt.joinToString$default(r1, SimContactsConstants.EMAIL_SEP, null, null, 0, null, null, 62, null) + ')', null) + " orphaned records");
        KvSyncManager.INSTANCE.setDeleted(r1, SyncContractKt.TAB_NAME_SYNC);
        return;
    }

    private final boolean isContactExists(Context r7, long r8) {
        Cursor r6 = r7.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"_id"}, "_id = ?", new String[]{String.valueOf(r8)}, null);
        if (r6 == null) goto L13;
        Cursor r9 = r6;
        boolean r10 = r9.moveToFirst();     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r9, null);
        return r10;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L13:
        return false;
    }

    public final Map<Long, ContentValues> updateLocalToSync(final Context r35, List<Long> r36, boolean r37, final boolean r38) {
        String r7 = SyncContractKt.COLUMN_NICK_NAME;
        String r8 = SyncContractKt.COLUMN_NOTE;
        String r9 = SyncContractKt.COLUMN_COMPANY;
        String r14 = SyncContractKt.COLUMN_ID_CARDS;
        String r16 = SyncContractKt.COLUMN_GENDER;
        String r4 = "phone_number";
        String r17 = SyncContractKt.COLUMN_RELATION;
        Intrinsics.checkNotNullParameter(r35, "context");
        Intrinsics.checkNotNullParameter(r36, "ids");
        ContentResolver r10 = r35.getContentResolver();
        String r24 = SyncContractKt.COLUMN_INTER_ADDRESS;
        Intrinsics.checkNotNullExpressionValue(r10, "contentResolver");
        List<Long> r2 = selectContactIdsForSync$app_QssiCnRelease(ContactEntityUtilKt.updateRawId2ContactsIdIdsList(r10, r36, r37), r38, new LocalToSyncUtils$updateLocalToSync$list$1(r35, r38));
        if (r2.isEmpty() == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "updateLocalToSync#idsListString return empty");
        return MapsKt.emptyMap();
    L6:
        String r3 = CollectionsKt.joinToString$default(r2, SimContactsConstants.EMAIL_SEP, "(", ")", 0, null, null, 56, null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "updateLocalToSync#idsListString: " + r3);
        LinkedHashMap r0 = new LinkedHashMap();
        Uri r19 = ContactsContract.Contacts.CONTENT_URI;
        String r5 = "_id";
        String r25 = SyncContractKt.COLUMN_ADDRESS;
        String r11 = "photo_uri";
        Cursor r6 = r10.query(r19, new String[]{"_id", "photo_uri", "contact_last_updated_timestamp"}, "_id IN " + r3, null, null);
        String r26 = SyncContractKt.COLUMN_BIRTHDAY;
        String r27 = SyncContractKt.COLUMN_WEBSITE;
        String r28 = SyncContractKt.COLUMN_IM;
        if (r6 == null) goto L28;
        Cursor r12 = r6;
        Cursor r13 = r12;     // Catch: Throwable -> L22
    L11:
        if (r13.moveToNext() == false) goto L20;
        String r29 = r14;
        ContentValues r15 = new ContentValues();     // Catch: Throwable -> L22
        String r30 = r7;
        long r18 = r13.getLong(r13.getColumnIndexOrThrow(r5));     // Catch: Throwable -> L22
        String r20 = r13.getString(r13.getColumnIndexOrThrow(r11));     // Catch: Throwable -> L22
        String r39 = r5;
        LocalToSyncUtils r21 = INSTANCE;     // Catch: Throwable -> L22
        if (r20 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r20, "photoUri");     // Catch: Throwable -> L22
        Uri r22 = Uri.parse(r20);     // Catch: Throwable -> L22
    L16:
        byte[] r23 = r21.getPhotoValue(r35, r22);     // Catch: Throwable -> L22
        r15.put("contact_id", Long.valueOf(r18));     // Catch: Throwable -> L22
        if (r23 == null) goto L19;
        r15.put(SyncContractKt.COLUMN_AVATAR, r23);     // Catch: Throwable -> L22
    L19:
        r0.put(Long.valueOf(r18), r15);     // Catch: Throwable -> L22
        r5 = r39;
        r11 = r11;
        r14 = r29;
        r7 = r30;
        goto L11
    L15:
        r22 = null;
        goto L16
    L20:
        String r31 = r7;
        String r210 = r14;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r12, null);
    L29:
        Cursor r32 = r10.query(ContactsContract.Data.CONTENT_URI, SyncContractKt.getCONTACT_DATA_PROJECTION(), "contact_id IN " + r3, null, null);
        if (r32 == null) goto L99;
        Cursor r33 = r32;
        Cursor r34 = r33;     // Catch: Throwable -> L92
    L34:
        if (r34.moveToNext() == false) goto L90;
        ContentValues r40 = r0.get(Long.valueOf(r34.getLong(r34.getColumnIndexOrThrow("contact_id"))));     // Catch: Throwable -> L92
        String r41 = r34.getString(r34.getColumnIndexOrThrow("mimetype"));     // Catch: Throwable -> L92
        String r42 = r34.getString(r34.getColumnIndexOrThrow("data1"));     // Catch: Throwable -> L92
        if (r40 == null) goto L34;
        if (r42 != null) goto L39;
        String r110 = r4;
        String r111 = r8;
        String r211 = r9;
        String r43 = r16;
        String r112 = r17;
        String r113 = r210;
        String r114 = r31;
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_AVATAR)) == false) goto L89;
        byte[] r44 = r34.getBlob(r34.getColumnIndexOrThrow(SyncContractKt.getContactValueColumnName().get(r41)));     // Catch: Throwable -> L92
        if (r44 == null) goto L89;
        Intrinsics.checkNotNullExpressionValue(r44, BlackListQueryHandler.KEY_PHOTO);     // Catch: Throwable -> L92
        r40.put(SyncContractKt.COLUMN_AVATAR, r44);     // Catch: Throwable -> L92
    L89:
        r16 = r43;
        r17 = r112;
        r31 = r114;
        r210 = r113;
        r4 = r110;
        r8 = r111;
        r9 = r211;
        goto L34
    L39:
        if (Intrinsics.areEqual(r41, "vnd.android.cursor.item/name") == false) goto L42;
        String r45 = r34.getString(r34.getColumnIndexOrThrow(DBHelper.COL_DATA3));     // Catch: Throwable -> L92
        String r115 = r34.getString(r34.getColumnIndexOrThrow(DBHelper.COL_DATA2));     // Catch: Throwable -> L92
        r40.put("name", r42);     // Catch: Throwable -> L92
        r40.put(SyncContractKt.COLUMN_FIRST_NAME, r45);     // Catch: Throwable -> L92
        r40.put(SyncContractKt.COLUMN_LAST_NAME, r115);     // Catch: Throwable -> L92
    L44:
        r110 = r4;
        r111 = r8;
        r211 = r9;
        r43 = r16;
        r112 = r17;
        r113 = r210;
        r114 = r31;
        goto L89
    L42:
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r9)) == false) goto L46;
        r40.put(r9, r42);     // Catch: Throwable -> L92
        goto L44
    L46:
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r8)) == false) goto L49;
        r40.put(r8, r42);     // Catch: Throwable -> L92
        goto L44
    L49:
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r4)) == false) goto L52;
        String r116 = r40.getAsString(r4);     // Catch: Throwable -> L92
        r40.put(r4, new Gson().toJson(new ContactParamList(updateList(r42, r34.getInt(r34.getColumnIndexOrThrow(SyncContractKt.getContactTypeColumnName().get(r41))), r34.getString(r34.getColumnIndexOrThrow(SyncContractKt.getContactLabelColumnName().get(r41))), r116))));     // Catch: Throwable -> L92
        goto L44
    L52:
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get("email")) == false) goto L54;
        String r117 = r40.getAsString("email");     // Catch: Throwable -> L92
        r40.put("email", new Gson().toJson(new ContactParamList(updateList(r42, r34.getInt(r34.getColumnIndexOrThrow(SyncContractKt.getContactTypeColumnName().get(r41))), r34.getString(r34.getColumnIndexOrThrow(SyncContractKt.getContactLabelColumnName().get(r41))), r117))));     // Catch: Throwable -> L92
        goto L44
    L54:
        r114 = r31;
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r114)) == false) goto L57;
        r40.put(r114, r42);     // Catch: Throwable -> L92
        r110 = r4;
        r111 = r8;
        r211 = r9;
        r43 = r16;
        r112 = r17;
        r113 = r210;
        goto L89
    L57:
        r113 = r210;
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r113)) == false) goto L60;
        String r118 = r40.getAsString(r113);     // Catch: Throwable -> L92
        r110 = r4;
        r111 = r8;
        r40.put(r113, new Gson().toJson(new ContactParamList(updateList(r42, r34.getInt(r34.getColumnIndexOrThrow(SyncContractKt.getContactTypeColumnName().get(r41))), null, r118))));     // Catch: Throwable -> L92
        r211 = r9;
    L66:
        r43 = r16;
        r112 = r17;
        goto L89
    L60:
        r110 = r4;
        r111 = r8;
        String r46 = r28;
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r46)) == false) goto L63;
        String r47 = r40.getAsString(r46);     // Catch: Throwable -> L92
        r211 = r9;
        r40.put(r46, new Gson().toJson(new ContactParamList(updateList(r42, r34.getInt(r34.getColumnIndexOrThrow(SyncContractKt.getContactTypeColumnName().get(r41))), r34.getString(r34.getColumnIndexOrThrow(SyncContractKt.getContactLabelColumnName().get(r41))), r47))));     // Catch: Throwable -> L92
        r28 = r46;
        goto L66
    L63:
        r211 = r9;
        String r48 = r27;
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r48)) == false) goto L67;
        r40.put(r48, r42);     // Catch: Throwable -> L92
        r28 = r46;
        r27 = r48;
        goto L66
    L67:
        String r119 = r26;
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r119)) == false) goto L70;
        String r49 = r40.getAsString(r119);     // Catch: Throwable -> L92
        r28 = r46;
        r27 = r48;
        r40.put(r119, new Gson().toJson(new ContactParamList(updateList(r42, r34.getInt(r34.getColumnIndexOrThrow(SyncContractKt.getContactTypeColumnName().get(r41))), r34.getString(r34.getColumnIndexOrThrow(SyncContractKt.getContactLabelColumnName().get(r41))), r49))));     // Catch: Throwable -> L92
        r26 = r119;
        goto L66
    L70:
        r28 = r46;
        r27 = r48;
        String r50 = r25;
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r50)) == false) goto L73;
        String r51 = r40.getAsString(r50);     // Catch: Throwable -> L92
        r26 = r119;
        r40.put(r50, new Gson().toJson(new ContactParamList(updateList(r42, r34.getInt(r34.getColumnIndexOrThrow(SyncContractKt.getContactTypeColumnName().get(r41))), r34.getString(r34.getColumnIndexOrThrow(SyncContractKt.getContactLabelColumnName().get(r41))), r51))));     // Catch: Throwable -> L92
        r25 = r50;
        goto L66
    L73:
        r26 = r119;
        String r52 = r24;
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r52)) == false) goto L76;
        r40.put(r52, r42);     // Catch: Throwable -> L92
        r25 = r50;
        r24 = r52;
        goto L66
    L76:
        r112 = r17;
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r112)) == false) goto L79;
        String r53 = r40.getAsString(r112);     // Catch: Throwable -> L92
        r25 = r50;
        r24 = r52;
        r40.put(r112, new Gson().toJson(new ContactParamList(updateList(r42, r34.getInt(r34.getColumnIndexOrThrow(SyncContractKt.getContactTypeColumnName().get(r41))), r34.getString(r34.getColumnIndexOrThrow(SyncContractKt.getContactLabelColumnName().get(r41))), r53))));     // Catch: Throwable -> L92
        r43 = r16;
        goto L89
    L79:
        r25 = r50;
        r24 = r52;
        r43 = r16;
        if (Intrinsics.areEqual(r41, SyncContractKt.getContactMap().get(r43)) == false) goto L89;
        int r54 = Integer.parseInt(r42);     // Catch: Throwable -> L92
        if (r54 < 0) goto L89;
        r40.put(r43, Integer.valueOf(r54));     // Catch: Throwable -> L92
        goto L89
    L90:
        Unit r55 = Unit.INSTANCE;     // Catch: Throwable -> L92
        CloseableKt.closeFinally(r33, null);
    L92:
        th = move-exception;
        throw th;     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        CloseableKt.closeFinally(r33, th);
        throw th;
    L99:
        return updateMap$app_QssiCnRelease(r0);
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L28:
        r31 = SyncContractKt.COLUMN_NICK_NAME;
        r210 = SyncContractKt.COLUMN_ID_CARDS;
        goto L29
    }

    public final List<Long> selectContactIdsForSync$app_QssiCnRelease(List<Long> r5, boolean r6, Function1<? super Long, Long> r7) {
        Intrinsics.checkNotNullParameter(r5, "contactIds");
        Intrinsics.checkNotNullParameter(r7, "syncIdLookup");
        if (r6 == true) goto L5;
        return r5;
    L5:
        ArrayList r4 = new ArrayList();
        Iterator<T> r8 = r5.iterator();
    L7:
        if (r8.hasNext() == false) goto L15;
        Object r9 = r8.next();
        if (r7.invoke(Long.valueOf(((Number) r9).longValue())).longValue() != (-1)) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L7;
        r4.add(r9);
        goto L7
    L11:
        r0 = false;
        goto L12
    L15:
        return r4;
    }

    public final Map<Long, ContentValues> updateMap$app_QssiCnRelease(Map<Long, ContentValues> r11) {
        Intrinsics.checkNotNullParameter(r11, "contactsMap");
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<T> r0 = r11.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L108;
        long r1 = ((Number) r0.next()).longValue();
        ContentValues r3 = r11.get(Long.valueOf(r1));
        ContentValues r4 = new ContentValues();
        String r6 = null;
        if (r3 == null) goto L8;
        String r7 = r3.getAsString("name");
    L9:
        String r8 = "";
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        r4.put("name", r7);
        if (r3 == null) goto L15;
        String r9 = r3.getAsString(SyncContractKt.COLUMN_FIRST_NAME);
    L16:
        if (r9 != null) goto L18;
        r9 = "";
    L18:
        r4.put(SyncContractKt.COLUMN_FIRST_NAME, r9);
        if (r3 == null) goto L21;
        String r12 = r3.getAsString(SyncContractKt.COLUMN_LAST_NAME);
    L22:
        if (r12 != null) goto L24;
        r12 = "";
    L24:
        r4.put(SyncContractKt.COLUMN_LAST_NAME, r12);
        if (r3 == null) goto L27;
        String r13 = r3.getAsString(SyncContractKt.COLUMN_COMPANY);
    L28:
        if (r13 != null) goto L30;
        r13 = "";
    L30:
        r4.put(SyncContractKt.COLUMN_COMPANY, r13);
        if (r3 == null) goto L33;
        String r14 = r3.getAsString(SyncContractKt.COLUMN_ADDRESS);
    L34:
        if (r14 != null) goto L36;
        r14 = "";
    L36:
        r4.put(SyncContractKt.COLUMN_ADDRESS, r14);
        if (r3 == null) goto L39;
        String r15 = r3.getAsString("phone_number");
    L40:
        if (r15 != null) goto L42;
        r15 = "";
    L42:
        r4.put("phone_number", r15);
        if (r3 == null) goto L45;
        String r16 = r3.getAsString(SyncContractKt.COLUMN_ID_CARDS);
    L46:
        if (r16 != null) goto L48;
        r16 = "";
    L48:
        r4.put(SyncContractKt.COLUMN_ID_CARDS, r16);
        if (r3 == null) goto L51;
        String r17 = r3.getAsString("email");
    L52:
        if (r17 != null) goto L54;
        r17 = "";
    L54:
        r4.put("email", r17);
        if (r3 == null) goto L57;
        byte[] r18 = r3.getAsByteArray(SyncContractKt.COLUMN_AVATAR);
    L58:
        r4.put(SyncContractKt.COLUMN_AVATAR, r18);
        if (r3 == null) goto L61;
        String r19 = r3.getAsString(SyncContractKt.COLUMN_BIRTHDAY);
    L62:
        if (r19 != null) goto L64;
        r19 = "";
    L64:
        r4.put(SyncContractKt.COLUMN_BIRTHDAY, r19);
        if (r3 == null) goto L67;
        String r20 = r3.getAsString(SyncContractKt.COLUMN_NOTE);
    L68:
        if (r20 != null) goto L70;
        r20 = "";
    L70:
        r4.put(SyncContractKt.COLUMN_NOTE, r20);
        if (r3 == null) goto L73;
        String r21 = r3.getAsString(SyncContractKt.COLUMN_NICK_NAME);
    L74:
        if (r21 != null) goto L76;
        r21 = "";
    L76:
        r4.put(SyncContractKt.COLUMN_NICK_NAME, r21);
        if (r3 == null) goto L79;
        String r22 = r3.getAsString(SyncContractKt.COLUMN_IM);
    L80:
        if (r22 != null) goto L82;
        r22 = "";
    L82:
        r4.put(SyncContractKt.COLUMN_IM, r22);
        if (r3 == null) goto L85;
        String r23 = r3.getAsString(SyncContractKt.COLUMN_WEBSITE);
    L86:
        if (r23 != null) goto L88;
        r23 = "";
    L88:
        r4.put(SyncContractKt.COLUMN_WEBSITE, r23);
        if (r3 == null) goto L91;
        Integer r24 = r3.getAsInteger(SyncContractKt.COLUMN_GENDER);
    L92:
        if (r24 != null) goto L94;
        int r25 = -1;
    L95:
        r4.put(SyncContractKt.COLUMN_GENDER, Integer.valueOf(r25));
        if (r3 == null) goto L98;
        String r26 = r3.getAsString(SyncContractKt.COLUMN_RELATION);
    L99:
        if (r26 != null) goto L101;
        r26 = "";
    L101:
        r4.put(SyncContractKt.COLUMN_RELATION, r26);
        if (r3 == null) goto L104;
        r6 = r3.getAsString(SyncContractKt.COLUMN_INTER_ADDRESS);
    L104:
        if (r6 == null) goto L107;
        r8 = r6;
    L107:
        r4.put(SyncContractKt.COLUMN_INTER_ADDRESS, r8);
        r4.put("contact_id", Long.valueOf(r1));
        r10.put(Long.valueOf(r1), r4);
        goto L4
    L98:
        r26 = null;
        goto L99
    L94:
        Intrinsics.checkNotNullExpressionValue(r24, "values?.getAsInteger(COLUMN_GENDER) ?: -1");
        r25 = r24.intValue();
        goto L95
    L91:
        r24 = null;
        goto L92
    L85:
        r23 = null;
        goto L86
    L79:
        r22 = null;
        goto L80
    L73:
        r21 = null;
        goto L74
    L67:
        r20 = null;
        goto L68
    L61:
        r19 = null;
        goto L62
    L57:
        r18 = null;
        goto L58
    L51:
        r17 = null;
        goto L52
    L45:
        r16 = null;
        goto L46
    L39:
        r15 = null;
        goto L40
    L33:
        r14 = null;
        goto L34
    L27:
        r13 = null;
        goto L28
    L21:
        r12 = null;
        goto L22
    L15:
        r9 = null;
        goto L16
    L8:
        r7 = null;
        goto L9
    L108:
        return r10;
    }

    public final byte[] getPhotoValue(Context r6, Uri r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();
        byte[] r0 = null;
        if (r7 != null) goto L37;
        InputStream r8 = null;
    L9:
        if (r8 != null) goto L33;
    L29:
        if (r8 == null) goto L31;
        r8.close();
    L31:
        r5.close();
        return r0;
    L33:
        byte[] r9 = new byte[1024];     // Catch: Throwable -> L17
    L12:
        int r1 = r8.read(r9);     // Catch: Throwable -> L17
        if (r1 == (-1)) goto L15;
        r5.write(r9, 0, r1);     // Catch: Throwable -> L17
        goto L12
    L15:
        r0 = r5.toByteArray();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        InputStream r10 = r8;
        th = th;
    L35:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("", "error e = " + th);     // Catch: Throwable -> L23
        if (r10 == null) goto L31;
        r10.close();
    L23:
        th = move-exception;
        if (r10 == null) goto L27;
        r10.close();
    L27:
        r5.close();
        throw th;
    L37:
        r8 = r6.getContentResolver().openInputStream(r7);     // Catch: Throwable -> L6
    L6:
        th = th;
        r10 = null;
        goto L35
    }

    public final boolean hasContact(Context r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Cursor r6 = r7.getContentResolver().query(SyncContractKt.getContactSyncUri(), null, "_id = ?", new String[]{String.valueOf(r8)}, null);
        if (r6 == null) goto L13;
        Cursor r9 = r6;
        Cursor r10 = r9;     // Catch: Throwable -> L8
        boolean r11 = r6.moveToFirst();     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r9, null);
        return r11;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L13:
        return false;
    }

    @JvmStatic
    public static final ArrayList<ContactType> updateList(String r3, int r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "value");
        ArrayList<ContactType> r0 = new ArrayList();
        String r1 = r6;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L23;
    L19:
        ContactType r7 = new ContactType(r3, r4, r5);
        if (r0.contains(r7) == true) goto L22;
        r0.add(r7);
    L22:
        return r0;
    L23:
        ContactParamList r8 = (ContactParamList) new Gson().fromJson(r6, ContactParamList.class);     // Catch: JsonParseException -> L13
    L15:
        if (r8 == null) goto L19;
        List<ContactType> r9 = r8.getList();
        if (r9 == null) goto L19;
        r0 = new ArrayList(r9);
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ObricSyncUtils.TAG, String.valueOf(e));
        r8 = null;
        goto L15
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
