package com.stepos.alphame.userbehavior;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.LongKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\n\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0007R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/alphame/userbehavior/UserBehaviorEngine;", "Lcom/stepos/alphame/engine/EngineBase;", "()V", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "mPowerReceiver", "com/stepos/alphame/userbehavior/UserBehaviorEngine$mPowerReceiver$1", "Lcom/stepos/alphame/userbehavior/UserBehaviorEngine$mPowerReceiver$1;", "getDigitalHealthClearDataTime", "", "onStart", "", "onStop", "setDigitalHealthClearDataTime", "Companion", "GetDigitalHealthClearDataTime", "SetDigitalHealthClearDataTime", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UserBehaviorEngine extends EngineBase {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<UserBehaviorEngine> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<UserBehaviorEngine>() { // from class: com.stepos.alphame.userbehavior.UserBehaviorEngine$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final UserBehaviorEngine invoke() {
            return new UserBehaviorEngine();
        }
    });

    @NotNull
    public static final String KEY_DIGITAL_HEALTH_CLEAR_DATA_TIME = "KEY_DIGITAL_HEALTH_CLEAR_DATA_TIME";

    @NotNull
    public static final String TAG = "UserBehaviorEngine";

    /* renamed from: mHandler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mHandler = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Handler>() { // from class: com.stepos.alphame.userbehavior.UserBehaviorEngine$mHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Handler invoke() {
            return new Handler(ApplicationImpl.getAlphaMeLooper());
        }
    });

    @NotNull
    private final UserBehaviorEngine$mPowerReceiver$1 mPowerReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.userbehavior.UserBehaviorEngine$mPowerReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            String action;
            if (intent == null || (action = intent.getAction()) == null) {
                return;
            }
            if (Intrinsics.areEqual("android.intent.action.ACTION_SHUTDOWN", action) || Intrinsics.areEqual("android.intent.action.REBOOT", action)) {
                UserBehaviorDataSource.getInstance().onShutdown(System.currentTimeMillis());
            }
        }
    };

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/alphame/userbehavior/UserBehaviorEngine$Companion;", "", "()V", "INSTANCE", "Lcom/stepos/alphame/userbehavior/UserBehaviorEngine;", "getINSTANCE", "()Lcom/stepos/alphame/userbehavior/UserBehaviorEngine;", "INSTANCE$delegate", "Lkotlin/Lazy;", "KEY_DIGITAL_HEALTH_CLEAR_DATA_TIME", "", "TAG", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserBehaviorEngine getINSTANCE() {
            return (UserBehaviorEngine) UserBehaviorEngine.INSTANCE$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/userbehavior/UserBehaviorEngine$GetDigitalHealthClearDataTime;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetDigitalHealthClearDataTime extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetDigitalHealthClearDataTime(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = "getDigitalHealthClearDataTime";
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 5;
            this.annotation = new String[]{"获取数字健康上次清除数据的时间", "@return 时间", "@author 梁英杰"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/userbehavior/UserBehaviorEngine$SetDigitalHealthClearDataTime;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SetDigitalHealthClearDataTime extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetDigitalHealthClearDataTime(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = "setDigitalHealthClearDataTime";
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"设置数字健康清除数据的时间", "输入参数：时间", "@author 梁英杰"};
        }
    }

    @NotProguard
    public final long getDigitalHealthClearDataTime() {
        Long digitalHealthClearDataTime = UserBehaviorDataSource.getDigitalHealthClearDataTime();
        Intrinsics.checkNotNull(digitalHealthClearDataTime);
        AlphaMeLogger.debugLog(TAG, "getDigitalHealthClearDataTime " + LongKt.formatDateYear(digitalHealthClearDataTime.longValue()));
        return digitalHealthClearDataTime.longValue();
    }

    @NotNull
    public final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        EngineBase.addFunc(new GetDigitalHealthClearDataTime(this));
        EngineBase.addFunc(new SetDigitalHealthClearDataTime(this));
        IntentFilter intentFilter = new IntentFilter("android.intent.action.ACTION_SHUTDOWN");
        intentFilter.addAction("android.intent.action.REBOOT");
        intentFilter.setPriority(1000);
        ApplicationImpl.getApplication().registerReceiver(this.mPowerReceiver, intentFilter);
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
    }

    @NotProguard
    public final void setDigitalHealthClearDataTime() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.i(TAG, "setDigitalHealthClearDataTime " + LongKt.formatDateYear(jCurrentTimeMillis));
        UserBehaviorDataSource.setDigitalHealthClearDataTime(jCurrentTimeMillis);
    }
}
