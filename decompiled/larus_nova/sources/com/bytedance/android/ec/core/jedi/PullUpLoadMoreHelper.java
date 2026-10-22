package com.bytedance.android.ec.core.jedi;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductRecyclerview;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/core/jedi/PullUpLoadMoreHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PullUpLoadMoreHelper implements RecyclerView.OnItemTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f45098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f45099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f45101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f45102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f45103f;

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "motionEvent");
    }

    public PullUpLoadMoreHelper(DeepFeedProductRecyclerview r100, Function0 r101) {
        this.f45102e = r100;
        this.f45103f = r101;
        Intrinsics.checkNotNull(r100);
        this.f45100c = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        r100.addOnItemTouchListener(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101.getAction() != 0) goto L5;
        this.f45101d = r101.getY();
        this.f45099b = true;
    L5:
        RecyclerView r102 = this.f45102e;
        if (r102 != null) goto L8;
    L19:
        return false;
    L8:
        if (this.f45098a == false) goto L19;
        if (this.f45099b == false) goto L19;
        if (r102.canScrollVertically(1) == true) goto L19;
        if ((this.f45101d - r101.getY()) <= this.f45100c) goto L19;
        Function0<Unit> r103 = this.f45103f;
        if (r103 == null) goto L18;
        Unit r104 = r103.invoke();
    L18:
        this.f45098a = false;
        this.f45099b = false;
        goto L19
    }
}
