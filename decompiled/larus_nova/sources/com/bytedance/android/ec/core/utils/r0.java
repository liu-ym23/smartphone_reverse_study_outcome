package com.bytedance.android.ec.core.utils;

import android.graphics.drawable.Animatable;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public abstract class r0 extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super ImageInfo, Unit> f45695a;

    public r0() {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, ImageInfo r101, Animatable r102) {
        ImageInfo r103 = r101;
        Function1<? super ImageInfo, Unit> r104 = this.f45695a;
        if (r104 == null) goto L6;
        Unit r105 = r104.invoke(r103);
        return;
    }
}
