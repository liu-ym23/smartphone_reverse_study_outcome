package com.stepos.aiengine;

import com.stepos.core.model.manager.ModelCacheImpl;
import java.util.Set;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final /* synthetic */ class AIEngineApplication$registerAicMemoryCallback$1$handler$2 extends FunctionReferenceImpl implements l<String, Set<? extends Integer>> {
    @Override // zb.l
    public final Set<? extends Integer> invoke(String str) {
        String p02 = str;
        g.f(p02, "p0");
        return ((ModelCacheImpl) this.receiver).holderUidsOf(p02);
    }
}
