package com.bytedance.android.ecom.arch.slice.render.util.keyboard;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.android.ecom.arch.slice.render.util.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcKeyboardMonitor {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f50748k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<c> f50749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f50751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f50752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f50753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SlcApplyWindowInsetsListener f50754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f50755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f50756h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f50757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f50758j;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/util/keyboard/SlcKeyboardMonitor$SlcApplyWindowInsetsListener;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "slice-render_release"}, k = 1, mv = {1, 4, 0})
    public static final class SlcApplyWindowInsetsListener implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SlcKeyboardMonitor> f50759a;

        public SlcApplyWindowInsetsListener(WeakReference<SlcKeyboardMonitor> r100) {
            this.f50759a = r100;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            SlcKeyboardMonitor r102 = this.f50759a.get();
            if (r102 == null) goto L14;
            int r103 = r101.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
            int r104 = r101.getInsets(WindowInsetsCompat.Type.ime()).bottom - r103;
            if (r104 <= 0) goto L7;
            boolean r105 = true;
        L9:
            if (r102.f50755g == r105) goto L14;
            if (r105 == false) goto L12;
            r102.b(r104);
        L13:
            r102.f50755g = r105;
            goto L14
        L12:
            r102.a();
            goto L13
        L7:
            r105 = false;
        L14:
            return r101;
        }
    }

    public static final class a {
    }

    public interface b {
        void a(SlcApplyWindowInsetsListener r100);

        void b(SlcApplyWindowInsetsListener r100);
    }

    public interface c {
        void a();

        void b(int r100);
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SlcKeyboardMonitor> f50760a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            SlcKeyboardMonitor r100 = this.f50760a.get();     // Catch: Throwable -> L12
            if (r100 == null) goto L17;
            View r101 = r100.f50756h;     // Catch: Throwable -> L12
            Rect r102 = new Rect();     // Catch: Throwable -> L12
            r101.getWindowVisibleDisplayFrame(r102);     // Catch: Throwable -> L12
            int r103 = r102.bottom - r102.top;     // Catch: Throwable -> L12
            if (r103 == r100.f50750b) goto L18;
            int r104 = r100.f50756h.getHeight();     // Catch: Throwable -> L12
            if ((r104 - r103) <= (r104 / 4)) goto L9;
            r100.b(r100.f50750b - r103);     // Catch: Throwable -> L12
        L10:
            r100.f50750b = r103;     // Catch: Throwable -> L12
            return;
        L9:
            r100.a();     // Catch: Throwable -> L12
            goto L10
        L18:
            return;
        L17:
            return;
        L12:
            th = move-exception;
            nq.a.f(th, "Slice AndroidBug5497Workaround OnGlobalLayoutListener happen error");
        }

        public d(WeakReference<SlcKeyboardMonitor> r100) {
            this.f50760a = r100;
        }
    }

    static {
    }

    public final void a() {
        int r100 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(SlcKeyboardMonitor$onKeyboardHide$1.INSTANCE);
        int r101 = 0;
        Object[] r102 = this.f50749a.toArray(new c[0]);
        if (r102 == null) goto L9;
        c[] r103 = (c[]) r102;
        int r104 = r103.length;
    L5:
        if (r101 >= r104) goto L7;
        r103[r101].a();
        r101 = r101 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void b(int r100) {
        int r101 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(SlcKeyboardMonitor$onKeyboardShow$1.INSTANCE);
        int r102 = 0;
        Object[] r103 = this.f50749a.toArray(new c[0]);
        if (r103 == null) goto L9;
        c[] r104 = (c[]) r103;
        int r105 = r104.length;
    L5:
        if (r102 >= r105) goto L7;
        r104[r102].b(r100);
        r102 = r102 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public SlcKeyboardMonitor(View r100, boolean r101, b r102) {
        this.f50756h = r100;
        this.f50757i = r101;
        this.f50758j = r102;
        this.f50749a = new ArrayList(2);
        if (r101 == false) goto L8;
        SlcApplyWindowInsetsListener r103 = new SlcApplyWindowInsetsListener(new WeakReference(this));     // Catch: Throwable -> L15
        if (r102 == null) goto L7;
        r102.a(r103);     // Catch: Throwable -> L15
        this.f50754f = r103;     // Catch: Throwable -> L15
    L18:
        return;
    L7:
        nq.a.c(null, AnonymousClass1.INSTANCE, 1);     // Catch: Throwable -> L15
        goto L18
    L8:
        this.f50751c = new d(new WeakReference(this));     // Catch: Throwable -> L15
        if (this.f50752d == true) goto L18;
        if (this.f50753e == true) goto L18;
        h.a(new SlcKeyboardMonitor$doAddGlobalLayoutListener$1(this));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        nq.a.f(th, "Slice AndroidBug5497Workaround init fail");
    }
}
