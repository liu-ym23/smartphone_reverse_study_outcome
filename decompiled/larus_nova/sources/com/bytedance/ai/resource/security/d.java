package com.bytedance.ai.resource.security;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class d implements Function1 {
    public /* synthetic */ d() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.getBytes(Charsets.UTF_8);
    }
}
