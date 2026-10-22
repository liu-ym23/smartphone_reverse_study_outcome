package com.baidu.mapapi.map;

import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseIntArray;
import androidx.camera.video.AudioStats;
import androidx.collection.LongSparseArray;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes39.dex */
public class HeatMap {
    public static final Gradient DEFAULT_GRADIENT = null;
    public static final int DEFAULT_MAX_HIGH = 0;
    public static final int DEFAULT_MAX_LEVEL = 22;
    public static final int DEFAULT_MIN_LEVEL = 4;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f30912a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f30913b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float[] f30914c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f30915d;
    private ExecutorService A;
    private HashSet<String> B;
    BaiduMap C;
    private int D;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f30916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f30917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f30918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f30919h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private e<WeightedLatLng> f30920i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Collection<WeightedLatLng> f30921j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<List<WeightedLatLng>> f30922k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f30923l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f30924m;
    protected boolean mIsSetMaxIntensity;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private HeatMapAnimation f30925n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private HeatMapAnimation f30926o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f30927p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f30928q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Gradient f30929r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private double f30930s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private c f30931t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int[] f30932u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float[] f30933v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private double[] f30934w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private double[] f30935x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List<double[]> f30936y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private HashMap<String, Tile> f30937z;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Collection<WeightedLatLng> f30938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<List<WeightedLatLng>> f30939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f30940c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f30941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Gradient f30942e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private double f30943f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f30944g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f30945h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f30946i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f30947j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private float f30948k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private float f30949l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f30950m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private HeatMapAnimation f30951n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private HeatMapAnimation f30952o;

        public HeatMap build() {
            if (this.f30938a != null) goto L10;
            if (this.f30939b != null) goto L10;
            throw new IllegalStateException("BDMapSDKException: No input data: you must use either .data or .weightedData before building");
        L10:
            return new HeatMap(this, null);
        }

        public Builder() {
            this.f30940c = 12;
            this.f30941d = 12;
            this.f30942e = HeatMap.DEFAULT_GRADIENT;
            this.f30943f = 0.6d;
            this.f30944g = 0;
            this.f30945h = false;
            this.f30946i = 22;
            this.f30947j = 4;
            this.f30948k = 1.0f;
            this.f30949l = 0.0f;
            this.f30950m = false;
            HeatMapAnimation.AnimationType r100 = HeatMapAnimation.AnimationType.Linear;
            this.f30951n = new HeatMapAnimation(false, 100, r100);
            this.f30952o = new HeatMapAnimation(false, 100, r100);
        }

        public static /* synthetic */ Collection a(Builder r100) {
            return r100.f30938a;
        }

        public static /* synthetic */ HeatMapAnimation b(Builder r100) {
            return r100.f30951n;
        }

        public static /* synthetic */ HeatMapAnimation c(Builder r100) {
            return r100.f30952o;
        }

        public static /* synthetic */ int d(Builder r100) {
            return r100.f30944g;
        }

        public static /* synthetic */ float e(Builder r100) {
            return r100.f30948k;
        }

        public static /* synthetic */ float f(Builder r100) {
            return r100.f30949l;
        }

        public static /* synthetic */ Gradient g(Builder r100) {
            return r100.f30942e;
        }

        public static /* synthetic */ double h(Builder r100) {
            return r100.f30943f;
        }

        public static /* synthetic */ List i(Builder r100) {
            return r100.f30939b;
        }

        public static /* synthetic */ int j(Builder r100) {
            return r100.f30940c;
        }

        public static /* synthetic */ int k(Builder r100) {
            return r100.f30941d;
        }

        public static /* synthetic */ boolean l(Builder r100) {
            return r100.f30945h;
        }

        public static /* synthetic */ int m(Builder r100) {
            return r100.f30946i;
        }

        public static /* synthetic */ int n(Builder r100) {
            return r100.f30947j;
        }

        public static /* synthetic */ boolean o(Builder r100) {
            return r100.f30950m;
        }

