package com.bytedance.android.annie.service.prefetch;

import android.content.Context;
import com.bytedance.android.annie.Annie;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class AbsAnnieGeckoResLoader implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f39928b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f39929a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.annie.service.prefetch.n
    public abstract /* synthetic */ Context getContext();

    public AbsAnnieGeckoResLoader() {
        this.f39929a = LazyKt.lazy(new AbsAnnieGeckoResLoader$resourceLoader$2(this));
    }

    @Override // com.bytedance.android.annie.service.prefetch.n
    public final InputStream a(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "relativePath");
        Intrinsics.checkNotNullParameter(r111, "channel");
        PolarisFileWrapper r100 = null;
        if (f39928b == true) goto L17;
        b r101 = (b) this;
        String r102 = r101.f39944d;
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L17;
        LinkedHashMap r104 = new LinkedHashMap();
        List<String> r105 = ((com.bytedance.android.annie.service.resource.f) Annie.getService$default(com.bytedance.android.annie.service.resource.f.class, null, 2, null)).r();
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        String r108 = (String) r107.next();
        r104.put(r108, CollectionsKt.listOf(new String[]{"prefetch." + r108 + InvRouter.FLOW_SUFFIX, "protobuf/definitions_v2.json", "protobuf/definitions.json", "protobuf/shrink_config.json", "latch.json"}));
        r106.add(Unit.INSTANCE);
        goto L14
    L16:
        com.bytedance.geckox.b r109 = com.bytedance.geckox.b.a.f245076a;
        ((ConcurrentHashMap) com.bytedance.iesgurd.core.f.f250660a).put(r101.f39944d, r104);
        f39928b = true;
        goto L17
    L7:
        if (r102.length() == 0) goto L10;
        r103 = false;
    L17:
        b r112 = (b) this;
        String r113 = r112.f39945e;
        if (r113 == null) goto L21;
        r100 = new PolarisFileWrapper(r113);
    L21:
        return ResLoadUtils.getPrefetchDataForPath(r100, r112.f39944d, r111, r110);
    }
}
