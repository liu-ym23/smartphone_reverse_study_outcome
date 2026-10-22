package com.bytedance.android.live.revlink.link.core.service;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.bytedance.android.livesdk.link.model.bridge.g> f98360a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f98360a, ((o) r100).f98360a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, com.bytedance.android.livesdk.link.model.bridge.g> r100 = this.f98360a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("LayoutDetails(positionDetails={");
        Iterator<Map.Entry<String, com.bytedance.android.livesdk.link.model.bridge.g>> r101 = this.f98360a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, com.bytedance.android.livesdk.link.model.bridge.g> r102 = r101.next();
        r100.append(r102.getKey() + com.alipay.sdk.m.n.a.f25612h + r102.getValue().getPosition() + ", ");
        goto L4
    L6:
        r100.append("})");
        return r100.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Map<String, ? extends com.bytedance.android.livesdk.link.model.bridge.g> r100) {
        Intrinsics.checkNotNullParameter(r100, "positionDetails");
        this.f98360a = r100;
    }
}
