package stepai.aios.guiagent.util;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lstepai/aios/guiagent/util/AppErrorType;", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AppErrorType {

    /* renamed from: a, reason: collision with root package name */
    public static final AppErrorType f6173a;
    public static final AppErrorType b;
    public static final AppErrorType c;
    public static final AppErrorType d;
    public static final /* synthetic */ AppErrorType[] e;

    static {
        AppErrorType appErrorType = new AppErrorType("APP_NOT_INSTALLED", 0);
        f6173a = appErrorType;
        AppErrorType appErrorType2 = new AppErrorType("PACKAGE_NOT_FOUND", 1);
        b = appErrorType2;
        AppErrorType appErrorType3 = new AppErrorType("LAUNCH_FAILED", 2);
        c = appErrorType3;
        AppErrorType appErrorType4 = new AppErrorType("INTENT_NOT_AVAILABLE", 3);
        AppErrorType appErrorType5 = new AppErrorType("UNKNOWN_ERROR", 4);
        d = appErrorType5;
        AppErrorType[] appErrorTypeArr = {appErrorType, appErrorType2, appErrorType3, appErrorType4, appErrorType5};
        e = appErrorTypeArr;
        kotlin.enums.a.a(appErrorTypeArr);
    }

    public static AppErrorType valueOf(String str) {
        return (AppErrorType) Enum.valueOf(AppErrorType.class, str);
    }

    public static AppErrorType[] values() {
        return (AppErrorType[]) e.clone();
    }
}
