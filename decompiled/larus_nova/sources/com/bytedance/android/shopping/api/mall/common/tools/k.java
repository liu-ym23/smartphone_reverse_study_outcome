package com.bytedance.android.shopping.api.mall.common.tools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements yj.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f170443b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MallRouteManageProxy f170444a;

    @Override // yj.p
    public final void a(Context r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_ANIMATION);
        this.f170444a.a(r100, r101, r102);
    }

    @Override // yj.p
    public final boolean b(Context r100, Uri r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return this.f170444a.b(r100, r101, r102);
    }

    @Override // yj.p
    public final boolean c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return this.f170444a.c(r100);
    }

    @Override // yj.p
    public final void d(Context r100, String r101, Map<String, Object> r102) {
        this.f170444a.d(r100, r101, r102);
    }

    static {
        f170443b = new k();
    }

    public k() {
        this.f170444a = new MallRouteManageProxy();
    }
}
