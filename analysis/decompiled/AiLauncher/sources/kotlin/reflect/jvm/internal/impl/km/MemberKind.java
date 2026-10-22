package kotlin.reflect.jvm.internal.impl.km;

import O9.c;
import ea.C4018b;
import h9.InterfaceC4149a;
import kotlin.enums.a;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class MemberKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ MemberKind[] $VALUES;
    private final c flag;
    public static final MemberKind DECLARATION = new MemberKind("DECLARATION", 0, 0);
    public static final MemberKind FAKE_OVERRIDE = new MemberKind("FAKE_OVERRIDE", 1, 1);
    public static final MemberKind DELEGATION = new MemberKind("DELEGATION", 2, 2);
    public static final MemberKind SYNTHESIZED = new MemberKind("SYNTHESIZED", 3, 3);

    private static final /* synthetic */ MemberKind[] $values() {
        return new MemberKind[]{DECLARATION, FAKE_OVERRIDE, DELEGATION, SYNTHESIZED};
    }

    static {
        MemberKind[] memberKindArr$values = $values();
        $VALUES = memberKindArr$values;
        $ENTRIES = a.a(memberKindArr$values);
    }

    private MemberKind(String str, int i10, int i11) {
        C4018b.d<ProtoBuf$MemberKind> MEMBER_KIND = C4018b.f32390q;
        p.h(MEMBER_KIND, "MEMBER_KIND");
        this.flag = new c(MEMBER_KIND, i11);
    }

    public static InterfaceC4149a<MemberKind> getEntries() {
        return $ENTRIES;
    }

    public static MemberKind valueOf(String str) {
        return (MemberKind) Enum.valueOf(MemberKind.class, str);
    }

    public static MemberKind[] values() {
        return (MemberKind[]) $VALUES.clone();
    }

    public final c getFlag$kotlin_metadata() {
        return this.flag;
    }
}
