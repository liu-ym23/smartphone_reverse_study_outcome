package androidx.compose.foundation.text.handwriting;

import S7.a;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/Modifier;", "Lkotlin/Function0;", "LC7/r;", "callback", "handwritingDetector", "(Landroidx/compose/ui/Modifier;LS7/a;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HandwritingDetector_androidKt {
    public static final Modifier handwritingDetector(Modifier modifier, a aVar) {
        return StylusHandwriting_androidKt.isStylusHandwritingSupported() ? PaddingKt.m701paddingVpY3zN4(modifier.then(new HandwritingDetectorElement(aVar)), StylusHandwritingKt.getHandwritingBoundsHorizontalOffset(), StylusHandwritingKt.getHandwritingBoundsVerticalOffset()) : modifier;
    }
}
