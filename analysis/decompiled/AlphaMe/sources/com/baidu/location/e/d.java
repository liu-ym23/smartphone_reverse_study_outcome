package com.baidu.location.e;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f5839a = "loc.map.baidu.com";

    /* renamed from: b, reason: collision with root package name */
    public static String f5840b = "https://blg.map.baidu.com/map_loc_debug/debug_url.json";

    /* renamed from: c, reason: collision with root package name */
    public static String f5841c = "https://loc.map.baidu.com/sdk_ep.php";

    /* renamed from: d, reason: collision with root package name */
    public static String f5842d = "https://loc.map.baidu.com/tcu.php";

    /* renamed from: e, reason: collision with root package name */
    public static String f5843e = "https://loc.map.baidu.com/sdk.php";

    /* renamed from: f, reason: collision with root package name */
    public static String f5844f = "https://loc.map.baidu.com/cfgs/loc/commcfgs";

    /* renamed from: g, reason: collision with root package name */
    public static String f5845g = "https://client.map.baidu.com/phpui2/?";

    /* renamed from: h, reason: collision with root package name */
    public static String f5846h = "https://loc.map.baidu.com/cfgs/indoorloc/indoorroadnet";

    /* renamed from: i, reason: collision with root package name */
    public static String f5847i = "https://aispace.baidu.com/cfgs/indoorloc/indoorbldgrects";

    /* renamed from: j, reason: collision with root package name */
    public static String f5848j = "https://parking.baidu.com/parking/api/parkingdata/getcarportlistforlocation?";

    /* renamed from: k, reason: collision with root package name */
    public static String f5849k = "https://daup.map.baidu.com/cltr/rcvr";

    /* renamed from: l, reason: collision with root package name */
    public static String f5850l = "https://loc.map.baidu.com/vdr_yawcheck";

    /* renamed from: m, reason: collision with root package name */
    public static String f5851m = "https://ofloc.map.baidu.com/locnd";

    /* renamed from: n, reason: collision with root package name */
    public static String f5852n = "https://ofloc.map.baidu.com/locnu";

    /* renamed from: o, reason: collision with root package name */
    public static String f5853o = "https://aispace.baidu.com/aispacelbs/receiver/recordlog";

    /* renamed from: p, reason: collision with root package name */
    public static String f5854p = "https://ofloc.map.baidu.com/LocBrokerService/do_loc_map_match";

    /* renamed from: q, reason: collision with root package name */
    public static String f5855q = "https://ofloc.map.baidu.com/PlanarStartService/detect_parking_exits";

    /* renamed from: r, reason: collision with root package name */
    public static String f5856r = "https://loc.map.baidu.com/gpsz";

    /* renamed from: s, reason: collision with root package name */
    public static String f5857s = "https://loc.map.baidu.com/indoorlocbuildinginfo.php";

    /* renamed from: t, reason: collision with root package name */
    public static String f5858t = "https://loc.map.baidu.com/cc.php";

    public static void a() throws IllegalAccessException, IllegalArgumentException {
        for (Field field : d.class.getDeclaredFields()) {
            if (field.getType().equals(String.class) && Modifier.isStatic(field.getModifiers())) {
                try {
                    field.set(null, field.get(null).toString().replace("//" + f5839a, "//cnloc.map.baidu.com"));
                } catch (Exception unused) {
                }
            }
        }
    }
}
