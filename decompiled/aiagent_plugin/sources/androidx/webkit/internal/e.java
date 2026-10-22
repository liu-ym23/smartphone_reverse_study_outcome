package androidx.webkit.internal;

import android.content.Context;
import android.net.Uri;
import android.webkit.SafeBrowsingResponse;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ApiHelperForOMR1.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static void a(SafeBrowsingResponse r0, boolean r1) {
        r0.showInterstitial(r1);
    }

    public static void b(SafeBrowsingResponse r0, boolean r1) {
        r0.proceed(r1);
    }

    public static void c(SafeBrowsingResponse r0, boolean r1) {
        r0.backToSafety(r1);
    }

    public static void a(Context r2, ValueCallback<Boolean> r3) {
        WebView.startSafeBrowsing((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (ValueCallback) ZeusTransformUtils.wrapperContextForParams(r3, ValueCallback.class, "com.obric.aiagent.plugin"));
    }

    public static void a(List<String> r2, ValueCallback<Boolean> r3) {
        WebView.setSafeBrowsingWhitelist((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), (ValueCallback) ZeusTransformUtils.wrapperContextForParams(r3, ValueCallback.class, "com.obric.aiagent.plugin"));
    }

    public static Uri a() {
        return WebView.getSafeBrowsingPrivacyPolicyUrl();
    }
}
