package com.bytedance.android.monitorV2.event;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f163023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HybridEvent.a f163024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f163025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f163026d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f163023a, r101.f163023a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f163024b, r101.f163024b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f163025c, r101.f163025c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f163026d, r101.f163026d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f163023a.hashCode() * 31) + this.f163024b.hashCode()) * 31) + this.f163025c.hashCode()) * 31) + this.f163026d.hashCode();
    }

    public final String toString() {
        return "EventInfo(eventType=" + this.f163023a + ", state=" + this.f163024b + ", eventId=" + this.f163025c + ", info=" + this.f163026d + ')';
    }

    public c(String r100, HybridEvent.a r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r102, com.heytap.mcssdk.constant.b.f276361k);
        Intrinsics.checkNotNullParameter(r103, "info");
        this.f163023a = r100;
        this.f163024b = r101;
        this.f163025c = r102;
        this.f163026d = r103;
    }
}
