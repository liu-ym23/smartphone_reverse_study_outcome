package com.bytedance.android.shopping.card_list.components;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f171469d;

    public final int g() {
        LinearLayout r100 = this.f171469d;     // Catch: Throwable -> L13
        if (r100 == null) goto L17;
        View r101 = r100.getChildAt(r100.getChildCount() - 1);     // Catch: Throwable -> L13
        if (r101 == null) goto L8;
        Integer r102 = Integer.valueOf(r101.getMeasuredHeight());     // Catch: Throwable -> L13
    L9:
        if (r102 == null) goto L17;
        return r102.intValue();
    L8:
        r102 = null;
    L17:
        return com.bytedance.android.shopping.extensions.b.b(64);
    L14:
        return com.bytedance.android.shopping.extensions.b.b(64);
    }

    public i(CardListObjectContainer r100, LinearLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        super(r100);
        this.f171469d = r101;
    }
}
