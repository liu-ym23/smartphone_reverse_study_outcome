package androidx.compose.foundation;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import S7.o;
import androidx.compose.foundation.gestures.ScrollableContainerNode;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\f\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aX\u0010\f\u001a\u00020\u0000*\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001av\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u008a\u0001\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aH\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u001e\b\u0004\u0010\u001d\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00000\u001bH\u0080\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a \u0001\u0010+\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010!\u001a\u00020 2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001az\u00100\u001a\u00020-2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010,\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u0013\u00102\u001a\u00020\u0001*\u000201H\u0000¢\u0006\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "enabled", "", "onClickLabel", "Landroidx/compose/ui/semantics/Role;", "role", "Lkotlin/Function0;", "LC7/r;", "onClick", "clickable-XHw0xAI", "(Landroidx/compose/ui/Modifier;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;LS7/a;)Landroidx/compose/ui/Modifier;", "clickable", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/foundation/Indication;", "indication", "clickable-O2vRcR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;LS7/a;)Landroidx/compose/ui/Modifier;", "onLongClickLabel", "onLongClick", "onDoubleClick", "combinedClickable-cJG_KMw", "(Landroidx/compose/ui/Modifier;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Ljava/lang/String;LS7/a;LS7/a;LS7/a;)Landroidx/compose/ui/Modifier;", "combinedClickable", "combinedClickable-XVZzFYc", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Ljava/lang/String;LS7/a;LS7/a;LS7/a;)Landroidx/compose/ui/Modifier;", "Lkotlin/Function2;", "Landroidx/compose/foundation/IndicationNodeFactory;", "createClickable", "clickableWithIndicationIfNeeded", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;LS7/n;)Landroidx/compose/ui/Modifier;", "Lm9/z;", "indicationScope", "", "Landroidx/compose/ui/input/key/Key;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "currentKeyPressInteractions", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/geometry/Offset;", "keyClickOffset", "genericClickableWithoutGesture-Kqv-Bsg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;Lm9/z;Ljava/util/Map;Landroidx/compose/runtime/State;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Ljava/lang/String;LS7/a;LS7/a;)Landroidx/compose/ui/Modifier;", "genericClickableWithoutGesture", "indicationNodeFactory", "Landroidx/compose/foundation/CombinedClickableNode;", "CombinedClickableNode-nSzSaCc", "(LS7/a;Ljava/lang/String;LS7/a;LS7/a;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;)Landroidx/compose/foundation/CombinedClickableNode;", "CombinedClickableNode", "Landroidx/compose/ui/node/TraversableNode;", "hasScrollableContainer", "(Landroidx/compose/ui/node/TraversableNode;)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClickableKt {
    @ExperimentalFoundationApi
    /* renamed from: CombinedClickableNode-nSzSaCc, reason: not valid java name */
    public static final CombinedClickableNode m270CombinedClickableNodenSzSaCc(S7.a aVar, String str, S7.a aVar2, S7.a aVar3, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z10, String str2, Role role) {
        return new CombinedClickableNodeImpl(aVar, str, aVar2, aVar3, mutableInteractionSource, indicationNodeFactory, z10, str2, role, null);
    }

    /* renamed from: clickable-O2vRcR0, reason: not valid java name */
    public static final Modifier m271clickableO2vRcR0(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z10, final String str, final Role role, final S7.a aVar) {
        Modifier modifierComposed$default;
        if (indication instanceof IndicationNodeFactory) {
            modifierComposed$default = new ClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, z10, str, role, aVar, null);
        } else if (indication == null) {
            modifierComposed$default = new ClickableElement(mutableInteractionSource, null, z10, str, role, aVar, null);
        } else if (mutableInteractionSource != null) {
            modifierComposed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then(new ClickableElement(mutableInteractionSource, null, z10, str, role, aVar, null));
        } else {
            modifierComposed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new o() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                @Composable
                public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                    composer.startReplaceGroup(-1525724089);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:375)");
                    }
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then(new ClickableElement(mutableInteractionSource2, null, z10, str, role, aVar, null));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return modifierThen;
                }
            }, 1, null);
        }
        return modifier.then(modifierComposed$default);
    }

    /* renamed from: clickable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m272clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z10, String str, Role role, S7.a aVar, int i, Object obj) {
        if ((i & 4) != 0) {
            z10 = true;
        }
        return m271clickableO2vRcR0(modifier, mutableInteractionSource, indication, z10, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : role, aVar);
    }

    /* renamed from: clickable-XHw0xAI, reason: not valid java name */
    public static final Modifier m273clickableXHw0xAI(Modifier modifier, final boolean z10, final String str, final Role role, final S7.a aVar) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("clickable");
                b.k(z10, inspectorInfo.getProperties(), "enabled", inspectorInfo).set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", aVar);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new o() { // from class: androidx.compose.foundation.ClickableKt$clickable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                MutableInteractionSource mutableInteractionSource;
                composer.startReplaceGroup(-756081143);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-756081143, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:112)");
                }
                Indication indication = (Indication) composer.consume(IndicationKt.getLocalIndication());
                if (indication instanceof IndicationNodeFactory) {
                    composer.startReplaceGroup(617140216);
                    composer.endReplaceGroup();
                    mutableInteractionSource = null;
                } else {
                    composer.startReplaceGroup(617248189);
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composer.endReplaceGroup();
                }
                Modifier modifierM271clickableO2vRcR0 = ClickableKt.m271clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource, indication, z10, str, role, aVar);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM271clickableO2vRcR0;
            }
        });
    }

    /* renamed from: clickable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m274clickableXHw0xAI$default(Modifier modifier, boolean z10, String str, Role role, S7.a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m273clickableXHw0xAI(modifier, z10, str, role, aVar);
    }

    public static final Modifier clickableWithIndicationIfNeeded(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final n nVar) {
        return modifier.then(indication instanceof IndicationNodeFactory ? (Modifier) nVar.invoke(mutableInteractionSource, indication) : indication == null ? (Modifier) nVar.invoke(mutableInteractionSource, null) : mutableInteractionSource != null ? IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then((Modifier) nVar.invoke(mutableInteractionSource, null)) : ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new o() { // from class: androidx.compose.foundation.ClickableKt.clickableWithIndicationIfNeeded.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(-1525724089);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:375)");
                }
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composer.updateRememberedValue(objRememberedValue);
                }
                MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then((Modifier) nVar.invoke(mutableInteractionSource2, null));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierThen;
            }
        }, 1, null));
    }

    @ExperimentalFoundationApi
    /* renamed from: combinedClickable-XVZzFYc, reason: not valid java name */
    public static final Modifier m275combinedClickableXVZzFYc(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z10, final String str, final Role role, final String str2, final S7.a aVar, final S7.a aVar2, final S7.a aVar3) {
        Modifier modifierComposed$default;
        if (indication instanceof IndicationNodeFactory) {
            modifierComposed$default = new CombinedClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, z10, str, role, aVar3, str2, aVar, aVar2, null);
        } else if (indication == null) {
            modifierComposed$default = new CombinedClickableElement(mutableInteractionSource, null, z10, str, role, aVar3, str2, aVar, aVar2, null);
        } else if (mutableInteractionSource != null) {
            modifierComposed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then(new CombinedClickableElement(mutableInteractionSource, null, z10, str, role, aVar3, str2, aVar, aVar2, null));
        } else {
            modifierComposed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new o() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$clickableWithIndicationIfNeeded$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                @Composable
                public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                    composer.startReplaceGroup(-1525724089);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:375)");
                    }
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then(new CombinedClickableElement(mutableInteractionSource2, null, z10, str, role, aVar3, str2, aVar, aVar2, null));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return modifierThen;
                }
            }, 1, null);
        }
        return modifier.then(modifierComposed$default);
    }

    /* renamed from: combinedClickable-XVZzFYc$default, reason: not valid java name */
    public static /* synthetic */ Modifier m276combinedClickableXVZzFYc$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z10, String str, Role role, String str2, S7.a aVar, S7.a aVar2, S7.a aVar3, int i, Object obj) {
        S7.a aVar4;
        Modifier modifier2;
        MutableInteractionSource mutableInteractionSource2;
        Indication indication2;
        S7.a aVar5;
        if ((i & 4) != 0) {
            z10 = true;
        }
        boolean z11 = z10;
        String str3 = (i & 8) != 0 ? null : str;
        Role role2 = (i & 16) != 0 ? null : role;
        String str4 = (i & 32) != 0 ? null : str2;
        S7.a aVar6 = (i & 64) != 0 ? null : aVar;
        if ((i & 128) != 0) {
            aVar4 = null;
            modifier2 = modifier;
            indication2 = indication;
            aVar5 = aVar3;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            aVar4 = aVar2;
            modifier2 = modifier;
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            aVar5 = aVar3;
        }
        return m275combinedClickableXVZzFYc(modifier2, mutableInteractionSource2, indication2, z11, str3, role2, str4, aVar6, aVar4, aVar5);
    }

    @ExperimentalFoundationApi
    /* renamed from: combinedClickable-cJG_KMw, reason: not valid java name */
    public static final Modifier m277combinedClickablecJG_KMw(Modifier modifier, final boolean z10, final String str, final Role role, final String str2, final S7.a aVar, final S7.a aVar2, final S7.a aVar3) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("combinedClickable");
                b.k(z10, inspectorInfo.getProperties(), "enabled", inspectorInfo).set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", aVar3);
                inspectorInfo.getProperties().set("onDoubleClick", aVar2);
                inspectorInfo.getProperties().set("onLongClick", aVar);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new o() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                MutableInteractionSource mutableInteractionSource;
                composer.startReplaceGroup(1969174843);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969174843, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:252)");
                }
                Indication indication = (Indication) composer.consume(IndicationKt.getLocalIndication());
                if (indication instanceof IndicationNodeFactory) {
                    composer.startReplaceGroup(-1726989699);
                    composer.endReplaceGroup();
                    mutableInteractionSource = null;
                } else {
                    composer.startReplaceGroup(-1726881726);
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composer.endReplaceGroup();
                }
                Modifier modifierM275combinedClickableXVZzFYc = ClickableKt.m275combinedClickableXVZzFYc(Modifier.INSTANCE, mutableInteractionSource, indication, z10, str, role, str2, aVar, aVar2, aVar3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM275combinedClickableXVZzFYc;
            }
        });
    }

    /* renamed from: combinedClickable-cJG_KMw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m278combinedClickablecJG_KMw$default(Modifier modifier, boolean z10, String str, Role role, String str2, S7.a aVar, S7.a aVar2, S7.a aVar3, int i, Object obj) {
        S7.a aVar4;
        S7.a aVar5;
        String str3;
        S7.a aVar6;
        String str4;
        Role role2;
        Modifier modifier2;
        if ((i & 1) != 0) {
            z10 = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            aVar = null;
        }
        if ((i & 32) != 0) {
            aVar4 = null;
            str3 = str2;
            aVar5 = aVar3;
            str4 = str;
            aVar6 = aVar;
            modifier2 = modifier;
            role2 = role;
        } else {
            aVar4 = aVar2;
            aVar5 = aVar3;
            str3 = str2;
            aVar6 = aVar;
            str4 = str;
            role2 = role;
            modifier2 = modifier;
        }
        return m277combinedClickablecJG_KMw(modifier2, z10, str4, role2, str3, aVar6, aVar4, aVar5);
    }

    /* renamed from: genericClickableWithoutGesture-Kqv-Bsg, reason: not valid java name */
    public static final Modifier m279genericClickableWithoutGestureKqvBsg(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, InterfaceC1733z interfaceC1733z, Map<Key, PressInteraction.Press> map, State<Offset> state, boolean z10, String str, Role role, String str2, S7.a aVar, S7.a aVar2) {
        return modifier.then(FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(new ClickableSemanticsElement(z10, role, str2, aVar, str, aVar2, null), z10, map, state, interfaceC1733z, aVar2, mutableInteractionSource), mutableInteractionSource, indication), mutableInteractionSource, z10), z10, mutableInteractionSource));
    }

    /* renamed from: genericClickableWithoutGesture-Kqv-Bsg$default, reason: not valid java name */
    public static /* synthetic */ Modifier m280genericClickableWithoutGestureKqvBsg$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, InterfaceC1733z interfaceC1733z, Map map, State state, boolean z10, String str, Role role, String str2, S7.a aVar, S7.a aVar2, int i, Object obj) {
        S7.a aVar3;
        Modifier modifier2;
        MutableInteractionSource mutableInteractionSource2;
        Indication indication2;
        InterfaceC1733z interfaceC1733z2;
        Map map2;
        State state2;
        S7.a aVar4;
        boolean z11 = (i & 32) != 0 ? true : z10;
        String str3 = (i & 64) != 0 ? null : str;
        Role role2 = (i & 128) != 0 ? null : role;
        String str4 = (i & 256) != 0 ? null : str2;
        if ((i & 512) != 0) {
            aVar3 = null;
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            interfaceC1733z2 = interfaceC1733z;
            map2 = map;
            state2 = state;
            aVar4 = aVar2;
            modifier2 = modifier;
        } else {
            aVar3 = aVar;
            modifier2 = modifier;
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            interfaceC1733z2 = interfaceC1733z;
            map2 = map;
            state2 = state;
            aVar4 = aVar2;
        }
        return m279genericClickableWithoutGestureKqvBsg(modifier2, mutableInteractionSource2, indication2, interfaceC1733z2, map2, state2, z11, str3, role2, str4, aVar3, aVar4);
    }

    private static final Modifier genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(Modifier modifier, final boolean z10, final Map<Key, PressInteraction.Press> map, final State<Offset> state, final InterfaceC1733z interfaceC1733z, final S7.a aVar, final MutableInteractionSource mutableInteractionSource) {
        return KeyInputModifierKt.onKeyEvent(modifier, new k() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1

            @c(c = "androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1", f = "Clickable.kt", l = {434}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1, reason: invalid class name */
            public static final class AnonymousClass1 extends SuspendLambda implements n {
                final /* synthetic */ MutableInteractionSource $interactionSource;
                final /* synthetic */ PressInteraction.Press $press;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(MutableInteractionSource mutableInteractionSource, PressInteraction.Press press, H7.c<? super AnonymousClass1> cVar) {
                    super(2, cVar);
                    this.$interactionSource = mutableInteractionSource;
                    this.$press = press;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    return new AnonymousClass1(this.$interactionSource, this.$press, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    int i = this.label;
                    if (i == 0) {
                        kotlin.b.b(obj);
                        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                        PressInteraction.Press press = this.$press;
                        this.label = 1;
                        if (mutableInteractionSource.emit(press, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.b.b(obj);
                    }
                    return r.f317a;
                }

                @Override // S7.n
                public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                    return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m281invokeZmokQxo(((KeyEvent) obj).m5264unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m281invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z11 = false;
                if (z10 && Clickable_androidKt.m288isPressZmokQxo(keyEvent)) {
                    if (!map.containsKey(Key.m4964boximpl(KeyEvent_androidKt.m5275getKeyZmokQxo(keyEvent)))) {
                        PressInteraction.Press press = new PressInteraction.Press(state.getValue().m3905unboximpl(), null);
                        map.put(Key.m4964boximpl(KeyEvent_androidKt.m5275getKeyZmokQxo(keyEvent)), press);
                        AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(mutableInteractionSource, press, null), 3);
                        z11 = true;
                    }
                } else if (z10 && Clickable_androidKt.m286isClickZmokQxo(keyEvent)) {
                    PressInteraction.Press pressRemove = map.remove(Key.m4964boximpl(KeyEvent_androidKt.m5275getKeyZmokQxo(keyEvent)));
                    if (pressRemove != null) {
                        AbstractC1683A.n(interfaceC1733z, null, new ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1(mutableInteractionSource, pressRemove, null), 3);
                    }
                    aVar.invoke();
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            }
        });
    }

    public static final boolean hasScrollableContainer(TraversableNode traversableNode) {
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        TraversableNodeKt.traverseAncestors(traversableNode, ScrollableContainerNode.INSTANCE, new k() { // from class: androidx.compose.foundation.ClickableKt.hasScrollableContainer.1
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
            @Override // S7.k
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Boolean invoke(androidx.compose.ui.node.TraversableNode r4) {
                /*
                    r3 = this;
                    kotlin.jvm.internal.Ref$BooleanRef r0 = r1
                    boolean r1 = r0.f4916a
                    r2 = 1
                    if (r1 != 0) goto L17
                    java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableContainerNode"
                    kotlin.jvm.internal.k.d(r4, r1)
                    androidx.compose.foundation.gestures.ScrollableContainerNode r4 = (androidx.compose.foundation.gestures.ScrollableContainerNode) r4
                    boolean r4 = r4.getEnabled()
                    if (r4 == 0) goto L15
                    goto L17
                L15:
                    r4 = 0
                    goto L18
                L17:
                    r4 = r2
                L18:
                    r0.f4916a = r4
                    kotlin.jvm.internal.Ref$BooleanRef r3 = r1
                    boolean r3 = r3.f4916a
                    r3 = r3 ^ r2
                    java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt.C03781.invoke(androidx.compose.ui.node.TraversableNode):java.lang.Boolean");
            }
        });
        return ref$BooleanRef.f4916a;
    }
}
