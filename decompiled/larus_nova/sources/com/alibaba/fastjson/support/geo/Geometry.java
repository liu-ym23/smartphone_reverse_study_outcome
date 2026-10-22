package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONType;

/* JADX INFO: loaded from: classes28.dex */
@JSONType(seeAlso = {GeometryCollection.class, LineString.class, MultiLineString.class, Point.class, MultiPoint.class, Polygon.class, MultiPolygon.class, Feature.class, FeatureCollection.class}, typeKey = "type")
public abstract class Geometry {
    private double[] bbox;
    private final String type;

    public double[] getBbox() {
        return this.bbox;
    }

    public String getType() {
        return this.type;
    }

    public Geometry(String r100) {
        this.type = r100;
    }

    public void setBbox(double[] r100) {
        this.bbox = r100;
    }
}
