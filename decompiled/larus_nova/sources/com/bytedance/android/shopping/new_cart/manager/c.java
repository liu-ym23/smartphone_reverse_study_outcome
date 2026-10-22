package com.bytedance.android.shopping.new_cart.manager;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.new_cart.widgets.j;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements com.bytedance.android.shopping.new_cart.manager.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f179113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.new_cart.manager.b f179114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f179115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CartObjectContainer f179116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f179117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f179118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f179119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f179120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CartViewModel f179121i;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f179122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f179123b;

        public a(c r100, View r101) {
            this.f179122a = r100;
            this.f179123b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f179122a;     // Catch: Throwable -> L8
            com.bytedance.android.shopping.new_cart.manager.b r101 = new com.bytedance.android.shopping.new_cart.manager.b(this.f179123b, r100, Boolean.TRUE, r100.f179120h);     // Catch: Throwable -> L5
        L6:
            r100.f179114b = r101;     // Catch: Throwable -> L8
            return;
        L5:
            r101 = null;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f179124a;

        public b(c r100) {
            this.f179124a = r100;
        }

        public final void a() {
            CartSliceCustomWidgetAdapterComponent r100 = (CartSliceCustomWidgetAdapterComponent) this.f179124a.f179115c.getValue();
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.f178941d != true) goto L15;
            com.bytedance.android.shopping.new_cart.yata.customdata.a r101 = this.f179124a.f179121i.getCustomDataCenter();
            if (r101 == null) goto L9;
            r101.c(Boolean.FALSE);
        L9:
            CartSliceCustomWidgetAdapterComponent r102 = (CartSliceCustomWidgetAdapterComponent) this.f179124a.f179115c.getValue();
            if (r102 == null) goto L12;
            r102.f178941d = false;
        L12:
            this.f179124a.f179116d.f178935e.f178983d.invoke().x(null, aa6.a.C0038a.f2348b, null, null);
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

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.manager.c$c, reason: collision with other inner class name */
    public static final class RunnableC2663c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f179125a;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.manager.c$c$a */
        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f179126a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f179127b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ RunnableC2663c f179128c;

            public a(int r100, int r101, RunnableC2663c r102) {
                this.f179126a = r100;
                this.f179127b = r101;
                this.f179128c = r102;
            }

            public final void a() {
                if (this.f179128c.f179125a.f179117e.isAttachedToWindow() == true) goto L5;
                return;
            L5:
                c r100 = this.f179128c.f179125a;
                int r101 = this.f179126a;
                RecyclerView.Adapter r102 = r100.f179117e.getAdapter();
                if (r102 == null) goto L13;
                int r103 = r102.getItemCount();
                if (r101 == (-1)) goto L13;
                if (r101 < 0) goto L13;
                if (r103 <= r101) goto L13;
                boolean r104 = true;
            L14:
                if (r104 == true) goto L16;
                return;
            L16:
                int r105 = this.f179128c.f179125a.f179117e.getHeight();
                int[] r106 = new int[2];
                this.f179128c.f179125a.f179117e.getLocationOnScreen(r106);
                int r107 = r106[1] + r105;
                Rect r108 = new Rect();
                this.f179128c.f179125a.f179117e.getWindowVisibleDisplayFrame(r108);
                int r109 = RangesKt.coerceAtLeast((r105 - RangesKt.coerceAtLeast(r107 - r108.bottom, 0)) - this.f179127b, 0);
                RecyclerView.LayoutManager r110 = this.f179128c.f179125a.f179117e.getLayoutManager();
                if ((r110 instanceof LinearLayoutManager) == true) goto L19;
                r110 = null;
            L19:
                LinearLayoutManager r111 = (LinearLayoutManager) r110;
                if (r111 == null) goto L23;
                r111.scrollToPositionWithOffset(this.f179126a, r109);
                return;
            L23:
                return;
            L13:
                r104 = false;
                goto L14
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

        public RunnableC2663c(c r100) {
            this.f179125a = r100;
        }

        public final void a() {
            j r100 = this.f179125a.f179119g;
            if (r100 == null) goto L5;
            r100.c();
        L5:
            Iterator<T> r101 = com.bytedance.commerce.base.view.b.a(this.f179125a.f179117e).iterator();
        L7:
            if (r101.hasNext() == false) goto L11;
            Object r102 = r101.next();
            if (((View) r102).hasFocus() == false) goto L7;
        L12:
            View r103 = (View) r102;
            if (r103 == null) goto L32;
            int r104 = this.f179125a.f179117e.getChildAdapterPosition(r103);
            RecyclerView.Adapter r105 = this.f179125a.f179117e.getAdapter();
            if (r105 == null) goto L22;
            int r106 = r105.getItemCount();
            if (r104 == (-1)) goto L22;
            if (r104 < 0) goto L22;
            if (r106 <= r104) goto L22;
            boolean r107 = true;
        L23:
            if (r107 == false) goto L33;
            c r108 = this.f179125a;
            if (r108.f179113a <= 0) goto L27;
            int r109 = r103.getHeight();
            this.f179125a.f179117e.post(new a(r104, r109, this));
            return;
        L27:
            r108.f179117e.scrollToPosition(r104);
            return;
        L33:
            return;
        L22:
            r107 = false;
            goto L23
        L32:
            return;
        L11:
            r102 = null;
            goto L12
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

    @Override // com.bytedance.android.shopping.new_cart.manager.b.a
    public final void a() {
        this.f179118f.setVisibility(0);
        j r100 = this.f179119g;
        if (r100 == null) goto L5;
        r100.d();
    L5:
        this.f179117e.post(new b(this));
    }

    public final void c() {
        com.bytedance.android.shopping.new_cart.manager.b r100 = this.f179114b;
        if (r100 == null) goto L8;
        View r101 = r100.f179104a;
        if (r101 == null) goto L9;
        r101.getViewTreeObserver().addOnGlobalLayoutListener(r100.f179109f);
        return;
    L9:
        return;
    }

    public final void d() {
        com.bytedance.android.shopping.new_cart.manager.b r100 = this.f179114b;
        if (r100 == null) goto L8;
        View r101 = r100.f179104a;
        if (r101 == null) goto L9;
        r101.getViewTreeObserver().removeOnGlobalLayoutListener(r100.f179109f);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.manager.b.a
    public final void z() {
        this.f179118f.setVisibility(8);
        com.bytedance.android.shopping.new_cart.utils.a.f179359c.d("onKeyboardShow", new RunnableC2663c(this));
    }

    public final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        com.bytedance.android.shopping.new_cart.utils.a.f179359c.d("bindWidget", new a(this, r100));
    }

    public c(CartObjectContainer r100, RecyclerView r101, View r102, CartLinkedScrollViewV2 r103, int r104, int r105) {
        if ((r105 & 16) == 0) goto L6;
        r104 = 0;
    L6:
        if ((r105 & 32) == 0) goto L8;
        CartViewModel r106 = r100.f178934d;
    L9:
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        Intrinsics.checkNotNullParameter(r101, "bodyWidget");
        Intrinsics.checkNotNullParameter(r102, "footerWidget");
        Intrinsics.checkNotNullParameter(r106, "cartVM");
        this.f179116d = r100;
        this.f179117e = r101;
        this.f179118f = r102;
        this.f179119g = r103;
        this.f179120h = r104;
        this.f179121i = r106;
        this.f179115c = LazyKt.lazy(new KeyboardManager$sliceCustomWidgetAdapterComponent$2(this));
        return;
    L8:
        r106 = null;
        goto L9
    }
}
