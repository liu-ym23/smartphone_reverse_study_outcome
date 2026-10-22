package com.baidu.location.pb;

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
public final class BhpsPackage extends f {
    public static final int AK_FIELD_NUMBER = 15;
    public static final int ANDROID_VERSION_FIELD_NUMBER = 13;
    public static final int APP_NAME_FIELD_NUMBER = 17;
    public static final int CUID_FIELD_NUMBER = 3;
    public static final int EVENT_BRAND_FIELD_NUMBER = 11;
    public static final int FROM_FIELD_NUMBER = 8;
    public static final int GPS_FIRST_FIELD_NUMBER = 4;
    public static final int GPS_POINT_DELAT_FIELD_NUMBER = 7;
    public static final int GPS_POINT_NUM_FIELD_NUMBER = 1;
    public static final int NAVI_START_OR_END_FLAG_FIELD_NUMBER = 10;
    public static final int PHONE_TYPE_FIELD_NUMBER = 16;
    public static final int RTK_SDK_VERSION_FIELD_NUMBER = 12;
    public static final int SERVICE_VERSION_FIELD_NUMBER = 14;
    public static final int SUB_FROM_FIELD_NUMBER = 9;
    public static final int VERSION_FIELD_NUMBER = 2;
    private boolean hasAndroidVersion;
    private boolean hasCuid;
    private boolean hasEventBrand;
    private boolean hasFrom;
    private boolean hasGpsFirst;
    private boolean hasGpsPointNum;
    private boolean hasNaviStartOrEndFlag;
    private boolean hasPhoneType;
    private boolean hasRtkSdkVersion;
    private boolean hasServiceVersion;
    private boolean hasSubFrom;
    private boolean hasVersion;
    private int gpsPointNum_ = 0;
    private String version_ = "";
    private a cuid_ = a.f1216c;
    private BhpsPointFirst gpsFirst_ = null;
    private List<BhpsPointDelta> gpsPointDelat_ = Collections.emptyList();
    private int from_ = 0;
    private String subFrom_ = "";
    private int naviStartOrEndFlag_ = 0;
    private int eventBrand_ = 0;
    private String rtkSdkVersion_ = "";
    private String androidVersion_ = "";
    private String serviceVersion_ = "";
    private List<String> ak_ = Collections.emptyList();
    private String phoneType_ = "";
    private List<String> appName_ = Collections.emptyList();
    private int cachedSize = -1;

    public static BhpsPackage parseFrom(b bVar) throws IOException {
        return new BhpsPackage().mergeFrom(bVar);
    }

    public BhpsPackage addAk(String str) {
        str.getClass();
        if (this.ak_.isEmpty()) {
            this.ak_ = new ArrayList();
        }
        this.ak_.add(str);
        return this;
    }

    public BhpsPackage addAppName(String str) {
        str.getClass();
        if (this.appName_.isEmpty()) {
            this.appName_ = new ArrayList();
        }
        this.appName_.add(str);
        return this;
    }

    public BhpsPackage addGpsPointDelat(BhpsPointDelta bhpsPointDelta) {
        if (bhpsPointDelta == null) {
            return this;
        }
        if (this.gpsPointDelat_.isEmpty()) {
            this.gpsPointDelat_ = new ArrayList();
        }
        this.gpsPointDelat_.add(bhpsPointDelta);
        return this;
    }

    public final BhpsPackage clear() {
        clearGpsPointNum();
        clearVersion();
        clearCuid();
        clearGpsFirst();
        clearGpsPointDelat();
        clearFrom();
        clearSubFrom();
        clearNaviStartOrEndFlag();
        clearEventBrand();
        clearRtkSdkVersion();
        clearAndroidVersion();
        clearServiceVersion();
        clearAk();
        clearPhoneType();
        clearAppName();
        this.cachedSize = -1;
        return this;
    }

    public BhpsPackage clearAk() {
        this.ak_ = Collections.emptyList();
        return this;
    }

    public BhpsPackage clearAndroidVersion() {
        this.hasAndroidVersion = false;
        this.androidVersion_ = "";
        return this;
    }

