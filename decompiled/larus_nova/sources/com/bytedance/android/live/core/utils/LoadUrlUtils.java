package com.bytedance.android.live.core.utils;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes45.dex */
public class LoadUrlUtils {
    static final a IMPL = null;

    public static class a {
        public void a(WebView r100, String r101) {
            throw null;
        }

        public a() {
        }
    }

    public static class b extends a {
        public b() {
        }

        @Override // com.bytedance.android.live.core.utils.LoadUrlUtils.a
        public final void a(WebView r100, String r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            boolean r102 = false;
            if (r101 != null) goto L7;
        L13:
            if (r102 == true) goto L21;
            r100.loadUrl(r101);     // Catch: Throwable -> L16
            return;
        L22:
            return;
        L21:
            return;
        L7:
            if (r101.startsWith("javascript:") == false) goto L13;
            r100.evaluateJavascript(r101, null);     // Catch: Throwable -> L11
            r102 = true;
        L11:
            th = move-exception;
            boolean r103 = th instanceof IllegalStateException;
            goto L13
        }
    }

    public LoadUrlUtils() {
    }

    static {
        IMPL = new b();
    }

    public static void loadUrl(WebView r100, String r101) {
        IMPL.a(r100, r101);
    }
}
