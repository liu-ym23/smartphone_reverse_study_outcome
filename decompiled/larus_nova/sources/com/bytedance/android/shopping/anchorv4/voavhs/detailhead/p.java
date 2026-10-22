package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.util.AttributeSet;
import com.bytedance.android.shopping.anchorv3.repository.dto.AttrItem;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormat;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3ProductFormatItemView;
import com.bytedance.commerce.uikit.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class p extends fg4.a<AttrItem> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AnchorV4DetailSkuPropertiesFragment f168246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ProductFormat f168247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f168248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ q f168249f;

    @Override // fg4.a
    public final AnchorV3ProductFormatItemView a(FlowLayout r100, Object r101) {
        AttrItem r102 = (AttrItem) r101;
        AttributeSet r103 = null;
        if (r100 == null) goto L6;
        AnchorV3ProductFormatItemView r104 = new AnchorV3ProductFormatItemView(r100.getContext(), r103, 6, 0);
        r104.d(r102, this.f168247d, this.f168248e, this.f168249f);
        ((ArrayList) this.f168246c.f168190l).add(r104);
        return r104;
    L6:
        return null;
    }

    public p(AnchorV4DetailSkuPropertiesFragment r100, ProductFormat r101, String r102, q r103, List r104) {
        this.f168246c = r100;
        this.f168247d = r101;
        this.f168248e = r102;
        this.f168249f = r103;
        super(r104);
    }
}
