package com.android.server.notification;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class SmallHash {
    public static final int MAX_HASH = 8192;

    public SmallHash() {
    }

    public static int hash(String in) {
        return hash(Objects.hashCode(in));
    }

    public static int hash(int in) {
        return Math.floorMod(in, 8192);
    }
}
