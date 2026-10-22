package com.bytedance.android.shopping.anchorv3.compat;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/compat/UserInteractFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv3/compat/d;", "listener", "", "setDrawListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class UserInteractFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f164788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f164789b;

    public UserInteractFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UserInteractFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        d r101 = this.f164789b;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        super.dispatchDraw(r100);
        d r102 = this.f164789b;
        if (r102 == null) goto L9;
        r102.a();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
    L10:
        return false;
    L4:
        if (r100.getAction() != 0) goto L8;
        Function0<Unit> r101 = this.f164788a;     // Catch: Exception -> L10
        if (r101 == null) goto L8;
        Unit r102 = r101.invoke();     // Catch: Exception -> L10
    L8:
        return super.dispatchTouchEvent(r100);
    }

    public final void setDrawListener(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f164789b = r100;
    }

    public UserInteractFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ UserInteractFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
