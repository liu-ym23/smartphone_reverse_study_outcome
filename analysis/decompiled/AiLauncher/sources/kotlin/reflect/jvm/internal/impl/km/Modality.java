package kotlin.reflect.jvm.internal.impl.km;

import O9.c;
import ea.C4018b;
import h9.InterfaceC4149a;
import kotlin.enums.a;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class Modality {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ Modality[] $VALUES;
    private final c flag;
    public static final Modality FINAL = new Modality("FINAL", 0, 0);
    public static final Modality OPEN = new Modality("OPEN", 1, 1);
    public static final Modality ABSTRACT = new Modality("ABSTRACT", 2, 2);
    public static final Modality SEALED = new Modality("SEALED", 3, 3);

    private static final /* synthetic */ Modality[] $values() {
        return new Modality[]{FINAL, OPEN, ABSTRACT, SEALED};
    }

    static {
        Modality[] modalityArr$values = $values();
        $VALUES = modalityArr$values;
        $ENTRIES = a.a(modalityArr$values);
    }

    private Modality(String str, int i10, int i11) {
        C4018b.d<ProtoBuf$Modality> MODALITY = C4018b.f32378e;
        p.h(MODALITY, "MODALITY");
        this.flag = new c(MODALITY, i11);
    }

    public static InterfaceC4149a<Modality> getEntries() {
        return $ENTRIES;
    }

    public static Modality valueOf(String str) {
        return (Modality) Enum.valueOf(Modality.class, str);
    }

    public static Modality[] values() {
        return (Modality[]) $VALUES.clone();
    }

    public final c getFlag$kotlin_metadata() {
        return this.flag;
    }
}
