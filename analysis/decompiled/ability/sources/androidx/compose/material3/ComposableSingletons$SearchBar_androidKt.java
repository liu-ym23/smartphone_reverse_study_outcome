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
public final class ComposableSingletons$SearchBar_androidKt {
    public static final ComposableSingletons$SearchBar_androidKt INSTANCE = new ComposableSingletons$SearchBar_androidKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static n f43lambda1 = ComposableLambdaKt.composableLambdaInstance(159817819, false, new n() { // from class: androidx.compose.material3.ComposableSingletons$SearchBar_androidKt$lambda-1$1
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
                ComposerKt.traceEventStart(159817819, i, -1, "androidx.compose.material3.ComposableSingletons$SearchBar_androidKt.lambda-1.<anonymous> (SearchBar.android.kt:560)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static n f44lambda2 = ComposableLambdaKt.composableLambdaInstance(-480309201, false, new n() { // from class: androidx.compose.material3.ComposableSingletons$SearchBar_androidKt$lambda-2$1
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
                ComposerKt.traceEventStart(-480309201, i, -1, "androidx.compose.material3.ComposableSingletons$SearchBar_androidKt.lambda-2.<anonymous> (SearchBar.android.kt:899)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$material3_release, reason: not valid java name */
    public final n m1723getLambda1$material3_release() {
        return f43lambda1;
    }

    /* renamed from: getLambda-2$material3_release, reason: not valid java name */
    public final n m1724getLambda2$material3_release() {
        return f44lambda2;
    }
}
