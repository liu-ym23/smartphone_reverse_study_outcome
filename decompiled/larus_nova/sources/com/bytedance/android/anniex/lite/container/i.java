package com.bytedance.android.anniex.lite.container;

import com.bytedance.android.anniex.container.popup.PopupCloseType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class i implements com.bytedance.ies.bullet.core.kit.bridge.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f40873a;

    @Override // com.bytedance.ies.bullet.core.kit.bridge.h
    public final String getName() {
        return "containerShouldClose";
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.h
    public final Object getParams() {
        return this.f40873a;
    }

    public i(PopupCloseType r100) {
        JSONObject r101 = new JSONObject();
        r101.put("type", PopupCloseType.getTag$default(r100, false, 1, null));
        this.f40873a = r101;
    }
}
