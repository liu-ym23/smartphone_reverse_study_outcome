package com.bytedance.android.livesdk.gift.platform.core.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class x {
    public x() {
    }

    public abstract void a(JSONObject r100);

    public final String toString() {
        JSONObject r100 = new JSONObject();
        a(r100);
        return r100.toString();
    }
}
