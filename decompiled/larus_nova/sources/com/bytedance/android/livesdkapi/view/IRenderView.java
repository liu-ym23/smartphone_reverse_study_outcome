package com.bytedance.android.livesdkapi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Pair;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.livesdkapi.model.DisplayRatio;
import com.bytedance.android.livesdkapi.model.StrictMeasureData;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;

/* JADX INFO: loaded from: classes12.dex */
public interface IRenderView {
    public static final int BOTTOM_MARGIN = 7;
    public static final int CENTER_CROP = 2;
    public static final int CENTER_INSIDE = 0;
    public static final int DISPLAY_RATIO = 6;
    public static final int FILL_PARENT = 1;
    public static final int FIT_WIDTH = 3;
    public static final int STRICT = 4;
    public static final int VR = 5;
    public static final int VR_LANDSCAPE = 10002;
    public static final int VR_NO_VR = 10000;
    public static final int VR_PORTRAIT = 10001;

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.view.IRenderView$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isLayoutVideoSizeValid(IRenderView r100) {
            return true;
        }

        public static void $default$setStrictMeasureData(IRenderView r100, StrictMeasureData r101) {
        }
    }

    public interface LayoutListener {
        void onLayoutReady(int r100, int r101, int r102, int r103);
    }

    public interface MeasureListener {
        void onMeasureReady(int r100, int r101, int r102, int r103);
    }

    public static final enum RenderViewType extends Enum<RenderViewType> {
        private static final /* synthetic */ RenderViewType[] $VALUES = null;
        public static final RenderViewType KEEP_TEXTURE_RENDER_VIEW = null;
        public static final RenderViewType SURFACE_VIEW = null;
        public static final RenderViewType TEXTURE_VIEW = null;

        static {
            RenderViewType r100 = new RenderViewType("TEXTURE_VIEW", 0);
            TEXTURE_VIEW = r100;
            RenderViewType r101 = new RenderViewType("SURFACE_VIEW", 1);
            SURFACE_VIEW = r101;
            RenderViewType r102 = new RenderViewType("KEEP_TEXTURE_RENDER_VIEW", 2);
            KEEP_TEXTURE_RENDER_VIEW = r102;
            $VALUES = new RenderViewType[]{r100, r101, r102};
        }

        public static RenderViewType[] values() {
            return (RenderViewType[]) $VALUES.clone();
        }

        public static RenderViewType valueOf(String r100) {
            return (RenderViewType) r27.a.a(RenderViewType.class, r100);
        }

        private RenderViewType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface TranslationAndScaleListener {
        void onTranslationAndScaleChange(float r100, float r101, float r102, float r103);
    }

    public interface VisibilityChangeListener {
        void onVisibilityChange(View r100, int r101);
    }

    void addRenderViewLayoutListener(LayoutListener r100);

    void addRenderViewMeasureListener(MeasureListener r100);

    void addTranslationAndScaleListener(TranslationAndScaleListener r100);

    Bitmap getBitmap();

    Context getContext();

    DisplayRatio getDisplayRatio();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    Pair<Integer, Integer> getMeasuredSize();

    long getNotVisibleTime();

    ViewParent getParent();

    int getScaleType();

    View getSelfView();

    SurfaceHolder getSurfaceHolder();

    SurfaceTexture getSurfaceTexture();

    int getVisibility();

    int getWidth();

    boolean isLayoutVideoSizeValid();

    void removeRenderViewLayoutListener(LayoutListener r100);

    void removeRenderViewMeasureListener(MeasureListener r100);

    void removeTranslationAndScaleListener(TranslationAndScaleListener r100);

    void reset();

    void setCurrentLandscape(boolean r100);

    void setDisplayRatio(DisplayRatio r100);

    void setLayoutParams(ViewGroup.LayoutParams r100);

    void setPlayerLogger(IPlayerLogger r100);

    void setScaleType(int r100);

    void setStrictMeasureData(StrictMeasureData r100);

    void setVideoSize(int r100, int r101);

    void setVisibility(int r100);

    void setVrMode(boolean r100);

    void setVrStyle(int r100);
}
