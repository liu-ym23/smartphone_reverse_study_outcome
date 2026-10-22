package androidx.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;

/* JADX INFO: loaded from: classes17.dex */
public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(Bundle r100, Bundle r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        if (r101 != null) goto L23;
        if (r100.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == (-1)) goto L18;
    L20:
        return false;
    L18:
        if (r100.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) != (-1)) goto L20;
        return true;
    L23:
        if (r100.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == r101.getInt(MediaBrowserCompat.EXTRA_PAGE, -1)) goto L25;
    L27:
        return false;
    L25:
        if (r100.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) != r101.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1)) goto L27;
        return true;
    L8:
        if (r101.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == (-1)) goto L10;
    L12:
        return false;
    L10:
        if (r101.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) != (-1)) goto L12;
        return true;
    }

    public static boolean hasDuplicatedItems(Bundle r100, Bundle r101) {
        if (r100 != null) goto L5;
        int r102 = -1;
    L6:
        if (r101 != null) goto L8;
        int r103 = -1;
    L10:
        if (r100 != null) goto L12;
        int r104 = -1;
    L13:
        if (r101 != null) goto L15;
        int r105 = -1;
    L16:
        int r106 = Integer.MAX_VALUE;
        if (r102 == (-1)) goto L21;
        if (r104 == (-1)) goto L21;
        int r107 = r102 * r104;
        int r108 = (r104 + r107) - 1;
    L22:
        if (r103 == (-1)) goto L26;
        if (r105 == (-1)) goto L26;
        int r109 = r103 * r105;
        r106 = (r105 + r109) - 1;
    L27:
        if (r108 < r109) goto L30;
        if (r106 < r107) goto L30;
        return true;
    L30:
        return false;
    L26:
        r109 = 0;
    L21:
        r108 = Integer.MAX_VALUE;
        r107 = 0;
        goto L22
    L15:
        r105 = r101.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        goto L16
    L12:
        r104 = r100.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        goto L13
    L8:
        r103 = r101.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        goto L10
    L5:
        r102 = r100.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        goto L6
    }
}
