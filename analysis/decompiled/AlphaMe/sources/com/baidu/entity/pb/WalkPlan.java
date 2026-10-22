package com.baidu.entity.pb;

import B0.g;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import ch.qos.logback.core.net.SyslogConstants;
import com.baidu.entity.pb.PoiResult;
import com.baidu.platform.comapi.license.LicenseCode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class WalkPlan extends f {
    public static final int APPEND_ROUTEINF_LIST_FIELD_NUMBER = 8;
    public static final int AR_GUIDE_FIELD_NUMBER = 7;
    public static final int CURRENT_CITY_FIELD_NUMBER = 4;
    public static final int INDOOR_NAVIS_FIELD_NUMBER = 5;
    public static final int OPTION_FIELD_NUMBER = 3;
    public static final int ROUTES_FIELD_NUMBER = 1;
    public static final int SESSION_FIELD_NUMBER = 9;
    public static final int TAXI_FIELD_NUMBER = 2;
    public static final int VEHICLE_FIELD_NUMBER = 10;
    public static final int YAW_STATUS_FIELD_NUMBER = 6;
    private boolean hasAppendRouteinfList;
    private boolean hasCurrentCity;
    private boolean hasOption;
    private boolean hasSession;
    private boolean hasTaxi;
    private boolean hasVehicle;
    private boolean hasYawStatus;
    private Taxi taxi_ = null;
    private List<Routes> routes_ = Collections.emptyList();
    private Option option_ = null;
    private CurrentCity currentCity_ = null;
    private List<IndoorNavi> indoorNavis_ = Collections.emptyList();
    private int yawStatus_ = 0;
    private List<ARGuide> arGuide_ = Collections.emptyList();
    private AppendRouteInf appendRouteinfList_ = null;
    private Session session_ = null;
    private int vehicle_ = 0;
    private int cachedSize = -1;

    public static final class ARGuide extends f {
        public static final int GUIDE_V1_FIELD_NUMBER = 4;
        public static final int LEG_IDX_FIELD_NUMBER = 3;
        public static final int ROUTE_IDX_FIELD_NUMBER = 2;
        public static final int VERSION_FIELD_NUMBER = 1;
        private boolean hasGuideV1;
        private boolean hasLegIdx;
        private boolean hasRouteIdx;
        private boolean hasVersion;
        private int version_ = 0;
        private int routeIdx_ = 0;
        private int legIdx_ = 0;
        private GuideV1 guideV1_ = null;
        private int cachedSize = -1;

        public static final class GuideV1 extends f {
            public static final int BASE_INFO_FIELD_NUMBER = 1;
            private List<BaseInfo> baseInfo_ = Collections.emptyList();
            private int cachedSize = -1;

            public static final class BaseInfo extends f {
                public static final int MODEL_TYPE_FIELD_NUMBER = 1;
                public static final int SP_IDX_FIELD_NUMBER = 3;
                public static final int STEP_IDX_FIELD_NUMBER = 2;
                private boolean hasModelType;
                private boolean hasSpIdx;
                private boolean hasStepIdx;
                private int modelType_ = 0;
                private int stepIdx_ = 0;
                private int spIdx_ = 0;
                private int cachedSize = -1;

                public static BaseInfo parseFrom(b bVar) throws IOException {
                    return new BaseInfo().mergeFrom(bVar);
                }

                public final BaseInfo clear() {
                    clearModelType();
                    clearStepIdx();
                    clearSpIdx();
                    this.cachedSize = -1;
                    return this;
                }

                public BaseInfo clearModelType() {
                    this.hasModelType = false;
                    this.modelType_ = 0;
                    return this;
                }

                public BaseInfo clearSpIdx() {
                    this.hasSpIdx = false;
                    this.spIdx_ = 0;
                    return this;
                }

                public BaseInfo clearStepIdx() {
                    this.hasStepIdx = false;
                    this.stepIdx_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getModelType() {
                    return this.modelType_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasModelType() ? d.e(1, getModelType()) : 0;
                    if (hasStepIdx()) {
                        iE += d.e(2, getStepIdx());
                    }
                    if (hasSpIdx()) {
                        iE += d.e(3, getSpIdx());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public int getSpIdx() {
                    return this.spIdx_;
                }

                public int getStepIdx() {
                    return this.stepIdx_;
                }

                public boolean hasModelType() {
                    return this.hasModelType;
                }

                public boolean hasSpIdx() {
                    return this.hasSpIdx;
                }

                public boolean hasStepIdx() {
                    return this.hasStepIdx;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public BaseInfo setModelType(int i4) {
                    this.hasModelType = true;
                    this.modelType_ = i4;
                    return this;
                }

                public BaseInfo setSpIdx(int i4) {
                    this.hasSpIdx = true;
                    this.spIdx_ = i4;
                    return this;
                }

                public BaseInfo setStepIdx(int i4) {
                    this.hasStepIdx = true;
                    this.stepIdx_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasModelType()) {
                        dVar.s(1, getModelType());
                    }
                    if (hasStepIdx()) {
                        dVar.s(2, getStepIdx());
                    }
                    if (hasSpIdx()) {
                        dVar.s(3, getSpIdx());
                    }
                }

                public static BaseInfo parseFrom(byte[] bArr) throws e {
                    return (BaseInfo) new BaseInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public BaseInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setModelType(bVar.k());
                        } else if (iO == 16) {
                            setStepIdx(bVar.k());
                        } else if (iO == 24) {
                            setSpIdx(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static GuideV1 parseFrom(b bVar) throws IOException {
                return new GuideV1().mergeFrom(bVar);
            }

            public GuideV1 addBaseInfo(BaseInfo baseInfo) {
                if (baseInfo == null) {
                    return this;
                }
                if (this.baseInfo_.isEmpty()) {
                    this.baseInfo_ = new ArrayList();
                }
                this.baseInfo_.add(baseInfo);
                return this;
            }

            public final GuideV1 clear() {
                clearBaseInfo();
                this.cachedSize = -1;
                return this;
            }

            public GuideV1 clearBaseInfo() {
                this.baseInfo_ = Collections.emptyList();
                return this;
            }

            public BaseInfo getBaseInfo(int i4) {
                return this.baseInfo_.get(i4);
            }

            public int getBaseInfoCount() {
                return this.baseInfo_.size();
            }

            public List<BaseInfo> getBaseInfoList() {
                return this.baseInfo_;
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
                Iterator<BaseInfo> it = getBaseInfoList().iterator();
                int iH = 0;
                while (it.hasNext()) {
                    iH += d.h(1, it.next());
                }
                this.cachedSize = iH;
                return iH;
            }

            public final boolean isInitialized() {
                return true;
            }

            public GuideV1 setBaseInfo(int i4, BaseInfo baseInfo) {
                if (baseInfo == null) {
                    return this;
                }
                this.baseInfo_.set(i4, baseInfo);
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                Iterator<BaseInfo> it = getBaseInfoList().iterator();
                while (it.hasNext()) {
                    dVar.u(1, it.next());
                }
            }

            public static GuideV1 parseFrom(byte[] bArr) throws e {
                return (GuideV1) new GuideV1().mergeFrom(bArr);
            }

            @Override // L1.f
            public GuideV1 mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        BaseInfo baseInfo = new BaseInfo();
                        bVar.f(baseInfo);
                        addBaseInfo(baseInfo);
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static ARGuide parseFrom(b bVar) throws IOException {
            return new ARGuide().mergeFrom(bVar);
        }

        public final ARGuide clear() {
            clearVersion();
            clearRouteIdx();
            clearLegIdx();
            clearGuideV1();
            this.cachedSize = -1;
            return this;
        }

        public ARGuide clearGuideV1() {
            this.hasGuideV1 = false;
            this.guideV1_ = null;
            return this;
        }

        public ARGuide clearLegIdx() {
            this.hasLegIdx = false;
            this.legIdx_ = 0;
            return this;
        }

        public ARGuide clearRouteIdx() {
            this.hasRouteIdx = false;
            this.routeIdx_ = 0;
            return this;
        }

        public ARGuide clearVersion() {
            this.hasVersion = false;
            this.version_ = 0;
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public GuideV1 getGuideV1() {
            return this.guideV1_;
        }

        public int getLegIdx() {
            return this.legIdx_;
        }

        public int getRouteIdx() {
            return this.routeIdx_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iE = hasVersion() ? d.e(1, getVersion()) : 0;
            if (hasRouteIdx()) {
                iE += d.e(2, getRouteIdx());
            }
            if (hasLegIdx()) {
                iE += d.e(3, getLegIdx());
            }
            if (hasGuideV1()) {
                iE += d.h(4, getGuideV1());
            }
            this.cachedSize = iE;
            return iE;
        }

        public int getVersion() {
            return this.version_;
        }

        public boolean hasGuideV1() {
            return this.hasGuideV1;
        }

        public boolean hasLegIdx() {
            return this.hasLegIdx;
        }

        public boolean hasRouteIdx() {
            return this.hasRouteIdx;
        }

        public boolean hasVersion() {
            return this.hasVersion;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ARGuide setGuideV1(GuideV1 guideV1) {
            if (guideV1 == null) {
                return clearGuideV1();
            }
            this.hasGuideV1 = true;
            this.guideV1_ = guideV1;
            return this;
        }

        public ARGuide setLegIdx(int i4) {
            this.hasLegIdx = true;
            this.legIdx_ = i4;
            return this;
        }

        public ARGuide setRouteIdx(int i4) {
            this.hasRouteIdx = true;
            this.routeIdx_ = i4;
            return this;
        }

        public ARGuide setVersion(int i4) {
            this.hasVersion = true;
            this.version_ = i4;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasVersion()) {
                dVar.s(1, getVersion());
            }
            if (hasRouteIdx()) {
                dVar.s(2, getRouteIdx());
            }
            if (hasLegIdx()) {
                dVar.s(3, getLegIdx());
            }
            if (hasGuideV1()) {
                dVar.u(4, getGuideV1());
            }
        }

        public static ARGuide parseFrom(byte[] bArr) throws e {
            return (ARGuide) new ARGuide().mergeFrom(bArr);
        }

        @Override // L1.f
        public ARGuide mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 8) {
                    setVersion(bVar.k());
                } else if (iO == 16) {
                    setRouteIdx(bVar.k());
                } else if (iO == 24) {
                    setLegIdx(bVar.k());
                } else if (iO == 34) {
                    GuideV1 guideV1 = new GuideV1();
                    bVar.f(guideV1);
                    setGuideV1(guideV1);
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class AppendRouteInf extends f {
        public static final int ROUTEINF_LIST_FIELD_NUMBER = 1;
        private List<RouteInf> routeinfList_ = Collections.emptyList();
        private int cachedSize = -1;

        public static final class RouteInf extends f {
            public static final int FIRST_SCRN_INF_LIST_FIELD_NUMBER = 2;
            public static final int POSITIVE_FAC_NUM_FIELD_NUMBER = 1;
            public static final int SECOND_SCRN_INF_LIST_FIELD_NUMBER = 3;
            private boolean hasPositiveFacNum;
            private int positiveFacNum_ = 0;
            private List<FirstScreenInf> firstScrnInfList_ = Collections.emptyList();
            private List<SecondScreenInf> secondScrnInfList_ = Collections.emptyList();
            private int cachedSize = -1;

            public static final class FirstScreenInf extends f {
                public static final int IS_HIGHLIGHT_FIELD_NUMBER = 3;
                public static final int TEXT_FIELD_NUMBER = 2;
                public static final int TEXT_NAME_FIELD_NUMBER = 1;
                private boolean hasIsHighlight;
                private boolean hasText;
                private boolean hasTextName;
                private String textName_ = "";
                private String text_ = "";
                private int isHighlight_ = 0;
                private int cachedSize = -1;

                public static FirstScreenInf parseFrom(b bVar) throws IOException {
                    return new FirstScreenInf().mergeFrom(bVar);
                }

                public final FirstScreenInf clear() {
                    clearTextName();
                    clearText();
                    clearIsHighlight();
                    this.cachedSize = -1;
                    return this;
                }

                public FirstScreenInf clearIsHighlight() {
                    this.hasIsHighlight = false;
                    this.isHighlight_ = 0;
                    return this;
                }

                public FirstScreenInf clearText() {
                    this.hasText = false;
                    this.text_ = "";
                    return this;
                }

                public FirstScreenInf clearTextName() {
                    this.hasTextName = false;
                    this.textName_ = "";
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getIsHighlight() {
                    return this.isHighlight_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasTextName() ? d.l(1, getTextName()) : 0;
                    if (hasText()) {
                        iL += d.l(2, getText());
                    }
                    if (hasIsHighlight()) {
                        iL += d.e(3, getIsHighlight());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public String getText() {
                    return this.text_;
                }

                public String getTextName() {
                    return this.textName_;
                }

                public boolean hasIsHighlight() {
                    return this.hasIsHighlight;
                }

                public boolean hasText() {
                    return this.hasText;
                }

                public boolean hasTextName() {
                    return this.hasTextName;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public FirstScreenInf setIsHighlight(int i4) {
                    this.hasIsHighlight = true;
                    this.isHighlight_ = i4;
                    return this;
                }

                public FirstScreenInf setText(String str) {
                    this.hasText = true;
                    this.text_ = str;
                    return this;
                }

                public FirstScreenInf setTextName(String str) {
                    this.hasTextName = true;
                    this.textName_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasTextName()) {
                        dVar.A(1, getTextName());
                    }
                    if (hasText()) {
                        dVar.A(2, getText());
                    }
                    if (hasIsHighlight()) {
                        dVar.s(3, getIsHighlight());
                    }
                }

                public static FirstScreenInf parseFrom(byte[] bArr) throws e {
                    return (FirstScreenInf) new FirstScreenInf().mergeFrom(bArr);
                }

                @Override // L1.f
                public FirstScreenInf mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setTextName(bVar.n());
                        } else if (iO == 18) {
                            setText(bVar.n());
                        } else if (iO == 24) {
                            setIsHighlight(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class SecondScreenInf extends f {
                public static final int GROUPS_DETAIL_INF_FIELD_NUMBER = 2;
                public static final int GROUP_NAME_FIELD_NUMBER = 1;
                private boolean hasGroupName;
                private String groupName_ = "";
                private List<GroupDetailInf> groupsDetailInf_ = Collections.emptyList();
                private int cachedSize = -1;

                public static final class GroupDetailInf extends f {
                    public static final int IS_HIGHLIGHT_FIELD_NUMBER = 3;
                    public static final int TEXT_FIELD_NUMBER = 2;
                    public static final int TEXT_NAME_FIELD_NUMBER = 1;
                    private boolean hasIsHighlight;
                    private boolean hasText;
                    private boolean hasTextName;
                    private String textName_ = "";
                    private String text_ = "";
                    private int isHighlight_ = 0;
                    private int cachedSize = -1;

                    public static GroupDetailInf parseFrom(b bVar) throws IOException {
                        return new GroupDetailInf().mergeFrom(bVar);
                    }

                    public final GroupDetailInf clear() {
                        clearTextName();
                        clearText();
                        clearIsHighlight();
                        this.cachedSize = -1;
                        return this;
                    }

                    public GroupDetailInf clearIsHighlight() {
                        this.hasIsHighlight = false;
                        this.isHighlight_ = 0;
                        return this;
                    }

                    public GroupDetailInf clearText() {
                        this.hasText = false;
                        this.text_ = "";
                        return this;
                    }

                    public GroupDetailInf clearTextName() {
                        this.hasTextName = false;
                        this.textName_ = "";
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getIsHighlight() {
                        return this.isHighlight_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasTextName() ? d.l(1, getTextName()) : 0;
                        if (hasText()) {
                            iL += d.l(2, getText());
                        }
                        if (hasIsHighlight()) {
                            iL += d.e(3, getIsHighlight());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public String getText() {
                        return this.text_;
                    }

                    public String getTextName() {
                        return this.textName_;
                    }

                    public boolean hasIsHighlight() {
                        return this.hasIsHighlight;
                    }

                    public boolean hasText() {
                        return this.hasText;
                    }

                    public boolean hasTextName() {
                        return this.hasTextName;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public GroupDetailInf setIsHighlight(int i4) {
                        this.hasIsHighlight = true;
                        this.isHighlight_ = i4;
                        return this;
                    }

                    public GroupDetailInf setText(String str) {
                        this.hasText = true;
                        this.text_ = str;
                        return this;
                    }

                    public GroupDetailInf setTextName(String str) {
                        this.hasTextName = true;
                        this.textName_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasTextName()) {
                            dVar.A(1, getTextName());
                        }
                        if (hasText()) {
                            dVar.A(2, getText());
                        }
                        if (hasIsHighlight()) {
                            dVar.s(3, getIsHighlight());
                        }
                    }

                    public static GroupDetailInf parseFrom(byte[] bArr) throws e {
                        return (GroupDetailInf) new GroupDetailInf().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public GroupDetailInf mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setTextName(bVar.n());
                            } else if (iO == 18) {
                                setText(bVar.n());
                            } else if (iO == 24) {
                                setIsHighlight(bVar.k());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static SecondScreenInf parseFrom(b bVar) throws IOException {
                    return new SecondScreenInf().mergeFrom(bVar);
                }

                public SecondScreenInf addGroupsDetailInf(GroupDetailInf groupDetailInf) {
                    if (groupDetailInf == null) {
                        return this;
                    }
                    if (this.groupsDetailInf_.isEmpty()) {
                        this.groupsDetailInf_ = new ArrayList();
                    }
                    this.groupsDetailInf_.add(groupDetailInf);
                    return this;
                }

                public final SecondScreenInf clear() {
                    clearGroupName();
                    clearGroupsDetailInf();
                    this.cachedSize = -1;
                    return this;
                }

                public SecondScreenInf clearGroupName() {
                    this.hasGroupName = false;
                    this.groupName_ = "";
                    return this;
                }

                public SecondScreenInf clearGroupsDetailInf() {
                    this.groupsDetailInf_ = Collections.emptyList();
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getGroupName() {
                    return this.groupName_;
                }

                public GroupDetailInf getGroupsDetailInf(int i4) {
                    return this.groupsDetailInf_.get(i4);
                }

                public int getGroupsDetailInfCount() {
                    return this.groupsDetailInf_.size();
                }

                public List<GroupDetailInf> getGroupsDetailInfList() {
                    return this.groupsDetailInf_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasGroupName() ? d.l(1, getGroupName()) : 0;
                    Iterator<GroupDetailInf> it = getGroupsDetailInfList().iterator();
                    while (it.hasNext()) {
                        iL += d.h(2, it.next());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public boolean hasGroupName() {
                    return this.hasGroupName;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public SecondScreenInf setGroupName(String str) {
                    this.hasGroupName = true;
                    this.groupName_ = str;
                    return this;
                }

                public SecondScreenInf setGroupsDetailInf(int i4, GroupDetailInf groupDetailInf) {
                    if (groupDetailInf == null) {
                        return this;
                    }
                    this.groupsDetailInf_.set(i4, groupDetailInf);
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasGroupName()) {
                        dVar.A(1, getGroupName());
                    }
                    Iterator<GroupDetailInf> it = getGroupsDetailInfList().iterator();
                    while (it.hasNext()) {
                        dVar.u(2, it.next());
                    }
                }

                public static SecondScreenInf parseFrom(byte[] bArr) throws e {
                    return (SecondScreenInf) new SecondScreenInf().mergeFrom(bArr);
                }

                @Override // L1.f
                public SecondScreenInf mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setGroupName(bVar.n());
                        } else if (iO == 18) {
                            GroupDetailInf groupDetailInf = new GroupDetailInf();
                            bVar.f(groupDetailInf);
                            addGroupsDetailInf(groupDetailInf);
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static RouteInf parseFrom(b bVar) throws IOException {
                return new RouteInf().mergeFrom(bVar);
            }

            public RouteInf addFirstScrnInfList(FirstScreenInf firstScreenInf) {
                if (firstScreenInf == null) {
                    return this;
                }
                if (this.firstScrnInfList_.isEmpty()) {
                    this.firstScrnInfList_ = new ArrayList();
                }
                this.firstScrnInfList_.add(firstScreenInf);
                return this;
            }

            public RouteInf addSecondScrnInfList(SecondScreenInf secondScreenInf) {
                if (secondScreenInf == null) {
                    return this;
                }
                if (this.secondScrnInfList_.isEmpty()) {
                    this.secondScrnInfList_ = new ArrayList();
                }
                this.secondScrnInfList_.add(secondScreenInf);
                return this;
            }

            public final RouteInf clear() {
                clearPositiveFacNum();
                clearFirstScrnInfList();
                clearSecondScrnInfList();
                this.cachedSize = -1;
                return this;
            }

            public RouteInf clearFirstScrnInfList() {
                this.firstScrnInfList_ = Collections.emptyList();
                return this;
            }

            public RouteInf clearPositiveFacNum() {
                this.hasPositiveFacNum = false;
                this.positiveFacNum_ = 0;
                return this;
            }

            public RouteInf clearSecondScrnInfList() {
                this.secondScrnInfList_ = Collections.emptyList();
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public FirstScreenInf getFirstScrnInfList(int i4) {
                return this.firstScrnInfList_.get(i4);
            }

            public int getFirstScrnInfListCount() {
                return this.firstScrnInfList_.size();
            }

            public List<FirstScreenInf> getFirstScrnInfListList() {
                return this.firstScrnInfList_;
            }

            public int getPositiveFacNum() {
                return this.positiveFacNum_;
            }

            public SecondScreenInf getSecondScrnInfList(int i4) {
                return this.secondScrnInfList_.get(i4);
            }

            public int getSecondScrnInfListCount() {
                return this.secondScrnInfList_.size();
            }

            public List<SecondScreenInf> getSecondScrnInfListList() {
                return this.secondScrnInfList_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasPositiveFacNum() ? d.e(1, getPositiveFacNum()) : 0;
                Iterator<FirstScreenInf> it = getFirstScrnInfListList().iterator();
                while (it.hasNext()) {
                    iE += d.h(2, it.next());
                }
                Iterator<SecondScreenInf> it2 = getSecondScrnInfListList().iterator();
                while (it2.hasNext()) {
                    iE += d.h(3, it2.next());
                }
                this.cachedSize = iE;
                return iE;
            }

            public boolean hasPositiveFacNum() {
                return this.hasPositiveFacNum;
            }

            public final boolean isInitialized() {
                return true;
            }

            public RouteInf setFirstScrnInfList(int i4, FirstScreenInf firstScreenInf) {
                if (firstScreenInf == null) {
                    return this;
                }
                this.firstScrnInfList_.set(i4, firstScreenInf);
                return this;
            }

            public RouteInf setPositiveFacNum(int i4) {
                this.hasPositiveFacNum = true;
                this.positiveFacNum_ = i4;
                return this;
            }

            public RouteInf setSecondScrnInfList(int i4, SecondScreenInf secondScreenInf) {
                if (secondScreenInf == null) {
                    return this;
                }
                this.secondScrnInfList_.set(i4, secondScreenInf);
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasPositiveFacNum()) {
                    dVar.s(1, getPositiveFacNum());
                }
                Iterator<FirstScreenInf> it = getFirstScrnInfListList().iterator();
                while (it.hasNext()) {
                    dVar.u(2, it.next());
                }
                Iterator<SecondScreenInf> it2 = getSecondScrnInfListList().iterator();
                while (it2.hasNext()) {
                    dVar.u(3, it2.next());
                }
            }

            public static RouteInf parseFrom(byte[] bArr) throws e {
                return (RouteInf) new RouteInf().mergeFrom(bArr);
            }

            @Override // L1.f
            public RouteInf mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setPositiveFacNum(bVar.k());
                    } else if (iO == 18) {
                        FirstScreenInf firstScreenInf = new FirstScreenInf();
                        bVar.f(firstScreenInf);
                        addFirstScrnInfList(firstScreenInf);
                    } else if (iO == 26) {
                        SecondScreenInf secondScreenInf = new SecondScreenInf();
                        bVar.f(secondScreenInf);
                        addSecondScrnInfList(secondScreenInf);
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static AppendRouteInf parseFrom(b bVar) throws IOException {
            return new AppendRouteInf().mergeFrom(bVar);
        }

        public AppendRouteInf addRouteinfList(RouteInf routeInf) {
            if (routeInf == null) {
                return this;
            }
            if (this.routeinfList_.isEmpty()) {
                this.routeinfList_ = new ArrayList();
            }
            this.routeinfList_.add(routeInf);
            return this;
        }

        public final AppendRouteInf clear() {
            clearRouteinfList();
            this.cachedSize = -1;
            return this;
        }

        public AppendRouteInf clearRouteinfList() {
            this.routeinfList_ = Collections.emptyList();
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public RouteInf getRouteinfList(int i4) {
            return this.routeinfList_.get(i4);
        }

        public int getRouteinfListCount() {
            return this.routeinfList_.size();
        }

        public List<RouteInf> getRouteinfListList() {
            return this.routeinfList_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            Iterator<RouteInf> it = getRouteinfListList().iterator();
            int iH = 0;
            while (it.hasNext()) {
                iH += d.h(1, it.next());
            }
            this.cachedSize = iH;
            return iH;
        }

        public final boolean isInitialized() {
            return true;
        }

        public AppendRouteInf setRouteinfList(int i4, RouteInf routeInf) {
            if (routeInf == null) {
                return this;
            }
            this.routeinfList_.set(i4, routeInf);
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            Iterator<RouteInf> it = getRouteinfListList().iterator();
            while (it.hasNext()) {
                dVar.u(1, it.next());
            }
        }

        public static AppendRouteInf parseFrom(byte[] bArr) throws e {
            return (AppendRouteInf) new AppendRouteInf().mergeFrom(bArr);
        }

        @Override // L1.f
        public AppendRouteInf mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    RouteInf routeInf = new RouteInf();
                    bVar.f(routeInf);
                    addRouteinfList(routeInf);
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class Option extends f {
        public static final int AVOID_JAM_FIELD_NUMBER = 6;
        public static final int DIS_SY_FIELD_NUMBER = 9;
        public static final int END_CITY_FIELD_NUMBER = 8;
        public static final int END_FIELD_NUMBER = 5;
        public static final int EXPTIME_FIELD_NUMBER = 2;
        public static final int REQ_TM_FIELD_NUMBER = 10;
        public static final int SESSIONID_FIELD_NUMBER = 12;
        public static final int SPATH_TYPE_FIELD_NUMBER = 11;
        public static final int START_CITY_FIELD_NUMBER = 7;
        public static final int START_FIELD_NUMBER = 4;
        public static final int SY_FIELD_NUMBER = 3;
        public static final int TOTAL_FIELD_NUMBER = 1;
        private boolean hasAvoidJam;
        private boolean hasDisSy;
        private boolean hasExptime;
        private boolean hasReqTm;
        private boolean hasSessionid;
        private boolean hasSpathType;
        private boolean hasStart;
        private boolean hasStartCity;
        private boolean hasSy;
        private boolean hasTotal;
        private int total_ = 0;
        private String exptime_ = "";
        private int sy_ = 0;
        private Start start_ = null;
        private List<End> end_ = Collections.emptyList();
        private int avoidJam_ = 0;
        private StartCity startCity_ = null;
        private List<EndCity> endCity_ = Collections.emptyList();
        private int disSy_ = 0;
        private String reqTm_ = "";
        private int spathType_ = 0;
        private String sessionid_ = "";
        private int cachedSize = -1;

        public static final class End extends f {
            public static final int BUILDINGNAME_FIELD_NUMBER = 8;
            public static final int BUILDING_FIELD_NUMBER = 7;
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int FLOOR_FIELD_NUMBER = 6;
            public static final int FLOOR_INFO_FIELD_NUMBER = 9;
            public static final int INDOOR_LOC_TECH_FIELD_NUMBER = 10;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int RT_BUS_FIELD_NUMBER = 11;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            private boolean hasBuilding;
            private boolean hasBuildingname;
            private boolean hasBusStop;
            private boolean hasFloor;
            private boolean hasFloorInfo;
            private boolean hasIndoorLocTech;
            private boolean hasPt;
            private boolean hasRtBus;
            private boolean hasUid;
            private boolean hasWd;
            private String pt_ = "";
            private String wd_ = "";
            private String uid_ = "";
            private boolean busStop_ = false;
            private List<Integer> spt_ = Collections.emptyList();
            private String floor_ = "";
            private String building_ = "";
            private String buildingname_ = "";
            private String floorInfo_ = "";
            private int indoorLocTech_ = 0;
            private int rtBus_ = 0;
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
                clearWd();
                clearUid();
                clearBusStop();
                clearSpt();
                clearFloor();
                clearBuilding();
                clearBuildingname();
                clearFloorInfo();
                clearIndoorLocTech();
                clearRtBus();
                this.cachedSize = -1;
                return this;
            }

            public End clearBuilding() {
                this.hasBuilding = false;
                this.building_ = "";
                return this;
            }

            public End clearBuildingname() {
                this.hasBuildingname = false;
                this.buildingname_ = "";
                return this;
            }

            public End clearBusStop() {
                this.hasBusStop = false;
                this.busStop_ = false;
                return this;
            }

            public End clearFloor() {
                this.hasFloor = false;
                this.floor_ = "";
                return this;
            }

            public End clearFloorInfo() {
                this.hasFloorInfo = false;
                this.floorInfo_ = "";
                return this;
            }

            public End clearIndoorLocTech() {
                this.hasIndoorLocTech = false;
                this.indoorLocTech_ = 0;
                return this;
            }

            public End clearPt() {
                this.hasPt = false;
                this.pt_ = "";
                return this;
            }

            public End clearRtBus() {
                this.hasRtBus = false;
                this.rtBus_ = 0;
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

            public String getBuilding() {
                return this.building_;
            }

            public String getBuildingname() {
                return this.buildingname_;
            }

            public boolean getBusStop() {
                return this.busStop_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getFloor() {
                return this.floor_;
            }

            public String getFloorInfo() {
                return this.floorInfo_;
            }

            public int getIndoorLocTech() {
                return this.indoorLocTech_;
            }

            public String getPt() {
                return this.pt_;
            }

            public int getRtBus() {
                return this.rtBus_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iG = 0;
                int iL = hasPt() ? d.l(1, getPt()) : 0;
                if (hasWd()) {
                    iL += d.l(2, getWd());
                }
                if (hasUid()) {
                    iL += d.l(3, getUid());
                }
                if (hasBusStop()) {
                    getBusStop();
                    iL += d.a(4);
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    iG = g.g(it.next(), iG);
                }
                int size = getSptList().size() + iL + iG;
                if (hasFloor()) {
                    size += d.l(6, getFloor());
                }
                if (hasBuilding()) {
                    size += d.l(7, getBuilding());
                }
                if (hasBuildingname()) {
                    size += d.l(8, getBuildingname());
                }
                if (hasFloorInfo()) {
                    size += d.l(9, getFloorInfo());
                }
                if (hasIndoorLocTech()) {
                    size += d.e(10, getIndoorLocTech());
                }
                if (hasRtBus()) {
                    size += d.e(11, getRtBus());
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

            public boolean hasBuilding() {
                return this.hasBuilding;
            }

            public boolean hasBuildingname() {
                return this.hasBuildingname;
            }

            public boolean hasBusStop() {
                return this.hasBusStop;
            }

            public boolean hasFloor() {
                return this.hasFloor;
            }

            public boolean hasFloorInfo() {
                return this.hasFloorInfo;
            }

            public boolean hasIndoorLocTech() {
                return this.hasIndoorLocTech;
            }

            public boolean hasPt() {
                return this.hasPt;
            }

            public boolean hasRtBus() {
                return this.hasRtBus;
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

            public End setBuilding(String str) {
                this.hasBuilding = true;
                this.building_ = str;
                return this;
            }

            public End setBuildingname(String str) {
                this.hasBuildingname = true;
                this.buildingname_ = str;
                return this;
            }

            public End setBusStop(boolean z4) {
                this.hasBusStop = true;
                this.busStop_ = z4;
                return this;
            }

            public End setFloor(String str) {
                this.hasFloor = true;
                this.floor_ = str;
                return this;
            }

            public End setFloorInfo(String str) {
                this.hasFloorInfo = true;
                this.floorInfo_ = str;
                return this;
            }

            public End setIndoorLocTech(int i4) {
                this.hasIndoorLocTech = true;
                this.indoorLocTech_ = i4;
                return this;
            }

            public End setPt(String str) {
                this.hasPt = true;
                this.pt_ = str;
                return this;
            }

            public End setRtBus(int i4) {
                this.hasRtBus = true;
                this.rtBus_ = i4;
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
                if (hasWd()) {
                    dVar.A(2, getWd());
                }
                if (hasUid()) {
                    dVar.A(3, getUid());
                }
                if (hasBusStop()) {
                    dVar.p(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    dVar.z(5, it.next().intValue());
                }
                if (hasFloor()) {
                    dVar.A(6, getFloor());
                }
                if (hasBuilding()) {
                    dVar.A(7, getBuilding());
                }
                if (hasBuildingname()) {
                    dVar.A(8, getBuildingname());
                }
                if (hasFloorInfo()) {
                    dVar.A(9, getFloorInfo());
                }
                if (hasIndoorLocTech()) {
                    dVar.s(10, getIndoorLocTech());
                }
                if (hasRtBus()) {
                    dVar.s(11, getRtBus());
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
                            setWd(bVar.n());
                            break;
                        case 26:
                            setUid(bVar.n());
                            break;
                        case 32:
                            setBusStop(bVar.a());
                            break;
                        case 40:
                            addSpt(bVar.m());
                            break;
                        case 50:
                            setFloor(bVar.n());
                            break;
                        case 58:
                            setBuilding(bVar.n());
                            break;
                        case 66:
                            setBuildingname(bVar.n());
                            break;
                        case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                            setFloorInfo(bVar.n());
                            break;
                        case 80:
                            setIndoorLocTech(bVar.k());
                            break;
                        case 88:
                            setRtBus(bVar.k());
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

        public static final class EndCity extends f {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            private boolean hasCname;
            private boolean hasCode;
            private int code_ = 0;
            private String cname_ = "";
            private int cachedSize = -1;

            public static EndCity parseFrom(b bVar) throws IOException {
                return new EndCity().mergeFrom(bVar);
            }

            public final EndCity clear() {
                clearCode();
                clearCname();
                this.cachedSize = -1;
                return this;
            }

            public EndCity clearCname() {
                this.hasCname = false;
                this.cname_ = "";
                return this;
            }

            public EndCity clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getCname() {
                return this.cname_;
            }

            public int getCode() {
                return this.code_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasCode() ? d.e(1, getCode()) : 0;
                if (hasCname()) {
                    iE += d.l(2, getCname());
                }
                this.cachedSize = iE;
                return iE;
            }

            public boolean hasCname() {
                return this.hasCname;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public final boolean isInitialized() {
                return true;
            }

            public EndCity setCname(String str) {
                this.hasCname = true;
                this.cname_ = str;
                return this;
            }

            public EndCity setCode(int i4) {
                this.hasCode = true;
                this.code_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasCode()) {
                    dVar.s(1, getCode());
                }
                if (hasCname()) {
                    dVar.A(2, getCname());
                }
            }

            public static EndCity parseFrom(byte[] bArr) throws e {
                return (EndCity) new EndCity().mergeFrom(bArr);
            }

            @Override // L1.f
            public EndCity mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setCode(bVar.k());
                    } else if (iO == 18) {
                        setCname(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Start extends f {
            public static final int BUILDINGNAME_FIELD_NUMBER = 8;
            public static final int BUILDING_FIELD_NUMBER = 7;
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int FLOOR_FIELD_NUMBER = 6;
            public static final int FLOOR_INFO_FIELD_NUMBER = 9;
            public static final int INDOOR_LOC_TECH_FIELD_NUMBER = 10;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int RT_BUS_FIELD_NUMBER = 11;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            private boolean hasBuilding;
            private boolean hasBuildingname;
            private boolean hasBusStop;
            private boolean hasFloor;
            private boolean hasFloorInfo;
            private boolean hasIndoorLocTech;
            private boolean hasPt;
            private boolean hasRtBus;
            private boolean hasUid;
            private boolean hasWd;
            private String pt_ = "";
            private String wd_ = "";
            private String uid_ = "";
            private boolean busStop_ = false;
            private List<Integer> spt_ = Collections.emptyList();
            private String floor_ = "";
            private String building_ = "";
            private String buildingname_ = "";
            private String floorInfo_ = "";
            private int indoorLocTech_ = 0;
            private int rtBus_ = 0;
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
                clearWd();
                clearUid();
                clearBusStop();
                clearSpt();
                clearFloor();
                clearBuilding();
                clearBuildingname();
                clearFloorInfo();
                clearIndoorLocTech();
                clearRtBus();
                this.cachedSize = -1;
                return this;
            }

            public Start clearBuilding() {
                this.hasBuilding = false;
                this.building_ = "";
                return this;
            }

            public Start clearBuildingname() {
                this.hasBuildingname = false;
                this.buildingname_ = "";
                return this;
            }

            public Start clearBusStop() {
                this.hasBusStop = false;
                this.busStop_ = false;
                return this;
            }

            public Start clearFloor() {
                this.hasFloor = false;
                this.floor_ = "";
                return this;
            }

            public Start clearFloorInfo() {
                this.hasFloorInfo = false;
                this.floorInfo_ = "";
                return this;
            }

            public Start clearIndoorLocTech() {
                this.hasIndoorLocTech = false;
                this.indoorLocTech_ = 0;
                return this;
            }

            public Start clearPt() {
                this.hasPt = false;
                this.pt_ = "";
                return this;
            }

            public Start clearRtBus() {
                this.hasRtBus = false;
                this.rtBus_ = 0;
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

            public String getBuilding() {
                return this.building_;
            }

            public String getBuildingname() {
                return this.buildingname_;
            }

            public boolean getBusStop() {
                return this.busStop_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getFloor() {
                return this.floor_;
            }

            public String getFloorInfo() {
                return this.floorInfo_;
            }

            public int getIndoorLocTech() {
                return this.indoorLocTech_;
            }

            public String getPt() {
                return this.pt_;
            }

            public int getRtBus() {
                return this.rtBus_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iG = 0;
                int iL = hasPt() ? d.l(1, getPt()) : 0;
                if (hasWd()) {
                    iL += d.l(2, getWd());
                }
                if (hasUid()) {
                    iL += d.l(3, getUid());
                }
                if (hasBusStop()) {
                    getBusStop();
                    iL += d.a(4);
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    iG = g.g(it.next(), iG);
                }
                int size = getSptList().size() + iL + iG;
                if (hasFloor()) {
                    size += d.l(6, getFloor());
                }
                if (hasBuilding()) {
                    size += d.l(7, getBuilding());
                }
                if (hasBuildingname()) {
                    size += d.l(8, getBuildingname());
                }
                if (hasFloorInfo()) {
                    size += d.l(9, getFloorInfo());
                }
                if (hasIndoorLocTech()) {
                    size += d.e(10, getIndoorLocTech());
                }
                if (hasRtBus()) {
                    size += d.e(11, getRtBus());
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

            public boolean hasBuilding() {
                return this.hasBuilding;
            }

            public boolean hasBuildingname() {
                return this.hasBuildingname;
            }

            public boolean hasBusStop() {
                return this.hasBusStop;
            }

            public boolean hasFloor() {
                return this.hasFloor;
            }

            public boolean hasFloorInfo() {
                return this.hasFloorInfo;
            }

            public boolean hasIndoorLocTech() {
                return this.hasIndoorLocTech;
            }

            public boolean hasPt() {
                return this.hasPt;
            }

            public boolean hasRtBus() {
                return this.hasRtBus;
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

            public Start setBuilding(String str) {
                this.hasBuilding = true;
                this.building_ = str;
                return this;
            }

            public Start setBuildingname(String str) {
                this.hasBuildingname = true;
                this.buildingname_ = str;
                return this;
            }

            public Start setBusStop(boolean z4) {
                this.hasBusStop = true;
                this.busStop_ = z4;
                return this;
            }

            public Start setFloor(String str) {
                this.hasFloor = true;
                this.floor_ = str;
                return this;
            }

            public Start setFloorInfo(String str) {
                this.hasFloorInfo = true;
                this.floorInfo_ = str;
                return this;
            }

            public Start setIndoorLocTech(int i4) {
                this.hasIndoorLocTech = true;
                this.indoorLocTech_ = i4;
                return this;
            }

            public Start setPt(String str) {
                this.hasPt = true;
                this.pt_ = str;
                return this;
            }

            public Start setRtBus(int i4) {
                this.hasRtBus = true;
                this.rtBus_ = i4;
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
                if (hasWd()) {
                    dVar.A(2, getWd());
                }
                if (hasUid()) {
                    dVar.A(3, getUid());
                }
                if (hasBusStop()) {
                    dVar.p(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    dVar.z(5, it.next().intValue());
                }
                if (hasFloor()) {
                    dVar.A(6, getFloor());
                }
                if (hasBuilding()) {
                    dVar.A(7, getBuilding());
                }
                if (hasBuildingname()) {
                    dVar.A(8, getBuildingname());
                }
                if (hasFloorInfo()) {
                    dVar.A(9, getFloorInfo());
                }
                if (hasIndoorLocTech()) {
                    dVar.s(10, getIndoorLocTech());
                }
                if (hasRtBus()) {
                    dVar.s(11, getRtBus());
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
                            setWd(bVar.n());
                            break;
                        case 26:
                            setUid(bVar.n());
                            break;
                        case 32:
                            setBusStop(bVar.a());
                            break;
                        case 40:
                            addSpt(bVar.m());
                            break;
                        case 50:
                            setFloor(bVar.n());
                            break;
                        case 58:
                            setBuilding(bVar.n());
                            break;
                        case 66:
                            setBuildingname(bVar.n());
                            break;
                        case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                            setFloorInfo(bVar.n());
                            break;
                        case 80:
                            setIndoorLocTech(bVar.k());
                            break;
                        case 88:
                            setRtBus(bVar.k());
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

        public static final class StartCity extends f {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            private boolean hasCname;
            private boolean hasCode;
            private int code_ = 0;
            private String cname_ = "";
            private int cachedSize = -1;

            public static StartCity parseFrom(b bVar) throws IOException {
                return new StartCity().mergeFrom(bVar);
            }

            public final StartCity clear() {
                clearCode();
                clearCname();
                this.cachedSize = -1;
                return this;
            }

            public StartCity clearCname() {
                this.hasCname = false;
                this.cname_ = "";
                return this;
            }

            public StartCity clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getCname() {
                return this.cname_;
            }

            public int getCode() {
                return this.code_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasCode() ? d.e(1, getCode()) : 0;
                if (hasCname()) {
                    iE += d.l(2, getCname());
                }
                this.cachedSize = iE;
                return iE;
            }

            public boolean hasCname() {
                return this.hasCname;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public final boolean isInitialized() {
                return true;
            }

            public StartCity setCname(String str) {
                this.hasCname = true;
                this.cname_ = str;
                return this;
            }

            public StartCity setCode(int i4) {
                this.hasCode = true;
                this.code_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasCode()) {
                    dVar.s(1, getCode());
                }
                if (hasCname()) {
                    dVar.A(2, getCname());
                }
            }

            public static StartCity parseFrom(byte[] bArr) throws e {
                return (StartCity) new StartCity().mergeFrom(bArr);
            }

            @Override // L1.f
            public StartCity mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setCode(bVar.k());
                    } else if (iO == 18) {
                        setCname(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
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

        public Option addEndCity(EndCity endCity) {
            if (endCity == null) {
                return this;
            }
            if (this.endCity_.isEmpty()) {
                this.endCity_ = new ArrayList();
            }
            this.endCity_.add(endCity);
            return this;
        }

        public final Option clear() {
            clearTotal();
            clearExptime();
            clearSy();
            clearStart();
            clearEnd();
            clearAvoidJam();
            clearStartCity();
            clearEndCity();
            clearDisSy();
            clearReqTm();
            clearSpathType();
            clearSessionid();
            this.cachedSize = -1;
            return this;
        }

        public Option clearAvoidJam() {
            this.hasAvoidJam = false;
            this.avoidJam_ = 0;
            return this;
        }

        public Option clearDisSy() {
            this.hasDisSy = false;
            this.disSy_ = 0;
            return this;
        }

        public Option clearEnd() {
            this.end_ = Collections.emptyList();
            return this;
        }

        public Option clearEndCity() {
            this.endCity_ = Collections.emptyList();
            return this;
        }

        public Option clearExptime() {
            this.hasExptime = false;
            this.exptime_ = "";
            return this;
        }

        public Option clearReqTm() {
            this.hasReqTm = false;
            this.reqTm_ = "";
            return this;
        }

        public Option clearSessionid() {
            this.hasSessionid = false;
            this.sessionid_ = "";
            return this;
        }

        public Option clearSpathType() {
            this.hasSpathType = false;
            this.spathType_ = 0;
            return this;
        }

        public Option clearStart() {
            this.hasStart = false;
            this.start_ = null;
            return this;
        }

        public Option clearStartCity() {
            this.hasStartCity = false;
            this.startCity_ = null;
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

        public int getDisSy() {
            return this.disSy_;
        }

        public End getEnd(int i4) {
            return this.end_.get(i4);
        }

        public EndCity getEndCity(int i4) {
            return this.endCity_.get(i4);
        }

        public int getEndCityCount() {
            return this.endCity_.size();
        }

        public List<EndCity> getEndCityList() {
            return this.endCity_;
        }

        public int getEndCount() {
            return this.end_.size();
        }

        public List<End> getEndList() {
            return this.end_;
        }

        public String getExptime() {
            return this.exptime_;
        }

        public String getReqTm() {
            return this.reqTm_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iE = hasTotal() ? d.e(1, getTotal()) : 0;
            if (hasExptime()) {
                iE += d.l(2, getExptime());
            }
            if (hasSy()) {
                iE += d.e(3, getSy());
            }
            if (hasStart()) {
                iE += d.h(4, getStart());
            }
            Iterator<End> it = getEndList().iterator();
            while (it.hasNext()) {
                iE += d.h(5, it.next());
            }
            if (hasAvoidJam()) {
                iE += d.e(6, getAvoidJam());
            }
            if (hasStartCity()) {
                iE += d.h(7, getStartCity());
            }
            Iterator<EndCity> it2 = getEndCityList().iterator();
            while (it2.hasNext()) {
                iE += d.h(8, it2.next());
            }
            if (hasDisSy()) {
                iE += d.e(9, getDisSy());
            }
            if (hasReqTm()) {
                iE += d.l(10, getReqTm());
            }
            if (hasSpathType()) {
                iE += d.e(11, getSpathType());
            }
            if (hasSessionid()) {
                iE += d.l(12, getSessionid());
            }
            this.cachedSize = iE;
            return iE;
        }

        public String getSessionid() {
            return this.sessionid_;
        }

        public int getSpathType() {
            return this.spathType_;
        }

        public Start getStart() {
            return this.start_;
        }

        public StartCity getStartCity() {
            return this.startCity_;
        }

        public int getSy() {
            return this.sy_;
        }

        public int getTotal() {
            return this.total_;
        }

        public boolean hasAvoidJam() {
            return this.hasAvoidJam;
        }

        public boolean hasDisSy() {
            return this.hasDisSy;
        }

        public boolean hasExptime() {
            return this.hasExptime;
        }

        public boolean hasReqTm() {
            return this.hasReqTm;
        }

        public boolean hasSessionid() {
            return this.hasSessionid;
        }

        public boolean hasSpathType() {
            return this.hasSpathType;
        }

        public boolean hasStart() {
            return this.hasStart;
        }

        public boolean hasStartCity() {
            return this.hasStartCity;
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

        public Option setDisSy(int i4) {
            this.hasDisSy = true;
            this.disSy_ = i4;
            return this;
        }

        public Option setEnd(int i4, End end) {
            if (end == null) {
                return this;
            }
            this.end_.set(i4, end);
            return this;
        }

        public Option setEndCity(int i4, EndCity endCity) {
            if (endCity == null) {
                return this;
            }
            this.endCity_.set(i4, endCity);
            return this;
        }

        public Option setExptime(String str) {
            this.hasExptime = true;
            this.exptime_ = str;
            return this;
        }

        public Option setReqTm(String str) {
            this.hasReqTm = true;
            this.reqTm_ = str;
            return this;
        }

        public Option setSessionid(String str) {
            this.hasSessionid = true;
            this.sessionid_ = str;
            return this;
        }

        public Option setSpathType(int i4) {
            this.hasSpathType = true;
            this.spathType_ = i4;
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

        public Option setStartCity(StartCity startCity) {
            if (startCity == null) {
                return clearStartCity();
            }
            this.hasStartCity = true;
            this.startCity_ = startCity;
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

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasTotal()) {
                dVar.s(1, getTotal());
            }
            if (hasExptime()) {
                dVar.A(2, getExptime());
            }
            if (hasSy()) {
                dVar.s(3, getSy());
            }
            if (hasStart()) {
                dVar.u(4, getStart());
            }
            Iterator<End> it = getEndList().iterator();
            while (it.hasNext()) {
                dVar.u(5, it.next());
            }
            if (hasAvoidJam()) {
                dVar.s(6, getAvoidJam());
            }
            if (hasStartCity()) {
                dVar.u(7, getStartCity());
            }
            Iterator<EndCity> it2 = getEndCityList().iterator();
            while (it2.hasNext()) {
                dVar.u(8, it2.next());
            }
            if (hasDisSy()) {
                dVar.s(9, getDisSy());
            }
            if (hasReqTm()) {
                dVar.A(10, getReqTm());
            }
            if (hasSpathType()) {
                dVar.s(11, getSpathType());
            }
            if (hasSessionid()) {
                dVar.A(12, getSessionid());
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
                        setTotal(bVar.k());
                        break;
                    case 18:
                        setExptime(bVar.n());
                        break;
                    case 24:
                        setSy(bVar.k());
                        break;
                    case 34:
                        Start start = new Start();
                        bVar.f(start);
                        setStart(start);
                        break;
                    case 42:
                        End end = new End();
                        bVar.f(end);
                        addEnd(end);
                        break;
                    case 48:
                        setAvoidJam(bVar.k());
                        break;
                    case 58:
                        StartCity startCity = new StartCity();
                        bVar.f(startCity);
                        setStartCity(startCity);
                        break;
                    case 66:
                        EndCity endCity = new EndCity();
                        bVar.f(endCity);
                        addEndCity(endCity);
                        break;
                    case 72:
                        setDisSy(bVar.k());
                        break;
                    case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                        setReqTm(bVar.n());
                        break;
                    case 88:
                        setSpathType(bVar.k());
                        break;
                    case 98:
                        setSessionid(bVar.n());
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

    public static final class Routes extends f {
        public static final int CLIMB_FIELD_NUMBER = 2;
        public static final int GUIDE_INFO_FIELD_NUMBER = 8;
        public static final int LEGS_FIELD_NUMBER = 1;
        public static final int MAP_DRAW_INFO_FIELD_NUMBER = 10;
        public static final int MS_INFO_FIELD_NUMBER = 6;
        public static final int OTHERINFO_FIELD_NUMBER = 4;
        public static final int PLCY_INFO_FIELD_NUMBER = 5;
        public static final int ROUTE_IDF_FIELD_NUMBER = 7;
        public static final int TIP_FIELD_NUMBER = 3;
        public static final int UGC_INFO_FIELD_NUMBER = 9;
        private boolean hasClimb;
        private boolean hasOtherinfo;
        private boolean hasPlcyInfo;
        private boolean hasRouteIdf;
        private boolean hasTip;
        private List<Legs> legs_ = Collections.emptyList();
        private Climb climb_ = null;
        private Tip tip_ = null;
        private OtherInfo otherinfo_ = null;
        private PolicyInfo plcyInfo_ = null;
        private List<Milestone> msInfo_ = Collections.emptyList();
        private String routeIdf_ = "";
        private List<Guideinfo> guideInfo_ = Collections.emptyList();
        private List<UgcInfo> ugcInfo_ = Collections.emptyList();
        private List<MapDrawInfo> mapDrawInfo_ = Collections.emptyList();
        private int cachedSize = -1;

        public static final class Climb extends f {
            public static final int CLIMB_HEIGHT_FIELD_NUMBER = 3;
            public static final int DOWN_DIS_FIELD_NUMBER = 2;
            public static final int UP_DIS_FIELD_NUMBER = 1;
            private boolean hasClimbHeight;
            private boolean hasDownDis;
            private boolean hasUpDis;
            private int upDis_ = 0;
            private int downDis_ = 0;
            private int climbHeight_ = 0;
            private int cachedSize = -1;

            public static Climb parseFrom(b bVar) throws IOException {
                return new Climb().mergeFrom(bVar);
            }

            public final Climb clear() {
                clearUpDis();
                clearDownDis();
                clearClimbHeight();
                this.cachedSize = -1;
                return this;
            }

            public Climb clearClimbHeight() {
                this.hasClimbHeight = false;
                this.climbHeight_ = 0;
                return this;
            }

            public Climb clearDownDis() {
                this.hasDownDis = false;
                this.downDis_ = 0;
                return this;
            }

            public Climb clearUpDis() {
                this.hasUpDis = false;
                this.upDis_ = 0;
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getClimbHeight() {
                return this.climbHeight_;
            }

            public int getDownDis() {
                return this.downDis_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasUpDis() ? d.e(1, getUpDis()) : 0;
                if (hasDownDis()) {
                    iE += d.e(2, getDownDis());
                }
                if (hasClimbHeight()) {
                    iE += d.e(3, getClimbHeight());
                }
                this.cachedSize = iE;
                return iE;
            }

            public int getUpDis() {
                return this.upDis_;
            }

            public boolean hasClimbHeight() {
                return this.hasClimbHeight;
            }

            public boolean hasDownDis() {
                return this.hasDownDis;
            }

            public boolean hasUpDis() {
                return this.hasUpDis;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Climb setClimbHeight(int i4) {
                this.hasClimbHeight = true;
                this.climbHeight_ = i4;
                return this;
            }

            public Climb setDownDis(int i4) {
                this.hasDownDis = true;
                this.downDis_ = i4;
                return this;
            }

            public Climb setUpDis(int i4) {
                this.hasUpDis = true;
                this.upDis_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasUpDis()) {
                    dVar.s(1, getUpDis());
                }
                if (hasDownDis()) {
                    dVar.s(2, getDownDis());
                }
                if (hasClimbHeight()) {
                    dVar.s(3, getClimbHeight());
                }
            }

            public static Climb parseFrom(byte[] bArr) throws e {
                return (Climb) new Climb().mergeFrom(bArr);
            }

            @Override // L1.f
            public Climb mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setUpDis(bVar.k());
                    } else if (iO == 16) {
                        setDownDis(bVar.k());
                    } else if (iO == 24) {
                        setClimbHeight(bVar.k());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class GraphItemInfo extends f {
            public static final int CONTENT_FIELD_NUMBER = 1;
            public static final int PT_FIELD_NUMBER = 2;
            private boolean hasContent;
            private String content_ = "";
            private List<Integer> pt_ = Collections.emptyList();
            private int cachedSize = -1;

            public static GraphItemInfo parseFrom(b bVar) throws IOException {
                return new GraphItemInfo().mergeFrom(bVar);
            }

            public GraphItemInfo addPt(int i4) {
                if (this.pt_.isEmpty()) {
                    this.pt_ = new ArrayList();
                }
                this.pt_.add(Integer.valueOf(i4));
                return this;
            }

            public final GraphItemInfo clear() {
                clearContent();
                clearPt();
                this.cachedSize = -1;
                return this;
            }

            public GraphItemInfo clearContent() {
                this.hasContent = false;
                this.content_ = "";
                return this;
            }

            public GraphItemInfo clearPt() {
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

            public String getContent() {
                return this.content_;
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
                int iG = 0;
                int iL = hasContent() ? d.l(1, getContent()) : 0;
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    iG = g.g(it.next(), iG);
                }
                int size = getPtList().size() + iL + iG;
                this.cachedSize = size;
                return size;
            }

            public boolean hasContent() {
                return this.hasContent;
            }

            public final boolean isInitialized() {
                return true;
            }

            public GraphItemInfo setContent(String str) {
                this.hasContent = true;
                this.content_ = str;
                return this;
            }

            public GraphItemInfo setPt(int i4, int i5) {
                this.pt_.set(i4, Integer.valueOf(i5));
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasContent()) {
                    dVar.A(1, getContent());
                }
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    dVar.z(2, it.next().intValue());
                }
            }

            public static GraphItemInfo parseFrom(byte[] bArr) throws e {
                return (GraphItemInfo) new GraphItemInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public GraphItemInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setContent(bVar.n());
                    } else if (iO == 16) {
                        addPt(bVar.m());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Guideinfo extends f {
            public static final int GUIDE_STR_FIELD_NUMBER = 2;
            public static final int TYPE_FIELD_NUMBER = 1;
            private boolean hasGuideStr;
            private boolean hasType;
            private int type_ = 0;
            private String guideStr_ = "";
            private int cachedSize = -1;

            public static Guideinfo parseFrom(b bVar) throws IOException {
                return new Guideinfo().mergeFrom(bVar);
            }

            public final Guideinfo clear() {
                clearType();
                clearGuideStr();
                this.cachedSize = -1;
                return this;
            }

            public Guideinfo clearGuideStr() {
                this.hasGuideStr = false;
                this.guideStr_ = "";
                return this;
            }

            public Guideinfo clearType() {
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

            public String getGuideStr() {
                return this.guideStr_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasType() ? d.e(1, getType()) : 0;
                if (hasGuideStr()) {
                    iE += d.l(2, getGuideStr());
                }
                this.cachedSize = iE;
                return iE;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasGuideStr() {
                return this.hasGuideStr;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Guideinfo setGuideStr(String str) {
                this.hasGuideStr = true;
                this.guideStr_ = str;
                return this;
            }

            public Guideinfo setType(int i4) {
                this.hasType = true;
                this.type_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasType()) {
                    dVar.s(1, getType());
                }
                if (hasGuideStr()) {
                    dVar.A(2, getGuideStr());
                }
            }

            public static Guideinfo parseFrom(byte[] bArr) throws e {
                return (Guideinfo) new Guideinfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public Guideinfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setType(bVar.k());
                    } else if (iO == 18) {
                        setGuideStr(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Legs extends f {
            public static final int CONNECTED_POIS_FIELD_NUMBER = 11;
            public static final int DISTANCE_FIELD_NUMBER = 5;
            public static final int DURATION_FIELD_NUMBER = 6;
            public static final int END_ADDRESS_FIELD_NUMBER = 4;
            public static final int END_DIST_FIELD_NUMBER = 9;
            public static final int LEG_LINKED_FIELD_NUMBER = 12;
            public static final int SEND_LOCATION_FIELD_NUMBER = 2;
            public static final int SIDE_FIELD_NUMBER = 7;
            public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
            public static final int START_ADDRESS_FIELD_NUMBER = 3;
            public static final int START_DIST_FIELD_NUMBER = 8;
            public static final int STEPS_FIELD_NUMBER = 10;
            public static final int TYPE_FIELD_NUMBER = 13;
            private boolean hasDistance;
            private boolean hasDuration;
            private boolean hasEndAddress;
            private boolean hasEndDist;
            private boolean hasLegLinked;
            private boolean hasSide;
            private boolean hasStartAddress;
            private boolean hasStartDist;
            private boolean hasType;
            private List<Steps> steps_ = Collections.emptyList();
            private List<Integer> sstartLocation_ = Collections.emptyList();
            private List<Integer> sendLocation_ = Collections.emptyList();
            private String startAddress_ = "";
            private String endAddress_ = "";
            private int distance_ = 0;
            private int duration_ = 0;
            private int side_ = 0;
            private int startDist_ = 0;
            private int endDist_ = 0;
            private List<ConnectedPois> connectedPois_ = Collections.emptyList();
            private LegLinked legLinked_ = null;
            private int type_ = 0;
            private int cachedSize = -1;

            public static final class ConnectedPois extends f {
                public static final int BUILDING_FIELD_NUMBER = 6;
                public static final int FLOOR_FIELD_NUMBER = 5;
                public static final int INFO_FIELD_NUMBER = 3;
                public static final int LOCATION_FIELD_NUMBER = 4;
                public static final int TYPE_DIR_FIELD_NUMBER = 2;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasBuilding;
                private boolean hasFloor;
                private boolean hasInfo;
                private boolean hasType;
                private boolean hasTypeDir;
                private int type_ = 0;
                private int typeDir_ = 0;
                private String info_ = "";
                private List<Integer> location_ = Collections.emptyList();
                private String floor_ = "";
                private String building_ = "";
                private int cachedSize = -1;

                public static ConnectedPois parseFrom(b bVar) throws IOException {
                    return new ConnectedPois().mergeFrom(bVar);
                }

                public ConnectedPois addLocation(int i4) {
                    if (this.location_.isEmpty()) {
                        this.location_ = new ArrayList();
                    }
                    this.location_.add(Integer.valueOf(i4));
                    return this;
                }

                public final ConnectedPois clear() {
                    clearType();
                    clearTypeDir();
                    clearInfo();
                    clearLocation();
                    clearFloor();
                    clearBuilding();
                    this.cachedSize = -1;
                    return this;
                }

                public ConnectedPois clearBuilding() {
                    this.hasBuilding = false;
                    this.building_ = "";
                    return this;
                }

                public ConnectedPois clearFloor() {
                    this.hasFloor = false;
                    this.floor_ = "";
                    return this;
                }

                public ConnectedPois clearInfo() {
                    this.hasInfo = false;
                    this.info_ = "";
                    return this;
                }

                public ConnectedPois clearLocation() {
                    this.location_ = Collections.emptyList();
                    return this;
                }

                public ConnectedPois clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                public ConnectedPois clearTypeDir() {
                    this.hasTypeDir = false;
                    this.typeDir_ = 0;
                    return this;
                }

                public String getBuilding() {
                    return this.building_;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getFloor() {
                    return this.floor_;
                }

                public String getInfo() {
                    return this.info_;
                }

                public int getLocation(int i4) {
                    return this.location_.get(i4).intValue();
                }

                public int getLocationCount() {
                    return this.location_.size();
                }

                public List<Integer> getLocationList() {
                    return this.location_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iF = 0;
                    int iE = hasType() ? d.e(1, getType()) : 0;
                    if (hasTypeDir()) {
                        iE += d.e(2, getTypeDir());
                    }
                    if (hasInfo()) {
                        iE += d.l(3, getInfo());
                    }
                    Iterator<Integer> it = getLocationList().iterator();
                    while (it.hasNext()) {
                        iF += d.f(it.next().intValue());
                    }
                    int size = getLocationList().size() + iE + iF;
                    if (hasFloor()) {
                        size += d.l(5, getFloor());
                    }
                    if (hasBuilding()) {
                        size += d.l(6, getBuilding());
                    }
                    this.cachedSize = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public int getTypeDir() {
                    return this.typeDir_;
                }

                public boolean hasBuilding() {
                    return this.hasBuilding;
                }

                public boolean hasFloor() {
                    return this.hasFloor;
                }

                public boolean hasInfo() {
                    return this.hasInfo;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public boolean hasTypeDir() {
                    return this.hasTypeDir;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public ConnectedPois setBuilding(String str) {
                    this.hasBuilding = true;
                    this.building_ = str;
                    return this;
                }

                public ConnectedPois setFloor(String str) {
                    this.hasFloor = true;
                    this.floor_ = str;
                    return this;
                }

                public ConnectedPois setInfo(String str) {
                    this.hasInfo = true;
                    this.info_ = str;
                    return this;
                }

                public ConnectedPois setLocation(int i4, int i5) {
                    this.location_.set(i4, Integer.valueOf(i5));
                    return this;
                }

                public ConnectedPois setType(int i4) {
                    this.hasType = true;
                    this.type_ = i4;
                    return this;
                }

                public ConnectedPois setTypeDir(int i4) {
                    this.hasTypeDir = true;
                    this.typeDir_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasType()) {
                        dVar.s(1, getType());
                    }
                    if (hasTypeDir()) {
                        dVar.s(2, getTypeDir());
                    }
                    if (hasInfo()) {
                        dVar.A(3, getInfo());
                    }
                    Iterator<Integer> it = getLocationList().iterator();
                    while (it.hasNext()) {
                        dVar.s(4, it.next().intValue());
                    }
                    if (hasFloor()) {
                        dVar.A(5, getFloor());
                    }
                    if (hasBuilding()) {
                        dVar.A(6, getBuilding());
                    }
                }

                public static ConnectedPois parseFrom(byte[] bArr) throws e {
                    return (ConnectedPois) new ConnectedPois().mergeFrom(bArr);
                }

                @Override // L1.f
                public ConnectedPois mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setType(bVar.k());
                        } else if (iO == 16) {
                            setTypeDir(bVar.k());
                        } else if (iO == 26) {
                            setInfo(bVar.n());
                        } else if (iO == 32) {
                            addLocation(bVar.k());
                        } else if (iO == 42) {
                            setFloor(bVar.n());
                        } else if (iO == 50) {
                            setBuilding(bVar.n());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class LegLinked extends f {
                public static final int NEXT_FIELD_NUMBER = 2;
                public static final int PREV_FIELD_NUMBER = 1;
                private boolean hasNext;
                private boolean hasPrev;
                private int prev_ = 0;
                private int next_ = 0;
                private int cachedSize = -1;

                public static LegLinked parseFrom(b bVar) throws IOException {
                    return new LegLinked().mergeFrom(bVar);
                }

                public final LegLinked clear() {
                    clearPrev();
                    clearNext();
                    this.cachedSize = -1;
                    return this;
                }

                public LegLinked clearNext() {
                    this.hasNext = false;
                    this.next_ = 0;
                    return this;
                }

                public LegLinked clearPrev() {
                    this.hasPrev = false;
                    this.prev_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getNext() {
                    return this.next_;
                }

                public int getPrev() {
                    return this.prev_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasPrev() ? d.e(1, getPrev()) : 0;
                    if (hasNext()) {
                        iE += d.e(2, getNext());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public boolean hasNext() {
                    return this.hasNext;
                }

                public boolean hasPrev() {
                    return this.hasPrev;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public LegLinked setNext(int i4) {
                    this.hasNext = true;
                    this.next_ = i4;
                    return this;
                }

                public LegLinked setPrev(int i4) {
                    this.hasPrev = true;
                    this.prev_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasPrev()) {
                        dVar.s(1, getPrev());
                    }
                    if (hasNext()) {
                        dVar.s(2, getNext());
                    }
                }

                public static LegLinked parseFrom(byte[] bArr) throws e {
                    return (LegLinked) new LegLinked().mergeFrom(bArr);
                }

                @Override // L1.f
                public LegLinked mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setPrev(bVar.k());
                        } else if (iO == 16) {
                            setNext(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class Steps extends f {
                public static final int CIRCLE_ROAD_FIELD_NUMBER = 9;
                public static final int CLOUD_GUIDE_V1_FIELD_NUMBER = 24;
                public static final int CLOUD_GUIDE_V2_FIELD_NUMBER = 25;
                public static final int CLOUD_GUIDE_V3_FIELD_NUMBER = 27;
                public static final int DIRECTION_FIELD_NUMBER = 15;
                public static final int DISTANCE_FIELD_NUMBER = 11;
                public static final int DURATION_FIELD_NUMBER = 12;
                public static final int FIRST_LINK_END_INDEX_FIELD_NUMBER = 5;
                public static final int GUIDE_TYPE_FIELD_NUMBER = 26;
                public static final int HAS_PANID_FIELD_NUMBER = 16;
                public static final int INSTRUCTIONS_FIELD_NUMBER = 2;
                public static final int LIGHT_FIELD_NUMBER = 8;
                public static final int LINKS_FIELD_NUMBER = 13;
                public static final int NAME_FIELD_NUMBER = 4;
                public static final int POIREF_POIS_FIELD_NUMBER = 23;
                public static final int POIS_FIELD_NUMBER = 14;
                public static final int ROAD_WIDTH_FIELD_NUMBER = 10;
                public static final int SEND_LOCATION_FIELD_NUMBER = 18;
                public static final int SPATH_4_NAVI_FIELD_NUMBER = 21;
                public static final int SPATH_FIELD_NUMBER = 1;
                public static final int SSTART_LOCATION_FIELD_NUMBER = 17;
                public static final int STEP_STATUS_FIELD_NUMBER = 22;
                public static final int STRAFFICMARK_LOC_FIELD_NUMBER = 19;
                public static final int TRAFFIC_TYPE_FIELD_NUMBER = 20;
                public static final int TURN_TYPE_FIELD_NUMBER = 6;
                public static final int TYPE_FIELD_NUMBER = 3;
                public static final int WALK_TYPE_FIELD_NUMBER = 7;
                private boolean hasCircleRoad;
                private boolean hasDirection;
                private boolean hasDistance;
                private boolean hasDuration;
                private boolean hasFirstLinkEndIndex;
                private boolean hasGuideType;
                private boolean hasHasPanid;
                private boolean hasInstructions;
                private boolean hasLight;
                private boolean hasName;
                private boolean hasRoadWidth;
                private boolean hasStepStatus;
                private boolean hasTrafficType;
                private boolean hasTurnType;
                private boolean hasType;
                private boolean hasWalkType;
                private List<Links> links_ = Collections.emptyList();
                private List<Pois> pois_ = Collections.emptyList();
                private List<Integer> spath_ = Collections.emptyList();
                private String instructions_ = "";
                private int type_ = 0;
                private String name_ = "";
                private int firstLinkEndIndex_ = 0;
                private int turnType_ = 0;
                private int walkType_ = 0;
                private int light_ = 0;
                private int circleRoad_ = 0;
                private int roadWidth_ = 0;
                private int distance_ = 0;
                private int duration_ = 0;
                private int direction_ = 0;
                private int hasPanid_ = 0;
                private List<Integer> sstartLocation_ = Collections.emptyList();
                private List<Integer> sendLocation_ = Collections.emptyList();
                private List<Integer> strafficmarkLoc_ = Collections.emptyList();
                private int trafficType_ = 0;
                private List<Integer> spath4Navi_ = Collections.emptyList();
                private int stepStatus_ = 0;
                private List<Pois> poirefPois_ = Collections.emptyList();
                private List<DetailGuideInfoV1> cloudGuideV1_ = Collections.emptyList();
                private List<DetailGuideInfoV2> cloudGuideV2_ = Collections.emptyList();
                private int guideType_ = 0;
                private List<DetailGuideInfoV3> cloudGuideV3_ = Collections.emptyList();
                private int cachedSize = -1;

                public static final class DetailGuideInfoV1 extends f {
                    public static final int ADD_DIST_FIELD_NUMBER = 1;
                    public static final int AFTER_DIST_FIELD_NUMBER = 6;
                    public static final int BROADCAST_CONTENT_FIELD_NUMBER = 3;
                    public static final int BROADCAST_CONTENT_TYPE_FIELD_NUMBER = 2;
                    public static final int CIRCLE_ROAD_FIELD_NUMBER = 10;
                    public static final int NOTIFY_NPC_FIELD_NUMBER = 7;
                    public static final int PRE_DIST_FIELD_NUMBER = 5;
                    public static final int PRIOROTY_FIELD_NUMBER = 4;
                    public static final int TURN_TYPE_FIELD_NUMBER = 8;
                    public static final int VIBRATE_FIELD_NUMBER = 11;
                    public static final int WALK_TYPE_FIELD_NUMBER = 9;
                    private boolean hasAddDist;
                    private boolean hasAfterDist;
                    private boolean hasBroadcastContent;
                    private boolean hasBroadcastContentType;
                    private boolean hasCircleRoad;
                    private boolean hasNotifyNpc;
                    private boolean hasPreDist;
                    private boolean hasPrioroty;
                    private boolean hasTurnType;
                    private boolean hasVibrate;
                    private boolean hasWalkType;
                    private int addDist_ = 0;
                    private int broadcastContentType_ = 0;
                    private String broadcastContent_ = "";
                    private int prioroty_ = 0;
                    private int preDist_ = 0;
                    private int afterDist_ = 0;
                    private int notifyNpc_ = 0;
                    private int turnType_ = 0;
                    private int walkType_ = 0;
                    private int circleRoad_ = 0;
                    private int vibrate_ = 0;
                    private int cachedSize = -1;

                    public static DetailGuideInfoV1 parseFrom(b bVar) throws IOException {
                        return new DetailGuideInfoV1().mergeFrom(bVar);
                    }

                    public final DetailGuideInfoV1 clear() {
                        clearAddDist();
                        clearBroadcastContentType();
                        clearBroadcastContent();
                        clearPrioroty();
                        clearPreDist();
                        clearAfterDist();
                        clearNotifyNpc();
                        clearTurnType();
                        clearWalkType();
                        clearCircleRoad();
                        clearVibrate();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DetailGuideInfoV1 clearAddDist() {
                        this.hasAddDist = false;
                        this.addDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearAfterDist() {
                        this.hasAfterDist = false;
                        this.afterDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearBroadcastContent() {
                        this.hasBroadcastContent = false;
                        this.broadcastContent_ = "";
                        return this;
                    }

                    public DetailGuideInfoV1 clearBroadcastContentType() {
                        this.hasBroadcastContentType = false;
                        this.broadcastContentType_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearCircleRoad() {
                        this.hasCircleRoad = false;
                        this.circleRoad_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearNotifyNpc() {
                        this.hasNotifyNpc = false;
                        this.notifyNpc_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearPreDist() {
                        this.hasPreDist = false;
                        this.preDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearPrioroty() {
                        this.hasPrioroty = false;
                        this.prioroty_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearTurnType() {
                        this.hasTurnType = false;
                        this.turnType_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearVibrate() {
                        this.hasVibrate = false;
                        this.vibrate_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearWalkType() {
                        this.hasWalkType = false;
                        this.walkType_ = 0;
                        return this;
                    }

                    public int getAddDist() {
                        return this.addDist_;
                    }

                    public int getAfterDist() {
                        return this.afterDist_;
                    }

                    public String getBroadcastContent() {
                        return this.broadcastContent_;
                    }

                    public int getBroadcastContentType() {
                        return this.broadcastContentType_;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getCircleRoad() {
                        return this.circleRoad_;
                    }

                    public int getNotifyNpc() {
                        return this.notifyNpc_;
                    }

                    public int getPreDist() {
                        return this.preDist_;
                    }

                    public int getPrioroty() {
                        return this.prioroty_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasAddDist() ? d.e(1, getAddDist()) : 0;
                        if (hasBroadcastContentType()) {
                            iE += d.e(2, getBroadcastContentType());
                        }
                        if (hasBroadcastContent()) {
                            iE += d.l(3, getBroadcastContent());
                        }
                        if (hasPrioroty()) {
                            iE += d.e(4, getPrioroty());
                        }
                        if (hasPreDist()) {
                            iE += d.e(5, getPreDist());
                        }
                        if (hasAfterDist()) {
                            iE += d.e(6, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            iE += d.e(7, getNotifyNpc());
                        }
                        if (hasTurnType()) {
                            iE += d.e(8, getTurnType());
                        }
                        if (hasWalkType()) {
                            iE += d.e(9, getWalkType());
                        }
                        if (hasCircleRoad()) {
                            iE += d.e(10, getCircleRoad());
                        }
                        if (hasVibrate()) {
                            iE += d.e(11, getVibrate());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public int getTurnType() {
                        return this.turnType_;
                    }

                    public int getVibrate() {
                        return this.vibrate_;
                    }

                    public int getWalkType() {
                        return this.walkType_;
                    }

                    public boolean hasAddDist() {
                        return this.hasAddDist;
                    }

                    public boolean hasAfterDist() {
                        return this.hasAfterDist;
                    }

                    public boolean hasBroadcastContent() {
                        return this.hasBroadcastContent;
                    }

                    public boolean hasBroadcastContentType() {
                        return this.hasBroadcastContentType;
                    }

                    public boolean hasCircleRoad() {
                        return this.hasCircleRoad;
                    }

                    public boolean hasNotifyNpc() {
                        return this.hasNotifyNpc;
                    }

                    public boolean hasPreDist() {
                        return this.hasPreDist;
                    }

                    public boolean hasPrioroty() {
                        return this.hasPrioroty;
                    }

                    public boolean hasTurnType() {
                        return this.hasTurnType;
                    }

                    public boolean hasVibrate() {
                        return this.hasVibrate;
                    }

                    public boolean hasWalkType() {
                        return this.hasWalkType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public DetailGuideInfoV1 setAddDist(int i4) {
                        this.hasAddDist = true;
                        this.addDist_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV1 setAfterDist(int i4) {
                        this.hasAfterDist = true;
                        this.afterDist_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV1 setBroadcastContent(String str) {
                        this.hasBroadcastContent = true;
                        this.broadcastContent_ = str;
                        return this;
                    }

                    public DetailGuideInfoV1 setBroadcastContentType(int i4) {
                        this.hasBroadcastContentType = true;
                        this.broadcastContentType_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV1 setCircleRoad(int i4) {
                        this.hasCircleRoad = true;
                        this.circleRoad_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV1 setNotifyNpc(int i4) {
                        this.hasNotifyNpc = true;
                        this.notifyNpc_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV1 setPreDist(int i4) {
                        this.hasPreDist = true;
                        this.preDist_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV1 setPrioroty(int i4) {
                        this.hasPrioroty = true;
                        this.prioroty_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV1 setTurnType(int i4) {
                        this.hasTurnType = true;
                        this.turnType_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV1 setVibrate(int i4) {
                        this.hasVibrate = true;
                        this.vibrate_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV1 setWalkType(int i4) {
                        this.hasWalkType = true;
                        this.walkType_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasAddDist()) {
                            dVar.s(1, getAddDist());
                        }
                        if (hasBroadcastContentType()) {
                            dVar.s(2, getBroadcastContentType());
                        }
                        if (hasBroadcastContent()) {
                            dVar.A(3, getBroadcastContent());
                        }
                        if (hasPrioroty()) {
                            dVar.s(4, getPrioroty());
                        }
                        if (hasPreDist()) {
                            dVar.s(5, getPreDist());
                        }
                        if (hasAfterDist()) {
                            dVar.s(6, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            dVar.s(7, getNotifyNpc());
                        }
                        if (hasTurnType()) {
                            dVar.s(8, getTurnType());
                        }
                        if (hasWalkType()) {
                            dVar.s(9, getWalkType());
                        }
                        if (hasCircleRoad()) {
                            dVar.s(10, getCircleRoad());
                        }
                        if (hasVibrate()) {
                            dVar.s(11, getVibrate());
                        }
                    }

                    public static DetailGuideInfoV1 parseFrom(byte[] bArr) throws e {
                        return (DetailGuideInfoV1) new DetailGuideInfoV1().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public DetailGuideInfoV1 mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            switch (iO) {
                                case 0:
                                    return this;
                                case 8:
                                    setAddDist(bVar.k());
                                    break;
                                case 16:
                                    setBroadcastContentType(bVar.k());
                                    break;
                                case 26:
                                    setBroadcastContent(bVar.n());
                                    break;
                                case 32:
                                    setPrioroty(bVar.k());
                                    break;
                                case 40:
                                    setPreDist(bVar.k());
                                    break;
                                case 48:
                                    setAfterDist(bVar.k());
                                    break;
                                case 56:
                                    setNotifyNpc(bVar.k());
                                    break;
                                case 64:
                                    setTurnType(bVar.k());
                                    break;
                                case 72:
                                    setWalkType(bVar.k());
                                    break;
                                case 80:
                                    setCircleRoad(bVar.k());
                                    break;
                                case 88:
                                    setVibrate(bVar.k());
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

                public static final class DetailGuideInfoV2 extends f {
                    public static final int AFTER_DIST_FIELD_NUMBER = 6;
                    public static final int BROADCAST_CONTENT_TYPE_FIELD_NUMBER = 2;
                    public static final int BROADCAST_TEMPLATE_FIELD_NUMBER = 3;
                    public static final int CIRCLE_ROAD_FIELD_NUMBER = 10;
                    public static final int NOTIFY_NPC_FIELD_NUMBER = 7;
                    public static final int PRE_DIST_FIELD_NUMBER = 5;
                    public static final int PRIOROTY_FIELD_NUMBER = 4;
                    public static final int SUB_INFO_FIELD_NUMBER = 1;
                    public static final int TURN_TYPE_FIELD_NUMBER = 8;
                    public static final int WALK_TYPE_FIELD_NUMBER = 9;
                    private boolean hasAfterDist;
                    private boolean hasBroadcastContentType;
                    private boolean hasCircleRoad;
                    private boolean hasNotifyNpc;
                    private boolean hasPreDist;
                    private boolean hasPrioroty;
                    private boolean hasTurnType;
                    private boolean hasWalkType;
                    private List<SubGuideInfo> subInfo_ = Collections.emptyList();
                    private int broadcastContentType_ = 0;
                    private List<String> broadcastTemplate_ = Collections.emptyList();
                    private int prioroty_ = 0;
                    private int preDist_ = 0;
                    private int afterDist_ = 0;
                    private int notifyNpc_ = 0;
                    private int turnType_ = 0;
                    private int walkType_ = 0;
                    private int circleRoad_ = 0;
                    private int cachedSize = -1;

                    public static final class SubGuideInfo extends f {
                        public static final int ADD_DIST_FIELD_NUMBER = 1;
                        public static final int AFTER_DIST_FIELD_NUMBER = 6;
                        public static final int BROADCAST_CONTENT_FIELD_NUMBER = 3;
                        public static final int BROADCAST_CONTENT_TYPE_FIELD_NUMBER = 2;
                        public static final int CIRCLE_ROAD_FIELD_NUMBER = 10;
                        public static final int NOTIFY_NPC_FIELD_NUMBER = 7;
                        public static final int PRE_DIST_FIELD_NUMBER = 5;
                        public static final int PRIOROTY_FIELD_NUMBER = 4;
                        public static final int TURN_TYPE_FIELD_NUMBER = 8;
                        public static final int WALK_TYPE_FIELD_NUMBER = 9;
                        private boolean hasAddDist;
                        private boolean hasAfterDist;
                        private boolean hasBroadcastContentType;
                        private boolean hasCircleRoad;
                        private boolean hasNotifyNpc;
                        private boolean hasPreDist;
                        private boolean hasPrioroty;
                        private boolean hasTurnType;
                        private boolean hasWalkType;
                        private int addDist_ = 0;
                        private int broadcastContentType_ = 0;
                        private List<String> broadcastContent_ = Collections.emptyList();
                        private int prioroty_ = 0;
                        private int preDist_ = 0;
                        private int afterDist_ = 0;
                        private int notifyNpc_ = 0;
                        private int turnType_ = 0;
                        private int walkType_ = 0;
                        private int circleRoad_ = 0;
                        private int cachedSize = -1;

                        public static SubGuideInfo parseFrom(b bVar) throws IOException {
                            return new SubGuideInfo().mergeFrom(bVar);
                        }

                        public SubGuideInfo addBroadcastContent(String str) {
                            str.getClass();
                            if (this.broadcastContent_.isEmpty()) {
                                this.broadcastContent_ = new ArrayList();
                            }
                            this.broadcastContent_.add(str);
                            return this;
                        }

                        public final SubGuideInfo clear() {
                            clearAddDist();
                            clearBroadcastContentType();
                            clearBroadcastContent();
                            clearPrioroty();
                            clearPreDist();
                            clearAfterDist();
                            clearNotifyNpc();
                            clearTurnType();
                            clearWalkType();
                            clearCircleRoad();
                            this.cachedSize = -1;
                            return this;
                        }

                        public SubGuideInfo clearAddDist() {
                            this.hasAddDist = false;
                            this.addDist_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearAfterDist() {
                            this.hasAfterDist = false;
                            this.afterDist_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearBroadcastContent() {
                            this.broadcastContent_ = Collections.emptyList();
                            return this;
                        }

                        public SubGuideInfo clearBroadcastContentType() {
                            this.hasBroadcastContentType = false;
                            this.broadcastContentType_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearCircleRoad() {
                            this.hasCircleRoad = false;
                            this.circleRoad_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearNotifyNpc() {
                            this.hasNotifyNpc = false;
                            this.notifyNpc_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearPreDist() {
                            this.hasPreDist = false;
                            this.preDist_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearPrioroty() {
                            this.hasPrioroty = false;
                            this.prioroty_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearTurnType() {
                            this.hasTurnType = false;
                            this.turnType_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearWalkType() {
                            this.hasWalkType = false;
                            this.walkType_ = 0;
                            return this;
                        }

                        public int getAddDist() {
                            return this.addDist_;
                        }

                        public int getAfterDist() {
                            return this.afterDist_;
                        }

                        public String getBroadcastContent(int i4) {
                            return this.broadcastContent_.get(i4);
                        }

                        public int getBroadcastContentCount() {
                            return this.broadcastContent_.size();
                        }

                        public List<String> getBroadcastContentList() {
                            return this.broadcastContent_;
                        }

                        public int getBroadcastContentType() {
                            return this.broadcastContentType_;
                        }

                        @Override // L1.f
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public int getCircleRoad() {
                            return this.circleRoad_;
                        }

                        public int getNotifyNpc() {
                            return this.notifyNpc_;
                        }

                        public int getPreDist() {
                            return this.preDist_;
                        }

                        public int getPrioroty() {
                            return this.prioroty_;
                        }

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iM = 0;
                            int iE = hasAddDist() ? d.e(1, getAddDist()) : 0;
                            if (hasBroadcastContentType()) {
                                iE += d.e(2, getBroadcastContentType());
                            }
                            Iterator<String> it = getBroadcastContentList().iterator();
                            while (it.hasNext()) {
                                iM += d.m(it.next());
                            }
                            int size = getBroadcastContentList().size() + iE + iM;
                            if (hasPrioroty()) {
                                size += d.e(4, getPrioroty());
                            }
                            if (hasPreDist()) {
                                size += d.e(5, getPreDist());
                            }
                            if (hasAfterDist()) {
                                size += d.e(6, getAfterDist());
                            }
                            if (hasNotifyNpc()) {
                                size += d.e(7, getNotifyNpc());
                            }
                            if (hasTurnType()) {
                                size += d.e(8, getTurnType());
                            }
                            if (hasWalkType()) {
                                size += d.e(9, getWalkType());
                            }
                            if (hasCircleRoad()) {
                                size += d.e(10, getCircleRoad());
                            }
                            this.cachedSize = size;
                            return size;
                        }

                        public int getTurnType() {
                            return this.turnType_;
                        }

                        public int getWalkType() {
                            return this.walkType_;
                        }

                        public boolean hasAddDist() {
                            return this.hasAddDist;
                        }

                        public boolean hasAfterDist() {
                            return this.hasAfterDist;
                        }

                        public boolean hasBroadcastContentType() {
                            return this.hasBroadcastContentType;
                        }

                        public boolean hasCircleRoad() {
                            return this.hasCircleRoad;
                        }

                        public boolean hasNotifyNpc() {
                            return this.hasNotifyNpc;
                        }

                        public boolean hasPreDist() {
                            return this.hasPreDist;
                        }

                        public boolean hasPrioroty() {
                            return this.hasPrioroty;
                        }

                        public boolean hasTurnType() {
                            return this.hasTurnType;
                        }

                        public boolean hasWalkType() {
                            return this.hasWalkType;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public SubGuideInfo setAddDist(int i4) {
                            this.hasAddDist = true;
                            this.addDist_ = i4;
                            return this;
                        }

                        public SubGuideInfo setAfterDist(int i4) {
                            this.hasAfterDist = true;
                            this.afterDist_ = i4;
                            return this;
                        }

                        public SubGuideInfo setBroadcastContent(int i4, String str) {
                            str.getClass();
                            this.broadcastContent_.set(i4, str);
                            return this;
                        }

                        public SubGuideInfo setBroadcastContentType(int i4) {
                            this.hasBroadcastContentType = true;
                            this.broadcastContentType_ = i4;
                            return this;
                        }

                        public SubGuideInfo setCircleRoad(int i4) {
                            this.hasCircleRoad = true;
                            this.circleRoad_ = i4;
                            return this;
                        }

                        public SubGuideInfo setNotifyNpc(int i4) {
                            this.hasNotifyNpc = true;
                            this.notifyNpc_ = i4;
                            return this;
                        }

                        public SubGuideInfo setPreDist(int i4) {
                            this.hasPreDist = true;
                            this.preDist_ = i4;
                            return this;
                        }

                        public SubGuideInfo setPrioroty(int i4) {
                            this.hasPrioroty = true;
                            this.prioroty_ = i4;
                            return this;
                        }

                        public SubGuideInfo setTurnType(int i4) {
                            this.hasTurnType = true;
                            this.turnType_ = i4;
                            return this;
                        }

                        public SubGuideInfo setWalkType(int i4) {
                            this.hasWalkType = true;
                            this.walkType_ = i4;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasAddDist()) {
                                dVar.s(1, getAddDist());
                            }
                            if (hasBroadcastContentType()) {
                                dVar.s(2, getBroadcastContentType());
                            }
                            Iterator<String> it = getBroadcastContentList().iterator();
                            while (it.hasNext()) {
                                dVar.A(3, it.next());
                            }
                            if (hasPrioroty()) {
                                dVar.s(4, getPrioroty());
                            }
                            if (hasPreDist()) {
                                dVar.s(5, getPreDist());
                            }
                            if (hasAfterDist()) {
                                dVar.s(6, getAfterDist());
                            }
                            if (hasNotifyNpc()) {
                                dVar.s(7, getNotifyNpc());
                            }
                            if (hasTurnType()) {
                                dVar.s(8, getTurnType());
                            }
                            if (hasWalkType()) {
                                dVar.s(9, getWalkType());
                            }
                            if (hasCircleRoad()) {
                                dVar.s(10, getCircleRoad());
                            }
                        }

                        public static SubGuideInfo parseFrom(byte[] bArr) throws e {
                            return (SubGuideInfo) new SubGuideInfo().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public SubGuideInfo mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                switch (iO) {
                                    case 0:
                                        return this;
                                    case 8:
                                        setAddDist(bVar.k());
                                        break;
                                    case 16:
                                        setBroadcastContentType(bVar.k());
                                        break;
                                    case 26:
                                        addBroadcastContent(bVar.n());
                                        break;
                                    case 32:
                                        setPrioroty(bVar.k());
                                        break;
                                    case 40:
                                        setPreDist(bVar.k());
                                        break;
                                    case 48:
                                        setAfterDist(bVar.k());
                                        break;
                                    case 56:
                                        setNotifyNpc(bVar.k());
                                        break;
                                    case 64:
                                        setTurnType(bVar.k());
                                        break;
                                    case 72:
                                        setWalkType(bVar.k());
                                        break;
                                    case 80:
                                        setCircleRoad(bVar.k());
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

                    public static DetailGuideInfoV2 parseFrom(b bVar) throws IOException {
                        return new DetailGuideInfoV2().mergeFrom(bVar);
                    }

                    public DetailGuideInfoV2 addBroadcastTemplate(String str) {
                        str.getClass();
                        if (this.broadcastTemplate_.isEmpty()) {
                            this.broadcastTemplate_ = new ArrayList();
                        }
                        this.broadcastTemplate_.add(str);
                        return this;
                    }

                    public DetailGuideInfoV2 addSubInfo(SubGuideInfo subGuideInfo) {
                        if (subGuideInfo == null) {
                            return this;
                        }
                        if (this.subInfo_.isEmpty()) {
                            this.subInfo_ = new ArrayList();
                        }
                        this.subInfo_.add(subGuideInfo);
                        return this;
                    }

                    public final DetailGuideInfoV2 clear() {
                        clearSubInfo();
                        clearBroadcastContentType();
                        clearBroadcastTemplate();
                        clearPrioroty();
                        clearPreDist();
                        clearAfterDist();
                        clearNotifyNpc();
                        clearTurnType();
                        clearWalkType();
                        clearCircleRoad();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DetailGuideInfoV2 clearAfterDist() {
                        this.hasAfterDist = false;
                        this.afterDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearBroadcastContentType() {
                        this.hasBroadcastContentType = false;
                        this.broadcastContentType_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearBroadcastTemplate() {
                        this.broadcastTemplate_ = Collections.emptyList();
                        return this;
                    }

                    public DetailGuideInfoV2 clearCircleRoad() {
                        this.hasCircleRoad = false;
                        this.circleRoad_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearNotifyNpc() {
                        this.hasNotifyNpc = false;
                        this.notifyNpc_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearPreDist() {
                        this.hasPreDist = false;
                        this.preDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearPrioroty() {
                        this.hasPrioroty = false;
                        this.prioroty_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearSubInfo() {
                        this.subInfo_ = Collections.emptyList();
                        return this;
                    }

                    public DetailGuideInfoV2 clearTurnType() {
                        this.hasTurnType = false;
                        this.turnType_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearWalkType() {
                        this.hasWalkType = false;
                        this.walkType_ = 0;
                        return this;
                    }

                    public int getAfterDist() {
                        return this.afterDist_;
                    }

                    public int getBroadcastContentType() {
                        return this.broadcastContentType_;
                    }

                    public String getBroadcastTemplate(int i4) {
                        return this.broadcastTemplate_.get(i4);
                    }

                    public int getBroadcastTemplateCount() {
                        return this.broadcastTemplate_.size();
                    }

                    public List<String> getBroadcastTemplateList() {
                        return this.broadcastTemplate_;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getCircleRoad() {
                        return this.circleRoad_;
                    }

                    public int getNotifyNpc() {
                        return this.notifyNpc_;
                    }

                    public int getPreDist() {
                        return this.preDist_;
                    }

                    public int getPrioroty() {
                        return this.prioroty_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        Iterator<SubGuideInfo> it = getSubInfoList().iterator();
                        int iM = 0;
                        int iE = 0;
                        while (it.hasNext()) {
                            iE += d.h(1, it.next());
                        }
                        if (hasBroadcastContentType()) {
                            iE += d.e(2, getBroadcastContentType());
                        }
                        Iterator<String> it2 = getBroadcastTemplateList().iterator();
                        while (it2.hasNext()) {
                            iM += d.m(it2.next());
                        }
                        int size = getBroadcastTemplateList().size() + iE + iM;
                        if (hasPrioroty()) {
                            size += d.e(4, getPrioroty());
                        }
                        if (hasPreDist()) {
                            size += d.e(5, getPreDist());
                        }
                        if (hasAfterDist()) {
                            size += d.e(6, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            size += d.e(7, getNotifyNpc());
                        }
                        if (hasTurnType()) {
                            size += d.e(8, getTurnType());
                        }
                        if (hasWalkType()) {
                            size += d.e(9, getWalkType());
                        }
                        if (hasCircleRoad()) {
                            size += d.e(10, getCircleRoad());
                        }
                        this.cachedSize = size;
                        return size;
                    }

                    public SubGuideInfo getSubInfo(int i4) {
                        return this.subInfo_.get(i4);
                    }

                    public int getSubInfoCount() {
                        return this.subInfo_.size();
                    }

                    public List<SubGuideInfo> getSubInfoList() {
                        return this.subInfo_;
                    }

                    public int getTurnType() {
                        return this.turnType_;
                    }

                    public int getWalkType() {
                        return this.walkType_;
                    }

                    public boolean hasAfterDist() {
                        return this.hasAfterDist;
                    }

                    public boolean hasBroadcastContentType() {
                        return this.hasBroadcastContentType;
                    }

                    public boolean hasCircleRoad() {
                        return this.hasCircleRoad;
                    }

                    public boolean hasNotifyNpc() {
                        return this.hasNotifyNpc;
                    }

                    public boolean hasPreDist() {
                        return this.hasPreDist;
                    }

                    public boolean hasPrioroty() {
                        return this.hasPrioroty;
                    }

                    public boolean hasTurnType() {
                        return this.hasTurnType;
                    }

                    public boolean hasWalkType() {
                        return this.hasWalkType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public DetailGuideInfoV2 setAfterDist(int i4) {
                        this.hasAfterDist = true;
                        this.afterDist_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV2 setBroadcastContentType(int i4) {
                        this.hasBroadcastContentType = true;
                        this.broadcastContentType_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV2 setBroadcastTemplate(int i4, String str) {
                        str.getClass();
                        this.broadcastTemplate_.set(i4, str);
                        return this;
                    }

                    public DetailGuideInfoV2 setCircleRoad(int i4) {
                        this.hasCircleRoad = true;
                        this.circleRoad_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV2 setNotifyNpc(int i4) {
                        this.hasNotifyNpc = true;
                        this.notifyNpc_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV2 setPreDist(int i4) {
                        this.hasPreDist = true;
                        this.preDist_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV2 setPrioroty(int i4) {
                        this.hasPrioroty = true;
                        this.prioroty_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV2 setSubInfo(int i4, SubGuideInfo subGuideInfo) {
                        if (subGuideInfo == null) {
                            return this;
                        }
                        this.subInfo_.set(i4, subGuideInfo);
                        return this;
                    }

                    public DetailGuideInfoV2 setTurnType(int i4) {
                        this.hasTurnType = true;
                        this.turnType_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV2 setWalkType(int i4) {
                        this.hasWalkType = true;
                        this.walkType_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        Iterator<SubGuideInfo> it = getSubInfoList().iterator();
                        while (it.hasNext()) {
                            dVar.u(1, it.next());
                        }
                        if (hasBroadcastContentType()) {
                            dVar.s(2, getBroadcastContentType());
                        }
                        Iterator<String> it2 = getBroadcastTemplateList().iterator();
                        while (it2.hasNext()) {
                            dVar.A(3, it2.next());
                        }
                        if (hasPrioroty()) {
                            dVar.s(4, getPrioroty());
                        }
                        if (hasPreDist()) {
                            dVar.s(5, getPreDist());
                        }
                        if (hasAfterDist()) {
                            dVar.s(6, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            dVar.s(7, getNotifyNpc());
                        }
                        if (hasTurnType()) {
                            dVar.s(8, getTurnType());
                        }
                        if (hasWalkType()) {
                            dVar.s(9, getWalkType());
                        }
                        if (hasCircleRoad()) {
                            dVar.s(10, getCircleRoad());
                        }
                    }

                    public static DetailGuideInfoV2 parseFrom(byte[] bArr) throws e {
                        return (DetailGuideInfoV2) new DetailGuideInfoV2().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public DetailGuideInfoV2 mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            switch (iO) {
                                case 0:
                                    return this;
                                case 10:
                                    SubGuideInfo subGuideInfo = new SubGuideInfo();
                                    bVar.f(subGuideInfo);
                                    addSubInfo(subGuideInfo);
                                    break;
                                case 16:
                                    setBroadcastContentType(bVar.k());
                                    break;
                                case 26:
                                    addBroadcastTemplate(bVar.n());
                                    break;
                                case 32:
                                    setPrioroty(bVar.k());
                                    break;
                                case 40:
                                    setPreDist(bVar.k());
                                    break;
                                case 48:
                                    setAfterDist(bVar.k());
                                    break;
                                case 56:
                                    setNotifyNpc(bVar.k());
                                    break;
                                case 64:
                                    setTurnType(bVar.k());
                                    break;
                                case 72:
                                    setWalkType(bVar.k());
                                    break;
                                case 80:
                                    setCircleRoad(bVar.k());
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

                public static final class DetailGuideInfoV3 extends f {
                    public static final int ADD_DIST_FIELD_NUMBER = 2;
                    public static final int AFTER_DIST_FIELD_NUMBER = 5;
                    public static final int BROADCAST_TEMPLATE_FIELD_NUMBER = 1;
                    public static final int NOTIFY_NPC_FIELD_NUMBER = 6;
                    public static final int PRE_DIST_FIELD_NUMBER = 4;
                    public static final int PRIOROTY_FIELD_NUMBER = 3;
                    public static final int VIBRATE_FIELD_NUMBER = 7;
                    private boolean hasAddDist;
                    private boolean hasAfterDist;
                    private boolean hasBroadcastTemplate;
                    private boolean hasNotifyNpc;
                    private boolean hasPreDist;
                    private boolean hasPrioroty;
                    private boolean hasVibrate;
                    private String broadcastTemplate_ = "";
                    private int addDist_ = 0;
                    private int prioroty_ = 0;
                    private int preDist_ = 0;
                    private int afterDist_ = 0;
                    private int notifyNpc_ = 0;
                    private int vibrate_ = 0;
                    private int cachedSize = -1;

                    public static DetailGuideInfoV3 parseFrom(b bVar) throws IOException {
                        return new DetailGuideInfoV3().mergeFrom(bVar);
                    }

                    public final DetailGuideInfoV3 clear() {
                        clearBroadcastTemplate();
                        clearAddDist();
                        clearPrioroty();
                        clearPreDist();
                        clearAfterDist();
                        clearNotifyNpc();
                        clearVibrate();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DetailGuideInfoV3 clearAddDist() {
                        this.hasAddDist = false;
                        this.addDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV3 clearAfterDist() {
                        this.hasAfterDist = false;
                        this.afterDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV3 clearBroadcastTemplate() {
                        this.hasBroadcastTemplate = false;
                        this.broadcastTemplate_ = "";
                        return this;
                    }

                    public DetailGuideInfoV3 clearNotifyNpc() {
                        this.hasNotifyNpc = false;
                        this.notifyNpc_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV3 clearPreDist() {
                        this.hasPreDist = false;
                        this.preDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV3 clearPrioroty() {
                        this.hasPrioroty = false;
                        this.prioroty_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV3 clearVibrate() {
                        this.hasVibrate = false;
                        this.vibrate_ = 0;
                        return this;
                    }

                    public int getAddDist() {
                        return this.addDist_;
                    }

                    public int getAfterDist() {
                        return this.afterDist_;
                    }

                    public String getBroadcastTemplate() {
                        return this.broadcastTemplate_;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getNotifyNpc() {
                        return this.notifyNpc_;
                    }

                    public int getPreDist() {
                        return this.preDist_;
                    }

                    public int getPrioroty() {
                        return this.prioroty_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasBroadcastTemplate() ? d.l(1, getBroadcastTemplate()) : 0;
                        if (hasAddDist()) {
                            iL += d.e(2, getAddDist());
                        }
                        if (hasPrioroty()) {
                            iL += d.e(3, getPrioroty());
                        }
                        if (hasPreDist()) {
                            iL += d.e(4, getPreDist());
                        }
                        if (hasAfterDist()) {
                            iL += d.e(5, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            iL += d.e(6, getNotifyNpc());
                        }
                        if (hasVibrate()) {
                            iL += d.e(7, getVibrate());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public int getVibrate() {
                        return this.vibrate_;
                    }

                    public boolean hasAddDist() {
                        return this.hasAddDist;
                    }

                    public boolean hasAfterDist() {
                        return this.hasAfterDist;
                    }

                    public boolean hasBroadcastTemplate() {
                        return this.hasBroadcastTemplate;
                    }

                    public boolean hasNotifyNpc() {
                        return this.hasNotifyNpc;
                    }

                    public boolean hasPreDist() {
                        return this.hasPreDist;
                    }

                    public boolean hasPrioroty() {
                        return this.hasPrioroty;
                    }

                    public boolean hasVibrate() {
                        return this.hasVibrate;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public DetailGuideInfoV3 setAddDist(int i4) {
                        this.hasAddDist = true;
                        this.addDist_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV3 setAfterDist(int i4) {
                        this.hasAfterDist = true;
                        this.afterDist_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV3 setBroadcastTemplate(String str) {
                        this.hasBroadcastTemplate = true;
                        this.broadcastTemplate_ = str;
                        return this;
                    }

                    public DetailGuideInfoV3 setNotifyNpc(int i4) {
                        this.hasNotifyNpc = true;
                        this.notifyNpc_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV3 setPreDist(int i4) {
                        this.hasPreDist = true;
                        this.preDist_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV3 setPrioroty(int i4) {
                        this.hasPrioroty = true;
                        this.prioroty_ = i4;
                        return this;
                    }

                    public DetailGuideInfoV3 setVibrate(int i4) {
                        this.hasVibrate = true;
                        this.vibrate_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasBroadcastTemplate()) {
                            dVar.A(1, getBroadcastTemplate());
                        }
                        if (hasAddDist()) {
                            dVar.s(2, getAddDist());
                        }
                        if (hasPrioroty()) {
                            dVar.s(3, getPrioroty());
                        }
                        if (hasPreDist()) {
                            dVar.s(4, getPreDist());
                        }
                        if (hasAfterDist()) {
                            dVar.s(5, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            dVar.s(6, getNotifyNpc());
                        }
                        if (hasVibrate()) {
                            dVar.s(7, getVibrate());
                        }
                    }

                    public static DetailGuideInfoV3 parseFrom(byte[] bArr) throws e {
                        return (DetailGuideInfoV3) new DetailGuideInfoV3().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public DetailGuideInfoV3 mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setBroadcastTemplate(bVar.n());
                            } else if (iO == 16) {
                                setAddDist(bVar.k());
                            } else if (iO == 24) {
                                setPrioroty(bVar.k());
                            } else if (iO == 32) {
                                setPreDist(bVar.k());
                            } else if (iO == 40) {
                                setAfterDist(bVar.k());
                            } else if (iO == 48) {
                                setNotifyNpc(bVar.k());
                            } else if (iO == 56) {
                                setVibrate(bVar.k());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class Links extends f {
                    public static final int FCROSS_DIS_TO_TURN_FIELD_NUMBER = 8;
                    public static final int FCROSS_NUM_TO_TURN_FIELD_NUMBER = 7;
                    public static final int HAS_PANID_FIELD_NUMBER = 4;
                    public static final int IDX_FIELD_NUMBER = 2;
                    public static final int ID_FIELD_NUMBER = 1;
                    public static final int INNER_CROSS_LINK_FIELD_NUMBER = 12;
                    public static final int IS_BIND_TRAFFIC_LIGHT_FIELD_NUMBER = 13;
                    public static final int LENGTH_FIELD_NUMBER = 3;
                    public static final int LINK_ATTR_FIELD_NUMBER = 6;
                    public static final int LINK_TYPE_FIELD_NUMBER = 5;
                    public static final int ROAD_LEVEL_FIELD_NUMBER = 9;
                    public static final int ROAD_WIDTH_FIELD_NUMBER = 10;
                    public static final int TRAFFIC_LIGHT_FIELD_NUMBER = 11;
                    public static final int TURN_LEFT_LAMP_INFO_FIELD_NUMBER = 14;
                    private boolean hasFcrossDisToTurn;
                    private boolean hasFcrossNumToTurn;
                    private boolean hasHasPanid;
                    private boolean hasId;
                    private boolean hasIdx;
                    private boolean hasInnerCrossLink;
                    private boolean hasIsBindTrafficLight;
                    private boolean hasLength;
                    private boolean hasLinkAttr;
                    private boolean hasLinkType;
                    private boolean hasRoadLevel;
                    private boolean hasRoadWidth;
                    private boolean hasTrafficLight;
                    private boolean hasTurnLeftLampInfo;
                    private String id_ = "";
                    private int idx_ = 0;
                    private int length_ = 0;
                    private int hasPanid_ = 0;
                    private int linkType_ = 0;
                    private int linkAttr_ = 0;
                    private int fcrossNumToTurn_ = 0;
                    private int fcrossDisToTurn_ = 0;
                    private int roadLevel_ = 0;
                    private int roadWidth_ = 0;
                    private int trafficLight_ = 0;
                    private int innerCrossLink_ = 0;
                    private int isBindTrafficLight_ = 0;
                    private TurnLeftLampInfo turnLeftLampInfo_ = null;
                    private int cachedSize = -1;

                    public static final class TurnLeftLampInfo extends f {
                        public static final int TURN_LEFT_LAMP_LINKID_FIELD_NUMBER = 2;
                        public static final int TURN_LEFT_ROUTE_LINKID_FIELD_NUMBER = 1;
                        private boolean hasTurnLeftLampLinkid;
                        private boolean hasTurnLeftRouteLinkid;
                        private String turnLeftRouteLinkid_ = "";
                        private String turnLeftLampLinkid_ = "";
                        private int cachedSize = -1;

                        public static TurnLeftLampInfo parseFrom(b bVar) throws IOException {
                            return new TurnLeftLampInfo().mergeFrom(bVar);
                        }

                        public final TurnLeftLampInfo clear() {
                            clearTurnLeftRouteLinkid();
                            clearTurnLeftLampLinkid();
                            this.cachedSize = -1;
                            return this;
                        }

                        public TurnLeftLampInfo clearTurnLeftLampLinkid() {
                            this.hasTurnLeftLampLinkid = false;
                            this.turnLeftLampLinkid_ = "";
                            return this;
                        }

                        public TurnLeftLampInfo clearTurnLeftRouteLinkid() {
                            this.hasTurnLeftRouteLinkid = false;
                            this.turnLeftRouteLinkid_ = "";
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
                            int iL = hasTurnLeftRouteLinkid() ? d.l(1, getTurnLeftRouteLinkid()) : 0;
                            if (hasTurnLeftLampLinkid()) {
                                iL += d.l(2, getTurnLeftLampLinkid());
                            }
                            this.cachedSize = iL;
                            return iL;
                        }

                        public String getTurnLeftLampLinkid() {
                            return this.turnLeftLampLinkid_;
                        }

                        public String getTurnLeftRouteLinkid() {
                            return this.turnLeftRouteLinkid_;
                        }

                        public boolean hasTurnLeftLampLinkid() {
                            return this.hasTurnLeftLampLinkid;
                        }

                        public boolean hasTurnLeftRouteLinkid() {
                            return this.hasTurnLeftRouteLinkid;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public TurnLeftLampInfo setTurnLeftLampLinkid(String str) {
                            this.hasTurnLeftLampLinkid = true;
                            this.turnLeftLampLinkid_ = str;
                            return this;
                        }

                        public TurnLeftLampInfo setTurnLeftRouteLinkid(String str) {
                            this.hasTurnLeftRouteLinkid = true;
                            this.turnLeftRouteLinkid_ = str;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasTurnLeftRouteLinkid()) {
                                dVar.A(1, getTurnLeftRouteLinkid());
                            }
                            if (hasTurnLeftLampLinkid()) {
                                dVar.A(2, getTurnLeftLampLinkid());
                            }
                        }

                        public static TurnLeftLampInfo parseFrom(byte[] bArr) throws e {
                            return (TurnLeftLampInfo) new TurnLeftLampInfo().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public TurnLeftLampInfo mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 10) {
                                    setTurnLeftRouteLinkid(bVar.n());
                                } else if (iO == 18) {
                                    setTurnLeftLampLinkid(bVar.n());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static Links parseFrom(b bVar) throws IOException {
                        return new Links().mergeFrom(bVar);
                    }

                    public final Links clear() {
                        clearId();
                        clearIdx();
                        clearLength();
                        clearHasPanid();
                        clearLinkType();
                        clearLinkAttr();
                        clearFcrossNumToTurn();
                        clearFcrossDisToTurn();
                        clearRoadLevel();
                        clearRoadWidth();
                        clearTrafficLight();
                        clearInnerCrossLink();
                        clearIsBindTrafficLight();
                        clearTurnLeftLampInfo();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Links clearFcrossDisToTurn() {
                        this.hasFcrossDisToTurn = false;
                        this.fcrossDisToTurn_ = 0;
                        return this;
                    }

                    public Links clearFcrossNumToTurn() {
                        this.hasFcrossNumToTurn = false;
                        this.fcrossNumToTurn_ = 0;
                        return this;
                    }

                    public Links clearHasPanid() {
                        this.hasHasPanid = false;
                        this.hasPanid_ = 0;
                        return this;
                    }

                    public Links clearId() {
                        this.hasId = false;
                        this.id_ = "";
                        return this;
                    }

                    public Links clearIdx() {
                        this.hasIdx = false;
                        this.idx_ = 0;
                        return this;
                    }

                    public Links clearInnerCrossLink() {
                        this.hasInnerCrossLink = false;
                        this.innerCrossLink_ = 0;
                        return this;
                    }

                    public Links clearIsBindTrafficLight() {
                        this.hasIsBindTrafficLight = false;
                        this.isBindTrafficLight_ = 0;
                        return this;
                    }

                    public Links clearLength() {
                        this.hasLength = false;
                        this.length_ = 0;
                        return this;
                    }

                    public Links clearLinkAttr() {
                        this.hasLinkAttr = false;
                        this.linkAttr_ = 0;
                        return this;
                    }

                    public Links clearLinkType() {
                        this.hasLinkType = false;
                        this.linkType_ = 0;
                        return this;
                    }

                    public Links clearRoadLevel() {
                        this.hasRoadLevel = false;
                        this.roadLevel_ = 0;
                        return this;
                    }

                    public Links clearRoadWidth() {
                        this.hasRoadWidth = false;
                        this.roadWidth_ = 0;
                        return this;
                    }

                    public Links clearTrafficLight() {
                        this.hasTrafficLight = false;
                        this.trafficLight_ = 0;
                        return this;
                    }

                    public Links clearTurnLeftLampInfo() {
                        this.hasTurnLeftLampInfo = false;
                        this.turnLeftLampInfo_ = null;
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getFcrossDisToTurn() {
                        return this.fcrossDisToTurn_;
                    }

                    public int getFcrossNumToTurn() {
                        return this.fcrossNumToTurn_;
                    }

                    public int getHasPanid() {
                        return this.hasPanid_;
                    }

                    public String getId() {
                        return this.id_;
                    }

                    public int getIdx() {
                        return this.idx_;
                    }

                    public int getInnerCrossLink() {
                        return this.innerCrossLink_;
                    }

                    public int getIsBindTrafficLight() {
                        return this.isBindTrafficLight_;
                    }

                    public int getLength() {
                        return this.length_;
                    }

                    public int getLinkAttr() {
                        return this.linkAttr_;
                    }

                    public int getLinkType() {
                        return this.linkType_;
                    }

                    public int getRoadLevel() {
                        return this.roadLevel_;
                    }

                    public int getRoadWidth() {
                        return this.roadWidth_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasId() ? d.l(1, getId()) : 0;
                        if (hasIdx()) {
                            iL += d.e(2, getIdx());
                        }
                        if (hasLength()) {
                            iL += d.e(3, getLength());
                        }
                        if (hasHasPanid()) {
                            iL += d.e(4, getHasPanid());
                        }
                        if (hasLinkType()) {
                            iL += d.e(5, getLinkType());
                        }
                        if (hasLinkAttr()) {
                            iL += d.e(6, getLinkAttr());
                        }
                        if (hasFcrossNumToTurn()) {
                            iL += d.e(7, getFcrossNumToTurn());
                        }
                        if (hasFcrossDisToTurn()) {
                            iL += d.e(8, getFcrossDisToTurn());
                        }
                        if (hasRoadLevel()) {
                            iL += d.e(9, getRoadLevel());
                        }
                        if (hasRoadWidth()) {
                            iL += d.e(10, getRoadWidth());
                        }
                        if (hasTrafficLight()) {
                            iL += d.e(11, getTrafficLight());
                        }
                        if (hasInnerCrossLink()) {
                            iL += d.e(12, getInnerCrossLink());
                        }
                        if (hasIsBindTrafficLight()) {
                            iL += d.e(13, getIsBindTrafficLight());
                        }
                        if (hasTurnLeftLampInfo()) {
                            iL += d.h(14, getTurnLeftLampInfo());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public int getTrafficLight() {
                        return this.trafficLight_;
                    }

                    public TurnLeftLampInfo getTurnLeftLampInfo() {
                        return this.turnLeftLampInfo_;
                    }

                    public boolean hasFcrossDisToTurn() {
                        return this.hasFcrossDisToTurn;
                    }

                    public boolean hasFcrossNumToTurn() {
                        return this.hasFcrossNumToTurn;
                    }

                    public boolean hasHasPanid() {
                        return this.hasHasPanid;
                    }

                    public boolean hasId() {
                        return this.hasId;
                    }

                    public boolean hasIdx() {
                        return this.hasIdx;
                    }

                    public boolean hasInnerCrossLink() {
                        return this.hasInnerCrossLink;
                    }

                    public boolean hasIsBindTrafficLight() {
                        return this.hasIsBindTrafficLight;
                    }

                    public boolean hasLength() {
                        return this.hasLength;
                    }

                    public boolean hasLinkAttr() {
                        return this.hasLinkAttr;
                    }

                    public boolean hasLinkType() {
                        return this.hasLinkType;
                    }

                    public boolean hasRoadLevel() {
                        return this.hasRoadLevel;
                    }

                    public boolean hasRoadWidth() {
                        return this.hasRoadWidth;
                    }

                    public boolean hasTrafficLight() {
                        return this.hasTrafficLight;
                    }

                    public boolean hasTurnLeftLampInfo() {
                        return this.hasTurnLeftLampInfo;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Links setFcrossDisToTurn(int i4) {
                        this.hasFcrossDisToTurn = true;
                        this.fcrossDisToTurn_ = i4;
                        return this;
                    }

                    public Links setFcrossNumToTurn(int i4) {
                        this.hasFcrossNumToTurn = true;
                        this.fcrossNumToTurn_ = i4;
                        return this;
                    }

                    public Links setHasPanid(int i4) {
                        this.hasHasPanid = true;
                        this.hasPanid_ = i4;
                        return this;
                    }

                    public Links setId(String str) {
                        this.hasId = true;
                        this.id_ = str;
                        return this;
                    }

                    public Links setIdx(int i4) {
                        this.hasIdx = true;
                        this.idx_ = i4;
                        return this;
                    }

                    public Links setInnerCrossLink(int i4) {
                        this.hasInnerCrossLink = true;
                        this.innerCrossLink_ = i4;
                        return this;
                    }

                    public Links setIsBindTrafficLight(int i4) {
                        this.hasIsBindTrafficLight = true;
                        this.isBindTrafficLight_ = i4;
                        return this;
                    }

                    public Links setLength(int i4) {
                        this.hasLength = true;
                        this.length_ = i4;
                        return this;
                    }

                    public Links setLinkAttr(int i4) {
                        this.hasLinkAttr = true;
                        this.linkAttr_ = i4;
                        return this;
                    }

                    public Links setLinkType(int i4) {
                        this.hasLinkType = true;
                        this.linkType_ = i4;
                        return this;
                    }

                    public Links setRoadLevel(int i4) {
                        this.hasRoadLevel = true;
                        this.roadLevel_ = i4;
                        return this;
                    }

                    public Links setRoadWidth(int i4) {
                        this.hasRoadWidth = true;
                        this.roadWidth_ = i4;
                        return this;
                    }

                    public Links setTrafficLight(int i4) {
                        this.hasTrafficLight = true;
                        this.trafficLight_ = i4;
                        return this;
                    }

                    public Links setTurnLeftLampInfo(TurnLeftLampInfo turnLeftLampInfo) {
                        if (turnLeftLampInfo == null) {
                            return clearTurnLeftLampInfo();
                        }
                        this.hasTurnLeftLampInfo = true;
                        this.turnLeftLampInfo_ = turnLeftLampInfo;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasId()) {
                            dVar.A(1, getId());
                        }
                        if (hasIdx()) {
                            dVar.s(2, getIdx());
                        }
                        if (hasLength()) {
                            dVar.s(3, getLength());
                        }
                        if (hasHasPanid()) {
                            dVar.s(4, getHasPanid());
                        }
                        if (hasLinkType()) {
                            dVar.s(5, getLinkType());
                        }
                        if (hasLinkAttr()) {
                            dVar.s(6, getLinkAttr());
                        }
                        if (hasFcrossNumToTurn()) {
                            dVar.s(7, getFcrossNumToTurn());
                        }
                        if (hasFcrossDisToTurn()) {
                            dVar.s(8, getFcrossDisToTurn());
                        }
                        if (hasRoadLevel()) {
                            dVar.s(9, getRoadLevel());
                        }
                        if (hasRoadWidth()) {
                            dVar.s(10, getRoadWidth());
                        }
                        if (hasTrafficLight()) {
                            dVar.s(11, getTrafficLight());
                        }
                        if (hasInnerCrossLink()) {
                            dVar.s(12, getInnerCrossLink());
                        }
                        if (hasIsBindTrafficLight()) {
                            dVar.s(13, getIsBindTrafficLight());
                        }
                        if (hasTurnLeftLampInfo()) {
                            dVar.u(14, getTurnLeftLampInfo());
                        }
                    }

                    public static Links parseFrom(byte[] bArr) throws e {
                        return (Links) new Links().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Links mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            switch (iO) {
                                case 0:
                                    return this;
                                case 10:
                                    setId(bVar.n());
                                    break;
                                case 16:
                                    setIdx(bVar.k());
                                    break;
                                case 24:
                                    setLength(bVar.k());
                                    break;
                                case 32:
                                    setHasPanid(bVar.k());
                                    break;
                                case 40:
                                    setLinkType(bVar.k());
                                    break;
                                case 48:
                                    setLinkAttr(bVar.k());
                                    break;
                                case 56:
                                    setFcrossNumToTurn(bVar.k());
                                    break;
                                case 64:
                                    setFcrossDisToTurn(bVar.k());
                                    break;
                                case 72:
                                    setRoadLevel(bVar.k());
                                    break;
                                case 80:
                                    setRoadWidth(bVar.k());
                                    break;
                                case 88:
                                    setTrafficLight(bVar.k());
                                    break;
                                case 96:
                                    setInnerCrossLink(bVar.k());
                                    break;
                                case 104:
                                    setIsBindTrafficLight(bVar.k());
                                    break;
                                case 114:
                                    TurnLeftLampInfo turnLeftLampInfo = new TurnLeftLampInfo();
                                    bVar.f(turnLeftLampInfo);
                                    setTurnLeftLampInfo(turnLeftLampInfo);
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

                public static final class Pois extends f {
                    public static final int DISPLAY_PT_FIELD_NUMBER = 8;
                    public static final int DIST_TO_STEP_ST_FIELD_NUMBER = 17;
                    public static final int END_ADDDIST_FIELD_NUMBER = 15;
                    public static final int FACE_PICTURE_URL_FIELD_NUMBER = 10;
                    public static final int FACE_PIC_LONG_FIELD_NUMBER = 12;
                    public static final int FACE_PIC_WIDE_FIELD_NUMBER = 13;
                    public static final int HEADING_FIELD_NUMBER = 4;
                    public static final int ICON_URL_FIELD_NUMBER = 9;
                    public static final int NAME_FIELD_NUMBER = 1;
                    public static final int PANOID_FIELD_NUMBER = 6;
                    public static final int PITCH_FIELD_NUMBER = 5;
                    public static final int SIDE_FIELD_NUMBER = 3;
                    public static final int SLOCATION_FIELD_NUMBER = 2;
                    public static final int START_ADDDIST_FIELD_NUMBER = 14;
                    public static final int STD_TAG_FIELD_NUMBER = 11;
                    public static final int TYPE_FIELD_NUMBER = 16;
                    public static final int UID_FIELD_NUMBER = 7;
                    private boolean hasDistToStepSt;
                    private boolean hasEndAdddist;
                    private boolean hasFacePicLong;
                    private boolean hasFacePicWide;
                    private boolean hasFacePictureUrl;
                    private boolean hasHeading;
                    private boolean hasIconUrl;
                    private boolean hasName;
                    private boolean hasPanoid;
                    private boolean hasPitch;
                    private boolean hasSide;
                    private boolean hasStartAdddist;
                    private boolean hasStdTag;
                    private boolean hasType;
                    private boolean hasUid;
                    private String name_ = "";
                    private List<Integer> slocation_ = Collections.emptyList();
                    private int side_ = 0;
                    private String heading_ = "";
                    private String pitch_ = "";
                    private String panoid_ = "";
                    private String uid_ = "";
                    private List<Integer> displayPt_ = Collections.emptyList();
                    private String iconUrl_ = "";
                    private String facePictureUrl_ = "";
                    private String stdTag_ = "";
                    private int facePicLong_ = 0;
                    private int facePicWide_ = 0;
                    private int startAdddist_ = 0;
                    private int endAdddist_ = 0;
                    private int type_ = 0;
                    private int distToStepSt_ = 0;
                    private int cachedSize = -1;

                    public static Pois parseFrom(b bVar) throws IOException {
                        return new Pois().mergeFrom(bVar);
                    }

                    public Pois addDisplayPt(int i4) {
                        if (this.displayPt_.isEmpty()) {
                            this.displayPt_ = new ArrayList();
                        }
                        this.displayPt_.add(Integer.valueOf(i4));
                        return this;
                    }

                    public Pois addSlocation(int i4) {
                        if (this.slocation_.isEmpty()) {
                            this.slocation_ = new ArrayList();
                        }
                        this.slocation_.add(Integer.valueOf(i4));
                        return this;
                    }

                    public final Pois clear() {
                        clearName();
                        clearSlocation();
                        clearSide();
                        clearHeading();
                        clearPitch();
                        clearPanoid();
                        clearUid();
                        clearDisplayPt();
                        clearIconUrl();
                        clearFacePictureUrl();
                        clearStdTag();
                        clearFacePicLong();
                        clearFacePicWide();
                        clearStartAdddist();
                        clearEndAdddist();
                        clearType();
                        clearDistToStepSt();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Pois clearDisplayPt() {
                        this.displayPt_ = Collections.emptyList();
                        return this;
                    }

                    public Pois clearDistToStepSt() {
                        this.hasDistToStepSt = false;
                        this.distToStepSt_ = 0;
                        return this;
                    }

                    public Pois clearEndAdddist() {
                        this.hasEndAdddist = false;
                        this.endAdddist_ = 0;
                        return this;
                    }

                    public Pois clearFacePicLong() {
                        this.hasFacePicLong = false;
                        this.facePicLong_ = 0;
                        return this;
                    }

                    public Pois clearFacePicWide() {
                        this.hasFacePicWide = false;
                        this.facePicWide_ = 0;
                        return this;
                    }

                    public Pois clearFacePictureUrl() {
                        this.hasFacePictureUrl = false;
                        this.facePictureUrl_ = "";
                        return this;
                    }

                    public Pois clearHeading() {
                        this.hasHeading = false;
                        this.heading_ = "";
                        return this;
                    }

                    public Pois clearIconUrl() {
                        this.hasIconUrl = false;
                        this.iconUrl_ = "";
                        return this;
                    }

                    public Pois clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    public Pois clearPanoid() {
                        this.hasPanoid = false;
                        this.panoid_ = "";
                        return this;
                    }

                    public Pois clearPitch() {
                        this.hasPitch = false;
                        this.pitch_ = "";
                        return this;
                    }

                    public Pois clearSide() {
                        this.hasSide = false;
                        this.side_ = 0;
                        return this;
                    }

                    public Pois clearSlocation() {
                        this.slocation_ = Collections.emptyList();
                        return this;
                    }

                    public Pois clearStartAdddist() {
                        this.hasStartAdddist = false;
                        this.startAdddist_ = 0;
                        return this;
                    }

                    public Pois clearStdTag() {
                        this.hasStdTag = false;
                        this.stdTag_ = "";
                        return this;
                    }

                    public Pois clearType() {
                        this.hasType = false;
                        this.type_ = 0;
                        return this;
                    }

                    public Pois clearUid() {
                        this.hasUid = false;
                        this.uid_ = "";
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getDisplayPt(int i4) {
                        return this.displayPt_.get(i4).intValue();
                    }

                    public int getDisplayPtCount() {
                        return this.displayPt_.size();
                    }

                    public List<Integer> getDisplayPtList() {
                        return this.displayPt_;
                    }

                    public int getDistToStepSt() {
                        return this.distToStepSt_;
                    }

                    public int getEndAdddist() {
                        return this.endAdddist_;
                    }

                    public int getFacePicLong() {
                        return this.facePicLong_;
                    }

                    public int getFacePicWide() {
                        return this.facePicWide_;
                    }

                    public String getFacePictureUrl() {
                        return this.facePictureUrl_;
                    }

                    public String getHeading() {
                        return this.heading_;
                    }

                    public String getIconUrl() {
                        return this.iconUrl_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    public String getPanoid() {
                        return this.panoid_;
                    }

                    public String getPitch() {
                        return this.pitch_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iG = 0;
                        int iL = hasName() ? d.l(1, getName()) : 0;
                        Iterator<Integer> it = getSlocationList().iterator();
                        int iG2 = 0;
                        while (it.hasNext()) {
                            iG2 = g.g(it.next(), iG2);
                        }
                        int size = getSlocationList().size() + iL + iG2;
                        if (hasSide()) {
                            size += d.e(3, getSide());
                        }
                        if (hasHeading()) {
                            size += d.l(4, getHeading());
                        }
                        if (hasPitch()) {
                            size += d.l(5, getPitch());
                        }
                        if (hasPanoid()) {
                            size += d.l(6, getPanoid());
                        }
                        if (hasUid()) {
                            size += d.l(7, getUid());
                        }
                        Iterator<Integer> it2 = getDisplayPtList().iterator();
                        while (it2.hasNext()) {
                            iG = g.g(it2.next(), iG);
                        }
                        int size2 = getDisplayPtList().size() + size + iG;
                        if (hasIconUrl()) {
                            size2 += d.l(9, getIconUrl());
                        }
                        if (hasFacePictureUrl()) {
                            size2 += d.l(10, getFacePictureUrl());
                        }
                        if (hasStdTag()) {
                            size2 += d.l(11, getStdTag());
                        }
                        if (hasFacePicLong()) {
                            size2 += d.e(12, getFacePicLong());
                        }
                        if (hasFacePicWide()) {
                            size2 += d.e(13, getFacePicWide());
                        }
                        if (hasStartAdddist()) {
                            size2 += d.e(14, getStartAdddist());
                        }
                        if (hasEndAdddist()) {
                            size2 += d.e(15, getEndAdddist());
                        }
                        if (hasType()) {
                            size2 += d.e(16, getType());
                        }
                        if (hasDistToStepSt()) {
                            size2 += d.e(17, getDistToStepSt());
                        }
                        this.cachedSize = size2;
                        return size2;
                    }

                    public int getSide() {
                        return this.side_;
                    }

                    public int getSlocation(int i4) {
                        return this.slocation_.get(i4).intValue();
                    }

                    public int getSlocationCount() {
                        return this.slocation_.size();
                    }

                    public List<Integer> getSlocationList() {
                        return this.slocation_;
                    }

                    public int getStartAdddist() {
                        return this.startAdddist_;
                    }

                    public String getStdTag() {
                        return this.stdTag_;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public String getUid() {
                        return this.uid_;
                    }

                    public boolean hasDistToStepSt() {
                        return this.hasDistToStepSt;
                    }

                    public boolean hasEndAdddist() {
                        return this.hasEndAdddist;
                    }

                    public boolean hasFacePicLong() {
                        return this.hasFacePicLong;
                    }

                    public boolean hasFacePicWide() {
                        return this.hasFacePicWide;
                    }

                    public boolean hasFacePictureUrl() {
                        return this.hasFacePictureUrl;
                    }

                    public boolean hasHeading() {
                        return this.hasHeading;
                    }

                    public boolean hasIconUrl() {
                        return this.hasIconUrl;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public boolean hasPanoid() {
                        return this.hasPanoid;
                    }

                    public boolean hasPitch() {
                        return this.hasPitch;
                    }

                    public boolean hasSide() {
                        return this.hasSide;
                    }

                    public boolean hasStartAdddist() {
                        return this.hasStartAdddist;
                    }

                    public boolean hasStdTag() {
                        return this.hasStdTag;
                    }

                    public boolean hasType() {
                        return this.hasType;
                    }

                    public boolean hasUid() {
                        return this.hasUid;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Pois setDisplayPt(int i4, int i5) {
                        this.displayPt_.set(i4, Integer.valueOf(i5));
                        return this;
                    }

                    public Pois setDistToStepSt(int i4) {
                        this.hasDistToStepSt = true;
                        this.distToStepSt_ = i4;
                        return this;
                    }

                    public Pois setEndAdddist(int i4) {
                        this.hasEndAdddist = true;
                        this.endAdddist_ = i4;
                        return this;
                    }

                    public Pois setFacePicLong(int i4) {
                        this.hasFacePicLong = true;
                        this.facePicLong_ = i4;
                        return this;
                    }

                    public Pois setFacePicWide(int i4) {
                        this.hasFacePicWide = true;
                        this.facePicWide_ = i4;
                        return this;
                    }

                    public Pois setFacePictureUrl(String str) {
                        this.hasFacePictureUrl = true;
                        this.facePictureUrl_ = str;
                        return this;
                    }

                    public Pois setHeading(String str) {
                        this.hasHeading = true;
                        this.heading_ = str;
                        return this;
                    }

                    public Pois setIconUrl(String str) {
                        this.hasIconUrl = true;
                        this.iconUrl_ = str;
                        return this;
                    }

                    public Pois setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    public Pois setPanoid(String str) {
                        this.hasPanoid = true;
                        this.panoid_ = str;
                        return this;
                    }

                    public Pois setPitch(String str) {
                        this.hasPitch = true;
                        this.pitch_ = str;
                        return this;
                    }

                    public Pois setSide(int i4) {
                        this.hasSide = true;
                        this.side_ = i4;
                        return this;
                    }

                    public Pois setSlocation(int i4, int i5) {
                        this.slocation_.set(i4, Integer.valueOf(i5));
                        return this;
                    }

                    public Pois setStartAdddist(int i4) {
                        this.hasStartAdddist = true;
                        this.startAdddist_ = i4;
                        return this;
                    }

                    public Pois setStdTag(String str) {
                        this.hasStdTag = true;
                        this.stdTag_ = str;
                        return this;
                    }

                    public Pois setType(int i4) {
                        this.hasType = true;
                        this.type_ = i4;
                        return this;
                    }

                    public Pois setUid(String str) {
                        this.hasUid = true;
                        this.uid_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasName()) {
                            dVar.A(1, getName());
                        }
                        Iterator<Integer> it = getSlocationList().iterator();
                        while (it.hasNext()) {
                            dVar.z(2, it.next().intValue());
                        }
                        if (hasSide()) {
                            dVar.s(3, getSide());
                        }
                        if (hasHeading()) {
                            dVar.A(4, getHeading());
                        }
                        if (hasPitch()) {
                            dVar.A(5, getPitch());
                        }
                        if (hasPanoid()) {
                            dVar.A(6, getPanoid());
                        }
                        if (hasUid()) {
                            dVar.A(7, getUid());
                        }
                        Iterator<Integer> it2 = getDisplayPtList().iterator();
                        while (it2.hasNext()) {
                            dVar.z(8, it2.next().intValue());
                        }
                        if (hasIconUrl()) {
                            dVar.A(9, getIconUrl());
                        }
                        if (hasFacePictureUrl()) {
                            dVar.A(10, getFacePictureUrl());
                        }
                        if (hasStdTag()) {
                            dVar.A(11, getStdTag());
                        }
                        if (hasFacePicLong()) {
                            dVar.s(12, getFacePicLong());
                        }
                        if (hasFacePicWide()) {
                            dVar.s(13, getFacePicWide());
                        }
                        if (hasStartAdddist()) {
                            dVar.s(14, getStartAdddist());
                        }
                        if (hasEndAdddist()) {
                            dVar.s(15, getEndAdddist());
                        }
                        if (hasType()) {
                            dVar.s(16, getType());
                        }
                        if (hasDistToStepSt()) {
                            dVar.s(17, getDistToStepSt());
                        }
                    }

                    public static Pois parseFrom(byte[] bArr) throws e {
                        return (Pois) new Pois().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Pois mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            switch (iO) {
                                case 0:
                                    return this;
                                case 10:
                                    setName(bVar.n());
                                    break;
                                case 16:
                                    addSlocation(bVar.m());
                                    break;
                                case 24:
                                    setSide(bVar.k());
                                    break;
                                case 34:
                                    setHeading(bVar.n());
                                    break;
                                case 42:
                                    setPitch(bVar.n());
                                    break;
                                case 50:
                                    setPanoid(bVar.n());
                                    break;
                                case 58:
                                    setUid(bVar.n());
                                    break;
                                case 64:
                                    addDisplayPt(bVar.m());
                                    break;
                                case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                                    setIconUrl(bVar.n());
                                    break;
                                case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                                    setFacePictureUrl(bVar.n());
                                    break;
                                case 90:
                                    setStdTag(bVar.n());
                                    break;
                                case 96:
                                    setFacePicLong(bVar.k());
                                    break;
                                case 104:
                                    setFacePicWide(bVar.k());
                                    break;
                                case 112:
                                    setStartAdddist(bVar.k());
                                    break;
                                case SyslogConstants.LOG_CLOCK /* 120 */:
                                    setEndAdddist(bVar.k());
                                    break;
                                case 128:
                                    setType(bVar.k());
                                    break;
                                case SyslogConstants.LOG_LOCAL1 /* 136 */:
                                    setDistToStepSt(bVar.k());
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

                public static Steps parseFrom(b bVar) throws IOException {
                    return new Steps().mergeFrom(bVar);
                }

                public Steps addCloudGuideV1(DetailGuideInfoV1 detailGuideInfoV1) {
                    if (detailGuideInfoV1 == null) {
                        return this;
                    }
                    if (this.cloudGuideV1_.isEmpty()) {
                        this.cloudGuideV1_ = new ArrayList();
                    }
                    this.cloudGuideV1_.add(detailGuideInfoV1);
                    return this;
                }

                public Steps addCloudGuideV2(DetailGuideInfoV2 detailGuideInfoV2) {
                    if (detailGuideInfoV2 == null) {
                        return this;
                    }
                    if (this.cloudGuideV2_.isEmpty()) {
                        this.cloudGuideV2_ = new ArrayList();
                    }
                    this.cloudGuideV2_.add(detailGuideInfoV2);
                    return this;
                }

                public Steps addCloudGuideV3(DetailGuideInfoV3 detailGuideInfoV3) {
                    if (detailGuideInfoV3 == null) {
                        return this;
                    }
                    if (this.cloudGuideV3_.isEmpty()) {
                        this.cloudGuideV3_ = new ArrayList();
                    }
                    this.cloudGuideV3_.add(detailGuideInfoV3);
                    return this;
                }

                public Steps addLinks(Links links) {
                    if (links == null) {
                        return this;
                    }
                    if (this.links_.isEmpty()) {
                        this.links_ = new ArrayList();
                    }
                    this.links_.add(links);
                    return this;
                }

                public Steps addPoirefPois(Pois pois) {
                    if (pois == null) {
                        return this;
                    }
                    if (this.poirefPois_.isEmpty()) {
                        this.poirefPois_ = new ArrayList();
                    }
                    this.poirefPois_.add(pois);
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

                public Steps addSendLocation(int i4) {
                    if (this.sendLocation_.isEmpty()) {
                        this.sendLocation_ = new ArrayList();
                    }
                    this.sendLocation_.add(Integer.valueOf(i4));
                    return this;
                }

                public Steps addSpath(int i4) {
                    if (this.spath_.isEmpty()) {
                        this.spath_ = new ArrayList();
                    }
                    this.spath_.add(Integer.valueOf(i4));
                    return this;
                }

                public Steps addSpath4Navi(int i4) {
                    if (this.spath4Navi_.isEmpty()) {
                        this.spath4Navi_ = new ArrayList();
                    }
                    this.spath4Navi_.add(Integer.valueOf(i4));
                    return this;
                }

                public Steps addSstartLocation(int i4) {
                    if (this.sstartLocation_.isEmpty()) {
                        this.sstartLocation_ = new ArrayList();
                    }
                    this.sstartLocation_.add(Integer.valueOf(i4));
                    return this;
                }

                public Steps addStrafficmarkLoc(int i4) {
                    if (this.strafficmarkLoc_.isEmpty()) {
                        this.strafficmarkLoc_ = new ArrayList();
                    }
                    this.strafficmarkLoc_.add(Integer.valueOf(i4));
                    return this;
                }

                public final Steps clear() {
                    clearLinks();
                    clearPois();
                    clearSpath();
                    clearInstructions();
                    clearType();
                    clearName();
                    clearFirstLinkEndIndex();
                    clearTurnType();
                    clearWalkType();
                    clearLight();
                    clearCircleRoad();
                    clearRoadWidth();
                    clearDistance();
                    clearDuration();
                    clearDirection();
                    clearHasPanid();
                    clearSstartLocation();
                    clearSendLocation();
                    clearStrafficmarkLoc();
                    clearTrafficType();
                    clearSpath4Navi();
                    clearStepStatus();
                    clearPoirefPois();
                    clearCloudGuideV1();
                    clearCloudGuideV2();
                    clearGuideType();
                    clearCloudGuideV3();
                    this.cachedSize = -1;
                    return this;
                }

                public Steps clearCircleRoad() {
                    this.hasCircleRoad = false;
                    this.circleRoad_ = 0;
                    return this;
                }

                public Steps clearCloudGuideV1() {
                    this.cloudGuideV1_ = Collections.emptyList();
                    return this;
                }

                public Steps clearCloudGuideV2() {
                    this.cloudGuideV2_ = Collections.emptyList();
                    return this;
                }

                public Steps clearCloudGuideV3() {
                    this.cloudGuideV3_ = Collections.emptyList();
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

                public Steps clearFirstLinkEndIndex() {
                    this.hasFirstLinkEndIndex = false;
                    this.firstLinkEndIndex_ = 0;
                    return this;
                }

                public Steps clearGuideType() {
                    this.hasGuideType = false;
                    this.guideType_ = 0;
                    return this;
                }

                public Steps clearHasPanid() {
                    this.hasHasPanid = false;
                    this.hasPanid_ = 0;
                    return this;
                }

                public Steps clearInstructions() {
                    this.hasInstructions = false;
                    this.instructions_ = "";
                    return this;
                }

                public Steps clearLight() {
                    this.hasLight = false;
                    this.light_ = 0;
                    return this;
                }

                public Steps clearLinks() {
                    this.links_ = Collections.emptyList();
                    return this;
                }

                public Steps clearName() {
                    this.hasName = false;
                    this.name_ = "";
                    return this;
                }

                public Steps clearPoirefPois() {
                    this.poirefPois_ = Collections.emptyList();
                    return this;
                }

                public Steps clearPois() {
                    this.pois_ = Collections.emptyList();
                    return this;
                }

                public Steps clearRoadWidth() {
                    this.hasRoadWidth = false;
                    this.roadWidth_ = 0;
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

                public Steps clearSpath4Navi() {
                    this.spath4Navi_ = Collections.emptyList();
                    return this;
                }

                public Steps clearSstartLocation() {
                    this.sstartLocation_ = Collections.emptyList();
                    return this;
                }

                public Steps clearStepStatus() {
                    this.hasStepStatus = false;
                    this.stepStatus_ = 0;
                    return this;
                }

                public Steps clearStrafficmarkLoc() {
                    this.strafficmarkLoc_ = Collections.emptyList();
                    return this;
                }

                public Steps clearTrafficType() {
                    this.hasTrafficType = false;
                    this.trafficType_ = 0;
                    return this;
                }

                public Steps clearTurnType() {
                    this.hasTurnType = false;
                    this.turnType_ = 0;
                    return this;
                }

                public Steps clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                public Steps clearWalkType() {
                    this.hasWalkType = false;
                    this.walkType_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCircleRoad() {
                    return this.circleRoad_;
                }

                public DetailGuideInfoV1 getCloudGuideV1(int i4) {
                    return this.cloudGuideV1_.get(i4);
                }

                public int getCloudGuideV1Count() {
                    return this.cloudGuideV1_.size();
                }

                public List<DetailGuideInfoV1> getCloudGuideV1List() {
                    return this.cloudGuideV1_;
                }

                public DetailGuideInfoV2 getCloudGuideV2(int i4) {
                    return this.cloudGuideV2_.get(i4);
                }

                public int getCloudGuideV2Count() {
                    return this.cloudGuideV2_.size();
                }

                public List<DetailGuideInfoV2> getCloudGuideV2List() {
                    return this.cloudGuideV2_;
                }

                public DetailGuideInfoV3 getCloudGuideV3(int i4) {
                    return this.cloudGuideV3_.get(i4);
                }

                public int getCloudGuideV3Count() {
                    return this.cloudGuideV3_.size();
                }

                public List<DetailGuideInfoV3> getCloudGuideV3List() {
                    return this.cloudGuideV3_;
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

                public int getFirstLinkEndIndex() {
                    return this.firstLinkEndIndex_;
                }

                public int getGuideType() {
                    return this.guideType_;
                }

                public int getHasPanid() {
                    return this.hasPanid_;
                }

                public String getInstructions() {
                    return this.instructions_;
                }

                public int getLight() {
                    return this.light_;
                }

                public Links getLinks(int i4) {
                    return this.links_.get(i4);
                }

                public int getLinksCount() {
                    return this.links_.size();
                }

                public List<Links> getLinksList() {
                    return this.links_;
                }

                public String getName() {
                    return this.name_;
                }

                public Pois getPoirefPois(int i4) {
                    return this.poirefPois_.get(i4);
                }

                public int getPoirefPoisCount() {
                    return this.poirefPois_.size();
                }

                public List<Pois> getPoirefPoisList() {
                    return this.poirefPois_;
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

                public int getRoadWidth() {
                    return this.roadWidth_;
                }

                public int getSendLocation(int i4) {
                    return this.sendLocation_.get(i4).intValue();
                }

                public int getSendLocationCount() {
                    return this.sendLocation_.size();
                }

                public List<Integer> getSendLocationList() {
                    return this.sendLocation_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    Iterator<Integer> it = getSpathList().iterator();
                    int iG = 0;
                    int iG2 = 0;
                    while (it.hasNext()) {
                        iG2 = g.g(it.next(), iG2);
                    }
                    int size = getSpathList().size() + iG2;
                    if (hasInstructions()) {
                        size += d.l(2, getInstructions());
                    }
                    if (hasType()) {
                        size += d.e(3, getType());
                    }
                    if (hasName()) {
                        size += d.l(4, getName());
                    }
                    if (hasFirstLinkEndIndex()) {
                        size += d.e(5, getFirstLinkEndIndex());
                    }
                    if (hasTurnType()) {
                        size += d.e(6, getTurnType());
                    }
                    if (hasWalkType()) {
                        size += d.e(7, getWalkType());
                    }
                    if (hasLight()) {
                        size += d.e(8, getLight());
                    }
                    if (hasCircleRoad()) {
                        size += d.e(9, getCircleRoad());
                    }
                    if (hasRoadWidth()) {
                        size += d.e(10, getRoadWidth());
                    }
                    if (hasDistance()) {
                        size += d.e(11, getDistance());
                    }
                    if (hasDuration()) {
                        size += d.e(12, getDuration());
                    }
                    Iterator<Links> it2 = getLinksList().iterator();
                    while (it2.hasNext()) {
                        size += d.h(13, it2.next());
                    }
                    Iterator<Pois> it3 = getPoisList().iterator();
                    while (it3.hasNext()) {
                        size += d.h(14, it3.next());
                    }
                    if (hasDirection()) {
                        size += d.e(15, getDirection());
                    }
                    if (hasHasPanid()) {
                        size += d.e(16, getHasPanid());
                    }
                    Iterator<Integer> it4 = getSstartLocationList().iterator();
                    int iG3 = 0;
                    while (it4.hasNext()) {
                        iG3 = g.g(it4.next(), iG3);
                    }
                    int size2 = (getSstartLocationList().size() * 2) + size + iG3;
                    Iterator<Integer> it5 = getSendLocationList().iterator();
                    int iG4 = 0;
                    while (it5.hasNext()) {
                        iG4 = g.g(it5.next(), iG4);
                    }
                    int size3 = (getSendLocationList().size() * 2) + size2 + iG4;
                    Iterator<Integer> it6 = getStrafficmarkLocList().iterator();
                    int iF = 0;
                    while (it6.hasNext()) {
                        iF += d.f(it6.next().intValue());
                    }
                    int size4 = (getStrafficmarkLocList().size() * 2) + size3 + iF;
                    if (hasTrafficType()) {
                        size4 += d.e(20, getTrafficType());
                    }
                    Iterator<Integer> it7 = getSpath4NaviList().iterator();
                    while (it7.hasNext()) {
                        iG = g.g(it7.next(), iG);
                    }
                    int size5 = (getSpath4NaviList().size() * 2) + size4 + iG;
                    if (hasStepStatus()) {
                        size5 += d.e(22, getStepStatus());
                    }
                    Iterator<Pois> it8 = getPoirefPoisList().iterator();
                    while (it8.hasNext()) {
                        size5 += d.h(23, it8.next());
                    }
                    Iterator<DetailGuideInfoV1> it9 = getCloudGuideV1List().iterator();
                    while (it9.hasNext()) {
                        size5 += d.h(24, it9.next());
                    }
                    Iterator<DetailGuideInfoV2> it10 = getCloudGuideV2List().iterator();
                    while (it10.hasNext()) {
                        size5 += d.h(25, it10.next());
                    }
                    if (hasGuideType()) {
                        size5 += d.e(26, getGuideType());
                    }
                    Iterator<DetailGuideInfoV3> it11 = getCloudGuideV3List().iterator();
                    while (it11.hasNext()) {
                        size5 += d.h(27, it11.next());
                    }
                    this.cachedSize = size5;
                    return size5;
                }

                public int getSpath(int i4) {
                    return this.spath_.get(i4).intValue();
                }

                public int getSpath4Navi(int i4) {
                    return this.spath4Navi_.get(i4).intValue();
                }

                public int getSpath4NaviCount() {
                    return this.spath4Navi_.size();
                }

                public List<Integer> getSpath4NaviList() {
                    return this.spath4Navi_;
                }

                public int getSpathCount() {
                    return this.spath_.size();
                }

                public List<Integer> getSpathList() {
                    return this.spath_;
                }

                public int getSstartLocation(int i4) {
                    return this.sstartLocation_.get(i4).intValue();
                }

                public int getSstartLocationCount() {
                    return this.sstartLocation_.size();
                }

                public List<Integer> getSstartLocationList() {
                    return this.sstartLocation_;
                }

                public int getStepStatus() {
                    return this.stepStatus_;
                }

                public int getStrafficmarkLoc(int i4) {
                    return this.strafficmarkLoc_.get(i4).intValue();
                }

                public int getStrafficmarkLocCount() {
                    return this.strafficmarkLoc_.size();
                }

                public List<Integer> getStrafficmarkLocList() {
                    return this.strafficmarkLoc_;
                }

                public int getTrafficType() {
                    return this.trafficType_;
                }

                public int getTurnType() {
                    return this.turnType_;
                }

                public int getType() {
                    return this.type_;
                }

                public int getWalkType() {
                    return this.walkType_;
                }

                public boolean hasCircleRoad() {
                    return this.hasCircleRoad;
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

                public boolean hasFirstLinkEndIndex() {
                    return this.hasFirstLinkEndIndex;
                }

                public boolean hasGuideType() {
                    return this.hasGuideType;
                }

                public boolean hasHasPanid() {
                    return this.hasHasPanid;
                }

                public boolean hasInstructions() {
                    return this.hasInstructions;
                }

                public boolean hasLight() {
                    return this.hasLight;
                }

                public boolean hasName() {
                    return this.hasName;
                }

                public boolean hasRoadWidth() {
                    return this.hasRoadWidth;
                }

                public boolean hasStepStatus() {
                    return this.hasStepStatus;
                }

                public boolean hasTrafficType() {
                    return this.hasTrafficType;
                }

                public boolean hasTurnType() {
                    return this.hasTurnType;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public boolean hasWalkType() {
                    return this.hasWalkType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Steps setCircleRoad(int i4) {
                    this.hasCircleRoad = true;
                    this.circleRoad_ = i4;
                    return this;
                }

                public Steps setCloudGuideV1(int i4, DetailGuideInfoV1 detailGuideInfoV1) {
                    if (detailGuideInfoV1 == null) {
                        return this;
                    }
                    this.cloudGuideV1_.set(i4, detailGuideInfoV1);
                    return this;
                }

                public Steps setCloudGuideV2(int i4, DetailGuideInfoV2 detailGuideInfoV2) {
                    if (detailGuideInfoV2 == null) {
                        return this;
                    }
                    this.cloudGuideV2_.set(i4, detailGuideInfoV2);
                    return this;
                }

                public Steps setCloudGuideV3(int i4, DetailGuideInfoV3 detailGuideInfoV3) {
                    if (detailGuideInfoV3 == null) {
                        return this;
                    }
                    this.cloudGuideV3_.set(i4, detailGuideInfoV3);
                    return this;
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

                public Steps setFirstLinkEndIndex(int i4) {
                    this.hasFirstLinkEndIndex = true;
                    this.firstLinkEndIndex_ = i4;
                    return this;
                }

                public Steps setGuideType(int i4) {
                    this.hasGuideType = true;
                    this.guideType_ = i4;
                    return this;
                }

                public Steps setHasPanid(int i4) {
                    this.hasHasPanid = true;
                    this.hasPanid_ = i4;
                    return this;
                }

                public Steps setInstructions(String str) {
                    this.hasInstructions = true;
                    this.instructions_ = str;
                    return this;
                }

                public Steps setLight(int i4) {
                    this.hasLight = true;
                    this.light_ = i4;
                    return this;
                }

                public Steps setLinks(int i4, Links links) {
                    if (links == null) {
                        return this;
                    }
                    this.links_.set(i4, links);
                    return this;
                }

                public Steps setName(String str) {
                    this.hasName = true;
                    this.name_ = str;
                    return this;
                }

                public Steps setPoirefPois(int i4, Pois pois) {
                    if (pois == null) {
                        return this;
                    }
                    this.poirefPois_.set(i4, pois);
                    return this;
                }

                public Steps setPois(int i4, Pois pois) {
                    if (pois == null) {
                        return this;
                    }
                    this.pois_.set(i4, pois);
                    return this;
                }

                public Steps setRoadWidth(int i4) {
                    this.hasRoadWidth = true;
                    this.roadWidth_ = i4;
                    return this;
                }

                public Steps setSendLocation(int i4, int i5) {
                    this.sendLocation_.set(i4, Integer.valueOf(i5));
                    return this;
                }

                public Steps setSpath(int i4, int i5) {
                    this.spath_.set(i4, Integer.valueOf(i5));
                    return this;
                }

                public Steps setSpath4Navi(int i4, int i5) {
                    this.spath4Navi_.set(i4, Integer.valueOf(i5));
                    return this;
                }

                public Steps setSstartLocation(int i4, int i5) {
                    this.sstartLocation_.set(i4, Integer.valueOf(i5));
                    return this;
                }

                public Steps setStepStatus(int i4) {
                    this.hasStepStatus = true;
                    this.stepStatus_ = i4;
                    return this;
                }

                public Steps setStrafficmarkLoc(int i4, int i5) {
                    this.strafficmarkLoc_.set(i4, Integer.valueOf(i5));
                    return this;
                }

                public Steps setTrafficType(int i4) {
                    this.hasTrafficType = true;
                    this.trafficType_ = i4;
                    return this;
                }

                public Steps setTurnType(int i4) {
                    this.hasTurnType = true;
                    this.turnType_ = i4;
                    return this;
                }

                public Steps setType(int i4) {
                    this.hasType = true;
                    this.type_ = i4;
                    return this;
                }

                public Steps setWalkType(int i4) {
                    this.hasWalkType = true;
                    this.walkType_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    Iterator<Integer> it = getSpathList().iterator();
                    while (it.hasNext()) {
                        dVar.z(1, it.next().intValue());
                    }
                    if (hasInstructions()) {
                        dVar.A(2, getInstructions());
                    }
                    if (hasType()) {
                        dVar.s(3, getType());
                    }
                    if (hasName()) {
                        dVar.A(4, getName());
                    }
                    if (hasFirstLinkEndIndex()) {
                        dVar.s(5, getFirstLinkEndIndex());
                    }
                    if (hasTurnType()) {
                        dVar.s(6, getTurnType());
                    }
                    if (hasWalkType()) {
                        dVar.s(7, getWalkType());
                    }
                    if (hasLight()) {
                        dVar.s(8, getLight());
                    }
                    if (hasCircleRoad()) {
                        dVar.s(9, getCircleRoad());
                    }
                    if (hasRoadWidth()) {
                        dVar.s(10, getRoadWidth());
                    }
                    if (hasDistance()) {
                        dVar.s(11, getDistance());
                    }
                    if (hasDuration()) {
                        dVar.s(12, getDuration());
                    }
                    Iterator<Links> it2 = getLinksList().iterator();
                    while (it2.hasNext()) {
                        dVar.u(13, it2.next());
                    }
                    Iterator<Pois> it3 = getPoisList().iterator();
                    while (it3.hasNext()) {
                        dVar.u(14, it3.next());
                    }
                    if (hasDirection()) {
                        dVar.s(15, getDirection());
                    }
                    if (hasHasPanid()) {
                        dVar.s(16, getHasPanid());
                    }
                    Iterator<Integer> it4 = getSstartLocationList().iterator();
                    while (it4.hasNext()) {
                        dVar.z(17, it4.next().intValue());
                    }
                    Iterator<Integer> it5 = getSendLocationList().iterator();
                    while (it5.hasNext()) {
                        dVar.z(18, it5.next().intValue());
                    }
                    Iterator<Integer> it6 = getStrafficmarkLocList().iterator();
                    while (it6.hasNext()) {
                        dVar.s(19, it6.next().intValue());
                    }
                    if (hasTrafficType()) {
                        dVar.s(20, getTrafficType());
                    }
                    Iterator<Integer> it7 = getSpath4NaviList().iterator();
                    while (it7.hasNext()) {
                        dVar.z(21, it7.next().intValue());
                    }
                    if (hasStepStatus()) {
                        dVar.s(22, getStepStatus());
                    }
                    Iterator<Pois> it8 = getPoirefPoisList().iterator();
                    while (it8.hasNext()) {
                        dVar.u(23, it8.next());
                    }
                    Iterator<DetailGuideInfoV1> it9 = getCloudGuideV1List().iterator();
                    while (it9.hasNext()) {
                        dVar.u(24, it9.next());
                    }
                    Iterator<DetailGuideInfoV2> it10 = getCloudGuideV2List().iterator();
                    while (it10.hasNext()) {
                        dVar.u(25, it10.next());
                    }
                    if (hasGuideType()) {
                        dVar.s(26, getGuideType());
                    }
                    Iterator<DetailGuideInfoV3> it11 = getCloudGuideV3List().iterator();
                    while (it11.hasNext()) {
                        dVar.u(27, it11.next());
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
                                addSpath(bVar.m());
                                break;
                            case 18:
                                setInstructions(bVar.n());
                                break;
                            case 24:
                                setType(bVar.k());
                                break;
                            case 34:
                                setName(bVar.n());
                                break;
                            case 40:
                                setFirstLinkEndIndex(bVar.k());
                                break;
                            case 48:
                                setTurnType(bVar.k());
                                break;
                            case 56:
                                setWalkType(bVar.k());
                                break;
                            case 64:
                                setLight(bVar.k());
                                break;
                            case 72:
                                setCircleRoad(bVar.k());
                                break;
                            case 80:
                                setRoadWidth(bVar.k());
                                break;
                            case 88:
                                setDistance(bVar.k());
                                break;
                            case 96:
                                setDuration(bVar.k());
                                break;
                            case 106:
                                Links links = new Links();
                                bVar.f(links);
                                addLinks(links);
                                break;
                            case 114:
                                Pois pois = new Pois();
                                bVar.f(pois);
                                addPois(pois);
                                break;
                            case SyslogConstants.LOG_CLOCK /* 120 */:
                                setDirection(bVar.k());
                                break;
                            case 128:
                                setHasPanid(bVar.k());
                                break;
                            case SyslogConstants.LOG_LOCAL1 /* 136 */:
                                addSstartLocation(bVar.m());
                                break;
                            case SyslogConstants.LOG_LOCAL2 /* 144 */:
                                addSendLocation(bVar.m());
                                break;
                            case SyslogConstants.LOG_LOCAL3 /* 152 */:
                                addStrafficmarkLoc(bVar.k());
                                break;
                            case 160:
                                setTrafficType(bVar.k());
                                break;
                            case SyslogConstants.LOG_LOCAL5 /* 168 */:
                                addSpath4Navi(bVar.m());
                                break;
                            case 176:
                                setStepStatus(bVar.k());
                                break;
                            case 186:
                                Pois pois2 = new Pois();
                                bVar.f(pois2);
                                addPoirefPois(pois2);
                                break;
                            case 194:
                                DetailGuideInfoV1 detailGuideInfoV1 = new DetailGuideInfoV1();
                                bVar.f(detailGuideInfoV1);
                                addCloudGuideV1(detailGuideInfoV1);
                                break;
                            case LicenseCode.CODE_LICENSE_SERVICE_LICENSE_SIGN_ERROR /* 202 */:
                                DetailGuideInfoV2 detailGuideInfoV2 = new DetailGuideInfoV2();
                                bVar.f(detailGuideInfoV2);
                                addCloudGuideV2(detailGuideInfoV2);
                                break;
                            case 208:
                                setGuideType(bVar.k());
                                break;
                            case 218:
                                DetailGuideInfoV3 detailGuideInfoV3 = new DetailGuideInfoV3();
                                bVar.f(detailGuideInfoV3);
                                addCloudGuideV3(detailGuideInfoV3);
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

            public Legs addConnectedPois(ConnectedPois connectedPois) {
                if (connectedPois == null) {
                    return this;
                }
                if (this.connectedPois_.isEmpty()) {
                    this.connectedPois_ = new ArrayList();
                }
                this.connectedPois_.add(connectedPois);
                return this;
            }

            public Legs addSendLocation(int i4) {
                if (this.sendLocation_.isEmpty()) {
                    this.sendLocation_ = new ArrayList();
                }
                this.sendLocation_.add(Integer.valueOf(i4));
                return this;
            }

            public Legs addSstartLocation(int i4) {
                if (this.sstartLocation_.isEmpty()) {
                    this.sstartLocation_ = new ArrayList();
                }
                this.sstartLocation_.add(Integer.valueOf(i4));
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
                clearSteps();
                clearSstartLocation();
                clearSendLocation();
                clearStartAddress();
                clearEndAddress();
                clearDistance();
                clearDuration();
                clearSide();
                clearStartDist();
                clearEndDist();
                clearConnectedPois();
                clearLegLinked();
                clearType();
                this.cachedSize = -1;
                return this;
            }

            public Legs clearConnectedPois() {
                this.connectedPois_ = Collections.emptyList();
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

            public Legs clearEndAddress() {
                this.hasEndAddress = false;
                this.endAddress_ = "";
                return this;
            }

            public Legs clearEndDist() {
                this.hasEndDist = false;
                this.endDist_ = 0;
                return this;
            }

            public Legs clearLegLinked() {
                this.hasLegLinked = false;
                this.legLinked_ = null;
                return this;
            }

            public Legs clearSendLocation() {
                this.sendLocation_ = Collections.emptyList();
                return this;
            }

            public Legs clearSide() {
                this.hasSide = false;
                this.side_ = 0;
                return this;
            }

            public Legs clearSstartLocation() {
                this.sstartLocation_ = Collections.emptyList();
                return this;
            }

            public Legs clearStartAddress() {
                this.hasStartAddress = false;
                this.startAddress_ = "";
                return this;
            }

            public Legs clearStartDist() {
                this.hasStartDist = false;
                this.startDist_ = 0;
                return this;
            }

            public Legs clearSteps() {
                this.steps_ = Collections.emptyList();
                return this;
            }

            public Legs clearType() {
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

            public ConnectedPois getConnectedPois(int i4) {
                return this.connectedPois_.get(i4);
            }

            public int getConnectedPoisCount() {
                return this.connectedPois_.size();
            }

            public List<ConnectedPois> getConnectedPoisList() {
                return this.connectedPois_;
            }

            public int getDistance() {
                return this.distance_;
            }

            public int getDuration() {
                return this.duration_;
            }

            public String getEndAddress() {
                return this.endAddress_;
            }

            public int getEndDist() {
                return this.endDist_;
            }

            public LegLinked getLegLinked() {
                return this.legLinked_;
            }

            public int getSendLocation(int i4) {
                return this.sendLocation_.get(i4).intValue();
            }

            public int getSendLocationCount() {
                return this.sendLocation_.size();
            }

            public List<Integer> getSendLocationList() {
                return this.sendLocation_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                Iterator<Integer> it = getSstartLocationList().iterator();
                int iG = 0;
                int iG2 = 0;
                while (it.hasNext()) {
                    iG2 = g.g(it.next(), iG2);
                }
                int size = getSstartLocationList().size() + iG2;
                Iterator<Integer> it2 = getSendLocationList().iterator();
                while (it2.hasNext()) {
                    iG = g.g(it2.next(), iG);
                }
                int size2 = getSendLocationList().size() + size + iG;
                if (hasStartAddress()) {
                    size2 += d.l(3, getStartAddress());
                }
                if (hasEndAddress()) {
                    size2 += d.l(4, getEndAddress());
                }
                if (hasDistance()) {
                    size2 += d.e(5, getDistance());
                }
                if (hasDuration()) {
                    size2 += d.e(6, getDuration());
                }
                if (hasSide()) {
                    size2 += d.e(7, getSide());
                }
                if (hasStartDist()) {
                    size2 += d.e(8, getStartDist());
                }
                if (hasEndDist()) {
                    size2 += d.e(9, getEndDist());
                }
                Iterator<Steps> it3 = getStepsList().iterator();
                while (it3.hasNext()) {
                    size2 += d.h(10, it3.next());
                }
                Iterator<ConnectedPois> it4 = getConnectedPoisList().iterator();
                while (it4.hasNext()) {
                    size2 += d.h(11, it4.next());
                }
                if (hasLegLinked()) {
                    size2 += d.h(12, getLegLinked());
                }
                if (hasType()) {
                    size2 += d.e(13, getType());
                }
                this.cachedSize = size2;
                return size2;
            }

            public int getSide() {
                return this.side_;
            }

            public int getSstartLocation(int i4) {
                return this.sstartLocation_.get(i4).intValue();
            }

            public int getSstartLocationCount() {
                return this.sstartLocation_.size();
            }

            public List<Integer> getSstartLocationList() {
                return this.sstartLocation_;
            }

            public String getStartAddress() {
                return this.startAddress_;
            }

            public int getStartDist() {
                return this.startDist_;
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

            public int getType() {
                return this.type_;
            }

            public boolean hasDistance() {
                return this.hasDistance;
            }

            public boolean hasDuration() {
                return this.hasDuration;
            }

            public boolean hasEndAddress() {
                return this.hasEndAddress;
            }

            public boolean hasEndDist() {
                return this.hasEndDist;
            }

            public boolean hasLegLinked() {
                return this.hasLegLinked;
            }

            public boolean hasSide() {
                return this.hasSide;
            }

            public boolean hasStartAddress() {
                return this.hasStartAddress;
            }

            public boolean hasStartDist() {
                return this.hasStartDist;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Legs setConnectedPois(int i4, ConnectedPois connectedPois) {
                if (connectedPois == null) {
                    return this;
                }
                this.connectedPois_.set(i4, connectedPois);
                return this;
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

            public Legs setEndAddress(String str) {
                this.hasEndAddress = true;
                this.endAddress_ = str;
                return this;
            }

            public Legs setEndDist(int i4) {
                this.hasEndDist = true;
                this.endDist_ = i4;
                return this;
            }

            public Legs setLegLinked(LegLinked legLinked) {
                if (legLinked == null) {
                    return clearLegLinked();
                }
                this.hasLegLinked = true;
                this.legLinked_ = legLinked;
                return this;
            }

            public Legs setSendLocation(int i4, int i5) {
                this.sendLocation_.set(i4, Integer.valueOf(i5));
                return this;
            }

            public Legs setSide(int i4) {
                this.hasSide = true;
                this.side_ = i4;
                return this;
            }

            public Legs setSstartLocation(int i4, int i5) {
                this.sstartLocation_.set(i4, Integer.valueOf(i5));
                return this;
            }

            public Legs setStartAddress(String str) {
                this.hasStartAddress = true;
                this.startAddress_ = str;
                return this;
            }

            public Legs setStartDist(int i4) {
                this.hasStartDist = true;
                this.startDist_ = i4;
                return this;
            }

            public Legs setSteps(int i4, Steps steps) {
                if (steps == null) {
                    return this;
                }
                this.steps_.set(i4, steps);
                return this;
            }

            public Legs setType(int i4) {
                this.hasType = true;
                this.type_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                Iterator<Integer> it = getSstartLocationList().iterator();
                while (it.hasNext()) {
                    dVar.z(1, it.next().intValue());
                }
                Iterator<Integer> it2 = getSendLocationList().iterator();
                while (it2.hasNext()) {
                    dVar.z(2, it2.next().intValue());
                }
                if (hasStartAddress()) {
                    dVar.A(3, getStartAddress());
                }
                if (hasEndAddress()) {
                    dVar.A(4, getEndAddress());
                }
                if (hasDistance()) {
                    dVar.s(5, getDistance());
                }
                if (hasDuration()) {
                    dVar.s(6, getDuration());
                }
                if (hasSide()) {
                    dVar.s(7, getSide());
                }
                if (hasStartDist()) {
                    dVar.s(8, getStartDist());
                }
                if (hasEndDist()) {
                    dVar.s(9, getEndDist());
                }
                Iterator<Steps> it3 = getStepsList().iterator();
                while (it3.hasNext()) {
                    dVar.u(10, it3.next());
                }
                Iterator<ConnectedPois> it4 = getConnectedPoisList().iterator();
                while (it4.hasNext()) {
                    dVar.u(11, it4.next());
                }
                if (hasLegLinked()) {
                    dVar.u(12, getLegLinked());
                }
                if (hasType()) {
                    dVar.s(13, getType());
                }
            }

            public static Legs parseFrom(byte[] bArr) throws e {
                return (Legs) new Legs().mergeFrom(bArr);
            }

            @Override // L1.f
            public Legs mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    switch (iO) {
                        case 0:
                            return this;
                        case 8:
                            addSstartLocation(bVar.m());
                            break;
                        case 16:
                            addSendLocation(bVar.m());
                            break;
                        case 26:
                            setStartAddress(bVar.n());
                            break;
                        case 34:
                            setEndAddress(bVar.n());
                            break;
                        case 40:
                            setDistance(bVar.k());
                            break;
                        case 48:
                            setDuration(bVar.k());
                            break;
                        case 56:
                            setSide(bVar.k());
                            break;
                        case 64:
                            setStartDist(bVar.k());
                            break;
                        case 72:
                            setEndDist(bVar.k());
                            break;
                        case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                            Steps steps = new Steps();
                            bVar.f(steps);
                            addSteps(steps);
                            break;
                        case 90:
                            ConnectedPois connectedPois = new ConnectedPois();
                            bVar.f(connectedPois);
                            addConnectedPois(connectedPois);
                            break;
                        case 98:
                            LegLinked legLinked = new LegLinked();
                            bVar.f(legLinked);
                            setLegLinked(legLinked);
                            break;
                        case 104:
                            setType(bVar.k());
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

        public static final class MapDrawInfo extends f {
            public static final int GRAPH_ITEM_FIELD_NUMBER = 2;
            public static final int ICON_TYPE_FIELD_NUMBER = 3;
            public static final int ICON_URL_FIELD_NUMBER = 4;
            public static final int TYPE_FIELD_NUMBER = 1;
            private boolean hasIconType;
            private boolean hasIconUrl;
            private boolean hasType;
            private int type_ = 0;
            private List<GraphItemInfo> graphItem_ = Collections.emptyList();
            private int iconType_ = 0;
            private String iconUrl_ = "";
            private int cachedSize = -1;

            public static MapDrawInfo parseFrom(b bVar) throws IOException {
                return new MapDrawInfo().mergeFrom(bVar);
            }

            public MapDrawInfo addGraphItem(GraphItemInfo graphItemInfo) {
                if (graphItemInfo == null) {
                    return this;
                }
                if (this.graphItem_.isEmpty()) {
                    this.graphItem_ = new ArrayList();
                }
                this.graphItem_.add(graphItemInfo);
                return this;
            }

            public final MapDrawInfo clear() {
                clearType();
                clearGraphItem();
                clearIconType();
                clearIconUrl();
                this.cachedSize = -1;
                return this;
            }

            public MapDrawInfo clearGraphItem() {
                this.graphItem_ = Collections.emptyList();
                return this;
            }

            public MapDrawInfo clearIconType() {
                this.hasIconType = false;
                this.iconType_ = 0;
                return this;
            }

            public MapDrawInfo clearIconUrl() {
                this.hasIconUrl = false;
                this.iconUrl_ = "";
                return this;
            }

            public MapDrawInfo clearType() {
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

            public GraphItemInfo getGraphItem(int i4) {
                return this.graphItem_.get(i4);
            }

            public int getGraphItemCount() {
                return this.graphItem_.size();
            }

            public List<GraphItemInfo> getGraphItemList() {
                return this.graphItem_;
            }

            public int getIconType() {
                return this.iconType_;
            }

            public String getIconUrl() {
                return this.iconUrl_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasType() ? d.e(1, getType()) : 0;
                Iterator<GraphItemInfo> it = getGraphItemList().iterator();
                while (it.hasNext()) {
                    iE += d.h(2, it.next());
                }
                if (hasIconType()) {
                    iE += d.e(3, getIconType());
                }
                if (hasIconUrl()) {
                    iE += d.l(4, getIconUrl());
                }
                this.cachedSize = iE;
                return iE;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasIconType() {
                return this.hasIconType;
            }

            public boolean hasIconUrl() {
                return this.hasIconUrl;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            public MapDrawInfo setGraphItem(int i4, GraphItemInfo graphItemInfo) {
                if (graphItemInfo == null) {
                    return this;
                }
                this.graphItem_.set(i4, graphItemInfo);
                return this;
            }

            public MapDrawInfo setIconType(int i4) {
                this.hasIconType = true;
                this.iconType_ = i4;
                return this;
            }

            public MapDrawInfo setIconUrl(String str) {
                this.hasIconUrl = true;
                this.iconUrl_ = str;
                return this;
            }

            public MapDrawInfo setType(int i4) {
                this.hasType = true;
                this.type_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasType()) {
                    dVar.s(1, getType());
                }
                Iterator<GraphItemInfo> it = getGraphItemList().iterator();
                while (it.hasNext()) {
                    dVar.u(2, it.next());
                }
                if (hasIconType()) {
                    dVar.s(3, getIconType());
                }
                if (hasIconUrl()) {
                    dVar.A(4, getIconUrl());
                }
            }

            public static MapDrawInfo parseFrom(byte[] bArr) throws e {
                return (MapDrawInfo) new MapDrawInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public MapDrawInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setType(bVar.k());
                    } else if (iO == 18) {
                        GraphItemInfo graphItemInfo = new GraphItemInfo();
                        bVar.f(graphItemInfo);
                        addGraphItem(graphItemInfo);
                    } else if (iO == 24) {
                        setIconType(bVar.k());
                    } else if (iO == 34) {
                        setIconUrl(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Milestone extends f {
            public static final int DIS_FIELD_NUMBER = 1;
            public static final int PT_FIELD_NUMBER = 2;
            private boolean hasDis;
            private int dis_ = 0;
            private List<Integer> pt_ = Collections.emptyList();
            private int cachedSize = -1;

            public static Milestone parseFrom(b bVar) throws IOException {
                return new Milestone().mergeFrom(bVar);
            }

            public Milestone addPt(int i4) {
                if (this.pt_.isEmpty()) {
                    this.pt_ = new ArrayList();
                }
                this.pt_.add(Integer.valueOf(i4));
                return this;
            }

            public final Milestone clear() {
                clearDis();
                clearPt();
                this.cachedSize = -1;
                return this;
            }

            public Milestone clearDis() {
                this.hasDis = false;
                this.dis_ = 0;
                return this;
            }

            public Milestone clearPt() {
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

            public int getDis() {
                return this.dis_;
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
                int iG = 0;
                int iE = hasDis() ? d.e(1, getDis()) : 0;
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    iG = g.g(it.next(), iG);
                }
                int size = getPtList().size() + iE + iG;
                this.cachedSize = size;
                return size;
            }

            public boolean hasDis() {
                return this.hasDis;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Milestone setDis(int i4) {
                this.hasDis = true;
                this.dis_ = i4;
                return this;
            }

            public Milestone setPt(int i4, int i5) {
                this.pt_.set(i4, Integer.valueOf(i5));
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasDis()) {
                    dVar.s(1, getDis());
                }
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    dVar.z(2, it.next().intValue());
                }
            }

            public static Milestone parseFrom(byte[] bArr) throws e {
                return (Milestone) new Milestone().mergeFrom(bArr);
            }

            @Override // L1.f
            public Milestone mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setDis(bVar.k());
                    } else if (iO == 16) {
                        addPt(bVar.m());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class OtherInfo extends f {
            public static final int LIGHT_NUM_FIELD_NUMBER = 1;
            private boolean hasLightNum;
            private int lightNum_ = 0;
            private int cachedSize = -1;

            public static OtherInfo parseFrom(b bVar) throws IOException {
                return new OtherInfo().mergeFrom(bVar);
            }

            public final OtherInfo clear() {
                clearLightNum();
                this.cachedSize = -1;
                return this;
            }

            public OtherInfo clearLightNum() {
                this.hasLightNum = false;
                this.lightNum_ = 0;
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getLightNum() {
                return this.lightNum_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasLightNum() ? d.e(1, getLightNum()) : 0;
                this.cachedSize = iE;
                return iE;
            }

            public boolean hasLightNum() {
                return this.hasLightNum;
            }

            public final boolean isInitialized() {
                return true;
            }

            public OtherInfo setLightNum(int i4) {
                this.hasLightNum = true;
                this.lightNum_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasLightNum()) {
                    dVar.s(1, getLightNum());
                }
            }

            public static OtherInfo parseFrom(byte[] bArr) throws e {
                return (OtherInfo) new OtherInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public OtherInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setLightNum(bVar.k());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class PolicyInfo extends f {
            public static final int CALORIE_FIELD_NUMBER = 11;
            public static final int END_FIELD_NUMBER = 4;
            public static final int LABEL_FIELD_NUMBER = 2;
            public static final int LABEL_TIP_BAR_FIELD_NUMBER = 8;
            public static final int OPERATION_LABEL_CONTENT_FIELD_NUMBER = 9;
            public static final int OPERATION_LABEL_STYLE_FIELD_NUMBER = 10;
            public static final int PREVIEW_ROUTE_SCENE_FIELD_NUMBER = 7;
            public static final int RESULT_CARDS_FIELD_NUMBER = 6;
            public static final int RT_IDX_FIELD_NUMBER = 1;
            public static final int START_FIELD_NUMBER = 3;
            public static final int TAXI_FIELD_NUMBER = 5;
            private boolean hasCalorie;
            private boolean hasLabel;
            private boolean hasLabelTipBar;
            private boolean hasOperationLabelContent;
            private boolean hasOperationLabelStyle;
            private boolean hasPreviewRouteScene;
            private boolean hasRtIdx;
            private boolean hasStart;
            private boolean hasTaxi;
            private int rtIdx_ = 0;
            private String label_ = "";
            private Point_Info start_ = null;
            private List<Point_Info> end_ = Collections.emptyList();
            private Taxi taxi_ = null;
            private List<ResultCardInfo> resultCards_ = Collections.emptyList();
            private PreviewRouteSceneInfo previewRouteScene_ = null;
            private LabelTipBar labelTipBar_ = null;
            private String operationLabelContent_ = "";
            private OperationLabelStyle operationLabelStyle_ = null;
            private int calorie_ = 0;
            private int cachedSize = -1;

            public static final class LabelTipBar extends f {
                public static final int CONTENT_FIELD_NUMBER = 2;
                public static final int LINK_FIELD_NUMBER = 3;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasContent;
                private boolean hasLink;
                private boolean hasType;
                private String type_ = "";
                private String content_ = "";
                private String link_ = "";
                private int cachedSize = -1;

                public static LabelTipBar parseFrom(b bVar) throws IOException {
                    return new LabelTipBar().mergeFrom(bVar);
                }

                public final LabelTipBar clear() {
                    clearType();
                    clearContent();
                    clearLink();
                    this.cachedSize = -1;
                    return this;
                }

                public LabelTipBar clearContent() {
                    this.hasContent = false;
                    this.content_ = "";
                    return this;
                }

                public LabelTipBar clearLink() {
                    this.hasLink = false;
                    this.link_ = "";
                    return this;
                }

                public LabelTipBar clearType() {
                    this.hasType = false;
                    this.type_ = "";
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

                public String getLink() {
                    return this.link_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasType() ? d.l(1, getType()) : 0;
                    if (hasContent()) {
                        iL += d.l(2, getContent());
                    }
                    if (hasLink()) {
                        iL += d.l(3, getLink());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public String getType() {
                    return this.type_;
                }

                public boolean hasContent() {
                    return this.hasContent;
                }

                public boolean hasLink() {
                    return this.hasLink;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public LabelTipBar setContent(String str) {
                    this.hasContent = true;
                    this.content_ = str;
                    return this;
                }

                public LabelTipBar setLink(String str) {
                    this.hasLink = true;
                    this.link_ = str;
                    return this;
                }

                public LabelTipBar setType(String str) {
                    this.hasType = true;
                    this.type_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasType()) {
                        dVar.A(1, getType());
                    }
                    if (hasContent()) {
                        dVar.A(2, getContent());
                    }
                    if (hasLink()) {
                        dVar.A(3, getLink());
                    }
                }

                public static LabelTipBar parseFrom(byte[] bArr) throws e {
                    return (LabelTipBar) new LabelTipBar().mergeFrom(bArr);
                }

                @Override // L1.f
                public LabelTipBar mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setType(bVar.n());
                        } else if (iO == 18) {
                            setContent(bVar.n());
                        } else if (iO == 26) {
                            setLink(bVar.n());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class OperationLabelStyle extends f {
                public static final int BACKGROUND_COLOR_FIELD_NUMBER = 3;
                public static final int FONT_COLOR_FIELD_NUMBER = 2;
                public static final int FONT_SIZE_FIELD_NUMBER = 1;
                private boolean hasBackgroundColor;
                private boolean hasFontColor;
                private boolean hasFontSize;
                private int fontSize_ = 0;
                private String fontColor_ = "";
                private String backgroundColor_ = "";
                private int cachedSize = -1;

                public static OperationLabelStyle parseFrom(b bVar) throws IOException {
                    return new OperationLabelStyle().mergeFrom(bVar);
                }

                public final OperationLabelStyle clear() {
                    clearFontSize();
                    clearFontColor();
                    clearBackgroundColor();
                    this.cachedSize = -1;
                    return this;
                }

                public OperationLabelStyle clearBackgroundColor() {
                    this.hasBackgroundColor = false;
                    this.backgroundColor_ = "";
                    return this;
                }

                public OperationLabelStyle clearFontColor() {
                    this.hasFontColor = false;
                    this.fontColor_ = "";
                    return this;
                }

                public OperationLabelStyle clearFontSize() {
                    this.hasFontSize = false;
                    this.fontSize_ = 0;
                    return this;
                }

                public String getBackgroundColor() {
                    return this.backgroundColor_;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getFontColor() {
                    return this.fontColor_;
                }

                public int getFontSize() {
                    return this.fontSize_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasFontSize() ? d.e(1, getFontSize()) : 0;
                    if (hasFontColor()) {
                        iE += d.l(2, getFontColor());
                    }
                    if (hasBackgroundColor()) {
                        iE += d.l(3, getBackgroundColor());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public boolean hasBackgroundColor() {
                    return this.hasBackgroundColor;
                }

                public boolean hasFontColor() {
                    return this.hasFontColor;
                }

                public boolean hasFontSize() {
                    return this.hasFontSize;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public OperationLabelStyle setBackgroundColor(String str) {
                    this.hasBackgroundColor = true;
                    this.backgroundColor_ = str;
                    return this;
                }

                public OperationLabelStyle setFontColor(String str) {
                    this.hasFontColor = true;
                    this.fontColor_ = str;
                    return this;
                }

                public OperationLabelStyle setFontSize(int i4) {
                    this.hasFontSize = true;
                    this.fontSize_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasFontSize()) {
                        dVar.s(1, getFontSize());
                    }
                    if (hasFontColor()) {
                        dVar.A(2, getFontColor());
                    }
                    if (hasBackgroundColor()) {
                        dVar.A(3, getBackgroundColor());
                    }
                }

                public static OperationLabelStyle parseFrom(byte[] bArr) throws e {
                    return (OperationLabelStyle) new OperationLabelStyle().mergeFrom(bArr);
                }

                @Override // L1.f
                public OperationLabelStyle mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setFontSize(bVar.k());
                        } else if (iO == 18) {
                            setFontColor(bVar.n());
                        } else if (iO == 26) {
                            setBackgroundColor(bVar.n());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class Point_Info extends f {
                public static final int BUILDINGNAME_FIELD_NUMBER = 9;
                public static final int BUILDING_FIELD_NUMBER = 6;
                public static final int BUILDING_INFOS_FIELD_NUMBER = 11;
                public static final int DISPT_FIELD_NUMBER = 8;
                public static final int FLOOR_FIELD_NUMBER = 5;
                public static final int FLOOR_INFO_FIELD_NUMBER = 10;
                public static final int GPT_FIELD_NUMBER = 7;
                public static final int INDOOR_LOC_TECH_FIELD_NUMBER = 13;
                public static final int NAME_FIELD_NUMBER = 2;
                public static final int PT_FIELD_NUMBER = 1;
                public static final int PT_POPINF_FIELD_NUMBER = 17;
                public static final int REALITY_POINT_GIF_URL_FIELD_NUMBER = 14;
                public static final int RT_BUS_FIELD_NUMBER = 16;
                public static final int SPT_FIELD_NUMBER = 4;
                public static final int SUBUID_FIELD_NUMBER = 15;
                public static final int T_INFO_FIELD_NUMBER = 12;
                public static final int UID_FIELD_NUMBER = 3;
                private boolean hasBuilding;
                private boolean hasBuildingInfos;
                private boolean hasBuildingname;
                private boolean hasFloor;
                private boolean hasFloorInfo;
                private boolean hasIndoorLocTech;
                private boolean hasName;
                private boolean hasPt;
                private boolean hasPtPopinf;
                private boolean hasRealityPointGifUrl;
                private boolean hasRtBus;
                private boolean hasSubuid;
                private boolean hasUid;
                private String pt_ = "";
                private String name_ = "";
                private String uid_ = "";
                private List<Integer> spt_ = Collections.emptyList();
                private String floor_ = "";
                private String building_ = "";
                private List<Integer> gpt_ = Collections.emptyList();
                private List<Integer> dispt_ = Collections.emptyList();
                private String buildingname_ = "";
                private String floorInfo_ = "";
                private BuildingInfos buildingInfos_ = null;
                private List<TrafficHubPort> tInfo_ = Collections.emptyList();
                private int indoorLocTech_ = 0;
                private String realityPointGifUrl_ = "";
                private String subuid_ = "";
                private int rtBus_ = 0;
                private PtPopInf ptPopinf_ = null;
                private int cachedSize = -1;

                public static final class BuildingInfos extends f {
                    public static final int BID_FIELD_NUMBER = 1;
                    public static final int FLOORLIST_FIELD_NUMBER = 3;
                    public static final int NAME_FIELD_NUMBER = 2;
                    private boolean hasBid;
                    private boolean hasFloorlist;
                    private boolean hasName;
                    private String bid_ = "";
                    private String name_ = "";
                    private String floorlist_ = "";
                    private int cachedSize = -1;

                    public static BuildingInfos parseFrom(b bVar) throws IOException {
                        return new BuildingInfos().mergeFrom(bVar);
                    }

                    public final BuildingInfos clear() {
                        clearBid();
                        clearName();
                        clearFloorlist();
                        this.cachedSize = -1;
                        return this;
                    }

                    public BuildingInfos clearBid() {
                        this.hasBid = false;
                        this.bid_ = "";
                        return this;
                    }

                    public BuildingInfos clearFloorlist() {
                        this.hasFloorlist = false;
                        this.floorlist_ = "";
                        return this;
                    }

                    public BuildingInfos clearName() {
                        this.hasName = false;
                        this.name_ = "";
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

                    public String getFloorlist() {
                        return this.floorlist_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasBid() ? d.l(1, getBid()) : 0;
                        if (hasName()) {
                            iL += d.l(2, getName());
                        }
                        if (hasFloorlist()) {
                            iL += d.l(3, getFloorlist());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public boolean hasBid() {
                        return this.hasBid;
                    }

                    public boolean hasFloorlist() {
                        return this.hasFloorlist;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public BuildingInfos setBid(String str) {
                        this.hasBid = true;
                        this.bid_ = str;
                        return this;
                    }

                    public BuildingInfos setFloorlist(String str) {
                        this.hasFloorlist = true;
                        this.floorlist_ = str;
                        return this;
                    }

                    public BuildingInfos setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasBid()) {
                            dVar.A(1, getBid());
                        }
                        if (hasName()) {
                            dVar.A(2, getName());
                        }
                        if (hasFloorlist()) {
                            dVar.A(3, getFloorlist());
                        }
                    }

                    public static BuildingInfos parseFrom(byte[] bArr) throws e {
                        return (BuildingInfos) new BuildingInfos().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public BuildingInfos mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setBid(bVar.n());
                            } else if (iO == 18) {
                                setName(bVar.n());
                            } else if (iO == 26) {
                                setFloorlist(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class PtPopInf extends f {
                    public static final int TEXT_FIELD_NUMBER = 1;
                    public static final int URL_FIELD_NUMBER = 2;
                    private boolean hasText;
                    private boolean hasUrl;
                    private String text_ = "";
                    private String url_ = "";
                    private int cachedSize = -1;

                    public static PtPopInf parseFrom(b bVar) throws IOException {
                        return new PtPopInf().mergeFrom(bVar);
                    }

                    public final PtPopInf clear() {
                        clearText();
                        clearUrl();
                        this.cachedSize = -1;
                        return this;
                    }

                    public PtPopInf clearText() {
                        this.hasText = false;
                        this.text_ = "";
                        return this;
                    }

                    public PtPopInf clearUrl() {
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
                        int iL = hasText() ? d.l(1, getText()) : 0;
                        if (hasUrl()) {
                            iL += d.l(2, getUrl());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public String getText() {
                        return this.text_;
                    }

                    public String getUrl() {
                        return this.url_;
                    }

                    public boolean hasText() {
                        return this.hasText;
                    }

                    public boolean hasUrl() {
                        return this.hasUrl;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public PtPopInf setText(String str) {
                        this.hasText = true;
                        this.text_ = str;
                        return this;
                    }

                    public PtPopInf setUrl(String str) {
                        this.hasUrl = true;
                        this.url_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasText()) {
                            dVar.A(1, getText());
                        }
                        if (hasUrl()) {
                            dVar.A(2, getUrl());
                        }
                    }

                    public static PtPopInf parseFrom(byte[] bArr) throws e {
                        return (PtPopInf) new PtPopInf().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public PtPopInf mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setText(bVar.n());
                            } else if (iO == 18) {
                                setUrl(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class TrafficHubPort extends f {
                    public static final int NAME_FIELD_NUMBER = 1;
                    public static final int TYPE_FIELD_NUMBER = 2;
                    private boolean hasName;
                    private boolean hasType;
                    private String name_ = "";
                    private int type_ = 0;
                    private int cachedSize = -1;

                    public static TrafficHubPort parseFrom(b bVar) throws IOException {
                        return new TrafficHubPort().mergeFrom(bVar);
                    }

                    public final TrafficHubPort clear() {
                        clearName();
                        clearType();
                        this.cachedSize = -1;
                        return this;
                    }

                    public TrafficHubPort clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    public TrafficHubPort clearType() {
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

                    public String getName() {
                        return this.name_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasName() ? d.l(1, getName()) : 0;
                        if (hasType()) {
                            iL += d.k(getType()) + d.n(2);
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public boolean hasType() {
                        return this.hasType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public TrafficHubPort setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    public TrafficHubPort setType(int i4) {
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
                            dVar.z(2, getType());
                        }
                    }

                    public static TrafficHubPort parseFrom(byte[] bArr) throws e {
                        return (TrafficHubPort) new TrafficHubPort().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public TrafficHubPort mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setName(bVar.n());
                            } else if (iO == 16) {
                                setType(bVar.m());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static Point_Info parseFrom(b bVar) throws IOException {
                    return new Point_Info().mergeFrom(bVar);
                }

                public Point_Info addDispt(int i4) {
                    if (this.dispt_.isEmpty()) {
                        this.dispt_ = new ArrayList();
                    }
                    this.dispt_.add(Integer.valueOf(i4));
                    return this;
                }

                public Point_Info addGpt(int i4) {
                    if (this.gpt_.isEmpty()) {
                        this.gpt_ = new ArrayList();
                    }
                    this.gpt_.add(Integer.valueOf(i4));
                    return this;
                }

                public Point_Info addSpt(int i4) {
                    if (this.spt_.isEmpty()) {
                        this.spt_ = new ArrayList();
                    }
                    this.spt_.add(Integer.valueOf(i4));
                    return this;
                }

                public Point_Info addTInfo(TrafficHubPort trafficHubPort) {
                    if (trafficHubPort == null) {
                        return this;
                    }
                    if (this.tInfo_.isEmpty()) {
                        this.tInfo_ = new ArrayList();
                    }
                    this.tInfo_.add(trafficHubPort);
                    return this;
                }

                public final Point_Info clear() {
                    clearPt();
                    clearName();
                    clearUid();
                    clearSpt();
                    clearFloor();
                    clearBuilding();
                    clearGpt();
                    clearDispt();
                    clearBuildingname();
                    clearFloorInfo();
                    clearBuildingInfos();
                    clearTInfo();
                    clearIndoorLocTech();
                    clearRealityPointGifUrl();
                    clearSubuid();
                    clearRtBus();
                    clearPtPopinf();
                    this.cachedSize = -1;
                    return this;
                }

                public Point_Info clearBuilding() {
                    this.hasBuilding = false;
                    this.building_ = "";
                    return this;
                }

                public Point_Info clearBuildingInfos() {
                    this.hasBuildingInfos = false;
                    this.buildingInfos_ = null;
                    return this;
                }

                public Point_Info clearBuildingname() {
                    this.hasBuildingname = false;
                    this.buildingname_ = "";
                    return this;
                }

                public Point_Info clearDispt() {
                    this.dispt_ = Collections.emptyList();
                    return this;
                }

                public Point_Info clearFloor() {
                    this.hasFloor = false;
                    this.floor_ = "";
                    return this;
                }

                public Point_Info clearFloorInfo() {
                    this.hasFloorInfo = false;
                    this.floorInfo_ = "";
                    return this;
                }

                public Point_Info clearGpt() {
                    this.gpt_ = Collections.emptyList();
                    return this;
                }

                public Point_Info clearIndoorLocTech() {
                    this.hasIndoorLocTech = false;
                    this.indoorLocTech_ = 0;
                    return this;
                }

                public Point_Info clearName() {
                    this.hasName = false;
                    this.name_ = "";
                    return this;
                }

                public Point_Info clearPt() {
                    this.hasPt = false;
                    this.pt_ = "";
                    return this;
                }

                public Point_Info clearPtPopinf() {
                    this.hasPtPopinf = false;
                    this.ptPopinf_ = null;
                    return this;
                }

                public Point_Info clearRealityPointGifUrl() {
                    this.hasRealityPointGifUrl = false;
                    this.realityPointGifUrl_ = "";
                    return this;
                }

                public Point_Info clearRtBus() {
                    this.hasRtBus = false;
                    this.rtBus_ = 0;
                    return this;
                }

                public Point_Info clearSpt() {
                    this.spt_ = Collections.emptyList();
                    return this;
                }

                public Point_Info clearSubuid() {
                    this.hasSubuid = false;
                    this.subuid_ = "";
                    return this;
                }

                public Point_Info clearTInfo() {
                    this.tInfo_ = Collections.emptyList();
                    return this;
                }

                public Point_Info clearUid() {
                    this.hasUid = false;
                    this.uid_ = "";
                    return this;
                }

                public String getBuilding() {
                    return this.building_;
                }

                public BuildingInfos getBuildingInfos() {
                    return this.buildingInfos_;
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

                public int getDispt(int i4) {
                    return this.dispt_.get(i4).intValue();
                }

                public int getDisptCount() {
                    return this.dispt_.size();
                }

                public List<Integer> getDisptList() {
                    return this.dispt_;
                }

                public String getFloor() {
                    return this.floor_;
                }

                public String getFloorInfo() {
                    return this.floorInfo_;
                }

                public int getGpt(int i4) {
                    return this.gpt_.get(i4).intValue();
                }

                public int getGptCount() {
                    return this.gpt_.size();
                }

                public List<Integer> getGptList() {
                    return this.gpt_;
                }

                public int getIndoorLocTech() {
                    return this.indoorLocTech_;
                }

                public String getName() {
                    return this.name_;
                }

                public String getPt() {
                    return this.pt_;
                }

                public PtPopInf getPtPopinf() {
                    return this.ptPopinf_;
                }

                public String getRealityPointGifUrl() {
                    return this.realityPointGifUrl_;
                }

                public int getRtBus() {
                    return this.rtBus_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iG = 0;
                    int iL = hasPt() ? d.l(1, getPt()) : 0;
                    if (hasName()) {
                        iL += d.l(2, getName());
                    }
                    if (hasUid()) {
                        iL += d.l(3, getUid());
                    }
                    Iterator<Integer> it = getSptList().iterator();
                    int iG2 = 0;
                    while (it.hasNext()) {
                        iG2 = g.g(it.next(), iG2);
                    }
                    int size = getSptList().size() + iL + iG2;
                    if (hasFloor()) {
                        size += d.l(5, getFloor());
                    }
                    if (hasBuilding()) {
                        size += d.l(6, getBuilding());
                    }
                    Iterator<Integer> it2 = getGptList().iterator();
                    int iG3 = 0;
                    while (it2.hasNext()) {
                        iG3 = g.g(it2.next(), iG3);
                    }
                    int size2 = getGptList().size() + size + iG3;
                    Iterator<Integer> it3 = getDisptList().iterator();
                    while (it3.hasNext()) {
                        iG = g.g(it3.next(), iG);
                    }
                    int size3 = getDisptList().size() + size2 + iG;
                    if (hasBuildingname()) {
                        size3 += d.l(9, getBuildingname());
                    }
                    if (hasFloorInfo()) {
                        size3 += d.l(10, getFloorInfo());
                    }
                    if (hasBuildingInfos()) {
                        size3 += d.h(11, getBuildingInfos());
                    }
                    Iterator<TrafficHubPort> it4 = getTInfoList().iterator();
                    while (it4.hasNext()) {
                        size3 += d.h(12, it4.next());
                    }
                    if (hasIndoorLocTech()) {
                        size3 += d.e(13, getIndoorLocTech());
                    }
                    if (hasRealityPointGifUrl()) {
                        size3 += d.l(14, getRealityPointGifUrl());
                    }
                    if (hasSubuid()) {
                        size3 += d.l(15, getSubuid());
                    }
                    if (hasRtBus()) {
                        size3 += d.e(16, getRtBus());
                    }
                    if (hasPtPopinf()) {
                        size3 += d.h(17, getPtPopinf());
                    }
                    this.cachedSize = size3;
                    return size3;
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

                public String getSubuid() {
                    return this.subuid_;
                }

                public TrafficHubPort getTInfo(int i4) {
                    return this.tInfo_.get(i4);
                }

                public int getTInfoCount() {
                    return this.tInfo_.size();
                }

                public List<TrafficHubPort> getTInfoList() {
                    return this.tInfo_;
                }

                public String getUid() {
                    return this.uid_;
                }

                public boolean hasBuilding() {
                    return this.hasBuilding;
                }

                public boolean hasBuildingInfos() {
                    return this.hasBuildingInfos;
                }

                public boolean hasBuildingname() {
                    return this.hasBuildingname;
                }

                public boolean hasFloor() {
                    return this.hasFloor;
                }

                public boolean hasFloorInfo() {
                    return this.hasFloorInfo;
                }

                public boolean hasIndoorLocTech() {
                    return this.hasIndoorLocTech;
                }

                public boolean hasName() {
                    return this.hasName;
                }

                public boolean hasPt() {
                    return this.hasPt;
                }

                public boolean hasPtPopinf() {
                    return this.hasPtPopinf;
                }

                public boolean hasRealityPointGifUrl() {
                    return this.hasRealityPointGifUrl;
                }

                public boolean hasRtBus() {
                    return this.hasRtBus;
                }

                public boolean hasSubuid() {
                    return this.hasSubuid;
                }

                public boolean hasUid() {
                    return this.hasUid;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Point_Info setBuilding(String str) {
                    this.hasBuilding = true;
                    this.building_ = str;
                    return this;
                }

                public Point_Info setBuildingInfos(BuildingInfos buildingInfos) {
                    if (buildingInfos == null) {
                        return clearBuildingInfos();
                    }
                    this.hasBuildingInfos = true;
                    this.buildingInfos_ = buildingInfos;
                    return this;
                }

                public Point_Info setBuildingname(String str) {
                    this.hasBuildingname = true;
                    this.buildingname_ = str;
                    return this;
                }

                public Point_Info setDispt(int i4, int i5) {
                    this.dispt_.set(i4, Integer.valueOf(i5));
                    return this;
                }

                public Point_Info setFloor(String str) {
                    this.hasFloor = true;
                    this.floor_ = str;
                    return this;
                }

                public Point_Info setFloorInfo(String str) {
                    this.hasFloorInfo = true;
                    this.floorInfo_ = str;
                    return this;
                }

                public Point_Info setGpt(int i4, int i5) {
                    this.gpt_.set(i4, Integer.valueOf(i5));
                    return this;
                }

                public Point_Info setIndoorLocTech(int i4) {
                    this.hasIndoorLocTech = true;
                    this.indoorLocTech_ = i4;
                    return this;
                }

                public Point_Info setName(String str) {
                    this.hasName = true;
                    this.name_ = str;
                    return this;
                }

                public Point_Info setPt(String str) {
                    this.hasPt = true;
                    this.pt_ = str;
                    return this;
                }

                public Point_Info setPtPopinf(PtPopInf ptPopInf) {
                    if (ptPopInf == null) {
                        return clearPtPopinf();
                    }
                    this.hasPtPopinf = true;
                    this.ptPopinf_ = ptPopInf;
                    return this;
                }

                public Point_Info setRealityPointGifUrl(String str) {
                    this.hasRealityPointGifUrl = true;
                    this.realityPointGifUrl_ = str;
                    return this;
                }

                public Point_Info setRtBus(int i4) {
                    this.hasRtBus = true;
                    this.rtBus_ = i4;
                    return this;
                }

                public Point_Info setSpt(int i4, int i5) {
                    this.spt_.set(i4, Integer.valueOf(i5));
                    return this;
                }

                public Point_Info setSubuid(String str) {
                    this.hasSubuid = true;
                    this.subuid_ = str;
                    return this;
                }

                public Point_Info setTInfo(int i4, TrafficHubPort trafficHubPort) {
                    if (trafficHubPort == null) {
                        return this;
                    }
                    this.tInfo_.set(i4, trafficHubPort);
                    return this;
                }

                public Point_Info setUid(String str) {
                    this.hasUid = true;
                    this.uid_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasPt()) {
                        dVar.A(1, getPt());
                    }
                    if (hasName()) {
                        dVar.A(2, getName());
                    }
                    if (hasUid()) {
                        dVar.A(3, getUid());
                    }
                    Iterator<Integer> it = getSptList().iterator();
                    while (it.hasNext()) {
                        dVar.z(4, it.next().intValue());
                    }
                    if (hasFloor()) {
                        dVar.A(5, getFloor());
                    }
                    if (hasBuilding()) {
                        dVar.A(6, getBuilding());
                    }
                    Iterator<Integer> it2 = getGptList().iterator();
                    while (it2.hasNext()) {
                        dVar.z(7, it2.next().intValue());
                    }
                    Iterator<Integer> it3 = getDisptList().iterator();
                    while (it3.hasNext()) {
                        dVar.z(8, it3.next().intValue());
                    }
                    if (hasBuildingname()) {
                        dVar.A(9, getBuildingname());
                    }
                    if (hasFloorInfo()) {
                        dVar.A(10, getFloorInfo());
                    }
                    if (hasBuildingInfos()) {
                        dVar.u(11, getBuildingInfos());
                    }
                    Iterator<TrafficHubPort> it4 = getTInfoList().iterator();
                    while (it4.hasNext()) {
                        dVar.u(12, it4.next());
                    }
                    if (hasIndoorLocTech()) {
                        dVar.s(13, getIndoorLocTech());
                    }
                    if (hasRealityPointGifUrl()) {
                        dVar.A(14, getRealityPointGifUrl());
                    }
                    if (hasSubuid()) {
                        dVar.A(15, getSubuid());
                    }
                    if (hasRtBus()) {
                        dVar.s(16, getRtBus());
                    }
                    if (hasPtPopinf()) {
                        dVar.u(17, getPtPopinf());
                    }
                }

                public static Point_Info parseFrom(byte[] bArr) throws e {
                    return (Point_Info) new Point_Info().mergeFrom(bArr);
                }

                @Override // L1.f
                public Point_Info mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        switch (iO) {
                            case 0:
                                return this;
                            case 10:
                                setPt(bVar.n());
                                break;
                            case 18:
                                setName(bVar.n());
                                break;
                            case 26:
                                setUid(bVar.n());
                                break;
                            case 32:
                                addSpt(bVar.m());
                                break;
                            case 42:
                                setFloor(bVar.n());
                                break;
                            case 50:
                                setBuilding(bVar.n());
                                break;
                            case 56:
                                addGpt(bVar.m());
                                break;
                            case 64:
                                addDispt(bVar.m());
                                break;
                            case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                                setBuildingname(bVar.n());
                                break;
                            case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                                setFloorInfo(bVar.n());
                                break;
                            case 90:
                                BuildingInfos buildingInfos = new BuildingInfos();
                                bVar.f(buildingInfos);
                                setBuildingInfos(buildingInfos);
                                break;
                            case 98:
                                TrafficHubPort trafficHubPort = new TrafficHubPort();
                                bVar.f(trafficHubPort);
                                addTInfo(trafficHubPort);
                                break;
                            case 104:
                                setIndoorLocTech(bVar.k());
                                break;
                            case 114:
                                setRealityPointGifUrl(bVar.n());
                                break;
                            case 122:
                                setSubuid(bVar.n());
                                break;
                            case 128:
                                setRtBus(bVar.k());
                                break;
                            case 138:
                                PtPopInf ptPopInf = new PtPopInf();
                                bVar.f(ptPopInf);
                                setPtPopinf(ptPopInf);
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

            public static final class PreviewRouteSceneInfo extends f {
                public static final int BUTTON_TXT_FIELD_NUMBER = 2;
                public static final int IS_DISPLAY_FIELD_NUMBER = 1;
                public static final int JUMP_URL_FIELD_NUMBER = 4;
                public static final int SUPERSCRIPT_TXT_FIELD_NUMBER = 3;
                private boolean hasButtonTxt;
                private boolean hasIsDisplay;
                private boolean hasJumpUrl;
                private boolean hasSuperscriptTxt;
                private int isDisplay_ = 0;
                private String buttonTxt_ = "";
                private String superscriptTxt_ = "";
                private String jumpUrl_ = "";
                private int cachedSize = -1;

                public static PreviewRouteSceneInfo parseFrom(b bVar) throws IOException {
                    return new PreviewRouteSceneInfo().mergeFrom(bVar);
                }

                public final PreviewRouteSceneInfo clear() {
                    clearIsDisplay();
                    clearButtonTxt();
                    clearSuperscriptTxt();
                    clearJumpUrl();
                    this.cachedSize = -1;
                    return this;
                }

                public PreviewRouteSceneInfo clearButtonTxt() {
                    this.hasButtonTxt = false;
                    this.buttonTxt_ = "";
                    return this;
                }

                public PreviewRouteSceneInfo clearIsDisplay() {
                    this.hasIsDisplay = false;
                    this.isDisplay_ = 0;
                    return this;
                }

                public PreviewRouteSceneInfo clearJumpUrl() {
                    this.hasJumpUrl = false;
                    this.jumpUrl_ = "";
                    return this;
                }

                public PreviewRouteSceneInfo clearSuperscriptTxt() {
                    this.hasSuperscriptTxt = false;
                    this.superscriptTxt_ = "";
                    return this;
                }

                public String getButtonTxt() {
                    return this.buttonTxt_;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getIsDisplay() {
                    return this.isDisplay_;
                }

                public String getJumpUrl() {
                    return this.jumpUrl_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasIsDisplay() ? d.e(1, getIsDisplay()) : 0;
                    if (hasButtonTxt()) {
                        iE += d.l(2, getButtonTxt());
                    }
                    if (hasSuperscriptTxt()) {
                        iE += d.l(3, getSuperscriptTxt());
                    }
                    if (hasJumpUrl()) {
                        iE += d.l(4, getJumpUrl());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public String getSuperscriptTxt() {
                    return this.superscriptTxt_;
                }

                public boolean hasButtonTxt() {
                    return this.hasButtonTxt;
                }

                public boolean hasIsDisplay() {
                    return this.hasIsDisplay;
                }

                public boolean hasJumpUrl() {
                    return this.hasJumpUrl;
                }

                public boolean hasSuperscriptTxt() {
                    return this.hasSuperscriptTxt;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public PreviewRouteSceneInfo setButtonTxt(String str) {
                    this.hasButtonTxt = true;
                    this.buttonTxt_ = str;
                    return this;
                }

                public PreviewRouteSceneInfo setIsDisplay(int i4) {
                    this.hasIsDisplay = true;
                    this.isDisplay_ = i4;
                    return this;
                }

                public PreviewRouteSceneInfo setJumpUrl(String str) {
                    this.hasJumpUrl = true;
                    this.jumpUrl_ = str;
                    return this;
                }

                public PreviewRouteSceneInfo setSuperscriptTxt(String str) {
                    this.hasSuperscriptTxt = true;
                    this.superscriptTxt_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasIsDisplay()) {
                        dVar.s(1, getIsDisplay());
                    }
                    if (hasButtonTxt()) {
                        dVar.A(2, getButtonTxt());
                    }
                    if (hasSuperscriptTxt()) {
                        dVar.A(3, getSuperscriptTxt());
                    }
                    if (hasJumpUrl()) {
                        dVar.A(4, getJumpUrl());
                    }
                }

                public static PreviewRouteSceneInfo parseFrom(byte[] bArr) throws e {
                    return (PreviewRouteSceneInfo) new PreviewRouteSceneInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public PreviewRouteSceneInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setIsDisplay(bVar.k());
                        } else if (iO == 18) {
                            setButtonTxt(bVar.n());
                        } else if (iO == 26) {
                            setSuperscriptTxt(bVar.n());
                        } else if (iO == 34) {
                            setJumpUrl(bVar.n());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class ResultCardInfo extends f {
                public static final int ALTITUDE_DATA_INFO_FIELD_NUMBER = 3;
                public static final int CARD_TYPE_FIELD_NUMBER = 1;
                public static final int DATA_FIELD_NUMBER = 2;
                public static final int VIEW_TICKET_INFO_FIELD_NUMBER = 4;
                private boolean hasAltitudeDataInfo;
                private boolean hasCardType;
                private boolean hasData;
                private String cardType_ = "";
                private String data_ = "";
                private AltitudeDataInfo altitudeDataInfo_ = null;
                private List<ViewTicketsInfo> viewTicketInfo_ = Collections.emptyList();
                private int cachedSize = -1;

                public static final class AltitudeDataInfo extends f {
                    public static final int ASCENT_ALTITUDE_FIELD_NUMBER = 3;
                    public static final int CHART_INFO_FIELD_NUMBER = 5;
                    public static final int DESCENT_ALTITUDE_FIELD_NUMBER = 4;
                    public static final int DOWNHILL_TOTAL_DIS_FIELD_NUMBER = 2;
                    public static final int UPHILL_TOTAL_DIS_FIELD_NUMBER = 1;
                    private boolean hasAscentAltitude;
                    private boolean hasDescentAltitude;
                    private boolean hasDownhillTotalDis;
                    private boolean hasUphillTotalDis;
                    private int uphillTotalDis_ = 0;
                    private int downhillTotalDis_ = 0;
                    private int ascentAltitude_ = 0;
                    private int descentAltitude_ = 0;
                    private List<AltitudeDataLineChartInfo> chartInfo_ = Collections.emptyList();
                    private int cachedSize = -1;

                    public static final class AltitudeDataLineChartInfo extends f {
                        public static final int ALTITUDE_FIELD_NUMBER = 2;
                        public static final int DIS_FIELD_NUMBER = 1;
                        private boolean hasAltitude;
                        private boolean hasDis;
                        private int dis_ = 0;
                        private int altitude_ = 0;
                        private int cachedSize = -1;

                        public static AltitudeDataLineChartInfo parseFrom(b bVar) throws IOException {
                            return new AltitudeDataLineChartInfo().mergeFrom(bVar);
                        }

                        public final AltitudeDataLineChartInfo clear() {
                            clearDis();
                            clearAltitude();
                            this.cachedSize = -1;
                            return this;
                        }

                        public AltitudeDataLineChartInfo clearAltitude() {
                            this.hasAltitude = false;
                            this.altitude_ = 0;
                            return this;
                        }

                        public AltitudeDataLineChartInfo clearDis() {
                            this.hasDis = false;
                            this.dis_ = 0;
                            return this;
                        }

                        public int getAltitude() {
                            return this.altitude_;
                        }

                        @Override // L1.f
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public int getDis() {
                            return this.dis_;
                        }

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iE = hasDis() ? d.e(1, getDis()) : 0;
                            if (hasAltitude()) {
                                iE += d.e(2, getAltitude());
                            }
                            this.cachedSize = iE;
                            return iE;
                        }

                        public boolean hasAltitude() {
                            return this.hasAltitude;
                        }

                        public boolean hasDis() {
                            return this.hasDis;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public AltitudeDataLineChartInfo setAltitude(int i4) {
                            this.hasAltitude = true;
                            this.altitude_ = i4;
                            return this;
                        }

                        public AltitudeDataLineChartInfo setDis(int i4) {
                            this.hasDis = true;
                            this.dis_ = i4;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasDis()) {
                                dVar.s(1, getDis());
                            }
                            if (hasAltitude()) {
                                dVar.s(2, getAltitude());
                            }
                        }

                        public static AltitudeDataLineChartInfo parseFrom(byte[] bArr) throws e {
                            return (AltitudeDataLineChartInfo) new AltitudeDataLineChartInfo().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public AltitudeDataLineChartInfo mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 8) {
                                    setDis(bVar.k());
                                } else if (iO == 16) {
                                    setAltitude(bVar.k());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static AltitudeDataInfo parseFrom(b bVar) throws IOException {
                        return new AltitudeDataInfo().mergeFrom(bVar);
                    }

                    public AltitudeDataInfo addChartInfo(AltitudeDataLineChartInfo altitudeDataLineChartInfo) {
                        if (altitudeDataLineChartInfo == null) {
                            return this;
                        }
                        if (this.chartInfo_.isEmpty()) {
                            this.chartInfo_ = new ArrayList();
                        }
                        this.chartInfo_.add(altitudeDataLineChartInfo);
                        return this;
                    }

                    public final AltitudeDataInfo clear() {
                        clearUphillTotalDis();
                        clearDownhillTotalDis();
                        clearAscentAltitude();
                        clearDescentAltitude();
                        clearChartInfo();
                        this.cachedSize = -1;
                        return this;
                    }

                    public AltitudeDataInfo clearAscentAltitude() {
                        this.hasAscentAltitude = false;
                        this.ascentAltitude_ = 0;
                        return this;
                    }

                    public AltitudeDataInfo clearChartInfo() {
                        this.chartInfo_ = Collections.emptyList();
                        return this;
                    }

                    public AltitudeDataInfo clearDescentAltitude() {
                        this.hasDescentAltitude = false;
                        this.descentAltitude_ = 0;
                        return this;
                    }

                    public AltitudeDataInfo clearDownhillTotalDis() {
                        this.hasDownhillTotalDis = false;
                        this.downhillTotalDis_ = 0;
                        return this;
                    }

                    public AltitudeDataInfo clearUphillTotalDis() {
                        this.hasUphillTotalDis = false;
                        this.uphillTotalDis_ = 0;
                        return this;
                    }

                    public int getAscentAltitude() {
                        return this.ascentAltitude_;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public AltitudeDataLineChartInfo getChartInfo(int i4) {
                        return this.chartInfo_.get(i4);
                    }

                    public int getChartInfoCount() {
                        return this.chartInfo_.size();
                    }

                    public List<AltitudeDataLineChartInfo> getChartInfoList() {
                        return this.chartInfo_;
                    }

                    public int getDescentAltitude() {
                        return this.descentAltitude_;
                    }

                    public int getDownhillTotalDis() {
                        return this.downhillTotalDis_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasUphillTotalDis() ? d.e(1, getUphillTotalDis()) : 0;
                        if (hasDownhillTotalDis()) {
                            iE += d.e(2, getDownhillTotalDis());
                        }
                        if (hasAscentAltitude()) {
                            iE += d.e(3, getAscentAltitude());
                        }
                        if (hasDescentAltitude()) {
                            iE += d.e(4, getDescentAltitude());
                        }
                        Iterator<AltitudeDataLineChartInfo> it = getChartInfoList().iterator();
                        while (it.hasNext()) {
                            iE += d.h(5, it.next());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public int getUphillTotalDis() {
                        return this.uphillTotalDis_;
                    }

                    public boolean hasAscentAltitude() {
                        return this.hasAscentAltitude;
                    }

                    public boolean hasDescentAltitude() {
                        return this.hasDescentAltitude;
                    }

                    public boolean hasDownhillTotalDis() {
                        return this.hasDownhillTotalDis;
                    }

                    public boolean hasUphillTotalDis() {
                        return this.hasUphillTotalDis;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public AltitudeDataInfo setAscentAltitude(int i4) {
                        this.hasAscentAltitude = true;
                        this.ascentAltitude_ = i4;
                        return this;
                    }

                    public AltitudeDataInfo setChartInfo(int i4, AltitudeDataLineChartInfo altitudeDataLineChartInfo) {
                        if (altitudeDataLineChartInfo == null) {
                            return this;
                        }
                        this.chartInfo_.set(i4, altitudeDataLineChartInfo);
                        return this;
                    }

                    public AltitudeDataInfo setDescentAltitude(int i4) {
                        this.hasDescentAltitude = true;
                        this.descentAltitude_ = i4;
                        return this;
                    }

                    public AltitudeDataInfo setDownhillTotalDis(int i4) {
                        this.hasDownhillTotalDis = true;
                        this.downhillTotalDis_ = i4;
                        return this;
                    }

                    public AltitudeDataInfo setUphillTotalDis(int i4) {
                        this.hasUphillTotalDis = true;
                        this.uphillTotalDis_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasUphillTotalDis()) {
                            dVar.s(1, getUphillTotalDis());
                        }
                        if (hasDownhillTotalDis()) {
                            dVar.s(2, getDownhillTotalDis());
                        }
                        if (hasAscentAltitude()) {
                            dVar.s(3, getAscentAltitude());
                        }
                        if (hasDescentAltitude()) {
                            dVar.s(4, getDescentAltitude());
                        }
                        Iterator<AltitudeDataLineChartInfo> it = getChartInfoList().iterator();
                        while (it.hasNext()) {
                            dVar.u(5, it.next());
                        }
                    }

                    public static AltitudeDataInfo parseFrom(byte[] bArr) throws e {
                        return (AltitudeDataInfo) new AltitudeDataInfo().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public AltitudeDataInfo mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setUphillTotalDis(bVar.k());
                            } else if (iO == 16) {
                                setDownhillTotalDis(bVar.k());
                            } else if (iO == 24) {
                                setAscentAltitude(bVar.k());
                            } else if (iO == 32) {
                                setDescentAltitude(bVar.k());
                            } else if (iO == 42) {
                                AltitudeDataLineChartInfo altitudeDataLineChartInfo = new AltitudeDataLineChartInfo();
                                bVar.f(altitudeDataLineChartInfo);
                                addChartInfo(altitudeDataLineChartInfo);
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class ViewTicketsInfo extends f {
                    public static final int BOOKING_TIME_TAG_FIELD_NUMBER = 3;
                    public static final int BOOKING_URL_FIELD_NUMBER = 5;
                    public static final int NAME_FIELD_NUMBER = 1;
                    public static final int PRICE_FIELD_NUMBER = 2;
                    public static final int REFUND_TYPE_TAG_FIELD_NUMBER = 4;
                    private boolean hasBookingTimeTag;
                    private boolean hasBookingUrl;
                    private boolean hasName;
                    private boolean hasPrice;
                    private boolean hasRefundTypeTag;
                    private String name_ = "";
                    private int price_ = 0;
                    private String bookingTimeTag_ = "";
                    private String refundTypeTag_ = "";
                    private String bookingUrl_ = "";
                    private int cachedSize = -1;

                    public static ViewTicketsInfo parseFrom(b bVar) throws IOException {
                        return new ViewTicketsInfo().mergeFrom(bVar);
                    }

                    public final ViewTicketsInfo clear() {
                        clearName();
                        clearPrice();
                        clearBookingTimeTag();
                        clearRefundTypeTag();
                        clearBookingUrl();
                        this.cachedSize = -1;
                        return this;
                    }

                    public ViewTicketsInfo clearBookingTimeTag() {
                        this.hasBookingTimeTag = false;
                        this.bookingTimeTag_ = "";
                        return this;
                    }

                    public ViewTicketsInfo clearBookingUrl() {
                        this.hasBookingUrl = false;
                        this.bookingUrl_ = "";
                        return this;
                    }

                    public ViewTicketsInfo clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    public ViewTicketsInfo clearPrice() {
                        this.hasPrice = false;
                        this.price_ = 0;
                        return this;
                    }

                    public ViewTicketsInfo clearRefundTypeTag() {
                        this.hasRefundTypeTag = false;
                        this.refundTypeTag_ = "";
                        return this;
                    }

                    public String getBookingTimeTag() {
                        return this.bookingTimeTag_;
                    }

                    public String getBookingUrl() {
                        return this.bookingUrl_;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    public int getPrice() {
                        return this.price_;
                    }

                    public String getRefundTypeTag() {
                        return this.refundTypeTag_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasName() ? d.l(1, getName()) : 0;
                        if (hasPrice()) {
                            iL += d.e(2, getPrice());
                        }
                        if (hasBookingTimeTag()) {
                            iL += d.l(3, getBookingTimeTag());
                        }
                        if (hasRefundTypeTag()) {
                            iL += d.l(4, getRefundTypeTag());
                        }
                        if (hasBookingUrl()) {
                            iL += d.l(5, getBookingUrl());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public boolean hasBookingTimeTag() {
                        return this.hasBookingTimeTag;
                    }

                    public boolean hasBookingUrl() {
                        return this.hasBookingUrl;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public boolean hasPrice() {
                        return this.hasPrice;
                    }

                    public boolean hasRefundTypeTag() {
                        return this.hasRefundTypeTag;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public ViewTicketsInfo setBookingTimeTag(String str) {
                        this.hasBookingTimeTag = true;
                        this.bookingTimeTag_ = str;
                        return this;
                    }

                    public ViewTicketsInfo setBookingUrl(String str) {
                        this.hasBookingUrl = true;
                        this.bookingUrl_ = str;
                        return this;
                    }

                    public ViewTicketsInfo setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    public ViewTicketsInfo setPrice(int i4) {
                        this.hasPrice = true;
                        this.price_ = i4;
                        return this;
                    }

                    public ViewTicketsInfo setRefundTypeTag(String str) {
                        this.hasRefundTypeTag = true;
                        this.refundTypeTag_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasName()) {
                            dVar.A(1, getName());
                        }
                        if (hasPrice()) {
                            dVar.s(2, getPrice());
                        }
                        if (hasBookingTimeTag()) {
                            dVar.A(3, getBookingTimeTag());
                        }
                        if (hasRefundTypeTag()) {
                            dVar.A(4, getRefundTypeTag());
                        }
                        if (hasBookingUrl()) {
                            dVar.A(5, getBookingUrl());
                        }
                    }

                    public static ViewTicketsInfo parseFrom(byte[] bArr) throws e {
                        return (ViewTicketsInfo) new ViewTicketsInfo().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public ViewTicketsInfo mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setName(bVar.n());
                            } else if (iO == 16) {
                                setPrice(bVar.k());
                            } else if (iO == 26) {
                                setBookingTimeTag(bVar.n());
                            } else if (iO == 34) {
                                setRefundTypeTag(bVar.n());
                            } else if (iO == 42) {
                                setBookingUrl(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static ResultCardInfo parseFrom(b bVar) throws IOException {
                    return new ResultCardInfo().mergeFrom(bVar);
                }

                public ResultCardInfo addViewTicketInfo(ViewTicketsInfo viewTicketsInfo) {
                    if (viewTicketsInfo == null) {
                        return this;
                    }
                    if (this.viewTicketInfo_.isEmpty()) {
                        this.viewTicketInfo_ = new ArrayList();
                    }
                    this.viewTicketInfo_.add(viewTicketsInfo);
                    return this;
                }

                public final ResultCardInfo clear() {
                    clearCardType();
                    clearData();
                    clearAltitudeDataInfo();
                    clearViewTicketInfo();
                    this.cachedSize = -1;
                    return this;
                }

                public ResultCardInfo clearAltitudeDataInfo() {
                    this.hasAltitudeDataInfo = false;
                    this.altitudeDataInfo_ = null;
                    return this;
                }

                public ResultCardInfo clearCardType() {
                    this.hasCardType = false;
                    this.cardType_ = "";
                    return this;
                }

                public ResultCardInfo clearData() {
                    this.hasData = false;
                    this.data_ = "";
                    return this;
                }

                public ResultCardInfo clearViewTicketInfo() {
                    this.viewTicketInfo_ = Collections.emptyList();
                    return this;
                }

                public AltitudeDataInfo getAltitudeDataInfo() {
                    return this.altitudeDataInfo_;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getCardType() {
                    return this.cardType_;
                }

                public String getData() {
                    return this.data_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasCardType() ? d.l(1, getCardType()) : 0;
                    if (hasData()) {
                        iL += d.l(2, getData());
                    }
                    if (hasAltitudeDataInfo()) {
                        iL += d.h(3, getAltitudeDataInfo());
                    }
                    Iterator<ViewTicketsInfo> it = getViewTicketInfoList().iterator();
                    while (it.hasNext()) {
                        iL += d.h(4, it.next());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public ViewTicketsInfo getViewTicketInfo(int i4) {
                    return this.viewTicketInfo_.get(i4);
                }

                public int getViewTicketInfoCount() {
                    return this.viewTicketInfo_.size();
                }

                public List<ViewTicketsInfo> getViewTicketInfoList() {
                    return this.viewTicketInfo_;
                }

                public boolean hasAltitudeDataInfo() {
                    return this.hasAltitudeDataInfo;
                }

                public boolean hasCardType() {
                    return this.hasCardType;
                }

                public boolean hasData() {
                    return this.hasData;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public ResultCardInfo setAltitudeDataInfo(AltitudeDataInfo altitudeDataInfo) {
                    if (altitudeDataInfo == null) {
                        return clearAltitudeDataInfo();
                    }
                    this.hasAltitudeDataInfo = true;
                    this.altitudeDataInfo_ = altitudeDataInfo;
                    return this;
                }

                public ResultCardInfo setCardType(String str) {
                    this.hasCardType = true;
                    this.cardType_ = str;
                    return this;
                }

                public ResultCardInfo setData(String str) {
                    this.hasData = true;
                    this.data_ = str;
                    return this;
                }

                public ResultCardInfo setViewTicketInfo(int i4, ViewTicketsInfo viewTicketsInfo) {
                    if (viewTicketsInfo == null) {
                        return this;
                    }
                    this.viewTicketInfo_.set(i4, viewTicketsInfo);
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasCardType()) {
                        dVar.A(1, getCardType());
                    }
                    if (hasData()) {
                        dVar.A(2, getData());
                    }
                    if (hasAltitudeDataInfo()) {
                        dVar.u(3, getAltitudeDataInfo());
                    }
                    Iterator<ViewTicketsInfo> it = getViewTicketInfoList().iterator();
                    while (it.hasNext()) {
                        dVar.u(4, it.next());
                    }
                }

                public static ResultCardInfo parseFrom(byte[] bArr) throws e {
                    return (ResultCardInfo) new ResultCardInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public ResultCardInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setCardType(bVar.n());
                        } else if (iO == 18) {
                            setData(bVar.n());
                        } else if (iO == 26) {
                            AltitudeDataInfo altitudeDataInfo = new AltitudeDataInfo();
                            bVar.f(altitudeDataInfo);
                            setAltitudeDataInfo(altitudeDataInfo);
                        } else if (iO == 34) {
                            ViewTicketsInfo viewTicketsInfo = new ViewTicketsInfo();
                            bVar.f(viewTicketsInfo);
                            addViewTicketInfo(viewTicketsInfo);
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static PolicyInfo parseFrom(b bVar) throws IOException {
                return new PolicyInfo().mergeFrom(bVar);
            }

            public PolicyInfo addEnd(Point_Info point_Info) {
                if (point_Info == null) {
                    return this;
                }
                if (this.end_.isEmpty()) {
                    this.end_ = new ArrayList();
                }
                this.end_.add(point_Info);
                return this;
            }

            public PolicyInfo addResultCards(ResultCardInfo resultCardInfo) {
                if (resultCardInfo == null) {
                    return this;
                }
                if (this.resultCards_.isEmpty()) {
                    this.resultCards_ = new ArrayList();
                }
                this.resultCards_.add(resultCardInfo);
                return this;
            }

            public final PolicyInfo clear() {
                clearRtIdx();
                clearLabel();
                clearStart();
                clearEnd();
                clearTaxi();
                clearResultCards();
                clearPreviewRouteScene();
                clearLabelTipBar();
                clearOperationLabelContent();
                clearOperationLabelStyle();
                clearCalorie();
                this.cachedSize = -1;
                return this;
            }

            public PolicyInfo clearCalorie() {
                this.hasCalorie = false;
                this.calorie_ = 0;
                return this;
            }

            public PolicyInfo clearEnd() {
                this.end_ = Collections.emptyList();
                return this;
            }

            public PolicyInfo clearLabel() {
                this.hasLabel = false;
                this.label_ = "";
                return this;
            }

            public PolicyInfo clearLabelTipBar() {
                this.hasLabelTipBar = false;
                this.labelTipBar_ = null;
                return this;
            }

            public PolicyInfo clearOperationLabelContent() {
                this.hasOperationLabelContent = false;
                this.operationLabelContent_ = "";
                return this;
            }

            public PolicyInfo clearOperationLabelStyle() {
                this.hasOperationLabelStyle = false;
                this.operationLabelStyle_ = null;
                return this;
            }

            public PolicyInfo clearPreviewRouteScene() {
                this.hasPreviewRouteScene = false;
                this.previewRouteScene_ = null;
                return this;
            }

            public PolicyInfo clearResultCards() {
                this.resultCards_ = Collections.emptyList();
                return this;
            }

            public PolicyInfo clearRtIdx() {
                this.hasRtIdx = false;
                this.rtIdx_ = 0;
                return this;
            }

            public PolicyInfo clearStart() {
                this.hasStart = false;
                this.start_ = null;
                return this;
            }

            public PolicyInfo clearTaxi() {
                this.hasTaxi = false;
                this.taxi_ = null;
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getCalorie() {
                return this.calorie_;
            }

            public Point_Info getEnd(int i4) {
                return this.end_.get(i4);
            }

            public int getEndCount() {
                return this.end_.size();
            }

            public List<Point_Info> getEndList() {
                return this.end_;
            }

            public String getLabel() {
                return this.label_;
            }

            public LabelTipBar getLabelTipBar() {
                return this.labelTipBar_;
            }

            public String getOperationLabelContent() {
                return this.operationLabelContent_;
            }

            public OperationLabelStyle getOperationLabelStyle() {
                return this.operationLabelStyle_;
            }

            public PreviewRouteSceneInfo getPreviewRouteScene() {
                return this.previewRouteScene_;
            }

            public ResultCardInfo getResultCards(int i4) {
                return this.resultCards_.get(i4);
            }

            public int getResultCardsCount() {
                return this.resultCards_.size();
            }

            public List<ResultCardInfo> getResultCardsList() {
                return this.resultCards_;
            }

            public int getRtIdx() {
                return this.rtIdx_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasRtIdx() ? d.e(1, getRtIdx()) : 0;
                if (hasLabel()) {
                    iE += d.l(2, getLabel());
                }
                if (hasStart()) {
                    iE += d.h(3, getStart());
                }
                Iterator<Point_Info> it = getEndList().iterator();
                while (it.hasNext()) {
                    iE += d.h(4, it.next());
                }
                if (hasTaxi()) {
                    iE += d.h(5, getTaxi());
                }
                Iterator<ResultCardInfo> it2 = getResultCardsList().iterator();
                while (it2.hasNext()) {
                    iE += d.h(6, it2.next());
                }
                if (hasPreviewRouteScene()) {
                    iE += d.h(7, getPreviewRouteScene());
                }
                if (hasLabelTipBar()) {
                    iE += d.h(8, getLabelTipBar());
                }
                if (hasOperationLabelContent()) {
                    iE += d.l(9, getOperationLabelContent());
                }
                if (hasOperationLabelStyle()) {
                    iE += d.h(10, getOperationLabelStyle());
                }
                if (hasCalorie()) {
                    iE += d.o(11, getCalorie());
                }
                this.cachedSize = iE;
                return iE;
            }

            public Point_Info getStart() {
                return this.start_;
            }

            public Taxi getTaxi() {
                return this.taxi_;
            }

            public boolean hasCalorie() {
                return this.hasCalorie;
            }

            public boolean hasLabel() {
                return this.hasLabel;
            }

            public boolean hasLabelTipBar() {
                return this.hasLabelTipBar;
            }

            public boolean hasOperationLabelContent() {
                return this.hasOperationLabelContent;
            }

            public boolean hasOperationLabelStyle() {
                return this.hasOperationLabelStyle;
            }

            public boolean hasPreviewRouteScene() {
                return this.hasPreviewRouteScene;
            }

            public boolean hasRtIdx() {
                return this.hasRtIdx;
            }

            public boolean hasStart() {
                return this.hasStart;
            }

            public boolean hasTaxi() {
                return this.hasTaxi;
            }

            public final boolean isInitialized() {
                return true;
            }

            public PolicyInfo setCalorie(int i4) {
                this.hasCalorie = true;
                this.calorie_ = i4;
                return this;
            }

            public PolicyInfo setEnd(int i4, Point_Info point_Info) {
                if (point_Info == null) {
                    return this;
                }
                this.end_.set(i4, point_Info);
                return this;
            }

            public PolicyInfo setLabel(String str) {
                this.hasLabel = true;
                this.label_ = str;
                return this;
            }

            public PolicyInfo setLabelTipBar(LabelTipBar labelTipBar) {
                if (labelTipBar == null) {
                    return clearLabelTipBar();
                }
                this.hasLabelTipBar = true;
                this.labelTipBar_ = labelTipBar;
                return this;
            }

            public PolicyInfo setOperationLabelContent(String str) {
                this.hasOperationLabelContent = true;
                this.operationLabelContent_ = str;
                return this;
            }

            public PolicyInfo setOperationLabelStyle(OperationLabelStyle operationLabelStyle) {
                if (operationLabelStyle == null) {
                    return clearOperationLabelStyle();
                }
                this.hasOperationLabelStyle = true;
                this.operationLabelStyle_ = operationLabelStyle;
                return this;
            }

            public PolicyInfo setPreviewRouteScene(PreviewRouteSceneInfo previewRouteSceneInfo) {
                if (previewRouteSceneInfo == null) {
                    return clearPreviewRouteScene();
                }
                this.hasPreviewRouteScene = true;
                this.previewRouteScene_ = previewRouteSceneInfo;
                return this;
            }

            public PolicyInfo setResultCards(int i4, ResultCardInfo resultCardInfo) {
                if (resultCardInfo == null) {
                    return this;
                }
                this.resultCards_.set(i4, resultCardInfo);
                return this;
            }

            public PolicyInfo setRtIdx(int i4) {
                this.hasRtIdx = true;
                this.rtIdx_ = i4;
                return this;
            }

            public PolicyInfo setStart(Point_Info point_Info) {
                if (point_Info == null) {
                    return clearStart();
                }
                this.hasStart = true;
                this.start_ = point_Info;
                return this;
            }

            public PolicyInfo setTaxi(Taxi taxi) {
                if (taxi == null) {
                    return clearTaxi();
                }
                this.hasTaxi = true;
                this.taxi_ = taxi;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasRtIdx()) {
                    dVar.s(1, getRtIdx());
                }
                if (hasLabel()) {
                    dVar.A(2, getLabel());
                }
                if (hasStart()) {
                    dVar.u(3, getStart());
                }
                Iterator<Point_Info> it = getEndList().iterator();
                while (it.hasNext()) {
                    dVar.u(4, it.next());
                }
                if (hasTaxi()) {
                    dVar.u(5, getTaxi());
                }
                Iterator<ResultCardInfo> it2 = getResultCardsList().iterator();
                while (it2.hasNext()) {
                    dVar.u(6, it2.next());
                }
                if (hasPreviewRouteScene()) {
                    dVar.u(7, getPreviewRouteScene());
                }
                if (hasLabelTipBar()) {
                    dVar.u(8, getLabelTipBar());
                }
                if (hasOperationLabelContent()) {
                    dVar.A(9, getOperationLabelContent());
                }
                if (hasOperationLabelStyle()) {
                    dVar.u(10, getOperationLabelStyle());
                }
                if (hasCalorie()) {
                    dVar.C(11, getCalorie());
                }
            }

            public static PolicyInfo parseFrom(byte[] bArr) throws e {
                return (PolicyInfo) new PolicyInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public PolicyInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    switch (iO) {
                        case 0:
                            return this;
                        case 8:
                            setRtIdx(bVar.k());
                            break;
                        case 18:
                            setLabel(bVar.n());
                            break;
                        case 26:
                            Point_Info point_Info = new Point_Info();
                            bVar.f(point_Info);
                            setStart(point_Info);
                            break;
                        case 34:
                            Point_Info point_Info2 = new Point_Info();
                            bVar.f(point_Info2);
                            addEnd(point_Info2);
                            break;
                        case 42:
                            Taxi taxi = new Taxi();
                            bVar.f(taxi);
                            setTaxi(taxi);
                            break;
                        case 50:
                            ResultCardInfo resultCardInfo = new ResultCardInfo();
                            bVar.f(resultCardInfo);
                            addResultCards(resultCardInfo);
                            break;
                        case 58:
                            PreviewRouteSceneInfo previewRouteSceneInfo = new PreviewRouteSceneInfo();
                            bVar.f(previewRouteSceneInfo);
                            setPreviewRouteScene(previewRouteSceneInfo);
                            break;
                        case 66:
                            LabelTipBar labelTipBar = new LabelTipBar();
                            bVar.f(labelTipBar);
                            setLabelTipBar(labelTipBar);
                            break;
                        case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                            setOperationLabelContent(bVar.n());
                            break;
                        case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                            OperationLabelStyle operationLabelStyle = new OperationLabelStyle();
                            bVar.f(operationLabelStyle);
                            setOperationLabelStyle(operationLabelStyle);
                            break;
                        case 88:
                            setCalorie(bVar.k());
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

        public static final class Tip extends f {
            public static final int CONTENT_FIELD_NUMBER = 1;
            public static final int DARK_ICONURL_FIELD_NUMBER = 5;
            public static final int ICONURL_FIELD_NUMBER = 2;
            public static final int LINK_FIELD_NUMBER = 3;
            public static final int MATERIAL_TYPE_FIELD_NUMBER = 6;
            public static final int TYPE_FIELD_NUMBER = 4;
            private boolean hasContent;
            private boolean hasDarkIconurl;
            private boolean hasIconurl;
            private boolean hasLink;
            private boolean hasMaterialType;
            private boolean hasType;
            private String content_ = "";
            private String iconurl_ = "";
            private String link_ = "";
            private int type_ = 0;
            private String darkIconurl_ = "";
            private String materialType_ = "";
            private int cachedSize = -1;

            public static Tip parseFrom(b bVar) throws IOException {
                return new Tip().mergeFrom(bVar);
            }

            public final Tip clear() {
                clearContent();
                clearIconurl();
                clearLink();
                clearType();
                clearDarkIconurl();
                clearMaterialType();
                this.cachedSize = -1;
                return this;
            }

            public Tip clearContent() {
                this.hasContent = false;
                this.content_ = "";
                return this;
            }

            public Tip clearDarkIconurl() {
                this.hasDarkIconurl = false;
                this.darkIconurl_ = "";
                return this;
            }

            public Tip clearIconurl() {
                this.hasIconurl = false;
                this.iconurl_ = "";
                return this;
            }

            public Tip clearLink() {
                this.hasLink = false;
                this.link_ = "";
                return this;
            }

            public Tip clearMaterialType() {
                this.hasMaterialType = false;
                this.materialType_ = "";
                return this;
            }

            public Tip clearType() {
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

            public String getDarkIconurl() {
                return this.darkIconurl_;
            }

            public String getIconurl() {
                return this.iconurl_;
            }

            public String getLink() {
                return this.link_;
            }

            public String getMaterialType() {
                return this.materialType_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasContent() ? d.l(1, getContent()) : 0;
                if (hasIconurl()) {
                    iL += d.l(2, getIconurl());
                }
                if (hasLink()) {
                    iL += d.l(3, getLink());
                }
                if (hasType()) {
                    iL += d.e(4, getType());
                }
                if (hasDarkIconurl()) {
                    iL += d.l(5, getDarkIconurl());
                }
                if (hasMaterialType()) {
                    iL += d.l(6, getMaterialType());
                }
                this.cachedSize = iL;
                return iL;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasContent() {
                return this.hasContent;
            }

            public boolean hasDarkIconurl() {
                return this.hasDarkIconurl;
            }

            public boolean hasIconurl() {
                return this.hasIconurl;
            }

            public boolean hasLink() {
                return this.hasLink;
            }

            public boolean hasMaterialType() {
                return this.hasMaterialType;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Tip setContent(String str) {
                this.hasContent = true;
                this.content_ = str;
                return this;
            }

            public Tip setDarkIconurl(String str) {
                this.hasDarkIconurl = true;
                this.darkIconurl_ = str;
                return this;
            }

            public Tip setIconurl(String str) {
                this.hasIconurl = true;
                this.iconurl_ = str;
                return this;
            }

            public Tip setLink(String str) {
                this.hasLink = true;
                this.link_ = str;
                return this;
            }

            public Tip setMaterialType(String str) {
                this.hasMaterialType = true;
                this.materialType_ = str;
                return this;
            }

            public Tip setType(int i4) {
                this.hasType = true;
                this.type_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasContent()) {
                    dVar.A(1, getContent());
                }
                if (hasIconurl()) {
                    dVar.A(2, getIconurl());
                }
                if (hasLink()) {
                    dVar.A(3, getLink());
                }
                if (hasType()) {
                    dVar.s(4, getType());
                }
                if (hasDarkIconurl()) {
                    dVar.A(5, getDarkIconurl());
                }
                if (hasMaterialType()) {
                    dVar.A(6, getMaterialType());
                }
            }

            public static Tip parseFrom(byte[] bArr) throws e {
                return (Tip) new Tip().mergeFrom(bArr);
            }

            @Override // L1.f
            public Tip mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setContent(bVar.n());
                    } else if (iO == 18) {
                        setIconurl(bVar.n());
                    } else if (iO == 26) {
                        setLink(bVar.n());
                    } else if (iO == 32) {
                        setType(bVar.k());
                    } else if (iO == 42) {
                        setDarkIconurl(bVar.n());
                    } else if (iO == 50) {
                        setMaterialType(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class UgcInfo extends f {
            public static final int MATERIAL_ID_FIELD_NUMBER = 2;
            public static final int TYPE_FIELD_NUMBER = 1;
            private boolean hasMaterialId;
            private boolean hasType;
            private int type_ = 0;
            private String materialId_ = "";
            private int cachedSize = -1;

            public static UgcInfo parseFrom(b bVar) throws IOException {
                return new UgcInfo().mergeFrom(bVar);
            }

            public final UgcInfo clear() {
                clearType();
                clearMaterialId();
                this.cachedSize = -1;
                return this;
            }

            public UgcInfo clearMaterialId() {
                this.hasMaterialId = false;
                this.materialId_ = "";
                return this;
            }

            public UgcInfo clearType() {
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

            public String getMaterialId() {
                return this.materialId_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasType() ? d.e(1, getType()) : 0;
                if (hasMaterialId()) {
                    iE += d.l(2, getMaterialId());
                }
                this.cachedSize = iE;
                return iE;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasMaterialId() {
                return this.hasMaterialId;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            public UgcInfo setMaterialId(String str) {
                this.hasMaterialId = true;
                this.materialId_ = str;
                return this;
            }

            public UgcInfo setType(int i4) {
                this.hasType = true;
                this.type_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasType()) {
                    dVar.s(1, getType());
                }
                if (hasMaterialId()) {
                    dVar.A(2, getMaterialId());
                }
            }

            public static UgcInfo parseFrom(byte[] bArr) throws e {
                return (UgcInfo) new UgcInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public UgcInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setType(bVar.k());
                    } else if (iO == 18) {
                        setMaterialId(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static Routes parseFrom(b bVar) throws IOException {
            return new Routes().mergeFrom(bVar);
        }

        public Routes addGuideInfo(Guideinfo guideinfo) {
            if (guideinfo == null) {
                return this;
            }
            if (this.guideInfo_.isEmpty()) {
                this.guideInfo_ = new ArrayList();
            }
            this.guideInfo_.add(guideinfo);
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

        public Routes addMapDrawInfo(MapDrawInfo mapDrawInfo) {
            if (mapDrawInfo == null) {
                return this;
            }
            if (this.mapDrawInfo_.isEmpty()) {
                this.mapDrawInfo_ = new ArrayList();
            }
            this.mapDrawInfo_.add(mapDrawInfo);
            return this;
        }

        public Routes addMsInfo(Milestone milestone) {
            if (milestone == null) {
                return this;
            }
            if (this.msInfo_.isEmpty()) {
                this.msInfo_ = new ArrayList();
            }
            this.msInfo_.add(milestone);
            return this;
        }

        public Routes addUgcInfo(UgcInfo ugcInfo) {
            if (ugcInfo == null) {
                return this;
            }
            if (this.ugcInfo_.isEmpty()) {
                this.ugcInfo_ = new ArrayList();
            }
            this.ugcInfo_.add(ugcInfo);
            return this;
        }

        public final Routes clear() {
            clearLegs();
            clearClimb();
            clearTip();
            clearOtherinfo();
            clearPlcyInfo();
            clearMsInfo();
            clearRouteIdf();
            clearGuideInfo();
            clearUgcInfo();
            clearMapDrawInfo();
            this.cachedSize = -1;
            return this;
        }

        public Routes clearClimb() {
            this.hasClimb = false;
            this.climb_ = null;
            return this;
        }

        public Routes clearGuideInfo() {
            this.guideInfo_ = Collections.emptyList();
            return this;
        }

        public Routes clearLegs() {
            this.legs_ = Collections.emptyList();
            return this;
        }

        public Routes clearMapDrawInfo() {
            this.mapDrawInfo_ = Collections.emptyList();
            return this;
        }

        public Routes clearMsInfo() {
            this.msInfo_ = Collections.emptyList();
            return this;
        }

        public Routes clearOtherinfo() {
            this.hasOtherinfo = false;
            this.otherinfo_ = null;
            return this;
        }

        public Routes clearPlcyInfo() {
            this.hasPlcyInfo = false;
            this.plcyInfo_ = null;
            return this;
        }

        public Routes clearRouteIdf() {
            this.hasRouteIdf = false;
            this.routeIdf_ = "";
            return this;
        }

        public Routes clearTip() {
            this.hasTip = false;
            this.tip_ = null;
            return this;
        }

        public Routes clearUgcInfo() {
            this.ugcInfo_ = Collections.emptyList();
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public Climb getClimb() {
            return this.climb_;
        }

        public Guideinfo getGuideInfo(int i4) {
            return this.guideInfo_.get(i4);
        }

        public int getGuideInfoCount() {
            return this.guideInfo_.size();
        }

        public List<Guideinfo> getGuideInfoList() {
            return this.guideInfo_;
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

        public MapDrawInfo getMapDrawInfo(int i4) {
            return this.mapDrawInfo_.get(i4);
        }

        public int getMapDrawInfoCount() {
            return this.mapDrawInfo_.size();
        }

        public List<MapDrawInfo> getMapDrawInfoList() {
            return this.mapDrawInfo_;
        }

        public Milestone getMsInfo(int i4) {
            return this.msInfo_.get(i4);
        }

        public int getMsInfoCount() {
            return this.msInfo_.size();
        }

        public List<Milestone> getMsInfoList() {
            return this.msInfo_;
        }

        public OtherInfo getOtherinfo() {
            return this.otherinfo_;
        }

        public PolicyInfo getPlcyInfo() {
            return this.plcyInfo_;
        }

        public String getRouteIdf() {
            return this.routeIdf_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            Iterator<Legs> it = getLegsList().iterator();
            int iH = 0;
            while (it.hasNext()) {
                iH += d.h(1, it.next());
            }
            if (hasClimb()) {
                iH += d.h(2, getClimb());
            }
            if (hasTip()) {
                iH += d.h(3, getTip());
            }
            if (hasOtherinfo()) {
                iH += d.h(4, getOtherinfo());
            }
            if (hasPlcyInfo()) {
                iH += d.h(5, getPlcyInfo());
            }
            Iterator<Milestone> it2 = getMsInfoList().iterator();
            while (it2.hasNext()) {
                iH += d.h(6, it2.next());
            }
            if (hasRouteIdf()) {
                iH += d.l(7, getRouteIdf());
            }
            Iterator<Guideinfo> it3 = getGuideInfoList().iterator();
            while (it3.hasNext()) {
                iH += d.h(8, it3.next());
            }
            Iterator<UgcInfo> it4 = getUgcInfoList().iterator();
            while (it4.hasNext()) {
                iH += d.h(9, it4.next());
            }
            Iterator<MapDrawInfo> it5 = getMapDrawInfoList().iterator();
            while (it5.hasNext()) {
                iH += d.h(10, it5.next());
            }
            this.cachedSize = iH;
            return iH;
        }

        public Tip getTip() {
            return this.tip_;
        }

        public UgcInfo getUgcInfo(int i4) {
            return this.ugcInfo_.get(i4);
        }

        public int getUgcInfoCount() {
            return this.ugcInfo_.size();
        }

        public List<UgcInfo> getUgcInfoList() {
            return this.ugcInfo_;
        }

        public boolean hasClimb() {
            return this.hasClimb;
        }

        public boolean hasOtherinfo() {
            return this.hasOtherinfo;
        }

        public boolean hasPlcyInfo() {
            return this.hasPlcyInfo;
        }

        public boolean hasRouteIdf() {
            return this.hasRouteIdf;
        }

        public boolean hasTip() {
            return this.hasTip;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Routes setClimb(Climb climb) {
            if (climb == null) {
                return clearClimb();
            }
            this.hasClimb = true;
            this.climb_ = climb;
            return this;
        }

        public Routes setGuideInfo(int i4, Guideinfo guideinfo) {
            if (guideinfo == null) {
                return this;
            }
            this.guideInfo_.set(i4, guideinfo);
            return this;
        }

        public Routes setLegs(int i4, Legs legs) {
            if (legs == null) {
                return this;
            }
            this.legs_.set(i4, legs);
            return this;
        }

        public Routes setMapDrawInfo(int i4, MapDrawInfo mapDrawInfo) {
            if (mapDrawInfo == null) {
                return this;
            }
            this.mapDrawInfo_.set(i4, mapDrawInfo);
            return this;
        }

        public Routes setMsInfo(int i4, Milestone milestone) {
            if (milestone == null) {
                return this;
            }
            this.msInfo_.set(i4, milestone);
            return this;
        }

        public Routes setOtherinfo(OtherInfo otherInfo) {
            if (otherInfo == null) {
                return clearOtherinfo();
            }
            this.hasOtherinfo = true;
            this.otherinfo_ = otherInfo;
            return this;
        }

        public Routes setPlcyInfo(PolicyInfo policyInfo) {
            if (policyInfo == null) {
                return clearPlcyInfo();
            }
            this.hasPlcyInfo = true;
            this.plcyInfo_ = policyInfo;
            return this;
        }

        public Routes setRouteIdf(String str) {
            this.hasRouteIdf = true;
            this.routeIdf_ = str;
            return this;
        }

        public Routes setTip(Tip tip) {
            if (tip == null) {
                return clearTip();
            }
            this.hasTip = true;
            this.tip_ = tip;
            return this;
        }

        public Routes setUgcInfo(int i4, UgcInfo ugcInfo) {
            if (ugcInfo == null) {
                return this;
            }
            this.ugcInfo_.set(i4, ugcInfo);
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            Iterator<Legs> it = getLegsList().iterator();
            while (it.hasNext()) {
                dVar.u(1, it.next());
            }
            if (hasClimb()) {
                dVar.u(2, getClimb());
            }
            if (hasTip()) {
                dVar.u(3, getTip());
            }
            if (hasOtherinfo()) {
                dVar.u(4, getOtherinfo());
            }
            if (hasPlcyInfo()) {
                dVar.u(5, getPlcyInfo());
            }
            Iterator<Milestone> it2 = getMsInfoList().iterator();
            while (it2.hasNext()) {
                dVar.u(6, it2.next());
            }
            if (hasRouteIdf()) {
                dVar.A(7, getRouteIdf());
            }
            Iterator<Guideinfo> it3 = getGuideInfoList().iterator();
            while (it3.hasNext()) {
                dVar.u(8, it3.next());
            }
            Iterator<UgcInfo> it4 = getUgcInfoList().iterator();
            while (it4.hasNext()) {
                dVar.u(9, it4.next());
            }
            Iterator<MapDrawInfo> it5 = getMapDrawInfoList().iterator();
            while (it5.hasNext()) {
                dVar.u(10, it5.next());
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
                        Legs legs = new Legs();
                        bVar.f(legs);
                        addLegs(legs);
                        break;
                    case 18:
                        Climb climb = new Climb();
                        bVar.f(climb);
                        setClimb(climb);
                        break;
                    case 26:
                        Tip tip = new Tip();
                        bVar.f(tip);
                        setTip(tip);
                        break;
                    case 34:
                        OtherInfo otherInfo = new OtherInfo();
                        bVar.f(otherInfo);
                        setOtherinfo(otherInfo);
                        break;
                    case 42:
                        PolicyInfo policyInfo = new PolicyInfo();
                        bVar.f(policyInfo);
                        setPlcyInfo(policyInfo);
                        break;
                    case 50:
                        Milestone milestone = new Milestone();
                        bVar.f(milestone);
                        addMsInfo(milestone);
                        break;
                    case 58:
                        setRouteIdf(bVar.n());
                        break;
                    case 66:
                        Guideinfo guideinfo = new Guideinfo();
                        bVar.f(guideinfo);
                        addGuideInfo(guideinfo);
                        break;
                    case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                        UgcInfo ugcInfo = new UgcInfo();
                        bVar.f(ugcInfo);
                        addUgcInfo(ugcInfo);
                        break;
                    case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                        MapDrawInfo mapDrawInfo = new MapDrawInfo();
                        bVar.f(mapDrawInfo);
                        addMapDrawInfo(mapDrawInfo);
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

    public static final class Session extends f {
        public static final int CACHE_ID_FIELD_NUMBER = 1;
        private String cacheId_ = "";
        private int cachedSize = -1;
        private boolean hasCacheId;

        public static Session parseFrom(b bVar) throws IOException {
            return new Session().mergeFrom(bVar);
        }

        public final Session clear() {
            clearCacheId();
            this.cachedSize = -1;
            return this;
        }

        public Session clearCacheId() {
            this.hasCacheId = false;
            this.cacheId_ = "";
            return this;
        }

        public String getCacheId() {
            return this.cacheId_;
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
            int iL = hasCacheId() ? d.l(1, getCacheId()) : 0;
            this.cachedSize = iL;
            return iL;
        }

        public boolean hasCacheId() {
            return this.hasCacheId;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Session setCacheId(String str) {
            this.hasCacheId = true;
            this.cacheId_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasCacheId()) {
                dVar.A(1, getCacheId());
            }
        }

        public static Session parseFrom(byte[] bArr) throws e {
            return (Session) new Session().mergeFrom(bArr);
        }

        @Override // L1.f
        public Session mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setCacheId(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class Taxi extends f {
        public static final int DETAIL_FIELD_NUMBER = 4;
        public static final int DISTANCE_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int REMARK_FIELD_NUMBER = 3;
        private boolean hasDistance;
        private boolean hasDuration;
        private boolean hasRemark;
        private String distance_ = "";
        private String duration_ = "";
        private String remark_ = "";
        private List<Detail> detail_ = Collections.emptyList();
        private int cachedSize = -1;

        public static final class Detail extends f {
            public static final int DESC_FIELD_NUMBER = 4;
            public static final int KM_PRICE_FIELD_NUMBER = 1;
            public static final int START_PRICE_FIELD_NUMBER = 2;
            public static final int TOTAL_PRICE_FIELD_NUMBER = 3;
            private boolean hasDesc;
            private boolean hasKmPrice;
            private boolean hasStartPrice;
            private boolean hasTotalPrice;
            private String kmPrice_ = "";
            private String startPrice_ = "";
            private String totalPrice_ = "";
            private String desc_ = "";
            private int cachedSize = -1;

            public static Detail parseFrom(b bVar) throws IOException {
                return new Detail().mergeFrom(bVar);
            }

            public final Detail clear() {
                clearKmPrice();
                clearStartPrice();
                clearTotalPrice();
                clearDesc();
                this.cachedSize = -1;
                return this;
            }

            public Detail clearDesc() {
                this.hasDesc = false;
                this.desc_ = "";
                return this;
            }

            public Detail clearKmPrice() {
                this.hasKmPrice = false;
                this.kmPrice_ = "";
                return this;
            }

            public Detail clearStartPrice() {
                this.hasStartPrice = false;
                this.startPrice_ = "";
                return this;
            }

            public Detail clearTotalPrice() {
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

            public String getDesc() {
                return this.desc_;
            }

            public String getKmPrice() {
                return this.kmPrice_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasKmPrice() ? d.l(1, getKmPrice()) : 0;
                if (hasStartPrice()) {
                    iL += d.l(2, getStartPrice());
                }
                if (hasTotalPrice()) {
                    iL += d.l(3, getTotalPrice());
                }
                if (hasDesc()) {
                    iL += d.l(4, getDesc());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getStartPrice() {
                return this.startPrice_;
            }

            public String getTotalPrice() {
                return this.totalPrice_;
            }

            public boolean hasDesc() {
                return this.hasDesc;
            }

            public boolean hasKmPrice() {
                return this.hasKmPrice;
            }

            public boolean hasStartPrice() {
                return this.hasStartPrice;
            }

            public boolean hasTotalPrice() {
                return this.hasTotalPrice;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Detail setDesc(String str) {
                this.hasDesc = true;
                this.desc_ = str;
                return this;
            }

            public Detail setKmPrice(String str) {
                this.hasKmPrice = true;
                this.kmPrice_ = str;
                return this;
            }

            public Detail setStartPrice(String str) {
                this.hasStartPrice = true;
                this.startPrice_ = str;
                return this;
            }

            public Detail setTotalPrice(String str) {
                this.hasTotalPrice = true;
                this.totalPrice_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasKmPrice()) {
                    dVar.A(1, getKmPrice());
                }
                if (hasStartPrice()) {
                    dVar.A(2, getStartPrice());
                }
                if (hasTotalPrice()) {
                    dVar.A(3, getTotalPrice());
                }
                if (hasDesc()) {
                    dVar.A(4, getDesc());
                }
            }

            public static Detail parseFrom(byte[] bArr) throws e {
                return (Detail) new Detail().mergeFrom(bArr);
            }

            @Override // L1.f
            public Detail mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setKmPrice(bVar.n());
                    } else if (iO == 18) {
                        setStartPrice(bVar.n());
                    } else if (iO == 26) {
                        setTotalPrice(bVar.n());
                    } else if (iO == 34) {
                        setDesc(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static Taxi parseFrom(b bVar) throws IOException {
            return new Taxi().mergeFrom(bVar);
        }

        public Taxi addDetail(Detail detail) {
            if (detail == null) {
                return this;
            }
            if (this.detail_.isEmpty()) {
                this.detail_ = new ArrayList();
            }
            this.detail_.add(detail);
            return this;
        }

        public final Taxi clear() {
            clearDistance();
            clearDuration();
            clearRemark();
            clearDetail();
            this.cachedSize = -1;
            return this;
        }

        public Taxi clearDetail() {
            this.detail_ = Collections.emptyList();
            return this;
        }

        public Taxi clearDistance() {
            this.hasDistance = false;
            this.distance_ = "";
            return this;
        }

        public Taxi clearDuration() {
            this.hasDuration = false;
            this.duration_ = "";
            return this;
        }

        public Taxi clearRemark() {
            this.hasRemark = false;
            this.remark_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public Detail getDetail(int i4) {
            return this.detail_.get(i4);
        }

        public int getDetailCount() {
            return this.detail_.size();
        }

        public List<Detail> getDetailList() {
            return this.detail_;
        }

        public String getDistance() {
            return this.distance_;
        }

        public String getDuration() {
            return this.duration_;
        }

        public String getRemark() {
            return this.remark_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasDistance() ? d.l(1, getDistance()) : 0;
            if (hasDuration()) {
                iL += d.l(2, getDuration());
            }
            if (hasRemark()) {
                iL += d.l(3, getRemark());
            }
            Iterator<Detail> it = getDetailList().iterator();
            while (it.hasNext()) {
                iL += d.h(4, it.next());
            }
            this.cachedSize = iL;
            return iL;
        }

        public boolean hasDistance() {
            return this.hasDistance;
        }

        public boolean hasDuration() {
            return this.hasDuration;
        }

        public boolean hasRemark() {
            return this.hasRemark;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Taxi setDetail(int i4, Detail detail) {
            if (detail == null) {
                return this;
            }
            this.detail_.set(i4, detail);
            return this;
        }

        public Taxi setDistance(String str) {
            this.hasDistance = true;
            this.distance_ = str;
            return this;
        }

        public Taxi setDuration(String str) {
            this.hasDuration = true;
            this.duration_ = str;
            return this;
        }

        public Taxi setRemark(String str) {
            this.hasRemark = true;
            this.remark_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasDistance()) {
                dVar.A(1, getDistance());
            }
            if (hasDuration()) {
                dVar.A(2, getDuration());
            }
            if (hasRemark()) {
                dVar.A(3, getRemark());
            }
            Iterator<Detail> it = getDetailList().iterator();
            while (it.hasNext()) {
                dVar.u(4, it.next());
            }
        }

        public static Taxi parseFrom(byte[] bArr) throws e {
            return (Taxi) new Taxi().mergeFrom(bArr);
        }

        @Override // L1.f
        public Taxi mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setDistance(bVar.n());
                } else if (iO == 18) {
                    setDuration(bVar.n());
                } else if (iO == 26) {
                    setRemark(bVar.n());
                } else if (iO == 34) {
                    Detail detail = new Detail();
                    bVar.f(detail);
                    addDetail(detail);
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static WalkPlan parseFrom(b bVar) throws IOException {
        return new WalkPlan().mergeFrom(bVar);
    }

    public WalkPlan addArGuide(ARGuide aRGuide) {
        if (aRGuide == null) {
            return this;
        }
        if (this.arGuide_.isEmpty()) {
            this.arGuide_ = new ArrayList();
        }
        this.arGuide_.add(aRGuide);
        return this;
    }

    public WalkPlan addIndoorNavis(IndoorNavi indoorNavi) {
        if (indoorNavi == null) {
            return this;
        }
        if (this.indoorNavis_.isEmpty()) {
            this.indoorNavis_ = new ArrayList();
        }
        this.indoorNavis_.add(indoorNavi);
        return this;
    }

    public WalkPlan addRoutes(Routes routes) {
        if (routes == null) {
            return this;
        }
        if (this.routes_.isEmpty()) {
            this.routes_ = new ArrayList();
        }
        this.routes_.add(routes);
        return this;
    }

    public final WalkPlan clear() {
        clearTaxi();
        clearRoutes();
        clearOption();
        clearCurrentCity();
        clearIndoorNavis();
        clearYawStatus();
        clearArGuide();
        clearAppendRouteinfList();
        clearSession();
        clearVehicle();
        this.cachedSize = -1;
        return this;
    }

    public WalkPlan clearAppendRouteinfList() {
        this.hasAppendRouteinfList = false;
        this.appendRouteinfList_ = null;
        return this;
    }

    public WalkPlan clearArGuide() {
        this.arGuide_ = Collections.emptyList();
        return this;
    }

    public WalkPlan clearCurrentCity() {
        this.hasCurrentCity = false;
        this.currentCity_ = null;
        return this;
    }

    public WalkPlan clearIndoorNavis() {
        this.indoorNavis_ = Collections.emptyList();
        return this;
    }

    public WalkPlan clearOption() {
        this.hasOption = false;
        this.option_ = null;
        return this;
    }

    public WalkPlan clearRoutes() {
        this.routes_ = Collections.emptyList();
        return this;
    }

    public WalkPlan clearSession() {
        this.hasSession = false;
        this.session_ = null;
        return this;
    }

    public WalkPlan clearTaxi() {
        this.hasTaxi = false;
        this.taxi_ = null;
        return this;
    }

    public WalkPlan clearVehicle() {
        this.hasVehicle = false;
        this.vehicle_ = 0;
        return this;
    }

    public WalkPlan clearYawStatus() {
        this.hasYawStatus = false;
        this.yawStatus_ = 0;
        return this;
    }

    public AppendRouteInf getAppendRouteinfList() {
        return this.appendRouteinfList_;
    }

    public ARGuide getArGuide(int i4) {
        return this.arGuide_.get(i4);
    }

    public int getArGuideCount() {
        return this.arGuide_.size();
    }

    public List<ARGuide> getArGuideList() {
        return this.arGuide_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public CurrentCity getCurrentCity() {
        return this.currentCity_;
    }

    public IndoorNavi getIndoorNavis(int i4) {
        return this.indoorNavis_.get(i4);
    }

    public int getIndoorNavisCount() {
        return this.indoorNavis_.size();
    }

    public List<IndoorNavi> getIndoorNavisList() {
        return this.indoorNavis_;
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
        Iterator<Routes> it = getRoutesList().iterator();
        int iE = 0;
        while (it.hasNext()) {
            iE += d.h(1, it.next());
        }
        if (hasTaxi()) {
            iE += d.h(2, getTaxi());
        }
        if (hasOption()) {
            iE += d.h(3, getOption());
        }
        if (hasCurrentCity()) {
            iE += d.h(4, getCurrentCity());
        }
        Iterator<IndoorNavi> it2 = getIndoorNavisList().iterator();
        while (it2.hasNext()) {
            iE += d.h(5, it2.next());
        }
        if (hasYawStatus()) {
            iE += d.e(6, getYawStatus());
        }
        Iterator<ARGuide> it3 = getArGuideList().iterator();
        while (it3.hasNext()) {
            iE += d.h(7, it3.next());
        }
        if (hasAppendRouteinfList()) {
            iE += d.h(8, getAppendRouteinfList());
        }
        if (hasSession()) {
            iE += d.h(9, getSession());
        }
        if (hasVehicle()) {
            iE += d.e(10, getVehicle());
        }
        this.cachedSize = iE;
        return iE;
    }

    public Session getSession() {
        return this.session_;
    }

    public Taxi getTaxi() {
        return this.taxi_;
    }

    public int getVehicle() {
        return this.vehicle_;
    }

    public int getYawStatus() {
        return this.yawStatus_;
    }

    public boolean hasAppendRouteinfList() {
        return this.hasAppendRouteinfList;
    }

    public boolean hasCurrentCity() {
        return this.hasCurrentCity;
    }

    public boolean hasOption() {
        return this.hasOption;
    }

    public boolean hasSession() {
        return this.hasSession;
    }

    public boolean hasTaxi() {
        return this.hasTaxi;
    }

    public boolean hasVehicle() {
        return this.hasVehicle;
    }

    public boolean hasYawStatus() {
        return this.hasYawStatus;
    }

    public final boolean isInitialized() {
        return true;
    }

    public WalkPlan setAppendRouteinfList(AppendRouteInf appendRouteInf) {
        if (appendRouteInf == null) {
            return clearAppendRouteinfList();
        }
        this.hasAppendRouteinfList = true;
        this.appendRouteinfList_ = appendRouteInf;
        return this;
    }

    public WalkPlan setArGuide(int i4, ARGuide aRGuide) {
        if (aRGuide == null) {
            return this;
        }
        this.arGuide_.set(i4, aRGuide);
        return this;
    }

    public WalkPlan setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.hasCurrentCity = true;
        this.currentCity_ = currentCity;
        return this;
    }

    public WalkPlan setIndoorNavis(int i4, IndoorNavi indoorNavi) {
        if (indoorNavi == null) {
            return this;
        }
        this.indoorNavis_.set(i4, indoorNavi);
        return this;
    }

    public WalkPlan setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.hasOption = true;
        this.option_ = option;
        return this;
    }

    public WalkPlan setRoutes(int i4, Routes routes) {
        if (routes == null) {
            return this;
        }
        this.routes_.set(i4, routes);
        return this;
    }

    public WalkPlan setSession(Session session) {
        if (session == null) {
            return clearSession();
        }
        this.hasSession = true;
        this.session_ = session;
        return this;
    }

    public WalkPlan setTaxi(Taxi taxi) {
        if (taxi == null) {
            return clearTaxi();
        }
        this.hasTaxi = true;
        this.taxi_ = taxi;
        return this;
    }

    public WalkPlan setVehicle(int i4) {
        this.hasVehicle = true;
        this.vehicle_ = i4;
        return this;
    }

    public WalkPlan setYawStatus(int i4) {
        this.hasYawStatus = true;
        this.yawStatus_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        Iterator<Routes> it = getRoutesList().iterator();
        while (it.hasNext()) {
            dVar.u(1, it.next());
        }
        if (hasTaxi()) {
            dVar.u(2, getTaxi());
        }
        if (hasOption()) {
            dVar.u(3, getOption());
        }
        if (hasCurrentCity()) {
            dVar.u(4, getCurrentCity());
        }
        Iterator<IndoorNavi> it2 = getIndoorNavisList().iterator();
        while (it2.hasNext()) {
            dVar.u(5, it2.next());
        }
        if (hasYawStatus()) {
            dVar.s(6, getYawStatus());
        }
        Iterator<ARGuide> it3 = getArGuideList().iterator();
        while (it3.hasNext()) {
            dVar.u(7, it3.next());
        }
        if (hasAppendRouteinfList()) {
            dVar.u(8, getAppendRouteinfList());
        }
        if (hasSession()) {
            dVar.u(9, getSession());
        }
        if (hasVehicle()) {
            dVar.s(10, getVehicle());
        }
    }

    public static WalkPlan parseFrom(byte[] bArr) throws e {
        return (WalkPlan) new WalkPlan().mergeFrom(bArr);
    }

    @Override // L1.f
    public WalkPlan mergeFrom(b bVar) throws IOException {
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
                    Taxi taxi = new Taxi();
                    bVar.f(taxi);
                    setTaxi(taxi);
                    break;
                case 26:
                    Option option = new Option();
                    bVar.f(option);
                    setOption(option);
                    break;
                case 34:
                    CurrentCity currentCity = new CurrentCity();
                    bVar.f(currentCity);
                    setCurrentCity(currentCity);
                    break;
                case 42:
                    IndoorNavi indoorNavi = new IndoorNavi();
                    bVar.f(indoorNavi);
                    addIndoorNavis(indoorNavi);
                    break;
                case 48:
                    setYawStatus(bVar.k());
                    break;
                case 58:
                    ARGuide aRGuide = new ARGuide();
                    bVar.f(aRGuide);
                    addArGuide(aRGuide);
                    break;
                case 66:
                    AppendRouteInf appendRouteInf = new AppendRouteInf();
                    bVar.f(appendRouteInf);
                    setAppendRouteinfList(appendRouteInf);
                    break;
                case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                    Session session = new Session();
                    bVar.f(session);
                    setSession(session);
                    break;
                case 80:
                    setVehicle(bVar.k());
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
