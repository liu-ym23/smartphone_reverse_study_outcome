package U0;

import B0.g;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.Log;
import com.equationl.paddleocr4android.Util.paddle.OCRPredictorNative;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.ocr.OcrTrace;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import t0.J;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: s, reason: collision with root package name */
    public static volatile boolean f1891s = false;

    /* renamed from: a, reason: collision with root package name */
    public long f1892a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1893b;

    /* renamed from: c, reason: collision with root package name */
    public int f1894c;

    /* renamed from: d, reason: collision with root package name */
    public int f1895d;

    /* renamed from: e, reason: collision with root package name */
    public String f1896e;

    /* renamed from: f, reason: collision with root package name */
    public OCRPredictorNative f1897f;

    /* renamed from: g, reason: collision with root package name */
    public float f1898g;

    /* renamed from: h, reason: collision with root package name */
    public Vector f1899h;

    /* renamed from: i, reason: collision with root package name */
    public int f1900i;

    /* renamed from: j, reason: collision with root package name */
    public Bitmap f1901j;

    /* renamed from: k, reason: collision with root package name */
    public Bitmap f1902k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1903l;

    /* renamed from: m, reason: collision with root package name */
    public volatile String f1904m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f1905n;

    /* renamed from: o, reason: collision with root package name */
    public String f1906o;

    /* renamed from: p, reason: collision with root package name */
    public String f1907p;

    /* renamed from: q, reason: collision with root package name */
    public String f1908q;

    /* renamed from: r, reason: collision with root package name */
    public Boolean f1909r;

    public final void a(Context context, String str, String str2, boolean z4, int i4, String str3, int i5, String[] strArr, Boolean bool) throws Throwable {
        String str4 = str;
        this.f1900i = i5;
        this.f1906o = strArr[0];
        this.f1907p = strArr[1];
        this.f1908q = strArr[2];
        this.f1909r = bool;
        d();
        if (str.isEmpty()) {
            throw new X0.a("modelPath is Empty!", 0);
        }
        if (str4.charAt(0) != '/') {
            String str5 = context.getCacheDir() + "/" + str4;
            J.n(context, str4, str5);
            str4 = str5;
        }
        if (str4.isEmpty()) {
            throw new X0.a("Get Model Real Path Fail", 0);
        }
        StringBuilder sbS = g.s(str4);
        String str6 = File.separator;
        sbS.append(str6);
        sbS.append(this.f1906o);
        String string = sbS.toString();
        StringBuilder sbV = g.v(str4, str6);
        sbV.append(this.f1907p);
        String string2 = sbV.toString();
        StringBuilder sbV2 = g.v(str4, str6);
        sbV2.append(this.f1908q);
        String string3 = sbV2.toString();
        StringBuilder sbX = g.x("model path", string, " ; ", string2, ";");
        sbX.append(string3);
        Log.i("Predictor", sbX.toString());
        if (!new File(string).canRead() || !new File(string).canRead() || !new File(string).canRead()) {
            throw new X0.a("无法读取模型，请检查模型路径是否正确且是否有权限读取！", 0);
        }
        OCRPredictorNative oCRPredictorNative = new OCRPredictorNative();
        oCRPredictorNative.f9568a = 0L;
        AtomicBoolean atomicBoolean = OCRPredictorNative.f9567b;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            try {
                System.loadLibrary("Native");
            } catch (Throwable th) {
                throw new RuntimeException("Load libNative.so failed, please check it exists in apk file.", th);
            }
        }
        StringBuilder sbX2 = g.x("OCRPredictorNative: ", string, AwarenessDataItem.PERMISSION_SPLITTER, string2, AwarenessDataItem.PERMISSION_SPLITTER);
        sbX2.append(string3);
        sbX2.append(AwarenessDataItem.PERMISSION_SPLITTER);
        sbX2.append(z4 ? 1 : 0);
        sbX2.append(AwarenessDataItem.PERMISSION_SPLITTER);
        sbX2.append(i4);
        sbX2.append(AwarenessDataItem.PERMISSION_SPLITTER);
        sbX2.append(str3);
        Log.i("OCRPredictorNative", sbX2.toString());
        oCRPredictorNative.f9568a = oCRPredictorNative.init(string, string2, string3, z4 ? 1 : 0, i4, str3);
        Log.i("OCRPredictorNative", "load success " + oCRPredictorNative.f9568a);
        this.f1897f = oCRPredictorNative;
        this.f1895d = i4;
        this.f1896e = str3;
        str4.substring(str4.lastIndexOf("/") + 1);
        this.f1893b = true;
        Vector vector = this.f1899h;
        vector.clear();
        vector.add("black");
        try {
            if (str2 == null) {
                vector.clear();
            } else {
                InputStream inputStreamOpen = context.getAssets().open(str2);
                byte[] bArr = new byte[inputStreamOpen.available()];
                inputStreamOpen.read(bArr);
                inputStreamOpen.close();
                for (String str7 : new String(bArr).split("\n")) {
                    vector.add(str7);
                }
                vector.add(AwarenessDataItem.PERMISSION_SPLITTER);
                Log.i("b", "Word label size: " + vector.size());
            }
            this.f1893b = true;
        } catch (Exception e4) {
            e4.printStackTrace();
            throw new X0.a("Load label Fail: " + e4.getMessage(), 0);
        }
    }

    public final boolean b() {
        return this.f1897f != null && this.f1893b;
    }

    public final void c() {
        Bitmap bitmap = (!this.f1903l || this.f1909r.booleanValue()) ? null : this.f1901j;
        this.f1901j = null;
        this.f1902k = null;
        this.f1903l = false;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public final void d() {
        c();
        OCRPredictorNative oCRPredictorNative = this.f1897f;
        if (oCRPredictorNative != null) {
            long j4 = oCRPredictorNative.f9568a;
            if (j4 > 0) {
                oCRPredictorNative.release(j4);
                oCRPredictorNative.f9568a = 0L;
            }
            this.f1897f = null;
        }
        this.f1893b = false;
        this.f1895d = 1;
        this.f1896e = "LITE_POWER_HIGH";
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(boolean r20, boolean r21, boolean r22) throws X0.a {
        /*
            Method dump skipped, instructions count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: U0.b.e(boolean, boolean, boolean):void");
    }

    public final void f(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        c();
        Bitmap.Config config = bitmap.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config == config2 && !this.f1909r.booleanValue()) {
            this.f1901j = bitmap;
            this.f1903l = false;
            this.f1892a = 0L;
            if (f1891s) {
                Log.i(OcrTrace.TAG, "setInputImage alias " + bitmap.getWidth() + "x" + bitmap.getHeight());
                return;
            }
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f1901j = bitmap.copy(config2, true);
        this.f1903l = true;
        this.f1892a = SystemClock.elapsedRealtime() - jElapsedRealtime;
        if (f1891s) {
            Log.i(OcrTrace.TAG, "setInputImage copy " + bitmap.getWidth() + "x" + bitmap.getHeight() + " cfg=" + bitmap.getConfig() + " drawBox=" + this.f1909r + " cost=" + this.f1892a + "ms");
        }
    }

    public final void g() {
        if (b()) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Bitmap bitmapCreateBitmap = null;
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(320, 320, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.eraseColor(-1);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint();
                paint.setColor(-16777216);
                paint.setStyle(Paint.Style.FILL);
                for (int i4 = 40; i4 < 280; i4 += 60) {
                    canvas.drawRect(30.0f, i4, 290.0f, i4 + 24, paint);
                }
                this.f1897f.b(bitmapCreateBitmap, this.f1900i, 1, 1, 1);
                if (f1891s) {
                    Log.i(OcrTrace.TAG, "warmUp dummy=320x320 cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
                }
                this.f1894c = 0;
            } catch (Throwable th) {
                try {
                    Log.w(OcrTrace.TAG, "warmUp failed cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms err=" + th);
                } finally {
                    this.f1894c = 0;
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateBitmap.recycle();
                    }
                }
            }
        }
    }
}
