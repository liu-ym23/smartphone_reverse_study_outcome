package androidx.compose.material3.carousel;

import C7.r;
import H4.o;
import H7.c;
import S7.a;
import S7.k;
import S7.n;
import androidx.annotation.FloatRange;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@ExperimentalMaterial3Api
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ<\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000fH\u0096@¢\u0006\u0004\b\u0015\u0010\u0016R.\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Landroidx/compose/material3/carousel/CarouselState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "", "currentItem", "", "currentItemOffsetFraction", "Lkotlin/Function0;", "itemCount", AppAgent.CONSTRUCT, "(IFLS7/a;)V", "delta", "dispatchRawDelta", "(F)F", "Landroidx/compose/foundation/MutatePriority;", "scrollPriority", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "LH7/c;", "LC7/r;", "", "block", "scroll", "(Landroidx/compose/foundation/MutatePriority;LS7/n;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/runtime/MutableState;", "itemCountState", "Landroidx/compose/runtime/MutableState;", "getItemCountState", "()Landroidx/compose/runtime/MutableState;", "setItemCountState", "(Landroidx/compose/runtime/MutableState;)V", "Landroidx/compose/foundation/pager/PagerState;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "getPagerState$material3_release", "()Landroidx/compose/foundation/pager/PagerState;", "setPagerState$material3_release", "(Landroidx/compose/foundation/pager/PagerState;)V", "", "isScrollInProgress", "()Z", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CarouselState implements ScrollableState {
    private MutableState<a> itemCountState;
    private PagerState pagerState;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Saver<CarouselState, ?> Saver = ListSaverKt.listSaver(new n() { // from class: androidx.compose.material3.carousel.CarouselState$Companion$Saver$1
        @Override // S7.n
        public final List<Object> invoke(SaverScope saverScope, CarouselState carouselState) {
            return o.N(Integer.valueOf(carouselState.getPagerState().getCurrentPage()), Float.valueOf(carouselState.getPagerState().getCurrentPageOffsetFraction()), Integer.valueOf(carouselState.getPagerState().getPageCount()));
        }
    }, new k() { // from class: androidx.compose.material3.carousel.CarouselState$Companion$Saver$2
        @Override // S7.k
        public final CarouselState invoke(final List<? extends Object> list) {
            Object obj = list.get(0);
            kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj).intValue();
            Object obj2 = list.get(1);
            kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.Float");
            return new CarouselState(iIntValue, ((Float) obj2).floatValue(), new a() { // from class: androidx.compose.material3.carousel.CarouselState$Companion$Saver$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final Integer invoke() {
                    Object obj3 = list.get(2);
                    kotlin.jvm.internal.k.d(obj3, "null cannot be cast to non-null type kotlin.Int");
                    return (Integer) obj3;
                }
            });
        }
    });

    @ExperimentalMaterial3Api
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/carousel/CarouselState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/carousel/CarouselState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Saver<CarouselState, ?> getSaver() {
            return CarouselState.Saver;
        }

        private Companion() {
        }
    }

    public CarouselState(int i, @FloatRange(from = -0.5d, to = 0.5d) float f, a aVar) {
        MutableState<a> mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(aVar, null, 2, null);
        this.itemCountState = mutableStateMutableStateOf$default;
        this.pagerState = PagerStateKt.PagerState(i, f, mutableStateMutableStateOf$default.getValue());
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.pagerState.dispatchRawDelta(delta);
    }

    public final MutableState<a> getItemCountState() {
        return this.itemCountState;
    }

    /* renamed from: getPagerState$material3_release, reason: from getter */
    public final PagerState getPagerState() {
        return this.pagerState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.pagerState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority mutatePriority, n nVar, c<? super r> cVar) {
        Object objScroll = this.pagerState.scroll(mutatePriority, nVar, cVar);
        return objScroll == CoroutineSingletons.f4909a ? objScroll : r.f317a;
    }

    public final void setItemCountState(MutableState<a> mutableState) {
        this.itemCountState = mutableState;
    }

    public final void setPagerState$material3_release(PagerState pagerState) {
        this.pagerState = pagerState;
    }

    public /* synthetic */ CarouselState(int i, float f, a aVar, int i6, e eVar) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0.0f : f, aVar);
    }
}
