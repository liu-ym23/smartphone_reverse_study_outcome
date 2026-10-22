package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.view.NoPaddingTextView;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkPaidViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkPaidViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int f75965h = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f75966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f75967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HSImageView f75968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final HSImageView f75969d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinearLayout f75970e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final NoPaddingTextView f75971f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f75972g;

        public ItemViewHolder(View r100, ViewGroup r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "parentView");
            super(r100);
            this.f75966a = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_video_bid_paid_coin_anim.webp";
            this.f75968c = (HSImageView) this.itemView.findViewById(R.id.background_view);
            this.f75969d = (HSImageView) this.itemView.findViewById(R.id.front_view);
            this.f75970e = (LinearLayout) this.itemView.findViewById(R.id.end_link_bid_container);
            this.f75971f = (NoPaddingTextView) this.itemView.findViewById(R.id.end_link_bid_profit);
            this.f75967b = r101;
        }
    }

    public static final class a extends tf0.e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final ILinkPlayerInfoBridge f75974k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f75975l;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f75974k, r101.f75974k) == true) goto L8;
            return false;
        L8:
            if (this.f75975l == r101.f75975l) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ILinkPlayerInfoBridge r100 = this.f75974k;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.f75975l;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "PaidItemData(linkPlayerInfo=" + this.f75974k + ", position=" + this.f75975l + ")";
        }

        public a(ILinkPlayerInfoBridge r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "linkPlayerInfo");
            this.f75974k = r100;
            this.f75975l = r101;
        }
    }

    public MultiLinkPaidViewBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        ItemViewHolder r102 = (ItemViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        ILinkPlayerInfoBridge r104 = r103.f75974k;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "linkPlayInfo");
        ALogger.d("MultiLinkPaidViewBinder", "bind viewHolder: " + r102.hashCode());
        if (r102.f75972g == true) goto L10;
        HSImageView r105 = r102.f75969d;
        if (r105 != null) goto L7;
    L9:
        boolean r106 = false;
    L11:
        if (r106 == false) goto L14;
        ALogger.d("MultiLinkPaidViewBinder", "bind viewHolder: " + r102.hashCode() + ", return");
        return;
    L14:
        if (r104.isPaidUserLeave() == true) goto L16;
        return;
    L16:
        if (r104.getPaidCount() <= 0) goto L31;
        IBaseUser r107 = r104.getUser();
        if (r107 == null) goto L22;
        k r108 = r107.getAvatarThumbKt();
        if (r108 == null) goto L22;
        ImageLoader.bindImage(r102.f75968c, r108, new l3(5, r102.f75967b.getWidth() / r102.f75967b.getHeight(), null));
    L22:
        HSImageView r109 = r102.f75969d;
        if (r109 == null) goto L25;
        UtilityKotlinExtentionsKt.w(r109);
    L25:
        HSImageView r110 = r102.f75969d;
        if (r110 == null) goto L32;
        r110.setController(Fresco.newDraweeControllerBuilder().setUri(r102.f75966a).setAutoPlayAnimations(true).setControllerListener(new f(r102, r104)).build());
        return;
    L32:
        return;
    L31:
        return;
    L7:
        if (r105.isAnimating() != true) goto L9;
    L10:
        r106 = true;
        goto L11
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = LayoutInflater.from(r101.getContext()).inflate(R.layout.ttlive_item_multi_link_paid_stub, r101, false);
        TextView r103 = (TextView) r102.findViewById(R.id.end_link_bid_tips);
        if (r103 == null) goto L6;
        r103.setText(s1.C(R.string.ttlive_item_video_talkroom_end_link_bid_tips_new, new Object[]{r3.c()}));
    L6:
        return new ItemViewHolder(r102, r101);
    }

    @Override // me.drakeet.multitype.b
    public final void c(RecyclerView.ViewHolder r100, a r101, List r102) {
        ItemViewHolder r103 = (ItemViewHolder) r100;
        a r104 = r101;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "payloads");
        b(r103, r104);
    }
}
