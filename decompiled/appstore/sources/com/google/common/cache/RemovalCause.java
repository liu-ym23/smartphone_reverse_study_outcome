package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract enum RemovalCause extends Enum<RemovalCause> {
    private static final /* synthetic */ RemovalCause[] $VALUES = null;
    public static final RemovalCause COLLECTED = null;
    public static final RemovalCause EXPIRED = null;
    public static final RemovalCause EXPLICIT = null;
    public static final RemovalCause REPLACED = null;
    public static final RemovalCause SIZE = null;

    static {
        final String r10 = "EXPLICIT";
        final int r11 = 0;
        RemovalCause r12 = new AnonymousClass1(r10, r11);
        EXPLICIT = r12;
        final String r13 = "REPLACED";
        final int r14 = 1;
        RemovalCause r15 = new AnonymousClass2(r13, r14);
        REPLACED = r15;
        final String r16 = "COLLECTED";
        final int r17 = 2;
        RemovalCause r18 = new AnonymousClass3(r16, r17);
        COLLECTED = r18;
        final String r19 = "EXPIRED";
        final int r20 = 3;
        RemovalCause r21 = new AnonymousClass4(r19, r20);
        EXPIRED = r21;
        final String r22 = "SIZE";
        final int r110 = 4;
        RemovalCause r23 = new AnonymousClass5(r22, r110);
        SIZE = r23;
        $VALUES = new RemovalCause[]{r12, r15, r18, r21, r23};
    }

    private RemovalCause(String r10, int r11) {
        super(r10, r11);
    }

    public static RemovalCause valueOf(String r10) {
        return (RemovalCause) Enum.valueOf(RemovalCause.class, r10);
    }

    public static RemovalCause[] values() {
        return (RemovalCause[]) $VALUES.clone();
    }

    public abstract boolean wasEvicted();

    public /* synthetic */ RemovalCause(String r10, int r11, AnonymousClass1 r12) {
        this(r10, r11);
    }
}
