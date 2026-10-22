package baseverify;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.dtf.face.config.DeviceSetting;
import com.dtf.face.log.RecordService;
import com.dtf.face.utils.ClientConfigUtil;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class a implements is7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f18453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f18454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Camera f18455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Camera.Parameters f18456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public is7.d f18457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f18459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DeviceSetting f18461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f18462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Camera.CameraInfo f18463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f18464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f18465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f18466n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f18467o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f18468p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f18469q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f18470r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f18471s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f18472t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f18473u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f18474v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f18475w;

    /* JADX INFO: renamed from: baseverify.a$a, reason: collision with other inner class name */
    public class C0285a implements Camera.PreviewCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f18476a;

        public C0285a(a r100) {
            this.f18476a = r100;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] r100, Camera r110) {
            if (r100 == null) goto L9;
            a r101 = this.f18476a;
            if (r101.f18457e == null) goto L9;
            r101.f18473u++;
            ByteBuffer r102 = ByteBuffer.wrap(r100);
            a r103 = this.f18476a;
            is7.b r111 = new is7.b(r102, r103.f18465m, r103.f18466n, r103.f18467o, r103.f18468p);
            r111.f495634j = r103.f18458f;
            r103.f18457e.onPreviewFrame(r111);
            ss7.a.c(-824112624, null);
            return;
        L9:
            if (r100 != null) goto L11;
            String r104 = "data is null";
        L13:
            if (this.f18476a.f18457e != null) goto L15;
            r104 = r104.concat("mCameraCallback is null");
        L15:
            RecordService.getInstance().recordEvent(2, "cameraPreviewEx", new String[]{"msg", r104});
            return;
        L11:
            r104 = "";
            goto L13
        }
    }

    public class b implements Camera.PictureCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ is7.f f18477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f18478b;

        public b(a r100, is7.f r101) {
            this.f18478b = r100;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] r110, Camera r111) {
            ss7.a.c(-824112622, null);     // Catch: Exception -> L20
            if (r110 == null) goto L19;
            a r112 = this.f18478b;     // Catch: Exception -> L20
            int r100 = r112.a(r112.f18461i);     // Catch: Exception -> L20
            r112.f18458f = r100;     // Catch: Exception -> L20
            Bitmap r113 = BitmapFactory.decodeByteArray(r110, 0, r110.length);     // Catch: Exception -> L20
            if (this.f18478b.f18475w == true) goto L8;
        L13:
            if (r113 == null) goto L17;
            Matrix r101 = new Matrix();     // Catch: Exception -> L20
            r101.setRotate(r100);     // Catch: Exception -> L20
            if (Bitmap.createBitmap(r113, 0, 0, r113.getWidth(), r113.getHeight(), r101, false) == r113) goto L17;
            r113.recycle();     // Catch: Exception -> L20
        L17:
            this.f18478b.f18455c.startPreview();     // Catch: Exception -> L20
            return;
        L8:
            if (r113.getWidth() <= this.f18478b.f18467o) goto L13;
            ss7.a.c(-824112621, null);     // Catch: Exception -> L20
            int r102 = r113.getWidth();     // Catch: Exception -> L20
            int r103 = r113.getHeight();     // Catch: Exception -> L20
            float r114 = this.f18478b.f18467o / r102;     // Catch: Exception -> L20
            Matrix r104 = new Matrix();     // Catch: Exception -> L20
            r104.postScale(r114, r114);     // Catch: Exception -> L20
            Bitmap r115 = Bitmap.createBitmap(r113, 0, 0, r102, r103, r104, true);     // Catch: Exception -> L20
            if (r115 == r113) goto L12;
            r113.recycle();     // Catch: Exception -> L20
        L12:
            r113 = r115;
            goto L13
        L19:
            throw new Exception("taken photo exception, image data null");     // Catch: Exception -> L20
        L20:
            e = move-exception;
            RecordService.getInstance().recordException(e);
        }
    }

    public boolean beautifyAvatar(Bitmap r100) {
        return true;
    }

    @Override // is7.e
    public PointF colorToDepth(PointF r100) {
        return null;
    }

    public PointF depthToColor(PointF r100) {
        return null;
    }

    @Override // is7.e
    public is7.c getCameraParams() {
        return null;
    }

    public String getCameraSN() {
        return null;
    }

    public int getColorMode() {
        return 0;
    }

    @Override // is7.e
    public int getDepthHeight() {
        return 0;
    }

    @Override // is7.e
    public int getDepthWidth() {
        return 0;
    }

    public String getFirmwareVersion() {
        return null;
    }

    @Override // is7.e
    public Rect getROI() {
        return null;
    }

    public Object getUVCCamera() {
        return null;
    }

    @Override // is7.e
    public boolean isMirror() {
        return false;
    }

    @Override // is7.e
    public void releaseCamera() {
    }

    public boolean setDrawCapturing(boolean r100) {
        return false;
    }

    public void setFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r100) {
    }

    public void setGLSurfaceViewListener(baseverify.b r100) {
    }

    public void setRenderLayers(Map<String, Object> r100) {
    }

    public void startFpsCheck() {
    }

    public void stopFpsCheck() {
    }

    public final void a() {
        if (this.f18456d == null) goto L41;
        DeviceSetting r100 = this.f18461i;
        if (r100 == null) goto L7;
        this.f18458f = a(r100);
    L7:
        Camera r101 = this.f18455c;
        if (r101 == null) goto L10;
        r101.setDisplayOrientation(this.f18458f);
    L10:
        DeviceSetting r102 = this.f18461i;
        if (r102 == null) goto L16;
        if (r102.isWidthAuto() == true) goto L16;
        Camera.Size r103 = c.a().a(this.f18456d.getSupportedPreviewSizes(), this.f18461i.getWidth(), this.f18461i.getHeight(), this.f18458f, this.f18461i, this.f18462j, this.f18463k);
    L19:
        if (r103 == null) goto L26;
        int r104 = r103.width;
        this.f18467o = r104;
        int r105 = r103.height;
        this.f18468p = r105;
        this.f18465m = r104;
        this.f18466n = r105;
        this.f18456d.setPreviewSize(r104, r105);
        if (this.f18472t == true) goto L26;
        Camera.Size r106 = c.a().a(this.f18456d.getSupportedPictureSizes(), js7.b.e(this.f18454b), is7.a.f495624a, this.f18458f);
        if (r106 == null) goto L26;
        this.f18456d.setPictureSize(r106.width, r106.height);
    L26:
        if (this.f18461i != null) goto L28;
    L32:
        List<String> r107 = this.f18456d.getSupportedFocusModes();
        if (r107 != null) goto L35;
        return;
    L35:
        if (r107.contains("continuous-video") == false) goto L38;
        this.f18456d.setFocusMode("continuous-video");
        return;
    L38:
        if (r107.contains("auto") == false) goto L44;
        this.f18456d.setFocusMode("auto");
        return;
    L44:
        return;
    L28:
        if (this.f18456d.isZoomSupported() == false) goto L32;
        int r108 = Math.min(Math.max(this.f18461i.getZoom(), 0), this.f18456d.getMaxZoom());
        if (r108 == this.f18456d.getZoom()) goto L32;
        this.f18456d.setZoom(r108);
    L16:
        if (this.f18472t == false) goto L18;
        r103 = c.a().a(this.f18456d.getSupportedPreviewSizes(), is7.a.f495624a, 480, this.f18458f, this.f18461i, this.f18462j, this.f18463k);
        goto L19
    L18:
        r103 = c.a().a(this.f18456d.getSupportedPreviewSizes(), js7.b.e(this.f18454b), is7.a.f495624a, this.f18458f);
        goto L19
    }

    public void closeCamera() {
        if (this.f18469q == true) goto L5;
        return;
    L5:
        this.f18469q = false;
    }

    public int getCameraPictureAngle() {
        Camera.CameraInfo r100 = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f18459g, r100);
        return r100.orientation;
    }

    public int getCameraRotation() {
        return a(this.f18461i);
    }

    public String getFlashMode() {
        Camera r100 = this.f18455c;
        if (r100 == null) goto L14;
        Camera.Parameters r101 = r100.getParameters();     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        return r101.getFlashMode();
    L15:
        return "";
    L8:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "cameraError", new String[]{"errMsg", RecordService.getStackTraceString(th)});
        return "";
    L14:
        return "";
    }

    public void lockCameraWhiteBalanceAndExposure() {
        Object r100 = this.f18464l;
        monitor-enter(r100);
        Camera r101 = this.f18455c;     // Catch: Throwable -> L9
        if (r101 != null) goto L13;
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L13:
        Camera.Parameters r102 = r101.getParameters();     // Catch: Throwable -> L12
        r102.setAutoExposureLock(true);     // Catch: Throwable -> L12
        r102.setAutoWhiteBalanceLock(true);     // Catch: Throwable -> L12
        this.f18455c.setParameters(r102);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    @Override // is7.e
    public void startCamera() {
        Object r100 = this.f18464l;
        monitor-enter(r100);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.f18470r == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L8:
        int r101 = 0;
        int r102 = c.a(0);     // Catch: Throwable -> L22
        if (r102 == (-1)) goto L13;
        r101 = r102;
    L13:
        if (this.f18460h == false) goto L18;
        r101 = c.a(1);     // Catch: Throwable -> L22
        if (r101 != (-1)) goto L18;
        r101 = 1;
    L18:
        if (a(r101) == false) goto L20;
        this.f18470r = true;     // Catch: Throwable -> L22
    L20:
        monitor-exit(r100);     // Catch: Throwable -> L22
    }

    @Override // is7.e
    public void stopCamera() {
        Object r100 = this.f18464l;
        monitor-enter(r100);
    L55:
        th = move-exception;
        throw th;
    L5:
        if (this.f18471s == true) goto L61;
        monitor-exit(r100);     // Catch: Throwable -> L55
    L38:
        Object r101 = this.f18464l;
        monitor-enter(r101);
    L52:
        th = move-exception;
        throw th;
    L41:
        if (this.f18470r == true) goto L44;
        monitor-exit(r101);     // Catch: Throwable -> L52
        return;
    L44:
        this.f18457e = null;     // Catch: Throwable -> L52
        Camera r102 = this.f18455c;     // Catch: Throwable -> L52
        if (r102 != null) goto L64;
    L50:
        monitor-exit(r101);     // Catch: Throwable -> L52
        return;
    L64:
        baseverify_a_android_hardware_Camera_release(r102);     // Catch: Exception -> L48 Throwable -> L52
        this.f18455c = null;     // Catch: Exception -> L48 Throwable -> L52
        this.f18470r = false;     // Catch: Exception -> L48 Throwable -> L52
    L48:
        e = move-exception;
        RecordService.getInstance().recordException(e);     // Catch: Throwable -> L52
        goto L50
    L61:
        long r103 = System.currentTimeMillis() - this.f18474v;     // Catch: Throwable -> L20
        if (r103 == 0) goto L23;
        float r104 = this.f18473u / ((r103 * 1.0f) / 1000.0f);     // Catch: Throwable -> L20
        RecordService r105 = RecordService.getInstance();     // Catch: Throwable -> L20
        String[] r106 = new String[8];     // Catch: Throwable -> L20
        r106[0] = "previewFrameCount";     // Catch: Throwable -> L20
        r106[1] = String.valueOf(this.f18473u);     // Catch: Throwable -> L20
        r106[2] = ChameleonOpenTracker.ParamKey.COST;     // Catch: Throwable -> L20
        r106[3] = String.valueOf(r103);     // Catch: Throwable -> L20
        r106[4] = "frameRatio";     // Catch: Throwable -> L20
        r106[5] = String.valueOf(r104);     // Catch: Throwable -> L20
        r106[6] = "status";     // Catch: Throwable -> L20
        if (r104 >= 20.0f) goto L16;
        String r107 = com.bytedance.android.ec.core.event.a.KEY_EXCEPTION;
    L18:
        r106[7] = r107;     // Catch: Throwable -> L20
        r105.recordEvent(2, "stopPreview", r106);     // Catch: Throwable -> L20
    L16:
        r107 = "normal";
    L23:
        if (this.f18455c == null) goto L37;
        Object r108 = this.f18464l;     // Catch: Throwable -> L55
        monitor-enter(r108);     // Catch: Throwable -> L55
        this.f18455c.setOneShotPreviewCallback(null);     // Catch: Throwable -> L28 Exception -> L30
        this.f18455c.setPreviewCallback(null);     // Catch: Throwable -> L28 Exception -> L30
        this.f18455c.stopPreview();     // Catch: Throwable -> L28 Exception -> L30
    L32:
        monitor-exit(r108);     // Catch: Throwable -> L28
        this.f18471s = false;     // Catch: Throwable -> L55
        goto L37
    L30:
        e = move-exception;
        RecordService.getInstance().recordException(e);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L55
    L37:
        monitor-exit(r100);     // Catch: Throwable -> L55
    L20:
        th = move-exception;
        RecordService.getInstance().recordException(th);     // Catch: Throwable -> L55
        goto L23
    }

    @Override // is7.e
    public void stopPreview() {
        Object r100 = this.f18464l;
        monitor-enter(r100);
    L40:
        th = move-exception;
        throw th;
    L5:
        if (this.f18471s == true) goto L46;
        monitor-exit(r100);     // Catch: Throwable -> L40
        return;
    L46:
        long r101 = System.currentTimeMillis() - this.f18474v;     // Catch: Throwable -> L21
        if (r101 == 0) goto L24;
        float r102 = this.f18473u / ((r101 * 1.0f) / 1000.0f);     // Catch: Throwable -> L21
        RecordService r103 = RecordService.getInstance();     // Catch: Throwable -> L21
        String[] r104 = new String[8];     // Catch: Throwable -> L21
        r104[0] = "previewFrameCount";     // Catch: Throwable -> L21
        r104[1] = String.valueOf(this.f18473u);     // Catch: Throwable -> L21
        r104[2] = ChameleonOpenTracker.ParamKey.COST;     // Catch: Throwable -> L21
        r104[3] = String.valueOf(r101);     // Catch: Throwable -> L21
        r104[4] = "frameRatio";     // Catch: Throwable -> L21
        r104[5] = String.valueOf(r102);     // Catch: Throwable -> L21
        r104[6] = "status";     // Catch: Throwable -> L21
        if (r102 >= 20.0f) goto L17;
        String r105 = com.bytedance.android.ec.core.event.a.KEY_EXCEPTION;
    L19:
        r104[7] = r105;     // Catch: Throwable -> L21
        r103.recordEvent(2, "stopPreview", r104);     // Catch: Throwable -> L21
    L17:
        r105 = "normal";
    L24:
        if (this.f18455c == null) goto L38;
        Object r106 = this.f18464l;     // Catch: Throwable -> L40
        monitor-enter(r106);     // Catch: Throwable -> L40
        this.f18455c.setOneShotPreviewCallback(null);     // Catch: Throwable -> L29 Exception -> L31
        this.f18455c.setPreviewCallback(null);     // Catch: Throwable -> L29 Exception -> L31
        this.f18455c.stopPreview();     // Catch: Throwable -> L29 Exception -> L31
    L33:
        monitor-exit(r106);     // Catch: Throwable -> L29
        this.f18471s = false;     // Catch: Throwable -> L40
        goto L38
    L31:
        e = move-exception;
        RecordService.getInstance().recordException(e);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L38:
        monitor-exit(r100);     // Catch: Throwable -> L40
        return;
    L21:
        th = move-exception;
        RecordService.getInstance().recordException(th);     // Catch: Throwable -> L40
        goto L24
    }

    public void turnOffTakePhotoFlash() {
        Camera r100 = this.f18455c;
        if (r100 == null) goto L14;
        Camera.Parameters r101 = r100.getParameters();     // Catch: Throwable -> L9
        if (r101 != null) goto L7;
        return;
    L7:
        r101.setFlashMode("off");     // Catch: Throwable -> L9
        this.f18455c.setParameters(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "cameraError", new String[]{"errMsg", RecordService.getStackTraceString(th)});
        return;
    }

    public void turnOnTakePhotoFlash() {
        Camera r100 = this.f18455c;
        if (r100 == null) goto L14;
        Camera.Parameters r101 = r100.getParameters();     // Catch: Throwable -> L9
        if (r101 != null) goto L7;
        return;
    L7:
        r101.setFlashMode("torch");     // Catch: Throwable -> L9
        this.f18455c.setParameters(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "cameraError", new String[]{"errMsg", RecordService.getStackTraceString(th)});
        return;
    }

    public void unlockCameraWhiteBalanceAndExposure() {
        Object r100 = this.f18464l;
        monitor-enter(r100);
        Camera r101 = this.f18455c;     // Catch: Throwable -> L9
        if (r101 != null) goto L13;
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L13:
        Camera.Parameters r102 = r101.getParameters();     // Catch: Throwable -> L12
        r102.setAutoExposureLock(false);     // Catch: Throwable -> L12
        r102.setAutoWhiteBalanceLock(false);     // Catch: Throwable -> L12
        this.f18455c.setParameters(r102);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public a() {
        this.f18458f = 90;
        this.f18460h = true;
        this.f18461i = new DeviceSetting();
        this.f18464l = new Object();
        this.f18465m = 0;
        this.f18466n = 0;
        this.f18467o = 0;
        this.f18468p = 0;
        this.f18472t = false;
        this.f18473u = 0;
        this.f18474v = 0;
        this.f18475w = false;
        this.f18469q = false;
        this.f18470r = false;
        this.f18471s = false;
    }

    @Override // is7.e
    public Camera getCamera() {
        return this.f18455c;
    }

    @Override // is7.e
    public int getCameraViewRotation() {
        return this.f18458f;
    }

    @Override // is7.e
    public int getColorHeight() {
        return this.f18466n;
    }

    @Override // is7.e
    public int getColorWidth() {
        return this.f18465m;
    }

    @Override // is7.e
    public int getPreviewHeight() {
        return this.f18468p;
    }

    @Override // is7.e
    public int getPreviewWidth() {
        return this.f18467o;
    }

    private static Camera baseverify_a_android_hardware_Camera_open(int r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = {Integer.valueOf(r110)};
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(100100, "android/hardware/Camera", "open", Camera.class, r101, "android.hardware.Camera", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, null, r111, false);
        return (Camera) r112.f474983b;
    L6:
        Camera r113 = Camera.open(r110);
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, r113, r111, true);
        return r113;
    }

    private static void baseverify_a_android_hardware_Camera_release(Camera r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100101, "android/hardware/Camera", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, true);
    }

    public final int a(DeviceSetting r100) {
        if (r100 == null) goto L45;
        if (r100.isDisplayAuto() == false) goto L38;
        int r101 = this.f18459g;
        Camera.CameraInfo r102 = new Camera.CameraInfo();
        this.f18463k = r102;
        Camera.getCameraInfo(r101, r102);
        this.f18462j = ((WindowManager) this.f18454b.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRotation();
        int r103 = 0;
        if (ClientConfigUtil.f273689h != (-1)) goto L12;
        if ("0".equals(ClientConfigUtil.c("DEVICE_ROTATION_FIX")) == false) goto L10;
        ClientConfigUtil.f273689h = 0;
        goto L12
    L10:
        ClientConfigUtil.f273689h = 1;
    L12:
        if (1 != ClientConfigUtil.f273689h) goto L14;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L18;
    L24:
        int r105 = this.f18462j;
        if (r105 == 0) goto L34;
        if (r105 == 1) goto L33;
        if (r105 != 2) goto L29;
        r103 = 180;
        goto L34
    L29:
        if (r105 != 3) goto L34;
        r103 = 270;
        goto L34
    L33:
        r103 = 90;
    L34:
        Camera.CameraInfo r106 = this.f18463k;
        if (r106.facing != 1) goto L37;
        int r107 = (360 - ((r106.orientation + r103) % 360)) % 360;
    L40:
        if (js7.b.g() == false) goto L43;
        return 90;
    L43:
        return r107;
    L37:
        r107 = ((r106.orientation - r103) + 360) % 360;
        goto L40
    L18:
        if (js7.b.g() == true) goto L24;
        if (this.f18462j != 1) goto L24;
        if (hs7.a.h().f487013y == true) goto L24;
        this.f18462j = 0;
        RecordService.getInstance().recordEvent(2, "rotationFix", new String[0]);
        goto L24
    L14:
        r104 = false;
        goto L16
    L38:
        r107 = r100.getDisplayAngle();
        goto L40
    L45:
        throw new IllegalArgumentException("deviceSetting can't be null");
    }

    public void openCamera(DeviceSetting r100) {
        if (this.f18469q == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        this.f18461i = r100;
    L7:
        this.f18469q = true;
    }

    @Override // is7.e
    public void setCallback(is7.d r100) {
        this.f18457e = r100;
    }

    public void setTakeAsPreviewSize(boolean r100) {
        this.f18475w = r100;
    }

    public void takePhoto(is7.f r100) {
        Camera r101 = this.f18455c;
        if (r101 == null) goto L6;
        baseverify_a_android_hardware_Camera_takePicture(r101, null, null, new b(this, r100));
        return;
    }

    public final boolean a(int r100) {
        Camera r101 = baseverify_a_android_hardware_Camera_open(r100);     // Catch: Throwable -> L12 Exception -> L16
        this.f18455c = r101;     // Catch: Throwable -> L12 Exception -> L16
        if (r101 != null) goto L9;
        is7.d r102 = this.f18457e;     // Catch: Throwable -> L12 Exception -> L16
        if (r102 == null) goto L8;
        r102.onError(new Throwable("mCamera == null"));     // Catch: Throwable -> L12 Exception -> L16
    L8:
        return false;
    L9:
        this.f18459g = r100;     // Catch: Throwable -> L12 Exception -> L16
        this.f18456d = r101.getParameters();     // Catch: Throwable -> L12 Exception -> L16
        a();     // Catch: Throwable -> L12 Exception -> L16
        this.f18455c.setParameters(this.f18456d);     // Catch: Throwable -> L12 Exception -> L16
        return true;
    L16:
        e = move-exception;
        is7.d r103 = this.f18457e;
        if (r103 == null) goto L20;
        r103.onError(e);
    L20:
        return false;
    L12:
        th = move-exception;
        is7.d r104 = this.f18457e;
        if (r104 == null) goto L20;
        r104.onError(th);
        goto L20
    }

    private static void baseverify_a_android_hardware_Camera_takePicture(Camera r110, Camera.ShutterCallback r111, Camera.PictureCallback r210, Camera.PictureCallback r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(100107);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(100107, "android/hardware/Camera", "takePicture", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.takePicture(r111, r210, r211);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // is7.e
    public void initCamera(Context r100, boolean r101, boolean r102, DeviceSetting r103) {
        if (r100 != null) goto L4;
    L7:
        this.f18460h = r101;
        this.f18472t = r102;
        if (r103 == null) goto L10;
        this.f18461i = r103;
    L10:
        if (r101 == true) goto L16;
        this.f18458f = 270;
        DeviceSetting r104 = this.f18461i;
        if (r104 == null) goto L16;
        if (this.f18470r == false) goto L16;
        this.f18458f = a(r104);
    L16:
        this.f18454b = r100;
        return;
    L4:
        if ((r100 instanceof Activity) == false) goto L6;
        Activity r105 = (Activity) r100;
    L6:
        r100 = r100.getApplicationContext();
        goto L7
    }

    @Override // is7.e
    public void startPreview(SurfaceHolder r100, float r101, int r102, int r103) {
        Object r104 = this.f18464l;
        monitor-enter(r104);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.f18471s == false) goto L8;
        monitor-exit(r104);     // Catch: Throwable -> L26
        return;
    L8:
        Camera r105 = this.f18455c;     // Catch: Throwable -> L26
        if (r105 == null) goto L23;
        if (r100 != null) goto L29;
    L12:
        this.f18455c.setPreviewCallback(new C0285a(this));     // Catch: Exception -> L15 Throwable -> L26
        this.f18473u = 0;     // Catch: Exception -> L15 Throwable -> L26
        this.f18474v = System.currentTimeMillis();     // Catch: Exception -> L15 Throwable -> L26
        this.f18455c.startPreview();     // Catch: Exception -> L15 Throwable -> L26
    L15:
        e = move-exception;
        is7.d r106 = this.f18457e;     // Catch: Throwable -> L26
        if (r106 == null) goto L20;
        r106.onError(e);     // Catch: Throwable -> L26
    L20:
        return;
    L14:
        this.f18471s = true;     // Catch: Throwable -> L26
    L24:
        monitor-exit(r104);     // Catch: Throwable -> L26
        return;
    L29:
        r105.setPreviewDisplay(r100);     // Catch: Exception -> L15 Throwable -> L26
        goto L12
    L23:
        RecordService.getInstance().recordEvent(2, "cameraPreviewEx", new String[]{"msg", "camera is null"});     // Catch: Throwable -> L26
        goto L24
    }
}
