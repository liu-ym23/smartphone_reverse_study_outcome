package androidx.viewpager2.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FakeDrag.java */
/* JADX INFO: loaded from: classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewPager2 f2958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f2959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView f2960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VelocityTracker f2961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2962e;
    private float f;
    private int g;
    private long h;

    d(ViewPager2 r1, g r2, RecyclerView r3) {
        this.f2958a = r1;
        this.f2959b = r2;
        this.f2960c = r3;
    }

    boolean a() {
        return this.f2959b.g();
    }

    boolean b() {
        if (this.f2959b.f() == false) goto L5;
        return false;
    L5:
        this.g = 0;
        this.f = 0;
        this.h = SystemClock.uptimeMillis();
        d();
        this.f2959b.b();
        if (this.f2959b.e() == true) goto L8;
        this.f2960c.stopScroll();
    L8:
        a(this.h, 0, 0.0f, 0.0f);
        return true;
    }

    boolean a(float r10) {
        int r1 = 0;
        if (this.f2959b.g() == true) goto L5;
        return false;
    L5:
        float r0 = this.f - r10;
        this.f = r0;
        int r11 = Math.round(r0 - this.g);
        this.g += r11;
        long r3 = SystemClock.uptimeMillis();
        if (this.f2958a.getOrientation() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        int r4 = r11;
    L12:
        if (r2 == true) goto L15;
        r1 = r11;
    L15:
        float r12 = 0.0f;
        if (r2 == false) goto L18;
        float r6 = this.f;
    L19:
        if (r2 == true) goto L22;
        r12 = this.f;
    L22:
        this.f2960c.scrollBy(r4, r1);
        a(r3, 2, r6, r12);
        return true;
    L18:
        r6 = 0.0f;
        goto L19
    L11:
        r4 = 0;
        goto L12
    L8:
        r2 = false;
        goto L9
    }

    boolean c() {
        if (this.f2959b.g() == true) goto L6;
        return false;
    L6:
        this.f2959b.c();
        VelocityTracker r0 = this.f2961d;
        r0.computeCurrentVelocity(1000, this.f2962e);
        if (this.f2960c.fling((int) r0.getXVelocity(), (int) r0.getYVelocity()) == true) goto L11;
        this.f2958a.snapToPage();
        return true;
    L11:
        return true;
    }

    private void d() {
        VelocityTracker r0 = this.f2961d;
        if (r0 != null) goto L5;
        this.f2961d = VelocityTracker.obtain();
        this.f2962e = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2958a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getScaledMaximumFlingVelocity();
        return;
    L5:
        r0.clear();
    }

    private void a(long r9, int r11, float r12, float r13) {
        MotionEvent r10 = MotionEvent.obtain(this.h, r9, r11, r12, r13, 0);
        this.f2961d.addMovement(r10);
        r10.recycle();
    }
}
