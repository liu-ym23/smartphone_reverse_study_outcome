package com.alibaba.fastjson.support.geo;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/* JADX INFO: loaded from: classes28.dex */
@JSONType(orders = {"type", "bbox", "coordinates"}, typeName = "Point")
public class Point extends Geometry {
    private double latitude;
    private double longitude;

    public double[] getCoordinates() {
        return new double[]{this.longitude, this.latitude};
    }

    public Point() {
        super("Point");
    }

    @JSONField(serialize = false)
    public double getLatitude() {
        return this.latitude;
    }

    @JSONField(serialize = false)
    public double getLongitude() {
        return this.longitude;
    }

    public void setCoordinates(double[] r100) {
        if (r100 != null) goto L4;
    L12:
        this.longitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.latitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        return;
    L4:
        if (r100.length == 0) goto L12;
        if (r100.length != 1) goto L10;
        this.longitude = r100[0];
        return;
    L10:
        this.longitude = r100[0];
        this.latitude = r100[1];
    }

    @JSONField(deserialize = false)
    public void setLatitude(double r100) {
        this.latitude = r100;
    }

    @JSONField(deserialize = false)
    public void setLongitude(double r100) {
        this.longitude = r100;
    }
}
