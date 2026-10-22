package com.bytedance.compression.zstd;

import com.android.vcard.VCardConstants;

/* JADX INFO: loaded from: classes2.dex */
public final enum EndDirective extends Enum<EndDirective> {
    private static final /* synthetic */ EndDirective[] $VALUES = null;
    public static final EndDirective CONTINUE = null;
    public static final EndDirective END = null;
    public static final EndDirective FLUSH = null;
    private final int value;

    public static EndDirective valueOf(String r1) {
        return (EndDirective) Enum.valueOf(EndDirective.class, r1);
    }

    public static EndDirective[] values() {
        return (EndDirective[]) $VALUES.clone();
    }

    static {
        EndDirective r0 = new EndDirective("CONTINUE", 0, 0);
        CONTINUE = r0;
        EndDirective r1 = new EndDirective("FLUSH", 1, 1);
        FLUSH = r1;
        EndDirective r3 = new EndDirective(VCardConstants.PROPERTY_END, 2, 2);
        END = r3;
        $VALUES = new EndDirective[]{r0, r1, r3};
    }

    private EndDirective(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    int value() {
        return this.value;
    }
}
