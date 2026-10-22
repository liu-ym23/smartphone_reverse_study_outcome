package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECRoundedLinearLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/widget/CombinationView;", "Lcom/bytedance/android/livesdk/livecommerce/view/ECRoundedLinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CombinationView extends ECRoundedLinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ECNetImageView> f152506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f152507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f152508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECDraweeView f152509e;

    public CombinationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CombinationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public CombinationView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f152506b = new ArrayList();
        setOrientation(0);
        setBackgroundResource(R.drawable.ec_bg_combination_view);
        ImageView r113 = new ImageView(r110);
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams((int) UtilityKotlinExtentionsKt.c(12), (int) UtilityKotlinExtentionsKt.c(24));
        r100.setMargins((int) UtilityKotlinExtentionsKt.c(5), (int) UtilityKotlinExtentionsKt.c(2), 0, (int) UtilityKotlinExtentionsKt.c(3));
        r113.setImageResource(R.drawable.ec_icon_explain_card_combination);
        Unit r114 = Unit.INSTANCE;
        r113.setLayoutParams(r100);
        addView(r113);
        int r115 = getChildCount();
        this.f152507c = r115;
        this.f152508d = r115;
        ECDraweeView r116 = new ECDraweeView(r110, null, 0, 6, null);
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(r116.getDp(4), r116.getDp(7));
        r117.setMargins(r116.getDp(1), r116.getDp(12), r116.getDp(3), r116.getDp(10));
        r116.setImageResource(R.drawable.ec_icon_explain_card_combination_right_arrow);
        r116.setLayoutParams(r117);
        this.f152509e = r116;
        addView(r116);
    }

    public /* synthetic */ CombinationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
