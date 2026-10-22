package com.bytedance.android.livesdk.player;

import javax.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f155370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f155371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final JSONObject f155372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f155373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ls2.e f155374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public hl0.a f155375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f155376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f155377h;

    public final boolean a() {
        int r100 = this.f155370a;
        if (r100 != 102) goto L5;
        return true;
    L5:
        if (r100 != 122) goto L7;
        return true;
    L7:
        if (r100 != 124) goto L9;
        return true;
    L9:
        if (r100 != 105) goto L11;
        return true;
    L11:
        if (r100 != 106) goto L13;
        return true;
    L13:
        if (r100 != 108) goto L15;
        return true;
    L15:
        if (r100 == 109) goto L25;
        return false;
    L25:
        return true;
    }

    public g0(int r100, @Nullable JSONObject r101, long r102) {
        this.f155370a = r100;
        this.f155371b = "fetch failed because the pull_url isn't valid";
        this.f155372c = r101;
        this.f155373d = r102;
    }

    public g0(int r100, @Nullable String r101, long r102) {
        this.f155370a = r100;
        this.f155371b = r101;
        this.f155373d = r102;
    }
}
