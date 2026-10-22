package com.obric.autogui.operator.a.c.a;

import android.content.ComponentName;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.impl.g;
import com.obric.autogui.agents.vlm.models.impl.l;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.operator.a.c.c;
import com.obric.autogui.operator.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ActivityChangedCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f29726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f29727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29728c;

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.c.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityChangedCheck.kt */
    @f(b = "ActivityChangedCheck.kt", c = {36}, d = "perform", e = "com.obric.autogui.operator.impl.precheck.impl.ActivityChangedCheck")
    static final class C0769a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29732d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f29733e;
        int f;

        C0769a(a r3, d.c.d<? super C0769a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29733e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29732d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f29733e.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public a() {
        this(false, 1, null);
    }

    public a(boolean r1) {
        this.f29726a = r1;
        this.f29727b = p.b();
        this.f29728c = "ActivityChangedCheck";
    }

    public /* synthetic */ a(boolean r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    @Override // com.obric.autogui.operator.a.c.a
    public String a() {
        return this.f29728c;
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public Object a(d.c.d<? super Boolean> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return d.c.b.a.b.a(this.f29726a);
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public Object a(String r20, e r21, com.obric.autogui.operator.b.a r22, d.c.d<? super com.obric.autogui.common.e> r23) {
        a r0 = this;
        String r1 = r20;
        e r2 = r21;
        com.obric.autogui.operator.b.a r3 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r22, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, C0769a.class) == false) goto L7;
        C0769a r6 = (C0769a) ZeusTransformUtils.preCheckCast(r5, C0769a.class, "com.obric.aiagent.plugin");
        if ((r6.f & Integer.MIN_VALUE) == 0) goto L7;
        r6.f -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.f29732d;
        Object r8 = d.c.a.b.a();
        int r9 = r6.f;
        if (r9 == 0) goto L14;
        if (r9 != 1) goto L13;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r6.f29731c, e.class, "com.obric.aiagent.plugin");
        r1 = (String) ZeusTransformUtils.preCheckCast(r6.f29730b, String.class, "com.obric.aiagent.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(r6.f29729a, a.class, "com.obric.aiagent.plugin");
        o.a(r7);
        r2 = r4;
        r0 = r10;
    L18:
        if (ZeusTransformUtils.instanceOf(r2, l.class) == false) goto L22;
        return com.obric.autogui.common.e.f29014b.a();
    L22:
        if (ZeusTransformUtils.instanceOf(r2, g.class) == false) goto L26;
        com.obric.autogui.agents.vlm.models.a.a.b r11 = ((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin")).n();
        if (r11 == null) goto L26;
        ComponentName r12 = r11.b();
    L27:
        com.obric.autogui.session.a r13 = com.obric.autogui.session.c.f30777a.b();
        if (r13 == null) goto L30;
        com.obric.autogui.agents.vlm.b.C0677b r14 = r13.B();
    L32:
        if (r14 != null) goto L34;
    L37:
        ComponentName r15 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(r1, " - [" + r0.a() + "], current: " + r15 + ", previous: " + r12);
        if (r15 != null) goto L41;
        Loog.INSTANCE.w(r1, " - [" + r0.a() + "] Failed: current activity is null.");
        r0.a("cannot_get_cur_activity", "current activity is null");
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_no_app, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_no_app"), null, 2, null), "ignore_" + r1 + "_task_null", null, false, null, 0, 26, null);
    L41:
        Iterator<String> r16 = r0.f29727b.iterator();
    L43:
        if (r16.hasNext() == false) goto L49;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin");
        String r18 = r15.flattenToString();
        d.h.b.o.c(r18, "flattenToString(...)");
        if (d.o.o.b(r18, r17, false, 2, null) == false) goto L43;
        Loog.INSTANCE.w(r1, " - [" + r0.a() + "] Failed: current activity is in not-allowed list.");
        r0.a("in_not_allowed_list", "current activity is in not-allowed list");
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_blacklisted, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_blacklisted"), null, 2, null), "ignore_" + r1 + "_blacklisted_activity", null, false, null, 0, 26, null);
    L49:
        if (d.h.b.o.a(r15, r12) == true) goto L53;
        Loog.INSTANCE.w(r1, " - [" + r0.a() + "] Failed: activity changed.");
        r0.a("activity_changed", "top activity different");
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_activity_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_activity_changed"), null, 2, null), "ignore_" + r1 + "_activity_changed", "b=" + r12 + ", c=" + r15, false, null, 0, 24, null);
    L53:
        return com.obric.autogui.common.e.f29014b.a();
    L34:
        if (r14.f() == true) goto L37;
        Loog.INSTANCE.i(r1, " - [" + r0.a() + "] skip due to initial request.");
        return com.obric.autogui.common.e.f29014b.a();
    L30:
        r14 = null;
    L26:
        r12 = null;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r7);
        r6.f29729a = r0;
        r6.f29730b = r1;
        r6.f29731c = r2;
        r6.f = 1;
        if (super.a(r1, r2, r3, r6) != r8) goto L18;
        return r8;
    L7:
        r6 = new C0769a(r0, r5);
        goto L8
    }
}
