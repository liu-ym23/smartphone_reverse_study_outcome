package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.AssetsLoadUtil;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes39.dex */
public class y extends LinearLayout implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f32229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f32230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f32231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f32232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bitmap f32233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bitmap f32234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f32235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Bitmap f32236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Bitmap f32237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Bitmap f32238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Bitmap f32239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f32240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f32241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f32242n;

    private void a() {
        this.f32232d = a("main_icon_zoomin.png");
        this.f32233e = a("main_icon_zoomin_dis.png");
        this.f32234f = a("main_icon_zoomout.png");
        this.f32235g = a("main_icon_zoomout_dis.png");
    }

    public void d() {
        Bitmap r100 = this.f32232d;
        if (r100 != null) goto L5;
    L7:
        Bitmap r101 = this.f32233e;
        if (r101 != null) goto L10;
    L12:
        Bitmap r102 = this.f32234f;
        if (r102 != null) goto L15;
    L17:
        Bitmap r103 = this.f32235g;
        if (r103 != null) goto L20;
    L22:
        Bitmap r104 = this.f32236h;
        if (r104 != null) goto L25;
    L27:
        Bitmap r105 = this.f32237i;
        if (r105 != null) goto L30;
    L32:
        Bitmap r106 = this.f32238j;
        if (r106 != null) goto L35;
    L37:
        Bitmap r107 = this.f32239k;
        if (r107 != null) goto L40;
        return;
    L40:
        if (r107.isRecycled() == true) goto L44;
        this.f32239k.recycle();
        this.f32239k = null;
        return;
    L44:
        return;
    L35:
        if (r106.isRecycled() == true) goto L37;
        this.f32238j.recycle();
        this.f32238j = null;
        goto L37
    L30:
        if (r105.isRecycled() == true) goto L32;
        this.f32237i.recycle();
        this.f32237i = null;
        goto L32
    L25:
        if (r104.isRecycled() == true) goto L27;
        this.f32236h.recycle();
        this.f32236h = null;
        goto L27
    L20:
        if (r103.isRecycled() == true) goto L22;
        this.f32235g.recycle();
        this.f32235g = null;
        goto L22
    L15:
        if (r102.isRecycled() == true) goto L17;
        this.f32234f.recycle();
        this.f32234f = null;
        goto L17
    L10:
        if (r101.isRecycled() == true) goto L12;
        this.f32233e.recycle();
        this.f32233e = null;
        goto L12
    L5:
        if (r100.isRecycled() == true) goto L7;
        this.f32232d.recycle();
        this.f32232d = null;
        goto L7
    }

    private void b() {
        this.f32236h = a("wear_zoom_in.png");
        this.f32237i = a("wear_zoom_in_pressed.png");
        this.f32238j = a("wear_zoon_out.png");
        this.f32239k = a("wear_zoom_out_pressed.png");
    }

    public boolean c() {
        return this.f32242n;
    }

    public y(Context r100) {
        super(r100);
        this.f32241m = false;
        this.f32242n = false;
        this.f32231c = r100;
        a();
        if (this.f32232d != null) goto L5;
        return;
    L5:
        if (this.f32233e != null) goto L7;
        return;
    L7:
        if (this.f32234f != null) goto L9;
        return;
    L9:
        if (this.f32235g == null) goto L16;
        this.f32229a = new ImageView(this.f32231c);
        this.f32230b = new ImageView(this.f32231c);
        this.f32229a.setImageBitmap(this.f32232d);
        this.f32230b.setImageBitmap(this.f32234f);
        this.f32240l = a(this.f32234f.getHeight() / 6);
        a(this.f32229a, "main_topbtn_up.9.png");
        a(this.f32230b, "main_bottombtn_up.9.png");
        this.f32229a.setTag("BMap_ZoomIn");
        this.f32230b.setTag("BMap_ZoomOut");
        this.f32229a.setClickable(true);
        this.f32230b.setClickable(true);
        this.f32229a.setOnTouchListener(this);
        this.f32230b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f32229a);
        addView(this.f32230b);
        this.f32242n = true;
        return;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_baidu_mapsdkplatform_comapi_map_y_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private Bitmap a(String r100) {
        Matrix r101 = new Matrix();
        int r102 = SysOSUtil.getDensityDpi();
        if (r102 <= 480) goto L6;
        r101.postScale(1.8f, 1.8f);
    L10:
        Bitmap r103 = AssetsLoadUtil.loadAssetsFile(r100, this.f32231c);
        if (r103 != null) goto L15;
        return null;
    L15:
        return Bitmap.createBitmap(r103, 0, 0, r103.getWidth(), r103.getHeight(), r101, true);
    L6:
        if (r102 <= 320) goto L9;
        if (r102 > 480) goto L9;
        r101.postScale(1.5f, 1.5f);
    L9:
        r101.postScale(1.2f, 1.2f);
        goto L10
    }

    public void setIsZoomInEnabled(boolean r100) {
        ImageView r101 = this.f32229a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setEnabled(r100);
        if (r100 == true) goto L8;
        this.f32229a.setImageBitmap(this.f32233e);
        return;
    L8:
        this.f32229a.setImageBitmap(this.f32232d);
    }

    public void setIsZoomOutEnabled(boolean r100) {
        ImageView r101 = this.f32230b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setEnabled(r100);
        if (r100 == true) goto L8;
        this.f32230b.setImageBitmap(this.f32235g);
        return;
    L8:
        this.f32230b.setImageBitmap(this.f32234f);
    }

    public void setOnZoomInClickListener(View.OnClickListener r100) {
        this.f32229a.setOnClickListener(r100);
    }

    public void setOnZoomOutClickListener(View.OnClickListener r100) {
        this.f32230b.setOnClickListener(r100);
    }

    private int a(int r100) {
        return (int) ((INVOKEVIRTUAL_com_baidu_mapsdkplatform_comapi_map_y_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.f32231c.getResources()).density * r100) + 0.5f);
    }

    public y(Context r100, boolean r101) {
        super(r100);
        this.f32242n = false;
        this.f32231c = r100;
        this.f32241m = r101;
        this.f32229a = new ImageView(this.f32231c);
        this.f32230b = new ImageView(this.f32231c);
        if (r101 == false) goto L15;
        b();
        if (this.f32236h != null) goto L7;
        return;
    L7:
        if (this.f32237i != null) goto L9;
        return;
    L9:
        if (this.f32238j != null) goto L11;
        return;
    L11:
        if (this.f32239k == null) goto L29;
        this.f32229a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f32230b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f32229a.setImageBitmap(this.f32236h);
        this.f32230b.setImageBitmap(this.f32238j);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(0);
    L25:
        this.f32229a.setTag("BMap_ZoomIn");
        this.f32230b.setTag("BMap_ZoomOut");
        this.f32229a.setClickable(true);
        this.f32230b.setClickable(true);
        this.f32229a.setOnTouchListener(this);
        this.f32230b.setOnTouchListener(this);
        addView(this.f32229a);
        addView(this.f32230b);
        this.f32242n = true;
        return;
    L29:
        return;
    L15:
        a();
        Bitmap r102 = this.f32232d;
        if (r102 != null) goto L18;
        return;
    L18:
        if (this.f32233e != null) goto L20;
        return;
    L20:
        if (this.f32234f != null) goto L22;
        return;
    L22:
        if (this.f32235g == null) goto L33;
        this.f32229a.setImageBitmap(r102);
        this.f32230b.setImageBitmap(this.f32234f);
        this.f32240l = a(this.f32234f.getHeight() / 6);
        a(this.f32229a, "main_topbtn_up.9.png");
        a(this.f32230b, "main_bottombtn_up.9.png");
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(1);
        goto L25
    }

    private void a(View r100, String r101) {
        Bitmap r102 = AssetsLoadUtil.loadAssetsFile(r101, this.f32231c);
        byte[] r103 = r102.getNinePatchChunk();
        NinePatch.isNinePatchChunk(r103);
        r100.setBackgroundDrawable(new NinePatchDrawable(r102, r103, new Rect(), null));
        int r104 = this.f32240l;
        r100.setPadding(r104, r104, r104, r104);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r100, MotionEvent r101) {
        if ((r100 instanceof ImageView) == false) goto L35;
        String r102 = (String) ((ImageView) r100).getTag();
        r102.getClass();
        if (r102.equals("BMap_ZoomIn") == true) goto L22;
        if (r102.equals("BMap_ZoomOut") == true) goto L10;
        return false;
    L10:
        if (r101.getAction() != 0) goto L16;
        if (this.f32241m == true) goto L14;
        a(this.f32230b, "main_bottombtn_down.9.png");
        return false;
    L14:
        this.f32230b.setImageBitmap(this.f32239k);
        return false;
    L16:
        if (r101.getAction() == 1) goto L18;
        return false;
    L18:
        if (this.f32241m == true) goto L20;
        a(this.f32230b, "main_bottombtn_up.9.png");
        return false;
    L20:
        this.f32230b.setImageBitmap(this.f32238j);
        return false;
    L22:
        if (r101.getAction() != 0) goto L28;
        if (this.f32241m == true) goto L26;
        a(this.f32229a, "main_topbtn_down.9.png");
        return false;
    L26:
        this.f32229a.setImageBitmap(this.f32237i);
        return false;
    L28:
        if (r101.getAction() == 1) goto L30;
        return false;
    L30:
        if (this.f32241m == true) goto L32;
        a(this.f32229a, "main_topbtn_up.9.png");
        return false;
    L32:
        this.f32229a.setImageBitmap(this.f32236h);
        return false;
    L35:
        return false;
    }
}
