package com.bytedance.android.shopping.anchorv4.perf.preload;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import androidx.collection.LruCache;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.utils.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpPreloadDataManager implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PdpPreloadDataManager f167292c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<com.bytedance.android.shopping.anchorv4.perf.preload.a, PackParsedDTO> f167293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<com.bytedance.android.shopping.anchorv4.perf.preload.a> f167294b;

    public static final class a implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpPreloadDataManager f167295a;

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
            Intrinsics.checkNotNullParameter(r100, "newConfig");
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
            PdpPreloadDataManager r100 = this.f167295a;
            int r101 = r100.f167293a.maxSize() / 2;
            monitor-enter(r100);
            r100.f167293a.trimToSize(r101);     // Catch: Throwable -> L7
            monitor-exit(r100);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public a(PdpPreloadDataManager r100) {
            this.f167295a = r100;
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r100) {
            PdpPreloadDataManager r101 = this.f167295a;
            int r102 = r101.f167293a.maxSize() / 2;
            monitor-enter(r101);
            r101.f167293a.trimToSize(r102);     // Catch: Throwable -> L7
            monitor-exit(r101);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static final class b {
    }

    static {
        g r100 = g.f167320b;
        if (r100 != null) goto L5;
    L7:
        PdpPreloadDataManager r101 = null;
    L8:
        f167292c = r101;
        return;
    L5:
        if (r100.b() != true) goto L7;
        r101 = new PdpPreloadDataManager();
        goto L8
    }

    public PdpPreloadDataManager() {
        String r100 = g.f167319a;
        g r101 = g.f167320b;
        if (r101 == null) goto L7;
        Integer r102 = r101.e();
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L8:
        this.f167293a = new LruCache(r103);
        this.f167294b = new LinkedHashSet();
        Context r104 = ECAppInfoService.f48114e.getApplicationContext();
        if (r104 == null) goto L12;
        r104.registerComponentCallbacks(new a(this));
        return;
    L12:
        return;
    L7:
        r103 = 10;
        goto L8
    }

    public static p d(String r100) {
        int r101 = y.f187160a;
        boolean r102 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        p r104 = new e();
    L17:
        if (r104 == null) goto L20;
        r104.parse(r100);
        return r104;
    L20:
        return null;
    L10:
        if (r100 != null) goto L12;
    L14:
        if (r102 == false) goto L16;
        r104 = new f();
        goto L17
    L16:
        r104 = null;
        goto L17
    L12:
        if (StringsKt.startsWith$default(r100, "sslocal://ec_goods_detail", false, 2, null) != true) goto L14;
        r102 = true;
        goto L14
    L5:
        if (StringsKt.startsWith$default(r100, "sslocal://ec_goods_pdp", false, 2, null) != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.perf.preload.c
    public final void a(final String r100, final List<ca3.d> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "list");
        Lazy r102 = UIUtils.f45548a;
        if (UIUtils.d() == false) goto L5;
        b2.b(new PdpPreloadDataManager$tryPreload$1(this, r100, r101));
        return;
    L5:
        e(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(String r110, List<ca3.d> r111) {
        ArrayList r100 = new ArrayList();
        int r101 = r111.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L50;
        ca3.d r103 = (ca3.d) CollectionsKt.getOrNull(r111, r102);
        if (r103 == null) goto L45;
        String r104 = r103.f22932b;
        String r105 = r103.f22933c;
        Object r112 = null;
        String r106 = r105;
        r106 = r105;
        if (r104 != null) goto L17;
        if (r105 != null) goto L17;
        p r107 = d(r103.f22931a);
        if (r107 == null) goto L13;
        String r108 = r107.getPromotionId();
    L14:
        if (r107 == null) goto L16;
        r112 = r107.getProductId();
    L16:
        Object r113 = r112;
        r112 = r107;
        r104 = r108;
        r106 = r113;
        goto L17
    L13:
        r108 = null;
    L17:
        if (r104 != null) goto L20;
        if (r106 == 0) goto L45;
    L20:
        com.bytedance.android.shopping.anchorv4.perf.preload.a r114 = new com.bytedance.android.shopping.anchorv4.perf.preload.a(r104, r106, r110);
        Set<com.bytedance.android.shopping.anchorv4.perf.preload.a> r115 = this.f167294b;
        monitor-enter(r115);
        boolean r116 = true;
        if (this.f167294b.contains(r114) == true) goto L25;
        this.f167294b.add(r114);     // Catch: Throwable -> L46
        boolean r117 = true;
    L26:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L46
        monitor-exit(r115);
        if (r117 == true) goto L30;
    L35:
        r116 = false;
    L36:
        if (r116 == true) goto L45;
        Set<com.bytedance.android.shopping.anchorv4.perf.preload.a> r109 = this.f167294b;
        monitor-enter(r109);
        this.f167294b.remove(r114);     // Catch: Throwable -> L42
        monitor-exit(r109);
    L42:
        th = move-exception;
        throw th;
    L30:
        if (c(r110, r106, r104) != null) goto L35;
        if (r112 != null) goto L33;
        r112 = d(r103.f22931a);
    L33:
        if (r112 == null) goto L35;
        r100.add(r112);
        goto L36
    L25:
        r117 = false;
    L46:
        th = move-exception;
        throw th;
    L45:
        r102 = r102 + 1;
        goto L3
    L50:
        if (r100.size() <= 0) goto L77;
        PreloadApi.a r119 = PreloadApi.f167304a;
        p r120 = (p) CollectionsKt.getOrNull(r100, 0);
        if (r120 == null) goto L56;
        Boolean r121 = r120.a();
        if (r121 == null) goto L56;
        r121.booleanValue();
    L56:
        LinkedHashMap r122 = new LinkedHashMap();
        r122.put("is_short_screen", String.valueOf(com.bytedance.android.shopping.anchorv3.detail.utils.a.a()));
        int r123 = com.bytedance.android.shopping.anchorv4.params.a.f167177a;
        r122.put(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS, com.bytedance.android.shopping.anchorv4.params.a.C2524a.a());
        r122.put("preload_config", g.f167319a);
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r125 = r100.iterator();
    L58:
        if (r125.hasNext() == false) goto L63;
        Map<String, String> r126 = ((p) r125.next()).b();
        if (r126 != null) goto L62;
        r126 = MapsKt.emptyMap();
    L62:
        r124.add(r126);
        goto L58
    L63:
        r122.put("product_list", com.bytedance.android.ec.hybrid.list.util.k.d(r124));
        r119.getClass();
        Intrinsics.checkNotNullParameter(r122, "params");
        PreloadApi.a.f167305a.fetchPreloadMultiData(r122).subscribe(new i(this, r110, r100), new j(this, r100, r110));
        return;
    }

    public final synchronized PackParsedDTO c(String r100, String r101, String r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "scene");     // Catch: Throwable -> L22
        boolean r103 = false;
        if (r102 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L19;
        if (r101 != null) goto L13;
    L14:
        r103 = true;
    L15:
        if (r103 == false) goto L19;
        monitor-exit(this);
        return null;
    L13:
        if (r101.length() != 0) goto L15;
    L19:
        PackParsedDTO r105 = this.f167293a.get(new com.bytedance.android.shopping.anchorv4.perf.preload.a(r102, r101, r100));     // Catch: Throwable -> L22
        monitor-exit(this);
        return r105;
    L6:
        if (r102.length() == 0) goto L9;
        r104 = false;
    L22:
        th = move-exception;
        throw th;
    }

    public static final void b(PdpPreloadDataManager r100, String r101, String r102, String r103, PackParsedDTO r104) {
        monitor-enter(r100);
        boolean r105 = true;
        if (r102 != null) goto L27;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == false) goto L19;
        if (r103 != null) goto L15;
    L18:
        if (r105 == false) goto L19;
    L20:
        monitor-exit(r100);
        return;
    L15:
        if (r103.length() == 0) goto L18;
        r105 = false;
    L19:
        if (r104 == null) goto L20;
        r100.f167293a.put(new com.bytedance.android.shopping.anchorv4.perf.preload.a(r103, r102, r101), r104);     // Catch: Throwable -> L9
        monitor-exit(r100);
        return;
    L9:
        th = move-exception;
        throw th;
    L27:
        if (r102.length() == 0) goto L11;
        r106 = false;
        goto L12
    }
}
