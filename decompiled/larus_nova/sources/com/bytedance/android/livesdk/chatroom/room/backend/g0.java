package com.bytedance.android.livesdk.chatroom.room.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livesdk.config.dl0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.utils.PSTopMessagePayload;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class g0 implements is2.b {
    @Override // is2.b
    public final /* synthetic */ boolean a() {
        return false;
    }

    @Override // is2.b
    public final /* synthetic */ boolean c() {
        return false;
    }

    @Override // is2.b
    public final void d() {
    }

    @Override // is2.b
    public final boolean f() {
        return true;
    }

    @Override // is2.b
    public final String getPath() {
        return "backend_top_message";
    }

    @Override // is2.b
    public final boolean enable() {
        if (dl0.f120047a.getValue().booleanValue() == false) goto L5;
    L8:
        return true;
    L5:
        if (PublicScreenABHelper.P == true) goto L8;
        return false;
    }

    public g0() {
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return PSTopMessagePayload.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        if (r100 == null) goto L4;
        long r102 = r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_BACKEND_ROOMID);
    L5:
        JSONObject r103 = new JSONObject();
        BaseMonitor.add(r103, "room_id", r102);
        BaseMonitor.add(r103, "biz_data_type", 2);
        BaseMonitor.add(r103, "open", true);
        return r103;
    L4:
        r102 = 0;
        goto L5
    }
}
