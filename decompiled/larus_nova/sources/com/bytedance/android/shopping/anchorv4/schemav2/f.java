package com.bytedance.android.shopping.anchorv4.schemav2;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends PdpSchemaParam {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f167415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f167416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f167417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f167418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f167419g;

    public final String e() {
        JSONObject r100 = this.f167417e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.optString("creative_id");
    }

    @Override // com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaParam
    public final String d() {
        return this.f167415c;
    }

    public f(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        super(r100);
        this.f167415c = "custom_params";
        JSONObject r101 = this.f167417e;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.f167418f = r103;
        if (com.bytedance.android.ec.core.abtest.d.h() == false) goto L11;
    L12:
        r102 = true;
    L13:
        this.f167419g = r102;
        return;
    L11:
        if (com.bytedance.android.ec.core.anchorv3.o.a(null) == false) goto L13;
    L5:
        if (r101.optInt(com.bytedance.android.ec.core.event.a.KEY_IS_LUBAN) != 1) goto L7;
        r103 = true;
        goto L8
    }
}
