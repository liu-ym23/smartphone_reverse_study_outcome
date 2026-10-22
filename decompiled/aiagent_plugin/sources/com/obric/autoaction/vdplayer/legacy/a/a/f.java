package com.obric.autoaction.vdplayer.legacy.a.a;

import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.m;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: OpenAssistInputUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25659a = null;

    /* JADX INFO: compiled from: OpenAssistInputUseCase.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ Map a(a r0, String r1, String r2, IAutoActionAgentEventListener.SessionInfo r3, String r4) {
            return r0.a(r1, r2, r3, r4);
        }

        private final Map<String, String> a(String r7, String r8, IAutoActionAgentEventListener.SessionInfo r9, String r10) {
            String r6 = null;
            if (r9 == null) goto L5;
            String r0 = r9.getInstructionType();
        L6:
            String r1 = "";
            if (r0 != null) goto L9;
            r0 = "";
        L9:
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
            if (r2.length() != 0) goto L12;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L17;
            if (r10 != null) goto L16;
            r10 = "";
        L16:
            r2 = r10;
        L17:
            String r11 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
            m[] r4 = new m[7];
            if (r7 != null) goto L20;
            r7 = "";
        L20:
            r4[0] = s.a("action_button_type", r7);
            r4[1] = s.a("enter_from", "vd_player");
            if (r8 != null) goto L23;
            r8 = "";
        L23:
            r4[2] = s.a("source_from", r8);
            r4[3] = s.a("instruction_type", r11);
            if (r9 == null) goto L26;
            String r12 = r9.getToolId();
        L27:
            if (r12 != null) goto L29;
            r12 = "";
        L29:
            r4[4] = s.a("tool_id", r12);
            if (r9 == null) goto L32;
            String r13 = r9.getToolName();
        L33:
            if (r13 != null) goto L35;
            r13 = "";
        L35:
            r4[5] = s.a("tool_name", r13);
            if (r9 == null) goto L38;
            r6 = r9.getActionType();
        L38:
            if (r6 == null) goto L41;
            r1 = r6;
        L41:
            r4[6] = s.a("action_type", r1);
            return ao.a(r4);
        L32:
            r13 = null;
            goto L33
        L26:
            r12 = null;
            goto L27
        L12:
            r3 = false;
            goto L13
        L5:
            r0 = null;
            goto L6
        }
    }

    static {
        f25659a = new a(null);
    }

    public f() {
    }

    public static /* synthetic */ void a(f r1, String r2, String r3, IAutoActionAgentEventListener.SessionInfo r4, String r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        r1.a(r2, r3, r4, r5);
    }

    public final void a(String r1, String r2, IAutoActionAgentEventListener.SessionInfo r3, String r4) {
        Map<String, String> r0 = a.a(f25659a, r1, r2, r3, r4);
        IAssistInputHost r5 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        r5.openInput(true, r0);
        return;
    }
}
