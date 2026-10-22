package com.bytedance.android.live.broadcastgame.opengame.runtime;

import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PluginContext$getPlugin$1 extends MutablePropertyReference0Impl {
    public PluginContext$getPlugin$1(PluginContext r100) {
        super(r100, PluginContext.class, CloudControlInf.PLUGIN, "getPlugin()Lcom/bytedance/android/live/broadcastgame/opengame/runtime/ILivePlugin;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        k r100 = ((PluginContext) this.receiver).f60797a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(CloudControlInf.PLUGIN);
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        k r101 = (k) r100;
        ((PluginContext) this.receiver).f60797a = r101;
    }
}
