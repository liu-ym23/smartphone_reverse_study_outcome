package com.bytedance.common.util;

import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class LollipopV21Compat {
    private static BaseImpl mImpl;

    /* JADX INFO: renamed from: com.bytedance.common.util.LollipopV21Compat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BaseImpl {
        public void setAcceptThirdPartyCookies(WebView r1, boolean r2) {
        }

        public void setMixedContentMode(WebSettings r1, int r2) {
        }

        private BaseImpl() {
        }

        /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }
    }

    private static class LollipopImpl extends BaseImpl {
        private LollipopImpl() {
            super(null);
        }

        /* synthetic */ LollipopImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.util.LollipopV21Compat.BaseImpl
        public void setMixedContentMode(WebSettings r1, int r2) {
            if (r1 == null) goto L10;
            r1.setMixedContentMode(r2);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        @Override // com.bytedance.common.util.LollipopV21Compat.BaseImpl
        public void setAcceptThirdPartyCookies(WebView r1, boolean r2) {
            if (r1 == null) goto L10;
            CookieManager.getInstance().setAcceptThirdPartyCookies(r1, r2);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            return;
        }
    }

    public LollipopV21Compat() {
    }

    static {
        mImpl = new LollipopImpl(null);
    }

    public static void setMixedContentMode(WebSettings r1, int r2) {
        mImpl.setMixedContentMode(r1, r2);
    }

    public static void setAcceptThirdPartyCookies(WebView r1, boolean r2) {
        mImpl.setAcceptThirdPartyCookies(r1, r2);
    }
}
