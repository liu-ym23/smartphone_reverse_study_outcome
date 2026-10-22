package com.bytedance.android.shopping.anchorv3.comment;

import android.view.View;
import com.bytedance.android.ec.core.utils.q;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {
    public static void a(View r100, float r101, float r102, float r103, float r110) {
        Intrinsics.checkNotNullParameter(r100, "$this$setRadius");
        float r104 = q.a(Float.valueOf(r101));
        float r105 = q.a(Float.valueOf(r102));
        float r106 = q.a(Float.valueOf(r103));
        float r107 = q.a(Float.valueOf(r110));
        Float r108 = ArraysKt.maxOrNull(new float[]{r104, r105, r106, r107});
        if (r108 == null) goto L5;
        float r109 = r108.floatValue();
    L7:
        if (r109 <= 0) goto L9;
        r100.setClipToOutline(true);
        r100.setOutlineProvider(new b(r109, r104, r107, r105, r106));
        return;
    L9:
        r100.setClipToOutline(false);
        r100.setOutlineProvider(null);
        return;
    L5:
        r109 = 0.0f;
        goto L7
    }
}
