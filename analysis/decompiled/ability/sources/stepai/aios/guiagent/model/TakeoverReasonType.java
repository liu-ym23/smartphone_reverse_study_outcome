package stepai.aios.guiagent.model;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lstepai/aios/guiagent/model/TakeoverReasonType;", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TakeoverReasonType {

    /* renamed from: a, reason: collision with root package name */
    public static final TakeoverReasonType f6034a;
    public static final TakeoverReasonType b;
    public static final /* synthetic */ TakeoverReasonType[] c;

    static {
        TakeoverReasonType takeoverReasonType = new TakeoverReasonType("USER_REQUEST", 0);
        f6034a = takeoverReasonType;
        TakeoverReasonType takeoverReasonType2 = new TakeoverReasonType("LLM_REQUEST", 1);
        b = takeoverReasonType2;
        TakeoverReasonType[] takeoverReasonTypeArr = {takeoverReasonType, takeoverReasonType2};
        c = takeoverReasonTypeArr;
        a.a(takeoverReasonTypeArr);
    }

    public static TakeoverReasonType valueOf(String str) {
        return (TakeoverReasonType) Enum.valueOf(TakeoverReasonType.class, str);
    }

    public static TakeoverReasonType[] values() {
        return (TakeoverReasonType[]) c.clone();
    }
}
