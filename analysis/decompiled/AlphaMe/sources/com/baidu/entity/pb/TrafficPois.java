package com.baidu.entity.pb;

import L1.a;
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
public final class TrafficPois extends f {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int CURRENT_CITY_FIELD_NUMBER = 2;
    public static final int IMGE_SHOW_FIELD_NUMBER = 6;
    public static final int LIST_TYPE_FIELD_NUMBER = 7;
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int SUGGEST_QUERY_FIELD_NUMBER = 4;
    public static final int SUGGEST_QUERY_FLAG_FIELD_NUMBER = 5;
    private boolean hasContent;
    private boolean hasCurrentCity;
    private boolean hasImgeShow;
    private boolean hasListType;
    private boolean hasOption;
    private boolean hasSuggestQueryFlag;
    private Option option_ = null;
    private CurrentCity currentCity_ = null;
    private Content content_ = null;
    private List<SuggestQuery> suggestQuery_ = Collections.emptyList();
    private int suggestQueryFlag_ = 0;
    private ImageShow imgeShow_ = null;
    private int listType_ = 0;
    private int cachedSize = -1;

    public static final class Content extends f {
        public static final int END_FIELD_NUMBER = 2;
        public static final int MULTI_WAYPOINTS_FIELD_NUMBER = 4;
        public static final int START_FIELD_NUMBER = 1;
        public static final int WAY_POINTS_FIELD_NUMBER = 3;
        private List<Start> start_ = Collections.emptyList();
        private List<End> end_ = Collections.emptyList();
        private List<WayPoints> wayPoints_ = Collections.emptyList();
        private List<MultiWaypoints> multiWaypoints_ = Collections.emptyList();
        private int cachedSize = -1;

        public static final class End extends f {
            public static final int ADDR_FIELD_NUMBER = 5;
            public static final int CODE_FIELD_NUMBER = 1;
            public static final int DESCRIBE_FIELD_NUMBER = 13;
            public static final int DIRECTION_FIELD_NUMBER = 12;
            public static final int DIST_FIELD_NUMBER = 11;
            public static final int EXT_FIELD_NUMBER = 7;
            public static final int GEO_FIELD_NUMBER = 6;
            public static final int HISTORY_ADDRESS_FIELD_NUMBER = 15;
            public static final int IMAGE_URL_FIELD_NUMBER = 14;
            public static final int INDOOR_FLOOR_FIELD_NUMBER = 9;
            public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 10;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int NUM_FIELD_NUMBER = 3;
            public static final int POITYPE_FIELD_NUMBER = 8;
            public static final int UID_FIELD_NUMBER = 4;
            private boolean hasAddr;
            private boolean hasCode;
            private boolean hasDescribe;
            private boolean hasDirection;
            private boolean hasDist;
            private boolean hasExt;
            private boolean hasGeo;
            private boolean hasHistoryAddress;
            private boolean hasImageUrl;
            private boolean hasIndoorFloor;
            private boolean hasIndoorParentUid;
            private boolean hasName;
            private boolean hasNum;
            private boolean hasPoiType;
            private boolean hasUid;
            private int code_ = 0;
            private String name_ = "";
            private int num_ = 0;
            private String uid_ = "";
            private String addr_ = "";
            private String geo_ = "";
            private String ext_ = "";
            private int poiType_ = 0;
            private String indoorFloor_ = "";
            private String indoorParentUid_ = "";
            private int dist_ = 0;
            private int direction_ = 0;
            private String describe_ = "";
            private a imageUrl_ = a.f1216c;
            private String historyAddress_ = "";
            private int cachedSize = -1;

            public static End parseFrom(b bVar) throws IOException {
                return new End().mergeFrom(bVar);
            }

            public final End clear() {
                clearCode();
                clearName();
                clearNum();
                clearUid();
                clearAddr();
                clearGeo();
                clearExt();
                clearPoiType();
                clearIndoorFloor();
                clearIndoorParentUid();
                clearDist();
                clearDirection();
                clearDescribe();
                clearImageUrl();
                clearHistoryAddress();
                this.cachedSize = -1;
                return this;
            }

