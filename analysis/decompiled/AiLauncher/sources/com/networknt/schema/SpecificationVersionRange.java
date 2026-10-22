package com.networknt.schema;

import com.stepos.core.download.ModelFlowMeta;
import java.util.Arrays;
import java.util.EnumSet;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ALL_VERSIONS' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class SpecificationVersionRange {
    private static final /* synthetic */ SpecificationVersionRange[] $VALUES;
    public static final SpecificationVersionRange ALL_VERSIONS;
    public static final SpecificationVersionRange DRAFT_2019_09;
    public static final SpecificationVersionRange DRAFT_6_TO_DRAFT_7;
    public static final SpecificationVersionRange DRAFT_7;
    public static final SpecificationVersionRange MAX_DRAFT_2019_09;
    public static final SpecificationVersionRange MAX_DRAFT_7;
    public static final SpecificationVersionRange MIN_DRAFT_2019_09;
    public static final SpecificationVersionRange MIN_DRAFT_2020_12;
    public static final SpecificationVersionRange MIN_DRAFT_6;
    public static final SpecificationVersionRange MIN_DRAFT_7;
    public static final SpecificationVersionRange NONE = new SpecificationVersionRange(ModelFlowMeta.PLAN_NONE, 0, new SpecificationVersion[0]);
    private final EnumSet<SpecificationVersion> versions;

    private static /* synthetic */ SpecificationVersionRange[] $values() {
        return new SpecificationVersionRange[]{NONE, ALL_VERSIONS, MIN_DRAFT_6, DRAFT_6_TO_DRAFT_7, MIN_DRAFT_7, MAX_DRAFT_7, MAX_DRAFT_2019_09, MIN_DRAFT_2019_09, MIN_DRAFT_2020_12, DRAFT_2019_09, DRAFT_7};
    }

    static {
        SpecificationVersion specificationVersion = SpecificationVersion.DRAFT_4;
        SpecificationVersion specificationVersion2 = SpecificationVersion.DRAFT_6;
        SpecificationVersion specificationVersion3 = SpecificationVersion.DRAFT_7;
        SpecificationVersion specificationVersion4 = SpecificationVersion.DRAFT_2019_09;
        SpecificationVersion specificationVersion5 = SpecificationVersion.DRAFT_2020_12;
        ALL_VERSIONS = new SpecificationVersionRange("ALL_VERSIONS", 1, new SpecificationVersion[]{specificationVersion, specificationVersion2, specificationVersion3, specificationVersion4, specificationVersion5});
        MIN_DRAFT_6 = new SpecificationVersionRange("MIN_DRAFT_6", 2, new SpecificationVersion[]{specificationVersion2, specificationVersion3, specificationVersion4, specificationVersion5});
        DRAFT_6_TO_DRAFT_7 = new SpecificationVersionRange("DRAFT_6_TO_DRAFT_7", 3, new SpecificationVersion[]{specificationVersion2, specificationVersion3});
        MIN_DRAFT_7 = new SpecificationVersionRange("MIN_DRAFT_7", 4, new SpecificationVersion[]{specificationVersion3, specificationVersion4, specificationVersion5});
        MAX_DRAFT_7 = new SpecificationVersionRange("MAX_DRAFT_7", 5, new SpecificationVersion[]{specificationVersion, specificationVersion2, specificationVersion3});
        MAX_DRAFT_2019_09 = new SpecificationVersionRange("MAX_DRAFT_2019_09", 6, new SpecificationVersion[]{specificationVersion, specificationVersion2, specificationVersion3, specificationVersion4});
        MIN_DRAFT_2019_09 = new SpecificationVersionRange("MIN_DRAFT_2019_09", 7, new SpecificationVersion[]{specificationVersion4, specificationVersion5});
        MIN_DRAFT_2020_12 = new SpecificationVersionRange("MIN_DRAFT_2020_12", 8, new SpecificationVersion[]{specificationVersion5});
        DRAFT_2019_09 = new SpecificationVersionRange("DRAFT_2019_09", 9, new SpecificationVersion[]{specificationVersion4});
        DRAFT_7 = new SpecificationVersionRange("DRAFT_7", 10, new SpecificationVersion[]{specificationVersion3});
        $VALUES = $values();
    }

    private SpecificationVersionRange(String str, int i10, SpecificationVersion[] specificationVersionArr) {
        EnumSet<SpecificationVersion> enumSetNoneOf = EnumSet.noneOf(SpecificationVersion.class);
        this.versions = enumSetNoneOf;
        enumSetNoneOf.addAll(Arrays.asList(specificationVersionArr));
    }

    public static SpecificationVersionRange valueOf(String str) {
        return (SpecificationVersionRange) Enum.valueOf(SpecificationVersionRange.class, str);
    }

    public static SpecificationVersionRange[] values() {
        return (SpecificationVersionRange[]) $VALUES.clone();
    }

    public EnumSet<SpecificationVersion> getVersions() {
        return this.versions;
    }
}
