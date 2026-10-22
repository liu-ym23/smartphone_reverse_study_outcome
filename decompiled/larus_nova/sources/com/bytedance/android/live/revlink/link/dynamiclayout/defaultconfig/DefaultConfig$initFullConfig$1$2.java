package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import t51.e;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "count", "", "forLayer", "", "Lt51/e;", AbsMethodDelegate.TAG_INVOKE, "(IZ)Ljava/util/List;", "genOtherSmallConfig"}, k = 3, mv = {1, 5, 1})
final class DefaultConfig$initFullConfig$1$2 extends Lambda implements Function2<Integer, Boolean, List<? extends e>> {
    public static final DefaultConfig$initFullConfig$1$2 INSTANCE = null;

    static {
        INSTANCE = new DefaultConfig$initFullConfig$1$2();
    }

    public DefaultConfig$initFullConfig$1$2() {
        super(2);
    }

    public final List<e> invoke(int r110, boolean r111) {
        e r100 = new e();
        r100.m(0.0f);
        r100.n(0.0f);
        r100.l(1.0f);
        r100.h(1.0f);
        r100.i(0);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r101 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r102 = Integer.valueOf(r101.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.q r103 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.q.f98776c;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r104 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r105 = Integer.valueOf(r104.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.p r106 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.p.f98775c;
        r100.t(MapsKt.mapOf(new Pair[]{TuplesKt.to(r102, 7), TuplesKt.to(r105, 6)}));
        r100.r(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r101.ordinal()), 6), TuplesKt.to(Integer.valueOf(r104.ordinal()), 6)}));
        ArrayList r107 = new ArrayList();
        r107.add(r100);
        if (r111 == false) goto L5;
        Number r112 = Double.valueOf(0.09d);
    L6:
        float r113 = r112.floatValue();
        int r108 = 1;
    L7:
        if (r108 >= r110) goto L9;
        e r109 = new e();
        r109.m((float) 0.7222d);
        r109.l((float) 0.25d);
        r109.h((float) 0.2d);
        r109.n(((float) (((double) (1 - (r108 * r109.a()))) - 0.1d)) + r113);
        r109.i(r108);
        r109.o();
        IAnchorUpdateLayoutContent.AnchorLayoutRange r114 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r115 = Integer.valueOf(r114.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.q r116 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.q.f98776c;
        r109.t(MapsKt.mapOf(TuplesKt.to(r115, 7)));
        r109.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r114.ordinal()), 7)));
        Unit r117 = Unit.INSTANCE;
        r107.add(r109);
        r108 = r108 + 1;
        goto L7
    L9:
        return r107;
    L5:
        r112 = 0;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ List<? extends e> invoke(Integer r100, Boolean r101) {
        return invoke(r100.intValue(), r101.booleanValue());
    }

    public static /* synthetic */ List invoke$default(DefaultConfig$initFullConfig$1$2 r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.invoke(r101, r102);
    }
}
