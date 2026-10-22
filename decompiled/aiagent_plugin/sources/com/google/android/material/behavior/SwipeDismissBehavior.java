package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c f13209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f13210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f13211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f13212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f13213e;
    float f;
    private boolean g;
    private float h;
    private boolean i;
    private final c.a j;

    public interface a {
        void a(int r1);

        void a(View r1);
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SwipeDismissBehavior f13218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f13219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f13220c;

        b(SwipeDismissBehavior r1, View r2, boolean r3) {
            this.f13218a = r1;
            this.f13219b = r2;
            this.f13220c = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13218a.f13209a == null) goto L8;
            if (this.f13218a.f13209a.a(true) == false) goto L8;
            ViewCompat.a(this.f13219b, this);
            return;
        L8:
            if (this.f13220c == true) goto L10;
            return;
        L10:
            if (this.f13218a.f13210b == null) goto L15;
            this.f13218a.f13210b.a(this.f13219b);
            return;
        }
    }

    static float b(float r0, float r1, float r2) {
        return (r2 - r0) / (r1 - r0);
    }

    public boolean a(View r1) {
        return true;
    }

    public SwipeDismissBehavior() {
        this.h = 0.0f;
        this.f13211c = 2;
        this.f13212d = 0.5f;
        this.f13213e = 0.0f;
        this.f = 0.5f;
        this.j = new AnonymousClass1(this);
    }

    public void a(a r3) {
        this.f13210b = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public void a(int r1) {
        this.f13211c = r1;
    }

    public void a(float r3) {
        this.f13213e = a(0.0f, r3, 1.0f);
    }

    public void b(float r3) {
        this.f = a(0.0f, r3, 1.0f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r1, V r2, int r3) {
        boolean r4 = super.a(r1, r2, r3);
        if (ViewCompat.g(r2) != 0) goto L5;
        ViewCompat.c(r2, 1);
        b(r2);
    L5:
        return r4;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r4, V r5, MotionEvent r6) {
        boolean r0 = this.g;
        int r1 = r6.getActionMasked();
        if (r1 != 0) goto L5;
        r0 = r4.isPointInChildBounds(r5, (int) r6.getX(), (int) r6.getY());
        this.g = r0;
    L11:
        if (r0 == false) goto L14;
        a(r4);
        return this.f13209a.a(r6);
    L14:
        return false;
    L5:
        if (r1 != 1) goto L7;
    L9:
        this.g = false;
        goto L11
    L7:
        if (r1 == 3) goto L9;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout r1, V r2, MotionEvent r3) {
        c r0 = this.f13209a;
        if (r0 == null) goto L6;
        r0.b(r3);
        return true;
    L6:
        return false;
    }

    private void a(ViewGroup r3) {
        if (this.f13209a == null) goto L5;
        return;
    L5:
        if (this.i == false) goto L7;
        c r4 = c.a(r3, this.h, this.j);
    L8:
        this.f13209a = r4;
        return;
    L7:
        r4 = c.a(r3, this.j);
        goto L8
    }

    private void b(View r4) {
        ViewCompat.d(r4, 1048576);
        if (a(r4) == false) goto L6;
        ViewCompat.a(r4, androidx.core.view.accessibility.b.a.u, null, new AnonymousClass2(this));
        return;
    }

    static float a(float r0, float r1, float r2) {
        return Math.min(Math.max(r0, r1), r2);
    }

    static int a(int r0, int r1, int r2) {
        return Math.min(Math.max(r0, r1), r2);
    }
}
