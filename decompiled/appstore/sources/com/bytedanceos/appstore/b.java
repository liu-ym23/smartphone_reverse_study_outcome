package com.bytedanceos.appstore;

import android.content.Context;
import android.view.View;
import com.bumptech.glide.Glide;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static Glide a(Context r10) {
        return Glide.get(r10);
    }

    public static e b(View r10) {
        return (e) Glide.with(r10);
    }
}
