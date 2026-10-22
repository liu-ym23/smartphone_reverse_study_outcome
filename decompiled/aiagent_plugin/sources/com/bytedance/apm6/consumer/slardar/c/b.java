package com.bytedance.apm6.consumer.slardar.c;

import org.json.JSONObject;

/* JADX INFO: compiled from: LogItem.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f5096a;

    public b(byte[] r1) {
        this.f5096a = r1;
    }

    public byte[] a() {
        return this.f5096a;
    }

    public String toString() {
        return new JSONObject(new String(this.f5096a)).toString();
    L4:
        return "";
    }
}
