package com.bytedance.android.shopping.anchorv3.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.experiment.h;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/widget/BasePdpRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/shopping/anchorv3/widget/d;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/anchorv3/widget/d;", "getInterceptHandler", "()Lcom/bytedance/android/shopping/anchorv3/widget/d;", "setInterceptHandler", "(Lcom/bytedance/android/shopping/anchorv3/widget/d;)V", "interceptHandler", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePdpRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f165588b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f165589a;

    public static final class a {
    }

    public BasePdpRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BasePdpRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract boolean r();

    static {
        boolean r100 = h.f166757a;
        int r101 = 1;
        if (h.f166758b == 1) goto L6;
        r101 = 0;
    L6:
        f165588b = r101;
    }

    public final d getInterceptHandler() {
        return this.f165589a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        d r101 = this.f165589a;
        if (r101 == null) goto L9;
        if (r101.b(r100) != true) goto L9;
        return false;
    L9:
        return t(r100);
    }

    public final void setInterceptHandler(d r100) {
        this.f165589a = r100;
    }

    public boolean t(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    }

    public BasePdpRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (f165588b != 1) goto L6;
        setClipChildren(true);
        return;
    }

    public /* synthetic */ BasePdpRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
