package com.bytedance.android.annie.business.lynx;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxEnv;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/business/lynx/AnnieXLivePropsProvider;", "Lcom/bytedance/android/anniex/ability/service/IAnnieXBizPropsProvider;", "<init>", "()V", "annie-mix-glue_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXLivePropsProvider extends IAnnieXBizPropsProvider {
    public AnnieXLivePropsProvider() {
    }

    @Override // com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider
    public final Map<String, Object> b(KitType r110, String r111, Uri r112) {
        Intrinsics.checkNotNullParameter(r110, "kitType");
        Intrinsics.checkNotNullParameter(r111, "bid");
        Intrinsics.checkNotNullParameter(r112, "uri");
        Object r100 = null;
        if (Intrinsics.areEqual(r111, "webcast") == false) goto L28;
        LinkedHashMap r101 = new LinkedHashMap();
        if (r110 != KitType.LYNX) goto L7;
        r101.put("lynxVersion", LynxEnv.inst().getLynxVersion());
        r101.put("lynx_version", LynxEnv.inst().getLynxVersion());
    L7:
        i7.a r113 = i7.a.f488450a;
        Application r102 = h.f246501h.f246503b;
        String r103 = r112.toString();
        boolean r114 = true;
        boolean r104 = !o7.e.a();
        String r105 = UriProtector.getQueryParameter(r112, "url");
        if (r105 != null) goto L10;
        r105 = r112.toString();
    L10:
        Boolean r106 = Boolean.TRUE;
        r113.getClass();
        i7.a.a(r101, r111, r102, r103, r104, r105, r111, r106);
        String r115 = com.bytedance.ies.bullet.service.router.d.a(r112, "flow_page_cache_param");
        if (com.bytedance.ies.bullet.service.base.h.l0() == false) goto L27;
        if (r115 != null) goto L14;
    L17:
        if (r114 == true) goto L27;
        Object r116 = r101.get("initialBusinessProps");
        if ((r116 instanceof Map) == false) goto L21;
        Map r117 = (Map) r116;
    L23:
        if (r117 == null) goto L25;
        r100 = r117.get("bcm_chain");
    L25:
        if (r100 == null) goto L27;
        r101.put("bcm_chain", r100);
        goto L27
    L21:
        r117 = null;
        goto L23
    L14:
        if (r115.length() == 0) goto L17;
        r114 = false;
    L27:
        return r101;
    L28:
        return null;
    }

    @Override // com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider
    public final Map<String, Object> c(String r100, KitType r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "kitType");
        if (Intrinsics.areEqual(r100, "webcast") == true) goto L5;
        return null;
    L5:
        return ((i9.c) Annie.getService$default(i9.c.class, null, 2, null)).H1(r102);
    }

    @Override // com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider
    public final void a(Map<String, Object> r100, KitType r101, String r102, Uri r103) {
        Intrinsics.checkNotNullParameter(r100, "originProps");
        Intrinsics.checkNotNullParameter(r101, "kitType");
        Intrinsics.checkNotNullParameter(r102, "bid");
        Intrinsics.checkNotNullParameter(r103, "uri");
        if (Intrinsics.areEqual(r102, "webcast") == true) goto L5;
        return;
    L5:
        if (r101 != KitType.LYNX) goto L7;
        r100.put("lynxVersion", LynxEnv.inst().getLynxVersion());
        r100.put("lynx_version", LynxEnv.inst().getLynxVersion());
    L7:
        r100.put("os", "Android");
        LinkedHashMap r104 = (LinkedHashMap) r100;
        Object r105 = r104.get("appVersion");
        if (r105 == null) goto L10;
        r100.put("version_name", r105);
    L10:
        Object r106 = r104.get("deviceId");
        if (r106 == null) goto L13;
        r100.put("device_id", r106);
        r100.put("deviceID", r106);
    L13:
        Object r107 = r104.get("deviceScore");
        if (r107 == null) goto L16;
        r100.put("device_score", r107.toString());
    L16:
        ((IUserInfoService) Annie.getService$default(IUserInfoService.class, null, 2, null)).getUserId();
        r100.put("user_id", "");
        r100.put("container_name", ILiveHybridMonitor.ContainerType.ANNIE);
        r100.put(TTVideoEngineInterface.PLAY_API_KEY_AC, NetworkUtils.getNetworkAccessType(h.f246501h.f246503b));
        r100.put("device_platform", "android");
        r100.put("devicePlatform", "mobile");
        Map<String, Object> r108 = ((i9.c) Annie.getService$default(i9.c.class, null, 2, null)).I1();
        if (r108 == null) goto L21;
        r100.putAll(r108);
        return;
    }
}
