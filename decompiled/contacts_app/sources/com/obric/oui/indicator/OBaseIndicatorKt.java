package com.obric.oui.indicator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: OBaseIndicator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"INDICATOR_TYPE_NORMAL", "", "INDICATOR_TYPE_PIC", "resolveDotSpacingSpec", "Lcom/obric/oui/indicator/DotSpacingSpec;", "index", "spacing", "visibleRange", "Lkotlin/ranges/IntRange;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OBaseIndicatorKt {
    public static final int INDICATOR_TYPE_NORMAL = 0;
    public static final int INDICATOR_TYPE_PIC = 1;

    public static final DotSpacingSpec resolveDotSpacingSpec(int r3, int r4, IntRange r5) {
        Intrinsics.checkNotNullParameter(r5, "visibleRange");
        if (r5.getFirst() != r5.getLast()) goto L8;
        if (r3 != r5.getFirst()) goto L8;
        return new DotSpacingSpec(0, 0);
    L8:
        if (r3 != r5.getFirst()) goto L11;
        return new DotSpacingSpec(0, r4);
    L11:
        if (r3 != r5.getLast()) goto L14;
        return new DotSpacingSpec(r4, 0);
    L14:
        return new DotSpacingSpec(r4, r4);
    }
}
