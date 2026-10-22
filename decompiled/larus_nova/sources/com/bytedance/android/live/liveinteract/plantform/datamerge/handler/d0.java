package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f76429a;

    public d0(y r100) {
        this.f76429a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        SeiAppData r111 = (SeiAppData) r110;
        Intrinsics.checkNotNullParameter(r111, "curr");
        y r100 = this.f76429a;
        SeiAppData r101 = r100.f76552e;
        r100.f76552e = r111;
        if (r101 != null) goto L6;
        return new b.C1190b(null, r111, true, true);
    L6:
        if (r101.getTimestamp() != r111.getTimestamp()) goto L10;
        b.C1190b r102 = new b.C1190b(r101, r111, false, false);
    L52:
        return r102;
    L10:
        if (r101.getGrids().size() == r111.getGrids().size()) goto L13;
        b.C1190b r103 = new b.C1190b(r101, r111, true, true);
    L53:
        return r103;
    L13:
        int r104 = r111.getGrids().size();
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L43;
        SeiRegion r106 = (SeiRegion) ListProtector.get(r111.getGrids(), r105);
        Iterator<T> r107 = r101.getGrids().iterator();
    L17:
        if (r107.hasNext() == false) goto L21;
        T r108 = r107.next();
        if (Intrinsics.areEqual(((SeiRegion) r108).getInteractId(), r106.getInteractId()) == false) goto L17;
    L22:
        SeiRegion r109 = r108;
        if (r109 == null) goto L24;
        if (r106.getType() == r109.getType()) goto L28;
    L33:
        boolean r112 = true;
    L35:
        if (r106.isTalking() == r109.isTalking()) goto L37;
        boolean r113 = true;
    L38:
        if (r112 == true) goto L42;
        if (r113 == true) goto L42;
        r105 = r105 + 1;
    L42:
        r102 = new b.C1190b(r101, r111, r112, r113);
        goto L52
    L37:
        r113 = false;
        goto L38
    L28:
        if (r106.position != r109.position) goto L33;
        if (r106.isVisible() != r109.isVisible()) goto L33;
        r112 = false;
        goto L35
    L24:
        r103 = new b.C1190b(r101, r111, true, true);
        goto L53
    L21:
        r108 = (T) null;
        goto L22
    L43:
        r102 = new b.C1190b(r101, r111, false, false);
        goto L52
    }
}
