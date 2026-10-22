package w0;

import android.app.job.JobParameters;
import android.net.Network;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class d {
    @DoNotInline
    public static Network a(JobParameters jobParameters) {
        return jobParameters.getNetwork();
    }
}
