package androidx.webkit.internal;

import android.content.Context;
import android.net.Uri;
import android.webkit.SafeBrowsingResponse;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class ApiHelperForOMR1 {
    public static Uri getSafeBrowsingPrivacyPolicyUrl() {
        return WebView.getSafeBrowsingPrivacyPolicyUrl();
    }

    private ApiHelperForOMR1() {
    }

    public static void backToSafety(SafeBrowsingResponse r100, boolean r101) {
        r100.backToSafety(r101);
    }

    public static void proceed(SafeBrowsingResponse r100, boolean r101) {
        r100.proceed(r101);
    }

    public static void setSafeBrowsingWhitelist(List<String> r100, ValueCallback<Boolean> r101) {
        WebView.setSafeBrowsingWhitelist(r100, r101);
    }

    public static void showInterstitial(SafeBrowsingResponse r100, boolean r101) {
        r100.showInterstitial(r101);
    }

    public static void startSafeBrowsing(Context r100, ValueCallback<Boolean> r101) {
        WebView.startSafeBrowsing(r100, r101);
    }
}
