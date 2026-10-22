package com.bytedance.bdinstall.d;

import org.json.JSONObject;

/* JADX INFO: compiled from: BaseLoader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f6209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f6210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f6211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f6212d;

    public abstract boolean a(JSONObject r1);

    public void b(JSONObject r1) {
    }

    d(boolean r1, boolean r2) {
        this.f6210b = r1;
        this.f6211c = r2;
        this.f6212d = false;
    }

    d(boolean r1, boolean r2, boolean r3) {
        this.f6210b = r1;
        this.f6211c = r2;
        this.f6212d = r3;
    }
}
