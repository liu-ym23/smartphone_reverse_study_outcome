package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.compress.parallel.FileBasedScatterGatherBackingStore;
import org.apache.commons.compress.parallel.InputStreamSupplier;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;
import org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier;

/* JADX INFO: loaded from: classes3.dex */
public class ParallelScatterZipCreator {
    private final ScatterGatherBackingStoreSupplier backingStoreSupplier;
    private long compressionDoneAt;
    private final ExecutorService es;
    private final List<Future<Object>> futures;
    private long scatterDoneAt;
    private final long startedAt;
    private final List<ScatterZipOutputStream> streams;
    private final ThreadLocal<ScatterZipOutputStream> tlScatterStreams;

    private static class DefaultBackingStoreSupplier implements ScatterGatherBackingStoreSupplier {
        final AtomicInteger storeNum;

        private DefaultBackingStoreSupplier() {
            this.storeNum = new AtomicInteger(0);
        }

        /* synthetic */ DefaultBackingStoreSupplier(AnonymousClass1 x0) {
            this();
        }

        @Override // org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier
        public ScatterGatherBackingStore get() throws IOException {
            File tempFile = File.createTempFile("parallelscatter", "n" + this.storeNum.incrementAndGet());
            return new FileBasedScatterGatherBackingStore(tempFile);
        }
    }

    static /* synthetic */ ScatterGatherBackingStoreSupplier access$000(ParallelScatterZipCreator x0) {
        return x0.backingStoreSupplier;
    }

    static /* synthetic */ ScatterZipOutputStream access$100(ParallelScatterZipCreator x0, ScatterGatherBackingStoreSupplier x1) throws IOException {
        return x0.createDeferred(x1);
    }

    static /* synthetic */ List access$200(ParallelScatterZipCreator x0) {
        return x0.streams;
    }

    static /* synthetic */ ThreadLocal access$400(ParallelScatterZipCreator x0) {
        return x0.tlScatterStreams;
    }

    private ScatterZipOutputStream createDeferred(ScatterGatherBackingStoreSupplier scatterGatherBackingStoreSupplier) throws IOException {
        ScatterGatherBackingStore bs = scatterGatherBackingStoreSupplier.get();
        StreamCompressor sc = StreamCompressor.create(-1, bs);
        return new ScatterZipOutputStream(bs, sc);
    }

    public ParallelScatterZipCreator() {
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
    }

    public ParallelScatterZipCreator(ExecutorService executorService) {
        this(executorService, new DefaultBackingStoreSupplier(null));
    }

    public ParallelScatterZipCreator(ExecutorService executorService, ScatterGatherBackingStoreSupplier backingStoreSupplier) {
        this.streams = Collections.synchronizedList(new ArrayList());
        this.futures = new ArrayList();
        this.startedAt = System.currentTimeMillis();
        this.compressionDoneAt = 0;
        this.tlScatterStreams = new AnonymousClass1(this);
        this.backingStoreSupplier = backingStoreSupplier;
        this.es = executorService;
    }

    public void addArchiveEntry(ZipArchiveEntry zipArchiveEntry, InputStreamSupplier source) {
        submit(createCallable(zipArchiveEntry, source));
    }

    public void addArchiveEntry(ZipArchiveEntryRequestSupplier zipArchiveEntryRequestSupplier) {
        submit(createCallable(zipArchiveEntryRequestSupplier));
    }

    public final void submit(Callable<Object> callable) {
        this.futures.add(this.es.submit(callable));
    }

    public final Callable<Object> createCallable(ZipArchiveEntry zipArchiveEntry, InputStreamSupplier source) {
        int method = zipArchiveEntry.getMethod();
        if (method == (-1)) goto L7;
        final ZipArchiveEntryRequest zipArchiveEntryRequest = ZipArchiveEntryRequest.createZipArchiveEntryRequest(zipArchiveEntry, source);
        return new AnonymousClass2(this, zipArchiveEntryRequest);
    L7:
        throw new IllegalArgumentException("Method must be set on zipArchiveEntry: " + zipArchiveEntry);
    }

    public final Callable<Object> createCallable(final ZipArchiveEntryRequestSupplier zipArchiveEntryRequestSupplier) {
        return new AnonymousClass3(this, zipArchiveEntryRequestSupplier);
    }

    public void writeTo(ZipArchiveOutputStream targetStream) throws IOException, InterruptedException, ExecutionException {
        Iterator<Future<Object>> r0 = this.futures.iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L9;
        Future<?> future = r0.next();     // Catch: Throwable -> L7
        future.get();     // Catch: Throwable -> L7
        goto L4
    L9:
        this.es.shutdown();
        this.es.awaitTermination(60000, TimeUnit.SECONDS);
        this.compressionDoneAt = System.currentTimeMillis();
        List<ScatterZipOutputStream> r1 = this.streams;
        monitor-enter(r1);
        Iterator<ScatterZipOutputStream> r2 = this.streams.iterator();     // Catch: Throwable -> L15
    L13:
        if (r2.hasNext() == false) goto L17;
        ScatterZipOutputStream scatterStream = r2.next();     // Catch: Throwable -> L15
        scatterStream.writeTo(targetStream);     // Catch: Throwable -> L15
        scatterStream.close();     // Catch: Throwable -> L15
        goto L13
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L15
        this.scatterDoneAt = System.currentTimeMillis();
        return;
    L15:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        this.es.shutdown();
        throw th;
    }

    public ScatterStatistics getStatisticsMessage() {
        return new ScatterStatistics(this.compressionDoneAt - this.startedAt, this.scatterDoneAt - this.compressionDoneAt);
    }
}
