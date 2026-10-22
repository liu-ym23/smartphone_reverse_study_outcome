package androidx.compose.foundation.lazy.layout;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003;<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B2\b\u0017\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u0002\u0010\u000bB&\b\u0017\u0012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u0002\u0010\fJ\u0010\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020\u001dJ\u001d\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J<\u0010.\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020\u001d2\u0006\u0010/\u001a\u0002002\u001b\b\u0002\u00101\u001a\u0015\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b3\u00104JD\u0010.\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010/\u001a\u0002002\u0006\u0010+\u001a\u00020,2\u001b\b\u0002\u00101\u001a\u0015\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nH\u0000¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0000¢\u0006\u0002\b:R\"\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R'\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!¨\u0006>"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "", "<init>", "()V", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "onNestedPrefetch", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;Lkotlin/jvm/functions/Function1;)V", "(Lkotlin/jvm/functions/Function1;)V", "getPrefetchScheduler$foundation_release$annotations", "getPrefetchScheduler$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "setPrefetchScheduler$foundation_release", "(Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "getOnNestedPrefetch$annotations", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "prefetchHandleProvider", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "getPrefetchHandleProvider$foundation_release$annotations", "getPrefetchHandleProvider$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "setPrefetchHandleProvider$foundation_release", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;)V", "realizedNestedPrefetchCount", "", "getRealizedNestedPrefetchCount$foundation_release", "()I", "setRealizedNestedPrefetchCount$foundation_release", "(I)V", "idealNestedPrefetchCount", "getIdealNestedPrefetchCount$foundation_release", "setIdealNestedPrefetchCount$foundation_release", "lastNumberOfNestedPrefetchItems", "getLastNumberOfNestedPrefetchItems$foundation_release", "setLastNumberOfNestedPrefetchItems$foundation_release", "schedulePrecomposition", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "isHighPriority", "", "schedulePrecomposition$foundation_release", "schedulePrecompositionAndPremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "onItemPremeasured", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "schedulePrecompositionAndPremeasure-VKLhPVY", "(IJLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "schedulePrecompositionAndPremeasure-_EkL_-Y$foundation_release", "(IJZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "collectNestedPrefetchRequests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "collectNestedPrefetchRequests$foundation_release", "PrefetchHandle", "PrefetchResultScope", "NestedPrefetchScopeImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutPrefetchState {
    public static final int $stable = 0;
    private int idealNestedPrefetchCount;
    private int lastNumberOfNestedPrefetchItems;
    private Function1<? super NestedPrefetchScope, Unit> onNestedPrefetch;
    private PrefetchHandleProvider prefetchHandleProvider;
    private final PrefetchMetrics prefetchMetrics;
    private PrefetchScheduler prefetchScheduler;
    private int realizedNestedPrefetchCount;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u001f\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$NestedPrefetchScopeImpl;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "nestedPrefetchItemCount", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;I)V", "getNestedPrefetchItemCount", "()I", "requests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "getRequests", "()Ljava/util/List;", "_requests", "", "schedulePrecomposition", "", "index", "schedulePrecompositionAndPremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrecompositionAndPremeasure-0kLqBqw", "(IJ)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class NestedPrefetchScopeImpl implements NestedPrefetchScope {
        private final List<PrefetchRequest> _requests;
        private final int nestedPrefetchItemCount;
        final /* synthetic */ LazyLayoutPrefetchState this$0;

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public final /* synthetic */ void schedulePrefetch(int r100) {
            NestedPrefetchScope.CC.$default$schedulePrefetch(this, r100);
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        /* JADX INFO: renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
        public final /* synthetic */ void mo907schedulePrefetch0kLqBqw(int r100, long r101) {
            NestedPrefetchScope.CC.m909$default$schedulePrefetch0kLqBqw(this, r100, r101);
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public int getNestedPrefetchItemCount() {
            return this.nestedPrefetchItemCount;
        }

        public final List<PrefetchRequest> getRequests() {
            return this._requests;
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public void schedulePrecomposition(int r100) {
            PrefetchHandleProvider r101 = this.this$0.getPrefetchHandleProvider$foundation_release();
            if (r101 != null) goto L5;
            return;
        L5:
            this._requests.add(r101.createNestedPrefetchRequest(r100, LazyLayoutPrefetchState.access$getPrefetchMetrics$p(this.this$0)));
        }

        public NestedPrefetchScopeImpl(LazyLayoutPrefetchState r100, int r101) {
            this.this$0 = r100;
            this.nestedPrefetchItemCount = r101;
            this._requests = new ArrayList();
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        /* JADX INFO: renamed from: schedulePrecompositionAndPremeasure-0kLqBqw, reason: not valid java name */
        public void mo906schedulePrecompositionAndPremeasure0kLqBqw(int r100, long r101) {
            PrefetchHandleProvider r102 = this.this$0.getPrefetchHandleProvider$foundation_release();
            if (r102 != null) goto L5;
            return;
        L5:
            this._requests.add(r102.m920createNestedPrefetchRequestVKLhPVY(r100, r101, LazyLayoutPrefetchState.access$getPrefetchMetrics$p(this.this$0)));
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u000e\u0010\u0005\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0006\u0082\u0001\u0002\u0007\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "", "cancel", "", "markAsUrgent", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/lazy/layout/DummyHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PrefetchHandle {

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Object $default$await(PrefetchHandle r100, Continuation r101) {
                return await$suspendImpl(r100, r101);
            }

            public static /* synthetic */ Object await$suspendImpl(PrefetchHandle r100, Continuation<? super Unit> r101) {
                return Unit.INSTANCE;
            }
        }

        Object await(Continuation<? super Unit> r100);

        void cancel();

        void markAsUrgent();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0019\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u0082\u0001\u0001\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "", "placeablesCount", "", "getPlaceablesCount", "()I", "index", "getIndex", "getSize", "Landroidx/compose/ui/unit/IntSize;", "placeableIndex", "getSize-YEO4UFw", "(I)J", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PrefetchResultScope {
        int getIndex();

        int getPlaceablesCount();

        /* JADX INFO: renamed from: getSize-YEO4UFw, reason: not valid java name */
        long mo908getSizeYEO4UFw(int r100);
    }

    private static /* synthetic */ void getOnNestedPrefetch$annotations() {
    }

    public static /* synthetic */ void getPrefetchHandleProvider$foundation_release$annotations() {
    }

    public static /* synthetic */ void getPrefetchScheduler$foundation_release$annotations() {
    }

    public final List<PrefetchRequest> collectNestedPrefetchRequests$foundation_release() {
        Function1<? super NestedPrefetchScope, Unit> r100 = this.onNestedPrefetch;
        if (r100 == null) goto L5;
        NestedPrefetchScopeImpl r101 = new NestedPrefetchScopeImpl(this, this.realizedNestedPrefetchCount);
        r100.invoke(r101);
        List<PrefetchRequest> r102 = r101.getRequests();
        this.lastNumberOfNestedPrefetchItems = r102.size();
        return r102;
    L5:
        return CollectionsKt.emptyList();
    }

    public LazyLayoutPrefetchState() {
        this.prefetchMetrics = new PrefetchMetrics();
        this.realizedNestedPrefetchCount = -1;
        this.idealNestedPrefetchCount = -1;
    }

    public final int getIdealNestedPrefetchCount$foundation_release() {
        return this.idealNestedPrefetchCount;
    }

    public final int getLastNumberOfNestedPrefetchItems$foundation_release() {
        return this.lastNumberOfNestedPrefetchItems;
    }

    public final PrefetchHandleProvider getPrefetchHandleProvider$foundation_release() {
        return this.prefetchHandleProvider;
    }

    public final PrefetchScheduler getPrefetchScheduler$foundation_release() {
        return this.prefetchScheduler;
    }

    public final int getRealizedNestedPrefetchCount$foundation_release() {
        return this.realizedNestedPrefetchCount;
    }

    public LazyLayoutPrefetchState(Function1<? super NestedPrefetchScope, Unit> r100) {
        this();
        this.onNestedPrefetch = r100;
    }

    public static final /* synthetic */ PrefetchMetrics access$getPrefetchMetrics$p(LazyLayoutPrefetchState r100) {
        return r100.prefetchMetrics;
    }

    public final PrefetchHandle schedulePrecomposition(int r100) {
        return schedulePrecomposition$foundation_release(r100, true);
    }

    public final void setIdealNestedPrefetchCount$foundation_release(int r100) {
        this.idealNestedPrefetchCount = r100;
    }

    public final void setLastNumberOfNestedPrefetchItems$foundation_release(int r100) {
        this.lastNumberOfNestedPrefetchItems = r100;
    }

    public final void setPrefetchHandleProvider$foundation_release(PrefetchHandleProvider r100) {
        this.prefetchHandleProvider = r100;
    }

    public final void setPrefetchScheduler$foundation_release(PrefetchScheduler r100) {
        this.prefetchScheduler = r100;
    }

    public final void setRealizedNestedPrefetchCount$foundation_release(int r100) {
        this.realizedNestedPrefetchCount = r100;
    }

    @Deprecated(message = "Please use overload without Prefetch Scheduler.")
    public LazyLayoutPrefetchState(PrefetchScheduler r100, Function1<? super NestedPrefetchScope, Unit> r101) {
        this();
        this.prefetchScheduler = r100;
        this.onNestedPrefetch = r101;
    }

    public final PrefetchHandle schedulePrecomposition$foundation_release(int r100, boolean r101) {
        PrefetchHandleProvider r102 = this.prefetchHandleProvider;
        if (r102 == null) goto L7;
        PrefetchHandle r103 = r102.schedulePrecomposition(r100, r101, this.prefetchMetrics);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return DummyHandle.INSTANCE;
    }

    public /* synthetic */ LazyLayoutPrefetchState(Function1 r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }

    /* JADX INFO: renamed from: schedulePrecompositionAndPremeasure-VKLhPVY, reason: not valid java name */
    public final PrefetchHandle m904schedulePrecompositionAndPremeasureVKLhPVY(int r100, long r101, Function1<? super PrefetchResultScope, Unit> r110) {
        return m905schedulePrecompositionAndPremeasure_EkL_Y$foundation_release(r100, r101, true, r110);
    }

    public /* synthetic */ LazyLayoutPrefetchState(PrefetchScheduler r100, Function1 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }

    /* JADX INFO: renamed from: schedulePrecompositionAndPremeasure-_EkL_-Y$foundation_release, reason: not valid java name */
    public final PrefetchHandle m905schedulePrecompositionAndPremeasure_EkL_Y$foundation_release(int r100, long r101, boolean r110, Function1<? super PrefetchResultScope, Unit> r111) {
        PrefetchHandleProvider r102 = this.prefetchHandleProvider;
        if (r102 == null) goto L7;
        PrefetchHandle r103 = r102.m921schedulePremeasurem8Kt_7k(r100, r101, this.prefetchMetrics, r110, r111);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return DummyHandle.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: schedulePrecompositionAndPremeasure-VKLhPVY$default, reason: not valid java name */
    public static /* synthetic */ PrefetchHandle m902schedulePrecompositionAndPremeasureVKLhPVY$default(LazyLayoutPrefetchState r100, int r101, long r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        return r100.m904schedulePrecompositionAndPremeasureVKLhPVY(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: schedulePrecompositionAndPremeasure-_EkL_-Y$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ PrefetchHandle m903xe6b2911(LazyLayoutPrefetchState r100, int r101, long r102, boolean r110, Function1 r111, int r112, Object r113) {
        if ((r112 & 8) == 0) goto L6;
        r111 = null;
    L6:
        return r100.m905schedulePrecompositionAndPremeasure_EkL_Y$foundation_release(r101, r102, r110, r111);
    }
}
