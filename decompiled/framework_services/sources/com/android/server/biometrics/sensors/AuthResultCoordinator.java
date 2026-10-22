package com.android.server.biometrics.sensors;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Map;
import java.util.function.IntFunction;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: loaded from: classes.dex */
class AuthResultCoordinator {
    static final int AUTHENTICATOR_DEFAULT = 0;
    static final int AUTHENTICATOR_PERMANENT_LOCKED = 1;
    static final int AUTHENTICATOR_TIMED_LOCKED = 2;
    static final int AUTHENTICATOR_UNLOCKED = 4;
    private static final String TAG = "AuthResultCoordinator";
    private final Map<Integer, Integer> mAuthenticatorState;

    public static /* synthetic */ Integer $r8$lambda$F4O_7Sg0xc2d3wWJcis0olsGlTg(int r0) {
        return lambda$authenticatedFor$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$hhYhR-XEk11dcd5V2TvKvgQkU1E, reason: not valid java name */
    public static /* synthetic */ Integer m2609$r8$lambda$hhYhRXEk11dcd5V2TvKvgQkU1E(int r0) {
        return lambda$lockedOutFor$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$l-YKceN9ZZ9AYmtDelUOK9ELgro, reason: not valid java name */
    public static /* synthetic */ Integer m2610$r8$lambda$lYKceN9ZZ9AYmtDelUOK9ELgro(int r0) {
        return lambda$lockOutTimed$2(r0);
    }

    AuthResultCoordinator() {
        this.mAuthenticatorState = new ArrayMap();
        this.mAuthenticatorState.put(15, 0);
        this.mAuthenticatorState.put(255, 0);
        this.mAuthenticatorState.put(Integer.valueOf(UnixStat.PERM_MASK), 0);
    }

    private void updateState(int strength, IntFunction<Integer> mapper) {
        switch(strength) {
            case 15: goto L4;
            case 255: goto L5;
            case 4095: goto L6;
            default: goto L8;
        };
    L4:
        this.mAuthenticatorState.put(15, mapper.apply(this.mAuthenticatorState.get(15).intValue()));
    L5:
        this.mAuthenticatorState.put(255, mapper.apply(this.mAuthenticatorState.get(255).intValue()));
    L6:
        this.mAuthenticatorState.put(Integer.valueOf(UnixStat.PERM_MASK), mapper.apply(this.mAuthenticatorState.get(Integer.valueOf(UnixStat.PERM_MASK)).intValue()));
        return;
    }

    void authenticatedFor(int strength) {
        if (strength != 15) goto L6;
        updateState(strength, new AuthResultCoordinator$$ExternalSyntheticLambda2());
        return;
    }

    private static /* synthetic */ Integer lambda$authenticatedFor$0(int old) {
        return Integer.valueOf(old | 4);
    }

    private static /* synthetic */ Integer lambda$lockedOutFor$1(int old) {
        return Integer.valueOf(old | 1);
    }

    void lockedOutFor(int strength) {
        updateState(strength, new AuthResultCoordinator$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ Integer lambda$lockOutTimed$2(int old) {
        return Integer.valueOf(old | 2);
    }

    void lockOutTimed(int strength) {
        updateState(strength, new AuthResultCoordinator$$ExternalSyntheticLambda1());
    }

    final Map<Integer, Integer> getResult() {
        return Collections.unmodifiableMap(this.mAuthenticatorState);
    }
}
