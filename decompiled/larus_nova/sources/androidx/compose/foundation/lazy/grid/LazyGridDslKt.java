package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.AVLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u008a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001a\u001a\u008a\u0001\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001d\u001a~\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001e\u001a\u001d\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010#\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0002\u001aÛ\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0%2%\b\n\u0010,\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001620\b\n\u00101\u001a*\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u000102¢\u0006\u0002\b\u00182%\b\n\u00105\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u000102¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u00109\u001a¯\u0002\u0010:\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0%2:\b\n\u0010,\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u0001022E\b\n\u00101\u001a?\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u00010<¢\u0006\u0002\b\u00182:\b\u0006\u00105\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u000100022H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010=\u001aÛ\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0>2%\b\n\u0010,\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001620\b\n\u00101\u001a*\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u000102¢\u0006\u0002\b\u00182%\b\n\u00105\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u000102¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010?\u001a¯\u0002\u0010:\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0>2:\b\n\u0010,\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u0001022E\b\n\u00101\u001a?\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u00010<¢\u0006\u0002\b\u00182:\b\u0006\u00105\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u000100022H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010@¨\u0006A"}, d2 = {"LazyVerticalGrid", "", "columns", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyHorizontalGrid", "rows", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnWidthSums", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "items", ExifInterface.GPS_DIRECTION_TRUE, "key", "Lkotlin/ParameterName;", "name", MapController.ITEM_LAYER_TAG, "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$10, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass10 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass10(Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r100, T[] r101) {
            this.$itemContent = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(LazyGridItemScope r100, int r101, Composer r102, int r103) {
            if ((r103 & 6) == 0) goto L5;
            int r104 = r103;
        L11:
            if ((r103 & 48) != 0) goto L18;
            if (r102.changed(r101) == false) goto L15;
            int r105 = 32;
        L16:
            r104 = r104 | r105;
            goto L18
        L15:
            r105 = 16;
        L18:
            if ((r104 & 147) == 146) goto L20;
            boolean r106 = true;
        L22:
            if (r102.shouldExecute(r106, r104 & 1) == true) goto L24;
            r102.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(1179065086, r104, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:613)");
        L26:
            this.$itemContent.invoke(r100, this.$items[r101], r102, Integer.valueOf(r104 & 14));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r106 = false;
            goto L22
        L5:
            if (r102.changed(r100) == false) goto L7;
            int r107 = 4;
        L8:
            r104 = r107 | r103;
            goto L11
        L7:
            r107 = 2;
            goto L8
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope r100, Integer r101, Composer r102, Integer r103) {
            invoke(r100, r101.intValue(), r102, r103.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass2 implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super T, ? extends Object> r100, List<? extends T> r101) {
            this.$key = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int r100) {
            return this.$key.invoke((T) ListProtector.get(this.$items, r100));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
            return invoke(r100.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass3 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> r100, List<? extends T> r101) {
            this.$span = r100;
            this.$items = r101;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope r100, Integer r101) {
            return GridItemSpan.m848boximpl(m857invoke_orMbw(r100, r101.intValue()));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m857invoke_orMbw(LazyGridItemSpanScope r100, int r101) {
            return this.$span.invoke(r100, (T) ListProtector.get(this.$items, r101)).m855unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$4, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass4 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Function1<? super T, ? extends Object> r100, List<? extends T> r101) {
            this.$contentType = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int r100) {
            return this.$contentType.invoke((T) ListProtector.get(this.$items, r100));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
            return invoke(r100.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$5, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass5 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r100, List<? extends T> r101) {
            this.$itemContent = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyGridItemScope r100, int r101, Composer r102, int r103) {
            if ((r103 & 6) == 0) goto L5;
            int r104 = r103;
        L11:
            if ((r103 & 48) != 0) goto L18;
            if (r102.changed(r101) == false) goto L15;
            int r105 = 32;
        L16:
            r104 = r104 | r105;
            goto L18
        L15:
            r105 = 16;
        L18:
            if ((r104 & 147) == 146) goto L20;
            boolean r106 = true;
        L22:
            if (r102.shouldExecute(r106, r104 & 1) == true) goto L24;
            r102.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(-1117249557, r104, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
        L26:
            Function4<LazyGridItemScope, T, Composer, Integer, Unit> r107 = this.$itemContent;
            Object r108 = ListProtector.get(this.$items, r101);
            T r109 = (T) r108;
            r107.invoke(r100, r109, r102, Integer.valueOf(r104 & 14));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r106 = false;
            goto L22
        L5:
            if (r102.changed(r100) == false) goto L7;
            int r110 = 4;
        L8:
            r104 = r110 | r103;
            goto L11
        L7:
            r110 = 2;
            goto L8
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope r100, Integer r101, Composer r102, Integer r103) {
            invoke(r100, r101.intValue(), r102, r103.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$7, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass7 implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function1<? super T, ? extends Object> r100, T[] r101) {
            this.$key = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int r100) {
            return this.$key.invoke(this.$items[r100]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
            return invoke(r100.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$8, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass8 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> r100, T[] r101) {
            this.$span = r100;
            this.$items = r101;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope r100, Integer r101) {
            return GridItemSpan.m848boximpl(m858invoke_orMbw(r100, r101.intValue()));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m858invoke_orMbw(LazyGridItemSpanScope r100, int r101) {
            return this.$span.invoke(r100, this.$items[r101]).m855unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$9, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass9 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass9(Function1<? super T, ? extends Object> r100, T[] r101) {
            this.$contentType = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int r100) {
            return this.$contentType.invoke(this.$items[r100]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
            return invoke(r100.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$10, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C861610 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C861610(Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r100, T[] r101) {
            this.$itemContent = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(LazyGridItemScope r110, int r111, Composer r112, int r113) {
            if ((r113 & 6) == 0) goto L5;
            int r100 = r113;
        L11:
            if ((r113 & 48) != 0) goto L18;
            if (r112.changed(r111) == false) goto L15;
            int r114 = 32;
        L16:
            r100 = r100 | r114;
            goto L18
        L15:
            r114 = 16;
        L18:
            if ((r100 & 147) == 146) goto L20;
            boolean r115 = true;
        L22:
            if (r112.shouldExecute(r115, r100 & 1) == true) goto L24;
            r112.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(49283819, r100, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:650)");
        L26:
            this.$itemContent.invoke(r110, Integer.valueOf(r111), this.$items[r111], r112, Integer.valueOf((r100 & 14) | (r100 & 112)));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r115 = false;
            goto L22
        L5:
            if (r112.changed(r110) == false) goto L7;
            int r101 = 4;
        L8:
            r100 = r101 | r113;
            goto L11
        L7:
            r101 = 2;
            goto L8
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope r100, Integer r101, Composer r102, Integer r103) {
            invoke(r100, r101.intValue(), r102, r103.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C86172 implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public C86172(Function2<? super Integer, ? super T, ? extends Object> r100, List<? extends T> r101) {
            this.$key = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int r100) {
            return this.$key.invoke(Integer.valueOf(r100), (T) ListProtector.get(this.$items, r100));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
            return invoke(r100.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C86183 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public C86183(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> r100, List<? extends T> r101) {
            this.$span = r100;
            this.$items = r101;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope r100, Integer r101) {
            return GridItemSpan.m848boximpl(m859invoke_orMbw(r100, r101.intValue()));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m859invoke_orMbw(LazyGridItemSpanScope r100, int r101) {
            return this.$span.invoke(r100, Integer.valueOf(r101), (T) ListProtector.get(this.$items, r101)).m855unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C86194 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C86194(Function2<? super Integer, ? super T, ? extends Object> r100, List<? extends T> r101) {
            this.$contentType = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int r100) {
            return this.$contentType.invoke(Integer.valueOf(r100), (T) ListProtector.get(this.$items, r100));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
            return invoke(r100.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$5, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C86205 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C86205(Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r100, List<? extends T> r101) {
            this.$itemContent = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyGridItemScope r110, int r111, Composer r112, int r113) {
            if ((r113 & 6) == 0) goto L5;
            int r100 = r113;
        L11:
            if ((r113 & 48) != 0) goto L18;
            if (r112.changed(r111) == false) goto L15;
            int r114 = 32;
        L16:
            r100 = r100 | r114;
            goto L18
        L15:
            r114 = 16;
        L18:
            if ((r100 & 147) == 146) goto L20;
            boolean r115 = true;
        L22:
            if (r112.shouldExecute(r115, r100 & 1) == true) goto L24;
            r112.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(-1942245546, r100, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:576)");
        L26:
            Function5<LazyGridItemScope, Integer, T, Composer, Integer, Unit> r101 = this.$itemContent;
            Integer r102 = Integer.valueOf(r111);
            Object r103 = ListProtector.get(this.$items, r111);
            T r104 = (T) r103;
            r101.invoke(r110, r102, r104, r112, Integer.valueOf((r100 & 14) | (r100 & 112)));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r115 = false;
            goto L22
        L5:
            if (r112.changed(r110) == false) goto L7;
            int r105 = 4;
        L8:
            r100 = r105 | r113;
            goto L11
        L7:
            r105 = 2;
            goto L8
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope r100, Integer r101, Composer r102, Integer r103) {
            invoke(r100, r101.intValue(), r102, r103.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$7, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C86227 implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public C86227(Function2<? super Integer, ? super T, ? extends Object> r100, T[] r101) {
            this.$key = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int r100) {
            return this.$key.invoke(Integer.valueOf(r100), this.$items[r100]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
            return invoke(r100.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C86238 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: Multi-variable type inference failed */
        public C86238(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> r100, T[] r101) {
            this.$span = r100;
            this.$items = r101;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope r100, Integer r101) {
            return GridItemSpan.m848boximpl(m860invoke_orMbw(r100, r101.intValue()));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m860invoke_orMbw(LazyGridItemSpanScope r100, int r101) {
            return this.$span.invoke(r100, Integer.valueOf(r101), this.$items[r101]).m855unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$9, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C86249 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C86249(Function2<? super Integer, ? super T, ? extends Object> r100, T[] r101) {
            this.$contentType = r100;
            this.$items = r101;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int r100) {
            return this.$contentType.invoke(Integer.valueOf(r100), this.$items[r100]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
            return invoke(r100.intValue());
        }
    }

    private static final Unit LazyHorizontalGrid$lambda$2(GridCells r110, Modifier r111, LazyGridState r112, PaddingValues r113, boolean r210, Arrangement.Horizontal r211, Arrangement.Vertical r212, FlingBehavior r213, boolean r214, OverscrollEffect r215, Function1 r216, int r217, int r218, int r219, Composer r310, int r311) {
        LazyHorizontalGrid(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r310, RecomposeScopeImplKt.updateChangedFlags(r217 | 1), RecomposeScopeImplKt.updateChangedFlags(r218), r219);
        return Unit.INSTANCE;
    }

    private static final Unit LazyHorizontalGrid$lambda$3(GridCells r110, Modifier r111, LazyGridState r112, PaddingValues r113, boolean r114, Arrangement.Horizontal r115, Arrangement.Vertical r210, FlingBehavior r211, boolean r212, Function1 r213, int r214, int r215, Composer r216, int r217) {
        LazyHorizontalGrid(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r216, RecomposeScopeImplKt.updateChangedFlags(r214 | 1), r215);
        return Unit.INSTANCE;
    }

    private static final Unit LazyVerticalGrid$lambda$0(GridCells r110, Modifier r111, LazyGridState r112, PaddingValues r113, boolean r210, Arrangement.Vertical r211, Arrangement.Horizontal r212, FlingBehavior r213, boolean r214, OverscrollEffect r215, Function1 r216, int r217, int r218, int r219, Composer r310, int r311) {
        LazyVerticalGrid(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r310, RecomposeScopeImplKt.updateChangedFlags(r217 | 1), RecomposeScopeImplKt.updateChangedFlags(r218), r219);
        return Unit.INSTANCE;
    }

    private static final Unit LazyVerticalGrid$lambda$1(GridCells r110, Modifier r111, LazyGridState r112, PaddingValues r113, boolean r114, Arrangement.Vertical r115, Arrangement.Horizontal r210, FlingBehavior r211, boolean r212, Function1 r213, int r214, int r215, Composer r216, int r217) {
        LazyVerticalGrid(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r216, RecomposeScopeImplKt.updateChangedFlags(r214 | 1), r215);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(GridCells r100, Modifier r101, LazyGridState r102, PaddingValues r103, boolean r104, Arrangement.Horizontal r105, Arrangement.Vertical r106, FlingBehavior r107, boolean r108, OverscrollEffect r109, Function1 r110, int r111, int r112, int r113, Composer r114, int r115) {
        return LazyHorizontalGrid$lambda$2(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115);
    }

    public static /* synthetic */ Unit b(GridCells r100, Modifier r101, LazyGridState r102, PaddingValues r103, boolean r104, Arrangement.Horizontal r105, Arrangement.Vertical r106, FlingBehavior r107, boolean r108, Function1 r109, int r110, int r111, Composer r112, int r113) {
        return LazyHorizontalGrid$lambda$3(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113);
    }

    public static /* synthetic */ LazyGridSlots c(GridCells r100, Arrangement.Horizontal r101, Density r102, Constraints r103) {
        return rememberColumnWidthSums$lambda$9$lambda$8(r100, r101, r102, r103);
    }

    public static /* synthetic */ LazyGridSlots d(GridCells r100, Arrangement.Vertical r101, Density r102, Constraints r103) {
        return rememberRowHeightSums$lambda$15$lambda$14(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit e(GridCells r100, Modifier r101, LazyGridState r102, PaddingValues r103, boolean r104, Arrangement.Vertical r105, Arrangement.Horizontal r106, FlingBehavior r107, boolean r108, OverscrollEffect r109, Function1 r110, int r111, int r112, int r113, Composer r114, int r115) {
        return LazyVerticalGrid$lambda$0(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115);
    }

    public static /* synthetic */ Unit f(GridCells r100, Modifier r101, LazyGridState r102, PaddingValues r103, boolean r104, Arrangement.Vertical r105, Arrangement.Horizontal r106, FlingBehavior r107, boolean r108, Function1 r109, int r110, int r111, Composer r112, int r113) {
        return LazyVerticalGrid$lambda$1(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113);
    }

    public static final /* synthetic */ List access$calculateCellsCrossAxisSizeImpl(int r100, int r101, int r102) {
        return calculateCellsCrossAxisSizeImpl(r100, r101, r102);
    }

    private static final List<Integer> calculateCellsCrossAxisSizeImpl(int r100, int r101, int r102) {
        int r103 = r100 - (r102 * (r101 - 1));
        int r104 = r103 / r101;
        int r105 = r103 % r101;
        ArrayList r106 = new ArrayList(r101);
        int r107 = 0;
    L3:
        if (r107 >= r101) goto L8;
        if (r107 >= r105) goto L6;
        int r108 = 1;
    L7:
        r106.add(Integer.valueOf(r108 + r104));
        r107 = r107 + 1;
        goto L3
    L6:
        r108 = 0;
        goto L7
    L8:
        return r106;
    }

    private static final LazyGridSlotsProvider rememberColumnWidthSums(final GridCells r100, final Arrangement.Horizontal r101, Composer r102, int r103) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-76500289, r103, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:221)");
    L5:
        boolean r104 = false;
        if (((r103 & 14) ^ 6) <= 4) goto L10;
        if (r102.changed(r100) == false) goto L10;
    L11:
        boolean r105 = true;
    L14:
        if (((r103 & 112) ^ 48) <= 32) goto L18;
        if (r102.changed(r101) == false) goto L18;
    L19:
        r104 = true;
    L20:
        boolean r106 = r105 | r104;
        Object r107 = r102.rememberedValue();
        if (r106 == false) goto L23;
    L24:
        r107 = new GridSlotCache(new e(r100, r101));
        r102.updateRememberedValue(r107);
    L25:
        LazyGridSlotsProvider r108 = (LazyGridSlotsProvider) r107;
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r108;
    L23:
        if (r107 != Composer.Companion.getEmpty()) goto L25;
    L18:
        if ((r103 & 48) != 32) goto L20;
    L10:
        if ((r103 & 6) == 4) goto L11;
        r105 = false;
        goto L14
    }

    private static final LazyGridSlots rememberColumnWidthSums$lambda$9$lambda$8(GridCells r100, Arrangement.Horizontal r101, Density r110, Constraints r111) {
        if (Constraints.m7487getMaxWidthimpl(r111.m7493unboximpl()) == Integer.MAX_VALUE) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("LazyVerticalGrid's width should be bound by parent.");
    L8:
        int r103 = Constraints.m7487getMaxWidthimpl(r111.m7493unboximpl());
        int[] r104 = CollectionsKt.toIntArray(r100.calculateCrossAxisCellSizes(r110, r103, r110.mo365roundToPx0680j_4(r101.mo617getSpacingD9Ej5fM())));
        int[] r112 = new int[r104.length];
        r101.arrange(r110, r103, r104, LayoutDirection.Ltr, r112);
        return new LazyGridSlots(r104, r112);
    L5:
        r102 = false;
        goto L6
    }

    private static final LazyGridSlotsProvider rememberRowHeightSums(final GridCells r100, final Arrangement.Vertical r101, Composer r102, int r103) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-150818144, r103, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:245)");
    L5:
        boolean r104 = false;
        if (((r103 & 14) ^ 6) <= 4) goto L10;
        if (r102.changed(r100) == false) goto L10;
    L11:
        boolean r105 = true;
    L14:
        if (((r103 & 112) ^ 48) <= 32) goto L18;
        if (r102.changed(r101) == false) goto L18;
    L19:
        r104 = true;
    L20:
        boolean r106 = r105 | r104;
        Object r107 = r102.rememberedValue();
        if (r106 == false) goto L23;
    L24:
        r107 = new GridSlotCache(new f(r100, r101));
        r102.updateRememberedValue(r107);
    L25:
        LazyGridSlotsProvider r108 = (LazyGridSlotsProvider) r107;
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r108;
    L23:
        if (r107 != Composer.Companion.getEmpty()) goto L25;
    L18:
        if ((r103 & 48) != 32) goto L20;
    L10:
        if ((r103 & 6) == 4) goto L11;
        r105 = false;
        goto L14
    }

    private static final LazyGridSlots rememberRowHeightSums$lambda$15$lambda$14(GridCells r100, Arrangement.Vertical r101, Density r102, Constraints r103) {
        if (Constraints.m7486getMaxHeightimpl(r103.m7493unboximpl()) == Integer.MAX_VALUE) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.");
    L8:
        int r105 = Constraints.m7486getMaxHeightimpl(r103.m7493unboximpl());
        int[] r106 = CollectionsKt.toIntArray(r100.calculateCrossAxisCellSizes(r102, r105, r102.mo365roundToPx0680j_4(r101.mo617getSpacingD9Ej5fM())));
        int[] r107 = new int[r106.length];
        r101.arrange(r102, r105, r106, r107);
        return new LazyGridSlots(r106, r107);
    L5:
        r104 = false;
        goto L6
    }

    public static final <T> void items(LazyGridScope r100, List<? extends T> r101, Function1<? super T, ? extends Object> r102, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> r103, Function1<? super T, ? extends Object> r104, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r105) {
        int r106 = r101.size();
        AnonymousClass3 r107 = null;
        if (r102 == null) goto L5;
        AnonymousClass2 r108 = new AnonymousClass2(r102, r101);
    L6:
        if (r103 == null) goto L8;
        r107 = new AnonymousClass3(r103, r101);
    L8:
        r100.items(r106, r108, r107, new AnonymousClass4(r104, r101), ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new AnonymousClass5(r105, r101)));
        return;
    L5:
        r108 = null;
        goto L6
    }

    public static final <T> void itemsIndexed(LazyGridScope r100, List<? extends T> r101, Function2<? super Integer, ? super T, ? extends Object> r102, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> r103, Function2<? super Integer, ? super T, ? extends Object> r104, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r105) {
        int r106 = r101.size();
        C86183 r107 = null;
        if (r102 == null) goto L5;
        C86172 r108 = new C86172(r102, r101);
    L6:
        if (r103 == null) goto L8;
        r107 = new C86183(r103, r101);
    L8:
        r100.items(r106, r108, r107, new C86194(r104, r101), ComposableLambdaKt.composableLambdaInstance(-1942245546, true, new C86205(r105, r101)));
        return;
    L5:
        r108 = null;
        goto L6
    }

    public static final <T> void items(LazyGridScope r100, T[] r101, Function1<? super T, ? extends Object> r102, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> r103, Function1<? super T, ? extends Object> r104, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> r105) {
        int r106 = r101.length;
        AnonymousClass8 r107 = null;
        if (r102 == null) goto L5;
        AnonymousClass7 r108 = new AnonymousClass7(r102, r101);
    L6:
        if (r103 == null) goto L8;
        r107 = new AnonymousClass8(r103, r101);
    L8:
        r100.items(r106, r108, r107, new AnonymousClass9(r104, r101), ComposableLambdaKt.composableLambdaInstance(1179065086, true, new AnonymousClass10(r105, r101)));
        return;
    L5:
        r108 = null;
        goto L6
    }

    public static final <T> void itemsIndexed(LazyGridScope r100, T[] r101, Function2<? super Integer, ? super T, ? extends Object> r102, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> r103, Function2<? super Integer, ? super T, ? extends Object> r104, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r105) {
        int r106 = r101.length;
        C86238 r107 = null;
        if (r102 == null) goto L5;
        C86227 r108 = new C86227(r102, r101);
    L6:
        if (r103 == null) goto L8;
        r107 = new C86238(r103, r101);
    L8:
        r100.items(r106, r108, r107, new C86249(r104, r101), ComposableLambdaKt.composableLambdaInstance(49283819, true, new C861610(r105, r101)));
        return;
    L5:
        r108 = null;
        goto L6
    }

    public static /* synthetic */ void items$default(LazyGridScope r100, List r101, Function1 r102, Function2 r110, Function1 r111, Function4 r112, int r113, Object r114) {
        AnonymousClass3 r103 = null;
        if ((r113 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r113 & 4) == 0) goto L9;
        r110 = null;
    L9:
        if ((r113 & 8) == 0) goto L11;
        r111 = AnonymousClass1.INSTANCE;
    L11:
        int r104 = r101.size();
        if (r102 == null) goto L14;
        AnonymousClass2 r105 = new AnonymousClass2(r102, r101);
    L15:
        if (r110 == null) goto L17;
        r103 = new AnonymousClass3(r110, r101);
    L17:
        r100.items(r104, r105, r103, new AnonymousClass4(r111, r101), ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new AnonymousClass5(r112, r101)));
        return;
    L14:
        r105 = null;
        goto L15
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope r100, List r101, Function2 r102, Function3 r110, Function2 r111, Function5 r112, int r113, Object r114) {
        C86183 r103 = null;
        if ((r113 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r113 & 4) == 0) goto L9;
        r110 = null;
    L9:
        if ((r113 & 8) == 0) goto L11;
        r111 = C86151.INSTANCE;
    L11:
        int r104 = r101.size();
        if (r102 == null) goto L14;
        C86172 r105 = new C86172(r102, r101);
    L15:
        if (r110 == null) goto L17;
        r103 = new C86183(r110, r101);
    L17:
        r100.items(r104, r105, r103, new C86194(r111, r101), ComposableLambdaKt.composableLambdaInstance(-1942245546, true, new C86205(r112, r101)));
        return;
    L14:
        r105 = null;
        goto L15
    }

    public static /* synthetic */ void items$default(LazyGridScope r100, Object[] r101, Function1 r102, Function2 r110, Function1 r111, Function4 r112, int r113, Object r114) {
        AnonymousClass8 r103 = null;
        if ((r113 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r113 & 4) == 0) goto L9;
        r110 = null;
    L9:
        if ((r113 & 8) == 0) goto L11;
        r111 = AnonymousClass6.INSTANCE;
    L11:
        int r104 = r101.length;
        if (r102 == null) goto L14;
        AnonymousClass7 r105 = new AnonymousClass7(r102, r101);
    L15:
        if (r110 == null) goto L17;
        r103 = new AnonymousClass8(r110, r101);
    L17:
        r100.items(r104, r105, r103, new AnonymousClass9(r111, r101), ComposableLambdaKt.composableLambdaInstance(1179065086, true, new AnonymousClass10(r112, r101)));
        return;
    L14:
        r105 = null;
        goto L15
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope r100, Object[] r101, Function2 r102, Function3 r110, Function2 r111, Function5 r112, int r113, Object r114) {
        C86238 r103 = null;
        if ((r113 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r113 & 4) == 0) goto L9;
        r110 = null;
    L9:
        if ((r113 & 8) == 0) goto L11;
        r111 = C86216.INSTANCE;
    L11:
        int r104 = r101.length;
        if (r102 == null) goto L14;
        C86227 r105 = new C86227(r102, r101);
    L15:
        if (r110 == null) goto L17;
        r103 = new C86238(r110, r101);
    L17:
        r100.items(r104, r105, r103, new C86249(r111, r101), ComposableLambdaKt.composableLambdaInstance(49283819, true, new C861610(r112, r101)));
        return;
    L14:
        r105 = null;
        goto L15
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyHorizontalGrid(final GridCells r210, Modifier r310, LazyGridState r311, PaddingValues r312, boolean r313, Arrangement.Horizontal r314, Arrangement.Vertical r315, FlingBehavior r316, boolean r317, final Function1 r318, Composer r319, final int r410, final int r411) {
        Composer r100 = r319.startRestartGroup(2123608858);
        if ((r411 & 1) == 0) goto L6;
        int r101 = r410 | 6;
    L13:
        int r102 = r411 & 2;
        if (r102 == 0) goto L17;
        r101 = r101 | 48;
    L25:
        if ((r410 & 384) != 0) goto L35;
        if ((r411 & 4) != 0) goto L32;
        if (r100.changed(r311) == false) goto L32;
        int r103 = 256;
    L33:
        r101 = r101 | r103;
    L32:
        r103 = 128;
    L35:
        int r104 = r411 & 8;
        if (r104 == 0) goto L39;
        r101 = r101 | 3072;
    L45:
        PaddingValues r105 = r312;
    L46:
        int r106 = r411 & 16;
        if (r106 == 0) goto L50;
        r101 = r101 | 24576;
    L56:
        boolean r110 = r313;
    L58:
        if ((196608 & r410) == 0) goto L60;
        Arrangement.Horizontal r111 = r314;
    L68:
        int r112 = r411 & 64;
        if (r112 == 0) goto L72;
        r101 = r101 | 1572864;
    L78:
        Arrangement.Vertical r113 = r315;
    L80:
        if ((r410 & 12582912) != 0) goto L90;
        if ((r411 & 128) != 0) goto L87;
        if (r100.changed(r316) == false) goto L87;
        int r114 = 8388608;
    L88:
        r101 = r101 | r114;
    L87:
        r114 = 4194304;
    L90:
        int r107 = r411 & 256;
        if (r107 == 0) goto L94;
        r101 = r101 | AVLogger.LEVEL_LOG_SILENT;
    L101:
        if ((r411 & 512) == 0) goto L104;
        r101 = r101 | 805306368;
    L112:
        if ((r101 & 306783379) == 306783378) goto L114;
        boolean r108 = true;
    L116:
        if (r100.shouldExecute(r108, r101 & 1) == false) goto L171;
        r100.startDefaults();
        if ((r410 & 1) != 0) goto L120;
    L133:
        if (r102 == 0) goto L135;
        final Modifier r109 = Modifier.Companion;
    L137:
        if ((r411 & 4) == 0) goto L139;
        LazyGridState r115 = LazyGridStateKt.rememberLazyGridState(0, 0, r100, 0, 3);
        r101 = r101 & (-897);
    L140:
        if (r104 == 0) goto L142;
        PaddingValues r116 = PaddingKt.m724PaddingValues0680j_4(Dp.m7544constructorimpl(0));
    L143:
        if (r106 == 0) goto L146;
        r110 = false;
    L146:
        if ((r411 & 32) == 0) goto L152;
        Arrangement r117 = Arrangement.INSTANCE;
        if (r110 == true) goto L150;
        Arrangement.Horizontal r118 = r117.getStart();
    L151:
        r101 = r101 & (-458753);
    L153:
        if (r112 == 0) goto L155;
        Arrangement.Vertical r119 = Arrangement.INSTANCE.getTop();
    L157:
        if ((r411 & 128) == 0) goto L159;
        FlingBehavior r120 = ScrollableDefaults.INSTANCE.flingBehavior(r100, 6);
        r101 = r101 & (-29360129);
    L160:
        int r121 = r101;
        if (r107 == 0) goto L163;
        FlingBehavior r122 = r120;
        boolean r123 = true;
    L164:
        r100.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L167;
        ComposerKt.traceEventStart(2123608858, r121, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:199)");
    L167:
        LazyHorizontalGrid(r210, r109, r115, r116, r110, r118, r119, r122, r123, OverscrollKt.rememberOverscrollEffect(r100, 0), r318, r100, ((((((((r121 & 14) | (r121 & 112)) | (r121 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT)) | (r121 & 7168)) | (57344 & r121)) | (458752 & r121)) | (3670016 & r121)) | (29360128 & r121)) | (234881024 & r121), (r121 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L170;
        ComposerKt.traceEventEnd();
    L170:
        final Arrangement.Horizontal r124 = r118;
        final boolean r125 = r110;
        final FlingBehavior r126 = r122;
        Arrangement.Vertical r211 = r119;
        final boolean r127 = r123;
        final LazyGridState r128 = r115;
        final PaddingValues r129 = r116;
        final Arrangement.Vertical r130 = r211;
    L172:
        ScopeUpdateScope r131 = r100.endRestartGroup();
        if (r131 == null) goto L176;
        r131.updateScope(new b(r210, r109, r128, r129, r125, r124, r130, r126, r127, r318, r410, r411));
        return;
    L176:
        return;
    L163:
        r122 = r120;
    L132:
        r123 = r317;
        goto L164
    L159:
        r120 = r316;
        goto L160
    L155:
        r119 = r113;
        goto L157
    L150:
        r118 = r117.getEnd();
        goto L151
    L152:
        r118 = r111;
        goto L153
    L142:
        r116 = r105;
        goto L143
    L139:
        r115 = r311;
        goto L140
    L135:
        r109 = r310;
        goto L137
    L120:
        if (r100.getDefaultsInvalid() == true) goto L133;
        r100.skipToGroupEnd();
        if ((r411 & 4) == 0) goto L126;
        r101 = r101 & (-897);
    L126:
        if ((r411 & 32) == 0) goto L129;
        r101 = r101 & (-458753);
    L129:
        if ((r411 & 128) == 0) goto L131;
        r101 = r101 & (-29360129);
    L131:
        r109 = r310;
        r115 = r311;
        r122 = r316;
        r121 = r101;
        r116 = r105;
        r118 = r111;
        r119 = r113;
        goto L132
    L171:
        r100.skipToGroupEnd();
        r109 = r310;
        r128 = r311;
        r127 = r317;
        r129 = r105;
        r125 = r110;
        r124 = r111;
        r130 = r113;
        r126 = r316;
        goto L172
    L114:
        r108 = false;
        goto L116
    L104:
        if ((r410 & 805306368) != 0) goto L112;
        if (r100.changedInstance(r318) == false) goto L108;
        int r132 = 536870912;
    L109:
        r101 = r101 | r132;
        goto L112
    L108:
        r132 = 268435456;
        goto L109
    L94:
        if ((r410 & AVLogger.LEVEL_LOG_SILENT) != 0) goto L101;
        if (r100.changed(r317) == false) goto L98;
        int r133 = 67108864;
    L99:
        r101 = r101 | r133;
        goto L101
    L98:
        r133 = 33554432;
        goto L99
    L72:
        if ((1572864 & r410) != 0) goto L78;
        r113 = r315;
        if (r100.changed(r113) == false) goto L76;
        int r134 = 1048576;
    L77:
        r101 = r101 | r134;
        goto L80
    L76:
        r134 = 524288;
        goto L77
    L60:
        if ((r411 & 32) != 0) goto L64;
        r111 = r314;
        if (r100.changed(r111) == false) goto L65;
        int r135 = 131072;
    L66:
        r101 = r101 | r135;
    L65:
        r135 = 65536;
        goto L66
    L64:
        r111 = r314;
        goto L65
    L50:
        if ((r410 & 24576) != 0) goto L56;
        r110 = r313;
        if (r100.changed(r110) == false) goto L54;
        int r136 = 16384;
    L55:
        r101 = r101 | r136;
        goto L58
    L54:
        r136 = 8192;
        goto L55
    L39:
        if ((r410 & 3072) != 0) goto L45;
        r105 = r312;
        if (r100.changed(r105) == false) goto L43;
        int r137 = 2048;
    L44:
        r101 = r101 | r137;
        goto L46
    L43:
        r137 = 1024;
        goto L44
    L17:
        if ((r410 & 48) != 0) goto L25;
        if (r100.changed(r310) == false) goto L21;
        int r138 = 32;
    L22:
        r101 = r101 | r138;
        goto L25
    L21:
        r138 = 16;
        goto L22
    L6:
        if ((r410 & 6) == 0) goto L8;
        r101 = r410;
        goto L13
    L8:
        if (r100.changed(r210) == false) goto L10;
        int r139 = 4;
    L11:
        r101 = r139 | r410;
        goto L13
    L10:
        r139 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyVerticalGrid(final GridCells r210, Modifier r310, LazyGridState r311, PaddingValues r312, boolean r313, Arrangement.Vertical r314, Arrangement.Horizontal r315, FlingBehavior r316, boolean r317, final Function1 r318, Composer r319, final int r410, final int r411) {
        Composer r100 = r319.startRestartGroup(1485410512);
        if ((r411 & 1) == 0) goto L6;
        int r101 = r410 | 6;
    L13:
        int r102 = r411 & 2;
        if (r102 == 0) goto L17;
        r101 = r101 | 48;
    L25:
        if ((r410 & 384) != 0) goto L35;
        if ((r411 & 4) != 0) goto L32;
        if (r100.changed(r311) == false) goto L32;
        int r103 = 256;
    L33:
        r101 = r101 | r103;
    L32:
        r103 = 128;
    L35:
        int r104 = r411 & 8;
        if (r104 == 0) goto L39;
        r101 = r101 | 3072;
    L45:
        PaddingValues r105 = r312;
    L46:
        int r106 = r411 & 16;
        if (r106 == 0) goto L50;
        r101 = r101 | 24576;
    L56:
        boolean r110 = r313;
    L58:
        if ((196608 & r410) == 0) goto L60;
        Arrangement.Vertical r111 = r314;
    L68:
        int r112 = r411 & 64;
        if (r112 == 0) goto L72;
        r101 = r101 | 1572864;
    L78:
        Arrangement.Horizontal r113 = r315;
    L80:
        if ((r410 & 12582912) != 0) goto L90;
        if ((r411 & 128) != 0) goto L87;
        if (r100.changed(r316) == false) goto L87;
        int r114 = 8388608;
    L88:
        r101 = r101 | r114;
    L87:
        r114 = 4194304;
    L90:
        int r107 = r411 & 256;
        if (r107 == 0) goto L94;
        r101 = r101 | AVLogger.LEVEL_LOG_SILENT;
    L101:
        if ((r411 & 512) == 0) goto L104;
        r101 = r101 | 805306368;
    L112:
        if ((r101 & 306783379) == 306783378) goto L114;
        boolean r108 = true;
    L116:
        if (r100.shouldExecute(r108, r101 & 1) == false) goto L171;
        r100.startDefaults();
        if ((r410 & 1) != 0) goto L120;
    L133:
        if (r102 == 0) goto L135;
        final Modifier r109 = Modifier.Companion;
    L137:
        if ((r411 & 4) == 0) goto L139;
        LazyGridState r115 = LazyGridStateKt.rememberLazyGridState(0, 0, r100, 0, 3);
        r101 = r101 & (-897);
    L140:
        if (r104 == 0) goto L142;
        PaddingValues r116 = PaddingKt.m724PaddingValues0680j_4(Dp.m7544constructorimpl(0));
    L143:
        if (r106 == 0) goto L146;
        r110 = false;
    L146:
        if ((r411 & 32) == 0) goto L152;
        Arrangement r117 = Arrangement.INSTANCE;
        if (r110 == true) goto L150;
        Arrangement.Vertical r118 = r117.getTop();
    L151:
        r101 = r101 & (-458753);
    L153:
        if (r112 == 0) goto L155;
        Arrangement.Horizontal r119 = Arrangement.INSTANCE.getStart();
    L157:
        if ((r411 & 128) == 0) goto L159;
        FlingBehavior r120 = ScrollableDefaults.INSTANCE.flingBehavior(r100, 6);
        r101 = r101 & (-29360129);
    L160:
        int r121 = r101;
        if (r107 == 0) goto L163;
        FlingBehavior r122 = r120;
        boolean r123 = true;
    L164:
        r100.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L167;
        ComposerKt.traceEventStart(1485410512, r121, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:110)");
    L167:
        LazyVerticalGrid(r210, r109, r115, r116, r110, r118, r119, r122, r123, OverscrollKt.rememberOverscrollEffect(r100, 0), r318, r100, ((((((((r121 & 14) | (r121 & 112)) | (r121 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT)) | (r121 & 7168)) | (57344 & r121)) | (458752 & r121)) | (3670016 & r121)) | (29360128 & r121)) | (234881024 & r121), (r121 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L170;
        ComposerKt.traceEventEnd();
    L170:
        final Arrangement.Vertical r124 = r118;
        final boolean r125 = r110;
        final FlingBehavior r126 = r122;
        Arrangement.Horizontal r211 = r119;
        final boolean r127 = r123;
        final LazyGridState r128 = r115;
        final PaddingValues r129 = r116;
        final Arrangement.Horizontal r130 = r211;
    L172:
        ScopeUpdateScope r131 = r100.endRestartGroup();
        if (r131 == null) goto L176;
        r131.updateScope(new g(r210, r109, r128, r129, r125, r124, r130, r126, r127, r318, r410, r411));
        return;
    L176:
        return;
    L163:
        r122 = r120;
    L132:
        r123 = r317;
        goto L164
    L159:
        r120 = r316;
        goto L160
    L155:
        r119 = r113;
        goto L157
    L150:
        r118 = r117.getBottom();
        goto L151
    L152:
        r118 = r111;
        goto L153
    L142:
        r116 = r105;
        goto L143
    L139:
        r115 = r311;
        goto L140
    L135:
        r109 = r310;
        goto L137
    L120:
        if (r100.getDefaultsInvalid() == true) goto L133;
        r100.skipToGroupEnd();
        if ((r411 & 4) == 0) goto L126;
        r101 = r101 & (-897);
    L126:
        if ((r411 & 32) == 0) goto L129;
        r101 = r101 & (-458753);
    L129:
        if ((r411 & 128) == 0) goto L131;
        r101 = r101 & (-29360129);
    L131:
        r109 = r310;
        r115 = r311;
        r122 = r316;
        r121 = r101;
        r116 = r105;
        r118 = r111;
        r119 = r113;
        goto L132
    L171:
        r100.skipToGroupEnd();
        r109 = r310;
        r128 = r311;
        r127 = r317;
        r129 = r105;
        r125 = r110;
        r124 = r111;
        r130 = r113;
        r126 = r316;
        goto L172
    L114:
        r108 = false;
        goto L116
    L104:
        if ((r410 & 805306368) != 0) goto L112;
        if (r100.changedInstance(r318) == false) goto L108;
        int r132 = 536870912;
    L109:
        r101 = r101 | r132;
        goto L112
    L108:
        r132 = 268435456;
        goto L109
    L94:
        if ((r410 & AVLogger.LEVEL_LOG_SILENT) != 0) goto L101;
        if (r100.changed(r317) == false) goto L98;
        int r133 = 67108864;
    L99:
        r101 = r101 | r133;
        goto L101
    L98:
        r133 = 33554432;
        goto L99
    L72:
        if ((1572864 & r410) != 0) goto L78;
        r113 = r315;
        if (r100.changed(r113) == false) goto L76;
        int r134 = 1048576;
    L77:
        r101 = r101 | r134;
        goto L80
    L76:
        r134 = 524288;
        goto L77
    L60:
        if ((r411 & 32) != 0) goto L64;
        r111 = r314;
        if (r100.changed(r111) == false) goto L65;
        int r135 = 131072;
    L66:
        r101 = r101 | r135;
    L65:
        r135 = 65536;
        goto L66
    L64:
        r111 = r314;
        goto L65
    L50:
        if ((r410 & 24576) != 0) goto L56;
        r110 = r313;
        if (r100.changed(r110) == false) goto L54;
        int r136 = 16384;
    L55:
        r101 = r101 | r136;
        goto L58
    L54:
        r136 = 8192;
        goto L55
    L39:
        if ((r410 & 3072) != 0) goto L45;
        r105 = r312;
        if (r100.changed(r105) == false) goto L43;
        int r137 = 2048;
    L44:
        r101 = r101 | r137;
        goto L46
    L43:
        r137 = 1024;
        goto L44
    L17:
        if ((r410 & 48) != 0) goto L25;
        if (r100.changed(r310) == false) goto L21;
        int r138 = 32;
    L22:
        r101 = r101 | r138;
        goto L25
    L21:
        r138 = 16;
        goto L22
    L6:
        if ((r410 & 6) == 0) goto L8;
        r101 = r410;
        goto L13
    L8:
        if (r100.changed(r210) == false) goto L10;
        int r139 = 4;
    L11:
        r101 = r139 | r410;
        goto L13
    L10:
        r139 = 2;
        goto L11
    }

    public static final void LazyHorizontalGrid(final GridCells r310, Modifier r311, LazyGridState r312, PaddingValues r313, boolean r314, Arrangement.Horizontal r315, Arrangement.Vertical r316, FlingBehavior r410, boolean r411, OverscrollEffect r412, final Function1<? super LazyGridScope, Unit> r413, Composer r414, final int r415, final int r416, final int r417) {
        Composer r100 = r414.startRestartGroup(635941664);
        if ((r417 & 1) == 0) goto L6;
        int r101 = r415 | 6;
    L13:
        int r102 = r417 & 2;
        if (r102 == 0) goto L17;
        r101 = r101 | 48;
    L25:
        if ((r415 & 384) != 0) goto L35;
        if ((r417 & 4) != 0) goto L32;
        if (r100.changed(r312) == false) goto L32;
        int r103 = 256;
    L33:
        r101 = r101 | r103;
    L32:
        r103 = 128;
    L35:
        int r104 = r417 & 8;
        if (r104 == 0) goto L39;
        r101 = r101 | 3072;
    L45:
        PaddingValues r110 = r313;
    L46:
        int r111 = r417 & 16;
        if (r111 == 0) goto L50;
        r101 = r101 | 24576;
    L56:
        boolean r112 = r314;
    L58:
        if ((r415 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) goto L67;
        if ((r417 & 32) == 0) goto L62;
    L64:
        int r113 = 65536;
    L65:
        r101 = r101 | r113;
        goto L67
    L62:
        if (r100.changed(r315) == false) goto L64;
        r113 = 131072;
    L67:
        int r114 = r417 & 64;
        if (r114 == 0) goto L70;
        r101 = r101 | 1572864;
        Arrangement.Vertical r115 = r316;
    L78:
        if ((r415 & 12582912) != 0) goto L88;
        if ((r417 & 128) != 0) goto L85;
        if (r100.changed(r410) == false) goto L85;
        int r116 = 8388608;
    L86:
        r101 = r101 | r116;
    L85:
        r116 = 4194304;
    L88:
        int r105 = r417 & 256;
        if (r105 == 0) goto L92;
        r101 = r101 | AVLogger.LEVEL_LOG_SILENT;
    L99:
        if ((r415 & 805306368) != 0) goto L110;
        if ((r417 & 512) != 0) goto L106;
        if (r100.changed(r412) == false) goto L106;
        int r210 = 536870912;
    L107:
        r101 = r101 | r210;
    L106:
        r210 = 268435456;
    L110:
        if ((r417 & 1024) == 0) goto L113;
        int r106 = r416 | 6;
    L120:
        boolean r211 = true;
        if ((r101 & 306783379) == 306783378) goto L123;
    L126:
        boolean r107 = true;
    L128:
        if (r100.shouldExecute(r107, r101 & 1) == false) goto L189;
        r100.startDefaults();
        if ((r415 & 1) != 0) goto L132;
    L147:
        if (r102 == 0) goto L149;
        Modifier r108 = Modifier.Companion;
    L151:
        if ((r417 & 4) == 0) goto L153;
        LazyGridState r109 = LazyGridStateKt.rememberLazyGridState(0, 0, r100, 0, 3);
        r101 = r101 & (-897);
    L154:
        if (r104 == 0) goto L156;
        PaddingValues r117 = PaddingKt.m724PaddingValues0680j_4(Dp.m7544constructorimpl(0));
    L157:
        if (r111 == 0) goto L160;
        r112 = false;
    L160:
        if ((r417 & 32) == 0) goto L166;
        Arrangement r118 = Arrangement.INSTANCE;
        if (r112 == true) goto L164;
        Arrangement.Horizontal r119 = r118.getStart();
    L165:
        r101 = r101 & (-458753);
    L167:
        if (r114 == 0) goto L169;
        Arrangement.Vertical r120 = Arrangement.INSTANCE.getTop();
    L171:
        if ((r417 & 128) == 0) goto L173;
        FlingBehavior r121 = ScrollableDefaults.INSTANCE.flingBehavior(r100, 6);
        r101 = r101 & (-29360129);
    L174:
        if (r105 != 0) goto L178;
        r211 = r411;
    L178:
        if ((r417 & 512) == 0) goto L180;
        OverscrollEffect r122 = OverscrollKt.rememberOverscrollEffect(r100, 0);
        r101 = r101 & (-1879048193);
    L181:
        int r123 = r101;
        boolean r124 = r211;
    L182:
        r100.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L185;
        ComposerKt.traceEventStart(635941664, r123, r106, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:168)");
    L185:
        int r125 = r123 >> 15;
        int r126 = r123 >> 3;
        LazyGridKt.LazyGrid(r108, r109, rememberRowHeightSums(r310, r120, r100, (r123 & 14) | (r125 & 112)), r117, r112, false, r121, r124, r122, r120, r119, r413, r100, ((((((((r126 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) | (r126 & 112)) | (r123 & 7168)) | (r123 & 57344)) | (r126 & 3670016)) | (r126 & 29360128)) | (r126 & 234881024)) | ((r123 << 9) & 1879048192), (r125 & 14) | ((r106 << 3) & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L188;
        ComposerKt.traceEventEnd();
    L188:
        final FlingBehavior r127 = r121;
        final Arrangement.Vertical r128 = r120;
        PaddingValues r317 = r117;
        final boolean r129 = r124;
        final LazyGridState r130 = r109;
        final Arrangement.Horizontal r131 = r119;
        final OverscrollEffect r132 = r122;
        final PaddingValues r133 = r317;
    L190:
        ScopeUpdateScope r134 = r100.endRestartGroup();
        if (r134 == null) goto L194;
        final Modifier r135 = r108;
        final boolean r136 = r112;
        r134.updateScope(new c(r310, r135, r130, r133, r136, r131, r128, r127, r129, r132, r413, r415, r416, r417));
        return;
    L194:
        return;
    L180:
        r122 = r412;
        goto L181
    L173:
        r121 = r410;
        goto L174
    L169:
        r120 = r115;
        goto L171
    L164:
        r119 = r118.getEnd();
        goto L165
    L166:
        r119 = r315;
        goto L167
    L156:
        r117 = r110;
        goto L157
    L153:
        r109 = r312;
        goto L154
    L149:
        r108 = r311;
        goto L151
    L132:
        if (r100.getDefaultsInvalid() == true) goto L147;
        r100.skipToGroupEnd();
        if ((r417 & 4) == 0) goto L138;
        r101 = r101 & (-897);
    L138:
        if ((r417 & 32) == 0) goto L141;
        r101 = r101 & (-458753);
    L141:
        if ((r417 & 128) == 0) goto L144;
        r101 = r101 & (-29360129);
    L144:
        if ((r417 & 512) == 0) goto L146;
        r101 = r101 & (-1879048193);
    L146:
        r108 = r311;
        r109 = r312;
        r121 = r410;
        r122 = r412;
        r123 = r101;
        r117 = r110;
        r120 = r115;
        r119 = r315;
        r124 = r411;
        goto L182
    L189:
        r100.skipToGroupEnd();
        r108 = r311;
        r130 = r312;
        r131 = r315;
        r127 = r410;
        r129 = r411;
        r133 = r110;
        r128 = r115;
        r132 = r412;
        goto L190
    L123:
        if ((r106 & 3) != 2) goto L126;
        r107 = false;
        goto L128
    L113:
        if ((r416 & 6) == 0) goto L115;
        r106 = r416;
        goto L120
    L115:
        if (r100.changedInstance(r413) == false) goto L117;
        int r212 = 4;
    L118:
        r106 = r416 | r212;
        goto L120
    L117:
        r212 = 2;
        goto L118
    L92:
        if ((r415 & AVLogger.LEVEL_LOG_SILENT) != 0) goto L99;
        if (r100.changed(r411) == false) goto L96;
        int r213 = 67108864;
    L97:
        r101 = r101 | r213;
        goto L99
    L96:
        r213 = 33554432;
        goto L97
    L70:
        r115 = r316;
        if ((r415 & 1572864) != 0) goto L78;
        if (r100.changed(r115) == false) goto L75;
        int r137 = 1048576;
    L76:
        r101 = r101 | r137;
        goto L78
    L75:
        r137 = 524288;
        goto L76
    L50:
        if ((r415 & 24576) != 0) goto L56;
        r112 = r314;
        if (r100.changed(r112) == false) goto L54;
        int r138 = 16384;
    L55:
        r101 = r101 | r138;
        goto L58
    L54:
        r138 = 8192;
        goto L55
    L39:
        if ((r415 & 3072) != 0) goto L45;
        r110 = r313;
        if (r100.changed(r110) == false) goto L43;
        int r139 = 2048;
    L44:
        r101 = r101 | r139;
        goto L46
    L43:
        r139 = 1024;
        goto L44
    L17:
        if ((r415 & 48) != 0) goto L25;
        if (r100.changed(r311) == false) goto L21;
        int r140 = 32;
    L22:
        r101 = r101 | r140;
        goto L25
    L21:
        r140 = 16;
        goto L22
    L6:
        if ((r415 & 6) == 0) goto L8;
        r101 = r415;
        goto L13
    L8:
        if (r100.changed(r310) == false) goto L10;
        int r141 = 4;
    L11:
        r101 = r141 | r415;
        goto L13
    L10:
        r141 = 2;
        goto L11
    }

    public static final void LazyVerticalGrid(final GridCells r310, Modifier r311, LazyGridState r312, PaddingValues r313, boolean r314, Arrangement.Vertical r315, Arrangement.Horizontal r316, FlingBehavior r410, boolean r411, OverscrollEffect r412, final Function1<? super LazyGridScope, Unit> r413, Composer r414, final int r415, final int r416, final int r417) {
        Composer r100 = r414.startRestartGroup(-2072102870);
        if ((r417 & 1) == 0) goto L6;
        int r101 = r415 | 6;
    L13:
        int r102 = r417 & 2;
        if (r102 == 0) goto L17;
        r101 = r101 | 48;
    L25:
        if ((r415 & 384) != 0) goto L35;
        if ((r417 & 4) != 0) goto L32;
        if (r100.changed(r312) == false) goto L32;
        int r103 = 256;
    L33:
        r101 = r101 | r103;
    L32:
        r103 = 128;
    L35:
        int r104 = r417 & 8;
        if (r104 == 0) goto L39;
        r101 = r101 | 3072;
    L45:
        PaddingValues r110 = r313;
    L46:
        int r111 = r417 & 16;
        if (r111 == 0) goto L50;
        r101 = r101 | 24576;
    L56:
        boolean r112 = r314;
    L58:
        if ((r415 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) goto L67;
        if ((r417 & 32) == 0) goto L62;
    L64:
        int r113 = 65536;
    L65:
        r101 = r101 | r113;
        goto L67
    L62:
        if (r100.changed(r315) == false) goto L64;
        r113 = 131072;
    L67:
        int r114 = r417 & 64;
        if (r114 == 0) goto L70;
        r101 = r101 | 1572864;
        Arrangement.Horizontal r115 = r316;
    L78:
        if ((r415 & 12582912) != 0) goto L88;
        if ((r417 & 128) != 0) goto L85;
        if (r100.changed(r410) == false) goto L85;
        int r116 = 8388608;
    L86:
        r101 = r101 | r116;
    L85:
        r116 = 4194304;
    L88:
        int r105 = r417 & 256;
        if (r105 == 0) goto L92;
        r101 = r101 | AVLogger.LEVEL_LOG_SILENT;
    L99:
        if ((r415 & 805306368) != 0) goto L110;
        if ((r417 & 512) != 0) goto L106;
        if (r100.changed(r412) == false) goto L106;
        int r210 = 536870912;
    L107:
        r101 = r101 | r210;
    L106:
        r210 = 268435456;
    L110:
        if ((r417 & 1024) == 0) goto L113;
        int r106 = r416 | 6;
    L120:
        boolean r211 = true;
        if ((r101 & 306783379) == 306783378) goto L123;
    L126:
        boolean r107 = true;
    L128:
        if (r100.shouldExecute(r107, r101 & 1) == false) goto L189;
        r100.startDefaults();
        if ((r415 & 1) != 0) goto L132;
    L147:
        if (r102 == 0) goto L149;
        Modifier r108 = Modifier.Companion;
    L151:
        if ((r417 & 4) == 0) goto L153;
        LazyGridState r109 = LazyGridStateKt.rememberLazyGridState(0, 0, r100, 0, 3);
        r101 = r101 & (-897);
    L154:
        if (r104 == 0) goto L156;
        PaddingValues r117 = PaddingKt.m724PaddingValues0680j_4(Dp.m7544constructorimpl(0));
    L157:
        if (r111 == 0) goto L160;
        r112 = false;
    L160:
        if ((r417 & 32) == 0) goto L166;
        Arrangement r118 = Arrangement.INSTANCE;
        if (r112 == true) goto L164;
        Arrangement.Vertical r119 = r118.getTop();
    L165:
        r101 = r101 & (-458753);
    L167:
        if (r114 == 0) goto L169;
        Arrangement.Horizontal r120 = Arrangement.INSTANCE.getStart();
    L171:
        if ((r417 & 128) == 0) goto L173;
        FlingBehavior r121 = ScrollableDefaults.INSTANCE.flingBehavior(r100, 6);
        r101 = r101 & (-29360129);
    L174:
        if (r105 != 0) goto L178;
        r211 = r411;
    L178:
        if ((r417 & 512) == 0) goto L180;
        OverscrollEffect r122 = OverscrollKt.rememberOverscrollEffect(r100, 0);
        r101 = r101 & (-1879048193);
    L181:
        int r123 = r101;
        boolean r124 = r211;
    L182:
        r100.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L185;
        ComposerKt.traceEventStart(-2072102870, r123, r106, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:79)");
    L185:
        int r125 = r123 >> 3;
        Modifier r126 = r108;
        LazyGridState r127 = r109;
        LazyGridKt.LazyGrid(r126, r127, rememberColumnWidthSums(r310, r120, r100, (r123 & 14) | ((r123 >> 15) & 112)), r117, r112, true, r121, r124, r122, r119, r120, r413, r100, ((((((((r125 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) | (r125 & 112)) | (r123 & 7168)) | (r123 & 57344)) | (r125 & 3670016)) | (r125 & 29360128)) | (r125 & 234881024)) | ((r123 << 12) & 1879048192), ((r123 >> 18) & 14) | ((r106 << 3) & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L188;
        ComposerKt.traceEventEnd();
    L188:
        final FlingBehavior r128 = r121;
        final Arrangement.Horizontal r129 = r120;
        PaddingValues r317 = r117;
        final boolean r130 = r124;
        final LazyGridState r131 = r109;
        final Arrangement.Vertical r132 = r119;
        final OverscrollEffect r133 = r122;
        final PaddingValues r134 = r317;
    L190:
        ScopeUpdateScope r135 = r100.endRestartGroup();
        if (r135 == null) goto L194;
        final Modifier r136 = r108;
        final boolean r137 = r112;
        r135.updateScope(new d(r310, r136, r131, r134, r137, r132, r129, r128, r130, r133, r413, r415, r416, r417));
        return;
    L194:
        return;
    L180:
        r122 = r412;
        goto L181
    L173:
        r121 = r410;
        goto L174
    L169:
        r120 = r115;
        goto L171
    L164:
        r119 = r118.getBottom();
        goto L165
    L166:
        r119 = r315;
        goto L167
    L156:
        r117 = r110;
        goto L157
    L153:
        r109 = r312;
        goto L154
    L149:
        r108 = r311;
        goto L151
    L132:
        if (r100.getDefaultsInvalid() == true) goto L147;
        r100.skipToGroupEnd();
        if ((r417 & 4) == 0) goto L138;
        r101 = r101 & (-897);
    L138:
        if ((r417 & 32) == 0) goto L141;
        r101 = r101 & (-458753);
    L141:
        if ((r417 & 128) == 0) goto L144;
        r101 = r101 & (-29360129);
    L144:
        if ((r417 & 512) == 0) goto L146;
        r101 = r101 & (-1879048193);
    L146:
        r108 = r311;
        r109 = r312;
        r121 = r410;
        r122 = r412;
        r123 = r101;
        r117 = r110;
        r120 = r115;
        r119 = r315;
        r124 = r411;
        goto L182
    L189:
        r100.skipToGroupEnd();
        r108 = r311;
        r131 = r312;
        r132 = r315;
        r128 = r410;
        r130 = r411;
        r134 = r110;
        r129 = r115;
        r133 = r412;
        goto L190
    L123:
        if ((r106 & 3) != 2) goto L126;
        r107 = false;
        goto L128
    L113:
        if ((r416 & 6) == 0) goto L115;
        r106 = r416;
        goto L120
    L115:
        if (r100.changedInstance(r413) == false) goto L117;
        int r212 = 4;
    L118:
        r106 = r416 | r212;
        goto L120
    L117:
        r212 = 2;
        goto L118
    L92:
        if ((r415 & AVLogger.LEVEL_LOG_SILENT) != 0) goto L99;
        if (r100.changed(r411) == false) goto L96;
        int r213 = 67108864;
    L97:
        r101 = r101 | r213;
        goto L99
    L96:
        r213 = 33554432;
        goto L97
    L70:
        r115 = r316;
        if ((r415 & 1572864) != 0) goto L78;
        if (r100.changed(r115) == false) goto L75;
        int r138 = 1048576;
    L76:
        r101 = r101 | r138;
        goto L78
    L75:
        r138 = 524288;
        goto L76
    L50:
        if ((r415 & 24576) != 0) goto L56;
        r112 = r314;
        if (r100.changed(r112) == false) goto L54;
        int r139 = 16384;
    L55:
        r101 = r101 | r139;
        goto L58
    L54:
        r139 = 8192;
        goto L55
    L39:
        if ((r415 & 3072) != 0) goto L45;
        r110 = r313;
        if (r100.changed(r110) == false) goto L43;
        int r140 = 2048;
    L44:
        r101 = r101 | r140;
        goto L46
    L43:
        r140 = 1024;
        goto L44
    L17:
        if ((r415 & 48) != 0) goto L25;
        if (r100.changed(r311) == false) goto L21;
        int r141 = 32;
    L22:
        r101 = r101 | r141;
        goto L25
    L21:
        r141 = 16;
        goto L22
    L6:
        if ((r415 & 6) == 0) goto L8;
        r101 = r415;
        goto L13
    L8:
        if (r100.changed(r310) == false) goto L10;
        int r142 = 4;
    L11:
        r101 = r142 | r415;
        goto L13
    L10:
        r142 = 2;
        goto L11
    }
}
