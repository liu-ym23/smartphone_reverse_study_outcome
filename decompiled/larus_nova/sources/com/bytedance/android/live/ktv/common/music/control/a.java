package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements h {
    public a() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.h
    public final boolean a(IMusicControlNode r110, CopyOnWriteArrayList<IMusicControlNode> r111, CopyOnWriteArrayList<IMusicControlNode> r112) {
        Intrinsics.checkNotNullParameter(r110, "node");
        Intrinsics.checkNotNullParameter(r111, "waitingList");
        Intrinsics.checkNotNullParameter(r112, "runningList");
        boolean r100 = false;
        if (r112.isEmpty() == false) goto L6;
        return false;
    L6:
        if ((r112.get(0) instanceof b) == true) goto L8;
    L49:
        return true;
    L8:
        if ((r110 instanceof b) == false) goto L49;
        int r101 = r112.size();
        int r102 = 0;
    L11:
        if (r102 >= r101) goto L29;
        IMusicControlNode r103 = r112.get(r102);
        if ((r103 instanceof b) == false) goto L27;
        MusicPanel r104 = ((b) r103).f70024d;
        if (r104 == null) goto L27;
        KtvMusic r105 = r104.f153577a;
        if (r105 == null) goto L27;
        long r106 = r105.getId();
        MusicPanel r107 = ((b) r110).f70024d;
        if (r107 == null) goto L23;
        KtvMusic r108 = r107.f153577a;
        if (r108 == null) goto L23;
        Long r109 = Long.valueOf(r108.getId());
    L25:
        if (r106 != r109.longValue()) goto L27;
        r111.remove(r110);
        r100 = true;
    L23:
        r109 = null;
    L27:
        r102 = r102 + 1;
    L29:
        if (r111.isEmpty() == true) goto L48;
        Iterator<IMusicControlNode> r113 = r111.iterator();
    L32:
        if (r113.hasNext() == false) goto L48;
        IMusicControlNode r114 = r113.next();
        if ((r114 instanceof b) == false) goto L32;
        MusicPanel r115 = ((b) r114).f70024d;
        if (r115 == null) goto L32;
        KtvMusic r116 = r115.f153577a;
        if (r116 == null) goto L32;
        long r117 = r116.getId();
        MusicPanel r118 = ((b) r110).f70024d;
        if (r118 == null) goto L44;
        KtvMusic r119 = r118.f153577a;
        if (r119 == null) goto L44;
        Long r120 = Long.valueOf(r119.getId());
    L46:
        if (r117 != r120.longValue()) goto L32;
        r111.remove(r110);
    L44:
        r120 = null;
    L48:
        return r100;
    }
}
