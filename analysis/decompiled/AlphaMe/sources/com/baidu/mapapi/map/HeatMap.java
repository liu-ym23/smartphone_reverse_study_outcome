package com.baidu.mapapi.map;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.util.SparseIntArray;
import com.alibaba.fastjson.util.UTF8Decoder;
import com.baidu.mapapi.map.HeatMapAnimation;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class HeatMap {
    public static final Gradient DEFAULT_GRADIENT;
    public static final int DEFAULT_MAX_HIGH = 0;
    public static final int DEFAULT_MAX_LEVEL = 22;
    public static final int DEFAULT_MIN_LEVEL = 4;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;

    /* renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f6393a;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f6394b;

    /* renamed from: c, reason: collision with root package name */
    private static final float[] f6395c;

    /* renamed from: d, reason: collision with root package name */
    private static int f6396d;

    /* renamed from: A, reason: collision with root package name */
    private ExecutorService f6397A;

    /* renamed from: B, reason: collision with root package name */
    private HashSet<String> f6398B;

    /* renamed from: C, reason: collision with root package name */
    BaiduMap f6399C;

    /* renamed from: D, reason: collision with root package name */
    private int f6400D;

    /* renamed from: e, reason: collision with root package name */
    private int f6401e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6402f;

    /* renamed from: g, reason: collision with root package name */
    private int f6403g;

    /* renamed from: h, reason: collision with root package name */
    private int f6404h;

    /* renamed from: i, reason: collision with root package name */
    private e<WeightedLatLng> f6405i;

    /* renamed from: j, reason: collision with root package name */
    private Collection<WeightedLatLng> f6406j;

    /* renamed from: k, reason: collision with root package name */
    private List<List<WeightedLatLng>> f6407k;

    /* renamed from: l, reason: collision with root package name */
    private float f6408l;

    /* renamed from: m, reason: collision with root package name */
    private float f6409m;
    protected boolean mIsSetMaxIntensity;

    /* renamed from: n, reason: collision with root package name */
    private HeatMapAnimation f6410n;

    /* renamed from: o, reason: collision with root package name */
    private HeatMapAnimation f6411o;

    /* renamed from: p, reason: collision with root package name */
    private int f6412p;

    /* renamed from: q, reason: collision with root package name */
    private int f6413q;

    /* renamed from: r, reason: collision with root package name */
    private Gradient f6414r;

    /* renamed from: s, reason: collision with root package name */
    private double f6415s;

    /* renamed from: t, reason: collision with root package name */
    private c f6416t;

    /* renamed from: u, reason: collision with root package name */
    private int[] f6417u;

    /* renamed from: v, reason: collision with root package name */
    private float[] f6418v;

    /* renamed from: w, reason: collision with root package name */
    private double[] f6419w;

    /* renamed from: x, reason: collision with root package name */
    private double[] f6420x;

    /* renamed from: y, reason: collision with root package name */
    private List<double[]> f6421y;

    /* renamed from: z, reason: collision with root package name */
    private HashMap<String, Tile> f6422z;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Collection<WeightedLatLng> f6423a;

        /* renamed from: b, reason: collision with root package name */
        private List<List<WeightedLatLng>> f6424b;

        /* renamed from: c, reason: collision with root package name */
        private int f6425c = 12;

        /* renamed from: d, reason: collision with root package name */
        private int f6426d = 12;

        /* renamed from: e, reason: collision with root package name */
        private Gradient f6427e = HeatMap.DEFAULT_GRADIENT;

        /* renamed from: f, reason: collision with root package name */
        private double f6428f = 0.6d;

        /* renamed from: g, reason: collision with root package name */
        private int f6429g = 0;

        /* renamed from: h, reason: collision with root package name */
        private boolean f6430h = false;

        /* renamed from: i, reason: collision with root package name */
        private int f6431i = 22;

        /* renamed from: j, reason: collision with root package name */
        private int f6432j = 4;

        /* renamed from: k, reason: collision with root package name */
        private float f6433k = 1.0f;

        /* renamed from: l, reason: collision with root package name */
        private float f6434l = Property.DEFAULT_FLOAT_VALUE;

        /* renamed from: m, reason: collision with root package name */
        private boolean f6435m = false;

        /* renamed from: n, reason: collision with root package name */
        private HeatMapAnimation f6436n;

        /* renamed from: o, reason: collision with root package name */
        private HeatMapAnimation f6437o;

        public Builder() {
            HeatMapAnimation.AnimationType animationType = HeatMapAnimation.AnimationType.Linear;
            this.f6436n = new HeatMapAnimation(false, 100, animationType);
            this.f6437o = new HeatMapAnimation(false, 100, animationType);
        }

        public HeatMap build() {
            if (this.f6423a == null && this.f6424b == null) {
                throw new IllegalStateException("BDMapSDKException: No input data: you must use either .data or .weightedData before building");
            }
            return new HeatMap(this, null);
        }

        public Builder data(Collection<LatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            return weightedData(HeatMap.d(collection));
        }

        public Builder datas(List<List<LatLng>> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input datas.");
            }
            if (list.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            return weightedDatas(HeatMap.b(list));
        }

        public Builder frameAnimation(HeatMapAnimation heatMapAnimation) {
            this.f6437o = heatMapAnimation;
            return this;
        }

        public Builder gradient(Gradient gradient) {
            if (gradient == null) {
                throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
            }
            this.f6427e = gradient;
            return this;
        }

        public Builder initAnimation(HeatMapAnimation heatMapAnimation) {
            this.f6436n = heatMapAnimation;
            return this;
        }

        public Builder isRadiusMeter(boolean z4) {
            this.f6430h = z4;
            return this;
        }

        public Builder maxHigh(int i4) {
            if (i4 < 0) {
                return this;
            }
            if (i4 > 200) {
                this.f6429g = 200;
                return this;
            }
            this.f6429g = i4;
            return this;
        }

        public Builder maxIntensity(float f4) {
            if (f4 >= Property.DEFAULT_FLOAT_VALUE && f4 > this.f6434l) {
                this.f6433k = f4;
                this.f6435m = true;
            }
            return this;
        }

        public Builder maxShowLevel(int i4) {
            if (i4 < this.f6432j) {
                return this;
            }
            if (i4 > 22) {
                this.f6431i = 22;
            }
            this.f6431i = i4;
            return this;
        }

        public Builder minIntensity(float f4) {
            if (f4 < Property.DEFAULT_FLOAT_VALUE) {
                this.f6434l = Property.DEFAULT_FLOAT_VALUE;
                return this;
            }
            if (f4 >= this.f6433k) {
                return this;
            }
            this.f6434l = f4;
            return this;
        }

        public Builder minShowLevel(int i4) {
            if (i4 < 4) {
                this.f6432j = 4;
                return this;
            }
            if (i4 > this.f6431i) {
                return this;
            }
            this.f6432j = i4;
            return this;
        }

        public Builder opacity(double d4) {
            if (d4 < 0.0d) {
                this.f6428f = 0.0d;
                return this;
            }
            if (d4 > 1.0d) {
                this.f6428f = 1.0d;
                return this;
            }
            this.f6428f = d4;
            return this;
        }

        public Builder radius(int i4) {
            if (i4 < 10) {
                this.f6425c = 10;
                return this;
            }
            if (i4 > 50) {
                this.f6425c = 50;
                return this;
            }
            this.f6425c = i4;
            return this;
        }

        public Builder radiusMeter(int i4) {
            if (i4 < 10) {
                this.f6426d = 10;
                return this;
            }
            if (i4 > 50) {
                this.f6426d = 50;
                return this;
            }
            this.f6426d = i4;
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            this.f6423a = collection;
            return this;
        }

        public Builder weightedDatas(List<List<WeightedLatLng>> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            if (list.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            this.f6424b = list;
            return this;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6393a = sparseIntArray;
        sparseIntArray.put(3, BmLocated.ALIGN_RIGHT);
        sparseIntArray.put(4, BmLocated.ALIGN_LEFT);
        sparseIntArray.put(5, BmLocated.ALIGN_BOTTOM);
        sparseIntArray.put(6, BmLocated.ALIGN_TOP);
        sparseIntArray.put(7, 524288);
        sparseIntArray.put(8, 262144);
        sparseIntArray.put(9, 131072);
        sparseIntArray.put(10, UTF8Decoder.Surrogate.UCS4_MIN);
        sparseIntArray.put(11, 32768);
        sparseIntArray.put(12, 16384);
        sparseIntArray.put(13, 8192);
        sparseIntArray.put(14, 4096);
        sparseIntArray.put(15, 2048);
        sparseIntArray.put(16, 1024);
        sparseIntArray.put(17, 512);
        sparseIntArray.put(18, 256);
        sparseIntArray.put(19, 128);
        sparseIntArray.put(20, 64);
        int[] iArr = {Color.rgb(0, 0, 200), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        f6394b = iArr;
        float[] fArr = {0.08f, 0.4f, 1.0f};
        f6395c = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
        f6396d = 0;
    }

    public /* synthetic */ HeatMap(Builder builder, d dVar) {
        this(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<List<WeightedLatLng>> b(List<List<LatLng>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<List<LatLng>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((List) d(it.next()));
        }
        return arrayList;
    }

    private void c(Collection<WeightedLatLng> collection) {
        this.f6406j = collection;
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
        c cVarB = b(this.f6406j);
        this.f6416t = cVarB;
        this.f6405i = new e<>(cVarB);
        Iterator<WeightedLatLng> it = this.f6406j.iterator();
        while (it.hasNext()) {
            this.f6405i.a(it.next());
        }
        this.f6420x = a(this.f6412p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> d(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    public HeatMapData getData(int i4, int i5) {
        List<List<WeightedLatLng>> list;
        if (i5 > 23 || i5 < 4 || ((list = this.f6407k) == null && this.f6406j == null)) {
            return null;
        }
        if (list != null) {
            return a(i4, i5);
        }
        if (this.f6406j != null) {
            return b(i4, i5);
        }
        return null;
    }

    public int getMaxHigh() {
        return this.f6401e;
    }

    public boolean isFrameAnimation() {
        HeatMapAnimation heatMapAnimation = this.f6410n;
        if (heatMapAnimation == null) {
            return false;
        }
        return heatMapAnimation.getIsAnimation();
    }

    public boolean isInitAnimation() {
        HeatMapAnimation heatMapAnimation = this.f6411o;
        if (heatMapAnimation == null) {
            return false;
        }
        return heatMapAnimation.getIsAnimation();
    }

    public void removeHeatMap() {
        BaiduMap baiduMap = this.f6399C;
        if (baiduMap != null) {
            baiduMap.a(this);
        }
        List<List<WeightedLatLng>> list = this.f6407k;
        if (list != null) {
            list.clear();
        }
        Collection<WeightedLatLng> collection = this.f6406j;
        if (collection != null) {
            collection.clear();
        }
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("grid_size", this.f6400D);
        bundle.putFloat("point_size_meter", this.f6413q * 2);
        bundle.putFloat("point_size", this.f6412p * 2);
        bundle.putFloat("max_hight", this.f6401e);
        bundle.putFloat(ViewTweenItem.ALPHA, (float) this.f6415s);
        List<List<WeightedLatLng>> list = this.f6407k;
        if (list != null) {
            bundle.putInt("frame_count", list.size());
        } else if (this.f6406j != null) {
            bundle.putInt("frame_count", 1);
        }
        bundle.putIntArray("color_array", this.f6417u);
        bundle.putFloatArray("color_start_points", this.f6418v);
        bundle.putBoolean("is_need_init_animation", this.f6411o.getIsAnimation());
        bundle.putBoolean("is_need_frame_animation", this.f6410n.getIsAnimation());
        bundle.putBoolean("point_size_is_meter", this.f6402f);
        bundle.putInt("init_animation_duration", this.f6411o.getDuration());
        bundle.putInt("init_animation_type", this.f6411o.getAnimationType());
        bundle.putInt("frame_animation_duration", this.f6410n.getDuration());
        bundle.putInt("frame_animation_type", this.f6410n.getAnimationType());
        bundle.putFloat("max_intentity", this.f6408l);
        bundle.putFloat("min_intentity", this.f6409m);
        bundle.putFloat("max_show_level", this.f6403g);
        bundle.putFloat("min_show_level", this.f6404h);
        return bundle;
    }

    public void updateData(Collection<LatLng> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
        if (collection.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        updateWeightedData(d(collection));
    }

    public void updateDatas(List<List<LatLng>> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: No input datas.");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        updateWeightedDatas(b(list));
    }

    public void updateFrameAnimation(HeatMapAnimation heatMapAnimation) {
        this.f6410n = heatMapAnimation;
    }

    public void updateGradient(Gradient gradient) {
        if (gradient == null) {
            throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
        }
        this.f6414r = gradient;
        a(gradient);
    }

    public void updateIsRadiusMeter(boolean z4) {
        this.f6402f = z4;
    }

    public void updateMaxHigh(int i4) {
        if (i4 < 0) {
            return;
        }
        if (i4 > 200) {
            this.f6401e = 200;
        } else {
            this.f6401e = i4;
        }
    }

    public void updateMaxIntensity(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE || f4 <= this.f6409m) {
            return;
        }
        this.f6408l = f4;
    }

    public void updateMaxShowLevel(int i4) {
        if (i4 < this.f6404h) {
            return;
        }
        if (i4 > 22) {
            this.f6403g = 22;
        } else {
            this.f6403g = i4;
        }
    }

    public void updateMinIntensity(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            this.f6409m = Property.DEFAULT_FLOAT_VALUE;
        } else {
            if (f4 >= this.f6408l) {
                return;
            }
            this.f6409m = f4;
        }
    }

    public void updateMinShowLevel(int i4) {
        if (i4 < 4) {
            this.f6404h = 4;
        } else {
            if (i4 > this.f6403g) {
                return;
            }
            this.f6404h = i4;
        }
    }

    public void updateOpacity(double d4) {
        if (d4 < 0.0d) {
            this.f6415s = 0.0d;
        } else if (d4 > 1.0d) {
            this.f6415s = 1.0d;
        } else {
            this.f6415s = d4;
        }
    }

    public void updateRadius(int i4) {
        if (i4 < 10) {
            this.f6412p = 10;
        } else if (i4 > 50) {
            this.f6412p = 50;
        } else {
            this.f6412p = i4;
        }
    }

    public void updateRadiusMeter(int i4) {
        if (i4 < 10) {
            this.f6413q = 10;
        } else if (i4 > 50) {
            this.f6413q = 50;
        } else {
            this.f6413q = i4;
        }
    }

    public void updateWeightedData(Collection<WeightedLatLng> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
        if (collection.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        this.f6406j = collection;
    }

    public void updateWeightedDatas(List<List<WeightedLatLng>> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        this.f6407k = list;
    }

    private HeatMap(Builder builder) {
        this.f6401e = 200;
        this.f6402f = false;
        this.f6403g = 22;
        this.f6404h = 4;
        this.f6400D = SysOSUtil.getInstance().getScreenWidth() / 2;
        this.f6422z = new HashMap<>();
        this.f6397A = Executors.newFixedThreadPool(1);
        this.f6398B = new HashSet<>();
        this.f6407k = builder.f6424b;
        this.f6412p = builder.f6425c;
        this.f6413q = builder.f6426d;
        this.f6402f = builder.f6430h;
        this.f6403g = builder.f6431i;
        this.f6404h = builder.f6432j;
        boolean z4 = builder.f6435m;
        this.mIsSetMaxIntensity = z4;
        if (!z4 && this.f6407k != null) {
            this.f6421y = new ArrayList();
            for (int i4 = 0; i4 < this.f6407k.size(); i4++) {
                List<WeightedLatLng> list = this.f6407k.get(i4);
                this.f6406j = list;
                this.f6416t = b(list);
                this.f6421y.add(a(this.f6412p));
            }
        }
        Collection<WeightedLatLng> collection = builder.f6423a;
        this.f6406j = collection;
        if (!this.mIsSetMaxIntensity && collection != null) {
            c(collection);
        }
        this.f6411o = builder.f6436n;
        this.f6410n = builder.f6437o;
        this.f6401e = builder.f6429g;
        this.f6408l = builder.f6433k;
        this.f6409m = builder.f6434l;
        this.f6414r = builder.f6427e;
        this.f6415s = builder.f6428f;
        int i5 = this.f6412p;
        this.f6419w = a(i5, i5 / 3.0d);
        a(this.f6414r);
    }

    private HeatMapData a(int i4, int i5) {
        List<List<WeightedLatLng>> list = this.f6407k;
        if (list == null || i4 >= list.size()) {
            return null;
        }
        List<WeightedLatLng> list2 = this.f6407k.get(i4);
        List<double[]> list3 = this.f6421y;
        return new HeatMapData(list2, (list3 == null || list3.size() <= i4) ? Property.DEFAULT_FLOAT_VALUE : (float) this.f6421y.get(i4)[i5]);
    }

    private HeatMapData b(int i4, int i5) {
        Collection<WeightedLatLng> collection = this.f6406j;
        if (collection == null) {
            return null;
        }
        double[] dArr = this.f6420x;
        return new HeatMapData(collection, dArr != null ? (float) dArr[i5] : Property.DEFAULT_FLOAT_VALUE);
    }

    private synchronized void b() {
        this.f6422z.clear();
    }

    public void c() {
        this.f6397A.shutdownNow();
    }

    private static c b(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d4 = next.getPoint().x;
        double d5 = d4;
        double d6 = next.getPoint().x;
        double d7 = next.getPoint().y;
        double d8 = next.getPoint().y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d9 = next2.getPoint().x;
            double d10 = next2.getPoint().y;
            if (d9 < d5) {
                d5 = d9;
            }
            if (d9 > d6) {
                d6 = d9;
            }
            if (d10 < d7) {
                d7 = d10;
            }
            if (d10 > d8) {
                d8 = d10;
            }
        }
        return new c(d5, d6, d7, d8);
    }

    public void a() {
        b();
    }

    private void a(Gradient gradient) {
        this.f6414r = gradient;
        this.f6417u = gradient.a(this.f6415s);
        this.f6418v = gradient.b();
    }

    private double[] a(int i4) {
        int i5;
        double[] dArr = new double[23];
        int i6 = 4;
        while (true) {
            if (i6 >= 11) {
                break;
            }
            dArr[i6] = a(this.f6406j, this.f6416t, i4, (int) (Math.pow(2.0d, i6 - 3) * 1280.0d));
            if (i6 == 4) {
                for (int i7 = 0; i7 < i6; i7++) {
                    dArr[i7] = dArr[i6];
                }
            }
            i6++;
        }
        for (i5 = 11; i5 < 23; i5++) {
            dArr[i5] = dArr[10];
        }
        return dArr;
    }

    private static double[] a(int i4, double d4) {
        double[] dArr = new double[(i4 * 2) + 1];
        for (int i5 = -i4; i5 <= i4; i5++) {
            dArr[i5 + i4] = Math.exp(((-i5) * i5) / ((2.0d * d4) * d4));
        }
        return dArr;
    }

    private static double a(Collection<WeightedLatLng> collection, c cVar, int i4, int i5) {
        double d4 = cVar.f7150a;
        double d5 = cVar.f7152c;
        double d6 = cVar.f7151b;
        double d7 = d5 - d4;
        double d8 = cVar.f7153d - d6;
        if (d7 <= d8) {
            d7 = d8;
        }
        double d9 = ((int) ((i5 / (i4 * 2)) + 0.5d)) / d7;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d10 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            int i6 = (int) ((weightedLatLng.getPoint().y - d6) * d9);
            long j4 = (int) ((weightedLatLng.getPoint().x - d4) * d9);
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j4);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j4, longSparseArray2);
            }
            long j5 = i6;
            Double dValueOf = (Double) longSparseArray2.get(j5);
            if (dValueOf == null) {
                dValueOf = Double.valueOf(0.0d);
            }
            LongSparseArray longSparseArray3 = longSparseArray;
            double d11 = d4;
            double dDoubleValue = dValueOf.doubleValue() + weightedLatLng.intensity;
            longSparseArray2.put(j5, Double.valueOf(dDoubleValue));
            if (dDoubleValue > d10) {
                longSparseArray = longSparseArray3;
                d10 = dDoubleValue;
            } else {
                longSparseArray = longSparseArray3;
            }
            d4 = d11;
        }
        return d10;
    }
}
