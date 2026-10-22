package com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.widget.ECAnchorHeaderFrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class AnchorV4SmallTransition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a> f168822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a> f168823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f168824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f168825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f168826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f168827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f168828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f168829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f168830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f168831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a f168832k;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4SmallTransition f168833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f168834b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f168833a.c(this.f168834b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AnchorV4SmallTransition r100, boolean r101) {
            this.f168833a = r100;
            this.f168834b = r101;
        }
    }

    public final int b() {
        return ((Number) this.f168830i.getValue()).intValue();
    }

    public final List<View> a() {
        return this.f168832k.getContainers();
    }

    public AnchorV4SmallTransition(com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a r100) {
        Intrinsics.checkNotNullParameter(r100, "transformViewPager");
        this.f168832k = r100;
        this.f168822a = new ArrayList();
        this.f168823b = new ArrayList();
        this.f168830i = LazyKt.lazy(AnchorV4SmallTransition$mScreenWidth$2.INSTANCE);
        this.f168831j = -1.0f;
    }

    public final void c(boolean r100) {
        List<com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a> r101 = this.f168822a;
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        this.f168832k.d(new a(this, r100));
        return;
    L12:
        this.f168832k.b();
        ECAnchorHeaderFrameLayout r104 = this.f168832k.f();
        if (r104 == null) goto L35;
        if (r100 == false) goto L16;
        int r105 = this.f168829h;
    L17:
        r104.setFixedWidth(Integer.valueOf(r105));
        if (this.f168832k.e() == false) goto L24;
        int r106 = this.f168832k.a();
        com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a r107 = (com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(this.f168822a, r106);
        if ((r107.f165002a + r107.f165004c) <= b()) goto L22;
        float r108 = (r107.f165002a + r107.f165004c) - b();
    L23:
        this.f168824c = (int) r108;
    L32:
        this.f168825d = r106 * b();
        return;
    L22:
        r108 = 0.0f;
        goto L23
    L24:
        int r109 = this.f168832k.h().getScrollX();
        Iterator<T> r110 = a().iterator();
        int r111 = 0;
    L26:
        if (r110.hasNext() == false) goto L31;
        if (r109 <= ((View) r110.next()).getX()) goto L29;
        r111 = r111 + 1;
        goto L26
    L29:
        r102 = r111;
    L31:
        this.f168824c = this.f168832k.h().getScrollX();
        r106 = r102;
        goto L32
    L16:
        r105 = this.f168826e;
        goto L17
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.detail.widget.ECAnchorHeaderFrameLayout");
    L5:
        if (((ArrayList) r101).isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
