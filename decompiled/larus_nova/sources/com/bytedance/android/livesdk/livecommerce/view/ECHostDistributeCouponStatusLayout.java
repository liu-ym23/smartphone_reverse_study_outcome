package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public class ECHostDistributeCouponStatusLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f153143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f153144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f153145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f153146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f153147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f153148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f153149g;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHostDistributeCouponStatusLayout f153150a;

        public a(ECHostDistributeCouponStatusLayout r100) {
            this.f153150a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ECHostDistributeCouponStatusLayout r101 = this.f153150a;
            if (r101.f153149g == false) goto L8;
            b r102 = r101.f153143a;
            if (r102 == null) goto L9;
            r102.onClick();
            return;
        L9:
            return;
        }
    }

    public interface b {
        void onClick();
    }

    public ECHostDistributeCouponStatusLayout(Context r100) {
        super(r100);
        this.f153145c = -2146035677;
        this.f153146d = -1;
        this.f153147e = R.drawable.ec_coupon_new_bg;
        this.f153148f = R.drawable.ec_bg_unable_distribute_coupon;
        this.f153149g = false;
        a(r100);
    }

    public final void a(Context r100) {
        this.f153146d = r100.getResources().getColor(R.color.ec_color_pink_fe2c55);
        this.f153147e = R.drawable.ec_coupon_new_bg;
        TextView r101 = new TextView(r100);
        this.f153144b = r101;
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f153144b.setTextSize(1, 13.0f);
        this.f153144b.setGravity(17);
        addView(this.f153144b);
        this.f153144b.setOnClickListener(new a(this));
    }

    public void setDistributeClickListener(b r100) {
        this.f153143a = r100;
    }

    public void setDistributeCouponButtonAlpha(float r100) {
        this.f153144b.setAlpha(r100);
    }

    public ECHostDistributeCouponStatusLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f153145c = -2146035677;
        this.f153146d = -1;
        this.f153147e = R.drawable.ec_coupon_new_bg;
        this.f153148f = R.drawable.ec_bg_unable_distribute_coupon;
        this.f153149g = false;
        a(r100);
    }

    public final void b(String r100, boolean r101) {
        this.f153149g = true;
        this.f153144b.setTextColor(getContext().getResources().getColor(R.color.ec_color_white));
        if (r101 == false) goto L5;
        this.f153144b.setBackgroundResource(this.f153147e);
    L6:
        this.f153144b.setText(r100);
        return;
    L5:
        this.f153144b.setBackgroundResource(this.f153148f);
        goto L6
    }

    public ECHostDistributeCouponStatusLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f153145c = -2146035677;
        this.f153146d = -1;
        this.f153147e = R.drawable.ec_coupon_new_bg;
        this.f153148f = R.drawable.ec_bg_unable_distribute_coupon;
        this.f153149g = false;
        a(r100);
    }
}
