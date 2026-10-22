package com.android.ttcjpaysdk.bindcard.base.utils;

import android.widget.ImageView;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/utils/ImageUtil;", "", "()V", "loadImage", "", "url", "", "view", "Landroid/widget/ImageView;", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageUtil {
    public static final ImageUtil INSTANCE = null;

    static {
        INSTANCE = new ImageUtil();
    }

    private ImageUtil() {
    }

    public final void loadImage(String r100, final ImageView r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "view");
        ImageLoader.Companion.getInstance().loadImage(r100, new AnonymousClass1(r101));
    }
}
