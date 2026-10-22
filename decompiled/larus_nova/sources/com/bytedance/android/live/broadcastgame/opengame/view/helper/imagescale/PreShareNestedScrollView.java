package com.bytedance.android.live.broadcastgame.opengame.view.helper.imagescale;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/helper/imagescale/PreShareNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/bytedance/android/live/broadcastgame/opengame/view/helper/imagescale/PreShareNestedScrollView$a;", "preScrollListener", "Lcom/bytedance/android/live/broadcastgame/opengame/view/helper/imagescale/PreShareNestedScrollView$a;", "getPreScrollListener", "()Lcom/bytedance/android/live/broadcastgame/opengame/view/helper/imagescale/PreShareNestedScrollView$a;", "setPreScrollListener", "(Lcom/bytedance/android/live/broadcastgame/opengame/view/helper/imagescale/PreShareNestedScrollView$a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreShareNestedScrollView extends NestedScrollView {

    public interface a {
    }

    public PreShareNestedScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PreShareNestedScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final a getPreScrollListener() {
        return null;
    }

    public final void setPreScrollListener(a r100) {
    }

    public PreShareNestedScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ PreShareNestedScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103, int r104) {
        if (r102 == null) goto L5;
        int r105 = r102.length;
    L5:
        return super.dispatchNestedPreScroll(r100, r101, r102, r103, r104);
    }
}
