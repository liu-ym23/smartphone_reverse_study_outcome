package com.obric.autogui.session.d;

import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: AutoGuiExecutionConsent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f30886a = null;

    /* JADX INFO: compiled from: AutoGuiExecutionConsent.kt */
    /* synthetic */ class a extends d.h.b.l implements d.h.a.a<Integer> {
        a(Object r8) {
            super(0, r8, d.class, "readHostScene", "readHostScene()Ljava/lang/Integer;", 0);
        }

        public final Integer a() {
            return d.a((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: AutoGuiExecutionConsent.kt */
    /* synthetic */ class b extends d.h.b.l implements d.h.a.a<Integer> {
        b(Object r8) {
            super(0, r8, d.class, "readHostScene", "readHostScene()Ljava/lang/Integer;", 0);
        }

        public final Integer a() {
            return d.a((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    static {
        f30886a = new d();
    }

    public static /* synthetic */ x lambda$psVk4hv7gYYvRUhwwfwhtSwkLy4() {
        return b();
    }

    private d() {
    }

    public static final /* synthetic */ Integer a(d r0) {
        return r0.a();
    }

    public static /* synthetic */ boolean a(d r1, d.h.a.a r2, int r3, Object r4) {
        d.h.a.a<Integer> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r1), d.h.a.a.class, "com.obric.aiagent.plugin");
    L6:
        return r1.a(r5);
    }

    public final boolean a(d.h.a.a<Integer> r3) {
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r2, "readScene");
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r2.invoke(), Integer.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
        if (r4 == null) goto L13;
        if (r4.intValue() == 2) goto L9;
        return false;
    L9:
        return true;
    L13:
        return false;
    L15:
        return false;
    }

    public static /* synthetic */ Object a(d r1, d.h.a.a r2, d.h.a.a r3, d.h.a.b r4, d.c.d r5, int r6, Object r7) {
        d.h.a.a<Integer> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r1), d.h.a.a.class, "com.obric.aiagent.plugin");
    L6:
        if ((r6 & 2) == 0) goto L9;
        r9 = $$Lambda$d$psVk4hv7gYYvRUhwwfwhtSwkLy4.INSTANCE;
    L9:
        return r1.a(r8, r9, r10, r11);
    }

    private static final x b() {
        return x.f38692a;
    }

    public final <T> Object a(d.h.a.a<Integer> r3, d.h.a.a<x> r4, d.h.a.b<? super d.c.d<? super T>, ? extends Object> r5, d.c.d<? super T> r6) {
        d.h.a.a<Integer> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (a(r7) == true) goto L7;
        r8.invoke();
        return null;
    L7:
        return r9.invoke(r10);
    }

    private final Integer a() {
        IFlowSettingsIDL r0 = at.a(aa.b(IFlowSettingsIDL.class));
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getAutoGuiEnabledScene());
    }
}
