package com.baidu.platform.comapi.map;

import android.text.TextUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes39.dex */
public final class IndoorMapInfo implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f32990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f32991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f32992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f32993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f32996g;

    public String toString() {
        return "IndoorMapInfo:building_id:" + this.f32990a + ";floor_id:" + this.f32991b + ";indoor_type:" + this.f32994e + ";floor_list:" + Arrays.toString(this.f32992c) + ";floor_attribute:" + Arrays.toString(this.f32993d);
    }

    public String getBuildingId() {
        return this.f32990a;
    }

    public final int[] getFloorAttribute() {
        return this.f32993d;
    }

    public String getFloorId() {
        return this.f32991b;
    }

    public final String[] getFloorList() {
        return this.f32992c;
    }

    public String getIdrSearch() {
        return this.f32996g;
    }

    public int getIdrguide() {
        return this.f32995f;
    }

    public int getIndoorType() {
        return this.f32994e;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof IndoorMapInfo) == true) goto L8;
        return false;
    L8:
        IndoorMapInfo r101 = (IndoorMapInfo) r100;
        if (TextUtils.equals(this.f32990a, r101.f32990a) == true) goto L12;
        return false;
    L12:
        if (TextUtils.equals(this.f32991b, r101.f32991b) == true) goto L15;
        return false;
    L15:
        if (Arrays.equals(this.f32992c, r101.f32992c) == true) goto L18;
        return false;
    L18:
        return Arrays.equals(this.f32993d, r101.f32993d);
    }

    public IndoorMapInfo(String r100, String r101) {
        this.f32990a = r100;
        this.f32991b = r101;
    }

    public IndoorMapInfo(String r100, String r110, String[] r111, int[] r112, int r113) {
        this(r100, r110, r111, r112, r113, 0, "");
    }

    public IndoorMapInfo(String r100, String r110, String[] r111, int[] r112, int r113, int r114) {
        this(r100, r110, r111, r112, r113, r114, "");
    }

    public IndoorMapInfo(String r100, String r101, String[] r102, int[] r103, int r104, int r105, String r106) {
        this.f32990a = r100;
        this.f32991b = r101;
        this.f32994e = r104;
        this.f32995f = r105;
        if (r102 == null) goto L5;
        String[] r107 = (String[]) Array.newInstance(String.class, r102.length);
        this.f32992c = r107;
        System.arraycopy(r102, 0, r107, 0, r102.length);
    L5:
        if (r103 == null) goto L7;
        int[] r108 = new int[r103.length];
        this.f32993d = r108;
        System.arraycopy(r103, 0, r108, 0, r103.length);
    L7:
        this.f32996g = r106;
    }
}
