package com.bytedance.android.anya;

import com.bytedance.android.anya.BaseMVIDataStore;

/* JADX INFO: loaded from: classes43.dex */
@AnyaDSL
public interface n<DATA_STORE extends BaseMVIDataStore<?>> {
    <T> void a(t<DATA_STORE, T> r100, T r101);

    <T> T b(t<DATA_STORE, T> r100);
}
