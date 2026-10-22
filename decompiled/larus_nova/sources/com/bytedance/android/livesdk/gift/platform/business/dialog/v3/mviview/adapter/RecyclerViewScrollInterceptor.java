package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/RecyclerViewScrollInterceptor;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewScrollInterceptor implements RecyclerView.OnItemTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureDetector f127809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f127810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Float, Float, Boolean> f127811c;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerViewScrollInterceptor f127812a;

        public a(RecyclerViewScrollInterceptor r100) {
            this.f127812a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            if (this.f127812a.f127811c.invoke(Float.valueOf(r102), Float.valueOf(r103)).booleanValue() == false) goto L6;
            return true;
        L6:
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "rv");
        Intrinsics.checkNotNullParameter(r101, "e");
    }

    public final Context getContext() {
        return this.f127810b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerViewScrollInterceptor(Context r100, Function2<? super Float, ? super Float, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onScrolledIntercept");
        this.f127810b = r100;
        this.f127811c = r101;
        this.f127809a = new GestureDetector(r100, new a(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "rv");
        Intrinsics.checkNotNullParameter(r101, "e");
        return this.f127809a.onTouchEvent(r101);
    }
}
