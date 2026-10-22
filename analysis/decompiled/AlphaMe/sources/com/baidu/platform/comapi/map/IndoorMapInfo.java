package com.baidu.platform.comapi.map;

import android.text.TextUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class IndoorMapInfo implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f8851a;

    /* renamed from: b, reason: collision with root package name */
    private String f8852b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f8853c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f8854d;

    /* renamed from: e, reason: collision with root package name */
    private int f8855e;

    /* renamed from: f, reason: collision with root package name */
    private int f8856f;

    /* renamed from: g, reason: collision with root package name */
    private String f8857g;

    public IndoorMapInfo(String str, String str2) {
        this.f8851a = str;
        this.f8852b = str2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IndoorMapInfo)) {
            return false;
        }
        IndoorMapInfo indoorMapInfo = (IndoorMapInfo) obj;
        if (TextUtils.equals(this.f8851a, indoorMapInfo.f8851a) && TextUtils.equals(this.f8852b, indoorMapInfo.f8852b) && Arrays.equals(this.f8853c, indoorMapInfo.f8853c)) {
            return Arrays.equals(this.f8854d, indoorMapInfo.f8854d);
        }
        return false;
    }

    public String getBuildingId() {
        return this.f8851a;
    }

    public final int[] getFloorAttribute() {
        return this.f8854d;
    }

    public String getFloorId() {
        return this.f8852b;
    }

    public final String[] getFloorList() {
        return this.f8853c;
    }

    public String getIdrSearch() {
        return this.f8857g;
    }

    public int getIdrguide() {
        return this.f8856f;
    }

    public int getIndoorType() {
        return this.f8855e;
    }

    public String toString() {
        return "IndoorMapInfo:building_id:" + this.f8851a + ";floor_id:" + this.f8852b + ";indoor_type:" + this.f8855e + ";floor_list:" + Arrays.toString(this.f8853c) + ";floor_attribute:" + Arrays.toString(this.f8854d);
    }

    public IndoorMapInfo(String str, String str2, String[] strArr, int[] iArr, int i4) {
        this(str, str2, strArr, iArr, i4, 0, "");
    }

    public IndoorMapInfo(String str, String str2, String[] strArr, int[] iArr, int i4, int i5) {
        this(str, str2, strArr, iArr, i4, i5, "");
    }

    public IndoorMapInfo(String str, String str2, String[] strArr, int[] iArr, int i4, int i5, String str3) {
        this.f8851a = str;
        this.f8852b = str2;
        this.f8855e = i4;
        this.f8856f = i5;
        if (strArr != null) {
            String[] strArr2 = (String[]) Array.newInstance((Class<?>) String.class, strArr.length);
            this.f8853c = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        }
        if (iArr != null) {
            int[] iArr2 = new int[iArr.length];
            this.f8854d = iArr2;
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        }
        this.f8857g = str3;
    }
}
