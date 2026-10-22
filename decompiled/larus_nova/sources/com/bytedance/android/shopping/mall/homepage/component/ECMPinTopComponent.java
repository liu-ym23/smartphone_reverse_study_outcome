package com.bytedance.android.shopping.mall.homepage.component;

import android.os.Bundle;
import com.bytedance.android.shopping.api.mall.ability.MallAbilityManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMPinTopComponent extends b implements e93.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f178162b;

    public static final class a {
    }

    static {
    }

    @Override // u93.b, u93.c
    public final void onDestroy() {
        ((List) this.f178162b.getValue()).clear();
    }

    public ECMPinTopComponent() {
        this.f178162b = LazyKt.lazy(ECMPinTopComponent$guideBenefitListeners$2.INSTANCE);
    }

    @Override // u93.b, u93.c
    public final void onCreate(Bundle r100) {
        ConcurrentHashMap<Class<? extends e93.d>, Map<String, MallAbilityManager.a<? extends e93.d>>> r101 = MallAbilityManager.f170215a;
        MallAbilityManager.a(e93.a.class, this, o());
    }
}
