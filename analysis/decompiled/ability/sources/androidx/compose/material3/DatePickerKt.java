package androidx.compose.material3;

import C7.r;
import D7.v;
import H4.o;
import S7.k;
import S7.n;
import S7.p;
import Y7.f;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.material3.DisplayMode;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.stepos.ability.mcpserver.model.McpErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import p9.d;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u001am\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001aH\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aT\u0010\"\u001a\u00020\u00002\n\u0010\u001f\u001a\u00060\u001dj\u0002`\u001e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0084\u0001\u0010+\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0013\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b2\u0013\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a6\u00101\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00162\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070-H\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a~\u0010:\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u00112\u0006\u00103\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00162\u0014\u00104\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00070-2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070-2\u0006\u00107\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001aq\u0010;\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u00112\u0006\u00103\u001a\u00020\u00112\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070-2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070-2\u0006\u00107\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b;\u0010<\u001aZ\u0010C\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0013\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020&2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001aq\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020D2\b\u00102\u001a\u0004\u0018\u00010\u00112\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070-2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070-2\u0006\u00107\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\bF\u0010G\u001a<\u0010H\u001a\u00020\u00072\u0006\u0010E\u001a\u00020D2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070-2\u0006\u00107\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u0014H\u0080@¢\u0006\u0004\bH\u0010I\u001a\u001f\u0010J\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00107\u001a\u000206H\u0001¢\u0006\u0004\bJ\u0010K\u001ai\u0010S\u001a\u00020\u00072\u0006\u0010M\u001a\u00020L2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070-2\u0006\u0010N\u001a\u00020\u00112\b\u0010O\u001a\u0004\u0018\u00010\u00112\b\u0010P\u001a\u0004\u0018\u00010\u00112\b\u0010R\u001a\u0004\u0018\u00010Q2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\bS\u0010T\u001a\u0017\u0010V\u001a\u00020U2\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\bV\u0010W\u001a9\u0010^\u001a\u0004\u0018\u00010]2\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\u000bH\u0003¢\u0006\u0004\b^\u0010_\u001ap\u0010g\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010`\u001a\u00020\u000b2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020]2\u0006\u0010\u000e\u001a\u00020\r2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\bg\u0010h\u001aS\u0010j\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00112\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\u00070-2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00107\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\bj\u0010k\u001a`\u0010m\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010`\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020\u000b2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010c\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020]2\u0006\u0010\u000e\u001a\u00020\r2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\bm\u0010n\u001ai\u0010v\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010o\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020\u000b2\u0006\u0010q\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020]2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\bv\u0010w\u001aB\u0010y\u001a\u00020\u00072\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010x\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\by\u0010z\u001a:\u0010\u0082\u0001\u001a\n\u0012\u0005\u0012\u00030\u0081\u00010\u0080\u00012\u0006\u0010\u0001\u001a\u00020{2\u0006\u0010}\u001a\u00020|2\u0006\u0010~\u001a\u00020]2\u0006\u0010\u007f\u001a\u00020]H\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u001f\u0010\u0084\u0001\u001a\u00020&8\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u001f\u0010\u0088\u0001\u001a\u00020&8\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0085\u0001\u001a\u0006\b\u0089\u0001\u0010\u0087\u0001\"\u001f\u0010\u008a\u0001\u001a\u00020&8\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u0085\u0001\u001a\u0006\b\u008b\u0001\u0010\u0087\u0001\" \u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0018\u0010\u0091\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u008e\u0001\"\u0018\u0010\u0092\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u008e\u0001\"\u0017\u0010\u0093\u0001\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0085\u0001\"\u0017\u0010\u0094\u0001\u001a\u00020U8\u0002X\u0082T¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0017\u0010\u0096\u0001\u001a\u00020U8\u0002X\u0082T¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0095\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0097\u0001²\u0006\u000e\u0010q\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/material3/DatePickerState;", "state", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/material3/DatePickerFormatter;", "dateFormatter", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "title", "headline", "", "showModeToggle", "Landroidx/compose/material3/DatePickerColors;", "colors", "DatePicker", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;LS7/n;LS7/n;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "", "initialSelectedDateMillis", "initialDisplayedMonthMillis", "LY7/f;", "yearRange", "Landroidx/compose/material3/DisplayMode;", "initialDisplayMode", "Landroidx/compose/material3/SelectableDates;", "selectableDates", "rememberDatePickerState-EU0dCGE", "(Ljava/lang/Long;Ljava/lang/Long;LY7/f;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "rememberDatePickerState", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "locale", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;LY7/f;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "DatePickerState", "modeToggleButton", "Landroidx/compose/ui/text/TextStyle;", "headlineTextStyle", "Landroidx/compose/ui/unit/Dp;", "headerMinHeight", "content", "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;LS7/n;LS7/n;LS7/n;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLS7/n;Landroidx/compose/runtime/Composer;I)V", "DateEntryContainer", "displayMode", "Lkotlin/Function1;", "onDisplayModeChange", "DisplayModeToggleButton-tER2X8s", "(Landroidx/compose/ui/Modifier;ILS7/k;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "selectedDateMillis", "displayedMonthMillis", "onDateSelectionChange", "onDisplayedMonthChange", "Landroidx/compose/material3/internal/CalendarModel;", "calendarModel", "SwitchableDateEntryContent-d7iavvg", "(Ljava/lang/Long;JILS7/k;LS7/k;Landroidx/compose/material3/internal/CalendarModel;LY7/f;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "DatePickerContent", "(Ljava/lang/Long;JLS7/k;LS7/k;Landroidx/compose/material3/internal/CalendarModel;LY7/f;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "minHeight", "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;LS7/n;JJFLS7/n;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "Landroidx/compose/foundation/lazy/LazyListState;", "lazyListState", "HorizontalMonthsList", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;LS7/k;LS7/k;Landroidx/compose/material3/internal/CalendarModel;LY7/f;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;LS7/k;Landroidx/compose/material3/internal/CalendarModel;LY7/f;LH7/c;)Ljava/lang/Object;", "WeekDays", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/internal/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/material3/internal/CalendarMonth;", "month", "todayMillis", "startDateMillis", "endDateMillis", "Landroidx/compose/material3/SelectedRangeInfo;", "rangeSelectionInfo", "Month", "(Landroidx/compose/material3/internal/CalendarMonth;LS7/k;JLjava/lang/Long;Ljava/lang/Long;Landroidx/compose/material3/SelectedRangeInfo;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "", "numberOfMonthsInRange", "(LY7/f;)I", "rangeSelectionEnabled", "isToday", "isStartDate", "isEndDate", "isInRange", "", "dayContentDescription", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "selected", "onClick", "animateChecked", "enabled", "today", "inRange", "description", "Day", "(Landroidx/compose/ui/Modifier;ZLS7/a;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;LS7/n;Landroidx/compose/runtime/Composer;I)V", "onYearSelected", "YearPicker", "(Landroidx/compose/ui/Modifier;JLS7/k;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/CalendarModel;LY7/f;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "currentYear", "Year", "(Landroidx/compose/ui/Modifier;ZZLS7/a;ZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;LS7/n;Landroidx/compose/runtime/Composer;I)V", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "MonthsNavigation", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;LS7/a;LS7/a;LS7/a;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "expanded", "YearPickerMenuButton", "(LS7/a;ZLandroidx/compose/ui/Modifier;LS7/n;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "Lm9/z;", "coroutineScope", "scrollUpLabel", "scrollDownLabel", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "customScrollActions", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Lm9/z;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "RecommendedSizeForAccessibility", "F", "getRecommendedSizeForAccessibility", "()F", "MonthYearHeight", "getMonthYearHeight", "DatePickerHorizontalPadding", "getDatePickerHorizontalPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerModeTogglePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "DatePickerHeadlinePadding", "YearsVerticalPadding", "MaxCalendarRows", "I", "YearsInRow", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DatePickerKt {
    private static final PaddingValues DatePickerHeadlinePadding;
    private static final float DatePickerHorizontalPadding;
    private static final PaddingValues DatePickerModeTogglePadding;
    private static final PaddingValues DatePickerTitlePadding;
    private static final int MaxCalendarRows = 6;
    private static final int YearsInRow = 3;
    private static final float YearsVerticalPadding;
    private static final float RecommendedSizeForAccessibility = Dp.m6844constructorimpl(48);
    private static final float MonthYearHeight = Dp.m6844constructorimpl(56);

    static {
        float f = 12;
        DatePickerHorizontalPadding = Dp.m6844constructorimpl(f);
        DatePickerModeTogglePadding = PaddingKt.m697PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m6844constructorimpl(f), Dp.m6844constructorimpl(f), 3, null);
        float f7 = 24;
        float f9 = 16;
        DatePickerTitlePadding = PaddingKt.m697PaddingValuesa9UjIt4$default(Dp.m6844constructorimpl(f7), Dp.m6844constructorimpl(f9), Dp.m6844constructorimpl(f), 0.0f, 8, null);
        DatePickerHeadlinePadding = PaddingKt.m697PaddingValuesa9UjIt4$default(Dp.m6844constructorimpl(f7), 0.0f, Dp.m6844constructorimpl(f), Dp.m6844constructorimpl(f), 2, null);
        YearsVerticalPadding = Dp.m6844constructorimpl(f9);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: DateEntryContainer-au3_HiA, reason: not valid java name */
    public static final void m1771DateEntryContainerau3_HiA(final Modifier modifier, final n nVar, final n nVar2, final n nVar3, final DatePickerColors datePickerColors, final TextStyle textStyle, final float f, final n nVar4, Composer composer, final int i) {
        int i6;
        n nVar5;
        n nVar6;
        n nVar7;
        DatePickerColors datePickerColors2;
        TextStyle textStyle2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1507356255);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            nVar5 = nVar;
            i6 |= composerStartRestartGroup.changedInstance(nVar5) ? 32 : 16;
        } else {
            nVar5 = nVar;
        }
        if ((i & 384) == 0) {
            nVar6 = nVar2;
            i6 |= composerStartRestartGroup.changedInstance(nVar6) ? 256 : 128;
        } else {
            nVar6 = nVar2;
        }
        if ((i & 3072) == 0) {
            nVar7 = nVar3;
            i6 |= composerStartRestartGroup.changedInstance(nVar7) ? 2048 : 1024;
        } else {
            nVar7 = nVar3;
        }
        if ((i & 24576) == 0) {
            datePickerColors2 = datePickerColors;
            i6 |= composerStartRestartGroup.changed(datePickerColors2) ? 16384 : 8192;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((196608 & i) == 0) {
            textStyle2 = textStyle;
            i6 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
        } else {
            textStyle2 = textStyle;
        }
        if ((1572864 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar4) ? 8388608 : 4194304;
        }
        if ((4793491 & i6) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507356255, i6, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1302)");
            }
            Modifier modifierM239backgroundbw27NRU$default = BackgroundKt.m239backgroundbw27NRU$default(SemanticsModifierKt.semantics$default(SizeKt.m749sizeInqDBjuR0$default(modifier, DatePickerModalTokens.INSTANCE.m2918getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null), false, new k() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return r.f317a;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                }
            }, 1, null), datePickerColors2.getContainerColor(), null, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM239backgroundbw27NRU$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            S7.a constructor = companion.getConstructor();
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyColumnMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            final n nVar8 = nVar5;
            final n nVar9 = nVar6;
            final n nVar10 = nVar7;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            final TextStyle textStyle3 = textStyle2;
            m1772DatePickerHeaderpc5RIQQ(Modifier.INSTANCE, nVar, datePickerColors2.getTitleContentColor(), datePickerColors2.getHeadlineContentColor(), f, ComposableLambdaKt.rememberComposableLambda(-229007058, true, new n() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1
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
                public final void invoke(Composer composer3, int i10) {
                    if ((i10 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-229007058, i10, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous> (DatePicker.kt:1320)");
                    }
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                    final n nVar11 = nVar9;
                    n nVar12 = nVar10;
                    n nVar13 = nVar8;
                    DatePickerColors datePickerColors4 = datePickerColors3;
                    TextStyle textStyle4 = textStyle3;
                    Arrangement arrangement = Arrangement.INSTANCE;
                    Arrangement.Vertical top = arrangement.getTop();
                    Alignment.Companion companion3 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composer3, 0);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                    S7.a constructor2 = companion4.getConstructor();
                    if (composer3.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor2);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM3474constructorimpl2 = Updater.m3474constructorimpl(composer3);
                    n nVarG2 = androidx.appfunctions.metadata.a.g(companion4, composerM3474constructorimpl2, measurePolicyColumnMeasurePolicy2, composerM3474constructorimpl2, currentCompositionLocalMap2);
                    if (composerM3474constructorimpl2.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    Arrangement.Horizontal start = (nVar11 == null || nVar12 == null) ? nVar11 != null ? arrangement.getStart() : arrangement.getEnd() : arrangement.getSpaceBetween();
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion3.getCenterVertically(), composer3, 48);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default2);
                    S7.a constructor3 = companion4.getConstructor();
                    if (composer3.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM3474constructorimpl3 = Updater.m3474constructorimpl(composer3);
                    n nVarG3 = androidx.appfunctions.metadata.a.g(companion4, composerM3474constructorimpl3, measurePolicyRowMeasurePolicy, composerM3474constructorimpl3, currentCompositionLocalMap3);
                    if (composerM3474constructorimpl3.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        androidx.appfunctions.metadata.a.z(nVarG3, currentCompositeKeyHash3, composerM3474constructorimpl3, currentCompositeKeyHash3);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
                    final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    composer3.startReplaceGroup(-1287352520);
                    if (nVar11 != null) {
                        TextKt.ProvideTextStyle(textStyle4, ComposableLambdaKt.rememberComposableLambda(-962031352, true, new n() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1$1$1$1
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
                                    ComposerKt.traceEventStart(-962031352, i11, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1334)");
                                }
                                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                n nVar14 = nVar11;
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer4, modifierWeight$default);
                                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                                S7.a constructor4 = companion5.getConstructor();
                                if (composer4.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor4);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM3474constructorimpl4 = Updater.m3474constructorimpl(composer4);
                                n nVarG4 = androidx.appfunctions.metadata.a.g(companion5, composerM3474constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl4, currentCompositionLocalMap4);
                                if (composerM3474constructorimpl4.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                    androidx.appfunctions.metadata.a.z(nVarG4, currentCompositeKeyHash4, composerM3474constructorimpl4, currentCompositeKeyHash4);
                                }
                                Updater.m3481setimpl(composerM3474constructorimpl4, modifierMaterializeModifier4, companion5.getSetModifier());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                if (androidx.appfunctions.metadata.a.C(nVar14, composer4, 0)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 48);
                    }
                    composer3.endReplaceGroup();
                    composer3.startReplaceGroup(-1287344444);
                    if (nVar12 != null) {
                        nVar12.invoke(composer3, 0);
                    }
                    composer3.endReplaceGroup();
                    composer3.endNode();
                    composer3.startReplaceGroup(1995129302);
                    if (nVar13 != null || nVar11 != null || nVar12 != null) {
                        DividerKt.m1826HorizontalDivider9IZ8Weo(null, 0.0f, datePickerColors4.getDividerColor(), composer3, 0, 3);
                    }
                    if (androidx.appfunctions.metadata.a.D(composer3)) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i6 & 112) | 196614 | (57344 & (i6 >> 6)));
            composer2 = composerStartRestartGroup;
            if (androidx.appfunctions.metadata.a.C(nVar4, composer2, (i6 >> 21) & 14)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i10) {
                    DatePickerKt.m1771DateEntryContainerau3_HiA(modifier, nVar, nVar2, nVar3, datePickerColors, textStyle, f, nVar4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e8  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DatePicker(final androidx.compose.material3.DatePickerState r25, androidx.compose.ui.Modifier r26, androidx.compose.material3.DatePickerFormatter r27, S7.n r28, S7.n r29, boolean r30, androidx.compose.material3.DatePickerColors r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.DatePicker(androidx.compose.material3.DatePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.DatePickerFormatter, S7.n, S7.n, boolean, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x039d  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DatePickerContent(final java.lang.Long r25, final long r26, final S7.k r28, final S7.k r29, final androidx.compose.material3.internal.CalendarModel r30, final Y7.f r31, final androidx.compose.material3.DatePickerFormatter r32, final androidx.compose.material3.SelectableDates r33, final androidx.compose.material3.DatePickerColors r34, androidx.compose.runtime.Composer r35, final int r36) {
        /*
            Method dump skipped, instructions count: 963
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.DatePickerContent(java.lang.Long, long, S7.k, S7.k, androidx.compose.material3.internal.CalendarModel, Y7.f, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.SelectableDates, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DatePickerContent$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DatePickerContent$lambda$9(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0166  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: DatePickerHeader-pc5RIQQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1772DatePickerHeaderpc5RIQQ(final androidx.compose.ui.Modifier r17, final S7.n r18, final long r19, final long r21, final float r23, final S7.n r24, androidx.compose.runtime.Composer r25, final int r26) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.m1772DatePickerHeaderpc5RIQQ(androidx.compose.ui.Modifier, S7.n, long, long, float, S7.n, androidx.compose.runtime.Composer, int):void");
    }

    @ExperimentalMaterial3Api
    /* renamed from: DatePickerState-sHin3Bw, reason: not valid java name */
    public static final DatePickerState m1773DatePickerStatesHin3Bw(Locale locale, Long l, Long l5, f fVar, int i, SelectableDates selectableDates) {
        return new DatePickerStateImpl(l, l5, fVar, i, selectableDates, locale, null);
    }

    /* renamed from: DatePickerState-sHin3Bw$default, reason: not valid java name */
    public static /* synthetic */ DatePickerState m1774DatePickerStatesHin3Bw$default(Locale locale, Long l, Long l5, f fVar, int i, SelectableDates selectableDates, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            l = null;
        }
        if ((i6 & 4) != 0) {
            l5 = l;
        }
        if ((i6 & 8) != 0) {
            fVar = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i6 & 16) != 0) {
            i = DisplayMode.INSTANCE.m1823getPickerjFl4v0();
        }
        if ((i6 & 32) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        SelectableDates selectableDates2 = selectableDates;
        f fVar2 = fVar;
        return m1773DatePickerStatesHin3Bw(locale, l, l5, fVar2, i, selectableDates2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Day(final Modifier modifier, final boolean z10, final S7.a aVar, final boolean z11, final boolean z12, final boolean z13, final boolean z14, final String str, final DatePickerColors datePickerColors, final n nVar, Composer composer, final int i) {
        int i6;
        boolean z15;
        boolean z16;
        boolean z17;
        DatePickerColors datePickerColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1434777861);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(aVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            z15 = z11;
            i6 |= composerStartRestartGroup.changed(z15) ? 2048 : 1024;
        } else {
            z15 = z11;
        }
        if ((i & 24576) == 0) {
            z16 = z12;
            i6 |= composerStartRestartGroup.changed(z16) ? 16384 : 8192;
        } else {
            z16 = z12;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(z13) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            z17 = z14;
            i6 |= composerStartRestartGroup.changed(z17) ? 1048576 : 524288;
        } else {
            z17 = z14;
        }
        if ((12582912 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(str) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i6 |= composerStartRestartGroup.changed(datePickerColors2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((805306368 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 536870912 : 268435456;
        }
        int i10 = i6;
        if ((306783379 & i10) == 306783378 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1434777861, i10, -1, "androidx.compose.material3.Day (DatePicker.kt:1921)");
            }
            boolean z18 = (29360128 & i10) == 8388608;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z18 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new k() { // from class: androidx.compose.material3.DatePickerKt$Day$1$1
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
                        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(str, null, null, 6, null));
                        SemanticsPropertiesKt.m6100setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m6081getButtono7Vup1c());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, true, (k) objRememberedValue);
            DatePickerModalTokens datePickerModalTokens = DatePickerModalTokens.INSTANCE;
            Shape value = ShapesKt.getValue(datePickerModalTokens.getDateContainerShape(), composerStartRestartGroup, 6);
            int i11 = i10 >> 3;
            int i12 = i10 >> 15;
            long jM4149unboximpl = datePickerColors2.dayContainerColor$material3_release(z10, z16, z15, composerStartRestartGroup, (i12 & 7168) | (i11 & 14) | ((i10 >> 9) & 112) | (i11 & 896)).getValue().m4149unboximpl();
            int i13 = i10 >> 12;
            SurfaceKt.m2315Surfaced85dljk(z10, aVar, modifierSemantics, z12, value, jM4149unboximpl, datePickerColors.dayContentColor$material3_release(z13, z10, z17, z12, composerStartRestartGroup, (i12 & 14) | (i10 & 112) | (i13 & 896) | (i11 & 7168) | (i13 & 57344)).getValue().m4149unboximpl(), 0.0f, 0.0f, (!z13 || z10) ? null : BorderStrokeKt.m268BorderStrokecXLIe8U(datePickerModalTokens.m2923getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.getTodayDateBorderColor()), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-2031780827, true, new n() { // from class: androidx.compose.material3.DatePickerKt.Day.2
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
                public final void invoke(Composer composer2, int i14) {
                    if ((i14 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2031780827, i14, -1, "androidx.compose.material3.Day.<anonymous> (DatePicker.kt:1960)");
                    }
                    Modifier.Companion companion = Modifier.INSTANCE;
                    DatePickerModalTokens datePickerModalTokens2 = DatePickerModalTokens.INSTANCE;
                    Modifier modifierM739requiredSizeVpY3zN4 = SizeKt.m739requiredSizeVpY3zN4(companion, datePickerModalTokens2.m2922getDateStateLayerWidthD9Ej5fM(), datePickerModalTokens2.m2921getDateStateLayerHeightD9Ej5fM());
                    Alignment center = Alignment.INSTANCE.getCenter();
                    n nVar2 = nVar;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM739requiredSizeVpY3zN4);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    S7.a constructor = companion2.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer2);
                    n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
                    if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    if (androidx.appfunctions.metadata.a.C(nVar2, composer2, 0)) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i11 & 7294, 48, 1408);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DatePickerKt.Day.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i14) {
                    DatePickerKt.Day(modifier, z10, aVar, z11, z12, z13, z14, str, datePickerColors, nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: DisplayModeToggleButton-tER2X8s, reason: not valid java name */
    public static final void m1775DisplayModeToggleButtontER2X8s(Modifier modifier, final int i, final k kVar, Composer composer, final int i6) {
        int i10;
        boolean z10;
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1393846115);
        if ((i6 & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i10 = i6;
        }
        if ((i6 & 48) == 0) {
            i10 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(kVar) ? 256 : 128;
        }
        if ((i10 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1393846115, i10, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1355)");
            }
            if (DisplayMode.m1818equalsimpl0(i, DisplayMode.INSTANCE.m1823getPickerjFl4v0())) {
                composerStartRestartGroup.startReplaceGroup(-411460444);
                z10 = (i10 & 896) == 256;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new S7.a() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$1$1
                        {
                            super(0);
                        }

                        @Override // S7.a
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1783invoke();
                            return r.f317a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m1783invoke() {
                            kVar.invoke(DisplayMode.m1815boximpl(DisplayMode.INSTANCE.m1822getInputjFl4v0()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                modifier2 = modifier;
                IconButtonKt.IconButton((S7.a) objRememberedValue, modifier2, false, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m1706getLambda1$material3_release(), composerStartRestartGroup, ((i10 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-411178437);
                z10 = (i10 & 896) == 256;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z10 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new S7.a() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$2$1
                        {
                            super(0);
                        }

                        @Override // S7.a
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1784invoke();
                            return r.f317a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m1784invoke() {
                            kVar.invoke(DisplayMode.m1815boximpl(DisplayMode.INSTANCE.m1823getPickerjFl4v0()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                modifier2 = modifier;
                IconButtonKt.IconButton((S7.a) objRememberedValue2, modifier2, false, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m1707getLambda2$material3_release(), composerStartRestartGroup, ((i10 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$3
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
                    DatePickerKt.m1775DisplayModeToggleButtontER2X8s(modifier2, i, kVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void HorizontalMonthsList(LazyListState lazyListState, final Long l, final k kVar, final k kVar2, final CalendarModel calendarModel, final f fVar, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i6;
        Long l5;
        final k kVar3;
        SelectableDates selectableDates2;
        DatePickerColors datePickerColors2;
        Object datePickerKt$HorizontalMonthsList$2$1;
        final LazyListState lazyListState2 = lazyListState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1994757941);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(lazyListState2) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            l5 = l;
            i6 |= composerStartRestartGroup.changed(l5) ? 32 : 16;
        } else {
            l5 = l;
        }
        if ((i & 384) == 0) {
            kVar3 = kVar;
            i6 |= composerStartRestartGroup.changedInstance(kVar3) ? 256 : 128;
        } else {
            kVar3 = kVar;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(kVar2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(calendarModel) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(fVar) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i6 |= (2097152 & i) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            selectableDates2 = selectableDates;
            i6 |= composerStartRestartGroup.changed(selectableDates2) ? 8388608 : 4194304;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((100663296 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i6 |= composerStartRestartGroup.changed(datePickerColors2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((38347923 & i6) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1994757941, i6, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1636)");
            }
            final CalendarDate today = calendarModel.getToday();
            boolean zChanged = composerStartRestartGroup.changed(fVar);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = calendarModel.getMonth(fVar.f1569a, 1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CalendarMonth calendarMonth = (CalendarMonth) objRememberedValue;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            final SelectableDates selectableDates3 = selectableDates2;
            final Long l9 = l5;
            int i10 = i6;
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1504086906, true, new n() { // from class: androidx.compose.material3.DatePickerKt.HorizontalMonthsList.1
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
                public final void invoke(Composer composer2, int i11) {
                    if ((i11 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1504086906, i11, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous> (DatePicker.kt:1646)");
                    }
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new k() { // from class: androidx.compose.material3.DatePickerKt.HorizontalMonthsList.1.1
                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return r.f317a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new S7.a() { // from class: androidx.compose.material3.DatePickerKt.HorizontalMonthsList.1.1.1
                                @Override // S7.a
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, new S7.a() { // from class: androidx.compose.material3.DatePickerKt.HorizontalMonthsList.1.1.2
                                @Override // S7.a
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, false, 4, null));
                        }
                    }, 1, null);
                    LazyListState lazyListState3 = lazyListState2;
                    FlingBehavior flingBehaviorRememberSnapFlingBehavior$material3_release = DatePickerDefaults.INSTANCE.rememberSnapFlingBehavior$material3_release(lazyListState3, null, composer2, 384, 2);
                    boolean zChangedInstance = composer2.changedInstance(fVar) | composer2.changedInstance(calendarModel) | composer2.changed(calendarMonth) | composer2.changed(kVar3) | composer2.changed(today) | composer2.changed(l9) | composer2.changedInstance(datePickerFormatter) | composer2.changed(selectableDates3) | composer2.changed(datePickerColors3);
                    final f fVar2 = fVar;
                    final CalendarModel calendarModel2 = calendarModel;
                    final CalendarMonth calendarMonth2 = calendarMonth;
                    final k kVar4 = kVar3;
                    final CalendarDate calendarDate = today;
                    final Long l10 = l9;
                    final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                    final SelectableDates selectableDates4 = selectableDates3;
                    final DatePickerColors datePickerColors4 = datePickerColors3;
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        k kVar5 = new k() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((LazyListScope) obj);
                                return r.f317a;
                            }

                            public final void invoke(LazyListScope lazyListScope) {
                                int iNumberOfMonthsInRange = DatePickerKt.numberOfMonthsInRange(fVar2);
                                final CalendarModel calendarModel3 = calendarModel2;
                                final CalendarMonth calendarMonth3 = calendarMonth2;
                                final k kVar6 = kVar4;
                                final CalendarDate calendarDate2 = calendarDate;
                                final Long l11 = l10;
                                final DatePickerFormatter datePickerFormatter3 = datePickerFormatter2;
                                final SelectableDates selectableDates5 = selectableDates4;
                                final DatePickerColors datePickerColors5 = datePickerColors4;
                                LazyListScope.items$default(lazyListScope, iNumberOfMonthsInRange, null, null, ComposableLambdaKt.composableLambdaInstance(1137566309, true, new p() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // S7.p
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                        return r.f317a;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(LazyItemScope lazyItemScope, int i12, Composer composer3, int i13) {
                                        int i14;
                                        if ((i13 & 6) == 0) {
                                            i14 = i13 | (composer3.changed(lazyItemScope) ? 4 : 2);
                                        } else {
                                            i14 = i13;
                                        }
                                        if ((i13 & 48) == 0) {
                                            i14 |= composer3.changed(i12) ? 32 : 16;
                                        }
                                        if ((i14 & 147) == 146 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1137566309, i14, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1658)");
                                        }
                                        CalendarMonth calendarMonthPlusMonths = calendarModel3.plusMonths(calendarMonth3, i12);
                                        Modifier modifierFillParentMaxWidth$default = LazyItemScope.fillParentMaxWidth$default(lazyItemScope, Modifier.INSTANCE, 0.0f, 1, null);
                                        k kVar7 = kVar6;
                                        CalendarDate calendarDate3 = calendarDate2;
                                        Long l12 = l11;
                                        DatePickerFormatter datePickerFormatter4 = datePickerFormatter3;
                                        SelectableDates selectableDates6 = selectableDates5;
                                        DatePickerColors datePickerColors6 = datePickerColors5;
                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierFillParentMaxWidth$default);
                                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                        S7.a constructor = companion.getConstructor();
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
                                        n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
                                        if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
                                        }
                                        Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        DatePickerKt.Month(calendarMonthPlusMonths, kVar7, calendarDate3.getUtcTimeMillis(), l12, null, null, datePickerFormatter4, selectableDates6, datePickerColors6, composer3, 221184);
                                        composer3.endNode();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), 6, null);
                            }
                        };
                        composer2.updateRememberedValue(kVar5);
                        objRememberedValue2 = kVar5;
                    }
                    LazyDslKt.LazyRow(modifierSemantics$default, lazyListState3, null, false, null, null, flingBehaviorRememberSnapFlingBehavior$material3_release, false, (k) objRememberedValue2, composer2, 0, 188);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            int i11 = i10 & 14;
            boolean zChangedInstance = (i11 == 4) | ((i10 & 7168) == 2048) | composerStartRestartGroup.changedInstance(calendarModel) | composerStartRestartGroup.changedInstance(fVar);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                lazyListState2 = lazyListState;
                datePickerKt$HorizontalMonthsList$2$1 = new DatePickerKt$HorizontalMonthsList$2$1(lazyListState2, kVar2, calendarModel, fVar, null);
                composerStartRestartGroup.updateRememberedValue(datePickerKt$HorizontalMonthsList$2$1);
            } else {
                datePickerKt$HorizontalMonthsList$2$1 = objRememberedValue2;
                lazyListState2 = lazyListState;
            }
            EffectsKt.LaunchedEffect(lazyListState2, (n) datePickerKt$HorizontalMonthsList$2$1, composerStartRestartGroup, i11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DatePickerKt.HorizontalMonthsList.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i12) {
                    DatePickerKt.HorizontalMonthsList(lazyListState2, l, kVar, kVar2, calendarModel, fVar, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x042a  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Month(final androidx.compose.material3.internal.CalendarMonth r30, final S7.k r31, final long r32, final java.lang.Long r34, final java.lang.Long r35, final androidx.compose.material3.SelectedRangeInfo r36, final androidx.compose.material3.DatePickerFormatter r37, final androidx.compose.material3.SelectableDates r38, final androidx.compose.material3.DatePickerColors r39, androidx.compose.runtime.Composer r40, final int r41) {
        /*
            Method dump skipped, instructions count: 1098
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.Month(androidx.compose.material3.internal.CalendarMonth, S7.k, long, java.lang.Long, java.lang.Long, androidx.compose.material3.SelectedRangeInfo, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.SelectableDates, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MonthsNavigation(final Modifier modifier, final boolean z10, final boolean z11, final boolean z12, final String str, final S7.a aVar, final S7.a aVar2, final S7.a aVar3, DatePickerColors datePickerColors, Composer composer, final int i) {
        int i6;
        S7.a aVar4;
        DatePickerColors datePickerColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-773929258);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(z12) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(aVar) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(aVar2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            aVar4 = aVar3;
            i6 |= composerStartRestartGroup.changedInstance(aVar4) ? 8388608 : 4194304;
        } else {
            aVar4 = aVar3;
        }
        if ((100663296 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i6 |= composerStartRestartGroup.changed(datePickerColors2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((38347923 & i6) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773929258, i6, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:2130)");
            }
            Modifier modifierM734requiredHeight3ABfNKs = SizeKt.m734requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), MonthYearHeight);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(z12 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM734requiredHeight3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            S7.a constructor = companion.getConstructor();
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyRowMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            final S7.a aVar5 = aVar4;
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4129boximpl(datePickerColors2.getNavigationContentColor())), ComposableLambdaKt.rememberComposableLambda(-962805198, true, new n() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1
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
                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-962805198, i10, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous> (DatePicker.kt:2143)");
                    }
                    S7.a aVar6 = aVar5;
                    boolean z13 = z12;
                    final String str2 = str;
                    DatePickerKt.YearPickerMenuButton(aVar6, z13, null, ComposableLambdaKt.rememberComposableLambda(1377272806, true, new n() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1.1
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
                                ComposerKt.traceEventStart(1377272806, i11, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2147)");
                            }
                            String str3 = str2;
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            boolean zChanged = composer3.changed(str3);
                            final String str4 = str2;
                            Object objRememberedValue = composer3.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new k() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1$1$1$1
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
                                        SemanticsPropertiesKt.m6099setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m6073getPolite0phEisY());
                                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str4);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            TextKt.m2464Text4IGK_g(str3, SemanticsModifierKt.semantics$default(companion2, false, (k) objRememberedValue, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (k) null, (TextStyle) null, composer3, 0, 0, 131068);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 3072, 4);
                    if (!z12) {
                        S7.a aVar7 = aVar2;
                        boolean z14 = z11;
                        S7.a aVar8 = aVar;
                        boolean z15 = z10;
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion2);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                        S7.a constructor2 = companion3.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM3474constructorimpl2 = Updater.m3474constructorimpl(composer2);
                        n nVarG2 = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl2, measurePolicyRowMeasurePolicy2, composerM3474constructorimpl2, currentCompositionLocalMap2);
                        if (composerM3474constructorimpl2.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
                        }
                        Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        ComposableSingletons$DatePickerKt composableSingletons$DatePickerKt = ComposableSingletons$DatePickerKt.INSTANCE;
                        IconButtonKt.IconButton(aVar7, null, z14, null, null, composableSingletons$DatePickerKt.m1708getLambda3$material3_release(), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                        IconButtonKt.IconButton(aVar8, null, z15, null, null, composableSingletons$DatePickerKt.m1709getLambda4$material3_release(), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                        composer2.endNode();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final DatePickerColors datePickerColors3 = datePickerColors2;
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DatePickerKt.MonthsNavigation.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    DatePickerKt.MonthsNavigation(modifier, z10, z11, z12, str, aVar, aVar2, aVar3, datePickerColors3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: SwitchableDateEntryContent-d7iavvg, reason: not valid java name */
    public static final void m1776SwitchableDateEntryContentd7iavvg(final Long l, final long j5, final int i, final k kVar, final k kVar2, final CalendarModel calendarModel, final f fVar, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i6) {
        int i10;
        k kVar3;
        k kVar4;
        CalendarModel calendarModel2;
        f fVar2;
        SelectableDates selectableDates2;
        DatePickerColors datePickerColors2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-895379221);
        if ((i6 & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i6;
        } else {
            i10 = i6;
        }
        if ((i6 & 48) == 0) {
            i10 |= composerStartRestartGroup.changed(j5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i10 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            kVar3 = kVar;
            i10 |= composerStartRestartGroup.changedInstance(kVar3) ? 2048 : 1024;
        } else {
            kVar3 = kVar;
        }
        if ((i6 & 24576) == 0) {
            kVar4 = kVar2;
            i10 |= composerStartRestartGroup.changedInstance(kVar4) ? 16384 : 8192;
        } else {
            kVar4 = kVar2;
        }
        if ((196608 & i6) == 0) {
            calendarModel2 = calendarModel;
            i10 |= composerStartRestartGroup.changedInstance(calendarModel2) ? 131072 : 65536;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((1572864 & i6) == 0) {
            fVar2 = fVar;
            i10 |= composerStartRestartGroup.changedInstance(fVar2) ? 1048576 : 524288;
        } else {
            fVar2 = fVar;
        }
        if ((12582912 & i6) == 0) {
            i10 |= (16777216 & i6) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i6) == 0) {
            selectableDates2 = selectableDates;
            i10 |= composerStartRestartGroup.changed(selectableDates2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((805306368 & i6) == 0) {
            datePickerColors2 = datePickerColors;
            i10 |= composerStartRestartGroup.changed(datePickerColors2) ? 536870912 : 268435456;
        } else {
            datePickerColors2 = datePickerColors;
        }
        int i11 = i10;
        if ((306783379 & i11) == 306783378 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-895379221, i11, -1, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1390)");
            }
            final int i12 = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo375roundToPx0680j_4(Dp.m6844constructorimpl(48));
            DisplayMode displayModeM1815boximpl = DisplayMode.m1815boximpl(i);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new k() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return r.f317a;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                }
            }, 1, null);
            boolean zChanged = composerStartRestartGroup.changed(i12);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new k() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public final ContentTransform invoke(AnimatedContentTransitionScope<DisplayMode> animatedContentTransitionScope) {
                        ContentTransform contentTransform;
                        if (DisplayMode.m1818equalsimpl0(animatedContentTransitionScope.getTargetState().getValue(), DisplayMode.INSTANCE.m1822getInputjFl4v0())) {
                            EnterTransition enterTransitionPlus = EnterExitTransitionKt.slideInVertically$default(null, new k() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.1
                                public final Integer invoke(int i13) {
                                    return Integer.valueOf(i13);
                                }

                                @Override // S7.k
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }
                            }, 1, null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(100, 100, null, 4, null), 0.0f, 2, null));
                            ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, 2, null);
                            final int i13 = i12;
                            contentTransform = AnimatedContentKt.togetherWith(enterTransitionPlus, exitTransitionFadeOut$default.plus(EnterExitTransitionKt.slideOutVertically$default(null, new k() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final Integer invoke(int i14) {
                                    return Integer.valueOf(i13);
                                }

                                @Override // S7.k
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }
                            }, 1, null)));
                        } else {
                            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(0, 50, null, 5, null);
                            final int i14 = i12;
                            contentTransform = AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(tweenSpecTween$default, new k() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // S7.k
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }

                                public final Integer invoke(int i15) {
                                    return Integer.valueOf(i14);
                                }
                            }).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(100, 100, null, 4, null), 0.0f, 2, null)), EnterExitTransitionKt.slideOutVertically$default(null, new k() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.4
                                public final Integer invoke(int i15) {
                                    return Integer.valueOf(i15);
                                }

                                @Override // S7.k
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }
                            }, 1, null).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, 2, null)));
                        }
                        return animatedContentTransitionScope.using(contentTransform, AnimatedContentKt.SizeTransform(true, new n() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.5
                            @Override // S7.n
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m1786invokeTemP2vQ(((IntSize) obj).m7019unboximpl(), ((IntSize) obj2).m7019unboximpl());
                            }

                            /* renamed from: invoke-TemP2vQ, reason: not valid java name */
                            public final FiniteAnimationSpec<IntSize> m1786invokeTemP2vQ(long j6, long j10) {
                                return AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier(), 2, null);
                            }
                        }));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final k kVar5 = kVar3;
            final k kVar6 = kVar4;
            final CalendarModel calendarModel3 = calendarModel2;
            final f fVar3 = fVar2;
            final SelectableDates selectableDates3 = selectableDates2;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            composer2 = composerStartRestartGroup;
            AnimatedContentKt.AnimatedContent(displayModeM1815boximpl, modifierSemantics$default, (k) objRememberedValue, null, "DatePickerDisplayModeAnimation", null, ComposableLambdaKt.rememberComposableLambda(-459778869, true, new p() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // S7.p
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    m1787invokefYndouo((AnimatedContentScope) obj, ((DisplayMode) obj2).getValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                /* renamed from: invoke-fYndouo, reason: not valid java name */
                public final void m1787invokefYndouo(AnimatedContentScope animatedContentScope, int i13, Composer composer3, int i14) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-459778869, i14, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DatePicker.kt:1446)");
                    }
                    DisplayMode.Companion companion = DisplayMode.INSTANCE;
                    if (DisplayMode.m1818equalsimpl0(i13, companion.m1823getPickerjFl4v0())) {
                        composer3.startReplaceGroup(-1870124677);
                        DatePickerKt.DatePickerContent(l, j5, kVar5, kVar6, calendarModel3, fVar3, datePickerFormatter, selectableDates3, datePickerColors3, composer3, 0);
                        composer3.endReplaceGroup();
                    } else if (DisplayMode.m1818equalsimpl0(i13, companion.m1822getInputjFl4v0())) {
                        composer3.startReplaceGroup(-1870106124);
                        DateInputKt.DateInputContent(l, kVar5, calendarModel3, fVar3, datePickerFormatter, selectableDates3, datePickerColors3, composer3, 0);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-2138321635);
                        composer3.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, ((i11 >> 6) & 14) | 1597440, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i13) {
                    DatePickerKt.m1776SwitchableDateEntryContentd7iavvg(l, j5, i, kVar, kVar2, calendarModel, fVar, datePickerFormatter, selectableDates, datePickerColors, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v9 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void WeekDays(final DatePickerColors datePickerColors, final CalendarModel calendarModel, Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1849465391);
        int i6 = (i & 6) == 0 ? (composerStartRestartGroup.changed(datePickerColors) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(calendarModel) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849465391, i6, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1708)");
            }
            int firstDayOfWeek = calendarModel.getFirstDayOfWeek();
            List<Pair<String, String>> weekdayNames = calendarModel.getWeekdayNames();
            ArrayList arrayList = new ArrayList();
            int i10 = firstDayOfWeek - 1;
            int size = weekdayNames.size();
            for (int i11 = i10; i11 < size; i11++) {
                arrayList.add(weekdayNames.get(i11));
            }
            ?? r82 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                arrayList.add(weekdayNames.get(i12));
            }
            TextStyle value = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont(), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m730defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, RecommendedSizeForAccessibility, 1, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceEvenly(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            S7.a constructor = companion.getConstructor();
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyRowMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(396170355);
            int size2 = arrayList.size();
            int i13 = 0;
            while (i13 < size2) {
                final Pair pair = (Pair) arrayList.get(i13);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                boolean zChanged = composerStartRestartGroup.changed(pair);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new k() { // from class: androidx.compose.material3.DatePickerKt$WeekDays$1$1$1$1
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
                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, (String) pair.f4886a);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion2, (k) objRememberedValue);
                float f = RecommendedSizeForAccessibility;
                Modifier modifierM747sizeVpY3zN4 = SizeKt.m747sizeVpY3zN4(modifierClearAndSetSemantics, f, f);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), r82);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r82);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM747sizeVpY3zN4);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                S7.a constructor2 = companion3.getConstructor();
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
                n nVarG2 = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl2, currentCompositionLocalMap2);
                if (composerM3474constructorimpl2.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
                }
                Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Composer composer3 = composerStartRestartGroup;
                TextKt.m2464Text4IGK_g((String) pair.b, SizeKt.wrapContentSize$default(companion2, null, false, 3, null), datePickerColors.getWeekdayContentColor(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6721boximpl(TextAlign.INSTANCE.m6728getCentere0LSkKk()), 0L, 0, false, 0, 0, (k) null, value, composer3, 48, 0, 65016);
                composer3.endNode();
                i13++;
                composerStartRestartGroup = composer3;
                arrayList = arrayList;
                r82 = 0;
            }
            composer2 = composerStartRestartGroup;
            if (androidx.appfunctions.metadata.a.D(composer2)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DatePickerKt.WeekDays.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer4, int i14) {
                    DatePickerKt.WeekDays(datePickerColors, calendarModel, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Year(final Modifier modifier, final boolean z10, final boolean z11, final S7.a aVar, final boolean z12, final String str, final DatePickerColors datePickerColors, final n nVar, Composer composer, final int i) {
        int i6;
        Object objM268BorderStrokecXLIe8U;
        Composer composerStartRestartGroup = composer.startRestartGroup(238547184);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(aVar) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(z12) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(str) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(datePickerColors) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 8388608 : 4194304;
        }
        if ((4793491 & i6) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(238547184, i6, -1, "androidx.compose.material3.Year (DatePicker.kt:2077)");
            }
            int i10 = i6 & 112;
            boolean z13 = ((i6 & 896) == 256) | (i10 == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objM268BorderStrokecXLIe8U = (!z11 || z10) ? null : BorderStrokeKt.m268BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m2923getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.getTodayDateBorderColor());
                composerStartRestartGroup.updateRememberedValue(objM268BorderStrokecXLIe8U);
            } else {
                objM268BorderStrokecXLIe8U = objRememberedValue;
            }
            BorderStroke borderStroke = (BorderStroke) objM268BorderStrokecXLIe8U;
            boolean z14 = (458752 & i6) == 131072;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z14 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new k() { // from class: androidx.compose.material3.DatePickerKt$Year$1$1
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
                        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(str, null, null, 6, null));
                        SemanticsPropertiesKt.m6100setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m6081getButtono7Vup1c());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            int i11 = i6 >> 3;
            int i12 = i11 & 14;
            int i13 = i6 >> 9;
            int i14 = i6 >> 6;
            SurfaceKt.m2315Surfaced85dljk(z10, aVar, SemanticsModifierKt.semantics(modifier, true, (k) objRememberedValue2), z12, ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearStateLayerShape(), composerStartRestartGroup, 6), datePickerColors.yearContainerColor$material3_release(z10, z12, composerStartRestartGroup, i12 | (i13 & 112) | ((i6 >> 12) & 896)).getValue().m4149unboximpl(), datePickerColors.yearContentColor$material3_release(z11, z10, z12, composerStartRestartGroup, (i14 & 14) | i10 | (i14 & 896) | (i13 & 7168)).getValue().m4149unboximpl(), 0.0f, 0.0f, borderStroke, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1573188346, true, new n() { // from class: androidx.compose.material3.DatePickerKt.Year.2
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
                        ComposerKt.traceEventStart(-1573188346, i15, -1, "androidx.compose.material3.Year.<anonymous> (DatePicker.kt:2110)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    n nVar2 = nVar;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    S7.a constructor = companion.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer2);
                    n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
                    if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    if (androidx.appfunctions.metadata.a.C(nVar2, composer2, 0)) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i12 | (i14 & 112) | (i11 & 7168), 48, 1408);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DatePickerKt.Year.3
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
                    DatePickerKt.Year(modifier, z10, z11, aVar, z12, str, datePickerColors, nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void YearPicker(final Modifier modifier, final long j5, final k kVar, final SelectableDates selectableDates, final CalendarModel calendarModel, final f fVar, final DatePickerColors datePickerColors, Composer composer, final int i) {
        Modifier modifier2;
        int i6;
        k kVar2;
        SelectableDates selectableDates2;
        CalendarModel calendarModel2;
        f fVar2;
        DatePickerColors datePickerColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1286899812);
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
            kVar2 = kVar;
            i6 |= composerStartRestartGroup.changedInstance(kVar2) ? 256 : 128;
        } else {
            kVar2 = kVar;
        }
        if ((i & 3072) == 0) {
            selectableDates2 = selectableDates;
            i6 |= composerStartRestartGroup.changed(selectableDates2) ? 2048 : 1024;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i & 24576) == 0) {
            calendarModel2 = calendarModel;
            i6 |= composerStartRestartGroup.changedInstance(calendarModel2) ? 16384 : 8192;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((196608 & i) == 0) {
            fVar2 = fVar;
            i6 |= composerStartRestartGroup.changedInstance(fVar2) ? 131072 : 65536;
        } else {
            fVar2 = fVar;
        }
        if ((1572864 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i6 |= composerStartRestartGroup.changed(datePickerColors2) ? 1048576 : 524288;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((599187 & i6) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1286899812, i6, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:1983)");
            }
            final Modifier modifier3 = modifier2;
            final k kVar3 = kVar2;
            final SelectableDates selectableDates3 = selectableDates2;
            final CalendarModel calendarModel3 = calendarModel2;
            final f fVar3 = fVar2;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1301915789, true, new n() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1
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
                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1301915789, i10, -1, "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:1985)");
                    }
                    CalendarModel calendarModel4 = calendarModel3;
                    final int year = calendarModel4.getMonth(calendarModel4.getToday()).getYear();
                    final int year2 = calendarModel3.getMonth(j5).getYear();
                    final LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(Math.max(0, (year2 - fVar3.f1569a) - 3), 0, composer2, 0, 2);
                    long containerColor = datePickerColors3.getContainerColor();
                    Object objRememberedValue = composer2.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = B7.a.e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.f4908a, composer2), composer2);
                    }
                    final InterfaceC1733z coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    Strings.Companion companion2 = Strings.INSTANCE;
                    final String strM2752getString2EP1pXo = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_picker_scroll_to_earlier_years), composer2, 0);
                    final String strM2752getString2EP1pXo2 = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_picker_scroll_to_later_years), composer2, 0);
                    GridCells.Fixed fixed = new GridCells.Fixed(3);
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(BackgroundKt.m239backgroundbw27NRU$default(modifier3, containerColor, null, 2, null), false, new k() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.1
                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return r.f317a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new S7.a() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.1.1
                                @Override // S7.a
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, new S7.a() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.1.2
                                @Override // S7.a
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, false, 4, null));
                        }
                    }, 1, null);
                    Arrangement arrangement = Arrangement.INSTANCE;
                    Arrangement.HorizontalOrVertical spaceEvenly = arrangement.getSpaceEvenly();
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM580spacedBy0680j_4 = arrangement.m580spacedBy0680j_4(DatePickerKt.YearsVerticalPadding);
                    boolean zChangedInstance = composer2.changedInstance(fVar3) | composer2.changed(lazyGridStateRememberLazyGridState) | composer2.changedInstance(coroutineScope) | composer2.changed(strM2752getString2EP1pXo) | composer2.changed(strM2752getString2EP1pXo2) | composer2.changed(year2) | composer2.changed(year) | composer2.changed(kVar3) | composer2.changed(selectableDates3) | composer2.changed(datePickerColors3);
                    final f fVar4 = fVar3;
                    final k kVar4 = kVar3;
                    final SelectableDates selectableDates4 = selectableDates3;
                    final DatePickerColors datePickerColors4 = datePickerColors3;
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                        Object obj = new k() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((LazyGridScope) obj2);
                                return r.f317a;
                            }

                            public final void invoke(LazyGridScope lazyGridScope) {
                                int size;
                                Iterable iterable = fVar4;
                                kotlin.jvm.internal.k.f(iterable, "<this>");
                                if (iterable instanceof Collection) {
                                    size = ((Collection) iterable).size();
                                } else {
                                    Iterator it = iterable.iterator();
                                    size = 0;
                                    while (it.hasNext()) {
                                        it.next();
                                        size++;
                                        if (size < 0) {
                                            o.W();
                                            throw null;
                                        }
                                    }
                                }
                                final f fVar5 = fVar4;
                                final LazyGridState lazyGridState = lazyGridStateRememberLazyGridState;
                                final InterfaceC1733z interfaceC1733z = coroutineScope;
                                final String str = strM2752getString2EP1pXo;
                                final String str2 = strM2752getString2EP1pXo2;
                                final int i11 = year2;
                                final int i12 = year;
                                final k kVar5 = kVar4;
                                final SelectableDates selectableDates5 = selectableDates4;
                                final DatePickerColors datePickerColors5 = datePickerColors4;
                                LazyGridScope.items$default(lazyGridScope, size, null, null, null, ComposableLambdaKt.composableLambdaInstance(1040623618, true, new p() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // S7.p
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                        invoke((LazyGridItemScope) obj2, ((Number) obj3).intValue(), (Composer) obj4, ((Number) obj5).intValue());
                                        return r.f317a;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(LazyGridItemScope lazyGridItemScope, final int i13, Composer composer3, int i14) {
                                        int i15;
                                        Modifier modifier4;
                                        boolean z10;
                                        Modifier modifier5;
                                        boolean z11;
                                        if ((i14 & 48) == 0) {
                                            i15 = i14 | (composer3.changed(i13) ? 32 : 16);
                                        } else {
                                            i15 = i14;
                                        }
                                        if ((i15 & 145) == 144 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1040623618, i15, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2014)");
                                        }
                                        final int i16 = i13 + fVar5.f1569a;
                                        final String localString$default = CalendarLocale_jvmKt.toLocalString$default(i16, 0, 0, false, 7, null);
                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                        DatePickerModalTokens datePickerModalTokens = DatePickerModalTokens.INSTANCE;
                                        Modifier modifierM739requiredSizeVpY3zN4 = SizeKt.m739requiredSizeVpY3zN4(companion3, datePickerModalTokens.m2930getSelectionYearContainerWidthD9Ej5fM(), datePickerModalTokens.m2929getSelectionYearContainerHeightD9Ej5fM());
                                        boolean zChanged = ((i15 & 112) == 32) | composer3.changed(lazyGridState) | composer3.changedInstance(interfaceC1733z) | composer3.changed(str) | composer3.changed(str2);
                                        final LazyGridState lazyGridState2 = lazyGridState;
                                        final InterfaceC1733z interfaceC1733z2 = interfaceC1733z;
                                        final String str3 = str;
                                        final String str4 = str2;
                                        Object objRememberedValue3 = composer3.rememberedValue();
                                        if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            k kVar6 = new k() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // S7.k
                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                    invoke((SemanticsPropertyReceiver) obj2);
                                                    return r.f317a;
                                                }

                                                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    LazyGridItemInfo lazyGridItemInfo;
                                                    SemanticsPropertiesKt.setCustomActions(semanticsPropertyReceiver, (lazyGridState2.getFirstVisibleItemIndex() == i13 || ((lazyGridItemInfo = (LazyGridItemInfo) v.L0(lazyGridState2.getLayoutInfo().getVisibleItemsInfo())) != null && lazyGridItemInfo.getIndex() == i13)) ? DatePickerKt.customScrollActions(lazyGridState2, interfaceC1733z2, str3, str4) : EmptyList.f4893a);
                                                }
                                            };
                                            composer3.updateRememberedValue(kVar6);
                                            objRememberedValue3 = kVar6;
                                        }
                                        Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierM739requiredSizeVpY3zN4, false, (k) objRememberedValue3, 1, null);
                                        if (i16 == i11) {
                                            modifier4 = modifierSemantics$default2;
                                            z10 = true;
                                        } else {
                                            modifier4 = modifierSemantics$default2;
                                            z10 = false;
                                        }
                                        if (i16 == i12) {
                                            modifier5 = modifier4;
                                            z11 = true;
                                        } else {
                                            modifier5 = modifier4;
                                            z11 = false;
                                        }
                                        boolean zChanged2 = composer3.changed(kVar5) | composer3.changed(i16);
                                        final k kVar7 = kVar5;
                                        Object objRememberedValue4 = composer3.rememberedValue();
                                        if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue4 = new S7.a() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // S7.a
                                                public /* bridge */ /* synthetic */ Object invoke() {
                                                    m1788invoke();
                                                    return r.f317a;
                                                }

                                                /* renamed from: invoke, reason: collision with other method in class */
                                                public final void m1788invoke() {
                                                    kVar7.invoke(Integer.valueOf(i16));
                                                }
                                            };
                                            composer3.updateRememberedValue(objRememberedValue4);
                                        }
                                        boolean zIsSelectableYear = selectableDates5.isSelectableYear(i16);
                                        Strings.Companion companion4 = Strings.INSTANCE;
                                        DatePickerKt.Year(modifier5, z10, z11, (S7.a) objRememberedValue4, zIsSelectableYear, String.format(Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_picker_navigate_to_year_description), composer3, 0), Arrays.copyOf(new Object[]{localString$default}, 1)), datePickerColors5, ComposableLambdaKt.rememberComposableLambda(882189459, true, new n() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.2.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // S7.n
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                                invoke((Composer) obj2, ((Number) obj3).intValue());
                                                return r.f317a;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(Composer composer4, int i17) {
                                                if ((i17 & 3) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(882189459, i17, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2054)");
                                                }
                                                TextKt.m2464Text4IGK_g(localString$default, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new k() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.2.1.1.3.1
                                                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    }

                                                    @Override // S7.k
                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                        invoke((SemanticsPropertyReceiver) obj2);
                                                        return r.f317a;
                                                    }
                                                }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6721boximpl(TextAlign.INSTANCE.m6728getCentere0LSkKk()), 0L, 0, false, 0, 0, (k) null, (TextStyle) null, composer4, 0, 0, 130556);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer3, 54), composer3, 12582912);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), 14, null);
                            }
                        };
                        composer2.updateRememberedValue(obj);
                        objRememberedValue2 = obj;
                    }
                    LazyGridDslKt.LazyVerticalGrid(fixed, modifierSemantics$default, lazyGridStateRememberLazyGridState, null, false, horizontalOrVerticalM580spacedBy0680j_4, spaceEvenly, null, false, (k) objRememberedValue2, composer2, 1769472, McpErrorCode.TIMEOUT);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    DatePickerKt.YearPicker(modifier, j5, kVar, selectableDates, calendarModel, fVar, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void YearPickerMenuButton(final S7.a r19, final boolean r20, androidx.compose.ui.Modifier r21, final S7.n r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.YearPickerMenuButton(S7.a, boolean, androidx.compose.ui.Modifier, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(final LazyGridState lazyGridState, final InterfaceC1733z interfaceC1733z, String str, String str2) {
        return o.N(new CustomAccessibilityAction(str, new S7.a() { // from class: androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1

            @J7.c(c = "androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1$1", f = "DatePicker.kt", l = {2222}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1$1, reason: invalid class name */
            public static final class AnonymousClass1 extends SuspendLambda implements n {
                final /* synthetic */ LazyGridState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(LazyGridState lazyGridState, H7.c<? super AnonymousClass1> cVar) {
                    super(2, cVar);
                    this.$state = lazyGridState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    return new AnonymousClass1(this.$state, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    int i = this.label;
                    if (i == 0) {
                        kotlin.b.b(obj);
                        LazyGridState lazyGridState = this.$state;
                        int firstVisibleItemIndex = lazyGridState.getFirstVisibleItemIndex() - 3;
                        this.label = 1;
                        if (LazyGridState.scrollToItem$default(lazyGridState, firstVisibleItemIndex, 0, this, 2, null) == coroutineSingletons) {
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
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() {
                boolean z10;
                if (lazyGridState.getCanScrollBackward()) {
                    AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(lazyGridState, null), 3);
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }), new CustomAccessibilityAction(str2, new S7.a() { // from class: androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1

            @J7.c(c = "androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1$1", f = "DatePicker.kt", l = {2230}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1$1, reason: invalid class name */
            public static final class AnonymousClass1 extends SuspendLambda implements n {
                final /* synthetic */ LazyGridState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(LazyGridState lazyGridState, H7.c<? super AnonymousClass1> cVar) {
                    super(2, cVar);
                    this.$state = lazyGridState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    return new AnonymousClass1(this.$state, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    int i = this.label;
                    if (i == 0) {
                        kotlin.b.b(obj);
                        LazyGridState lazyGridState = this.$state;
                        int firstVisibleItemIndex = lazyGridState.getFirstVisibleItemIndex() + 3;
                        this.label = 1;
                        if (LazyGridState.scrollToItem$default(lazyGridState, firstVisibleItemIndex, 0, this, 2, null) == coroutineSingletons) {
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
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() {
                boolean z10;
                if (lazyGridState.getCanScrollForward()) {
                    AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(lazyGridState, null), 3);
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }));
    }

    @Composable
    private static final String dayContentDescription(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(502032503, i, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1889)");
        }
        StringBuilder sb = new StringBuilder();
        composer.startReplaceGroup(-647758197);
        if (z10) {
            if (z12) {
                composer.startReplaceGroup(-647755172);
                Strings.Companion companion = Strings.INSTANCE;
                sb.append(Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_range_picker_start_headline), composer, 0));
                composer.endReplaceGroup();
            } else if (z13) {
                composer.startReplaceGroup(-647751174);
                Strings.Companion companion2 = Strings.INSTANCE;
                sb.append(Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_range_picker_end_headline), composer, 0));
                composer.endReplaceGroup();
            } else if (z14) {
                composer.startReplaceGroup(-647747239);
                Strings.Companion companion3 = Strings.INSTANCE;
                sb.append(Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_range_picker_day_in_range), composer, 0));
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1394740614);
                composer.endReplaceGroup();
            }
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(-647744489);
        if (z11) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            Strings.Companion companion4 = Strings.INSTANCE;
            sb.append(Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_date_picker_today_description), composer, 0));
        }
        composer.endReplaceGroup();
        String string = sb.length() == 0 ? null : sb.toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return string;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerModeTogglePadding;
    }

    public static final float getMonthYearHeight() {
        return MonthYearHeight;
    }

    public static final float getRecommendedSizeForAccessibility() {
        return RecommendedSizeForAccessibility;
    }

    public static final int numberOfMonthsInRange(f fVar) {
        return ((fVar.b - fVar.f1569a) + 1) * 12;
    }

    @Composable
    @ExperimentalMaterial3Api
    /* renamed from: rememberDatePickerState-EU0dCGE, reason: not valid java name */
    public static final DatePickerState m1778rememberDatePickerStateEU0dCGE(Long l, Long l5, f fVar, int i, SelectableDates selectableDates, Composer composer, int i6, int i10) {
        if ((i10 & 1) != 0) {
            l = null;
        }
        final Long l9 = l;
        final Long l10 = (i10 & 2) != 0 ? l9 : l5;
        if ((i10 & 4) != 0) {
            fVar = DatePickerDefaults.INSTANCE.getYearRange();
        }
        final f fVar2 = fVar;
        if ((i10 & 8) != 0) {
            i = DisplayMode.INSTANCE.m1823getPickerjFl4v0();
        }
        final int i11 = i;
        if ((i10 & 16) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        final SelectableDates selectableDates2 = selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2065763010, i6, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:364)");
        }
        final Locale localeDefaultLocale = CalendarLocale_androidKt.defaultLocale(composer, 0);
        Object[] objArr = new Object[0];
        Saver<DatePickerStateImpl, Object> Saver = DatePickerStateImpl.INSTANCE.Saver(selectableDates2, localeDefaultLocale);
        boolean zChangedInstance = ((((57344 & i6) ^ 24576) > 16384 && composer.changed(selectableDates2)) || (i6 & 24576) == 16384) | ((((i6 & 14) ^ 6) > 4 && composer.changed(l9)) || (i6 & 6) == 4) | ((((i6 & 112) ^ 48) > 32 && composer.changed(l10)) || (i6 & 48) == 32) | composer.changedInstance(fVar2) | ((((i6 & 7168) ^ 3072) > 2048 && composer.changed(i11)) || (i6 & 3072) == 2048) | composer.changedInstance(localeDefaultLocale);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object obj = new S7.a() { // from class: androidx.compose.material3.DatePickerKt$rememberDatePickerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final DatePickerStateImpl invoke() {
                    return new DatePickerStateImpl(l9, l10, fVar2, i11, selectableDates2, localeDefaultLocale, null);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue = obj;
        }
        DatePickerStateImpl datePickerStateImpl = (DatePickerStateImpl) RememberSaveableKt.m3591rememberSaveable(objArr, (Saver) Saver, (String) null, (S7.a) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return datePickerStateImpl;
    }

    public static final Object updateDisplayedMonth(final LazyListState lazyListState, final k kVar, final CalendarModel calendarModel, final f fVar, H7.c<? super r> cVar) {
        Object objCollect = SnapshotStateKt.snapshotFlow(new S7.a() { // from class: androidx.compose.material3.DatePickerKt.updateDisplayedMonth.2
            {
                super(0);
            }

            @Override // S7.a
            public final Integer invoke() {
                return Integer.valueOf(lazyListState.getFirstVisibleItemIndex());
            }
        }).collect(new d() { // from class: androidx.compose.material3.DatePickerKt.updateDisplayedMonth.3
            @Override // p9.d
            public /* bridge */ /* synthetic */ Object emit(Object obj, H7.c cVar2) {
                return emit(((Number) obj).intValue(), (H7.c<? super r>) cVar2);
            }

            public final Object emit(int i, H7.c<? super r> cVar2) {
                int firstVisibleItemIndex = lazyListState.getFirstVisibleItemIndex() / 12;
                kVar.invoke(new Long(calendarModel.getMonth(fVar.f1569a + firstVisibleItemIndex, (lazyListState.getFirstVisibleItemIndex() % 12) + 1).getStartUtcTimeMillis()));
                return r.f317a;
            }
        }, cVar);
        return objCollect == CoroutineSingletons.f4909a ? objCollect : r.f317a;
    }
}
