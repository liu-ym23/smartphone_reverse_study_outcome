package org.apache.commons.compress.archivers.sevenz;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final enum SevenZMethod extends Enum<SevenZMethod> {
    private static final /* synthetic */ SevenZMethod[] $VALUES = null;
    public static final SevenZMethod AES256SHA256 = null;
    public static final SevenZMethod BCJ_ARM_FILTER = null;
    public static final SevenZMethod BCJ_ARM_THUMB_FILTER = null;
    public static final SevenZMethod BCJ_IA64_FILTER = null;
    public static final SevenZMethod BCJ_PPC_FILTER = null;
    public static final SevenZMethod BCJ_SPARC_FILTER = null;
    public static final SevenZMethod BCJ_X86_FILTER = null;
    public static final SevenZMethod BZIP2 = null;
    public static final SevenZMethod COPY = null;
    public static final SevenZMethod DEFLATE = null;
    public static final SevenZMethod DEFLATE64 = null;
    public static final SevenZMethod DELTA_FILTER = null;
    public static final SevenZMethod LZMA = null;
    public static final SevenZMethod LZMA2 = null;
    private final byte[] id;

    private static /* synthetic */ SevenZMethod[] $values() {
        return new SevenZMethod[]{COPY, LZMA, LZMA2, DEFLATE, DEFLATE64, BZIP2, AES256SHA256, BCJ_X86_FILTER, BCJ_PPC_FILTER, BCJ_IA64_FILTER, BCJ_ARM_FILTER, BCJ_ARM_THUMB_FILTER, BCJ_SPARC_FILTER, DELTA_FILTER};
    }

    public static SevenZMethod valueOf(String name) {
        return (SevenZMethod) Enum.valueOf(SevenZMethod.class, name);
    }

    public static SevenZMethod[] values() {
        return (SevenZMethod[]) $VALUES.clone();
    }

    static {
        COPY = new SevenZMethod("COPY", 0, new byte[]{0});
        LZMA = new SevenZMethod("LZMA", 1, new byte[]{3, 1, 1});
        LZMA2 = new SevenZMethod("LZMA2", 2, new byte[]{33});
        DEFLATE = new SevenZMethod("DEFLATE", 3, new byte[]{4, 1, 8});
        DEFLATE64 = new SevenZMethod("DEFLATE64", 4, new byte[]{4, 1, 9});
        BZIP2 = new SevenZMethod("BZIP2", 5, new byte[]{4, 2, 2});
        AES256SHA256 = new SevenZMethod("AES256SHA256", 6, new byte[]{6, -15, 7, 1});
        BCJ_X86_FILTER = new SevenZMethod("BCJ_X86_FILTER", 7, new byte[]{3, 3, 1, 3});
        BCJ_PPC_FILTER = new SevenZMethod("BCJ_PPC_FILTER", 8, new byte[]{3, 3, 2, 5});
        BCJ_IA64_FILTER = new SevenZMethod("BCJ_IA64_FILTER", 9, new byte[]{3, 3, 4, 1});
        BCJ_ARM_FILTER = new SevenZMethod("BCJ_ARM_FILTER", 10, new byte[]{3, 3, 5, 1});
        BCJ_ARM_THUMB_FILTER = new SevenZMethod("BCJ_ARM_THUMB_FILTER", 11, new byte[]{3, 3, 7, 1});
        BCJ_SPARC_FILTER = new SevenZMethod("BCJ_SPARC_FILTER", 12, new byte[]{3, 3, 8, 5});
        DELTA_FILTER = new SevenZMethod("DELTA_FILTER", 13, new byte[]{3});
        $VALUES = $values();
    }

    private SevenZMethod(String r1, int r2, byte[] id) {
        super(r1, r2);
        this.id = id;
    }

    byte[] getId() {
        byte[] copy = new byte[this.id.length];
        System.arraycopy(this.id, 0, copy, 0, this.id.length);
        return copy;
    }

    static SevenZMethod byId(byte[] id) {
        SevenZMethod[] r0 = (SevenZMethod[]) SevenZMethod.class.getEnumConstants();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        SevenZMethod m = r0[r2];
        if (Arrays.equals(m.id, id) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return m;
    L8:
        return null;
    }
}
