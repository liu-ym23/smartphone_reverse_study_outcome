package kotlin.reflect.jvm.internal.impl.descriptors;

import h8.C1504L;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class Modality {

    /* renamed from: a, reason: collision with root package name */
    public static final C1504L f4953a;
    public static final Modality b;
    public static final Modality c;
    public static final Modality d;
    public static final Modality e;
    public static final /* synthetic */ Modality[] f;

    static {
        Modality modality = new Modality("FINAL", 0);
        b = modality;
        Modality modality2 = new Modality("SEALED", 1);
        c = modality2;
        Modality modality3 = new Modality("OPEN", 2);
        d = modality3;
        Modality modality4 = new Modality("ABSTRACT", 3);
        e = modality4;
        Modality[] modalityArr = {modality, modality2, modality3, modality4};
        f = modalityArr;
        kotlin.enums.a.a(modalityArr);
        f4953a = new C1504L(5);
    }

    public static Modality valueOf(String str) {
        return (Modality) Enum.valueOf(Modality.class, str);
    }

    public static Modality[] values() {
        return (Modality[]) f.clone();
    }
}
