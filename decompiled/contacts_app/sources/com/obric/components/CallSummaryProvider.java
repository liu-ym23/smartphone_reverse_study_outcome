package com.obric.components;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.GlobalProxyLancet;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import com.obric.Intelligentcall.IntelligentUtils;
import com.obric.callsummary.CallSummaryGenerateManagerKt;
import com.obric.callsummary.model.aikernel.AISummary;
import com.obric.callsummary.widget.CallSummaryWidget;
import com.obric.model.CallFeatureModel;
import com.obric.notification.NotificationHelper;
import com.obric.privacy.PrivacyUtils;
import com.obric.tracker.CallScreenShowUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallSummaryProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016JO\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u001bJ;\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/obric/components/CallSummaryProvider;", "Landroid/content/ContentProvider;", "()V", "call", "Landroid/os/Bundle;", "method", "", "arg", "extras", "delete", "", "uri", "Landroid/net/Uri;", CallLogListAdapter.PAYLOAD_SELECTION, "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSummaryProvider extends ContentProvider {
    private static final String CALL_FOR_ME_OUT_GOING_CALL_STATUS_CHANGE = "call_for_me_out_going_call_status_change";
    public static final Companion Companion = null;
    private static final String METHOD_CALL_END = "METHOD_CALL_END";
    private static final String METHOD_CALL_SCREEN_SHOW = "METHOD_CALL_SCREEN_SHOW";
    private static final String METHOD_CALL_SUMMARY_WIDGET_QUERY = "METHOD_CALL_SUMMARY_WIDGET_QUERY";
    private static final String METHOD_ON_ONLY_INTELLIGENT_DONE = "METHOD_ON_ONLY_INTELLIGENT_DONE";
    private static final String METHOD_PARAMETER_CALL_CREATE_TIME = "call_create_time";
    private static final String METHOD_PARAMETER_CALL_FOR_ME_PARAMS = "call_for_me_params";
    private static final String METHOD_PARAMETER_CALL_FOR_ME_RESULT = "call_for_me_result";
    private static final String METHOD_PARAMETER_CALL_FOR_ME_STATUS = "call_for_me_status";
    private static final String METHOD_PARAMETER_PHONE_NUMBER = "phone_number";
    private static final String METHOD_START_CALL_SUMMARY_COMPRESS_TASK = "METHOD_START_CALL_SUMMARY_COMPRESS_TASK";
    private static final String METHOD_START_CALL_SUMMARY_TASK = "METHOD_START_CALL_SUMMARY_TASK";
    private static final String PERMISSION_CALL_CALL_SUMMARY_PROVIDER = "obric.contacts.permission.CALL_CALL_SUMMARY_PROVIDER";
    private static final String TAG = "CallSummaryProvider";

    /* JADX INFO: compiled from: CallSummaryProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/components/CallSummaryProvider$Companion;", "", "()V", "CALL_FOR_ME_OUT_GOING_CALL_STATUS_CHANGE", "", CallSummaryProvider.METHOD_CALL_END, CallSummaryProvider.METHOD_CALL_SCREEN_SHOW, CallSummaryProvider.METHOD_CALL_SUMMARY_WIDGET_QUERY, CallSummaryProvider.METHOD_ON_ONLY_INTELLIGENT_DONE, "METHOD_PARAMETER_CALL_CREATE_TIME", "METHOD_PARAMETER_CALL_FOR_ME_PARAMS", "METHOD_PARAMETER_CALL_FOR_ME_RESULT", "METHOD_PARAMETER_CALL_FOR_ME_STATUS", "METHOD_PARAMETER_PHONE_NUMBER", CallSummaryProvider.METHOD_START_CALL_SUMMARY_COMPRESS_TASK, CallSummaryProvider.METHOD_START_CALL_SUMMARY_TASK, "PERMISSION_CALL_CALL_SUMMARY_PROVIDER", "TAG", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    public CallSummaryProvider() {
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r21, String r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r21, "method");
        Context r4 = getContext();
        if (r4 != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "[call] context is null! return.");
        return null;
    L7:
        if (r4.checkCallingPermission(PERMISSION_CALL_CALL_SUMMARY_PROVIDER) != 0) goto L99;
        if (PrivacyUtils.hasBasePermissionAndAgree(r4) == true) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "call method " + r21 + ", but privacy not ok");
        return null;
    L12:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "call method " + r21);
        switch(r21.hashCode()) {
            case -1994733011: goto L94;
            case -698125207: goto L90;
            case -303864349: goto L72;
            case 90039074: goto L58;
            case 602689499: goto L43;
            case 1115461316: goto L20;
            case 1420077304: goto L16;
            default: goto L106;
        };
    L106:
        return null;
    L16:
        if (r21.equals(METHOD_CALL_END) == false) goto L107;
        IntelligentUtils.INSTANCE.sendIntelligentNotification(r4);
        return null;
    L107:
        return null;
    L20:
        if (r21.equals(METHOD_START_CALL_SUMMARY_TASK) == false) goto L108;
        if (r23 != null) goto L25;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "extras is null. return!");
        return null;
    L25:
        long r13 = r23.getLong("call_create_time", -1);
        if (r13 != (-1)) goto L29;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "get callCreateTime error. return!");
        return null;
    L29:
        String r0 = r23.getString("phone_number");
        if (r0 != null) goto L33;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "get phoneNumber error. return!");
        return null;
    L33:
        CallFeatureModel.INSTANCE.callSummaryStarted(new Pair(Long.valueOf(r13), r0));
        boolean r1 = AISummary.INSTANCE.isLocalModel(r4);
        StringBuilder r2 = new StringBuilder("provider startTask date=").append(r13).append(" route=");
        if (r1 == false) goto L36;
        String r3 = "local";
    L37:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, r2.append(r3).toString());
        if (r1 == false) goto L41;
        AISummary.INSTANCE.callSummaryComposeByPart(r4, true, r13, r0);
        return null;
    L41:
        Intent r5 = new Intent();
        r5.setAction(ContactsTaskService.ACTION_START_CALL_SUMMARY_TASK);
        r5.putExtra("call_create_time", r13);
        r5.putExtra("phone_number", r0);
        r5.setClass(r4, ContactsTaskService.class);
        r4.startService(r5);
        return null;
    L36:
        r3 = "service";
        goto L37
    L108:
        return null;
    L43:
        if (r21.equals(METHOD_ON_ONLY_INTELLIGENT_DONE) == false) goto L109;
        if (r23 != null) goto L48;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "extras is null. return!");
        return null;
    L48:
        long r14 = r23.getLong("call_create_time", -1);
        if (r14 != (-1)) goto L52;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "get callCreateTime error. return!");
        return null;
    L52:
        String r6 = r23.getString("phone_number");
        if (r6 != null) goto L56;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "get phoneNumber error. return!");
        return null;
    L56:
        NotificationHelper.INSTANCE.sendNotification(r4, r14, r6);
        return null;
    L109:
        return null;
    L58:
        if (r21.equals(CALL_FOR_ME_OUT_GOING_CALL_STATUS_CHANGE) == false) goto L110;
        if (r23 != null) goto L63;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "extras is null. return!");
        return null;
    L63:
        String r15 = r23.getString(METHOD_PARAMETER_CALL_FOR_ME_PARAMS);
        boolean r16 = r23.getBoolean(METHOD_PARAMETER_CALL_FOR_ME_RESULT);
        String r7 = r23.getString(METHOD_PARAMETER_CALL_FOR_ME_STATUS);
        long r17 = r23.getLong("call_create_time", -1);
        String r19 = r23.getString("phone_number");
        StringBuilder r8 = new StringBuilder("outGoingCallStatusChange call method ").append(r21).append(", id: ");
        String r9 = r15;
        if (r9 != null) goto L66;
    L69:
        boolean r10 = true;
    L70:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r8.append(r10).append(", result: ").append(r16).append(", status: ").append(r7).toString());
        CallFeatureModel.INSTANCE.notifyCallResult(r15, r16, r7, r17, r19);
        return null;
    L66:
        if (r9.length() == 0) goto L69;
        r10 = false;
        goto L70
    L110:
        return null;
    L72:
        if (r21.equals(METHOD_START_CALL_SUMMARY_COMPRESS_TASK) == false) goto L111;
        if (r23 != null) goto L77;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "extras is null. return!");
        return null;
    L77:
        long r18 = r23.getLong("call_create_time", -1);
        if (r18 != (-1)) goto L81;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "get callCreateTime error. return!");
        return null;
    L81:
        String r11 = r23.getString("phone_number");
        if (r11 != null) goto L86;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "get phoneNumber error. return!");
        return null;
    L86:
        if (AISummary.INSTANCE.isLocalModel(r4) == true) goto L88;
        return null;
    L88:
        AISummary.INSTANCE.callSummaryComposeByPart(r4, false, r18, r11);
        return null;
    L111:
        return null;
    L90:
        if (r21.equals(METHOD_CALL_SUMMARY_WIDGET_QUERY) == true) goto L105;
        return null;
    L105:
        return CallSummaryWidget.getWidgetDate(r4, r23);
    L94:
        if (r21.equals(METHOD_CALL_SCREEN_SHOW) == false) goto L113;
        CallScreenShowUtils.INSTANCE.end();
        return null;
    L113:
        return null;
    L99:
        throw new SecurityException("PERMISSION DENIED");
    }
}
