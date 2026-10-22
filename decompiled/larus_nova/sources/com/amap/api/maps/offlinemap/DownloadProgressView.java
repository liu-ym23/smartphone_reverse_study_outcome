package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class DownloadProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f28700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f28701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f28702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextPaint f28703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextPaint f28704g;

    public DownloadProgressView(Context r100) {
        super(r100);
        this.f28699b = -65536;
        this.f28700c = -65536;
        this.f28701d = 0.0f;
        this.f28702e = 0.6f;
        a(null, 0);
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = getPaddingLeft();
        int r101 = getPaddingTop();
        int r102 = getPaddingRight();
        int r103 = getPaddingBottom();
        int r104 = (getWidth() - r100) - r102;
        int r105 = (getHeight() - r101) - r103;
        double r106 = r105 * 0.8f;
        float r107 = r104;
        String r108 = String.valueOf((int) (this.f28702e * 100.0f)) + GXTemplateKey.GAIAX_PE;
        r110.drawRect(new Rect(0, (int) r106, (int) (r107 * this.f28702e), r105), this.f28704g);
        r110.drawText(r108, (int) (this.f28702e * r107), (int) (r106 - 3.0d), this.f28703f);
    }

    public void setProgress(int r100) {
        if (r100 > 100) goto L8;
        if (r100 < 0) goto L9;
        this.f28702e = r100 / 100.0f;
        invalidate();
        return;
    L9:
        return;
    }

    public DownloadProgressView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f28699b = -65536;
        this.f28700c = -65536;
        this.f28701d = 0.0f;
        this.f28702e = 0.6f;
        a(r101, 0);
    }

    private void a(AttributeSet r100, int r101) {
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.anim.ab_microapp_i_slide_in_right, R.anim.ab_microapp_i_slide_out_right, R.anim.abc_fade_in, R.anim.abc_fade_out}, r101, 0);
        this.f28698a = r102.getString(0);
        this.f28699b = r102.getColor(3, this.f28699b);
        this.f28701d = r102.getDimension(1, this.f28701d);
        this.f28700c = r102.getColor(2, this.f28700c);
        r102.recycle();
        TextPaint r103 = new TextPaint();
        this.f28703f = r103;
        r103.setFlags(1);
        this.f28703f.setTextAlign(Paint.Align.RIGHT);
        TextPaint r104 = new TextPaint();
        this.f28704g = r104;
        r104.setStyle(Paint.Style.FILL);
        this.f28703f.setTextSize(this.f28701d);
        this.f28703f.setColor(this.f28699b);
        this.f28704g.setColor(this.f28700c);
        this.f28703f.measureText(this.f28698a);
        float r105 = this.f28703f.getFontMetrics().bottom;
    }

    public DownloadProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f28699b = -65536;
        this.f28700c = -65536;
        this.f28701d = 0.0f;
        this.f28702e = 0.6f;
        a(r101, r102);
    }
}
