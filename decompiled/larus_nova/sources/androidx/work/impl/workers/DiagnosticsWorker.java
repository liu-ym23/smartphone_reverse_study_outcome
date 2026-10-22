package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes28.dex */
public class DiagnosticsWorker extends Worker {
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("DiagnosticsWrkr");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        WorkDatabase r100 = WorkManagerImpl.getInstance(getApplicationContext()).getWorkDatabase();
        WorkSpecDao r101 = r100.workSpecDao();
        WorkNameDao r102 = r100.workNameDao();
        WorkTagDao r103 = r100.workTagDao();
        SystemIdInfoDao r104 = r100.systemIdInfoDao();
        List<WorkSpec> r105 = r101.getRecentlyCompletedWork(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<WorkSpec> r106 = r101.getRunningWork();
        List<WorkSpec> r107 = r101.getAllEligibleWorkSpecsForScheduling(200);
        if (r105 != null) goto L5;
    L7:
        if (r106 != null) goto L9;
    L11:
        if (r107 == null) goto L16;
        if (r107.isEmpty() == true) goto L16;
        Logger r108 = Logger.get();
        String r109 = TAG;
        r108.info(r109, "Enqueued work:\n\n", new Throwable[0]);
        Logger.get().info(r109, workSpecRows(r102, r103, r104, r107), new Throwable[0]);
    L16:
        return ListenableWorker.Result.success();
    L9:
        if (r106.isEmpty() == true) goto L11;
        Logger r110 = Logger.get();
        String r111 = TAG;
        r110.info(r111, "Running work:\n\n", new Throwable[0]);
        Logger.get().info(r111, workSpecRows(r102, r103, r104, r106), new Throwable[0]);
        goto L11
    L5:
        if (r105.isEmpty() == true) goto L7;
        Logger r112 = Logger.get();
        String r113 = TAG;
        r112.info(r113, "Recently completed work:\n\n", new Throwable[0]);
        Logger.get().info(r113, workSpecRows(r102, r103, r104, r105), new Throwable[0]);
        goto L7
    }

    public DiagnosticsWorker(Context r100, WorkerParameters r101) {
        super(r100, r101);
    }

    private static String workSpecRow(WorkSpec r100, String r101, Integer r102, String r103) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", new Object[]{r100.f15686id, r100.workerClassName, r102, r100.state.name(), r101, r103});
    }

    private static String workSpecRows(WorkNameDao r100, WorkTagDao r101, SystemIdInfoDao r102, List<WorkSpec> r103) {
        StringBuilder r104 = new StringBuilder();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        String r105 = "Job Id";
    L6:
        r104.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", new Object[]{r105}));
        Iterator<WorkSpec> r106 = r103.iterator();
    L8:
        if (r106.hasNext() == false) goto L15;
        WorkSpec r107 = r106.next();
        SystemIdInfo r108 = r102.getSystemIdInfo(r107.f15686id);
        if (r108 == null) goto L12;
        Integer r109 = Integer.valueOf(r108.systemId);
    L13:
        r104.append(workSpecRow(r107, TextUtils.join(",", r100.getNamesForWorkSpecId(r107.f15686id)), r109, TextUtils.join(",", r101.getTagsForWorkSpecId(r107.f15686id))));
        goto L8
    L12:
        r109 = null;
        goto L13
    L15:
        return r104.toString();
    L5:
        r105 = "Alarm Id";
        goto L6
    }
}
