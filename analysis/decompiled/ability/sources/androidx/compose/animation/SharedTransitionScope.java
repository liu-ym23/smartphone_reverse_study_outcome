package androidx.compose.animation;

import C7.c;
import S7.n;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@ExperimentalSharedTransitionApi
@Stable
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u00043;<=J#\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\f*\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJK\u0010\u0019\u001a\u00020\f*\u00020\f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H&¢\u0006\u0004\b\u0019\u0010\u001aJU\u0010%\u001a\u00020\f*\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020$H&¢\u0006\u0004\b%\u0010&Js\u0010,\u001a\u00020\f*\u00020\f2\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010+\u001a\u00020*2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020$H&¢\u0006\u0004\b,\u0010-JU\u0010/\u001a\u00020\f*\u00020\f2\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020$H&¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020$2\u0006\u00102\u001a\u000201H&¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u001b2\u0006\u00106\u001a\u000205H'¢\u0006\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006>À\u0006\u0001"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "Landroidx/compose/ui/Alignment;", "alignment", "Landroidx/compose/animation/EnterTransition;", "scaleInSharedContentToBounds", "(Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Alignment;)Landroidx/compose/animation/EnterTransition;", "Landroidx/compose/animation/ExitTransition;", "scaleOutSharedContentToBounds", "(Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Alignment;)Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/ui/Modifier;", "skipToLookaheadSize", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "Lkotlin/Function0;", "", "renderInOverlay", "", "zIndexInOverlay", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "clipInOverlayDuringTransition", "renderInSharedTransitionScopeOverlay", "(Landroidx/compose/ui/Modifier;LS7/a;FLS7/n;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "state", "Landroidx/compose/animation/AnimatedVisibilityScope;", "animatedVisibilityScope", "Landroidx/compose/animation/BoundsTransform;", "boundsTransform", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "placeHolderSize", "renderInOverlayDuringTransition", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "sharedElement", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/SharedTransitionScope$SharedContentState;Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/animation/BoundsTransform;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZFLandroidx/compose/animation/SharedTransitionScope$OverlayClip;)Landroidx/compose/ui/Modifier;", "sharedContentState", "enter", "exit", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "resizeMode", "sharedBounds", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/SharedTransitionScope$SharedContentState;Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/animation/BoundsTransform;Landroidx/compose/animation/SharedTransitionScope$ResizeMode;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZFLandroidx/compose/animation/SharedTransitionScope$OverlayClip;)Landroidx/compose/ui/Modifier;", "visible", "sharedElementWithCallerManagedVisibility", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/SharedTransitionScope$SharedContentState;ZLandroidx/compose/animation/BoundsTransform;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZFLandroidx/compose/animation/SharedTransitionScope$OverlayClip;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/graphics/Shape;", "clipShape", "OverlayClip", "(Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "", "key", "rememberSharedContentState", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "isTransitionActive", "()Z", "PlaceHolderSize", "ResizeMode", "SharedContentState", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SharedTransitionScope extends LookaheadScope {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "", "getClipPath", "Landroidx/compose/ui/graphics/Path;", "state", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OverlayClip {
        Path getClipPath(SharedContentState state, Rect bounds, LayoutDirection layoutDirection, Density density);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bæ\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "", "calculateSize", "Landroidx/compose/ui/unit/IntSize;", "contentSize", "animatedSize", "calculateSize-JyjRU_E", "(JJ)J", "Companion", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PlaceHolderSize {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize$Companion;", "", "()V", "animatedSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "getAnimatedSize", "()Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "contentSize", "getContentSize", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final PlaceHolderSize animatedSize = new PlaceHolderSize() { // from class: androidx.compose.animation.SharedTransitionScope$PlaceHolderSize$Companion$animatedSize$1
                @Override // androidx.compose.animation.SharedTransitionScope.PlaceHolderSize
                /* renamed from: calculateSize-JyjRU_E */
                public final long mo107calculateSizeJyjRU_E(long j5, long j6) {
                    return j6;
                }
            };
            private static final PlaceHolderSize contentSize = new PlaceHolderSize() { // from class: androidx.compose.animation.SharedTransitionScope$PlaceHolderSize$Companion$contentSize$1
                @Override // androidx.compose.animation.SharedTransitionScope.PlaceHolderSize
                /* renamed from: calculateSize-JyjRU_E */
                public final long mo107calculateSizeJyjRU_E(long j5, long j6) {
                    return j5;
                }
            };

            private Companion() {
            }

            public final PlaceHolderSize getAnimatedSize() {
                return animatedSize;
            }

            public final PlaceHolderSize getContentSize() {
                return contentSize;
            }
        }

        /* renamed from: calculateSize-JyjRU_E, reason: not valid java name */
        long mo107calculateSizeJyjRU_E(long contentSize, long animatedSize);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0002\u0003\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "", "Companion", "Landroidx/compose/animation/RemeasureImpl;", "Landroidx/compose/animation/ScaleToBoundsImpl;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ResizeMode {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$ResizeMode$Companion;", "", "()V", "RemeasureToBounds", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "getRemeasureToBounds", "()Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "ScaleToBounds", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final ResizeMode RemeasureToBounds = RemeasureImpl.INSTANCE;

            private Companion() {
            }

            public static /* synthetic */ ResizeMode ScaleToBounds$default(Companion companion, ContentScale contentScale, Alignment alignment, int i, Object obj) {
                if ((i & 1) != 0) {
                    contentScale = ContentScale.INSTANCE.getFillWidth();
                }
                if ((i & 2) != 0) {
                    alignment = Alignment.INSTANCE.getCenter();
                }
                return companion.ScaleToBounds(contentScale, alignment);
            }

            public final ResizeMode ScaleToBounds(ContentScale contentScale, Alignment alignment) {
                return SharedTransitionScopeKt.ScaleToBoundsCached(contentScale, alignment);
            }

            public final ResizeMode getRemeasureToBounds() {
                return RemeasureToBounds;
            }
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R/\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\fR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "", "key", "(Ljava/lang/Object;)V", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay", "()Landroidx/compose/ui/graphics/Path;", "<set-?>", "Landroidx/compose/animation/SharedElementInternalState;", "internalState", "getInternalState$animation_release", "()Landroidx/compose/animation/SharedElementInternalState;", "setInternalState$animation_release", "(Landroidx/compose/animation/SharedElementInternalState;)V", "internalState$delegate", "Landroidx/compose/runtime/MutableState;", "isMatchFound", "", "()Z", "getKey", "()Ljava/lang/Object;", "nonNullInternalState", "getNonNullInternalState", "parentSharedContentState", "getParentSharedContentState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SharedContentState {
        public static final int $stable = 8;

        /* renamed from: internalState$delegate, reason: from kotlin metadata */
        private final MutableState internalState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        private final Object key;

        public SharedContentState(Object obj) {
            this.key = obj;
        }

        private final SharedElementInternalState getNonNullInternalState() {
            SharedElementInternalState internalState$animation_release = getInternalState$animation_release();
            if (internalState$animation_release != null) {
                return internalState$animation_release;
            }
            throw new IllegalArgumentException("Error: SharedContentState has not been added to a sharedElement/sharedBoundsmodifier yet. Therefore the internal state has not bee initialized.");
        }

        public final Path getClipPathInOverlay() {
            return getNonNullInternalState().getClipPathInOverlay();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final SharedElementInternalState getInternalState$animation_release() {
            return (SharedElementInternalState) this.internalState.getValue();
        }

        public final Object getKey() {
            return this.key;
        }

        public final SharedContentState getParentSharedContentState() {
            SharedElementInternalState parentState = getNonNullInternalState().getParentState();
            if (parentState != null) {
                return parentState.getUserState();
            }
            return null;
        }

        public final boolean isMatchFound() {
            SharedElement sharedElement;
            SharedElementInternalState internalState$animation_release = getInternalState$animation_release();
            if (internalState$animation_release == null || (sharedElement = internalState$animation_release.getSharedElement()) == null) {
                return false;
            }
            return sharedElement.getFoundMatch();
        }

        public final void setInternalState$animation_release(SharedElementInternalState sharedElementInternalState) {
            this.internalState.setValue(sharedElementInternalState);
        }
    }

    static /* synthetic */ Modifier renderInSharedTransitionScopeOverlay$default(SharedTransitionScope sharedTransitionScope, Modifier modifier, S7.a aVar, float f, n nVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderInSharedTransitionScopeOverlay");
        }
        if ((i & 1) != 0) {
            aVar = new S7.a() { // from class: androidx.compose.animation.SharedTransitionScope.renderInSharedTransitionScopeOverlay.1
                {
                    super(0);
                }

                @Override // S7.a
                public final Boolean invoke() {
                    return Boolean.valueOf(SharedTransitionScope.this.isTransitionActive());
                }
            };
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            nVar = SharedTransitionScopeKt.DefaultClipInOverlayDuringTransition;
        }
        return sharedTransitionScope.renderInSharedTransitionScopeOverlay(modifier, aVar, f, nVar);
    }

    static /* synthetic */ EnterTransition scaleInSharedContentToBounds$default(SharedTransitionScope sharedTransitionScope, ContentScale contentScale, Alignment alignment, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scaleInSharedContentToBounds");
        }
        if ((i & 1) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getCenter();
        }
        return sharedTransitionScope.scaleInSharedContentToBounds(contentScale, alignment);
    }

    static /* synthetic */ ExitTransition scaleOutSharedContentToBounds$default(SharedTransitionScope sharedTransitionScope, ContentScale contentScale, Alignment alignment, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scaleOutSharedContentToBounds");
        }
        if ((i & 1) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getCenter();
        }
        return sharedTransitionScope.scaleOutSharedContentToBounds(contentScale, alignment);
    }

    static /* synthetic */ Modifier sharedBounds$default(SharedTransitionScope sharedTransitionScope, Modifier modifier, SharedContentState sharedContentState, AnimatedVisibilityScope animatedVisibilityScope, EnterTransition enterTransition, ExitTransition exitTransition, BoundsTransform boundsTransform, ResizeMode resizeMode, PlaceHolderSize placeHolderSize, boolean z10, float f, OverlayClip overlayClip, int i, Object obj) {
        if (obj == null) {
            return sharedTransitionScope.sharedBounds(modifier, sharedContentState, animatedVisibilityScope, (i & 4) != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null) : enterTransition, (i & 8) != 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null) : exitTransition, (i & 16) != 0 ? SharedTransitionScopeKt.DefaultBoundsTransform : boundsTransform, (i & 32) != 0 ? ResizeMode.INSTANCE.ScaleToBounds(ContentScale.INSTANCE.getFillWidth(), Alignment.INSTANCE.getCenter()) : resizeMode, (i & 64) != 0 ? PlaceHolderSize.INSTANCE.getContentSize() : placeHolderSize, (i & 128) != 0 ? true : z10, (i & 256) != 0 ? 0.0f : f, (i & 512) != 0 ? SharedTransitionScopeKt.ParentClip : overlayClip);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedBounds");
    }

    static /* synthetic */ Modifier sharedElement$default(SharedTransitionScope sharedTransitionScope, Modifier modifier, SharedContentState sharedContentState, AnimatedVisibilityScope animatedVisibilityScope, BoundsTransform boundsTransform, PlaceHolderSize placeHolderSize, boolean z10, float f, OverlayClip overlayClip, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedElement");
        }
        if ((i & 4) != 0) {
            boundsTransform = SharedTransitionScopeKt.DefaultBoundsTransform;
        }
        BoundsTransform boundsTransform2 = boundsTransform;
        if ((i & 8) != 0) {
            placeHolderSize = PlaceHolderSize.INSTANCE.getContentSize();
        }
        return sharedTransitionScope.sharedElement(modifier, sharedContentState, animatedVisibilityScope, boundsTransform2, placeHolderSize, (i & 16) != 0 ? true : z10, (i & 32) != 0 ? 0.0f : f, (i & 64) != 0 ? SharedTransitionScopeKt.ParentClip : overlayClip);
    }

    static /* synthetic */ Modifier sharedElementWithCallerManagedVisibility$default(SharedTransitionScope sharedTransitionScope, Modifier modifier, SharedContentState sharedContentState, boolean z10, BoundsTransform boundsTransform, PlaceHolderSize placeHolderSize, boolean z11, float f, OverlayClip overlayClip, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedElementWithCallerManagedVisibility");
        }
        if ((i & 4) != 0) {
            boundsTransform = SharedTransitionScopeKt.DefaultBoundsTransform;
        }
        BoundsTransform boundsTransform2 = boundsTransform;
        if ((i & 8) != 0) {
            placeHolderSize = PlaceHolderSize.INSTANCE.getContentSize();
        }
        return sharedTransitionScope.sharedElementWithCallerManagedVisibility(modifier, sharedContentState, z10, boundsTransform2, placeHolderSize, (i & 16) != 0 ? true : z11, (i & 32) != 0 ? 0.0f : f, (i & 64) != 0 ? SharedTransitionScopeKt.ParentClip : overlayClip);
    }

    OverlayClip OverlayClip(Shape clipShape);

    boolean isTransitionActive();

    @Composable
    SharedContentState rememberSharedContentState(Object obj, Composer composer, int i);

    Modifier renderInSharedTransitionScopeOverlay(Modifier modifier, S7.a aVar, float f, n nVar);

    @c
    default EnterTransition scaleInSharedContentToBounds(ContentScale contentScale, Alignment alignment) {
        return EnterExitTransitionKt.withEffect(EnterTransition.INSTANCE.getNone(), new ContentScaleTransitionEffect(contentScale, alignment));
    }

    @c
    default ExitTransition scaleOutSharedContentToBounds(ContentScale contentScale, Alignment alignment) {
        return EnterExitTransitionKt.withEffect(ExitTransition.INSTANCE.getNone(), new ContentScaleTransitionEffect(contentScale, alignment));
    }

    Modifier sharedBounds(Modifier modifier, SharedContentState sharedContentState, AnimatedVisibilityScope animatedVisibilityScope, EnterTransition enterTransition, ExitTransition exitTransition, BoundsTransform boundsTransform, ResizeMode resizeMode, PlaceHolderSize placeHolderSize, boolean z10, float f, OverlayClip overlayClip);

    Modifier sharedElement(Modifier modifier, SharedContentState sharedContentState, AnimatedVisibilityScope animatedVisibilityScope, BoundsTransform boundsTransform, PlaceHolderSize placeHolderSize, boolean z10, float f, OverlayClip overlayClip);

    Modifier sharedElementWithCallerManagedVisibility(Modifier modifier, SharedContentState sharedContentState, boolean z10, BoundsTransform boundsTransform, PlaceHolderSize placeHolderSize, boolean z11, float f, OverlayClip overlayClip);

    Modifier skipToLookaheadSize(Modifier modifier);
}
