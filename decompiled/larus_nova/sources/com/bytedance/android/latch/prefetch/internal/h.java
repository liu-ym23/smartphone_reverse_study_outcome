package com.bytedance.android.latch.prefetch.internal;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f58482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f58483b;

    @Override // com.bytedance.android.latch.prefetch.internal.p
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TEMPLATE_VERSION);
        return TextUtils.equals(this.f58483b.f58489a, r100);
    }

    public h(g r100, t r101) {
        this.f58482a = r100;
        this.f58483b = r101;
    }

    @Override // com.bytedance.android.latch.prefetch.internal.p
    public final JSONObject b(String r100, com.bytedance.android.latch.a.b r101, o r102) {
        Intrinsics.checkNotNullParameter(r100, "pageUrl");
        Intrinsics.checkNotNullParameter(r101, "dataHolder");
        Intrinsics.checkNotNullParameter(r102, "bridge");
        this.f58482a.f58481a.a(r100, this.f58483b, r101, r102);
        return this.f58483b.f58491c;
    }
}
