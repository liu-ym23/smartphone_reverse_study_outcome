package com.bytedance.android.annie.websocket;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f40114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f40115e;

    public e(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "socketTaskID");
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f40111a = r100;
        this.f40112b = r101;
        this.f40113c = r102;
        this.f40114d = r103;
        this.f40115e = r104;
    }
}
