package com.obric.agent.utils;

import android.os.SystemClock;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f16016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile a f16017c;

    /* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f16018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f16019b;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if (this.f16018a == r10.f16018a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f16019b, r10.f16019b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f16018a) * 31) + this.f16019b.hashCode();
        }

        public String toString() {
            return "Snapshot(collectedTimestamp=" + this.f16018a + ", envJson=" + this.f16019b + ')';
        }

        public a(long r2, String r4) {
            d.h.b.o.e(r4, "envJson");
            this.f16018a = r2;
            this.f16019b = r4;
        }

        public final long a() {
            return this.f16018a;
        }

        public final String b() {
            return this.f16019b;
        }
    }

    public abstract void a(JSONObject r1, long r2);

    public c(String r2, long r3) {
        d.h.b.o.e(r2, "name");
        this.f16015a = r2;
        this.f16016b = r3;
    }

    public final String a() {
        return this.f16015a;
    }

    public final void a(JSONObject r11) {
        d.h.b.o.e(r11, "env");
        long r0 = SystemClock.elapsedRealtime();
        long r2 = System.currentTimeMillis();
        boolean r4 = true;
        a r6 = this.f16017c;     // Catch: Throwable -> L32
        a r7 = null;
        if (r6 != null) goto L6;
    L15:
        monitor-enter(this);     // Catch: Throwable -> L32
        a r8 = this.f16017c;     // Catch: Throwable -> L29
        if (r8 != null) goto L19;
    L23:
        r7 = a(r2);     // Catch: Throwable -> L29
        this.f16017c = r7;     // Catch: Throwable -> L29
        r4 = false;
    L25:
        monitor-exit(this);     // Catch: Throwable -> L13
        a(r11, r7);     // Catch: Throwable -> L13
        ILogDepend.Companion.i("ClientPhoneEnvInfo", "client env collector collect name=" + this.f16015a + " cost=" + (SystemClock.elapsedRealtime() - r0) + "ms fromCache=" + r4);
        return;
    L19:
        if (a(r2, r8.a()) == false) goto L21;
        r7 = r8;
    L21:
        if (r7 == null) goto L23;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L6:
        if (a(r2, r6.a()) == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L15;
        a(r11, r6);     // Catch: Throwable -> L13
        ILogDepend.Companion.i("ClientPhoneEnvInfo", "client env collector collect name=" + this.f16015a + " cost=" + (SystemClock.elapsedRealtime() - r0) + "ms fromCache=true");
        return;
    L13:
        th = th;
    L34:
        ILogDepend.Companion.i("ClientPhoneEnvInfo", "client env collector collect name=" + this.f16015a + " cost=" + (SystemClock.elapsedRealtime() - r0) + "ms fromCache=" + r4);
        throw th;
    L32:
        th = th;
        r4 = false;
        goto L34
    }

    private final a a(long r3) {
        JSONObject r0 = new JSONObject();
        a(r0, r3);
        String r1 = r0.toString();
        d.h.b.o.c(r1, "toString(...)");
        return new a(r3, r1);
    }

    private final boolean a(long r1, long r3) {
        long r2 = r1 - r3;
        if (r2 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r2 >= this.f16016b) goto L7;
        return true;
    }

    private final void a(JSONObject r1, a r2) {
        f.a(r1, new JSONObject(r2.b()));
    }
}
