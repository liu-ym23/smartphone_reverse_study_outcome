package com.bytedance.android.livesdk.gecko;

import android.webkit.WebResourceResponse;
import com.bytedance.android.live.core.setting.i3;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f125818b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveResourcesDistributionImpl f125819a;

    static {
        f125818b = new n();
    }

    public final String b() {
        j r100 = this.f125819a.f125787a;
        if (r100 == null) goto L6;
        String r101 = r100.a();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public n() {
        this.f125819a = new LiveResourcesDistributionImpl();
    }

    public final WebResourceResponse c(String r100) {
        LiveResourcesDistributionImpl r101 = this.f125819a;
        r101.getClass();
        if (i3.f65323a.getValue().booleanValue() == true) goto L16;
        j r102 = r101.f125787a;
        if (r102 == null) goto L11;
        WebResourceResponse r103 = r102.interceptRequest(r100);
        if (r103 == null) goto L11;
        return r103;
    L11:
        Function1<? super String, ? extends WebResourceResponse> r104 = r101.f125788b;
        if (r104 != null) goto L18;
        return null;
    L18:
        return r104.invoke(r100);
    L16:
        return i.a(r100);
    }

    public final InputStream a(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "relativePath");
        Intrinsics.checkNotNullParameter(r110, "channel");
        LiveResourcesDistributionImpl r101 = this.f125819a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "relativePath");
        Intrinsics.checkNotNullParameter(r110, "channel");
        if (LiveResourcesDistributionImpl.f125786d == true) goto L10;
        LinkedHashMap r102 = new LinkedHashMap();
        List r103 = (List) r101.f125789c.getValue();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        String r106 = (String) r105.next();
        r102.put(r106, CollectionsKt.listOf(new String[]{"prefetch." + r106 + InvRouter.FLOW_SUFFIX, "protobuf/definitions_v2.json", "protobuf/definitions.json", "protobuf/shrink_config.json", "latch.json"}));
        r104.add(Unit.INSTANCE);
        goto L6
    L8:
        com.bytedance.geckox.b r107 = com.bytedance.geckox.b.a.f245076a;
        ((ConcurrentHashMap) com.bytedance.iesgurd.core.f.f250660a).put(LiveGeckoConfig.b(), r102);
        LiveResourcesDistributionImpl.f125786d = true;
    L10:
        return ResLoadUtils.getPrefetchDataForPath(new PolarisFileWrapper(LiveGeckoConfig.c()), LiveGeckoConfig.b(), r110, r100);
    }
}
