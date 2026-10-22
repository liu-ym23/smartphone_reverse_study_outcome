package androidx.webkit.internal;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import nvc.a;

/* JADX INFO: loaded from: classes17.dex */
public abstract class ApiFeature implements ConditionallySupportedFeature {
    private static final Set<ApiFeature> sValues = null;
    private final String mInternalFeatureValue;
    private final String mPublicFeatureValue;

    public static class LAZY_HOLDER {
        static final Set<String> WEBVIEW_APK_FEATURES = null;

        private LAZY_HOLDER() {
        }

        static {
            WEBVIEW_APK_FEATURES = new HashSet(Arrays.asList(WebViewGlueCommunicator.getFactory().getWebViewFeatures()));
        }
    }

    public static final class M extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return true;
        L5:
            return false;
        }

        public M(String r100, String r101) {
            super(r100, r101);
        }
    }

    public static final class N extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return true;
        L5:
            return false;
        }

        public N(String r100, String r101) {
            super(r100, r101);
        }
    }

    public static final class NoFramework extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public boolean isSupportedByFramework() {
            return false;
        }

        public NoFramework(String r100, String r101) {
            super(r100, r101);
        }
    }

    public static final class O extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT < 26) goto L5;
            return true;
        L5:
            return false;
        }

        public O(String r100, String r101) {
            super(r100, r101);
        }
    }

    public static final class O_MR1 extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT < 27) goto L5;
            return true;
        L5:
            return false;
        }

        public O_MR1(String r100, String r101) {
            super(r100, r101);
        }
    }

    public static final class P extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT < 28) goto L5;
            return true;
        L5:
            return false;
        }

        public P(String r100, String r101) {
            super(r100, r101);
        }
    }

    public static final class Q extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT < 29) goto L5;
            return true;
        L5:
            return false;
        }

        public Q(String r100, String r101) {
            super(r100, r101);
        }
    }

    public abstract boolean isSupportedByFramework();

    static {
        sValues = new HashSet();
    }

    public static Set<ApiFeature> values() {
        return Collections.unmodifiableSet(sValues);
    }

    public boolean isSupportedByWebView() {
        Set<String> r100 = LAZY_HOLDER.WEBVIEW_APK_FEATURES;
        String r101 = this.mInternalFeatureValue;
        int r102 = a.f520929a;
        if (r100.contains(r101) == true) goto L17;
        String r103 = Build.TYPE;
        if ("eng".equals(r103) == false) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L13;
    L15:
        return false;
    L13:
        if (r100.contains(r101 + ":dev") == false) goto L15;
        return true;
    L7:
        if ("userdebug".equals(r103) == true) goto L10;
        r104 = false;
        goto L11
    L17:
        return true;
    }

    @Override // androidx.webkit.internal.ConditionallySupportedFeature
    public boolean isSupported() {
        if (isSupportedByFramework() == false) goto L5;
    L8:
        return true;
    L5:
        if (isSupportedByWebView() == true) goto L8;
        return false;
    }

    public static Set<String> getWebViewApkFeaturesForTesting() {
        return LAZY_HOLDER.WEBVIEW_APK_FEATURES;
    }

    @Override // androidx.webkit.internal.ConditionallySupportedFeature
    public String getPublicFeatureName() {
        return this.mPublicFeatureValue;
    }

    public ApiFeature(String r100, String r101) {
        this.mPublicFeatureValue = r100;
        this.mInternalFeatureValue = r101;
        sValues.add(this);
    }
}
