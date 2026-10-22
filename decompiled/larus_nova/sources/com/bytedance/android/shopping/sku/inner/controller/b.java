package com.bytedance.android.shopping.sku.inner.controller;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f182892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.sku.inner.container.b f182893b;

    public final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f182894a;

        public a(b r100) {
            this.f182894a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f182894a.f182893b.close(2);
        }
    }

    public b(com.bytedance.android.shopping.sku.inner.container.b r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f182893b = r100;
        this.f182892a = new a(this);
    }
}
