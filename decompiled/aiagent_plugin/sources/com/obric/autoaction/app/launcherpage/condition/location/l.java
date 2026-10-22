package com.obric.autoaction.app.launcherpage.condition.location;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: ConditionLocationModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("LinkedAddrCount")
    private final long f23214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("LinkedAddrCountByLevel")
    private final Map<String, Long> f23215b;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, l.class) == true) goto L8;
        return false;
    L8:
        l r10 = (l) ZeusTransformUtils.preCheckCast(r9, l.class, "com.obric.aiagent.plugin");
        if (this.f23214a == r10.f23214a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23215b, r10.f23215b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f23214a) * 31) + this.f23215b.hashCode();
    }

    public String toString() {
        return "LinkedAddr(linkedAddrCount=" + this.f23214a + ", linkedAddrCountByLevel=" + this.f23215b + ')';
    }
}
