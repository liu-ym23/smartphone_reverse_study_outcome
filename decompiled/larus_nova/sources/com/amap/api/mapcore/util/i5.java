package com.amap.api.mapcore.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class i5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile i5 f27431b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, a> f27432a;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f27433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f27434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f27435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f27436d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f27437e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private HashMap<Integer, List<LatLng>> f27438f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<LatLng> f27439g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5 f27440h;

        public HashMap<Integer, List<LatLng>> a() {
            return this.f27438f;
        }

        public void a(Handler r100) {
            int r101 = this.f27435c;
        L4:
            if (r101 > this.f27433a) goto L9;
            List<LatLng> r102 = this.f27438f.get(Integer.valueOf(r101));
            if (r102 == null) goto L9;
            this.f27439g.addAll(r102);
            Message r103 = r100.obtainMessage();
            r103.obj = r102;
            r103.what = 100;
            r103.arg1 = this.f27435c;
            Bundle r104 = new Bundle();
            r104.putInt("lineID", this.f27434b);
            r103.setData(r104);
            r100.sendMessage(r103);
            this.f27435c++;
            this.f27437e++;
            r101 = r101 + 1;
        L9:
            if (this.f27435c == (this.f27433a + 1)) goto L11;
            return;
        L11:
            if (this.f27437e <= 0) goto L27;
            List<LatLng> r105 = this.f27439g;
            int r106 = 0;
            if (r105 != null) goto L15;
        L26:
            Message r107 = r100.obtainMessage();
            r107.obj = this.f27439g;
            r107.what = 101;
            r107.arg1 = r106;
            r107.arg2 = this.f27436d;
            Bundle r108 = new Bundle();
            r108.putInt("lineID", this.f27434b);
            r107.setData(r108);
            r100.sendMessage(r107);
            return;
        L15:
            if (r105.size() == 0) goto L26;
            int r109 = 0;
        L19:
            if (r106 >= (r105.size() - 1)) goto L25;
            LatLng r110 = (LatLng) ListProtector.get(r105, r106);
            r106 = r106 + 1;
            LatLng r111 = (LatLng) ListProtector.get(r105, r106);
            if (r110 == null) goto L25;
            if (r111 == null) goto L25;
            r109 = (int) (r109 + AMapUtils.calculateLineDistance(r110, r111));
        L25:
            r106 = r109;
            goto L26
        L27:
            this.f27440h.a(r100, this.f27434b, LBSTraceClient.MIN_GRASP_POINT_ERROR);
        }

        public a(i5 r100, int r101, int r102, int r103, HashMap<Integer, List<LatLng>> r104) {
            this.f27440h = r100;
            this.f27433a = 0;
            this.f27434b = 0;
            this.f27435c = 0;
            this.f27436d = 0;
            this.f27437e = 0;
            this.f27439g = new ArrayList();
            this.f27433a = r102;
            this.f27438f = r104;
            this.f27434b = r101;
            this.f27436d = r103;
        }
    }

    public static i5 a() {
        if (f27431b != null) goto L15;
        monitor-enter(i5.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f27431b != null) goto L9;
        f27431b = new i5();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i5.class);     // Catch: Throwable -> L11
    L15:
        return f27431b;
    }

    public i5() {
        this.f27432a = null;
        this.f27432a = Collections.synchronizedMap(new HashMap());
    }

    public synchronized a a(String r100) {
        monitor-enter(this);
        Map<String, a> r101 = this.f27432a;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        a r102 = r101.get(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        monitor-exit(this);
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public void a(Handler r100, int r101, String r102) {
        Message r103 = r100.obtainMessage();
        r103.obj = r102;
        r103.what = 102;
        Bundle r104 = new Bundle();
        r104.putInt("lineID", r101);
        r103.setData(r104);
        r100.sendMessage(r103);
    }

    public synchronized void a(String r100, int r101, List<LatLng> r102) {
        monitor-enter(this);
        Map<String, a> r103 = this.f27432a;     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        r103.get(r100).a().put(Integer.valueOf(r101), r102);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void a(String r100, int r110, int r111, int r112) {
        monitor-enter(this);
        Map<String, a> r101 = this.f27432a;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.put(r100, new a(this, r110, r111, r112, new HashMap(16)));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
