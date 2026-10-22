package com.obric.oui.sheet.v2;

import android.content.Context;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OSheetBase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"SHEET_LANDSCAPE_MAX_CONTENT_HEIGHT", "", "SHEET_LANDSCAPE_MAX_WIDTH", "getSheetMaxWidth", "context", "Landroid/content/Context;", "expected", "getTargetDimAmount", "", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OSheetBaseKt {
    public static final int SHEET_LANDSCAPE_MAX_CONTENT_HEIGHT = 244;
    public static final int SHEET_LANDSCAPE_MAX_WIDTH = 480;

    public static final int getSheetMaxWidth(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (ResourceUtils.INSTANCE.isLandscape(r1) == true) goto L5;
        return r2;
    L5:
        return RangesKt.coerceAtMost(r2, OUnitExtensionKt.cdp(r1, SHEET_LANDSCAPE_MAX_WIDTH));
    }

    public static final float getTargetDimAmount(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if ((r1.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return 0.5f;
    L8:
        return 0.16f;
    L5:
        r2 = false;
        goto L6
    }
}
