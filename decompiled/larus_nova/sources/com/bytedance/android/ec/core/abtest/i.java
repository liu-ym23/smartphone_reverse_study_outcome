package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    public static void a(JSONObject r100, long r101, long r110) {
        JSONObject r102 = r100.optJSONObject("data");
        long r103 = 43200;
        if (r102 == null) goto L5;
        r103 = r102.optLong("valid_time", 43200);
    L5:
        yj.g r104 = null;
        if (r110 > ((r103 * ((long) 1000)) + r101)) goto L59;
        if (r102 == null) goto L9;
        Integer r105 = Integer.valueOf(r102.optInt("settings_type"));
    L10:
        if (r102 == null) goto L12;
        JSONObject r106 = r102.optJSONObject(OnekeyLoginConstants.CU_KEY_TOKEN_EXPIRES);
    L13:
        if (r105 == null) goto L53;
        if (r106 == null) goto L53;
        if (r106.length() == 0) goto L53;
        if (r105.intValue() != 1) goto L30;
        Iterator<String> r107 = r106.keys();
        LinkedHashMap r108 = new LinkedHashMap();
    L22:
        if (r107.hasNext() == false) goto L27;
        String r111 = r107.next();
        if (r111 == null) goto L22;
        Object r109 = r106.opt(r111);
        SDKSettingsCacheManager.f42812e.getClass();
        Intrinsics.checkNotNullParameter(r111, "key");
        SDKSettingsCacheManager.f42808a.remove(r111);
        SDKSettingsCacheManager.f42809b.put(r111, r109);
        dm.a.a("EcByteSync").a("sdkExpDisasterRecovery:" + r111 + ", " + r109 + ", " + r109.getClass());
        r108.put(r111, r109);
        goto L22
    L27:
        int r112 = com.bytedance.android.ec.core.abtest.a.f43636a;
        Intrinsics.checkNotNullParameter(r108, "map");
        return;
    L30:
        if (r105.intValue() != 2) goto L52;
        IHybridHostService r113 = com.bytedance.android.ec.hybrid.a.h();
        if (r113 == null) goto L34;
        r104 = r113.getHostAB();
    L34:
        Iterator<String> r114 = r106.keys();
        LinkedHashMap r115 = new LinkedHashMap();
    L36:
        if (r114.hasNext() == false) goto L47;
        String r116 = r114.next();
        if (r116 == null) goto L36;
        Object r117 = r106.opt(r116);
        if (r117 == null) goto L36;
        r115.put(r116, r117);
        ConcurrentHashMap<String, Object> r118 = com.bytedance.android.ec.base.settings.d.f42816a;
        Intrinsics.checkNotNullParameter(r116, "key");
        Intrinsics.checkNotNullParameter(r117, "value");
        com.bytedance.android.ec.base.settings.d.f42816a.remove(r116);
        com.bytedance.android.ec.base.settings.d.f42818c.put(r116, r117);
        if (r104 == null) goto L46;
        r104.d(r116, r117);
    L46:
        dm.a.a("EcByteSync").a("hostExpDisasterRecovery:" + r116 + ", " + r117 + ", " + r117.getClass());
        goto L36
    L47:
        if (r104 == null) goto L50;
        return;
    L50:
        throw new Exception("business don't have experiment feature");
    L52:
        throw new Exception("invalid setting_type " + r105);
    L53:
        dm.a.a("EcByteSync").b("settingsType or experiments is null " + r105, null);
        if (r105 != null) goto L58;
        throw new Exception("settings_type is null");
    L58:
        throw new Exception("exp is null");
    L12:
        r106 = null;
        goto L13
    L9:
        r105 = null;
        goto L10
    L59:
        dm.a.a("EcByteSync").b("initTime: " + r110 + ", msg publishTime:" + r101, null);
        throw new Exception("initTime > publishTime");
    }
}
