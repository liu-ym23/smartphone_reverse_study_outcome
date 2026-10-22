package com.obric.autoaction.presentation.input;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IslandState;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi;
import com.obric.autogui.util.e;
import com.obric.eventkit.EventsTaskSdk;
import com.obric.eventkit.eventstaskmanager.StateInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.m;
import d.s;
import d.x;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: AssistInputUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "AssistInput";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f24958a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.h.a.b<a, x> f24959b = null;

    /* JADX INFO: compiled from: AssistInputUtils.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f24960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f24961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f24962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<String, String> f24963d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f24960a == r6.f24960a) goto L12;
            return false;
        L12:
            if (this.f24961b == r6.f24961b) goto L15;
            return false;
        L15:
            if (o.a(this.f24962c, r6.f24962c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f24963d, r6.f24963d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((Boolean.hashCode(this.f24960a) * 31) + Boolean.hashCode(this.f24961b)) * 31;
            String r1 = this.f24962c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Map<String, String> r5 = this.f24963d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "OpenInputParams(force=" + this.f24960a + ", startWithAsr=" + this.f24961b + ", meta=" + this.f24962c + ", ext=" + this.f24963d + ')';
        }

        public a(boolean r3, boolean r4, String r5, Map<String, String> r6) {
            Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            this.f24960a = r3;
            this.f24961b = r4;
            this.f24962c = r5;
            this.f24963d = r7;
        }

        public final boolean a() {
            return this.f24960a;
        }

        public final boolean b() {
            return this.f24961b;
        }

        public final String c() {
            return this.f24962c;
        }

        public final Map<String, String> d() {
            return this.f24963d;
        }
    }

    private static final String g() {
        return "startInput";
    }

    private static final String h() {
        return "cancelInput";
    }

    private static final String i() {
        return "openInput";
    }

    private static final String j() {
        return "openInput";
    }

    public static /* synthetic */ String lambda$5EnXNd2iHiZHKJg0f0y9z03f7Bc(StateInfo r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$CrwFNorsXcb4Yw54D0z9hwBdX90() {
        return h();
    }

    public static /* synthetic */ x lambda$Hk8yaSpXePgaMV1O2mBExlE09oE(a r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$IPDIKRpZ6R4awWK6bLyXOog96MQ() {
        return j();
    }

    public static /* synthetic */ String lambda$IPDLNbJ3zOfEeOhYGdXSe3QKZxQ() {
        return i();
    }

    public static /* synthetic */ String lambda$Nr1ducoNLwD14BvJ2Yojci9F0Bo(StateInfo r0) {
        return b(r0);
    }

    public static /* synthetic */ String lambda$TqX5E5N1Ve3TmUYI451T9fIqTQ8(StateInfo r0) {
        return c(r0);
    }

    public static /* synthetic */ String lambda$vCBf5FWDScxPd28CthQ9GsmIPwg() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$ysYs7N9LpuNhIZl-xlRs6fwInyk, reason: not valid java name */
    public static /* synthetic */ String m625lambda$ysYs7N9LpuNhIZlxlRs6fwInyk(String r0) {
        return a(r0);
    }

    private b() {
    }

    public final void a() {
        Loog.INSTANCE.d(TAG, "reset assistant state");
        EventsTaskSdk.INSTANCE.notifyAssistantState(false, new StateInfo(0, null, null, null, 0, false, false, null, 192, null));
        d();
    }

    public final void b() {
        final StateInfo r4 = e();
        if (r4 != null) goto L5;
        return;
    L5:
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$5EnXNd2iHiZHKJg0f0y9z03f7Bc(r4), $$Lambda$b$vCBf5FWDScxPd28CthQ9GsmIPwg.INSTANCE);
        EventsTaskSdk.INSTANCE.notifyAssistantState(true, r4);
    }

    private static final String a(StateInfo r2) {
        return "startInput " + r2;
    }

    public final void c() {
        final StateInfo r4 = e();
        if (r4 != null) goto L5;
        return;
    L5:
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$Nr1ducoNLwD14BvJ2Yojci9F0Bo(r4), $$Lambda$b$CrwFNorsXcb4Yw54D0z9hwBdX90.INSTANCE);
        EventsTaskSdk.INSTANCE.notifyAssistantState(false, r4);
    }

    private static final String b(StateInfo r2) {
        return "cancelInput " + r2;
    }

    static {
        f24958a = new b();
        f24959b = e.a(1000, $$Lambda$b$Hk8yaSpXePgaMV1O2mBExlE09oE.INSTANCE);
    }

    private static final x a(a r13) {
        o.e(r13, "params");
        final StateInfo r1 = f24958a.e();
        if (r1 == null) goto L5;
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$TqX5E5N1Ve3TmUYI451T9fIqTQ8(r1), $$Lambda$b$IPDLNbJ3zOfEeOhYGdXSe3QKZxQ.INSTANCE);
        Map<String, String> r0 = r1.getExt();
        if (r0 == null) goto L10;
        Map<String, String> r2 = ao.e(r0);
        if (r2 == null) goto L10;
    L11:
        String r3 = r13.c();
        if (r3 == null) goto L14;
        r2.put("o_meta", r3);
    L14:
        Map<String, String> r4 = r13.d();
        if (r4 == null) goto L18;
        r2.putAll(r4);
    L18:
        if ((!r2.isEmpty()) == true) goto L21;
        r2 = null;
    L21:
        if (r2 != null) goto L23;
        r2 = r1.getExt();
    L23:
        EventsTaskSdk.INSTANCE.openAssistantInputPanel(StateInfo.copy$default(r1, 0, null, null, null, 0, false, r13.b(), r2, 63, null), r13.a());
        return x.f38692a;
    L10:
        r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        goto L11
    L5:
        return x.f38692a;
    }

    private static final String c(StateInfo r2) {
        return "openInput " + r2;
    }

    public static /* synthetic */ void a(b r1, boolean r2, boolean r3, String r4, Map r5, int r6, Object r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = true;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r8 = null;
    L14:
        r1.a(r2, r3, r4, r8);
    }

    public final void a(boolean r2, boolean r3, String r4, Map<String, String> r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        f24959b.invoke(new a(r2, r3, r4, r1));
    }

    public final void a(final String r16, String r17, Map<String, String> r18) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        o.e(r17, "taskType");
        if (AssistantAbilityHelper.INSTANCE.isLogin((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L8;
        Loog.INSTANCE.d(TAG, "open assist login page");
        AssistantAbilityHelper r1 = AssistantAbilityHelper.INSTANCE;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName();
        o.c(r3, "getPackageName(...)");
        if (r1.openLogin(r2, r3) == true) goto L23;
        Loog.INSTANCE.e(TAG, "openLogin failed");
        return;
    L23:
        return;
    L8:
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$ysYs7N9LpuNhIZlxlRs6fwInyk(r16), $$Lambda$b$IPDIKRpZ6R4awWK6bLyXOog96MQ.INSTANCE);
        EventsTaskSdk r10 = EventsTaskSdk.INSTANCE;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L11;
    L14:
        boolean r12 = true;
    L15:
        Map r9 = ao.b(new m[]{s.a("o_foreground_app", f())});
        if (r0 == null) goto L19;
        r9.putAll(r0);
    L19:
        if (o.a(r17, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI) == false) goto L21;
        r9.put("o_omni_instruction_type", "shortcut");
    L21:
        x r5 = x.f38692a;
        r10.openAssistantInputPanel(new StateInfo(0, r16, null, r17, 0, false, r12, r9), true);
        return;
    L11:
        if (r4.length() == 0) goto L14;
        r12 = false;
        goto L15
    }

    private static final String a(String r2) {
        return "openInput " + r2;
    }

    public final void d() {
        Loog.INSTANCE.d(TAG, "closeInput");
        EventsTaskSdk.INSTANCE.closeAssistantInputPanel();
    }

    private final StateInfo e() {
        GlobalUIContext r0 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState().c(), GlobalUIContext.class, "com.obric.aiagent.plugin");
        WidgetState r1 = r0.getWidgetState();
        String r3 = null;
        if (r1 != null) goto L5;
        return null;
    L5:
        IslandState r2 = r0.getIsland();
        if (ZeusTransformUtils.instanceOf(r1, WidgetState.Clarify.class) == false) goto L8;
        int r8 = 1;
    L10:
        if (ZeusTransformUtils.instanceOf(r1, WidgetState.Clarify.class) == false) goto L12;
        String r4 = ((WidgetState.Clarify) ZeusTransformUtils.preCheckCast(r1, WidgetState.Clarify.class, "com.obric.aiagent.plugin")).getStepInfo().getAction();
    L13:
        String r9 = r4;
        if (ZeusTransformUtils.instanceOf(r1, WidgetState.Clarify.class) == false) goto L16;
        long r10 = 600000;
    L17:
        long r12 = r10;
        Integer r5 = r1.getSessionInfo().getTask().m799getTaskType();
        if (r5 != null) goto L21;
    L22:
        Integer r6 = r1.getSessionInfo().getTask().m799getTaskType();
        if (r6 != null) goto L26;
    L28:
        String r7 = IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI;
    L30:
        String r11 = r7;
        Long r13 = r1.getSessionInfo().getTask().doubaoMessageId();
        if (r13 == null) goto L33;
        r3 = r13.toString();
    L33:
        String r14 = r3;
        boolean r15 = r2.getInDialogueMode();
        m[] r16 = new m[5];
        r16[0] = s.a("o_task_source", String.valueOf(r1.getSessionInfo().getTask().getLaunchOrigin()));
        r16[1] = s.a("o_foreground_app", f());
        Integer r17 = r1.getSessionInfo().getTask().m799getTaskType();
        if (r17 != null) goto L37;
    L39:
        String r18 = "0";
    L40:
        r16[2] = s.a("is_condition_task", r18);
        String r19 = r1.getSessionInfo().getSessionId();
        if (r19 != null) goto L43;
        r19 = "";
    L43:
        r16[3] = s.a("o_omni_task_id", r19);
        r16[4] = s.a("o_complex_source_type", "gui");
        return new StateInfo(r8, r9, r14, r11, r12, r15, true, ao.a(r16));
    L37:
        if (r17.intValue() != 2) goto L39;
        r18 = "1";
        goto L40
    L26:
        if (r6.intValue() != 2) goto L28;
    L29:
        r7 = IAssistInputHost.TaskType.TASK_TYPE_AUTO_TIMER_TASK;
        goto L30
    L21:
        if (r5.intValue() == 1) goto L29;
    L16:
        r10 = 0;
        goto L17
    L12:
        r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_supplement_your_idea, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_supplement_your_idea"));
        o.c(r4, "getString(...)");
        goto L13
    L8:
        r8 = 2;
        goto L10
    }

    private final String f() {
        ComponentName r5 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        String r6 = r5.getPackageName();
        if (r6 == null) goto L6;
        return r6;
    L6:
        Collection r7 = IAutoActionVDApi.DefaultImpls.fetchMdTopAppInfo$default((IAutoActionVDApi) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE, IAutoActionVDApi.class, "com.obric.aiagent.plugin"), 1, false, 2, null);
        if (r7 == null) goto L13;
        DisplayedAppInfo r8 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")), DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L13;
        ComponentName r9 = r8.getTopActivity();
        if (r9 == null) goto L13;
        String r10 = r9.getPackageName();
    L14:
        if (r10 != null) goto L18;
        return "";
    L18:
        return r10;
    L13:
        r10 = null;
        goto L14
    }
}
