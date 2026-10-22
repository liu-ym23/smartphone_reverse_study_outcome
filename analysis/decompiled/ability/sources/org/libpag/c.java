package org.libpag;

import android.graphics.Matrix;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes4.dex */
abstract class c {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        volatile int f5510a;
        volatile int b;
        volatile long c;
        private PAGDecoder d;
        private final ReentrantLock e = new ReentrantLock();
        private final AtomicInteger f = new AtomicInteger(0);
        private volatile int g = 0;
        private volatile boolean h = false;
        private volatile int i = 0;

        public boolean a() {
            return this.h;
        }

        public boolean b() {
            return this.f5510a > 0 && this.b > 0 && this.g == this.f.get();
        }

        public void c() {
            this.e.lock();
        }

        public int d() {
            return this.i;
        }

        public void e() {
            this.e.lock();
            try {
                PAGDecoder pAGDecoder = this.d;
                if (pAGDecoder != null) {
                    pAGDecoder.release();
                    this.d = null;
                }
                this.h = false;
                this.e.unlock();
            } catch (Throwable th) {
                this.e.unlock();
                throw th;
            }
        }

        public void f() {
            this.f.incrementAndGet();
            this.h = false;
            this.i = 0;
            if (!this.e.tryLock()) {
                this.f5510a = 0;
                this.b = 0;
                this.c = 0L;
                this.f.incrementAndGet();
                return;
            }
            try {
                e();
                this.f5510a = 0;
                this.b = 0;
                this.c = 0L;
            } finally {
                this.e.unlock();
            }
        }

