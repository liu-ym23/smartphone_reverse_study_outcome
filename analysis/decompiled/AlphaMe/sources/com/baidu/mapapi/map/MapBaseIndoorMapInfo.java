package com.baidu.mapapi.map;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class MapBaseIndoorMapInfo {

    /* renamed from: a, reason: collision with root package name */
    String f6499a;

    /* renamed from: b, reason: collision with root package name */
    String f6500b;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<String> f6501c;

    public enum SwitchFloorError {
        SWITCH_OK,
        FLOOR_INFO_ERROR,
        FLOOR_OVERLFLOW,
        FOCUSED_ID_ERROR,
        SWITCH_ERROR
    }

    public MapBaseIndoorMapInfo() {
    }

    public String getCurFloor() {
        return this.f6500b;
    }

    public ArrayList<String> getFloors() {
        return this.f6501c;
    }

    public String getID() {
        return this.f6499a;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f6499a = str;
        this.f6500b = str2;
        this.f6501c = arrayList;
    }

    public MapBaseIndoorMapInfo(MapBaseIndoorMapInfo mapBaseIndoorMapInfo) {
        this.f6499a = mapBaseIndoorMapInfo.f6499a;
        this.f6500b = mapBaseIndoorMapInfo.f6500b;
        this.f6501c = mapBaseIndoorMapInfo.f6501c;
    }
}
