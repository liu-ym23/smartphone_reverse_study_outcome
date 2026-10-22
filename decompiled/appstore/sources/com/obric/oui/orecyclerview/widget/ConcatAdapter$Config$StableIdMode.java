package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes4.dex */
public final enum ConcatAdapter$Config$StableIdMode extends Enum<ConcatAdapter$Config$StableIdMode> {
    private static final /* synthetic */ ConcatAdapter$Config$StableIdMode[] $VALUES = null;
    public static final ConcatAdapter$Config$StableIdMode ISOLATED_STABLE_IDS = null;
    public static final ConcatAdapter$Config$StableIdMode NO_STABLE_IDS = null;
    public static final ConcatAdapter$Config$StableIdMode SHARED_STABLE_IDS = null;

    static {
        ConcatAdapter$Config$StableIdMode r10 = new ConcatAdapter$Config$StableIdMode("NO_STABLE_IDS", 0);
        NO_STABLE_IDS = r10;
        ConcatAdapter$Config$StableIdMode r11 = new ConcatAdapter$Config$StableIdMode("ISOLATED_STABLE_IDS", 1);
        ISOLATED_STABLE_IDS = r11;
        ConcatAdapter$Config$StableIdMode r12 = new ConcatAdapter$Config$StableIdMode("SHARED_STABLE_IDS", 2);
        SHARED_STABLE_IDS = r12;
        $VALUES = new ConcatAdapter$Config$StableIdMode[]{r10, r11, r12};
    }

    private ConcatAdapter$Config$StableIdMode(String r10, int r11) {
        super(r10, r11);
    }

    public static ConcatAdapter$Config$StableIdMode valueOf(String r10) {
        return (ConcatAdapter$Config$StableIdMode) Enum.valueOf(ConcatAdapter$Config$StableIdMode.class, r10);
    }

    public static ConcatAdapter$Config$StableIdMode[] values() {
        return (ConcatAdapter$Config$StableIdMode[]) $VALUES.clone();
    }
}
