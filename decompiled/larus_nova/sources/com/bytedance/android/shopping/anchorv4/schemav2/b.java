package com.bytedance.android.shopping.anchorv4.schemav2;

import android.net.Uri;
import com.bytedance.android.livesdkapi.app.AppConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends PdpSchemaParam {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f167366c;

    @Override // com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaParam
    public final String d() {
        return this.f167366c;
    }

    public b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        super(r100);
        this.f167366c = AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS;
    }
}
