package com.android.ttcjpaysdk.thirdparty.utils;

import android.widget.ImageView;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayImageLoadUtils {
    public CJPayImageLoadUtils() {
    }

    public static void loadImage(String r100, final ImageView r101) {
        ImageLoader.Companion.getInstance().loadImage(r100, new AnonymousClass1(r101));
    }

    public static void loadImageAndVisible(String r100, final ImageView r101) {
        ImageLoader.Companion.getInstance().loadImage(r100, new AnonymousClass2(r101));
    }
}
