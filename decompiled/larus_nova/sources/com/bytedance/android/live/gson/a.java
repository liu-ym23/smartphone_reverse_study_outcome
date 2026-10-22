package com.bytedance.android.live.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements ExclusionStrategy {
    public a() {
    }

    @Override // com.google.gson.ExclusionStrategy
    public final boolean shouldSkipClass(Class<?> r100) {
        return false;
    }

    @Override // com.google.gson.ExclusionStrategy
    public final boolean shouldSkipField(FieldAttributes r100) {
        Intrinsics.checkNotNullParameter(r100, "f");
        SerializedName r101 = (SerializedName) r100.getAnnotation(SerializedName.class);
        Class<?> r102 = r100.getDeclaredClass();
        if (r102.isArray() == false) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L15;
        if (r101 != null) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual("user_ids", r101.value()) == false) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    L5:
        if (Iterable.class.isAssignableFrom(r102) == true) goto L8;
        r103 = false;
        goto L9
    }
}
