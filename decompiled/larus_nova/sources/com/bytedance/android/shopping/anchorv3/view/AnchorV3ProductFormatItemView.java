package com.bytedance.android.shopping.anchorv3.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.repository.dto.AttrItem;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormat;
import com.bytedance.android.shopping.widget.legacy.SquareImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/AnchorV3ProductFormatItemView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/u;", "", "getCurrentContentDescription", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3ProductFormatItemView extends LinearLayout implements com.bytedance.android.shopping.anchorv4.voavhs.detailhead.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f165448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f165449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SquareImageView f165450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoundedFrameLayout f165451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f165452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f165453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f165454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f165455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f165456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.detailhead.w f165457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f165458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f165459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f165460m;

    public AnchorV3ProductFormatItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3ProductFormatItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailhead.u
    public final TextView a() {
        TextView r100 = this.f165454g;
        if (r100 == null) goto L8;
        if (this.f165459l == false) goto L8;
        return r100;
    L8:
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailhead.u
    public final View c() {
        SquareImageView r100 = this.f165450c;
        if (r100 == null) goto L8;
        if (this.f165458k == false) goto L8;
        return r100;
    L8:
        return null;
    }

    public final String getCurrentContentDescription() {
        String r100 = this.f165456i;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailhead.u
    public final String b() {
        return this.f165460m;
    }

    public AnchorV3ProductFormatItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f165456i = "";
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_anchorv3_product_format_item_layout, this, true);
        this.f165448a = (TextView) findViewById(R.id.anchor_v3_tv_product_format_title);
        this.f165449b = (TextView) findViewById(R.id.anchor_v3_tv_product_format_desc);
        this.f165450c = (SquareImageView) findViewById(R.id.anchor_v3_brand_logo);
        this.f165451d = (RoundedFrameLayout) findViewById(R.id.anchor_v3_rfl_brand_logo);
        this.f165452e = (LinearLayout) findViewById(R.id.anchor_v3_ll_go_to_qualification);
        this.f165453f = (LinearLayout) findViewById(R.id.anchor_v3_qualification_context);
        this.f165454g = (TextView) findViewById(R.id.anchor_v3_brand_text);
        setContentDescription(null);
    }

    public /* synthetic */ AnchorV3ProductFormatItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void d(AttrItem r100, ProductFormat r101, String r102, com.bytedance.android.shopping.anchorv4.voavhs.detailhead.w r103) {
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        this.f165455h = r102;
        this.f165457j = r103;
        this.f165460m = r101.getType();
        Integer r104 = r101.getMaxLines();
        boolean r105 = false;
        String r106 = null;
        if (r104 != null) goto L5;
    L13:
        if (r100 == null) goto L78;
        List<ECUrlModel> r107 = r101.getPicUrls();
        if (r107 != null) goto L17;
    L19:
        boolean r108 = false;
    L20:
        String r109 = r101.getType();
        if (r109 == null) goto L23;
        Boolean r110 = Boolean.valueOf(a2.b(r109));
    L24:
        ECUrlModel r111 = r101.getLogo();
        if (r111 == null) goto L27;
        String r112 = r111.getUri();
    L28:
        this.f165458k = a2.b(r112);
        if (r108 == true) goto L31;
    L33:
        this.f165459l = r105;
        if (Intrinsics.areEqual(r101.getType(), "0") == false) goto L37;
        r106 = com.bytedance.android.shopping.extensions.j.c(R.string.commerce_anchor_v3_official_operated_shop);
    L39:
        LinearLayout r113 = this.f165453f;
        if (r113 == null) goto L42;
        wg.a.h(r113, this.f165459l);
    L42:
        LinearLayout r114 = this.f165452e;
        if (r114 == null) goto L45;
        wg.a.h(r114, r108);
    L45:
        RoundedFrameLayout r115 = this.f165451d;
        if (r115 == null) goto L48;
        wg.a.h(r115, this.f165458k);
    L48:
        this.f165449b.setText(r100.getDesc());
        boolean r116 = a2.b(r100.getTitle());
        wg.a.h(this.f165448a, r116);
        if (r116 == false) goto L51;
        this.f165448a.setText(r100.getTitle());
        this.f165456i = this.f165456i + r100.getTitle();
    L51:
        this.f165456i = this.f165456i + r100.getDesc();
        if (this.f165458k == false) goto L60;
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.w r117 = this.f165457j;
        if (r117 == null) goto L56;
        r117.c();
    L56:
        SquareImageView r118 = this.f165450c;
        if (r118 == null) goto L60;
        com.bytedance.android.ec.core.utils.y.a(r118, r101.getLogo());
    L60:
        if (this.f165459l == false) goto L68;
        r101.getType();
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.w r119 = this.f165457j;
        if (r119 == null) goto L64;
        r119.a();
    L64:
        TextView r120 = this.f165454g;
        if (r120 == null) goto L67;
        r120.setText(r101.getContext());
    L67:
        this.f165456i = this.f165456i + r101.getContext();
    L68:
        Activity r121 = com.bytedance.android.ec.sdk.plugin.e.getActivity(getContext());
        if (r121 == null) goto L77;
        FragmentManager r122 = ((FragmentActivity) r121).getSupportFragmentManager();
        if (r122 == null) goto L81;
        LinearLayout r123 = this.f165452e;
        if (r123 == null) goto L79;
        r123.setOnClickListener(new u(this, r106, r101, r122));
        return;
    L79:
        return;
    L81:
        return;
    L77:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L37:
        if (Intrinsics.areEqual(r101.getType(), "1") == false) goto L39;
        r106 = com.bytedance.android.shopping.extensions.j.c(R.string.commerce_anchor_v3_agent_operated_shop);
        goto L39
    L31:
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == false) goto L33;
        r105 = true;
        goto L33
    L27:
        r112 = null;
        goto L28
    L23:
        r110 = null;
        goto L24
    L17:
        if (r107.isEmpty() == true) goto L19;
        r108 = true;
        goto L20
    L78:
        return;
    L5:
        if (r104.intValue() <= 0) goto L7;
        boolean r124 = true;
    L8:
        if (r124 == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L13;
        this.f165449b.setMaxLines(r104.intValue());
        goto L13
    L7:
        r124 = false;
        goto L8
    }
}
