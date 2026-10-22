package com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.common.wschannel.WsConstants;
import hg0.c;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tf0.e;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkPreOnlineViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xg0.a f75580b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/audio/viewbinder/MultiLinkPreOnlineViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/audio/viewbinder/MultiLinkPreOnlineViewBinder$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder implements hg0.b<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g<a> f75581a;

        @Override // hg0.b
        public final g<a> l() {
            return this.f75581a;
        }

        public ItemViewHolder(g<a> r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
            super(r100.l());
            this.f75581a = r100;
            r100.j(r100.f498956c.getContext());
        }
    }

    public static final class a extends e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final IBaseUser f75582k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f75583l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f75584m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final LinkmicPositionItem f75585n;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f75582k, r101.f75582k) == true) goto L8;
            return false;
        L8:
            if (this.f75583l == r101.f75583l) goto L10;
            return false;
        L10:
            if (this.f75584m == r101.f75584m) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f75585n, r101.f75585n) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            IBaseUser r100 = this.f75582k;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((((r102 * 31) + this.f75583l) * 31) + this.f75584m) * 31;
            LinkmicPositionItem r104 = this.f75585n;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "PreOnlineItemData(user=" + this.f75582k + ", selfLinkPlayerStatus=" + this.f75583l + ", position=" + this.f75584m + ", positionNameItem=" + this.f75585n + ")";
        }

        public a(IBaseUser r100, int r101, int r102, LinkmicPositionItem r103) {
            Intrinsics.checkNotNullParameter(r100, "user");
            this.f75582k = r100;
            this.f75583l = r101;
            this.f75584m = r102;
            this.f75585n = r103;
        }
    }

    public interface b {
        void V3(a r100);
    }

    public MultiLinkPreOnlineViewBinder(xg0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "linkSeatAbilityProvider");
        this.f75580b = r100;
    }

    public static void h(ItemViewHolder r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "itemData");
        r100.f75581a.v(r101, r101.f545685a);
    }

    @Override // me.drakeet.multitype.b
    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r100, a r101) {
        h((ItemViewHolder) r100, r101);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        m r102 = this.f75580b.getLinkWindowLayoutConfig();
        if (r102.getUiLayout() != 21) goto L6;
        int r103 = c.f485001a;
        g r104 = c.e(r101, MicSeatScene.AUDIO_LINK, this.f75580b);
    L13:
        return new ItemViewHolder(r104);
    L6:
        if (r102.getUiLayout() != 22) goto L9;
        int r105 = c.f485001a;
        r104 = c.e(r101, MicSeatScene.AUDIO_LINK_LARGE, this.f75580b);
        goto L13
    L9:
        if (r102.getUiLayout() != 30) goto L11;
        int r106 = c.f485001a;
        r104 = c.e(r101, MicSeatScene.AUDIO_LINK_STAGE_ENLARGE, this.f75580b);
        goto L13
    L11:
        int r107 = c.f485001a;
        r104 = c.e(r101, MicSeatScene.AUDIO_LINK, this.f75580b);
        goto L13
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
        if (r107.containsKey("payload_key_is_not_same_class") == true) goto L19;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "itemData");
        Intrinsics.checkNotNullParameter(r107, WsConstants.KEY_PAYLOAD);
        r103.f75581a.w(r104, r104.f545685a, r107);
    L19:
        h(r103, r104);
        goto L7
    }
}
