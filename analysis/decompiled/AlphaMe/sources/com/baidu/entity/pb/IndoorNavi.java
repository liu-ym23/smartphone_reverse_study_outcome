package com.baidu.entity.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import com.baidu.entity.pb.PoiResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class IndoorNavi extends f {
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int ROUTES_FIELD_NUMBER = 2;
    private boolean hasOption;
    private Option option_ = null;
    private List<Routes> routes_ = Collections.emptyList();
    private int cachedSize = -1;

    public static final class Option extends f {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int TIPS_INFO_FIELD_NUMBER = 4;
        public static final int TOTAL_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 3;
        private boolean hasError;
        private boolean hasTotal;
        private boolean hasType;
        private int error_ = 0;
        private int total_ = 0;
        private int type_ = 0;
        private List<TipsInfo> tipsInfo_ = Collections.emptyList();
        private int cachedSize = -1;

        public static final class TipsInfo extends f {
            public static final int BUTTONS_FIELD_NUMBER = 2;
            public static final int TIPS_TEXT_FIELD_NUMBER = 1;
            private boolean hasTipsText;
            private String tipsText_ = "";
            private List<ButtonInfo> buttons_ = Collections.emptyList();
            private int cachedSize = -1;

            public static final class ButtonInfo extends f {
                public static final int BUTTON_LOC_FIELD_NUMBER = 1;
                public static final int BUTTON_PARAVAL_FIELD_NUMBER = 2;
                public static final int BUTTON_STATUS_FIELD_NUMBER = 4;
                public static final int BUTTON_TEXT_FIELD_NUMBER = 3;
                private boolean hasButtonLoc;
                private boolean hasButtonParaval;
                private boolean hasButtonStatus;
                private boolean hasButtonText;
                private int buttonLoc_ = 0;
                private int buttonParaval_ = 0;
                private String buttonText_ = "";
                private int buttonStatus_ = 0;
                private int cachedSize = -1;

                public static ButtonInfo parseFrom(b bVar) throws IOException {
                    return new ButtonInfo().mergeFrom(bVar);
                }

                public final ButtonInfo clear() {
                    clearButtonLoc();
                    clearButtonParaval();
                    clearButtonText();
                    clearButtonStatus();
                    this.cachedSize = -1;
                    return this;
                }

                public ButtonInfo clearButtonLoc() {
                    this.hasButtonLoc = false;
                    this.buttonLoc_ = 0;
                    return this;
                }

                public ButtonInfo clearButtonParaval() {
                    this.hasButtonParaval = false;
                    this.buttonParaval_ = 0;
                    return this;
                }

                public ButtonInfo clearButtonStatus() {
                    this.hasButtonStatus = false;
                    this.buttonStatus_ = 0;
                    return this;
                }

                public ButtonInfo clearButtonText() {
                    this.hasButtonText = false;
                    this.buttonText_ = "";
                    return this;
                }

                public int getButtonLoc() {
                    return this.buttonLoc_;
                }

                public int getButtonParaval() {
                    return this.buttonParaval_;
                }

                public int getButtonStatus() {
                    return this.buttonStatus_;
                }

                public String getButtonText() {
                    return this.buttonText_;
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
                    int iE = hasButtonLoc() ? d.e(1, getButtonLoc()) : 0;
                    if (hasButtonParaval()) {
                        iE += d.e(2, getButtonParaval());
                    }
                    if (hasButtonText()) {
                        iE += d.l(3, getButtonText());
                    }
                    if (hasButtonStatus()) {
                        iE += d.e(4, getButtonStatus());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public boolean hasButtonLoc() {
                    return this.hasButtonLoc;
                }

                public boolean hasButtonParaval() {
                    return this.hasButtonParaval;
                }

                public boolean hasButtonStatus() {
                    return this.hasButtonStatus;
                }

                public boolean hasButtonText() {
                    return this.hasButtonText;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public ButtonInfo setButtonLoc(int i4) {
                    this.hasButtonLoc = true;
                    this.buttonLoc_ = i4;
                    return this;
                }

                public ButtonInfo setButtonParaval(int i4) {
                    this.hasButtonParaval = true;
                    this.buttonParaval_ = i4;
                    return this;
                }

                public ButtonInfo setButtonStatus(int i4) {
                    this.hasButtonStatus = true;
                    this.buttonStatus_ = i4;
                    return this;
                }

                public ButtonInfo setButtonText(String str) {
                    this.hasButtonText = true;
                    this.buttonText_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasButtonLoc()) {
                        dVar.s(1, getButtonLoc());
                    }
                    if (hasButtonParaval()) {
                        dVar.s(2, getButtonParaval());
                    }
                    if (hasButtonText()) {
                        dVar.A(3, getButtonText());
                    }
                    if (hasButtonStatus()) {
                        dVar.s(4, getButtonStatus());
                    }
                }

                public static ButtonInfo parseFrom(byte[] bArr) throws e {
                    return (ButtonInfo) new ButtonInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public ButtonInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setButtonLoc(bVar.k());
                        } else if (iO == 16) {
                            setButtonParaval(bVar.k());
                        } else if (iO == 26) {
                            setButtonText(bVar.n());
                        } else if (iO == 32) {
                            setButtonStatus(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static TipsInfo parseFrom(b bVar) throws IOException {
                return new TipsInfo().mergeFrom(bVar);
            }

            public TipsInfo addButtons(ButtonInfo buttonInfo) {
                if (buttonInfo == null) {
                    return this;
                }
                if (this.buttons_.isEmpty()) {
                    this.buttons_ = new ArrayList();
                }
                this.buttons_.add(buttonInfo);
                return this;
            }

            public final TipsInfo clear() {
                clearTipsText();
                clearButtons();
                this.cachedSize = -1;
                return this;
            }

            public TipsInfo clearButtons() {
                this.buttons_ = Collections.emptyList();
                return this;
            }

            public TipsInfo clearTipsText() {
                this.hasTipsText = false;
                this.tipsText_ = "";
                return this;
            }

            public ButtonInfo getButtons(int i4) {
                return this.buttons_.get(i4);
            }

            public int getButtonsCount() {
                return this.buttons_.size();
            }

            public List<ButtonInfo> getButtonsList() {
                return this.buttons_;
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
                int iL = hasTipsText() ? d.l(1, getTipsText()) : 0;
                Iterator<ButtonInfo> it = getButtonsList().iterator();
                while (it.hasNext()) {
                    iL += d.h(2, it.next());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getTipsText() {
                return this.tipsText_;
            }

            public boolean hasTipsText() {
                return this.hasTipsText;
            }

            public final boolean isInitialized() {
                return true;
            }

            public TipsInfo setButtons(int i4, ButtonInfo buttonInfo) {
                if (buttonInfo == null) {
                    return this;
                }
                this.buttons_.set(i4, buttonInfo);
                return this;
            }

            public TipsInfo setTipsText(String str) {
                this.hasTipsText = true;
                this.tipsText_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasTipsText()) {
                    dVar.A(1, getTipsText());
                }
                Iterator<ButtonInfo> it = getButtonsList().iterator();
                while (it.hasNext()) {
                    dVar.u(2, it.next());
                }
            }

            public static TipsInfo parseFrom(byte[] bArr) throws e {
                return (TipsInfo) new TipsInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public TipsInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setTipsText(bVar.n());
                    } else if (iO == 18) {
                        ButtonInfo buttonInfo = new ButtonInfo();
                        bVar.f(buttonInfo);
                        addButtons(buttonInfo);
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static Option parseFrom(b bVar) throws IOException {
            return new Option().mergeFrom(bVar);
        }

        public Option addTipsInfo(TipsInfo tipsInfo) {
            if (tipsInfo == null) {
                return this;
            }
            if (this.tipsInfo_.isEmpty()) {
                this.tipsInfo_ = new ArrayList();
            }
            this.tipsInfo_.add(tipsInfo);
            return this;
        }

        public final Option clear() {
            clearError();
            clearTotal();
            clearType();
            clearTipsInfo();
            this.cachedSize = -1;
            return this;
        }

        public Option clearError() {
            this.hasError = false;
            this.error_ = 0;
            return this;
        }

        public Option clearTipsInfo() {
            this.tipsInfo_ = Collections.emptyList();
            return this;
        }

        public Option clearTotal() {
            this.hasTotal = false;
            this.total_ = 0;
            return this;
        }

        public Option clearType() {
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

        public int getError() {
            return this.error_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iE = hasError() ? d.e(1, getError()) : 0;
            if (hasTotal()) {
                iE += d.e(2, getTotal());
            }
            if (hasType()) {
                iE += d.e(3, getType());
            }
            Iterator<TipsInfo> it = getTipsInfoList().iterator();
            while (it.hasNext()) {
                iE += d.h(4, it.next());
            }
            this.cachedSize = iE;
            return iE;
        }

        public TipsInfo getTipsInfo(int i4) {
            return this.tipsInfo_.get(i4);
        }

        public int getTipsInfoCount() {
            return this.tipsInfo_.size();
        }

        public List<TipsInfo> getTipsInfoList() {
            return this.tipsInfo_;
        }

        public int getTotal() {
            return this.total_;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasError() {
            return this.hasError;
        }

        public boolean hasTotal() {
            return this.hasTotal;
        }

        public boolean hasType() {
            return this.hasType;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option setError(int i4) {
            this.hasError = true;
            this.error_ = i4;
            return this;
        }

        public Option setTipsInfo(int i4, TipsInfo tipsInfo) {
            if (tipsInfo == null) {
                return this;
            }
            this.tipsInfo_.set(i4, tipsInfo);
            return this;
        }

        public Option setTotal(int i4) {
            this.hasTotal = true;
            this.total_ = i4;
            return this;
        }

        public Option setType(int i4) {
            this.hasType = true;
            this.type_ = i4;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasError()) {
                dVar.s(1, getError());
            }
            if (hasTotal()) {
                dVar.s(2, getTotal());
            }
            if (hasType()) {
                dVar.s(3, getType());
            }
            Iterator<TipsInfo> it = getTipsInfoList().iterator();
            while (it.hasNext()) {
                dVar.u(4, it.next());
            }
        }

        public static Option parseFrom(byte[] bArr) throws e {
            return (Option) new Option().mergeFrom(bArr);
        }

        @Override // L1.f
        public Option mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 8) {
                    setError(bVar.k());
                } else if (iO == 16) {
                    setTotal(bVar.k());
                } else if (iO == 24) {
                    setType(bVar.k());
                } else if (iO == 34) {
                    TipsInfo tipsInfo = new TipsInfo();
                    bVar.f(tipsInfo);
                    addTipsInfo(tipsInfo);
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class Routes extends f {
        public static final int DISTANCE_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int FACILITY_TYPE_FIELD_NUMBER = 7;
        public static final int LEGS_FIELD_NUMBER = 3;
        public static final int LOC_LEVEL_FIELD_NUMBER = 4;
        public static final int MBR_LEFTDOWN_LOCATION_FIELD_NUMBER = 5;
        public static final int MBR_RIGHTUP_LOCATION_FIELD_NUMBER = 6;
        private boolean hasDistance;
        private boolean hasDuration;
        private boolean hasFacilityType;
        private boolean hasLocLevel;
        private int distance_ = 0;
        private int duration_ = 0;
        private List<Legs> legs_ = Collections.emptyList();
        private int locLevel_ = 0;
        private List<Integer> mbrLeftdownLocation_ = Collections.emptyList();
        private List<Integer> mbrRightupLocation_ = Collections.emptyList();
        private int facilityType_ = 0;
        private int cachedSize = -1;

        public static final class Legs extends f {
            public static final int DISTANCE_FIELD_NUMBER = 3;
            public static final int DURATION_FIELD_NUMBER = 4;
            public static final int SEND_LOCATION_FIELD_NUMBER = 2;
            public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
            public static final int STEPS_FIELD_NUMBER = 5;
            private boolean hasDistance;
            private boolean hasDuration;
            private List<Double> sstartLocation_ = Collections.emptyList();
            private List<Double> sendLocation_ = Collections.emptyList();
            private int distance_ = 0;
            private int duration_ = 0;
            private List<Steps> steps_ = Collections.emptyList();
            private int cachedSize = -1;

            public static final class Steps extends f {
                public static final int BUILDINGID_FIELD_NUMBER = 10;
                public static final int BUILDINGNAME_FIELD_NUMBER = 11;
                public static final int DISTANCE_FIELD_NUMBER = 3;
                public static final int DURATION_FIELD_NUMBER = 4;
                public static final int FLOORID_FIELD_NUMBER = 7;
                public static final int INDOORTURNTYPE_FIELD_NUMBER = 12;
                public static final int INSTRUCTIONS_FIELD_NUMBER = 5;
                public static final int POIS_FIELD_NUMBER = 9;
                public static final int SEND_LOCATION_FIELD_NUMBER = 2;
                public static final int SPATH_FIELD_NUMBER = 8;
                public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
                public static final int TYPE_FIELD_NUMBER = 6;
                public static final int YAW_INFO_FIELD_NUMBER = 13;
                private boolean hasBuildingid;
                private boolean hasBuildingname;
                private boolean hasDistance;
                private boolean hasDuration;
                private boolean hasFloorid;
                private boolean hasInstructions;
                private boolean hasType;
                private List<Double> sstartLocation_ = Collections.emptyList();
                private List<Double> sendLocation_ = Collections.emptyList();
                private int distance_ = 0;
                private int duration_ = 0;
                private String instructions_ = "";
                private int type_ = 0;
                private String floorid_ = "";
                private List<Double> spath_ = Collections.emptyList();
                private List<Pois> pois_ = Collections.emptyList();
                private String buildingid_ = "";
                private String buildingname_ = "";
                private List<IndoorTurnType> indoorturntype_ = Collections.emptyList();
                private List<YawInfo> yawInfo_ = Collections.emptyList();
                private int cachedSize = -1;

                public static final class IndoorTurnType extends f {
                    public static final int SPATH_INDEX_FIELD_NUMBER = 1;
                    public static final int TURN_TYPE_FIELD_NUMBER = 2;
                    private boolean hasSpathIndex;
                    private boolean hasTurnType;
                    private int spathIndex_ = 0;
                    private int turnType_ = 0;
                    private int cachedSize = -1;

                    public static IndoorTurnType parseFrom(b bVar) throws IOException {
                        return new IndoorTurnType().mergeFrom(bVar);
                    }

                    public final IndoorTurnType clear() {
                        clearSpathIndex();
                        clearTurnType();
                        this.cachedSize = -1;
                        return this;
                    }

                    public IndoorTurnType clearSpathIndex() {
                        this.hasSpathIndex = false;
                        this.spathIndex_ = 0;
                        return this;
                    }

                    public IndoorTurnType clearTurnType() {
                        this.hasTurnType = false;
                        this.turnType_ = 0;
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
                        int iE = hasSpathIndex() ? d.e(1, getSpathIndex()) : 0;
                        if (hasTurnType()) {
                            iE += d.e(2, getTurnType());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public int getSpathIndex() {
                        return this.spathIndex_;
                    }

                    public int getTurnType() {
                        return this.turnType_;
                    }

                    public boolean hasSpathIndex() {
                        return this.hasSpathIndex;
                    }

                    public boolean hasTurnType() {
                        return this.hasTurnType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public IndoorTurnType setSpathIndex(int i4) {
                        this.hasSpathIndex = true;
                        this.spathIndex_ = i4;
                        return this;
                    }

                    public IndoorTurnType setTurnType(int i4) {
                        this.hasTurnType = true;
                        this.turnType_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasSpathIndex()) {
                            dVar.s(1, getSpathIndex());
                        }
                        if (hasTurnType()) {
                            dVar.s(2, getTurnType());
                        }
                    }

                    public static IndoorTurnType parseFrom(byte[] bArr) throws e {
                        return (IndoorTurnType) new IndoorTurnType().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public IndoorTurnType mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setSpathIndex(bVar.k());
                            } else if (iO == 16) {
                                setTurnType(bVar.k());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class Pois extends f {
                    public static final int BID_FIELD_NUMBER = 5;
                    public static final int CONNDIS_FROM_S_FIELD_NUMBER = 8;
                    public static final int DETAIL_FIELD_NUMBER = 4;
                    public static final int INDEX_CONN_POI_FIELD_NUMBER = 7;
                    public static final int LOCATION_FIELD_NUMBER = 3;
                    public static final int NAME_FIELD_NUMBER = 1;
                    public static final int STYLEID_FIELD_NUMBER = 6;
                    public static final int TYPE_FIELD_NUMBER = 2;
                    private boolean hasBid;
                    private boolean hasConndisFromS;
                    private boolean hasDetail;
                    private boolean hasIndexConnPoi;
                    private boolean hasName;
                    private boolean hasStyleid;
                    private boolean hasType;
                    private String name_ = "";
                    private int type_ = 0;
                    private List<Double> location_ = Collections.emptyList();
                    private String detail_ = "";
                    private String bid_ = "";
                    private String styleid_ = "";
                    private int indexConnPoi_ = 0;
                    private int conndisFromS_ = 0;
                    private int cachedSize = -1;

                    public static Pois parseFrom(b bVar) throws IOException {
                        return new Pois().mergeFrom(bVar);
                    }

                    public Pois addLocation(double d4) {
                        if (this.location_.isEmpty()) {
                            this.location_ = new ArrayList();
                        }
                        this.location_.add(Double.valueOf(d4));
                        return this;
                    }

                    public final Pois clear() {
                        clearName();
                        clearType();
                        clearLocation();
                        clearDetail();
                        clearBid();
                        clearStyleid();
                        clearIndexConnPoi();
                        clearConndisFromS();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Pois clearBid() {
                        this.hasBid = false;
                        this.bid_ = "";
                        return this;
                    }

                    public Pois clearConndisFromS() {
                        this.hasConndisFromS = false;
                        this.conndisFromS_ = 0;
                        return this;
                    }

                    public Pois clearDetail() {
                        this.hasDetail = false;
                        this.detail_ = "";
                        return this;
                    }

                    public Pois clearIndexConnPoi() {
                        this.hasIndexConnPoi = false;
                        this.indexConnPoi_ = 0;
                        return this;
                    }

                    public Pois clearLocation() {
                        this.location_ = Collections.emptyList();
                        return this;
                    }

                    public Pois clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    public Pois clearStyleid() {
                        this.hasStyleid = false;
                        this.styleid_ = "";
                        return this;
                    }

                    public Pois clearType() {
                        this.hasType = false;
                        this.type_ = 0;
                        return this;
                    }

                    public String getBid() {
                        return this.bid_;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getConndisFromS() {
                        return this.conndisFromS_;
                    }

                    public String getDetail() {
                        return this.detail_;
                    }

                    public int getIndexConnPoi() {
                        return this.indexConnPoi_;
                    }

                    public double getLocation(int i4) {
                        return this.location_.get(i4).doubleValue();
                    }

                    public int getLocationCount() {
                        return this.location_.size();
                    }

                    public List<Double> getLocationList() {
                        return this.location_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasName() ? d.l(1, getName()) : 0;
                        if (hasType()) {
                            iL += d.e(2, getType());
                        }
                        int size = getLocationList().size() + (getLocationList().size() * 8) + iL;
                        if (hasDetail()) {
                            size += d.l(4, getDetail());
                        }
                        if (hasBid()) {
                            size += d.l(5, getBid());
                        }
                        if (hasStyleid()) {
                            size += d.l(6, getStyleid());
                        }
                        if (hasIndexConnPoi()) {
                            size += d.e(7, getIndexConnPoi());
                        }
                        if (hasConndisFromS()) {
                            size += d.e(8, getConndisFromS());
                        }
                        this.cachedSize = size;
                        return size;
                    }

                    public String getStyleid() {
                        return this.styleid_;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasBid() {
                        return this.hasBid;
                    }

                    public boolean hasConndisFromS() {
                        return this.hasConndisFromS;
                    }

                    public boolean hasDetail() {
                        return this.hasDetail;
                    }

                    public boolean hasIndexConnPoi() {
                        return this.hasIndexConnPoi;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public boolean hasStyleid() {
                        return this.hasStyleid;
                    }

                    public boolean hasType() {
                        return this.hasType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Pois setBid(String str) {
                        this.hasBid = true;
                        this.bid_ = str;
                        return this;
                    }

                    public Pois setConndisFromS(int i4) {
                        this.hasConndisFromS = true;
                        this.conndisFromS_ = i4;
                        return this;
                    }

                    public Pois setDetail(String str) {
                        this.hasDetail = true;
                        this.detail_ = str;
                        return this;
                    }

                    public Pois setIndexConnPoi(int i4) {
                        this.hasIndexConnPoi = true;
                        this.indexConnPoi_ = i4;
                        return this;
                    }

                    public Pois setLocation(int i4, double d4) {
                        this.location_.set(i4, Double.valueOf(d4));
                        return this;
                    }

                    public Pois setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    public Pois setStyleid(String str) {
                        this.hasStyleid = true;
                        this.styleid_ = str;
                        return this;
                    }

                    public Pois setType(int i4) {
                        this.hasType = true;
                        this.type_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasName()) {
                            dVar.A(1, getName());
                        }
                        if (hasType()) {
                            dVar.s(2, getType());
                        }
                        Iterator<Double> it = getLocationList().iterator();
                        while (it.hasNext()) {
                            dVar.r(3, it.next().doubleValue());
                        }
                        if (hasDetail()) {
                            dVar.A(4, getDetail());
                        }
                        if (hasBid()) {
                            dVar.A(5, getBid());
                        }
                        if (hasStyleid()) {
                            dVar.A(6, getStyleid());
                        }
                        if (hasIndexConnPoi()) {
                            dVar.s(7, getIndexConnPoi());
                        }
                        if (hasConndisFromS()) {
                            dVar.s(8, getConndisFromS());
                        }
                    }

                    public static Pois parseFrom(byte[] bArr) throws e {
                        return (Pois) new Pois().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Pois mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setName(bVar.n());
                            } else if (iO == 16) {
                                setType(bVar.k());
                            } else if (iO == 25) {
                                addLocation(bVar.c());
                            } else if (iO == 34) {
                                setDetail(bVar.n());
                            } else if (iO == 42) {
                                setBid(bVar.n());
                            } else if (iO == 50) {
                                setStyleid(bVar.n());
                            } else if (iO == 56) {
                                setIndexConnPoi(bVar.k());
                            } else if (iO == 64) {
                                setConndisFromS(bVar.k());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class YawInfo extends f {
                    public static final int END_SPATH_INDEX_FIELD_NUMBER = 2;
                    public static final int START_SPATH_INDEX_FIELD_NUMBER = 1;
                    public static final int YAW_THRESHOLD_FIELD_NUMBER = 3;
                    private boolean hasEndSpathIndex;
                    private boolean hasStartSpathIndex;
                    private boolean hasYawThreshold;
                    private int startSpathIndex_ = 0;
                    private int endSpathIndex_ = 0;
                    private int yawThreshold_ = 0;
                    private int cachedSize = -1;

                    public static YawInfo parseFrom(b bVar) throws IOException {
                        return new YawInfo().mergeFrom(bVar);
                    }

                    public final YawInfo clear() {
                        clearStartSpathIndex();
                        clearEndSpathIndex();
                        clearYawThreshold();
                        this.cachedSize = -1;
                        return this;
                    }

                    public YawInfo clearEndSpathIndex() {
                        this.hasEndSpathIndex = false;
                        this.endSpathIndex_ = 0;
                        return this;
                    }

                    public YawInfo clearStartSpathIndex() {
                        this.hasStartSpathIndex = false;
                        this.startSpathIndex_ = 0;
                        return this;
                    }

                    public YawInfo clearYawThreshold() {
                        this.hasYawThreshold = false;
                        this.yawThreshold_ = 0;
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getEndSpathIndex() {
                        return this.endSpathIndex_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasStartSpathIndex() ? d.e(1, getStartSpathIndex()) : 0;
                        if (hasEndSpathIndex()) {
                            iE += d.e(2, getEndSpathIndex());
                        }
                        if (hasYawThreshold()) {
                            iE += d.e(3, getYawThreshold());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public int getStartSpathIndex() {
                        return this.startSpathIndex_;
                    }

                    public int getYawThreshold() {
                        return this.yawThreshold_;
                    }

                    public boolean hasEndSpathIndex() {
                        return this.hasEndSpathIndex;
                    }

                    public boolean hasStartSpathIndex() {
                        return this.hasStartSpathIndex;
                    }

                    public boolean hasYawThreshold() {
                        return this.hasYawThreshold;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public YawInfo setEndSpathIndex(int i4) {
                        this.hasEndSpathIndex = true;
                        this.endSpathIndex_ = i4;
                        return this;
                    }

                    public YawInfo setStartSpathIndex(int i4) {
                        this.hasStartSpathIndex = true;
                        this.startSpathIndex_ = i4;
                        return this;
                    }

                    public YawInfo setYawThreshold(int i4) {
                        this.hasYawThreshold = true;
                        this.yawThreshold_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasStartSpathIndex()) {
                            dVar.s(1, getStartSpathIndex());
                        }
                        if (hasEndSpathIndex()) {
                            dVar.s(2, getEndSpathIndex());
                        }
                        if (hasYawThreshold()) {
                            dVar.s(3, getYawThreshold());
                        }
                    }

                    public static YawInfo parseFrom(byte[] bArr) throws e {
                        return (YawInfo) new YawInfo().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public YawInfo mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setStartSpathIndex(bVar.k());
                            } else if (iO == 16) {
                                setEndSpathIndex(bVar.k());
                            } else if (iO == 24) {
                                setYawThreshold(bVar.k());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static Steps parseFrom(b bVar) throws IOException {
                    return new Steps().mergeFrom(bVar);
                }

                public Steps addIndoorturntype(IndoorTurnType indoorTurnType) {
                    if (indoorTurnType == null) {
                        return this;
                    }
                    if (this.indoorturntype_.isEmpty()) {
                        this.indoorturntype_ = new ArrayList();
                    }
                    this.indoorturntype_.add(indoorTurnType);
                    return this;
                }

                public Steps addPois(Pois pois) {
                    if (pois == null) {
                        return this;
                    }
                    if (this.pois_.isEmpty()) {
                        this.pois_ = new ArrayList();
                    }
                    this.pois_.add(pois);
                    return this;
                }

                public Steps addSendLocation(double d4) {
                    if (this.sendLocation_.isEmpty()) {
                        this.sendLocation_ = new ArrayList();
                    }
                    this.sendLocation_.add(Double.valueOf(d4));
                    return this;
                }

                public Steps addSpath(double d4) {
                    if (this.spath_.isEmpty()) {
                        this.spath_ = new ArrayList();
                    }
                    this.spath_.add(Double.valueOf(d4));
                    return this;
                }

                public Steps addSstartLocation(double d4) {
                    if (this.sstartLocation_.isEmpty()) {
                        this.sstartLocation_ = new ArrayList();
                    }
                    this.sstartLocation_.add(Double.valueOf(d4));
                    return this;
                }

                public Steps addYawInfo(YawInfo yawInfo) {
                    if (yawInfo == null) {
                        return this;
                    }
                    if (this.yawInfo_.isEmpty()) {
                        this.yawInfo_ = new ArrayList();
                    }
                    this.yawInfo_.add(yawInfo);
                    return this;
                }

                public final Steps clear() {
                    clearSstartLocation();
                    clearSendLocation();
                    clearDistance();
                    clearDuration();
                    clearInstructions();
                    clearType();
                    clearFloorid();
                    clearSpath();
                    clearPois();
                    clearBuildingid();
                    clearBuildingname();
                    clearIndoorturntype();
                    clearYawInfo();
                    this.cachedSize = -1;
                    return this;
                }

                public Steps clearBuildingid() {
                    this.hasBuildingid = false;
                    this.buildingid_ = "";
                    return this;
                }

                public Steps clearBuildingname() {
                    this.hasBuildingname = false;
                    this.buildingname_ = "";
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

                public Steps clearFloorid() {
                    this.hasFloorid = false;
                    this.floorid_ = "";
                    return this;
                }

                public Steps clearIndoorturntype() {
                    this.indoorturntype_ = Collections.emptyList();
                    return this;
                }

                public Steps clearInstructions() {
                    this.hasInstructions = false;
                    this.instructions_ = "";
                    return this;
                }

                public Steps clearPois() {
                    this.pois_ = Collections.emptyList();
                    return this;
                }

                public Steps clearSendLocation() {
                    this.sendLocation_ = Collections.emptyList();
                    return this;
                }

                public Steps clearSpath() {
                    this.spath_ = Collections.emptyList();
                    return this;
                }

                public Steps clearSstartLocation() {
                    this.sstartLocation_ = Collections.emptyList();
                    return this;
                }

                public Steps clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                public Steps clearYawInfo() {
                    this.yawInfo_ = Collections.emptyList();
                    return this;
                }

                public String getBuildingid() {
                    return this.buildingid_;
                }

                public String getBuildingname() {
                    return this.buildingname_;
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

                public String getFloorid() {
                    return this.floorid_;
                }

                public IndoorTurnType getIndoorturntype(int i4) {
                    return this.indoorturntype_.get(i4);
                }

                public int getIndoorturntypeCount() {
                    return this.indoorturntype_.size();
                }

                public List<IndoorTurnType> getIndoorturntypeList() {
                    return this.indoorturntype_;
                }

                public String getInstructions() {
                    return this.instructions_;
                }

                public Pois getPois(int i4) {
                    return this.pois_.get(i4);
                }

                public int getPoisCount() {
                    return this.pois_.size();
                }

                public List<Pois> getPoisList() {
                    return this.pois_;
                }

                public double getSendLocation(int i4) {
                    return this.sendLocation_.get(i4).doubleValue();
                }

                public int getSendLocationCount() {
                    return this.sendLocation_.size();
                }

                public List<Double> getSendLocationList() {
                    return this.sendLocation_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int size = getSendLocationList().size() + (getSendLocationList().size() * 8) + getSstartLocationList().size() + (getSstartLocationList().size() * 8);
                    if (hasDistance()) {
                        size += d.e(3, getDistance());
                    }
                    if (hasDuration()) {
                        size += d.e(4, getDuration());
                    }
                    if (hasInstructions()) {
                        size += d.l(5, getInstructions());
                    }
                    if (hasType()) {
                        size += d.e(6, getType());
                    }
                    if (hasFloorid()) {
                        size += d.l(7, getFloorid());
                    }
                    int size2 = getSpathList().size() + (getSpathList().size() * 8) + size;
                    Iterator<Pois> it = getPoisList().iterator();
                    while (it.hasNext()) {
                        size2 += d.h(9, it.next());
                    }
                    if (hasBuildingid()) {
                        size2 += d.l(10, getBuildingid());
                    }
                    if (hasBuildingname()) {
                        size2 += d.l(11, getBuildingname());
                    }
                    Iterator<IndoorTurnType> it2 = getIndoorturntypeList().iterator();
                    while (it2.hasNext()) {
                        size2 += d.h(12, it2.next());
                    }
                    Iterator<YawInfo> it3 = getYawInfoList().iterator();
                    while (it3.hasNext()) {
                        size2 += d.h(13, it3.next());
                    }
                    this.cachedSize = size2;
                    return size2;
                }

                public double getSpath(int i4) {
                    return this.spath_.get(i4).doubleValue();
                }

                public int getSpathCount() {
                    return this.spath_.size();
                }

                public List<Double> getSpathList() {
                    return this.spath_;
                }

                public double getSstartLocation(int i4) {
                    return this.sstartLocation_.get(i4).doubleValue();
                }

                public int getSstartLocationCount() {
                    return this.sstartLocation_.size();
                }

                public List<Double> getSstartLocationList() {
                    return this.sstartLocation_;
                }

                public int getType() {
                    return this.type_;
                }

                public YawInfo getYawInfo(int i4) {
                    return this.yawInfo_.get(i4);
                }

                public int getYawInfoCount() {
                    return this.yawInfo_.size();
                }

                public List<YawInfo> getYawInfoList() {
                    return this.yawInfo_;
                }

                public boolean hasBuildingid() {
                    return this.hasBuildingid;
                }

                public boolean hasBuildingname() {
                    return this.hasBuildingname;
                }

                public boolean hasDistance() {
                    return this.hasDistance;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasFloorid() {
                    return this.hasFloorid;
                }

                public boolean hasInstructions() {
                    return this.hasInstructions;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Steps setBuildingid(String str) {
                    this.hasBuildingid = true;
                    this.buildingid_ = str;
                    return this;
                }

                public Steps setBuildingname(String str) {
                    this.hasBuildingname = true;
                    this.buildingname_ = str;
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

                public Steps setFloorid(String str) {
                    this.hasFloorid = true;
                    this.floorid_ = str;
                    return this;
                }

                public Steps setIndoorturntype(int i4, IndoorTurnType indoorTurnType) {
                    if (indoorTurnType == null) {
                        return this;
                    }
                    this.indoorturntype_.set(i4, indoorTurnType);
                    return this;
                }

                public Steps setInstructions(String str) {
                    this.hasInstructions = true;
                    this.instructions_ = str;
                    return this;
                }

                public Steps setPois(int i4, Pois pois) {
                    if (pois == null) {
                        return this;
                    }
                    this.pois_.set(i4, pois);
                    return this;
                }

                public Steps setSendLocation(int i4, double d4) {
                    this.sendLocation_.set(i4, Double.valueOf(d4));
                    return this;
                }

                public Steps setSpath(int i4, double d4) {
                    this.spath_.set(i4, Double.valueOf(d4));
                    return this;
                }

                public Steps setSstartLocation(int i4, double d4) {
                    this.sstartLocation_.set(i4, Double.valueOf(d4));
                    return this;
                }

                public Steps setType(int i4) {
                    this.hasType = true;
                    this.type_ = i4;
                    return this;
                }

                public Steps setYawInfo(int i4, YawInfo yawInfo) {
                    if (yawInfo == null) {
                        return this;
                    }
                    this.yawInfo_.set(i4, yawInfo);
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    Iterator<Double> it = getSstartLocationList().iterator();
                    while (it.hasNext()) {
                        dVar.r(1, it.next().doubleValue());
                    }
                    Iterator<Double> it2 = getSendLocationList().iterator();
                    while (it2.hasNext()) {
                        dVar.r(2, it2.next().doubleValue());
                    }
                    if (hasDistance()) {
                        dVar.s(3, getDistance());
                    }
                    if (hasDuration()) {
                        dVar.s(4, getDuration());
                    }
                    if (hasInstructions()) {
                        dVar.A(5, getInstructions());
                    }
                    if (hasType()) {
                        dVar.s(6, getType());
                    }
                    if (hasFloorid()) {
                        dVar.A(7, getFloorid());
                    }
                    Iterator<Double> it3 = getSpathList().iterator();
                    while (it3.hasNext()) {
                        dVar.r(8, it3.next().doubleValue());
                    }
                    Iterator<Pois> it4 = getPoisList().iterator();
                    while (it4.hasNext()) {
                        dVar.u(9, it4.next());
                    }
                    if (hasBuildingid()) {
                        dVar.A(10, getBuildingid());
                    }
                    if (hasBuildingname()) {
                        dVar.A(11, getBuildingname());
                    }
                    Iterator<IndoorTurnType> it5 = getIndoorturntypeList().iterator();
                    while (it5.hasNext()) {
                        dVar.u(12, it5.next());
                    }
                    Iterator<YawInfo> it6 = getYawInfoList().iterator();
                    while (it6.hasNext()) {
                        dVar.u(13, it6.next());
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
                            case 9:
                                addSstartLocation(bVar.c());
                                break;
                            case 17:
                                addSendLocation(bVar.c());
                                break;
                            case 24:
                                setDistance(bVar.k());
                                break;
                            case 32:
                                setDuration(bVar.k());
                                break;
                            case 42:
                                setInstructions(bVar.n());
                                break;
                            case 48:
                                setType(bVar.k());
                                break;
                            case 58:
                                setFloorid(bVar.n());
                                break;
                            case 65:
                                addSpath(bVar.c());
                                break;
                            case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                                Pois pois = new Pois();
                                bVar.f(pois);
                                addPois(pois);
                                break;
                            case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                                setBuildingid(bVar.n());
                                break;
                            case 90:
                                setBuildingname(bVar.n());
                                break;
                            case 98:
                                IndoorTurnType indoorTurnType = new IndoorTurnType();
                                bVar.f(indoorTurnType);
                                addIndoorturntype(indoorTurnType);
                                break;
                            case 106:
                                YawInfo yawInfo = new YawInfo();
                                bVar.f(yawInfo);
                                addYawInfo(yawInfo);
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

            public static Legs parseFrom(b bVar) throws IOException {
                return new Legs().mergeFrom(bVar);
            }

            public Legs addSendLocation(double d4) {
                if (this.sendLocation_.isEmpty()) {
                    this.sendLocation_ = new ArrayList();
                }
                this.sendLocation_.add(Double.valueOf(d4));
                return this;
            }

            public Legs addSstartLocation(double d4) {
                if (this.sstartLocation_.isEmpty()) {
                    this.sstartLocation_ = new ArrayList();
                }
                this.sstartLocation_.add(Double.valueOf(d4));
                return this;
            }

            public Legs addSteps(Steps steps) {
                if (steps == null) {
                    return this;
                }
                if (this.steps_.isEmpty()) {
                    this.steps_ = new ArrayList();
                }
                this.steps_.add(steps);
                return this;
            }

            public final Legs clear() {
                clearSstartLocation();
                clearSendLocation();
                clearDistance();
                clearDuration();
                clearSteps();
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

            public Legs clearSendLocation() {
                this.sendLocation_ = Collections.emptyList();
                return this;
            }

            public Legs clearSstartLocation() {
                this.sstartLocation_ = Collections.emptyList();
                return this;
            }

            public Legs clearSteps() {
                this.steps_ = Collections.emptyList();
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

            public double getSendLocation(int i4) {
                return this.sendLocation_.get(i4).doubleValue();
            }

            public int getSendLocationCount() {
                return this.sendLocation_.size();
            }

            public List<Double> getSendLocationList() {
                return this.sendLocation_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int size = getSendLocationList().size() + (getSendLocationList().size() * 8) + getSstartLocationList().size() + (getSstartLocationList().size() * 8);
                if (hasDistance()) {
                    size += d.e(3, getDistance());
                }
                if (hasDuration()) {
                    size += d.e(4, getDuration());
                }
                Iterator<Steps> it = getStepsList().iterator();
                while (it.hasNext()) {
                    size += d.h(5, it.next());
                }
                this.cachedSize = size;
                return size;
            }

            public double getSstartLocation(int i4) {
                return this.sstartLocation_.get(i4).doubleValue();
            }

            public int getSstartLocationCount() {
                return this.sstartLocation_.size();
            }

            public List<Double> getSstartLocationList() {
                return this.sstartLocation_;
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

            public boolean hasDistance() {
                return this.hasDistance;
            }

            public boolean hasDuration() {
                return this.hasDuration;
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

            public Legs setSendLocation(int i4, double d4) {
                this.sendLocation_.set(i4, Double.valueOf(d4));
                return this;
            }

            public Legs setSstartLocation(int i4, double d4) {
                this.sstartLocation_.set(i4, Double.valueOf(d4));
                return this;
            }

            public Legs setSteps(int i4, Steps steps) {
                if (steps == null) {
                    return this;
                }
                this.steps_.set(i4, steps);
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                Iterator<Double> it = getSstartLocationList().iterator();
                while (it.hasNext()) {
                    dVar.r(1, it.next().doubleValue());
                }
                Iterator<Double> it2 = getSendLocationList().iterator();
                while (it2.hasNext()) {
                    dVar.r(2, it2.next().doubleValue());
                }
                if (hasDistance()) {
                    dVar.s(3, getDistance());
                }
                if (hasDuration()) {
                    dVar.s(4, getDuration());
                }
                Iterator<Steps> it3 = getStepsList().iterator();
                while (it3.hasNext()) {
                    dVar.u(5, it3.next());
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
                    if (iO == 9) {
                        addSstartLocation(bVar.c());
                    } else if (iO == 17) {
                        addSendLocation(bVar.c());
                    } else if (iO == 24) {
                        setDistance(bVar.k());
                    } else if (iO == 32) {
                        setDuration(bVar.k());
                    } else if (iO == 42) {
                        Steps steps = new Steps();
                        bVar.f(steps);
                        addSteps(steps);
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static Routes parseFrom(b bVar) throws IOException {
            return new Routes().mergeFrom(bVar);
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

        public Routes addMbrLeftdownLocation(int i4) {
            if (this.mbrLeftdownLocation_.isEmpty()) {
                this.mbrLeftdownLocation_ = new ArrayList();
            }
            this.mbrLeftdownLocation_.add(Integer.valueOf(i4));
            return this;
        }

        public Routes addMbrRightupLocation(int i4) {
            if (this.mbrRightupLocation_.isEmpty()) {
                this.mbrRightupLocation_ = new ArrayList();
            }
            this.mbrRightupLocation_.add(Integer.valueOf(i4));
            return this;
        }

        public final Routes clear() {
            clearDistance();
            clearDuration();
            clearLegs();
            clearLocLevel();
            clearMbrLeftdownLocation();
            clearMbrRightupLocation();
            clearFacilityType();
            this.cachedSize = -1;
            return this;
        }

        public Routes clearDistance() {
            this.hasDistance = false;
            this.distance_ = 0;
            return this;
        }

        public Routes clearDuration() {
            this.hasDuration = false;
            this.duration_ = 0;
            return this;
        }

        public Routes clearFacilityType() {
            this.hasFacilityType = false;
            this.facilityType_ = 0;
            return this;
        }

        public Routes clearLegs() {
            this.legs_ = Collections.emptyList();
            return this;
        }

        public Routes clearLocLevel() {
            this.hasLocLevel = false;
            this.locLevel_ = 0;
            return this;
        }

        public Routes clearMbrLeftdownLocation() {
            this.mbrLeftdownLocation_ = Collections.emptyList();
            return this;
        }

        public Routes clearMbrRightupLocation() {
            this.mbrRightupLocation_ = Collections.emptyList();
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

        public int getFacilityType() {
            return this.facilityType_;
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

        public int getLocLevel() {
            return this.locLevel_;
        }

        public int getMbrLeftdownLocation(int i4) {
            return this.mbrLeftdownLocation_.get(i4).intValue();
        }

        public int getMbrLeftdownLocationCount() {
            return this.mbrLeftdownLocation_.size();
        }

        public List<Integer> getMbrLeftdownLocationList() {
            return this.mbrLeftdownLocation_;
        }

        public int getMbrRightupLocation(int i4) {
            return this.mbrRightupLocation_.get(i4).intValue();
        }

        public int getMbrRightupLocationCount() {
            return this.mbrRightupLocation_.size();
        }

        public List<Integer> getMbrRightupLocationList() {
            return this.mbrRightupLocation_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iF = 0;
            int iE = hasDistance() ? d.e(1, getDistance()) : 0;
            if (hasDuration()) {
                iE += d.e(2, getDuration());
            }
            Iterator<Legs> it = getLegsList().iterator();
            while (it.hasNext()) {
                iE += d.h(3, it.next());
            }
            if (hasLocLevel()) {
                iE += d.e(4, getLocLevel());
            }
            Iterator<Integer> it2 = getMbrLeftdownLocationList().iterator();
            int iF2 = 0;
            while (it2.hasNext()) {
                iF2 += d.f(it2.next().intValue());
            }
            int size = getMbrLeftdownLocationList().size() + iE + iF2;
            Iterator<Integer> it3 = getMbrRightupLocationList().iterator();
            while (it3.hasNext()) {
                iF += d.f(it3.next().intValue());
            }
            int size2 = getMbrRightupLocationList().size() + size + iF;
            if (hasFacilityType()) {
                size2 += d.e(7, getFacilityType());
            }
            this.cachedSize = size2;
            return size2;
        }

        public boolean hasDistance() {
            return this.hasDistance;
        }

        public boolean hasDuration() {
            return this.hasDuration;
        }

        public boolean hasFacilityType() {
            return this.hasFacilityType;
        }

        public boolean hasLocLevel() {
            return this.hasLocLevel;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Routes setDistance(int i4) {
            this.hasDistance = true;
            this.distance_ = i4;
            return this;
        }

        public Routes setDuration(int i4) {
            this.hasDuration = true;
            this.duration_ = i4;
            return this;
        }

        public Routes setFacilityType(int i4) {
            this.hasFacilityType = true;
            this.facilityType_ = i4;
            return this;
        }

        public Routes setLegs(int i4, Legs legs) {
            if (legs == null) {
                return this;
            }
            this.legs_.set(i4, legs);
            return this;
        }

        public Routes setLocLevel(int i4) {
            this.hasLocLevel = true;
            this.locLevel_ = i4;
            return this;
        }

        public Routes setMbrLeftdownLocation(int i4, int i5) {
            this.mbrLeftdownLocation_.set(i4, Integer.valueOf(i5));
            return this;
        }

        public Routes setMbrRightupLocation(int i4, int i5) {
            this.mbrRightupLocation_.set(i4, Integer.valueOf(i5));
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
            Iterator<Legs> it = getLegsList().iterator();
            while (it.hasNext()) {
                dVar.u(3, it.next());
            }
            if (hasLocLevel()) {
                dVar.s(4, getLocLevel());
            }
            Iterator<Integer> it2 = getMbrLeftdownLocationList().iterator();
            while (it2.hasNext()) {
                dVar.s(5, it2.next().intValue());
            }
            Iterator<Integer> it3 = getMbrRightupLocationList().iterator();
            while (it3.hasNext()) {
                dVar.s(6, it3.next().intValue());
            }
            if (hasFacilityType()) {
                dVar.s(7, getFacilityType());
            }
        }

        public static Routes parseFrom(byte[] bArr) throws e {
            return (Routes) new Routes().mergeFrom(bArr);
        }

        @Override // L1.f
        public Routes mergeFrom(b bVar) throws IOException {
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
                    Legs legs = new Legs();
                    bVar.f(legs);
                    addLegs(legs);
                } else if (iO == 32) {
                    setLocLevel(bVar.k());
                } else if (iO == 40) {
                    addMbrLeftdownLocation(bVar.k());
                } else if (iO == 48) {
                    addMbrRightupLocation(bVar.k());
                } else if (iO == 56) {
                    setFacilityType(bVar.k());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static IndoorNavi parseFrom(b bVar) throws IOException {
        return new IndoorNavi().mergeFrom(bVar);
    }

    public IndoorNavi addRoutes(Routes routes) {
        if (routes == null) {
            return this;
        }
        if (this.routes_.isEmpty()) {
            this.routes_ = new ArrayList();
        }
        this.routes_.add(routes);
        return this;
    }

    public final IndoorNavi clear() {
        clearOption();
        clearRoutes();
        this.cachedSize = -1;
        return this;
    }

    public IndoorNavi clearOption() {
        this.hasOption = false;
        this.option_ = null;
        return this;
    }

    public IndoorNavi clearRoutes() {
        this.routes_ = Collections.emptyList();
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public Option getOption() {
        return this.option_;
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
        int iH = hasOption() ? d.h(1, getOption()) : 0;
        Iterator<Routes> it = getRoutesList().iterator();
        while (it.hasNext()) {
            iH += d.h(2, it.next());
        }
        this.cachedSize = iH;
        return iH;
    }

    public boolean hasOption() {
        return this.hasOption;
    }

    public final boolean isInitialized() {
        return true;
    }

    public IndoorNavi setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.hasOption = true;
        this.option_ = option;
        return this;
    }

    public IndoorNavi setRoutes(int i4, Routes routes) {
        if (routes == null) {
            return this;
        }
        this.routes_.set(i4, routes);
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasOption()) {
            dVar.u(1, getOption());
        }
        Iterator<Routes> it = getRoutesList().iterator();
        while (it.hasNext()) {
            dVar.u(2, it.next());
        }
    }

    public static IndoorNavi parseFrom(byte[] bArr) throws e {
        return (IndoorNavi) new IndoorNavi().mergeFrom(bArr);
    }

    @Override // L1.f
    public IndoorNavi mergeFrom(b bVar) throws IOException {
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
                Routes routes = new Routes();
                bVar.f(routes);
                addRoutes(routes);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
