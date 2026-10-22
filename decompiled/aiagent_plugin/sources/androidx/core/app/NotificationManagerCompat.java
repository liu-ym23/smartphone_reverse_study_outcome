package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationManagerCompat {
    private static final String TAG = "NotifManCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1054a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f1055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Set<String> f1056c;
    private static final Object f = null;
    private static SideChannelManager g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f1057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final NotificationManager f1058e;

    private static class SideChannelManager implements ServiceConnection, Handler.Callback {
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private Set<String> mCachedEnabledPackages;
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map<ComponentName, a> mRecordMap;

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ComponentName f1059a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            boolean f1060b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            INotificationSideChannel f1061c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            ArrayDeque<e> f1062d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f1063e;

            a(ComponentName r3) {
                this.f1060b = false;
                this.f1062d = new ArrayDeque();
                this.f1063e = 0;
                this.f1059a = r3;
            }
        }

        public static /* synthetic */ boolean access$000(String r0, int r1) {
            return Log.isLoggable(r0, r1);
        }

        public static /* synthetic */ int access$001(String r0, String r1) {
            return Log.d(r0, r1);
        }

        public static /* synthetic */ int access$002(String r0, String r1) {
            return Log.w(r0, r1);
        }

        public static /* synthetic */ int access$003(String r0, String r1, Throwable r2) {
            return Log.w(r0, r1, r2);
        }

        SideChannelManager(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            this.mRecordMap = new HashMap();
            this.mCachedEnabledPackages = new HashSet();
            this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
            HandlerThread r5 = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = r5;
            r5.start();
            this.mHandler = new Handler(r5.getLooper(), this);
        }

        public void queueTask(e r3) {
            e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
            this.mHandler.obtainMessage(0, r4).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r5) {
            int r0 = r5.what;
            if (r0 == 0) goto L17;
            if (r0 != 1) goto L6;
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5.obj, d.class, "com.obric.aiagent.plugin");
            handleServiceConnected(r6.f1068a, r6.f1069b);
            return true;
        L6:
            if (r0 != 2) goto L8;
            handleServiceDisconnected((ComponentName) ZeusTransformUtils.preCheckCast(r5.obj, ComponentName.class, "com.obric.aiagent.plugin"));
            return true;
        L8:
            if (r0 == 3) goto L11;
            return false;
        L11:
            handleRetryListenerQueue((ComponentName) ZeusTransformUtils.preCheckCast(r5.obj, ComponentName.class, "com.obric.aiagent.plugin"));
            return true;
        L17:
            handleQueueTask((e) ZeusTransformUtils.preCheckCast(r5.obj, e.class, "com.obric.aiagent.plugin"));
            return true;
        }

        private void handleQueueTask(e r5) {
            e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.aiagent.plugin");
            updateListenerMap();
            Iterator<a> r0 = this.mRecordMap.values().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            a r2 = (a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin");
            r2.f1062d.add(r6);
            processListenerQueue(r2);
            goto L4
        }

        private void handleServiceConnected(ComponentName r3, IBinder r4) {
            IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
            a r6 = (a) ZeusTransformUtils.preCheckCast(this.mRecordMap.get(r3), a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L6;
            r6.f1061c = INotificationSideChannel.Stub.asInterface(r5);
            r6.f1063e = 0;
            processListenerQueue(r6);
            return;
        }

        private void handleServiceDisconnected(ComponentName r3) {
            a r4 = (a) ZeusTransformUtils.preCheckCast(this.mRecordMap.get(r3), a.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L6;
            ensureServiceUnbound(r4);
            return;
        }

        private void handleRetryListenerQueue(ComponentName r3) {
            a r4 = (a) ZeusTransformUtils.preCheckCast(this.mRecordMap.get(r3), a.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L6;
            processListenerQueue(r4);
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r4, IBinder r5) {
            IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
            if (INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(NotificationManagerCompat.TAG, "Connected to service " + r4);
        L5:
            this.mHandler.obtainMessage(1, new d(r4, r6)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r4) {
            if (INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(NotificationManagerCompat.TAG, "Disconnected from service " + r4);
        L5:
            this.mHandler.obtainMessage(2, r4).sendToTarget();
        }

        private void updateListenerMap() {
            Set<String> r0 = NotificationManagerCompat.b(this.mContext);
            if (r0.equals(this.mCachedEnabledPackages) == false) goto L5;
            return;
        L5:
            this.mCachedEnabledPackages = r0;
            List<ResolveInfo> r1 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet r2 = new HashSet();
            Iterator<ResolveInfo> r3 = r1.iterator();
        L7:
            if (r3.hasNext() == false) goto L15;
            ResolveInfo r4 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r3.next(), ResolveInfo.class, "com.obric.aiagent.plugin");
            if (r0.contains(r4.serviceInfo.packageName) == false) goto L7;
            ComponentName r5 = new ComponentName(r4.serviceInfo.packageName, r4.serviceInfo.name);
            if (r4.serviceInfo.permission != null) goto L13;
            r2.add(r5);
            goto L7
        L13:
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(NotificationManagerCompat.TAG, "Permission present on component " + r5 + ", not adding listener record.");
            goto L7
        L15:
            Iterator r6 = r2.iterator();
        L17:
            if (r6.hasNext() == false) goto L24;
            ComponentName r7 = (ComponentName) ZeusTransformUtils.preCheckCast(r6.next(), ComponentName.class, "com.obric.aiagent.plugin");
            if (this.mRecordMap.containsKey(r7) == true) goto L17;
            if (INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L23;
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(NotificationManagerCompat.TAG, "Adding listener record for " + r7);
        L23:
            this.mRecordMap.put(r7, new a(r7));
            goto L17
        L24:
            Iterator<Map.Entry<ComponentName, a>> r8 = this.mRecordMap.entrySet().iterator();
        L26:
            if (r8.hasNext() == false) goto L33;
            Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            if (r2.contains(r9.getKey()) == true) goto L26;
            if (INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L32;
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(NotificationManagerCompat.TAG, "Removing listener record for " + r9.getKey());
        L32:
            ensureServiceUnbound((a) ZeusTransformUtils.preCheckCast(r9.getValue(), a.class, "com.obric.aiagent.plugin"));
            r8.remove();
            goto L26
        }

        private boolean ensureServiceBound(a r5) {
            if (r5.f1060b == false) goto L6;
            return true;
        L6:
            r5.f1060b = ZeusTransformUtils.bindService(this.mContext, new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(r5.f1059a), this, 33, "com.obric.aiagent.plugin");
            if (r5.f1060b == false) goto L9;
            r5.f1063e = 0;
        L11:
            return r5.f1060b;
        L9:
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(NotificationManagerCompat.TAG, "Unable to bind to listener " + r5.f1059a);
            ZeusTransformUtils.unbindService(this.mContext, this, "com.obric.aiagent.plugin");
            goto L11
        }

        private void ensureServiceUnbound(a r3) {
            if (r3.f1060b == false) goto L5;
            ZeusTransformUtils.unbindService(this.mContext, this, "com.obric.aiagent.plugin");
            r3.f1060b = false;
        L5:
            r3.f1061c = null;
        }

        private void scheduleListenerRetry(a r6) {
            if (this.mHandler.hasMessages(3, r6.f1059a) == false) goto L5;
            return;
        L5:
            r6.f1063e++;
            if (r6.f1063e <= 6) goto L9;
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(NotificationManagerCompat.TAG, "Giving up on delivering " + r6.f1062d.size() + " tasks to " + r6.f1059a + " after " + r6.f1063e + " retries");
            r6.f1062d.clear();
            return;
        L9:
            int r0 = (1 << (r6.f1063e - 1)) * 1000;
            if (INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L12;
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(NotificationManagerCompat.TAG, "Scheduling retry for " + r0 + " ms");
        L12:
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, r6.f1059a), r0);
        }

        private void processListenerQueue(a r6) {
            if (INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L6;
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(NotificationManagerCompat.TAG, "Processing component " + r6.f1059a + ", " + r6.f1062d.size() + " queued tasks");
        L6:
            if (r6.f1062d.isEmpty() == false) goto L9;
            return;
        L9:
            if (ensureServiceBound(r6) == true) goto L11;
        L30:
            scheduleListenerRetry(r6);
            return;
        L11:
            if (r6.f1061c == null) goto L30;
        L13:
            e r2 = (e) ZeusTransformUtils.preCheckCast(r6.f1062d.peek(), e.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L27;
            if (INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L19;
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(NotificationManagerCompat.TAG, "Sending task " + r2);     // Catch: RemoteException -> L21 DeadObjectException -> L23
        L19:
            r2.a(r6.f1061c);     // Catch: RemoteException -> L21 DeadObjectException -> L23
            r6.f1062d.remove();     // Catch: RemoteException -> L21 DeadObjectException -> L23
            goto L13
        L21:
            e = move-exception;
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(NotificationManagerCompat.TAG, "RemoteException communicating with " + r6.f1059a, e);
        L24:
            if (INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L27;
            INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(NotificationManagerCompat.TAG, "Remote service has died: " + r6.f1059a);
        L27:
            if (r6.f1062d.isEmpty() == true) goto L37;
            scheduleListenerRetry(r6);
            return;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static boolean INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(String r1, int r2) {
            if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
            return Log.isLoggable(r1, r2);
        L7:
            if (r2 == 6) goto L9;
        L11:
            return false;
        L9:
            if (Log.isLoggable(r1, r2) == false) goto L11;
            return true;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_androidx_core_app_NotificationManagerCompat$SideChannelManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }
    }

    static class a {
        static boolean a(NotificationManager r0) {
            return r0.areNotificationsEnabled();
        }

        static int b(NotificationManager r0) {
            return r0.getImportance();
        }
    }

    static class b {
        static void a(NotificationManager r0, NotificationChannel r1) {
            r0.createNotificationChannel(r1);
        }

        static NotificationChannel a(NotificationManager r0, String r1) {
            return r0.getNotificationChannel(r1);
        }

        static void a(NotificationManager r2, List<NotificationChannel> r3) {
            r2.createNotificationChannels((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        static List<NotificationChannel> a(NotificationManager r0) {
            return r0.getNotificationChannels();
        }

        static void a(NotificationManager r0, NotificationChannelGroup r1) {
            r0.createNotificationChannelGroup(r1);
        }

        static void b(NotificationManager r2, List<NotificationChannelGroup> r3) {
            r2.createNotificationChannelGroups((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        static List<NotificationChannelGroup> b(NotificationManager r0) {
            return r0.getNotificationChannelGroups();
        }

        static void b(NotificationManager r0, String r1) {
            r0.deleteNotificationChannel(r1);
        }

        static void c(NotificationManager r0, String r1) {
            r0.deleteNotificationChannelGroup(r1);
        }

        static String a(NotificationChannel r0) {
            return r0.getId();
        }

        static String a(NotificationChannelGroup r0) {
            return r0.getId();
        }
    }

    private static class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f1064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f1065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f1066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f1067d;

        c(String r1) {
            this.f1064a = r1;
            this.f1065b = 0;
            this.f1066c = null;
            this.f1067d = true;
        }

        c(String r1, int r2, String r3) {
            this.f1064a = r1;
            this.f1065b = r2;
            this.f1066c = r3;
            this.f1067d = false;
        }

        @Override // androidx.core.app.NotificationManagerCompat.e
        public void a(INotificationSideChannel r3) {
            INotificationSideChannel r4 = (INotificationSideChannel) ZeusTransformUtils.wrapperContextForParams(r3, INotificationSideChannel.class, "com.obric.aiagent.plugin");
            if (this.f1067d == false) goto L5;
            r4.cancelAll(this.f1064a);
            return;
        L5:
            r4.cancel(this.f1064a, this.f1065b, this.f1066c);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("CancelTask[");
            r0.append("packageName:").append(this.f1064a);
            r0.append(", id:").append(this.f1065b);
            r0.append(", tag:").append(this.f1066c);
            r0.append(", all:").append(this.f1067d);
            r0.append("]");
            return r0.toString();
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ComponentName f1068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final IBinder f1069b;

        d(ComponentName r3, IBinder r4) {
            IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
            this.f1068a = r3;
            this.f1069b = r5;
        }
    }

    private interface e {
        void a(INotificationSideChannel r1);
    }

    static {
        f1054a = new Object();
        f1056c = new HashSet();
        f = new Object();
    }

    public static NotificationManagerCompat a(Context r2) {
        return new NotificationManagerCompat((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    private NotificationManagerCompat(Context r3) {
        Context r4 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f1057d = r4;
        this.f1058e = (NotificationManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(IFlowAppIntentIDL.PERMISSION_NOTIFICATION), NotificationManager.class, "com.obric.aiagent.plugin");
    }

    public void a(String r3, int r4) {
        this.f1058e.cancel(r3, r4);
        if (Build.VERSION.SDK_INT > 19) goto L6;
        a(new c(this.f1057d.getPackageName(), r4, r3));
        return;
    }

    public void a() {
        this.f1058e.cancelAll();
        if (Build.VERSION.SDK_INT > 19) goto L6;
        a(new c(this.f1057d.getPackageName()));
        return;
    }

    public boolean b() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return a.a(this.f1058e);
    L7:
        if (Build.VERSION.SDK_INT < 19) goto L17;
        AppOpsManager r0 = (AppOpsManager) ZeusTransformUtils.preCheckCast(this.f1057d.getSystemService("appops"), AppOpsManager.class, "com.obric.aiagent.plugin");
        ApplicationInfo r1 = this.f1057d.getApplicationInfo();
        String r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1057d.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName();
        int r2 = r1.uid;
        Class r4 = ZeusTransformUtils.forName(AppOpsManager.class.getName(), "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (((Integer) ZeusTransformUtils.preCheckCast(r4.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(r0, new Object[]{Integer.valueOf(((Integer) ZeusTransformUtils.preCheckCast(r4.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class), Integer.class, "com.obric.aiagent.plugin")).intValue()), Integer.valueOf(r2), r11}), Integer.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L13;
        return true;
    L13:
        return false;
    L19:
        return true;
    L17:
        return true;
    }

    public void a(NotificationChannel r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        b.a(this.f1058e, r3);
        return;
    }

    public void a(j r1) {
        a(r1.a());
    }

    public static Set<String> b(Context r6) {
        String r7 = Settings.Secure.getString(((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), "enabled_notification_listeners");
        Object r0 = f1054a;
        monitor-enter(r0);
        if (r7 != null) goto L20;
    L14:
        Set<String> r8 = f1056c;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r8;
    L17:
        th = move-exception;
        throw th;
    L20:
        if (r7.equals(f1055b) == true) goto L14;
        String[] r1 = r7.split(":", -1);     // Catch: Throwable -> L17
        HashSet r2 = new HashSet(r1.length);     // Catch: Throwable -> L17
        int r3 = r1.length;     // Catch: Throwable -> L17
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L13;
        ComponentName r5 = ComponentName.unflattenFromString(r1[r4]);     // Catch: Throwable -> L17
        if (r5 == null) goto L12;
        r2.add(r5.getPackageName());     // Catch: Throwable -> L17
    L12:
        r4 = r4 + 1;     // Catch: Throwable -> L17
        goto L8
    L13:
        f1056c = r2;     // Catch: Throwable -> L17
        f1055b = r7;     // Catch: Throwable -> L17
        goto L14
    }

    private void a(e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.aiagent.plugin");
        Object r0 = f;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (g != null) goto L7;
        g = new SideChannelManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1057d.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
    L7:
        g.queueTask(r6);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }
}
