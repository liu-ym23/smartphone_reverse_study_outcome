package com.obric.autogui.common.api.model;

import android.content.Context;
import android.graphics.Bitmap;
import d.c.d;

/* JADX INFO: compiled from: IAutoActionLocalModelProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionLocalModelProvider {

    /* JADX INFO: compiled from: IAutoActionLocalModelProvider.kt */
    public interface ImageClassifyModel<R> {
        Object inference(Bitmap r1, d<? super com.obric.autogui.common.d<R>> r2);
    }

    Object acquireImageClassifyModel(Context r1, String r2, d<? super com.obric.autogui.common.d<ImageClassifyModel<String>>> r3);

    void init(Context r1);
}
