package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes28.dex */
public class m4 extends View {
    private boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f27536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f27537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f27538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f27539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bitmap f27540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f27541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Rect f27542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f27543h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f27544i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f27545j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f27546k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f27547l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f27548m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f27549n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f27550o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f27551p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f27552q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f27553r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f27554s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Context f27555t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f27556u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f27557v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f27558w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f27559x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f27560y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f27561z;

    private void a() {
        int r100 = this.f27550o;
        if (r100 == 0) goto L11;
        if (r100 == 2) goto L7;
    L19:
        this.f27548m = this.f27551p;
        int r101 = (getHeight() - this.f27552q) - c();
        this.f27549n = r101;
        if (this.f27548m >= 0) goto L22;
        this.f27548m = 0;
    L22:
        if (r101 >= 0) goto L25;
        this.f27549n = 0;
        return;
    L25:
        return;
    L7:
        if (this.f27559x == false) goto L9;
        this.f27551p = (int) (getWidth() * this.f27557v);
    L10:
        this.f27552q = (int) (getHeight() * this.f27558w);
        goto L19
    L9:
        this.f27551p = (int) ((getWidth() * this.f27557v) - d());
        goto L10
    L11:
        int r102 = this.f27547l;
        if (r102 != 1) goto L15;
        this.f27551p = (getWidth() - d()) / 2;
    L18:
        this.f27552q = 8;
        goto L19
    L15:
        if (r102 != 2) goto L17;
        this.f27551p = (getWidth() - d()) - 10;
        goto L18
    L17:
        this.f27551p = 10;
        goto L18
    }

    private int c() {
        int r100 = this.f27544i;
        if (r100 > 0) goto L6;
        return 0;
    L6:
        return Math.max(1, Math.round(r100 * this.f27546k));
    }

    private int d() {
        int r100 = this.f27545j;
        if (r100 > 0) goto L6;
        return 0;
    L6:
        return Math.max(1, Math.round(r100 * this.f27546k));
    }

    public void b() {
        Bitmap r100 = this.f27536a;     // Catch: Throwable -> L19
        if (r100 == null) goto L5;
        w3.a(r100);     // Catch: Throwable -> L19
        this.f27536a = null;     // Catch: Throwable -> L19
    L5:
        Bitmap r101 = this.f27537b;     // Catch: Throwable -> L19
        if (r101 == null) goto L8;
        w3.a(r101);     // Catch: Throwable -> L19
        this.f27537b = null;     // Catch: Throwable -> L19
    L8:
        this.f27536a = null;     // Catch: Throwable -> L19
        this.f27537b = null;     // Catch: Throwable -> L19
        Bitmap r102 = this.f27540e;     // Catch: Throwable -> L19
        if (r102 == null) goto L11;
        w3.a(r102);     // Catch: Throwable -> L19
        this.f27540e = null;     // Catch: Throwable -> L19
    L11:
        Bitmap r103 = this.f27538c;     // Catch: Throwable -> L19
        if (r103 == null) goto L14;
        w3.a(r103);     // Catch: Throwable -> L19
    L14:
        this.f27538c = null;     // Catch: Throwable -> L19
        Bitmap r104 = this.f27539d;     // Catch: Throwable -> L19
        if (r104 == null) goto L17;
        w3.a(r104);     // Catch: Throwable -> L19
    L17:
        this.f27539d = null;     // Catch: Throwable -> L19
        this.f27541f = null;     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        t6.a(th, "WaterMarkerView", "destory");
        th.printStackTrace();
    }

    public Point e() {
        return new Point(d(), c());
    }

    public Point h() {
        return new Point(this.f27548m, this.f27549n - 2);
    }

    private boolean k() {
        return "en".equals(MapsInitializer.getLogoLanguage());
    }

    public int g() {
        return d();
    }

    public void j() {
        if (getWidth() != 0) goto L5;
        return;
    L5:
        if (getHeight() == 0) goto L10;
        a();
        postInvalidate();
        return;
    }

    public float f() {
        return this.f27546k;
    }

    public boolean i() {
        return this.f27543h;
    }