        public void g() {
            this.e.unlock();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(int r3) {
            /*
                r2 = this;
                java.util.concurrent.locks.ReentrantLock r0 = r2.e
                boolean r0 = r0.tryLock()
                r1 = 1
                if (r0 != 0) goto La
                return r1
            La:
                org.libpag.PAGDecoder r0 = r2.d     // Catch: java.lang.Throwable -> L15
                if (r0 == 0) goto L17
                boolean r3 = r0.checkFrameChanged(r3)     // Catch: java.lang.Throwable -> L15
                if (r3 == 0) goto L17
                goto L18
            L15:
                r3 = move-exception
                goto L1e
            L17:
                r1 = 0
            L18:
                java.util.concurrent.locks.ReentrantLock r2 = r2.e
                r2.unlock()
                return r1
            L1e:
                java.util.concurrent.locks.ReentrantLock r2 = r2.e
                r2.unlock()
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: org.libpag.c.a.a(int):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(int r2, android.hardware.HardwareBuffer r3) {
            /*
                r1 = this;
                java.util.concurrent.locks.ReentrantLock r0 = r1.e
                r0.lock()
                org.libpag.PAGDecoder r0 = r1.d     // Catch: java.lang.Throwable -> L13
                if (r0 == 0) goto L15
                if (r3 == 0) goto L15
                boolean r2 = r0.readFrame(r2, r3)     // Catch: java.lang.Throwable -> L13
                if (r2 == 0) goto L15
                r2 = 1
                goto L16
            L13:
                r2 = move-exception
                goto L1c
            L15:
                r2 = 0
            L16:
                java.util.concurrent.locks.ReentrantLock r1 = r1.e
                r1.unlock()
                return r2
            L1c:
                java.util.concurrent.locks.ReentrantLock r1 = r1.e
                r1.unlock()
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.libpag.c.a.a(int, android.hardware.HardwareBuffer):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(android.graphics.Bitmap r2, int r3) {
            /*
                r1 = this;
                java.util.concurrent.locks.ReentrantLock r0 = r1.e
                r0.lock()
                org.libpag.PAGDecoder r0 = r1.d     // Catch: java.lang.Throwable -> L13
                if (r0 == 0) goto L15
                if (r2 == 0) goto L15
                boolean r2 = r0.copyFrameTo(r2, r3)     // Catch: java.lang.Throwable -> L13
                if (r2 == 0) goto L15
                r2 = 1
                goto L16
            L13:
                r2 = move-exception
                goto L1c
            L15:
                r2 = 0
            L16:
                java.util.concurrent.locks.ReentrantLock r1 = r1.e
                r1.unlock()
                return r2
            L1c:
                java.util.concurrent.locks.ReentrantLock r1 = r1.e
                r1.unlock()
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.libpag.c.a.a(android.graphics.Bitmap, int):boolean");
        }

        public boolean a(PAGComposition pAGComposition, int i, int i6, float f) {
            float f7;
            int iHeight;
            this.e.lock();
            if (pAGComposition != null && i > 0 && i6 > 0 && f > 0.0f) {
                try {
                    e();
                    int i10 = this.f.get();
                    if (pAGComposition.width() >= pAGComposition.height()) {
                        f7 = i * 1.0f;
                        iHeight = pAGComposition.width();
                    } else {
                        f7 = i6 * 1.0f;
                        iHeight = pAGComposition.height();
                    }
                    PAGDecoder pAGDecoderMake = PAGDecoder.Make(pAGComposition, f, f7 / iHeight);
                    if (pAGDecoderMake == null) {
                        this.e.unlock();
                        return false;
                    }
                    if (this.f.get() != i10) {
                        pAGDecoderMake.release();
                        this.e.unlock();
                        return false;
                    }
                    this.d = pAGDecoderMake;
                    this.f5510a = pAGDecoderMake.width();
                    this.b = pAGDecoderMake.height();
                    this.i = pAGDecoderMake.numFrames();
                    this.c = pAGComposition.duration();
                    this.g = i10;
                    this.h = true;
                    this.e.unlock();
                    return true;
                } catch (Throwable th) {
                    this.e.unlock();
                    throw th;
                }
            }
            this.e.unlock();
            return false;
        }
    }

    public static double a(int i, int i6) {
        if (i6 <= 1 || i < 0) {
            return 0.0d;
        }
        if (i >= i6 - 1) {
            return 1.0d;
        }
        return ((i * 1.0d) + 0.1d) / i6;
    }

    public static Matrix a(int i, int i6, int i10, int i11, int i12) {
        Matrix matrix = new Matrix();
        if (i != 0 && i6 > 0 && i10 > 0 && i11 > 0 && i12 > 0) {
            float f = i11;
            float f7 = i6;
            float f9 = (f * 1.0f) / f7;
            float f10 = i12;
            float f11 = i10;
            float f12 = (1.0f * f10) / f11;
            if (i != 1) {
                if (i != 3) {
                    float fMin = Math.min(f9, f12);
                    matrix.setScale(fMin, fMin);
                    if (f9 < f12) {
                        matrix.postTranslate(0.0f, androidx.compose.foundation.b.a(f11, fMin, f10, 0.5f));
                        return matrix;
                    }
                    matrix.postTranslate(androidx.compose.foundation.b.a(f7, fMin, f, 0.5f), 0.0f);
                    return matrix;
                }
                float fMax = Math.max(f9, f12);
                matrix.setScale(fMax, fMax);
                if (f9 > f12) {
                    matrix.postTranslate(0.0f, androidx.compose.foundation.b.a(f11, fMax, f10, 0.5f));
                    return matrix;
                }
                matrix.postTranslate(androidx.compose.foundation.b.a(f7, fMax, f, 0.5f), 0.0f);
                return matrix;
            }
            matrix.setScale(f9, f12);
        }
        return matrix;
    }

    private static double a(double d, double d6) {
        return d - (((int) Math.floor(d / d6)) * d6);
    }

    public static int a(double d, int i) {
        if (i <= 1) {
            return 0;
        }
        double dA = a(d, 1.0d);
        if (dA <= 0.0d && d != 0.0d) {
            dA += 1.0d;
        }
        int iFloor = (int) Math.floor(dA * i);
        return iFloor == i ? i - 1 : iFloor;
    }
}
