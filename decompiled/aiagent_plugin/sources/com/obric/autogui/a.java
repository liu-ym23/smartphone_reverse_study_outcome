package com.obric.autogui;

import android.content.Context;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.o;

/* JADX INFO: compiled from: AutoGUI.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {

    /* JADX INFO: renamed from: com.obric.autogui.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoGUI.kt */
    @f(b = "AutoGUI.kt", c = {47, 58, 59}, d = "checkAndFireTask", e = "com.obric.autogui.AutoGUI")
    static final class C0653a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f26083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f26084c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f26085d;

        C0653a(a r3, d.c.d<? super C0653a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26084c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26083b = r3;
            this.f26085d |= Integer.MIN_VALUE;
            return this.f26084c.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public a() {
    }

    @Override // com.obric.autogui.b
    public e a(b.C0722b r2) {
        o.e(r2, "params");
        com.obric.autogui.b.b.f28935a.a();
        Loog.INSTANCE.i("AutoGUI", "[INIT] libautogui");
        return e.f29014b.a();
    }

    @Override // com.obric.autogui.b
    public Object a(AutoOperateTask r3, d.c.d<? super e> r4) {
        return b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.b
    public e a(String r4) {
        e r3 = com.obric.autogui.b.b.f28935a.a(r4);
        if (r3.g() == true) goto L5;
        Loog.INSTANCE.e("AutoGUI", "failed to stop the ongoing task; reason=" + r3.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
    L5:
        return r3;
    }

    public final Object b(AutoOperateTask r8, d.c.d<? super e> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, C0653a.class) == false) goto L7;
        C0653a r0 = (C0653a) ZeusTransformUtils.preCheckCast(r10, C0653a.class, "com.obric.aiagent.plugin");
        if ((r0.f26085d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f26085d -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f26083b;
        Object r11 = d.c.a.b.a();
        int r2 = r0.f26085d;
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L15;
        e r12 = (e) ZeusTransformUtils.preCheckCast(r0.f26082a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        return r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r7);
    L28:
        e r13 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.aiagent.plugin");
        if (r13.g() == true) goto L35;
        com.obric.autogui.b.b r14 = com.obric.autogui.b.b.f28935a;
        r0.f26082a = r13;
        r0.f26085d = 3;
        if (r14.a(null, r13, 3, r0) != r11) goto L37;
        return r11;
    L37:
        return r13;
    L35:
        return e.f29014b.a();
    L17:
        e r15 = (e) ZeusTransformUtils.preCheckCast(r0.f26082a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        return r15;
    L18:
        d.o.a(r7);
        e r16 = r8.checkParameters();
        if (r16.g() == true) goto L25;
        com.obric.autogui.b.b r17 = com.obric.autogui.b.b.f28935a;
        r0.f26082a = r16;
        r0.f26085d = 1;
        if (r17.a(null, r16, 3, r0) != r11) goto L24;
        return r11;
    L24:
        return r16;
    L25:
        Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.b.b.f28935a.a(null);
        com.obric.autogui.b.b r3 = com.obric.autogui.b.b.f28935a;
        r0.f26085d = 2;
        r7 = r3.a(r18, r8, r0);
        if (r7 != r11) goto L28;
        return r11;
    L7:
        r0 = new C0653a(this, r10);
        goto L8
    }
}
