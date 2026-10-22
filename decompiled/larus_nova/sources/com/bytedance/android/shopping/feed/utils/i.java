package com.bytedance.android.shopping.feed.utils;

import android.view.View;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<View> f175451a;

    public static void a() {
        WeakReference<View> r100 = f175451a;
        View r101 = null;
        if (r100 == null) goto L5;
        View r102 = r100.get();
    L7:
        if ((r102 instanceof ECLottieAnimationView) == false) goto L10;
        r101 = r102;
    L10:
        ECLottieAnimationView r103 = (ECLottieAnimationView) r101;
        if (r103 == null) goto L14;
        r103.clearAnimation();
        r103.playAnimation();
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    static {
    }
}
