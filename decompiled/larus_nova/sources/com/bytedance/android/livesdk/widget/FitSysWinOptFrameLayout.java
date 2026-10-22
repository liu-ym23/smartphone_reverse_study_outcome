package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.ILiveCheckDraw;
import com.bytedance.android.livesdk.config.vo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/widget/FitSysWinOptFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FitSysWinOptFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f160863a;

    @Override // android.view.View
    public final void requestApplyInsets() {
        if (this.f160863a.booleanValue() == false) goto L5;
        return;
    L5:
        super.requestApplyInsets();
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestFitSystemWindows() {
        if (this.f160863a.booleanValue() == false) goto L5;
        return;
    L5:
        super.requestFitSystemWindows();
    }

    public FitSysWinOptFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f160863a = vo.f121466a.getValue();
    }

    public FitSysWinOptFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f160863a = vo.f121466a.getValue();
    }

    public FitSysWinOptFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f160863a = vo.f121466a.getValue();
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (ILiveCheckDraw.a(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.drawChild(r100, r101, r102) == false) goto L7;
        return true;
    }
}
