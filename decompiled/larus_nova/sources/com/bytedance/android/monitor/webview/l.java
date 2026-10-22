package com.bytedance.android.monitor.webview;

import android.webkit.WebView;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<b, List<a>> f162952a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f162953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f162954b;

        public a(String r100, JSONObject r101) {
            this.f162953a = r100;
            this.f162954b = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WebView f162955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f162956b;

        public final int hashCode() {
            WebView r100 = this.f162955a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f162956b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L25:
            return false;
        L8:
            if (b.class != r100.getClass()) goto L25;
            b r101 = (b) r100;
            WebView r102 = this.f162955a;
            if (r102 == null) goto L16;
            if (r102.equals(r101.f162955a) == false) goto L17;
        L18:
            String r103 = this.f162956b;
            String r104 = r101.f162956b;
            if (r103 != null) goto L26;
            if (r104 == null) goto L27;
            return false;
        L27:
            return true;
        L26:
            return r103.equals(r104);
        L17:
            return false;
        L16:
            if (r101.f162955a == null) goto L18;
            goto L17
        }

        public b(WebView r100, String r101) {
            this.f162955a = r100;
            this.f162956b = r101;
        }
    }

    public l() {
        this.f162952a = new WeakHashMap();
    }
}
