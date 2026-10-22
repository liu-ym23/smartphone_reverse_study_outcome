package com.bytedance.android.live.performance.views.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import xr0.c;
import xr0.d;

/* JADX INFO: loaded from: classes46.dex */
public class LineChartView extends SurfaceView implements SurfaceHolder.Callback {
    public static final /* synthetic */ int K = 0;
    public SurfaceHolder A;
    public a B;
    public int C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public Button H;
    public Button I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public wr0.a f85389J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f85390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f85391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f85392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f85393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f85394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f85395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Path f85396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f85397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f85398i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Data> f85399j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<b> f85400k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f85401l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f85402m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f85403n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f85404o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f85405p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public double f85406q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public double f85407r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double f85408s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f85409t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f85410u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f85411v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f85412w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f85413x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f85414y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f85415z;

    public static class Data implements Parcelable {
        public static final Parcelable.Creator<Data> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f85416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Date f85417b;

        public class a implements Parcelable.Creator<Data> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Data createFromParcel(Parcel r100) {
                return new Data(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final Data[] newArray(int r100) {
                return new Data[r100];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public Data(Parcel r100) {
            this.f85416a = r100.readDouble();
            this.f85417b = (Date) r100.readSerializable();
        }

        public Data(double r100, Date r101) {
            this.f85416a = r100;
            this.f85417b = r101;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeDouble(this.f85416a);
            r100.writeSerializable(this.f85417b);
        }
    }

    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ LineChartView f85418v;

        public final void l() {
        L17:
            LineChartView r100 = this.f85418v;     // Catch: Exception -> L14
            if (r100.f85415z == false) goto L22;
            int r101 = Build.VERSION.SDK_INT;     // Catch: Exception -> L14
            if (r101 < 23) goto L7;
            Canvas r102 = r100.A.getSurface().lockHardwareCanvas();     // Catch: Exception -> L14
        L8:
            LineChartView.a(this.f85418v, r102);     // Catch: Exception -> L14
            if (r101 < 23) goto L11;
            this.f85418v.A.getSurface().unlockCanvasAndPost(r102);     // Catch: Exception -> L14
        L12:
            Thread.sleep(16);     // Catch: Exception -> L14
            goto L17
        L11:
            this.f85418v.A.unlockCanvasAndPost(r102);     // Catch: Exception -> L14
            goto L12
        L7:
            r102 = r100.A.lockCanvas();     // Catch: Exception -> L14
            goto L8
        L22:
            return;
        L14:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LineChartView r100) {
            this.f85418v = r100;
            super("LineChartView$1");
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f85419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Date f85420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Point f85421c;

        public b(double r100, Date r101, Point r102) {
            this.f85419a = r100;
            this.f85420b = r101;
            this.f85421c = r102;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
    }

    private int getTableEnd() {
        int r100 = this.f85401l;
        int r101 = this.f85402m;
        if (((ArrayList) this.f85400k).isEmpty() == false) goto L5;
        int r102 = 0;
    L7:
        return (r100 + (r101 * r102)) + this.f85405p;
    L5:
        r102 = ((ArrayList) this.f85400k).size() - 1;
        goto L7
    }

    private int getTableStart() {
        return this.f85401l + this.f85405p;
    }

    public final void f() {
        Path r100 = this.f85395f;
        if (r100 == null) goto L5;
        r100.reset();
    L5:
        Path r101 = this.f85396g;
        if (r101 == null) goto L8;
        r101.reset();
    L8:
        this.f85402m = (int) s1.e(30.0f);
        this.f85405p = (int) s1.e(15.0f);
        this.f85409t = (int) s1.e(8.0f);
        int r102 = this.f85405p;
        this.f85401l = r102 * 2;
        this.f85404o = r102;
        this.f85403n = r102;
    }

    public int getDataCount() {
        List<Data> r100 = this.f85399j;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return ((ArrayList) r100).size();
    }

    public final void i() {
        if (((ArrayList) this.f85399j).isEmpty() == true) goto L5;
        double r100 = ((Data) Collections.max(this.f85399j, new xr0.b(this))).f85416a;
    L6:
        this.f85406q = g(r100);
        if (((ArrayList) this.f85399j).isEmpty() == true) goto L9;
        double r101 = ((Data) Collections.min(this.f85399j, new c(this))).f85416a;
    L10:
        double r102 = g(r101);
        this.f85407r = r102;
        double r103 = this.f85406q;
        double r104 = (r103 - r102) / 2.0d;
        this.f85408s = r104;
        if (r104 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        r104 = r103 * 2.0d;
    L13:
        this.f85408s = r104;
        this.f85408s = g(r104);
        if (wr0.c.a() == false) goto L16;
        f();
        requestLayout();
        postInvalidate();
        return;
    L16:
        post(new d(this));
        return;
    L9:
        r101 = 0.0d;
        goto L10
    L5:
        r100 = 0.0d;
        goto L6
    }

    private float getViewDrawHeight() {
        return getMeasuredHeight() * 0.618f;
    }

    public final void h() {
        SurfaceHolder r100 = getHolder();
        this.A = r100;
        r100.setFormat(-2);
        this.A.addCallback(this);
        setZOrderOnTop(true);
        Paint r101 = new Paint();
        this.f85390a = r101;
        r101.setAntiAlias(true);
        this.f85390a.setStyle(Paint.Style.STROKE);
        this.f85390a.setColor(this.f85410u);
        this.f85390a.setStrokeWidth(s1.e(1.0f));
        Paint r102 = new Paint();
        this.f85391b = r102;
        r102.setAntiAlias(true);
        this.f85391b.setStyle(Paint.Style.FILL);
        this.f85391b.setColor(this.f85411v);
        this.f85391b.setStrokeWidth(s1.e(4.0f));
        Paint r103 = new Paint();
        this.f85392c = r103;
        r103.setAntiAlias(true);
        this.f85392c.setStyle(Paint.Style.STROKE);
        this.f85392c.setColor(this.f85412w);
        this.f85392c.setStrokeWidth(s1.e(0.25f));
        Paint r104 = new Paint();
        this.f85393d = r104;
        r104.setAntiAlias(true);
        this.f85393d.setStyle(Paint.Style.FILL);
        this.f85393d.setTextAlign(Paint.Align.CENTER);
        this.f85393d.setColor(this.f85413x);
        this.f85393d.setTextSize(s1.I(5.0f));
        Paint r105 = new Paint();
        this.f85394e = r105;
        r105.setAntiAlias(true);
        this.f85394e.setStyle(Paint.Style.FILL);
        this.f85394e.setTextAlign(Paint.Align.CENTER);
        this.f85394e.setColor(this.f85414y);
        this.f85394e.setTextSize(s1.I(5.0f));
        this.f85395f = new Path();
        this.f85396g = new Path();
        f();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
    }

    public LineChartView(Context r100) {
        this(r100, null);
    }

    public static double g(double r100) {
        double r101 = Math.pow(10.0d, 2);
        return Math.ceil(r100 * r101) / r101;
    }

    public final boolean b(boolean r100) {
        if (((ArrayList) this.f85399j).isEmpty() == true) goto L27;
        wr0.a r101 = this.f85389J;
        if (r101 == null) goto L30;
        boolean r102 = this.D;
        if (r102 == false) goto L13;
        if (this.E == false) goto L13;
        return false;
    L13:
        if (r100 == false) goto L20;
        if (r101.f560788d <= 0) goto L25;
        if (r102 == true) goto L26;
        return true;
    L26:
        return false;
    L25:
        return false;
    L20:
        if (r101.f560787c < ((ArrayList) this.f85399j).size()) goto L22;
        return false;
    L22:
        if (this.E == true) goto L29;
        return true;
    L29:
        return false;
    L30:
        return false;
    L27:
        return false;
    }

    public final int d(double r100) {
        double r101 = (Math.abs(g(r100) - this.f85407r) * 100.0d) / (Math.abs(this.f85406q - this.f85407r) * 100.0d);
        return (int) (((((double) getViewDrawHeight()) * r101) + ((double) this.f85404o)) + 0.5d);
    }

    public final void e(boolean r100) {
        wr0.a r101 = this.f85389J;
        if (r101 != null) goto L5;
        return;
    L5:
        boolean r102 = this.D;
        if (r102 == false) goto L11;
        if (this.E == false) goto L11;
        return;
    L11:
        if (r100 == false) goto L19;
        if (r101.f560786b <= 0) goto L17;
        if (r102 == true) goto L30;
        r101.f560788d--;
        r101.f560787c--;
    L24:
        this.f85389J.f560785a = true;
        i();
        return;
    L30:
        return;
    L17:
        return;
    L19:
        if (r101.f560787c >= ((ArrayList) this.f85399j).size()) goto L27;
        if (this.E == true) goto L27;
        wr0.a r103 = this.f85389J;
        r103.f560788d++;
        r103.f560787c++;
    L27:
        if (this.E == false) goto L31;
        this.f85389J.f560785a = false;
        return;
    }

    public void setBackwardButton(Button r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.H = r100;
    }

    public void setCurrentDataShowRange(wr0.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f85389J = r100;
        r100.f560785a = false;
        r100.f560786b = 0;
        r100.f560787c = Integer.MAX_VALUE;
        r100.f560788d = -1;
    }

    public void setData(List<Double> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((ArrayList) this.f85399j).clear();
        Iterator<Double> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        Double r102 = r101.next();
        List<Data> r103 = this.f85399j;
        ArrayList r104 = (ArrayList) r103;
        r104.add(new Data(r102.doubleValue(), new Date()));
        goto L6
    L8:
        i();
    }

    public void setForwardButton(Button r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.I = r100;
    }

    public void setWidth(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f85397h = r100;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        this.f85415z = true;
        a r101 = new a(this);
        this.B = r101;
        ThreadMethodProxy.start(r101);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        this.f85415z = false;
        a r101 = this.B;
        if (r101 == null) goto L6;
        r101.interrupt();
        return;
    }

    public LineChartView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void a(final LineChartView r110, Canvas r111) {
        if (r111 != null) goto L6;
        r110.getClass();
        return;
    L6:
        if (r110.f85395f != null) goto L8;
    L13:
        r110.h();
    L14:
        r110.f85395f.reset();
        r110.f85396g.reset();
        r111.drawColor(0, PorterDuff.Mode.CLEAR);
        r111.translate(0.0f, (((r110.f85398i + r110.getViewDrawHeight()) + r110.f85403n) + r110.f85404o) / 2.0f);
        if (r110.f85389J == null) goto L105;
        ((ArrayList) r110.f85400k).clear();
        r110.D = false;
        r110.E = false;
        if (((ArrayList) r110.f85399j).isEmpty() == false) goto L22;
        wr0.a r100 = r110.f85389J;
        if (r100 == null) goto L105;
        r100.f560785a = false;
        r100.f560786b = 0;
        r100.f560787c = Integer.MAX_VALUE;
        r100.f560788d = -1;
        goto L105
    L22:
        r110.G = r110.getTableStart();
        int r101 = ((ArrayList) r110.f85399j).size();
        wr0.a r102 = r110.f85389J;
        boolean r103 = r102.f560785a;
        if (r103 == false) goto L25;
        int r104 = r102.f560788d;
    L26:
        int r105 = Math.max(0, r104);
        if (r103 == false) goto L29;
        int r112 = Math.min(r110.f85389J.f560787c, r101);
    L30:
        r110.F = false;
        int r113 = r105;
    L31:
        if (r113 >= r112) goto L101;
        Data r114 = (Data) ListProtector.get(r110.f85399j, r113);
        if (r114 == null) goto L97;
        int r115 = Math.max(r105, r110.f85389J.f560786b);
        if (r103 == true) goto L39;
        if (r113 < r115) goto L97;
    L39:
        int r116 = r110.G;
        if (r103 == false) goto L42;
        r115 = r105;
    L42:
        Point r117 = new Point(r116 + ((r113 - r115) * r110.f85402m), -r110.d(r114.f85416a));
    L44:
        if (r117.x > 0) goto L46;
    L48:
        boolean r106 = false;
    L49:
        if (r106 == true) goto L66;
        if (((ArrayList) r110.f85400k).isEmpty() == true) goto L66;
        if (((ArrayList) r110.f85400k).isEmpty() == true) goto L62;
        ListProtector.remove(r110.f85400k, 0);
        Iterator r107 = ((ArrayList) r110.f85400k).iterator();
    L57:
        if (r107.hasNext() == false) goto L62;
        Point r108 = ((b) r107.next()).f85421c;
        if (r108 == null) goto L57;
        r108.x -= r110.f85402m;
    L62:
        r117.x -= r110.f85402m;
        wr0.a r109 = r110.f85389J;
        if (r109 == null) goto L44;
        r109.f560786b++;
    L66:
        if (r117.x > 0) goto L68;
    L70:
        boolean r118 = false;
    L71:
        if (r118 == true) goto L73;
        boolean r119 = false;
    L98:
        if (r119 == false) goto L105;
        r113 = r113 + 1;
        goto L31
    L73:
        if (r113 != 0) goto L76;
        r110.D = true;
    L79:
        if (r110.F == true) goto L86;
        r110.f85395f.moveTo(r117.x, r117.y);
        r110.F = true;
        if (r103 == false) goto L83;
        r110.C = r113;
    L96:
        ((ArrayList) r110.f85400k).add(new b(r114.f85416a, r114.f85417b, r117));
        goto L97
    L83:
        wr0.a r120 = r110.f85389J;
        if (r120 == null) goto L96;
        r120.f560786b = r113;
        r120.f560788d = r113;
        goto L96
    L86:
        r110.f85395f.lineTo(r117.x, r117.y);
        if (r103 == true) goto L89;
        wr0.a r121 = r110.f85389J;
        if (r121 == null) goto L96;
        r121.f560787c = r113;
        goto L96
    L89:
        if (r110.E == false) goto L96;
        wr0.a r122 = r110.f85389J;
        if (r122 == null) goto L96;
        r122.f560785a = false;
        r122.f560786b = r110.C;
        r110.C = 0;
        goto L96
    L76:
        if (r113 != (r101 - 1)) goto L79;
        r110.E = true;
        goto L79
    L68:
        if ((r110.getMeasuredWidth() - r110.f85405p) <= r117.x) goto L70;
        r118 = true;
        goto L71
    L46:
        if ((r110.getMeasuredWidth() - r110.f85405p) <= r117.x) goto L48;
        r106 = true;
    L97:
        r119 = true;
        goto L98
    L101:
        if (r103 == true) goto L103;
        r110.f85389J.f560787c = r112;
    L103:
        r110.post(new xr0.a(r110));
        goto L105
    L29:
        r112 = r101;
        goto L30
    L25:
        r104 = r102.f560786b;
    L105:
        if (r110.f85396g == null) goto L142;
        int r123 = r110.getTableEnd();
        double r124 = r110.f85407r;
        double r125 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r124 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L111;
        r125 = r124 % r110.f85408s;
    L111:
        double r126 = r124 - r125;
        double r127 = r110.f85406q + r110.f85408s;
    L112:
        float r128 = -r110.d(r126);
        r110.f85396g.moveTo(r110.f85401l, r128);
        float r129 = r123;
        r110.f85396g.lineTo(r129, r128);
        String r130 = String.format(Locale.CHINA, "%.2f", new Object[]{Double.valueOf(r126)});
        float r131 = r110.f85401l;
        r110.f85393d.setTextAlign(Paint.Align.RIGHT);
        Paint.FontMetrics r132 = r110.f85393d.getFontMetrics();
        float r133 = r132.bottom;
        r111.drawText(r130, r131 - r110.f85409t, (((r133 - r132.top) / 2.0f) - r133) + r128, r110.f85393d);
        r126 = r126 + r110.f85408s;
        if (r126 < r127) goto L112;
        r110.f85396g.moveTo(r110.f85401l, r128);
        r110.f85396g.lineTo(r110.f85401l, 0.0f);
        r110.f85396g.lineTo(r129, 0.0f);
        r111.drawPath(r110.f85396g, r110.f85392c);
        if (((ArrayList) r110.f85400k).isEmpty() == true) goto L142;
        SimpleDateFormat r134 = new SimpleDateFormat("HH:mm");
        Iterator r135 = ((ArrayList) r110.f85400k).iterator();
        Date r136 = null;
    L119:
        if (r135.hasNext() == false) goto L142;
        b r137 = (b) r135.next();
        if (r137.f85421c == null) goto L119;
        int r138 = ((ArrayList) r110.f85400k).indexOf(r137);     // Catch: Exception -> L138
        Date r139 = r137.f85420b;     // Catch: Exception -> L138
        if (r138 != 0) goto L127;
        r136 = r139;
    L127:
        if (r138 == 0) goto L128;
        if (r139 == null) goto L119;
        if (r136 == null) goto L119;
        if ((r139.getTime() - r136.getTime()) <= 5000) goto L119;
        r110.c(r111, r134.format(r139), r137.f85421c.x);     // Catch: Exception -> L136
    L141:
        r136 = r139;
    L136:
        e = e;
    L140:
        e.printStackTrace();
        goto L141
    L128:
        r110.c(r111, r134.format(r139), r137.f85421c.x);     // Catch: Exception -> L138
    L138:
        e = e;
        r139 = r136;
    L142:
        r111.drawPath(r110.f85395f, r110.f85390a);
        if (((ArrayList) r110.f85400k).isEmpty() == true) goto L194;
        float r140 = s1.e(4.0f) / 2.0f;
        if (((ArrayList) r110.f85400k).size() > ((ArrayList) r110.f85399j).size()) goto L195;
        Iterator r141 = ((ArrayList) r110.f85400k).iterator();
    L150:
        if (r141.hasNext() == false) goto L196;
        b r142 = (b) r141.next();
        if (r142 == null) goto L197;
        Point r143 = r142.f85421c;
        if (r143 == null) goto L198;
        r111.drawCircle(r143.x, r143.y, r140, r110.f85391b);
        String r144 = String.format(Locale.CHINA, "%.2f", new Object[]{Double.valueOf(r142.f85419a)});
        Point r145 = r142.f85421c;
        float r146 = r145.x;
        float r147 = r145.y;
        r110.f85394e.setTextAlign(Paint.Align.CENTER);
        r111.drawText(r144, r146, r147 - r110.f85409t, r110.f85394e);
        goto L150
    L198:
        return;
    L197:
        return;
    L196:
        return;
    L195:
        return;
    L194:
        return;
    L8:
        if (r110.f85396g == null) goto L13;
        if (r110.f85392c == null) goto L13;
        if (r110.f85390a != null) goto L14;
        goto L13
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f85397h;
        if (r102 > 0) goto L5;
        r102 = (int) s1.e(345.0f);
    L5:
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r101);
        if (1073741824 != r103) goto L8;
        r104 = r104 + (getPaddingTop() + getPaddingBottom());
    L8:
        setMeasuredDimension(r102, r104);
    }

    public LineChartView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f85399j = new ArrayList();
        this.f85400k = new ArrayList();
        this.f85408s = 10.0d;
        this.f85410u = ColorProtector.parseColor("#286DD4");
        this.f85411v = ColorProtector.parseColor("#FF4081");
        int r103 = ColorProtector.parseColor("#BBBBBB");
        this.f85412w = r103;
        this.f85413x = r103;
        this.f85414y = ColorProtector.parseColor("#009688");
        this.f85415z = true;
        this.C = 0;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = null;
        this.I = null;
        this.f85389J = null;
        h();
    }

    public final void c(Canvas r100, String r101, float r102) {
        this.f85393d.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics r103 = this.f85393d.getFontMetrics();
        float r104 = r103.bottom;
        r100.drawText(r101, r102, (0.0f + (((r104 - r103.top) / 2.0f) - r104)) + this.f85409t, this.f85393d);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f85397h = r100;
        this.f85398i = r101;
    }
}
