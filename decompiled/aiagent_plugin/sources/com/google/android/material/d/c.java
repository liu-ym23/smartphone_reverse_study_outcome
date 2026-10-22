package com.google.android.material.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ExpandableWidgetHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f13314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13316c;

    public c(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f13315b = false;
        this.f13316c = 0;
        this.f13314a = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin");
    }

    public boolean a(boolean r2) {
        if (this.f13315b == r2) goto L6;
        this.f13315b = r2;
        d();
        return true;
    L6:
        return false;
    }

    public boolean a() {
        return this.f13315b;
    }

    public Bundle b() {
        Bundle r0 = new Bundle();
        r0.putBoolean("expanded", this.f13315b);
        r0.putInt("expandedComponentIdHint", this.f13316c);
        return r0;
    }

    public void a(Bundle r3) {
        this.f13315b = r3.getBoolean("expanded", false);
        this.f13316c = r3.getInt("expandedComponentIdHint", 0);
        if (this.f13315b == false) goto L6;
        d();
        return;
    }

    public void a(int r1) {
        this.f13316c = r1;
    }

    public int c() {
        return this.f13316c;
    }

    private void d() {
        ViewParent r0 = this.f13314a.getParent();
        if (ZeusTransformUtils.instanceOf(r0, CoordinatorLayout.class) == false) goto L6;
        ((CoordinatorLayout) ZeusTransformUtils.preCheckCast(r0, CoordinatorLayout.class, "com.obric.aiagent.plugin")).dispatchDependentViewsChanged(this.f13314a);
        return;
    }
}
