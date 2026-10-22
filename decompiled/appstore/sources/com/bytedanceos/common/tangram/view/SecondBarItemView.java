package com.bytedanceos.common.tangram.view;

import a9.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.ui.BaseMainActivity;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.util.ImageUtils;
import tc.f;
import z8.a;

/* JADX INFO: loaded from: classes2.dex */
public class SecondBarItemView extends NavigationView {
    static {
        a.a(1, new int[]{230});
    }

    public SecondBarItemView(Context r10) {
        this(r10, null);
    }

    @Override // com.bytedanceos.common.tangram.view.NavigationView
    public void a(Topic r10, BaseCell r11) {
        super.a(r10, r11);
        if (TextUtils.equals(r10.getTitle(), "新游预约") == false) goto L6;
        NetworkImageView r12 = this.f9955a;
        int r13 = R$drawable.oui_icon_time;
        r12.setDefaultImageResId(r13);
        this.f9955a.setImageDrawable(c.a.b(getContext(), r13));
    L9:
        this.f9955a.setImageTintMode(PorterDuff.Mode.SRC_IN);
        if ((getContext() instanceof BaseMainActivity) == true) goto L12;
    L14:
        this.f9955a.setImageTintList(ColorStateList.valueOf(getResources().getColor(R$color.oui_b_blue_fg)));
        return;
    L12:
        if (((BaseMainActivity) getContext()).isGame() == false) goto L14;
        this.f9955a.setImageTintList(ColorStateList.valueOf(getResources().getColor(R$color.oui_b_blue_fg)));
        return;
    L6:
        if (TextUtils.equals(r10.getTitle(), "一步精选") == false) goto L8;
        NetworkImageView r14 = this.f9955a;
        int r15 = R$drawable.oui_icon_one_step;
        r14.setDefaultImageResId(r15);
        this.f9955a.setImageDrawable(c.a.b(getContext(), r15));
        goto L9
    L8:
        ImageUtils.doLoadImageUrl(this.f9955a, r10.getImageResUrl());
        goto L9
    }

    @Override // com.bytedanceos.common.tangram.view.NavigationView, com.bytedanceos.common.tangram.Bind
    public /* bridge */ /* synthetic */ void bindData(Topic r10, BaseCell r11) {
        a(r10, r11);
    }

    @Override // com.bytedanceos.common.tangram.view.NavigationView
    public void c() {
        this.f9959e = 230;
    }

    @Override // com.bytedanceos.common.tangram.view.NavigationView
    public void d(b r10) {
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) this.f9955a.getLayoutParams();
        r11.width = f.i(24);
        r11.height = f.i(24);
        r11.setMargins(0, f.i(12), 0, 0);
        this.f9955a.setLayoutParams(r11);
    }

    @Override // com.bytedanceos.common.tangram.view.NavigationView
    public void f(b r10) {
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) this.f9956b.getLayoutParams();
        r11.setMargins(0, f.i(8), 0, f.i(12));
        r11.height = f.i(14);
        this.f9956b.setLayoutParams(r11);
        this.f9956b.setIncludeFontPadding(false);
        this.f9956b.setTextSize(2, 11.0f);
        this.f9956b.setTextColor(getContext().getColor(R$color.oui_text_3));
    }

    public SecondBarItemView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public SecondBarItemView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
