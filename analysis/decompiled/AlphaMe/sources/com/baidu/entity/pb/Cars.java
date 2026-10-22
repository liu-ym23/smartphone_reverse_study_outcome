package com.baidu.entity.pb;

import B0.g;
import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import ch.qos.logback.core.net.SyslogConstants;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.entity.pb.PoiResult;
import com.baidu.platform.comapi.license.LicenseCode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class Cars extends f {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int TEST_FIELD_NUMBER = 3;
    private boolean hasContent;
    private boolean hasOption;
    private boolean hasTest;
    private Option option_ = null;
    private Content content_ = null;
    private String test_ = "";
    private int cachedSize = -1;

    public static final class Content extends f {
        public static final int ACCI_INFOS_FIELD_NUMBER = 6;
        public static final int AVOID_CAR_RULES_FIELD_NUMBER = 14;
        public static final int AVOID_JAM_PREFER_FIELD_NUMBER = 17;
        public static final int COMMUTER_TITLE_DESC_FIELD_NUMBER = 16;
        public static final int CRIP_TYPE_FIELD_NUMBER = 15;
        public static final int DYNAMIC_CONTENT_FIELD_NUMBER = 18;
        public static final int HEAT_EFFECTIVE_CITY_FLAG_FIELD_NUMBER = 13;
        public static final int LOCAL_INFO_TIPS_FIELD_NUMBER = 8;
        public static final int LONG_DISTANCE_INFO_FIELD_NUMBER = 11;
        public static final int ROUTEALL = 1;
        public static final int ROUTEPART = 2;
        public static final int ROUTESTATUS_FIELD_NUMBER = 7;
        public static final int ROUTES_FIELD_NUMBER = 1;
        public static final int SESSIONID_FIELD_NUMBER = 9;
        public static final int STEPS_FIELD_NUMBER = 2;
        public static final int STEPTS_FIELD_NUMBER = 3;
        public static final int TAXIS_FIELD_NUMBER = 4;
        public static final int TRAFFICS_FIELD_NUMBER = 5;
        public static final int WALKINF_FIELD_NUMBER = 10;
        public static final int YELLOW_TIPS_LIST_FIELD_NUMBER = 12;
        private boolean hasAvoidJamPrefer;
        private boolean hasCommuterTitleDesc;
        private boolean hasCripType;
        private boolean hasDynamicContent;
        private boolean hasHeatEffectiveCityFlag;
        private boolean hasLocalInfoTips;
        private boolean hasRouteStatus;
        private boolean hasSessionid;
        private boolean hasWalkinf;
        private List<Routes> routes_ = Collections.emptyList();
        private List<Steps> steps_ = Collections.emptyList();
        private List<Stepts> stepts_ = Collections.emptyList();
        private List<Taxis> taxis_ = Collections.emptyList();
        private List<Traffics> traffics_ = Collections.emptyList();
        private List<AcciInfos> acciInfos_ = Collections.emptyList();
        private int routeStatus_ = 1;
        private String localInfoTips_ = "";
        private String sessionid_ = "";
        private WalkInfoT walkinf_ = null;
        private List<LongDistanceInfo> longDistanceInfo_ = Collections.emptyList();
        private List<YellowTipsList> yellowTipsList_ = Collections.emptyList();
        private int heatEffectiveCityFlag_ = 0;
        private List<String> avoidCarRules_ = Collections.emptyList();
        private int cripType_ = 0;
        private String commuterTitleDesc_ = "";
        private AvoidJamInfoPrefer avoidJamPrefer_ = null;
        private a dynamicContent_ = a.f1216c;
        private int cachedSize = -1;

        public static final class AcciInfos extends f {
            public static final int PATH_FIELD_NUMBER = 2;
            public static final int TIPS_FIELD_NUMBER = 1;
            private boolean hasPath;
            private boolean hasTips;
            private String tips_ = "";
            private String path_ = "";
            private int cachedSize = -1;

            public static AcciInfos parseFrom(b bVar) throws IOException {
                return new AcciInfos().mergeFrom(bVar);
            }

            public final AcciInfos clear() {
                clearTips();
                clearPath();
                this.cachedSize = -1;
                return this;
            }

            public AcciInfos clearPath() {
                this.hasPath = false;
                this.path_ = "";
                return this;
            }

            public AcciInfos clearTips() {
                this.hasTips = false;
                this.tips_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getPath() {
                return this.path_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasTips() ? d.l(1, getTips()) : 0;
                if (hasPath()) {
                    iL += d.l(2, getPath());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getTips() {
                return this.tips_;
            }

            public boolean hasPath() {
                return this.hasPath;
            }

            public boolean hasTips() {
                return this.hasTips;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AcciInfos setPath(String str) {
                this.hasPath = true;
                this.path_ = str;
                return this;
            }

            public AcciInfos setTips(String str) {
                this.hasTips = true;
                this.tips_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasTips()) {
                    dVar.A(1, getTips());
                }
                if (hasPath()) {
                    dVar.A(2, getPath());
                }
            }

            public static AcciInfos parseFrom(byte[] bArr) throws e {
                return (AcciInfos) new AcciInfos().mergeFrom(bArr);
            }

            @Override // L1.f
            public AcciInfos mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setTips(bVar.n());
                    } else if (iO == 18) {
                        setPath(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class AvoidJamInfo extends f {
            public static final int AVOID_JAM_DISCRIPTION_FIELD_NUMBER = 3;
            public static final int AVOID_JAM_PERCENTAGE_FIELD_NUMBER = 1;
            public static final int AVOID_JAM_PERCENTAGE_TEXT_FIELD_NUMBER = 2;
            public static final int IS_DEFAULT_FIELD_NUMBER = 5;
            public static final int MRSL_FIELD_NUMBER = 4;
            private boolean hasAvoidJamDiscription;
            private boolean hasAvoidJamPercentage;
            private boolean hasAvoidJamPercentageText;
            private boolean hasIsDefault;
            private int avoidJamPercentage_ = 0;
            private String avoidJamPercentageText_ = "";
            private String avoidJamDiscription_ = "";
            private List<String> mrsl_ = Collections.emptyList();
            private boolean isDefault_ = false;
            private int cachedSize = -1;

            public static AvoidJamInfo parseFrom(b bVar) throws IOException {
                return new AvoidJamInfo().mergeFrom(bVar);
            }

            public AvoidJamInfo addMrsl(String str) {
                str.getClass();
                if (this.mrsl_.isEmpty()) {
                    this.mrsl_ = new ArrayList();
                }
                this.mrsl_.add(str);
                return this;
            }

            public final AvoidJamInfo clear() {
                clearAvoidJamPercentage();
                clearAvoidJamPercentageText();
                clearAvoidJamDiscription();
                clearMrsl();
                clearIsDefault();
                this.cachedSize = -1;
                return this;
            }

            public AvoidJamInfo clearAvoidJamDiscription() {
                this.hasAvoidJamDiscription = false;
                this.avoidJamDiscription_ = "";
                return this;
            }

            public AvoidJamInfo clearAvoidJamPercentage() {
                this.hasAvoidJamPercentage = false;
                this.avoidJamPercentage_ = 0;
                return this;
            }

            public AvoidJamInfo clearAvoidJamPercentageText() {
                this.hasAvoidJamPercentageText = false;
                this.avoidJamPercentageText_ = "";
                return this;
            }

            public AvoidJamInfo clearIsDefault() {
                this.hasIsDefault = false;
                this.isDefault_ = false;
                return this;
            }

            public AvoidJamInfo clearMrsl() {
                this.mrsl_ = Collections.emptyList();
                return this;
            }

            public String getAvoidJamDiscription() {
                return this.avoidJamDiscription_;
            }

            public int getAvoidJamPercentage() {
                return this.avoidJamPercentage_;
            }

            public String getAvoidJamPercentageText() {
                return this.avoidJamPercentageText_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public boolean getIsDefault() {
                return this.isDefault_;
            }

            public String getMrsl(int i4) {
                return this.mrsl_.get(i4);
            }

            public int getMrslCount() {
                return this.mrsl_.size();
            }

            public List<String> getMrslList() {
                return this.mrsl_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iM = 0;
                int iE = hasAvoidJamPercentage() ? d.e(1, getAvoidJamPercentage()) : 0;
                if (hasAvoidJamPercentageText()) {
                    iE += d.l(2, getAvoidJamPercentageText());
                }
                if (hasAvoidJamDiscription()) {
                    iE += d.l(3, getAvoidJamDiscription());
                }
                Iterator<String> it = getMrslList().iterator();
                while (it.hasNext()) {
                    iM += d.m(it.next());
                }
                int size = getMrslList().size() + iE + iM;
                if (hasIsDefault()) {
                    getIsDefault();
                    size += d.a(5);
                }
                this.cachedSize = size;
                return size;
            }

            public boolean hasAvoidJamDiscription() {
                return this.hasAvoidJamDiscription;
            }

            public boolean hasAvoidJamPercentage() {
                return this.hasAvoidJamPercentage;
            }

            public boolean hasAvoidJamPercentageText() {
                return this.hasAvoidJamPercentageText;
            }

            public boolean hasIsDefault() {
                return this.hasIsDefault;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AvoidJamInfo setAvoidJamDiscription(String str) {
                this.hasAvoidJamDiscription = true;
                this.avoidJamDiscription_ = str;
                return this;
            }

            public AvoidJamInfo setAvoidJamPercentage(int i4) {
                this.hasAvoidJamPercentage = true;
                this.avoidJamPercentage_ = i4;
                return this;
            }

            public AvoidJamInfo setAvoidJamPercentageText(String str) {
                this.hasAvoidJamPercentageText = true;
                this.avoidJamPercentageText_ = str;
                return this;
            }

            public AvoidJamInfo setIsDefault(boolean z4) {
                this.hasIsDefault = true;
                this.isDefault_ = z4;
                return this;
            }

            public AvoidJamInfo setMrsl(int i4, String str) {
                str.getClass();
                this.mrsl_.set(i4, str);
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasAvoidJamPercentage()) {
                    dVar.s(1, getAvoidJamPercentage());
                }
                if (hasAvoidJamPercentageText()) {
                    dVar.A(2, getAvoidJamPercentageText());
                }
                if (hasAvoidJamDiscription()) {
                    dVar.A(3, getAvoidJamDiscription());
                }
                Iterator<String> it = getMrslList().iterator();
                while (it.hasNext()) {
                    dVar.A(4, it.next());
                }
                if (hasIsDefault()) {
                    dVar.p(5, getIsDefault());
                }
            }

            public static AvoidJamInfo parseFrom(byte[] bArr) throws e {
                return (AvoidJamInfo) new AvoidJamInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public AvoidJamInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setAvoidJamPercentage(bVar.k());
                    } else if (iO == 18) {
                        setAvoidJamPercentageText(bVar.n());
                    } else if (iO == 26) {
                        setAvoidJamDiscription(bVar.n());
                    } else if (iO == 34) {
                        addMrsl(bVar.n());
                    } else if (iO == 40) {
                        setIsDefault(bVar.a());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class AvoidJamInfoPrefer extends f {
            public static final int AVOID_JAM_INFO_FIELD_NUMBER = 1;
            public static final int PREFER_DISCRIPTION_FIELD_NUMBER = 3;
            public static final int SWITCH_AVOID_JAM_FIELD_NUMBER = 2;
            private boolean hasPreferDiscription;
            private boolean hasSwitchAvoidJam;
            private List<AvoidJamInfo> avoidJamInfo_ = Collections.emptyList();
            private boolean switchAvoidJam_ = false;
            private String preferDiscription_ = "";
            private int cachedSize = -1;

            public static AvoidJamInfoPrefer parseFrom(b bVar) throws IOException {
                return new AvoidJamInfoPrefer().mergeFrom(bVar);
            }

            public AvoidJamInfoPrefer addAvoidJamInfo(AvoidJamInfo avoidJamInfo) {
                if (avoidJamInfo == null) {
                    return this;
                }
                if (this.avoidJamInfo_.isEmpty()) {
                    this.avoidJamInfo_ = new ArrayList();
                }
                this.avoidJamInfo_.add(avoidJamInfo);
                return this;
            }

            public final AvoidJamInfoPrefer clear() {
                clearAvoidJamInfo();
                clearSwitchAvoidJam();
                clearPreferDiscription();
                this.cachedSize = -1;
                return this;
            }

            public AvoidJamInfoPrefer clearAvoidJamInfo() {
                this.avoidJamInfo_ = Collections.emptyList();
                return this;
            }

            public AvoidJamInfoPrefer clearPreferDiscription() {
                this.hasPreferDiscription = false;
                this.preferDiscription_ = "";
                return this;
            }

            public AvoidJamInfoPrefer clearSwitchAvoidJam() {
                this.hasSwitchAvoidJam = false;
                this.switchAvoidJam_ = false;
                return this;
            }

            public AvoidJamInfo getAvoidJamInfo(int i4) {
                return this.avoidJamInfo_.get(i4);
            }

            public int getAvoidJamInfoCount() {
                return this.avoidJamInfo_.size();
            }

            public List<AvoidJamInfo> getAvoidJamInfoList() {
                return this.avoidJamInfo_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getPreferDiscription() {
                return this.preferDiscription_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                Iterator<AvoidJamInfo> it = getAvoidJamInfoList().iterator();
                int iL = 0;
                while (it.hasNext()) {
                    iL += d.h(1, it.next());
                }
                if (hasSwitchAvoidJam()) {
                    getSwitchAvoidJam();
                    iL += d.a(2);
                }
                if (hasPreferDiscription()) {
                    iL += d.l(3, getPreferDiscription());
                }
                this.cachedSize = iL;
                return iL;
            }

            public boolean getSwitchAvoidJam() {
                return this.switchAvoidJam_;
            }

            public boolean hasPreferDiscription() {
                return this.hasPreferDiscription;
            }

            public boolean hasSwitchAvoidJam() {
                return this.hasSwitchAvoidJam;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AvoidJamInfoPrefer setAvoidJamInfo(int i4, AvoidJamInfo avoidJamInfo) {
                if (avoidJamInfo == null) {
                    return this;
                }
                this.avoidJamInfo_.set(i4, avoidJamInfo);
                return this;
            }

            public AvoidJamInfoPrefer setPreferDiscription(String str) {
                this.hasPreferDiscription = true;
                this.preferDiscription_ = str;
                return this;
            }

            public AvoidJamInfoPrefer setSwitchAvoidJam(boolean z4) {
                this.hasSwitchAvoidJam = true;
                this.switchAvoidJam_ = z4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                Iterator<AvoidJamInfo> it = getAvoidJamInfoList().iterator();
                while (it.hasNext()) {
                    dVar.u(1, it.next());
                }
                if (hasSwitchAvoidJam()) {
                    dVar.p(2, getSwitchAvoidJam());
                }
                if (hasPreferDiscription()) {
                    dVar.A(3, getPreferDiscription());
                }
            }

            public static AvoidJamInfoPrefer parseFrom(byte[] bArr) throws e {
                return (AvoidJamInfoPrefer) new AvoidJamInfoPrefer().mergeFrom(bArr);
            }

            @Override // L1.f
            public AvoidJamInfoPrefer mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        AvoidJamInfo avoidJamInfo = new AvoidJamInfo();
                        bVar.f(avoidJamInfo);
                        addAvoidJamInfo(avoidJamInfo);
                    } else if (iO == 16) {
                        setSwitchAvoidJam(bVar.a());
                    } else if (iO == 26) {
                        setPreferDiscription(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class LongDistanceInfo extends f {
            public static final int VIA_CHECKSER_FIELD_NUMBER = 4;
            public static final int VIA_CITY_INFO_FIELD_NUMBER = 1;
            public static final int VIA_MAIN_ROAD_FIELD_NUMBER = 2;
            public static final int VIA_SERVICE_FIELD_NUMBER = 3;
            private List<ViaCityInfo> viaCityInfo_ = Collections.emptyList();
            private List<ViaMainRoad> viaMainRoad_ = Collections.emptyList();
            private List<ViaService> viaService_ = Collections.emptyList();
            private List<ViaCheckSer> viaCheckser_ = Collections.emptyList();
            private int cachedSize = -1;

            public static final class Point extends f {
                public static final int X_FIELD_NUMBER = 1;
                public static final int Y_FIELD_NUMBER = 2;
                private boolean hasX;
                private boolean hasY;
                private double x_ = 0.0d;
                private double y_ = 0.0d;
                private int cachedSize = -1;

                public static Point parseFrom(b bVar) throws IOException {
                    return new Point().mergeFrom(bVar);
                }

                public final Point clear() {
                    clearX();
                    clearY();
                    this.cachedSize = -1;
                    return this;
                }

                public Point clearX() {
                    this.hasX = false;
                    this.x_ = 0.0d;
                    return this;
                }

                public Point clearY() {
                    this.hasY = false;
                    this.y_ = 0.0d;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iD;
                    if (hasX()) {
                        getX();
                        iD = d.d(1);
                    } else {
                        iD = 0;
                    }
                    if (hasY()) {
                        getY();
                        iD += d.d(2);
                    }
                    this.cachedSize = iD;
                    return iD;
                }

                public double getX() {
                    return this.x_;
                }

                public double getY() {
                    return this.y_;
                }

                public boolean hasX() {
                    return this.hasX;
                }

                public boolean hasY() {
                    return this.hasY;
                }

                public final boolean isInitialized() {
                    return this.hasX && this.hasY;
                }

                public Point setX(double d4) {
                    this.hasX = true;
                    this.x_ = d4;
                    return this;
                }

                public Point setY(double d4) {
                    this.hasY = true;
                    this.y_ = d4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasX()) {
                        dVar.r(1, getX());
                    }
                    if (hasY()) {
                        dVar.r(2, getY());
                    }
                }

                public static Point parseFrom(byte[] bArr) throws e {
                    return (Point) new Point().mergeFrom(bArr);
                }

                @Override // L1.f
                public Point mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 9) {
                            setX(bVar.c());
                        } else if (iO == 17) {
                            setY(bVar.c());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class ServiceGasInfo extends f {
                public static final int BRAND_FIELD_NUMBER = 2;
                public static final int GAS_TYPE_FIELD_NUMBER = 4;
                public static final int LABEL_FIELD_NUMBER = 3;
                public static final int STATION_STATUS_FIELD_NUMBER = 1;
                private boolean hasBrand;
                private boolean hasGasType;
                private boolean hasLabel;
                private boolean hasStationStatus;
                private int stationStatus_ = 0;
                private int brand_ = 0;
                private int label_ = 0;
                private int gasType_ = 0;
                private int cachedSize = -1;

                public static ServiceGasInfo parseFrom(b bVar) throws IOException {
                    return new ServiceGasInfo().mergeFrom(bVar);
                }

                public final ServiceGasInfo clear() {
                    clearStationStatus();
                    clearBrand();
                    clearLabel();
                    clearGasType();
                    this.cachedSize = -1;
                    return this;
                }

                public ServiceGasInfo clearBrand() {
                    this.hasBrand = false;
                    this.brand_ = 0;
                    return this;
                }

                public ServiceGasInfo clearGasType() {
                    this.hasGasType = false;
                    this.gasType_ = 0;
                    return this;
                }

                public ServiceGasInfo clearLabel() {
                    this.hasLabel = false;
                    this.label_ = 0;
                    return this;
                }

                public ServiceGasInfo clearStationStatus() {
                    this.hasStationStatus = false;
                    this.stationStatus_ = 0;
                    return this;
                }

                public int getBrand() {
                    return this.brand_;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getGasType() {
                    return this.gasType_;
                }

                public int getLabel() {
                    return this.label_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasStationStatus() ? d.e(1, getStationStatus()) : 0;
                    if (hasBrand()) {
                        iE += d.e(2, getBrand());
                    }
                    if (hasLabel()) {
                        iE += d.e(3, getLabel());
                    }
                    if (hasGasType()) {
                        iE += d.e(4, getGasType());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public int getStationStatus() {
                    return this.stationStatus_;
                }

                public boolean hasBrand() {
                    return this.hasBrand;
                }

                public boolean hasGasType() {
                    return this.hasGasType;
                }

                public boolean hasLabel() {
                    return this.hasLabel;
                }

                public boolean hasStationStatus() {
                    return this.hasStationStatus;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public ServiceGasInfo setBrand(int i4) {
                    this.hasBrand = true;
                    this.brand_ = i4;
                    return this;
                }

                public ServiceGasInfo setGasType(int i4) {
                    this.hasGasType = true;
                    this.gasType_ = i4;
                    return this;
                }

                public ServiceGasInfo setLabel(int i4) {
                    this.hasLabel = true;
                    this.label_ = i4;
                    return this;
                }

                public ServiceGasInfo setStationStatus(int i4) {
                    this.hasStationStatus = true;
                    this.stationStatus_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasStationStatus()) {
                        dVar.s(1, getStationStatus());
                    }
                    if (hasBrand()) {
                        dVar.s(2, getBrand());
                    }
                    if (hasLabel()) {
                        dVar.s(3, getLabel());
                    }
                    if (hasGasType()) {
                        dVar.s(4, getGasType());
                    }
                }

                public static ServiceGasInfo parseFrom(byte[] bArr) throws e {
                    return (ServiceGasInfo) new ServiceGasInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public ServiceGasInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setStationStatus(bVar.k());
                        } else if (iO == 16) {
                            setBrand(bVar.k());
                        } else if (iO == 24) {
                            setLabel(bVar.k());
                        } else if (iO == 32) {
                            setGasType(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class ViaCheckSer extends f {
                public static final int CAN_BE_VIA_NODE_FIELD_NUMBER = 5;
                public static final int CHECKSER_NAME_DISTANCE_FROM_START_FIELD_NUMBER = 2;
                public static final int CHECKSER_NAME_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 3;
                public static final int LABEL_POINT_FIELD_NUMBER = 4;
                private boolean hasCanBeViaNode;
                private boolean hasCheckserName;
                private boolean hasCheckserNameDistanceFromStart;
                private boolean hasDuration;
                private boolean hasLabelPoint;
                private String checkserName_ = "";
                private int checkserNameDistanceFromStart_ = 0;
                private int duration_ = 0;
                private Point labelPoint_ = null;
                private int canBeViaNode_ = 0;
                private int cachedSize = -1;

                public static ViaCheckSer parseFrom(b bVar) throws IOException {
                    return new ViaCheckSer().mergeFrom(bVar);
                }

                public final ViaCheckSer clear() {
                    clearCheckserName();
                    clearCheckserNameDistanceFromStart();
                    clearDuration();
                    clearLabelPoint();
                    clearCanBeViaNode();
                    this.cachedSize = -1;
                    return this;
                }

                public ViaCheckSer clearCanBeViaNode() {
                    this.hasCanBeViaNode = false;
                    this.canBeViaNode_ = 0;
                    return this;
                }

                public ViaCheckSer clearCheckserName() {
                    this.hasCheckserName = false;
                    this.checkserName_ = "";
                    return this;
                }

                public ViaCheckSer clearCheckserNameDistanceFromStart() {
                    this.hasCheckserNameDistanceFromStart = false;
                    this.checkserNameDistanceFromStart_ = 0;
                    return this;
                }

                public ViaCheckSer clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public ViaCheckSer clearLabelPoint() {
                    this.hasLabelPoint = false;
                    this.labelPoint_ = null;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCanBeViaNode() {
                    return this.canBeViaNode_;
                }

                public String getCheckserName() {
                    return this.checkserName_;
                }

                public int getCheckserNameDistanceFromStart() {
                    return this.checkserNameDistanceFromStart_;
                }

                public int getDuration() {
                    return this.duration_;
                }

                public Point getLabelPoint() {
                    return this.labelPoint_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasCheckserName() ? d.l(1, getCheckserName()) : 0;
                    if (hasCheckserNameDistanceFromStart()) {
                        iL += d.e(2, getCheckserNameDistanceFromStart());
                    }
                    if (hasDuration()) {
                        iL += d.e(3, getDuration());
                    }
                    if (hasLabelPoint()) {
                        iL += d.h(4, getLabelPoint());
                    }
                    if (hasCanBeViaNode()) {
                        iL += d.e(5, getCanBeViaNode());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public boolean hasCanBeViaNode() {
                    return this.hasCanBeViaNode;
                }

                public boolean hasCheckserName() {
                    return this.hasCheckserName;
                }

                public boolean hasCheckserNameDistanceFromStart() {
                    return this.hasCheckserNameDistanceFromStart;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasLabelPoint() {
                    return this.hasLabelPoint;
                }

                public final boolean isInitialized() {
                    return this.hasCheckserName && this.hasCheckserNameDistanceFromStart && this.hasDuration && this.hasLabelPoint && this.hasCanBeViaNode && getLabelPoint().isInitialized();
                }

                public ViaCheckSer setCanBeViaNode(int i4) {
                    this.hasCanBeViaNode = true;
                    this.canBeViaNode_ = i4;
                    return this;
                }

                public ViaCheckSer setCheckserName(String str) {
                    this.hasCheckserName = true;
                    this.checkserName_ = str;
                    return this;
                }

                public ViaCheckSer setCheckserNameDistanceFromStart(int i4) {
                    this.hasCheckserNameDistanceFromStart = true;
                    this.checkserNameDistanceFromStart_ = i4;
                    return this;
                }

                public ViaCheckSer setDuration(int i4) {
                    this.hasDuration = true;
                    this.duration_ = i4;
                    return this;
                }

                public ViaCheckSer setLabelPoint(Point point) {
                    if (point == null) {
                        return clearLabelPoint();
                    }
                    this.hasLabelPoint = true;
                    this.labelPoint_ = point;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasCheckserName()) {
                        dVar.A(1, getCheckserName());
                    }
                    if (hasCheckserNameDistanceFromStart()) {
                        dVar.s(2, getCheckserNameDistanceFromStart());
                    }
                    if (hasDuration()) {
                        dVar.s(3, getDuration());
                    }
                    if (hasLabelPoint()) {
                        dVar.u(4, getLabelPoint());
                    }
                    if (hasCanBeViaNode()) {
                        dVar.s(5, getCanBeViaNode());
                    }
                }

                public static ViaCheckSer parseFrom(byte[] bArr) throws e {
                    return (ViaCheckSer) new ViaCheckSer().mergeFrom(bArr);
                }

                @Override // L1.f
                public ViaCheckSer mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setCheckserName(bVar.n());
                        } else if (iO == 16) {
                            setCheckserNameDistanceFromStart(bVar.k());
                        } else if (iO == 24) {
                            setDuration(bVar.k());
                        } else if (iO == 34) {
                            Point point = new Point();
                            bVar.f(point);
                            setLabelPoint(point);
                        } else if (iO == 40) {
                            setCanBeViaNode(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class ViaCityInfo extends f {
                public static final int CITY_DISTANCE_FROM_START_FIELD_NUMBER = 3;
                public static final int CITY_ID_FIELD_NUMBER = 2;
                public static final int CITY_NAME_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 4;
                public static final int POINT_FIELD_NUMBER = 6;
                public static final int PRIORITY_FIELD_NUMBER = 5;
                private boolean hasCityDistanceFromStart;
                private boolean hasCityId;
                private boolean hasCityName;
                private boolean hasDuration;
                private boolean hasPoint;
                private boolean hasPriority;
                private String cityName_ = "";
                private int cityId_ = 0;
                private int cityDistanceFromStart_ = 0;
                private int duration_ = 0;
                private int priority_ = 0;
                private Point point_ = null;
                private int cachedSize = -1;

                public static ViaCityInfo parseFrom(b bVar) throws IOException {
                    return new ViaCityInfo().mergeFrom(bVar);
                }

                public final ViaCityInfo clear() {
                    clearCityName();
                    clearCityId();
                    clearCityDistanceFromStart();
                    clearDuration();
                    clearPriority();
                    clearPoint();
                    this.cachedSize = -1;
                    return this;
                }

                public ViaCityInfo clearCityDistanceFromStart() {
                    this.hasCityDistanceFromStart = false;
                    this.cityDistanceFromStart_ = 0;
                    return this;
                }

                public ViaCityInfo clearCityId() {
                    this.hasCityId = false;
                    this.cityId_ = 0;
                    return this;
                }

                public ViaCityInfo clearCityName() {
                    this.hasCityName = false;
                    this.cityName_ = "";
                    return this;
                }

                public ViaCityInfo clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public ViaCityInfo clearPoint() {
                    this.hasPoint = false;
                    this.point_ = null;
                    return this;
                }

                public ViaCityInfo clearPriority() {
                    this.hasPriority = false;
                    this.priority_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCityDistanceFromStart() {
                    return this.cityDistanceFromStart_;
                }

                public int getCityId() {
                    return this.cityId_;
                }

                public String getCityName() {
                    return this.cityName_;
                }

                public int getDuration() {
                    return this.duration_;
                }

                public Point getPoint() {
                    return this.point_;
                }

                public int getPriority() {
                    return this.priority_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasCityName() ? d.l(1, getCityName()) : 0;
                    if (hasCityId()) {
                        iL += d.e(2, getCityId());
                    }
                    if (hasCityDistanceFromStart()) {
                        iL += d.e(3, getCityDistanceFromStart());
                    }
                    if (hasDuration()) {
                        iL += d.e(4, getDuration());
                    }
                    if (hasPriority()) {
                        iL += d.e(5, getPriority());
                    }
                    if (hasPoint()) {
                        iL += d.h(6, getPoint());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public boolean hasCityDistanceFromStart() {
                    return this.hasCityDistanceFromStart;
                }

                public boolean hasCityId() {
                    return this.hasCityId;
                }

                public boolean hasCityName() {
                    return this.hasCityName;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasPoint() {
                    return this.hasPoint;
                }

                public boolean hasPriority() {
                    return this.hasPriority;
                }

                public final boolean isInitialized() {
                    return this.hasCityName && this.hasCityId && this.hasCityDistanceFromStart && this.hasDuration && this.hasPoint && getPoint().isInitialized();
                }

                public ViaCityInfo setCityDistanceFromStart(int i4) {
                    this.hasCityDistanceFromStart = true;
                    this.cityDistanceFromStart_ = i4;
                    return this;
                }

                public ViaCityInfo setCityId(int i4) {
                    this.hasCityId = true;
                    this.cityId_ = i4;
                    return this;
                }

                public ViaCityInfo setCityName(String str) {
                    this.hasCityName = true;
                    this.cityName_ = str;
                    return this;
                }

                public ViaCityInfo setDuration(int i4) {
                    this.hasDuration = true;
                    this.duration_ = i4;
                    return this;
                }

                public ViaCityInfo setPoint(Point point) {
                    if (point == null) {
                        return clearPoint();
                    }
                    this.hasPoint = true;
                    this.point_ = point;
                    return this;
                }

                public ViaCityInfo setPriority(int i4) {
                    this.hasPriority = true;
                    this.priority_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasCityName()) {
                        dVar.A(1, getCityName());
                    }
                    if (hasCityId()) {
                        dVar.s(2, getCityId());
                    }
                    if (hasCityDistanceFromStart()) {
                        dVar.s(3, getCityDistanceFromStart());
                    }
                    if (hasDuration()) {
                        dVar.s(4, getDuration());
                    }
                    if (hasPriority()) {
                        dVar.s(5, getPriority());
                    }
                    if (hasPoint()) {
                        dVar.u(6, getPoint());
                    }
                }

                public static ViaCityInfo parseFrom(byte[] bArr) throws e {
                    return (ViaCityInfo) new ViaCityInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public ViaCityInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setCityName(bVar.n());
                        } else if (iO == 16) {
                            setCityId(bVar.k());
                        } else if (iO == 24) {
                            setCityDistanceFromStart(bVar.k());
                        } else if (iO == 32) {
                            setDuration(bVar.k());
                        } else if (iO == 40) {
                            setPriority(bVar.k());
                        } else if (iO == 50) {
                            Point point = new Point();
                            bVar.f(point);
                            setPoint(point);
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class ViaMainRoad extends f {
                public static final int DISTANCE_FIELD_NUMBER = 5;
                public static final int END_FIELD_NUMBER = 8;
                public static final int LABEL_POINT_FIELD_NUMBER = 6;
                public static final int LANE_COUNT_FIELD_NUMBER = 3;
                public static final int MAIN_ROAD_NAME_FIELD_NUMBER = 1;
                public static final int MAIN_ROAD_TYPE_FIELD_NUMBER = 2;
                public static final int SPEED_LIMIT_FIELD_NUMBER = 4;
                public static final int START_FIELD_NUMBER = 7;
                private boolean hasDistance;
                private boolean hasEnd;
                private boolean hasLabelPoint;
                private boolean hasLaneCount;
                private boolean hasMainRoadName;
                private boolean hasMainRoadType;
                private boolean hasSpeedLimit;
                private boolean hasStart;
                private String mainRoadName_ = "";
                private int mainRoadType_ = 0;
                private String laneCount_ = "";
                private String speedLimit_ = "";
                private int distance_ = 0;
                private Point labelPoint_ = null;
                private Point start_ = null;
                private Point end_ = null;
                private int cachedSize = -1;

                public static ViaMainRoad parseFrom(b bVar) throws IOException {
                    return new ViaMainRoad().mergeFrom(bVar);
                }

                public final ViaMainRoad clear() {
                    clearMainRoadName();
                    clearMainRoadType();
                    clearLaneCount();
                    clearSpeedLimit();
                    clearDistance();
                    clearLabelPoint();
                    clearStart();
                    clearEnd();
                    this.cachedSize = -1;
                    return this;
                }

                public ViaMainRoad clearDistance() {
                    this.hasDistance = false;
                    this.distance_ = 0;
                    return this;
                }

                public ViaMainRoad clearEnd() {
                    this.hasEnd = false;
                    this.end_ = null;
                    return this;
                }

                public ViaMainRoad clearLabelPoint() {
                    this.hasLabelPoint = false;
                    this.labelPoint_ = null;
                    return this;
                }

                public ViaMainRoad clearLaneCount() {
                    this.hasLaneCount = false;
                    this.laneCount_ = "";
                    return this;
                }

                public ViaMainRoad clearMainRoadName() {
                    this.hasMainRoadName = false;
                    this.mainRoadName_ = "";
                    return this;
                }

                public ViaMainRoad clearMainRoadType() {
                    this.hasMainRoadType = false;
                    this.mainRoadType_ = 0;
                    return this;
                }

                public ViaMainRoad clearSpeedLimit() {
                    this.hasSpeedLimit = false;
                    this.speedLimit_ = "";
                    return this;
                }

                public ViaMainRoad clearStart() {
                    this.hasStart = false;
                    this.start_ = null;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getDistance() {
                    return this.distance_;
                }

                public Point getEnd() {
                    return this.end_;
                }

                public Point getLabelPoint() {
                    return this.labelPoint_;
                }

                public String getLaneCount() {
                    return this.laneCount_;
                }

                public String getMainRoadName() {
                    return this.mainRoadName_;
                }

                public int getMainRoadType() {
                    return this.mainRoadType_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasMainRoadName() ? d.l(1, getMainRoadName()) : 0;
                    if (hasMainRoadType()) {
                        iL += d.e(2, getMainRoadType());
                    }
                    if (hasLaneCount()) {
                        iL += d.l(3, getLaneCount());
                    }
                    if (hasSpeedLimit()) {
                        iL += d.l(4, getSpeedLimit());
                    }
                    if (hasDistance()) {
                        iL += d.e(5, getDistance());
                    }
                    if (hasLabelPoint()) {
                        iL += d.h(6, getLabelPoint());
                    }
                    if (hasStart()) {
                        iL += d.h(7, getStart());
                    }
                    if (hasEnd()) {
                        iL += d.h(8, getEnd());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public String getSpeedLimit() {
                    return this.speedLimit_;
                }

                public Point getStart() {
                    return this.start_;
                }

                public boolean hasDistance() {
                    return this.hasDistance;
                }

                public boolean hasEnd() {
                    return this.hasEnd;
                }

                public boolean hasLabelPoint() {
                    return this.hasLabelPoint;
                }

                public boolean hasLaneCount() {
                    return this.hasLaneCount;
                }

                public boolean hasMainRoadName() {
                    return this.hasMainRoadName;
                }

                public boolean hasMainRoadType() {
                    return this.hasMainRoadType;
                }

                public boolean hasSpeedLimit() {
                    return this.hasSpeedLimit;
                }

                public boolean hasStart() {
                    return this.hasStart;
                }

                public final boolean isInitialized() {
                    return this.hasMainRoadName && this.hasMainRoadType && this.hasDistance && this.hasLabelPoint && this.hasStart && this.hasEnd && getLabelPoint().isInitialized() && getStart().isInitialized() && getEnd().isInitialized();
                }

                public ViaMainRoad setDistance(int i4) {
                    this.hasDistance = true;
                    this.distance_ = i4;
                    return this;
                }

                public ViaMainRoad setEnd(Point point) {
                    if (point == null) {
                        return clearEnd();
                    }
                    this.hasEnd = true;
                    this.end_ = point;
                    return this;
                }

                public ViaMainRoad setLabelPoint(Point point) {
                    if (point == null) {
                        return clearLabelPoint();
                    }
                    this.hasLabelPoint = true;
                    this.labelPoint_ = point;
                    return this;
                }

                public ViaMainRoad setLaneCount(String str) {
                    this.hasLaneCount = true;
                    this.laneCount_ = str;
                    return this;
                }

                public ViaMainRoad setMainRoadName(String str) {
                    this.hasMainRoadName = true;
                    this.mainRoadName_ = str;
                    return this;
                }

                public ViaMainRoad setMainRoadType(int i4) {
                    this.hasMainRoadType = true;
                    this.mainRoadType_ = i4;
                    return this;
                }

                public ViaMainRoad setSpeedLimit(String str) {
                    this.hasSpeedLimit = true;
                    this.speedLimit_ = str;
                    return this;
                }

                public ViaMainRoad setStart(Point point) {
                    if (point == null) {
                        return clearStart();
                    }
                    this.hasStart = true;
                    this.start_ = point;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasMainRoadName()) {
                        dVar.A(1, getMainRoadName());
                    }
                    if (hasMainRoadType()) {
                        dVar.s(2, getMainRoadType());
                    }
                    if (hasLaneCount()) {
                        dVar.A(3, getLaneCount());
                    }
                    if (hasSpeedLimit()) {
                        dVar.A(4, getSpeedLimit());
                    }
                    if (hasDistance()) {
                        dVar.s(5, getDistance());
                    }
                    if (hasLabelPoint()) {
                        dVar.u(6, getLabelPoint());
                    }
                    if (hasStart()) {
                        dVar.u(7, getStart());
                    }
                    if (hasEnd()) {
                        dVar.u(8, getEnd());
                    }
                }

                public static ViaMainRoad parseFrom(byte[] bArr) throws e {
                    return (ViaMainRoad) new ViaMainRoad().mergeFrom(bArr);
                }

                @Override // L1.f
                public ViaMainRoad mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setMainRoadName(bVar.n());
                        } else if (iO == 16) {
                            setMainRoadType(bVar.k());
                        } else if (iO == 26) {
                            setLaneCount(bVar.n());
                        } else if (iO == 34) {
                            setSpeedLimit(bVar.n());
                        } else if (iO == 40) {
                            setDistance(bVar.k());
                        } else if (iO == 50) {
                            Point point = new Point();
                            bVar.f(point);
                            setLabelPoint(point);
                        } else if (iO == 58) {
                            Point point2 = new Point();
                            bVar.f(point2);
                            setStart(point2);
                        } else if (iO == 66) {
                            Point point3 = new Point();
                            bVar.f(point3);
                            setEnd(point3);
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class ViaService extends f {
                public static final int CAN_BE_VIA_NODE_FIELD_NUMBER = 5;
                public static final int DURATION_FIELD_NUMBER = 3;
                public static final int LABEL_POINT_FIELD_NUMBER = 4;
                public static final int SERVICE_DISTANCE_FROM_START_FIELD_NUMBER = 2;
                public static final int SERVICE_GAS_INFO_FIELD_NUMBER = 7;
                public static final int SERVICE_NAME_FIELD_NUMBER = 1;
                public static final int SERVICE_SUPPORT_FIELD_NUMBER = 6;
                private boolean hasCanBeViaNode;
                private boolean hasDuration;
                private boolean hasLabelPoint;
                private boolean hasServiceDistanceFromStart;
                private boolean hasServiceGasInfo;
                private boolean hasServiceName;
                private boolean hasServiceSupport;
                private String serviceName_ = "";
                private int serviceDistanceFromStart_ = 0;
                private int duration_ = 0;
                private Point labelPoint_ = null;
                private int canBeViaNode_ = 0;
                private int serviceSupport_ = 0;
                private ServiceGasInfo serviceGasInfo_ = null;
                private int cachedSize = -1;

                public static ViaService parseFrom(b bVar) throws IOException {
                    return new ViaService().mergeFrom(bVar);
                }

                public final ViaService clear() {
                    clearServiceName();
                    clearServiceDistanceFromStart();
                    clearDuration();
                    clearLabelPoint();
                    clearCanBeViaNode();
                    clearServiceSupport();
                    clearServiceGasInfo();
                    this.cachedSize = -1;
                    return this;
                }

                public ViaService clearCanBeViaNode() {
                    this.hasCanBeViaNode = false;
                    this.canBeViaNode_ = 0;
                    return this;
                }

                public ViaService clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public ViaService clearLabelPoint() {
                    this.hasLabelPoint = false;
                    this.labelPoint_ = null;
                    return this;
                }

                public ViaService clearServiceDistanceFromStart() {
                    this.hasServiceDistanceFromStart = false;
                    this.serviceDistanceFromStart_ = 0;
                    return this;
                }

                public ViaService clearServiceGasInfo() {
                    this.hasServiceGasInfo = false;
                    this.serviceGasInfo_ = null;
                    return this;
                }

                public ViaService clearServiceName() {
                    this.hasServiceName = false;
                    this.serviceName_ = "";
                    return this;
                }

                public ViaService clearServiceSupport() {
                    this.hasServiceSupport = false;
                    this.serviceSupport_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCanBeViaNode() {
                    return this.canBeViaNode_;
                }

                public int getDuration() {
                    return this.duration_;
                }

                public Point getLabelPoint() {
                    return this.labelPoint_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasServiceName() ? d.l(1, getServiceName()) : 0;
                    if (hasServiceDistanceFromStart()) {
                        iL += d.e(2, getServiceDistanceFromStart());
                    }
                    if (hasDuration()) {
                        iL += d.e(3, getDuration());
                    }
                    if (hasLabelPoint()) {
                        iL += d.h(4, getLabelPoint());
                    }
                    if (hasCanBeViaNode()) {
                        iL += d.e(5, getCanBeViaNode());
                    }
                    if (hasServiceSupport()) {
                        iL += d.e(6, getServiceSupport());
                    }
                    if (hasServiceGasInfo()) {
                        iL += d.h(7, getServiceGasInfo());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public int getServiceDistanceFromStart() {
                    return this.serviceDistanceFromStart_;
                }

                public ServiceGasInfo getServiceGasInfo() {
                    return this.serviceGasInfo_;
                }

                public String getServiceName() {
                    return this.serviceName_;
                }

                public int getServiceSupport() {
                    return this.serviceSupport_;
                }

                public boolean hasCanBeViaNode() {
                    return this.hasCanBeViaNode;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasLabelPoint() {
                    return this.hasLabelPoint;
                }

                public boolean hasServiceDistanceFromStart() {
                    return this.hasServiceDistanceFromStart;
                }

                public boolean hasServiceGasInfo() {
                    return this.hasServiceGasInfo;
                }

                public boolean hasServiceName() {
                    return this.hasServiceName;
                }

                public boolean hasServiceSupport() {
                    return this.hasServiceSupport;
                }

                public final boolean isInitialized() {
                    return this.hasServiceName && this.hasServiceDistanceFromStart && this.hasDuration && this.hasLabelPoint && this.hasCanBeViaNode && getLabelPoint().isInitialized();
                }

                public ViaService setCanBeViaNode(int i4) {
                    this.hasCanBeViaNode = true;
                    this.canBeViaNode_ = i4;
                    return this;
                }

                public ViaService setDuration(int i4) {
                    this.hasDuration = true;
                    this.duration_ = i4;
                    return this;
                }

                public ViaService setLabelPoint(Point point) {
                    if (point == null) {
                        return clearLabelPoint();
                    }
                    this.hasLabelPoint = true;
                    this.labelPoint_ = point;
                    return this;
                }

                public ViaService setServiceDistanceFromStart(int i4) {
                    this.hasServiceDistanceFromStart = true;
                    this.serviceDistanceFromStart_ = i4;
                    return this;
                }

                public ViaService setServiceGasInfo(ServiceGasInfo serviceGasInfo) {
                    if (serviceGasInfo == null) {
                        return clearServiceGasInfo();
                    }
                    this.hasServiceGasInfo = true;
                    this.serviceGasInfo_ = serviceGasInfo;
                    return this;
                }

                public ViaService setServiceName(String str) {
                    this.hasServiceName = true;
                    this.serviceName_ = str;
                    return this;
                }

                public ViaService setServiceSupport(int i4) {
                    this.hasServiceSupport = true;
                    this.serviceSupport_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasServiceName()) {
                        dVar.A(1, getServiceName());
                    }
                    if (hasServiceDistanceFromStart()) {
                        dVar.s(2, getServiceDistanceFromStart());
                    }
                    if (hasDuration()) {
                        dVar.s(3, getDuration());
                    }
                    if (hasLabelPoint()) {
                        dVar.u(4, getLabelPoint());
                    }
                    if (hasCanBeViaNode()) {
                        dVar.s(5, getCanBeViaNode());
                    }
                    if (hasServiceSupport()) {
                        dVar.s(6, getServiceSupport());
                    }
                    if (hasServiceGasInfo()) {
                        dVar.u(7, getServiceGasInfo());
                    }
                }

                public static ViaService parseFrom(byte[] bArr) throws e {
                    return (ViaService) new ViaService().mergeFrom(bArr);
                }

                @Override // L1.f
                public ViaService mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setServiceName(bVar.n());
                        } else if (iO == 16) {
                            setServiceDistanceFromStart(bVar.k());
                        } else if (iO == 24) {
                            setDuration(bVar.k());
                        } else if (iO == 34) {
                            Point point = new Point();
                            bVar.f(point);
                            setLabelPoint(point);
                        } else if (iO == 40) {
                            setCanBeViaNode(bVar.k());
                        } else if (iO == 48) {
                            setServiceSupport(bVar.k());
                        } else if (iO == 58) {
                            ServiceGasInfo serviceGasInfo = new ServiceGasInfo();
                            bVar.f(serviceGasInfo);
                            setServiceGasInfo(serviceGasInfo);
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static LongDistanceInfo parseFrom(b bVar) throws IOException {
                return new LongDistanceInfo().mergeFrom(bVar);
            }

            public LongDistanceInfo addViaCheckser(ViaCheckSer viaCheckSer) {
                if (viaCheckSer == null) {
                    return this;
                }
                if (this.viaCheckser_.isEmpty()) {
                    this.viaCheckser_ = new ArrayList();
                }
                this.viaCheckser_.add(viaCheckSer);
                return this;
            }

            public LongDistanceInfo addViaCityInfo(ViaCityInfo viaCityInfo) {
                if (viaCityInfo == null) {
                    return this;
                }
                if (this.viaCityInfo_.isEmpty()) {
                    this.viaCityInfo_ = new ArrayList();
                }
                this.viaCityInfo_.add(viaCityInfo);
                return this;
            }

            public LongDistanceInfo addViaMainRoad(ViaMainRoad viaMainRoad) {
                if (viaMainRoad == null) {
                    return this;
                }
                if (this.viaMainRoad_.isEmpty()) {
                    this.viaMainRoad_ = new ArrayList();
                }
                this.viaMainRoad_.add(viaMainRoad);
                return this;
            }

            public LongDistanceInfo addViaService(ViaService viaService) {
                if (viaService == null) {
                    return this;
                }
                if (this.viaService_.isEmpty()) {
                    this.viaService_ = new ArrayList();
                }
                this.viaService_.add(viaService);
                return this;
            }

            public final LongDistanceInfo clear() {
                clearViaCityInfo();
                clearViaMainRoad();
                clearViaService();
                clearViaCheckser();
                this.cachedSize = -1;
                return this;
            }

            public LongDistanceInfo clearViaCheckser() {
                this.viaCheckser_ = Collections.emptyList();
                return this;
            }

            public LongDistanceInfo clearViaCityInfo() {
                this.viaCityInfo_ = Collections.emptyList();
                return this;
            }

            public LongDistanceInfo clearViaMainRoad() {
                this.viaMainRoad_ = Collections.emptyList();
                return this;
            }

            public LongDistanceInfo clearViaService() {
                this.viaService_ = Collections.emptyList();
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            @Override // L1.f
            public int getSerializedSize() {
                Iterator<ViaCityInfo> it = getViaCityInfoList().iterator();
                int iH = 0;
                while (it.hasNext()) {
                    iH += d.h(1, it.next());
                }
                Iterator<ViaMainRoad> it2 = getViaMainRoadList().iterator();
                while (it2.hasNext()) {
                    iH += d.h(2, it2.next());
                }
                Iterator<ViaService> it3 = getViaServiceList().iterator();
                while (it3.hasNext()) {
                    iH += d.h(3, it3.next());
                }
                Iterator<ViaCheckSer> it4 = getViaCheckserList().iterator();
                while (it4.hasNext()) {
                    iH += d.h(4, it4.next());
                }
                this.cachedSize = iH;
                return iH;
            }

            public ViaCheckSer getViaCheckser(int i4) {
                return this.viaCheckser_.get(i4);
            }

            public int getViaCheckserCount() {
                return this.viaCheckser_.size();
            }

            public List<ViaCheckSer> getViaCheckserList() {
                return this.viaCheckser_;
            }

            public ViaCityInfo getViaCityInfo(int i4) {
                return this.viaCityInfo_.get(i4);
            }

            public int getViaCityInfoCount() {
                return this.viaCityInfo_.size();
            }

            public List<ViaCityInfo> getViaCityInfoList() {
                return this.viaCityInfo_;
            }

            public ViaMainRoad getViaMainRoad(int i4) {
                return this.viaMainRoad_.get(i4);
            }

            public int getViaMainRoadCount() {
                return this.viaMainRoad_.size();
            }

            public List<ViaMainRoad> getViaMainRoadList() {
                return this.viaMainRoad_;
            }

            public ViaService getViaService(int i4) {
                return this.viaService_.get(i4);
            }

            public int getViaServiceCount() {
                return this.viaService_.size();
            }

            public List<ViaService> getViaServiceList() {
                return this.viaService_;
            }

            public final boolean isInitialized() {
                Iterator<ViaCityInfo> it = getViaCityInfoList().iterator();
                while (it.hasNext()) {
                    if (!it.next().isInitialized()) {
                        return false;
                    }
                }
                Iterator<ViaMainRoad> it2 = getViaMainRoadList().iterator();
                while (it2.hasNext()) {
                    if (!it2.next().isInitialized()) {
                        return false;
                    }
                }
                Iterator<ViaService> it3 = getViaServiceList().iterator();
                while (it3.hasNext()) {
                    if (!it3.next().isInitialized()) {
                        return false;
                    }
                }
                Iterator<ViaCheckSer> it4 = getViaCheckserList().iterator();
                while (it4.hasNext()) {
                    if (!it4.next().isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public LongDistanceInfo setViaCheckser(int i4, ViaCheckSer viaCheckSer) {
                if (viaCheckSer == null) {
                    return this;
                }
                this.viaCheckser_.set(i4, viaCheckSer);
                return this;
            }

            public LongDistanceInfo setViaCityInfo(int i4, ViaCityInfo viaCityInfo) {
                if (viaCityInfo == null) {
                    return this;
                }
                this.viaCityInfo_.set(i4, viaCityInfo);
                return this;
            }

            public LongDistanceInfo setViaMainRoad(int i4, ViaMainRoad viaMainRoad) {
                if (viaMainRoad == null) {
                    return this;
                }
                this.viaMainRoad_.set(i4, viaMainRoad);
                return this;
            }

            public LongDistanceInfo setViaService(int i4, ViaService viaService) {
                if (viaService == null) {
                    return this;
                }
                this.viaService_.set(i4, viaService);
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                Iterator<ViaCityInfo> it = getViaCityInfoList().iterator();
                while (it.hasNext()) {
                    dVar.u(1, it.next());
                }
                Iterator<ViaMainRoad> it2 = getViaMainRoadList().iterator();
                while (it2.hasNext()) {
                    dVar.u(2, it2.next());
                }
                Iterator<ViaService> it3 = getViaServiceList().iterator();
                while (it3.hasNext()) {
                    dVar.u(3, it3.next());
                }
                Iterator<ViaCheckSer> it4 = getViaCheckserList().iterator();
                while (it4.hasNext()) {
                    dVar.u(4, it4.next());
                }
            }

            public static LongDistanceInfo parseFrom(byte[] bArr) throws e {
                return (LongDistanceInfo) new LongDistanceInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public LongDistanceInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        ViaCityInfo viaCityInfo = new ViaCityInfo();
                        bVar.f(viaCityInfo);
                        addViaCityInfo(viaCityInfo);
                    } else if (iO == 18) {
                        ViaMainRoad viaMainRoad = new ViaMainRoad();
                        bVar.f(viaMainRoad);
                        addViaMainRoad(viaMainRoad);
                    } else if (iO == 26) {
                        ViaService viaService = new ViaService();
                        bVar.f(viaService);
                        addViaService(viaService);
                    } else if (iO == 34) {
                        ViaCheckSer viaCheckSer = new ViaCheckSer();
                        bVar.f(viaCheckSer);
                        addViaCheckser(viaCheckSer);
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Point extends f {
            public static final int X_FIELD_NUMBER = 1;
            public static final int Y_FIELD_NUMBER = 2;
            private boolean hasX;
            private boolean hasY;
            private double x_ = 0.0d;
            private double y_ = 0.0d;
            private int cachedSize = -1;

            public static Point parseFrom(b bVar) throws IOException {
                return new Point().mergeFrom(bVar);
            }

            public final Point clear() {
                clearX();
                clearY();
                this.cachedSize = -1;
                return this;
            }

            public Point clearX() {
                this.hasX = false;
                this.x_ = 0.0d;
                return this;
            }

            public Point clearY() {
                this.hasY = false;
                this.y_ = 0.0d;
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iD;
                if (hasX()) {
                    getX();
                    iD = d.d(1);
                } else {
                    iD = 0;
                }
                if (hasY()) {
                    getY();
                    iD += d.d(2);
                }
                this.cachedSize = iD;
                return iD;
            }

            public double getX() {
                return this.x_;
            }

            public double getY() {
                return this.y_;
            }

            public boolean hasX() {
                return this.hasX;
            }

            public boolean hasY() {
                return this.hasY;
            }

            public final boolean isInitialized() {
                return this.hasX && this.hasY;
            }

            public Point setX(double d4) {
                this.hasX = true;
                this.x_ = d4;
                return this;
            }

            public Point setY(double d4) {
                this.hasY = true;
                this.y_ = d4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasX()) {
                    dVar.r(1, getX());
                }
                if (hasY()) {
                    dVar.r(2, getY());
                }
            }

            public static Point parseFrom(byte[] bArr) throws e {
                return (Point) new Point().mergeFrom(bArr);
            }

            @Override // L1.f
            public Point mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 9) {
                        setX(bVar.c());
                    } else if (iO == 17) {
                        setY(bVar.c());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Routes extends f {
            public static final int CAMERA_INFO_FIELD_NUMBER = 28;
            public static final int CARROUTEPLANPREFERAVOIDJAM = 16;
            public static final int CARROUTEPLANPREFERCARNUM = 32;
            public static final int CARROUTEPLANPREFERDEFAULT = 1;
            public static final int CARROUTEPLANPREFERHIGHWAY = 2;
            public static final int CARROUTEPLANPREFERINVALID = 0;
            public static final int CARROUTEPLANPREFERNOHIGHWAY = 4;
            public static final int CARROUTEPLANPREFERNOTOLL = 8;
            public static final int CAR_PREFER_ARRAY_FIELD_NUMBER = 12;
            public static final int CONGESTION_LENGTH_FIELD_NUMBER = 9;
            public static final int DESC_FIELD_NUMBER = 1;
            public static final int DESC_INFO_FIELD_NUMBER = 23;
            public static final int HIT_CAR_RULES_FIELD_NUMBER = 18;
            public static final int IS_COLLECTED_FIELD_NUMBER = 22;
            public static final int IS_RP_BYPART_FIELD_NUMBER = 20;
            public static final int LEGS_FIELD_NUMBER = 3;
            public static final int LIGHT_NUM_FIELD_NUMBER = 7;
            public static final int LIGHT_WAIT_TIME_FIELD_NUMBER = 34;
            public static final int MAIN_ROADS_FIELD_NUMBER = 5;
            public static final int MRSL_FIELD_NUMBER = 2;
            public static final int NE_LIST_PAGE_PANEL_FIELD_NUMBER = 30;
            public static final int NE_PANEL_INFO_FIELD_NUMBER = 25;
            public static final int NE_ROUTE_LABEL_FIELD_NUMBER = 32;
            public static final int OIL_TOLL_FIELD_NUMBER = 24;
            public static final int ROUTE_DESC_FIELD_NUMBER = 16;
            public static final int ROUTE_EVENT_FIELD_NUMBER = 27;
            public static final int ROUTE_LABEL_DESC_FIELD_NUMBER = 31;
            public static final int ROUTE_LABEL_FIELD_NUMBER = 26;
            public static final int ROUTE_LABEL_NAME_FIELD_NUMBER = 13;
            public static final int ROUTE_LABEL_TIPS_FIELD_NUMBER = 14;
            public static final int ROUTE_MD5_FIELD_NUMBER = 17;
            public static final int ROUTE_UNIQ_ID_FIELD_NUMBER = 21;
            public static final int STREET_VIEW_FIELD_NUMBER = 29;
            public static final int TAB_FIELD_NUMBER = 10;
            public static final int TAX_PRICE_FIELD_NUMBER = 19;
            public static final int TOLL_FIELD_NUMBER = 6;
            public static final int TRAFFIC_CONDITION_FIELD_NUMBER = 4;
            public static final int TRAFFIC_RESTRICTION_FLGS_FIELD_NUMBER = 35;
            public static final int TRANS_ROUTE_TAG_INFO_FIELD_NUMBER = 33;
            public static final int UGC_TIPS_FIELD_NUMBER = 15;
            public static final int WAITING_TIME_FIELD_NUMBER = 8;
            public static final int WHOLE_CONDITION_FIELD_NUMBER = 11;
            private boolean hasCarPreferArray;
            private boolean hasCongestionLength;
            private boolean hasDesc;
            private boolean hasDescInfo;
            private boolean hasIsCollected;
            private boolean hasIsRpBypart;
            private boolean hasLightNum;
            private boolean hasLightWaitTime;
            private boolean hasMainRoads;
            private boolean hasMrsl;
            private boolean hasNeRouteLabel;
            private boolean hasOilToll;
            private boolean hasRouteDesc;
            private boolean hasRouteLabel;
            private boolean hasRouteLabelDesc;
            private boolean hasRouteLabelName;
            private boolean hasRouteLabelTips;
            private boolean hasRouteMd5;
            private boolean hasRouteUniqId;
            private boolean hasStreetView;
            private boolean hasTab;
            private boolean hasTaxPrice;
            private boolean hasToll;
            private boolean hasTrafficCondition;
            private boolean hasTrafficRestrictionFlgs;
            private boolean hasUgcTips;
            private boolean hasWaitingTime;
            private boolean hasWholeCondition;
            private String desc_ = "";
            private String mrsl_ = "";
            private List<Legs> legs_ = Collections.emptyList();
            private int trafficCondition_ = 0;
            private String mainRoads_ = "";
            private int toll_ = 0;
            private int lightNum_ = 0;
            private String waitingTime_ = "";
            private int congestionLength_ = 0;
            private String tab_ = "";
            private WholeCondition wholeCondition_ = null;
            private CarPreferInfoArray carPreferArray_ = null;
            private String routeLabelName_ = "";
            private String routeLabelTips_ = "";
            private String ugcTips_ = "";
            private String routeDesc_ = "";
            private String routeMd5_ = "";
            private List<String> hitCarRules_ = Collections.emptyList();
            private String taxPrice_ = "";
            private int isRpBypart_ = 0;
            private String routeUniqId_ = "";
            private int isCollected_ = 0;
            private DescribeInfo descInfo_ = null;
            private int oilToll_ = 0;
            private List<NEPanelInfo> nePanelInfo_ = Collections.emptyList();
            private RouteLabelInfo routeLabel_ = null;
            private List<RouteEvent> routeEvent_ = Collections.emptyList();
            private List<CameraInfo> cameraInfo_ = Collections.emptyList();
            private DstStreetView streetView_ = null;
            private List<NEPanelInfo> neListPagePanel_ = Collections.emptyList();
            private String routeLabelDesc_ = "";
            private NETransRouteLabel neRouteLabel_ = null;
            private List<RouteLabelUnit> transRouteTagInfo_ = Collections.emptyList();
            private int lightWaitTime_ = 0;
            private int trafficRestrictionFlgs_ = 0;
            private int cachedSize = -1;

            public static final class CameraInfo extends f {
                public static final int DIST_FIELD_NUMBER = 2;
                public static final int ICON_ID_FIELD_NUMBER = 5;
                public static final int POS_FIELD_NUMBER = 3;
                public static final int PRIORITY_FIELD_NUMBER = 4;
                public static final int SPEED_LIMIT_FIELD_NUMBER = 6;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasDist;
                private boolean hasIconId;
                private boolean hasPos;
                private boolean hasPriority;
                private boolean hasSpeedLimit;
                private boolean hasType;
                private int type_ = 0;
                private int dist_ = 0;
                private Point pos_ = null;
                private int priority_ = 0;
                private int iconId_ = 0;
                private int speedLimit_ = 0;
                private int cachedSize = -1;

                public static CameraInfo parseFrom(b bVar) throws IOException {
                    return new CameraInfo().mergeFrom(bVar);
                }

                public final CameraInfo clear() {
                    clearType();
                    clearDist();
                    clearPos();
                    clearPriority();
                    clearIconId();
                    clearSpeedLimit();
                    this.cachedSize = -1;
                    return this;
                }

                public CameraInfo clearDist() {
                    this.hasDist = false;
                    this.dist_ = 0;
                    return this;
                }

                public CameraInfo clearIconId() {
                    this.hasIconId = false;
                    this.iconId_ = 0;
                    return this;
                }

                public CameraInfo clearPos() {
                    this.hasPos = false;
                    this.pos_ = null;
                    return this;
                }

                public CameraInfo clearPriority() {
                    this.hasPriority = false;
                    this.priority_ = 0;
                    return this;
                }

                public CameraInfo clearSpeedLimit() {
                    this.hasSpeedLimit = false;
                    this.speedLimit_ = 0;
                    return this;
                }

                public CameraInfo clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getDist() {
                    return this.dist_;
                }

                public int getIconId() {
                    return this.iconId_;
                }

                public Point getPos() {
                    return this.pos_;
                }

                public int getPriority() {
                    return this.priority_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasType() ? d.e(1, getType()) : 0;
                    if (hasDist()) {
                        iE += d.e(2, getDist());
                    }
                    if (hasPos()) {
                        iE += d.h(3, getPos());
                    }
                    if (hasPriority()) {
                        iE += d.e(4, getPriority());
                    }
                    if (hasIconId()) {
                        iE += d.e(5, getIconId());
                    }
                    if (hasSpeedLimit()) {
                        iE += d.e(6, getSpeedLimit());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public int getSpeedLimit() {
                    return this.speedLimit_;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDist() {
                    return this.hasDist;
                }

                public boolean hasIconId() {
                    return this.hasIconId;
                }

                public boolean hasPos() {
                    return this.hasPos;
                }

                public boolean hasPriority() {
                    return this.hasPriority;
                }

                public boolean hasSpeedLimit() {
                    return this.hasSpeedLimit;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return !hasPos() || getPos().isInitialized();
                }

                public CameraInfo setDist(int i4) {
                    this.hasDist = true;
                    this.dist_ = i4;
                    return this;
                }

                public CameraInfo setIconId(int i4) {
                    this.hasIconId = true;
                    this.iconId_ = i4;
                    return this;
                }

                public CameraInfo setPos(Point point) {
                    if (point == null) {
                        return clearPos();
                    }
                    this.hasPos = true;
                    this.pos_ = point;
                    return this;
                }

                public CameraInfo setPriority(int i4) {
                    this.hasPriority = true;
                    this.priority_ = i4;
                    return this;
                }

                public CameraInfo setSpeedLimit(int i4) {
                    this.hasSpeedLimit = true;
                    this.speedLimit_ = i4;
                    return this;
                }

                public CameraInfo setType(int i4) {
                    this.hasType = true;
                    this.type_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasType()) {
                        dVar.s(1, getType());
                    }
                    if (hasDist()) {
                        dVar.s(2, getDist());
                    }
                    if (hasPos()) {
                        dVar.u(3, getPos());
                    }
                    if (hasPriority()) {
                        dVar.s(4, getPriority());
                    }
                    if (hasIconId()) {
                        dVar.s(5, getIconId());
                    }
                    if (hasSpeedLimit()) {
                        dVar.s(6, getSpeedLimit());
                    }
                }

                public static CameraInfo parseFrom(byte[] bArr) throws e {
                    return (CameraInfo) new CameraInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public CameraInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setType(bVar.k());
                        } else if (iO == 16) {
                            setDist(bVar.k());
                        } else if (iO == 26) {
                            Point point = new Point();
                            bVar.f(point);
                            setPos(point);
                        } else if (iO == 32) {
                            setPriority(bVar.k());
                        } else if (iO == 40) {
                            setIconId(bVar.k());
                        } else if (iO == 48) {
                            setSpeedLimit(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class CarPreferInfo extends f {
                public static final int CAR_PREFER_TAB_FIELD_NUMBER = 2;
                public static final int CAR_PREFER_VAL_FIELD_NUMBER = 1;
                private boolean hasCarPreferTab;
                private boolean hasCarPreferVal;
                private int carPreferVal_ = 0;
                private a carPreferTab_ = a.f1216c;
                private int cachedSize = -1;

                public static CarPreferInfo parseFrom(b bVar) throws IOException {
                    return new CarPreferInfo().mergeFrom(bVar);
                }

                public final CarPreferInfo clear() {
                    clearCarPreferVal();
                    clearCarPreferTab();
                    this.cachedSize = -1;
                    return this;
                }

                public CarPreferInfo clearCarPreferTab() {
                    this.hasCarPreferTab = false;
                    this.carPreferTab_ = a.f1216c;
                    return this;
                }

                public CarPreferInfo clearCarPreferVal() {
                    this.hasCarPreferVal = false;
                    this.carPreferVal_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public a getCarPreferTab() {
                    return this.carPreferTab_;
                }

                public int getCarPreferVal() {
                    return this.carPreferVal_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasCarPreferVal() ? d.e(1, getCarPreferVal()) : 0;
                    if (hasCarPreferTab()) {
                        iE += d.b(2, getCarPreferTab());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public boolean hasCarPreferTab() {
                    return this.hasCarPreferTab;
                }

                public boolean hasCarPreferVal() {
                    return this.hasCarPreferVal;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public CarPreferInfo setCarPreferTab(a aVar) {
                    this.hasCarPreferTab = true;
                    this.carPreferTab_ = aVar;
                    return this;
                }

                public CarPreferInfo setCarPreferVal(int i4) {
                    this.hasCarPreferVal = true;
                    this.carPreferVal_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasCarPreferVal()) {
                        dVar.s(1, getCarPreferVal());
                    }
                    if (hasCarPreferTab()) {
                        dVar.q(2, getCarPreferTab());
                    }
                }

                public static CarPreferInfo parseFrom(byte[] bArr) throws e {
                    return (CarPreferInfo) new CarPreferInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public CarPreferInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setCarPreferVal(bVar.k());
                        } else if (iO == 18) {
                            setCarPreferTab(bVar.b());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class CarPreferInfoArray extends f {
                public static final int CAR_CITY_CODE_FIELD_NUMBER = 2;
                public static final int CAR_INFO_ARRAY_FIELD_NUMBER = 1;
                public static final int LOCAL_ENABLE_TIPS_FIELD_NUMBER = 3;
                private boolean hasCarCityCode;
                private boolean hasLocalEnableTips;
                private List<CarPreferInfo> carInfoArray_ = Collections.emptyList();
                private int carCityCode_ = -1;
                private a localEnableTips_ = a.f1216c;
                private int cachedSize = -1;

                public static CarPreferInfoArray parseFrom(b bVar) throws IOException {
                    return new CarPreferInfoArray().mergeFrom(bVar);
                }

                public CarPreferInfoArray addCarInfoArray(CarPreferInfo carPreferInfo) {
                    if (carPreferInfo == null) {
                        return this;
                    }
                    if (this.carInfoArray_.isEmpty()) {
                        this.carInfoArray_ = new ArrayList();
                    }
                    this.carInfoArray_.add(carPreferInfo);
                    return this;
                }

                public final CarPreferInfoArray clear() {
                    clearCarInfoArray();
                    clearCarCityCode();
                    clearLocalEnableTips();
                    this.cachedSize = -1;
                    return this;
                }

                public CarPreferInfoArray clearCarCityCode() {
                    this.hasCarCityCode = false;
                    this.carCityCode_ = -1;
                    return this;
                }

                public CarPreferInfoArray clearCarInfoArray() {
                    this.carInfoArray_ = Collections.emptyList();
                    return this;
                }

                public CarPreferInfoArray clearLocalEnableTips() {
                    this.hasLocalEnableTips = false;
                    this.localEnableTips_ = a.f1216c;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCarCityCode() {
                    return this.carCityCode_;
                }

                public CarPreferInfo getCarInfoArray(int i4) {
                    return this.carInfoArray_.get(i4);
                }

                public int getCarInfoArrayCount() {
                    return this.carInfoArray_.size();
                }

                public List<CarPreferInfo> getCarInfoArrayList() {
                    return this.carInfoArray_;
                }

                public a getLocalEnableTips() {
                    return this.localEnableTips_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    Iterator<CarPreferInfo> it = getCarInfoArrayList().iterator();
                    int iB = 0;
                    while (it.hasNext()) {
                        iB += d.h(1, it.next());
                    }
                    if (hasCarCityCode()) {
                        iB += d.e(2, getCarCityCode());
                    }
                    if (hasLocalEnableTips()) {
                        iB += d.b(3, getLocalEnableTips());
                    }
                    this.cachedSize = iB;
                    return iB;
                }

                public boolean hasCarCityCode() {
                    return this.hasCarCityCode;
                }

                public boolean hasLocalEnableTips() {
                    return this.hasLocalEnableTips;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public CarPreferInfoArray setCarCityCode(int i4) {
                    this.hasCarCityCode = true;
                    this.carCityCode_ = i4;
                    return this;
                }

                public CarPreferInfoArray setCarInfoArray(int i4, CarPreferInfo carPreferInfo) {
                    if (carPreferInfo == null) {
                        return this;
                    }
                    this.carInfoArray_.set(i4, carPreferInfo);
                    return this;
                }

                public CarPreferInfoArray setLocalEnableTips(a aVar) {
                    this.hasLocalEnableTips = true;
                    this.localEnableTips_ = aVar;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    Iterator<CarPreferInfo> it = getCarInfoArrayList().iterator();
                    while (it.hasNext()) {
                        dVar.u(1, it.next());
                    }
                    if (hasCarCityCode()) {
                        dVar.s(2, getCarCityCode());
                    }
                    if (hasLocalEnableTips()) {
                        dVar.q(3, getLocalEnableTips());
                    }
                }

                public static CarPreferInfoArray parseFrom(byte[] bArr) throws e {
                    return (CarPreferInfoArray) new CarPreferInfoArray().mergeFrom(bArr);
                }

                @Override // L1.f
                public CarPreferInfoArray mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            CarPreferInfo carPreferInfo = new CarPreferInfo();
                            bVar.f(carPreferInfo);
                            addCarInfoArray(carPreferInfo);
                        } else if (iO == 16) {
                            setCarCityCode(bVar.k());
                        } else if (iO == 26) {
                            setLocalEnableTips(bVar.b());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class DescribeInfo extends f {
                public static final int ATTR_STR_FIELD_NUMBER = 2;
                public static final int LABEL_TYPE_FIELD_NUMBER = 1;
                public static final int POS_FIELD_NUMBER = 5;
                public static final int RC_STR_FIELD_NUMBER = 4;
                public static final int ROAD_STR_FIELD_NUMBER = 3;
                private boolean hasAttrStr;
                private boolean hasLabelType;
                private boolean hasPos;
                private boolean hasRcStr;
                private boolean hasRoadStr;
                private int labelType_ = 0;
                private String attrStr_ = "";
                private String roadStr_ = "";
                private String rcStr_ = "";
                private Point pos_ = null;
                private int cachedSize = -1;

                public static DescribeInfo parseFrom(b bVar) throws IOException {
                    return new DescribeInfo().mergeFrom(bVar);
                }

                public final DescribeInfo clear() {
                    clearLabelType();
                    clearAttrStr();
                    clearRoadStr();
                    clearRcStr();
                    clearPos();
                    this.cachedSize = -1;
                    return this;
                }

                public DescribeInfo clearAttrStr() {
                    this.hasAttrStr = false;
                    this.attrStr_ = "";
                    return this;
                }

                public DescribeInfo clearLabelType() {
                    this.hasLabelType = false;
                    this.labelType_ = 0;
                    return this;
                }

                public DescribeInfo clearPos() {
                    this.hasPos = false;
                    this.pos_ = null;
                    return this;
                }

                public DescribeInfo clearRcStr() {
                    this.hasRcStr = false;
                    this.rcStr_ = "";
                    return this;
                }

                public DescribeInfo clearRoadStr() {
                    this.hasRoadStr = false;
                    this.roadStr_ = "";
                    return this;
                }

                public String getAttrStr() {
                    return this.attrStr_;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getLabelType() {
                    return this.labelType_;
                }

                public Point getPos() {
                    return this.pos_;
                }

                public String getRcStr() {
                    return this.rcStr_;
                }

                public String getRoadStr() {
                    return this.roadStr_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasLabelType() ? d.e(1, getLabelType()) : 0;
                    if (hasAttrStr()) {
                        iE += d.l(2, getAttrStr());
                    }
                    if (hasRoadStr()) {
                        iE += d.l(3, getRoadStr());
                    }
                    if (hasRcStr()) {
                        iE += d.l(4, getRcStr());
                    }
                    if (hasPos()) {
                        iE += d.h(5, getPos());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public boolean hasAttrStr() {
                    return this.hasAttrStr;
                }

                public boolean hasLabelType() {
                    return this.hasLabelType;
                }

                public boolean hasPos() {
                    return this.hasPos;
                }

                public boolean hasRcStr() {
                    return this.hasRcStr;
                }

                public boolean hasRoadStr() {
                    return this.hasRoadStr;
                }

                public final boolean isInitialized() {
                    return !hasPos() || getPos().isInitialized();
                }

                public DescribeInfo setAttrStr(String str) {
                    this.hasAttrStr = true;
                    this.attrStr_ = str;
                    return this;
                }

                public DescribeInfo setLabelType(int i4) {
                    this.hasLabelType = true;
                    this.labelType_ = i4;
                    return this;
                }

                public DescribeInfo setPos(Point point) {
                    if (point == null) {
                        return clearPos();
                    }
                    this.hasPos = true;
                    this.pos_ = point;
                    return this;
                }

                public DescribeInfo setRcStr(String str) {
                    this.hasRcStr = true;
                    this.rcStr_ = str;
                    return this;
                }

                public DescribeInfo setRoadStr(String str) {
                    this.hasRoadStr = true;
                    this.roadStr_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasLabelType()) {
                        dVar.s(1, getLabelType());
                    }
                    if (hasAttrStr()) {
                        dVar.A(2, getAttrStr());
                    }
                    if (hasRoadStr()) {
                        dVar.A(3, getRoadStr());
                    }
                    if (hasRcStr()) {
                        dVar.A(4, getRcStr());
                    }
                    if (hasPos()) {
                        dVar.u(5, getPos());
                    }
                }

                public static DescribeInfo parseFrom(byte[] bArr) throws e {
                    return (DescribeInfo) new DescribeInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public DescribeInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setLabelType(bVar.k());
                        } else if (iO == 18) {
                            setAttrStr(bVar.n());
                        } else if (iO == 26) {
                            setRoadStr(bVar.n());
                        } else if (iO == 34) {
                            setRcStr(bVar.n());
                        } else if (iO == 42) {
                            Point point = new Point();
                            bVar.f(point);
                            setPos(point);
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class DstStreetView extends f {
                public static final int IMAGE_TYPE_FIELD_NUMBER = 4;
                public static final int IMAGE_URL_FIELD_NUMBER = 3;
                public static final int POINT_FIELD_NUMBER = 2;
                public static final int STREET_VIEW_URL_FIELD_NUMBER = 1;
                private boolean hasImageType;
                private boolean hasImageUrl;
                private boolean hasPoint;
                private boolean hasStreetViewUrl;
                private String streetViewUrl_ = "";
                private Point point_ = null;
                private String imageUrl_ = "";
                private int imageType_ = 0;
                private int cachedSize = -1;

                public static DstStreetView parseFrom(b bVar) throws IOException {
                    return new DstStreetView().mergeFrom(bVar);
                }

                public final DstStreetView clear() {
                    clearStreetViewUrl();
                    clearPoint();
                    clearImageUrl();
                    clearImageType();
                    this.cachedSize = -1;
                    return this;
                }

                public DstStreetView clearImageType() {
                    this.hasImageType = false;
                    this.imageType_ = 0;
                    return this;
                }

                public DstStreetView clearImageUrl() {
                    this.hasImageUrl = false;
                    this.imageUrl_ = "";
                    return this;
                }

                public DstStreetView clearPoint() {
                    this.hasPoint = false;
                    this.point_ = null;
                    return this;
                }

                public DstStreetView clearStreetViewUrl() {
                    this.hasStreetViewUrl = false;
                    this.streetViewUrl_ = "";
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getImageType() {
                    return this.imageType_;
                }

                public String getImageUrl() {
                    return this.imageUrl_;
                }

                public Point getPoint() {
                    return this.point_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasStreetViewUrl() ? d.l(1, getStreetViewUrl()) : 0;
                    if (hasPoint()) {
                        iL += d.h(2, getPoint());
                    }
                    if (hasImageUrl()) {
                        iL += d.l(3, getImageUrl());
                    }
                    if (hasImageType()) {
                        iL += d.e(4, getImageType());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public String getStreetViewUrl() {
                    return this.streetViewUrl_;
                }

                public boolean hasImageType() {
                    return this.hasImageType;
                }

                public boolean hasImageUrl() {
                    return this.hasImageUrl;
                }

                public boolean hasPoint() {
                    return this.hasPoint;
                }

                public boolean hasStreetViewUrl() {
                    return this.hasStreetViewUrl;
                }

                public final boolean isInitialized() {
                    return !hasPoint() || getPoint().isInitialized();
                }

                public DstStreetView setImageType(int i4) {
                    this.hasImageType = true;
                    this.imageType_ = i4;
                    return this;
                }

                public DstStreetView setImageUrl(String str) {
                    this.hasImageUrl = true;
                    this.imageUrl_ = str;
                    return this;
                }

                public DstStreetView setPoint(Point point) {
                    if (point == null) {
                        return clearPoint();
                    }
                    this.hasPoint = true;
                    this.point_ = point;
                    return this;
                }

                public DstStreetView setStreetViewUrl(String str) {
                    this.hasStreetViewUrl = true;
                    this.streetViewUrl_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasStreetViewUrl()) {
                        dVar.A(1, getStreetViewUrl());
                    }
                    if (hasPoint()) {
                        dVar.u(2, getPoint());
                    }
                    if (hasImageUrl()) {
                        dVar.A(3, getImageUrl());
                    }
                    if (hasImageType()) {
                        dVar.s(4, getImageType());
                    }
                }

                public static DstStreetView parseFrom(byte[] bArr) throws e {
                    return (DstStreetView) new DstStreetView().mergeFrom(bArr);
                }

                @Override // L1.f
                public DstStreetView mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setStreetViewUrl(bVar.n());
                        } else if (iO == 18) {
                            Point point = new Point();
                            bVar.f(point);
                            setPoint(point);
                        } else if (iO == 26) {
                            setImageUrl(bVar.n());
                        } else if (iO == 32) {
                            setImageType(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class Legs extends f {
                public static final int DISTANCE_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 2;
                public static final int DURATION_INFO_FIELD_NUMBER = 5;
                public static final int DURATION_WHOLEDAY_FIELD_NUMBER = 6;
                public static final int MRSL_FIELD_NUMBER = 4;
                public static final int STEPIS_FIELD_NUMBER = 3;
                private boolean hasDistance;
                private boolean hasDuration;
                private boolean hasDurationInfo;
                private boolean hasDurationWholeday;
                private boolean hasMrsl;
                private int distance_ = 0;
                private int duration_ = 0;
                private List<Stepis> stepis_ = Collections.emptyList();
                private String mrsl_ = "";
                private DurationInfo durationInfo_ = null;
                private DurationWholeday durationWholeday_ = null;
                private int cachedSize = -1;

                public static final class DurationInfo extends f {
                    public static final int INFOS_FIELD_NUMBER = 3;
                    public static final int INTERVAL_FIELD_NUMBER = 1;
                    public static final int TIMESTAMP_FIELD_NUMBER = 2;
                    private boolean hasInterval;
                    private boolean hasTimestamp;
                    private List<Infos> infos_ = Collections.emptyList();
                    private int interval_ = 0;
                    private String timestamp_ = "";
                    private int cachedSize = -1;

                    public static final class Infos extends f {
                        public static final int DURATION_FIELD_NUMBER = 2;
                        public static final int INDEX_FIELD_NUMBER = 1;
                        private boolean hasDuration;
                        private boolean hasIndex;
                        private int index_ = 0;
                        private int duration_ = 0;
                        private int cachedSize = -1;

                        public static Infos parseFrom(b bVar) throws IOException {
                            return new Infos().mergeFrom(bVar);
                        }

                        public final Infos clear() {
                            clearIndex();
                            clearDuration();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Infos clearDuration() {
                            this.hasDuration = false;
                            this.duration_ = 0;
                            return this;
                        }

                        public Infos clearIndex() {
                            this.hasIndex = false;
                            this.index_ = 0;
                            return this;
                        }

                        @Override // L1.f
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public int getDuration() {
                            return this.duration_;
                        }

                        public int getIndex() {
                            return this.index_;
                        }

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iE = hasIndex() ? d.e(1, getIndex()) : 0;
                            if (hasDuration()) {
                                iE += d.e(2, getDuration());
                            }
                            this.cachedSize = iE;
                            return iE;
                        }

                        public boolean hasDuration() {
                            return this.hasDuration;
                        }

                        public boolean hasIndex() {
                            return this.hasIndex;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Infos setDuration(int i4) {
                            this.hasDuration = true;
                            this.duration_ = i4;
                            return this;
                        }

                        public Infos setIndex(int i4) {
                            this.hasIndex = true;
                            this.index_ = i4;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasIndex()) {
                                dVar.s(1, getIndex());
                            }
                            if (hasDuration()) {
                                dVar.s(2, getDuration());
                            }
                        }

                        public static Infos parseFrom(byte[] bArr) throws e {
                            return (Infos) new Infos().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public Infos mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 8) {
                                    setIndex(bVar.k());
                                } else if (iO == 16) {
                                    setDuration(bVar.k());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static DurationInfo parseFrom(b bVar) throws IOException {
                        return new DurationInfo().mergeFrom(bVar);
                    }

                    public DurationInfo addInfos(Infos infos) {
                        if (infos == null) {
                            return this;
                        }
                        if (this.infos_.isEmpty()) {
                            this.infos_ = new ArrayList();
                        }
                        this.infos_.add(infos);
                        return this;
                    }

                    public final DurationInfo clear() {
                        clearInfos();
                        clearInterval();
                        clearTimestamp();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DurationInfo clearInfos() {
                        this.infos_ = Collections.emptyList();
                        return this;
                    }

                    public DurationInfo clearInterval() {
                        this.hasInterval = false;
                        this.interval_ = 0;
                        return this;
                    }

                    public DurationInfo clearTimestamp() {
                        this.hasTimestamp = false;
                        this.timestamp_ = "";
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public Infos getInfos(int i4) {
                        return this.infos_.get(i4);
                    }

                    public int getInfosCount() {
                        return this.infos_.size();
                    }

                    public List<Infos> getInfosList() {
                        return this.infos_;
                    }

                    public int getInterval() {
                        return this.interval_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasInterval() ? d.e(1, getInterval()) : 0;
                        if (hasTimestamp()) {
                            iE += d.l(2, getTimestamp());
                        }
                        Iterator<Infos> it = getInfosList().iterator();
                        while (it.hasNext()) {
                            iE += d.h(3, it.next());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public String getTimestamp() {
                        return this.timestamp_;
                    }

                    public boolean hasInterval() {
                        return this.hasInterval;
                    }

                    public boolean hasTimestamp() {
                        return this.hasTimestamp;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public DurationInfo setInfos(int i4, Infos infos) {
                        if (infos == null) {
                            return this;
                        }
                        this.infos_.set(i4, infos);
                        return this;
                    }

                    public DurationInfo setInterval(int i4) {
                        this.hasInterval = true;
                        this.interval_ = i4;
                        return this;
                    }

                    public DurationInfo setTimestamp(String str) {
                        this.hasTimestamp = true;
                        this.timestamp_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasInterval()) {
                            dVar.s(1, getInterval());
                        }
                        if (hasTimestamp()) {
                            dVar.A(2, getTimestamp());
                        }
                        Iterator<Infos> it = getInfosList().iterator();
                        while (it.hasNext()) {
                            dVar.u(3, it.next());
                        }
                    }

                    public static DurationInfo parseFrom(byte[] bArr) throws e {
                        return (DurationInfo) new DurationInfo().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public DurationInfo mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setInterval(bVar.k());
                            } else if (iO == 18) {
                                setTimestamp(bVar.n());
                            } else if (iO == 26) {
                                Infos infos = new Infos();
                                bVar.f(infos);
                                addInfos(infos);
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class DurationWholeday extends f {
                    public static final int INFOS_FIELD_NUMBER = 3;
                    public static final int INTERVAL_FIELD_NUMBER = 1;
                    public static final int TIMESTAMP_FIELD_NUMBER = 2;
                    private boolean hasInterval;
                    private boolean hasTimestamp;
                    private List<Infos> infos_ = Collections.emptyList();
                    private int interval_ = 0;
                    private String timestamp_ = "";
                    private int cachedSize = -1;

                    public static final class Infos extends f {
                        public static final int DURATION_FIELD_NUMBER = 2;
                        public static final int INDEX_FIELD_NUMBER = 1;
                        private boolean hasDuration;
                        private boolean hasIndex;
                        private int index_ = 0;
                        private int duration_ = 0;
                        private int cachedSize = -1;

                        public static Infos parseFrom(b bVar) throws IOException {
                            return new Infos().mergeFrom(bVar);
                        }

                        public final Infos clear() {
                            clearIndex();
                            clearDuration();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Infos clearDuration() {
                            this.hasDuration = false;
                            this.duration_ = 0;
                            return this;
                        }

                        public Infos clearIndex() {
                            this.hasIndex = false;
                            this.index_ = 0;
                            return this;
                        }

                        @Override // L1.f
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public int getDuration() {
                            return this.duration_;
                        }

                        public int getIndex() {
                            return this.index_;
                        }

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iE = hasIndex() ? d.e(1, getIndex()) : 0;
                            if (hasDuration()) {
                                iE += d.e(2, getDuration());
                            }
                            this.cachedSize = iE;
                            return iE;
                        }

                        public boolean hasDuration() {
                            return this.hasDuration;
                        }

                        public boolean hasIndex() {
                            return this.hasIndex;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Infos setDuration(int i4) {
                            this.hasDuration = true;
                            this.duration_ = i4;
                            return this;
                        }

                        public Infos setIndex(int i4) {
                            this.hasIndex = true;
                            this.index_ = i4;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasIndex()) {
                                dVar.s(1, getIndex());
                            }
                            if (hasDuration()) {
                                dVar.s(2, getDuration());
                            }
                        }

                        public static Infos parseFrom(byte[] bArr) throws e {
                            return (Infos) new Infos().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public Infos mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 8) {
                                    setIndex(bVar.k());
                                } else if (iO == 16) {
                                    setDuration(bVar.k());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static DurationWholeday parseFrom(b bVar) throws IOException {
                        return new DurationWholeday().mergeFrom(bVar);
                    }

                    public DurationWholeday addInfos(Infos infos) {
                        if (infos == null) {
                            return this;
                        }
                        if (this.infos_.isEmpty()) {
                            this.infos_ = new ArrayList();
                        }
                        this.infos_.add(infos);
                        return this;
                    }

                    public final DurationWholeday clear() {
                        clearInfos();
                        clearInterval();
                        clearTimestamp();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DurationWholeday clearInfos() {
                        this.infos_ = Collections.emptyList();
                        return this;
                    }

                    public DurationWholeday clearInterval() {
                        this.hasInterval = false;
                        this.interval_ = 0;
                        return this;
                    }

                    public DurationWholeday clearTimestamp() {
                        this.hasTimestamp = false;
                        this.timestamp_ = "";
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public Infos getInfos(int i4) {
                        return this.infos_.get(i4);
                    }

                    public int getInfosCount() {
                        return this.infos_.size();
                    }

                    public List<Infos> getInfosList() {
                        return this.infos_;
                    }

                    public int getInterval() {
                        return this.interval_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasInterval() ? d.e(1, getInterval()) : 0;
                        if (hasTimestamp()) {
                            iE += d.l(2, getTimestamp());
                        }
                        Iterator<Infos> it = getInfosList().iterator();
                        while (it.hasNext()) {
                            iE += d.h(3, it.next());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public String getTimestamp() {
                        return this.timestamp_;
                    }

                    public boolean hasInterval() {
                        return this.hasInterval;
                    }

                    public boolean hasTimestamp() {
                        return this.hasTimestamp;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public DurationWholeday setInfos(int i4, Infos infos) {
                        if (infos == null) {
                            return this;
                        }
                        this.infos_.set(i4, infos);
                        return this;
                    }

                    public DurationWholeday setInterval(int i4) {
                        this.hasInterval = true;
                        this.interval_ = i4;
                        return this;
                    }

                    public DurationWholeday setTimestamp(String str) {
                        this.hasTimestamp = true;
                        this.timestamp_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasInterval()) {
                            dVar.s(1, getInterval());
                        }
                        if (hasTimestamp()) {
                            dVar.A(2, getTimestamp());
                        }
                        Iterator<Infos> it = getInfosList().iterator();
                        while (it.hasNext()) {
                            dVar.u(3, it.next());
                        }
                    }

                    public static DurationWholeday parseFrom(byte[] bArr) throws e {
                        return (DurationWholeday) new DurationWholeday().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public DurationWholeday mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setInterval(bVar.k());
                            } else if (iO == 18) {
                                setTimestamp(bVar.n());
                            } else if (iO == 26) {
                                Infos infos = new Infos();
                                bVar.f(infos);
                                addInfos(infos);
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class Stepis extends f {
                    public static final int N_FIELD_NUMBER = 1;
                    public static final int S_FIELD_NUMBER = 2;
                    private boolean hasN;
                    private boolean hasS;
                    private int n_ = 0;
                    private int s_ = 0;
                    private int cachedSize = -1;

                    public static Stepis parseFrom(b bVar) throws IOException {
                        return new Stepis().mergeFrom(bVar);
                    }

                    public final Stepis clear() {
                        clearN();
                        clearS();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Stepis clearN() {
                        this.hasN = false;
                        this.n_ = 0;
                        return this;
                    }

                    public Stepis clearS() {
                        this.hasS = false;
                        this.s_ = 0;
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getN() {
                        return this.n_;
                    }

                    public int getS() {
                        return this.s_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasN() ? d.e(1, getN()) : 0;
                        if (hasS()) {
                            iE += d.e(2, getS());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public boolean hasN() {
                        return this.hasN;
                    }

                    public boolean hasS() {
                        return this.hasS;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Stepis setN(int i4) {
                        this.hasN = true;
                        this.n_ = i4;
                        return this;
                    }

                    public Stepis setS(int i4) {
                        this.hasS = true;
                        this.s_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasN()) {
                            dVar.s(1, getN());
                        }
                        if (hasS()) {
                            dVar.s(2, getS());
                        }
                    }

                    public static Stepis parseFrom(byte[] bArr) throws e {
                        return (Stepis) new Stepis().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Stepis mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setN(bVar.k());
                            } else if (iO == 16) {
                                setS(bVar.k());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static Legs parseFrom(b bVar) throws IOException {
                    return new Legs().mergeFrom(bVar);
                }

                public Legs addStepis(Stepis stepis) {
                    if (stepis == null) {
                        return this;
                    }
                    if (this.stepis_.isEmpty()) {
                        this.stepis_ = new ArrayList();
                    }
                    this.stepis_.add(stepis);
                    return this;
                }

                public final Legs clear() {
                    clearDistance();
                    clearDuration();
                    clearStepis();
                    clearMrsl();
                    clearDurationInfo();
                    clearDurationWholeday();
                    this.cachedSize = -1;
                    return this;
                }

                public Legs clearDistance() {
                    this.hasDistance = false;
                    this.distance_ = 0;
                    return this;
                }

                public Legs clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public Legs clearDurationInfo() {
                    this.hasDurationInfo = false;
                    this.durationInfo_ = null;
                    return this;
                }

                public Legs clearDurationWholeday() {
                    this.hasDurationWholeday = false;
                    this.durationWholeday_ = null;
                    return this;
                }

                public Legs clearMrsl() {
                    this.hasMrsl = false;
                    this.mrsl_ = "";
                    return this;
                }

                public Legs clearStepis() {
                    this.stepis_ = Collections.emptyList();
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getDistance() {
                    return this.distance_;
                }

                public int getDuration() {
                    return this.duration_;
                }

                public DurationInfo getDurationInfo() {
                    return this.durationInfo_;
                }

                public DurationWholeday getDurationWholeday() {
                    return this.durationWholeday_;
                }

                public String getMrsl() {
                    return this.mrsl_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasDistance() ? d.e(1, getDistance()) : 0;
                    if (hasDuration()) {
                        iE += d.e(2, getDuration());
                    }
                    Iterator<Stepis> it = getStepisList().iterator();
                    while (it.hasNext()) {
                        iE += d.h(3, it.next());
                    }
                    if (hasMrsl()) {
                        iE += d.l(4, getMrsl());
                    }
                    if (hasDurationInfo()) {
                        iE += d.h(5, getDurationInfo());
                    }
                    if (hasDurationWholeday()) {
                        iE += d.h(6, getDurationWholeday());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public Stepis getStepis(int i4) {
                    return this.stepis_.get(i4);
                }

                public int getStepisCount() {
                    return this.stepis_.size();
                }

                public List<Stepis> getStepisList() {
                    return this.stepis_;
                }

                public boolean hasDistance() {
                    return this.hasDistance;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasDurationInfo() {
                    return this.hasDurationInfo;
                }

                public boolean hasDurationWholeday() {
                    return this.hasDurationWholeday;
                }

                public boolean hasMrsl() {
                    return this.hasMrsl;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Legs setDistance(int i4) {
                    this.hasDistance = true;
                    this.distance_ = i4;
                    return this;
                }

                public Legs setDuration(int i4) {
                    this.hasDuration = true;
                    this.duration_ = i4;
                    return this;
                }

                public Legs setDurationInfo(DurationInfo durationInfo) {
                    if (durationInfo == null) {
                        return clearDurationInfo();
                    }
                    this.hasDurationInfo = true;
                    this.durationInfo_ = durationInfo;
                    return this;
                }

                public Legs setDurationWholeday(DurationWholeday durationWholeday) {
                    if (durationWholeday == null) {
                        return clearDurationWholeday();
                    }
                    this.hasDurationWholeday = true;
                    this.durationWholeday_ = durationWholeday;
                    return this;
                }

                public Legs setMrsl(String str) {
                    this.hasMrsl = true;
                    this.mrsl_ = str;
                    return this;
                }

                public Legs setStepis(int i4, Stepis stepis) {
                    if (stepis == null) {
                        return this;
                    }
                    this.stepis_.set(i4, stepis);
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasDistance()) {
                        dVar.s(1, getDistance());
                    }
                    if (hasDuration()) {
                        dVar.s(2, getDuration());
                    }
                    Iterator<Stepis> it = getStepisList().iterator();
                    while (it.hasNext()) {
                        dVar.u(3, it.next());
                    }
                    if (hasMrsl()) {
                        dVar.A(4, getMrsl());
                    }
                    if (hasDurationInfo()) {
                        dVar.u(5, getDurationInfo());
                    }
                    if (hasDurationWholeday()) {
                        dVar.u(6, getDurationWholeday());
                    }
                }

                public static Legs parseFrom(byte[] bArr) throws e {
                    return (Legs) new Legs().mergeFrom(bArr);
                }

                @Override // L1.f
                public Legs mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setDistance(bVar.k());
                        } else if (iO == 16) {
                            setDuration(bVar.k());
                        } else if (iO == 26) {
                            Stepis stepis = new Stepis();
                            bVar.f(stepis);
                            addStepis(stepis);
                        } else if (iO == 34) {
                            setMrsl(bVar.n());
                        } else if (iO == 42) {
                            DurationInfo durationInfo = new DurationInfo();
                            bVar.f(durationInfo);
                            setDurationInfo(durationInfo);
                        } else if (iO == 50) {
                            DurationWholeday durationWholeday = new DurationWholeday();
                            bVar.f(durationWholeday);
                            setDurationWholeday(durationWholeday);
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class NEPanelInfo extends f {
                public static final int ICON_TYPE_FIELD_NUMBER = 7;
                public static final int NE_COPYWRITING_FIELD_NUMBER = 1;
                public static final int NE_JUMP_PAGE_INDEX_FIELD_NUMBER = 2;
                public static final int NE_JUMP_PAGE_URL_FIELD_NUMBER = 3;
                public static final int PATTERN_ID_FIELD_NUMBER = 5;
                public static final int SUB_CW_FIELD_NUMBER = 4;
                public static final int TAG_FIELD_NUMBER = 6;
                private boolean hasIconType;
                private boolean hasNeCopywriting;
                private boolean hasNeJumpPageIndex;
                private boolean hasNeJumpPageUrl;
                private boolean hasPatternId;
                private boolean hasSubCw;
                private boolean hasTag;
                private String neCopywriting_ = "";
                private int neJumpPageIndex_ = 0;
                private String neJumpPageUrl_ = "";
                private String subCw_ = "";
                private int patternId_ = 0;
                private int tag_ = 0;
                private int iconType_ = 0;
                private int cachedSize = -1;

                public static NEPanelInfo parseFrom(b bVar) throws IOException {
                    return new NEPanelInfo().mergeFrom(bVar);
                }

                public final NEPanelInfo clear() {
                    clearNeCopywriting();
                    clearNeJumpPageIndex();
                    clearNeJumpPageUrl();
                    clearSubCw();
                    clearPatternId();
                    clearTag();
                    clearIconType();
                    this.cachedSize = -1;
                    return this;
                }

                public NEPanelInfo clearIconType() {
                    this.hasIconType = false;
                    this.iconType_ = 0;
                    return this;
                }

                public NEPanelInfo clearNeCopywriting() {
                    this.hasNeCopywriting = false;
                    this.neCopywriting_ = "";
                    return this;
                }

                public NEPanelInfo clearNeJumpPageIndex() {
                    this.hasNeJumpPageIndex = false;
                    this.neJumpPageIndex_ = 0;
                    return this;
                }

                public NEPanelInfo clearNeJumpPageUrl() {
                    this.hasNeJumpPageUrl = false;
                    this.neJumpPageUrl_ = "";
                    return this;
                }

                public NEPanelInfo clearPatternId() {
                    this.hasPatternId = false;
                    this.patternId_ = 0;
                    return this;
                }

                public NEPanelInfo clearSubCw() {
                    this.hasSubCw = false;
                    this.subCw_ = "";
                    return this;
                }

                public NEPanelInfo clearTag() {
                    this.hasTag = false;
                    this.tag_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getIconType() {
                    return this.iconType_;
                }

                public String getNeCopywriting() {
                    return this.neCopywriting_;
                }

                public int getNeJumpPageIndex() {
                    return this.neJumpPageIndex_;
                }

                public String getNeJumpPageUrl() {
                    return this.neJumpPageUrl_;
                }

                public int getPatternId() {
                    return this.patternId_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasNeCopywriting() ? d.l(1, getNeCopywriting()) : 0;
                    if (hasNeJumpPageIndex()) {
                        iL += d.e(2, getNeJumpPageIndex());
                    }
                    if (hasNeJumpPageUrl()) {
                        iL += d.l(3, getNeJumpPageUrl());
                    }
                    if (hasSubCw()) {
                        iL += d.l(4, getSubCw());
                    }
                    if (hasPatternId()) {
                        iL += d.e(5, getPatternId());
                    }
                    if (hasTag()) {
                        iL += d.e(6, getTag());
                    }
                    if (hasIconType()) {
                        iL += d.e(7, getIconType());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public String getSubCw() {
                    return this.subCw_;
                }

                public int getTag() {
                    return this.tag_;
                }

                public boolean hasIconType() {
                    return this.hasIconType;
                }

                public boolean hasNeCopywriting() {
                    return this.hasNeCopywriting;
                }

                public boolean hasNeJumpPageIndex() {
                    return this.hasNeJumpPageIndex;
                }

                public boolean hasNeJumpPageUrl() {
                    return this.hasNeJumpPageUrl;
                }

                public boolean hasPatternId() {
                    return this.hasPatternId;
                }

                public boolean hasSubCw() {
                    return this.hasSubCw;
                }

                public boolean hasTag() {
                    return this.hasTag;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public NEPanelInfo setIconType(int i4) {
                    this.hasIconType = true;
                    this.iconType_ = i4;
                    return this;
                }

                public NEPanelInfo setNeCopywriting(String str) {
                    this.hasNeCopywriting = true;
                    this.neCopywriting_ = str;
                    return this;
                }

                public NEPanelInfo setNeJumpPageIndex(int i4) {
                    this.hasNeJumpPageIndex = true;
                    this.neJumpPageIndex_ = i4;
                    return this;
                }

                public NEPanelInfo setNeJumpPageUrl(String str) {
                    this.hasNeJumpPageUrl = true;
                    this.neJumpPageUrl_ = str;
                    return this;
                }

                public NEPanelInfo setPatternId(int i4) {
                    this.hasPatternId = true;
                    this.patternId_ = i4;
                    return this;
                }

                public NEPanelInfo setSubCw(String str) {
                    this.hasSubCw = true;
                    this.subCw_ = str;
                    return this;
                }

                public NEPanelInfo setTag(int i4) {
                    this.hasTag = true;
                    this.tag_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasNeCopywriting()) {
                        dVar.A(1, getNeCopywriting());
                    }
                    if (hasNeJumpPageIndex()) {
                        dVar.s(2, getNeJumpPageIndex());
                    }
                    if (hasNeJumpPageUrl()) {
                        dVar.A(3, getNeJumpPageUrl());
                    }
                    if (hasSubCw()) {
                        dVar.A(4, getSubCw());
                    }
                    if (hasPatternId()) {
                        dVar.s(5, getPatternId());
                    }
                    if (hasTag()) {
                        dVar.s(6, getTag());
                    }
                    if (hasIconType()) {
                        dVar.s(7, getIconType());
                    }
                }

                public static NEPanelInfo parseFrom(byte[] bArr) throws e {
                    return (NEPanelInfo) new NEPanelInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public NEPanelInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setNeCopywriting(bVar.n());
                        } else if (iO == 16) {
                            setNeJumpPageIndex(bVar.k());
                        } else if (iO == 26) {
                            setNeJumpPageUrl(bVar.n());
                        } else if (iO == 34) {
                            setSubCw(bVar.n());
                        } else if (iO == 40) {
                            setPatternId(bVar.k());
                        } else if (iO == 48) {
                            setTag(bVar.k());
                        } else if (iO == 56) {
                            setIconType(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class NETransRouteLabel extends f {
                public static final int ICON_TYPE_FIELD_NUMBER = 1;
                private boolean hasIconType;
                private int iconType_ = 0;
                private int cachedSize = -1;

                public static NETransRouteLabel parseFrom(b bVar) throws IOException {
                    return new NETransRouteLabel().mergeFrom(bVar);
                }

                public final NETransRouteLabel clear() {
                    clearIconType();
                    this.cachedSize = -1;
                    return this;
                }

                public NETransRouteLabel clearIconType() {
                    this.hasIconType = false;
                    this.iconType_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getIconType() {
                    return this.iconType_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasIconType() ? d.e(1, getIconType()) : 0;
                    this.cachedSize = iE;
                    return iE;
                }

                public boolean hasIconType() {
                    return this.hasIconType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public NETransRouteLabel setIconType(int i4) {
                    this.hasIconType = true;
                    this.iconType_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasIconType()) {
                        dVar.s(1, getIconType());
                    }
                }

                public static NETransRouteLabel parseFrom(byte[] bArr) throws e {
                    return (NETransRouteLabel) new NETransRouteLabel().mergeFrom(bArr);
                }

                @Override // L1.f
                public NETransRouteLabel mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setIconType(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class RouteEvent extends f {
                public static final int CONTENT_FIELD_NUMBER = 6;
                public static final int EVENT_ID_FIELD_NUMBER = 2;
                public static final int EVENT_TYPE_FIELD_NUMBER = 1;
                public static final int PATTERN_ID_FIELD_NUMBER = 5;
                public static final int POS_FIELD_NUMBER = 3;
                public static final int ROOM_ID_FIELD_NUMBER = 7;
                public static final int WEIGHT_FIELD_NUMBER = 4;
                private boolean hasContent;
                private boolean hasEventId;
                private boolean hasEventType;
                private boolean hasPatternId;
                private boolean hasPos;
                private boolean hasRoomId;
                private boolean hasWeight;
                private int eventType_ = 0;
                private long eventId_ = 0;
                private Point pos_ = null;
                private int weight_ = 0;
                private int patternId_ = 0;
                private String content_ = "";
                private long roomId_ = 0;
                private int cachedSize = -1;

                public static RouteEvent parseFrom(b bVar) throws IOException {
                    return new RouteEvent().mergeFrom(bVar);
                }

                public final RouteEvent clear() {
                    clearEventType();
                    clearEventId();
                    clearPos();
                    clearWeight();
                    clearPatternId();
                    clearContent();
                    clearRoomId();
                    this.cachedSize = -1;
                    return this;
                }

                public RouteEvent clearContent() {
                    this.hasContent = false;
                    this.content_ = "";
                    return this;
                }

                public RouteEvent clearEventId() {
                    this.hasEventId = false;
                    this.eventId_ = 0L;
                    return this;
                }

                public RouteEvent clearEventType() {
                    this.hasEventType = false;
                    this.eventType_ = 0;
                    return this;
                }

                public RouteEvent clearPatternId() {
                    this.hasPatternId = false;
                    this.patternId_ = 0;
                    return this;
                }

                public RouteEvent clearPos() {
                    this.hasPos = false;
                    this.pos_ = null;
                    return this;
                }

                public RouteEvent clearRoomId() {
                    this.hasRoomId = false;
                    this.roomId_ = 0L;
                    return this;
                }

                public RouteEvent clearWeight() {
                    this.hasWeight = false;
                    this.weight_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getContent() {
                    return this.content_;
                }

                public long getEventId() {
                    return this.eventId_;
                }

                public int getEventType() {
                    return this.eventType_;
                }

                public int getPatternId() {
                    return this.patternId_;
                }

                public Point getPos() {
                    return this.pos_;
                }

                public long getRoomId() {
                    return this.roomId_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasEventType() ? d.e(1, getEventType()) : 0;
                    if (hasEventId()) {
                        iE += d.g(2, getEventId());
                    }
                    if (hasPos()) {
                        iE += d.h(3, getPos());
                    }
                    if (hasWeight()) {
                        iE += d.e(4, getWeight());
                    }
                    if (hasPatternId()) {
                        iE += d.e(5, getPatternId());
                    }
                    if (hasContent()) {
                        iE += d.l(6, getContent());
                    }
                    if (hasRoomId()) {
                        iE += d.g(7, getRoomId());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public int getWeight() {
                    return this.weight_;
                }

                public boolean hasContent() {
                    return this.hasContent;
                }

                public boolean hasEventId() {
                    return this.hasEventId;
                }

                public boolean hasEventType() {
                    return this.hasEventType;
                }

                public boolean hasPatternId() {
                    return this.hasPatternId;
                }

                public boolean hasPos() {
                    return this.hasPos;
                }

                public boolean hasRoomId() {
                    return this.hasRoomId;
                }

                public boolean hasWeight() {
                    return this.hasWeight;
                }

                public final boolean isInitialized() {
                    return !hasPos() || getPos().isInitialized();
                }

                public RouteEvent setContent(String str) {
                    this.hasContent = true;
                    this.content_ = str;
                    return this;
                }

                public RouteEvent setEventId(long j4) {
                    this.hasEventId = true;
                    this.eventId_ = j4;
                    return this;
                }

                public RouteEvent setEventType(int i4) {
                    this.hasEventType = true;
                    this.eventType_ = i4;
                    return this;
                }

                public RouteEvent setPatternId(int i4) {
                    this.hasPatternId = true;
                    this.patternId_ = i4;
                    return this;
                }

                public RouteEvent setPos(Point point) {
                    if (point == null) {
                        return clearPos();
                    }
                    this.hasPos = true;
                    this.pos_ = point;
                    return this;
                }

                public RouteEvent setRoomId(long j4) {
                    this.hasRoomId = true;
                    this.roomId_ = j4;
                    return this;
                }

                public RouteEvent setWeight(int i4) {
                    this.hasWeight = true;
                    this.weight_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasEventType()) {
                        dVar.s(1, getEventType());
                    }
                    if (hasEventId()) {
                        dVar.t(2, getEventId());
                    }
                    if (hasPos()) {
                        dVar.u(3, getPos());
                    }
                    if (hasWeight()) {
                        dVar.s(4, getWeight());
                    }
                    if (hasPatternId()) {
                        dVar.s(5, getPatternId());
                    }
                    if (hasContent()) {
                        dVar.A(6, getContent());
                    }
                    if (hasRoomId()) {
                        dVar.t(7, getRoomId());
                    }
                }

                public static RouteEvent parseFrom(byte[] bArr) throws e {
                    return (RouteEvent) new RouteEvent().mergeFrom(bArr);
                }

                @Override // L1.f
                public RouteEvent mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setEventType(bVar.k());
                        } else if (iO == 16) {
                            setEventId(bVar.l());
                        } else if (iO == 26) {
                            Point point = new Point();
                            bVar.f(point);
                            setPos(point);
                        } else if (iO == 32) {
                            setWeight(bVar.k());
                        } else if (iO == 40) {
                            setPatternId(bVar.k());
                        } else if (iO == 50) {
                            setContent(bVar.n());
                        } else if (iO == 56) {
                            setRoomId(bVar.l());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class RouteLabelInfo extends f {
                public static final int LABELS_FIELD_NUMBER = 1;
                private List<DynamicLabel> labels_ = Collections.emptyList();
                private int cachedSize = -1;

                public static final class DynamicLabel extends f {
                    public static final int CONTENT_FIELD_NUMBER = 3;
                    public static final int LABEL_TYPE_FIELD_NUMBER = 2;
                    public static final int POS_FIELD_NUMBER = 4;
                    public static final int ROUTE_NO_FIELD_NUMBER = 1;
                    private boolean hasContent;
                    private boolean hasLabelType;
                    private boolean hasPos;
                    private boolean hasRouteNo;
                    private int routeNo_ = 0;
                    private int labelType_ = 0;
                    private String content_ = "";
                    private Point pos_ = null;
                    private int cachedSize = -1;

                    public static DynamicLabel parseFrom(b bVar) throws IOException {
                        return new DynamicLabel().mergeFrom(bVar);
                    }

                    public final DynamicLabel clear() {
                        clearRouteNo();
                        clearLabelType();
                        clearContent();
                        clearPos();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DynamicLabel clearContent() {
                        this.hasContent = false;
                        this.content_ = "";
                        return this;
                    }

                    public DynamicLabel clearLabelType() {
                        this.hasLabelType = false;
                        this.labelType_ = 0;
                        return this;
                    }

                    public DynamicLabel clearPos() {
                        this.hasPos = false;
                        this.pos_ = null;
                        return this;
                    }

                    public DynamicLabel clearRouteNo() {
                        this.hasRouteNo = false;
                        this.routeNo_ = 0;
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getContent() {
                        return this.content_;
                    }

                    public int getLabelType() {
                        return this.labelType_;
                    }

                    public Point getPos() {
                        return this.pos_;
                    }

                    public int getRouteNo() {
                        return this.routeNo_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasRouteNo() ? d.e(1, getRouteNo()) : 0;
                        if (hasLabelType()) {
                            iE += d.e(2, getLabelType());
                        }
                        if (hasContent()) {
                            iE += d.l(3, getContent());
                        }
                        if (hasPos()) {
                            iE += d.h(4, getPos());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public boolean hasContent() {
                        return this.hasContent;
                    }

                    public boolean hasLabelType() {
                        return this.hasLabelType;
                    }

                    public boolean hasPos() {
                        return this.hasPos;
                    }

                    public boolean hasRouteNo() {
                        return this.hasRouteNo;
                    }

                    public final boolean isInitialized() {
                        return !hasPos() || getPos().isInitialized();
                    }

                    public DynamicLabel setContent(String str) {
                        this.hasContent = true;
                        this.content_ = str;
                        return this;
                    }

                    public DynamicLabel setLabelType(int i4) {
                        this.hasLabelType = true;
                        this.labelType_ = i4;
                        return this;
                    }

                    public DynamicLabel setPos(Point point) {
                        if (point == null) {
                            return clearPos();
                        }
                        this.hasPos = true;
                        this.pos_ = point;
                        return this;
                    }

                    public DynamicLabel setRouteNo(int i4) {
                        this.hasRouteNo = true;
                        this.routeNo_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasRouteNo()) {
                            dVar.s(1, getRouteNo());
                        }
                        if (hasLabelType()) {
                            dVar.s(2, getLabelType());
                        }
                        if (hasContent()) {
                            dVar.A(3, getContent());
                        }
                        if (hasPos()) {
                            dVar.u(4, getPos());
                        }
                    }

                    public static DynamicLabel parseFrom(byte[] bArr) throws e {
                        return (DynamicLabel) new DynamicLabel().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public DynamicLabel mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setRouteNo(bVar.k());
                            } else if (iO == 16) {
                                setLabelType(bVar.k());
                            } else if (iO == 26) {
                                setContent(bVar.n());
                            } else if (iO == 34) {
                                Point point = new Point();
                                bVar.f(point);
                                setPos(point);
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static RouteLabelInfo parseFrom(b bVar) throws IOException {
                    return new RouteLabelInfo().mergeFrom(bVar);
                }

                public RouteLabelInfo addLabels(DynamicLabel dynamicLabel) {
                    if (dynamicLabel == null) {
                        return this;
                    }
                    if (this.labels_.isEmpty()) {
                        this.labels_ = new ArrayList();
                    }
                    this.labels_.add(dynamicLabel);
                    return this;
                }

                public final RouteLabelInfo clear() {
                    clearLabels();
                    this.cachedSize = -1;
                    return this;
                }

                public RouteLabelInfo clearLabels() {
                    this.labels_ = Collections.emptyList();
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public DynamicLabel getLabels(int i4) {
                    return this.labels_.get(i4);
                }

                public int getLabelsCount() {
                    return this.labels_.size();
                }

                public List<DynamicLabel> getLabelsList() {
                    return this.labels_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    Iterator<DynamicLabel> it = getLabelsList().iterator();
                    int iH = 0;
                    while (it.hasNext()) {
                        iH += d.h(1, it.next());
                    }
                    this.cachedSize = iH;
                    return iH;
                }

                public final boolean isInitialized() {
                    Iterator<DynamicLabel> it = getLabelsList().iterator();
                    while (it.hasNext()) {
                        if (!it.next().isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }

                public RouteLabelInfo setLabels(int i4, DynamicLabel dynamicLabel) {
                    if (dynamicLabel == null) {
                        return this;
                    }
                    this.labels_.set(i4, dynamicLabel);
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    Iterator<DynamicLabel> it = getLabelsList().iterator();
                    while (it.hasNext()) {
                        dVar.u(1, it.next());
                    }
                }

                public static RouteLabelInfo parseFrom(byte[] bArr) throws e {
                    return (RouteLabelInfo) new RouteLabelInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public RouteLabelInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            DynamicLabel dynamicLabel = new DynamicLabel();
                            bVar.f(dynamicLabel);
                            addLabels(dynamicLabel);
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class RouteLabelUnit extends f {
                public static final int LABEL_CONFIG_ID_FIELD_NUMBER = 4;
                public static final int LABEL_DESC_FIELD_NUMBER = 2;
                public static final int LABEL_FLAG_FIELD_NUMBER = 3;
                public static final int LABEL_NAME_FIELD_NUMBER = 1;
                private boolean hasLabelConfigId;
                private boolean hasLabelDesc;
                private boolean hasLabelFlag;
                private boolean hasLabelName;
                private String labelName_ = "";
                private String labelDesc_ = "";
                private boolean labelFlag_ = false;
                private int labelConfigId_ = 0;
                private int cachedSize = -1;

                public static RouteLabelUnit parseFrom(b bVar) throws IOException {
                    return new RouteLabelUnit().mergeFrom(bVar);
                }

                public final RouteLabelUnit clear() {
                    clearLabelName();
                    clearLabelDesc();
                    clearLabelFlag();
                    clearLabelConfigId();
                    this.cachedSize = -1;
                    return this;
                }

                public RouteLabelUnit clearLabelConfigId() {
                    this.hasLabelConfigId = false;
                    this.labelConfigId_ = 0;
                    return this;
                }

                public RouteLabelUnit clearLabelDesc() {
                    this.hasLabelDesc = false;
                    this.labelDesc_ = "";
                    return this;
                }

                public RouteLabelUnit clearLabelFlag() {
                    this.hasLabelFlag = false;
                    this.labelFlag_ = false;
                    return this;
                }

                public RouteLabelUnit clearLabelName() {
                    this.hasLabelName = false;
                    this.labelName_ = "";
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getLabelConfigId() {
                    return this.labelConfigId_;
                }

                public String getLabelDesc() {
                    return this.labelDesc_;
                }

                public boolean getLabelFlag() {
                    return this.labelFlag_;
                }

                public String getLabelName() {
                    return this.labelName_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasLabelName() ? d.l(1, getLabelName()) : 0;
                    if (hasLabelDesc()) {
                        iL += d.l(2, getLabelDesc());
                    }
                    if (hasLabelFlag()) {
                        getLabelFlag();
                        iL += d.a(3);
                    }
                    if (hasLabelConfigId()) {
                        iL += d.e(4, getLabelConfigId());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public boolean hasLabelConfigId() {
                    return this.hasLabelConfigId;
                }

                public boolean hasLabelDesc() {
                    return this.hasLabelDesc;
                }

                public boolean hasLabelFlag() {
                    return this.hasLabelFlag;
                }

                public boolean hasLabelName() {
                    return this.hasLabelName;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public RouteLabelUnit setLabelConfigId(int i4) {
                    this.hasLabelConfigId = true;
                    this.labelConfigId_ = i4;
                    return this;
                }

                public RouteLabelUnit setLabelDesc(String str) {
                    this.hasLabelDesc = true;
                    this.labelDesc_ = str;
                    return this;
                }

                public RouteLabelUnit setLabelFlag(boolean z4) {
                    this.hasLabelFlag = true;
                    this.labelFlag_ = z4;
                    return this;
                }

                public RouteLabelUnit setLabelName(String str) {
                    this.hasLabelName = true;
                    this.labelName_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasLabelName()) {
                        dVar.A(1, getLabelName());
                    }
                    if (hasLabelDesc()) {
                        dVar.A(2, getLabelDesc());
                    }
                    if (hasLabelFlag()) {
                        dVar.p(3, getLabelFlag());
                    }
                    if (hasLabelConfigId()) {
                        dVar.s(4, getLabelConfigId());
                    }
                }

                public static RouteLabelUnit parseFrom(byte[] bArr) throws e {
                    return (RouteLabelUnit) new RouteLabelUnit().mergeFrom(bArr);
                }

                @Override // L1.f
                public RouteLabelUnit mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setLabelName(bVar.n());
                        } else if (iO == 18) {
                            setLabelDesc(bVar.n());
                        } else if (iO == 24) {
                            setLabelFlag(bVar.a());
                        } else if (iO == 32) {
                            setLabelConfigId(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class WholeCondition extends f {
                public static final int LENGTH_FIELD_NUMBER = 2;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasLength;
                private boolean hasType;
                private int type_ = 0;
                private int length_ = 0;
                private int cachedSize = -1;

                public static WholeCondition parseFrom(b bVar) throws IOException {
                    return new WholeCondition().mergeFrom(bVar);
                }

                public final WholeCondition clear() {
                    clearType();
                    clearLength();
                    this.cachedSize = -1;
                    return this;
                }

                public WholeCondition clearLength() {
                    this.hasLength = false;
                    this.length_ = 0;
                    return this;
                }

                public WholeCondition clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getLength() {
                    return this.length_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasType() ? d.e(1, getType()) : 0;
                    if (hasLength()) {
                        iE += d.e(2, getLength());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasLength() {
                    return this.hasLength;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public WholeCondition setLength(int i4) {
                    this.hasLength = true;
                    this.length_ = i4;
                    return this;
                }

                public WholeCondition setType(int i4) {
                    this.hasType = true;
                    this.type_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasType()) {
                        dVar.s(1, getType());
                    }
                    if (hasLength()) {
                        dVar.s(2, getLength());
                    }
                }

                public static WholeCondition parseFrom(byte[] bArr) throws e {
                    return (WholeCondition) new WholeCondition().mergeFrom(bArr);
                }

                @Override // L1.f
                public WholeCondition mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setType(bVar.k());
                        } else if (iO == 16) {
                            setLength(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static Routes parseFrom(b bVar) throws IOException {
                return new Routes().mergeFrom(bVar);
            }

            public Routes addCameraInfo(CameraInfo cameraInfo) {
                if (cameraInfo == null) {
                    return this;
                }
                if (this.cameraInfo_.isEmpty()) {
                    this.cameraInfo_ = new ArrayList();
                }
                this.cameraInfo_.add(cameraInfo);
                return this;
            }

            public Routes addHitCarRules(String str) {
                str.getClass();
                if (this.hitCarRules_.isEmpty()) {
                    this.hitCarRules_ = new ArrayList();
                }
                this.hitCarRules_.add(str);
                return this;
            }

            public Routes addLegs(Legs legs) {
                if (legs == null) {
                    return this;
                }
                if (this.legs_.isEmpty()) {
                    this.legs_ = new ArrayList();
                }
                this.legs_.add(legs);
                return this;
            }

            public Routes addNeListPagePanel(NEPanelInfo nEPanelInfo) {
                if (nEPanelInfo == null) {
                    return this;
                }
                if (this.neListPagePanel_.isEmpty()) {
                    this.neListPagePanel_ = new ArrayList();
                }
                this.neListPagePanel_.add(nEPanelInfo);
                return this;
            }

            public Routes addNePanelInfo(NEPanelInfo nEPanelInfo) {
                if (nEPanelInfo == null) {
                    return this;
                }
                if (this.nePanelInfo_.isEmpty()) {
                    this.nePanelInfo_ = new ArrayList();
                }
                this.nePanelInfo_.add(nEPanelInfo);
                return this;
            }

            public Routes addRouteEvent(RouteEvent routeEvent) {
                if (routeEvent == null) {
                    return this;
                }
                if (this.routeEvent_.isEmpty()) {
                    this.routeEvent_ = new ArrayList();
                }
                this.routeEvent_.add(routeEvent);
                return this;
            }

            public Routes addTransRouteTagInfo(RouteLabelUnit routeLabelUnit) {
                if (routeLabelUnit == null) {
                    return this;
                }
                if (this.transRouteTagInfo_.isEmpty()) {
                    this.transRouteTagInfo_ = new ArrayList();
                }
                this.transRouteTagInfo_.add(routeLabelUnit);
                return this;
            }

            public final Routes clear() {
                clearDesc();
                clearMrsl();
                clearLegs();
                clearTrafficCondition();
                clearMainRoads();
                clearToll();
                clearLightNum();
                clearWaitingTime();
                clearCongestionLength();
                clearTab();
                clearWholeCondition();
                clearCarPreferArray();
                clearRouteLabelName();
                clearRouteLabelTips();
                clearUgcTips();
                clearRouteDesc();
                clearRouteMd5();
                clearHitCarRules();
                clearTaxPrice();
                clearIsRpBypart();
                clearRouteUniqId();
                clearIsCollected();
                clearDescInfo();
                clearOilToll();
                clearNePanelInfo();
                clearRouteLabel();
                clearRouteEvent();
                clearCameraInfo();
                clearStreetView();
                clearNeListPagePanel();
                clearRouteLabelDesc();
                clearNeRouteLabel();
                clearTransRouteTagInfo();
                clearLightWaitTime();
                clearTrafficRestrictionFlgs();
                this.cachedSize = -1;
                return this;
            }

            public Routes clearCameraInfo() {
                this.cameraInfo_ = Collections.emptyList();
                return this;
            }

            public Routes clearCarPreferArray() {
                this.hasCarPreferArray = false;
                this.carPreferArray_ = null;
                return this;
            }

            public Routes clearCongestionLength() {
                this.hasCongestionLength = false;
                this.congestionLength_ = 0;
                return this;
            }

            public Routes clearDesc() {
                this.hasDesc = false;
                this.desc_ = "";
                return this;
            }

            public Routes clearDescInfo() {
                this.hasDescInfo = false;
                this.descInfo_ = null;
                return this;
            }

            public Routes clearHitCarRules() {
                this.hitCarRules_ = Collections.emptyList();
                return this;
            }

            public Routes clearIsCollected() {
                this.hasIsCollected = false;
                this.isCollected_ = 0;
                return this;
            }

            public Routes clearIsRpBypart() {
                this.hasIsRpBypart = false;
                this.isRpBypart_ = 0;
                return this;
            }

            public Routes clearLegs() {
                this.legs_ = Collections.emptyList();
                return this;
            }

            public Routes clearLightNum() {
                this.hasLightNum = false;
                this.lightNum_ = 0;
                return this;
            }

            public Routes clearLightWaitTime() {
                this.hasLightWaitTime = false;
                this.lightWaitTime_ = 0;
                return this;
            }

            public Routes clearMainRoads() {
                this.hasMainRoads = false;
                this.mainRoads_ = "";
                return this;
            }

            public Routes clearMrsl() {
                this.hasMrsl = false;
                this.mrsl_ = "";
                return this;
            }

            public Routes clearNeListPagePanel() {
                this.neListPagePanel_ = Collections.emptyList();
                return this;
            }

            public Routes clearNePanelInfo() {
                this.nePanelInfo_ = Collections.emptyList();
                return this;
            }

            public Routes clearNeRouteLabel() {
                this.hasNeRouteLabel = false;
                this.neRouteLabel_ = null;
                return this;
            }

            public Routes clearOilToll() {
                this.hasOilToll = false;
                this.oilToll_ = 0;
                return this;
            }

            public Routes clearRouteDesc() {
                this.hasRouteDesc = false;
                this.routeDesc_ = "";
                return this;
            }

            public Routes clearRouteEvent() {
                this.routeEvent_ = Collections.emptyList();
                return this;
            }

            public Routes clearRouteLabel() {
                this.hasRouteLabel = false;
                this.routeLabel_ = null;
                return this;
            }

            public Routes clearRouteLabelDesc() {
                this.hasRouteLabelDesc = false;
                this.routeLabelDesc_ = "";
                return this;
            }

            public Routes clearRouteLabelName() {
                this.hasRouteLabelName = false;
                this.routeLabelName_ = "";
                return this;
            }

            public Routes clearRouteLabelTips() {
                this.hasRouteLabelTips = false;
                this.routeLabelTips_ = "";
                return this;
            }

            public Routes clearRouteMd5() {
                this.hasRouteMd5 = false;
                this.routeMd5_ = "";
                return this;
            }

            public Routes clearRouteUniqId() {
                this.hasRouteUniqId = false;
                this.routeUniqId_ = "";
                return this;
            }

            public Routes clearStreetView() {
                this.hasStreetView = false;
                this.streetView_ = null;
                return this;
            }

            public Routes clearTab() {
                this.hasTab = false;
                this.tab_ = "";
                return this;
            }

            public Routes clearTaxPrice() {
                this.hasTaxPrice = false;
                this.taxPrice_ = "";
                return this;
            }

            public Routes clearToll() {
                this.hasToll = false;
                this.toll_ = 0;
                return this;
            }

            public Routes clearTrafficCondition() {
                this.hasTrafficCondition = false;
                this.trafficCondition_ = 0;
                return this;
            }

            public Routes clearTrafficRestrictionFlgs() {
                this.hasTrafficRestrictionFlgs = false;
                this.trafficRestrictionFlgs_ = 0;
                return this;
            }

            public Routes clearTransRouteTagInfo() {
                this.transRouteTagInfo_ = Collections.emptyList();
                return this;
            }

            public Routes clearUgcTips() {
                this.hasUgcTips = false;
                this.ugcTips_ = "";
                return this;
            }

            public Routes clearWaitingTime() {
                this.hasWaitingTime = false;
                this.waitingTime_ = "";
                return this;
            }

            public Routes clearWholeCondition() {
                this.hasWholeCondition = false;
                this.wholeCondition_ = null;
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public CameraInfo getCameraInfo(int i4) {
                return this.cameraInfo_.get(i4);
            }

            public int getCameraInfoCount() {
                return this.cameraInfo_.size();
            }

            public List<CameraInfo> getCameraInfoList() {
                return this.cameraInfo_;
            }

            public CarPreferInfoArray getCarPreferArray() {
                return this.carPreferArray_;
            }

            public int getCongestionLength() {
                return this.congestionLength_;
            }

            public String getDesc() {
                return this.desc_;
            }

            public DescribeInfo getDescInfo() {
                return this.descInfo_;
            }

            public String getHitCarRules(int i4) {
                return this.hitCarRules_.get(i4);
            }

            public int getHitCarRulesCount() {
                return this.hitCarRules_.size();
            }

            public List<String> getHitCarRulesList() {
                return this.hitCarRules_;
            }

            public int getIsCollected() {
                return this.isCollected_;
            }

            public int getIsRpBypart() {
                return this.isRpBypart_;
            }

            public Legs getLegs(int i4) {
                return this.legs_.get(i4);
            }

            public int getLegsCount() {
                return this.legs_.size();
            }

            public List<Legs> getLegsList() {
                return this.legs_;
            }

            public int getLightNum() {
                return this.lightNum_;
            }

            public int getLightWaitTime() {
                return this.lightWaitTime_;
            }

            public String getMainRoads() {
                return this.mainRoads_;
            }

            public String getMrsl() {
                return this.mrsl_;
            }

            public NEPanelInfo getNeListPagePanel(int i4) {
                return this.neListPagePanel_.get(i4);
            }

            public int getNeListPagePanelCount() {
                return this.neListPagePanel_.size();
            }

            public List<NEPanelInfo> getNeListPagePanelList() {
                return this.neListPagePanel_;
            }

            public NEPanelInfo getNePanelInfo(int i4) {
                return this.nePanelInfo_.get(i4);
            }

            public int getNePanelInfoCount() {
                return this.nePanelInfo_.size();
            }

            public List<NEPanelInfo> getNePanelInfoList() {
                return this.nePanelInfo_;
            }

            public NETransRouteLabel getNeRouteLabel() {
                return this.neRouteLabel_;
            }

            public int getOilToll() {
                return this.oilToll_;
            }

            public String getRouteDesc() {
                return this.routeDesc_;
            }

            public RouteEvent getRouteEvent(int i4) {
                return this.routeEvent_.get(i4);
            }

            public int getRouteEventCount() {
                return this.routeEvent_.size();
            }

            public List<RouteEvent> getRouteEventList() {
                return this.routeEvent_;
            }

            public RouteLabelInfo getRouteLabel() {
                return this.routeLabel_;
            }

            public String getRouteLabelDesc() {
                return this.routeLabelDesc_;
            }

            public String getRouteLabelName() {
                return this.routeLabelName_;
            }

            public String getRouteLabelTips() {
                return this.routeLabelTips_;
            }

            public String getRouteMd5() {
                return this.routeMd5_;
            }

            public String getRouteUniqId() {
                return this.routeUniqId_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iM = 0;
                int iL = hasDesc() ? d.l(1, getDesc()) : 0;
                if (hasMrsl()) {
                    iL += d.l(2, getMrsl());
                }
                Iterator<Legs> it = getLegsList().iterator();
                while (it.hasNext()) {
                    iL += d.h(3, it.next());
                }
                if (hasTrafficCondition()) {
                    iL += d.e(4, getTrafficCondition());
                }
                if (hasMainRoads()) {
                    iL += d.l(5, getMainRoads());
                }
                if (hasToll()) {
                    iL += d.e(6, getToll());
                }
                if (hasLightNum()) {
                    iL += d.e(7, getLightNum());
                }
                if (hasWaitingTime()) {
                    iL += d.l(8, getWaitingTime());
                }
                if (hasCongestionLength()) {
                    iL += d.e(9, getCongestionLength());
                }
                if (hasTab()) {
                    iL += d.l(10, getTab());
                }
                if (hasWholeCondition()) {
                    iL += d.h(11, getWholeCondition());
                }
                if (hasCarPreferArray()) {
                    iL += d.h(12, getCarPreferArray());
                }
                if (hasRouteLabelName()) {
                    iL += d.l(13, getRouteLabelName());
                }
                if (hasRouteLabelTips()) {
                    iL += d.l(14, getRouteLabelTips());
                }
                if (hasUgcTips()) {
                    iL += d.l(15, getUgcTips());
                }
                if (hasRouteDesc()) {
                    iL += d.l(16, getRouteDesc());
                }
                if (hasRouteMd5()) {
                    iL += d.l(17, getRouteMd5());
                }
                Iterator<String> it2 = getHitCarRulesList().iterator();
                while (it2.hasNext()) {
                    iM += d.m(it2.next());
                }
                int size = (getHitCarRulesList().size() * 2) + iL + iM;
                if (hasTaxPrice()) {
                    size += d.l(19, getTaxPrice());
                }
                if (hasIsRpBypart()) {
                    size += d.e(20, getIsRpBypart());
                }
                if (hasRouteUniqId()) {
                    size += d.l(21, getRouteUniqId());
                }
                if (hasIsCollected()) {
                    size += d.e(22, getIsCollected());
                }
                if (hasDescInfo()) {
                    size += d.h(23, getDescInfo());
                }
                if (hasOilToll()) {
                    size += d.e(24, getOilToll());
                }
                Iterator<NEPanelInfo> it3 = getNePanelInfoList().iterator();
                while (it3.hasNext()) {
                    size += d.h(25, it3.next());
                }
                if (hasRouteLabel()) {
                    size += d.h(26, getRouteLabel());
                }
                Iterator<RouteEvent> it4 = getRouteEventList().iterator();
                while (it4.hasNext()) {
                    size += d.h(27, it4.next());
                }
                Iterator<CameraInfo> it5 = getCameraInfoList().iterator();
                while (it5.hasNext()) {
                    size += d.h(28, it5.next());
                }
                if (hasStreetView()) {
                    size += d.h(29, getStreetView());
                }
                Iterator<NEPanelInfo> it6 = getNeListPagePanelList().iterator();
                while (it6.hasNext()) {
                    size += d.h(30, it6.next());
                }
                if (hasRouteLabelDesc()) {
                    size += d.l(31, getRouteLabelDesc());
                }
                if (hasNeRouteLabel()) {
                    size += d.h(32, getNeRouteLabel());
                }
                Iterator<RouteLabelUnit> it7 = getTransRouteTagInfoList().iterator();
                while (it7.hasNext()) {
                    size += d.h(33, it7.next());
                }
                if (hasLightWaitTime()) {
                    size += d.e(34, getLightWaitTime());
                }
                if (hasTrafficRestrictionFlgs()) {
                    size += d.e(35, getTrafficRestrictionFlgs());
                }
                this.cachedSize = size;
                return size;
            }

            public DstStreetView getStreetView() {
                return this.streetView_;
            }

            public String getTab() {
                return this.tab_;
            }

            public String getTaxPrice() {
                return this.taxPrice_;
            }

            public int getToll() {
                return this.toll_;
            }

            public int getTrafficCondition() {
                return this.trafficCondition_;
            }

            public int getTrafficRestrictionFlgs() {
                return this.trafficRestrictionFlgs_;
            }

            public RouteLabelUnit getTransRouteTagInfo(int i4) {
                return this.transRouteTagInfo_.get(i4);
            }

            public int getTransRouteTagInfoCount() {
                return this.transRouteTagInfo_.size();
            }

            public List<RouteLabelUnit> getTransRouteTagInfoList() {
                return this.transRouteTagInfo_;
            }

            public String getUgcTips() {
                return this.ugcTips_;
            }

            public String getWaitingTime() {
                return this.waitingTime_;
            }

            public WholeCondition getWholeCondition() {
                return this.wholeCondition_;
            }

            public boolean hasCarPreferArray() {
                return this.hasCarPreferArray;
            }

            public boolean hasCongestionLength() {
                return this.hasCongestionLength;
            }

            public boolean hasDesc() {
                return this.hasDesc;
            }

            public boolean hasDescInfo() {
                return this.hasDescInfo;
            }

            public boolean hasIsCollected() {
                return this.hasIsCollected;
            }

            public boolean hasIsRpBypart() {
                return this.hasIsRpBypart;
            }

            public boolean hasLightNum() {
                return this.hasLightNum;
            }

            public boolean hasLightWaitTime() {
                return this.hasLightWaitTime;
            }

            public boolean hasMainRoads() {
                return this.hasMainRoads;
            }

            public boolean hasMrsl() {
                return this.hasMrsl;
            }

            public boolean hasNeRouteLabel() {
                return this.hasNeRouteLabel;
            }

            public boolean hasOilToll() {
                return this.hasOilToll;
            }

            public boolean hasRouteDesc() {
                return this.hasRouteDesc;
            }

            public boolean hasRouteLabel() {
                return this.hasRouteLabel;
            }

            public boolean hasRouteLabelDesc() {
                return this.hasRouteLabelDesc;
            }

            public boolean hasRouteLabelName() {
                return this.hasRouteLabelName;
            }

            public boolean hasRouteLabelTips() {
                return this.hasRouteLabelTips;
            }

            public boolean hasRouteMd5() {
                return this.hasRouteMd5;
            }

            public boolean hasRouteUniqId() {
                return this.hasRouteUniqId;
            }

            public boolean hasStreetView() {
                return this.hasStreetView;
            }

            public boolean hasTab() {
                return this.hasTab;
            }

            public boolean hasTaxPrice() {
                return this.hasTaxPrice;
            }

            public boolean hasToll() {
                return this.hasToll;
            }

            public boolean hasTrafficCondition() {
                return this.hasTrafficCondition;
            }

            public boolean hasTrafficRestrictionFlgs() {
                return this.hasTrafficRestrictionFlgs;
            }

            public boolean hasUgcTips() {
                return this.hasUgcTips;
            }

            public boolean hasWaitingTime() {
                return this.hasWaitingTime;
            }

            public boolean hasWholeCondition() {
                return this.hasWholeCondition;
            }

            public final boolean isInitialized() {
                if (hasDescInfo() && !getDescInfo().isInitialized()) {
                    return false;
                }
                if (hasRouteLabel() && !getRouteLabel().isInitialized()) {
                    return false;
                }
                Iterator<RouteEvent> it = getRouteEventList().iterator();
                while (it.hasNext()) {
                    if (!it.next().isInitialized()) {
                        return false;
                    }
                }
                Iterator<CameraInfo> it2 = getCameraInfoList().iterator();
                while (it2.hasNext()) {
                    if (!it2.next().isInitialized()) {
                        return false;
                    }
                }
                return !hasStreetView() || getStreetView().isInitialized();
            }

            public Routes setCameraInfo(int i4, CameraInfo cameraInfo) {
                if (cameraInfo == null) {
                    return this;
                }
                this.cameraInfo_.set(i4, cameraInfo);
                return this;
            }

            public Routes setCarPreferArray(CarPreferInfoArray carPreferInfoArray) {
                if (carPreferInfoArray == null) {
                    return clearCarPreferArray();
                }
                this.hasCarPreferArray = true;
                this.carPreferArray_ = carPreferInfoArray;
                return this;
            }

            public Routes setCongestionLength(int i4) {
                this.hasCongestionLength = true;
                this.congestionLength_ = i4;
                return this;
            }

            public Routes setDesc(String str) {
                this.hasDesc = true;
                this.desc_ = str;
                return this;
            }

            public Routes setDescInfo(DescribeInfo describeInfo) {
                if (describeInfo == null) {
                    return clearDescInfo();
                }
                this.hasDescInfo = true;
                this.descInfo_ = describeInfo;
                return this;
            }

            public Routes setHitCarRules(int i4, String str) {
                str.getClass();
                this.hitCarRules_.set(i4, str);
                return this;
            }

            public Routes setIsCollected(int i4) {
                this.hasIsCollected = true;
                this.isCollected_ = i4;
                return this;
            }

            public Routes setIsRpBypart(int i4) {
                this.hasIsRpBypart = true;
                this.isRpBypart_ = i4;
                return this;
            }

            public Routes setLegs(int i4, Legs legs) {
                if (legs == null) {
                    return this;
                }
                this.legs_.set(i4, legs);
                return this;
            }

            public Routes setLightNum(int i4) {
                this.hasLightNum = true;
                this.lightNum_ = i4;
                return this;
            }

            public Routes setLightWaitTime(int i4) {
                this.hasLightWaitTime = true;
                this.lightWaitTime_ = i4;
                return this;
            }

            public Routes setMainRoads(String str) {
                this.hasMainRoads = true;
                this.mainRoads_ = str;
                return this;
            }

            public Routes setMrsl(String str) {
                this.hasMrsl = true;
                this.mrsl_ = str;
                return this;
            }

            public Routes setNeListPagePanel(int i4, NEPanelInfo nEPanelInfo) {
                if (nEPanelInfo == null) {
                    return this;
                }
                this.neListPagePanel_.set(i4, nEPanelInfo);
                return this;
            }

            public Routes setNePanelInfo(int i4, NEPanelInfo nEPanelInfo) {
                if (nEPanelInfo == null) {
                    return this;
                }
                this.nePanelInfo_.set(i4, nEPanelInfo);
                return this;
            }

            public Routes setNeRouteLabel(NETransRouteLabel nETransRouteLabel) {
                if (nETransRouteLabel == null) {
                    return clearNeRouteLabel();
                }
                this.hasNeRouteLabel = true;
                this.neRouteLabel_ = nETransRouteLabel;
                return this;
            }

            public Routes setOilToll(int i4) {
                this.hasOilToll = true;
                this.oilToll_ = i4;
                return this;
            }

            public Routes setRouteDesc(String str) {
                this.hasRouteDesc = true;
                this.routeDesc_ = str;
                return this;
            }

            public Routes setRouteEvent(int i4, RouteEvent routeEvent) {
                if (routeEvent == null) {
                    return this;
                }
                this.routeEvent_.set(i4, routeEvent);
                return this;
            }

            public Routes setRouteLabel(RouteLabelInfo routeLabelInfo) {
                if (routeLabelInfo == null) {
                    return clearRouteLabel();
                }
                this.hasRouteLabel = true;
                this.routeLabel_ = routeLabelInfo;
                return this;
            }

            public Routes setRouteLabelDesc(String str) {
                this.hasRouteLabelDesc = true;
                this.routeLabelDesc_ = str;
                return this;
            }

            public Routes setRouteLabelName(String str) {
                this.hasRouteLabelName = true;
                this.routeLabelName_ = str;
                return this;
            }

            public Routes setRouteLabelTips(String str) {
                this.hasRouteLabelTips = true;
                this.routeLabelTips_ = str;
                return this;
            }

            public Routes setRouteMd5(String str) {
                this.hasRouteMd5 = true;
                this.routeMd5_ = str;
                return this;
            }

            public Routes setRouteUniqId(String str) {
                this.hasRouteUniqId = true;
                this.routeUniqId_ = str;
                return this;
            }

            public Routes setStreetView(DstStreetView dstStreetView) {
                if (dstStreetView == null) {
                    return clearStreetView();
                }
                this.hasStreetView = true;
                this.streetView_ = dstStreetView;
                return this;
            }

            public Routes setTab(String str) {
                this.hasTab = true;
                this.tab_ = str;
                return this;
            }

            public Routes setTaxPrice(String str) {
                this.hasTaxPrice = true;
                this.taxPrice_ = str;
                return this;
            }

            public Routes setToll(int i4) {
                this.hasToll = true;
                this.toll_ = i4;
                return this;
            }

            public Routes setTrafficCondition(int i4) {
                this.hasTrafficCondition = true;
                this.trafficCondition_ = i4;
                return this;
            }

            public Routes setTrafficRestrictionFlgs(int i4) {
                this.hasTrafficRestrictionFlgs = true;
                this.trafficRestrictionFlgs_ = i4;
                return this;
            }

            public Routes setTransRouteTagInfo(int i4, RouteLabelUnit routeLabelUnit) {
                if (routeLabelUnit == null) {
                    return this;
                }
                this.transRouteTagInfo_.set(i4, routeLabelUnit);
                return this;
            }

            public Routes setUgcTips(String str) {
                this.hasUgcTips = true;
                this.ugcTips_ = str;
                return this;
            }

            public Routes setWaitingTime(String str) {
                this.hasWaitingTime = true;
                this.waitingTime_ = str;
                return this;
            }

            public Routes setWholeCondition(WholeCondition wholeCondition) {
                if (wholeCondition == null) {
                    return clearWholeCondition();
                }
                this.hasWholeCondition = true;
                this.wholeCondition_ = wholeCondition;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasDesc()) {
                    dVar.A(1, getDesc());
                }
                if (hasMrsl()) {
                    dVar.A(2, getMrsl());
                }
                Iterator<Legs> it = getLegsList().iterator();
                while (it.hasNext()) {
                    dVar.u(3, it.next());
                }
                if (hasTrafficCondition()) {
                    dVar.s(4, getTrafficCondition());
                }
                if (hasMainRoads()) {
                    dVar.A(5, getMainRoads());
                }
                if (hasToll()) {
                    dVar.s(6, getToll());
                }
                if (hasLightNum()) {
                    dVar.s(7, getLightNum());
                }
                if (hasWaitingTime()) {
                    dVar.A(8, getWaitingTime());
                }
                if (hasCongestionLength()) {
                    dVar.s(9, getCongestionLength());
                }
                if (hasTab()) {
                    dVar.A(10, getTab());
                }
                if (hasWholeCondition()) {
                    dVar.u(11, getWholeCondition());
                }
                if (hasCarPreferArray()) {
                    dVar.u(12, getCarPreferArray());
                }
                if (hasRouteLabelName()) {
                    dVar.A(13, getRouteLabelName());
                }
                if (hasRouteLabelTips()) {
                    dVar.A(14, getRouteLabelTips());
                }
                if (hasUgcTips()) {
                    dVar.A(15, getUgcTips());
                }
                if (hasRouteDesc()) {
                    dVar.A(16, getRouteDesc());
                }
                if (hasRouteMd5()) {
                    dVar.A(17, getRouteMd5());
                }
                Iterator<String> it2 = getHitCarRulesList().iterator();
                while (it2.hasNext()) {
                    dVar.A(18, it2.next());
                }
                if (hasTaxPrice()) {
                    dVar.A(19, getTaxPrice());
                }
                if (hasIsRpBypart()) {
                    dVar.s(20, getIsRpBypart());
                }
                if (hasRouteUniqId()) {
                    dVar.A(21, getRouteUniqId());
                }
                if (hasIsCollected()) {
                    dVar.s(22, getIsCollected());
                }
                if (hasDescInfo()) {
                    dVar.u(23, getDescInfo());
                }
                if (hasOilToll()) {
                    dVar.s(24, getOilToll());
                }
                Iterator<NEPanelInfo> it3 = getNePanelInfoList().iterator();
                while (it3.hasNext()) {
                    dVar.u(25, it3.next());
                }
                if (hasRouteLabel()) {
                    dVar.u(26, getRouteLabel());
                }
                Iterator<RouteEvent> it4 = getRouteEventList().iterator();
                while (it4.hasNext()) {
                    dVar.u(27, it4.next());
                }
                Iterator<CameraInfo> it5 = getCameraInfoList().iterator();
                while (it5.hasNext()) {
                    dVar.u(28, it5.next());
                }
                if (hasStreetView()) {
                    dVar.u(29, getStreetView());
                }
                Iterator<NEPanelInfo> it6 = getNeListPagePanelList().iterator();
                while (it6.hasNext()) {
                    dVar.u(30, it6.next());
                }
                if (hasRouteLabelDesc()) {
                    dVar.A(31, getRouteLabelDesc());
                }
                if (hasNeRouteLabel()) {
                    dVar.u(32, getNeRouteLabel());
                }
                Iterator<RouteLabelUnit> it7 = getTransRouteTagInfoList().iterator();
                while (it7.hasNext()) {
                    dVar.u(33, it7.next());
                }
                if (hasLightWaitTime()) {
                    dVar.s(34, getLightWaitTime());
                }
                if (hasTrafficRestrictionFlgs()) {
                    dVar.s(35, getTrafficRestrictionFlgs());
                }
            }

            public static Routes parseFrom(byte[] bArr) throws e {
                return (Routes) new Routes().mergeFrom(bArr);
            }

            @Override // L1.f
            public Routes mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    switch (iO) {
                        case 0:
                            return this;
                        case 10:
                            setDesc(bVar.n());
                            break;
                        case 18:
                            setMrsl(bVar.n());
                            break;
                        case 26:
                            Legs legs = new Legs();
                            bVar.f(legs);
                            addLegs(legs);
                            break;
                        case 32:
                            setTrafficCondition(bVar.k());
                            break;
                        case 42:
                            setMainRoads(bVar.n());
                            break;
                        case 48:
                            setToll(bVar.k());
                            break;
                        case 56:
                            setLightNum(bVar.k());
                            break;
                        case 66:
                            setWaitingTime(bVar.n());
                            break;
                        case 72:
                            setCongestionLength(bVar.k());
                            break;
                        case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                            setTab(bVar.n());
                            break;
                        case 90:
                            WholeCondition wholeCondition = new WholeCondition();
                            bVar.f(wholeCondition);
                            setWholeCondition(wholeCondition);
                            break;
                        case 98:
                            CarPreferInfoArray carPreferInfoArray = new CarPreferInfoArray();
                            bVar.f(carPreferInfoArray);
                            setCarPreferArray(carPreferInfoArray);
                            break;
                        case 106:
                            setRouteLabelName(bVar.n());
                            break;
                        case 114:
                            setRouteLabelTips(bVar.n());
                            break;
                        case 122:
                            setUgcTips(bVar.n());
                            break;
                        case 130:
                            setRouteDesc(bVar.n());
                            break;
                        case 138:
                            setRouteMd5(bVar.n());
                            break;
                        case 146:
                            addHitCarRules(bVar.n());
                            break;
                        case Opcodes.IFNE /* 154 */:
                            setTaxPrice(bVar.n());
                            break;
                        case 160:
                            setIsRpBypart(bVar.k());
                            break;
                        case 170:
                            setRouteUniqId(bVar.n());
                            break;
                        case 176:
                            setIsCollected(bVar.k());
                            break;
                        case 186:
                            DescribeInfo describeInfo = new DescribeInfo();
                            bVar.f(describeInfo);
                            setDescInfo(describeInfo);
                            break;
                        case Opcodes.CHECKCAST /* 192 */:
                            setOilToll(bVar.k());
                            break;
                        case LicenseCode.CODE_LICENSE_SERVICE_LICENSE_SIGN_ERROR /* 202 */:
                            NEPanelInfo nEPanelInfo = new NEPanelInfo();
                            bVar.f(nEPanelInfo);
                            addNePanelInfo(nEPanelInfo);
                            break;
                        case 210:
                            RouteLabelInfo routeLabelInfo = new RouteLabelInfo();
                            bVar.f(routeLabelInfo);
                            setRouteLabel(routeLabelInfo);
                            break;
                        case 218:
                            RouteEvent routeEvent = new RouteEvent();
                            bVar.f(routeEvent);
                            addRouteEvent(routeEvent);
                            break;
                        case 226:
                            CameraInfo cameraInfo = new CameraInfo();
                            bVar.f(cameraInfo);
                            addCameraInfo(cameraInfo);
                            break;
                        case 234:
                            DstStreetView dstStreetView = new DstStreetView();
                            bVar.f(dstStreetView);
                            setStreetView(dstStreetView);
                            break;
                        case 242:
                            NEPanelInfo nEPanelInfo2 = new NEPanelInfo();
                            bVar.f(nEPanelInfo2);
                            addNeListPagePanel(nEPanelInfo2);
                            break;
                        case 250:
                            setRouteLabelDesc(bVar.n());
                            break;
                        case 258:
                            NETransRouteLabel nETransRouteLabel = new NETransRouteLabel();
                            bVar.f(nETransRouteLabel);
                            setNeRouteLabel(nETransRouteLabel);
                            break;
                        case 266:
                            RouteLabelUnit routeLabelUnit = new RouteLabelUnit();
                            bVar.f(routeLabelUnit);
                            addTransRouteTagInfo(routeLabelUnit);
                            break;
                        case 272:
                            setLightWaitTime(bVar.k());
                            break;
                        case 280:
                            setTrafficRestrictionFlgs(bVar.k());
                            break;
                        default:
                            if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                            break;
                    }
                }
            }
        }

        public static final class Steps extends f {
            public static final int DIRECTION_FIELD_NUMBER = 1;
            public static final int DISTANCE_FIELD_NUMBER = 2;
            public static final int DURATION_FIELD_NUMBER = 14;
            public static final int END_INSTRUCTIONS_FIELD_NUMBER = 7;
            public static final int INSTRUCTIONS_FIELD_NUMBER = 3;
            public static final int IS_UNKNOWN_ROAD_FIELD_NUMBER = 13;
            public static final int LEVEL_FIELD_NUMBER = 10;
            public static final int PATH_FIELD_NUMBER = 4;
            public static final int ROAD_TYPE_FIELD_NUMBER = 12;
            public static final int SPATH_FIELD_NUMBER = 8;
            public static final int START_INSTRUCTIONS_FIELD_NUMBER = 6;
            public static final int STEPRCS_FIELD_NUMBER = 11;
            public static final int TURN_FIELD_NUMBER = 5;
            public static final int USROADNAME_FIELD_NUMBER = 9;
            private boolean hasDirection;
            private boolean hasDistance;
            private boolean hasDuration;
            private boolean hasEndInstructions;
            private boolean hasInstructions;
            private boolean hasIsUnknownRoad;
            private boolean hasLevel;
            private boolean hasPath;
            private boolean hasRoadType;
            private boolean hasStartInstructions;
            private boolean hasTurn;
            private boolean hasUsroadname;
            private int direction_ = 0;
            private int distance_ = 0;
            private String instructions_ = "";
            private String path_ = "";
            private int turn_ = 0;
            private String startInstructions_ = "";
            private String endInstructions_ = "";
            private List<Integer> spath_ = Collections.emptyList();
            private String usroadname_ = "";
            private int level_ = 0;
            private List<Steprcs> steprcs_ = Collections.emptyList();
            private int roadType_ = 0;
            private int isUnknownRoad_ = 0;
            private int duration_ = 0;
            private int cachedSize = -1;

            public static final class Steprcs extends f {
                public static final int END_FIELD_NUMBER = 1;
                public static final int STATUS_FIELD_NUMBER = 2;
                private boolean hasEnd;
                private boolean hasStatus;
                private int end_ = 0;
                private int status_ = 0;
                private int cachedSize = -1;

                public static Steprcs parseFrom(b bVar) throws IOException {
                    return new Steprcs().mergeFrom(bVar);
                }

                public final Steprcs clear() {
                    clearEnd();
                    clearStatus();
                    this.cachedSize = -1;
                    return this;
                }

                public Steprcs clearEnd() {
                    this.hasEnd = false;
                    this.end_ = 0;
                    return this;
                }

                public Steprcs clearStatus() {
                    this.hasStatus = false;
                    this.status_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getEnd() {
                    return this.end_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasEnd() ? d.e(1, getEnd()) : 0;
                    if (hasStatus()) {
                        iE += d.e(2, getStatus());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public int getStatus() {
                    return this.status_;
                }

                public boolean hasEnd() {
                    return this.hasEnd;
                }

                public boolean hasStatus() {
                    return this.hasStatus;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Steprcs setEnd(int i4) {
                    this.hasEnd = true;
                    this.end_ = i4;
                    return this;
                }

                public Steprcs setStatus(int i4) {
                    this.hasStatus = true;
                    this.status_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasEnd()) {
                        dVar.s(1, getEnd());
                    }
                    if (hasStatus()) {
                        dVar.s(2, getStatus());
                    }
                }

                public static Steprcs parseFrom(byte[] bArr) throws e {
                    return (Steprcs) new Steprcs().mergeFrom(bArr);
                }

                @Override // L1.f
                public Steprcs mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setEnd(bVar.k());
                        } else if (iO == 16) {
                            setStatus(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static Steps parseFrom(b bVar) throws IOException {
                return new Steps().mergeFrom(bVar);
            }

            public Steps addSpath(int i4) {
                if (this.spath_.isEmpty()) {
                    this.spath_ = new ArrayList();
                }
                this.spath_.add(Integer.valueOf(i4));
                return this;
            }

            public Steps addSteprcs(Steprcs steprcs) {
                if (steprcs == null) {
                    return this;
                }
                if (this.steprcs_.isEmpty()) {
                    this.steprcs_ = new ArrayList();
                }
                this.steprcs_.add(steprcs);
                return this;
            }

            public final Steps clear() {
                clearDirection();
                clearDistance();
                clearInstructions();
                clearPath();
                clearTurn();
                clearStartInstructions();
                clearEndInstructions();
                clearSpath();
                clearUsroadname();
                clearLevel();
                clearSteprcs();
                clearRoadType();
                clearIsUnknownRoad();
                clearDuration();
                this.cachedSize = -1;
                return this;
            }

            public Steps clearDirection() {
                this.hasDirection = false;
                this.direction_ = 0;
                return this;
            }

            public Steps clearDistance() {
                this.hasDistance = false;
                this.distance_ = 0;
                return this;
            }

            public Steps clearDuration() {
                this.hasDuration = false;
                this.duration_ = 0;
                return this;
            }

            public Steps clearEndInstructions() {
                this.hasEndInstructions = false;
                this.endInstructions_ = "";
                return this;
            }

            public Steps clearInstructions() {
                this.hasInstructions = false;
                this.instructions_ = "";
                return this;
            }

            public Steps clearIsUnknownRoad() {
                this.hasIsUnknownRoad = false;
                this.isUnknownRoad_ = 0;
                return this;
            }

            public Steps clearLevel() {
                this.hasLevel = false;
                this.level_ = 0;
                return this;
            }

            public Steps clearPath() {
                this.hasPath = false;
                this.path_ = "";
                return this;
            }

            public Steps clearRoadType() {
                this.hasRoadType = false;
                this.roadType_ = 0;
                return this;
            }

            public Steps clearSpath() {
                this.spath_ = Collections.emptyList();
                return this;
            }

            public Steps clearStartInstructions() {
                this.hasStartInstructions = false;
                this.startInstructions_ = "";
                return this;
            }

            public Steps clearSteprcs() {
                this.steprcs_ = Collections.emptyList();
                return this;
            }

            public Steps clearTurn() {
                this.hasTurn = false;
                this.turn_ = 0;
                return this;
            }

            public Steps clearUsroadname() {
                this.hasUsroadname = false;
                this.usroadname_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getDirection() {
                return this.direction_;
            }

            public int getDistance() {
                return this.distance_;
            }

            public int getDuration() {
                return this.duration_;
            }

            public String getEndInstructions() {
                return this.endInstructions_;
            }

            public String getInstructions() {
                return this.instructions_;
            }

            public int getIsUnknownRoad() {
                return this.isUnknownRoad_;
            }

            public int getLevel() {
                return this.level_;
            }

            public String getPath() {
                return this.path_;
            }

            public int getRoadType() {
                return this.roadType_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iG = 0;
                int iE = hasDirection() ? d.e(1, getDirection()) : 0;
                if (hasDistance()) {
                    iE += d.e(2, getDistance());
                }
                if (hasInstructions()) {
                    iE += d.l(3, getInstructions());
                }
                if (hasPath()) {
                    iE += d.l(4, getPath());
                }
                if (hasTurn()) {
                    iE += d.e(5, getTurn());
                }
                if (hasStartInstructions()) {
                    iE += d.l(6, getStartInstructions());
                }
                if (hasEndInstructions()) {
                    iE += d.l(7, getEndInstructions());
                }
                Iterator<Integer> it = getSpathList().iterator();
                while (it.hasNext()) {
                    iG = g.g(it.next(), iG);
                }
                int size = getSpathList().size() + iE + iG;
                if (hasUsroadname()) {
                    size += d.l(9, getUsroadname());
                }
                if (hasLevel()) {
                    size += d.e(10, getLevel());
                }
                Iterator<Steprcs> it2 = getSteprcsList().iterator();
                while (it2.hasNext()) {
                    size += d.h(11, it2.next());
                }
                if (hasRoadType()) {
                    size += d.e(12, getRoadType());
                }
                if (hasIsUnknownRoad()) {
                    size += d.e(13, getIsUnknownRoad());
                }
                if (hasDuration()) {
                    size += d.e(14, getDuration());
                }
                this.cachedSize = size;
                return size;
            }

            public int getSpath(int i4) {
                return this.spath_.get(i4).intValue();
            }

            public int getSpathCount() {
                return this.spath_.size();
            }

            public List<Integer> getSpathList() {
                return this.spath_;
            }

            public String getStartInstructions() {
                return this.startInstructions_;
            }

            public Steprcs getSteprcs(int i4) {
                return this.steprcs_.get(i4);
            }

            public int getSteprcsCount() {
                return this.steprcs_.size();
            }

            public List<Steprcs> getSteprcsList() {
                return this.steprcs_;
            }

            public int getTurn() {
                return this.turn_;
            }

            public String getUsroadname() {
                return this.usroadname_;
            }

            public boolean hasDirection() {
                return this.hasDirection;
            }

            public boolean hasDistance() {
                return this.hasDistance;
            }

            public boolean hasDuration() {
                return this.hasDuration;
            }

            public boolean hasEndInstructions() {
                return this.hasEndInstructions;
            }

            public boolean hasInstructions() {
                return this.hasInstructions;
            }

            public boolean hasIsUnknownRoad() {
                return this.hasIsUnknownRoad;
            }

            public boolean hasLevel() {
                return this.hasLevel;
            }

            public boolean hasPath() {
                return this.hasPath;
            }

            public boolean hasRoadType() {
                return this.hasRoadType;
            }

            public boolean hasStartInstructions() {
                return this.hasStartInstructions;
            }

            public boolean hasTurn() {
                return this.hasTurn;
            }

            public boolean hasUsroadname() {
                return this.hasUsroadname;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Steps setDirection(int i4) {
                this.hasDirection = true;
                this.direction_ = i4;
                return this;
            }

            public Steps setDistance(int i4) {
                this.hasDistance = true;
                this.distance_ = i4;
                return this;
            }

            public Steps setDuration(int i4) {
                this.hasDuration = true;
                this.duration_ = i4;
                return this;
            }

            public Steps setEndInstructions(String str) {
                this.hasEndInstructions = true;
                this.endInstructions_ = str;
                return this;
            }

            public Steps setInstructions(String str) {
                this.hasInstructions = true;
                this.instructions_ = str;
                return this;
            }

            public Steps setIsUnknownRoad(int i4) {
                this.hasIsUnknownRoad = true;
                this.isUnknownRoad_ = i4;
                return this;
            }

            public Steps setLevel(int i4) {
                this.hasLevel = true;
                this.level_ = i4;
                return this;
            }

            public Steps setPath(String str) {
                this.hasPath = true;
                this.path_ = str;
                return this;
            }

            public Steps setRoadType(int i4) {
                this.hasRoadType = true;
                this.roadType_ = i4;
                return this;
            }

            public Steps setSpath(int i4, int i5) {
                this.spath_.set(i4, Integer.valueOf(i5));
                return this;
            }

            public Steps setStartInstructions(String str) {
                this.hasStartInstructions = true;
                this.startInstructions_ = str;
                return this;
            }

            public Steps setSteprcs(int i4, Steprcs steprcs) {
                if (steprcs == null) {
                    return this;
                }
                this.steprcs_.set(i4, steprcs);
                return this;
            }

            public Steps setTurn(int i4) {
                this.hasTurn = true;
                this.turn_ = i4;
                return this;
            }

            public Steps setUsroadname(String str) {
                this.hasUsroadname = true;
                this.usroadname_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasDirection()) {
                    dVar.s(1, getDirection());
                }
                if (hasDistance()) {
                    dVar.s(2, getDistance());
                }
                if (hasInstructions()) {
                    dVar.A(3, getInstructions());
                }
                if (hasPath()) {
                    dVar.A(4, getPath());
                }
                if (hasTurn()) {
                    dVar.s(5, getTurn());
                }
                if (hasStartInstructions()) {
                    dVar.A(6, getStartInstructions());
                }
                if (hasEndInstructions()) {
                    dVar.A(7, getEndInstructions());
                }
                Iterator<Integer> it = getSpathList().iterator();
                while (it.hasNext()) {
                    dVar.z(8, it.next().intValue());
                }
                if (hasUsroadname()) {
                    dVar.A(9, getUsroadname());
                }
                if (hasLevel()) {
                    dVar.s(10, getLevel());
                }
                Iterator<Steprcs> it2 = getSteprcsList().iterator();
                while (it2.hasNext()) {
                    dVar.u(11, it2.next());
                }
                if (hasRoadType()) {
                    dVar.s(12, getRoadType());
                }
                if (hasIsUnknownRoad()) {
                    dVar.s(13, getIsUnknownRoad());
                }
                if (hasDuration()) {
                    dVar.s(14, getDuration());
                }
            }

            public static Steps parseFrom(byte[] bArr) throws e {
                return (Steps) new Steps().mergeFrom(bArr);
            }

            @Override // L1.f
            public Steps mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    switch (iO) {
                        case 0:
                            return this;
                        case 8:
                            setDirection(bVar.k());
                            break;
                        case 16:
                            setDistance(bVar.k());
                            break;
                        case 26:
                            setInstructions(bVar.n());
                            break;
                        case 34:
                            setPath(bVar.n());
                            break;
                        case 40:
                            setTurn(bVar.k());
                            break;
                        case 50:
                            setStartInstructions(bVar.n());
                            break;
                        case 58:
                            setEndInstructions(bVar.n());
                            break;
                        case 64:
                            addSpath(bVar.m());
                            break;
                        case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                            setUsroadname(bVar.n());
                            break;
                        case 80:
                            setLevel(bVar.k());
                            break;
                        case 90:
                            Steprcs steprcs = new Steprcs();
                            bVar.f(steprcs);
                            addSteprcs(steprcs);
                            break;
                        case 96:
                            setRoadType(bVar.k());
                            break;
                        case 104:
                            setIsUnknownRoad(bVar.k());
                            break;
                        case 112:
                            setDuration(bVar.k());
                            break;
                        default:
                            if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                            break;
                    }
                }
            }
        }

        public static final class Stepts extends f {
            public static final int END_FIELD_NUMBER = 1;
            public static final int STATUS_FIELD_NUMBER = 2;
            private List<Integer> end_ = Collections.emptyList();
            private List<Integer> status_ = Collections.emptyList();
            private int cachedSize = -1;

            public static Stepts parseFrom(b bVar) throws IOException {
                return new Stepts().mergeFrom(bVar);
            }

            public Stepts addEnd(int i4) {
                if (this.end_.isEmpty()) {
                    this.end_ = new ArrayList();
                }
                this.end_.add(Integer.valueOf(i4));
                return this;
            }

            public Stepts addStatus(int i4) {
                if (this.status_.isEmpty()) {
                    this.status_ = new ArrayList();
                }
                this.status_.add(Integer.valueOf(i4));
                return this;
            }

            public final Stepts clear() {
                clearEnd();
                clearStatus();
                this.cachedSize = -1;
                return this;
            }

            public Stepts clearEnd() {
                this.end_ = Collections.emptyList();
                return this;
            }

            public Stepts clearStatus() {
                this.status_ = Collections.emptyList();
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getEnd(int i4) {
                return this.end_.get(i4).intValue();
            }

            public int getEndCount() {
                return this.end_.size();
            }

            public List<Integer> getEndList() {
                return this.end_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                Iterator<Integer> it = getEndList().iterator();
                int iF = 0;
                int iF2 = 0;
                while (it.hasNext()) {
                    iF2 += d.f(it.next().intValue());
                }
                int size = getEndList().size() + iF2;
                Iterator<Integer> it2 = getStatusList().iterator();
                while (it2.hasNext()) {
                    iF += d.f(it2.next().intValue());
                }
                int size2 = getStatusList().size() + size + iF;
                this.cachedSize = size2;
                return size2;
            }

            public int getStatus(int i4) {
                return this.status_.get(i4).intValue();
            }

            public int getStatusCount() {
                return this.status_.size();
            }

            public List<Integer> getStatusList() {
                return this.status_;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Stepts setEnd(int i4, int i5) {
                this.end_.set(i4, Integer.valueOf(i5));
                return this;
            }

            public Stepts setStatus(int i4, int i5) {
                this.status_.set(i4, Integer.valueOf(i5));
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                Iterator<Integer> it = getEndList().iterator();
                while (it.hasNext()) {
                    dVar.s(1, it.next().intValue());
                }
                Iterator<Integer> it2 = getStatusList().iterator();
                while (it2.hasNext()) {
                    dVar.s(2, it2.next().intValue());
                }
            }

            public static Stepts parseFrom(byte[] bArr) throws e {
                return (Stepts) new Stepts().mergeFrom(bArr);
            }

            @Override // L1.f
            public Stepts mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        addEnd(bVar.k());
                    } else if (iO == 16) {
                        addStatus(bVar.k());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Taxis extends f {
            public static final int TOTAL_PRICE_FIELD_NUMBER = 1;
            private boolean hasTotalPrice;
            private String totalPrice_ = "";
            private int cachedSize = -1;

            public static Taxis parseFrom(b bVar) throws IOException {
                return new Taxis().mergeFrom(bVar);
            }

            public final Taxis clear() {
                clearTotalPrice();
                this.cachedSize = -1;
                return this;
            }

            public Taxis clearTotalPrice() {
                this.hasTotalPrice = false;
                this.totalPrice_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasTotalPrice() ? d.l(1, getTotalPrice()) : 0;
                this.cachedSize = iL;
                return iL;
            }

            public String getTotalPrice() {
                return this.totalPrice_;
            }

            public boolean hasTotalPrice() {
                return this.hasTotalPrice;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Taxis setTotalPrice(String str) {
                this.hasTotalPrice = true;
                this.totalPrice_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasTotalPrice()) {
                    dVar.A(1, getTotalPrice());
                }
            }

            public static Taxis parseFrom(byte[] bArr) throws e {
                return (Taxis) new Taxis().mergeFrom(bArr);
            }

            @Override // L1.f
            public Taxis mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setTotalPrice(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Traffics extends f {
            public static final int CONGESTION_LENGTH_FIELD_NUMBER = 3;
            public static final int DIGEST_FIELD_NUMBER = 1;
            public static final int LEGS_FIELD_NUMBER = 2;
            public static final int UGC_TIPS_FIELD_NUMBER = 4;
            private boolean hasCongestionLength;
            private boolean hasDigest;
            private boolean hasUgcTips;
            private String digest_ = "";
            private List<Legs> legs_ = Collections.emptyList();
            private int congestionLength_ = 0;
            private String ugcTips_ = "";
            private int cachedSize = -1;

            public static final class Legs extends f {
                public static final int DISTANCE_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 2;
                public static final int MRSL_FIELD_NUMBER = 4;
                public static final int STEPTIS_FIELD_NUMBER = 3;
                private boolean hasDistance;
                private boolean hasDuration;
                private boolean hasMrsl;
                private int distance_ = 0;
                private int duration_ = 0;
                private List<Steptis> steptis_ = Collections.emptyList();
                private String mrsl_ = "";
                private int cachedSize = -1;

                public static final class Steptis extends f {
                    public static final int N_FIELD_NUMBER = 1;
                    public static final int S_FIELD_NUMBER = 2;
                    private boolean hasN;
                    private boolean hasS;
                    private int n_ = 0;
                    private int s_ = 0;
                    private int cachedSize = -1;

                    public static Steptis parseFrom(b bVar) throws IOException {
                        return new Steptis().mergeFrom(bVar);
                    }

                    public final Steptis clear() {
                        clearN();
                        clearS();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Steptis clearN() {
                        this.hasN = false;
                        this.n_ = 0;
                        return this;
                    }

                    public Steptis clearS() {
                        this.hasS = false;
                        this.s_ = 0;
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getN() {
                        return this.n_;
                    }

                    public int getS() {
                        return this.s_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasN() ? d.e(1, getN()) : 0;
                        if (hasS()) {
                            iE += d.e(2, getS());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public boolean hasN() {
                        return this.hasN;
                    }

                    public boolean hasS() {
                        return this.hasS;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Steptis setN(int i4) {
                        this.hasN = true;
                        this.n_ = i4;
                        return this;
                    }

                    public Steptis setS(int i4) {
                        this.hasS = true;
                        this.s_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasN()) {
                            dVar.s(1, getN());
                        }
                        if (hasS()) {
                            dVar.s(2, getS());
                        }
                    }

                    public static Steptis parseFrom(byte[] bArr) throws e {
                        return (Steptis) new Steptis().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Steptis mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setN(bVar.k());
                            } else if (iO == 16) {
                                setS(bVar.k());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static Legs parseFrom(b bVar) throws IOException {
                    return new Legs().mergeFrom(bVar);
                }

                public Legs addSteptis(Steptis steptis) {
                    if (steptis == null) {
                        return this;
                    }
                    if (this.steptis_.isEmpty()) {
                        this.steptis_ = new ArrayList();
                    }
                    this.steptis_.add(steptis);
                    return this;
                }

                public final Legs clear() {
                    clearDistance();
                    clearDuration();
                    clearSteptis();
                    clearMrsl();
                    this.cachedSize = -1;
                    return this;
                }

                public Legs clearDistance() {
                    this.hasDistance = false;
                    this.distance_ = 0;
                    return this;
                }

                public Legs clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public Legs clearMrsl() {
                    this.hasMrsl = false;
                    this.mrsl_ = "";
                    return this;
                }

                public Legs clearSteptis() {
                    this.steptis_ = Collections.emptyList();
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getDistance() {
                    return this.distance_;
                }

                public int getDuration() {
                    return this.duration_;
                }

                public String getMrsl() {
                    return this.mrsl_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasDistance() ? d.e(1, getDistance()) : 0;
                    if (hasDuration()) {
                        iE += d.e(2, getDuration());
                    }
                    Iterator<Steptis> it = getSteptisList().iterator();
                    while (it.hasNext()) {
                        iE += d.h(3, it.next());
                    }
                    if (hasMrsl()) {
                        iE += d.l(4, getMrsl());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public Steptis getSteptis(int i4) {
                    return this.steptis_.get(i4);
                }

                public int getSteptisCount() {
                    return this.steptis_.size();
                }

                public List<Steptis> getSteptisList() {
                    return this.steptis_;
                }

                public boolean hasDistance() {
                    return this.hasDistance;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasMrsl() {
                    return this.hasMrsl;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Legs setDistance(int i4) {
                    this.hasDistance = true;
                    this.distance_ = i4;
                    return this;
                }

                public Legs setDuration(int i4) {
                    this.hasDuration = true;
                    this.duration_ = i4;
                    return this;
                }

                public Legs setMrsl(String str) {
                    this.hasMrsl = true;
                    this.mrsl_ = str;
                    return this;
                }

                public Legs setSteptis(int i4, Steptis steptis) {
                    if (steptis == null) {
                        return this;
                    }
                    this.steptis_.set(i4, steptis);
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasDistance()) {
                        dVar.s(1, getDistance());
                    }
                    if (hasDuration()) {
                        dVar.s(2, getDuration());
                    }
                    Iterator<Steptis> it = getSteptisList().iterator();
                    while (it.hasNext()) {
                        dVar.u(3, it.next());
                    }
                    if (hasMrsl()) {
                        dVar.A(4, getMrsl());
                    }
                }

                public static Legs parseFrom(byte[] bArr) throws e {
                    return (Legs) new Legs().mergeFrom(bArr);
                }

                @Override // L1.f
                public Legs mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setDistance(bVar.k());
                        } else if (iO == 16) {
                            setDuration(bVar.k());
                        } else if (iO == 26) {
                            Steptis steptis = new Steptis();
                            bVar.f(steptis);
                            addSteptis(steptis);
                        } else if (iO == 34) {
                            setMrsl(bVar.n());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static Traffics parseFrom(b bVar) throws IOException {
                return new Traffics().mergeFrom(bVar);
            }

            public Traffics addLegs(Legs legs) {
                if (legs == null) {
                    return this;
                }
                if (this.legs_.isEmpty()) {
                    this.legs_ = new ArrayList();
                }
                this.legs_.add(legs);
                return this;
            }

            public final Traffics clear() {
                clearDigest();
                clearLegs();
                clearCongestionLength();
                clearUgcTips();
                this.cachedSize = -1;
                return this;
            }

            public Traffics clearCongestionLength() {
                this.hasCongestionLength = false;
                this.congestionLength_ = 0;
                return this;
            }

            public Traffics clearDigest() {
                this.hasDigest = false;
                this.digest_ = "";
                return this;
            }

            public Traffics clearLegs() {
                this.legs_ = Collections.emptyList();
                return this;
            }

            public Traffics clearUgcTips() {
                this.hasUgcTips = false;
                this.ugcTips_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getCongestionLength() {
                return this.congestionLength_;
            }

            public String getDigest() {
                return this.digest_;
            }

            public Legs getLegs(int i4) {
                return this.legs_.get(i4);
            }

            public int getLegsCount() {
                return this.legs_.size();
            }

            public List<Legs> getLegsList() {
                return this.legs_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasDigest() ? d.l(1, getDigest()) : 0;
                Iterator<Legs> it = getLegsList().iterator();
                while (it.hasNext()) {
                    iL += d.h(2, it.next());
                }
                if (hasCongestionLength()) {
                    iL += d.e(3, getCongestionLength());
                }
                if (hasUgcTips()) {
                    iL += d.l(4, getUgcTips());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getUgcTips() {
                return this.ugcTips_;
            }

            public boolean hasCongestionLength() {
                return this.hasCongestionLength;
            }

            public boolean hasDigest() {
                return this.hasDigest;
            }

            public boolean hasUgcTips() {
                return this.hasUgcTips;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Traffics setCongestionLength(int i4) {
                this.hasCongestionLength = true;
                this.congestionLength_ = i4;
                return this;
            }

            public Traffics setDigest(String str) {
                this.hasDigest = true;
                this.digest_ = str;
                return this;
            }

            public Traffics setLegs(int i4, Legs legs) {
                if (legs == null) {
                    return this;
                }
                this.legs_.set(i4, legs);
                return this;
            }

            public Traffics setUgcTips(String str) {
                this.hasUgcTips = true;
                this.ugcTips_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasDigest()) {
                    dVar.A(1, getDigest());
                }
                Iterator<Legs> it = getLegsList().iterator();
                while (it.hasNext()) {
                    dVar.u(2, it.next());
                }
                if (hasCongestionLength()) {
                    dVar.s(3, getCongestionLength());
                }
                if (hasUgcTips()) {
                    dVar.A(4, getUgcTips());
                }
            }

            public static Traffics parseFrom(byte[] bArr) throws e {
                return (Traffics) new Traffics().mergeFrom(bArr);
            }

            @Override // L1.f
            public Traffics mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setDigest(bVar.n());
                    } else if (iO == 18) {
                        Legs legs = new Legs();
                        bVar.f(legs);
                        addLegs(legs);
                    } else if (iO == 24) {
                        setCongestionLength(bVar.k());
                    } else if (iO == 34) {
                        setUgcTips(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class WalkInfoT extends f {
            public static final int DIST_FIELD_NUMBER = 1;
            public static final int PT_FIELD_NUMBER = 2;
            private boolean hasDist;
            private int dist_ = 0;
            private List<Integer> pt_ = Collections.emptyList();
            private int cachedSize = -1;

            public static WalkInfoT parseFrom(b bVar) throws IOException {
                return new WalkInfoT().mergeFrom(bVar);
            }

            public WalkInfoT addPt(int i4) {
                if (this.pt_.isEmpty()) {
                    this.pt_ = new ArrayList();
                }
                this.pt_.add(Integer.valueOf(i4));
                return this;
            }

            public final WalkInfoT clear() {
                clearDist();
                clearPt();
                this.cachedSize = -1;
                return this;
            }

            public WalkInfoT clearDist() {
                this.hasDist = false;
                this.dist_ = 0;
                return this;
            }

            public WalkInfoT clearPt() {
                this.pt_ = Collections.emptyList();
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getDist() {
                return this.dist_;
            }

            public int getPt(int i4) {
                return this.pt_.get(i4).intValue();
            }

            public int getPtCount() {
                return this.pt_.size();
            }

            public List<Integer> getPtList() {
                return this.pt_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iF = 0;
                int iE = hasDist() ? d.e(1, getDist()) : 0;
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    iF += d.f(it.next().intValue());
                }
                int size = getPtList().size() + iE + iF;
                this.cachedSize = size;
                return size;
            }

            public boolean hasDist() {
                return this.hasDist;
            }

            public final boolean isInitialized() {
                return this.hasDist;
            }

            public WalkInfoT setDist(int i4) {
                this.hasDist = true;
                this.dist_ = i4;
                return this;
            }

            public WalkInfoT setPt(int i4, int i5) {
                this.pt_.set(i4, Integer.valueOf(i5));
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasDist()) {
                    dVar.s(1, getDist());
                }
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    dVar.s(2, it.next().intValue());
                }
            }

            public static WalkInfoT parseFrom(byte[] bArr) throws e {
                return (WalkInfoT) new WalkInfoT().mergeFrom(bArr);
            }

            @Override // L1.f
            public WalkInfoT mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setDist(bVar.k());
                    } else if (iO == 16) {
                        addPt(bVar.k());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class YellowTipsList extends f {
            public static final int MRSL_FIELD_NUMBER = 2;
            public static final int YELLOW_TIPS_INFO_FIELD_NUMBER = 1;
            private boolean hasMrsl;
            private List<YellowTipsInfo> yellowTipsInfo_ = Collections.emptyList();
            private String mrsl_ = "";
            private int cachedSize = -1;

            public static final class YellowTipsInfo extends f {
                public static final int ASSIST_INFO_FIELD_NUMBER = 3;
                public static final int BACK_COLOR_ID_FIELD_NUMBER = 6;
                public static final int DISPLAY_POS_FIELD_NUMBER = 20;
                public static final int END_BTN_FIELD_NUMBER = 7;
                public static final int EVENT_ID_FIELD_NUMBER = 13;
                public static final int EVENT_TYPE_FIELD_NUMBER = 14;
                public static final int EXPLAIN_BUBBLE_FIELD_NUMBER = 19;
                public static final int EXPLAIN_SUB_TITLE_FIELD_NUMBER = 18;
                public static final int EXPLAIN_TITLE_FIELD_NUMBER = 8;
                public static final int ICON_ID_FIELD_NUMBER = 5;
                public static final int IMAGE_EXPLAIN_FIELD_NUMBER = 16;
                public static final int IMAGE_URL_FIELD_NUMBER = 15;
                public static final int JUMP_FLAG_FIELD_NUMBER = 11;
                public static final int NEW_PATTERN_FIELD_NUMBER = 17;
                public static final int PANEL_FLAG_FIELD_NUMBER = 12;
                public static final int PERMIT_INFO_ID_FIELD_NUMBER = 9;
                public static final int ROAD_NO_FIELD_NUMBER = 10;
                public static final int SUB_TITLE_FIELD_NUMBER = 2;
                public static final int TIP_ID_FIELD_NUMBER = 4;
                public static final int TITLE_FIELD_NUMBER = 1;
                private boolean hasAssistInfo;
                private boolean hasBackColorId;
                private boolean hasDisplayPos;
                private boolean hasEventId;
                private boolean hasEventType;
                private boolean hasExplainBubble;
                private boolean hasExplainSubTitle;
                private boolean hasExplainTitle;
                private boolean hasIconId;
                private boolean hasJumpFlag;
                private boolean hasNewPattern;
                private boolean hasPanelFlag;
                private boolean hasPermitInfoId;
                private boolean hasRoadNo;
                private boolean hasSubTitle;
                private boolean hasTipId;
                private boolean hasTitle;
                private String title_ = "";
                private String subTitle_ = "";
                private String assistInfo_ = "";
                private int tipId_ = 0;
                private int iconId_ = 0;
                private int backColorId_ = 0;
                private List<end_button_info> endBtn_ = Collections.emptyList();
                private String explainTitle_ = "";
                private String permitInfoId_ = "";
                private int roadNo_ = 0;
                private int jumpFlag_ = 0;
                private int panelFlag_ = 0;
                private String eventId_ = "";
                private int eventType_ = 0;
                private List<String> imageUrl_ = Collections.emptyList();
                private List<String> imageExplain_ = Collections.emptyList();
                private int newPattern_ = 0;
                private String explainSubTitle_ = "";
                private explain_bubble_t explainBubble_ = null;
                private int displayPos_ = 0;
                private int cachedSize = -1;

                public static YellowTipsInfo parseFrom(b bVar) throws IOException {
                    return new YellowTipsInfo().mergeFrom(bVar);
                }

                public YellowTipsInfo addEndBtn(end_button_info end_button_infoVar) {
                    if (end_button_infoVar == null) {
                        return this;
                    }
                    if (this.endBtn_.isEmpty()) {
                        this.endBtn_ = new ArrayList();
                    }
                    this.endBtn_.add(end_button_infoVar);
                    return this;
                }

                public YellowTipsInfo addImageExplain(String str) {
                    str.getClass();
                    if (this.imageExplain_.isEmpty()) {
                        this.imageExplain_ = new ArrayList();
                    }
                    this.imageExplain_.add(str);
                    return this;
                }

                public YellowTipsInfo addImageUrl(String str) {
                    str.getClass();
                    if (this.imageUrl_.isEmpty()) {
                        this.imageUrl_ = new ArrayList();
                    }
                    this.imageUrl_.add(str);
                    return this;
                }

                public final YellowTipsInfo clear() {
                    clearTitle();
                    clearSubTitle();
                    clearAssistInfo();
                    clearTipId();
                    clearIconId();
                    clearBackColorId();
                    clearEndBtn();
                    clearExplainTitle();
                    clearPermitInfoId();
                    clearRoadNo();
                    clearJumpFlag();
                    clearPanelFlag();
                    clearEventId();
                    clearEventType();
                    clearImageUrl();
                    clearImageExplain();
                    clearNewPattern();
                    clearExplainSubTitle();
                    clearExplainBubble();
                    clearDisplayPos();
                    this.cachedSize = -1;
                    return this;
                }

                public YellowTipsInfo clearAssistInfo() {
                    this.hasAssistInfo = false;
                    this.assistInfo_ = "";
                    return this;
                }

                public YellowTipsInfo clearBackColorId() {
                    this.hasBackColorId = false;
                    this.backColorId_ = 0;
                    return this;
                }

                public YellowTipsInfo clearDisplayPos() {
                    this.hasDisplayPos = false;
                    this.displayPos_ = 0;
                    return this;
                }

                public YellowTipsInfo clearEndBtn() {
                    this.endBtn_ = Collections.emptyList();
                    return this;
                }

                public YellowTipsInfo clearEventId() {
                    this.hasEventId = false;
                    this.eventId_ = "";
                    return this;
                }

                public YellowTipsInfo clearEventType() {
                    this.hasEventType = false;
                    this.eventType_ = 0;
                    return this;
                }

                public YellowTipsInfo clearExplainBubble() {
                    this.hasExplainBubble = false;
                    this.explainBubble_ = null;
                    return this;
                }

                public YellowTipsInfo clearExplainSubTitle() {
                    this.hasExplainSubTitle = false;
                    this.explainSubTitle_ = "";
                    return this;
                }

                public YellowTipsInfo clearExplainTitle() {
                    this.hasExplainTitle = false;
                    this.explainTitle_ = "";
                    return this;
                }

                public YellowTipsInfo clearIconId() {
                    this.hasIconId = false;
                    this.iconId_ = 0;
                    return this;
                }

                public YellowTipsInfo clearImageExplain() {
                    this.imageExplain_ = Collections.emptyList();
                    return this;
                }

                public YellowTipsInfo clearImageUrl() {
                    this.imageUrl_ = Collections.emptyList();
                    return this;
                }

                public YellowTipsInfo clearJumpFlag() {
                    this.hasJumpFlag = false;
                    this.jumpFlag_ = 0;
                    return this;
                }

                public YellowTipsInfo clearNewPattern() {
                    this.hasNewPattern = false;
                    this.newPattern_ = 0;
                    return this;
                }

                public YellowTipsInfo clearPanelFlag() {
                    this.hasPanelFlag = false;
                    this.panelFlag_ = 0;
                    return this;
                }

                public YellowTipsInfo clearPermitInfoId() {
                    this.hasPermitInfoId = false;
                    this.permitInfoId_ = "";
                    return this;
                }

                public YellowTipsInfo clearRoadNo() {
                    this.hasRoadNo = false;
                    this.roadNo_ = 0;
                    return this;
                }

                public YellowTipsInfo clearSubTitle() {
                    this.hasSubTitle = false;
                    this.subTitle_ = "";
                    return this;
                }

                public YellowTipsInfo clearTipId() {
                    this.hasTipId = false;
                    this.tipId_ = 0;
                    return this;
                }

                public YellowTipsInfo clearTitle() {
                    this.hasTitle = false;
                    this.title_ = "";
                    return this;
                }

                public String getAssistInfo() {
                    return this.assistInfo_;
                }

                public int getBackColorId() {
                    return this.backColorId_;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getDisplayPos() {
                    return this.displayPos_;
                }

                public end_button_info getEndBtn(int i4) {
                    return this.endBtn_.get(i4);
                }

                public int getEndBtnCount() {
                    return this.endBtn_.size();
                }

                public List<end_button_info> getEndBtnList() {
                    return this.endBtn_;
                }

                public String getEventId() {
                    return this.eventId_;
                }

                public int getEventType() {
                    return this.eventType_;
                }

                public explain_bubble_t getExplainBubble() {
                    return this.explainBubble_;
                }

                public String getExplainSubTitle() {
                    return this.explainSubTitle_;
                }

                public String getExplainTitle() {
                    return this.explainTitle_;
                }

                public int getIconId() {
                    return this.iconId_;
                }

                public String getImageExplain(int i4) {
                    return this.imageExplain_.get(i4);
                }

                public int getImageExplainCount() {
                    return this.imageExplain_.size();
                }

                public List<String> getImageExplainList() {
                    return this.imageExplain_;
                }

                public String getImageUrl(int i4) {
                    return this.imageUrl_.get(i4);
                }

                public int getImageUrlCount() {
                    return this.imageUrl_.size();
                }

                public List<String> getImageUrlList() {
                    return this.imageUrl_;
                }

                public int getJumpFlag() {
                    return this.jumpFlag_;
                }

                public int getNewPattern() {
                    return this.newPattern_;
                }

                public int getPanelFlag() {
                    return this.panelFlag_;
                }

                public String getPermitInfoId() {
                    return this.permitInfoId_;
                }

                public int getRoadNo() {
                    return this.roadNo_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iM = 0;
                    int iL = hasTitle() ? d.l(1, getTitle()) : 0;
                    if (hasSubTitle()) {
                        iL += d.l(2, getSubTitle());
                    }
                    if (hasAssistInfo()) {
                        iL += d.l(3, getAssistInfo());
                    }
                    if (hasTipId()) {
                        iL += d.e(4, getTipId());
                    }
                    if (hasIconId()) {
                        iL += d.e(5, getIconId());
                    }
                    if (hasBackColorId()) {
                        iL += d.e(6, getBackColorId());
                    }
                    Iterator<end_button_info> it = getEndBtnList().iterator();
                    while (it.hasNext()) {
                        iL += d.h(7, it.next());
                    }
                    if (hasExplainTitle()) {
                        iL += d.l(8, getExplainTitle());
                    }
                    if (hasPermitInfoId()) {
                        iL += d.l(9, getPermitInfoId());
                    }
                    if (hasRoadNo()) {
                        iL += d.e(10, getRoadNo());
                    }
                    if (hasJumpFlag()) {
                        iL += d.e(11, getJumpFlag());
                    }
                    if (hasPanelFlag()) {
                        iL += d.e(12, getPanelFlag());
                    }
                    if (hasEventId()) {
                        iL += d.l(13, getEventId());
                    }
                    if (hasEventType()) {
                        iL += d.e(14, getEventType());
                    }
                    Iterator<String> it2 = getImageUrlList().iterator();
                    int iM2 = 0;
                    while (it2.hasNext()) {
                        iM2 += d.m(it2.next());
                    }
                    int size = getImageUrlList().size() + iL + iM2;
                    Iterator<String> it3 = getImageExplainList().iterator();
                    while (it3.hasNext()) {
                        iM += d.m(it3.next());
                    }
                    int size2 = (getImageExplainList().size() * 2) + size + iM;
                    if (hasNewPattern()) {
                        size2 += d.e(17, getNewPattern());
                    }
                    if (hasExplainSubTitle()) {
                        size2 += d.l(18, getExplainSubTitle());
                    }
                    if (hasExplainBubble()) {
                        size2 += d.h(19, getExplainBubble());
                    }
                    if (hasDisplayPos()) {
                        size2 += d.e(20, getDisplayPos());
                    }
                    this.cachedSize = size2;
                    return size2;
                }

                public String getSubTitle() {
                    return this.subTitle_;
                }

                public int getTipId() {
                    return this.tipId_;
                }

                public String getTitle() {
                    return this.title_;
                }

                public boolean hasAssistInfo() {
                    return this.hasAssistInfo;
                }

                public boolean hasBackColorId() {
                    return this.hasBackColorId;
                }

                public boolean hasDisplayPos() {
                    return this.hasDisplayPos;
                }

                public boolean hasEventId() {
                    return this.hasEventId;
                }

                public boolean hasEventType() {
                    return this.hasEventType;
                }

                public boolean hasExplainBubble() {
                    return this.hasExplainBubble;
                }

                public boolean hasExplainSubTitle() {
                    return this.hasExplainSubTitle;
                }

                public boolean hasExplainTitle() {
                    return this.hasExplainTitle;
                }

                public boolean hasIconId() {
                    return this.hasIconId;
                }

                public boolean hasJumpFlag() {
                    return this.hasJumpFlag;
                }

                public boolean hasNewPattern() {
                    return this.hasNewPattern;
                }

                public boolean hasPanelFlag() {
                    return this.hasPanelFlag;
                }

                public boolean hasPermitInfoId() {
                    return this.hasPermitInfoId;
                }

                public boolean hasRoadNo() {
                    return this.hasRoadNo;
                }

                public boolean hasSubTitle() {
                    return this.hasSubTitle;
                }

                public boolean hasTipId() {
                    return this.hasTipId;
                }

                public boolean hasTitle() {
                    return this.hasTitle;
                }

                public final boolean isInitialized() {
                    if (!this.hasTitle || !this.hasTipId) {
                        return false;
                    }
                    Iterator<end_button_info> it = getEndBtnList().iterator();
                    while (it.hasNext()) {
                        if (!it.next().isInitialized()) {
                            return false;
                        }
                    }
                    return !hasExplainBubble() || getExplainBubble().isInitialized();
                }

                public YellowTipsInfo setAssistInfo(String str) {
                    this.hasAssistInfo = true;
                    this.assistInfo_ = str;
                    return this;
                }

                public YellowTipsInfo setBackColorId(int i4) {
                    this.hasBackColorId = true;
                    this.backColorId_ = i4;
                    return this;
                }

                public YellowTipsInfo setDisplayPos(int i4) {
                    this.hasDisplayPos = true;
                    this.displayPos_ = i4;
                    return this;
                }

                public YellowTipsInfo setEndBtn(int i4, end_button_info end_button_infoVar) {
                    if (end_button_infoVar == null) {
                        return this;
                    }
                    this.endBtn_.set(i4, end_button_infoVar);
                    return this;
                }

                public YellowTipsInfo setEventId(String str) {
                    this.hasEventId = true;
                    this.eventId_ = str;
                    return this;
                }

                public YellowTipsInfo setEventType(int i4) {
                    this.hasEventType = true;
                    this.eventType_ = i4;
                    return this;
                }

                public YellowTipsInfo setExplainBubble(explain_bubble_t explain_bubble_tVar) {
                    if (explain_bubble_tVar == null) {
                        return clearExplainBubble();
                    }
                    this.hasExplainBubble = true;
                    this.explainBubble_ = explain_bubble_tVar;
                    return this;
                }

                public YellowTipsInfo setExplainSubTitle(String str) {
                    this.hasExplainSubTitle = true;
                    this.explainSubTitle_ = str;
                    return this;
                }

                public YellowTipsInfo setExplainTitle(String str) {
                    this.hasExplainTitle = true;
                    this.explainTitle_ = str;
                    return this;
                }

                public YellowTipsInfo setIconId(int i4) {
                    this.hasIconId = true;
                    this.iconId_ = i4;
                    return this;
                }

                public YellowTipsInfo setImageExplain(int i4, String str) {
                    str.getClass();
                    this.imageExplain_.set(i4, str);
                    return this;
                }

                public YellowTipsInfo setImageUrl(int i4, String str) {
                    str.getClass();
                    this.imageUrl_.set(i4, str);
                    return this;
                }

                public YellowTipsInfo setJumpFlag(int i4) {
                    this.hasJumpFlag = true;
                    this.jumpFlag_ = i4;
                    return this;
                }

                public YellowTipsInfo setNewPattern(int i4) {
                    this.hasNewPattern = true;
                    this.newPattern_ = i4;
                    return this;
                }

                public YellowTipsInfo setPanelFlag(int i4) {
                    this.hasPanelFlag = true;
                    this.panelFlag_ = i4;
                    return this;
                }

                public YellowTipsInfo setPermitInfoId(String str) {
                    this.hasPermitInfoId = true;
                    this.permitInfoId_ = str;
                    return this;
                }

                public YellowTipsInfo setRoadNo(int i4) {
                    this.hasRoadNo = true;
                    this.roadNo_ = i4;
                    return this;
                }

                public YellowTipsInfo setSubTitle(String str) {
                    this.hasSubTitle = true;
                    this.subTitle_ = str;
                    return this;
                }

                public YellowTipsInfo setTipId(int i4) {
                    this.hasTipId = true;
                    this.tipId_ = i4;
                    return this;
                }

                public YellowTipsInfo setTitle(String str) {
                    this.hasTitle = true;
                    this.title_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasTitle()) {
                        dVar.A(1, getTitle());
                    }
                    if (hasSubTitle()) {
                        dVar.A(2, getSubTitle());
                    }
                    if (hasAssistInfo()) {
                        dVar.A(3, getAssistInfo());
                    }
                    if (hasTipId()) {
                        dVar.s(4, getTipId());
                    }
                    if (hasIconId()) {
                        dVar.s(5, getIconId());
                    }
                    if (hasBackColorId()) {
                        dVar.s(6, getBackColorId());
                    }
                    Iterator<end_button_info> it = getEndBtnList().iterator();
                    while (it.hasNext()) {
                        dVar.u(7, it.next());
                    }
                    if (hasExplainTitle()) {
                        dVar.A(8, getExplainTitle());
                    }
                    if (hasPermitInfoId()) {
                        dVar.A(9, getPermitInfoId());
                    }
                    if (hasRoadNo()) {
                        dVar.s(10, getRoadNo());
                    }
                    if (hasJumpFlag()) {
                        dVar.s(11, getJumpFlag());
                    }
                    if (hasPanelFlag()) {
                        dVar.s(12, getPanelFlag());
                    }
                    if (hasEventId()) {
                        dVar.A(13, getEventId());
                    }
                    if (hasEventType()) {
                        dVar.s(14, getEventType());
                    }
                    Iterator<String> it2 = getImageUrlList().iterator();
                    while (it2.hasNext()) {
                        dVar.A(15, it2.next());
                    }
                    Iterator<String> it3 = getImageExplainList().iterator();
                    while (it3.hasNext()) {
                        dVar.A(16, it3.next());
                    }
                    if (hasNewPattern()) {
                        dVar.s(17, getNewPattern());
                    }
                    if (hasExplainSubTitle()) {
                        dVar.A(18, getExplainSubTitle());
                    }
                    if (hasExplainBubble()) {
                        dVar.u(19, getExplainBubble());
                    }
                    if (hasDisplayPos()) {
                        dVar.s(20, getDisplayPos());
                    }
                }

                public static YellowTipsInfo parseFrom(byte[] bArr) throws e {
                    return (YellowTipsInfo) new YellowTipsInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public YellowTipsInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        switch (iO) {
                            case 0:
                                return this;
                            case 10:
                                setTitle(bVar.n());
                                break;
                            case 18:
                                setSubTitle(bVar.n());
                                break;
                            case 26:
                                setAssistInfo(bVar.n());
                                break;
                            case 32:
                                setTipId(bVar.k());
                                break;
                            case 40:
                                setIconId(bVar.k());
                                break;
                            case 48:
                                setBackColorId(bVar.k());
                                break;
                            case 58:
                                end_button_info end_button_infoVar = new end_button_info();
                                bVar.f(end_button_infoVar);
                                addEndBtn(end_button_infoVar);
                                break;
                            case 66:
                                setExplainTitle(bVar.n());
                                break;
                            case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                                setPermitInfoId(bVar.n());
                                break;
                            case 80:
                                setRoadNo(bVar.k());
                                break;
                            case 88:
                                setJumpFlag(bVar.k());
                                break;
                            case 96:
                                setPanelFlag(bVar.k());
                                break;
                            case 106:
                                setEventId(bVar.n());
                                break;
                            case 112:
                                setEventType(bVar.k());
                                break;
                            case 122:
                                addImageUrl(bVar.n());
                                break;
                            case 130:
                                addImageExplain(bVar.n());
                                break;
                            case SyslogConstants.LOG_LOCAL1 /* 136 */:
                                setNewPattern(bVar.k());
                                break;
                            case 146:
                                setExplainSubTitle(bVar.n());
                                break;
                            case Opcodes.IFNE /* 154 */:
                                explain_bubble_t explain_bubble_tVar = new explain_bubble_t();
                                bVar.f(explain_bubble_tVar);
                                setExplainBubble(explain_bubble_tVar);
                                break;
                            case 160:
                                setDisplayPos(bVar.k());
                                break;
                            default:
                                if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                                break;
                        }
                    }
                }
            }

            public static final class end_button_info extends f {
                public static final int BACKGROUND_COLOR_FIELD_NUMBER = 8;
                public static final int BORDER_COLOR_FIELD_NUMBER = 7;
                public static final int BTN_TITLE_FIELD_NUMBER = 1;
                public static final int CITYID_FIELD_NUMBER = 6;
                public static final int CNAME_FIELD_NUMBER = 5;
                public static final int END_INPUT_FIELD_NUMBER = 2;
                public static final int SHOW_POINT_FIELD_NUMBER = 3;
                public static final int UID_FIELD_NUMBER = 4;
                private boolean hasBackgroundColor;
                private boolean hasBorderColor;
                private boolean hasBtnTitle;
                private boolean hasCityid;
                private boolean hasCname;
                private boolean hasEndInput;
                private boolean hasShowPoint;
                private boolean hasUid;
                private String btnTitle_ = "";
                private String endInput_ = "";
                private Point showPoint_ = null;
                private String uid_ = "";
                private String cname_ = "";
                private int cityid_ = 0;
                private int borderColor_ = 0;
                private int backgroundColor_ = 0;
                private int cachedSize = -1;

                public static end_button_info parseFrom(b bVar) throws IOException {
                    return new end_button_info().mergeFrom(bVar);
                }

                public final end_button_info clear() {
                    clearBtnTitle();
                    clearEndInput();
                    clearShowPoint();
                    clearUid();
                    clearCname();
                    clearCityid();
                    clearBorderColor();
                    clearBackgroundColor();
                    this.cachedSize = -1;
                    return this;
                }

                public end_button_info clearBackgroundColor() {
                    this.hasBackgroundColor = false;
                    this.backgroundColor_ = 0;
                    return this;
                }

                public end_button_info clearBorderColor() {
                    this.hasBorderColor = false;
                    this.borderColor_ = 0;
                    return this;
                }

                public end_button_info clearBtnTitle() {
                    this.hasBtnTitle = false;
                    this.btnTitle_ = "";
                    return this;
                }

                public end_button_info clearCityid() {
                    this.hasCityid = false;
                    this.cityid_ = 0;
                    return this;
                }

                public end_button_info clearCname() {
                    this.hasCname = false;
                    this.cname_ = "";
                    return this;
                }

                public end_button_info clearEndInput() {
                    this.hasEndInput = false;
                    this.endInput_ = "";
                    return this;
                }

                public end_button_info clearShowPoint() {
                    this.hasShowPoint = false;
                    this.showPoint_ = null;
                    return this;
                }

                public end_button_info clearUid() {
                    this.hasUid = false;
                    this.uid_ = "";
                    return this;
                }

                public int getBackgroundColor() {
                    return this.backgroundColor_;
                }

                public int getBorderColor() {
                    return this.borderColor_;
                }

                public String getBtnTitle() {
                    return this.btnTitle_;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCityid() {
                    return this.cityid_;
                }

                public String getCname() {
                    return this.cname_;
                }

                public String getEndInput() {
                    return this.endInput_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasBtnTitle() ? d.l(1, getBtnTitle()) : 0;
                    if (hasEndInput()) {
                        iL += d.l(2, getEndInput());
                    }
                    if (hasShowPoint()) {
                        iL += d.h(3, getShowPoint());
                    }
                    if (hasUid()) {
                        iL += d.l(4, getUid());
                    }
                    if (hasCname()) {
                        iL += d.l(5, getCname());
                    }
                    if (hasCityid()) {
                        iL += d.e(6, getCityid());
                    }
                    if (hasBorderColor()) {
                        iL += d.e(7, getBorderColor());
                    }
                    if (hasBackgroundColor()) {
                        iL += d.e(8, getBackgroundColor());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public Point getShowPoint() {
                    return this.showPoint_;
                }

                public String getUid() {
                    return this.uid_;
                }

                public boolean hasBackgroundColor() {
                    return this.hasBackgroundColor;
                }

                public boolean hasBorderColor() {
                    return this.hasBorderColor;
                }

                public boolean hasBtnTitle() {
                    return this.hasBtnTitle;
                }

                public boolean hasCityid() {
                    return this.hasCityid;
                }

                public boolean hasCname() {
                    return this.hasCname;
                }

                public boolean hasEndInput() {
                    return this.hasEndInput;
                }

                public boolean hasShowPoint() {
                    return this.hasShowPoint;
                }

                public boolean hasUid() {
                    return this.hasUid;
                }

                public final boolean isInitialized() {
                    return !hasShowPoint() || getShowPoint().isInitialized();
                }

                public end_button_info setBackgroundColor(int i4) {
                    this.hasBackgroundColor = true;
                    this.backgroundColor_ = i4;
                    return this;
                }

                public end_button_info setBorderColor(int i4) {
                    this.hasBorderColor = true;
                    this.borderColor_ = i4;
                    return this;
                }

                public end_button_info setBtnTitle(String str) {
                    this.hasBtnTitle = true;
                    this.btnTitle_ = str;
                    return this;
                }

                public end_button_info setCityid(int i4) {
                    this.hasCityid = true;
                    this.cityid_ = i4;
                    return this;
                }

                public end_button_info setCname(String str) {
                    this.hasCname = true;
                    this.cname_ = str;
                    return this;
                }

                public end_button_info setEndInput(String str) {
                    this.hasEndInput = true;
                    this.endInput_ = str;
                    return this;
                }

                public end_button_info setShowPoint(Point point) {
                    if (point == null) {
                        return clearShowPoint();
                    }
                    this.hasShowPoint = true;
                    this.showPoint_ = point;
                    return this;
                }

                public end_button_info setUid(String str) {
                    this.hasUid = true;
                    this.uid_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasBtnTitle()) {
                        dVar.A(1, getBtnTitle());
                    }
                    if (hasEndInput()) {
                        dVar.A(2, getEndInput());
                    }
                    if (hasShowPoint()) {
                        dVar.u(3, getShowPoint());
                    }
                    if (hasUid()) {
                        dVar.A(4, getUid());
                    }
                    if (hasCname()) {
                        dVar.A(5, getCname());
                    }
                    if (hasCityid()) {
                        dVar.s(6, getCityid());
                    }
                    if (hasBorderColor()) {
                        dVar.s(7, getBorderColor());
                    }
                    if (hasBackgroundColor()) {
                        dVar.s(8, getBackgroundColor());
                    }
                }

                public static end_button_info parseFrom(byte[] bArr) throws e {
                    return (end_button_info) new end_button_info().mergeFrom(bArr);
                }

                @Override // L1.f
                public end_button_info mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setBtnTitle(bVar.n());
                        } else if (iO == 18) {
                            setEndInput(bVar.n());
                        } else if (iO == 26) {
                            Point point = new Point();
                            bVar.f(point);
                            setShowPoint(point);
                        } else if (iO == 34) {
                            setUid(bVar.n());
                        } else if (iO == 42) {
                            setCname(bVar.n());
                        } else if (iO == 48) {
                            setCityid(bVar.k());
                        } else if (iO == 56) {
                            setBorderColor(bVar.k());
                        } else if (iO == 64) {
                            setBackgroundColor(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class explain_bubble_t extends f {
                public static final int CONTENT_FIELD_NUMBER = 3;
                public static final int POINT_FIELD_NUMBER = 2;
                public static final int SUB_CONTENT_FIELD_NUMBER = 4;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasContent;
                private boolean hasPoint;
                private boolean hasSubContent;
                private boolean hasType;
                private int type_ = 0;
                private Point point_ = null;
                private String content_ = "";
                private String subContent_ = "";
                private int cachedSize = -1;

                public static explain_bubble_t parseFrom(b bVar) throws IOException {
                    return new explain_bubble_t().mergeFrom(bVar);
                }

                public final explain_bubble_t clear() {
                    clearType();
                    clearPoint();
                    clearContent();
                    clearSubContent();
                    this.cachedSize = -1;
                    return this;
                }

                public explain_bubble_t clearContent() {
                    this.hasContent = false;
                    this.content_ = "";
                    return this;
                }

                public explain_bubble_t clearPoint() {
                    this.hasPoint = false;
                    this.point_ = null;
                    return this;
                }

                public explain_bubble_t clearSubContent() {
                    this.hasSubContent = false;
                    this.subContent_ = "";
                    return this;
                }

                public explain_bubble_t clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getContent() {
                    return this.content_;
                }

                public Point getPoint() {
                    return this.point_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasType() ? d.e(1, getType()) : 0;
                    if (hasPoint()) {
                        iE += d.h(2, getPoint());
                    }
                    if (hasContent()) {
                        iE += d.l(3, getContent());
                    }
                    if (hasSubContent()) {
                        iE += d.l(4, getSubContent());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public String getSubContent() {
                    return this.subContent_;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasContent() {
                    return this.hasContent;
                }

                public boolean hasPoint() {
                    return this.hasPoint;
                }

                public boolean hasSubContent() {
                    return this.hasSubContent;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return !hasPoint() || getPoint().isInitialized();
                }

                public explain_bubble_t setContent(String str) {
                    this.hasContent = true;
                    this.content_ = str;
                    return this;
                }

                public explain_bubble_t setPoint(Point point) {
                    if (point == null) {
                        return clearPoint();
                    }
                    this.hasPoint = true;
                    this.point_ = point;
                    return this;
                }

                public explain_bubble_t setSubContent(String str) {
                    this.hasSubContent = true;
                    this.subContent_ = str;
                    return this;
                }

                public explain_bubble_t setType(int i4) {
                    this.hasType = true;
                    this.type_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasType()) {
                        dVar.s(1, getType());
                    }
                    if (hasPoint()) {
                        dVar.u(2, getPoint());
                    }
                    if (hasContent()) {
                        dVar.A(3, getContent());
                    }
                    if (hasSubContent()) {
                        dVar.A(4, getSubContent());
                    }
                }

                public static explain_bubble_t parseFrom(byte[] bArr) throws e {
                    return (explain_bubble_t) new explain_bubble_t().mergeFrom(bArr);
                }

                @Override // L1.f
                public explain_bubble_t mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setType(bVar.k());
                        } else if (iO == 18) {
                            Point point = new Point();
                            bVar.f(point);
                            setPoint(point);
                        } else if (iO == 26) {
                            setContent(bVar.n());
                        } else if (iO == 34) {
                            setSubContent(bVar.n());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static YellowTipsList parseFrom(b bVar) throws IOException {
                return new YellowTipsList().mergeFrom(bVar);
            }

            public YellowTipsList addYellowTipsInfo(YellowTipsInfo yellowTipsInfo) {
                if (yellowTipsInfo == null) {
                    return this;
                }
                if (this.yellowTipsInfo_.isEmpty()) {
                    this.yellowTipsInfo_ = new ArrayList();
                }
                this.yellowTipsInfo_.add(yellowTipsInfo);
                return this;
            }

            public final YellowTipsList clear() {
                clearYellowTipsInfo();
                clearMrsl();
                this.cachedSize = -1;
                return this;
            }

            public YellowTipsList clearMrsl() {
                this.hasMrsl = false;
                this.mrsl_ = "";
                return this;
            }

            public YellowTipsList clearYellowTipsInfo() {
                this.yellowTipsInfo_ = Collections.emptyList();
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getMrsl() {
                return this.mrsl_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                Iterator<YellowTipsInfo> it = getYellowTipsInfoList().iterator();
                int iL = 0;
                while (it.hasNext()) {
                    iL += d.h(1, it.next());
                }
                if (hasMrsl()) {
                    iL += d.l(2, getMrsl());
                }
                this.cachedSize = iL;
                return iL;
            }

            public YellowTipsInfo getYellowTipsInfo(int i4) {
                return this.yellowTipsInfo_.get(i4);
            }

            public int getYellowTipsInfoCount() {
                return this.yellowTipsInfo_.size();
            }

            public List<YellowTipsInfo> getYellowTipsInfoList() {
                return this.yellowTipsInfo_;
            }

            public boolean hasMrsl() {
                return this.hasMrsl;
            }

            public final boolean isInitialized() {
                Iterator<YellowTipsInfo> it = getYellowTipsInfoList().iterator();
                while (it.hasNext()) {
                    if (!it.next().isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public YellowTipsList setMrsl(String str) {
                this.hasMrsl = true;
                this.mrsl_ = str;
                return this;
            }

            public YellowTipsList setYellowTipsInfo(int i4, YellowTipsInfo yellowTipsInfo) {
                if (yellowTipsInfo == null) {
                    return this;
                }
                this.yellowTipsInfo_.set(i4, yellowTipsInfo);
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                Iterator<YellowTipsInfo> it = getYellowTipsInfoList().iterator();
                while (it.hasNext()) {
                    dVar.u(1, it.next());
                }
                if (hasMrsl()) {
                    dVar.A(2, getMrsl());
                }
            }

            public static YellowTipsList parseFrom(byte[] bArr) throws e {
                return (YellowTipsList) new YellowTipsList().mergeFrom(bArr);
            }

            @Override // L1.f
            public YellowTipsList mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        YellowTipsInfo yellowTipsInfo = new YellowTipsInfo();
                        bVar.f(yellowTipsInfo);
                        addYellowTipsInfo(yellowTipsInfo);
                    } else if (iO == 18) {
                        setMrsl(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static Content parseFrom(b bVar) throws IOException {
            return new Content().mergeFrom(bVar);
        }

        public Content addAcciInfos(AcciInfos acciInfos) {
            if (acciInfos == null) {
                return this;
            }
            if (this.acciInfos_.isEmpty()) {
                this.acciInfos_ = new ArrayList();
            }
            this.acciInfos_.add(acciInfos);
            return this;
        }

        public Content addAvoidCarRules(String str) {
            str.getClass();
            if (this.avoidCarRules_.isEmpty()) {
                this.avoidCarRules_ = new ArrayList();
            }
            this.avoidCarRules_.add(str);
            return this;
        }

        public Content addLongDistanceInfo(LongDistanceInfo longDistanceInfo) {
            if (longDistanceInfo == null) {
                return this;
            }
            if (this.longDistanceInfo_.isEmpty()) {
                this.longDistanceInfo_ = new ArrayList();
            }
            this.longDistanceInfo_.add(longDistanceInfo);
            return this;
        }

        public Content addRoutes(Routes routes) {
            if (routes == null) {
                return this;
            }
            if (this.routes_.isEmpty()) {
                this.routes_ = new ArrayList();
            }
            this.routes_.add(routes);
            return this;
        }

        public Content addSteps(Steps steps) {
            if (steps == null) {
                return this;
            }
            if (this.steps_.isEmpty()) {
                this.steps_ = new ArrayList();
            }
            this.steps_.add(steps);
            return this;
        }

        public Content addStepts(Stepts stepts) {
            if (stepts == null) {
                return this;
            }
            if (this.stepts_.isEmpty()) {
                this.stepts_ = new ArrayList();
            }
            this.stepts_.add(stepts);
            return this;
        }

        public Content addTaxis(Taxis taxis) {
            if (taxis == null) {
                return this;
            }
            if (this.taxis_.isEmpty()) {
                this.taxis_ = new ArrayList();
            }
            this.taxis_.add(taxis);
            return this;
        }

        public Content addTraffics(Traffics traffics) {
            if (traffics == null) {
                return this;
            }
            if (this.traffics_.isEmpty()) {
                this.traffics_ = new ArrayList();
            }
            this.traffics_.add(traffics);
            return this;
        }

        public Content addYellowTipsList(YellowTipsList yellowTipsList) {
            if (yellowTipsList == null) {
                return this;
            }
            if (this.yellowTipsList_.isEmpty()) {
                this.yellowTipsList_ = new ArrayList();
            }
            this.yellowTipsList_.add(yellowTipsList);
            return this;
        }

        public final Content clear() {
            clearRoutes();
            clearSteps();
            clearStepts();
            clearTaxis();
            clearTraffics();
            clearAcciInfos();
            clearRouteStatus();
            clearLocalInfoTips();
            clearSessionid();
            clearWalkinf();
            clearLongDistanceInfo();
            clearYellowTipsList();
            clearHeatEffectiveCityFlag();
            clearAvoidCarRules();
            clearCripType();
            clearCommuterTitleDesc();
            clearAvoidJamPrefer();
            clearDynamicContent();
            this.cachedSize = -1;
            return this;
        }

        public Content clearAcciInfos() {
            this.acciInfos_ = Collections.emptyList();
            return this;
        }

        public Content clearAvoidCarRules() {
            this.avoidCarRules_ = Collections.emptyList();
            return this;
        }

        public Content clearAvoidJamPrefer() {
            this.hasAvoidJamPrefer = false;
            this.avoidJamPrefer_ = null;
            return this;
        }

        public Content clearCommuterTitleDesc() {
            this.hasCommuterTitleDesc = false;
            this.commuterTitleDesc_ = "";
            return this;
        }

        public Content clearCripType() {
            this.hasCripType = false;
            this.cripType_ = 0;
            return this;
        }

        public Content clearDynamicContent() {
            this.hasDynamicContent = false;
            this.dynamicContent_ = a.f1216c;
            return this;
        }

        public Content clearHeatEffectiveCityFlag() {
            this.hasHeatEffectiveCityFlag = false;
            this.heatEffectiveCityFlag_ = 0;
            return this;
        }

        public Content clearLocalInfoTips() {
            this.hasLocalInfoTips = false;
            this.localInfoTips_ = "";
            return this;
        }

        public Content clearLongDistanceInfo() {
            this.longDistanceInfo_ = Collections.emptyList();
            return this;
        }

        public Content clearRouteStatus() {
            this.hasRouteStatus = false;
            this.routeStatus_ = 1;
            return this;
        }

        public Content clearRoutes() {
            this.routes_ = Collections.emptyList();
            return this;
        }

        public Content clearSessionid() {
            this.hasSessionid = false;
            this.sessionid_ = "";
            return this;
        }

        public Content clearSteps() {
            this.steps_ = Collections.emptyList();
            return this;
        }

        public Content clearStepts() {
            this.stepts_ = Collections.emptyList();
            return this;
        }

        public Content clearTaxis() {
            this.taxis_ = Collections.emptyList();
            return this;
        }

        public Content clearTraffics() {
            this.traffics_ = Collections.emptyList();
            return this;
        }

        public Content clearWalkinf() {
            this.hasWalkinf = false;
            this.walkinf_ = null;
            return this;
        }

        public Content clearYellowTipsList() {
            this.yellowTipsList_ = Collections.emptyList();
            return this;
        }

        public AcciInfos getAcciInfos(int i4) {
            return this.acciInfos_.get(i4);
        }

        public int getAcciInfosCount() {
            return this.acciInfos_.size();
        }

        public List<AcciInfos> getAcciInfosList() {
            return this.acciInfos_;
        }

        public String getAvoidCarRules(int i4) {
            return this.avoidCarRules_.get(i4);
        }

        public int getAvoidCarRulesCount() {
            return this.avoidCarRules_.size();
        }

        public List<String> getAvoidCarRulesList() {
            return this.avoidCarRules_;
        }

        public AvoidJamInfoPrefer getAvoidJamPrefer() {
            return this.avoidJamPrefer_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getCommuterTitleDesc() {
            return this.commuterTitleDesc_;
        }

        public int getCripType() {
            return this.cripType_;
        }

        public a getDynamicContent() {
            return this.dynamicContent_;
        }

        public int getHeatEffectiveCityFlag() {
            return this.heatEffectiveCityFlag_;
        }

        public String getLocalInfoTips() {
            return this.localInfoTips_;
        }

        public LongDistanceInfo getLongDistanceInfo(int i4) {
            return this.longDistanceInfo_.get(i4);
        }

        public int getLongDistanceInfoCount() {
            return this.longDistanceInfo_.size();
        }

        public List<LongDistanceInfo> getLongDistanceInfoList() {
            return this.longDistanceInfo_;
        }

        public int getRouteStatus() {
            return this.routeStatus_;
        }

        public Routes getRoutes(int i4) {
            return this.routes_.get(i4);
        }

        public int getRoutesCount() {
            return this.routes_.size();
        }

        public List<Routes> getRoutesList() {
            return this.routes_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            Iterator<Routes> it = getRoutesList().iterator();
            int iM = 0;
            int iE = 0;
            while (it.hasNext()) {
                iE += d.h(1, it.next());
            }
            Iterator<Steps> it2 = getStepsList().iterator();
            while (it2.hasNext()) {
                iE += d.h(2, it2.next());
            }
            Iterator<Stepts> it3 = getSteptsList().iterator();
            while (it3.hasNext()) {
                iE += d.h(3, it3.next());
            }
            Iterator<Taxis> it4 = getTaxisList().iterator();
            while (it4.hasNext()) {
                iE += d.h(4, it4.next());
            }
            Iterator<Traffics> it5 = getTrafficsList().iterator();
            while (it5.hasNext()) {
                iE += d.h(5, it5.next());
            }
            Iterator<AcciInfos> it6 = getAcciInfosList().iterator();
            while (it6.hasNext()) {
                iE += d.h(6, it6.next());
            }
            if (hasRouteStatus()) {
                iE += d.e(7, getRouteStatus());
            }
            if (hasLocalInfoTips()) {
                iE += d.l(8, getLocalInfoTips());
            }
            if (hasSessionid()) {
                iE += d.l(9, getSessionid());
            }
            if (hasWalkinf()) {
                iE += d.h(10, getWalkinf());
            }
            Iterator<LongDistanceInfo> it7 = getLongDistanceInfoList().iterator();
            while (it7.hasNext()) {
                iE += d.h(11, it7.next());
            }
            Iterator<YellowTipsList> it8 = getYellowTipsListList().iterator();
            while (it8.hasNext()) {
                iE += d.h(12, it8.next());
            }
            if (hasHeatEffectiveCityFlag()) {
                iE += d.e(13, getHeatEffectiveCityFlag());
            }
            Iterator<String> it9 = getAvoidCarRulesList().iterator();
            while (it9.hasNext()) {
                iM += d.m(it9.next());
            }
            int size = getAvoidCarRulesList().size() + iE + iM;
            if (hasCripType()) {
                size += d.e(15, getCripType());
            }
            if (hasCommuterTitleDesc()) {
                size += d.l(16, getCommuterTitleDesc());
            }
            if (hasAvoidJamPrefer()) {
                size += d.h(17, getAvoidJamPrefer());
            }
            if (hasDynamicContent()) {
                size += d.b(18, getDynamicContent());
            }
            this.cachedSize = size;
            return size;
        }

        public String getSessionid() {
            return this.sessionid_;
        }

        public Steps getSteps(int i4) {
            return this.steps_.get(i4);
        }

        public int getStepsCount() {
            return this.steps_.size();
        }

        public List<Steps> getStepsList() {
            return this.steps_;
        }

        public Stepts getStepts(int i4) {
            return this.stepts_.get(i4);
        }

        public int getSteptsCount() {
            return this.stepts_.size();
        }

        public List<Stepts> getSteptsList() {
            return this.stepts_;
        }

        public Taxis getTaxis(int i4) {
            return this.taxis_.get(i4);
        }

        public int getTaxisCount() {
            return this.taxis_.size();
        }

        public List<Taxis> getTaxisList() {
            return this.taxis_;
        }

        public Traffics getTraffics(int i4) {
            return this.traffics_.get(i4);
        }

        public int getTrafficsCount() {
            return this.traffics_.size();
        }

        public List<Traffics> getTrafficsList() {
            return this.traffics_;
        }

        public WalkInfoT getWalkinf() {
            return this.walkinf_;
        }

        public YellowTipsList getYellowTipsList(int i4) {
            return this.yellowTipsList_.get(i4);
        }

        public int getYellowTipsListCount() {
            return this.yellowTipsList_.size();
        }

        public List<YellowTipsList> getYellowTipsListList() {
            return this.yellowTipsList_;
        }

        public boolean hasAvoidJamPrefer() {
            return this.hasAvoidJamPrefer;
        }

        public boolean hasCommuterTitleDesc() {
            return this.hasCommuterTitleDesc;
        }

        public boolean hasCripType() {
            return this.hasCripType;
        }

        public boolean hasDynamicContent() {
            return this.hasDynamicContent;
        }

        public boolean hasHeatEffectiveCityFlag() {
            return this.hasHeatEffectiveCityFlag;
        }

        public boolean hasLocalInfoTips() {
            return this.hasLocalInfoTips;
        }

        public boolean hasRouteStatus() {
            return this.hasRouteStatus;
        }

        public boolean hasSessionid() {
            return this.hasSessionid;
        }

        public boolean hasWalkinf() {
            return this.hasWalkinf;
        }

        public final boolean isInitialized() {
            Iterator<Routes> it = getRoutesList().iterator();
            while (it.hasNext()) {
                if (!it.next().isInitialized()) {
                    return false;
                }
            }
            if (hasWalkinf() && !getWalkinf().isInitialized()) {
                return false;
            }
            Iterator<LongDistanceInfo> it2 = getLongDistanceInfoList().iterator();
            while (it2.hasNext()) {
                if (!it2.next().isInitialized()) {
                    return false;
                }
            }
            Iterator<YellowTipsList> it3 = getYellowTipsListList().iterator();
            while (it3.hasNext()) {
                if (!it3.next().isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public Content setAcciInfos(int i4, AcciInfos acciInfos) {
            if (acciInfos == null) {
                return this;
            }
            this.acciInfos_.set(i4, acciInfos);
            return this;
        }

        public Content setAvoidCarRules(int i4, String str) {
            str.getClass();
            this.avoidCarRules_.set(i4, str);
            return this;
        }

        public Content setAvoidJamPrefer(AvoidJamInfoPrefer avoidJamInfoPrefer) {
            if (avoidJamInfoPrefer == null) {
                return clearAvoidJamPrefer();
            }
            this.hasAvoidJamPrefer = true;
            this.avoidJamPrefer_ = avoidJamInfoPrefer;
            return this;
        }

        public Content setCommuterTitleDesc(String str) {
            this.hasCommuterTitleDesc = true;
            this.commuterTitleDesc_ = str;
            return this;
        }

        public Content setCripType(int i4) {
            this.hasCripType = true;
            this.cripType_ = i4;
            return this;
        }

        public Content setDynamicContent(a aVar) {
            this.hasDynamicContent = true;
            this.dynamicContent_ = aVar;
            return this;
        }

        public Content setHeatEffectiveCityFlag(int i4) {
            this.hasHeatEffectiveCityFlag = true;
            this.heatEffectiveCityFlag_ = i4;
            return this;
        }

        public Content setLocalInfoTips(String str) {
            this.hasLocalInfoTips = true;
            this.localInfoTips_ = str;
            return this;
        }

        public Content setLongDistanceInfo(int i4, LongDistanceInfo longDistanceInfo) {
            if (longDistanceInfo == null) {
                return this;
            }
            this.longDistanceInfo_.set(i4, longDistanceInfo);
            return this;
        }

        public Content setRouteStatus(int i4) {
            this.hasRouteStatus = true;
            this.routeStatus_ = i4;
            return this;
        }

        public Content setRoutes(int i4, Routes routes) {
            if (routes == null) {
                return this;
            }
            this.routes_.set(i4, routes);
            return this;
        }

        public Content setSessionid(String str) {
            this.hasSessionid = true;
            this.sessionid_ = str;
            return this;
        }

        public Content setSteps(int i4, Steps steps) {
            if (steps == null) {
                return this;
            }
            this.steps_.set(i4, steps);
            return this;
        }

        public Content setStepts(int i4, Stepts stepts) {
            if (stepts == null) {
                return this;
            }
            this.stepts_.set(i4, stepts);
            return this;
        }

        public Content setTaxis(int i4, Taxis taxis) {
            if (taxis == null) {
                return this;
            }
            this.taxis_.set(i4, taxis);
            return this;
        }

        public Content setTraffics(int i4, Traffics traffics) {
            if (traffics == null) {
                return this;
            }
            this.traffics_.set(i4, traffics);
            return this;
        }

        public Content setWalkinf(WalkInfoT walkInfoT) {
            if (walkInfoT == null) {
                return clearWalkinf();
            }
            this.hasWalkinf = true;
            this.walkinf_ = walkInfoT;
            return this;
        }

        public Content setYellowTipsList(int i4, YellowTipsList yellowTipsList) {
            if (yellowTipsList == null) {
                return this;
            }
            this.yellowTipsList_.set(i4, yellowTipsList);
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            Iterator<Routes> it = getRoutesList().iterator();
            while (it.hasNext()) {
                dVar.u(1, it.next());
            }
            Iterator<Steps> it2 = getStepsList().iterator();
            while (it2.hasNext()) {
                dVar.u(2, it2.next());
            }
            Iterator<Stepts> it3 = getSteptsList().iterator();
            while (it3.hasNext()) {
                dVar.u(3, it3.next());
            }
            Iterator<Taxis> it4 = getTaxisList().iterator();
            while (it4.hasNext()) {
                dVar.u(4, it4.next());
            }
            Iterator<Traffics> it5 = getTrafficsList().iterator();
            while (it5.hasNext()) {
                dVar.u(5, it5.next());
            }
            Iterator<AcciInfos> it6 = getAcciInfosList().iterator();
            while (it6.hasNext()) {
                dVar.u(6, it6.next());
            }
            if (hasRouteStatus()) {
                dVar.s(7, getRouteStatus());
            }
            if (hasLocalInfoTips()) {
                dVar.A(8, getLocalInfoTips());
            }
            if (hasSessionid()) {
                dVar.A(9, getSessionid());
            }
            if (hasWalkinf()) {
                dVar.u(10, getWalkinf());
            }
            Iterator<LongDistanceInfo> it7 = getLongDistanceInfoList().iterator();
            while (it7.hasNext()) {
                dVar.u(11, it7.next());
            }
            Iterator<YellowTipsList> it8 = getYellowTipsListList().iterator();
            while (it8.hasNext()) {
                dVar.u(12, it8.next());
            }
            if (hasHeatEffectiveCityFlag()) {
                dVar.s(13, getHeatEffectiveCityFlag());
            }
            Iterator<String> it9 = getAvoidCarRulesList().iterator();
            while (it9.hasNext()) {
                dVar.A(14, it9.next());
            }
            if (hasCripType()) {
                dVar.s(15, getCripType());
            }
            if (hasCommuterTitleDesc()) {
                dVar.A(16, getCommuterTitleDesc());
            }
            if (hasAvoidJamPrefer()) {
                dVar.u(17, getAvoidJamPrefer());
            }
            if (hasDynamicContent()) {
                dVar.q(18, getDynamicContent());
            }
        }

        public static Content parseFrom(byte[] bArr) throws e {
            return (Content) new Content().mergeFrom(bArr);
        }

        @Override // L1.f
        public Content mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                switch (iO) {
                    case 0:
                        return this;
                    case 10:
                        Routes routes = new Routes();
                        bVar.f(routes);
                        addRoutes(routes);
                        break;
                    case 18:
                        Steps steps = new Steps();
                        bVar.f(steps);
                        addSteps(steps);
                        break;
                    case 26:
                        Stepts stepts = new Stepts();
                        bVar.f(stepts);
                        addStepts(stepts);
                        break;
                    case 34:
                        Taxis taxis = new Taxis();
                        bVar.f(taxis);
                        addTaxis(taxis);
                        break;
                    case 42:
                        Traffics traffics = new Traffics();
                        bVar.f(traffics);
                        addTraffics(traffics);
                        break;
                    case 50:
                        AcciInfos acciInfos = new AcciInfos();
                        bVar.f(acciInfos);
                        addAcciInfos(acciInfos);
                        break;
                    case 56:
                        setRouteStatus(bVar.k());
                        break;
                    case 66:
                        setLocalInfoTips(bVar.n());
                        break;
                    case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                        setSessionid(bVar.n());
                        break;
                    case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                        WalkInfoT walkInfoT = new WalkInfoT();
                        bVar.f(walkInfoT);
                        setWalkinf(walkInfoT);
                        break;
                    case 90:
                        LongDistanceInfo longDistanceInfo = new LongDistanceInfo();
                        bVar.f(longDistanceInfo);
                        addLongDistanceInfo(longDistanceInfo);
                        break;
                    case 98:
                        YellowTipsList yellowTipsList = new YellowTipsList();
                        bVar.f(yellowTipsList);
                        addYellowTipsList(yellowTipsList);
                        break;
                    case 104:
                        setHeatEffectiveCityFlag(bVar.k());
                        break;
                    case 114:
                        addAvoidCarRules(bVar.n());
                        break;
                    case SyslogConstants.LOG_CLOCK /* 120 */:
                        setCripType(bVar.k());
                        break;
                    case 130:
                        setCommuterTitleDesc(bVar.n());
                        break;
                    case 138:
                        AvoidJamInfoPrefer avoidJamInfoPrefer = new AvoidJamInfoPrefer();
                        bVar.f(avoidJamInfoPrefer);
                        setAvoidJamPrefer(avoidJamInfoPrefer);
                        break;
                    case 146:
                        setDynamicContent(bVar.b());
                        break;
                    default:
                        if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                        break;
                }
            }
        }
    }

    public static final class Option extends f {
        public static final int AVOID_JAM_FIELD_NUMBER = 1;
        public static final int END_BID_FIELD_NUMBER = 15;
        public static final int END_FIELD_NUMBER = 6;
        public static final int END_NAME_FIELD_NUMBER = 4;
        public static final int FUTURE_ROUTEETA_INFO_FIELD_NUMBER = 16;
        public static final int IS_LONG_DISTANCE_FIELD_NUMBER = 12;
        public static final int IS_RC_PREDICATION_FIELD_NUMBER = 17;
        public static final int LOCAL_INFO_URL_FIELD_NUMBER = 11;
        public static final int NAVI_TYPE_FIELD_NUMBER = 13;
        public static final int PREFER_FIELD_NUMBER = 8;
        public static final int ROUTE_PLAN_NET_MODE_FIELD_NUMBER = 10;
        public static final int Route_Plan_Net_Mode_Offline = 1;
        public static final int Route_Plan_Net_Mode_Offline2Online = 3;
        public static final int Route_Plan_Net_Mode_Online = 0;
        public static final int Route_Plan_Net_Mode_Online2Offline = 2;
        public static final int START_BID_FIELD_NUMBER = 14;
        public static final int START_FIELD_NUMBER = 5;
        public static final int START_NAME_FIELD_NUMBER = 3;
        public static final int STRONG_WEAK_FLAG_FIELD_NUMBER = 18;
        public static final int SY_FIELD_NUMBER = 7;
        public static final int TOTAL_FIELD_NUMBER = 2;
        public static final int VIA_NAME_FIELD_NUMBER = 9;
        private boolean hasAvoidJam;
        private boolean hasEndName;
        private boolean hasIsLongDistance;
        private boolean hasIsRcPredication;
        private boolean hasLocalInfoUrl;
        private boolean hasNaviType;
        private boolean hasPrefer;
        private boolean hasRoutePlanNetMode;
        private boolean hasStart;
        private boolean hasStartBid;
        private boolean hasStartName;
        private boolean hasStrongWeakFlag;
        private boolean hasSy;
        private boolean hasTotal;
        private int avoidJam_ = 0;
        private int total_ = 0;
        private String startName_ = "";
        private String endName_ = "";
        private Start start_ = null;
        private List<End> end_ = Collections.emptyList();
        private int sy_ = 0;
        private int prefer_ = 0;
        private List<String> viaName_ = Collections.emptyList();
        private int routePlanNetMode_ = 0;
        private LocalInfoUrl localInfoUrl_ = null;
        private int isLongDistance_ = 0;
        private int naviType_ = 0;
        private String startBid_ = "";
        private List<String> endBid_ = Collections.emptyList();
        private List<FutureRouteEtaInfo> futureRouteetaInfo_ = Collections.emptyList();
        private int isRcPredication_ = 0;
        private int strongWeakFlag_ = 0;
        private int cachedSize = -1;

        public static final class End extends f {
            public static final int ADDR_FIELD_NUMBER = 11;
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int BWANDA_FIELD_NUMBER = 6;
            public static final int CITYID_FIELD_NUMBER = 7;
            public static final int CITYNAME_FIELD_NUMBER = 8;
            public static final int DIRECTION_FIELD_NUMBER = 13;
            public static final int DIST_FIELD_NUMBER = 12;
            public static final int ICON_TYPE_FIELD_NUMBER = 14;
            public static final int IMAGE_URL_FIELD_NUMBER = 10;
            public static final int NEW_CATALOGID_FIELD_NUMBER = 9;
            public static final int ORIGIN_IDX_FIELD_NUMBER = 15;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 2;
            public static final int WD_FIELD_NUMBER = 3;
            private boolean hasAddr;
            private boolean hasBusStop;
            private boolean hasBwanda;
            private boolean hasCityid;
            private boolean hasCityname;
            private boolean hasDirection;
            private boolean hasDist;
            private boolean hasIconType;
            private boolean hasImageUrl;
            private boolean hasNewCatalogid;
            private boolean hasOriginIdx;
            private boolean hasPt;
            private boolean hasUid;
            private boolean hasWd;
            private String pt_ = "";
            private String uid_ = "";
            private String wd_ = "";
            private int busStop_ = 0;
            private List<Integer> spt_ = Collections.emptyList();
            private int bwanda_ = 0;
            private int cityid_ = 0;
            private String cityname_ = "";
            private int newCatalogid_ = 0;
            private a imageUrl_ = a.f1216c;
            private String addr_ = "";
            private int dist_ = 0;
            private int direction_ = 0;
            private int iconType_ = 0;
            private int originIdx_ = 0;
            private int cachedSize = -1;

            public static End parseFrom(b bVar) throws IOException {
                return new End().mergeFrom(bVar);
            }

            public End addSpt(int i4) {
                if (this.spt_.isEmpty()) {
                    this.spt_ = new ArrayList();
                }
                this.spt_.add(Integer.valueOf(i4));
                return this;
            }

            public final End clear() {
                clearPt();
                clearUid();
                clearWd();
                clearBusStop();
                clearSpt();
                clearBwanda();
                clearCityid();
                clearCityname();
                clearNewCatalogid();
                clearImageUrl();
                clearAddr();
                clearDist();
                clearDirection();
                clearIconType();
                clearOriginIdx();
                this.cachedSize = -1;
                return this;
            }

            public End clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public End clearBusStop() {
                this.hasBusStop = false;
                this.busStop_ = 0;
                return this;
            }

            public End clearBwanda() {
                this.hasBwanda = false;
                this.bwanda_ = 0;
                return this;
            }

            public End clearCityid() {
                this.hasCityid = false;
                this.cityid_ = 0;
                return this;
            }

            public End clearCityname() {
                this.hasCityname = false;
                this.cityname_ = "";
                return this;
            }

            public End clearDirection() {
                this.hasDirection = false;
                this.direction_ = 0;
                return this;
            }

            public End clearDist() {
                this.hasDist = false;
                this.dist_ = 0;
                return this;
            }

            public End clearIconType() {
                this.hasIconType = false;
                this.iconType_ = 0;
                return this;
            }

            public End clearImageUrl() {
                this.hasImageUrl = false;
                this.imageUrl_ = a.f1216c;
                return this;
            }

            public End clearNewCatalogid() {
                this.hasNewCatalogid = false;
                this.newCatalogid_ = 0;
                return this;
            }

            public End clearOriginIdx() {
                this.hasOriginIdx = false;
                this.originIdx_ = 0;
                return this;
            }

            public End clearPt() {
                this.hasPt = false;
                this.pt_ = "";
                return this;
            }

            public End clearSpt() {
                this.spt_ = Collections.emptyList();
                return this;
            }

            public End clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public End clearWd() {
                this.hasWd = false;
                this.wd_ = "";
                return this;
            }

            public String getAddr() {
                return this.addr_;
            }

            public int getBusStop() {
                return this.busStop_;
            }

            public int getBwanda() {
                return this.bwanda_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getCityid() {
                return this.cityid_;
            }

            public String getCityname() {
                return this.cityname_;
            }

            public int getDirection() {
                return this.direction_;
            }

            public int getDist() {
                return this.dist_;
            }

            public int getIconType() {
                return this.iconType_;
            }

            public a getImageUrl() {
                return this.imageUrl_;
            }

            public int getNewCatalogid() {
                return this.newCatalogid_;
            }

            public int getOriginIdx() {
                return this.originIdx_;
            }

            public String getPt() {
                return this.pt_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iG = 0;
                int iL = hasPt() ? d.l(1, getPt()) : 0;
                if (hasUid()) {
                    iL += d.l(2, getUid());
                }
                if (hasWd()) {
                    iL += d.l(3, getWd());
                }
                if (hasBusStop()) {
                    iL += d.e(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    iG = g.g(it.next(), iG);
                }
                int size = getSptList().size() + iL + iG;
                if (hasBwanda()) {
                    size += d.e(6, getBwanda());
                }
                if (hasCityid()) {
                    size += d.e(7, getCityid());
                }
                if (hasCityname()) {
                    size += d.l(8, getCityname());
                }
                if (hasNewCatalogid()) {
                    size += d.e(9, getNewCatalogid());
                }
                if (hasImageUrl()) {
                    size += d.b(10, getImageUrl());
                }
                if (hasAddr()) {
                    size += d.l(11, getAddr());
                }
                if (hasDist()) {
                    size += d.e(12, getDist());
                }
                if (hasDirection()) {
                    size += d.e(13, getDirection());
                }
                if (hasIconType()) {
                    size += d.e(14, getIconType());
                }
                if (hasOriginIdx()) {
                    size += d.e(15, getOriginIdx());
                }
                this.cachedSize = size;
                return size;
            }

            public int getSpt(int i4) {
                return this.spt_.get(i4).intValue();
            }

            public int getSptCount() {
                return this.spt_.size();
            }

            public List<Integer> getSptList() {
                return this.spt_;
            }

            public String getUid() {
                return this.uid_;
            }

            public String getWd() {
                return this.wd_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasBusStop() {
                return this.hasBusStop;
            }

            public boolean hasBwanda() {
                return this.hasBwanda;
            }

            public boolean hasCityid() {
                return this.hasCityid;
            }

            public boolean hasCityname() {
                return this.hasCityname;
            }

            public boolean hasDirection() {
                return this.hasDirection;
            }

            public boolean hasDist() {
                return this.hasDist;
            }

            public boolean hasIconType() {
                return this.hasIconType;
            }

            public boolean hasImageUrl() {
                return this.hasImageUrl;
            }

            public boolean hasNewCatalogid() {
                return this.hasNewCatalogid;
            }

            public boolean hasOriginIdx() {
                return this.hasOriginIdx;
            }

            public boolean hasPt() {
                return this.hasPt;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public boolean hasWd() {
                return this.hasWd;
            }

            public final boolean isInitialized() {
                return true;
            }

            public End setAddr(String str) {
                this.hasAddr = true;
                this.addr_ = str;
                return this;
            }

            public End setBusStop(int i4) {
                this.hasBusStop = true;
                this.busStop_ = i4;
                return this;
            }

            public End setBwanda(int i4) {
                this.hasBwanda = true;
                this.bwanda_ = i4;
                return this;
            }

            public End setCityid(int i4) {
                this.hasCityid = true;
                this.cityid_ = i4;
                return this;
            }

            public End setCityname(String str) {
                this.hasCityname = true;
                this.cityname_ = str;
                return this;
            }

            public End setDirection(int i4) {
                this.hasDirection = true;
                this.direction_ = i4;
                return this;
            }

            public End setDist(int i4) {
                this.hasDist = true;
                this.dist_ = i4;
                return this;
            }

            public End setIconType(int i4) {
                this.hasIconType = true;
                this.iconType_ = i4;
                return this;
            }

            public End setImageUrl(a aVar) {
                this.hasImageUrl = true;
                this.imageUrl_ = aVar;
                return this;
            }

            public End setNewCatalogid(int i4) {
                this.hasNewCatalogid = true;
                this.newCatalogid_ = i4;
                return this;
            }

            public End setOriginIdx(int i4) {
                this.hasOriginIdx = true;
                this.originIdx_ = i4;
                return this;
            }

            public End setPt(String str) {
                this.hasPt = true;
                this.pt_ = str;
                return this;
            }

            public End setSpt(int i4, int i5) {
                this.spt_.set(i4, Integer.valueOf(i5));
                return this;
            }

            public End setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            public End setWd(String str) {
                this.hasWd = true;
                this.wd_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasPt()) {
                    dVar.A(1, getPt());
                }
                if (hasUid()) {
                    dVar.A(2, getUid());
                }
                if (hasWd()) {
                    dVar.A(3, getWd());
                }
                if (hasBusStop()) {
                    dVar.s(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    dVar.z(5, it.next().intValue());
                }
                if (hasBwanda()) {
                    dVar.s(6, getBwanda());
                }
                if (hasCityid()) {
                    dVar.s(7, getCityid());
                }
                if (hasCityname()) {
                    dVar.A(8, getCityname());
                }
                if (hasNewCatalogid()) {
                    dVar.s(9, getNewCatalogid());
                }
                if (hasImageUrl()) {
                    dVar.q(10, getImageUrl());
                }
                if (hasAddr()) {
                    dVar.A(11, getAddr());
                }
                if (hasDist()) {
                    dVar.s(12, getDist());
                }
                if (hasDirection()) {
                    dVar.s(13, getDirection());
                }
                if (hasIconType()) {
                    dVar.s(14, getIconType());
                }
                if (hasOriginIdx()) {
                    dVar.s(15, getOriginIdx());
                }
            }

            public static End parseFrom(byte[] bArr) throws e {
                return (End) new End().mergeFrom(bArr);
            }

            @Override // L1.f
            public End mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    switch (iO) {
                        case 0:
                            return this;
                        case 10:
                            setPt(bVar.n());
                            break;
                        case 18:
                            setUid(bVar.n());
                            break;
                        case 26:
                            setWd(bVar.n());
                            break;
                        case 32:
                            setBusStop(bVar.k());
                            break;
                        case 40:
                            addSpt(bVar.m());
                            break;
                        case 48:
                            setBwanda(bVar.k());
                            break;
                        case 56:
                            setCityid(bVar.k());
                            break;
                        case 66:
                            setCityname(bVar.n());
                            break;
                        case 72:
                            setNewCatalogid(bVar.k());
                            break;
                        case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                            setImageUrl(bVar.b());
                            break;
                        case 90:
                            setAddr(bVar.n());
                            break;
                        case 96:
                            setDist(bVar.k());
                            break;
                        case 104:
                            setDirection(bVar.k());
                            break;
                        case 112:
                            setIconType(bVar.k());
                            break;
                        case SyslogConstants.LOG_CLOCK /* 120 */:
                            setOriginIdx(bVar.k());
                            break;
                        default:
                            if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                            break;
                    }
                }
            }
        }

        public static final class FutureRouteEtaInfo extends f {
            public static final int DURATION_FIELD_NUMBER = 2;
            public static final int TIMESTAMP_FIELD_NUMBER = 1;
            private boolean hasDuration;
            private boolean hasTimestamp;
            private int timestamp_ = 0;
            private int duration_ = 0;
            private int cachedSize = -1;

            public static FutureRouteEtaInfo parseFrom(b bVar) throws IOException {
                return new FutureRouteEtaInfo().mergeFrom(bVar);
            }

            public final FutureRouteEtaInfo clear() {
                clearTimestamp();
                clearDuration();
                this.cachedSize = -1;
                return this;
            }

            public FutureRouteEtaInfo clearDuration() {
                this.hasDuration = false;
                this.duration_ = 0;
                return this;
            }

            public FutureRouteEtaInfo clearTimestamp() {
                this.hasTimestamp = false;
                this.timestamp_ = 0;
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getDuration() {
                return this.duration_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasTimestamp() ? d.e(1, getTimestamp()) : 0;
                if (hasDuration()) {
                    iE += d.e(2, getDuration());
                }
                this.cachedSize = iE;
                return iE;
            }

            public int getTimestamp() {
                return this.timestamp_;
            }

            public boolean hasDuration() {
                return this.hasDuration;
            }

            public boolean hasTimestamp() {
                return this.hasTimestamp;
            }

            public final boolean isInitialized() {
                return true;
            }

            public FutureRouteEtaInfo setDuration(int i4) {
                this.hasDuration = true;
                this.duration_ = i4;
                return this;
            }

            public FutureRouteEtaInfo setTimestamp(int i4) {
                this.hasTimestamp = true;
                this.timestamp_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasTimestamp()) {
                    dVar.s(1, getTimestamp());
                }
                if (hasDuration()) {
                    dVar.s(2, getDuration());
                }
            }

            public static FutureRouteEtaInfo parseFrom(byte[] bArr) throws e {
                return (FutureRouteEtaInfo) new FutureRouteEtaInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public FutureRouteEtaInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setTimestamp(bVar.k());
                    } else if (iO == 16) {
                        setDuration(bVar.k());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class LocalInfoUrl extends f {
            public static final int URL_FIELD_NUMBER = 1;
            private boolean hasUrl;
            private String url_ = "";
            private int cachedSize = -1;

            public static LocalInfoUrl parseFrom(b bVar) throws IOException {
                return new LocalInfoUrl().mergeFrom(bVar);
            }

            public final LocalInfoUrl clear() {
                clearUrl();
                this.cachedSize = -1;
                return this;
            }

            public LocalInfoUrl clearUrl() {
                this.hasUrl = false;
                this.url_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasUrl() ? d.l(1, getUrl()) : 0;
                this.cachedSize = iL;
                return iL;
            }

            public String getUrl() {
                return this.url_;
            }

            public boolean hasUrl() {
                return this.hasUrl;
            }

            public final boolean isInitialized() {
                return true;
            }

            public LocalInfoUrl setUrl(String str) {
                this.hasUrl = true;
                this.url_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasUrl()) {
                    dVar.A(1, getUrl());
                }
            }

            public static LocalInfoUrl parseFrom(byte[] bArr) throws e {
                return (LocalInfoUrl) new LocalInfoUrl().mergeFrom(bArr);
            }

            @Override // L1.f
            public LocalInfoUrl mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setUrl(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Start extends f {
            public static final int ADDR_FIELD_NUMBER = 10;
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int CITYID_FIELD_NUMBER = 6;
            public static final int CITYNAME_FIELD_NUMBER = 7;
            public static final int DIRECTION_FIELD_NUMBER = 12;
            public static final int DIST_FIELD_NUMBER = 11;
            public static final int IMAGE_URL_FIELD_NUMBER = 9;
            public static final int NEW_CATALOGID_FIELD_NUMBER = 8;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 2;
            public static final int WD_FIELD_NUMBER = 3;
            private boolean hasAddr;
            private boolean hasBusStop;
            private boolean hasCityid;
            private boolean hasCityname;
            private boolean hasDirection;
            private boolean hasDist;
            private boolean hasImageUrl;
            private boolean hasNewCatalogid;
            private boolean hasPt;
            private boolean hasUid;
            private boolean hasWd;
            private String pt_ = "";
            private String uid_ = "";
            private String wd_ = "";
            private int busStop_ = 0;
            private List<Integer> spt_ = Collections.emptyList();
            private int cityid_ = 0;
            private String cityname_ = "";
            private int newCatalogid_ = 0;
            private a imageUrl_ = a.f1216c;
            private String addr_ = "";
            private int dist_ = 0;
            private int direction_ = 0;
            private int cachedSize = -1;

            public static Start parseFrom(b bVar) throws IOException {
                return new Start().mergeFrom(bVar);
            }

            public Start addSpt(int i4) {
                if (this.spt_.isEmpty()) {
                    this.spt_ = new ArrayList();
                }
                this.spt_.add(Integer.valueOf(i4));
                return this;
            }

            public final Start clear() {
                clearPt();
                clearUid();
                clearWd();
                clearBusStop();
                clearSpt();
                clearCityid();
                clearCityname();
                clearNewCatalogid();
                clearImageUrl();
                clearAddr();
                clearDist();
                clearDirection();
                this.cachedSize = -1;
                return this;
            }

            public Start clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public Start clearBusStop() {
                this.hasBusStop = false;
                this.busStop_ = 0;
                return this;
            }

            public Start clearCityid() {
                this.hasCityid = false;
                this.cityid_ = 0;
                return this;
            }

            public Start clearCityname() {
                this.hasCityname = false;
                this.cityname_ = "";
                return this;
            }

            public Start clearDirection() {
                this.hasDirection = false;
                this.direction_ = 0;
                return this;
            }

            public Start clearDist() {
                this.hasDist = false;
                this.dist_ = 0;
                return this;
            }

            public Start clearImageUrl() {
                this.hasImageUrl = false;
                this.imageUrl_ = a.f1216c;
                return this;
            }

            public Start clearNewCatalogid() {
                this.hasNewCatalogid = false;
                this.newCatalogid_ = 0;
                return this;
            }

            public Start clearPt() {
                this.hasPt = false;
                this.pt_ = "";
                return this;
            }

            public Start clearSpt() {
                this.spt_ = Collections.emptyList();
                return this;
            }

            public Start clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public Start clearWd() {
                this.hasWd = false;
                this.wd_ = "";
                return this;
            }

            public String getAddr() {
                return this.addr_;
            }

            public int getBusStop() {
                return this.busStop_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getCityid() {
                return this.cityid_;
            }

            public String getCityname() {
                return this.cityname_;
            }

            public int getDirection() {
                return this.direction_;
            }

            public int getDist() {
                return this.dist_;
            }

            public a getImageUrl() {
                return this.imageUrl_;
            }

            public int getNewCatalogid() {
                return this.newCatalogid_;
            }

            public String getPt() {
                return this.pt_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iG = 0;
                int iL = hasPt() ? d.l(1, getPt()) : 0;
                if (hasUid()) {
                    iL += d.l(2, getUid());
                }
                if (hasWd()) {
                    iL += d.l(3, getWd());
                }
                if (hasBusStop()) {
                    iL += d.e(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    iG = g.g(it.next(), iG);
                }
                int size = getSptList().size() + iL + iG;
                if (hasCityid()) {
                    size += d.e(6, getCityid());
                }
                if (hasCityname()) {
                    size += d.l(7, getCityname());
                }
                if (hasNewCatalogid()) {
                    size += d.e(8, getNewCatalogid());
                }
                if (hasImageUrl()) {
                    size += d.b(9, getImageUrl());
                }
                if (hasAddr()) {
                    size += d.l(10, getAddr());
                }
                if (hasDist()) {
                    size += d.e(11, getDist());
                }
                if (hasDirection()) {
                    size += d.e(12, getDirection());
                }
                this.cachedSize = size;
                return size;
            }

            public int getSpt(int i4) {
                return this.spt_.get(i4).intValue();
            }

            public int getSptCount() {
                return this.spt_.size();
            }

            public List<Integer> getSptList() {
                return this.spt_;
            }

            public String getUid() {
                return this.uid_;
            }

            public String getWd() {
                return this.wd_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasBusStop() {
                return this.hasBusStop;
            }

            public boolean hasCityid() {
                return this.hasCityid;
            }

            public boolean hasCityname() {
                return this.hasCityname;
            }

            public boolean hasDirection() {
                return this.hasDirection;
            }

            public boolean hasDist() {
                return this.hasDist;
            }

            public boolean hasImageUrl() {
                return this.hasImageUrl;
            }

            public boolean hasNewCatalogid() {
                return this.hasNewCatalogid;
            }

            public boolean hasPt() {
                return this.hasPt;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public boolean hasWd() {
                return this.hasWd;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Start setAddr(String str) {
                this.hasAddr = true;
                this.addr_ = str;
                return this;
            }

            public Start setBusStop(int i4) {
                this.hasBusStop = true;
                this.busStop_ = i4;
                return this;
            }

            public Start setCityid(int i4) {
                this.hasCityid = true;
                this.cityid_ = i4;
                return this;
            }

            public Start setCityname(String str) {
                this.hasCityname = true;
                this.cityname_ = str;
                return this;
            }

            public Start setDirection(int i4) {
                this.hasDirection = true;
                this.direction_ = i4;
                return this;
            }

            public Start setDist(int i4) {
                this.hasDist = true;
                this.dist_ = i4;
                return this;
            }

            public Start setImageUrl(a aVar) {
                this.hasImageUrl = true;
                this.imageUrl_ = aVar;
                return this;
            }

            public Start setNewCatalogid(int i4) {
                this.hasNewCatalogid = true;
                this.newCatalogid_ = i4;
                return this;
            }

            public Start setPt(String str) {
                this.hasPt = true;
                this.pt_ = str;
                return this;
            }

            public Start setSpt(int i4, int i5) {
                this.spt_.set(i4, Integer.valueOf(i5));
                return this;
            }

            public Start setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            public Start setWd(String str) {
                this.hasWd = true;
                this.wd_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasPt()) {
                    dVar.A(1, getPt());
                }
                if (hasUid()) {
                    dVar.A(2, getUid());
                }
                if (hasWd()) {
                    dVar.A(3, getWd());
                }
                if (hasBusStop()) {
                    dVar.s(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    dVar.z(5, it.next().intValue());
                }
                if (hasCityid()) {
                    dVar.s(6, getCityid());
                }
                if (hasCityname()) {
                    dVar.A(7, getCityname());
                }
                if (hasNewCatalogid()) {
                    dVar.s(8, getNewCatalogid());
                }
                if (hasImageUrl()) {
                    dVar.q(9, getImageUrl());
                }
                if (hasAddr()) {
                    dVar.A(10, getAddr());
                }
                if (hasDist()) {
                    dVar.s(11, getDist());
                }
                if (hasDirection()) {
                    dVar.s(12, getDirection());
                }
            }

            public static Start parseFrom(byte[] bArr) throws e {
                return (Start) new Start().mergeFrom(bArr);
            }

            @Override // L1.f
            public Start mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    switch (iO) {
                        case 0:
                            return this;
                        case 10:
                            setPt(bVar.n());
                            break;
                        case 18:
                            setUid(bVar.n());
                            break;
                        case 26:
                            setWd(bVar.n());
                            break;
                        case 32:
                            setBusStop(bVar.k());
                            break;
                        case 40:
                            addSpt(bVar.m());
                            break;
                        case 48:
                            setCityid(bVar.k());
                            break;
                        case 58:
                            setCityname(bVar.n());
                            break;
                        case 64:
                            setNewCatalogid(bVar.k());
                            break;
                        case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                            setImageUrl(bVar.b());
                            break;
                        case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                            setAddr(bVar.n());
                            break;
                        case 88:
                            setDist(bVar.k());
                            break;
                        case 96:
                            setDirection(bVar.k());
                            break;
                        default:
                            if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                            break;
                    }
                }
            }
        }

        public static Option parseFrom(b bVar) throws IOException {
            return new Option().mergeFrom(bVar);
        }

        public Option addEnd(End end) {
            if (end == null) {
                return this;
            }
            if (this.end_.isEmpty()) {
                this.end_ = new ArrayList();
            }
            this.end_.add(end);
            return this;
        }

        public Option addEndBid(String str) {
            str.getClass();
            if (this.endBid_.isEmpty()) {
                this.endBid_ = new ArrayList();
            }
            this.endBid_.add(str);
            return this;
        }

        public Option addFutureRouteetaInfo(FutureRouteEtaInfo futureRouteEtaInfo) {
            if (futureRouteEtaInfo == null) {
                return this;
            }
            if (this.futureRouteetaInfo_.isEmpty()) {
                this.futureRouteetaInfo_ = new ArrayList();
            }
            this.futureRouteetaInfo_.add(futureRouteEtaInfo);
            return this;
        }

        public Option addViaName(String str) {
            str.getClass();
            if (this.viaName_.isEmpty()) {
                this.viaName_ = new ArrayList();
            }
            this.viaName_.add(str);
            return this;
        }

        public final Option clear() {
            clearAvoidJam();
            clearTotal();
            clearStartName();
            clearEndName();
            clearStart();
            clearEnd();
            clearSy();
            clearPrefer();
            clearViaName();
            clearRoutePlanNetMode();
            clearLocalInfoUrl();
            clearIsLongDistance();
            clearNaviType();
            clearStartBid();
            clearEndBid();
            clearFutureRouteetaInfo();
            clearIsRcPredication();
            clearStrongWeakFlag();
            this.cachedSize = -1;
            return this;
        }

        public Option clearAvoidJam() {
            this.hasAvoidJam = false;
            this.avoidJam_ = 0;
            return this;
        }

        public Option clearEnd() {
            this.end_ = Collections.emptyList();
            return this;
        }

        public Option clearEndBid() {
            this.endBid_ = Collections.emptyList();
            return this;
        }

        public Option clearEndName() {
            this.hasEndName = false;
            this.endName_ = "";
            return this;
        }

        public Option clearFutureRouteetaInfo() {
            this.futureRouteetaInfo_ = Collections.emptyList();
            return this;
        }

        public Option clearIsLongDistance() {
            this.hasIsLongDistance = false;
            this.isLongDistance_ = 0;
            return this;
        }

        public Option clearIsRcPredication() {
            this.hasIsRcPredication = false;
            this.isRcPredication_ = 0;
            return this;
        }

        public Option clearLocalInfoUrl() {
            this.hasLocalInfoUrl = false;
            this.localInfoUrl_ = null;
            return this;
        }

        public Option clearNaviType() {
            this.hasNaviType = false;
            this.naviType_ = 0;
            return this;
        }

        public Option clearPrefer() {
            this.hasPrefer = false;
            this.prefer_ = 0;
            return this;
        }

        public Option clearRoutePlanNetMode() {
            this.hasRoutePlanNetMode = false;
            this.routePlanNetMode_ = 0;
            return this;
        }

        public Option clearStart() {
            this.hasStart = false;
            this.start_ = null;
            return this;
        }

        public Option clearStartBid() {
            this.hasStartBid = false;
            this.startBid_ = "";
            return this;
        }

        public Option clearStartName() {
            this.hasStartName = false;
            this.startName_ = "";
            return this;
        }

        public Option clearStrongWeakFlag() {
            this.hasStrongWeakFlag = false;
            this.strongWeakFlag_ = 0;
            return this;
        }

        public Option clearSy() {
            this.hasSy = false;
            this.sy_ = 0;
            return this;
        }

        public Option clearTotal() {
            this.hasTotal = false;
            this.total_ = 0;
            return this;
        }

        public Option clearViaName() {
            this.viaName_ = Collections.emptyList();
            return this;
        }

        public int getAvoidJam() {
            return this.avoidJam_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public End getEnd(int i4) {
            return this.end_.get(i4);
        }

        public String getEndBid(int i4) {
            return this.endBid_.get(i4);
        }

        public int getEndBidCount() {
            return this.endBid_.size();
        }

        public List<String> getEndBidList() {
            return this.endBid_;
        }

        public int getEndCount() {
            return this.end_.size();
        }

        public List<End> getEndList() {
            return this.end_;
        }

        public String getEndName() {
            return this.endName_;
        }

        public FutureRouteEtaInfo getFutureRouteetaInfo(int i4) {
            return this.futureRouteetaInfo_.get(i4);
        }

        public int getFutureRouteetaInfoCount() {
            return this.futureRouteetaInfo_.size();
        }

        public List<FutureRouteEtaInfo> getFutureRouteetaInfoList() {
            return this.futureRouteetaInfo_;
        }

        public int getIsLongDistance() {
            return this.isLongDistance_;
        }

        public int getIsRcPredication() {
            return this.isRcPredication_;
        }

        public LocalInfoUrl getLocalInfoUrl() {
            return this.localInfoUrl_;
        }

        public int getNaviType() {
            return this.naviType_;
        }

        public int getPrefer() {
            return this.prefer_;
        }

        public int getRoutePlanNetMode() {
            return this.routePlanNetMode_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iM = 0;
            int iE = hasAvoidJam() ? d.e(1, getAvoidJam()) : 0;
            if (hasTotal()) {
                iE += d.e(2, getTotal());
            }
            if (hasStartName()) {
                iE += d.l(3, getStartName());
            }
            if (hasEndName()) {
                iE += d.l(4, getEndName());
            }
            if (hasStart()) {
                iE += d.h(5, getStart());
            }
            Iterator<End> it = getEndList().iterator();
            while (it.hasNext()) {
                iE += d.h(6, it.next());
            }
            if (hasSy()) {
                iE += d.e(7, getSy());
            }
            if (hasPrefer()) {
                iE += d.e(8, getPrefer());
            }
            Iterator<String> it2 = getViaNameList().iterator();
            int iM2 = 0;
            while (it2.hasNext()) {
                iM2 += d.m(it2.next());
            }
            int size = getViaNameList().size() + iE + iM2;
            if (hasRoutePlanNetMode()) {
                size += d.e(10, getRoutePlanNetMode());
            }
            if (hasLocalInfoUrl()) {
                size += d.h(11, getLocalInfoUrl());
            }
            if (hasIsLongDistance()) {
                size += d.e(12, getIsLongDistance());
            }
            if (hasNaviType()) {
                size += d.e(13, getNaviType());
            }
            if (hasStartBid()) {
                size += d.l(14, getStartBid());
            }
            Iterator<String> it3 = getEndBidList().iterator();
            while (it3.hasNext()) {
                iM += d.m(it3.next());
            }
            int size2 = getEndBidList().size() + size + iM;
            Iterator<FutureRouteEtaInfo> it4 = getFutureRouteetaInfoList().iterator();
            while (it4.hasNext()) {
                size2 += d.h(16, it4.next());
            }
            if (hasIsRcPredication()) {
                size2 += d.e(17, getIsRcPredication());
            }
            if (hasStrongWeakFlag()) {
                size2 += d.e(18, getStrongWeakFlag());
            }
            this.cachedSize = size2;
            return size2;
        }

        public Start getStart() {
            return this.start_;
        }

        public String getStartBid() {
            return this.startBid_;
        }

        public String getStartName() {
            return this.startName_;
        }

        public int getStrongWeakFlag() {
            return this.strongWeakFlag_;
        }

        public int getSy() {
            return this.sy_;
        }

        public int getTotal() {
            return this.total_;
        }

        public String getViaName(int i4) {
            return this.viaName_.get(i4);
        }

        public int getViaNameCount() {
            return this.viaName_.size();
        }

        public List<String> getViaNameList() {
            return this.viaName_;
        }

        public boolean hasAvoidJam() {
            return this.hasAvoidJam;
        }

        public boolean hasEndName() {
            return this.hasEndName;
        }

        public boolean hasIsLongDistance() {
            return this.hasIsLongDistance;
        }

        public boolean hasIsRcPredication() {
            return this.hasIsRcPredication;
        }

        public boolean hasLocalInfoUrl() {
            return this.hasLocalInfoUrl;
        }

        public boolean hasNaviType() {
            return this.hasNaviType;
        }

        public boolean hasPrefer() {
            return this.hasPrefer;
        }

        public boolean hasRoutePlanNetMode() {
            return this.hasRoutePlanNetMode;
        }

        public boolean hasStart() {
            return this.hasStart;
        }

        public boolean hasStartBid() {
            return this.hasStartBid;
        }

        public boolean hasStartName() {
            return this.hasStartName;
        }

        public boolean hasStrongWeakFlag() {
            return this.hasStrongWeakFlag;
        }

        public boolean hasSy() {
            return this.hasSy;
        }

        public boolean hasTotal() {
            return this.hasTotal;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option setAvoidJam(int i4) {
            this.hasAvoidJam = true;
            this.avoidJam_ = i4;
            return this;
        }

        public Option setEnd(int i4, End end) {
            if (end == null) {
                return this;
            }
            this.end_.set(i4, end);
            return this;
        }

        public Option setEndBid(int i4, String str) {
            str.getClass();
            this.endBid_.set(i4, str);
            return this;
        }

        public Option setEndName(String str) {
            this.hasEndName = true;
            this.endName_ = str;
            return this;
        }

        public Option setFutureRouteetaInfo(int i4, FutureRouteEtaInfo futureRouteEtaInfo) {
            if (futureRouteEtaInfo == null) {
                return this;
            }
            this.futureRouteetaInfo_.set(i4, futureRouteEtaInfo);
            return this;
        }

        public Option setIsLongDistance(int i4) {
            this.hasIsLongDistance = true;
            this.isLongDistance_ = i4;
            return this;
        }

        public Option setIsRcPredication(int i4) {
            this.hasIsRcPredication = true;
            this.isRcPredication_ = i4;
            return this;
        }

        public Option setLocalInfoUrl(LocalInfoUrl localInfoUrl) {
            if (localInfoUrl == null) {
                return clearLocalInfoUrl();
            }
            this.hasLocalInfoUrl = true;
            this.localInfoUrl_ = localInfoUrl;
            return this;
        }

        public Option setNaviType(int i4) {
            this.hasNaviType = true;
            this.naviType_ = i4;
            return this;
        }

        public Option setPrefer(int i4) {
            this.hasPrefer = true;
            this.prefer_ = i4;
            return this;
        }

        public Option setRoutePlanNetMode(int i4) {
            this.hasRoutePlanNetMode = true;
            this.routePlanNetMode_ = i4;
            return this;
        }

        public Option setStart(Start start) {
            if (start == null) {
                return clearStart();
            }
            this.hasStart = true;
            this.start_ = start;
            return this;
        }

        public Option setStartBid(String str) {
            this.hasStartBid = true;
            this.startBid_ = str;
            return this;
        }

        public Option setStartName(String str) {
            this.hasStartName = true;
            this.startName_ = str;
            return this;
        }

        public Option setStrongWeakFlag(int i4) {
            this.hasStrongWeakFlag = true;
            this.strongWeakFlag_ = i4;
            return this;
        }

        public Option setSy(int i4) {
            this.hasSy = true;
            this.sy_ = i4;
            return this;
        }

        public Option setTotal(int i4) {
            this.hasTotal = true;
            this.total_ = i4;
            return this;
        }

        public Option setViaName(int i4, String str) {
            str.getClass();
            this.viaName_.set(i4, str);
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasAvoidJam()) {
                dVar.s(1, getAvoidJam());
            }
            if (hasTotal()) {
                dVar.s(2, getTotal());
            }
            if (hasStartName()) {
                dVar.A(3, getStartName());
            }
            if (hasEndName()) {
                dVar.A(4, getEndName());
            }
            if (hasStart()) {
                dVar.u(5, getStart());
            }
            Iterator<End> it = getEndList().iterator();
            while (it.hasNext()) {
                dVar.u(6, it.next());
            }
            if (hasSy()) {
                dVar.s(7, getSy());
            }
            if (hasPrefer()) {
                dVar.s(8, getPrefer());
            }
            Iterator<String> it2 = getViaNameList().iterator();
            while (it2.hasNext()) {
                dVar.A(9, it2.next());
            }
            if (hasRoutePlanNetMode()) {
                dVar.s(10, getRoutePlanNetMode());
            }
            if (hasLocalInfoUrl()) {
                dVar.u(11, getLocalInfoUrl());
            }
            if (hasIsLongDistance()) {
                dVar.s(12, getIsLongDistance());
            }
            if (hasNaviType()) {
                dVar.s(13, getNaviType());
            }
            if (hasStartBid()) {
                dVar.A(14, getStartBid());
            }
            Iterator<String> it3 = getEndBidList().iterator();
            while (it3.hasNext()) {
                dVar.A(15, it3.next());
            }
            Iterator<FutureRouteEtaInfo> it4 = getFutureRouteetaInfoList().iterator();
            while (it4.hasNext()) {
                dVar.u(16, it4.next());
            }
            if (hasIsRcPredication()) {
                dVar.s(17, getIsRcPredication());
            }
            if (hasStrongWeakFlag()) {
                dVar.s(18, getStrongWeakFlag());
            }
        }

        public static Option parseFrom(byte[] bArr) throws e {
            return (Option) new Option().mergeFrom(bArr);
        }

        @Override // L1.f
        public Option mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                switch (iO) {
                    case 0:
                        return this;
                    case 8:
                        setAvoidJam(bVar.k());
                        break;
                    case 16:
                        setTotal(bVar.k());
                        break;
                    case 26:
                        setStartName(bVar.n());
                        break;
                    case 34:
                        setEndName(bVar.n());
                        break;
                    case 42:
                        Start start = new Start();
                        bVar.f(start);
                        setStart(start);
                        break;
                    case 50:
                        End end = new End();
                        bVar.f(end);
                        addEnd(end);
                        break;
                    case 56:
                        setSy(bVar.k());
                        break;
                    case 64:
                        setPrefer(bVar.k());
                        break;
                    case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                        addViaName(bVar.n());
                        break;
                    case 80:
                        setRoutePlanNetMode(bVar.k());
                        break;
                    case 90:
                        LocalInfoUrl localInfoUrl = new LocalInfoUrl();
                        bVar.f(localInfoUrl);
                        setLocalInfoUrl(localInfoUrl);
                        break;
                    case 96:
                        setIsLongDistance(bVar.k());
                        break;
                    case 104:
                        setNaviType(bVar.k());
                        break;
                    case 114:
                        setStartBid(bVar.n());
                        break;
                    case 122:
                        addEndBid(bVar.n());
                        break;
                    case 130:
                        FutureRouteEtaInfo futureRouteEtaInfo = new FutureRouteEtaInfo();
                        bVar.f(futureRouteEtaInfo);
                        addFutureRouteetaInfo(futureRouteEtaInfo);
                        break;
                    case SyslogConstants.LOG_LOCAL1 /* 136 */:
                        setIsRcPredication(bVar.k());
                        break;
                    case SyslogConstants.LOG_LOCAL2 /* 144 */:
                        setStrongWeakFlag(bVar.k());
                        break;
                    default:
                        if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                        break;
                }
            }
        }
    }

    public static Cars parseFrom(b bVar) throws IOException {
        return new Cars().mergeFrom(bVar);
    }

    public final Cars clear() {
        clearOption();
        clearContent();
        clearTest();
        this.cachedSize = -1;
        return this;
    }

    public Cars clearContent() {
        this.hasContent = false;
        this.content_ = null;
        return this;
    }

    public Cars clearOption() {
        this.hasOption = false;
        this.option_ = null;
        return this;
    }

    public Cars clearTest() {
        this.hasTest = false;
        this.test_ = "";
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public Content getContent() {
        return this.content_;
    }

    public Option getOption() {
        return this.option_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iH = hasOption() ? d.h(1, getOption()) : 0;
        if (hasContent()) {
            iH += d.h(2, getContent());
        }
        if (hasTest()) {
            iH += d.l(3, getTest());
        }
        this.cachedSize = iH;
        return iH;
    }

    public String getTest() {
        return this.test_;
    }

    public boolean hasContent() {
        return this.hasContent;
    }

    public boolean hasOption() {
        return this.hasOption;
    }

    public boolean hasTest() {
        return this.hasTest;
    }

    public final boolean isInitialized() {
        return !hasContent() || getContent().isInitialized();
    }

    public Cars setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.hasContent = true;
        this.content_ = content;
        return this;
    }

    public Cars setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.hasOption = true;
        this.option_ = option;
        return this;
    }

    public Cars setTest(String str) {
        this.hasTest = true;
        this.test_ = str;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasOption()) {
            dVar.u(1, getOption());
        }
        if (hasContent()) {
            dVar.u(2, getContent());
        }
        if (hasTest()) {
            dVar.A(3, getTest());
        }
    }

    public static Cars parseFrom(byte[] bArr) throws e {
        return (Cars) new Cars().mergeFrom(bArr);
    }

    @Override // L1.f
    public Cars mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                Option option = new Option();
                bVar.f(option);
                setOption(option);
            } else if (iO == 18) {
                Content content = new Content();
                bVar.f(content);
                setContent(content);
            } else if (iO == 26) {
                setTest(bVar.n());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
