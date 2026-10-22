package com.bytedance.android.ec.core.imagex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.ecom.arch.slice.render.widget.fresco.SlcPipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes43.dex */
public interface q {
    boolean a();

    SlcPipelineDraweeControllerBuilder b();

    void c(com.bytedance.android.ecom.arch.slice.render.widget.fresco.h r100);

    void d(Drawable r100, ScalingUtils.ScaleType r101);

    Context getContext();

    com.bytedance.android.ecom.arch.slice.render.widget.fresco.h getController();
}
