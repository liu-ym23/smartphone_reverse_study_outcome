package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements ScaleGestureDetector.OnScaleGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f117704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f117705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f117706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f117707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f117708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f117709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f117710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f117711h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f117712i;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        boolean r101 = true;
        if (this.f117709f == false) goto L7;
        if (r100.getScaleFactor() <= 1) goto L7;
    L11:
        if (this.f117709f == false) goto L14;
        r100.getScaleFactor();
    L14:
        if (this.f117710g == false) goto L16;
        r100.getScaleFactor();
    L16:
        return true;
    L7:
        if (this.f117710g == true) goto L9;
    L17:
        float r102 = this.f117705b * r100.getScaleFactor();
        this.f117704a = r102;
        float r103 = this.f117707d * 1.0f;
        if (r102 <= r103) goto L20;
        this.f117704a = r103;
        this.f117709f = true;
        this.f117710g = false;
    L24:
        Float r104 = Float.valueOf(this.f117704a);
        Float r105 = Float.valueOf(this.f117704a);
        if (r104 == null) goto L27;
        this.f117711h.setScaleX(r104.floatValue());
    L27:
        if (r105 == null) goto L29;
        this.f117711h.setScaleY(r105.floatValue());
    L29:
        return r101;
    L20:
        float r106 = this.f117708e * 1.0f;
        if (r102 >= r106) goto L23;
        this.f117704a = r106;
        this.f117709f = false;
        this.f117710g = true;
        goto L24
    L23:
        this.f117709f = false;
        this.f117710g = false;
        r101 = false;
        goto L24
    L9:
        if (r100.getScaleFactor() >= 1) goto L17;
        goto L17
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        this.f117705b = this.f117704a;
    }

    public c(View r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "viewGroup");
        this.f117711h = r100;
        this.f117712i = r101;
        this.f117704a = 1.0f;
        this.f117705b = 1.0f;
        this.f117707d = 5.0f;
        this.f117708e = 1.0f;
        this.f117710g = true;
    }
}