    public BhpsPackage clearAppName() {
        this.appName_ = Collections.emptyList();
        return this;
    }

    public BhpsPackage clearCuid() {
        this.hasCuid = false;
        this.cuid_ = a.f1216c;
        return this;
    }

    public BhpsPackage clearEventBrand() {
        this.hasEventBrand = false;
        this.eventBrand_ = 0;
        return this;
    }

    public BhpsPackage clearFrom() {
        this.hasFrom = false;
        this.from_ = 0;
        return this;
    }

    public BhpsPackage clearGpsFirst() {
        this.hasGpsFirst = false;
        this.gpsFirst_ = null;
        return this;
    }

    public BhpsPackage clearGpsPointDelat() {
        this.gpsPointDelat_ = Collections.emptyList();
        return this;
    }

    public BhpsPackage clearGpsPointNum() {
        this.hasGpsPointNum = false;
        this.gpsPointNum_ = 0;
        return this;
    }

    public BhpsPackage clearNaviStartOrEndFlag() {
        this.hasNaviStartOrEndFlag = false;
        this.naviStartOrEndFlag_ = 0;
        return this;
    }

    public BhpsPackage clearPhoneType() {
        this.hasPhoneType = false;
        this.phoneType_ = "";
        return this;
    }

    public BhpsPackage clearRtkSdkVersion() {
        this.hasRtkSdkVersion = false;
        this.rtkSdkVersion_ = "";
        return this;
    }

    public BhpsPackage clearServiceVersion() {
        this.hasServiceVersion = false;
        this.serviceVersion_ = "";
        return this;
    }

    public BhpsPackage clearSubFrom() {
        this.hasSubFrom = false;
        this.subFrom_ = "";
        return this;
    }

    public BhpsPackage clearVersion() {
        this.hasVersion = false;
        this.version_ = "";
        return this;
    }

    public String getAk(int i4) {
        return this.ak_.get(i4);
    }

    public int getAkCount() {
        return this.ak_.size();
    }

    public List<String> getAkList() {
        return this.ak_;
    }

    public String getAndroidVersion() {
        return this.androidVersion_;
    }

    public String getAppName(int i4) {
        return this.appName_.get(i4);
    }

    public int getAppNameCount() {
        return this.appName_.size();
    }

