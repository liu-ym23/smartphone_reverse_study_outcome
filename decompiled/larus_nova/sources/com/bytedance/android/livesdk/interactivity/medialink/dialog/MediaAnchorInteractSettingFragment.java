package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorInteractSettingContract$View;
import com.bytedance.android.livesdk.interactivity.medialink.network.LinkCrossRoomApi;
import com.bytedance.android.livesdk.interactivity.medialink.network.LinkCrossRoomApiCompat;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public class MediaAnchorInteractSettingFragment extends MediaAnchorInteractSettingContract$View implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f138009h = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Switch f138010g;

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final View U90() {
        AutoRTLImageView r100 = new AutoRTLImageView(getContext());
        r100.setLayoutParams(new RelativeLayout.LayoutParams(s1.f(32.0f), s1.f(32.0f)));
        r100.setImageDrawable(s1.m(R.drawable.ttlive_ic_pk_back));
        r100.setOnClickListener(new e(this));
        r3.c(r100, s1.B(R.string.ttlive_label_back), true);
        return r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final String V90() {
        return getString(R.string.ttlive_media_link_setting);
    }

    public MediaAnchorInteractSettingFragment() {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, final boolean r101) {
        if (r100.getId() != R.id.switch_apply_link_invitations) goto L12;
        Room r102 = ((IRoomService) jc1.k.f(IRoomService.class)).getCurrentRoom();
        HashMap r103 = new HashMap();
        r103.put("is_turn_on", Boolean.valueOf(r101));
        if (r102 == null) goto L13;
        LinkCrossRoomApiCompat r104 = (LinkCrossRoomApiCompat) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApiCompat.class);
        long r105 = r102.getId();
        if (r102.getBaseOwner() == null) goto L9;
        String r106 = r102.getBaseOwner().getCastSecUid();
    L10:
        ((SingleSubscribeProxy) r104.updateAnchorLinkSetting(r105, r106, 0, r103).as(S90())).subscribe(new f(r101), new g60.c());
        return;
    L9:
        r106 = "";
        goto L10
    L13:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.ttlive_media_fragment_anchor_interact_setting, r101, false);
        Switch r104 = (Switch) r103.findViewById(R.id.switch_apply_link_invitations);
        this.f138010g = r104;
        r104.setChecked(com.bytedance.android.livesdk.sharedpref.b.S1.getValue().booleanValue());
        Room r105 = RoomContext.getShared().getRoom().getValue();
        if (r105 == null) goto L5;
        ((SingleSubscribeProxy) ((LinkCrossRoomApi) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApi.class)).getAnchorLinkSetting(r105.getId(), r105.getBaseOwner().getCastSecUid()).as(S90())).subscribe(new c(this), new d());
    L5:
        this.f138010g.setOnCheckedChangeListener(this);
        return r103;
    }
}
