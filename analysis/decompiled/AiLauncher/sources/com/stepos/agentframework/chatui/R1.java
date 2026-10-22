package com.stepos.agentframework.chatui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.engine.ImageEngine;
import com.zyql.ai.selector.listener.OnImageCompleteCallback;
import com.zyql.ai.selector.tools.MediaUtils;
import com.zyql.ai.selector.widget.longimage.ImageSource;
import com.zyql.ai.selector.widget.longimage.ImageViewState;
import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;

/* loaded from: classes2.dex */
public class R1 implements ImageEngine {
    private static R1 instance;

    public class a extends ImageViewTarget<Bitmap> {
        final /* synthetic */ OnImageCompleteCallback val$callback;
        final /* synthetic */ ImageView val$imageView;
        final /* synthetic */ SubsamplingScaleImageView val$longImageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView, OnImageCompleteCallback onImageCompleteCallback, SubsamplingScaleImageView subsamplingScaleImageView, ImageView imageView2) {
            super(imageView);
            this.val$callback = onImageCompleteCallback;
            this.val$longImageView = subsamplingScaleImageView;
            this.val$imageView = imageView2;
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            OnImageCompleteCallback onImageCompleteCallback = this.val$callback;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onHideLoading();
            }
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable drawable) {
            super.onLoadStarted(drawable);
            OnImageCompleteCallback onImageCompleteCallback = this.val$callback;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onShowLoading();
            }
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(Bitmap bitmap) {
            OnImageCompleteCallback onImageCompleteCallback = this.val$callback;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onHideLoading();
            }
            if (bitmap != null) {
                boolean zIsLongImg = MediaUtils.isLongImg(bitmap.getWidth(), bitmap.getHeight());
                this.val$longImageView.setVisibility(zIsLongImg ? 0 : 8);
                this.val$imageView.setVisibility(zIsLongImg ? 8 : 0);
                if (!zIsLongImg) {
                    this.val$imageView.setImageBitmap(bitmap);
                    return;
                }
                this.val$longImageView.setQuickScaleEnabled(true);
                this.val$longImageView.setZoomEnabled(true);
                this.val$longImageView.setDoubleTapZoomDuration(100);
                this.val$longImageView.setMinimumScaleType(2);
                this.val$longImageView.setDoubleTapZoomDpi(2);
                this.val$longImageView.setImage(ImageSource.cachedBitmap(bitmap), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
            }
        }
    }

    public class b extends ImageViewTarget<Bitmap> {
        final /* synthetic */ ImageView val$imageView;
        final /* synthetic */ SubsamplingScaleImageView val$longImageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, ImageView imageView2) {
            super(imageView);
            this.val$longImageView = subsamplingScaleImageView;
            this.val$imageView = imageView2;
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(Bitmap bitmap) {
            if (bitmap != null) {
                boolean zIsLongImg = MediaUtils.isLongImg(bitmap.getWidth(), bitmap.getHeight());
                this.val$longImageView.setVisibility(zIsLongImg ? 0 : 8);
                this.val$imageView.setVisibility(zIsLongImg ? 8 : 0);
                if (!zIsLongImg) {
                    this.val$imageView.setImageBitmap(bitmap);
                    return;
                }
                this.val$longImageView.setQuickScaleEnabled(true);
                this.val$longImageView.setZoomEnabled(true);
                this.val$longImageView.setDoubleTapZoomDuration(100);
                this.val$longImageView.setMinimumScaleType(2);
                this.val$longImageView.setDoubleTapZoomDpi(2);
                this.val$longImageView.setImage(ImageSource.cachedBitmap(bitmap), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
            }
        }
    }

    public class c extends BitmapImageViewTarget {
        final /* synthetic */ Context val$context;
        final /* synthetic */ ImageView val$imageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ImageView imageView, Context context, ImageView imageView2) {
            super(imageView);
            this.val$context = context;
            this.val$imageView = imageView2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.request.target.BitmapImageViewTarget, com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(Bitmap bitmap) {
            u0.c cVarA = u0.d.a(this.val$context.getResources(), bitmap);
            cVarA.e(8.0f);
            this.val$imageView.setImageDrawable(cVarA);
        }
    }

    public static R1 a() {
        if (instance == null) {
            synchronized (R1.class) {
                try {
                    if (instance == null) {
                        instance = new R1();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadAsGifImage(Context context, String str, ImageView imageView) {
        Glide.with(context).asGif().load(str).into(imageView);
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadFolderImage(Context context, String str, ImageView imageView) {
        Glide.with(context).asBitmap().load(str).override(180, 180).centerCrop().sizeMultiplier(0.5f).placeholder(R.drawable.picture_image_placeholder).into((RequestBuilder) new c(imageView, context, imageView));
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadGridImage(Context context, String str, ImageView imageView) {
        Glide.with(context).load(str).override(200, 200).centerCrop().placeholder(R.drawable.picture_image_placeholder).into(imageView);
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadImage(Context context, String str, ImageView imageView) {
        Glide.with(context).load(str).into(imageView);
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadImage(Context context, String str, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, OnImageCompleteCallback onImageCompleteCallback) {
        Glide.with(context).asBitmap().load(str).into((RequestBuilder<Bitmap>) new a(imageView, onImageCompleteCallback, subsamplingScaleImageView, imageView));
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadImage(Context context, String str, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView) {
        Glide.with(context).asBitmap().load(str).into((RequestBuilder<Bitmap>) new b(imageView, subsamplingScaleImageView, imageView));
    }
}
