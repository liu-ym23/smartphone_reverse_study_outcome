package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewOffsetBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class c<V extends View> extends CoordinatorLayout.b<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f13187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13189c;

    public c() {
        this.f13188b = 0;
        this.f13189c = 0;
    }

    public c(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.f13188b = 0;
        this.f13189c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r1, V r2, int r3) {
        b(r1, r2, r3);
        if (this.f13187a != null) goto L5;
        this.f13187a = new d(r2);
    L5:
        this.f13187a.a();
        this.f13187a.b();
        int r4 = this.f13188b;
        if (r4 == 0) goto L8;
        this.f13187a.a(r4);
        this.f13188b = 0;
    L8:
        int r5 = this.f13189c;
        if (r5 == 0) goto L13;
        this.f13187a.b(r5);
        this.f13189c = 0;
        return true;
    L13:
        return true;
    }

    public void b(CoordinatorLayout r1, V r2, int r3) {
        r1.onLayoutChild(r2, r3);
    }

    public boolean a(int r2) {
        d r0 = this.f13187a;
        if (r0 != null) goto L5;
        this.f13188b = r2;
        return false;
    L5:
        return r0.a(r2);
    }

    public int c() {
        d r0 = this.f13187a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }
}
