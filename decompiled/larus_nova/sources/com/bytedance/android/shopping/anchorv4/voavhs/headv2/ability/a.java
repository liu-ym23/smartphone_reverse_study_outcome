package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.ec.model.response.f0;
import com.bytedance.android.ec.model.response.u1;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.ttm.player.MediaPlayer;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f169054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f169055b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a$a, reason: collision with other inner class name */
    public static final class C2550a {
    }

    static {
    }

    public final Map<String, Object> b() {
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r100 = this.f169055b.Sf().f(this.f169055b.getCurrentPosition());
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L10;
        u1 r102 = r100.b();
        if (r102 == null) goto L10;
        f0 r103 = r102.a();
        if (r103 == null) goto L10;
        Map<String, Object> r104 = r103.b();
        if (r104 == null) goto L10;
    L11:
        r101.putAll(r104);
        if (r100 == null) goto L14;
        String r105 = r100.j();
    L15:
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        r101.put("video_id", r105);
        return r101;
    L14:
        r105 = null;
    L10:
        r104 = MapsKt.emptyMap();
        goto L11
    }

    public a(s r100) {
        Intrinsics.checkNotNullParameter(r100, "headAbility");
        this.f169055b = r100;
        this.f169054a = new LinkedHashSet();
    }

    public final void c(boolean r110) {
        Pair[] r100 = new Pair[1];
        if (r110 == false) goto L5;
        String r111 = "open";
    L6:
        r100[0] = TuplesKt.to("click_type", r111);
        Map r101 = MapsKt.mutableMapOf(r100);
        AnchorV4HeadV2VO r112 = this.f169055b.K10();
        if (r112 == null) goto L14;
        List<HeaderContentModel> r113 = r112.getCells();
        if (r113 == null) goto L14;
        HeaderContentModel r114 = (HeaderContentModel) CollectionsKt.getOrNull(r113, this.f169055b.getCurrentPosition());
        if (r114 == null) goto L14;
        Map<String, String> r115 = r114.getTrack();
        if (r115 == null) goto L14;
    L15:
        r101.putAll(r115);
        r101.putAll(b());
        Unit r116 = Unit.INSTANCE;
        q.a.a(this, "pd_sound_icon_click", r101, false, null, null, null, null, null, 508);
        return;
    L14:
        r115 = MapsKt.emptyMap();
        goto L15
    L5:
        r111 = "close";
        goto L6
    }

    public final void d(boolean r110) {
        Pair[] r100 = new Pair[1];
        if (r110 == false) goto L5;
        String r111 = "open";
    L6:
        r100[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ICON_STATUS, r111);
        Map r101 = MapsKt.mutableMapOf(r100);
        AnchorV4HeadV2VO r112 = this.f169055b.K10();
        if (r112 == null) goto L14;
        List<HeaderContentModel> r113 = r112.getCells();
        if (r113 == null) goto L14;
        HeaderContentModel r114 = (HeaderContentModel) CollectionsKt.getOrNull(r113, this.f169055b.getCurrentPosition());
        if (r114 == null) goto L14;
        Map<String, String> r115 = r114.getTrack();
        if (r115 == null) goto L14;
    L15:
        r101.putAll(r115);
        r101.putAll(b());
        Unit r116 = Unit.INSTANCE;
        q.a.a(this, "pd_sound_icon_show", r101, false, null, null, null, null, null, 508);
        return;
    L14:
        r115 = MapsKt.emptyMap();
        goto L15
    L5:
        r111 = "close";
        goto L6
    }

    public final void e(boolean r110) {
        Pair[] r100 = new Pair[1];
        if (r110 == false) goto L5;
        String r111 = "play";
    L6:
        r100[0] = TuplesKt.to("click_type", r111);
        Map r101 = MapsKt.mutableMapOf(r100);
        AnchorV4HeadV2VO r112 = this.f169055b.K10();
        if (r112 == null) goto L14;
        List<HeaderContentModel> r113 = r112.getCells();
        if (r113 == null) goto L14;
        HeaderContentModel r114 = (HeaderContentModel) CollectionsKt.getOrNull(r113, this.f169055b.getCurrentPosition());
        if (r114 == null) goto L14;
        Map<String, String> r115 = r114.getTrack();
        if (r115 == null) goto L14;
    L15:
        r101.putAll(r115);
        r101.putAll(b());
        Unit r116 = Unit.INSTANCE;
        q.a.a(this, "pd_video_pause_click", r101, false, null, null, null, null, null, 508);
        return;
    L14:
        r115 = MapsKt.emptyMap();
        goto L15
    L5:
        r111 = "pause";
        goto L6
    }

    public final void f(boolean r110) {
        Pair[] r100 = new Pair[1];
        if (r110 == false) goto L5;
        String r111 = "play";
    L6:
        r100[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ICON_STATUS, r111);
        Map r101 = MapsKt.mutableMapOf(r100);
        AnchorV4HeadV2VO r112 = this.f169055b.K10();
        if (r112 == null) goto L14;
        List<HeaderContentModel> r113 = r112.getCells();
        if (r113 == null) goto L14;
        HeaderContentModel r114 = (HeaderContentModel) CollectionsKt.getOrNull(r113, this.f169055b.getCurrentPosition());
        if (r114 == null) goto L14;
        Map<String, String> r115 = r114.getTrack();
        if (r115 == null) goto L14;
    L15:
        r101.putAll(r115);
        r101.putAll(b());
        Unit r116 = Unit.INSTANCE;
        q.a.a(this, "pd_video_pause_show", r101, false, null, null, null, null, null, 508);
        return;
    L14:
        r115 = MapsKt.emptyMap();
        goto L15
    L5:
        r111 = "pause";
        goto L6
    }

    public final void h(Map<String, ? extends Object> r110) {
        q.a.a(this, "pd_images_tab_show", r110, false, null, null, null, null, null, 508);
    }

    public final void i(RecyclerView r110) {
        Intrinsics.checkNotNullParameter("a1.b8094.c0645.d057069", "btmId");
        q.a.a(this, "show_product_main_picture", null, false, null, r110, "a1.b8094.c0645.d057069", null, null, 406);
    }

    public final void j(String r110) {
        if (r110 == null) goto L4;
    L7:
        Map<String, Object> r100 = b();
        r100.put(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, r110);
        q.a.a(this, "pd_video_show", r100, false, r110 + "_" + ((LinkedHashMap) r100).get("video_id"), this.f169055b.getRecyclerView(), "a1.b8094.c0645.d057069", null, null, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT);
        return;
    L4:
        if (this.f169055b.a() == false) goto L6;
        r110 = com.bytedance.android.ec.core.event.a.VALUE_BIG_PICTURE;
        goto L7
    L6:
        r110 = com.bytedance.android.ec.core.event.a.VALUE_MAIN_PICTURE;
        goto L7
    }

    public final void g(String r110, Map<String, ? extends Object> r111) {
        Intrinsics.checkNotNullParameter(r110, ReportConstant.COMMON_ACTION_TYPE);
        Map r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("action_type", r110)});
        if (r111 == null) goto L5;
        r100.putAll(r111);
    L5:
        Unit r112 = Unit.INSTANCE;
        q.a.a(this, "pd_images_tab_click", r100, false, null, this.f169055b.getRecyclerView(), "a1.b8094.c0645.d663013", null, null, 412);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.q
    public final void a(String r110, Map<String, ? extends Object> r111, boolean r210, boolean r211, String r212, View r213, String r214, Integer r215, Integer r216) {
        if (r110 != null) goto L5;
        return;
    L5:
        boolean r112 = true;
        if (r215 != null) goto L8;
    L10:
        boolean r100 = false;
    L11:
        String r113 = null;
        if (r100 == false) goto L43;
        if (r213 == null) goto L78;
        if (r214 != null) goto L16;
        String r101 = "";
    L17:
        if (r214 == null) goto L19;
        r113 = r214 + r212;
    L19:
        c r102 = new c(this, r111, r210);
        if (r101.length() != 0) goto L22;
        boolean r103 = true;
    L23:
        if (r103 == false) goto L25;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L25:
        com.bytedance.android.bst.api.d r104 = new com.bytedance.android.bst.api.d(r213);
        r104.f41906a = r101;
        r104.f41907b = r110;
        r104.f41908c = r113;
        r104.f41909d = "shopping";
        r104.f41910e = -1;
        r104.f41911f = r102;
        if (r215 != null) goto L29;
    L31:
        boolean r105 = false;
    L32:
        if (r105 == false) goto L34;
        com.bytedance.android.bst.api.f.f41925b.getClass();
        com.bytedance.android.bst.api.f.a(r104);
        return;
    L34:
        if (r215 != null) goto L37;
    L39:
        r112 = false;
    L40:
        if (r112 == false) goto L80;
        com.bytedance.android.bst.api.f.f41925b.getClass();
        com.bytedance.android.bst.api.f.c(r104);
        return;
    L80:
        return;
    L37:
        if (r215.intValue() != 2) goto L39;
    L29:
        if (r215.intValue() != 1) goto L31;
        r105 = true;
        goto L32
    L22:
        r103 = false;
        goto L23
    L16:
        r101 = r214;
        goto L17
    L78:
        return;
    L43:
        LinkedHashMap r106 = new LinkedHashMap();
        AnchorV4HeadV2VO r107 = this.f169055b.K10();
        if (r107 == null) goto L48;
        Map<String, String> r108 = r107.getTrackMeta();
        if (r108 == null) goto L48;
        r106.putAll(r108);
    L48:
        if (r111 == null) goto L51;
        r106.putAll(r111);
    L51:
        if (com.bytedance.android.shopping.extensions.k.c(r214) == false) goto L53;
        r106.put("btm", r214);
    L53:
        if (r111 == null) goto L55;
        Object r109 = r111.get(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE);
    L57:
        if (Intrinsics.areEqual(r109, com.bytedance.android.ec.core.event.a.VALUE_BIG_PICTURE) == false) goto L59;
        r106.put(com.bytedance.android.ec.core.event.a.KEY_ENTER_SOURCE, com.bytedance.android.ec.core.event.a.VALUE_PDP_HEAD);
    L59:
        this.f169055b.rR().g0(r110, r106, r214, r213, r210, r211, r212);
        if (r216 != null) goto L63;
    L65:
        if (r216 != null) goto L68;
    L71:
        String r114 = null;
    L72:
        if (r114 == null) goto L81;
        if (r212 == null) goto L75;
        String r115 = StringsKt.replace$default(r212, r110, r114, false, 4, null);
    L76:
        this.f169055b.rR().g0(r114, r106, r214, r213, r210, r211, r115);
        return;
    L75:
        r115 = null;
        goto L76
    L81:
        return;
    L68:
        if (r216.intValue() != 2) goto L71;
        String r116 = com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_CLICK;
    L70:
        r114 = r116;
        goto L72
    L63:
        if (r216.intValue() != 1) goto L65;
        r116 = com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_SHOW;
        goto L70
    L55:
        r109 = null;
        goto L57
    L8:
        if (r215.intValue() <= 0) goto L10;
        r100 = true;
        goto L11
    }
}
