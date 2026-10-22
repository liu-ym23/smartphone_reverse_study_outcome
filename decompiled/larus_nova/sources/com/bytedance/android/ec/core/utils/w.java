package com.bytedance.android.ec.core.utils;

import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ControllerListener<? super ImageInfo> f45734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super DraweeController, Unit> f45735b;

    public w(ControllerListener<? super ImageInfo> r100, Function1<? super DraweeController, Unit> r101) {
        this.f45734a = r100;
        this.f45735b = r101;
    }
}
