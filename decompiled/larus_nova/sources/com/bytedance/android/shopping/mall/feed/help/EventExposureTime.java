package com.bytedance.android.shopping.mall.feed.help;

import android.graphics.Rect;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.CardBusinessType;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.mall.feed.holder.ECMallFeedTitleViewHolder;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class EventExposureTime implements k, l, g {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f176912q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<BaseViewHolder> f176913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f176914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f176915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f176916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f176917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f176918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f176919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f176920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f176921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<BaseViewHolder, Boolean> f176922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<BaseViewHolder> f176923k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f176924l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f176925m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f176926n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a.C2622a f176927o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<String> f176928p;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.help.EventExposureTime$a$a, reason: collision with other inner class name */
        public static final class C2622a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f176929a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f176930b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final CoroutineScope f176931c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final q f176932d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final ECHybridRecyclerView f176933e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final boolean f176934f;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C2622a) == false) goto L18;
                C2622a r101 = (C2622a) r100;
                if (Intrinsics.areEqual(this.f176929a, r101.f176929a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f176930b, r101.f176930b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.f176931c, r101.f176931c) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f176932d, r101.f176932d) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.f176933e, r101.f176933e) == true) goto L16;
                return false;
            L16:
                if (this.f176934f == r101.f176934f) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public final int hashCode() {
                String r100 = this.f176929a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.f176930b;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                CoroutineScope r107 = this.f176931c;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                q r110 = this.f176932d;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                ECHybridRecyclerView r113 = this.f176933e;
                if (r113 == null) goto L21;
                r101 = r113.hashCode();
            L21:
                int r114 = (r112 + r101) * 31;
                boolean r115 = this.f176934f;
                ?? r116 = r115;
                if (r115 == false) goto L25;
                r116 = 1;
            L25:
                return r114 + r116;
            L17:
                r111 = 0;
                goto L18
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "ExposureTimeContext(pageName=" + this.f176929a + ", btm=" + this.f176930b + ", scope=" + this.f176931c + ", shelterHelp=" + this.f176932d + ", recyclerView=" + this.f176933e + ", isNestScene=" + this.f176934f + ")";
            }

            public C2622a(String r100, String r101, CoroutineScope r102, q r103, ECHybridRecyclerView r104, boolean r105) {
                Intrinsics.checkNotNullParameter(r100, "pageName");
                Intrinsics.checkNotNullParameter(r101, "btm");
                Intrinsics.checkNotNullParameter(r102, "scope");
                this.f176929a = r100;
                this.f176930b = r101;
                this.f176931c = r102;
                this.f176932d = r103;
                this.f176933e = r104;
                this.f176934f = r105;
            }
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.g
    public final void k(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.l
    public final void b() {
        if (this.f176927o.f176934f == false) goto L5;
        h();
        return;
    L5:
        r();
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.k
    public final void d() {
        if (this.f176927o.f176934f == false) goto L5;
        h();
        return;
    L5:
        r();
    }

    public final void h() {
        Iterator<T> r100 = this.f176913a.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        ECHybridListItemVO r101 = ((BaseViewHolder) r100.next()).f47152c;
        if (r101 == null) goto L4;
        r101.m();
        goto L4
    }

    public final void p() {
        ArrayList r100 = new ArrayList();
        if (this.f176927o.f176934f == false) goto L5;
        Set<BaseViewHolder> r101 = this.f176913a;
    L6:
        r100.addAll(r101);
        LinkedHashMap r102 = new LinkedHashMap();
        r102.putAll(this.f176922j);
        this.f176923k.clear();
        Iterator<T> r103 = this.f176913a.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        BaseViewHolder r104 = (BaseViewHolder) r103.next();
        if (this.f176922j.containsKey(r104) == false) goto L8;
        this.f176922j.put(r104, Boolean.FALSE);
        goto L8
    L12:
        BuildersKt.launch$default(this.f176927o.f176931c, Dispatchers.getDefault(), null, new EventExposureTime$reportAllCardExposure$2(this, r100, r102, null), 2, null);
        return;
    L5:
        r101 = this.f176923k;
        goto L6
    }

    public final void r() {
        Iterator<T> r100 = this.f176913a.iterator();
    L4:
        if (r100.hasNext() == false) goto L26;
        BaseViewHolder r101 = (BaseViewHolder) r100.next();
        if ((r101 instanceof ECMallFeedTitleViewHolder) == true) goto L4;
        if (this.f176923k.contains(r101) == true) goto L4;
        if (this.f176913a.contains(r101) == false) goto L4;
        if (r101.f47152c == null) goto L4;
        if (r101.itemView.getLocalVisibleRect(this.f176926n) == false) goto L4;
        if (this.f176923k.isEmpty() == false) goto L22;
        this.f176914b = System.currentTimeMillis();
    L22:
        ECHybridListItemVO r102 = r101.f47152c;
        if (r102 == null) goto L25;
        r102.m();
    L25:
        this.f176923k.add(r101);
        this.f176922j.put(r101, Boolean.TRUE);
        goto L4
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.l
    public final void a() {
        p();
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.k
    public final void c() {
        p();
    }

    public static final String e(EventExposureTime r100) {
        if (r100.f176927o.f176930b.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L11;
        a.C2622a r102 = r100.f176927o;
        String r103 = r100.f176928p.invoke();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f176930b = r103;
        return r100.f176927o.f176930b + "c0.d0";
    L11:
        return r100.f176927o.f176930b + "c0.d0";
    L5:
        r101 = false;
        goto L7
    }

    public static boolean m(ECHybridListItemVO r100) {
        ECNAMallCardExtra r101 = r100.c();
        if (r101 == null) goto L7;
        CardBusinessType r102 = r101.getCardBusinessType();
        if (r102 == null) goto L7;
        Boolean r103 = r102.isAd();
    L9:
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L7:
        r103 = null;
        goto L9
    }

    public static boolean n(ECHybridListItemVO r100) {
        ECNAMallCardExtra r101 = r100.c();
        if (r101 == null) goto L7;
        CardBusinessType r102 = r101.getCardBusinessType();
        if (r102 == null) goto L7;
        Boolean r103 = r102.isLife();
    L9:
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L7:
        r103 = null;
        goto L9
    }

    public static boolean o(ECHybridListItemVO r100) {
        ECNAMallCardExtra r101 = r100.c();
        if (r101 == null) goto L7;
        CardBusinessType r102 = r101.getCardBusinessType();
        if (r102 == null) goto L7;
        Boolean r103 = r102.isLive();
    L9:
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L7:
        r103 = null;
        goto L9
    }

    public final JSONObject i(BaseViewHolder r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L85
        if (r110.f47152c != null) goto L7;
        return null;
    L7:
        if (r110.getLayoutPosition() < 0) goto L9;
    L11:
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L85
        ECHybridListItemVO r102 = r110.f47152c;     // Catch: Throwable -> L85
        if (r102 != null) goto L14;
    L84:
        return r101;
    L14:
        if (r110.getAdapterPosition() <= 0) goto L16;
        int r103 = r110.getAdapterPosition();     // Catch: Throwable -> L85
    L17:
        com.bytedance.android.ec.hybrid.list.entity.n r104 = r102.f47041o;     // Catch: Throwable -> L85
        String r111 = "";
        if (r104 == null) goto L65;
        List<com.bytedance.android.ec.hybrid.list.entity.c> r105 = r104.f47141c;     // Catch: Throwable -> L85
        if (r105 == null) goto L65;
        Iterator<T> r106 = r105.iterator();     // Catch: Throwable -> L85
        String r112 = "";
        String r113 = r112;
    L24:
        if (r106.hasNext() == false) goto L64;
        com.bytedance.android.ec.hybrid.list.entity.c r114 = (com.bytedance.android.ec.hybrid.list.entity.c) r106.next();     // Catch: Throwable -> L85
        if (Intrinsics.areEqual(r114.f47071a, "show_ecom_card") == false) goto L24;
        Map<String, Object> r107 = r114.f47072b;     // Catch: Throwable -> L85
        if (r107 == null) goto L30;
        Object r108 = r107.get(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE);     // Catch: Throwable -> L85
    L32:
        if ((r108 instanceof String) == true) goto L34;
        r108 = null;
    L34:
        String r109 = (String) r108;     // Catch: Throwable -> L85
        if (r109 != null) goto L37;
        r113 = "";
    L38:
        Map<String, Object> r115 = r114.f47072b;     // Catch: Throwable -> L85
        if (r115 == null) goto L41;
        Object r116 = r115.get("btm");     // Catch: Throwable -> L85
    L43:
        if ((r116 instanceof String) == true) goto L45;
        r116 = null;
    L45:
        String r117 = (String) r116;     // Catch: Throwable -> L85
        if (r117 != null) goto L48;
        r112 = "";
    L50:
        if (r112.length() != 0) goto L52;
        boolean r118 = true;
    L53:
        if (r118 == false) goto L24;
        Map<String, Object> r119 = r114.f47074d;     // Catch: Throwable -> L85
        if (r119 == null) goto L57;
        Object r120 = r119.get("btm");     // Catch: Throwable -> L85
    L59:
        if ((r120 instanceof String) == true) goto L61;
        r120 = null;
    L61:
        r112 = (String) r120;     // Catch: Throwable -> L85
        if (r112 != null) goto L24;
        r112 = "";
        goto L24
    L57:
        r120 = null;
        goto L59
    L52:
        r118 = false;
        goto L53
    L48:
        r112 = r117;
        goto L50
    L41:
        r116 = null;
        goto L43
    L37:
        r113 = r109;
        goto L38
    L30:
        r108 = null;
        goto L32
    L64:
        r111 = r112;
    L67:
        if (this.f176927o.f176930b.length() != 0) goto L69;
        boolean r121 = true;
    L70:
        if (r121 == false) goto L72;
        a.C2622a r122 = this.f176927o;     // Catch: Throwable -> L85
        String r123 = this.f176928p.invoke();     // Catch: Throwable -> L85
        r122.getClass();     // Catch: Throwable -> L85
        Intrinsics.checkNotNullParameter(r123, "<set-?>");     // Catch: Throwable -> L85
        r122.f176930b = r123;     // Catch: Throwable -> L85
    L72:
        r101.putOpt("page_name", this.f176927o.f176929a);     // Catch: Throwable -> L85
        r101.putOpt("btm", this.f176927o.f176930b + r111);     // Catch: Throwable -> L85
        r101.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r102.f47028c);     // Catch: Throwable -> L85
        r101.putOpt(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, r113);     // Catch: Throwable -> L85
        r101.putOpt("index", Integer.valueOf(r103 + this.f176925m));     // Catch: Throwable -> L85
        r101.putOpt("exposure_num", Integer.valueOf(r102.f47025J));     // Catch: Throwable -> L85
        r101.putOpt("exposure_start", Long.valueOf(r102.M));     // Catch: Throwable -> L85
        r101.putOpt("exposure_end", Long.valueOf(r102.N));     // Catch: Throwable -> L85
        r101.putOpt("exposure_time", Long.valueOf(r102.N - r102.M));     // Catch: Throwable -> L85
        r101.putOpt(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r102.b());     // Catch: Throwable -> L85
        ECHybridListItemVO r124 = r110.f47152c;     // Catch: Throwable -> L85
        if (r124 == null) goto L78;
        ECNAMallCardExtra r125 = r124.c();     // Catch: Throwable -> L85
        if (r125 == null) goto L78;
        Map<String, Object> r126 = r125.getTrackParams();     // Catch: Throwable -> L85
        if (r126 == null) goto L78;
    L79:
        Iterator<T> r127 = r126.keySet().iterator();     // Catch: Throwable -> L85
    L80:
        if (r127.hasNext() == false) goto L84;
        String r128 = (String) r127.next();     // Catch: Throwable -> L85
        r101.putOpt(r128, r126.get(r128));     // Catch: Throwable -> L85
    L78:
        r126 = new LinkedHashMap();     // Catch: Throwable -> L85
        goto L79
    L69:
        r121 = false;
    L65:
        r113 = "";
        goto L67
    L16:
        r103 = r110.getLayoutPosition();     // Catch: Throwable -> L85
        goto L17
    L9:
        if (r110.getAdapterPosition() >= 0) goto L11;
        return null;
    L85:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.g
    public final void j(boolean r100) {
        if (r100 == true) goto L4;
        p();
        l(this.f176914b, System.currentTimeMillis());
        return;
    L4:
        if (this.f176927o.f176934f == false) goto L8;
        h();
        if ((!this.f176913a.isEmpty()) == false) goto L11;
        this.f176914b = System.currentTimeMillis();
        return;
    L11:
        return;
    L8:
        r();
    }

    public EventExposureTime(a.C2622a r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "getBtm");
        this.f176927o = r100;
        this.f176928p = r101;
        this.f176913a = new LinkedHashSet();
        this.f176916d = -1;
        this.f176917e = -1;
        this.f176921i = "";
        this.f176922j = new LinkedHashMap();
        this.f176923k = new LinkedHashSet();
        this.f176926n = new Rect();
        q r102 = r100.f176932d;
        if (r102 == null) goto L5;
        r102.g(this);
    L5:
        q r103 = r100.f176932d;
        if (r103 == null) goto L9;
        r103.e(this);
    L9:
        if (Intrinsics.areEqual(r100.f176929a, MallPageName.X_TAB_MALL) == false) goto L11;
    L12:
        this.f176925m = -1;
        return;
    L11:
        if (Intrinsics.areEqual(r100.f176929a, "order_homepage") == true) goto L12;
    }

    public static final void f(EventExposureTime r110, BaseViewHolder r111) {
        r110.getClass();
        if ((r111 instanceof ECMallFeedTitleViewHolder) == false) goto L6;
        r110.f176925m = -1;
        return;
    L6:
        if (r110.f176913a.isEmpty() == false) goto L8;
        r110.f176914b = System.currentTimeMillis();
    L8:
        r110.f176913a.add(r111);
        r110.f176916d = RangesKt.coerceAtLeast(r110.f176916d, r111.getAdapterPosition());
        if (r110.f176927o.f176934f == false) goto L14;
        ECHybridListItemVO r100 = r111.f47152c;
        if (r100 == null) goto L14;
        r100.m();
    L14:
        if (r111.getAdapterPosition() <= r110.f176917e) goto L112;
        r110.f176917e = r111.getAdapterPosition();
        ECHybridListItemVO r101 = r111.f47152c;
        if (r101 == null) goto L108;
        String r102 = "";
        Object r103 = null;
        if (m(r101) == true) goto L57;
        if (o(r101) == true) goto L57;
        if (n(r101) == true) goto L57;
        if (r110.f176920h <= 1) goto L27;
    L31:
        int r104 = r111.getAdapterPosition() + r110.f176925m;
        ECHybridListItemVO r112 = r111.f47152c;
        if (r112 == null) goto L38;
        com.bytedance.android.ec.hybrid.list.entity.n r113 = r112.f47041o;
        if (r113 == null) goto L38;
        HashMap<String, Object> r114 = r113.f47140b;
        if (r114 == null) goto L38;
        Object r115 = r114.get("request_id");
    L40:
        if ((r115 instanceof String) == false) goto L43;
        r103 = r115;
    L43:
        String r105 = (String) r103;
        if (r105 != null) goto L46;
        r105 = "";
    L46:
        int r106 = r110.f176920h;
        if (r106 <= 1) goto L49;
        r110.q("ad", r106, r104, r110.f176921i, r105);
    L49:
        int r107 = r110.f176919g;
        if (r107 <= 1) goto L52;
        r110.q("life", r107, r104, r110.f176921i, r105);
    L52:
        int r108 = r110.f176918f;
        if (r108 <= 1) goto L55;
        r110.q("live", r108, r104, r110.f176921i, r105);
    L55:
        r110.f176920h = 0;
        r110.f176919g = 0;
        r110.f176918f = 0;
        r110.f176921i = "";
        return;
    L38:
        r115 = null;
        goto L40
    L27:
        if (r110.f176919g > 1) goto L31;
        if (r110.f176918f > 1) goto L31;
        r110.f176920h = 0;
        r110.f176919g = 0;
        r110.f176918f = 0;
        r110.f176921i = "";
        return;
    L57:
        if (m(r101) == false) goto L59;
    L62:
        ECHybridListItemVO r109 = r111.f47152c;
        if (r109 == null) goto L69;
        com.bytedance.android.ec.hybrid.list.entity.n r116 = r109.f47041o;
        if (r116 == null) goto L69;
        HashMap<String, Object> r117 = r116.f47140b;
        if (r117 == null) goto L69;
        Object r118 = r117.get("request_id");
    L71:
        if ((r118 instanceof String) == false) goto L74;
        r103 = r118;
    L74:
        String r119 = (String) r103;
        if (r119 == null) goto L78;
        r102 = r119;
    L78:
        int r120 = r111.getAdapterPosition() + r110.f176925m;
        if (m(r101) == false) goto L82;
        r110.f176920h++;
    L82:
        if (n(r101) == false) goto L85;
        r110.f176919g++;
    L85:
        if (o(r101) == false) goto L88;
        r110.f176918f++;
    L88:
        if (m(r101) == true) goto L94;
        int r121 = r110.f176920h;
        if (r121 <= 1) goto L92;
        r110.q("ad", r121, r120, r110.f176921i, r102);
    L92:
        r110.f176920h = 0;
    L94:
        if (n(r101) == true) goto L100;
        int r122 = r110.f176919g;
        if (r122 <= 1) goto L98;
        r110.q("life", r122, r120, r110.f176921i, r102);
    L98:
        r110.f176919g = 0;
    L100:
        if (o(r101) == true) goto L105;
        int r123 = r110.f176918f;
        if (r123 <= 1) goto L104;
        r110.q("live", r123, r120, r110.f176921i, r102);
    L104:
        r110.f176918f = 0;
    L105:
        r110.f176921i = r102;
        return;
    L69:
        r118 = null;
        goto L71
    L59:
        if (o(r101) == true) goto L62;
        if (n(r101) == true) goto L62;
        return;
    L108:
        return;
    }

    public static final void g(EventExposureTime r100, BaseViewHolder r101) {
        r100.getClass();
        if ((r101 instanceof ECMallFeedTitleViewHolder) == true) goto L44;
        r100.f176913a.remove(r101);
        if (r101.getAdapterPosition() > r100.f176916d) goto L8;
        r100.f176916d = r101.getAdapterPosition() - 1;
    L8:
        r100.f176922j.remove(r101);
        if (r100.f176927o.f176934f == false) goto L24;
        ECHybridListItemVO r102 = r101.f47152c;
        if (r102 == null) goto L13;
        r102.N = System.currentTimeMillis();
    L13:
        ECHybridListItemVO r103 = r101.f47152c;
        if (r103 != null) goto L16;
        return;
    L16:
        if (r103.f47049w == true) goto L38;
        JSONObject r104 = r100.i(r101);
        if (r104 == null) goto L21;
        AppLogNewUtils.onEventV3("show_ecom_card_time", r104);
    L21:
        if (r100.f176913a.isEmpty() == false) goto L39;
        r100.l(r100.f176914b, System.currentTimeMillis());
        return;
    L39:
        return;
    L38:
        return;
    L24:
        if (r100.f176923k.remove(r101) == false) goto L45;
        ECHybridListItemVO r105 = r101.f47152c;
        if (r105 == null) goto L29;
        r105.N = System.currentTimeMillis();
    L29:
        ECHybridListItemVO r106 = r101.f47152c;
        if (r106 != null) goto L32;
        return;
    L32:
        if (r106.f47049w == true) goto L42;
        JSONObject r107 = r100.i(r101);
        if (r107 == null) goto L43;
        AppLogNewUtils.onEventV3("show_ecom_card_time", r107);
        return;
    L43:
        return;
    L42:
        return;
    L45:
        return;
    }

    public final void l(long r110, long r111) {
        this.f176914b = 0;
        if (r110 > 0) goto L5;
        return;
    L5:
        if (r111 > 0) goto L7;
        return;
    L7:
        if ((r111 - r110) < 100) goto L13;
        BuildersKt.launch$default(this.f176927o.f176931c, Dispatchers.getDefault(), null, new EventExposureTime$gulShowReport$1(this, r110, r111, null), 2, null);
        return;
    }

    public final void q(String r110, int r111, int r112, String r113, String r114) {
        BuildersKt.launch$default(this.f176927o.f176931c, Dispatchers.getDefault(), null, new EventExposureTime$reportRepeat$1(this, r111, r112, r113, r114, r110, null), 2, null);
    }
}
