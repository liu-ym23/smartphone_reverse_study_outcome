package com.zyql.ai.crop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import com.zyql.ai.crop.model.AspectRatio;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.entity.LocalMedia;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes4.dex */
public class UCrop {
    public static final String EXTRA_ASPECT_RATIO_X = "com.zyql.ai.crop.AspectRatioX";
    public static final String EXTRA_ASPECT_RATIO_Y = "com.zyql.ai.crop.AspectRatioY";
    public static final String EXTRA_ERROR = "com.zyql.ai.crop.Error";
    public static final String EXTRA_INPUT_URI = "com.zyql.ai.crop.InputUri";
    public static final String EXTRA_MAX_SIZE_X = "com.zyql.ai.crop.MaxSizeX";
    public static final String EXTRA_MAX_SIZE_Y = "com.zyql.ai.crop.MaxSizeY";
    public static final String EXTRA_OUTPUT_CROP_ASPECT_RATIO = "com.zyql.ai.crop.CropAspectRatio";
    public static final String EXTRA_OUTPUT_IMAGE_HEIGHT = "com.zyql.ai.crop.ImageHeight";
    public static final String EXTRA_OUTPUT_IMAGE_WIDTH = "com.zyql.ai.crop.ImageWidth";
    public static final String EXTRA_OUTPUT_OFFSET_X = "com.zyql.ai.crop.OffsetX";
    public static final String EXTRA_OUTPUT_OFFSET_Y = "com.zyql.ai.crop.OffsetY";
    public static final String EXTRA_OUTPUT_URI = "com.zyql.ai.crop.OutputUri";
    private static final String EXTRA_PREFIX = "com.zyql.ai.crop";
    public static final int MIN_SIZE = 10;
    public static final int REQUEST_CROP = 69;
    public static final int REQUEST_MULTI_CROP = 609;
    public static final int RESULT_ERROR = 96;
    private final Intent mCropIntent = new Intent();
    private final Bundle mCropOptionsBundle;

