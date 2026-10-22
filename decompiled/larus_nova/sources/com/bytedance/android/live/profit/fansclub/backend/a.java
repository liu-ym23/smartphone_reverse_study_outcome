package com.bytedance.android.live.profit.fansclub.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.profit.fansclub.i;
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
        return "backend_webcast_fansclub_homepage";
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // is2.b
    public final boolean enable() {
        if (i.d() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return IGetFansclubHomepageResult.class;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "open", true);
        BaseMonitor.add(r102, "biz_data_type", 2);
        BaseMonitor.add(r102, "source", 1);
        return r102;
    }
}
