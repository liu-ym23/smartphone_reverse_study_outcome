package org.apache.commons.compress.archivers.dump;

/* JADX INFO: loaded from: classes3.dex */
public final class DumpArchiveConstants {
    public static final int CHECKSUM = 84446;
    public static final int FS_UFS2_MAGIC = 424935705;
    public static final int HIGH_DENSITY_NTREC = 32;
    public static final int LBLSIZE = 16;
    public static final int NAMELEN = 64;
    public static final int NFS_MAGIC = 60012;
    public static final int NTREC = 10;
    public static final int OFS_MAGIC = 60011;
    public static final int TP_SIZE = 1024;

    public static final enum COMPRESSION_TYPE extends Enum<COMPRESSION_TYPE> {
        private static final /* synthetic */ COMPRESSION_TYPE[] $VALUES = null;
        public static final COMPRESSION_TYPE BZLIB = null;
        public static final COMPRESSION_TYPE LZO = null;
        public static final COMPRESSION_TYPE ZLIB = null;
        int code;

        private static /* synthetic */ COMPRESSION_TYPE[] $values() {
            return new COMPRESSION_TYPE[]{ZLIB, BZLIB, LZO};
        }

        public static COMPRESSION_TYPE valueOf(String name) {
            return (COMPRESSION_TYPE) Enum.valueOf(COMPRESSION_TYPE.class, name);
        }

        public static COMPRESSION_TYPE[] values() {
            return (COMPRESSION_TYPE[]) $VALUES.clone();
        }

        static {
            ZLIB = new COMPRESSION_TYPE("ZLIB", 0, 0);
            BZLIB = new COMPRESSION_TYPE("BZLIB", 1, 1);
            LZO = new COMPRESSION_TYPE("LZO", 2, 2);
            $VALUES = $values();
        }

        private COMPRESSION_TYPE(String r1, int r2, int code) {
            super(r1, r2);
            this.code = code;
        }

        public static COMPRESSION_TYPE find(int code) {
            COMPRESSION_TYPE[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            COMPRESSION_TYPE t = r0[r2];
            if (t.code == code) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return t;
        L8:
            return null;
        }
    }

    public static final enum SEGMENT_TYPE extends Enum<SEGMENT_TYPE> {
        private static final /* synthetic */ SEGMENT_TYPE[] $VALUES = null;
        public static final SEGMENT_TYPE ADDR = null;
        public static final SEGMENT_TYPE BITS = null;
        public static final SEGMENT_TYPE CLRI = null;
        public static final SEGMENT_TYPE END = null;
        public static final SEGMENT_TYPE INODE = null;
        public static final SEGMENT_TYPE TAPE = null;
        int code;

        private static /* synthetic */ SEGMENT_TYPE[] $values() {
            return new SEGMENT_TYPE[]{TAPE, INODE, BITS, ADDR, END, CLRI};
        }

        public static SEGMENT_TYPE valueOf(String name) {
            return (SEGMENT_TYPE) Enum.valueOf(SEGMENT_TYPE.class, name);
        }

        public static SEGMENT_TYPE[] values() {
            return (SEGMENT_TYPE[]) $VALUES.clone();
        }

        static {
            TAPE = new SEGMENT_TYPE("TAPE", 0, 1);
            INODE = new SEGMENT_TYPE("INODE", 1, 2);
            BITS = new SEGMENT_TYPE("BITS", 2, 3);
            ADDR = new SEGMENT_TYPE("ADDR", 3, 4);
            END = new SEGMENT_TYPE("END", 4, 5);
            CLRI = new SEGMENT_TYPE("CLRI", 5, 6);
            $VALUES = $values();
        }

        private SEGMENT_TYPE(String r1, int r2, int code) {
            super(r1, r2);
            this.code = code;
        }

        public static SEGMENT_TYPE find(int code) {
            SEGMENT_TYPE[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            SEGMENT_TYPE t = r0[r2];
            if (t.code == code) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return t;
        L8:
            return null;
        }
    }

    private DumpArchiveConstants() {
    }
}
