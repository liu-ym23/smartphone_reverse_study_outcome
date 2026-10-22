package b06;

import android.app.Application;
import android.content.Context;
import androidx.collection.ArrayMap;
import com.bytedance.helios.api.config.RuleInfo;
import com.bytedance.helios.sdk.HeliosEnvImpl;
import e06.d;
import e06.e;
import gz5.f;
import gz5.l;
import gz5.x;
import gz5.y;
import hz5.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jz5.h;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vz5.b;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements b, gz5.a.InterfaceC6085a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, RuleInfo> f16883a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f16884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Application f16885c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f16886d = null;

    public a() {
    }

    static {
        f16886d = new a();
        f16883a = new ConcurrentHashMap();
        f16884b = "";
        f16885c = HeliosEnvImpl.get().f245468k;
    }

    public static void c() {
        Application r100 = f16885c;
        if (r100 == null) goto L32;
        Context r101 = r100.getBaseContext();
        if (r101 != null) goto L7;
        return;
    L7:
        if (e.b(r101) == false) goto L34;
        StringBuilder r102 = new StringBuilder();
        Iterator<Map.Entry<String, RuleInfo>> r103 = f16883a.entrySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<String, RuleInfo> r104 = r103.next();
        if ((!r104.getValue().a().isEmpty()) == true) goto L15;
        if ((true ^ r104.getValue().d().isEmpty()) == false) goto L10;
    L15:
        r102.append(r104.getKey());
        r102.append(",");
        goto L10
    L17:
        if (r102.length() <= 0) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L22;
        r102.deleteCharAt(r102.length() - 1);
    L22:
        h r106 = d.f470643a;
        String r107 = r102.toString();
        h r108 = d.f470643a;
        if (r108 == null) goto L35;
        r108.putString("sky_eye_rule_update", r107);
        return;
    L35:
        return;
    L19:
        r105 = false;
        goto L20
    L34:
        return;
    }

    @Override // gz5.a.InterfaceC6085a
    public final void onNewSettings(y r100) {
        Iterator<Map.Entry<String, RuleInfo>> r101 = f16883a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, RuleInfo> r102 = r101.next();
        f16886d.b(r102.getKey(), true);
        goto L4
    }

    @Override // vz5.b
    public void update(RuleInfo r100) {
        f16883a.put(r100.b(), r100);
        c();
        b(r100.b(), true);
        k.d("Helios-Common-Env", "RulesManager.update name=" + r100.b() + " apiIds=" + r100.a() + " resourceIds=" + r100.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(String r210, boolean r211) {
        ArrayMap r100 = HeliosEnvImpl.get().f245473p;
        if (r100 == null) goto L118;
        if (r211 == true) goto L6;
        return;
    L6:
        if (r100.containsKey(r210) == false) goto L120;
        RuleInfo r101 = f16883a.get(r210);
        CopyOnWriteArrayList<f> r102 = HeliosEnvImpl.get().f245470m.f().a();
        boolean r103 = false;
        if ((r102 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r104 = r102.iterator();
    L14:
        if (r104.hasNext() == false) goto L46;
        f r105 = (f) r104.next();
        List<l> r106 = r105.c();
        if ((r106 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L26;
        if (StringsKt.contains$default(((l) r107.next()).a(), r210, false, 2, null) == false) goto L22;
        boolean r108 = true;
    L27:
        if (r108 == true) goto L43;
        List<l> r109 = r105.b();
        if ((r109 instanceof Collection) == true) goto L31;
    L33:
        Iterator<T> r110 = r109.iterator();
    L35:
        if (r110.hasNext() == false) goto L39;
        if (StringsKt.contains$default(((l) r110.next()).a(), r210, false, 2, null) == false) goto L35;
        boolean r111 = true;
    L40:
        if (r111 == true) goto L43;
        boolean r112 = false;
    L44:
        if (r112 == false) goto L14;
        boolean r113 = true;
    L47:
        if (r113 == true) goto L121;
        if (r101 == null) goto L50;
        List<Integer> r114 = r101.a();
    L51:
        List<Integer> r115 = r114;
        if (r115 != null) goto L54;
    L57:
        boolean r116 = true;
    L58:
        if (r116 == false) goto L68;
        if (r101 == null) goto L61;
        List<String> r117 = r101.d();
    L62:
        List<String> r118 = r117;
        if (r118 != null) goto L65;
    L66:
        r103 = true;
    L67:
        if (r103 == false) goto L68;
        return;
    L65:
        if (r118.isEmpty() == false) goto L67;
    L61:
        r117 = null;
    L68:
        ArrayMap r119 = HeliosEnvImpl.get().f245472o;
        if (r119 == null) goto L71;
        x r120 = (x) r119.get(r210);
    L73:
        if (r120 != null) goto L75;
        if (r101 == null) goto L97;
        List<Integer> r121 = r101.a();
        if (r121 == null) goto L97;
    L98:
        List<Integer> r122 = r121;
        if (r101 == null) goto L103;
        List<String> r123 = r101.d();
        if (r123 == null) goto L103;
    L104:
        r102.add(new f(r122, r123, null, CollectionsKt.listOf(new l("$" + r210, null, null, 59)), 28));
        return;
    L103:
        r123 = CollectionsKt.emptyList();
    L97:
        r121 = CollectionsKt.emptyList();
        goto L98
    L75:
        if ((true ^ r120.f483410e.isEmpty()) == false) goto L80;
        Iterator<T> r124 = r120.f483410e.iterator();
    L78:
        if (r124.hasNext() == false) goto L124;
        f r125 = (f) r124.next();
        r102.add(new f(r125.a(), r125.d(), null, null, 60));
        goto L78
    L124:
        return;
    L80:
        List<Integer> r126 = r120.f483407b;
        if (r101 == null) goto L85;
        List<String> r127 = r101.d();
        if (r127 == null) goto L85;
    L86:
        r102.add(new f(r126, r127, null, CollectionsKt.listOf(new l("$" + r210, null, null, 59)), 28));
        List<Integer> r128 = r120.f483409d;
        if (r101 == null) goto L91;
        List<String> r129 = r101.d();
        if (r129 == null) goto L91;
    L92:
        r102.add(new f(r128, r129, CollectionsKt.listOf(new l("$" + r210, null, null, 59)), null, 44));
        return;
    L91:
        r129 = CollectionsKt.emptyList();
    L85:
        r127 = CollectionsKt.emptyList();
        goto L86
    L71:
        r120 = null;
        goto L73
    L54:
        if (r115.isEmpty() == true) goto L57;
        r116 = false;
        goto L58
    L50:
        r114 = null;
        goto L51
    L121:
        return;
    L39:
        r111 = false;
        goto L40
    L31:
        if (r109.isEmpty() == false) goto L33;
    L43:
        r112 = true;
    L26:
        r108 = false;
        goto L27
    L18:
        if (r106.isEmpty() == false) goto L20;
    L46:
        r113 = false;
        goto L47
    L10:
        if (r102.isEmpty() == false) goto L12;
    L120:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vz5.b
    public void update(String r100, boolean r101) {
        if (r101 == false) goto L18;
        Iterator<T> r102 = HeliosEnvImpl.get().f245470m.x().iterator();
    L4:
        RuleInfo r103 = null;
        if (r102.hasNext() == false) goto L9;
        Object r104 = r102.next();
        if (Intrinsics.areEqual(((RuleInfo) r104).b(), r100) == false) goto L4;
    L10:
        RuleInfo r105 = (RuleInfo) r104;
        if (r105 == null) goto L13;
        r103 = r105;
    L16:
        if (r103 == null) goto L19;
        f16886d.update(r103);
    L19:
        b(r100, r101);
        k.d("Helios-Common-Env", "RulesManager.update name=" + r100 + " isEnable=" + r101);
        return;
    L13:
        ArrayMap r106 = HeliosEnvImpl.get().f245473p;
        if (r106 == null) goto L16;
        r103 = (RuleInfo) r106.get(r100);
        goto L16
    L9:
        r104 = null;
        goto L10
    L18:
        f16883a.remove(r100);
        c();
        goto L19
    }
}
