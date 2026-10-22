package com.bytedance.android.live.core.setting;

import com.bytedance.android.live.core.log.ALogger;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class g7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, JSONObject> f65309a = null;

    static {
        f65309a = new LinkedHashMap();
    }

    public static Object a(String r100, Type r101, Object r102) {
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r101 != Boolean.TYPE) goto L13;
        if (r102 == null) goto L11;
        boolean r103 = ((Boolean) r102).booleanValue();
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r100, "name");
        JSONObject r104 = (JSONObject) ((LinkedHashMap) f65309a).get(SettingUtil.KEY_TT_APP_SETTING);
        if (r104 == null) goto L86;
        r103 = r104.optBoolean(r100, r103);
    L86:
        return Boolean.valueOf(r103);
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L13:
        if (r101 != Integer.TYPE) goto L15;
    L75:
        if (r102 == null) goto L83;
        int r105 = ((Integer) r102).intValue();
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r100, "name");
        JSONObject r106 = (JSONObject) ((LinkedHashMap) f65309a).get(SettingUtil.KEY_TT_APP_SETTING);
        if (r106 == null) goto L81;
        r105 = r106.optInt(r100, r105);
    L81:
        return Integer.valueOf(r105);
    L83:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L15:
        if (r101 == Short.TYPE) goto L75;
        if (r101 != Float.TYPE) goto L27;
        if (r102 == null) goto L25;
        float r107 = ((Float) r102).floatValue();
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r100, "name");
        JSONObject r108 = (JSONObject) ((LinkedHashMap) f65309a).get(SettingUtil.KEY_TT_APP_SETTING);
        if (r108 == null) goto L87;
        r107 = (float) r108.optDouble(r100, r107);
    L87:
        return Float.valueOf(r107);
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L27:
        if (r101 != Long.TYPE) goto L37;
        if (r102 == null) goto L35;
        long r109 = ((Long) r102).longValue();
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r100, "name");
        JSONObject r110 = (JSONObject) ((LinkedHashMap) f65309a).get(SettingUtil.KEY_TT_APP_SETTING);
        if (r110 == null) goto L88;
        r109 = r110.optLong(r100, r109);
    L88:
        return Long.valueOf(r109);
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L37:
        if (r101 != Double.TYPE) goto L47;
        if (r102 == null) goto L45;
        double r111 = ((Double) r102).doubleValue();
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r100, "name");
        JSONObject r112 = (JSONObject) ((LinkedHashMap) f65309a).get(SettingUtil.KEY_TT_APP_SETTING);
        if (r112 == null) goto L89;
        r111 = r112.optDouble(r100, r111);
    L89:
        return Double.valueOf(r111);
    L45:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L47:
        if (r101 != String.class) goto L55;
        if (r102 == null) goto L54;
        String r113 = (String) r102;
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r113, "defaultValue");
        JSONObject r114 = (JSONObject) ((LinkedHashMap) f65309a).get(SettingUtil.KEY_TT_APP_SETTING);
        Object r115 = r113;
        if (r114 == null) goto L91;
        return r114.optString(r100, r113);
    L91:
        return r115;
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L55:
        if (r102 == null) goto L74;
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        LinkedHashMap r116 = (LinkedHashMap) f65309a;
        r115 = r102;
        if (((JSONObject) r116.get(SettingUtil.KEY_TT_APP_SETTING)) == null) goto L91;
        String r117 = "";
        if (r116.get(SettingUtil.KEY_TT_APP_SETTING) == null) goto L84;
        Object r118 = r116.get(SettingUtil.KEY_TT_APP_SETTING);
        Intrinsics.checkNotNull(r118);
        r117 = ((JSONObject) r118).optString(r100, "");
    L84:
        Object r119 = SettingUtil.getGson().fromJson(r117, r101);     // Catch: Exception -> L67
        r115 = r102;
        if (r119 == null) goto L91;
        r115 = r119;
    L67:
        e = move-exception;
        if (SettingUtil.isLocalTest() == true) goto L72;
        ALogger.e("TTHostSettingCache", "getObj error:key:TT_APP_SETTING, name:" + r100 + ",type:" + r101 + ", \n error:" + e);
        r115 = r102;
        goto L91
    L72:
        throw e;
    L74:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }
}
