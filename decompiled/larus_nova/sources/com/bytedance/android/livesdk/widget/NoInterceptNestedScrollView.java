package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/widget/NoInterceptNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NoInterceptNestedScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OverScroller f161222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f161223b;

    public static final class a {
    }

    static {
    }

    public NoInterceptNestedScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NoInterceptNestedScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getActionMasked() != 0) goto L36;
    L30:
        th = move-exception;
        ALogger.e("NoInterceptNestedScrollView", "setParentScrollerFinish error, " + th.getMessage());
        String r101 = th.getMessage();
        if (r101 != null) goto L34;
        r101 = "";
    L34:
        SafetyGuard.a(null, null, "NoInterceptNestedScrollView ".concat(r101));
        goto L36
    L6:
        if (this.f161222a != null) goto L18;
        Field r102 = NestedScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L30
        if (r102 == null) goto L10;
        r102.setAccessible(true);     // Catch: Throwable -> L30
    L10:
        if (r102 == null) goto L12;
        Object r103 = r102.get(this);     // Catch: Throwable -> L30
    L14:
        if ((r103 instanceof OverScroller) == true) goto L16;
        r103 = null;
    L16:
        this.f161222a = (OverScroller) r103;     // Catch: Throwable -> L30
        goto L18
    L12:
        r103 = null;
    L18:
        if (this.f161223b != null) goto L22;
        Method r104 = NestedScrollView.class.getDeclaredMethod("abortAnimatedScroll", new Class[0]);     // Catch: Throwable -> L30
        this.f161223b = r104;     // Catch: Throwable -> L30
        if (r104 == null) goto L22;
        r104.setAccessible(true);     // Catch: Throwable -> L30
    L22:
        OverScroller r105 = this.f161222a;     // Catch: Throwable -> L30
        if (r105 != null) goto L25;
    L26:
        ALogger.i("NoInterceptNestedScrollView", "setParentScrollerFinish set mScroller finish");     // Catch: Throwable -> L30
        Method r106 = this.f161223b;     // Catch: Throwable -> L30
        if (r106 == null) goto L36;
        r106.invoke(this, new Object[0]);     // Catch: Throwable -> L30
        goto L36
    L25:
        if (r105.isFinished() != true) goto L26;
    L36:
        return super.onInterceptTouchEvent(r100);
    }

    public NoInterceptNestedScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ NoInterceptNestedScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
