package com.bytedance.android.ecom.arch.slice;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class o extends com.bytedance.android.ecom.arch.slice.render.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f50080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SlcElement f50081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f50082f;

    public final String getType() {
        return this.f50080d;
    }

    public o(String r100, String r101, String r102, String r103, SlcElement r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "version");
        super(r100, r101, r102);
        this.f50080d = r103;
        this.f50081e = r104;
        this.f50082f = r105;
    }
}
