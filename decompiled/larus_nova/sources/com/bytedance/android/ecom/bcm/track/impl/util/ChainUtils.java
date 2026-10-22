package com.bytedance.android.ecom.bcm.track.impl.util;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.g;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.btm.api.model.q;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.ecom.bcm.track.impl.setting.Setting;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class ChainUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChainUtils f51156a = null;

    public ChainUtils() {
    }

    static {
        f51156a = new ChainUtils();
    }

    public static String d(l r100) {
        kc.a r101 = a(r100, CollectionsKt.listOf("page_show"), Setting.f51149a.p().b());
        if (r101 == null) goto L10;
        JSONArray r102 = new JSONArray();
        Iterator<T> r103 = r101.f502353a.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        r102.put(((kc.a.C6534a) r103.next()).f502356c);
        goto L6
    L9:
        return r102.toString();
    L10:
        return null;
    }

    public static String e(kc.a r100) {
        if (r100.f502353a.size() != 0) goto L6;
        return "";
    L6:
        StringBuilder r101 = new StringBuilder();
        Iterator<kc.a.C6534a> r102 = r100.f502353a.iterator();
    L8:
        if (r102.hasNext() == false) goto L11;
        r101.append(r102.next().f502356c + ',');
        goto L8
    L11:
        return r101.substring(0, r101.length() - 1);
    }

    public static boolean f(kc.a.C6534a r100) {
        kc.a.C6534a.C6535a r101 = r100.f502360g;
        if (r101 == null) goto L7;
        BcmParams r102 = r101.f502361a;
        if (r102 == null) goto L7;
        JSONObject r103 = r102.toJSONObject();
    L8:
        if (r103 != null) goto L10;
        return false;
    L10:
        if (r103.length() == 0) goto L16;
        return true;
    L16:
        return false;
    L7:
        r103 = null;
        goto L8
    }

    public static boolean g(kc.a.C6534a r100) {
        kc.a.C6534a.C6535a r101 = r100.f502360g;
        if (r101 == null) goto L7;
        BcmParams r102 = r101.f502362b;
        if (r102 == null) goto L7;
        JSONObject r103 = r102.toJSONObject();
    L8:
        if (r103 != null) goto L10;
        return false;
    L10:
        if (r103.length() == 0) goto L16;
        return true;
    L16:
        return false;
    L7:
        r103 = null;
        goto L8
    }

    public static String c(l r100, Function1 r101) {
        if (Setting.f51149a.l().c() == 1) goto L6;
        return null;
    L6:
        if (Setting.f51149a.g() != 1) goto L8;
        List<String> r102 = nc.a.f518601a;
    L9:
        int r103 = Setting.f51149a.l().a();
        if (Setting.f51149a.l().b() != 1) goto L15;
        if ((r100 instanceof q) == false) goto L15;
        kc.a r104 = com.bytedance.android.bcm.api.b.f41761a.getBcmChainByToken(((q) r100).f42070a, r102, r103, true);
    L18:
        if (r104 == null) goto L21;
        if (r101 == null) goto L21;
        Unit r105 = (Unit) r101.invoke(r104);
    L21:
        if (r104 != null) goto L23;
        return null;
    L23:
        return r104.a().toString();
    L15:
        if ((r100 instanceof d) == false) goto L17;
        r104 = com.bytedance.android.bcm.api.b.f41761a.getBcmChainByBtmModel((d) r100, r102, r103, true);
        goto L18
    L17:
        r104 = com.bytedance.android.bcm.api.b.f41761a.getBcmChainByFinder(null, r102, r103, true);
        goto L18
    L8:
        r102 = CollectionsKt.listOf(new String[]{"page_show", "ecom_entrance", "ecom_sec"});
        goto L9
    }

    public static kc.a a(final l r110, List r111, int r112) {
        if (Setting.f51149a.l().b() == 1) goto L10;
        if ((r110 instanceof d) == false) goto L8;
        return com.bytedance.android.bcm.api.b.b(((d) r110).f42023b, r111, r112);
    L8:
        return com.bytedance.android.bcm.api.b.b(null, r111, r112);
    L10:
        if ((r110 instanceof q) == false) goto L13;
        kc.a r100 = com.bytedance.android.bcm.api.b.f41761a.getBcmChainByToken(((q) r110).f42070a, r111, r112, false);
    L16:
        if (r100 != null) goto L19;
        return null;
    L19:
        if (r100.f502353a.isEmpty() == false) goto L21;
        return r100;
    L21:
        kc.a.C6534a r101 = (kc.a.C6534a) ListProtector.get(r100.f502353a, 0);
        if ((r110 instanceof d) == false) goto L83;
        d r102 = (d) r110;
        if (r102.f42022a.length() <= 0) goto L26;
        boolean r103 = true;
    L27:
        if (r103 == false) goto L66;
        int r104 = a.f51158a;
        final String r105 = a.a(r101.f502356c);
        final String r106 = a.a(r102.f42022a);
        if (r105.length() <= 0) goto L31;
        boolean r107 = true;
    L32:
        if (r107 == true) goto L34;
    L41:
        StringBuilder r108 = new StringBuilder();
        r108.append(r105);
        r108.append(".");
        String r113 = r102.f42022a;
        if (r113 != null) goto L44;
    L47:
        boolean r109 = true;
    L48:
        if (r109 == false) goto L51;
    L64:
        String r114 = "c0.d0";
    L65:
        r108.append(r114);
        r101.f502356c = r108.toString();
        goto L66
    L51:
        if (StringsKt.startsWith$default(r113, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, false, 2, null) == false) goto L59;
        List r115 = StringsKt.split$default(r113, new String[]{"."}, false, 0, 6, null);
        if (r115.size() != 3) goto L56;
        r114 = ((String) ListProtector.get(r115, 2)) + ".d0";
        goto L65
    L56:
        if (r115.size() < 4) goto L64;
        r114 = ((String) ListProtector.get(r115, 2)) + "." + ((String) ListProtector.get(r115, 3));
        goto L65
    L59:
        if (StringsKt.startsWith$default(r113, "c", false, 2, null) == false) goto L64;
        List r116 = StringsKt.split$default(r113, new String[]{"."}, false, 0, 6, null);
        if (r116.size() != 1) goto L63;
        r113 = ((String) ListProtector.get(r116, 0)) + ".d0";
    L63:
        r114 = r113;
        goto L65
    L44:
        if (r113.length() == 0) goto L47;
        r109 = false;
        goto L48
    L34:
        if (r106.length() <= 0) goto L36;
        boolean r117 = true;
    L37:
        if (r117 == false) goto L41;
        if ((!Intrinsics.areEqual(r105, r106)) == false) goto L41;
        g.a.a(BtmMonitor.f42161c, SpeechEngineDefines.MESSAGE_TYPE_DIALOG_CHAT_ENDED, null, null, new ChainUtils$getBcmChain$1(r105, r106, r110), 30);
        goto L41
    L36:
        r117 = false;
        goto L37
    L31:
        r107 = false;
    L66:
        BcmParams r118 = r102.f42024c;
        if (r118 == null) goto L83;
        Map<String, Object> r119 = r118.toMap();
        if (r119 == null) goto L83;
        if ((!r119.isEmpty()) != true) goto L83;
        kc.a.C6534a.C6535a r120 = r101.f502360g;
        if (r120 == null) goto L80;
        BcmParams r121 = r120.f502362b;
        if (r121 == null) goto L80;
        Map<String, Object> r122 = r121.toMap();
        if (r122 == null) goto L80;
        if ((!r122.isEmpty()) == true) goto L83;
    L80:
        kc.a.C6534a.C6535a r123 = r101.f502360g;
        if (r123 == null) goto L83;
        r123.f502362b = r102.f42024c;
        goto L83
    L26:
        r103 = false;
    L83:
        return r100;
    L13:
        if ((r110 instanceof d) == false) goto L15;
        r100 = com.bytedance.android.bcm.api.b.b(((d) r110).f42023b, r111, r112);
        goto L16
    L15:
        r100 = com.bytedance.android.bcm.api.b.b(null, r111, r112);
        goto L16
    }

    public static /* synthetic */ kc.a b(ChainUtils r100, l r101, List r102) {
        r100.getClass();
        return a(r101, r102, 20);
    }
}
