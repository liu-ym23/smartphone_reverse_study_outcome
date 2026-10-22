package com.stepos.ability.voicewakeup.ui;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/ability/voicewakeup/ui/WakeupPagAnimation;", "", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WakeupPagAnimation {
    public static final WakeupPagAnimation b;
    public static final WakeupPagAnimation c;
    public static final WakeupPagAnimation d;
    public static final WakeupPagAnimation e;
    public static final WakeupPagAnimation f;
    public static final /* synthetic */ WakeupPagAnimation[] g;

    /* renamed from: a, reason: collision with root package name */
    public final String f3431a;

    static {
        WakeupPagAnimation wakeupPagAnimation = new WakeupPagAnimation("HELLO", 0, "pag/hello.pag");
        b = wakeupPagAnimation;
        WakeupPagAnimation wakeupPagAnimation2 = new WakeupPagAnimation("IDLE", 1, "pag/idle.pag");
        c = wakeupPagAnimation2;
        WakeupPagAnimation wakeupPagAnimation3 = new WakeupPagAnimation("FINISH", 2, "pag/finish.pag");
        d = wakeupPagAnimation3;
        WakeupPagAnimation wakeupPagAnimation4 = new WakeupPagAnimation("FAIL", 3, "pag/fail.pag");
        e = wakeupPagAnimation4;
        WakeupPagAnimation wakeupPagAnimation5 = new WakeupPagAnimation("ALL_COMPLETE", 4, "pag/all_complete.pag");
        f = wakeupPagAnimation5;
        WakeupPagAnimation[] wakeupPagAnimationArr = {wakeupPagAnimation, wakeupPagAnimation2, wakeupPagAnimation3, wakeupPagAnimation4, wakeupPagAnimation5};
        g = wakeupPagAnimationArr;
        kotlin.enums.a.a(wakeupPagAnimationArr);
    }

    public WakeupPagAnimation(String str, int i, String str2) {
        this.f3431a = str2;
    }

    public static WakeupPagAnimation valueOf(String str) {
        return (WakeupPagAnimation) Enum.valueOf(WakeupPagAnimation.class, str);
    }

    public static WakeupPagAnimation[] values() {
        return (WakeupPagAnimation[]) g.clone();
    }
}
