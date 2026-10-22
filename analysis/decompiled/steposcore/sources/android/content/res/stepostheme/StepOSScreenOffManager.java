package android.content.res.stepostheme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentExt;
import android.content.IntentFilter;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class StepOSScreenOffManager {
    public static final String IS_NEED_SEND_CC_SCREEN_OFF_BROADCAST = "is_need_send_cc_screen_off_broadcast";
    public static final String LAST_TIME_SEND_CC_SCREEN_OFF_BROADCAST = "last_time_send_cc_screen_off_broadcast";
    public static final String SEND_CC_SCREEN_OFF_BROADCAST_MIN_TIME_INTERVAL = "send_cc_screen_off_broadcast_min_time_interval";
    public static final String STEPOS_CUSTOMIZE_SCREEN_OFF_INTENT = "stepos.intent.action.CUSTOMIZE_SCREEN_OFF";
    private static final String TAG = "StepOSScreenOffManager";
    private Context mContext;
    private Intent mCCScreenOffIntent = new Intent(STEPOS_CUSTOMIZE_SCREEN_OFF_INTENT);
    private ExecutorService mExecutorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) { // from class: android.content.res.stepostheme.StepOSScreenOffManager.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            return new Thread(r, "stepos-screenoff-pool");
        }
    });
    private Runnable mSendCCScreenOffBroadRunnable = new Runnable() { // from class: android.content.res.stepostheme.StepOSScreenOffManager.2
        @Override // java.lang.Runnable
        public void run() {
            StepOSScreenOffManager.this.sendCCScreenOffBroadcastIfNeed();
        }
    };
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: android.content.res.stepostheme.StepOSScreenOffManager.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                StepOSScreenOffManager.this.mExecutorService.execute(StepOSScreenOffManager.this.mSendCCScreenOffBroadRunnable);
            }
        }
    };

    public StepOSScreenOffManager(Context context) {
        this.mContext = context;
    }

    public void registerScreenOffBroadcast() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.mReceiver, filter);
    }

    private void unRegisterScreenOffBroadcast() {
        if (this.mReceiver != null && this.mContext != null) {
            try {
                this.mContext.unregisterReceiver(this.mReceiver);
            } catch (Exception e) {
                Log.w(TAG, "Failed to unregister receiver: " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCCScreenOffBroadcastIfNeed() {
        if (isNeedSendCCScreenOffBroadcast()) {
            this.mCCScreenOffIntent.setFlags(IntentExt.STEPOS_FLAG_IMMEDIATE_BROADCAST);
            this.mCCScreenOffIntent.setFlags(32);
            this.mContext.sendBroadcastAsUser(this.mCCScreenOffIntent, UserHandle.ALL);
            Settings.System.putLong(this.mContext.getContentResolver(), LAST_TIME_SEND_CC_SCREEN_OFF_BROADCAST, System.currentTimeMillis());
            Log.i(TAG, "send broadcast");
        }
    }

    private boolean isNeedSendCCScreenOffBroadcast() {
        long minTimeInterval = Settings.System.getLong(this.mContext.getContentResolver(), SEND_CC_SCREEN_OFF_BROADCAST_MIN_TIME_INTERVAL, 0L);
        long lastTime = Settings.System.getLong(this.mContext.getContentResolver(), LAST_TIME_SEND_CC_SCREEN_OFF_BROADCAST, 0L);
        long timeInterval = System.currentTimeMillis() - lastTime;
        return (timeInterval >= minTimeInterval || timeInterval < 0) && Settings.System.getInt(this.mContext.getContentResolver(), IS_NEED_SEND_CC_SCREEN_OFF_BROADCAST, 1) == 1;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        unRegisterScreenOffBroadcast();
    }
}
