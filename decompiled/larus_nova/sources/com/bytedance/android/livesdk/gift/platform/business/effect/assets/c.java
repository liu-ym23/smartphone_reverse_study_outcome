package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import com.bytedance.android.livesdk.gift.platform.business.effect.delete.CleanOpportunity;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.ss.android.ugc.effectmanager.MobConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f129081a = 0;

    public c() {
    }

    static {
    }

    public static void a(long r100, long r101, String r102, String r103, CleanDataSource r104, CleanOpportunity r105, String r110, int r111) {
        if ((r111 & 16) == 0) goto L6;
        r104 = CleanDataSource.DEFAULT;
    L6:
        if ((r111 & 32) == 0) goto L9;
        r105 = CleanOpportunity.UNKNOWN;
    L9:
        if ((r111 & 64) == 0) goto L11;
        r110 = "";
    L11:
        Intrinsics.checkNotNullParameter(r102, "md5");
        Intrinsics.checkNotNullParameter(r103, "source");
        Intrinsics.checkNotNullParameter(r104, "cleanDataSource");
        Intrinsics.checkNotNullParameter(r105, "cleanOpportunity");
        Intrinsics.checkNotNullParameter(r110, "assetPoolType");
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put(MobConstants.EFFECT_ID, String.valueOf(r100));
        r106.put("live_duration", String.valueOf(r101));
        r106.put("source", r103);
        r106.put("delete_md5", r102);
        r106.put("clean_data_source", String.valueOf(r104.getSource()));
        r106.put("clean_moment", String.valueOf(r105.getValue()));
        r106.put("asset_pool_type", r110);
        mz0.n r107 = new mz0.n();
        Map<String, String> r108 = r107.f516447a;
        Intrinsics.checkNotNullParameter(r108, "map");
        Intrinsics.checkNotNullParameter(r106, "map");
        r108.putAll(r106);
        mz0.m r109 = new mz0.m();
        r109.b(LogCommon.PAGE_SOURCE_LOG);
        r109.b(LogCommon.ROOM);
        List<Object> r112 = r107.f516448b;
        ArrayList r113 = (ArrayList) r112;
        r113.addAll(r109.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r114 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r115 = com.bytedance.android.scope.m.b(r114).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r115);
        ((mz0.i) ((f80.a) r115)).w3("livesdk_rd_gift_resource_delete", r107.f516447a, r107.f516448b);
    }
}
