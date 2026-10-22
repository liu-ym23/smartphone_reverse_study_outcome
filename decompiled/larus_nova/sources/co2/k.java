package co2;

import am2.x;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.performance.h0;
import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.q;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements q {
    public k() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L57;
        com.bytedance.android.livesdk.log.filter.o r102 = u.l().c(x.class);
        com.bytedance.android.livesdk.log.filter.o r103 = u.l().c(Room.class);
        if (r102 == null) goto L7;
        r102.a(r100);
    L7:
        if (r103 == null) goto L10;
        r103.a(r100);
    L10:
        if (r101.f154693a == false) goto L17;
        HashMap r104 = (HashMap) r100;
        if (r104.containsKey("room_id") == true) goto L17;
        Room r105 = ((IRoomService) jc1.k.f(IRoomService.class)).getCurrentRoom();
        if (r105 == null) goto L17;
        r104.put("room_id", String.valueOf(r105.getId()));
    L17:
        if (r101.f154693a == false) goto L24;
        HashMap r106 = (HashMap) r100;
        if (r106.containsKey("anchor_id") == true) goto L24;
        IUser r107 = ((IUserService) jc1.k.f(IUserService.class)).user().b();
        if ((r107 instanceof User) == false) goto L24;
        r106.put("anchor_id", ((User) r107).getIdString());
    L24:
        if (r101.f154693a == false) goto L26;
        HashMap r108 = (HashMap) r100;
        r108.put("is_multi_process", String.valueOf(r101.f154696b));
    L26:
        boolean r109 = r101.f154699c;
        String r110 = "1";
        if (r109 == false) goto L32;
        if (r109 == false) goto L30;
        Object r111 = "1";
    L31:
        ((HashMap) r100).put("is_restart_broadcast", r111);
        goto L32
    L30:
        r111 = "0";
    L32:
        HashMap r112 = (HashMap) r100;
        r112.put("scene", r101.f154708f);
        r112.put(IPerformanceManager.Params.room_type, r101.f154705e);
        if (r101.f154693a == false) goto L35;
        Object r113 = "1";
    L36:
        r112.put(IPerformanceManager.Params.is_anchor, r113);
        if (r101.f154702d == false) goto L39;
        Object r114 = "1";
    L40:
        r112.put("is_live", r114);
        r112.put(IPerformanceManager.Params.draw_room_count, String.valueOf(h0.f154660a));
        RoomContext r115 = (RoomContext) com.bytedance.live.datacontext.d.d(RoomContext.class);
        if (r101.f154693a == true) goto L49;
        if (r115 == null) goto L49;
        if (r115.isPortraitInteraction().getValue().booleanValue() == true) goto L47;
        r110 = "0";
    L47:
        r112.put(IPerformanceManager.Params.is_portrait, r110);
    L49:
        if (r101.f154693a == false) goto L52;
        String r116 = "anchor";
    L55:
        r112.put("user_type", r116);
        return;
    L52:
        if (hd0.c.f().h() == false) goto L54;
        r116 = "guest";
        goto L55
    L54:
        r116 = "user";
        goto L55
    L39:
        r114 = "0";
        goto L40
    L35:
        r113 = "0";
        goto L36
    }
}
