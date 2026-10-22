package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract enum Pack200Strategy extends Enum<Pack200Strategy> {
    private static final /* synthetic */ Pack200Strategy[] $VALUES = null;
    public static final Pack200Strategy IN_MEMORY = null;
    public static final Pack200Strategy TEMP_FILE = null;

    abstract StreamBridge newStreamBridge() throws IOException;

    private static /* synthetic */ Pack200Strategy[] $values() {
        return new Pack200Strategy[]{IN_MEMORY, TEMP_FILE};
    }

    private Pack200Strategy(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ Pack200Strategy(String x0, int x1, AnonymousClass1 x2) {
        this(x0, x1);
    }

    public static Pack200Strategy valueOf(String name) {
        return (Pack200Strategy) Enum.valueOf(Pack200Strategy.class, name);
    }

    public static Pack200Strategy[] values() {
        return (Pack200Strategy[]) $VALUES.clone();
    }

    static {
        final String r1 = "IN_MEMORY";
        final int r2 = 0;
        IN_MEMORY = new AnonymousClass1(r1, r2);
        final String r3 = "TEMP_FILE";
        final int r4 = 1;
        TEMP_FILE = new AnonymousClass2(r3, r4);
        $VALUES = $values();
    }
}
