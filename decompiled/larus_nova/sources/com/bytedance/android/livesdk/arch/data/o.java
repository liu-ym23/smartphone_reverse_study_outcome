package com.bytedance.android.livesdk.arch.data;

import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class o extends t {
    public o() {
    }

    @Override // com.bytedance.android.livesdk.arch.data.a
    public final c a(c r100) {
        TbRoomDataPsContext r101 = (TbRoomDataPsContext) r100;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ILiveToolbarData r102 = r101.f103786i;
        if (r102 == null) goto L21;
        int r103 = n.f103801a[r101.f103787j.ordinal()];
        List<IToolbarComponentData> r104 = null;
        if (r103 != 1) goto L7;
        List<IToolbarComponentData> r105 = r102.getToolbarDataList();
    L11:
        if (r105 == null) goto L21;
        if ((!r105.isEmpty()) == false) goto L15;
        r104 = r105;
    L15:
        if (r104 == null) goto L21;
        List<IToolbarComponentData> r106 = r104;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L18:
        if (r108.hasNext() == false) goto L20;
        IToolbarComponentData r109 = (IToolbarComponentData) r108.next();
        Intrinsics.checkNotNullParameter(r109, "$this$toModel");
        int r110 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s.f116190q;
        r107.add(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s.a.a(r109));
        goto L18
    L20:
        r101.e(r107);
        goto L21
    L7:
        if (r103 == 2) goto L9;
        r105 = null;
        goto L11
    L9:
        r105 = r102.getMorePanelDataList();
    L21:
        return r101;
    }
}
