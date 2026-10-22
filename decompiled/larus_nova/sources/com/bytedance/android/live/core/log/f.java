package com.bytedance.android.live.core.log;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f64889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f64890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f64891c;

    public /* synthetic */ f(g r100, String r101, JSONObject r102) {
        this.f64889a = r100;
        this.f64890b = r101;
        this.f64891c = r102;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return this.f64889a.g(this.f64890b, this.f64891c);
    }
}
