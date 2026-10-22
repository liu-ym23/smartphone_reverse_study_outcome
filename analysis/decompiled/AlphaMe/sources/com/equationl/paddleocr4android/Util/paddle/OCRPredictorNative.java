package com.equationl.paddleocr4android.Util.paddle;

import U0.a;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class OCRPredictorNative {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f9567b = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    public long f9568a;

    public static void a() {
        if (f9567b.get()) {
            try {
                purgeMallocArena();
            } catch (Throwable th) {
                Log.w("OCRPredictorNative", "purgeMallocArena failed", th);
            }
        }
    }

    private static native void purgeMallocArena();

    public final ArrayList b(Bitmap bitmap, int i4, int i5, int i6, int i7) {
        Log.i("OCRPredictorNative", "begin to run image ");
        float[] fArrForward = forward(this.f9568a, bitmap, i4, i5, i6, i7);
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        while (i8 < fArrForward.length) {
            int iRound = Math.round(fArrForward[i8]);
            int iRound2 = Math.round(fArrForward[i8 + 1]);
            a aVar = new a();
            aVar.f1885a = new ArrayList();
            aVar.f1886b = new ArrayList();
            aVar.f1888d = fArrForward[i8 + 2];
            int i9 = i8 + 3;
            for (int i10 = 0; i10 < iRound; i10++) {
                int i11 = (i10 * 2) + i9;
                aVar.f1885a.add(new Point(Math.round(fArrForward[i11]), Math.round(fArrForward[i11 + 1])));
            }
            int i12 = iRound * 2;
            int i13 = i9 + i12;
            for (int i14 = 0; i14 < iRound2; i14++) {
                aVar.f1886b.add(Integer.valueOf(Math.round(fArrForward[i13 + i14])));
            }
            int i15 = i13 + iRound2;
            aVar.f1889e = fArrForward[i15];
            float f4 = fArrForward[i15 + 1];
            Log.i("OCRPredictorNative", "word finished " + iRound2);
            i8 += i12 + 3 + iRound2 + 2;
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public native float[] forward(long j4, Bitmap bitmap, int i4, int i5, int i6, int i7);

    public native long init(String str, String str2, String str3, int i4, int i5, String str4);

    public native void release(long j4);
}
