package com.bytedance.android.livesdk.widget;

import android.view.MotionEvent;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public interface y {

    public static final class a {
        public static void a(ViewGroup r100, MotionEvent r101) {
            Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
            Intrinsics.checkNotNullParameter(r101, "ev");
        }
    }

    boolean a(ViewGroup r100);

    boolean b(ViewGroup r100, MotionEvent r101);

    boolean c(ViewGroup r100, MotionEvent r101);

    f0 getConfig();

    boolean onTouchEvent(ViewGroup r100, MotionEvent r101);
}
