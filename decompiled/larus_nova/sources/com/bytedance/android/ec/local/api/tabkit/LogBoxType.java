package com.bytedance.android.ec.local.api.tabkit;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/local/api/tabkit/LogBoxType;", "", "POPUP_TYPE_ERROR", "POPUP_TYPE_WARNNING", "POPUP_TYPE_NOTICE", "ec-local-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LogBoxType extends Enum<LogBoxType> {
    public static final LogBoxType POPUP_TYPE_ERROR = null;
    public static final LogBoxType POPUP_TYPE_NOTICE = null;
    public static final LogBoxType POPUP_TYPE_WARNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogBoxType[] f47846a = null;

    static {
        LogBoxType r100 = new LogBoxType("POPUP_TYPE_ERROR", 0);
        POPUP_TYPE_ERROR = r100;
        LogBoxType r101 = new LogBoxType("POPUP_TYPE_WARNNING", 1);
        POPUP_TYPE_WARNNING = r101;
        LogBoxType r102 = new LogBoxType("POPUP_TYPE_NOTICE", 2);
        POPUP_TYPE_NOTICE = r102;
        f47846a = new LogBoxType[]{r100, r101, r102};
    }

    public static LogBoxType valueOf(String r100) {
        return (LogBoxType) a.a(LogBoxType.class, r100);
    }

    public static LogBoxType[] values() {
        return (LogBoxType[]) f47846a.clone();
    }

    public LogBoxType(String r100, int r101) {
        super(r100, r101);
    }
}
