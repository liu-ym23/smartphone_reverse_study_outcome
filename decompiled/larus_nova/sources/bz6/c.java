package bz6;

import android.content.Intent;
import android.os.Bundle;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.common.utils.d;
import com.bytedance.locallife.dito.data.k;
import com.bytedance.locallife.poi.dito.container.api.DitoPoiApi;
import com.bytedance.locallife.poi.poidetail.container.ability.common.h;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import com.ss.android.ugc.aweme.prefetch.newsdk.PrefetchType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21879a = 0;

    static {
    }

    public static String a(String r100, Intent r101, PoiBundle r102, String r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r110, "poiEnterId");
        String r103 = "";
        if (r101 != null) goto L6;
        return "";
    L6:
        if (r101.getExtras() != null) goto L8;
        return "";
    L8:
        qt6.b r104 = HostServiceUtilsKt.S();
        com.bytedance.locallife.poi.dito.mob.a r105 = com.bytedance.locallife.poi.dito.mob.a.f262418a;
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        com.bytedance.locallife.poi.dito.mob.a.f262421d.set(r100);
        if (r102 == null) goto L12;
        r102.sessionId = r110;
    L12:
        h r112 = vy6.a.a(r101.getStringExtra(UniContext.KEY_OF_BIZ_CODE)).c();
        Unit r106 = null;
        if (r102 == null) goto L15;
        String r107 = r102.bizCode;
    L16:
        if (r102 == null) goto L18;
        Map<String, String> r108 = r102.requestHeaderParamsMap;
    L19:
        DitoPoiApi r109 = r112.a(r100, r104.f(r107, r108));
        LinkedHashMap r113 = new LinkedHashMap();
        String r114 = r101.getStringExtra("request_params");
        if (r114 != null) goto L22;
        r114 = "";
    L22:
        if (r102 == null) goto L24;
        String r115 = r102.requestParams;
    L25:
        if (r115 != null) goto L27;
        r115 = "";
    L27:
        String r116 = r101.getStringExtra("ditom_extra_biz_params");
        if (r116 == null) goto L74;
        r103 = r116;
    L74:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L51
        Object r118 = d.a(r114, Map.class);     // Catch: Throwable -> L51
        if ((r118 instanceof Map) == false) goto L34;
        Map<? extends String, ? extends Object> r119 = (Map) r118;     // Catch: Throwable -> L51
    L35:
        if (r119 == null) goto L37;
        r113.putAll(r119);     // Catch: Throwable -> L51
    L37:
        Object r120 = d.a(r103, Map.class);     // Catch: Throwable -> L51
        if ((r120 instanceof Map) == false) goto L40;
        Map<? extends String, ? extends Object> r121 = (Map) r120;     // Catch: Throwable -> L51
    L41:
        if (r121 == null) goto L43;
        r113.putAll(r121);     // Catch: Throwable -> L51
    L43:
        Object r122 = d.a(r115, Map.class);     // Catch: Throwable -> L51
        if ((r122 instanceof Map) == false) goto L46;
        Map<? extends String, ? extends Object> r123 = (Map) r122;     // Catch: Throwable -> L51
    L47:
        if (r123 == null) goto L49;
        r113.putAll(r123);     // Catch: Throwable -> L51
        r106 = Unit.INSTANCE;     // Catch: Throwable -> L51
    L49:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L51
    L53:
        k r124 = (k) r104.n(r101.getExtras());
        if (r124 != null) goto L72;
        r124 = (k) r104.c(r111, r112.b(r102, "0", "0", r113));
    L72:
        r109.a(r124, PrefetchType.INTERCEPTOR_PREFETCH);     // Catch: Throwable -> L58
        Object r125 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L58
    L60:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r125);
        if (r126 == null) goto L64;
        HostServiceUtilsKt.c().a(r126);
    L64:
        String r127 = r104.i(r111);
        if (r127 != null) goto L76;
        StringBuilder r128 = new StringBuilder();
        r128.append(System.currentTimeMillis());
        if (r124 == null) goto L69;
        int r129 = r124.hashCode();
    L70:
        r128.append(r129);
        return r128.toString();
    L69:
        r129 = 0;
        goto L70
    L76:
        return r127;
    L58:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L60
    L46:
        r123 = null;
        goto L47
    L40:
        r121 = null;
        goto L41
    L34:
        r119 = null;
    L51:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L53
    L24:
        r115 = null;
        goto L25
    L18:
        r108 = null;
        goto L19
    L15:
        r107 = null;
        goto L16
    }
}
