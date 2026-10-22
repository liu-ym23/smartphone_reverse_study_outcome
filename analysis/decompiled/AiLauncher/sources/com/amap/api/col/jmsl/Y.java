package com.amap.api.col.jmsl;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class Y {

    /* renamed from: c, reason: collision with root package name */
    public final long f16476c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16477d;

    /* renamed from: f, reason: collision with root package name */
    public final File f16479f;

    /* renamed from: e, reason: collision with root package name */
    public final Map<File, Long> f16478e = Collections.synchronizedMap(new HashMap());

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f16474a = new AtomicLong();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f16475b = new AtomicInteger();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f16480a;

        /* renamed from: com.amap.api.col.jmsl.Y$a$a, reason: collision with other inner class name */
        public class C0202a implements FilenameFilter {
            public C0202a(a aVar) {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith("cdu_");
            }
        }

        public a(File file) {
            this.f16480a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArrListFiles = this.f16480a.listFiles(new C0202a(this));
            if (fileArrListFiles != null) {
                int length = 0;
                int i10 = 0;
                for (File file : fileArrListFiles) {
                    length = (int) (length + file.length());
                    i10++;
                    Y.this.f16478e.put(file, Long.valueOf(file.lastModified()));
                }
                Y.this.f16474a.getAndAdd(length);
                Y.this.f16475b.getAndAdd(i10);
            }
        }
    }

    public class b implements FilenameFilter {
        public b(Y y10) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith("cdu_");
        }
    }

    public Y(File file, long j10, int i10) {
        this.f16479f = file;
        this.f16476c = j10;
        this.f16477d = i10;
        C1534b.a().b(new a(file));
    }

    public final String a(String str) {
        return "cdu_" + str.substring(0, 3) + str.substring(3).hashCode();
    }

    public void c(File file) {
        File key;
        this.f16475b.addAndGet(1);
        this.f16474a.addAndGet(file.length());
        while (true) {
            if (this.f16475b.get() <= this.f16477d && this.f16474a.get() <= this.f16476c) {
                return;
            }
            AtomicLong atomicLong = this.f16474a;
            long j10 = 0;
            if (!this.f16478e.isEmpty()) {
                Long l10 = Long.MAX_VALUE;
                Set<Map.Entry<File, Long>> setEntrySet = this.f16478e.entrySet();
                synchronized (this.f16478e) {
                    try {
                        key = null;
                        for (Map.Entry<File, Long> entry : setEntrySet) {
                            Long value = entry.getValue();
                            if (value.longValue() < l10.longValue()) {
                                key = entry.getKey();
                                l10 = value;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (key != null) {
                    long length = key.length();
                    if (key.delete()) {
                        this.f16478e.remove(key);
                        j10 = length;
                    }
                }
            }
            atomicLong.addAndGet(-j10);
            this.f16475b.addAndGet(-1);
        }
    }

    public boolean d() {
        File[] fileArrListFiles = this.f16479f.listFiles(new b(this));
        boolean z10 = true;
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                if (file.delete()) {
                    this.f16474a.addAndGet(-file.length());
                    this.f16475b.addAndGet(-1);
                    this.f16478e.remove(file);
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                this.f16478e.clear();
                this.f16474a.set(0L);
                this.f16475b.set(0);
            }
        }
        return z10;
    }

    public File e(String str) {
        File file = new File(this.f16479f, a(str));
        if (file.exists()) {
            this.f16475b.addAndGet(-1);
            this.f16474a.addAndGet(-file.length());
        }
        return file;
    }

    public void g(File file) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        file.setLastModified(jCurrentTimeMillis);
        this.f16478e.put(file, lValueOf);
    }

    public File h(String str) {
        File file = new File(this.f16479f, a(str));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public boolean j(String str) {
        File file = new File(this.f16479f, a(str));
        if (!file.exists()) {
            file = null;
        }
        if (file == null) {
            return true;
        }
        if (!file.delete()) {
            return false;
        }
        this.f16474a.addAndGet(-file.length());
        this.f16475b.addAndGet(-1);
        this.f16478e.remove(file);
        return true;
    }
}
