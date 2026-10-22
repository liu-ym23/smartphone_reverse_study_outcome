package com.bytedanceos.common.network.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import y8.f;

/* JADX INFO: loaded from: classes2.dex */
public class ImageLoader {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static HashMap f9848i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RequestQueue f9850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageCache f9852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f9853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f9854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f9855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f9856h;

    public interface ImageCache {
        Bitmap getBitmap(String r10);

        void putBitmap(String r10, Bitmap r11);
    }

    public class ImageContainer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bitmap f9857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageListener f9858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f9859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f9860d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ImageLoader f9861e;

        public ImageContainer(ImageLoader r10, Bitmap r11, String r12, String r13, ImageListener r14) {
            this.f9861e = r10;
            this.f9857a = r11;
            this.f9860d = r12;
            this.f9859c = r13;
            this.f9858b = r14;
        }

        public static /* synthetic */ ImageListener a(ImageContainer r10) {
            return r10.f9858b;
        }

        public static /* synthetic */ Bitmap b(ImageContainer r10, Bitmap r11) {
            r10.f9857a = r11;
            return r11;
        }

        public void c() {
            if (this.f9858b != null) goto L5;
            return;
        L5:
            e r10 = (e) ImageLoader.c(this.f9861e).get(this.f9859c);
            if (r10 != null) goto L8;
            e r11 = (e) ImageLoader.d(this.f9861e).get(this.f9859c);
            if (r11 == null) goto L18;
            r11.f(this);
            if (e.c(r11).size() != 0) goto L19;
            ImageLoader.d(this.f9861e).remove(this.f9859c);
            return;
        L19:
            return;
        L18:
            return;
        L8:
            if (r10.f(this) == false) goto L16;
            ImageLoader.c(this.f9861e).remove(this.f9859c);
            return;
        }

        public Bitmap d() {
            return this.f9857a;
        }

