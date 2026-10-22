package com.bytedance.android.ec.core.utils;

import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class e0 extends r0 {
    public e0() {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageSet(String r100, ImageInfo r101) {
        ImageInfo r102 = r101;
        Function1<? super ImageInfo, Unit> r103 = this.f45695a;
        if (r103 == null) goto L6;
        Unit r104 = r103.invoke(r102);
        return;
    }
}
