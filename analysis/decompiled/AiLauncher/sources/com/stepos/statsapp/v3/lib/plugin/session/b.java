package com.stepos.statsapp.v3.lib.plugin.session;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static final String f30950d = "PageController";

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<a> f30951a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    private final long f30952b = 43200000;

    /* renamed from: c, reason: collision with root package name */
    private final int f30953c = 100;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f30954a;

        /* renamed from: b, reason: collision with root package name */
        public long f30955b;

        /* renamed from: c, reason: collision with root package name */
        public long f30956c;

        public a(String str, long j10, long j11) {
            this.f30954a = str;
            this.f30955b = j10;
            this.f30956c = j11;
        }

        public String toString() {
            return "[" + this.f30954a + Const.STR_MART_COMMA + this.f30955b + Const.STR_MART_COMMA + this.f30956c + "]";
        }
    }

    public b() {
        Logger.d(f30950d, "PageController init");
    }

    public long a(String str) {
        Iterator<a> it = this.f30951a.iterator();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (str.equals(next.f30954a)) {
                long j10 = jElapsedRealtime - next.f30956c;
                if (j10 > 0) {
                    return j10;
                }
            }
        }
        return 0L;
    }

    public synchronized void b(String str) throws Throwable {
        try {
            try {
                Logger.d(f30950d, "startPage: " + str);
                this.f30951a.addFirst(new a(str, System.currentTimeMillis(), SystemClock.elapsedRealtime()));
                int size = this.f30951a.size() - 100;
                if (size > 0) {
                    Logger.d(f30950d, "ON_PAGE_STOP, too many pages in stack, delete pages " + size);
                    for (int i10 = 0; i10 < size; i10++) {
                        this.f30951a.removeLast();
                    }
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public synchronized a c(String str) {
        a aVar;
        try {
            Logger.d(f30950d, "stopPage: " + str);
            Iterator<a> it = this.f30951a.iterator();
            while (it.hasNext()) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                a next = it.next();
                if (Math.abs(jElapsedRealtime - next.f30956c) > 43200000) {
                    it.remove();
                    Logger.d(f30950d, "#2_remove invalid page who's duration > 12 hours:" + next);
                }
            }
            Iterator<a> it2 = this.f30951a.iterator();
            aVar = null;
            while (it2.hasNext()) {
                a next2 = it2.next();
                if (str.equals(next2.f30954a)) {
                    if (aVar == null) {
                        Logger.d(f30950d, "stopPage, first found page: " + next2);
                        aVar = next2;
                    } else {
                        Logger.d(f30950d, "stopPage, found repeated page: " + next2);
                    }
                    it2.remove();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVar;
    }
}
