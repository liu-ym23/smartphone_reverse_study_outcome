package com.bytedance.android.shopping.api.mall.common.tools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class MallRouteManageProxy implements yj.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f170410b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f170411a;

    public static final class a {
    }

    static {
    }

    public MallRouteManageProxy() {
        this.f170411a = LazyKt.lazy(MallRouteManageProxy$routerService$2.INSTANCE);
    }

    public static boolean e(String r100) {
        if (MallServiceUtil.a() != null) goto L5;
        return true;
    L5:
        if (r100 != null) goto L27;
    L21:
        yj.u r101 = MallServiceUtil.a();
        if (r101 != null) goto L24;
        return false;
    L24:
        return r101.a();
    L27:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        String r103 = UriProtector.parse(r100).getHost();     // Catch: Throwable -> L18
        Unit r104 = null;
        List<String> r105 = null;
        if (r103 == null) goto L16;
        yj.u r106 = MallServiceUtil.a();     // Catch: Throwable -> L18
        if (r106 == null) goto L11;
        r105 = r106.c();     // Catch: Throwable -> L18
    L11:
        if (r105 != null) goto L13;
    L15:
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L18
        goto L16
    L13:
        if (r105.contains(r103) == false) goto L15;
        return true;
    L16:
        Object r107 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L18
    L20:
        Result.m9448boximpl(r107);
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    @Override // yj.p
    public final boolean c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (e(r100.toString()) == true) goto L5;
        return false;
    L5:
        return ((yj.p) this.f170411a.getValue()).c(r100);
    }

    @Override // yj.p
    public final void a(final Context r100, final String r101, final Bundle r102) {
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_ANIMATION);
        f(r101, r100, new MallRouteManageProxy$openSchemaWithAnimation$1(this, r100, r101, r102), MallRouteManageProxy$openSchemaWithAnimation$2.INSTANCE);
    }

    @Override // yj.p
    public final boolean b(Context r100, Uri r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (e(String.valueOf(r101)) == true) goto L5;
        return false;
    L5:
        return ((yj.p) this.f170411a.getValue()).b(r100, r101, r102);
    }

    @Override // yj.p
    public final void d(final Context r100, final String r101, final Map<String, Object> r102) {
        f(r101, r100, new MallRouteManageProxy$openSchema$1(this, r100, r101, r102), MallRouteManageProxy$openSchema$2.INSTANCE);
    }

    public static void f(String r100, final Context r101, final Function0 r102, final Function0 r103) {
        if (e(r100) == false) goto L6;
        r102.invoke();
        return;
    L6:
        final yj.u r104 = MallServiceUtil.a();
        if (r104 == null) goto L12;
        h.f170438b.getIHybridHostAppInfo().isDebug();
        if (r101 == null) goto L13;
        r104.b(r101, new MallRouteManageProxy$pluginCheckAndInstall$$inlined$let$lambda$1(r104, r101, r102, r103), new MallRouteManageProxy$pluginCheckAndInstall$$inlined$let$lambda$2(r104, r101, r102, r103));
        return;
    L13:
        return;
    }
}
