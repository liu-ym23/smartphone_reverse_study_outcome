package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/LinkmicSubtitleDragParentView;", "Lcom/bytedance/android/livesdk/interactivity/api/DragParentView;", "Ls52/a;", "", "disableDelete", "", "setDisableDelete", "q", "Z", "getMDisableDelete", "()Z", "setMDisableDelete", "(Z)V", "mDisableDelete", "", "r", "I", "getDeleteAreaViewHeight", "()I", "setDeleteAreaViewHeight", "(I)V", "deleteAreaViewHeight", "s", "getForbiddenAreaViewHeight", "setForbiddenAreaViewHeight", "forbiddenAreaViewHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicSubtitleDragParentView extends DragParentView implements s52.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f132778q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f132779r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f132780s;

    public LinkmicSubtitleDragParentView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LinkmicSubtitleDragParentView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getDeleteAreaViewHeight() {
        return this.f132779r;
    }

    public final int getForbiddenAreaViewHeight() {
        return this.f132780s;
    }

    public final boolean getMDisableDelete() {
        return this.f132778q;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.DragParentView, d42.d
    public final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "dragView");
        addView(r100, new FrameLayout.LayoutParams(-2, -2));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.DragParentView, d42.d
    public final Pair h(DragContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "dragView");
        return TuplesKt.to(Float.valueOf(r100.getX() / getWidth()), Float.valueOf((r100.getY() - this.f132779r) / ((getHeight() - this.f132779r) - this.f132780s)));
    }

    public final void setDeleteAreaViewHeight(int r100) {
        this.f132779r = r100;
    }

    @Override // s52.a
    public void setDisableDelete(boolean r100) {
        this.f132778q = r100;
    }

    public final void setForbiddenAreaViewHeight(int r100) {
        this.f132780s = r100;
    }

    public final void setMDisableDelete(boolean r100) {
        this.f132778q = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.DragParentView, d42.d
    public final void d(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "deleteView");
        super.d(r100, r101);
        this.f132779r = r101;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.DragParentView, d42.d
    public final boolean i(float r100, float r101) {
        if (this.f132778q == false) goto L12;
        if (r100 >= ((getTop() + this.f132779r) + getMDragAreaMarginTop())) goto L7;
    L9:
        return false;
    L7:
        if ((r100 + r101) > ((getBottom() - this.f132780s) - getMDragAreaMarginBottom())) goto L9;
        return true;
    L12:
        return super.i(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.DragParentView, d42.d
    public final void j(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "forbiddenView");
        super.j(r100, r101);
        this.f132780s = r101;
    }

    public LinkmicSubtitleDragParentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ LinkmicSubtitleDragParentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
