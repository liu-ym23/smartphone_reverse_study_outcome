package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.os.BuildCompat;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
class SystemJobInfoConverter {
    static final String EXTRA_IS_PERIODIC = "EXTRA_IS_PERIODIC";
    static final String EXTRA_WORK_SPEC_ID = "EXTRA_WORK_SPEC_ID";
    private static final String TAG = null;
    private final ComponentName mWorkServiceComponent;

    /* JADX INFO: renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType = null;

        static {
            int[] r100 = new int[NetworkType.values().length];
            $SwitchMap$androidx$work$NetworkType = r100;
            r100[NetworkType.NOT_REQUIRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$work$NetworkType[NetworkType.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$work$NetworkType[NetworkType.UNMETERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$work$NetworkType[NetworkType.NOT_ROAMING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$work$NetworkType[NetworkType.METERED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        TAG = Logger.tagWithPrefix("SystemJobInfoConverter");
    }

    public SystemJobInfoConverter(Context r100) {
        this.mWorkServiceComponent = new ComponentName(r100.getApplicationContext(), SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri convertContentUriTrigger(ContentUriTriggers.Trigger r100) {
        boolean r101 = r100.shouldTriggerForDescendants();
        return new JobInfo.TriggerContentUri(r100.getUri(), r101 ? 1 : 0);
    }

    public static int convertNetworkType(NetworkType r100) {
        int r101 = AnonymousClass1.$SwitchMap$androidx$work$NetworkType[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 0;
    L5:
        if (r101 != 2) goto L7;
        return 1;
    L7:
        if (r101 != 3) goto L9;
        return 2;
    L9:
        if (r101 == 4) goto L17;
        if (r101 == 5) goto L14;
    L19:
        Logger.get().debug(TAG, String.format("API version too low. Cannot convert network type value %s", new Object[]{r100}), new Throwable[0]);
        return 1;
    L14:
        if (Build.VERSION.SDK_INT < 26) goto L19;
        return 4;
    L17:
        if (Build.VERSION.SDK_INT < 24) goto L19;
        return 3;
    }

    public static void setRequiredNetwork(JobInfo.Builder r100, NetworkType r101) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
    L7:
        r100.setRequiredNetworkType(convertNetworkType(r101));
        return;
    L5:
        if (r101 != NetworkType.TEMPORARILY_UNMETERED) goto L7;
        r100.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
    }

    public JobInfo convert(WorkSpec r110, int r111) {
        Constraints r100 = r110.constraints;
        PersistableBundle r101 = new PersistableBundle();
        r101.putString(EXTRA_WORK_SPEC_ID, r110.f15686id);
        r101.putBoolean(EXTRA_IS_PERIODIC, r110.isPeriodic());
        JobInfo.Builder r112 = new JobInfo.Builder(r111, this.mWorkServiceComponent).setRequiresCharging(r100.requiresCharging()).setRequiresDeviceIdle(r100.requiresDeviceIdle()).setExtras(r101);
        setRequiredNetwork(r112, r100.getRequiredNetworkType());
        boolean r102 = false;
        if (r100.requiresDeviceIdle() == false) goto L5;
    L9:
        long r103 = Math.max(r110.calculateNextRunTime() - System.currentTimeMillis(), 0);
        int r104 = Build.VERSION.SDK_INT;
        if (r104 > 28) goto L13;
        r112.setMinimumLatency(r103);
    L19:
        if (r104 >= 24) goto L21;
    L27:
        r112.setPersisted(false);
        if (Build.VERSION.SDK_INT < 26) goto L31;
        r112.setRequiresBatteryNotLow(r100.requiresBatteryNotLow());
        r112.setRequiresStorageNotLow(r100.requiresStorageNotLow());
    L31:
        if (r110.runAttemptCount <= 0) goto L33;
        boolean r105 = true;
    L35:
        if (r103 <= 0) goto L38;
        r102 = true;
    L38:
        if (BuildCompat.isAtLeastS() == false) goto L45;
        if (r110.expedited == false) goto L45;
        if (r105 == true) goto L45;
        if (r102 == true) goto L45;
        r112.setExpedited(true);
    L45:
        return r112.build();
    L33:
        r105 = false;
        goto L35
    L21:
        if (r100.hasContentUriTriggers() == false) goto L27;
        Iterator<ContentUriTriggers.Trigger> r106 = r100.getContentUriTriggers().getTriggers().iterator();
    L24:
        if (r106.hasNext() == false) goto L26;
        r112.addTriggerContentUri(convertContentUriTrigger(r106.next()));
        goto L24
    L26:
        r112.setTriggerContentUpdateDelay(r100.getTriggerContentUpdateDelay());
        r112.setTriggerContentMaxDelay(r100.getTriggerMaxContentDelay());
        goto L27
    L13:
        if (r103 <= 0) goto L16;
        r112.setMinimumLatency(r103);
        goto L19
    L16:
        if (r110.expedited == true) goto L19;
        r112.setImportantWhileForeground(true);
        goto L19
    L5:
        if (r110.backoffPolicy != BackoffPolicy.LINEAR) goto L7;
        int r107 = 0;
    L8:
        r112.setBackoffCriteria(r110.backoffDelayDuration, r107);
        goto L9
    L7:
        r107 = 1;
        goto L8
    }
}
