package com.android.ttcjpaysdk.ocr.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayBPEAService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.ocr.CameraPreview;
import com.android.ttcjpaysdk.ocr.data.OCRScanData;
import com.android.ttcjpaysdk.ocr.utils.OCRCodeUtil;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import f06.b;
import f06.c;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes39.dex */
public class OCRCodeView extends RelativeLayout implements Camera.PreviewCallback {
    private boolean canTakePicture;
    protected Camera mCamera;
    private AtomicBoolean mDetectedSuccess;
    protected Handler mHandler;
    protected IOCRScanViewListener mIOCRScanViewListener;
    protected IScanBoxView mIScanBoxView;
    protected ImageCollectionListener mImageCollectionListener;
    private Runnable mOneShotPreviewCallbackTask;
    protected CameraPreview mPreview;
    private byte[] mPreviewFrameDate;
    private int mPreviewMaskColor;
    protected boolean mSpotAble;
    private int scanBoxHeight;
    private int scanBoxWidth;
    private Rect scanRect;

    public interface IOCRScanViewListener {
        void onSizeChanged();
    }

    public interface IScanDataHandleListener {
        void onFinish();
    }

    public interface ITakePhotoCallback {
        void onCameraError();

        void onPictureTaken(byte[] r100);
    }

    public interface ImageCollectionListener {
        void onCameraError();

        void onCollect(OCRScanData r100);
    }

    public void cancelProcessDataTask() {
    }

    public void startCamera() {
        startCamera(0);
    }

    private void setScanBoxViewListener() {
        IScanBoxView r100 = this.mIScanBoxView;
        if ((r100 instanceof DefaultScanBoxView) == false) goto L6;
        ((DefaultScanBoxView) r100).setListener(new AnonymousClass5(this));
        return;
    }

    public void closeFlashlight() {
        this.mPreview.closeFlashlight();
    }

    public Rect getScanBoxRect() {
        IScanBoxView r100 = this.mIScanBoxView;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getFramingRect();
    }

    public int getTipsLineCount() {
        IScanBoxView r100 = this.mIScanBoxView;
        if (r100 != null) goto L5;
        return 1;
    L5:
        return r100.getTipsLineCount();
    }

