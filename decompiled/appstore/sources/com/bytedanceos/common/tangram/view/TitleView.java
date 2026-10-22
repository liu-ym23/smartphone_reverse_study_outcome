package com.bytedanceos.common.tangram.view;

import a9.c;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.p;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.tangram.Bind;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.util.ImageUtils;
import z8.a;

/* JADX INFO: loaded from: classes2.dex */
public class TitleView extends RelativeLayout implements Bind<Topic> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NetworkImageView f9968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f9969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f9970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9971d;

    static {
        a.a(4, new int[]{240});
    }

    public TitleView(Context r10) {
        this(r10, null);
    }

    private void b() {
        this.f9969b = new TextView(getContext());
        RelativeLayout.LayoutParams r10 = new RelativeLayout.LayoutParams(-2, -1);
        r10.addRule(9);
        this.f9969b.setTypeface(Typeface.DEFAULT_BOLD);
        this.f9969b.setGravity(16);
        addView(this.f9969b, r10);
        this.f9970c = new ImageView(getContext());
        RelativeLayout.LayoutParams r11 = new RelativeLayout.LayoutParams(-2, -1);
        r11.addRule(11);
        addView(this.f9970c, r11);
        this.f9970c.setImageResource(R$drawable.item_arrow);
        ImageView r12 = new ImageView(getContext());
        r12.setImageResource(R$drawable.line);
        r12.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams r13 = new RelativeLayout.LayoutParams(-1, -2);
        r13.addRule(12);
        addView(r12, r13);
    }

    public void a(Topic r10, BaseCell r11) {
        this.f9969b.setText(r10.getTitle());
        setTag(r10);
        if (this.f9971d == false) goto L5;
        ImageUtils.doLoadImageUrl(this.f9968a, r10.getImageResUrl());
        this.f9968a.setVisibility(0);
    L8:
        r11.setOnClickListener(this, 240);
        if (TextUtils.isEmpty(r10.getId()) == false) goto L11;
        this.f9970c.setVisibility(8);
        return;
    L11:
        this.f9970c.setVisibility(0);
        return;
    L5:
        NetworkImageView r12 = this.f9968a;
        if (r12 == null) goto L8;
        r12.setVisibility(8);
        goto L8
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public /* bridge */ /* synthetic */ void bindData(Topic r10, BaseCell r11) {
        a(r10, r11);
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void bindStyle(Style r10, BaseCell r11) {
        setGravity(16);
        p.a(r10);
        d(null);
        e(null);
        c(null);
        getLayoutParams();
        throw null;
    }

    public final void c(c r10) {
        RelativeLayout.LayoutParams r11 = (RelativeLayout.LayoutParams) this.f9970c.getLayoutParams();
        throw null;
    }

    public final void d(c r10) {
        throw null;
    }

    public final void e(c r10) {
        RelativeLayout.LayoutParams r11 = (RelativeLayout.LayoutParams) this.f9969b.getLayoutParams();
        throw null;
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void unBind() {
    }

    public TitleView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public TitleView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f9971d = false;
        b();
    }
}
