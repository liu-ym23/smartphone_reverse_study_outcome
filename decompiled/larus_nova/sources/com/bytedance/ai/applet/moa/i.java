package com.bytedance.ai.applet.moa;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34853b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f34852a, r101.f34852a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34853b, r101.f34853b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f34852a.hashCode() * 31) + this.f34853b.hashCode();
    }

    public final String toString() {
        return "MoaGrantingKey(appletId=" + this.f34852a + ", authorizationID=" + this.f34853b + ')';
    }

    public i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r101, "authorizationID");
        this.f34852a = r100;
        this.f34853b = r101;
    }
}
