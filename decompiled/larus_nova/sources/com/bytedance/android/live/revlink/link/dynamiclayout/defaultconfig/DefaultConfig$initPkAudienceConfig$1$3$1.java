package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import t51.e;
import z41.g;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "offset", "", "forWithAudience", "", "Lt51/e;", AbsMethodDelegate.TAG_INVOKE, "(IZ)Ljava/util/List;", "getAnchorRegion"}, k = 3, mv = {1, 5, 1})
final class DefaultConfig$initPkAudienceConfig$1$3$1 extends Lambda implements Function2<Integer, Boolean, List<? extends e>> {
    public static final DefaultConfig$initPkAudienceConfig$1$3$1 INSTANCE = null;

    static {
        INSTANCE = new DefaultConfig$initPkAudienceConfig$1$3$1();
    }

    public DefaultConfig$initPkAudienceConfig$1$3$1() {
        super(2);
    }

    public final List<e> invoke(int r100, boolean r101) {
        if (g.f569928o.b() == false) goto L6;
        if (r101 == false) goto L6;
        float r102 = 8.5f;
    L7:
        e r103 = new e();
        r103.m(0.0f);
        r103.n(0.19f);
        r103.l(0.5f);
        float r104 = r102 / 32.0f;
        r103.h(r104);
        r103.i(r100 + 0);
        r103.s();
        Unit r105 = Unit.INSTANCE;
        e r106 = new e();
        r106.m(0.5f);
        r106.n(0.19f);
        r106.l(0.5f);
        r106.h(r104);
        r106.i(r100 + 1);
        r106.s();
        return CollectionsKt.listOf(new e[]{r103, r106});
    L6:
        r102 = 13.0f;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ List<? extends e> invoke(Integer r100, Boolean r101) {
        return invoke(r100.intValue(), r101.booleanValue());
    }
}
