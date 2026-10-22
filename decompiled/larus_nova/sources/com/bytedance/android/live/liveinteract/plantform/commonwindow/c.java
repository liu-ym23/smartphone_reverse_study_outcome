package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PointF f75630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PointF f75631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CommonDynamicIslandLayoutManager f75632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f75633d;

    public c(PointF r100, PointF r101, CommonDynamicIslandLayoutManager r102, View r103) {
        this.f75630a = r100;
        this.f75631b = r101;
        this.f75632c = r102;
        this.f75633d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = this.f75633d.getWidth();
        int r102 = this.f75633d.getHeight();
        Object r103 = r100.getAnimatedValue();
        if (r103 == null) goto L7;
        float r104 = ((Float) r103).floatValue();
        PointF r105 = this.f75630a;
        PointF r106 = new PointF(r105.x - (r101 / 2), r105.y - (r102 / 2));
        PointF r107 = this.f75631b;
        float r108 = r107.x;
        float r109 = r108 + ((r106.x - r108) * r104);
        float r110 = r107.y;
        float r111 = r110 + ((r106.y - r110) * r104);
        ALogger.i(this.f75632c.f75553a, "addUpdateListener startPointLeft=" + this.f75631b + " endPoint=" + r106 + " x=" + r109 + ", y=" + r111);
        this.f75633d.setX(r109);
        this.f75633d.setY(r111);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
