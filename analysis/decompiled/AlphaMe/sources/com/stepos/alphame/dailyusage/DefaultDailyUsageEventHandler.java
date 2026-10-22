package com.stepos.alphame.dailyusage;

import Z2.AbstractC0123e0;
import Z2.C0125f0;
import Z2.F;
import Z2.G;
import Z2.I;
import Z2.M;
import Z2.Q;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.platform.comapi.UIMsg;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.common.utils.AppUtilsKt;
import com.stepos.alphame.common.utils.BaseApplication;
import com.stepos.alphame.common.utils.EventUtils;
import com.stepos.alphame.common.utils.LogKt;
import com.stepos.alphame.common.utils.TimeUtils;
import com.stepos.alphame.common.utils.TimeUtilsKt;
import com.stepos.alphame.dailyusage.sync.DailyUsageSync;
import com.stepos.alphame.data.DataContractKt;
import com.stepos.alphame.data.local.database.CommonRoomDatabase;
import com.stepos.alphame.data.model.dailyusage.DailyUsageKt;
import com.stepos.alphame.data.model.dailyusage.NotificationUsage;
import com.stepos.alphame.data.model.dailyusage.ScreenUsage;
import com.stepos.alphame.data.model.dailyusage.TimeUsage;
import com.stepos.alphame.data.model.dailyusage.TimeUsageType;
import com.stepos.alphame.data.repo.DailyUsageRepository;
import com.stepos.alphame.data.repo.DefaultDailyUsageRepository;
import com.stepos.alphame.data.utils.DailyUsageMessageHelperKt;
import com.stepos.alphame.data.utils.DigitalHealthHelper;
import com.stepos.alphame.model.event.DailyUsageAudioMessage;
import com.stepos.alphame.model.event.DailyUsageDataClearMessage;
import com.stepos.alphame.model.event.DailyUsageInitMessage;
import com.stepos.alphame.model.event.DailyUsageMessage;
import com.stepos.alphame.model.event.DailyUsageMzForegroundWindowModeMessage;
import com.stepos.alphame.model.event.DailyUsageMzWindowMessage;
import com.stepos.alphame.model.event.DailyUsageMzWindowModeMessage;
import com.stepos.alphame.model.event.DailyUsageNotificationMessage;
import com.stepos.alphame.model.event.DailyUsageScreenMessage;
import com.stepos.alphame.model.event.DailyUsageTimeChangedMessage;
import com.stepos.alphame.model.event.DailyUsageUserChangedMessage;
import com.stepos.alphame.model.event.DailyUsageUserDeletedMessage;
import com.stepos.alphame.model.event.DailyUsageWindowMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.J;

