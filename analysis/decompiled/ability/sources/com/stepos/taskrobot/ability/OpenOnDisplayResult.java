package com.stepos.taskrobot.ability;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0003\u0002¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/ability/OpenOnDisplayResult;", "", "Z5/c", "com/stepos/taskrobot/ability/b", "Reason", "ability_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface OpenOnDisplayResult {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/taskrobot/ability/OpenOnDisplayResult$Reason;", "", "ability_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Reason {

        /* renamed from: a, reason: collision with root package name */
        public static final Reason f3998a;
        public static final Reason b;
        public static final Reason c;
        public static final /* synthetic */ Reason[] d;

        static {
            Reason reason = new Reason("MDI_UNAVAILABLE", 0);
            f3998a = reason;
            Reason reason2 = new Reason("CREATE_TASK_FAILED", 1);
            b = reason2;
            Reason reason3 = new Reason("OPEN_APP_FAILED", 2);
            c = reason3;
            Reason[] reasonArr = {reason, reason2, reason3};
            d = reasonArr;
            kotlin.enums.a.a(reasonArr);
        }

        public static Reason valueOf(String str) {
            return (Reason) Enum.valueOf(Reason.class, str);
        }

        public static Reason[] values() {
            return (Reason[]) d.clone();
        }
    }
}
