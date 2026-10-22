package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/RevScrollListenerView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/RevScrollListenerView$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/live/revlink/impl/pk/ui/RevScrollListenerView$a;", "getScrollListener", "()Lcom/bytedance/android/live/revlink/impl/pk/ui/RevScrollListenerView$a;", "setScrollListener", "(Lcom/bytedance/android/live/revlink/impl/pk/ui/RevScrollListenerView$a;)V", "scrollListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevScrollListenerView extends NestedScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f97023a;

    public interface a {
        void a(int r100);
    }

    public RevScrollListenerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RevScrollListenerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final a getScrollListener() {
        return this.f97023a;
    }

    public final void setScrollListener(a r100) {
        this.f97023a = r100;
    }

    public RevScrollListenerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ RevScrollListenerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        a r104 = this.f97023a;
        if (r104 == null) goto L6;
        r104.a(r101);
        return;
    }
}
