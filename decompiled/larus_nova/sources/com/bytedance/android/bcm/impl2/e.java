package com.bytedance.android.bcm.impl2;

import com.bytedance.crash.dumper.Scraps;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class e extends kc.a.C6534a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f41895j = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f41896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f41897i;

    public static final class a {
    }

    static {
    }

    @Override // kc.a.C6534a
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("btm", this.f502356c);     // Catch: Throwable -> L15
        r100.put("btm_show_id", this.f502358e);     // Catch: Throwable -> L15
        if (this.f41896h == null) goto L6;
    L7:
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L15
        r101.put("page", this.f41896h);     // Catch: Throwable -> L14
        r101.put(Scraps.INNER_UNIT, this.f41897i);     // Catch: Throwable -> L14
    L9:
        r100.put("content", r101);     // Catch: Throwable -> L15
    L10:
        String r102 = this.f502359f;     // Catch: Throwable -> L15
        if (r102 == null) goto L13;
        r100.put("jump_with_token", r102);     // Catch: Throwable -> L15
        goto L13
    L6:
        if (this.f41897i == null) goto L10;
    L13:
        return r100;
    }

    public e() {
    }
}
