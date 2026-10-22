package com.android.ttcjpaysdk.kmp.base.route;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ$\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\t¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/route/CJRouter;", "", "<init>", "()V", "releaseById", "", "id", "", "useAnimation", "", "openH5Page", "url", "params", "", "removeAllPageAbove", "pageId", "include", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJRouter {
    public static final int $stable = 0;
    public static final CJRouter INSTANCE = null;

    static {
        INSTANCE = new CJRouter();
    }

    private CJRouter() {
    }

    public final void openH5Page(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        b r102 = c.f528682a;
        IKmpCJRouteService r103 = (IKmpCJRouteService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJRouteService.class));
        if (r103 == null) goto L6;
        r103.openH5Page(r100, r101);
        return;
    }

    public final void releaseById(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        b r102 = c.f528682a;
        IKmpCJRouteService r103 = (IKmpCJRouteService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJRouteService.class));
        if (r103 == null) goto L6;
        r103.releaseById(r100, r101);
        return;
    }

    public final void removeAllPageAbove(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "pageId");
        b r102 = c.f528682a;
        IKmpCJRouteService r103 = (IKmpCJRouteService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJRouteService.class));
        if (r103 == null) goto L6;
        r103.removeAllPageAbove(r100, r101);
        return;
    }

    public static /* synthetic */ void removeAllPageAbove$default(CJRouter r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.removeAllPageAbove(r101, r102);
    }
}
