package com.danikula.videocache.file;

import com.danikula.videocache.KLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LruDiskUsage implements DiskUsage {
    private final ExecutorService workerThread;

    public class TouchCallable implements Callable<Void> {
        private final File file;
        final /* synthetic */ LruDiskUsage this$0;

        public TouchCallable(LruDiskUsage r10, File r11) {
            this.this$0 = r10;
            this.file = r11;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            LruDiskUsage.access$000(this.this$0, this.file);
            return null;
        }
    }

    public LruDiskUsage() {
        this.workerThread = Executors.newSingleThreadExecutor();
    }

    public static /* synthetic */ void access$000(LruDiskUsage r10, File r11) throws IOException {
        r10.touchInBackground(r11);
    }

    private long countTotalSize(List<File> r10) {
        Iterator<File> r11 = r10.iterator();
        long r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().length();
        goto L4
    L6:
        return r12;
    }

    private void touchInBackground(File r10) throws IOException {
        Files.setLastModifiedNow(r10);
        trim(Files.getLruListFiles(r10.getParentFile()));
    }

    private void trim(List<File> r10) {
        long r11 = countTotalSize(r10);
        int r12 = r10.size();
        Iterator<File> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        File r14 = r13.next();
        if (accept(r14, r11, r12) == true) goto L4;
        long r15 = r14.length();
        if (r14.delete() == true) goto L9;
        KLog.e("Error deleting file " + r14 + " for trimming cache");
        goto L4
    L9:
        r12 = r12 - 1;
        r11 = r11 - r15;
        KLog.i("Cache file " + r14 + " is deleted because it exceeds cache limit");
        goto L4
    }

    public abstract boolean accept(File r10, long r11, int r12);

    @Override // com.danikula.videocache.file.DiskUsage
    public void touch(File r10) throws IOException {
        this.workerThread.submit(new TouchCallable(this, r10));
    }
}
