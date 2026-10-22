package k6;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.service.notification.StatusBarNotification;
import com.stepos.aiengine.R;
import com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor;
import h6.r;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9946a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<ActiveDownloadConditionMonitor.ConditionKind, String> f9947b = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: k6.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0100a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9948a;

        static {
            int[] iArr = new int[ActiveDownloadConditionMonitor.ConditionKind.values().length];
            try {
                iArr[ActiveDownloadConditionMonitor.ConditionKind.WIFI_TO_CELLULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActiveDownloadConditionMonitor.ConditionKind.LOW_BATTERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActiveDownloadConditionMonitor.ConditionKind.LOW_STORAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ActiveDownloadConditionMonitor.ConditionKind.NO_NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f9948a = iArr;
        }
    }

    public static boolean a(NotificationManager notificationManager, int i10) {
        Object objA;
        try {
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            g.e(activeNotifications, "getActiveNotifications(...)");
            int length = activeNotifications.length;
            boolean z = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (activeNotifications[i11].getId() == i10) {
                    z = true;
                    break;
                }
                i11++;
            }
            objA = Boolean.valueOf(z);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public static void b(Context context, NotificationManager notificationManager, String str, ActiveDownloadConditionMonitor.ConditionKind conditionKind, int i10) {
        String string;
        Intent intentA = r.a(context, str, 4);
        intentA.addFlags(335544320);
        PendingIntent activity = PendingIntent.getActivity(context, i10, intentA, 201326592);
        androidx.core.app.g gVar = new androidx.core.app.g(context, "aiengine_condition_break");
        gVar.f1507o.icon = R.drawable.mm_ic_model;
        int i11 = C0100a.f9948a[conditionKind.ordinal()];
        if (i11 == 1) {
            string = context.getString(R.string.mm_cond_wifi_to_cellular);
            g.e(string, "getString(...)");
        } else if (i11 == 2) {
            string = context.getString(R.string.mm_cond_low_battery);
            g.e(string, "getString(...)");
        } else if (i11 == 3) {
            string = context.getString(R.string.mm_cond_low_storage);
            g.e(string, "getString(...)");
        } else {
            if (i11 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            string = context.getString(R.string.mm_cond_no_network);
            g.e(string, "getString(...)");
        }
        gVar.f1498e = androidx.core.app.g.c(string);
        gVar.f1499f = androidx.core.app.g.c(context.getString(R.string.mm_cond_tap_to_continue));
        gVar.f1500g = activity;
        gVar.d(16, true);
        gVar.d(8, true);
        notificationManager.notify(i10, gVar.b());
    }
}
