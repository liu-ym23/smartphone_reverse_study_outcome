package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposableSingletons$SegmentedButtonKt {
    public static final ComposableSingletons$SegmentedButtonKt INSTANCE = new ComposableSingletons$SegmentedButtonKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static n f45lambda1 = ComposableLambdaKt.composableLambdaInstance(-860995255, false, new n() { // from class: androidx.compose.material3.ComposableSingletons$SegmentedButtonKt$lambda-1$1
        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return r.f317a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-860995255, i, -1, "androidx.compose.material3.ComposableSingletons$SegmentedButtonKt.lambda-1.<anonymous> (SegmentedButton.kt:564)");
            }
            SegmentedButtonDefaults.INSTANCE.ActiveIcon(composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$material3_release, reason: not valid java name */
    public final n m1725getLambda1$material3_release() {
        return f45lambda1;
    }
}
