package T2;

import com.stepos.minor.Minor;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import g3.C0742e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    protected static byte[] f5401b;

    /* renamed from: e, reason: collision with root package name */
    protected static String f5404e;

    /* renamed from: a, reason: collision with root package name */
    protected static byte[] f5400a = {0};

    /* renamed from: c, reason: collision with root package name */
    protected static byte[] f5402c = {2};

    /* renamed from: d, reason: collision with root package name */
    protected static byte[] f5403d = {3};

    /* renamed from: f, reason: collision with root package name */
    protected static String f5405f = new String(f5402c);

    /* renamed from: g, reason: collision with root package name */
    protected static String f5406g = new String(f5403d);

    /* renamed from: h, reason: collision with root package name */
    protected static String f5407h = new String("\n");

    static {
        byte[] bArr = {1};
        f5401b = bArr;
        f5404e = new String(bArr);
    }

    protected static int a(boolean z5) {
        return z5 ? 1 : 0;
    }

    public static String b(List<TrackerPayload> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("03");
        sb.append("5");
        Iterator<TrackerPayload> it = list.iterator();
        while (it.hasNext()) {
            sb.append(g(it.next()));
        }
        return sb.toString();
    }

    protected static void c(TrackerPayload trackerPayload, StringBuilder sb) {
        Object obj = trackerPayload.D().get("udid");
        if (obj instanceof String) {
            sb.append(obj);
        }
        sb.append(f5404e);
        Object obj2 = trackerPayload.D().get("oaid");
        if (obj2 instanceof String) {
            sb.append(obj2);
        }
        sb.append(f5404e);
        Object obj3 = trackerPayload.D().get("vaid");
        if (obj3 instanceof String) {
            sb.append(obj3);
        }
        sb.append(f5404e);
        Object obj4 = trackerPayload.D().get("aaid");
        if (obj4 instanceof String) {
            sb.append(obj4);
        }
        sb.append(f5404e);
        Object obj5 = trackerPayload.D().get("rimei");
        if (obj5 instanceof String) {
            sb.append(obj5);
        }
        sb.append(f5404e);
        Object obj6 = trackerPayload.D().get("sn1");
        if (obj6 instanceof String) {
            sb.append(obj6);
        }
        sb.append(f5404e);
        Object obj7 = trackerPayload.D().get("sn2");
        if (obj7 instanceof String) {
            sb.append(obj7);
        }
    }

    protected static void d(TrackerPayload trackerPayload, StringBuilder sb) {
        Object obj = trackerPayload.D().get("pkg_key");
        if (obj instanceof String) {
            sb.append(obj);
        }
        sb.append(f5404e);
        Object obj2 = trackerPayload.D().get("pkg_type");
        if (obj2 instanceof Integer) {
            sb.append(obj2);
        }
        sb.append(f5404e);
        Object obj3 = trackerPayload.D().get("pkg_name");
        if (obj3 instanceof String) {
            sb.append(obj3);
        }
        sb.append(f5404e);
        Object obj4 = trackerPayload.D().get("pkg_ver");
        if (obj4 instanceof String) {
            sb.append(obj4);
        }
        sb.append(f5404e);
        Object obj5 = trackerPayload.D().get("pkg_ver_code");
        if (obj5 instanceof Integer) {
            sb.append(obj5);
        }
        sb.append(f5404e);
        Object obj6 = trackerPayload.D().get("sdk_ver");
        if (obj6 instanceof String) {
            sb.append(obj6);
        }
        sb.append(f5404e);
        Object obj7 = trackerPayload.D().get("channel_id");
        if (obj7 instanceof String) {
            sb.append(obj7);
        }
        sb.append(f5404e);
    }

    protected static void e(TrackerPayload trackerPayload, StringBuilder sb) {
        Object obj = trackerPayload.D().get("brand");
        if (obj instanceof String) {
            sb.append(obj);
        }
        sb.append(f5404e);
        Object obj2 = trackerPayload.D().get("device");
        if (obj2 instanceof String) {
            sb.append(obj2);
        }
        sb.append(f5404e);
        Object obj3 = trackerPayload.D().get("product_model");
        if (obj3 instanceof String) {
            sb.append(obj3);
        }
        sb.append(f5404e);
        Object obj4 = trackerPayload.D().get("os_type");
        if (obj4 instanceof String) {
            sb.append(obj4);
        }
        sb.append(f5404e);
        Object obj5 = trackerPayload.D().get("os_version");
        if (obj5 instanceof String) {
            sb.append(obj5);
        }
        sb.append(f5404e);
        Object obj6 = trackerPayload.D().get("os");
        if (obj6 instanceof String) {
            sb.append(obj6);
        }
        sb.append(f5404e);
        Object obj7 = trackerPayload.D().get("stepos_ver");
        if (obj7 instanceof String) {
            sb.append(obj7);
        }
        sb.append(f5404e);
        Object obj8 = trackerPayload.D().get("build_mask");
        if (obj8 instanceof String) {
            sb.append(obj8);
        }
        sb.append(f5404e);
        Object obj9 = trackerPayload.D().get("umid");
        if (obj9 instanceof String) {
            sb.append(obj9);
        }
        sb.append(f5404e);
        Object obj10 = trackerPayload.D().get("imei");
        if (obj10 instanceof String) {
            sb.append(obj10);
        }
        sb.append(f5404e);
        Object obj11 = trackerPayload.D().get("mac_address");
        if (obj11 instanceof String) {
            sb.append(obj11);
        }
        sb.append(f5404e);
        Object obj12 = trackerPayload.D().get("sn");
        if (obj12 instanceof String) {
            sb.append(obj12);
        }
        sb.append(f5404e);
        Object obj13 = trackerPayload.D().get("andro_id");
        if (obj13 instanceof String) {
            sb.append(obj13);
        }
        sb.append(f5404e);
        Object obj14 = trackerPayload.D().get("android_ad_id");
        if (obj14 instanceof String) {
            sb.append(obj14);
        }
        sb.append(f5404e);
        Object obj15 = trackerPayload.D().get("imsi1");
        if (obj15 instanceof String) {
            sb.append(obj15);
        }
        sb.append(f5404e);
        Object obj16 = trackerPayload.D().get("imsi2");
        if (obj16 instanceof String) {
            sb.append(obj16);
        }
        sb.append(f5404e);
        Object obj17 = trackerPayload.D().get("ter_type");
        if (obj17 instanceof Integer) {
            sb.append(obj17);
        }
        sb.append(f5404e);
        Object obj18 = trackerPayload.D().get("sre");
        if (obj18 instanceof String) {
            sb.append(obj18);
        }
        sb.append(f5404e);
        Object obj19 = trackerPayload.D().get("lla");
        if (obj19 instanceof String) {
            sb.append(obj19);
        }
        sb.append(f5404e);
        Object obj20 = trackerPayload.D().get("root");
        if (obj20 instanceof Boolean) {
            sb.append(a(((Boolean) obj20).booleanValue()));
        }
        sb.append(f5404e);
        Object obj21 = trackerPayload.D().get("stepos_uid");
        if (obj21 instanceof String) {
            sb.append(obj21);
        }
        sb.append(f5404e);
        Object obj22 = trackerPayload.D().get("country");
        if (obj22 instanceof String) {
            sb.append(obj22);
        }
        sb.append(f5404e);
        Object obj23 = trackerPayload.D().get("operator");
        if (obj23 instanceof String) {
            sb.append(obj23);
        }
        sb.append(f5404e);
        Object obj24 = trackerPayload.D().get("international");
        if (obj24 instanceof Boolean) {
            sb.append(a(((Boolean) obj24).booleanValue()));
        }
        sb.append(f5404e);
    }

    protected static void f(TrackerPayload trackerPayload, StringBuilder sb) {
        Object obj = trackerPayload.D().get("source");
        if (obj instanceof String) {
            sb.append(obj);
        }
        sb.append(f5404e);
        Object obj2 = trackerPayload.D().get("sid");
        if (obj2 instanceof String) {
            sb.append(obj2);
        }
        sb.append(f5404e);
        Object obj3 = trackerPayload.D().get("network");
        if (obj3 instanceof String) {
            sb.append(obj3);
        }
        sb.append(f5404e);
        Object obj4 = trackerPayload.D().get("longitude");
        if (obj4 instanceof Double) {
            sb.append(obj4);
        }
        sb.append(f5404e);
        Object obj5 = trackerPayload.D().get("latitude");
        if (obj5 instanceof Double) {
            sb.append(obj5);
        }
        sb.append(f5404e);
        Object obj6 = trackerPayload.D().get("page");
        if (obj6 instanceof String) {
            sb.append(obj6);
        }
        sb.append(f5404e);
        Object obj7 = trackerPayload.D().get("launch");
        if (obj7 instanceof String) {
            sb.append(obj7);
        }
        sb.append(f5404e);
        Object obj8 = trackerPayload.D().get("type");
        if (obj8 instanceof String) {
            sb.append(obj8);
        }
        sb.append(f5404e);
        Object obj9 = trackerPayload.D().get(Minor.COLUMN_NAME);
        if (obj9 instanceof String) {
            sb.append(obj9);
        }
        sb.append(f5404e);
        boolean z5 = true;
        boolean z6 = true;
        for (Map.Entry<String, String> entry : trackerPayload.F().entrySet()) {
            if (z6) {
                z6 = false;
            } else {
                sb.append(f5405f);
            }
            if (entry.getKey() != null) {
                sb.append(entry.getKey());
            }
            sb.append(f5406g);
            if (entry.getValue() != null) {
                sb.append(entry.getValue());
            }
        }
        sb.append(f5404e);
        Object obj10 = trackerPayload.D().get("event_attrib");
        if (obj10 instanceof Map) {
            for (Map.Entry entry2 : ((Map) obj10).entrySet()) {
                if (z5) {
                    z5 = false;
                } else {
                    sb.append(f5405f);
                }
                if (entry2.getKey() != null) {
                    sb.append((String) entry2.getKey());
                }
                sb.append(f5406g);
                if (entry2.getValue() != null) {
                    sb.append((String) entry2.getValue());
                }
            }
        }
        sb.append(f5404e);
        Object obj11 = trackerPayload.D().get("terminate");
        if (obj11 instanceof String) {
            sb.append(obj11);
        }
        sb.append(f5404e);
        Object obj12 = trackerPayload.D().get("time");
        if (obj12 instanceof Long) {
            sb.append(obj12);
        }
        sb.append(f5404e);
        Object obj13 = trackerPayload.D().get("cseq");
        if (obj13 instanceof Long) {
            sb.append(obj13);
        }
        sb.append(f5404e);
        Object obj14 = trackerPayload.D().get("debug");
        if (obj14 instanceof Boolean) {
            sb.append(a(((Boolean) obj14).booleanValue()));
        }
        sb.append(f5404e);
        Object obj15 = trackerPayload.D().get("loc_time");
        if (obj15 instanceof Long) {
            sb.append(obj15);
        }
        sb.append(f5404e);
    }

    protected static String g(TrackerPayload trackerPayload) {
        C0742e.c("TrackerPayload", trackerPayload.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(f5407h);
        sb.append("0");
        e(trackerPayload, sb);
        d(trackerPayload, sb);
        f(trackerPayload, sb);
        c(trackerPayload, sb);
        return sb.toString();
    }
}
