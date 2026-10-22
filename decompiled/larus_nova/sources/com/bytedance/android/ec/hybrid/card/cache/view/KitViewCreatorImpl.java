package com.bytedance.android.ec.hybrid.card.cache.view;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.card.bridge.ECBridgeMethodFinder;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCardBridgeInfoRegistry;
import com.bytedance.android.ec.hybrid.card.impl.j;
import com.bytedance.android.ec.hybrid.card.util.ECLynxBuildUtilKt;
import com.bytedance.android.ec.hybrid.monitor.f;
import com.bytedance.lynx.hybrid.IKitInitParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uj.c;
import yj.g;
import zz6.IKitView;

/* JADX INFO: loaded from: classes44.dex */
public final class KitViewCreatorImpl implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f46458a;

    public static final class a {
    }

    static {
    }

    public KitViewCreatorImpl() {
        this.f46458a = LazyKt.lazy(KitViewCreatorImpl$lynxKitService$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.hybrid.card.cache.view.b
    public final com.bytedance.android.ec.hybrid.card.api.a a(com.bytedance.android.ec.hybrid.card.cache.view.a r210) {
        Intrinsics.checkNotNullParameter(r210, "params");
        boolean r100 = f.f47559a;
        f.c("create", -1, r210.f46460b, 0, r210.f46467i);
        if (((t07.a) this.f46458a.getValue()) != null) goto L53;
        return null;
    L53:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L49
        t07.a r102 = (t07.a) this.f46458a.getValue();     // Catch: Throwable -> L49
        if (r102 == null) goto L8;
        r102.c();     // Catch: Throwable -> L49
    L8:
        xj.a r110 = new xj.a();     // Catch: Throwable -> L49
        g r103 = com.bytedance.android.ec.hybrid.a.b();     // Catch: Throwable -> L49
        if (r103 == null) goto L11;
        r103.o();     // Catch: Throwable -> L49
    L11:
        Uri r104 = UriProtector.parse(r210.f46460b);     // Catch: Throwable -> L49
        String r105 = r210.f46467i;     // Catch: Throwable -> L49
        String r106 = r210.f46468j;     // Catch: Throwable -> L49
        if (r105 == null) goto L20;
        if (r106 == null) goto L20;
        c r107 = ECLynxBuildUtilKt.b();     // Catch: Throwable -> L49
        if (r107 == null) goto L20;
        if (r107.a() != true) goto L20;
        r104 = ECLynxBuildUtilKt.c(r104, new uj.b(r106));     // Catch: Throwable -> L49
    L20:
        Uri r108 = r104;
        String r111 = r108.toString();     // Catch: Throwable -> L49
        String r109 = UriProtector.getQueryParameter(r108, "enable_js_runtime");     // Catch: Throwable -> L49
        if (r109 == null) goto L23;
        boolean r211 = Boolean.parseBoolean(r109);     // Catch: Throwable -> L49
    L24:
        String r112 = UriProtector.getQueryParameter(r108, "enable_lynx_strict_mode");     // Catch: Throwable -> L49
        if (r112 == null) goto L27;
        boolean r212 = Boolean.parseBoolean(r112);     // Catch: Throwable -> L49
    L28:
        String r113 = UriProtector.getQueryParameter(r108, "thread_strategy");     // Catch: Throwable -> L49
        if (r113 == null) goto L31;
        int r213 = CastIntegerProtector.parseInt(r113);     // Catch: Throwable -> L49
    L32:
        ECBridgeMethodFinder r114 = new ECBridgeMethodFinder("", null);     // Catch: Throwable -> L49
        Pair<b07.a, com.bytedance.lynx.service.model.a> r115 = b(r210, r108, r212, r213, r110, r114);     // Catch: Throwable -> L49
        b07.a r116 = r115.getFirst();     // Catch: Throwable -> L49
        com.bytedance.lynx.service.model.a r117 = r115.getSecond();     // Catch: Throwable -> L49
        j r118 = new j(null, r210.f46464f);     // Catch: Throwable -> L49
        t07.a r119 = (t07.a) this.f46458a.getValue();     // Catch: Throwable -> L49
        if (r119 == null) goto L35;
        r210.getContext();     // Catch: Throwable -> L49
        IKitView r120 = r119.b();     // Catch: Throwable -> L49
    L36:
        if (r120 == null) goto L46;
        f.c("create", 1, r111, 0, r210.f46467i);     // Catch: Throwable -> L49
        if (r117 == null) goto L45;
        String r121 = r210.f46461c;     // Catch: Throwable -> L49
        if (r121 != null) goto L42;
        String r214 = "";
    L44:
        return new com.bytedance.android.ec.hybrid.card.api.a(r120, r118, r116, r117, r110, null, r114, r211, r212, r213, r214, r111, r210.f46465g, r210.f46468j);
    L42:
        r214 = r121;
        goto L44
    L45:
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L49
    L47:
        Result.m9449constructorimpl(r122);     // Catch: Throwable -> L49
    L51:
        boolean r123 = f.f47559a;
        f.c("create", 0, r210.f46460b, 2, r210.f46467i);
        return null;
    L46:
        r122 = null;
        goto L47
    L35:
        r120 = null;
        goto L36
    L31:
        r213 = 0;
        goto L32
    L27:
        r212 = false;
        goto L28
    L23:
        r211 = true;
    L49:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L51
    }

    public final Pair<b07.a, com.bytedance.lynx.service.model.a> b(com.bytedance.android.ec.hybrid.card.cache.view.a r100, Uri r101, boolean r102, int r103, xj.a r104, ECBridgeMethodFinder r105) {
        t07.a r106 = (t07.a) this.f46458a.getValue();
        if (r106 == null) goto L32;
        com.bytedance.lynx.service.model.a r107 = r106.a();
        if (r107 == null) goto L32;
        r107.o();
        r107.p(r101);
        r107.h();
        com.bytedance.android.ec.hybrid.monitor.g.b(r107);
        CollectionsKt.toMutableList(r100.f46462d);
        r107.f();
        LinkedHashMap r108 = new LinkedHashMap();
        if (r102 == false) goto L10;
        r108.put("setEnableAirStrictMode", CollectionsKt.listOf(Boolean.TRUE));
    L10:
        if (r100.f46463e == false) goto L12;
    L13:
        r108.put("setEnableSyncFlush", CollectionsKt.listOf(Boolean.TRUE));
    L14:
        Boolean r109 = Boolean.TRUE;
        r108.put("setEnablePreUpdateData", CollectionsKt.listOf(r109));
        c r110 = ECLynxBuildUtilKt.b();
        if (r110 == null) goto L21;
        List<String> r111 = r110.c();
        if (r111 == null) goto L21;
        if (r111.contains(r100.f46467i) == false) goto L21;
        r108.put("setEnableVSyncAlignedMessageLoop", CollectionsKt.listOf(r109));
    L21:
        c r112 = ECLynxBuildUtilKt.b();
        if (r112 == null) goto L30;
        if (r112.b() != true) goto L30;
        int r113 = lk.a.f509537a;
        String r114 = r100.f46468j;
        if (r114 != null) goto L28;
        r114 = "";
    L28:
        Intrinsics.checkNotNullParameter(r114, "groupName");
    L30:
        if ((!r108.isEmpty()) == false) goto L33;
        r107.e();
    L33:
        b07.a r115 = new b07.a();
        new ECLynxCardBridgeInfoRegistry(r105);
        r115.setHybridParams((IKitInitParam) r107);
        return new Pair(r115, r107);
    L12:
        if (r103 != 3) goto L14;
    L32:
        r107 = null;
        goto L33
    }
}
