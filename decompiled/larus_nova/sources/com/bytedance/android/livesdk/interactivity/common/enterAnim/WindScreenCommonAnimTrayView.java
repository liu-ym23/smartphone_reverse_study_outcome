package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class WindScreenCommonAnimTrayView extends BaseWindScreenAnimEnterTrayView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f136532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f136533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintLayout f136534d;

    public class a implements qb2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindScreenCommonAnimTrayView f136535a;

        @Override // qb2.e
        public final void a(ak6.g r100) {
        }

        public a(WindScreenCommonAnimTrayView r100) {
            this.f136535a = r100;
        }

        @Override // qb2.e
        public final void b(ak6.g r100) {
            this.f136535a.f136532b.setText(r100.f4074a);
            c r101 = this.f136535a.f136516a;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public WindScreenCommonAnimTrayView(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final void R5(k32.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        setTextContent(r100);
        setIcon(r100);
        setBackground(r100);
    }

    public void setBackground(k32.d r100) {
        Drawable r101 = this.f136534d.getBackground();
        h3 r102 = r100.f501712t;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getBackground() != null) goto L7;
        return;
    L7:
        if (r100.f501712t.getBackground().b() == null) goto L12;
        ((GradientDrawable) r101).setColor(com.bytedance.android.live.schema.helper.g.b(r100.f501712t.getBackground().b(), ColorProtector.parseColor("#99FAA14F")));
        return;
    }

    public void setIcon(k32.d r100) {
        h3 r101 = r100.f501712t;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.N() != null) goto L7;
        return;
    L7:
        if (r100.f501712t.N().isEmpty() == false) goto L9;
        return;
    L9:
        if (ListProtector.get(r100.f501712t.N(), 0) == null) goto L15;
        ImageUtil.loadImage(this.f136533c, (py.k) ListProtector.get(r100.f501712t.N(), 0), 0);
        return;
    }

    public void setTextContent(k32.d r100) {
        h3 r101 = r100.f501712t;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.M() != null) goto L7;
        return;
    L7:
        if (r100.f501712t.M().a() != null) goto L9;
    L31:
        a5 r102 = r100.f501712t.getText();
    L32:
        if (r102 == null) goto L42;
        com.bytedance.android.livesdk.interactivity.common.utils.d.a(r102);
        qb2.c.a(r102, new a(this));
        return;
    L42:
        return;
    L9:
        if (r100.f501713u == false) goto L31;
        String r103 = IESUIUtils.getDisplayCount(r100.f501712t.M().a().longValue(), "w");
        if (r100.f501712t.M().b() == null) goto L30;
        r102 = r100.f501712t.M().b();
        if (r102 == null) goto L32;
        if (r102.getPieces() == null) goto L32;
        if (r102.getPieces().isEmpty() == true) goto L32;
        int r104 = 0;
    L21:
        if (r104 >= r102.getPieces().size()) goto L32;
        if (ListProtector.get(r102.getPieces(), r104) == null) goto L29;
        if (((c5) ListProtector.get(r102.getPieces(), r104)).getStringValue() == null) goto L29;
        if (((c5) ListProtector.get(r102.getPieces(), r104)).getStringValue().contains("$aggregate_num_sum") == false) goto L29;
        ((c5) ListProtector.get(r102.getPieces(), r104)).setStringValue(((c5) ListProtector.get(r102.getPieces(), r104)).getStringValue().replace("$aggregate_num_sum", r103));
    L29:
        r104 = r104 + 1;
        goto L21
    L30:
        r102 = null;
        goto L32
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public void setTextSize(float r100) {
        this.f136532b.setTextSize(0, r100);
    }

    public void setIcon(Bitmap r100) {
        this.f136533c.setImageBitmap(r100);
        this.f136516a.c();
    }

    public WindScreenCommonAnimTrayView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final void U5(int r100, int r101) {
        ViewGroup.LayoutParams r102 = this.f136533c.getLayoutParams();
        r102.width = r100;
        r102.height = r101;
        this.f136533c.setLayoutParams(r102);
    }

    public WindScreenCommonAnimTrayView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        ViewGroup.inflate(getContext(), R.layout.ttlive_wind_screen_common_tray_view, this);
        this.f136532b = (TextView) findViewById(R.id.wind_screen_common_tray_text_content);
        this.f136533c = (HSImageView) findViewById(R.id.wind_screen_common_tray_icon);
        this.f136534d = (ConstraintLayout) findViewById(R.id.buy_ticket_tray_container);
    }
}
