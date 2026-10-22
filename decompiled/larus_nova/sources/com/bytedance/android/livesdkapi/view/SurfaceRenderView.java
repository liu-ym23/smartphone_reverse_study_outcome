package com.bytedance.android.livesdkapi.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.SurfaceControl;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.android.livesdk.player.utils.h;
import com.bytedance.android.livesdk.utils.ntp.g;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import com.bytedance.android.livesdkapi.model.DisplayRatio;
import com.bytedance.android.livesdkapi.model.PlayerConfig;
import com.bytedance.android.livesdkapi.model.RenderViewInfo;
import com.bytedance.android.livesdkapi.model.StrictMeasureData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
public class SurfaceRenderView extends SurfaceView implements IRenderView, ISurfaceControlParent {
    private final float DEFAULT_RESOLUTION;
    private boolean currentLandscape;
    private DisplayRatio displayRatio;
    public boolean drawFrameWhenSurfaceControlReplace;
    private boolean foldScreenAdapter;
    private boolean hasOnceValidLayout;
    private Set<IRenderView.LayoutListener> mLayoutListenerSet;
    private Set<IRenderView.MeasureListener> mMeasureListenerSet;
    private boolean mSurfaceControlAttached;
    private final Set<ISurfaceControlParent.Listener> mSurfaceControlRenderListenerSet;
    private Set<IRenderView.TranslationAndScaleListener> mTranslationAndScaleListenerSet;
    private int mVideoHeight;
    private int mVideoWidth;
    private Set<IRenderView.VisibilityChangeListener> mVisibilityChangeListenerSet;
    private long notVisibleTime;
    private IPlayerLogger playerLogger;
    private String scene;
    private StrictMeasureData strictMeasureData;
    private int textureLayout;
    private boolean vrMode;
    private int vrStyle;

