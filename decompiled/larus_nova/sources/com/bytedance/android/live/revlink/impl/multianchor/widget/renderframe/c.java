package com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements u11.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f95270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f95271b;

    public static final class a {
    }

    static {
    }

    @Override // u11.a
    public final void a() {
    }

    @Override // u11.a
    public final void detach() {
        jy0.b.c("NormalRenderFrame", "detach", null, 4);
        this.f95270a.removeView(this.f95271b);
    }

    @Override // u11.a
    public final void b(p r110) {
        Intrinsics.checkNotNullParameter(r110, "renderState");
        RectF r100 = r110.f98446c;
        jy0.b.c("NormalRenderFrame", String.valueOf(this.f95271b.getParent()), null, 4);
        if (this.f95271b.getParent() != null) goto L5;
        this.f95270a.addView(this.f95271b, 0, new FrameLayout.LayoutParams((int) r100.width(), (int) r100.height()));
        jy0.b.c("NormalRenderFrame", "add view", null, 4);
    L5:
        ViewGroup.LayoutParams r101 = this.f95271b.getLayoutParams();
        if ((r101 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r101 = null;
    L8:
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
        if (r102 != null) goto L11;
        return;
    L11:
        r102.leftMargin = (int) r100.left;
        r102.topMargin = (int) r100.top;
        r102.width = (int) r100.width();
        r102.height = (int) r100.height();
        jy0.b.c("NormalRenderFrame", "add view with  " + r102, null, 4);
        this.f95271b.setLayoutParams(r102);
        UtilityKotlinExtentionsKt.z(this.f95271b, r110.f98445b);
    }

    public c(FrameLayout r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "renderContainer");
        Intrinsics.checkNotNullParameter(r101, "host");
        this.f95270a = r100;
        this.f95271b = r101;
    }
}
