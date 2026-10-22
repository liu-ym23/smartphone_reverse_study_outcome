package com.bytedance.android.live.browser.schema.core.strategy;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64220a;

    public static final class a {
    }

    public interface b {
        c a(JSONObject r100);
    }

    static {
    }

    public abstract boolean a(JSONObject r100);

    public final int getType() {
        return this.f64220a;
    }

    public c(int r100) {
        this.f64220a = r100;
    }
}
