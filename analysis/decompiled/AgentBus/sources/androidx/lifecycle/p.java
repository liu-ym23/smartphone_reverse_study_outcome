package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class p {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ p[] $VALUES;
    public static final n Companion;
    public static final p ON_ANY;
    public static final p ON_CREATE;
    public static final p ON_DESTROY;
    public static final p ON_PAUSE;
    public static final p ON_RESUME;
    public static final p ON_START;
    public static final p ON_STOP;

    static {
        p pVar = new p("ON_CREATE", 0);
        ON_CREATE = pVar;
        p pVar2 = new p("ON_START", 1);
        ON_START = pVar2;
        p pVar3 = new p("ON_RESUME", 2);
        ON_RESUME = pVar3;
        p pVar4 = new p("ON_PAUSE", 3);
        ON_PAUSE = pVar4;
        p pVar5 = new p("ON_STOP", 4);
        ON_STOP = pVar5;
        p pVar6 = new p("ON_DESTROY", 5);
        ON_DESTROY = pVar6;
        p pVar7 = new p("ON_ANY", 6);
        ON_ANY = pVar7;
        p[] pVarArr = {pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7};
        $VALUES = pVarArr;
        $ENTRIES = w7.e0.s(pVarArr);
        Companion = new n();
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) $VALUES.clone();
    }

    public final q a() {
        switch (o.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
                return q.f1022h;
            case 3:
            case 4:
                return q.f1023i;
            case 5:
                return q.f1024j;
            case 6:
                return q.f1020f;
            case 7:
                throw new IllegalArgumentException(this + " has no target state");
            default:
                throw new a4.u();
        }
    }
}
