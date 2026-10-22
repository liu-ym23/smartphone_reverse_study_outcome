package androidx.webkit.internal;

import android.net.Uri;
import android.webkit.WebResourceRequest;

/* JADX INFO: loaded from: classes17.dex */
public class ApiHelperForLollipop {
    private ApiHelperForLollipop() {
    }

    public static Uri getUrl(WebResourceRequest r100) {
        return r100.getUrl();
    }

    public static boolean isForMainFrame(WebResourceRequest r100) {
        return r100.isForMainFrame();
    }
}
