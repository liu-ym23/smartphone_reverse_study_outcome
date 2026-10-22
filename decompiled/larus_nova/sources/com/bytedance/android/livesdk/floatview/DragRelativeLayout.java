package com.bytedance.android.livesdk.floatview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.customview.widget.ViewDragHelper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/DragRelativeLayout;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DragRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewDragHelper f125049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f125050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f125051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f125052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewDragHelper.Callback f125053e;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f125050b = getChildAt(0);
    }

    public final boolean a(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        View r101 = this.f125050b;
        if (r101 == null) goto L5;
        int r102 = r101.getLeft();
    L6:
        View r103 = this.f125050b;
        if (r103 == null) goto L9;
        int r104 = r103.getTop();
    L10:
        View r105 = this.f125050b;
        if (r105 == null) goto L13;
        int r106 = r105.getRight();
    L14:
        View r107 = this.f125050b;
        if (r107 == null) goto L17;
        int r108 = r107.getBottom();
    L19:
        if (r100.getX() >= r102) goto L21;
    L27:
        boolean r109 = false;
    L28:
        if (r109 == true) goto L30;
        return false;
    L30:
        if (this.f125052d == false) goto L34;
        return true;
    L34:
        return false;
    L21:
        if (r100.getX() > r106) goto L27;
        if (r100.getY() < r104) goto L27;
        if (r100.getY() > r108) goto L27;
        r109 = true;
        goto L28
    L17:
        r108 = 0;
        goto L19
    L13:
        r106 = 0;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = a(r100);
        this.f125051c = r101;
        if (r101 == false) goto L9;
        ViewDragHelper r102 = this.f125049a;
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.shouldInterceptTouchEvent(r100);
    L9:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f125051c == false) goto L12;
        ViewDragHelper r101 = this.f125049a;     // Catch: IllegalArgumentException -> L8
        if (r101 == null) goto L10;
        r101.processTouchEvent(r100);     // Catch: IllegalArgumentException -> L8
    L10:
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L12:
        return super.onTouchEvent(r100);
    }

    public DragRelativeLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f125049a = ViewDragHelper.create(this, 1.0f, new DragRelativeLayout$initDragHelper$1(this));
    }
}
