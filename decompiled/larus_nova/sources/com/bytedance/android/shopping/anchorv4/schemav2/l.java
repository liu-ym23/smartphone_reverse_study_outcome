package com.bytedance.android.shopping.anchorv4.schemav2;

import android.net.Uri;
import com.bytedance.android.shopping.api.anchorv3.WireFrameSchemaInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class l extends PdpSchemaParam {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f167430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f167431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f167432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f167433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f167434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f167435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WireFrameSchemaInfo f167436i;

    public final void e() {
        this.f167431d = c().optString("product_id", "");
        this.f167432e = c().optString("promotion_id", "");
        this.f167433f = c().optString("cover_img");
        this.f167434g = c().optString("cover_img_uri");
        this.f167435h = c().optString(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID);
        String r100 = c().optString("product_pre_info");
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        this.f167436i = (WireFrameSchemaInfo) p83.a.a(r100, WireFrameSchemaInfo.class);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaParam
    public final String d() {
        return this.f167430c;
    }

    public l(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        super(r100);
        this.f167430c = "product_info";
        this.f167431d = "";
        this.f167432e = "";
    }
}
