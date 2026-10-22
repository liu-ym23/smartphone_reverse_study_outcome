package com.bytedance.android.shopping.store.status;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.store.utils.o;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f186442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f186443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f186444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECShopEmptyPageType f186445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f186446e;

    public final void a() {
        if (this.f186446e == false) goto L5;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setBackgroundColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        setPadding(0, 0, 0, 0);
        ImageView r100 = this.f186442a;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        r101.height = o.a(120);
        r101.width = o.a(120);
        Unit r102 = Unit.INSTANCE;
        r100.setLayoutParams(r101);
        this.f186443b.setTextSize(2, 17.0f);
        TextView r103 = this.f186443b;
        int r104 = c.f47296a;
        d2.f(r103, c.d(8));
        this.f186444c.setTextSize(2, 14.0f);
        d2.f(this.f186444c, c.d(8));
        return;
    L5:
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int r105 = c.f47296a;
        setPadding(0, c.d(40), 0, c.d(40));
        ImageView r106 = this.f186442a;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        r107.height = o.a(80);
        r107.width = o.a(80);
        Unit r108 = Unit.INSTANCE;
        r106.setLayoutParams(r107);
        this.f186443b.setTextSize(2, 15.0f);
        d2.f(this.f186443b, c.d(6));
        this.f186444c.setTextSize(2, 13.0f);
        d2.f(this.f186444c, c.d(6));
    }

    public final ECShopEmptyPageType getPageType() {
        return this.f186445d;
    }

    public final void setBigSize(boolean r100) {
        this.f186446e = r100;
    }

    public b(Context r100, ECShopEmptyPageType r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageType");
        super(r100, null, 0);
        this.f186445d = r101;
        this.f186446e = r102;
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_shop_empty_status_view, this, true);
        setGravity(17);
        setOrientation(1);
        ImageView r103 = (ImageView) findViewById(R.id.ec_shop_empty_image);
        this.f186442a = r103;
        TextView r104 = (TextView) findViewById(R.id.ec_shop_empty_title);
        this.f186443b = r104;
        TextView r105 = (TextView) findViewById(R.id.ec_shop_empty_sub_title);
        this.f186444c = r105;
        int r106 = a.f186441a[r101.ordinal()];
        if (r106 == 1) goto L9;
        if (r106 != 2) goto L13;
        r103.setImageResource(R.drawable.ec_shop_search_empty);
        r104.setText(th.a.g(getContext(), R.string.ec_shop_search_empty_product_title));
        r105.setText(th.a.g(getContext(), R.string.ec_shop_search_empty_product_sub_title));
    L13:
        a();
        return;
    L9:
        if (com.bytedance.android.shopping.store.settings.a.a() == false) goto L11;
        r103.setImageResource(R.drawable.ec_shop_empty_product_v2);
    L12:
        r104.setText(th.a.g(getContext(), R.string.ec_shop_empty_product_title));
        r105.setText(th.a.g(getContext(), R.string.ec_shop_empty_product_sub_title));
        goto L13
    L11:
        r103.setImageResource(R.drawable.ec_shop_empty_product);
        goto L12
    }
}
