package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class FriendsItemBinderHorizontal extends me.drakeet.multitype.b<f, ViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f74885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ILinkPlayerInfoBridge, Unit> f74886c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/FriendsItemBinderHorizontal$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HSImageView f74887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f74888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f74889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f74890d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f74891e;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f74887a = (HSImageView) r100.findViewById(R.id.img_avatar);
            this.f74888b = r100.findViewById(R.id.v_online_state);
            this.f74889c = (TextView) r100.findViewById(R.id.user_nick);
            this.f74890d = (ImageView) r100.findViewById(R.id.invited_shader);
            this.f74891e = (ImageView) r100.findViewById(R.id.invited_arrow);
        }
    }

    public final boolean h(ILinkPlayerInfoBridge r100) {
        int r101 = vm2.d.i();
        if (r100.getLastInvitedTimeMillis() >= 0) goto L5;
    L8:
        return true;
    L5:
        if ((p6.b() - r100.getLastInvitedTimeMillis()) > (r101 * 1000)) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendsItemBinderHorizontal(boolean r100, Function1<? super ILinkPlayerInfoBridge, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onInvite");
        this.f74885b = r100;
        this.f74886c = r101;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, f r101) {
        ViewHolder r102 = (ViewHolder) r100;
        f r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        ILinkPlayerInfoBridge r104 = r103.f74948a;
        HSImageView r105 = r102.f74887a;
        IBaseUser r106 = r104.getUser();
        String r107 = null;
        if (r106 == null) goto L5;
        py.k r108 = r106.getAvatarThumbKt();
    L6:
        ImageUtil.loadRoundImage(r105, r108);
        View r109 = r102.f74888b;
        if (r104.isActive() == false) goto L13;
        IBaseUser r110 = r104.getUser();
        if (r110 == null) goto L13;
        if (r110.isMysteryMan() == true) goto L13;
        int r111 = 0;
    L14:
        r109.setVisibility(r111);
        if (r104.isActive() == false) goto L21;
        IBaseUser r112 = r104.getUser();
        if (r112 == null) goto L21;
        if (r112.isMysteryMan() == true) goto L21;
        String r113 = s1.B(R.string.ttlive_live_interact_invite_active);
    L22:
        TextView r114 = r102.f74889c;
        IBaseUser r115 = r104.getUser();
        if (r115 == null) goto L25;
        String r116 = r115.getRealNickName();
    L26:
        r114.setText(r116);
        if (h(r104) == false) goto L32;
        r102.f74889c.setTextColor(ColorProtector.parseColor("#E5161823"));
        r102.itemView.setOnClickListener(new k(r102, this, r104));
        r102.f74890d.setVisibility(8);
        r102.f74891e.setVisibility(8);
        View r117 = r102.itemView;
        StringBuilder r118 = new StringBuilder();
        IBaseUser r119 = r104.getUser();
        if (r119 == null) goto L31;
        r107 = r119.getRealNickName();
    L31:
        r118.append(r107);
        r118.append(' ');
        r118.append(r113);
        r3.a(r117, r118.toString());
    L37:
        if (r104.isHasExposed() == true) goto L40;
        boolean r120 = this.f74885b;
        IBaseUser r121 = r104.getUser();
        Intrinsics.checkNotNull(r121);
        String r122 = r121.getIdString();
        boolean r123 = r104.isActive();
        boolean r124 = h(r104);
        IBaseUser r125 = r104.getUser();
        Intrinsics.checkNotNull(r125);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.i(r120, r122, r123, r124, r125.isSubscriber(), "mutual");
        r104.setHasExposed(true);
        return;
    L40:
        return;
    L32:
        String r126 = s1.B(R.string.ttlive_live_interact_invite_ready);
        r102.itemView.setOnClickListener(null);
        r102.f74889c.setText(r126);
        r102.f74889c.setTextColor(ColorProtector.parseColor("#57161823"));
        r102.f74890d.setVisibility(0);
        r102.f74891e.setVisibility(0);
        View r127 = r102.itemView;
        StringBuilder r128 = new StringBuilder();
        r128.append(r126);
        r128.append(' ');
        IBaseUser r129 = r104.getUser();
        if (r129 == null) goto L35;
        r107 = r129.getRealNickName();
    L35:
        r128.append(r107);
        r128.append(' ');
        r128.append(r113);
        r3.a(r127, r128.toString());
        goto L37
    L25:
        r116 = null;
    L21:
        r113 = "";
    L13:
        r111 = 8;
        goto L14
    L5:
        r108 = null;
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ViewHolder(r100.inflate(R.layout.ttlive_item_invite_my_friends, r101, false));
    }
}
