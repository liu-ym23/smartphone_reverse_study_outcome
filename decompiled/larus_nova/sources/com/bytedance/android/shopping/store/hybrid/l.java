package com.bytedance.android.shopping.store.hybrid;

import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabDTO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f184876a = 0;

    public l() {
    }

    static {
    }

    public static void b(int r100) {
        Intrinsics.checkNotNullParameter("homepage", "tabName");
        new StoreTabConfig(-1, r100, "homepage", true, -1, null, null);
    }

    public static StoreTabConfig a(uj3.j r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "tabVO");
        int r101 = r100.hashCode();
        int r102 = r100.f550300d;
        String r103 = r100.c();
        Integer r104 = r100.f550316t;
        ECStoreDynamicTabDTO.Companion.getClass();
        return new StoreTabConfig(r101, r102, r103, r110, r104, ECStoreDynamicTabDTO.a.a(r100), null);
    }
}
