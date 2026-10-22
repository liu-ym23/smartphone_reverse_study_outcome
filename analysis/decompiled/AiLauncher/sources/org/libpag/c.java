package org.libpag;

import android.graphics.Matrix;

/* loaded from: classes5.dex */
abstract class c {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f37911a;

        /* renamed from: b, reason: collision with root package name */
        int f37912b;

        /* renamed from: c, reason: collision with root package name */
        long f37913c;

        /* renamed from: d, reason: collision with root package name */
        private PAGDecoder f37914d;

        public synchronized boolean a() {
            return this.f37914d != null;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x000d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized boolean b() {
            /*
                r1 = this;
                monitor-enter(r1)
                int r0 = r1.f37911a     // Catch: java.lang.Throwable -> Lb
                if (r0 <= 0) goto Ld
                int r0 = r1.f37912b     // Catch: java.lang.Throwable -> Lb
                if (r0 <= 0) goto Ld
                r0 = 1
                goto Le
            Lb:
                r0 = move-exception
                goto L10
            Ld:
                r0 = 0
            Le:
                monitor-exit(r1)
                return r0
            L10:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.libpag.c.a.b():boolean");
        }

        public synchronized int c() {
            PAGDecoder pAGDecoder;
            pAGDecoder = this.f37914d;
            return pAGDecoder == null ? 0 : pAGDecoder.numFrames();
        }

        public synchronized void d() {
            PAGDecoder pAGDecoder = this.f37914d;
            if (pAGDecoder != null) {
                pAGDecoder.release();
                this.f37914d = null;
            }
        }

        public synchronized void e() {
            d();
            this.f37911a = 0;
            this.f37912b = 0;
            this.f37913c = 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x000f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized boolean a(int r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                org.libpag.PAGDecoder r0 = r1.f37914d     // Catch: java.lang.Throwable -> Ld
                if (r0 == 0) goto Lf
                boolean r2 = r0.checkFrameChanged(r2)     // Catch: java.lang.Throwable -> Ld
                if (r2 == 0) goto Lf
                r2 = 1
                goto L10
            Ld:
                r2 = move-exception
                goto L12
            Lf:
                r2 = 0
            L10:
                monitor-exit(r1)
                return r2
            L12:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Ld
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.libpag.c.a.a(int):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0011  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized boolean a(int r2, android.hardware.HardwareBuffer r3) {
            /*
                r1 = this;
                monitor-enter(r1)
                org.libpag.PAGDecoder r0 = r1.f37914d     // Catch: java.lang.Throwable -> Lf
                if (r0 == 0) goto L11
                if (r3 == 0) goto L11
                boolean r2 = r0.readFrame(r2, r3)     // Catch: java.lang.Throwable -> Lf
                if (r2 == 0) goto L11
                r2 = 1
                goto L12
            Lf:
                r2 = move-exception
                goto L14
            L11:
                r2 = 0
            L12:
                monitor-exit(r1)
                return r2
            L14:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lf
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.libpag.c.a.a(int, android.hardware.HardwareBuffer):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0011  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized boolean a(android.graphics.Bitmap r2, int r3) {
            /*
                r1 = this;
                monitor-enter(r1)
                org.libpag.PAGDecoder r0 = r1.f37914d     // Catch: java.lang.Throwable -> Lf
                if (r0 == 0) goto L11
                if (r2 == 0) goto L11
                boolean r2 = r0.copyFrameTo(r2, r3)     // Catch: java.lang.Throwable -> Lf
                if (r2 == 0) goto L11
                r2 = 1
                goto L12
            Lf:
                r2 = move-exception
                goto L14
            L11:
                r2 = 0
            L12:
                monitor-exit(r1)
                return r2
            L14:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lf
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.libpag.c.a.a(android.graphics.Bitmap, int):boolean");
        }

        public synchronized boolean a(PAGComposition pAGComposition, int i10, int i11, float f10) {
            float f11;
            int iHeight;
            if (pAGComposition == null || i10 <= 0 || i11 <= 0 || f10 <= 0.0f) {
                return false;
            }
            try {
                if (pAGComposition.width() >= pAGComposition.height()) {
                    f11 = i10 * 1.0f;
                    iHeight = pAGComposition.width();
                } else {
                    f11 = i11 * 1.0f;
                    iHeight = pAGComposition.height();
                }
                PAGDecoder pAGDecoderMake = PAGDecoder.Make(pAGComposition, f10, f11 / iHeight);
                this.f37914d = pAGDecoderMake;
                this.f37911a = pAGDecoderMake.width();
                this.f37912b = this.f37914d.height();
                this.f37913c = pAGComposition.duration();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static double a(int i10, int i11) {
        if (i11 <= 1 || i10 < 0) {
            return 0.0d;
        }
        if (i10 >= i11 - 1) {
            return 1.0d;
        }
        return ((i10 * 1.0d) + 0.1d) / i11;
    }

    public static Matrix a(int i10, int i11, int i12, int i13, int i14) {
        Matrix matrix = new Matrix();
        if (i10 != 0 && i11 > 0 && i12 > 0 && i13 > 0 && i14 > 0) {
            float f10 = i13;
            float f11 = i11;
            float f12 = (f10 * 1.0f) / f11;
            float f13 = i14;
            float f14 = i12;
            float f15 = (1.0f * f13) / f14;
            if (i10 != 1) {
                if (i10 != 3) {
                    float fMin = Math.min(f12, f15);
                    matrix.setScale(fMin, fMin);
                    if (f12 < f15) {
                        matrix.postTranslate(0.0f, (f13 - (f14 * fMin)) * 0.5f);
                        return matrix;
                    }
                    matrix.postTranslate((f10 - (f11 * fMin)) * 0.5f, 0.0f);
                    return matrix;
                }
                float fMax = Math.max(f12, f15);
                matrix.setScale(fMax, fMax);
                if (f12 > f15) {
                    matrix.postTranslate(0.0f, (f13 - (f14 * fMax)) * 0.5f);
                    return matrix;
                }
                matrix.postTranslate((f10 - (f11 * fMax)) * 0.5f, 0.0f);
                return matrix;
            }
            matrix.setScale(f12, f15);
        }
        return matrix;
    }

    private static double a(double d10, double d11) {
        return d10 - (((int) Math.floor(d10 / d11)) * d11);
    }

    public static int a(double d10, int i10) {
        if (i10 <= 1) {
            return 0;
        }
        double dA = a(d10, 1.0d);
        if (dA <= 0.0d && d10 != 0.0d) {
            dA += 1.0d;
        }
        int iFloor = (int) Math.floor(dA * i10);
        return iFloor == i10 ? i10 - 1 : iFloor;
    }
}
