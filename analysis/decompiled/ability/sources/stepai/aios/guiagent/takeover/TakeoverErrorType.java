package stepai.aios.guiagent.takeover;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lstepai/aios/guiagent/takeover/TakeoverErrorType;", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TakeoverErrorType {

    /* renamed from: a, reason: collision with root package name */
    public static final TakeoverErrorType f6156a;
    public static final TakeoverErrorType b;
    public static final TakeoverErrorType c;
    public static final TakeoverErrorType d;
    public static final TakeoverErrorType e;
    public static final TakeoverErrorType f;
    public static final TakeoverErrorType g;
    public static final TakeoverErrorType h;
    public static final TakeoverErrorType i;

    /* renamed from: j, reason: collision with root package name */
    public static final TakeoverErrorType f6157j;
    public static final /* synthetic */ TakeoverErrorType[] k;

    static {
        TakeoverErrorType takeoverErrorType = new TakeoverErrorType("SESSION_NOT_FOUND", 0);
        f6156a = takeoverErrorType;
        TakeoverErrorType takeoverErrorType2 = new TakeoverErrorType("INVALID_STATE_TRANSITION", 1);
        b = takeoverErrorType2;
        TakeoverErrorType takeoverErrorType3 = new TakeoverErrorType("INTERRUPTION_FAILED", 2);
        c = takeoverErrorType3;
        TakeoverErrorType takeoverErrorType4 = new TakeoverErrorType("CONTEXT_SAVE_FAILED", 3);
        d = takeoverErrorType4;
        TakeoverErrorType takeoverErrorType5 = new TakeoverErrorType("CONTEXT_RESTORE_FAILED", 4);
        e = takeoverErrorType5;
        TakeoverErrorType takeoverErrorType6 = new TakeoverErrorType("TIMEOUT", 5);
        f = takeoverErrorType6;
        TakeoverErrorType takeoverErrorType7 = new TakeoverErrorType("CONCURRENT_OPERATION", 6);
        g = takeoverErrorType7;
        TakeoverErrorType takeoverErrorType8 = new TakeoverErrorType("SERVICE_UNAVAILABLE", 7);
        h = takeoverErrorType8;
        TakeoverErrorType takeoverErrorType9 = new TakeoverErrorType("PERMISSION_DENIED", 8);
        i = takeoverErrorType9;
        TakeoverErrorType takeoverErrorType10 = new TakeoverErrorType("UNKNOWN_ERROR", 9);
        f6157j = takeoverErrorType10;
        TakeoverErrorType[] takeoverErrorTypeArr = {takeoverErrorType, takeoverErrorType2, takeoverErrorType3, takeoverErrorType4, takeoverErrorType5, takeoverErrorType6, takeoverErrorType7, takeoverErrorType8, takeoverErrorType9, takeoverErrorType10};
        k = takeoverErrorTypeArr;
        kotlin.enums.a.a(takeoverErrorTypeArr);
    }

    public static TakeoverErrorType valueOf(String str) {
        return (TakeoverErrorType) Enum.valueOf(TakeoverErrorType.class, str);
    }

    public static TakeoverErrorType[] values() {
        return (TakeoverErrorType[]) k.clone();
    }
}
