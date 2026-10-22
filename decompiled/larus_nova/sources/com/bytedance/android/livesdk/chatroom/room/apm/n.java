package com.bytedance.android.livesdk.chatroom.room.apm;

import android.os.Bundle;
import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f110709a;

    public n(p r100) {
        this.f110709a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        p r102 = this.f110709a;
        r102.f110721k = new LinkedList();
        p r103 = this.f110709a;
        r103.f110720j = new JSONObject();
        p r104 = this.f110709a;
        r104.f110718h = new JSONObject();
        p r105 = this.f110709a;
        r105.f110719i = new JSONObject();
        p r106 = this.f110709a;
        r106.f110726p = new HashMap();
        Bundle r107 = new Bundle();
        r107.putString(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_TYPE, this.f110709a.f110711a.getString(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_TYPE, ""));
        r107.putLong(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_STAR_TIME, System.currentTimeMillis());
        p r108 = this.f110709a;
        r108.f110711a = r107;
        r108.f110728r = 0;
        r108.f110729s = 0;
        r108.f110730t = 0;
        r108.f110727q = new p.b();
        r108.b(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "scroll to this room"));
        RoomExitExtensionMonitor r109 = this.f110709a.f110724n;
        if (r109 == null) goto L6;
        r109.j();
        return;
    }
}
