package com.obric.autoaction.app.launcherpage.detail.base.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.detail.shortcut.data.g;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskSpec;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: TaskValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "TaskValidator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23241a = null;

    /* JADX INFO: compiled from: TaskValidator.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TaskValidator.kt */
    @f(b = "TaskValidator.kt", c = {38}, d = "checkQuery", e = "com.obric.autoaction.app.launcherpage.detail.base.repository.TaskValidator")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f23242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f23243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f23244c;

        b(c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23243b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23242a = r3;
            this.f23244c |= Integer.MIN_VALUE;
            return this.f23243b.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.base.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskValidator.kt */
    @f(b = "TaskValidator.kt", c = {ITaskManager.Stub.TRANSACTION_tryActiveAgent}, d = "checkShortcutInstruct", e = "com.obric.autoaction.app.launcherpage.detail.base.repository.TaskValidator")
    static final class C0507c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f23246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f23247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f23248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f23249e;
        final /* synthetic */ c f;
        int g;

        C0507c(c r3, d.c.d<? super C0507c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23249e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskValidator.kt */
    @f(b = "TaskValidator.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.base.repository.TaskValidator$checkShortcutInstruct$isInstructionOk$1")
    static final class d extends l implements m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23251b;

        d(String r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23251b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f23251b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f23250a != 0) goto L7;
            o.a(r2);
            return d.c.b.a.b.a(AOPlatformTools.INSTANCE.security().checkSensitiveWord(this.f23251b));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f23241a = new a(null);
    }

    private static final String a() {
        return "checkQuery";
    }

    public static /* synthetic */ String lambda$4VXpized2rtO3m9PMM_KoRGtVGY(com.obric.autogui.common.d r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$ELiYlCVNOO8ZrcA72RhIZt2NEiY() {
        return a();
    }

    public c() {
    }

    public final Object a(String r5, String r6, String r7, d.c.d<? super com.obric.autoaction.app.launcherpage.detail.base.a.d> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if ((r0.f23244c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f23244c -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f23242a;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f23244c;
        boolean r3 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r4);
    L25:
        final com.obric.autogui.common.d r11 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.dp(TAG, new $$Lambda$c$4VXpized2rtO3m9PMM_KoRGtVGY(r11), $$Lambda$c$ELiYlCVNOO8ZrcA72RhIZt2NEiY.INSTANCE);
        if (r11 == null) goto L31;
        com.obric.autoaction.app.launcherpage.detail.shortcut.data.b r12 = (com.obric.autoaction.app.launcherpage.detail.shortcut.data.b) ZeusTransformUtils.preCheckCast(r11.a(), com.obric.autoaction.app.launcherpage.detail.shortcut.data.b.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L31;
        String r13 = r12.b();
        if (r13 == null) goto L31;
    L33:
        if (r11 != null) goto L35;
    L37:
        r3 = false;
    L39:
        if (r3 == true) goto L46;
        if (r11 == null) goto L43;
        String r14 = r11.h();
        if (r14 == null) goto L43;
    L45:
        return new com.obric.autoaction.app.launcherpage.detail.base.a.d.a(-102, r13, r14);
    L43:
        r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.network_exception_retry, WsChannelMultiProcessSharedProvider.STRING_TYPE, "network_exception_retry"));
        d.h.b.o.c(r14, "getString(...)");
        goto L45
    L46:
        com.obric.autoaction.app.launcherpage.detail.shortcut.data.b r15 = (com.obric.autoaction.app.launcherpage.detail.shortcut.data.b) ZeusTransformUtils.preCheckCast(r11.a(), com.obric.autoaction.app.launcherpage.detail.shortcut.data.b.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L49;
        String r16 = r15.a();
    L51:
        if (d.h.b.o.a(r16, "无风险") == true) goto L60;
        com.obric.autoaction.app.launcherpage.detail.shortcut.data.b r17 = (com.obric.autoaction.app.launcherpage.detail.shortcut.data.b) ZeusTransformUtils.preCheckCast(r11.a(), com.obric.autoaction.app.launcherpage.detail.shortcut.data.b.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L56;
        String r18 = r17.b();
        if (r18 == null) goto L56;
    L58:
        return new com.obric.autoaction.app.launcherpage.detail.base.a.d.a(-102, r13, r18);
    L56:
        r18 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.server_check_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "server_check_failed"));
        d.h.b.o.c(r18, "getString(...)");
        goto L58
    L60:
        return com.obric.autoaction.app.launcherpage.detail.base.a.d.b.f23255a;
    L49:
        r16 = null;
        goto L51
    L35:
        if (r11.g() != true) goto L37;
    L31:
        r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.network_exception_retry, WsChannelMultiProcessSharedProvider.STRING_TYPE, "network_exception_retry"));
        d.h.b.o.c(r13, "getString(...)");
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_check_query", true) == true) goto L19;
        return com.obric.autoaction.app.launcherpage.detail.base.a.d.b.f23255a;
    L19:
        if (d.h.b.o.a(r5, r6) == true) goto L21;
        g r19 = g.f23539a;
        r0.f23244c = 1;
        r4 = r19.a(r6, r7, r0);
        if (r4 != r10) goto L25;
        return r10;
    L21:
        return com.obric.autoaction.app.launcherpage.detail.base.a.d.b.f23255a;
    L7:
        r0 = new b(this, r9);
        goto L8
    }

    private static final String a(com.obric.autogui.common.d r3) {
        StringBuilder r0 = new StringBuilder().append("checkQuery, serverCheck = ").append(r3).append(", payload = ");
        if (r3 == null) goto L5;
        com.obric.autoaction.app.launcherpage.detail.shortcut.data.b r4 = (com.obric.autoaction.app.launcherpage.detail.shortcut.data.b) ZeusTransformUtils.preCheckCast(r3.a(), com.obric.autoaction.app.launcherpage.detail.shortcut.data.b.class, "com.obric.aiagent.plugin");
    L7:
        return r0.append(r4).toString();
    L5:
        r4 = null;
        goto L7
    }

    public static /* synthetic */ Object a(c r1, ShortcutTaskSpec r2, List r3, String r4, d.c.d r5, int r6, Object r7) {
        List<? extends EventTask> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autoaction.app.launcherpage.detail.base.a.d> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        return r1.a(r2, r8, r4, r9);
    }

    public final Object a(ShortcutTaskSpec r21, List<? extends EventTask> r22, String r23, d.c.d<? super com.obric.autoaction.app.launcherpage.detail.base.a.d> r24) {
        String r0 = r23;
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, C0507c.class) == false) goto L7;
        C0507c r4 = (C0507c) ZeusTransformUtils.preCheckCast(r3, C0507c.class, "com.obric.aiagent.plugin");
        if ((r4.g & Integer.MIN_VALUE) == 0) goto L7;
        r4.g -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f23249e;
        Object r6 = d.c.a.b.a();
        int r7 = r4.g;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.f23248d, String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.f23247c, String.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.preCheckCast(r4.f23246b, List.class, "com.obric.aiagent.plugin");
        ShortcutTaskSpec r10 = (ShortcutTaskSpec) ZeusTransformUtils.preCheckCast(r4.f23245a, ShortcutTaskSpec.class, "com.obric.aiagent.plugin");
        o.a(r5);
        String r11 = r2;
        r0 = r8;
        ShortcutTaskSpec r13 = r10;
        r1 = r9;
    L58:
        boolean r12 = ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        Loog.INSTANCE.d(TAG, "checkShortcutInstruct isInstructionOk = " + r12);
        if (r12 == true) goto L63;
        String r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.shortcut_instruct_sensitive_words_tip, WsChannelMultiProcessSharedProvider.STRING_TYPE, "shortcut_instruct_sensitive_words_tip"));
        d.h.b.o.c(r14, "getString(...)");
        return new com.obric.autoaction.app.launcherpage.detail.base.a.d.a(-100, r14, null, 4, null);
    L63:
        if (r1 == null) goto L82;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r15.iterator();
    L66:
        if (r17.hasNext() == false) goto L81;
        Object r18 = r17.next();
        EventTask r19 = (EventTask) ZeusTransformUtils.preCheckCast(r18, EventTask.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r0, r19.getId()) == false) goto L70;
    L78:
        boolean r20 = false;
    L79:
        if (r20 == false) goto L66;
        r16.add(r18);
        goto L66
    L70:
        if (ZeusTransformUtils.instanceOf(r19, ShortcutTask.class) == false) goto L72;
        ShortcutTask r25 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r19, ShortcutTask.class, "com.obric.aiagent.plugin");
    L73:
        if (r25 == null) goto L75;
        String r26 = r25.getShortInstruct();
    L76:
        if (r26 == null) goto L78;
        r20 = true;
        goto L79
    L75:
        r26 = null;
        goto L76
    L72:
        r25 = null;
        goto L73
    L81:
        List r27 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");
    L83:
        if (r27 == null) goto L110;
        Iterator r28 = ((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L86:
        if (r28.hasNext() == false) goto L108;
        Object r29 = r28.next();
        EventTask r30 = (EventTask) ZeusTransformUtils.preCheckCast(r29, EventTask.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r30, ShortcutTask.class) == false) goto L90;
        ShortcutTask r31 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r30, ShortcutTask.class, "com.obric.aiagent.plugin");
    L91:
        if (r31 == null) goto L93;
        String r32 = r31.getShortInstruct();
    L95:
        if (d.h.b.o.a(r32, r11) == true) goto L97;
    L105:
        boolean r33 = false;
    L106:
        if (r33 == false) goto L86;
    L109:
        EventTask r34 = (EventTask) ZeusTransformUtils.preCheckCast(r29, EventTask.class, "com.obric.aiagent.plugin");
    L111:
        if (r34 != null) goto L113;
    L116:
        if (r27 == null) goto L132;
        Iterable r35 = (Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.aiagent.plugin");
        Collection r36 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r37 = r35.iterator();
    L119:
        if (r37.hasNext() == false) goto L131;
        Object r38 = r37.next();
        EventTask r39 = (EventTask) ZeusTransformUtils.preCheckCast(r38, EventTask.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r39, ShortcutTask.class) == false) goto L123;
        ShortcutTask r40 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r39, ShortcutTask.class, "com.obric.aiagent.plugin");
    L124:
        if (r40 != null) goto L126;
    L128:
        boolean r41 = false;
    L129:
        if (r41 == false) goto L119;
        r36.add(r38);
        goto L119
    L126:
        if (r40.isShortInstructEnable() != true) goto L128;
        r41 = true;
        goto L129
    L123:
        r40 = null;
        goto L124
    L131:
        int r42 = ((List) ZeusTransformUtils.preCheckCast(r36, List.class, "com.obric.aiagent.plugin")).size();
    L134:
        if (d.h.b.o.a(r13.isShortInstructEnable(), d.c.b.a.b.a(true)) == true) goto L136;
    L138:
        boolean r43 = false;
    L139:
        if (r43 == false) goto L143;
        String r110 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.shortcut_instruct_limit_tip, WsChannelMultiProcessSharedProvider.STRING_TYPE, "shortcut_instruct_limit_tip"), new Object[]{"20"});
        d.h.b.o.c(r110, "getString(...)");
        return new com.obric.autoaction.app.launcherpage.detail.base.a.d.a(-101, r110, null, 4, null);
    L143:
        return com.obric.autoaction.app.launcherpage.detail.base.a.d.b.f23255a;
    L136:
        if (r42 < 20) goto L138;
        r43 = true;
        goto L139
    L132:
        r42 = 0;
        goto L134
    L113:
        if (d.h.b.o.a(r13.isShortInstructEnable(), d.c.b.a.b.a(true)) == false) goto L116;
        String r44 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.shortcut_instruct_duplicate_tip, WsChannelMultiProcessSharedProvider.STRING_TYPE, "shortcut_instruct_duplicate_tip"));
        d.h.b.o.c(r44, "getString(...)");
        return new com.obric.autoaction.app.launcherpage.detail.base.a.d.a(-101, r44, null, 4, null);
    L97:
        if (ZeusTransformUtils.instanceOf(r30, ShortcutTask.class) == false) goto L99;
        ShortcutTask r45 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r30, ShortcutTask.class, "com.obric.aiagent.plugin");
    L100:
        if (r45 == null) goto L102;
        boolean r46 = r45.isShortInstructEnable();
    L103:
        if (r46 == false) goto L105;
        r33 = true;
        goto L106
    L102:
        r46 = false;
        goto L103
    L99:
        r45 = null;
        goto L100
    L93:
        r32 = null;
        goto L95
    L90:
        r31 = null;
        goto L91
    L108:
        r29 = null;
        goto L109
    L110:
        r34 = null;
        goto L111
    L82:
        r27 = null;
        goto L83
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r5);
        if (r1 == null) goto L24;
        Iterator r47 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r47.hasNext() == false) goto L22;
        Object r48 = r47.next();
        if (d.h.b.o.a(((EventTask) ZeusTransformUtils.preCheckCast(r48, EventTask.class, "com.obric.aiagent.plugin")).getId(), r0) == false) goto L18;
    L23:
        EventTask r49 = (EventTask) ZeusTransformUtils.preCheckCast(r48, EventTask.class, "com.obric.aiagent.plugin");
    L26:
        if (ZeusTransformUtils.instanceOf(r49, ShortcutTask.class) == false) goto L28;
        ShortcutTask r50 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r49, ShortcutTask.class, "com.obric.aiagent.plugin");
    L29:
        r11 = r21.getShortInstruct();
        if (d.h.b.o.a(r21.isShortInstructEnable(), d.c.b.a.b.a(true)) == false) goto L41;
        CharSequence r111 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r111 != null) goto L34;
    L37:
        boolean r112 = true;
    L38:
        if (r112 == false) goto L41;
        String r113 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.shortcut_instruct_empty_tip, WsChannelMultiProcessSharedProvider.STRING_TYPE, "shortcut_instruct_empty_tip"));
        d.h.b.o.c(r113, "getString(...)");
        return new com.obric.autoaction.app.launcherpage.detail.base.a.d.a(-100, r113, null, 4, null);
    L34:
        if (r111.length() == 0) goto L37;
        r112 = false;
    L41:
        if (r11 != null) goto L43;
    L48:
        boolean r114 = false;
    L49:
        if (r114 == false) goto L143;
        if (r50 == null) goto L52;
        String r51 = r50.getShortInstruct();
    L54:
        if (d.h.b.o.a(r51, r11) == true) goto L62;
        d.c.g r52 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");
        m r115 = (m) ZeusTransformUtils.preCheckCast(new d(r11, null), m.class, "com.obric.aiagent.plugin");
        r13 = r21;
        r4.f23245a = r13;
        r4.f23246b = r1;
        r4.f23247c = r0;
        r4.f23248d = r11;
        r4.g = 1;
        r5 = i.a(r52, r115, r4);
        if (r5 != r6) goto L58;
        return r6;
    L62:
        r13 = r21;
        goto L63
    L52:
        r51 = null;
        goto L54
    L43:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L45;
        boolean r116 = true;
    L46:
        if (r116 != true) goto L48;
        r114 = true;
        goto L49
    L45:
        r116 = false;
        goto L46
    L28:
        r50 = null;
        goto L29
    L22:
        r48 = null;
        goto L23
    L24:
        r49 = null;
    L7:
        r4 = new C0507c(this, r3);
        goto L8
    }
}
