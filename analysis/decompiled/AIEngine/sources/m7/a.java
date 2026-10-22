package m7;

import androidx.compose.runtime.g;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.model.manager.i;
import com.stepos.core.ota.d;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f10498a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10499b;

    /* renamed from: c, reason: collision with root package name */
    public final zb.a<Long> f10500c;

    /* renamed from: d, reason: collision with root package name */
    public final zb.a<Long> f10501d;

    /* renamed from: e, reason: collision with root package name */
    public final g f10502e;

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f10503f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f10504g;
    public g h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayDeque<Long> f10505i;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: m7.a$a, reason: collision with other inner class name */
    public static final class C0108a {

        /* renamed from: a, reason: collision with root package name */
        public final String f10506a;

        /* renamed from: b, reason: collision with root package name */
        public final long f10507b;

        /* renamed from: c, reason: collision with root package name */
        public final long f10508c;

        /* renamed from: d, reason: collision with root package name */
        public final String f10509d;

        public C0108a(String threadName, long j10, long j11, String stackSnapshot) {
            kotlin.jvm.internal.g.f(threadName, "threadName");
            kotlin.jvm.internal.g.f(stackSnapshot, "stackSnapshot");
            this.f10506a = threadName;
            this.f10507b = j10;
            this.f10508c = j11;
            this.f10509d = stackSnapshot;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0108a)) {
                return false;
            }
            C0108a c0108a = (C0108a) obj;
            return kotlin.jvm.internal.g.b(this.f10506a, c0108a.f10506a) && this.f10507b == c0108a.f10507b && this.f10508c == c0108a.f10508c && kotlin.jvm.internal.g.b(this.f10509d, c0108a.f10509d);
        }

        public final int hashCode() {
            return this.f10509d.hashCode() + a0.a.c(a0.a.c(this.f10506a.hashCode() * 31, this.f10507b, 31), this.f10508c, 31);
        }

        public final String toString() {
            StringBuilder sbL = d.l("DeadlockReport(threadName=", this.f10507b, this.f10506a, ", lastFeedMs=");
            a0.a.s(this.f10508c, ", nowMs=", ", stackSnapshot=", sbL);
            return ai.onnxruntime.a.o(sbL, this.f10509d, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public volatile long f10510a;

        /* renamed from: c, reason: collision with root package name */
        public final Executor f10512c;

        /* renamed from: d, reason: collision with root package name */
        public volatile long f10513d;

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f10511b = false;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f10514e = new AtomicBoolean(false);

        public b(long j10, Executor executor, long j11) {
            this.f10510a = j10;
            this.f10512c = executor;
            this.f10513d = j11;
        }
    }

    public a() {
        throw null;
    }

    public a(g gVar) {
        com.stepos.cpuset.c cVar = new com.stepos.cpuset.c(7);
        com.stepos.cpuset.b bVar = new com.stepos.cpuset.b(10);
        this.f10498a = TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS;
        this.f10499b = 600000L;
        this.f10500c = cVar;
        this.f10501d = bVar;
        this.f10502e = gVar;
        this.f10503f = new ConcurrentHashMap<>();
        this.f10504g = new Object();
        this.f10505i = new ArrayDeque<>();
    }

    public static String a(String str) {
        Object next;
        try {
            Iterator<T> it = Thread.getAllStackTraces().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (kotlin.jvm.internal.g.b(((Thread) ((Map.Entry) next).getKey()).getName(), str)) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) next;
            StackTraceElement[] stackTraceElementArr = entry != null ? (StackTraceElement[]) entry.getValue() : null;
            if (stackTraceElementArr != null && stackTraceElementArr.length != 0) {
                StringBuilder sb2 = new StringBuilder(1024);
                int iMin = Math.min(stackTraceElementArr.length, 32);
                for (int i10 = 0; i10 < iMin && sb2.length() < 4096; i10++) {
                    String string = stackTraceElementArr[i10].toString();
                    kotlin.jvm.internal.g.e(string, "toString(...)");
                    if (string.length() > 200) {
                        String strSubstring = string.substring(0, 200);
                        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
                        string = strSubstring + "…";
                    }
                    if (sb2.length() > 0) {
                        sb2.append('\n');
                    }
                    sb2.append("  at ");
                    sb2.append(string);
                }
                if (stackTraceElementArr.length > iMin && sb2.length() < 4096) {
                    sb2.append("\n  … (");
                    sb2.append(stackTraceElementArr.length - iMin);
                    sb2.append(" more)");
                }
                if (sb2.length() > 4096) {
                    sb2.setLength(4096);
                    sb2.append("…");
                }
                return sb2.toString();
            }
            return "<unavailable>";
        } catch (Throwable unused) {
            return "<unavailable>";
        }
    }

    public final boolean b(b bVar, long j10) {
        if (bVar.f10510a <= j10) {
            return bVar.f10512c == null || this.f10501d.invoke().longValue() - bVar.f10513d >= this.f10498a;
        }
        return false;
    }

    public final void c() {
        for (Map.Entry<String, b> entry : this.f10503f.entrySet()) {
            String key = entry.getKey();
            b value = entry.getValue();
            Executor executor = value.f10512c;
            if (executor != null && value.f10514e.compareAndSet(false, true)) {
                try {
                    executor.execute(new i((Object) this, key, (Object) value, 6));
                } catch (Exception unused) {
                    value.f10514e.set(false);
                }
            }
        }
        long jLongValue = this.f10500c.invoke().longValue();
        long j10 = jLongValue - this.f10498a;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, b> entry2 : this.f10503f.entrySet()) {
            String key2 = entry2.getKey();
            b value2 = entry2.getValue();
            if (!f(key2, value2) && !value2.f10511b && b(value2, j10)) {
                synchronized (this.f10504g) {
                    if (this.f10503f.get(key2) == value2 && !value2.f10511b && !f(key2, value2) && b(value2, j10)) {
                        value2.f10511b = true;
                        C0108a c0108a = new C0108a(key2, value2.f10510a, jLongValue, a(key2));
                        arrayList.add(c0108a);
                        synchronized (this.f10505i) {
                            this.f10505i.addLast(Long.valueOf(jLongValue));
                            ArrayDeque<Long> arrayDeque = this.f10505i;
                            long j11 = jLongValue - this.f10499b;
                            while (!arrayDeque.isEmpty()) {
                                Long lPeekFirst = arrayDeque.peekFirst();
                                if ((lPeekFirst != null ? lPeekFirst.longValue() : Long.MAX_VALUE) >= j11) {
                                    break;
                                } else {
                                    arrayDeque.pollFirst();
                                }
                            }
                            n nVar = n.f10413a;
                        }
                        try {
                            this.f10502e.invoke(c0108a);
                        } catch (Throwable unused2) {
                        }
                    }
                    n nVar2 = n.f10413a;
                }
            }
        }
    }

    public final void d(String threadName, Executor executor) {
        g gVar;
        kotlin.jvm.internal.g.f(threadName, "threadName");
        synchronized (this.f10504g) {
            try {
                boolean zIsEmpty = this.f10503f.isEmpty();
                this.f10503f.put(threadName, new b(this.f10500c.invoke().longValue(), executor, executor != null ? this.f10501d.invoke().longValue() : 0L));
                if (zIsEmpty && (gVar = this.h) != null) {
                    gVar.invoke(Boolean.TRUE);
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(String threadName) {
        g gVar;
        kotlin.jvm.internal.g.f(threadName, "threadName");
        synchronized (this.f10504g) {
            try {
                if (this.f10503f.remove(threadName) != null && this.f10503f.isEmpty() && (gVar = this.h) != null) {
                    gVar.invoke(Boolean.FALSE);
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean f(String str, b bVar) {
        g gVar;
        Executor executor = bVar.f10512c;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService == null || !executorService.isTerminated()) {
            return false;
        }
        synchronized (this.f10504g) {
            try {
                if (this.f10503f.get(str) == bVar) {
                    this.f10503f.remove(str);
                    if (this.f10503f.isEmpty() && (gVar = this.h) != null) {
                        gVar.invoke(Boolean.FALSE);
                    }
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }
}
