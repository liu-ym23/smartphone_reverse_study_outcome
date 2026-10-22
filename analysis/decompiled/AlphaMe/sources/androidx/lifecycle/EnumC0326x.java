package androidx.lifecycle;

import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: androidx.lifecycle.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0326x {
    private static final /* synthetic */ EnumC0326x[] $VALUES;

    @NotNull
    public static final C0324v Companion;
    public static final EnumC0326x ON_ANY;
    public static final EnumC0326x ON_CREATE;
    public static final EnumC0326x ON_DESTROY;
    public static final EnumC0326x ON_PAUSE;
    public static final EnumC0326x ON_RESUME;
    public static final EnumC0326x ON_START;
    public static final EnumC0326x ON_STOP;

    static {
        EnumC0326x enumC0326x = new EnumC0326x("ON_CREATE", 0);
        ON_CREATE = enumC0326x;
        EnumC0326x enumC0326x2 = new EnumC0326x("ON_START", 1);
        ON_START = enumC0326x2;
        EnumC0326x enumC0326x3 = new EnumC0326x("ON_RESUME", 2);
        ON_RESUME = enumC0326x3;
        EnumC0326x enumC0326x4 = new EnumC0326x("ON_PAUSE", 3);
        ON_PAUSE = enumC0326x4;
        EnumC0326x enumC0326x5 = new EnumC0326x("ON_STOP", 4);
        ON_STOP = enumC0326x5;
        EnumC0326x enumC0326x6 = new EnumC0326x("ON_DESTROY", 5);
        ON_DESTROY = enumC0326x6;
        EnumC0326x enumC0326x7 = new EnumC0326x("ON_ANY", 6);
        ON_ANY = enumC0326x7;
        $VALUES = new EnumC0326x[]{enumC0326x, enumC0326x2, enumC0326x3, enumC0326x4, enumC0326x5, enumC0326x6, enumC0326x7};
        Companion = new C0324v();
    }

    public static EnumC0326x valueOf(String str) {
        return (EnumC0326x) Enum.valueOf(EnumC0326x.class, str);
    }

    public static EnumC0326x[] values() {
        return (EnumC0326x[]) $VALUES.clone();
    }

    public final EnumC0327y a() {
        switch (AbstractC0325w.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
                return EnumC0327y.f3985c;
            case 3:
            case 4:
                return EnumC0327y.f3986d;
            case 5:
                return EnumC0327y.f3987e;
            case 6:
                return EnumC0327y.f3983a;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
