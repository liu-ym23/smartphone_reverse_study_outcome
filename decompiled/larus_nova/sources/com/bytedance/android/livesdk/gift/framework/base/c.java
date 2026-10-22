package com.bytedance.android.livesdk.gift.framework.base;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements ExclusionStrategy {
    public c() {
    }

    @Override // com.google.gson.ExclusionStrategy
    public final boolean shouldSkipClass(Class<?> r100) {
        return false;
    }

    @Override // com.google.gson.ExclusionStrategy
    public final boolean shouldSkipField(FieldAttributes r100) {
        Intrinsics.checkNotNullParameter(r100, "field");
        if (r100.getAnnotation(TraceExclude.class) == null) goto L5;
    L8:
        return true;
    L5:
        if ((FieldAttributes.class instanceof k) == true) goto L8;
        return false;
    }
}
