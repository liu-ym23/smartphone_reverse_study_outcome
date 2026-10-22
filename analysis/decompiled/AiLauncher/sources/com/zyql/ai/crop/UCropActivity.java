package com.zyql.ai.crop;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.appcompat.app.g;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.a;
import androidx.core.graphics.BlendModeCompat;
import com.zyql.ai.crop.UCrop;
import com.zyql.ai.crop.callback.BitmapCropCallback;
import com.zyql.ai.crop.model.AspectRatio;
import com.zyql.ai.crop.util.SelectedStateListDrawable;
import com.zyql.ai.crop.view.GestureCropImageView;
import com.zyql.ai.crop.view.OverlayView;
import com.zyql.ai.crop.view.TransformImageView;
import com.zyql.ai.crop.view.UCropView;
import com.zyql.ai.crop.view.widget.AspectRatioTextView;
import com.zyql.ai.crop.view.widget.HorizontalProgressWheelView;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.immersive.ImmersiveManage;
import com.zyql.ai.selector.tools.PictureFileUtils;
import com.zyql.ai.selector.tools.ScreenUtils;
import f.C4027a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p1.C5040a;
import p1.j;
import p1.r;
import t0.C5499a;

/* loaded from: classes4.dex */
public class UCropActivity extends d {
    public static final int ALL = 3;
    private static final long CONTROLS_ANIMATION_DURATION = 50;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    private static final String TAG = "UCropActivity";
    private boolean isDragFrame;
    private boolean isOpenWhiteStatusBar;
    private boolean isRotateEnabled;
    private boolean isScaleEnabled;
    private int mActiveControlsWidgetColor;
    private int mActiveWidgetColor;
    protected View mBlockingView;
    private j mControlsTransition;
    private GestureCropImageView mGestureCropImageView;
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;
    private int mRootViewBackgroundColor;
    protected int mScreenWidth;
    protected boolean mShowBottomControls;
    private int mStatusBarColor;
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;
    private int mToolbarCancelDrawable;
    private int mToolbarColor;
    private int mToolbarCropDrawable;
    private String mToolbarTitle;
    private int mToolbarWidgetColor;
    private UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;
    protected RelativeLayout uCropPhotoBox;
    private boolean mShowLoader = true;
    private List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    private List<AspectRatioTextView> mAspectRatioTextViews = new ArrayList();
    private Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private int[] mAllowedGestures = {1, 2, 3};
    private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener() { // from class: com.zyql.ai.crop.UCropActivity.1
        @Override // com.zyql.ai.crop.view.TransformImageView.TransformImageListener
        public void onLoadComplete() {
            UCropActivity.this.mUCropView.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.mBlockingView.setClickable(!r0.isOnTouch());
            UCropActivity.this.mShowLoader = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.zyql.ai.crop.view.TransformImageView.TransformImageListener
        public void onLoadFailure(Exception exc) {
            UCropActivity.this.setResultError(exc);
            UCropActivity.this.onBackPressed();
        }

        @Override // com.zyql.ai.crop.view.TransformImageView.TransformImageListener
        public void onRotate(float f10) {
            UCropActivity.this.setAngleText(f10);
        }

        @Override // com.zyql.ai.crop.view.TransformImageView.TransformImageListener
        public void onScale(float f10) {
            UCropActivity.this.setScaleText(f10);
        }
    };
    private final View.OnClickListener mStateClickListener = new View.OnClickListener() { // from class: com.zyql.ai.crop.UCropActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropActivity.this.setWidgetState(view.getId());
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    static {
        g.I(true);
    }

    private void changeSelectedTab(int i10) {
        r.a((ViewGroup) findViewById(R.id.ucrop_photobox), this.mControlsTransition);
        this.mWrapperStateScale.findViewById(R.id.text_view_scale).setVisibility(i10 == R.id.state_scale ? 0 : 8);
        this.mWrapperStateAspectRatio.findViewById(R.id.text_view_crop).setVisibility(i10 == R.id.state_aspect_ratio ? 0 : 8);
        this.mWrapperStateRotate.findViewById(R.id.text_view_rotate).setVisibility(i10 == R.id.state_rotate ? 0 : 8);
    }

    private void getCustomOptionsData(Intent intent) {
        this.isOpenWhiteStatusBar = intent.getBooleanExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR, false);
        int i10 = R.color.ucrop_color_statusbar;
        this.mStatusBarColor = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, a.c(this, i10));
        int i11 = R.color.ucrop_color_toolbar;
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, a.c(this, i11));
        this.mToolbarColor = intExtra;
        if (intExtra == 0) {
            this.mToolbarColor = a.c(this, i11);
        }
        if (this.mStatusBarColor == 0) {
            this.mStatusBarColor = a.c(this, i10);
        }
    }

    private void initiateRootViews() {
        this.uCropPhotoBox = (RelativeLayout) findViewById(R.id.ucrop_photobox);
        UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
        this.mUCropView = uCropView;
        this.mGestureCropImageView = uCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.ucrop_frame).setBackgroundColor(this.mRootViewBackgroundColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOnTouch() {
        Uri uri = (Uri) getIntent().getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        if (uri == null) {
            return true;
        }
        return isOnTouch(uri);
    }

    private void processOptions(Intent intent) {
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_COMPRESSION_FORMAT_NAME);
        Bitmap.CompressFormat compressFormatValueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (compressFormatValueOf == null) {
            compressFormatValueOf = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = compressFormatValueOf;
        this.mCompressQuality = intent.getIntExtra(UCrop.Options.EXTRA_COMPRESSION_QUALITY, 90);
        OverlayView overlayView = this.mOverlayView;
        Resources resources = getResources();
        int i10 = R.color.ucrop_color_default_crop_frame;
        overlayView.setDimmedBorderColor(intent.getIntExtra(UCrop.Options.EXTRA_DIMMED_LAYER_BORDER_COLOR, resources.getColor(i10)));
        this.isDragFrame = intent.getBooleanExtra(UCrop.Options.EXTRA_DRAG_CROP_FRAME, true);
        this.mOverlayView.setDimmedStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CIRCLE_STROKE_WIDTH_LAYER, 1));
        this.isScaleEnabled = intent.getBooleanExtra(UCrop.Options.EXTRA_SCALE, true);
        this.isRotateEnabled = intent.getBooleanExtra(UCrop.Options.EXTRA_ROTATE, true);
        int[] intArrayExtra = intent.getIntArrayExtra(UCrop.Options.EXTRA_ALLOWED_GESTURES);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.mAllowedGestures = intArrayExtra;
        }
        this.mGestureCropImageView.setMaxBitmapSize(intent.getIntExtra(UCrop.Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(intent.getFloatExtra(UCrop.Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra(UCrop.Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 500));
        this.mOverlayView.setFreestyleCropEnabled(intent.getBooleanExtra(UCrop.Options.EXTRA_FREE_STYLE_CROP, false));
        this.mOverlayView.setDragFrame(this.isDragFrame);
        this.mOverlayView.setDimmedColor(intent.getIntExtra(UCrop.Options.EXTRA_DIMMED_LAYER_COLOR, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.mOverlayView.setCircleDimmedLayer(intent.getBooleanExtra(UCrop.Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.mOverlayView.setShowCropFrame(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_FRAME, true));
        this.mOverlayView.setCropFrameColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(i10)));
        this.mOverlayView.setCropFrameStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_GRID, true));
        this.mOverlayView.setCropGridRowCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.mOverlayView.setCropGridColumnCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.mOverlayView.setCropGridColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
        float floatExtra2 = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            ViewGroup viewGroup = this.mWrapperStateAspectRatio;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.mGestureCropImageView.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra == null || intExtra >= parcelableArrayListExtra.size()) {
            this.mGestureCropImageView.setTargetAspectRatio(0.0f);
        } else {
            this.mGestureCropImageView.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioX() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioY());
        }
        int intExtra2 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_X, 0);
        int intExtra3 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (intExtra2 <= 0 || intExtra3 <= 0) {
            return;
        }
        this.mGestureCropImageView.setMaxResultImageSizeX(intExtra2);
        this.mGestureCropImageView.setMaxResultImageSizeY(intExtra3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetRotation() {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotateByAngle(int i10) {
        this.mGestureCropImageView.postRotate(i10);
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    private void setAllowedGestures(int i10) {
        if (isOnTouch()) {
            GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
            boolean z10 = this.isScaleEnabled;
            boolean z11 = false;
            if (z10 && this.mShowBottomControls) {
                int i11 = this.mAllowedGestures[i10];
                z10 = i11 == 3 || i11 == 1;
            }
            gestureCropImageView.setScaleEnabled(z10);
            GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
            boolean z12 = this.isRotateEnabled;
            if (z12 && this.mShowBottomControls) {
                int i12 = this.mAllowedGestures[i10];
                if (i12 == 3 || i12 == 2) {
                    z11 = true;
                }
            } else {
                z11 = z12;
            }
            gestureCropImageView2.setRotateEnabled(z11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAngleText(float f10) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f10)));
        }
    }

    private void setNavBar() {
        int intExtra = getIntent().getIntExtra(UCrop.Options.EXTRA_NAV_BAR_COLOR, 0);
        if (intExtra != 0) {
            getWindow().setNavigationBarColor(intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScaleText(float f10) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f10 * 100.0f))));
        }
    }

    @TargetApi(21)
    private void setStatusBarColor(int i10) {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidgetState(int i10) {
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = this.mWrapperStateAspectRatio;
            int i11 = R.id.state_aspect_ratio;
            viewGroup.setSelected(i10 == i11);
            ViewGroup viewGroup2 = this.mWrapperStateRotate;
            int i12 = R.id.state_rotate;
            viewGroup2.setSelected(i10 == i12);
            ViewGroup viewGroup3 = this.mWrapperStateScale;
            int i13 = R.id.state_scale;
            viewGroup3.setSelected(i10 == i13);
            this.mLayoutAspectRatio.setVisibility(i10 == i11 ? 0 : 8);
            this.mLayoutRotate.setVisibility(i10 == i12 ? 0 : 8);
            this.mLayoutScale.setVisibility(i10 == i13 ? 0 : 8);
            changeSelectedTab(i10);
            if (i10 == i13) {
                setAllowedGestures(0);
            } else if (i10 == i12) {
                setAllowedGestures(1);
            } else {
                setAllowedGestures(2);
            }
        }
    }

    private void setupAppBar() {
        setStatusBarColor(this.mStatusBarColor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.mToolbarColor);
        toolbar.setTitleTextColor(this.mToolbarWidgetColor);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.mToolbarWidgetColor);
        textView.setText(this.mToolbarTitle);
        Drawable drawableMutate = C4027a.b(this, this.mToolbarCancelDrawable).mutate();
        drawableMutate.setColorFilter(C5499a.a(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
        toolbar.setNavigationIcon(drawableMutate);
        setSupportActionBar(toolbar);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(false);
        }
    }

    private void setupAspectRatioWidget(Intent intent) {
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
            intExtra = 2;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        int i10 = -1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        if (getCurrentActivity() instanceof PictureMultiCuttingActivity) {
            this.mAspectRatioTextViews = new ArrayList();
            this.mCropAspectRatioViews = new ArrayList();
        }
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            AspectRatio aspectRatio = (AspectRatio) it.next();
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            this.mAspectRatioTextViews.add(aspectRatioTextView);
            linearLayout.addView(frameLayout);
            this.mCropAspectRatioViews.add(frameLayout);
        }
        this.mCropAspectRatioViews.get(intExtra).setSelected(true);
        for (ViewGroup viewGroup : this.mCropAspectRatioViews) {
            i10++;
            viewGroup.setTag(Integer.valueOf(i10));
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.crop.UCropActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UCropActivity.this.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
                    UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
                    if (view.isSelected()) {
                        return;
                    }
                    for (ViewGroup viewGroup2 : UCropActivity.this.mCropAspectRatioViews) {
                        viewGroup2.setSelected(viewGroup2 == view);
                    }
                }
            });
        }
    }

    private void setupRotateWidget() {
        this.mTextViewRotateAngle = (TextView) findViewById(R.id.text_view_rotate);
        int i10 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i10)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.zyql.ai.crop.UCropActivity.3
            @Override // com.zyql.ai.crop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScroll(float f10, float f11) {
                UCropActivity.this.mGestureCropImageView.postRotate(f10 / 42.0f);
            }

            @Override // com.zyql.ai.crop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            @Override // com.zyql.ai.crop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(i10)).setMiddleLineColor(this.mActiveWidgetColor);
        findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.crop.UCropActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UCropActivity.this.resetRotation();
            }
        });
        findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.crop.UCropActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UCropActivity.this.rotateByAngle(90);
            }
        });
    }

    private void setupScaleWidget() {
        this.mTextViewScalePercent = (TextView) findViewById(R.id.text_view_scale);
        int i10 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i10)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.zyql.ai.crop.UCropActivity.6
            @Override // com.zyql.ai.crop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScroll(float f10, float f11) {
                if (f10 > 0.0f) {
                    UCropActivity.this.mGestureCropImageView.zoomInImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f10 * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                } else {
                    UCropActivity.this.mGestureCropImageView.zoomOutImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f10 * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                }
            }

            @Override // com.zyql.ai.crop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            @Override // com.zyql.ai.crop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(i10)).setMiddleLineColor(this.mActiveWidgetColor);
    }

    private void setupStatesWrapper() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.mActiveControlsWidgetColor));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveControlsWidgetColor));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveControlsWidgetColor));
    }

    public void addBlockingView() {
        if (this.mBlockingView == null) {
            this.mBlockingView = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.mBlockingView.setLayoutParams(layoutParams);
            this.mBlockingView.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    public void closeActivity() {
        finish();
        exitAnimation();
    }

    public void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.mShowLoader = true;
        supportInvalidateOptionsMenu();
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback() { // from class: com.zyql.ai.crop.UCropActivity.8
            @Override // com.zyql.ai.crop.callback.BitmapCropCallback
            public void onBitmapCropped(Uri uri, int i10, int i11, int i12, int i13) {
                UCropActivity uCropActivity = UCropActivity.this;
                uCropActivity.setResultUri(uri, uCropActivity.mGestureCropImageView.getTargetAspectRatio(), i10, i11, i12, i13);
                if (UCropActivity.this.getCurrentActivity() instanceof PictureMultiCuttingActivity) {
                    return;
                }
                UCropActivity.this.onBackPressed();
            }

            @Override // com.zyql.ai.crop.callback.BitmapCropCallback
            public void onCropFailure(Throwable th) {
                UCropActivity.this.setResultError(th);
                UCropActivity.this.onBackPressed();
            }
        });
    }

    public void exitAnimation() {
        int intExtra = getIntent().getIntExtra(UCrop.Options.EXTRA_WINDOW_EXIT_ANIMATION, 0);
        int i10 = R.anim.ucrop_anim_fade_in;
        if (intExtra == 0) {
            intExtra = R.anim.ucrop_close;
        }
        overridePendingTransition(i10, intExtra);
    }

    public Activity getCurrentActivity() {
        return this;
    }

    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23(this, this.mStatusBarColor, this.mToolbarColor, this.isOpenWhiteStatusBar);
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return true;
    }

    @Override // b.q, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        closeActivity();
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        setNewRequestedOrientation(intent);
        getCustomOptionsData(intent);
        if (isImmersive()) {
            immersive();
        }
        setContentView(R.layout.ucrop_activity_photobox);
        this.mScreenWidth = ScreenUtils.getScreenWidth(this);
        setupViews(intent);
        setNavBar();
        setImageData(intent);
        setInitialState();
        addBlockingView();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_loader);
        Drawable icon = menuItemFindItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(C5499a.a(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
                menuItemFindItem.setIcon(icon);
            } catch (IllegalStateException e10) {
                Log.i(TAG, String.format("%s - %s", e10.getMessage(), "必須指定輸入以及輸出的 Uri"));
            }
            ((Animatable) menuItemFindItem.getIcon()).start();
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawableE = a.e(this, this.mToolbarCropDrawable);
        if (drawableE == null) {
            return true;
        }
        drawableE.mutate();
        drawableE.setColorFilter(C5499a.a(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
        menuItemFindItem2.setIcon(drawableE);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            cropAndSaveImage();
            return true;
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.mShowLoader);
        menu.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        if (gestureCropImageView != null) {
            gestureCropImageView.cancelAllAnimations();
        }
    }

    public void setImageData(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) intent.getParcelableExtra(UCrop.EXTRA_OUTPUT_URI);
        processOptions(intent);
        if (uri == null || uri2 == null) {
            setResultError(new NullPointerException("在你的 App 內复写颜色资源 (ucrop_color_toolbar_widget) 使 5.0 以前裝置正常运作"));
            onBackPressed();
            return;
        }
        try {
            boolean zIsOnTouch = isOnTouch(uri);
            this.mGestureCropImageView.setRotateEnabled(zIsOnTouch ? this.isRotateEnabled : zIsOnTouch);
            GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
            if (zIsOnTouch) {
                zIsOnTouch = this.isScaleEnabled;
            }
            gestureCropImageView.setScaleEnabled(zIsOnTouch);
            this.mGestureCropImageView.setImageUri(uri, uri2);
        } catch (Exception e10) {
            setResultError(e10);
            onBackPressed();
        }
    }

    public void setInitialState() {
        if (!this.mShowBottomControls) {
            setAllowedGestures(0);
        } else if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
            setWidgetState(R.id.state_aspect_ratio);
        } else {
            setWidgetState(R.id.state_scale);
        }
    }

    public void setNewRequestedOrientation(Intent intent) {
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ACTIVITY_ORIENTATION, -1);
        if (getRequestedOrientation() != intExtra) {
            setRequestedOrientation(intExtra);
        }
    }

    public void setResultError(Throwable th) {
        setResult(96, new Intent().putExtra(UCrop.EXTRA_ERROR, th));
    }

    public void setResultUri(Uri uri, float f10, int i10, int i11, int i12, int i13) {
        setResult(-1, new Intent().putExtra(UCrop.EXTRA_OUTPUT_URI, uri).putExtra(UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, f10).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, i12).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, i13).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, i10).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, i11));
    }

    public void setupViews(Intent intent) {
        this.mStatusBarColor = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, a.c(this, R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, a.c(this, R.color.ucrop_color_toolbar));
        this.mActiveWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_COLOR_WIDGET_ACTIVE, a.c(this, R.color.ucrop_color_widget_background));
        this.mActiveControlsWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, a.c(this, R.color.ucrop_color_active_controls_color));
        this.mToolbarWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, a.c(this, R.color.ucrop_color_toolbar_widget));
        this.mToolbarCancelDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, R.drawable.ucrop_ic_cross);
        this.mToolbarCropDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_DRAWABLE, R.drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        this.mToolbarTitle = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.mToolbarTitle = stringExtra;
        this.mLogoColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_LOGO_COLOR, a.c(this, R.color.ucrop_color_default_logo));
        this.mShowBottomControls = !intent.getBooleanExtra(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.mRootViewBackgroundColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, a.c(this, R.color.ucrop_color_crop_background));
        setupAppBar();
        initiateRootViews();
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            viewGroup.setBackgroundColor(this.mRootViewBackgroundColor);
            LayoutInflater.from(this).inflate(R.layout.ucrop_controls, viewGroup, true);
            C5040a c5040a = new C5040a();
            this.mControlsTransition = c5040a;
            c5040a.m0(50L);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio = viewGroup2;
            viewGroup2.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_rotate);
            this.mWrapperStateRotate = viewGroup3;
            viewGroup3.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.state_scale);
            this.mWrapperStateScale = viewGroup4;
            viewGroup4.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.mLayoutRotate = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.mLayoutScale = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            setupAspectRatioWidget(intent);
            setupRotateWidget();
            setupScaleWidget();
            setupStatesWrapper();
        }
    }

    private boolean isOnTouch(Uri uri) {
        boolean zIsGif;
        if (uri == null) {
            return true;
        }
        if (PictureMimeType.isHasHttp(uri.toString())) {
            zIsGif = PictureMimeType.isGifForSuffix(PictureMimeType.getLastImgType(uri.toString()));
        } else {
            String mimeTypeFromMediaContentUri = PictureMimeType.getMimeTypeFromMediaContentUri(this, uri);
            if (mimeTypeFromMediaContentUri.endsWith("image/*")) {
                mimeTypeFromMediaContentUri = PictureMimeType.getImageMimeType(PictureFileUtils.getPath(this, uri));
            }
            zIsGif = PictureMimeType.isGif(mimeTypeFromMediaContentUri);
        }
        return !zIsGif;
    }
}
