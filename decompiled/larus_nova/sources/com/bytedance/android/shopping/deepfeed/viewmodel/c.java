package com.bytedance.android.shopping.deepfeed.viewmodel;

import com.bytedance.android.shopping.deepfeed.data.repo.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public interface c {
    void loadProductFeed(n r100);

    void loadProductPack(Function1<? super Boolean, Unit> r100);
}
