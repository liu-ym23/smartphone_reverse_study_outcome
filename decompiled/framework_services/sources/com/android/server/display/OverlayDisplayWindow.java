package com.android.server.display;

import android.R;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.util.Slog;
import android.view.Display;
import android.view.DisplayInfo;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.TextureView;
import android.view.ThreadedRenderer;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.android.internal.util.DumpUtils;
import com.android.server.display.utils.DebugUtils;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
final class OverlayDisplayWindow implements DumpUtils.Dump {
    private static final boolean DEBUG = false;
    private static final String TAG = "OverlayDisplayWindow";
    private final boolean DISABLE_MOVE_AND_RESIZE;
    private final float INITIAL_SCALE;
    private final float MAX_SCALE;
    private final float MIN_SCALE;
    private final float WINDOW_ALPHA;
    private final Context mContext;
    private final Display mDefaultDisplay;
    private final DisplayInfo mDefaultDisplayInfo;
    private int mDensityDpi;
    private final boolean mDisableWindowInteraction;
    private final DisplayManager.DisplayListener mDisplayListener;
    private final DisplayManager mDisplayManager;
    private GestureDetector mGestureDetector;
    private final int mGravity;
    private int mHeight;
    private final Listener mListener;
    private float mLiveScale;
    private float mLiveTranslationX;
    private float mLiveTranslationY;
    private final String mName;
    private final GestureDetector.OnGestureListener mOnGestureListener;
    private final ScaleGestureDetector.OnScaleGestureListener mOnScaleGestureListener;
    private final View.OnTouchListener mOnTouchListener;
    private ScaleGestureDetector mScaleGestureDetector;
    private final boolean mSecure;
    private final TextureView.SurfaceTextureListener mSurfaceTextureListener;
    private TextureView mTextureView;
    private String mTitle;
    private TextView mTitleTextView;
    private int mWidth;
    private View mWindowContent;
    private final WindowManager mWindowManager;
    private WindowManager.LayoutParams mWindowParams;
    private float mWindowScale;
    private boolean mWindowVisible;
    private int mWindowX;
    private int mWindowY;

    public interface Listener {
        void onStateChanged(int r1);

        void onWindowCreated(SurfaceTexture r1, float r2, long r3, int r5);

