package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.p;
import d.o;
import d.x;
import kotlinx.coroutines.a.q;

/* JADX INFO: compiled from: PipHintTracker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: compiled from: PipHintTracker.kt */
    @d.c.b.a.f(b = "PipHintTracker.kt", c = {87}, d = "invokeSuspend", e = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1")
    static final class a extends l implements m<q<? super Rect>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f150c;

        /* JADX INFO: renamed from: androidx.activity.e$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: PipHintTracker.kt */
        static final class AnonymousClass1 extends p implements d.h.a.a<x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f151a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnScrollChangedListener f152b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ View.OnLayoutChangeListener f153c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 f154d;

            AnonymousClass1(View r3, ViewTreeObserver.OnScrollChangedListener r4, View.OnLayoutChangeListener r5, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 r6) {
                ViewTreeObserver.OnScrollChangedListener r7 = (ViewTreeObserver.OnScrollChangedListener) ZeusTransformUtils.wrapperContextForParams(r4, ViewTreeObserver.OnScrollChangedListener.class, "com.obric.aiagent.plugin");
                View.OnLayoutChangeListener r8 = (View.OnLayoutChangeListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnLayoutChangeListener.class, "com.obric.aiagent.plugin");
                this.f151a = r3;
                this.f152b = r7;
                this.f153c = r8;
                this.f154d = r6;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ x invoke() {
                a();
                return x.f38692a;
            }

            public final void a() {
                this.f151a.getViewTreeObserver().removeOnScrollChangedListener(this.f152b);
                this.f151a.removeOnLayoutChangeListener(this.f153c);
                this.f151a.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this.f154d, View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin"));
            }
        }

        a(View r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f149b = r3;
            super(2, r5);
        }

        public static /* synthetic */ void lambda$9oVIAjyuLrmPrsrtFKrW2L1MRSI(q r0, View r1) {
            a(r0, r1);
        }

        public static /* synthetic */ void lambda$dToyQ7EX9TNhZjiUP4lNkeCoXLI(q r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        }

        public final Object a(q<? super Rect> r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f149b, r5);
            r0.f150c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(q<? super Rect> r3, d.c.d<? super x> r4) {
            return a((q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1, java.lang.Object] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f148a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r9);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r9);
            final q r10 = (q) ZeusTransformUtils.preCheckCast(this.f150c, q.class, "com.obric.aiagent.plugin");
            final View.OnLayoutChangeListener r2 = new $$Lambda$e$a$dToyQ7EX9TNhZjiUP4lNkeCoXLI(r10);
            final View r4 = this.f149b;
            final ViewTreeObserver.OnScrollChangedListener r5 = new $$Lambda$e$a$9oVIAjyuLrmPrsrtFKrW2L1MRSI(r10, r4);
            final View r6 = this.f149b;
            ?? r7 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(r10, r6, r5, r2);
            if (androidx.activity.a.f142a.a(this.f149b) == false) goto L11;
            r10.a_(e.a(this.f149b));
            this.f149b.getViewTreeObserver().addOnScrollChangedListener(r5);
            this.f149b.addOnLayoutChangeListener(r2);
        L11:
            this.f149b.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(r7, View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin"));
            d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f149b, r5, r2, r7), d.h.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f148a = 1;
            if (kotlinx.coroutines.a.o.a(r10, r3, r8) != r0) goto L15;
            return r0;
        }

        private static final void a(q r2, View r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
            q r12 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.aiagent.plugin");
            if (r4 != r8) goto L7;
            if (r6 != r10) goto L7;
            if (r5 != r9) goto L7;
            if (r7 != r11) goto L7;
            return;
        L7:
            d.h.b.o.c(r3, "v");
            r12.a_(e.a(r3));
        }

        private static final void a(q r2, View r3) {
            ((q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.aiagent.plugin")).a_(e.a(r3));
        }
    }

    public static final /* synthetic */ Rect a(View r0) {
        return b(r0);
    }

    private static final Rect b(View r1) {
        Rect r0 = new Rect();
        r1.getGlobalVisibleRect(r0);
        return r0;
    }
}
