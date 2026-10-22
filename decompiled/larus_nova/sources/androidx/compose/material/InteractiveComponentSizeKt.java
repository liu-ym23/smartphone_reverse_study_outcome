package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\"\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b\"\u0010\u0010\u0000\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u000e"}, d2 = {"minimumInteractiveComponentSize", "Landroidx/compose/ui/Modifier;", "LocalMinimumInteractiveComponentEnforcement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalMinimumInteractiveComponentEnforcement$annotations", "()V", "getLocalMinimumInteractiveComponentEnforcement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalMinimumTouchTargetEnforcement", "getLocalMinimumTouchTargetEnforcement$annotations", "getLocalMinimumTouchTargetEnforcement", "Landroidx/compose/ui/unit/DpSize;", "J", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InteractiveComponentSizeKt {
    private static final ProvidableCompositionLocal<Boolean> LocalMinimumInteractiveComponentEnforcement = null;
    private static final ProvidableCompositionLocal<Boolean> LocalMinimumTouchTargetEnforcement = null;
    private static final long minimumInteractiveComponentSize = 0;

    private static final boolean LocalMinimumInteractiveComponentEnforcement$lambda$0() {
        return true;
    }

    public static /* synthetic */ boolean a() {
        return LocalMinimumInteractiveComponentEnforcement$lambda$0();
    }

    public static /* synthetic */ void getLocalMinimumInteractiveComponentEnforcement$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use LocalMinimumInteractiveComponentEnforcement instead.", replaceWith = @ReplaceWith(expression = "LocalMinimumInteractiveComponentEnforcement", imports = {}))
    public static /* synthetic */ void getLocalMinimumTouchTargetEnforcement$annotations() {
    }

    static {
        ProvidableCompositionLocal<Boolean> r100 = CompositionLocalKt.staticCompositionLocalOf(new q5());
        LocalMinimumInteractiveComponentEnforcement = r100;
        LocalMinimumTouchTargetEnforcement = r100;
        float r101 = 48;
        minimumInteractiveComponentSize = DpKt.m7566DpSizeYgX7TsA(Dp.m7544constructorimpl(r101), Dp.m7544constructorimpl(r101));
    }

    public static final /* synthetic */ long access$getMinimumInteractiveComponentSize$p() {
        return minimumInteractiveComponentSize;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalMinimumInteractiveComponentEnforcement() {
        return LocalMinimumInteractiveComponentEnforcement;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalMinimumTouchTargetEnforcement() {
        return LocalMinimumTouchTargetEnforcement;
    }

    public static final Modifier minimumInteractiveComponentSize(Modifier r100) {
        return r100.then(MinimumInteractiveModifier.INSTANCE);
    }
}