    public void hiddenScanRect() {
        IScanBoxView r100 = this.mIScanBoxView;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    public void openFlashlight() {
        this.mPreview.openFlashlight();
    }

    public void showScanRect() {
        IScanBoxView r100 = this.mIScanBoxView;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
        return;
    }

    public void startSpot() {
        startSpotDelay(200);
    }

    public void stopCamera() {
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("OCRCodeView#stopCamera", e);
        CJBasicCommonUtils.logCatch("CJCatch", "OCRCodeView#stopCamera", e);
        return;
    L3:
        if (this.mCamera == null) goto L15;
        this.mPreview.stopCameraPreview();     // Catch: Exception -> L10
        this.mPreview.setCamera(null);     // Catch: Exception -> L10
        ICJPayBPEAService r100 = (ICJPayBPEAService) CJPayServiceManager.getInstance().getIService(ICJPayBPEAService.class);     // Catch: Exception -> L10
        if (r100 == null) goto L7;
        r100.releaseCamera(this.mCamera, "bpea-cjpay_android_ocr_release_camera");     // Catch: Exception -> L10
    L8:
        this.mCamera = null;     // Catch: Exception -> L10
        return;
    L7:
        com_android_ttcjpaysdk_ocr_view_OCRCodeView_android_hardware_Camera_release(this.mCamera);     // Catch: Exception -> L10
        goto L8
    }

    public void onDestroy() {
        stopCamera();
        stopSpotAndHiddenRect();
    }

    public void startSpotAndShowRect() {
        startSpot();
        showScanRect();
    }

    public void stopSpot() {
        cancelProcessDataTask();
        this.mSpotAble = false;
        Camera r100 = this.mCamera;
        if (r100 != null) goto L13;
    L9:
        Handler r101 = this.mHandler;
        if (r101 == null) goto L15;
        r101.removeCallbacks(this.mOneShotPreviewCallbackTask);
        return;
    L15:
        return;
    L13:
        r100.setOneShotPreviewCallback(null);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("OCRCodeView#cancelProcessDataTask", e);
        CJBasicCommonUtils.logCatch("CJCatch", "OCRCodeView#cancelProcessDataTask", e);
        goto L9
    }

    public void stopSpotAndHiddenRect() {
        stopSpot();
        hiddenScanRect();
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public CameraPreview getCameraPreview() {
        return this.mPreview;
    }

    public int getScanBoxHeight() {
        return this.scanBoxHeight;
    }

    public int getScanBoxWidth() {
        return this.scanBoxWidth;
    }

    public static /* synthetic */ byte[] access$000(OCRCodeView r100) {
        return r100.mPreviewFrameDate;
    }

    public static /* synthetic */ Rect access$200(OCRCodeView r100) {
        return r100.scanRect;
    }

    private static Camera com_android_ttcjpaysdk_ocr_view_OCRCodeView_android_hardware_Camera_open(int r110) {
        c r100 = new c();
        Object[] r101 = {Integer.valueOf(r110)};
        b r111 = new b();
        d r112 = r100.b(100100, "android/hardware/Camera", "open", Camera.class, r101, "android.hardware.Camera", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, null, r111, false);
        return (Camera) r112.f474983b;
    L6:
        Camera r113 = Camera.open(r110);
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, r113, r111, true);
        return r113;
    }

    private static void com_android_ttcjpaysdk_ocr_view_OCRCodeView_android_hardware_Camera_release(Camera r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        if (r100.b(100101, "android/hardware/Camera", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, true);
    }

    private void startCameraById(int r100) {
        ICJPayBPEAService r101 = (ICJPayBPEAService) CJPayServiceManager.getInstance().getIService(ICJPayBPEAService.class);     // Catch: Exception -> L13
        if (r101 == null) goto L5;
        this.mCamera = r101.openCamera(r100, "bpea-cjpay_android_ocr_camera");     // Catch: Exception -> L13
    L7:
        if (this.mCamera != null) goto L11;
        ImageCollectionListener r102 = this.mImageCollectionListener;     // Catch: Exception -> L13
        if (r102 == null) goto L11;
        r102.onCameraError();     // Catch: Exception -> L13
    L11:
        this.mPreview.setCamera(this.mCamera);     // Catch: Exception -> L13
        this.canTakePicture = true;     // Catch: Exception -> L13
        return;
    L5:
        this.mCamera = com_android_ttcjpaysdk_ocr_view_OCRCodeView_android_hardware_Camera_open(r100);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("OCRCodeView#startCameraById", e);
        CJBasicCommonUtils.logCatch("CJCatch", "OCRCodeView#startCameraById", e);
        ImageCollectionListener r103 = this.mImageCollectionListener;
        if (r103 == null) goto L20;
        r103.onCameraError();
        return;
    }

    public Rect getScanBoxRectRelativeTo(View r110) {
        Rect r100 = getScanBoxRect();     // Catch: Throwable -> L20
        if (r100 == null) goto L19;
        if (r100.width() <= 0) goto L19;
        if (r100.height() <= 0) goto L19;
        View r101 = this.mPreview;     // Catch: Throwable -> L20
        if (r101 != null) goto L14;
        r101 = this;
    L14:
        int[] r102 = new int[2];     // Catch: Throwable -> L20
        int[] r103 = new int[2];     // Catch: Throwable -> L20
        r101.getLocationInWindow(r102);     // Catch: Throwable -> L20
        if (r110 == null) goto L17;
        r110.getLocationInWindow(r103);     // Catch: Throwable -> L20
    L17:
        int r104 = r102[0];     // Catch: Throwable -> L20
        int r105 = r103[0];     // Catch: Throwable -> L20
        int r106 = (r104 - r105) + r100.left;     // Catch: Throwable -> L20
        int r107 = r102[1];     // Catch: Throwable -> L20
        int r108 = r103[1];     // Catch: Throwable -> L20
        return new Rect(r106, (r107 - r108) + r100.top, (r104 - r105) + r100.right, (r107 - r108) + r100.bottom);
    L19:
        return null;
    }

    public void setImageCollectionListener(ImageCollectionListener r100) {
        this.mImageCollectionListener = r100;
    }

    public void setOCRScanViewListener(IOCRScanViewListener r100) {
        this.mIOCRScanViewListener = r100;
    }

    public void setScanBoxText(String r100) {
        IScanBoxView r101 = this.mIScanBoxView;
        if ((r101 instanceof DefaultScanBoxView) == false) goto L6;
        ((DefaultScanBoxView) r101).setOCRTipText(r100);
        return;
    }

    public void setScanBoxTextSize(int r100) {
        IScanBoxView r101 = this.mIScanBoxView;
        if ((r101 instanceof DefaultScanBoxView) == false) goto L6;
        ((DefaultScanBoxView) r101).setOCRTipTextSize(r100);
        return;
    }

    public void setScanBoxTopOffset(int r100) {
        IScanBoxView r101 = this.mIScanBoxView;
        if ((r101 instanceof DefaultScanBoxView) == false) goto L6;
        ((DefaultScanBoxView) r101).setTopOffset(r100);
        return;
    }

    public void setScanLineBitmap(Bitmap r100) {
        this.mIScanBoxView.setScanLineBitmap(r100);
    }

    public void setScanView(IScanBoxView r100) {
        this.mIScanBoxView = r100;
    }

    public void showPermissionTip(boolean r100) {
        IScanBoxView r101 = this.mIScanBoxView;
        if (r101 == null) goto L6;
        r101.showPermissionTip(r100);
        this.mIScanBoxView.invalidate();
        return;
    }

    public void showScanBox(boolean r100) {
        IScanBoxView r101 = this.mIScanBoxView;
        if (r101 == null) goto L6;
        r101.showScanBox(r100);
        this.mIScanBoxView.invalidate();
        return;
    }

    public void showScanLine(boolean r100) {
        IScanBoxView r101 = this.mIScanBoxView;
        if (r101 == null) goto L6;
        r101.showScanLine(r100);
        return;
    }

    public void startCamera(int r100) {
        if (this.mCamera == null) goto L5;
        return;
    L5:
        Camera.CameraInfo r101 = new Camera.CameraInfo();
        int r102 = 0;
    L7:
        if (r102 >= Camera.getNumberOfCameras()) goto L21;
        Camera.getCameraInfo(r102, r101);     // Catch: Exception -> L10
    L13:
        if (r101.facing == r100) goto L14;
        r102 = r102 + 1;
        goto L7
    L14:
        startCameraById(r102);
        return;
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("OCRCodeView#startCamera", e);
        CJBasicCommonUtils.logCatch("CJCatch", "OCRCodeView#startCamera", e);
        goto L13
    }

    public void startSpotDelay(int r100) {
        CJLogger.d("ocr_opt", "startSpotDelay");
        this.mSpotAble = true;
        this.mDetectedSuccess.set(false);
        startCamera();
        this.mHandler.removeCallbacks(this.mOneShotPreviewCallbackTask);
        this.mHandler.postDelayed(this.mOneShotPreviewCallbackTask, r100);
    }

    public void takePhoto(final ITakePhotoCallback r100) {
        Camera r101 = this.mCamera;     // Catch: Throwable -> L10
        if (r101 != null) goto L5;
    L7:
        if (r101 != null) goto L13;
        r100.onCameraError();     // Catch: Throwable -> L10
    L13:
        return;
    L5:
        if (this.canTakePicture == false) goto L7;
        this.canTakePicture = false;     // Catch: Throwable -> L10
        com_android_ttcjpaysdk_ocr_view_OCRCodeView_android_hardware_Camera_takePicture(r101, null, null, new AnonymousClass4(this, r100));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("OCRCodeView#onPictureTaken", th);
        CJLogger.c("ocr", "takePhoto", th);
    }

    public OCRCodeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static /* synthetic */ boolean access$302(OCRCodeView r100, boolean r101) {
        r100.canTakePicture = r101;
        return r101;
    }

    private void initView(Context r100, AttributeSet r101) {
        CameraPreview r102 = new CameraPreview(getContext());
        this.mPreview = r102;
        r102.setVisibility(4);
        setBackgroundColor(-16777216);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayScanBoxLayout, R.attr.cj_pay_ocr_preview_maskColor});
        int r104 = r103.getResourceId(0, 0);     // Catch: Throwable -> L15
        this.mPreviewMaskColor = r103.getColor(1, this.mPreviewMaskColor);     // Catch: Throwable -> L15
        r103.recycle();
        if (r104 == 0) goto L8;
        this.mIScanBoxView = (IScanBoxView) LayoutInflater.from(r100).inflate(r104, null, false);
    L8:
        if ((this.mIScanBoxView instanceof DefaultScanBoxView) == false) goto L10;
        int r105 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r100) - (OCRCodeUtil.dp2px(r100, 24.0f) * 2);
        this.scanBoxWidth = r105;
        this.scanBoxHeight = (int) ((((double) r105) * 212.0d) / 327.0d);
        ((DefaultScanBoxView) this.mIScanBoxView).setRectWidth(r105);
        ((DefaultScanBoxView) this.mIScanBoxView).setRectHeight(this.scanBoxHeight);
        int r106 = ((CJPayBasicUtils.getScreenHeight(r100) - OCRCodeUtil.dp2px(r100, 44.0f)) - this.scanBoxHeight) / 2;
        ((DefaultScanBoxView) this.mIScanBoxView).setTopOffset(r106);
    L10:
        setScanBoxViewListener();
        this.mPreview.setBackgroundColor(this.mPreviewMaskColor);
        this.mPreview.setId(R.id.cj_pay_camera_preview);
        RelativeLayout.LayoutParams r107 = new RelativeLayout.LayoutParams(r100, r101);
        r107.addRule(13, this.mPreview.getId());
        addView(this.mPreview, r107);
        RelativeLayout.LayoutParams r108 = new RelativeLayout.LayoutParams(r100, r101);
        r108.addRule(6, this.mPreview.getId());
        r108.addRule(8, this.mPreview.getId());
        View r109 = this.mIScanBoxView;
        if (r109 == null) goto L13;
        addView(r109, r108);
    L13:
        this.mPreview.setAutoFocusCallback(new AnonymousClass2(this));
        return;
    L15:
        th = move-exception;
        r103.recycle();
        throw th;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] r100, Camera r101) {
        if (this.mSpotAble == false) goto L10;
        this.mPreview.setBackgroundColor(this.mPreviewMaskColor);
        this.mPreviewFrameDate = r100;
        if (this.mDetectedSuccess.get() == true) goto L11;
        Camera r102 = this.mCamera;
        if (r102 == null) goto L12;
        r102.setOneShotPreviewCallback(this);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void setScanBorderRadius(int r100, int r101) {
        this.mIScanBoxView.setBorderRadius(r100, r101);
    }

    public void setScanBoxSize(int r100, int r101) {
        IScanBoxView r102 = this.mIScanBoxView;
        if ((r102 instanceof DefaultScanBoxView) == false) goto L6;
        ((DefaultScanBoxView) r102).setRectWidth(r100);
        ((DefaultScanBoxView) this.mIScanBoxView).setRectHeight(r101);
        return;
    }

    public OCRCodeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mHandler = new Handler();
        this.mSpotAble = false;
        this.scanRect = null;
        this.mPreviewMaskColor = ColorProtector.parseColor("#80000000");
        this.canTakePicture = false;
        this.scanBoxWidth = 0;
        this.scanBoxHeight = 0;
        this.mDetectedSuccess = new AtomicBoolean(false);
        this.mOneShotPreviewCallbackTask = new AnonymousClass1(this);
        initView(r100, r101);
    }

    private void executeDateConvert(final byte[] r100, final int r101, final int r102) {
        IScanBoxView r103 = this.mIScanBoxView;
        if (r103 == null) goto L5;
        this.scanRect = r103.getFramingRect();
    L5:
        this.mHandler.post(new AnonymousClass3(this, r100, r101, r102));
    }

    public static /* synthetic */ void access$100(OCRCodeView r100, byte[] r101, int r102, int r103) {
        r100.executeDateConvert(r101, r102, r103);
    }

    private static void com_android_ttcjpaysdk_ocr_view_OCRCodeView_android_hardware_Camera_takePicture(Camera r110, Camera.ShutterCallback r111, Camera.PictureCallback r210, Camera.PictureCallback r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(100107);
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
        d r107 = r106.preInvoke(100107, "android/hardware/Camera", "takePicture", r110, r101, "void", r112);     // Catch: Exception -> L21
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
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
