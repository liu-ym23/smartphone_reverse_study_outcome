package com.bytedance.android.livesdk.chatroom.miniapp.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.customview.widget.ViewDragHelper;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oh1.b;
import oh1.c;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/miniapp/views/TTLiveDragRelativeLayout;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TTLiveDragRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f106877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f106878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f106879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f106880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f106881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewDragHelper f106882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f106883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f106884h;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f106883g = getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        View r101 = this.f106883g;
        if (r101 == null) goto L5;
        int r102 = r101.getLeft();
    L6:
        View r103 = this.f106883g;
        if (r103 == null) goto L9;
        int r104 = r103.getTop();
    L10:
        View r105 = this.f106883g;
        if (r105 == null) goto L13;
        int r106 = r105.getRight();
    L14:
        View r107 = this.f106883g;
        if (r107 == null) goto L17;
        int r108 = r107.getBottom();
    L19:
        if (r100.getX() >= r102) goto L21;
    L27:
        boolean r109 = false;
    L28:
        this.f106884h = r109;
        if (r109 == false) goto L34;
        ViewDragHelper r110 = this.f106882f;
        if (r110 != null) goto L36;
        return false;
    L36:
        return r110.shouldInterceptTouchEvent(r100);
    L34:
        return super.onInterceptTouchEvent(r100);
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

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f106884h == false) goto L12;
        getParent().requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L9
        ViewDragHelper r101 = this.f106882f;     // Catch: IllegalArgumentException -> L9
        if (r101 == null) goto L15;
        r101.processTouchEvent(r100);     // Catch: IllegalArgumentException -> L9
        return true;
    L15:
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();
        return true;
    L12:
        return super.onTouchEvent(r100);
    }

    public TTLiveDragRelativeLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.ttlive_dock_margin_bottom, R.attr.ttlive_dock_margin_left, R.attr.ttlive_dock_margin_right, R.attr.ttlive_dock_margin_top, R.attr.ttlive_dock_mode});
        this.f106877a = r102.getInt(4, R.id.drag_layout);
        this.f106878b = r102.getDimensionPixelOffset(1, 0);
        this.f106879c = r102.getDimensionPixelOffset(2, 0);
        this.f106880d = r102.getDimensionPixelOffset(3, 0);
        this.f106881e = r102.getDimensionPixelOffset(0, 0);
        r102.recycle();
        this.f106882f = ViewDragHelper.create(this, 1.0f, new TTLiveDragRelativeLayout$initDragHelper$1(this));
    }

    public static void a(TTLiveDragRelativeLayout r100, View r101, int r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = 0;
    L8:
        r100.getClass();
        int r105 = r101.getLeft();
        int r106 = r101.getTop();
        if (r102 == 0) goto L11;
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{0, r102});
        r107.addUpdateListener(new b(r101, r105, r106));
    L14:
        if (r107 == null) goto L16;
        r107.setDuration(250);
    L16:
        if (r107 == null) goto L19;
        r107.start();
        return;
    L19:
        return;
    L11:
        if (r103 == 0) goto L13;
        r107 = ValueAnimator.ofInt(new int[]{0, r103});
        r107.addUpdateListener(new c(r101, r105, r106));
        goto L14
    L13:
        r107 = null;
        goto L14
    }
}
