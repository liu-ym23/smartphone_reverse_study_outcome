package com.bytedance.android.shopping.anchorv4.schemav2;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p extends PdpSchemaParam {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f167442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f167443d;

    @Override // com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaParam
    public final String d() {
        return this.f167442c;
    }

    public p(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        super(r100);
        this.f167442c = "user_info";
    }
}
