package com.byted.mgl.merge.service.model;

/* JADX INFO: loaded from: classes43.dex */
public class BdpCameraPosition {
    public final float bearing;
    public final BdpLatLng latLng;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private float bearing;
        private BdpLatLng latLng;
        private float tilt;
        private float zoom;

        public static Builder builder() {
            return new Builder();
        }

        public BdpCameraPosition build() {
            return new BdpCameraPosition(this.latLng, this.zoom, this.tilt, this.bearing);
        }

        public Builder() {
        }

        public Builder bearing(float r100) {
            this.bearing = r100;
            return this;
        }

        public Builder latLng(BdpLatLng r100) {
            this.latLng = r100;
            return this;
        }

        public Builder tilt(float r100) {
            this.tilt = r100;
            return this;
        }

        public Builder zoom(float r100) {
            this.zoom = r100;
            return this;
        }
    }

    public BdpCameraPosition(BdpLatLng r100, float r101, float r102, float r103) {
        this.latLng = r100;
        this.zoom = r101;
        this.tilt = r102;
        this.bearing = r103;
    }
}
