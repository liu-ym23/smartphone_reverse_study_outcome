package com.bytedance.android.live.profit.vote.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.revenue.common.l0;
import com.bytedance.android.scope.o;
import is2.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements b, o {
    public a() {
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
        return "webcast_gift_vote_list";
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // is2.b
    public final boolean enable() {
        return l0.a("vote");
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return com.bytedance.android.live.profit.vote.transfer.a.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", true);
        BaseMonitor.add(r102, "biz_data_type", "pb");
        BaseMonitor.add(r102, "request_source", "enter_room");
        return r102;
    }
}
