package com.bytedance.android.live.liveinteract.linkpanel.list;

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
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.utils.p6;
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
public final class FriendsItemBinder extends me.drakeet.multitype.b<f, ViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f74877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ILinkPlayerInfoBridge, Unit> f74878c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/FriendsItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HSImageView f74879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f74880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f74881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f74882d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinearLayout f74883e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SimpleDraweeView f74884f;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f74879a = (HSImageView) r100.findViewById(R.id.img_avatar);
            this.f74880b = r100.findViewById(R.id.v_online_state);
            this.f74881c = (TextView) r100.findViewById(R.id.tv_nickname);
            this.f74882d = (TextView) r100.findViewById(R.id.btn_invite);
            this.f74883e = (LinearLayout) r100.findViewById(R.id.anim_container);
            this.f74884f = (SimpleDraweeView) r100.findViewById(R.id.calling);
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
    public FriendsItemBinder(boolean r100, Function1<? super ILinkPlayerInfoBridge, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onInvite");
        this.f74877b = r100;
        this.f74878c = r101;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r110, f r111) {
        ViewHolder r112 = (ViewHolder) r110;
        f r113 = r111;
        Intrinsics.checkNotNullParameter(r112, "holder");
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        ILinkPlayerInfoBridge r114 = r113.f74948a;
        HSImageView r100 = r112.f74879a;
        IBaseUser r101 = r114.getUser();
        if (r101 == null) goto L5;
        py.k r102 = r101.getAvatarThumbKt();
    L6:
        ImageUtil.loadRoundImage(r100, r102);
        View r103 = r112.f74880b;
        if (r114.isActive() == false) goto L9;
        int r104 = 0;
    L10:
        r103.setVisibility(r104);
        TextView r105 = r112.f74881c;
        IBaseUser r106 = r114.getUser();
        if (r106 == null) goto L13;
        String r107 = r106.getRealNickName();
    L14:
        r105.setText(r107);
        if (r114.isInviting() == false) goto L17;
        r112.f74883e.setVisibility(0);
        r112.f74882d.setVisibility(8);
        r112.f74884f.setController(Fresco.newDraweeControllerBuilder().setUri("https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_invite_list_calling.webp").setAutoPlayAnimations(true).build());
        r112.f74884f.postDelayed(new j(r112), 30000);
        r114.setInviting(false);
    L17:
        TextView r108 = r112.f74882d;
        boolean r109 = h(r114);
        if (r109 == false) goto L20;
        r108.setOnClickListener(new i(r112, this, r114));
    L21:
        if (r109 == false) goto L23;
        String r115 = s1.B(R.string.ttlive_live_interact_invite);
    L24:
        r108.setText(r115);
        if (r109 == false) goto L27;
        int r116 = R.drawable.ttlive_bg_live_red_btn;
    L28:
        r108.setBackgroundResource(r116);
        if (r114.isHasExposed() == true) goto L47;
        boolean r117 = this.f74877b;
        IBaseUser r118 = r114.getUser();
        Intrinsics.checkNotNull(r118);
        String r119 = r118.getIdString();
        boolean r120 = r114.isActive();
        boolean r121 = h(r114);
        IBaseUser r122 = r114.getUser();
        Intrinsics.checkNotNull(r122);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.i(r117, r119, r120, r121, r122.isSubscriber(), "mutual");
        boolean r123 = this.f74877b;
        IBaseUser r124 = r114.getUser();
        Intrinsics.checkNotNull(r124);
        String r125 = r124.getIdString();
        boolean r126 = r114.isActive();
        boolean r127 = h(r114);
        Intrinsics.checkNotNullParameter(r125, "inviteeId");
        if (com.bytedance.android.live.liveinteract.linkpanel.util.m.h() == true) goto L45;
        HashMap r128 = new HashMap();
        if (r123 == false) goto L35;
        String r129 = "voice_live";
    L36:
        r128.put("live_type", r129);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r128, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), 4);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.H(r128, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        r128.put("invitee_id", r125.toString());
        if (r126 == false) goto L39;
        String r130 = "online";
    L40:
        r128.put("online_status", r130);
        if (r127 == false) goto L43;
        String r131 = "1";
    L44:
        r128.put("icon_type", r131);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.L("livesdk_audience_invitee_show", r128, new Object[0]);
        goto L45
    L43:
        r131 = "0";
        goto L44
    L39:
        r130 = OperationName.OPERATION_OFFLINE_AVAILABLE;
        goto L40
    L35:
        r129 = "video_live";
    L45:
        r114.setHasExposed(true);
        return;
    L47:
        return;
    L27:
        r116 = R.drawable.ttlive_bg_live_grey_btn;
        goto L28
    L23:
        r115 = s1.B(R.string.ttlive_live_interact_invite_ready);
        goto L24
    L20:
        r108.setOnClickListener(null);
        goto L21
    L13:
        r107 = null;
        goto L14
    L9:
        r104 = 8;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ViewHolder(r100.inflate(R.layout.ttlive_item_talk_friend, r101, false));
    }
}
