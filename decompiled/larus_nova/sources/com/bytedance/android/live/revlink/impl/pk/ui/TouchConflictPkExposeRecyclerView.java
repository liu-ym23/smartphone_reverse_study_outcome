package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/TouchConflictPkExposeRecyclerView;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/PkItemExposeRecyclerView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defaultStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TouchConflictPkExposeRecyclerView extends PkItemExposeRecyclerView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f97024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f97025e;

    public TouchConflictPkExposeRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        float r101 = r100.getX();
        float r102 = r100.getY();
        int r103 = r100.getAction();
        if (r103 != 0) goto L5;
        getParent().requestDisallowInterceptTouchEvent(true);
    L11:
        this.f97024d = r101;
        this.f97025e = r102;
        return super.dispatchTouchEvent(r100);
    L5:
        if (r103 != 2) goto L11;
        float r104 = r101 - this.f97024d;
        float r105 = r102 - this.f97025e;
        if (Math.abs(r104) <= Math.abs(r105)) goto L11;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L11
    }

    public TouchConflictPkExposeRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public TouchConflictPkExposeRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
