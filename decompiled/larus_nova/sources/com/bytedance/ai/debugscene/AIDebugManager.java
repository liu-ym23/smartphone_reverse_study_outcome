package com.bytedance.ai.debugscene;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debugscene.tag.DebugTagStyle;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfo;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppVersionList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersion;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersionPage;
import com.bytedance.ai.resource.core.bean.OpenPlatformScanTarget;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.obric.sva.sdk.effectplatform.EffectConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class AIDebugManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AIDebugManager f36217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AppletDebugTool f36218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static IAISDKDebugService.DebugMode f36219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.bytedance.ai.resource.d0> f36220d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.bytedance.ai.resource.d0> f36221e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<c, com.bytedance.ai.resource.d0> f36222f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.bytedance.ai.resource.d0> f36223g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.bytedance.ai.resource.d0> f36224h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f36225i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f36226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f36227k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static JSONObject f36228l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f36229m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f36230n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f36231o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f36232p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static b f36233q;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f36234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f36235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f36236c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f36234a, r101.f36234a) == true) goto L12;
            return false;
        L12:
            if (this.f36235b == r101.f36235b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f36236c, r101.f36236c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f36234a.hashCode() * 31;
            if (this.f36235b == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            String r103 = this.f36236c;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "PreviewDebugConfigChange(appKey=" + this.f36234a + ", enabled=" + this.f36235b + ", versionTag=" + this.f36236c + ')';
        }

        public final JSONObject a() {
            JSONObject r100 = new JSONObject();
            r100.put("app_key", this.f36234a);
            r100.put("enabled", this.f36235b);
            if (this.f36235b == false) goto L13;
            String r101 = this.f36236c;
            if (r101 != null) goto L7;
        L10:
            boolean r102 = true;
        L11:
            if (r102 == true) goto L13;
            r100.put("version_tag", this.f36236c);
            goto L13
        L7:
            if (StringsKt.isBlank(r101) == true) goto L10;
            r102 = false;
        L13:
            return r100;
        }

        public a(String r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
            this.f36234a = r100;
            this.f36235b = r101;
            this.f36236c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f36237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f36238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f36239c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f36237a, r101.f36237a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f36238b, r101.f36238b) == true) goto L15;
            return false;
        L15:
            if (this.f36239c == r101.f36239c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f36237a.hashCode() * 31) + this.f36238b.hashCode()) * 31) + this.f36239c;
        }

        public final String toString() {
            return "PreviewInstallContext(deviceId=" + this.f36237a + ", xToken=" + this.f36238b + ", source=" + this.f36239c + ')';
        }

        public b(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "deviceId");
            Intrinsics.checkNotNullParameter(r101, "xToken");
            this.f36237a = r100;
            this.f36238b = r101;
            this.f36239c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f36240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f36241b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f36240a, r101.f36240a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f36241b, r101.f36241b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f36240a.hashCode() * 31) + this.f36241b.hashCode();
        }

        public final String toString() {
            return "PreviewPackageKey(packageName=" + this.f36240a + ", versionTag=" + this.f36241b + ')';
        }

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "packageName");
            Intrinsics.checkNotNullParameter(r101, "versionTag");
            this.f36240a = r100;
            this.f36241b = r101;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36242a = null;

        static {
            int[] r100 = new int[IAISDKDebugService.DebugMode.values().length];
            r100[IAISDKDebugService.DebugMode.LOCAL_DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[IAISDKDebugService.DebugMode.SCAN_PREVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[IAISDKDebugService.DebugMode.LEGACY_SCAN_PREVIEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[IAISDKDebugService.DebugMode.NORMAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f36242a = r100;
        }
    }

    public AIDebugManager() {
    }

    static {
        f36217a = new AIDebugManager();
        f36219c = IAISDKDebugService.DebugMode.NORMAL;
        f36220d = new ConcurrentHashMap();
        f36221e = new ConcurrentHashMap();
        f36222f = new ConcurrentHashMap();
        f36223g = new ConcurrentHashMap();
        f36224h = new ConcurrentHashMap();
        f36225i = new ConcurrentHashMap();
        f36229m = new ConcurrentHashMap();
        f36232p = new ConcurrentHashMap();
    }

    public static Set c() {
        LinkedHashSet r100 = new LinkedHashSet();
        r100.addAll(f36221e.keySet());
        r100.addAll(f36223g.keySet());
        r100.addAll(f36220d.keySet());
        return r100;
    }

    public static String i() {
        String r100 = null;
        if (f36219c != IAISDKDebugService.DebugMode.LOCAL_DEBUG) goto L21;
        String r101 = f36231o;
        if (r101 != null) goto L19;
        AppletDebugTool r102 = f36218b;
        if (r102 == null) goto L54;
        final j1 r103 = r102.f36247c;
        if (r103 != null) goto L13;
        return null;
    L13:
        if (r103.f36419a.getBoolean("applet_cache_debug_host", false) == false) goto L56;
        r101 = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(f36220d.keySet()), new com.bytedance.ai.debugscene.b()), new k(r103)));
        if (r101 == null) goto L57;
        f36231o = r101;
        goto L19
    L57:
        return null;
    L56:
        return null;
    L54:
        return null;
    L19:
        return r101;
    L21:
        if (f36219c != IAISDKDebugService.DebugMode.SCAN_PREVIEW) goto L47;
        q();
        JSONObject r104 = f36228l;
        if (r104 == null) goto L25;
        r100 = r104.optString("app_key");
    L25:
        Collection<a> r105 = f36229m.values();
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L27:
        if (r107.hasNext() == false) goto L31;
        Object r108 = r107.next();
        if ((!Intrinsics.areEqual(((a) r108).f36234a, r100)) == false) goto L27;
        r106.add(r108);
        goto L27
    L31:
        boolean r109 = !r106.isEmpty();
        if (r104 != null) goto L36;
        if (r109 == true) goto L36;
        JSONObject r110 = new JSONObject();
        r110.put("mode", "preview");
        r110.put("scan_app", new JSONArray());
        r110.put("changes", new JSONArray());
        return r110.toString();
    L36:
        JSONObject r111 = new JSONObject();
        r111.put("mode", "preview");
        if (r104 == null) goto L39;
        JSONArray r112 = new JSONArray();
        r112.put(r104);
        Unit r113 = Unit.INSTANCE;
        r111.put("scan_app", r112);
    L39:
        if (r109 == false) goto L46;
        JSONArray r114 = new JSONArray();
        Iterator r115 = r106.iterator();
    L42:
        if (r115.hasNext() == false) goto L44;
        r114.put(((a) r115.next()).a());
        goto L42
    L44:
        Unit r116 = Unit.INSTANCE;
        r111.put("changes", r114);
    L46:
        return r111.toString();
    L47:
        return null;
    }

    public static void q() {
        if ((!f36229m.isEmpty()) == false) goto L5;
        return;
    L5:
        AppletDebugTool r100 = f36218b;
        if (r100 == null) goto L68;
        j1 r101 = r100.f36247c;
        if (r101 == null) goto L69;
        String r102 = r101.f36420b.get("preview_debug_config_changes");
        if (r102 != null) goto L21;
        r102 = r101.f36419a.getString("preview_debug_config_changes", null);
        if (r102 != null) goto L15;
        r102 = null;
        goto L21
    L15:
        if (r102.length() <= 0) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == false) goto L21;
        r101.f36420b.put("preview_debug_config_changes", r102);
        goto L21
    L17:
        r103 = false;
    L21:
        if (r102 == null) goto L72;
        JSONArray r104 = new JSONArray(r102);     // Catch: Exception -> L55
        int r105 = r104.length();     // Catch: Exception -> L55
        int r106 = 0;
    L24:
        if (r106 >= r105) goto L53;
        JSONObject r107 = r104.optJSONObject(r106);     // Catch: Exception -> L55
        if (r107 == null) goto L52;
        String r108 = r107.optString("app_key");     // Catch: Exception -> L55
        Intrinsics.checkNotNull(r108);     // Catch: Exception -> L55
        if ((!StringsKt.isBlank(r108)) == true) goto L32;
        r108 = null;
    L32:
        if (r108 == null) goto L52;
        boolean r110 = r107.optBoolean("enabled");     // Catch: Exception -> L55
        String r109 = r107.optString("version_tag");     // Catch: Exception -> L55
        Intrinsics.checkNotNull(r109);     // Catch: Exception -> L55
        if ((!StringsKt.isBlank(r109)) == true) goto L38;
        r109 = null;
    L38:
        if (r110 == false) goto L47;
        if (r109 != null) goto L41;
    L44:
        boolean r111 = true;
    L45:
        if (r111 == true) goto L47;
        boolean r112 = true;
    L48:
        if (r112 == true) goto L51;
        r109 = null;
    L51:
        f36229m.put(r108, new a(r108, r110, r109));     // Catch: Exception -> L55
        goto L52
    L41:
        if (StringsKt.isBlank(r109) == true) goto L44;
        r111 = false;
    L47:
        r112 = false;
    L52:
        r106 = r106 + 1;     // Catch: Exception -> L55
        goto L24
    L53:
        com.bytedance.ai.utils.g.f37637a.i("AIDebugManager", "load preview debug config changes from storage. size: " + f36229m.size());     // Catch: Exception -> L55
        return;
    L55:
        e = move-exception;
        com.bytedance.ai.utils.g r113 = com.bytedance.ai.utils.g.f37637a;
        r113.e("AIDebugManager", "failed to load preview debug config changes from storage: " + e.getMessage());
        AppletDebugTool r114 = f36218b;
        if (r114 == null) goto L70;
        j1 r115 = r114.f36247c;
        if (r115 == null) goto L71;
        r115.f36420b.remove("preview_debug_config_changes");
        SharedPreferences.Editor r116 = r115.f36419a.edit();
        r116.remove("preview_debug_config_changes");
        r116.commit();
        r113.i("AISDKDebugSettings", "Cleared preview debug config changes from storage");
        return;
    L71:
        return;
    L70:
        return;
    L72:
        return;
    L69:
        return;
    }

    public static Map j() {
        String r100 = i();
        if (r100 == null) goto L5;
        JSONArray r101 = new JSONObject(r100).optJSONArray("changes");     // Catch: Exception -> L33
        if (r101 == null) goto L9;
        Map r102 = MapsKt.createMapBuilder();     // Catch: Exception -> L33
        int r103 = r101.length();     // Catch: Exception -> L33
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L41;
        JSONObject r105 = r101.optJSONObject(r104);     // Catch: Exception -> L33
        if (r105 == null) goto L30;
        String r106 = r105.optString("app_key");     // Catch: Exception -> L33
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L33
        boolean r107 = true;
        String r108 = null;
        if ((!StringsKt.isBlank(r106)) == true) goto L19;
        r106 = null;
    L19:
        if (r106 == null) goto L30;
        boolean r109 = r105.optBoolean("enabled");     // Catch: Exception -> L33
        String r110 = r105.optString("version_tag");     // Catch: Exception -> L33
        if (r109 == false) goto L26;
        Intrinsics.checkNotNull(r110);     // Catch: Exception -> L33
        if ((!StringsKt.isBlank(r110)) == false) goto L26;
    L27:
        if (r107 == false) goto L29;
        r108 = r110;
    L29:
        r102.put(r106, new a(r106, r109, r108));     // Catch: Exception -> L33
    L26:
        r107 = false;
    L30:
        r104 = r104 + 1;     // Catch: Exception -> L33
        goto L11
    L41:
        return MapsKt.build(r102);
    L9:
        return MapsKt.emptyMap();
    L33:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AIDebugManager", "failed to parse preview debug config changes for mock data: " + e.getMessage());
        return MapsKt.emptyMap();
    L5:
        return MapsKt.emptyMap();
    }

    public static void B(String r100) {
        AppletDebugTool r101 = f36218b;
        if (r101 == null) goto L5;
        j1 r102 = r101.f36247c;
    L6:
        if (r102 == null) goto L19;
        SharedPreferences.Editor r103 = r102.f36419a.edit();
        if (r100 != null) goto L10;
    L13:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        r103.remove("remote_debug_modern_tag_package");
    L18:
        r103.commit();
        goto L19
    L17:
        r103.putString("remote_debug_modern_tag_package", r100);
        goto L18
    L10:
        if (StringsKt.isBlank(r100) == true) goto L13;
        r104 = false;
    L19:
        v4.c.c();
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static v4.a e(String r100) {
        com.bytedance.ai.resource.d0 r101 = f(r100);
        Boolean r102 = null;
        j1 r103 = null;
        j1 r104 = null;
        if (r101 == null) goto L7;
        AIPackage r105 = r101.g(r100);
        if (r105 == null) goto L7;
    L11:
        int r106 = d.f36242a[f36219c.ordinal()];
        boolean r107 = true;
        if (r106 != 1) goto L14;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if (r105.A == true) goto L44;
    L46:
        boolean r108 = false;
    L47:
        if (r108 == false) goto L66;
        Intrinsics.checkNotNullParameter(r100, "packageName");
        AppletDebugTool r109 = f36218b;
        if (r109 == null) goto L51;
        j1 r110 = r109.f36247c;
    L52:
        if (r110 == null) goto L63;
        Intrinsics.checkNotNullParameter(r100, "appletName");
        String r111 = "show_debug_tag_".concat(r100);
        String r112 = r110.f36420b.get(r111);
        if (r112 == null) goto L56;
        r102 = Boolean.valueOf(Boolean.parseBoolean(r112));
    L56:
        if (r102 == null) goto L58;
    L60:
        boolean r113 = Intrinsics.areEqual(r102, Boolean.TRUE);
    L61:
        if (r113 != true) goto L63;
        boolean r114 = true;
    L64:
        if (r114 == false) goto L66;
    L67:
        v4.a r115 = new v4.a(r107, "Debug", DebugTagStyle.MODERN_DEBUG);
    L71:
        return r115;
    L58:
        if (r110.f36421c == false) goto L60;
        r113 = r110.f36419a.getBoolean(r111, false);
        r110.f36420b.put(r111, String.valueOf(r113));
    L63:
        r114 = false;
        goto L64
    L51:
        r110 = null;
    L66:
        r107 = false;
        goto L67
    L44:
        if (com.bytedance.ai.utils.f.g(IAISDKDebugService.f36186a.G(r105.f36895b)) == false) goto L46;
        r108 = true;
        goto L47
    L14:
        if (r106 != 2) goto L16;
        Intrinsics.checkNotNullParameter(r100, "packageName");
        AppletDebugTool r116 = f36218b;
        if (r116 == null) goto L34;
        r104 = r116.f36247c;
    L34:
        if (r104 != null) goto L36;
    L38:
        r107 = false;
    L39:
        r115 = new v4.a(r107, "Debug", DebugTagStyle.MODERN_DEBUG);
        goto L71
    L36:
        if (r104.f36419a.getBoolean("remote_debug_tag_enabled", true) != true) goto L38;
    L16:
        if (r106 != 3) goto L18;
        Intrinsics.checkNotNullParameter(r100, "packageName");
        AppletDebugTool r117 = f36218b;
        if (r117 == null) goto L25;
        r103 = r117.f36247c;
    L25:
        if (r103 != null) goto L27;
    L29:
        r107 = false;
    L30:
        r115 = new v4.a(r107, "Preview", DebugTagStyle.LEGACY_PREVIEW);
        goto L71
    L27:
        if (r103.f36419a.getBoolean("remote_debug_tag_enabled", true) != true) goto L29;
    L18:
        if (r106 != 4) goto L21;
        return new v4.a();
    L21:
        throw new NoWhenBranchMatchedException();
    L7:
        if (r101 == null) goto L9;
        r105 = (Widget) CollectionsKt.firstOrNull(r101.f());
    L10:
        if (r105 != null) goto L11;
        return new v4.a();
    L9:
        r105 = null;
        goto L10
    }

    public static com.bytedance.ai.resource.d0 f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        IAISDKDebugService.DebugMode r101 = f36219c;
        int r102 = d.f36242a[r101.ordinal()];
        if (r102 == 1) goto L16;
        if (r102 == 2) goto L19;
        if (r102 == 3) goto L18;
        if (r102 != 4) goto L12;
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return f36221e.get(r100);
    L19:
        return f36223g.get(r100);
    L16:
        return f36220d.get(r100);
    }

    public static boolean m(String r100) {
        AppletDebugTool r101 = f36218b;
        if (r101 == null) goto L12;
        j1 r102 = r101.f36247c;
        if (r102 == null) goto L12;
        if (f36220d.containsKey(r100) == false) goto L12;
        if (com.bytedance.ai.utils.f.g(r102.b(r100)) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static void x(IAISDKDebugService.DebugMode r100) {
        Intrinsics.checkNotNullParameter(r100, "debugMode");
        com.bytedance.ai.utils.g.f37637a.i("AIDebugManager", "setDebugMode: " + f36219c + " -> " + r100);
        f36219c = r100;
    }

    public static void A(String r100, String r101) {
        Activity r102 = f2.k.b();
        if (r102 == null) goto L6;
        final AlertDialog.Builder r103 = new AlertDialog.Builder(r102);
        r103.setTitle(r100);
        r103.setMessage(r101);
        r103.setNegativeButton("Confirm", new e());
        r102.runOnUiThread(new f(r103));
        return;
    }

    public static com.bytedance.ai.resource.d0 b(String r100, String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == true) goto L12;
        return f36222f.get(new c(r100, r101));
    L12:
        return f36223g.get(r100);
    L4:
        if (r101.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    public static OpenPlatformPreviewAppInfo t(OpenPlatformPreviewAppInfo r210, a r211) {
        if (r211.f36235b == false) goto L5;
        String r100 = r211.f36236c;
        if (r100 == null) goto L9;
        List<OpenPlatformPreviewVersion> r101 = r210.getTestVersions();
        List<OpenPlatformPreviewVersion> r102 = r210.getAuditVersions();
        OpenPlatformPreviewVersionPage r103 = r210.getFormalVersions();
        Boolean r110 = Boolean.TRUE;
        ArrayList r104 = null;
        if (r101 == null) goto L17;
        List<OpenPlatformPreviewVersion> r105 = r101;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        OpenPlatformPreviewVersion r111 = (OpenPlatformPreviewVersion) r107.next();
        r106.add(OpenPlatformPreviewVersion.copy$default(r111, null, null, Boolean.valueOf(Intrinsics.areEqual(r111.getVersionTag(), r100)), null, null, 27, null));
        goto L14
    L16:
        ArrayList r108 = r106;
    L18:
        if (r102 == null) goto L24;
        List<OpenPlatformPreviewVersion> r109 = r102;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r113 = r109.iterator();
    L21:
        if (r113.hasNext() == false) goto L23;
        OpenPlatformPreviewVersion r114 = (OpenPlatformPreviewVersion) r113.next();
        r112.add(OpenPlatformPreviewVersion.copy$default(r114, null, null, Boolean.valueOf(Intrinsics.areEqual(r114.getVersionTag(), r100)), null, null, 27, null));
        goto L21
    L23:
        ArrayList r115 = r112;
    L25:
        if (r103 == null) goto L33;
        List<OpenPlatformPreviewVersion> r116 = r103.getItems();
        if (r116 == null) goto L32;
        List<OpenPlatformPreviewVersion> r117 = r116;
        r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r118 = r117.iterator();
    L30:
        if (r118.hasNext() == false) goto L32;
        OpenPlatformPreviewVersion r119 = (OpenPlatformPreviewVersion) r118.next();
        r104.add(OpenPlatformPreviewVersion.copy$default(r119, null, null, Boolean.valueOf(Intrinsics.areEqual(r119.getVersionTag(), r100)), null, null, 27, null));
    L32:
        OpenPlatformPreviewVersionPage r120 = OpenPlatformPreviewVersionPage.copy$default(r103, r104, null, false, 6, null);
    L35:
        return OpenPlatformPreviewAppInfo.copy$default(r210, null, null, null, r110, r108, r115, r120, 7, null);
    L33:
        r120 = null;
        goto L35
    L24:
        r115 = null;
        goto L25
    L17:
        r108 = null;
        goto L18
    L9:
        return OpenPlatformPreviewAppInfo.copy$default(r210, null, null, null, Boolean.TRUE, null, null, null, 119, null);
    L5:
        return OpenPlatformPreviewAppInfo.copy$default(r210, null, null, null, Boolean.FALSE, null, null, null, 119, null);
    }

    public static List u(List r110, OpenPlatformScanTarget r111) {
        ArrayList r100 = null;
        boolean r101 = false;
        if (r110 == null) goto L40;
        List r102 = r110;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L39;
        OpenPlatformPreviewAppInfo r105 = (OpenPlatformPreviewAppInfo) r104.next();
        f36217a.getClass();
        if (Intrinsics.areEqual(r105.getAppKey(), r111.getAppKey()) == false) goto L33;
        List<OpenPlatformPreviewVersion> r112 = v(r105.getTestVersions(), r111.getVersionTag());
        List<OpenPlatformPreviewVersion> r113 = v(r105.getAuditVersions(), r111.getVersionTag());
        OpenPlatformPreviewVersionPage r106 = r105.getFormalVersions();
        if (r106 == null) goto L13;
        List<OpenPlatformPreviewVersion> r107 = r106.getItems();
    L14:
        List<OpenPlatformPreviewVersion> r114 = v(r107, r111.getVersionTag());
        OpenPlatformPreviewVersionPage r108 = r105.getFormalVersions();
        if (r108 == null) goto L17;
        List<OpenPlatformPreviewVersion> r109 = r108.getItems();
    L18:
        if (r114 != r109) goto L20;
        OpenPlatformPreviewVersionPage r115 = r105.getFormalVersions();
    L23:
        OpenPlatformPreviewVersionPage r116 = r115;
    L25:
        Boolean r117 = Boolean.TRUE;
        if (Intrinsics.areEqual(r117, r105.getDefaultEnabled()) == true) goto L28;
    L34:
        OpenPlatformPreviewAppInfo r118 = OpenPlatformPreviewAppInfo.copy$default(r105, null, null, null, r117, r112, r113, r116, 7, null);
    L35:
        if (r118 == r105) goto L38;
        r101 = true;
        r105 = r118;
    L38:
        r103.add(r105);
        goto L6
    L28:
        if (r112 != r105.getTestVersions()) goto L34;
        if (r113 != r105.getAuditVersions()) goto L34;
        if (r116 != r105.getFormalVersions()) goto L34;
    L20:
        OpenPlatformPreviewVersionPage r119 = r105.getFormalVersions();
        if (r119 == null) goto L24;
        r115 = OpenPlatformPreviewVersionPage.copy$default(r119, r114, null, false, 6, null);
        goto L23
    L24:
        r116 = null;
        goto L25
    L17:
        r109 = null;
        goto L18
    L13:
        r107 = null;
    L33:
        r118 = r105;
        goto L35
    L39:
        r100 = r103;
    L40:
        if (r101 == false) goto L43;
        return r100;
    L43:
        return r110;
    }

    public static List v(List r110, String r111) {
        boolean r100 = false;
        if (r110 == null) goto L12;
        List r101 = r110;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        OpenPlatformPreviewVersion r104 = (OpenPlatformPreviewVersion) r103.next();
        boolean r105 = Intrinsics.areEqual(r104.getVersionTag(), r111);
        if (Intrinsics.areEqual(r104.isDefault(), Boolean.valueOf(r105)) == true) goto L11;
        r104 = OpenPlatformPreviewVersion.copy$default(r104, null, null, Boolean.valueOf(r105), null, null, 27, null);
        r100 = true;
    L11:
        r102.add(r104);
    L13:
        if (r100 == true) goto L15;
        return r110;
    L15:
        return r102;
    L12:
        r102 = null;
        goto L13
    }

    public static void y(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "packageName");
        f36231o = r100;
        boolean r102 = true;
        if ((!StringsKt.isBlank(r101)) == true) goto L5;
        return;
    L5:
        if (m(r101) == false) goto L24;
        AppletDebugTool r103 = f36218b;
        if (r103 == null) goto L25;
        j1 r104 = r103.f36247c;
        if (r104 == null) goto L26;
        Intrinsics.checkNotNullParameter(r101, "appletName");
        String r105 = "local_debug_config_" + r101;
        if (r104.f36421c == false) goto L27;
        SharedPreferences.Editor r106 = r104.f36419a.edit();
        if (r100 != null) goto L15;
    L18:
        if (r102 == false) goto L20;
        r106.remove(r105);
    L21:
        r106.commit();
        return;
    L20:
        r106.putString(r105, r100);
        goto L21
    L15:
        if (r100.length() == 0) goto L18;
        r102 = false;
        goto L18
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }

    public final Object d(String r100, Continuation<? super String> r101) {
        if ((r101 instanceof AIDebugManager$getDebugSchema$1) == false) goto L7;
        AIDebugManager$getDebugSchema$1 r102 = (AIDebugManager$getDebugSchema$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        String r107 = (String) r104;
        if (r107 == null) goto L20;
        f36230n = true;
        return r107;
    L20:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        f36230n = false;
        AIManager r108 = AIManager.f37211a;
        r102.label = 1;
        r104 = AIManager.j(r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new AIDebugManager$getDebugSchema$1(this, r101);
        goto L8
    }

    public final Object p(String r100, Continuation r101) {
        if ((r101 instanceof AIDebugManager$loadAppletWithWidgets$1) == false) goto L7;
        AIDebugManager$loadAppletWithWidgets$1 r102 = (AIDebugManager$loadAppletWithWidgets$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        Applet r107 = (Applet) r102.L$1;
        Applet r108 = (Applet) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L25:
        List r109 = (List) r104;
        ArrayList<Widget> r110 = r108.S;
        if (r110 == null) goto L28;
        r110.clear();
    L28:
        if (r109 == null) goto L33;
        ArrayList<Widget> r111 = r108.S;
        if (r111 == null) goto L33;
        Boxing.boxBoolean(r111.addAll(r109));
    L33:
        return r108;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r112 = (String) r102.L$1;
        String r113 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
        String r114 = r112;
        r100 = r113;
        Object r115 = r104;
    L19:
        Applet r116 = (Applet) r115;
        if (r116 == null) goto L34;
        AIDebugManager r117 = f36217a;
        r102.L$0 = r116;
        r102.L$1 = r116;
        r102.label = 2;
        r104 = r117.s(r100, r114, r102);
        if (r104 != r105) goto L24;
        return r105;
    L24:
        r108 = r116;
        goto L25
    L34:
        return r116;
    L16:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r114 = null;
        r102.L$1 = null;
        r102.label = 1;
        r115 = n(r100, null, r102);
        if (r115 != r105) goto L19;
        return r105;
    L7:
        r102 = new AIDebugManager$loadAppletWithWidgets$1(this, r101);
        goto L8
    }

    public static void w(String r100, String r101, com.bytedance.ai.resource.d0 r110) {
        String r102 = r110.f37481a;
        if (StringsKt.isBlank(r102) == true) goto L6;
        r100 = r102;
    L6:
        c r103 = new c(r100, r101);
        ConcurrentHashMap<String, com.bytedance.ai.resource.d0> r104 = f36223g;
        com.bytedance.ai.resource.d0 r105 = r104.get(r100);
        if (r105 == null) goto L10;
        if (r105 == r110) goto L10;
        f36224h.put(r100 + '_' + r105.f37489i + '_' + r101, r105);
    L10:
        f36222f.put(r103, r110);
        r104.put(r100, r110);
        AppletDebugTool r106 = f36218b;
        if (r106 == null) goto L15;
        j1 r107 = r106.f36247c;
        if (r107 == null) goto L15;
        Intrinsics.checkNotNullParameter(r104, "debugPackages");
        r107.g("debug_packages", r104);
        ConcurrentHashMap<String, com.bytedance.ai.resource.d0> r108 = f36224h;
        Intrinsics.checkNotNullParameter(r108, "previousDebugPackages");
        r107.g("previous_debug_packages", r108);
    L15:
        com.bytedance.ai.utils.g.f37637a.i("AIManager", "install scan preview package succeed: " + r100 + ", versionCode: " + r110.f37489i + ", versionTag: " + r101);
    }

    public static void z(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        Intrinsics.checkNotNullParameter(r101, "xToken");
        com.bytedance.ai.utils.g r103 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r104 = new StringBuilder("setPreviewInstallContext. source: ");
        r104.append(r102);
        r104.append(", deviceIdEmpty: ");
        boolean r105 = false;
        if (r100.length() != 0) goto L5;
        boolean r106 = true;
    L6:
        r104.append(r106);
        r104.append(", xTokenEmpty: ");
        if (r101.length() != 0) goto L9;
        r105 = true;
    L9:
        r104.append(r105);
        r103.i("AIDebugManager", r104.toString());
        f36233q = new b(r100, r101, r102);
        return;
    L5:
        r106 = false;
        goto L6
    }

    public final Object a(final String r110, final String r111, Continuation<? super com.bytedance.ai.resource.d0> r112) {
        if ((r112 instanceof AIDebugManager$ensureScanPreviewPackage$1) == false) goto L7;
        AIDebugManager$ensureScanPreviewPackage$1 r100 = (AIDebugManager$ensureScanPreviewPackage$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AIDebugManager$ensureScanPreviewPackage$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r111 = (String) r102.L$1;
        r110 = (String) r102.L$0;
        ResultKt.throwOnFailure(r113);
    L34:
        return b(r110, r111);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        com.bytedance.ai.resource.d0 r114 = b(r110, r111);
        if (r114 == null) goto L17;
        return r114;
    L17:
        if (r111 != null) goto L19;
    L22:
        boolean r115 = true;
    L24:
        if (r115 == false) goto L26;
        return null;
    L26:
        b r116 = f36233q;
        if (r116 != null) goto L30;
        com.bytedance.ai.utils.g.f37637a.e("AIManager", "scan preview install context is null. packageName: " + r110 + ", versionTag: " + r111);
        return null;
    L30:
        AIManager r105 = AIManager.f37211a;
        int r106 = r116.f36239c;
        String r107 = r116.f36237a;
        String r108 = r116.f36238b;
        Function4<? super Boolean, ? super Boolean, ? super com.bytedance.ai.resource.d0, ? super String, Unit> r109 = new l(r110, r111);
        r102.L$0 = r110;
        r102.L$1 = r111;
        r102.label = 1;
        if (r105.v(r106, r110, r111, r107, r108, r109, r102) != r103) goto L34;
        return r103;
    L19:
        if (r111.length() == 0) goto L22;
        r115 = false;
    L7:
        r100 = new AIDebugManager$ensureScanPreviewPackage$1(this, r112);
        goto L8
    }

    public final Object n(String r110, String r111, Continuation<? super Applet> r112) {
        int r100 = d.f36242a[f36219c.ordinal()];
        if (r100 != 1) goto L5;
        kotlinx.coroutines.j r101 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r112), 1);
        r101.C();
        com.bytedance.ai.resource.d0 r102 = f36220d.get(r110);
        if (r102 == null) goto L22;
        Applet r103 = r102.g(r110);
    L23:
        if (r103 != null) goto L37;
        AppletDebugTool r104 = f36218b;
        if (r104 == null) goto L36;
        j1 r105 = r104.f36247c;
        if (r105 == null) goto L36;
        ConcurrentHashMap<String, Boolean> r106 = f36225i;
        if (Intrinsics.areEqual(r106.get(r110), Boxing.boxBoolean(true)) == false) goto L31;
        com.bytedance.ai.utils.g.f37637a.d("AIManager", "--loadApplet: " + r110 + " --skip to install " + r110 + " from debug host");
        r101.resumeWith(Result.m9449constructorimpl(null));
    L38:
        Object r107 = r101.B();
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
        DebugProbesKt.probeCoroutineSuspended(r112);
    L41:
        return r107;
    L31:
        r106.put(r110, Boxing.boxBoolean(true));
        String r108 = r105.b(r110);
        if (r105.f36419a.getBoolean("applet_cache_debug_host", false) == false) goto L35;
        if (r108 == null) goto L35;
        boolean r109 = r105.e(r110);
        String r113 = r105.c(r110);
        boolean r114 = r105.d(r110);
        com.bytedance.ai.utils.g.f37637a.d("AIManager", "--loadApplet: " + r110 + " --try to install " + r110 + " from debug host: " + r108);
        l(f36217a, r110, r109, r113, r114, new w(r101, r110), new x(r101), 64);
    L35:
        r101.resumeWith(Result.m9449constructorimpl(null));
    L36:
        r101.resumeWith(Result.m9449constructorimpl(null));
        goto L38
    L37:
        r101.resumeWith(Result.m9449constructorimpl(r103));
        goto L38
    L22:
        r103 = null;
        goto L23
    L5:
        if (r100 == 2) goto L18;
        if (r100 != 3) goto L9;
        com.bytedance.ai.resource.d0 r115 = f36221e.get(r110);
        if (r115 != null) goto L16;
        return null;
    L16:
        return r115.g(r110);
    L9:
        if (r100 != 4) goto L12;
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return o(r110, r111, r112);
    }

    public final Object o(String r100, String r101, Continuation<? super Applet> r102) {
        if ((r102 instanceof AIDebugManager$loadAppletFromScanPreview$1) == false) goto L7;
        AIDebugManager$loadAppletFromScanPreview$1 r103 = (AIDebugManager$loadAppletFromScanPreview$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        com.bytedance.ai.resource.d0 r108 = (com.bytedance.ai.resource.d0) r105;
        if (r108 != null) goto L22;
        return null;
    L22:
        return r108.g(r100);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.label = 1;
        r105 = a(r100, r101, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new AIDebugManager$loadAppletFromScanPreview$1(this, r102);
        goto L8
    }

    public final Object s(String r100, String r101, Continuation<? super List<? extends Widget>> r102) {
        if ((r102 instanceof AIDebugManager$loadWidgetsWithPackageName$1) == false) goto L7;
        AIDebugManager$loadWidgetsWithPackageName$1 r103 = (AIDebugManager$loadWidgetsWithPackageName$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L31:
        com.bytedance.ai.resource.d0 r108 = (com.bytedance.ai.resource.d0) r105;
        if (r108 != null) goto L40;
    L37:
        return null;
    L40:
        return r108.f();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        IAISDKDebugService.DebugMode r109 = f36219c;
        int r110 = d.f36242a[r109.ordinal()];
        if (r110 != 1) goto L17;
        com.bytedance.ai.resource.d0 r111 = f36220d.get(r100);
        if (r111 == null) goto L37;
        return r111.f();
    L17:
        if (r110 != 2) goto L19;
        r103.label = 1;
        r105 = a(r100, r101, r103);
        if (r105 != r106) goto L31;
        return r106;
    L19:
        if (r110 != 3) goto L21;
        com.bytedance.ai.resource.d0 r112 = f36221e.get(r100);
        if (r112 == null) goto L37;
        return r112.f();
    L21:
        if (r110 == 4) goto L37;
        throw new NoWhenBranchMatchedException();
    L7:
        r103 = new AIDebugManager$loadWidgetsWithPackageName$1(this, r102);
        goto L8
    }

    public final Object r(String r100, String r101, String r102, Continuation<? super Widget> r103) {
        if ((r103 instanceof AIDebugManager$loadWidgetFromScanPreview$1) == false) goto L7;
        AIDebugManager$loadWidgetFromScanPreview$1 r104 = (AIDebugManager$loadWidgetFromScanPreview$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r101 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L17:
        com.bytedance.ai.resource.d0 r109 = (com.bytedance.ai.resource.d0) r106;
        if (r109 != null) goto L22;
        return null;
    L22:
        return r109.h(r101);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        r104.L$0 = r101;
        r104.label = 1;
        r106 = a(r100, r102, r104);
        if (r106 != r107) goto L17;
        return r107;
    L7:
        r104 = new AIDebugManager$loadWidgetFromScanPreview$1(this, r103);
        goto L8
    }

    public final Object g(int r210, String r211, String r212, String r213, int r214, Continuation<? super OpenPlatformPreviewAppInfoList> r310) {
        if ((r310 instanceof AIDebugManager$getPreviewAppInfoList$1) == false) goto L7;
        AIDebugManager$getPreviewAppInfoList$1 r100 = (AIDebugManager$getPreviewAppInfoList$1) r310;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AIDebugManager$getPreviewAppInfoList$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L35:
        OpenPlatformPreviewAppInfoList r110 = (OpenPlatformPreviewAppInfoList) r103;
        Map r106 = j();
        ArrayList r107 = null;
        if (r106.isEmpty() == false) goto L38;
    L37:
        OpenPlatformPreviewAppInfoList r111 = r110;
        JSONObject r108 = f36228l;
        if (r108 != null) goto L70;
        OpenPlatformScanTarget r109 = null;
    L71:
        if (r109 == null) goto L77;
        List<OpenPlatformPreviewAppInfo> r112 = u(r111.getScanSelectedApps(), r109);
        List<OpenPlatformPreviewAppInfo> r113 = u(r111.getApps(), r109);
        com.bytedance.ai.utils.g.f37637a.i("AIDebugManager", "merge scan debug config with preview app info list. appKey: " + r109.getAppKey() + ", versionTag: " + r109.getVersionTag());
        if (r112 == r111.getScanSelectedApps()) goto L76;
    L78:
        r111 = OpenPlatformPreviewAppInfoList.copy$default(r111, null, r112, r113, null, false, 25, null);
        goto L77
    L76:
        if (r113 != r111.getApps()) goto L78;
    L77:
        OpenPlatformPreviewAppInfoList r114 = r111;
        List<OpenPlatformPreviewAppInfo> r115 = r114.getScanSelectedApps();
        if (r115 == null) goto L93;
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r115.iterator();
    L83:
        if (r117.hasNext() == false) goto L92;
        String r118 = ((OpenPlatformPreviewAppInfo) r117.next()).getAppKey();
        if (r118 != null) goto L87;
    L89:
        r118 = null;
    L90:
        if (r118 == null) goto L83;
        r116.add(r118);
        goto L83
    L87:
        if ((!StringsKt.isBlank(r118)) == false) goto L89;
    L92:
        Set r119 = CollectionsKt.toSet(r116);
    L94:
        if (r119 != null) goto L97;
        r119 = SetsKt.emptySet();
    L97:
        if (r119.isEmpty() == true) goto L139;
        List<OpenPlatformPreviewAppInfo> r120 = r114.getApps();
        if (r120 == null) goto L119;
        r107 = new ArrayList();
        Iterator<T> r121 = r120.iterator();
    L103:
        if (r121.hasNext() == false) goto L119;
        Object r122 = r121.next();
        String r123 = ((OpenPlatformPreviewAppInfo) r122).getAppKey();
        if (r123 != null) goto L107;
    L110:
        boolean r124 = true;
    L111:
        if (r124 == false) goto L113;
    L116:
        boolean r125 = true;
    L117:
        if (r125 == false) goto L103;
        r107.add(r122);
        goto L103
    L113:
        if (r119.contains(r123) == false) goto L116;
        r125 = false;
        goto L117
    L107:
        if (StringsKt.isBlank(r123) == true) goto L110;
        r124 = false;
    L119:
        ArrayList r126 = r107;
        com.bytedance.ai.utils.g.f37637a.i("AIDebugManager", "remove scan selected apps from preview app list. selectedAppCount: " + r119.size());
        return OpenPlatformPreviewAppInfoList.copy$default(r114, null, null, r126, null, false, 27, null);
    L139:
        return r114;
    L93:
        r119 = null;
        goto L94
    L70:
        r109 = new OpenPlatformScanTarget(r108.optString("app_key"), r108.optString("version_tag"));
        goto L71
    L38:
        List<OpenPlatformPreviewAppInfo> r127 = r110.getScanSelectedApps();
        if (r127 == null) goto L51;
        List<OpenPlatformPreviewAppInfo> r128 = r127;
        ArrayList r129 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r128, 10));
        Iterator<T> r130 = r128.iterator();
    L42:
        if (r130.hasNext() == false) goto L50;
        OpenPlatformPreviewAppInfo r131 = (OpenPlatformPreviewAppInfo) r130.next();
        String r132 = r131.getAppKey();
        if (r132 == null) goto L49;
        a r133 = (a) r106.get(r132);
        if (r133 == null) goto L49;
        f36217a.getClass();
        r131 = t(r131, r133);
    L49:
        r129.add(r131);
        goto L42
    L50:
        ArrayList r134 = r129;
    L52:
        List<OpenPlatformPreviewAppInfo> r135 = r110.getApps();
        if (r135 == null) goto L65;
        List<OpenPlatformPreviewAppInfo> r136 = r135;
        ArrayList r137 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r136, 10));
        Iterator<T> r138 = r136.iterator();
    L56:
        if (r138.hasNext() == false) goto L64;
        OpenPlatformPreviewAppInfo r139 = (OpenPlatformPreviewAppInfo) r138.next();
        String r140 = r139.getAppKey();
        if (r140 == null) goto L63;
        a r141 = (a) r106.get(r140);
        if (r141 == null) goto L63;
        f36217a.getClass();
        r139 = t(r139, r141);
    L63:
        r137.add(r139);
        goto L56
    L64:
        ArrayList r142 = r137;
    L66:
        com.bytedance.ai.utils.g.f37637a.i("AIDebugManager", "merge preview debug config changes with mock app info list. changes: " + r106.size());
        r110 = OpenPlatformPreviewAppInfoList.copy$default(r110, null, r134, r142, null, false, 25, null);
        goto L37
    L65:
        r142 = null;
        goto L66
    L51:
        r134 = null;
        goto L52
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ArrayList r143 = new ArrayList();
        JSONObject r144 = f36228l;
        if (r144 == null) goto L32;
        String r145 = r144.optString("app_key");
        String r146 = r144.optString("version_tag");
        if (r145 != null) goto L19;
    L22:
        boolean r147 = true;
    L23:
        if (r147 == true) goto L32;
        if (r146 != null) goto L26;
    L29:
        boolean r148 = true;
    L30:
        if (r148 == true) goto L32;
        r143.add(new OpenPlatformScanTarget(r145, r146));
        goto L32
    L26:
        if (StringsKt.isBlank(r146) == true) goto L29;
        r148 = false;
        goto L30
    L19:
        if (StringsKt.isBlank(r145) == true) goto L22;
        r147 = false;
    L32:
        AIManager r149 = AIManager.f37211a;
        r102.label = 1;
        r103 = AIManager.n(r210, r211, r212, r213, r214, r143, r102);
        if (r103 != r104) goto L35;
        return r104;
    L7:
        r100 = new AIDebugManager$getPreviewAppInfoList$1(this, r310);
        goto L8
    }

    public static void k(final String r110, final boolean r111, final String r112, final boolean r113, final Function0 r114, final Function1 r115, final String r116) {
        Intrinsics.checkNotNullParameter(r110, "packageName");
        Intrinsics.checkNotNullParameter(r114, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r115, "reject");
        Intrinsics.checkNotNullParameter(r116, "appletType");
        x(IAISDKDebugService.DebugMode.LOCAL_DEBUG);
        AppletResourceTool r117 = AppletResourceTool.f37276a;
        Function1 r118 = new n(r110, r115, r111, r112, r113, r116, r114);
        Function1 r100 = new o(r110, r115);
        r117.getClass();
        AppletResourceTool.p(r110, EffectConstant.MODEL_MANIFEST_FILE_NAME, false, r118, r100);
    }

    public final Object h(int r210, String r211, String r212, String r213, String r214, int r215, Continuation<? super OpenPlatformPreviewAppVersionList> r216) {
        if ((r216 instanceof AIDebugManager$getPreviewAppVersionList$1) == false) goto L7;
        AIDebugManager$getPreviewAppVersionList$1 r100 = (AIDebugManager$getPreviewAppVersionList$1) r216;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AIDebugManager$getPreviewAppVersionList$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        OpenPlatformPreviewAppVersionList r106 = (OpenPlatformPreviewAppVersionList) r103;
        a r107 = (a) j().get(r106.getAppKey());
        if (r107 != null) goto L21;
    L38:
        JSONObject r108 = f36228l;
        if (r108 != null) goto L41;
        OpenPlatformScanTarget r109 = null;
    L42:
        if (r109 == null) goto L56;
        OpenPlatformPreviewVersionPage r110 = r106.getFormalVersions();
        if (r110 == null) goto L57;
        boolean r111 = Intrinsics.areEqual(r106.getAppKey(), r109.getAppKey());
        com.bytedance.ai.utils.g.f37637a.i("AIDebugManager", "merge scan debug config with preview app version list. appKey: " + r109.getAppKey() + ", versionTag: " + r109.getVersionTag() + ", targetApp: " + r111);
        if (r111 == false) goto L58;
        List<OpenPlatformPreviewVersion> r112 = v(r110.getItems(), r109.getVersionTag());
        if (r112 != r110.getItems()) goto L54;
        return r106;
    L54:
        return OpenPlatformPreviewAppVersionList.copy$default(r106, null, OpenPlatformPreviewVersionPage.copy$default(r110, r112, null, false, 6, null), 1, null);
    L58:
        return r106;
    L57:
        return r106;
    L56:
        return r106;
    L41:
        r109 = new OpenPlatformScanTarget(r108.optString("app_key"), r108.optString("version_tag"));
        goto L42
    L21:
        if (r107.f36235b == false) goto L28;
        String r113 = r107.f36236c;
        if (r113 == null) goto L28;
        OpenPlatformPreviewVersionPage r114 = r106.getFormalVersions();
        if (r114 == null) goto L28;
        List<OpenPlatformPreviewVersion> r115 = r114.getItems();
        if (r115 == null) goto L35;
        List<OpenPlatformPreviewVersion> r116 = r115;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r118 = r116.iterator();
    L33:
        if (r118.hasNext() == false) goto L36;
        OpenPlatformPreviewVersion r119 = (OpenPlatformPreviewVersion) r118.next();
        r117.add(OpenPlatformPreviewVersion.copy$default(r119, null, null, Boolean.valueOf(Intrinsics.areEqual(r119.getVersionTag(), r113)), null, null, 27, null));
    L36:
        OpenPlatformPreviewAppVersionList r120 = OpenPlatformPreviewAppVersionList.copy$default(r106, null, OpenPlatformPreviewVersionPage.copy$default(r114, r117, null, false, 6, null), 1, null);
    L37:
        com.bytedance.ai.utils.g.f37637a.i("AIDebugManager", "merge preview debug config changes with mock app version list. appKey: " + r106.getAppKey());
        r106 = r120;
        goto L38
    L35:
        r117 = null;
    L28:
        r120 = r106;
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        AIManager r121 = AIManager.f37211a;
        r102.label = 1;
        r103 = AIManager.o(r210, r211, r212, r213, r214, r215, r102);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r100 = new AIDebugManager$getPreviewAppVersionList$1(this, r216);
        goto L8
    }

    public static /* synthetic */ void l(AIDebugManager r100, String r110, boolean r111, String r112, boolean r113, Function0 r114, Function1 r115, int r116) {
        String r101 = null;
        if ((r116 & 4) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r116 & 8) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r116 & 32) == 0) goto L13;
        Function1 r104 = new m();
    L15:
        if ((r116 & 64) == 0) goto L17;
        r101 = "0";
    L17:
        r100.getClass();
        k(r110, r111, r102, r103, r114, r104, r101);
        return;
    L13:
        r104 = r115;
        goto L15
    L9:
        r103 = r113;
        goto L11
    L5:
        r102 = r112;
        goto L7
    }
}
