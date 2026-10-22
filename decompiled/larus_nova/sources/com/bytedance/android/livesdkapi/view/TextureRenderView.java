package com.bytedance.android.livesdkapi.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.SurfaceHolder;
import android.view.TextureView;
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
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public class TextureRenderView extends TextureView implements IRenderView {
    private final float DEFAULT_RESOLUTION;
    private boolean currentLandscape;
    private DisplayRatio displayRatio;
    private boolean foldScreenAdapter;
    private boolean hasOnceValidLayout;
    private Set<IRenderView.LayoutListener> mLayoutListenerSet;
    private Set<IRenderView.MeasureListener> mMeasureListenerSet;
    private Set<IRenderView.TranslationAndScaleListener> mTranslationAndScaleListenerSet;
    private int mVideoHeight;
    private int mVideoWidth;
    private Set<IRenderView.VisibilityChangeListener> mVisibilityChangeListenerSet;
    private long notVisibleTime;
    private IPlayerLogger playerLogger;
    private StrictMeasureData strictMeasureData;
    private int textureLayout;
    private boolean vrMode;
    private int vrStyle;

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public View getSelfView() {
        return this;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public SurfaceHolder getSurfaceHolder() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void reset() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.textureLayout = 2;
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

    private View getDecorView() {
        Context r100 = getContext();
        if ((r100 instanceof Activity) == true) goto L5;
        return null;
    L5:
        Window r101 = ((Activity) r100).getWindow();
        if (r101 != null) goto L9;
        return null;
    L9:
        return INVOKEVIRTUAL_com_bytedance_android_livesdkapi_view_TextureRenderView_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101);
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

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        logPlayer("TextureRenderView onDetachedFromWindow", false);
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

    public int getTextureLayout() {
        return this.textureLayout;
    }

    public TextureRenderView(Context r100) {
        super(r100);
        this.textureLayout = 2;
        this.DEFAULT_RESOLUTION = 1.7777778f;
        this.mMeasureListenerSet = new HashSet();
        this.mLayoutListenerSet = new HashSet();
        this.mTranslationAndScaleListenerSet = new HashSet();
        this.mVisibilityChangeListenerSet = new HashSet();
        this.foldScreenAdapter = false;
        this.notVisibleTime = 0;
        this.currentLandscape = false;
        this.vrMode = true;
        this.vrStyle = 10000;
        this.hasOnceValidLayout = false;
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_livesdkapi_view_TextureRenderView_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
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

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void addTranslationAndScaleListener(IRenderView.TranslationAndScaleListener r100) {
        this.mTranslationAndScaleListenerSet.add(r100);
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

    @Override // android.view.View, com.bytedance.android.livesdkapi.view.IRenderView
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        super.setLayoutParams(r100);
        IPlayerLogger r101 = this.playerLogger;
        if (r101 == null) goto L6;
        r101.logCallStack("texture view set layout params");
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
        if (r100 == 4) goto L6;
        this.strictMeasureData = null;
    L6:
        if (r100 == 6) goto L8;
        this.displayRatio = null;
    L8:
        logPlayer("TextureRenderView setScaleType: " + r100, true);
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

    @Override // android.view.View, com.bytedance.android.livesdkapi.view.IRenderView
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 == 0) goto L5;
        this.notVisibleTime = SystemClock.elapsedRealtime();
    L5:
        logPlayer("setVisibility " + r100, false);
        IPlayerLogger r101 = this.playerLogger;
        if (r101 == null) goto L9;
        r101.logCallStack("TextureRenderView.setVisibility: " + Integer.toString(r100));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setVrMode(boolean r100) {
        this.vrMode = r100;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setVrStyle(int r100) {
        this.vrStyle = r100;
    }

    public TextureRenderView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.textureLayout = 2;
        this.DEFAULT_RESOLUTION = 1.7777778f;
        this.mMeasureListenerSet = new HashSet();
        this.mLayoutListenerSet = new HashSet();
        this.mTranslationAndScaleListenerSet = new HashSet();
        this.mVisibilityChangeListenerSet = new HashSet();
        this.foldScreenAdapter = false;
        this.notVisibleTime = 0;
        this.currentLandscape = false;
        this.vrMode = true;
        this.vrStyle = 10000;
        this.hasOnceValidLayout = false;
    }

    private void logPlayer(String r100, boolean r101) {
        IPlayerLogger r102 = this.playerLogger;
        if (r102 == null) goto L6;
        r102.logPlayerView(r100, null, r101);
        return;
    }

    @Override // android.view.View
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
        int r114 = this.vrStyle;
        boolean r104 = true;
        int r105 = -1;
        if (r114 != 10002) goto L43;
        if (this.vrMode == false) goto L43;
        View r115 = getDecorView();
        if (r115 != null) goto L18;
        int r116 = -1;
    L19:
        if (r115 == null) goto L22;
        r105 = r115.getHeight();
    L22:
        if (r116 > 0) goto L25;
        r116 = h.e();
    L25:
        if (r105 > 0) goto L28;
        r105 = h.d();
    L28:
        if (r116 <= r105) goto L30;
        boolean r117 = true;
    L31:
        boolean r106 = this.currentLandscape;
        if (r106 == false) goto L34;
        if (r117 == true) goto L34;
    L38:
        if (r104 == false) goto L40;
        r101 = r116;
        r100 = r105;
    L110:
        logPlayer("TextureRenderView onMeasure width:" + r100 + " height:" + r101 + " ; widthMode : " + r102 + " heightMode : " + r103 + "hash:" + hashCode(), false);
        Iterator<IRenderView.MeasureListener> r118 = this.mMeasureListenerSet.iterator();
    L112:
        if (r118.hasNext() == false) goto L114;
        r118.next().onMeasureReady(r100, r101, this.mVideoWidth, this.mVideoHeight);
        goto L112
    L114:
        setMeasuredDimension(r100, r101);
        return;
    L40:
        r100 = r116;
    L41:
        r101 = r105;
    L34:
        if (r106 == true) goto L37;
        if (r117 == true) goto L38;
    L37:
        r104 = false;
        goto L38
    L30:
        r117 = false;
        goto L31
    L18:
        r116 = r115.getWidth();
    L43:
        if (r114 == 10001) goto L45;
    L60:
        int r119 = this.textureLayout;
        if (r119 == 2) goto L99;
        int r120 = this.mVideoWidth;
        if (r120 == 0) goto L99;
        int r107 = this.mVideoHeight;
        if (r107 == 0) goto L99;
        if (r119 == 1) goto L110;
        if (r119 != 0) goto L84;
        int r121 = (int) (r107 * ((r100 * 1.0f) / r120));
        if (r107 > r120) goto L74;
        r104 = false;
    L74:
        if (r121 > r101) goto L76;
    L59:
        r101 = r121;
        goto L110
    L76:
        if (this.foldScreenAdapter == false) goto L81;
        if (r104 == true) goto L81;
        if (isPortraitOrientation() == true) goto L59;
    L81:
        float r122 = (r101 * 1.0f) / this.mVideoHeight;
        float r123 = this.mVideoWidth;
    L82:
        r100 = (int) (r123 * r122);
        goto L110
    L84:
        if (r119 != 3) goto L87;
        r101 = (int) (r107 * ((r100 * 1.0f) / r120));
        goto L110
    L87:
        if (r119 != 4) goto L92;
        StrictMeasureData r124 = this.strictMeasureData;
        if (r124 == null) goto L98;
        int r125 = r124.getWidth();
        r101 = r124.getHeight();
        r100 = r125;
    L98:
        r100 = 0;
        r101 = 0;
        goto L110
    L92:
        if (r119 != 6) goto L98;
        DisplayRatio r126 = this.displayRatio;
        if (r126 == null) goto L98;
        RenderViewInfo r127 = DisplayRatio.calculateRenderViewInfo(r126, r120, r107);
        if (r127 == null) goto L98;
        r100 = r127.getViewWidth();
        r101 = r127.getViewHeight();
    L99:
        float r128 = r101;
        float r129 = r100;
        float r108 = r128 / r129;
        int r109 = this.mVideoWidth;
        if (r109 == 0) goto L105;
        int r130 = this.mVideoHeight;
        if (r130 == 0) goto L105;
        float r131 = r130 / r109;
    L107:
        if (r131 <= r108) goto L109;
        r101 = (int) (r130 * ((r129 * 1.0f) / r109));
        goto L110
    L109:
        r122 = (r128 * 1.0f) / r130;
        r123 = r109;
    L105:
        r131 = 1.7777778f;
        r109 = 9;
        r130 = 16;
        goto L107
    L45:
        if (this.vrMode == false) goto L60;
        View r132 = getDecorView();
        if (r132 != null) goto L49;
        int r133 = -1;
    L50:
        if (r132 == null) goto L53;
        r105 = r132.getHeight() - g.a(getContext());
    L53:
        if (r133 <= 0) goto L55;
        r100 = r133;
    L56:
        if (r105 > 0) goto L41;
        r121 = h.d();
        goto L59
    L55:
        r100 = h.e();
        goto L56
    L49:
        r133 = r132.getWidth();
        goto L50
    L9:
        if (r103 != Integer.MIN_VALUE) goto L11;
        r101 = Math.min(r101, r113);
        goto L11
    L5:
        if (r102 != Integer.MIN_VALUE) goto L7;
        r100 = Math.min(r100, r112);
        goto L7
    }

    @Override // android.view.TextureView, android.view.View
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
        logPlayer("TextureRenderView setVideoSize width:" + r100 + " height:" + r101, true);
        if (r100 <= 0) goto L7;
        if (r101 <= 0) goto L8;
        this.mVideoWidth = r100;
        this.mVideoHeight = r101;
        requestLayout();
        return;
    L8:
        return;
    }

    public TextureRenderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.textureLayout = 2;
        this.DEFAULT_RESOLUTION = 1.7777778f;
        this.mMeasureListenerSet = new HashSet();
        this.mLayoutListenerSet = new HashSet();
        this.mTranslationAndScaleListenerSet = new HashSet();
        this.mVisibilityChangeListenerSet = new HashSet();
        this.foldScreenAdapter = false;
        this.notVisibleTime = 0;
        this.currentLandscape = false;
        this.vrMode = true;
        this.vrStyle = 10000;
        this.hasOnceValidLayout = false;
    }

    public TextureRenderView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.textureLayout = 2;
        this.DEFAULT_RESOLUTION = 1.7777778f;
        this.mMeasureListenerSet = new HashSet();
        this.mLayoutListenerSet = new HashSet();
        this.mTranslationAndScaleListenerSet = new HashSet();
        this.mVisibilityChangeListenerSet = new HashSet();
        this.foldScreenAdapter = false;
        this.notVisibleTime = 0;
        this.currentLandscape = false;
        this.vrMode = true;
        this.vrStyle = 10000;
        this.hasOnceValidLayout = false;
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
