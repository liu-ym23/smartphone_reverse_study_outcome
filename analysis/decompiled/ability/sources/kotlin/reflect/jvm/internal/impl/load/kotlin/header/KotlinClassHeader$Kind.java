package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import F1.a;
import java.util.LinkedHashMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class KotlinClassHeader$Kind {
    public static final a b;
    public static final LinkedHashMap c;
    public static final KotlinClassHeader$Kind d;
    public static final KotlinClassHeader$Kind e;
    public static final KotlinClassHeader$Kind f;
    public static final KotlinClassHeader$Kind g;
    public static final KotlinClassHeader$Kind h;
    public static final KotlinClassHeader$Kind i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ KotlinClassHeader$Kind[] f5009j;

    /* renamed from: a, reason: collision with root package name */
    public final int f5010a;

    static {
        KotlinClassHeader$Kind kotlinClassHeader$Kind = new KotlinClassHeader$Kind("UNKNOWN", 0, 0);
        d = kotlinClassHeader$Kind;
        KotlinClassHeader$Kind kotlinClassHeader$Kind2 = new KotlinClassHeader$Kind("CLASS", 1, 1);
        e = kotlinClassHeader$Kind2;
        KotlinClassHeader$Kind kotlinClassHeader$Kind3 = new KotlinClassHeader$Kind("FILE_FACADE", 2, 2);
        f = kotlinClassHeader$Kind3;
        KotlinClassHeader$Kind kotlinClassHeader$Kind4 = new KotlinClassHeader$Kind("SYNTHETIC_CLASS", 3, 3);
        g = kotlinClassHeader$Kind4;
        KotlinClassHeader$Kind kotlinClassHeader$Kind5 = new KotlinClassHeader$Kind("MULTIFILE_CLASS", 4, 4);
        h = kotlinClassHeader$Kind5;
        KotlinClassHeader$Kind kotlinClassHeader$Kind6 = new KotlinClassHeader$Kind("MULTIFILE_CLASS_PART", 5, 5);
        i = kotlinClassHeader$Kind6;
        KotlinClassHeader$Kind[] kotlinClassHeader$KindArr = {kotlinClassHeader$Kind, kotlinClassHeader$Kind2, kotlinClassHeader$Kind3, kotlinClassHeader$Kind4, kotlinClassHeader$Kind5, kotlinClassHeader$Kind6};
        f5009j = kotlinClassHeader$KindArr;
        kotlin.enums.a.a(kotlinClassHeader$KindArr);
        b = new a();
        KotlinClassHeader$Kind[] kotlinClassHeader$KindArrValues = values();
        int iP = kotlin.collections.a.P(kotlinClassHeader$KindArrValues.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP < 16 ? 16 : iP);
        for (KotlinClassHeader$Kind kotlinClassHeader$Kind7 : kotlinClassHeader$KindArrValues) {
            linkedHashMap.put(Integer.valueOf(kotlinClassHeader$Kind7.f5010a), kotlinClassHeader$Kind7);
        }
        c = linkedHashMap;
    }

    public KotlinClassHeader$Kind(String str, int i6, int i10) {
        this.f5010a = i10;
    }

    public static KotlinClassHeader$Kind valueOf(String str) {
        return (KotlinClassHeader$Kind) Enum.valueOf(KotlinClassHeader$Kind.class, str);
    }

    public static KotlinClassHeader$Kind[] values() {
        return (KotlinClassHeader$Kind[]) f5009j.clone();
    }
}
