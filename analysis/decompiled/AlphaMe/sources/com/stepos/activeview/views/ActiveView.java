package com.stepos.activeview.views;

import B0.g;
import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.PathInterpolator;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import ch.qos.logback.core.net.SyslogConstants;
import com.airbnb.lottie.LottieComposition;
import com.stepos.activeview.databinding.BindingContainer;
import com.stepos.activeview.databinding.VariableContainer;
import com.stepos.activeview.databinding.model.DataBindingWrapper;
import com.stepos.activeview.download.GetActInterface;
import com.stepos.activeview.download.GetActManager;
import com.stepos.activeview.elements.ActiveAnimation;
import com.stepos.activeview.elements.ActiveTextView;
import com.stepos.activeview.elements.GLImageView;
import com.stepos.activeview.elements.GLTextureView;
import com.stepos.activeview.elements.GifMovieView;
import com.stepos.activeview.elements.LottieView;
import com.stepos.activeview.elements.ParticleView;
import com.stepos.activeview.elements.StatesImageView;
import com.stepos.activeview.elements.TextureVideoView;
import com.stepos.activeview.handler.EventHandler;
import com.stepos.activeview.json.ActiveData;
import com.stepos.activeview.json.ApertureData;
import com.stepos.activeview.json.Args;
import com.stepos.activeview.json.ButtonState;
import com.stepos.activeview.json.CustomEvent;
import com.stepos.activeview.json.Element;
import com.stepos.activeview.json.Event;
import com.stepos.activeview.json.Interpolator;
import com.stepos.activeview.json.LayerAni;
import com.stepos.activeview.json.Orientation;
import com.stepos.activeview.json.Page;
import com.stepos.activeview.json.Parallax;
import com.stepos.activeview.json.Parameter;
import com.stepos.activeview.json.Particle2DAttr;
import com.stepos.activeview.json.SeekBarAttrs;
import com.stepos.activeview.json.StatesButtonAttrs;
import com.stepos.activeview.json.Style;
import com.stepos.activeview.json.VideoAttr;
import com.stepos.activeview.json.WaveData;
import com.stepos.activeview.listener.OnAsyncTaskListener;
import com.stepos.activeview.listener.OnEventListener;
import com.stepos.activeview.listener.OnLayerAniListener;
import com.stepos.activeview.listener.OnLoadImageListener;
import com.stepos.activeview.listener.OnOrientationAnimationListener;
import com.stepos.activeview.listener.OnParallaxListener;
import com.stepos.activeview.listener.OnUpdateListener;
import com.stepos.activeview.listener.OnVersionListener;
import com.stepos.activeview.moveline.AnimationListener;
import com.stepos.activeview.moveline.Timeline;
import com.stepos.activeview.moveline.TimelineTicker;
import com.stepos.activeview.moveline.item.FrameStyle;
import com.stepos.activeview.moveline.item.GLImageViewTweenItem;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.activeview.task.LoadImageTask;
import com.stepos.activeview.task.LoadLottieAnimationTask;
import com.stepos.activeview.task.ReleaseVideoTask;
import com.stepos.activeview.texture.GLBaseRender;
import com.stepos.activeview.texture.GLImageRender;
import com.stepos.activeview.utils.ActiveUsageStatsUtils;
import com.stepos.activeview.utils.BitmapUtils;
import com.stepos.activeview.utils.CacheUtils;
import com.stepos.activeview.utils.FileUtil;
import com.stepos.activeview.utils.ImageCache;
import com.stepos.activeview.utils.ImageCacheUtils;
import com.stepos.activeview.utils.LogUtil;
import com.stepos.activeview.utils.UpdaterUtils;
import com.stepos.activeview.utils.Utility;
import com.stepos.activeview.version.Version;
import com.stepos.alphame.utils.Property;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ActiveView extends FrameLayout implements GetActInterface {
    private static final String ACTIVE_TIMELINE_KEY = "active_view_timeline";
    static final String ELEMENT_BUTTON = "button";
    static final String ELEMENT_GIF = "gif";
    static final String ELEMENT_GLIMAGE = "glimage";
    static final String ELEMENT_GROUP = "group";
    static final String ELEMENT_IMAGE = "image";
    static final String ELEMENT_LOTTIE = "lottie";
    static final String ELEMENT_PARTICLE2D = "particle2D";
    static final String ELEMENT_SEEKBAR = "seekBar";
    static final String ELEMENT_STATES_BUTTON = "statesButton";
    static final String ELEMENT_TEXT = "text";
    static final String ELEMENT_TEXTURE = "texture";
    static final String ELEMENT_VIDEO = "video";
    private static final String INTERPOLATOR_TYPE_LINEAR = "linear";
    private static final String INTERPOLATOR_TYPE_SHAKE = "shake";
    private static final String LOAD_VIDEO_FROM_URL = "load_video_from_url";
    public static final String LOG_TAG = "activeview.ActiveView";
    private static final String TEXT_HEIGHT_WRACONTENT_VERSION = "2.0.0";
    private static final String VIEW_IMAGEVIEW = "imageview";
    private static final String VIEW_TEXTVIEW = "textview";
    private int ActiveViewHeight;
    private int ActiveViewWidth;
    private boolean isLoadFromCache;
    private ActiveData mActiveData;
    private HashMap<String, ActiveAnimation> mAnimations;
    private boolean mAutoDeleteFolder;
    private boolean mAutoGradientDisplay;
    private boolean mAutoReleaseVideo;
    private boolean mAutoRunAnim;
    private AlphaAnimation mAutpAlphaAnimation;
    private BindingContainer mBindingContainer;
    protected boolean mCanReverseAnimaion;
    private int mColorPrimary;
    private Context mContext;
    private HashMap<String, ArrayList<Timeline>> mCustomEventMap;
    private FrameLayout.LayoutParams mDefaultImageLayoutParams;
    private ImageView mDefaultImageView;
    private Animation.AnimationListener mDefaultImgAnimListener;
    private boolean mEnableOrientationAnim;
    private int mFolderHours;
    private boolean mHasApproachAnim;
    private boolean mHasDataBinding;
    private boolean mHasDefaultImage;
    private ImageView mImageView;
    private AnimationListener mInnerAnimationListener;
    private ArrayList<LayerAniData> mLayerAniData;
    private HashMap<AsyncTask, Boolean> mLoadResTaskMap;
    private boolean mMeasured;
    private int mMeasuredWidth;
    private Handler mMsgHandler;
    private OnEventListener mOnEventListener;
    private OnLayerAniListener mOnLayerAniListener;
    private OnLoadImageListener mOnLoadImageListener;
    private OnOrientationAnimationListener mOnOrientationAnimationListener;
    private OnParallaxListener mOnParallaxListener;
    private OnUpdateListener mOnUpdateListener;
    private ArrayList<OrientationData> mOrientationData;
    private ArrayList<ParallaxData> mParallaxData;
    private boolean mResourceLoaded;
    private float mScaleRate;
    private boolean mShowAfterImagesLoaded;
    private TextureVideoView mSimpleVideoView;
    private HashMap<String, TextureVideoView> mTextureVideoView;
    private Timeline mTimeline;
    private HashMap<String, Timeline> mTimelineMap;
    private HashMap<View, ViewTweenItem> mTweenItemMap;
    private String mUrl;
    private boolean mUseLayerAni;
    private boolean mUseParallax;
    private VariableContainer mVariableContainer;
    private HashMap<String, ViewElementData> mViewElementCacheMap;
    private WebView mWebView;
    private String zipExtractedDir;

    public static class InnerAnimationListener implements AnimationListener {
        private WeakReference<ActiveView> ref;

        public InnerAnimationListener(ActiveView activeView) {
            if (activeView != null) {
                this.ref = new WeakReference<>(activeView);
            }
        }

        @Override // com.stepos.activeview.moveline.AnimationListener
        public void onAnimationEnd(com.stepos.activeview.moveline.Animation animation) {
            ActiveView activeView;
            WeakReference<ActiveView> weakReference = this.ref;
            if (weakReference == null || (activeView = weakReference.get()) == null) {
                return;
            }
            activeView.updateOrientationData();
        }

        @Override // com.stepos.activeview.moveline.AnimationListener
        public void onAnimationStart(com.stepos.activeview.moveline.Animation animation) {
        }

        @Override // com.stepos.activeview.moveline.AnimationListener
        public void onAnimationStopped(com.stepos.activeview.moveline.Animation animation) {
        }
    }

    public class LayerAniData {
        Float[] mRange;
        View mView;

        private LayerAniData(ActiveView activeView) {
        }

        public /* synthetic */ LayerAniData(ActiveView activeView, int i4) {
            this(activeView);
        }
    }

    public class OrientationData {
        Float[] mAngles;
        Float mMaxEndAngle;
        Float[] mRange;
        String mType;
        View mView;

        private OrientationData(ActiveView activeView) {
        }

        public /* synthetic */ OrientationData(ActiveView activeView, int i4) {
            this(activeView);
        }
    }

    public class ParallaxData {
        Float[] mRange;
        View mView;

        private ParallaxData(ActiveView activeView) {
        }

        public /* synthetic */ ParallaxData(ActiveView activeView, int i4) {
            this(activeView);
        }
    }

    public class ViewElementData {
        Element mElementData;
        View mView;
        String mViewType;

        private ViewElementData(ActiveView activeView) {
        }

        public /* synthetic */ ViewElementData(ActiveView activeView, int i4) {
            this(activeView);
        }
    }

    public ActiveView(Context context) {
        super(context);
        this.mTimelineMap = new HashMap<>();
        this.mCustomEventMap = new HashMap<>();
        this.mAnimations = new HashMap<>();
        this.mTextureVideoView = new HashMap<>();
        this.mTweenItemMap = new HashMap<>();
        this.mLoadResTaskMap = new HashMap<>();
        this.mViewElementCacheMap = new HashMap<>();
        this.mScaleRate = 1.0f;
        this.mMeasuredWidth = 0;
        this.ActiveViewWidth = 0;
        this.ActiveViewHeight = 0;
        this.mMeasured = false;
        this.mAutoRunAnim = true;
        this.mAutoGradientDisplay = false;
        this.mUseParallax = true;
        this.mUseLayerAni = true;
        this.mEnableOrientationAnim = false;
        this.mShowAfterImagesLoaded = false;
        this.mResourceLoaded = false;
        this.mAutoDeleteFolder = true;
        this.mFolderHours = SyslogConstants.LOG_LOCAL5;
        this.mCanReverseAnimaion = true;
        this.mHasApproachAnim = false;
        this.mAutoReleaseVideo = true;
        this.mHasDefaultImage = false;
        this.isLoadFromCache = false;
        this.mDefaultImgAnimListener = null;
        init(context);
    }

    private void activeCustomEvent(CustomEvent customEvent) {
        ArrayList<Timeline> arrayList = this.mCustomEventMap.get(customEvent.getKey());
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            Timeline timeline = new Timeline();
            arrayList.add(timeline);
            for (com.stepos.activeview.json.Animation animation : customEvent.getAnimations()) {
                View view = this.mViewElementCacheMap.get(animation.getElementId()).mView;
                ViewTweenItem gLImageViewTweenItem = this.mTweenItemMap.get(view);
                if (gLImageViewTweenItem == null) {
                    gLImageViewTweenItem = new GLImageViewTweenItem(view);
                    this.mTweenItemMap.put(view, gLImageViewTweenItem);
                }
                FrameStyle frameStyleBuildFrameStyle = gLImageViewTweenItem.buildFrameStyle();
                initFrameStyle(frameStyleBuildFrameStyle, animation, view);
                if (animation.isRepeat()) {
                    Timeline timeline2 = new Timeline();
                    timeline2.setRepeatCount(animation.getRepeatCount());
                    timeline2.setRepeatMode(animation.getRepeatMode());
                    timeline2.setDelayTime(animation.getStartTime());
                    putTween(timeline2, animation, gLImageViewTweenItem, frameStyleBuildFrameStyle);
                    arrayList.add(timeline2);
                } else {
                    putTween(timeline, animation, gLImageViewTweenItem, frameStyleBuildFrameStyle);
                }
            }
            this.mCustomEventMap.put(customEvent.getKey(), arrayList);
        }
        Iterator<Timeline> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().play();
        }
    }

    private float calScaleRate(float f4) {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i4 = displayMetrics.widthPixels;
        int i5 = this.mMeasuredWidth;
        return f4 / ((i5 == 0 || f4 == Property.DEFAULT_FLOAT_VALUE) ? i4 : i5);
    }

    private void cancelLoadData() {
        GetActManager.GetActRequest request = GetActManager.getInstance().getRequest(this.mUrl);
        if (request == null && this.isLoadFromCache) {
            request = GetActManager.getInstance().getRequest(this.zipExtractedDir);
        }
        if (request == null || request.removeWaitActiveView(this) != 0) {
            return;
        }
        GetActManager.getInstance().removeRequest(request.getRequestString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearActiveView() {
        cancelAllRunningTasks();
        stopAnimation();
        reset();
        removeAllViews();
        if (!this.isLoadFromCache && this.mHasDefaultImage) {
            addView(this.mDefaultImageView);
        }
        HashMap<String, ViewElementData> map = this.mViewElementCacheMap;
        if (map != null) {
            map.clear();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.stepos.activeview.elements.ParticleView create2DParticleView(com.stepos.activeview.json.Particle2DAttr r11) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.views.ActiveView.create2DParticleView(com.stepos.activeview.json.Particle2DAttr):com.stepos.activeview.elements.ParticleView");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.stepos.activeview.elements.LottieView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.View, com.stepos.activeview.elements.GLTextureView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v3, types: [com.stepos.activeview.elements.StatesImageView] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8 */
    private void createElements(View view, List<Element> list) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String str;
        String str2;
        String str3;
        String str4;
        int i4;
        boolean z4;
        View view2;
        View imageView;
        View view3;
        View view4;
        View view5 = view;
        List<Element> list2 = list;
        String str5 = LOG_TAG;
        if (list2 == null) {
            LogUtil.e(LOG_TAG, "elementsList is NULL!");
            return;
        }
        int size = list.size();
        LogUtil.i(LOG_TAG, "elementSize = " + size);
        int i5 = 0;
        while (i5 < size) {
            Element element = list2.get(i5);
            if (element == null) {
                LogUtil.e(str5, "element == null");
            } else {
                String type = element.getType();
                if (type == null) {
                    LogUtil.e(str5, "elementType == null");
                } else {
                    LogUtil.i(str5, "elementType =".concat(type));
                    type.hashCode();
                    str = ELEMENT_GROUP;
                    switch (type) {
                        case "texture":
                            str2 = ELEMENT_GROUP;
                            str3 = type;
                            str4 = str5;
                            i4 = size;
                            ?? gLTextureView = new GLTextureView(this.mContext);
                            gLTextureView.setInnnerSurfaceChangedListener(new GLBaseRender(this.mContext, g.r(new StringBuilder(), this.zipExtractedDir, "/texture/vertex2.sh"), g.r(new StringBuilder(), this.zipExtractedDir, "/texture/star.glsl"), g.r(new StringBuilder(), this.zipExtractedDir, "/texture/noise.png")));
                            gLTextureView.requestFocus();
                            z4 = true;
                            gLTextureView.setFocusableInTouchMode(true);
                            this.mAnimations.put(element.getId(), gLTextureView);
                            view3 = gLTextureView;
                            break;
                        case "button":
                            str2 = ELEMENT_GROUP;
                            str3 = type;
                            i4 = size;
                            str4 = str5;
                            LogUtil.i(str4, "Element[" + i5 + "]: Button is Created ! elementSize");
                            view2 = null;
                            z4 = true;
                            view3 = view2;
                            break;
                        case "lottie":
                            str2 = ELEMENT_GROUP;
                            str3 = type;
                            i4 = size;
                            final ?? lottieView = new LottieView(this.mContext);
                            this.mAnimations.put(element.getId(), lottieView);
                            loadLottie(element.getJsonPath(), new OnAsyncTaskListener() { // from class: com.stepos.activeview.views.ActiveView.7
                                @Override // com.stepos.activeview.listener.OnAsyncTaskListener
                                public void onLoadFinished(AsyncTask asyncTask, Object obj) throws IllegalArgumentException {
                                    LottieView lottieView2;
                                    LottieComposition lottieComposition = (LottieComposition) obj;
                                    if (lottieComposition == null || (lottieView2 = lottieView) == null) {
                                        return;
                                    }
                                    lottieView2.setContentComposition(lottieComposition);
                                    lottieView.loop(true);
                                    ActiveView.this.setLoadResFinished(asyncTask);
                                }
                            });
                            str4 = str5;
                            view2 = lottieView;
                            z4 = true;
                            view3 = view2;
                            break;
                        case "statesButton":
                            Object statesImageView = new StatesImageView(this.mContext);
                            StatesButtonAttrs statesButtonAttrs = element.getStatesButtonAttrs();
                            if (statesButtonAttrs != null) {
                                List<ButtonState> states = statesButtonAttrs.getStates();
                                String[] strArr = new String[states.size()];
                                Drawable[] drawableArr = new Drawable[states.size()];
                                float[] rectRegion = element.getRectRegion(this.mContext);
                                final int[] iArr = {0};
                                int i6 = 0;
                                while (i6 < states.size()) {
                                    strArr[i6] = states.get(i6).getState();
                                    String icon = states.get(i6).getIcon();
                                    float f4 = rectRegion[2];
                                    float f5 = this.mScaleRate;
                                    final int i7 = i6;
                                    final Drawable[] drawableArr2 = drawableArr;
                                    final String[] strArr2 = strArr;
                                    String str6 = str;
                                    final List<ButtonState> list3 = states;
                                    List<ButtonState> list4 = states;
                                    final StatesImageView statesImageView2 = statesImageView;
                                    loadImage(icon, f4 / f5, rectRegion[3] / f5, new OnAsyncTaskListener() { // from class: com.stepos.activeview.views.ActiveView.11
                                        @Override // com.stepos.activeview.listener.OnAsyncTaskListener
                                        public void onLoadFinished(AsyncTask asyncTask, Object obj) throws IllegalArgumentException {
                                            drawableArr2[i7] = new BitmapDrawable(ActiveView.this.mContext.getResources(), (Bitmap) obj);
                                            int[] iArr2 = iArr;
                                            iArr2[0] = iArr2[0] + 1;
                                            ActiveView.this.setLoadResFinished(asyncTask);
                                            if (iArr[0] == list3.size()) {
                                                statesImageView2.setStates(strArr2, drawableArr2);
                                            }
                                        }
                                    });
                                    i6 = i7 + 1;
                                    type = type;
                                    states = list4;
                                    str5 = str5;
                                    size = size;
                                    drawableArr = drawableArr;
                                    strArr = strArr2;
                                    str = str6;
                                    statesImageView = statesImageView;
                                }
                            }
                            str2 = str;
                            i4 = size;
                            View view6 = statesImageView;
                            str3 = type;
                            str4 = str5;
                            view2 = view6;
                            z4 = true;
                            view3 = view2;
                            break;
                        case "gif":
                            View gifMovieView = new GifMovieView(this.mContext);
                            this.mAnimations.put(element.getId(), gifMovieView);
                            imageView = gifMovieView;
                            str2 = ELEMENT_GROUP;
                            str3 = type;
                            str4 = str5;
                            i4 = size;
                            view2 = imageView;
                            z4 = true;
                            view3 = view2;
                            break;
                        case "text":
                            ActiveTextView activeTextView = new ActiveTextView(this.mContext);
                            setTextAttrs(activeTextView, element);
                            imageView = activeTextView;
                            str2 = ELEMENT_GROUP;
                            str3 = type;
                            str4 = str5;
                            i4 = size;
                            view2 = imageView;
                            z4 = true;
                            view3 = view2;
                            break;
                        case "particle2D":
                            Particle2DAttr particle2DAttr = element.getParticle2DAttr();
                            if (particle2DAttr != null) {
                                ParticleView particleViewCreate2DParticleView = create2DParticleView(particle2DAttr);
                                this.mAnimations.put(element.getId(), particleViewCreate2DParticleView);
                                imageView = particleViewCreate2DParticleView;
                                str2 = ELEMENT_GROUP;
                                str3 = type;
                                str4 = str5;
                                i4 = size;
                                view2 = imageView;
                                z4 = true;
                                view3 = view2;
                                break;
                            } else {
                                LogUtil.e(str5, "particle2DAttr is NULL !");
                                str2 = ELEMENT_GROUP;
                                str3 = type;
                                str4 = str5;
                                i4 = size;
                                view2 = null;
                                z4 = true;
                                view3 = view2;
                            }
                        case "group":
                            FrameLayout frameLayout = new FrameLayout(this.mContext);
                            frameLayout.setClipChildren(false);
                            imageView = frameLayout;
                            str2 = ELEMENT_GROUP;
                            str3 = type;
                            str4 = str5;
                            i4 = size;
                            view2 = imageView;
                            z4 = true;
                            view3 = view2;
                            break;
                        case "image":
                            imageView = new ImageView(this.mContext);
                            str2 = ELEMENT_GROUP;
                            str3 = type;
                            str4 = str5;
                            i4 = size;
                            view2 = imageView;
                            z4 = true;
                            view3 = view2;
                            break;
                        case "video":
                            TextureVideoView textureVideoView = new TextureVideoView(this.mContext);
                            setVideoViewAttrs(textureVideoView, element);
                            if (!this.mAutoReleaseVideo) {
                                this.mTextureVideoView.put(element.getId(), textureVideoView);
                            }
                            this.mAnimations.put(element.getId(), textureVideoView);
                            imageView = textureVideoView;
                            str2 = ELEMENT_GROUP;
                            str3 = type;
                            str4 = str5;
                            i4 = size;
                            view2 = imageView;
                            z4 = true;
                            view3 = view2;
                            break;
                        case "glimage":
                            StringBuilder sbT = g.t("Element[", i5, "]: ImageView is Created ! Id=");
                            sbT.append(element.getId());
                            sbT.append(", url=");
                            sbT.append(element.getUrl());
                            LogUtil.i(str5, sbT.toString());
                            GLImageView gLImageView = new GLImageView(this.mContext);
                            gLImageView.setOpaque(false);
                            gLImageView.setScalRate(this.mScaleRate);
                            gLImageView.setSurfaceTextureListener(new GLImageRender());
                            setGLImageViewAttrs(gLImageView, element);
                            imageView = gLImageView;
                            str2 = ELEMENT_GROUP;
                            str3 = type;
                            str4 = str5;
                            i4 = size;
                            view2 = imageView;
                            z4 = true;
                            view3 = view2;
                            break;
                        case "seekBar":
                            final SeekBar seekBar = new SeekBar(this.mContext);
                            SeekBarAttrs seekBarAttrs = element.getSeekBarAttrs();
                            float[] rectRegion2 = element.getRectRegion(this.mContext);
                            final LayerDrawable layerDrawable = (LayerDrawable) seekBar.getProgressDrawable();
                            layerDrawable.setAutoMirrored(true);
                            loadImage(seekBarAttrs.getBackground(), -1.0f, -1.0f, new OnAsyncTaskListener() { // from class: com.stepos.activeview.views.ActiveView.8
                                @Override // com.stepos.activeview.listener.OnAsyncTaskListener
                                public void onLoadFinished(AsyncTask asyncTask, Object obj) throws IllegalArgumentException {
                                    if (obj instanceof Bitmap) {
                                        Bitmap bitmap = (Bitmap) obj;
                                        BitmapDrawable bitmapDrawable = new BitmapDrawable(ActiveView.this.mContext.getResources(), bitmap);
                                        bitmapDrawable.setTargetDensity(bitmap.getDensity());
                                        layerDrawable.setDrawableByLayerId(R.id.background, bitmapDrawable);
                                        Drawable.ConstantState constantState = layerDrawable.getConstantState();
                                        if (constantState == null) {
                                            seekBar.setProgressDrawable(layerDrawable);
                                        } else {
                                            seekBar.setProgressDrawable(constantState.newDrawable(ActiveView.this.getResources()));
                                        }
                                    }
                                    ActiveView.this.setLoadResFinished(asyncTask);
                                }
                            });
                            loadImage(seekBarAttrs.getProgressBackground(), -1.0f, -1.0f, new OnAsyncTaskListener() { // from class: com.stepos.activeview.views.ActiveView.9
                                @Override // com.stepos.activeview.listener.OnAsyncTaskListener
                                public void onLoadFinished(AsyncTask asyncTask, Object obj) throws IllegalArgumentException {
                                    if (obj instanceof Bitmap) {
                                        Bitmap bitmap = (Bitmap) obj;
                                        BitmapDrawable bitmapDrawable = new BitmapDrawable(ActiveView.this.mContext.getResources(), bitmap);
                                        bitmapDrawable.setTargetDensity(bitmap.getDensity());
                                        layerDrawable.setDrawableByLayerId(R.id.progress, new ClipDrawable(bitmapDrawable, 3, 1));
                                        Drawable.ConstantState constantState = layerDrawable.getConstantState();
                                        if (constantState == null) {
                                            seekBar.setProgressDrawable(layerDrawable);
                                        } else {
                                            seekBar.setProgressDrawable(constantState.newDrawable(ActiveView.this.getResources()));
                                        }
                                    }
                                    ActiveView.this.setLoadResFinished(asyncTask);
                                }
                            });
                            String thumb = seekBarAttrs.getThumb();
                            float f6 = rectRegion2[3] / this.mScaleRate;
                            loadImage(thumb, f6, f6, new OnAsyncTaskListener() { // from class: com.stepos.activeview.views.ActiveView.10
                                @Override // com.stepos.activeview.listener.OnAsyncTaskListener
                                public void onLoadFinished(AsyncTask asyncTask, Object obj) throws IllegalArgumentException {
                                    if (obj instanceof Bitmap) {
                                        Bitmap bitmap = (Bitmap) obj;
                                        BitmapDrawable bitmapDrawable = new BitmapDrawable(ActiveView.this.mContext.getResources(), bitmap);
                                        bitmapDrawable.setTargetDensity(bitmap.getDensity());
                                        seekBar.setThumb(bitmapDrawable);
                                    }
                                    ActiveView.this.setLoadResFinished(asyncTask);
                                }
                            });
                            imageView = seekBar;
                            str2 = ELEMENT_GROUP;
                            str3 = type;
                            str4 = str5;
                            i4 = size;
                            view2 = imageView;
                            z4 = true;
                            view3 = view2;
                            break;
                        default:
                            str2 = ELEMENT_GROUP;
                            str3 = type;
                            str4 = str5;
                            i4 = size;
                            view2 = null;
                            z4 = true;
                            view3 = view2;
                            break;
                    }
                    if (view3 != null) {
                        ViewElementData viewElementData = new ViewElementData(this, 0);
                        viewElementData.mView = view3;
                        viewElementData.mViewType = VIEW_IMAGEVIEW;
                        viewElementData.mElementData = element;
                        this.mViewElementCacheMap.put(element.getId(), viewElementData);
                    }
                    if (view3 != null) {
                        setElementProperties(view3, element, z4);
                        setElementAnimation(view3, element.getAnimations());
                        view4 = view;
                        if (view4 != null && (view4 instanceof FrameLayout)) {
                            ((FrameLayout) view4).addView(view3);
                        }
                        if (str3.equals(str2)) {
                            List<Element> elements = element.getElements();
                            if (elements == null || elements.isEmpty()) {
                                return;
                            } else {
                                createElements(view3, elements);
                            }
                        } else {
                            continue;
                        }
                    } else {
                        view4 = view;
                    }
                    i5++;
                    list2 = list;
                    str5 = str4;
                    view5 = view4;
                    size = i4;
                }
            }
            view4 = view5;
            str4 = str5;
            i4 = size;
            i5++;
            list2 = list;
            str5 = str4;
            view5 = view4;
            size = i4;
        }
    }

    private void createViewsFromActiveData() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        ActiveData activeData = this.mActiveData;
        if (activeData == null || activeData.getContent() == null) {
            StringBuilder sb = new StringBuilder("mActiveInfo = ");
            sb.append(this.mActiveData);
            sb.append(", mActiveInfo.getContent()=");
            ActiveData activeData2 = this.mActiveData;
            sb.append(activeData2 != null ? activeData2.getContent() : null);
            LogUtil.e(LOG_TAG, sb.toString());
            return;
        }
        List<Page> pages = this.mActiveData.getContent().getPages();
        if (pages == null) {
            LogUtil.e(LOG_TAG, "pageList is NULL!");
            return;
        }
        int size = pages.size();
        if (size > 0) {
            cancelLoadImage();
            this.mScaleRate = 1.0f;
            clearActiveView();
            this.mResourceLoaded = false;
            this.mShowAfterImagesLoaded = false;
        }
        FrameLayout frameLayout = null;
        for (int i4 = 0; i4 < size; i4++) {
            Page page = pages.get(i4);
            if (page != null) {
                frameLayout = new FrameLayout(this.mContext);
                this.mScaleRate = calScaleRate(page.getStyle().getWidthValue(this.mContext));
                LogUtil.i(LOG_TAG, "mMeasured = " + this.mMeasured + ", mScaleRate = " + this.mScaleRate);
                setStyleProperties(frameLayout, page.getStyle());
                if (!this.mMeasured) {
                    removeAllViews();
                    addView(frameLayout);
                    notifyListenerInMainThread(8, 1, "ActiveView is ready, but not added to a View. Url=" + this.mUrl);
                    return;
                }
                setEvent(frameLayout, null, page.getEvents());
                List<Element> elements = page.getElements();
                if (elements == null) {
                    LogUtil.e(LOG_TAG, "elementsList is NULL!");
                    return;
                }
                createElements(frameLayout, elements);
            }
        }
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
            frameLayout.setClipChildren(false);
            addView(frameLayout);
            setClipChildren(true);
            if (!this.mShowAfterImagesLoaded) {
                startFirstAnimation();
                this.mResourceLoaded = true;
                notifyListenerInMainThread(7, 1, "ActiveView is ready, no need load image. Url=" + this.mUrl);
            }
        } else {
            LogUtil.e(LOG_TAG, "ActiveView has no content!");
        }
        if (this.mHasDataBinding) {
            this.mVariableContainer.startApplying();
            this.mBindingContainer.startApplying();
        }
    }

    private void extractZipFile(String str, boolean z4) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.mUrl = str;
        if (hasCacheDir()) {
            LogUtil.d(LOG_TAG, "hasCacheDir true");
            return;
        }
        LogUtil.d(LOG_TAG, "hasCacheDir false");
        if (GetActManager.getInstance().isRequestInFlight(str)) {
            GetActManager.getInstance().getRequest(str).addWaitActiveViews(this);
            return;
        }
        if (z4) {
            GetActManager.GetActRequest getActRequestCreateRequest = GetActManager.getInstance().createRequest(str, 3, this);
            GetActManager.getInstance().putRequest(getActRequestCreateRequest);
            getActRequestCreateRequest.startGetData();
        } else {
            GetActManager.GetActRequest getActRequestCreateRequest2 = GetActManager.getInstance().createRequest(this.mUrl, 2, this);
            GetActManager.getInstance().putRequest(getActRequestCreateRequest2);
            getActRequestCreateRequest2.startGetData();
        }
    }

    private CustomEvent findCustomEvent(String str) {
        ActiveData activeData;
        if (str != null && (activeData = this.mActiveData) != null && activeData.getContent() != null) {
            List<Page> pages = this.mActiveData.getContent().getPages();
            if (pages == null) {
                LogUtil.e(LOG_TAG, "pageList is NULL!");
                return null;
            }
            int size = pages.size();
            for (int i4 = 0; i4 < size; i4++) {
                List<CustomEvent> customEvents = pages.get(i4).getCustomEvents();
                if (customEvents != null) {
                    for (CustomEvent customEvent : customEvents) {
                        if (str.equals(customEvent.getKey())) {
                            return customEvent;
                        }
                    }
                }
            }
        }
        return null;
    }

    private AlphaAnimation getAlphaAnimation(int i4) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(Property.DEFAULT_FLOAT_VALUE, 1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(i4);
        return alphaAnimation;
    }

    private Animation.AnimationListener getAnimationListener() {
        return new Animation.AnimationListener() { // from class: com.stepos.activeview.views.ActiveView.20
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) throws IllegalArgumentException {
                if (ActiveView.this.mHasDefaultImage && ActiveView.this.mDefaultImageView != null) {
                    ViewParent parent = ActiveView.this.mDefaultImageView.getParent();
                    ActiveView activeView = ActiveView.this;
                    if (parent == activeView) {
                        activeView.removeView(activeView.mDefaultImageView);
                    }
                }
                if (ActiveView.this.getChildAt(0) != null) {
                    ActiveView.this.getChildAt(0).setVisibility(0);
                }
                ActiveView.this.isLoadFromCache = true;
                if (ActiveView.this.mAutoRunAnim) {
                    ActiveView.this.startAnimation();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
    }

    private boolean hasCacheDir() {
        String sharePreferenceValue = CacheUtils.getInstance(this.mContext).getSharePreferenceValue(this.mUrl);
        LogUtil.i(LOG_TAG, "mUrl=" + this.mUrl + ", cachedDir =" + sharePreferenceValue);
        if (sharePreferenceValue == null || sharePreferenceValue.isEmpty() || !new File(sharePreferenceValue).exists()) {
            return false;
        }
        this.isLoadFromCache = true;
        LogUtil.i(LOG_TAG, "Don't download or extract the same file. Load data from cachedDir=".concat(sharePreferenceValue));
        this.zipExtractedDir = sharePreferenceValue;
        if (GetActManager.getInstance().isRequestInFlight(sharePreferenceValue)) {
            GetActManager.getInstance().getRequest(sharePreferenceValue).addWaitActiveViews(this);
            return true;
        }
        GetActManager.GetActRequest getActRequestCreateRequest = GetActManager.getInstance().createRequest(sharePreferenceValue, 4, this);
        GetActManager.getInstance().putRequest(getActRequestCreateRequest);
        getActRequestCreateRequest.startGetData();
        return true;
    }

    private void init(Context context) {
        if (ActiveUsageStatsUtils.getInstance() == null) {
            ActiveUsageStatsUtils.initialize(context);
        }
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        VariableContainer variableContainer = new VariableContainer(applicationContext);
        this.mVariableContainer = variableContainer;
        this.mBindingContainer = new BindingContainer(this, variableContainer);
        HashMap map = new HashMap();
        map.put(ActiveUsageStatsUtils.APP_PACKAGE_NAME, Utility.getAppPackageName(this.mContext));
        map.put(ActiveUsageStatsUtils.APP_PACKAGE_VERSION_NAME, Utility.getAppVersionName(this.mContext));
        ActiveUsageStatsUtils.getInstance().recordEvent(ActiveUsageStatsUtils.EVENT_APP_PACKAGE_INFO, "", map);
        HashMap map2 = new HashMap();
        map2.put(ActiveUsageStatsUtils.VERSION_NUMBER, Version.sRealVersion);
        ActiveUsageStatsUtils.getInstance().recordEvent(ActiveUsageStatsUtils.EVENT_VERSION_FREQUENCY, "", map2);
        setLayoutDirection(0);
    }

    private void initFrameStyle(FrameStyle frameStyle, com.stepos.activeview.json.Animation animation, View view) {
        if (animation.getTransform2dValue(this.mContext)[0] != null) {
            frameStyle.setPropertyValue(ViewTweenItem.LEFT, Float.valueOf(animation.getTransform2dValue(this.mContext)[0].floatValue() / this.mScaleRate));
        }
        if (animation.getTransform2dValue(this.mContext)[1] != null) {
            frameStyle.setPropertyValue(ViewTweenItem.TOP, Float.valueOf(animation.getTransform2dValue(this.mContext)[1].floatValue() / this.mScaleRate));
        }
        if (animation.getScale2d()[0] != null) {
            frameStyle.setPropertyValue("scaleX", animation.getScale2d()[0]);
        }
        if (animation.getScale2d()[1] != null) {
            frameStyle.setPropertyValue("scaleY", animation.getScale2d()[0]);
        }
        if (animation.getRotate3d()[0] != null) {
            frameStyle.setPropertyValue(ViewTweenItem.ROTATION_X, animation.getRotate3d()[0]);
        }
        if (animation.getRotate3d()[1] != null) {
            frameStyle.setPropertyValue(ViewTweenItem.ROTATION_Y, animation.getRotate3d()[1]);
        }
        if (animation.getRotate3d()[2] != null) {
            frameStyle.setPropertyValue("rotation", animation.getRotate3d()[2]);
        }
        if (animation.getOpacity() != null) {
            frameStyle.setPropertyValue(ViewTweenItem.ALPHA, Float.valueOf(animation.getOpacity().intValue() / 255.0f));
        }
        if (animation.getTrackPathValue(this.mContext) != null) {
            List<float[]> trackPathValue = animation.getTrackPathValue(this.mContext);
            int size = trackPathValue.size();
            for (int i4 = 0; i4 < size; i4++) {
                trackPathValue.get(i4)[0] = trackPathValue.get(i4)[0] / this.mScaleRate;
                trackPathValue.get(i4)[1] = trackPathValue.get(i4)[1] / this.mScaleRate;
            }
            frameStyle.setPropertyValue(ViewTweenItem.TRACK_PATH, trackPathValue);
        }
        if (view instanceof GLImageView) {
            WaveData wave = animation.getWave();
            if (wave != null) {
                frameStyle.setPropertyValue(GLImageViewTweenItem.WAVE, wave);
            }
            ApertureData aperture = animation.getAperture();
            if (aperture != null) {
                frameStyle.setPropertyValue(GLImageViewTweenItem.APERTURER, aperture);
            }
        }
    }

    private boolean isActiveURL(String str) {
        return str != null && (str.endsWith(".act") || str.endsWith(".zip"));
    }

    private boolean isImageURL(String str) {
        return str != null && (str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(".psd"));
    }

    private boolean isVideoURL(String str) {
        return str != null && (str.endsWith(".mp4") || str.endsWith(".3gp") || str.endsWith(".webm") || str.endsWith(".mkv") || str.endsWith(".mov"));
    }

    private void loadLottie(String str, OnAsyncTaskListener onAsyncTaskListener) {
        this.mShowAfterImagesLoaded = true;
        LoadLottieAnimationTask loadLottieAnimationTask = new LoadLottieAnimationTask(this.mContext.getApplicationContext(), this.zipExtractedDir + "/" + str, onAsyncTaskListener);
        loadLottieAnimationTask.execute(new Void[0]);
        this.mLoadResTaskMap.put(loadLottieAnimationTask, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListenerInMainThread(final int i4, final int i5, final String str) {
        if (this.mOnUpdateListener != null) {
            if (this.mMsgHandler == null) {
                this.mMsgHandler = new Handler(Looper.getMainLooper());
            }
            this.mMsgHandler.post(new Runnable() { // from class: com.stepos.activeview.views.ActiveView.22
                @Override // java.lang.Runnable
                public void run() {
                    if (ActiveView.this.mOnUpdateListener != null) {
                        ActiveView.this.mOnUpdateListener.onUpdateFinished(i4, i5, str);
                    }
                }
            });
        }
        if (!isActiveURL(this.mUrl) || i4 == 2 || str.contains("Url Not Changed")) {
            return;
        }
        if (i4 == 7 && i5 == 1) {
            ActiveUsageStatsUtils.recordUseEvent(ActiveUsageStatsUtils.EVENT_LOAD_ACT_FILE, this.mUrl, ActiveUsageStatsUtils.STATE_SUCCESS);
        } else if (i5 == 0) {
            ActiveUsageStatsUtils.recordUseEvent(ActiveUsageStatsUtils.EVENT_LOAD_ACT_FILE, this.mUrl, ActiveUsageStatsUtils.STATE_FAIL);
        }
    }

    private void putTween(Timeline timeline, com.stepos.activeview.json.Animation animation, ViewTweenItem viewTweenItem, FrameStyle frameStyle) {
        PathInterpolator pathInterpolator;
        Interpolator interpolator = animation.getInterpolator();
        if (interpolator == null) {
            LogUtil.i(LOG_TAG, "Use no Interpolator.");
            timeline.to(viewTweenItem, animation.getDuration(), frameStyle, animation.getStartTime(), 0);
            return;
        }
        if (interpolator.getName().equals(INTERPOLATOR_TYPE_SHAKE)) {
            Args args = interpolator.getArgs();
            if (args != null) {
                LogUtil.i(LOG_TAG, "Use Shake Frequency =" + args.getFrequency());
                if (animation.isRepeat()) {
                    timeline.to(viewTweenItem, animation.getDuration(), frameStyle, new CycleInterpolator(args.getFrequency()), 0, 0, (int) (animation.getRepeatDelay() * 1000.0f));
                    return;
                } else {
                    timeline.to(viewTweenItem, animation.getDuration(), frameStyle, new CycleInterpolator(args.getFrequency()), animation.getStartTime(), 0, 0);
                    return;
                }
            }
            return;
        }
        if (interpolator.getName().equals(INTERPOLATOR_TYPE_LINEAR)) {
            Args args2 = interpolator.getArgs();
            if (args2 == null || args2.getPath().length != 4) {
                pathInterpolator = new PathInterpolator(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1.0f, 1.0f);
            } else {
                float[] path = args2.getPath();
                LogUtil.i(LOG_TAG, "Use PathInterpolator path =" + path[0] + ", " + path[1] + ", " + path[2] + ", " + path[3]);
                pathInterpolator = new PathInterpolator(path[0], path[1], path[2], path[3]);
            }
            PathInterpolator pathInterpolator2 = pathInterpolator;
            if (animation.isRepeat()) {
                timeline.to(viewTweenItem, animation.getDuration(), frameStyle, pathInterpolator2, 0, 0, (int) (animation.getRepeatDelay() * 1000.0f));
            } else {
                timeline.to(viewTweenItem, animation.getDuration(), frameStyle, pathInterpolator2, animation.getStartTime(), 0, 0);
            }
        }
    }

    private void reset() {
        Timeline timeline = this.mTimeline;
        if (timeline != null) {
            timeline.stop();
            this.mTimeline = null;
        }
        HashMap<String, Timeline> map = this.mTimelineMap;
        if (map != null) {
            for (Timeline timeline2 : map.values()) {
                if (timeline2 != null) {
                    timeline2.stop();
                }
            }
            this.mTimelineMap.clear();
        }
        HashMap<String, ArrayList<Timeline>> map2 = this.mCustomEventMap;
        if (map2 != null) {
            for (ArrayList<Timeline> arrayList : map2.values()) {
                if (arrayList != null) {
                    Iterator<Timeline> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().stop();
                    }
                }
            }
            this.mCustomEventMap.clear();
        }
        HashMap<View, ViewTweenItem> map3 = this.mTweenItemMap;
        if (map3 != null) {
            map3.clear();
        }
        ArrayList<ParallaxData> arrayList2 = this.mParallaxData;
        if (arrayList2 != null) {
            arrayList2.clear();
            this.mParallaxData = null;
        }
        ArrayList<OrientationData> arrayList3 = this.mOrientationData;
        if (arrayList3 != null) {
            arrayList3.clear();
            this.mOrientationData = null;
        }
        ArrayList<LayerAniData> arrayList4 = this.mLayerAniData;
        if (arrayList4 != null) {
            arrayList4.clear();
            this.mLayerAniData = null;
        }
        HashMap<String, ViewElementData> map4 = this.mViewElementCacheMap;
        if (map4 != null) {
            map4.clear();
        }
        this.mAnimations.clear();
        GetActManager.GetActRequest request = GetActManager.getInstance().getRequest(this.mUrl);
        if (request != null && request.removeWaitActiveView(this) == 0) {
            GetActManager.getInstance().removeRequest(this.mUrl);
        }
        if (this.mHasDataBinding) {
            this.mBindingContainer.clearDataBinding();
        }
        this.mHasDataBinding = false;
        this.mCanReverseAnimaion = true;
        this.mHasApproachAnim = false;
    }

    private void setDefaultImageDrawable(int i4, int i5, Drawable drawable) {
        if (this.mDefaultImageView == null) {
            this.mDefaultImageView = new ImageView(this.mContext);
        }
        this.mDefaultImageView.setBackground(drawable);
        if (this.mDefaultImageView.getParent() == null) {
            clearActiveView();
            this.mDefaultImageLayoutParams = new FrameLayout.LayoutParams(i4, i5);
            this.mHasDefaultImage = true;
        }
    }

    private void setElementAnimation(View view, List<com.stepos.activeview.json.Animation> list) {
        GLImageViewTweenItem gLImageViewTweenItem;
        Timeline timeline;
        if (list == null) {
            return;
        }
        int size = list.size();
        if (size > 0) {
            if (this.mTimeline == null) {
                Timeline timeline2 = new Timeline();
                this.mTimeline = timeline2;
                this.mTimelineMap.put(ACTIVE_TIMELINE_KEY, timeline2);
            }
            gLImageViewTweenItem = new GLImageViewTweenItem(view);
            this.mTweenItemMap.put(view, gLImageViewTweenItem);
        } else {
            gLImageViewTweenItem = null;
        }
        if (gLImageViewTweenItem == null) {
            return;
        }
        for (int i4 = 0; i4 < size; i4++) {
            FrameStyle frameStyleBuildFrameStyle = gLImageViewTweenItem.buildFrameStyle();
            com.stepos.activeview.json.Animation animation = list.get(i4);
            if (animation.isRepeat()) {
                timeline = new Timeline();
                this.mTimelineMap.put(animation.getId(), timeline);
                timeline.setRepeatCount(animation.getRepeatCount());
                timeline.setRepeatMode(animation.getRepeatMode());
                timeline.setDelayTime(animation.getStartTime());
                timeline.setRepeatDelay(animation.getRepeatDelay());
                this.mCanReverseAnimaion = false;
            } else {
                timeline = this.mTimeline;
                if (this.mEnableOrientationAnim) {
                    if (this.mInnerAnimationListener == null) {
                        this.mInnerAnimationListener = new InnerAnimationListener(this);
                    }
                    timeline.setAnimationListener(this.mInnerAnimationListener);
                    this.mHasApproachAnim = true;
                }
            }
            initFrameStyle(frameStyleBuildFrameStyle, animation, view);
            putTween(timeline, animation, gLImageViewTweenItem, frameStyleBuildFrameStyle);
        }
    }

    private void setElementProperties(final View view, Element element, boolean z4) {
        FrameLayout.LayoutParams layoutParams;
        int iCalculateInSampleSize;
        if (view == null || element == null) {
            LogUtil.e(LOG_TAG, "view or element is NULL!");
            return;
        }
        if (element.getDataBinding() != null) {
            this.mHasDataBinding = true;
            this.mBindingContainer.addDataBinding(element.getId(), new DataBindingWrapper(element));
        }
        String type = element.getType();
        float[] rectRegion = element.getRectRegion(this.mContext);
        if (element.getType().equals(ELEMENT_TEXT)) {
            String version = this.mActiveData.getVersion();
            layoutParams = (version == null || version.compareTo(TEXT_HEIGHT_WRACONTENT_VERSION) <= 0) ? new FrameLayout.LayoutParams(Math.round(rectRegion[2] / this.mScaleRate), -2) : new FrameLayout.LayoutParams(Math.round(rectRegion[2] / this.mScaleRate), Math.round(rectRegion[3] / this.mScaleRate));
        } else {
            layoutParams = new FrameLayout.LayoutParams(Math.round(rectRegion[2] / this.mScaleRate), Math.round(rectRegion[3] / this.mScaleRate));
        }
        view.setLayoutParams(layoutParams);
        view.setTranslationX(rectRegion[0] / this.mScaleRate);
        view.setTranslationY(rectRegion[1] / this.mScaleRate);
        Parallax parallax = element.getParallax();
        if (parallax != null) {
            setParallax(view, parallax);
        } else {
            LogUtil.i(LOG_TAG, element.getId() + " don't set parallax!");
        }
        LayerAni layerAni = element.getLayerAni();
        if (layerAni != null) {
            setLayerAni(view, layerAni);
        } else {
            LogUtil.i(LOG_TAG, element.getId() + " don't set layerAni!");
        }
        Orientation orientation = element.getOrientation();
        if (orientation != null) {
            setOrientationData(view, orientation);
            this.mCanReverseAnimaion = false;
        } else {
            LogUtil.i(LOG_TAG, element.getId() + " don't set gravity anim!");
        }
        float radiusValue = element.getRadiusValue(this.mContext);
        if (radiusValue > Property.DEFAULT_FLOAT_VALUE) {
            setRoundCorner(view, radiusValue);
        }
        Integer backgroundColorValue = element.getBackgroundColorValue();
        if (backgroundColorValue != null) {
            view.setBackgroundColor(backgroundColorValue.intValue());
        }
        view.setScaleX(element.getScale2d()[0]);
        view.setScaleY(element.getScale2d()[1]);
        view.setRotationX(element.getRotate3d()[0]);
        view.setRotationY(element.getRotate3d()[1]);
        view.setRotation(element.getRotate3d()[2]);
        float[] rotateCenterValue = element.getRotateCenterValue(this.mContext);
        view.setPivotX(rotateCenterValue[0] / this.mScaleRate);
        view.setPivotY(rotateCenterValue[1] / this.mScaleRate);
        view.setAlpha(element.getOpacity().intValue() / 255.0f);
        if (z4) {
            setEvent(view, element.getId(), element.getEvents());
            type.getClass();
            switch (type) {
                case "gif":
                    if (view instanceof GifMovieView) {
                        ((GifMovieView) view).setMovieResource(this.zipExtractedDir + "/" + element.getUrl());
                        break;
                    }
                    break;
                case "image":
                    float f4 = rectRegion[2];
                    float f5 = this.mScaleRate;
                    float f6 = f4 / f5;
                    float f7 = rectRegion[3] / f5;
                    if (element.getAnimations().size() == 0) {
                        int i4 = this.ActiveViewWidth;
                        if ((f6 > i4 || f7 > this.ActiveViewHeight) && (iCalculateInSampleSize = BitmapUtils.calculateInSampleSize((int) f6, (int) f7, i4, this.ActiveViewHeight)) != 1) {
                            float f8 = iCalculateInSampleSize;
                            f6 /= f8;
                            f7 /= f8;
                            view.setLayoutParams(new FrameLayout.LayoutParams(Math.round(f6), Math.round(f7)));
                            view.setTranslationX((rectRegion[0] / this.mScaleRate) / f8);
                            view.setTranslationY((rectRegion[1] / this.mScaleRate) / f8);
                        }
                    }
                    loadImage(element.getUrl(), f6, f7, new OnAsyncTaskListener() { // from class: com.stepos.activeview.views.ActiveView.13
                        @Override // com.stepos.activeview.listener.OnAsyncTaskListener
                        public void onLoadFinished(AsyncTask asyncTask, Object obj) throws IllegalArgumentException {
                            ((ImageView) view).setImageBitmap((Bitmap) obj);
                            ActiveView.this.setLoadResFinished(asyncTask);
                        }
                    });
                    break;
                case "glimage":
                    String url = element.getUrl();
                    float f9 = rectRegion[2];
                    float f10 = this.mScaleRate;
                    loadImage(url, f9 / f10, rectRegion[3] / f10, new OnAsyncTaskListener() { // from class: com.stepos.activeview.views.ActiveView.14
                        @Override // com.stepos.activeview.listener.OnAsyncTaskListener
                        public void onLoadFinished(AsyncTask asyncTask, Object obj) throws IllegalArgumentException {
                            ((GLImageView) view).setImageBitmap((Bitmap) obj);
                            ActiveView.this.setLoadResFinished(asyncTask);
                        }
                    });
                    break;
            }
        }
    }

    private void setEvent(View view, String str, List<Event> list) {
        int size;
        EventHandler eventHandlerRegisterEventHandler;
        if (view == null || list == null || (size = list.size()) == 0) {
            return;
        }
        for (int i4 = 0; i4 < size; i4++) {
            Event event = list.get(i4);
            if (event != null && (eventHandlerRegisterEventHandler = EventHandler.registerEventHandler(view, str, event)) != null) {
                eventHandlerRegisterEventHandler.setOnEventListener(this.mOnEventListener);
                eventHandlerRegisterEventHandler.setCallback(new EventHandler.Callback() { // from class: com.stepos.activeview.views.ActiveView.21
                    @Override // com.stepos.activeview.handler.EventHandler.Callback
                    public void clickCallback() {
                        ActiveUsageStatsUtils.recordClickEvent(ActiveView.this.mUrl);
                    }
                });
            }
        }
    }

    private void setGLImageViewAttrs(GLImageView gLImageView, Element element) {
        gLImageView.setStartEndApertureData(element.getAperture(), element.getAperture(), Property.DEFAULT_FLOAT_VALUE);
        gLImageView.setStartEndWaveData(element.getWave(), element.getWave(), Property.DEFAULT_FLOAT_VALUE);
    }

    private void setLayerAni(View view, LayerAni layerAni) {
        if (this.mLayerAniData == null) {
            this.mLayerAniData = new ArrayList<>();
        }
        LayerAniData layerAniData = new LayerAniData(this, 0);
        layerAniData.mView = view;
        Parameter parameter = layerAni.getParameter();
        if (parameter != null) {
            layerAniData.mRange = parameter.getRangeValue(this.mContext);
        }
        this.mLayerAniData.add(layerAniData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadResFinished(AsyncTask asyncTask) throws IllegalArgumentException {
        if (asyncTask.isCancelled()) {
            StringBuilder sb = new StringBuilder("LoadImageTask is cancelled.image=");
            LoadImageTask loadImageTask = (LoadImageTask) asyncTask;
            sb.append(loadImageTask.getImagePath());
            LogUtil.e(LOG_TAG, sb.toString());
            notifyListenerInMainThread(5, 0, "LoadImageTask is cancelled. image=" + loadImageTask.getImagePath());
            return;
        }
        this.mLoadResTaskMap.put(asyncTask, Boolean.TRUE);
        if (this.mLoadResTaskMap.containsValue(Boolean.FALSE)) {
            return;
        }
        notifyListenerInMainThread(5, 1, "url=" + this.mUrl);
        this.mLoadResTaskMap.clear();
        if (!this.mMeasured) {
            notifyListenerInMainThread(8, 1, "ActiveView is ready, but not added to a View. Url=" + this.mUrl);
            return;
        }
        startFirstAnimation();
        if (this.mOnLoadImageListener != null) {
            this.mOnLoadImageListener.onLoadFinished(1, getActiveViewBitmap());
        }
        notifyListenerInMainThread(7, 1, "ActiveView is ready, and is added to a View. Url=" + this.mUrl);
        this.mResourceLoaded = true;
    }

    private void setOrientationData(View view, Orientation orientation) {
        if (this.mOrientationData == null) {
            this.mOrientationData = new ArrayList<>();
        }
        OrientationData orientationData = new OrientationData(this, 0);
        orientationData.mView = view;
        orientationData.mType = orientation.getType();
        orientationData.mMaxEndAngle = orientation.getOriEnd();
        Parameter parameter = orientation.getParameter();
        if (parameter != null) {
            orientationData.mRange = parameter.getOrientationRangeValue(getContext());
            orientationData.mAngles = parameter.getAngle();
        }
        this.mOrientationData.add(orientationData);
    }

    private void setParallax(View view, Parallax parallax) {
        if (this.mParallaxData == null) {
            this.mParallaxData = new ArrayList<>();
        }
        ParallaxData parallaxData = new ParallaxData(this, 0);
        parallaxData.mView = view;
        Parameter parameter = parallax.getParameter();
        if (parameter != null) {
            parallaxData.mRange = parameter.getRangeValue(this.mContext);
        }
        this.mParallaxData.add(parallaxData);
    }

    private void setRoundCorner(View view, final float f4) {
        if (view == null) {
            return;
        }
        view.setOutlineProvider(new ViewOutlineProvider(this) { // from class: com.stepos.activeview.views.ActiveView.15
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f4);
            }
        });
        view.setClipToOutline(true);
    }

    private void setStyleProperties(View view, Style style) {
        if (view == null || style == null) {
            LogUtil.e(LOG_TAG, "view or style is NULL!");
            return;
        }
        this.ActiveViewWidth = Math.round(style.getWidthValue(this.mContext) / this.mScaleRate);
        this.ActiveViewHeight = Math.round(style.getHeightValue(this.mContext) / this.mScaleRate);
        view.setLayoutParams(new FrameLayout.LayoutParams(this.ActiveViewWidth, this.ActiveViewHeight));
        LogUtil.i(LOG_TAG, "mScaleRate =" + this.mScaleRate + ", Style width=" + style.getWidthValue(this.mContext) + ", Style height" + style.getHeightValue(this.mContext) + "; Real width=" + ((int) (style.getWidthValue(this.mContext) / this.mScaleRate)) + ", Real height=" + ((int) (style.getHeightValue(this.mContext) / this.mScaleRate)));
        float radiusValue = style.getRadiusValue();
        if (radiusValue > Property.DEFAULT_FLOAT_VALUE) {
            setRoundCorner(view, radiusValue);
        }
        view.setBackgroundColor(style.getBackgroundColorValue());
        this.mColorPrimary = style.getColorPrimary();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setTextAttrs(android.widget.TextView r10, com.stepos.activeview.json.Element r11) {
        /*
            Method dump skipped, instructions count: 770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.views.ActiveView.setTextAttrs(android.widget.TextView, com.stepos.activeview.json.Element):void");
    }

    private void setVideoViewAttrs(TextureVideoView textureVideoView, Element element) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (textureVideoView == null || element == null || element.getVideoAttr() == null) {
            LogUtil.e(LOG_TAG, "Don't set VideoAttrs.");
            return;
        }
        VideoAttr videoAttr = element.getVideoAttr();
        textureVideoView.setAutoRelease(this.mAutoReleaseVideo);
        String src = videoAttr.getSrc();
        if (src != null) {
            textureVideoView.setVideoPath(this.zipExtractedDir + "/" + src);
        }
        if (videoAttr.getAudio() != null) {
            textureVideoView.setPlayAudio(videoAttr.getAudio().booleanValue());
        }
        if (videoAttr.getAutoPlay() != null) {
            textureVideoView.setAutoPlay(videoAttr.getAutoPlay().booleanValue());
        }
        if (videoAttr.getLoop() != null) {
            textureVideoView.setLooping(videoAttr.getLoop().booleanValue());
        }
        if (videoAttr.getStartTime() != null) {
            textureVideoView.setStartPlayTime(videoAttr.getStartTime().longValue());
        }
        if (videoAttr.getIntervalDelay() != null) {
            textureVideoView.setIntervalDelay(videoAttr.getIntervalDelay().longValue());
        }
        final String uri = textureVideoView.getUri();
        textureVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.stepos.activeview.views.ActiveView.16
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                ActiveView.this.notifyListenerInMainThread(10, 1, "Play video is completion, VideoFile=" + uri);
            }
        });
        textureVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.stepos.activeview.views.ActiveView.17
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                ActiveView.this.notifyListenerInMainThread(9, 1, "Video is prepared, Url=" + ActiveView.this.mUrl + ", VideoFile=" + uri);
            }
        });
        textureVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.stepos.activeview.views.ActiveView.18
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i4, int i5) {
                LogUtil.i(ActiveView.LOG_TAG, "VideoAttrs onError what= " + i4 + ", extra=" + i5);
                ActiveView activeView = ActiveView.this;
                StringBuilder sbU = g.u("MediaPlayer Error, what=", i4, ", extra=", i5, ", VideoFile=");
                sbU.append(uri);
                activeView.notifyListenerInMainThread(11, 1, sbU.toString());
                return false;
            }
        });
        textureVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.stepos.activeview.views.ActiveView.19
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i4, int i5) {
                ActiveView activeView = ActiveView.this;
                StringBuilder sbU = g.u("MediaPlayer Info, what=", i4, ", extra=", i5, ", VideoFile=");
                sbU.append(uri);
                activeView.notifyListenerInMainThread(12, 1, sbU.toString());
                return false;
            }
        });
    }

    private void startDataBinding() throws IllegalArgumentException {
        if (this.mHasDataBinding) {
            this.mVariableContainer.startApplying();
            this.mBindingContainer.startApplying();
        }
    }

    private void startFirstAnimation() throws IllegalArgumentException {
        if (this.mAutoGradientDisplay && this.mAutpAlphaAnimation != null) {
            Animation.AnimationListener animationListener = getAnimationListener();
            this.mDefaultImgAnimListener = animationListener;
            this.mAutpAlphaAnimation.setAnimationListener(animationListener);
            if (this.isLoadFromCache || !this.mHasDefaultImage) {
                getChildAt(0).startAnimation(this.mAutpAlphaAnimation);
                return;
            } else {
                if (getChildAt(1) != null) {
                    getChildAt(1).startAnimation(this.mAutpAlphaAnimation);
                    return;
                }
                return;
            }
        }
        if (this.isLoadFromCache || !this.mHasDefaultImage) {
            if (getChildAt(0) != null) {
                getChildAt(0).setVisibility(0);
            }
            if (this.mAutoRunAnim) {
                startAnimation();
                return;
            }
            return;
        }
        this.mDefaultImgAnimListener = getAnimationListener();
        AlphaAnimation alphaAnimation = getAlphaAnimation(800);
        alphaAnimation.setAnimationListener(this.mDefaultImgAnimListener);
        if (getChildAt(1) != null) {
            getChildAt(1).startAnimation(alphaAnimation);
        }
    }

    private void stopDataBinding() {
        if (this.mHasDataBinding) {
            this.mVariableContainer.stopApplying();
            this.mBindingContainer.stopApplying();
        }
    }

    private void updateLayerAniData() {
        if (!this.mUseLayerAni || this.mOnLayerAniListener == null || this.mLayerAniData == null) {
            return;
        }
        for (int i4 = 0; i4 < this.mLayerAniData.size(); i4++) {
            LayerAniData layerAniData = this.mLayerAniData.get(i4);
            Float[] fArr = layerAniData.mRange;
            if (fArr == null) {
                this.mOnLayerAniListener.onUpdateLayerAniData(layerAniData.mView, null);
            } else {
                this.mOnLayerAniListener.onUpdateLayerAniData(layerAniData.mView, fArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOrientationData() {
        if (!this.mEnableOrientationAnim || this.mOnOrientationAnimationListener == null || this.mOrientationData == null) {
            return;
        }
        for (int i4 = 0; i4 < this.mOrientationData.size(); i4++) {
            OrientationData orientationData = this.mOrientationData.get(i4);
            if (orientationData != null) {
                this.mOnOrientationAnimationListener.onUpdateOrientationData(orientationData.mView, orientationData.mType, orientationData.mMaxEndAngle, orientationData.mRange, orientationData.mAngles);
            }
        }
    }

    private void updateParallaxData() {
        if (!this.mUseParallax || this.mOnParallaxListener == null || this.mParallaxData == null) {
            return;
        }
        for (int i4 = 0; i4 < this.mParallaxData.size(); i4++) {
            ParallaxData parallaxData = this.mParallaxData.get(i4);
            Float[] fArr = parallaxData.mRange;
            if (fArr == null) {
                this.mOnParallaxListener.onUpdateParallaxData(parallaxData.mView, null);
            } else {
                this.mOnParallaxListener.onUpdateParallaxData(parallaxData.mView, fArr);
            }
        }
    }

    public boolean canAnimationReverse() {
        return this.mCanReverseAnimaion;
    }

    public void cancelAllRunningTasks() {
        cancelDownload();
        cancelExtract();
        cancelLoadData();
        cancelLoadImage();
    }

    public void cancelDownload() {
        GetActManager.GetActRequest request = GetActManager.getInstance().getRequest(this.mUrl);
        if (request == null && this.isLoadFromCache) {
            request = GetActManager.getInstance().getRequest(this.zipExtractedDir);
        }
        if (request == null || request.removeWaitActiveView(this) != 0) {
            return;
        }
        GetActManager.getInstance().removeRequest(request.getRequestString());
    }

    public void cancelExtract() {
        GetActManager.GetActRequest request = GetActManager.getInstance().getRequest(this.mUrl);
        if (request == null && this.isLoadFromCache) {
            request = GetActManager.getInstance().getRequest(this.zipExtractedDir);
        }
        if (request == null || request.removeWaitActiveView(this) != 0) {
            return;
        }
        GetActManager.getInstance().removeRequest(request.getRequestString());
    }

    public void cancelLoadImage() {
        for (AsyncTask asyncTask : this.mLoadResTaskMap.keySet()) {
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
        }
        this.mLoadResTaskMap.clear();
    }

    public void clear() {
        this.mActiveData = null;
        clearActiveView();
    }

    public void clearCacheFolder() {
        if (this.mContext != null && this.mAutoDeleteFolder) {
            new Thread(new Runnable() { // from class: com.stepos.activeview.views.ActiveView.6
                @Override // java.lang.Runnable
                public void run() {
                    CacheUtils.getInstance(ActiveView.this.mContext).clearCacheFolder(FileUtil.getActiveViewCachesDir(ActiveView.this.mContext), ActiveView.this.mFolderHours);
                    CacheUtils.getInstance(ActiveView.this.mContext).clearCacheFolder(FileUtil.getVollyCacheDir(ActiveView.this.mContext), ActiveView.this.mFolderHours);
                }
            }).start();
            return;
        }
        LogUtil.e(LOG_TAG, "clearCacheFolder ==mCacheDir=, mContext=" + this.mContext + ", mAutoDeleteFolder=" + this.mAutoDeleteFolder);
    }

    public void clearImageCache() {
        reset();
        ImageCacheUtils.getInstance().clearCache();
    }

    public void downloadImage(String str) {
        if (str == null || str.isEmpty()) {
            LogUtil.e(LOG_TAG, "Illegal RUL !!! url = " + str);
            return;
        }
        if (!str.equals(this.mUrl)) {
            this.mUrl = str;
            if (this.mImageView == null) {
                ImageView imageView = new ImageView(this.mContext);
                this.mImageView = imageView;
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            if (this.mImageView.getParent() != null) {
                this.mImageView.setVisibility(4);
            }
        }
        this.isLoadFromCache = true;
        if (ImageCacheUtils.getInstance().getBitmapFromImageCache(str) == null) {
            UpdaterUtils.getInstance(this.mContext).loadImage(this.mImageView, str, 0, 0, new UpdaterUtils.OnLoadListener() { // from class: com.stepos.activeview.views.ActiveView.1
                @Override // com.stepos.activeview.utils.UpdaterUtils.OnLoadListener
                public void onLoadError(int i4, String str2) {
                    ActiveUsageStatsUtils.recordUseEvent(ActiveUsageStatsUtils.EVENT_LOAD_IMAGE_FILE, ActiveView.this.mUrl, ActiveUsageStatsUtils.STATE_FAIL);
                    ActiveView.this.notifyListenerInMainThread(7, 0, str2);
                }

                @Override // com.stepos.activeview.utils.UpdaterUtils.OnLoadListener
                public void onLoadFinished(int i4, Bitmap bitmap) {
                    if (i4 == 1) {
                        if (ActiveView.this.mImageView.getParent() == null) {
                            ActiveView.this.clearActiveView();
                            ActiveView activeView = ActiveView.this;
                            activeView.addView(activeView.mImageView);
                        }
                        ActiveView.this.mImageView.setVisibility(0);
                        ActiveUsageStatsUtils.recordUseEvent(ActiveUsageStatsUtils.EVENT_LOAD_IMAGE_FILE, ActiveView.this.mUrl, ActiveUsageStatsUtils.STATE_SUCCESS);
                    } else {
                        ActiveUsageStatsUtils.recordUseEvent(ActiveUsageStatsUtils.EVENT_LOAD_IMAGE_FILE, ActiveView.this.mUrl, ActiveUsageStatsUtils.STATE_FAIL);
                    }
                    if (ActiveView.this.mOnLoadImageListener != null) {
                        ActiveView.this.mOnLoadImageListener.onLoadFinished(i4, bitmap);
                    }
                    ActiveView.this.notifyListenerInMainThread(7, 1, "load image success, url=" + ActiveView.this.mUrl);
                }
            });
        }
    }

    public void downloadPackage(String str) throws IllegalArgumentException {
        downloadPackage(str, null);
    }

    public void downloadVideo(String str, int i4, int i5) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String str2;
        if (str == null || str.isEmpty() || ((str2 = this.mUrl) != null && str2.equals(str))) {
            LogUtil.e(LOG_TAG, "mUrl == url, don't update Video.");
            return;
        }
        this.mUrl = str;
        this.isLoadFromCache = true;
        TextureVideoView textureVideoView = this.mSimpleVideoView;
        if (textureVideoView == null) {
            TextureVideoView textureVideoView2 = new TextureVideoView(this.mContext);
            this.mSimpleVideoView = textureVideoView2;
            textureVideoView2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.stepos.activeview.views.ActiveView.2
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    ActiveView.this.notifyListenerInMainThread(10, 1, "Play video is completion, VideoFile=" + ActiveView.this.mUrl);
                }
            });
            this.mSimpleVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.stepos.activeview.views.ActiveView.3
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    ActiveView.this.notifyListenerInMainThread(9, 1, "Video is prepared, Url=" + ActiveView.this.mUrl + ", VideoFile=" + ActiveView.this.mUrl);
                }
            });
            this.mSimpleVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.stepos.activeview.views.ActiveView.4
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i6, int i7) {
                    ActiveView activeView = ActiveView.this;
                    StringBuilder sbU = g.u("MediaPlayer Error, what=", i6, ", extra=", i7, ", VideoFile=");
                    sbU.append(ActiveView.this.mUrl);
                    activeView.notifyListenerInMainThread(11, 1, sbU.toString());
                    return false;
                }
            });
            this.mSimpleVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.stepos.activeview.views.ActiveView.5
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer, int i6, int i7) {
                    ActiveView activeView = ActiveView.this;
                    StringBuilder sbU = g.u("MediaPlayer Info, what=", i6, ", extra=", i7, ", VideoFile=");
                    sbU.append(ActiveView.this.mUrl);
                    activeView.notifyListenerInMainThread(12, 1, sbU.toString());
                    return false;
                }
            });
        } else if (textureVideoView.getParent() != null) {
            this.mSimpleVideoView.setVideoURI(Uri.parse(str));
            return;
        }
        this.mSimpleVideoView.setLayoutParams((i4 == 0 || i5 == 0) ? (getMeasuredWidth() == 0 || getMeasuredHeight() == 0) ? new FrameLayout.LayoutParams(-2, -2) : new FrameLayout.LayoutParams(getMeasuredWidth(), getMeasuredHeight()) : new FrameLayout.LayoutParams(i4, i5));
        clearActiveView();
        addView(this.mSimpleVideoView);
        this.mSimpleVideoView.setVideoURI(Uri.parse(str));
        this.mSimpleVideoView.setAutoRelease(this.mAutoReleaseVideo);
        this.mAnimations.put(LOAD_VIDEO_FROM_URL, this.mSimpleVideoView);
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public View findViewByEleId(String str) {
        ViewElementData viewElementData = this.mViewElementCacheMap.get(str);
        if (viewElementData != null) {
            return viewElementData.mView;
        }
        return null;
    }

    public Bitmap getActiveViewBitmap() {
        setDrawingCacheEnabled(true);
        buildDrawingCache();
        return getDrawingCache();
    }

    public int getColorPrimary() {
        return this.mColorPrimary;
    }

    @Override // com.stepos.activeview.download.GetActInterface
    public Context getContextForTask() {
        return getContext();
    }

    public View getItemViewById(String str) {
        if (this.mViewElementCacheMap.containsKey(str)) {
            return this.mViewElementCacheMap.get(str).mView;
        }
        return null;
    }

    public int getTimelineDuration() {
        Timeline timeline = this.mTimeline;
        if (timeline != null) {
            return timeline.getDuration();
        }
        return 0;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getVersion() {
        return Version.VERSION;
    }

    public void gotoAnimEnd() {
        for (Timeline timeline : this.mTimelineMap.values()) {
            if (timeline != null) {
                timeline.stop();
            }
        }
    }

    public void gotoAnimStart() {
        stopAnimation();
        for (Timeline timeline : this.mTimelineMap.values()) {
            if (timeline != null) {
                timeline.setCurrentPlayTime(0L);
            }
        }
    }

    public boolean hasDefaultImage() {
        return this.mHasDefaultImage;
    }

    public boolean hasSensorAnim() {
        ArrayList<OrientationData> arrayList = this.mOrientationData;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    public boolean haveCustomAnimation(String str) {
        return findCustomEvent(str) != null;
    }

    public boolean isCustomAnimationRunning(String str) {
        ArrayList<Timeline> arrayList = this.mCustomEventMap.get(str);
        if (arrayList == null) {
            return false;
        }
        Iterator<Timeline> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isShowing() {
        return isShown();
    }

    public void loadData(String str) {
        if (str == null) {
            LogUtil.e(LOG_TAG, "loadData zipExtractedPath is NULL");
            return;
        }
        this.mUrl = str;
        this.zipExtractedDir = str;
        if (!GetActManager.getInstance().isRequestInFlight(this.mUrl)) {
            GetActManager.GetActRequest getActRequestCreateRequest = GetActManager.getInstance().createRequest(this.mUrl, 4, this);
            GetActManager.getInstance().putRequest(getActRequestCreateRequest);
            getActRequestCreateRequest.startGetData();
        } else {
            GetActManager.GetActRequest request = GetActManager.getInstance().getRequest(this.mUrl);
            if (request != null) {
                request.addWaitActiveViews(this);
            }
        }
    }

    public void loadFromWeb(String str) {
        loadFromWeb(str, 0, 0);
    }

    public void loadImage(String str, float f4, float f5, OnAsyncTaskListener onAsyncTaskListener) {
        this.mShowAfterImagesLoaded = true;
        LoadImageTask loadImageTask = new LoadImageTask(this.zipExtractedDir + "/" + str, onAsyncTaskListener, f4, f5);
        loadImageTask.execute(new Void[0]);
        this.mLoadResTaskMap.put(loadImageTask, Boolean.FALSE);
    }

    public void loadResourceFile(String str) {
        extractZipFile(str, false);
    }

    public void loadResourceFileFromAssets(String str) {
        extractZipFile(str, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopDataBinding();
        if (this.mHasDefaultImage && this.mResourceLoaded) {
            if (!this.isLoadFromCache && getChildCount() == 2) {
                if (getChildAt(0) == this.mDefaultImageView) {
                    getChildAt(1).setAlpha(1.0f);
                    getChildAt(1).setVisibility(0);
                }
                removeView(this.mDefaultImageView);
            }
            this.isLoadFromCache = true;
        }
        if (getChildAt(0) != null) {
            getChildAt(0).setVisibility(0);
        }
    }

    @Override // com.stepos.activeview.download.GetActInterface
    public void onDownloadError() {
        notifyListenerInMainThread(2, 0, "Download file error!");
    }

    @Override // com.stepos.activeview.download.GetActInterface
    public void onDownloadSuccess(String str) {
        notifyListenerInMainThread(2, 1, g.m("Downloaded file=", str));
    }

    @Override // com.stepos.activeview.download.GetActInterface
    public void onExtractError(String str) {
        notifyListenerInMainThread(3, 0, str);
    }

    @Override // com.stepos.activeview.download.GetActInterface
    public void onExtractSuccess(String str) {
        notifyListenerInMainThread(3, 1, g.m("extracted dir=", str));
        this.zipExtractedDir = str;
    }

    @Override // com.stepos.activeview.download.GetActInterface
    public void onLoadDataError() {
        notifyListenerInMainThread(4, 0, "load and parse json file FAIL");
    }

    @Override // com.stepos.activeview.download.GetActInterface
    public void onLoadDataSuccess(ActiveData activeData) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        notifyListenerInMainThread(4, 1, "load and parse json file success");
        setData(activeData);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int measuredWidth = getMeasuredWidth();
        StringBuilder sbT = g.t("onMeasure  getMeasuredWidth =", measuredWidth, ", mMeasuredWidth =");
        sbT.append(this.mMeasuredWidth);
        LogUtil.i(LOG_TAG, sbT.toString());
        if (this.mMeasuredWidth != measuredWidth) {
            this.mMeasured = true;
            this.mMeasuredWidth = measuredWidth;
            post(new Runnable() { // from class: com.stepos.activeview.views.ActiveView.12
                @Override // java.lang.Runnable
                public void run() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                    if (ActiveView.this.mActiveData != null) {
                        ActiveView activeView = ActiveView.this;
                        activeView.setData(activeView.mActiveData);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i4) throws IllegalArgumentException {
        super.onVisibilityChanged(view, i4);
        if (this.mHasDataBinding) {
            if (i4 == 0) {
                this.mVariableContainer.startApplying();
            } else {
                this.mVariableContainer.stopApplying();
            }
        }
    }

    public void pauseAnimation() {
        for (Timeline timeline : this.mTimelineMap.values()) {
            if (timeline != null) {
                timeline.pause();
            }
        }
        for (ActiveAnimation activeAnimation : this.mAnimations.values()) {
            if (activeAnimation != null) {
                activeAnimation.pauseAnimation();
            }
        }
    }

    public void pauseCustomAnimation(String str) {
        ArrayList<Timeline> arrayList = this.mCustomEventMap.get(str);
        if (arrayList != null) {
            Iterator<Timeline> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause();
            }
        }
    }

    public void releaseVideo() {
        Iterator<TextureVideoView> it = this.mTextureVideoView.values().iterator();
        while (it.hasNext()) {
            new ReleaseVideoTask(it.next()).execute(new Void[0]);
        }
        this.mTextureVideoView.clear();
    }

    public void removeDefaultImage() {
        this.mHasDefaultImage = false;
    }

    public void resumeAnimation() {
        for (Timeline timeline : this.mTimelineMap.values()) {
            if (timeline != null && timeline.isPaused()) {
                timeline.resume();
            }
        }
        for (ActiveAnimation activeAnimation : this.mAnimations.values()) {
            if (activeAnimation != null) {
                activeAnimation.resumeAnimation();
            }
        }
    }

    public void resumeCustomAnimation(String str) {
        ArrayList<Timeline> arrayList = this.mCustomEventMap.get(str);
        if (arrayList != null) {
            Iterator<Timeline> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().resume();
            }
        }
    }

    public void reverseAnimation() {
        if (this.mCanReverseAnimaion) {
            for (Timeline timeline : this.mTimelineMap.values()) {
                if (timeline != null) {
                    timeline.reverse();
                }
            }
        }
    }

    public void setAutoDeleteFolder(boolean z4, int i4) {
        this.mAutoDeleteFolder = z4;
        this.mFolderHours = i4;
    }

    public void setAutoGradientDisplay(boolean z4) {
        setAutoGradientDisplay(z4, 800);
    }

    public void setAutoReleaseVideo(Boolean bool) {
        this.mAutoReleaseVideo = bool.booleanValue();
    }

    public void setAutoRunAnimation(boolean z4) {
        this.mAutoRunAnim = z4;
    }

    public void setData(ActiveData activeData) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (activeData == null) {
            LogUtil.i(LOG_TAG, "setData activeData is NULL!");
            return;
        }
        LogUtil.enableInfoLog(activeData.isDebugLog());
        this.mActiveData = activeData;
        createViewsFromActiveData();
    }

    public void setDefaultImage(int i4, int i5, int i6) {
        setDefaultImageDrawable(i4, i5, this.mContext.getDrawable(i6));
    }

    public void setFrameDelay(long j4) {
        TimelineTicker.setFrameDelay(j4);
    }

    public void setImageCache(ImageCache imageCache) {
        ImageCacheUtils.getInstance().setImageCache(imageCache);
    }

    public void setLayerAnimEnable(Boolean bool) {
        this.mUseLayerAni = bool.booleanValue();
    }

    public void setLayerAnimListener(OnLayerAniListener onLayerAniListener) {
        this.mOnLayerAniListener = onLayerAniListener;
    }

    public void setOnEventListener(OnEventListener onEventListener) {
        this.mOnEventListener = onEventListener;
    }

    public void setOnLoadImageListener(OnLoadImageListener onLoadImageListener) {
        this.mOnLoadImageListener = onLoadImageListener;
    }

    public void setOnUpdateListener(OnUpdateListener onUpdateListener) {
        this.mOnUpdateListener = onUpdateListener;
    }

    @Deprecated
    public void setOnVersionListener(OnVersionListener onVersionListener) {
    }

    public void setOrientationAnimListener(OnOrientationAnimationListener onOrientationAnimationListener) {
        this.mOnOrientationAnimationListener = onOrientationAnimationListener;
    }

    public void setParallaxEnable(Boolean bool) {
        this.mUseParallax = bool.booleanValue();
    }

    public void setParallaxListener(OnParallaxListener onParallaxListener) {
        this.mOnParallaxListener = onParallaxListener;
    }

    public void setSensorAnimEnable(boolean z4) {
        this.mEnableOrientationAnim = z4;
    }

    public void setTextContent(String str, String str2) {
        if (this.mViewElementCacheMap.containsKey(str)) {
            ViewElementData viewElementData = this.mViewElementCacheMap.get(str);
            if (viewElementData.mViewType.equals(VIEW_TEXTVIEW)) {
                ((TextView) viewElementData.mView).setText(str2);
            }
        }
    }

    public void startAnimation() throws IllegalArgumentException {
        for (Timeline timeline : this.mTimelineMap.values()) {
            if (timeline != null) {
                timeline.play();
            }
        }
        for (ActiveAnimation activeAnimation : this.mAnimations.values()) {
            if (activeAnimation != null) {
                activeAnimation.startAnimation();
            }
        }
        startDataBinding();
        updateParallaxData();
        updateLayerAniData();
        if (this.mHasApproachAnim) {
            return;
        }
        updateOrientationData();
    }

    public void startCustomAnimation(String str) {
        CustomEvent customEventFindCustomEvent = findCustomEvent(str);
        if (customEventFindCustomEvent != null) {
            activeCustomEvent(customEventFindCustomEvent);
        }
    }

    public void startOrientationAnim() {
        updateOrientationData();
    }

    public void stopAnimation() {
        for (Timeline timeline : this.mTimelineMap.values()) {
            if (timeline != null) {
                timeline.stop();
            }
        }
        for (ActiveAnimation activeAnimation : this.mAnimations.values()) {
            if (activeAnimation != null) {
                activeAnimation.stopAnimation();
            }
        }
        stopDataBinding();
    }

    public void stopCustomAnimation(String str) {
        ArrayList<Timeline> arrayList = this.mCustomEventMap.get(str);
        if (arrayList != null) {
            Iterator<Timeline> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
        }
    }

    public void updateResource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (str == null) {
            LogUtil.e(LOG_TAG, "updateResource is NULL !!!");
            return;
        }
        LogUtil.i(LOG_TAG, "updateResource url=".concat(str));
        if (str.endsWith(".act") || str.endsWith(".zip")) {
            downloadPackage(str);
        } else if (isVideoURL(str)) {
            downloadVideo(str, getMeasuredWidth(), getMeasuredHeight());
        } else {
            downloadImage(str);
        }
    }

    public void downloadPackage(String str, OnLoadImageListener onLoadImageListener) throws IllegalArgumentException {
        if (str == null || str.isEmpty()) {
            LogUtil.e(LOG_TAG, "Illegal RUL !!! url = " + str);
            return;
        }
        String str2 = this.mUrl;
        if (str2 != null && str2.equals(str) && this.mResourceLoaded) {
            notifyListenerInMainThread(7, 1, "Url Not Changed:" + this.mUrl);
            startAnimation();
            return;
        }
        cancelAllRunningTasks();
        this.mUrl = str;
        if (onLoadImageListener != null) {
            this.mOnLoadImageListener = onLoadImageListener;
        }
        if (hasCacheDir()) {
            return;
        }
        if (!this.isLoadFromCache && this.mHasDefaultImage && this.mDefaultImageView.getParent() == null) {
            addView(this.mDefaultImageView, this.mDefaultImageLayoutParams);
        }
        if (GetActManager.getInstance().isRequestInFlight(this.mUrl)) {
            GetActManager.getInstance().getRequest(this.mUrl).addWaitActiveViews(this);
            return;
        }
        GetActManager.GetActRequest getActRequestCreateRequest = GetActManager.getInstance().createRequest(this.mUrl, 1, this);
        GetActManager.getInstance().putRequest(getActRequestCreateRequest);
        getActRequestCreateRequest.startGetData();
        LogUtil.i(LOG_TAG, "Begin download :".concat(str));
        HashMap map = new HashMap();
        map.put(ActiveUsageStatsUtils.FILE_URL, this.mUrl);
        ActiveUsageStatsUtils.getInstance().recordEvent(ActiveUsageStatsUtils.EVENT_DOWNLOAD, "", map);
    }

    public void loadFromWeb(String str, int i4, int i5) {
        if (str == null || str.isEmpty()) {
            LogUtil.e(LOG_TAG, "webUrl");
            return;
        }
        WebView webView = this.mWebView;
        if (webView == null) {
            WebView webView2 = new WebView(this.mContext);
            this.mWebView = webView2;
            webView2.getSettings().setJavaScriptEnabled(true);
        } else if (webView.getParent() != null) {
            this.mWebView.loadUrl(str);
            return;
        }
        this.mWebView.setLayoutParams((i4 == 0 && i5 == 0) ? new FrameLayout.LayoutParams(-1, -1) : new FrameLayout.LayoutParams(i4, i5));
        clearActiveView();
        addView(this.mWebView);
        LogUtil.i(LOG_TAG, "webUrl=".concat(str));
        this.mWebView.loadUrl(str);
    }

    public void setAutoGradientDisplay(boolean z4, int i4) {
        this.mAutoGradientDisplay = z4;
        this.mAutpAlphaAnimation = null;
        if (z4) {
            this.mAutpAlphaAnimation = getAlphaAnimation(i4);
        }
    }

    public void setDefaultImage(int i4) {
        setDefaultImage(-1, -1, i4);
    }

    public void setDefaultImage(int i4, int i5, Bitmap bitmap) {
        if (bitmap != null) {
            setDefaultImageDrawable(i4, i5, new BitmapDrawable(this.mContext.getResources(), bitmap));
        }
    }

    public void setDefaultImage(Bitmap bitmap) {
        setDefaultImage(-1, -1, bitmap);
    }

    public void setDefaultImage(Drawable drawable) {
        setDefaultImage(-1, -1, drawable);
    }

    public void setDefaultImage(int i4, int i5, Drawable drawable) {
        setDefaultImageDrawable(i4, i5, drawable);
    }

    public void downloadImage(String str, OnLoadImageListener onLoadImageListener) {
        setOnLoadImageListener(onLoadImageListener);
        downloadImage(str);
    }

    public ActiveView(Context context, int i4, int i5, int i6) {
        this(context);
        setDefaultImage(i4, i5, i6);
    }

    public ActiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTimelineMap = new HashMap<>();
        this.mCustomEventMap = new HashMap<>();
        this.mAnimations = new HashMap<>();
        this.mTextureVideoView = new HashMap<>();
        this.mTweenItemMap = new HashMap<>();
        this.mLoadResTaskMap = new HashMap<>();
        this.mViewElementCacheMap = new HashMap<>();
        this.mScaleRate = 1.0f;
        this.mMeasuredWidth = 0;
        this.ActiveViewWidth = 0;
        this.ActiveViewHeight = 0;
        this.mMeasured = false;
        this.mAutoRunAnim = true;
        this.mAutoGradientDisplay = false;
        this.mUseParallax = true;
        this.mUseLayerAni = true;
        this.mEnableOrientationAnim = false;
        this.mShowAfterImagesLoaded = false;
        this.mResourceLoaded = false;
        this.mAutoDeleteFolder = true;
        this.mFolderHours = SyslogConstants.LOG_LOCAL5;
        this.mCanReverseAnimaion = true;
        this.mHasApproachAnim = false;
        this.mAutoReleaseVideo = true;
        this.mHasDefaultImage = false;
        this.isLoadFromCache = false;
        this.mDefaultImgAnimListener = null;
        init(context);
    }
}
