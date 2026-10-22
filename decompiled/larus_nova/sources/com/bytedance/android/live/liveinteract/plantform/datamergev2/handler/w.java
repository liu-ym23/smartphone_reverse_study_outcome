package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class w<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f76755a;

    public w(p r100) {
        this.f76755a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        SeiAppData r111 = (SeiAppData) r110;
        Intrinsics.checkNotNullParameter(r111, "curr");
        p r100 = this.f76755a;
        SeiAppData r101 = r100.f76739f;
        r100.f76739f = r111;
        if (r101 == null) goto L37;
        int r102 = 0;
        if (r101.getTimestamp() != r111.getTimestamp()) goto L10;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b r103 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b(r101, r111, false, false);
    L45:
        return r103;
    L10:
        if (r101.getGrids().size() == r111.getGrids().size()) goto L13;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b r104 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b(r101, r111, true, true);
    L46:
        return r104;
    L13:
        int r105 = r111.getGrids().size();
        boolean r106 = false;
        boolean r107 = false;
    L14:
        if (r102 >= r105) goto L36;
        SeiRegion r108 = (SeiRegion) ListProtector.get(r111.getGrids(), r102);
        Iterator<T> r109 = r101.getGrids().iterator();
    L17:
        if (r109.hasNext() == false) goto L21;
        T r112 = r109.next();
        if (Intrinsics.areEqual(((SeiRegion) r112).getInteractId(), r108.getInteractId()) == false) goto L17;
    L22:
        SeiRegion r113 = r112;
        if (r113 == null) goto L24;
        if (r108.getType() == r113.getType()) goto L28;
    L31:
        r106 = true;
    L33:
        if (r108.isTalking() == r113.isTalking()) goto L35;
        r107 = true;
    L35:
        r102 = r102 + 1;
        goto L14
    L28:
        if (r108.position != r113.position) goto L31;
        if (r108.isVisible() == r113.isVisible()) goto L33;
    L24:
        r104 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b(r101, r111, true, true);
        goto L46
    L21:
        r112 = (T) null;
        goto L22
    L36:
        r103 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b(r101, r111, r106, r107);
        goto L45
    L37:
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b(null, r111, true, true);
    }
}
