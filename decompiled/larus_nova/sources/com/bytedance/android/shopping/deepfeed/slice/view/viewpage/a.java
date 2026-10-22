package com.bytedance.android.shopping.deepfeed.slice.view.viewpage;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f173673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f173674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f173675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f173676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f173677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f173678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC2598a f173679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewPager2 f173680h;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.viewpage.a$a, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC2598a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f173681a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        }

        public ViewOnAttachStateChangeListenerC2598a(a r100) {
            this.f173681a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f173681a.b();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f173682a;

        public b(a r100) {
            this.f173682a = r100;
        }

        public final void a() {
            a r100 = this.f173682a;
            if (r100.f173675c == false) goto L5;
            return;
        L5:
            if (r100.f173674b == true) goto L18;
            float r101 = r100.f173680h.getHeight();
            if (r101 != 0.0f) goto L10;
            r100.a();
            return;
        L10:
            long r102 = RangesKt.coerceAtLeast(r100.f173677e / 16, 1);
            if (r100.f173680h.beginFakeDrag() == true) goto L13;
            r100.a();
            return;
        L13:
            r100.f173674b = true;
            Ref.LongRef r103 = new Ref.LongRef();
            r103.element = 0;
            Ref.FloatRef r104 = new Ref.FloatRef();
            r104.element = 0.0f;
            new AutoScrollViewPager2$scrollToNext$2(r100, r103, r102, new AutoScrollViewPager2$scrollToNext$1(r100), r101, r104, 16).invoke2();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void a() {
        if (this.f173675c == false) goto L5;
        return;
    L5:
        this.f173673a.postDelayed(this.f173678f, this.f173676d);
    }

    public final void b() {
        this.f173673a.removeCallbacksAndMessages(null);
        if (this.f173680h.isFakeDragging() == true) goto L8;
    L5:
        this.f173674b = false;
        return;
    L8:
        this.f173680h.endFakeDrag();     // Catch: IllegalStateException -> L7
        goto L5
    }

    public a(ViewPager2 r100) {
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        this.f173680h = r100;
        this.f173673a = new Handler(Looper.getMainLooper());
        this.f173676d = 2000;
        this.f173677e = 1000;
        this.f173678f = new b(this);
        ViewOnAttachStateChangeListenerC2598a r101 = new ViewOnAttachStateChangeListenerC2598a(this);
        this.f173679g = r101;
        r100.addOnAttachStateChangeListener(r101);
    }
}