@Metadata(d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001]\u0018\u0000 q2\u00020\u0001:\u0001qB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010X\u001a\u00020W¢\u0006\u0004\bo\u0010pJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\"\u0010 J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001dH\u0002¢\u0006\u0004\b#\u0010 J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001dH\u0002¢\u0006\u0004\b$\u0010 J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bC\u0010DJ?\u0010J\u001a\u00020\u00042\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u000bH\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010O\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u000bH\u0002¢\u0006\u0004\bO\u0010\u000eJ\u0017\u0010Q\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u000bH\u0002¢\u0006\u0004\bQ\u0010\u000eJ\u0017\u0010T\u001a\u00020\u00042\u0006\u0010S\u001a\u00020RH\u0002¢\u0006\u0004\bT\u0010UR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010`\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010aR\u0016\u0010c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010aR\u0014\u0010e\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u001b\u0010l\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0016\u0010m\u001a\u00020E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010n¨\u0006r"}, d2 = {"Lcom/stepos/alphame/dailyusage/DefaultDailyUsageEventHandler;", "", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "", "onInit", "(Landroid/content/Context;)V", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "dailyUsageMessage", "onDailyUsageMessage", "(Lcom/stepos/alphame/model/event/DailyUsageMessage;)V", "", "triggerTime", "handleCrossDayEvent", "(J)V", "", "state", "sendScreenBroadcast", "(Ljava/lang/String;J)V", "registerReceiver", "()V", "Lcom/stepos/alphame/model/event/DailyUsageInitMessage;", "initEvent", "handleInitMessage", "(Lcom/stepos/alphame/model/event/DailyUsageInitMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/stepos/alphame/model/event/DailyUsageNotificationMessage;", "notificationEvent", "handleNotificationMessage", "(Lcom/stepos/alphame/model/event/DailyUsageNotificationMessage;)V", "Lcom/stepos/alphame/model/event/DailyUsageMzWindowMessage;", "mzWindowEvent", "handleMzWindowMessage", "(Lcom/stepos/alphame/model/event/DailyUsageMzWindowMessage;)V", "dailyUsageEvent", "handleForegroundWindowResumeEvent", "handleFloatingWindowResumeEvent", "handleFullScreenWindowResumeEvent", "Lcom/stepos/alphame/model/event/DailyUsageMzForegroundWindowModeMessage;", "mzForegroundWindowModeMessage", "handleMzForegroundWindowModeMessage", "(Lcom/stepos/alphame/model/event/DailyUsageMzForegroundWindowModeMessage;)V", "Lcom/stepos/alphame/model/event/DailyUsageMzWindowModeMessage;", "mzWindowModeEvent", "handleMzWindowModeMessage", "(Lcom/stepos/alphame/model/event/DailyUsageMzWindowModeMessage;)V", "Lcom/stepos/alphame/model/event/DailyUsageWindowMessage;", "windowEvent", "handleFullScreenWindowMessage", "(Lcom/stepos/alphame/model/event/DailyUsageWindowMessage;)V", "Lcom/stepos/alphame/model/event/DailyUsageAudioMessage;", "audioEvent", "handleAudioMessage", "(Lcom/stepos/alphame/model/event/DailyUsageAudioMessage;)V", "Lcom/stepos/alphame/model/event/DailyUsageScreenMessage;", "screenEvent", "handleScreenMessage", "(Lcom/stepos/alphame/model/event/DailyUsageScreenMessage;)V", "Lcom/stepos/alphame/model/event/DailyUsageUserDeletedMessage;", "userDeletedMessage", "handleUserDeletedMessage", "(Lcom/stepos/alphame/model/event/DailyUsageUserDeletedMessage;)V", "Lcom/stepos/alphame/model/event/DailyUsageDataClearMessage;", "dataClearMessage", "handleDataClearMessage", "(Lcom/stepos/alphame/model/event/DailyUsageDataClearMessage;)V", "Lcom/stepos/alphame/model/event/DailyUsageUserChangedMessage;", "userChangedMessage", "handleUserChangedMessage", "(Lcom/stepos/alphame/model/event/DailyUsageUserChangedMessage;)V", "", "oldMode", "oldUserId", "mode", "userId", "handleUserInfoChange", "(IJIJJLcom/stepos/alphame/model/event/DailyUsageUserChangedMessage;)V", "projectedWallClock", "()J", "now", "setTrustedClock", "wallNow", "advanceTrustedClock", "Lcom/stepos/alphame/model/event/DailyUsageTimeChangedMessage;", "message", "handleTimeChangedEvent", "(Lcom/stepos/alphame/model/event/DailyUsageTimeChangedMessage;)V", "Landroid/content/Context;", "Lcom/stepos/alphame/data/repo/DailyUsageRepository;", "dailyUsageRepository", "Lcom/stepos/alphame/data/repo/DailyUsageRepository;", "", "mScreenSate", "Z", "com/stepos/alphame/dailyusage/DefaultDailyUsageEventHandler$receiver$1", "receiver", "Lcom/stepos/alphame/dailyusage/DefaultDailyUsageEventHandler$receiver$1;", "lastEventTime", "J", "lastTrustedWallClockMs", "lastTrustedElapsedRealtimeMs", "LZ2/e0;", "singleDispatcher", "LZ2/e0;", "LZ2/F;", "handlerScope$delegate", "Lkotlin/Lazy;", "getHandlerScope", "()LZ2/F;", "handlerScope", "lastState", "I", "<init>", "(Landroid/content/Context;Lcom/stepos/alphame/data/repo/DailyUsageRepository;)V", "Companion", "dailyusage_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDefaultDailyUsageEventHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultDailyUsageEventHandler.kt\ncom/stepos/alphame/dailyusage/DefaultDailyUsageEventHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,693:1\n1#2:694\n*E\n"})
/* loaded from: classes.dex */
public final class DefaultDailyUsageEventHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<DefaultDailyUsageEventHandler> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<DefaultDailyUsageEventHandler>() { // from class: com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final DefaultDailyUsageEventHandler invoke() {
            BaseApplication.Companion companion = BaseApplication.INSTANCE;
            return new DefaultDailyUsageEventHandler(companion.getAppContext(), new DefaultDailyUsageRepository(Q.f2190b, CommonRoomDatabase.Companion.getInstance(companion.getAppContext()).getDailyUsageDao()));
        }
    });

    @NotNull
    public static final String TAG = "DefaultDailyUsageEventHandler";
    private static final long TIME_JUMP_BACKWARD_TOLERANCE_MS = 60000;
    private static final long TIME_JUMP_THRESHOLD_MS = 300000;

    @NotNull
    private final Context context;

    @NotNull
    private final DailyUsageRepository dailyUsageRepository;

    /* renamed from: handlerScope$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy handlerScope;
    private long lastEventTime;
    private int lastState;
    private long lastTrustedElapsedRealtimeMs;
    private long lastTrustedWallClockMs;
    private boolean mScreenSate;

    @NotNull
    private final DefaultDailyUsageEventHandler$receiver$1 receiver;

    @NotNull
    private final AbstractC0123e0 singleDispatcher;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stepos/alphame/dailyusage/DefaultDailyUsageEventHandler$Companion;", "", "()V", "INSTANCE", "Lcom/stepos/alphame/dailyusage/DefaultDailyUsageEventHandler;", "getINSTANCE", "()Lcom/stepos/alphame/dailyusage/DefaultDailyUsageEventHandler;", "INSTANCE$delegate", "Lkotlin/Lazy;", "TAG", "", "TIME_JUMP_BACKWARD_TOLERANCE_MS", "", "TIME_JUMP_THRESHOLD_MS", "dailyusage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DefaultDailyUsageEventHandler getINSTANCE() {
            return (DefaultDailyUsageEventHandler) DefaultDailyUsageEventHandler.INSTANCE$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$handleDataClearMessage$1", f = "DefaultDailyUsageEventHandler.kt", i = {}, l = {UIMsg.MsgDefine.MSG_NETWORK_CHANNEL}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$handleDataClearMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DefaultDailyUsageEventHandler.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DailyUsageRepository dailyUsageRepository = DefaultDailyUsageEventHandler.this.dailyUsageRepository;
                this.label = 1;
                if (dailyUsageRepository.clearDailyUsage(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$handleUserDeletedMessage$1", f = "DefaultDailyUsageEventHandler.kt", i = {}, l = {529}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$handleUserDeletedMessage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04701 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ DailyUsageUserDeletedMessage $userDeletedMessage;
        int I$0;
        int I$1;
        Object L$0;
        int label;
        final /* synthetic */ DefaultDailyUsageEventHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04701(DailyUsageUserDeletedMessage dailyUsageUserDeletedMessage, DefaultDailyUsageEventHandler defaultDailyUsageEventHandler, Continuation<? super C04701> continuation) {
            super(2, continuation);
            this.$userDeletedMessage = dailyUsageUserDeletedMessage;
            this.this$0 = defaultDailyUsageEventHandler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C04701(this.$userDeletedMessage, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04701) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0047 -> B:13:0x004a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                int r1 = r8.I$1
                int r3 = r8.I$0
                java.lang.Object r4 = r8.L$0
                long[] r4 = (long[]) r4
                kotlin.ResultKt.throwOnFailure(r9)
                goto L4a
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1f:
                kotlin.ResultKt.throwOnFailure(r9)
                com.stepos.alphame.model.event.DailyUsageUserDeletedMessage r9 = r8.$userDeletedMessage
                long[] r9 = r9.getUserId()
                int r1 = r9.length
                r3 = 0
                r4 = r9
            L2b:
                if (r3 >= r1) goto L4c
                r5 = r4[r3]
                com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler r9 = r8.this$0
                com.stepos.alphame.data.repo.DailyUsageRepository r9 = com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler.access$getDailyUsageRepository$p(r9)
                com.stepos.alphame.model.event.DailyUsageUserDeletedMessage r7 = r8.$userDeletedMessage
                int r7 = r7.getMode()
                r8.L$0 = r4
                r8.I$0 = r3
                r8.I$1 = r1
                r8.label = r2
                java.lang.Object r9 = r9.deleteDailyUsage(r7, r5, r8)
                if (r9 != r0) goto L4a
                return r0
            L4a:
                int r3 = r3 + r2
                goto L2b
            L4c:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler.C04701.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$onDailyUsageMessage$1", f = "DefaultDailyUsageEventHandler.kt", i = {}, l = {Opcodes.IFNONNULL}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$onDailyUsageMessage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04711 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ DailyUsageMessage $dailyUsageMessage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04711(DailyUsageMessage dailyUsageMessage, Continuation<? super C04711> continuation) {
            super(2, continuation);
            this.$dailyUsageMessage = dailyUsageMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DefaultDailyUsageEventHandler.this.new C04711(this.$dailyUsageMessage, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04711) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            try {
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    DigitalHealthHelper digitalHealthHelper = DigitalHealthHelper.INSTANCE;
                    if (!digitalHealthHelper.isDigitalHealthFeatureEnable() && !digitalHealthHelper.isMinorsModeEnable(DefaultDailyUsageEventHandler.this.context) && !digitalHealthHelper.isDigitalHealthMessage(this.$dailyUsageMessage)) {
                        LogKt.logI(DefaultDailyUsageEventHandler.TAG, "digital health feature disable and minors mode disable, not handle event");
                        return Unit.INSTANCE;
                    }
                    DailyUsageMessage dailyUsageMessage = this.$dailyUsageMessage;
                    if (dailyUsageMessage instanceof DailyUsageTimeChangedMessage) {
                        DefaultDailyUsageEventHandler.this.handleTimeChangedEvent((DailyUsageTimeChangedMessage) dailyUsageMessage);
                        return Unit.INSTANCE;
                    }
                    if (!TimeUtilsKt.isSameDay(dailyUsageMessage.getRequestTime(), DefaultDailyUsageEventHandler.this.lastEventTime)) {
                        DefaultDailyUsageEventHandler.this.handleCrossDayEvent(this.$dailyUsageMessage.getRequestTime());
                    }
                    DailyUsageMessage dailyUsageMessage2 = this.$dailyUsageMessage;
                    if (dailyUsageMessage2 instanceof DailyUsageInitMessage) {
                        this.label = 1;
                        if (DefaultDailyUsageEventHandler.this.handleInitMessage((DailyUsageInitMessage) dailyUsageMessage2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (dailyUsageMessage2 instanceof DailyUsageWindowMessage) {
                        DefaultDailyUsageEventHandler.this.handleFullScreenWindowMessage((DailyUsageWindowMessage) dailyUsageMessage2);
                    } else if (dailyUsageMessage2 instanceof DailyUsageMzWindowMessage) {
                        DefaultDailyUsageEventHandler.this.handleMzWindowMessage((DailyUsageMzWindowMessage) dailyUsageMessage2);
                    } else if (dailyUsageMessage2 instanceof DailyUsageMzWindowModeMessage) {
                        DefaultDailyUsageEventHandler.this.handleMzWindowModeMessage((DailyUsageMzWindowModeMessage) dailyUsageMessage2);
                    } else if (dailyUsageMessage2 instanceof DailyUsageMzForegroundWindowModeMessage) {
                        DefaultDailyUsageEventHandler.this.handleMzForegroundWindowModeMessage((DailyUsageMzForegroundWindowModeMessage) dailyUsageMessage2);
                    } else if (dailyUsageMessage2 instanceof DailyUsageNotificationMessage) {
                        DefaultDailyUsageEventHandler.this.handleNotificationMessage((DailyUsageNotificationMessage) dailyUsageMessage2);
                    } else if (dailyUsageMessage2 instanceof DailyUsageAudioMessage) {
                        DefaultDailyUsageEventHandler.this.handleAudioMessage((DailyUsageAudioMessage) dailyUsageMessage2);
                    } else if (dailyUsageMessage2 instanceof DailyUsageScreenMessage) {
                        DefaultDailyUsageEventHandler.this.handleScreenMessage((DailyUsageScreenMessage) dailyUsageMessage2);
                    } else if (dailyUsageMessage2 instanceof DailyUsageUserChangedMessage) {
                        DefaultDailyUsageEventHandler.this.handleUserChangedMessage((DailyUsageUserChangedMessage) dailyUsageMessage2);
                    } else if (dailyUsageMessage2 instanceof DailyUsageUserDeletedMessage) {
                        DefaultDailyUsageEventHandler.this.handleUserDeletedMessage((DailyUsageUserDeletedMessage) dailyUsageMessage2);
                    } else if (dailyUsageMessage2 instanceof DailyUsageDataClearMessage) {
                        DefaultDailyUsageEventHandler.this.handleDataClearMessage((DailyUsageDataClearMessage) dailyUsageMessage2);
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                DefaultDailyUsageEventHandler.this.lastEventTime = this.$dailyUsageMessage.getRequestTime();
                DefaultDailyUsageEventHandler.this.advanceTrustedClock(this.$dailyUsageMessage.getRequestTime());
            } catch (Exception e4) {
                AbstractC0351g.B("handleEvent error: ", e4, DefaultDailyUsageEventHandler.TAG);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$onInit$1", f = "DefaultDailyUsageEventHandler.kt", i = {}, l = {101, 102}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$onInit$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04721 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04721(Context context, Continuation<? super C04721> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DefaultDailyUsageEventHandler.this.new C04721(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04721) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DailyUsageRepository dailyUsageRepository = DefaultDailyUsageEventHandler.this.dailyUsageRepository;
                this.label = 1;
                if (dailyUsageRepository.restoreDailyUsage(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    if (i4 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    DailyUsageSync.INSTANCE.save(this.$context);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            this.label = 2;
            if (M.a(2000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            DailyUsageSync.INSTANCE.save(this.$context);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$receiver$1] */
    public DefaultDailyUsageEventHandler(@NotNull Context context, @NotNull DailyUsageRepository dailyUsageRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dailyUsageRepository, "dailyUsageRepository");
        this.context = context;
        this.dailyUsageRepository = dailyUsageRepository;
        this.mScreenSate = true;
        this.receiver = new BroadcastReceiver() { // from class: com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$receiver$1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
            java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
            	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
            	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
             */
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context2, @Nullable Intent intent) {
                String action;
                if (intent == null || (action = intent.getAction()) == null) {
                    return;
                }
                DefaultDailyUsageEventHandler defaultDailyUsageEventHandler = this.this$0;
                long jCurrentTimeMillis = System.currentTimeMillis();
                switch (action.hashCode()) {
                    case -2128145023:
                        if (!action.equals("android.intent.action.SCREEN_OFF")) {
                        }
                        defaultDailyUsageEventHandler.mScreenSate = false;
                        DailyUsageMessageHelperKt.sendDailyUsageScreenMessage("screen_off", jCurrentTimeMillis);
                        defaultDailyUsageEventHandler.sendScreenBroadcast("screen_off", jCurrentTimeMillis);
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            defaultDailyUsageEventHandler.mScreenSate = true;
                            DailyUsageMessageHelperKt.sendDailyUsageScreenMessage(EventUtils.SCREEN_ON, jCurrentTimeMillis);
                            defaultDailyUsageEventHandler.sendScreenBroadcast(EventUtils.SCREEN_ON, jCurrentTimeMillis);
                            break;
                        }
                        break;
                    case 502473491:
                        if (!action.equals("android.intent.action.TIMEZONE_CHANGED")) {
                        }
                        DailyUsageMessageHelperKt.sendDailyUsageTimeChangedMessage(action, jCurrentTimeMillis);
                        break;
                    case 505380757:
                        if (!action.equals("android.intent.action.TIME_SET")) {
                        }
                        DailyUsageMessageHelperKt.sendDailyUsageTimeChangedMessage(action, jCurrentTimeMillis);
                        break;
                    case 1947666138:
                        if (!action.equals("android.intent.action.ACTION_SHUTDOWN")) {
                        }
                        defaultDailyUsageEventHandler.mScreenSate = false;
                        DailyUsageMessageHelperKt.sendDailyUsageScreenMessage("screen_off", jCurrentTimeMillis);
                        defaultDailyUsageEventHandler.sendScreenBroadcast("screen_off", jCurrentTimeMillis);
                        break;
                    case 2039811242:
                        if (!action.equals("android.intent.action.REBOOT")) {
                        }
                        defaultDailyUsageEventHandler.mScreenSate = false;
                        DailyUsageMessageHelperKt.sendDailyUsageScreenMessage("screen_off", jCurrentTimeMillis);
                        defaultDailyUsageEventHandler.sendScreenBroadcast("screen_off", jCurrentTimeMillis);
                        break;
                }
            }
        };
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new a(1));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.singleDispatcher = new C0125f0(executorServiceNewSingleThreadExecutor);
        this.handlerScope = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<F>() { // from class: com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler$handlerScope$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final F invoke() {
                return G.a(this.this$0.singleDispatcher.plus(I.b()));
            }
        });
        this.lastState = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void advanceTrustedClock(long wallNow) {
        long jProjectedWallClock = projectedWallClock();
        if ((this.lastTrustedWallClockMs <= 0 || Math.abs(wallNow - jProjectedWallClock) <= 300000) && wallNow >= this.lastTrustedWallClockMs) {
            setTrustedClock(wallNow);
        }
    }

    private final F getHandlerScope() {
        return (F) this.handlerScope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAudioMessage(DailyUsageAudioMessage audioEvent) {
        Unit unit;
        LogKt.logI(TAG, "handleAudioEvent, " + audioEvent);
        Log.d(TAG, "lastState is " + this.lastState + "   currentState is " + audioEvent.getAudioPlayedState());
        if (this.lastState == audioEvent.getAudioPlayedState()) {
            return;
        }
        this.lastState = audioEvent.getAudioPlayedState();
        DailyUsageRepository dailyUsageRepository = this.dailyUsageRepository;
        TimeUsageType timeUsageType = TimeUsageType.AUDIO;
        TimeUsage timeUsage = dailyUsageRepository.getTimeUsage(timeUsageType.getKey());
        if (timeUsage != null) {
            if (timeUsage.getStartTime() == timeUsage.getEndTime() && audioEvent.getAudioPlayedState() == 0) {
                this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, audioEvent.getRequestTime());
                this.dailyUsageRepository.removeTimeUsage(timeUsageType.getKey());
            } else if (audioEvent.getAudioPlayedState() == 2) {
                this.dailyUsageRepository.setTimeUsageWhenRunning(audioEvent, timeUsageType);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null && audioEvent.getAudioPlayedState() == 2) {
            this.dailyUsageRepository.setTimeUsageWhenRunning(audioEvent, timeUsageType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDataClearMessage(DailyUsageDataClearMessage dataClearMessage) {
        Log.i(TAG, "handle data clear message, dataClearMessage " + dataClearMessage + " , current mode " + this.dailyUsageRepository.getCurrentUserMode());
        J.y(getHandlerScope(), null, new AnonymousClass1(null), 3);
    }

    private final void handleFloatingWindowResumeEvent(DailyUsageMzWindowMessage dailyUsageEvent) {
        LogKt.logI(TAG, "handleFloatingWindowResumeEvent");
        DailyUsageRepository dailyUsageRepository = this.dailyUsageRepository;
        TimeUsageType timeUsageType = TimeUsageType.FOREGROUND_WINDOW;
        TimeUsage timeUsage = dailyUsageRepository.getTimeUsage(timeUsageType.getKey());
        DailyUsageRepository dailyUsageRepository2 = this.dailyUsageRepository;
        TimeUsageType timeUsageType2 = TimeUsageType.FLOATING_WINDOW;
        TimeUsage timeUsage2 = dailyUsageRepository2.getTimeUsage(timeUsageType2.getKey());
        if (timeUsage == null || timeUsage2 == null) {
            if (timeUsage != null) {
                if (Intrinsics.areEqual(dailyUsageEvent.getPackageName(), timeUsage.getPackageName())) {
                    this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, dailyUsageEvent.getRequestTime());
                    this.dailyUsageRepository.removeTimeUsage(timeUsageType.getKey());
                }
            } else if (timeUsage2 != null && !Intrinsics.areEqual(dailyUsageEvent.getPackageName(), timeUsage2.getPackageName())) {
                this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage2, dailyUsageEvent.getRequestTime());
            }
        } else if (Intrinsics.areEqual(dailyUsageEvent.getPackageName(), timeUsage.getPackageName()) && !Intrinsics.areEqual(dailyUsageEvent.getPackageName(), timeUsage2.getPackageName())) {
            this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, dailyUsageEvent.getRequestTime());
            this.dailyUsageRepository.removeTimeUsage(timeUsageType.getKey());
            this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage2, dailyUsageEvent.getRequestTime());
        }
        this.dailyUsageRepository.setTimeUsageWhenRunning(dailyUsageEvent, timeUsageType2);
    }

    private final void handleForegroundWindowResumeEvent(DailyUsageMzWindowMessage dailyUsageEvent) {
        LogKt.logI(TAG, "handleForegroundWindowResumeEvent");
        DailyUsageRepository dailyUsageRepository = this.dailyUsageRepository;
        TimeUsageType timeUsageType = TimeUsageType.FOREGROUND_WINDOW;
        TimeUsage timeUsage = dailyUsageRepository.getTimeUsage(timeUsageType.getKey());
        DailyUsageRepository dailyUsageRepository2 = this.dailyUsageRepository;
        TimeUsageType timeUsageType2 = TimeUsageType.FLOATING_WINDOW;
        TimeUsage timeUsage2 = dailyUsageRepository2.getTimeUsage(timeUsageType2.getKey());
        if (timeUsage != null && timeUsage2 != null) {
            if (!Intrinsics.areEqual(dailyUsageEvent.getPackageName(), timeUsage.getPackageName()) && !Intrinsics.areEqual(dailyUsageEvent.getPackageName(), timeUsage2.getPackageName())) {
                this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, dailyUsageEvent.getRequestTime());
                this.dailyUsageRepository.setTimeUsageWhenRunning(dailyUsageEvent, timeUsageType);
                return;
            } else {
                if (Intrinsics.areEqual(dailyUsageEvent.getPackageName(), timeUsage.getPackageName())) {
                    return;
                }
                this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, dailyUsageEvent.getRequestTime());
                this.dailyUsageRepository.setTimeUsageWhenRunning(dailyUsageEvent, timeUsageType);
                this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage2, dailyUsageEvent.getRequestTime());
                this.dailyUsageRepository.removeTimeUsage(timeUsageType2.getKey());
                return;
            }
        }
        if (timeUsage != null) {
            if (Intrinsics.areEqual(dailyUsageEvent.getPackageName(), timeUsage.getPackageName())) {
                return;
            }
            this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, dailyUsageEvent.getRequestTime());
            this.dailyUsageRepository.setTimeUsageWhenRunning(dailyUsageEvent, timeUsageType);
            return;
        }
        if (timeUsage2 == null) {
            this.dailyUsageRepository.setTimeUsageWhenRunning(dailyUsageEvent, timeUsageType);
        } else if (Intrinsics.areEqual(dailyUsageEvent.getPackageName(), timeUsage2.getPackageName())) {
            this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage2, dailyUsageEvent.getRequestTime());
            this.dailyUsageRepository.removeTimeUsage(timeUsageType2.getKey());
            this.dailyUsageRepository.setTimeUsageWhenRunning(dailyUsageEvent, timeUsageType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFullScreenWindowMessage(DailyUsageWindowMessage windowEvent) {
        LogKt.logI(TAG, "handleFullScreenWindowEvent, " + windowEvent);
        if (this.mScreenSate) {
            EventUtils eventUtils = EventUtils.INSTANCE;
            if (eventUtils.isScreenOffEvent(windowEvent.getPackageName()) || eventUtils.isScreenOnEvent(windowEvent.getPackageName())) {
                Log.i(TAG, "not handle screen event");
                return;
            }
            if (TimeUtilsKt.isSameDay(windowEvent.getRequestTime(), this.lastEventTime)) {
                LogKt.logI(TAG, "is same day");
                DailyUsageRepository dailyUsageRepository = this.dailyUsageRepository;
                TimeUsageType timeUsageType = TimeUsageType.FULL_SCREEN_WINDOW;
                TimeUsage timeUsage = dailyUsageRepository.getTimeUsage(timeUsageType.getKey());
                if (timeUsage != null && DailyUsageKt.isRunning(timeUsage)) {
                    this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, windowEvent.getRequestTime());
                }
                if (TextUtils.isEmpty(windowEvent.getPackageName()) || AppUtilsKt.isQuickApp(windowEvent.getPackageName()) || AppUtilsKt.isPayment(windowEvent.getPackageName())) {
                    return;
                }
                this.dailyUsageRepository.setTimeUsageWhenRunning(windowEvent, timeUsageType);
            }
        }
    }

    private final void handleFullScreenWindowResumeEvent(DailyUsageMzWindowMessage dailyUsageEvent) {
        DailyUsageRepository dailyUsageRepository = this.dailyUsageRepository;
        TimeUsageType timeUsageType = TimeUsageType.FOREGROUND_WINDOW;
        TimeUsage timeUsage = dailyUsageRepository.getTimeUsage(timeUsageType.getKey());
        if (timeUsage == null || !Intrinsics.areEqual(dailyUsageEvent.getPackageName(), timeUsage.getPackageName())) {
            return;
        }
        LogKt.logI(TAG, "foreground Window to full screen window");
        this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, dailyUsageEvent.getRequestTime());
        this.dailyUsageRepository.removeTimeUsage(timeUsageType.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleInitMessage(DailyUsageInitMessage dailyUsageInitMessage, Continuation<? super Unit> continuation) {
        LogKt.logI(TAG, "handleInitEvent " + dailyUsageInitMessage);
        Object objRestoreDailyUsage = this.dailyUsageRepository.restoreDailyUsage(continuation);
        return objRestoreDailyUsage == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRestoreDailyUsage : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMzForegroundWindowModeMessage(DailyUsageMzForegroundWindowModeMessage mzForegroundWindowModeMessage) {
        DailyUsageRepository dailyUsageRepository = this.dailyUsageRepository;
        TimeUsageType timeUsageType = TimeUsageType.FOREGROUND_WINDOW;
        TimeUsage timeUsage = dailyUsageRepository.getTimeUsage(timeUsageType.getKey());
        if (timeUsage != null) {
            Log.d(TAG, AwarenessDataItem.PERMISSION_SPLITTER + timeUsage.getPackageName());
            this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, mzForegroundWindowModeMessage.getRequestTime());
            this.dailyUsageRepository.removeTimeUsage(timeUsageType.getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMzWindowMessage(DailyUsageMzWindowMessage mzWindowEvent) {
        int mode = mzWindowEvent.getMode();
        TimeUsageType timeUsageType = TimeUsageType.FULL_SCREEN_WINDOW;
        if (mode != timeUsageType.getType() || Intrinsics.areEqual(mzWindowEvent.getState(), "resume")) {
            LogKt.logI(TAG, "handleMzWindowEvent " + mzWindowEvent);
            if (mzWindowEvent.getMode() == TimeUsageType.FOREGROUND_WINDOW.getType() && Intrinsics.areEqual(mzWindowEvent.getState(), "resume")) {
                handleForegroundWindowResumeEvent(mzWindowEvent);
                return;
            }
            if (mzWindowEvent.getMode() == TimeUsageType.FLOATING_WINDOW.getType() && Intrinsics.areEqual(mzWindowEvent.getState(), "resume")) {
                handleFloatingWindowResumeEvent(mzWindowEvent);
            } else if (mzWindowEvent.getMode() == timeUsageType.getType() && Intrinsics.areEqual(mzWindowEvent.getState(), "resume")) {
                handleFullScreenWindowResumeEvent(mzWindowEvent);
            } else {
                Log.d(TAG, "not handler this event");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMzWindowModeMessage(DailyUsageMzWindowModeMessage mzWindowModeEvent) {
        LogKt.logI(TAG, "handleFloatingWindowPauseEvent " + mzWindowModeEvent);
        DailyUsageRepository dailyUsageRepository = this.dailyUsageRepository;
        TimeUsageType timeUsageType = TimeUsageType.FOREGROUND_WINDOW;
        TimeUsage timeUsage = dailyUsageRepository.getTimeUsage(timeUsageType.getKey());
        DailyUsageRepository dailyUsageRepository2 = this.dailyUsageRepository;
        TimeUsageType timeUsageType2 = TimeUsageType.FLOATING_WINDOW;
        TimeUsage timeUsage2 = dailyUsageRepository2.getTimeUsage(timeUsageType2.getKey());
        if (timeUsage != null && 260 == mzWindowModeEvent.getWindowModeState() && mzWindowModeEvent.getMode() == 268) {
            this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, mzWindowModeEvent.getRequestTime());
            this.dailyUsageRepository.removeTimeUsage(timeUsageType.getKey());
        }
        if (timeUsage2 != null) {
            if ((4 == mzWindowModeEvent.getWindowModeState() || 1024 == mzWindowModeEvent.getWindowModeState()) && mzWindowModeEvent.getMode() == 12) {
                this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage2, mzWindowModeEvent.getRequestTime());
                this.dailyUsageRepository.removeTimeUsage(timeUsageType2.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleNotificationMessage(DailyUsageNotificationMessage notificationEvent) {
        LogKt.logI(TAG, "handleNotificationEvent " + notificationEvent);
        this.dailyUsageRepository.addNotificationUsage(new NotificationUsage(notificationEvent.getPackageName(), notificationEvent.getRequestTime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleScreenMessage(DailyUsageScreenMessage screenEvent) {
        LogKt.logI(TAG, "handleScreenOnEvent, " + screenEvent);
        this.dailyUsageRepository.addScreenUsage(new ScreenUsage(screenEvent.getScreenState(), screenEvent.getRequestTime()));
        if (Intrinsics.areEqual(screenEvent.getScreenState(), "screen_off")) {
            this.dailyUsageRepository.endRunningTimeUsages(screenEvent.getRequestTime(), this.dailyUsageRepository.getCurrentUserMode(), this.dailyUsageRepository.getCurrentUserId(), screenEvent);
            this.dailyUsageRepository.saveDailyUsages();
            DailyUsageRepository dailyUsageRepository = this.dailyUsageRepository;
            TimeUsageType timeUsageType = TimeUsageType.FULL_SCREEN_WINDOW;
            TimeUsage timeUsage = dailyUsageRepository.getTimeUsage(timeUsageType.getKey());
            if (timeUsage != null) {
                this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, screenEvent.getRequestTime());
                this.dailyUsageRepository.removeTimeUsage(timeUsageType.getKey());
            }
            DailyUsageRepository dailyUsageRepository2 = this.dailyUsageRepository;
            TimeUsageType timeUsageType2 = TimeUsageType.FLOATING_WINDOW;
            TimeUsage timeUsage2 = dailyUsageRepository2.getTimeUsage(timeUsageType2.getKey());
            if (timeUsage2 != null) {
                this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage2, screenEvent.getRequestTime());
                this.dailyUsageRepository.removeTimeUsage(timeUsageType2.getKey());
            }
            DailyUsageRepository dailyUsageRepository3 = this.dailyUsageRepository;
            TimeUsageType timeUsageType3 = TimeUsageType.FOREGROUND_WINDOW;
            TimeUsage timeUsage3 = dailyUsageRepository3.getTimeUsage(timeUsageType3.getKey());
            if (timeUsage3 != null) {
                this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage3, screenEvent.getRequestTime());
                this.dailyUsageRepository.removeTimeUsage(timeUsageType3.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleTimeChangedEvent(DailyUsageTimeChangedMessage message) {
        long requestTime = message.getRequestTime();
        long j4 = this.lastTrustedWallClockMs;
        long jProjectedWallClock = projectedWallClock();
        boolean z4 = false;
        boolean z5 = j4 > 0 && requestTime < jProjectedWallClock - 60000;
        if (j4 > 0 && Math.abs(requestTime - jProjectedWallClock) > 300000) {
            z4 = true;
        }
        LogKt.logI(TAG, "handleTimeChangedEvent action=" + message.getAction() + " now=" + requestTime + " prevTrusted=" + j4 + " projected=" + jProjectedWallClock + " backward=" + z5 + " largeJump=" + z4);
        if (j4 <= 0 || !z4) {
            setTrustedClock(requestTime);
            this.lastEventTime = requestTime;
            return;
        }
        if (z5) {
            this.dailyUsageRepository.clampTodayUsagesToWallClock(requestTime);
            this.dailyUsageRepository.restartFutureRunningTimeUsages(requestTime);
            this.dailyUsageRepository.resetRunningTimeUsages(requestTime);
            this.dailyUsageRepository.saveDailyUsages();
        } else if (TimeUtilsKt.isSameDay(jProjectedWallClock, requestTime)) {
            this.dailyUsageRepository.splitRunningTimeUsagesAtJump(jProjectedWallClock, requestTime);
            this.dailyUsageRepository.addScreenUsage(new ScreenUsage("screen_off", jProjectedWallClock));
            this.dailyUsageRepository.addScreenUsage(new ScreenUsage(EventUtils.SCREEN_ON, requestTime));
            this.dailyUsageRepository.saveDailyUsages();
        } else {
            handleCrossDayEvent(requestTime);
        }
        setTrustedClock(requestTime);
        this.lastEventTime = requestTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUserChangedMessage(DailyUsageUserChangedMessage userChangedMessage) {
        LogKt.logI(TAG, "handle user change, userChangedMessage " + userChangedMessage + ", current mode " + this.dailyUsageRepository.getCurrentUserMode());
        int currentMode = userChangedMessage.getCurrentMode();
        handleUserInfoChange(currentMode == 0 ? 1 : 0, userChangedMessage.getOldUserId(), currentMode, userChangedMessage.getCurrentUserId(), userChangedMessage.getRequestTime(), userChangedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUserDeletedMessage(DailyUsageUserDeletedMessage userDeletedMessage) {
        LogKt.logI(TAG, "handle user delete change, userDeletedMessage " + userDeletedMessage + " , current mode " + this.dailyUsageRepository.getCurrentUserMode());
        if (userDeletedMessage.getMode() != this.dailyUsageRepository.getCurrentUserMode()) {
            Log.e(TAG, "user changed, oldUser mode is not current mode");
        } else {
            J.y(getHandlerScope(), null, new C04701(userDeletedMessage, this, null), 3);
        }
    }

    private final void handleUserInfoChange(int oldMode, long oldUserId, int mode, long userId, long triggerTime, DailyUsageUserChangedMessage userChangedMessage) {
        LogKt.logI(TAG, "handle user info change");
        this.dailyUsageRepository.endRunningTimeUsages(triggerTime, oldMode, oldUserId, userChangedMessage);
        this.dailyUsageRepository.saveDailyUsages();
        this.dailyUsageRepository.setUserInfo(mode, userId);
        this.dailyUsageRepository.resetRunningTimeUsages(triggerTime);
    }

    private final long projectedWallClock() {
        if (this.lastTrustedElapsedRealtimeMs <= 0) {
            return this.lastTrustedWallClockMs;
        }
        return this.lastTrustedWallClockMs + RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - this.lastTrustedElapsedRealtimeMs, 0L);
    }

    private final void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.ACTION_SHUTDOWN");
        intentFilter.addAction("android.intent.action.REBOOT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.setPriority(1000);
        BaseApplication.INSTANCE.getAppContext().registerReceiver(this.receiver, intentFilter);
    }

    private final void setTrustedClock(long now) {
        this.lastTrustedWallClockMs = now;
        this.lastTrustedElapsedRealtimeMs = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread singleDispatcher$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable, "dailyUsage");
        thread.setDaemon(true);
        return thread;
    }

    public final void handleCrossDayEvent(long triggerTime) {
        LogKt.logI(TAG, "handleCrossDayEvent --------------------------------");
        long baseTimeMill = TimeUtils.getBaseTimeMill(triggerTime);
        for (TimeUsage timeUsage : this.dailyUsageRepository.getTimeUsageMap().values()) {
            Intrinsics.checkNotNull(timeUsage);
            if (DailyUsageKt.isRunning(timeUsage)) {
                this.dailyUsageRepository.setTimeUsageWhenRunningEnd(timeUsage, baseTimeMill);
                DailyUsageKt.setRunning(timeUsage, baseTimeMill);
            } else {
                LogKt.logI(TAG, "remove time usage in memory when cross day. " + timeUsage);
                this.dailyUsageRepository.removeTimeUsage(DailyUsageKt.getTimeUsageKey(timeUsage.getType()));
            }
        }
        this.dailyUsageRepository.saveDailyUsages();
        this.dailyUsageRepository.clearTodayDailyUsage();
        DailyUsageMessageHelperKt.sendDailyUsageScreenMessage(EventUtils.SCREEN_ON, triggerTime);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public final void onDailyUsageMessage(@NotNull DailyUsageMessage dailyUsageMessage) {
        Intrinsics.checkNotNullParameter(dailyUsageMessage, "dailyUsageMessage");
        J.y(getHandlerScope(), null, new C04711(dailyUsageMessage, null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onInit(@org.jetbrains.annotations.NotNull android.content.Context r20) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.dailyusage.DefaultDailyUsageEventHandler.onInit(android.content.Context):void");
    }

    public final void sendScreenBroadcast(@NotNull String state, long triggerTime) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intent intent = new Intent(DailyUsageContractKt.ACTION_SCREEN_EVENT);
        intent.addFlags(32);
        intent.putExtra("state", state);
        intent.putExtra(DataContractKt.EXTRA_START_TIME, triggerTime);
        intent.setPackage(DataContractKt.PACKAGE_NAME_SCENE_INFO);
        BaseApplication.INSTANCE.getAppContext().sendBroadcast(intent, DailyUsageContractKt.PERMISSION_SCREEN_EVENT);
        LogKt.logI(DefaultDailyUsageRepository.TAG, "send app event broadcast");
    }
}
