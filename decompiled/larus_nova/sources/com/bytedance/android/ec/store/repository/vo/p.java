package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.android.ec.store.repository.dto.StoreV2CartsInfoDTO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f48474b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f48475a;

    public static final class a {
        public static p a(StoreV2CartsInfoDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            p r101 = new p();
            r101.f48475a = r100.getJumpCartsUrl();
            r100.getProductNum();
            return r101;
        }
    }

    static {
    }

    public p() {
    }
}
