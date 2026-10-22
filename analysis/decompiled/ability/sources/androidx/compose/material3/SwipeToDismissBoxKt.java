package androidx.compose.material3;

import S7.k;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001aq\u0010\u0015\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0002¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0002¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxValue;", "initialValue", "Lkotlin/Function1;", "", "confirmValueChange", "", "positionalThreshold", "Landroidx/compose/material3/SwipeToDismissBoxState;", "rememberSwipeToDismissBoxState", "(Landroidx/compose/material3/SwipeToDismissBoxValue;LS7/k;LS7/k;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "state", "Landroidx/compose/foundation/layout/RowScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "backgroundContent", "Landroidx/compose/ui/Modifier;", "modifier", "enableDismissFromStartToEnd", "enableDismissFromEndToStart", "gesturesEnabled", "content", "SwipeToDismissBox", "(Landroidx/compose/material3/SwipeToDismissBoxState;LS7/o;Landroidx/compose/ui/Modifier;ZZZLS7/o;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/unit/Dp;", "DismissVelocityThreshold", "F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwipeToDismissBoxKt {
    private static final float DismissVelocityThreshold = Dp.m6844constructorimpl(125);

    /* JADX WARN: Removed duplicated region for block: B:105:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0110  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SwipeToDismissBox(final androidx.compose.material3.SwipeToDismissBoxState r27, final S7.o r28, androidx.compose.ui.Modifier r29, boolean r30, boolean r31, boolean r32, S7.o r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 753
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeToDismissBoxKt.SwipeToDismissBox(androidx.compose.material3.SwipeToDismissBoxState, S7.o, androidx.compose.ui.Modifier, boolean, boolean, boolean, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(final SwipeToDismissBoxValue swipeToDismissBoxValue, final k kVar, final k kVar2, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            swipeToDismissBoxValue = SwipeToDismissBoxValue.Settled;
        }
        if ((i6 & 2) != 0) {
            kVar = new k() { // from class: androidx.compose.material3.SwipeToDismissBoxKt.rememberSwipeToDismissBoxState.1
                @Override // S7.k
                public final Boolean invoke(SwipeToDismissBoxValue swipeToDismissBoxValue2) {
                    return Boolean.TRUE;
                }
            };
        }
        if ((i6 & 4) != 0) {
            kVar2 = SwipeToDismissBoxDefaults.INSTANCE.getPositionalThreshold(composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-246335487, i, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:186)");
        }
        final Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Object[] objArr = new Object[0];
        Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> Saver = SwipeToDismissBoxState.INSTANCE.Saver(kVar, kVar2, density);
        boolean zChanged = (((6 ^ (i & 14)) > 4 && composer.changed(swipeToDismissBoxValue)) || (i & 6) == 4) | composer.changed(density) | ((((i & 112) ^ 48) > 32 && composer.changed(kVar)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(kVar2)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new S7.a() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final SwipeToDismissBoxState invoke() {
                    return new SwipeToDismissBoxState(swipeToDismissBoxValue, density, kVar, kVar2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        SwipeToDismissBoxState swipeToDismissBoxState = (SwipeToDismissBoxState) RememberSaveableKt.m3591rememberSaveable(objArr, (Saver) Saver, (String) null, (S7.a) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return swipeToDismissBoxState;
    }
}
