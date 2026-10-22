package com.bytedance.android.livesdkapi.hybridapi;

import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n56.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004H\u0016J\u001c\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u0004H\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004H\u0016J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/hybridapi/BaseJsBridgeMethodFactory;", "", "Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeManager;", "manager", "", "", "Lcom/bytedance/ies/web/jsbridge2/g;", "provideStatelessMethods", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "provideStatefulMethods", "Ln56/c;", "provideLegacyMethods", "provideLegacyCacheableMethods", "provideStatelessCacheableMethods", "provideStatefulCacheableMethods", "provideLegacySpecifiedMethods", "provideStatelessSpecifiedMethods", "provideStatefulSpecifiedMethods", "<init>", "()V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseJsBridgeMethodFactory {
    public BaseJsBridgeMethodFactory() {
    }

    public Map<String, c> provideLegacyCacheableMethods() {
        return MapsKt.emptyMap();
    }

    public Map<String, f.b> provideStatefulCacheableMethods() {
        return MapsKt.emptyMap();
    }

    public Map<String, g<?, ?>> provideStatelessCacheableMethods() {
        return MapsKt.emptyMap();
    }

    public Map<String, c> provideLegacyMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.plus(provideLegacyCacheableMethods(), provideLegacySpecifiedMethods(r100));
    }

    public Map<String, c> provideLegacySpecifiedMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.emptyMap();
    }

    public Map<String, f.b> provideStatefulMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.plus(provideStatefulCacheableMethods(), provideStatefulSpecifiedMethods(r100));
    }

    public Map<String, f.b> provideStatefulSpecifiedMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.emptyMap();
    }

    public Map<String, g<?, ?>> provideStatelessMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.plus(provideStatelessCacheableMethods(), provideStatelessSpecifiedMethods(r100));
    }

    public Map<String, g<?, ?>> provideStatelessSpecifiedMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.emptyMap();
    }
}
