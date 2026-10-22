package com.stepos.ailauncher.foundation.appstore;

import La.K;
import Y8.t;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.appcenter.appcentersdk.AppCenterSdk;
import h8.C4148a;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0006*\u0002HK\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002NOB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\nJ'\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010 J\u001f\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010#J\u0017\u0010%\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u001eJ\u0017\u0010&\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010 J#\u0010)\u001a\u0004\u0018\u00010(2\b\u0010'\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010.R\u0014\u00100\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010.R\u0014\u00101\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010,R\u0014\u00102\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010,R\u0014\u00103\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010,R\u0014\u00104\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u0010,R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R&\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r09088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R&\u0010<\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001309088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010;R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020=088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010;R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010ART\u0010E\u001aB\u0012\f\u0012\n D*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n D*\u0004\u0018\u00010\b0\b D* \u0012\f\u0012\n D*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n D*\u0004\u0018\u00010\b0\b\u0018\u00010C0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FRT\u0010G\u001aB\u0012\f\u0012\n D*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n D*\u0004\u0018\u00010\b0\b D* \u0012\f\u0012\n D*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n D*\u0004\u0018\u00010\b0\b\u0018\u00010C0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010FR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006P"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/j;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", j.EXTRA_UNINSTALL_PKG, "", "v", "(Landroid/content/Context;Ljava/lang/String;)Z", "u", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appstore/j$a;", "callback", "LY8/t;", "n", "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appstore/j$a;)V", "F", "Lcom/stepos/ailauncher/foundation/appstore/j$b;", "o", "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appstore/j$b;)V", "G", "K", "", "updateAppId", "H", "(Landroid/content/Context;Ljava/lang/String;J)Z", "appContext", "t", "(Landroid/content/Context;)V", "C", "(Ljava/lang/String;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", "(Landroid/content/Context;Ljava/lang/String;)V", "q", "p", "y", "data", "", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "TAG", "Ljava/lang/String;", "CODE_DOWNLOADING", "I", "CODE_INSTALL_SUCCESS", "LISTENER_VERSION", "PKG_APPSTORE", "MARKET_SOURCE", "ACTION_UNINSTALL_STATUS", "EXTRA_UNINSTALL_PKG", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "callbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "uninstallCallbacks", "Lcom/stepos/appcenter/appcentersdk/AppCenterSdk$Listener;", "sdkListeners", "Ljava/util/concurrent/atomic/AtomicBoolean;", "packageReceiverRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "uninstallStatusReceiverRegistered", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "installingPkgs", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "uninstallingPkgs", "com/stepos/ailauncher/foundation/appstore/j$d", "uninstallStatusReceiver", "Lcom/stepos/ailauncher/foundation/appstore/j$d;", "com/stepos/ailauncher/foundation/appstore/j$c", "packageReceiver", "Lcom/stepos/ailauncher/foundation/appstore/j$c;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class j {
    private static final String ACTION_UNINSTALL_STATUS = "com.stepos.ailauncher.action.APP_UNINSTALL_STATUS";
    private static final int CODE_DOWNLOADING = 11;
    private static final int CODE_INSTALL_SUCCESS = 21;
    private static final String EXTRA_UNINSTALL_PKG = "pkg";
    private static final int LISTENER_VERSION = 0;
    private static final String MARKET_SOURCE = "amoo";
    private static final String PKG_APPSTORE = "com.stepos.appstore";
    private static final String TAG = "AppInstallManager";
    public static final j INSTANCE = new j();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<a>> callbacks = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<b>> uninstallCallbacks = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, AppCenterSdk.Listener> sdkListeners = new ConcurrentHashMap<>();
    private static final AtomicBoolean packageReceiverRegistered = new AtomicBoolean(false);
    private static final AtomicBoolean uninstallStatusReceiverRegistered = new AtomicBoolean(false);
    private static final ConcurrentHashMap.KeySetView<String, Boolean> installingPkgs = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> uninstallingPkgs = ConcurrentHashMap.newKeySet();
    private static final d uninstallStatusReceiver = new d();
    private static final c packageReceiver = new c();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\n¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/j$a;", "", "", j.EXTRA_UNINSTALL_PKG, "", "progress", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;I)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "c", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(String pkg, int progress);

        void b(String pkg);

        void c(String pkg);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/j$b;", "", "", j.EXTRA_UNINSTALL_PKG, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        void a(String pkg);

        void b(String pkg);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/foundation/appstore/j$c", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Uri data;
            String schemeSpecificPart;
            String action;
            Collection collection;
            if (intent == null || (data = intent.getData()) == null || (schemeSpecificPart = data.getSchemeSpecificPart()) == null || (action = intent.getAction()) == null) {
                return;
            }
            int iHashCode = action.hashCode();
            if (iHashCode == 525384130) {
                if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                    j.INSTANCE.C(schemeSpecificPart);
                }
            } else if (iHashCode == 1544582882 && action.equals("android.intent.action.PACKAGE_ADDED")) {
                if (j.installingPkgs.contains(schemeSpecificPart) || !((collection = (Collection) j.callbacks.get(schemeSpecificPart)) == null || collection.isEmpty())) {
                    j.INSTANCE.y(schemeSpecificPart);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/foundation/appstore/j$d", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            Object objB;
            if (p.d(intent != null ? intent.getAction() : null, j.ACTION_UNINSTALL_STATUS) && (stringExtra = intent.getStringExtra(j.EXTRA_UNINSTALL_PKG)) != null) {
                int intExtra = intent.getIntExtra("android.content.pm.extra.STATUS", 1);
                if (intExtra != -1) {
                    if (intExtra == 0) {
                        j.INSTANCE.C(stringExtra);
                        return;
                    }
                    C4148a.u(j.TAG, "uninstall 失败 pkg=" + stringExtra + " msg=" + intent.getStringExtra("android.content.pm.extra.STATUS_MESSAGE"), false, 4, null);
                    j.INSTANCE.A(stringExtra);
                    return;
                }
                Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.INTENT");
                if (intent2 == null || context == null) {
                    j.INSTANCE.A(stringExtra);
                    return;
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    context.startActivity(intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                    objB = Result.b(t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t(j.TAG, "拉起卸载确认界面失败 pkg=" + stringExtra, thE, false, 8, null);
                    j.INSTANCE.A(stringExtra);
                }
                Result.a(objB);
            }
        }
    }

    public static final void B(String str) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = uninstallCallbacks.get(str);
        if (copyOnWriteArrayList != null) {
            for (b bVar : copyOnWriteArrayList) {
                p.f(bVar);
                bVar.a(str);
            }
        }
    }

    public static final void D(String str) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = uninstallCallbacks.get(str);
        if (copyOnWriteArrayList != null) {
            for (b bVar : copyOnWriteArrayList) {
                p.f(bVar);
                bVar.b(str);
            }
        }
    }

    public static /* synthetic */ boolean I(j jVar, Context context, String str, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 0;
        }
        return jVar.H(context, str, j10);
    }

    public static final void J(String str, long j10, j jVar, Context context, int i10, String str2) {
        if (i10 < 0) {
            C4148a.u(TAG, "商店下载回错误码 pkg=" + str + " appId=" + j10 + " code=" + i10 + " data=" + (str2 != null ? K.R1(str2, 120) : null), false, 4, null);
            p.f(context);
            jVar.w(context, str);
        }
    }

    public static final void L(String str) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = uninstallCallbacks.get(str);
        if (copyOnWriteArrayList != null) {
            for (b bVar : copyOnWriteArrayList) {
                p.f(bVar);
                bVar.a(str);
            }
        }
    }

    public static final void r(final String str, int i10, String str2) {
        if (i10 != 11) {
            if (i10 != 21) {
                return;
            }
            INSTANCE.y(str);
        } else {
            Integer numE = INSTANCE.E(str2, str);
            if (numE != null) {
                final int iIntValue = numE.intValue();
                mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appstore.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.s(str, iIntValue);
                    }
                });
            }
        }
    }

    public static final void s(String str, int i10) {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = callbacks.get(str);
        if (copyOnWriteArrayList != null) {
            for (a aVar : copyOnWriteArrayList) {
                p.f(aVar);
                aVar.a(str, i10);
            }
        }
    }

    public static final void x(String str) {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = callbacks.get(str);
        if (copyOnWriteArrayList != null) {
            for (a aVar : copyOnWriteArrayList) {
                p.f(aVar);
                aVar.c(str);
            }
        }
    }

    public static final void z(String str) {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = callbacks.get(str);
        if (copyOnWriteArrayList != null) {
            for (a aVar : copyOnWriteArrayList) {
                p.f(aVar);
                aVar.b(str);
            }
        }
    }

    public final void A(final String pkg) {
        uninstallingPkgs.remove(pkg);
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appstore.d
            @Override // java.lang.Runnable
            public final void run() {
                j.B(pkg);
            }
        });
    }

    public final void C(final String pkg) {
        if (uninstallingPkgs.remove(pkg)) {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appstore.c
                @Override // java.lang.Runnable
                public final void run() {
                    j.D(pkg);
                }
            });
        }
    }

    public final Integer E(String data, String pkg) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (data == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(data);
        String strOptString = jSONObject.optString("packageName");
        p.f(strOptString);
        if (strOptString.length() > 0 && !p.d(strOptString, pkg)) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(jSONObject.optInt("progress", -1));
        int iIntValue = numValueOf.intValue();
        if (1 > iIntValue || iIntValue >= 101) {
            numValueOf = null;
        }
        objB = Result.b(numValueOf);
        return (Integer) (Result.g(objB) ? null : objB);
    }

    public final void F(String pkg, a callback) {
        p.i(pkg, "pkg");
        p.i(callback, "callback");
        CopyOnWriteArrayList<a> copyOnWriteArrayList = callbacks.get(pkg);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(callback);
        }
    }

    public final void G(String pkg, b callback) {
        p.i(pkg, "pkg");
        p.i(callback, "callback");
        CopyOnWriteArrayList<b> copyOnWriteArrayList = uninstallCallbacks.get(pkg);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(callback);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean H(android.content.Context r13, final java.lang.String r14, long r15) {
        /*
            r12 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.p.i(r13, r0)
            java.lang.String r0 = "pkg"
            kotlin.jvm.internal.p.i(r14, r0)
            android.content.Context r5 = r13.getApplicationContext()
            kotlin.jvm.internal.p.f(r5)
            r12.q(r5, r14)
            r12.p(r5)
            java.util.concurrent.ConcurrentHashMap$KeySetView<java.lang.String, java.lang.Boolean> r13 = com.stepos.ailauncher.foundation.appstore.j.installingPkgs
            r13.add(r14)
            kotlin.Result$a r13 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L5b
            com.stepos.appcenter.appcentersdk.AppCenterSdk r13 = com.stepos.appcenter.appcentersdk.AppCenterSdk.getInstance()     // Catch: java.lang.Throwable -> L5b
            int r6 = r13.getInstallType()     // Catch: java.lang.Throwable -> L5b
            r0 = 2
            r13.setInstallType(r0)     // Catch: java.lang.Throwable -> L5b
            com.stepos.ailauncher.foundation.appstore.e r0 = new com.stepos.ailauncher.foundation.appstore.e     // Catch: java.lang.Throwable -> L55
            r4 = r12
            r1 = r14
            r2 = r15
            r0.<init>()     // Catch: java.lang.Throwable -> L3e
            r7 = 0
            int r7 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r7 <= 0) goto L40
            r7 = 0
            r13.performDownloadClickByAppId(r2, r7, r0)     // Catch: java.lang.Throwable -> L3e
            goto L48
        L3e:
            r0 = move-exception
            goto L57
        L40:
            com.stepos.appcenter.appcentersdk.AppCenterSdk$c r7 = new com.stepos.appcenter.appcentersdk.AppCenterSdk$c     // Catch: java.lang.Throwable -> L3e
            r7.<init>(r14)     // Catch: java.lang.Throwable -> L3e
            r13.performDownloadClick(r7, r0)     // Catch: java.lang.Throwable -> L3e
        L48:
            r13.setInstallType(r6)     // Catch: java.lang.Throwable -> L52
            java.lang.Boolean r13 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L52
            java.lang.Object r13 = kotlin.Result.b(r13)     // Catch: java.lang.Throwable -> L52
            goto L68
        L52:
            r0 = move-exception
        L53:
            r13 = r0
            goto L5e
        L55:
            r0 = move-exception
            r2 = r15
        L57:
            r13.setInstallType(r6)     // Catch: java.lang.Throwable -> L52
            throw r0     // Catch: java.lang.Throwable -> L52
        L5b:
            r0 = move-exception
            r2 = r15
            goto L53
        L5e:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r13 = kotlin.C4849c.a(r13)
            java.lang.Object r13 = kotlin.Result.b(r13)
        L68:
            java.lang.Throwable r8 = kotlin.Result.e(r13)
            if (r8 == 0) goto L91
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "商店下载发起异常 pkg="
            r0.append(r6)
            r0.append(r14)
            java.lang.String r6 = " appId="
            r0.append(r6)
            r0.append(r2)
            java.lang.String r7 = r0.toString()
            r10 = 8
            r11 = 0
            java.lang.String r6 = "AppInstallManager"
            r9 = 0
            h8.C4148a.t(r6, r7, r8, r9, r10, r11)
        L91:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            boolean r2 = kotlin.Result.g(r13)
            if (r2 == 0) goto L9a
            r13 = r0
        L9a:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto La5
            r12.w(r5, r14)
        La5:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.j.H(android.content.Context, java.lang.String, long):boolean");
    }

    public final boolean K(Context context, final String pkg) {
        Object objB;
        p.i(context, "context");
        p.i(pkg, "pkg");
        Context applicationContext = context.getApplicationContext();
        p.f(applicationContext);
        t(applicationContext);
        p(applicationContext);
        PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, pkg.hashCode(), new Intent(ACTION_UNINSTALL_STATUS).setPackage(applicationContext.getPackageName()).putExtra(EXTRA_UNINSTALL_PKG, pkg), 167772160);
        try {
            Result.Companion companion = Result.INSTANCE;
            uninstallingPkgs.add(pkg);
            applicationContext.getPackageManager().getPackageInstaller().uninstall(pkg, broadcast.getIntentSender());
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            uninstallingPkgs.remove(pkg);
            C4148a.t(TAG, "uninstall 发起失败 pkg=" + pkg, thE, false, 8, null);
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appstore.f
                @Override // java.lang.Runnable
                public final void run() {
                    j.L(pkg);
                }
            });
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void n(String pkg, a callback) {
        CopyOnWriteArrayList<a> copyOnWriteArrayListPutIfAbsent;
        p.i(pkg, "pkg");
        p.i(callback, "callback");
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = callbacks;
        CopyOnWriteArrayList<a> copyOnWriteArrayList = concurrentHashMap.get(pkg);
        if (copyOnWriteArrayList == null && (copyOnWriteArrayListPutIfAbsent = concurrentHashMap.putIfAbsent(pkg, (copyOnWriteArrayList = new CopyOnWriteArrayList<>()))) != null) {
            copyOnWriteArrayList = copyOnWriteArrayListPutIfAbsent;
        }
        copyOnWriteArrayList.addIfAbsent(callback);
    }

    public final void o(String pkg, b callback) {
        CopyOnWriteArrayList<b> copyOnWriteArrayListPutIfAbsent;
        p.i(pkg, "pkg");
        p.i(callback, "callback");
        ConcurrentHashMap<String, CopyOnWriteArrayList<b>> concurrentHashMap = uninstallCallbacks;
        CopyOnWriteArrayList<b> copyOnWriteArrayList = concurrentHashMap.get(pkg);
        if (copyOnWriteArrayList == null && (copyOnWriteArrayListPutIfAbsent = concurrentHashMap.putIfAbsent(pkg, (copyOnWriteArrayList = new CopyOnWriteArrayList<>()))) != null) {
            copyOnWriteArrayList = copyOnWriteArrayListPutIfAbsent;
        }
        copyOnWriteArrayList.addIfAbsent(callback);
    }

    public final void p(Context appContext) {
        Object objB;
        if (packageReceiverRegistered.compareAndSet(false, true)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(androidx.core.content.a.j(appContext, packageReceiver, intentFilter, 4));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                packageReceiverRegistered.set(false);
                C4148a.t(TAG, "注册 PACKAGE_ADDED/REMOVED 监听失败", thE, false, 8, null);
            }
        }
    }

    public final void q(Context context, final String pkg) {
        Object objB;
        ConcurrentHashMap<String, AppCenterSdk.Listener> concurrentHashMap = sdkListeners;
        if (concurrentHashMap.get(pkg) == null) {
            AppCenterSdk.Listener listener = new AppCenterSdk.Listener() { // from class: com.stepos.ailauncher.foundation.appstore.h
                @Override // com.stepos.appcenter.appcentersdk.AppCenterSdk.Listener
                public final void onCallback(int i10, String str) {
                    j.r(pkg, i10, str);
                }
            };
            try {
                Result.Companion companion = Result.INSTANCE;
                AppCenterSdk.getInstance().registerListener(pkg, 0, listener);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "registerListener 失败 pkg=" + pkg, thE, false, 8, null);
                sdkListeners.remove(pkg, listener);
            }
            concurrentHashMap.putIfAbsent(pkg, listener);
        }
    }

    public final void t(Context appContext) {
        Object objB;
        if (uninstallStatusReceiverRegistered.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(androidx.core.content.a.j(appContext, uninstallStatusReceiver, new IntentFilter(ACTION_UNINSTALL_STATUS), 4));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                uninstallStatusReceiverRegistered.set(false);
                C4148a.t(TAG, "注册卸载结果监听失败", thE, false, 8, null);
            }
        }
    }

    public final String u(Context context, String pkg) {
        p.i(context, "context");
        p.i(pkg, "pkg");
        try {
            return context.getPackageManager().getPackageInfo(pkg, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final boolean v(Context context, String pkg) throws PackageManager.NameNotFoundException {
        p.i(context, "context");
        p.i(pkg, "pkg");
        try {
            context.getPackageManager().getApplicationInfo(pkg, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void w(Context context, final String pkg) {
        Object objB;
        installingPkgs.remove(pkg);
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + pkg + "&package_name=" + pkg + "&source=amoo"));
            intent.setPackage("com.stepos.appstore");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "兜底跳商店详情页失败 pkg=" + pkg, thE, false, 8, null);
        }
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appstore.g
            @Override // java.lang.Runnable
            public final void run() {
                j.x(pkg);
            }
        });
    }

    public final void y(final String pkg) {
        installingPkgs.remove(pkg);
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appstore.b
            @Override // java.lang.Runnable
            public final void run() {
                j.z(pkg);
            }
        });
    }
}
