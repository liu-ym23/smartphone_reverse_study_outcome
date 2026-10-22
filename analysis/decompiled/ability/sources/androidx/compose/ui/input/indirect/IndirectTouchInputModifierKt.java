package androidx.compose.ui.input.indirect;

import S7.k;
import androidx.compose.ui.ExperimentalIndirectTouchTypeApi;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/indirect/IndirectTouchEvent;", "", "onIndirectTouchEvent", "(Landroidx/compose/ui/Modifier;LS7/k;)Landroidx/compose/ui/Modifier;", "onPreIndirectTouchEvent", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IndirectTouchInputModifierKt {
    @ExperimentalIndirectTouchTypeApi
    public static final Modifier onIndirectTouchEvent(Modifier modifier, k kVar) {
        return modifier.then(new IndirectTouchInputElement(kVar, null));
    }

    @ExperimentalIndirectTouchTypeApi
    public static final Modifier onPreIndirectTouchEvent(Modifier modifier, k kVar) {
        return modifier.then(new IndirectTouchInputElement(null, kVar));
    }
}
