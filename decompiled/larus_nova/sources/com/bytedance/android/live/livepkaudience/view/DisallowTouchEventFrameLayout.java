package com.bytedance.android.live.livepkaudience.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/view/DisallowTouchEventFrameLayout;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getBlockYTop", "()I", "setBlockYTop", "(I)V", "blockYTop", "b", "getBlockYBottom", "setBlockYBottom", "blockYBottom", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DisallowTouchEventFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f82296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f82297b;

    public DisallowTouchEventFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DisallowTouchEventFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getBlockYBottom() {
        return this.f82297b;
    }

    public final int getBlockYTop() {
        return this.f82296a;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L5:
        if (r101 != null) goto L8;
    L10:
        if (r101 != null) goto L13;
    L25:
        return super.onInterceptTouchEvent(r100);
    L13:
        if (r101.intValue() != 2) goto L25;
    L14:
        int r102 = this.f82296a;
        if (r102 < 0) goto L25;
        int r103 = this.f82297b;
        if (r103 < 0) goto L25;
        if (r103 <= r102) goto L25;
        if (r100.getY() <= this.f82296a) goto L25;
        if (r100.getY() >= this.f82297b) goto L25;
        requestDisallowInterceptTouchEvent(true);
        goto L25
    L8:
        if (r101.intValue() != 0) goto L10;
    L4:
        r101 = null;
        goto L5
    }

    public final void setBlockYBottom(int r100) {
        this.f82297b = r100;
    }

    public final void setBlockYTop(int r100) {
        this.f82296a = r100;
    }

    public DisallowTouchEventFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ DisallowTouchEventFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
