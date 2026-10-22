package com.bytedance.android.bcm.impl2;

import com.bytedance.crash.dumper.Scraps;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends kc.a.C6534a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f41892j = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f41893h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f41894i;

    public static final class a {
    }

    static {
    }

    @Override // kc.a.C6534a
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("btm", this.f502356c);     // Catch: Throwable -> L13
        r100.put("btm_show_id", this.f502358e);     // Catch: Throwable -> L13
        if (this.f41893h == null) goto L6;
    L7:
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L13
        r101.put("page", this.f41893h);     // Catch: Throwable -> L12
        r101.put(Scraps.INNER_UNIT, this.f41894i);     // Catch: Throwable -> L12
    L9:
        r100.put("content", r101);     // Catch: Throwable -> L13
    L10:
        r100.put("jump_with_token", this.f502359f);     // Catch: Throwable -> L13
        goto L11
    L6:
        if (this.f41894i == null) goto L10;
    L11:
        return r100;
    }

    public d() {
    }
}
