package androidx.compose.material3;

import C7.r;
import S7.n;
import Y7.f;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.InputIdentifier;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ai\u0010\u0010\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u001c\u0010\u0005\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"", "selectedStartDateMillis", "selectedEndDateMillis", "Lkotlin/Function2;", "LC7/r;", "onDatesSelectionChange", "Landroidx/compose/material3/internal/CalendarModel;", "calendarModel", "LY7/f;", "yearRange", "Landroidx/compose/material3/DatePickerFormatter;", "dateFormatter", "Landroidx/compose/material3/SelectableDates;", "selectableDates", "Landroidx/compose/material3/DatePickerColors;", "colors", "DateRangeInputContent", "(Ljava/lang/Long;Ljava/lang/Long;LS7/n;Landroidx/compose/material3/internal/CalendarModel;LY7/f;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/unit/Dp;", "TextFieldSpacing", "F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateRangeInputKt {
    private static final float TextFieldSpacing = Dp.m6844constructorimpl(8);

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DateRangeInputContent(final Long l, final Long l5, final n nVar, final CalendarModel calendarModel, final f fVar, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i6;
        f fVar2;
        SelectableDates selectableDates2;
        DateInputFormat dateInputFormat;
        Composer composerStartRestartGroup = composer.startRestartGroup(-607499086);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(l5) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(calendarModel) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            fVar2 = fVar;
            i6 |= composerStartRestartGroup.changedInstance(fVar2) ? 16384 : 8192;
        } else {
            fVar2 = fVar;
        }
        if ((196608 & i) == 0) {
            i6 |= (i & 262144) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            selectableDates2 = selectableDates;
            i6 |= composerStartRestartGroup.changed(selectableDates2) ? 1048576 : 524288;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i & 12582912) == 0) {
            i6 |= composerStartRestartGroup.changed(datePickerColors) ? 8388608 : 4194304;
        }
        if ((i6 & 4793491) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-607499086, i6, -1, "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:43)");
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
            String strM2752getString2EP1pXo4 = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_range_input_invalid_range_input), composerStartRestartGroup, 0);
            boolean zChanged2 = ((i6 & 458752) == 131072 || ((i6 & 262144) != 0 && composerStartRestartGroup.changed(datePickerFormatter))) | composerStartRestartGroup.changed(dateInputFormat2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                dateInputFormat = dateInputFormat2;
                objRememberedValue2 = new DateInputValidator(fVar2, selectableDates2, dateInputFormat, datePickerFormatter, strM2752getString2EP1pXo, strM2752getString2EP1pXo2, strM2752getString2EP1pXo3, strM2752getString2EP1pXo4, null, null, 768, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                dateInputFormat = dateInputFormat2;
            }
            DateInputValidator dateInputValidator = (DateInputValidator) objRememberedValue2;
            dateInputValidator.setCurrentStartDateMillis$material3_release(l);
            dateInputValidator.setCurrentEndDateMillis$material3_release(l5);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierPadding = PaddingKt.padding(companion2, DateInputKt.getInputTextFieldPadding());
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m580spacedBy0680j_4(TextFieldSpacing), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            S7.a constructor = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl, measurePolicyRowMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            final String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            k.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            final String strM2752getString2EP1pXo5 = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_range_picker_start_headline), composerStartRestartGroup, 0);
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, companion2, 0.5f, false, 2, null);
            InputIdentifier.Companion companion4 = InputIdentifier.INSTANCE;
            int iM1935getStartDateInputJ2x2o4M = companion4.m1935getStartDateInputJ2x2o4M();
            int i10 = i6 & 896;
            int i11 = i6 & 112;
            boolean z10 = (i11 == 32) | (i10 == 256);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new S7.k() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Long) obj);
                        return r.f317a;
                    }

                    public final void invoke(Long l9) {
                        nVar.invoke(l9, l5);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            int i12 = i6 & 7168;
            int i13 = (i6 >> 21) & 14;
            int i14 = i6;
            DateInputFormat dateInputFormat3 = dateInputFormat;
            DateInputKt.m1738DateInputTextFieldtQNruF0(modifierWeight$default, l, (S7.k) objRememberedValue3, calendarModel, ComposableLambdaKt.rememberComposableLambda(801434508, true, new n() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$2
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
                public final void invoke(Composer composer2, int i15) {
                    if ((i15 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(801434508, i15, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:80)");
                    }
                    String str = strM2752getString2EP1pXo5;
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    boolean zChanged3 = composer2.changed(str) | composer2.changed(upperCase);
                    final String str2 = strM2752getString2EP1pXo5;
                    final String str3 = upperCase;
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new S7.k() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$2$1$1
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
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    TextKt.m2464Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion5, false, (S7.k) objRememberedValue4, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (S7.k) null, (TextStyle) null, composer2, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(665407211, true, new n() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$3
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
                public final void invoke(Composer composer2, int i15) {
                    if ((i15 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(665407211, i15, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:86)");
                    }
                    TextKt.m2464Text4IGK_g(upperCase, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new S7.k() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$3.1
                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return r.f317a;
                        }
                    }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (S7.k) null, (TextStyle) null, composer2, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), iM1935getStartDateInputJ2x2o4M, dateInputValidator, dateInputFormat3, localeDefaultLocale, datePickerColors, composerStartRestartGroup, ((i6 << 3) & 112) | 1794048 | i12, i13);
            final String strM2752getString2EP1pXo6 = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_range_picker_end_headline), composerStartRestartGroup, 0);
            Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance, companion2, 0.5f, false, 2, null);
            int iM1933getEndDateInputJ2x2o4M = companion4.m1933getEndDateInputJ2x2o4M();
            boolean z11 = (i10 == 256) | ((i14 & 14) == 4);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new S7.k() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Long) obj);
                        return r.f317a;
                    }

                    public final void invoke(Long l9) {
                        nVar.invoke(l, l9);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            DateInputKt.m1738DateInputTextFieldtQNruF0(modifierWeight$default2, l5, (S7.k) objRememberedValue4, calendarModel, ComposableLambdaKt.rememberComposableLambda(911487285, true, new n() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$5
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
                public final void invoke(Composer composer2, int i15) {
                    if ((i15 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(911487285, i15, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:103)");
                    }
                    String str = strM2752getString2EP1pXo6;
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    boolean zChanged3 = composer2.changed(str) | composer2.changed(upperCase);
                    final String str2 = strM2752getString2EP1pXo6;
                    final String str3 = upperCase;
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new S7.k() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$5$1$1
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
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    TextKt.m2464Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion5, false, (S7.k) objRememberedValue5, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (S7.k) null, (TextStyle) null, composer2, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-961726252, true, new n() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$6
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
                public final void invoke(Composer composer2, int i15) {
                    if ((i15 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-961726252, i15, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:108)");
                    }
                    TextKt.m2464Text4IGK_g(upperCase, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new S7.k() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$6.1
                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return r.f317a;
                        }
                    }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (S7.k) null, (TextStyle) null, composer2, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), iM1933getEndDateInputJ2x2o4M, dateInputValidator, dateInputFormat3, localeDefaultLocale, datePickerColors, composerStartRestartGroup, i11 | 1794048 | i12, i13);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DateRangeInputKt.DateRangeInputContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i15) {
                    DateRangeInputKt.DateRangeInputContent(l, l5, nVar, calendarModel, fVar, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
