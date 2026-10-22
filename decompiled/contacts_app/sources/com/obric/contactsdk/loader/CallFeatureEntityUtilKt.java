package com.obric.contactsdk.loader;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.GlobalProxyLancet;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CallFeatureEntityUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001e\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b\u001a1\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"#\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0010\u0010\u0007¨\u0006 "}, d2 = {"AUTHORITY", "", "CALL_FEATURE_PATH", "CALL_FEATURE_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getCALL_FEATURE_URI", "()Landroid/net/Uri;", "CALL_FLAG_SPLIT", "PARAM_ACTION_CALL_FEATURE_TYPE_DELETE", "PARAM_ACTION_CALL_FEATURE_TYPE_INSERT", "PARAM_ACTION_CALL_FEATURE_TYPE_UPDATE", "PARAM_KEY_ACTION", "PARAM_KEY_CALL_FlAG", "SCHEME_CONTENT", "callFeatureUri", "getCallFeatureUri", "callFeatureUri$delegate", "Lkotlin/Lazy;", "getCallCreateTimeAndPhoneNumber", "Lkotlin/Pair;", CallFeatureEntityUtilKt.PARAM_KEY_CALL_FlAG, "getCallFeatureEntity", "Lcom/obric/contactsdk/loader/CallFeatureEntity;", "contentResolver", "Landroid/content/ContentResolver;", "callCreateTime", "", CallLogListAdapter.PAYLOAD_SELECTION, "selectionArgs", "", "(Landroid/content/ContentResolver;Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/contactsdk/loader/CallFeatureEntity;", "contactsdk_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CallFeatureEntityUtilKt {
    private static final String AUTHORITY = "call_log_obric";
    private static final String CALL_FEATURE_PATH = "call_feature";
    private static final Uri CALL_FEATURE_URI = null;
    public static final String CALL_FLAG_SPLIT = "@@";
    public static final String PARAM_ACTION_CALL_FEATURE_TYPE_DELETE = "delete";
    public static final String PARAM_ACTION_CALL_FEATURE_TYPE_INSERT = "insert";
    public static final String PARAM_ACTION_CALL_FEATURE_TYPE_UPDATE = "update";
    public static final String PARAM_KEY_ACTION = "action";
    public static final String PARAM_KEY_CALL_FlAG = "callFlag";
    private static final String SCHEME_CONTENT = "content";
    private static final Lazy callFeatureUri$delegate = null;

    static {
        CALL_FEATURE_URI = new Uri.Builder().scheme("content").authority(AUTHORITY).path("call_feature").build();
        callFeatureUri$delegate = LazyKt.lazy(CallFeatureEntityUtilKt$callFeatureUri$2.INSTANCE);
    }

    public static final Uri getCALL_FEATURE_URI() {
        return CALL_FEATURE_URI;
    }

    public static final Uri getCallFeatureUri() {
        return (Uri) callFeatureUri$delegate.getValue();
    }

    public static final CallFeatureEntity getCallFeatureEntity(ContentResolver r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        return getCallFeatureEntity(r3, CallFeature.INSTANCE.getCALL_CREATE_TIME() + "=?", new String[]{String.valueOf(r4)});
    }

    public static final Pair<String, String> getCallCreateTimeAndPhoneNumber(String r10) {
        String r0 = r10;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L26;
        return null;
    L26:
        List r11 = StringsKt.split$default(r10, new String[]{"@@"}, false, 0, 6, null);     // Catch: Throwable -> L23
        String r2 = (String) CollectionsKt.getOrNull(r11, 0);     // Catch: Throwable -> L23
        if (r2 == null) goto L22;
        String r3 = StringsKt.trim(r2).toString();     // Catch: Throwable -> L23
        if (r3 == null) goto L22;
        String r12 = (String) CollectionsKt.getOrNull(r11, 1);     // Catch: Throwable -> L23
        if (r12 != null) goto L20;
        return null;
    L20:
        return new Pair(r3, r12);
    L22:
        return null;
    L23:
        th = move-exception;
        System.out.println("Error getCallCreateTimeAndPhoneNumber to list: " + th.getMessage());
        return null;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    private static final CallFeatureEntity getCallFeatureEntity(ContentResolver r8, String r9, String[] r10) {
        Cursor r11 = r8.query(getCallFeatureUri(), null, r9, r10, null, null);
        if (r11 == null) goto L50;
        Cursor r12 = r11;
        Cursor r13 = r12;     // Catch: Throwable -> L45
        if (r13.moveToFirst() == true) goto L9;
        CloseableKt.closeFinally(r12, null);
        return null;
    L9:
        int r0 = r13.getColumnIndex(CallFeature.INSTANCE.getSUMMARY());     // Catch: Throwable -> L45
        if (r0 != (-1)) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("", "Get index error! Return.");     // Catch: Throwable -> L45
        CloseableKt.closeFinally(r12, null);
        return null;
    L14:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L45
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        String r14 = r13.getString(r0);     // Catch: Throwable -> L20
        Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L23:
        String r3 = r14;     // Catch: Throwable -> L45
        boolean r4 = false;
        if (r3 != null) goto L26;
    L29:
        boolean r5 = true;
    L30:
        boolean r6 = !r5;     // Catch: Throwable -> L45
        if (r6 == false) goto L42;
        CallSummary r15 = (CallSummary) new Gson().fromJson(r14, CallSummary.class);     // Catch: Throwable -> L45
        String r7 = r15.getSummaryStr();     // Catch: Throwable -> L45
        r1.addAll(r15.getTodoListStr());     // Catch: Throwable -> L45
        String r16 = r7;     // Catch: Throwable -> L45
        if (r16 != null) goto L35;
    L38:
        boolean r17 = true;
    L39:
        if (r17 == true) goto L41;
        r4 = true;
    L41:
        String r18 = r15.getTitle();     // Catch: Throwable -> L45
        r14 = r7;
    L43:
        CallFeatureEntity r19 = new CallFeatureEntity(r4, r14, r1, r18);     // Catch: Throwable -> L45
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L45
        CloseableKt.closeFinally(r12, null);
        return r19;
    L35:
        if (r16.length() == 0) goto L38;
        r17 = false;
        goto L39
    L42:
        r4 = r6;
        r18 = null;
        goto L43
    L26:
        if (r3.length() == 0) goto L29;
        r5 = false;
    L18:
        th = th;
    L22:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L45
        Result.m803constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L45
    L20:
        th = th;
        r14 = null;
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L50:
        return null;
    }
}
