package com.autonavi.aps.protocol.aps.response.model.vo.fields;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Semantics implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private double f19123a;

    /* renamed from: b, reason: collision with root package name */
    private double f19124b;

    /* renamed from: c, reason: collision with root package name */
    private double f19125c;

    /* renamed from: d, reason: collision with root package name */
    private String f19126d;

    /* renamed from: e, reason: collision with root package name */
    private Poi f19127e;

    /* renamed from: f, reason: collision with root package name */
    private Building f19128f;

    /* renamed from: g, reason: collision with root package name */
    private Block f19129g;

    /* renamed from: h, reason: collision with root package name */
    private Area f19130h;

    /* renamed from: i, reason: collision with root package name */
    private int f19131i;

    public static class Area extends BasePoi implements Serializable {
    }

    public static class BasePoi implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private String f19132a;

        /* renamed from: b, reason: collision with root package name */
        private String f19133b;

        /* renamed from: c, reason: collision with root package name */
        private double f19134c;

        /* renamed from: d, reason: collision with root package name */
        private double f19135d;

        /* renamed from: e, reason: collision with root package name */
        private String f19136e;

        /* renamed from: f, reason: collision with root package name */
        private int f19137f;

        public String getCategoryIds() {
            return this.f19136e;
        }

        public int getExtConfidence() {
            return this.f19137f;
        }

        public String getId() {
            return this.f19132a;
        }

        public double getLat() {
            return this.f19135d;
        }

        public double getLon() {
            return this.f19134c;
        }

        public String getName() {
            return this.f19133b;
        }

        public void setCategoryIds(String str) {
            this.f19136e = str;
        }

        public void setExtConfidence(int i10) {
            this.f19137f = i10;
        }

        public void setId(String str) {
            this.f19132a = str;
        }

        public void setLat(double d10) {
            this.f19135d = d10;
        }

        public void setLon(double d10) {
            this.f19134c = d10;
        }

        public void setName(String str) {
            this.f19133b = str;
        }
    }

    public static class Block extends BasePoi implements Serializable {
    }

    public static class Building extends BasePoi implements Serializable {

        /* renamed from: g, reason: collision with root package name */
        private Integer f19138g;

        public Integer getFloor() {
            return this.f19138g;
        }

        public void setFloor(Integer num) {
            this.f19138g = num;
        }
    }

    public static class Poi extends BasePoi implements Serializable {

        /* renamed from: g, reason: collision with root package name */
        private Integer f19139g;

        public Integer getFloor() {
            return this.f19139g;
        }

        public void setFloor(Integer num) {
            this.f19139g = num;
        }
    }

    public Area getArea() {
        return this.f19130h;
    }

    public Block getBlock() {
        return this.f19129g;
    }

    public Building getBuilding() {
        return this.f19128f;
    }

    public double getConfidence() {
        return this.f19125c;
    }

    public double getLat() {
        return this.f19124b;
    }

    public double getLon() {
        return this.f19123a;
    }

    public Poi getPoi() {
        return this.f19127e;
    }

    public String getScenes() {
        return this.f19126d;
    }

    public int getScode() {
        return this.f19131i;
    }

    public void setArea(Area area) {
        this.f19130h = area;
    }

    public void setBlock(Block block) {
        this.f19129g = block;
    }

    public void setBuilding(Building building) {
        this.f19128f = building;
    }

    public void setConfidence(double d10) {
        this.f19125c = d10;
    }

    public void setLat(double d10) {
        this.f19124b = d10;
    }

    public void setLon(double d10) {
        this.f19123a = d10;
    }

    public void setPoi(Poi poi) {
        this.f19127e = poi;
    }

    public void setScenes(String str) {
        this.f19126d = str;
    }

    public void setScode(int i10) {
        this.f19131i = i10;
    }
}
