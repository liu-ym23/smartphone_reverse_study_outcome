package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l extends qf3.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f177122d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f177122d;
    }

    public l(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter("ec.mallInstantAndWindVansEnd", "name");
        super(r100);
        this.f177122d = "ec.mallInstantAndWindVansEnd";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        return TuplesKt.to(Boolean.TRUE, null);
    }
}
