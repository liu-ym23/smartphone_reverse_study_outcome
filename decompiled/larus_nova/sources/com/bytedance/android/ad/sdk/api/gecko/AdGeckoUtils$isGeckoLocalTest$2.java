package com.bytedance.android.ad.sdk.api.gecko;

import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.b;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import l6.g;
import t6.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class AdGeckoUtils$isGeckoLocalTest$2 extends Lambda implements Function0<Boolean> {
    public static final AdGeckoUtils$isGeckoLocalTest$2 INSTANCE = null;

    static {
        INSTANCE = new AdGeckoUtils$isGeckoLocalTest$2();
    }

    public AdGeckoUtils$isGeckoLocalTest$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        b r100 = b.a.f245076a;
        GeckoGlobalConfig r101 = b.a();
        if (r101 == null) goto L5;
        GeckoGlobalConfig.ENVType r102 = r101.getEnv();
    L7:
        if (r102 != null) goto L9;
        t6.b r103 = a.f544652a;
        g r104 = (g) a.C7690a.a(g.class, null);
        if (r104 != null) goto L16;
    L18:
        return false;
    L16:
        if (r104.isDebug() != true) goto L18;
        return true;
    L9:
        if (r102 != GeckoGlobalConfig.ENVType.PROD) goto L19;
        return false;
    L19:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }
}
