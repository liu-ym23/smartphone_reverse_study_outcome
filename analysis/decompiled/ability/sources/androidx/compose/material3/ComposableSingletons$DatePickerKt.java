package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeftKt;
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRightKt;
import androidx.compose.material.icons.filled.DateRangeKt;
import androidx.compose.material.icons.filled.EditKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposableSingletons$DatePickerKt {
    public static final ComposableSingletons$DatePickerKt INSTANCE = new ComposableSingletons$DatePickerKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static n f26lambda1 = ComposableLambdaKt.composableLambdaInstance(1244569435, false, new n() { // from class: androidx.compose.material3.ComposableSingletons$DatePickerKt$lambda-1$1
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
                ComposerKt.traceEventStart(1244569435, i, -1, "androidx.compose.material3.ComposableSingletons$DatePickerKt.lambda-1.<anonymous> (DatePicker.kt:1358)");
            }
            ImageVector edit = EditKt.getEdit(Icons.Filled.INSTANCE);
            Strings.Companion companion = Strings.INSTANCE;
            IconKt.m1909Iconww6aTOc(edit, Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_picker_switch_to_input_mode), composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static n f27lambda2 = ComposableLambdaKt.composableLambdaInstance(668820324, false, new n() { // from class: androidx.compose.material3.ComposableSingletons$DatePickerKt$lambda-2$1
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
                ComposerKt.traceEventStart(668820324, i, -1, "androidx.compose.material3.ComposableSingletons$DatePickerKt.lambda-2.<anonymous> (DatePicker.kt:1365)");
            }
            ImageVector dateRange = DateRangeKt.getDateRange(Icons.Filled.INSTANCE);
            Strings.Companion companion = Strings.INSTANCE;
            IconKt.m1909Iconww6aTOc(dateRange, Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_picker_switch_to_calendar_mode), composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static n f28lambda3 = ComposableLambdaKt.composableLambdaInstance(1233169686, false, new n() { // from class: androidx.compose.material3.ComposableSingletons$DatePickerKt$lambda-3$1
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
                ComposerKt.traceEventStart(1233169686, i, -1, "androidx.compose.material3.ComposableSingletons$DatePickerKt.lambda-3.<anonymous> (DatePicker.kt:2163)");
            }
            ImageVector keyboardArrowLeft = KeyboardArrowLeftKt.getKeyboardArrowLeft(Icons.AutoMirrored.Filled.INSTANCE);
            Strings.Companion companion = Strings.INSTANCE;
            IconKt.m1909Iconww6aTOc(keyboardArrowLeft, Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_picker_switch_to_previous_month), composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    public static n f29lambda4 = ComposableLambdaKt.composableLambdaInstance(412350847, false, new n() { // from class: androidx.compose.material3.ComposableSingletons$DatePickerKt$lambda-4$1
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
                ComposerKt.traceEventStart(412350847, i, -1, "androidx.compose.material3.ComposableSingletons$DatePickerKt.lambda-4.<anonymous> (DatePicker.kt:2169)");
            }
            ImageVector keyboardArrowRight = KeyboardArrowRightKt.getKeyboardArrowRight(Icons.AutoMirrored.Filled.INSTANCE);
            Strings.Companion companion = Strings.INSTANCE;
            IconKt.m1909Iconww6aTOc(keyboardArrowRight, Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_picker_switch_to_next_month), composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$material3_release, reason: not valid java name */
    public final n m1706getLambda1$material3_release() {
        return f26lambda1;
    }

    /* renamed from: getLambda-2$material3_release, reason: not valid java name */
    public final n m1707getLambda2$material3_release() {
        return f27lambda2;
    }

    /* renamed from: getLambda-3$material3_release, reason: not valid java name */
    public final n m1708getLambda3$material3_release() {
        return f28lambda3;
    }

    /* renamed from: getLambda-4$material3_release, reason: not valid java name */
    public final n m1709getLambda4$material3_release() {
        return f29lambda4;
    }
}
