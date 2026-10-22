package com.obric.autoaction;

import android.content.ComponentName;
import com.obric.autoaction.vdplayer.tracking.b;
import com.obric.autogui.agents.vlm.models.omni.a.e;
import com.obric.autogui.api.IOAutoStateManager;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.autogui.common.api.presentation.WidgetStateType;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.session.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.i;
import d.a.p;
import d.h.b.h;
import d.n;
import d.n.j;
import d.n.m;
import d.o;
import d.s;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: OmniTaskStateProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OmniTaskStateManagerImpl implements IOAutoStateManager {
    public static final a Companion = null;
    private static final String TAG = "OmniStateManager";

    /* JADX INFO: compiled from: OmniTaskStateProvider.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ boolean lambda$d3quNd3lVwgsc2M2YpBKV92QJ0Y(File r0) {
        return getOmniJournalPath$lambda$5$lambda$3(r0);
    }

    public static /* synthetic */ String lambda$dCHvHHlB19LtX9qVpRq1DFJwGMs(File r0) {
        return getOmniJournalPath$lambda$5$lambda$4(r0);
    }

    public OmniTaskStateManagerImpl() {
    }

    @Override // com.obric.autogui.api.IOAutoStateManager
    public com.obric.autogui.api.a fetchTopDisplayed() {
        Object r2 = null;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L13
        OmniTaskStateManagerImpl r7 = (OmniTaskStateManagerImpl) ZeusTransformUtils.preCheckCast(this, OmniTaskStateManagerImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        DisplayedAppInfo r4 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();     // Catch: Throwable -> L13
        Loog r5 = Loog.INSTANCE;     // Catch: Throwable -> L13
        StringBuilder r6 = new StringBuilder().append("fetchTopDisplayed topActivity=");     // Catch: Throwable -> L13
        if (r4 == null) goto L6;
        ComponentName r8 = r4.getTopActivity();     // Catch: Throwable -> L13
    L7:
        r5.i(TAG, r6.append(r8).toString());     // Catch: Throwable -> L13
        if (r4 == null) goto L10;
        com.obric.autogui.api.a r9 = r7.toApiModel(r4);     // Catch: Throwable -> L13
    L11:
        Object r10 = n.f(r9);     // Catch: Throwable -> L13
    L15:
        Throwable r11 = n.c(r10);
        if (r11 == null) goto L19;
        Loog.INSTANCE.e(TAG, "fetchTopDisplayed failed: " + r11);
    L19:
        if (n.b(r10) == true) goto L23;
        r2 = r10;
    L23:
        return (com.obric.autogui.api.a) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.api.a.class, "com.obric.aiagent.plugin");
    L10:
        r9 = null;
        goto L11
    L6:
        r8 = null;
    L13:
        th = move-exception;
        n.a r12 = n.f38560a;
        r10 = n.f(o.a(th));
        goto L15
    }

    private final com.obric.autogui.api.a toApiModel(DisplayedAppInfo r9) {
        DisplayedAppInfo r8 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r9, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        return new com.obric.autogui.api.a(r8.getTaskId(), r8.isVisible(), r8.getTopActivity(), r8.getBaseActivity(), r8.getRealActivity(), r8.getData(), r8.getTaskLabel());
    }

    @Override // com.obric.autogui.api.IOAutoStateManager
    public IOAutoStateManager.a getCurrentState(String r4) {
        IAutoActionAgentEventListener.SessionInfo r3 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(IAutoActionAgentApi.IMPL.getOngoingSessionInfo().a(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return new IOAutoStateManager.a(-1, null, 2, null);
    L7:
        if (d.h.b.o.a(r3.getSessionId(), r4) == false) goto L9;
        WidgetState r5 = ((GlobalUIContext) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState().c(), GlobalUIContext.class, "com.obric.aiagent.plugin")).getWidgetState();
        if (r5 == null) goto L13;
        int r6 = r5.getWidgetStateType();
    L15:
        return new IOAutoStateManager.a(0, Integer.valueOf(r6));
    L13:
        r6 = WidgetStateType.Operating.getValue();
        goto L15
    L9:
        return new IOAutoStateManager.a(-2, null, 2, null);
    }

    @Override // com.obric.autogui.api.IOAutoStateManager
    public boolean stopTask(String r10, String r11, int r12, Map<String, String> r13) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "ext");
        Loog.INSTANCE.d(TAG, "stopTask, sessionId: " + r10 + ", message: " + r11 + ", reason: " + r12);
        IAutoActionAgentEventListener.SessionInfo r9 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(IAutoActionAgentApi.IMPL.getOngoingSessionInfo().a(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L6;
        return false;
    L6:
        if (d.h.b.o.a(r9.getSessionId(), r10) == true) goto L8;
        return false;
    L8:
        if (r11 != null) goto L10;
        r11 = "用户停止了当前任务";
    L10:
        IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default((IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin"), r9.getSessionKey(), r11, r12, null, r6, 8, null);
        return true;
    }

    @Override // com.obric.autogui.api.IOAutoStateManager
    public List<String> getOmniJournalPath(String r6) {
        Object r0 = null;
        if (r6 != null) goto L5;
    L40:
        return null;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L40;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L32
        OmniTaskStateManagerImpl r5 = (OmniTaskStateManagerImpl) ZeusTransformUtils.preCheckCast(this, OmniTaskStateManagerImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        File r7 = new File(c.f30720a.a(), "id_" + r6);     // Catch: Throwable -> L32
        if (r7.exists() == true) goto L13;
    L31:
        return null;
    L13:
        if (r7.isDirectory() == false) goto L31;
        File[] r8 = r7.listFiles();     // Catch: Throwable -> L32
        if (r8 == null) goto L28;
        j r9 = i.k(r8);     // Catch: Throwable -> L32
        if (r9 == null) goto L28;
        j r10 = m.a(r9, $$Lambda$OmniTaskStateManagerImpl$d3quNd3lVwgsc2M2YpBKV92QJ0Y.INSTANCE);     // Catch: Throwable -> L32
        if (r10 == null) goto L28;
        j r11 = m.d(r10, $$Lambda$OmniTaskStateManagerImpl$dCHvHHlB19LtX9qVpRq1DFJwGMs.INSTANCE);     // Catch: Throwable -> L32
        if (r11 == null) goto L28;
        j r12 = m.f(r11);     // Catch: Throwable -> L32
        if (r12 == null) goto L28;
        List r13 = m.g(r12);     // Catch: Throwable -> L32
        if (r13 == null) goto L28;
    L29:
        Object r14 = n.f(r13);     // Catch: Throwable -> L32
    L35:
        if (n.b(r14) == true) goto L39;
        r0 = r14;
    L39:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L28:
        r13 = p.b();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        n.a r15 = n.f38560a;
        r14 = n.f(o.a(th));
        goto L35
    }

    private static final boolean getOmniJournalPath$lambda$5$lambda$3(File r0) {
        return r0.isDirectory();
    }

    private static final String getOmniJournalPath$lambda$5$lambda$4(File r0) {
        return r0.getAbsolutePath();
    }

    @Override // com.obric.autogui.api.IOAutoStateManager
    public void drainOmniUploadImagesForFeedback(String r2) {
        drainOmniUploadImagesForFeedback(r2, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.autogui.api.IOAutoStateManager
    public void drainOmniUploadImagesForFeedback(String r10, IOAutoStateManager.b r11) {
        if (r10 == null) goto L42;
        e r0 = null;
        com.obric.autogui.agents.vlm.models.omni.a.j r1 = null;
        r1 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r10 = null;
    L7:
        if (r10 == null) goto L43;
        Loog r9 = Loog.INSTANCE;
        StringBuilder r2 = new StringBuilder().append("drainOmniUploadImagesForFeedback: sessionId=").append(r10).append(", type=");
        if (r11 == null) goto L12;
        String r3 = r11.getType();
    L13:
        String r4 = "";
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        StringBuilder r5 = r2.append(r3).append(", source=");
        if (r11 == null) goto L19;
        String r6 = r11.c();
    L20:
        if (r6 == null) goto L23;
        r4 = r6;
    L23:
        StringBuilder r7 = r5.append(r4).append(", amount=");
        if (r11 == null) goto L26;
        Integer r8 = r11.f();
    L27:
        r9.i(TAG, r7.append(r8).toString());
        com.obric.autogui.agents.vlm.models.omni.upload.e r12 = com.obric.autogui.agents.vlm.models.omni.upload.e.f28643a;
        if (r11 == null) goto L38;
        String r13 = r11.a();
        List<String> r14 = r11.b();
        String r15 = r11.c();
        if (r15 == null) goto L37;
        com.obric.autogui.agents.vlm.models.omni.a.j[] r16 = com.obric.autogui.agents.vlm.models.omni.a.j.values();
        int r17 = 0;
        int r18 = r16.length;
    L32:
        if (r17 >= r18) goto L37;
        com.obric.autogui.agents.vlm.models.omni.a.j r19 = r16[r17];
        if (d.h.b.o.a(r19.a(), r15) == true) goto L35;
        r17 = r17 + 1;
        goto L32
    L35:
        r1 = r19;
    L37:
        r0 = new e(r13, r14, r1, r11.getType(), r11.d(), r11.e(), r11.f());
    L38:
        r12.a(r10, r0);
        return;
    L26:
        r8 = null;
        goto L27
    L19:
        r6 = null;
        goto L20
    L12:
        r3 = null;
        goto L13
    L43:
        return;
    }

    @Override // com.obric.autogui.api.IOAutoStateManager
    public void onOmniInferenceImageUploadStarted(String r1) {
        d.h.b.o.e(r1, "requestToken");
        com.obric.autogui.agents.vlm.models.omni.upload.e.f28643a.b(r1);
    }

    @Override // com.obric.autogui.api.IOAutoStateManager
    public void onOmniInferenceImageUploadFinished(String r1) {
        d.h.b.o.e(r1, "requestToken");
        com.obric.autogui.agents.vlm.models.omni.upload.e.f28643a.e(r1);
    }

    @Override // com.obric.autogui.api.IOAutoStateManager
    public Map<String, Object> getOmniExtraLog(String r4) {
        if (r4 != null) goto L6;
        return ao.b();
    L6:
        return ao.b(new d.m[]{s.a("virtual_display_duration", Long.valueOf(b.f26072a.a(r4))), s.a("wait_user_duration", Long.valueOf(com.obric.autogui.session.functions.impl.b.a.f31063a.d(r4)))});
    }
}
