package M0;

import H4.o;
import android.util.Log;
import com.bytedance.apm.core.ActivityLifeObserver;
import g1.AbstractC1451a;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import s1.AbstractRunnableC1911a;

/* loaded from: classes2.dex */
public final class c extends AbstractRunnableC1911a {
    public final /* synthetic */ int d = 0;

    public /* synthetic */ c(long j5) {
        super(j5);
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] fileArrListFiles;
        FileChannel channel;
        switch (this.d) {
            case 0:
                S0.g gVar = S0.g.c;
                CopyOnWriteArrayList copyOnWriteArrayList = N0.a.f1006a;
                if (!copyOnWriteArrayList.contains(gVar)) {
                    copyOnWriteArrayList.add(gVar);
                }
                if (AbstractC1451a.P()) {
                    ActivityLifeObserver.getInstance().register(new Y.c());
                    return;
                }
                return;
            default:
                File file = new File(S0.b.x0(), "child_process_persistent");
                if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2 != null && file2.exists() && file2.length() > 0) {
                            try {
                                if (Long.parseLong(file2.getName().split("_")[0]) >= AbstractC1451a.J()) {
                                    continue;
                                } else {
                                    FileChannel fileChannel = null;
                                    try {
                                        channel = new RandomAccessFile(file2, "rw").getChannel();
                                        try {
                                            FileLock fileLockTryLock = channel.tryLock(0L, Long.MAX_VALUE, false);
                                            if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                                                File file3 = new File(S0.b.i(), System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + ".log");
                                                String absolutePath = file2.getAbsolutePath();
                                                String absolutePath2 = file3.getAbsolutePath();
                                                File file4 = new File(absolutePath);
                                                boolean zRenameTo = !file4.exists() ? false : file4.renameTo(new File(absolutePath2));
                                                if (AbstractC1451a.f4467a) {
                                                    o.f(S0.a.f1163a, "moveInactiveSubProcessData: src:" + file2.getAbsolutePath() + " dst:" + file3.getAbsolutePath() + " isSuccess:" + zRenameTo);
                                                }
                                                fileLockTryLock.release();
                                            } else if (AbstractC1451a.f4467a) {
                                                o.f(S0.a.f1163a, "moveInactiveSubProcessData isValid is not true ");
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            fileChannel = channel;
                                            try {
                                                if (AbstractC1451a.f4467a) {
                                                    String str = S0.a.f1163a;
                                                    if (AbstractC1451a.f4467a) {
                                                        Log.w(str, "moveInactiveSubProcessData failed.", th);
                                                    }
                                                }
                                                channel = fileChannel;
                                                S0.b.F(channel);
                                            } catch (Throwable th2) {
                                                S0.b.F(fileChannel);
                                                throw th2;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                    S0.b.F(channel);
                                }
                            } catch (Throwable unused) {
                                continue;
                            }
                        }
                    }
                    return;
                }
                return;
        }
    }

    public c(S0.e eVar) {
        super(10000L);
    }
}
