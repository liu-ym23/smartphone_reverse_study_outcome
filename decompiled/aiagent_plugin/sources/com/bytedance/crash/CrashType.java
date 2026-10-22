package com.bytedance.crash;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum CrashType extends Enum<CrashType> {
    private static final /* synthetic */ CrashType[] $VALUES = null;
    public static final CrashType ALL = null;
    public static final CrashType ANR = null;
    public static final CrashType ASAN = null;
    public static final CrashType BLOCK = null;
    public static final CrashType CJAVA = null;
    public static final CrashType COREDUMP = null;
    public static final CrashType CUSTOM_JAVA = null;
    public static final CrashType DART = null;
    public static final CrashType ENSURE = null;
    public static final CrashType EVENT = null;
    public static final CrashType GAME = null;
    public static final CrashType JAVA = null;
    public static final CrashType LAUNCH = null;
    public static final CrashType NATIVE = null;
    public static final CrashType NATIVE_CUSTOMIZE = null;
    public static final CrashType OOM = null;
    public static final CrashType TSAN = null;
    public static final CrashType UNKNOWN = null;
    private final String mName;

    public static CrashType valueOf(String r2) {
        return (CrashType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CrashType.class, r2), CrashType.class, "com.obric.aiagent.plugin");
    }

    public static CrashType[] values() {
        return (CrashType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CrashType[].class, "com.obric.aiagent.plugin");
    }

    static {
        CrashType r0 = new CrashType("LAUNCH", 0, "launch");
        LAUNCH = r0;
        CrashType r1 = new CrashType("JAVA", 1, "java");
        JAVA = r1;
        CrashType r3 = new CrashType("NATIVE", 2, "native");
        NATIVE = r3;
        CrashType r5 = new CrashType("ASAN", 3, "asan");
        ASAN = r5;
        CrashType r7 = new CrashType("TSAN", 4, "tsan");
        TSAN = r7;
        CrashType r9 = new CrashType("ANR", 5, "anr");
        ANR = r9;
        CrashType r11 = new CrashType("NATIVE_CUSTOMIZE", 6, "ensure_zip");
        NATIVE_CUSTOMIZE = r11;
        CrashType r13 = new CrashType("BLOCK", 7, "block");
        BLOCK = r13;
        CrashType r12 = new CrashType("ENSURE", 8, "ensure");
        ENSURE = r12;
        CrashType r10 = new CrashType("DART", 9, "dart");
        DART = r10;
        CrashType r8 = new CrashType("GAME", 10, "game");
        GAME = r8;
        CrashType r6 = new CrashType("CUSTOM_JAVA", 11, "custom_java");
        CUSTOM_JAVA = r6;
        CrashType r4 = new CrashType("OOM", 12, "oom");
        OOM = r4;
        CrashType r2 = new CrashType("CJAVA", 13, "cjava");
        CJAVA = r2;
        CrashType r14 = new CrashType("COREDUMP", 14, "coredump");
        COREDUMP = r14;
        CrashType r15 = new CrashType("EVENT", 15, "event");
        EVENT = r15;
        CrashType r16 = new CrashType("ALL", 16, "all");
        ALL = r16;
        CrashType r17 = new CrashType("UNKNOWN", 17, SensitiveType.UNKNOWN);
        UNKNOWN = r17;
        $VALUES = new CrashType[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14, r15, r16, r17};
    }

    private CrashType(String r1, int r2, String r3) {
        super(r1, r2);
        this.mName = r3;
    }

    public String getName() {
        return this.mName;
    }

    public static CrashType getType(String r0) {
        return valueOf(r0.toUpperCase());
    L5:
        return UNKNOWN;
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }
}
