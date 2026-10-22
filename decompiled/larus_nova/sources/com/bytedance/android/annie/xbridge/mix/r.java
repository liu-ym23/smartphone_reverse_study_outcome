package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class r implements IDLXBridgeMethod.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q.a f40189a;

    public r(q.a r100) {
        this.f40189a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.a
    public final void invoke(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f40189a.finishWithRawResult(ConvertUtils.mapToJSON$default(ConvertUtils.INSTANCE, r100, 0, 2, null));
    }
}
