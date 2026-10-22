package com.bytedance.android.bst.api;

import java.util.HashMap;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a {
    private final String biz;
    private final transient HashMap<String, Object> extraInfo;
    private final String key;

    public abstract boolean checkValid(vc.a r100);

    public abstract a copy();

    public abstract String getTag();

    public final a deepCopy$api_cnRelease() {
        a r100 = copy();
        r100.extraInfo.putAll(this.extraInfo);
        return r100;
    }

    public final String getBiz() {
        return this.biz;
    }

    public final HashMap<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public final String getKey() {
        return this.key;
    }

    public a(String r100, String r101) {
        this.biz = r100;
        this.key = r101;
        this.extraInfo = new HashMap();
    }
}
