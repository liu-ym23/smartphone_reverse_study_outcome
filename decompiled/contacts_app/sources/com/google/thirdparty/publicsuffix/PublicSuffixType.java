package com.google.thirdparty.publicsuffix;

/* JADX INFO: loaded from: classes2.dex */
final enum PublicSuffixType extends Enum<PublicSuffixType> {
    private static final /* synthetic */ PublicSuffixType[] $VALUES = null;
    public static final PublicSuffixType ICANN = null;
    public static final PublicSuffixType PRIVATE = null;
    private final char innerNodeCode;
    private final char leafNodeCode;

    public static PublicSuffixType valueOf(String r1) {
        return (PublicSuffixType) Enum.valueOf(PublicSuffixType.class, r1);
    }

    public static PublicSuffixType[] values() {
        return (PublicSuffixType[]) $VALUES.clone();
    }

    static {
        PublicSuffixType r0 = new PublicSuffixType("PRIVATE", 0, ':', ',');
        PRIVATE = r0;
        PublicSuffixType r1 = new PublicSuffixType("ICANN", 1, '!', '?');
        ICANN = r1;
        $VALUES = new PublicSuffixType[]{r0, r1};
    }

    private PublicSuffixType(String r1, int r2, char r3, char r4) {
        super(r1, r2);
        this.innerNodeCode = r3;
        this.leafNodeCode = r4;
    }

    char getLeafNodeCode() {
        return this.leafNodeCode;
    }

    char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    static PublicSuffixType fromCode(char r5) {
        PublicSuffixType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        PublicSuffixType r3 = r0[r2];
        if (r3.getInnerNodeCode() == r5) goto L10;
        if (r3.getLeafNodeCode() == r5) goto L10;
        r2 = r2 + 1;
    L10:
        return r3;
    L12:
        throw new IllegalArgumentException("No enum corresponding to given code: " + r5);
    }

    static PublicSuffixType fromIsPrivate(boolean r0) {
        if (r0 == false) goto L5;
        return PRIVATE;
    L5:
        return ICANN;
    }
}
