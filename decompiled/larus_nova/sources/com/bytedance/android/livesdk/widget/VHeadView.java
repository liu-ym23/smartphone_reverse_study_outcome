package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class VHeadView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f161367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f161368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f161369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f161370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f161371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f161372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f161373g;

    public VHeadView(Context r100) {
        super(r100);
        this.f161369c = Boolean.FALSE;
        this.f161372f = false;
        this.f161373g = new Paint();
        init(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.f161369c.booleanValue() == false) goto L5;
    L7:
        int r101 = getWidth();
        int r102 = getHeight();
        int r103 = Math.min(r101, r102);
        if (this.f161369c.booleanValue() == false) goto L22;
        if (this.f161368b != null) goto L14;
        Bitmap r104 = BitmapFactory.decodeResource(getResources(), this.f161367a);
        if (r104 == null) goto L14;
        this.f161368b = r104;
    L14:
        Bitmap r105 = this.f161368b;
        if (r105 == null) goto L22;
        int r106 = (r103 - r105.getWidth()) + 0;
        int r107 = r103 - this.f161368b.getHeight();
        if (r101 <= r102) goto L19;
        r106 = r106 + ((r101 - r102) / 2);
    L20:
        r100.drawBitmap(this.f161368b, r106, r107, this.f161373g);
        goto L22
    L19:
        r107 = r107 + ((r102 - r101) / 2);
    L22:
        if (this.f161372f == true) goto L24;
        return;
    L24:
        if (this.f161371e != null) goto L28;
        Bitmap r108 = BitmapFactory.decodeResource(getResources(), this.f161370d);
        if (r108 == null) goto L28;
        this.f161371e = r108;
    L28:
        Bitmap r109 = this.f161371e;
        if (r109 == null) goto L33;
        r100.drawBitmap(r109, (r103 - r109.getWidth()) / 2, r103 - this.f161371e.getHeight(), this.f161373g);
        return;
    L33:
        return;
    L5:
        if (this.f161372f == true) goto L7;
    }

    public void setAuthor(boolean r100) {
        if (this.f161372f != r100) goto L5;
        return;
    L5:
        this.f161372f = r100;
        invalidate();
    }

    public void setVAble(boolean r100) {
        if (this.f161369c.booleanValue() != r100) goto L5;
        return;
    L5:
        this.f161369c = Boolean.valueOf(r100);
        invalidate();
    }

    public void setVResId(int r100) {
        if (this.f161367a != r100) goto L5;
        return;
    L5:
        this.f161367a = r100;
        this.f161368b = null;
        invalidate();
    }

    public VHeadView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f161369c = Boolean.FALSE;
        this.f161372f = false;
        this.f161373g = new Paint();
        init(r100, r101);
    }

    public final void init(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.author_src, R.attr.v_able, R.attr.v_src});
        this.f161367a = r102.getResourceId(2, R.drawable.ttlive_icon_v_hotsoon);
        this.f161369c = Boolean.valueOf(r102.getBoolean(1, false));
        this.f161370d = r102.getResourceId(0, R.drawable.ttlive_api_img_writer_regular);
        r102.recycle();
    }

    public VHeadView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f161369c = Boolean.FALSE;
        this.f161372f = false;
        this.f161373g = new Paint();
        init(r100, r101);
    }
}
