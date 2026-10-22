package com.bytedance.android.harmony;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010'\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/bytedance/android/harmony/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/Map$Entry;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ServiceHub$unloadDriver$1 extends Lambda implements Function1<Map.Entry<String, a>, Boolean> {
    final /* synthetic */ a $driver;

    public ServiceHub$unloadDriver$1(a r100) {
        this.$driver = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Map.Entry<String, a> r100) {
        if (r100.getValue() != this.$driver) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<String, a> r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
