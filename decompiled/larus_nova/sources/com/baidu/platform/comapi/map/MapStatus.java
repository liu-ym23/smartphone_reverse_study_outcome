package com.baidu.platform.comapi.map;

import androidx.camera.video.AudioStats;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class MapStatus implements Serializable {
    public float adapterZoomUnits;
    public int animationTime;
    public int animationType;
    public boolean bOverlookSpringback;
    public boolean bfpp;
    public double centerPtX;
    public double centerPtY;
    public double centerPtZ;
    public GeoBound geoRound;
    public int hasAnimation;
    public boolean isBirdEye;
    public float level;
    public int minOverlooking;
    public double overlooking;
    public String panoId;
    public float roadOffsetX;
    public float roadOffsetY;
    public int rotation;
    public int streetExt;
    public float streetIndicateAngle;
    public WinRound winRound;
    public float xOffset;
    public float xScreenOffset;
    public float yOffset;
    public float yScreenOffset;

    public static class GeoBound implements Serializable {
        public long bottom;
        public long left;
        public long right;
        public long top;

        public int hashCode() {
            long r100 = this.bottom;
            int r101 = (((int) (r100 ^ (r100 >>> 32))) + 31) * 31;
            long r102 = this.left;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.right;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.top;
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        }

        public GeoBound() {
            this.left = 0;
            this.right = 0;
            this.top = 0;
            this.bottom = 0;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if ((r100 instanceof GeoBound) == true) goto L11;
            return false;
        L11:
            GeoBound r101 = (GeoBound) r100;
            if (this.bottom == r101.bottom) goto L15;
            return false;
        L15:
            if (this.left == r101.left) goto L18;
            return false;
        L18:
            if (this.right == r101.right) goto L21;
            return false;
        L21:
            if (this.top == r101.top) goto L25;
            return false;
        L25:
            return true;
        }
    }

    public static class WinRound implements Serializable {
        public int bottom;
        public int left;
        public int right;
        public int top;

        public int hashCode() {
            return ((((((this.bottom + 31) * 31) + this.left) * 31) + this.right) * 31) + this.top;
        }

        public WinRound() {
            this.left = 0;
            this.right = 0;
            this.top = 0;
            this.bottom = 0;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if ((r100 instanceof WinRound) == true) goto L11;
            return false;
        L11:
            WinRound r101 = (WinRound) r100;
            if (this.bottom == r101.bottom) goto L15;
            return false;
        L15:
            if (this.left == r101.left) goto L18;
            return false;
        L18:
            if (this.right == r101.right) goto L21;
            return false;
        L21:
            if (this.top == r101.top) goto L25;
            return false;
        L25:
            return true;
        }
    }

    public int hashCode() {
        double r100 = (((((((this.centerPtX + 31.0d) * 31.0d) + this.centerPtY) * 31.0d) + this.centerPtZ) * 31.0d) + (this.bfpp ? 1.0d : 0.0d)) * 31.0d;
        GeoBound r101 = this.geoRound;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        double r104 = (((((((r100 + ((double) r103)) * 31.0d) + ((double) Float.floatToIntBits(this.level))) * 31.0d) + this.overlooking) * 31.0d) + ((double) this.rotation)) * 31.0d;
        WinRound r105 = this.winRound;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return (int) (r104 + ((double) r102));
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "MapStatus{level=" + this.level + ", rotation=" + this.rotation + ", overlooking=" + this.overlooking + ", centerPtX=" + this.centerPtX + ", centerPtY=" + this.centerPtY + ", centerPtZ=" + this.centerPtZ + ", winRound=" + this.winRound + ", geoRound=" + this.geoRound + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", bfpp=" + this.bfpp + ", panoId='" + this.panoId + "', streetIndicateAngle=" + this.streetIndicateAngle + ", isBirdEye=" + this.isBirdEye + ", streetExt=" + this.streetExt + ", roadOffsetX=" + this.roadOffsetX + ", roadOffsetY=" + this.roadOffsetY + ", xScreenOffset=" + this.xScreenOffset + ", yScreenOffset=" + this.yScreenOffset + ", adapterZoomUnits=" + this.adapterZoomUnits + '}';
    }

    public MapStatus() {
        this.animationType = 0;
        this.level = -1.0f;
        this.rotation = -1;
        this.overlooking = -1.0d;
        this.centerPtX = -1.0d;
        this.centerPtY = -1.0d;
        this.centerPtZ = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.xOffset = 0.0f;
        this.yOffset = 0.0f;
        this.winRound = new WinRound();
        this.geoRound = new GeoBound();
        this.bfpp = false;
        this.panoId = "";
        this.streetIndicateAngle = 0.0f;
        this.isBirdEye = false;
        this.streetExt = 0;
        this.roadOffsetX = 0.0f;
        this.roadOffsetY = 0.0f;
        this.bOverlookSpringback = false;
        this.minOverlooking = -1;
        this.xScreenOffset = 0.0f;
        this.yScreenOffset = 0.0f;
        this.adapterZoomUnits = 0.0f;
    }

    public MapStatus(MapStatus r100) {
        this.animationType = 0;
        this.level = r100.level;
        this.rotation = r100.rotation;
        this.overlooking = r100.overlooking;
        this.centerPtX = r100.centerPtX;
        this.centerPtY = r100.centerPtY;
        this.centerPtZ = r100.centerPtZ;
        this.xOffset = r100.xOffset;
        this.yOffset = r100.yOffset;
        this.winRound = r100.winRound;
        this.geoRound = r100.geoRound;
        this.bfpp = r100.bfpp;
        this.panoId = r100.panoId;
        this.streetIndicateAngle = r100.streetIndicateAngle;
        this.isBirdEye = r100.isBirdEye;
        this.streetExt = r100.streetExt;
        this.roadOffsetX = r100.roadOffsetX;
        this.roadOffsetY = r100.roadOffsetY;
        this.bOverlookSpringback = r100.bOverlookSpringback;
        this.minOverlooking = r100.minOverlooking;
        this.xScreenOffset = r100.xScreenOffset;
        this.yScreenOffset = r100.yScreenOffset;
        this.adapterZoomUnits = r100.adapterZoomUnits;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MapStatus) == true) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        if (r100 != null) goto L10;
        return false;
    L10:
        MapStatus r101 = (MapStatus) r100;
        if (this.centerPtX == r101.centerPtX) goto L14;
        return false;
    L14:
        if (this.centerPtY == r101.centerPtY) goto L17;
        return false;
    L17:
        if (this.centerPtZ == r101.centerPtZ) goto L20;
        return false;
    L20:
        if (this.bfpp == r101.bfpp) goto L22;
        return false;
    L22:
        GeoBound r102 = this.geoRound;
        if (r102 != null) goto L28;
        if (r101.geoRound == null) goto L31;
        return false;
    L31:
        if (Float.floatToIntBits(this.level) == Float.floatToIntBits(r101.level)) goto L34;
        return false;
    L34:
        if (Double.doubleToLongBits(this.overlooking) == Double.doubleToLongBits(r101.overlooking)) goto L37;
        return false;
    L37:
        if (this.rotation == r101.rotation) goto L40;
        return false;
    L40:
        if (this.yOffset == r101.yOffset) goto L43;
        return false;
    L43:
        if (this.xOffset == r101.xOffset) goto L46;
        return false;
    L46:
        if (this.xScreenOffset == r101.xScreenOffset) goto L49;
        return false;
    L49:
        if (this.yScreenOffset == r101.yScreenOffset) goto L52;
        return false;
    L52:
        if (this.adapterZoomUnits == r101.adapterZoomUnits) goto L54;
        return false;
    L54:
        WinRound r103 = this.winRound;
        if (r103 != null) goto L60;
        if (r101.winRound == null) goto L62;
        return false;
    L62:
        return true;
    L60:
        if (r103.equals(r101.winRound) == true) goto L62;
        return false;
    L28:
        if (r102.equals(r101.geoRound) == true) goto L31;
        return false;
    }
}
