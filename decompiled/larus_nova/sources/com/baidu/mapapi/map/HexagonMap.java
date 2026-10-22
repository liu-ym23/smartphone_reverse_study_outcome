package com.baidu.mapapi.map;

import android.graphics.Color;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class HexagonMap {
    public static final Gradient DEFAULT_GRADIENT = null;
    public static final int DEFAULT_MAX_HIGH = 0;
    public static final int DEFAULT_MAX_LEVEL = 22;
    public static final int DEFAULT_MIN_LEVEL = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f30961a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float[] f30962b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Collection<WeightedLatLng> f30963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f30964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f30965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HexagonType f30966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f30967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f30968h;
    protected b hexagonMapLayerListener;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f30969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Gradient f30970j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f30971k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f30972l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f30973m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float[] f30974n;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Collection<WeightedLatLng> f30975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f30976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private HexagonType f30977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f30978d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Gradient f30979e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f30980f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f30981g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f30982h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f30983i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private float f30984j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private float f30985k;

        public HexagonMap build() {
            if (this.f30975a == null) goto L7;
            return new HexagonMap(this, null);
        L7:
            throw new IllegalStateException("BDMapSDKException: No input data: you must use either .data or .weightedData before building");
        }

        public Builder() {
            this.f30976b = 200.0f;
            this.f30977c = HexagonType.VERTEX_UP;
            this.f30978d = 5.0f;
            this.f30979e = HexagonMap.DEFAULT_GRADIENT;
            this.f30980f = 1.0f;
            this.f30981g = 0;
            this.f30982h = 22;
            this.f30983i = 4;
            this.f30984j = 1.0f;
            this.f30985k = 0.0f;
        }

        public static /* synthetic */ Collection a(Builder r100) {
            return r100.f30975a;
        }

        public static /* synthetic */ float b(Builder r100) {
            return r100.f30976b;
        }

        public static /* synthetic */ float c(Builder r100) {
            return r100.f30978d;
        }

        public static /* synthetic */ HexagonType d(Builder r100) {
            return r100.f30977c;
        }

        public static /* synthetic */ Gradient e(Builder r100) {
            return r100.f30979e;
        }

        public static /* synthetic */ int f(Builder r100) {
            return r100.f30982h;
        }

        public static /* synthetic */ int g(Builder r100) {
            return r100.f30983i;
        }

        public static /* synthetic */ float h(Builder r100) {
            return r100.f30984j;
        }

        public static /* synthetic */ float i(Builder r100) {
            return r100.f30985k;
        }

        public static /* synthetic */ float j(Builder r100) {
            return r100.f30980f;
        }

        public Builder data(Collection<LatLng> r100) {
            if (r100 == null) goto L12;
            if (r100.isEmpty() == true) goto L12;
            if (r100.contains(null) == true) goto L10;
            return weightedData(HexagonMap.a(r100));
        L10:
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        L12:
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }

        public Builder gap(float r100) {
            if (r100 >= 0.0f) goto L6;
            this.f30978d = 0.0f;
            return this;
        L6:
            this.f30978d = r100;
            return this;
        }

        public Builder gradient(Gradient r100) {
            if (r100 == null) goto L6;
            this.f30979e = r100;
            return this;
        L6:
            throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
        }

        public Builder hexagonType(HexagonType r100) {
            this.f30977c = r100;
            return this;
        }

        public Builder maxIntensity(float r100) {
            if (r100 >= 0.0f) goto L5;
        L8:
            return this;
        L5:
            if (r100 <= this.f30985k) goto L8;
            this.f30984j = r100;
            goto L8
        }

        public Builder maxShowLevel(int r100) {
            if (r100 >= this.f30983i) goto L6;
            return this;
        L6:
            if (r100 <= 22) goto L8;
            this.f30982h = 22;
        L8:
            this.f30982h = r100;
            return this;
        }

        public Builder minIntensity(float r100) {
            if (r100 >= 0.0f) goto L7;
            this.f30985k = 0.0f;
            return this;
        L7:
            if (r100 < this.f30984j) goto L9;
            return this;
        L9:
            this.f30985k = r100;
            return this;
        }

        public Builder minShowLevel(int r100) {
            if (r100 >= 4) goto L7;
            this.f30983i = 4;
            return this;
        L7:
            if (r100 <= this.f30982h) goto L9;
            return this;
        L9:
            this.f30983i = r100;
            return this;
        }

        public Builder opacity(float r100) {
            if (r100 >= 0.0f) goto L7;
            this.f30980f = 0.0f;
            return this;
        L7:
            if (r100 <= 1.0f) goto L10;
            this.f30980f = 1.0f;
            return this;
        L10:
            this.f30980f = r100;
            return this;
        }

        public Builder radius(int r100) {
            if (r100 >= 0) goto L4;
            return this;
        L4:
            this.f30976b = r100;
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> r100) {
            if (r100 == null) goto L12;
            if (r100.isEmpty() == true) goto L12;
            if (r100.contains(null) == true) goto L10;
            this.f30975a = r100;
            return this;
        L10:
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        L12:
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
    }

    public static final enum HexagonType extends Enum<HexagonType> {
        public static final HexagonType EDGE_UP = null;
        public static final HexagonType VERTEX_UP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ HexagonType[] f30986a = null;

        static {
            HexagonType r100 = new HexagonType("VERTEX_UP", 0);
            VERTEX_UP = r100;
            HexagonType r101 = new HexagonType("EDGE_UP", 1);
            EDGE_UP = r101;
            f30986a = new HexagonType[]{r100, r101};
        }

        public static HexagonType[] values() {
            return (HexagonType[]) f30986a.clone();
        }

        public static HexagonType valueOf(String r100) {
            return (HexagonType) r27.a.a(HexagonType.class, r100);
        }

        private HexagonType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public interface b {
        void a(HexagonMap r100);

        void a(HexagonMap r100, boolean r101);
    }

    static {
        int[] r100 = {Color.rgb(0, 0, 250), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        f30961a = r100;
        float[] r101 = {0.0f, 0.5f, 1.0f};
        f30962b = r101;
        DEFAULT_GRADIENT = new Gradient(r100, r101);
    }

    public void remove() {
        Collection<WeightedLatLng> r100 = this.f30963c;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.hexagonMapLayerListener.a(this);
    }

    public Bundle toBundle() {
        Bundle r100 = new Bundle();
        r100.putFloat("radius", this.f30964d);
        r100.putFloat("gap", this.f30965e);
        r100.putFloat("alpha", this.f30967g);
        new HexagonMapData(this.f30963c, this.f30968h).toBundle(r100);
        r100.putIntArray("color_array", this.f30973m);
        r100.putInt("hexagon_type", this.f30966f.ordinal());
        r100.putFloatArray("color_start_points", this.f30974n);
        r100.putFloat("max_intentity", this.f30968h);
        r100.putFloat("min_intentity", this.f30969i);
        r100.putFloat("max_show_level", this.f30971k);
        r100.putFloat("min_show_level", this.f30972l);
        return r100;
    }

    private HexagonMap(Builder r100) {
        this.f30963c = Builder.a(r100);
        this.f30964d = Builder.b(r100);
        this.f30965e = Builder.c(r100);
        this.f30966f = Builder.d(r100);
        this.f30970j = Builder.e(r100);
        this.f30971k = Builder.f(r100);
        this.f30972l = Builder.g(r100);
        this.f30968h = Builder.h(r100);
        this.f30969i = Builder.i(r100);
        this.f30967g = Builder.j(r100);
        a(this.f30970j);
    }

    private void a(Gradient r100) {
        this.f30970j = r100;
        this.f30973m = r100.a(this.f30967g);
        this.f30974n = r100.b();
    }

    private static Collection<WeightedLatLng> b(Collection<LatLng> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<LatLng> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(new WeightedLatLng(r102.next()));
        goto L4
    L6:
        return r101;
    }

    public void setShow(boolean r100) {
        this.hexagonMapLayerListener.a(this, r100);
    }

    public static /* synthetic */ Collection a(Collection r100) {
        return b(r100);
    }

    public /* synthetic */ HexagonMap(Builder r100, a r101) {
        this(r100);
    }
}
