package com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import pn0.f;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/MultiLinkAudioStageEnlargeRecyclerLayoutManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/MultiLinkRecyclerLayoutManagerV2;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkAudioStageEnlargeRecyclerLayoutManager extends MultiLinkRecyclerLayoutManagerV2 {
    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.MultiLinkRecyclerLayoutManagerV2, ug0.a
    public final Pair<Integer, Integer> a(int r100) {
        Iterator<T> r101 = this.f75830b.f529924d.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (((f.c) r102).f529933a != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L12:
        f.c r104 = (f.c) r102;
        if (r104 == null) goto L15;
        if (r100 != 0) goto L20;
        return new Pair(Integer.valueOf(r104.f529937e), Integer.valueOf((int) (((double) r104.f529938f) * 1.15d)));
    L20:
        return new Pair(Integer.valueOf(r104.f529937e), Integer.valueOf(r104.f529938f));
    L15:
        return new Pair(0, 0);
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L12
    }

    public MultiLinkAudioStageEnlargeRecyclerLayoutManager(m r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "linkWindowLayoutConfig");
        Intrinsics.checkNotNullParameter(r101, "layoutConfigResult");
        super(r100, r101);
    }
}
