package com.obric.contactsdk.loader;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.callandsms.common.DonationTracker;
import com.obric.callandsms.common.DonationTrackerDelegate;
import com.obric.callandsms.common.Logger;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.enums.CallTypeEnum;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.capabilitykit.sync.EntityIdData;
import defpackage.CallContentObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CallHistoryEntityUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\u001a\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t\u001a\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\f\u001a\u0018\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0003\u001a \u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a*\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\f2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u001a\u0010#\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\t\u001a(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0)2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"CALL_LOG_DONATION_MAX_COUNT", "", "CALL_LOG_DONATION_TIME_LIMIT_MS", "", "callTypeToDesc", "Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "type", "duration", "filterAdministrativeDivision", "", BatteryTypeInf.BATTERY_LOC_API, "filterExpiredCallHistoryEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "entities", "formatNumber", "context", "Landroid/content/Context;", "phoneNumber", "entity", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getAllCallLogIds", "getCallLogIdByCallFlags", "callFlags", "getCallLogIdByTimestamp", "timestamp", "queryCallLogById", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "contentResolver", "Landroid/content/ContentResolver;", "id", "queryCallLogSampleEntities", "Lcom/obric/capabilitykit/sync/EntityIdData;", "queryCallLogsByIds", "ids", "safeGetColumn", "cursor", "Landroid/database/Cursor;", "columnName", "updateCallHistoryEntitiesQueryByIds", "callHistoryEntities", "", "contactsdk_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CallHistoryEntityUtilKt {
    public static final int CALL_LOG_DONATION_MAX_COUNT = 500;
    public static final long CALL_LOG_DONATION_TIME_LIMIT_MS = 63072000000L;

    public static final List<AppEntity> filterExpiredCallHistoryEntities(List<? extends AppEntity> r7) {
        Intrinsics.checkNotNullParameter(r7, "entities");
        long r0 = System.currentTimeMillis() - CALL_LOG_DONATION_TIME_LIMIT_MS;
        ArrayList r3 = new ArrayList();
        Iterator<T> r2 = r7.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        Object r4 = r2.next();
        AppEntity r5 = (AppEntity) r4;
        if ((r5 instanceof CallHistoryEntity) == true) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L4;
        r3.add(r4);
        goto L4
    L8:
        if (r5.getCreateTime() >= r0) goto L11;
        r6 = false;
        goto L12
    L14:
        ArrayList r8 = r3;
        if (r8.size() <= 500) goto L17;
        List<AppEntity> r1 = CollectionsKt.take(r8, 500);
    L18:
        int r9 = r7.size() - r8.size();
        int r10 = r8.size() - r1.size();
        Logger.INSTANCE.i(CallContentObserver.TAG, "filterExpiredCallHistoryEntities: " + r7.size() + " -> " + r1.size() + " (expired " + r9 + ", truncated " + r10 + ')');
        DonationTracker r11 = DonationTrackerDelegate.INSTANCE.getTracker();
        if (r11 == null) goto L21;
        r11.trackCallLogDonation(r7.size(), r1.size(), r9, r10);
    L21:
        return r1;
    L17:
        r1 = r8;
        goto L18
    }

    public static final List<Long> getAllCallLogIds(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        ArrayList r0 = new ArrayList();
        Uri r2 = CallLog.Calls.CONTENT_URI;
        Cursor r1 = r7.getContentResolver().query(r2, new String[]{"_id"}, null, null, null);
        if (r1 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r1.moveToNext() == false) goto L9;
        int r3 = r1.getColumnIndex("_id");
        if (r3 == (-1)) goto L5;
        r0.add(Long.valueOf(r1.getLong(r3)));
        goto L5
    L9:
        r1.close();
        goto L10
    }

    public static final List<EntityIdData> queryCallLogSampleEntities(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        ArrayList r0 = new ArrayList();
        Uri r2 = CallLog.Calls.CONTENT_URI;
        Cursor r1 = r9.getContentResolver().query(r2, new String[]{"_id", "date"}, null, null, null);
        if (r1 == null) goto L18;
        Cursor r3 = r1;
        Cursor r4 = r3;     // Catch: Throwable -> L13
        int r10 = r4.getColumnIndex("_id");     // Catch: Throwable -> L13
        int r5 = r4.getColumnIndex("date");     // Catch: Throwable -> L13
        if (r10 == (-1)) goto L11;
        if (r5 == (-1)) goto L11;
    L9:
        if (r4.moveToNext() == false) goto L11;
        String r6 = r4.getString(r10);     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r6, "it.getString(idIndex)");     // Catch: Throwable -> L13
        r0.add(new EntityIdData(r6, 202, r4.getLong(r5)));     // Catch: Throwable -> L13
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<CallHistoryEntity> queryCallLogsByIds(ContentResolver r31, List<Long> r32, Context r33) {
        String r9 = "number";
        Intrinsics.checkNotNullParameter(r31, "contentResolver");
        Intrinsics.checkNotNullParameter(r32, "ids");
        Intrinsics.checkNotNullParameter(r33, "context");
        String r4 = "_id IN " + CollectionsKt.joinToString$default(r32, SimContactsConstants.EMAIL_SEP, "(", ")", 0, null, null, 56, null);
        Cursor r1 = r31.query(CallLog.Calls.CONTENT_URI, new String[]{"_id", "date", "duration", "number", "type", "numberlabel", "geocoded_location"}, r4, null, null);
        ArrayList r2 = new ArrayList();
        LinkedHashMap r3 = new LinkedHashMap();
        if (r1 == null) goto L85;
        Cursor r5 = r1;
        Cursor r6 = r5;     // Catch: Throwable -> L78
    L7:
        if (r6.moveToNext() == false) goto L73;
        int r7 = r6.getColumnIndex("_id");     // Catch: Throwable -> L78
        int r10 = r6.getColumnIndex("date");     // Catch: Throwable -> L78
        int r11 = r6.getColumnIndex("duration");     // Catch: Throwable -> L78
        int r12 = r6.getColumnIndex(r9);     // Catch: Throwable -> L78
        int r13 = r6.getColumnIndex("type");     // Catch: Throwable -> L78
        int r14 = r6.getColumnIndex("numberlabel");     // Catch: Throwable -> L78
        int r15 = r6.getColumnIndex("geocoded_location");     // Catch: Throwable -> L78
        if (r7 == (-1)) goto L7;
        if (r10 == (-1)) goto L7;
        if (r11 == (-1)) goto L7;
        if (r12 == (-1)) goto L7;
        if (r13 == (-1)) goto L7;
        if (r14 == (-1)) goto L7;
        if (r15 == (-1)) goto L7;
        String r8 = r6.getString(r7);     // Catch: Throwable -> L78
        long r16 = r6.getLong(r10);     // Catch: Throwable -> L78
        int r17 = r6.getInt(r11);     // Catch: Throwable -> L78
        String r18 = r6.getString(r12);     // Catch: Throwable -> L78
        int r19 = r6.getInt(r13);     // Catch: Throwable -> L78
        String r110 = r6.getString(r14);     // Catch: Throwable -> L78
        String r111 = r6.getString(r15);     // Catch: Throwable -> L78
        Cursor r27 = r5;
        ArrayList r112 = r2;
        CallTypeEnum r25 = callTypeToDesc(r19, r17);     // Catch: Throwable -> L70
        Intrinsics.checkNotNullExpressionValue(r18, r9);     // Catch: Throwable -> L70
        String r20 = ContactEntityUtilKt.getContactIdByPhoneNumber(r31, r18);     // Catch: Throwable -> L70
        Ref.ObjectRef r21 = new Ref.ObjectRef();     // Catch: Throwable -> L70
        boolean r113 = false;
        if (r20 == null) goto L28;
        long r114 = Long.parseLong(r20);     // Catch: Throwable -> L70
        ContactEntity r22 = (ContactEntity) r3.get(Long.valueOf(r114));     // Catch: Throwable -> L70
        if (r22 != null) goto L26;
        List<ContactEntity> r23 = ContactEntityUtilKt.queryContactsByIds(r31, CollectionsKt.listOf(Long.valueOf(r114)), false, false);     // Catch: Throwable -> L70
        boolean r28 = true;
        if ((!r23.isEmpty()) == false) goto L25;
        r3.put(Long.valueOf(r114), r23.get(0));     // Catch: Throwable -> L70
        T r24 = r23;
    L27:
        r21.element = r24;     // Catch: Throwable -> L70
    L29:
        List r26 = (List) r21.element;     // Catch: Throwable -> L70
        if (r26 == null) goto L32;
        ContactEntity r29 = (ContactEntity) CollectionsKt.getOrNull(r26, 0);     // Catch: Throwable -> L70
    L33:
        List r210 = CollectionsKt.listOf(formatNumber(r33, r18, r29));     // Catch: Throwable -> L70
        CallFeatureEntity r30 = CallFeatureEntityUtilKt.getCallFeatureEntity(r31, r16);     // Catch: Throwable -> L70
        if (r25 == null) goto L68;
        Intrinsics.checkNotNullExpressionValue(r8, "callId");     // Catch: Throwable -> L70
        CallHistoryEntity r34 = new CallHistoryEntity(r8, r16, r16, r210, (List) r21.element, r25, r17);     // Catch: Throwable -> L70
        String r35 = r111;     // Catch: Throwable -> L70
        if (r35 != null) goto L38;
    L41:
        boolean r36 = r28;
    L42:
        if (r36 == true) goto L44;
        String r37 = filterAdministrativeDivision(r111);     // Catch: Throwable -> L70
    L55:
        if (r37.length() <= 0) goto L57;
        r113 = r28;
    L57:
        if (r113 == false) goto L59;
        r34.setCarriers(CollectionsKt.listOf(r37));     // Catch: Throwable -> L70
    L59:
        if (r110 == null) goto L61;
        Intrinsics.checkNotNullExpressionValue(r110, "cachedNumberLabel");     // Catch: Throwable -> L70
        r34.setTag(r110);     // Catch: Throwable -> L70
    L61:
        if (r30 == null) goto L66;
        r34.setHasTranscript(r30.getHasSummary());     // Catch: Throwable -> L70
        String r38 = r30.getSummary();     // Catch: Throwable -> L70
        if (r38 == null) goto L65;
        r34.setTranscript(r38);     // Catch: Throwable -> L70
    L65:
        r34.setTodoList(r30.getTodoList());     // Catch: Throwable -> L70
        r34.setTranscriptTitle(r30.getTitle());     // Catch: Throwable -> L70
    L66:
        r2 = r112;
        r2.add(r34);     // Catch: Throwable -> L70
    L69:
        r5 = r27;
        r6 = r6;
        r9 = r9;
        goto L7
    L44:
        String r39 = r110;     // Catch: Throwable -> L70
        if (r39 != null) goto L47;
    L50:
        boolean r40 = r28;
    L51:
        if (r40 == true) goto L53;
        Intrinsics.checkNotNullExpressionValue(r110, "{\n                      …bel\n                    }");     // Catch: Throwable -> L70
        r37 = r110;
        goto L55
    L53:
        r37 = "";
        goto L55
    L47:
        if (r39.length() == 0) goto L50;
        r40 = false;
        goto L51
    L38:
        if (r35.length() == 0) goto L41;
        r36 = false;
        goto L42
    L68:
        r2 = r112;
        goto L69
    L32:
        r29 = null;
        goto L33
    L25:
        r24 = r23;
        goto L27
    L26:
        r28 = true;
        r24 = CollectionsKt.listOf(r22);     // Catch: Throwable -> L70
        goto L27
    L28:
        r6 = r6;
        r9 = r9;
        r28 = true;
    L70:
        th = move-exception;
        Throwable r41 = th;
        r5 = r27;
    L90:
        throw r41;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        CloseableKt.closeFinally(r5, r41);
        throw th;
    L73:
        Cursor r211 = r5;
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L76
        CloseableKt.closeFinally(r5, null);
    L76:
        th = th;
        r5 = r211;
    L79:
        r41 = th;
    L78:
        th = th;
    L85:
        return updateCallHistoryEntitiesQueryByIds(r2, r32);
    }

    public static final String filterAdministrativeDivision(String r3) {
        String r4 = r3;
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return "";
    L12:
        String r5 = new Regex("(省|自治区|直辖市)").replace(r4, HanziToPinyin.Token.SEPARATOR);
        String r6 = new Regex("市").replace(r5, HanziToPinyin.Token.SEPARATOR);
        String r7 = new Regex("[·]").replace(r6, HanziToPinyin.Token.SEPARATOR);
        return StringsKt.trim(new Regex("\\s+").replace(r7, HanziToPinyin.Token.SEPARATOR)).toString();
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static final List<CallHistoryEntity> updateCallHistoryEntitiesQueryByIds(List<CallHistoryEntity> r7, List<Long> r8) {
        Intrinsics.checkNotNullParameter(r7, "callHistoryEntities");
        Intrinsics.checkNotNullParameter(r8, "ids");
        ArrayList r0 = new ArrayList();
        Iterator<Long> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L14;
        long r1 = r9.next().longValue();
        Iterator<CallHistoryEntity> r3 = r7.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        CallHistoryEntity r4 = r3.next();
        if (TextUtils.equals(String.valueOf(r1), r4.getId()) == false) goto L7;
        if (r0.contains(r4) == true) goto L7;
        r0.add(r4);
        goto L7
    L14:
        if (r0.size() != 0) goto L17;
        return r7;
    L17:
        return r0;
    }

    public static final String formatNumber(Context r8, String r9, ContactEntity r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "phoneNumber");
        String r0 = r9;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return r9;
    L5:
        if (r10 == null) goto L15;
        List<MetaTelephone> r11 = r10.getTelephones();
        if (r11 != null) goto L9;
        r11 = CollectionsKt.emptyList();
    L9:
        Iterator<MetaTelephone> r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        String r1 = r12.next().getTelephone();
        if (TextUtils.equals(r0, StringsKt.replace$default(r1, HanziToPinyin.Token.SEPARATOR, "", false, 4, null)) == false) goto L11;
        return r1;
    L15:
        Object r13 = r8.getApplicationContext().getSystemService("phone");
        String r2 = null;
        if ((r13 instanceof TelephonyManager) == false) goto L18;
        TelephonyManager r14 = (TelephonyManager) r13;
    L19:
        if (r14 == null) goto L21;
        String r15 = r14.getSimCountryIso();
    L22:
        if (r15 == null) goto L24;
        r2 = r15.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
    L24:
        String r16 = r2;
        if (r16 != null) goto L27;
    L30:
        boolean r17 = true;
    L31:
        if (r17 == false) goto L33;
        r2 = Locale.CHINA.getCountry();
    L33:
        String r18 = PhoneNumberUtils.formatNumber(r9, r2);
        if (r18 != null) goto L37;
        return r9;
    L37:
        return r18;
    L27:
        if (r16.length() == 0) goto L30;
        r17 = false;
        goto L31
    L21:
        r15 = null;
        goto L22
    L18:
        r14 = null;
        goto L19
    }

    public static final CallHistoryEntity queryCallLogById(ContentResolver r1, long r2, Context r4) {
        Intrinsics.checkNotNullParameter(r1, "contentResolver");
        Intrinsics.checkNotNullParameter(r4, "context");
        List<CallHistoryEntity> r3 = queryCallLogsByIds(r1, CollectionsKt.listOf(Long.valueOf(r2)), r4);
        if ((!r3.isEmpty()) == true) goto L5;
        return null;
    L5:
        return r3.get(0);
    }

    public static final CallTypeEnum callTypeToDesc(int r2, long r3) {
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L11;
        if (r2 == 3) goto L17;
        return null;
    L17:
        return CallTypeEnum.INCOMING_CALL_MISSED;
    L11:
        if (r3 <= 0) goto L19;
        return CallTypeEnum.OUTGOING_CALL_ANSWERED;
    L19:
        return CallTypeEnum.OUTGOING_CALL_MISSED;
    L15:
        return CallTypeEnum.INCOMING_CALL_ANSWERED;
    }

    public static final String getCallLogIdByTimestamp(Context r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        String[] r5 = {String.valueOf(r8)};
        Cursor r9 = r7.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"_id", "date"}, "date = ?", r5, "date DESC");
        if (r9 != null) goto L5;
    L7:
        return null;
    L5:
        if (r9.moveToFirst() == false) goto L7;
        String r10 = safeGetColumn(r9, "_id");
        r9.close();
        return r10;
    }

    public static final List<String> getCallLogIdByCallFlags(Context r10, List<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "callFlags");
        ArrayList r0 = new ArrayList();
        ContentResolver r12 = r10.getContentResolver();
        String[] r8 = {"_id", "date", "number"};
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L27;
        Pair<String, String> r1 = CallFeatureEntityUtilKt.getCallCreateTimeAndPhoneNumber((String) r13.next());
        if (r1 == null) goto L8;
        String[] r5 = {r1.getFirst(), r1.getSecond()};
    L9:
        Cursor r2 = r12.query(CallLog.Calls.CONTENT_URI, r8, "date=? AND number=?", r5, "date DESC");
        if (r2 == null) goto L4;
        Cursor r3 = r2;
        Cursor r4 = r3;     // Catch: Throwable -> L22
    L14:
        if (r2.moveToNext() == false) goto L20;
        String r6 = safeGetColumn(r2, "_id");     // Catch: Throwable -> L22
        if (r6 == null) goto L14;
        if (r0.contains(r6) == true) goto L14;
        r0.add(r6);     // Catch: Throwable -> L22
        goto L14
    L20:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r3, null);
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L8:
        r5 = null;
        goto L9
    L27:
        return r0;
    }

    public static final String safeGetColumn(Cursor r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "columnName");
        if (r1 != null) goto L5;
    L9:
        return null;
    L5:
        if (r1.getCount() <= 0) goto L9;
        int r3 = r1.getColumnIndex(r2);
        if (r3 == (-1)) goto L9;
        return r1.getString(r3);
    }
}
