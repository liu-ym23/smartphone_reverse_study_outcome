package com.bytedance.android.shopping.store.tabkit;

import androidx.lifecycle.MutableLiveData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, MutableLiveData<Object>> f186753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TabKitViewModel f186754b;

    public i(TabKitViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        this.f186754b = r100;
        this.f186753a = new HashMap();
    }
}
