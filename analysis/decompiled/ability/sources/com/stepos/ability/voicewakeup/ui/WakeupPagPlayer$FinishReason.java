package com.stepos.ability.voicewakeup.ui;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/stepos/ability/voicewakeup/ui/WakeupPagPlayer$FinishReason", "", "Lcom/stepos/ability/voicewakeup/ui/WakeupPagPlayer$FinishReason;", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class WakeupPagPlayer$FinishReason {

    /* renamed from: a, reason: collision with root package name */
    public static final WakeupPagPlayer$FinishReason f3432a;
    public static final WakeupPagPlayer$FinishReason b;
    public static final WakeupPagPlayer$FinishReason c;
    public static final WakeupPagPlayer$FinishReason d;
    public static final WakeupPagPlayer$FinishReason e;
    public static final WakeupPagPlayer$FinishReason f;
    public static final WakeupPagPlayer$FinishReason g;
    public static final WakeupPagPlayer$FinishReason h;
    public static final /* synthetic */ WakeupPagPlayer$FinishReason[] i;

    static {
        WakeupPagPlayer$FinishReason wakeupPagPlayer$FinishReason = new WakeupPagPlayer$FinishReason("END_CALLBACK", 0);
        f3432a = wakeupPagPlayer$FinishReason;
        WakeupPagPlayer$FinishReason wakeupPagPlayer$FinishReason2 = new WakeupPagPlayer$FinishReason("LOAD_FAILED", 1);
        b = wakeupPagPlayer$FinishReason2;
        WakeupPagPlayer$FinishReason wakeupPagPlayer$FinishReason3 = new WakeupPagPlayer$FinishReason("INVALID_DURATION", 2);
        c = wakeupPagPlayer$FinishReason3;
        WakeupPagPlayer$FinishReason wakeupPagPlayer$FinishReason4 = new WakeupPagPlayer$FinishReason("PLAY_FAILED", 3);
        d = wakeupPagPlayer$FinishReason4;
        WakeupPagPlayer$FinishReason wakeupPagPlayer$FinishReason5 = new WakeupPagPlayer$FinishReason("RESUME_AT_END", 4);
        e = wakeupPagPlayer$FinishReason5;
        WakeupPagPlayer$FinishReason wakeupPagPlayer$FinishReason6 = new WakeupPagPlayer$FinishReason("PROGRESS_READ_FAILED", 5);
        f = wakeupPagPlayer$FinishReason6;
        WakeupPagPlayer$FinishReason wakeupPagPlayer$FinishReason7 = new WakeupPagPlayer$FinishReason("END_STATE_READ_FAILED", 6);
        g = wakeupPagPlayer$FinishReason7;
        WakeupPagPlayer$FinishReason wakeupPagPlayer$FinishReason8 = new WakeupPagPlayer$FinishReason("WATCHDOG_TIMEOUT", 7);
        h = wakeupPagPlayer$FinishReason8;
        WakeupPagPlayer$FinishReason[] wakeupPagPlayer$FinishReasonArr = {wakeupPagPlayer$FinishReason, wakeupPagPlayer$FinishReason2, wakeupPagPlayer$FinishReason3, wakeupPagPlayer$FinishReason4, wakeupPagPlayer$FinishReason5, wakeupPagPlayer$FinishReason6, wakeupPagPlayer$FinishReason7, wakeupPagPlayer$FinishReason8};
        i = wakeupPagPlayer$FinishReasonArr;
        kotlin.enums.a.a(wakeupPagPlayer$FinishReasonArr);
    }

    public static WakeupPagPlayer$FinishReason valueOf(String str) {
        return (WakeupPagPlayer$FinishReason) Enum.valueOf(WakeupPagPlayer$FinishReason.class, str);
    }

    public static WakeupPagPlayer$FinishReason[] values() {
        return (WakeupPagPlayer$FinishReason[]) i.clone();
    }
}
