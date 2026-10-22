package com.bytedance.android.annie.pia;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.param.k;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.services.IPiaLifeCycleService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o7.l;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c47.c f39722a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f39724b;

        public a(String r100, String r101) {
            this.f39723a = r100;
            this.f39724b = r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.pia.b$b, reason: collision with other inner class name */
    public static final class C0739b implements l47.b<Map<String, ?>> {
        public C0739b() {
        }

        @Override // l47.b
        public final Map<String, ?> create() {
            return a(null);
        }

        public final Map<String, ?> a(Object r100) {
            String r101 = null;
            if ((r100 instanceof a) == false) goto L5;
            a r102 = (a) r100;
        L6:
            Context r103 = c47.c.a.f22405a;
            if (r102 == null) goto L9;
            String r104 = r102.f39723a;
        L10:
            if (r102 == null) goto L12;
            r101 = r102.f39724b;
        L12:
            k r105 = com.bytedance.android.annie.a.a(r103, r104, false, r101, "host");
            LinkedHashMap r106 = new LinkedHashMap();
            r106.putAll(com.bytedance.android.annie.param.b.b(r105));
            return r106;
        L9:
            r104 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }

        @Override // l47.b
        public final /* bridge */ /* synthetic */ Map<String, ?> create(Object r100) {
            return a(r100);
        }
    }

    public static final class c<T> implements l47.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f39725a = null;

        static {
            f39725a = new c();
        }

        public c() {
        }

        @Override // l47.b
        public final Object create() {
            return new PiaResourceLoader();
        }

        @Override // l47.b
        public final Object create(Object r100) {
            return create();
        }
    }

    public static final class d<T> implements l47.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f39726a = null;

        static {
            f39726a = new d();
        }

        public d() {
        }

        @Override // l47.b
        public final Object create() {
            return l.b(new StringBuilder());
        }

        @Override // l47.b
        public final Object create(Object r100) {
            return create();
        }
    }

    static {
        c47.c r100 = new c47.c();
        r100.f22396a = ILiveHybridMonitor.ContainerType.ANNIE;
        r100.f22402g = new C0739b();
        r100.f22398c = c.f39725a;
        r100.f22397b = d.f39726a;
        f39722a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    @JvmStatic
    public static final boolean a(String r100, com.bytedance.android.annie.param.a r101) {
        Intrinsics.checkNotNullParameter(r101, "annieContext");
        IPiaLifeCycleService r102 = k47.c.a();
        if (r102 == null) goto L5;
        ?? r103 = r102.a(r100);
    L6:
        String r104 = r101.getMonitorID();
        if (r104 == null) goto L9;
        ((k9.e) Annie.getService(k9.e.class, r101.getBizKey())).V0().a(r104, "is_pia", r103);
    L9:
        return r103;
    L5:
        r103 = 0;
        goto L6
    }

    public static void b(String r100, String r101, String r110, com.bytedance.android.annie.param.a r111) {
        Intrinsics.checkNotNullParameter(r111, "annieContext");
        if (r101 != null) goto L6;
        return;
    L6:
        if (a(r101, r111) == true) goto L9;
        return;
    L9:
        if (r100 == null) goto L47;
        Iterator<T> r102 = AnnieConfigSettingKeys.LIVE_SKIP_PIA_WARMUP.a().iterator();
    L12:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        if (StringsKt.contains$default(r101, (String) r103, false, 2, null) == false) goto L12;
    L17:
        boolean r104 = true;
        if (r103 == null) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == false) goto L47;
        ConcurrentHashMap<Integer, s9.f> r106 = s9.a.f541022a;
        String r112 = r111.getBizKey();
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r112, "bizKey");
        com.bytedance.android.annie.ng.a r107 = g.f39671c.get(r112);
        if (r107 == null) goto L29;
        o8.g r108 = r107.f39646d;
        if (r108 == null) goto L29;
        if (r108.f522333b == true) goto L29;
    L30:
        if (r104 == true) goto L43;
        Uri r109 = UriProtector.parse(r100);
        String r113 = UriProtector.getQueryParameter(r109, "url");
        if (r113 == null) goto L43;
        String r114 = UriProtector.getQueryParameter(r109, "prerender_cache_key");
        Uri r115 = UriProtector.parse(r113);     // Catch: Exception -> L42
        StringBuilder r116 = new StringBuilder();     // Catch: Exception -> L42
        r116.append(r115.getScheme());     // Catch: Exception -> L42
        r116.append(':');     // Catch: Exception -> L42
        if (r115.getPort() != (-1)) goto L39;
        Object r117 = "";
    L40:
        r116.append(r117);     // Catch: Exception -> L42
        r116.append("//");     // Catch: Exception -> L42
        r116.append(r115.getHost());     // Catch: Exception -> L42
        r116.append(r115.getPath());     // Catch: Exception -> L42
        boolean r118 = s9.a.d(r112, r116.toString() + '_' + r114);
    L44:
        if (r118 == false) goto L47;
        int r119 = x8.a.f562881a;
        x8.a.d("PiaCore", r101.concat(" is in skip list and has prerenderCard, skip warmup"), false);
        return;
    L39:
        r117 = Integer.valueOf(r115.getPort());     // Catch: Exception -> L42
    L42:
        int r120 = x8.a.f562881a;
        x8.a.b(Annie.ANNIE_TAG, "解析schema种的url失败:".concat(r100), false);
    L43:
        r118 = false;
    L29:
        r104 = false;
        goto L30
    L20:
        r105 = false;
        goto L21
    L16:
        r103 = null;
    L47:
        IPiaLifeCycleService r121 = k47.c.a();
        if (r121 == null) goto L58;
        if (r110 != null) goto L51;
        r110 = "";
    L51:
        String r122 = l.c(r101, null, r110);
        r121.c(r122, ILiveHybridMonitor.ContainerType.ANNIE, new a(r100, r122));
        return;
    }
}
