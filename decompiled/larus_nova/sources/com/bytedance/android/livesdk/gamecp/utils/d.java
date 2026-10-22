package com.bytedance.android.livesdk.gamecp.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPTrackService;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f125482a = 0;

    public d() {
    }

    static {
    }

    public static final void a(uy5.c r100, List r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if ((!r101.isEmpty()) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L27;
        Iterator r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L28;
        String r103 = (String) r102.next();
        r100.a(r103);     // Catch: Throwable -> L15
        b(GPAccessGeckoResultType.SUCCESS, r103);     // Catch: Throwable -> L15
        ALogger.i("GPGeckoHelper", "succeed to find GameCP gecko Resource, relative path: " + r103);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        b(GPAccessGeckoResultType.FAIL, r103);
        StringBuilder r104 = new StringBuilder("fail to find GameCP gecko Resource, resource, relative path: ");
        r104.append(r103);
        r104.append(", error msg: ");
        String r105 = th.getMessage();
        if (r105 != null) goto L19;
        r105 = "";
    L19:
        r104.append(r105);
        ALogger.e("GPGeckoHelper", r104.toString());
        goto L11
    L28:
        return;
    }

    public static void b(GPAccessGeckoResultType r100, String r101) {
        IHostGameCP r102 = (IHostGameCP) k.f(IHostGameCP.class);
        if (r102 == null) goto L8;
        IGameCPTrackService r103 = r102.getTrackService();
        if (r103 == null) goto L9;
        r103.sendLog("dygame_tech_gecko_access_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("gecko_access_result", r100.getValue()), TuplesKt.to("gecko_resource_path", r101)}));
        return;
    L9:
        return;
    }
}
