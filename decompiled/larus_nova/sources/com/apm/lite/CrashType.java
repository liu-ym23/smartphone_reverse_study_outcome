package com.apm.lite;

import com.obric.miniapp.alarm.AccountType;
import com.ss.android.common.applog.EventVerify;

/* JADX INFO: loaded from: classes39.dex */
public final enum CrashType extends Enum<CrashType> {
    private static final /* synthetic */ CrashType[] $VALUES = null;
    public static final CrashType ALL = null;
    public static final CrashType ANR = null;
    public static final CrashType DART = null;
    public static final CrashType ENSURE = null;
    public static final CrashType JAVA = null;
    public static final CrashType LAUNCH = null;
    public static final CrashType NATIVE = null;
    public static final CrashType OOM = null;
    private String mName;

    static {
        CrashType r100 = new CrashType("LAUNCH", 0, EventVerify.TYPE_LAUNCH);
        LAUNCH = r100;
        CrashType r101 = new CrashType("JAVA", 1, "java");
        JAVA = r101;
        CrashType r102 = new CrashType("NATIVE", 2, "native");
        NATIVE = r102;
        CrashType r103 = new CrashType("ANR", 3, "anr");
        ANR = r103;
        CrashType r104 = new CrashType("ENSURE", 4, "ensure");
        ENSURE = r104;
        CrashType r105 = new CrashType("DART", 5, "dart");
        DART = r105;
        CrashType r110 = new CrashType("OOM", 6, "oom");
        OOM = r110;
        CrashType r111 = new CrashType(AccountType.ALL, 7, "all");
        ALL = r111;
        $VALUES = new CrashType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    private CrashType(String r100, int r101, String r102) {
        super(r100, r101);
        this.mName = r102;
    }

    public static CrashType valueOf(String r100) {
        return (CrashType) r27.a.a(CrashType.class, r100);
    }

    public static CrashType[] values() {
        return (CrashType[]) $VALUES.clone();
    }

    public String getName() {
        return this.mName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }
}
