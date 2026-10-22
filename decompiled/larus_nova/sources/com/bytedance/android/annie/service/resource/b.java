package com.bytedance.android.annie.service.resource;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements e {
    public b() {
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final int A1(String r100, boolean r101, String r102, String r103, IHybridComponent.HybridType r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r104, "type");
        return -1;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final boolean D1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return false;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final boolean F0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return false;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final boolean l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return false;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final int m(String r100, JSONObject r101, String r102, String r103, String r104, IHybridComponent.HybridType r105, String r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r105, "type");
        Intrinsics.checkNotNullParameter(r106, "bizKey");
        return -1;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final h o0(String r100, RequestConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "requestConfig");
        return null;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final String t1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return r100;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final h x(String r100, RequestConfig r101, Function1<? super i, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "requestConfig");
        Intrinsics.checkNotNullParameter(r102, JSEventListener.ACTION_RESOLVE);
        return null;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final d b1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return new d(0);
    }
}
