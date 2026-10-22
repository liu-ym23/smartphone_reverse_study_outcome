package com.android.server.locksettings;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes2.dex */
public class SecureRandomUtils {
    private static final SecureRandom RNG = null;

    public SecureRandomUtils() {
    }

    static {
        RNG = new SecureRandom();
    }

    public static byte[] randomBytes(int length) {
        byte[] res = new byte[length];
        RNG.nextBytes(res);
        return res;
    }

    public static long randomLong() {
        return RNG.nextLong();
    }
}
