package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.config.ty;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends mx.l {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Room f114093p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ListDialogAbility f114094q;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.setting.a$a, reason: collision with other inner class name */
    public static final class C1685a {
    }

    static {
    }

    public a(Room r110, ListDialogAbility r111) {
        Intrinsics.checkNotNullParameter(r111, "ability");
        String r100 = s1.B(R.string.ttlive_setting_open_audience_receive_gift);
        com.bytedance.android.livesdk.sharedpref.e<Long> r101 = com.bytedance.android.livesdk.sharedpref.b.f158136d3;
        Long r102 = r101.getValue();
        if (r102 != null) goto L6;
    L10:
        String r103 = ty.f121334a.getValue().c();
        if (r103 != null) goto L13;
        r103 = s1.B(R.string.ttlive_setting_audience_receive_gift_open_tips);
    L13:
        String r104 = r103;
        Long r105 = r101.getValue();
        if (r105 != null) goto L17;
    L19:
        boolean r106 = false;
    L20:
        super(r100, r104, r106, false, false, null, 120);
        this.f114093p = r110;
        this.f114094q = r111;
        return;
    L17:
        if (r105.longValue() != 1) goto L19;
        r106 = true;
        goto L20
    L6:
        if (r102.longValue() != 1) goto L10;
        r103 = ty.f121334a.getValue().b();
        if (r103 != null) goto L13;
        r103 = s1.B(R.string.ttlive_setting_audience_receive_gift_close_tips);
        goto L13
    }

    @Override // mx.l
    public final void c(SwitchSettingViewHolder r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        Intrinsics.checkNotNullParameter(r110, "holder");
        this.f516148l = r111;
        Room r100 = this.f114093p;
        if (r100 != null) goto L5;
        return;
    L5:
        long r101 = r100.getRoomId();
        String r102 = this.f114093p.getOwnerUserIdString();
        if (r111 == false) goto L8;
        long r103 = 1;
    L9:
        long r104 = r103;
        Disposable r105 = this.f516149m;
        if (r105 == null) goto L12;
        r105.dispose();
    L12:
        com.bytedance.android.livesdk.service.l.d().getClass();
        this.f516149m = ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).updateAudienceAuthSwitch(r101, r102, r104).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r111, r110, r101, r102), new c(this, r111, r101, r102));
        return;
    L8:
        r103 = 2;
        goto L9
    }

    public static final void g(a r100, long r101, String r102, boolean r103, boolean r104) {
        r100.getClass();
        HashMap r105 = new HashMap();
        r105.put("anchor_id", r102.toString());
        r105.put("room_id", String.valueOf(r101));
        if (r103 == false) goto L5;
        String r106 = "turn_on";
    L6:
        r105.put("click_type", r106);
        if (r104 == false) goto L9;
        String r107 = "success";
    L10:
        r105.put("click_result", r107);
        com.bytedance.android.livesdk.log.u.l().sendLog("audience_receive_click", r105, new Object[]{new am2.x(), Room.class});
        return;
    L9:
        r107 = "failure";
        goto L10
    L5:
        r106 = "turn_off";
        goto L6
    }
}
