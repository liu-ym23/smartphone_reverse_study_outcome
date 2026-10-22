package com.bytedance.android.livesdk.link.model.bridge;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c2 {
    public static final String a(b2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$simpleString");
        StringBuilder r101 = new StringBuilder("PreRtcInfo{");
        Map<Long, z1> r102 = r100.getPreRtcUserInfo();
        if (r102 == null) goto L8;
        Iterator<Map.Entry<Long, z1>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<Long, z1> r104 = r103.next();
        r101.append("[");
        r101.append(r104.getKey().longValue());
        r101.append(":");
        r101.append(r104.getValue().getLinkmicIdStr());
        r101.append(",push=");
        r101.append(r104.getValue().getRtcPushStream());
        r101.append(",status=");
        r101.append(r104.getValue().getLinkStatus());
        r101.append("]");
    L8:
        r101.append(" pre_join=");
        r101.append(r100.getRtcJoinChannel());
        r101.append(" version=");
        r101.append(r100.getVersion());
        r101.append(com.alipay.sdk.m.u.i.f25855d);
        return r101.toString();
    }
}