        public Builder data(Collection<LatLng> r100) {
            if (r100 == null) goto L12;
            if (r100.isEmpty() == true) goto L12;
            if (r100.contains(null) == true) goto L10;
            return weightedData(HeatMap.a(r100));
        L10:
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        L12:
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }

        public Builder datas(List<List<LatLng>> r100) {
            if (r100 == null) goto L12;
            if (r100.isEmpty() == true) goto L12;
            if (r100.contains(null) == true) goto L10;
            return weightedDatas(HeatMap.a(r100));
        L10:
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        L12:
            throw new IllegalArgumentException("BDMapSDKException: No input datas.");
        }

        public Builder frameAnimation(HeatMapAnimation r100) {
            this.f30952o = r100;
            return this;
        }

        public Builder gradient(Gradient r100) {
            if (r100 == null) goto L6;
            this.f30942e = r100;
            return this;
        L6:
            throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
        }

        public Builder initAnimation(HeatMapAnimation r100) {
            this.f30951n = r100;
            return this;
        }

        public Builder isRadiusMeter(boolean r100) {
            this.f30945h = r100;
            return this;
        }

        public Builder maxHigh(int r100) {
            if (r100 >= 0) goto L5;
            return this;
        L5:
            if (r100 <= 200) goto L8;
            this.f30944g = 200;
            return this;
        L8:
            this.f30944g = r100;
            return this;
        }

        public Builder maxIntensity(float r100) {
            if (r100 >= 0.0f) goto L5;
        L8:
            return this;
        L5:
            if (r100 <= this.f30949l) goto L8;
            this.f30948k = r100;
            this.f30950m = true;
            goto L8
        }

        public Builder maxShowLevel(int r100) {
            if (r100 >= this.f30947j) goto L6;
            return this;
        L6:
            if (r100 <= 22) goto L8;
            this.f30946i = 22;
        L8:
            this.f30946i = r100;
            return this;
        }

        public Builder minIntensity(float r100) {
            if (r100 >= 0.0f) goto L7;
            this.f30949l = 0.0f;
            return this;
        L7:
            if (r100 < this.f30948k) goto L9;
            return this;
        L9:
            this.f30949l = r100;
            return this;
        }

        public Builder minShowLevel(int r100) {
            if (r100 >= 4) goto L7;
            this.f30947j = 4;
            return this;
        L7:
            if (r100 <= this.f30946i) goto L9;
            return this;
        L9:
            this.f30947j = r100;
            return this;
        }

