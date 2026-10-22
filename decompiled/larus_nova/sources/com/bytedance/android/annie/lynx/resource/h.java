package com.bytedance.android.annie.lynx.resource;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.lynx.LynxComponent;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class h implements f76.b<f76.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.annie.service.resource.g f39529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.annie.card.base.c f39530b;

    @Override // f76.b
    public final f76.c j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resUrl");
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == false) goto L15;
        LinkedHashMap r101 = new LinkedHashMap();
        com.bytedance.android.annie.card.base.c r102 = this.f39530b;
        if (r102 == null) goto L7;
        r102.b(r100, AnnieResType.LYNX_CHILD_RESOURCE, IHybridComponent.HybridType.LYNX, r101);
    L7:
        RequestConfig r103 = new RequestConfig(AnnieResType.LYNX_CHILD_RESOURCE);
        r103.f40018c = false;
        r103.f40019d = true;
        r103.f40020e = false;
        r103.a().putAll(r101);
        com.bytedance.android.annie.service.resource.g r104 = this.f39529a;
        if (r104.f40034c == false) goto L10;
        r103.f40023h = r104.f40035d;
    L10:
        String r105 = n.d(r100, r103);
        if (r105 != null) goto L14;
        r105 = n.a(r100);
    L14:
        return new f76.c(UriProtector.parse(r105), r105);
    L15:
        return null;
    }

    public h(com.bytedance.android.annie.service.resource.g r100, LynxComponent.d r101) {
        Intrinsics.checkNotNullParameter(r100, "loaderConfig");
        this.f39529a = r100;
        this.f39530b = r101;
    }
}
