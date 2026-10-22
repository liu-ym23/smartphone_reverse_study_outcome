package com.byted.mgl.merge.service.model;

import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public class BdpPolylineOptions {
    public final int color;
    public final boolean dottedLine;
    public final List<BdpLatLng> points;
    public final double width;

    public static final class Builder {
        private int color;
        private boolean dottedLine;
        private List<BdpLatLng> points;
        private double width;

        public static Builder builder() {
            return new Builder();
        }

        public BdpPolylineOptions build() {
            return new BdpPolylineOptions(this.points, this.color, this.width, this.dottedLine);
        }

        public Builder() {
        }

        public Builder color(int r100) {
            this.color = r100;
            return this;
        }

        public Builder dottedLine(boolean r100) {
            this.dottedLine = r100;
            return this;
        }

        public Builder points(List<BdpLatLng> r100) {
            this.points = r100;
            return this;
        }

        public Builder width(double r100) {
            this.width = r100;
            return this;
        }
    }

    public BdpPolylineOptions(List<BdpLatLng> r100, int r101, double r102, boolean r103) {
        this.points = r100;
        this.color = r101;
        this.width = r102;
        this.dottedLine = r103;
    }
}
