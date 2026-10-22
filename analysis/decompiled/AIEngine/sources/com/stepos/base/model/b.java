package com.stepos.base.model;

import b7.h;
import b7.i;
import com.stepos.core.ability.speech.PcmDumpBudget;
import gc.n;
import gc.q;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.g;
import l7.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f6348a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicLong f6349b = new AtomicLong(0);

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f6350c;

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f6351d;

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f6352e;

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f6353f;

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f6354g;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static final C0044b a(boolean z) {
            if (z) {
                return b.f6348a.e();
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.base.model.b$b, reason: collision with other inner class name */
    public static final class C0044b {

        /* renamed from: a, reason: collision with root package name */
        public final long f6355a;

        /* renamed from: b, reason: collision with root package name */
        public final long f6356b;

        public C0044b(long j10, long j11) {
            this.f6355a = j10;
            this.f6356b = j11;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0044b)) {
                return false;
            }
            C0044b c0044b = (C0044b) obj;
            return this.f6355a == c0044b.f6355a && this.f6356b == c0044b.f6356b;
        }

        public final int hashCode() {
            return Long.hashCode(this.f6356b) + (Long.hashCode(this.f6355a) * 31);
        }

        public final String toString() {
            return ai.onnxruntime.a.m(ai.onnxruntime.a.q(this.f6355a, "Snapshot(rssMb=", ", dspMb="), this.f6356b, ")");
        }
    }

    static {
        ThreadLocal<byte[]> threadLocal = d.f10346a;
        f6350c = d.a("VmRSS:");
        f6351d = d.a("exp_name:");
        f6352e = d.a("size:");
        f6353f = d.a("ino:");
        f6354g = d.a("/dmabuf:");
    }

    public static String a(C0044b before, C0044b after) {
        String str;
        g.f(before, "before");
        g.f(after, "after");
        long j10 = before.f6355a;
        long j11 = after.f6355a;
        long j12 = before.f6356b;
        long j13 = after.f6356b;
        String str2 = "n/a";
        if (j10 < 0 || j11 < 0) {
            str = "n/a";
        } else {
            str = (j11 - j10) + "MB";
        }
        if (j12 >= 0 && j13 >= 0) {
            str2 = (j13 - j12) + "MB";
        }
        return ai.onnxruntime.a.l("ΔRSS=", str, " ΔDspMmap=", str2);
    }

    public static String b(C0044b s8) {
        g.f(s8, "s");
        long j10 = s8.f6355a;
        long j11 = s8.f6356b;
        return j11 >= 0 ? ai.onnxruntime.a.m(ai.onnxruntime.a.q(j10, "RSS=", "MB DspMmap="), j11, "MB") : ai.onnxruntime.a.h(j10, "RSS=", "MB");
    }

    public static boolean c() {
        Object objA;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "persist.aiengine.memprobe", "0");
            g.d(objInvoke, "null cannot be cast to non-null type kotlin.String");
            Integer numC0 = n.c0(q.L0((String) objInvoke).toString());
            objA = Integer.valueOf(numC0 != null ? numC0.intValue() : 0);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0;
        }
        int iIntValue = ((Number) objA).intValue();
        AtomicLong seq = f6349b;
        g.f(seq, "seq");
        if (iIntValue <= 0) {
            return false;
        }
        return iIntValue == 1 || seq.getAndIncrement() % ((long) iIntValue) == 0;
    }

    public final long d() {
        Object objA;
        File file = new File("/proc/self/fdinfo");
        File file2 = new File("/proc/self/maps");
        try {
            HashMap map = new HashMap();
            File[] fileArrListFiles = file.listFiles();
            long jLongValue = 0;
            if (fileArrListFiles != null) {
                for (File file3 : fileArrListFiles) {
                    try {
                        Ref$LongRef ref$LongRef = new Ref$LongRef();
                        ref$LongRef.f10075a = -1L;
                        Ref$LongRef ref$LongRef2 = new Ref$LongRef();
                        ref$LongRef2.f10075a = -1L;
                        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                        ThreadLocal<byte[]> threadLocal = d.f10346a;
                        g.c(file3);
                        d.f(file3, new b7.g(ref$BooleanRef, ref$LongRef2, ref$LongRef, 0));
                        if (ref$BooleanRef.f10073a) {
                            long j10 = ref$LongRef.f10075a;
                            if (j10 >= 0 && ref$LongRef2.f10075a > 0) {
                                map.put(Long.valueOf(j10), Long.valueOf(ref$LongRef2.f10075a));
                            }
                        }
                        lb.n nVar = lb.n.f10413a;
                    } catch (Throwable th) {
                        c.a(th);
                    }
                }
            }
            ThreadLocal<byte[]> threadLocal2 = d.f10346a;
            d.f(file2, new h(this, map));
            Collection collectionValues = map.values();
            g.e(collectionValues, "<get-values>(...)");
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                jLongValue += ((Number) it.next()).longValue();
            }
            objA = Long.valueOf(jLongValue / PcmDumpBudget.BYTES_PER_MB);
        } catch (Throwable th2) {
            objA = c.a(th2);
        }
        if (objA instanceof Result.Failure) {
            objA = -1L;
        }
        return ((Number) objA).longValue();
    }

    public final C0044b e() {
        Object objA;
        try {
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ThreadLocal<byte[]> threadLocal = d.f10346a;
            d.f(new File("/proc/self/status"), new i(0, ref$BooleanRef, ref$LongRef));
            objA = Long.valueOf(ref$LongRef.f10075a / 1024);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = -1L;
        }
        return new C0044b(((Number) objA).longValue(), d());
    }
}
