package com.bytedance.android.live.room.api.screenrotation.rotate;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f99146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f99147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f99148c;

    public h(f r100, String r101, i r102, T r103) {
        Intrinsics.checkNotNullParameter(r100, "orientation");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "rotateType");
        this.f99146a = r101;
        this.f99147b = r102;
        this.f99148c = r103;
    }
}
