package com.bytedance.common.util;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class JellyBeanMR1V16Compat {
    private static BaseImpl mImpl;

    /* JADX INFO: renamed from: com.bytedance.common.util.JellyBeanMR1V16Compat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BaseImpl {
        private BaseImpl() {
        }

        /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }

        public void setBackground(View r1, Drawable r2) {
            r1.setBackgroundDrawable(r2);
        }
    }

    private static class V16Impl extends BaseImpl {
        private V16Impl() {
            super(null);
        }

        /* synthetic */ V16Impl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V16Compat.BaseImpl
        public void setBackground(View r1, Drawable r2) {
            r1.setBackground(r2);
        }
    }

    static {
    }

    public JellyBeanMR1V16Compat() {
    }

    public static void setBackgroundForView(View r2, Drawable r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (mImpl != null) goto L7;
        mImpl = new V16Impl(null);
    L7:
        mImpl.setBackground(r2, r3);
    }
}
