package com.bytedance.common.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public class HoneyCombMR2V13Compat {
    static final BaseImpl IMPL = null;

    /* JADX INFO: renamed from: com.bytedance.common.util.HoneyCombMR2V13Compat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BaseImpl {
        private BaseImpl() {
        }

        /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }

        public void getDisplaySize(Display r1, Point r2) {
            r2.x = r1.getWidth();
            r2.y = r1.getHeight();
        }
    }

    private static class HoneyCombMR2Impl extends BaseImpl {
        private HoneyCombMR2Impl() {
            super(null);
        }

        /* synthetic */ HoneyCombMR2Impl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.util.HoneyCombMR2V13Compat.BaseImpl
        public void getDisplaySize(Display r1, Point r2) {
            r1.getSize(r2);
        }
    }

    public HoneyCombMR2V13Compat() {
    }

    static {
        IMPL = new HoneyCombMR2Impl(null);
    }

    public static void getDisplaySize(Display r1, Point r2) {
        IMPL.getDisplaySize(r1, r2);
    }

    public static int getDisplayWidth(Display r1) {
        Point r0 = new Point();
        getDisplaySize(r1, r0);
        return r0.x;
    }

    public static void getDisplaySize(Context r1, Point r2) {
        getDisplaySize(((WindowManager) r1.getSystemService("window")).getDefaultDisplay(), r2);
    }
}
