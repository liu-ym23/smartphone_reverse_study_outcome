package com.bytedance.android.shopping.anchorv4.schemav2;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class k extends PdpSchemaParam {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f167428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f167429d;

    @Override // com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaParam
    public final String d() {
        return this.f167429d;
    }

    public k(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        super(r100);
        this.f167428c = Boolean.TRUE;
        this.f167429d = "platform_params";
    }
}
