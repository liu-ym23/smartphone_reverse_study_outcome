package com.bytedance.android.live.revenue.common;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o {
    public static final void a(HSImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$cancelAnimation");
        if (r100.getController() == null) goto L14;
        DraweeController r101 = r100.getController();
        if (r101 == null) goto L7;
        Animatable r102 = r101.getAnimatable();
    L9:
        if ((r102 instanceof AnimatedDrawable2) == true) goto L11;
        r102 = null;
    L11:
        AnimatedDrawable2 r103 = (AnimatedDrawable2) r102;
        if (r103 == null) goto L14;
        r103.setAnimationListener(null);
        r103.stop();
        goto L14
    L7:
        r102 = null;
    L14:
        r100.setController(null);
    }
}
