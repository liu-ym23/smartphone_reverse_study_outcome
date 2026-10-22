package com.stepos.common.alphame;

/* loaded from: classes.dex */
public abstract class g {
    private static int sNextId;
    private int mId;

    public g() {
        int i4;
        synchronized (g.class) {
            i4 = sNextId + 1;
            sNextId = i4;
        }
        this.mId = i4;
    }

    public int getId() {
        return this.mId;
    }
}
