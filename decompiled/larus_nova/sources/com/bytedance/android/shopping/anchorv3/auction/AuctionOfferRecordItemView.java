package com.bytedance.android.shopping.anchorv3.auction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/auction/AuctionOfferRecordItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/facebook/drawee/view/SimpleDraweeView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/facebook/drawee/view/SimpleDraweeView;", "getAvatarView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getUserNameView", "()Landroid/widget/TextView;", "userNameView", "c", "getStateView", "stateView", "d", "getTimeView", "timeView", "Lcom/bytedance/android/ec/core/widget/price/PriceView;", "e", "Lcom/bytedance/android/ec/core/widget/price/PriceView;", "getPriceView", "()Lcom/bytedance/android/ec/core/widget/price/PriceView;", "priceView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionOfferRecordItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f164438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f164439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f164440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f164441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PriceView f164442e;

    public AuctionOfferRecordItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AuctionOfferRecordItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final SimpleDraweeView getAvatarView() {
        return this.f164438a;
    }

    public final PriceView getPriceView() {
        return this.f164442e;
    }

    public final TextView getStateView() {
        return this.f164440c;
    }

    public final TextView getTimeView() {
        return this.f164441d;
    }

    public final TextView getUserNameView() {
        return this.f164439b;
    }

    public AuctionOfferRecordItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(r100, R.layout.shopping_view_offer_record_item, this);
        this.f164438a = (SimpleDraweeView) findViewById(R.id.avatar);
        this.f164439b = (TextView) findViewById(R.id.user_name);
        this.f164441d = (TextView) findViewById(R.id.offer_time);
        this.f164442e = (PriceView) findViewById(R.id.price_view);
        this.f164440c = (TextView) findViewById(R.id.record_state);
    }

    public /* synthetic */ AuctionOfferRecordItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