        public Builder opacity(double r100) {
            if (r100 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
            this.f30943f = AudioStats.AUDIO_AMPLITUDE_NONE;
            return this;
        L7:
            if (r100 <= 1.0d) goto L10;
            this.f30943f = 1.0d;
            return this;
        L10:
            this.f30943f = r100;
            return this;
        }

        public Builder radius(int r100) {
            if (r100 >= 10) goto L7;
            this.f30940c = 10;
            return this;
        L7:
            if (r100 <= 50) goto L10;
            this.f30940c = 50;
            return this;
        L10:
            this.f30940c = r100;
            return this;
        }

        public Builder radiusMeter(int r100) {
            if (r100 >= 10) goto L7;
            this.f30941d = 10;
            return this;
        L7:
            if (r100 <= 50) goto L10;
            this.f30941d = 50;
            return this;
        L10:
            this.f30941d = r100;
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> r100) {
            if (r100 == null) goto L12;
            if (r100.isEmpty() == true) goto L12;
            if (r100.contains(null) == true) goto L10;
            this.f30938a = r100;
            return this;
        L10:
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        L12:
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }

        public Builder weightedDatas(List<List<WeightedLatLng>> r100) {
            if (r100 == null) goto L12;
            if (r100.isEmpty() == true) goto L12;
            if (r100.contains(null) == true) goto L10;
            this.f30939b = r100;
            return this;
        L10:
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        L12:
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
    }

    private synchronized void b() {
        monitor-enter(this);
        this.f30937z.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        SparseIntArray r100 = new SparseIntArray();
        f30912a = r100;
        r100.put(3, 8388608);
        r100.put(4, 4194304);
        r100.put(5, 2097152);
        r100.put(6, 1048576);
        r100.put(7, 524288);
        r100.put(8, 262144);
        r100.put(9, 131072);
        r100.put(10, 65536);
        r100.put(11, 32768);
        r100.put(12, 16384);
        r100.put(13, 8192);
        r100.put(14, 4096);
        r100.put(15, 2048);
        r100.put(16, 1024);
        r100.put(17, 512);
        r100.put(18, 256);
        r100.put(19, 128);
        r100.put(20, 64);
        int[] r101 = {Color.rgb(0, 0, 200), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        f30913b = r101;
        float[] r102 = {0.08f, 0.4f, 1.0f};
        f30914c = r102;
        DEFAULT_GRADIENT = new Gradient(r101, r102);
        f30915d = 0;
    }

    public void c() {
        this.A.shutdownNow();
    }

    public boolean isFrameAnimation() {
        HeatMapAnimation r100 = this.f30925n;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getIsAnimation();
    }

    public boolean isInitAnimation() {
        HeatMapAnimation r100 = this.f30926o;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getIsAnimation();
    }

    public void removeHeatMap() {
        BaiduMap r100 = this.C;
        if (r100 == null) goto L5;
        r100.a(this);
    L5:
        List<List<WeightedLatLng>> r101 = this.f30922k;
        if (r101 == null) goto L8;
        r101.clear();
    L8:
        Collection<WeightedLatLng> r102 = this.f30921j;
        if (r102 == null) goto L12;
        r102.clear();
        return;
    }

    public Bundle toBundle() {
        Bundle r100 = new Bundle();
        r100.putInt("grid_size", this.D);
        r100.putFloat("point_size_meter", this.f30928q * 2);
        r100.putFloat("point_size", this.f30927p * 2);
        r100.putFloat("max_hight", this.f30916e);
        r100.putFloat("alpha", (float) this.f30930s);
        List<List<WeightedLatLng>> r101 = this.f30922k;
        if (r101 == null) goto L6;
        r100.putInt("frame_count", r101.size());
    L8:
        r100.putIntArray("color_array", this.f30932u);
        r100.putFloatArray("color_start_points", this.f30933v);
        r100.putBoolean("is_need_init_animation", this.f30926o.getIsAnimation());
        r100.putBoolean("is_need_frame_animation", this.f30925n.getIsAnimation());
        r100.putBoolean("point_size_is_meter", this.f30917f);
        r100.putInt("init_animation_duration", this.f30926o.getDuration());
        r100.putInt("init_animation_type", this.f30926o.getAnimationType());
        r100.putInt("frame_animation_duration", this.f30925n.getDuration());
        r100.putInt("frame_animation_type", this.f30925n.getAnimationType());
        r100.putFloat("max_intentity", this.f30923l);
        r100.putFloat("min_intentity", this.f30924m);
        r100.putFloat("max_show_level", this.f30918g);
        r100.putFloat("min_show_level", this.f30919h);
        return r100;
    L6:
        if (this.f30921j == null) goto L8;
        r100.putInt("frame_count", 1);
        goto L8
    }

    public void a() {
        b();
    }

    public int getMaxHigh() {
        return this.f30916e;
    }

    private HeatMap(Builder r100) {
        this.f30916e = 200;
        int r101 = 0;
        this.f30917f = false;
        this.f30918g = 22;
        this.f30919h = 4;
        this.D = SysOSUtil.getInstance().getScreenWidth() / 2;
        this.f30937z = new HashMap();
        this.A = PThreadExecutorsUtils.newFixedThreadPool(1, new DefaultThreadFactory("i/map/HeatMap"));
        this.B = new HashSet();
        this.f30922k = Builder.i(r100);
        this.f30927p = Builder.j(r100);
        this.f30928q = Builder.k(r100);
        this.f30917f = Builder.l(r100);
        this.f30918g = Builder.m(r100);
        this.f30919h = Builder.n(r100);
        boolean r102 = Builder.o(r100);
        this.mIsSetMaxIntensity = r102;
        if (r102 == false) goto L5;
    L10:
        Collection<WeightedLatLng> r103 = Builder.a(r100);
        this.f30921j = r103;
        if (this.mIsSetMaxIntensity == true) goto L14;
        if (r103 == null) goto L14;
        c(r103);
    L14:
        this.f30926o = Builder.b(r100);
        this.f30925n = Builder.c(r100);
        this.f30916e = Builder.d(r100);
        this.f30923l = Builder.e(r100);
        this.f30924m = Builder.f(r100);
        this.f30929r = Builder.g(r100);
        this.f30930s = Builder.h(r100);
        int r104 = this.f30927p;
        this.f30934w = a(r104, ((double) r104) / 3.0d);
        a(this.f30929r);
        return;
    L5:
        if (this.f30922k == null) goto L10;
        this.f30936y = new ArrayList();
    L8:
        if (r101 >= this.f30922k.size()) goto L10;
        Collection<WeightedLatLng> r105 = (Collection) ListProtector.get(this.f30922k, r101);
        this.f30921j = r105;
        this.f30931t = b(r105);
        this.f30936y.add(a(this.f30927p));
        r101 = r101 + 1;
        goto L8
    }

    private double[] a(int r110) {
        double[] r100 = new double[23];
        int r101 = 4;
    L3:
        int r102 = 11;
        if (r101 >= 11) goto L11;
        r100[r101] = a(this.f30921j, this.f30931t, r110, (int) (Math.pow(2.0d, r101 - 3) * 1280.0d));
        if (r101 != 4) goto L10;
        int r103 = 0;
    L8:
        if (r103 >= r101) goto L10;
        r100[r103] = r100[r101];
        r103 = r103 + 1;
    L10:
        r101 = r101 + 1;
    L11:
        if (r102 >= 23) goto L13;
        r100[r102] = r100[10];
        r102 = r102 + 1;
        goto L11
    L13:
        return r100;
    }

    private static c b(Collection<WeightedLatLng> r110) {
        Iterator<WeightedLatLng> r100 = r110.iterator();
        WeightedLatLng r101 = r100.next();
        double r102 = r101.getPoint().x;
        double r103 = r101.getPoint().x;
        double r111 = r102;
        double r112 = r103;
        double r113 = r101.getPoint().y;
        double r114 = r101.getPoint().y;
    L4:
        if (r100.hasNext() == false) goto L18;
        WeightedLatLng r104 = r100.next();
        double r105 = r104.getPoint().x;
        double r106 = r104.getPoint().y;
        if (r105 >= r111) goto L9;
        r111 = r105;
    L9:
        if (r105 <= r112) goto L12;
        r112 = r105;
    L12:
        if (r106 >= r113) goto L15;
        r113 = r106;
    L15:
        if (r106 <= r114) goto L4;
        r114 = r106;
        goto L4
    L18:
        return new c(r111, r112, r113, r114);
    }

    private void c(Collection<WeightedLatLng> r100) {
        this.f30921j = r100;
        if (r100.isEmpty() == true) goto L11;
        c r101 = b(this.f30921j);
        this.f30931t = r101;
        this.f30920i = new e(r101);
        Iterator<WeightedLatLng> r102 = this.f30921j.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        WeightedLatLng r103 = r102.next();
        this.f30920i.a(r103);
        goto L6
    L8:
        this.f30935x = a(this.f30927p);
        return;
    L11:
        throw new IllegalArgumentException("BDMapSDKException: No input points.");
    }

    private static Collection<WeightedLatLng> d(Collection<LatLng> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<LatLng> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(new WeightedLatLng(r102.next()));
        goto L4
    L6:
        return r101;
    }

    public void updateData(Collection<LatLng> r100) {
        if (r100 == null) goto L12;
        if (r100.isEmpty() == true) goto L12;
        if (r100.contains(null) == true) goto L10;
        updateWeightedData(d(r100));
        return;
    L10:
        throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
    L12:
        throw new IllegalArgumentException("BDMapSDKException: No input points.");
    }

    public void updateDatas(List<List<LatLng>> r100) {
        if (r100 == null) goto L12;
        if (r100.isEmpty() == true) goto L12;
        if (r100.contains(null) == true) goto L10;
        updateWeightedDatas(b(r100));
        return;
    L10:
        throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
    L12:
        throw new IllegalArgumentException("BDMapSDKException: No input datas.");
    }

    public void updateFrameAnimation(HeatMapAnimation r100) {
        this.f30925n = r100;
    }

    public void updateGradient(Gradient r100) {
        if (r100 == null) goto L6;
        this.f30929r = r100;
        a(r100);
        return;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
    }

    public void updateIsRadiusMeter(boolean r100) {
        this.f30917f = r100;
    }

    public void updateMaxHigh(int r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (r100 <= 200) goto L8;
        this.f30916e = 200;
        return;
    L8:
        this.f30916e = r100;
    }

    public void updateMaxIntensity(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        if (r100 <= this.f30924m) goto L10;
        this.f30923l = r100;
        return;
    }

    public void updateMaxShowLevel(int r100) {
        if (r100 >= this.f30919h) goto L6;
        return;
    L6:
        if (r100 <= 22) goto L9;
        this.f30918g = 22;
        return;
    L9:
        this.f30918g = r100;
    }

    public void updateMinIntensity(float r100) {
        if (r100 >= 0.0f) goto L7;
        this.f30924m = 0.0f;
        return;
    L7:
        if (r100 < this.f30923l) goto L9;
        return;
    L9:
        this.f30924m = r100;
    }

    public void updateMinShowLevel(int r100) {
        if (r100 >= 4) goto L7;
        this.f30919h = 4;
        return;
    L7:
        if (r100 <= this.f30918g) goto L9;
        return;
    L9:
        this.f30919h = r100;
    }

    public void updateOpacity(double r100) {
        if (r100 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        this.f30930s = AudioStats.AUDIO_AMPLITUDE_NONE;
        return;
    L7:
        if (r100 <= 1.0d) goto L10;
        this.f30930s = 1.0d;
        return;
    L10:
        this.f30930s = r100;
    }

    public void updateRadius(int r100) {
        if (r100 >= 10) goto L7;
        this.f30927p = 10;
        return;
    L7:
        if (r100 <= 50) goto L10;
        this.f30927p = 50;
        return;
    L10:
        this.f30927p = r100;
    }

    public void updateRadiusMeter(int r100) {
        if (r100 >= 10) goto L7;
        this.f30928q = 10;
        return;
    L7:
        if (r100 <= 50) goto L10;
        this.f30928q = 50;
        return;
    L10:
        this.f30928q = r100;
    }

    public void updateWeightedData(Collection<WeightedLatLng> r100) {
        if (r100 == null) goto L12;
        if (r100.isEmpty() == true) goto L12;
        if (r100.contains(null) == true) goto L10;
        this.f30921j = r100;
        return;
    L10:
        throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
    L12:
        throw new IllegalArgumentException("BDMapSDKException: No input points.");
    }

    public void updateWeightedDatas(List<List<WeightedLatLng>> r100) {
        if (r100 == null) goto L12;
        if (r100.isEmpty() == true) goto L12;
        if (r100.contains(null) == true) goto L10;
        this.f30922k = r100;
        return;
    L10:
        throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
    L12:
        throw new IllegalArgumentException("BDMapSDKException: No input points.");
    }

    private void a(Gradient r100) {
        this.f30929r = r100;
        this.f30932u = r100.a(this.f30930s);
        this.f30933v = r100.b();
    }

    private static List<List<WeightedLatLng>> b(List<List<LatLng>> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<List<LatLng>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add((List) d(r102.next()));
        goto L4
    L6:
        return r101;
    }

    public static /* synthetic */ Collection a(Collection r100) {
        return d(r100);
    }

    public static /* synthetic */ List a(List r100) {
        return b(r100);
    }

    public /* synthetic */ HeatMap(Builder r100, d r101) {
        this(r100);
    }

    private HeatMapData a(int r100, int r101) {
        List<List<WeightedLatLng>> r102 = this.f30922k;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r100 < r102.size()) goto L8;
        return null;
    L8:
        Collection r103 = (Collection) ListProtector.get(this.f30922k, r100);
        List<double[]> r104 = this.f30936y;
        if (r104 != null) goto L11;
    L13:
        float r105 = 0.0f;
    L15:
        return new HeatMapData(r103, r105);
    L11:
        if (r104.size() <= r100) goto L13;
        r105 = (float) ((double[]) ListProtector.get(this.f30936y, r100))[r101];
        goto L15
    }

    private HeatMapData b(int r100, int r101) {
        Collection<WeightedLatLng> r102 = this.f30921j;
        if (r102 != null) goto L6;
        return null;
    L6:
        double[] r103 = this.f30935x;
        if (r103 == null) goto L9;
        float r104 = (float) r103[r101];
    L11:
        return new HeatMapData(r102, r104);
    L9:
        r104 = 0.0f;
        goto L11
    }

    public HeatMapData getData(int r100, int r101) {
        if (r101 <= 23) goto L5;
    L19:
        return null;
    L5:
        if (r101 < 4) goto L19;
        List<List<WeightedLatLng>> r102 = this.f30922k;
        if (r102 == null) goto L10;
    L12:
        if (r102 == null) goto L16;
        return a(r100, r101);
    L16:
        if (this.f30921j == null) goto L19;
        return b(r100, r101);
    L10:
        if (this.f30921j != null) goto L12;
        return null;
    }

    private static double[] a(int r100, double r101) {
        double[] r102 = new double[(r100 * 2) + 1];
        int r103 = -r100;
    L3:
        if (r103 > r100) goto L5;
        r102[r103 + r100] = Math.exp(((double) ((-r103) * r103)) / ((2.0d * r101) * r101));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    private static double a(Collection<WeightedLatLng> r210, c r211, int r212, int r213) {
        double r100 = r211.f31585a;
        double r101 = r211.f31587c;
        double r102 = r211.f31586b;
        double r103 = r101 - r100;
        double r104 = r211.f31588d - r102;
        if (r103 > r104) goto L6;
        r103 = r104;
    L6:
        double r105 = ((double) ((int) (((double) (r213 / (r212 * 2))) + 0.5d))) / r103;
        LongSparseArray r106 = new LongSparseArray();
        Iterator<WeightedLatLng> r107 = r210.iterator();
        double r110 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L8:
        if (r107.hasNext() == false) goto L19;
        WeightedLatLng r108 = r107.next();
        double r111 = r108.getPoint().x;
        int r109 = (int) ((((double) r108.getPoint().y) - r102) * r105);
        long r112 = (int) ((r111 - r100) * r105);
        LongSparseArray r113 = (LongSparseArray) r106.get(r112);
        if (r113 != null) goto L12;
        r113 = new LongSparseArray();
        r106.put(r112, r113);
    L12:
        long r114 = r109;
        Double r115 = (Double) r113.get(r114);
        if (r115 != null) goto L15;
        r115 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L15:
        LongSparseArray r214 = r106;
        double r116 = r100;
        Double r117 = Double.valueOf(r115.doubleValue() + r108.intensity);
        r113.put(r114, r117);
        if (r117.doubleValue() <= r110) goto L18;
        r110 = r117.doubleValue();
    L18:
        r106 = r214;
        r100 = r116;
        goto L8
    L19:
        return r110;
    }
}
