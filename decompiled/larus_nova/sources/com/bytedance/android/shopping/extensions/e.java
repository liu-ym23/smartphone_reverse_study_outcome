package com.bytedance.android.shopping.extensions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {
    public static final <T> MutableLiveData<T> a(LiveData<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$mutable");
        return (MutableLiveData) r100;
    }
}
