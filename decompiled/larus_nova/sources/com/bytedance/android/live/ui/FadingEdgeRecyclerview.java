package com.bytedance.android.live.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0014R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/ui/FadingEdgeRecyclerview;", "Landroidx/recyclerview/widget/RecyclerView;", "", "getBottomFadingEdgeStrength", "getTopFadingEdgeStrength", "Lkn2/m;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkn2/m;", "getBase", "()Lkn2/m;", "setBase", "(Lkn2/m;)V", "base", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class FadingEdgeRecyclerview extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kn2.m f101947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f101948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f101949c;

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (this.f101948b == true) goto L5;
        return 0.0f;
    L5:
        return super.getBottomFadingEdgeStrength();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (this.f101949c == true) goto L5;
        return 0.0f;
    L5:
        return super.getTopFadingEdgeStrength();
    }

    public final kn2.m getBase() {
        return this.f101947a;
    }

    public FadingEdgeRecyclerview(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        boolean r101 = super.dispatchTouchEvent(r100);
        kn2.m r102 = this.f101947a;
        if (r102 == null) goto L5;
        r102.onTouch(this, r100);
    L5:
        return r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    public final void setBase(kn2.m r100) {
        this.f101947a = r100;
    }

    public FadingEdgeRecyclerview(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f101949c = true;
        setOnTouchListener(null);
    }
}
