package stepai.aios.accessibility;

import C5.e;
import N9.j;
import android.accessibilityservice.AccessibilityService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.IntentFilter;
import android.view.accessibility.AccessibilityEvent;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.statsrpk.service.c;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import s9.C1923c;
import s9.k;
import u9.d;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lstepai/aios/accessibility/DefaultAccessibilityService;", "Landroid/accessibilityservice/AccessibilityService;", AppAgent.CONSTRUCT, "()V", "stepai/aios/accessibility/b", "ta/d", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultAccessibilityService extends AccessibilityService {
    public static WeakReference d;

    /* renamed from: a, reason: collision with root package name */
    public final C1923c f6015a;
    public e b;
    public Thread.UncaughtExceptionHandler c;

    public DefaultAccessibilityService() {
        d dVar = AbstractC1691I.f5315a;
        this.f6015a = AbstractC1683A.b(k.f6003a);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public final void onAccessibilityEvent(AccessibilityEvent event) {
        String string;
        String strConcat;
        kotlin.jvm.internal.k.f(event, "event");
        try {
            CharSequence packageName = event.getPackageName();
            if (packageName != null) {
                packageName.toString();
            }
            CharSequence className = event.getClassName();
            if (className == null || (string = className.toString()) == null) {
                string = "";
            }
            int eventType = event.getEventType();
            if (eventType == 2048) {
                return;
            }
            if (eventType == 1) {
                strConcat = "View was clicked. event-class=".concat(string);
            } else if (eventType == 8) {
                String strConcat2 = "View was focused. event-class=".concat(string);
                event.getSource();
                strConcat = strConcat2;
            } else if (eventType == 16) {
                strConcat = "View text changed. event-class=".concat(string);
            } else if (eventType == 32) {
                strConcat = "Window state changed. event-class=".concat(string);
            } else if (eventType != 64) {
                strConcat = null;
            } else {
                strConcat = "System popup event: " + event;
            }
            if (strConcat != null) {
                j.I("AccessibilityEvent received: ".concat(strConcat), "DefaultAccessibilityService");
            }
        } catch (Exception e) {
            c.n("Process accessibility event failed: ", e.getMessage(), "DefaultAccessibilityService");
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        j.H("AccessibilityService onCreate", "DefaultAccessibilityService");
        this.b = new e(2);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        registerReceiver(this.b, intentFilter, 2);
        this.c = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new b(this));
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("babelfish_accessibility_service_channel", "Babelfish 无障碍服务", 2));
        Notification notificationBuild = new Notification.Builder(this, "babelfish_accessibility_service_channel").setContentTitle("Babelfish正在运行").setContentText("点击查看详情").build();
        kotlin.jvm.internal.k.e(notificationBuild, "build(...)");
        startForeground(1001, notificationBuild);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        j.H("AccessibilityService onDestroy", "DefaultAccessibilityService");
        WeakReference weakReference = d;
        if (weakReference != null) {
            weakReference.clear();
        }
        d = null;
        e eVar = this.b;
        if (eVar != null) {
            unregisterReceiver(eVar);
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public final void onInterrupt() {
        j.H("AccessibilityService onInterrupt", "DefaultAccessibilityService");
    }

    @Override // android.accessibilityservice.AccessibilityService
    public final void onServiceConnected() {
        super.onServiceConnected();
        j.H("AccessibilityService onServiceConnected", "DefaultAccessibilityService");
        d = new WeakReference(this);
    }
}
