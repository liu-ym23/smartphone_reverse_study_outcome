package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class s {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final si2.i f149646s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.oldflash.e f149647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f149648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f149649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f149650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f149651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f149652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f149653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.oldflash.a f149654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j f149655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<? extends com.bytedance.android.livesdk.livecommerce.oldflash.b> f149656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<g> f149657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f149658l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k f149659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public k f149660n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public xi2.a f149661o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f149662p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LiveFlashViewModel f149663q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f149664r;

    public static final class a implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f149665a;

        public a(s r100) {
            this.f149665a = r100;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.oldflash.n
        public final String a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "label");
            return th.a.g(this.f149665a.getContext(), R.string.ec_live_flash_max_limit);
        }
    }

    public static final class b implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f149666a;

        public b(s r100) {
            this.f149666a = r100;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.oldflash.n
        public final String a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "label");
            return th.a.h(this.f149666a.getContext(), R.string.ec_live_flash_stock_num_input_hint, new Object[]{Integer.valueOf(r101)});
        }
    }

    public static final class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f149667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f149668b;

        @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
        public final boolean a() {
            String r100 = this.f149667a.f149626c;
            if (r100 == null) goto L5;
            Integer r101 = Integer.valueOf(r100.length());
        L6:
            int r102 = com.bytedance.android.shopping.extensions.k.f(r101);
            String r103 = this.f149668b.f149663q.getTargetName();
            if (r103 != null) goto L10;
            r103 = "";
        L10:
            if ((r102 + s.d(r103).length()) >= d.c()) goto L18;
            int r104 = com.bytedance.android.shopping.extensions.k.g(Integer.valueOf(this.f149668b.e().length()), 0);
            int r105 = d.d();
            int r106 = d.c();
            if (r105 > r104) goto L15;
            if (r106 < r104) goto L15;
            return false;
        L15:
            return true;
        L18:
            return false;
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
        public final String b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            si2.i r101 = s.f149646s;
            return th.a.h(r100, R.string.ec_live_flash_input_title_hint, new Object[]{Integer.valueOf(d.d()), Integer.valueOf(d.c())});
        }

        public c(l r100, s r101) {
            this.f149667a = r100;
            this.f149668b = r101;
        }
    }

    public static final class d {
        public static int c() {
            return ((si2.i) EComABUtils.getLiveSettingValue("flash_create_config", s.f149646s)).a();
        }

        public static int d() {
            return ((si2.i) EComABUtils.getLiveSettingValue("flash_create_config", s.f149646s)).b();
        }

        public static String a(Context r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r101 != 9999) goto L6;
            return th.a.g(r100, R.string.ec_live_flash_deposit_today);
        L6:
            return th.a.h(r100, R.string.ec_live_flash_deposit_day, new Object[]{Long.valueOf(r101)});
        }

        public static long b(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            long r102 = 0;
            if (r101 != null) goto L6;
            return 0;
        L6:
            if (Intrinsics.areEqual(r101, th.a.g(r100, R.string.ec_live_flash_deposit_today)) == false) goto L12;
            return 9999;
        L12:
            r102 = CastLongProtector.parseLong(new Regex("[^0-9]").replace(r101, ""));     // Catch: Throwable -> L11
        L10:
            return r102;
        }

        public static int e(String r100, int r101) {
            if (r100 != null) goto L10;
        L7:
            return 0;
        L10:
            String r102 = StringsKt.trim(r100).toString();     // Catch: Exception -> L9
            if (r102 == null) goto L7;
            double r103 = CastDoubleProtector.parseDouble(r102);     // Catch: Exception -> L9
            return (int) (r103 * ((double) r101));
        }
    }

    public static final class e<T> implements Comparator<T> {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((xi2.k0) r100, (xi2.k0) r101);
        }
    }

    static {
        f149646s = new si2.i();
    }

    public final Integer c() {
        List<? extends com.bytedance.android.livesdk.livecommerce.oldflash.b> r100 = this.f149656j;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.livecommerce.oldflash.b r101 = (com.bytedance.android.livesdk.livecommerce.oldflash.b) ListProtector.get(r100, 1);
    L7:
        if ((r101 instanceof k) == true) goto L9;
        r101 = null;
    L9:
        k r102 = (k) r101;
        if (r102 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf(d.e(r102.f149613g, 100));
    L5:
        r101 = null;
        goto L7
    }

    public final String e() {
        StringBuilder r100 = new StringBuilder();
        String r101 = this.f149650d.f149626c;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        String r103 = this.f149663q.getTargetName();
        if (r103 == null) goto L8;
        r100.append(d(r103));
    L8:
        String r104 = this.f149650d.f149627d;
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        r100.append(r102);
        return r100.toString();
    }

    public final Context getContext() {
        return this.f149662p;
    }

    public static String d(String r100) {
        int r101 = r100.length();
        if (r101 <= 1) goto L15;
        int r102 = 0;
        if (r101 == 2) goto L14;
        StringBuilder r103 = new StringBuilder(String.valueOf(r100.charAt(0)));
        int r104 = RangesKt.coerceAtMost(r101 - 2, 4);
    L9:
        if (r102 >= r104) goto L11;
        r103.append("*");
        r102 = r102 + 1;
        goto L9
    L11:
        r103.append(String.valueOf(r100.charAt(r101 - 1)));
        return r103.toString();
    L14:
        return String.valueOf(r100.charAt(0)) + "*";
    L15:
        return r100;
    }

    public final void f(List<? extends com.bytedance.android.livesdk.livecommerce.oldflash.b> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        StringBuilder r101 = new StringBuilder();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L18;
        com.bytedance.android.livesdk.livecommerce.oldflash.b r103 = (com.bytedance.android.livesdk.livecommerce.oldflash.b) r102.next();
        if ((r103 instanceof k) == false) goto L6;
        k r104 = (k) r103;
        xi2.k0 r105 = r104.f149612f;
        if (r105 == null) goto L6;
        if (r105 == null) goto L6;
        if (r105.d() != true) goto L6;
        if (r104.f149620n.size() > 1) goto L16;
        r101.append(r104.f149613g);
        goto L6
    L16:
        r101.append((String) CollectionsKt.first(r104.f149620n));
        goto L6
    L18:
        l r106 = this.f149650d;
        r106.f149626c = r101.toString();
    }

    public final k b(xi2.k0 r110, Map<String, ? extends List<String>> r111) {
        boolean r100 = true;
        if (r110.g() == false) goto L12;
        if (r110.h() == false) goto L8;
        String r101 = th.a.g(this.f149662p, R.string.ec_live_flash_required_select_hint);
    L15:
        String r102 = r110.getName();
        String r103 = "";
        if (r102 != null) goto L18;
        r102 = "";
    L18:
        k r104 = new k(r102, r101, !r110.h());
        r104.f149571a = r110.g();
        r104.f149612f = r110;
        r104.f149610d = Intrinsics.areEqual(th.a.g(this.f149662p, R.string.ec_live_flash_brand), r110.getName());
        r104.f149611e = r110.f();
        if (r110.g() == false) goto L70;
        String r105 = null;
        JSONArray r106 = null;
        r105 = null;
        if (Intrinsics.areEqual(th.a.g(this.f149662p, R.string.ec_live_flash_brand), r110.getName()) == false) goto L48;
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        String r112 = r110.a();
        if (r112 == null) goto L38;
        JSONObject r113 = z1.g(r112);
        if (r113 == null) goto L38;
        JSONObject r114 = r113.optJSONObject("group");
        if (r114 == null) goto L38;
        JSONArray r115 = r114.optJSONArray("本类目已有资质品牌");
        if (r115 == null) goto L38;
        if (r115.length() > 0) goto L34;
        r100 = false;
    L34:
        if (r100 == false) goto L36;
        r106 = r115;
    L36:
        if (r106 == null) goto L38;
        int r116 = JSONArrayProtectorUtils.getInt(r106, 0);
    L39:
        if (r116 <= (-1)) goto L46;
        List<String> r117 = r110.b();
        if (r117 == null) goto L47;
        String r118 = (String) CollectionsKt.getOrNull(r117, r116);
        if (r118 == null) goto L47;
        r103 = r118;
    L47:
        r104.f149619m = r103;
        List<String> r119 = CollectionsKt.listOf(r103);
    L71:
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        r104.f149620n = r119;
        Intrinsics.checkNotNullParameter(r119, "$this$toDisplayString");
        r104.f149613g = CollectionsKt.joinToString$default(r119, "，", null, null, 0, null, null, 62, null);
        return r104;
    L46:
        r103 = th.a.g(this.f149662p, R.string.ec_live_flash_no_brand);
    L38:
        r116 = -1;
        goto L39
    L48:
        if (r111 == null) goto L59;
        List<String> r120 = r111.get(r110.getName());
        if (r120 == null) goto L59;
        if ((!r120.isEmpty()) == true) goto L55;
        r120 = null;
    L55:
        if (r120 == null) goto L59;
        r119 = r120;
    L59:
        if (r110.h() == true) goto L62;
        r110 = null;
    L62:
        if (r110 == null) goto L66;
        List<String> r121 = r110.b();
        if (r121 == null) goto L66;
        r105 = (String) CollectionsKt.firstOrNull(r121);
    L66:
        if (r105 == null) goto L69;
        r103 = r105;
    L69:
        r119 = CollectionsKt.listOf(r103);
        goto L71
    L70:
        r119 = CollectionsKt.emptyList();
        goto L71
    L8:
        if (r110.d() == false) goto L10;
        r101 = th.a.h(this.f149662p, R.string.ec_live_flash_input_title_hint, new Object[]{Integer.valueOf(d.d()), Integer.valueOf(d.c())});
        goto L15
    L10:
        r101 = th.a.h(this.f149662p, R.string.ec_live_flash_required_input_hint, new Object[]{20});
        goto L15
    L12:
        if (r110.h() == false) goto L14;
        r101 = th.a.g(this.f149662p, R.string.ec_live_flash_normal_select_hint);
        goto L15
    L14:
        r101 = th.a.h(this.f149662p, R.string.ec_live_flash_normal_input_hint, new Object[]{20});
        goto L15
    }

    public s(Context r100, LiveFlashViewModel r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "imagePath");
        this.f149662p = r100;
        this.f149663q = r101;
        this.f149664r = r102;
        this.f149647a = new com.bytedance.android.livesdk.livecommerce.oldflash.e(r102);
        boolean r103 = true;
        k r104 = new k(th.a.g(r100, R.string.ec_live_flash_price), "0.00", true);
        r104.f149617k = 1;
        r104.f149571a = true;
        r104.f149615i = 100000000;
        r104.f149614h = new a(this);
        Unit r105 = Unit.INSTANCE;
        this.f149648b = r104;
        i r106 = new i(th.a.g(r100, R.string.ec_live_flash_stock));
        r106.f149617k = 0;
        r106.f149571a = true;
        r106.f149614h = new b(this);
        r106.f149615i = 1000000;
        this.f149649c = r106;
        l r107 = new l(th.a.g(r100, R.string.ec_live_flash_title));
        r107.f149628e = new c(r107, this);
        this.f149650d = r107;
        k r108 = new k(th.a.g(r100, R.string.ec_live_flash_category), th.a.g(r100, R.string.ec_live_flash_required_select_hint), false);
        r108.f149609c = true;
        r108.f149571a = true;
        this.f149651e = r108;
        this.f149652f = new k(th.a.g(r100, R.string.ec_live_flash_extra), th.a.h(r100, R.string.ec_live_flash_normal_input_hint, new Object[]{20}), true);
        this.f149653g = new f(0);
        com.bytedance.android.livesdk.livecommerce.oldflash.a r109 = new com.bytedance.android.livesdk.livecommerce.oldflash.a(th.a.g(r100, R.string.ec_live_flash_sku_barcode), th.a.g(r100, R.string.ec_live_flash_sku_barcode_hint));
        r109.f149571a = false;
        if (r101.getBarCodeState() == 1) goto L6;
        r103 = false;
    L6:
        r109.f149569q = r103;
        r109.f149616j = 4;
        r109.f149617k = 3;
        this.f149654h = r109;
        r101.setFlashHelper(this);
    }

    public final List<com.bytedance.android.livesdk.livecommerce.oldflash.b> a(String r210, xi2.v r211, boolean r212) {
        boolean r100 = false;
        if (r211 == null) goto L21;
        List<xi2.k0> r101 = r211.d();
        if (r101 == null) goto L21;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L20;
        Object r104 = r103.next();
        xi2.k0 r105 = (xi2.k0) r104;
        if (r105.h() == false) goto L17;
        List<String> r106 = r105.b();
        if (r106 != null) goto L14;
    L16:
        boolean r107 = false;
    L18:
        if (r107 == false) goto L8;
        r102.add(r104);
        goto L8
    L14:
        if ((!r106.isEmpty()) != true) goto L16;
    L17:
        r107 = true;
        goto L18
    L20:
        List r108 = CollectionsKt.sortedWith(r102, new e());
    L22:
        if (r211 == null) goto L24;
        int r109 = r211.h();
    L26:
        if (r211 == null) goto L36;
        Integer r110 = Integer.valueOf(r211.g());
        if (r110.intValue() <= 0) goto L30;
        boolean r111 = true;
    L31:
        if (r111 == true) goto L34;
        r110 = null;
    L34:
        if (r110 == null) goto L36;
        int r112 = r110.intValue();
    L37:
        if (r211 == null) goto L39;
        final xi2.d r113 = r211.c();
    L40:
        if (r211 == null) goto L42;
        List<xi2.j0> r114 = r211.f();
    L43:
        this.f149651e.f149613g = r210;
        if (r212 == true) goto L46;
    L50:
        final Map<String, ? extends List<String>> r115 = null;
    L51:
        i r116 = this.f149649c;
        r116.f149615i = r112;
        if (r112 != 1000000) goto L54;
        Intrinsics.checkNotNullParameter("0", "<set-?>");
        r116.f149621o = "0";
    L55:
        ArrayList r117 = new ArrayList();
        r117.add(this.f149647a);
        if (r113 != null) goto L58;
    L59:
        r117.add(this.f149648b);
    L60:
        r117.add(this.f149649c);
        r117.add(this.f149651e);
        if (r108 == null) goto L74;
        Iterator r118 = r108.iterator();
        boolean r119 = false;
    L64:
        if (r118.hasNext() == false) goto L75;
        xi2.k0 r120 = (xi2.k0) r118.next();
        if (r120.g() == false) goto L64;
        if (r120.d() == true) goto L73;
        if (r119 == true) goto L73;
        if (r120.c() == 1687) goto L73;
        r117.add(this.f149650d);
        r119 = true;
    L73:
        r117.add(b(r120, r115));
    L75:
        if (r119 == true) goto L78;
        r117.add(this.f149650d);
    L78:
        if (this.f149663q.isNeedBarCode() == false) goto L80;
        r117.add(this.f149654h);
    L80:
        String r121 = "default";
        if (r113 != null) goto L83;
    L100:
        this.f149656j = null;
        if (r211 == null) goto L139;
        final xi2.c r122 = r211.b();
        if (r122 == null) goto L139;
        k r123 = new k(th.a.g(this.f149662p, R.string.ec_live_flash_deposit_item_deliver_label), th.a.g(this.f149662p, R.string.ec_live_flash_required_select_hint), false);
        r123.f149571a = true;
        r123.f149618l = new LiveFlashHelper$createDeliveryDelayTimeRuleData$$inlined$apply$lambda$1(this, r122, r115);
        xi2.k0 r124 = new xi2.k0();
        r124.i(th.a.g(this.f149662p, R.string.ec_live_flash_deposit_item_deliver_label));
        List<Long> r125 = r122.a();
        if (r125 == null) goto L111;
        List<Long> r126 = r125;
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        Iterator<T> r128 = r126.iterator();
    L108:
        if (r128.hasNext() == false) goto L110;
        r127.add(d.a(this.f149662p, ((Number) r128.next()).longValue()));
        r121 = r121;
        goto L108
    L110:
        String r213 = r121;
    L112:
        r124.l(r127);
        List<Long> r129 = r122.a();
        if (r129 == null) goto L118;
        List<Long> r130 = r129;
        ArrayList r131 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r130, 10));
        Iterator<T> r132 = r130.iterator();
    L116:
        if (r132.hasNext() == false) goto L119;
        r131.add(String.valueOf(((Number) r132.next()).longValue()));
    L119:
        r124.o(r131);
        r124.m();
        r124.n();
        Unit r133 = Unit.INSTANCE;
        r123.f149612f = r124;
        if (r115 == null) goto L126;
        List<String> r134 = r115.get(r123.f149573b);
        if (r134 == null) goto L126;
        String r135 = (String) CollectionsKt.first(r134);
        if (r135 == null) goto L126;
        String r136 = r213;
        Intrinsics.checkNotNullParameter("", r136);
    L128:
        if (com.bytedance.android.shopping.extensions.k.c(r135) == false) goto L130;
        r123.f149613g = r135;
    L138:
        this.f149659m = r123;
        r117.add(r123);
    L140:
        if (r211 == null) goto L175;
        xi2.a r137 = r211.a();
        if (r137 == null) goto L175;
        this.f149661o = r137;
        k r138 = new k(th.a.g(this.f149662p, R.string.ec_live_flash_returns), th.a.g(this.f149662p, R.string.ec_live_flash_required_select_hint), false);
        r138.f149571a = true;
        final xi2.l0 r139 = r137.a();
        if (r139 == null) goto L173;
        r138.f149618l = new LiveFlashHelper$createAfterSellRuleReturnData$1$1$1(r139);
        List<String> r140 = r139.b();
        if (r140 == null) goto L173;
        xi2.k0 r141 = new xi2.k0();
        r141.i(th.a.g(this.f149662p, R.string.ec_live_flash_returns));
        r141.l(r140);
        r141.m();
        r141.n();
        r141.o(r139.a());
        Unit r142 = Unit.INSTANCE;
        r138.f149612f = r141;
        if (r115 == null) goto L154;
        List<String> r143 = r115.get(r138.f149573b);
        if (r143 == null) goto L154;
        String r144 = (String) CollectionsKt.first(r143);
        if (r144 == null) goto L154;
        Intrinsics.checkNotNullParameter("", r136);
    L156:
        if (com.bytedance.android.shopping.extensions.k.c(r144) == true) goto L169;
        List<String> r145 = r139.a();
        if (r145 == null) goto L161;
        Integer r146 = Integer.valueOf(r145.indexOf("7-1"));
    L162:
        int r147 = com.bytedance.android.shopping.extensions.k.g(r146, 0);
        if (r140.isEmpty() == false) goto L165;
        r144 = "";
        goto L169
    L165:
        if (r147 >= 0) goto L167;
    L170:
        String r148 = (String) ListProtector.get(r140, r140.size() - 1);
    L171:
        r138.f149613g = r148;
        goto L173
    L167:
        if (r147 >= r140.size()) goto L170;
        r144 = (String) ListProtector.get(r140, r147);
        goto L169
    L161:
        r146 = null;
    L169:
        r148 = r144;
    L154:
        r144 = null;
    L173:
        this.f149660n = r138;
        Unit r149 = Unit.INSTANCE;
        r117.add(r138);
    L175:
        ArrayList r150 = new ArrayList();
        if (r114 == null) goto L203;
        Iterator<T> r151 = r114.iterator();
        boolean r152 = true;
    L179:
        if (r151.hasNext() == false) goto L203;
        xi2.j0 r153 = (xi2.j0) r151.next();
        String r154 = r153.c();
        String r155 = r153.b();
        if (r154 != null) goto L183;
    L186:
        boolean r156 = true;
    L187:
        if (r156 == true) goto L200;
        if (r155 != null) goto L190;
    L193:
        boolean r157 = true;
    L194:
        if (r157 == true) goto L200;
        if (r152 == false) goto L198;
        String r158 = th.a.g(this.f149662p, R.string.ec_live_flash_privileges);
    L199:
        g r159 = new g(r158, r154, r155);
        r159.f149584c = r153.a();
        r159.f149585d = r153.f();
        r159.f149586e = r153.e();
        r159.f149587f = r153.d();
    L201:
        if (r159 == null) goto L179;
        r150.add(r159);
        r152 = false;
        goto L179
    L198:
        r158 = "";
        goto L199
    L190:
        if (r155.length() == 0) goto L193;
        r157 = false;
    L200:
        r159 = null;
        goto L201
    L183:
        if (r154.length() == 0) goto L186;
        r156 = false;
    L203:
        this.f149657k = r150;
        r117.addAll(r150);
        r117.add(this.f149653g);
        if (r108 == null) goto L211;
        Iterator r160 = r108.iterator();
    L207:
        if (r160.hasNext() == false) goto L211;
        xi2.k0 r161 = (xi2.k0) r160.next();
        if (r161.g() == true) goto L207;
        r117.add(b(r161, r115));
    L211:
        if (r109 <= 0) goto L216;
        j r162 = this.f149655i;
        if (r162 != null) goto L215;
        r162 = new j(th.a.g(this.f149662p, R.string.ec_live_flash_stock_reduction_label), r109);
        this.f149655i = r162;
        Unit r163 = Unit.INSTANCE;
    L215:
        r117.add(r162);
    L216:
        j r164 = this.f149655i;
        if (r164 == null) goto L219;
        r164.f149598d = r109;
    L219:
        if (r164 == null) goto L223;
        if (r109 <= 0) goto L222;
        r100 = true;
    L222:
        r164.f149597c = r100;
    L223:
        r117.add(this.f149652f);
        f(r117);
        return r117;
    L130:
        List<Long> r165 = r122.a();
        if (r165 == null) goto L138;
        if ((!r165.isEmpty()) == true) goto L136;
        r165 = null;
    L136:
        if (r165 == null) goto L138;
        r123.f149613g = d.a(this.f149662p, ((Number) CollectionsKt.last(r165)).longValue());
    L126:
        r136 = r213;
        r135 = null;
        goto L128
    L118:
        r131 = null;
        goto L119
    L111:
        r213 = "default";
        r127 = null;
    L139:
        r136 = "default";
        goto L140
    L83:
        if (r113.e() != true) goto L100;
        com.bytedance.android.livesdk.livecommerce.oldflash.b[] r166 = new com.bytedance.android.livesdk.livecommerce.oldflash.b[4];
        r166[0] = new h(th.a.g(this.f149662p, R.string.ec_live_flash_deposit_section_label), th.a.g(this.f149662p, R.string.ec_live_flash_deposit_section_hint_highlight), th.a.g(this.f149662p, R.string.ec_live_flash_deposit_section_hint_not_highlight));
        k r167 = new k(th.a.g(this.f149662p, R.string.ec_live_flash_deposit_item_price_label), th.a.g(this.f149662p, R.string.ec_live_flash_deposit_item_price_hint), true);
        r167.f149571a = true;
        r167.f149617k = 0;
        r167.f149615i = 1000000;
        r167.f149614h = new t(this);
        r167.f149616j = 1;
        Unit r168 = Unit.INSTANCE;
        r166[1] = r167;
        if (r113.f() == false) goto L90;
        String r169 = r113.b();
        if (r169 != null) goto L89;
        r169 = "";
    L89:
        com.bytedance.android.livesdk.livecommerce.oldflash.d r170 = new com.bytedance.android.livesdk.livecommerce.oldflash.d(r169);
        r170.f149571a = true;
        com.bytedance.android.livesdk.livecommerce.oldflash.b r171 = r170;
    L91:
        r166[2] = r171;
        k r172 = new k(th.a.g(this.f149662p, R.string.ec_live_flash_deposit_item_deliver_label), th.a.g(this.f149662p, R.string.ec_live_flash_required_select_hint), false);
        r172.f149571a = true;
        r172.f149618l = new LiveFlashHelper$createDepositList$$inlined$apply$lambda$3(this, r113);
        List<Long> r173 = r113.a();
        if (r173 != null) goto L94;
    L99:
        r166[3] = r172;
        List<? extends com.bytedance.android.livesdk.livecommerce.oldflash.b> r174 = CollectionsKt.listOf(r166);
        this.f149656j = r174;
        r117.addAll(r174);
        goto L139
    L94:
        if ((!r173.isEmpty()) == true) goto L97;
        r173 = null;
    L97:
        if (r173 == null) goto L99;
        r172.f149613g = d.a(this.f149662p, ((Number) CollectionsKt.last(r173)).longValue());
        goto L99
    L90:
        k r175 = new k(th.a.g(this.f149662p, R.string.ec_live_flash_deposit_item_time_label), th.a.g(this.f149662p, R.string.ec_live_flash_required_select_hint), false);
        r175.f149571a = true;
        r175.f149618l = new LiveFlashHelper$createDepositList$$inlined$apply$lambda$2(this, r113);
        r175.f149613g = d.a(this.f149662p, r113.c());
        r171 = r175;
        goto L91
    L74:
        r119 = false;
        goto L75
    L58:
        if (r113.e() == true) goto L60;
    L54:
        String r176 = th.a.h(this.f149662p, R.string.ec_live_flash_stock_limit_hint, new Object[]{Integer.valueOf(r112)});
        Intrinsics.checkNotNullParameter(r176, "<set-?>");
        r116.f149621o = r176;
        goto L55
    L46:
        if (this.f149658l == true) goto L50;
        if (this.f149663q.isCategoryChanged() == true) goto L50;
        r115 = this.f149663q.getProperties();
        this.f149658l = true;
        goto L51
    L42:
        r114 = null;
        goto L43
    L39:
        r113 = null;
        goto L40
    L30:
        r111 = false;
    L36:
        r112 = 1000000;
        goto L37
    L24:
        r109 = 0;
    L21:
        r108 = null;
        goto L22
    }
}
