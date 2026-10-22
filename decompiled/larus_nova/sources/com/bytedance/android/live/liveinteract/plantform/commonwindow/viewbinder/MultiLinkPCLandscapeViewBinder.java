package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkPCLandscapeViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xg0.a f75962b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkPCLandscapeViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g<a> f75963a;

        public ItemViewHolder(g<a> r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
            super(r100.l());
            this.f75963a = r100;
        }
    }

    public static final class a extends MultiLinkGuestViewBinder.a {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final ch0.e f75964q;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f75964q, ((a) r100).f75964q) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ch0.e r100 = this.f75964q;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.a
        public final String toString() {
            return "PCLandscapeItemData(linkUserMergeData=" + this.f75964q + ")";
        }

        public a(ch0.e r100) {
            Intrinsics.checkNotNullParameter(r100, "linkUserMergeData");
            super(r100, null, 60);
            this.f75964q = r100;
        }
    }

    public interface b {
        void K1(String r100);
    }

    public MultiLinkPCLandscapeViewBinder(xg0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "linkSeatAbilityProvider");
        this.f75962b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r100, a r101) {
        h((ItemViewHolder) r100, r101);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        int r102 = hg0.c.f485001a;
        MicSeatScene r103 = MicSeatScene.VIDEO_LINK;
        xg0.a r104 = this.f75962b;
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r103, "scene");
        Intrinsics.checkNotNullParameter(r104, "linkSeatAbilityProvider");
        mg0.a r105 = new mg0.a(r103, r104);
        g r106 = new g(r101);
        r106.b(r105);
        r106.a(r101.getContext());
        return new ItemViewHolder(r106);
    }

    public final void h(ItemViewHolder r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        r100.f75963a.v(r101, r101.f545685a);
        xg0.a r102 = this.f75962b;
        if (r102 == null) goto L9;
        String r103 = r101.f75934k.f23724a.getInteractId();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r102.K1(r103);
        return;
    }

    @Override // me.drakeet.multitype.b
    public final void c(RecyclerView.ViewHolder r100, a r101, List r102) {
        ItemViewHolder r103 = (ItemViewHolder) r100;
        a r104 = r101;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "payloads");
        h(r103, r104);
    }
}
