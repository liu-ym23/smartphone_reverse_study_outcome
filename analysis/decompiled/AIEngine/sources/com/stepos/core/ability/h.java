package com.stepos.core.ability;

import com.stepos.core.ability.text.SessionStore;
import com.stepos.core.common.cloud.CloudConnectionWarmer;
import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Function;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7227a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f7228b;

    public /* synthetic */ h(l lVar, int i10) {
        this.f7227a = i10;
        this.f7228b = lVar;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i10 = this.f7227a;
        l lVar = this.f7228b;
        switch (i10) {
            case 0:
                return AbilityManager.setAbilityProperty$lambda$49((b6.i) lVar, obj);
            case 1:
                return SessionStore.getOrCreate$lambda$3((com.stepos.core.ability.text.e) lVar, obj);
            case 2:
                return CloudConnectionWarmer.warm$lambda$3((b6.i) lVar, obj);
            case 3:
                return ThreadPoolManagerImpl.enqueueOrReject$lambda$10((com.stepos.core.common.cloud.d) lVar, obj);
            default:
                return (CopyOnWriteArraySet) ((com.stepos.core.common.cloud.d) lVar).invoke(obj);
        }
    }
}
