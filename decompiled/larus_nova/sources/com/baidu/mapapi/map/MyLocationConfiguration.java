package com.baidu.mapapi.map;

import android.graphics.Color;
import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes39.dex */
public class MyLocationConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f31174a;
    public int accuracyCircleFillColor;
    public int accuracyCircleStrokeColor;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f31175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BitmapDescriptor f31176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f31177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BitmapDescriptor f31178e;
    public boolean enableArrow;
    public boolean enableDirection;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f31179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f31180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f31181h;
    public final LocationMode locationMode;
    public int width;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f31182a;
        public int accuracyCircleFillColor;
        public int accuracyCircleStrokeColor;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private BitmapDescriptor f31183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private BitmapDescriptor f31184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f31185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f31186e;
        public boolean enableArrow;
        public boolean enableDirection;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f31187f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f31188g;
        public LocationMode locationMode;

        public MyLocationConfiguration build() {
            return new MyLocationConfiguration(this, null);
        }

        private int a(int r100) {
            int r101 = (16711680 & r100) >> 16;
            int r102 = (65280 & r100) >> 8;
            return Color.argb(((-16777216) & r100) >> 24, r100 & 255, r102, r101);
        }

        public static /* synthetic */ BitmapDescriptor b(Builder r100) {
            return r100.f31183b;
        }

        public static /* synthetic */ BitmapDescriptor c(Builder r100) {
            return r100.f31184c;
        }

        public static /* synthetic */ String d(Builder r100) {
            return r100.f31185d;
        }

        public static /* synthetic */ float e(Builder r100) {
            return r100.f31186e;
        }

        public static /* synthetic */ float f(Builder r100) {
            return r100.f31187f;
        }

        public static /* synthetic */ boolean g(Builder r100) {
            return r100.f31188g;
        }

        public Builder setAccuracyCircleFillColor(int r100) {
            this.accuracyCircleFillColor = a(r100);
            return this;
        }

        public Builder setAccuracyCircleStrokeColor(int r100) {
            this.accuracyCircleStrokeColor = a(r100);
            return this;
        }

        public Builder setAnimation(boolean r100) {
            this.f31188g = r100;
            return this;
        }

        public Builder setArrow(BitmapDescriptor r100) {
            this.f31183b = r100;
            return this;
        }

        public Builder setArrowSize(float r100) {
            this.f31187f = r100;
            return this;
        }

        public Builder setCustomMarker(BitmapDescriptor r100) {
            this.f31184c = r100;
            return this;
        }

        public Builder setGifMarker(String r100) {
            this.f31185d = r100;
            return this;
        }

        public Builder setMarkerRotation(boolean r100) {
            this.f31182a = r100;
            return this;
        }

        public Builder setMarkerSize(float r100) {
            this.f31186e = r100;
            return this;
        }

        public static /* synthetic */ boolean a(Builder r100) {
            return r100.f31182a;
        }

        public Builder(LocationMode r100, boolean r101) {
            this.enableDirection = true;
            this.f31182a = false;
            this.f31183b = null;
            this.f31184c = null;
            this.f31186e = 1.0f;
            this.f31187f = 1.0f;
            this.f31188g = true;
            this.accuracyCircleStrokeColor = 4653056;
            this.accuracyCircleFillColor = 4521984;
            this.locationMode = r100;
            this.enableArrow = r101;
        }
    }

    public static final enum LocationMode extends Enum<LocationMode> {
        public static final LocationMode COMPASS = null;
        public static final LocationMode FOLLOWING = null;
        public static final LocationMode NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ LocationMode[] f31189a = null;

        static {
            LocationMode r100 = new LocationMode(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            LocationMode r101 = new LocationMode("FOLLOWING", 1);
            FOLLOWING = r101;
            LocationMode r102 = new LocationMode("COMPASS", 2);
            COMPASS = r102;
            f31189a = new LocationMode[]{r100, r101, r102};
        }

        public static LocationMode[] values() {
            return (LocationMode[]) f31189a.clone();
        }

        public static LocationMode valueOf(String r100) {
            return (LocationMode) r27.a.a(LocationMode.class, r100);
        }

        private LocationMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public BitmapDescriptor getArrow() {
        return this.f31176c;
    }

    public float getArrowSize() {
        return this.f31177d;
    }

    public BitmapDescriptor getCustomMarker() {
        return this.f31178e;
    }

    public String getGifMarker() {
        return this.f31179f;
    }

    public float getMarkerSize() {
        return this.f31180g;
    }

    public boolean isEnableCustom() {
        return this.f31175b;
    }

    public boolean isEnableRotation() {
        return this.f31174a;
    }

    public boolean isNeedAnimation() {
        return this.f31181h;
    }

    private MyLocationConfiguration(Builder r100) {
        this.enableDirection = true;
        this.f31174a = false;
        this.f31175b = true;
        this.f31177d = 1.0f;
        this.f31180g = 1.0f;
        this.f31181h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        this.locationMode = r100.locationMode;
        boolean r101 = r100.enableArrow;
        this.enableArrow = r101;
        this.f31175b = true;
        if (r101 == false) goto L12;
        this.f31174a = Builder.a(r100);
        if (Builder.b(r100) != null) goto L7;
        r100.setArrow(BitmapDescriptorFactory.fromAsset("icon_arrow.png"));
    L7:
        this.f31176c = Builder.b(r100);
        this.f31178e = Builder.c(r100);
        String r102 = Builder.d(r100);
        this.f31179f = r102;
        if (this.f31178e != null) goto L11;
        if (r102 != null) goto L11;
        this.f31178e = BitmapDescriptorFactory.fromAsset("icon_blue.png");
    L11:
        this.f31180g = Builder.e(r100);
        this.f31177d = Builder.f(r100);
        this.f31181h = Builder.g(r100);
    L18:
        this.accuracyCircleFillColor = r100.accuracyCircleFillColor;
        this.accuracyCircleStrokeColor = r100.accuracyCircleStrokeColor;
        return;
    L12:
        this.f31174a = Builder.a(r100);
        this.f31179f = Builder.d(r100);
        this.f31178e = Builder.c(r100);
        this.f31180g = Builder.e(r100);
        if (this.f31179f == null) goto L15;
    L17:
        this.f31181h = Builder.g(r100);
        goto L18
    L15:
        if (this.f31178e != null) goto L17;
        this.f31178e = BitmapDescriptorFactory.fromAsset("icon_blue.png");
        goto L17
    }

    private int a(int r100) {
        int r101 = (16711680 & r100) >> 16;
        int r102 = (65280 & r100) >> 8;
        return Color.argb(((-16777216) & r100) >> 24, r100 & 255, r102, r101);
    }

    public void setAnimation(boolean r100) {
        this.f31181h = r100;
    }

    public void setArrow(BitmapDescriptor r100) {
        this.f31176c = r100;
    }

    public void setArrowSize(float r100) {
        this.f31177d = r100;
    }

    public void setCustomMarker(BitmapDescriptor r100) {
        this.f31178e = r100;
    }

    public void setGifMarker(String r100) {
        this.f31179f = r100;
    }

    public void setMarkerRotation(boolean r100) {
        this.f31174a = r100;
    }

    public void setMarkerSize(float r100) {
        this.f31180g = r100;
    }

    public /* synthetic */ MyLocationConfiguration(Builder r100, a r101) {
        this(r100);
    }

    public MyLocationConfiguration(LocationMode r100, boolean r101, BitmapDescriptor r102) {
        this.enableDirection = true;
        this.f31174a = false;
        this.f31175b = true;
        this.f31177d = 1.0f;
        this.f31180g = 1.0f;
        this.f31181h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        if (r100 != null) goto L5;
        r100 = LocationMode.NORMAL;
    L5:
        this.locationMode = r100;
        this.f31175b = false;
        this.enableDirection = r101;
        this.f31178e = r102;
        this.accuracyCircleFillColor = a(4521984);
        this.accuracyCircleStrokeColor = a(this.accuracyCircleStrokeColor);
    }

    public MyLocationConfiguration(LocationMode r100, boolean r101, BitmapDescriptor r102, int r103, int r104) {
        this.enableDirection = true;
        this.f31174a = false;
        this.f31175b = true;
        this.f31177d = 1.0f;
        this.f31180g = 1.0f;
        this.f31181h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        if (r100 != null) goto L5;
        r100 = LocationMode.NORMAL;
    L5:
        this.locationMode = r100;
        this.f31175b = false;
        this.enableDirection = r101;
        this.f31178e = r102;
        this.accuracyCircleFillColor = a(r103);
        this.accuracyCircleStrokeColor = a(r104);
    }

    public MyLocationConfiguration(LocationMode r100, boolean r101, BitmapDescriptor r102, int r103, int r104, int r105) {
        this.enableDirection = true;
        this.f31174a = false;
        this.f31175b = true;
        this.f31177d = 1.0f;
        this.f31180g = 1.0f;
        this.f31181h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        if (r100 != null) goto L5;
        r100 = LocationMode.NORMAL;
    L5:
        this.locationMode = r100;
        this.enableDirection = r101;
        this.f31178e = r102;
        this.accuracyCircleFillColor = a(r103);
        this.accuracyCircleStrokeColor = a(r104);
        this.width = r105;
    }
}