        void onWindowDestroyed();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ Display m3863$$Nest$fgetmDefaultDisplay(OverlayDisplayWindow r0) {
        return r0.mDefaultDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultDisplayInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayInfo m3864$$Nest$fgetmDefaultDisplayInfo(OverlayDisplayWindow r0) {
        return r0.mDefaultDisplayInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGestureDetector, reason: not valid java name */
    static /* bridge */ /* synthetic */ GestureDetector m3865$$Nest$fgetmGestureDetector(OverlayDisplayWindow r0) {
        return r0.mGestureDetector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ Listener m3866$$Nest$fgetmListener(OverlayDisplayWindow r0) {
        return r0.mListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLiveScale, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m3867$$Nest$fgetmLiveScale(OverlayDisplayWindow r0) {
        return r0.mLiveScale;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLiveTranslationX, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m3868$$Nest$fgetmLiveTranslationX(OverlayDisplayWindow r0) {
        return r0.mLiveTranslationX;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLiveTranslationY, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m3869$$Nest$fgetmLiveTranslationY(OverlayDisplayWindow r0) {
        return r0.mLiveTranslationY;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScaleGestureDetector, reason: not valid java name */
    static /* bridge */ /* synthetic */ ScaleGestureDetector m3870$$Nest$fgetmScaleGestureDetector(OverlayDisplayWindow r0) {
        return r0.mScaleGestureDetector;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLiveScale, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3871$$Nest$fputmLiveScale(OverlayDisplayWindow r0, float r1) {
        r0.mLiveScale = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLiveTranslationX, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3872$$Nest$fputmLiveTranslationX(OverlayDisplayWindow r0, float r1) {
        r0.mLiveTranslationX = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLiveTranslationY, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3873$$Nest$fputmLiveTranslationY(OverlayDisplayWindow r0, float r1) {
        r0.mLiveTranslationY = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$msaveWindowParams, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3874$$Nest$msaveWindowParams(OverlayDisplayWindow r0) {
        r0.saveWindowParams();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDefaultDisplayInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3875$$Nest$mupdateDefaultDisplayInfo(OverlayDisplayWindow r0) {
        return r0.updateDefaultDisplayInfo();
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    OverlayDisplayWindow(Context context, String name, int width, int height, int densityDpi, int gravity, boolean secure, boolean disableWindowInteraction, Listener listener) {
        this.INITIAL_SCALE = 0.5f;
        this.MIN_SCALE = 0.3f;
        this.MAX_SCALE = 1.0f;
        this.WINDOW_ALPHA = 0.8f;
        this.DISABLE_MOVE_AND_RESIZE = false;
        this.mDefaultDisplayInfo = new DisplayInfo();
        this.mLiveScale = 1.0f;
        this.mDisplayListener = new AnonymousClass1(this);
        this.mSurfaceTextureListener = new AnonymousClass2(this);
        this.mOnTouchListener = new AnonymousClass3(this);
        this.mOnGestureListener = new AnonymousClass4(this);
        this.mOnScaleGestureListener = new AnonymousClass5(this);
        ThreadedRenderer.disableVsync();
        this.mContext = context;
        this.mName = name;
        this.mGravity = gravity;
        this.mSecure = secure;
        this.mDisableWindowInteraction = disableWindowInteraction;
        this.mListener = listener;
        this.mDisplayManager = (DisplayManager) context.getSystemService("display");
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mDefaultDisplay = this.mContext.getDisplay();
        updateDefaultDisplayInfo();
        resize(width, height, densityDpi, false);
        createWindow();
    }

    public void show() {
        if (this.mWindowVisible == true) goto L10;
        this.mDisplayManager.registerDisplayListener(this.mDisplayListener, null);
        if (updateDefaultDisplayInfo() == true) goto L8;
        this.mDisplayManager.unregisterDisplayListener(this.mDisplayListener);
        return;
    L8:
        clearLiveState();
        updateWindowParams();
        this.mWindowManager.addView(this.mWindowContent, this.mWindowParams);
        this.mWindowVisible = true;
        return;
    }

    public void dismiss() {
        if (this.mWindowVisible == false) goto L6;
        this.mDisplayManager.unregisterDisplayListener(this.mDisplayListener);
        this.mWindowManager.removeView(this.mWindowContent);
        this.mWindowVisible = false;
        return;
    }

    public void resize(int width, int height, int densityDpi) {
        resize(width, height, densityDpi, true);
    }

    private void resize(int width, int height, int densityDpi, boolean doLayout) {
        this.mWidth = width;
        this.mHeight = height;
        this.mDensityDpi = densityDpi;
        this.mTitle = this.mContext.getResources().getString(R.string.eventTypeBirthday, new Object[]{this.mName, Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mDensityDpi)});
        if (this.mSecure == false) goto L5;
        this.mTitle += this.mContext.getResources().getString(R.string.eventTypeAnniversary);
    L5:
        if (doLayout == false) goto L8;
        relayout();
        return;
    }

    public void relayout() {
        if (this.mWindowVisible == false) goto L6;
        updateWindowParams();
        this.mWindowManager.updateViewLayout(this.mWindowContent, this.mWindowParams);
        return;
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println("mWindowVisible=" + this.mWindowVisible);
        pw.println("mWindowX=" + this.mWindowX);
        pw.println("mWindowY=" + this.mWindowY);
        pw.println("mWindowScale=" + this.mWindowScale);
        pw.println("mWindowParams=" + this.mWindowParams);
        if (this.mTextureView == null) goto L5;
        pw.println("mTextureView.getScaleX()=" + this.mTextureView.getScaleX());
        pw.println("mTextureView.getScaleY()=" + this.mTextureView.getScaleY());
    L5:
        pw.println("mLiveTranslationX=" + this.mLiveTranslationX);
        pw.println("mLiveTranslationY=" + this.mLiveTranslationY);
        pw.println("mLiveScale=" + this.mLiveScale);
    }

    private boolean updateDefaultDisplayInfo() {
        if (this.mDefaultDisplay.getDisplayInfo(this.mDefaultDisplayInfo) == true) goto L6;
        Slog.w(TAG, "Cannot show overlay display because there is no default display upon which to show it.");
        return false;
    L6:
        return true;
    }

    private void createWindow() {
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        this.mWindowContent = inflater.inflate(R.layout.simple_dropdown_hint, null);
        this.mWindowContent.setOnTouchListener(this.mOnTouchListener);
        this.mTextureView = (TextureView) this.mWindowContent.findViewById(R.id.screen);
        this.mTextureView.setPivotX(0.0f);
        this.mTextureView.setPivotY(0.0f);
        this.mTextureView.getLayoutParams().width = this.mWidth;
        this.mTextureView.getLayoutParams().height = this.mHeight;
        int r2 = 0;
        this.mTextureView.setOpaque(false);
        this.mTextureView.setSurfaceTextureListener(this.mSurfaceTextureListener);
        this.mTitleTextView = (TextView) this.mWindowContent.findViewById(R.id.screenLayout);
        this.mTitleTextView.setText(this.mTitle);
        this.mWindowParams = new WindowManager.LayoutParams(2026);
        this.mWindowParams.flags |= 16778024;
        if (this.mSecure == false) goto L6;
        this.mWindowParams.flags |= 8192;
    L6:
        if (this.mDisableWindowInteraction == false) goto L8;
        this.mWindowParams.flags |= 16;
        this.mWindowParams.privateFlags |= 536870912;
    L8:
        this.mWindowParams.privateFlags |= 2;
        this.mWindowParams.alpha = 0.8f;
        this.mWindowParams.gravity = 51;
        this.mWindowParams.setTitle(this.mTitle);
        this.mGestureDetector = new GestureDetector(this.mContext, this.mOnGestureListener);
        this.mScaleGestureDetector = new ScaleGestureDetector(this.mContext, this.mOnScaleGestureListener);
        if ((this.mGravity & 3) != 3) goto L11;
        int r1 = 0;
    L12:
        this.mWindowX = r1;
        if ((this.mGravity & 48) == 48) goto L16;
        r2 = this.mDefaultDisplayInfo.logicalHeight;
    L16:
        this.mWindowY = r2;
        this.mWindowScale = 0.5f;
        return;
    L11:
        r1 = this.mDefaultDisplayInfo.logicalWidth;
        goto L12
    }

    private void updateWindowParams() {
        float scale = Math.max(0.3f, Math.min(1.0f, Math.min(Math.min(this.mWindowScale * this.mLiveScale, this.mDefaultDisplayInfo.logicalWidth / this.mWidth), this.mDefaultDisplayInfo.logicalHeight / this.mHeight)));
        float offsetScale = ((scale / this.mWindowScale) - 1.0f) * 0.5f;
        int width = (int) (this.mWidth * scale);
        int height = (int) (this.mHeight * scale);
        int x = (int) ((this.mWindowX + this.mLiveTranslationX) - (width * offsetScale));
        int y = (int) ((this.mWindowY + this.mLiveTranslationY) - (height * offsetScale));
        int x2 = Math.max(0, Math.min(x, this.mDefaultDisplayInfo.logicalWidth - width));
        int y2 = Math.max(0, Math.min(y, this.mDefaultDisplayInfo.logicalHeight - height));
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "updateWindowParams: scale=" + scale + ", offsetScale=" + offsetScale + ", x=" + x2 + ", y=" + y2 + ", width=" + width + ", height=" + height);
    L5:
        this.mTextureView.setScaleX(scale);
        this.mTextureView.setScaleY(scale);
        this.mWindowParams.x = x2;
        this.mWindowParams.y = y2;
        this.mWindowParams.width = width;
        this.mWindowParams.height = height;
    }

    private void saveWindowParams() {
        this.mWindowX = this.mWindowParams.x;
        this.mWindowY = this.mWindowParams.y;
        this.mWindowScale = this.mTextureView.getScaleX();
        clearLiveState();
    }

    private void clearLiveState() {
        this.mLiveTranslationX = 0.0f;
        this.mLiveTranslationY = 0.0f;
        this.mLiveScale = 1.0f;
    }
}
