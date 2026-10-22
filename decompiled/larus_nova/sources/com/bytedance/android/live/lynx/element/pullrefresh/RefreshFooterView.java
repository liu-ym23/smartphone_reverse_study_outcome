package com.bytedance.android.live.lynx.element.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.ss.android.lark.utils.statistics.PerfLog;
import cqa.d;
import cqa.h;
import dqa.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0014\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00020\u0007\"\u00020\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/lynx/element/pullrefresh/RefreshFooterView;", "Landroid/widget/RelativeLayout;", "Lcqa/d;", "Ldqa/b;", "getSpinnerStyle", "Landroid/view/View;", "getView", "", "", "colors", "", "setPrimaryColors", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RefreshFooterView extends RelativeLayout implements d {
    public RefreshFooterView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RefreshFooterView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // cqa.f
    public final boolean a() {
        return false;
    }

    @Override // cqa.d
    public final boolean c(boolean r100) {
        return true;
    }

    @Override // cqa.f
    public final void d(float r100, int r101, int r102) {
    }

    @Override // gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        Intrinsics.checkNotNullParameter(r101, "oldState");
        Intrinsics.checkNotNullParameter(r102, "newState");
    }

    @Override // cqa.f
    public View getView() {
        return this;
    }

    @Override // cqa.f
    public void setPrimaryColors(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
    }

    @Override // cqa.f
    public b getSpinnerStyle() {
        return b.f469717d;
    }

    @Override // cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        ALogger.i("lol", "RefreshFooterView -> onFinish");
        return 0;
    }

    public RefreshFooterView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    @Override // cqa.f
    public final void f(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        ALogger.i("lol", "RefreshFooterView -> onStartAnimator");
    }

    @Override // cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "kernel");
        ALogger.i("lol", "RefreshFooterView -> onInitialized");
    }

    @Override // cqa.f
    public final void i(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        ALogger.i("lol", "RefreshFooterView -> onReleased");
    }

    public /* synthetic */ RefreshFooterView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // cqa.f
    public final void b(boolean r100, float r101, int r102, int r103, int r104) {
        ALogger.i("lol", "RefreshFooterView -> onMoving");
    }
}
