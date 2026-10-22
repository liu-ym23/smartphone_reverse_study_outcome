package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum RemovalCause extends Enum<RemovalCause> {
    private static final /* synthetic */ RemovalCause[] $VALUES = null;
    public static final RemovalCause COLLECTED = null;
    public static final RemovalCause EXPIRED = null;
    public static final RemovalCause EXPLICIT = null;
    public static final RemovalCause REPLACED = null;
    public static final RemovalCause SIZE = null;

    abstract boolean wasEvicted();

    public static RemovalCause valueOf(String r1) {
        return (RemovalCause) Enum.valueOf(RemovalCause.class, r1);
    }

    public static RemovalCause[] values() {
        return (RemovalCause[]) $VALUES.clone();
    }

    private RemovalCause(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ RemovalCause(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static {
        final String r1 = "EXPLICIT";
        final int r2 = 0;
        RemovalCause r0 = new AnonymousClass1(r1, r2);
        EXPLICIT = r0;
        final String r3 = "REPLACED";
        final int r4 = 1;
        RemovalCause r5 = new AnonymousClass2(r3, r4);
        REPLACED = r5;
        final String r6 = "COLLECTED";
        final int r7 = 2;
        RemovalCause r8 = new AnonymousClass3(r6, r7);
        COLLECTED = r8;
        final String r9 = "EXPIRED";
        final int r10 = 3;
        RemovalCause r11 = new AnonymousClass4(r9, r10);
        EXPIRED = r11;
        final String r12 = "SIZE";
        final int r13 = 4;
        RemovalCause r14 = new AnonymousClass5(r12, r13);
        SIZE = r14;
        $VALUES = new RemovalCause[]{r0, r5, r8, r11, r14};
    }
}
