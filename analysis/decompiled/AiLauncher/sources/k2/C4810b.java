package k2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import h2.C4124a;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.zip.Adler32;
import l2.InterfaceC4863c;
import o2.C4998a;

/* renamed from: k2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4810b implements o {

    /* renamed from: a, reason: collision with root package name */
    public final Context f34590a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4863c f34591b;

    /* renamed from: c, reason: collision with root package name */
    public final SchedulerConfig f34592c;

    public C4810b(Context context, InterfaceC4863c interfaceC4863c, SchedulerConfig schedulerConfig) {
        this.f34590a = context;
        this.f34591b = interfaceC4863c;
        this.f34592c = schedulerConfig;
    }

    @Override // k2.o
    public void a(e2.m mVar, int i10) {
        b(mVar, i10, false);
    }

    @Override // k2.o
    public void b(e2.m mVar, int i10, boolean z10) {
        ComponentName componentName = new ComponentName(this.f34590a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f34590a.getSystemService("jobscheduler");
        int iC = c(mVar);
        if (!z10 && d(jobScheduler, iC, i10)) {
            C4124a.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", mVar);
            return;
        }
        long jW = this.f34591b.W(mVar);
        JobInfo.Builder builderC = this.f34592c.c(new JobInfo.Builder(iC, componentName), mVar.d(), jW, i10);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i10);
        persistableBundle.putString("backendName", mVar.b());
        persistableBundle.putInt("priority", C4998a.a(mVar.d()));
        if (mVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(mVar.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        C4124a.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", mVar, Integer.valueOf(iC), Long.valueOf(this.f34592c.g(mVar.d(), jW, i10)), Long.valueOf(jW), Integer.valueOf(i10));
        jobScheduler.schedule(builderC.build());
    }

    public int c(e2.m mVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f34590a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(mVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(C4998a.a(mVar.d())).array());
        if (mVar.c() != null) {
            adler32.update(mVar.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean d(JobScheduler jobScheduler, int i10, int i11) {
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JobInfo next = it.next();
            int i12 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == i10) {
                if (i12 >= i11) {
                    return true;
                }
            }
        }
        return false;
    }
}
