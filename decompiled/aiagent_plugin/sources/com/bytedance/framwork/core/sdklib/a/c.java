package com.bytedance.framwork.core.sdklib.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: LogItem.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f8596c;

    public c(byte[] r1, long r2, long r4) {
        this.f8596c = r1;
        this.f8594a = r4;
        this.f8595b = r2;
    }

    public byte[] a() {
        return this.f8596c;
    }

    public long b() {
        return this.f8594a;
    }

    public long c() {
        return this.f8595b;
    }

    public String toString() {
        return new JSONObject(new String(this.f8596c)).toString();
    L4:
        return "";
    }
}
