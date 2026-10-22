package com.bytedance.android.anniex.utils;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/utils/AnnieXDDPFSignalScopeEnum;", "", "", "signalScope", "Ljava/lang/String;", "getSignalScope", "()Ljava/lang/String;", "CPU", "MEMORY", "ANR", "JIT", "GC", "STORAGE", "POWER", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXDDPFSignalScopeEnum extends Enum<AnnieXDDPFSignalScopeEnum> {
    public static final AnnieXDDPFSignalScopeEnum ANR = null;
    public static final AnnieXDDPFSignalScopeEnum CPU = null;
    public static final AnnieXDDPFSignalScopeEnum GC = null;
    public static final AnnieXDDPFSignalScopeEnum JIT = null;
    public static final AnnieXDDPFSignalScopeEnum MEMORY = null;
    public static final AnnieXDDPFSignalScopeEnum POWER = null;
    public static final AnnieXDDPFSignalScopeEnum STORAGE = null;
    public static final AnnieXDDPFSignalScopeEnum UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXDDPFSignalScopeEnum[] f41396a = null;
    private final String signalScope;

    public static AnnieXDDPFSignalScopeEnum valueOf(String r100) {
        return (AnnieXDDPFSignalScopeEnum) r27.a.a(AnnieXDDPFSignalScopeEnum.class, r100);
    }

    public static AnnieXDDPFSignalScopeEnum[] values() {
        return (AnnieXDDPFSignalScopeEnum[]) f41396a.clone();
    }

    static {
        AnnieXDDPFSignalScopeEnum r100 = new AnnieXDDPFSignalScopeEnum("CPU", 0, "cpu");
        CPU = r100;
        AnnieXDDPFSignalScopeEnum r101 = new AnnieXDDPFSignalScopeEnum("MEMORY", 1, "memory");
        MEMORY = r101;
        AnnieXDDPFSignalScopeEnum r102 = new AnnieXDDPFSignalScopeEnum("ANR", 2, "anr");
        ANR = r102;
        AnnieXDDPFSignalScopeEnum r103 = new AnnieXDDPFSignalScopeEnum("JIT", 3, "jit");
        JIT = r103;
        AnnieXDDPFSignalScopeEnum r104 = new AnnieXDDPFSignalScopeEnum("GC", 4, "gc");
        GC = r104;
        AnnieXDDPFSignalScopeEnum r105 = new AnnieXDDPFSignalScopeEnum("STORAGE", 5, "storage");
        STORAGE = r105;
        AnnieXDDPFSignalScopeEnum r110 = new AnnieXDDPFSignalScopeEnum("POWER", 6, BatteryTypeInf.BATTERY_POWER_LOCK);
        POWER = r110;
        AnnieXDDPFSignalScopeEnum r111 = new AnnieXDDPFSignalScopeEnum("UNKNOWN", 7, "unknown");
        UNKNOWN = r111;
        f41396a = new AnnieXDDPFSignalScopeEnum[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public final String getSignalScope() {
        return this.signalScope;
    }

    public AnnieXDDPFSignalScopeEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.signalScope = r102;
    }
}
