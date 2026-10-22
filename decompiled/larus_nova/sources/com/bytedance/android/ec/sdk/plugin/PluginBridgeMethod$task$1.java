package com.bytedance.android.ec.sdk.plugin;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PluginBridgeMethod$task$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PluginBridgeMethod this$0;

    public PluginBridgeMethod$task$1(PluginBridgeMethod r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        PluginBridgeMethod r100 = this.this$0;
        r100.getClass();
        r100.f48145e = true;
        ECBaseBridgeMethod.a r101 = r100.f48146f;
        if (r101 == null) goto L6;
        r101.onFailed(0, "Django: plugin init timeout in jsb");
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
