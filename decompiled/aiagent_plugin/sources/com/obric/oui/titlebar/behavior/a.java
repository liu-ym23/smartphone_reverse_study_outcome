package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewOffsetBehavior.java */
/* JADX INFO: loaded from: classes4.dex */
class a<V extends View> extends CoordinatorLayout.b<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f36689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f36690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36691c;

    public a() {
        this.f36690b = 0;
        this.f36691c = 0;
    }

    public a(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.f36690b = 0;
        this.f36691c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r1, V r2, int r3) {
        b(r1, r2, r3);
        if (this.f36689a != null) goto L5;
        this.f36689a = new b(r2);
    L5:
        this.f36689a.a();
        this.f36689a.b();
        int r4 = this.f36690b;
        if (r4 == 0) goto L8;
        this.f36689a.a(r4);
        this.f36690b = 0;
    L8:
        int r5 = this.f36691c;
        if (r5 == 0) goto L13;
        this.f36689a.b(r5);
        this.f36691c = 0;
        return true;
    L13:
        return true;
    }

    public void b(CoordinatorLayout r1, V r2, int r3) {
        r1.onLayoutChild(r2, r3);
    }

    public boolean a(int r2) {
        b r0 = this.f36689a;
        if (r0 != null) goto L5;
        this.f36690b = r2;
        return false;
    L5:
        return r0.a(r2);
    }

    public int d() {
        b r0 = this.f36689a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }
}
