package com.bytedance.android.ec.hybrid.card.cache.template;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f46457a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L22;
        e r101 = (e) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        if (this.f46457a == r101.f46457a) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(null, null) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    public final int hashCode() {
        boolean r100 = this.f46457a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return ((((((((r101 + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0;
    }

    public final String toString() {
        return "LynxCardTemplateCache(kitView=null, schemaUri=null, ecLoadSession=null, enableJSRuntime=false, enableStrictMode=false, lynxThreadStrategy=0, itemType=0, lifeCycleAdapter=null, result=" + this.f46457a + ", ecJsEventSubscriber=null, methodFinder=null, originSchema=null, screenWidth=0)";
    }

    public final void setResult(boolean r100) {
        this.f46457a = r100;
    }
}
