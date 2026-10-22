package androidx.compose.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u000423+4J\u001c\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0017J\u001c\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0017J\f\u0010\r\u001a\u00020\u000e*\u00020\u000eH&JD\u0010\u000f\u001a\u00020\u000e*\u00020\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015H&JN\u0010\u0019\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020#H&Jl\u0010$\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020#H&JN\u0010)\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020#H&J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-H&J\u0015\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H'¢\u0006\u0002\u00101R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00065À\u0006\u0001"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "isTransitionActive", "", "()Z", "scaleInSharedContentToBounds", "Landroidx/compose/animation/EnterTransition;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "scaleOutSharedContentToBounds", "Landroidx/compose/animation/ExitTransition;", "skipToLookaheadSize", "Landroidx/compose/ui/Modifier;", "renderInSharedTransitionScopeOverlay", "renderInOverlay", "Lkotlin/Function0;", "zIndexInOverlay", "", "clipInOverlayDuringTransition", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "sharedElement", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "placeHolderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "renderInOverlayDuringTransition", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "sharedBounds", "enter", "exit", "resizeMode", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "sharedElementWithCallerManagedVisibility", "visible", "OverlayClip", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "rememberSharedContentState", "key", "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "PlaceHolderSize", "ResizeMode", "SharedContentState", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SharedTransitionScope extends LookaheadScope {

    /* JADX INFO: renamed from: androidx.compose.animation.SharedTransitionScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @Deprecated(message = "This EnterTransition has been deprecated. Please replace the usage with resizeMode = ScaleToBounds(...) in sharedBounds to achieve the scale-to-bounds effect.")
        public static EnterTransition $default$scaleInSharedContentToBounds(SharedTransitionScope r100, ContentScale r101, Alignment r102) {
            return EnterExitTransitionKt.withEffect(EnterTransition.Companion.getNone(), new ContentScaleTransitionEffect(r101, r102));
        }

        @Deprecated(message = "This ExitTransition has been deprecated.  Please replace the usage with resizeMode = ScaleToBounds(...) in sharedBounds to achieve the scale-to-bounds effect.")
        public static ExitTransition $default$scaleOutSharedContentToBounds(SharedTransitionScope r100, ContentScale r101, Alignment r102) {
            return EnterExitTransitionKt.withEffect(ExitTransition.Companion.getNone(), new ContentScaleTransitionEffect(r101, r102));
        }

        public static /* synthetic */ EnterTransition scaleInSharedContentToBounds$default(SharedTransitionScope r100, ContentScale r101, Alignment r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = ContentScale.Companion.getFit();
        L7:
            if ((r103 & 2) == 0) goto L10;
            r102 = Alignment.Companion.getCenter();
        L10:
            return r100.scaleInSharedContentToBounds(r101, r102);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scaleInSharedContentToBounds");
        }

        public static /* synthetic */ ExitTransition scaleOutSharedContentToBounds$default(SharedTransitionScope r100, ContentScale r101, Alignment r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = ContentScale.Companion.getFit();
        L7:
            if ((r103 & 2) == 0) goto L10;
            r102 = Alignment.Companion.getCenter();
        L10:
            return r100.scaleOutSharedContentToBounds(r101, r102);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scaleOutSharedContentToBounds");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Modifier renderInSharedTransitionScopeOverlay$default(final SharedTransitionScope r100, Modifier r101, Function0 r102, float r103, Function2 r104, int r105, Object r106) {
            if (r106 != null) goto L15;
            if ((r105 & 1) == 0) goto L7;
            r102 = new AnonymousClass1(r100);
        L7:
            if ((r105 & 2) == 0) goto L10;
            r103 = 0.0f;
        L10:
            if ((r105 & 4) == 0) goto L13;
            r104 = SharedTransitionScopeKt.access$getDefaultClipInOverlayDuringTransition$p();
        L13:
            return r100.renderInSharedTransitionScopeOverlay(r101, r102, r103, r104);
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderInSharedTransitionScopeOverlay");
        }

        public static /* synthetic */ Modifier sharedElement$default(SharedTransitionScope r110, Modifier r111, SharedContentState r112, AnimatedVisibilityScope r113, BoundsTransform r114, PlaceHolderSize r115, boolean r116, float r117, OverlayClip r118, int r119, Object r210) {
            if (r210 != null) goto L26;
            if ((r119 & 4) == 0) goto L6;
            BoundsTransform r100 = SharedTransitionScopeKt.access$getDefaultBoundsTransform$p();
        L8:
            if ((r119 & 8) == 0) goto L10;
            PlaceHolderSize r101 = PlaceHolderSize.Companion.getContentSize();
        L12:
            if ((r119 & 16) == 0) goto L14;
            boolean r102 = true;
        L16:
            if ((r119 & 32) == 0) goto L18;
            float r103 = 0.0f;
        L20:
            if ((r119 & 64) == 0) goto L22;
            OverlayClip r104 = SharedTransitionScopeKt.access$getParentClip$p();
        L24:
            return r110.sharedElement(r111, r112, r113, r100, r101, r102, r103, r104);
        L22:
            r104 = r118;
            goto L24
        L18:
            r103 = r117;
            goto L20
        L14:
            r102 = r116;
            goto L16
        L10:
            r101 = r115;
            goto L12
        L6:
            r100 = r114;
            goto L8
        L26:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedElement");
        }

        public static /* synthetic */ Modifier sharedElementWithCallerManagedVisibility$default(SharedTransitionScope r110, Modifier r111, SharedContentState r112, boolean r113, BoundsTransform r114, PlaceHolderSize r115, boolean r116, float r117, OverlayClip r118, int r119, Object r210) {
            if (r210 != null) goto L26;
            if ((r119 & 4) == 0) goto L6;
            BoundsTransform r100 = SharedTransitionScopeKt.access$getDefaultBoundsTransform$p();
        L8:
            if ((r119 & 8) == 0) goto L10;
            PlaceHolderSize r101 = PlaceHolderSize.Companion.getContentSize();
        L12:
            if ((r119 & 16) == 0) goto L14;
            boolean r102 = true;
        L16:
            if ((r119 & 32) == 0) goto L18;
            float r103 = 0.0f;
        L20:
            if ((r119 & 64) == 0) goto L22;
            OverlayClip r104 = SharedTransitionScopeKt.access$getParentClip$p();
        L24:
            return r110.sharedElementWithCallerManagedVisibility(r111, r112, r113, r100, r101, r102, r103, r104);
        L22:
            r104 = r118;
            goto L24
        L18:
            r103 = r117;
            goto L20
        L14:
            r102 = r116;
            goto L16
        L10:
            r101 = r115;
            goto L12
        L6:
            r100 = r114;
            goto L8
        L26:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedElementWithCallerManagedVisibility");
        }

        public static /* synthetic */ Modifier sharedBounds$default(SharedTransitionScope r110, Modifier r111, SharedContentState r112, AnimatedVisibilityScope r210, EnterTransition r211, ExitTransition r212, BoundsTransform r213, ResizeMode r214, PlaceHolderSize r215, boolean r216, float r217, OverlayClip r218, int r219, Object r310) {
            if (r310 != null) goto L39;
            if ((r219 & 4) == 0) goto L7;
            EnterTransition r100 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
        L9:
            if ((r219 & 8) == 0) goto L11;
            ExitTransition r113 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
        L13:
            if ((r219 & 16) == 0) goto L15;
            BoundsTransform r114 = SharedTransitionScopeKt.access$getDefaultBoundsTransform$p();
        L17:
            if ((r219 & 32) == 0) goto L19;
            ResizeMode r115 = ResizeMode.Companion.ScaleToBounds(ContentScale.Companion.getFillWidth(), Alignment.Companion.getCenter());
        L21:
            if ((r219 & 64) == 0) goto L23;
            PlaceHolderSize r116 = PlaceHolderSize.Companion.getContentSize();
        L25:
            if ((r219 & 128) == 0) goto L27;
            boolean r117 = true;
        L29:
            if ((r219 & 256) == 0) goto L31;
            float r118 = 0.0f;
        L33:
            if ((r219 & 512) == 0) goto L35;
            OverlayClip r119 = SharedTransitionScopeKt.access$getParentClip$p();
        L37:
            return r110.sharedBounds(r111, r112, r210, r100, r113, r114, r115, r116, r117, r118, r119);
        L35:
            r119 = r218;
            goto L37
        L31:
            r118 = r217;
            goto L33
        L27:
            r117 = r216;
            goto L29
        L23:
            r116 = r215;
            goto L25
        L19:
            r115 = r214;
            goto L21
        L15:
            r114 = r213;
            goto L17
        L11:
            r113 = r212;
            goto L13
        L7:
            r100 = r211;
            goto L9
        L39:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedBounds");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "", "getClipPath", "Landroidx/compose/ui/graphics/Path;", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OverlayClip {
        Path getClipPath(SharedContentState r100, Rect r101, LayoutDirection r102, Density r103);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bæ\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "", "calculateSize", "Landroidx/compose/ui/unit/IntSize;", "contentSize", "animatedSize", "calculateSize-JyjRU_E", "(JJ)J", "Companion", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PlaceHolderSize {
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize$Companion;", "", "<init>", "()V", "animatedSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "getAnimatedSize", "()Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "contentSize", "getContentSize", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            private static final PlaceHolderSize animatedSize = null;
            private static final PlaceHolderSize contentSize = null;

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
                animatedSize = SharedTransitionScope$PlaceHolderSize$Companion$animatedSize$1.INSTANCE;
                contentSize = SharedTransitionScope$PlaceHolderSize$Companion$contentSize$1.INSTANCE;
            }

            public final PlaceHolderSize getAnimatedSize() {
                return animatedSize;
            }

            public final PlaceHolderSize getContentSize() {
                return contentSize;
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }

        /* JADX INFO: renamed from: calculateSize-JyjRU_E, reason: not valid java name */
        long mo105calculateSizeJyjRU_E(long r100, long r101);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0002\u0003\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "", "Companion", "Landroidx/compose/animation/RemeasureImpl;", "Landroidx/compose/animation/ScaleToBoundsImpl;", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ResizeMode {
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$ResizeMode$Companion;", "", "<init>", "()V", "RemeasureToBounds", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "getRemeasureToBounds", "()Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "ScaleToBounds", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            private static final ResizeMode RemeasureToBounds = null;

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
                RemeasureToBounds = RemeasureImpl.INSTANCE;
            }

            public final ResizeMode getRemeasureToBounds() {
                return RemeasureToBounds;
            }

            public final ResizeMode ScaleToBounds(ContentScale r100, Alignment r101) {
                return SharedTransitionScopeKt.access$ScaleToBoundsCached(r100, r101);
            }

            public static /* synthetic */ ResizeMode ScaleToBounds$default(Companion r100, ContentScale r101, Alignment r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = ContentScale.Companion.getFillWidth();
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = Alignment.Companion.getCenter();
            L9:
                return r100.ScaleToBounds(r101, r102);
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001c"}, d2 = {"Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "", "key", "<init>", "(Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "isMatchFound", "", "()Z", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay", "()Landroidx/compose/ui/graphics/Path;", "parentSharedContentState", "getParentSharedContentState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "<set-?>", "Landroidx/compose/animation/SharedElementInternalState;", "internalState", "getInternalState$animation", "()Landroidx/compose/animation/SharedElementInternalState;", "setInternalState$animation", "(Landroidx/compose/animation/SharedElementInternalState;)V", "internalState$delegate", "Landroidx/compose/runtime/MutableState;", "nonNullInternalState", "getNonNullInternalState", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SharedContentState {
        public static final int $stable = 8;
        private final MutableState internalState$delegate;
        private final Object key;

        /* JADX WARN: Multi-variable type inference failed */
        public final SharedElementInternalState getInternalState$animation() {
            return (SharedElementInternalState) this.internalState$delegate.getValue();
        }

        private final SharedElementInternalState getNonNullInternalState() {
            SharedElementInternalState r100 = getInternalState$animation();
            if (r100 == null) goto L6;
            return r100;
        L6:
            throw new IllegalArgumentException("Error: SharedContentState has not been added to a sharedElement/sharedBoundsmodifier yet. Therefore the internal state has not bee initialized.".toString());
        }

        public final Path getClipPathInOverlay() {
            return getNonNullInternalState().getClipPathInOverlay$animation();
        }

        public final SharedContentState getParentSharedContentState() {
            SharedElementInternalState r100 = getNonNullInternalState().getParentState();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getUserState();
        }

        public final boolean isMatchFound() {
            SharedElementInternalState r100 = getInternalState$animation();
            if (r100 == null) goto L7;
            SharedElement r101 = r100.getSharedElement();
            if (r101 == null) goto L7;
            return r101.getFoundMatch();
        L7:
            return false;
        }

        public final Object getKey() {
            return this.key;
        }

        public SharedContentState(Object r100) {
            this.key = r100;
            this.internalState$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        }

        public final void setInternalState$animation(SharedElementInternalState r100) {
            this.internalState$delegate.setValue(r100);
        }
    }

    OverlayClip OverlayClip(Shape r100);

    boolean isTransitionActive();

    SharedContentState rememberSharedContentState(Object r100, Composer r101, int r102);

    Modifier renderInSharedTransitionScopeOverlay(Modifier r100, Function0<Boolean> r101, float r102, Function2<? super LayoutDirection, ? super Density, ? extends Path> r103);

    @Deprecated(message = "This EnterTransition has been deprecated. Please replace the usage with resizeMode = ScaleToBounds(...) in sharedBounds to achieve the scale-to-bounds effect.")
    EnterTransition scaleInSharedContentToBounds(ContentScale r100, Alignment r101);

    @Deprecated(message = "This ExitTransition has been deprecated.  Please replace the usage with resizeMode = ScaleToBounds(...) in sharedBounds to achieve the scale-to-bounds effect.")
    ExitTransition scaleOutSharedContentToBounds(ContentScale r100, Alignment r101);

    Modifier sharedBounds(Modifier r100, SharedContentState r101, AnimatedVisibilityScope r102, EnterTransition r103, ExitTransition r104, BoundsTransform r105, ResizeMode r106, PlaceHolderSize r107, boolean r108, float r110, OverlayClip r111);

    Modifier sharedElement(Modifier r100, SharedContentState r101, AnimatedVisibilityScope r102, BoundsTransform r103, PlaceHolderSize r104, boolean r105, float r106, OverlayClip r107);

    Modifier sharedElementWithCallerManagedVisibility(Modifier r100, SharedContentState r101, boolean r102, BoundsTransform r103, PlaceHolderSize r104, boolean r105, float r106, OverlayClip r107);

    Modifier skipToLookaheadSize(Modifier r100);
}
