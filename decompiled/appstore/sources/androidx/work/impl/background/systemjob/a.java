package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.i;
import androidx.work.impl.model.o;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5492b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentName f5493a;

    /* JADX INFO: renamed from: androidx.work.impl.background.systemjob.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0059a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5494a = null;

        static {
            int[] r10 = new int[NetworkType.values().length];
            f5494a = r10;
            r10[NetworkType.NOT_REQUIRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f5494a[NetworkType.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f5494a[NetworkType.UNMETERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f5494a[NetworkType.NOT_ROAMING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f5494a[NetworkType.METERED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        f5492b = i.i("SystemJobInfoConverter");
    }

    public a(Context r10) {
        this.f5493a = new ComponentName(r10.getApplicationContext(), SystemJobService.class);
    }

    public static JobInfo.TriggerContentUri b(androidx.work.a.b r10) {
        boolean r11 = r10.b();
        return new JobInfo.TriggerContentUri(r10.a(), r11 ? 1 : 0);
    }

    public static int c(NetworkType r10) {
        int r11 = C0059a.f5494a[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 0;
    L5:
        if (r11 != 2) goto L7;
        return 1;
    L7:
        if (r11 != 3) goto L9;
        return 2;
    L9:
        if (r11 != 4) goto L11;
        return 3;
    L11:
        if (r11 == 5) goto L14;
        i.e().a(f5492b, "API version too low. Cannot convert network type value " + r10);
        return 1;
    L14:
        return 4;
    }

    public static void d(JobInfo.Builder r10, NetworkType r11) {
        if (r11 != NetworkType.TEMPORARILY_UNMETERED) goto L5;
        r10.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        return;
    L5:
        r10.setRequiredNetworkType(c(r11));
    }

    public JobInfo a(o r10, int r11) {
        androidx.work.a r12 = r10.f5679j;
        PersistableBundle r13 = new PersistableBundle();
        r13.putString("EXTRA_WORK_SPEC_ID", r10.f5670a);
        r13.putInt("EXTRA_WORK_SPEC_GENERATION", r10.d());
        r13.putBoolean("EXTRA_IS_PERIODIC", r10.h());
        JobInfo.Builder r14 = new JobInfo.Builder(r11, this.f5493a).setRequiresCharging(r12.g()).setRequiresDeviceIdle(r12.h()).setExtras(r13);
        d(r14, r12.d());
        boolean r15 = false;
        if (r12.h() == false) goto L5;
    L9:
        long r16 = Math.max(r10.c() - System.currentTimeMillis(), 0);
        if (r16 <= 0) goto L13;
        r14.setMinimumLatency(r16);
    L16:
        if (r12.e() == false) goto L22;
        Iterator r17 = r12.c().iterator();
    L19:
        if (r17.hasNext() == false) goto L21;
        r14.addTriggerContentUri(b((androidx.work.a.b) r17.next()));
        goto L19
    L21:
        r14.setTriggerContentUpdateDelay(r12.b());
        r14.setTriggerContentMaxDelay(r12.a());
    L22:
        r14.setPersisted(false);
        int r18 = Build.VERSION.SDK_INT;
        r14.setRequiresBatteryNotLow(r12.f());
        r14.setRequiresStorageNotLow(r12.i());
        if (r10.f5680k <= 0) goto L25;
        boolean r19 = true;
    L27:
        if (r16 <= 0) goto L30;
        r15 = true;
    L30:
        if (r18 < 31) goto L37;
        if (r10.f5686q == false) goto L37;
        if (r19 == true) goto L37;
        if (r15 == true) goto L37;
        r14.setExpedited(true);
    L37:
        return r14.build();
    L25:
        r19 = false;
        goto L27
    L13:
        if (r10.f5686q == true) goto L16;
        r14.setImportantWhileForeground(true);
        goto L16
    L5:
        if (r10.f5681l != BackoffPolicy.LINEAR) goto L7;
        int r110 = 0;
    L8:
        r14.setBackoffCriteria(r10.f5682m, r110);
        goto L9
    L7:
        r110 = 1;
        goto L8
    }
}
