package com.bytedance.android.livesdk.chatroom.room.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class f0 implements is2.b {
    public f0() {
    }

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
    public final /* synthetic */ boolean f() {
        return false;
    }

    @Override // is2.b
    public final String getPath() {
        return "webcast_linkmic_audience_list_v2";
    }

    @Override // is2.b
    public final boolean enable() {
        return MultiLinkLoadWidgetUtils.c();
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return w0.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", true);
        BaseMonitor.add(r102, "biz_data_type", 2);
        return r102;
    }
}
