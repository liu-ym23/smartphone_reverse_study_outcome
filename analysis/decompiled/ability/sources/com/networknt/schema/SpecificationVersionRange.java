package com.networknt.schema;

import java.util.Arrays;
import java.util.EnumSet;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class SpecificationVersionRange {
    public static final SpecificationVersionRange b;
    public static final SpecificationVersionRange c;
    public static final SpecificationVersionRange d;
    public static final SpecificationVersionRange e;
    public static final SpecificationVersionRange f;
    public static final SpecificationVersionRange g;
    public static final SpecificationVersionRange h;
    public static final SpecificationVersionRange i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ SpecificationVersionRange[] f3014j;

    /* renamed from: a, reason: collision with root package name */
    public final EnumSet f3015a;

    static {
        SpecificationVersionRange specificationVersionRange = new SpecificationVersionRange("NONE", 0, new SpecificationVersion[0]);
        b = specificationVersionRange;
        SpecificationVersion specificationVersion = SpecificationVersion.DRAFT_4;
        SpecificationVersion specificationVersion2 = SpecificationVersion.DRAFT_6;
        SpecificationVersion specificationVersion3 = SpecificationVersion.DRAFT_7;
        SpecificationVersion specificationVersion4 = SpecificationVersion.DRAFT_2019_09;
        SpecificationVersion specificationVersion5 = SpecificationVersion.DRAFT_2020_12;
        SpecificationVersionRange specificationVersionRange2 = new SpecificationVersionRange("ALL_VERSIONS", 1, new SpecificationVersion[]{specificationVersion, specificationVersion2, specificationVersion3, specificationVersion4, specificationVersion5});
        c = specificationVersionRange2;
        SpecificationVersionRange specificationVersionRange3 = new SpecificationVersionRange("MIN_DRAFT_6", 2, new SpecificationVersion[]{specificationVersion2, specificationVersion3, specificationVersion4, specificationVersion5});
        d = specificationVersionRange3;
        SpecificationVersionRange specificationVersionRange4 = new SpecificationVersionRange("DRAFT_6_TO_DRAFT_7", 3, new SpecificationVersion[]{specificationVersion2, specificationVersion3});
        e = specificationVersionRange4;
        SpecificationVersionRange specificationVersionRange5 = new SpecificationVersionRange("MIN_DRAFT_7", 4, new SpecificationVersion[]{specificationVersion3, specificationVersion4, specificationVersion5});
        SpecificationVersionRange specificationVersionRange6 = new SpecificationVersionRange("MAX_DRAFT_7", 5, new SpecificationVersion[]{specificationVersion, specificationVersion2, specificationVersion3});
        f = specificationVersionRange6;
        SpecificationVersionRange specificationVersionRange7 = new SpecificationVersionRange("MAX_DRAFT_2019_09", 6, new SpecificationVersion[]{specificationVersion, specificationVersion2, specificationVersion3, specificationVersion4});
        SpecificationVersionRange specificationVersionRange8 = new SpecificationVersionRange("MIN_DRAFT_2019_09", 7, new SpecificationVersion[]{specificationVersion4, specificationVersion5});
        g = specificationVersionRange8;
        SpecificationVersionRange specificationVersionRange9 = new SpecificationVersionRange("MIN_DRAFT_2020_12", 8, new SpecificationVersion[]{specificationVersion5});
        h = specificationVersionRange9;
        SpecificationVersionRange specificationVersionRange10 = new SpecificationVersionRange("DRAFT_2019_09", 9, new SpecificationVersion[]{specificationVersion4});
        SpecificationVersionRange specificationVersionRange11 = new SpecificationVersionRange("DRAFT_7", 10, new SpecificationVersion[]{specificationVersion3});
        i = specificationVersionRange11;
        f3014j = new SpecificationVersionRange[]{specificationVersionRange, specificationVersionRange2, specificationVersionRange3, specificationVersionRange4, specificationVersionRange5, specificationVersionRange6, specificationVersionRange7, specificationVersionRange8, specificationVersionRange9, specificationVersionRange10, specificationVersionRange11};
    }

    public SpecificationVersionRange(String str, int i6, SpecificationVersion[] specificationVersionArr) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(SpecificationVersion.class);
        this.f3015a = enumSetNoneOf;
        enumSetNoneOf.addAll(Arrays.asList(specificationVersionArr));
    }

    public static SpecificationVersionRange valueOf(String str) {
        return (SpecificationVersionRange) Enum.valueOf(SpecificationVersionRange.class, str);
    }

    public static SpecificationVersionRange[] values() {
        return (SpecificationVersionRange[]) f3014j.clone();
    }
}
