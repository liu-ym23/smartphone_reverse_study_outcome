package com.bytedance.android.livesdk.calendar;

import android.database.Cursor;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Lcom/bytedance/android/livesdk/calendar/CalendarManager$a;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.calendar.CalendarManager$getCalendars$1$1", f = "CalendarManager.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
final class CalendarManager$getCalendars$1$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super CalendarManager.a>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Cursor $it;
    private /* synthetic */ Object L$0;
    int label;

    public CalendarManager$getCalendars$1$1(Cursor r100, Continuation r101) {
        this.$it = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        CalendarManager$getCalendars$1$1 r102 = new CalendarManager$getCalendars$1$1(this.$it, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super CalendarManager.a> r100, Continuation<? super Unit> r101) {
        return ((CalendarManager$getCalendars$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        SequenceScope r102 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r110);
    L11:
        if (this.$it.moveToNext() == false) goto L16;
        long r103 = this.$it.getLong(0);
        String r104 = this.$it.getString(1);
        String r105 = this.$it.getString(2);
        String r111 = this.$it.getString(3);
        CalendarManager.a r106 = new CalendarManager.a(r103, r104, r105, this.$it.getString(4), r111, this.$it.getInt(5), this.$it.getString(6));
        this.L$0 = r102;
        this.label = 1;
        if (r102.yield(r106, this) != r100) goto L11;
        return r100;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        r102 = (SequenceScope) this.L$0;
        goto L11
    }
}
