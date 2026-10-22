package com.bytedance.android.shopping.anchorv4.schemav2;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends PdpSchemaParam {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f167367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f167368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f167369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f167370f;

    @Override // com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaParam
    public final String d() {
        return this.f167367c;
    }

    public c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        super(r100);
        this.f167367c = "biz_context";
    }
}
