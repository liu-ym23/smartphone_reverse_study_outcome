package com.tmall.wireless.tangram.util;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedanceos.common.network.widget.NetworkImageView;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageUtils {
    public static final int IO_BUFFER_SIZE = 8192;
    private static IInnerImageSetter sImageSetter;

    public ImageUtils() {
    }

    public static NetworkImageView createImageInstance(Context r10) {
        return new NetworkImageView(r10);
    }

    public static <IMAGE extends ImageView> void doLoadImageUrl(@NonNull IMAGE r10, @Nullable String r11, float r12) {
        doLoadImageUrl(r10, r11, r12, false);
    }

    public static void setImageSetter(@NonNull IInnerImageSetter r10) {
        sImageSetter = r10;
    }

    public static <IMAGE extends ImageView> void doLoadImageUrl(@NonNull IMAGE r10, @Nullable String r11) {
        doLoadImageUrl(r10, r11, 0.0f, false);
    }

    public static <IMAGE extends ImageView> void doLoadImageUrl(@NonNull IMAGE r10, @Nullable String r11, boolean r12) {
        doLoadImageUrl(r10, r11, 0.0f, r12);
    }

    public static <IMAGE extends ImageView> void doLoadImageUrl(@NonNull IMAGE r10, @Nullable String r11, float r12, boolean r13) {
        if (sImageSetter == null) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkState(r14, "ImageSetter must be initialized before calling image load");
        sImageSetter.doLoadImageUrl(r10, r11, r12, r13);
        return;
    L5:
        r14 = false;
        goto L6
    }
}
