package kotlin.reflect.jvm.internal.impl.descriptors;

import h9.InterfaceC4149a;
import kotlin.jvm.internal.i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class Modality {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ Modality[] $VALUES;
    public static final a Companion;
    public static final Modality FINAL = new Modality("FINAL", 0);
    public static final Modality SEALED = new Modality("SEALED", 1);
    public static final Modality OPEN = new Modality("OPEN", 2);
    public static final Modality ABSTRACT = new Modality("ABSTRACT", 3);

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public final Modality a(boolean z10, boolean z11, boolean z12) {
            return z10 ? Modality.SEALED : z11 ? Modality.ABSTRACT : z12 ? Modality.OPEN : Modality.FINAL;
        }

        public a() {
        }
    }

    private static final /* synthetic */ Modality[] $values() {
        return new Modality[]{FINAL, SEALED, OPEN, ABSTRACT};
    }

    static {
        Modality[] modalityArr$values = $values();
        $VALUES = modalityArr$values;
        $ENTRIES = kotlin.enums.a.a(modalityArr$values);
        Companion = new a(null);
    }

    private Modality(String str, int i10) {
    }

    public static Modality valueOf(String str) {
        return (Modality) Enum.valueOf(Modality.class, str);
    }

    public static Modality[] values() {
        return (Modality[]) $VALUES.clone();
    }
}
