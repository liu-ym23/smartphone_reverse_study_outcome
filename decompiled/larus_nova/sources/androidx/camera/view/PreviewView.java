package androidx.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.impl.ZoomGestureDetector;
import androidx.camera.view.internal.ScreenFlashUiInfo;
import androidx.camera.view.internal.compat.quirk.DeviceQuirks;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import androidx.camera.view.transform.OutputTransform;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.nova.R;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class PreviewView extends FrameLayout {
    static final int DEFAULT_BACKGROUND_COLOR = 17170444;
    private static final ImplementationMode DEFAULT_IMPL_MODE = null;
    private static final String TAG = "PreviewView";
    final AtomicReference<PreviewStreamStateObserver> mActiveStreamStateObserver;
    CameraController mCameraController;
    CameraInfoInternal mCameraInfoInternal;
    private final DisplayRotationListener mDisplayRotationListener;
    PreviewViewImplementation mImplementation;
    ImplementationMode mImplementationMode;
    OnFrameUpdateListener mOnFrameUpdateListener;
    Executor mOnFrameUpdateListenerExecutor;
    private final View.OnLayoutChangeListener mOnLayoutChangeListener;
    final MutableLiveData<StreamState> mPreviewStreamStateLiveData;
    final PreviewTransformation mPreviewTransform;
    PreviewViewMeteringPointFactory mPreviewViewMeteringPointFactory;
    final ScreenFlashView mScreenFlashView;
    final Preview.SurfaceProvider mSurfaceProvider;
    private MotionEvent mTouchUpEvent;
    boolean mUseDisplayRotation;
    private final ZoomGestureDetector mZoomGestureDetector;

    /* JADX INFO: renamed from: androidx.camera.view.PreviewView$1, reason: invalid class name */
    public class AnonymousClass1 implements Preview.SurfaceProvider {
        final /* synthetic */ PreviewView this$0;

        public static /* synthetic */ void a(AnonymousClass1 r100, PreviewStreamStateObserver r101, CameraInternal r102) {
            r100.lambda$onSurfaceRequested$2(r101, r102);
        }

        public static /* synthetic */ void b(AnonymousClass1 r100, CameraInternal r101, SurfaceRequest r102, SurfaceRequest.TransformationInfo r103) {
            r100.lambda$onSurfaceRequested$1(r101, r102, r103);
        }

        public static /* synthetic */ void c(AnonymousClass1 r100, SurfaceRequest r101) {
            r100.lambda$onSurfaceRequested$0(r101);
        }

        public AnonymousClass1(PreviewView r100) {
            this.this$0 = r100;
        }

        private /* synthetic */ void lambda$onSurfaceRequested$0(SurfaceRequest r100) {
            this.this$0.mSurfaceProvider.onSurfaceRequested(r100);
        }

        @Override // androidx.camera.core.Preview.SurfaceProvider
        public void onSurfaceRequested(final SurfaceRequest r100) {
            if (Threads.isMainThread() == true) goto L6;
            ContextCompat.getMainExecutor(this.this$0.getContext()).execute(new q(this, r100));
            return;
        L6:
            Logger.d(PreviewView.TAG, "Surface requested by Preview.");
            final CameraInternal r101 = r100.getCamera();
            PreviewView r102 = this.this$0;
            r102.mCameraInfoInternal = r101.getCameraInfoInternal();
            this.this$0.mPreviewViewMeteringPointFactory.setSensorRect(r101.getCameraControlInternal().getSensorRect());
            r100.setTransformationInfoListener(ContextCompat.getMainExecutor(this.this$0.getContext()), new s(this, r101, r100));
            PreviewView r103 = this.this$0;
            if (PreviewView.shouldReuseImplementation(r103.mImplementation, r100, r103.mImplementationMode) == true) goto L13;
            PreviewView r104 = this.this$0;
            if (PreviewView.shouldUseTextureView(r100, r104.mImplementationMode) == false) goto L11;
            PreviewView r105 = this.this$0;
            PreviewViewImplementation r106 = new TextureViewImplementation(r105, r105.mPreviewTransform);
        L12:
            r104.mImplementation = r106;
            goto L13
        L11:
            PreviewView r107 = this.this$0;
            r106 = new SurfaceViewImplementation(r107, r107.mPreviewTransform);
        L13:
            CameraInfoInternal r108 = r101.getCameraInfoInternal();
            PreviewView r109 = this.this$0;
            final PreviewStreamStateObserver r110 = new PreviewStreamStateObserver(r108, r109.mPreviewStreamStateLiveData, r109.mImplementation);
            this.this$0.mActiveStreamStateObserver.set(r110);
            r101.getCameraState().addObserver(ContextCompat.getMainExecutor(this.this$0.getContext()), r110);
            this.this$0.mImplementation.onSurfaceRequested(r100, new t(this, r110, r101));
            PreviewView r111 = this.this$0;
            if (r111.indexOfChild(r111.mScreenFlashView) != (-1)) goto L16;
            PreviewView r112 = this.this$0;
            r112.addView(r112.mScreenFlashView);
        L16:
            PreviewView r113 = this.this$0;
            OnFrameUpdateListener r114 = r113.mOnFrameUpdateListener;
            if (r114 == null) goto L22;
            Executor r115 = r113.mOnFrameUpdateListenerExecutor;
            if (r115 == null) goto L23;
            r113.mImplementation.setFrameUpdateListener(r115, r114);
            return;
        L23:
            return;
        }

        private /* synthetic */ void lambda$onSurfaceRequested$2(PreviewStreamStateObserver r100, CameraInternal r101) {
            AtomicReference<PreviewStreamStateObserver> r102 = this.this$0.mActiveStreamStateObserver;
        L4:
            if (r102.compareAndSet(r100, null) == true) goto L5;
            if (r102.get() == r100) goto L4;
            boolean r103 = false;
        L9:
            if (r103 == false) goto L11;
            r100.updatePreviewStreamState(StreamState.IDLE);
        L11:
            r100.clear();
            r101.getCameraState().removeObserver(r100);
            return;
        L5:
            r103 = true;
            goto L9
        }

        private /* synthetic */ void lambda$onSurfaceRequested$1(CameraInternal r100, SurfaceRequest r101, SurfaceRequest.TransformationInfo r102) {
            Logger.d(PreviewView.TAG, "Preview transformation info updated. " + r102);
            Integer r103 = Integer.valueOf(r100.getCameraInfoInternal().getLensFacing());
            if (r103 != null) goto L7;
            Logger.w(PreviewView.TAG, "The lens facing is null, probably an external.");
        L5:
            boolean r104 = true;
        L10:
            this.this$0.mPreviewTransform.setTransformationInfo(r102, r101.getResolution(), r104);
            if (r102.getTargetRotation() == (-1)) goto L18;
            PreviewView r105 = this.this$0;
            PreviewViewImplementation r106 = r105.mImplementation;
            if (r106 != null) goto L15;
        L17:
            r105.mUseDisplayRotation = false;
        L19:
            this.this$0.redrawPreview();
            return;
        L15:
            if ((r106 instanceof SurfaceViewImplementation) == false) goto L17;
        L18:
            this.this$0.mUseDisplayRotation = true;
            goto L19
        L7:
            if (r103.intValue() == 0) goto L5;
            r104 = false;
            goto L10
        }
    }

    public class DisplayRotationListener implements DisplayManager.DisplayListener {
        final /* synthetic */ PreviewView this$0;

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int r100) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int r100) {
        }

        public DisplayRotationListener(PreviewView r100) {
            this.this$0 = r100;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int r100) {
            Display r101 = this.this$0.getDisplay();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getDisplayId() != r100) goto L9;
            this.this$0.redrawPreview();
            return;
        }
    }

    public static final enum ImplementationMode extends Enum<ImplementationMode> {
        private static final /* synthetic */ ImplementationMode[] $VALUES = null;
        public static final ImplementationMode COMPATIBLE = null;
        public static final ImplementationMode PERFORMANCE = null;
        private final int mId;

        private static /* synthetic */ ImplementationMode[] $values() {
            return new ImplementationMode[]{PERFORMANCE, COMPATIBLE};
        }

        static {
            PERFORMANCE = new ImplementationMode("PERFORMANCE", 0, 0);
            COMPATIBLE = new ImplementationMode("COMPATIBLE", 1, 1);
            $VALUES = $values();
        }

        public static ImplementationMode[] values() {
            return (ImplementationMode[]) $VALUES.clone();
        }

        public int getId() {
            return this.mId;
        }

        public static ImplementationMode fromId(int r100) {
            ImplementationMode[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            ImplementationMode r104 = r101[r103];
            if (r104.mId == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            throw new IllegalArgumentException("Unknown implementation mode id " + r100);
        }

        public static ImplementationMode valueOf(String r100) {
            return (ImplementationMode) r27.a.a(ImplementationMode.class, r100);
        }

        private ImplementationMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.mId = r102;
        }
    }

    public interface OnFrameUpdateListener {
        void onFrameUpdate(long r100);
    }

    public static final enum ScaleType extends Enum<ScaleType> {
        private static final /* synthetic */ ScaleType[] $VALUES = null;
        public static final ScaleType FILL_CENTER = null;
        public static final ScaleType FILL_END = null;
        public static final ScaleType FILL_START = null;
        public static final ScaleType FIT_CENTER = null;
        public static final ScaleType FIT_END = null;
        public static final ScaleType FIT_START = null;
        private final int mId;

        private static /* synthetic */ ScaleType[] $values() {
            return new ScaleType[]{FILL_START, FILL_CENTER, FILL_END, FIT_START, FIT_CENTER, FIT_END};
        }

        static {
            FILL_START = new ScaleType("FILL_START", 0, 0);
            FILL_CENTER = new ScaleType("FILL_CENTER", 1, 1);
            FILL_END = new ScaleType("FILL_END", 2, 2);
            FIT_START = new ScaleType("FIT_START", 3, 3);
            FIT_CENTER = new ScaleType("FIT_CENTER", 4, 4);
            FIT_END = new ScaleType("FIT_END", 5, 5);
            $VALUES = $values();
        }

        public static ScaleType[] values() {
            return (ScaleType[]) $VALUES.clone();
        }

        public int getId() {
            return this.mId;
        }

        public static ScaleType fromId(int r100) {
            ScaleType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            ScaleType r104 = r101[r103];
            if (r104.mId == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            throw new IllegalArgumentException("Unknown scale type id " + r100);
        }

        public static ScaleType valueOf(String r100) {
            return (ScaleType) r27.a.a(ScaleType.class, r100);
        }

        private ScaleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.mId = r102;
        }
    }

    public static final enum StreamState extends Enum<StreamState> {
        private static final /* synthetic */ StreamState[] $VALUES = null;
        public static final StreamState IDLE = null;
        public static final StreamState STREAMING = null;

        private static /* synthetic */ StreamState[] $values() {
            return new StreamState[]{IDLE, STREAMING};
        }

        static {
            IDLE = new StreamState("IDLE", 0);
            STREAMING = new StreamState("STREAMING", 1);
            $VALUES = $values();
        }

        public static StreamState[] values() {
            return (StreamState[]) $VALUES.clone();
        }

        public static StreamState valueOf(String r100) {
            return (StreamState) r27.a.a(StreamState.class, r100);
        }

        private StreamState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ boolean a(PreviewView r100, ZoomGestureDetector.ZoomEvent r101) {
        return r100.lambda$new$1(r101);
    }

    public static /* synthetic */ void b(PreviewView r100, View r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109) {
        r100.lambda$new$0(r101, r102, r103, r104, r105, r106, r107, r108, r109);
    }

    static {
        DEFAULT_IMPL_MODE = ImplementationMode.PERFORMANCE;
    }

    private ImageCapture.ScreenFlash getScreenFlashInternal() {
        return this.mScreenFlashView.getScreenFlash();
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.mCameraController == null) goto L13;
        MotionEvent r100 = this.mTouchUpEvent;
        if (r100 == null) goto L7;
        float r101 = r100.getX();
    L8:
        MotionEvent r102 = this.mTouchUpEvent;
        if (r102 == null) goto L11;
        float r103 = r102.getY();
    L12:
        this.mCameraController.onTapToFocus(this.mPreviewViewMeteringPointFactory, r101, r103);
        goto L13
    L11:
        r103 = getHeight() / 2.0f;
        goto L12
    L7:
        r101 = getWidth() / 2.0f;
    L13:
        this.mTouchUpEvent = null;
        return super.performClick();
    }

    public void updateDisplayRotationIfNeeded() {
        if (this.mUseDisplayRotation == false) goto L10;
        Display r100 = getDisplay();
        if (r100 == null) goto L11;
        CameraInfoInternal r101 = this.mCameraInfoInternal;
        if (r101 == null) goto L12;
        this.mPreviewTransform.overrideWithDisplayRotation(r101.getSensorRotationDegrees(r100.getRotation()), r100.getRotation());
        return;
    L12:
        return;
    L11:
        return;
    }

    private DisplayManager getDisplayManager() {
        Context r100 = getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return (DisplayManager) r100.getApplicationContext().getSystemService("display");
    }

    private int getViewPortScaleType() {
        int r100 = getScaleType().ordinal();
        if (r100 == 0) goto L18;
        int r101 = 1;
        if (r100 == 1) goto L17;
        r101 = 2;
        if (r100 == 2) goto L17;
        r101 = 3;
        if (r100 == 3) goto L17;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L17;
        throw new IllegalStateException("Unexpected scale type: " + getScaleType());
    L17:
        return r101;
    L18:
        return 0;
    }

    private void startListeningToDisplayChange() {
        DisplayManager r100 = getDisplayManager();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.registerDisplayListener(this.mDisplayRotationListener, new Handler(Looper.getMainLooper()));
    }

    private void stopListeningToDisplayChange() {
        DisplayManager r100 = getDisplayManager();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.unregisterDisplayListener(this.mDisplayRotationListener);
    }

    public Bitmap getBitmap() {
        Threads.checkMainThread();
        PreviewViewImplementation r100 = this.mImplementation;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getBitmap();
    }

    public CameraController getController() {
        Threads.checkMainThread();
        return this.mCameraController;
    }

    public ImplementationMode getImplementationMode() {
        Threads.checkMainThread();
        return this.mImplementationMode;
    }

    public MeteringPointFactory getMeteringPointFactory() {
        Threads.checkMainThread();
        return this.mPreviewViewMeteringPointFactory;
    }

    public OutputTransform getOutputTransform() {
        Threads.checkMainThread();
        Matrix r100 = this.mPreviewTransform.getSurfaceToPreviewViewMatrix(new Size(getWidth(), getHeight()), getLayoutDirection());     // Catch: IllegalStateException -> L5
    L6:
        Rect r101 = this.mPreviewTransform.getSurfaceCropRect();
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        r100.preConcat(TransformUtils.getNormalizedToBuffer(r101));
        if ((this.mImplementation instanceof TextureViewImplementation) == false) goto L14;
        r100.postConcat(getMatrix());
    L17:
        return new OutputTransform(r100, new Size(r101.width(), r101.height()));
    L14:
        if (getMatrix().isIdentity() == true) goto L17;
        Logger.w(TAG, "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
    L18:
        Logger.d(TAG, "Transform info is not ready");
        return null;
    L5:
        r100 = null;
        goto L6
    }

    public ScaleType getScaleType() {
        Threads.checkMainThread();
        return this.mPreviewTransform.getScaleType();
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return getScreenFlashInternal();
    }

    public Matrix getSensorToViewTransform() {
        Threads.checkMainThread();
        if (getWidth() != 0) goto L5;
        return null;
    L5:
        if (getHeight() != 0) goto L8;
        return null;
    L8:
        return this.mPreviewTransform.getSensorToViewTransform(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    public Preview.SurfaceProvider getSurfaceProvider() {
        Threads.checkMainThread();
        return this.mSurfaceProvider;
    }

    public ViewPort getViewPort() {
        Threads.checkMainThread();
        if (getDisplay() != null) goto L7;
        return null;
    L7:
        return getViewPort(getDisplay().getRotation());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startListeningToDisplayChange();
        addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation r100 = this.mImplementation;
        if (r100 == null) goto L5;
        r100.onAttachedToWindow();
    L5:
        attachToControllerIfReady(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation r100 = this.mImplementation;
        if (r100 == null) goto L5;
        r100.onDetachedFromWindow();
    L5:
        CameraController r101 = this.mCameraController;
        if (r101 == null) goto L8;
        r101.clearPreviewSurface();
    L8:
        stopListeningToDisplayChange();
    }

    public void redrawPreview() {
        Threads.checkMainThread();
        if (this.mImplementation == null) goto L5;
        updateDisplayRotationIfNeeded();
        this.mImplementation.redrawPreview();
    L5:
        this.mPreviewViewMeteringPointFactory.recalculate(new Size(getWidth(), getHeight()), getLayoutDirection());
        CameraController r100 = this.mCameraController;
        if (r100 == null) goto L9;
        r100.updatePreviewViewTransform(getSensorToViewTransform());
        return;
    }

    public LiveData<StreamState> getPreviewStreamState() {
        return this.mPreviewStreamStateLiveData;
    }

    public PreviewView(Context r100) {
        this(r100, null);
    }

    private void attachToControllerIfReady(boolean r100) {
        Threads.checkMainThread();
        ViewPort r101 = getViewPort();
        if (this.mCameraController == null) goto L13;
        if (r101 != null) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == false) goto L17;
        this.mCameraController.attachPreviewSurface(getSurfaceProvider(), r101);     // Catch: IllegalStateException -> L9
        return;
    L9:
        e = move-exception;
        if (r100 == false) goto L12;
        Logger.e(TAG, e.toString(), e);
        return;
    L12:
        throw e;
    L17:
        return;
    }

    private /* synthetic */ boolean lambda$new$1(ZoomGestureDetector.ZoomEvent r100) {
        if ((r100 instanceof ZoomGestureDetector.ZoomEvent.Move) == false) goto L9;
        CameraController r101 = this.mCameraController;
        if (r101 == null) goto L10;
        r101.onPinchToZoom(((ZoomGestureDetector.ZoomEvent.Move) r100).getIncrementalScaleFactor());
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    private void setScreenFlashUiInfo(ImageCapture.ScreenFlash r100) {
        CameraController r101 = this.mCameraController;
        if (r101 != null) goto L6;
        Logger.d(TAG, "setScreenFlashUiInfo: mCameraController is null!");
        return;
    L6:
        r101.setScreenFlashUiInfo(new ScreenFlashUiInfo(ScreenFlashUiInfo.ProviderType.PREVIEW_VIEW, r100));
    }

    public ViewPort getViewPort(int r100) {
        Threads.checkMainThread();
        if (getWidth() != 0) goto L5;
        return null;
    L5:
        if (getHeight() != 0) goto L8;
        return null;
    L8:
        return new ViewPort.Builder(new Rational(getWidth(), getHeight()), r100).setScaleType(getViewPortScaleType()).setLayoutDirection(getLayoutDirection()).build();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        if (this.mCameraController != null) goto L7;
        return super.onTouchEvent(r110);
    L7:
        if (r110.getPointerCount() != 1) goto L9;
        boolean r100 = true;
    L11:
        if (r110.getAction() != 1) goto L13;
        boolean r101 = true;
    L15:
        if ((r110.getEventTime() - r110.getDownTime()) >= ViewConfiguration.getLongPressTimeout()) goto L17;
        boolean r102 = true;
    L18:
        if (r100 == false) goto L24;
        if (r101 == false) goto L24;
        if (r102 == false) goto L24;
        this.mTouchUpEvent = r110;
        performClick();
        return true;
    L24:
        if (this.mZoomGestureDetector.onTouchEvent(r110) == false) goto L26;
    L27:
        return true;
    L26:
        if (super.onTouchEvent(r110) == true) goto L27;
        return false;
    L17:
        r102 = false;
        goto L18
    L13:
        r101 = false;
        goto L15
    L9:
        r100 = false;
        goto L11
    }

    public void setController(CameraController r100) {
        Threads.checkMainThread();
        CameraController r101 = this.mCameraController;
        if (r101 == null) goto L6;
        if (r101 == r100) goto L6;
        r101.clearPreviewSurface();
        setScreenFlashUiInfo(null);
    L6:
        this.mCameraController = r100;
        attachToControllerIfReady(false);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public void setImplementationMode(ImplementationMode r100) {
        Threads.checkMainThread();
        this.mImplementationMode = r100;
        if (r100 == ImplementationMode.PERFORMANCE) goto L5;
        return;
    L5:
        if (this.mOnFrameUpdateListener != null) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
    }

    public void setScaleType(ScaleType r100) {
        Threads.checkMainThread();
        this.mPreviewTransform.setScaleType(r100);
        redrawPreview();
        attachToControllerIfReady(false);
    }

    public void setScreenFlashOverlayColor(int r100) {
        this.mScreenFlashView.setBackgroundColor(r100);
    }

    public void setScreenFlashWindow(Window r100) {
        Threads.checkMainThread();
        this.mScreenFlashView.setScreenFlashWindow(r100);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public PreviewView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static boolean shouldUseTextureView(SurfaceRequest r100, ImplementationMode r101) {
        boolean r102 = r100.getCamera().getCameraInfoInternal().getImplementationType().equals(CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY);
        if (DeviceQuirks.get(SurfaceViewStretchedQuirk.class) == null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (Build.VERSION.SDK_INT <= 24) goto L21;
        if (r102 == true) goto L21;
        if (r103 == true) goto L21;
        int r104 = r101.ordinal();
        if (r104 == 0) goto L20;
        if (r104 != 1) goto L19;
        return true;
    L19:
        throw new IllegalArgumentException("Invalid implementation mode: " + r101);
    L20:
        return false;
    L21:
        return true;
    L5:
        if (DeviceQuirks.get(SurfaceViewNotCroppedByParentQuirk.class) != null) goto L8;
        r103 = false;
        goto L10
    }

    public void setFrameUpdateListener(Executor r100, OnFrameUpdateListener r101) {
        if (this.mImplementationMode == ImplementationMode.PERFORMANCE) goto L9;
        this.mOnFrameUpdateListener = r101;
        this.mOnFrameUpdateListenerExecutor = r100;
        PreviewViewImplementation r102 = this.mImplementation;
        if (r102 == null) goto L10;
        r102.setFrameUpdateListener(r100, r101);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
    }

    public PreviewView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 0);
    }

    public static boolean shouldReuseImplementation(PreviewViewImplementation r100, SurfaceRequest r101, ImplementationMode r102) {
        if ((r100 instanceof SurfaceViewImplementation) == true) goto L5;
    L7:
        return false;
    L5:
        if (shouldUseTextureView(r101, r102) == true) goto L7;
        return true;
    }

    public PreviewView(Context r110, AttributeSet r111, int r112, int r113) {
        super(r110, r111, r112, r113);
        ImplementationMode r100 = DEFAULT_IMPL_MODE;
        this.mImplementationMode = r100;
        PreviewTransformation r114 = new PreviewTransformation();
        this.mPreviewTransform = r114;
        this.mUseDisplayRotation = true;
        this.mPreviewStreamStateLiveData = new MutableLiveData(StreamState.IDLE);
        this.mActiveStreamStateObserver = new AtomicReference();
        this.mPreviewViewMeteringPointFactory = new PreviewViewMeteringPointFactory(r114);
        this.mDisplayRotationListener = new DisplayRotationListener(this);
        this.mOnLayoutChangeListener = new o(this);
        this.mSurfaceProvider = new AnonymousClass1(this);
        Threads.checkMainThread();
        TypedArray r115 = r110.getTheme().obtainStyledAttributes(r111, new int[]{R.attr.implementationMode, R.attr.scaleType}, r112, r113);
        ViewCompat.saveAttributeDataForStyleable(this, r110, new int[]{R.attr.implementationMode, R.attr.scaleType}, r111, r115, r112, r113);
        setScaleType(ScaleType.fromId(r115.getInteger(1, r114.getScaleType().getId())));     // Catch: Throwable -> L9
        setImplementationMode(ImplementationMode.fromId(r115.getInteger(0, r100.getId())));     // Catch: Throwable -> L9
        r115.recycle();
        this.mZoomGestureDetector = new ZoomGestureDetector(r110, new p(this));
        if (getBackground() != null) goto L7;
        setBackgroundColor(ContextCompat.getColor(getContext(), 17170444));
    L7:
        ScreenFlashView r101 = new ScreenFlashView(r110);
        this.mScreenFlashView = r101;
        r101.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return;
    L9:
        th = move-exception;
        r115.recycle();
        throw th;
    }

    private /* synthetic */ void lambda$new$0(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if ((r103 - r101) == (r107 - r105)) goto L5;
    L8:
        boolean r109 = true;
    L9:
        if (r109 == false) goto L12;
        redrawPreview();
        attachToControllerIfReady(true);
        return;
    L12:
        return;
    L5:
        if ((r104 - r102) != (r108 - r106)) goto L8;
        r109 = false;
        goto L9
    }
}
