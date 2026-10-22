package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import Y7.f;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import j9.m;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000z\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aW\u0010\u000f\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0098\u0001\u0010#\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\n\u0010 \u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010\u000e\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\"\u001a\u0010%\u001a\u00020$8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006.²\u0006\u000e\u0010-\u001a\u00020,8\n@\nX\u008a\u008e\u0002"}, d2 = {"", "selectedDateMillis", "Lkotlin/Function1;", "LC7/r;", "onDateSelectionChange", "Landroidx/compose/material3/internal/CalendarModel;", "calendarModel", "LY7/f;", "yearRange", "Landroidx/compose/material3/DatePickerFormatter;", "dateFormatter", "Landroidx/compose/material3/SelectableDates;", "selectableDates", "Landroidx/compose/material3/DatePickerColors;", "colors", "DateInputContent", "(Ljava/lang/Long;LS7/k;Landroidx/compose/material3/internal/CalendarModel;LY7/f;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "initialDateMillis", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "label", "placeholder", "Landroidx/compose/material3/InputIdentifier;", "inputIdentifier", "Landroidx/compose/material3/DateInputValidator;", "dateInputValidator", "Landroidx/compose/material3/internal/DateInputFormat;", "dateInputFormat", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "locale", "DateInputTextField-tQNruF0", "(Landroidx/compose/ui/Modifier;Ljava/lang/Long;LS7/k;Landroidx/compose/material3/internal/CalendarModel;LS7/n;LS7/n;ILandroidx/compose/material3/DateInputValidator;Landroidx/compose/material3/internal/DateInputFormat;Ljava/util/Locale;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DateInputTextField", "Landroidx/compose/foundation/layout/PaddingValues;", "InputTextFieldPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getInputTextFieldPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "Landroidx/compose/ui/unit/Dp;", "InputTextNonErroneousBottomPadding", "F", "Landroidx/compose/ui/text/input/TextFieldValue;", "text", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateInputKt {
    private static final PaddingValues InputTextFieldPadding;
    private static final float InputTextNonErroneousBottomPadding = Dp.m6844constructorimpl(16);

    static {
        float f = 24;
        InputTextFieldPadding = PaddingKt.m697PaddingValuesa9UjIt4$default(Dp.m6844constructorimpl(f), Dp.m6844constructorimpl(10), Dp.m6844constructorimpl(f), 0.0f, 8, null);
    }

    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DateInputContent(final Long l, final k kVar, final CalendarModel calendarModel, final f fVar, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i6;
        Composer composer2;
        DateInputFormat dateInputFormat;
        int i10;
        ?? r02;
        Composer composer3;
        Composer composerStartRestartGroup = composer.startRestartGroup(643325609);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(kVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(calendarModel) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(fVar) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= (i & 32768) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(selectableDates) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(datePickerColors) ? 1048576 : 524288;
        }
        if ((599187 & i6) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer3 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(643325609, i6, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:60)");
            }
            Locale localeDefaultLocale = CalendarLocale_androidKt.defaultLocale(composerStartRestartGroup, 0);
            boolean zChanged = composerStartRestartGroup.changed(localeDefaultLocale);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = calendarModel.getDateInputFormat(localeDefaultLocale);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            DateInputFormat dateInputFormat2 = (DateInputFormat) objRememberedValue;
            Strings.Companion companion = Strings.INSTANCE;
            String strM2752getString2EP1pXo = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_input_invalid_for_pattern), composerStartRestartGroup, 0);
            String strM2752getString2EP1pXo2 = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_input_invalid_year_range), composerStartRestartGroup, 0);
            String strM2752getString2EP1pXo3 = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_input_invalid_not_allowed), composerStartRestartGroup, 0);
            boolean zChanged2 = composerStartRestartGroup.changed(dateInputFormat2) | ((i6 & 57344) == 16384 || ((i6 & 32768) != 0 && composerStartRestartGroup.changed(datePickerFormatter)));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                dateInputFormat = dateInputFormat2;
                i10 = i6;
                r02 = 1;
                DateInputValidator dateInputValidator = new DateInputValidator(fVar, selectableDates, dateInputFormat, datePickerFormatter, strM2752getString2EP1pXo, strM2752getString2EP1pXo2, strM2752getString2EP1pXo3, "", null, null, 768, null);
                composer2.updateRememberedValue(dateInputValidator);
                objRememberedValue2 = dateInputValidator;
            } else {
                composer2 = composerStartRestartGroup;
                i10 = i6;
                dateInputFormat = dateInputFormat2;
                r02 = 1;
            }
            DateInputValidator dateInputValidator2 = (DateInputValidator) objRememberedValue2;
            final String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.k.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            final String strM2752getString2EP1pXo4 = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_input_label), composer2, 0);
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, r02, null), InputTextFieldPadding);
            int iM1934getSingleDateInputJ2x2o4M = InputIdentifier.INSTANCE.m1934getSingleDateInputJ2x2o4M();
            dateInputValidator2.setCurrentStartDateMillis$material3_release(l);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1819015125, r02, new n() { // from class: androidx.compose.material3.DateInputKt.DateInputContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer4, int i11) {
                    if ((i11 & 3) == 2 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1819015125, i11, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:87)");
                    }
                    String str = strM2752getString2EP1pXo4;
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    boolean zChanged3 = composer4.changed(str) | composer4.changed(upperCase);
                    final String str2 = strM2752getString2EP1pXo4;
                    final String str3 = upperCase;
                    Object objRememberedValue3 = composer4.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new k() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return r.f317a;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str2 + ", " + str3);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue3);
                    }
                    TextKt.m2464Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion2, false, (k) objRememberedValue3, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (k) null, (TextStyle) null, composer4, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-564233108, r02, new n() { // from class: androidx.compose.material3.DateInputKt.DateInputContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer4, int i11) {
                    if ((i11 & 3) == 2 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-564233108, i11, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:92)");
                    }
                    TextKt.m2464Text4IGK_g(upperCase, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new k() { // from class: androidx.compose.material3.DateInputKt.DateInputContent.3.1
                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return r.f317a;
                        }
                    }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (k) null, (TextStyle) null, composer4, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54);
            int i11 = i10 << 3;
            Composer composer4 = composer2;
            m1738DateInputTextFieldtQNruF0(modifierPadding, l, kVar, calendarModel, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, iM1934getSingleDateInputJ2x2o4M, dateInputValidator2, dateInputFormat, localeDefaultLocale, datePickerColors, composer4, (i11 & 112) | 1794054 | (i11 & 896) | (i11 & 7168), (i10 >> 18) & 14);
            composer3 = composer4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DateInputKt.DateInputContent.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer5, int i12) {
                    DateInputKt.DateInputContent(l, kVar, calendarModel, fVar, datePickerFormatter, selectableDates, datePickerColors, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: DateInputTextField-tQNruF0, reason: not valid java name */
    public static final void m1738DateInputTextFieldtQNruF0(final Modifier modifier, final Long l, final k kVar, final CalendarModel calendarModel, final n nVar, final n nVar2, final int i, final DateInputValidator dateInputValidator, DateInputFormat dateInputFormat, final Locale locale, final DatePickerColors datePickerColors, Composer composer, final int i6, final int i10) {
        int i11;
        k kVar2;
        int i12;
        final MutableState mutableState;
        int i13;
        Composer composer2;
        final DateInputFormat dateInputFormat2 = dateInputFormat;
        Composer composerStartRestartGroup = composer.startRestartGroup(-857008589);
        if ((i6 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i11 = i6;
        }
        if ((i6 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(l) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            kVar2 = kVar;
            i11 |= composerStartRestartGroup.changedInstance(kVar2) ? 256 : 128;
        } else {
            kVar2 = kVar;
        }
        if ((i6 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(calendarModel) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(nVar) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(nVar2) ? 131072 : 65536;
        }
        if ((i6 & 1572864) == 0) {
            i11 |= composerStartRestartGroup.changed(i) ? 1048576 : 524288;
        }
        if ((i6 & 12582912) == 0) {
            i11 |= composerStartRestartGroup.changed(dateInputValidator) ? 8388608 : 4194304;
        }
        if ((i6 & 100663296) == 0) {
            i11 |= composerStartRestartGroup.changed(dateInputFormat2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i6 & 805306368) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(locale) ? 536870912 : 268435456;
        }
        if ((i10 & 6) == 0) {
            i12 = i10 | (composerStartRestartGroup.changed(datePickerColors) ? 4 : 2);
        } else {
            i12 = i10;
        }
        if ((i11 & 306783379) == 306783378 && (i12 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-857008589, i11, i12, "androidx.compose.material3.DateInputTextField (DateInput.kt:121)");
            }
            MutableState mutableState2 = (MutableState) RememberSaveableKt.m3591rememberSaveable(new Object[0], (Saver) null, (String) null, (S7.a) new S7.a() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$errorText$1
                @Override // S7.a
                public final MutableState<String> invoke() {
                    return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                }
            }, composerStartRestartGroup, 3072, 6);
            Object[] objArr = new Object[0];
            Saver<TextFieldValue, Object> saver = TextFieldValue.INSTANCE.getSaver();
            boolean zChangedInstance = ((i11 & 112) == 32) | composerStartRestartGroup.changedInstance(calendarModel);
            int i14 = 234881024 & i11;
            boolean zChangedInstance2 = zChangedInstance | (i14 == 67108864) | composerStartRestartGroup.changedInstance(locale);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new S7.a() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$text$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
                    @Override // S7.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> invoke() {
                        /*
                            r7 = this;
                            java.lang.Long r0 = r1
                            if (r0 == 0) goto L1b
                            androidx.compose.material3.internal.CalendarModel r1 = r2
                            androidx.compose.material3.internal.DateInputFormat r2 = r3
                            java.util.Locale r7 = r4
                            long r3 = r0.longValue()
                            java.lang.String r0 = r2.getPatternWithoutDelimiters()
                            java.lang.String r7 = r1.formatWithPattern(r3, r0, r7)
                            if (r7 != 0) goto L19
                            goto L1b
                        L19:
                            r1 = r7
                            goto L1e
                        L1b:
                            java.lang.String r7 = ""
                            goto L19
                        L1e:
                            r7 = 0
                            long r2 = androidx.compose.ui.text.TextRangeKt.TextRange(r7, r7)
                            androidx.compose.ui.text.input.TextFieldValue r0 = new androidx.compose.ui.text.input.TextFieldValue
                            r4 = 0
                            r5 = 4
                            r6 = 0
                            r0.<init>(r1, r2, r4, r5, r6)
                            r7 = 2
                            r1 = 0
                            androidx.compose.runtime.MutableState r7 = androidx.compose.runtime.SnapshotStateKt.mutableStateOf$default(r0, r1, r7, r1)
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputKt$DateInputTextField$text$2$1.invoke():androidx.compose.runtime.MutableState");
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableStateRememberSaveable = RememberSaveableKt.rememberSaveable(objArr, (Saver) saver, (String) null, (S7.a) objRememberedValue, composerStartRestartGroup, 0, 4);
            TextFieldValue textFieldValueDateInputTextField_tQNruF0$lambda$4 = DateInputTextField_tQNruF0$lambda$4(mutableStateRememberSaveable);
            boolean zChanged = (i14 == 67108864) | composerStartRestartGroup.changed(mutableStateRememberSaveable) | composerStartRestartGroup.changed(mutableState2) | ((i11 & 896) == 256) | composerStartRestartGroup.changedInstance(calendarModel) | ((29360128 & i11) == 8388608) | ((3670016 & i11) == 1048576) | composerStartRestartGroup.changedInstance(locale);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState2;
                i13 = i11;
                final k kVar3 = kVar2;
                k kVar4 = new k() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((TextFieldValue) obj);
                        return r.f317a;
                    }

                    public final void invoke(TextFieldValue textFieldValue) {
                        if (textFieldValue.getText().length() <= dateInputFormat2.getPatternWithoutDelimiters().length()) {
                            String text = textFieldValue.getText();
                            for (int i15 = 0; i15 < text.length(); i15++) {
                                if (!Character.isDigit(text.charAt(i15))) {
                                    return;
                                }
                            }
                            mutableStateRememberSaveable.setValue(textFieldValue);
                            String string = m.R0(textFieldValue.getText()).toString();
                            Long lValueOf = null;
                            if (string.length() == 0 || string.length() < dateInputFormat2.getPatternWithoutDelimiters().length()) {
                                mutableState.setValue("");
                                kVar3.invoke(null);
                                return;
                            }
                            CalendarDate calendarDate = calendarModel.parse(string, dateInputFormat2.getPatternWithoutDelimiters());
                            mutableState.setValue(dateInputValidator.m1739validateXivgLIo(calendarDate, i, locale));
                            k kVar5 = kVar3;
                            if (mutableState.getValue().length() == 0 && calendarDate != null) {
                                lValueOf = Long.valueOf(calendarDate.getUtcTimeMillis());
                            }
                            kVar5.invoke(lValueOf);
                        }
                    }
                };
                dateInputFormat2 = dateInputFormat2;
                composerStartRestartGroup.updateRememberedValue(kVar4);
                objRememberedValue2 = kVar4;
            } else {
                mutableState = mutableState2;
                i13 = i11;
            }
            k kVar5 = (k) objRememberedValue2;
            Modifier modifierM704paddingqDBjuR0$default = PaddingKt.m704paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, !m.s0((CharSequence) mutableState.getValue()) ? Dp.m6844constructorimpl(0) : InputTextNonErroneousBottomPadding, 7, null);
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new k() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return r.f317a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        if (m.s0(mutableState.getValue())) {
                            return;
                        }
                        SemanticsPropertiesKt.error(semanticsPropertyReceiver, mutableState.getValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            OutlinedTextFieldKt.OutlinedTextField(textFieldValueDateInputTextField_tQNruF0$lambda$4, kVar5, SemanticsModifierKt.semantics$default(modifierM704paddingqDBjuR0$default, false, (k) objRememberedValue3, 1, null), false, false, (TextStyle) null, nVar, nVar2, (n) null, (n) null, (n) null, (n) null, (n) ComposableLambdaKt.rememberComposableLambda(-591991974, true, new n() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer3, int i15) {
                    if ((i15 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-591991974, i15, -1, "androidx.compose.material3.DateInputTextField.<anonymous> (DateInput.kt:191)");
                    }
                    if (!m.s0(mutableState.getValue())) {
                        TextKt.m2464Text4IGK_g(mutableState.getValue(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (k) null, (TextStyle) null, composer3, 0, 0, 131070);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), !m.s0((CharSequence) mutableState.getValue()), (VisualTransformation) new DateVisualTransformation(dateInputFormat2), new KeyboardOptions(0, Boolean.FALSE, KeyboardType.INSTANCE.m6547getNumberPjHm6EE(), ImeAction.INSTANCE.m6491getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 113, (e) null), (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, datePickerColors.getDateTextFieldColors(), composerStartRestartGroup, (i13 << 6) & 33030144, 12779904, 0, 4001592);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i15) {
                    DateInputKt.m1738DateInputTextFieldtQNruF0(modifier, l, kVar, calendarModel, nVar, nVar2, i, dateInputValidator, dateInputFormat2, locale, datePickerColors, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i10));
                }
            });
        }
    }

    private static final TextFieldValue DateInputTextField_tQNruF0$lambda$4(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return InputTextFieldPadding;
    }
}
