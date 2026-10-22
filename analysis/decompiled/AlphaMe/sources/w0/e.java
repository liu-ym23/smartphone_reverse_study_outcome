package w0;

import android.app.job.JobParameters;
import androidx.annotation.DoNotInline;
import androidx.work.impl.background.systemjob.SystemJobService;

/* loaded from: classes.dex */
public abstract class e {
    @DoNotInline
    public static int a(JobParameters jobParameters) {
        int stopReason = jobParameters.getStopReason();
        String str = SystemJobService.f4334e;
        switch (stopReason) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return stopReason;
            default:
                return -512;
        }
    }
}
