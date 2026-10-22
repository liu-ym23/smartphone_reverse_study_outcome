package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public final class a extends SurfaceView implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Camera f24319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f24323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f0.b f24324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f24325g;

    /* JADX INFO: renamed from: cn.bingoogolapple.qrcode.core.a$a, reason: collision with other inner class name */
    public class C0466a implements Camera.AutoFocusCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f24326a;

        public C0466a(a r100) {
            this.f24326a = r100;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public final void onAutoFocus(boolean r100, Camera r101) {
            this.f24326a.e();
        }
    }

    public interface b {
    }

    public final void e() {
        this.f24322d = false;
        Camera r100 = this.f24319a;
        if (r100 != null) goto L8;
        return;
    L8:
        Camera.Parameters r101 = r100.getParameters();     // Catch: Exception -> L7
        r101.setFocusMode("continuous-picture");     // Catch: Exception -> L7
        this.f24319a.setParameters(r101);     // Catch: Exception -> L7
        this.f24319a.cancelAutoFocus();     // Catch: Exception -> L7
        return;
    }

    public final boolean c() {
        if (this.f24319a != null) goto L5;
    L9:
        return false;
    L5:
        if (this.f24320b == false) goto L9;
        if (this.f24321c == false) goto L9;
        return true;
    }

    public final void d() {
        if (this.f24319a != null) goto L13;
        return;
    L13:
        this.f24320b = true;     // Catch: Exception -> L10
        SurfaceHolder r100 = getHolder();     // Catch: Exception -> L10
        r100.setKeepScreenOn(true);     // Catch: Exception -> L10
        this.f24319a.setPreviewDisplay(r100);     // Catch: Exception -> L10
        this.f24324f.a(this.f24319a);     // Catch: Exception -> L10
        this.f24319a.startPreview();     // Catch: Exception -> L10
        b r101 = this.f24325g;     // Catch: Exception -> L10
        if (r101 == null) goto L8;
        QRCodeView r102 = ((cn.bingoogolapple.qrcode.core.b) r101).f24327a;     // Catch: Exception -> L10
        long[] r103 = QRCodeView.f24312g;     // Catch: Exception -> L10
        r102.getClass();     // Catch: Exception -> L10
    L8:
        e();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public a(Context r100) {
        super(r100);
        this.f24320b = false;
        this.f24321c = false;
        this.f24322d = false;
        this.f24323e = 1.0f;
        getHolder().addCallback(this);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (c() == true) goto L7;
        return super.onTouchEvent(r100);
    L7:
        if (r100.getPointerCount() != 1) goto L18;
        if ((r100.getAction() & 255) != 1) goto L18;
        if (this.f24322d == false) goto L13;
        return true;
    L13:
        this.f24322d = true;
        float r101 = r100.getX();
        float r102 = r100.getY();
        if (f0.a.f(getContext()) == false) goto L16;
        r102 = r101;
        r101 = r102;
    L16:
        int r103 = f0.a.d(getContext(), 120.0f);
        a(r101, r102, r103, r103);
    L18:
        if (r100.getPointerCount() != 2) goto L31;
        int r104 = r100.getAction() & 255;
        if (r104 != 2) goto L22;
        float r105 = f0.a.b(r100);
        float r106 = this.f24323e;
        if (r105 <= r106) goto L29;
        b(true, this.f24319a);
        goto L31
    L29:
        if (r105 >= r106) goto L31;
        b(false, this.f24319a);
        goto L31
    L22:
        if (r104 != 5) goto L31;
        this.f24323e = f0.a.b(r100);
    L31:
        return true;
    }

    public void setCamera(Camera r110) {
        this.f24319a = r110;
        if (r110 == null) goto L36;
        Context r100 = getContext();
        f0.b r111 = new f0.b(r100);
        this.f24324f = r111;
        Camera r101 = this.f24319a;
        Point r102 = f0.a.e(r100);
        Point r103 = new Point();
        r103.x = r102.x;
        r103.y = r102.y;
        if (f0.a.f(r100) == false) goto L7;
        r103.x = r102.y;
        r103.y = r102.x;
    L7:
        Iterator<Camera.Size> r104 = r101.getParameters().getSupportedPreviewSizes().iterator();
        int r105 = 0;
        int r106 = 0;
        int r107 = Integer.MAX_VALUE;
    L9:
        if (r104.hasNext() == false) goto L15;
        Camera.Size r108 = r104.next();
        int r109 = r108.width;
        int r112 = r108.height;
        int r113 = Math.abs(r109 - r103.x) + Math.abs(r112 - r103.y);
        if (r113 == 0) goto L12;
        if (r113 >= r107) goto L9;
        r106 = r112;
        r105 = r109;
        r107 = r113;
        goto L9
    L12:
        r106 = r112;
        r105 = r109;
    L15:
        if (r105 <= 0) goto L18;
        if (r106 <= 0) goto L18;
        Point r114 = new Point(r105, r106);
    L19:
        if (r114 != null) goto L21;
        r114 = new Point((r103.x >> 3) << 3, (r103.y >> 3) << 3);
    L21:
        r111.f474915c = r114;
        if (f0.a.f(r111.f474913a) == false) goto L24;
        Point r115 = r111.f474915c;
        r111.f474914b = new Point(r115.y, r115.x);
    L26:
        if (this.f24320b == false) goto L28;
        requestLayout();
        return;
    L28:
        d();
        return;
    L24:
        r111.f474914b = r111.f474915c;
    L18:
        r114 = null;
        goto L19
    }

    public void setDelegate(b r100) {
        this.f24325g = r100;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        this.f24321c = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        this.f24321c = false;
        Camera r101 = this.f24319a;
        if (r101 == null) goto L11;
        this.f24320b = false;     // Catch: Exception -> L6
        r101.cancelAutoFocus();     // Catch: Exception -> L6
        this.f24319a.setOneShotPreviewCallback(null);     // Catch: Exception -> L6
        this.f24319a.stopPreview();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void b(boolean r100, Camera r101) {
        Camera.Parameters r102 = r101.getParameters();
        if (r102.isZoomSupported() == false) goto L14;
        int r103 = r102.getZoom();
        if (r100 == true) goto L7;
    L9:
        if (r100 == true) goto L12;
        if (r103 <= 0) goto L12;
        r103 = r103 - 1;
    L12:
        r102.setZoom(r103);
        r101.setParameters(r102);
        return;
    L7:
        if (r103 >= r102.getMaxZoom()) goto L9;
        r103 = r103 + 1;
        goto L12
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int r100, int r110) {
        int r101 = SurfaceView.getDefaultSize(getSuggestedMinimumWidth(), r100);
        int r111 = SurfaceView.getDefaultSize(getSuggestedMinimumHeight(), r110);
        f0.b r102 = this.f24324f;
        if (r102 == null) goto L10;
        Point r103 = r102.f474914b;
        if (r103 == null) goto L10;
        float r104 = r101;
        float r105 = r111;
        float r106 = (r104 * 1.0f) / r105;
        float r107 = r103.x;
        float r108 = r103.y;
        float r109 = (r107 * 1.0f) / r108;
        if (r106 >= r109) goto L9;
        r101 = (int) ((r105 / ((r108 * 1.0f) / r107)) + 0.5f);
        goto L10
    L9:
        r111 = (int) ((r104 / r109) + 0.5f);
    L10:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r101, 1073741824), View.MeasureSpec.makeMeasureSpec(r111, 1073741824));
    }

    public final void a(float r110, float r111, int r112, int r113) {
        Camera.Parameters r100 = this.f24319a.getParameters();     // Catch: Exception -> L15
        Camera.Size r101 = r100.getPreviewSize();     // Catch: Exception -> L15
        boolean r102 = true;
        if (r100.getMaxNumFocusAreas() <= 0) goto L6;
        Rect r103 = f0.a.c(1.0f, r110, r111, r112, r113, r101.width, r101.height);     // Catch: Exception -> L15
        f0.a.h(r103);     // Catch: Exception -> L15
        r100.setFocusAreas(Collections.singletonList(new Camera.Area(r103, 1000)));     // Catch: Exception -> L15
        r100.setFocusMode("macro");     // Catch: Exception -> L15
        boolean r104 = true;
    L8:
        if (r100.getMaxNumMeteringAreas() <= 0) goto L10;
        Rect r105 = f0.a.c(1.5f, r110, r111, r112, r113, r101.width, r101.height);     // Catch: Exception -> L15
        f0.a.h(r105);     // Catch: Exception -> L15
        r100.setMeteringAreas(Collections.singletonList(new Camera.Area(r105, 1000)));     // Catch: Exception -> L15
    L11:
        if (r102 == false) goto L13;
        this.f24319a.cancelAutoFocus();     // Catch: Exception -> L15
        this.f24319a.setParameters(r100);     // Catch: Exception -> L15
        this.f24319a.autoFocus(new C0466a(this));     // Catch: Exception -> L15
        return;
    L13:
        this.f24322d = false;     // Catch: Exception -> L15
        return;
    L10:
        r102 = r104;
        goto L11
    L6:
        r104 = false;
    L15:
        e = move-exception;
        e.printStackTrace();
        e.getMessage();
        e();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        if (r100.getSurface() != null) goto L5;
        return;
    L5:
        Camera r104 = this.f24319a;
        if (r104 != null) goto L14;
    L12:
        d();
        return;
    L14:
        this.f24320b = false;     // Catch: Exception -> L10
        r104.cancelAutoFocus();     // Catch: Exception -> L10
        this.f24319a.setOneShotPreviewCallback(null);     // Catch: Exception -> L10
        this.f24319a.stopPreview();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }
}
