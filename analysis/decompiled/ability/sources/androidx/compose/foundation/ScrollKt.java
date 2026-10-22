package androidx.compose.foundation;

import C7.r;
import S7.k;
import S7.o;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a2\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t\u001a6\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002\u001a2\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t¨\u0006\u0011"}, d2 = {"rememberScrollState", "Landroidx/compose/foundation/ScrollState;", "initial", "", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/ScrollState;", "horizontalScroll", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "reverseScrolling", "scroll", "isScrollable", "isVertical", "verticalScroll", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollKt {
    public static final Modifier horizontalScroll(Modifier modifier, ScrollState scrollState, boolean z10, FlingBehavior flingBehavior, boolean z11) {
        return scroll(modifier, scrollState, z11, flingBehavior, z10, false);
    }

    public static /* synthetic */ Modifier horizontalScroll$default(Modifier modifier, ScrollState scrollState, boolean z10, FlingBehavior flingBehavior, boolean z11, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = true;
        }
        if ((i & 4) != 0) {
            flingBehavior = null;
        }
        if ((i & 8) != 0) {
            z11 = false;
        }
        return horizontalScroll(modifier, scrollState, z10, flingBehavior, z11);
    }

    @Composable
    public static final ScrollState rememberScrollState(final int i, Composer composer, int i6, int i10) {
        boolean z10 = true;
        if ((i10 & 1) != 0) {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1464256199, i6, -1, "androidx.compose.foundation.rememberScrollState (Scroll.kt:69)");
        }
        Object[] objArr = new Object[0];
        Saver<ScrollState, ?> saver = ScrollState.INSTANCE.getSaver();
        if ((((i6 & 14) ^ 6) <= 4 || !composer.changed(i)) && (i6 & 6) != 4) {
            z10 = false;
        }
        Object objRememberedValue = composer.rememberedValue();
        if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new S7.a() { // from class: androidx.compose.foundation.ScrollKt$rememberScrollState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final ScrollState invoke() {
                    return new ScrollState(i);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ScrollState scrollState = (ScrollState) RememberSaveableKt.m3591rememberSaveable(objArr, (Saver) saver, (String) null, (S7.a) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return scrollState;
    }

    private static final Modifier scroll(Modifier modifier, ScrollState scrollState, boolean z10, FlingBehavior flingBehavior, boolean z11, boolean z12) {
        final ScrollState scrollState2;
        final boolean z13;
        final FlingBehavior flingBehavior2;
        final boolean z14;
        final boolean z15;
        k noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            scrollState2 = scrollState;
            z13 = z10;
            flingBehavior2 = flingBehavior;
            z14 = z11;
            z15 = z12;
            noInspectorInfo = new k() { // from class: androidx.compose.foundation.ScrollKt$scroll$$inlined$debugInspectorInfo$1
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
                    inspectorInfo.setName("scroll");
                    inspectorInfo.getProperties().set("state", scrollState2);
                    b.k(z13, inspectorInfo.getProperties(), "reverseScrolling", inspectorInfo).set("flingBehavior", flingBehavior2);
                    b.k(z14, inspectorInfo.getProperties(), "isScrollable", inspectorInfo).set("isVertical", Boolean.valueOf(z15));
                }
            };
        } else {
            scrollState2 = scrollState;
            z13 = z10;
            flingBehavior2 = flingBehavior;
            z14 = z11;
            z15 = z12;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final boolean z16 = z15;
        final boolean z17 = z14;
        final FlingBehavior flingBehavior3 = flingBehavior2;
        final boolean z18 = z13;
        final ScrollState scrollState3 = scrollState2;
        return ComposedModifierKt.composed(modifier, noInspectorInfo, new o() { // from class: androidx.compose.foundation.ScrollKt.scroll.2
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
                composer.startReplaceGroup(1478351300);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1478351300, i, -1, "androidx.compose.foundation.scroll.<anonymous> (Scroll.kt:276)");
                }
                Modifier modifierThen = Modifier.INSTANCE.then(new ScrollSemanticsElement(scrollState3, z18, flingBehavior3, z17, z16));
                ScrollState scrollState4 = scrollState3;
                Modifier modifierThen2 = ScrollingContainerKt.scrollingContainer(modifierThen, scrollState4, z16 ? Orientation.Vertical : Orientation.Horizontal, z17, z18, flingBehavior3, scrollState4.getInternalInteractionSource(), null, composer, 0, 64).then(new ScrollingLayoutElement(scrollState3, z18, z16));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierThen2;
            }
        });
    }

    public static final Modifier verticalScroll(Modifier modifier, ScrollState scrollState, boolean z10, FlingBehavior flingBehavior, boolean z11) {
        return scroll(modifier, scrollState, z11, flingBehavior, z10, true);
    }

    public static /* synthetic */ Modifier verticalScroll$default(Modifier modifier, ScrollState scrollState, boolean z10, FlingBehavior flingBehavior, boolean z11, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = true;
        }
        if ((i & 4) != 0) {
            flingBehavior = null;
        }
        if ((i & 8) != 0) {
            z11 = false;
        }
        return verticalScroll(modifier, scrollState, z10, flingBehavior, z11);
    }
}
