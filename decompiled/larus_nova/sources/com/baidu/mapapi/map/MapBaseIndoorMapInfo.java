package com.baidu.mapapi.map;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public final class MapBaseIndoorMapInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f31014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f31015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList<String> f31016c;

    public static final enum SwitchFloorError extends Enum<SwitchFloorError> {
        public static final SwitchFloorError FLOOR_INFO_ERROR = null;
        public static final SwitchFloorError FLOOR_OVERLFLOW = null;
        public static final SwitchFloorError FOCUSED_ID_ERROR = null;
        public static final SwitchFloorError SWITCH_ERROR = null;
        public static final SwitchFloorError SWITCH_OK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ SwitchFloorError[] f31017a = null;

        static {
            SwitchFloorError r100 = new SwitchFloorError("SWITCH_OK", 0);
            SWITCH_OK = r100;
            SwitchFloorError r101 = new SwitchFloorError("FLOOR_INFO_ERROR", 1);
            FLOOR_INFO_ERROR = r101;
            SwitchFloorError r102 = new SwitchFloorError("FLOOR_OVERLFLOW", 2);
            FLOOR_OVERLFLOW = r102;
            SwitchFloorError r103 = new SwitchFloorError("FOCUSED_ID_ERROR", 3);
            FOCUSED_ID_ERROR = r103;
            SwitchFloorError r104 = new SwitchFloorError("SWITCH_ERROR", 4);
            SWITCH_ERROR = r104;
            f31017a = new SwitchFloorError[]{r100, r101, r102, r103, r104};
        }

        public static SwitchFloorError[] values() {
            return (SwitchFloorError[]) f31017a.clone();
        }

        public static SwitchFloorError valueOf(String r100) {
            return (SwitchFloorError) r27.a.a(SwitchFloorError.class, r100);
        }

        private SwitchFloorError(String r100, int r101) {
            super(r100, r101);
        }
    }

    public MapBaseIndoorMapInfo() {
    }

    public String getCurFloor() {
        return this.f31015b;
    }

    public ArrayList<String> getFloors() {
        return this.f31016c;
    }

    public String getID() {
        return this.f31014a;
    }

    public MapBaseIndoorMapInfo(MapBaseIndoorMapInfo r100) {
        this.f31014a = r100.f31014a;
        this.f31015b = r100.f31015b;
        this.f31016c = r100.f31016c;
    }

    public MapBaseIndoorMapInfo(String r100, String r101, ArrayList<String> r102) {
        this.f31014a = r100;
        this.f31015b = r101;
        this.f31016c = r102;
    }
}
