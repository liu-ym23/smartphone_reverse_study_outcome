package com.obric.autogui.session.b;

import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.computercontrol.CCApplicationAccessState;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionState;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: ComputerControlBizTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "CCBizTracking";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f30776a = null;

    static {
        f30776a = new e();
    }

    private e() {
    }

    public static /* synthetic */ void a(e r16, String r17, String r18, com.obric.autogui.session.a r19, CCSessionAccessor r20, CCSessionState r21, String r22, String r23, String r24, CCApplicationAccessState r25, Integer r26, Throwable r27, int r28, Object r29) {
        CCSessionAccessor r1 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r20, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        if ((r28 & 4) == 0) goto L5;
        com.obric.autogui.session.a r7 = null;
    L7:
        if ((r28 & 8) == 0) goto L9;
        CCSessionAccessor r8 = null;
    L11:
        if ((r28 & 16) == 0) goto L16;
        if (r8 == null) goto L14;
        CCSessionState r2 = r8.getState();
    L15:
        CCSessionState r9 = r2;
    L18:
        if ((r28 & 32) == 0) goto L20;
        String r10 = null;
    L22:
        if ((r28 & 64) == 0) goto L24;
        String r11 = null;
    L26:
        if ((r28 & 128) == 0) goto L28;
        String r12 = null;
    L30:
        if ((r28 & 256) == 0) goto L32;
        CCApplicationAccessState r13 = null;
    L34:
        if ((r28 & 512) == 0) goto L36;
        Integer r14 = null;
    L38:
        if ((r28 & 1024) == 0) goto L40;
        Throwable r15 = null;
    L41:
        r16.a(r17, r18, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        return;
    L40:
        r15 = r27;
        goto L41
    L36:
        r14 = r26;
        goto L38
    L32:
        r13 = r25;
        goto L34
    L28:
        r12 = r24;
        goto L30
    L24:
        r11 = r23;
        goto L26
    L20:
        r10 = r22;
        goto L22
    L14:
        r2 = null;
        goto L15
    L16:
        r9 = r21;
        goto L18
    L9:
        r8 = r1;
        goto L11
    L5:
        r7 = r19;
        goto L7
    }

    public final void a(String r22, String r23, com.obric.autogui.session.a r24, CCSessionAccessor r25, CCSessionState r26, String r27, String r28, String r29, CCApplicationAccessState r30, Integer r31, Throwable r32) {
        String r3 = r27;
        String r4 = r28;
        Object r5 = r29;
        CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r25, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r22, "stage");
        o.e(r23, "reason");
        String r12 = null;
        if (r5 == null) goto L10;
    L69:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "report failed, stage=" + r22 + ", reason=" + r23, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L10;
    L20:
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L69
        r15.put("stage", r22);     // Catch: Exception -> L69
        r15.put("reason", r23);     // Catch: Exception -> L69
        if (r24 == null) goto L23;
        r15.put("session_id", r24.b());     // Catch: Exception -> L69
        r15.put("session_key", r24.a());     // Catch: Exception -> L69
        r15.put("is_omni", r24.c());     // Catch: Exception -> L69
        r15.put("session_origin", r24.l().getLaunchOrigin());     // Catch: Exception -> L69
    L23:
        if (r7 == null) goto L25;
        r15.put("display_id", r7.getDisplayId());     // Catch: Exception -> L69
    L25:
        if (r26 == null) goto L29;
        e r9 = f30776a;     // Catch: Exception -> L69
        r15.put("session_state", r9.a(r26));     // Catch: Exception -> L69
        Integer r8 = r9.b(r26);     // Catch: Exception -> L69
        if (r8 == null) goto L29;
        r15.put("framework_code", ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L69
    L29:
        if (r3 != null) goto L31;
    L36:
        if (r4 != null) goto L38;
    L43:
        if (r5 == null) goto L45;
        r15.put("package_name", r5);     // Catch: Exception -> L69
    L45:
        if (r30 == null) goto L47;
        r15.put("access_state", r30.name());     // Catch: Exception -> L69
    L47:
        if (r31 == null) goto L49;
        r15.put("access_raw_value", ((Number) ZeusTransformUtils.preCheckCast(r31, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L69
    L49:
        if (r32 == null) goto L54;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r32.getClass().getSimpleName(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L69
        if (d.o.o.d(r6) == false) goto L53;
        r6 = r32.getClass().getName();     // Catch: Exception -> L69
    L53:
        r15.put("error_type", r6);     // Catch: Exception -> L69
    L54:
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "computer_control_abnormal", r15, false, false, null, 28, null);     // Catch: Exception -> L69
        Loog r10 = Loog.INSTANCE;     // Catch: Exception -> L69
        StringBuilder r11 = new StringBuilder().append("event=abnormal_reported stage=").append(r22).append(" reason=").append(r23).append(" origin=");     // Catch: Exception -> L69
        String r13 = "";
        if (r3 != null) goto L58;
        r3 = "";
    L58:
        StringBuilder r14 = r11.append(r3).append(" action=");     // Catch: Exception -> L69
        if (r4 != null) goto L61;
        r4 = "";
    L61:
        StringBuilder r16 = r14.append(r4).append(" sessionState=");     // Catch: Exception -> L69
        if (r26 == null) goto L64;
        r12 = a(r26);     // Catch: Exception -> L69
    L64:
        if (r12 == null) goto L67;
        r13 = r12;
    L67:
        r10.i(TAG, r16.append(r13).toString());     // Catch: Exception -> L69
        return;
    L38:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L40;
        Object r17 = r4;
    L41:
        if (r17 == null) goto L43;
        r15.put("action", r17);     // Catch: Exception -> L69
        goto L43
    L40:
        r17 = null;
        goto L41
    L31:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L33;
        Object r18 = r3;
    L34:
        if (r18 == null) goto L36;
        r15.put("origin", r18);     // Catch: Exception -> L69
        goto L36
    L33:
        r18 = null;
    L10:
        if (ZeusTransformUtils.instanceOf(r26, CCSessionState.Blocked.class) == false) goto L12;
        CCSessionState.Blocked r19 = (CCSessionState.Blocked) ZeusTransformUtils.preCheckCast(r26, CCSessionState.Blocked.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L69
    L13:
        if (r19 == null) goto L19;
        r5 = r19.getPackageName();     // Catch: Exception -> L69
        if (r5 == null) goto L19;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L20;
    L19:
        r5 = null;
        goto L20
    L12:
        r19 = null;
        goto L13
    }

    private final String a(CCSessionState r1) {
        if (o.a(r1, CCSessionState.Requesting.INSTANCE) == false) goto L6;
        return "Requesting";
    L6:
        if (o.a(r1, CCSessionState.Created.INSTANCE) == false) goto L9;
        return "Created";
    L9:
        if (o.a(r1, CCSessionState.Active.INSTANCE) == false) goto L12;
        return "Active";
    L12:
        if (ZeusTransformUtils.instanceOf(r1, CCSessionState.Blocked.class) == false) goto L15;
        return "Blocked";
    L15:
        if (ZeusTransformUtils.instanceOf(r1, CCSessionState.Closed.class) == false) goto L18;
        return "Closed";
    L18:
        if (ZeusTransformUtils.instanceOf(r1, CCSessionState.CreationFailed.class) == false) goto L22;
        return "CreationFailed";
    L22:
        throw new k();
    }

    private final Integer b(CCSessionState r2) {
        if (ZeusTransformUtils.instanceOf(r2, CCSessionState.Blocked.class) == false) goto L6;
        return Integer.valueOf(((CCSessionState.Blocked) ZeusTransformUtils.preCheckCast(r2, CCSessionState.Blocked.class, "com.obric.aiagent.plugin")).getReason());
    L6:
        if (ZeusTransformUtils.instanceOf(r2, CCSessionState.Closed.class) == false) goto L9;
        return ((CCSessionState.Closed) ZeusTransformUtils.preCheckCast(r2, CCSessionState.Closed.class, "com.obric.aiagent.plugin")).getReason();
    L9:
        if (ZeusTransformUtils.instanceOf(r2, CCSessionState.CreationFailed.class) == true) goto L15;
        return null;
    L15:
        return Integer.valueOf(((CCSessionState.CreationFailed) ZeusTransformUtils.preCheckCast(r2, CCSessionState.CreationFailed.class, "com.obric.aiagent.plugin")).getErrorCode());
    }
}
