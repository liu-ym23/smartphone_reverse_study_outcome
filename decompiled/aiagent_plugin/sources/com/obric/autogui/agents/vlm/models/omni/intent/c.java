package com.obric.autogui.agents.vlm.models.omni.intent;

import com.obric.capabilitykit.common.ErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: OmniGUIIntentResultCode.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28406a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f28407b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f28408c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f28409d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f28410e = null;
    public static final c f = null;
    public static final c g = null;
    public static final c h = null;
    public static final c i = null;
    public static final c j = null;
    public static final c k = null;
    public static final c l = null;
    public static final c m = null;
    public static final c n = null;
    public static final c o = null;
    public static final c p = null;
    private static final /* synthetic */ c[] s = null;
    private static final /* synthetic */ d.d.a t = null;
    private final int q;
    private final String r;

    /* JADX INFO: compiled from: OmniGUIIntentResultCode.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final String a(int r7, String r8) {
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(c.c(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L3:
            boolean r2 = true;
            String r4 = null;
            if (r6.hasNext() == false) goto L11;
            Object r0 = r6.next();
            if (((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin")).a() != r7) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == false) goto L3;
        L12:
            c r9 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L19;
            String r10 = r9.name();
            if (r10 == null) goto L19;
            String r11 = r10.toLowerCase(Locale.ROOT);
            o.c(r11, "toLowerCase(...)");
            if (r11 == null) goto L19;
            return r11;
        L19:
            if (r8 == null) goto L28;
            String r12 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r12 == null) goto L28;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L26;
            r2 = false;
        L26:
            if (r2 == false) goto L28;
            r4 = r12;
        L28:
            if (r4 != null) goto L31;
            return "omni_action_result_unknown";
        L31:
            return r4;
        L8:
            r5 = false;
            goto L9
        L11:
            r0 = null;
            goto L12
        }
    }

    public static d.d.a<c> c() {
        return t;
    }

    private static final /* synthetic */ c[] d() {
        return new c[]{f28407b, f28408c, f28409d, f28410e, f, g, h, i, j, k, l, m, n, o, p};
    }

    private c(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.q = r3;
        this.r = r4;
    }

    public final int a() {
        return this.q;
    }

    public final String b() {
        return this.r;
    }

    static {
        f28407b = new c("SUCCESS", 0, 0, "Success");
        f28408c = new c("GUI_ACTION_PARAMS_INVALID", 1, 1000, "GUI Action Params Invalid");
        f28409d = new c("SESSION_ID_MISMATCH", 2, 1001, "Session ID Mismatch");
        f28410e = new c("SESSION_CLOSED", 3, 1002, "Session Closed");
        f = new c("SESSION_CREATE_FAIL", 4, 1003, "Session Create Failed");
        g = new c("SESSION_NOT_FOUND", 5, 1004, "Omni Session Not Found");
        h = new c("SESSION_NOT_CREATED_OR_ALREADY_CLOSED", 6, 1005, "stop command refused, Omni Session Not Created Or Already Closed");
        i = new c("ACTION_QUEUE_FULL", 7, ErrorCode.Clock.TIMER_NOT_EXIST_ERROR, "Action Queue Full");
        j = new c("ACTION_QUEUE_FULL_DISPATCH_CONTEXT_NOT_CONSUME", 8, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR, "Action Queue Failed, Last Dispatch Context Not Consume");
        k = new c("SESSION_PAUSED_UNKNOWN", 9, 3000, "Session Paused Unknown Reason");
        l = new c("SESSION_PAUSED_ENTER_CALL_USER", 10, ErrorCode.AudioControl.NO_CONTROLLABLE_SESSION_ERROR, "Session Paused ENTER_CALL_USER");
        m = new c("SESSION_PAUSED_ENTER_USER_ADDITION", 11, ErrorCode.AudioControl.EXISTED_PLAYING_SESSION_ERROR, "Session Paused ENTER_USER_ADDITION");
        n = new c("SESSION_PAUSED_ENTER_CLARIFY", 12, 3003, "Session Paused ENTER_CLARIFY");
        o = new c("SESSION_PAUSED_ENTER_MANUAL_OPERATION", 13, 3004, "Session Paused ENTER_MANUAL_OPERATION");
        p = new c("SESSION_PAUSED_USER_INTERRUPTED", 14, 3006, "Session Paused USER_INTERRUPTED");
        c[] r0 = d();
        s = r0;
        t = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f28406a = new a(null);
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(s.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
