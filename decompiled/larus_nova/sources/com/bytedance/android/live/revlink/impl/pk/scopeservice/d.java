package com.bytedance.android.live.revlink.impl.pk.scopeservice;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkLynxInfoImpl f96837a;

    public d(PkLynxInfoImpl r100) {
        this.f96837a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L6;
        boolean r102 = r101.booleanValue();
        JSONObject r103 = new JSONObject();
        r103.put("type", "instant_kill");
        r103.put("data", r102);
        this.f96837a.f(r103);
        return;
    }
}