    public m4(Context r100) {
        super(r100);
        this.f27541f = new Paint();
        this.f27542g = new Rect();
        this.f27543h = false;
        this.f27544i = 0;
        this.f27545j = 0;
        this.f27546k = 1.0f;
        this.f27547l = 0;
        this.f27548m = 10;
        this.f27549n = 0;
        this.f27550o = 0;
        this.f27551p = 10;
        this.f27552q = 8;
        this.f27553r = false;
        this.f27554s = false;
        this.f27556u = true;
        this.f27557v = 0.0f;
        this.f27558w = 0.0f;
        this.f27559x = true;
        this.f27560y = false;
        this.f27561z = false;
        this.A = false;
        this.f27555t = r100.getApplicationContext();     // Catch: Throwable -> L5
        a(r100);     // Catch: Throwable -> L5
        this.f27545j = this.f27537b.getWidth();     // Catch: Throwable -> L5
        this.f27544i = this.f27537b.getHeight();     // Catch: Throwable -> L5
        this.f27541f.setAntiAlias(true);     // Catch: Throwable -> L5
        this.f27541f.setColor(-16777216);     // Catch: Throwable -> L5
        this.f27541f.setStyle(Paint.Style.STROKE);     // Catch: Throwable -> L5
        AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = r100.getFilesDir() + "/icon_web_day.data";     // Catch: Throwable -> L5
        AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = r100.getFilesDir() + "/icon_web_night.data";     // Catch: Throwable -> L5
        v3.b().a(new l4(this));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        t6.a(th, "WaterMarkerView", "create");     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v9 */
    private void a(Context r100) {
        Bitmap r101 = this.f27536a;
        Bitmap r102 = this.f27537b;
        Bitmap r103 = null;
        Bitmap r104 = k();     // Catch: Throwable -> L28
        this.f27561z = r104;     // Catch: Throwable -> L28
        if (r104 == 0) goto L8;
        Bitmap r105 = p3.b(r100, "ap_en.data");     // Catch: Throwable -> L28
        Bitmap r106 = p3.b(r100, "ap1_en.data");     // Catch: Throwable -> L26
        r104 = r105;
    L7:
        r103 = r106;
        this.f27536a = w3.a(r104, w.f28255b);     // Catch: Throwable -> L26
        Bitmap r107 = w3.a(r103, w.f28255b);     // Catch: Throwable -> L26
        this.f27537b = r107;     // Catch: Throwable -> L26
        if (r107 == null) goto L13;
        this.f27545j = r107.getWidth();     // Catch: Throwable -> L26
        this.f27544i = this.f27537b.getHeight();     // Catch: Throwable -> L26
    L13:
        if (r104 == 0) goto L15;
        w3.a(r104);
    L15:
        if (r103 == null) goto L17;
        w3.a(r103);
    L17:
        if (r101 != null) goto L19;
    L21:
        if (r102 != null) goto L23;
        return;
    L23:
        if (r102 == this.f27537b) goto L47;
        w3.a(r102);
        return;
    L47:
        return;
    L19:
        if (r101 == this.f27536a) goto L21;
        w3.a(r101);
        goto L21
    L8:
        Bitmap r108 = p3.b(r100, "ap.data");     // Catch: Throwable -> L28
        r106 = p3.b(r100, "ap1.data");     // Catch: Throwable -> L26
        r104 = r108;
    L26:
        th = th;
    L30:
        if (r104 == 0) goto L32;
        w3.a(r104);
    L32:
        if (r103 == null) goto L34;
        w3.a(r103);
    L34:
        if (r101 != null) goto L36;
    L38:
        if (r102 != null) goto L40;
    L42:
        throw th;
    L40:
        if (r102 == this.f27537b) goto L42;
        w3.a(r102);
        goto L42
    L36:
        if (r101 == this.f27536a) goto L38;
        w3.a(r101);
    L28:
        th = th;
        r104 = 0;
        goto L30
    }

    public void b(boolean r100) {
        if (this.f27556u == true) goto L5;
        return;
    L5:
        this.f27560y = r100;
        if (r100 == true) goto L10;
        this.f27545j = this.f27536a.getWidth();
        this.f27544i = this.f27536a.getHeight();
        return;
    }

    public void c(boolean r100) {
        if (this.f27556u == true) goto L5;
        return;
    L5:
        if (r100 == false) goto L10;
        if (k() == false) goto L10;
        return;
    L10:
        if (this.f27554s == r100) goto L25;
        this.f27554s = r100;
        if (r100 == true) goto L14;
        Bitmap r101 = this.f27536a;
        if (r101 == null) goto L30;
        this.f27545j = r101.getWidth();
        this.f27544i = this.f27536a.getHeight();
        return;
    L30:
        return;
    L14:
        if (this.f27543h == false) goto L18;
        Bitmap r102 = this.f27539d;
        if (r102 == null) goto L26;
        this.f27545j = r102.getWidth();
        this.f27544i = this.f27539d.getHeight();
        return;
    L26:
        return;
    L18:
        Bitmap r103 = this.f27538c;
        if (r103 == null) goto L28;
        this.f27545j = r103.getWidth();
        this.f27544i = this.f27538c.getHeight();
        return;
    L28:
        return;
    }

    public void d(int r100) {
        this.f27550o = 0;
        this.f27547l = r100;
        j();
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
    L44:
        th = move-exception;
        t6.a(th, "WaterMarkerView", "onDraw");
        th.printStackTrace();
        return;
    L3:
        if (this.f27556u == true) goto L6;
        return;
    L6:
        if (getWidth() != 0) goto L8;
        return;
    L8:
        if (getHeight() != 0) goto L11;
        return;
    L11:
        if (this.f27554s == true) goto L13;
    L15:
        boolean r101 = false;
    L17:
        if (this.f27543h == false) goto L23;
        if (r101 == false) goto L22;
        Bitmap r102 = this.f27539d;     // Catch: Throwable -> L44
        if (r102 == null) goto L22;
    L28:
        if (r102 != null) goto L31;
        return;
    L31:
        if (this.f27553r == true) goto L33;
        a();     // Catch: Throwable -> L44
        this.f27553r = true;     // Catch: Throwable -> L44
    L33:
        int r103 = this.f27548m;     // Catch: Throwable -> L44
        int r104 = this.f27549n;     // Catch: Throwable -> L44
        int r105 = d();     // Catch: Throwable -> L44
        int r106 = c();     // Catch: Throwable -> L44
        if (r100 == null) goto L49;
        if (r105 <= 0) goto L50;
        if (r106 > 0) goto L39;
        return;
    L39:
        if (this.f27546k != 1.0f) goto L41;
        r100.drawBitmap(r102, r103, r104, this.f27541f);     // Catch: Throwable -> L44
        return;
    L41:
        this.f27542g.set(r103, r104, r105 + r103, r106 + r104);     // Catch: Throwable -> L44
        r100.drawBitmap(r102, null, this.f27542g, this.f27541f);     // Catch: Throwable -> L44
        return;
    L50:
        return;
    L49:
        return;
    L22:
        r102 = this.f27537b;     // Catch: Throwable -> L44
        goto L28
    L23:
        if (r101 == false) goto L27;
        r102 = this.f27538c;     // Catch: Throwable -> L44
        if (r102 != null) goto L28;
    L27:
        r102 = this.f27536a;     // Catch: Throwable -> L44
        goto L28
    L13:
        if (this.f27561z == true) goto L15;
        r101 = true;
        goto L17
    }

    public static /* synthetic */ Bitmap d(m4 r100) {
        return r100.f27539d;
    }

    public void a(String r100) {
        if (this.f27555t != null) goto L5;
        return;
    L5:
        MapsInitializer.setLogoLanguage(r100);
        boolean r101 = k();
        if (r101 == this.f27561z) goto L8;
        boolean r102 = true;
    L9:
        if (r101 == true) goto L11;
    L13:
        if (r102 == false) goto L15;
        a(this.f27555t);
    L15:
        if (r101 == false) goto L17;
    L27:
        if (r101 == true) goto L30;
        this.A = false;
    L30:
        if (this.f27560y == false) goto L32;
    L36:
        j();
        return;
    L32:
        if (this.f27554s == true) goto L36;
        Bitmap r103 = this.f27536a;
        if (r103 == null) goto L36;
        this.f27545j = r103.getWidth();
        this.f27544i = this.f27536a.getHeight();
        goto L36
    L17:
        if (this.A == false) goto L27;
        if (this.f27538c == null) goto L21;
    L24:
        boolean r104 = true;
    L25:
        if (r104 == false) goto L27;
        c(true);
        this.A = false;
        goto L30
    L21:
        if (this.f27539d != null) goto L24;
        r104 = false;
        goto L25
    L11:
        if (this.f27554s == false) goto L13;
        this.A = true;
        c(false);
        goto L13
    L8:
        r102 = false;
        goto L9
    }

    public void b(int r100) {
        this.f27550o = 1;
        this.f27552q = r100;
        j();
    }

    public void c(int r100) {
        this.f27550o = 1;
        this.f27551p = r100;
        j();
    }

    public static /* synthetic */ Context b(m4 r100) {
        return r100.f27555t;
    }

    public static /* synthetic */ Bitmap c(m4 r100) {
        return r100.f27538c;
    }

    public void a(boolean r100) {
        if (this.f27556u == true) goto L14;
        return;
    L14:
        this.f27543h = r100;     // Catch: Throwable -> L10
        if (r100 == false) goto L8;
        this.f27541f.setColor(-1);     // Catch: Throwable -> L10
    L13:
        return;
    L8:
        this.f27541f.setColor(-16777216);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        t6.a(th, "WaterMarkerView", "changeBitmap");
        th.printStackTrace();
    }

    public void d(boolean r100) {
        this.f27556u = r100;
    }

    public void a(float r100) {
        if (Float.isNaN(r100) == false) goto L5;
    L8:
        r100 = 1.0f;
    L10:
        if (this.f27546k != r100) goto L12;
        return;
    L12:
        this.f27546k = r100;
        j();
        return;
    L5:
        if (Float.isInfinite(r100) == true) goto L8;
        if (r100 > 0.0f) goto L10;
        goto L8
    }

    public float a(int r100) {
        if (this.f27556u == true) goto L5;
        return 0.0f;
    L5:
        if (r100 == 0) goto L15;
        if (r100 != 1) goto L9;
        float r101 = this.f27557v;
    L16:
        return 1.0f - r101;
    L9:
        if (r100 != 2) goto L17;
        r101 = this.f27558w;
        goto L16
    L17:
        return 0.0f;
    L15:
        return this.f27557v;
    }

    public static /* synthetic */ boolean a(m4 r100) {
        return r100.k();
    }

    public void a(String r100, int r101) {
    L25:
        th = move-exception;
        t6.a(th, "WaterMarkerView", "create");
        th.printStackTrace();
        return;
    L3:
        if (this.f27556u == true) goto L6;
        return;
    L6:
        if (k() == false) goto L9;
        return;
    L9:
        if (new PolarisFileWrapper(r100).exists() == true) goto L11;
        return;
    L11:
        if (r101 != 0) goto L18;
        Bitmap r102 = this.f27538c;     // Catch: Throwable -> L25
        Bitmap r103 = BitmapFactory.decodeFile(r100);     // Catch: Throwable -> L25
        this.f27540e = r103;     // Catch: Throwable -> L25
        this.f27538c = w3.a(r103, w.f28255b);     // Catch: Throwable -> L25
        if (r102 != null) goto L15;
    L28:
        return;
    L15:
        if (r102.isRecycled() == true) goto L28;
        w3.a(r102);     // Catch: Throwable -> L25
        goto L28
    L18:
        if (r101 != 1) goto L28;
        Bitmap r104 = this.f27539d;     // Catch: Throwable -> L25
        Bitmap r105 = BitmapFactory.decodeFile(r100);     // Catch: Throwable -> L25
        this.f27540e = r105;     // Catch: Throwable -> L25
        this.f27539d = w3.a(r105, w.f28255b);     // Catch: Throwable -> L25
        if (r104 == null) goto L28;
        if (r104.isRecycled() == true) goto L28;
        w3.a(r104);     // Catch: Throwable -> L25
        goto L28
    }

    public void a(int r100, float r101) {
        if (this.f27556u == true) goto L5;
        return;
    L5:
        this.f27550o = 2;
        float r102 = Math.max(0.0f, Math.min(r101, 1.0f));
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L11;
        if (r100 != 2) goto L13;
        this.f27558w = 1.0f - r102;
    L13:
        j();
        return;
    L11:
        this.f27557v = 1.0f - r102;
        this.f27559x = false;
        goto L13
    L12:
        this.f27557v = r102;
        this.f27559x = true;
        goto L13
    }
}
