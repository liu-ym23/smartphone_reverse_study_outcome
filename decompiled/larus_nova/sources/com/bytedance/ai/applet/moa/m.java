package com.bytedance.ai.applet.moa;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34865b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f34864a, r101.f34864a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34865b, r101.f34865b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f34864a.hashCode() * 31) + this.f34865b.hashCode();
    }

    public final String toString() {
        return "MoaGrantingRequest(appletId=" + this.f34864a + ", authorizationID=" + this.f34865b + ')';
    }

    public m(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r101, "authorizationID");
        this.f34864a = r100;
        this.f34865b = r101;
    }
}
