package com.bytedance.android.live.liveinteract.spatial;

import ch0.e;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static final List<ILinkPlayerInfoBridge> b(List<e> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<e> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.add(r102.next().f23724a);
        goto L7
    L9:
        return r101;
    }

    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "content");
        ALogger.i("SpatialAudio_".concat(r100), r101);
    }
}
