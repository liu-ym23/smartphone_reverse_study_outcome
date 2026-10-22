package com.bytedance.android.ec.sdk.plugin;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class PluginBridgeMethod$handle$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ ECBaseBridgeMethod.a $iReturn;
    final /* synthetic */ JSONObject $params;
    final /* synthetic */ hj.c $pluginService;
    final /* synthetic */ pl.a $snapshot;
    final /* synthetic */ PluginBridgeMethod this$0;

    public PluginBridgeMethod$handle$1(PluginBridgeMethod r100, hj.c r101, pl.a r102, JSONObject r103, ECBaseBridgeMethod.a r104) {
        this.this$0 = r100;
        this.$pluginService = r101;
        this.$snapshot = r102;
        this.$params = r103;
        this.$iReturn = r104;
        super(1);
    }

    public final void invoke(boolean r100) {
        PluginBridgeMethod r101 = this.this$0;
        if (r101.f48145e == false) goto L8;
        System.out.println("Django: plugin init timeout in jsb");
        hj.c r102 = this.$pluginService;
        if (r102 == null) goto L10;
        r102.e();
        return;
    L10:
        return;
    L8:
        r101.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }
}
