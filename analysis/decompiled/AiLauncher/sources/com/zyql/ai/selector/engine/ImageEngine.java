package com.zyql.ai.selector.engine;

import android.content.Context;
import android.widget.ImageView;
import com.zyql.ai.selector.listener.OnImageCompleteCallback;
import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;

/* loaded from: classes4.dex */
public interface ImageEngine {
    void loadAsGifImage(Context context, String str, ImageView imageView);

    void loadFolderImage(Context context, String str, ImageView imageView);

    void loadGridImage(Context context, String str, ImageView imageView);

    void loadImage(Context context, String str, ImageView imageView);

    @Deprecated
    void loadImage(Context context, String str, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView);

    void loadImage(Context context, String str, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, OnImageCompleteCallback onImageCompleteCallback);
}
