package com.bytedance.android.shopping.store.mall.follows.apidata;

import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f185540a = null;

    public a() {
    }

    static {
        f185540a = new a();
    }

    public final void delete(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Keva.getRepo("follow_store", 1).storeString(r100, null);
    }

    public final String query(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return Keva.getRepo("follow_store", 1).getString(r100, null);
    }
}
