package com.bytedance.android.ec.hybrid.list.util;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxLoadType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, q> f47356a = null;

    public r() {
    }

    static {
        f47356a = new LinkedHashMap();
    }

    public static ECLynxLoadType a(String r100, int r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = -1;
    L6:
        if ((r102 & 4) == 0) goto L8;
        ECLynxLoadType r103 = ECLynxLoadType.DEFAULT;
    L9:
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Intrinsics.checkNotNullParameter(r103, "fallback");
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        q r104 = (q) ((LinkedHashMap) f47356a).get(r100);
        if (r104 == null) goto L16;
        ECLynxLoadType r105 = r104.a(r101);
        if (r105 != null) goto L15;
        return r103;
    L15:
        return r105;
    L16:
        return r103;
    L8:
        r103 = null;
        goto L9
    }
}
