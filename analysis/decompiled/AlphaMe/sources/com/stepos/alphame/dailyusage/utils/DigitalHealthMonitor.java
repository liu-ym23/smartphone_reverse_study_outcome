package com.stepos.alphame.dailyusage.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.common.utils.BaseApplication;
import com.stepos.alphame.data.DataContractKt;
import com.stepos.alphame.data.utils.DailyUsageMessageHelperKt;
import com.stepos.alphame.data.utils.DigitalHealthHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0010H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/stepos/alphame/dailyusage/utils/DigitalHealthMonitor;", "", "()V", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "applicationContext$delegate", "Lkotlin/Lazy;", "broadcastReceiver", "com/stepos/alphame/dailyusage/utils/DigitalHealthMonitor$broadcastReceiver$1", "Lcom/stepos/alphame/dailyusage/utils/DigitalHealthMonitor$broadcastReceiver$1;", "onInit", "", "registerBroadcastReceiver", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/BroadcastReceiver;", "Companion", "dailyusage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DigitalHealthMonitor {

    @NotNull
    public static final String ACTION_ACTIVE_MINOR_CHANGED = "active_minor_changed";

    @NotNull
    public static final String ACTION_CHILD_MODE_TURN_OFF = "minors_mode_enabled_turn_off";

    @NotNull
    public static final String ACTION_CHILD_MODE_TURN_ON = "minors_mode_enabled_turn_on";

    @NotNull
    public static final String ACTION_DELETE_MINORS = "delete_minors";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<DigitalHealthMonitor> INSTANCE$delegate = LazyKt.lazy(new Function0<DigitalHealthMonitor>() { // from class: com.stepos.alphame.dailyusage.utils.DigitalHealthMonitor$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final DigitalHealthMonitor invoke() {
            return new DigitalHealthMonitor();
        }
    });

    @NotNull
    public static final String KEY_ACTIVE_MINOR_ID = "active_minor_id";

    @NotNull
    public static final String KEY_CURRENT_MODE = "minors_mode_enabled";

    @NotNull
    public static final String KEY_DELETED_MINORS_ID = "deleted_minors_id";

    @NotNull
    public static final String KEY_LAST_ACTIVE_MINOR_ID = "last_active_minor_id";

    @NotNull
    public static final String KEY_LAST_MODE = "key_last_mode";

    @NotNull
    public static final String KEY_MINORS_MODE_AGE_RANGE = "minors_mode_age_range";

    @NotNull
    public static final String KEY_MINOR_MODE = "minors_mode_enabled";

    @NotNull
    public static final String KEY_SUPPORT_MINOR_MODE = "minors_mode";
    public static final int MINORS_MODE_DISABLED = 0;
    public static final int MINORS_MODE_ENABLED = 1;

    @NotNull
    public static final String TAG = "DigitalHealthMonitor";

    /* renamed from: applicationContext$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy applicationContext = LazyKt.lazy(new Function0<Context>() { // from class: com.stepos.alphame.dailyusage.utils.DigitalHealthMonitor$applicationContext$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Context invoke() {
            return BaseApplication.INSTANCE.getAppContext();
        }
    });

    @NotNull
    private final DigitalHealthMonitor$broadcastReceiver$1 broadcastReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.dailyusage.utils.DigitalHealthMonitor$broadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (intent == null) {
                return;
            }
            Log.d(DigitalHealthMonitor.TAG, "onReceiver , action " + intent.getAction() + " this " + this);
            String action = intent.getAction();
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -234987406) {
                    if (action.equals(DigitalHealthMonitor.ACTION_DELETE_MINORS) && context != null) {
                        try {
                            DigitalHealthHelper digitalHealthHelper = DigitalHealthHelper.INSTANCE;
                            int currentMode = digitalHealthHelper.getCurrentMode(context);
                            Log.d(DigitalHealthMonitor.TAG, "in setting, currentMode " + currentMode + " currentUserId " + digitalHealthHelper.getCurrentUserId(context));
                            long[] longArrayExtra = intent.getLongArrayExtra(DigitalHealthMonitor.KEY_DELETED_MINORS_ID);
                            Intrinsics.checkNotNull(longArrayExtra, "null cannot be cast to non-null type kotlin.LongArray");
                            for (long j4 : longArrayExtra) {
                                Log.d(DigitalHealthMonitor.TAG, "delete user , id " + j4);
                            }
                            if (DataContractKt.isUserModeValid(currentMode)) {
                                DailyUsageMessageHelperKt.sendDailyUsageUserDeletedMessage(currentMode, longArrayExtra, System.currentTimeMillis());
                                return;
                            }
                            return;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                if (iHashCode == 233798321 && action.equals(DigitalHealthMonitor.ACTION_ACTIVE_MINOR_CHANGED) && context != null) {
                    int intExtra = intent.getIntExtra("minors_mode_enabled", 0);
                    long longExtra = intent.getLongExtra("active_minor_id", -1L);
                    long longExtra2 = intent.getLongExtra(DigitalHealthMonitor.KEY_LAST_ACTIVE_MINOR_ID, -1L);
                    Log.d(DigitalHealthMonitor.TAG, "minors user changed, currentMode " + intExtra + " currentUserId " + longExtra + " oldUserId " + longExtra2);
                    DigitalHealthHelper digitalHealthHelper2 = DigitalHealthHelper.INSTANCE;
                    Log.d(DigitalHealthMonitor.TAG, "in setting, currentMode " + digitalHealthHelper2.getCurrentMode(context) + " currentUserId " + digitalHealthHelper2.getCurrentUserId(context));
                    if (DataContractKt.isUserModeValid(intExtra)) {
                        if (intExtra == 1 && DataContractKt.isUserIdInvalid(longExtra)) {
                            Log.e(DigitalHealthMonitor.TAG, longExtra + " is invalid userId in minors mode");
                            return;
                        }
                        if (intExtra != 0 || longExtra == -1) {
                            DailyUsageMessageHelperKt.sendDailyUsageUserChangeMessage(intExtra, longExtra, longExtra2, System.currentTimeMillis());
                            return;
                        }
                        Log.e(DigitalHealthMonitor.TAG, longExtra + " is invalid userId in normal mode");
                    }
                }
            }
        }
    };

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/stepos/alphame/dailyusage/utils/DigitalHealthMonitor$Companion;", "", "()V", "ACTION_ACTIVE_MINOR_CHANGED", "", "ACTION_CHILD_MODE_TURN_OFF", "ACTION_CHILD_MODE_TURN_ON", "ACTION_DELETE_MINORS", "INSTANCE", "Lcom/stepos/alphame/dailyusage/utils/DigitalHealthMonitor;", "getINSTANCE", "()Lcom/stepos/alphame/dailyusage/utils/DigitalHealthMonitor;", "INSTANCE$delegate", "Lkotlin/Lazy;", "KEY_ACTIVE_MINOR_ID", "KEY_CURRENT_MODE", "KEY_DELETED_MINORS_ID", "KEY_LAST_ACTIVE_MINOR_ID", "KEY_LAST_MODE", "KEY_MINORS_MODE_AGE_RANGE", "KEY_MINOR_MODE", "KEY_SUPPORT_MINOR_MODE", "MINORS_MODE_DISABLED", "", "MINORS_MODE_ENABLED", "TAG", "dailyusage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DigitalHealthMonitor getINSTANCE() {
            return (DigitalHealthMonitor) DigitalHealthMonitor.INSTANCE$delegate.getValue();
        }
    }

    private final Context getApplicationContext() {
        return (Context) this.applicationContext.getValue();
    }

    private final void registerBroadcastReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_CHILD_MODE_TURN_ON);
        intentFilter.addAction(ACTION_CHILD_MODE_TURN_OFF);
        intentFilter.addAction(ACTION_ACTIVE_MINOR_CHANGED);
        intentFilter.addAction(ACTION_DELETE_MINORS);
        context.registerReceiver(broadcastReceiver, intentFilter, 2);
    }

    public final void onInit() {
        registerBroadcastReceiver(getApplicationContext(), this.broadcastReceiver);
    }
}
