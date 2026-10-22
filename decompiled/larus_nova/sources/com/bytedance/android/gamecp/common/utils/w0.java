package com.bytedance.android.gamecp.common.utils;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class w0 implements GestureDetector.OnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f57325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f57326b;

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        this.f57325a.onClick(this.f57326b);
        return false;
    }

    public w0(com.bytedance.android.gamecp.business.gamedetail.view.comment.t r100, RecyclerView r101) {
        this.f57325a = r100;
        this.f57326b = r101;
    }
}
