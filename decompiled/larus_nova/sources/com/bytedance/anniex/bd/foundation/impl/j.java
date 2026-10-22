package com.bytedance.anniex.bd.foundation.impl;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j implements AttachUserData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f190145a;

    public j(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f190145a = r100;
    }

    @Override // com.bytedance.crash.AttachUserData
    public final Map<String, String> getUserData(CrashType r100) {
        Map<String, String> r101 = this.f190145a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    L6:
        return r101;
    }
}
