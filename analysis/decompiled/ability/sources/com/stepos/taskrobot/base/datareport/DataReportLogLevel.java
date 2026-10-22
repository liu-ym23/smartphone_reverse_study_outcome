package com.stepos.taskrobot.base.datareport;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/taskrobot/base/datareport/DataReportLogLevel;", "", "datareport_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataReportLogLevel {

    /* renamed from: a, reason: collision with root package name */
    public static final DataReportLogLevel f4025a;
    public static final DataReportLogLevel b;
    public static final DataReportLogLevel c;
    public static final /* synthetic */ DataReportLogLevel[] d;

    static {
        DataReportLogLevel dataReportLogLevel = new DataReportLogLevel("INFO", 0);
        f4025a = dataReportLogLevel;
        DataReportLogLevel dataReportLogLevel2 = new DataReportLogLevel("WARN", 1);
        b = dataReportLogLevel2;
        DataReportLogLevel dataReportLogLevel3 = new DataReportLogLevel("ERROR", 2);
        c = dataReportLogLevel3;
        DataReportLogLevel[] dataReportLogLevelArr = {dataReportLogLevel, dataReportLogLevel2, dataReportLogLevel3};
        d = dataReportLogLevelArr;
        a.a(dataReportLogLevelArr);
    }

    public static DataReportLogLevel valueOf(String str) {
        return (DataReportLogLevel) Enum.valueOf(DataReportLogLevel.class, str);
    }

    public static DataReportLogLevel[] values() {
        return (DataReportLogLevel[]) d.clone();
    }
}
