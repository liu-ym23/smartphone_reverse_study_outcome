package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes39.dex */
interface ModelTypes<T> {
    T load(Bitmap r100);

    T load(Drawable r100);

    T load(Uri r100);

    T load(File r100);

    T load(Integer r100);

    T load(Object r100);

    T load(String r100);

    T load(URL r100);

    T load(byte[] r100);
}
