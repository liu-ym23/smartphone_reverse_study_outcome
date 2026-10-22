package com.stepos.core.common.log;

import fc.f;
import fc.i;
import fc.p;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogRingBuffer {
    private final LogEntry[] buffer;
    private final int capacity;
    private final AtomicLong writeIndex = new AtomicLong(0);
    private final AtomicInteger count = new AtomicInteger(0);
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final LogStatistics stats = new LogStatistics(null, null, null, null, null, 31, null);

    public LogRingBuffer(int i10) {
        this.capacity = i10;
        this.buffer = new LogEntry[i10];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List filterLogs$default(LogRingBuffer logRingBuffer, List list, LogLevel logLevel, Boolean bool, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = null;
        }
        if ((i10 & 2) != 0) {
            logLevel = null;
        }
        if ((i10 & 4) != 0) {
            bool = null;
        }
        if ((i10 & 8) != 0) {
            num = null;
        }
        return logRingBuffer.filterLogs(list, logLevel, bool, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean filterLogs$lambda$10$lambda$9(LogLevel logLevel, LogEntry it) {
        g.f(it, "it");
        return it.getLevel().getPriority() >= logLevel.getPriority();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean filterLogs$lambda$12$lambda$11(boolean z, LogEntry it) {
        g.f(it, "it");
        return it.isFromNative() == z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean filterLogs$lambda$8$lambda$7(List list, LogEntry it) {
        g.f(it, "it");
        return list.contains(it.getModule());
    }

    public final void clear() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i11 = 0; i11 < readHoldCount; i11++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            int length = this.buffer.length;
            for (int i12 = 0; i12 < length; i12++) {
                this.buffer[i12] = null;
            }
            this.writeIndex.set(0L);
            this.count.set(0);
            this.stats.reset();
            n nVar = n.f10413a;
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final List<LogEntry> filterByLevel(LogLevel minLevel) {
        g.f(minLevel, "minLevel");
        List<LogEntry> all = getAll();
        ArrayList arrayList = new ArrayList();
        for (Object obj : all) {
            if (((LogEntry) obj).getLevel().getPriority() >= minLevel.getPriority()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<LogEntry> filterByModule(LogModule module) {
        g.f(module, "module");
        List<LogEntry> all = getAll();
        ArrayList arrayList = new ArrayList();
        for (Object obj : all) {
            if (((LogEntry) obj).getModule() == module) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<LogEntry> filterLogs(List<? extends LogModule> list, LogLevel logLevel, Boolean bool, Integer num) {
        List<LogEntry> listK0;
        i iVarL0 = kotlin.collections.a.l0(getAll());
        if (list != null) {
            iVarL0 = new f(iVarL0, new androidx.compose.runtime.g(list, 9));
        }
        if (logLevel != null) {
            iVarL0 = new f(iVarL0, new androidx.compose.runtime.i(logLevel, 6));
        }
        if (bool != null) {
            final boolean zBooleanValue = bool.booleanValue();
            iVarL0 = new f(iVarL0, new l() { // from class: com.stepos.core.common.log.b
                @Override // zb.l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(LogRingBuffer.filterLogs$lambda$12$lambda$11(zBooleanValue, (LogEntry) obj));
                }
            });
        }
        List<LogEntry> listA = p.A(iVarL0);
        return (num == null || (listK0 = kotlin.collections.a.K0(num.intValue(), listA)) == null) ? listA : listK0;
    }

    public final List<LogEntry> getAll() {
        List<LogEntry> list;
        ReentrantReadWriteLock.ReadLock lock = this.lock.readLock();
        lock.lock();
        try {
            int i10 = this.count.get();
            if (i10 == 0) {
                list = EmptyList.f10001a;
            } else {
                long j10 = this.writeIndex.get();
                ArrayList arrayList = new ArrayList(i10);
                int i11 = this.capacity;
                long j11 = i10 >= i11 ? j10 % i11 : 0L;
                for (int i12 = 0; i12 < i10; i12++) {
                    LogEntry logEntry = this.buffer[(int) ((i12 + j11) % this.capacity)];
                    if (logEntry != null) {
                        arrayList.add(logEntry);
                    }
                }
                list = arrayList;
            }
            lock.unlock();
            return list;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public final List<LogEntry> getRecent(int i10) {
        List<LogEntry> list;
        ReentrantReadWriteLock.ReadLock lock = this.lock.readLock();
        lock.lock();
        try {
            int i11 = this.count.get();
            if (i11 == 0) {
                list = EmptyList.f10001a;
            } else {
                int iMin = Math.min(i10, i11);
                long j10 = this.writeIndex.get();
                ArrayList arrayList = new ArrayList(iMin);
                for (int i12 = 0; i12 < iMin; i12++) {
                    int i13 = this.capacity;
                    LogEntry logEntry = this.buffer[(int) ((((j10 - 1) - i12) + (i13 * 2)) % i13)];
                    if (logEntry != null) {
                        arrayList.add(0, logEntry);
                    }
                }
                list = arrayList;
            }
            lock.unlock();
            return list;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public final LogStatistics getStatistics() {
        return this.stats.copy();
    }

    public final void put(LogEntry entry) {
        g.f(entry, "entry");
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i11 = 0; i11 < readHoldCount; i11++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            this.buffer[(int) (this.writeIndex.getAndIncrement() % this.capacity)] = entry;
            if (this.count.get() < this.capacity) {
                this.count.incrementAndGet();
            }
            this.stats.getTotalCount().incrementAndGet();
            this.stats.updateLevelCount(entry.getLevel());
            this.stats.updateModuleCount(entry.getModule());
            n nVar = n.f10413a;
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final int size() {
        return this.count.get();
    }
}
