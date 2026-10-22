package com.bytedance.android.shopping.anchorv4.schemav2;

import android.net.Uri;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class PdpSchemaParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f167346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f167347b;

    public final JSONArray b() {
        return (JSONArray) this.f167347b.getValue();
    }

    public final JSONObject c() {
        return (JSONObject) this.f167346a.getValue();
    }

    public abstract String d();

    public PdpSchemaParam(final Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.f167346a = LazyKt.lazy(new PdpSchemaParam$jsonObj$2(this, r100));
        this.f167347b = LazyKt.lazy(new PdpSchemaParam$jsonArray$2(this, r100));
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        c().put(r100, r101);
    }
}
