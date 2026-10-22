package com.android.contacts.commonbind.experiments;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static Flags sInstance;

    public boolean getBoolean(String r1, boolean r2) {
        return r2;
    }

    public byte[] getBytes(String r1, byte[] r2) {
        return r2;
    }

    public double getDouble(String r1, double r2) {
        return r2;
    }

    public int getInt(String r1, int r2) {
        return r2;
    }

    public long getLong(String r1, long r2) {
        return r2;
    }

    public String getString(String r1, String r2) {
        return r2;
    }

    public static Flags getInstance(Context r0) {
        if (sInstance != null) goto L6;
        sInstance = new Flags();
    L6:
        return sInstance;
    }

    private Flags() {
    }
}
