package com.baidu.mapapi.map;

import android.graphics.Color;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class HexagonMap {
    public static final Gradient DEFAULT_GRADIENT;
    public static final int DEFAULT_MAX_HIGH = 0;
    public static final int DEFAULT_MAX_LEVEL = 22;
    public static final int DEFAULT_MIN_LEVEL = 4;

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f6446a;

    /* renamed from: b, reason: collision with root package name */
    private static final float[] f6447b;

    /* renamed from: c, reason: collision with root package name */
    private Collection<WeightedLatLng> f6448c;

    /* renamed from: d, reason: collision with root package name */
    private float f6449d;

    /* renamed from: e, reason: collision with root package name */
    private float f6450e;

    /* renamed from: f, reason: collision with root package name */
    private HexagonType f6451f;

    /* renamed from: g, reason: collision with root package name */
    private float f6452g;

    /* renamed from: h, reason: collision with root package name */
    private float f6453h;
    protected b hexagonMapLayerListener;

    /* renamed from: i, reason: collision with root package name */
    private float f6454i;

    /* renamed from: j, reason: collision with root package name */
    private Gradient f6455j;

    /* renamed from: k, reason: collision with root package name */
    private int f6456k;

    /* renamed from: l, reason: collision with root package name */
    private int f6457l;

    /* renamed from: m, reason: collision with root package name */
    private int[] f6458m;

    /* renamed from: n, reason: collision with root package name */
    private float[] f6459n;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Collection<WeightedLatLng> f6460a;

        /* renamed from: b, reason: collision with root package name */
        private float f6461b = 200.0f;

        /* renamed from: c, reason: collision with root package name */
        private HexagonType f6462c = HexagonType.VERTEX_UP;

        /* renamed from: d, reason: collision with root package name */
        private float f6463d = 5.0f;

        /* renamed from: e, reason: collision with root package name */
        private Gradient f6464e = HexagonMap.DEFAULT_GRADIENT;

        /* renamed from: f, reason: collision with root package name */
        private float f6465f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        private int f6466g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f6467h = 22;

        /* renamed from: i, reason: collision with root package name */
        private int f6468i = 4;

        /* renamed from: j, reason: collision with root package name */
        private float f6469j = 1.0f;

        /* renamed from: k, reason: collision with root package name */
        private float f6470k = Property.DEFAULT_FLOAT_VALUE;

        public HexagonMap build() {
            if (this.f6460a != null) {
                return new HexagonMap(this);
            }
            throw new IllegalStateException("BDMapSDKException: No input data: you must use either .data or .weightedData before building");
        }

        public Builder data(Collection<LatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            return weightedData(HexagonMap.b(collection));
        }

        public Builder gap(float f4) {
            if (f4 < Property.DEFAULT_FLOAT_VALUE) {
                this.f6463d = Property.DEFAULT_FLOAT_VALUE;
                return this;
            }
            this.f6463d = f4;
            return this;
        }

        public Builder gradient(Gradient gradient) {
            if (gradient == null) {
                throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
            }
            this.f6464e = gradient;
            return this;
        }

        public Builder hexagonType(HexagonType hexagonType) {
            this.f6462c = hexagonType;
            return this;
        }

        public Builder maxIntensity(float f4) {
            if (f4 >= Property.DEFAULT_FLOAT_VALUE && f4 > this.f6470k) {
                this.f6469j = f4;
            }
            return this;
        }

        public Builder maxShowLevel(int i4) {
            if (i4 < this.f6468i) {
                return this;
            }
            if (i4 > 22) {
                this.f6467h = 22;
            }
            this.f6467h = i4;
            return this;
        }

        public Builder minIntensity(float f4) {
            if (f4 < Property.DEFAULT_FLOAT_VALUE) {
                this.f6470k = Property.DEFAULT_FLOAT_VALUE;
                return this;
            }
            if (f4 >= this.f6469j) {
                return this;
            }
            this.f6470k = f4;
            return this;
        }

        public Builder minShowLevel(int i4) {
            if (i4 < 4) {
                this.f6468i = 4;
                return this;
            }
            if (i4 > this.f6467h) {
                return this;
            }
            this.f6468i = i4;
            return this;
        }

        public Builder opacity(float f4) {
            if (f4 < Property.DEFAULT_FLOAT_VALUE) {
                this.f6465f = Property.DEFAULT_FLOAT_VALUE;
                return this;
            }
            if (f4 > 1.0f) {
                this.f6465f = 1.0f;
                return this;
            }
            this.f6465f = f4;
            return this;
        }

        public Builder radius(int i4) {
            if (i4 < 0) {
                return this;
            }
            this.f6461b = i4;
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            this.f6460a = collection;
            return this;
        }
    }

    public enum HexagonType {
        VERTEX_UP,
        EDGE_UP
    }

    public interface b {
        void a(HexagonMap hexagonMap);

        void a(HexagonMap hexagonMap, boolean z4);
    }

    static {
        int[] iArr = {Color.rgb(0, 0, 250), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        f6446a = iArr;
        float[] fArr = {Property.DEFAULT_FLOAT_VALUE, 0.5f, 1.0f};
        f6447b = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> b(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    public void remove() {
        Collection<WeightedLatLng> collection = this.f6448c;
        if (collection != null) {
            collection.clear();
        }
        this.hexagonMapLayerListener.a(this);
    }

    public void setShow(boolean z4) {
        this.hexagonMapLayerListener.a(this, z4);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat("radius", this.f6449d);
        bundle.putFloat("gap", this.f6450e);
        bundle.putFloat(ViewTweenItem.ALPHA, this.f6452g);
        new HexagonMapData(this.f6448c, this.f6453h).toBundle(bundle);
        bundle.putIntArray("color_array", this.f6458m);
        bundle.putInt("hexagon_type", this.f6451f.ordinal());
        bundle.putFloatArray("color_start_points", this.f6459n);
        bundle.putFloat("max_intentity", this.f6453h);
        bundle.putFloat("min_intentity", this.f6454i);
        bundle.putFloat("max_show_level", this.f6456k);
        bundle.putFloat("min_show_level", this.f6457l);
        return bundle;
    }

    private HexagonMap(Builder builder) {
        this.f6448c = builder.f6460a;
        this.f6449d = builder.f6461b;
        this.f6450e = builder.f6463d;
        this.f6451f = builder.f6462c;
        this.f6455j = builder.f6464e;
        this.f6456k = builder.f6467h;
        this.f6457l = builder.f6468i;
        this.f6453h = builder.f6469j;
        this.f6454i = builder.f6470k;
        this.f6452g = builder.f6465f;
        a(this.f6455j);
    }

    private void a(Gradient gradient) {
        this.f6455j = gradient;
        this.f6458m = gradient.a(this.f6452g);
        this.f6459n = gradient.b();
    }
}
