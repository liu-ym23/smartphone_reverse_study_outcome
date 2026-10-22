package com.bytedance.android.monitorV2.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public class b extends HybridEvent {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final jz2.d f163022m;

    public b(jz2.d r100) {
        Intrinsics.checkNotNullParameter(r100, "customInfo");
        super("custom");
        this.f163022m = r100;
        c();
    }
}
