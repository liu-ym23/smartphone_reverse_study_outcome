package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.bytedanceos.common.toolbox.ServerElements;

/* JADX INFO: loaded from: classes.dex */
public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;

    private MediaStoreUtil() {
    }

    public static boolean isMediaStoreImageUri(Uri r10) {
        if (isMediaStoreUri(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (isVideoUri(r10) == true) goto L7;
        return true;
    }

    public static boolean isMediaStoreUri(Uri r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if (ServerElements.CONTENT.equals(r10.getScheme()) == false) goto L8;
        if ("media".equals(r10.getAuthority()) == false) goto L8;
        return true;
    }

    public static boolean isMediaStoreVideoUri(Uri r10) {
        if (isMediaStoreUri(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (isVideoUri(r10) == false) goto L7;
        return true;
    }

    public static boolean isThumbnailSize(int r10, int r11) {
        if (r10 == Integer.MIN_VALUE) goto L10;
        if (r11 == Integer.MIN_VALUE) goto L10;
        if (r10 > 512) goto L10;
        if (r11 > MINI_THUMB_HEIGHT) goto L10;
        return true;
    L10:
        return false;
    }

    private static boolean isVideoUri(Uri r10) {
        return r10.getPathSegments().contains(ServerElements.VIDEO);
    }
}
