package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.livesdk.config.a8;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class PkFriendsItemBinder extends me.drakeet.multitype.b<g, ViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f82029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<LinkPlayerInfo, Unit> f82030c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkFriendsItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HSImageView f82031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f82032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f82033c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f82034d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinearLayout f82035e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SimpleDraweeView f82036f;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f82031a = (HSImageView) r100.findViewById(R.id.img_avatar);
            this.f82032b = r100.findViewById(R.id.v_online_state);
            this.f82033c = (TextView) r100.findViewById(R.id.tv_nickname);
            this.f82034d = (TextView) r100.findViewById(R.id.btn_invite);
            this.f82035e = (LinearLayout) r100.findViewById(R.id.anim_container);
            this.f82036f = (SimpleDraweeView) r100.findViewById(R.id.calling);
        }
    }

    public static boolean h(LinkPlayerInfo r100) {
        Integer r101 = a8.f119769a.getValue();
        if (r100.lastInvitedTimeMillis >= 0) goto L5;
    L8:
        return true;
    L5:
        if ((p6.b() - r100.lastInvitedTimeMillis) > (r101.intValue() * 1000)) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkFriendsItemBinder(boolean r100, Function1<? super LinkPlayerInfo, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onInvite");
        this.f82029b = r100;
        this.f82030c = r101;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r110, g r111) {
        final ViewHolder r112 = (ViewHolder) r110;
        g r113 = r111;
        Intrinsics.checkNotNullParameter(r112, "holder");
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        final LinkPlayerInfo r114 = r113.f82094a;
        HSImageView r100 = r112.f82031a;
        IBaseUser r101 = r114.getUser();
        String r102 = null;
        if (r101 == null) goto L5;
        py.k r103 = r101.getAvatarThumbKt();
    L6:
        ImageUtil.loadRoundImage(r100, r103);
        View r104 = r112.f82032b;
        if (r114.isActive == false) goto L9;
        int r105 = 0;
    L10:
        r104.setVisibility(r105);
        TextView r106 = r112.f82033c;
        IBaseUser r107 = r114.getUser();
        if (r107 == null) goto L13;
        String r108 = r107.getRealNickName();
    L14:
        r106.setText(r108);
        if (r114.isInviting == false) goto L17;
        r112.f82035e.setVisibility(0);
        r112.f82034d.setVisibility(8);
        r112.f82036f.setController(Fresco.newDraweeControllerBuilder().setUri("https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_invite_list_calling.webp").setAutoPlayAnimations(true).build());
        r112.f82036f.postDelayed(new h(r112), 30000);
        r114.isInviting = false;
    L17:
        TextView r109 = r112.f82034d;
        boolean r115 = h(r114);
        if (r115 == false) goto L20;
        r109.setOnClickListener(x0.a(new PkFriendsItemBinder$onBindViewHolder$$inlined$apply$lambda$1(this, r114, r112)));
    L21:
        if (r115 == false) goto L23;
        String r116 = s1.B(R.string.ttlive_live_interact_invite);
    L24:
        r109.setText(r116);
        if (r115 == false) goto L27;
        int r117 = R.drawable.ttlive_bg_live_red_btn;
    L28:
        r109.setBackgroundResource(r117);
        if (r114.mHasExposed == true) goto L58;
        int r118 = al0.d.f4121a;
        boolean r119 = this.f82029b;
        IBaseUser r120 = r114.getUser();
        if (r120 == null) goto L33;
        String r121 = r120.getIdString();
    L34:
        long r122 = d5.c(r121);
        boolean r123 = r114.isActive;
        boolean r124 = h(r114);
        IBaseUser r125 = r114.getUser();
        if (r125 == null) goto L37;
        boolean r126 = r125.isSubscriber();
    L38:
        al0.d.c(r119, r122, r123, r124, r126);
        boolean r127 = this.f82029b;
        IBaseUser r128 = r114.getUser();
        if (r128 == null) goto L41;
        r102 = r128.getIdString();
    L41:
        long r129 = d5.c(r102);
        boolean r130 = r114.isActive;
        boolean r131 = h(r114);
        if (al0.d.b() == true) goto L56;
        HashMap r132 = new HashMap();
        if (r127 == false) goto L46;
        String r133 = "voice_live";
    L47:
        r132.put("live_type", r133);
        el0.j.j(r132, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        el0.j.n(r132, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        r132.put("invitee_id", String.valueOf(r129));
        if (r130 == false) goto L50;
        String r134 = "online";
    L51:
        r132.put("online_status", r134);
        if (r131 == false) goto L54;
        String r135 = "1";
    L55:
        r132.put("icon_type", r135);
        al0.d.g("livesdk_audience_invitee_show", r132, new Object[0]);
        goto L56
    L54:
        r135 = "0";
        goto L55
    L50:
        r134 = OperationName.OPERATION_OFFLINE_AVAILABLE;
        goto L51
    L46:
        r133 = "video_live";
    L56:
        r114.mHasExposed = true;
        return;
    L37:
        r126 = false;
        goto L38
    L33:
        r121 = null;
        goto L34
    L58:
        return;
    L27:
        r117 = R.drawable.ttlive_bg_live_grey_btn;
        goto L28
    L23:
        r116 = s1.B(R.string.ttlive_live_interact_invite_ready);
        goto L24
    L20:
        r109.setOnClickListener(null);
        goto L21
    L13:
        r108 = null;
        goto L14
    L9:
        r105 = 8;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ViewHolder(r100.inflate(R.layout.ttlive_item_pk_guest_friend, r101, false));
    }
}
