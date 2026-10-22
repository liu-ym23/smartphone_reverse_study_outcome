package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ECHostLiveNoPromotionLayout extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f153151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f153152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f153153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f153154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnClickListener f153155e;

    public abstract TextView a(View r100);

    public abstract void b();

    public abstract TextView c(View r100);

    public ECHostLiveNoPromotionLayout(Context r100) {
        super(r100);
        d(r100);
    }

    public final void d(Context r100) {
        View r101 = View.inflate(r100, R.layout.ec_live_no_promotion, (ECHostLiveNoPromotionLayoutImpl) this);
        this.f153151a = r101;
        this.f153152b = c(r101);
        b();
        this.f153153c = null;
        TextView r102 = a(this.f153151a);
        this.f153154d = r102;
        if (r102 == null) goto L6;
        r102.setOnClickListener(this);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != this.f153154d) goto L8;
        View.OnClickListener r101 = this.f153155e;
        if (r101 == null) goto L9;
        r101.onClick(r100);
        return;
    L9:
        return;
    }

    public void setIronNoPromotion(String r100) {
        TextView r101 = this.f153152b;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
        this.f153152b.setText(r100);
        this.f153152b.setTypeface(Typeface.DEFAULT_BOLD);
    L5:
        TextView r102 = this.f153153c;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        TextView r103 = this.f153154d;
        if (r103 == null) goto L12;
        r103.setVisibility(8);
        return;
    }

    public void setOnAddButtonClickListener(View.OnClickListener r100) {
        this.f153155e = r100;
    }

    public ECHostLiveNoPromotionLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        d(r100);
    }

    public ECHostLiveNoPromotionLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        d(r100);
    }
}
