package com.android.contacts.obricsync;

import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.ContactSaveService;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.interactions.GroupDeletionDialogFragment;
import com.android.contacts.model.dataitem.CardIdDataItem;
import com.android.contacts.obricsync.contact.ContactParamList;
import com.android.contacts.obricsync.contact.ContactSync;
import com.android.contacts.obricsync.contact.ContactType;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.cloudsdk.kv.base.KvSyncManager;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.ContactsSyncUpdateEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SyncToLocalUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J1\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001fJ(\u0010 \u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010#\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010%\u001a\u00020\fH\u0002J\u001f\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010#\u001a\u00020\fH\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0010H\u0002J \u0010,\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0019H\u0002J\u0018\u0010/\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\fH\u0002J\u001e\u00101\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\fH\u0002J?\u00102\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u00192\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u00105J+\u00106\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0000¢\u0006\u0002\b7J\u001a\u00108\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\u0015H\u0007JG\u0010:\u001a\u00020;2\u0006\u0010\t\u001a\u00020\n2\b\u0010<\u001a\u0004\u0018\u00010\f2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010\u00042\b\u0010.\u001a\u0004\u0018\u00010\u00192\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010>J0\u0010?\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020@0\u001fH\u0002J\u0018\u0010A\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0018\u0010B\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\fH\u0002J\u0018\u0010C\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\fH\u0002J+\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0000¢\u0006\u0002\bGJ\u0018\u0010H\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\fH\u0002J9\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020\u00042\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\b\u0010E\u001a\u0004\u0018\u00010J2\b\u0010F\u001a\u0004\u0018\u00010JH\u0000¢\u0006\u0002\bMJ+\u0010N\u001a\u00020\u00192\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\u0019H\u0000¢\u0006\u0002\bOJ9\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010K\u001a\u00020\u00042\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\b\u0010E\u001a\u0004\u0018\u00010Q2\b\u0010F\u001a\u0004\u0018\u00010QH\u0000¢\u0006\u0002\bRJ3\u0010S\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0000¢\u0006\u0002\bTJ\u0018\u0010U\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010#\u001a\u00020\fH\u0007J\u001d\u0010V\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u00020\fH\u0000¢\u0006\u0002\bWJ\u0018\u0010X\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J9\u0010Y\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0002\u0010ZJ6\u0010[\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010Q2\b\u0010\u000f\u001a\u0004\u0018\u00010Q2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0002J,\u0010[\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0002J1\u0010\\\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000b\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010]J6\u0010^\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010Q2\b\u0010\u000f\u001a\u0004\u0018\u00010Q2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0002Jj\u0010_\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\"\u0010`\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@0aj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@`b2\"\u0010c\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@0aj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@`bH\u0003J\"\u0010d\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010JH\u0002J6\u0010e\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006f"}, d2 = {"Lcom/android/contacts/obricsync/SyncToLocalUtils;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "clearContactsPhoto", "", "context", "Landroid/content/Context;", "contactsId", "", "compareAndUpdate", "", "contactSyncNew", "Lcom/android/contacts/obricsync/contact/ContactSync;", "contactSyncOld", "cloudKeys", "", "cursorToContentValues", "Landroid/content/ContentValues;", "cursor", "Landroid/database/Cursor;", "deleteContact", "", CallLogListAdapter.PAYLOAD_SELECTION, "selectionArgs", "", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;)I", "ids", "", "deleteContactParams", "mimeType", "deleteInsertedContact", ContactSaveService.EXTRA_RAW_CONTACT_ID, "getContactId", "syncId", "getContactIdByData", "contact", "(Landroid/content/Context;Lcom/android/contacts/obricsync/contact/ContactSync;)Ljava/lang/Long;", "getContactIdByRawContactId", "getContactName", "contactSync", "getLabelByType", "mileType", "type", "getRawContactIdByContactId", ContactSaveService.EXTRA_CONTACT_ID, "getRawContactIdsByContactId", "getRawContactsIds", "data", GroupDeletionDialogFragment.ARG_LABEL, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/util/List;", "hasStructuredNameDiff", "hasStructuredNameDiff$app_QssiCnRelease", "insertContact", "values", "insertContactItemData", "Landroid/content/ContentProviderOperation;", "rawId", "value", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Landroid/content/ContentProviderOperation;", "insertContactParams", "Lcom/android/contacts/obricsync/contact/ContactType;", "insertItem", "isContactDeleted", "isContactIdValid", "mergeMissingFromOld", "new", "old", "mergeMissingFromOld$app_QssiCnRelease", "notifyCloudDeleteForContact", "pickBytes", "", "key", "keys", "pickBytes$app_QssiCnRelease", "pickGender", "pickGender$app_QssiCnRelease", "pickList", "Lcom/android/contacts/obricsync/contact/ContactParamList;", "pickList$app_QssiCnRelease", "pickStr", "pickStr$app_QssiCnRelease", "queryContactIdByRawContactId", "resolveExistingContactDataId", "resolveExistingContactDataId$app_QssiCnRelease", "revertLocalToCloud", "updateContact", "(Landroid/content/Context;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z", "updateContactItem", "updateContactItemGender", "(Landroid/content/Context;Ljava/lang/Integer;JLjava/lang/String;)Z", "updateContactItemPhone", "updateContactParams", "updateMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "oldData", "updatePhoto2Sync", "updateStructuredName", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SyncToLocalUtils {
    public static final SyncToLocalUtils INSTANCE = null;
    private static final String TAG = null;

    private SyncToLocalUtils() {
    }

    static {
        INSTANCE = new SyncToLocalUtils();
        TAG = "SyncUtils";
    }

    public final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static final long insertContact(Context r10, ContentValues r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncToLocalUtils#insertContact ");
        boolean r2 = false;
        if (r11 != null) goto L5;
    L7:
        if (r2 == false) goto L9;
        r11.remove(SyncContractKt.COLUMN_SHOULD_RESET);
    L9:
        ContactSync r0 = ObricSyncUtils.INSTANCE.getContactSync(r11);
        SyncToLocalUtils r3 = INSTANCE;
        Long r4 = r3.getContactIdByData(r10, r0);
        if (r4 == null) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncToLocalUtils#insertContact existingContactId:" + r4);
        if (r3.isContactDeleted(r10, r4.longValue()) == false) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#insertContact blocked: contactId=" + r4 + " was locally deleted");
        r3.notifyCloudDeleteForContact(r10, r4.longValue());
        return -1;
    L16:
        return r3.resolveExistingContactDataId$app_QssiCnRelease(r10, r4.longValue());
    L17:
        long r1 = r3.insertItem(r10, r0);
        long r6 = r3.getContactIdByRawContactId(r10, r1);
        if (r6 >= 0) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#insertContact failed to resolve contactId, rawContactId=" + r1);
        return -1;
    L22:
        if (r3.isContactDeleted(r10, r6) == false) goto L25;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#insertContact blocked: newly inserted contactId=" + r6 + " matches a deleted contact");
        r3.deleteInsertedContact(r10, r1);
        r3.notifyCloudDeleteForContact(r10, r6);
        return -1;
    L25:
        if (r11 == null) goto L27;
        r11.put("contact_id", Long.valueOf(r6));
    L27:
        Uri r12 = r10.getContentResolver().insert(SyncContractKt.getContactSyncUri(), r11);
        if (r12 == null) goto L31;
        long r13 = ContentUris.parseId(r12);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "[SYNC-BULK-CLEANUP] cloud insert mapped, contactId=" + r6 + ", dataId=" + r13 + ", existing=false");
        ObricSyncUtils.scheduleSnapshotCleanup(r6);
        return r13;
    L31:
        return -1;
    L5:
        if (r11.containsKey(SyncContractKt.COLUMN_SHOULD_RESET) != true) goto L7;
        r2 = true;
        goto L7
    }

    public final long resolveExistingContactDataId$app_QssiCnRelease(Context r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        long r3 = LocalToSyncUtils.INSTANCE.getSyncId(r4, r5);
        if (r3 >= 0) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#insertContact existing sync snapshot missing, contactId=" + r5);
    L5:
        return r3;
    }

    @JvmStatic
    public static final boolean updateContact(Context r21, ContentValues r22, String r23, String[] r24) {
        Intrinsics.checkNotNullParameter(r21, "context");
        StringBuilder r1 = new StringBuilder("SyncToLocalUtils#updateContact ").append(r23).append(" , ");
        if (r24 == null) goto L5;
        Integer r2 = Integer.valueOf(r24.length);
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, r1.append(r2).toString());
        boolean r12 = false;
        if (r22 != null) goto L9;
        return false;
    L9:
        boolean r14 = Intrinsics.areEqual(r22.getAsBoolean(SyncContractKt.COLUMN_SHOULD_RESET), true);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncToLocalUtils#updateContact before hasShouldReset: " + r14);
        if (r22.containsKey(SyncContractKt.COLUMN_SHOULD_RESET) == false) goto L12;
        r22.remove(SyncContractKt.COLUMN_SHOULD_RESET);
    L12:
        Set<String> r3 = r22.keySet();
        Intrinsics.checkNotNullExpressionValue(r3, "values.keySet()");
        Set<String> r15 = CollectionsKt.toSet(r3);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#updateContact after hasShouldReset=" + r14 + ", cloudKeys=" + r15);
        ArrayList r6 = new ArrayList();
        Cursor r4 = r21.getContentResolver().query(SyncContractKt.getContactSyncUri(), null, r23, r24, null);
        if (r4 == null) goto L27;
        Cursor r5 = r4;
        Cursor r7 = r5;     // Catch: Throwable -> L21
    L17:
        if (r4.moveToNext() == false) goto L19;
        r6.add(Long.valueOf(r4.getLong(r4.getColumnIndexOrThrow("_id"))));     // Catch: Throwable -> L21
        goto L17
    L19:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r5, null);
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L27:
        char r9 = ' ';
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncToLocalUtils#updateContact ids " + r6 + ' ');
        Iterator r13 = r6.iterator();
        boolean r10 = false;
    L29:
        if (r13.hasNext() == false) goto L50;
        long r11 = ((Number) r13.next()).longValue();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncToLocalUtils#updateContact id " + r11 + r9);
        SyncToLocalUtils r16 = INSTANCE;
        long r17 = r16.getContactId(r21, r11);
        if (LocalToSyncUtils.INSTANCE.hasContact(r21, r11) == false) goto L33;
    L38:
        boolean r18 = r10;
        r21.getContentResolver().update(SyncContractKt.getContactSyncUri(), r22, r23, r24);
        ContactSync r19 = ObricSyncUtils.INSTANCE.getContactSync(r22);
        ContactSync r20 = ObricSyncUtils.INSTANCE.getContactSync(LocalToSyncUtils.INSTANCE.updateLocalToSync(r21, CollectionsKt.listOf(Long.valueOf(r17)), r12, r12).get(Long.valueOf(r17)));
        if (r14 == false) goto L42;
        r19 = r16.mergeMissingFromOld$app_QssiCnRelease(r19, r20, r15);
    L42:
        if (r16.compareAndUpdate(r21, r17, r19, r20, r15) == true) goto L46;
        if (r18 == true) goto L46;
        r10 = false;
    L47:
        if (r14 == false) goto L49;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "[CLOUD-RESET] revert after diff. contactId=" + r17);
        r16.revertLocalToCloud(r21, r17);
    L49:
        r9 = ' ';
        r12 = false;
    L46:
        r10 = true;
        goto L47
    L33:
        if (insertContact(r21, r22) == (-1)) goto L37;
        if (r10 == true) goto L37;
        r10 = r12;
    L37:
        r10 = true;
        goto L38
    L50:
        return r10;
    L5:
        r2 = null;
        goto L6
    }

    public final ContactSync mergeMissingFromOld$app_QssiCnRelease(ContactSync r4, ContactSync r5, Set<String> r6) {
        Intrinsics.checkNotNullParameter(r4, "new");
        Intrinsics.checkNotNullParameter(r5, "old");
        Intrinsics.checkNotNullParameter(r6, "cloudKeys");
        SyncToLocalUtils r3 = INSTANCE;
        r4.setName(r3.pickStr$app_QssiCnRelease("name", r6, r4.getName(), r5.getName()));
        r4.setFirstName(r3.pickStr$app_QssiCnRelease(SyncContractKt.COLUMN_FIRST_NAME, r6, r4.getFirstName(), r5.getFirstName()));
        r4.setLastName(r3.pickStr$app_QssiCnRelease(SyncContractKt.COLUMN_LAST_NAME, r6, r4.getLastName(), r5.getLastName()));
        r4.setCompany(r3.pickStr$app_QssiCnRelease(SyncContractKt.COLUMN_COMPANY, r6, r4.getCompany(), r5.getCompany()));
        r4.setNote(r3.pickStr$app_QssiCnRelease(SyncContractKt.COLUMN_NOTE, r6, r4.getNote(), r5.getNote()));
        r4.setNickname(r3.pickStr$app_QssiCnRelease(SyncContractKt.COLUMN_NICK_NAME, r6, r4.getNickname(), r5.getNickname()));
        r4.setWebsite(r3.pickStr$app_QssiCnRelease(SyncContractKt.COLUMN_WEBSITE, r6, r4.getWebsite(), r5.getWebsite()));
        r4.setIntelAddress(r3.pickStr$app_QssiCnRelease(SyncContractKt.COLUMN_INTER_ADDRESS, r6, r4.getIntelAddress(), r5.getIntelAddress()));
        r4.setPhoneNumber(r3.pickList$app_QssiCnRelease("phone_number", r6, r4.getPhoneNumber(), r5.getPhoneNumber()));
        r4.setEmail(r3.pickList$app_QssiCnRelease("email", r6, r4.getEmail(), r5.getEmail()));
        r4.setIdCards(r3.pickList$app_QssiCnRelease(SyncContractKt.COLUMN_ID_CARDS, r6, r4.getIdCards(), r5.getIdCards()));
        r4.setIm(r3.pickList$app_QssiCnRelease(SyncContractKt.COLUMN_IM, r6, r4.getIm(), r5.getIm()));
        r4.setBirthdayData(r3.pickList$app_QssiCnRelease(SyncContractKt.COLUMN_BIRTHDAY, r6, r4.getBirthdayData(), r5.getBirthdayData()));
        r4.setAddress(r3.pickList$app_QssiCnRelease(SyncContractKt.COLUMN_ADDRESS, r6, r4.getAddress(), r5.getAddress()));
        r4.setRelation(r3.pickList$app_QssiCnRelease(SyncContractKt.COLUMN_RELATION, r6, r4.getRelation(), r5.getRelation()));
        r4.setAvatar(r3.pickBytes$app_QssiCnRelease(SyncContractKt.COLUMN_AVATAR, r6, r4.getAvatar(), r5.getAvatar()));
        r4.setGenderCode(r3.pickGender$app_QssiCnRelease(r6, r4.getGenderCode(), r5.getGenderCode()));
        return r4;
    }

    public final String pickStr$app_QssiCnRelease(String r1, Set<String> r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "keys");
        Intrinsics.checkNotNullParameter(r3, "new");
        Intrinsics.checkNotNullParameter(r4, "old");
        if (r2.contains(r1) == false) goto L11;
        if (r3.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return r3;
    L7:
        r0 = false;
    L11:
        return r4;
    }

    public final ContactParamList pickList$app_QssiCnRelease(String r1, Set<String> r2, ContactParamList r3, ContactParamList r4) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "keys");
        if (r2.contains(r1) == false) goto L17;
        if (r3 == null) goto L6;
        List<ContactType> r0 = r3.getList();
    L7:
        List<ContactType> r5 = r0;
        if (r5 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == true) goto L17;
        return r3;
    L10:
        if (r5.isEmpty() == true) goto L13;
        r6 = false;
        goto L14
    L6:
        r0 = null;
    L17:
        return r4;
    }

    public final byte[] pickBytes$app_QssiCnRelease(String r1, Set<String> r2, byte[] r3, byte[] r4) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "keys");
        if (r2.contains(r1) == false) goto L10;
        if (r3 == null) goto L6;
        int r0 = r3.length;
    L7:
        if (r0 <= 0) goto L10;
        return r3;
    L6:
        r0 = 0;
    L10:
        return r4;
    }

    public final int pickGender$app_QssiCnRelease(Set<String> r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "keys");
        if (r1.contains(SyncContractKt.COLUMN_GENDER) == false) goto L8;
        if (r2 == (-1)) goto L8;
        return r2;
    L8:
        return r3;
    }

    private final void revertLocalToCloud(Context r3, long r4) {
        if (r4 > 0) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "[CLOUD-RESET] revert skipped, invalid contactsId=" + r4);
        return;
    L14:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        LocalToSyncUtils.update2Sync(r3, CollectionsKt.listOf(Long.valueOf(r4)), false);     // Catch: Throwable -> L8
        Object r5 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.m806exceptionOrNullimpl(r5);
        if (r6 == null) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "[CLOUD-RESET] update2Sync failed, contactId=" + r4, r6);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @JvmStatic
    public static final int deleteContact(Context r7, String r8, String[] r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncToLocalUtils#deleteContact selection " + r8);
        ArrayList r0 = new ArrayList();
        Cursor r10 = r7.getContentResolver().query(SyncContractKt.getContactSyncUri(), null, r8, r9, null);
        if (r10 == null) goto L17;
        Cursor r11 = r10;
        Cursor r1 = r11;     // Catch: Throwable -> L11
    L7:
        if (r10.moveToNext() == false) goto L9;
        r0.add(Long.valueOf(r10.getLong(r10.getColumnIndexOrThrow("_id"))));     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r11, null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L17:
        return INSTANCE.deleteContact(r7, r0);
    }

    public final int deleteContact(Context r21, List<Long> r22) {
        String r2 = "contact_id";
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "ids");
        String r1 = "_id IN " + CollectionsKt.joinToString$default(r22, SimContactsConstants.EMAIL_SEP, "(", ")", 0, null, null, 56, null);
        Cursor r3 = r21.getContentResolver().query(SyncContractKt.getContactSyncUri(), null, r1, null, null);
        if (r3 == null) goto L40;
        Cursor r5 = r3;
        Cursor r6 = r5;     // Catch: Throwable -> L32
    L6:
        if (r3.moveToNext() == false) goto L28;
        long r7 = r6.getLong(r6.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L26
        long r9 = r6.getLong(r6.getColumnIndexOrThrow(r2));     // Catch: Throwable -> L26
        SyncToLocalUtils r11 = INSTANCE;     // Catch: Throwable -> L26
        if (r11.isContactIdValid(r21, r9) == false) goto L13;
        r2 = r2;
        r3 = r3;
        long r4 = r9;
        long r8 = 0;
    L19:
        if (r4 < r8) goto L43;
        Iterator<T> r10 = r11.getRawContactIdsByContactId(r21, r4).iterator();     // Catch: Throwable -> L30
    L23:
        if (r10.hasNext() == false) goto L25;
        r21.startService(ContactSaveService.createDeleteRawContactIntent(r21, ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, ((Number) r10.next()).longValue()).buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build()));     // Catch: Throwable -> L30
    L25:
        r5 = r5;
        r2 = r2;
        r3 = r3;
        goto L6
    L43:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#deleteContact skip, invalid contactId=" + r9 + " for syncId=" + r7);     // Catch: Throwable -> L30
    L30:
        th = th;
        Cursor r12 = r5;
    L34:
        Throwable r13 = th;
    L41:
        throw r13;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r12, r13);
        throw th;
    L13:
        r4 = r11.getContactIdByRawContactId(r21, r9);     // Catch: Throwable -> L30
        if (r4 <= 0) goto L17;
        ContentValues r14 = new ContentValues();     // Catch: Throwable -> L30
        r14.put(r2, Long.valueOf(r4));     // Catch: Throwable -> L30
        r21.getContentResolver().update(SyncContractKt.getContactSyncUri(), r14, "_id = ?", new String[]{String.valueOf(r7)});     // Catch: Throwable -> L30
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#deleteContact migrate contact_id from rawId=" + r9 + " to contactId=" + r4 + " for syncId=" + r7);     // Catch: Throwable -> L30
    L17:
        r8 = 0;
    L26:
        th = move-exception;
        r13 = th;
        r12 = r5;
        goto L41
    L28:
        r5 = r5;
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r5, null);
    L32:
        th = th;
        r12 = r5;
    L40:
        return r21.getContentResolver().delete(SyncContractKt.getContactSyncUri(), r1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean compareAndUpdate(Context r20, long r21, ContactSync r23, ContactSync r24, Set<String> r25) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncToLocalUtils#compareAndUpdate contactsId " + r21 + " \n old = [" + r24 + "] \n new = [" + r23 + "] \n cloudKeys = " + r25);
        if (Intrinsics.areEqual(r24, r23) == false) goto L5;
        return true;
    L5:
        boolean r16 = false;
        if (hasStructuredNameDiff$app_QssiCnRelease(r23, r24, r25) == false) goto L8;
        boolean r7 = updateStructuredName(r20, r23, r24, r21, r25);
    L10:
        if (r25.contains(SyncContractKt.COLUMN_COMPANY) == false) goto L20;
        if (Intrinsics.areEqual(r23.getCompany(), r24.getCompany()) == true) goto L20;
        if (updateContactItem(r20, r23.getCompany(), r21, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_COMPANY)) == true) goto L18;
        if (r7 == true) goto L18;
        r7 = false;
    L18:
        r7 = true;
    L20:
        if (r25.contains(SyncContractKt.COLUMN_NOTE) == true) goto L22;
    L29:
        boolean r17 = r7;
        if (r25.contains("phone_number") == false) goto L40;
        if (Intrinsics.areEqual(r23.getPhoneNumber(), r24.getPhoneNumber()) == true) goto L40;
        if (updateContactItemPhone(r20, r24.getPhoneNumber(), r23.getPhoneNumber(), r21, SyncContractKt.getContactMap().get("phone_number")) == true) goto L38;
        if (r17 == true) goto L38;
        r17 = false;
    L38:
        r17 = true;
    L40:
        if (r25.contains("email") == false) goto L50;
        if (Intrinsics.areEqual(r23.getEmail(), r24.getEmail()) == true) goto L50;
        if (updateContactItem(r20, r24.getEmail(), r23.getEmail(), r21, SyncContractKt.getContactMap().get("email")) == true) goto L48;
        if (r17 == true) goto L48;
        r17 = false;
    L48:
        r17 = true;
    L50:
        if (r25.contains(SyncContractKt.COLUMN_NICK_NAME) == false) goto L60;
        if (Intrinsics.areEqual(r23.getNickname(), r24.getNickname()) == true) goto L60;
        if (updateContactItem(r20, r23.getNickname(), r21, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_NICK_NAME)) == true) goto L58;
        if (r17 == true) goto L58;
        r17 = false;
    L58:
        r17 = true;
    L60:
        if (r25.contains(SyncContractKt.COLUMN_ID_CARDS) == false) goto L70;
        if (Intrinsics.areEqual(r23.getIdCards(), r24.getIdCards()) == true) goto L70;
        if (updateContactItem(r20, r24.getIdCards(), r23.getIdCards(), r21, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_ID_CARDS)) == true) goto L68;
        if (r17 == true) goto L68;
        r17 = false;
    L68:
        r17 = true;
    L70:
        if (r25.contains(SyncContractKt.COLUMN_AVATAR) == false) goto L81;
        if (Arrays.equals(r23.getAvatar(), r24.getAvatar()) == true) goto L81;
        if (updatePhoto2Sync(r20, r21, r23.getAvatar()) == true) goto L78;
        if (r17 == true) goto L78;
        r17 = false;
    L78:
        r17 = true;
    L81:
        if (r25.contains(SyncContractKt.COLUMN_IM) == false) goto L91;
        if (Intrinsics.areEqual(r23.getIm(), r24.getIm()) == true) goto L91;
        if (updateContactItem(r20, r24.getIm(), r23.getIm(), r21, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_IM)) == true) goto L89;
        if (r17 == true) goto L89;
        r17 = false;
    L89:
        r17 = true;
    L91:
        if (r25.contains(SyncContractKt.COLUMN_WEBSITE) == false) goto L101;
        if (Intrinsics.areEqual(r23.getWebsite(), r24.getWebsite()) == true) goto L101;
        if (updateContactItem(r20, r23.getWebsite(), r21, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_WEBSITE)) == true) goto L99;
        if (r17 == true) goto L99;
        r17 = false;
    L99:
        r17 = true;
    L101:
        if (r25.contains(SyncContractKt.COLUMN_BIRTHDAY) == false) goto L111;
        if (Intrinsics.areEqual(r23.getBirthdayData(), r24.getBirthdayData()) == true) goto L111;
        if (updateContactItem(r20, r24.getBirthdayData(), r23.getBirthdayData(), r21, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_BIRTHDAY)) == true) goto L109;
        if (r17 == true) goto L109;
        r17 = false;
    L109:
        r17 = true;
    L111:
        if (r25.contains(SyncContractKt.COLUMN_ADDRESS) == false) goto L121;
        if (Intrinsics.areEqual(r23.getAddress(), r24.getAddress()) == true) goto L121;
        if (updateContactItem(r20, r24.getAddress(), r23.getAddress(), r21, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_ADDRESS)) == true) goto L119;
        if (r17 == true) goto L119;
        r17 = false;
    L119:
        r17 = true;
    L121:
        if (r25.contains(SyncContractKt.COLUMN_INTER_ADDRESS) == false) goto L131;
        if (Intrinsics.areEqual(r23.getIntelAddress(), r24.getIntelAddress()) == true) goto L131;
        if (updateContactItem(r20, r23.getIntelAddress(), r21, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_INTER_ADDRESS)) == true) goto L129;
        if (r17 == true) goto L129;
        r17 = false;
    L129:
        r17 = true;
    L131:
        if (r25.contains(SyncContractKt.COLUMN_RELATION) == false) goto L141;
        if (Intrinsics.areEqual(r23.getRelation(), r24.getRelation()) == true) goto L141;
        if (updateContactItem(r20, r24.getRelation(), r23.getRelation(), r21, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_RELATION)) == true) goto L139;
        if (r17 == true) goto L139;
        r17 = false;
    L139:
        r17 = true;
    L141:
        if (r25.contains(SyncContractKt.COLUMN_GENDER) == true) goto L143;
    L149:
        boolean r1 = r17;
    L150:
        if (r1 == false) goto L159;
        String r2 = null;
        long r3 = getRawContactIdByContactId(r20, r21);     // Catch: Throwable -> L157
        if (r3 <= 0) goto L155;
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L157
        r0.put("dirty", 1);     // Catch: Throwable -> L157
        Uri r4 = ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r3).buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build();     // Catch: Throwable -> L157
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#compareAndUpdate update rawContactUri = " + r4);     // Catch: Throwable -> L157
        r20.getContentResolver().update(r4, r0, null, null);     // Catch: Throwable -> L157
    L161:
        goto L159
    L155:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#compareAndUpdate skip mark dirty, invalid rawId=" + r3 + ", contactId=" + r21);     // Catch: Throwable -> L157
    L157:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "SyncToLocalUtils#compareAndUpdate update exception = ", th);
        EventTrackerManager.INSTANCE.track(new ContactsSyncUpdateEvent(ExceptionsKt.stackTraceToString(th), r2, 2, null == true ? 1 : 0));
    L159:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#compareAndUpdate update updateNum = " + r1);
        return r1;
    L143:
        if (r23.getGenderCode() == r24.getGenderCode()) goto L149;
        if (updateContactItemGender(r20, Integer.valueOf(r23.getGenderCode()), r21, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_GENDER)) == true) goto L147;
        if (r17 == true) goto L147;
    L148:
        r1 = r16;
    L147:
        r16 = true;
        goto L148
    L22:
        if (Intrinsics.areEqual(r23.getNote(), r24.getNote()) == true) goto L29;
        if (updateContactItem(r20, r23.getNote(), r21, SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_NOTE)) == true) goto L28;
        if (r7 == true) goto L28;
        r7 = false;
    L28:
        r7 = true;
        goto L29
    L8:
        r7 = false;
        goto L10
    }

    private final boolean updatePhoto2Sync(Context r8, long r9, byte[] r11) {
        long r0 = getRawContactIdByContactId(r8, r9);
        boolean r3 = false;
        if (r0 > 0) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#updatePhoto2Sync skip, rawId=" + r0 + ", contactsId=" + r9);
        return false;
    L6:
        clearContactsPhoto(r8, r9);
        String r7 = "(contact_id=" + r9 + ") AND (mimetype='" + SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_AVATAR) + "')";
        Uri r10 = ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build();
        if (r11 == null) goto L9;
        String r12 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_AVATAR);
        ContentValues r5 = new ContentValues();
        r5.put(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r0));
        r5.put("mimetype", r12);
        r5.put(SyncContractKt.getContactValueColumnName().get(r12), r11);
        int r13 = r8.getContentResolver().update(r10, r5, r7, null);
        if (r13 <= 0) goto L15;
        boolean r14 = true;
    L16:
        if (r13 == 0) goto L18;
        return r14;
    L18:
        if (r8.getContentResolver().insert(r10, r5) == null) goto L21;
        r3 = true;
    L21:
        return r3;
    L15:
        r14 = false;
        goto L16
    L9:
        if (r8.getContentResolver().delete(r10, r7, null) > 0) goto L11;
        return false;
    L11:
        return true;
    }

    private final void clearContactsPhoto(Context r7, long r8) {
        String r6 = "(_id=" + r8 + ')';
        Uri r9 = ContactsContract.Contacts.CONTENT_URI.buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build();
        Cursor r10 = r7.getContentResolver().query(r9, null, r6, null, null);
        if (r10 == null) goto L16;
        Cursor r11 = r10;
        ContentValues r0 = INSTANCE.cursorToContentValues(r11);     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r11, null);
        if (r0 == null) goto L21;
        r0.put("photo_uri", "");
        r0.put("photo_id", -1);
        r0.put("photo_file_id", -1);
        r7.getContentResolver().update(r9, r0, r6, null);
        return;
    L21:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public final ContentValues cursorToContentValues(Cursor r6) {
        ContentValues r5 = new ContentValues();
        if (r6 != null) goto L5;
    L23:
        return r5;
    L5:
        if (r6.moveToFirst() == false) goto L23;
        int r0 = r6.getColumnCount();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L22;
        String r2 = r6.getColumnName(r1);
        int r3 = r6.getType(r1);
        if (r3 != 1) goto L11;
        r5.put(r2, Integer.valueOf(r6.getInt(r1)));
    L21:
        r1 = r1 + 1;
        goto L7
    L11:
        if (r3 != 2) goto L13;
        r5.put(r2, Float.valueOf(r6.getFloat(r1)));
        goto L21
    L13:
        if (r3 != 3) goto L15;
        r5.put(r2, r6.getString(r1));
        goto L21
    L15:
        if (r3 != 4) goto L21;
        r5.put(r2, r6.getBlob(r1));
        goto L21
    L22:
        r6.moveToFirst();
        goto L23
    }

    private final boolean updateContactItemPhone(Context r23, ContactParamList r24, ContactParamList r25, long r26, String r28) {
        HashMap r1 = new HashMap();
        HashMap<Long, ContactType> r7 = new HashMap();
        ArrayList r10 = new ArrayList();
        String r2 = CollectionsKt.joinToString$default(getRawContactIdsByContactId(r23, r26), SimContactsConstants.EMAIL_SEP, "(", ")", 0, null, null, 56, null);
        if (r24 == null) goto L44;
        List<ContactType> r3 = r24.getList();
        if (r3 == null) goto L44;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L44;
        ContactType r5 = (ContactType) r4.next();
        String r17 = "(raw_contact_id IN " + r2 + ") AND (mimetype='" + r28 + "') AND (" + SyncContractKt.getContactValueColumnName().get(r28) + "='" + r5.getValue() + "')";
        Cursor r6 = r23.getContentResolver().query(ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build(), null, r17, null, null);
        if (r6 == null) goto L42;
        Cursor r8 = r6;
        Cursor r14 = r8;     // Catch: Throwable -> L36
        int r15 = r6.getCount();     // Catch: Throwable -> L36
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "updateContactItemPhone count " + r15);     // Catch: Throwable -> L36
        if (r15 > 1) goto L17;
        r4 = r4;
        if (r15 == 1) goto L32;
    L34:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r8, null);
    L43:
        r4 = r4;
        r2 = r2;
        goto L8
    L32:
        if (r6.moveToFirst() == false) goto L34;
        long r11 = r6.getLong(r6.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L36
        r1.put(r5.getValue(), Long.valueOf(r11));     // Catch: Throwable -> L36
        r7.put(Long.valueOf(r11), r5);     // Catch: Throwable -> L36
        goto L34
    L17:
        if (r6.moveToPosition(r15 - 1) == false) goto L20;
        long r13 = r6.getLong(r6.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L36
        r1.put(r5.getValue(), Long.valueOf(r13));     // Catch: Throwable -> L36
        r7.put(Long.valueOf(r13), r5);     // Catch: Throwable -> L36
    L20:
        r6.moveToPosition(-1);     // Catch: Throwable -> L36
    L22:
        if (r6.moveToNext() == true) goto L34;
        if (r6.isLast() == true) goto L34;
        long r12 = r6.getLong(r6.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L36
        if (r10.contains(Long.valueOf(r12)) == true) goto L22;
        r10.add(Long.valueOf(r12));     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    L42:
        r4 = r4;
    L44:
        ArrayList r16 = new ArrayList();
        ArrayList r18 = new ArrayList();
        HashMap<Long, ContactType> r19 = new HashMap();
        if (r25 == null) goto L65;
        List<ContactType> r20 = r25.getList();
        if (r20 == null) goto L65;
        Iterator<T> r21 = r20.iterator();
    L50:
        if (r21.hasNext() == false) goto L65;
        ContactType r22 = (ContactType) r21.next();
        long r27 = (Long) r1.get(r22.getValue());
        if (r27 != null) goto L54;
        r27 = -1L;
    L54:
        Intrinsics.checkNotNullExpressionValue(r27, "oldIds[number] ?: -1L");
        long r110 = r27.longValue();
        if (r110 == (-1)) goto L57;
        if (r16.contains(Long.valueOf(r110)) == true) goto L63;
        r16.add(Long.valueOf(r110));
    L63:
        if (Intrinsics.areEqual(r7.get(Long.valueOf(r110)), r22) == true) goto L50;
        r19.put(Long.valueOf(r110), r22);
        goto L50
    L57:
        if (r18.contains(r22) == true) goto L50;
        r18.add(r22);
    L65:
        Collection r29 = r1.values();
        Intrinsics.checkNotNullExpressionValue(r29, "oldIds.values");
        Iterator r30 = r29.iterator();
    L67:
        if (r30.hasNext() == false) goto L73;
        Long r31 = (Long) r30.next();
        if (r16.contains(r31) == true) goto L67;
        if (r10.contains(r31) == true) goto L67;
        r10.add(r31);
        goto L67
    L73:
        boolean r32 = updateContactParams(r23, r28, r26, r19, r7);
        boolean r33 = insertContactParams(r23, r28, r26, r18);
        boolean r0 = deleteContactParams(r23, r10, r28);
        if (r32 == true) goto L80;
        if (r33 == true) goto L80;
        if (r0 == true) goto L80;
        return false;
    L80:
        return true;
    }

    private final boolean updateContactItem(Context r24, ContactParamList r25, ContactParamList r26, long r27, String r29) {
        HashMap r1 = new HashMap();
        HashMap<Long, ContactType> r7 = new HashMap();
        ArrayList r10 = new ArrayList();
        String r2 = CollectionsKt.joinToString$default(getRawContactIdsByContactId(r24, r27), SimContactsConstants.EMAIL_SEP, "(", ")", 0, null, null, 56, null);
        if (r25 == null) goto L49;
        List<ContactType> r3 = r25.getList();
        if (r3 == null) goto L49;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L49;
        ContactType r5 = (ContactType) r4.next();
        String r6 = "(raw_contact_id IN " + r2 + ") AND (mimetype='" + r29 + "') AND (" + SyncContractKt.getContactValueColumnName().get(r29) + "='" + r5.getValue() + "') AND (" + SyncContractKt.getContactTypeColumnName().get(r29) + "='" + r5.getType() + "')";
        if (r5.getType() != 0) goto L12;
    L13:
        r6 = r6 + " AND (" + SyncContractKt.getContactLabelColumnName().get(r29) + "='" + r5.getLabel() + "')";
    L14:
        Uri r18 = ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build();
        Cursor r8 = r24.getContentResolver().query(r18, null, r6, null, null);
        if (r8 == null) goto L47;
        Cursor r9 = r8;
        Cursor r14 = r9;     // Catch: Throwable -> L41
        int r15 = r8.getCount();     // Catch: Throwable -> L41
        if (r15 > 1) goto L22;
        r2 = r2;
        r4 = r4;
        if (r15 == 1) goto L37;
    L39:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L41
        CloseableKt.closeFinally(r9, null);
    L48:
        r2 = r2;
        r4 = r4;
        goto L8
    L37:
        if (r8.moveToFirst() == false) goto L39;
        long r12 = r8.getLong(r8.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L41
        r1.put(r5, Long.valueOf(r12));     // Catch: Throwable -> L41
        r7.put(Long.valueOf(r12), r5);     // Catch: Throwable -> L41
        goto L39
    L22:
        if (r8.moveToPosition(r15 - 1) == false) goto L25;
        long r13 = r8.getLong(r8.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L41
        r1.put(r5, Long.valueOf(r13));     // Catch: Throwable -> L41
        r7.put(Long.valueOf(r13), r5);     // Catch: Throwable -> L41
    L25:
        r8.moveToPosition(-1);     // Catch: Throwable -> L41
    L27:
        if (r8.moveToNext() == true) goto L39;
        if (r8.isLast() == true) goto L39;
        long r16 = r8.getLong(r8.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L41
        if (r10.contains(Long.valueOf(r16)) == true) goto L27;
        r10.add(Long.valueOf(r16));     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L47:
        r2 = r2;
        r4 = r4;
        goto L48
    L12:
        if (r5.getType() != (-1)) goto L14;
    L49:
        ArrayList r17 = new ArrayList();
        ArrayList r19 = new ArrayList();
        HashMap<Long, ContactType> r20 = new HashMap();
        if (r26 == null) goto L69;
        List<ContactType> r21 = r26.getList();
        if (r21 == null) goto L69;
        Iterator<T> r22 = r21.iterator();
    L55:
        if (r22.hasNext() == false) goto L69;
        ContactType r23 = (ContactType) r22.next();
        long r28 = (Long) r1.get(r23);
        if (r28 != null) goto L59;
        r28 = -1L;
    L59:
        Intrinsics.checkNotNullExpressionValue(r28, "oldIds[data] ?: -1L");
        long r110 = r28.longValue();
        if (r110 != (-1)) goto L65;
        if (r19.contains(r23) == true) goto L55;
        r19.add(r23);
        goto L55
    L65:
        if (r17.contains(Long.valueOf(r110)) == true) goto L67;
        r17.add(Long.valueOf(r110));
    L67:
        r20.put(Long.valueOf(r110), r23);
    L69:
        Collection r30 = r1.values();
        Intrinsics.checkNotNullExpressionValue(r30, "oldIds.values");
        Iterator r31 = r30.iterator();
    L71:
        if (r31.hasNext() == false) goto L77;
        Long r32 = (Long) r31.next();
        if (r17.contains(r32) == true) goto L71;
        if (r10.contains(r32) == true) goto L71;
        r10.add(r32);
        goto L71
    L77:
        boolean r33 = updateContactParams(r24, r29, r27, r20, r7);
        boolean r34 = insertContactParams(r24, r29, r27, r19);
        boolean r0 = deleteContactParams(r24, r10, r29);
        if (r33 == true) goto L83;
        if (r34 == true) goto L83;
        if (r0 == true) goto L83;
        return false;
    L83:
        return true;
    }

    private final boolean updateContactItem(Context r11, String r12, long r13, String r15) {
        Uri r0 = ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build();
        String r1 = "(contact_id=" + r13 + ") AND (mimetype='" + r15 + "')";
        String r2 = r12;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == true) goto L12;
        ContentValues r5 = new ContentValues();
        long r6 = getRawContactIdByContactId(r11, r13);
        if (r6 > 0) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#updateContactItem skip, rawId=" + r6 + ", contactsId=" + r13);
        return false;
    L20:
        r5.put(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r6));
        r5.put("mimetype", r15);
        r5.put(SyncContractKt.getContactValueColumnName().get(r15), r12);
        int r10 = r11.getContentResolver().update(r0, r5, r1, null);
        if (r10 <= 0) goto L23;
        boolean r14 = true;
    L24:
        if (r10 <= 0) goto L26;
        return r14;
    L26:
        if (r11.getContentResolver().insert(r0, r5) != null) goto L30;
        r3 = false;
    L30:
        return r3;
    L23:
        r14 = false;
        goto L24
    L12:
        if (r11.getContentResolver().delete(r0, r1, null) <= 0) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L10
    }

    private final boolean updateContactItemGender(Context r10, Integer r11, long r12, String r14) {
        Uri r9 = ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build();
        String r0 = "(contact_id=" + r12 + ") AND (mimetype='" + r14 + "')";
        boolean r2 = true;
        if (r11 == null) goto L20;
        r11.intValue();
        ContentValues r4 = new ContentValues();
        long r5 = INSTANCE.getRawContactIdByContactId(r10, r12);
        if (r5 > 0) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#updateContactItemGender skip, rawId=" + r5 + ", contactsId=" + r12);
        return false;
    L8:
        r4.put(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r5));
        r4.put("mimetype", r14);
        r4.put(SyncContractKt.getContactValueColumnName().get(r14), r11);
        int r13 = r10.getContentResolver().update(r9, r4, r0, null);
        if (r13 == 0) goto L11;
        boolean r15 = true;
    L12:
        if (r13 <= 0) goto L14;
        return r15;
    L14:
        if (r10.getContentResolver().insert(r9, r4) != null) goto L18;
        r2 = false;
    L18:
        return r2;
    L11:
        r15 = false;
        goto L12
    L20:
        if (r10.getContentResolver().delete(r9, r0, null) == 0) goto L23;
        return true;
    L23:
        return false;
    }

    public final boolean hasStructuredNameDiff$app_QssiCnRelease(ContactSync r2, ContactSync r3, Set<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "contactSyncNew");
        Intrinsics.checkNotNullParameter(r3, "contactSyncOld");
        Intrinsics.checkNotNullParameter(r4, "cloudKeys");
        if (r4.contains("name") == false) goto L7;
        if (Intrinsics.areEqual(r2.getName(), r3.getName()) == true) goto L7;
    L14:
        return true;
    L7:
        if (r4.contains(SyncContractKt.COLUMN_FIRST_NAME) == false) goto L11;
        if (Intrinsics.areEqual(r2.getFirstName(), r3.getFirstName()) == false) goto L14;
    L11:
        if (r4.contains(SyncContractKt.COLUMN_LAST_NAME) == true) goto L13;
    L15:
        return false;
    L13:
        if (Intrinsics.areEqual(r2.getLastName(), r3.getLastName()) == true) goto L15;
        goto L14
    }

    private final boolean updateStructuredName(Context r8, ContactSync r9, ContactSync r10, long r11, Set<String> r13) {
        long r0 = getRawContactIdByContactId(r8, r11);
        boolean r2 = false;
        if (r0 > 0) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#updateStructuredName skip, rawId=" + r0 + ", contactsId=" + r11);
        return false;
    L6:
        String r7 = SyncContractKt.getContactMap().get("name");
        Uri r4 = ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build();
        String r12 = "(contact_id=" + r11 + ") AND (mimetype='" + r7 + "')";
        if (r13.contains(SyncContractKt.COLUMN_FIRST_NAME) == false) goto L9;
        String r14 = r9.getFirstName();
    L11:
        if (r13.contains(SyncContractKt.COLUMN_LAST_NAME) == false) goto L13;
        String r5 = r9.getLastName();
    L15:
        if (r13.contains("name") == false) goto L17;
        String r15 = r9.getName();
    L19:
        if (r15.length() != 0) goto L21;
        boolean r16 = true;
    L23:
        if (r16 == true) goto L25;
    L38:
        ContentValues r17 = new ContentValues();
        r17.put(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r0));
        r17.put("mimetype", r7);
        r17.put("data1", r15);
        r17.put(DBHelper.COL_DATA3, r14);
        r17.put(DBHelper.COL_DATA2, r5);
        int r18 = r8.getContentResolver().update(r4, r17, r12, null);
        if (r18 <= 0) goto L41;
        boolean r19 = true;
    L42:
        if (r18 <= 0) goto L44;
        return r19;
    L44:
        if (r8.getContentResolver().insert(r4, r17) == null) goto L47;
        r2 = true;
    L47:
        return r2;
    L41:
        r19 = false;
        goto L42
    L25:
        if (r14.length() != 0) goto L27;
        boolean r110 = true;
    L28:
        if (r110 == false) goto L38;
        if (r5.length() != 0) goto L32;
        boolean r111 = true;
    L33:
        if (r111 == false) goto L38;
        if (r8.getContentResolver().delete(r4, r12, null) > 0) goto L37;
        return false;
    L37:
        return true;
    L32:
        r111 = false;
        goto L33
    L27:
        r110 = false;
        goto L28
    L21:
        r16 = false;
        goto L23
    L17:
        r15 = r10.getName();
        goto L19
    L13:
        r5 = r10.getLastName();
        goto L15
    L9:
        r14 = r10.getFirstName();
        goto L11
    }

    private final String getContactName(ContactSync r3) {
        String r2 = r3.getName();
        boolean r0 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L21;
        if (r3.getFirstName().length() <= 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L22;
        if (r3.getLastName().length() <= 0) goto L18;
        r0 = true;
    L18:
        if (r0 == false) goto L21;
    L22:
        return r3.getFirstName() + r3.getLastName();
    L13:
        r5 = false;
    L21:
        return r3.getName();
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    private final boolean updateContactParams(Context r18, String r19, long r20, HashMap<Long, ContactType> r22, HashMap<Long, ContactType> r23) {
        boolean r5 = false;
        if (r19 != null) goto L5;
        return false;
    L5:
        Set<Long> r6 = r22.keySet();
        Intrinsics.checkNotNullExpressionValue(r6, "updateMap.keys");
        Iterator r7 = r6.iterator();
        int r8 = 0;
    L6:
        int r9 = 1;
        if (r7.hasNext() == false) goto L47;
        Long r10 = (Long) r7.next();
        SyncToLocalUtils r11 = INSTANCE;
        long r12 = r11.getRawContactIdByContactId(r18, r20);
        if (r12 <= 0) goto L10;
        ContentValues r13 = new ContentValues();
        ContactType r14 = r22.get(r10);
        if (r14 == null) goto L16;
        r9 = r14.getType();
    L19:
        ContactType r15 = r23.get(r10);
        String r16 = SyncContractKt.getContactValueColumnName().get(r19);
        String r2 = SyncContractKt.getContactValueColumnName().get(r19);
        String r3 = SyncContractKt.getContactLabelColumnName().get(r19);
        Iterator r17 = r7;
        r13.put(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r12));
        r13.put("mimetype", r19);
        ContactType r21 = r22.get(r10);
        if (r21 == null) goto L22;
        String r24 = r21.getValue();
    L23:
        r13.put(r16, r24);
        r13.put(r2, Integer.valueOf(r9));
        if (r3 == null) goto L31;
        ContactType r25 = r22.get(r10);
        if (r25 == null) goto L29;
        String r26 = r25.getLabel();
        if (r26 == null) goto L29;
    L30:
        r13.put(r3, r26);
    L29:
        r26 = r11.getLabelByType(r18, r19, r9);
    L31:
        StringBuilder r27 = new StringBuilder("(_id=").append(r10.longValue()).append(") AND (mimetype='").append(r19).append("') AND (").append(r16).append("='");
        if (r15 == null) goto L34;
        String r28 = r15.getValue();
    L35:
        String r29 = r27.append(r28).append("')").toString();
        StringBuilder r30 = new StringBuilder(" AND (").append(r2).append("='");
        if (r15 == null) goto L38;
        Integer r110 = Integer.valueOf(r15.getType());
    L39:
        r30.append(r110).append("')").toString();
        if (r3 == null) goto L46;
        StringBuilder r4 = new StringBuilder().append(r29).append(" AND (").append(r2).append("='");
        if (r15 == null) goto L44;
        String r31 = r15.getLabel();
    L45:
        r29 = r4.append(r31).append("')").toString();
        goto L46
    L44:
        r31 = null;
    L46:
        r8 = r8 + r18.getContentResolver().update(ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build(), r13, r29, null);
        r7 = r17;
        r5 = false;
        goto L6
    L38:
        r110 = null;
        goto L39
    L34:
        r28 = null;
        goto L35
    L22:
        r24 = null;
        goto L23
    L16:
        Integer r111 = SyncContractKt.getContactTypeDefaultValue().get(r19);
        if (r111 == null) goto L19;
        r9 = r111.intValue();
        goto L19
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#updateContactParams skip, rawId=" + r12 + ", contactsId=" + r20);
        return r5;
    L47:
        if (r8 != 0) goto L55;
        return false;
    L55:
        return true;
    }

    private final boolean insertContactParams(Context r11, String r12, long r13, List<ContactType> r15) {
        if (r12 != null) goto L5;
        return false;
    L5:
        Iterator<T> r16 = r15.iterator();
        long r0 = -1;
    L7:
        if (r16.hasNext() == false) goto L22;
        ContactType r2 = (ContactType) r16.next();
        SyncToLocalUtils r5 = INSTANCE;
        long r6 = r5.getRawContactIdByContactId(r11, r13);
        if (r6 <= 0) goto L10;
        ContentValues r8 = new ContentValues();
        r8.put(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r6));
        r8.put("mimetype", r12);
        r8.put(SyncContractKt.getContactValueColumnName().get(r12), r2.getValue());
        r8.put(SyncContractKt.getContactTypeColumnName().get(r12), Integer.valueOf(r2.getType()));
        String r7 = SyncContractKt.getContactLabelColumnName().get(r12);
        if (r7 == null) goto L19;
        String r9 = r2.getLabel();
        if (r9 != null) goto L17;
        r9 = r5.getLabelByType(r11, r12, r2.getType());
    L17:
        r8.put(r7, r9);
    L19:
        if (r11.getContentResolver().insert(ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build(), r8) != null) goto L7;
        r0 = 0;
        goto L7
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#insertContactParams skip, rawId=" + r6 + ", contactsId=" + r13);
        return false;
    L22:
        if (r0 == 0) goto L31;
        return true;
    L31:
        return false;
    }

    private final boolean deleteContactParams(Context r10, List<Long> r11, String r12) {
        String r9 = "(_id IN " + CollectionsKt.joinToString$default(r11, SimContactsConstants.EMAIL_SEP, "(", ")", 0, null, null, 56, null) + ')';
        if (r10.getContentResolver().delete(ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build(), r9, null) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final long getContactId(Context r16, long r17) {
        String[] r11 = {String.valueOf(r17)};
        Cursor r4 = r16.getContentResolver().query(SyncContractKt.getContactSyncUri(), new String[]{"contact_id"}, "_id = ?", r11, null);
        if (r4 == null) goto L17;
        Cursor r5 = r4;
        Cursor r7 = r5;     // Catch: Throwable -> L11
        if (r7.moveToFirst() == false) goto L8;
        long r8 = r7.getLong(r7.getColumnIndexOrThrow("contact_id"));     // Catch: Throwable -> L11
    L9:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r5, null);
    L19:
        if (r8 >= 0) goto L22;
        return -1;
    L22:
        if (isContactIdValid(r16, r8) == false) goto L24;
        return r8;
    L24:
        long r6 = getContactIdByRawContactId(r16, r8);
        if (r6 <= 0) goto L28;
        ContentValues r0 = new ContentValues();
        r0.put("contact_id", Long.valueOf(r6));
        r16.getContentResolver().update(SyncContractKt.getContactSyncUri(), r0, "_id = ?", r11);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#getContactId migrate contact_id from rawId=" + r8 + " to contactId=" + r6 + " for syncId=" + r17);
        return r6;
    L28:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#getContactId invalid contactId=" + r8 + " for syncId=" + r17);
        return -1;
    L8:
        r8 = -1;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L17:
        r8 = -1;
        goto L19
    }

    @JvmStatic
    public static final long queryContactIdByRawContactId(Context r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Uri r1 = ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r7).buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build();
        Cursor r8 = r6.getContentResolver().query(r1, new String[]{"contact_id"}, null, null, null);
        if (r8 == null) goto L19;
        Cursor r9 = r8;
        Cursor r10 = r9;     // Catch: Throwable -> L14
        if (r10.moveToFirst() == false) goto L12;
        int r11 = r10.getColumnIndex("contact_id");     // Catch: Throwable -> L14
        if (r11 < 0) goto L12;
        long r2 = r10.getLong(r11);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r9, null);
        return r2;
    L12:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r9, null);
        return -1;
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

    private final boolean isContactDeleted(Context r7, long r8) {
        Cursor r6 = r7.getContentResolver().query(ContactsContract.DeletedContacts.CONTENT_URI, new String[]{"contact_id"}, "contact_id = ?", new String[]{String.valueOf(r8)}, null);
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

    private final void notifyCloudDeleteForContact(Context r10, long r11) {
        List<Long> r9 = LocalToSyncUtils.getAllSyncIds(r10, r11);
        if ((!r9.isEmpty()) == false) goto L6;
        r10.getContentResolver().delete(SyncContractKt.getContactSyncUri(), "_id IN (" + CollectionsKt.joinToString$default(r9, SimContactsConstants.EMAIL_SEP, null, null, 0, null, null, 62, null) + ')', null);
        KvSyncManager.INSTANCE.setDeleted(r9, SyncContractKt.TAB_NAME_SYNC);
        return;
    }

    private final void deleteInsertedContact(Context r1, long r2) {
        Uri r0 = ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r2).buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
        r1.getContentResolver().delete(r0, null, null);
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v1 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    private final long insertItem(android.content.Context r27, com.android.contacts.obricsync.contact.ContactSync r28) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0096: MOVE (r14v15 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (1 ??[boolean, int, float, short, byte, char]) A[DECLARE_VAR] in method: com.android.contacts.obricsync.SyncToLocalUtils.insertItem(android.content.Context, com.android.contacts.obricsync.contact.ContactSync):long, file: classes2.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.obricsync.SyncToLocalUtils.insertItem(android.content.Context, com.android.contacts.obricsync.contact.ContactSync):long");
    }

    private final ContentProviderOperation insertContactItemData(Context r1, Long r2, String r3, String r4, Integer r5, String r6) {
        ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build());
        Intrinsics.checkNotNullExpressionValue(r0, "newInsert(sqlUri)");
        ContentValues r7 = new ContentValues();
        r7.put("mimetype", r3);
        r7.put(SyncContractKt.getContactValueColumnName().get(r3), r4);
        if (r5 == null) goto L5;
        int r8 = r5.intValue();
        r7.put(SyncContractKt.getContactTypeColumnName().get(r3), Integer.valueOf(r8));
    L5:
        if (r6 == null) goto L7;
        r7.put(SyncContractKt.getContactLabelColumnName().get(r3), r6);
    L7:
        ContentProviderOperation r9 = r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0).withValues(r7).build();
        Intrinsics.checkNotNullExpressionValue(r9, "contentProviderOperation…ues)\n            .build()");
        return r9;
    }

    private final String getLabelByType(Context r1, String r2, int r3) {
        switch(r2.hashCode()) {
            case -1569536764: goto L29;
            case -1328682538: goto L25;
            case -601229436: goto L22;
            case -213986043: goto L18;
            case 684173810: goto L14;
            case 950831081: goto L10;
            case 1409846529: goto L6;
            default: goto L32;
        };
    L32:
        int r0 = 0;
    L33:
        if (r0 != 0) goto L35;
        return "";
    L35:
        String r4 = r1.getString(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "{\n            context.getString(resId)\n        }");
        return r4;
    L6:
        if (r2.equals("vnd.android.cursor.item/relation") == false) goto L32;
        r0 = ContactsContract.CommonDataKinds.Relation.getTypeLabelResource(r3);
        goto L33
    L10:
        if (r2.equals("vnd.android.cursor.item/im") == false) goto L32;
        r0 = ContactsContract.CommonDataKinds.Im.getTypeLabelResource(r3);
        goto L33
    L14:
        if (r2.equals("vnd.android.cursor.item/phone_v2") == false) goto L32;
        r0 = ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(r3);
        goto L33
    L18:
        if (r2.equals("vnd.android.cursor.item/card_id") == false) goto L32;
        r0 = CardIdDataItem.getTypeLabelResource(r3);
        goto L33
    L22:
        if (r2.equals("vnd.android.cursor.item/postal-address_v2") == false) goto L32;
        r0 = ContactsContract.CommonDataKinds.StructuredPostal.getTypeLabelResource(r3);
        goto L33
    L25:
        if (r2.equals("vnd.android.cursor.item/contact_event") == false) goto L32;
        r0 = ContactsContract.CommonDataKinds.Event.getTypeResource(Integer.valueOf(r3));
        goto L33
    L29:
        if (r2.equals("vnd.android.cursor.item/email_v2") == false) goto L32;
        r0 = ContactsContract.CommonDataKinds.Email.getTypeLabelResource(r3);
        goto L33
    }

    private final List<Long> getRawContactIdsByContactId(Context r7, long r8) {
        ArrayList r6 = new ArrayList();
        String[] r4 = {String.valueOf(r8)};
        Cursor r9 = r7.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id"}, "contact_id = ?", r4, null);
        if (r9 == null) goto L23;
        Cursor r10 = r9;
        Cursor r11 = r10;     // Catch: Throwable -> L18
        if (r11.moveToFirst() == true) goto L10;
        CloseableKt.closeFinally(r10, null);
        return r6;
    L10:
        int r0 = r11.getColumnIndex("_id");     // Catch: Throwable -> L18
        if (r0 < 0) goto L15;
        r6.add(Long.valueOf(r11.getLong(r0)));     // Catch: Throwable -> L18
    L15:
        if (r11.moveToNext() == true) goto L10;
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r10, null);
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L23:
        return r6;
    }

    private final boolean isContactIdValid(Context r8, long r9) {
        if (r9 >= 0) goto L5;
        return false;
    L5:
        Cursor r7 = r8.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"_id"}, "_id = ?", new String[]{String.valueOf(r9)}, null);
        if (r7 == null) goto L16;
        Cursor r10 = r7;
        boolean r11 = r10.moveToFirst();     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r10, null);
        return r11;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L16:
        return false;
    }

    private final long getContactIdByRawContactId(Context r9, long r10) {
        if (r10 >= 0) goto L5;
        return -1;
    L5:
        Uri r3 = ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r10).buildUpon().appendQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER, "true").build();
        Cursor r11 = r9.getContentResolver().query(r3, new String[]{"contact_id"}, null, null, null);
        if (r11 == null) goto L22;
        Cursor r12 = r11;
        Cursor r13 = r12;     // Catch: Throwable -> L17
        if (r13.moveToFirst() == false) goto L15;
        int r8 = r13.getColumnIndex("contact_id");     // Catch: Throwable -> L17
        if (r8 < 0) goto L15;
        long r14 = r13.getLong(r8);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r12, null);
        return r14;
    L15:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r12, null);
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L22:
        return -1;
    }

    private final long getRawContactIdByContactId(Context r13, long r14) {
        long r4 = -1;
        if (r14 >= 0) goto L5;
        return -1;
    L5:
        Cursor r6 = r13.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"name_raw_contact_id"}, "_id = ?", new String[]{String.valueOf(r14)}, null);
        if (r6 == null) goto L25;
        Cursor r7 = r6;
        Cursor r8 = r7;     // Catch: Throwable -> L20
        if (r8.moveToFirst() == false) goto L18;
        int r3 = r8.getColumnIndex("name_raw_contact_id");     // Catch: Throwable -> L20
        if (r3 < 0) goto L17;
        long r9 = r8.getLong(r3);     // Catch: Throwable -> L20
        if (r9 <= 0) goto L18;
        CloseableKt.closeFinally(r7, null);
        return r9;
    L17:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#getRawContactIdByContactId fail, index < 0，contactId = " + r14);     // Catch: Throwable -> L20
    L18:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r7, null);
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L25:
        Long r12 = (Long) CollectionsKt.firstOrNull(getRawContactIdsByContactId(r13, r14));
        if (r12 == null) goto L28;
        r4 = r12.longValue();
    L28:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SyncToLocalUtils#getRawContactIdByContactId fallback rawId=" + r4 + ", contactId=" + r14);
        return r4;
    }

    private final Long getContactIdByData(Context r19, ContactSync r20) {
        String r1 = TAG;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r1, "SyncToLocalUtils#getContactIdByData start");
        ArrayList r2 = new ArrayList();
        String r7 = getContactName(r20);
        boolean r10 = true;
        if (r7.length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L11;
        String r6 = SyncContractKt.getContactMap().get("name");
        if (r6 == null) goto L10;
        r2.addAll(INSTANCE.getRawContactsIds(r19, r6, r7, null, null));
    L10:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L19;
        if (r2.isEmpty() == false) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r1, "SyncToLocalUtils#getContactIdByData after name");
        return null;
    L19:
        if (r20.getCompany().length() <= 0) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L27;
        String r14 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_COMPANY);
        if (r14 == null) goto L26;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r14, r20.getCompany(), null, null)));
    L26:
        boolean r9 = true;
    L28:
        if (r9 == false) goto L34;
        if (r2.isEmpty() == false) goto L34;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r1, "SyncToLocalUtils#getContactIdByData after company");
        return null;
    L34:
        if (r20.getNote().length() <= 0) goto L36;
        boolean r11 = true;
    L37:
        if (r11 == false) goto L42;
        String r15 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_NOTE);
        if (r15 == null) goto L41;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r15, r20.getNote(), null, null)));
    L41:
        boolean r12 = true;
    L43:
        if (r12 == true) goto L45;
    L48:
        ContactParamList r3 = r20.getPhoneNumber();
        if (r3 == null) goto L59;
        List<ContactType> r13 = r3.getList();
        if (r13 == null) goto L59;
        Iterator<T> r16 = r13.iterator();
        boolean r17 = false;
    L54:
        if (r16.hasNext() == false) goto L60;
        ContactType r18 = (ContactType) r16.next();
        String r110 = FormatPhoneNumberUtil.Companion.format(r18.getValue());
        String r111 = SyncContractKt.getContactMap().get("phone_number");
        if (r111 == null) goto L58;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r111, r110, Integer.valueOf(r18.getType()), r18.getLabel())));
    L58:
        r17 = true;
    L60:
        if (r17 == true) goto L62;
    L65:
        ContactParamList r21 = r20.getEmail();
        if (r21 == null) goto L76;
        List<ContactType> r22 = r21.getList();
        if (r22 == null) goto L76;
        Iterator<T> r23 = r22.iterator();
        boolean r24 = false;
    L71:
        if (r23.hasNext() == false) goto L77;
        ContactType r25 = (ContactType) r23.next();
        String r112 = SyncContractKt.getContactMap().get("email");
        if (r112 == null) goto L75;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r112, r25.getValue(), Integer.valueOf(r25.getType()), r25.getLabel())));
    L75:
        r24 = true;
    L77:
        if (r24 == false) goto L83;
        if (r2.isEmpty() == false) goto L83;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#getContactIdByData after email");
        return null;
    L83:
        if (r20.getNickname().length() <= 0) goto L85;
        boolean r26 = true;
    L86:
        if (r26 == false) goto L91;
        String r113 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_NICK_NAME);
        if (r113 == null) goto L90;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r113, r20.getNickname(), null, null)));
    L90:
        boolean r27 = true;
    L92:
        if (r27 == true) goto L94;
    L97:
        ContactParamList r28 = r20.getIdCards();
        if (r28 == null) goto L108;
        List<ContactType> r29 = r28.getList();
        if (r29 == null) goto L108;
        Iterator<T> r30 = r29.iterator();
        boolean r31 = false;
    L103:
        if (r30.hasNext() == false) goto L109;
        ContactType r32 = (ContactType) r30.next();
        String r114 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_ID_CARDS);
        if (r114 == null) goto L107;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r114, r32.getValue(), Integer.valueOf(r32.getType()), r32.getLabel())));
    L107:
        r31 = true;
    L109:
        if (r31 == true) goto L111;
    L114:
        ContactParamList r33 = r20.getIm();
        if (r33 == null) goto L125;
        List<ContactType> r34 = r33.getList();
        if (r34 == null) goto L125;
        Iterator<T> r35 = r34.iterator();
        boolean r36 = false;
    L120:
        if (r35.hasNext() == false) goto L126;
        ContactType r37 = (ContactType) r35.next();
        String r115 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_IM);
        if (r115 == null) goto L124;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r115, r37.getValue(), Integer.valueOf(r37.getType()), r37.getLabel())));
    L124:
        r36 = true;
    L126:
        if (r36 == false) goto L132;
        if (r2.isEmpty() == false) goto L132;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#getContactIdByData after im");
        return null;
    L132:
        if (r20.getWebsite().length() <= 0) goto L134;
        boolean r38 = true;
    L135:
        if (r38 == false) goto L140;
        String r116 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_WEBSITE);
        if (r116 == null) goto L139;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r116, r20.getWebsite(), null, null)));
    L139:
        boolean r39 = true;
    L141:
        if (r39 == true) goto L143;
    L146:
        ContactParamList r40 = r20.getBirthdayData();
        if (r40 == null) goto L157;
        List<ContactType> r41 = r40.getList();
        if (r41 == null) goto L157;
        Iterator<T> r42 = r41.iterator();
        boolean r43 = false;
    L152:
        if (r42.hasNext() == false) goto L158;
        ContactType r44 = (ContactType) r42.next();
        String r117 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_BIRTHDAY);
        if (r117 == null) goto L156;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r117, r44.getValue(), Integer.valueOf(r44.getType()), r44.getLabel())));
    L156:
        r43 = true;
    L158:
        if (r43 == true) goto L160;
    L163:
        ContactParamList r45 = r20.getAddress();
        if (r45 == null) goto L174;
        List<ContactType> r46 = r45.getList();
        if (r46 == null) goto L174;
        Iterator<T> r47 = r46.iterator();
        boolean r48 = false;
    L169:
        if (r47.hasNext() == false) goto L175;
        ContactType r49 = (ContactType) r47.next();
        String r118 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_ADDRESS);
        if (r118 == null) goto L173;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r118, r49.getValue(), Integer.valueOf(r49.getType()), r49.getLabel())));
    L173:
        r48 = true;
    L175:
        if (r48 == false) goto L181;
        if (r2.isEmpty() == false) goto L181;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#getContactIdByData after address");
        return null;
    L181:
        if (r20.getIntelAddress().length() <= 0) goto L183;
        boolean r50 = true;
    L184:
        if (r50 == false) goto L189;
        String r119 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_INTER_ADDRESS);
        if (r119 == null) goto L188;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r119, r20.getIntelAddress(), null, null)));
    L188:
        boolean r51 = true;
    L190:
        if (r51 == true) goto L192;
    L195:
        ContactParamList r52 = r20.getRelation();
        if (r52 == null) goto L206;
        List<ContactType> r53 = r52.getList();
        if (r53 == null) goto L206;
        Iterator<T> r54 = r53.iterator();
        boolean r55 = false;
    L201:
        if (r54.hasNext() == false) goto L207;
        ContactType r56 = (ContactType) r54.next();
        String r120 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_RELATION);
        if (r120 == null) goto L205;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r120, r56.getValue(), Integer.valueOf(r56.getType()), r56.getLabel())));
    L205:
        r55 = true;
    L207:
        if (r55 == false) goto L213;
        if (r2.isEmpty() == false) goto L213;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#getContactIdByData after relation");
        return null;
    L213:
        if (r20.getGenderCode() <= 0) goto L217;
        String r121 = SyncContractKt.getContactMap().get(SyncContractKt.COLUMN_GENDER);
        if (r121 == null) goto L217;
        r2.retainAll(CollectionsKt.toSet(INSTANCE.getRawContactsIds(r19, r121, String.valueOf(r20.getGenderCode()), null, null)));
    L217:
        Long r57 = (Long) CollectionsKt.getOrNull(r2, 0);
        if (r57 == null) goto L247;
        long r58 = r57.longValue();
        long r59 = getContactIdByRawContactId(r19, r58);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#getContactIdByData: rawContactId=" + r58 + ", contactId=" + r59);
        Long r0 = Long.valueOf(r59);
        if (r0.longValue() > 0) goto L223;
        r10 = false;
    L223:
        if (r10 == true) goto L225;
        return null;
    L225:
        return r0;
    L247:
        return null;
    L206:
        r55 = false;
        goto L207
    L192:
        if (r2.isEmpty() == false) goto L195;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#getContactIdByData after intelAddress");
        return null;
    L189:
        r51 = false;
        goto L190
    L183:
        r50 = false;
    L174:
        r48 = false;
        goto L175
    L160:
        if (r2.isEmpty() == false) goto L163;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#getContactIdByData after birthday");
        return null;
    L157:
        r43 = false;
        goto L158
    L143:
        if (r2.isEmpty() == false) goto L146;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#getContactIdByData after website");
        return null;
    L140:
        r39 = false;
        goto L141
    L134:
        r38 = false;
    L125:
        r36 = false;
        goto L126
    L111:
        if (r2.isEmpty() == false) goto L114;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#getContactIdByData after idCards");
        return null;
    L108:
        r31 = false;
        goto L109
    L94:
        if (r2.isEmpty() == false) goto L97;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#getContactIdByData after nickname");
        return null;
    L91:
        r27 = false;
        goto L92
    L85:
        r26 = false;
    L76:
        r24 = false;
        goto L77
    L62:
        if (r2.isEmpty() == false) goto L65;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SyncToLocalUtils#getContactIdByData after phone");
        return null;
    L59:
        r17 = false;
        goto L60
    L45:
        if (r2.isEmpty() == false) goto L48;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r1, "SyncToLocalUtils#getContactIdByData after note");
        return null;
    L42:
        r12 = false;
        goto L43
    L36:
        r11 = false;
        goto L37
    L27:
        r9 = false;
        goto L28
    L21:
        r8 = false;
        goto L22
    L11:
        r5 = false;
        goto L13
    L5:
        r4 = false;
        goto L6
    }

    private final List<Long> getRawContactsIds(Context r8, String r9, String r10, Integer r11, String r12) {
        ArrayList r7 = new ArrayList();
        ArrayList r0 = new ArrayList();
        r0.add(r9);
        r0.add(r10);
        StringBuilder r13 = new StringBuilder("mimetype=?");
        r13.append(" and " + SyncContractKt.getContactValueColumnName().get(r9) + "=?");
        if (r11 == null) goto L5;
        int r14 = r11.intValue();
        r13.append(" and " + SyncContractKt.getContactTypeColumnName().get(r9) + "=?");
        r0.add(String.valueOf(r14));
    L5:
        if (r12 == null) goto L7;
        r13.append(" and " + SyncContractKt.getContactLabelColumnName().get(r9) + "=?");
        r0.add(r12);
    L7:
        Cursor r15 = r8.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{GroupSelectionActivity.EXTRA_RAW_CONTACT_ID}, r13.toString(), (String[]) r0.toArray(new String[r0.size()]), null);
        if (r15 == null) goto L25;
        Cursor r16 = r15;
        Cursor r17 = r16;     // Catch: Throwable -> L19
        if (r15.moveToFirst() == false) goto L17;
    L12:
        long r18 = r15.getLong(0);     // Catch: Throwable -> L19
        if (r7.contains(Long.valueOf(r18)) == true) goto L16;
        r7.add(Long.valueOf(r18));     // Catch: Throwable -> L19
    L16:
        if (r15.moveToNext() == true) goto L12;
    L17:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r16, null);
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);
        throw th;
    L25:
        return r7;
    }
}
