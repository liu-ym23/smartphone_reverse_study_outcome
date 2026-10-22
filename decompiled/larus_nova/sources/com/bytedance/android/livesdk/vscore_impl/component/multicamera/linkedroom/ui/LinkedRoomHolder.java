package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui;

import am2.x;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.view.VSLinkedAvatarContainer;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomNode;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/ui/LinkedRoomHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkedRoomHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f159657g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f159658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f159659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f159660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f159661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VSLinkedRoomNode f159662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f159663f;

    public interface a {
        long[] e0();

        DataCenter getDataCenter();

        ITabView.Scene getScene();

        Function0<Unit> i();
    }

    public static final class b {
    }

    static {
    }

    public LinkedRoomHolder(View r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f159663f = r101;
        VSLinkedAvatarContainer r102 = (VSLinkedAvatarContainer) r100.findViewById(R.id.container);
        this.f159658a = (HSImageView) r100.findViewById(R.id.avatar);
        this.f159659b = (TextView) r100.findViewById(R.id.tv_nick_name);
        this.f159660c = (SimpleDraweeView) r100.findViewById(R.id.living_view);
        float r103 = 39;
        r102.setCenterX(UtilityKotlinExtentionsKt.h(r103));
        r102.setCenterY(UtilityKotlinExtentionsKt.h(r103));
        r102.setRadius(UtilityKotlinExtentionsKt.h(9.0f));
        r102.setEnableCircle(true);
        if (r101.getScene().enableLinkedGoWatchBtn() == false) goto L6;
        this.f159661d = (TextView) r100.findViewById(R.id.go_to_live_room);
        return;
    }

    public static final void T3(LinkedRoomHolder r100, String r110) {
        VSLinkedRoomNode r101 = r100.f159662e;
        if (r101 == null) goto L48;
        int r102 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.b.f159780a;
        DataCenter r103 = r100.f159663f.getDataCenter();
        Intrinsics.checkNotNullParameter(r101, "roomNode");
        Intrinsics.checkNotNullParameter(r110, "clickPos");
        HashMap r104 = new HashMap();
        r104.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "relevant_live");
        r104.put("vs_click_position", r110);
        Map<String, String> r111 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.a(r103);
        if (r111 == null) goto L8;
        r104.putAll(r111);
    L8:
        Long r112 = null;
        if (r103 != null) goto L12;
    L39:
        r100.f159663f.i().invoke();
        Bundle r105 = new Bundle();
        r105.putString("enter_from_merge", "vs_player_detail");
        r105.putString("enter_method", "vs_relevant_live_panel");
        IBaseUser r106 = r101.getOwner();
        if (r106 == null) goto L42;
        String r107 = r106.getIdString();
    L43:
        r105.putString("anchor_id", r107);
        r105.putLongArray(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_IDS, r100.f159663f.e0());
        String r108 = VSConstants.EXTRA_VS_FROM_EPISODE_ID;
        IEpisodeExtraInfo r109 = lu2.c.f(r100.f159663f.getDataCenter()).getEpisodeExtra();
        if (r109 == null) goto L46;
        r112 = Long.valueOf(r109.getId());
    L46:
        r105.putString(r108, String.valueOf(r112));
        r105.putLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID, r101.getRoomId());
        xs2.b.a().post(new JumpToOtherRoomEvent(r101.getRoomId(), r105));
        return;
    L42:
        r107 = null;
        goto L43
    L12:
        if (r101.isVS() == false) goto L21;
        Episode r113 = r101.getEpisodeExtra();
        if (r113 == null) goto L20;
        EpisodeMod r114 = r113.episodeMod;
        if (r114 == null) goto L20;
        if (r114.episodeStage != EpisodeMod.EpisodeStageType.PREMIERE) goto L20;
        String r115 = "vs_premiere";
    L22:
        Pair[] r116 = new Pair[4];
        r116[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "relevant_live");
        r116[1] = TuplesKt.to("to_room_type", r115);
        r116[2] = TuplesKt.to("to_room_id", String.valueOf(r101.getRoomId()));
        IBaseUser r117 = r101.getOwner();
        if (r117 == null) goto L26;
        String r118 = r117.getIdString();
        if (r118 == null) goto L26;
    L27:
        r116[3] = TuplesKt.to("to_anchor_id", r118);
        Map<String, String> r119 = MapsKt.mutableMapOf(r116);
        if (r101.isVS() == false) goto L38;
        Episode r120 = r101.getEpisodeExtra();
        if (r120 == null) goto L32;
        Long r121 = Long.valueOf(r120.getId());
    L33:
        r119.put("to_vs_episode_id", String.valueOf(r121));
        Episode r122 = r101.getEpisodeExtra();
        if (r122 == null) goto L36;
        String r123 = r122.itemId;
    L37:
        r119.put("to_vs_group_id", String.valueOf(r123));
        goto L38
    L36:
        r123 = null;
        goto L37
    L32:
        r121 = null;
    L38:
        r119.putAll(r104);
        r.l().sendLog("livesdk_relevant_live_panel_click", r119, new Object[]{x.class, Room.class});
    L26:
        r118 = "";
    L20:
        r115 = PriorityModule.SCENE_VS_LIVE;
        goto L22
    L21:
        r115 = "normal_room";
        goto L22
    }
}
