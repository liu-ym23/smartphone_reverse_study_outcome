package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;

/* JADX INFO: loaded from: classes39.dex */
public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;

    public static boolean isThumbnailSize(int r100, int r101) {
        if (r100 == Integer.MIN_VALUE) goto L10;
        if (r101 == Integer.MIN_VALUE) goto L10;
        if (r100 > 512) goto L10;
        if (r101 > 384) goto L10;
        return true;
    L10:
        return false;
    }

    private MediaStoreUtil() {
    }

    public static boolean isMediaStoreImageUri(Uri r100) {
        if (isMediaStoreUri(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (isVideoUri(r100) == true) goto L7;
        return true;
    }

    public static boolean isMediaStoreUri(Uri r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if ("content".equals(r100.getScheme()) == false) goto L8;
        if ("media".equals(r100.getAuthority()) == false) goto L8;
        return true;
    }

    public static boolean isMediaStoreVideoUri(Uri r100) {
        if (isMediaStoreUri(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (isVideoUri(r100) == false) goto L7;
        return true;
    }

    private static boolean isVideoUri(Uri r100) {
        return r100.getPathSegments().contains("video");
    }
}
