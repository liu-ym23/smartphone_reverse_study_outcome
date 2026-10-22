package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkGuestViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f75930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveTypeForMultiLink f75931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xg0.a f75932d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkGuestViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkGuestViewBinder$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder implements hg0.b<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g<a> f75933a;

        @Override // hg0.b
        public final g<a> l() {
            return this.f75933a;
        }

        public ItemViewHolder(g<a> r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
            super(r100.l());
            this.f75933a = r100;
            r100.j(r100.f498956c.getContext());
        }
    }

    public static class a extends tf0.e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ch0.e f75934k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public LinkmicPositionItem f75935l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public pf0.a f75936m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public wg0.a f75937n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List<Integer> f75938o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public ch0.c f75939p;

        public final a a() {
            a r100 = new a(this.f75934k, this.f75935l, this.f75936m, this.f75937n, this.f75938o, this.f75939p);
            r100.f545685a = this.f545685a;
            r100.f545686b = this.f545686b;
            r100.f545687c = this.f545687c;
            r100.f545688d = this.f545688d;
            r100.f545689e = this.f545689e;
            r100.f545690f = this.f545690f;
            List<Integer> r101 = this.f545691g;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f545691g = r101;
            r100.f545692h = this.f545692h;
            HashMap<String, tf0.d> r102 = this.f545693i;
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r100.f545693i = r102;
            r100.f545694j = this.f545694j;
            return r100;
        }

        public String toString() {
            return this.f75934k.f23724a.toString();
        }

        public /* synthetic */ a(ch0.e r100, LinkmicPositionItem r101, int r110) {
            if ((r110 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101, null, null, null, null);
        }

        public a(ch0.e r100, LinkmicPositionItem r101, pf0.a r102, wg0.a r103, List<Integer> r104, ch0.c r105) {
            Intrinsics.checkNotNullParameter(r100, "mergeData");
            this.f75934k = r100;
            this.f75935l = r101;
            this.f75936m = r102;
            this.f75937n = r103;
            this.f75938o = r104;
            this.f75939p = r105;
        }
    }

    public interface b {
        void N0(w8 r100);

        void e4(a r100);

        int getCurrentWindowCount();

        void m3(a r100, boolean r101);

        void w1(a r100);
    }

    @Override // me.drakeet.multitype.b
    public final long a(a r100) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        return r101.f545685a;
    }

    @Override // me.drakeet.multitype.b
    public final void f(RecyclerView.ViewHolder r100) {
        ItemViewHolder r101 = (ItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        r101.f75933a.onDetach();
    }

    public MultiLinkGuestViewBinder(LiveTypeForMultiLink r100, xg0.b r101) {
        Intrinsics.checkNotNullParameter(r100, "liveTypeForMultiLink");
        Intrinsics.checkNotNullParameter(r101, "linkSeatAbilityProvider");
        this.f75931c = r100;
        this.f75932d = r101;
    }

    @Override // me.drakeet.multitype.b
    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r100, a r101) {
        h((ItemViewHolder) r100, r101);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        m r102 = this.f75932d.getLinkWindowLayoutConfig();
        r102.getClass();
        int r103 = r102.getUiLayout();
        m r104 = this.f75932d.getLinkWindowLayoutConfig();
        if (this.f75931c != LiveTypeForMultiLink.Audio) goto L24;
        se0.c r105 = this.f75932d.getAudioFeedLayerUIConfig();
        if (r103 != 21) goto L7;
        int r106 = hg0.c.f485001a;
        g r107 = hg0.c.c(r101, MicSeatScene.AUDIO_LINK, r104, r105, this.f75932d);
    L41:
        int r108 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        DataCenter r109 = this.f75932d.getDataCenter();
        IRoom r110 = this.f75932d.getRoom();
        if (r110 == null) goto L44;
        long r111 = r110.getId();
    L45:
        MultiSceneEnterRoomStatisticsUtils r112 = MultiSceneEnterRoomStatisticsUtils.a.a(r109, Long.valueOf(r111));
        if (r112 == null) goto L48;
        r112.c();
    L48:
        System.currentTimeMillis();
        return new ItemViewHolder(r107);
    L44:
        r111 = 0;
        goto L45
    L7:
        if (r103 != 22) goto L9;
        int r113 = hg0.c.f485001a;
        r107 = hg0.c.c(r101, MicSeatScene.AUDIO_LINK_LARGE, r104, r105, this.f75932d);
        goto L41
    L9:
        if (r103 != 24) goto L11;
        int r114 = hg0.c.f485001a;
        r107 = hg0.c.c(r101, MicSeatScene.AUDIO_LINK_DYNAMIC_ISLAND, r104, r105, this.f75932d);
        goto L41
    L11:
        if (r103 != 28) goto L13;
        int r115 = hg0.c.f485001a;
        r107 = hg0.c.c(r101, MicSeatScene.AUDIO_LINK_HAMLET_AVATAR, r104, r105, this.f75932d);
        goto L41
    L13:
        if (r103 != 30) goto L15;
        int r116 = hg0.c.f485001a;
        r107 = hg0.c.c(r101, MicSeatScene.AUDIO_LINK_STAGE_ENLARGE, r104, r105, this.f75932d);
        goto L41
    L15:
        if (aj0.b.c(r103) == false) goto L17;
        int r117 = hg0.c.f485001a;
        r107 = hg0.c.g(r101, MicSeatScene.VIDEO_LINK_EQUAL, this.f75932d);
        goto L41
    L17:
        int r118 = hg0.c.f485001a;
        r107 = hg0.c.c(r101, MicSeatScene.AUDIO_LINK, r104, r105, this.f75932d);
        goto L41
    L24:
        if (r103 != 4) goto L26;
        int r119 = hg0.c.f485001a;
        r107 = hg0.c.g(r101, MicSeatScene.VIDEO_LINK_EQUAL, this.f75932d);
        goto L41
    L26:
        if (r103 == 15) goto L39;
        if (r103 != 21) goto L29;
    L38:
        int r120 = hg0.c.f485001a;
        MicSeatScene r121 = MicSeatScene.VIDEO_LINK_EQUAL;
        xg0.a r122 = this.f75932d;
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r121, "scene");
        Intrinsics.checkNotNullParameter(r122, "linkSeatAbilityProvider");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a r123 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a(r121, r122);
        pg0.a r124 = new pg0.a(r121, r123, r122);
        g r125 = new g(r101);
        r125.b(r123);
        r125.b(new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.theme.b(r123, r121, r122));
        r125.b(r124);
        boolean r126 = tb1.d.f545237a;
        r125.b(new og0.a(r123, r122));
        r125.b(new lg0.a(r121, r124, r123, r122));
        r125.a(r101.getContext());
        r107 = r125;
        goto L41
    L29:
        if (r103 == 109) goto L38;
        if (r103 == 111) goto L38;
        if (r103 == 112) goto L38;
        if (aj0.b.c(r103) == false) goto L37;
        int r127 = hg0.c.f485001a;
        r107 = hg0.c.g(r101, MicSeatScene.VIDEO_LINK_EQUAL, this.f75932d);
        goto L41
    L37:
        int r128 = hg0.c.f485001a;
        r107 = hg0.c.g(r101, MicSeatScene.VIDEO_LINK_EQUAL, this.f75932d);
        goto L41
    L39:
        int r129 = hg0.c.f485001a;
        MicSeatScene r130 = MicSeatScene.VIDEO_LINK_EQUAL;
        xg0.a r131 = this.f75932d;
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r130, "scene");
        Intrinsics.checkNotNullParameter(r131, "linkSeatAbilityProvider");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a r132 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a(r130, r131);
        g r133 = new g(r101);
        r133.b(r132);
        r133.b(new com.bytedance.android.live.liveinteract.revenue.game.layer.c(r130, r132, r131));
        r133.a(r101.getContext());
        r107 = r133;
        goto L41
    }

    public final void h(ItemViewHolder r100, a r110) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "itemData");
        r100.f75933a.v(r110, r110.f545685a);
        g<a> r101 = r100.f75933a;
        int r102 = 0;
        if (r110.f545694j == false) goto L5;
        int r103 = 0;
    L6:
        r101.x(r103);
        if (this.f75930b == true) goto L35;
        int r104 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        DataCenter r105 = this.f75932d.getDataCenter();
        IRoom r106 = this.f75932d.getRoom();
        long r107 = 0;
        if (r106 == null) goto L11;
        long r108 = r106.getId();
    L12:
        MultiSceneEnterRoomStatisticsUtils r109 = MultiSceneEnterRoomStatisticsUtils.a.a(r105, Long.valueOf(r108));
        if (r109 == null) goto L15;
        r109.c();
    L15:
        System.currentTimeMillis();
        r100.getLayoutPosition();
        this.f513439a.getItemCount();
        r110.toString();
        Iterator r111 = CollectionsKt.reversed(this.f513439a.f513437a).iterator();
    L16:
        int r112 = -1;
        if (r111.hasNext() == false) goto L22;
        if ((!(r111.next() instanceof MultiLinkNormalEmptyViewBinder.a)) == true) goto L23;
        r102 = r102 + 1;
    L23:
        if (r102 < 0) goto L25;
        r112 = (this.f513439a.getItemCount() - 1) - r102;
    L25:
        if (r112 < 0) goto L35;
        if (r100.getLayoutPosition() != r112) goto L35;
        System.currentTimeMillis();
        r100.getLayoutPosition();
        this.f513439a.getItemCount();
        int r113 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        DataCenter r114 = this.f75932d.getDataCenter();
        IRoom r115 = this.f75932d.getRoom();
        if (r115 == null) goto L31;
        r107 = r115.getId();
    L31:
        MultiSceneEnterRoomStatisticsUtils r116 = MultiSceneEnterRoomStatisticsUtils.a.a(r114, Long.valueOf(r107));
        if (r116 == null) goto L34;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r116, "guest_seat_render", 0, 2, null);
    L34:
        this.f75930b = true;
        goto L35
    L22:
        r102 = -1;
        goto L23
    L11:
        r108 = 0;
    L35:
        tf0.m r117 = b0.b();
        if ((r117 instanceof u) == true) goto L38;
        r117 = null;
    L38:
        u r118 = (u) r117;
        if (r118 == null) goto L41;
        boolean r119 = r118.f76110a;
    L42:
        if (r119 == false) goto L44;
        return;
    L44:
        if (r100.getLayoutPosition() != (this.f513439a.getItemCount() - 1)) goto L51;
        if (r118 == null) goto L52;
        r118.b(System.currentTimeMillis());
        return;
    L52:
        return;
    L51:
        return;
    L41:
        r119 = true;
        goto L42
    L5:
        r103 = 4;
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final void c(RecyclerView.ViewHolder r100, a r101, List r102) {
        ItemViewHolder r103 = (ItemViewHolder) r100;
        a r104 = r101;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.size() != 0) goto L5;
        h(r103, r104);
        return;
    L5:
        Iterator r105 = r102.iterator();
    L7:
        if (r105.hasNext() == false) goto L44;
        Object r106 = r105.next();
        if ((r106 instanceof Bundle) == true) goto L11;
        r106 = null;
    L11:
        Bundle r107 = (Bundle) r106;
        if (r107 == null) goto L7;
        if (r107.size() == 0) goto L28;
        if (r107.containsKey("payload_key_is_not_same_class") == true) goto L28;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "itemData");
        Intrinsics.checkNotNullParameter(r107, WsConstants.KEY_PAYLOAD);
        r103.f75933a.w(r104, r104.f545685a, r107);
        if (r107.containsKey("payload_key_is_visible") == true) goto L20;
        if (r107.containsKey("payload_key_update_for_show_from") == false) goto L7;
        r103.f75933a.v(r104, r104.f545685a);
        goto L7
    L20:
        g<a> r108 = r103.f75933a;
        if (r104.f545694j == false) goto L23;
        int r109 = 0;
    L24:
        r108.x(r109);
        goto L7
    L23:
        r109 = 4;
    L28:
        h(r103, r104);
        goto L7
    }
}
