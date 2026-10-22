package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public final enum PublicSuffixType extends Enum<PublicSuffixType> {
    private static final /* synthetic */ PublicSuffixType[] $VALUES = null;
    public static final PublicSuffixType PRIVATE = null;
    public static final PublicSuffixType REGISTRY = null;
    private final char innerNodeCode;
    private final char leafNodeCode;

    static {
        PublicSuffixType r10 = new PublicSuffixType("PRIVATE", 0, ':', ',');
        PRIVATE = r10;
        PublicSuffixType r11 = new PublicSuffixType("REGISTRY", 1, '!', '?');
        REGISTRY = r11;
        $VALUES = new PublicSuffixType[]{r10, r11};
    }

    private PublicSuffixType(String r10, int r11, char r12, char r13) {
        super(r10, r11);
        this.innerNodeCode = r12;
        this.leafNodeCode = r13;
    }

    public static PublicSuffixType fromCode(char r10) {
        PublicSuffixType[] r11 = values();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        PublicSuffixType r14 = r11[r13];
        if (r14.getInnerNodeCode() == r10) goto L10;
        if (r14.getLeafNodeCode() == r10) goto L10;
        r13 = r13 + 1;
    L10:
        return r14;
    L12:
        throw new IllegalArgumentException("No enum corresponding to given code: " + r10);
    }

    public static PublicSuffixType fromIsPrivate(boolean r10) {
        if (r10 == false) goto L5;
        return PRIVATE;
    L5:
        return REGISTRY;
    }

    public static PublicSuffixType valueOf(String r10) {
        return (PublicSuffixType) Enum.valueOf(PublicSuffixType.class, r10);
    }

    public static PublicSuffixType[] values() {
        return (PublicSuffixType[]) $VALUES.clone();
    }

    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
