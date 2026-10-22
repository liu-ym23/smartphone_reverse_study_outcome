package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONType;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
@JSONType(orders = {"type", "id", "bbox", "coordinates", "properties"}, typeName = "Feature")
public class Feature extends Geometry {
    private Geometry geometry;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f24937id;
    private Map<String, String> properties;

    public Feature() {
        super("Feature");
        this.properties = new LinkedHashMap();
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    public String getId() {
        return this.f24937id;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public void setGeometry(Geometry r100) {
        this.geometry = r100;
    }

    public void setId(String r100) {
        this.f24937id = r100;
    }

    public void setProperties(Map<String, String> r100) {
        this.properties = r100;
    }
}
