package org.apache.commons.compress.archivers.zip;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final enum ZipMethod extends Enum<ZipMethod> {
    private static final /* synthetic */ ZipMethod[] $VALUES = null;
    public static final ZipMethod AES_ENCRYPTED = null;
    public static final ZipMethod BZIP2 = null;
    public static final ZipMethod DEFLATED = null;
    public static final ZipMethod ENHANCED_DEFLATED = null;
    public static final ZipMethod EXPANDING_LEVEL_1 = null;
    public static final ZipMethod EXPANDING_LEVEL_2 = null;
    public static final ZipMethod EXPANDING_LEVEL_3 = null;
    public static final ZipMethod EXPANDING_LEVEL_4 = null;
    public static final ZipMethod IMPLODING = null;
    public static final ZipMethod JPEG = null;
    public static final ZipMethod LZMA = null;
    public static final ZipMethod PKWARE_IMPLODING = null;
    public static final ZipMethod PPMD = null;
    public static final ZipMethod STORED = null;
    public static final ZipMethod TOKENIZATION = null;
    public static final ZipMethod UNKNOWN = null;
    static final int UNKNOWN_CODE = -1;
    public static final ZipMethod UNSHRINKING = null;
    public static final ZipMethod WAVPACK = null;
    public static final ZipMethod XZ = null;
    private static final Map<Integer, ZipMethod> codeToEnum = null;
    private final int code;

    private static /* synthetic */ ZipMethod[] $values() {
        return new ZipMethod[]{STORED, UNSHRINKING, EXPANDING_LEVEL_1, EXPANDING_LEVEL_2, EXPANDING_LEVEL_3, EXPANDING_LEVEL_4, IMPLODING, TOKENIZATION, DEFLATED, ENHANCED_DEFLATED, PKWARE_IMPLODING, BZIP2, LZMA, XZ, JPEG, WAVPACK, PPMD, AES_ENCRYPTED, UNKNOWN};
    }

    public static ZipMethod valueOf(String name) {
        return (ZipMethod) Enum.valueOf(ZipMethod.class, name);
    }

    public static ZipMethod[] values() {
        return (ZipMethod[]) $VALUES.clone();
    }

    static {
        int r2 = 0;
        STORED = new ZipMethod("STORED", 0, 0);
        UNSHRINKING = new ZipMethod("UNSHRINKING", 1, 1);
        EXPANDING_LEVEL_1 = new ZipMethod("EXPANDING_LEVEL_1", 2, 2);
        EXPANDING_LEVEL_2 = new ZipMethod("EXPANDING_LEVEL_2", 3, 3);
        EXPANDING_LEVEL_3 = new ZipMethod("EXPANDING_LEVEL_3", 4, 4);
        EXPANDING_LEVEL_4 = new ZipMethod("EXPANDING_LEVEL_4", 5, 5);
        IMPLODING = new ZipMethod("IMPLODING", 6, 6);
        TOKENIZATION = new ZipMethod("TOKENIZATION", 7, 7);
        DEFLATED = new ZipMethod("DEFLATED", 8, 8);
        ENHANCED_DEFLATED = new ZipMethod("ENHANCED_DEFLATED", 9, 9);
        PKWARE_IMPLODING = new ZipMethod("PKWARE_IMPLODING", 10, 10);
        BZIP2 = new ZipMethod("BZIP2", 11, 12);
        LZMA = new ZipMethod("LZMA", 12, 14);
        XZ = new ZipMethod("XZ", 13, 95);
        JPEG = new ZipMethod("JPEG", 14, 96);
        WAVPACK = new ZipMethod("WAVPACK", 15, 97);
        PPMD = new ZipMethod("PPMD", 16, 98);
        AES_ENCRYPTED = new ZipMethod("AES_ENCRYPTED", 17, 99);
        UNKNOWN = new ZipMethod("UNKNOWN", 18);
        $VALUES = $values();
        Map<Integer, ZipMethod> cte = new HashMap();
        ZipMethod[] r1 = values();
        int r3 = r1.length;
    L3:
        if (r2 >= r3) goto L5;
        ZipMethod method = r1[r2];
        cte.put(Integer.valueOf(method.getCode()), method);
        r2 = r2 + 1;
        goto L3
    L5:
        codeToEnum = Collections.unmodifiableMap(cte);
    }

    private ZipMethod(String r2, int r3) {
        this(r2, r3, -1);
    }

    private ZipMethod(String r1, int r2, int code) {
        super(r1, r2);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static ZipMethod getMethodByCode(int code) {
        return codeToEnum.get(Integer.valueOf(code));
    }
}
