package com.baidu.platform.comapi.bmsdk;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BmLayer extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<BmDrawItem> f8643a;

    /* renamed from: b, reason: collision with root package name */
    private c f8644b;

    /* renamed from: c, reason: collision with root package name */
    private long f8645c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f8646d;

    public BmLayer() {
        super(1, nativeCreate());
        this.f8643a = new ArrayList<>();
        this.f8644b = null;
        this.f8645c = 0L;
        this.f8646d = new Object();
    }

    private static native boolean nativeAddDrawItem(long j4, long j5);

    private static native boolean nativeAddDrawItemAbove(long j4, long j5, long j6);

    private static native boolean nativeAddDrawItemBelow(long j4, long j5, long j6);

    private static native boolean nativeAddDrawItemByZIndex(long j4, long j5, int i4);

    private static native boolean nativeClearDrawItems(long j4);

    private static native boolean nativeCommitUpdate(long j4);

    private static native long nativeCreate();

    private static native Bundle nativeGetDrawItemRect(long j4, int i4, int i5, int i6, int i7);

    private static native long nativeGetLayerId(long j4);

    private static native boolean nativeHandleClick(long j4, int i4, int i5, int i6, long[] jArr);

    private static native boolean nativeRemoveDrawItem(long j4, long j5);

    private static native boolean nativeSDKHandleClick(long j4, int i4, int i5, int i6, long[] jArr, Bundle bundle);

    private static native boolean nativeSetClickable(long j4, boolean z4);

    private static native boolean nativeSetCollideByArea(long j4, boolean z4);

    private static native boolean nativeSetCollisionBaseMap(long j4, boolean z4);

    private static native boolean nativeSetShowLevel(long j4, int i4, int i5);

    private static native boolean nativeSetVisibility(long j4, int i4);

    private static native boolean nativeUpdateDrawItemZIndex(long j4, long j5, int i4);

    public boolean a(BmDrawItem bmDrawItem, int i4) {
        synchronized (this.f8646d) {
            this.f8643a.add(bmDrawItem);
        }
        return nativeAddDrawItemByZIndex(this.nativeInstance, bmDrawItem.getNativeInstance(), i4);
    }

    public boolean b() {
        return nativeCommitUpdate(this.nativeInstance);
    }

    public long c() {
        if (this.f8645c == 0) {
            this.f8645c = nativeGetLayerId(this.nativeInstance);
        }
        return this.f8645c;
    }

    public BmLayer(boolean z4) {
        super(1, nativeCreate());
        this.f8643a = new ArrayList<>();
        this.f8644b = null;
        this.f8645c = 0L;
        this.f8646d = new Object();
        nativeSetCollisionBaseMap(this.nativeInstance, z4);
    }

    public boolean a(String str, BmDrawItem bmDrawItem) {
        long nativeInstance;
        synchronized (this.f8646d) {
            try {
                if (TextUtils.isEmpty(str)) {
                    nativeInstance = 0;
                } else {
                    int size = this.f8643a.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        if (str.equals(this.f8643a.get(i4).getName())) {
                            nativeInstance = this.f8643a.get(i4).getNativeInstance();
                            this.f8643a.add(i4 + 1, bmDrawItem);
                            break;
                        }
                    }
                    nativeInstance = 0;
                }
                if (nativeInstance == 0) {
                    this.f8643a.add(bmDrawItem);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeAddDrawItemAbove(this.nativeInstance, nativeInstance, bmDrawItem.getNativeInstance());
    }

    public boolean a(BmDrawItem bmDrawItem) {
        synchronized (this.f8646d) {
            this.f8643a.remove(bmDrawItem);
        }
        return nativeRemoveDrawItem(this.nativeInstance, bmDrawItem.getNativeInstance());
    }

    public boolean a() {
        synchronized (this.f8646d) {
            this.f8643a.clear();
        }
        return nativeClearDrawItems(this.nativeInstance);
    }

    public BmDrawItem a(String str) {
        synchronized (this.f8646d) {
            try {
                Iterator<BmDrawItem> it = this.f8643a.iterator();
                while (it.hasNext()) {
                    BmDrawItem next = it.next();
                    if (!str.isEmpty() && next.getName().equals(str)) {
                        return next;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean a(BmDrawItem bmDrawItem, short s4) {
        return nativeUpdateDrawItemZIndex(this.nativeInstance, bmDrawItem.getNativeInstance(), s4);
    }

    public BmDrawItem a(int i4, int i5, int i6) {
        long[] jArr = {0, 0, -1};
        if (!nativeSDKHandleClick(this.nativeInstance, i4, i5, i6, jArr, new Bundle()) || this.f8644b == null) {
            return null;
        }
        long j4 = jArr[0];
        if (j4 == 0) {
            return null;
        }
        synchronized (this.f8646d) {
            for (int i7 = 0; i7 < this.f8643a.size(); i7++) {
                try {
                    BmDrawItem bmDrawItem = this.f8643a.get(i7);
                    if (bmDrawItem.nativeInstance == j4) {
                        return bmDrawItem;
                    }
                } finally {
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:10:0x002d, B:12:0x0035, B:14:0x0043, B:16:0x0049, B:18:0x004d, B:25:0x0064, B:27:0x006c, B:28:0x0076, B:30:0x007e, B:34:0x0090, B:35:0x0096, B:37:0x009e, B:38:0x00a4, B:21:0x0057, B:23:0x005b, B:39:0x00aa, B:40:0x00ac), top: B:45:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:10:0x002d, B:12:0x0035, B:14:0x0043, B:16:0x0049, B:18:0x004d, B:25:0x0064, B:27:0x006c, B:28:0x0076, B:30:0x007e, B:34:0x0090, B:35:0x0096, B:37:0x009e, B:38:0x00a4, B:21:0x0057, B:23:0x005b, B:39:0x00aa, B:40:0x00ac), top: B:45:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(int r16, int r17, int r18, boolean r19, boolean r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = 1
            r2 = 0
            r4 = 3
            long[] r4 = new long[r4]
            r4 = {x00b2: FILL_ARRAY_DATA , data: [0, 0, -1} // fill-array
            android.os.Bundle r12 = new android.os.Bundle
            r12.<init>()
            long r5 = r0.nativeInstance
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r4
            r11 = r12
            boolean r5 = nativeSDKHandleClick(r5, r7, r8, r9, r10, r11)
            if (r5 == 0) goto Lb0
            com.baidu.platform.comapi.bmsdk.c r6 = r0.f8644b
            if (r6 == 0) goto Lb0
            r6 = 0
            r7 = r4[r6]
            int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r9 == 0) goto Lb0
            java.lang.Object r9 = r0.f8646d
            monitor-enter(r9)
        L2d:
            java.util.ArrayList<com.baidu.platform.comapi.bmsdk.BmDrawItem> r10 = r0.f8643a     // Catch: java.lang.Throwable -> L55
            int r10 = r10.size()     // Catch: java.lang.Throwable -> L55
            if (r6 >= r10) goto Lac
            java.util.ArrayList<com.baidu.platform.comapi.bmsdk.BmDrawItem> r10 = r0.f8643a     // Catch: java.lang.Throwable -> L55
            java.lang.Object r10 = r10.get(r6)     // Catch: java.lang.Throwable -> L55
            com.baidu.platform.comapi.bmsdk.BmDrawItem r10 = (com.baidu.platform.comapi.bmsdk.BmDrawItem) r10     // Catch: java.lang.Throwable -> L55
            long r13 = r10.nativeInstance     // Catch: java.lang.Throwable -> L55
            int r11 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r11 != 0) goto Laa
            r6 = r4[r1]     // Catch: java.lang.Throwable -> L55
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 == 0) goto L63
            boolean r1 = r10 instanceof com.baidu.platform.comapi.bmsdk.BmBaseMarker     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L57
            r1 = r10
            com.baidu.platform.comapi.bmsdk.BmBaseMarker r1 = (com.baidu.platform.comapi.bmsdk.BmBaseMarker) r1     // Catch: java.lang.Throwable -> L55
            com.baidu.platform.comapi.bmsdk.ui.BmBaseUI r1 = r1.b(r6)     // Catch: java.lang.Throwable -> L55
            goto L64
        L55:
            r0 = move-exception
            goto Lae
        L57:
            boolean r1 = r10 instanceof com.baidu.platform.comapi.bmsdk.Bm3DModel     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L63
            r1 = r10
            com.baidu.platform.comapi.bmsdk.Bm3DModel r1 = (com.baidu.platform.comapi.bmsdk.Bm3DModel) r1     // Catch: java.lang.Throwable -> L55
            com.baidu.platform.comapi.bmsdk.ui.BmBaseUI r1 = r1.b(r6)     // Catch: java.lang.Throwable -> L55
            goto L64
        L63:
            r1 = 0
        L64:
            java.lang.String r2 = "hole_index"
            boolean r2 = r12.containsKey(r2)     // Catch: java.lang.Throwable -> L55
            if (r2 == 0) goto L76
            java.lang.String r2 = "hole_index"
            int r2 = r12.getInt(r2)     // Catch: java.lang.Throwable -> L55
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L55
            r10.a(r2)     // Catch: java.lang.Throwable -> L55
        L76:
            java.lang.String r2 = "multipoint_index"
            boolean r2 = r12.containsKey(r2)     // Catch: java.lang.Throwable -> L55
            if (r2 == 0) goto L8a
            r2 = r10
            com.baidu.platform.comapi.bmsdk.BmMultiPoint r2 = (com.baidu.platform.comapi.bmsdk.BmMultiPoint) r2     // Catch: java.lang.Throwable -> L55
            java.lang.String r3 = "multipoint_index"
            int r3 = r12.getInt(r3)     // Catch: java.lang.Throwable -> L55
            r2.e(r3)     // Catch: java.lang.Throwable -> L55
        L8a:
            if (r19 == 0) goto L9c
            if (r20 == 0) goto Lac
            if (r1 == 0) goto L96
            com.baidu.platform.comapi.bmsdk.c r0 = r0.f8644b     // Catch: java.lang.Throwable -> L55
            r0.a(r10, r1)     // Catch: java.lang.Throwable -> L55
            goto Lac
        L96:
            com.baidu.platform.comapi.bmsdk.c r0 = r0.f8644b     // Catch: java.lang.Throwable -> L55
            r0.a(r10)     // Catch: java.lang.Throwable -> L55
            goto Lac
        L9c:
            if (r1 == 0) goto La4
            com.baidu.platform.comapi.bmsdk.c r0 = r0.f8644b     // Catch: java.lang.Throwable -> L55
            r0.a(r10, r1)     // Catch: java.lang.Throwable -> L55
            goto Lac
        La4:
            com.baidu.platform.comapi.bmsdk.c r0 = r0.f8644b     // Catch: java.lang.Throwable -> L55
            r0.a(r10)     // Catch: java.lang.Throwable -> L55
            goto Lac
        Laa:
            int r6 = r6 + r1
            goto L2d
        Lac:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L55
            goto Lb0
        Lae:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L55
            throw r0
        Lb0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.bmsdk.BmLayer.a(int, int, int, boolean, boolean):boolean");
    }

    public void a(c cVar) {
        this.f8644b = cVar;
    }
}
