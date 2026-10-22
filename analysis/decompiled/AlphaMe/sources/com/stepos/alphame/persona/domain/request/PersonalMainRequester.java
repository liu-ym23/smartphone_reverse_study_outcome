package com.stepos.alphame.persona.domain.request;

import R1.a;
import S.A;
import Z2.E0;
import Z2.F;
import Z2.G;
import Z2.I;
import Z2.Q;
import Z2.n0;
import Z2.o0;
import android.text.TextUtils;
import androidx.lifecycle.C0307d;
import androidx.lifecycle.C0314k;
import androidx.lifecycle.C0320q;
import androidx.lifecycle.P;
import androidx.lifecycle.U;
import b3.C0369C;
import b3.InterfaceC0367A;
import b3.InterfaceC0379h;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.R;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.common.utils.LogKt;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.persona.address.data.AddressInfo;
import com.stepos.alphame.persona.carbluetooth.bean.BluetoothInfo;
import com.stepos.alphame.persona.common.time.bean.TimeInfo;
import com.stepos.alphame.persona.data.PersonalDataType;
import com.stepos.alphame.persona.data.config.PersonalPreferenceConfigs;
import com.stepos.alphame.persona.data.repo.PersonalRepo;
import com.stepos.alphame.persona.domain.event.AddressMessages;
import com.stepos.alphame.persona.domain.event.BluetoothMessages;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.domain.event.Messages;
import com.stepos.alphame.persona.domain.event.TimeMessages;
import com.stepos.alphame.persona.domain.event.WifiMessages;
import com.stepos.alphame.persona.wifi.bean.WifiInfo;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.LongKt;
import d3.q;
import f3.d;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import l.C0744b;
import m.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.J;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bq\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002¢\u0006\u0004\b&\u0010'R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010+R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010+R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010+R\u001c\u00102\u001a\b\u0012\u0004\u0012\u0002010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010+R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010+R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010+R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010+R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00110(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010+R\u0016\u00107\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010=\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010@\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010:\u001a\u0004\b?\u0010<R\u0016\u0010A\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR$\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u00050Cj\b\u0012\u0004\u0012\u00020\u0005`D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bJ\u0010IR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bN\u0010MR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bR\u0010QR\u0016\u0010S\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010T\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bT\u0010QR\u0016\u0010V\u001a\u00020U8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020)0\u00158F¢\u0006\u0006\u001a\u0004\b[\u0010\u0017R\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020)0\u00158F¢\u0006\u0006\u001a\u0004\b]\u0010\u0017R\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020)0\u00158F¢\u0006\u0006\u001a\u0004\b_\u0010\u0017R\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020)0\u00158F¢\u0006\u0006\u001a\u0004\ba\u0010\u0017R\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020)0\u00158F¢\u0006\u0006\u001a\u0004\bc\u0010\u0017R\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020)0\u00158F¢\u0006\u0006\u001a\u0004\be\u0010\u0017R\u0017\u0010h\u001a\b\u0012\u0004\u0012\u0002010\u00158F¢\u0006\u0006\u001a\u0004\bg\u0010\u0017R\u0017\u0010j\u001a\b\u0012\u0004\u0012\u00020)0\u00158F¢\u0006\u0006\u001a\u0004\bi\u0010\u0017R\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020)0\u00158F¢\u0006\u0006\u001a\u0004\bk\u0010\u0017R\u0017\u0010n\u001a\b\u0012\u0004\u0012\u00020)0\u00158F¢\u0006\u0006\u001a\u0004\bm\u0010\u0017R\u0017\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158F¢\u0006\u0006\u001a\u0004\bo\u0010\u0017¨\u0006r"}, d2 = {"Lcom/stepos/alphame/persona/domain/request/PersonalMainRequester;", "LR1/a;", "", "requestData", "()V", "Lcom/stepos/alphame/persona/domain/event/Messages;", "getTask", "()Lcom/stepos/alphame/persona/domain/event/Messages;", "checkUpdateFinish", "task", "updateAutoInfo", "(Lcom/stepos/alphame/persona/domain/event/Messages;)V", "checkAutoInfoUpdate", "", "mode", "postCommutingMode", "(I)V", "", "state", "postAutoLearningState", "(Z)V", "Landroidx/lifecycle/P;", "requestAutoLearningState", "()Landroidx/lifecycle/P;", "messages", "isSave", "setCustomPreference", "(Lcom/stepos/alphame/persona/domain/event/Messages;Z)V", "Lcom/stepos/alphame/persona/domain/event/AddressMessages;", "setAddressInfo", "(Lcom/stepos/alphame/persona/domain/event/AddressMessages;Z)V", "Lcom/stepos/alphame/persona/domain/event/WifiMessages;", "setWifiInfo", "(Lcom/stepos/alphame/persona/domain/event/WifiMessages;Z)V", "Lcom/stepos/alphame/persona/domain/event/TimeMessages;", "setTimeInfo", "(Lcom/stepos/alphame/persona/domain/event/TimeMessages;Z)V", "Lcom/stepos/alphame/persona/domain/event/BluetoothMessages;", "setBluetoothInfo", "(Lcom/stepos/alphame/persona/domain/event/BluetoothMessages;Z)V", "Landroidx/lifecycle/U;", "", "_homeAddress", "Landroidx/lifecycle/U;", "_companyAddress", "_homeWifi", "_companyWifi", "_timeAwayFromHome", "_offDutyTime", "", "_commutingMode", "_sleepTime", "_wakeupTime", "_carBluetoothName", "_autoInfoUpdate", "autoLearningState", "Z", "learningTip$delegate", "Lkotlin/Lazy;", "getLearningTip", "()Ljava/lang/String;", "learningTip", "noInformationTip$delegate", "getNoInformationTip", "noInformationTip", "mCheckingIndex", "I", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mTaskList", "Ljava/util/ArrayList;", "Lcom/stepos/alphame/persona/address/data/AddressInfo;", "mHomeAddress", "Lcom/stepos/alphame/persona/address/data/AddressInfo;", "mCompanyAddress", "Lcom/stepos/alphame/persona/wifi/bean/WifiInfo;", "mHomeWifi", "Lcom/stepos/alphame/persona/wifi/bean/WifiInfo;", "mCompanyWifi", "Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "mTimeAwayFromHome", "Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "mOffDutyTime", "mSleepTime", "mWakeupTime", "Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", "mBluetoothInfo", "Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "repo", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", PersonalContract.FUN_GET_HOME_ADDRESS, "homeAddress", PersonalContract.FUN_GET_COMPANY_ADDRESS, "companyAddress", PersonalContract.FUN_GET_HOME_WIFI, "homeWifi", PersonalContract.FUN_GET_COMPANY_WIFI, "companyWifi", PersonalContract.FUN_GET_TIME_AWAY_FROM_HOME, "timeAwayFromHome", PersonalContract.FUN_GET_OFF_DUTY_TIME, "offDutyTime", PersonalContract.FUN_GET_COMMUTING_MODE, "commutingMode", PersonalContract.FUN_GET_SLEEP_TIME, "sleepTime", PersonalContract.FUN_GET_WAKEUP_TIME, "wakeupTime", "getCarBluetoothName", "carBluetoothName", "getAutoInfoUpdate", "autoInfoUpdate", "<init>", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PersonalMainRequester extends a {
    private boolean autoLearningState;

    /* renamed from: learningTip$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy learningTip;
    private BluetoothInfo mBluetoothInfo;
    private int mCheckingIndex;
    private AddressInfo mCompanyAddress;
    private WifiInfo mCompanyWifi;
    private AddressInfo mHomeAddress;
    private WifiInfo mHomeWifi;
    private TimeInfo mOffDutyTime;
    private TimeInfo mSleepTime;

    @NotNull
    private final ArrayList<Messages> mTaskList;
    private TimeInfo mTimeAwayFromHome;
    private TimeInfo mWakeupTime;

    /* renamed from: noInformationTip$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy noInformationTip;

    @NotNull
    private final PersonalRepo repo;

    @NotNull
    private U _homeAddress = new U();

    @NotNull
    private U _companyAddress = new U();

    @NotNull
    private U _homeWifi = new U();

    @NotNull
    private U _companyWifi = new U();

    @NotNull
    private U _timeAwayFromHome = new U();

    @NotNull
    private U _offDutyTime = new U();

    @NotNull
    private U _commutingMode = new U();

    @NotNull
    private U _sleepTime = new U();

    @NotNull
    private U _wakeupTime = new U();

    @NotNull
    private U _carBluetoothName = new U();

    @NotNull
    private U _autoInfoUpdate = new U();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventId.values().length];
            try {
                iArr[EventId.HOME_ADDRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventId.COMPANY_ADDRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventId.HOME_WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EventId.COMPANY_WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EventId.TIME_AWAY_FROM_HOME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EventId.OFF_DUTY_TIME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EventId.SLEEP_TIME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EventId.WAKE_UP_TIME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.domain.request.PersonalMainRequester$postAutoLearningState$1", f = "PersonalMainRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.persona.domain.request.PersonalMainRequester$postAutoLearningState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z4, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = z4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, continuation);
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
            PersonalPreferenceConfigs.INSTANCE.setAutoLearningStatus(this.$state);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.domain.request.PersonalMainRequester$requestData$1", f = "PersonalMainRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.persona.domain.request.PersonalMainRequester$requestData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04801 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        int label;

        public C04801(Continuation<? super C04801> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return PersonalMainRequester.this.new C04801(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04801) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            U u4;
            String noInformationTip;
            U u5;
            String noInformationTip2;
            U u6;
            String noInformationTip3;
            U u7;
            String noInformationTip4;
            U u8;
            String noInformationTip5;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PersonalMainRequester personalMainRequester = PersonalMainRequester.this;
            personalMainRequester.mHomeAddress = personalMainRequester.repo.getAddressInfo(EventId.HOME_ADDRESS);
            AddressInfo addressInfo = PersonalMainRequester.this.mHomeAddress;
            BluetoothInfo bluetoothInfo = null;
            if (addressInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomeAddress");
                addressInfo = null;
            }
            if (TextUtils.isEmpty(addressInfo.getName())) {
                if (PersonalMainRequester.this.autoLearningState) {
                    u4 = PersonalMainRequester.this._homeAddress;
                    noInformationTip = PersonalMainRequester.this.getLearningTip();
                } else {
                    u4 = PersonalMainRequester.this._homeAddress;
                    noInformationTip = PersonalMainRequester.this.getNoInformationTip();
                }
                u4.g(noInformationTip);
            } else {
                U u9 = PersonalMainRequester.this._homeAddress;
                AddressInfo addressInfo2 = PersonalMainRequester.this.mHomeAddress;
                if (addressInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHomeAddress");
                    addressInfo2 = null;
                }
                u9.g(addressInfo2.getName());
            }
            PersonalMainRequester personalMainRequester2 = PersonalMainRequester.this;
            personalMainRequester2.mCompanyAddress = personalMainRequester2.repo.getAddressInfo(EventId.COMPANY_ADDRESS);
            AddressInfo addressInfo3 = PersonalMainRequester.this.mCompanyAddress;
            if (addressInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCompanyAddress");
                addressInfo3 = null;
            }
            if (!TextUtils.isEmpty(addressInfo3.getName())) {
                U u10 = PersonalMainRequester.this._companyAddress;
                AddressInfo addressInfo4 = PersonalMainRequester.this.mCompanyAddress;
                if (addressInfo4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCompanyAddress");
                    addressInfo4 = null;
                }
                u10.g(addressInfo4.getName());
            } else if (PersonalMainRequester.this.autoLearningState) {
                PersonalMainRequester.this._companyAddress.g(PersonalMainRequester.this.getLearningTip());
            } else {
                PersonalMainRequester.this._companyAddress.g(PersonalMainRequester.this.getNoInformationTip());
            }
            PersonalMainRequester personalMainRequester3 = PersonalMainRequester.this;
            personalMainRequester3.mHomeWifi = personalMainRequester3.repo.getWifiInfo(EventId.HOME_WIFI);
            WifiInfo wifiInfo = PersonalMainRequester.this.mHomeWifi;
            if (wifiInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomeWifi");
                wifiInfo = null;
            }
            if (TextUtils.isEmpty(wifiInfo.getSsid())) {
                if (PersonalMainRequester.this.autoLearningState) {
                    u5 = PersonalMainRequester.this._homeWifi;
                    noInformationTip2 = PersonalMainRequester.this.getLearningTip();
                } else {
                    u5 = PersonalMainRequester.this._homeWifi;
                    noInformationTip2 = PersonalMainRequester.this.getNoInformationTip();
                }
                u5.g(noInformationTip2);
            } else {
                U u11 = PersonalMainRequester.this._homeWifi;
                WifiInfo wifiInfo2 = PersonalMainRequester.this.mHomeWifi;
                if (wifiInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHomeWifi");
                    wifiInfo2 = null;
                }
                u11.g(wifiInfo2.getSsid());
            }
            PersonalMainRequester personalMainRequester4 = PersonalMainRequester.this;
            personalMainRequester4.mCompanyWifi = personalMainRequester4.repo.getWifiInfo(EventId.COMPANY_WIFI);
            WifiInfo wifiInfo3 = PersonalMainRequester.this.mCompanyWifi;
            if (wifiInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCompanyWifi");
                wifiInfo3 = null;
            }
            if (TextUtils.isEmpty(wifiInfo3.getSsid())) {
                if (PersonalMainRequester.this.autoLearningState) {
                    u6 = PersonalMainRequester.this._companyWifi;
                    noInformationTip3 = PersonalMainRequester.this.getLearningTip();
                } else {
                    u6 = PersonalMainRequester.this._companyWifi;
                    noInformationTip3 = PersonalMainRequester.this.getNoInformationTip();
                }
                u6.g(noInformationTip3);
            } else {
                U u12 = PersonalMainRequester.this._companyWifi;
                WifiInfo wifiInfo4 = PersonalMainRequester.this.mCompanyWifi;
                if (wifiInfo4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCompanyWifi");
                    wifiInfo4 = null;
                }
                u12.g(wifiInfo4.getSsid());
            }
            PersonalMainRequester personalMainRequester5 = PersonalMainRequester.this;
            personalMainRequester5.mTimeAwayFromHome = personalMainRequester5.repo.getTimeInfo(EventId.TIME_AWAY_FROM_HOME);
            TimeInfo timeInfo = PersonalMainRequester.this.mTimeAwayFromHome;
            if (timeInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTimeAwayFromHome");
                timeInfo = null;
            }
            if (timeInfo.getTime() != 0) {
                U u13 = PersonalMainRequester.this._timeAwayFromHome;
                TimeInfo timeInfo2 = PersonalMainRequester.this.mTimeAwayFromHome;
                if (timeInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeAwayFromHome");
                    timeInfo2 = null;
                }
                u13.g(LongKt.formatDateHourAndMin(timeInfo2.getTime()));
            } else if (PersonalMainRequester.this.autoLearningState) {
                PersonalMainRequester.this._timeAwayFromHome.g(PersonalMainRequester.this.getLearningTip());
            } else {
                PersonalMainRequester.this._timeAwayFromHome.g(PersonalMainRequester.this.getNoInformationTip());
            }
            PersonalMainRequester personalMainRequester6 = PersonalMainRequester.this;
            personalMainRequester6.mOffDutyTime = personalMainRequester6.repo.getTimeInfo(EventId.OFF_DUTY_TIME);
            TimeInfo timeInfo3 = PersonalMainRequester.this.mOffDutyTime;
            if (timeInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOffDutyTime");
                timeInfo3 = null;
            }
            if (timeInfo3.getTime() != 0) {
                U u14 = PersonalMainRequester.this._offDutyTime;
                TimeInfo timeInfo4 = PersonalMainRequester.this.mOffDutyTime;
                if (timeInfo4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mOffDutyTime");
                    timeInfo4 = null;
                }
                u14.g(LongKt.formatDateHourAndMin(timeInfo4.getTime()));
            } else if (PersonalMainRequester.this.autoLearningState) {
                PersonalMainRequester.this._offDutyTime.g(PersonalMainRequester.this.getLearningTip());
            } else {
                PersonalMainRequester.this._offDutyTime.g(PersonalMainRequester.this.getNoInformationTip());
            }
            PersonalMainRequester.this._commutingMode.g(Boxing.boxLong(PersonalMainRequester.this.repo.getCommutingMode()));
            PersonalMainRequester personalMainRequester7 = PersonalMainRequester.this;
            personalMainRequester7.mSleepTime = personalMainRequester7.repo.getTimeInfo(EventId.SLEEP_TIME);
            TimeInfo timeInfo5 = PersonalMainRequester.this.mSleepTime;
            if (timeInfo5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSleepTime");
                timeInfo5 = null;
            }
            if (timeInfo5.getTime() != 0) {
                U u15 = PersonalMainRequester.this._sleepTime;
                TimeInfo timeInfo6 = PersonalMainRequester.this.mSleepTime;
                if (timeInfo6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSleepTime");
                    timeInfo6 = null;
                }
                u15.g(LongKt.formatDateFull(timeInfo6.getTime(), "HH:mm"));
            } else {
                if (PersonalMainRequester.this.autoLearningState) {
                    u7 = PersonalMainRequester.this._sleepTime;
                    noInformationTip4 = PersonalMainRequester.this.getLearningTip();
                } else {
                    u7 = PersonalMainRequester.this._sleepTime;
                    noInformationTip4 = PersonalMainRequester.this.getNoInformationTip();
                }
                u7.g(noInformationTip4);
            }
            PersonalMainRequester personalMainRequester8 = PersonalMainRequester.this;
            personalMainRequester8.mWakeupTime = personalMainRequester8.repo.getTimeInfo(EventId.WAKE_UP_TIME);
            TimeInfo timeInfo7 = PersonalMainRequester.this.mWakeupTime;
            if (timeInfo7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWakeupTime");
                timeInfo7 = null;
            }
            if (timeInfo7.getTime() != 0) {
                U u16 = PersonalMainRequester.this._wakeupTime;
                TimeInfo timeInfo8 = PersonalMainRequester.this.mWakeupTime;
                if (timeInfo8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWakeupTime");
                    timeInfo8 = null;
                }
                u16.g(LongKt.formatDateFull(timeInfo8.getTime(), "HH:mm"));
            } else {
                if (PersonalMainRequester.this.autoLearningState) {
                    u8 = PersonalMainRequester.this._wakeupTime;
                    noInformationTip5 = PersonalMainRequester.this.getLearningTip();
                } else {
                    u8 = PersonalMainRequester.this._wakeupTime;
                    noInformationTip5 = PersonalMainRequester.this.getNoInformationTip();
                }
                u8.g(noInformationTip5);
            }
            PersonalMainRequester personalMainRequester9 = PersonalMainRequester.this;
            personalMainRequester9.mBluetoothInfo = personalMainRequester9.repo.getCarBluetoothInfo(EventId.CAR_BLUETOOTH);
            BluetoothInfo bluetoothInfo2 = PersonalMainRequester.this.mBluetoothInfo;
            if (bluetoothInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBluetoothInfo");
                bluetoothInfo2 = null;
            }
            if (!TextUtils.isEmpty(bluetoothInfo2.getBluetoothName())) {
                U u17 = PersonalMainRequester.this._carBluetoothName;
                BluetoothInfo bluetoothInfo3 = PersonalMainRequester.this.mBluetoothInfo;
                if (bluetoothInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBluetoothInfo");
                } else {
                    bluetoothInfo = bluetoothInfo3;
                }
                u17.g(bluetoothInfo.getBluetoothName());
            } else if (PersonalMainRequester.this.autoLearningState) {
                PersonalMainRequester.this._carBluetoothName.g(PersonalMainRequester.this.getLearningTip());
            } else {
                PersonalMainRequester.this._carBluetoothName.g(PersonalMainRequester.this.getNoInformationTip());
            }
            return Unit.INSTANCE;
        }
    }

    public PersonalMainRequester() {
        PersonalRepo.Companion companion = PersonalRepo.INSTANCE;
        this.autoLearningState = companion.getINSTANCE().getAutoLearningState();
        this.learningTip = LazyKt.lazy(new Function0<String>() { // from class: com.stepos.alphame.persona.domain.request.PersonalMainRequester$learningTip$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String string = ApplicationImpl.getApplication().getString(R.string.learning);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
        });
        this.noInformationTip = LazyKt.lazy(new Function0<String>() { // from class: com.stepos.alphame.persona.domain.request.PersonalMainRequester$noInformationTip$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String string = ApplicationImpl.getApplication().getString(R.string.no_information);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
        });
        this.mTaskList = new ArrayList<>();
        this.repo = companion.getINSTANCE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLearningTip() {
        return (String) this.learningTip.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getNoInformationTip() {
        return (String) this.noInformationTip.getValue();
    }

    private final void setAddressInfo(AddressMessages messages, boolean isSave) {
        int i4 = WhenMappings.$EnumSwitchMapping$0[messages.getEventId().ordinal()];
        AddressInfo addressInfo = null;
        if (i4 == 1) {
            AddressInfo addressInfo2 = messages.getAddressInfo();
            this.mHomeAddress = addressInfo2;
            if (addressInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomeAddress");
                addressInfo2 = null;
            }
            if (TextUtils.isEmpty(addressInfo2.getName())) {
                this._homeAddress.g(this.autoLearningState ? getLearningTip() : getNoInformationTip());
            } else {
                U u4 = this._homeAddress;
                AddressInfo addressInfo3 = this.mHomeAddress;
                if (addressInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHomeAddress");
                } else {
                    addressInfo = addressInfo3;
                }
                u4.g(addressInfo.getName());
            }
        } else if (i4 == 2) {
            AddressInfo addressInfo4 = messages.getAddressInfo();
            this.mCompanyAddress = addressInfo4;
            if (addressInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCompanyAddress");
                addressInfo4 = null;
            }
            if (TextUtils.isEmpty(addressInfo4.getName())) {
                this._companyAddress.g(this.autoLearningState ? getLearningTip() : getNoInformationTip());
            } else {
                U u5 = this._companyAddress;
                AddressInfo addressInfo5 = this.mCompanyAddress;
                if (addressInfo5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCompanyAddress");
                } else {
                    addressInfo = addressInfo5;
                }
                u5.g(addressInfo.getName());
            }
        }
        if (isSave) {
            this.repo.setAddressInfo(messages.getEventId(), messages.getAddressInfo());
        }
    }

    private final void setBluetoothInfo(BluetoothMessages messages, boolean isSave) {
        BluetoothInfo bluetoothInfo = messages.getBluetoothInfo();
        this.mBluetoothInfo = bluetoothInfo;
        BluetoothInfo bluetoothInfo2 = null;
        if (bluetoothInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBluetoothInfo");
            bluetoothInfo = null;
        }
        if (TextUtils.isEmpty(bluetoothInfo.getBluetoothName())) {
            this._carBluetoothName.g(this.autoLearningState ? getLearningTip() : getNoInformationTip());
        } else {
            U u4 = this._carBluetoothName;
            BluetoothInfo bluetoothInfo3 = this.mBluetoothInfo;
            if (bluetoothInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBluetoothInfo");
            } else {
                bluetoothInfo2 = bluetoothInfo3;
            }
            u4.g(bluetoothInfo2.getBluetoothName());
        }
        if (isSave) {
            this.repo.setCarBluetoothInfo(messages.getEventId(), messages.getBluetoothInfo());
        }
    }

    private final void setTimeInfo(TimeMessages messages, boolean isSave) {
        int i4 = WhenMappings.$EnumSwitchMapping$0[messages.getEventId().ordinal()];
        TimeInfo timeInfo = null;
        if (i4 == 5) {
            TimeInfo timeInfo2 = messages.getTimeInfo();
            this.mTimeAwayFromHome = timeInfo2;
            if (timeInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTimeAwayFromHome");
                timeInfo2 = null;
            }
            TimeInfo timeInfo3 = this.mTimeAwayFromHome;
            if (timeInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTimeAwayFromHome");
                timeInfo3 = null;
            }
            LogKt.logD("PersonalMain", "get message, mTimeAwayFromHome " + timeInfo2 + AwarenessDataItem.PERMISSION_SPLITTER + LongKt.formatDateHourAndMin(timeInfo3.getTime()));
            if (messages.getTimeInfo().getTime() == 0) {
                this._timeAwayFromHome.g(this.autoLearningState ? getLearningTip() : getNoInformationTip());
            } else {
                U u4 = this._timeAwayFromHome;
                TimeInfo timeInfo4 = this.mTimeAwayFromHome;
                if (timeInfo4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeAwayFromHome");
                } else {
                    timeInfo = timeInfo4;
                }
                u4.g(LongKt.formatDateFull(timeInfo.getTime(), "HH:mm"));
            }
        } else if (i4 == 6) {
            TimeInfo timeInfo5 = messages.getTimeInfo();
            this.mOffDutyTime = timeInfo5;
            if (timeInfo5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOffDutyTime");
                timeInfo5 = null;
            }
            TimeInfo timeInfo6 = this.mOffDutyTime;
            if (timeInfo6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOffDutyTime");
                timeInfo6 = null;
            }
            LogKt.logD("PersonalMain", "get message, mOffDutyTime " + timeInfo5 + AwarenessDataItem.PERMISSION_SPLITTER + LongKt.formatDateHourAndMin(timeInfo6.getTime()));
            if (messages.getTimeInfo().getTime() == 0) {
                this._offDutyTime.g(this.autoLearningState ? getLearningTip() : getNoInformationTip());
            } else {
                U u5 = this._offDutyTime;
                TimeInfo timeInfo7 = this.mOffDutyTime;
                if (timeInfo7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mOffDutyTime");
                } else {
                    timeInfo = timeInfo7;
                }
                u5.g(LongKt.formatDateFull(timeInfo.getTime(), "HH:mm"));
            }
        } else if (i4 == 7) {
            TimeInfo timeInfo8 = messages.getTimeInfo();
            this.mSleepTime = timeInfo8;
            if (timeInfo8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSleepTime");
                timeInfo8 = null;
            }
            TimeInfo timeInfo9 = this.mSleepTime;
            if (timeInfo9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSleepTime");
                timeInfo9 = null;
            }
            LogKt.logD("PersonalMain", "get message, mSleepTime " + timeInfo8 + AwarenessDataItem.PERMISSION_SPLITTER + LongKt.formatDateHourAndMin(timeInfo9.getTime()));
            if (messages.getTimeInfo().getTime() == 0) {
                this._sleepTime.g(this.autoLearningState ? getLearningTip() : getNoInformationTip());
            } else {
                U u6 = this._sleepTime;
                TimeInfo timeInfo10 = this.mSleepTime;
                if (timeInfo10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSleepTime");
                } else {
                    timeInfo = timeInfo10;
                }
                u6.g(LongKt.formatDateFull(timeInfo.getTime(), "HH:mm"));
            }
        } else if (i4 != 8) {
            AlphaMeLogger.debugLog("Personal", "eventId " + messages.getEventId());
        } else {
            TimeInfo timeInfo11 = messages.getTimeInfo();
            this.mWakeupTime = timeInfo11;
            if (timeInfo11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWakeupTime");
                timeInfo11 = null;
            }
            TimeInfo timeInfo12 = this.mWakeupTime;
            if (timeInfo12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWakeupTime");
                timeInfo12 = null;
            }
            LogKt.logD("PersonalMain", "get message, mWakeupTime " + timeInfo11 + AwarenessDataItem.PERMISSION_SPLITTER + LongKt.formatDateHourAndMin(timeInfo12.getTime()));
            if (messages.getTimeInfo().getTime() == 0) {
                this._wakeupTime.g(this.autoLearningState ? getLearningTip() : getNoInformationTip());
            } else {
                U u7 = this._wakeupTime;
                TimeInfo timeInfo13 = this.mWakeupTime;
                if (timeInfo13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWakeupTime");
                } else {
                    timeInfo = timeInfo13;
                }
                u7.g(LongKt.formatDateFull(timeInfo.getTime(), "HH:mm"));
            }
        }
        if (isSave) {
            this.repo.setTimeInfo(messages.getEventId(), messages.getTimeInfo());
        }
    }

    private final void setWifiInfo(WifiMessages messages, boolean isSave) {
        int i4 = WhenMappings.$EnumSwitchMapping$0[messages.getEventId().ordinal()];
        WifiInfo wifiInfo = null;
        if (i4 == 3) {
            WifiInfo wifiInfo2 = messages.getWifiInfo();
            this.mHomeWifi = wifiInfo2;
            if (wifiInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomeWifi");
                wifiInfo2 = null;
            }
            if (TextUtils.isEmpty(wifiInfo2.getSsid())) {
                this._homeWifi.g(this.autoLearningState ? getLearningTip() : getNoInformationTip());
            } else {
                U u4 = this._homeWifi;
                WifiInfo wifiInfo3 = this.mHomeWifi;
                if (wifiInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHomeWifi");
                } else {
                    wifiInfo = wifiInfo3;
                }
                u4.g(wifiInfo.getSsid());
            }
        } else if (i4 == 4) {
            WifiInfo wifiInfo4 = messages.getWifiInfo();
            this.mCompanyWifi = wifiInfo4;
            if (wifiInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCompanyWifi");
                wifiInfo4 = null;
            }
            if (TextUtils.isEmpty(wifiInfo4.getSsid())) {
                this._companyWifi.g(this.autoLearningState ? getLearningTip() : getNoInformationTip());
            } else {
                U u5 = this._companyWifi;
                WifiInfo wifiInfo5 = this.mCompanyWifi;
                if (wifiInfo5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCompanyWifi");
                } else {
                    wifiInfo = wifiInfo5;
                }
                u5.g(wifiInfo.getSsid());
            }
        }
        if (isSave) {
            this.repo.setWifiInfo(messages.getEventId(), messages.getWifiInfo());
        }
    }

    public final void checkAutoInfoUpdate() {
        if (this.autoLearningState) {
            AlphaMeLogger.debugLog("Personal", "checkAutoInfoUpdate");
            this.mTaskList.clear();
            PersonalRepo personalRepo = this.repo;
            EventId eventId = EventId.HOME_ADDRESS;
            AddressInfo autoAddress = personalRepo.getAutoAddress(eventId);
            AlphaMeLogger.debugLog("Personal", "home address " + autoAddress);
            String name = autoAddress.getName();
            AddressInfo addressInfo = this.mHomeAddress;
            BluetoothInfo bluetoothInfo = null;
            if (addressInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomeAddress");
                addressInfo = null;
            }
            if (!Intrinsics.areEqual(name, addressInfo.getName()) && !TextUtils.isEmpty(autoAddress.getName())) {
                this.mTaskList.add(new AddressMessages(eventId, autoAddress));
            }
            PersonalRepo personalRepo2 = this.repo;
            EventId eventId2 = EventId.COMPANY_ADDRESS;
            AddressInfo autoAddress2 = personalRepo2.getAutoAddress(eventId2);
            AlphaMeLogger.debugLog("Personal", "autoCompanyAddress " + autoAddress2);
            String name2 = autoAddress2.getName();
            AddressInfo addressInfo2 = this.mCompanyAddress;
            if (addressInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCompanyAddress");
                addressInfo2 = null;
            }
            if (!Intrinsics.areEqual(name2, addressInfo2.getName()) && !TextUtils.isEmpty(autoAddress2.getName())) {
                this.mTaskList.add(new AddressMessages(eventId2, autoAddress2));
            }
            PersonalRepo personalRepo3 = this.repo;
            EventId eventId3 = EventId.HOME_WIFI;
            WifiInfo autoWifi = personalRepo3.getAutoWifi(eventId3);
            AlphaMeLogger.debugLog("Personal", "autoHomeWifi " + autoWifi);
            String ssid = autoWifi.getSsid();
            WifiInfo wifiInfo = this.mHomeWifi;
            if (wifiInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomeWifi");
                wifiInfo = null;
            }
            if (!Intrinsics.areEqual(ssid, wifiInfo.getSsid()) && !TextUtils.isEmpty(autoWifi.getSsid())) {
                this.mTaskList.add(new WifiMessages(eventId3, autoWifi));
            }
            PersonalRepo personalRepo4 = this.repo;
            EventId eventId4 = EventId.COMPANY_WIFI;
            WifiInfo autoWifi2 = personalRepo4.getAutoWifi(eventId4);
            AlphaMeLogger.debugLog("Personal", "autoCompanyWifi " + autoWifi2);
            String ssid2 = autoWifi2.getSsid();
            WifiInfo wifiInfo2 = this.mCompanyWifi;
            if (wifiInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCompanyWifi");
                wifiInfo2 = null;
            }
            if (!Intrinsics.areEqual(ssid2, wifiInfo2.getSsid()) && !TextUtils.isEmpty(autoWifi2.getSsid())) {
                this.mTaskList.add(new WifiMessages(eventId4, autoWifi2));
            }
            PersonalRepo personalRepo5 = this.repo;
            EventId eventId5 = EventId.TIME_AWAY_FROM_HOME;
            TimeInfo autoTimeInfo = personalRepo5.getAutoTimeInfo(eventId5);
            AlphaMeLogger.debugLog("Personal", "autoCommutingInfo " + autoTimeInfo);
            if (autoTimeInfo.getTime() != 0) {
                String dateHourAndMin = LongKt.formatDateHourAndMin(autoTimeInfo.getTime());
                TimeInfo timeInfo = this.mTimeAwayFromHome;
                if (timeInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeAwayFromHome");
                    timeInfo = null;
                }
                if (!Intrinsics.areEqual(dateHourAndMin, LongKt.formatDateHourAndMin(timeInfo.getTime()))) {
                    this.mTaskList.add(new TimeMessages(eventId5, new TimeInfo(PersonalDataType.AUTO.getType(), autoTimeInfo.getTime())));
                }
            }
            PersonalRepo personalRepo6 = this.repo;
            EventId eventId6 = EventId.OFF_DUTY_TIME;
            TimeInfo autoTimeInfo2 = personalRepo6.getAutoTimeInfo(eventId6);
            if (autoTimeInfo2.getTime() != 0) {
                String dateHourAndMin2 = LongKt.formatDateHourAndMin(autoTimeInfo2.getTime());
                TimeInfo timeInfo2 = this.mOffDutyTime;
                if (timeInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mOffDutyTime");
                    timeInfo2 = null;
                }
                if (!Intrinsics.areEqual(dateHourAndMin2, LongKt.formatDateHourAndMin(timeInfo2.getTime()))) {
                    this.mTaskList.add(new TimeMessages(eventId6, new TimeInfo(PersonalDataType.AUTO.getType(), autoTimeInfo2.getTime())));
                }
            }
            PersonalRepo personalRepo7 = this.repo;
            EventId eventId7 = EventId.SLEEP_TIME;
            TimeInfo autoTimeInfo3 = personalRepo7.getAutoTimeInfo(eventId7);
            AlphaMeLogger.debugLog("Personal", "autoSleepInfo " + autoTimeInfo3);
            if (autoTimeInfo3.getTime() != 0) {
                String dateHourAndMin3 = LongKt.formatDateHourAndMin(autoTimeInfo3.getTime());
                TimeInfo timeInfo3 = this.mSleepTime;
                if (timeInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSleepTime");
                    timeInfo3 = null;
                }
                if (!Intrinsics.areEqual(dateHourAndMin3, LongKt.formatDateHourAndMin(timeInfo3.getTime()))) {
                    this.mTaskList.add(new TimeMessages(eventId7, new TimeInfo(PersonalDataType.AUTO.getType(), autoTimeInfo3.getTime())));
                }
            }
            PersonalRepo personalRepo8 = this.repo;
            EventId eventId8 = EventId.WAKE_UP_TIME;
            TimeInfo autoTimeInfo4 = personalRepo8.getAutoTimeInfo(eventId8);
            if (autoTimeInfo4.getTime() != 0) {
                String dateHourAndMin4 = LongKt.formatDateHourAndMin(autoTimeInfo4.getTime());
                TimeInfo timeInfo4 = this.mWakeupTime;
                if (timeInfo4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWakeupTime");
                    timeInfo4 = null;
                }
                if (!Intrinsics.areEqual(dateHourAndMin4, LongKt.formatDateHourAndMin(timeInfo4.getTime()))) {
                    this.mTaskList.add(new TimeMessages(eventId8, new TimeInfo(PersonalDataType.AUTO.getType(), autoTimeInfo4.getTime())));
                }
            }
            BluetoothInfo autoCarBluetooth = this.repo.getAutoCarBluetooth();
            String bluetoothName = autoCarBluetooth.getBluetoothName();
            BluetoothInfo bluetoothInfo2 = this.mBluetoothInfo;
            if (bluetoothInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBluetoothInfo");
            } else {
                bluetoothInfo = bluetoothInfo2;
            }
            if (!Intrinsics.areEqual(bluetoothName, bluetoothInfo.getBluetoothName()) && !TextUtils.isEmpty(autoCarBluetooth.getBluetoothName())) {
                this.mTaskList.add(new BluetoothMessages(EventId.CAR_BLUETOOTH, autoCarBluetooth));
            }
            AlphaMeLogger.debugLog("Personal", "checkAutoInfoUpdate " + this.mTaskList.size());
            if (!this.mTaskList.isEmpty()) {
                this._autoInfoUpdate.g(Boolean.TRUE);
            }
        }
    }

    public final void checkUpdateFinish() {
        this._autoInfoUpdate.g(Boolean.valueOf(this.mCheckingIndex >= this.mTaskList.size()));
    }

    @NotNull
    public final P getAutoInfoUpdate() {
        return this._autoInfoUpdate;
    }

    @NotNull
    public final P getCarBluetoothName() {
        return this._carBluetoothName;
    }

    @NotNull
    public final P getCommutingMode() {
        return this._commutingMode;
    }

    @NotNull
    public final P getCompanyAddress() {
        return this._companyAddress;
    }

    @NotNull
    public final P getCompanyWifi() {
        return this._companyWifi;
    }

    @NotNull
    public final P getHomeAddress() {
        return this._homeAddress;
    }

    @NotNull
    public final P getHomeWifi() {
        return this._homeWifi;
    }

    @NotNull
    public final P getOffDutyTime() {
        return this._offDutyTime;
    }

    @NotNull
    public final P getSleepTime() {
        return this._sleepTime;
    }

    @Nullable
    public final Messages getTask() {
        if (this.mCheckingIndex >= this.mTaskList.size()) {
            AlphaMeLogger.debugLog("Personal", "reset checkingIndex " + this.mCheckingIndex);
            return null;
        }
        ArrayList<Messages> arrayList = this.mTaskList;
        int i4 = this.mCheckingIndex;
        this.mCheckingIndex = i4 + 1;
        Messages messages = arrayList.get(i4);
        Intrinsics.checkNotNullExpressionValue(messages, "get(...)");
        Messages messages2 = messages;
        AlphaMeLogger.debugLog("Personal", "checkingIndex " + this.mCheckingIndex);
        return messages2;
    }

    @NotNull
    public final P getTimeAwayFromHome() {
        return this._timeAwayFromHome;
    }

    @NotNull
    public final P getWakeupTime() {
        return this._wakeupTime;
    }

    public final void postAutoLearningState(boolean state) {
        AlphaMeLogger.debugLog("Personal", "auto learning state " + state);
        this.autoLearningState = state;
        J.y(I.t(this), null, new AnonymousClass1(state, null), 3);
    }

    public final void postCommutingMode(int mode) {
        long j4 = mode;
        this._commutingMode.g(Long.valueOf(j4));
        this.repo.setCommutingMode(j4);
    }

    @NotNull
    public final P requestAutoLearningState() {
        InterfaceC0379h data = PersonalPreferenceConfigs.INSTANCE.readData(PersonalPreferenceConfigs.KEY_IS_AUTO_LEARNING, Boolean.TRUE);
        EmptyCoroutineContext context = EmptyCoroutineContext.INSTANCE;
        Intrinsics.checkNotNullParameter(data, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        C0320q block = new C0320q(data, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        C0314k c0314k = new C0314k();
        c0314k.f3904l = new g();
        E0 e02 = new E0((o0) context.get(n0.f2230a));
        d dVar = Q.f2189a;
        c0314k.f3958m = new C0307d(c0314k, block, 5000L, G.a(q.f12477a.getImmediate().plus(context).plus(e02)), new A(1, c0314k));
        if (data instanceof InterfaceC0367A) {
            if (C0744b.g0().h0()) {
                c0314k.g(((C0369C) ((InterfaceC0367A) data)).a());
            } else {
                c0314k.h(((C0369C) ((InterfaceC0367A) data)).a());
            }
        }
        return c0314k;
    }

    public final void requestData() {
        J.y(I.t(this), null, new C04801(null), 3);
    }

    public final void setCustomPreference(@NotNull Messages messages, boolean isSave) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        AlphaMeLogger.debugLog("PersonalMain", "setCustomPreference " + messages);
        if (messages instanceof AddressMessages) {
            setAddressInfo((AddressMessages) messages, isSave);
            return;
        }
        if (messages instanceof WifiMessages) {
            setWifiInfo((WifiMessages) messages, isSave);
        } else if (messages instanceof TimeMessages) {
            setTimeInfo((TimeMessages) messages, isSave);
        } else if (messages instanceof BluetoothMessages) {
            setBluetoothInfo((BluetoothMessages) messages, isSave);
        }
    }

    public final void updateAutoInfo(@NotNull Messages task) {
        Intrinsics.checkNotNullParameter(task, "task");
        setCustomPreference(task, true);
    }
}
