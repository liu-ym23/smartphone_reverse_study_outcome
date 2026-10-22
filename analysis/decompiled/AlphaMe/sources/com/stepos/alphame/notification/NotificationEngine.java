package com.stepos.alphame.notification;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.utils.LocalConsts;

/* loaded from: classes.dex */
public final class NotificationEngine extends EngineBase {

    @SuppressLint({"StaticFieldLeak"})
    private static NotificationEngine sInstance;
    private final Context mContext;
    private BroadcastReceiver mForwardReceiver;
    private final NotificationListenerImpl mNotificationListener = new NotificationListenerImpl();

    public static class NotiPredict extends EngineFunc {
        public NotiPredict(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_NOTI_PREDICT;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{"content"};
            this.isPublic = true;
            this.returnType = (byte) 6;
            this.annotation = new String[]{"通知栏消息分类", "@author lxh", "@return 根据内容返回分析结果"};
        }
    }

    private NotificationEngine(Context context) {
        this.mContext = context.getApplicationContext();
        registerAsSystemService();
    }

    private synchronized void ensureForwardReceiver() {
        if (this.mForwardReceiver != null) {
            return;
        }
        this.mForwardReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.notification.NotificationEngine.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent == null || !PerfBinderHelper.ACTION_NOTIFICATION_FORWARD.equals(intent.getAction())) {
                    return;
                }
                String stringExtra = intent.getStringExtra(PerfBinderHelper.EXTRA_NOTI_EVENT);
                String stringExtra2 = intent.getStringExtra(PerfBinderHelper.EXTRA_NOTI_PACKAGE);
                if (stringExtra2 == null) {
                    return;
                }
                String stringExtra3 = intent.getStringExtra(PerfBinderHelper.EXTRA_NOTI_ORIGINAL_PACKAGE);
                int intExtra = intent.getIntExtra(PerfBinderHelper.EXTRA_NOTI_ID, 0);
                String stringExtra4 = intent.getStringExtra(PerfBinderHelper.EXTRA_NOTI_GROUP);
                if (PerfBinderHelper.NOTI_EVENT_POSTED.equals(stringExtra)) {
                    NotificationEngine.this.mNotificationListener.onForwardedNotificationPosted(stringExtra2, stringExtra3, stringExtra4, intExtra, intent.getIntExtra(PerfBinderHelper.EXTRA_NOTI_FLAGS, 0), intent.getStringExtra(PerfBinderHelper.EXTRA_NOTI_TITLE), intent.getBooleanExtra(PerfBinderHelper.EXTRA_NOTI_HAS_CONTENT, false));
                } else if (PerfBinderHelper.NOTI_EVENT_REMOVED.equals(stringExtra)) {
                    NotificationEngine.this.mNotificationListener.onForwardedNotificationRemoved(stringExtra2, stringExtra3, stringExtra4, intExtra);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(PerfBinderHelper.ACTION_NOTIFICATION_FORWARD);
        try {
            this.mContext.registerReceiver(this.mForwardReceiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null, 2);
        } catch (Throwable unused) {
            this.mContext.registerReceiver(this.mForwardReceiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null);
        }
    }

    public static NotificationEngine getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new NotificationEngine(context);
        }
        return sInstance;
    }

    @NotProguard
    public String notiPredict(String str) {
        return NotiPredictManager.getInstance().notiPredict(str);
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        EngineBase.addFunc(new NotiPredict(this));
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        super.onStop();
    }

    public void receiveNotification(String str) {
    }

    public void registerAsSystemService() {
        ensureForwardReceiver();
        PerfBinderHelper.enableNotificationMonitor();
    }
}
