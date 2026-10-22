package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public class d extends b {
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
    public final boolean a(int r100) {
        return true;
    }

    public d(View r100, boolean r101, boolean r110, boolean r111, int r112) {
        if ((r112 & 8) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r112 & 16) == 0) goto L9;
        boolean r103 = false;
    L10:
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100, new m0(r101, true, r103, 0, r102, 24));
        return;
    L9:
        r103 = r111;
        goto L10
    L5:
        r102 = r110;
        goto L7
    }
}
