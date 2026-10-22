package com.bytedance.android.shopping.feed.resourcecard.view.countdownview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/countdownview/CouponCountDownViewV2;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/countdownview/BaseCountDownView;", "", "getLayout", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponCountDownViewV2 extends BaseCountDownView {
    public CouponCountDownViewV2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CouponCountDownViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.countdownview.BaseCountDownView
    public int getLayout() {
        return R.layout.ec_commerce_count_down_view_v2;
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.countdownview.BaseCountDownView
    public final void e(long r110) {
        long r111 = r110 / 1000;
        if (r111 <= 0) goto L14;
        TextView r100 = getTvHours();
        if (r100 == null) goto L7;
        r100.setText(getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Long.valueOf(r111 / ((long) AnnouncementViewModel.HOUR_DURATION))}));
    L7:
        TextView r101 = getTvMins();
        if (r101 == null) goto L10;
        r101.setText(getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Long.valueOf((r111 % ((long) AnnouncementViewModel.HOUR_DURATION)) / ((long) 60))}));
    L10:
        TextView r102 = getTvSecs();
        if (r102 == null) goto L15;
        r102.setText(getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Long.valueOf((r111 % ((long) AnnouncementViewModel.HOUR_DURATION)) % ((long) 60))}));
        return;
    L15:
        return;
    }

    public CouponCountDownViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ CouponCountDownViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
