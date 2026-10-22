package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.response.u1;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f169335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f169336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f169337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f169338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f169339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n f169340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GalleryFromType f169341g;

    public static final class a {
    }

    static {
    }

    public final Map<String, Object> b(int r100) {
        l r101 = this.f169336b;
        Map<String, Object> r102 = null;
        if (r101 == null) goto L7;
        List<com.bytedance.android.ec.model.k> r103 = r101.f169324b;
        if (r103 == null) goto L7;
        com.bytedance.android.ec.model.k r104 = (com.bytedance.android.ec.model.k) CollectionsKt.getOrNull(r103, r100);
    L9:
        if ((r104 instanceof g0) == true) goto L11;
        r104 = null;
    L11:
        g0 r105 = (g0) r104;
        if (r105 == null) goto L16;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r106 = r105.f169310o;
        if (r106 == null) goto L16;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r107 = r106.getPlayInfo();
    L17:
        l r108 = this.f169336b;
        if (r108 == null) goto L31;
        List<c0> r109 = r108.f169325c;
        if (r109 == null) goto L31;
        Iterator<T> r110 = r109.iterator();
    L23:
        if (r110.hasNext() == false) goto L27;
        Object r111 = r110.next();
        if (f0.b(r100, (c0) r111) == false) goto L23;
    L28:
        c0 r112 = (c0) r111;
        if (r112 == null) goto L31;
        Integer r113 = Integer.valueOf((r100 - r112.f169285a) + 1);
    L32:
        Pair[] r114 = new Pair[3];
        r114[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, com.bytedance.android.ec.core.event.a.VALUE_BIG_PICTURE);
        if (r107 == null) goto L35;
        String r115 = r107.j();
    L36:
        if (r115 != null) goto L38;
        r115 = "";
    L38:
        r114[1] = TuplesKt.to("video_id", r115);
        r114[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_VIDEO_POSITION, r113);
        HashMap r116 = MapsKt.hashMapOf(r114);
        if (this.f169341g != GalleryFromType.MoreVideo) goto L46;
        if (r107 == null) goto L52;
        u1 r117 = r107.b();
        if (r117 == null) goto L52;
        com.bytedance.android.ec.model.response.k0 r118 = r117.c();
        if (r118 == null) goto L52;
        r102 = r118.a();
    L52:
        if (r102 == null) goto L54;
        r116.putAll(r102);
    L54:
        return r116;
    L46:
        if (r107 == null) goto L52;
        u1 r119 = r107.b();
        if (r119 == null) goto L52;
        com.bytedance.android.ec.model.response.f0 r120 = r119.a();
        if (r120 == null) goto L52;
        r102 = r120.b();
        goto L52
    L35:
        r115 = null;
        goto L36
    L27:
        r111 = null;
    L31:
        r113 = null;
    L16:
        r107 = null;
    L7:
        r104 = null;
        goto L9
    }

    public final void e(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        d(this, com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_CLICK, MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r100)), null, "a1.b34986.c442582.d324529", 28);
    }

    public final void f(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        d(this, com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_SHOW, MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r100)), null, "a1.b34986.c442582.d324529", 28);
    }

    public final void g(boolean r100) {
        d(this, com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_CLICK, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW, Integer.valueOf(r100 ? 1 : 0))}), null, "a1.b34986.c503191.d90177", 28);
    }

    public m(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n r100, GalleryFromType r101) {
        this.f169340f = r100;
        this.f169341g = r101;
        this.f169335a = new LinkedHashSet();
        this.f169339e = new LinkedHashSet();
    }

    public final void h(int r100, boolean r101) {
        Map<String, Object> r102 = b(r100);
        if (r101 == false) goto L5;
        String r103 = "close";
    L6:
        r102.put("click_type", r103);
        Unit r104 = Unit.INSTANCE;
        d(this, "pd_sound_icon_click", r102, null, null, 60);
        return;
    L5:
        r103 = "open";
        goto L6
    }

    public final void i(int r100, boolean r101) {
        Map<String, Object> r102 = b(r100);
        if (r101 == false) goto L5;
        String r103 = "auto";
    L6:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_METHOD, r103);
        Object r104 = r102.get("video_id");
        if (r104 == null) goto L9;
        String r105 = r104.toString();
    L10:
        int r106 = !CollectionsKt.contains(this.f169335a, r105) ? 1 : 0;
        if (r105 == null) goto L13;
        this.f169335a.add(r105);
    L13:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r106));
        Unit r107 = Unit.INSTANCE;
        d(this, "pd_video_play", r102, null, null, 60);
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.j
    public final void a(int r100, String r101, String r102) {
        Pair[] r103 = new Pair[4];
        r103[0] = TuplesKt.to("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n r104 = this.f169340f;
        if (r104 == null) goto L7;
        CommonMeta r105 = r104.a();
        if (r105 == null) goto L7;
        String r106 = r105.getProductId();
    L8:
        r103[1] = TuplesKt.to("product_id", r106);
        r103[2] = TuplesKt.to("tab_type", com.bytedance.android.ec.core.event.a.VALUE_PIC_RECOMMEND);
        r103[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PIC_TYPE, Integer.valueOf(r100));
        HashMap r107 = MapsKt.hashMapOf(r103);
        if (r102 == null) goto L11;
        r107.put(com.bytedance.android.ec.core.event.a.KEY_VIEW_STYLE, r102);
    L11:
        if (r101 == null) goto L13;
        r107.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, r101);
    L13:
        Unit r108 = Unit.INSTANCE;
        d(this, com.bytedance.android.ec.core.event.a.KEY_FIND_SIMILAR_TAB_SHOW, r107, String.valueOf(r101), "a1.b8094.c86220.d94403", 4);
        return;
    L7:
        r106 = null;
        goto L8
    }

    public final void c(int r100, String r101, String r102) {
        Pair[] r103 = new Pair[4];
        r103[0] = TuplesKt.to("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n r104 = this.f169340f;
        if (r104 == null) goto L7;
        CommonMeta r105 = r104.a();
        if (r105 == null) goto L7;
        String r106 = r105.getProductId();
    L8:
        r103[1] = TuplesKt.to("product_id", r106);
        r103[2] = TuplesKt.to("tab_type", com.bytedance.android.ec.core.event.a.VALUE_PIC_RECOMMEND);
        r103[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PIC_TYPE, Integer.valueOf(r100));
        HashMap r107 = MapsKt.hashMapOf(r103);
        if (r102 == null) goto L11;
        r107.put(com.bytedance.android.ec.core.event.a.KEY_VIEW_STYLE, r102);
    L11:
        r107.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, r101);
        Unit r108 = Unit.INSTANCE;
        d(this, com.bytedance.android.ec.core.event.a.KEY_FIND_SIMILAR_TAB_CLICK, r107, null, "a1.b8094.c86220.d94403", 28);
        return;
    L7:
        r106 = null;
        goto L8
    }

    public final void j(int r110, long r111, boolean r112) {
        if (r111 <= 0) goto L10;
        Map<String, Object> r100 = b(r110);
        r100.put("duration", Long.valueOf(r111));
        if (r112 == false) goto L7;
        String r113 = "1";
    L8:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_IS_PLAY_OVER, r113);
        Unit r114 = Unit.INSTANCE;
        d(this, "pd_video_play_time", r100, null, null, 60);
        return;
    L7:
        r113 = "0";
        goto L8
    }

    public static void d(m r110, String r111, Map r112, String r113, String r114, int r115) {
        PageFinder r100 = null;
        if ((r115 & 2) == 0) goto L5;
        Map r101 = null;
    L7:
        if ((r115 & 8) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r115 & 16) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r115 & 32) == 0) goto L17;
        String r116 = null;
    L18:
        r110.getClass();
        cl.d.f24079a.getClass();
        cl.d r104 = cl.d.a.b();
        if (r104 == null) goto L21;
        r104.f();
    L21:
        if (r103 == null) goto L26;
        String r105 = r111.concat(r103);
        if (r105 == null) goto L26;
    L27:
        if (r102 == false) goto L29;
    L32:
        LinkedHashMap r106 = new LinkedHashMap();
        if (r101 == null) goto L36;
        r106.putAll(r101);
    L36:
        if (r110.f169341g != GalleryFromType.MoreVideo) goto L38;
        String r107 = com.bytedance.android.ec.core.event.a.VALUE_PDP_MORE_VIDEO;
    L39:
        r106.put(com.bytedance.android.ec.core.event.a.KEY_ENTER_SOURCE, r107);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n r108 = r110.f169340f;
        if (r108 == null) goto L46;
        l r109 = r110.f169336b;
        if (r109 == null) goto L44;
        r100 = r109.f169333k;
    L44:
        r108.b(r111, r106, false, true, r103, null, r116, r100);
        return;
    L46:
        return;
    L38:
        r107 = com.bytedance.android.ec.core.event.a.VALUE_PDP_HEAD;
        goto L39
    L29:
        if (r110.f169339e.contains(r105) == true) goto L47;
        r110.f169339e.add(r105);
        goto L32
    L47:
        return;
    L26:
        r105 = r111;
        goto L27
    L17:
        r116 = r114;
        goto L18
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = false;
        goto L11
    L5:
        r101 = r112;
        goto L7
    }
}
