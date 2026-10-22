package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.ULong;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"toColorLong", "", "Landroidx/compose/ui/graphics/Color;", "toColorLong-8_81llA", "(J)J", "fromColorLong", "Landroidx/compose/ui/graphics/Color$Companion;", "colorLong", "(Landroidx/compose/ui/graphics/Color$Companion;J)J", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidColor_androidKt {
    /* JADX INFO: renamed from: toColorLong-8_81llA, reason: not valid java name */
    public static final long m4691toColorLong8_81llA(long r100) {
        long r101 = 63 & r100;
        if (Long.compare(ULong.m9623constructorimpl(r101) ^ Long.MIN_VALUE, -9223372036854775792L) >= 0) goto L6;
        return r100;
    L6:
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl(r100 & ULong.m9623constructorimpl(-64)) | ULong.m9623constructorimpl(ULong.m9623constructorimpl(r101) - 1));
    }

    public static final long fromColorLong(Color.Companion r100, long r101) {
        long r102 = 63 & r101;
        if (r102 < 16) goto L7;
        r101 = (r101 & (-64)) | (r102 + 1);
    L7:
        return Color.m4823constructorimpl(ULong.m9623constructorimpl(r101));
    }
}
