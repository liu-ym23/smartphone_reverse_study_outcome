package b8a;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class m {
    public static l e(ReadableMap r100) {
        HashMap<String, Object> r101 = r100.asHashMap();
        String r102 = (String) r101.get("name");
        String r103 = (String) r101.get("entryType");
        if (r103.equals("pipeline") == false) goto L8;
        if (r102.equals("updateTriggeredByBts") == false) goto L8;
        n r104 = new n(r100.asHashMap());
        r104.f18216c = true;
        return r104;
    L8:
        if (r103.equals("pipeline") == false) goto L13;
        if (r102.equals("updateTriggeredByNative") == false) goto L13;
        n r105 = new n(r100.asHashMap());
        r105.f18216c = true;
        return r105;
    L13:
        if (r103.equals("pipeline") == false) goto L18;
        if (r102.equals("reactLynxHydrate") == false) goto L18;
        n r106 = new n(r100.asHashMap());
        r106.f18216c = true;
        return r106;
    L18:
        if (r103.equals("pipeline") == false) goto L23;
        if (r102.equals("setNativeProps") == false) goto L23;
        n r107 = new n(r100.asHashMap());
        r107.f18216c = true;
        return r107;
    L23:
        if (r103.equals("pipeline") == false) goto L28;
        if (r102.equals("updateGlobalProps") == false) goto L28;
        n r108 = new n(r100.asHashMap());
        r108.f18216c = true;
        return r108;
    L28:
        if (r103.equals("pipeline") == false) goto L33;
        if (r102.equals("loadBundle") == false) goto L33;
        f r109 = new f(r100.asHashMap());
        r109.f18216c = true;
        return r109;
    L33:
        if (r103.equals("init") == false) goto L38;
        if (r102.equals(KtvSubElement.CONTAINER) == false) goto L38;
        b r110 = new b(r100.asHashMap());
        r110.f18216c = true;
        return r110;
    L38:
        if (r103.equals("init") == false) goto L43;
        if (r102.equals(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == false) goto L43;
        c r111 = new c(r100.asHashMap());
        r111.f18216c = true;
        return r111;
    L43:
        if (r103.equals("init") == false) goto L48;
        if (r102.equals("backgroundRuntime") == false) goto L48;
        a r112 = new a(r100.asHashMap());
        r112.f18216c = true;
        return r112;
    L48:
        if (r103.equals("metric") == false) goto L53;
        if (r102.equals("fcp") == false) goto L53;
        j r113 = new j(r100.asHashMap());
        r113.f18216c = true;
        return r113;
    L53:
        if (r103.equals("metric") == false) goto L58;
        if (r102.equals("fsp") == false) goto L58;
        k r114 = new k(r100.asHashMap());
        r114.f18216c = true;
        return r114;
    L58:
        if (r103.equals("metric") == false) goto L63;
        if (r102.equals("actualFmp") == false) goto L63;
        i r115 = new i(r100.asHashMap());
        r115.f18216c = true;
        return r115;
    L63:
        if (r103.equals("pipeline") == false) goto L68;
        if (r102.equals("reloadBundleFromNative") == false) goto L68;
        o r116 = new o(r100.asHashMap());
        r116.f18216c = true;
        return r116;
    L68:
        if (r103.equals("pipeline") == false) goto L73;
        if (r102.equals("reloadBundleFromBts") == false) goto L73;
        o r117 = new o(r100.asHashMap());
        r117.f18216c = true;
        return r117;
    L73:
        if (r103.equals("memory") == false) goto L78;
        if (r102.equals("memory") == false) goto L78;
        g r118 = new g(r100.asHashMap());
        r118.f18216c = true;
        return r118;
    L78:
        if (r103.equals("resource") == false) goto L83;
        if (r102.equals("lazyBundle") == false) goto L83;
        e r119 = new e(r100.asHashMap());
        r119.f18216c = true;
        return r119;
    L83:
        if (r103.equals("jsBlocking") == true) goto L85;
    L87:
        l r120 = new l(r100.asHashMap());
        r120.f18216c = false;
        return r120;
    L85:
        if (r102.equals("jsBlocking") == false) goto L87;
        d r121 = new d(r100.asHashMap());
        r121.f18216c = true;
        return r121;
    }

    public static Long c(HashMap r100, Long r101) {
        Object r102 = r100.get("sizeBytes");
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Long) == false) goto L10;
        return (Long) r102;
    L10:
        if ((r102 instanceof Number) == false) goto L14;
        return Long.valueOf(((Number) r102).longValue());
    L14:
        if ((r102 instanceof String) == false) goto L19;
        return Long.valueOf(CastLongProtector.parseLong((String) r102));
    L17:
        return r101;
    L19:
        if ((r102 instanceof Boolean) == true) goto L21;
        return r101;
    L21:
        return Long.valueOf(((Boolean) r102).booleanValue() ? 1 : 0);
    }

    public static String d(HashMap r100, String r101) {
        Object r102 = r100.get(r101);
        if (r102 != null) goto L7;
        return "";
    L7:
        if ((r102 instanceof String) == false) goto L11;
        return (String) r102;
    L11:
        return String.valueOf(r102);
    }

    public static Boolean a(HashMap<String, Object> r100, String r101, Boolean r102) {
        Object r103 = r100.get(r101);
        if (r103 != null) goto L6;
        return r102;
    L6:
        if ((r103 instanceof Boolean) == false) goto L10;
        return (Boolean) r103;
    L10:
        if ((r103 instanceof Number) == false) goto L18;
        if (((Number) r103).intValue() == 0) goto L14;
        boolean r104 = true;
    L16:
        return Boolean.valueOf(r104);
    L14:
        r104 = false;
        goto L16
    L18:
        if ((r103 instanceof String) == true) goto L20;
        return r102;
    L20:
        return Boolean.valueOf(Boolean.parseBoolean((String) r103));
    }

    public static Double b(HashMap<String, Object> r100, String r101, Double r102) {
        Object r103 = r100.get(r101);
        if (r103 != null) goto L6;
        return r102;
    L6:
        if ((r103 instanceof Double) == false) goto L10;
        return (Double) r103;
    L10:
        if ((r103 instanceof Number) == false) goto L14;
        return Double.valueOf(((Number) r103).doubleValue());
    L14:
        if ((r103 instanceof String) == false) goto L19;
        return Double.valueOf(CastDoubleProtector.parseDouble((String) r103));
    L17:
        return r102;
    L19:
        if ((r103 instanceof Boolean) == true) goto L21;
        return r102;
    L21:
        return Double.valueOf(((Boolean) r103).booleanValue() ? 1.0d : 0.0d);
    }
}
