package com.bytedance.android.live.core.utils;

import android.graphics.Typeface;
import io.reactivex.Single;

/* JADX INFO: loaded from: classes45.dex */
public interface j0 {
    Single<Typeface> get();

    Typeface getHostTypeface(int r100);

    void init();
}
