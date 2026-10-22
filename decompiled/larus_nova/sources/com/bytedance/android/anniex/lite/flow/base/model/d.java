package com.bytedance.android.anniex.lite.flow.base.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements com.bytedance.android.anniex.lite.flow.base.model.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f40932a;

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.model.a.b
    public final <T extends AnnieXModel> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        return r100.newInstance();
    L5:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r100, e);
    L8:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r100, e);
    }
}
