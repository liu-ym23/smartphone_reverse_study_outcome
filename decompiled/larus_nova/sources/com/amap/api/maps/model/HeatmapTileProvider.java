package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.camera.video.AudioStats;
import androidx.collection.LongSparseArray;
import com.amap.api.mapcore.util.g3;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.DPoint;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT = null;
    private static final int[] DEFAULT_GRADIENT_COLORS = null;
    private static final float[] DEFAULT_GRADIENT_START_POINTS = null;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int MAX_RADIUS = 200;
    private static final int MAX_ZOOM_LEVEL = 21;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 256;
    private g3 mBounds;
    private int[] mColorMap;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private com.amap.api.maps.model.a mTree;

    public static class Builder {
        private Collection<WeightedLatLng> data;
        private Gradient gradient;
        private double opacity;
        private int radius;

        public HeatmapTileProvider build() {
            Collection<WeightedLatLng> r100 = this.data;
            a r101 = null;
            if (r100 != null) goto L5;
        L16:
        L13:
            e = move-exception;
            e.getErrorMessage();
            e.printStackTrace();
            return null;
        L12:
            throw new AMapException("No input points.");     // Catch: AMapException -> L13
        L5:
            if (r100.size() == 0) goto L16;
            return new HeatmapTileProvider(this, r101);
        L8:
            th = move-exception;
            th.printStackTrace();
            return null;
        }

        public Builder() {
            this.radius = 12;
            this.gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
            this.opacity = 0.6d;
        }

        public static /* synthetic */ Collection a(Builder r100) {
            return r100.data;
        }

        public static /* synthetic */ int b(Builder r100) {
            return r100.radius;
        }

        public static /* synthetic */ Gradient c(Builder r100) {
            return r100.gradient;
        }

        public static /* synthetic */ double d(Builder r100) {
            return r100.opacity;
        }

        public Builder data(Collection<LatLng> r100) {
            int r101 = HeatmapTileProvider.DEFAULT_RADIUS;
            ArrayList r102 = new ArrayList();
            Iterator<LatLng> r103 = r100.iterator();
        L4:
            if (r103.hasNext() == false) goto L7;
            r102.add(new WeightedLatLng(r103.next()));
            goto L4
        L7:
            return weightedData(r102);
        }

        public Builder gradient(Gradient r100) {
            this.gradient = r100;
            return this;
        }

        public Builder radius(int r100) {
            this.radius = Math.max(10, Math.min(r100, 200));
            return this;
        }

        public Builder transparency(double r100) {
            this.opacity = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(r100, 1.0d));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> r100) {
            this.data = r100;
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    static {
        int[] r100 = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = r100;
        float[] r101 = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = r101;
        DEFAULT_GRADIENT = new Gradient(r100, r101);
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }

    private HeatmapTileProvider(Builder r100) {
        this.mData = Builder.a(r100);
        this.mRadius = Builder.b(r100);
        Gradient r101 = Builder.c(r100);
        this.mGradient = r101;
        if (r101 != null) goto L5;
    L6:
        this.mGradient = DEFAULT_GRADIENT;
    L7:
        this.mOpacity = Builder.d(r100);
        int r102 = this.mRadius;
        this.mKernel = a(r102, ((double) r102) / 3.0d);
        a(this.mGradient);
        b(this.mData);
        return;
    L5:
        if (r101.isAvailable() == true) goto L7;
        goto L6
    }

    private double[] a(int r210) {
        int r100 = 21;
        double[] r101 = new double[21];
        int r102 = 5;
    L3:
        int r103 = 11;
        if (r102 >= 11) goto L28;
        Collection<WeightedLatLng> r104 = this.mData;
        g3 r105 = this.mBounds;
        int r106 = (int) (Math.pow(2.0d, r102) * 1280.0d);
        double r107 = r105.f27297a;
        double r110 = r105.f27299c;
        double r111 = r105.f27298b;
        double r112 = r110 - r107;
        double r113 = r105.f27300d - r111;
        if (r112 > r113) goto L9;
        r112 = r113;
    L9:
        double r108 = ((double) ((int) (((double) (r106 / (r210 * 2))) + 0.5d))) / r112;
        LongSparseArray r114 = new LongSparseArray();
        Iterator<WeightedLatLng> r109 = r104.iterator();
        double r115 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L11:
        if (r109.hasNext() == false) goto L22;
        WeightedLatLng r116 = r109.next();
        int r117 = r102;
        double r118 = r116.getPoint().f30021x;
        int r119 = (int) ((r118 - r107) * r108);
        int r120 = (int) ((r116.getPoint().f30022y - r111) * r108);
        long r121 = r119;
        LongSparseArray r122 = (LongSparseArray) r114.get(r121);
        if (r122 != null) goto L15;
        r122 = new LongSparseArray();
        r114.put(r121, r122);
    L15:
        long r123 = r120;
        Double r124 = (Double) r122.get(r123);
        if (r124 != null) goto L18;
        r124 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L18:
        double r211 = r108;
        Iterator<WeightedLatLng> r125 = r109;
        Double r126 = Double.valueOf(r124.doubleValue() + r116.intensity);
        r122.put(r123, r126);
        if (r126.doubleValue() <= r115) goto L21;
        r115 = r126.doubleValue();
    L21:
        r109 = r125;
        r102 = r117;
        r108 = r211;
        goto L11
    L22:
        int r127 = r102;
        r101[r127] = r115;
        if (r127 != 5) goto L27;
        int r128 = 0;
    L25:
        if (r128 >= r127) goto L27;
        r101[r128] = r101[r127];
        r128 = r128 + 1;
    L27:
        r102 = r127 + 1;
        r100 = 21;
    L28:
        if (r103 >= r100) goto L30;
        r101[r103] = r101[10];
        r103 = r103 + 1;
        goto L28
    L30:
        return r101;
    }

    private void b(Collection<WeightedLatLng> r100) {
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L16
        Iterator<WeightedLatLng> r102 = r100.iterator();     // Catch: Throwable -> L16
    L4:
        if (r102.hasNext() == false) goto L10;
        WeightedLatLng r103 = r102.next();     // Catch: Throwable -> L16
        double r104 = r103.latLng.latitude;     // Catch: Throwable -> L16
        if (r104 >= 85.0d) goto L4;
        if (r104 <= (-85.0d)) goto L4;
        r101.add(r103);     // Catch: Throwable -> L16
        goto L4
    L10:
        this.mData = r101;     // Catch: Throwable -> L16
        g3 r105 = a(r101);     // Catch: Throwable -> L16
        this.mBounds = r105;     // Catch: Throwable -> L16
        this.mTree = new com.amap.api.maps.model.a(r105);     // Catch: Throwable -> L16
        Iterator<WeightedLatLng> r106 = this.mData.iterator();     // Catch: Throwable -> L16
    L12:
        if (r106.hasNext() == false) goto L14;
        WeightedLatLng r107 = r106.next();     // Catch: Throwable -> L16
        this.mTree.a(r107);     // Catch: Throwable -> L16
        goto L12
    L14:
        this.mMaxIntensity = a(this.mRadius);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    }

    public static g3 a(Collection<WeightedLatLng> r110) {
        Iterator<WeightedLatLng> r100 = r110.iterator();
        WeightedLatLng r101 = r100.next();
        double r102 = r101.getPoint().f30021x;
        double r103 = r101.getPoint().f30021x;
        double r104 = r101.getPoint().f30022y;
        double r111 = r102;
        double r112 = r103;
        double r113 = r104;
        double r114 = r101.getPoint().f30022y;
    L4:
        if (r100.hasNext() == false) goto L18;
        WeightedLatLng r105 = r100.next();
        double r106 = r105.getPoint().f30021x;
        double r107 = r105.getPoint().f30022y;
        if (r106 >= r111) goto L9;
        r111 = r106;
    L9:
        if (r106 <= r112) goto L12;
        r112 = r106;
    L12:
        if (r107 >= r113) goto L15;
        r113 = r107;
    L15:
        if (r107 <= r114) goto L4;
        r114 = r107;
        goto L4
    L18:
        return new g3(r111, r112, r113, r114);
    }

    private void a(Gradient r100) {
        this.mGradient = r100;
        this.mColorMap = r100.generateColorMap(this.mOpacity);
    }

    public /* synthetic */ HeatmapTileProvider(Builder r100, a r101) {
        this(r100);
    }

    public static double[] a(int r100, double r101) {
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

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int r410, int r411, int r412) {
        double r100 = 1.0d / Math.pow(2.0d, r412);
        int r110 = this.mRadius;
        double r111 = (((double) r110) * r100) / 256.0d;
        double r112 = ((r111 * 2.0d) + r100) / ((double) ((r110 * 2) + 256));
        double r101 = (((double) r410) * r100) - r111;
        int r113 = 1;
        double r210 = (((double) (r410 + 1)) * r100) + r111;
        double r102 = (((double) r411) * r100) - r111;
        double r103 = (((double) (r411 + 1)) * r100) + r111;
        Collection<WeightedLatLng> r104 = new ArrayList();
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r104 = this.mTree.a(new g3(r101 + 1.0d, 1.0d, r102, r103));
        double r114 = -1.0d;
    L5:
        double r211 = r114;
    L10:
        g3 r105 = new g3(r101, r210, r102, r103);
        g3 r106 = this.mBounds;
        Collection<WeightedLatLng> r413 = r104;
        if (r105.a(new g3(r106.f27297a - r111, r106.f27299c + r111, r106.f27298b - r111, r106.f27300d + r111)) == false) goto L13;
        ArrayList r107 = (ArrayList) this.mTree.a(r105);
        if (r107.isEmpty() == true) goto L17;
        int r108 = (this.mRadius * 2) + 256;
        double[][] r109 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r108, r108});
        Iterator r115 = r107.iterator();
    L20:
        if (r115.hasNext() == false) goto L22;
        WeightedLatLng r116 = (WeightedLatLng) r115.next();
        DPoint r117 = r116.getPoint();
        int r118 = (int) ((r117.f30021x - r101) / r112);
        int r119 = (int) ((r117.f30022y - r102) / r112);
        double[] r120 = r109[r118];
        r120[r119] = r120[r119] + r116.intensity;
        r115 = r115;
        goto L20
    L22:
        Iterator<WeightedLatLng> r121 = r413.iterator();
    L24:
        if (r121.hasNext() == false) goto L26;
        WeightedLatLng r122 = r121.next();
        DPoint r123 = r122.getPoint();
        int r124 = (int) (((r123.f30021x + r211) - r101) / r112);
        int r125 = (int) ((r123.f30022y - r102) / r112);
        double[] r126 = r109[r124];
        r126[r125] = r126[r125] + r122.intensity;
        r121 = r121;
        goto L24
    L26:
        double[] r127 = this.mKernel;
        int r128 = (int) Math.floor(((double) r127.length) / 2.0d);
        int r129 = r109.length;
        int r130 = r129 - (r128 * 2);
        int r131 = (r128 + r130) - 1;
        double[][] r132 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r129, r129});
        int r133 = 0;
    L27:
        if (r133 >= r129) goto L43;
        int r134 = 0;
    L29:
        if (r134 >= r129) goto L42;
        double r135 = r109[r133][r134];
        if (r135 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L41;
        int r136 = r133 + r128;
        if (r131 >= r136) goto L35;
        r136 = r131;
    L35:
        int r137 = r136 + r113;
        int r138 = r133 - r128;
        if (r128 <= r138) goto L38;
        int r139 = r128;
    L39:
        if (r139 >= r137) goto L41;
        double[] r140 = r132[r139];
        r140[r134] = r140[r134] + (r127[r139 - r138] * r135);
        r139 = r139 + 1;
        goto L39
    L38:
        r139 = r138;
    L41:
        r134 = r134 + 1;
        r113 = 1;
        goto L29
    L42:
        r133 = r133 + 1;
        r113 = 1;
        goto L27
    L43:
        double[][] r141 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r130, r130});
        int r142 = r128;
    L45:
        if (r142 >= (r131 + 1)) goto L61;
        int r143 = 0;
    L47:
        if (r143 >= r129) goto L60;
        double r144 = r132[r142][r143];
        if (r144 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L59;
        int r145 = r143 + r128;
        if (r131 >= r145) goto L53;
        r145 = r131;
    L53:
        int r146 = r145 + 1;
        int r147 = r143 - r128;
        if (r128 <= r147) goto L56;
        int r148 = r128;
    L57:
        if (r148 >= r146) goto L59;
        double[] r149 = r141[r142 - r128];
        int r150 = r148 - r128;
        r149[r150] = r149[r150] + (r127[r148 - r147] * r144);
        r148 = r148 + 1;
        goto L57
    L56:
        r148 = r147;
    L59:
        r143 = r143 + 1;
        goto L47
    L60:
        r142 = r142 + 1;
        goto L45
    L61:
        int[] r151 = this.mColorMap;
        double r152 = this.mMaxIntensity[r412];
        int r153 = r151[r151.length - 1];
        double r154 = ((double) (r151.length - 1)) / r152;
        int r155 = r141.length;
        int[] r156 = new int[r155 * r155];
        int r157 = 0;
    L62:
        if (r157 >= r155) goto L75;
        int r158 = 0;
    L64:
        if (r158 >= r155) goto L74;
        double r159 = r141[r158][r157];
        int r160 = (r157 * r155) + r158;
        int r161 = (int) (r159 * r154);
        if (r159 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L68;
        r156[r160] = 0;
    L73:
        r158 = r158 + 1;
        goto L64
    L68:
        if (r161 >= r151.length) goto L70;
        r156[r160] = r151[r161];
        goto L73
    L70:
        r156[r160] = r153;
        goto L73
    L74:
        r157 = r157 + 1;
        goto L62
    L75:
        Bitmap r162 = Bitmap.createBitmap(r155, r155, Bitmap.Config.ARGB_8888);
        r162.setPixels(r156, 0, r155, 0, 0, r155, r155);
        ByteArrayOutputStream r163 = new ByteArrayOutputStream();
        r162.compress(Bitmap.CompressFormat.PNG, 100, r163);
        return Tile.obtain(256, 256, r163.toByteArray());
    L17:
        return TileProvider.NO_TILE;
    L13:
        return TileProvider.NO_TILE;
    L6:
        r114 = 1.0d;
        if (r210 <= 1.0d) goto L9;
        r104 = this.mTree.a(new g3(AudioStats.AUDIO_AMPLITUDE_NONE, r210 - 1.0d, r102, r103));
        goto L5
    L9:
        r211 = 0.0d;
        goto L10
    }
}
