package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes.dex */
class F {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f9725a = new float[20];

    /* renamed from: b, reason: collision with root package name */
    private final long[] f9726b = new long[20];

    /* renamed from: c, reason: collision with root package name */
    private float f9727c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    private int f9728d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f9729e = 0;

    F() {
    }

    private void b() {
        this.f9728d = 0;
        this.f9727c = 0.0f;
    }

    private float e() {
        long[] jArr;
        long j5;
        int i5 = this.f9728d;
        if (i5 < 2) {
            return 0.0f;
        }
        int i6 = this.f9729e;
        int i7 = ((i6 + 20) - (i5 - 1)) % 20;
        long j6 = this.f9726b[i6];
        while (true) {
            jArr = this.f9726b;
            j5 = jArr[i7];
            if (j6 - j5 <= 100) {
                break;
            }
            this.f9728d--;
            i7 = (i7 + 1) % 20;
        }
        int i8 = this.f9728d;
        if (i8 < 2) {
            return 0.0f;
        }
        if (i8 == 2) {
            int i9 = (i7 + 1) % 20;
            if (j5 == jArr[i9]) {
                return 0.0f;
            }
            return this.f9725a[i9] / (r2 - j5);
        }
        float fAbs = 0.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f9728d - 1; i11++) {
            int i12 = i11 + i7;
            long[] jArr2 = this.f9726b;
            long j7 = jArr2[i12 % 20];
            int i13 = (i12 + 1) % 20;
            if (jArr2[i13] != j7) {
                i10++;
                float f5 = f(fAbs);
                float f6 = this.f9725a[i13] / (this.f9726b[i13] - j7);
                fAbs += (f6 - f5) * Math.abs(f6);
                if (i10 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return f(fAbs);
    }

    private static float f(float f5) {
        return (f5 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f5) * 2.0f));
    }

    void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f9728d != 0 && eventTime - this.f9726b[this.f9729e] > 40) {
            b();
        }
        int i5 = (this.f9729e + 1) % 20;
        this.f9729e = i5;
        int i6 = this.f9728d;
        if (i6 != 20) {
            this.f9728d = i6 + 1;
        }
        this.f9725a[i5] = motionEvent.getAxisValue(26);
        this.f9726b[this.f9729e] = eventTime;
    }

    void c(int i5, float f5) {
        float fE = e() * i5;
        this.f9727c = fE;
        if (fE < (-Math.abs(f5))) {
            this.f9727c = -Math.abs(f5);
        } else if (this.f9727c > Math.abs(f5)) {
            this.f9727c = Math.abs(f5);
        }
    }

    float d(int i5) {
        if (i5 != 26) {
            return 0.0f;
        }
        return this.f9727c;
    }
}
