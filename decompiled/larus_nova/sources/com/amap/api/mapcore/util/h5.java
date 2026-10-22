package com.amap.api.mapcore.util;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes28.dex */
public class h5 implements LBSTraceBase, LocationSource.OnLocationChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CoordinateConverter f27370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private z8 f27371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private z8 f27372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f27373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f27374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TraceStatusListener f27375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a1 f27376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<TraceLocation> f27377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f27378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f27379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f27380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private c f27381m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TraceLocation f27382n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<LatLng> f27383o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List<LatLng> f27384p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<LatLng> f27385q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f27386r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private BlockingQueue<Runnable> f27387s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private BlockingQueue<Runnable> f27388t;

    public class a extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<TraceLocation> f27389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f27390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f27391d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<TraceLocation> f27392e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f27393f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private TraceListener f27394h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ h5 f27395i;

        /* JADX INFO: renamed from: com.amap.api.mapcore.util.h5$a$a, reason: collision with other inner class name */
        public class C0511a extends a9 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ g5 f27396b;

            @Override // com.amap.api.mapcore.util.a9
            public void runTask() {
                this.f27396b.run();
            }

            public C0511a(a r100, g5 r101) {
                this.f27396b = r101;
            }
        }

        private int a() {
            List<TraceLocation> r100 = this.f27392e;
            if (r100 != null) goto L5;
        L27:
            return 0;
        L5:
            if (r100.size() == 0) goto L27;
            ArrayList r101 = new ArrayList();
            Iterator<TraceLocation> r102 = this.f27392e.iterator();
            int r103 = 0;
        L9:
            if (r102.hasNext() == false) goto L26;
            TraceLocation r104 = r102.next();
            if (r104 == null) goto L9;
            if (r104.getSpeed() < 0.01d) goto L15;
            int r105 = r101.size();
            if (r105 <= 1) goto L24;
            TraceLocation r106 = (TraceLocation) ListProtector.get(r101, 0);
            TraceLocation r107 = (TraceLocation) ListProtector.get(r101, r105 - 1);
            if (r106 == null) goto L24;
            if (r107 == null) goto L24;
            int r108 = (int) ((r107.getTime() - r106.getTime()) / 1000);
        L25:
            r103 = r103 + r108;
            r101.clear();
        L24:
            r108 = 0;
            goto L25
        L15:
            r101.add(r104);
            goto L9
        L26:
            return r103;
        }

        @Override // com.amap.api.mapcore.util.a9
        public void runTask() {
            h5.g(this.f27395i).a(this.f27394h);     // Catch: Throwable -> L52
            int r100 = a();     // Catch: Throwable -> L52
            List<TraceLocation> r101 = this.f27392e;     // Catch: Throwable -> L52
            if (r101 != null) goto L5;
        L50:
            i5.a().a(h5.g(this.f27395i), this.f27391d, LBSTraceClient.MIN_GRASP_POINT_ERROR);     // Catch: Throwable -> L52
            return;
        L5:
            if (r101.size() < 2) goto L50;
            Iterator<TraceLocation> r102 = this.f27392e.iterator();     // Catch: Throwable -> L52
        L9:
            if (r102.hasNext() == false) goto L17;
            TraceLocation r103 = r102.next().copy();     // Catch: Throwable -> L52
            if (r103 == null) goto L9;
            if (r103.getLatitude() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
            if (r103.getLongitude() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
            this.f27389b.add(r103);     // Catch: Throwable -> L52
            goto L9
        L17:
            int r104 = (this.f27389b.size() - 2) / 500;     // Catch: Throwable -> L52
            i5.a().a(this.f27393f, this.f27391d, r104, r100);     // Catch: Throwable -> L52
            int r105 = 500;
            int r110 = 0;
        L18:
            if (r110 > r104) goto L75;
            if (r110 != r104) goto L21;
            r105 = this.f27389b.size();     // Catch: Throwable -> L52
        L21:
            int r111 = r105;
            ArrayList r106 = new ArrayList();     // Catch: Throwable -> L52
            int r107 = 0;
        L22:
            if (r107 >= r111) goto L39;
            TraceLocation r108 = this.f27389b.remove(0);     // Catch: Throwable -> L52
            if (r108 == null) goto L37;
            int r109 = this.f27390c;     // Catch: Throwable -> L52
            if (r109 != 1) goto L29;
        L36:
            r106.add(r108);     // Catch: Throwable -> L52
            goto L37
        L29:
            if (r109 != 3) goto L31;
            h5.h(this.f27395i).from(CoordinateConverter.CoordType.BAIDU);     // Catch: Throwable -> L52
        L33:
            LatLng r112 = new LatLng(r108.getLatitude(), r108.getLongitude());     // Catch: Throwable -> L52
            h5.h(this.f27395i).coord(r112);     // Catch: Throwable -> L52
            LatLng r113 = h5.h(this.f27395i).convert();     // Catch: Throwable -> L52
            if (r113 == null) goto L36;
            r108.setLatitude(r113.latitude);     // Catch: Throwable -> L52
            r108.setLongitude(r113.longitude);     // Catch: Throwable -> L52
            goto L36
        L31:
            if (r109 != 2) goto L33;
            h5.h(this.f27395i).from(CoordinateConverter.CoordType.GPS);     // Catch: Throwable -> L52
        L37:
            r107 = r107 + 1;     // Catch: Throwable -> L52
            goto L22
        L39:
            if (r106.size() < 2) goto L49;
            if (r106.size() > 500) goto L49;
            g5 r114 = new g5(h5.i(this.f27395i), h5.g(this.f27395i), r106, this.f27393f, this.f27391d, r110);     // Catch: Throwable -> L52
            h5.j(this.f27395i).d(new C0511a(this, r114));     // Catch: Throwable -> L52
            r110 = r110 + 1;
            Thread.sleep(50);     // Catch: InterruptedException -> L47 Throwable -> L52
        L47:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L52
        L49:
            r105 = r111;
            goto L18
        L75:
            return;
        L52:
            th = move-exception;
            th.printStackTrace();
        }

        public a(h5 r100, int r101, List<TraceLocation> r102, int r103, TraceListener r104) {
            this.f27395i = r100;
            this.f27389b = new ArrayList();
            this.f27390c = r103;
            this.f27391d = r101;
            this.f27392e = r102;
            this.f27393f = s3.a();
            this.f27394h = r104;
        }
    }

    public class b implements TraceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<TraceLocation> f27397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h5 f27398b;

        @Override // com.amap.api.trace.TraceListener
        public void onTraceProcessing(int r100, int r101, List<LatLng> r102) {
        }

        public b(h5 r100, List<TraceLocation> r101) {
            this.f27398b = r100;
            this.f27397a = r101;
        }

        private void a(int r100, List<LatLng> r101) {
            List r102 = h5.a(this.f27398b);     // Catch: Throwable -> L15
            monitor-enter(r102);     // Catch: Throwable -> L15
            h5.a(this.f27398b).clear();     // Catch: Throwable -> L12
            h5.a(this.f27398b).addAll(r101);     // Catch: Throwable -> L12
            monitor-exit(r102);     // Catch: Throwable -> L12
            h5.c(this.f27398b).clear();     // Catch: Throwable -> L15
            if (r100 != 0) goto L9;
            h5.c(this.f27398b).addAll(h5.a(this.f27398b));     // Catch: Throwable -> L15
        L10:
            h5.f(this.f27398b).onTraceStatus(h5.e(this.f27398b), h5.c(this.f27398b), LBSTraceClient.TRACE_SUCCESS);     // Catch: Throwable -> L15
            return;
        L9:
            h5.c(this.f27398b).addAll(h5.d(this.f27398b));     // Catch: Throwable -> L15
            h5.c(this.f27398b).addAll(h5.a(this.f27398b));     // Catch: Throwable -> L15
            goto L10
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.amap.api.trace.TraceListener
        public void onRequestFailed(int r100, String r110) {
            ArrayList r111 = new ArrayList();
            if (h5.a(this.f27398b) == null) goto L5;
            r111.addAll(h5.a(this.f27398b));
        L5:
            List<TraceLocation> r101 = this.f27397a;
            if (r101 == null) goto L15;
            int r102 = r101.size();
            if (this.f27397a.size() <= h5.b(this.f27398b)) goto L15;
            int r103 = r102 - h5.b(this.f27398b);
        L10:
            if (r103 >= r102) goto L15;
            TraceLocation r104 = (TraceLocation) ListProtector.get(this.f27397a, r103);
            if (r104 == null) goto L14;
            r111.add(new LatLng(r104.getLatitude(), r104.getLongitude()));
        L14:
            r103 = r103 + 1;
        L15:
            a(r100, r111);
        }

        @Override // com.amap.api.trace.TraceListener
        public void onFinished(int r100, List<LatLng> r101, int r102, int r103) {
            a(r100, r101);
        }
    }

    public static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TraceListener f27399a;

        public c(Looper r100) {
            super(r100);
        }

        public void a(TraceListener r100) {
            this.f27399a = r100;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
        L15:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (this.f27399a != null) goto L5;
            return;
        L5:
            Bundle r101 = r100.getData();     // Catch: Throwable -> L15
            if (r101 != null) goto L8;
            return;
        L8:
            int r102 = r101.getInt("lineID");     // Catch: Throwable -> L15
            switch(r100.what) {
                case 100: goto L13;
                case 101: goto L12;
                case 102: goto L11;
                default: goto L18;
            };     // Catch: Throwable -> L15
        L11:
            String r103 = (String) r100.obj;     // Catch: Throwable -> L15
            this.f27399a.onRequestFailed(r102, r103);     // Catch: Throwable -> L15
            goto L18
        L12:
            List<LatLng> r104 = (List) r100.obj;     // Catch: Throwable -> L15
            this.f27399a.onFinished(r102, r104, r100.arg1, r100.arg2);     // Catch: Throwable -> L15
            goto L18
        L13:
            List<LatLng> r105 = (List) r100.obj;     // Catch: Throwable -> L15
            this.f27399a.onTraceProcessing(r102, r100.arg1, r105);     // Catch: Throwable -> L15
        L18:
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void destroy() {
        stopTrace();     // Catch: Throwable -> L11
        z8 r100 = this.f27371c;     // Catch: Throwable -> L11
        if (r100 == null) goto L6;
        r100.a();     // Catch: Throwable -> L11
        this.f27371c = null;     // Catch: Throwable -> L11
    L6:
        z8 r101 = this.f27372d;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        r101.a();     // Catch: Throwable -> L11
        this.f27372d = null;     // Catch: Throwable -> L11
    L9:
        this.f27377i = null;     // Catch: Throwable -> L11
        this.f27375g = null;     // Catch: Throwable -> L11
    L13:
        this.f27369a = null;
        this.f27370b = null;
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    private void a() {
        int r100 = this.f27377i.size();
        if (r100 >= this.f27374f) goto L6;
        return;
    L6:
        if (r100 > 50) goto L8;
        ArrayList r101 = new ArrayList(this.f27377i);
        queryProcessedTrace(0, r101, 1, new b(this, r101));
        return;
    L8:
        int r110 = r100 - 50;
        if (r110 >= 0) goto L11;
        return;
    L11:
        ArrayList r102 = new ArrayList(this.f27377i.subList(r110 - this.f27374f, r110));
        List<LatLng> r111 = this.f27385q;
        monitor-enter(r111);
    L50:
        th = move-exception;
        throw th;
    L14:
        if (r102.size() >= 1) goto L18;
        monitor-exit(r111);     // Catch: Throwable -> L50
    L16:
        int r112 = r110;
    L48:
        int r103 = r112;
        ArrayList r104 = new ArrayList(this.f27377i.subList(r103, r100));
        queryProcessedTrace(r103, r104, 1, new b(this, r104));
        return;
    L18:
        if (this.f27385q.size() >= 1) goto L21;
        monitor-exit(r111);     // Catch: Throwable -> L50
        goto L16
    L21:
        Iterator r113 = r102.iterator();     // Catch: Throwable -> L50
        LatLng r114 = null;
        double r115 = AudioStats.AUDIO_AMPLITUDE_NONE;
        TraceLocation r116 = null;
        double r117 = 0.0d;
    L23:
        if (r113.hasNext() == false) goto L34;
        TraceLocation r210 = (TraceLocation) r113.next();     // Catch: Throwable -> L50
        if (r210 == null) goto L23;
        if (r116 == null) goto L33;
        double r105 = a(r116.getLatitude(), r116.getLongitude(), r210.getLatitude(), r210.getLongitude());     // Catch: Throwable -> L50
        if (r105 > 100.0d) goto L23;
        r117 = r117 + r105;     // Catch: Throwable -> L50
    L33:
        r116 = r210;
        goto L23
    L34:
        Iterator<LatLng> r118 = this.f27385q.iterator();     // Catch: Throwable -> L50
    L36:
        if (r118.hasNext() == false) goto L46;
        LatLng r106 = r118.next();     // Catch: Throwable -> L50
        if (r106 == null) goto L39;
        if (r114 != null) goto L42;
        this.f27383o.add(r106);     // Catch: Throwable -> L50
        r118.remove();     // Catch: Throwable -> L50
        r114 = r106;
        r112 = r110;
    L45:
        r110 = r112;
        goto L36
    L42:
        r112 = r110;
        r114 = r106;
        r115 = r115 + a(r114.latitude, r114.longitude, r106.latitude, r106.longitude);     // Catch: Throwable -> L50
        if (r115 >= r117) goto L47;
        this.f27383o.add(r114);     // Catch: Throwable -> L50
        r118.remove();     // Catch: Throwable -> L50
    L47:
        monitor-exit(r111);     // Catch: Throwable -> L50
        goto L48
    L39:
        r118.remove();     // Catch: Throwable -> L50
        goto L36
    L46:
        r112 = r110;
        goto L47
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void stopTrace() {
        a1 r100 = this.f27376h;
        if (r100 == null) goto L5;
        r100.deactivate();
        this.f27376h = null;
    L5:
        this.f27387s.clear();
        this.f27388t.clear();
        List<TraceLocation> r101 = this.f27377i;
        if (r101 == null) goto L17;
        monitor-enter(r101);
        List<TraceLocation> r102 = this.f27377i;     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        r102.clear();     // Catch: Throwable -> L14
    L11:
        this.f27379k = 0;     // Catch: Throwable -> L14
        this.f27378j = 0;     // Catch: Throwable -> L14
        this.f27380l = 0;     // Catch: Throwable -> L14
        this.f27382n = null;     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public h5(Context r100) {
        this.f27373e = 2000;
        this.f27374f = 5;
        this.f27377i = new ArrayList();
        this.f27378j = 0;
        this.f27379k = 0;
        this.f27380l = 0;
        this.f27382n = null;
        this.f27383o = new ArrayList();
        this.f27384p = new ArrayList();
        this.f27385q = new ArrayList();
        this.f27386r = Runtime.getRuntime().availableProcessors();
        this.f27387s = new LinkedBlockingQueue();
        this.f27388t = new LinkedBlockingQueue();
        Context r101 = r100.getApplicationContext();
        this.f27369a = r101;
        this.f27370b = new CoordinateConverter(r101);
        this.f27381m = new c(Looper.getMainLooper());
        r5.a().a(this.f27369a);
        this.f27371c = n0.a(1, this.f27386r * 2, this.f27387s, "AMapTraceManagerProcess");
        this.f27372d = n0.a(1, this.f27386r * 2, this.f27388t, "AMapTraceManagerRequest");
    }

    public static /* synthetic */ List a(h5 r100) {
        return r100.f27385q;
    }

    public static /* synthetic */ int b(h5 r100) {
        return r100.f27374f;
    }

    public static /* synthetic */ List c(h5 r100) {
        return r100.f27384p;
    }

    public static /* synthetic */ List d(h5 r100) {
        return r100.f27383o;
    }

    public static /* synthetic */ List e(h5 r100) {
        return r100.f27377i;
    }

    public static /* synthetic */ TraceStatusListener f(h5 r100) {
        return r100.f27375g;
    }

    public static /* synthetic */ c g(h5 r100) {
        return r100.f27381m;
    }

    public static /* synthetic */ CoordinateConverter h(h5 r100) {
        return r100.f27370b;
    }

    public static /* synthetic */ Context i(h5 r100) {
        return r100.f27369a;
    }

    public static /* synthetic */ z8 j(h5 r100) {
        return r100.f27372d;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public void onLocationChanged(Location r110) {
        if (this.f27375g == null) goto L39;
    L34:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if ((System.currentTimeMillis() - this.f27380l) < 30000) goto L9;
        TraceStatusListener r100 = this.f27375g;     // Catch: Throwable -> L34
        if (r100 == null) goto L9;
        r100.onTraceStatus(null, null, LBSTraceClient.LOCATE_TIMEOUT_ERROR);     // Catch: Throwable -> L34
    L9:
        this.f27380l = System.currentTimeMillis();     // Catch: Throwable -> L34
        Bundle r101 = r110.getExtras();     // Catch: Throwable -> L34
        if (r101.getInt("errorCode") == 0) goto L13;
        r101.getString("errorInfo");     // Catch: Throwable -> L34
        return;
    L13:
        List<TraceLocation> r102 = this.f27377i;     // Catch: Throwable -> L34
        monitor-enter(r102);     // Catch: Throwable -> L34
        TraceLocation r111 = new TraceLocation(r110.getLatitude(), r110.getLongitude(), r110.getSpeed(), r110.getBearing(), r110.getTime());     // Catch: Throwable -> L31
        TraceLocation r112 = this.f27382n;     // Catch: Throwable -> L31
        if (r112 != null) goto L18;
    L22:
        boolean r113 = false;
    L23:
        if (r113 == false) goto L26;
        monitor-exit(r102);     // Catch: Throwable -> L31
        return;
    L26:
        this.f27377i.add(r111);     // Catch: Throwable -> L31
        this.f27382n = r111;     // Catch: Throwable -> L31
        int r114 = this.f27378j + 1;     // Catch: Throwable -> L31
        this.f27378j = r114;     // Catch: Throwable -> L31
        if (r114 != this.f27374f) goto L29;
        this.f27379k += r114;     // Catch: Throwable -> L31
        a();     // Catch: Throwable -> L31
        this.f27378j = 0;     // Catch: Throwable -> L31
    L29:
        monitor-exit(r102);     // Catch: Throwable -> L31
        return;
    L18:
        if (r112.getLatitude() != r111.getLatitude()) goto L22;
        if (r112.getLongitude() != r111.getLongitude()) goto L22;
        r113 = true;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void setLocationInterval(long r100) {
        this.f27373e = r100;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void setTraceStatusInterval(int r100) {
        this.f27374f = Math.max(r100, 2);
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void startTrace(TraceStatusListener r100) {
        if (this.f27369a != null) goto L5;
        return;
    L5:
        this.f27380l = System.currentTimeMillis();
        this.f27375g = r100;
        if (this.f27376h != null) goto L9;
        a1 r101 = new a1(this.f27369a);
        this.f27376h = r101;
        r101.a(this.f27373e);
        this.f27376h.activate(this);
        return;
    }

    private double a(double r100, double r101, double r102, double r103) {
        if (r100 <= r102) goto L5;
        double r104 = r100 - r102;
    L7:
        if (r101 <= r103) goto L9;
        double r105 = r101 - r103;
    L11:
        return Math.sqrt((r104 * r104) + (r105 * r105));
    L9:
        r105 = r103 - r101;
        goto L11
    L5:
        r104 = r102 - r100;
        goto L7
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void queryProcessedTrace(int r100, List<TraceLocation> r101, int r110, TraceListener r111) {
        a r102 = new a(this, r100, r101, r110, r111);     // Catch: Throwable -> L4
        this.f27371c.d(r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
