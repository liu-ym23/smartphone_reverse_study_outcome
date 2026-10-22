package com.zyql.ai.selector.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.engine.ImageEngine;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.listener.OnVideoSelectedPlayCallback;
import com.zyql.ai.selector.photoview.OnViewTapListener;
import com.zyql.ai.selector.photoview.PhotoView;
import com.zyql.ai.selector.tools.JumpUtils;
import com.zyql.ai.selector.tools.MediaUtils;
import com.zyql.ai.selector.tools.ScreenUtils;
import com.zyql.ai.selector.widget.longimage.ImageSource;
import com.zyql.ai.selector.widget.longimage.ImageViewState;
import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class PictureSimpleFragmentAdapter extends androidx.viewpager.widget.a {
    private static final int MAX_CACHE_SIZE = 20;
    private final PictureSelectionConfig config;
    private List<LocalMedia> data;
    private SparseArray<View> mCacheView = new SparseArray<>();
    private final int mScreenHeight;
    private final int mScreenWidth;
    private final OnCallBackActivity onBackPressed;

    public interface OnCallBackActivity {
        void onActivityBackPressed();
    }

    public PictureSimpleFragmentAdapter(Context context, PictureSelectionConfig pictureSelectionConfig, OnCallBackActivity onCallBackActivity) {
        this.config = pictureSelectionConfig;
        this.onBackPressed = onCallBackActivity;
        this.mScreenWidth = ScreenUtils.getScreenWidth(context);
        this.mScreenHeight = ScreenUtils.getScreenHeight(context);
    }

    public static /* synthetic */ void b(LocalMedia localMedia, String str, ViewGroup viewGroup, View view) {
        OnVideoSelectedPlayCallback<LocalMedia> onVideoSelectedPlayCallback = PictureSelectionConfig.customVideoPlayCallback;
        if (onVideoSelectedPlayCallback != null) {
            onVideoSelectedPlayCallback.startPlayVideo(localMedia);
            return;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean(PictureConfig.EXTRA_PREVIEW_VIDEO, true);
        bundle.putString(PictureConfig.EXTRA_VIDEO_PATH, str);
        intent.putExtras(bundle);
        JumpUtils.startPictureVideoPlayActivity(viewGroup.getContext(), bundle, PictureConfig.PREVIEW_VIDEO_CODE);
    }

    private void displayLongPic(Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(ImageSource.uri(uri), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$instantiateItem$1(View view, float f10, float f11) {
        OnCallBackActivity onCallBackActivity = this.onBackPressed;
        if (onCallBackActivity != null) {
            onCallBackActivity.onActivityBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$instantiateItem$2(View view) {
        OnCallBackActivity onCallBackActivity = this.onBackPressed;
        if (onCallBackActivity != null) {
            onCallBackActivity.onActivityBackPressed();
        }
    }

    public void bindData(List<LocalMedia> list) {
        this.data = list;
    }

    public void clear() {
        SparseArray<View> sparseArray = this.mCacheView;
        if (sparseArray != null) {
            sparseArray.clear();
            this.mCacheView = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        viewGroup.removeView((View) obj);
        if (this.mCacheView.size() > 20) {
            this.mCacheView.remove(i10);
        }
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        List<LocalMedia> list = this.data;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<LocalMedia> getData() {
        List<LocalMedia> list = this.data;
        return list == null ? new ArrayList() : list;
    }

    public LocalMedia getItem(int i10) {
        if (getSize() <= 0 || i10 >= getSize()) {
            return null;
        }
        return this.data.get(i10);
    }

    @Override // androidx.viewpager.widget.a
    public int getItemPosition(Object obj) {
        return -2;
    }

    public int getSize() {
        List<LocalMedia> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(final ViewGroup viewGroup, int i10) {
        ImageEngine imageEngine;
        ImageEngine imageEngine2;
        View viewInflate = this.mCacheView.get(i10);
        if (viewInflate == null) {
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_image_preview, viewGroup, false);
            this.mCacheView.put(i10, viewInflate);
        }
        PhotoView photoView = (PhotoView) viewInflate.findViewById(R.id.preview_image);
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) viewInflate.findViewById(R.id.longImg);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_play);
        final LocalMedia item = getItem(i10);
        if (this.config.isAutoScalePreviewImage) {
            float fMin = Math.min(item.getWidth(), item.getHeight());
            float fMax = Math.max(item.getHeight(), item.getWidth());
            if (fMin > 0.0f && fMax > 0.0f) {
                int iCeil = (int) Math.ceil((fMax * fMin) / fMin);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) photoView.getLayoutParams();
                layoutParams.width = this.mScreenWidth;
                int i11 = this.mScreenHeight;
                if (iCeil < i11) {
                    iCeil += i11;
                }
                layoutParams.height = iCeil;
                layoutParams.gravity = 17;
            }
        }
        String mimeType = item.getMimeType();
        final String compressPath = (!item.isCut() || item.isCompressed()) ? (item.isCompressed() || (item.isCut() && item.isCompressed())) ? item.getCompressPath() : item.getPath() : item.getCutPath();
        boolean zIsGif = PictureMimeType.isGif(mimeType);
        int i12 = 8;
        imageView.setVisibility(PictureMimeType.isHasVideo(mimeType) ? 0 : 8);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PictureSimpleFragmentAdapter.b(item, compressPath, viewGroup, view);
            }
        });
        boolean zIsLongImg = MediaUtils.isLongImg(item);
        photoView.setVisibility((!zIsLongImg || zIsGif) ? 0 : 8);
        photoView.setOnViewTapListener(new OnViewTapListener() { // from class: com.zyql.ai.selector.adapter.f
            @Override // com.zyql.ai.selector.photoview.OnViewTapListener
            public final void onViewTap(View view, float f10, float f11) {
                this.f31964a.lambda$instantiateItem$1(view, f10, f11);
            }
        });
        if (zIsLongImg && !zIsGif) {
            i12 = 0;
        }
        subsamplingScaleImageView.setVisibility(i12);
        subsamplingScaleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.adapter.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31965a.lambda$instantiateItem$2(view);
            }
        });
        if (!zIsGif || item.isCompressed()) {
            if (this.config != null && (imageEngine = PictureSelectionConfig.imageEngine) != null) {
                if (zIsLongImg) {
                    displayLongPic(PictureMimeType.isContent(compressPath) ? Uri.parse(compressPath) : Uri.fromFile(new File(compressPath)), subsamplingScaleImageView);
                } else {
                    imageEngine.loadImage(viewInflate.getContext(), compressPath, photoView);
                }
            }
        } else if (this.config != null && (imageEngine2 = PictureSelectionConfig.imageEngine) != null) {
            imageEngine2.loadAsGifImage(viewInflate.getContext(), compressPath, photoView);
        }
        viewGroup.addView(viewInflate, 0);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void remove(int i10) {
        if (getSize() > i10) {
            this.data.remove(i10);
        }
    }

    public void removeCacheView(int i10) {
        SparseArray<View> sparseArray = this.mCacheView;
        if (sparseArray == null || i10 >= sparseArray.size()) {
            return;
        }
        this.mCacheView.removeAt(i10);
    }
}
