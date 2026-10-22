package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends qf3.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f178202d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f178202d;
    }

    public f(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
        this.f178202d = "ec.mall.hideTaskBanner";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        Object r104 = r102.get("containerID");
        if ((r104 instanceof String) == true) goto L5;
        r104 = null;
    L5:
        String r105 = (String) r104;
        if (r105 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == true) goto L14;
        IHybridHostService r107 = com.bytedance.android.ec.hybrid.a.h();
        if (r107 == null) goto L22;
        yj.f r108 = r107.getHybridECSdkService();
        if (r108 == null) goto L22;
        r108.hideTaskBanner(r105);
        Unit r109 = Unit.INSTANCE;
        Pair<Boolean, String> r110 = qf3.e.f(this);
        if (r110 == null) goto L22;
        return r110;
    L22:
        return qf3.e.c("ECHostService or ECSdkService is null");
    L14:
        return qf3.e.c("containerID is null or empty");
    L8:
        if (r105.length() == 0) goto L11;
        r106 = false;
        goto L12
    }
}
