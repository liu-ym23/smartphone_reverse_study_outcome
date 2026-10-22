package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.AssetsLoadUtil;
import java.io.IOException;

/* loaded from: classes.dex */
public class y extends LinearLayout implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f8128a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f8129b;

    /* renamed from: c, reason: collision with root package name */
    private Context f8130c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f8131d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f8132e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f8133f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f8134g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f8135h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f8136i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f8137j;

    /* renamed from: k, reason: collision with root package name */
    private Bitmap f8138k;

    /* renamed from: l, reason: collision with root package name */
    private int f8139l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8140m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8141n;

    @Deprecated
    public y(Context context) throws IOException {
        super(context);
        this.f8140m = false;
        this.f8141n = false;
        this.f8130c = context;
        a();
        if (this.f8131d == null || this.f8132e == null || this.f8133f == null || this.f8134g == null) {
            return;
        }
        this.f8128a = new ImageView(this.f8130c);
        this.f8129b = new ImageView(this.f8130c);
        this.f8128a.setImageBitmap(this.f8131d);
        this.f8129b.setImageBitmap(this.f8133f);
        this.f8139l = a(this.f8133f.getHeight() / 6);
        a(this.f8128a, "main_topbtn_up.9.png");
        a(this.f8129b, "main_bottombtn_up.9.png");
        this.f8128a.setId(0);
        this.f8129b.setId(1);
        this.f8128a.setClickable(true);
        this.f8129b.setClickable(true);
        this.f8128a.setOnTouchListener(this);
        this.f8129b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f8128a);
        addView(this.f8129b);
        this.f8141n = true;
    }

    private void a() {
        this.f8131d = a("main_icon_zoomin.png");
        this.f8132e = a("main_icon_zoomin_dis.png");
        this.f8133f = a("main_icon_zoomout.png");
        this.f8134g = a("main_icon_zoomout_dis.png");
    }

    private void b() {
        this.f8135h = a("wear_zoom_in.png");
        this.f8136i = a("wear_zoom_in_pressed.png");
        this.f8137j = a("wear_zoon_out.png");
        this.f8138k = a("wear_zoom_out_pressed.png");
    }

    public boolean c() {
        return this.f8141n;
    }

    public void d() {
        Bitmap bitmap = this.f8131d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f8131d.recycle();
            this.f8131d = null;
        }
        Bitmap bitmap2 = this.f8132e;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f8132e.recycle();
            this.f8132e = null;
        }
        Bitmap bitmap3 = this.f8133f;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.f8133f.recycle();
            this.f8133f = null;
        }
        Bitmap bitmap4 = this.f8134g;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            this.f8134g.recycle();
            this.f8134g = null;
        }
        Bitmap bitmap5 = this.f8135h;
        if (bitmap5 != null && !bitmap5.isRecycled()) {
            this.f8135h.recycle();
            this.f8135h = null;
        }
        Bitmap bitmap6 = this.f8136i;
        if (bitmap6 != null && !bitmap6.isRecycled()) {
            this.f8136i.recycle();
            this.f8136i = null;
        }
        Bitmap bitmap7 = this.f8137j;
        if (bitmap7 != null && !bitmap7.isRecycled()) {
            this.f8137j.recycle();
            this.f8137j = null;
        }
        Bitmap bitmap8 = this.f8138k;
        if (bitmap8 == null || bitmap8.isRecycled()) {
            return;
        }
        this.f8138k.recycle();
        this.f8138k = null;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) throws IOException {
        if (!(view instanceof ImageView)) {
            return false;
        }
        int id = ((ImageView) view).getId();
        if (id == 0) {
            if (motionEvent.getAction() == 0) {
                if (this.f8140m) {
                    this.f8128a.setImageBitmap(this.f8136i);
                    return false;
                }
                a(this.f8128a, "main_topbtn_down.9.png");
                return false;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            if (this.f8140m) {
                this.f8128a.setImageBitmap(this.f8135h);
                return false;
            }
            a(this.f8128a, "main_topbtn_up.9.png");
            return false;
        }
        if (id != 1) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            if (this.f8140m) {
                this.f8129b.setImageBitmap(this.f8138k);
                return false;
            }
            a(this.f8129b, "main_bottombtn_down.9.png");
            return false;
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        if (this.f8140m) {
            this.f8129b.setImageBitmap(this.f8137j);
            return false;
        }
        a(this.f8129b, "main_bottombtn_up.9.png");
        return false;
    }

    public void setIsZoomInEnabled(boolean z4) {
        ImageView imageView = this.f8128a;
        if (imageView == null) {
            return;
        }
        imageView.setEnabled(z4);
        if (z4) {
            this.f8128a.setImageBitmap(this.f8131d);
        } else {
            this.f8128a.setImageBitmap(this.f8132e);
        }
    }

    public void setIsZoomOutEnabled(boolean z4) {
        ImageView imageView = this.f8129b;
        if (imageView == null) {
            return;
        }
        imageView.setEnabled(z4);
        if (z4) {
            this.f8129b.setImageBitmap(this.f8133f);
        } else {
            this.f8129b.setImageBitmap(this.f8134g);
        }
    }

    public void setOnZoomInClickListener(View.OnClickListener onClickListener) {
        this.f8128a.setOnClickListener(onClickListener);
    }

    public void setOnZoomOutClickListener(View.OnClickListener onClickListener) {
        this.f8129b.setOnClickListener(onClickListener);
    }

    private void a(View view, String str) throws IOException {
        Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile(str, this.f8130c);
        byte[] ninePatchChunk = bitmapLoadAssetsFile.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        view.setBackgroundDrawable(new NinePatchDrawable(bitmapLoadAssetsFile, ninePatchChunk, new Rect(), null));
        int i4 = this.f8139l;
        view.setPadding(i4, i4, i4, i4);
    }

    private Bitmap a(String str) throws IOException {
        Matrix matrix = new Matrix();
        int densityDpi = SysOSUtil.getDensityDpi();
        if (densityDpi > 480) {
            matrix.postScale(1.8f, 1.8f);
        } else if (densityDpi > 320 && densityDpi <= 480) {
            matrix.postScale(1.5f, 1.5f);
        } else {
            matrix.postScale(1.2f, 1.2f);
        }
        Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile(str, this.f8130c);
        if (bitmapLoadAssetsFile == null) {
            return null;
        }
        return Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix, true);
    }

    private int a(int i4) {
        return (int) ((this.f8130c.getResources().getDisplayMetrics().density * i4) + 0.5f);
    }

    public y(Context context, boolean z4) throws IOException {
        super(context);
        this.f8141n = false;
        this.f8130c = context;
        this.f8140m = z4;
        this.f8128a = new ImageView(this.f8130c);
        this.f8129b = new ImageView(this.f8130c);
        if (z4) {
            b();
            if (this.f8135h == null || this.f8136i == null || this.f8137j == null || this.f8138k == null) {
                return;
            }
            this.f8128a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f8129b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f8128a.setImageBitmap(this.f8135h);
            this.f8129b.setImageBitmap(this.f8137j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            a();
            Bitmap bitmap = this.f8131d;
            if (bitmap == null || this.f8132e == null || this.f8133f == null || this.f8134g == null) {
                return;
            }
            this.f8128a.setImageBitmap(bitmap);
            this.f8129b.setImageBitmap(this.f8133f);
            this.f8139l = a(this.f8133f.getHeight() / 6);
            a(this.f8128a, "main_topbtn_up.9.png");
            a(this.f8129b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.f8128a.setId(0);
        this.f8129b.setId(1);
        this.f8128a.setClickable(true);
        this.f8129b.setClickable(true);
        this.f8128a.setOnTouchListener(this);
        this.f8129b.setOnTouchListener(this);
        addView(this.f8128a);
        addView(this.f8129b);
        this.f8141n = true;
    }
}
