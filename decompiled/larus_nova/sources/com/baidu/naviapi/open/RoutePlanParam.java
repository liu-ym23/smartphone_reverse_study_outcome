package com.baidu.naviapi.open;

import android.util.Pair;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class RoutePlanParam {
    private boolean avoid;
    private int carType;
    private int coordType;
    private String eName;
    private LocInfo end;
    private String euid;
    private Pair<Integer, Integer> guidanceRange;
    private int originRoadType;
    private String plate;
    private int prefer;
    private int reCoordType;
    private int ridingType;
    private String routeId;
    private RoutePlanType routePlanType;
    private String sName;
    private String sessionId;
    private int special;
    private LocInfo start;
    private int state;
    private String suid;
    private String verbalMode;
    private List<LocInfo.Point> vias;

    public static final enum RoutePlanType extends Enum<RoutePlanType> {
        private static final /* synthetic */ RoutePlanType[] $VALUES = null;
        public static final RoutePlanType DRIVING = null;
        public static final RoutePlanType RIDING = null;
        public static final RoutePlanType WALKING = null;

        static {
            RoutePlanType r100 = new RoutePlanType("DRIVING", 0);
            DRIVING = r100;
            RoutePlanType r101 = new RoutePlanType("RIDING", 1);
            RIDING = r101;
            RoutePlanType r102 = new RoutePlanType("WALKING", 2);
            WALKING = r102;
            $VALUES = new RoutePlanType[]{r100, r101, r102};
        }

        public static RoutePlanType[] values() {
            return (RoutePlanType[]) $VALUES.clone();
        }

        public static RoutePlanType valueOf(String r100) {
            return (RoutePlanType) a.a(RoutePlanType.class, r100);
        }

        private RoutePlanType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public String toString() {
        return "RoutePlanParam{start=" + this.start + ", end=" + this.end + ", suid='" + this.suid + "', euid='" + this.euid + "', sName='" + this.sName + "', eName='" + this.eName + "', vias=" + this.vias + ", plate='" + this.plate + "', carType=" + this.carType + ", special=" + this.special + ", prefer=" + this.prefer + ", ridingType=" + this.ridingType + ", coordType=" + this.coordType + ", reCoordType=" + this.reCoordType + ", originRoadType=" + this.originRoadType + ", verbalMode='" + this.verbalMode + "', routeId='" + this.routeId + "', state=" + this.state + ", avoid=" + this.avoid + ", guidanceRange='" + this.guidanceRange + "', routePlanType=" + this.routePlanType + ", sessionId='" + this.sessionId + "'}";
    }

    public RoutePlanParam() {
        this.state = 0;
        this.guidanceRange = new Pair(-20, 20);
    }

    public int getCarType() {
        return this.carType;
    }

    public int getCoordType() {
        return this.coordType;
    }

    public LocInfo getEnd() {
        return this.end;
    }

    public String getEuid() {
        return this.euid;
    }

    public Pair<Integer, Integer> getGuidanceRange() {
        return this.guidanceRange;
    }

    public int getOriginRoadType() {
        return this.originRoadType;
    }

    public String getPlate() {
        return this.plate;
    }

    public int getPrefer() {
        return this.prefer;
    }

    public int getReCoordType() {
        return this.reCoordType;
    }

    public int getRidingType() {
        return this.ridingType;
    }

    public String getRouteId() {
        return this.routeId;
    }

    public RoutePlanType getRoutePlanType() {
        return this.routePlanType;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getSpecial() {
        return this.special;
    }

    public LocInfo getStart() {
        return this.start;
    }

    public int getState() {
        return this.state;
    }

    public String getSuid() {
        return this.suid;
    }

    public String getVerbalMode() {
        return this.verbalMode;
    }

    public List<LocInfo.Point> getVias() {
        return this.vias;
    }

    public String geteName() {
        return this.eName;
    }

    public String getsName() {
        return this.sName;
    }

    public boolean isAvoid() {
        return this.avoid;
    }

    public void setAvoid(boolean r100) {
        this.avoid = r100;
    }

    public void setCarType(int r100) {
        this.carType = r100;
    }

    public void setCoordType(int r100) {
        this.coordType = r100;
    }

    public void setEnd(LocInfo r100) {
        this.end = r100;
    }

    public void setEuid(String r100) {
        this.euid = r100;
    }

    public void setGuidanceRange(Pair<Integer, Integer> r100) {
        this.guidanceRange = r100;
    }

    public void setOriginRoadType(int r100) {
        this.originRoadType = r100;
    }

    public void setPlate(String r100) {
        this.plate = r100;
    }

    public void setPrefer(int r100) {
        this.prefer = r100;
    }

    public void setReCoordType(int r100) {
        this.reCoordType = r100;
    }

    public void setRidingType(int r100) {
        this.ridingType = r100;
    }

    public void setRouteId(String r100) {
        this.routeId = r100;
    }

    public void setRoutePlanType(RoutePlanType r100) {
        this.routePlanType = r100;
    }

    public void setSessionId(String r100) {
        this.sessionId = r100;
    }

    public void setSpecial(int r100) {
        this.special = r100;
    }

    public void setStart(LocInfo r100) {
        this.start = r100;
    }

    public void setState(int r100) {
        this.state = r100;
    }

    public void setSuid(String r100) {
        this.suid = r100;
    }

    public void setVerbalMode(String r100) {
        this.verbalMode = r100;
    }

    public void setVias(List<LocInfo.Point> r100) {
        this.vias = r100;
    }

    public void seteName(String r100) {
        this.eName = r100;
    }

    public void setsName(String r100) {
        this.sName = r100;
    }
}
