package org.slf4j.helpers;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class Reporter$TargetChoice {

    /* renamed from: a, reason: collision with root package name */
    public static final Reporter$TargetChoice f5516a;
    public static final Reporter$TargetChoice b;
    public static final /* synthetic */ Reporter$TargetChoice[] c;

    static {
        Reporter$TargetChoice reporter$TargetChoice = new Reporter$TargetChoice("Stderr", 0);
        f5516a = reporter$TargetChoice;
        Reporter$TargetChoice reporter$TargetChoice2 = new Reporter$TargetChoice("Stdout", 1);
        b = reporter$TargetChoice2;
        c = new Reporter$TargetChoice[]{reporter$TargetChoice, reporter$TargetChoice2};
    }

    public static Reporter$TargetChoice valueOf(String str) {
        return (Reporter$TargetChoice) Enum.valueOf(Reporter$TargetChoice.class, str);
    }

    public static Reporter$TargetChoice[] values() {
        return (Reporter$TargetChoice[]) c.clone();
    }
}
