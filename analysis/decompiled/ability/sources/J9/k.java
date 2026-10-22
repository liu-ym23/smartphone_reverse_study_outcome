package J9;

import N9.m;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f901a;
    public int b;
    public final long c;
    public final Object d;
    public Object e;
    public final Serializable f;

    public k(String str, String str2, HashMap map) {
        this.f901a = 1;
        this.b = 2;
        this.e = "no error";
        this.c = 0L;
        this.f = null;
        this.d = str2;
        this.c = System.currentTimeMillis();
        this.f = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x002e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0033 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(F9.C0223a r5, J9.i r6, java.util.ArrayList r7, boolean r8) {
        /*
            r4 = this;
            java.io.Serializable r4 = r4.f
            java.util.concurrent.ConcurrentLinkedQueue r4 = (java.util.concurrent.ConcurrentLinkedQueue) r4
            java.util.Iterator r4 = r4.iterator()
        L8:
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 == 0) goto L37
            java.lang.Object r0 = r4.next()
            okhttp3.internal.connection.a r0 = (okhttp3.internal.connection.a) r0
            java.lang.String r2 = "connection"
            kotlin.jvm.internal.k.e(r0, r2)
            monitor-enter(r0)
            r2 = 1
            if (r8 == 0) goto L28
            M9.o r3 = r0.g     // Catch: java.lang.Throwable -> L26
            if (r3 == 0) goto L23
            r1 = r2
        L23:
            if (r1 == 0) goto L33
            goto L28
        L26:
            r4 = move-exception
            goto L35
        L28:
            boolean r1 = r0.h(r5, r7)     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L33
            r6.a(r0)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r0)
            return r2
        L33:
            monitor-exit(r0)
            goto L8
        L35:
            monitor-exit(r0)
            throw r4
        L37:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: J9.k.a(F9.a, J9.i, java.util.ArrayList, boolean):boolean");
    }

    public int b(okhttp3.internal.connection.a aVar, long j5) {
        byte[] bArr = G9.b.f704a;
        ArrayList arrayList = aVar.p;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                String str = "A connection to " + aVar.b.f635a.i + " was leaked. Did you forget to close a response body?";
                m.Companion.getClass();
                m.platform.logCloseableLeak(str, ((g) reference).f896a);
                arrayList.remove(i);
                aVar.f5471j = true;
                if (arrayList.isEmpty()) {
                    aVar.f5472q = j5 - this.c;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }

    public String toString() {
        switch (this.f901a) {
            case 1:
                return "UploadInfo{lastUploadTime=0, isUploading=false, commandId='" + ((String) this.d) + "', cloudMsgResponseCode=" + this.b + ", errorMsg='" + ((String) this.e) + "', operateTime=" + this.c + ", specificParams=" + ((HashMap) this.f) + '}';
            default:
                return super.toString();
        }
    }

    public k(I9.e taskRunner, int i, long j5, TimeUnit timeUnit) {
        this.f901a = 0;
        kotlin.jvm.internal.k.f(taskRunner, "taskRunner");
        kotlin.jvm.internal.k.f(timeUnit, "timeUnit");
        this.b = i;
        this.c = timeUnit.toNanos(j5);
        this.d = taskRunner.e();
        this.e = new I9.b(this, B7.a.q(new StringBuilder(), G9.b.h, " ConnectionPool"));
        this.f = new ConcurrentLinkedQueue();
        if (j5 <= 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "keepAliveDuration <= 0: ").toString());
        }
    }
}
