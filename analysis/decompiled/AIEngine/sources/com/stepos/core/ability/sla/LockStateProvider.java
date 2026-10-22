package com.stepos.core.ability.sla;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface LockStateProvider {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final LockStateProvider DEFAULT = new KeyguardLockStateProvider();

        private Companion() {
        }

        public final LockStateProvider getDEFAULT() {
            return DEFAULT;
        }
    }

    boolean isKeyguardLocked();
}
