package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/AnchorV3PresaleDepositLayout;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3PresaleDepositLayout extends LinearLayout implements com.bytedance.android.shopping.feed.view.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f164845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f164846b;

    public AnchorV3PresaleDepositLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3PresaleDepositLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public static void b(AnchorV3PresaleDepositLayout r100, PromotionProductBannerStruct r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103 == null) goto L8;
        r103.bottomMargin = com.bytedance.android.shopping.extensions.b.b(8);
    L8:
        r100.f164845a.setText(r101.getTitle());
        r100.f164846b.setText(r101.getContent());
    }

    public AnchorV3PresaleDepositLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        u63.a.a(r100, R.layout.ec_commerce_anchor_v3_deposit_info_layout, this, true);
        this.f164845a = (TextView) findViewById(R.id.anchor_v3_tv_presale_deposit_title);
        this.f164846b = (TextView) findViewById(R.id.anchor_v3_tv_presale_start_end_time);
    }

    public /* synthetic */ AnchorV3PresaleDepositLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
