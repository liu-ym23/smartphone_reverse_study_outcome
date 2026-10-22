package com.bytedanceos.common.tangram.view;

import a9.b;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.p;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.tangram.Bind;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.util.ImageUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationView extends LinearLayout implements Bind<Topic> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NetworkImageView f9955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f9956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f9957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9959e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseCell f9960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NavigationView f9961b;

        public a(NavigationView r10, BaseCell r11) {
            this.f9961b = r10;
            this.f9960a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9961b.getLeft() >= 0) goto L6;
            return;
        L6:
            if (this.f9961b.getLeft() != 0) goto L8;
        L9:
            AdsReportManager.h().m(this.f9960a);
            return;
        L8:
            if (this.f9961b.getLeft() < this.f9961b.getResources().getDisplayMetrics().widthPixels) goto L9;
        }
    }

    static {
        z8.a.a(8, new int[]{220});
    }

    public NavigationView(Context r10) {
        this(r10, null);
    }

    private void b() {
        setOrientation(1);
        NetworkImageView r10 = new NetworkImageView(getContext());
        this.f9955a = r10;
        r10.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f9955a);
        TextView r11 = new TextView(getContext());
        this.f9956b = r11;
        r11.setSingleLine();
        this.f9956b.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f9956b.setGravity(17);
        addView(this.f9956b, new ViewGroup.LayoutParams(-2, -2));
        c();
    }

    public void a(Topic r10, BaseCell r11) {
        this.f9956b.setText(r10.getTitle());
        if (this.f9958d == false) goto L5;
        this.f9957c.setText(r10.getSubTitle());
        this.f9957c.setVisibility(0);
    L8:
        this.f9955a.setRoundRX(10.0f);
        if ((this instanceof SecondBarItemView) == true) goto L11;
        ImageUtils.doLoadImageUrl(this.f9955a, r10.getImageResUrl());
    L11:
        r11.setOnClickListener(this, this.f9959e);
        setTag(r10);
        post(new a(this, r11));
        return;
    L5:
        TextView r12 = this.f9957c;
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
        p.a(r10);
        setGravity(1);
        d(null);
        f(null);
        e(null);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    public void c() {
        this.f9959e = 220;
    }

    public void d(b r10) {
    }

    public final void e(b r10) {
        throw null;
    }

    public void f(b r10) {
        this.f9956b.setTextSize(2, 11.0f);
        this.f9956b.setTextColor(getContext().getColor(R$color.oui_text_3));
        throw null;
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void unBind() {
        this.f9955a.setImageDrawable(null);
    }

    public NavigationView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public NavigationView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f9958d = false;
        b();
    }
}
