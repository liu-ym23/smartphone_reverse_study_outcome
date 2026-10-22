package com.bytedance.common.util;

import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class IceCreamSandwichV14Compat {
    private static final int FONT_BIG_PERCENT = 125;
    private static final int FONT_DEFAULT_PERCENT = 100;
    private static final int FONT_LARGE_PERCENT = 150;
    public static final int FONT_SIZE_BIG = 3;
    public static final int FONT_SIZE_LARGE = 4;
    public static final int FONT_SIZE_NORMAL = 2;
    public static final int FONT_SIZE_SMALL = 1;
    private static final int FONT_SMALL_PERCENT = 75;
    static final BaseImpl IMPL = null;
    public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1;

    /* JADX INFO: renamed from: com.bytedance.common.util.IceCreamSandwichV14Compat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BaseImpl {
        public void setUiOptions(Window r1, int r2) {
        }

        public void setUiOptions(Window r1, int r2, int r3) {
        }

        private BaseImpl() {
        }

        /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }

        public void setWebViewTextSize(WebView r2, int r3) {
            WebSettings.TextSize r1 = WebSettings.TextSize.NORMAL;
            if (r3 != 3) goto L6;
            r1 = WebSettings.TextSize.LARGER;
        L11:
            r2.getSettings().setTextSize(r1);
            return;
        L6:
            if (r3 != 1) goto L9;
            r1 = WebSettings.TextSize.SMALLER;
            goto L11
        L9:
            if (r3 != 4) goto L11;
            r1 = WebSettings.TextSize.LARGEST;
            goto L11
        }
    }

    private static class IceCreamSandwichImpl extends BaseImpl {
        private IceCreamSandwichImpl() {
            super(null);
        }

        /* synthetic */ IceCreamSandwichImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.util.IceCreamSandwichV14Compat.BaseImpl
        public void setWebViewTextSize(WebView r2, int r3) {
            if (r3 != 1) goto L5;
            int r1 = 75;
        L7:
            if (r3 != 3) goto L10;
            r1 = 125;
        L10:
            if (r3 != 4) goto L12;
            r1 = 150;
        L12:
            r2.getSettings().setTextZoom(r1);
            return;
        L5:
            r1 = 100;
            goto L7
        }

        @Override // com.bytedance.common.util.IceCreamSandwichV14Compat.BaseImpl
        public void setUiOptions(Window r1, int r2) {
            r1.setUiOptions(r2);
        }

        @Override // com.bytedance.common.util.IceCreamSandwichV14Compat.BaseImpl
        public void setUiOptions(Window r1, int r2, int r3) {
            r1.setUiOptions(r2, r3);
        }
    }

    public IceCreamSandwichV14Compat() {
    }

    static {
        IMPL = new IceCreamSandwichImpl(null);
    }

    public static void setWebViewTextSize(WebView r1, int r2) {
        IMPL.setWebViewTextSize(r1, r2);
    }

    public static void setUiOptions(Window r1, int r2, int r3) {
        IMPL.setUiOptions(r1, r2, r3);
    }

    public static void setUiOptions(Window r1, int r2) {
        IMPL.setUiOptions(r1, r2);
    }
}
