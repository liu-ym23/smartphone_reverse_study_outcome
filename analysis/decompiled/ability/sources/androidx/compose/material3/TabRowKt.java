package androidx.compose.material3;

import C7.r;
import N9.j;
import S7.k;
import S7.n;
import S7.o;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000T\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a{\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0013\b\u0002\u0010\r\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a{\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0013\b\u0002\u0010\r\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0010\u001a\u0081\u0001\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0013\b\u0002\u0010\r\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0010\u001a\u008f\u0001\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0013\b\u0002\u0010\r\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u008f\u0001\u0010 \u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0013\b\u0002\u0010\r\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001d\u001a\u008b\u0001\u0010#\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0013\b\u0002\u0010\r\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001ai\u0010&\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\nH\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a\u0081\u0001\u0010)\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00182\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\nH\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001ao\u0010+\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\nH\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010%\u001a\u0091\u0001\u0010.\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0013\b\u0002\u0010\r\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-\"\u0014\u0010/\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100\"\u001a\u00103\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104\"\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u001a018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"", "selectedTabIndex", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/material3/TabIndicatorScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "indicator", "Lkotlin/Function0;", "divider", "tabs", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLS7/o;LS7/n;LS7/n;Landroidx/compose/runtime/Composer;II)V", "PrimaryTabRow", "SecondaryTabRow-pAZo6Ak", "SecondaryTabRow", "", "Landroidx/compose/material3/TabPosition;", "TabRow-pAZo6Ak", "TabRow", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Landroidx/compose/ui/unit/Dp;", "edgePadding", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLS7/o;LS7/n;LS7/n;Landroidx/compose/runtime/Composer;II)V", "PrimaryScrollableTabRow", "SecondaryScrollableTabRow-qhFBPw4", "SecondaryScrollableTabRow", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLS7/o;LS7/n;LS7/n;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLS7/o;LS7/n;LS7/n;Landroidx/compose/runtime/Composer;I)V", "TabRowImpl", "ScrollableTabRowImpl-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/ScrollState;LS7/o;LS7/n;LS7/n;Landroidx/compose/runtime/Composer;I)V", "ScrollableTabRowImpl", "TabRowWithSubcomposeImpl-DTcfvLk", "TabRowWithSubcomposeImpl", "ScrollableTabRowWithSubcomposeImpl-qhFBPw4", "(ILS7/o;Landroidx/compose/ui/Modifier;JJFLS7/n;LS7/n;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowWithSubcomposeImpl", "ScrollableTabRowMinimumTabWidth", "F", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "TabRowIndicatorSpec", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m6844constructorimpl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final AnimationSpec<Dp> TabRowIndicatorSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f8  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* renamed from: PrimaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2362PrimaryScrollableTabRowqhFBPw4(final int r21, androidx.compose.ui.Modifier r22, androidx.compose.foundation.ScrollState r23, long r24, long r26, float r28, S7.o r29, S7.n r30, final S7.n r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2362PrimaryScrollableTabRowqhFBPw4(int, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, long, long, float, S7.o, S7.n, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0112  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* renamed from: PrimaryTabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2363PrimaryTabRowpAZo6Ak(final int r21, androidx.compose.ui.Modifier r22, long r23, long r25, S7.o r27, S7.n r28, final S7.n r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2363PrimaryTabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, S7.o, S7.n, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0109  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2364ScrollableTabRowsKfQg0A(final int r19, androidx.compose.ui.Modifier r20, long r21, long r23, float r25, S7.o r26, S7.n r27, final S7.n r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2364ScrollableTabRowsKfQg0A(int, androidx.compose.ui.Modifier, long, long, float, S7.o, S7.n, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* renamed from: ScrollableTabRowImpl-sKfQg0A, reason: not valid java name */
    public static final void m2365ScrollableTabRowImplsKfQg0A(final int i, final Modifier modifier, final long j5, final long j6, final float f, final ScrollState scrollState, final o oVar, final n nVar, final n nVar2, Composer composer, final int i6) {
        int i10;
        float f7;
        ScrollState scrollState2;
        o oVar2;
        n nVar3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1594140035);
        if ((i6 & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i6;
        } else {
            i10 = i6;
        }
        if ((i6 & 48) == 0) {
            i10 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i10 |= composerStartRestartGroup.changed(j5) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i10 |= composerStartRestartGroup.changed(j6) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            f7 = f;
            i10 |= composerStartRestartGroup.changed(f7) ? 16384 : 8192;
        } else {
            f7 = f;
        }
        if ((196608 & i6) == 0) {
            scrollState2 = scrollState;
            i10 |= composerStartRestartGroup.changed(scrollState2) ? 131072 : 65536;
        } else {
            scrollState2 = scrollState;
        }
        if ((1572864 & i6) == 0) {
            oVar2 = oVar;
            i10 |= composerStartRestartGroup.changedInstance(oVar2) ? 1048576 : 524288;
        } else {
            oVar2 = oVar;
        }
        if ((i6 & 12582912) == 0) {
            nVar3 = nVar;
            i10 |= composerStartRestartGroup.changedInstance(nVar3) ? 8388608 : 4194304;
        } else {
            nVar3 = nVar;
        }
        if ((100663296 & i6) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i10 & 38347923) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1594140035, i10, -1, "androidx.compose.material3.ScrollableTabRowImpl (TabRow.kt:698)");
            }
            Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollState2, false, null, false, 14, null)));
            final n nVar4 = nVar3;
            final o oVar3 = oVar2;
            final float f9 = f7;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2314SurfaceT9BRK9s(modifierClipToBounds, null, j5, j6, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1556158104, true, new n() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1
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
                public final void invoke(Composer composer3, int i11) {
                    if ((i11 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1556158104, i11, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous> (TabRow.kt:710)");
                    }
                    Object objRememberedValue = composer3.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = B7.a.e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.f4908a, composer3), composer3);
                    }
                    InterfaceC1733z coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    boolean zChanged = composer3.changed(scrollState) | composer3.changed(coroutineScope);
                    ScrollState scrollState3 = scrollState;
                    Object objRememberedValue2 = composer3.rememberedValue();
                    if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new ScrollableTabData(scrollState3, coroutineScope);
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    final ScrollableTabData scrollableTabData = (ScrollableTabData) objRememberedValue2;
                    Object objRememberedValue3 = composer3.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new TabRowKt$ScrollableTabRowImpl$1$scope$1$1();
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    final TabRowKt$ScrollableTabRowImpl$1$scope$1$1 tabRowKt$ScrollableTabRowImpl$1$scope$1$1 = (TabRowKt$ScrollableTabRowImpl$1$scope$1$1) objRememberedValue3;
                    n nVar5 = nVar2;
                    n nVar6 = nVar4;
                    final o oVar4 = oVar3;
                    List listN = H4.o.N(nVar5, nVar6, ComposableLambdaKt.rememberComposableLambda(-1530560661, true, new n() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // S7.n
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return r.f317a;
                        }

                        @Composable
                        public final void invoke(Composer composer4, int i12) {
                            if ((i12 & 3) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1530560661, i12, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous>.<anonymous> (TabRow.kt:756)");
                            }
                            oVar4.invoke(tabRowKt$ScrollableTabRowImpl$1$scope$1$1, composer4, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54));
                    boolean zChanged2 = composer3.changed(f9) | composer3.changed(i) | composer3.changedInstance(scrollableTabData);
                    final float f10 = f9;
                    final int i12 = i;
                    Object objRememberedValue4 = composer3.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$2$1
                            @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                            /* renamed from: measure-3p2s80s */
                            public final MeasureResult mo648measure3p2s80s(final MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j10) {
                                List<? extends Measurable> list2 = list.get(0);
                                List<? extends Measurable> list3 = list.get(1);
                                List<? extends Measurable> list4 = list.get(2);
                                final int iMo375roundToPx0680j_4 = measureScope.mo375roundToPx0680j_4(f10);
                                int size = list2.size();
                                int iMo375roundToPx0680j_42 = measureScope.mo375roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                Integer numValueOf = 0;
                                int size2 = list2.size();
                                for (int i13 = 0; i13 < size2; i13++) {
                                    numValueOf = Integer.valueOf(Math.max(numValueOf.intValue(), list2.get(i13).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                }
                                int iIntValue = numValueOf.intValue();
                                int iMo375roundToPx0680j_43 = iMo375roundToPx0680j_4 * 2;
                                long jM6787copyZbe2FdA$default = Constraints.m6787copyZbe2FdA$default(j10, iMo375roundToPx0680j_42, 0, iIntValue, iIntValue, 2, null);
                                int i14 = iIntValue;
                                final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                                ref$FloatRef.f4917a = f10;
                                ArrayList arrayList = new ArrayList(list2.size());
                                int size3 = list2.size();
                                for (int i15 = 0; i15 < size3; i15++) {
                                    arrayList.add(list2.get(i15).mo5549measureBRTryo0(jM6787copyZbe2FdA$default));
                                }
                                ArrayList arrayList2 = new ArrayList(size);
                                for (int i16 = 0; i16 < size; i16++) {
                                    float fM6858unboximpl = ((Dp) j.L(Dp.m6842boximpl(TabRowKt.ScrollableTabRowMinimumTabWidth), Dp.m6842boximpl(measureScope.mo378toDpu2uoSUM(((Placeable) arrayList.get(i16)).getWidth())))).m6858unboximpl();
                                    iMo375roundToPx0680j_43 += measureScope.mo375roundToPx0680j_4(fM6858unboximpl);
                                    TabPosition tabPosition = new TabPosition(ref$FloatRef.f4917a, fM6858unboximpl, ((Dp) j.L(Dp.m6842boximpl(Dp.m6844constructorimpl(fM6858unboximpl - Dp.m6844constructorimpl(TabKt.getHorizontalTextPadding() * 2))), Dp.m6842boximpl(Dp.m6844constructorimpl(24)))).m6858unboximpl(), null);
                                    ref$FloatRef.f4917a = Dp.m6844constructorimpl(ref$FloatRef.f4917a + fM6858unboximpl);
                                    arrayList2.add(tabPosition);
                                }
                                tabRowKt$ScrollableTabRowImpl$1$scope$1$1.setTabPositions(arrayList2);
                                final ArrayList arrayList3 = new ArrayList(list3.size());
                                int size4 = list3.size();
                                int i17 = 0;
                                while (i17 < size4) {
                                    int i18 = iMo375roundToPx0680j_43;
                                    arrayList3.add(list3.get(i17).mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(j10, i18, iMo375roundToPx0680j_43, 0, 0, 8, null)));
                                    i17++;
                                    size4 = size4;
                                    list3 = list3;
                                    iMo375roundToPx0680j_43 = i18;
                                }
                                int i19 = iMo375roundToPx0680j_43;
                                int i20 = i12;
                                final ArrayList arrayList4 = new ArrayList(list4.size());
                                int size5 = list4.size();
                                int i21 = 0;
                                while (i21 < size5) {
                                    int i22 = i14;
                                    arrayList4.add(list4.get(i21).mo5549measureBRTryo0(Constraints.m6786copyZbe2FdA(j10, 0, measureScope.mo375roundToPx0680j_4(((TabPosition) arrayList2.get(i20)).getWidth()), 0, i22)));
                                    i21++;
                                    arrayList = arrayList;
                                    i14 = i22;
                                    list4 = list4;
                                    arrayList2 = arrayList2;
                                }
                                final ArrayList arrayList5 = arrayList;
                                final int i23 = i14;
                                final ArrayList arrayList6 = arrayList2;
                                final float f11 = f10;
                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                final int i24 = i12;
                                return MeasureScope.layout$default(measureScope, i19, i23, null, new k() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // S7.k
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return r.f317a;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        Ref$FloatRef ref$FloatRef2 = ref$FloatRef;
                                        ref$FloatRef2.f4917a = f11;
                                        List<Placeable> list5 = arrayList5;
                                        MeasureScope measureScope2 = measureScope;
                                        List<TabPosition> list6 = arrayList6;
                                        int size6 = list5.size();
                                        for (int i25 = 0; i25 < size6; i25++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i25), measureScope2.mo375roundToPx0680j_4(ref$FloatRef2.f4917a), 0, 0.0f, 4, null);
                                            ref$FloatRef2.f4917a = Dp.m6844constructorimpl(list6.get(i25).getWidth() + ref$FloatRef2.f4917a);
                                        }
                                        List<Placeable> list7 = arrayList3;
                                        int i26 = i23;
                                        int size7 = list7.size();
                                        for (int i27 = 0; i27 < size7; i27++) {
                                            Placeable placeable = list7.get(i27);
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i26 - placeable.getHeight(), 0.0f, 4, null);
                                        }
                                        List<Placeable> list8 = arrayList4;
                                        MeasureScope measureScope3 = measureScope;
                                        List<TabPosition> list9 = arrayList6;
                                        int i28 = i24;
                                        int i29 = i23;
                                        int size8 = list8.size();
                                        for (int i30 = 0; i30 < size8; i30++) {
                                            Placeable placeable2 = list8.get(i30);
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, Math.max(0, (measureScope3.mo375roundToPx0680j_4(list9.get(i28).getWidth()) - placeable2.getWidth()) / 2), i29 - placeable2.getHeight(), 0.0f, 4, null);
                                        }
                                        scrollableTabData2.onLaidOut(measureScope, iMo375roundToPx0680j_4, arrayList6, i24);
                                    }
                                }, 4, null);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) objRememberedValue4;
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    n nVarCombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listN);
                    boolean zChanged3 = composer3.changed(multiContentMeasurePolicy);
                    Object objRememberedValue5 = composer3.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue5;
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, companion2);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    S7.a constructor = companion3.getConstructor();
                    if (composer3.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer3);
                    n nVarG = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
                    if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                    nVarCombineAsVirtualLayouts.invoke(composer3, 0);
                    composer3.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, (i10 & 896) | 12582912 | (i10 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i11) {
                    TabRowKt.m2365ScrollableTabRowImplsKfQg0A(i, modifier, j5, j6, f, scrollState, oVar, nVar, nVar2, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f9  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* renamed from: ScrollableTabRowWithSubcomposeImpl-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2366ScrollableTabRowWithSubcomposeImplqhFBPw4(final int r27, final S7.o r28, androidx.compose.ui.Modifier r29, long r30, long r32, float r34, S7.n r35, final S7.n r36, final androidx.compose.foundation.ScrollState r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2366ScrollableTabRowWithSubcomposeImplqhFBPw4(int, S7.o, androidx.compose.ui.Modifier, long, long, float, S7.n, S7.n, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f8  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* renamed from: SecondaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2367SecondaryScrollableTabRowqhFBPw4(final int r21, androidx.compose.ui.Modifier r22, androidx.compose.foundation.ScrollState r23, long r24, long r26, float r28, S7.o r29, S7.n r30, final S7.n r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2367SecondaryScrollableTabRowqhFBPw4(int, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, long, long, float, S7.o, S7.n, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0112  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* renamed from: SecondaryTabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2368SecondaryTabRowpAZo6Ak(final int r21, androidx.compose.ui.Modifier r22, long r23, long r25, S7.o r27, S7.n r28, final S7.n r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2368SecondaryTabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, S7.o, S7.n, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0112  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2369TabRowpAZo6Ak(final int r21, androidx.compose.ui.Modifier r22, long r23, long r25, S7.o r27, S7.n r28, final S7.n r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2369TabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, S7.o, S7.n, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* renamed from: TabRowImpl-DTcfvLk, reason: not valid java name */
    public static final void m2370TabRowImplDTcfvLk(Modifier modifier, final long j5, final long j6, final o oVar, final n nVar, final n nVar2, Composer composer, final int i) {
        Modifier modifier2;
        int i6;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1757425411);
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i6 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(j5) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(j6) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(oVar) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar2) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757425411, i6, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:570)");
            }
            int i10 = i6 << 3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2314SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j5, j6, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-65106680, true, new n() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1
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
                public final void invoke(Composer composer3, int i11) {
                    if ((i11 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-65106680, i11, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:576)");
                    }
                    Object objRememberedValue = composer3.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new TabRowKt$TabRowImpl$1$scope$1$1();
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    final TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = (TabRowKt$TabRowImpl$1$scope$1$1) objRememberedValue;
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    n nVar3 = nVar2;
                    n nVar4 = nVar;
                    final o oVar2 = oVar;
                    List listN = H4.o.N(nVar3, nVar4, ComposableLambdaKt.rememberComposableLambda(1236693605, true, new n() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // S7.n
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return r.f317a;
                        }

                        @Composable
                        public final void invoke(Composer composer4, int i12) {
                            if ((i12 & 3) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1236693605, i12, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:617)");
                            }
                            oVar2.invoke(tabRowKt$TabRowImpl$1$scope$1$1, composer4, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54));
                    Object objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1
                            @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                            /* renamed from: measure-3p2s80s */
                            public final MeasureResult mo648measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j10) {
                                List<? extends Measurable> list2 = list.get(0);
                                List<? extends Measurable> list3 = list.get(1);
                                int i12 = 2;
                                List<? extends Measurable> list4 = list.get(2);
                                int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j10);
                                int size = list2.size();
                                final Ref$IntRef ref$IntRef = new Ref$IntRef();
                                if (size > 0) {
                                    ref$IntRef.f4918a = iM6797getMaxWidthimpl / size;
                                }
                                Integer numValueOf = 0;
                                int size2 = list2.size();
                                for (int i13 = 0; i13 < size2; i13++) {
                                    numValueOf = Integer.valueOf(Math.max(list2.get(i13).maxIntrinsicHeight(ref$IntRef.f4918a), numValueOf.intValue()));
                                }
                                final int iIntValue = numValueOf.intValue();
                                TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$12 = tabRowKt$TabRowImpl$1$scope$1$1;
                                ArrayList arrayList = new ArrayList(size);
                                int i14 = 0;
                                while (i14 < size) {
                                    arrayList.add(new TabPosition(Dp.m6844constructorimpl(measureScope.mo378toDpu2uoSUM(ref$IntRef.f4918a) * i14), measureScope.mo378toDpu2uoSUM(ref$IntRef.f4918a), ((Dp) j.L(Dp.m6842boximpl(Dp.m6844constructorimpl(measureScope.mo378toDpu2uoSUM(Math.min(list2.get(i14).maxIntrinsicWidth(iIntValue), ref$IntRef.f4918a)) - Dp.m6844constructorimpl(TabKt.getHorizontalTextPadding() * i12))), Dp.m6842boximpl(Dp.m6844constructorimpl(24)))).m6858unboximpl(), null));
                                    i14++;
                                    i12 = 2;
                                }
                                tabRowKt$TabRowImpl$1$scope$1$12.setTabPositions(arrayList);
                                final ArrayList arrayList2 = new ArrayList(list2.size());
                                int size3 = list2.size();
                                for (int i15 = 0; i15 < size3; i15++) {
                                    Measurable measurable = list2.get(i15);
                                    int i16 = ref$IntRef.f4918a;
                                    int i17 = iIntValue;
                                    long jM6786copyZbe2FdA = Constraints.m6786copyZbe2FdA(j10, i16, i16, i17, iIntValue);
                                    iIntValue = i17;
                                    arrayList2.add(measurable.mo5549measureBRTryo0(jM6786copyZbe2FdA));
                                }
                                final ArrayList arrayList3 = new ArrayList(list3.size());
                                int size4 = list3.size();
                                for (int i18 = 0; i18 < size4; i18++) {
                                    arrayList3.add(list3.get(i18).mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(j10, 0, 0, 0, 0, 11, null)));
                                }
                                final ArrayList arrayList4 = new ArrayList(list4.size());
                                int size5 = list4.size();
                                for (int i19 = 0; i19 < size5; i19++) {
                                    Measurable measurable2 = list4.get(i19);
                                    int i20 = ref$IntRef.f4918a;
                                    int i21 = iIntValue;
                                    iIntValue = i21;
                                    arrayList4.add(measurable2.mo5549measureBRTryo0(Constraints.m6786copyZbe2FdA(j10, i20, i20, 0, i21)));
                                }
                                return MeasureScope.layout$default(measureScope, iM6797getMaxWidthimpl, iIntValue, null, new k() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // S7.k
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return r.f317a;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        List<Placeable> list5 = arrayList2;
                                        Ref$IntRef ref$IntRef2 = ref$IntRef;
                                        int size6 = list5.size();
                                        for (int i22 = 0; i22 < size6; i22++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i22), i22 * ref$IntRef2.f4918a, 0, 0.0f, 4, null);
                                        }
                                        List<Placeable> list6 = arrayList3;
                                        int i23 = iIntValue;
                                        int size7 = list6.size();
                                        for (int i24 = 0; i24 < size7; i24++) {
                                            Placeable placeable = list6.get(i24);
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i23 - placeable.getHeight(), 0.0f, 4, null);
                                        }
                                        List<Placeable> list7 = arrayList4;
                                        int i25 = iIntValue;
                                        int size8 = list7.size();
                                        for (int i26 = 0; i26 < size8; i26++) {
                                            Placeable placeable2 = list7.get(i26);
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, 0, i25 - placeable2.getHeight(), 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) objRememberedValue2;
                    n nVarCombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listN);
                    Object objRememberedValue3 = composer3.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    S7.a constructor = companion2.getConstructor();
                    if (composer3.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer3);
                    n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
                    if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    nVarCombineAsVirtualLayouts.invoke(composer3, 0);
                    composer3.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, (i10 & 896) | 12582912 | (i10 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i11) {
                    TabRowKt.m2370TabRowImplDTcfvLk(modifier3, j5, j6, oVar, nVar, nVar2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* renamed from: TabRowWithSubcomposeImpl-DTcfvLk, reason: not valid java name */
    public static final void m2371TabRowWithSubcomposeImplDTcfvLk(Modifier modifier, final long j5, final long j6, final o oVar, final n nVar, final n nVar2, Composer composer, final int i) {
        Modifier modifier2;
        int i6;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-160898917);
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i6 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(j5) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(j6) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(oVar) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar2) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160898917, i6, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:942)");
            }
            int i10 = i6 << 3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2314SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j5, j6, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1617702432, true, new n() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1
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
                public final void invoke(Composer composer3, int i11) {
                    if ((i11 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1617702432, i11, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:948)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    boolean zChanged = composer3.changed(nVar2) | composer3.changed(nVar) | composer3.changed(oVar);
                    final n nVar3 = nVar2;
                    final n nVar4 = nVar;
                    final o oVar2 = oVar;
                    Object objRememberedValue = composer3.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new n() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // S7.n
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2379invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2379invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j10) {
                                final int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j10);
                                List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, nVar3);
                                int size = listSubcompose.size();
                                final Ref$IntRef ref$IntRef = new Ref$IntRef();
                                if (size > 0) {
                                    ref$IntRef.f4918a = iM6797getMaxWidthimpl / size;
                                }
                                Integer numValueOf = 0;
                                int size2 = listSubcompose.size();
                                for (int i12 = 0; i12 < size2; i12++) {
                                    numValueOf = Integer.valueOf(Math.max(listSubcompose.get(i12).maxIntrinsicHeight(ref$IntRef.f4918a), numValueOf.intValue()));
                                }
                                final int iIntValue = numValueOf.intValue();
                                final ArrayList arrayList = new ArrayList(listSubcompose.size());
                                int size3 = listSubcompose.size();
                                for (int i13 = 0; i13 < size3; i13++) {
                                    Measurable measurable = listSubcompose.get(i13);
                                    int i14 = ref$IntRef.f4918a;
                                    arrayList.add(measurable.mo5549measureBRTryo0(Constraints.m6786copyZbe2FdA(j10, i14, i14, iIntValue, iIntValue)));
                                }
                                final ArrayList arrayList2 = new ArrayList(size);
                                for (int i15 = 0; i15 < size; i15++) {
                                    arrayList2.add(new TabPosition(Dp.m6844constructorimpl(subcomposeMeasureScope.mo378toDpu2uoSUM(ref$IntRef.f4918a) * i15), subcomposeMeasureScope.mo378toDpu2uoSUM(ref$IntRef.f4918a), ((Dp) j.L(Dp.m6842boximpl(Dp.m6844constructorimpl(subcomposeMeasureScope.mo378toDpu2uoSUM(Math.min(listSubcompose.get(i15).maxIntrinsicWidth(iIntValue), ref$IntRef.f4918a)) - Dp.m6844constructorimpl(TabKt.getHorizontalTextPadding() * 2))), Dp.m6842boximpl(Dp.m6844constructorimpl(24)))).m6858unboximpl(), null));
                                }
                                final n nVar5 = nVar4;
                                final o oVar3 = oVar2;
                                return MeasureScope.layout$default(subcomposeMeasureScope, iM6797getMaxWidthimpl, iIntValue, null, new k() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // S7.k
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return r.f317a;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        List<Placeable> list = arrayList;
                                        Ref$IntRef ref$IntRef2 = ref$IntRef;
                                        int size4 = list.size();
                                        for (int i16 = 0; i16 < size4; i16++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i16), i16 * ref$IntRef2.f4918a, 0, 0.0f, 4, null);
                                        }
                                        List<Measurable> listSubcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, nVar5);
                                        long j11 = j10;
                                        int i17 = iIntValue;
                                        int size5 = listSubcompose2.size();
                                        for (int i18 = 0; i18 < size5; i18++) {
                                            Placeable placeableMo5549measureBRTryo0 = listSubcompose2.get(i18).mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(j11, 0, 0, 0, 0, 11, null));
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo0, 0, i17 - placeableMo5549measureBRTryo0.getHeight(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final o oVar4 = oVar3;
                                        final List<TabPosition> list2 = arrayList2;
                                        List<Measurable> listSubcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1621992604, true, new n() { // from class: androidx.compose.material3.TabRowKt.TabRowWithSubcomposeImpl.1.1.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // S7.n
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return r.f317a;
                                            }

                                            @Composable
                                            public final void invoke(Composer composer4, int i19) {
                                                if ((i19 & 3) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1621992604, i19, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:994)");
                                                }
                                                oVar4.invoke(list2, composer4, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i19 = iM6797getMaxWidthimpl;
                                        int i20 = iIntValue;
                                        int size6 = listSubcompose3.size();
                                        for (int i21 = 0; i21 < size6; i21++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, listSubcompose3.get(i21).mo5549measureBRTryo0(Constraints.INSTANCE.m6807fixedJhjzzOo(i19, i20)), 0, 0, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (n) objRememberedValue, composer3, 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, (i10 & 896) | 12582912 | (i10 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i11) {
                    TabRowKt.m2371TabRowWithSubcomposeImplDTcfvLk(modifier3, j5, j6, oVar, nVar, nVar2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