    public static /* synthetic */ Unit a(SurfaceRenderView r100, Map r101, Bitmap r102) {
        return r100.lambda$drawLastFrame$0(r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public Bitmap getBitmap() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public View getSelfView() {
        return this;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    private String getScene() {
        String r100 = this.scene;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (getParent() == null) goto L11;
        View r101 = (View) getParent();
        if ((r101 instanceof LivePlayerView) == false) goto L11;
        this.scene = ((LivePlayerView) r101).getConfig().getScene().getScene();
    L11:
        return this.scene;
    }

    private void notifyTranslationAndScaleChange() {
        Iterator<IRenderView.TranslationAndScaleListener> r100 = this.mTranslationAndScaleListenerSet.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onTranslationAndScaleChange(getTranslationX(), getTranslationY(), getScaleX(), getScaleY());
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public Pair<Integer, Integer> getMeasuredSize() {
        return new Pair(Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()));
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public boolean isLayoutVideoSizeValid() {
        if (this.mVideoWidth != 0) goto L5;
    L9:
        return false;
    L5:
        if (this.mVideoHeight == 0) goto L9;
        if (this.hasOnceValidLayout == false) goto L9;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void reset() {
        logPlayer("SurfaceRenderView reset", true);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.textureLayout = 2;
    }

    private void drawLastFrame() {
        if ((getParent() instanceof LivePlayerView) == false) goto L8;
        ILivePlayerClient r100 = ((LivePlayerView) getParent()).getClient();
        if (r100.isPlaying() == false) goto L9;
        logPlayer("SurfaceRenderView drawLastFrame saveFrameV2", true);
        r100.saveFrameV2(true, new a(this));
        return;
    L9:
        return;
    }

    private View getDecorView() {
        Context r100 = getContext();
        if ((r100 instanceof Activity) == true) goto L5;
        return null;
    L5:
        Window r101 = ((Activity) r100).getWindow();
        if (r101 != null) goto L9;
        return null;
    L9:
        return INVOKEVIRTUAL_com_bytedance_android_livesdkapi_view_SurfaceRenderView_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101);
    }

    private boolean isPortraitOrientation() {
        ViewGroup r100 = (ViewGroup) getParent();
        if (r100 == null) goto L5;
        Resources r101 = r100.getContext().getResources();
    L7:
        if (r101 != null) goto L9;
        return true;
    L9:
        if (r101.getConfiguration().orientation == 1) goto L14;
        return false;
    L14:
        return true;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public SurfaceHolder getSurfaceHolder() {
        return getHolder();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        logPlayer("SurfaceRenderView onAttachedFromWindow", true);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        logPlayer("SurfaceRenderView onDetachedFromWindow", false);
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public DisplayRatio getDisplayRatio() {
        return this.displayRatio;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public long getNotVisibleTime() {
        return this.notVisibleTime;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public int getScaleType() {
        return this.textureLayout;
    }

    @Override // com.bytedance.android.livesdkapi.view.ISurfaceControlParent
    public boolean hasSurfaceControlAttached() {
        return this.mSurfaceControlAttached;
    }

    public SurfaceRenderView(Context r100) {
        super(r100);
        this.textureLayout = 2;
        this.DEFAULT_RESOLUTION = 1.7777778f;
        this.mMeasureListenerSet = new HashSet();
        this.mLayoutListenerSet = new HashSet();
        this.mTranslationAndScaleListenerSet = new HashSet();
        this.foldScreenAdapter = false;
        this.mVisibilityChangeListenerSet = new HashSet();
        this.notVisibleTime = 0;
        this.currentLandscape = false;
        this.vrMode = true;
        this.vrStyle = 10000;
        this.hasOnceValidLayout = false;
        this.mSurfaceControlAttached = false;
        this.mSurfaceControlRenderListenerSet = new HashSet();
        this.drawFrameWhenSurfaceControlReplace = false;
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_livesdkapi_view_SurfaceRenderView_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void addRenderViewLayoutListener(IRenderView.LayoutListener r100) {
        this.mLayoutListenerSet.add(r100);
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void addRenderViewMeasureListener(IRenderView.MeasureListener r100) {
        this.mMeasureListenerSet.add(r100);
    }

    public void addRenderViewVisibilityChangeListener(IRenderView.VisibilityChangeListener r100) {
        this.mVisibilityChangeListenerSet.add(r100);
    }

    public void addSurfaceControlRenderListener(ISurfaceControlParent.Listener r100) {
        this.mSurfaceControlRenderListenerSet.add(r100);
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void addTranslationAndScaleListener(IRenderView.TranslationAndScaleListener r100) {
        this.mTranslationAndScaleListenerSet.add(r100);
    }

    @Override // com.bytedance.android.livesdkapi.view.ISurfaceControlParent
    public void onSurfaceControlAttached(SurfaceControl r100) {
        this.mSurfaceControlAttached = true;
        Iterator<ISurfaceControlParent.Listener> r101 = this.mSurfaceControlRenderListenerSet.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onSurfaceControlAttached(r100);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.view.ISurfaceControlParent
    public void onSurfaceControlDetach(boolean r100) {
        if (this.drawFrameWhenSurfaceControlReplace == false) goto L6;
        if (r100 == false) goto L6;
        drawLastFrame();
    L6:
        Iterator<ISurfaceControlParent.Listener> r101 = this.mSurfaceControlRenderListenerSet.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().onSurfaceControlDetach(r100);
        goto L8
    L10:
        this.mSurfaceControlAttached = false;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void removeRenderViewLayoutListener(IRenderView.LayoutListener r100) {
        this.mLayoutListenerSet.remove(r100);
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void removeRenderViewMeasureListener(IRenderView.MeasureListener r100) {
        this.mMeasureListenerSet.remove(r100);
    }

    public void removeRenderViewVisibilityChangeListener(IRenderView.VisibilityChangeListener r100) {
        this.mVisibilityChangeListenerSet.remove(r100);
    }

    public void removeSurfaceControlRenderListener(ISurfaceControlParent.Listener r100) {
        this.mSurfaceControlRenderListenerSet.remove(r100);
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void removeTranslationAndScaleListener(IRenderView.TranslationAndScaleListener r100) {
        this.mTranslationAndScaleListenerSet.remove(r100);
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setCurrentLandscape(boolean r100) {
        this.currentLandscape = r100;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setDisplayRatio(DisplayRatio r100) {
        this.displayRatio = r100;
    }

    public void setEnableClipping(boolean r100) {
        Method r101 = SurfaceView.class.getDeclaredMethod("setEnableSurfaceClipping", new Class[]{Boolean.TYPE});     // Catch: Exception -> L6
        r101.setAccessible(true);     // Catch: Exception -> L6
        r101.invoke(this, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L6
        IPlayerLogger r102 = this.playerLogger;     // Catch: Exception -> L6
        if (r102 == null) goto L11;
        r102.logCallStack("surface view setEnableSurfaceClipping");     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.toString();
    }

    @Override // android.view.View, com.bytedance.android.livesdkapi.view.IRenderView
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        super.setLayoutParams(r100);
        IPlayerLogger r101 = this.playerLogger;
        if (r101 == null) goto L6;
        r101.logCallStack("surface view set layout params");
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setPlayerLogger(IPlayerLogger r100) {
        if (this.playerLogger != r100) goto L5;
        return;
    L5:
        this.playerLogger = r100;
        if (r100 == null) goto L24;
        ILivePlayerHostService r101 = is0.c.c().hostService();
        boolean r102 = false;
        if (r101 == null) goto L10;
        boolean r103 = r101.isFoldScreen();
    L11:
        PlayerConfig r104 = (PlayerConfig) is0.c.c().getConfig(PlayerConfig.class);
        if (r104 != null) goto L14;
    L18:
        boolean r105 = false;
    L19:
        if (r105 == false) goto L22;
        if (r103 == false) goto L22;
        r102 = true;
    L22:
        this.foldScreenAdapter = r102;
        return;
    L14:
        if (r104.getFoldScreenAdapt() == false) goto L18;
        if (r104.getFoldScreenAdaptV2() == true) goto L18;
        r105 = true;
        goto L19
    L10:
        r103 = false;
        goto L11
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setScaleType(int r100) {
        this.textureLayout = r100;
        logPlayer("SurfaceRenderView setScaleType :" + r100, true);
        if (r100 == 4) goto L6;
        this.strictMeasureData = null;
    L6:
        if (r100 == 6) goto L9;
        this.displayRatio = null;
        return;
    }

    @Override // android.view.View
    public void setScaleX(float r100) {
        super.setScaleX(r100);
        notifyTranslationAndScaleChange();
    }

    @Override // android.view.View
    public void setScaleY(float r100) {
        super.setScaleY(r100);
        notifyTranslationAndScaleChange();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setStrictMeasureData(StrictMeasureData r100) {
        this.strictMeasureData = r100;
    }

    @Override // android.view.View
    public void setTranslationX(float r100) {
        super.setTranslationX(r100);
        notifyTranslationAndScaleChange();
    }

    @Override // android.view.View
    public void setTranslationY(float r100) {
        super.setTranslationY(r100);
        notifyTranslationAndScaleChange();
    }

    @Override // android.view.SurfaceView, android.view.View, com.bytedance.android.livesdkapi.view.IRenderView
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 == 0) goto L5;
        this.notVisibleTime = SystemClock.elapsedRealtime();
    L5:
        logPlayer("setVisibility " + r100, false);
        IPlayerLogger r101 = this.playerLogger;
        if (r101 == null) goto L9;
        r101.logCallStack("SurfaceRenderView.setVisibility: " + r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setVrMode(boolean r100) {
        logPlayer("SurfaceRenderView setVrMode from " + this.vrMode + " to " + r100, true);
        this.vrMode = r100;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setVrStyle(int r100) {
        logPlayer("SurfaceRenderView setVrStyle from " + this.vrStyle + " to " + r100, true);
        this.vrStyle = r100;
    }

    public void setWindowCrop(Rect r110) {
        if (Build.VERSION.SDK_INT >= 29) goto L12;
        return;
    L12:
        SurfaceControl r100 = getSurfaceControl();     // Catch: Exception -> L9
        SurfaceControl.Transaction r101 = new SurfaceControl.Transaction();     // Catch: Exception -> L9
        Method r102 = SurfaceControl.Transaction.class.getDeclaredMethod("setWindowCrop", new Class[]{SurfaceControl.class, Rect.class});     // Catch: Exception -> L9
        r102.setAccessible(true);     // Catch: Exception -> L9
        r102.invoke(r101, new Object[]{r100, r110});     // Catch: Exception -> L9
        r101.apply();     // Catch: Exception -> L9
        IPlayerLogger r111 = this.playerLogger;     // Catch: Exception -> L9
        if (r111 == null) goto L14;
        r111.logCallStack("surface view setWindowCrop");     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.toString();
    }

    public SurfaceRenderView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.textureLayout = 2;
        this.DEFAULT_RESOLUTION = 1.7777778f;
        this.mMeasureListenerSet = new HashSet();
        this.mLayoutListenerSet = new HashSet();
        this.mTranslationAndScaleListenerSet = new HashSet();
        this.foldScreenAdapter = false;
        this.mVisibilityChangeListenerSet = new HashSet();
        this.notVisibleTime = 0;
        this.currentLandscape = false;
        this.vrMode = true;
        this.vrStyle = 10000;
        this.hasOnceValidLayout = false;
        this.mSurfaceControlAttached = false;
        this.mSurfaceControlRenderListenerSet = new HashSet();
        this.drawFrameWhenSurfaceControlReplace = false;
    }

    private /* synthetic */ Unit lambda$drawLastFrame$0(Map r100, Bitmap r101) {
        if (r101 != null) goto L5;
    L11:
        return null;
    L5:
        if (r101.isRecycled() == true) goto L11;
        SurfaceHolder r102 = getHolder();     // Catch: Exception -> L9
        Canvas r103 = r102.lockCanvas();     // Catch: Exception -> L9
        r103.drawBitmap(r101, 0.0f, 0.0f, null);     // Catch: Exception -> L9
        r102.unlockCanvasAndPost(r103);     // Catch: Exception -> L9
        logPlayer("SurfaceRenderView drawLastFrame unlockCanvasAndPost", true);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        logPlayer("SurfaceRenderView drawLastFrame Exception" + e.getMessage(), true);
        goto L11
    }

    private void logPlayer(String r100, boolean r101) {
        IPlayerLogger r102 = this.playerLogger;
        if (r102 == null) goto L6;
        r102.logPlayerView("scene:" + getScene() + " " + r100, null, r101);
        return;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int r110, int r111) {
        int r100 = (getSuggestedMinimumWidth() + getPaddingLeft()) + getPaddingRight();
        int r101 = (getSuggestedMinimumHeight() + getPaddingTop()) + getPaddingBottom();
        int r102 = View.MeasureSpec.getMode(r110);
        int r112 = View.MeasureSpec.getSize(r110);
        int r103 = View.MeasureSpec.getMode(r111);
        int r113 = View.MeasureSpec.getSize(r111);
        if (r102 != 1073741824) goto L5;
        r100 = r112;
    L7:
        if (r103 != 1073741824) goto L9;
        r101 = r113;
    L11:
        boolean r114 = true;
        logPlayer("textureLayout = " + this.textureLayout + ", vrStyle = " + this.vrStyle + ", vrMode = " + this.vrMode, true);
        int r115 = this.vrStyle;
        int r104 = -1;
        if (r115 != 10002) goto L41;
        if (this.vrMode == false) goto L41;
        View r116 = getDecorView();
        if (r116 != null) goto L18;
        int r105 = -1;
    L19:
        if (r116 == null) goto L22;
        r104 = r116.getHeight();
    L22:
        if (r105 > 0) goto L25;
        r105 = h.e();
    L25:
        if (r104 > 0) goto L28;
        r104 = h.d();
    L28:
        if (r105 <= r104) goto L30;
        boolean r117 = true;
    L31:
        boolean r106 = this.currentLandscape;
        if (r106 == false) goto L34;
        if (r117 == true) goto L34;
    L38:
        if (r114 == false) goto L114;
        int r118 = r104;
        r104 = r105;
        r105 = r118;
    L114:
        logPlayer("SurfaceRenderView onMeasure widthR:" + r105 + " heightR:" + r104 + " width: " + r100 + " height: " + r101 + "; widthMode : " + r102 + " heightMode : " + r103, false);
        Iterator<IRenderView.MeasureListener> r119 = this.mMeasureListenerSet.iterator();
    L116:
        if (r119.hasNext() == false) goto L118;
        r119.next().onMeasureReady(r105, r104, this.mVideoWidth, this.mVideoHeight);
        goto L116
    L118:
        setMeasuredDimension(r105, r104);
        return;
    L34:
        if (r106 == true) goto L37;
        if (r117 == true) goto L38;
    L37:
        r114 = false;
        goto L38
    L30:
        r117 = false;
        goto L31
    L18:
        r105 = r116.getWidth();
    L41:
        if (r115 == 10001) goto L43;
    L57:
        int r120 = this.textureLayout;
        if (r120 == 2) goto L103;
        int r107 = this.mVideoWidth;
        if (r107 == 0) goto L103;
        int r108 = this.mVideoHeight;
        if (r108 == 0) goto L103;
        if (r120 == 1) goto L100;
        if (r120 != 0) goto L82;
        int r121 = (int) (r108 * ((r100 * 1.0f) / r107));
        if (r108 > r107) goto L71;
        r114 = false;
    L71:
        if (r121 > r101) goto L73;
    L80:
        r104 = r121;
    L84:
        r105 = r100;
        goto L114
    L73:
        if (this.foldScreenAdapter == false) goto L78;
        if (r114 == true) goto L78;
        if (isPortraitOrientation() == true) goto L80;
    L78:
        float r122 = (r101 * 1.0f) / this.mVideoHeight;
        float r123 = this.mVideoWidth;
    L79:
        r105 = (int) (r123 * r122);
    L101:
        r104 = r101;
        goto L114
    L82:
        if (r120 != 3) goto L86;
        r104 = (int) (r108 * ((r100 * 1.0f) / r107));
        goto L84
    L86:
        if (r120 != 4) goto L92;
        StrictMeasureData r124 = this.strictMeasureData;
        if (r124 == null) goto L102;
        int r125 = r124.getWidth();
        int r126 = r124.getHeight();
    L90:
        r104 = r126;
        r105 = r125;
    L102:
        r105 = 0;
        r104 = 0;
        goto L114
    L92:
        if (r120 != 6) goto L99;
        DisplayRatio r127 = this.displayRatio;
        if (r127 == null) goto L99;
        RenderViewInfo r128 = DisplayRatio.calculateRenderViewInfo(r127, r107, r108);
        if (r128 == null) goto L102;
        r125 = r128.getViewWidth();
        r126 = r128.getViewHeight();
    L99:
        if (r120 != 5) goto L102;
    L100:
        r105 = r100;
    L103:
        float r129 = r101;
        float r130 = r100;
        float r109 = r129 / r130;
        int r131 = this.mVideoWidth;
        if (r131 == 0) goto L109;
        int r132 = this.mVideoHeight;
        if (r132 == 0) goto L109;
        float r133 = r132 / r131;
    L111:
        if (r133 <= r109) goto L113;
        r121 = (int) (r132 * ((r130 * 1.0f) / r131));
        goto L80
    L113:
        r122 = (r129 * 1.0f) / r132;
        r123 = r131;
    L109:
        r133 = 1.7777778f;
        r131 = 9;
        r132 = 16;
        goto L111
    L43:
        if (this.vrMode == false) goto L57;
        View r134 = getDecorView();
        if (r134 != null) goto L47;
        int r135 = -1;
    L48:
        if (r134 == null) goto L51;
        r104 = r134.getHeight() - g.a(getContext());
    L51:
        if (r135 <= 0) goto L53;
        r105 = r135;
    L54:
        if (r104 > 0) goto L114;
        r104 = h.d();
        goto L114
    L53:
        r105 = h.e();
        goto L54
    L47:
        r135 = r134.getWidth();
        goto L48
    L9:
        if (r103 != Integer.MIN_VALUE) goto L11;
        r101 = Math.min(r101, r113);
        goto L11
    L5:
        if (r102 != Integer.MIN_VALUE) goto L7;
        r100 = Math.min(r100, r112);
        goto L7
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        Iterator<IRenderView.VisibilityChangeListener> r102 = this.mVisibilityChangeListenerSet.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onVisibilityChange(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setVideoSize(int r100, int r101) {
        logPlayer("SurfaceRenderView setVideoSize width:" + r100 + " height:" + r101, true);
        if (r100 <= 0) goto L7;
        if (r101 <= 0) goto L8;
        this.mVideoWidth = r100;
        this.mVideoHeight = r101;
        requestLayout();
        return;
    L8:
        return;
    }

    public SurfaceRenderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.textureLayout = 2;
        this.DEFAULT_RESOLUTION = 1.7777778f;
        this.mMeasureListenerSet = new HashSet();
        this.mLayoutListenerSet = new HashSet();
        this.mTranslationAndScaleListenerSet = new HashSet();
        this.foldScreenAdapter = false;
        this.mVisibilityChangeListenerSet = new HashSet();
        this.notVisibleTime = 0;
        this.currentLandscape = false;
        this.vrMode = true;
        this.vrStyle = 10000;
        this.hasOnceValidLayout = false;
        this.mSurfaceControlAttached = false;
        this.mSurfaceControlRenderListenerSet = new HashSet();
        this.drawFrameWhenSurfaceControlReplace = false;
    }

    public SurfaceRenderView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.textureLayout = 2;
        this.DEFAULT_RESOLUTION = 1.7777778f;
        this.mMeasureListenerSet = new HashSet();
        this.mLayoutListenerSet = new HashSet();
        this.mTranslationAndScaleListenerSet = new HashSet();
        this.foldScreenAdapter = false;
        this.mVisibilityChangeListenerSet = new HashSet();
        this.notVisibleTime = 0;
        this.currentLandscape = false;
        this.vrMode = true;
        this.vrStyle = 10000;
        this.hasOnceValidLayout = false;
        this.mSurfaceControlAttached = false;
        this.mSurfaceControlRenderListenerSet = new HashSet();
        this.drawFrameWhenSurfaceControlReplace = false;
    }

    @Override // android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        Iterator<IRenderView.LayoutListener> r105 = this.mLayoutListenerSet.iterator();
    L4:
        if (r105.hasNext() == false) goto L7;
        r105.next().onLayoutReady(r101, r102, r103, r104);
        goto L4
    L7:
        if (this.mVideoWidth != 0) goto L9;
        return;
    L9:
        if (this.mVideoHeight == 0) goto L14;
        this.hasOnceValidLayout = true;
        return;
    }
}
