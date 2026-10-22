package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\u0002¢\u0006\u0004\b\u0003\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"times", "Landroidx/compose/ui/unit/TextUnit;", "other", "times-NB67dxo", "(JJ)J", "DefaultFontSize", "J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MultiParagraphLayoutCacheKt {
    private static final long DefaultFontSize = 0;

    static {
        DefaultFontSize = TextUnitKt.getSp(14);
    }

    /* JADX INFO: renamed from: access$times-NB67dxo, reason: not valid java name */
    public static final /* synthetic */ long m1420access$timesNB67dxo(long r100, long r101) {
        return m1421timesNB67dxo(r100, r101);
    }

    /* JADX INFO: renamed from: times-NB67dxo, reason: not valid java name */
    private static final long m1421timesNB67dxo(long r100, long r101) {
        if (TextUnit.m7744isEmimpl(r101) == false) goto L18;
        if (TextUnit.m7744isEmimpl(r100) == true) goto L16;
        if (TextUnit.m7740getRawTypeimpl(r100) != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        long r103 = DefaultFontSize;
        float r104 = TextUnit.m7742getValueimpl(r101);
        TextUnitKt.m7755checkArithmeticR2X_6o(r103);
        return TextUnitKt.pack(TextUnit.m7740getRawTypeimpl(r103), TextUnit.m7742getValueimpl(r103) * r104);
    L13:
        float r105 = TextUnit.m7742getValueimpl(r101);
        TextUnitKt.m7755checkArithmeticR2X_6o(r100);
        return TextUnitKt.pack(TextUnit.m7740getRawTypeimpl(r100), TextUnit.m7742getValueimpl(r100) * r105);
    L9:
        r102 = false;
        goto L10
    L16:
        throw new IllegalStateException("Cannot convert Em to Px when style.fontSize is Em (" + TextUnit.m7749toStringimpl(r101) + "). Please declare the style.fontSize with Sp units instead.");
    L18:
        throw new IllegalArgumentException("The multiplier must be in em, but was " + TextUnit.m7749toStringimpl(r101) + '.');
    }
}
