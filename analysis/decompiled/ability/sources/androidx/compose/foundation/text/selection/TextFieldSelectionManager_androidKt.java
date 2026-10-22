package androidx.compose.foundation.text.selection;

import C7.r;
import S7.k;
import S7.o;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0018\u0010\u000e\u001a\u00020\r*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012²\u0006\u000e\u0010\u0011\u001a\u00020\u00108\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "manager", "textFieldMagnifier", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "contextMenuState", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "LC7/r;", "contextMenuBuilder", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/foundation/contextmenu/ContextMenuState;)LS7/k;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "", "isShiftPressed", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "Landroidx/compose/ui/unit/IntSize;", "magnifierSize", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager_androidKt {

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1, reason: invalid class name and case insensitive filesystem */
    public static final class C05391 extends Lambda implements o {
        final /* synthetic */ TextFieldSelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05391(TextFieldSelectionManager textFieldSelectionManager) {
            super(3);
            this.$manager = textFieldSelectionManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long invoke$lambda$1(MutableState<IntSize> mutableState) {
            return mutableState.getValue().m7019unboximpl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(MutableState<IntSize> mutableState, long j5) {
            mutableState.setValue(IntSize.m7007boximpl(j5));
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            composer.startReplaceGroup(1980580247);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1980580247, i, -1, "androidx.compose.foundation.text.selection.textFieldMagnifier.<anonymous> (TextFieldSelectionManager.android.kt:48)");
            }
            final Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m7007boximpl(IntSize.INSTANCE.m7020getZeroYbymL2g()), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            boolean zChangedInstance = composer.changedInstance(this.$manager);
            final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new S7.a() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        return Offset.m3884boximpl(m1468invokeF1C5BW0());
                    }

                    /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                    public final long m1468invokeF1C5BW0() {
                        return TextFieldSelectionManagerKt.m1463calculateSelectionMagnifierCenterAndroidO0kMr_c(textFieldSelectionManager, TextFieldSelectionManager_androidKt.C05391.invoke$lambda$1(mutableState));
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            S7.a aVar = (S7.a) objRememberedValue2;
            boolean zChanged = composer.changed(density);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new k() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public final Modifier invoke(final S7.a aVar2) {
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        k kVar = new k() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1.1
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return Offset.m3884boximpl(m1469invoketuRUvjQ((Density) obj));
                            }

                            /* renamed from: invoke-tuRUvjQ, reason: not valid java name */
                            public final long m1469invoketuRUvjQ(Density density2) {
                                return ((Offset) aVar2.invoke()).m3905unboximpl();
                            }
                        };
                        final Density density2 = density;
                        final MutableState<IntSize> mutableState2 = mutableState;
                        return Magnifier_androidKt.m313magnifierjPUL71Q$default(companion2, kVar, null, new k() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                m1470invokeEaSLcWc(((DpSize) obj).getPackedValue());
                                return r.f317a;
                            }

                            /* renamed from: invoke-EaSLcWc, reason: not valid java name */
                            public final void m1470invokeEaSLcWc(long j5) {
                                MutableState<IntSize> mutableState3 = mutableState2;
                                Density density3 = density2;
                                TextFieldSelectionManager_androidKt.C05391.invoke$lambda$2(mutableState3, IntSizeKt.IntSize(density3.mo375roundToPx0680j_4(DpSize.m6942getWidthD9Ej5fM(j5)), density3.mo375roundToPx0680j_4(DpSize.m6940getHeightD9Ej5fM(j5))));
                            }
                        }, 0.0f, true, 0L, 0.0f, 0.0f, false, PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform(), 490, null);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierAnimatedSelectionMagnifier = SelectionMagnifierKt.animatedSelectionMagnifier(modifier, aVar, (k) objRememberedValue3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifierAnimatedSelectionMagnifier;
        }
    }

    public static final k contextMenuBuilder(final TextFieldSelectionManager textFieldSelectionManager, final ContextMenuState contextMenuState) {
        return new k() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.contextMenuBuilder.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContextMenuScope) obj);
                return r.f317a;
            }

            public final void invoke(ContextMenuScope contextMenuScope) {
                ClipboardManager clipboardManager;
                boolean z10 = textFieldSelectionManager.getVisualTransformation() instanceof PasswordVisualTransformation;
                boolean zM6305getCollapsedimpl = TextRange.m6305getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().getSelection());
                final ContextMenuState contextMenuState2 = contextMenuState;
                TextContextMenuItems textContextMenuItems = TextContextMenuItems.Cut;
                boolean z11 = (zM6305getCollapsedimpl || !textFieldSelectionManager.getEditable() || z10) ? false : true;
                final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt.AnonymousClass1(textContextMenuItems), null, z11, null, new S7.a() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1464invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1464invoke() {
                        textFieldSelectionManager2.cut$foundation_release();
                        ContextMenuState_androidKt.close(contextMenuState2);
                    }
                }, 10, null);
                final ContextMenuState contextMenuState3 = contextMenuState;
                TextContextMenuItems textContextMenuItems2 = TextContextMenuItems.Copy;
                boolean z12 = (zM6305getCollapsedimpl || z10) ? false : true;
                final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager;
                ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt.AnonymousClass1(textContextMenuItems2), null, z12, null, new S7.a() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1465invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1465invoke() {
                        textFieldSelectionManager3.copy$foundation_release(false);
                        ContextMenuState_androidKt.close(contextMenuState3);
                    }
                }, 10, null);
                final ContextMenuState contextMenuState4 = contextMenuState;
                TextContextMenuItems textContextMenuItems3 = TextContextMenuItems.Paste;
                boolean z13 = textFieldSelectionManager.getEditable() && (clipboardManager = textFieldSelectionManager.getClipboardManager()) != null && clipboardManager.hasText();
                final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager;
                ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt.AnonymousClass1(textContextMenuItems3), null, z13, null, new S7.a() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1466invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1466invoke() {
                        textFieldSelectionManager4.paste$foundation_release();
                        ContextMenuState_androidKt.close(contextMenuState4);
                    }
                }, 10, null);
                final ContextMenuState contextMenuState5 = contextMenuState;
                TextContextMenuItems textContextMenuItems4 = TextContextMenuItems.SelectAll;
                boolean z14 = TextRange.m6307getLengthimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()) != textFieldSelectionManager.getValue$foundation_release().getText().length();
                final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager;
                ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt.AnonymousClass1(textContextMenuItems4), null, z14, null, new S7.a() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1467invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1467invoke() {
                        textFieldSelectionManager5.selectAll$foundation_release();
                        ContextMenuState_androidKt.close(contextMenuState5);
                    }
                }, 10, null);
            }
        };
    }

    public static final boolean isShiftPressed(PointerEvent pointerEvent) {
        return false;
    }

    public static final Modifier textFieldMagnifier(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager) {
        return !Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null) ? modifier : ComposedModifierKt.composed$default(modifier, null, new C05391(textFieldSelectionManager), 1, null);
    }
}
