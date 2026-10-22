package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.larus.nova.R;
import f0.c;

/* JADX INFO: loaded from: classes28.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long[] f24312g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cn.bingoogolapple.qrcode.core.a f24313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f24314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f24315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BarcodeType f24316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f24317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f24318f;

    public interface a {
    }

    static {
        f24312g = new long[]{255, 255, 255, 255};
    }

    public abstract void b();

    public void setDelegate(a r100) {
    }

    public boolean getIsScanBarcodeStyle() {
        return this.f24314b.getIsBarcode();
    }

    public cn.bingoogolapple.qrcode.core.a getCameraPreview() {
        return this.f24313a;
    }

    public c getScanBoxView() {
        return this.f24314b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
    }

    public QRCodeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(byte[] r110, Camera r111) {
        cn.bingoogolapple.qrcode.core.a r100 = this.f24313a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.c() == false) goto L29;
        long r101 = System.currentTimeMillis();
        if ((r101 - this.f24317e) >= 150) goto L10;
        return;
    L10:
        this.f24317e = r101;
        long r102 = r111.getParameters().getPreviewSize().width * r111.getParameters().getPreviewSize().height;
        if (Math.abs(r110.length - (r102 * 1.5f)) >= 1.0E-5f) goto L28;
        int r112 = 0;
        long r103 = 0;
        int r104 = 0;
    L14:
        if (r104 >= r102) goto L16;
        r103 = r103 + (((long) r110[r104]) & 255);
        r104 = r104 + 10;
        goto L14
    L16:
        long r105 = r103 / (r102 / ((long) 10));
        long[] r113 = f24312g;
        int r106 = this.f24318f % 4;
        r113[r106] = r105;
        this.f24318f = r106 + 1;
    L17:
        if (r112 >= 4) goto L23;
        if (r113[r112] > 60) goto L23;
        r112 = r112 + 1;
    L23:
        return;
    L28:
        return;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public final void onPreviewFrame(byte[] r100, Camera r101) {
        cn.bingoogolapple.qrcode.core.a r102 = this.f24313a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.c() == false) goto L14;
        a(r100, r101);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public QRCodeView(Context r100, AttributeSet r101, int r110) {
        super(r100, r101, r110);
        this.f24316d = BarcodeType.HIGH_FREQUENCY;
        this.f24317e = System.currentTimeMillis();
        int r111 = 0;
        this.f24318f = 0;
        cn.bingoogolapple.qrcode.core.a r102 = new cn.bingoogolapple.qrcode.core.a(r100);
        this.f24313a = r102;
        r102.setDelegate(new b(this));
        c r103 = new c(r100);
        this.f24314b = r103;
        r103.V0 = this;
        TypedArray r104 = r103.getContext().obtainStyledAttributes(r101, new int[]{R.attr.qrcv_animTime, R.attr.qrcv_barCodeTipText, R.attr.qrcv_barcodeRectHeight, R.attr.qrcv_borderColor, R.attr.qrcv_borderSize, R.attr.qrcv_cornerColor, R.attr.qrcv_cornerDisplayType, R.attr.qrcv_cornerLength, R.attr.qrcv_cornerSize, R.attr.qrcv_customGridScanLineDrawable, R.attr.qrcv_customScanLineDrawable, R.attr.qrcv_isAutoZoom, R.attr.qrcv_isBarcode, R.attr.qrcv_isCenterVertical, R.attr.qrcv_isOnlyDecodeScanBoxArea, R.attr.qrcv_isScanLineReverse, R.attr.qrcv_isShowDefaultGridScanLineDrawable, R.attr.qrcv_isShowDefaultScanLineDrawable, R.attr.qrcv_isShowLocationPoint, R.attr.qrcv_isShowTipBackground, R.attr.qrcv_isShowTipTextAsSingleLine, R.attr.qrcv_isTipTextBelowRect, R.attr.qrcv_maskColor, R.attr.qrcv_qrCodeTipText, R.attr.qrcv_rectWidth, R.attr.qrcv_scanLineColor, R.attr.qrcv_scanLineMargin, R.attr.qrcv_scanLineSize, R.attr.qrcv_tipBackgroundColor, R.attr.qrcv_tipTextColor, R.attr.qrcv_tipTextMargin, R.attr.qrcv_tipTextSize, R.attr.qrcv_toolbarHeight, R.attr.qrcv_topOffset, R.attr.qrcv_verticalBias});
        int r105 = r104.getIndexCount();
    L4:
        if (r111 >= r105) goto L105;
        int r106 = r104.getIndex(r111);
        if (r106 != 33) goto L8;
        r103.f474932o = r104.getDimensionPixelSize(r106, r103.f474932o);
    L104:
        r111 = r111 + 1;
        goto L4
    L8:
        if (r106 != 8) goto L11;
        r103.f474927k = r104.getDimensionPixelSize(r106, r103.f474927k);
        goto L104
    L11:
        if (r106 != 7) goto L14;
        r103.f474926j = r104.getDimensionPixelSize(r106, r103.f474926j);
        goto L104
    L14:
        if (r106 != 27) goto L17;
        r103.f474933p = r104.getDimensionPixelSize(r106, r103.f474933p);
        goto L104
    L17:
        if (r106 != 24) goto L20;
        r103.f474929l = r104.getDimensionPixelSize(r106, r103.f474929l);
        goto L104
    L20:
        if (r106 != 22) goto L23;
        r103.f474924h = r104.getColor(r106, r103.f474924h);
        goto L104
    L23:
        if (r106 != 5) goto L26;
        r103.f474925i = r104.getColor(r106, r103.f474925i);
        goto L104
    L26:
        if (r106 != 25) goto L29;
        r103.f474935q = r104.getColor(r106, r103.f474935q);
        goto L104
    L29:
        if (r106 != 26) goto L32;
        r103.f474936r = r104.getDimensionPixelSize(r106, r103.f474936r);
        goto L104
    L32:
        if (r106 != 17) goto L35;
        r103.f474937s = r104.getBoolean(r106, r103.f474937s);
        goto L104
    L35:
        if (r106 != 10) goto L38;
        r103.f474938t = r104.getDrawable(r106);
        goto L104
    L38:
        if (r106 != 4) goto L41;
        r103.f474940v = r104.getDimensionPixelSize(r106, r103.f474940v);
        goto L104
    L41:
        if (r106 != 3) goto L43;
        r103.f474941w = r104.getColor(r106, r103.f474941w);
        goto L104
    L43:
        if (r106 != 0) goto L46;
        r103.f474942x = r104.getInteger(r106, r103.f474942x);
        goto L104
    L46:
        if (r106 != 34) goto L48;
        r103.f474943y = r104.getFloat(r106, r103.f474943y);
        goto L104
    L48:
        if (r106 != 6) goto L51;
        r103.f474944z = r104.getInteger(r106, r103.f474944z);
        goto L104
    L51:
        if (r106 != 32) goto L54;
        r103.A = r104.getDimensionPixelSize(r106, r103.A);
        goto L104
    L54:
        if (r106 != 2) goto L57;
        r103.f474931n = r104.getDimensionPixelSize(r106, r103.f474931n);
        goto L104
    L57:
        if (r106 != 12) goto L60;
        r103.B = r104.getBoolean(r106, r103.B);
        goto L104
    L60:
        if (r106 != 1) goto L63;
        r103.D = r104.getString(r106);
        goto L104
    L63:
        if (r106 != 23) goto L66;
        r103.C = r104.getString(r106);
        goto L104
    L66:
        if (r106 != 31) goto L69;
        r103.F = r104.getDimensionPixelSize(r106, r103.F);
        goto L104
    L69:
        if (r106 != 29) goto L72;
        r103.G = r104.getColor(r106, r103.G);
        goto L104
    L72:
        if (r106 != 21) goto L75;
        r103.H = r104.getBoolean(r106, r103.H);
        goto L104
    L75:
        if (r106 != 30) goto L78;
        r103.I = r104.getDimensionPixelSize(r106, r103.I);
        goto L104
    L78:
        if (r106 != 20) goto L81;
        r103.f474916J = r104.getBoolean(r106, r103.f474916J);
        goto L104
    L81:
        if (r106 != 19) goto L84;
        r103.L = r104.getBoolean(r106, r103.L);
        goto L104
    L84:
        if (r106 != 28) goto L87;
        r103.K = r104.getColor(r106, r103.K);
        goto L104
    L87:
        if (r106 != 15) goto L90;
        r103.M = r104.getBoolean(r106, r103.M);
        goto L104
    L90:
        if (r106 != 16) goto L93;
        r103.N = r104.getBoolean(r106, r103.N);
        goto L104
    L93:
        if (r106 != 9) goto L96;
        r103.O = r104.getDrawable(r106);
        goto L104
    L96:
        if (r106 != 14) goto L99;
        r103.H0 = r104.getBoolean(r106, r103.H0);
        goto L104
    L99:
        if (r106 != 18) goto L102;
        r103.L0 = r104.getBoolean(r106, r103.L0);
        goto L104
    L102:
        if (r106 != 11) goto L104;
        r103.P0 = r104.getBoolean(r106, r103.P0);
        goto L104
    L105:
        r104.recycle();
        Drawable r112 = r103.O;
        if (r112 == null) goto L109;
        r103.U = ((BitmapDrawable) r112).getBitmap();
    L109:
        if (r103.U != null) goto L111;
        Bitmap r113 = BitmapFactory.decodeResource(r103.getResources(), R.mipmap.qrcode_default_grid_scan_line);
        r103.U = r113;
        r103.U = f0.a.g(r113, r103.f474935q);
    L111:
        Bitmap r114 = f0.a.a(r103.U);
        r103.V = r114;
        Bitmap r115 = f0.a.a(r114);
        r103.V = r115;
        r103.V = f0.a.a(r115);
        Drawable r116 = r103.f474938t;
        if (r116 == null) goto L115;
        r103.S = ((BitmapDrawable) r116).getBitmap();
    L115:
        if (r103.S != null) goto L117;
        Bitmap r117 = BitmapFactory.decodeResource(r103.getResources(), R.mipmap.qrcode_default_scan_line);
        r103.S = r117;
        r103.S = f0.a.g(r117, r103.f474935q);
    L117:
        r103.T = f0.a.a(r103.S);
        r103.f474932o += r103.A;
        r103.W = (r103.f474927k * 1.0f) / 2.0f;
        r103.f474923g.setTextSize(r103.F);
        r103.f474923g.setColor(r103.G);
        r103.setIsBarcode(r103.B);
        this.f24313a.setId(R.id.bgaqrcode_camera_preview);
        addView(this.f24313a);
        RelativeLayout.LayoutParams r118 = new RelativeLayout.LayoutParams(r100, r101);
        r118.addRule(6, this.f24313a.getId());
        r118.addRule(8, this.f24313a.getId());
        addView(this.f24314b, r118);
        Paint r107 = new Paint();
        this.f24315c = r107;
        r107.setColor(getScanBoxView().getCornerColor());
        this.f24315c.setStyle(Paint.Style.FILL);
        b();
    }
}
