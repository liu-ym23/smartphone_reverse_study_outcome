package com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewholder/LivePromotionListHeaderWrapperView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListHeaderWrapperView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f151273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LivePromotionListHeaderLoadMoreItem f151274b;

    public LivePromotionListHeaderWrapperView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        d r103 = new d(this);
        this.f151273a = r103;
        LivePromotionListHeaderLoadMoreItem r104 = new LivePromotionListHeaderLoadMoreItem(this);
        this.f151274b = r104;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        addView(r103.f151277a);
        addView(r104.f151268a);
    }
}
