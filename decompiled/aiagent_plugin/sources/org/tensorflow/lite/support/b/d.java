package org.tensorflow.lite.support.b;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: ImageConversions.java */
/* JADX INFO: loaded from: classes5.dex */
class d {

    /* JADX INFO: renamed from: org.tensorflow.lite.support.b.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImageConversions.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f40604a = null;

        static {
            int[] r0 = new int[org.tensorflow.lite.a.values().length];
            f40604a = r0;
            r0[org.tensorflow.lite.a.f40581c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f40604a[org.tensorflow.lite.a.f40579a.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static void a(Bitmap r12, org.tensorflow.lite.support.c.a r13) {
        int r8 = r12.getWidth();
        int r9 = r12.getHeight();
        int r10 = r8 * r9;
        int[] r11 = new int[r10];
        r12.getPixels(r11, 0, r8, 0, 0, r8, r9);
        int r1 = 0;
        int[] r0 = {r9, r8, 3};
        int r14 = AnonymousClass1.f40604a[r13.b().ordinal()];
        if (r14 == 1) goto L11;
        if (r14 != 2) goto L10;
        float[] r15 = new float[r10 * 3];
        int r2 = 0;
    L6:
        if (r1 >= r10) goto L8;
        int r3 = r2 + 1;
        r15[r2] = (r11[r1] >> 16) & 255;
        int r4 = r3 + 1;
        r15[r3] = (r11[r1] >> 8) & 255;
        r15[r4] = r11[r1] & 255;
        r1 = r1 + 1;
        r2 = r4 + 1;
        goto L6
    L8:
        r13.a(r15, r0);
        return;
    L10:
        throw new IllegalStateException("The type of TensorBuffer, " + r13.a() + ", is unsupported.");
    L11:
        byte[] r16 = new byte[r10 * 3];
        int r5 = 0;
    L12:
        if (r1 >= r10) goto L14;
        int r6 = r5 + 1;
        r16[r5] = (byte) ((r11[r1] >> 16) & 255);
        int r7 = r6 + 1;
        r16[r6] = (byte) ((r11[r1] >> 8) & 255);
        r16[r7] = (byte) (r11[r1] & 255);
        r1 = r1 + 1;
        r5 = r7 + 1;
        goto L12
    L14:
        ByteBuffer r17 = ByteBuffer.wrap(r16);
        r17.order(ByteOrder.nativeOrder());
        r13.a(r17, r0);
    }
}
