package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class HybridPropertyUtilsKt$STRING_MAP_ADAPTER$2 extends FunctionReferenceImpl implements Function2<String, Map<String, ? extends String>, Unit> {
    public static final HybridPropertyUtilsKt$STRING_MAP_ADAPTER$2 INSTANCE = null;

    static {
        INSTANCE = new HybridPropertyUtilsKt$STRING_MAP_ADAPTER$2();
    }

    public HybridPropertyUtilsKt$STRING_MAP_ADAPTER$2() {
        super(2, HybridPropertyUtilsKt.class, "writeStringMapToString", "writeStringMapToString(Ljava/lang/String;Ljava/util/Map;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Map<String, ? extends String> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r101, "p2");
        HybridPropertyUtilsKt.f90802a.edit().putString(r100, JsonUtil.toJSONString(r101)).apply();
    }
}
