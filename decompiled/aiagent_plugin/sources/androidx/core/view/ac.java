package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ac {

    /* JADX INFO: compiled from: View.kt */
    @d.c.b.a.f(b = "View.kt", c = {BDVideoUploaderBase.KeyIsPrivateVideo, 416}, d = "invokeSuspend", e = "androidx.core.view.ViewKt$allViews$1")
    static final class a extends d.c.b.a.k implements d.h.a.m<d.n.l<? super View>, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f1429c;

        a(View r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f1428b = r3;
            super(2, r5);
        }

        public final Object a(d.n.l<? super View> r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f1428b, r5);
            r0.f1429c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(d.n.l<? super View> r3, d.c.d<? super d.x> r4) {
            return a((d.n.l) ZeusTransformUtils.preCheckCast(r3, d.n.l.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f1427a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r7);
        L19:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.n.l r2 = (d.n.l) ZeusTransformUtils.preCheckCast(this.f1429c, d.n.l.class, "com.obric.aiagent.plugin");
            d.o.a(r7);
        L14:
            if (ZeusTransformUtils.instanceOf(this.f1428b, ViewGroup.class) == false) goto L19;
            d.n.j<View> r8 = ab.c((ViewGroup) ZeusTransformUtils.preCheckCast(this.f1428b, ViewGroup.class, "com.obric.aiagent.plugin"));
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f1429c = null;
            this.f1427a = 2;
            if (r2.a(r8, r3) != r0) goto L19;
            return r0;
        L10:
            d.o.a(r7);
            r2 = (d.n.l) ZeusTransformUtils.preCheckCast(this.f1429c, d.n.l.class, "com.obric.aiagent.plugin");
            View r9 = this.f1428b;
            d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f1429c = r2;
            this.f1427a = 1;
            if (r2.a(r9, r5) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: View.kt */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<View, d.x> f1430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1431b;

        public b(d.h.a.b<? super View, d.x> r3, View r4) {
            this.f1430a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f1431b = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f1430a.invoke(this.f1431b);
        }
    }

    public static final OneShotPreDrawListener a(View r2, d.h.a.b<? super View, d.x> r3) {
        return OneShotPreDrawListener.add(r2, (Runnable) ZeusTransformUtils.preCheckCast(new b((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin"), r2), Runnable.class, "com.obric.aiagent.plugin"));
    }

    public static final d.n.j<View> a(View r2) {
        return d.n.m.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r2, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }
}
