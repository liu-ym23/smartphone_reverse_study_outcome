package com.bytedance.android.livesdk.chatroom.end;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.LinkMicBattleSetting;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLinkInfo;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class t<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f106116a = null;

    static {
        f106116a = new t();
    }

    public t() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        RoomLinkInfo r101 = (RoomLinkInfo) r100;
        Intrinsics.checkNotNullParameter(r101, "interactInfo");
        HashMap r102 = new HashMap();
        LinkMicBattleSetting r103 = r101.battleSetting;
        if (r103 != null) goto L5;
    L7:
        r102.put("channel_id", String.valueOf(r101.channelId));
        r102.put("connection_type", "anchor");
    L8:
        return r102;
    L5:
        if (r103.duration == 0) goto L7;
        r102.put("channel_id", String.valueOf(r101.channelId));
        r102.put("pk_id", String.valueOf(r101.battleSetting.battleId));
        r102.put("connection_type", PbRequest.SwitchType.PK);
        r102.put("theme", r101.battleSetting.theme);
        r102.put("pk_time", String.valueOf(r101.battleSetting.duration));
        goto L8
    }
}
