package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkSpecialViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveTypeForMultiLink f75982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xg0.a f75983c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkSpecialViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g<a> f75984a;

        public ItemViewHolder(g<a> r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
            super(r100.l());
            this.f75984a = r100;
        }
    }

    public static final class a extends tf0.e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f75985k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f75986l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final LinkmicPositionItem f75987m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f75988n;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (this.f75985k == r101.f75985k) goto L8;
            return false;
        L8:
            if (this.f75986l == r101.f75986l) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f75987m, r101.f75987m) == true) goto L12;
            return false;
        L12:
            if (this.f75988n == r101.f75988n) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public final int hashCode() {
            int r100 = ((this.f75985k * 31) + this.f75986l) * 31;
            LinkmicPositionItem r101 = this.f75987m;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L6:
            int r103 = (r100 + r102) * 31;
            boolean r104 = this.f75988n;
            ?? r105 = r104;
            if (r104 == false) goto L10;
            r105 = 1;
        L10:
            return r103 + r105;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "SpecialItemData(position=" + this.f75985k + ", lockStatus=" + this.f75986l + ", positionNameItem=" + this.f75987m + ", isSelfInteracting=" + this.f75988n + ")";
        }

        public a(int r100, int r101, LinkmicPositionItem r102, boolean r103) {
            this.f75985k = r100;
            this.f75986l = r101;
            this.f75987m = r102;
            this.f75988n = r103;
        }
    }

    public interface b {
        void Q3(a r100);
    }

    public MultiLinkSpecialViewBinder(LiveTypeForMultiLink r100, xg0.b r101) {
        Intrinsics.checkNotNullParameter(r100, "liveTypeForMultiLink");
        Intrinsics.checkNotNullParameter(r101, "linkSeatAbilityProvider");
        this.f75982b = r100;
        this.f75983c = r101;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        ItemViewHolder r102 = (ItemViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.f75984a.v(r103, r103.f545685a);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        m r102 = this.f75983c.getLinkWindowLayoutConfig();
        if (this.f75982b != LiveTypeForMultiLink.Video) goto L5;
        int r103 = hg0.c.f485001a;
        g r104 = hg0.c.h(r101, MicSeatScene.VIDEO_LINK_EQUAL, this.f75983c);
    L19:
        return new ItemViewHolder(r104);
    L5:
        int r105 = r102.getUiLayout();
        if (r105 != 21) goto L8;
        int r106 = hg0.c.f485001a;
        r104 = hg0.c.d(r101, MicSeatScene.AUDIO_LINK, r102, this.f75983c);
        goto L19
    L8:
        if (r105 != 22) goto L10;
        int r107 = hg0.c.f485001a;
        r104 = hg0.c.d(r101, MicSeatScene.AUDIO_LINK_LARGE, r102, this.f75983c);
        goto L19
    L10:
        if (r105 != 30) goto L12;
        int r108 = hg0.c.f485001a;
        r104 = hg0.c.d(r101, MicSeatScene.AUDIO_LINK_STAGE_ENLARGE, r102, this.f75983c);
        goto L19
    L12:
        if (aj0.b.c(r102.getUiLayout()) == false) goto L14;
        int r109 = hg0.c.f485001a;
        r104 = hg0.c.h(r101, MicSeatScene.VIDEO_LINK_EQUAL, this.f75983c);
        goto L19
    L14:
        int r110 = hg0.c.f485001a;
        r104 = hg0.c.d(r101, MicSeatScene.AUDIO_LINK, r102, this.f75983c);
        goto L19
    }

    @Override // me.drakeet.multitype.b
    public final void c(RecyclerView.ViewHolder r100, a r101, List r102) {
        ItemViewHolder r103 = (ItemViewHolder) r100;
        a r104 = r101;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "payloads");
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        r103.f75984a.v(r104, r104.f545685a);
    }
}
