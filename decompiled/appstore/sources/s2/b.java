package s2;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutListener;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile b f24494f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set f24495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeedOutListener f24496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24499e;

    public class a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f24500d;

        public a(b r10, long r11, long r12) {
            this.f24500d = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r10 = System.currentTimeMillis();
            int r11 = b.a(this.f24500d);
            long r12 = ((long) b.b(this.f24500d)) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            HashMap r13 = new HashMap();
            if (r3.a.c() == false) goto L5;
            s3.a.a(n2.a.f22354a, "start weedOut:" + (r10 - (((long) r11) * 86400000)));
        L5:
            Iterator r14 = b.c(this.f24500d).iterator();
            long r15 = 0;
        L7:
            if (r14.hasNext() == false) goto L16;
            WeedOutStrategy r16 = (WeedOutStrategy) r14.next();
            s2.a r17 = new s2.a();
            r13.put(r16.getName(), r17);
            r17.g(r16.getName());
            r17.f(r16.getSize());
            if (r3.a.c() == false) goto L12;
            s3.a.a(n2.a.f22354a, "weedOut:name:" + r17.c() + " beforeSize:" + r17.b());
        L12:
            r16.doWeedOut(r10 - (((long) r11) * 86400000));
            long r18 = r16.getSize();
            r17.e(r18);
            if (r3.a.c() == false) goto L15;
            s3.a.a(n2.a.f22354a, "weedOut:name:" + r17.c() + " afterSize:" + r17.a());
        L15:
            r15 = r15 + r18;
            r14 = r14;
            r13 = r13;
            goto L7
        L16:
            HashMap r19 = r13;
            int r20 = r11 - 1;
        L18:
            if (r15 <= r12) goto L28;
            if (r20 <= 0) goto L28;
            Iterator r21 = b.c(this.f24500d).iterator();
            r15 = 0;
        L22:
            if (r21.hasNext() == false) goto L27;
            WeedOutStrategy r22 = (WeedOutStrategy) r21.next();
            r22.doWeedOut(r10 - (((long) r20) * 86400000));
            long r23 = r22.getSize();
            HashMap r24 = r19;
            s2.a r110 = (s2.a) r24.get(r22.getName());
            if (r110 == null) goto L26;
            r110.e(r23);
        L26:
            r15 = r15 + r22.getSize();
            r19 = r24;
            goto L22
        L27:
            r20 = r20 - 1;
        L28:
            HashMap r25 = r19;
            if (b.d(this.f24500d) <= 0) goto L45;
            long r26 = ((long) b.d(this.f24500d)) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            if (r15 <= r26) goto L45;
            Iterator r27 = b.c(this.f24500d).iterator();
        L34:
            if (r27.hasNext() == false) goto L45;
            WeedOutStrategy r28 = (WeedOutStrategy) r27.next();
            long r29 = r28.getSize();
            if (r29 <= 0) goto L34;
            r28.doWeedOutSize(r26);
            long r111 = r28.getSize();
            s2.a r30 = (s2.a) r25.get(r28.getName());
            if (r30 == null) goto L34;
            if (r3.a.c() == false) goto L42;
            s3.a.a(n2.a.f22354a, "weedOut:name:" + r30.c() + " afterSize:" + r111 + " maxBytesToday clean: " + (r29 - r111));
        L42:
            r30.h(true);
            r30.e(r111);
        L45:
            if (b.e(this.f24500d) == null) goto L63;
            b.e(this.f24500d).onWeedOut(new ArrayList(r25.values()));
            return;
        }
    }

    static {
        f24494f = new b();
    }

    public b() {
        this.f24495a = new HashSet();
        this.f24497c = 80;
        this.f24498d = 5;
        this.f24499e = -1;
    }

    public static /* synthetic */ int a(b r10) {
        return r10.f24498d;
    }

    public static /* synthetic */ int b(b r10) {
        return r10.f24497c;
    }

    public static /* synthetic */ Set c(b r10) {
        return r10.f24495a;
    }

    public static /* synthetic */ int d(b r10) {
        return r10.f24499e;
    }

    public static /* synthetic */ WeedOutListener e(b r10) {
        return r10.f24496b;
    }

    public static b g() {
        return f24494f;
    }

    public synchronized void f(WeedOutStrategy r10) {
        monitor-enter(this);
        if (r10 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.f24495a.add(r10);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void h() {
        if (d3.a.A() == true) goto L5;
        return;
    L5:
        u3.b.a(AsyncTaskManagerType.IO).c(new a(this, 0, 14400000));
    }

    public synchronized void i(WeedOutListener r10) {
        monitor-enter(this);
        this.f24496b = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void j(int r10, int r11, int r12) {
        if (r10 <= 0) goto L12;
        if (r11 <= 0) goto L14;
        this.f24497c = r10;
        this.f24498d = r11;
        int r13 = -1;
        if (r12 == (-1)) goto L8;
        r13 = Math.max(r12, 80);
    L8:
        this.f24499e = r13;
        if (r3.a.c() == false) goto L13;
        s3.a.a(n2.a.f22354a, "weed out config:maxSizeMB:" + r10 + " keepDays:" + r11);
        return;
    L13:
        return;
    L14:
        return;
    }
}