        public String e() {
            return this.f9860d;
        }
    }

    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer r10, boolean r11);
    }

    public class a implements Response.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f9863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageLoader f9864c;

        public a(ImageLoader r10, String r11, boolean r12) {
            this.f9864c = r10;
            this.f9862a = r11;
            this.f9863b = r12;
        }

        public void a(Bitmap r10) {
            ImageLoader.a(this.f9864c, this.f9862a, r10, true, this.f9863b);
        }

        @Override // com.android.volley.Response.Listener
        public /* bridge */ /* synthetic */ void onResponse(Object r10) {
            a((Bitmap) r10);
        }
    }

    public class b implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageLoader f9866b;

        public b(ImageLoader r10, String r11) {
            this.f9866b = r10;
            this.f9865a = r11;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError r10) {
            ImageLoader.b(this.f9866b, this.f9865a, r10);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageLoader f9867a;

        public c(ImageLoader r10) {
            this.f9867a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = ImageLoader.d(this.f9867a).values().iterator();
        L4:
            if (r10.hasNext() == false) goto L15;
            e r11 = (e) r10.next();
            Iterator r12 = e.c(r11).iterator();
        L7:
            if (r12.hasNext() == false) goto L4;
            ImageContainer r13 = (ImageContainer) r12.next();
            if (ImageContainer.a(r13) == null) goto L7;
            if (r11.e() == null) goto L13;
            ImageContainer.a(r13).onErrorResponse(r11.e());
            goto L7
        L13:
            ImageContainer.b(r13, e.a(r11));
            ImageContainer.a(r13).onResponse(r13, false);
            goto L7
        L15:
            ImageLoader.d(this.f9867a).clear();
            ImageLoader.e(this.f9867a, null);
        }
    }

    public class d extends ImageRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageLoader f9869b;

        public d(ImageLoader r10, String r11, Response.Listener r12, int r13, int r14, Bitmap.Config r15, Response.ErrorListener r16) {
            this.f9869b = r10;
            super(r11, r12, r13, r14, r15, r16);
            this.f9868a = false;
        }

        public boolean a() {
            return this.f9868a;
        }

        public void b(boolean r10) {
            this.f9868a = r10;
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Request f9870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap f9871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public VolleyError f9872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinkedList f9873d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ImageLoader f9874e;

        public e(ImageLoader r10, Request r11, ImageContainer r12) {
            this.f9874e = r10;
            LinkedList r13 = new LinkedList();
            this.f9873d = r13;
            this.f9870a = r11;
            r13.add(r12);
        }

        public static /* synthetic */ Bitmap a(e r10) {
            return r10.f9871b;
        }

        public static /* synthetic */ Bitmap b(e r10, Bitmap r11) {
            r10.f9871b = r11;
            return r11;
        }

        public static /* synthetic */ LinkedList c(e r10) {
            return r10.f9873d;
        }

        public void d(ImageContainer r10) {
            this.f9873d.add(r10);
        }

        public VolleyError e() {
            return this.f9872c;
        }

        public boolean f(ImageContainer r10) {
            this.f9873d.remove(r10);
            if (this.f9873d.size() != 0) goto L6;
            this.f9870a.cancel();
            return true;
        L6:
            return false;
        }

        public void g(VolleyError r10) {
            this.f9872c = r10;
        }
    }

    static {
        f9848i = new HashMap();
    }

    public ImageLoader(RequestQueue r10, ImageCache r11, float r12) {
        this.f9849a = 0.0f;
        this.f9851c = 100;
        this.f9853e = new HashMap();
        this.f9854f = new HashMap();
        this.f9855g = new Handler(Looper.getMainLooper());
        this.f9850b = r10;
        this.f9852d = r11;
        this.f9849a = r12;
    }

    public static /* synthetic */ void a(ImageLoader r10, String r11, Bitmap r12, boolean r13, boolean r14) {
        r10.n(r11, r12, r13, r14);
    }

    public static /* synthetic */ void b(ImageLoader r10, String r11, VolleyError r12) {
        r10.m(r11, r12);
    }

    public static /* synthetic */ HashMap c(ImageLoader r10) {
        return r10.f9853e;
    }

    public static /* synthetic */ HashMap d(ImageLoader r10) {
        return r10.f9854f;
    }

    public static /* synthetic */ Runnable e(ImageLoader r10, Runnable r11) {
        r10.f9856h = r11;
        return r11;
    }

    public static void g() {
        if (f9848i.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r10 = f9848i.values().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        ImageLoader r11 = (ImageLoader) r10.next();
        r11.f9855g.removeCallbacksAndMessages(null);
        r11.f9853e.clear();
        r11.f9854f.clear();
        goto L7
    L9:
        f9848i.clear();
    }

    public static String j(String r10, int r11, int r12) {
        StringBuilder r13 = new StringBuilder(r10.length() + 12);
        r13.append("#W");
        r13.append(r11);
        r13.append("#H");
        r13.append(r12);
        r13.append(r10);
        return r13.toString();
    }

    public static ImageLoader l(float r10) {
        ImageLoader r11 = (ImageLoader) f9848i.get(Float.valueOf(r10));
        if (r11 != null) goto L6;
        ImageLoader r12 = new ImageLoader(f.g(), x8.b.c(), r10);
        f9848i.put(Float.valueOf(r10), r12);
        return r12;
    L6:
        return r11;
    }

    public static Bitmap p(Bitmap r10, int r11, int r12) {
        int r13 = r10.getWidth();
        int r14 = r10.getHeight();
        Matrix r15 = new Matrix();
        r15.postScale(r11 / r13, r12 / r14);
        return Bitmap.createBitmap(r10, 0, 0, r13, r14, r15, true);
    }

    public final void f(String r10, e r11) {
        this.f9854f.put(r10, r11);
        if (this.f9856h != null) goto L6;
        c r12 = new c(this);
        this.f9856h = r12;
        this.f9855g.postDelayed(r12, this.f9851c);
        return;
    }

    public ImageContainer h(String r10, ImageListener r11, int r12, int r13, boolean r14) {
        return i(r10, r11, r12, r13, r14, false);
    }

    public ImageContainer i(String r16, ImageListener r17, int r18, int r19, boolean r20, boolean r21) {
        o();
        String r11 = j(r16, r18, r19);
        Bitmap r10 = this.f9852d.getBitmap(r11);
        if (r10 == null) goto L6;
        ImageContainer r12 = new ImageContainer(this, r10, r16, null, null);
        r17.onResponse(r12, true);
        return r12;
    L6:
        ImageContainer r13 = new ImageContainer(this, null, r16, r11, r17);
        r17.onResponse(r13, true);
        e r14 = (e) this.f9853e.get(r11);
        if (r14 == null) goto L10;
        r14.d(r13);
        return r13;
    L10:
        d r15 = new d(this, r16, new a(this, r11, r21), r18, r19, Bitmap.Config.RGB_565, new b(this, r11));
        r15.b(r20);
        this.f9850b.add(r15);
        this.f9853e.put(r11, new e(this, r15, r13));
        return r13;
    }

    public final Bitmap k(String r10, Bitmap r11, float r12) {
        if (r12 != 0.0f) goto L26;
        return r11;
    L26:
        int r13 = r11.getWidth();     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        int r14 = r11.getHeight();     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        if (r12 != BaseApplication.c().getResources().getFloat(R$dimen.app_list_icon_corner_radius)) goto L14;
        int r15 = BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.default_app_list_icon_size);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        if (r13 < r15) goto L17;
    L18:
        boolean r16 = false;
    L19:
        if (r16 == false) goto L21;
        r11 = p(r11, r13, r14);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
    L21:
        Bitmap r17 = Bitmap.createBitmap(r13, r14, Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        Canvas r18 = new Canvas(r17);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        Paint r19 = new Paint();     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        Rect r20 = new Rect(0, 0, r13, r14);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        RectF r21 = new RectF(r20);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        r19.setColor(-12434878);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        r19.setAntiAlias(true);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        r18.drawARGB(0, 0, 0, 0);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        r18.drawRoundRect(r21, r12, r12, r19);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        r19.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        r18.drawBitmap(r11, r20, r20, r19);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        r11.recycle();     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        return r17;
    L17:
        r13 = r15;
        r14 = r13;
        r16 = true;
        goto L19
    L14:
        if (r12 != com.bytedanceos.common.toolbox.d.f10012d) goto L18;
        r15 = BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.default_app_info_icon_size);     // Catch: OutOfMemoryError -> L11 RuntimeException -> L25
        if (r13 >= r15) goto L18;
    L11:
        e = move-exception;
        com.bytedanceos.common.toolbox.e.P0("getRoundCornerBitmap", true);
        e.printStackTrace();
    L24:
        return r11;
    }

    public final void m(String r10, VolleyError r11) {
        e r12 = (e) this.f9853e.remove(r10);
        if (r12 == null) goto L6;
        r12.g(r11);
        f(r10, r12);
        return;
    }

    public final void n(String r10, Bitmap r11, boolean r12, boolean r13) {
        if (r11 != null) goto L4;
    L10:
        Bitmap r14 = null;
    L11:
        e r15 = (e) this.f9853e.remove(r10);
        if (r15 == null) goto L15;
        e.b(r15, r14);
        f(r10, r15);
        return;
    L15:
        return;
    L4:
        if (r11.isRecycled() == true) goto L10;
        r14 = k(r10, r11, this.f9849a);
        if (r13 == false) goto L8;
        r14 = com.bytedanceos.common.utils.f.d(r10, r14, this.f9849a);
    L8:
        if (r12 == false) goto L11;
        this.f9852d.putBitmap(r10, r14);
        goto L11
    }

    public final void o() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
    }
}
