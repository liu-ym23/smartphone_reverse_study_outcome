package stepai.aios.guiagent.takeover;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lstepai/aios/guiagent/takeover/TakeoverOperationType;", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TakeoverOperationType {

    /* renamed from: a, reason: collision with root package name */
    public static final TakeoverOperationType f6159a;
    public static final TakeoverOperationType b;
    public static final /* synthetic */ TakeoverOperationType[] c;

    static {
        TakeoverOperationType takeoverOperationType = new TakeoverOperationType("TAKEOVER", 0);
        f6159a = takeoverOperationType;
        TakeoverOperationType takeoverOperationType2 = new TakeoverOperationType("RECOVERY", 1);
        b = takeoverOperationType2;
        TakeoverOperationType[] takeoverOperationTypeArr = {takeoverOperationType, takeoverOperationType2};
        c = takeoverOperationTypeArr;
        kotlin.enums.a.a(takeoverOperationTypeArr);
    }

    public static TakeoverOperationType valueOf(String str) {
        return (TakeoverOperationType) Enum.valueOf(TakeoverOperationType.class, str);
    }

    public static TakeoverOperationType[] values() {
        return (TakeoverOperationType[]) c.clone();
    }
}
