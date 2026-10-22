package com.stepos.alphame.persona.common.time;

import Z2.F;
import Z2.I;
import Z2.Q;
import android.text.TextUtils;
import androidx.lifecycle.P;
import androidx.lifecycle.U;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.common.utils.LogKt;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.persona.common.time.bean.TimeInfo;
import com.stepos.alphame.persona.data.PersonalDataType;
import com.stepos.alphame.persona.data.repo.PersonalRepo;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.domain.event.Messages;
import com.stepos.alphame.persona.domain.event.TimeMessages;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.LongKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.J;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0006J\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010(\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020,8F¢\u0006\u0006\u001a\u0004\b/\u0010.R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020,8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010.R\u0011\u00104\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00107\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/stepos/alphame/persona/common/time/PersonalCommonTimePickerRequester;", "LR1/a;", "", "option", "", "setTimeOption", "(J)V", "", "id", "setEventId", "(I)V", "result", "setCustomResult", "Lcom/stepos/alphame/persona/domain/event/Messages;", "getFinalResult", "()Lcom/stepos/alphame/persona/domain/event/Messages;", "getTimeResult", "()J", "getCustomTime", "saveData", "()V", "requestData", "Landroidx/lifecycle/U;", "_option", "Landroidx/lifecycle/U;", "_autoTime", "_customTime", "Lcom/stepos/alphame/persona/domain/event/EventId;", "_eventId", "Lcom/stepos/alphame/persona/domain/event/EventId;", "Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "mAutoTimeInfo", "Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "_mCustomTimeInfo", "", "autoLearningState", "Z", PersonalContract.FUN_GET_AUTO_LEARNING_STATE, "()Z", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "repo", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "getRepo", "()Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "Landroidx/lifecycle/P;", "getOption", "()Landroidx/lifecycle/P;", "getAutoTime", "autoTime", "customTime", "getEventId", "()Lcom/stepos/alphame/persona/domain/event/EventId;", "eventId", "getMCustomTimeInfo", "()Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "mCustomTimeInfo", "<init>", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PersonalCommonTimePickerRequester extends R1.a {
    private final boolean autoLearningState;

    @NotNull
    private final PersonalRepo repo;

    @NotNull
    private U _option = new U();

    @NotNull
    private U _autoTime = new U();

    @NotNull
    private U _customTime = new U();

    @NotNull
    private EventId _eventId = EventId.TIME_AWAY_FROM_HOME;

    @NotNull
    private TimeInfo mAutoTimeInfo = new TimeInfo();

    @NotNull
    private TimeInfo _mCustomTimeInfo = new TimeInfo();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.common.time.PersonalCommonTimePickerRequester$requestData$1", f = "PersonalCommonTimePickerRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.persona.common.time.PersonalCommonTimePickerRequester$requestData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return PersonalCommonTimePickerRequester.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PersonalCommonTimePickerRequester personalCommonTimePickerRequester = PersonalCommonTimePickerRequester.this;
            personalCommonTimePickerRequester._mCustomTimeInfo = personalCommonTimePickerRequester.getRepo().getTimeInfo(PersonalCommonTimePickerRequester.this.get_eventId());
            String dateHourAndMin = "";
            String dateHourAndMin2 = PersonalCommonTimePickerRequester.this._mCustomTimeInfo.getTime() != 0 ? LongKt.formatDateHourAndMin(PersonalCommonTimePickerRequester.this._mCustomTimeInfo.getTime()) : "";
            LogKt.logD(PersonalContract.TIME_TAG, "requestData get saveTime " + dateHourAndMin2);
            if (PersonalCommonTimePickerRequester.this.getAutoLearningState()) {
                PersonalCommonTimePickerRequester personalCommonTimePickerRequester2 = PersonalCommonTimePickerRequester.this;
                personalCommonTimePickerRequester2.mAutoTimeInfo = personalCommonTimePickerRequester2.getRepo().getAutoTimeInfo(PersonalCommonTimePickerRequester.this.get_eventId());
                if (PersonalCommonTimePickerRequester.this.mAutoTimeInfo.getTime() != 0) {
                    dateHourAndMin = LongKt.formatDateHourAndMin(PersonalCommonTimePickerRequester.this.mAutoTimeInfo.getTime());
                    PersonalCommonTimePickerRequester.this._autoTime.h(Boxing.boxLong(PersonalCommonTimePickerRequester.this.mAutoTimeInfo.getTime()));
                }
                LogKt.logD(PersonalContract.TIME_TAG, "autoTime " + dateHourAndMin);
                if (PersonalCommonTimePickerRequester.this._mCustomTimeInfo.getType() != PersonalDataType.AUTO.getType() || TextUtils.isEmpty(dateHourAndMin2) || TextUtils.isEmpty(dateHourAndMin) || Intrinsics.areEqual(dateHourAndMin2, dateHourAndMin)) {
                    PersonalCommonTimePickerRequester.this._option.h(Boxing.boxLong(PersonalCommonTimePickerRequester.this._mCustomTimeInfo.getType()));
                    if (PersonalCommonTimePickerRequester.this._mCustomTimeInfo.getType() == PersonalDataType.CUSTOM.getType()) {
                        PersonalCommonTimePickerRequester.this._customTime.h(Boxing.boxLong(PersonalCommonTimePickerRequester.this._mCustomTimeInfo.getTime()));
                    }
                } else {
                    TimeInfo timeInfo = PersonalCommonTimePickerRequester.this._mCustomTimeInfo;
                    PersonalDataType personalDataType = PersonalDataType.CUSTOM;
                    timeInfo.setType(personalDataType.getType());
                    PersonalCommonTimePickerRequester.this._option.h(Boxing.boxLong(personalDataType.getType()));
                    PersonalCommonTimePickerRequester.this._customTime.h(Boxing.boxLong(PersonalCommonTimePickerRequester.this._mCustomTimeInfo.getTime()));
                }
            } else {
                PersonalCommonTimePickerRequester.this._mCustomTimeInfo.setType(PersonalDataType.CUSTOM.getType());
                if (PersonalCommonTimePickerRequester.this.get_mCustomTimeInfo().getTime() == 0) {
                    PersonalCommonTimePickerRequester.this._mCustomTimeInfo.setTime(System.currentTimeMillis());
                }
                LogKt.logD(PersonalContract.TIME_TAG, "requestData set customType , time " + LongKt.formatDateHourAndMin(PersonalCommonTimePickerRequester.this._mCustomTimeInfo.getTime()));
                PersonalCommonTimePickerRequester.this._customTime.h(Boxing.boxLong(PersonalCommonTimePickerRequester.this._mCustomTimeInfo.getTime()));
                PersonalCommonTimePickerRequester.this._option.h(Boxing.boxLong(PersonalCommonTimePickerRequester.this._mCustomTimeInfo.getType()));
            }
            return Unit.INSTANCE;
        }
    }

    public PersonalCommonTimePickerRequester() {
        PersonalRepo.Companion companion = PersonalRepo.INSTANCE;
        this.autoLearningState = companion.getINSTANCE().getAutoLearningState();
        this.repo = companion.getINSTANCE();
    }

    public final boolean getAutoLearningState() {
        return this.autoLearningState;
    }

    @NotNull
    public final P getAutoTime() {
        return this._autoTime;
    }

    @NotNull
    /* renamed from: getCustomTime, reason: collision with other method in class */
    public final P m15getCustomTime() {
        return this._customTime;
    }

    @NotNull
    /* renamed from: getEventId, reason: from getter */
    public final EventId get_eventId() {
        return this._eventId;
    }

    @NotNull
    public final Messages getFinalResult() {
        return this._mCustomTimeInfo.getType() == PersonalDataType.CUSTOM.getType() ? new TimeMessages(get_eventId(), this._mCustomTimeInfo) : new TimeMessages(get_eventId(), this.mAutoTimeInfo);
    }

    @NotNull
    /* renamed from: getMCustomTimeInfo, reason: from getter */
    public final TimeInfo get_mCustomTimeInfo() {
        return this._mCustomTimeInfo;
    }

    @NotNull
    public final P getOption() {
        return this._option;
    }

    @NotNull
    public final PersonalRepo getRepo() {
        return this.repo;
    }

    public final long getTimeResult() {
        if (this._mCustomTimeInfo.getType() == PersonalDataType.AUTO.getType()) {
            return this.mAutoTimeInfo.getTime();
        }
        LogKt.logD(PersonalContract.TIME_TAG, "get custom time " + this._mCustomTimeInfo.getTime());
        return this._mCustomTimeInfo.getTime();
    }

    public final void requestData() {
        J.y(I.t(this), Q.f2190b, new AnonymousClass1(null), 2);
    }

    public final void saveData() {
        TimeInfo timeInfo = this._mCustomTimeInfo.getType() == PersonalDataType.CUSTOM.getType() ? this._mCustomTimeInfo : this.mAutoTimeInfo;
        LogKt.logD(PersonalContract.TIME_TAG, "saveData " + timeInfo + AwarenessDataItem.PERMISSION_SPLITTER + LongKt.formatDateHourAndMin(timeInfo.getTime()));
        this.repo.setTimeInfo(get_eventId(), timeInfo);
    }

    public final void setCustomResult(long result) {
        AlphaMeLogger.debugLog(PersonalContract.TIME_TAG, "result " + LongKt.formatDateFull(result, "yyyy/MM/dd HH:mm:ss"));
        TimeInfo timeInfo = this._mCustomTimeInfo;
        timeInfo.setType(PersonalDataType.CUSTOM.getType());
        timeInfo.setTime(result);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0024 A[PHI: r1
      0x0024: PHI (r1v6 com.stepos.alphame.persona.domain.event.EventId) = 
      (r1v3 com.stepos.alphame.persona.domain.event.EventId)
      (r1v4 com.stepos.alphame.persona.domain.event.EventId)
      (r1v5 com.stepos.alphame.persona.domain.event.EventId)
     binds: [B:6:0x0022, B:9:0x002c, B:12:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setEventId(int r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "page "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PersonalTime"
            com.stepos.alphame.utils.AlphaMeLogger.debugLog(r1, r0)
            com.stepos.alphame.persona.domain.event.EventId r0 = com.stepos.alphame.persona.domain.event.EventId.TIME_AWAY_FROM_HOME
            int r1 = r0.getId()
            if (r4 != r1) goto L1c
            goto L38
        L1c:
            com.stepos.alphame.persona.domain.event.EventId r1 = com.stepos.alphame.persona.domain.event.EventId.OFF_DUTY_TIME
            int r2 = r1.getId()
            if (r4 != r2) goto L26
        L24:
            r0 = r1
            goto L38
        L26:
            com.stepos.alphame.persona.domain.event.EventId r1 = com.stepos.alphame.persona.domain.event.EventId.SLEEP_TIME
            int r2 = r1.getId()
            if (r4 != r2) goto L2f
            goto L24
        L2f:
            com.stepos.alphame.persona.domain.event.EventId r1 = com.stepos.alphame.persona.domain.event.EventId.WAKE_UP_TIME
            int r2 = r1.getId()
            if (r4 != r2) goto L38
            goto L24
        L38:
            r3._eventId = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.persona.common.time.PersonalCommonTimePickerRequester.setEventId(int):void");
    }

    public final void setTimeOption(long option) {
        AlphaMeLogger.debugLog(PersonalContract.TIME_TAG, "option " + option);
        this._mCustomTimeInfo.setType(option);
    }

    public final long getCustomTime() {
        if (this._mCustomTimeInfo.getTime() != 0) {
            return this._mCustomTimeInfo.getTime();
        }
        this._mCustomTimeInfo.setTime(System.currentTimeMillis());
        return System.currentTimeMillis();
    }
}
