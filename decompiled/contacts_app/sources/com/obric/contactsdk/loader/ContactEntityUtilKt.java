package com.obric.contactsdk.loader;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.callandsms.common.Logger;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.capabilitykit.entity.enums.GenderEnum;
import com.obric.capabilitykit.entity.meta.MetaAddress;
import com.obric.capabilitykit.entity.meta.MetaAnniversary;
import com.obric.capabilitykit.entity.meta.MetaCredentialNumber;
import com.obric.capabilitykit.entity.meta.MetaEmailAddress;
import com.obric.capabilitykit.entity.meta.MetaInstantMessaging;
import com.obric.capabilitykit.entity.meta.MetaRelationship;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.capabilitykit.sync.EntityIdData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactEntityUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a,\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f\u001a\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000b2\u0006\u0010\r\u001a\u00020\u000e\u001a4\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f\u001a\u0010\u0010$\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u001a,\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010 \u001a\u00020\u001f¨\u0006("}, d2 = {"addressTypeToDesc", "", "cursor", "Landroid/database/Cursor;", "cardTypeToDesc", "dateTypeToDesc", "emailTypeToDesc", "genderTypeToDesc", "Lcom/obric/capabilitykit/entity/enums/GenderEnum;", "value", "getAllContactIds", "", "", "context", "Landroid/content/Context;", "getAllIds", "uri", "Landroid/net/Uri;", "getContactIdByPhoneNumber", "contentResolver", "Landroid/content/ContentResolver;", "phoneNumber", "getProfileContactsId", "ids", "getProfileId", "imTypeToDesc", "phoneTypeToDesc", "queryContactById", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "id", "isProfile", "", "isRawId", "queryContactSampleEntities", "Lcom/obric/capabilitykit/sync/EntityIdData;", "queryContactsByIds", "relationShipsTypeToDesc", "updateContactsListEntitiesQueryByIds", "contactHistoryEntities", "updateRawId2ContactsIdIdsList", "contactsdk_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContactEntityUtilKt {
    public static final List<Long> getAllContactIds(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Uri r0 = ContactsContract.Contacts.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(r0, "CONTENT_URI");
        return getAllIds(r2, r0);
    }

    public static final List<EntityIdData> queryContactSampleEntities(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        ArrayList r0 = new ArrayList();
        Uri r2 = ContactsContract.Contacts.CONTENT_URI;
        Cursor r1 = r9.getContentResolver().query(r2, new String[]{"_id", "contact_last_updated_timestamp"}, null, null, null);
        if (r1 == null) goto L18;
        Cursor r3 = r1;
        Cursor r4 = r3;     // Catch: Throwable -> L13
        int r10 = r4.getColumnIndex("_id");     // Catch: Throwable -> L13
        int r5 = r4.getColumnIndex("contact_last_updated_timestamp");     // Catch: Throwable -> L13
        if (r10 == (-1)) goto L11;
        if (r5 == (-1)) goto L11;
    L9:
        if (r4.moveToNext() == false) goto L11;
        long r6 = r4.getLong(r10);     // Catch: Throwable -> L13
        long r7 = r4.getLong(r5);     // Catch: Throwable -> L13
        r0.add(new EntityIdData(String.valueOf(r6), 201, r7));     // Catch: Throwable -> L13
    L11:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r3, null);
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L18:
        return r0;
    }

    public static final List<Long> getProfileId(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Uri r0 = ContactsContract.Profile.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(r0, "CONTENT_URI");
        return getAllIds(r2, r0);
    }

    public static final List<Long> getAllIds(Context r7, Uri r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "uri");
        ArrayList r0 = new ArrayList();
        Cursor r9 = r7.getContentResolver().query(r8, new String[]{"_id"}, null, null, null);
        if (r9 == null) goto L18;
        Cursor r1 = r9;
        Cursor r2 = r1;     // Catch: Throwable -> L13
    L7:
        if (r9.moveToNext() == false) goto L11;
        int r3 = r9.getColumnIndex("_id");     // Catch: Throwable -> L13
        if (r3 == (-1)) goto L7;
        r0.add(Long.valueOf(r9.getLong(r3)));     // Catch: Throwable -> L13
        goto L7
    L11:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r1, null);
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L18:
        return r0;
    }

    public static final String getContactIdByPhoneNumber(ContentResolver r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "contentResolver");
        Intrinsics.checkNotNullParameter(r10, "phoneNumber");
        Uri r3 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(r10));
        Intrinsics.checkNotNullExpressionValue(r3, "withAppendedPath(\n      …encode(phoneNumber)\n    )");
        String r1 = null;
        Cursor r11 = r9.query(r3, new String[]{"_id"}, null, null, null);     // Catch: Throwable -> L27
        if (r11 != null) goto L40;
    L25:
        if (r11 == null) goto L54;
        r11.close();
        return r1;
    L54:
        return r1;
    L40:
        Cursor r2 = r11;     // Catch: Throwable -> L23
        Cursor r4 = r2;     // Catch: Throwable -> L18
        if (r11.moveToFirst() == false) goto L10;
        String r12 = CallHistoryEntityUtilKt.safeGetColumn(r11, "_id");     // Catch: Throwable -> L18
    L44:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L14
        r1 = r12;
    L14:
        Object th = th;
    L48:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ContactEntityUtilKt", "getContactIdByPhoneNumber err = " + th);     // Catch: Throwable -> L35
        if (r11 == null) goto L34;
        r11.close();
    L34:
        return r12;
    L35:
        th = move-exception;
        if (r11 == null) goto L39;
        r11.close();
    L39:
        throw th;
    L16:
        th = move-exception;
        r1 = r12;
        th = th;
    L50:
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L10:
        r12 = null;
    L18:
        th = th;
    L23:
        th = move-exception;
        String r8 = r1;
        th = th;
        r12 = r8;
    L27:
        th = move-exception;
        r12 = null;
        th = th;
        r11 = null;
        goto L48
    }

    public static /* synthetic */ List queryContactsByIds$default(ContentResolver r0, List r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r2 = false;
    L6:
        return queryContactsByIds(r0, r1, r2, r3);
    }

    public static final List<ContactEntity> queryContactsByIds(ContentResolver r30, List<Long> r31, boolean r32, boolean r33) {
        Intrinsics.checkNotNullParameter(r30, "contentResolver");
        Intrinsics.checkNotNullParameter(r31, "ids");
        List<Long> r7 = updateRawId2ContactsIdIdsList(r30, r31, r33);
        Logger.INSTANCE.d("ContactEntityUtilKt", "queryContactsByIds ids size: " + r31.size() + ", updatedIds size: " + r7.size());
        String r9 = CollectionsKt.joinToString$default(r7, SimContactsConstants.EMAIL_SEP, "(", ")", 0, null, null, 56, null);
        LinkedHashMap r10 = new LinkedHashMap();
        String r4 = "_id IN " + r9;
        if (r32 == false) goto L5;
        Uri r1 = ContactsContract.Profile.CONTENT_URI;
    L6:
        Cursor r2 = r30.query(r1, new String[]{"_id", "photo_uri", "lookup", "contact_last_updated_timestamp"}, r4, null, null);
        if (r2 == null) goto L25;
        Cursor r3 = r2;
        Cursor r5 = r3;     // Catch: Throwable -> L19
    L11:
        if (r5.moveToNext() == false) goto L17;
        long r6 = r5.getLong(r5.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L19
        String r8 = r5.getString(r5.getColumnIndexOrThrow("photo_uri"));     // Catch: Throwable -> L19
        String r11 = r5.getString(r5.getColumnIndexOrThrow("lookup"));     // Catch: Throwable -> L19
        long r28 = r5.getLong(r5.getColumnIndexOrThrow("contact_last_updated_timestamp"));     // Catch: Throwable -> L19
        if (r8 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r8, "photoUri");     // Catch: Throwable -> L19
        Uri r0 = Uri.parse(r8);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r0, "parse(photoPath)");     // Catch: Throwable -> L19
        FileEntity r15 = new FileEntity(r8, 0, 0, r8, 0, r0, FileTypeEnum.FILE, "image/jpeg");     // Catch: Throwable -> L19
    L16:
        Uri r12 = ContactsContract.Contacts.getLookupUri(r6, r11);     // Catch: Throwable -> L19
        ContactEntity r13 = new ContactEntity(String.valueOf(r6), r28, r28, "", null);     // Catch: Throwable -> L19
        r13.setAvatar(r15);     // Catch: Throwable -> L19
        r13.addExtraEntity(new ExtraEntity("extra1", r12, false, 4, null));     // Catch: Throwable -> L19
        r10.put(Long.valueOf(r6), r13);     // Catch: Throwable -> L19
        r5 = r5;
        goto L11
    L15:
        r15 = null;
        goto L16
    L17:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r3, null);
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L25:
        String r16 = "contact_id IN " + r9;
        if (r32 == false) goto L28;
        Cursor r17 = r30.query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), ContractKt.getCONTACT_DATA_PROJECTION(), null, null, null);
    L29:
        if (r17 == null) goto L135;
        Cursor r18 = r17;
        Cursor r19 = r18;     // Catch: Throwable -> L129
    L33:
        if (r19.moveToNext() == false) goto L127;
        ContactEntity r20 = (ContactEntity) r10.get(Long.valueOf(r19.getLong(r19.getColumnIndexOrThrow("contact_id"))));     // Catch: Throwable -> L129
        String r21 = r19.getString(r19.getColumnIndexOrThrow("mimetype"));     // Catch: Throwable -> L129
        String r22 = r19.getString(r19.getColumnIndexOrThrow("data1"));     // Catch: Throwable -> L129
        if (r22 == null) goto L33;
        if (r20 == null) goto L33;
        if (r21 == null) goto L33;
        String r23 = "";
        switch(r21.hashCode()) {
            case -1569536764: goto L121;
            case -1328682538: goto L110;
            case -1079224304: goto L106;
            case -1079210633: goto L102;
            case -601229436: goto L95;
            case -213986043: goto L84;
            case 3430506: goto L80;
            case 684173810: goto L73;
            case 689862072: goto L69;
            case 950831081: goto L58;
            case 1409846529: goto L47;
            case 2050851590: goto L43;
            default: goto L33;
        };
    L43:
        if (r21.equals("vnd.android.cursor.item/gender") == false) goto L33;
        r20.setGender(genderTypeToDesc(r22));     // Catch: Throwable -> L129
        goto L33
    L47:
        if (r21.equals("vnd.android.cursor.item/relation") == false) goto L33;
        List<MetaRelationship> r24 = r20.getRelationShips();     // Catch: Throwable -> L129
        if (r24 != null) goto L52;
        r24 = CollectionsKt.emptyList();     // Catch: Throwable -> L129
    L52:
        List<MetaRelationship> r25 = CollectionsKt.toMutableList(r24);     // Catch: Throwable -> L129
        String r110 = relationShipsTypeToDesc(r17);     // Catch: Throwable -> L129
        if (r110 == null) goto L56;
        r23 = r110;
    L56:
        r25.add(new MetaRelationship(r23, r22));     // Catch: Throwable -> L129
        r20.setRelationShips(r25);     // Catch: Throwable -> L129
        goto L33
    L58:
        if (r21.equals("vnd.android.cursor.item/im") == false) goto L33;
        List<MetaInstantMessaging> r26 = r20.getInstantMessagings();     // Catch: Throwable -> L129
        if (r26 != null) goto L63;
        r26 = CollectionsKt.emptyList();     // Catch: Throwable -> L129
    L63:
        List<MetaInstantMessaging> r27 = CollectionsKt.toMutableList(r26);     // Catch: Throwable -> L129
        String r111 = imTypeToDesc(r17);     // Catch: Throwable -> L129
        if (r111 == null) goto L67;
        r23 = r111;
    L67:
        r27.add(new MetaInstantMessaging(r23, r22));     // Catch: Throwable -> L129
        r20.setInstantMessagings(r27);     // Catch: Throwable -> L129
        goto L33
    L69:
        if (r21.equals("vnd.android.cursor.item/organization") == false) goto L33;
        r20.setCompany(r22);     // Catch: Throwable -> L129
        goto L33
    L73:
        if (r21.equals("vnd.android.cursor.item/phone_v2") == false) goto L33;
        List<MetaTelephone> r29 = r20.getTelephones();     // Catch: Throwable -> L129
        if (r29 != null) goto L78;
        r29 = CollectionsKt.emptyList();     // Catch: Throwable -> L129
    L78:
        List<MetaTelephone> r34 = CollectionsKt.toMutableList(r29);     // Catch: Throwable -> L129
        r34.add(new MetaTelephone(r22, phoneTypeToDesc(r17)));     // Catch: Throwable -> L129
        r20.setTelephones(r34);     // Catch: Throwable -> L129
        goto L33
    L80:
        if (r21.equals("vnd.android.cursor.item/sip_address") == false) goto L33;
        r20.setVoip(r22);     // Catch: Throwable -> L129
        goto L33
    L84:
        if (r21.equals("vnd.android.cursor.item/card_id") == false) goto L33;
        List<MetaCredentialNumber> r35 = r20.getCredentialNumbers();     // Catch: Throwable -> L129
        if (r35 != null) goto L89;
        r35 = CollectionsKt.emptyList();     // Catch: Throwable -> L129
    L89:
        List<MetaCredentialNumber> r36 = CollectionsKt.toMutableList(r35);     // Catch: Throwable -> L129
        String r112 = cardTypeToDesc(r17);     // Catch: Throwable -> L129
        if (r112 == null) goto L93;
        r23 = r112;
    L93:
        r36.add(new MetaCredentialNumber(r22, r23));     // Catch: Throwable -> L129
        r20.setCredentialNumbers(r36);     // Catch: Throwable -> L129
        goto L33
    L95:
        if (r21.equals("vnd.android.cursor.item/postal-address_v2") == false) goto L33;
        List<MetaAddress> r37 = r20.getAddresses();     // Catch: Throwable -> L129
        if (r37 != null) goto L100;
        r37 = CollectionsKt.emptyList();     // Catch: Throwable -> L129
    L100:
        List<MetaAddress> r38 = CollectionsKt.toMutableList(r37);     // Catch: Throwable -> L129
        r38.add(new MetaAddress(r22, addressTypeToDesc(r17)));     // Catch: Throwable -> L129
        r20.setAddresses(r38);     // Catch: Throwable -> L129
        goto L33
    L102:
        if (r21.equals("vnd.android.cursor.item/note") == false) goto L33;
        r20.setNote(r22);     // Catch: Throwable -> L129
        goto L33
    L106:
        if (r21.equals("vnd.android.cursor.item/name") == false) goto L33;
        r20.setName(r22);     // Catch: Throwable -> L129
        goto L33
    L110:
        if (r21.equals("vnd.android.cursor.item/contact_event") == false) goto L33;
        List<MetaAnniversary> r39 = r20.getAnniversaries();     // Catch: Throwable -> L129
        if (r39 != null) goto L115;
        r39 = CollectionsKt.emptyList();     // Catch: Throwable -> L129
    L115:
        List<MetaAnniversary> r40 = CollectionsKt.toMutableList(r39);     // Catch: Throwable -> L129
        String r113 = dateTypeToDesc(r17);     // Catch: Throwable -> L129
        if (r113 == null) goto L119;
        r23 = r113;
    L119:
        r40.add(new MetaAnniversary(r23, r22));     // Catch: Throwable -> L129
        r20.setAnniversaries(r40);     // Catch: Throwable -> L129
        goto L33
    L121:
        if (r21.equals("vnd.android.cursor.item/email_v2") == false) goto L33;
        List<MetaEmailAddress> r41 = r20.getEmails();     // Catch: Throwable -> L129
        if (r41 != null) goto L126;
        r41 = CollectionsKt.emptyList();     // Catch: Throwable -> L129
    L126:
        List<MetaEmailAddress> r42 = CollectionsKt.toMutableList(r41);     // Catch: Throwable -> L129
        r42.add(new MetaEmailAddress(r22, emailTypeToDesc(r17)));     // Catch: Throwable -> L129
        r20.setEmails(r42);     // Catch: Throwable -> L129
        goto L33
    L127:
        Unit r43 = Unit.INSTANCE;     // Catch: Throwable -> L129
        CloseableKt.closeFinally(r18, null);
    L129:
        th = move-exception;
        throw th;     // Catch: Throwable -> L132
    L132:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);
        throw th;
    L135:
        List<ContactEntity> r44 = updateContactsListEntitiesQueryByIds(CollectionsKt.toList(r10.values()), r7);
        Logger.INSTANCE.d("ContactEntityUtilKt", "queryContactsByIds return list size: " + r44.size());
        return r44;
    L28:
        r17 = r30.query(ContactsContract.Data.CONTENT_URI, ContractKt.getCONTACT_DATA_PROJECTION(), r16, null, null);
        goto L29
    L5:
        r1 = ContactsContract.Contacts.CONTENT_URI;
        goto L6
    }

    public static /* synthetic */ List updateRawId2ContactsIdIdsList$default(ContentResolver r0, List r1, boolean r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = true;
    L6:
        return updateRawId2ContactsIdIdsList(r0, r1, r2);
    }

    public static final List<Long> updateRawId2ContactsIdIdsList(ContentResolver r10, List<Long> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "contentResolver");
        Intrinsics.checkNotNullParameter(r11, "ids");
        if (r12 == true) goto L5;
        return r11;
    L5:
        Cursor r13 = r10.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"contact_id"}, "_id IN " + CollectionsKt.joinToString$default(r11, SimContactsConstants.EMAIL_SEP, "(", ")", 0, null, null, 56, null), null, null);
        ArrayList r14 = new ArrayList();
        if (r13 == null) goto L21;
        Cursor r15 = r13;
        Cursor r0 = r15;     // Catch: Throwable -> L16
    L10:
        if (r0.moveToNext() == false) goto L14;
        long r1 = r0.getLong(r0.getColumnIndexOrThrow("contact_id"));     // Catch: Throwable -> L16
        if (r14.contains(Long.valueOf(r1)) == true) goto L10;
        r14.add(Long.valueOf(r1));     // Catch: Throwable -> L16
        goto L10
    L14:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r15, null);
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    L21:
        return r14;
    }

    public static final List<ContactEntity> updateContactsListEntitiesQueryByIds(List<ContactEntity> r7, List<Long> r8) {
        Intrinsics.checkNotNullParameter(r7, "contactHistoryEntities");
        Intrinsics.checkNotNullParameter(r8, "ids");
        ArrayList r0 = new ArrayList();
        Iterator<Long> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L13;
        long r1 = r9.next().longValue();
        Iterator<ContactEntity> r3 = r7.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        ContactEntity r4 = r3.next();
        if (TextUtils.equals(String.valueOf(r1), r4.getId()) == false) goto L7;
        if (r0.contains(r4) == true) goto L7;
        r0.add(r4);
        goto L7
    L13:
        return r0;
    }

    public static final String getProfileContactsId(Context r11, List<Long> r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "ids");
        Cursor r13 = r11.getContentResolver().query(ContactsContract.Profile.CONTENT_URI, new String[]{"_id"}, "name_raw_contact_id IN " + CollectionsKt.joinToString$default(r12, SimContactsConstants.EMAIL_SEP, "(", ")", 0, null, null, 56, null), null, null);     // Catch: SecurityException -> L25
        if (r13 == null) goto L27;
        Cursor r14 = r13;     // Catch: SecurityException -> L25
        Cursor r2 = r14;     // Catch: Throwable -> L20
        if (r2.moveToFirst() == true) goto L10;
        CloseableKt.closeFinally(r14, null);     // Catch: SecurityException -> L25
        return null;
    L10:
        long r3 = r2.getLong(r2.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L20
        if (r12.contains(Long.valueOf(r3)) == true) goto L12;
        if (r2.moveToNext() == true) goto L10;
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r14, null);     // Catch: SecurityException -> L25
        goto L27
    L12:
        String r16 = String.valueOf(r3);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r14, null);     // Catch: SecurityException -> L25
        return r16;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: SecurityException -> L25
        throw th;     // Catch: SecurityException -> L25
    L27:
        return null;
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L27
    }

    public static /* synthetic */ ContactEntity queryContactById$default(ContentResolver r1, long r2, boolean r4, boolean r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = false;
    L9:
        return queryContactById(r1, r2, r4, r5);
    }

    public static final ContactEntity queryContactById(ContentResolver r1, long r2, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "contentResolver");
        List<ContactEntity> r3 = queryContactsByIds(r1, CollectionsKt.listOf(Long.valueOf(r2)), r4, r5);
        if ((!r3.isEmpty()) == true) goto L5;
        return null;
    L5:
        return r3.get(0);
    }

    public static final GenderEnum genderTypeToDesc(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r2, "1") == false) goto L9;
        return GenderEnum.MALE;
    L9:
        if (Intrinsics.areEqual(r2, "2") == true) goto L11;
        return null;
    L11:
        return GenderEnum.FEMALE;
    }

    public static final String cardTypeToDesc(Cursor r1) {
        Intrinsics.checkNotNullParameter(r1, "cursor");
        String r2 = r1.getString(r1.getColumnIndexOrThrow(DBHelper.COL_DATA2));
        if (r2 != null) goto L5;
    L19:
        return null;
    L5:
        switch(r2.hashCode()) {
            case 49: goto L16;
            case 50: goto L12;
            case 51: goto L8;
            default: goto L19;
        };
    L8:
        if (r2.equals("3") == false) goto L19;
        return "驾驶证";
    L12:
        if (r2.equals("2") == false) goto L19;
        return "银行卡";
    L16:
        if (r2.equals("1") == false) goto L19;
        return "身份证";
    }

    public static final String emailTypeToDesc(Cursor r2) {
        Intrinsics.checkNotNullParameter(r2, "cursor");
        String r0 = r2.getString(r2.getColumnIndexOrThrow(DBHelper.COL_DATA2));
        if (r0 != null) goto L5;
    L23:
        return null;
    L5:
        switch(r0.hashCode()) {
            case 48: goto L20;
            case 49: goto L16;
            case 50: goto L12;
            case 51: goto L8;
            default: goto L23;
        };
    L8:
        if (r0.equals("3") == false) goto L23;
        return "其他";
    L12:
        if (r0.equals("2") == false) goto L23;
        return "工作";
    L16:
        if (r0.equals("1") == false) goto L23;
        return "个人";
    L20:
        if (r0.equals("0") == false) goto L23;
        return r2.getString(r2.getColumnIndexOrThrow(DBHelper.COL_DATA3));
    }

    public static final String phoneTypeToDesc(Cursor r3) {
        Intrinsics.checkNotNullParameter(r3, "cursor");
        String r0 = r3.getString(r3.getColumnIndexOrThrow(DBHelper.COL_DATA2));
        if (r0 == null) goto L32;
        int r1 = r0.hashCode();
        if (r1 == 55) goto L29;
        switch(r1) {
            case 48: goto L25;
            case 49: goto L21;
            case 50: goto L17;
            case 51: goto L13;
            case 52: goto L9;
            default: goto L32;
        };
    L9:
        if (r0.equals("4") == false) goto L32;
        return "传真";
    L13:
        if (r0.equals("3") == false) goto L32;
        return "工作";
    L17:
        if (r0.equals("2") == false) goto L32;
        return "电话";
    L21:
        if (r0.equals("1") == false) goto L32;
        return "住宅";
    L25:
        if (r0.equals("0") == false) goto L32;
        return r3.getString(r3.getColumnIndexOrThrow(DBHelper.COL_DATA3));
    L29:
        if (r0.equals("7") == false) goto L32;
        return "其他";
    L32:
        return null;
    }

    public static final String addressTypeToDesc(Cursor r2) {
        Intrinsics.checkNotNullParameter(r2, "cursor");
        String r0 = r2.getString(r2.getColumnIndexOrThrow(DBHelper.COL_DATA2));
        if (r0 != null) goto L5;
    L23:
        return null;
    L5:
        switch(r0.hashCode()) {
            case 48: goto L20;
            case 49: goto L16;
            case 50: goto L12;
            case 51: goto L8;
            default: goto L23;
        };
    L8:
        if (r0.equals("3") == false) goto L23;
        return "其他";
    L12:
        if (r0.equals("2") == false) goto L23;
        return "工作";
    L16:
        if (r0.equals("1") == false) goto L23;
        return "住宅";
    L20:
        if (r0.equals("0") == false) goto L23;
        return r2.getString(r2.getColumnIndexOrThrow(DBHelper.COL_DATA3));
    }

    public static final String imTypeToDesc(Cursor r3) {
        Intrinsics.checkNotNullParameter(r3, "cursor");
        String r0 = r3.getString(r3.getColumnIndexOrThrow("data5"));
        if (r0 == null) goto L42;
        int r1 = r0.hashCode();
        if (r1 == 49) goto L39;
        if (r1 == 1444) goto L35;
        if (r1 == 51) goto L31;
        if (r1 == 52) goto L27;
        switch(r1) {
            case 48625: goto L23;
            case 48626: goto L19;
            case 48627: goto L15;
            default: goto L42;
        };
    L15:
        if (r0.equals(ContractKt.IM_WANGWANG) == false) goto L42;
        return "旺旺";
    L19:
        if (r0.equals("101") == false) goto L42;
        return "陌陌";
    L23:
        if (r0.equals("100") == false) goto L42;
        return "微信";
    L27:
        if (r0.equals("4") == false) goto L42;
        return "QQ";
    L31:
        if (r0.equals("3") == false) goto L42;
        return "SKYPE";
    L35:
        if (r0.equals(ContractKt.IM_CUSTOM) == false) goto L42;
        return r3.getString(r3.getColumnIndexOrThrow("data6"));
    L39:
        if (r0.equals("1") == false) goto L42;
        return "MSN";
    L42:
        return null;
    }

    public static final String relationShipsTypeToDesc(Cursor r3) {
        Intrinsics.checkNotNullParameter(r3, "cursor");
        String r0 = r3.getString(r3.getColumnIndexOrThrow(DBHelper.COL_DATA2));
        if (r0 == null) goto L43;
        int r1 = r0.hashCode();
        if (r1 == 48) goto L40;
        if (r1 == 1567) goto L37;
        if (r1 == 1569) goto L33;
        if (r1 == 54) goto L29;
        if (r1 == 55) goto L25;
        switch(r1) {
            case 48625: goto L21;
            case 48626: goto L17;
            default: goto L43;
        };
    L17:
        if (r0.equals("101") == false) goto L43;
        return "同学";
    L21:
        if (r0.equals("100") == false) goto L43;
        return "同事";
    L25:
        if (r0.equals("7") == false) goto L43;
        return "领导";
    L29:
        if (r0.equals(ContractKt.RELATION_FRIEND) == false) goto L43;
        return "朋友";
    L33:
        if (r0.equals(ContractKt.RELATION_FAMILY) == false) goto L43;
        return "亲属";
    L37:
        if (r0.equals(ContractKt.RELATION_PARTNER) == false) goto L43;
        return "合作伙伴";
    L40:
        if (r0.equals("0") == false) goto L43;
        return r3.getString(r3.getColumnIndexOrThrow(DBHelper.COL_DATA3));
    L43:
        return null;
    }

    public static final String dateTypeToDesc(Cursor r2) {
        Intrinsics.checkNotNullParameter(r2, "cursor");
        String r0 = r2.getString(r2.getColumnIndexOrThrow(DBHelper.COL_DATA2));
        if (r0 != null) goto L5;
    L27:
        return null;
    L5:
        switch(r0.hashCode()) {
            case 48: goto L24;
            case 49: goto L20;
            case 50: goto L16;
            case 51: goto L12;
            case 52: goto L8;
            default: goto L27;
        };
    L8:
        if (r0.equals("4") == false) goto L27;
        return "农历生日";
    L12:
        if (r0.equals("3") == false) goto L27;
        return "生日";
    L16:
        if (r0.equals("2") == false) goto L27;
        return "其他";
    L20:
        if (r0.equals("1") == false) goto L27;
        return "周年纪念日";
    L24:
        if (r0.equals("0") == false) goto L27;
        return r2.getString(r2.getColumnIndexOrThrow(DBHelper.COL_DATA3));
    }
}
