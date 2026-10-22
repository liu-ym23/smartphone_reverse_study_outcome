package com.bytedance.security.zenmobile.deidentify;

/* JADX INFO: loaded from: classes.dex */
public abstract class Deidentifier {
    public abstract String deidentify(String r1, String r2);

    public abstract void deidentify(byte[] r1, int r2, int r3, String r4);

    public Deidentifier() {
    }
}
