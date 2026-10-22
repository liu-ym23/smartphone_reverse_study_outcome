package org.libpag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.hardware.HardwareBuffer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    private static c f19235a;

    /* renamed from: b, reason: collision with root package name */
    private static HandlerThread f19236b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile int f19237c;

    protected static class a {

        /* renamed from: a, reason: collision with root package name */
        PAGImageView f19238a;

        /* renamed from: b, reason: collision with root package name */
        String f19239b;

        /* renamed from: c, reason: collision with root package name */
        int f19240c;

        /* renamed from: d, reason: collision with root package name */
        Bitmap f19241d;

        protected a() {
        }

        static a a(PAGImageView pAGImageView, String str, int i5, Bitmap bitmap) {
            a aVar = new a();
            aVar.f19238a = pAGImageView;
            aVar.f19239b = str;
            aVar.f19240c = i5;
            aVar.f19241d = bitmap;
            return aVar;
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        int f19242a;

        /* renamed from: b, reason: collision with root package name */
        int f19243b;

        /* renamed from: c, reason: collision with root package name */
        float f19244c;

        /* renamed from: d, reason: collision with root package name */
        int f19245d;

        /* renamed from: e, reason: collision with root package name */
        long f19246e;

        /* renamed from: f, reason: collision with root package name */
        PAGDecoder f19247f;

        b() {
        }

        boolean a() {
            return this.f19242a > 0 && this.f19243b > 0;
        }

        void b() {
            PAGDecoder pAGDecoder = this.f19247f;
            if (pAGDecoder != null) {
                pAGDecoder.release();
            }
            this.f19247f = null;
        }

        void c() {
            b();
            this.f19242a = 0;
            this.f19243b = 0;
            this.f19244c = 0.0f;
            this.f19245d = 0;
            this.f19246e = 0L;
        }

        boolean a(Context context, PAGComposition pAGComposition, String str, int i5, int i6, float f5) {
            if ((pAGComposition == null && str == null) || i5 == 0) {
                return false;
            }
            if (pAGComposition == null) {
                pAGComposition = str.startsWith("assets://") ? PAGFile.Load(context.getAssets(), str.substring(9)) : PAGFile.Load(str);
            }
            if (pAGComposition == null) {
                return false;
            }
            float fMax = Math.max((i5 * 1.0f) / pAGComposition.width(), (i6 * 1.0f) / pAGComposition.height());
            if (f5 <= 0.0f) {
                this.f19244c = pAGComposition.frameRate();
            } else {
                this.f19244c = Math.min(pAGComposition.frameRate(), f5);
            }
            PAGDecoder pAGDecoderMake = PAGDecoder.Make(pAGComposition, this.f19244c, fMax);
            this.f19247f = pAGDecoderMake;
            this.f19242a = pAGDecoderMake.width();
            this.f19243b = this.f19247f.height();
            this.f19245d = this.f19247f.numFrames();
            this.f19246e = pAGComposition.duration();
            return true;
        }
    }

    static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final Object f19248a;

        /* renamed from: b, reason: collision with root package name */
        private List<PAGImageView> f19249b;

        c(Looper looper) {
            super(looper);
            this.f19248a = new Object();
            this.f19249b = new ArrayList();
        }

        void a(PAGImageView pAGImageView) {
            synchronized (this.f19248a) {
                try {
                    if (this.f19249b.isEmpty()) {
                        Message messageObtainMessage = obtainMessage();
                        messageObtainMessage.arg1 = 1;
                        sendMessage(messageObtainMessage);
                    }
                    this.f19249b.add(pAGImageView);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ArrayList arrayList;
            PAGImageView pAGImageView;
            super.handleMessage(message);
            int i5 = message.arg1;
            if (i5 == 0) {
                CacheManager cacheManagerA = CacheManager.a((Context) null);
                if (cacheManagerA != null) {
                    cacheManagerA.a();
                }
                new Handler(Looper.getMainLooper()).post(new l(this));
                return;
            }
            if (i5 == 1) {
                synchronized (this.f19248a) {
                    arrayList = new ArrayList(this.f19249b);
                    this.f19249b.clear();
                }
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    if (obj instanceof PAGImageView) {
                        PAGImageView pAGImageView2 = (PAGImageView) obj;
                        if (!arrayList2.contains(pAGImageView2)) {
                            pAGImageView2.e();
                            arrayList2.add(pAGImageView2);
                        }
                    }
                }
                return;
            }
            if (i5 != 2) {
                if (i5 == 3) {
                    ((PAGImageView) message.obj).b();
                    return;
                } else {
                    if (i5 == 4 && (pAGImageView = (PAGImageView) message.obj) != null) {
                        pAGImageView.c();
                        return;
                    }
                    return;
                }
            }
            PAGImageView pAGImageView3 = (PAGImageView) message.obj;
            if (pAGImageView3 != null) {
                pAGImageView3.d();
                if (pAGImageView3.f19177u != null) {
                    pAGImageView3.f19177u.c();
                }
            }
        }
    }

    protected static synchronized void a() {
        HandlerThread handlerThread;
        f19237c--;
        if (f19237c != 0) {
            return;
        }
        if (f19235a != null && (handlerThread = f19236b) != null) {
            if (handlerThread.isAlive()) {
                b(0, (Object) null);
            }
        }
    }

    protected static double b(int i5, int i6) {
        if (i6 <= 1 || i5 < 0) {
            return 0.0d;
        }
        if (i5 >= i6 - 1) {
            return 1.0d;
        }
        return ((i5 * 1.0d) + 0.1d) / i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        HandlerThread handlerThread;
        if (f19237c == 0 && f19235a != null && (handlerThread = f19236b) != null && handlerThread.isAlive()) {
            f19235a.removeCallbacksAndMessages(null);
            f19236b.quitSafely();
            f19236b = null;
            f19235a = null;
        }
    }

    protected static synchronized void b() {
        try {
            f19237c++;
            if (f19236b == null) {
                HandlerThread handlerThread = new HandlerThread("pagImageView-renderer");
                f19236b = handlerThread;
                handlerThread.start();
            }
            if (f19235a == null) {
                f19235a = new c(f19236b.getLooper());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    protected static void a(int i5, Object obj) {
        c cVar = f19235a;
        if (cVar == null) {
            return;
        }
        cVar.removeMessages(i5, obj);
    }

    protected static void a(PAGImageView pAGImageView) {
        c cVar = f19235a;
        if (cVar == null) {
            return;
        }
        cVar.a(pAGImageView);
    }

    protected static void b(int i5, Object obj) {
        c cVar = f19235a;
        if (cVar == null) {
            return;
        }
        Message messageObtainMessage = cVar.obtainMessage();
        messageObtainMessage.arg1 = i5;
        if (obj != null) {
            messageObtainMessage.obj = obj;
        }
        f19235a.sendMessage(messageObtainMessage);
    }

    protected static Matrix a(int i5, int i6, int i7, int i8, int i9) {
        Matrix matrix = new Matrix();
        if (i5 != 0 && i6 > 0 && i7 > 0 && i8 > 0 && i9 > 0) {
            float f5 = i8;
            float f6 = i6;
            float f7 = (f5 * 1.0f) / f6;
            float f8 = i9;
            float f9 = i7;
            float f10 = (1.0f * f8) / f9;
            if (i5 != 1) {
                if (i5 != 3) {
                    float fMin = Math.min(f7, f10);
                    matrix.setScale(fMin, fMin);
                    if (f7 < f10) {
                        matrix.postTranslate(0.0f, (f8 - (f9 * fMin)) * 0.5f);
                        return matrix;
                    }
                    matrix.postTranslate((f5 - (f6 * fMin)) * 0.5f, 0.0f);
                    return matrix;
                }
                float fMax = Math.max(f7, f10);
                matrix.setScale(fMax, fMax);
                if (f7 > f10) {
                    matrix.postTranslate(0.0f, (f8 - (f9 * fMax)) * 0.5f);
                    return matrix;
                }
                matrix.postTranslate((f5 - (f6 * fMax)) * 0.5f, 0.0f);
                return matrix;
            }
            matrix.setScale(f7, f10);
        }
        return matrix;
    }

    protected static String a(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            return null;
        }
        try {
            return new BigInteger(1, MessageDigest.getInstance("md5").digest(str.getBytes("utf-8"))).toString(16);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private static double a(double d6, double d7) {
        return d6 - (((int) Math.floor(d6 / d7)) * d7);
    }

    protected static int a(double d6, int i5) {
        if (i5 <= 1) {
            return 0;
        }
        double dA = a(d6, 1.0d);
        if (dA <= 0.0d && d6 != 0.0d) {
            dA += 1.0d;
        }
        int iFloor = (int) Math.floor(dA * i5);
        return iFloor == i5 ? i5 - 1 : iFloor;
    }

    protected static Bitmap a(int i5, int i6) {
        if (i5 == 0 || i6 == 0) {
            return null;
        }
        if (CacheManager.f19114a) {
            HardwareBuffer hardwareBufferCreate = HardwareBuffer.create(i5, i6, 1, 1, 307L);
            if (hardwareBufferCreate == null) {
                return null;
            }
            Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBufferCreate, ColorSpace.get(ColorSpace.Named.SRGB));
            try {
                hardwareBufferCreate.close();
                return bitmapWrapHardwareBuffer;
            } catch (Exception e6) {
                e6.printStackTrace();
                return bitmapWrapHardwareBuffer;
            }
        }
        return Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
    }
}
