package com.stepos.ability.voicewakeup.ui;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/stepos/ability/voicewakeup/ui/WakeupPagPlayer$Mode", "", "Lcom/stepos/ability/voicewakeup/ui/WakeupPagPlayer$Mode;", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class WakeupPagPlayer$Mode {

    /* renamed from: a, reason: collision with root package name */
    public static final WakeupPagPlayer$Mode f3433a;
    public static final WakeupPagPlayer$Mode b;
    public static final WakeupPagPlayer$Mode c;
    public static final /* synthetic */ WakeupPagPlayer$Mode[] d;

    static {
        WakeupPagPlayer$Mode wakeupPagPlayer$Mode = new WakeupPagPlayer$Mode("LOOP", 0);
        f3433a = wakeupPagPlayer$Mode;
        WakeupPagPlayer$Mode wakeupPagPlayer$Mode2 = new WakeupPagPlayer$Mode("ONCE", 1);
        b = wakeupPagPlayer$Mode2;
        WakeupPagPlayer$Mode wakeupPagPlayer$Mode3 = new WakeupPagPlayer$Mode("HOLD", 2);
        WakeupPagPlayer$Mode wakeupPagPlayer$Mode4 = new WakeupPagPlayer$Mode("INTERVAL_LOOP", 3);
        c = wakeupPagPlayer$Mode4;
        WakeupPagPlayer$Mode[] wakeupPagPlayer$ModeArr = {wakeupPagPlayer$Mode, wakeupPagPlayer$Mode2, wakeupPagPlayer$Mode3, wakeupPagPlayer$Mode4};
        d = wakeupPagPlayer$ModeArr;
        kotlin.enums.a.a(wakeupPagPlayer$ModeArr);
    }

    public static WakeupPagPlayer$Mode valueOf(String str) {
        return (WakeupPagPlayer$Mode) Enum.valueOf(WakeupPagPlayer$Mode.class, str);
    }

    public static WakeupPagPlayer$Mode[] values() {
        return (WakeupPagPlayer$Mode[]) d.clone();
    }
}
