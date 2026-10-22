package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerIconKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"handwritingDetector", "Landroidx/compose/ui/Modifier;", "callback", "Lkotlin/Function0;", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HandwritingDetector_androidKt {
    public static final Modifier handwritingDetector(Modifier r100, Function0<Unit> r101) {
        if (StylusHandwriting_androidKt.isStylusHandwritingSupported() == true) goto L5;
        return r100;
    L5:
        return PointerIconKt.stylusHoverIcon(r100, TextPointerIcon_androidKt.getHandwritingPointerIcon(), false, StylusHandwritingKt.getHandwritingBoundsExpansion()).then(new HandwritingDetectorElement(r101));
    }
}
