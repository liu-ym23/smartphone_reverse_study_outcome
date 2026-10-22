package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectInfo;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectPriority;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@LiveAtomicAbilityDescriptor(action = "redirect_api_path", description = "直播间重定向", service = {"LiveBase"})
public final class u extends com.bytedance.android.livesdk.livecommerce.ability.d<LiveRoomRedirectInfo> {

    public static final class a {
    }

    static {
    }

    public u() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r110, LiveRoomRedirectInfo r111, Object r112, il2.a r210, com.bytedance.android.livesdk.livecommerce.ability.e r211) {
        LiveRoomRedirectInfo r100 = r111;
        Object r101 = r112;
        String r102 = null;
        if ((r101 instanceof RoomContextController) == true) goto L5;
        r101 = null;
    L5:
        RoomContextController r103 = (RoomContextController) r101;
        if (r103 != null) goto L8;
        int r104 = RoomContextController.f151593h;
        r103 = RoomContextController.a.a();
    L8:
        if (r100 == null) goto L11;
        Map r105 = r100.f151922b;
        if (r105 == null) goto L11;
    L12:
        if (r100 == null) goto L14;
        r102 = r100.f151921a;
    L14:
        String r106 = r102;
        if (r100 == null) goto L18;
        LiveRoomRedirectPriority r107 = r100.f151923c;
        if (r107 == null) goto L18;
    L19:
        LiveRoomRedirectPriority r108 = r107;
        if (r100 == null) goto L22;
        long r109 = r100.f151924d;
    L23:
        LiveRoomRedirectInfo r113 = r103.f151598g;
        if (r113 == null) goto L26;
        long r114 = r113.f151924d;
    L27:
        LiveRoomRedirectInfo r115 = r103.f151598g;
        if (r115 == null) goto L31;
        LiveRoomRedirectPriority r116 = r115.f151923c;
        if (r116 == null) goto L31;
    L32:
        dm.a.a("LiveRedirectAbility").a("current: " + r103.f151598g + " params: " + r100);
        if (r108.compareTo(r116) >= 0) goto L36;
        dm.a.a("LiveRedirectAbility").i("current: " + r103.f151598g + " params: " + r100 + " priority < currPriority");
        return;
    L36:
        if (r109 > 0) goto L38;
    L40:
        Intrinsics.checkNotNullParameter(r105, "map");
        Intrinsics.checkNotNullParameter(r108, "priority");
        r103.f151598g = new LiveRoomRedirectInfo(r106, MapsKt.toMap(r105), r108, 0);
    L41:
        if (r211 == null) goto L45;
        r211.onSuccess();
        return;
    L45:
        return;
    L38:
        if (r109 <= r114) goto L40;
        Intrinsics.checkNotNullParameter(r105, "map");
        Intrinsics.checkNotNullParameter(r108, "priority");
        r103.f151598g = new LiveRoomRedirectInfo(r106, MapsKt.toMap(r105), r108, r109);
    L31:
        r116 = LiveRoomRedirectPriority.UNDEFINED;
        goto L32
    L26:
        r114 = 0;
        goto L27
    L22:
        r109 = 0;
    L18:
        r107 = LiveRoomRedirectPriority.UNDEFINED;
    L11:
        r105 = new LinkedHashMap();
        goto L12
    }
}
