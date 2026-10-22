package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import android.view.BackEventCompat;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0096\u0001\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u008c\u0001\u0010\u001a\u001a\u00020\u00012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u008e\u0002\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\u00042\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u0084\u0002\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\u00042\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a¶\u0001\u00107\u001a\u00020\u00012\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+2\u0006\u00100\u001a\u00020/2\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u000102012\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u000102012\b\b\u0002\u0010\t\u001a\u00020\b2\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u0096\u0001\u00109\u001a\u00020\u00012\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+2\u0006\u00100\u001a\u00020/2\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u000102012\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u000102012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00022\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00022\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u0002H\u0003¢\u0006\u0004\b9\u0010:\u001a)\u0010<\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u0001022\u0006\u0010;\u001a\u00020,2\u0006\u00100\u001a\u00020,H\u0002¢\u0006\u0004\b<\u0010=\u001aD\u0010G\u001a\u00020@2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\b\u00104\u001a\u0004\u0018\u0001022\u0006\u0010C\u001a\u00020B2\u0006\u0010;\u001a\u00020,2\u0006\u0010D\u001a\u00020,H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001aN\u0010L\u001a\u00020@2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\b\u00104\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001022\u0006\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020@2\u0006\u0010D\u001a\u00020,H\u0002ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\"\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010O\"\u0014\u0010P\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bP\u0010Q\"\u0014\u0010R\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bR\u0010Q\"\u0014\u0010S\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010Q\"\u001a\u0010T\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bT\u0010U\u0012\u0004\bV\u0010W\"\u001a\u0010X\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bX\u0010U\u001a\u0004\bY\u0010Z\"\u0014\u0010[\u001a\u00020,8\u0002X\u0082T¢\u0006\u0006\n\u0004\b[\u0010U\"\u001a\u0010\\\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\\\u0010U\u001a\u0004\b]\u0010Z\"\u0014\u0010^\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010U\"\u001a\u0010_\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b_\u0010U\u001a\u0004\b`\u0010Z\"\u0014\u0010a\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010U\"\u0014\u0010b\u001a\u00020,8\u0002X\u0082T¢\u0006\u0006\n\u0004\bb\u0010U\"\u0014\u0010c\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010U\"\u0014\u0010d\u001a\u00020,8\u0002X\u0082T¢\u0006\u0006\n\u0004\bd\u0010U\"\u0014\u0010e\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010U\"\u0014\u0010f\u001a\u00020@8\u0002X\u0082T¢\u0006\u0006\n\u0004\bf\u0010g\"\u0014\u0010h\u001a\u00020@8\u0002X\u0082T¢\u0006\u0006\n\u0004\bh\u0010g\"\u0014\u0010i\u001a\u00020@8\u0002X\u0082T¢\u0006\u0006\n\u0004\bi\u0010g\"\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010l\"\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010l\"\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020,0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010p\"\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020,0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010p\"\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020,0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010p\"\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020s0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010p\"\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020s0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010p\"\u0014\u0010w\u001a\u00020v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010x\"\u0014\u0010z\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006~²\u0006\f\u0010|\u001a\u00020\u00048\nX\u008a\u0084\u0002²\u0006\f\u0010}\u001a\u00020\u00048\nX\u008a\u0084\u0002"}, d2 = {"Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "inputField", "", "expanded", "Lkotlin/Function1;", "onExpandedChange", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/material3/SearchBarColors;", "colors", "Landroidx/compose/ui/unit/Dp;", "tonalElevation", "shadowElevation", "Landroidx/compose/foundation/layout/WindowInsets;", "windowInsets", "Landroidx/compose/foundation/layout/ColumnScope;", "content", "SearchBar-Y92LkZI", "(LS7/n;ZLS7/k;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;LS7/o;Landroidx/compose/runtime/Composer;II)V", "SearchBar", "DockedSearchBar-EQC0FA8", "(LS7/n;ZLS7/k;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLS7/o;Landroidx/compose/runtime/Composer;II)V", "DockedSearchBar", "", "query", "onQueryChange", "onSearch", "active", "onActiveChange", "enabled", "placeholder", "leadingIcon", "trailingIcon", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "SearchBar-WuY5d9Q", "(Ljava/lang/String;LS7/k;LS7/k;ZLS7/k;Landroidx/compose/ui/Modifier;ZLS7/n;LS7/n;LS7/n;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;LS7/o;Landroidx/compose/runtime/Composer;III)V", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;LS7/k;LS7/k;ZLS7/k;Landroidx/compose/ui/Modifier;ZLS7/n;LS7/n;LS7/n;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;LS7/o;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animationProgress", "Landroidx/compose/runtime/MutableFloatState;", "finalBackProgress", "Landroidx/compose/runtime/MutableState;", "Landroidx/activity/BackEventCompat;", "firstBackEvent", "currentBackEvent", "SearchBarImpl-j1jLAyQ", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;LS7/n;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;LS7/o;Landroidx/compose/runtime/Composer;III)V", "SearchBarImpl", "surface", "SearchBarLayout", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/WindowInsets;LS7/n;LS7/n;LS7/n;Landroidx/compose/runtime/Composer;I)V", "progress", "calculatePredictiveBackMultiplier", "(Landroidx/activity/BackEventCompat;FF)F", "Landroidx/compose/ui/unit/Constraints;", "constraints", "", "minMargin", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "predictiveBackMultiplier", "calculatePredictiveBackOffsetX-rOvwMX4", "(JILandroidx/activity/BackEventCompat;Landroidx/compose/ui/unit/LayoutDirection;FF)I", "calculatePredictiveBackOffsetX", "height", "maxOffsetY", "calculatePredictiveBackOffsetY-dzo92Q0", "(JILandroidx/activity/BackEventCompat;Landroidx/activity/BackEventCompat;IIF)I", "calculatePredictiveBackOffsetY", "Landroidx/compose/material3/TextFieldColors;", "UnspecifiedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "LayoutIdInputField", "Ljava/lang/String;", "LayoutIdSurface", "LayoutIdSearchContent", "SearchBarCornerRadius", "F", "getSearchBarCornerRadius$annotations", "()V", "DockedExpandedTableMinHeight", "getDockedExpandedTableMinHeight", "()F", "DockedExpandedTableMaxHeightScreenRatio", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarMaxWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "SearchBarIconOffsetX", "SearchBarPredictiveBackMinScale", "SearchBarPredictiveBackMinMargin", "SearchBarPredictiveBackMaxOffsetXRatio", "SearchBarPredictiveBackMaxOffsetY", "AnimationEnterDurationMillis", "I", "AnimationExitDurationMillis", "AnimationDelayMillis", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationExitEasing", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "AnimationExitFloatSpec", "AnimationPredictiveBackExitFloatSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationEnterSizeSpec", "AnimationExitSizeSpec", "Landroidx/compose/animation/EnterTransition;", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "Landroidx/compose/animation/ExitTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "useFullScreenShape", "showContent", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SearchBar_androidKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final FiniteAnimationSpec<Float> AnimationPredictiveBackExitFloatSpec;
    private static final EnterTransition DockedEnterTransition;
    private static final ExitTransition DockedExitTransition;
    private static final float DockedExpandedTableMaxHeightScreenRatio = 0.6666667f;
    private static final float DockedExpandedTableMinHeight;
    private static final String LayoutIdInputField = "InputField";
    private static final String LayoutIdSearchContent = "Content";
    private static final String LayoutIdSurface = "Surface";
    private static final float SearchBarCornerRadius;
    private static final float SearchBarIconOffsetX;
    private static final float SearchBarMaxWidth;
    private static final float SearchBarMinWidth;
    private static final float SearchBarPredictiveBackMaxOffsetXRatio = 0.05f;
    private static final float SearchBarPredictiveBackMaxOffsetY;
    private static final float SearchBarPredictiveBackMinMargin;
    private static final float SearchBarPredictiveBackMinScale = 0.9f;
    private static final float SearchBarVerticalPadding;
    private static final TextFieldColors UnspecifiedTextFieldColors;

    static {
        Color.Companion companion = Color.INSTANCE;
        UnspecifiedTextFieldColors = new TextFieldColors(companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), new TextSelectionColors(companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), null), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), companion.m4175getUnspecified0d7_KjU(), null);
        SearchBarCornerRadius = Dp.m6844constructorimpl(SearchBarDefaults.INSTANCE.m2183getInputFieldHeightD9Ej5fM() / 2);
        DockedExpandedTableMinHeight = Dp.m6844constructorimpl(240);
        SearchBarMinWidth = Dp.m6844constructorimpl(360);
        SearchBarMaxWidth = Dp.m6844constructorimpl(720);
        float f = 8;
        SearchBarVerticalPadding = Dp.m6844constructorimpl(f);
        SearchBarIconOffsetX = Dp.m6844constructorimpl(4);
        SearchBarPredictiveBackMinMargin = Dp.m6844constructorimpl(f);
        SearchBarPredictiveBackMaxOffsetY = Dp.m6844constructorimpl(24);
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        TweenSpec tweenSpecTween = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tweenSpecTween;
        TweenSpec tweenSpecTween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tweenSpecTween2;
        AnimationPredictiveBackExitFloatSpec = AnimationSpecKt.tween$default(AnimationExitDurationMillis, 0, cubicBezierEasing, 2, null);
        TweenSpec tweenSpecTween3 = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tweenSpecTween3;
        TweenSpec tweenSpecTween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tweenSpecTween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tweenSpecTween, 0.0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(tweenSpecTween3, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tweenSpecTween2, 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(tweenSpecTween4, null, false, null, 14, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0109  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: DockedSearchBar-EQC0FA8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2188DockedSearchBarEQC0FA8(final S7.n r26, final boolean r27, final S7.k r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, androidx.compose.material3.SearchBarColors r31, float r32, float r33, final S7.o r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2188DockedSearchBarEQC0FA8(S7.n, boolean, S7.k, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0129  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @C7.c
    @androidx.compose.runtime.Composable
    /* renamed from: DockedSearchBar-eWTbjVg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2189DockedSearchBareWTbjVg(final java.lang.String r34, final S7.k r35, final S7.k r36, final boolean r37, final S7.k r38, androidx.compose.ui.Modifier r39, boolean r40, S7.n r41, S7.n r42, S7.n r43, androidx.compose.ui.graphics.Shape r44, androidx.compose.material3.SearchBarColors r45, float r46, float r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, final S7.o r49, androidx.compose.runtime.Composer r50, final int r51, final int r52, final int r53) {
        /*
            Method dump skipped, instructions count: 917
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2189DockedSearchBareWTbjVg(java.lang.String, S7.k, S7.k, boolean, S7.k, androidx.compose.ui.Modifier, boolean, S7.n, S7.n, S7.n, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.interaction.MutableInteractionSource, S7.o, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0129  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @C7.c
    @androidx.compose.runtime.Composable
    /* renamed from: SearchBar-WuY5d9Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2190SearchBarWuY5d9Q(final java.lang.String r35, final S7.k r36, final S7.k r37, final boolean r38, final S7.k r39, androidx.compose.ui.Modifier r40, boolean r41, S7.n r42, S7.n r43, S7.n r44, androidx.compose.ui.graphics.Shape r45, androidx.compose.material3.SearchBarColors r46, float r47, float r48, androidx.compose.foundation.layout.WindowInsets r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, final S7.o r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 971
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2190SearchBarWuY5d9Q(java.lang.String, S7.k, S7.k, boolean, S7.k, androidx.compose.ui.Modifier, boolean, S7.n, S7.n, S7.n, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.foundation.interaction.MutableInteractionSource, S7.o, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0104  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: SearchBar-Y92LkZI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2191SearchBarY92LkZI(final S7.n r29, final boolean r30, final S7.k r31, androidx.compose.ui.Modifier r32, androidx.compose.ui.graphics.Shape r33, androidx.compose.material3.SearchBarColors r34, float r35, float r36, androidx.compose.foundation.layout.WindowInsets r37, final S7.o r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 874
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2191SearchBarY92LkZI(S7.n, boolean, S7.k, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0103  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: SearchBarImpl-j1jLAyQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2192SearchBarImplj1jLAyQ(final androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r27, final androidx.compose.runtime.MutableFloatState r28, final androidx.compose.runtime.MutableState<android.view.BackEventCompat> r29, final androidx.compose.runtime.MutableState<android.view.BackEventCompat> r30, androidx.compose.ui.Modifier r31, final S7.n r32, androidx.compose.ui.graphics.Shape r33, androidx.compose.material3.SearchBarColors r34, float r35, float r36, androidx.compose.foundation.layout.WindowInsets r37, final S7.o r38, androidx.compose.runtime.Composer r39, final int r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 925
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2192SearchBarImplj1jLAyQ(androidx.compose.animation.core.Animatable, androidx.compose.runtime.MutableFloatState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.ui.Modifier, S7.n, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, S7.o, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$12(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void SearchBarLayout(final Animatable<Float, AnimationVector1D> animatable, final MutableFloatState mutableFloatState, final MutableState<BackEventCompat> mutableState, final MutableState<BackEventCompat> mutableState2, final Modifier modifier, final WindowInsets windowInsets, final n nVar, final n nVar2, final n nVar3, Composer composer, final int i) {
        int i6;
        final MutableFloatState mutableFloatState2;
        MutableState<BackEventCompat> mutableState3;
        MutableState<BackEventCompat> mutableState4;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(70029564);
        if ((i & 6) == 0) {
            i6 = ((i & 8) == 0 ? composerStartRestartGroup.changed(animatable) : composerStartRestartGroup.changedInstance(animatable) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            mutableFloatState2 = mutableFloatState;
            i6 |= composerStartRestartGroup.changed(mutableFloatState2) ? 32 : 16;
        } else {
            mutableFloatState2 = mutableFloatState;
        }
        if ((i & 384) == 0) {
            mutableState3 = mutableState;
            i6 |= composerStartRestartGroup.changed(mutableState3) ? 256 : 128;
        } else {
            mutableState3 = mutableState;
        }
        if ((i & 3072) == 0) {
            mutableState4 = mutableState2;
            i6 |= composerStartRestartGroup.changed(mutableState4) ? 2048 : 1024;
        } else {
            mutableState4 = mutableState2;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar2) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & i6) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70029564, i6, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.android.kt:941)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new MutableWindowInsets(null, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
            Modifier modifierZIndex = ZIndexModifierKt.zIndex(modifier, 1.0f);
            boolean z10 = (i6 & 458752) == 131072;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new k() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((WindowInsets) obj);
                        return r.f317a;
                    }

                    public final void invoke(WindowInsets windowInsets2) {
                        mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, windowInsets2));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifierZIndex, (k) objRememberedValue2), windowInsets);
            boolean z11 = ((i6 & 7168) == 2048) | ((i6 & 14) == 4 || ((i6 & 8) != 0 && composerStartRestartGroup.changedInstance(animatable))) | ((i6 & 112) == 32) | ((i6 & 896) == 256);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue3 == companion.getEmpty()) {
                final MutableState<BackEventCompat> mutableState5 = mutableState3;
                final MutableState<BackEventCompat> mutableState6 = mutableState4;
                i10 = i6;
                MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo37measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, final long j5) {
                        Measurable measurable;
                        final Placeable placeableMo5549measureBRTryo0;
                        int iM6796getMaxHeightimpl;
                        MeasureScope measureScope2 = measureScope;
                        long j6 = j5;
                        final float fFloatValue = animatable.getValue().floatValue();
                        int size = list.size();
                        int i11 = 0;
                        while (i11 < size) {
                            Measurable measurable2 = list.get(i11);
                            if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable2), "InputField")) {
                                int size2 = list.size();
                                int i12 = 0;
                                while (i12 < size2) {
                                    Measurable measurable3 = list.get(i12);
                                    if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable3), "Surface")) {
                                        int size3 = list.size();
                                        int i13 = 0;
                                        while (true) {
                                            if (i13 >= size3) {
                                                measurable = null;
                                                break;
                                            }
                                            measurable = list.get(i13);
                                            if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable), "Content")) {
                                                break;
                                            }
                                            i13++;
                                        }
                                        Measurable measurable4 = measurable;
                                        final int iMo375roundToPx0680j_4 = measureScope2.mo375roundToPx0680j_4(SearchBar_androidKt.getSearchBarVerticalPadding()) + mutableWindowInsets.getTop(measureScope2);
                                        int iMo375roundToPx0680j_42 = measureScope2.mo375roundToPx0680j_4(SearchBar_androidKt.getSearchBarVerticalPadding());
                                        int iM6814constrainWidthK40F9xA = ConstraintsKt.m6814constrainWidthK40F9xA(j6, measurable2.maxIntrinsicWidth(Constraints.m6796getMaxHeightimpl(j6)));
                                        int iM6813constrainHeightK40F9xA = ConstraintsKt.m6813constrainHeightK40F9xA(j6, measurable2.minIntrinsicHeight(Constraints.m6797getMaxWidthimpl(j6)));
                                        int iU = U7.a.U(Constraints.m6797getMaxWidthimpl(j6) * 0.9f);
                                        int iU2 = U7.a.U(Constraints.m6796getMaxHeightimpl(j6) * 0.9f);
                                        final float fCalculatePredictiveBackMultiplier = SearchBar_androidKt.calculatePredictiveBackMultiplier(mutableState6.getValue(), fFloatValue, mutableFloatState2.getFloatValue());
                                        int iLerp = MathHelpersKt.lerp(iM6814constrainWidthK40F9xA, iU, fCalculatePredictiveBackMultiplier);
                                        int i14 = iMo375roundToPx0680j_4 + iM6813constrainHeightK40F9xA;
                                        int iLerp2 = MathHelpersKt.lerp(i14, iU2, fCalculatePredictiveBackMultiplier);
                                        int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j6);
                                        int iM6796getMaxHeightimpl2 = Constraints.m6796getMaxHeightimpl(j6);
                                        int iLerp3 = MathHelpersKt.lerp(iLerp, iM6797getMaxWidthimpl, fFloatValue);
                                        final int iLerp4 = MathHelpersKt.lerp(iLerp2, iM6796getMaxHeightimpl2, fFloatValue);
                                        final int iLerp5 = MathHelpersKt.lerp(iMo375roundToPx0680j_4, 0, fFloatValue);
                                        final int iLerp6 = MathHelpersKt.lerp(0, iMo375roundToPx0680j_42, fFloatValue);
                                        final Placeable placeableMo5549measureBRTryo02 = measurable2.mo5549measureBRTryo0(ConstraintsKt.Constraints(iLerp3, iM6797getMaxWidthimpl, iM6813constrainHeightK40F9xA, iM6813constrainHeightK40F9xA));
                                        int width = placeableMo5549measureBRTryo02.getWidth();
                                        final Placeable placeableMo5549measureBRTryo03 = measurable3.mo5549measureBRTryo0(Constraints.INSTANCE.m6807fixedJhjzzOo(width, iLerp4 - iLerp5));
                                        if (measurable4 != null) {
                                            if (Constraints.m6792getHasBoundedHeightimpl(j6)) {
                                                iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j6) - (i14 + iMo375roundToPx0680j_42);
                                                if (iM6796getMaxHeightimpl < 0) {
                                                    iM6796getMaxHeightimpl = 0;
                                                }
                                            } else {
                                                iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j6);
                                            }
                                            placeableMo5549measureBRTryo0 = measurable4.mo5549measureBRTryo0(ConstraintsKt.Constraints(width, width, 0, iM6796getMaxHeightimpl));
                                        } else {
                                            placeableMo5549measureBRTryo0 = null;
                                        }
                                        final MutableState<BackEventCompat> mutableState7 = mutableState6;
                                        final MutableState<BackEventCompat> mutableState8 = mutableState5;
                                        return MeasureScope.layout$default(measureScope, width, iLerp4, null, new k() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // S7.k
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Placeable.PlacementScope) obj);
                                                return r.f317a;
                                            }

                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                int iMo375roundToPx0680j_43 = measureScope.mo375roundToPx0680j_4(SearchBar_androidKt.SearchBarPredictiveBackMinMargin);
                                                int iM2195calculatePredictiveBackOffsetXrOvwMX4 = SearchBar_androidKt.m2195calculatePredictiveBackOffsetXrOvwMX4(j5, iMo375roundToPx0680j_43, mutableState7.getValue(), measureScope.getLayoutDirection(), fFloatValue, fCalculatePredictiveBackMultiplier);
                                                int iM2196calculatePredictiveBackOffsetYdzo92Q0 = SearchBar_androidKt.m2196calculatePredictiveBackOffsetYdzo92Q0(j5, iMo375roundToPx0680j_43, mutableState7.getValue(), mutableState8.getValue(), iLerp4, measureScope.mo375roundToPx0680j_4(SearchBar_androidKt.SearchBarPredictiveBackMaxOffsetY), fCalculatePredictiveBackMultiplier);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo03, iM2195calculatePredictiveBackOffsetXrOvwMX4, iM2196calculatePredictiveBackOffsetYdzo92Q0 + iLerp5, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo02, iM2195calculatePredictiveBackOffsetXrOvwMX4, iM2196calculatePredictiveBackOffsetYdzo92Q0 + iMo375roundToPx0680j_4, 0.0f, 4, null);
                                                Placeable placeable = placeableMo5549measureBRTryo0;
                                                if (placeable != null) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iM2195calculatePredictiveBackOffsetXrOvwMX4, placeableMo5549measureBRTryo02.getHeight() + iM2196calculatePredictiveBackOffsetYdzo92Q0 + iMo375roundToPx0680j_4 + iLerp6, 0.0f, 4, null);
                                                }
                                            }
                                        }, 4, null);
                                    }
                                    i12++;
                                    measureScope2 = measureScope;
                                    j6 = j5;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i11++;
                            measureScope2 = measureScope;
                            j6 = j5;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicy);
                objRememberedValue3 = measurePolicy;
            } else {
                i10 = i6;
            }
            MeasurePolicy measurePolicy2 = (MeasurePolicy) objRememberedValue3;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierConsumeWindowInsets);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            S7.a constructor = companion2.getConstructor();
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicy2, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion3, LayoutIdSurface);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), true);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
            S7.a constructor2 = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl2 = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG2 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl2, currentCompositionLocalMap2);
            if (composerM3474constructorimpl2.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            nVar2.invoke(composerStartRestartGroup, Integer.valueOf((i10 >> 21) & 14));
            composerStartRestartGroup.endNode();
            Modifier modifierLayoutId2 = LayoutIdKt.layoutId(companion3, LayoutIdInputField);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), true);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId2);
            S7.a constructor3 = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl3 = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG3 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM3474constructorimpl3, currentCompositionLocalMap3);
            if (composerM3474constructorimpl3.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                androidx.appfunctions.metadata.a.z(nVarG3, currentCompositeKeyHash3, composerM3474constructorimpl3, currentCompositeKeyHash3);
            }
            Updater.m3481setimpl(composerM3474constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
            nVar.invoke(composerStartRestartGroup, Integer.valueOf((i10 >> 18) & 14));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.startReplaceGroup(-1107184481);
            if (nVar3 != null) {
                Modifier modifierLayoutId3 = LayoutIdKt.layoutId(companion3, LayoutIdSearchContent);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), true);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId3);
                S7.a constructor4 = companion2.getConstructor();
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM3474constructorimpl4 = Updater.m3474constructorimpl(composerStartRestartGroup);
                n nVarG4 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, composerM3474constructorimpl4, currentCompositionLocalMap4);
                if (composerM3474constructorimpl4.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    androidx.appfunctions.metadata.a.z(nVarG4, currentCompositeKeyHash4, composerM3474constructorimpl4, currentCompositeKeyHash4);
                }
                Updater.m3481setimpl(composerM3474constructorimpl4, modifierMaterializeModifier4, companion2.getSetModifier());
                nVar3.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
            }
            if (androidx.appfunctions.metadata.a.D(composerStartRestartGroup)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.SearchBar_androidKt.SearchBarLayout.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i11) {
                    SearchBar_androidKt.SearchBarLayout(animatable, mutableFloatState, mutableState, mutableState2, modifier, windowInsets, nVar, nVar2, nVar3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackMultiplier(BackEventCompat backEventCompat, float f, float f7) {
        if (backEventCompat == null) {
            return 0.0f;
        }
        if (Float.isNaN(f7)) {
            return 1.0f;
        }
        if (f7 <= 0.0f) {
            return 0.0f;
        }
        return f / f7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculatePredictiveBackOffsetX-rOvwMX4, reason: not valid java name */
    public static final int m2195calculatePredictiveBackOffsetXrOvwMX4(long j5, int i, BackEventCompat backEventCompat, LayoutDirection layoutDirection, float f, float f7) {
        if (backEventCompat == null || f7 == 0.0f) {
            return 0;
        }
        return U7.a.U((1 - f) * ((Constraints.m6797getMaxWidthimpl(j5) * 0.05f) - i) * f7 * (backEventCompat.getSwipeEdge() == 0 ? 1 : -1) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculatePredictiveBackOffsetY-dzo92Q0, reason: not valid java name */
    public static final int m2196calculatePredictiveBackOffsetYdzo92Q0(long j5, int i, BackEventCompat backEventCompat, BackEventCompat backEventCompat2, int i6, int i10, float f) {
        if (backEventCompat2 == null || backEventCompat == null || f == 0.0f) {
            return 0;
        }
        int iMin = Math.min(Math.max(0, ((Constraints.m6796getMaxHeightimpl(j5) - i6) / 2) - i), i10);
        float touchY = backEventCompat.getTouchY() - backEventCompat2.getTouchY();
        float fAbs = Math.abs(touchY) / Constraints.m6796getMaxHeightimpl(j5);
        return U7.a.U(MathHelpersKt.lerp(0, iMin, fAbs) * f * Math.signum(touchY));
    }

    public static final float getDockedExpandedTableMinHeight() {
        return DockedExpandedTableMinHeight;
    }

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }
}
