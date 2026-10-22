package com.bytedance.android.bcm.impl.paramcheck.checker;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.ALogger;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ExtraRuleChecker implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f41870a;

    public ExtraRuleChecker() {
        this.f41870a = LazyKt.lazy(ExtraRuleChecker$expressRunner$2.INSTANCE);
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.checker.d
    public final List<a> a(final com.bytedance.android.bcm.impl.paramcheck.c r100, com.bytedance.android.bcm.impl.paramcheck.a r101, boolean r102) {
        if (r102 == false) goto L4;
        BcmParams r103 = r100.b();
        if (r103 == null) goto L8;
        Map<String, Object> r104 = r103.toMap();
    L9:
        final String r105 = r101.f41866b;
        if (r104 == null) goto L29;
        if (r104.isEmpty() == true) goto L29;
        if (r105 != null) goto L16;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == true) goto L29;
        final hc.a.b r107 = ((hc.a) this.f41870a.getValue()).run();     // Catch: Throwable -> L30
        ALogger.f41996d.a("Params_ExtraRule", true, new ExtraRuleChecker$check$1(r100, r105, r107));     // Catch: Throwable -> L30
        r107.getClass();     // Catch: Throwable -> L30
        if ((!Intrinsics.areEqual(r107.f484519a, Boolean.TRUE)) == false) goto L27;
        return CollectionsKt.listOf(new a.C0771a(r105));
    L27:
        return CollectionsKt.emptyList();
    L16:
        if (r105.length() == 0) goto L19;
        r106 = false;
    L29:
        return CollectionsKt.emptyList();
    L8:
        r104 = null;
        goto L9
    L4:
        return CollectionsKt.emptyList();
    }
}
