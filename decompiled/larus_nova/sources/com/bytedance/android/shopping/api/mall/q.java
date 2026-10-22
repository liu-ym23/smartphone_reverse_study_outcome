package com.bytedance.android.shopping.api.mall;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q extends r {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L14;
        ((q) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return 0 + ((int) 0);
    }

    public final String toString() {
        return "PreRenderTemplateTaskContext(useIdle=0, loadImmediateDelayTime=null, invalidBySchema=false, invalidByStr=null, baseCtx=null, threadStrategy=null, preloadInWorkThread=false, preloadModelOnly=false, checkLynxEnvInterval=0)";
    }
}
