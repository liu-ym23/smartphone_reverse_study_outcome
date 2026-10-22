package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.p;
import com.baidu.platform.comjni.NativeComponent;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class NABaseMap extends NativeComponent {

    /* renamed from: b, reason: collision with root package name */
    private long f9324b;

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f9323a = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f9325c = false;

    /* renamed from: d, reason: collision with root package name */
    private final ReadWriteLock f9326d = new ReentrantReadWriteLock(true);

    /* renamed from: e, reason: collision with root package name */
    private final Set<Long> f9327e = new CopyOnWriteArraySet();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f9328a;

        public a(Bundle bundle) {
            this.f9328a = bundle;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L52
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L52
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L52
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L52
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L52
                if (r0 == 0) goto L42
                android.os.Bundle r1 = r5.f9328a     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L3f
                if (r1 == 0) goto L33
                java.lang.String r2 = "itemaddr"
                r3 = 0
                long r1 = r1.getLong(r2, r3)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L3f
                com.baidu.platform.comjni.map.basemap.NABaseMap r3 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L3f
                boolean r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r3, r1)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L3f
                if (r1 == 0) goto L33
                if (r0 == 0) goto L30
                com.baidu.platform.comjni.map.basemap.NABaseMap r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r5)
            L30:
                return
            L31:
                r1 = move-exception
                goto L4a
            L33:
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L3f
                long r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r1)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L3f
                android.os.Bundle r4 = r5.f9328a     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L3f
                com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1, r2, r4)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L3f
                goto L42
            L3f:
                if (r0 == 0) goto L52
                goto L44
            L42:
                if (r0 == 0) goto L52
            L44:
                com.baidu.platform.comjni.map.basemap.NABaseMap r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r5)
                goto L52
            L4a:
                if (r0 == 0) goto L51
                com.baidu.platform.comjni.map.basemap.NABaseMap r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r5)
            L51:
                throw r1
            L52:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.a.run():void");
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f9330a;

        public b(Bundle bundle) {
            this.f9330a = bundle;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                com.baidu.platform.comjni.map.basemap.NABaseMap r0 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                boolean r0 = com.baidu.platform.comjni.map.basemap.NABaseMap.b(r0)
                if (r0 != 0) goto L9
                return
            L9:
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                if (r0 == 0) goto L2f
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                long r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                android.os.Bundle r4 = r5.f9330a     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                r1.nativeAddOneOverlayItem(r2, r4)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                goto L2f
            L2a:
                r1 = move-exception
                goto L37
            L2c:
                if (r0 == 0) goto L3f
                goto L31
            L2f:
                if (r0 == 0) goto L3f
            L31:
                com.baidu.platform.comjni.map.basemap.NABaseMap r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r5)
                goto L3f
            L37:
                if (r0 == 0) goto L3e
                com.baidu.platform.comjni.map.basemap.NABaseMap r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r5)
            L3e:
                throw r1
            L3f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.b.run():void");
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle[] f9332a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f9333b;

        public c(Bundle[] bundleArr, int i4) {
            this.f9332a = bundleArr;
            this.f9333b = i4;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r6 = this;
                com.baidu.platform.comjni.map.basemap.NABaseMap r0 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                boolean r0 = com.baidu.platform.comjni.map.basemap.NABaseMap.b(r0)
                if (r0 != 0) goto L9
                return
            L9:
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L41
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L41
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L41
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L41
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L41
                if (r0 == 0) goto L31
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
                long r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r1)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
                android.os.Bundle[] r4 = r6.f9332a     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
                int r5 = r6.f9333b     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
                r1.nativeAddOverlayItems(r2, r4, r5)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
                goto L31
            L2c:
                r1 = move-exception
                goto L39
            L2e:
                if (r0 == 0) goto L41
                goto L33
            L31:
                if (r0 == 0) goto L41
            L33:
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r6)
                goto L41
            L39:
                if (r0 == 0) goto L40
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r6)
            L40:
                throw r1
            L41:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.c.run():void");
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f9335a;

        public d(Bundle bundle) {
            this.f9335a = bundle;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                com.baidu.platform.comjni.map.basemap.NABaseMap r0 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                boolean r0 = com.baidu.platform.comjni.map.basemap.NABaseMap.b(r0)
                if (r0 != 0) goto L9
                return
            L9:
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                if (r0 == 0) goto L2f
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                long r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                android.os.Bundle r4 = r5.f9335a     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                r1.nativeUpdateOneOverlayItem(r2, r4)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                goto L2f
            L2a:
                r1 = move-exception
                goto L37
            L2c:
                if (r0 == 0) goto L3f
                goto L31
            L2f:
                if (r0 == 0) goto L3f
            L31:
                com.baidu.platform.comjni.map.basemap.NABaseMap r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r5)
                goto L3f
            L37:
                if (r0 == 0) goto L3e
                com.baidu.platform.comjni.map.basemap.NABaseMap r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r5)
            L3e:
                throw r1
            L3f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.d.run():void");
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f9337a;

        public e(Bundle bundle) {
            this.f9337a = bundle;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                com.baidu.platform.comjni.map.basemap.NABaseMap r0 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                boolean r0 = com.baidu.platform.comjni.map.basemap.NABaseMap.b(r0)
                if (r0 != 0) goto L9
                return
            L9:
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3f
                if (r0 == 0) goto L2f
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                long r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                android.os.Bundle r4 = r5.f9337a     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                r1.nativeRemoveOneOverlayItem(r2, r4)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                goto L2f
            L2a:
                r1 = move-exception
                goto L37
            L2c:
                if (r0 == 0) goto L3f
                goto L31
            L2f:
                if (r0 == 0) goto L3f
            L31:
                com.baidu.platform.comjni.map.basemap.NABaseMap r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r5)
                goto L3f
            L37:
                if (r0 == 0) goto L3e
                com.baidu.platform.comjni.map.basemap.NABaseMap r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r5)
            L3e:
                throw r1
            L3f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.e.run():void");
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle[] f9339a;

        public f(Bundle[] bundleArr) {
            this.f9339a = bundleArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                r9 = this;
                com.baidu.platform.comjni.map.basemap.NABaseMap r0 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                boolean r0 = com.baidu.platform.comjni.map.basemap.NABaseMap.b(r0)
                if (r0 != 0) goto L9
                return
            L9:
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L53
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L53
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L53
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L53
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r1 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L53
                if (r1 == 0) goto L3f
                android.os.Bundle[] r2 = r9.f9339a     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
                int r3 = r2.length     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            L21:
                if (r0 >= r3) goto L3f
                r4 = r2[r0]     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
                com.baidu.platform.comjni.map.basemap.NABaseMap r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
                boolean r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.c(r5)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
                if (r5 == 0) goto L2e
                goto L3f
            L2e:
                com.baidu.platform.comjni.map.basemap.NABaseMap r5 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
                long r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r5)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
                r5.nativeRemoveOneOverlayItem(r6, r4)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
                int r0 = r0 + 1
                goto L21
            L3a:
                r0 = move-exception
                goto L4b
            L3c:
                if (r1 == 0) goto L53
                goto L41
            L3f:
                if (r1 == 0) goto L53
            L41:
                com.baidu.platform.comjni.map.basemap.NABaseMap r9 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r9)
                goto L53
            L47:
                r1 = move-exception
                r8 = r1
                r1 = r0
                r0 = r8
            L4b:
                if (r1 == 0) goto L52
                com.baidu.platform.comjni.map.basemap.NABaseMap r9 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r9)
            L52:
                throw r0
            L53:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.f.run():void");
        }
    }

    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9341a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f9342b;

        public g(long j4, boolean z4) {
            this.f9341a = j4;
            this.f9342b = z4;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r8 = this;
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L42
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L42
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L42
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L42
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L42
                if (r0 == 0) goto L32
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                long r2 = r8.f9341a     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                boolean r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1, r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                if (r1 != 0) goto L32
                com.baidu.platform.comjni.map.basemap.NABaseMap r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                long r3 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                long r5 = r8.f9341a     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                boolean r7 = r8.f9342b     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                com.baidu.platform.comjni.map.basemap.NABaseMap.a(r2, r3, r5, r7)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                goto L32
            L2d:
                r1 = move-exception
                goto L3a
            L2f:
                if (r0 == 0) goto L42
                goto L34
            L32:
                if (r0 == 0) goto L42
            L34:
                com.baidu.platform.comjni.map.basemap.NABaseMap r8 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r8)
                goto L42
            L3a:
                if (r0 == 0) goto L41
                com.baidu.platform.comjni.map.basemap.NABaseMap r8 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r8)
            L41:
                throw r1
            L42:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.g.run():void");
        }
    }

    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9344a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f9345b;

        public h(long j4, boolean z4) {
            this.f9344a = j4;
            this.f9345b = z4;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r8 = this;
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L42
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L42
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L42
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L42
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L42
                if (r0 == 0) goto L32
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                long r2 = r8.f9344a     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                boolean r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1, r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                if (r1 != 0) goto L32
                com.baidu.platform.comjni.map.basemap.NABaseMap r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                long r3 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                long r5 = r8.f9344a     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                boolean r7 = r8.f9345b     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                com.baidu.platform.comjni.map.basemap.NABaseMap.b(r2, r3, r5, r7)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                goto L32
            L2d:
                r1 = move-exception
                goto L3a
            L2f:
                if (r0 == 0) goto L42
                goto L34
            L32:
                if (r0 == 0) goto L42
            L34:
                com.baidu.platform.comjni.map.basemap.NABaseMap r8 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r8)
                goto L42
            L3a:
                if (r0 == 0) goto L41
                com.baidu.platform.comjni.map.basemap.NABaseMap r8 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r8)
            L41:
                throw r1
            L42:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.h.run():void");
        }
    }

    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9347a;

        public i(long j4) {
            this.f9347a = j4;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                if (r0 == 0) goto L30
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                long r2 = r6.f9347a     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                boolean r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1, r2)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                if (r1 != 0) goto L30
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                long r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r1)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                long r4 = r6.f9347a     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                com.baidu.platform.comjni.map.basemap.NABaseMap.b(r1, r2, r4)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                goto L30
            L2b:
                r1 = move-exception
                goto L38
            L2d:
                if (r0 == 0) goto L40
                goto L32
            L30:
                if (r0 == 0) goto L40
            L32:
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r6)
                goto L40
            L38:
                if (r0 == 0) goto L3f
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r6)
            L3f:
                throw r1
            L40:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.i.run():void");
        }
    }

    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9349a;

        public j(long j4) {
            this.f9349a = j4;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L55
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L55
                java.util.concurrent.locks.Lock r1 = r1.writeLock()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L55
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L55
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L55
                if (r0 == 0) goto L35
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
                java.util.Set r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.e(r1)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
                long r2 = r6.f9349a     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
                r1.add(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
                long r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r1)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
                long r4 = r6.f9349a     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
                com.baidu.platform.comjni.map.basemap.NABaseMap.c(r1, r2, r4)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
                goto L35
            L30:
                r1 = move-exception
                goto L45
            L32:
                if (r0 == 0) goto L55
                goto L37
            L35:
                if (r0 == 0) goto L55
            L37:
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                java.util.concurrent.locks.ReadWriteLock r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r6)
                java.util.concurrent.locks.Lock r6 = r6.writeLock()
                r6.unlock()
                goto L55
            L45:
                if (r0 == 0) goto L54
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                java.util.concurrent.locks.ReadWriteLock r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r6)
                java.util.concurrent.locks.Lock r6 = r6.writeLock()
                r6.unlock()
            L54:
                throw r1
            L55:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.j.run():void");
        }
    }

    public class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9351a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f9352b;

        public k(long j4, long j5) {
            this.f9351a = j4;
            this.f9352b = j5;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r9 = this;
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L4c
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L4c
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L4c
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L4c
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L4c
                if (r0 == 0) goto L3c
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                long r2 = r9.f9351a     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                boolean r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1, r2)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                if (r1 != 0) goto L3c
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                long r2 = r9.f9352b     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                boolean r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1, r2)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                if (r1 != 0) goto L3c
                com.baidu.platform.comjni.map.basemap.NABaseMap r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                long r3 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r2)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                long r5 = r9.f9351a     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                long r7 = r9.f9352b     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                com.baidu.platform.comjni.map.basemap.NABaseMap.a(r2, r3, r5, r7)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                goto L3c
            L37:
                r1 = move-exception
                goto L44
            L39:
                if (r0 == 0) goto L4c
                goto L3e
            L3c:
                if (r0 == 0) goto L4c
            L3e:
                com.baidu.platform.comjni.map.basemap.NABaseMap r9 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r9)
                goto L4c
            L44:
                if (r0 == 0) goto L4b
                com.baidu.platform.comjni.map.basemap.NABaseMap r9 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r9)
            L4b:
                throw r1
            L4c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.k.run():void");
        }
    }

    public class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9354a;

        public l(long j4) {
            this.f9354a = j4;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                if (r0 == 0) goto L30
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                long r2 = r6.f9354a     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                boolean r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1, r2)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                if (r1 != 0) goto L30
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                long r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r1)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                long r4 = r6.f9354a     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                com.baidu.platform.comjni.map.basemap.NABaseMap.d(r1, r2, r4)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                goto L30
            L2b:
                r1 = move-exception
                goto L38
            L2d:
                if (r0 == 0) goto L40
                goto L32
            L30:
                if (r0 == 0) goto L40
            L32:
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r6)
                goto L40
            L38:
                if (r0 == 0) goto L3f
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r6)
            L3f:
                throw r1
            L40:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.l.run():void");
        }
    }

    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9356a;

        public m(long j4) {
            this.f9356a = j4;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L40
                if (r0 == 0) goto L30
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                long r2 = r6.f9356a     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                boolean r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1, r2)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                if (r1 != 0) goto L30
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                long r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r1)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                long r4 = r6.f9356a     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1, r2, r4)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                goto L30
            L2b:
                r1 = move-exception
                goto L38
            L2d:
                if (r0 == 0) goto L40
                goto L32
            L30:
                if (r0 == 0) goto L40
            L32:
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r6)
                goto L40
            L38:
                if (r0 == 0) goto L3f
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r6)
            L3f:
                throw r1
            L40:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.m.run():void");
        }
    }

    public class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f9358a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f9359b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f9360c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f9361d;

        public n(long j4, long j5, boolean z4, Bundle bundle) {
            this.f9358a = j4;
            this.f9359b = j5;
            this.f9360c = z4;
            this.f9361d = bundle;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r11 = this;
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L46
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L46
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L46
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L46
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L46
                if (r0 == 0) goto L36
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                long r2 = r11.f9358a     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                boolean r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1, r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                if (r1 != 0) goto L36
                com.baidu.platform.comjni.map.basemap.NABaseMap r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                long r3 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                long r5 = r11.f9358a     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                long r7 = r11.f9359b     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                boolean r9 = r11.f9360c     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                android.os.Bundle r10 = r11.f9361d     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                com.baidu.platform.comjni.map.basemap.NABaseMap.a(r2, r3, r5, r7, r9, r10)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                goto L36
            L31:
                r1 = move-exception
                goto L3e
            L33:
                if (r0 == 0) goto L46
                goto L38
            L36:
                if (r0 == 0) goto L46
            L38:
                com.baidu.platform.comjni.map.basemap.NABaseMap r11 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r11)
                goto L46
            L3e:
                if (r0 == 0) goto L45
                com.baidu.platform.comjni.map.basemap.NABaseMap r11 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r11)
            L45:
                throw r1
            L46:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.n.run():void");
        }
    }

    public class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f9363a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f9364b;

        public o(Bundle bundle, boolean z4) {
            this.f9363a = bundle;
            this.f9364b = z4;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L54
                java.util.concurrent.locks.ReadWriteLock r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L54
                java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L54
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L54
                r3 = 2000(0x7d0, double:9.88E-321)
                boolean r0 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L54
                if (r0 == 0) goto L44
                android.os.Bundle r1 = r6.f9363a     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L41
                if (r1 == 0) goto L33
                java.lang.String r2 = "itemaddr"
                r3 = 0
                long r1 = r1.getLong(r2, r3)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L41
                com.baidu.platform.comjni.map.basemap.NABaseMap r3 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L41
                boolean r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.a(r3, r1)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L41
                if (r1 == 0) goto L33
                if (r0 == 0) goto L30
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r6)
            L30:
                return
            L31:
                r1 = move-exception
                goto L4c
            L33:
                com.baidu.platform.comjni.map.basemap.NABaseMap r1 = com.baidu.platform.comjni.map.basemap.NABaseMap.this     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L41
                long r2 = com.baidu.platform.comjni.map.basemap.NABaseMap.d(r1)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L41
                android.os.Bundle r4 = r6.f9363a     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L41
                boolean r5 = r6.f9364b     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L41
                com.baidu.platform.comjni.map.basemap.NABaseMap.a(r1, r2, r4, r5)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L41
                goto L44
            L41:
                if (r0 == 0) goto L54
                goto L46
            L44:
                if (r0 == 0) goto L54
            L46:
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r6)
                goto L54
            L4c:
                if (r0 == 0) goto L53
                com.baidu.platform.comjni.map.basemap.NABaseMap r6 = com.baidu.platform.comjni.map.basemap.NABaseMap.this
                androidx.room.AbstractC0351g.z(r6)
            L53:
                throw r1
            L54:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.basemap.NABaseMap.o.run():void");
        }
    }

    private native void nativSetAuto3DEnter3DByZoomIn(long j4, boolean z4);

    private native void nativeAdd3DModelIDForFilterList(long j4, String str);

    private native boolean nativeAddBmLayerBelow(long j4, long j5, long j6, int i4, int i5);

    private native void nativeAddHexagonMapData(long j4, long j5, Bundle bundle);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeAddItemData(long j4, Bundle bundle, boolean z4);

    private native long nativeAddLayer(long j4, int i4, int i5, String str);

    private native void nativeAddPopupData(long j4, Bundle bundle);

    private native void nativeAddRtPopData(long j4, Bundle bundle);

    private native void nativeAddStreetCustomMarker(long j4, Bundle bundle, Bitmap bitmap);

    private native void nativeAttachDC(long j4, long j5);

    private native boolean nativeBeginLocationLayerAnimation(long j4);

    private native void nativeCancelPreload(long j4, int i4);

    private native boolean nativeCleanCache(long j4, int i4, boolean z4);

    private native void nativeClearFullscreenMaskColor(long j4);

    private native void nativeClearHeatMapLayerCache(long j4, long j5);

    private native void nativeClearHexagonLayerCache(long j4, long j5);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeClearLayer(long j4, long j5);

    private native void nativeClearLocationLayerData(long j4, Bundle bundle);

    private native void nativeClearMistmapLayer(long j4);

    private native void nativeClearParticleSystemMemory(long j4);

    private native void nativeClearUniversalLayer(long j4);

    private native boolean nativeCloseCache(long j4);

    private native void nativeCloseParticleEffect(long j4, String str);

    private native void nativeCloseParticleEffectByType(long j4, int i4);

    private native long nativeCreate();

    private native long nativeCreateDuplicate(long j4);

    private native boolean nativeCustomParticleEffectByType(long j4, int i4, Bundle bundle);

    private native boolean nativeDownloadMapStyle(long j4, String str);

    private native int nativeDraw(long j4);

    private native void nativeEnablePOIAnimation(long j4, boolean z4);

    private native void nativeEntrySearchTopic(long j4, int i4, String str, String str2);

    private native void nativeExitSearchTopic(long j4);

    private native void nativeFocusTrafficUGCLabel(long j4);

    private native String nativeGeoPt3ToScrPoint(long j4, int i4, int i5, int i6);

    private native String nativeGeoPtToScrPoint(long j4, int i4, int i5);

    private static native boolean nativeGet3DModelEnable(long j4);

    private native float nativeGetAdapterZoomUnitsEx(long j4);

    private native Bundle nativeGetBaseRoadData(long j4);

    private native int nativeGetCacheSize(long j4, int i4);

    private native boolean nativeGetCityInfoByBound(long j4, Bundle bundle);

    private native String nativeGetCityInfoByID(long j4, int i4);

    private native String nativeGetCurDrawPoiInfo(long j4, int i4);

    private native boolean nativeGetCustomTrafficColorEnable(long j4);

    private static native boolean nativeGetDEMEnable(long j4);

    private native float nativeGetDpiScale(long j4);

    private static native boolean nativeGetDrawHouseHeightEnable(long j4);

    private native Bundle nativeGetDrawingMapStatus(long j4);

    private native float nativeGetFZoomToBoundF(long j4, Bundle bundle, Bundle bundle2);

    private native String nativeGetFocusedBaseIndoorMapInfo(long j4);

    private native int nativeGetFontSizeLevel(long j4);

    private static native int nativeGetHouseSmoothLevel(long j4);

    private native int nativeGetIndoorMapShowMode(long j4, String str);

    private static native long nativeGetLayerIDByTag(long j4, String str);

    private native int nativeGetLayerPos(long j4, long j5);

    private native boolean nativeGetMapBarData(long j4, Bundle bundle);

    private native int nativeGetMapLanguage(long j4);

    private native int nativeGetMapRenderType(long j4);

    private native int nativeGetMapScene(long j4);

    private native int nativeGetMapSceneAttr(long j4);

    private native Bundle nativeGetMapStatus(long j4, boolean z4);

    private static native Bundle nativeGetMapStatusLimits(long j4);

    private native boolean nativeGetMapStatusLimitsLevel(long j4, int[] iArr);

    private native int nativeGetMapTheme(long j4);

    private native String nativeGetNearlyObjID(long j4, long j5, int i4, int i5, int i6);

    private native String nativeGetPoiMarkData(long j4, int i4, int i5, int i6, int i7, boolean z4);

    private static native boolean nativeGetPoiTagEnable(long j4, int i4);

    private static native void nativeGetProjectionMatrix(long j4, float[] fArr);

    private native String nativeGetProjectionPt(long j4, String str);

    private native int nativeGetScaleLevel(long j4, int i4, int i5);

    private native int nativeGetSkyOffset(long j4);

    private static native int nativeGetSkyboxStyle(long j4);

    private native String nativeGetStreetRoadNearPointFromCenter(long j4, double d4, double d5, int i4);

    private native int nativeGetVMPMapCityInfo(long j4, Bundle bundle);

    private static native void nativeGetViewMatrix(long j4, float[] fArr);

    private native boolean nativeGetVirtualPoiShowEnable(long j4);

    private native float nativeGetZoomToBound(long j4, Bundle bundle, int i4, int i5);

    private native float nativeGetZoomToBoundF(long j4, Bundle bundle);

    private native boolean nativeImportMapTheme(long j4, int i4);

    private native boolean nativeInit(long j4, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z4, boolean z5);

    private native boolean nativeInitCustomStyle(long j4, String str, String str2);

    private native void nativeInitHeatMapData(long j4, long j5, Bundle bundle);

    private native int nativeInitLayerCallback(long j4);

    private native boolean nativeInitWithBundle(long j4, Bundle bundle, boolean z4);

    private native long nativeInsertLayerAt(long j4, int i4, int i5, int i6, String str);

    private native void nativeInterruptDraw(long j4, boolean z4);

    private native boolean nativeIsAnimationRunning(long j4);

    private native boolean nativeIsBaseIndoorMapMode(long j4);

    private native boolean nativeIsBaseIndoorMapShow(long j4);

    private native boolean nativeIsEnableIndoor3D(long j4);

    private native boolean nativeIsNaviMode(long j4);

    private native boolean nativeIsPointInFocusBarBorder(long j4, double d4, double d5, double d6);

    private native boolean nativeIsPointInFocusIDRBorder(long j4, double d4, double d5);

    private native boolean nativeIsStreetArrowShown(long j4);

    private native boolean nativeIsStreetCustomMarkerShown(long j4);

    private native boolean nativeIsStreetPOIMarkerShown(long j4);

    private native boolean nativeIsStreetRoadClickable(long j4);

    private native boolean nativeIsSupBackgroundDraw(long j4);

    private native boolean nativeLayersIsShow(long j4, long j5);

    private native boolean nativeMoveLayerBelow(long j4, long j5, String str);

    private native boolean nativeMoveLayerBelowTo(long j4, long j5, int i4);

    private native void nativeMoveToScrPoint(long j4, int i4, int i5);

    private native void nativeNewSetMapStatus(long j4, Bundle bundle);

    private native void nativeOnBackground(long j4);

    private native void nativeOnForeground(long j4);

    private native void nativeOnGestureFinish(long j4);

    private native void nativeOnGestureStart(long j4);

    private native String nativeOnHotcityGet(long j4);

    private native void nativeOnPause(long j4);

    private native boolean nativeOnRecordAdd(long j4, int i4);

    private native String nativeOnRecordGetAll(long j4);

    private native String nativeOnRecordGetAt(long j4, int i4);

    private native boolean nativeOnRecordImport(long j4, boolean z4, boolean z5);

    private native boolean nativeOnRecordReload(long j4, int i4, boolean z4);

    private native boolean nativeOnRecordRemove(long j4, int i4, boolean z4);

    private native boolean nativeOnRecordStart(long j4, int i4, boolean z4, int i5);

    private native boolean nativeOnRecordSuspend(long j4, int i4, boolean z4, int i5);

    private native void nativeOnResume(long j4);

    private native String nativeOnSchcityGet(long j4, String str);

    private native boolean nativeOnUsrcityMsgInterval(long j4, int i4);

    private native int nativeOnWifiRecordAdd(long j4, int i4);

    private native boolean nativePerformAction(long j4, String str);

    private native void nativePreLoadParticleFile(long j4, String str);

    private native boolean nativePreload(long j4, Bundle bundle, int i4);

    private native int nativeQueryInterface(long j4);

    private native byte[] nativeReadMapResData(long j4, String str);

    private native void nativeRecycleMemory(long j4, int i4);

    private native int nativeRelease(long j4);

    private native void nativeRemove3DModelIDForFilterList(long j4, String str);

    private native boolean nativeRemoveBmLayer(long j4, long j5);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeRemoveItemData(long j4, Bundle bundle);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeRemoveLayer(long j4, long j5);

    private native void nativeRemoveStreetAllCustomMarker(long j4);

    private native void nativeRemoveStreetCustomMaker(long j4, String str);

    private static native void nativeRenderClearShaderCache(String str);

    private static native void nativeRenderInit(long j4, int i4, int i5, Surface surface, int i6);

    private native void nativeRenderResize(long j4, int i4, int i5);

    private native void nativeResetImageRes(long j4);

    private native boolean nativeResumeCache(long j4);

    private native boolean nativeSaveCache(long j4);

    private native void nativeSaveScreenToLocal(long j4, String str, String str2);

    private native String nativeScr2GeoInGesture(long j4, int i4, int i5);

    private native String nativeScrPtToGeoPoint(long j4, int i4, int i5);

    private static native void nativeSet3DModelEnable(long j4, boolean z4);

    private native void nativeSetAllStreetCustomMarkerVisibility(long j4, boolean z4);

    private native void nativeSetBackgroundColor(long j4, int i4);

    private native void nativeSetCustomStyleEnable(long j4, boolean z4);

    private native void nativeSetCustomTrafficColor(long j4, int i4, int i5, int i6, int i7);

    private native void nativeSetCustomTrafficColorEnable(long j4, boolean z4);

    private native void nativeSetCustomVMPDataRoot(long j4, String str);

    private static native void nativeSetDEMEnable(long j4, boolean z4);

    private native void nativeSetDpiScale(long j4, float f4);

    private static native void nativeSetDrawHouseHeightEnable(long j4, boolean z4);

    private native void nativeSetEnableIndoor3D(long j4, boolean z4);

    private native void nativeSetFeatureConfig(long j4, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native String nativeSetFocus(long j4, long j5, long j6, boolean z4, Bundle bundle);

    private native void nativeSetFontSizeLevel(long j4, int i4);

    private native void nativeSetFullscreenMaskColor(long j4, int i4);

    private native void nativeSetGlobalLightEnable(long j4, boolean z4);

    private native void nativeSetHeatMapFrameAnimationIndex(long j4, long j5, int i4);

    private static native void nativeSetHouseSmoothLevel(long j4, int i4);

    private native void nativeSetIndoorMapShowMode(long j4, String str, int i4);

    private native boolean nativeSetItsPreTime(long j4, int i4, int i5, int i6);

    private native boolean nativeSetLayerSceneMode(long j4, long j5, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetLayersClickable(long j4, long j5, boolean z4);

    private static native void nativeSetLittle3DEnable(long j4, boolean z4);

    private native void nativeSetLocationLayerData(long j4, Bundle bundle);

    private native void nativeSetMapBackgroundImage(long j4, Bundle bundle);

    private native int nativeSetMapControlMode(long j4, int i4);

    private native void nativeSetMapLanguage(long j4, int i4, boolean z4);

    private native boolean nativeSetMapScene(long j4, int i4);

    private native boolean nativeSetMapSceneAttr(long j4, int i4);

    private native void nativeSetMapStatus(long j4, Bundle bundle);

    private static native void nativeSetMapStatusLimits(long j4, Bundle bundle);

    private native boolean nativeSetMapStatusLimitsLevel(long j4, int i4, int i5);

    private native boolean nativeSetMapTheme(long j4, int i4, Bundle bundle);

    private native boolean nativeSetMapThemeScene(long j4, int i4, int i5, Bundle bundle);

    private static native void nativeSetMaxAndMinZoomLevel(long j4, Bundle bundle);

    private native void nativeSetPoiTagEnable(long j4, int i4, boolean z4);

    private native void nativeSetRecommendPOIScene(long j4, int i4);

    private static native void nativeSetSkyboxStyle(long j4, int i4);

    private native void nativeSetStreetArrowShow(long j4, boolean z4);

    private static native void nativeSetStreetLayerNewDesignFlag(long j4, boolean z4);

    private native void nativeSetStreetMarkerClickable(long j4, String str, boolean z4);

    private native void nativeSetStreetRoadClickable(long j4, boolean z4);

    private native void nativeSetStyleMode(long j4, int i4);

    private native void nativeSetSupBackgroundDraw(long j4, boolean z4);

    private native void nativeSetTargetStreetCustomMarkerVisibility(long j4, boolean z4, String str);

    private native boolean nativeSetTestSwitch(long j4, boolean z4);

    private native void nativeSetTrafficUGCData(long j4, String str);

    private native void nativeSetUniversalFilter(long j4, String str);

    private native void nativeSetUseCustomVMP(long j4, boolean z4);

    private native void nativeSetVirtualPoiShowEnable(long j4, boolean z4);

    private native void nativeShowBaseIndoorMap(long j4, boolean z4);

    private native void nativeShowFootMarkGrid(long j4, boolean z4, String str);

    private native void nativeShowHotMap(long j4, boolean z4, int i4);

    private native void nativeShowHotMapWithUid(long j4, boolean z4, int i4, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeShowLayers(long j4, long j5, boolean z4);

    private native void nativeShowMistMap(long j4, boolean z4, String str);

    private native void nativeShowOperatorDataByType(long j4, boolean z4, int i4);

    private native boolean nativeShowParticleEffect(long j4, int i4);

    private native boolean nativeShowParticleEffectByFileName(long j4, String str);

    private native boolean nativeShowParticleEffectByFilenameAndPos(long j4, String str, float f4, float f5, float f6);

    private native boolean nativeShowParticleEffectByName(long j4, String str, boolean z4);

    private native boolean nativeShowParticleEffectByType(long j4, int i4);

    private native boolean nativeShowParticleEffectByTypeAndPos(long j4, int i4, float f4, float f5, float f6);

    private native boolean nativeShowParticleEffectByTypeAndStyleID(long j4, int i4, int i5);

    private native void nativeShowSatelliteMap(long j4, boolean z4);

    private native void nativeShowStreetPOIMarker(long j4, boolean z4);

    private native void nativeShowStreetPopup(long j4, boolean z4);

    private native void nativeShowStreetRoadMap(long j4, boolean z4);

    private native void nativeShowTopicPOI(long j4, String str, boolean z4, String str2, boolean z5);

    private native void nativeShowTrafficMap(long j4, boolean z4);

    private native void nativeShowTrafficUGCMap(long j4, boolean z4);

    private native void nativeShowUniversalLayer(long j4, Bundle bundle);

    private native void nativeStartHeatMapFrameAnimation(long j4, long j5);

    private native void nativeStartIndoorAnimation(long j4);

    private native void nativeStopHeatMapFrameAnimation(long j4, long j5);

    private native void nativeSurfaceDestroyed(long j4, Surface surface);

    private native boolean nativeSwitchBaseIndoorMapFloor(long j4, String str, String str2);

    private native void nativeSwitchDayOrDarkTheme(long j4, int i4, boolean z4);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeSwitchLayer(long j4, long j5, long j6);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSyncClearLayer(long j4, long j5);

    private native void nativeUnFocusTrafficUGCLabel(long j4);

    private native void nativeUpdateBaseLayers(long j4);

    private native void nativeUpdateDrawFPS(long j4);

    private native void nativeUpdateFootMarkGrid(long j4);

    private native void nativeUpdateHeatMapData(long j4, long j5, Bundle bundle);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeUpdateLayers(long j4, long j5);

    private native String nativeworldPointToScreenPoint(long j4, float f4, float f5, float f6);

    public static void renderClearShaderCache(String str) {
        nativeRenderClearShaderCache(str);
    }

    public String Scr2GeoInGesture(int i4, int i5) {
        long j4 = this.f9324b;
        return j4 != 0 ? nativeScr2GeoInGesture(j4, i4, i5) : "";
    }

    public void add3DModelIDForFilterList(String str) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeAdd3DModelIDForFilterList(j4, str);
        }
    }

    public boolean addBmLayerBelow(long j4, long j5, int i4, int i5) {
        return nativeAddBmLayerBelow(this.f9324b, j4, j5, i4, i5);
    }

    public void addHexagonMapData(long j4, Bundle bundle) {
        long j5 = this.f9324b;
        if (j5 != 0) {
            nativeAddHexagonMapData(j5, j4, bundle);
        }
    }

    public void addItemData(Bundle bundle, boolean z4) {
        if (a()) {
            this.f9323a.submit(new o(bundle, z4));
        }
    }

    public long addLayer(int i4, int i5, String str) {
        long jNativeAddLayer = nativeAddLayer(this.f9324b, i4, i5, str);
        this.f9327e.remove(Long.valueOf(jNativeAddLayer));
        return jNativeAddLayer;
    }

    public void addOneOverlayItem(Bundle bundle) {
        if (a()) {
            this.f9323a.submit(new b(bundle));
        }
    }

    public void addOverlayItems(Bundle[] bundleArr, int i4) {
        if (a()) {
            this.f9323a.submit(new c(bundleArr, i4));
        }
    }

    public void addPopupData(Bundle bundle) {
        nativeAddPopupData(this.f9324b, bundle);
    }

    public void addRtPopData(Bundle bundle) {
        nativeAddRtPopData(this.f9324b, bundle);
    }

    public void addStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeAddStreetCustomMarker(j4, bundle, bitmap);
        }
    }

    public void beginLocationLayerAnimation() {
        nativeBeginLocationLayerAnimation(this.f9324b);
    }

    public void cancelPreload(int i4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeCancelPreload(j4, i4);
        }
    }

    public boolean cleanCache(int i4, boolean z4) {
        return nativeCleanCache(this.f9324b, i4, z4);
    }

    public void clearFullscreenMaskColor() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeClearFullscreenMaskColor(j4);
        }
    }

    public void clearHeatMapLayerCache(long j4) {
        long j5 = this.f9324b;
        if (j5 != 0) {
            nativeClearHeatMapLayerCache(j5, j4);
        }
    }

    public void clearHexagonLayerCache(long j4) {
        long j5 = this.f9324b;
        if (j5 != 0) {
            nativeClearHexagonLayerCache(j5, j4);
        }
    }

    public void clearLayer(long j4) {
        if (a()) {
            this.f9323a.submit(new m(j4));
        }
    }

    public void clearLocationLayerData(Bundle bundle) {
        nativeClearLocationLayerData(this.f9324b, bundle);
    }

    public void clearMistmapLayer() {
        nativeClearMistmapLayer(this.f9324b);
    }

    public void clearParticleSystemMemory() {
        nativeClearParticleSystemMemory(this.f9324b);
    }

    public void clearSDKLayer(long j4) {
        if (a()) {
            this.f9323a.submit(new l(j4));
        }
    }

    public void clearUniversalLayer() {
        nativeClearUniversalLayer(this.f9324b);
    }

    public boolean closeCache() {
        return nativeCloseCache(this.f9324b);
    }

    public void closeParticleEffect(String str) {
        nativeCloseParticleEffect(this.f9324b, str);
    }

    public void closeParticleEffectByType(int i4) {
        nativeCloseParticleEffectByType(this.f9324b, i4);
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        long jNativeCreate = nativeCreate();
        this.f9324b = jNativeCreate;
        nativeInitLayerCallback(jNativeCreate);
        return this.f9324b;
    }

    public long createByDuplicate(long j4) {
        long jNativeCreateDuplicate = nativeCreateDuplicate(j4);
        this.f9324b = jNativeCreateDuplicate;
        if (jNativeCreateDuplicate != 0) {
            nativeInitLayerCallback(jNativeCreateDuplicate);
        }
        return this.f9324b;
    }

    public long createDuplicate() {
        return nativeCreateDuplicate(this.f9324b);
    }

    public boolean customParticleEffectByType(int i4, Bundle bundle) {
        return nativeCustomParticleEffectByType(this.f9324b, i4, bundle);
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() throws InterruptedException {
        if (this.f9324b == 0) {
            return 0;
        }
        this.f9325c = true;
        b();
        int iNativeRelease = nativeRelease(this.f9324b);
        this.f9324b = 0L;
        return iNativeRelease;
    }

    public boolean downloadMapStyle(String str) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeDownloadMapStyle(j4, str);
        }
        return false;
    }

    public int draw() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeDraw(j4);
        }
        return 0;
    }

    public void enablePOIAnimation(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeEnablePOIAnimation(j4, z4);
        }
    }

    public void entrySearchTopic(int i4, String str, String str2) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeEntrySearchTopic(j4, i4, str, str2);
        }
    }

    public void exitSearchTopic() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeExitSearchTopic(j4);
        }
    }

    public void focusTrafficUGCLabel() {
        nativeFocusTrafficUGCLabel(this.f9324b);
    }

    public String geoPt3ToScrPoint(int i4, int i5, int i6) {
        return nativeGeoPt3ToScrPoint(this.f9324b, i4, i5, i6);
    }

    public String geoPtToScrPoint(int i4, int i5) {
        return nativeGeoPtToScrPoint(this.f9324b, i4, i5);
    }

    public boolean get3DModelEnable() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGet3DModelEnable(j4);
        }
        return false;
    }

    public float getAdapterZoomUnitsEx() {
        return nativeGetAdapterZoomUnitsEx(this.f9324b);
    }

    public Bundle getBaseRoadData() {
        long j4 = this.f9324b;
        if (j4 == 0) {
            return null;
        }
        return nativeGetBaseRoadData(j4);
    }

    public int getCacheSize(int i4) {
        return nativeGetCacheSize(this.f9324b, i4);
    }

    public boolean getCityInfoByBound(Bundle bundle) {
        return nativeGetCityInfoByBound(this.f9324b, bundle);
    }

    public String getCityInfoByID(int i4) {
        return nativeGetCityInfoByID(this.f9324b, i4);
    }

    public String getCurDrawPoiInfo(int i4) {
        long j4 = this.f9324b;
        return j4 != 0 ? nativeGetCurDrawPoiInfo(j4, i4) : "";
    }

    public boolean getCustomTrafficColorEnable() {
        long j4 = this.f9324b;
        if (0 == j4) {
            return false;
        }
        return nativeGetCustomTrafficColorEnable(j4);
    }

    public boolean getDEMEnable() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetDEMEnable(j4);
        }
        return false;
    }

    public float getDpiScale() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetDpiScale(j4);
        }
        return 1.0f;
    }

    public boolean getDrawHouseHeightEnable() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetDrawHouseHeightEnable(j4);
        }
        return false;
    }

    public Bundle getDrawingMapStatus() {
        return nativeGetDrawingMapStatus(this.f9324b);
    }

    public float getFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        return nativeGetFZoomToBoundF(this.f9324b, bundle, bundle2);
    }

    public String getFocusedBaseIndoorMapInfo() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetFocusedBaseIndoorMapInfo(j4);
        }
        return null;
    }

    public int getFontSizeLevel() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetFontSizeLevel(j4);
        }
        return 1;
    }

    public int getHouseSmoothLevel() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetHouseSmoothLevel(j4);
        }
        return -1;
    }

    public int getIndoorMapShowMode(String str) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetIndoorMapShowMode(j4, str);
        }
        return 0;
    }

    public long getLayerIDByTag(String str) {
        if (this.f9324b == 0 || TextUtils.isEmpty(str)) {
            return 0L;
        }
        return nativeGetLayerIDByTag(this.f9324b, str);
    }

    public boolean getMapBarData(Bundle bundle) {
        return nativeGetMapBarData(this.f9324b, bundle);
    }

    public int getMapLanguage() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetMapLanguage(j4);
        }
        return 0;
    }

    public int getMapRenderType() {
        return nativeGetMapRenderType(this.f9324b);
    }

    public int getMapScene() {
        return nativeGetMapScene(this.f9324b);
    }

    public int getMapSceneAttr() {
        return nativeGetMapSceneAttr(this.f9324b);
    }

    public Bundle getMapStatus(boolean z4) {
        return nativeGetMapStatus(this.f9324b, z4);
    }

    public Bundle getMapStatusLimits() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetMapStatusLimits(j4);
        }
        return null;
    }

    public boolean getMapStatusLimitsLevel(int[] iArr) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetMapStatusLimitsLevel(j4, iArr);
        }
        return false;
    }

    public int getMapTheme() {
        return nativeGetMapTheme(this.f9324b);
    }

    public long getNativeMapPointer() {
        return this.f9324b;
    }

    public String getNearlyObjID(long j4, int i4, int i5, int i6) {
        boolean zTryLock = false;
        try {
            zTryLock = this.f9326d.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
            if (!zTryLock) {
                if (zTryLock) {
                    this.f9326d.readLock().unlock();
                }
                return "";
            }
            if (a(j4)) {
                if (zTryLock) {
                    this.f9326d.readLock().unlock();
                }
                return "";
            }
            String strNativeGetNearlyObjID = nativeGetNearlyObjID(this.f9324b, j4, i4, i5, i6);
            if (zTryLock) {
                this.f9326d.readLock().unlock();
            }
            return strNativeGetNearlyObjID;
        } catch (Exception unused) {
            if (zTryLock) {
                this.f9326d.readLock().unlock();
            }
            return "";
        } catch (Throwable th) {
            if (zTryLock) {
                this.f9326d.readLock().unlock();
            }
            throw th;
        }
    }

    public String getPoiMarkData(int i4, int i5, int i6, int i7, boolean z4) {
        return nativeGetPoiMarkData(this.f9324b, i4, i5, i6, i7, z4);
    }

    public boolean getPoiTagEnable(int i4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetPoiTagEnable(j4, i4);
        }
        return false;
    }

    public void getProjectMatrix(float[] fArr) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeGetProjectionMatrix(j4, fArr);
        }
    }

    public String getProjectionPt(String str) {
        return nativeGetProjectionPt(this.f9324b, str);
    }

    public int getScaleLevel(int i4, int i5) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetScaleLevel(j4, i4, i5);
        }
        return -1;
    }

    public int getSkyOffset() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetSkyOffset(j4);
        }
        return 0;
    }

    public int getSkyboxStyle() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeGetSkyboxStyle(j4);
        }
        return 0;
    }

    public String getStreetRoadNearPointFromCenter(double d4, double d5, int i4) {
        return nativeGetStreetRoadNearPointFromCenter(this.f9324b, d4, d5, i4);
    }

    public int getVMPMapCityInfo(Bundle bundle) {
        return nativeGetVMPMapCityInfo(this.f9324b, bundle);
    }

    public void getViewMatrix(float[] fArr) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeGetViewMatrix(j4, fArr);
        }
    }

    public boolean getVirtualPoiShowEnable() {
        return nativeGetVirtualPoiShowEnable(this.f9324b);
    }

    public float getZoomToBound(Bundle bundle, int i4, int i5) {
        return nativeGetZoomToBound(this.f9324b, bundle, i4, i5);
    }

    public float getZoomToBoundF(Bundle bundle) {
        return nativeGetZoomToBoundF(this.f9324b, bundle);
    }

    public boolean importMapTheme(int i4) {
        return nativeImportMapTheme(this.f9324b, i4);
    }

    public boolean init(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z4, boolean z5) {
        long j4 = this.f9324b;
        return j4 != 0 && nativeInit(j4, str, str2, str3, str4, str5, str6, str7, i4, i5, i6, i7, i8, i9, i10, z4, z5);
    }

    public boolean initCustomStyle(String str, String str2) {
        long j4 = this.f9324b;
        if (j4 == 0) {
            return true;
        }
        nativeInitCustomStyle(j4, str, str2);
        return true;
    }

    public void initHeatMapData(long j4, Bundle bundle) {
        long j5 = this.f9324b;
        if (j5 != 0) {
            nativeInitHeatMapData(j5, j4, bundle);
        }
    }

    public boolean initWithOptions(Bundle bundle, boolean z4) {
        long j4 = this.f9324b;
        return j4 != 0 && nativeInitWithBundle(j4, bundle, z4);
    }

    public void interruptDraw(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeInterruptDraw(j4, z4);
        }
    }

    public boolean isAnimationRunning() {
        return nativeIsAnimationRunning(this.f9324b);
    }

    public boolean isBaseIndoorMapMode() {
        long j4 = this.f9324b;
        return j4 != 0 && nativeIsBaseIndoorMapMode(j4);
    }

    public boolean isBaseIndoorMapShow() {
        long j4 = this.f9324b;
        return j4 != 0 && nativeIsBaseIndoorMapShow(j4);
    }

    public boolean isEnableIndoor3D() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeIsEnableIndoor3D(j4);
        }
        return true;
    }

    public boolean isNaviMode() {
        return nativeIsNaviMode(this.f9324b);
    }

    public boolean isPointInFocusBarBorder(double d4, double d5, double d6) {
        long j4 = this.f9324b;
        return j4 != 0 && nativeIsPointInFocusBarBorder(j4, d4, d5, d6);
    }

    public boolean isPointInFocusIDRBorder(double d4, double d5) {
        long j4 = this.f9324b;
        return j4 != 0 && nativeIsPointInFocusIDRBorder(j4, d4, d5);
    }

    public boolean isStreetArrowShown() {
        return nativeIsStreetArrowShown(this.f9324b);
    }

    public boolean isStreetCustomMarkerShown() {
        return nativeIsStreetCustomMarkerShown(this.f9324b);
    }

    public boolean isStreetPOIMarkerShown() {
        long j4 = this.f9324b;
        return j4 != 0 && nativeIsStreetPOIMarkerShown(j4);
    }

    public boolean isStreetRoadClickable() {
        return nativeIsStreetRoadClickable(this.f9324b);
    }

    public boolean isSupBackgroundDraw() {
        long j4 = this.f9324b;
        if (j4 == 0) {
            return false;
        }
        return nativeIsSupBackgroundDraw(j4);
    }

    public boolean layersIsShow(long j4) throws Throwable {
        boolean zTryLock;
        boolean z4 = false;
        try {
            zTryLock = this.f9326d.readLock().tryLock(2000L, TimeUnit.MILLISECONDS);
            if (!zTryLock) {
                if (zTryLock) {
                    this.f9326d.readLock().unlock();
                }
                return false;
            }
            try {
                if (a(j4)) {
                    if (zTryLock) {
                        this.f9326d.readLock().unlock();
                    }
                    return false;
                }
                boolean zNativeLayersIsShow = nativeLayersIsShow(this.f9324b, j4);
                if (zTryLock) {
                    this.f9326d.readLock().unlock();
                }
                return zNativeLayersIsShow;
            } catch (Exception unused) {
                if (zTryLock) {
                    this.f9326d.readLock().unlock();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                z4 = zTryLock;
                if (z4) {
                    this.f9326d.readLock().unlock();
                }
                throw th;
            }
        } catch (Exception unused2) {
            zTryLock = false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean moveLayerBelow(long j4, String str) {
        long j5 = this.f9324b;
        if (j5 != 0) {
            return nativeMoveLayerBelow(j5, j4, str);
        }
        return false;
    }

    public boolean moveLayerBelowTo(long j4, int i4) {
        long j5 = this.f9324b;
        if (j5 != 0) {
            return nativeMoveLayerBelowTo(j5, j4, i4);
        }
        return false;
    }

    public void moveToScrPoint(int i4, int i5) {
        nativeMoveToScrPoint(this.f9324b, i4, i5);
    }

    public native void nativeAddOneOverlayItem(long j4, Bundle bundle);

    public native void nativeAddOverlayItems(long j4, Bundle[] bundleArr, int i4);

    public native boolean nativeAddTileOverlay(long j4, Bundle bundle);

    public native boolean nativeCleanSDKTileDataCache(long j4, long j5);

    public native void nativeRemoveOneOverlayItem(long j4, Bundle bundle);

    public native void nativeUpdateOneOverlayItem(long j4, Bundle bundle);

    public native boolean nativeUpdateSDKTile(long j4, Bundle bundle);

    public void onBackground() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeOnBackground(j4);
        }
    }

    public void onForeground() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeOnForeground(j4);
        }
    }

    public void onGestureFinish() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeOnGestureFinish(j4);
        }
    }

    public void onGestureStart() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeOnGestureStart(j4);
        }
    }

    public String onHotcityGet() {
        return nativeOnHotcityGet(this.f9324b);
    }

    public void onPause() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeOnPause(j4);
        }
    }

    public boolean onRecordAdd(int i4) {
        return nativeOnRecordAdd(this.f9324b, i4);
    }

    public String onRecordGetAll() {
        return nativeOnRecordGetAll(this.f9324b);
    }

    public String onRecordGetAt(int i4) {
        return nativeOnRecordGetAt(this.f9324b, i4);
    }

    public boolean onRecordImport(boolean z4, boolean z5) {
        return nativeOnRecordImport(this.f9324b, z4, z5);
    }

    public boolean onRecordReload(int i4, boolean z4) {
        return nativeOnRecordReload(this.f9324b, i4, z4);
    }

    public boolean onRecordRemove(int i4, boolean z4) {
        return nativeOnRecordRemove(this.f9324b, i4, z4);
    }

    public boolean onRecordStart(int i4, boolean z4, int i5) {
        return nativeOnRecordStart(this.f9324b, i4, z4, i5);
    }

    public boolean onRecordSuspend(int i4, boolean z4, int i5) {
        return nativeOnRecordSuspend(this.f9324b, i4, z4, i5);
    }

    public void onResume() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeOnResume(j4);
        }
    }

    public String onSchcityGet(String str) {
        return nativeOnSchcityGet(this.f9324b, str);
    }

    public boolean onUsrcityMsgInterval(int i4) {
        return nativeOnUsrcityMsgInterval(this.f9324b, i4);
    }

    public int onWifiRecordAdd(int i4) {
        return nativeOnWifiRecordAdd(this.f9324b, i4);
    }

    public boolean performAction(String str) {
        return nativePerformAction(this.f9324b, str);
    }

    public boolean preLoad(int i4, List<com.baidu.platform.comapi.map.i> list) {
        if (this.f9324b != 0 && list != null && list.size() > 0) {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < list.size(); i5++) {
                com.baidu.platform.comapi.map.i iVar = list.get(i5);
                ParcelItem parcelItem = new ParcelItem();
                Bundle bundle2 = new Bundle();
                bundle2.putDouble("x", iVar.f9210d);
                bundle2.putDouble("y", iVar.f9211e);
                bundle2.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, iVar.f9212f);
                bundle2.putFloat("level", iVar.f9207a);
                bundle2.putInt("rotation", iVar.f9208b);
                bundle2.putDouble("overlooking", iVar.f9209c);
                parcelItem.setBundle(bundle2);
                arrayList.add(parcelItem);
            }
            if (arrayList.size() > 0) {
                ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    parcelItemArr[i6] = (ParcelItem) arrayList.get(i6);
                }
                bundle.putParcelableArray("points", parcelItemArr);
                return nativePreload(this.f9324b, bundle, i4);
            }
        }
        return false;
    }

    public void preLoadParticleFile(String str) {
        nativePreLoadParticleFile(this.f9324b, str);
    }

    public byte[] readMapResData(String str) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeReadMapResData(j4, str);
        }
        return null;
    }

    public void recycleMemory(int i4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeRecycleMemory(j4, i4);
        }
    }

    public void remove3DModelIDForFilterList(String str) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeRemove3DModelIDForFilterList(j4, str);
        }
    }

    public void removeBmLayer(long j4) {
        nativeRemoveBmLayer(this.f9324b, j4);
    }

    public boolean removeItemData(Bundle bundle) {
        if (!a()) {
            return false;
        }
        this.f9323a.submit(new a(bundle));
        return true;
    }

    public void removeLayer(long j4) {
        if (a()) {
            this.f9323a.submit(new j(j4));
        }
    }

    public void removeOneOverlayItem(Bundle bundle) {
        if (a()) {
            this.f9323a.submit(new e(bundle));
        }
    }

    public void removeOneOverlayItems(Bundle[] bundleArr) {
        if (bundleArr == null || !a()) {
            return;
        }
        this.f9323a.submit(new f(bundleArr));
    }

    public void removeStreetAllCustomMarker() {
        nativeRemoveStreetAllCustomMarker(this.f9324b);
    }

    public void removeStreetCustomMaker(String str) {
        nativeRemoveStreetCustomMaker(this.f9324b, str);
    }

    @Deprecated
    public void renderDone() {
    }

    public void renderInit(int i4, int i5, Surface surface, int i6) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeRenderInit(j4, i4, i5, surface, i6);
        }
    }

    @Deprecated
    public int renderRender() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeDraw(j4);
        }
        return 0;
    }

    public void renderResize(int i4, int i5) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeRenderResize(j4, i4, i5);
        }
    }

    public void resetImageRes() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeResetImageRes(j4);
        }
    }

    public boolean resumeCache() {
        return nativeResumeCache(this.f9324b);
    }

    public boolean saveCache() {
        try {
            return nativeSaveCache(this.f9324b);
        } catch (Throwable unused) {
            return false;
        }
    }

    public void saveScreenToLocal(String str, String str2) {
        nativeSaveScreenToLocal(this.f9324b, str, str2);
    }

    public String scrPtToGeoPoint(int i4, int i5) {
        return nativeScrPtToGeoPoint(this.f9324b, i4, i5);
    }

    public void set3DModelEnable(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSet3DModelEnable(j4, z4);
        }
    }

    public void setAllStreetCustomMarkerVisibility(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetAllStreetCustomMarkerVisibility(j4, z4);
        }
    }

    public void setAutoEnter3DByZoomIn(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativSetAuto3DEnter3DByZoomIn(j4, z4);
        }
    }

    public void setBackgroundColor(int i4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetBackgroundColor(j4, i4);
        }
    }

    public void setCallback(p pVar) {
        BaseMapCallback.setMapCallback(this.f9324b, pVar);
    }

    public void setCustomStyleEnable(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetCustomStyleEnable(j4, z4);
        }
    }

    public void setCustomTrafficColor(int i4, int i5, int i6, int i7) {
        long j4 = this.f9324b;
        if (0 == j4) {
            return;
        }
        nativeSetCustomTrafficColor(j4, i4, i5, i6, i7);
    }

    public void setCustomTrafficColorEnable(boolean z4) {
        long j4 = this.f9324b;
        if (0 == j4) {
            return;
        }
        nativeSetCustomTrafficColorEnable(j4, z4);
    }

    public void setDEMEnable(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetDEMEnable(j4, z4);
        }
    }

    public void setDpiScale(float f4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetDpiScale(j4, f4);
        }
    }

    public void setDrawHouseHeightEnable(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetDrawHouseHeightEnable(j4, z4);
        }
    }

    public void setEnableIndoor3D(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetEnableIndoor3D(j4, z4);
        }
    }

    public void setFeatureConfig(String str) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetFeatureConfig(j4, str);
        }
    }

    public void setFocus(long j4, long j5, boolean z4, Bundle bundle) {
        if (a()) {
            this.f9323a.submit(new n(j4, j5, z4, bundle));
        }
    }

    public void setFontSizeLevel(int i4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetFontSizeLevel(j4, i4);
        }
    }

    public void setFullscreenMaskColor(int i4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetFullscreenMaskColor(j4, i4);
        }
    }

    public void setGlobalLightEnable(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetGlobalLightEnable(j4, z4);
        }
    }

    public void setHeatMapFrameAnimationIndex(long j4, int i4) {
        long j5 = this.f9324b;
        if (j5 != 0) {
            nativeSetHeatMapFrameAnimationIndex(j5, j4, i4);
        }
    }

    public void setHouseSmoothLevel(int i4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetHouseSmoothLevel(j4, i4);
        }
    }

    public void setIndoorMapShowMode(String str, int i4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetIndoorMapShowMode(j4, str, i4);
        }
    }

    public boolean setItsPreTime(int i4, int i5, int i6) {
        return nativeSetItsPreTime(this.f9324b, i4, i5, i6);
    }

    public boolean setLayerSceneMode(long j4, int i4) {
        return nativeSetLayerSceneMode(this.f9324b, j4, i4);
    }

    public void setLayersClickable(long j4, boolean z4) {
        if (a()) {
            this.f9323a.submit(new h(j4, z4));
        }
    }

    public void setLittle3DEnable(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetLittle3DEnable(j4, z4);
        }
    }

    public void setLocationLayerData(Bundle bundle) {
        nativeSetLocationLayerData(this.f9324b, bundle);
    }

    public void setMapBackgroundImage(Bundle bundle) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetMapBackgroundImage(j4, bundle);
        }
    }

    public int setMapControlMode(int i4) {
        return nativeSetMapControlMode(this.f9324b, i4);
    }

    public void setMapLanguage(int i4, boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetMapLanguage(j4, i4, z4);
        }
    }

    public void setMapScene(int i4) {
        nativeSetMapScene(this.f9324b, i4);
    }

    public boolean setMapSceneAttr(int i4) {
        return nativeSetMapSceneAttr(this.f9324b, i4);
    }

    public void setMapStatus(Bundle bundle) {
        nativeSetMapStatus(this.f9324b, bundle);
    }

    public void setMapStatusLimits(Bundle bundle) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetMapStatusLimits(j4, bundle);
        }
    }

    public boolean setMapStatusLimitsLevel(int i4, int i5) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            return nativeSetMapStatusLimitsLevel(j4, i4, i5);
        }
        return false;
    }

    public boolean setMapTheme(int i4, Bundle bundle) {
        return nativeSetMapTheme(this.f9324b, i4, bundle);
    }

    public boolean setMapThemeScene(int i4, int i5, Bundle bundle) {
        return nativeSetMapThemeScene(this.f9324b, i4, i5, bundle);
    }

    public void setMaxAndMinZoomLevel(Bundle bundle) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetMaxAndMinZoomLevel(j4, bundle);
        }
    }

    public void setNewMapStatus(Bundle bundle) {
        nativeNewSetMapStatus(this.f9324b, bundle);
    }

    public void setPoiTagEnable(int i4, boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetPoiTagEnable(j4, i4, z4);
        }
    }

    public void setRecommendPOIScene(int i4) {
        nativeSetRecommendPOIScene(this.f9324b, i4);
    }

    public void setSkyboxStyle(int i4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetSkyboxStyle(j4, i4);
        }
    }

    public void setStreetArrowShow(boolean z4) {
        nativeSetStreetArrowShow(this.f9324b, z4);
    }

    public void setStreetLayerNewDesignFlag(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetStreetLayerNewDesignFlag(j4, z4);
        }
    }

    public void setStreetMarkerClickable(String str, boolean z4) {
        nativeSetStreetMarkerClickable(this.f9324b, str, z4);
    }

    public void setStreetRoadClickable(boolean z4) {
        nativeSetStreetRoadClickable(this.f9324b, z4);
    }

    public void setStyleMode(int i4) {
        nativeSetStyleMode(this.f9324b, i4);
    }

    public void setSupBackgroundDraw(boolean z4) {
        long j4 = this.f9324b;
        if (j4 == 0) {
            return;
        }
        nativeSetSupBackgroundDraw(j4, z4);
    }

    public void setTargetStreetCustomMarkerVisibility(boolean z4, String str) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSetTargetStreetCustomMarkerVisibility(j4, z4, str);
        }
    }

    public boolean setTestSwitch(boolean z4) {
        return nativeSetTestSwitch(this.f9324b, z4);
    }

    public void setTrafficUGCData(String str) {
        nativeSetTrafficUGCData(this.f9324b, str);
    }

    public void setUniversalFilter(String str) {
        nativeSetUniversalFilter(this.f9324b, str);
    }

    public void setVirtualPoiShowEnable(boolean z4) {
        nativeSetVirtualPoiShowEnable(this.f9324b, z4);
    }

    public void showBaseIndoorMap(boolean z4) {
        nativeShowBaseIndoorMap(this.f9324b, z4);
    }

    public void showFootMarkGrid(boolean z4, String str) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeShowFootMarkGrid(j4, z4, str);
        }
    }

    public void showHotMap(boolean z4, int i4) {
        nativeShowHotMap(this.f9324b, z4, i4);
    }

    public void showLayers(long j4, boolean z4) {
        if (a()) {
            this.f9323a.submit(new g(j4, z4));
        }
    }

    public void showMistMap(boolean z4, String str) {
        nativeShowMistMap(this.f9324b, z4, str);
    }

    public void showOperatorDataByType(boolean z4, int i4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeShowOperatorDataByType(j4, z4, i4);
        }
    }

    public boolean showParticleEffect(int i4) {
        return nativeShowParticleEffect(this.f9324b, i4);
    }

    public boolean showParticleEffectByFileName(String str) {
        return nativeShowParticleEffectByFileName(this.f9324b, str);
    }

    public boolean showParticleEffectByFilenameAndPos(String str, float f4, float f5, float f6) {
        return nativeShowParticleEffectByFilenameAndPos(this.f9324b, str, f4, f5, f6);
    }

    public boolean showParticleEffectByName(String str, boolean z4) {
        return nativeShowParticleEffectByName(this.f9324b, str, z4);
    }

    public boolean showParticleEffectByType(int i4) {
        return nativeShowParticleEffectByType(this.f9324b, i4);
    }

    public boolean showParticleEffectByTypeAndPos(int i4, float f4, float f5, float f6) {
        return nativeShowParticleEffectByTypeAndPos(this.f9324b, i4, f4, f5, f6);
    }

    public boolean showParticleEffectByTypeAndStyleID(int i4, int i5) {
        return nativeShowParticleEffectByTypeAndStyleID(this.f9324b, i4, i5);
    }

    public void showSatelliteMap(boolean z4) {
        nativeShowSatelliteMap(this.f9324b, z4);
    }

    public void showStreetPOIMarker(boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeShowStreetPOIMarker(j4, z4);
        }
    }

    public void showStreetPopup(boolean z4) {
        nativeShowStreetPopup(this.f9324b, z4);
    }

    public void showStreetRoadMap(boolean z4) {
        nativeShowStreetRoadMap(this.f9324b, z4);
    }

    public void showTopicPOI(String str, boolean z4, String str2, boolean z5) {
        nativeShowTopicPOI(this.f9324b, str, z4, str2, z5);
    }

    public void showTrafficMap(boolean z4) {
        nativeShowTrafficMap(this.f9324b, z4);
    }

    public void showTrafficUGCMap(boolean z4) {
        nativeShowTrafficUGCMap(this.f9324b, z4);
    }

    public void showUniversalLayer(Bundle bundle) {
        nativeShowUniversalLayer(this.f9324b, bundle);
    }

    public void startHeatMapFrameAnimation(long j4) {
        long j5 = this.f9324b;
        if (j5 != 0) {
            nativeStartHeatMapFrameAnimation(j5, j4);
        }
    }

    public void startIndoorAnimation() {
        nativeStartIndoorAnimation(this.f9324b);
    }

    public void stopHeatMapFrameAnimation(long j4) {
        long j5 = this.f9324b;
        if (j5 != 0) {
            nativeStopHeatMapFrameAnimation(j5, j4);
        }
    }

    public void surfaceDestroyed(Surface surface) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSurfaceDestroyed(j4, surface);
        }
    }

    public boolean switchBaseIndoorMapFloor(String str, String str2) {
        return nativeSwitchBaseIndoorMapFloor(this.f9324b, str, str2);
    }

    public void switchDayOrDarkTheme(int i4, boolean z4) {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeSwitchDayOrDarkTheme(j4, i4, z4);
        }
    }

    public boolean switchLayer(long j4, long j5) {
        if (!a()) {
            return false;
        }
        this.f9323a.submit(new k(j4, j5));
        return true;
    }

    public void unFocusTrafficUGCLabel() {
        nativeUnFocusTrafficUGCLabel(this.f9324b);
    }

    public void updateBaseLayers() {
        nativeUpdateBaseLayers(this.f9324b);
    }

    public void updateDrawFPS() {
        long j4 = this.f9324b;
        if (j4 != 0) {
            nativeUpdateDrawFPS(j4);
        }
    }

    public void updateFootMarkGrid() {
        nativeUpdateFootMarkGrid(this.f9324b);
    }

    public void updateHeatMapData(long j4, Bundle bundle) {
        long j5 = this.f9324b;
        if (j5 != 0) {
            nativeUpdateHeatMapData(j5, j4, bundle);
        }
    }

    public void updateLayers(long j4) {
        if (a()) {
            this.f9323a.submit(new i(j4));
        }
    }

    public void updateOneOverlayItem(Bundle bundle) {
        if (a()) {
            this.f9323a.submit(new d(bundle));
        }
    }

    public String worldPointToScreenPoint(float f4, float f5, float f6) {
        return nativeworldPointToScreenPoint(this.f9324b, f4, f5, f6);
    }

    public float getZoomToBound(long j4, Bundle bundle, int i4, int i5) {
        return nativeGetZoomToBound(j4, bundle, i4, i5);
    }

    public void showHotMap(boolean z4, int i4, String str) {
        nativeShowHotMapWithUid(this.f9324b, z4, i4, str);
    }

    private void b() throws InterruptedException {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f9323a;
            if (threadPoolExecutor != null) {
                if (threadPoolExecutor.getQueue() != null) {
                    this.f9323a.getQueue().clear();
                }
                this.f9323a.shutdown();
                this.f9323a.awaitTermination(100L, TimeUnit.MILLISECONDS);
                this.f9323a.shutdownNow();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j4) {
        return this.f9327e.contains(Long.valueOf(j4)) && j4 != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        return (this.f9323a.isShutdown() || this.f9323a.isTerminated()) ? false : true;
    }
}