    public List<String> getAppNameList() {
        return this.appName_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getCuid() {
        return this.cuid_;
    }

    public int getEventBrand() {
        return this.eventBrand_;
    }

    public int getFrom() {
        return this.from_;
    }

    public BhpsPointFirst getGpsFirst() {
        return this.gpsFirst_;
    }

    public BhpsPointDelta getGpsPointDelat(int i4) {
        return this.gpsPointDelat_.get(i4);
    }

    public int getGpsPointDelatCount() {
        return this.gpsPointDelat_.size();
    }

    public List<BhpsPointDelta> getGpsPointDelatList() {
        return this.gpsPointDelat_;
    }

    public int getGpsPointNum() {
        return this.gpsPointNum_;
    }

    public int getNaviStartOrEndFlag() {
        return this.naviStartOrEndFlag_;
    }

    public String getPhoneType() {
        return this.phoneType_;
    }

    public String getRtkSdkVersion() {
        return this.rtkSdkVersion_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iM = 0;
        int iO = hasGpsPointNum() ? d.o(1, getGpsPointNum()) : 0;
        if (hasVersion()) {
            iO += d.l(2, getVersion());
        }
        if (hasCuid()) {
            iO += d.b(3, getCuid());
        }
        if (hasGpsFirst()) {
            iO += d.h(4, getGpsFirst());
        }
        Iterator<BhpsPointDelta> it = getGpsPointDelatList().iterator();
        while (it.hasNext()) {
            iO += d.h(7, it.next());
        }
        if (hasFrom()) {
            iO += d.o(8, getFrom());
        }
        if (hasSubFrom()) {
            iO += d.l(9, getSubFrom());
        }
        if (hasNaviStartOrEndFlag()) {
            iO += d.o(10, getNaviStartOrEndFlag());
        }
        if (hasEventBrand()) {
            iO += d.o(11, getEventBrand());
        }
        if (hasRtkSdkVersion()) {
            iO += d.l(12, getRtkSdkVersion());
        }
        if (hasAndroidVersion()) {
            iO += d.l(13, getAndroidVersion());
        }
        if (hasServiceVersion()) {
            iO += d.l(14, getServiceVersion());
        }
        Iterator<String> it2 = getAkList().iterator();
        int iM2 = 0;
        while (it2.hasNext()) {
            iM2 += d.m(it2.next());
        }
        int size = getAkList().size() + iO + iM2;
        if (hasPhoneType()) {
            size += d.l(16, getPhoneType());
        }
        Iterator<String> it3 = getAppNameList().iterator();
        while (it3.hasNext()) {
            iM += d.m(it3.next());
        }
        int size2 = (getAppNameList().size() * 2) + size + iM;
        this.cachedSize = size2;
        return size2;
    }

    public String getServiceVersion() {
        return this.serviceVersion_;
    }

    public String getSubFrom() {
        return this.subFrom_;
    }

    public String getVersion() {
        return this.version_;
    }

    public boolean hasAndroidVersion() {
        return this.hasAndroidVersion;
    }

    public boolean hasCuid() {
        return this.hasCuid;
    }

    public boolean hasEventBrand() {
        return this.hasEventBrand;
    }

    public boolean hasFrom() {
        return this.hasFrom;
    }

    public boolean hasGpsFirst() {
        return this.hasGpsFirst;
    }

    public boolean hasGpsPointNum() {
        return this.hasGpsPointNum;
    }

    public boolean hasNaviStartOrEndFlag() {
        return this.hasNaviStartOrEndFlag;
    }

    public boolean hasPhoneType() {
        return this.hasPhoneType;
    }

    public boolean hasRtkSdkVersion() {
        return this.hasRtkSdkVersion;
    }

    public boolean hasServiceVersion() {
        return this.hasServiceVersion;
    }

    public boolean hasSubFrom() {
        return this.hasSubFrom;
    }

    public boolean hasVersion() {
        return this.hasVersion;
    }

    public final boolean isInitialized() {
        if (!this.hasGpsPointNum || !this.hasVersion || !this.hasCuid || !this.hasGpsFirst || !this.hasFrom || !this.hasSubFrom || !getGpsFirst().isInitialized()) {
            return false;
        }
        Iterator<BhpsPointDelta> it = getGpsPointDelatList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public BhpsPackage setAk(int i4, String str) {
        str.getClass();
        this.ak_.set(i4, str);
        return this;
    }

    public BhpsPackage setAndroidVersion(String str) {
        this.hasAndroidVersion = true;
        this.androidVersion_ = str;
        return this;
    }

    public BhpsPackage setAppName(int i4, String str) {
        str.getClass();
        this.appName_.set(i4, str);
        return this;
    }

    public BhpsPackage setCuid(a aVar) {
        this.hasCuid = true;
        this.cuid_ = aVar;
        return this;
    }

    public BhpsPackage setEventBrand(int i4) {
        this.hasEventBrand = true;
        this.eventBrand_ = i4;
        return this;
    }

    public BhpsPackage setFrom(int i4) {
        this.hasFrom = true;
        this.from_ = i4;
        return this;
    }

    public BhpsPackage setGpsFirst(BhpsPointFirst bhpsPointFirst) {
        if (bhpsPointFirst == null) {
            return clearGpsFirst();
        }
        this.hasGpsFirst = true;
        this.gpsFirst_ = bhpsPointFirst;
        return this;
    }

    public BhpsPackage setGpsPointDelat(int i4, BhpsPointDelta bhpsPointDelta) {
        if (bhpsPointDelta == null) {
            return this;
        }
        this.gpsPointDelat_.set(i4, bhpsPointDelta);
        return this;
    }

    public BhpsPackage setGpsPointNum(int i4) {
        this.hasGpsPointNum = true;
        this.gpsPointNum_ = i4;
        return this;
    }

    public BhpsPackage setNaviStartOrEndFlag(int i4) {
        this.hasNaviStartOrEndFlag = true;
        this.naviStartOrEndFlag_ = i4;
        return this;
    }

    public BhpsPackage setPhoneType(String str) {
        this.hasPhoneType = true;
        this.phoneType_ = str;
        return this;
    }

    public BhpsPackage setRtkSdkVersion(String str) {
        this.hasRtkSdkVersion = true;
        this.rtkSdkVersion_ = str;
        return this;
    }

    public BhpsPackage setServiceVersion(String str) {
        this.hasServiceVersion = true;
        this.serviceVersion_ = str;
        return this;
    }

    public BhpsPackage setSubFrom(String str) {
        this.hasSubFrom = true;
        this.subFrom_ = str;
        return this;
    }

    public BhpsPackage setVersion(String str) {
        this.hasVersion = true;
        this.version_ = str;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasGpsPointNum()) {
            dVar.C(1, getGpsPointNum());
        }
        if (hasVersion()) {
            dVar.A(2, getVersion());
        }
        if (hasCuid()) {
            dVar.q(3, getCuid());
        }
        if (hasGpsFirst()) {
            dVar.u(4, getGpsFirst());
        }
        Iterator<BhpsPointDelta> it = getGpsPointDelatList().iterator();
        while (it.hasNext()) {
            dVar.u(7, it.next());
        }
        if (hasFrom()) {
            dVar.C(8, getFrom());
        }
        if (hasSubFrom()) {
            dVar.A(9, getSubFrom());
        }
        if (hasNaviStartOrEndFlag()) {
            dVar.C(10, getNaviStartOrEndFlag());
        }
        if (hasEventBrand()) {
            dVar.C(11, getEventBrand());
        }
        if (hasRtkSdkVersion()) {
            dVar.A(12, getRtkSdkVersion());
        }
        if (hasAndroidVersion()) {
            dVar.A(13, getAndroidVersion());
        }
        if (hasServiceVersion()) {
            dVar.A(14, getServiceVersion());
        }
        Iterator<String> it2 = getAkList().iterator();
        while (it2.hasNext()) {
            dVar.A(15, it2.next());
        }
        if (hasPhoneType()) {
            dVar.A(16, getPhoneType());
        }
        Iterator<String> it3 = getAppNameList().iterator();
        while (it3.hasNext()) {
            dVar.A(17, it3.next());
        }
    }

    public static BhpsPackage parseFrom(byte[] bArr) throws e {
        return (BhpsPackage) new BhpsPackage().mergeFrom(bArr);
    }

    @Override // L1.f
    public BhpsPackage mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            switch (iO) {
                case 0:
                    return this;
                case 8:
                    setGpsPointNum(bVar.k());
                    break;
                case 18:
                    setVersion(bVar.n());
                    break;
                case 26:
                    setCuid(bVar.b());
                    break;
                case 34:
                    BhpsPointFirst bhpsPointFirst = new BhpsPointFirst();
                    bVar.f(bhpsPointFirst);
                    setGpsFirst(bhpsPointFirst);
                    break;
                case 58:
                    BhpsPointDelta bhpsPointDelta = new BhpsPointDelta();
                    bVar.f(bhpsPointDelta);
                    addGpsPointDelat(bhpsPointDelta);
                    break;
                case 64:
                    setFrom(bVar.k());
                    break;
                case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                    setSubFrom(bVar.n());
                    break;
                case 80:
                    setNaviStartOrEndFlag(bVar.k());
                    break;
                case 88:
                    setEventBrand(bVar.k());
                    break;
                case 98:
                    setRtkSdkVersion(bVar.n());
                    break;
                case 106:
                    setAndroidVersion(bVar.n());
                    break;
                case 114:
                    setServiceVersion(bVar.n());
                    break;
                case 122:
                    addAk(bVar.n());
                    break;
                case 130:
                    setPhoneType(bVar.n());
                    break;
                case 138:
                    addAppName(bVar.n());
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
