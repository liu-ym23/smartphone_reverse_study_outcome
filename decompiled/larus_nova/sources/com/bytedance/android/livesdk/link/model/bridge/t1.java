package com.bytedance.android.livesdk.link.model.bridge;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class t1 {
    public static final String a(s1 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toSimpleString");
        StringBuilder r101 = new StringBuilder("MultiChannelInfo{");
        if (r100.getUseMultiChannel() == false) goto L5;
        String r102 = "";
    L6:
        r101.append(r102);
        r101.append("channels=");
        Map<Long, String> r103 = r100.getChannelMap();
        if (r103 == null) goto L9;
        Set<Long> r104 = r103.keySet();
    L10:
        r101.append(r104);
        r101.append('}');
        return r101.toString();
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = "useMultiChannel=false,";
        goto L6
    }
}
