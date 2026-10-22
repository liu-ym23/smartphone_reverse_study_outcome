package com.stepos.alphame.dailyusage.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.data.utils.DailyUsageMessageHelperKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/alphame/dailyusage/utils/SceneMonitor;", "", "()V", "receiver", "Landroid/content/BroadcastReceiver;", "ensureReceiver", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "onInit", "Companion", "dailyusage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SceneMonitor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<SceneMonitor> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<SceneMonitor>() { // from class: com.stepos.alphame.dailyusage.utils.SceneMonitor$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SceneMonitor invoke() {
            return new SceneMonitor();
        }
    });

    @NotNull
    public static final String TAG = "SceneMonitor";

    @Nullable
    private volatile BroadcastReceiver receiver;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/alphame/dailyusage/utils/SceneMonitor$Companion;", "", "()V", "INSTANCE", "Lcom/stepos/alphame/dailyusage/utils/SceneMonitor;", "getINSTANCE", "()Lcom/stepos/alphame/dailyusage/utils/SceneMonitor;", "INSTANCE$delegate", "Lkotlin/Lazy;", "TAG", "", "dailyusage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SceneMonitor getINSTANCE() {
            return (SceneMonitor) SceneMonitor.INSTANCE$delegate.getValue();
        }
    }

    private final void ensureReceiver(Context context) {
        if (this.receiver != null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        this.receiver = new BroadcastReceiver() { // from class: com.stepos.alphame.dailyusage.utils.SceneMonitor.ensureReceiver.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context ctx, @Nullable Intent intent) {
                String nameForUid;
                if (intent == null || !Intrinsics.areEqual(intent.getAction(), "com.stepos.alphame.ACTION_SCENE_WORKING_STATE_FORWARD")) {
                    return;
                }
                int intExtra = intent.getIntExtra("UID", -1);
                int intExtra2 = intent.getIntExtra("EXTRA_OLD_TYPE", -1);
                String stringExtra = intent.getStringExtra("EXTRA_OLD_TYPE_STR");
                int intExtra3 = intent.getIntExtra("EXTRA_NEW_TYPE", -1);
                String stringExtra2 = intent.getStringExtra("EXTRA_NEW_TYPE_STR");
                try {
                    nameForUid = applicationContext.getPackageManager().getNameForUid(intExtra);
                } catch (Exception unused) {
                    nameForUid = null;
                }
                Log.d(SceneMonitor.TAG, "workingStateChange uid: " + intExtra + " callingPackage: " + nameForUid + " oldType: " + intExtra2 + ", oldTypeStr " + stringExtra + " newType: " + intExtra3 + " newTypeStr " + stringExtra2);
                if (nameForUid != null) {
                    DailyUsageMessageHelperKt.sendDailyUsageAudioMessage(nameForUid, intExtra3 & 2, System.currentTimeMillis());
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("com.stepos.alphame.ACTION_SCENE_WORKING_STATE_FORWARD");
        try {
            applicationContext.registerReceiver(this.receiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null, 2);
        } catch (Throwable unused) {
            applicationContext.registerReceiver(this.receiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null);
        }
    }

    public final void onInit(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ensureReceiver(context);
            Log.d(TAG, "enableSceneMonitor=" + AlphaMeEventIpc.enableSceneMonitor());
        } catch (Exception e4) {
            AbstractC0351g.B("exception ", e4, TAG);
        }
    }
}
