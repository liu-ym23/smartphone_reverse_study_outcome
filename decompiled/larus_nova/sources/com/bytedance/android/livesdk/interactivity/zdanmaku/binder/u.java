package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class u extends tk6.e<q22.a, View> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f141565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f141566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f141567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f141568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f141569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f141570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f141571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f141572l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f141573m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h80.d<p22.g> f141574n;

    public u(View r100, h80.d<p22.g> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "giftDanmakuSettingConfigSupplier");
        super(r100, DanmakuCacheProviders.f141301a, SnapType.Bitmap, 8);
        this.f141574n = r101;
        this.f141565e = r100.findViewById(R.id.gift_content_layout);
        this.f141566f = (ImageView) r100.findViewById(R.id.iv_gift_icon);
        this.f141567g = (TextView) r100.findViewById(R.id.tv_gift_description);
        this.f141568h = (TextView) r100.findViewById(R.id.tv_gift_combo_count);
        this.f141569i = r100.findViewById(R.id.gift_group_count_layout);
        this.f141570j = (TextView) r100.findViewById(R.id.tv_gift_group_count);
        this.f141571k = r100.findViewById(R.id.gift_barrage_layout);
        this.f141572l = (TextView) r100.findViewById(R.id.tv_gift_combo_prefix);
        this.f141573m = (TextView) r100.findViewById(R.id.tv_gift_group_count_prefix);
    }

    @Override // of6.b
    public final void b(Object r100, RenderEntity r101) {
        q22.a r102 = (q22.a) r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "entity");
        p22.g r103 = this.f141574n.get();
        this.f141565e.setBackgroundResource(r102.f531401h);
        this.f141567g.setText(r102.f531400g);
        this.f141568h.setText(r102.f531403j.toString() + " ");
        if (r102.f531402i > 1) goto L5;
        UIUtils.setViewVisibility(this.f141569i, 8);
    L6:
        a1.k(this.f141569i, r103.f527395d.f527403g);
        a1.k(this.f141566f, r103.f527395d.f527398b);
        a1.p(this.f141566f, r103.f527395d.f527398b);
        this.f141565e.setPadding(r103.f527395d.f527398b, -3, -3, -3);
        a1.k(this.f141565e, r103.f527395d.f527399c);
        this.f141567g.setTextSize(0, r103.f527395d.f527400d);
        this.f141572l.setTextSize(0, r103.f527395d.f527401e);
        this.f141568h.setTextSize(0, r103.f527395d.f527402f);
        this.f141573m.setTextSize(0, r103.f527395d.f527404h);
        this.f141570j.setTextSize(0, r103.f527395d.f527404h);
        BarrageSettingFont r104 = r103.f527393b;
        if (r104 == null) goto L15;
        int r105 = t.f141564a[r104.ordinal()];
        if (r105 != 1) goto L12;
        int r106 = s1.f(15.0f);
    L19:
        a1.m(this.f141569i, r106);
        Bitmap r107 = r102.f531394a;
        if (r107 != null) goto L22;
    L24:
        this.f141566f.setImageDrawable(null);
        return;
    L22:
        if (r107.isRecycled() == true) goto L24;
        this.f141566f.setImageBitmap(r107);
        return;
    L12:
        if (r105 != 2) goto L14;
        r106 = s1.f(12.0f);
        goto L19
    L14:
        if (r105 != 3) goto L15;
        r106 = s1.f(9.0f);
    L15:
        r106 = s1.f(9.0f);
        goto L19
    L5:
        UIUtils.setViewVisibility(this.f141569i, 0);
        this.f141570j.setText(String.valueOf(r102.f531402i));
        goto L6
    }
}
