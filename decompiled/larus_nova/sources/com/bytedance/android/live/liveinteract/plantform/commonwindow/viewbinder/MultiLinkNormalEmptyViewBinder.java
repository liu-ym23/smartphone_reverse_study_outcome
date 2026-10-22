package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tf0.m;

/* JADX INFO: loaded from: classes46.dex */
public class MultiLinkNormalEmptyViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f75948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveTypeForMultiLink f75949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xg0.a f75950d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkNormalEmptyViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkNormalEmptyViewBinder$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder implements hg0.b<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g<a> f75951a;

        @Override // hg0.b
        public final g<a> l() {
            return this.f75951a;
        }

        public ItemViewHolder(g<a> r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
            super(r100.l());
            this.f75951a = r100;
            r100.j(r100.f498956c.getContext());
        }
    }

    public static class a extends tf0.e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f75952k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public LinkmicPositionItem f75953l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ch0.b f75954m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f75955n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f75956o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f75957p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f75958q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f75959r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final boolean f75960s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final int f75961t;

        public void k() {
            this.f75958q = true;
        }

        public ch0.b a() {
            return this.f75954m;
        }

        public int b() {
            return this.f75952k;
        }

        public LinkmicPositionItem c() {
            return this.f75953l;
        }

        public boolean d() {
            return this.f75959r;
        }

        public boolean e() {
            return this.f75956o;
        }

        public boolean f() {
            return this.f75958q;
        }

        public boolean g() {
            return this.f75955n;
        }

        public boolean h() {
            return this.f75957p;
        }

        public boolean i() {
            return this.f75960s;
        }

        public void j(ch0.b r100) {
            this.f75954m = r100;
        }

        public void l(LinkmicPositionItem r100) {
            this.f75953l = r100;
        }

        public void m(boolean r100) {
            this.f75957p = r100;
        }

        public a(int r100, LinkmicPositionItem r101, ch0.b r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r110, boolean r111, int r112) {
            if ((r112 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r112 & 4) == 0) goto L8;
            r102 = null;
        L8:
            int r107 = 0;
            if ((r112 & 8) == 0) goto L12;
            r103 = false;
        L12:
            if ((r112 & 16) == 0) goto L15;
            r104 = false;
        L15:
            if ((r112 & 32) == 0) goto L18;
            r105 = false;
        L18:
            if ((r112 & 64) == 0) goto L21;
            r106 = false;
        L21:
            if ((r112 & 128) == 0) goto L24;
            r110 = false;
        L24:
            if ((r112 & 256) == 0) goto L27;
            r111 = false;
        L27:
            if ((r112 & 512) == 0) goto L29;
            r107 = -1;
        L29:
            this.f75952k = r100;
            this.f75953l = r101;
            this.f75954m = r102;
            this.f75955n = r103;
            this.f75956o = r104;
            this.f75957p = r105;
            this.f75958q = r106;
            this.f75959r = r110;
            this.f75960s = r111;
            this.f75961t = r107;
        }
    }

    public interface b {
        void E5(ch0.b r100);

        void K3(a r100, boolean r101);

        void d2(a r100);
    }

    public MultiLinkNormalEmptyViewBinder(LiveTypeForMultiLink r100, xg0.b r101) {
        Intrinsics.checkNotNullParameter(r100, "liveTypeForMultiLink");
        Intrinsics.checkNotNullParameter(r101, "linkSeatAbilityProvider");
        this.f75949c = r100;
        this.f75950d = r101;
    }

    @Override // me.drakeet.multitype.b
    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r100, a r101) {
        h((ItemViewHolder) r100, r101);
    }

    @Override // me.drakeet.multitype.b
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        return i(r100, r101);
    }

    public final void h(ItemViewHolder r110, a r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "itemData");
        r110.f75951a.v(r111, r111.f545685a);
        m r100 = null;
        if (this.f75948b == true) goto L28;
        int r101 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        DataCenter r102 = this.f75950d.getDataCenter();
        IRoom r103 = this.f75950d.getRoom();
        long r104 = 0;
        if (r103 == null) goto L7;
        long r105 = r103.getId();
    L8:
        MultiSceneEnterRoomStatisticsUtils r106 = MultiSceneEnterRoomStatisticsUtils.a.a(r102, Long.valueOf(r105));
        if (r106 == null) goto L11;
        r106.c();
    L11:
        System.currentTimeMillis();
        r110.getLayoutPosition();
        this.f513439a.getItemCount();
        r111.toString();
        if (r110.getLayoutPosition() != (this.f513439a.getItemCount() - 1)) goto L28;
        Iterator<T> r112 = this.f513439a.f513437a.iterator();
    L15:
        if (r112.hasNext() == false) goto L19;
        Object r107 = r112.next();
        if ((!(r107 instanceof a)) == false) goto L15;
    L20:
        if (r107 != null) goto L28;
        System.currentTimeMillis();
        r110.getLayoutPosition();
        this.f513439a.getItemCount();
        int r113 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        DataCenter r114 = this.f75950d.getDataCenter();
        IRoom r108 = this.f75950d.getRoom();
        if (r108 == null) goto L24;
        r104 = r108.getId();
    L24:
        MultiSceneEnterRoomStatisticsUtils r109 = MultiSceneEnterRoomStatisticsUtils.a.a(r114, Long.valueOf(r104));
        if (r109 == null) goto L27;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r109, "empty_seat_render", 0, 2, null);
    L27:
        this.f75948b = true;
        goto L28
    L19:
        r107 = null;
        goto L20
    L7:
        r105 = 0;
    L28:
        m r115 = b0.b();
        if ((r115 instanceof u) == false) goto L32;
        r100 = r115;
    L32:
        u r116 = (u) r100;
        if (r116 == null) goto L35;
        boolean r117 = r116.f76110a;
    L36:
        if (r117 == false) goto L38;
        return;
    L38:
        if (r110.getLayoutPosition() != (this.f513439a.getItemCount() - 1)) goto L46;
        if (r116 == null) goto L47;
        r116.b(System.currentTimeMillis());
        return;
    L47:
        return;
    L46:
        return;
    L35:
        r117 = true;
        goto L36
    }

    public ItemViewHolder i(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r102 = this.f75950d.getLinkWindowLayoutConfig();
        if (this.f75949c != LiveTypeForMultiLink.Video) goto L5;
        int r103 = hg0.c.f485001a;
        g r104 = hg0.c.f(r101, MicSeatScene.VIDEO_LINK_EQUAL, r102, this.f75950d);
    L21:
        int r105 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        DataCenter r106 = this.f75950d.getDataCenter();
        IRoom r107 = this.f75950d.getRoom();
        if (r107 == null) goto L24;
        long r108 = r107.getId();
    L25:
        MultiSceneEnterRoomStatisticsUtils r109 = MultiSceneEnterRoomStatisticsUtils.a.a(r106, Long.valueOf(r108));
        if (r109 == null) goto L28;
        r109.c();
    L28:
        System.currentTimeMillis();
        return new ItemViewHolder(r104);
    L24:
        r108 = 0;
        goto L25
    L5:
        se0.c r110 = this.f75950d.getAudioFeedLayerUIConfig();
        if (aj0.b.c(r102.getUiLayout()) == false) goto L9;
        int r111 = hg0.c.f485001a;
        r104 = hg0.c.f(r101, MicSeatScene.VIDEO_LINK_EQUAL, r102, this.f75950d);
        goto L21
    L9:
        if (r102.getUiLayout() != 21) goto L12;
        int r112 = hg0.c.f485001a;
        r104 = hg0.c.b(r101, MicSeatScene.AUDIO_LINK, r110, r102, this.f75950d);
        goto L21
    L12:
        if (r102.getUiLayout() != 22) goto L15;
        int r113 = hg0.c.f485001a;
        r104 = hg0.c.b(r101, MicSeatScene.AUDIO_LINK_LARGE, r110, r102, this.f75950d);
        goto L21
    L15:
        if (r102.getUiLayout() != 28) goto L18;
        int r114 = hg0.c.f485001a;
        r104 = hg0.c.b(r101, MicSeatScene.AUDIO_LINK_HAMLET_AVATAR, r110, r102, this.f75950d);
        goto L21
    L18:
        if (r102.getUiLayout() != 30) goto L20;
        int r115 = hg0.c.f485001a;
        r104 = hg0.c.b(r101, MicSeatScene.AUDIO_LINK_STAGE_ENLARGE, r110, r102, this.f75950d);
        goto L21
    L20:
        int r116 = hg0.c.f485001a;
        r104 = hg0.c.b(r101, MicSeatScene.AUDIO_LINK, r110, r102, this.f75950d);
        goto L21
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
        if (r105.hasNext() == false) goto L30;
        Object r106 = r105.next();
        if ((r106 instanceof Bundle) == true) goto L11;
        r106 = null;
    L11:
        Bundle r107 = (Bundle) r106;
        if (r107 == null) goto L7;
        if (r107.size() == 0) goto L19;
        if (r107.containsKey("payload_key_update_for_show_from") == true) goto L19;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "itemData");
        Intrinsics.checkNotNullParameter(r107, WsConstants.KEY_PAYLOAD);
        r103.f75951a.w(r104, r104.f545685a, r107);
    L19:
        h(r103, r104);
        goto L7
    }
}
