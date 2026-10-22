package com.baidu.mapapi.map;

import android.graphics.Color;

/* loaded from: classes.dex */
public class MyLocationConfiguration {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6696a;
    public int accuracyCircleFillColor;
    public int accuracyCircleStrokeColor;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6697b;

    /* renamed from: c, reason: collision with root package name */
    private BitmapDescriptor f6698c;

    /* renamed from: d, reason: collision with root package name */
    private float f6699d;

    /* renamed from: e, reason: collision with root package name */
    private BitmapDescriptor f6700e;
    public boolean enableArrow;
    public boolean enableDirection;

    /* renamed from: f, reason: collision with root package name */
    private String f6701f;

    /* renamed from: g, reason: collision with root package name */
    private float f6702g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6703h;
    public final LocationMode locationMode;
    public int width;

    public static class Builder {

        /* renamed from: d, reason: collision with root package name */
        private String f6707d;
        public boolean enableArrow;
        public LocationMode locationMode;
        public boolean enableDirection = true;

        /* renamed from: a, reason: collision with root package name */
        private boolean f6704a = false;

        /* renamed from: b, reason: collision with root package name */
        private BitmapDescriptor f6705b = null;

        /* renamed from: c, reason: collision with root package name */
        private BitmapDescriptor f6706c = null;

        /* renamed from: e, reason: collision with root package name */
        private float f6708e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        private float f6709f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f6710g = true;
        public int accuracyCircleStrokeColor = 4653056;
        public int accuracyCircleFillColor = 4521984;

        public Builder(LocationMode locationMode, boolean z4) {
            this.locationMode = locationMode;
            this.enableArrow = z4;
        }

        public MyLocationConfiguration build() {
            return new MyLocationConfiguration(this);
        }

        public Builder setAccuracyCircleFillColor(int i4) {
            this.accuracyCircleFillColor = a(i4);
            return this;
        }

        public Builder setAccuracyCircleStrokeColor(int i4) {
            this.accuracyCircleStrokeColor = a(i4);
            return this;
        }

        public Builder setAnimation(boolean z4) {
            this.f6710g = z4;
            return this;
        }

        public Builder setArrow(BitmapDescriptor bitmapDescriptor) {
            this.f6705b = bitmapDescriptor;
            return this;
        }

        public Builder setArrowSize(float f4) {
            this.f6709f = f4;
            return this;
        }

        public Builder setCustomMarker(BitmapDescriptor bitmapDescriptor) {
            this.f6706c = bitmapDescriptor;
            return this;
        }

        public Builder setGifMarker(String str) {
            this.f6707d = str;
            return this;
        }

        public Builder setMarkerRotation(boolean z4) {
            this.f6704a = z4;
            return this;
        }

        public Builder setMarkerSize(float f4) {
            this.f6708e = f4;
            return this;
        }

        private int a(int i4) {
            return Color.argb(((-16777216) & i4) >> 24, i4 & 255, (65280 & i4) >> 8, (16711680 & i4) >> 16);
        }
    }

    public enum LocationMode {
        NORMAL,
        FOLLOWING,
        COMPASS
    }

    private int a(int i4) {
        return Color.argb(((-16777216) & i4) >> 24, i4 & 255, (65280 & i4) >> 8, (16711680 & i4) >> 16);
    }

    public BitmapDescriptor getArrow() {
        return this.f6698c;
    }

    public float getArrowSize() {
        return this.f6699d;
    }

    public BitmapDescriptor getCustomMarker() {
        return this.f6700e;
    }

    public String getGifMarker() {
        return this.f6701f;
    }

    public float getMarkerSize() {
        return this.f6702g;
    }

    public boolean isEnableCustom() {
        return this.f6697b;
    }

    public boolean isEnableRotation() {
        return this.f6696a;
    }

    public boolean isNeedAnimation() {
        return this.f6703h;
    }

    public void setAnimation(boolean z4) {
        this.f6703h = z4;
    }

    public void setArrow(BitmapDescriptor bitmapDescriptor) {
        this.f6698c = bitmapDescriptor;
    }

    public void setArrowSize(float f4) {
        this.f6699d = f4;
    }

    public void setCustomMarker(BitmapDescriptor bitmapDescriptor) {
        this.f6700e = bitmapDescriptor;
    }

    public void setGifMarker(String str) {
        this.f6701f = str;
    }

    public void setMarkerRotation(boolean z4) {
        this.f6696a = z4;
    }

    public void setMarkerSize(float f4) {
        this.f6702g = f4;
    }

    private MyLocationConfiguration(Builder builder) {
        this.enableDirection = true;
        this.f6696a = false;
        this.f6697b = true;
        this.f6699d = 1.0f;
        this.f6702g = 1.0f;
        this.f6703h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        this.locationMode = builder.locationMode;
        boolean z4 = builder.enableArrow;
        this.enableArrow = z4;
        this.f6697b = true;
        if (z4) {
            this.f6696a = builder.f6704a;
            if (builder.f6705b == null) {
                builder.setArrow(BitmapDescriptorFactory.fromAsset("icon_arrow.png"));
            }
            this.f6698c = builder.f6705b;
            this.f6700e = builder.f6706c;
            String str = builder.f6707d;
            this.f6701f = str;
            if (this.f6700e == null && str == null) {
                this.f6700e = BitmapDescriptorFactory.fromAsset("icon_blue.png");
            }
            this.f6702g = builder.f6708e;
            this.f6699d = builder.f6709f;
            this.f6703h = builder.f6710g;
        } else {
            this.f6696a = builder.f6704a;
            this.f6701f = builder.f6707d;
            this.f6700e = builder.f6706c;
            this.f6702g = builder.f6708e;
            if (this.f6701f == null && this.f6700e == null) {
                this.f6700e = BitmapDescriptorFactory.fromAsset("icon_blue.png");
            }
            this.f6703h = builder.f6710g;
        }
        this.accuracyCircleFillColor = builder.accuracyCircleFillColor;
        this.accuracyCircleStrokeColor = builder.accuracyCircleStrokeColor;
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z4, BitmapDescriptor bitmapDescriptor, int i4, int i5) {
        this.enableDirection = true;
        this.f6696a = false;
        this.f6697b = true;
        this.f6699d = 1.0f;
        this.f6702g = 1.0f;
        this.f6703h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.f6697b = false;
        this.enableDirection = z4;
        this.f6700e = bitmapDescriptor;
        this.accuracyCircleFillColor = a(i4);
        this.accuracyCircleStrokeColor = a(i5);
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z4, BitmapDescriptor bitmapDescriptor, int i4, int i5, int i6) {
        this.enableDirection = true;
        this.f6696a = false;
        this.f6697b = true;
        this.f6699d = 1.0f;
        this.f6702g = 1.0f;
        this.f6703h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.enableDirection = z4;
        this.f6700e = bitmapDescriptor;
        this.accuracyCircleFillColor = a(i4);
        this.accuracyCircleStrokeColor = a(i5);
        this.width = i6;
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z4, BitmapDescriptor bitmapDescriptor) {
        this.enableDirection = true;
        this.f6696a = false;
        this.f6697b = true;
        this.f6699d = 1.0f;
        this.f6702g = 1.0f;
        this.f6703h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.f6697b = false;
        this.enableDirection = z4;
        this.f6700e = bitmapDescriptor;
        this.accuracyCircleFillColor = a(4521984);
        this.accuracyCircleStrokeColor = a(this.accuracyCircleStrokeColor);
    }
}