    public static class Options {
        public static final String EXTRA_ACTIVITY_ORIENTATION = "com.zyql.ai.crop.activityOrientation";
        public static final String EXTRA_ALLOWED_GESTURES = "com.zyql.ai.crop.AllowedGestures";
        public static final String EXTRA_ASPECT_RATIO_OPTIONS = "com.zyql.ai.crop.AspectRatioOptions";
        public static final String EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT = "com.zyql.ai.crop.AspectRatioSelectedByDefault";
        public static final String EXTRA_CAMERA = "com.zyql.ai.crop.isCamera";
        public static final String EXTRA_CIRCLE_DIMMED_LAYER = "com.zyql.ai.crop.CircleDimmedLayer";
        public static final String EXTRA_CIRCLE_STROKE_WIDTH_LAYER = "com.zyql.ai.crop.CircleStrokeWidth";
        public static final String EXTRA_COMPRESSION_FORMAT_NAME = "com.zyql.ai.crop.CompressionFormatName";
        public static final String EXTRA_COMPRESSION_QUALITY = "com.zyql.ai.crop.CompressionQuality";
        public static final String EXTRA_CROP_FRAME_COLOR = "com.zyql.ai.crop.CropFrameColor";
        public static final String EXTRA_CROP_FRAME_STROKE_WIDTH = "com.zyql.ai.crop.CropFrameStrokeWidth";
        public static final String EXTRA_CROP_GRID_COLOR = "com.zyql.ai.crop.CropGridColor";
        public static final String EXTRA_CROP_GRID_COLUMN_COUNT = "com.zyql.ai.crop.CropGridColumnCount";
        public static final String EXTRA_CROP_GRID_ROW_COUNT = "com.zyql.ai.crop.CropGridRowCount";
        public static final String EXTRA_CROP_GRID_STROKE_WIDTH = "com.zyql.ai.crop.CropGridStrokeWidth";
        public static final String EXTRA_CUT_CROP = "com.zyql.ai.crop.cuts";
        public static final String EXTRA_DIMMED_LAYER_BORDER_COLOR = "com.zyql.ai.crop.DimmedLayerBorderColor";
        public static final String EXTRA_DIMMED_LAYER_COLOR = "com.zyql.ai.crop.DimmedLayerColor";
        public static final String EXTRA_DRAG_CROP_FRAME = "com.zyql.ai.crop.DragCropFrame";
        public static final String EXTRA_FREE_STYLE_CROP = "com.zyql.ai.crop.FreeStyleCrop";
        public static final String EXTRA_HIDE_BOTTOM_CONTROLS = "com.zyql.ai.crop.HideBottomControls";
        public static final String EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = "com.zyql.ai.crop.ImageToCropBoundsAnimDuration";
        public static final String EXTRA_MAX_BITMAP_SIZE = "com.zyql.ai.crop.MaxBitmapSize";
        public static final String EXTRA_MAX_SCALE_MULTIPLIER = "com.zyql.ai.crop.MaxScaleMultiplier";
        public static final String EXTRA_MULTIPLE_RECYCLERANIMATION = ".isMultipleAnimation";
        public static final String EXTRA_NAV_BAR_COLOR = "com.zyql.ai.crop.navBarColor";
        public static final String EXTRA_OUTPUT_URI_LIST = "com.zyql.ai.crop.OutputUriList";
        public static final String EXTRA_RENAME_CROP_FILENAME = "com.zyql.ai.crop.RenameCropFileName";
        public static final String EXTRA_ROTATE = "com.zyql.ai.crop.rotate";
        public static final String EXTRA_SCALE = "com.zyql.ai.crop.scale";
        public static final String EXTRA_SHOW_CROP_FRAME = "com.zyql.ai.crop.ShowCropFrame";
        public static final String EXTRA_SHOW_CROP_GRID = "com.zyql.ai.crop.ShowCropGrid";
        public static final String EXTRA_SKIP_MULTIPLE_CROP = "com.zyql.ai.crop.skip_multiple_crop";
        public static final String EXTRA_STATUS_BAR_COLOR = "com.zyql.ai.crop.StatusBarColor";
        public static final String EXTRA_TOOL_BAR_COLOR = "com.zyql.ai.crop.ToolbarColor";
        public static final String EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE = "com.zyql.ai.crop.UcropColorControlsWidgetActive";
        public static final String EXTRA_UCROP_COLOR_WIDGET_ACTIVE = "com.zyql.ai.crop.UcropColorWidgetActive";
        public static final String EXTRA_UCROP_LOGO_COLOR = "com.zyql.ai.crop.UcropLogoColor";
        public static final String EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR = "com.zyql.ai.crop.UcropRootViewBackgroundColor";
        public static final String EXTRA_UCROP_TITLE_TEXT_TOOLBAR = "com.zyql.ai.crop.UcropToolbarTitleText";
        public static final String EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE = "com.zyql.ai.crop.UcropToolbarCancelDrawable";
        public static final String EXTRA_UCROP_WIDGET_COLOR_TOOLBAR = "com.zyql.ai.crop.UcropToolbarWidgetColor";
        public static final String EXTRA_UCROP_WIDGET_CROP_DRAWABLE = "com.zyql.ai.crop.UcropToolbarCropDrawable";
        public static final String EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR = "com.zyql.ai.crop.openWhiteStatusBar";
        public static final String EXTRA_WINDOW_EXIT_ANIMATION = "com.zyql.ai.crop.WindowAnimation";
        public static final String EXTRA_WITH_VIDEO_IMAGE = "com.zyql.ai.crop.isWithVideoImage";
        private final Bundle mOptionBundle = new Bundle();

        public Bundle getOptionBundle() {
            return this.mOptionBundle;
        }

        public void isCamera(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_CAMERA, z10);
        }

