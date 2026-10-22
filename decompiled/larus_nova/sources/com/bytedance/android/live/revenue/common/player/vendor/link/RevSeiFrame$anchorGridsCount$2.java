package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.android.live.revlink.impl.multianchor.model.WindowType;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import z41.g;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$anchorGridsCount$2 extends FunctionReferenceImpl implements Function0<Integer> {
    public RevSeiFrame$anchorGridsCount$2(RevSeiFrame r100) {
        super(0, r100, RevSeiFrame.class, "parseAnchorGridsCount", "parseAnchorGridsCount()I", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        RevSeiFrame r100 = (RevSeiFrame) this.receiver;
        Lazy r101 = RevSeiFrame.D;
        if (r100.h() == true) goto L5;
    L20:
        Integer r102 = r100.n();
        if (r102 != null) goto L24;
    L26:
        p0 r103 = r100.b();
        if (r103 == null) goto L41;
        List<RevSeiRegion> r104 = r103.e();
        if (r104 != null) goto L31;
        return 0;
    L31:
        return r104.size();
    L41:
        return 0;
    L24:
        if (r102.intValue() != 2) goto L26;
        return 2;
    L5:
        if (g.f569928o.b() == false) goto L20;
        p0 r105 = r100.b();
        if (r105 == null) goto L37;
        List<RevSeiRegion> r106 = r105.h();
        if (r106 == null) goto L38;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L12:
        if (r108.hasNext() == false) goto L39;
        Object r109 = r108.next();
        if (((RevSeiRegion) r109).getWindowType() != WindowType.Anchor.ordinal()) goto L16;
        boolean r110 = true;
    L17:
        if (r110 == false) goto L12;
        r107.add(r109);
        goto L12
    L16:
        r110 = false;
        goto L17
    L39:
        return r107.size();
    L38:
        return 0;
    L37:
        return 0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}
