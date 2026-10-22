package com.bytedance.applog;

/* loaded from: classes.dex */
public enum Level {
    L0(0),
    L1(1);

    public final int a;

    Level(int i) {
        this.a = i;
    }

    public int value() {
        return this.a;
    }
}