            public End clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public End clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            public End clearDescribe() {
                this.hasDescribe = false;
                this.describe_ = "";
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

            public End clearExt() {
                this.hasExt = false;
                this.ext_ = "";
                return this;
            }

            public End clearGeo() {
                this.hasGeo = false;
                this.geo_ = "";
                return this;
            }

            public End clearHistoryAddress() {
                this.hasHistoryAddress = false;
                this.historyAddress_ = "";
                return this;
            }

            public End clearImageUrl() {
                this.hasImageUrl = false;
                this.imageUrl_ = a.f1216c;
                return this;
            }

            public End clearIndoorFloor() {
                this.hasIndoorFloor = false;
                this.indoorFloor_ = "";
                return this;
            }

            public End clearIndoorParentUid() {
                this.hasIndoorParentUid = false;
                this.indoorParentUid_ = "";
                return this;
            }

            public End clearName() {
                this.hasName = false;
                this.name_ = "";
                return this;
            }

            public End clearNum() {
                this.hasNum = false;
                this.num_ = 0;
                return this;
            }

            public End clearPoiType() {
                this.hasPoiType = false;
                this.poiType_ = 0;
                return this;
            }

            public End clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public String getAddr() {
                return this.addr_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getCode() {
                return this.code_;
            }

            public String getDescribe() {
                return this.describe_;
            }

            public int getDirection() {
                return this.direction_;
            }

            public int getDist() {
                return this.dist_;
            }

            public String getExt() {
                return this.ext_;
            }

            public String getGeo() {
                return this.geo_;
            }

            public String getHistoryAddress() {
                return this.historyAddress_;
            }

            public a getImageUrl() {
                return this.imageUrl_;
            }

            public String getIndoorFloor() {
                return this.indoorFloor_;
            }

            public String getIndoorParentUid() {
                return this.indoorParentUid_;
            }

            public String getName() {
                return this.name_;
            }

            public int getNum() {
                return this.num_;
            }

            public int getPoiType() {
                return this.poiType_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasCode() ? d.e(1, getCode()) : 0;
                if (hasName()) {
                    iE += d.l(2, getName());
                }
                if (hasNum()) {
                    iE += d.e(3, getNum());
                }
                if (hasUid()) {
                    iE += d.l(4, getUid());
                }
                if (hasAddr()) {
                    iE += d.l(5, getAddr());
                }
                if (hasGeo()) {
                    iE += d.l(6, getGeo());
                }
                if (hasExt()) {
                    iE += d.l(7, getExt());
                }
                if (hasPoiType()) {
                    iE += d.e(8, getPoiType());
                }
                if (hasIndoorFloor()) {
                    iE += d.l(9, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    iE += d.l(10, getIndoorParentUid());
                }
                if (hasDist()) {
                    iE += d.e(11, getDist());
                }
                if (hasDirection()) {
                    iE += d.e(12, getDirection());
                }
                if (hasDescribe()) {
                    iE += d.l(13, getDescribe());
                }
                if (hasImageUrl()) {
                    iE += d.b(14, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    iE += d.l(15, getHistoryAddress());
                }
                this.cachedSize = iE;
                return iE;
            }

            public String getUid() {
                return this.uid_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public boolean hasDescribe() {
                return this.hasDescribe;
            }

            public boolean hasDirection() {
                return this.hasDirection;
            }

            public boolean hasDist() {
                return this.hasDist;
            }

            public boolean hasExt() {
                return this.hasExt;
            }

            public boolean hasGeo() {
                return this.hasGeo;
            }

            public boolean hasHistoryAddress() {
                return this.hasHistoryAddress;
            }

            public boolean hasImageUrl() {
                return this.hasImageUrl;
            }

            public boolean hasIndoorFloor() {
                return this.hasIndoorFloor;
            }

            public boolean hasIndoorParentUid() {
                return this.hasIndoorParentUid;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasNum() {
                return this.hasNum;
            }

            public boolean hasPoiType() {
                return this.hasPoiType;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public final boolean isInitialized() {
                return true;
            }

            public End setAddr(String str) {
                this.hasAddr = true;
                this.addr_ = str;
                return this;
            }

            public End setCode(int i4) {
                this.hasCode = true;
                this.code_ = i4;
                return this;
            }

            public End setDescribe(String str) {
                this.hasDescribe = true;
                this.describe_ = str;
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

            public End setExt(String str) {
                this.hasExt = true;
                this.ext_ = str;
                return this;
            }

            public End setGeo(String str) {
                this.hasGeo = true;
                this.geo_ = str;
                return this;
            }

            public End setHistoryAddress(String str) {
                this.hasHistoryAddress = true;
                this.historyAddress_ = str;
                return this;
            }

            public End setImageUrl(a aVar) {
                this.hasImageUrl = true;
                this.imageUrl_ = aVar;
                return this;
            }

            public End setIndoorFloor(String str) {
                this.hasIndoorFloor = true;
                this.indoorFloor_ = str;
                return this;
            }

            public End setIndoorParentUid(String str) {
                this.hasIndoorParentUid = true;
                this.indoorParentUid_ = str;
                return this;
            }

            public End setName(String str) {
                this.hasName = true;
                this.name_ = str;
                return this;
            }

            public End setNum(int i4) {
                this.hasNum = true;
                this.num_ = i4;
                return this;
            }

            public End setPoiType(int i4) {
                this.hasPoiType = true;
                this.poiType_ = i4;
                return this;
            }

            public End setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasCode()) {
                    dVar.s(1, getCode());
                }
                if (hasName()) {
                    dVar.A(2, getName());
                }
                if (hasNum()) {
                    dVar.s(3, getNum());
                }
                if (hasUid()) {
                    dVar.A(4, getUid());
                }
                if (hasAddr()) {
                    dVar.A(5, getAddr());
                }
                if (hasGeo()) {
                    dVar.A(6, getGeo());
                }
                if (hasExt()) {
                    dVar.A(7, getExt());
                }
                if (hasPoiType()) {
                    dVar.s(8, getPoiType());
                }
                if (hasIndoorFloor()) {
                    dVar.A(9, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    dVar.A(10, getIndoorParentUid());
                }
                if (hasDist()) {
                    dVar.s(11, getDist());
                }
                if (hasDirection()) {
                    dVar.s(12, getDirection());
                }
                if (hasDescribe()) {
                    dVar.A(13, getDescribe());
                }
                if (hasImageUrl()) {
                    dVar.q(14, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    dVar.A(15, getHistoryAddress());
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
                        case 8:
                            setCode(bVar.k());
                            break;
                        case 18:
                            setName(bVar.n());
                            break;
                        case 24:
                            setNum(bVar.k());
                            break;
                        case 34:
                            setUid(bVar.n());
                            break;
                        case 42:
                            setAddr(bVar.n());
                            break;
                        case 50:
                            setGeo(bVar.n());
                            break;
                        case 58:
                            setExt(bVar.n());
                            break;
                        case 64:
                            setPoiType(bVar.k());
                            break;
                        case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                            setIndoorFloor(bVar.n());
                            break;
                        case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                            setIndoorParentUid(bVar.n());
                            break;
                        case 88:
                            setDist(bVar.k());
                            break;
                        case 96:
                            setDirection(bVar.k());
                            break;
                        case 106:
                            setDescribe(bVar.n());
                            break;
                        case 114:
                            setImageUrl(bVar.b());
                            break;
                        case 122:
                            setHistoryAddress(bVar.n());
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

        public static final class MultiWaypoints extends f {
            public static final int WAY_POINTS_FIELD_NUMBER = 1;
            private List<WayPoints> wayPoints_ = Collections.emptyList();
            private int cachedSize = -1;

            public static final class WayPoints extends f {
                public static final int ADDR_FIELD_NUMBER = 5;
                public static final int CODE_FIELD_NUMBER = 1;
                public static final int GEO_FIELD_NUMBER = 6;
                public static final int NAME_FIELD_NUMBER = 2;
                public static final int NUM_FIELD_NUMBER = 3;
                public static final int UID_FIELD_NUMBER = 4;
                private boolean hasAddr;
                private boolean hasCode;
                private boolean hasGeo;
                private boolean hasName;
                private boolean hasNum;
                private boolean hasUid;
                private int code_ = 0;
                private String name_ = "";
                private int num_ = 0;
                private String uid_ = "";
                private String addr_ = "";
                private String geo_ = "";
                private int cachedSize = -1;

                public static WayPoints parseFrom(b bVar) throws IOException {
                    return new WayPoints().mergeFrom(bVar);
                }

                public final WayPoints clear() {
                    clearCode();
                    clearName();
                    clearNum();
                    clearUid();
                    clearAddr();
                    clearGeo();
                    this.cachedSize = -1;
                    return this;
                }

                public WayPoints clearAddr() {
                    this.hasAddr = false;
                    this.addr_ = "";
                    return this;
                }

                public WayPoints clearCode() {
                    this.hasCode = false;
                    this.code_ = 0;
                    return this;
                }

                public WayPoints clearGeo() {
                    this.hasGeo = false;
                    this.geo_ = "";
                    return this;
                }

                public WayPoints clearName() {
                    this.hasName = false;
                    this.name_ = "";
                    return this;
                }

                public WayPoints clearNum() {
                    this.hasNum = false;
                    this.num_ = 0;
                    return this;
                }

                public WayPoints clearUid() {
                    this.hasUid = false;
                    this.uid_ = "";
                    return this;
                }

                public String getAddr() {
                    return this.addr_;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCode() {
                    return this.code_;
                }

                public String getGeo() {
                    return this.geo_;
                }

                public String getName() {
                    return this.name_;
                }

                public int getNum() {
                    return this.num_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasCode() ? d.e(1, getCode()) : 0;
                    if (hasName()) {
                        iE += d.l(2, getName());
                    }
                    if (hasNum()) {
                        iE += d.e(3, getNum());
                    }
                    if (hasUid()) {
                        iE += d.l(4, getUid());
                    }
                    if (hasAddr()) {
                        iE += d.l(5, getAddr());
                    }
                    if (hasGeo()) {
                        iE += d.l(6, getGeo());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public String getUid() {
                    return this.uid_;
                }

                public boolean hasAddr() {
                    return this.hasAddr;
                }

                public boolean hasCode() {
                    return this.hasCode;
                }

                public boolean hasGeo() {
                    return this.hasGeo;
                }

                public boolean hasName() {
                    return this.hasName;
                }

                public boolean hasNum() {
                    return this.hasNum;
                }

                public boolean hasUid() {
                    return this.hasUid;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public WayPoints setAddr(String str) {
                    this.hasAddr = true;
                    this.addr_ = str;
                    return this;
                }

                public WayPoints setCode(int i4) {
                    this.hasCode = true;
                    this.code_ = i4;
                    return this;
                }

                public WayPoints setGeo(String str) {
                    this.hasGeo = true;
                    this.geo_ = str;
                    return this;
                }

                public WayPoints setName(String str) {
                    this.hasName = true;
                    this.name_ = str;
                    return this;
                }

                public WayPoints setNum(int i4) {
                    this.hasNum = true;
                    this.num_ = i4;
                    return this;
                }

                public WayPoints setUid(String str) {
                    this.hasUid = true;
                    this.uid_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasCode()) {
                        dVar.s(1, getCode());
                    }
                    if (hasName()) {
                        dVar.A(2, getName());
                    }
                    if (hasNum()) {
                        dVar.s(3, getNum());
                    }
                    if (hasUid()) {
                        dVar.A(4, getUid());
                    }
                    if (hasAddr()) {
                        dVar.A(5, getAddr());
                    }
                    if (hasGeo()) {
                        dVar.A(6, getGeo());
                    }
                }

                public static WayPoints parseFrom(byte[] bArr) throws e {
                    return (WayPoints) new WayPoints().mergeFrom(bArr);
                }

                @Override // L1.f
                public WayPoints mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setCode(bVar.k());
                        } else if (iO == 18) {
                            setName(bVar.n());
                        } else if (iO == 24) {
                            setNum(bVar.k());
                        } else if (iO == 34) {
                            setUid(bVar.n());
                        } else if (iO == 42) {
                            setAddr(bVar.n());
                        } else if (iO == 50) {
                            setGeo(bVar.n());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static MultiWaypoints parseFrom(b bVar) throws IOException {
                return new MultiWaypoints().mergeFrom(bVar);
            }

            public MultiWaypoints addWayPoints(WayPoints wayPoints) {
                if (wayPoints == null) {
                    return this;
                }
                if (this.wayPoints_.isEmpty()) {
                    this.wayPoints_ = new ArrayList();
                }
                this.wayPoints_.add(wayPoints);
                return this;
            }

            public final MultiWaypoints clear() {
                clearWayPoints();
                this.cachedSize = -1;
                return this;
            }

            public MultiWaypoints clearWayPoints() {
                this.wayPoints_ = Collections.emptyList();
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
                Iterator<WayPoints> it = getWayPointsList().iterator();
                int iH = 0;
                while (it.hasNext()) {
                    iH += d.h(1, it.next());
                }
                this.cachedSize = iH;
                return iH;
            }

            public WayPoints getWayPoints(int i4) {
                return this.wayPoints_.get(i4);
            }

            public int getWayPointsCount() {
                return this.wayPoints_.size();
            }

            public List<WayPoints> getWayPointsList() {
                return this.wayPoints_;
            }

            public final boolean isInitialized() {
                return true;
            }

            public MultiWaypoints setWayPoints(int i4, WayPoints wayPoints) {
                if (wayPoints == null) {
                    return this;
                }
                this.wayPoints_.set(i4, wayPoints);
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                Iterator<WayPoints> it = getWayPointsList().iterator();
                while (it.hasNext()) {
                    dVar.u(1, it.next());
                }
            }

            public static MultiWaypoints parseFrom(byte[] bArr) throws e {
                return (MultiWaypoints) new MultiWaypoints().mergeFrom(bArr);
            }

            @Override // L1.f
            public MultiWaypoints mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        WayPoints wayPoints = new WayPoints();
                        bVar.f(wayPoints);
                        addWayPoints(wayPoints);
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Start extends f {
            public static final int ADDR_FIELD_NUMBER = 5;
            public static final int CODE_FIELD_NUMBER = 1;
            public static final int DESCRIBE_FIELD_NUMBER = 9;
            public static final int GEO_FIELD_NUMBER = 6;
            public static final int HISTORY_ADDRESS_FIELD_NUMBER = 11;
            public static final int IMAGE_URL_FIELD_NUMBER = 10;
            public static final int INDOOR_FLOOR_FIELD_NUMBER = 7;
            public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 8;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int NUM_FIELD_NUMBER = 3;
            public static final int UID_FIELD_NUMBER = 4;
            private boolean hasAddr;
            private boolean hasCode;
            private boolean hasDescribe;
            private boolean hasGeo;
            private boolean hasHistoryAddress;
            private boolean hasImageUrl;
            private boolean hasIndoorFloor;
            private boolean hasIndoorParentUid;
            private boolean hasName;
            private boolean hasNum;
            private boolean hasUid;
            private int code_ = 0;
            private String name_ = "";
            private int num_ = 0;
            private String uid_ = "";
            private String addr_ = "";
            private String geo_ = "";
            private String indoorFloor_ = "";
            private String indoorParentUid_ = "";
            private String describe_ = "";
            private a imageUrl_ = a.f1216c;
            private String historyAddress_ = "";
            private int cachedSize = -1;

            public static Start parseFrom(b bVar) throws IOException {
                return new Start().mergeFrom(bVar);
            }

            public final Start clear() {
                clearCode();
                clearName();
                clearNum();
                clearUid();
                clearAddr();
                clearGeo();
                clearIndoorFloor();
                clearIndoorParentUid();
                clearDescribe();
                clearImageUrl();
                clearHistoryAddress();
                this.cachedSize = -1;
                return this;
            }

            public Start clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public Start clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            public Start clearDescribe() {
                this.hasDescribe = false;
                this.describe_ = "";
                return this;
            }

            public Start clearGeo() {
                this.hasGeo = false;
                this.geo_ = "";
                return this;
            }

            public Start clearHistoryAddress() {
                this.hasHistoryAddress = false;
                this.historyAddress_ = "";
                return this;
            }

            public Start clearImageUrl() {
                this.hasImageUrl = false;
                this.imageUrl_ = a.f1216c;
                return this;
            }

            public Start clearIndoorFloor() {
                this.hasIndoorFloor = false;
                this.indoorFloor_ = "";
                return this;
            }

            public Start clearIndoorParentUid() {
                this.hasIndoorParentUid = false;
                this.indoorParentUid_ = "";
                return this;
            }

            public Start clearName() {
                this.hasName = false;
                this.name_ = "";
                return this;
            }

            public Start clearNum() {
                this.hasNum = false;
                this.num_ = 0;
                return this;
            }

            public Start clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public String getAddr() {
                return this.addr_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getCode() {
                return this.code_;
            }

            public String getDescribe() {
                return this.describe_;
            }

            public String getGeo() {
                return this.geo_;
            }

            public String getHistoryAddress() {
                return this.historyAddress_;
            }

            public a getImageUrl() {
                return this.imageUrl_;
            }

            public String getIndoorFloor() {
                return this.indoorFloor_;
            }

            public String getIndoorParentUid() {
                return this.indoorParentUid_;
            }

            public String getName() {
                return this.name_;
            }

            public int getNum() {
                return this.num_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasCode() ? d.e(1, getCode()) : 0;
                if (hasName()) {
                    iE += d.l(2, getName());
                }
                if (hasNum()) {
                    iE += d.e(3, getNum());
                }
                if (hasUid()) {
                    iE += d.l(4, getUid());
                }
                if (hasAddr()) {
                    iE += d.l(5, getAddr());
                }
                if (hasGeo()) {
                    iE += d.l(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    iE += d.l(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    iE += d.l(8, getIndoorParentUid());
                }
                if (hasDescribe()) {
                    iE += d.l(9, getDescribe());
                }
                if (hasImageUrl()) {
                    iE += d.b(10, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    iE += d.l(11, getHistoryAddress());
                }
                this.cachedSize = iE;
                return iE;
            }

            public String getUid() {
                return this.uid_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public boolean hasDescribe() {
                return this.hasDescribe;
            }

            public boolean hasGeo() {
                return this.hasGeo;
            }

            public boolean hasHistoryAddress() {
                return this.hasHistoryAddress;
            }

            public boolean hasImageUrl() {
                return this.hasImageUrl;
            }

            public boolean hasIndoorFloor() {
                return this.hasIndoorFloor;
            }

            public boolean hasIndoorParentUid() {
                return this.hasIndoorParentUid;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasNum() {
                return this.hasNum;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Start setAddr(String str) {
                this.hasAddr = true;
                this.addr_ = str;
                return this;
            }

            public Start setCode(int i4) {
                this.hasCode = true;
                this.code_ = i4;
                return this;
            }

            public Start setDescribe(String str) {
                this.hasDescribe = true;
                this.describe_ = str;
                return this;
            }

            public Start setGeo(String str) {
                this.hasGeo = true;
                this.geo_ = str;
                return this;
            }

            public Start setHistoryAddress(String str) {
                this.hasHistoryAddress = true;
                this.historyAddress_ = str;
                return this;
            }

            public Start setImageUrl(a aVar) {
                this.hasImageUrl = true;
                this.imageUrl_ = aVar;
                return this;
            }

            public Start setIndoorFloor(String str) {
                this.hasIndoorFloor = true;
                this.indoorFloor_ = str;
                return this;
            }

            public Start setIndoorParentUid(String str) {
                this.hasIndoorParentUid = true;
                this.indoorParentUid_ = str;
                return this;
            }

            public Start setName(String str) {
                this.hasName = true;
                this.name_ = str;
                return this;
            }

            public Start setNum(int i4) {
                this.hasNum = true;
                this.num_ = i4;
                return this;
            }

            public Start setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasCode()) {
                    dVar.s(1, getCode());
                }
                if (hasName()) {
                    dVar.A(2, getName());
                }
                if (hasNum()) {
                    dVar.s(3, getNum());
                }
                if (hasUid()) {
                    dVar.A(4, getUid());
                }
                if (hasAddr()) {
                    dVar.A(5, getAddr());
                }
                if (hasGeo()) {
                    dVar.A(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    dVar.A(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    dVar.A(8, getIndoorParentUid());
                }
                if (hasDescribe()) {
                    dVar.A(9, getDescribe());
                }
                if (hasImageUrl()) {
                    dVar.q(10, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    dVar.A(11, getHistoryAddress());
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
                        case 8:
                            setCode(bVar.k());
                            break;
                        case 18:
                            setName(bVar.n());
                            break;
                        case 24:
                            setNum(bVar.k());
                            break;
                        case 34:
                            setUid(bVar.n());
                            break;
                        case 42:
                            setAddr(bVar.n());
                            break;
                        case 50:
                            setGeo(bVar.n());
                            break;
                        case 58:
                            setIndoorFloor(bVar.n());
                            break;
                        case 66:
                            setIndoorParentUid(bVar.n());
                            break;
                        case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                            setDescribe(bVar.n());
                            break;
                        case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                            setImageUrl(bVar.b());
                            break;
                        case 90:
                            setHistoryAddress(bVar.n());
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

        public static final class WayPoints extends f {
            public static final int ADDR_FIELD_NUMBER = 5;
            public static final int CODE_FIELD_NUMBER = 1;
            public static final int DESCRIBE_FIELD_NUMBER = 11;
            public static final int DIRECTION_FIELD_NUMBER = 10;
            public static final int DIST_FIELD_NUMBER = 9;
            public static final int GEO_FIELD_NUMBER = 6;
            public static final int HISTORY_ADDRESS_FIELD_NUMBER = 13;
            public static final int IMAGE_URL_FIELD_NUMBER = 12;
            public static final int INDOOR_FLOOR_FIELD_NUMBER = 7;
            public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 8;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int NUM_FIELD_NUMBER = 3;
            public static final int UID_FIELD_NUMBER = 4;
            private boolean hasAddr;
            private boolean hasCode;
            private boolean hasDescribe;
            private boolean hasDirection;
            private boolean hasDist;
            private boolean hasGeo;
            private boolean hasHistoryAddress;
            private boolean hasImageUrl;
            private boolean hasIndoorFloor;
            private boolean hasIndoorParentUid;
            private boolean hasName;
            private boolean hasNum;
            private boolean hasUid;
            private int code_ = 0;
            private String name_ = "";
            private int num_ = 0;
            private String uid_ = "";
            private String addr_ = "";
            private String geo_ = "";
            private String indoorFloor_ = "";
            private String indoorParentUid_ = "";
            private int dist_ = 0;
            private int direction_ = 0;
            private String describe_ = "";
            private a imageUrl_ = a.f1216c;
            private String historyAddress_ = "";
            private int cachedSize = -1;

            public static WayPoints parseFrom(b bVar) throws IOException {
                return new WayPoints().mergeFrom(bVar);
            }

            public final WayPoints clear() {
                clearCode();
                clearName();
                clearNum();
                clearUid();
                clearAddr();
                clearGeo();
                clearIndoorFloor();
                clearIndoorParentUid();
                clearDist();
                clearDirection();
                clearDescribe();
                clearImageUrl();
                clearHistoryAddress();
                this.cachedSize = -1;
                return this;
            }

            public WayPoints clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public WayPoints clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            public WayPoints clearDescribe() {
                this.hasDescribe = false;
                this.describe_ = "";
                return this;
            }

            public WayPoints clearDirection() {
                this.hasDirection = false;
                this.direction_ = 0;
                return this;
            }

            public WayPoints clearDist() {
                this.hasDist = false;
                this.dist_ = 0;
                return this;
            }

            public WayPoints clearGeo() {
                this.hasGeo = false;
                this.geo_ = "";
                return this;
            }

            public WayPoints clearHistoryAddress() {
                this.hasHistoryAddress = false;
                this.historyAddress_ = "";
                return this;
            }

            public WayPoints clearImageUrl() {
                this.hasImageUrl = false;
                this.imageUrl_ = a.f1216c;
                return this;
            }

            public WayPoints clearIndoorFloor() {
                this.hasIndoorFloor = false;
                this.indoorFloor_ = "";
                return this;
            }

            public WayPoints clearIndoorParentUid() {
                this.hasIndoorParentUid = false;
                this.indoorParentUid_ = "";
                return this;
            }

            public WayPoints clearName() {
                this.hasName = false;
                this.name_ = "";
                return this;
            }

            public WayPoints clearNum() {
                this.hasNum = false;
                this.num_ = 0;
                return this;
            }

            public WayPoints clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public String getAddr() {
                return this.addr_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getCode() {
                return this.code_;
            }

            public String getDescribe() {
                return this.describe_;
            }

            public int getDirection() {
                return this.direction_;
            }

            public int getDist() {
                return this.dist_;
            }

            public String getGeo() {
                return this.geo_;
            }

            public String getHistoryAddress() {
                return this.historyAddress_;
            }

            public a getImageUrl() {
                return this.imageUrl_;
            }

            public String getIndoorFloor() {
                return this.indoorFloor_;
            }

            public String getIndoorParentUid() {
                return this.indoorParentUid_;
            }

            public String getName() {
                return this.name_;
            }

            public int getNum() {
                return this.num_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasCode() ? d.e(1, getCode()) : 0;
                if (hasName()) {
                    iE += d.l(2, getName());
                }
                if (hasNum()) {
                    iE += d.e(3, getNum());
                }
                if (hasUid()) {
                    iE += d.l(4, getUid());
                }
                if (hasAddr()) {
                    iE += d.l(5, getAddr());
                }
                if (hasGeo()) {
                    iE += d.l(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    iE += d.l(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    iE += d.l(8, getIndoorParentUid());
                }
                if (hasDist()) {
                    iE += d.e(9, getDist());
                }
                if (hasDirection()) {
                    iE += d.e(10, getDirection());
                }
                if (hasDescribe()) {
                    iE += d.l(11, getDescribe());
                }
                if (hasImageUrl()) {
                    iE += d.b(12, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    iE += d.l(13, getHistoryAddress());
                }
                this.cachedSize = iE;
                return iE;
            }

            public String getUid() {
                return this.uid_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public boolean hasDescribe() {
                return this.hasDescribe;
            }

            public boolean hasDirection() {
                return this.hasDirection;
            }

            public boolean hasDist() {
                return this.hasDist;
            }

            public boolean hasGeo() {
                return this.hasGeo;
            }

            public boolean hasHistoryAddress() {
                return this.hasHistoryAddress;
            }

            public boolean hasImageUrl() {
                return this.hasImageUrl;
            }

            public boolean hasIndoorFloor() {
                return this.hasIndoorFloor;
            }

            public boolean hasIndoorParentUid() {
                return this.hasIndoorParentUid;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasNum() {
                return this.hasNum;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public final boolean isInitialized() {
                return true;
            }

            public WayPoints setAddr(String str) {
                this.hasAddr = true;
                this.addr_ = str;
                return this;
            }

            public WayPoints setCode(int i4) {
                this.hasCode = true;
                this.code_ = i4;
                return this;
            }

            public WayPoints setDescribe(String str) {
                this.hasDescribe = true;
                this.describe_ = str;
                return this;
            }

            public WayPoints setDirection(int i4) {
                this.hasDirection = true;
                this.direction_ = i4;
                return this;
            }

            public WayPoints setDist(int i4) {
                this.hasDist = true;
                this.dist_ = i4;
                return this;
            }

            public WayPoints setGeo(String str) {
                this.hasGeo = true;
                this.geo_ = str;
                return this;
            }

            public WayPoints setHistoryAddress(String str) {
                this.hasHistoryAddress = true;
                this.historyAddress_ = str;
                return this;
            }

            public WayPoints setImageUrl(a aVar) {
                this.hasImageUrl = true;
                this.imageUrl_ = aVar;
                return this;
            }

            public WayPoints setIndoorFloor(String str) {
                this.hasIndoorFloor = true;
                this.indoorFloor_ = str;
                return this;
            }

            public WayPoints setIndoorParentUid(String str) {
                this.hasIndoorParentUid = true;
                this.indoorParentUid_ = str;
                return this;
            }

            public WayPoints setName(String str) {
                this.hasName = true;
                this.name_ = str;
                return this;
            }

            public WayPoints setNum(int i4) {
                this.hasNum = true;
                this.num_ = i4;
                return this;
            }

            public WayPoints setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasCode()) {
                    dVar.s(1, getCode());
                }
                if (hasName()) {
                    dVar.A(2, getName());
                }
                if (hasNum()) {
                    dVar.s(3, getNum());
                }
                if (hasUid()) {
                    dVar.A(4, getUid());
                }
                if (hasAddr()) {
                    dVar.A(5, getAddr());
                }
                if (hasGeo()) {
                    dVar.A(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    dVar.A(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    dVar.A(8, getIndoorParentUid());
                }
                if (hasDist()) {
                    dVar.s(9, getDist());
                }
                if (hasDirection()) {
                    dVar.s(10, getDirection());
                }
                if (hasDescribe()) {
                    dVar.A(11, getDescribe());
                }
                if (hasImageUrl()) {
                    dVar.q(12, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    dVar.A(13, getHistoryAddress());
                }
            }

            public static WayPoints parseFrom(byte[] bArr) throws e {
                return (WayPoints) new WayPoints().mergeFrom(bArr);
            }

            @Override // L1.f
            public WayPoints mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    switch (iO) {
                        case 0:
                            return this;
                        case 8:
                            setCode(bVar.k());
                            break;
                        case 18:
                            setName(bVar.n());
                            break;
                        case 24:
                            setNum(bVar.k());
                            break;
                        case 34:
                            setUid(bVar.n());
                            break;
                        case 42:
                            setAddr(bVar.n());
                            break;
                        case 50:
                            setGeo(bVar.n());
                            break;
                        case 58:
                            setIndoorFloor(bVar.n());
                            break;
                        case 66:
                            setIndoorParentUid(bVar.n());
                            break;
                        case 72:
                            setDist(bVar.k());
                            break;
                        case 80:
                            setDirection(bVar.k());
                            break;
                        case 90:
                            setDescribe(bVar.n());
                            break;
                        case 98:
                            setImageUrl(bVar.b());
                            break;
                        case 106:
                            setHistoryAddress(bVar.n());
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

        public static Content parseFrom(b bVar) throws IOException {
            return new Content().mergeFrom(bVar);
        }

        public Content addEnd(End end) {
            if (end == null) {
                return this;
            }
            if (this.end_.isEmpty()) {
                this.end_ = new ArrayList();
            }
            this.end_.add(end);
            return this;
        }

        public Content addMultiWaypoints(MultiWaypoints multiWaypoints) {
            if (multiWaypoints == null) {
                return this;
            }
            if (this.multiWaypoints_.isEmpty()) {
                this.multiWaypoints_ = new ArrayList();
            }
            this.multiWaypoints_.add(multiWaypoints);
            return this;
        }

        public Content addStart(Start start) {
            if (start == null) {
                return this;
            }
            if (this.start_.isEmpty()) {
                this.start_ = new ArrayList();
            }
            this.start_.add(start);
            return this;
        }

        public Content addWayPoints(WayPoints wayPoints) {
            if (wayPoints == null) {
                return this;
            }
            if (this.wayPoints_.isEmpty()) {
                this.wayPoints_ = new ArrayList();
            }
            this.wayPoints_.add(wayPoints);
            return this;
        }

        public final Content clear() {
            clearStart();
            clearEnd();
            clearWayPoints();
            clearMultiWaypoints();
            this.cachedSize = -1;
            return this;
        }

        public Content clearEnd() {
            this.end_ = Collections.emptyList();
            return this;
        }

        public Content clearMultiWaypoints() {
            this.multiWaypoints_ = Collections.emptyList();
            return this;
        }

        public Content clearStart() {
            this.start_ = Collections.emptyList();
            return this;
        }

        public Content clearWayPoints() {
            this.wayPoints_ = Collections.emptyList();
            return this;
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

        public int getEndCount() {
            return this.end_.size();
        }

        public List<End> getEndList() {
            return this.end_;
        }

        public MultiWaypoints getMultiWaypoints(int i4) {
            return this.multiWaypoints_.get(i4);
        }

        public int getMultiWaypointsCount() {
            return this.multiWaypoints_.size();
        }

        public List<MultiWaypoints> getMultiWaypointsList() {
            return this.multiWaypoints_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            Iterator<Start> it = getStartList().iterator();
            int iH = 0;
            while (it.hasNext()) {
                iH += d.h(1, it.next());
            }
            Iterator<End> it2 = getEndList().iterator();
            while (it2.hasNext()) {
                iH += d.h(2, it2.next());
            }
            Iterator<WayPoints> it3 = getWayPointsList().iterator();
            while (it3.hasNext()) {
                iH += d.h(3, it3.next());
            }
            Iterator<MultiWaypoints> it4 = getMultiWaypointsList().iterator();
            while (it4.hasNext()) {
                iH += d.h(4, it4.next());
            }
            this.cachedSize = iH;
            return iH;
        }

        public Start getStart(int i4) {
            return this.start_.get(i4);
        }

        public int getStartCount() {
            return this.start_.size();
        }

        public List<Start> getStartList() {
            return this.start_;
        }

        public WayPoints getWayPoints(int i4) {
            return this.wayPoints_.get(i4);
        }

        public int getWayPointsCount() {
            return this.wayPoints_.size();
        }

        public List<WayPoints> getWayPointsList() {
            return this.wayPoints_;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Content setEnd(int i4, End end) {
            if (end == null) {
                return this;
            }
            this.end_.set(i4, end);
            return this;
        }

        public Content setMultiWaypoints(int i4, MultiWaypoints multiWaypoints) {
            if (multiWaypoints == null) {
                return this;
            }
            this.multiWaypoints_.set(i4, multiWaypoints);
            return this;
        }

        public Content setStart(int i4, Start start) {
            if (start == null) {
                return this;
            }
            this.start_.set(i4, start);
            return this;
        }

        public Content setWayPoints(int i4, WayPoints wayPoints) {
            if (wayPoints == null) {
                return this;
            }
            this.wayPoints_.set(i4, wayPoints);
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            Iterator<Start> it = getStartList().iterator();
            while (it.hasNext()) {
                dVar.u(1, it.next());
            }
            Iterator<End> it2 = getEndList().iterator();
            while (it2.hasNext()) {
                dVar.u(2, it2.next());
            }
            Iterator<WayPoints> it3 = getWayPointsList().iterator();
            while (it3.hasNext()) {
                dVar.u(3, it3.next());
            }
            Iterator<MultiWaypoints> it4 = getMultiWaypointsList().iterator();
            while (it4.hasNext()) {
                dVar.u(4, it4.next());
            }
        }

        public static Content parseFrom(byte[] bArr) throws e {
            return (Content) new Content().mergeFrom(bArr);
        }

        @Override // L1.f
        public Content mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    Start start = new Start();
                    bVar.f(start);
                    addStart(start);
                } else if (iO == 18) {
                    End end = new End();
                    bVar.f(end);
                    addEnd(end);
                } else if (iO == 26) {
                    WayPoints wayPoints = new WayPoints();
                    bVar.f(wayPoints);
                    addWayPoints(wayPoints);
                } else if (iO == 34) {
                    MultiWaypoints multiWaypoints = new MultiWaypoints();
                    bVar.f(multiWaypoints);
                    addMultiWaypoints(multiWaypoints);
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class ImageShow extends f {
        public static final int IMAGE_EXT_FIELD_NUMBER = 1;
        public static final int RES_BOUND_FIELD_NUMBER = 2;
        private boolean hasImageExt;
        private boolean hasResBound;
        private a imageExt_ = a.f1216c;
        private String resBound_ = "";
        private int cachedSize = -1;

        public static ImageShow parseFrom(b bVar) throws IOException {
            return new ImageShow().mergeFrom(bVar);
        }

        public final ImageShow clear() {
            clearImageExt();
            clearResBound();
            this.cachedSize = -1;
            return this;
        }

        public ImageShow clearImageExt() {
            this.hasImageExt = false;
            this.imageExt_ = a.f1216c;
            return this;
        }

        public ImageShow clearResBound() {
            this.hasResBound = false;
            this.resBound_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public a getImageExt() {
            return this.imageExt_;
        }

        public String getResBound() {
            return this.resBound_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iB = hasImageExt() ? d.b(1, getImageExt()) : 0;
            if (hasResBound()) {
                iB += d.l(2, getResBound());
            }
            this.cachedSize = iB;
            return iB;
        }

        public boolean hasImageExt() {
            return this.hasImageExt;
        }

        public boolean hasResBound() {
            return this.hasResBound;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ImageShow setImageExt(a aVar) {
            this.hasImageExt = true;
            this.imageExt_ = aVar;
            return this;
        }

        public ImageShow setResBound(String str) {
            this.hasResBound = true;
            this.resBound_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasImageExt()) {
                dVar.q(1, getImageExt());
            }
            if (hasResBound()) {
                dVar.A(2, getResBound());
            }
        }

        public static ImageShow parseFrom(byte[] bArr) throws e {
            return (ImageShow) new ImageShow().mergeFrom(bArr);
        }

        @Override // L1.f
        public ImageShow mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setImageExt(bVar.b());
                } else if (iO == 18) {
                    setResBound(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class Option extends f {
        public static final int CITY_LIST_FIELD_NUMBER = 1;
        public static final int END_CITY_FIELD_NUMBER = 8;
        public static final int E_WD_FIELD_NUMBER = 5;
        public static final int IF_NAV_FIELD_NUMBER = 6;
        public static final int PRIO_FLAG_FIELD_NUMBER = 2;
        public static final int START_CITY_FIELD_NUMBER = 7;
        public static final int S_WD_FIELD_NUMBER = 4;
        public static final int WP_WD_FIELD_NUMBER = 3;
        private boolean hasIfNav;
        private boolean hasSWd;
        private boolean hasStartCity;
        private List<String> cityList_ = Collections.emptyList();
        private List<String> prioFlag_ = Collections.emptyList();
        private List<String> wpWd_ = Collections.emptyList();
        private String sWd_ = "";
        private List<String> eWd_ = Collections.emptyList();
        private boolean ifNav_ = false;
        private StartCity startCity_ = null;
        private List<EndCity> endCity_ = Collections.emptyList();
        private int cachedSize = -1;

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

        public Option addCityList(String str) {
            str.getClass();
            if (this.cityList_.isEmpty()) {
                this.cityList_ = new ArrayList();
            }
            this.cityList_.add(str);
            return this;
        }

        public Option addEWd(String str) {
            str.getClass();
            if (this.eWd_.isEmpty()) {
                this.eWd_ = new ArrayList();
            }
            this.eWd_.add(str);
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

        public Option addPrioFlag(String str) {
            str.getClass();
            if (this.prioFlag_.isEmpty()) {
                this.prioFlag_ = new ArrayList();
            }
            this.prioFlag_.add(str);
            return this;
        }

        public Option addWpWd(String str) {
            str.getClass();
            if (this.wpWd_.isEmpty()) {
                this.wpWd_ = new ArrayList();
            }
            this.wpWd_.add(str);
            return this;
        }

        public final Option clear() {
            clearCityList();
            clearPrioFlag();
            clearWpWd();
            clearSWd();
            clearEWd();
            clearIfNav();
            clearStartCity();
            clearEndCity();
            this.cachedSize = -1;
            return this;
        }

        public Option clearCityList() {
            this.cityList_ = Collections.emptyList();
            return this;
        }

        public Option clearEWd() {
            this.eWd_ = Collections.emptyList();
            return this;
        }

        public Option clearEndCity() {
            this.endCity_ = Collections.emptyList();
            return this;
        }

        public Option clearIfNav() {
            this.hasIfNav = false;
            this.ifNav_ = false;
            return this;
        }

        public Option clearPrioFlag() {
            this.prioFlag_ = Collections.emptyList();
            return this;
        }

        public Option clearSWd() {
            this.hasSWd = false;
            this.sWd_ = "";
            return this;
        }

        public Option clearStartCity() {
            this.hasStartCity = false;
            this.startCity_ = null;
            return this;
        }

        public Option clearWpWd() {
            this.wpWd_ = Collections.emptyList();
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getCityList(int i4) {
            return this.cityList_.get(i4);
        }

        public int getCityListCount() {
            return this.cityList_.size();
        }

        public List<String> getCityListList() {
            return this.cityList_;
        }

        public String getEWd(int i4) {
            return this.eWd_.get(i4);
        }

        public int getEWdCount() {
            return this.eWd_.size();
        }

        public List<String> getEWdList() {
            return this.eWd_;
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

        public boolean getIfNav() {
            return this.ifNav_;
        }

        public String getPrioFlag(int i4) {
            return this.prioFlag_.get(i4);
        }

        public int getPrioFlagCount() {
            return this.prioFlag_.size();
        }

        public List<String> getPrioFlagList() {
            return this.prioFlag_;
        }

        public String getSWd() {
            return this.sWd_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            Iterator<String> it = getCityListList().iterator();
            int iM = 0;
            int iM2 = 0;
            while (it.hasNext()) {
                iM2 += d.m(it.next());
            }
            int size = getCityListList().size() + iM2;
            Iterator<String> it2 = getPrioFlagList().iterator();
            int iM3 = 0;
            while (it2.hasNext()) {
                iM3 += d.m(it2.next());
            }
            int size2 = getPrioFlagList().size() + size + iM3;
            Iterator<String> it3 = getWpWdList().iterator();
            int iM4 = 0;
            while (it3.hasNext()) {
                iM4 += d.m(it3.next());
            }
            int size3 = getWpWdList().size() + size2 + iM4;
            if (hasSWd()) {
                size3 += d.l(4, getSWd());
            }
            Iterator<String> it4 = getEWdList().iterator();
            while (it4.hasNext()) {
                iM += d.m(it4.next());
            }
            int size4 = getEWdList().size() + size3 + iM;
            if (hasIfNav()) {
                getIfNav();
                size4 += d.a(6);
            }
            if (hasStartCity()) {
                size4 += d.h(7, getStartCity());
            }
            Iterator<EndCity> it5 = getEndCityList().iterator();
            while (it5.hasNext()) {
                size4 += d.h(8, it5.next());
            }
            this.cachedSize = size4;
            return size4;
        }

        public StartCity getStartCity() {
            return this.startCity_;
        }

        public String getWpWd(int i4) {
            return this.wpWd_.get(i4);
        }

        public int getWpWdCount() {
            return this.wpWd_.size();
        }

        public List<String> getWpWdList() {
            return this.wpWd_;
        }

        public boolean hasIfNav() {
            return this.hasIfNav;
        }

        public boolean hasSWd() {
            return this.hasSWd;
        }

        public boolean hasStartCity() {
            return this.hasStartCity;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option setCityList(int i4, String str) {
            str.getClass();
            this.cityList_.set(i4, str);
            return this;
        }

        public Option setEWd(int i4, String str) {
            str.getClass();
            this.eWd_.set(i4, str);
            return this;
        }

        public Option setEndCity(int i4, EndCity endCity) {
            if (endCity == null) {
                return this;
            }
            this.endCity_.set(i4, endCity);
            return this;
        }

        public Option setIfNav(boolean z4) {
            this.hasIfNav = true;
            this.ifNav_ = z4;
            return this;
        }

        public Option setPrioFlag(int i4, String str) {
            str.getClass();
            this.prioFlag_.set(i4, str);
            return this;
        }

        public Option setSWd(String str) {
            this.hasSWd = true;
            this.sWd_ = str;
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

        public Option setWpWd(int i4, String str) {
            str.getClass();
            this.wpWd_.set(i4, str);
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            Iterator<String> it = getCityListList().iterator();
            while (it.hasNext()) {
                dVar.A(1, it.next());
            }
            Iterator<String> it2 = getPrioFlagList().iterator();
            while (it2.hasNext()) {
                dVar.A(2, it2.next());
            }
            Iterator<String> it3 = getWpWdList().iterator();
            while (it3.hasNext()) {
                dVar.A(3, it3.next());
            }
            if (hasSWd()) {
                dVar.A(4, getSWd());
            }
            Iterator<String> it4 = getEWdList().iterator();
            while (it4.hasNext()) {
                dVar.A(5, it4.next());
            }
            if (hasIfNav()) {
                dVar.p(6, getIfNav());
            }
            if (hasStartCity()) {
                dVar.u(7, getStartCity());
            }
            Iterator<EndCity> it5 = getEndCityList().iterator();
            while (it5.hasNext()) {
                dVar.u(8, it5.next());
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
                if (iO == 10) {
                    addCityList(bVar.n());
                } else if (iO == 18) {
                    addPrioFlag(bVar.n());
                } else if (iO == 26) {
                    addWpWd(bVar.n());
                } else if (iO == 34) {
                    setSWd(bVar.n());
                } else if (iO == 42) {
                    addEWd(bVar.n());
                } else if (iO == 48) {
                    setIfNav(bVar.a());
                } else if (iO == 58) {
                    StartCity startCity = new StartCity();
                    bVar.f(startCity);
                    setStartCity(startCity);
                } else if (iO == 66) {
                    EndCity endCity = new EndCity();
                    bVar.f(endCity);
                    addEndCity(endCity);
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class SuggestQuery extends f {
        public static final int QUERY_FIELD_NUMBER = 1;
        private boolean hasQuery;
        private String query_ = "";
        private int cachedSize = -1;

        public static SuggestQuery parseFrom(b bVar) throws IOException {
            return new SuggestQuery().mergeFrom(bVar);
        }

        public final SuggestQuery clear() {
            clearQuery();
            this.cachedSize = -1;
            return this;
        }

        public SuggestQuery clearQuery() {
            this.hasQuery = false;
            this.query_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getQuery() {
            return this.query_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasQuery() ? d.l(1, getQuery()) : 0;
            this.cachedSize = iL;
            return iL;
        }

        public boolean hasQuery() {
            return this.hasQuery;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SuggestQuery setQuery(String str) {
            this.hasQuery = true;
            this.query_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasQuery()) {
                dVar.A(1, getQuery());
            }
        }

        public static SuggestQuery parseFrom(byte[] bArr) throws e {
            return (SuggestQuery) new SuggestQuery().mergeFrom(bArr);
        }

        @Override // L1.f
        public SuggestQuery mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setQuery(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static TrafficPois parseFrom(b bVar) throws IOException {
        return new TrafficPois().mergeFrom(bVar);
    }

    public TrafficPois addSuggestQuery(SuggestQuery suggestQuery) {
        if (suggestQuery == null) {
            return this;
        }
        if (this.suggestQuery_.isEmpty()) {
            this.suggestQuery_ = new ArrayList();
        }
        this.suggestQuery_.add(suggestQuery);
        return this;
    }

    public final TrafficPois clear() {
        clearOption();
        clearCurrentCity();
        clearContent();
        clearSuggestQuery();
        clearSuggestQueryFlag();
        clearImgeShow();
        clearListType();
        this.cachedSize = -1;
        return this;
    }

    public TrafficPois clearContent() {
        this.hasContent = false;
        this.content_ = null;
        return this;
    }

    public TrafficPois clearCurrentCity() {
        this.hasCurrentCity = false;
        this.currentCity_ = null;
        return this;
    }

    public TrafficPois clearImgeShow() {
        this.hasImgeShow = false;
        this.imgeShow_ = null;
        return this;
    }

    public TrafficPois clearListType() {
        this.hasListType = false;
        this.listType_ = 0;
        return this;
    }

    public TrafficPois clearOption() {
        this.hasOption = false;
        this.option_ = null;
        return this;
    }

    public TrafficPois clearSuggestQuery() {
        this.suggestQuery_ = Collections.emptyList();
        return this;
    }

    public TrafficPois clearSuggestQueryFlag() {
        this.hasSuggestQueryFlag = false;
        this.suggestQueryFlag_ = 0;
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

    public CurrentCity getCurrentCity() {
        return this.currentCity_;
    }

    public ImageShow getImgeShow() {
        return this.imgeShow_;
    }

    public int getListType() {
        return this.listType_;
    }

    public Option getOption() {
        return this.option_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iH = hasOption() ? d.h(1, getOption()) : 0;
        if (hasCurrentCity()) {
            iH += d.h(2, getCurrentCity());
        }
        if (hasContent()) {
            iH += d.h(3, getContent());
        }
        Iterator<SuggestQuery> it = getSuggestQueryList().iterator();
        while (it.hasNext()) {
            iH += d.h(4, it.next());
        }
        if (hasSuggestQueryFlag()) {
            iH += d.e(5, getSuggestQueryFlag());
        }
        if (hasImgeShow()) {
            iH += d.h(6, getImgeShow());
        }
        if (hasListType()) {
            iH += d.e(7, getListType());
        }
        this.cachedSize = iH;
        return iH;
    }

    public SuggestQuery getSuggestQuery(int i4) {
        return this.suggestQuery_.get(i4);
    }

    public int getSuggestQueryCount() {
        return this.suggestQuery_.size();
    }

    public int getSuggestQueryFlag() {
        return this.suggestQueryFlag_;
    }

    public List<SuggestQuery> getSuggestQueryList() {
        return this.suggestQuery_;
    }

    public boolean hasContent() {
        return this.hasContent;
    }

    public boolean hasCurrentCity() {
        return this.hasCurrentCity;
    }

    public boolean hasImgeShow() {
        return this.hasImgeShow;
    }

    public boolean hasListType() {
        return this.hasListType;
    }

    public boolean hasOption() {
        return this.hasOption;
    }

    public boolean hasSuggestQueryFlag() {
        return this.hasSuggestQueryFlag;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrafficPois setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.hasContent = true;
        this.content_ = content;
        return this;
    }

    public TrafficPois setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.hasCurrentCity = true;
        this.currentCity_ = currentCity;
        return this;
    }

    public TrafficPois setImgeShow(ImageShow imageShow) {
        if (imageShow == null) {
            return clearImgeShow();
        }
        this.hasImgeShow = true;
        this.imgeShow_ = imageShow;
        return this;
    }

    public TrafficPois setListType(int i4) {
        this.hasListType = true;
        this.listType_ = i4;
        return this;
    }

    public TrafficPois setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.hasOption = true;
        this.option_ = option;
        return this;
    }

    public TrafficPois setSuggestQuery(int i4, SuggestQuery suggestQuery) {
        if (suggestQuery == null) {
            return this;
        }
        this.suggestQuery_.set(i4, suggestQuery);
        return this;
    }

    public TrafficPois setSuggestQueryFlag(int i4) {
        this.hasSuggestQueryFlag = true;
        this.suggestQueryFlag_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasOption()) {
            dVar.u(1, getOption());
        }
        if (hasCurrentCity()) {
            dVar.u(2, getCurrentCity());
        }
        if (hasContent()) {
            dVar.u(3, getContent());
        }
        Iterator<SuggestQuery> it = getSuggestQueryList().iterator();
        while (it.hasNext()) {
            dVar.u(4, it.next());
        }
        if (hasSuggestQueryFlag()) {
            dVar.s(5, getSuggestQueryFlag());
        }
        if (hasImgeShow()) {
            dVar.u(6, getImgeShow());
        }
        if (hasListType()) {
            dVar.s(7, getListType());
        }
    }

    public static TrafficPois parseFrom(byte[] bArr) throws e {
        return (TrafficPois) new TrafficPois().mergeFrom(bArr);
    }

    @Override // L1.f
    public TrafficPois mergeFrom(b bVar) throws IOException {
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
                CurrentCity currentCity = new CurrentCity();
                bVar.f(currentCity);
                setCurrentCity(currentCity);
            } else if (iO == 26) {
                Content content = new Content();
                bVar.f(content);
                setContent(content);
            } else if (iO == 34) {
                SuggestQuery suggestQuery = new SuggestQuery();
                bVar.f(suggestQuery);
                addSuggestQuery(suggestQuery);
            } else if (iO == 40) {
                setSuggestQueryFlag(bVar.k());
            } else if (iO == 50) {
                ImageShow imageShow = new ImageShow();
                bVar.f(imageShow);
                setImgeShow(imageShow);
            } else if (iO == 56) {
                setListType(bVar.k());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
