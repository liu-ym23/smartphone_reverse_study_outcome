package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import Y7.f;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.CalendarModel;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.material3.DatePickerKt$HorizontalMonthsList$2$1", f = "DatePicker.kt", l = {1678}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class DatePickerKt$HorizontalMonthsList$2$1 extends SuspendLambda implements n {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ k $onDisplayedMonthChange;
    final /* synthetic */ f $yearRange;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$HorizontalMonthsList$2$1(LazyListState lazyListState, k kVar, CalendarModel calendarModel, f fVar, H7.c<? super DatePickerKt$HorizontalMonthsList$2$1> cVar) {
        super(2, cVar);
        this.$lazyListState = lazyListState;
        this.$onDisplayedMonthChange = kVar;
        this.$calendarModel = calendarModel;
        this.$yearRange = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new DatePickerKt$HorizontalMonthsList$2$1(this.$lazyListState, this.$onDisplayedMonthChange, this.$calendarModel, this.$yearRange, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            LazyListState lazyListState = this.$lazyListState;
            k kVar = this.$onDisplayedMonthChange;
            CalendarModel calendarModel = this.$calendarModel;
            f fVar = this.$yearRange;
            this.label = 1;
            if (DatePickerKt.updateDisplayedMonth(lazyListState, kVar, calendarModel, fVar, this) == coroutineSingletons) {
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
        return ((DatePickerKt$HorizontalMonthsList$2$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
