package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TabType f159950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f159951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f159952c;

    public final TabType getType() {
        return this.f159950a;
    }

    public e(TabType r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f159950a = r100;
        this.f159951b = r101;
        this.f159952c = r102;
    }
}
