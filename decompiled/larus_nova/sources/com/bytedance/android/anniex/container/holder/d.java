package com.bytedance.android.anniex.container.holder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class d implements ja.c {
    public d() {
    }

    public abstract ia.b a();

    @Override // ja.c
    public final void loadSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        a().loadSchema(r100, null);
    }
}