        public void isMultipleRecyclerAnimation(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_MULTIPLE_RECYCLERANIMATION, z10);
        }

        public void isMultipleSkipCrop(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_SKIP_MULTIPLE_CROP, z10);
        }

        public void isOpenWhiteStatusBar(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR, z10);
        }

        public void isWithVideoImage(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_WITH_VIDEO_IMAGE, z10);
        }

        public void setActiveControlsWidgetColor(int i10) {
            this.mOptionBundle.putInt(EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, i10);
        }

        public void setActiveWidgetColor(int i10) {
            this.mOptionBundle.putInt(EXTRA_UCROP_COLOR_WIDGET_ACTIVE, i10);
        }

        public void setAllowedGestures(int i10, int i11, int i12) {
            this.mOptionBundle.putIntArray(EXTRA_ALLOWED_GESTURES, new int[]{i10, i11, i12});
        }

        public void setAspectRatioOptions(int i10, AspectRatio... aspectRatioArr) {
            if (i10 > aspectRatioArr.length) {
                throw new IllegalArgumentException(String.format(Locale.US, "Index [selectedByDefault = %d] cannot be higher than aspect ratio options count [count = %d].", Integer.valueOf(i10), Integer.valueOf(aspectRatioArr.length)));
            }
            this.mOptionBundle.putInt(EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, i10);
            this.mOptionBundle.putParcelableArrayList(EXTRA_ASPECT_RATIO_OPTIONS, new ArrayList<>(Arrays.asList(aspectRatioArr)));
        }

        public void setCircleDimmedLayer(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_CIRCLE_DIMMED_LAYER, z10);
        }

        public void setCircleStrokeWidth(int i10) {
            if (i10 > 0) {
                this.mOptionBundle.putInt(EXTRA_CIRCLE_STROKE_WIDTH_LAYER, i10);
            }
        }

        public void setCompressionFormat(Bitmap.CompressFormat compressFormat) {
            this.mOptionBundle.putString(EXTRA_COMPRESSION_FORMAT_NAME, compressFormat.name());
        }

        public void setCompressionQuality(int i10) {
            this.mOptionBundle.putInt(EXTRA_COMPRESSION_QUALITY, i10);
        }

        public void setCropExitAnimation(int i10) {
            this.mOptionBundle.putInt(EXTRA_WINDOW_EXIT_ANIMATION, i10);
        }

        public void setCropFrameColor(int i10) {
            this.mOptionBundle.putInt(EXTRA_CROP_FRAME_COLOR, i10);
        }

        public void setCropFrameStrokeWidth(int i10) {
            this.mOptionBundle.putInt(EXTRA_CROP_FRAME_STROKE_WIDTH, i10);
        }

        public void setCropGridColor(int i10) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_COLOR, i10);
        }

        public void setCropGridColumnCount(int i10) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_COLUMN_COUNT, i10);
        }

        public void setCropGridRowCount(int i10) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_ROW_COUNT, i10);
        }

        public void setCropGridStrokeWidth(int i10) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_STROKE_WIDTH, i10);
        }

        public void setCutListData(ArrayList<LocalMedia> arrayList) {
            this.mOptionBundle.putParcelableArrayList(EXTRA_CUT_CROP, arrayList);
        }

        public void setDimmedLayerBorderColor(int i10) {
            if (i10 != 0) {
                this.mOptionBundle.putInt(EXTRA_DIMMED_LAYER_BORDER_COLOR, i10);
            }
        }

        public void setDimmedLayerColor(int i10) {
            this.mOptionBundle.putInt(EXTRA_DIMMED_LAYER_COLOR, i10);
        }

        public void setDragFrameEnabled(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_DRAG_CROP_FRAME, z10);
        }

        public void setFreeStyleCropEnabled(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_FREE_STYLE_CROP, z10);
        }

        public void setHideBottomControls(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_HIDE_BOTTOM_CONTROLS, z10);
        }

        public void setImageToCropBoundsAnimDuration(int i10) {
            this.mOptionBundle.putInt(EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, i10);
        }

        public void setLogoColor(int i10) {
            this.mOptionBundle.putInt(EXTRA_UCROP_LOGO_COLOR, i10);
        }

        public void setMaxBitmapSize(int i10) {
            this.mOptionBundle.putInt(EXTRA_MAX_BITMAP_SIZE, i10);
        }

        public void setMaxScaleMultiplier(float f10) {
            this.mOptionBundle.putFloat(EXTRA_MAX_SCALE_MULTIPLIER, f10);
        }

        public void setNavBarColor(int i10) {
            if (i10 != 0) {
                this.mOptionBundle.putInt(EXTRA_NAV_BAR_COLOR, i10);
            }
        }

        public void setRenameCropFileName(String str) {
            this.mOptionBundle.putString(EXTRA_RENAME_CROP_FILENAME, str);
        }

        public void setRequestedOrientation(int i10) {
            this.mOptionBundle.putInt(EXTRA_ACTIVITY_ORIENTATION, i10);
        }

        public void setRootViewBackgroundColor(int i10) {
            this.mOptionBundle.putInt(EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, i10);
        }

        public void setRotateEnabled(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_ROTATE, z10);
        }

        public void setScaleEnabled(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_SCALE, z10);
        }

        public void setShowCropFrame(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_SHOW_CROP_FRAME, z10);
        }

        public void setShowCropGrid(boolean z10) {
            this.mOptionBundle.putBoolean(EXTRA_SHOW_CROP_GRID, z10);
        }

        public void setStatusBarColor(int i10) {
            this.mOptionBundle.putInt(EXTRA_STATUS_BAR_COLOR, i10);
        }

        public void setToolbarCancelDrawable(int i10) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, i10);
        }

        public void setToolbarColor(int i10) {
            this.mOptionBundle.putInt(EXTRA_TOOL_BAR_COLOR, i10);
        }

        public void setToolbarCropDrawable(int i10) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_CROP_DRAWABLE, i10);
        }

        public void setToolbarTitle(String str) {
            this.mOptionBundle.putString(EXTRA_UCROP_TITLE_TEXT_TOOLBAR, str);
        }

        public void setToolbarWidgetColor(int i10) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, i10);
        }

        public void useSourceImageAspectRatio() {
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        }

        public void withAspectRatio(float f10, float f11) {
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_X, f10);
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_Y, f11);
        }

        public void withMaxResultSize(int i10, int i11) {
            this.mOptionBundle.putInt(UCrop.EXTRA_MAX_SIZE_X, i10);
            this.mOptionBundle.putInt(UCrop.EXTRA_MAX_SIZE_Y, i11);
        }
    }

    private UCrop(Uri uri, Uri uri2) {
        Bundle bundle = new Bundle();
        this.mCropOptionsBundle = bundle;
        bundle.putParcelable(EXTRA_INPUT_URI, uri);
        bundle.putParcelable(EXTRA_OUTPUT_URI, uri2);
    }

    public static Throwable getError(Intent intent) {
        return (Throwable) intent.getSerializableExtra(EXTRA_ERROR);
    }

    public static ArrayList<LocalMedia> getMultipleOutput(Intent intent) {
        return intent.getParcelableArrayListExtra(Options.EXTRA_OUTPUT_URI_LIST);
    }

    public static Uri getOutput(Intent intent) {
        return (Uri) intent.getParcelableExtra(EXTRA_OUTPUT_URI);
    }

    public static float getOutputCropAspectRatio(Intent intent) {
        return intent.getFloatExtra(EXTRA_OUTPUT_CROP_ASPECT_RATIO, 0.0f);
    }

    public static int getOutputImageHeight(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_HEIGHT, -1);
    }

    public static int getOutputImageWidth(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_WIDTH, -1);
    }

    public static UCrop of(Uri uri, Uri uri2) {
        return new UCrop(uri, uri2);
    }

    public Intent getIntent(Context context) {
        this.mCropIntent.setClass(context, UCropActivity.class);
        this.mCropIntent.putExtras(this.mCropOptionsBundle);
        return this.mCropIntent;
    }

    public Intent getMultipleIntent(Context context) {
        this.mCropIntent.setClass(context, PictureMultiCuttingActivity.class);
        this.mCropIntent.putExtras(this.mCropOptionsBundle);
        return this.mCropIntent;
    }

    public void start(Activity activity, int i10, int i11) {
        activity.startActivityForResult(getIntent(activity), i10);
        activity.overridePendingTransition(i11, R.anim.ucrop_anim_fade_in);
    }

    public void startAnimationActivity(Activity activity, int i10) {
        if (i10 != 0) {
            start(activity, 69, i10);
        } else {
            start(activity, 69);
        }
    }

    public void startAnimationMultipleCropActivity(Activity activity, int i10) {
        if (i10 != 0) {
            startMultiple(activity, REQUEST_MULTI_CROP, i10);
        } else {
            startMultiple(activity, REQUEST_MULTI_CROP);
        }
    }

    public void startMultiple(Activity activity, int i10, int i11) {
        activity.startActivityForResult(getMultipleIntent(activity), i10);
        activity.overridePendingTransition(i11, R.anim.ucrop_anim_fade_in);
    }

    public UCrop useSourceImageAspectRatio() {
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_X, 0.0f);
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_Y, 0.0f);
        return this;
    }

    public UCrop withAspectRatio(float f10, float f11) {
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_X, f10);
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_Y, f11);
        return this;
    }

    public UCrop withMaxResultSize(int i10, int i11) {
        if (i10 < 10) {
            i10 = 10;
        }
        if (i11 < 10) {
            i11 = 10;
        }
        this.mCropOptionsBundle.putInt(EXTRA_MAX_SIZE_X, i10);
        this.mCropOptionsBundle.putInt(EXTRA_MAX_SIZE_Y, i11);
        return this;
    }

    public UCrop withOptions(Options options) {
        this.mCropOptionsBundle.putAll(options.getOptionBundle());
        return this;
    }

    public void start(Activity activity, int i10) {
        activity.startActivityForResult(getIntent(activity), i10);
    }

    public void startMultiple(Activity activity) {
        start(activity, REQUEST_MULTI_CROP);
    }

    public void start(d dVar) {
        start(dVar, 69);
    }

    public void startMultiple(Activity activity, int i10) {
        activity.startActivityForResult(getMultipleIntent(activity), i10);
    }

    public void start(d dVar, int i10) {
        dVar.startActivityForResult(getIntent(dVar), i10);
    }

    public void start(Context context, Fragment fragment) {
        start(context, fragment, 69);
    }

    public void start(Context context, Fragment fragment, int i10) {
        fragment.startActivityForResult(getIntent(context), i10);
    }
}
