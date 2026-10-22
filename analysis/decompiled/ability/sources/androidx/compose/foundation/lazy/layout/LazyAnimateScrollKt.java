package androidx.compose.foundation.lazy.layout;

import C7.r;
import J7.c;
import S7.a;
import S7.n;
import androidx.appfunctions.AppFunctionException;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001e\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0082\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\n\u001a\u00020\t*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a4\u0010\u0010\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014\"\u0014\u0010\u0016\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014\"\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkotlin/Function0;", "", "generateMsg", "LC7/r;", "debugLog", "(LS7/a;)V", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "", "index", "", "isItemVisible", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;I)Z", "scrollOffset", "numOfItemsForTeleport", "Landroidx/compose/ui/unit/Density;", "density", "animateScrollToItem", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;IIILandroidx/compose/ui/unit/Density;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/ui/unit/Dp;", "TargetDistance", "F", "BoundDistance", "MinimumDistance", "DEBUG", "Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyAnimateScrollKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.m6844constructorimpl(2500);
    private static final float BoundDistance = Dp.m6844constructorimpl(AppFunctionException.ERROR_RESOURCE_NOT_FOUND);
    private static final float MinimumDistance = Dp.m6844constructorimpl(50);

    @c(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", l = {174, 272}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/ScrollScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ Density $density;
        final /* synthetic */ int $index;
        final /* synthetic */ int $numOfItemsForTeleport;
        final /* synthetic */ int $scrollOffset;
        final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToItem;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, Density density, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i6, int i10, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$index = i;
            this.$density = density;
            this.$this_animateScrollToItem = lazyLayoutAnimateScrollScope;
            this.$scrollOffset = i6;
            this.$numOfItemsForTeleport = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$isOvershot(boolean z10, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i, int i6) {
            if (z10) {
                if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() > i) {
                    return true;
                }
                return lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() > i6;
            }
            if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() < i) {
                return true;
            }
            return lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() < i6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$index, this.$density, this.$this_animateScrollToItem, this.$scrollOffset, this.$numOfItemsForTeleport, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(ScrollScope scrollScope, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(scrollScope, cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00c8 A[Catch: ItemFoundInScroll -> 0x00f1, TryCatch #5 {ItemFoundInScroll -> 0x00f1, blocks: (B:27:0x00c4, B:29:0x00c8, B:31:0x00d0, B:33:0x00e4, B:43:0x00fd, B:47:0x013a), top: B:97:0x00c4 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e4 A[Catch: ItemFoundInScroll -> 0x00f1, TryCatch #5 {ItemFoundInScroll -> 0x00f1, blocks: (B:27:0x00c4, B:29:0x00c8, B:31:0x00d0, B:33:0x00e4, B:43:0x00fd, B:47:0x013a), top: B:97:0x00c4 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0137  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0139  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0145  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0148  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x018e  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0201  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0205  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0227  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x018e -> B:87:0x0196). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r36) {
            /*
                Method dump skipped, instructions count: 582
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object animateScrollToItem(LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i, int i6, int i10, Density density, H7.c<? super r> cVar) {
        Object objScroll = lazyLayoutAnimateScrollScope.scroll(new AnonymousClass2(i, density, lazyLayoutAnimateScrollScope, i6, i10, null), cVar);
        return objScroll == CoroutineSingletons.f4909a ? objScroll : r.f317a;
    }

    private static final void debugLog(a aVar) {
    }

    public static final boolean isItemVisible(LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i) {
        return i <= lazyLayoutAnimateScrollScope.getLastVisibleItemIndex() && lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() <= i;
    }
}
