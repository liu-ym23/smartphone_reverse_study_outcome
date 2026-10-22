package com.obric.autogui.platforms.tools.input.inject;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ScreenSwipeV3.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f30293a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long[] f30294b = null;

    /* JADX INFO: compiled from: ScreenSwipeV3.kt */
    @f(b = "ScreenSwipeV3.kt", c = {76}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.input.inject.ScreenSwipeV3$swipeTail$2")
    static final class a extends l implements m<am, d.c.d<? super com.obric.autogui.common.e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f30295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f30297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f30298d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f30299e;
        int f;
        final /* synthetic */ float g;
        final /* synthetic */ float h;
        final /* synthetic */ int i;
        final /* synthetic */ float j;
        final /* synthetic */ float k;

        a(float r3, float r4, int r5, float r6, float r7, d.c.d<? super a> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            this.h = r4;
            this.i = r5;
            this.j = r6;
            this.k = r7;
            super(2, r9);
        }

        public static /* synthetic */ CharSequence lambda$St3a9FQGqb0l3TObDIUtGpZ0QvE(com.obric.autogui.common.e r0) {
            return a(r0);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.g, this.h, this.i, this.j, this.k, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r35) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f;
            if (r2 == 0) goto L12;
            if (r2 != 1) goto L11;
            int r3 = this.f30299e;
            long r6 = this.f30295a;
            com.obric.autogui.common.e r1 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(this.f30298d, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            ArrayList r8 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f30297c, ArrayList.class, "com.obric.aiagent.plugin");
            com.obric.autogui.common.e r9 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(this.f30296b, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            o.a(r35);     // Catch: Throwable -> L8
            int r11 = 1;
            int r10 = 0;
        L31:
            com.obric.autogui.common.e r4 = e.a(e.f30311a, 1, r6, SystemClock.uptimeMillis(), this.j, this.k, 0.0f, this.i, "swipe-v3-tail-up", null, 256, null);     // Catch: Throwable -> L8
            boolean r5 = r4.g();     // Catch: Throwable -> L8
            if (r1.g() == false) goto L48;
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L36;
        L38:
            Iterator r12 = r7.iterator();     // Catch: Throwable -> L8
        L40:
            if (r12.hasNext() == false) goto L44;
            if (((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.autogui.common.e.class, "com.obric.aiagent.plugin")).g() == true) goto L40;
            r11 = r10;
        L44:
            if (r11 == 0) goto L48;
            if (r4.g() == false) goto L48;
            com.obric.autogui.common.e r13 = com.obric.autogui.common.e.f29014b.a();     // Catch: Throwable -> L8
        L49:
            if (r5 == true) goto L51;
            e.a(e.f30311a, 3, r6, SystemClock.uptimeMillis(), this.j, this.k, 0.0f, this.i, "swipe-v3-tail-cancel", null, 256, null);
        L51:
            return r13;
        L36:
            if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L38;
        L48:
            r13 = c.a(c.f30293a, this.i, r9.h(), r1.h(), p.a((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, $$Lambda$c$a$St3a9FQGqb0l3TObDIUtGpZ0QvE.INSTANCE, 31, null), r4.h());     // Catch: Throwable -> L8
        L8:
            th = th;
            int r14 = r3;
        L57:
            if (r14 != 0) goto L59;
            e.a(e.f30311a, 3, r6, SystemClock.uptimeMillis(), this.j, this.k, 0.0f, this.i, "swipe-v3-tail-cancel", null, 256, null);
        L59:
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            o.a(r35);
            long r15 = SystemClock.uptimeMillis();
            long r16 = r15 - 120;
            long r17 = r16 - 16;
            com.obric.autogui.common.e r18 = e.a(e.f30311a, 0, r17, r17, this.g, this.h, 1.0f, this.i, "swipe-v3-tail-down", null, 256, null);
            if (r18.g() == true) goto L65;
            return c.a(c.f30293a, this.i, r18.h(), null, null, null, 28, null);
        L65:
            ArrayList r30 = new ArrayList(c.a().length);
            com.obric.autogui.common.e r19 = e.a(e.f30311a, 2, r17, r16, this.j, this.k, 1.0f, this.i, "swipe-v3-tail-move", null, 256, null);     // Catch: Throwable -> L54
            long[] r20 = c.a();     // Catch: Throwable -> L54
            float r110 = this.j;     // Catch: Throwable -> L54
            float r111 = this.k;     // Catch: Throwable -> L54
            int r112 = this.i;     // Catch: Throwable -> L54
            int r113 = r20.length;     // Catch: Throwable -> L54
            int r114 = 0;
            int r115 = 0;
        L19:
            if (r114 >= r113) goto L24;
            r115 = r115 + 1;     // Catch: Throwable -> L22
            long[] r36 = r20;
            int r31 = r113;
            ArrayList r116 = r30;
            long r32 = r15;
            ((Collection) ZeusTransformUtils.preCheckCast(r116, Collection.class, "com.obric.aiagent.plugin")).add(e.a(e.f30311a, 2, r17, r15 - r20[r114], r110, r111, 1.0f, r112, "swipe-v3-tail-stabilize-" + r115, null, 256, null));     // Catch: Throwable -> L22
            r114 = r114 + 1;
            r20 = r36;
            r30 = r116;
            r113 = r31;
            r15 = r32;
        L22:
            th = th;
            r6 = r17;
            r14 = 0;
            goto L57
        L24:
            ArrayList r117 = r30;
            d.c.d r21 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
            this.f30296b = r18;     // Catch: Throwable -> L54
            this.f30297c = r117;     // Catch: Throwable -> L54
            this.f30298d = r19;     // Catch: Throwable -> L54
            this.f30295a = r17;     // Catch: Throwable -> L54
            r10 = 0;
            this.f30299e = 0;     // Catch: Throwable -> L52
            r11 = 1;
            this.f = 1;     // Catch: Throwable -> L52
            if (ax.a(8, r21) != r0) goto L30;
            return r0;
        L30:
            r1 = r19;
            r6 = r17;
            r8 = r117;
            r9 = r18;
        L52:
            th = th;
        L56:
            r6 = r17;
            r14 = r10;
        L54:
            th = th;
            r10 = 0;
            goto L56
        }

        private static final CharSequence a(com.obric.autogui.common.e r2) {
            return (CharSequence) ZeusTransformUtils.preCheckCast(r2.h(), CharSequence.class, "com.obric.aiagent.plugin");
        }
    }

    private c() {
    }

    public static final /* synthetic */ com.obric.autogui.common.e a(c r0, int r1, String r2, String r3, String r4, String r5) {
        return r0.a(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ long[] a() {
        return f30294b;
    }

    static {
        f30293a = new c();
        f30294b = new long[]{32, 16};
    }

    public final Object a(int r10, float r11, float r12, float r13, float r14, d.c.d<? super com.obric.autogui.common.e> r15) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        return i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new a(r11, r12, r10, r13, r14, null), m.class, "com.obric.aiagent.plugin"), r9);
    }

    static /* synthetic */ com.obric.autogui.common.e a(c r7, int r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r13 & 8) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r13 & 16) == 0) goto L17;
        String r6 = "";
    L19:
        return r7.a(r8, r3, r4, r5, r6);
    L17:
        r6 = r12;
        goto L19
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    private final com.obric.autogui.common.e a(int r13, String r14, String r15, String r16, String r17) {
        return (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.platfom_input_swipe_failed_system, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platfom_input_swipe_failed_system"), null, 2, null), "swipe_v3_tail_error", "displayId=" + r13 + ", down=" + r14 + ", move=" + r15 + ", stabilize=" + r16 + ", up=" + r17, false, null, 0, 28, null), com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
    }
}
