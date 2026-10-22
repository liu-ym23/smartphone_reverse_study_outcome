package com.bytedance.android.live.core.utils.fresco;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.livesdk.config.InteractCustomDiskConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class FrescoLoader {
    public static final String DEFAULT_CALLER_ID = "ttlive_fresco_loader";
    private static final float FLOAT_0_5 = 0.5f;
    private static final int SDK_VERSION_19 = 19;
    private py.k imageModel;
    private ColorFilter mActualImageColorFilter;
    private PointF mActualImageFocusPoint;
    private ScalingUtils.ScaleType mActualImageScaleType;
    private boolean mAutoPlayAnimations;
    private Drawable mBackgroundDrawable;
    private boolean mBmp565;
    private boolean mCompatTemporaryDetach;
    private Context mContext;
    private ControllerListener mControllerListener;
    private String mCustomCacheName;
    private float mDesiredAspectRatio;
    private DraweeHolder<DraweeHierarchy> mDraweeHolder;
    private b mDraweeHolderDispatcher;
    private int mFadeDuration;
    private Drawable mFailureDrawable;
    private ScalingUtils.ScaleType mFailureScaleType;
    private boolean mLocalThumbnailPreviewsEnabled;
    private Uri mLowerUri;
    private List<Drawable> mOverlays;
    private Drawable mPlaceholderDrawable;
    private ScalingUtils.ScaleType mPlaceholderScaleType;
    private Postprocessor mPostprocessor;
    private Drawable mPressedStateOverlay;
    private Drawable mProgressBarDrawable;
    private ScalingUtils.ScaleType mProgressScaleType;
    private boolean mProgressiveRenderingEnabled;
    private ResizeOptions mResizeOptions;
    private boolean mRetainImageOnFailure;
    private Drawable mRetryDrawable;
    private ScalingUtils.ScaleType mRetryScaleType;
    private RoundingParams mRoundingParams;
    private boolean mTapToRetryEnabled;
    private Uri mUri;
    private boolean mUseFixedWidth;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f66136a = null;

        static {
            int[] r100 = new int[ImageView.ScaleType.values().length];
            f66136a = r100;
            r100[ImageView.ScaleType.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f66136a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f66136a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f66136a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f66136a[ImageView.ScaleType.FIT_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f66136a[ImageView.ScaleType.FIT_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f66136a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f66136a[ImageView.ScaleType.MATRIX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public class b implements View.OnAttachStateChangeListener, View.OnTouchListener, c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrescoLoader f66137a;

        @Override // com.bytedance.android.live.core.utils.fresco.FrescoLoader.c
        public final void a() {
        }

        public b(FrescoLoader r100) {
            this.f66137a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            if (FrescoLoader.access$100(this.f66137a) == null) goto L6;
            FrescoLoader.access$100(this.f66137a).onAttach();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            if (FrescoLoader.access$100(this.f66137a) == null) goto L6;
            FrescoLoader.access$100(this.f66137a).onDetach();
            return;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (FrescoLoader.access$100(this.f66137a) != null) goto L5;
            return false;
        L5:
            if (FrescoLoader.access$100(this.f66137a).onTouchEvent(r101) == false) goto L10;
            return true;
        L10:
            return false;
        }
    }

    public interface c {
        void a();
    }

    public FrescoLoader roundAsCircle() {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setRoundAsCircle(true);
        return this;
    }

    private FrescoLoader(Context r100) {
        this.mBmp565 = false;
        this.mContext = r100.getApplicationContext();
        this.mDraweeHolderDispatcher = null;
        this.mDesiredAspectRatio = 0.0f;
        this.mUseFixedWidth = true;
        this.mFadeDuration = 300;
        this.mPlaceholderDrawable = null;
        ScalingUtils.ScaleType r101 = GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE;
        this.mPlaceholderScaleType = r101;
        this.mRetryDrawable = null;
        this.mRetryScaleType = r101;
        this.mFailureDrawable = null;
        this.mFailureScaleType = r101;
        this.mProgressBarDrawable = null;
        this.mProgressScaleType = r101;
        this.mActualImageScaleType = GenericDraweeHierarchyBuilder.DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
        this.mActualImageFocusPoint = null;
        this.mActualImageColorFilter = null;
        this.mBackgroundDrawable = null;
        this.mOverlays = null;
        this.mPressedStateOverlay = null;
        this.mRoundingParams = null;
        this.mTapToRetryEnabled = false;
        this.mAutoPlayAnimations = false;
        this.mRetainImageOnFailure = false;
        this.mProgressiveRenderingEnabled = false;
        this.mLocalThumbnailPreviewsEnabled = false;
        this.mPostprocessor = null;
        this.mControllerListener = null;
        this.mDraweeHolder = null;
    }

    public static /* synthetic */ DraweeHolder access$100(FrescoLoader r100) {
        return r100.mDraweeHolder;
    }

    private static boolean isAttachedToWindow(View r100) {
        return r100.isAttachedToWindow();
    }

    public static FrescoLoader with(Context r100) {
        if (r100 == null) goto L6;
        return new FrescoLoader(r100);
    L6:
        throw new IllegalArgumentException("appContext == null");
    }

    public FrescoLoader actualScaleType(ImageView.ScaleType r100) {
        this.mActualImageScaleType = convertToFrescoScaleType(r100, GenericDraweeHierarchyBuilder.DEFAULT_ACTUAL_IMAGE_SCALE_TYPE);
        return this;
    }

    public FrescoLoader autoPlayAnimations(boolean r100) {
        this.mAutoPlayAnimations = r100;
        return this;
    }

    public FrescoLoader controllerListener(ControllerListener r100) {
        this.mControllerListener = r100;
        return this;
    }

    public FrescoLoader cornersRadii(float[] r100) {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setCornersRadii(r100);
        return this;
    }

    public FrescoLoader cornersRadius(int r100) {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setCornersRadius(r100);
        return this;
    }

    public FrescoLoader customCacheName(String r100) {
        this.mCustomCacheName = r100;
        return this;
    }

    public FrescoLoader fadeDuration(int r100) {
        this.mFadeDuration = r100;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void into(ImageView r110) {
        if (r110 != 0) goto L5;
        return;
    L5:
        if (this.mUri != null) goto L10;
        if (this.imageModel != null) goto L10;
        return;
    L10:
        if (this.mDraweeHolder != null) goto L15;
        Object r100 = TagCompat.getTag(r110);
        if ((r100 instanceof DraweeHolder) == false) goto L15;
        this.mDraweeHolder = (DraweeHolder) r100;
    L15:
        if (this.mResizeOptions == null) goto L17;
    L21:
        DraweeHolder<DraweeHierarchy> r101 = this.mDraweeHolder;
        if (r101 != null) goto L50;
        this.mDraweeHolder = DraweeHolder.create(null, r110.getContext());
        if (this.mDraweeHolderDispatcher != null) goto L26;
        this.mDraweeHolderDispatcher = new b(this);
    L26:
        this.mDraweeHolder.setHierarchy(new GenericDraweeHierarchyBuilder(r110.getResources()).setPlaceholderImage(this.mPlaceholderDrawable).setPlaceholderImageScaleType(this.mPlaceholderScaleType).setFailureImage(this.mFailureDrawable).setFailureImageScaleType(this.mFailureScaleType).setProgressBarImage(this.mProgressBarDrawable).setProgressBarImageScaleType(this.mProgressScaleType).setRetryImage(this.mRetryDrawable).setRetryImageScaleType(this.mRetryScaleType).setFadeDuration(this.mFadeDuration).setActualImageFocusPoint(this.mActualImageFocusPoint).setActualImageColorFilter(this.mActualImageColorFilter).setActualImageScaleType(this.mActualImageScaleType).setBackground(this.mBackgroundDrawable).setOverlays(this.mOverlays).setPressedStateOverlay(this.mPressedStateOverlay).setRoundingParams(this.mRoundingParams).build());
        ImageRequest[] r102 = createImageRequests(this.mUri, this.imageModel, this.mResizeOptions, this.mPostprocessor, this.mBmp565, this.mCustomCacheName);
        if (r102 != null) goto L29;
        return;
    L29:
        if (r102.length == 0) goto L81;
        PipelineDraweeControllerBuilder r103 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(this.mAutoPlayAnimations).setControllerListener(this.mControllerListener).setOldController(this.mDraweeHolder.getController()).setFirstAvailableImageRequests(r102).setRetainImageOnFailure(this.mRetainImageOnFailure).setTapToRetryEnabled(this.mTapToRetryEnabled);
        if (TextUtils.isEmpty(this.mCustomCacheName) == true) goto L34;
        r103.setCallerContext(this.mCustomCacheName);
    L35:
        Uri r104 = this.mLowerUri;
        if (r104 == null) goto L38;
        r103.setLowResImageRequest(ImageRequest.fromUri(r104));
    L38:
        this.mDraweeHolder.setController(r103.build());
        if (this.mCompatTemporaryDetach == false) goto L42;
        new h(r110, this.mDraweeHolderDispatcher);
    L48:
        r110.setOnTouchListener(this.mDraweeHolderDispatcher);
        TagCompat.setTag(r110, this.mDraweeHolder);
    L64:
        if (this.mDesiredAspectRatio == 0.0f) goto L79;
        ViewGroup.LayoutParams r105 = r110.getLayoutParams();
        if (r105 == null) goto L79;
        int r106 = r105.width;
        int r107 = r105.height;
        if (this.mUseFixedWidth == false) goto L72;
        if (r106 <= 0) goto L75;
        if (r107 != 0) goto L75;
        r107 = (int) (((((double) r106) * 1.0d) / ((double) this.mDesiredAspectRatio)) + 0.5d);
    L76:
        if (r106 == (-1)) goto L79;
        if (r107 == (-1)) goto L79;
        r105.width = r106;
        r105.height = r107;
        r110.requestLayout();
    L75:
        r106 = -1;
        r107 = -1;
        goto L76
    L72:
        if (r107 <= 0) goto L75;
        if (r106 != 0) goto L75;
        r106 = (int) ((r107 * this.mDesiredAspectRatio) + 0.5f);
    L79:
        r110.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
        return;
    L42:
        if ((r110 instanceof c) == false) goto L45;
        ((c) r110).a();
    L45:
        if (isAttachedToWindow(r110) == false) goto L47;
        this.mDraweeHolderDispatcher.onViewAttachedToWindow(r110);
    L47:
        r110.addOnAttachStateChangeListener(this.mDraweeHolderDispatcher);
        goto L48
    L34:
        r103.setCallerContext(DEFAULT_CALLER_ID);
        goto L35
    L81:
        return;
    L50:
        r101.onDetach();
        this.mDraweeHolder.setHierarchy(new GenericDraweeHierarchyBuilder(r110.getResources()).setPlaceholderImage(this.mPlaceholderDrawable).setPlaceholderImageScaleType(this.mPlaceholderScaleType).setFailureImage(this.mFailureDrawable).setFailureImageScaleType(this.mFailureScaleType).setProgressBarImage(this.mProgressBarDrawable).setProgressBarImageScaleType(this.mProgressScaleType).setRetryImage(this.mRetryDrawable).setRetryImageScaleType(this.mRetryScaleType).setFadeDuration(this.mFadeDuration).setActualImageFocusPoint(this.mActualImageFocusPoint).setActualImageColorFilter(this.mActualImageColorFilter).setActualImageScaleType(this.mActualImageScaleType).setBackground(this.mBackgroundDrawable).setOverlays(this.mOverlays).setPressedStateOverlay(this.mPressedStateOverlay).setRoundingParams(this.mRoundingParams).build());
        ImageRequest[] r108 = createImageRequests(this.mUri, this.imageModel, this.mResizeOptions, this.mPostprocessor, this.mBmp565, this.mCustomCacheName);
        if (r108 != null) goto L53;
        return;
    L53:
        if (r108.length == 0) goto L83;
        PipelineDraweeControllerBuilder r109 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(this.mAutoPlayAnimations).setControllerListener(this.mControllerListener).setFirstAvailableImageRequests(r108).setOldController(this.mDraweeHolder.getController()).setRetainImageOnFailure(this.mRetainImageOnFailure).setTapToRetryEnabled(this.mTapToRetryEnabled);
        if (TextUtils.isEmpty(this.mCustomCacheName) == true) goto L58;
        r109.setCallerContext(this.mCustomCacheName);
    L59:
        Uri r111 = this.mLowerUri;
        if (r111 == null) goto L62;
        r109.setLowResImageRequest(ImageRequest.fromUri(r111));
    L62:
        this.mDraweeHolder.setController(r109.build());
        this.mDraweeHolder.onAttach();
        goto L64
    L58:
        r109.setCallerContext(DEFAULT_CALLER_ID);
        goto L59
    L83:
        return;
    L17:
        if (r110.getMeasuredWidth() <= 0) goto L21;
        if (r110.getMeasuredHeight() <= 0) goto L21;
        resize(r110.getMeasuredWidth(), r110.getMeasuredHeight());
        goto L21
    }

    public FrescoLoader load(int r100) {
        return load(new Uri.Builder().scheme("res").path(String.valueOf(r100)).build());
    }

    public FrescoLoader placeholder(int r100) {
        return placeholder(this.mContext.getResources().getDrawable(r100));
    }

    public FrescoLoader placeholderScaleType(ImageView.ScaleType r100) {
        this.mPlaceholderScaleType = convertToFrescoScaleType(r100, GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE);
        return this;
    }

    public FrescoLoader postProcessor(Postprocessor r100) {
        this.mPostprocessor = r100;
        return this;
    }

    public FrescoLoader load(String r100) {
        return load(UriProtector.parse(r100));
    }

    public FrescoLoader placeholder(Drawable r100) {
        this.mPlaceholderDrawable = r100;
        return this;
    }

    public FrescoLoader load(Uri r100) {
        this.mUri = r100;
        return this;
    }

    public FrescoLoader load(py.k r100) {
        this.imageModel = r100;
        return this;
    }

    private static ScalingUtils.ScaleType convertToFrescoScaleType(ImageView.ScaleType r100, ScalingUtils.ScaleType r101) {
        switch(a.f66136a[r100.ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        return r101;
    L6:
        return ScalingUtils.ScaleType.FOCUS_CROP;
    L8:
        return ScalingUtils.ScaleType.FIT_XY;
    L10:
        return ScalingUtils.ScaleType.FIT_END;
    L12:
        return ScalingUtils.ScaleType.FIT_START;
    L14:
        return ScalingUtils.ScaleType.FIT_CENTER;
    L16:
        return ScalingUtils.ScaleType.CENTER_INSIDE;
    L18:
        return ScalingUtils.ScaleType.CENTER_CROP;
    L20:
        return ScalingUtils.ScaleType.CENTER;
    }

    public FrescoLoader border(int r100, float r101) {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setBorder(r100, r101);
        return this;
    }

    public FrescoLoader resize(int r100, int r101) {
        this.mResizeOptions = new ResizeOptions(r100, r101);
        return this;
    }

    private static ImageRequest createImageRequestWithUri(Uri r100, ResizeOptions r101, String r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ImageRequestBuilder r103 = ImageRequestBuilder.newBuilderWithSource(r100);
        if (r101 == null) goto L9;
        r103.setResizeOptions(r101);
    L9:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        if (((Boolean) InteractCustomDiskConfig.f119738a.getValue()).booleanValue() == false) goto L14;
        r103.setCacheChoice(ImageRequest.CacheChoice.CUSTOM).setCustomCacheName(r102);
    L14:
        return r103.build();
    }

    public FrescoLoader border(int r100, float r101, boolean r102) {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setBorder(r100, r101);
        this.mRoundingParams.setScaleDownInsideBorders(r102);
        return this;
    }

    public FrescoLoader cornersRadii(float r100, float r101, float r102, float r103) {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setCornersRadii(r100, r101, r102, r103);
        return this;
    }

    private static ImageRequest[] createImageRequests(Uri r100, py.k r101, ResizeOptions r102, Postprocessor r103, boolean r104, String r110) {
        if (r100 != null) goto L9;
        if (r101 == null) goto L8;
        if (Lists.isEmpty(r101.getUrls()) == false) goto L9;
    L8:
        return new ImageRequest[0];
    L9:
        ArrayList r105 = new ArrayList();
        ImageRequest r106 = createImageRequestWithUri(r100, r102, r110);
        if (r106 == null) goto L12;
        r105.add(r106);
    L12:
        if (r101 == null) goto L35;
        if (Lists.isEmpty(r101.getUrls()) == true) goto L35;
        ImageNetworkRequestsMonitor r107 = new ImageNetworkRequestsMonitor();
        Iterator<String> r108 = r101.getUrls().iterator();
    L17:
        if (r108.hasNext() == false) goto L35;
        String r109 = r108.next();
        if (StringUtils.isEmpty(r109) == true) goto L17;
        ImageRequestBuilder r111 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r109));
        if (r103 == null) goto L24;
        r111.setPostprocessor(r103);
    L24:
        if (r102 == null) goto L26;
        r111.setResizeOptions(r102);
    L26:
        if (r104 == false) goto L29;
        ImageDecodeOptionsBuilder r112 = ImageDecodeOptions.newBuilder();
        r112.setBitmapConfig(Bitmap.Config.RGB_565);
        r111.setImageDecodeOptions(r112.build());
    L29:
        if (TextUtils.isEmpty(r110) == false) goto L31;
    L33:
        r107.monitor(r111);
        r105.add(r111.build());
        goto L17
    L31:
        if (((Boolean) InteractCustomDiskConfig.f119738a.getValue()).booleanValue() == false) goto L33;
        r111.setCacheChoice(ImageRequest.CacheChoice.CUSTOM).setCustomCacheName(r110);
    L35:
        if (r105.size() != 0) goto L39;
        return new ImageRequest[0];
    L39:
        return (ImageRequest[]) r105.toArray(new ImageRequest[r105.size()]);
    }
}
