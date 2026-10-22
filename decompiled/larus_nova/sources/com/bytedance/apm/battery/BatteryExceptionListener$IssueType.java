package com.bytedance.apm.battery;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final enum BatteryExceptionListener$IssueType extends Enum<BatteryExceptionListener$IssueType> {
    public static final BatteryExceptionListener$IssueType ALARM = null;
    public static final BatteryExceptionListener$IssueType LOCATION = null;
    public static final BatteryExceptionListener$IssueType WAKELOCK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BatteryExceptionListener$IssueType[] f190314a = null;

    static {
        BatteryExceptionListener$IssueType r100 = new BatteryExceptionListener$IssueType("ALARM", 0);
        ALARM = r100;
        BatteryExceptionListener$IssueType r101 = new BatteryExceptionListener$IssueType("WAKELOCK", 1);
        WAKELOCK = r101;
        BatteryExceptionListener$IssueType r102 = new BatteryExceptionListener$IssueType(HTTP.LOCATION, 2);
        LOCATION = r102;
        f190314a = new BatteryExceptionListener$IssueType[]{r100, r101, r102};
    }

    public static BatteryExceptionListener$IssueType[] values() {
        return (BatteryExceptionListener$IssueType[]) f190314a.clone();
    }

    public static BatteryExceptionListener$IssueType valueOf(String r100) {
        return (BatteryExceptionListener$IssueType) a.a(BatteryExceptionListener$IssueType.class, r100);
    }

    public BatteryExceptionListener$IssueType(String r100, int r101) {
        super(r100, r101);
    }
}
