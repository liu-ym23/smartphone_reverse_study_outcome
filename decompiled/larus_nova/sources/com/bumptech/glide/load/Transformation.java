package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes39.dex */
public interface Transformation<T> extends Key {
    Resource<T> transform(Context r100, Resource<T> r101, int r102, int r103);
}
