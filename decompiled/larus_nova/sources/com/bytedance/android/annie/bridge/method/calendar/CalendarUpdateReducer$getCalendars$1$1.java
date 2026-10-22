package com.bytedance.android.annie.bridge.method.calendar;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Lcom/bytedance/android/annie/bridge/method/calendar/b;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.annie.bridge.method.calendar.CalendarUpdateReducer$getCalendars$1$1", f = "CalendarUpdateReducer.kt", i = {0}, l = {134}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
final class CalendarUpdateReducer$getCalendars$1$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super b>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Cursor $it;
    private /* synthetic */ Object L$0;
    int label;

    public CalendarUpdateReducer$getCalendars$1$1(Cursor r100, Continuation<? super CalendarUpdateReducer$getCalendars$1$1> r101) {
        this.$it = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CalendarUpdateReducer$getCalendars$1$1 r102 = new CalendarUpdateReducer$getCalendars$1$1(this.$it, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super b> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super b> r100, Continuation<? super Unit> r101) {
        return ((CalendarUpdateReducer$getCalendars$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        SequenceScope r102 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r110);
    L10:
        if (this.$it.moveToNext() == false) goto L15;
        long r103 = this.$it.getLong(0);
        String r104 = this.$it.getString(1);
        String r111 = this.$it.getString(2);
        String r112 = this.$it.getString(3);
        b r105 = new b(r103, r104, r111, this.$it.getString(4), r112, this.$it.getInt(5), this.$it.getString(6), 128, 0);
        this.L$0 = r102;
        this.label = 1;
        if (r102.yield(r105, this) != r100) goto L10;
        return r100;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        r102 = (SequenceScope) this.L$0;
        goto L10
    }
}
