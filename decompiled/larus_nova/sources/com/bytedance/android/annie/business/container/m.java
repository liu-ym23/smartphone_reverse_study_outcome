package com.bytedance.android.annie.business.container;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class m implements com.bytedance.ies.bullet.core.kit.bridge.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f38998a;

    @Override // com.bytedance.ies.bullet.core.kit.bridge.h
    public final String getName() {
        return "H5_visibilityChange";
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.h
    public final Object getParams() {
        JSONObject r100 = new JSONObject();
        r100.put("visible", this.f38998a);
        return r100;
    }

    public m(boolean r100) {
        this.f38998a = r100;
    }
}
