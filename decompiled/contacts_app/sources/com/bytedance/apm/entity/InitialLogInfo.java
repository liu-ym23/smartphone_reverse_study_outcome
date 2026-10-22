package com.bytedance.apm.entity;

/* JADX INFO: loaded from: classes2.dex */
public class InitialLogInfo {
    public boolean isSampled;
    public String key;
    public String type;
    public String type2;
    public float value;

    public InitialLogInfo(String r1, String r2, String r3, float r4, boolean r5) {
        this.type = r1;
        this.type2 = r2;
        this.key = r3;
        this.value = r4;
        this.isSampled = r5;
    }
}
