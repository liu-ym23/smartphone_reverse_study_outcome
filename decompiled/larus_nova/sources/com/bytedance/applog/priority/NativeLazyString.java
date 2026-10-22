package com.bytedance.applog.priority;

import com.bytedance.applog.priority.original.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class NativeLazyString {
    private final z<JSONObject> loader;

    public String getValue() {
        return this.loader.load().toString();
    }

    public NativeLazyString(z<JSONObject> r100) {
        this.loader = r100;
    }
}
