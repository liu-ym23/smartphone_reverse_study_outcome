package androidx.webkit.internal;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ApiHelperForLollipop.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static boolean a(WebResourceRequest r2) {
        return ((WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r2, WebResourceRequest.class, "com.obric.aiagent.plugin")).isForMainFrame();
    }

    public static Uri b(WebResourceRequest r2) {
        return ((WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r2, WebResourceRequest.class, "com.obric.aiagent.plugin")).getUrl();
    }
}
