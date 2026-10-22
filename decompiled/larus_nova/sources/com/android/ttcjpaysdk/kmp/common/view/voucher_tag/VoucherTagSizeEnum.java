package com.android.ttcjpaysdk.kmp.common.view.voucher_tag;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0011\u0010\u000f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/voucher_tag/VoucherTagSizeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "LARGE", "MEDIUM", "tagHeight", "Landroidx/compose/ui/unit/Dp;", "getTagHeight-D9Ej5fM", "()F", "tagCornerRadius", "getTagCornerRadius-D9Ej5fM", "textSize", "", "getTextSize", "tagItemsSpace", "getTagItemsSpace-D9Ej5fM", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoucherTagSizeEnum extends Enum<VoucherTagSizeEnum> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ VoucherTagSizeEnum[] $VALUES = null;
    public static final VoucherTagSizeEnum LARGE = null;
    public static final VoucherTagSizeEnum MEDIUM = null;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[VoucherTagSizeEnum.values().length];
            r100[VoucherTagSizeEnum.LARGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[VoucherTagSizeEnum.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private static final /* synthetic */ VoucherTagSizeEnum[] $values() {
        return new VoucherTagSizeEnum[]{LARGE, MEDIUM};
    }

    public static EnumEntries<VoucherTagSizeEnum> getEntries() {
        return $ENTRIES;
    }

    static {
        LARGE = new VoucherTagSizeEnum("LARGE", 0);
        MEDIUM = new VoucherTagSizeEnum("MEDIUM", 1);
        VoucherTagSizeEnum[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static VoucherTagSizeEnum[] values() {
        return (VoucherTagSizeEnum[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: getTagCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m8132getTagCornerRadiusD9Ej5fM() {
        int r100 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return Dp.m7544constructorimpl(2);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return Dp.m7544constructorimpl(3);
    }

    /* JADX INFO: renamed from: getTagHeight-D9Ej5fM, reason: not valid java name */
    public final float m8133getTagHeightD9Ej5fM() {
        int r100 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return Dp.m7544constructorimpl(14);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return Dp.m7544constructorimpl(19);
    }

    /* JADX INFO: renamed from: getTagItemsSpace-D9Ej5fM, reason: not valid java name */
    public final float m8134getTagItemsSpaceD9Ej5fM() {
        int r100 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return Dp.m7544constructorimpl(4);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return Dp.m7544constructorimpl(6);
    }

    public final float getTextSize() {
        int r100 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r100 != 1) goto L5;
        return 11.0f;
    L5:
        if (r100 != 2) goto L8;
        return 8.0f;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static VoucherTagSizeEnum valueOf(String r100) {
        return (VoucherTagSizeEnum) r27.a.a(VoucherTagSizeEnum.class, r100);
    }

    private VoucherTagSizeEnum(String r100, int r101) {
        super(r100, r101);
    }
}
