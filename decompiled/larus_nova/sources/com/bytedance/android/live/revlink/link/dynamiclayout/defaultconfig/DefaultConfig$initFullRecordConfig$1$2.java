package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import t51.e;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "count", "", "forLayer", "forStreamMix", "", "Lt51/e;", AbsMethodDelegate.TAG_INVOKE, "(IZZ)Ljava/util/List;", "genOtherSmallConfig"}, k = 3, mv = {1, 5, 1})
final class DefaultConfig$initFullRecordConfig$1$2 extends Lambda implements Function3<Integer, Boolean, Boolean, List<? extends e>> {
    public static final DefaultConfig$initFullRecordConfig$1$2 INSTANCE = null;

    static {
        INSTANCE = new DefaultConfig$initFullRecordConfig$1$2();
    }

    public DefaultConfig$initFullRecordConfig$1$2() {
        super(3);
    }

    public final List<e> invoke(int r100, boolean r110, boolean r111) {
        e r112 = new e();
        r112.m(0.0f);
        r112.n(0.0f);
        r112.l(1.0f);
        r112.h(1.0f);
        r112.i(0);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r101 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r102 = Integer.valueOf(r101.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.q r103 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.q.f98776c;
        r112.t(MapsKt.mapOf(TuplesKt.to(r102, 7)));
        Integer r104 = Integer.valueOf(r101.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.p r105 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.p.f98775c;
        r112.r(MapsKt.mapOf(TuplesKt.to(r104, 6)));
        r112.k();
        ArrayList r106 = new ArrayList();
        r106.add(r112);
        if (r110 == false) goto L5;
        Number r113 = Double.valueOf(0.09d);
    L6:
        float r114 = r113.floatValue();
        int r107 = 1;
    L7:
        if (r107 >= r100) goto L9;
        e r108 = new e();
        r108.m((float) 0.7222d);
        r108.l((float) 0.25d);
        r108.h((float) 0.2d);
        r108.n(((float) (((double) (1 - (r107 * r108.a()))) - 0.1d)) + r114);
        r108.i(r107);
        r108.o();
        IAnchorUpdateLayoutContent.AnchorLayoutRange r109 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r115 = Integer.valueOf(r109.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.q r116 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.q.f98776c;
        r108.t(MapsKt.mapOf(TuplesKt.to(r115, 7)));
        r108.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r109.ordinal()), 7)));
        Unit r117 = Unit.INSTANCE;
        r106.add(r108);
        r107 = r107 + 1;
        goto L7
    L9:
        return r106;
    L5:
        r113 = 0;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ List<? extends e> invoke(Integer r100, Boolean r101, Boolean r102) {
        return invoke(r100.intValue(), r101.booleanValue(), r102.booleanValue());
    }

    public static /* synthetic */ List invoke$default(DefaultConfig$initFullRecordConfig$1$2 r100, int r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return r100.invoke(r101, r102, r103);
    }
}
