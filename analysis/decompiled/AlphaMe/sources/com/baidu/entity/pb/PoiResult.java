package com.baidu.entity.pb;

import B0.g;
import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import ch.qos.logback.core.net.SyslogConstants;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.platform.comapi.license.LicenseCode;
import com.stepos.alphame.utils.Property;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PoiResult extends f {
    public static final int ADDRS_FIELD_NUMBER = 2;
    public static final int ADS_EXT_INFO_FIELD_NUMBER = 16;
    public static final int ADS_FIELD_NUMBER = 14;
    public static final int BRAND_BAR_FIELD_NUMBER = 10;
    public static final int CAR_PRELOAD_FIELD_NUMBER = 21;
    public static final int CHILDREN_FIELD_NUMBER = 8;
    public static final int CONTENTS_FIELD_NUMBER = 6;
    public static final int CORRECTION_INFO_FIELD_NUMBER = 20;
    public static final int CURRENT_CITY_FIELD_NUMBER = 7;
    public static final int EMPTY_RESULT_DYNAMIC_CARD_FIELD_NUMBER = 27;
    public static final int FLOAT_ICONS_FIELD_NUMBER = 28;
    public static final int GUIDE_TAG_FIELD_NUMBER = 13;
    public static final int GUILD_BUTTON_FIELD_NUMBER = 36;
    public static final int HORIZON_SLIDE_RESULT_FIELD_NUMBER = 26;
    public static final int IMGE_EXT_FIELD_NUMBER = 11;
    public static final int IMG_BANNER_FIELD_NUMBER = 23;
    public static final int INDUS_INFO_FIELD_NUMBER = 18;
    public static final int LIST_ADS_DATA_FIELD_NUMBER = 32;
    public static final int MYSTIQUE_LIST_FIELD_NUMBER = 24;
    public static final int OFFLINE_FIELD_NUMBER = 12;
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int PLACE_INFO_FIELD_NUMBER = 5;
    public static final int POPUP_WINDOW_FIELD_NUMBER = 30;
    public static final int PREVIEW_CACHE_KEY_FIELD_NUMBER = 34;
    public static final int PREVIOUS_CITY_FIELD_NUMBER = 9;
    public static final int PSRS_FIELD_NUMBER = 3;
    public static final int RECOMMEND_FIELD_NUMBER = 19;
    public static final int SEARCH_BOX_BG_IMG_FIELD_NUMBER = 29;
    public static final int SPEECH_FINAL_WORD_FIELD_NUMBER = 22;
    public static final int SUGGEST_QUERY_FIELD_NUMBER = 4;
    public static final int SUG_REC_RES_FIELD_NUMBER = 25;
    public static final int TALOS_BANNER_FIELD_NUMBER = 35;
    public static final int TALOS_DATA_FIELD_NUMBER = 33;
    public static final int WIDGET_BAR_FIELD_NUMBER = 31;
    private boolean hasAdsExtInfo;
    private boolean hasBrandBar;
    private boolean hasCarPreload;
    private boolean hasCorrectionInfo;
    private boolean hasCurrentCity;
    private boolean hasEmptyResultDynamicCard;
    private boolean hasHorizonSlideResult;
    private boolean hasImgBanner;
    private boolean hasImgeExt;
    private boolean hasIndusInfo;
    private boolean hasListAdsData;
    private boolean hasOffline;
    private boolean hasOption;
    private boolean hasPlaceInfo;
    private boolean hasPopupWindow;
    private boolean hasPreviewCacheKey;
    private boolean hasPreviousCity;
    private boolean hasPsrs;
    private boolean hasRecommend;
    private boolean hasSearchBoxBgImg;
    private boolean hasSpeechFinalWord;
    private boolean hasSugRecRes;
    private boolean hasTalosBanner;
    private boolean hasTalosData;
    private boolean hasWidgetBar;
    private Option option_ = null;
    private List<Addrs> addrs_ = Collections.emptyList();
    private Psrs psrs_ = null;
    private List<SuggestQuery> suggestQuery_ = Collections.emptyList();
    private PlaceInfo placeInfo_ = null;
    private List<Contents> contents_ = Collections.emptyList();
    private List<Children> children_ = Collections.emptyList();
    private PreviousCity previousCity_ = null;
    private CurrentCity currentCity_ = null;
    private BrandBar brandBar_ = null;
    private a imgeExt_ = a.f1216c;
    private int offline_ = 0;
    private List<GuideTag> guideTag_ = Collections.emptyList();
    private List<Ads> ads_ = Collections.emptyList();
    private AdsExtInfo adsExtInfo_ = null;
    private IndusInfo indusInfo_ = null;
    private Recommend recommend_ = null;
    private CorrectionInfo correctionInfo_ = null;
    private int carPreload_ = 0;
    private String speechFinalWord_ = "";
    private ImgBanner imgBanner_ = null;
    private List<MystiqueList> mystiqueList_ = Collections.emptyList();
    private SugRecResult sugRecRes_ = null;
    private HorizonSlideResult horizonSlideResult_ = null;
    private String emptyResultDynamicCard_ = "";
    private List<FloatIcon> floatIcons_ = Collections.emptyList();
    private String searchBoxBgImg_ = "";
    private String popupWindow_ = "";
    private WidgetBar widgetBar_ = null;
    private ListAdsData listAdsData_ = null;
    private TalosData talosData_ = null;
    private String previewCacheKey_ = "";
    private String talosBanner_ = "";
    private List<GuildButton> guildButton_ = Collections.emptyList();
    private int cachedSize = -1;

    public static final class AddrButton extends f {
        public static final int DARK_ICON_URL_FIELD_NUMBER = 3;
        public static final int ICON_URL_FIELD_NUMBER = 2;
        public static final int JUMP_URL_FIELD_NUMBER = 4;
        public static final int TEXT_FIELD_NUMBER = 1;
        private boolean hasDarkIconUrl;
        private boolean hasIconUrl;
        private boolean hasJumpUrl;
        private boolean hasText;
        private String text_ = "";
        private String iconUrl_ = "";
        private String darkIconUrl_ = "";
        private String jumpUrl_ = "";
        private int cachedSize = -1;

        public static AddrButton parseFrom(b bVar) throws IOException {
            return new AddrButton().mergeFrom(bVar);
        }

        public final AddrButton clear() {
            clearText();
            clearIconUrl();
            clearDarkIconUrl();
            clearJumpUrl();
            this.cachedSize = -1;
            return this;
        }

        public AddrButton clearDarkIconUrl() {
            this.hasDarkIconUrl = false;
            this.darkIconUrl_ = "";
            return this;
        }

        public AddrButton clearIconUrl() {
            this.hasIconUrl = false;
            this.iconUrl_ = "";
            return this;
        }

        public AddrButton clearJumpUrl() {
            this.hasJumpUrl = false;
            this.jumpUrl_ = "";
            return this;
        }

        public AddrButton clearText() {
            this.hasText = false;
            this.text_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getDarkIconUrl() {
            return this.darkIconUrl_;
        }

        public String getIconUrl() {
            return this.iconUrl_;
        }

        public String getJumpUrl() {
            return this.jumpUrl_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasText() ? d.l(1, getText()) : 0;
            if (hasIconUrl()) {
                iL += d.l(2, getIconUrl());
            }
            if (hasDarkIconUrl()) {
                iL += d.l(3, getDarkIconUrl());
            }
            if (hasJumpUrl()) {
                iL += d.l(4, getJumpUrl());
            }
            this.cachedSize = iL;
            return iL;
        }

        public String getText() {
            return this.text_;
        }

        public boolean hasDarkIconUrl() {
            return this.hasDarkIconUrl;
        }

        public boolean hasIconUrl() {
            return this.hasIconUrl;
        }

        public boolean hasJumpUrl() {
            return this.hasJumpUrl;
        }

        public boolean hasText() {
            return this.hasText;
        }

        public final boolean isInitialized() {
            return true;
        }

        public AddrButton setDarkIconUrl(String str) {
            this.hasDarkIconUrl = true;
            this.darkIconUrl_ = str;
            return this;
        }

        public AddrButton setIconUrl(String str) {
            this.hasIconUrl = true;
            this.iconUrl_ = str;
            return this;
        }

        public AddrButton setJumpUrl(String str) {
            this.hasJumpUrl = true;
            this.jumpUrl_ = str;
            return this;
        }

        public AddrButton setText(String str) {
            this.hasText = true;
            this.text_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasText()) {
                dVar.A(1, getText());
            }
            if (hasIconUrl()) {
                dVar.A(2, getIconUrl());
            }
            if (hasDarkIconUrl()) {
                dVar.A(3, getDarkIconUrl());
            }
            if (hasJumpUrl()) {
                dVar.A(4, getJumpUrl());
            }
        }

        public static AddrButton parseFrom(byte[] bArr) throws e {
            return (AddrButton) new AddrButton().mergeFrom(bArr);
        }

        @Override // L1.f
        public AddrButton mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setText(bVar.n());
                } else if (iO == 18) {
                    setIconUrl(bVar.n());
                } else if (iO == 26) {
                    setDarkIconUrl(bVar.n());
                } else if (iO == 34) {
                    setJumpUrl(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class Addrs extends f {
        public static final int ACC_FLAG_FIELD_NUMBER = 5;
        public static final int ADDR_FIELD_NUMBER = 1;
        public static final int ADDR_TRANSFER_PARAM_FIELD_NUMBER = 12;
        public static final int CLOUD_TEMPLATE_FIELD_NUMBER = 6;
        public static final int DISTANCE_FIELD_NUMBER = 9;
        public static final int GEO_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int PRECISE_FIELD_NUMBER = 4;
        public static final int RIGHT_UPPER_BTN_FIELD_NUMBER = 11;
        public static final int STREET_MAP_IMG_FIELD_NUMBER = 10;
        public static final int UID_FIELD_NUMBER = 8;
        public static final int VUI_PROCESS_DATA_FIELD_NUMBER = 7;
        private boolean hasAccFlag;
        private boolean hasAddr;
        private boolean hasAddrTransferParam;
        private boolean hasCloudTemplate;
        private boolean hasDistance;
        private boolean hasGeo;
        private boolean hasName;
        private boolean hasPrecise;
        private boolean hasRightUpperBtn;
        private boolean hasStreetMapImg;
        private boolean hasUid;
        private boolean hasVuiProcessData;
        private String addr_ = "";
        private String geo_ = "";
        private String name_ = "";
        private int precise_ = 0;
        private int accFlag_ = 0;
        private a cloudTemplate_ = a.f1216c;
        private VuiProcessData vuiProcessData_ = null;
        private String uid_ = "";
        private String distance_ = "";
        private StreetImg streetMapImg_ = null;
        private AddrButton rightUpperBtn_ = null;
        private String addrTransferParam_ = "";
        private int cachedSize = -1;

        public static Addrs parseFrom(b bVar) throws IOException {
            return new Addrs().mergeFrom(bVar);
        }

        public final Addrs clear() {
            clearAddr();
            clearGeo();
            clearName();
            clearPrecise();
            clearAccFlag();
            clearCloudTemplate();
            clearVuiProcessData();
            clearUid();
            clearDistance();
            clearStreetMapImg();
            clearRightUpperBtn();
            clearAddrTransferParam();
            this.cachedSize = -1;
            return this;
        }

        public Addrs clearAccFlag() {
            this.hasAccFlag = false;
            this.accFlag_ = 0;
            return this;
        }

        public Addrs clearAddr() {
            this.hasAddr = false;
            this.addr_ = "";
            return this;
        }

        public Addrs clearAddrTransferParam() {
            this.hasAddrTransferParam = false;
            this.addrTransferParam_ = "";
            return this;
        }

        public Addrs clearCloudTemplate() {
            this.hasCloudTemplate = false;
            this.cloudTemplate_ = a.f1216c;
            return this;
        }

        public Addrs clearDistance() {
            this.hasDistance = false;
            this.distance_ = "";
            return this;
        }

        public Addrs clearGeo() {
            this.hasGeo = false;
            this.geo_ = "";
            return this;
        }

        public Addrs clearName() {
            this.hasName = false;
            this.name_ = "";
            return this;
        }

        public Addrs clearPrecise() {
            this.hasPrecise = false;
            this.precise_ = 0;
            return this;
        }

        public Addrs clearRightUpperBtn() {
            this.hasRightUpperBtn = false;
            this.rightUpperBtn_ = null;
            return this;
        }

        public Addrs clearStreetMapImg() {
            this.hasStreetMapImg = false;
            this.streetMapImg_ = null;
            return this;
        }

        public Addrs clearUid() {
            this.hasUid = false;
            this.uid_ = "";
            return this;
        }

        public Addrs clearVuiProcessData() {
            this.hasVuiProcessData = false;
            this.vuiProcessData_ = null;
            return this;
        }

        public int getAccFlag() {
            return this.accFlag_;
        }

        public String getAddr() {
            return this.addr_;
        }

        public String getAddrTransferParam() {
            return this.addrTransferParam_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public a getCloudTemplate() {
            return this.cloudTemplate_;
        }

        public String getDistance() {
            return this.distance_;
        }

        public String getGeo() {
            return this.geo_;
        }

        public String getName() {
            return this.name_;
        }

        public int getPrecise() {
            return this.precise_;
        }

        public AddrButton getRightUpperBtn() {
            return this.rightUpperBtn_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasAddr() ? d.l(1, getAddr()) : 0;
            if (hasGeo()) {
                iL += d.l(2, getGeo());
            }
            if (hasName()) {
                iL += d.l(3, getName());
            }
            if (hasPrecise()) {
                iL += d.e(4, getPrecise());
            }
            if (hasAccFlag()) {
                iL += d.e(5, getAccFlag());
            }
            if (hasCloudTemplate()) {
                iL += d.b(6, getCloudTemplate());
            }
            if (hasVuiProcessData()) {
                iL += d.h(7, getVuiProcessData());
            }
            if (hasUid()) {
                iL += d.l(8, getUid());
            }
            if (hasDistance()) {
                iL += d.l(9, getDistance());
            }
            if (hasStreetMapImg()) {
                iL += d.h(10, getStreetMapImg());
            }
            if (hasRightUpperBtn()) {
                iL += d.h(11, getRightUpperBtn());
            }
            if (hasAddrTransferParam()) {
                iL += d.l(12, getAddrTransferParam());
            }
            this.cachedSize = iL;
            return iL;
        }

        public StreetImg getStreetMapImg() {
            return this.streetMapImg_;
        }

        public String getUid() {
            return this.uid_;
        }

        public VuiProcessData getVuiProcessData() {
            return this.vuiProcessData_;
        }

        public boolean hasAccFlag() {
            return this.hasAccFlag;
        }

        public boolean hasAddr() {
            return this.hasAddr;
        }

        public boolean hasAddrTransferParam() {
            return this.hasAddrTransferParam;
        }

        public boolean hasCloudTemplate() {
            return this.hasCloudTemplate;
        }

        public boolean hasDistance() {
            return this.hasDistance;
        }

        public boolean hasGeo() {
            return this.hasGeo;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public boolean hasPrecise() {
            return this.hasPrecise;
        }

        public boolean hasRightUpperBtn() {
            return this.hasRightUpperBtn;
        }

        public boolean hasStreetMapImg() {
            return this.hasStreetMapImg;
        }

        public boolean hasUid() {
            return this.hasUid;
        }

        public boolean hasVuiProcessData() {
            return this.hasVuiProcessData;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Addrs setAccFlag(int i4) {
            this.hasAccFlag = true;
            this.accFlag_ = i4;
            return this;
        }

        public Addrs setAddr(String str) {
            this.hasAddr = true;
            this.addr_ = str;
            return this;
        }

        public Addrs setAddrTransferParam(String str) {
            this.hasAddrTransferParam = true;
            this.addrTransferParam_ = str;
            return this;
        }

        public Addrs setCloudTemplate(a aVar) {
            this.hasCloudTemplate = true;
            this.cloudTemplate_ = aVar;
            return this;
        }

        public Addrs setDistance(String str) {
            this.hasDistance = true;
            this.distance_ = str;
            return this;
        }

        public Addrs setGeo(String str) {
            this.hasGeo = true;
            this.geo_ = str;
            return this;
        }

        public Addrs setName(String str) {
            this.hasName = true;
            this.name_ = str;
            return this;
        }

        public Addrs setPrecise(int i4) {
            this.hasPrecise = true;
            this.precise_ = i4;
            return this;
        }

        public Addrs setRightUpperBtn(AddrButton addrButton) {
            if (addrButton == null) {
                return clearRightUpperBtn();
            }
            this.hasRightUpperBtn = true;
            this.rightUpperBtn_ = addrButton;
            return this;
        }

        public Addrs setStreetMapImg(StreetImg streetImg) {
            if (streetImg == null) {
                return clearStreetMapImg();
            }
            this.hasStreetMapImg = true;
            this.streetMapImg_ = streetImg;
            return this;
        }

        public Addrs setUid(String str) {
            this.hasUid = true;
            this.uid_ = str;
            return this;
        }

        public Addrs setVuiProcessData(VuiProcessData vuiProcessData) {
            if (vuiProcessData == null) {
                return clearVuiProcessData();
            }
            this.hasVuiProcessData = true;
            this.vuiProcessData_ = vuiProcessData;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasAddr()) {
                dVar.A(1, getAddr());
            }
            if (hasGeo()) {
                dVar.A(2, getGeo());
            }
            if (hasName()) {
                dVar.A(3, getName());
            }
            if (hasPrecise()) {
                dVar.s(4, getPrecise());
            }
            if (hasAccFlag()) {
                dVar.s(5, getAccFlag());
            }
            if (hasCloudTemplate()) {
                dVar.q(6, getCloudTemplate());
            }
            if (hasVuiProcessData()) {
                dVar.u(7, getVuiProcessData());
            }
            if (hasUid()) {
                dVar.A(8, getUid());
            }
            if (hasDistance()) {
                dVar.A(9, getDistance());
            }
            if (hasStreetMapImg()) {
                dVar.u(10, getStreetMapImg());
            }
            if (hasRightUpperBtn()) {
                dVar.u(11, getRightUpperBtn());
            }
            if (hasAddrTransferParam()) {
                dVar.A(12, getAddrTransferParam());
            }
        }

        public static Addrs parseFrom(byte[] bArr) throws e {
            return (Addrs) new Addrs().mergeFrom(bArr);
        }

        @Override // L1.f
        public Addrs mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                switch (iO) {
                    case 0:
                        return this;
                    case 10:
                        setAddr(bVar.n());
                        break;
                    case 18:
                        setGeo(bVar.n());
                        break;
                    case 26:
                        setName(bVar.n());
                        break;
                    case 32:
                        setPrecise(bVar.k());
                        break;
                    case 40:
                        setAccFlag(bVar.k());
                        break;
                    case 50:
                        setCloudTemplate(bVar.b());
                        break;
                    case 58:
                        VuiProcessData vuiProcessData = new VuiProcessData();
                        bVar.f(vuiProcessData);
                        setVuiProcessData(vuiProcessData);
                        break;
                    case 66:
                        setUid(bVar.n());
                        break;
                    case Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                        setDistance(bVar.n());
                        break;
                    case Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                        StreetImg streetImg = new StreetImg();
                        bVar.f(streetImg);
                        setStreetMapImg(streetImg);
                        break;
                    case 90:
                        AddrButton addrButton = new AddrButton();
                        bVar.f(addrButton);
                        setRightUpperBtn(addrButton);
                        break;
                    case 98:
                        setAddrTransferParam(bVar.n());
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

    public static final class Ads extends f {
        public static final int ADS_DATA_FIELD_NUMBER = 8;
        public static final int ADS_EXT_FIELD_NUMBER = 4;
        public static final int ADS_INFO_FIELD_NUMBER = 3;
        public static final int ADS_POS_FIELD_NUMBER = 6;
        public static final int ADS_TYPE_FIELD_NUMBER = 7;
        public static final int POS_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 2;
        private boolean hasAdsData;
        private boolean hasAdsExt;
        private boolean hasAdsInfo;
        private boolean hasAdsPos;
        private boolean hasAdsType;
        private boolean hasPos;
        private boolean hasType;
        private int pos_ = 0;
        private int type_ = 0;
        private AdsInfo adsInfo_ = null;
        private AdsExt adsExt_ = null;
        private int adsPos_ = 0;
        private int adsType_ = 0;
        private String adsData_ = "";
        private int cachedSize = -1;

        public static final class AdsExt extends f {
            public static final int ADS_LOGS_FIELD_NUMBER = 3;
            public static final int INTIMESIGN_FIELD_NUMBER = 1;
            public static final int PROMOTE_STYLE_FIELD_NUMBER = 2;
            private boolean hasAdsLogs;
            private boolean hasInTimeSign;
            private boolean hasPromoteStyle;
            private String inTimeSign_ = "";
            private int promoteStyle_ = 0;
            private String adsLogs_ = "";
            private int cachedSize = -1;

            public static AdsExt parseFrom(b bVar) throws IOException {
                return new AdsExt().mergeFrom(bVar);
            }

            public final AdsExt clear() {
                clearInTimeSign();
                clearPromoteStyle();
                clearAdsLogs();
                this.cachedSize = -1;
                return this;
            }

            public AdsExt clearAdsLogs() {
                this.hasAdsLogs = false;
                this.adsLogs_ = "";
                return this;
            }

            public AdsExt clearInTimeSign() {
                this.hasInTimeSign = false;
                this.inTimeSign_ = "";
                return this;
            }

            public AdsExt clearPromoteStyle() {
                this.hasPromoteStyle = false;
                this.promoteStyle_ = 0;
                return this;
            }

            public String getAdsLogs() {
                return this.adsLogs_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getInTimeSign() {
                return this.inTimeSign_;
            }

            public int getPromoteStyle() {
                return this.promoteStyle_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasInTimeSign() ? d.l(1, getInTimeSign()) : 0;
                if (hasPromoteStyle()) {
                    iL += d.e(2, getPromoteStyle());
                }
                if (hasAdsLogs()) {
                    iL += d.l(3, getAdsLogs());
                }
                this.cachedSize = iL;
                return iL;
            }

            public boolean hasAdsLogs() {
                return this.hasAdsLogs;
            }

            public boolean hasInTimeSign() {
                return this.hasInTimeSign;
            }

            public boolean hasPromoteStyle() {
                return this.hasPromoteStyle;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AdsExt setAdsLogs(String str) {
                this.hasAdsLogs = true;
                this.adsLogs_ = str;
                return this;
            }

            public AdsExt setInTimeSign(String str) {
                this.hasInTimeSign = true;
                this.inTimeSign_ = str;
                return this;
            }

            public AdsExt setPromoteStyle(int i4) {
                this.hasPromoteStyle = true;
                this.promoteStyle_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasInTimeSign()) {
                    dVar.A(1, getInTimeSign());
                }
                if (hasPromoteStyle()) {
                    dVar.s(2, getPromoteStyle());
                }
                if (hasAdsLogs()) {
                    dVar.A(3, getAdsLogs());
                }
            }

            public static AdsExt parseFrom(byte[] bArr) throws e {
                return (AdsExt) new AdsExt().mergeFrom(bArr);
            }

            @Override // L1.f
            public AdsExt mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setInTimeSign(bVar.n());
                    } else if (iO == 16) {
                        setPromoteStyle(bVar.k());
                    } else if (iO == 26) {
                        setAdsLogs(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class AdsInfo extends f {
            public static final int ADS_MAIN_FIELD_NUMBER = 1;
            private AdsMain adsMain_ = null;
            private int cachedSize = -1;
            private boolean hasAdsMain;

            public static final class AdsMain extends f {
                public static final int ADDR_FIELD_NUMBER = 9;
                public static final int BRIEF_FIELD_NUMBER = 10;
                public static final int DISTANCE_FIELD_NUMBER = 7;
                public static final int NAME_FIELD_NUMBER = 3;
                public static final int PIC_FIELD_NUMBER = 11;
                public static final int PRIMARY_UID_FIELD_NUMBER = 2;
                public static final int PROMOTE_STYLE_FIELD_NUMBER = 12;
                public static final int SRC_NAME_FIELD_NUMBER = 8;
                public static final int STYLE_FIELD_NUMBER = 1;
                public static final int URL_FIELD_NUMBER = 4;
                public static final int X_FIELD_NUMBER = 5;
                public static final int Y_FIELD_NUMBER = 6;
                private boolean hasAddr;
                private boolean hasBrief;
                private boolean hasDistance;
                private boolean hasName;
                private boolean hasPic;
                private boolean hasPrimaryUid;
                private boolean hasPromoteStyle;
                private boolean hasSrcName;
                private boolean hasStyle;
                private boolean hasUrl;
                private boolean hasX;
                private boolean hasY;
                private int style_ = 0;
                private String primaryUid_ = "";
                private String name_ = "";
                private String url_ = "";
                private String x_ = "";
                private String y_ = "";
                private int distance_ = 0;
                private String srcName_ = "";
                private String addr_ = "";
                private String brief_ = "";
                private String pic_ = "";
                private int promoteStyle_ = 0;
                private int cachedSize = -1;

                public static AdsMain parseFrom(b bVar) throws IOException {
                    return new AdsMain().mergeFrom(bVar);
                }

                public final AdsMain clear() {
                    clearStyle();
                    clearPrimaryUid();
                    clearName();
                    clearUrl();
                    clearX();
                    clearY();
                    clearDistance();
                    clearSrcName();
                    clearAddr();
                    clearBrief();
                    clearPic();
                    clearPromoteStyle();
                    this.cachedSize = -1;
                    return this;
                }

                public AdsMain clearAddr() {
                    this.hasAddr = false;
                    this.addr_ = "";
                    return this;
                }

                public AdsMain clearBrief() {
                    this.hasBrief = false;
                    this.brief_ = "";
                    return this;
                }

                public AdsMain clearDistance() {
                    this.hasDistance = false;
                    this.distance_ = 0;
                    return this;
                }

                public AdsMain clearName() {
                    this.hasName = false;
                    this.name_ = "";
                    return this;
                }

                public AdsMain clearPic() {
                    this.hasPic = false;
                    this.pic_ = "";
                    return this;
                }

                public AdsMain clearPrimaryUid() {
                    this.hasPrimaryUid = false;
                    this.primaryUid_ = "";
                    return this;
                }

                public AdsMain clearPromoteStyle() {
                    this.hasPromoteStyle = false;
                    this.promoteStyle_ = 0;
                    return this;
                }

                public AdsMain clearSrcName() {
                    this.hasSrcName = false;
                    this.srcName_ = "";
                    return this;
                }

                public AdsMain clearStyle() {
                    this.hasStyle = false;
                    this.style_ = 0;
                    return this;
                }

                public AdsMain clearUrl() {
                    this.hasUrl = false;
                    this.url_ = "";
                    return this;
                }

                public AdsMain clearX() {
                    this.hasX = false;
                    this.x_ = "";
                    return this;
                }

                public AdsMain clearY() {
                    this.hasY = false;
                    this.y_ = "";
                    return this;
                }

                public String getAddr() {
                    return this.addr_;
                }

                public String getBrief() {
                    return this.brief_;
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

                public String getName() {
                    return this.name_;
                }

                public String getPic() {
                    return this.pic_;
                }

                public String getPrimaryUid() {
                    return this.primaryUid_;
                }

                public int getPromoteStyle() {
                    return this.promoteStyle_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasStyle() ? d.e(1, getStyle()) : 0;
                    if (hasPrimaryUid()) {
                        iE += d.l(2, getPrimaryUid());
                    }
                    if (hasName()) {
                        iE += d.l(3, getName());
                    }
                    if (hasUrl()) {
                        iE += d.l(4, getUrl());
                    }
                    if (hasX()) {
                        iE += d.l(5, getX());
                    }
                    if (hasY()) {
                        iE += d.l(6, getY());
                    }
                    if (hasDistance()) {
                        iE += d.e(7, getDistance());
                    }
                    if (hasSrcName()) {
                        iE += d.l(8, getSrcName());
                    }
                    if (hasAddr()) {
                        iE += d.l(9, getAddr());
                    }
                    if (hasBrief()) {
                        iE += d.l(10, getBrief());
                    }
                    if (hasPic()) {
                        iE += d.l(11, getPic());
                    }
                    if (hasPromoteStyle()) {
                        iE += d.e(12, getPromoteStyle());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public String getSrcName() {
                    return this.srcName_;
                }

                public int getStyle() {
                    return this.style_;
                }

                public String getUrl() {
                    return this.url_;
                }

                public String getX() {
                    return this.x_;
                }

                public String getY() {
                    return this.y_;
                }

                public boolean hasAddr() {
                    return this.hasAddr;
                }

                public boolean hasBrief() {
                    return this.hasBrief;
                }

                public boolean hasDistance() {
                    return this.hasDistance;
                }

                public boolean hasName() {
                    return this.hasName;
                }

                public boolean hasPic() {
                    return this.hasPic;
                }

                public boolean hasPrimaryUid() {
                    return this.hasPrimaryUid;
                }

                public boolean hasPromoteStyle() {
                    return this.hasPromoteStyle;
                }

                public boolean hasSrcName() {
                    return this.hasSrcName;
                }

                public boolean hasStyle() {
                    return this.hasStyle;
                }

                public boolean hasUrl() {
                    return this.hasUrl;
                }

                public boolean hasX() {
                    return this.hasX;
                }

                public boolean hasY() {
                    return this.hasY;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public AdsMain setAddr(String str) {
                    this.hasAddr = true;
                    this.addr_ = str;
                    return this;
                }

                public AdsMain setBrief(String str) {
                    this.hasBrief = true;
                    this.brief_ = str;
                    return this;
                }

                public AdsMain setDistance(int i4) {
                    this.hasDistance = true;
                    this.distance_ = i4;
                    return this;
                }

                public AdsMain setName(String str) {
                    this.hasName = true;
                    this.name_ = str;
                    return this;
                }

                public AdsMain setPic(String str) {
                    this.hasPic = true;
                    this.pic_ = str;
                    return this;
                }

                public AdsMain setPrimaryUid(String str) {
                    this.hasPrimaryUid = true;
                    this.primaryUid_ = str;
                    return this;
                }

                public AdsMain setPromoteStyle(int i4) {
                    this.hasPromoteStyle = true;
                    this.promoteStyle_ = i4;
                    return this;
                }

                public AdsMain setSrcName(String str) {
                    this.hasSrcName = true;
                    this.srcName_ = str;
                    return this;
                }

                public AdsMain setStyle(int i4) {
                    this.hasStyle = true;
                    this.style_ = i4;
                    return this;
                }

                public AdsMain setUrl(String str) {
                    this.hasUrl = true;
                    this.url_ = str;
                    return this;
                }

                public AdsMain setX(String str) {
                    this.hasX = true;
                    this.x_ = str;
                    return this;
                }

                public AdsMain setY(String str) {
                    this.hasY = true;
                    this.y_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasStyle()) {
                        dVar.s(1, getStyle());
                    }
                    if (hasPrimaryUid()) {
                        dVar.A(2, getPrimaryUid());
                    }
                    if (hasName()) {
                        dVar.A(3, getName());
                    }
                    if (hasUrl()) {
                        dVar.A(4, getUrl());
                    }
                    if (hasX()) {
                        dVar.A(5, getX());
                    }
                    if (hasY()) {
                        dVar.A(6, getY());
                    }
                    if (hasDistance()) {
                        dVar.s(7, getDistance());
                    }
                    if (hasSrcName()) {
                        dVar.A(8, getSrcName());
                    }
                    if (hasAddr()) {
                        dVar.A(9, getAddr());
                    }
                    if (hasBrief()) {
                        dVar.A(10, getBrief());
                    }
                    if (hasPic()) {
                        dVar.A(11, getPic());
                    }
                    if (hasPromoteStyle()) {
                        dVar.s(12, getPromoteStyle());
                    }
                }

                public static AdsMain parseFrom(byte[] bArr) throws e {
                    return (AdsMain) new AdsMain().mergeFrom(bArr);
                }

                @Override // L1.f
                public AdsMain mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        switch (iO) {
                            case 0:
                                return this;
                            case 8:
                                setStyle(bVar.k());
                                break;
                            case 18:
                                setPrimaryUid(bVar.n());
                                break;
                            case 26:
                                setName(bVar.n());
                                break;
                            case 34:
                                setUrl(bVar.n());
                                break;
                            case 42:
                                setX(bVar.n());
                                break;
                            case 50:
                                setY(bVar.n());
                                break;
                            case 56:
                                setDistance(bVar.k());
                                break;
                            case 66:
                                setSrcName(bVar.n());
                                break;
                            case Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                                setAddr(bVar.n());
                                break;
                            case Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                                setBrief(bVar.n());
                                break;
                            case 90:
                                setPic(bVar.n());
                                break;
                            case 96:
                                setPromoteStyle(bVar.k());
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

            public static AdsInfo parseFrom(b bVar) throws IOException {
                return new AdsInfo().mergeFrom(bVar);
            }

            public final AdsInfo clear() {
                clearAdsMain();
                this.cachedSize = -1;
                return this;
            }

            public AdsInfo clearAdsMain() {
                this.hasAdsMain = false;
                this.adsMain_ = null;
                return this;
            }

            public AdsMain getAdsMain() {
                return this.adsMain_;
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
                int iH = hasAdsMain() ? d.h(1, getAdsMain()) : 0;
                this.cachedSize = iH;
                return iH;
            }

            public boolean hasAdsMain() {
                return this.hasAdsMain;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AdsInfo setAdsMain(AdsMain adsMain) {
                if (adsMain == null) {
                    return clearAdsMain();
                }
                this.hasAdsMain = true;
                this.adsMain_ = adsMain;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasAdsMain()) {
                    dVar.u(1, getAdsMain());
                }
            }

            public static AdsInfo parseFrom(byte[] bArr) throws e {
                return (AdsInfo) new AdsInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public AdsInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        AdsMain adsMain = new AdsMain();
                        bVar.f(adsMain);
                        setAdsMain(adsMain);
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static Ads parseFrom(b bVar) throws IOException {
            return new Ads().mergeFrom(bVar);
        }

        public final Ads clear() {
            clearPos();
            clearType();
            clearAdsInfo();
            clearAdsExt();
            clearAdsPos();
            clearAdsType();
            clearAdsData();
            this.cachedSize = -1;
            return this;
        }

        public Ads clearAdsData() {
            this.hasAdsData = false;
            this.adsData_ = "";
            return this;
        }

        public Ads clearAdsExt() {
            this.hasAdsExt = false;
            this.adsExt_ = null;
            return this;
        }

        public Ads clearAdsInfo() {
            this.hasAdsInfo = false;
            this.adsInfo_ = null;
            return this;
        }

        public Ads clearAdsPos() {
            this.hasAdsPos = false;
            this.adsPos_ = 0;
            return this;
        }

        public Ads clearAdsType() {
            this.hasAdsType = false;
            this.adsType_ = 0;
            return this;
        }

        public Ads clearPos() {
            this.hasPos = false;
            this.pos_ = 0;
            return this;
        }

        public Ads clearType() {
            this.hasType = false;
            this.type_ = 0;
            return this;
        }

        public String getAdsData() {
            return this.adsData_;
        }

        public AdsExt getAdsExt() {
            return this.adsExt_;
        }

        public AdsInfo getAdsInfo() {
            return this.adsInfo_;
        }

        public int getAdsPos() {
            return this.adsPos_;
        }

        public int getAdsType() {
            return this.adsType_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public int getPos() {
            return this.pos_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iE = hasPos() ? d.e(1, getPos()) : 0;
            if (hasType()) {
                iE += d.e(2, getType());
            }
            if (hasAdsInfo()) {
                iE += d.h(3, getAdsInfo());
            }
            if (hasAdsExt()) {
                iE += d.h(4, getAdsExt());
            }
            if (hasAdsPos()) {
                iE += d.e(6, getAdsPos());
            }
            if (hasAdsType()) {
                iE += d.e(7, getAdsType());
            }
            if (hasAdsData()) {
                iE += d.l(8, getAdsData());
            }
            this.cachedSize = iE;
            return iE;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasAdsData() {
            return this.hasAdsData;
        }

        public boolean hasAdsExt() {
            return this.hasAdsExt;
        }

        public boolean hasAdsInfo() {
            return this.hasAdsInfo;
        }

        public boolean hasAdsPos() {
            return this.hasAdsPos;
        }

        public boolean hasAdsType() {
            return this.hasAdsType;
        }

        public boolean hasPos() {
            return this.hasPos;
        }

        public boolean hasType() {
            return this.hasType;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Ads setAdsData(String str) {
            this.hasAdsData = true;
            this.adsData_ = str;
            return this;
        }

        public Ads setAdsExt(AdsExt adsExt) {
            if (adsExt == null) {
                return clearAdsExt();
            }
            this.hasAdsExt = true;
            this.adsExt_ = adsExt;
            return this;
        }

        public Ads setAdsInfo(AdsInfo adsInfo) {
            if (adsInfo == null) {
                return clearAdsInfo();
            }
            this.hasAdsInfo = true;
            this.adsInfo_ = adsInfo;
            return this;
        }

        public Ads setAdsPos(int i4) {
            this.hasAdsPos = true;
            this.adsPos_ = i4;
            return this;
        }

        public Ads setAdsType(int i4) {
            this.hasAdsType = true;
            this.adsType_ = i4;
            return this;
        }

        public Ads setPos(int i4) {
            this.hasPos = true;
            this.pos_ = i4;
            return this;
        }

        public Ads setType(int i4) {
            this.hasType = true;
            this.type_ = i4;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasPos()) {
                dVar.s(1, getPos());
            }
            if (hasType()) {
                dVar.s(2, getType());
            }
            if (hasAdsInfo()) {
                dVar.u(3, getAdsInfo());
            }
            if (hasAdsExt()) {
                dVar.u(4, getAdsExt());
            }
            if (hasAdsPos()) {
                dVar.s(6, getAdsPos());
            }
            if (hasAdsType()) {
                dVar.s(7, getAdsType());
            }
            if (hasAdsData()) {
                dVar.A(8, getAdsData());
            }
        }

        public static Ads parseFrom(byte[] bArr) throws e {
            return (Ads) new Ads().mergeFrom(bArr);
        }

        @Override // L1.f
        public Ads mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 8) {
                    setPos(bVar.k());
                } else if (iO == 16) {
                    setType(bVar.k());
                } else if (iO == 26) {
                    AdsInfo adsInfo = new AdsInfo();
                    bVar.f(adsInfo);
                    setAdsInfo(adsInfo);
                } else if (iO == 34) {
                    AdsExt adsExt = new AdsExt();
                    bVar.f(adsExt);
                    setAdsExt(adsExt);
                } else if (iO == 48) {
                    setAdsPos(bVar.k());
                } else if (iO == 56) {
                    setAdsType(bVar.k());
                } else if (iO == 66) {
                    setAdsData(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class AdsExtInfo extends f {
        public static final int ADS_PAGE_LOGS_FIELD_NUMBER = 1;
        private String adsPageLogs_ = "";
        private int cachedSize = -1;
        private boolean hasAdsPageLogs;

        public static AdsExtInfo parseFrom(b bVar) throws IOException {
            return new AdsExtInfo().mergeFrom(bVar);
        }

        public final AdsExtInfo clear() {
            clearAdsPageLogs();
            this.cachedSize = -1;
            return this;
        }

        public AdsExtInfo clearAdsPageLogs() {
            this.hasAdsPageLogs = false;
            this.adsPageLogs_ = "";
            return this;
        }

        public String getAdsPageLogs() {
            return this.adsPageLogs_;
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
            int iL = hasAdsPageLogs() ? d.l(1, getAdsPageLogs()) : 0;
            this.cachedSize = iL;
            return iL;
        }

        public boolean hasAdsPageLogs() {
            return this.hasAdsPageLogs;
        }

        public final boolean isInitialized() {
            return true;
        }

        public AdsExtInfo setAdsPageLogs(String str) {
            this.hasAdsPageLogs = true;
            this.adsPageLogs_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasAdsPageLogs()) {
                dVar.A(1, getAdsPageLogs());
            }
        }

        public static AdsExtInfo parseFrom(byte[] bArr) throws e {
            return (AdsExtInfo) new AdsExtInfo().mergeFrom(bArr);
        }

        @Override // L1.f
        public AdsExtInfo mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setAdsPageLogs(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class BrandBar extends f {
        public static final int DESC_FIELD_NUMBER = 6;
        public static final int IMG_FIELD_NUMBER = 1;
        public static final int LINK_FIELD_NUMBER = 5;
        public static final int SUBTITLE_FIELD_NUMBER = 3;
        public static final int TEL_FIELD_NUMBER = 4;
        public static final int TITLE_FIELD_NUMBER = 2;
        private boolean hasDesc;
        private boolean hasImg;
        private boolean hasLink;
        private boolean hasSubtitle;
        private boolean hasTel;
        private boolean hasTitle;
        private String img_ = "";
        private String title_ = "";
        private String subtitle_ = "";
        private String tel_ = "";
        private String link_ = "";
        private String desc_ = "";
        private int cachedSize = -1;

        public static BrandBar parseFrom(b bVar) throws IOException {
            return new BrandBar().mergeFrom(bVar);
        }

        public final BrandBar clear() {
            clearImg();
            clearTitle();
            clearSubtitle();
            clearTel();
            clearLink();
            clearDesc();
            this.cachedSize = -1;
            return this;
        }

        public BrandBar clearDesc() {
            this.hasDesc = false;
            this.desc_ = "";
            return this;
        }

        public BrandBar clearImg() {
            this.hasImg = false;
            this.img_ = "";
            return this;
        }

        public BrandBar clearLink() {
            this.hasLink = false;
            this.link_ = "";
            return this;
        }

        public BrandBar clearSubtitle() {
            this.hasSubtitle = false;
            this.subtitle_ = "";
            return this;
        }

        public BrandBar clearTel() {
            this.hasTel = false;
            this.tel_ = "";
            return this;
        }

        public BrandBar clearTitle() {
            this.hasTitle = false;
            this.title_ = "";
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

        public String getImg() {
            return this.img_;
        }

        public String getLink() {
            return this.link_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasImg() ? d.l(1, getImg()) : 0;
            if (hasTitle()) {
                iL += d.l(2, getTitle());
            }
            if (hasSubtitle()) {
                iL += d.l(3, getSubtitle());
            }
            if (hasTel()) {
                iL += d.l(4, getTel());
            }
            if (hasLink()) {
                iL += d.l(5, getLink());
            }
            if (hasDesc()) {
                iL += d.l(6, getDesc());
            }
            this.cachedSize = iL;
            return iL;
        }

        public String getSubtitle() {
            return this.subtitle_;
        }

        public String getTel() {
            return this.tel_;
        }

        public String getTitle() {
            return this.title_;
        }

        public boolean hasDesc() {
            return this.hasDesc;
        }

        public boolean hasImg() {
            return this.hasImg;
        }

        public boolean hasLink() {
            return this.hasLink;
        }

        public boolean hasSubtitle() {
            return this.hasSubtitle;
        }

        public boolean hasTel() {
            return this.hasTel;
        }

        public boolean hasTitle() {
            return this.hasTitle;
        }

        public final boolean isInitialized() {
            return true;
        }

        public BrandBar setDesc(String str) {
            this.hasDesc = true;
            this.desc_ = str;
            return this;
        }

        public BrandBar setImg(String str) {
            this.hasImg = true;
            this.img_ = str;
            return this;
        }

        public BrandBar setLink(String str) {
            this.hasLink = true;
            this.link_ = str;
            return this;
        }

        public BrandBar setSubtitle(String str) {
            this.hasSubtitle = true;
            this.subtitle_ = str;
            return this;
        }

        public BrandBar setTel(String str) {
            this.hasTel = true;
            this.tel_ = str;
            return this;
        }

        public BrandBar setTitle(String str) {
            this.hasTitle = true;
            this.title_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasImg()) {
                dVar.A(1, getImg());
            }
            if (hasTitle()) {
                dVar.A(2, getTitle());
            }
            if (hasSubtitle()) {
                dVar.A(3, getSubtitle());
            }
            if (hasTel()) {
                dVar.A(4, getTel());
            }
            if (hasLink()) {
                dVar.A(5, getLink());
            }
            if (hasDesc()) {
                dVar.A(6, getDesc());
            }
        }

        public static BrandBar parseFrom(byte[] bArr) throws e {
            return (BrandBar) new BrandBar().mergeFrom(bArr);
        }

        @Override // L1.f
        public BrandBar mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setImg(bVar.n());
                } else if (iO == 18) {
                    setTitle(bVar.n());
                } else if (iO == 26) {
                    setSubtitle(bVar.n());
                } else if (iO == 34) {
                    setTel(bVar.n());
                } else if (iO == 42) {
                    setLink(bVar.n());
                } else if (iO == 50) {
                    setDesc(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class Children extends f {
        public static final int CHILDREN_CONTENT_FIELD_NUMBER = 2;
        public static final int FATER_ID_FIELD_NUMBER = 1;
        private boolean hasFaterId;
        private String faterId_ = "";
        private List<Contents> childrenContent_ = Collections.emptyList();
        private int cachedSize = -1;

        public static Children parseFrom(b bVar) throws IOException {
            return new Children().mergeFrom(bVar);
        }

        public Children addChildrenContent(Contents contents) {
            if (contents == null) {
                return this;
            }
            if (this.childrenContent_.isEmpty()) {
                this.childrenContent_ = new ArrayList();
            }
            this.childrenContent_.add(contents);
            return this;
        }

        public final Children clear() {
            clearFaterId();
            clearChildrenContent();
            this.cachedSize = -1;
            return this;
        }

        public Children clearChildrenContent() {
            this.childrenContent_ = Collections.emptyList();
            return this;
        }

        public Children clearFaterId() {
            this.hasFaterId = false;
            this.faterId_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public Contents getChildrenContent(int i4) {
            return this.childrenContent_.get(i4);
        }

        public int getChildrenContentCount() {
            return this.childrenContent_.size();
        }

        public List<Contents> getChildrenContentList() {
            return this.childrenContent_;
        }

        public String getFaterId() {
            return this.faterId_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasFaterId() ? d.l(1, getFaterId()) : 0;
            Iterator<Contents> it = getChildrenContentList().iterator();
            while (it.hasNext()) {
                iL += d.h(2, it.next());
            }
            this.cachedSize = iL;
            return iL;
        }

        public boolean hasFaterId() {
            return this.hasFaterId;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Children setChildrenContent(int i4, Contents contents) {
            if (contents == null) {
                return this;
            }
            this.childrenContent_.set(i4, contents);
            return this;
        }

        public Children setFaterId(String str) {
            this.hasFaterId = true;
            this.faterId_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasFaterId()) {
                dVar.A(1, getFaterId());
            }
            Iterator<Contents> it = getChildrenContentList().iterator();
            while (it.hasNext()) {
                dVar.u(2, it.next());
            }
        }

        public static Children parseFrom(byte[] bArr) throws e {
            return (Children) new Children().mergeFrom(bArr);
        }

        @Override // L1.f
        public Children mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setFaterId(bVar.n());
                } else if (iO == 18) {
                    Contents contents = new Contents();
                    bVar.f(contents);
                    addChildrenContent(contents);
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class Contents extends f {
        public static final int ACC_FLAG_FIELD_NUMBER = 4;
        public static final int ADDR_FIELD_NUMBER = 5;
        public static final int ADS_DATA_FIELD_NUMBER = 80;
        public static final int ADVERTISE_INFO_FIELD_NUMBER = 78;
        public static final int AISPACE_ADS_FIELD_NUMBER = 83;
        public static final int AOI_FIELD_NUMBER = 12;
        public static final int AREA_NAME_FIELD_NUMBER = 51;
        public static final int ATTACHED_ADDR_FIELD_NUMBER = 58;
        public static final int AVOCADO_FORWARD_PARAM_FIELD_NUMBER = 66;
        public static final int BAR_BUTTON_FIELD_NUMBER = 75;
        public static final int BAR_TEMPLATE_FIELD_NUMBER = 41;
        public static final int BOUND_FIELD_NUMBER = 86;
        public static final int BRAND_ICON_ID_FIELD_NUMBER = 32;
        public static final int BURIED_POINT_FIELD_NUMBER = 68;
        public static final int BUTTON_FIELD_NUMBER = 39;
        public static final int CARD_TYPE_FIELD_NUMBER = 77;
        public static final int CHILD_CATALOG_FIELD_NUMBER = 24;
        public static final int CITY_FIELD_NUMBER = 59;
        public static final int CLOUD_TEMPLATE_FIELD_NUMBER = 38;
        public static final int DETAIL_DISPLAY_TYPE_FIELD_NUMBER = 62;
        public static final int DETAIL_FIELD_NUMBER = 6;
        public static final int DISTANCE_FIELD_NUMBER = 48;
        public static final int END_TIME_FIELD_NUMBER = 16;
        public static final int EXT_FIELD_NUMBER = 14;
        public static final int FATHER_SON_FIELD_NUMBER = 20;
        public static final int FAV_BUBBLE_FIELD_NUMBER = 84;
        public static final int FAV_NUM_FIELD_NUMBER = 82;
        public static final int FIXED_BAR_BUTTON_FIELD_NUMBER = 87;
        public static final int FOUR_STATE_SWITCH_FIELD_NUMBER = 79;
        public static final int GEO_FIELD_NUMBER = 1;
        public static final int GROUP_TYPE_FIELD_NUMBER = 88;
        public static final int GUILD_BUTTON_FIELD_NUMBER = 85;
        public static final int HALF_KILL_FIELD_NUMBER = 70;
        public static final int HAS_RTBUS_FIELD_NUMBER = 17;
        public static final int HEADWAY_FIELD_NUMBER = 43;
        public static final int HEAD_ICON_BUBBLE_INFO_FIELD_NUMBER = 71;
        public static final int HEAD_ICON_FIELD_NUMBER = 53;
        public static final int HEAD_RESULT_MSG_FIELD_NUMBER = 73;
        public static final int HEAT_MAP_FIELD_NUMBER = 23;
        public static final int HISTORY_ADDRESS_FIELD_NUMBER = 81;
        public static final int HORIZON_SLIDE_DATA_FIELD_NUMBER = 67;
        public static final int HW_BROWSE_RECORDS_FIELD_NUMBER = 74;
        public static final int ICON_ID_FIELD_NUMBER = 30;
        public static final int INDOOR_FLOOR_FIELD_NUMBER = 36;
        public static final int INDOOR_GEOZ_FIELD_NUMBER = 64;
        public static final int INDOOR_OVER_LOOKING_FIELD_NUMBER = 54;
        public static final int INDOOR_PANO_FIELD_NUMBER = 11;
        public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 37;
        public static final int INF_DYN_REQUEST_FIELD_NUMBER = 69;
        public static final int INTERVENT_TIPS_FIELD_NUMBER = 44;
        public static final int ISMODIFIED_FIELD_NUMBER = 42;
        public static final int KINDTYPE_FIELD_NUMBER = 31;
        public static final int LIST_SHOW_FIELD_NUMBER = 28;
        public static final int MAP_POITAG_FIELD_NUMBER = 40;
        public static final int MAX_SHOW_LEVEL_FIELD_NUMBER = 35;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEWSGEO_FIELD_NUMBER = 57;
        public static final int NEW_CATALOG_ID_FIELD_NUMBER = 26;
        public static final int PANO_FIELD_NUMBER = 10;
        public static final int PHOTO_LIST_FIELD_NUMBER = 52;
        public static final int POITYPE_FIELD_NUMBER = 9;
        public static final int POI_CHILD_TEXT_FIELD_NUMBER = 25;
        public static final int POI_REGION_TYPE_FIELD_NUMBER = 45;
        public static final int POI_SIMILAR_FIELD_NUMBER = 65;
        public static final int POI_TYPE_TEXT_FIELD_NUMBER = 22;
        public static final int PROVINCE_FIELD_NUMBER = 60;
        public static final int QUERY_GUIDE_FIELD_NUMBER = 63;
        public static final int RANK_FIELD_NUMBER = 34;
        public static final int RECOMMEND_TYPE_FIELD_NUMBER = 61;
        public static final int REC_REASON_FIELD_NUMBER = 7;
        public static final int REGION_TYPE_FIELD_NUMBER = 46;
        public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 19;
        public static final int SERVICE_TAG_FIELD_NUMBER = 50;
        public static final int SGEO_FIELD_NUMBER = 21;
        public static final int SHOW_FIELD_NUMBER = 13;
        public static final int SHOW_LEVEL_FIELD_NUMBER = 29;
        public static final int START_TIME_FIELD_NUMBER = 15;
        public static final int STD_TAG_FIELD_NUMBER = 49;
        public static final int STD_TAG_ID_FIELD_NUMBER = 55;
        public static final int TAG_FIELD_NUMBER = 33;
        public static final int TEL_FIELD_NUMBER = 8;
        public static final int THIRD_PARTY_FIELD_NUMBER = 72;
        public static final int TIP_RTBUS_FIELD_NUMBER = 18;
        public static final int TRAVEL_BUTTON_FIELD_NUMBER = 76;
        public static final int UID_FIELD_NUMBER = 3;
        public static final int VIEW_TYPE_FIELD_NUMBER = 27;
        public static final int VUI_PROCESS_DATA_FIELD_NUMBER = 56;
        private AdsData adsData_;
        private AdvertiseInfo advertiseInfo_;
        private AispaceAds aispaceAds_;
        private String areaName_;
        private int attachedAddr_;
        private String avocadoForwardParam_;
        private List<BarButton> barButton_;
        private a barTemplate_;
        private String bound_;
        private String buriedPoint_;
        private Button button_;
        private int cachedSize;
        private int cardType_;
        private String city_;
        private a cloudTemplate_;
        private int detailDisplayType_;
        private String distance_;
        private String favBubble_;
        private int favNum_;
        private List<FixedBarButton> fixedBarButton_;
        private int fourStateSwitch_;
        private String groupType_;
        private List<GuildButton> guildButton_;
        private boolean halfKill_;
        private boolean hasAccFlag;
        private boolean hasAddr;
        private boolean hasAdsData;
        private boolean hasAdvertiseInfo;
        private boolean hasAispaceAds;
        private boolean hasAoi;
        private boolean hasAreaName;
        private boolean hasAttachedAddr;
        private boolean hasAvocadoForwardParam;
        private boolean hasBarTemplate;
        private boolean hasBound;
        private boolean hasBrandIconId;
        private boolean hasBuriedPoint;
        private boolean hasButton;
        private boolean hasCardType;
        private boolean hasChildCatalog;
        private boolean hasCity;
        private boolean hasCloudTemplate;
        private boolean hasDetail;
        private boolean hasDetailDisplayType;
        private boolean hasDistance;
        private boolean hasEndTime;
        private boolean hasExt;
        private boolean hasFatherSon;
        private boolean hasFavBubble;
        private boolean hasFavNum;
        private boolean hasFourStateSwitch;
        private boolean hasGeo;
        private boolean hasGroupType;
        private boolean hasHalfKill;
        private boolean hasHasRtbus;
        private boolean hasHeadIcon;
        private boolean hasHeadIconBubbleInfo;
        private boolean hasHeadResultMsg;
        private boolean hasHeadway;
        private boolean hasHeatMap;
        private boolean hasHistoryAddress;
        private boolean hasHorizonSlideData;
        private boolean hasHwBrowseRecords;
        private boolean hasIconId;
        private boolean hasIndoorFloor;
        private boolean hasIndoorGeoz;
        private boolean hasIndoorOverLooking;
        private boolean hasIndoorPano;
        private boolean hasIndoorParentUid;
        private boolean hasInfDynRequest;
        private boolean hasInterventTips;
        private boolean hasIsmodified;
        private boolean hasKindtype;
        private boolean hasListShow;
        private boolean hasMapPoitag;
        private boolean hasMaxShowLevel;
        private boolean hasName;
        private boolean hasNewCatalogId;
        private boolean hasNewsgeo;
        private boolean hasPano;
        private boolean hasPhotoList;
        private boolean hasPoiChildText;
        private boolean hasPoiRegionType;
        private boolean hasPoiSimilar;
        private boolean hasPoiType;
        private boolean hasPoiTypeText;
        private boolean hasProvince;
        private boolean hasQueryGuide;
        private boolean hasRank;
        private boolean hasRecommendType;
        private boolean hasRegionType;
        private boolean hasRtbusUpdateTime;
        private boolean hasServiceTag;
        private boolean hasSgeo;
        private boolean hasShow;
        private boolean hasShowLevel;
        private boolean hasStartTime;
        private boolean hasStdTag;
        private boolean hasStdTagId;
        private boolean hasTag;
        private boolean hasTel;
        private boolean hasThirdParty;
        private boolean hasTipRtbus;
        private boolean hasTravelButton;
        private boolean hasUid;
        private boolean hasViewType;
        private boolean hasVuiProcessData;
        private HeadIconBubbleInfo headIconBubbleInfo_;
        private HeadIcon headIcon_;
        private a headResultMsg_;
        private String headway_;
        private String historyAddress_;
        private String horizonSlideData_;
        private StartPageData hwBrowseRecords_;
        private int indoorGeoz_;
        private int indoorOverLooking_;
        private int infDynRequest_;
        private String interventTips_;
        private int ismodified_;
        private MapPoitag mapPoitag_;
        private Sgeo newsgeo_;
        private String photoList_;
        private String poiRegionType_;
        private PoiSimilar poiSimilar_;
        private String province_;
        private String queryGuide_;
        private int recommendType_;
        private String regionType_;
        private String serviceTag_;
        private String stdTagId_;
        private String stdTag_;
        private ThirdParty thirdParty_;
        private TravelButton travelButton_;
        private VuiProcessData vuiProcessData_;
        private Show show_ = null;
        private Ext ext_ = null;
        private HeatMap heatMap_ = null;
        private Sgeo sgeo_ = null;
        private String geo_ = "";
        private String name_ = "";
        private String uid_ = "";
        private int accFlag_ = 0;
        private String addr_ = "";
        private int detail_ = 0;
        private List<String> recReason_ = Collections.emptyList();
        private String tel_ = "";
        private int poiType_ = 0;
        private int pano_ = 0;
        private String indoorPano_ = "";
        private String aoi_ = "";
        private String startTime_ = "";
        private String endTime_ = "";
        private int hasRtbus_ = 0;
        private String tipRtbus_ = "";
        private int rtbusUpdateTime_ = 0;
        private int fatherSon_ = 0;
        private String poiTypeText_ = "";
        private String childCatalog_ = "";
        private String poiChildText_ = "";
        private String newCatalogId_ = "";
        private int viewType_ = 0;
        private int listShow_ = 0;
        private int showLevel_ = 0;
        private int iconId_ = 0;
        private int kindtype_ = 0;
        private int brandIconId_ = 0;
        private int tag_ = 0;
        private int rank_ = 0;
        private int maxShowLevel_ = 0;
        private String indoorFloor_ = "";
        private String indoorParentUid_ = "";

        public static final class AdsData extends f {
            public static final int FLOAT_ICON_FIELD_NUMBER = 1;
            private boolean hasFloatIcon;
            private AdsPoiFloatIcon floatIcon_ = null;
            private int cachedSize = -1;

            public static final class AdsPoiFloatIcon extends f {
                public static final int DATA_FIELD_NUMBER = 1;
                private boolean hasData;
                private String data_ = "";
                private int cachedSize = -1;

                public static AdsPoiFloatIcon parseFrom(b bVar) throws IOException {
                    return new AdsPoiFloatIcon().mergeFrom(bVar);
                }

                public final AdsPoiFloatIcon clear() {
                    clearData();
                    this.cachedSize = -1;
                    return this;
                }

                public AdsPoiFloatIcon clearData() {
                    this.hasData = false;
                    this.data_ = "";
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getData() {
                    return this.data_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasData() ? d.l(1, getData()) : 0;
                    this.cachedSize = iL;
                    return iL;
                }

                public boolean hasData() {
                    return this.hasData;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public AdsPoiFloatIcon setData(String str) {
                    this.hasData = true;
                    this.data_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasData()) {
                        dVar.A(1, getData());
                    }
                }

                public static AdsPoiFloatIcon parseFrom(byte[] bArr) throws e {
                    return (AdsPoiFloatIcon) new AdsPoiFloatIcon().mergeFrom(bArr);
                }

                @Override // L1.f
                public AdsPoiFloatIcon mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setData(bVar.n());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static AdsData parseFrom(b bVar) throws IOException {
                return new AdsData().mergeFrom(bVar);
            }

            public final AdsData clear() {
                clearFloatIcon();
                this.cachedSize = -1;
                return this;
            }

            public AdsData clearFloatIcon() {
                this.hasFloatIcon = false;
                this.floatIcon_ = null;
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public AdsPoiFloatIcon getFloatIcon() {
                return this.floatIcon_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iH = hasFloatIcon() ? d.h(1, getFloatIcon()) : 0;
                this.cachedSize = iH;
                return iH;
            }

            public boolean hasFloatIcon() {
                return this.hasFloatIcon;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AdsData setFloatIcon(AdsPoiFloatIcon adsPoiFloatIcon) {
                if (adsPoiFloatIcon == null) {
                    return clearFloatIcon();
                }
                this.hasFloatIcon = true;
                this.floatIcon_ = adsPoiFloatIcon;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasFloatIcon()) {
                    dVar.u(1, getFloatIcon());
                }
            }

            public static AdsData parseFrom(byte[] bArr) throws e {
                return (AdsData) new AdsData().mergeFrom(bArr);
            }

            @Override // L1.f
            public AdsData mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        AdsPoiFloatIcon adsPoiFloatIcon = new AdsPoiFloatIcon();
                        bVar.f(adsPoiFloatIcon);
                        setFloatIcon(adsPoiFloatIcon);
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class AdvertiseInfo extends f {
            public static final int JUMP_URL_FIELD_NUMBER = 3;
            public static final int LOCATION_FIELD_NUMBER = 2;
            public static final int PIC_URL_FIELD_NUMBER = 1;
            private boolean hasJumpUrl;
            private boolean hasLocation;
            private boolean hasPicUrl;
            private String picUrl_ = "";
            private int location_ = 0;
            private String jumpUrl_ = "";
            private int cachedSize = -1;

            public static AdvertiseInfo parseFrom(b bVar) throws IOException {
                return new AdvertiseInfo().mergeFrom(bVar);
            }

            public final AdvertiseInfo clear() {
                clearPicUrl();
                clearLocation();
                clearJumpUrl();
                this.cachedSize = -1;
                return this;
            }

            public AdvertiseInfo clearJumpUrl() {
                this.hasJumpUrl = false;
                this.jumpUrl_ = "";
                return this;
            }

            public AdvertiseInfo clearLocation() {
                this.hasLocation = false;
                this.location_ = 0;
                return this;
            }

            public AdvertiseInfo clearPicUrl() {
                this.hasPicUrl = false;
                this.picUrl_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getJumpUrl() {
                return this.jumpUrl_;
            }

            public int getLocation() {
                return this.location_;
            }

            public String getPicUrl() {
                return this.picUrl_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasPicUrl() ? d.l(1, getPicUrl()) : 0;
                if (hasLocation()) {
                    iL += d.e(2, getLocation());
                }
                if (hasJumpUrl()) {
                    iL += d.l(3, getJumpUrl());
                }
                this.cachedSize = iL;
                return iL;
            }

            public boolean hasJumpUrl() {
                return this.hasJumpUrl;
            }

            public boolean hasLocation() {
                return this.hasLocation;
            }

            public boolean hasPicUrl() {
                return this.hasPicUrl;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AdvertiseInfo setJumpUrl(String str) {
                this.hasJumpUrl = true;
                this.jumpUrl_ = str;
                return this;
            }

            public AdvertiseInfo setLocation(int i4) {
                this.hasLocation = true;
                this.location_ = i4;
                return this;
            }

            public AdvertiseInfo setPicUrl(String str) {
                this.hasPicUrl = true;
                this.picUrl_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasPicUrl()) {
                    dVar.A(1, getPicUrl());
                }
                if (hasLocation()) {
                    dVar.s(2, getLocation());
                }
                if (hasJumpUrl()) {
                    dVar.A(3, getJumpUrl());
                }
            }

            public static AdvertiseInfo parseFrom(byte[] bArr) throws e {
                return (AdvertiseInfo) new AdvertiseInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public AdvertiseInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setPicUrl(bVar.n());
                    } else if (iO == 16) {
                        setLocation(bVar.k());
                    } else if (iO == 26) {
                        setJumpUrl(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class AispaceAds extends f {
            public static final int DATA_FIELD_NUMBER = 1;
            private boolean hasData;
            private String data_ = "";
            private int cachedSize = -1;

            public static AispaceAds parseFrom(b bVar) throws IOException {
                return new AispaceAds().mergeFrom(bVar);
            }

            public final AispaceAds clear() {
                clearData();
                this.cachedSize = -1;
                return this;
            }

            public AispaceAds clearData() {
                this.hasData = false;
                this.data_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getData() {
                return this.data_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasData() ? d.l(1, getData()) : 0;
                this.cachedSize = iL;
                return iL;
            }

            public boolean hasData() {
                return this.hasData;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AispaceAds setData(String str) {
                this.hasData = true;
                this.data_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasData()) {
                    dVar.A(1, getData());
                }
            }

            public static AispaceAds parseFrom(byte[] bArr) throws e {
                return (AispaceAds) new AispaceAds().mergeFrom(bArr);
            }

            @Override // L1.f
            public AispaceAds mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setData(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class BarButton extends f {
            public static final int ALL_POS = 0;
            public static final int BAR_FIELD_NUMBER = 1;
            public static final int DETAIL_POS = 2;
            public static final int POS_FIELD_NUMBER = 2;
            public static final int SLIDE_POS = 1;
            private boolean hasBar;
            private boolean hasPos;
            private Button bar_ = null;
            private int pos_ = 0;
            private int cachedSize = -1;

            public static BarButton parseFrom(b bVar) throws IOException {
                return new BarButton().mergeFrom(bVar);
            }

            public final BarButton clear() {
                clearBar();
                clearPos();
                this.cachedSize = -1;
                return this;
            }

            public BarButton clearBar() {
                this.hasBar = false;
                this.bar_ = null;
                return this;
            }

            public BarButton clearPos() {
                this.hasPos = false;
                this.pos_ = 0;
                return this;
            }

            public Button getBar() {
                return this.bar_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getPos() {
                return this.pos_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iH = hasBar() ? d.h(1, getBar()) : 0;
                if (hasPos()) {
                    iH += d.e(2, getPos());
                }
                this.cachedSize = iH;
                return iH;
            }

            public boolean hasBar() {
                return this.hasBar;
            }

            public boolean hasPos() {
                return this.hasPos;
            }

            public final boolean isInitialized() {
                return true;
            }

            public BarButton setBar(Button button) {
                if (button == null) {
                    return clearBar();
                }
                this.hasBar = true;
                this.bar_ = button;
                return this;
            }

            public BarButton setPos(int i4) {
                this.hasPos = true;
                this.pos_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasBar()) {
                    dVar.u(1, getBar());
                }
                if (hasPos()) {
                    dVar.s(2, getPos());
                }
            }

            public static BarButton parseFrom(byte[] bArr) throws e {
                return (BarButton) new BarButton().mergeFrom(bArr);
            }

            @Override // L1.f
            public BarButton mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        Button button = new Button();
                        bVar.f(button);
                        setBar(button);
                    } else if (iO == 16) {
                        setPos(bVar.k());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Button extends f {
            public static final int CONTENT_FIELD_NUMBER = 1;
            public static final int GIF_URL_FIELD_NUMBER = 6;
            public static final int HINT_TEXT_FIELD_NUMBER = 9;
            public static final int ICON_URL_FIELD_NUMBER = 4;
            public static final int ONCE_BUBBLE_FIELD_NUMBER = 7;
            public static final int ONCE_BUBBLE_ICON_URL_FIELD_NUMBER = 8;
            public static final int SUB_ICON_URL_FIELD_NUMBER = 5;
            public static final int TIME_DURATION_FIELD_NUMBER = 11;
            public static final int TIME_ENTRANCE_FIELD_NUMBER = 10;
            public static final int TITLE_FIELD_NUMBER = 2;
            public static final int TYPE_FIELD_NUMBER = 3;
            private boolean hasContent;
            private boolean hasGifUrl;
            private boolean hasHintText;
            private boolean hasIconUrl;
            private boolean hasOnceBubble;
            private boolean hasOnceBubbleIconUrl;
            private boolean hasSubIconUrl;
            private boolean hasTimeDuration;
            private boolean hasTimeEntrance;
            private boolean hasTitle;
            private boolean hasType;
            private String content_ = "";
            private String title_ = "";
            private String type_ = "";
            private String iconUrl_ = "";
            private String subIconUrl_ = "";
            private String gifUrl_ = "";
            private String onceBubble_ = "";
            private String onceBubbleIconUrl_ = "";
            private String hintText_ = "";
            private int timeEntrance_ = 0;
            private int timeDuration_ = 0;
            private int cachedSize = -1;

            public static Button parseFrom(b bVar) throws IOException {
                return new Button().mergeFrom(bVar);
            }

            public final Button clear() {
                clearContent();
                clearTitle();
                clearType();
                clearIconUrl();
                clearSubIconUrl();
                clearGifUrl();
                clearOnceBubble();
                clearOnceBubbleIconUrl();
                clearHintText();
                clearTimeEntrance();
                clearTimeDuration();
                this.cachedSize = -1;
                return this;
            }

            public Button clearContent() {
                this.hasContent = false;
                this.content_ = "";
                return this;
            }

            public Button clearGifUrl() {
                this.hasGifUrl = false;
                this.gifUrl_ = "";
                return this;
            }

            public Button clearHintText() {
                this.hasHintText = false;
                this.hintText_ = "";
                return this;
            }

            public Button clearIconUrl() {
                this.hasIconUrl = false;
                this.iconUrl_ = "";
                return this;
            }

            public Button clearOnceBubble() {
                this.hasOnceBubble = false;
                this.onceBubble_ = "";
                return this;
            }

            public Button clearOnceBubbleIconUrl() {
                this.hasOnceBubbleIconUrl = false;
                this.onceBubbleIconUrl_ = "";
                return this;
            }

            public Button clearSubIconUrl() {
                this.hasSubIconUrl = false;
                this.subIconUrl_ = "";
                return this;
            }

            public Button clearTimeDuration() {
                this.hasTimeDuration = false;
                this.timeDuration_ = 0;
                return this;
            }

            public Button clearTimeEntrance() {
                this.hasTimeEntrance = false;
                this.timeEntrance_ = 0;
                return this;
            }

            public Button clearTitle() {
                this.hasTitle = false;
                this.title_ = "";
                return this;
            }

            public Button clearType() {
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

            public String getGifUrl() {
                return this.gifUrl_;
            }

            public String getHintText() {
                return this.hintText_;
            }

            public String getIconUrl() {
                return this.iconUrl_;
            }

            public String getOnceBubble() {
                return this.onceBubble_;
            }

            public String getOnceBubbleIconUrl() {
                return this.onceBubbleIconUrl_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasContent() ? d.l(1, getContent()) : 0;
                if (hasTitle()) {
                    iL += d.l(2, getTitle());
                }
                if (hasType()) {
                    iL += d.l(3, getType());
                }
                if (hasIconUrl()) {
                    iL += d.l(4, getIconUrl());
                }
                if (hasSubIconUrl()) {
                    iL += d.l(5, getSubIconUrl());
                }
                if (hasGifUrl()) {
                    iL += d.l(6, getGifUrl());
                }
                if (hasOnceBubble()) {
                    iL += d.l(7, getOnceBubble());
                }
                if (hasOnceBubbleIconUrl()) {
                    iL += d.l(8, getOnceBubbleIconUrl());
                }
                if (hasHintText()) {
                    iL += d.l(9, getHintText());
                }
                if (hasTimeEntrance()) {
                    iL += d.e(10, getTimeEntrance());
                }
                if (hasTimeDuration()) {
                    iL += d.e(11, getTimeDuration());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getSubIconUrl() {
                return this.subIconUrl_;
            }

            public int getTimeDuration() {
                return this.timeDuration_;
            }

            public int getTimeEntrance() {
                return this.timeEntrance_;
            }

            public String getTitle() {
                return this.title_;
            }

            public String getType() {
                return this.type_;
            }

            public boolean hasContent() {
                return this.hasContent;
            }

            public boolean hasGifUrl() {
                return this.hasGifUrl;
            }

            public boolean hasHintText() {
                return this.hasHintText;
            }

            public boolean hasIconUrl() {
                return this.hasIconUrl;
            }

            public boolean hasOnceBubble() {
                return this.hasOnceBubble;
            }

            public boolean hasOnceBubbleIconUrl() {
                return this.hasOnceBubbleIconUrl;
            }

            public boolean hasSubIconUrl() {
                return this.hasSubIconUrl;
            }

            public boolean hasTimeDuration() {
                return this.hasTimeDuration;
            }

            public boolean hasTimeEntrance() {
                return this.hasTimeEntrance;
            }

            public boolean hasTitle() {
                return this.hasTitle;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Button setContent(String str) {
                this.hasContent = true;
                this.content_ = str;
                return this;
            }

            public Button setGifUrl(String str) {
                this.hasGifUrl = true;
                this.gifUrl_ = str;
                return this;
            }

            public Button setHintText(String str) {
                this.hasHintText = true;
                this.hintText_ = str;
                return this;
            }

            public Button setIconUrl(String str) {
                this.hasIconUrl = true;
                this.iconUrl_ = str;
                return this;
            }

            public Button setOnceBubble(String str) {
                this.hasOnceBubble = true;
                this.onceBubble_ = str;
                return this;
            }

            public Button setOnceBubbleIconUrl(String str) {
                this.hasOnceBubbleIconUrl = true;
                this.onceBubbleIconUrl_ = str;
                return this;
            }

            public Button setSubIconUrl(String str) {
                this.hasSubIconUrl = true;
                this.subIconUrl_ = str;
                return this;
            }

            public Button setTimeDuration(int i4) {
                this.hasTimeDuration = true;
                this.timeDuration_ = i4;
                return this;
            }

            public Button setTimeEntrance(int i4) {
                this.hasTimeEntrance = true;
                this.timeEntrance_ = i4;
                return this;
            }

            public Button setTitle(String str) {
                this.hasTitle = true;
                this.title_ = str;
                return this;
            }

            public Button setType(String str) {
                this.hasType = true;
                this.type_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasContent()) {
                    dVar.A(1, getContent());
                }
                if (hasTitle()) {
                    dVar.A(2, getTitle());
                }
                if (hasType()) {
                    dVar.A(3, getType());
                }
                if (hasIconUrl()) {
                    dVar.A(4, getIconUrl());
                }
                if (hasSubIconUrl()) {
                    dVar.A(5, getSubIconUrl());
                }
                if (hasGifUrl()) {
                    dVar.A(6, getGifUrl());
                }
                if (hasOnceBubble()) {
                    dVar.A(7, getOnceBubble());
                }
                if (hasOnceBubbleIconUrl()) {
                    dVar.A(8, getOnceBubbleIconUrl());
                }
                if (hasHintText()) {
                    dVar.A(9, getHintText());
                }
                if (hasTimeEntrance()) {
                    dVar.s(10, getTimeEntrance());
                }
                if (hasTimeDuration()) {
                    dVar.s(11, getTimeDuration());
                }
            }

            public static Button parseFrom(byte[] bArr) throws e {
                return (Button) new Button().mergeFrom(bArr);
            }

            @Override // L1.f
            public Button mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    switch (iO) {
                        case 0:
                            return this;
                        case 10:
                            setContent(bVar.n());
                            break;
                        case 18:
                            setTitle(bVar.n());
                            break;
                        case 26:
                            setType(bVar.n());
                            break;
                        case 34:
                            setIconUrl(bVar.n());
                            break;
                        case 42:
                            setSubIconUrl(bVar.n());
                            break;
                        case 50:
                            setGifUrl(bVar.n());
                            break;
                        case 58:
                            setOnceBubble(bVar.n());
                            break;
                        case 66:
                            setOnceBubbleIconUrl(bVar.n());
                            break;
                        case Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                            setHintText(bVar.n());
                            break;
                        case 80:
                            setTimeEntrance(bVar.k());
                            break;
                        case 88:
                            setTimeDuration(bVar.k());
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

        public static final class Ext extends f {
            public static final int ADV_INFO_FIELD_NUMBER = 3;
            public static final int DETAIL_INFO_FIELD_NUMBER = 2;
            public static final int SRC_NAME_FIELD_NUMBER = 1;
            private boolean hasAdvInfo;
            private boolean hasDetailInfo;
            private boolean hasSrcName;
            private DetailInfo detailInfo_ = null;
            private String srcName_ = "";
            private AdvInfo advInfo_ = null;
            private int cachedSize = -1;

            public static final class AdvInfo extends f {
                public static final int OP_INFO_FIELD_NUMBER = 2;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasOpInfo;
                private boolean hasType;
                private String type_ = "";
                private OpInfo opInfo_ = null;
                private int cachedSize = -1;

                public static final class OpInfo extends f {
                    public static final int ADDR_FIELD_NUMBER = 8;
                    public static final int ADVID_FIELD_NUMBER = 5;
                    public static final int CITY_FIELD_NUMBER = 6;
                    public static final int DES_FIELD_NUMBER = 4;
                    public static final int ICON_FIELD_NUMBER = 2;
                    public static final int NAME_FIELD_NUMBER = 7;
                    public static final int PRIMARY_UID_FIELD_NUMBER = 1;
                    public static final int SDES_FIELD_NUMBER = 3;
                    public static final int URL_FIELD_NUMBER = 9;
                    private boolean hasAddr;
                    private boolean hasAdvid;
                    private boolean hasCity;
                    private boolean hasDes;
                    private boolean hasIcon;
                    private boolean hasName;
                    private boolean hasPrimaryUid;
                    private boolean hasSdes;
                    private boolean hasUrl;
                    private String primaryUid_ = "";
                    private String icon_ = "";
                    private String sdes_ = "";
                    private String des_ = "";
                    private String advid_ = "";
                    private String city_ = "";
                    private String name_ = "";
                    private String addr_ = "";
                    private String url_ = "";
                    private int cachedSize = -1;

                    public static OpInfo parseFrom(b bVar) throws IOException {
                        return new OpInfo().mergeFrom(bVar);
                    }

                    public final OpInfo clear() {
                        clearPrimaryUid();
                        clearIcon();
                        clearSdes();
                        clearDes();
                        clearAdvid();
                        clearCity();
                        clearName();
                        clearAddr();
                        clearUrl();
                        this.cachedSize = -1;
                        return this;
                    }

                    public OpInfo clearAddr() {
                        this.hasAddr = false;
                        this.addr_ = "";
                        return this;
                    }

                    public OpInfo clearAdvid() {
                        this.hasAdvid = false;
                        this.advid_ = "";
                        return this;
                    }

                    public OpInfo clearCity() {
                        this.hasCity = false;
                        this.city_ = "";
                        return this;
                    }

                    public OpInfo clearDes() {
                        this.hasDes = false;
                        this.des_ = "";
                        return this;
                    }

                    public OpInfo clearIcon() {
                        this.hasIcon = false;
                        this.icon_ = "";
                        return this;
                    }

                    public OpInfo clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    public OpInfo clearPrimaryUid() {
                        this.hasPrimaryUid = false;
                        this.primaryUid_ = "";
                        return this;
                    }

                    public OpInfo clearSdes() {
                        this.hasSdes = false;
                        this.sdes_ = "";
                        return this;
                    }

                    public OpInfo clearUrl() {
                        this.hasUrl = false;
                        this.url_ = "";
                        return this;
                    }

                    public String getAddr() {
                        return this.addr_;
                    }

                    public String getAdvid() {
                        return this.advid_;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getCity() {
                        return this.city_;
                    }

                    public String getDes() {
                        return this.des_;
                    }

                    public String getIcon() {
                        return this.icon_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    public String getPrimaryUid() {
                        return this.primaryUid_;
                    }

                    public String getSdes() {
                        return this.sdes_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasPrimaryUid() ? d.l(1, getPrimaryUid()) : 0;
                        if (hasIcon()) {
                            iL += d.l(2, getIcon());
                        }
                        if (hasSdes()) {
                            iL += d.l(3, getSdes());
                        }
                        if (hasDes()) {
                            iL += d.l(4, getDes());
                        }
                        if (hasAdvid()) {
                            iL += d.l(5, getAdvid());
                        }
                        if (hasCity()) {
                            iL += d.l(6, getCity());
                        }
                        if (hasName()) {
                            iL += d.l(7, getName());
                        }
                        if (hasAddr()) {
                            iL += d.l(8, getAddr());
                        }
                        if (hasUrl()) {
                            iL += d.l(9, getUrl());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public String getUrl() {
                        return this.url_;
                    }

                    public boolean hasAddr() {
                        return this.hasAddr;
                    }

                    public boolean hasAdvid() {
                        return this.hasAdvid;
                    }

                    public boolean hasCity() {
                        return this.hasCity;
                    }

                    public boolean hasDes() {
                        return this.hasDes;
                    }

                    public boolean hasIcon() {
                        return this.hasIcon;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public boolean hasPrimaryUid() {
                        return this.hasPrimaryUid;
                    }

                    public boolean hasSdes() {
                        return this.hasSdes;
                    }

                    public boolean hasUrl() {
                        return this.hasUrl;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public OpInfo setAddr(String str) {
                        this.hasAddr = true;
                        this.addr_ = str;
                        return this;
                    }

                    public OpInfo setAdvid(String str) {
                        this.hasAdvid = true;
                        this.advid_ = str;
                        return this;
                    }

                    public OpInfo setCity(String str) {
                        this.hasCity = true;
                        this.city_ = str;
                        return this;
                    }

                    public OpInfo setDes(String str) {
                        this.hasDes = true;
                        this.des_ = str;
                        return this;
                    }

                    public OpInfo setIcon(String str) {
                        this.hasIcon = true;
                        this.icon_ = str;
                        return this;
                    }

                    public OpInfo setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    public OpInfo setPrimaryUid(String str) {
                        this.hasPrimaryUid = true;
                        this.primaryUid_ = str;
                        return this;
                    }

                    public OpInfo setSdes(String str) {
                        this.hasSdes = true;
                        this.sdes_ = str;
                        return this;
                    }

                    public OpInfo setUrl(String str) {
                        this.hasUrl = true;
                        this.url_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasPrimaryUid()) {
                            dVar.A(1, getPrimaryUid());
                        }
                        if (hasIcon()) {
                            dVar.A(2, getIcon());
                        }
                        if (hasSdes()) {
                            dVar.A(3, getSdes());
                        }
                        if (hasDes()) {
                            dVar.A(4, getDes());
                        }
                        if (hasAdvid()) {
                            dVar.A(5, getAdvid());
                        }
                        if (hasCity()) {
                            dVar.A(6, getCity());
                        }
                        if (hasName()) {
                            dVar.A(7, getName());
                        }
                        if (hasAddr()) {
                            dVar.A(8, getAddr());
                        }
                        if (hasUrl()) {
                            dVar.A(9, getUrl());
                        }
                    }

                    public static OpInfo parseFrom(byte[] bArr) throws e {
                        return (OpInfo) new OpInfo().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public OpInfo mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setPrimaryUid(bVar.n());
                            } else if (iO == 18) {
                                setIcon(bVar.n());
                            } else if (iO == 26) {
                                setSdes(bVar.n());
                            } else if (iO == 34) {
                                setDes(bVar.n());
                            } else if (iO == 42) {
                                setAdvid(bVar.n());
                            } else if (iO == 50) {
                                setCity(bVar.n());
                            } else if (iO == 58) {
                                setName(bVar.n());
                            } else if (iO == 66) {
                                setAddr(bVar.n());
                            } else if (iO == 74) {
                                setUrl(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static AdvInfo parseFrom(b bVar) throws IOException {
                    return new AdvInfo().mergeFrom(bVar);
                }

                public final AdvInfo clear() {
                    clearType();
                    clearOpInfo();
                    this.cachedSize = -1;
                    return this;
                }

                public AdvInfo clearOpInfo() {
                    this.hasOpInfo = false;
                    this.opInfo_ = null;
                    return this;
                }

                public AdvInfo clearType() {
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

                public OpInfo getOpInfo() {
                    return this.opInfo_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iL = hasType() ? d.l(1, getType()) : 0;
                    if (hasOpInfo()) {
                        iL += d.h(2, getOpInfo());
                    }
                    this.cachedSize = iL;
                    return iL;
                }

                public String getType() {
                    return this.type_;
                }

                public boolean hasOpInfo() {
                    return this.hasOpInfo;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public AdvInfo setOpInfo(OpInfo opInfo) {
                    if (opInfo == null) {
                        return clearOpInfo();
                    }
                    this.hasOpInfo = true;
                    this.opInfo_ = opInfo;
                    return this;
                }

                public AdvInfo setType(String str) {
                    this.hasType = true;
                    this.type_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasType()) {
                        dVar.A(1, getType());
                    }
                    if (hasOpInfo()) {
                        dVar.u(2, getOpInfo());
                    }
                }

                public static AdvInfo parseFrom(byte[] bArr) throws e {
                    return (AdvInfo) new AdvInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public AdvInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 10) {
                            setType(bVar.n());
                        } else if (iO == 18) {
                            OpInfo opInfo = new OpInfo();
                            bVar.f(opInfo);
                            setOpInfo(opInfo);
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static final class DetailInfo extends f {
                public static final int ACTIVITY_FIELD_NUMBER = 23;
                public static final int ALLCARDEXTENSION_FIELD_NUMBER = 47;
                public static final int AOI_FIELD_NUMBER = 43;
                public static final int BLINK_BUILDING_FIELD_NUMBER = 55;
                public static final int BOOK_INFO_FIELD_NUMBER = 18;
                public static final int BUSINESS_SERVICE_FIELD_NUMBER = 37;
                public static final int CHEJI_NEED_FIELD_NUMBER = 56;
                public static final int COMMENT_NUM_FIELD_NUMBER = 11;
                public static final int DISCOUNT_FIELD_NUMBER = 21;
                public static final int DISCOUNT_TOTAL_FIELD_NUMBER = 8;
                public static final int DISPLAY_INFO_COMMENT_LABEL_FIELD_NUMBER = 41;
                public static final int DISPLAY_INFO_REDU_FIELD_NUMBER = 40;
                public static final int DIS_TEXT_FIELD_NUMBER = 33;
                public static final int FLAG_FIELD_NUMBER = 1;
                public static final int FLAG_ON_LEFT_FIELD_NUMBER = 26;
                public static final int GRADE_FIELD_NUMBER = 22;
                public static final int GROUPON_FLAG_FIELD_NUMBER = 14;
                public static final int GROUPON_INFO_FIELD_NUMBER = 15;
                public static final int GROUPON_TOTAL_FIELD_NUMBER = 9;
                public static final int GUIDE_FIELD_NUMBER = 24;
                public static final int HOTEL_SERVICE_FIELD_NUMBER = 46;
                public static final int IMAGE_FIELD_NUMBER = 5;
                public static final int IMPRESSION_FIELD_NUMBER = 27;
                public static final int LBC_BUSINESS_VIP_FIELD_NUMBER = 34;
                public static final int MARKETBIZ_FIELD_NUMBER = 30;
                public static final int MBC_FIELD_NUMBER = 42;
                public static final int MEISHIPAIHAO_FIELD_NUMBER = 28;
                public static final int MINIPROGRAM_FIELD_NUMBER = 53;
                public static final int MNP_KEY_INFO_FIELD_NUMBER = 54;
                public static final int MOVIE_FILM_COUNT_FIELD_NUMBER = 13;
                public static final int MOVIE_FLAG_FIELD_NUMBER = 12;
                public static final int NEW_BUSINESS_TIME_FIELD_NUMBER = 52;
                public static final int ORIGIN_PRICE_TEXT_FIELD_NUMBER = 45;
                public static final int ORIL_INFO_FIELD_NUMBER = 16;
                public static final int OVERALL_RATING_FIELD_NUMBER = 2;
                public static final int PHONE_DETAIL_FIELD_NUMBER = 50;
                public static final int PHONE_RISK_FIELD_NUMBER = 51;
                public static final int PREMIUM_FLAG_FIELD_NUMBER = 7;
                public static final int PREMIUM_INFO_FIELD_NUMBER = 10;
                public static final int PRICE_FIELD_NUMBER = 19;
                public static final int PRICE_TEXT_FIELD_NUMBER = 3;
                public static final int RECOMMEND_DISH_FIELD_NUMBER = 36;
                public static final int SHOP_HOURS_FIELD_NUMBER = 48;
                public static final int SHOW_INFO_FIELD_NUMBER = 6;
                public static final int SPECIAL_SERVICE_FIELD_NUMBER = 25;
                public static final int SPECIAL_TAG_FIELD_NUMBER = 44;
                public static final int STATUS_LABEL_FIELD_NUMBER = 38;
                public static final int TAG_FIELD_NUMBER = 4;
                public static final int TRADE_TAG_FIELD_NUMBER = 29;
                public static final int UPPERLEFTCORNER_FIELD_NUMBER = 39;
                public static final int VALIDATE_FIELD_NUMBER = 31;
                public static final int VS_CONTENT_FIELD_NUMBER = 49;
                public static final int WAP_BOOKABLE_FIELD_NUMBER = 17;
                public static final int WISE_FULLROOM_FIELD_NUMBER = 20;
                public static final int WISE_HOURLY_BOOKABLE_FIELD_NUMBER = 32;
                private boolean hasAllcardextension;
                private boolean hasAoi;
                private boolean hasBlinkBuilding;
                private boolean hasBookInfo;
                private boolean hasBusinessService;
                private boolean hasChejiNeed;
                private boolean hasCommentNum;
                private boolean hasDisText;
                private boolean hasDiscount;
                private boolean hasDiscountTotal;
                private boolean hasDisplayInfoCommentLabel;
                private boolean hasDisplayInfoRedu;
                private boolean hasFlagOnLeft;
                private boolean hasGrade;
                private boolean hasGrouponFlag;
                private boolean hasGrouponInfo;
                private boolean hasGrouponTotal;
                private boolean hasGuide;
                private boolean hasImage;
                private boolean hasLbcBusinessVip;
                private boolean hasMarketbiz;
                private boolean hasMbc;
                private boolean hasMeishipaihao;
                private boolean hasMiniprogram;
                private boolean hasMnpKeyInfo;
                private boolean hasMovieFilmCount;
                private boolean hasMovieFlag;
                private boolean hasNewBusinessTime;
                private boolean hasOriginPriceText;
                private boolean hasOrilInfo;
                private boolean hasOverallRating;
                private boolean hasPhoneDetail;
                private boolean hasPhoneRisk;
                private boolean hasPremiumFlag;
                private boolean hasPremiumInfo;
                private boolean hasPrice;
                private boolean hasPriceText;
                private boolean hasRecommendDish;
                private boolean hasShopHours;
                private boolean hasShowInfo;
                private boolean hasSpecialService;
                private boolean hasSpecialTag;
                private boolean hasStatusLabel;
                private boolean hasTag;
                private boolean hasTradeTag;
                private boolean hasUpperleftcorner;
                private boolean hasValidate;
                private boolean hasVsContent;
                private boolean hasWapBookable;
                private boolean hasWiseFullroom;
                private boolean hasWiseHourlyBookable;
                private PremiumInfo premiumInfo_ = null;
                private GrouponInfo grouponInfo_ = null;
                private OrilInfo orilInfo_ = null;
                private BookInfo bookInfo_ = null;
                private List<Activity> activity_ = Collections.emptyList();
                private List<String> flag_ = Collections.emptyList();
                private String overallRating_ = "";
                private String priceText_ = "";
                private String tag_ = "";
                private String image_ = "";
                private String showInfo_ = "";
                private int premiumFlag_ = 0;
                private int discountTotal_ = 0;
                private int grouponTotal_ = 0;
                private String commentNum_ = "";
                private String movieFlag_ = "";
                private int movieFilmCount_ = 0;
                private int grouponFlag_ = 0;
                private String wapBookable_ = "";
                private String price_ = "";
                private String wiseFullroom_ = "";
                private String discount_ = "";
                private String grade_ = "";
                private String guide_ = "";
                private String specialService_ = "";
                private String flagOnLeft_ = "";
                private List<Impression> impression_ = Collections.emptyList();
                private Meishipaihao meishipaihao_ = null;
                private String tradeTag_ = "";
                private Marketbiz marketbiz_ = null;
                private String validate_ = "";
                private String wiseHourlyBookable_ = "";
                private String disText_ = "";
                private LbcBusinessVip lbcBusinessVip_ = null;
                private RecommendDish recommendDish_ = null;
                private BusinessService businessService_ = null;
                private String statusLabel_ = "";
                private Upperleftcorner upperleftcorner_ = null;
                private String displayInfoRedu_ = "";
                private DisplayInfoCommentLabel displayInfoCommentLabel_ = null;
                private Mbc mbc_ = null;
                private String aoi_ = "";
                private String specialTag_ = "";
                private String originPriceText_ = "";
                private List<HotelService> hotelService_ = Collections.emptyList();
                private Allcardextension allcardextension_ = null;
                private String shopHours_ = "";
                private String vsContent_ = "";
                private PhoneDetail phoneDetail_ = null;
                private PhoneRisk phoneRisk_ = null;
                private String newBusinessTime_ = "";
                private String miniprogram_ = "";
                private MnpKeyInfo mnpKeyInfo_ = null;
                private BlinkBuilding blinkBuilding_ = null;
                private ChejiNeed chejiNeed_ = null;
                private int cachedSize = -1;

                public static final class Activity extends f {
                    public static final int ACTIVITY_PRICE_FIELD_NUMBER = 9;
                    public static final int BG_COLOR_FIELD_NUMBER = 4;
                    public static final int COLOR_FIELD_NUMBER = 3;
                    public static final int DESC_FIELD_NUMBER = 5;
                    public static final int HREF_FIELD_NUMBER = 6;
                    public static final int IMG_URL_FIELD_NUMBER = 7;
                    public static final int LEVEL_FIELD_NUMBER = 1;
                    public static final int ORIGIN_PRICE_FIELD_NUMBER = 8;
                    public static final int TITLE_FIELD_NUMBER = 2;
                    private boolean hasActivityPrice;
                    private boolean hasBgColor;
                    private boolean hasColor;
                    private boolean hasDesc;
                    private boolean hasHref;
                    private boolean hasImgUrl;
                    private boolean hasLevel;
                    private boolean hasOriginPrice;
                    private boolean hasTitle;
                    private String level_ = "";
                    private String title_ = "";
                    private String color_ = "";
                    private String bgColor_ = "";
                    private String desc_ = "";
                    private String href_ = "";
                    private String imgUrl_ = "";
                    private String originPrice_ = "";
                    private String activityPrice_ = "";
                    private int cachedSize = -1;

                    public static Activity parseFrom(b bVar) throws IOException {
                        return new Activity().mergeFrom(bVar);
                    }

                    public final Activity clear() {
                        clearLevel();
                        clearTitle();
                        clearColor();
                        clearBgColor();
                        clearDesc();
                        clearHref();
                        clearImgUrl();
                        clearOriginPrice();
                        clearActivityPrice();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Activity clearActivityPrice() {
                        this.hasActivityPrice = false;
                        this.activityPrice_ = "";
                        return this;
                    }

                    public Activity clearBgColor() {
                        this.hasBgColor = false;
                        this.bgColor_ = "";
                        return this;
                    }

                    public Activity clearColor() {
                        this.hasColor = false;
                        this.color_ = "";
                        return this;
                    }

                    public Activity clearDesc() {
                        this.hasDesc = false;
                        this.desc_ = "";
                        return this;
                    }

                    public Activity clearHref() {
                        this.hasHref = false;
                        this.href_ = "";
                        return this;
                    }

                    public Activity clearImgUrl() {
                        this.hasImgUrl = false;
                        this.imgUrl_ = "";
                        return this;
                    }

                    public Activity clearLevel() {
                        this.hasLevel = false;
                        this.level_ = "";
                        return this;
                    }

                    public Activity clearOriginPrice() {
                        this.hasOriginPrice = false;
                        this.originPrice_ = "";
                        return this;
                    }

                    public Activity clearTitle() {
                        this.hasTitle = false;
                        this.title_ = "";
                        return this;
                    }

                    public String getActivityPrice() {
                        return this.activityPrice_;
                    }

                    public String getBgColor() {
                        return this.bgColor_;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getColor() {
                        return this.color_;
                    }

                    public String getDesc() {
                        return this.desc_;
                    }

                    public String getHref() {
                        return this.href_;
                    }

                    public String getImgUrl() {
                        return this.imgUrl_;
                    }

                    public String getLevel() {
                        return this.level_;
                    }

                    public String getOriginPrice() {
                        return this.originPrice_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasLevel() ? d.l(1, getLevel()) : 0;
                        if (hasTitle()) {
                            iL += d.l(2, getTitle());
                        }
                        if (hasColor()) {
                            iL += d.l(3, getColor());
                        }
                        if (hasBgColor()) {
                            iL += d.l(4, getBgColor());
                        }
                        if (hasDesc()) {
                            iL += d.l(5, getDesc());
                        }
                        if (hasHref()) {
                            iL += d.l(6, getHref());
                        }
                        if (hasImgUrl()) {
                            iL += d.l(7, getImgUrl());
                        }
                        if (hasOriginPrice()) {
                            iL += d.l(8, getOriginPrice());
                        }
                        if (hasActivityPrice()) {
                            iL += d.l(9, getActivityPrice());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public String getTitle() {
                        return this.title_;
                    }

                    public boolean hasActivityPrice() {
                        return this.hasActivityPrice;
                    }

                    public boolean hasBgColor() {
                        return this.hasBgColor;
                    }

                    public boolean hasColor() {
                        return this.hasColor;
                    }

                    public boolean hasDesc() {
                        return this.hasDesc;
                    }

                    public boolean hasHref() {
                        return this.hasHref;
                    }

                    public boolean hasImgUrl() {
                        return this.hasImgUrl;
                    }

                    public boolean hasLevel() {
                        return this.hasLevel;
                    }

                    public boolean hasOriginPrice() {
                        return this.hasOriginPrice;
                    }

                    public boolean hasTitle() {
                        return this.hasTitle;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Activity setActivityPrice(String str) {
                        this.hasActivityPrice = true;
                        this.activityPrice_ = str;
                        return this;
                    }

                    public Activity setBgColor(String str) {
                        this.hasBgColor = true;
                        this.bgColor_ = str;
                        return this;
                    }

                    public Activity setColor(String str) {
                        this.hasColor = true;
                        this.color_ = str;
                        return this;
                    }

                    public Activity setDesc(String str) {
                        this.hasDesc = true;
                        this.desc_ = str;
                        return this;
                    }

                    public Activity setHref(String str) {
                        this.hasHref = true;
                        this.href_ = str;
                        return this;
                    }

                    public Activity setImgUrl(String str) {
                        this.hasImgUrl = true;
                        this.imgUrl_ = str;
                        return this;
                    }

                    public Activity setLevel(String str) {
                        this.hasLevel = true;
                        this.level_ = str;
                        return this;
                    }

                    public Activity setOriginPrice(String str) {
                        this.hasOriginPrice = true;
                        this.originPrice_ = str;
                        return this;
                    }

                    public Activity setTitle(String str) {
                        this.hasTitle = true;
                        this.title_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasLevel()) {
                            dVar.A(1, getLevel());
                        }
                        if (hasTitle()) {
                            dVar.A(2, getTitle());
                        }
                        if (hasColor()) {
                            dVar.A(3, getColor());
                        }
                        if (hasBgColor()) {
                            dVar.A(4, getBgColor());
                        }
                        if (hasDesc()) {
                            dVar.A(5, getDesc());
                        }
                        if (hasHref()) {
                            dVar.A(6, getHref());
                        }
                        if (hasImgUrl()) {
                            dVar.A(7, getImgUrl());
                        }
                        if (hasOriginPrice()) {
                            dVar.A(8, getOriginPrice());
                        }
                        if (hasActivityPrice()) {
                            dVar.A(9, getActivityPrice());
                        }
                    }

                    public static Activity parseFrom(byte[] bArr) throws e {
                        return (Activity) new Activity().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Activity mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setLevel(bVar.n());
                            } else if (iO == 18) {
                                setTitle(bVar.n());
                            } else if (iO == 26) {
                                setColor(bVar.n());
                            } else if (iO == 34) {
                                setBgColor(bVar.n());
                            } else if (iO == 42) {
                                setDesc(bVar.n());
                            } else if (iO == 50) {
                                setHref(bVar.n());
                            } else if (iO == 58) {
                                setImgUrl(bVar.n());
                            } else if (iO == 66) {
                                setOriginPrice(bVar.n());
                            } else if (iO == 74) {
                                setActivityPrice(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class Allcardextension extends f {
                    public static final int IMAGE_URL_FIELD_NUMBER = 1;
                    public static final int LANDING_URL_FIELD_NUMBER = 2;
                    private boolean hasImageUrl;
                    private boolean hasLandingUrl;
                    private String imageUrl_ = "";
                    private String landingUrl_ = "";
                    private int cachedSize = -1;

                    public static Allcardextension parseFrom(b bVar) throws IOException {
                        return new Allcardextension().mergeFrom(bVar);
                    }

                    public final Allcardextension clear() {
                        clearImageUrl();
                        clearLandingUrl();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Allcardextension clearImageUrl() {
                        this.hasImageUrl = false;
                        this.imageUrl_ = "";
                        return this;
                    }

                    public Allcardextension clearLandingUrl() {
                        this.hasLandingUrl = false;
                        this.landingUrl_ = "";
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getImageUrl() {
                        return this.imageUrl_;
                    }

                    public String getLandingUrl() {
                        return this.landingUrl_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasImageUrl() ? d.l(1, getImageUrl()) : 0;
                        if (hasLandingUrl()) {
                            iL += d.l(2, getLandingUrl());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public boolean hasImageUrl() {
                        return this.hasImageUrl;
                    }

                    public boolean hasLandingUrl() {
                        return this.hasLandingUrl;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Allcardextension setImageUrl(String str) {
                        this.hasImageUrl = true;
                        this.imageUrl_ = str;
                        return this;
                    }

                    public Allcardextension setLandingUrl(String str) {
                        this.hasLandingUrl = true;
                        this.landingUrl_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasImageUrl()) {
                            dVar.A(1, getImageUrl());
                        }
                        if (hasLandingUrl()) {
                            dVar.A(2, getLandingUrl());
                        }
                    }

                    public static Allcardextension parseFrom(byte[] bArr) throws e {
                        return (Allcardextension) new Allcardextension().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Allcardextension mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setImageUrl(bVar.n());
                            } else if (iO == 18) {
                                setLandingUrl(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class BlinkBuilding extends f {
                    public static final int ANGLE_FIELD_NUMBER = 1;
                    public static final int CENTER_LAT_FIELD_NUMBER = 3;
                    public static final int CENTER_LNG_FIELD_NUMBER = 2;
                    public static final int LEVEL_FIELD_NUMBER = 6;
                    public static final int NEED_PLAY_FIELD_NUMBER = 4;
                    public static final int VIDEO_TYPE_FIELD_NUMBER = 5;
                    private boolean hasAngle;
                    private boolean hasCenterLat;
                    private boolean hasCenterLng;
                    private boolean hasLevel;
                    private boolean hasNeedPlay;
                    private boolean hasVideoType;
                    private int angle_ = 0;
                    private double centerLng_ = 0.0d;
                    private double centerLat_ = 0.0d;
                    private int needPlay_ = 0;
                    private int videoType_ = 0;
                    private float level_ = Property.DEFAULT_FLOAT_VALUE;
                    private int cachedSize = -1;

                    public static BlinkBuilding parseFrom(b bVar) throws IOException {
                        return new BlinkBuilding().mergeFrom(bVar);
                    }

                    public final BlinkBuilding clear() {
                        clearAngle();
                        clearCenterLng();
                        clearCenterLat();
                        clearNeedPlay();
                        clearVideoType();
                        clearLevel();
                        this.cachedSize = -1;
                        return this;
                    }

                    public BlinkBuilding clearAngle() {
                        this.hasAngle = false;
                        this.angle_ = 0;
                        return this;
                    }

                    public BlinkBuilding clearCenterLat() {
                        this.hasCenterLat = false;
                        this.centerLat_ = 0.0d;
                        return this;
                    }

                    public BlinkBuilding clearCenterLng() {
                        this.hasCenterLng = false;
                        this.centerLng_ = 0.0d;
                        return this;
                    }

                    public BlinkBuilding clearLevel() {
                        this.hasLevel = false;
                        this.level_ = Property.DEFAULT_FLOAT_VALUE;
                        return this;
                    }

                    public BlinkBuilding clearNeedPlay() {
                        this.hasNeedPlay = false;
                        this.needPlay_ = 0;
                        return this;
                    }

                    public BlinkBuilding clearVideoType() {
                        this.hasVideoType = false;
                        this.videoType_ = 0;
                        return this;
                    }

                    public int getAngle() {
                        return this.angle_;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public double getCenterLat() {
                        return this.centerLat_;
                    }

                    public double getCenterLng() {
                        return this.centerLng_;
                    }

                    public float getLevel() {
                        return this.level_;
                    }

                    public int getNeedPlay() {
                        return this.needPlay_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasAngle() ? d.e(1, getAngle()) : 0;
                        if (hasCenterLng()) {
                            getCenterLng();
                            iE += d.d(2);
                        }
                        if (hasCenterLat()) {
                            getCenterLat();
                            iE += d.d(3);
                        }
                        if (hasNeedPlay()) {
                            iE += d.e(4, getNeedPlay());
                        }
                        if (hasVideoType()) {
                            iE += d.e(5, getVideoType());
                        }
                        if (hasLevel()) {
                            getLevel();
                            iE += d.n(6) + 4;
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public int getVideoType() {
                        return this.videoType_;
                    }

                    public boolean hasAngle() {
                        return this.hasAngle;
                    }

                    public boolean hasCenterLat() {
                        return this.hasCenterLat;
                    }

                    public boolean hasCenterLng() {
                        return this.hasCenterLng;
                    }

                    public boolean hasLevel() {
                        return this.hasLevel;
                    }

                    public boolean hasNeedPlay() {
                        return this.hasNeedPlay;
                    }

                    public boolean hasVideoType() {
                        return this.hasVideoType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public BlinkBuilding setAngle(int i4) {
                        this.hasAngle = true;
                        this.angle_ = i4;
                        return this;
                    }

                    public BlinkBuilding setCenterLat(double d4) {
                        this.hasCenterLat = true;
                        this.centerLat_ = d4;
                        return this;
                    }

                    public BlinkBuilding setCenterLng(double d4) {
                        this.hasCenterLng = true;
                        this.centerLng_ = d4;
                        return this;
                    }

                    public BlinkBuilding setLevel(float f4) {
                        this.hasLevel = true;
                        this.level_ = f4;
                        return this;
                    }

                    public BlinkBuilding setNeedPlay(int i4) {
                        this.hasNeedPlay = true;
                        this.needPlay_ = i4;
                        return this;
                    }

                    public BlinkBuilding setVideoType(int i4) {
                        this.hasVideoType = true;
                        this.videoType_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasAngle()) {
                            dVar.s(1, getAngle());
                        }
                        if (hasCenterLng()) {
                            dVar.r(2, getCenterLng());
                        }
                        if (hasCenterLat()) {
                            dVar.r(3, getCenterLat());
                        }
                        if (hasNeedPlay()) {
                            dVar.s(4, getNeedPlay());
                        }
                        if (hasVideoType()) {
                            dVar.s(5, getVideoType());
                        }
                        if (hasLevel()) {
                            float level = getLevel();
                            dVar.B(6, 5);
                            int iFloatToIntBits = Float.floatToIntBits(level);
                            dVar.v(iFloatToIntBits & 255);
                            dVar.v((iFloatToIntBits >> 8) & 255);
                            dVar.v((iFloatToIntBits >> 16) & 255);
                            dVar.v((iFloatToIntBits >> 24) & 255);
                        }
                    }

                    public static BlinkBuilding parseFrom(byte[] bArr) throws e {
                        return (BlinkBuilding) new BlinkBuilding().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public BlinkBuilding mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setAngle(bVar.k());
                            } else if (iO == 17) {
                                setCenterLng(bVar.c());
                            } else if (iO == 25) {
                                setCenterLat(bVar.c());
                            } else if (iO == 32) {
                                setNeedPlay(bVar.k());
                            } else if (iO == 40) {
                                setVideoType(bVar.k());
                            } else if (iO == 53) {
                                setLevel(Float.intBitsToFloat(bVar.i()));
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class BookInfo extends f {
                    public static final int COMS_FIELD_NUMBER = 3;
                    public static final int TEL_FIELD_NUMBER = 1;
                    public static final int WEB_FIELD_NUMBER = 2;
                    private boolean hasComs;
                    private boolean hasTel;
                    private boolean hasWeb;
                    private Tel tel_ = null;
                    private Web web_ = null;
                    private Coms coms_ = null;
                    private int cachedSize = -1;

                    public static final class Coms extends f {
                        public static final int CONTENT_FIELD_NUMBER = 1;
                        public static final int TITLE_FIELD_NUMBER = 2;
                        public static final int TYPE_FIELD_NUMBER = 3;
                        private boolean hasContent;
                        private boolean hasTitle;
                        private boolean hasType;
                        private String content_ = "";
                        private String title_ = "";
                        private String type_ = "";
                        private int cachedSize = -1;

                        public static Coms parseFrom(b bVar) throws IOException {
                            return new Coms().mergeFrom(bVar);
                        }

                        public final Coms clear() {
                            clearContent();
                            clearTitle();
                            clearType();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Coms clearContent() {
                            this.hasContent = false;
                            this.content_ = "";
                            return this;
                        }

                        public Coms clearTitle() {
                            this.hasTitle = false;
                            this.title_ = "";
                            return this;
                        }

                        public Coms clearType() {
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

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iL = hasContent() ? d.l(1, getContent()) : 0;
                            if (hasTitle()) {
                                iL += d.l(2, getTitle());
                            }
                            if (hasType()) {
                                iL += d.l(3, getType());
                            }
                            this.cachedSize = iL;
                            return iL;
                        }

                        public String getTitle() {
                            return this.title_;
                        }

                        public String getType() {
                            return this.type_;
                        }

                        public boolean hasContent() {
                            return this.hasContent;
                        }

                        public boolean hasTitle() {
                            return this.hasTitle;
                        }

                        public boolean hasType() {
                            return this.hasType;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Coms setContent(String str) {
                            this.hasContent = true;
                            this.content_ = str;
                            return this;
                        }

                        public Coms setTitle(String str) {
                            this.hasTitle = true;
                            this.title_ = str;
                            return this;
                        }

                        public Coms setType(String str) {
                            this.hasType = true;
                            this.type_ = str;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasContent()) {
                                dVar.A(1, getContent());
                            }
                            if (hasTitle()) {
                                dVar.A(2, getTitle());
                            }
                            if (hasType()) {
                                dVar.A(3, getType());
                            }
                        }

                        public static Coms parseFrom(byte[] bArr) throws e {
                            return (Coms) new Coms().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public Coms mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 10) {
                                    setContent(bVar.n());
                                } else if (iO == 18) {
                                    setTitle(bVar.n());
                                } else if (iO == 26) {
                                    setType(bVar.n());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static final class Tel extends f {
                        public static final int CONTENT_FIELD_NUMBER = 2;
                        public static final int TITLE_FIELD_NUMBER = 1;
                        private boolean hasContent;
                        private boolean hasTitle;
                        private String title_ = "";
                        private String content_ = "";
                        private int cachedSize = -1;

                        public static Tel parseFrom(b bVar) throws IOException {
                            return new Tel().mergeFrom(bVar);
                        }

                        public final Tel clear() {
                            clearTitle();
                            clearContent();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Tel clearContent() {
                            this.hasContent = false;
                            this.content_ = "";
                            return this;
                        }

                        public Tel clearTitle() {
                            this.hasTitle = false;
                            this.title_ = "";
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

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iL = hasTitle() ? d.l(1, getTitle()) : 0;
                            if (hasContent()) {
                                iL += d.l(2, getContent());
                            }
                            this.cachedSize = iL;
                            return iL;
                        }

                        public String getTitle() {
                            return this.title_;
                        }

                        public boolean hasContent() {
                            return this.hasContent;
                        }

                        public boolean hasTitle() {
                            return this.hasTitle;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Tel setContent(String str) {
                            this.hasContent = true;
                            this.content_ = str;
                            return this;
                        }

                        public Tel setTitle(String str) {
                            this.hasTitle = true;
                            this.title_ = str;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasTitle()) {
                                dVar.A(1, getTitle());
                            }
                            if (hasContent()) {
                                dVar.A(2, getContent());
                            }
                        }

                        public static Tel parseFrom(byte[] bArr) throws e {
                            return (Tel) new Tel().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public Tel mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 10) {
                                    setTitle(bVar.n());
                                } else if (iO == 18) {
                                    setContent(bVar.n());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static final class Web extends f {
                        public static final int CONTENT_FIELD_NUMBER = 2;
                        public static final int TITLE_FIELD_NUMBER = 1;
                        private boolean hasContent;
                        private boolean hasTitle;
                        private String title_ = "";
                        private String content_ = "";
                        private int cachedSize = -1;

                        public static Web parseFrom(b bVar) throws IOException {
                            return new Web().mergeFrom(bVar);
                        }

                        public final Web clear() {
                            clearTitle();
                            clearContent();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Web clearContent() {
                            this.hasContent = false;
                            this.content_ = "";
                            return this;
                        }

                        public Web clearTitle() {
                            this.hasTitle = false;
                            this.title_ = "";
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

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iL = hasTitle() ? d.l(1, getTitle()) : 0;
                            if (hasContent()) {
                                iL += d.l(2, getContent());
                            }
                            this.cachedSize = iL;
                            return iL;
                        }

                        public String getTitle() {
                            return this.title_;
                        }

                        public boolean hasContent() {
                            return this.hasContent;
                        }

                        public boolean hasTitle() {
                            return this.hasTitle;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Web setContent(String str) {
                            this.hasContent = true;
                            this.content_ = str;
                            return this;
                        }

                        public Web setTitle(String str) {
                            this.hasTitle = true;
                            this.title_ = str;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasTitle()) {
                                dVar.A(1, getTitle());
                            }
                            if (hasContent()) {
                                dVar.A(2, getContent());
                            }
                        }

                        public static Web parseFrom(byte[] bArr) throws e {
                            return (Web) new Web().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public Web mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 10) {
                                    setTitle(bVar.n());
                                } else if (iO == 18) {
                                    setContent(bVar.n());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static BookInfo parseFrom(b bVar) throws IOException {
                        return new BookInfo().mergeFrom(bVar);
                    }

                    public final BookInfo clear() {
                        clearTel();
                        clearWeb();
                        clearComs();
                        this.cachedSize = -1;
                        return this;
                    }

                    public BookInfo clearComs() {
                        this.hasComs = false;
                        this.coms_ = null;
                        return this;
                    }

                    public BookInfo clearTel() {
                        this.hasTel = false;
                        this.tel_ = null;
                        return this;
                    }

                    public BookInfo clearWeb() {
                        this.hasWeb = false;
                        this.web_ = null;
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public Coms getComs() {
                        return this.coms_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iH = hasTel() ? d.h(1, getTel()) : 0;
                        if (hasWeb()) {
                            iH += d.h(2, getWeb());
                        }
                        if (hasComs()) {
                            iH += d.h(3, getComs());
                        }
                        this.cachedSize = iH;
                        return iH;
                    }

                    public Tel getTel() {
                        return this.tel_;
                    }

                    public Web getWeb() {
                        return this.web_;
                    }

                    public boolean hasComs() {
                        return this.hasComs;
                    }

                    public boolean hasTel() {
                        return this.hasTel;
                    }

                    public boolean hasWeb() {
                        return this.hasWeb;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public BookInfo setComs(Coms coms) {
                        if (coms == null) {
                            return clearComs();
                        }
                        this.hasComs = true;
                        this.coms_ = coms;
                        return this;
                    }

                    public BookInfo setTel(Tel tel) {
                        if (tel == null) {
                            return clearTel();
                        }
                        this.hasTel = true;
                        this.tel_ = tel;
                        return this;
                    }

                    public BookInfo setWeb(Web web) {
                        if (web == null) {
                            return clearWeb();
                        }
                        this.hasWeb = true;
                        this.web_ = web;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasTel()) {
                            dVar.u(1, getTel());
                        }
                        if (hasWeb()) {
                            dVar.u(2, getWeb());
                        }
                        if (hasComs()) {
                            dVar.u(3, getComs());
                        }
                    }

                    public static BookInfo parseFrom(byte[] bArr) throws e {
                        return (BookInfo) new BookInfo().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public BookInfo mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                Tel tel = new Tel();
                                bVar.f(tel);
                                setTel(tel);
                            } else if (iO == 18) {
                                Web web = new Web();
                                bVar.f(web);
                                setWeb(web);
                            } else if (iO == 26) {
                                Coms coms = new Coms();
                                bVar.f(coms);
                                setComs(coms);
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class BusinessService extends f {
                    public static final int NUOMI_FIELD_NUMBER = 1;
                    private boolean hasNuomi;
                    private Nuomi nuomi_ = null;
                    private int cachedSize = -1;

                    public static final class Nuomi extends f {
                        public static final int DAODIANFU_STATUS_FIELD_NUMBER = 1;
                        private boolean hasDaodianfuStatus;
                        private int daodianfuStatus_ = 0;
                        private int cachedSize = -1;

                        public static Nuomi parseFrom(b bVar) throws IOException {
                            return new Nuomi().mergeFrom(bVar);
                        }

                        public final Nuomi clear() {
                            clearDaodianfuStatus();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Nuomi clearDaodianfuStatus() {
                            this.hasDaodianfuStatus = false;
                            this.daodianfuStatus_ = 0;
                            return this;
                        }

                        @Override // L1.f
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public int getDaodianfuStatus() {
                            return this.daodianfuStatus_;
                        }

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iE = hasDaodianfuStatus() ? d.e(1, getDaodianfuStatus()) : 0;
                            this.cachedSize = iE;
                            return iE;
                        }

                        public boolean hasDaodianfuStatus() {
                            return this.hasDaodianfuStatus;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Nuomi setDaodianfuStatus(int i4) {
                            this.hasDaodianfuStatus = true;
                            this.daodianfuStatus_ = i4;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasDaodianfuStatus()) {
                                dVar.s(1, getDaodianfuStatus());
                            }
                        }

                        public static Nuomi parseFrom(byte[] bArr) throws e {
                            return (Nuomi) new Nuomi().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public Nuomi mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 8) {
                                    setDaodianfuStatus(bVar.k());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static BusinessService parseFrom(b bVar) throws IOException {
                        return new BusinessService().mergeFrom(bVar);
                    }

                    public final BusinessService clear() {
                        clearNuomi();
                        this.cachedSize = -1;
                        return this;
                    }

                    public BusinessService clearNuomi() {
                        this.hasNuomi = false;
                        this.nuomi_ = null;
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public Nuomi getNuomi() {
                        return this.nuomi_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iH = hasNuomi() ? d.h(1, getNuomi()) : 0;
                        this.cachedSize = iH;
                        return iH;
                    }

                    public boolean hasNuomi() {
                        return this.hasNuomi;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public BusinessService setNuomi(Nuomi nuomi) {
                        if (nuomi == null) {
                            return clearNuomi();
                        }
                        this.hasNuomi = true;
                        this.nuomi_ = nuomi;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasNuomi()) {
                            dVar.u(1, getNuomi());
                        }
                    }

                    public static BusinessService parseFrom(byte[] bArr) throws e {
                        return (BusinessService) new BusinessService().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public BusinessService mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                Nuomi nuomi = new Nuomi();
                                bVar.f(nuomi);
                                setNuomi(nuomi);
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class ChejiNeed extends f {
                    public static final int CAR_INFO_FIELD_NUMBER = 1;
                    private boolean hasCarInfo;
                    private CarInfo carInfo_ = null;
                    private int cachedSize = -1;

                    public static final class CarInfo extends f {
                        public static final int PARK_RATE_FIELD_NUMBER = 1;
                        public static final int PARK_SPACE_FIELD_NUMBER = 2;
                        private boolean hasParkRate;
                        private boolean hasParkSpace;
                        private String parkRate_ = "";
                        private String parkSpace_ = "";
                        private int cachedSize = -1;

                        public static CarInfo parseFrom(b bVar) throws IOException {
                            return new CarInfo().mergeFrom(bVar);
                        }

                        public final CarInfo clear() {
                            clearParkRate();
                            clearParkSpace();
                            this.cachedSize = -1;
                            return this;
                        }

                        public CarInfo clearParkRate() {
                            this.hasParkRate = false;
                            this.parkRate_ = "";
                            return this;
                        }

                        public CarInfo clearParkSpace() {
                            this.hasParkSpace = false;
                            this.parkSpace_ = "";
                            return this;
                        }

                        @Override // L1.f
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public String getParkRate() {
                            return this.parkRate_;
                        }

                        public String getParkSpace() {
                            return this.parkSpace_;
                        }

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iL = hasParkRate() ? d.l(1, getParkRate()) : 0;
                            if (hasParkSpace()) {
                                iL += d.l(2, getParkSpace());
                            }
                            this.cachedSize = iL;
                            return iL;
                        }

                        public boolean hasParkRate() {
                            return this.hasParkRate;
                        }

                        public boolean hasParkSpace() {
                            return this.hasParkSpace;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public CarInfo setParkRate(String str) {
                            this.hasParkRate = true;
                            this.parkRate_ = str;
                            return this;
                        }

                        public CarInfo setParkSpace(String str) {
                            this.hasParkSpace = true;
                            this.parkSpace_ = str;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasParkRate()) {
                                dVar.A(1, getParkRate());
                            }
                            if (hasParkSpace()) {
                                dVar.A(2, getParkSpace());
                            }
                        }

                        public static CarInfo parseFrom(byte[] bArr) throws e {
                            return (CarInfo) new CarInfo().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public CarInfo mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 10) {
                                    setParkRate(bVar.n());
                                } else if (iO == 18) {
                                    setParkSpace(bVar.n());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static ChejiNeed parseFrom(b bVar) throws IOException {
                        return new ChejiNeed().mergeFrom(bVar);
                    }

                    public final ChejiNeed clear() {
                        clearCarInfo();
                        this.cachedSize = -1;
                        return this;
                    }

                    public ChejiNeed clearCarInfo() {
                        this.hasCarInfo = false;
                        this.carInfo_ = null;
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public CarInfo getCarInfo() {
                        return this.carInfo_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iH = hasCarInfo() ? d.h(1, getCarInfo()) : 0;
                        this.cachedSize = iH;
                        return iH;
                    }

                    public boolean hasCarInfo() {
                        return this.hasCarInfo;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public ChejiNeed setCarInfo(CarInfo carInfo) {
                        if (carInfo == null) {
                            return clearCarInfo();
                        }
                        this.hasCarInfo = true;
                        this.carInfo_ = carInfo;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasCarInfo()) {
                            dVar.u(1, getCarInfo());
                        }
                    }

                    public static ChejiNeed parseFrom(byte[] bArr) throws e {
                        return (ChejiNeed) new ChejiNeed().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public ChejiNeed mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                CarInfo carInfo = new CarInfo();
                                bVar.f(carInfo);
                                setCarInfo(carInfo);
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class DisplayInfoCommentLabel extends f {
                    public static final int BEAUTY_FIELD_NUMBER = 5;
                    public static final int CATER_FIELD_NUMBER = 3;
                    public static final int COMMON_FIELD_NUMBER = 2;
                    public static final int LIFE_FIELD_NUMBER = 1;
                    public static final int SCOPE_FIELD_NUMBER = 4;
                    private boolean hasBeauty;
                    private boolean hasCater;
                    private boolean hasCommon;
                    private boolean hasLife;
                    private boolean hasScope;
                    private String life_ = "";
                    private String common_ = "";
                    private String cater_ = "";
                    private String scope_ = "";
                    private String beauty_ = "";
                    private int cachedSize = -1;

                    public static DisplayInfoCommentLabel parseFrom(b bVar) throws IOException {
                        return new DisplayInfoCommentLabel().mergeFrom(bVar);
                    }

                    public final DisplayInfoCommentLabel clear() {
                        clearLife();
                        clearCommon();
                        clearCater();
                        clearScope();
                        clearBeauty();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DisplayInfoCommentLabel clearBeauty() {
                        this.hasBeauty = false;
                        this.beauty_ = "";
                        return this;
                    }

                    public DisplayInfoCommentLabel clearCater() {
                        this.hasCater = false;
                        this.cater_ = "";
                        return this;
                    }

                    public DisplayInfoCommentLabel clearCommon() {
                        this.hasCommon = false;
                        this.common_ = "";
                        return this;
                    }

                    public DisplayInfoCommentLabel clearLife() {
                        this.hasLife = false;
                        this.life_ = "";
                        return this;
                    }

                    public DisplayInfoCommentLabel clearScope() {
                        this.hasScope = false;
                        this.scope_ = "";
                        return this;
                    }

                    public String getBeauty() {
                        return this.beauty_;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getCater() {
                        return this.cater_;
                    }

                    public String getCommon() {
                        return this.common_;
                    }

                    public String getLife() {
                        return this.life_;
                    }

                    public String getScope() {
                        return this.scope_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasLife() ? d.l(1, getLife()) : 0;
                        if (hasCommon()) {
                            iL += d.l(2, getCommon());
                        }
                        if (hasCater()) {
                            iL += d.l(3, getCater());
                        }
                        if (hasScope()) {
                            iL += d.l(4, getScope());
                        }
                        if (hasBeauty()) {
                            iL += d.l(5, getBeauty());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public boolean hasBeauty() {
                        return this.hasBeauty;
                    }

                    public boolean hasCater() {
                        return this.hasCater;
                    }

                    public boolean hasCommon() {
                        return this.hasCommon;
                    }

                    public boolean hasLife() {
                        return this.hasLife;
                    }

                    public boolean hasScope() {
                        return this.hasScope;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public DisplayInfoCommentLabel setBeauty(String str) {
                        this.hasBeauty = true;
                        this.beauty_ = str;
                        return this;
                    }

                    public DisplayInfoCommentLabel setCater(String str) {
                        this.hasCater = true;
                        this.cater_ = str;
                        return this;
                    }

                    public DisplayInfoCommentLabel setCommon(String str) {
                        this.hasCommon = true;
                        this.common_ = str;
                        return this;
                    }

                    public DisplayInfoCommentLabel setLife(String str) {
                        this.hasLife = true;
                        this.life_ = str;
                        return this;
                    }

                    public DisplayInfoCommentLabel setScope(String str) {
                        this.hasScope = true;
                        this.scope_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasLife()) {
                            dVar.A(1, getLife());
                        }
                        if (hasCommon()) {
                            dVar.A(2, getCommon());
                        }
                        if (hasCater()) {
                            dVar.A(3, getCater());
                        }
                        if (hasScope()) {
                            dVar.A(4, getScope());
                        }
                        if (hasBeauty()) {
                            dVar.A(5, getBeauty());
                        }
                    }

                    public static DisplayInfoCommentLabel parseFrom(byte[] bArr) throws e {
                        return (DisplayInfoCommentLabel) new DisplayInfoCommentLabel().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public DisplayInfoCommentLabel mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setLife(bVar.n());
                            } else if (iO == 18) {
                                setCommon(bVar.n());
                            } else if (iO == 26) {
                                setCater(bVar.n());
                            } else if (iO == 34) {
                                setScope(bVar.n());
                            } else if (iO == 42) {
                                setBeauty(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class GrouponInfo extends f {
                    public static final int GROUPON_IMAGE_FIELD_NUMBER = 4;
                    public static final int GROUPON_NUM_FIELD_NUMBER = 1;
                    public static final int GROUPON_PRICE_FIELD_NUMBER = 2;
                    public static final int GROUPON_RESERVATION_FIELD_NUMBER = 8;
                    public static final int GROUPON_TITLE_FIELD_NUMBER = 3;
                    public static final int GROUPON_URL_MOBILE_FIELD_NUMBER = 6;
                    public static final int GROUPON_WEBAPP_URL_FIELD_NUMBER = 7;
                    public static final int REGULAR_PRICE_FIELD_NUMBER = 5;
                    private boolean hasGrouponImage;
                    private boolean hasGrouponNum;
                    private boolean hasGrouponPrice;
                    private boolean hasGrouponReservation;
                    private boolean hasGrouponTitle;
                    private boolean hasGrouponUrlMobile;
                    private boolean hasGrouponWebappUrl;
                    private boolean hasRegularPrice;
                    private String grouponNum_ = "";
                    private String grouponPrice_ = "";
                    private String grouponTitle_ = "";
                    private String grouponImage_ = "";
                    private String regularPrice_ = "";
                    private String grouponUrlMobile_ = "";
                    private String grouponWebappUrl_ = "";
                    private String grouponReservation_ = "";
                    private int cachedSize = -1;

                    public static GrouponInfo parseFrom(b bVar) throws IOException {
                        return new GrouponInfo().mergeFrom(bVar);
                    }

                    public final GrouponInfo clear() {
                        clearGrouponNum();
                        clearGrouponPrice();
                        clearGrouponTitle();
                        clearGrouponImage();
                        clearRegularPrice();
                        clearGrouponUrlMobile();
                        clearGrouponWebappUrl();
                        clearGrouponReservation();
                        this.cachedSize = -1;
                        return this;
                    }

                    public GrouponInfo clearGrouponImage() {
                        this.hasGrouponImage = false;
                        this.grouponImage_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponNum() {
                        this.hasGrouponNum = false;
                        this.grouponNum_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponPrice() {
                        this.hasGrouponPrice = false;
                        this.grouponPrice_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponReservation() {
                        this.hasGrouponReservation = false;
                        this.grouponReservation_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponTitle() {
                        this.hasGrouponTitle = false;
                        this.grouponTitle_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponUrlMobile() {
                        this.hasGrouponUrlMobile = false;
                        this.grouponUrlMobile_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponWebappUrl() {
                        this.hasGrouponWebappUrl = false;
                        this.grouponWebappUrl_ = "";
                        return this;
                    }

                    public GrouponInfo clearRegularPrice() {
                        this.hasRegularPrice = false;
                        this.regularPrice_ = "";
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getGrouponImage() {
                        return this.grouponImage_;
                    }

                    public String getGrouponNum() {
                        return this.grouponNum_;
                    }

                    public String getGrouponPrice() {
                        return this.grouponPrice_;
                    }

                    public String getGrouponReservation() {
                        return this.grouponReservation_;
                    }

                    public String getGrouponTitle() {
                        return this.grouponTitle_;
                    }

                    public String getGrouponUrlMobile() {
                        return this.grouponUrlMobile_;
                    }

                    public String getGrouponWebappUrl() {
                        return this.grouponWebappUrl_;
                    }

                    public String getRegularPrice() {
                        return this.regularPrice_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasGrouponNum() ? d.l(1, getGrouponNum()) : 0;
                        if (hasGrouponPrice()) {
                            iL += d.l(2, getGrouponPrice());
                        }
                        if (hasGrouponTitle()) {
                            iL += d.l(3, getGrouponTitle());
                        }
                        if (hasGrouponImage()) {
                            iL += d.l(4, getGrouponImage());
                        }
                        if (hasRegularPrice()) {
                            iL += d.l(5, getRegularPrice());
                        }
                        if (hasGrouponUrlMobile()) {
                            iL += d.l(6, getGrouponUrlMobile());
                        }
                        if (hasGrouponWebappUrl()) {
                            iL += d.l(7, getGrouponWebappUrl());
                        }
                        if (hasGrouponReservation()) {
                            iL += d.l(8, getGrouponReservation());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public boolean hasGrouponImage() {
                        return this.hasGrouponImage;
                    }

                    public boolean hasGrouponNum() {
                        return this.hasGrouponNum;
                    }

                    public boolean hasGrouponPrice() {
                        return this.hasGrouponPrice;
                    }

                    public boolean hasGrouponReservation() {
                        return this.hasGrouponReservation;
                    }

                    public boolean hasGrouponTitle() {
                        return this.hasGrouponTitle;
                    }

                    public boolean hasGrouponUrlMobile() {
                        return this.hasGrouponUrlMobile;
                    }

                    public boolean hasGrouponWebappUrl() {
                        return this.hasGrouponWebappUrl;
                    }

                    public boolean hasRegularPrice() {
                        return this.hasRegularPrice;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public GrouponInfo setGrouponImage(String str) {
                        this.hasGrouponImage = true;
                        this.grouponImage_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponNum(String str) {
                        this.hasGrouponNum = true;
                        this.grouponNum_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponPrice(String str) {
                        this.hasGrouponPrice = true;
                        this.grouponPrice_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponReservation(String str) {
                        this.hasGrouponReservation = true;
                        this.grouponReservation_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponTitle(String str) {
                        this.hasGrouponTitle = true;
                        this.grouponTitle_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponUrlMobile(String str) {
                        this.hasGrouponUrlMobile = true;
                        this.grouponUrlMobile_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponWebappUrl(String str) {
                        this.hasGrouponWebappUrl = true;
                        this.grouponWebappUrl_ = str;
                        return this;
                    }

                    public GrouponInfo setRegularPrice(String str) {
                        this.hasRegularPrice = true;
                        this.regularPrice_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasGrouponNum()) {
                            dVar.A(1, getGrouponNum());
                        }
                        if (hasGrouponPrice()) {
                            dVar.A(2, getGrouponPrice());
                        }
                        if (hasGrouponTitle()) {
                            dVar.A(3, getGrouponTitle());
                        }
                        if (hasGrouponImage()) {
                            dVar.A(4, getGrouponImage());
                        }
                        if (hasRegularPrice()) {
                            dVar.A(5, getRegularPrice());
                        }
                        if (hasGrouponUrlMobile()) {
                            dVar.A(6, getGrouponUrlMobile());
                        }
                        if (hasGrouponWebappUrl()) {
                            dVar.A(7, getGrouponWebappUrl());
                        }
                        if (hasGrouponReservation()) {
                            dVar.A(8, getGrouponReservation());
                        }
                    }

                    public static GrouponInfo parseFrom(byte[] bArr) throws e {
                        return (GrouponInfo) new GrouponInfo().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public GrouponInfo mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setGrouponNum(bVar.n());
                            } else if (iO == 18) {
                                setGrouponPrice(bVar.n());
                            } else if (iO == 26) {
                                setGrouponTitle(bVar.n());
                            } else if (iO == 34) {
                                setGrouponImage(bVar.n());
                            } else if (iO == 42) {
                                setRegularPrice(bVar.n());
                            } else if (iO == 50) {
                                setGrouponUrlMobile(bVar.n());
                            } else if (iO == 58) {
                                setGrouponWebappUrl(bVar.n());
                            } else if (iO == 66) {
                                setGrouponReservation(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class HotelService extends f {
                    public static final int ICON_ID_FIELD_NUMBER = 1;
                    public static final int NAME_FIELD_NUMBER = 2;
                    private boolean hasIconId;
                    private boolean hasName;
                    private String iconId_ = "";
                    private String name_ = "";
                    private int cachedSize = -1;

                    public static HotelService parseFrom(b bVar) throws IOException {
                        return new HotelService().mergeFrom(bVar);
                    }

                    public final HotelService clear() {
                        clearIconId();
                        clearName();
                        this.cachedSize = -1;
                        return this;
                    }

                    public HotelService clearIconId() {
                        this.hasIconId = false;
                        this.iconId_ = "";
                        return this;
                    }

                    public HotelService clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getIconId() {
                        return this.iconId_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasIconId() ? d.l(1, getIconId()) : 0;
                        if (hasName()) {
                            iL += d.l(2, getName());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public boolean hasIconId() {
                        return this.hasIconId;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public HotelService setIconId(String str) {
                        this.hasIconId = true;
                        this.iconId_ = str;
                        return this;
                    }

                    public HotelService setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasIconId()) {
                            dVar.A(1, getIconId());
                        }
                        if (hasName()) {
                            dVar.A(2, getName());
                        }
                    }

                    public static HotelService parseFrom(byte[] bArr) throws e {
                        return (HotelService) new HotelService().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public HotelService mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setIconId(bVar.n());
                            } else if (iO == 18) {
                                setName(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class Impression extends f {
                    public static final int KEYWORD_FIELD_NUMBER = 1;
                    public static final int NUM_FIELD_NUMBER = 2;
                    private boolean hasKeyword;
                    private boolean hasNum;
                    private String keyword_ = "";
                    private int num_ = 0;
                    private int cachedSize = -1;

                    public static Impression parseFrom(b bVar) throws IOException {
                        return new Impression().mergeFrom(bVar);
                    }

                    public final Impression clear() {
                        clearKeyword();
                        clearNum();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Impression clearKeyword() {
                        this.hasKeyword = false;
                        this.keyword_ = "";
                        return this;
                    }

                    public Impression clearNum() {
                        this.hasNum = false;
                        this.num_ = 0;
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getKeyword() {
                        return this.keyword_;
                    }

                    public int getNum() {
                        return this.num_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasKeyword() ? d.l(1, getKeyword()) : 0;
                        if (hasNum()) {
                            iL += d.e(2, getNum());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public boolean hasKeyword() {
                        return this.hasKeyword;
                    }

                    public boolean hasNum() {
                        return this.hasNum;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Impression setKeyword(String str) {
                        this.hasKeyword = true;
                        this.keyword_ = str;
                        return this;
                    }

                    public Impression setNum(int i4) {
                        this.hasNum = true;
                        this.num_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasKeyword()) {
                            dVar.A(1, getKeyword());
                        }
                        if (hasNum()) {
                            dVar.s(2, getNum());
                        }
                    }

                    public static Impression parseFrom(byte[] bArr) throws e {
                        return (Impression) new Impression().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Impression mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setKeyword(bVar.n());
                            } else if (iO == 16) {
                                setNum(bVar.k());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class LbcBusinessVip extends f {
                    public static final int AMOUNT_FIELD_NUMBER = 3;
                    public static final int COMMENT_FIELD_NUMBER = 2;
                    public static final int LISTS_FIELD_NUMBER = 4;
                    public static final int TYPE_FIELD_NUMBER = 1;
                    private boolean hasAmount;
                    private boolean hasComment;
                    private boolean hasLists;
                    private boolean hasType;
                    private int type_ = 0;
                    private String comment_ = "";
                    private String amount_ = "";
                    private String lists_ = "";
                    private int cachedSize = -1;

                    public static LbcBusinessVip parseFrom(b bVar) throws IOException {
                        return new LbcBusinessVip().mergeFrom(bVar);
                    }

                    public final LbcBusinessVip clear() {
                        clearType();
                        clearComment();
                        clearAmount();
                        clearLists();
                        this.cachedSize = -1;
                        return this;
                    }

                    public LbcBusinessVip clearAmount() {
                        this.hasAmount = false;
                        this.amount_ = "";
                        return this;
                    }

                    public LbcBusinessVip clearComment() {
                        this.hasComment = false;
                        this.comment_ = "";
                        return this;
                    }

                    public LbcBusinessVip clearLists() {
                        this.hasLists = false;
                        this.lists_ = "";
                        return this;
                    }

                    public LbcBusinessVip clearType() {
                        this.hasType = false;
                        this.type_ = 0;
                        return this;
                    }

                    public String getAmount() {
                        return this.amount_;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getComment() {
                        return this.comment_;
                    }

                    public String getLists() {
                        return this.lists_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasType() ? d.e(1, getType()) : 0;
                        if (hasComment()) {
                            iE += d.l(2, getComment());
                        }
                        if (hasAmount()) {
                            iE += d.l(3, getAmount());
                        }
                        if (hasLists()) {
                            iE += d.l(4, getLists());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasAmount() {
                        return this.hasAmount;
                    }

                    public boolean hasComment() {
                        return this.hasComment;
                    }

                    public boolean hasLists() {
                        return this.hasLists;
                    }

                    public boolean hasType() {
                        return this.hasType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public LbcBusinessVip setAmount(String str) {
                        this.hasAmount = true;
                        this.amount_ = str;
                        return this;
                    }

                    public LbcBusinessVip setComment(String str) {
                        this.hasComment = true;
                        this.comment_ = str;
                        return this;
                    }

                    public LbcBusinessVip setLists(String str) {
                        this.hasLists = true;
                        this.lists_ = str;
                        return this;
                    }

                    public LbcBusinessVip setType(int i4) {
                        this.hasType = true;
                        this.type_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasType()) {
                            dVar.s(1, getType());
                        }
                        if (hasComment()) {
                            dVar.A(2, getComment());
                        }
                        if (hasAmount()) {
                            dVar.A(3, getAmount());
                        }
                        if (hasLists()) {
                            dVar.A(4, getLists());
                        }
                    }

                    public static LbcBusinessVip parseFrom(byte[] bArr) throws e {
                        return (LbcBusinessVip) new LbcBusinessVip().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public LbcBusinessVip mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setType(bVar.k());
                            } else if (iO == 18) {
                                setComment(bVar.n());
                            } else if (iO == 26) {
                                setAmount(bVar.n());
                            } else if (iO == 34) {
                                setLists(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class Marketbiz extends f {
                    public static final int ACT_FIELD_NUMBER = 3;
                    public static final int CONTENT_FIELD_NUMBER = 2;
                    public static final int DTYPE_FIELD_NUMBER = 5;
                    public static final int SRCNAME_FIELD_NUMBER = 1;
                    public static final int STYPE_FIELD_NUMBER = 4;
                    private boolean hasAct;
                    private boolean hasContent;
                    private boolean hasDtype;
                    private boolean hasSrcname;
                    private boolean hasStype;
                    private String srcname_ = "";
                    private String content_ = "";
                    private int act_ = 0;
                    private int stype_ = 0;
                    private int dtype_ = 0;
                    private int cachedSize = -1;

                    public static Marketbiz parseFrom(b bVar) throws IOException {
                        return new Marketbiz().mergeFrom(bVar);
                    }

                    public final Marketbiz clear() {
                        clearSrcname();
                        clearContent();
                        clearAct();
                        clearStype();
                        clearDtype();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Marketbiz clearAct() {
                        this.hasAct = false;
                        this.act_ = 0;
                        return this;
                    }

                    public Marketbiz clearContent() {
                        this.hasContent = false;
                        this.content_ = "";
                        return this;
                    }

                    public Marketbiz clearDtype() {
                        this.hasDtype = false;
                        this.dtype_ = 0;
                        return this;
                    }

                    public Marketbiz clearSrcname() {
                        this.hasSrcname = false;
                        this.srcname_ = "";
                        return this;
                    }

                    public Marketbiz clearStype() {
                        this.hasStype = false;
                        this.stype_ = 0;
                        return this;
                    }

                    public int getAct() {
                        return this.act_;
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

                    public int getDtype() {
                        return this.dtype_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasSrcname() ? d.l(1, getSrcname()) : 0;
                        if (hasContent()) {
                            iL += d.l(2, getContent());
                        }
                        if (hasAct()) {
                            iL += d.e(3, getAct());
                        }
                        if (hasStype()) {
                            iL += d.e(4, getStype());
                        }
                        if (hasDtype()) {
                            iL += d.e(5, getDtype());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public String getSrcname() {
                        return this.srcname_;
                    }

                    public int getStype() {
                        return this.stype_;
                    }

                    public boolean hasAct() {
                        return this.hasAct;
                    }

                    public boolean hasContent() {
                        return this.hasContent;
                    }

                    public boolean hasDtype() {
                        return this.hasDtype;
                    }

                    public boolean hasSrcname() {
                        return this.hasSrcname;
                    }

                    public boolean hasStype() {
                        return this.hasStype;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Marketbiz setAct(int i4) {
                        this.hasAct = true;
                        this.act_ = i4;
                        return this;
                    }

                    public Marketbiz setContent(String str) {
                        this.hasContent = true;
                        this.content_ = str;
                        return this;
                    }

                    public Marketbiz setDtype(int i4) {
                        this.hasDtype = true;
                        this.dtype_ = i4;
                        return this;
                    }

                    public Marketbiz setSrcname(String str) {
                        this.hasSrcname = true;
                        this.srcname_ = str;
                        return this;
                    }

                    public Marketbiz setStype(int i4) {
                        this.hasStype = true;
                        this.stype_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasSrcname()) {
                            dVar.A(1, getSrcname());
                        }
                        if (hasContent()) {
                            dVar.A(2, getContent());
                        }
                        if (hasAct()) {
                            dVar.s(3, getAct());
                        }
                        if (hasStype()) {
                            dVar.s(4, getStype());
                        }
                        if (hasDtype()) {
                            dVar.s(5, getDtype());
                        }
                    }

                    public static Marketbiz parseFrom(byte[] bArr) throws e {
                        return (Marketbiz) new Marketbiz().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Marketbiz mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setSrcname(bVar.n());
                            } else if (iO == 18) {
                                setContent(bVar.n());
                            } else if (iO == 24) {
                                setAct(bVar.k());
                            } else if (iO == 32) {
                                setStype(bVar.k());
                            } else if (iO == 40) {
                                setDtype(bVar.k());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class Mbc extends f {
                    public static final int MARKV_FIELD_NUMBER = 1;
                    private boolean hasMarkv;
                    private String markv_ = "";
                    private int cachedSize = -1;

                    public static Mbc parseFrom(b bVar) throws IOException {
                        return new Mbc().mergeFrom(bVar);
                    }

                    public final Mbc clear() {
                        clearMarkv();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Mbc clearMarkv() {
                        this.hasMarkv = false;
                        this.markv_ = "";
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getMarkv() {
                        return this.markv_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasMarkv() ? d.l(1, getMarkv()) : 0;
                        this.cachedSize = iL;
                        return iL;
                    }

                    public boolean hasMarkv() {
                        return this.hasMarkv;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Mbc setMarkv(String str) {
                        this.hasMarkv = true;
                        this.markv_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasMarkv()) {
                            dVar.A(1, getMarkv());
                        }
                    }

                    public static Mbc parseFrom(byte[] bArr) throws e {
                        return (Mbc) new Mbc().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Mbc mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setMarkv(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class Meishipaihao extends f {
                    public static final int IS_OK_FIELD_NUMBER = 1;
                    public static final int MAIN_FIELD_NUMBER = 2;
                    private boolean hasIsOk;
                    private boolean hasMain;
                    private int isOk_ = 0;
                    private Main main_ = null;
                    private int cachedSize = -1;

                    public static final class Main extends f {
                        public static final int THIRD_FROM_FIELD_NUMBER = 1;
                        public static final int THIRD_ID_FIELD_NUMBER = 2;
                        private boolean hasThirdFrom;
                        private boolean hasThirdId;
                        private String thirdFrom_ = "";
                        private String thirdId_ = "";
                        private int cachedSize = -1;

                        public static Main parseFrom(b bVar) throws IOException {
                            return new Main().mergeFrom(bVar);
                        }

                        public final Main clear() {
                            clearThirdFrom();
                            clearThirdId();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Main clearThirdFrom() {
                            this.hasThirdFrom = false;
                            this.thirdFrom_ = "";
                            return this;
                        }

                        public Main clearThirdId() {
                            this.hasThirdId = false;
                            this.thirdId_ = "";
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
                            int iL = hasThirdFrom() ? d.l(1, getThirdFrom()) : 0;
                            if (hasThirdId()) {
                                iL += d.l(2, getThirdId());
                            }
                            this.cachedSize = iL;
                            return iL;
                        }

                        public String getThirdFrom() {
                            return this.thirdFrom_;
                        }

                        public String getThirdId() {
                            return this.thirdId_;
                        }

                        public boolean hasThirdFrom() {
                            return this.hasThirdFrom;
                        }

                        public boolean hasThirdId() {
                            return this.hasThirdId;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Main setThirdFrom(String str) {
                            this.hasThirdFrom = true;
                            this.thirdFrom_ = str;
                            return this;
                        }

                        public Main setThirdId(String str) {
                            this.hasThirdId = true;
                            this.thirdId_ = str;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasThirdFrom()) {
                                dVar.A(1, getThirdFrom());
                            }
                            if (hasThirdId()) {
                                dVar.A(2, getThirdId());
                            }
                        }

                        public static Main parseFrom(byte[] bArr) throws e {
                            return (Main) new Main().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public Main mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 10) {
                                    setThirdFrom(bVar.n());
                                } else if (iO == 18) {
                                    setThirdId(bVar.n());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static Meishipaihao parseFrom(b bVar) throws IOException {
                        return new Meishipaihao().mergeFrom(bVar);
                    }

                    public final Meishipaihao clear() {
                        clearIsOk();
                        clearMain();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Meishipaihao clearIsOk() {
                        this.hasIsOk = false;
                        this.isOk_ = 0;
                        return this;
                    }

                    public Meishipaihao clearMain() {
                        this.hasMain = false;
                        this.main_ = null;
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getIsOk() {
                        return this.isOk_;
                    }

                    public Main getMain() {
                        return this.main_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasIsOk() ? d.e(1, getIsOk()) : 0;
                        if (hasMain()) {
                            iE += d.h(2, getMain());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public boolean hasIsOk() {
                        return this.hasIsOk;
                    }

                    public boolean hasMain() {
                        return this.hasMain;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Meishipaihao setIsOk(int i4) {
                        this.hasIsOk = true;
                        this.isOk_ = i4;
                        return this;
                    }

                    public Meishipaihao setMain(Main main) {
                        if (main == null) {
                            return clearMain();
                        }
                        this.hasMain = true;
                        this.main_ = main;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasIsOk()) {
                            dVar.s(1, getIsOk());
                        }
                        if (hasMain()) {
                            dVar.u(2, getMain());
                        }
                    }

                    public static Meishipaihao parseFrom(byte[] bArr) throws e {
                        return (Meishipaihao) new Meishipaihao().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Meishipaihao mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setIsOk(bVar.k());
                            } else if (iO == 18) {
                                Main main = new Main();
                                bVar.f(main);
                                setMain(main);
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class MnpKeyInfo extends f {
                    public static final int APP_KEY_LIST_FIELD_NUMBER = 1;
                    private List<MnpAppList> appKeyList_ = Collections.emptyList();
                    private int cachedSize = -1;

                    public static final class MnpAppList extends f {
                        public static final int IS_PRE_LOAD_FIELD_NUMBER = 2;
                        public static final int KEY_FIELD_NUMBER = 1;
                        private boolean hasIsPreLoad;
                        private boolean hasKey;
                        private String key_ = "";
                        private String isPreLoad_ = "";
                        private int cachedSize = -1;

                        public static MnpAppList parseFrom(b bVar) throws IOException {
                            return new MnpAppList().mergeFrom(bVar);
                        }

                        public final MnpAppList clear() {
                            clearKey();
                            clearIsPreLoad();
                            this.cachedSize = -1;
                            return this;
                        }

                        public MnpAppList clearIsPreLoad() {
                            this.hasIsPreLoad = false;
                            this.isPreLoad_ = "";
                            return this;
                        }

                        public MnpAppList clearKey() {
                            this.hasKey = false;
                            this.key_ = "";
                            return this;
                        }

                        @Override // L1.f
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public String getIsPreLoad() {
                            return this.isPreLoad_;
                        }

                        public String getKey() {
                            return this.key_;
                        }

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iL = hasKey() ? d.l(1, getKey()) : 0;
                            if (hasIsPreLoad()) {
                                iL += d.l(2, getIsPreLoad());
                            }
                            this.cachedSize = iL;
                            return iL;
                        }

                        public boolean hasIsPreLoad() {
                            return this.hasIsPreLoad;
                        }

                        public boolean hasKey() {
                            return this.hasKey;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public MnpAppList setIsPreLoad(String str) {
                            this.hasIsPreLoad = true;
                            this.isPreLoad_ = str;
                            return this;
                        }

                        public MnpAppList setKey(String str) {
                            this.hasKey = true;
                            this.key_ = str;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasKey()) {
                                dVar.A(1, getKey());
                            }
                            if (hasIsPreLoad()) {
                                dVar.A(2, getIsPreLoad());
                            }
                        }

                        public static MnpAppList parseFrom(byte[] bArr) throws e {
                            return (MnpAppList) new MnpAppList().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public MnpAppList mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 10) {
                                    setKey(bVar.n());
                                } else if (iO == 18) {
                                    setIsPreLoad(bVar.n());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static MnpKeyInfo parseFrom(b bVar) throws IOException {
                        return new MnpKeyInfo().mergeFrom(bVar);
                    }

                    public MnpKeyInfo addAppKeyList(MnpAppList mnpAppList) {
                        if (mnpAppList == null) {
                            return this;
                        }
                        if (this.appKeyList_.isEmpty()) {
                            this.appKeyList_ = new ArrayList();
                        }
                        this.appKeyList_.add(mnpAppList);
                        return this;
                    }

                    public final MnpKeyInfo clear() {
                        clearAppKeyList();
                        this.cachedSize = -1;
                        return this;
                    }

                    public MnpKeyInfo clearAppKeyList() {
                        this.appKeyList_ = Collections.emptyList();
                        return this;
                    }

                    public MnpAppList getAppKeyList(int i4) {
                        return this.appKeyList_.get(i4);
                    }

                    public int getAppKeyListCount() {
                        return this.appKeyList_.size();
                    }

                    public List<MnpAppList> getAppKeyListList() {
                        return this.appKeyList_;
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
                        Iterator<MnpAppList> it = getAppKeyListList().iterator();
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

                    public MnpKeyInfo setAppKeyList(int i4, MnpAppList mnpAppList) {
                        if (mnpAppList == null) {
                            return this;
                        }
                        this.appKeyList_.set(i4, mnpAppList);
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        Iterator<MnpAppList> it = getAppKeyListList().iterator();
                        while (it.hasNext()) {
                            dVar.u(1, it.next());
                        }
                    }

                    public static MnpKeyInfo parseFrom(byte[] bArr) throws e {
                        return (MnpKeyInfo) new MnpKeyInfo().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public MnpKeyInfo mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                MnpAppList mnpAppList = new MnpAppList();
                                bVar.f(mnpAppList);
                                addAppKeyList(mnpAppList);
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class OrilInfo extends f {
                    public static final int ORIL_DETAIL_FIELD_NUMBER = 1;
                    private List<OrilDetail> orilDetail_ = Collections.emptyList();
                    private int cachedSize = -1;

                    public static final class OrilDetail extends f {
                        public static final int ORIL_PRICE_FIELD_NUMBER = 1;
                        public static final int ORIL_TYPE_FIELD_NUMBER = 2;
                        private boolean hasOrilPrice;
                        private boolean hasOrilType;
                        private String orilPrice_ = "";
                        private String orilType_ = "";
                        private int cachedSize = -1;

                        public static OrilDetail parseFrom(b bVar) throws IOException {
                            return new OrilDetail().mergeFrom(bVar);
                        }

                        public final OrilDetail clear() {
                            clearOrilPrice();
                            clearOrilType();
                            this.cachedSize = -1;
                            return this;
                        }

                        public OrilDetail clearOrilPrice() {
                            this.hasOrilPrice = false;
                            this.orilPrice_ = "";
                            return this;
                        }

                        public OrilDetail clearOrilType() {
                            this.hasOrilType = false;
                            this.orilType_ = "";
                            return this;
                        }

                        @Override // L1.f
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public String getOrilPrice() {
                            return this.orilPrice_;
                        }

                        public String getOrilType() {
                            return this.orilType_;
                        }

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iL = hasOrilPrice() ? d.l(1, getOrilPrice()) : 0;
                            if (hasOrilType()) {
                                iL += d.l(2, getOrilType());
                            }
                            this.cachedSize = iL;
                            return iL;
                        }

                        public boolean hasOrilPrice() {
                            return this.hasOrilPrice;
                        }

                        public boolean hasOrilType() {
                            return this.hasOrilType;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public OrilDetail setOrilPrice(String str) {
                            this.hasOrilPrice = true;
                            this.orilPrice_ = str;
                            return this;
                        }

                        public OrilDetail setOrilType(String str) {
                            this.hasOrilType = true;
                            this.orilType_ = str;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasOrilPrice()) {
                                dVar.A(1, getOrilPrice());
                            }
                            if (hasOrilType()) {
                                dVar.A(2, getOrilType());
                            }
                        }

                        public static OrilDetail parseFrom(byte[] bArr) throws e {
                            return (OrilDetail) new OrilDetail().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public OrilDetail mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 10) {
                                    setOrilPrice(bVar.n());
                                } else if (iO == 18) {
                                    setOrilType(bVar.n());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static OrilInfo parseFrom(b bVar) throws IOException {
                        return new OrilInfo().mergeFrom(bVar);
                    }

                    public OrilInfo addOrilDetail(OrilDetail orilDetail) {
                        if (orilDetail == null) {
                            return this;
                        }
                        if (this.orilDetail_.isEmpty()) {
                            this.orilDetail_ = new ArrayList();
                        }
                        this.orilDetail_.add(orilDetail);
                        return this;
                    }

                    public final OrilInfo clear() {
                        clearOrilDetail();
                        this.cachedSize = -1;
                        return this;
                    }

                    public OrilInfo clearOrilDetail() {
                        this.orilDetail_ = Collections.emptyList();
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public OrilDetail getOrilDetail(int i4) {
                        return this.orilDetail_.get(i4);
                    }

                    public int getOrilDetailCount() {
                        return this.orilDetail_.size();
                    }

                    public List<OrilDetail> getOrilDetailList() {
                        return this.orilDetail_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        Iterator<OrilDetail> it = getOrilDetailList().iterator();
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

                    public OrilInfo setOrilDetail(int i4, OrilDetail orilDetail) {
                        if (orilDetail == null) {
                            return this;
                        }
                        this.orilDetail_.set(i4, orilDetail);
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        Iterator<OrilDetail> it = getOrilDetailList().iterator();
                        while (it.hasNext()) {
                            dVar.u(1, it.next());
                        }
                    }

                    public static OrilInfo parseFrom(byte[] bArr) throws e {
                        return (OrilInfo) new OrilInfo().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public OrilInfo mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                OrilDetail orilDetail = new OrilDetail();
                                bVar.f(orilDetail);
                                addOrilDetail(orilDetail);
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class PhoneDetail extends f {
                    public static final int GROUP_FIELD_NUMBER = 1;
                    private List<Group> group_ = Collections.emptyList();
                    private int cachedSize = -1;

                    public static final class Group extends f {
                        public static final int BID_FIELD_NUMBER = 2;
                        public static final int NAME_FIELD_NUMBER = 3;
                        public static final int PHONE_FIELD_NUMBER = 1;
                        private boolean hasBid;
                        private boolean hasName;
                        private boolean hasPhone;
                        private String phone_ = "";
                        private String bid_ = "";
                        private String name_ = "";
                        private int cachedSize = -1;

                        public static Group parseFrom(b bVar) throws IOException {
                            return new Group().mergeFrom(bVar);
                        }

                        public final Group clear() {
                            clearPhone();
                            clearBid();
                            clearName();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Group clearBid() {
                            this.hasBid = false;
                            this.bid_ = "";
                            return this;
                        }

                        public Group clearName() {
                            this.hasName = false;
                            this.name_ = "";
                            return this;
                        }

                        public Group clearPhone() {
                            this.hasPhone = false;
                            this.phone_ = "";
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

                        public String getName() {
                            return this.name_;
                        }

                        public String getPhone() {
                            return this.phone_;
                        }

                        @Override // L1.f
                        public int getSerializedSize() {
                            int iL = hasPhone() ? d.l(1, getPhone()) : 0;
                            if (hasBid()) {
                                iL += d.l(2, getBid());
                            }
                            if (hasName()) {
                                iL += d.l(3, getName());
                            }
                            this.cachedSize = iL;
                            return iL;
                        }

                        public boolean hasBid() {
                            return this.hasBid;
                        }

                        public boolean hasName() {
                            return this.hasName;
                        }

                        public boolean hasPhone() {
                            return this.hasPhone;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Group setBid(String str) {
                            this.hasBid = true;
                            this.bid_ = str;
                            return this;
                        }

                        public Group setName(String str) {
                            this.hasName = true;
                            this.name_ = str;
                            return this;
                        }

                        public Group setPhone(String str) {
                            this.hasPhone = true;
                            this.phone_ = str;
                            return this;
                        }

                        @Override // L1.f
                        public void writeTo(d dVar) throws IOException {
                            if (hasPhone()) {
                                dVar.A(1, getPhone());
                            }
                            if (hasBid()) {
                                dVar.A(2, getBid());
                            }
                            if (hasName()) {
                                dVar.A(3, getName());
                            }
                        }

                        public static Group parseFrom(byte[] bArr) throws e {
                            return (Group) new Group().mergeFrom(bArr);
                        }

                        @Override // L1.f
                        public Group mergeFrom(b bVar) throws IOException {
                            while (true) {
                                int iO = bVar.o();
                                if (iO == 0) {
                                    return this;
                                }
                                if (iO == 10) {
                                    setPhone(bVar.n());
                                } else if (iO == 18) {
                                    setBid(bVar.n());
                                } else if (iO == 26) {
                                    setName(bVar.n());
                                } else if (!parseUnknownField(bVar, iO)) {
                                    return this;
                                }
                            }
                        }
                    }

                    public static PhoneDetail parseFrom(b bVar) throws IOException {
                        return new PhoneDetail().mergeFrom(bVar);
                    }

                    public PhoneDetail addGroup(Group group) {
                        if (group == null) {
                            return this;
                        }
                        if (this.group_.isEmpty()) {
                            this.group_ = new ArrayList();
                        }
                        this.group_.add(group);
                        return this;
                    }

                    public final PhoneDetail clear() {
                        clearGroup();
                        this.cachedSize = -1;
                        return this;
                    }

                    public PhoneDetail clearGroup() {
                        this.group_ = Collections.emptyList();
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public Group getGroup(int i4) {
                        return this.group_.get(i4);
                    }

                    public int getGroupCount() {
                        return this.group_.size();
                    }

                    public List<Group> getGroupList() {
                        return this.group_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        Iterator<Group> it = getGroupList().iterator();
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

                    public PhoneDetail setGroup(int i4, Group group) {
                        if (group == null) {
                            return this;
                        }
                        this.group_.set(i4, group);
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        Iterator<Group> it = getGroupList().iterator();
                        while (it.hasNext()) {
                            dVar.u(1, it.next());
                        }
                    }

                    public static PhoneDetail parseFrom(byte[] bArr) throws e {
                        return (PhoneDetail) new PhoneDetail().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public PhoneDetail mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                Group group = new Group();
                                bVar.f(group);
                                addGroup(group);
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class PhoneRisk extends f {
                    public static final int BID_FIELD_NUMBER = 1;
                    public static final int WORD_FIELD_NUMBER = 2;
                    private boolean hasBid;
                    private boolean hasWord;
                    private String bid_ = "";
                    private String word_ = "";
                    private int cachedSize = -1;

                    public static PhoneRisk parseFrom(b bVar) throws IOException {
                        return new PhoneRisk().mergeFrom(bVar);
                    }

                    public final PhoneRisk clear() {
                        clearBid();
                        clearWord();
                        this.cachedSize = -1;
                        return this;
                    }

                    public PhoneRisk clearBid() {
                        this.hasBid = false;
                        this.bid_ = "";
                        return this;
                    }

                    public PhoneRisk clearWord() {
                        this.hasWord = false;
                        this.word_ = "";
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

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasBid() ? d.l(1, getBid()) : 0;
                        if (hasWord()) {
                            iL += d.l(2, getWord());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public String getWord() {
                        return this.word_;
                    }

                    public boolean hasBid() {
                        return this.hasBid;
                    }

                    public boolean hasWord() {
                        return this.hasWord;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public PhoneRisk setBid(String str) {
                        this.hasBid = true;
                        this.bid_ = str;
                        return this;
                    }

                    public PhoneRisk setWord(String str) {
                        this.hasWord = true;
                        this.word_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasBid()) {
                            dVar.A(1, getBid());
                        }
                        if (hasWord()) {
                            dVar.A(2, getWord());
                        }
                    }

                    public static PhoneRisk parseFrom(byte[] bArr) throws e {
                        return (PhoneRisk) new PhoneRisk().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public PhoneRisk mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setBid(bVar.n());
                            } else if (iO == 18) {
                                setWord(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class PremiumInfo extends f {
                    public static final int DISCOUNT_CONTENT_FIELD_NUMBER = 1;
                    public static final int DISCOUNT_DL_FIELD_NUMBER = 2;
                    public static final int DISCOUNT_ID_FIELD_NUMBER = 3;
                    public static final int NAME_FIELD_NUMBER = 4;
                    private boolean hasDiscountContent;
                    private boolean hasDiscountDl;
                    private boolean hasDiscountId;
                    private boolean hasName;
                    private String discountContent_ = "";
                    private String discountDl_ = "";
                    private String discountId_ = "";
                    private String name_ = "";
                    private int cachedSize = -1;

                    public static PremiumInfo parseFrom(b bVar) throws IOException {
                        return new PremiumInfo().mergeFrom(bVar);
                    }

                    public final PremiumInfo clear() {
                        clearDiscountContent();
                        clearDiscountDl();
                        clearDiscountId();
                        clearName();
                        this.cachedSize = -1;
                        return this;
                    }

                    public PremiumInfo clearDiscountContent() {
                        this.hasDiscountContent = false;
                        this.discountContent_ = "";
                        return this;
                    }

                    public PremiumInfo clearDiscountDl() {
                        this.hasDiscountDl = false;
                        this.discountDl_ = "";
                        return this;
                    }

                    public PremiumInfo clearDiscountId() {
                        this.hasDiscountId = false;
                        this.discountId_ = "";
                        return this;
                    }

                    public PremiumInfo clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getDiscountContent() {
                        return this.discountContent_;
                    }

                    public String getDiscountDl() {
                        return this.discountDl_;
                    }

                    public String getDiscountId() {
                        return this.discountId_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iL = hasDiscountContent() ? d.l(1, getDiscountContent()) : 0;
                        if (hasDiscountDl()) {
                            iL += d.l(2, getDiscountDl());
                        }
                        if (hasDiscountId()) {
                            iL += d.l(3, getDiscountId());
                        }
                        if (hasName()) {
                            iL += d.l(4, getName());
                        }
                        this.cachedSize = iL;
                        return iL;
                    }

                    public boolean hasDiscountContent() {
                        return this.hasDiscountContent;
                    }

                    public boolean hasDiscountDl() {
                        return this.hasDiscountDl;
                    }

                    public boolean hasDiscountId() {
                        return this.hasDiscountId;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public PremiumInfo setDiscountContent(String str) {
                        this.hasDiscountContent = true;
                        this.discountContent_ = str;
                        return this;
                    }

                    public PremiumInfo setDiscountDl(String str) {
                        this.hasDiscountDl = true;
                        this.discountDl_ = str;
                        return this;
                    }

                    public PremiumInfo setDiscountId(String str) {
                        this.hasDiscountId = true;
                        this.discountId_ = str;
                        return this;
                    }

                    public PremiumInfo setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasDiscountContent()) {
                            dVar.A(1, getDiscountContent());
                        }
                        if (hasDiscountDl()) {
                            dVar.A(2, getDiscountDl());
                        }
                        if (hasDiscountId()) {
                            dVar.A(3, getDiscountId());
                        }
                        if (hasName()) {
                            dVar.A(4, getName());
                        }
                    }

                    public static PremiumInfo parseFrom(byte[] bArr) throws e {
                        return (PremiumInfo) new PremiumInfo().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public PremiumInfo mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 10) {
                                setDiscountContent(bVar.n());
                            } else if (iO == 18) {
                                setDiscountDl(bVar.n());
                            } else if (iO == 26) {
                                setDiscountId(bVar.n());
                            } else if (iO == 34) {
                                setName(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class RecommendDish extends f {
                    public static final int COLOR_FIELD_NUMBER = 3;
                    public static final int DISH_NAME_FIELD_NUMBER = 2;
                    public static final int DISH_NUM_FIELD_NUMBER = 1;
                    private boolean hasColor;
                    private boolean hasDishName;
                    private boolean hasDishNum;
                    private int dishNum_ = 0;
                    private String dishName_ = "";
                    private String color_ = "";
                    private int cachedSize = -1;

                    public static RecommendDish parseFrom(b bVar) throws IOException {
                        return new RecommendDish().mergeFrom(bVar);
                    }

                    public final RecommendDish clear() {
                        clearDishNum();
                        clearDishName();
                        clearColor();
                        this.cachedSize = -1;
                        return this;
                    }

                    public RecommendDish clearColor() {
                        this.hasColor = false;
                        this.color_ = "";
                        return this;
                    }

                    public RecommendDish clearDishName() {
                        this.hasDishName = false;
                        this.dishName_ = "";
                        return this;
                    }

                    public RecommendDish clearDishNum() {
                        this.hasDishNum = false;
                        this.dishNum_ = 0;
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getColor() {
                        return this.color_;
                    }

                    public String getDishName() {
                        return this.dishName_;
                    }

                    public int getDishNum() {
                        return this.dishNum_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasDishNum() ? d.e(1, getDishNum()) : 0;
                        if (hasDishName()) {
                            iE += d.l(2, getDishName());
                        }
                        if (hasColor()) {
                            iE += d.l(3, getColor());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public boolean hasColor() {
                        return this.hasColor;
                    }

                    public boolean hasDishName() {
                        return this.hasDishName;
                    }

                    public boolean hasDishNum() {
                        return this.hasDishNum;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public RecommendDish setColor(String str) {
                        this.hasColor = true;
                        this.color_ = str;
                        return this;
                    }

                    public RecommendDish setDishName(String str) {
                        this.hasDishName = true;
                        this.dishName_ = str;
                        return this;
                    }

                    public RecommendDish setDishNum(int i4) {
                        this.hasDishNum = true;
                        this.dishNum_ = i4;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasDishNum()) {
                            dVar.s(1, getDishNum());
                        }
                        if (hasDishName()) {
                            dVar.A(2, getDishName());
                        }
                        if (hasColor()) {
                            dVar.A(3, getColor());
                        }
                    }

                    public static RecommendDish parseFrom(byte[] bArr) throws e {
                        return (RecommendDish) new RecommendDish().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public RecommendDish mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setDishNum(bVar.k());
                            } else if (iO == 18) {
                                setDishName(bVar.n());
                            } else if (iO == 26) {
                                setColor(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static final class Upperleftcorner extends f {
                    public static final int RESOURCE_ID_FIELD_NUMBER = 1;
                    public static final int RESOURCE_URL_FIELD_NUMBER = 2;
                    private boolean hasResourceId;
                    private boolean hasResourceUrl;
                    private int resourceId_ = 0;
                    private String resourceUrl_ = "";
                    private int cachedSize = -1;

                    public static Upperleftcorner parseFrom(b bVar) throws IOException {
                        return new Upperleftcorner().mergeFrom(bVar);
                    }

                    public final Upperleftcorner clear() {
                        clearResourceId();
                        clearResourceUrl();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Upperleftcorner clearResourceId() {
                        this.hasResourceId = false;
                        this.resourceId_ = 0;
                        return this;
                    }

                    public Upperleftcorner clearResourceUrl() {
                        this.hasResourceUrl = false;
                        this.resourceUrl_ = "";
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getResourceId() {
                        return this.resourceId_;
                    }

                    public String getResourceUrl() {
                        return this.resourceUrl_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        int iE = hasResourceId() ? d.e(1, getResourceId()) : 0;
                        if (hasResourceUrl()) {
                            iE += d.l(2, getResourceUrl());
                        }
                        this.cachedSize = iE;
                        return iE;
                    }

                    public boolean hasResourceId() {
                        return this.hasResourceId;
                    }

                    public boolean hasResourceUrl() {
                        return this.hasResourceUrl;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Upperleftcorner setResourceId(int i4) {
                        this.hasResourceId = true;
                        this.resourceId_ = i4;
                        return this;
                    }

                    public Upperleftcorner setResourceUrl(String str) {
                        this.hasResourceUrl = true;
                        this.resourceUrl_ = str;
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        if (hasResourceId()) {
                            dVar.s(1, getResourceId());
                        }
                        if (hasResourceUrl()) {
                            dVar.A(2, getResourceUrl());
                        }
                    }

                    public static Upperleftcorner parseFrom(byte[] bArr) throws e {
                        return (Upperleftcorner) new Upperleftcorner().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public Upperleftcorner mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                setResourceId(bVar.k());
                            } else if (iO == 18) {
                                setResourceUrl(bVar.n());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static DetailInfo parseFrom(b bVar) throws IOException {
                    return new DetailInfo().mergeFrom(bVar);
                }

                public DetailInfo addActivity(Activity activity) {
                    if (activity == null) {
                        return this;
                    }
                    if (this.activity_.isEmpty()) {
                        this.activity_ = new ArrayList();
                    }
                    this.activity_.add(activity);
                    return this;
                }

                public DetailInfo addFlag(String str) {
                    str.getClass();
                    if (this.flag_.isEmpty()) {
                        this.flag_ = new ArrayList();
                    }
                    this.flag_.add(str);
                    return this;
                }

                public DetailInfo addHotelService(HotelService hotelService) {
                    if (hotelService == null) {
                        return this;
                    }
                    if (this.hotelService_.isEmpty()) {
                        this.hotelService_ = new ArrayList();
                    }
                    this.hotelService_.add(hotelService);
                    return this;
                }

                public DetailInfo addImpression(Impression impression) {
                    if (impression == null) {
                        return this;
                    }
                    if (this.impression_.isEmpty()) {
                        this.impression_ = new ArrayList();
                    }
                    this.impression_.add(impression);
                    return this;
                }

                public final DetailInfo clear() {
                    clearPremiumInfo();
                    clearGrouponInfo();
                    clearOrilInfo();
                    clearBookInfo();
                    clearActivity();
                    clearFlag();
                    clearOverallRating();
                    clearPriceText();
                    clearTag();
                    clearImage();
                    clearShowInfo();
                    clearPremiumFlag();
                    clearDiscountTotal();
                    clearGrouponTotal();
                    clearCommentNum();
                    clearMovieFlag();
                    clearMovieFilmCount();
                    clearGrouponFlag();
                    clearWapBookable();
                    clearPrice();
                    clearWiseFullroom();
                    clearDiscount();
                    clearGrade();
                    clearGuide();
                    clearSpecialService();
                    clearFlagOnLeft();
                    clearImpression();
                    clearMeishipaihao();
                    clearTradeTag();
                    clearMarketbiz();
                    clearValidate();
                    clearWiseHourlyBookable();
                    clearDisText();
                    clearLbcBusinessVip();
                    clearRecommendDish();
                    clearBusinessService();
                    clearStatusLabel();
                    clearUpperleftcorner();
                    clearDisplayInfoRedu();
                    clearDisplayInfoCommentLabel();
                    clearMbc();
                    clearAoi();
                    clearSpecialTag();
                    clearOriginPriceText();
                    clearHotelService();
                    clearAllcardextension();
                    clearShopHours();
                    clearVsContent();
                    clearPhoneDetail();
                    clearPhoneRisk();
                    clearNewBusinessTime();
                    clearMiniprogram();
                    clearMnpKeyInfo();
                    clearBlinkBuilding();
                    clearChejiNeed();
                    this.cachedSize = -1;
                    return this;
                }

                public DetailInfo clearActivity() {
                    this.activity_ = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearAllcardextension() {
                    this.hasAllcardextension = false;
                    this.allcardextension_ = null;
                    return this;
                }

                public DetailInfo clearAoi() {
                    this.hasAoi = false;
                    this.aoi_ = "";
                    return this;
                }

                public DetailInfo clearBlinkBuilding() {
                    this.hasBlinkBuilding = false;
                    this.blinkBuilding_ = null;
                    return this;
                }

                public DetailInfo clearBookInfo() {
                    this.hasBookInfo = false;
                    this.bookInfo_ = null;
                    return this;
                }

                public DetailInfo clearBusinessService() {
                    this.hasBusinessService = false;
                    this.businessService_ = null;
                    return this;
                }

                public DetailInfo clearChejiNeed() {
                    this.hasChejiNeed = false;
                    this.chejiNeed_ = null;
                    return this;
                }

                public DetailInfo clearCommentNum() {
                    this.hasCommentNum = false;
                    this.commentNum_ = "";
                    return this;
                }

                public DetailInfo clearDisText() {
                    this.hasDisText = false;
                    this.disText_ = "";
                    return this;
                }

                public DetailInfo clearDiscount() {
                    this.hasDiscount = false;
                    this.discount_ = "";
                    return this;
                }

                public DetailInfo clearDiscountTotal() {
                    this.hasDiscountTotal = false;
                    this.discountTotal_ = 0;
                    return this;
                }

                public DetailInfo clearDisplayInfoCommentLabel() {
                    this.hasDisplayInfoCommentLabel = false;
                    this.displayInfoCommentLabel_ = null;
                    return this;
                }

                public DetailInfo clearDisplayInfoRedu() {
                    this.hasDisplayInfoRedu = false;
                    this.displayInfoRedu_ = "";
                    return this;
                }

                public DetailInfo clearFlag() {
                    this.flag_ = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearFlagOnLeft() {
                    this.hasFlagOnLeft = false;
                    this.flagOnLeft_ = "";
                    return this;
                }

                public DetailInfo clearGrade() {
                    this.hasGrade = false;
                    this.grade_ = "";
                    return this;
                }

                public DetailInfo clearGrouponFlag() {
                    this.hasGrouponFlag = false;
                    this.grouponFlag_ = 0;
                    return this;
                }

                public DetailInfo clearGrouponInfo() {
                    this.hasGrouponInfo = false;
                    this.grouponInfo_ = null;
                    return this;
                }

                public DetailInfo clearGrouponTotal() {
                    this.hasGrouponTotal = false;
                    this.grouponTotal_ = 0;
                    return this;
                }

                public DetailInfo clearGuide() {
                    this.hasGuide = false;
                    this.guide_ = "";
                    return this;
                }

                public DetailInfo clearHotelService() {
                    this.hotelService_ = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearImage() {
                    this.hasImage = false;
                    this.image_ = "";
                    return this;
                }

                public DetailInfo clearImpression() {
                    this.impression_ = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearLbcBusinessVip() {
                    this.hasLbcBusinessVip = false;
                    this.lbcBusinessVip_ = null;
                    return this;
                }

                public DetailInfo clearMarketbiz() {
                    this.hasMarketbiz = false;
                    this.marketbiz_ = null;
                    return this;
                }

                public DetailInfo clearMbc() {
                    this.hasMbc = false;
                    this.mbc_ = null;
                    return this;
                }

                public DetailInfo clearMeishipaihao() {
                    this.hasMeishipaihao = false;
                    this.meishipaihao_ = null;
                    return this;
                }

                public DetailInfo clearMiniprogram() {
                    this.hasMiniprogram = false;
                    this.miniprogram_ = "";
                    return this;
                }

                public DetailInfo clearMnpKeyInfo() {
                    this.hasMnpKeyInfo = false;
                    this.mnpKeyInfo_ = null;
                    return this;
                }

                public DetailInfo clearMovieFilmCount() {
                    this.hasMovieFilmCount = false;
                    this.movieFilmCount_ = 0;
                    return this;
                }

                public DetailInfo clearMovieFlag() {
                    this.hasMovieFlag = false;
                    this.movieFlag_ = "";
                    return this;
                }

                public DetailInfo clearNewBusinessTime() {
                    this.hasNewBusinessTime = false;
                    this.newBusinessTime_ = "";
                    return this;
                }

                public DetailInfo clearOriginPriceText() {
                    this.hasOriginPriceText = false;
                    this.originPriceText_ = "";
                    return this;
                }

                public DetailInfo clearOrilInfo() {
                    this.hasOrilInfo = false;
                    this.orilInfo_ = null;
                    return this;
                }

                public DetailInfo clearOverallRating() {
                    this.hasOverallRating = false;
                    this.overallRating_ = "";
                    return this;
                }

                public DetailInfo clearPhoneDetail() {
                    this.hasPhoneDetail = false;
                    this.phoneDetail_ = null;
                    return this;
                }

                public DetailInfo clearPhoneRisk() {
                    this.hasPhoneRisk = false;
                    this.phoneRisk_ = null;
                    return this;
                }

                public DetailInfo clearPremiumFlag() {
                    this.hasPremiumFlag = false;
                    this.premiumFlag_ = 0;
                    return this;
                }

                public DetailInfo clearPremiumInfo() {
                    this.hasPremiumInfo = false;
                    this.premiumInfo_ = null;
                    return this;
                }

                public DetailInfo clearPrice() {
                    this.hasPrice = false;
                    this.price_ = "";
                    return this;
                }

                public DetailInfo clearPriceText() {
                    this.hasPriceText = false;
                    this.priceText_ = "";
                    return this;
                }

                public DetailInfo clearRecommendDish() {
                    this.hasRecommendDish = false;
                    this.recommendDish_ = null;
                    return this;
                }

                public DetailInfo clearShopHours() {
                    this.hasShopHours = false;
                    this.shopHours_ = "";
                    return this;
                }

                public DetailInfo clearShowInfo() {
                    this.hasShowInfo = false;
                    this.showInfo_ = "";
                    return this;
                }

                public DetailInfo clearSpecialService() {
                    this.hasSpecialService = false;
                    this.specialService_ = "";
                    return this;
                }

                public DetailInfo clearSpecialTag() {
                    this.hasSpecialTag = false;
                    this.specialTag_ = "";
                    return this;
                }

                public DetailInfo clearStatusLabel() {
                    this.hasStatusLabel = false;
                    this.statusLabel_ = "";
                    return this;
                }

                public DetailInfo clearTag() {
                    this.hasTag = false;
                    this.tag_ = "";
                    return this;
                }

                public DetailInfo clearTradeTag() {
                    this.hasTradeTag = false;
                    this.tradeTag_ = "";
                    return this;
                }

                public DetailInfo clearUpperleftcorner() {
                    this.hasUpperleftcorner = false;
                    this.upperleftcorner_ = null;
                    return this;
                }

                public DetailInfo clearValidate() {
                    this.hasValidate = false;
                    this.validate_ = "";
                    return this;
                }

                public DetailInfo clearVsContent() {
                    this.hasVsContent = false;
                    this.vsContent_ = "";
                    return this;
                }

                public DetailInfo clearWapBookable() {
                    this.hasWapBookable = false;
                    this.wapBookable_ = "";
                    return this;
                }

                public DetailInfo clearWiseFullroom() {
                    this.hasWiseFullroom = false;
                    this.wiseFullroom_ = "";
                    return this;
                }

                public DetailInfo clearWiseHourlyBookable() {
                    this.hasWiseHourlyBookable = false;
                    this.wiseHourlyBookable_ = "";
                    return this;
                }

                public Activity getActivity(int i4) {
                    return this.activity_.get(i4);
                }

                public int getActivityCount() {
                    return this.activity_.size();
                }

                public List<Activity> getActivityList() {
                    return this.activity_;
                }

                public Allcardextension getAllcardextension() {
                    return this.allcardextension_;
                }

                public String getAoi() {
                    return this.aoi_;
                }

                public BlinkBuilding getBlinkBuilding() {
                    return this.blinkBuilding_;
                }

                public BookInfo getBookInfo() {
                    return this.bookInfo_;
                }

                public BusinessService getBusinessService() {
                    return this.businessService_;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public ChejiNeed getChejiNeed() {
                    return this.chejiNeed_;
                }

                public String getCommentNum() {
                    return this.commentNum_;
                }

                public String getDisText() {
                    return this.disText_;
                }

                public String getDiscount() {
                    return this.discount_;
                }

                public int getDiscountTotal() {
                    return this.discountTotal_;
                }

                public DisplayInfoCommentLabel getDisplayInfoCommentLabel() {
                    return this.displayInfoCommentLabel_;
                }

                public String getDisplayInfoRedu() {
                    return this.displayInfoRedu_;
                }

                public String getFlag(int i4) {
                    return this.flag_.get(i4);
                }

                public int getFlagCount() {
                    return this.flag_.size();
                }

                public List<String> getFlagList() {
                    return this.flag_;
                }

                public String getFlagOnLeft() {
                    return this.flagOnLeft_;
                }

                public String getGrade() {
                    return this.grade_;
                }

                public int getGrouponFlag() {
                    return this.grouponFlag_;
                }

                public GrouponInfo getGrouponInfo() {
                    return this.grouponInfo_;
                }

                public int getGrouponTotal() {
                    return this.grouponTotal_;
                }

                public String getGuide() {
                    return this.guide_;
                }

                public HotelService getHotelService(int i4) {
                    return this.hotelService_.get(i4);
                }

                public int getHotelServiceCount() {
                    return this.hotelService_.size();
                }

                public List<HotelService> getHotelServiceList() {
                    return this.hotelService_;
                }

                public String getImage() {
                    return this.image_;
                }

                public Impression getImpression(int i4) {
                    return this.impression_.get(i4);
                }

                public int getImpressionCount() {
                    return this.impression_.size();
                }

                public List<Impression> getImpressionList() {
                    return this.impression_;
                }

                public LbcBusinessVip getLbcBusinessVip() {
                    return this.lbcBusinessVip_;
                }

                public Marketbiz getMarketbiz() {
                    return this.marketbiz_;
                }

                public Mbc getMbc() {
                    return this.mbc_;
                }

                public Meishipaihao getMeishipaihao() {
                    return this.meishipaihao_;
                }

                public String getMiniprogram() {
                    return this.miniprogram_;
                }

                public MnpKeyInfo getMnpKeyInfo() {
                    return this.mnpKeyInfo_;
                }

                public int getMovieFilmCount() {
                    return this.movieFilmCount_;
                }

                public String getMovieFlag() {
                    return this.movieFlag_;
                }

                public String getNewBusinessTime() {
                    return this.newBusinessTime_;
                }

                public String getOriginPriceText() {
                    return this.originPriceText_;
                }

                public OrilInfo getOrilInfo() {
                    return this.orilInfo_;
                }

                public String getOverallRating() {
                    return this.overallRating_;
                }

                public PhoneDetail getPhoneDetail() {
                    return this.phoneDetail_;
                }

                public PhoneRisk getPhoneRisk() {
                    return this.phoneRisk_;
                }

                public int getPremiumFlag() {
                    return this.premiumFlag_;
                }

                public PremiumInfo getPremiumInfo() {
                    return this.premiumInfo_;
                }

                public String getPrice() {
                    return this.price_;
                }

                public String getPriceText() {
                    return this.priceText_;
                }

                public RecommendDish getRecommendDish() {
                    return this.recommendDish_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    Iterator<String> it = getFlagList().iterator();
                    int iM = 0;
                    while (it.hasNext()) {
                        iM += d.m(it.next());
                    }
                    int size = getFlagList().size() + iM;
                    if (hasOverallRating()) {
                        size += d.l(2, getOverallRating());
                    }
                    if (hasPriceText()) {
                        size += d.l(3, getPriceText());
                    }
                    if (hasTag()) {
                        size += d.l(4, getTag());
                    }
                    if (hasImage()) {
                        size += d.l(5, getImage());
                    }
                    if (hasShowInfo()) {
                        size += d.l(6, getShowInfo());
                    }
                    if (hasPremiumFlag()) {
                        size += d.e(7, getPremiumFlag());
                    }
                    if (hasDiscountTotal()) {
                        size += d.e(8, getDiscountTotal());
                    }
                    if (hasGrouponTotal()) {
                        size += d.e(9, getGrouponTotal());
                    }
                    if (hasPremiumInfo()) {
                        size += d.h(10, getPremiumInfo());
                    }
                    if (hasCommentNum()) {
                        size += d.l(11, getCommentNum());
                    }
                    if (hasMovieFlag()) {
                        size += d.l(12, getMovieFlag());
                    }
                    if (hasMovieFilmCount()) {
                        size += d.e(13, getMovieFilmCount());
                    }
                    if (hasGrouponFlag()) {
                        size += d.e(14, getGrouponFlag());
                    }
                    if (hasGrouponInfo()) {
                        size += d.h(15, getGrouponInfo());
                    }
                    if (hasOrilInfo()) {
                        size += d.h(16, getOrilInfo());
                    }
                    if (hasWapBookable()) {
                        size += d.l(17, getWapBookable());
                    }
                    if (hasBookInfo()) {
                        size += d.h(18, getBookInfo());
                    }
                    if (hasPrice()) {
                        size += d.l(19, getPrice());
                    }
                    if (hasWiseFullroom()) {
                        size += d.l(20, getWiseFullroom());
                    }
                    if (hasDiscount()) {
                        size += d.l(21, getDiscount());
                    }
                    if (hasGrade()) {
                        size += d.l(22, getGrade());
                    }
                    Iterator<Activity> it2 = getActivityList().iterator();
                    while (it2.hasNext()) {
                        size += d.h(23, it2.next());
                    }
                    if (hasGuide()) {
                        size += d.l(24, getGuide());
                    }
                    if (hasSpecialService()) {
                        size += d.l(25, getSpecialService());
                    }
                    if (hasFlagOnLeft()) {
                        size += d.l(26, getFlagOnLeft());
                    }
                    Iterator<Impression> it3 = getImpressionList().iterator();
                    while (it3.hasNext()) {
                        size += d.h(27, it3.next());
                    }
                    if (hasMeishipaihao()) {
                        size += d.h(28, getMeishipaihao());
                    }
                    if (hasTradeTag()) {
                        size += d.l(29, getTradeTag());
                    }
                    if (hasMarketbiz()) {
                        size += d.h(30, getMarketbiz());
                    }
                    if (hasValidate()) {
                        size += d.l(31, getValidate());
                    }
                    if (hasWiseHourlyBookable()) {
                        size += d.l(32, getWiseHourlyBookable());
                    }
                    if (hasDisText()) {
                        size += d.l(33, getDisText());
                    }
                    if (hasLbcBusinessVip()) {
                        size += d.h(34, getLbcBusinessVip());
                    }
                    if (hasRecommendDish()) {
                        size += d.h(36, getRecommendDish());
                    }
                    if (hasBusinessService()) {
                        size += d.h(37, getBusinessService());
                    }
                    if (hasStatusLabel()) {
                        size += d.l(38, getStatusLabel());
                    }
                    if (hasUpperleftcorner()) {
                        size += d.h(39, getUpperleftcorner());
                    }
                    if (hasDisplayInfoRedu()) {
                        size += d.l(40, getDisplayInfoRedu());
                    }
                    if (hasDisplayInfoCommentLabel()) {
                        size += d.h(41, getDisplayInfoCommentLabel());
                    }
                    if (hasMbc()) {
                        size += d.h(42, getMbc());
                    }
                    if (hasAoi()) {
                        size += d.l(43, getAoi());
                    }
                    if (hasSpecialTag()) {
                        size += d.l(44, getSpecialTag());
                    }
                    if (hasOriginPriceText()) {
                        size += d.l(45, getOriginPriceText());
                    }
                    Iterator<HotelService> it4 = getHotelServiceList().iterator();
                    while (it4.hasNext()) {
                        size += d.h(46, it4.next());
                    }
                    if (hasAllcardextension()) {
                        size += d.h(47, getAllcardextension());
                    }
                    if (hasShopHours()) {
                        size += d.l(48, getShopHours());
                    }
                    if (hasVsContent()) {
                        size += d.l(49, getVsContent());
                    }
                    if (hasPhoneDetail()) {
                        size += d.h(50, getPhoneDetail());
                    }
                    if (hasPhoneRisk()) {
                        size += d.h(51, getPhoneRisk());
                    }
                    if (hasNewBusinessTime()) {
                        size += d.l(52, getNewBusinessTime());
                    }
                    if (hasMiniprogram()) {
                        size += d.l(53, getMiniprogram());
                    }
                    if (hasMnpKeyInfo()) {
                        size += d.h(54, getMnpKeyInfo());
                    }
                    if (hasBlinkBuilding()) {
                        size += d.h(55, getBlinkBuilding());
                    }
                    if (hasChejiNeed()) {
                        size += d.h(56, getChejiNeed());
                    }
                    this.cachedSize = size;
                    return size;
                }

                public String getShopHours() {
                    return this.shopHours_;
                }

                public String getShowInfo() {
                    return this.showInfo_;
                }

                public String getSpecialService() {
                    return this.specialService_;
                }

                public String getSpecialTag() {
                    return this.specialTag_;
                }

                public String getStatusLabel() {
                    return this.statusLabel_;
                }

                public String getTag() {
                    return this.tag_;
                }

                public String getTradeTag() {
                    return this.tradeTag_;
                }

                public Upperleftcorner getUpperleftcorner() {
                    return this.upperleftcorner_;
                }

                public String getValidate() {
                    return this.validate_;
                }

                public String getVsContent() {
                    return this.vsContent_;
                }

                public String getWapBookable() {
                    return this.wapBookable_;
                }

                public String getWiseFullroom() {
                    return this.wiseFullroom_;
                }

                public String getWiseHourlyBookable() {
                    return this.wiseHourlyBookable_;
                }

                public boolean hasAllcardextension() {
                    return this.hasAllcardextension;
                }

                public boolean hasAoi() {
                    return this.hasAoi;
                }

                public boolean hasBlinkBuilding() {
                    return this.hasBlinkBuilding;
                }

                public boolean hasBookInfo() {
                    return this.hasBookInfo;
                }

                public boolean hasBusinessService() {
                    return this.hasBusinessService;
                }

                public boolean hasChejiNeed() {
                    return this.hasChejiNeed;
                }

                public boolean hasCommentNum() {
                    return this.hasCommentNum;
                }

                public boolean hasDisText() {
                    return this.hasDisText;
                }

                public boolean hasDiscount() {
                    return this.hasDiscount;
                }

                public boolean hasDiscountTotal() {
                    return this.hasDiscountTotal;
                }

                public boolean hasDisplayInfoCommentLabel() {
                    return this.hasDisplayInfoCommentLabel;
                }

                public boolean hasDisplayInfoRedu() {
                    return this.hasDisplayInfoRedu;
                }

                public boolean hasFlagOnLeft() {
                    return this.hasFlagOnLeft;
                }

                public boolean hasGrade() {
                    return this.hasGrade;
                }

                public boolean hasGrouponFlag() {
                    return this.hasGrouponFlag;
                }

                public boolean hasGrouponInfo() {
                    return this.hasGrouponInfo;
                }

                public boolean hasGrouponTotal() {
                    return this.hasGrouponTotal;
                }

                public boolean hasGuide() {
                    return this.hasGuide;
                }

                public boolean hasImage() {
                    return this.hasImage;
                }

                public boolean hasLbcBusinessVip() {
                    return this.hasLbcBusinessVip;
                }

                public boolean hasMarketbiz() {
                    return this.hasMarketbiz;
                }

                public boolean hasMbc() {
                    return this.hasMbc;
                }

                public boolean hasMeishipaihao() {
                    return this.hasMeishipaihao;
                }

                public boolean hasMiniprogram() {
                    return this.hasMiniprogram;
                }

                public boolean hasMnpKeyInfo() {
                    return this.hasMnpKeyInfo;
                }

                public boolean hasMovieFilmCount() {
                    return this.hasMovieFilmCount;
                }

                public boolean hasMovieFlag() {
                    return this.hasMovieFlag;
                }

                public boolean hasNewBusinessTime() {
                    return this.hasNewBusinessTime;
                }

                public boolean hasOriginPriceText() {
                    return this.hasOriginPriceText;
                }

                public boolean hasOrilInfo() {
                    return this.hasOrilInfo;
                }

                public boolean hasOverallRating() {
                    return this.hasOverallRating;
                }

                public boolean hasPhoneDetail() {
                    return this.hasPhoneDetail;
                }

                public boolean hasPhoneRisk() {
                    return this.hasPhoneRisk;
                }

                public boolean hasPremiumFlag() {
                    return this.hasPremiumFlag;
                }

                public boolean hasPremiumInfo() {
                    return this.hasPremiumInfo;
                }

                public boolean hasPrice() {
                    return this.hasPrice;
                }

                public boolean hasPriceText() {
                    return this.hasPriceText;
                }

                public boolean hasRecommendDish() {
                    return this.hasRecommendDish;
                }

                public boolean hasShopHours() {
                    return this.hasShopHours;
                }

                public boolean hasShowInfo() {
                    return this.hasShowInfo;
                }

                public boolean hasSpecialService() {
                    return this.hasSpecialService;
                }

                public boolean hasSpecialTag() {
                    return this.hasSpecialTag;
                }

                public boolean hasStatusLabel() {
                    return this.hasStatusLabel;
                }

                public boolean hasTag() {
                    return this.hasTag;
                }

                public boolean hasTradeTag() {
                    return this.hasTradeTag;
                }

                public boolean hasUpperleftcorner() {
                    return this.hasUpperleftcorner;
                }

                public boolean hasValidate() {
                    return this.hasValidate;
                }

                public boolean hasVsContent() {
                    return this.hasVsContent;
                }

                public boolean hasWapBookable() {
                    return this.hasWapBookable;
                }

                public boolean hasWiseFullroom() {
                    return this.hasWiseFullroom;
                }

                public boolean hasWiseHourlyBookable() {
                    return this.hasWiseHourlyBookable;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public DetailInfo setActivity(int i4, Activity activity) {
                    if (activity == null) {
                        return this;
                    }
                    this.activity_.set(i4, activity);
                    return this;
                }

                public DetailInfo setAllcardextension(Allcardextension allcardextension) {
                    if (allcardextension == null) {
                        return clearAllcardextension();
                    }
                    this.hasAllcardextension = true;
                    this.allcardextension_ = allcardextension;
                    return this;
                }

                public DetailInfo setAoi(String str) {
                    this.hasAoi = true;
                    this.aoi_ = str;
                    return this;
                }

                public DetailInfo setBlinkBuilding(BlinkBuilding blinkBuilding) {
                    if (blinkBuilding == null) {
                        return clearBlinkBuilding();
                    }
                    this.hasBlinkBuilding = true;
                    this.blinkBuilding_ = blinkBuilding;
                    return this;
                }

                public DetailInfo setBookInfo(BookInfo bookInfo) {
                    if (bookInfo == null) {
                        return clearBookInfo();
                    }
                    this.hasBookInfo = true;
                    this.bookInfo_ = bookInfo;
                    return this;
                }

                public DetailInfo setBusinessService(BusinessService businessService) {
                    if (businessService == null) {
                        return clearBusinessService();
                    }
                    this.hasBusinessService = true;
                    this.businessService_ = businessService;
                    return this;
                }

                public DetailInfo setChejiNeed(ChejiNeed chejiNeed) {
                    if (chejiNeed == null) {
                        return clearChejiNeed();
                    }
                    this.hasChejiNeed = true;
                    this.chejiNeed_ = chejiNeed;
                    return this;
                }

                public DetailInfo setCommentNum(String str) {
                    this.hasCommentNum = true;
                    this.commentNum_ = str;
                    return this;
                }

                public DetailInfo setDisText(String str) {
                    this.hasDisText = true;
                    this.disText_ = str;
                    return this;
                }

                public DetailInfo setDiscount(String str) {
                    this.hasDiscount = true;
                    this.discount_ = str;
                    return this;
                }

                public DetailInfo setDiscountTotal(int i4) {
                    this.hasDiscountTotal = true;
                    this.discountTotal_ = i4;
                    return this;
                }

                public DetailInfo setDisplayInfoCommentLabel(DisplayInfoCommentLabel displayInfoCommentLabel) {
                    if (displayInfoCommentLabel == null) {
                        return clearDisplayInfoCommentLabel();
                    }
                    this.hasDisplayInfoCommentLabel = true;
                    this.displayInfoCommentLabel_ = displayInfoCommentLabel;
                    return this;
                }

                public DetailInfo setDisplayInfoRedu(String str) {
                    this.hasDisplayInfoRedu = true;
                    this.displayInfoRedu_ = str;
                    return this;
                }

                public DetailInfo setFlag(int i4, String str) {
                    str.getClass();
                    this.flag_.set(i4, str);
                    return this;
                }

                public DetailInfo setFlagOnLeft(String str) {
                    this.hasFlagOnLeft = true;
                    this.flagOnLeft_ = str;
                    return this;
                }

                public DetailInfo setGrade(String str) {
                    this.hasGrade = true;
                    this.grade_ = str;
                    return this;
                }

                public DetailInfo setGrouponFlag(int i4) {
                    this.hasGrouponFlag = true;
                    this.grouponFlag_ = i4;
                    return this;
                }

                public DetailInfo setGrouponInfo(GrouponInfo grouponInfo) {
                    if (grouponInfo == null) {
                        return clearGrouponInfo();
                    }
                    this.hasGrouponInfo = true;
                    this.grouponInfo_ = grouponInfo;
                    return this;
                }

                public DetailInfo setGrouponTotal(int i4) {
                    this.hasGrouponTotal = true;
                    this.grouponTotal_ = i4;
                    return this;
                }

                public DetailInfo setGuide(String str) {
                    this.hasGuide = true;
                    this.guide_ = str;
                    return this;
                }

                public DetailInfo setHotelService(int i4, HotelService hotelService) {
                    if (hotelService == null) {
                        return this;
                    }
                    this.hotelService_.set(i4, hotelService);
                    return this;
                }

                public DetailInfo setImage(String str) {
                    this.hasImage = true;
                    this.image_ = str;
                    return this;
                }

                public DetailInfo setImpression(int i4, Impression impression) {
                    if (impression == null) {
                        return this;
                    }
                    this.impression_.set(i4, impression);
                    return this;
                }

                public DetailInfo setLbcBusinessVip(LbcBusinessVip lbcBusinessVip) {
                    if (lbcBusinessVip == null) {
                        return clearLbcBusinessVip();
                    }
                    this.hasLbcBusinessVip = true;
                    this.lbcBusinessVip_ = lbcBusinessVip;
                    return this;
                }

                public DetailInfo setMarketbiz(Marketbiz marketbiz) {
                    if (marketbiz == null) {
                        return clearMarketbiz();
                    }
                    this.hasMarketbiz = true;
                    this.marketbiz_ = marketbiz;
                    return this;
                }

                public DetailInfo setMbc(Mbc mbc) {
                    if (mbc == null) {
                        return clearMbc();
                    }
                    this.hasMbc = true;
                    this.mbc_ = mbc;
                    return this;
                }

                public DetailInfo setMeishipaihao(Meishipaihao meishipaihao) {
                    if (meishipaihao == null) {
                        return clearMeishipaihao();
                    }
                    this.hasMeishipaihao = true;
                    this.meishipaihao_ = meishipaihao;
                    return this;
                }

                public DetailInfo setMiniprogram(String str) {
                    this.hasMiniprogram = true;
                    this.miniprogram_ = str;
                    return this;
                }

                public DetailInfo setMnpKeyInfo(MnpKeyInfo mnpKeyInfo) {
                    if (mnpKeyInfo == null) {
                        return clearMnpKeyInfo();
                    }
                    this.hasMnpKeyInfo = true;
                    this.mnpKeyInfo_ = mnpKeyInfo;
                    return this;
                }

                public DetailInfo setMovieFilmCount(int i4) {
                    this.hasMovieFilmCount = true;
                    this.movieFilmCount_ = i4;
                    return this;
                }

                public DetailInfo setMovieFlag(String str) {
                    this.hasMovieFlag = true;
                    this.movieFlag_ = str;
                    return this;
                }

                public DetailInfo setNewBusinessTime(String str) {
                    this.hasNewBusinessTime = true;
                    this.newBusinessTime_ = str;
                    return this;
                }

                public DetailInfo setOriginPriceText(String str) {
                    this.hasOriginPriceText = true;
                    this.originPriceText_ = str;
                    return this;
                }

                public DetailInfo setOrilInfo(OrilInfo orilInfo) {
                    if (orilInfo == null) {
                        return clearOrilInfo();
                    }
                    this.hasOrilInfo = true;
                    this.orilInfo_ = orilInfo;
                    return this;
                }

                public DetailInfo setOverallRating(String str) {
                    this.hasOverallRating = true;
                    this.overallRating_ = str;
                    return this;
                }

                public DetailInfo setPhoneDetail(PhoneDetail phoneDetail) {
                    if (phoneDetail == null) {
                        return clearPhoneDetail();
                    }
                    this.hasPhoneDetail = true;
                    this.phoneDetail_ = phoneDetail;
                    return this;
                }

                public DetailInfo setPhoneRisk(PhoneRisk phoneRisk) {
                    if (phoneRisk == null) {
                        return clearPhoneRisk();
                    }
                    this.hasPhoneRisk = true;
                    this.phoneRisk_ = phoneRisk;
                    return this;
                }

                public DetailInfo setPremiumFlag(int i4) {
                    this.hasPremiumFlag = true;
                    this.premiumFlag_ = i4;
                    return this;
                }

                public DetailInfo setPremiumInfo(PremiumInfo premiumInfo) {
                    if (premiumInfo == null) {
                        return clearPremiumInfo();
                    }
                    this.hasPremiumInfo = true;
                    this.premiumInfo_ = premiumInfo;
                    return this;
                }

                public DetailInfo setPrice(String str) {
                    this.hasPrice = true;
                    this.price_ = str;
                    return this;
                }

                public DetailInfo setPriceText(String str) {
                    this.hasPriceText = true;
                    this.priceText_ = str;
                    return this;
                }

                public DetailInfo setRecommendDish(RecommendDish recommendDish) {
                    if (recommendDish == null) {
                        return clearRecommendDish();
                    }
                    this.hasRecommendDish = true;
                    this.recommendDish_ = recommendDish;
                    return this;
                }

                public DetailInfo setShopHours(String str) {
                    this.hasShopHours = true;
                    this.shopHours_ = str;
                    return this;
                }

                public DetailInfo setShowInfo(String str) {
                    this.hasShowInfo = true;
                    this.showInfo_ = str;
                    return this;
                }

                public DetailInfo setSpecialService(String str) {
                    this.hasSpecialService = true;
                    this.specialService_ = str;
                    return this;
                }

                public DetailInfo setSpecialTag(String str) {
                    this.hasSpecialTag = true;
                    this.specialTag_ = str;
                    return this;
                }

                public DetailInfo setStatusLabel(String str) {
                    this.hasStatusLabel = true;
                    this.statusLabel_ = str;
                    return this;
                }

                public DetailInfo setTag(String str) {
                    this.hasTag = true;
                    this.tag_ = str;
                    return this;
                }

                public DetailInfo setTradeTag(String str) {
                    this.hasTradeTag = true;
                    this.tradeTag_ = str;
                    return this;
                }

                public DetailInfo setUpperleftcorner(Upperleftcorner upperleftcorner) {
                    if (upperleftcorner == null) {
                        return clearUpperleftcorner();
                    }
                    this.hasUpperleftcorner = true;
                    this.upperleftcorner_ = upperleftcorner;
                    return this;
                }

                public DetailInfo setValidate(String str) {
                    this.hasValidate = true;
                    this.validate_ = str;
                    return this;
                }

                public DetailInfo setVsContent(String str) {
                    this.hasVsContent = true;
                    this.vsContent_ = str;
                    return this;
                }

                public DetailInfo setWapBookable(String str) {
                    this.hasWapBookable = true;
                    this.wapBookable_ = str;
                    return this;
                }

                public DetailInfo setWiseFullroom(String str) {
                    this.hasWiseFullroom = true;
                    this.wiseFullroom_ = str;
                    return this;
                }

                public DetailInfo setWiseHourlyBookable(String str) {
                    this.hasWiseHourlyBookable = true;
                    this.wiseHourlyBookable_ = str;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    Iterator<String> it = getFlagList().iterator();
                    while (it.hasNext()) {
                        dVar.A(1, it.next());
                    }
                    if (hasOverallRating()) {
                        dVar.A(2, getOverallRating());
                    }
                    if (hasPriceText()) {
                        dVar.A(3, getPriceText());
                    }
                    if (hasTag()) {
                        dVar.A(4, getTag());
                    }
                    if (hasImage()) {
                        dVar.A(5, getImage());
                    }
                    if (hasShowInfo()) {
                        dVar.A(6, getShowInfo());
                    }
                    if (hasPremiumFlag()) {
                        dVar.s(7, getPremiumFlag());
                    }
                    if (hasDiscountTotal()) {
                        dVar.s(8, getDiscountTotal());
                    }
                    if (hasGrouponTotal()) {
                        dVar.s(9, getGrouponTotal());
                    }
                    if (hasPremiumInfo()) {
                        dVar.u(10, getPremiumInfo());
                    }
                    if (hasCommentNum()) {
                        dVar.A(11, getCommentNum());
                    }
                    if (hasMovieFlag()) {
                        dVar.A(12, getMovieFlag());
                    }
                    if (hasMovieFilmCount()) {
                        dVar.s(13, getMovieFilmCount());
                    }
                    if (hasGrouponFlag()) {
                        dVar.s(14, getGrouponFlag());
                    }
                    if (hasGrouponInfo()) {
                        dVar.u(15, getGrouponInfo());
                    }
                    if (hasOrilInfo()) {
                        dVar.u(16, getOrilInfo());
                    }
                    if (hasWapBookable()) {
                        dVar.A(17, getWapBookable());
                    }
                    if (hasBookInfo()) {
                        dVar.u(18, getBookInfo());
                    }
                    if (hasPrice()) {
                        dVar.A(19, getPrice());
                    }
                    if (hasWiseFullroom()) {
                        dVar.A(20, getWiseFullroom());
                    }
                    if (hasDiscount()) {
                        dVar.A(21, getDiscount());
                    }
                    if (hasGrade()) {
                        dVar.A(22, getGrade());
                    }
                    Iterator<Activity> it2 = getActivityList().iterator();
                    while (it2.hasNext()) {
                        dVar.u(23, it2.next());
                    }
                    if (hasGuide()) {
                        dVar.A(24, getGuide());
                    }
                    if (hasSpecialService()) {
                        dVar.A(25, getSpecialService());
                    }
                    if (hasFlagOnLeft()) {
                        dVar.A(26, getFlagOnLeft());
                    }
                    Iterator<Impression> it3 = getImpressionList().iterator();
                    while (it3.hasNext()) {
                        dVar.u(27, it3.next());
                    }
                    if (hasMeishipaihao()) {
                        dVar.u(28, getMeishipaihao());
                    }
                    if (hasTradeTag()) {
                        dVar.A(29, getTradeTag());
                    }
                    if (hasMarketbiz()) {
                        dVar.u(30, getMarketbiz());
                    }
                    if (hasValidate()) {
                        dVar.A(31, getValidate());
                    }
                    if (hasWiseHourlyBookable()) {
                        dVar.A(32, getWiseHourlyBookable());
                    }
                    if (hasDisText()) {
                        dVar.A(33, getDisText());
                    }
                    if (hasLbcBusinessVip()) {
                        dVar.u(34, getLbcBusinessVip());
                    }
                    if (hasRecommendDish()) {
                        dVar.u(36, getRecommendDish());
                    }
                    if (hasBusinessService()) {
                        dVar.u(37, getBusinessService());
                    }
                    if (hasStatusLabel()) {
                        dVar.A(38, getStatusLabel());
                    }
                    if (hasUpperleftcorner()) {
                        dVar.u(39, getUpperleftcorner());
                    }
                    if (hasDisplayInfoRedu()) {
                        dVar.A(40, getDisplayInfoRedu());
                    }
                    if (hasDisplayInfoCommentLabel()) {
                        dVar.u(41, getDisplayInfoCommentLabel());
                    }
                    if (hasMbc()) {
                        dVar.u(42, getMbc());
                    }
                    if (hasAoi()) {
                        dVar.A(43, getAoi());
                    }
                    if (hasSpecialTag()) {
                        dVar.A(44, getSpecialTag());
                    }
                    if (hasOriginPriceText()) {
                        dVar.A(45, getOriginPriceText());
                    }
                    Iterator<HotelService> it4 = getHotelServiceList().iterator();
                    while (it4.hasNext()) {
                        dVar.u(46, it4.next());
                    }
                    if (hasAllcardextension()) {
                        dVar.u(47, getAllcardextension());
                    }
                    if (hasShopHours()) {
                        dVar.A(48, getShopHours());
                    }
                    if (hasVsContent()) {
                        dVar.A(49, getVsContent());
                    }
                    if (hasPhoneDetail()) {
                        dVar.u(50, getPhoneDetail());
                    }
                    if (hasPhoneRisk()) {
                        dVar.u(51, getPhoneRisk());
                    }
                    if (hasNewBusinessTime()) {
                        dVar.A(52, getNewBusinessTime());
                    }
                    if (hasMiniprogram()) {
                        dVar.A(53, getMiniprogram());
                    }
                    if (hasMnpKeyInfo()) {
                        dVar.u(54, getMnpKeyInfo());
                    }
                    if (hasBlinkBuilding()) {
                        dVar.u(55, getBlinkBuilding());
                    }
                    if (hasChejiNeed()) {
                        dVar.u(56, getChejiNeed());
                    }
                }

                public static DetailInfo parseFrom(byte[] bArr) throws e {
                    return (DetailInfo) new DetailInfo().mergeFrom(bArr);
                }

                @Override // L1.f
                public DetailInfo mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        switch (iO) {
                            case 0:
                                return this;
                            case 10:
                                addFlag(bVar.n());
                                break;
                            case 18:
                                setOverallRating(bVar.n());
                                break;
                            case 26:
                                setPriceText(bVar.n());
                                break;
                            case 34:
                                setTag(bVar.n());
                                break;
                            case 42:
                                setImage(bVar.n());
                                break;
                            case 50:
                                setShowInfo(bVar.n());
                                break;
                            case 56:
                                setPremiumFlag(bVar.k());
                                break;
                            case 64:
                                setDiscountTotal(bVar.k());
                                break;
                            case 72:
                                setGrouponTotal(bVar.k());
                                break;
                            case Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                                PremiumInfo premiumInfo = new PremiumInfo();
                                bVar.f(premiumInfo);
                                setPremiumInfo(premiumInfo);
                                break;
                            case 90:
                                setCommentNum(bVar.n());
                                break;
                            case 98:
                                setMovieFlag(bVar.n());
                                break;
                            case 104:
                                setMovieFilmCount(bVar.k());
                                break;
                            case 112:
                                setGrouponFlag(bVar.k());
                                break;
                            case 122:
                                GrouponInfo grouponInfo = new GrouponInfo();
                                bVar.f(grouponInfo);
                                setGrouponInfo(grouponInfo);
                                break;
                            case 130:
                                OrilInfo orilInfo = new OrilInfo();
                                bVar.f(orilInfo);
                                setOrilInfo(orilInfo);
                                break;
                            case 138:
                                setWapBookable(bVar.n());
                                break;
                            case 146:
                                BookInfo bookInfo = new BookInfo();
                                bVar.f(bookInfo);
                                setBookInfo(bookInfo);
                                break;
                            case Opcodes.IFNE /* 154 */:
                                setPrice(bVar.n());
                                break;
                            case 162:
                                setWiseFullroom(bVar.n());
                                break;
                            case 170:
                                setDiscount(bVar.n());
                                break;
                            case Opcodes.GETSTATIC /* 178 */:
                                setGrade(bVar.n());
                                break;
                            case 186:
                                Activity activity = new Activity();
                                bVar.f(activity);
                                addActivity(activity);
                                break;
                            case 194:
                                setGuide(bVar.n());
                                break;
                            case LicenseCode.CODE_LICENSE_SERVICE_LICENSE_SIGN_ERROR /* 202 */:
                                setSpecialService(bVar.n());
                                break;
                            case 210:
                                setFlagOnLeft(bVar.n());
                                break;
                            case 218:
                                Impression impression = new Impression();
                                bVar.f(impression);
                                addImpression(impression);
                                break;
                            case 226:
                                Meishipaihao meishipaihao = new Meishipaihao();
                                bVar.f(meishipaihao);
                                setMeishipaihao(meishipaihao);
                                break;
                            case 234:
                                setTradeTag(bVar.n());
                                break;
                            case 242:
                                Marketbiz marketbiz = new Marketbiz();
                                bVar.f(marketbiz);
                                setMarketbiz(marketbiz);
                                break;
                            case 250:
                                setValidate(bVar.n());
                                break;
                            case 258:
                                setWiseHourlyBookable(bVar.n());
                                break;
                            case 266:
                                setDisText(bVar.n());
                                break;
                            case 274:
                                LbcBusinessVip lbcBusinessVip = new LbcBusinessVip();
                                bVar.f(lbcBusinessVip);
                                setLbcBusinessVip(lbcBusinessVip);
                                break;
                            case 290:
                                RecommendDish recommendDish = new RecommendDish();
                                bVar.f(recommendDish);
                                setRecommendDish(recommendDish);
                                break;
                            case 298:
                                BusinessService businessService = new BusinessService();
                                bVar.f(businessService);
                                setBusinessService(businessService);
                                break;
                            case 306:
                                setStatusLabel(bVar.n());
                                break;
                            case 314:
                                Upperleftcorner upperleftcorner = new Upperleftcorner();
                                bVar.f(upperleftcorner);
                                setUpperleftcorner(upperleftcorner);
                                break;
                            case 322:
                                setDisplayInfoRedu(bVar.n());
                                break;
                            case 330:
                                DisplayInfoCommentLabel displayInfoCommentLabel = new DisplayInfoCommentLabel();
                                bVar.f(displayInfoCommentLabel);
                                setDisplayInfoCommentLabel(displayInfoCommentLabel);
                                break;
                            case 338:
                                Mbc mbc = new Mbc();
                                bVar.f(mbc);
                                setMbc(mbc);
                                break;
                            case 346:
                                setAoi(bVar.n());
                                break;
                            case 354:
                                setSpecialTag(bVar.n());
                                break;
                            case 362:
                                setOriginPriceText(bVar.n());
                                break;
                            case 370:
                                HotelService hotelService = new HotelService();
                                bVar.f(hotelService);
                                addHotelService(hotelService);
                                break;
                            case 378:
                                Allcardextension allcardextension = new Allcardextension();
                                bVar.f(allcardextension);
                                setAllcardextension(allcardextension);
                                break;
                            case 386:
                                setShopHours(bVar.n());
                                break;
                            case 394:
                                setVsContent(bVar.n());
                                break;
                            case 402:
                                PhoneDetail phoneDetail = new PhoneDetail();
                                bVar.f(phoneDetail);
                                setPhoneDetail(phoneDetail);
                                break;
                            case 410:
                                PhoneRisk phoneRisk = new PhoneRisk();
                                bVar.f(phoneRisk);
                                setPhoneRisk(phoneRisk);
                                break;
                            case 418:
                                setNewBusinessTime(bVar.n());
                                break;
                            case 426:
                                setMiniprogram(bVar.n());
                                break;
                            case 434:
                                MnpKeyInfo mnpKeyInfo = new MnpKeyInfo();
                                bVar.f(mnpKeyInfo);
                                setMnpKeyInfo(mnpKeyInfo);
                                break;
                            case 442:
                                BlinkBuilding blinkBuilding = new BlinkBuilding();
                                bVar.f(blinkBuilding);
                                setBlinkBuilding(blinkBuilding);
                                break;
                            case 450:
                                ChejiNeed chejiNeed = new ChejiNeed();
                                bVar.f(chejiNeed);
                                setChejiNeed(chejiNeed);
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

            public static Ext parseFrom(b bVar) throws IOException {
                return new Ext().mergeFrom(bVar);
            }

            public final Ext clear() {
                clearDetailInfo();
                clearSrcName();
                clearAdvInfo();
                this.cachedSize = -1;
                return this;
            }

            public Ext clearAdvInfo() {
                this.hasAdvInfo = false;
                this.advInfo_ = null;
                return this;
            }

            public Ext clearDetailInfo() {
                this.hasDetailInfo = false;
                this.detailInfo_ = null;
                return this;
            }

            public Ext clearSrcName() {
                this.hasSrcName = false;
                this.srcName_ = "";
                return this;
            }

            public AdvInfo getAdvInfo() {
                return this.advInfo_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public DetailInfo getDetailInfo() {
                return this.detailInfo_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasSrcName() ? d.l(1, getSrcName()) : 0;
                if (hasDetailInfo()) {
                    iL += d.h(2, getDetailInfo());
                }
                if (hasAdvInfo()) {
                    iL += d.h(3, getAdvInfo());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getSrcName() {
                return this.srcName_;
            }

            public boolean hasAdvInfo() {
                return this.hasAdvInfo;
            }

            public boolean hasDetailInfo() {
                return this.hasDetailInfo;
            }

            public boolean hasSrcName() {
                return this.hasSrcName;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Ext setAdvInfo(AdvInfo advInfo) {
                if (advInfo == null) {
                    return clearAdvInfo();
                }
                this.hasAdvInfo = true;
                this.advInfo_ = advInfo;
                return this;
            }

            public Ext setDetailInfo(DetailInfo detailInfo) {
                if (detailInfo == null) {
                    return clearDetailInfo();
                }
                this.hasDetailInfo = true;
                this.detailInfo_ = detailInfo;
                return this;
            }

            public Ext setSrcName(String str) {
                this.hasSrcName = true;
                this.srcName_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasSrcName()) {
                    dVar.A(1, getSrcName());
                }
                if (hasDetailInfo()) {
                    dVar.u(2, getDetailInfo());
                }
                if (hasAdvInfo()) {
                    dVar.u(3, getAdvInfo());
                }
            }

            public static Ext parseFrom(byte[] bArr) throws e {
                return (Ext) new Ext().mergeFrom(bArr);
            }

            @Override // L1.f
            public Ext mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setSrcName(bVar.n());
                    } else if (iO == 18) {
                        DetailInfo detailInfo = new DetailInfo();
                        bVar.f(detailInfo);
                        setDetailInfo(detailInfo);
                    } else if (iO == 26) {
                        AdvInfo advInfo = new AdvInfo();
                        bVar.f(advInfo);
                        setAdvInfo(advInfo);
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class FixedBarButton extends f {
            public static final int ALL_POS = 0;
            public static final int BAR_FIELD_NUMBER = 1;
            public static final int DETAIL_POS = 2;
            public static final int NEARBY = 0;
            public static final int POS_FIELD_NUMBER = 2;
            public static final int SLIDE_POS = 1;
            public static final int TYPE_FIELD_NUMBER = 3;
            private boolean hasBar;
            private boolean hasPos;
            private boolean hasType;
            private Button bar_ = null;
            private int pos_ = 0;
            private int type_ = 0;
            private int cachedSize = -1;

            public static FixedBarButton parseFrom(b bVar) throws IOException {
                return new FixedBarButton().mergeFrom(bVar);
            }

            public final FixedBarButton clear() {
                clearBar();
                clearPos();
                clearType();
                this.cachedSize = -1;
                return this;
            }

            public FixedBarButton clearBar() {
                this.hasBar = false;
                this.bar_ = null;
                return this;
            }

            public FixedBarButton clearPos() {
                this.hasPos = false;
                this.pos_ = 0;
                return this;
            }

            public FixedBarButton clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            public Button getBar() {
                return this.bar_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getPos() {
                return this.pos_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iH = hasBar() ? d.h(1, getBar()) : 0;
                if (hasPos()) {
                    iH += d.e(2, getPos());
                }
                if (hasType()) {
                    iH += d.e(3, getType());
                }
                this.cachedSize = iH;
                return iH;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasBar() {
                return this.hasBar;
            }

            public boolean hasPos() {
                return this.hasPos;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            public FixedBarButton setBar(Button button) {
                if (button == null) {
                    return clearBar();
                }
                this.hasBar = true;
                this.bar_ = button;
                return this;
            }

            public FixedBarButton setPos(int i4) {
                this.hasPos = true;
                this.pos_ = i4;
                return this;
            }

            public FixedBarButton setType(int i4) {
                this.hasType = true;
                this.type_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasBar()) {
                    dVar.u(1, getBar());
                }
                if (hasPos()) {
                    dVar.s(2, getPos());
                }
                if (hasType()) {
                    dVar.s(3, getType());
                }
            }

            public static FixedBarButton parseFrom(byte[] bArr) throws e {
                return (FixedBarButton) new FixedBarButton().mergeFrom(bArr);
            }

            @Override // L1.f
            public FixedBarButton mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        Button button = new Button();
                        bVar.f(button);
                        setBar(button);
                    } else if (iO == 16) {
                        setPos(bVar.k());
                    } else if (iO == 24) {
                        setType(bVar.k());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class GuildButton extends f {
            public static final int ACTION_TYPE_FIELD_NUMBER = 1;
            public static final int ACTION_VALUE_FIELD_NUMBER = 2;
            public static final int CLICK_KEY_FIELD_NUMBER = 6;
            public static final int CLICK_PARAM_FIELD_NUMBER = 8;
            public static final int ICON_URL_FIELD_NUMBER = 4;
            public static final int OPENAPI = 0;
            public static final int SHOW_KEY_FIELD_NUMBER = 5;
            public static final int SHOW_PARAM_FIELD_NUMBER = 7;
            public static final int TITLE_FIELD_NUMBER = 3;
            private boolean hasActionType;
            private boolean hasActionValue;
            private boolean hasClickKey;
            private boolean hasClickParam;
            private boolean hasIconUrl;
            private boolean hasShowKey;
            private boolean hasShowParam;
            private boolean hasTitle;
            private int actionType_ = 0;
            private String actionValue_ = "";
            private String title_ = "";
            private String iconUrl_ = "";
            private String showKey_ = "";
            private String clickKey_ = "";
            private String showParam_ = "";
            private String clickParam_ = "";
            private int cachedSize = -1;

            public static GuildButton parseFrom(b bVar) throws IOException {
                return new GuildButton().mergeFrom(bVar);
            }

            public final GuildButton clear() {
                clearActionType();
                clearActionValue();
                clearTitle();
                clearIconUrl();
                clearShowKey();
                clearClickKey();
                clearShowParam();
                clearClickParam();
                this.cachedSize = -1;
                return this;
            }

            public GuildButton clearActionType() {
                this.hasActionType = false;
                this.actionType_ = 0;
                return this;
            }

            public GuildButton clearActionValue() {
                this.hasActionValue = false;
                this.actionValue_ = "";
                return this;
            }

            public GuildButton clearClickKey() {
                this.hasClickKey = false;
                this.clickKey_ = "";
                return this;
            }

            public GuildButton clearClickParam() {
                this.hasClickParam = false;
                this.clickParam_ = "";
                return this;
            }

            public GuildButton clearIconUrl() {
                this.hasIconUrl = false;
                this.iconUrl_ = "";
                return this;
            }

            public GuildButton clearShowKey() {
                this.hasShowKey = false;
                this.showKey_ = "";
                return this;
            }

            public GuildButton clearShowParam() {
                this.hasShowParam = false;
                this.showParam_ = "";
                return this;
            }

            public GuildButton clearTitle() {
                this.hasTitle = false;
                this.title_ = "";
                return this;
            }

            public int getActionType() {
                return this.actionType_;
            }

            public String getActionValue() {
                return this.actionValue_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getClickKey() {
                return this.clickKey_;
            }

            public String getClickParam() {
                return this.clickParam_;
            }

            public String getIconUrl() {
                return this.iconUrl_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasActionType() ? d.e(1, getActionType()) : 0;
                if (hasActionValue()) {
                    iE += d.l(2, getActionValue());
                }
                if (hasTitle()) {
                    iE += d.l(3, getTitle());
                }
                if (hasIconUrl()) {
                    iE += d.l(4, getIconUrl());
                }
                if (hasShowKey()) {
                    iE += d.l(5, getShowKey());
                }
                if (hasClickKey()) {
                    iE += d.l(6, getClickKey());
                }
                if (hasShowParam()) {
                    iE += d.l(7, getShowParam());
                }
                if (hasClickParam()) {
                    iE += d.l(8, getClickParam());
                }
                this.cachedSize = iE;
                return iE;
            }

            public String getShowKey() {
                return this.showKey_;
            }

            public String getShowParam() {
                return this.showParam_;
            }

            public String getTitle() {
                return this.title_;
            }

            public boolean hasActionType() {
                return this.hasActionType;
            }

            public boolean hasActionValue() {
                return this.hasActionValue;
            }

            public boolean hasClickKey() {
                return this.hasClickKey;
            }

            public boolean hasClickParam() {
                return this.hasClickParam;
            }

            public boolean hasIconUrl() {
                return this.hasIconUrl;
            }

            public boolean hasShowKey() {
                return this.hasShowKey;
            }

            public boolean hasShowParam() {
                return this.hasShowParam;
            }

            public boolean hasTitle() {
                return this.hasTitle;
            }

            public final boolean isInitialized() {
                return true;
            }

            public GuildButton setActionType(int i4) {
                this.hasActionType = true;
                this.actionType_ = i4;
                return this;
            }

            public GuildButton setActionValue(String str) {
                this.hasActionValue = true;
                this.actionValue_ = str;
                return this;
            }

            public GuildButton setClickKey(String str) {
                this.hasClickKey = true;
                this.clickKey_ = str;
                return this;
            }

            public GuildButton setClickParam(String str) {
                this.hasClickParam = true;
                this.clickParam_ = str;
                return this;
            }

            public GuildButton setIconUrl(String str) {
                this.hasIconUrl = true;
                this.iconUrl_ = str;
                return this;
            }

            public GuildButton setShowKey(String str) {
                this.hasShowKey = true;
                this.showKey_ = str;
                return this;
            }

            public GuildButton setShowParam(String str) {
                this.hasShowParam = true;
                this.showParam_ = str;
                return this;
            }

            public GuildButton setTitle(String str) {
                this.hasTitle = true;
                this.title_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasActionType()) {
                    dVar.s(1, getActionType());
                }
                if (hasActionValue()) {
                    dVar.A(2, getActionValue());
                }
                if (hasTitle()) {
                    dVar.A(3, getTitle());
                }
                if (hasIconUrl()) {
                    dVar.A(4, getIconUrl());
                }
                if (hasShowKey()) {
                    dVar.A(5, getShowKey());
                }
                if (hasClickKey()) {
                    dVar.A(6, getClickKey());
                }
                if (hasShowParam()) {
                    dVar.A(7, getShowParam());
                }
                if (hasClickParam()) {
                    dVar.A(8, getClickParam());
                }
            }

            public static GuildButton parseFrom(byte[] bArr) throws e {
                return (GuildButton) new GuildButton().mergeFrom(bArr);
            }

            @Override // L1.f
            public GuildButton mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setActionType(bVar.k());
                    } else if (iO == 18) {
                        setActionValue(bVar.n());
                    } else if (iO == 26) {
                        setTitle(bVar.n());
                    } else if (iO == 34) {
                        setIconUrl(bVar.n());
                    } else if (iO == 42) {
                        setShowKey(bVar.n());
                    } else if (iO == 50) {
                        setClickKey(bVar.n());
                    } else if (iO == 58) {
                        setShowParam(bVar.n());
                    } else if (iO == 66) {
                        setClickParam(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class HeadIcon extends f {
            public static final int COLOR_FIELD_NUMBER = 5;
            public static final int CONTEXT_FIELD_NUMBER = 6;
            public static final int DARK_URL_FIELD_NUMBER = 10;
            public static final int LINKS_FIELD_NUMBER = 3;
            public static final int NO_THIRD_WARNING_FIELD_NUMBER = 9;
            public static final int PARAM_API_FIELD_NUMBER = 8;
            public static final int PID_FIELD_NUMBER = 4;
            public static final int TYPE_FIELD_NUMBER = 2;
            public static final int URL_FIELD_NUMBER = 1;
            public static final int USECONTEXT_FIELD_NUMBER = 7;
            private boolean hasColor;
            private boolean hasContext;
            private boolean hasDarkUrl;
            private boolean hasLinks;
            private boolean hasNoThirdWarning;
            private boolean hasParamApi;
            private boolean hasPid;
            private boolean hasType;
            private boolean hasUrl;
            private boolean hasUsecontext;
            private String url_ = "";
            private int type_ = 0;
            private String links_ = "";
            private String pid_ = "";
            private int color_ = 0;
            private String context_ = "";
            private int usecontext_ = 0;
            private String paramApi_ = "";
            private int noThirdWarning_ = 0;
            private String darkUrl_ = "";
            private int cachedSize = -1;

            public static HeadIcon parseFrom(b bVar) throws IOException {
                return new HeadIcon().mergeFrom(bVar);
            }

            public final HeadIcon clear() {
                clearUrl();
                clearType();
                clearLinks();
                clearPid();
                clearColor();
                clearContext();
                clearUsecontext();
                clearParamApi();
                clearNoThirdWarning();
                clearDarkUrl();
                this.cachedSize = -1;
                return this;
            }

            public HeadIcon clearColor() {
                this.hasColor = false;
                this.color_ = 0;
                return this;
            }

            public HeadIcon clearContext() {
                this.hasContext = false;
                this.context_ = "";
                return this;
            }

            public HeadIcon clearDarkUrl() {
                this.hasDarkUrl = false;
                this.darkUrl_ = "";
                return this;
            }

            public HeadIcon clearLinks() {
                this.hasLinks = false;
                this.links_ = "";
                return this;
            }

            public HeadIcon clearNoThirdWarning() {
                this.hasNoThirdWarning = false;
                this.noThirdWarning_ = 0;
                return this;
            }

            public HeadIcon clearParamApi() {
                this.hasParamApi = false;
                this.paramApi_ = "";
                return this;
            }

            public HeadIcon clearPid() {
                this.hasPid = false;
                this.pid_ = "";
                return this;
            }

            public HeadIcon clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            public HeadIcon clearUrl() {
                this.hasUrl = false;
                this.url_ = "";
                return this;
            }

            public HeadIcon clearUsecontext() {
                this.hasUsecontext = false;
                this.usecontext_ = 0;
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getColor() {
                return this.color_;
            }

            public String getContext() {
                return this.context_;
            }

            public String getDarkUrl() {
                return this.darkUrl_;
            }

            public String getLinks() {
                return this.links_;
            }

            public int getNoThirdWarning() {
                return this.noThirdWarning_;
            }

            public String getParamApi() {
                return this.paramApi_;
            }

            public String getPid() {
                return this.pid_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasUrl() ? d.l(1, getUrl()) : 0;
                if (hasType()) {
                    iL += d.e(2, getType());
                }
                if (hasLinks()) {
                    iL += d.l(3, getLinks());
                }
                if (hasPid()) {
                    iL += d.l(4, getPid());
                }
                if (hasColor()) {
                    iL += d.e(5, getColor());
                }
                if (hasContext()) {
                    iL += d.l(6, getContext());
                }
                if (hasUsecontext()) {
                    iL += d.e(7, getUsecontext());
                }
                if (hasParamApi()) {
                    iL += d.l(8, getParamApi());
                }
                if (hasNoThirdWarning()) {
                    iL += d.e(9, getNoThirdWarning());
                }
                if (hasDarkUrl()) {
                    iL += d.l(10, getDarkUrl());
                }
                this.cachedSize = iL;
                return iL;
            }

            public int getType() {
                return this.type_;
            }

            public String getUrl() {
                return this.url_;
            }

            public int getUsecontext() {
                return this.usecontext_;
            }

            public boolean hasColor() {
                return this.hasColor;
            }

            public boolean hasContext() {
                return this.hasContext;
            }

            public boolean hasDarkUrl() {
                return this.hasDarkUrl;
            }

            public boolean hasLinks() {
                return this.hasLinks;
            }

            public boolean hasNoThirdWarning() {
                return this.hasNoThirdWarning;
            }

            public boolean hasParamApi() {
                return this.hasParamApi;
            }

            public boolean hasPid() {
                return this.hasPid;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public boolean hasUrl() {
                return this.hasUrl;
            }

            public boolean hasUsecontext() {
                return this.hasUsecontext;
            }

            public final boolean isInitialized() {
                return true;
            }

            public HeadIcon setColor(int i4) {
                this.hasColor = true;
                this.color_ = i4;
                return this;
            }

            public HeadIcon setContext(String str) {
                this.hasContext = true;
                this.context_ = str;
                return this;
            }

            public HeadIcon setDarkUrl(String str) {
                this.hasDarkUrl = true;
                this.darkUrl_ = str;
                return this;
            }

            public HeadIcon setLinks(String str) {
                this.hasLinks = true;
                this.links_ = str;
                return this;
            }

            public HeadIcon setNoThirdWarning(int i4) {
                this.hasNoThirdWarning = true;
                this.noThirdWarning_ = i4;
                return this;
            }

            public HeadIcon setParamApi(String str) {
                this.hasParamApi = true;
                this.paramApi_ = str;
                return this;
            }

            public HeadIcon setPid(String str) {
                this.hasPid = true;
                this.pid_ = str;
                return this;
            }

            public HeadIcon setType(int i4) {
                this.hasType = true;
                this.type_ = i4;
                return this;
            }

            public HeadIcon setUrl(String str) {
                this.hasUrl = true;
                this.url_ = str;
                return this;
            }

            public HeadIcon setUsecontext(int i4) {
                this.hasUsecontext = true;
                this.usecontext_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasUrl()) {
                    dVar.A(1, getUrl());
                }
                if (hasType()) {
                    dVar.s(2, getType());
                }
                if (hasLinks()) {
                    dVar.A(3, getLinks());
                }
                if (hasPid()) {
                    dVar.A(4, getPid());
                }
                if (hasColor()) {
                    dVar.s(5, getColor());
                }
                if (hasContext()) {
                    dVar.A(6, getContext());
                }
                if (hasUsecontext()) {
                    dVar.s(7, getUsecontext());
                }
                if (hasParamApi()) {
                    dVar.A(8, getParamApi());
                }
                if (hasNoThirdWarning()) {
                    dVar.s(9, getNoThirdWarning());
                }
                if (hasDarkUrl()) {
                    dVar.A(10, getDarkUrl());
                }
            }

            public static HeadIcon parseFrom(byte[] bArr) throws e {
                return (HeadIcon) new HeadIcon().mergeFrom(bArr);
            }

            @Override // L1.f
            public HeadIcon mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    switch (iO) {
                        case 0:
                            return this;
                        case 10:
                            setUrl(bVar.n());
                            break;
                        case 16:
                            setType(bVar.k());
                            break;
                        case 26:
                            setLinks(bVar.n());
                            break;
                        case 34:
                            setPid(bVar.n());
                            break;
                        case 40:
                            setColor(bVar.k());
                            break;
                        case 50:
                            setContext(bVar.n());
                            break;
                        case 56:
                            setUsecontext(bVar.k());
                            break;
                        case 66:
                            setParamApi(bVar.n());
                            break;
                        case 72:
                            setNoThirdWarning(bVar.k());
                            break;
                        case Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                            setDarkUrl(bVar.n());
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

        public static final class HeadIconBubbleInfo extends f {
            public static final int BURIED_POINT_FIELD_NUMBER = 4;
            public static final int ICON_URL_FIELD_NUMBER = 2;
            public static final int JUMP_URL_FIELD_NUMBER = 3;
            public static final int TEXT_FIELD_NUMBER = 1;
            private boolean hasBuriedPoint;
            private boolean hasIconUrl;
            private boolean hasJumpUrl;
            private boolean hasText;
            private String text_ = "";
            private String iconUrl_ = "";
            private String jumpUrl_ = "";
            private String buriedPoint_ = "";
            private int cachedSize = -1;

            public static HeadIconBubbleInfo parseFrom(b bVar) throws IOException {
                return new HeadIconBubbleInfo().mergeFrom(bVar);
            }

            public final HeadIconBubbleInfo clear() {
                clearText();
                clearIconUrl();
                clearJumpUrl();
                clearBuriedPoint();
                this.cachedSize = -1;
                return this;
            }

            public HeadIconBubbleInfo clearBuriedPoint() {
                this.hasBuriedPoint = false;
                this.buriedPoint_ = "";
                return this;
            }

            public HeadIconBubbleInfo clearIconUrl() {
                this.hasIconUrl = false;
                this.iconUrl_ = "";
                return this;
            }

            public HeadIconBubbleInfo clearJumpUrl() {
                this.hasJumpUrl = false;
                this.jumpUrl_ = "";
                return this;
            }

            public HeadIconBubbleInfo clearText() {
                this.hasText = false;
                this.text_ = "";
                return this;
            }

            public String getBuriedPoint() {
                return this.buriedPoint_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getIconUrl() {
                return this.iconUrl_;
            }

            public String getJumpUrl() {
                return this.jumpUrl_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasText() ? d.l(1, getText()) : 0;
                if (hasIconUrl()) {
                    iL += d.l(2, getIconUrl());
                }
                if (hasJumpUrl()) {
                    iL += d.l(3, getJumpUrl());
                }
                if (hasBuriedPoint()) {
                    iL += d.l(4, getBuriedPoint());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getText() {
                return this.text_;
            }

            public boolean hasBuriedPoint() {
                return this.hasBuriedPoint;
            }

            public boolean hasIconUrl() {
                return this.hasIconUrl;
            }

            public boolean hasJumpUrl() {
                return this.hasJumpUrl;
            }

            public boolean hasText() {
                return this.hasText;
            }

            public final boolean isInitialized() {
                return true;
            }

            public HeadIconBubbleInfo setBuriedPoint(String str) {
                this.hasBuriedPoint = true;
                this.buriedPoint_ = str;
                return this;
            }

            public HeadIconBubbleInfo setIconUrl(String str) {
                this.hasIconUrl = true;
                this.iconUrl_ = str;
                return this;
            }

            public HeadIconBubbleInfo setJumpUrl(String str) {
                this.hasJumpUrl = true;
                this.jumpUrl_ = str;
                return this;
            }

            public HeadIconBubbleInfo setText(String str) {
                this.hasText = true;
                this.text_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasText()) {
                    dVar.A(1, getText());
                }
                if (hasIconUrl()) {
                    dVar.A(2, getIconUrl());
                }
                if (hasJumpUrl()) {
                    dVar.A(3, getJumpUrl());
                }
                if (hasBuriedPoint()) {
                    dVar.A(4, getBuriedPoint());
                }
            }

            public static HeadIconBubbleInfo parseFrom(byte[] bArr) throws e {
                return (HeadIconBubbleInfo) new HeadIconBubbleInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public HeadIconBubbleInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setText(bVar.n());
                    } else if (iO == 18) {
                        setIconUrl(bVar.n());
                    } else if (iO == 26) {
                        setJumpUrl(bVar.n());
                    } else if (iO == 34) {
                        setBuriedPoint(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class HeatMap extends f {
            public static final int POINTS_FIELD_NUMBER = 2;
            public static final int RANKSTR_FIELD_NUMBER = 1;
            public static final int RANK_FIELD_NUMBER = 4;
            public static final int TYPE_FIELD_NUMBER = 3;
            private boolean hasPoints;
            private boolean hasRank;
            private boolean hasRankstr;
            private boolean hasType;
            private Points points_ = null;
            private String rankstr_ = "";
            private int type_ = 0;
            private int rank_ = 0;
            private int cachedSize = -1;

            public static final class Points extends f {
                public static final int BOUND_FIELD_NUMBER = 1;
                public static final int GEO_ELEMENTS_FIELD_NUMBER = 3;
                public static final int TYPE_FIELD_NUMBER = 2;
                private boolean hasType;
                private List<Integer> bound_ = Collections.emptyList();
                private int type_ = 0;
                private List<GeoElements> geoElements_ = Collections.emptyList();
                private int cachedSize = -1;

                public static final class GeoElements extends f {
                    public static final int POINT_FIELD_NUMBER = 1;
                    private List<Integer> point_ = Collections.emptyList();
                    private int cachedSize = -1;

                    public static GeoElements parseFrom(b bVar) throws IOException {
                        return new GeoElements().mergeFrom(bVar);
                    }

                    public GeoElements addPoint(int i4) {
                        if (this.point_.isEmpty()) {
                            this.point_ = new ArrayList();
                        }
                        this.point_.add(Integer.valueOf(i4));
                        return this;
                    }

                    public final GeoElements clear() {
                        clearPoint();
                        this.cachedSize = -1;
                        return this;
                    }

                    public GeoElements clearPoint() {
                        this.point_ = Collections.emptyList();
                        return this;
                    }

                    @Override // L1.f
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getPoint(int i4) {
                        return this.point_.get(i4).intValue();
                    }

                    public int getPointCount() {
                        return this.point_.size();
                    }

                    public List<Integer> getPointList() {
                        return this.point_;
                    }

                    @Override // L1.f
                    public int getSerializedSize() {
                        Iterator<Integer> it = getPointList().iterator();
                        int iG = 0;
                        while (it.hasNext()) {
                            iG = g.g(it.next(), iG);
                        }
                        int size = getPointList().size() + iG;
                        this.cachedSize = size;
                        return size;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public GeoElements setPoint(int i4, int i5) {
                        this.point_.set(i4, Integer.valueOf(i5));
                        return this;
                    }

                    @Override // L1.f
                    public void writeTo(d dVar) throws IOException {
                        Iterator<Integer> it = getPointList().iterator();
                        while (it.hasNext()) {
                            dVar.z(1, it.next().intValue());
                        }
                    }

                    public static GeoElements parseFrom(byte[] bArr) throws e {
                        return (GeoElements) new GeoElements().mergeFrom(bArr);
                    }

                    @Override // L1.f
                    public GeoElements mergeFrom(b bVar) throws IOException {
                        while (true) {
                            int iO = bVar.o();
                            if (iO == 0) {
                                return this;
                            }
                            if (iO == 8) {
                                addPoint(bVar.m());
                            } else if (!parseUnknownField(bVar, iO)) {
                                return this;
                            }
                        }
                    }
                }

                public static Points parseFrom(b bVar) throws IOException {
                    return new Points().mergeFrom(bVar);
                }

                public Points addBound(int i4) {
                    if (this.bound_.isEmpty()) {
                        this.bound_ = new ArrayList();
                    }
                    this.bound_.add(Integer.valueOf(i4));
                    return this;
                }

                public Points addGeoElements(GeoElements geoElements) {
                    if (geoElements == null) {
                        return this;
                    }
                    if (this.geoElements_.isEmpty()) {
                        this.geoElements_ = new ArrayList();
                    }
                    this.geoElements_.add(geoElements);
                    return this;
                }

                public final Points clear() {
                    clearBound();
                    clearType();
                    clearGeoElements();
                    this.cachedSize = -1;
                    return this;
                }

                public Points clearBound() {
                    this.bound_ = Collections.emptyList();
                    return this;
                }

                public Points clearGeoElements() {
                    this.geoElements_ = Collections.emptyList();
                    return this;
                }

                public Points clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                public int getBound(int i4) {
                    return this.bound_.get(i4).intValue();
                }

                public int getBoundCount() {
                    return this.bound_.size();
                }

                public List<Integer> getBoundList() {
                    return this.bound_;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public GeoElements getGeoElements(int i4) {
                    return this.geoElements_.get(i4);
                }

                public int getGeoElementsCount() {
                    return this.geoElements_.size();
                }

                public List<GeoElements> getGeoElementsList() {
                    return this.geoElements_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    Iterator<Integer> it = getBoundList().iterator();
                    int iG = 0;
                    while (it.hasNext()) {
                        iG = g.g(it.next(), iG);
                    }
                    int size = getBoundList().size() + iG;
                    if (hasType()) {
                        size += d.e(2, getType());
                    }
                    Iterator<GeoElements> it2 = getGeoElementsList().iterator();
                    while (it2.hasNext()) {
                        size += d.h(3, it2.next());
                    }
                    this.cachedSize = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Points setBound(int i4, int i5) {
                    this.bound_.set(i4, Integer.valueOf(i5));
                    return this;
                }

                public Points setGeoElements(int i4, GeoElements geoElements) {
                    if (geoElements == null) {
                        return this;
                    }
                    this.geoElements_.set(i4, geoElements);
                    return this;
                }

                public Points setType(int i4) {
                    this.hasType = true;
                    this.type_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    Iterator<Integer> it = getBoundList().iterator();
                    while (it.hasNext()) {
                        dVar.z(1, it.next().intValue());
                    }
                    if (hasType()) {
                        dVar.s(2, getType());
                    }
                    Iterator<GeoElements> it2 = getGeoElementsList().iterator();
                    while (it2.hasNext()) {
                        dVar.u(3, it2.next());
                    }
                }

                public static Points parseFrom(byte[] bArr) throws e {
                    return (Points) new Points().mergeFrom(bArr);
                }

                @Override // L1.f
                public Points mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            addBound(bVar.m());
                        } else if (iO == 16) {
                            setType(bVar.k());
                        } else if (iO == 26) {
                            GeoElements geoElements = new GeoElements();
                            bVar.f(geoElements);
                            addGeoElements(geoElements);
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static HeatMap parseFrom(b bVar) throws IOException {
                return new HeatMap().mergeFrom(bVar);
            }

            public final HeatMap clear() {
                clearPoints();
                clearRankstr();
                clearType();
                clearRank();
                this.cachedSize = -1;
                return this;
            }

            public HeatMap clearPoints() {
                this.hasPoints = false;
                this.points_ = null;
                return this;
            }

            public HeatMap clearRank() {
                this.hasRank = false;
                this.rank_ = 0;
                return this;
            }

            public HeatMap clearRankstr() {
                this.hasRankstr = false;
                this.rankstr_ = "";
                return this;
            }

            public HeatMap clearType() {
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

            public Points getPoints() {
                return this.points_;
            }

            public int getRank() {
                return this.rank_;
            }

            public String getRankstr() {
                return this.rankstr_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasRankstr() ? d.l(1, getRankstr()) : 0;
                if (hasPoints()) {
                    iL += d.h(2, getPoints());
                }
                if (hasType()) {
                    iL += d.e(3, getType());
                }
                if (hasRank()) {
                    iL += d.e(4, getRank());
                }
                this.cachedSize = iL;
                return iL;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasPoints() {
                return this.hasPoints;
            }

            public boolean hasRank() {
                return this.hasRank;
            }

            public boolean hasRankstr() {
                return this.hasRankstr;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            public HeatMap setPoints(Points points) {
                if (points == null) {
                    return clearPoints();
                }
                this.hasPoints = true;
                this.points_ = points;
                return this;
            }

            public HeatMap setRank(int i4) {
                this.hasRank = true;
                this.rank_ = i4;
                return this;
            }

            public HeatMap setRankstr(String str) {
                this.hasRankstr = true;
                this.rankstr_ = str;
                return this;
            }

            public HeatMap setType(int i4) {
                this.hasType = true;
                this.type_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasRankstr()) {
                    dVar.A(1, getRankstr());
                }
                if (hasPoints()) {
                    dVar.u(2, getPoints());
                }
                if (hasType()) {
                    dVar.s(3, getType());
                }
                if (hasRank()) {
                    dVar.s(4, getRank());
                }
            }

            public static HeatMap parseFrom(byte[] bArr) throws e {
                return (HeatMap) new HeatMap().mergeFrom(bArr);
            }

            @Override // L1.f
            public HeatMap mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setRankstr(bVar.n());
                    } else if (iO == 18) {
                        Points points = new Points();
                        bVar.f(points);
                        setPoints(points);
                    } else if (iO == 24) {
                        setType(bVar.k());
                    } else if (iO == 32) {
                        setRank(bVar.k());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class MapPoitag extends f {
            public static final int TAG_FIELD_NUMBER = 1;
            private boolean hasTag;
            private String tag_ = "";
            private int cachedSize = -1;

            public static MapPoitag parseFrom(b bVar) throws IOException {
                return new MapPoitag().mergeFrom(bVar);
            }

            public final MapPoitag clear() {
                clearTag();
                this.cachedSize = -1;
                return this;
            }

            public MapPoitag clearTag() {
                this.hasTag = false;
                this.tag_ = "";
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
                int iL = hasTag() ? d.l(1, getTag()) : 0;
                this.cachedSize = iL;
                return iL;
            }

            public String getTag() {
                return this.tag_;
            }

            public boolean hasTag() {
                return this.hasTag;
            }

            public final boolean isInitialized() {
                return true;
            }

            public MapPoitag setTag(String str) {
                this.hasTag = true;
                this.tag_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasTag()) {
                    dVar.A(1, getTag());
                }
            }

            public static MapPoitag parseFrom(byte[] bArr) throws e {
                return (MapPoitag) new MapPoitag().mergeFrom(bArr);
            }

            @Override // L1.f
            public MapPoitag mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setTag(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class PoiSimilar extends f {
            public static final int ICON_FIELD_NUMBER = 4;
            public static final int NAVI_FIELD_NUMBER = 3;
            public static final int OPENAPI_FIELD_NUMBER = 2;
            public static final int TEXT_FIELD_NUMBER = 1;
            private boolean hasIcon;
            private boolean hasNavi;
            private boolean hasOpenapi;
            private boolean hasText;
            private String text_ = "";
            private String openapi_ = "";
            private String navi_ = "";
            private String icon_ = "";
            private int cachedSize = -1;

            public static PoiSimilar parseFrom(b bVar) throws IOException {
                return new PoiSimilar().mergeFrom(bVar);
            }

            public final PoiSimilar clear() {
                clearText();
                clearOpenapi();
                clearNavi();
                clearIcon();
                this.cachedSize = -1;
                return this;
            }

            public PoiSimilar clearIcon() {
                this.hasIcon = false;
                this.icon_ = "";
                return this;
            }

            public PoiSimilar clearNavi() {
                this.hasNavi = false;
                this.navi_ = "";
                return this;
            }

            public PoiSimilar clearOpenapi() {
                this.hasOpenapi = false;
                this.openapi_ = "";
                return this;
            }

            public PoiSimilar clearText() {
                this.hasText = false;
                this.text_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getIcon() {
                return this.icon_;
            }

            public String getNavi() {
                return this.navi_;
            }

            public String getOpenapi() {
                return this.openapi_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasText() ? d.l(1, getText()) : 0;
                if (hasOpenapi()) {
                    iL += d.l(2, getOpenapi());
                }
                if (hasNavi()) {
                    iL += d.l(3, getNavi());
                }
                if (hasIcon()) {
                    iL += d.l(4, getIcon());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getText() {
                return this.text_;
            }

            public boolean hasIcon() {
                return this.hasIcon;
            }

            public boolean hasNavi() {
                return this.hasNavi;
            }

            public boolean hasOpenapi() {
                return this.hasOpenapi;
            }

            public boolean hasText() {
                return this.hasText;
            }

            public final boolean isInitialized() {
                return true;
            }

            public PoiSimilar setIcon(String str) {
                this.hasIcon = true;
                this.icon_ = str;
                return this;
            }

            public PoiSimilar setNavi(String str) {
                this.hasNavi = true;
                this.navi_ = str;
                return this;
            }

            public PoiSimilar setOpenapi(String str) {
                this.hasOpenapi = true;
                this.openapi_ = str;
                return this;
            }

            public PoiSimilar setText(String str) {
                this.hasText = true;
                this.text_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasText()) {
                    dVar.A(1, getText());
                }
                if (hasOpenapi()) {
                    dVar.A(2, getOpenapi());
                }
                if (hasNavi()) {
                    dVar.A(3, getNavi());
                }
                if (hasIcon()) {
                    dVar.A(4, getIcon());
                }
            }

            public static PoiSimilar parseFrom(byte[] bArr) throws e {
                return (PoiSimilar) new PoiSimilar().mergeFrom(bArr);
            }

            @Override // L1.f
            public PoiSimilar mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setText(bVar.n());
                    } else if (iO == 18) {
                        setOpenapi(bVar.n());
                    } else if (iO == 26) {
                        setNavi(bVar.n());
                    } else if (iO == 34) {
                        setIcon(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Sgeo extends f {
            public static final int BOUND_FIELD_NUMBER = 1;
            public static final int GEO_ELEMENTS_FIELD_NUMBER = 3;
            public static final int TYPE_FIELD_NUMBER = 2;
            private boolean hasType;
            private List<Integer> bound_ = Collections.emptyList();
            private int type_ = 0;
            private List<GeoElements> geoElements_ = Collections.emptyList();
            private int cachedSize = -1;

            public static final class GeoElements extends f {
                public static final int POINT_FIELD_NUMBER = 1;
                private List<Integer> point_ = Collections.emptyList();
                private int cachedSize = -1;

                public static GeoElements parseFrom(b bVar) throws IOException {
                    return new GeoElements().mergeFrom(bVar);
                }

                public GeoElements addPoint(int i4) {
                    if (this.point_.isEmpty()) {
                        this.point_ = new ArrayList();
                    }
                    this.point_.add(Integer.valueOf(i4));
                    return this;
                }

                public final GeoElements clear() {
                    clearPoint();
                    this.cachedSize = -1;
                    return this;
                }

                public GeoElements clearPoint() {
                    this.point_ = Collections.emptyList();
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getPoint(int i4) {
                    return this.point_.get(i4).intValue();
                }

                public int getPointCount() {
                    return this.point_.size();
                }

                public List<Integer> getPointList() {
                    return this.point_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    Iterator<Integer> it = getPointList().iterator();
                    int iG = 0;
                    while (it.hasNext()) {
                        iG = g.g(it.next(), iG);
                    }
                    int size = getPointList().size() + iG;
                    this.cachedSize = size;
                    return size;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public GeoElements setPoint(int i4, int i5) {
                    this.point_.set(i4, Integer.valueOf(i5));
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    Iterator<Integer> it = getPointList().iterator();
                    while (it.hasNext()) {
                        dVar.z(1, it.next().intValue());
                    }
                }

                public static GeoElements parseFrom(byte[] bArr) throws e {
                    return (GeoElements) new GeoElements().mergeFrom(bArr);
                }

                @Override // L1.f
                public GeoElements mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            addPoint(bVar.m());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static Sgeo parseFrom(b bVar) throws IOException {
                return new Sgeo().mergeFrom(bVar);
            }

            public Sgeo addBound(int i4) {
                if (this.bound_.isEmpty()) {
                    this.bound_ = new ArrayList();
                }
                this.bound_.add(Integer.valueOf(i4));
                return this;
            }

            public Sgeo addGeoElements(GeoElements geoElements) {
                if (geoElements == null) {
                    return this;
                }
                if (this.geoElements_.isEmpty()) {
                    this.geoElements_ = new ArrayList();
                }
                this.geoElements_.add(geoElements);
                return this;
            }

            public final Sgeo clear() {
                clearBound();
                clearType();
                clearGeoElements();
                this.cachedSize = -1;
                return this;
            }

            public Sgeo clearBound() {
                this.bound_ = Collections.emptyList();
                return this;
            }

            public Sgeo clearGeoElements() {
                this.geoElements_ = Collections.emptyList();
                return this;
            }

            public Sgeo clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            public int getBound(int i4) {
                return this.bound_.get(i4).intValue();
            }

            public int getBoundCount() {
                return this.bound_.size();
            }

            public List<Integer> getBoundList() {
                return this.bound_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public GeoElements getGeoElements(int i4) {
                return this.geoElements_.get(i4);
            }

            public int getGeoElementsCount() {
                return this.geoElements_.size();
            }

            public List<GeoElements> getGeoElementsList() {
                return this.geoElements_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                Iterator<Integer> it = getBoundList().iterator();
                int iG = 0;
                while (it.hasNext()) {
                    iG = g.g(it.next(), iG);
                }
                int size = getBoundList().size() + iG;
                if (hasType()) {
                    size += d.e(2, getType());
                }
                Iterator<GeoElements> it2 = getGeoElementsList().iterator();
                while (it2.hasNext()) {
                    size += d.h(3, it2.next());
                }
                this.cachedSize = size;
                return size;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Sgeo setBound(int i4, int i5) {
                this.bound_.set(i4, Integer.valueOf(i5));
                return this;
            }

            public Sgeo setGeoElements(int i4, GeoElements geoElements) {
                if (geoElements == null) {
                    return this;
                }
                this.geoElements_.set(i4, geoElements);
                return this;
            }

            public Sgeo setType(int i4) {
                this.hasType = true;
                this.type_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                Iterator<Integer> it = getBoundList().iterator();
                while (it.hasNext()) {
                    dVar.z(1, it.next().intValue());
                }
                if (hasType()) {
                    dVar.s(2, getType());
                }
                Iterator<GeoElements> it2 = getGeoElementsList().iterator();
                while (it2.hasNext()) {
                    dVar.u(3, it2.next());
                }
            }

            public static Sgeo parseFrom(byte[] bArr) throws e {
                return (Sgeo) new Sgeo().mergeFrom(bArr);
            }

            @Override // L1.f
            public Sgeo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        addBound(bVar.m());
                    } else if (iO == 16) {
                        setType(bVar.k());
                    } else if (iO == 26) {
                        GeoElements geoElements = new GeoElements();
                        bVar.f(geoElements);
                        addGeoElements(geoElements);
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class Show extends f {
            public static final int ADDRESS_FIELD_NUMBER = 1;
            public static final int BOOK_INFO_FIELD_NUMBER = 11;
            public static final int DISTANCE_FIELD_NUMBER = 5;
            public static final int EC_REASON_FIELD_NUMBER = 9;
            public static final int EP_CHAR_FIELD_NUMBER = 8;
            public static final int ICON_FIELD_NUMBER = 4;
            public static final int IMAGE_FIELD_NUMBER = 2;
            public static final int MAP_BUTTON_FIELD_NUMBER = 12;
            public static final int NAME_FIELD_NUMBER = 3;
            public static final int OVERALL_RATING_FIELD_NUMBER = 6;
            public static final int PHONE_BUTTON_FIELD_NUMBER = 10;
            public static final int PRICE_FIELD_NUMBER = 7;
            private boolean hasAddress;
            private boolean hasBookInfo;
            private boolean hasDistance;
            private boolean hasEcReason;
            private boolean hasEpChar;
            private boolean hasIcon;
            private boolean hasImage;
            private boolean hasMapButton;
            private boolean hasName;
            private boolean hasOverallRating;
            private boolean hasPhoneButton;
            private boolean hasPrice;
            private int address_ = 0;
            private int image_ = 0;
            private int name_ = 0;
            private int icon_ = 0;
            private int distance_ = 0;
            private int overallRating_ = 0;
            private int price_ = 0;
            private int epChar_ = 0;
            private int ecReason_ = 0;
            private int phoneButton_ = 0;
            private int bookInfo_ = 0;
            private int mapButton_ = 0;
            private int cachedSize = -1;

            public static Show parseFrom(b bVar) throws IOException {
                return new Show().mergeFrom(bVar);
            }

            public final Show clear() {
                clearAddress();
                clearImage();
                clearName();
                clearIcon();
                clearDistance();
                clearOverallRating();
                clearPrice();
                clearEpChar();
                clearEcReason();
                clearPhoneButton();
                clearBookInfo();
                clearMapButton();
                this.cachedSize = -1;
                return this;
            }

            public Show clearAddress() {
                this.hasAddress = false;
                this.address_ = 0;
                return this;
            }

            public Show clearBookInfo() {
                this.hasBookInfo = false;
                this.bookInfo_ = 0;
                return this;
            }

            public Show clearDistance() {
                this.hasDistance = false;
                this.distance_ = 0;
                return this;
            }

            public Show clearEcReason() {
                this.hasEcReason = false;
                this.ecReason_ = 0;
                return this;
            }

            public Show clearEpChar() {
                this.hasEpChar = false;
                this.epChar_ = 0;
                return this;
            }

            public Show clearIcon() {
                this.hasIcon = false;
                this.icon_ = 0;
                return this;
            }

            public Show clearImage() {
                this.hasImage = false;
                this.image_ = 0;
                return this;
            }

            public Show clearMapButton() {
                this.hasMapButton = false;
                this.mapButton_ = 0;
                return this;
            }

            public Show clearName() {
                this.hasName = false;
                this.name_ = 0;
                return this;
            }

            public Show clearOverallRating() {
                this.hasOverallRating = false;
                this.overallRating_ = 0;
                return this;
            }

            public Show clearPhoneButton() {
                this.hasPhoneButton = false;
                this.phoneButton_ = 0;
                return this;
            }

            public Show clearPrice() {
                this.hasPrice = false;
                this.price_ = 0;
                return this;
            }

            public int getAddress() {
                return this.address_;
            }

            public int getBookInfo() {
                return this.bookInfo_;
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

            public int getEcReason() {
                return this.ecReason_;
            }

            public int getEpChar() {
                return this.epChar_;
            }

            public int getIcon() {
                return this.icon_;
            }

            public int getImage() {
                return this.image_;
            }

            public int getMapButton() {
                return this.mapButton_;
            }

            public int getName() {
                return this.name_;
            }

            public int getOverallRating() {
                return this.overallRating_;
            }

            public int getPhoneButton() {
                return this.phoneButton_;
            }

            public int getPrice() {
                return this.price_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasAddress() ? d.e(1, getAddress()) : 0;
                if (hasImage()) {
                    iE += d.e(2, getImage());
                }
                if (hasName()) {
                    iE += d.e(3, getName());
                }
                if (hasIcon()) {
                    iE += d.e(4, getIcon());
                }
                if (hasDistance()) {
                    iE += d.e(5, getDistance());
                }
                if (hasOverallRating()) {
                    iE += d.e(6, getOverallRating());
                }
                if (hasPrice()) {
                    iE += d.e(7, getPrice());
                }
                if (hasEpChar()) {
                    iE += d.e(8, getEpChar());
                }
                if (hasEcReason()) {
                    iE += d.e(9, getEcReason());
                }
                if (hasPhoneButton()) {
                    iE += d.e(10, getPhoneButton());
                }
                if (hasBookInfo()) {
                    iE += d.e(11, getBookInfo());
                }
                if (hasMapButton()) {
                    iE += d.e(12, getMapButton());
                }
                this.cachedSize = iE;
                return iE;
            }

            public boolean hasAddress() {
                return this.hasAddress;
            }

            public boolean hasBookInfo() {
                return this.hasBookInfo;
            }

            public boolean hasDistance() {
                return this.hasDistance;
            }

            public boolean hasEcReason() {
                return this.hasEcReason;
            }

            public boolean hasEpChar() {
                return this.hasEpChar;
            }

            public boolean hasIcon() {
                return this.hasIcon;
            }

            public boolean hasImage() {
                return this.hasImage;
            }

            public boolean hasMapButton() {
                return this.hasMapButton;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasOverallRating() {
                return this.hasOverallRating;
            }

            public boolean hasPhoneButton() {
                return this.hasPhoneButton;
            }

            public boolean hasPrice() {
                return this.hasPrice;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Show setAddress(int i4) {
                this.hasAddress = true;
                this.address_ = i4;
                return this;
            }

            public Show setBookInfo(int i4) {
                this.hasBookInfo = true;
                this.bookInfo_ = i4;
                return this;
            }

            public Show setDistance(int i4) {
                this.hasDistance = true;
                this.distance_ = i4;
                return this;
            }

            public Show setEcReason(int i4) {
                this.hasEcReason = true;
                this.ecReason_ = i4;
                return this;
            }

            public Show setEpChar(int i4) {
                this.hasEpChar = true;
                this.epChar_ = i4;
                return this;
            }

            public Show setIcon(int i4) {
                this.hasIcon = true;
                this.icon_ = i4;
                return this;
            }

            public Show setImage(int i4) {
                this.hasImage = true;
                this.image_ = i4;
                return this;
            }

            public Show setMapButton(int i4) {
                this.hasMapButton = true;
                this.mapButton_ = i4;
                return this;
            }

            public Show setName(int i4) {
                this.hasName = true;
                this.name_ = i4;
                return this;
            }

            public Show setOverallRating(int i4) {
                this.hasOverallRating = true;
                this.overallRating_ = i4;
                return this;
            }

            public Show setPhoneButton(int i4) {
                this.hasPhoneButton = true;
                this.phoneButton_ = i4;
                return this;
            }

            public Show setPrice(int i4) {
                this.hasPrice = true;
                this.price_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasAddress()) {
                    dVar.s(1, getAddress());
                }
                if (hasImage()) {
                    dVar.s(2, getImage());
                }
                if (hasName()) {
                    dVar.s(3, getName());
                }
                if (hasIcon()) {
                    dVar.s(4, getIcon());
                }
                if (hasDistance()) {
                    dVar.s(5, getDistance());
                }
                if (hasOverallRating()) {
                    dVar.s(6, getOverallRating());
                }
                if (hasPrice()) {
                    dVar.s(7, getPrice());
                }
                if (hasEpChar()) {
                    dVar.s(8, getEpChar());
                }
                if (hasEcReason()) {
                    dVar.s(9, getEcReason());
                }
                if (hasPhoneButton()) {
                    dVar.s(10, getPhoneButton());
                }
                if (hasBookInfo()) {
                    dVar.s(11, getBookInfo());
                }
                if (hasMapButton()) {
                    dVar.s(12, getMapButton());
                }
            }

            public static Show parseFrom(byte[] bArr) throws e {
                return (Show) new Show().mergeFrom(bArr);
            }

            @Override // L1.f
            public Show mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    switch (iO) {
                        case 0:
                            return this;
                        case 8:
                            setAddress(bVar.k());
                            break;
                        case 16:
                            setImage(bVar.k());
                            break;
                        case 24:
                            setName(bVar.k());
                            break;
                        case 32:
                            setIcon(bVar.k());
                            break;
                        case 40:
                            setDistance(bVar.k());
                            break;
                        case 48:
                            setOverallRating(bVar.k());
                            break;
                        case 56:
                            setPrice(bVar.k());
                            break;
                        case 64:
                            setEpChar(bVar.k());
                            break;
                        case 72:
                            setEcReason(bVar.k());
                            break;
                        case 80:
                            setPhoneButton(bVar.k());
                            break;
                        case 88:
                            setBookInfo(bVar.k());
                            break;
                        case 96:
                            setMapButton(bVar.k());
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

        public static final class StartPageData extends f {
            public static final int ADDR_FIELD_NUMBER = 2;
            public static final int ICON_URL_FIELD_NUMBER = 3;
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int PARAM_FIELD_NUMBER = 5;
            public static final int TAG_FIELD_NUMBER = 4;
            private boolean hasAddr;
            private boolean hasIconUrl;
            private boolean hasName;
            private boolean hasParam;
            private boolean hasTag;
            private String name_ = "";
            private String addr_ = "";
            private String iconUrl_ = "";
            private String tag_ = "";
            private String param_ = "";
            private int cachedSize = -1;

            public static StartPageData parseFrom(b bVar) throws IOException {
                return new StartPageData().mergeFrom(bVar);
            }

            public final StartPageData clear() {
                clearName();
                clearAddr();
                clearIconUrl();
                clearTag();
                clearParam();
                this.cachedSize = -1;
                return this;
            }

            public StartPageData clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public StartPageData clearIconUrl() {
                this.hasIconUrl = false;
                this.iconUrl_ = "";
                return this;
            }

            public StartPageData clearName() {
                this.hasName = false;
                this.name_ = "";
                return this;
            }

            public StartPageData clearParam() {
                this.hasParam = false;
                this.param_ = "";
                return this;
            }

            public StartPageData clearTag() {
                this.hasTag = false;
                this.tag_ = "";
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

            public String getIconUrl() {
                return this.iconUrl_;
            }

            public String getName() {
                return this.name_;
            }

            public String getParam() {
                return this.param_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasName() ? d.l(1, getName()) : 0;
                if (hasAddr()) {
                    iL += d.l(2, getAddr());
                }
                if (hasIconUrl()) {
                    iL += d.l(3, getIconUrl());
                }
                if (hasTag()) {
                    iL += d.l(4, getTag());
                }
                if (hasParam()) {
                    iL += d.l(5, getParam());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getTag() {
                return this.tag_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasIconUrl() {
                return this.hasIconUrl;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasParam() {
                return this.hasParam;
            }

            public boolean hasTag() {
                return this.hasTag;
            }

            public final boolean isInitialized() {
                return true;
            }

            public StartPageData setAddr(String str) {
                this.hasAddr = true;
                this.addr_ = str;
                return this;
            }

            public StartPageData setIconUrl(String str) {
                this.hasIconUrl = true;
                this.iconUrl_ = str;
                return this;
            }

            public StartPageData setName(String str) {
                this.hasName = true;
                this.name_ = str;
                return this;
            }

            public StartPageData setParam(String str) {
                this.hasParam = true;
                this.param_ = str;
                return this;
            }

            public StartPageData setTag(String str) {
                this.hasTag = true;
                this.tag_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasName()) {
                    dVar.A(1, getName());
                }
                if (hasAddr()) {
                    dVar.A(2, getAddr());
                }
                if (hasIconUrl()) {
                    dVar.A(3, getIconUrl());
                }
                if (hasTag()) {
                    dVar.A(4, getTag());
                }
                if (hasParam()) {
                    dVar.A(5, getParam());
                }
            }

            public static StartPageData parseFrom(byte[] bArr) throws e {
                return (StartPageData) new StartPageData().mergeFrom(bArr);
            }

            @Override // L1.f
            public StartPageData mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setName(bVar.n());
                    } else if (iO == 18) {
                        setAddr(bVar.n());
                    } else if (iO == 26) {
                        setIconUrl(bVar.n());
                    } else if (iO == 34) {
                        setTag(bVar.n());
                    } else if (iO == 42) {
                        setParam(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class TravelButton extends f {
            public static final int BUBBLE_FIELD_NUMBER = 2;
            public static final int BUTTON_FIELD_NUMBER = 3;
            public static final int CORNER_MARK_URL_FIELD_NUMBER = 5;
            public static final int MATERIAL_ID_FIELD_NUMBER = 1;
            public static final int STRATEGY_FIELD_NUMBER = 4;
            private boolean hasButton;
            private boolean hasCornerMarkUrl;
            private boolean hasMaterialId;
            private boolean hasStrategy;
            private int materialId_ = 0;
            private List<String> bubble_ = Collections.emptyList();
            private Button button_ = null;
            private Strategy strategy_ = null;
            private String cornerMarkUrl_ = "";
            private int cachedSize = -1;

            public static final class Strategy extends f {
                public static final int MAX_CLICK_TIMES_FIELD_NUMBER = 1;
                public static final int MAX_SHOW_TIMES_FIELD_NUMBER = 2;
                public static final int SHOW_DURATION_FIELD_NUMBER = 3;
                private boolean hasMaxClickTimes;
                private boolean hasMaxShowTimes;
                private boolean hasShowDuration;
                private int maxClickTimes_ = 0;
                private int maxShowTimes_ = 0;
                private int showDuration_ = 0;
                private int cachedSize = -1;

                public static Strategy parseFrom(b bVar) throws IOException {
                    return new Strategy().mergeFrom(bVar);
                }

                public final Strategy clear() {
                    clearMaxClickTimes();
                    clearMaxShowTimes();
                    clearShowDuration();
                    this.cachedSize = -1;
                    return this;
                }

                public Strategy clearMaxClickTimes() {
                    this.hasMaxClickTimes = false;
                    this.maxClickTimes_ = 0;
                    return this;
                }

                public Strategy clearMaxShowTimes() {
                    this.hasMaxShowTimes = false;
                    this.maxShowTimes_ = 0;
                    return this;
                }

                public Strategy clearShowDuration() {
                    this.hasShowDuration = false;
                    this.showDuration_ = 0;
                    return this;
                }

                @Override // L1.f
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getMaxClickTimes() {
                    return this.maxClickTimes_;
                }

                public int getMaxShowTimes() {
                    return this.maxShowTimes_;
                }

                @Override // L1.f
                public int getSerializedSize() {
                    int iE = hasMaxClickTimes() ? d.e(1, getMaxClickTimes()) : 0;
                    if (hasMaxShowTimes()) {
                        iE += d.e(2, getMaxShowTimes());
                    }
                    if (hasShowDuration()) {
                        iE += d.e(3, getShowDuration());
                    }
                    this.cachedSize = iE;
                    return iE;
                }

                public int getShowDuration() {
                    return this.showDuration_;
                }

                public boolean hasMaxClickTimes() {
                    return this.hasMaxClickTimes;
                }

                public boolean hasMaxShowTimes() {
                    return this.hasMaxShowTimes;
                }

                public boolean hasShowDuration() {
                    return this.hasShowDuration;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Strategy setMaxClickTimes(int i4) {
                    this.hasMaxClickTimes = true;
                    this.maxClickTimes_ = i4;
                    return this;
                }

                public Strategy setMaxShowTimes(int i4) {
                    this.hasMaxShowTimes = true;
                    this.maxShowTimes_ = i4;
                    return this;
                }

                public Strategy setShowDuration(int i4) {
                    this.hasShowDuration = true;
                    this.showDuration_ = i4;
                    return this;
                }

                @Override // L1.f
                public void writeTo(d dVar) throws IOException {
                    if (hasMaxClickTimes()) {
                        dVar.s(1, getMaxClickTimes());
                    }
                    if (hasMaxShowTimes()) {
                        dVar.s(2, getMaxShowTimes());
                    }
                    if (hasShowDuration()) {
                        dVar.s(3, getShowDuration());
                    }
                }

                public static Strategy parseFrom(byte[] bArr) throws e {
                    return (Strategy) new Strategy().mergeFrom(bArr);
                }

                @Override // L1.f
                public Strategy mergeFrom(b bVar) throws IOException {
                    while (true) {
                        int iO = bVar.o();
                        if (iO == 0) {
                            return this;
                        }
                        if (iO == 8) {
                            setMaxClickTimes(bVar.k());
                        } else if (iO == 16) {
                            setMaxShowTimes(bVar.k());
                        } else if (iO == 24) {
                            setShowDuration(bVar.k());
                        } else if (!parseUnknownField(bVar, iO)) {
                            return this;
                        }
                    }
                }
            }

            public static TravelButton parseFrom(b bVar) throws IOException {
                return new TravelButton().mergeFrom(bVar);
            }

            public TravelButton addBubble(String str) {
                str.getClass();
                if (this.bubble_.isEmpty()) {
                    this.bubble_ = new ArrayList();
                }
                this.bubble_.add(str);
                return this;
            }

            public final TravelButton clear() {
                clearMaterialId();
                clearBubble();
                clearButton();
                clearStrategy();
                clearCornerMarkUrl();
                this.cachedSize = -1;
                return this;
            }

            public TravelButton clearBubble() {
                this.bubble_ = Collections.emptyList();
                return this;
            }

            public TravelButton clearButton() {
                this.hasButton = false;
                this.button_ = null;
                return this;
            }

            public TravelButton clearCornerMarkUrl() {
                this.hasCornerMarkUrl = false;
                this.cornerMarkUrl_ = "";
                return this;
            }

            public TravelButton clearMaterialId() {
                this.hasMaterialId = false;
                this.materialId_ = 0;
                return this;
            }

            public TravelButton clearStrategy() {
                this.hasStrategy = false;
                this.strategy_ = null;
                return this;
            }

            public String getBubble(int i4) {
                return this.bubble_.get(i4);
            }

            public int getBubbleCount() {
                return this.bubble_.size();
            }

            public List<String> getBubbleList() {
                return this.bubble_;
            }

            public Button getButton() {
                return this.button_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getCornerMarkUrl() {
                return this.cornerMarkUrl_;
            }

            public int getMaterialId() {
                return this.materialId_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iM = 0;
                int iE = hasMaterialId() ? d.e(1, getMaterialId()) : 0;
                Iterator<String> it = getBubbleList().iterator();
                while (it.hasNext()) {
                    iM += d.m(it.next());
                }
                int size = getBubbleList().size() + iE + iM;
                if (hasButton()) {
                    size += d.h(3, getButton());
                }
                if (hasStrategy()) {
                    size += d.h(4, getStrategy());
                }
                if (hasCornerMarkUrl()) {
                    size += d.l(5, getCornerMarkUrl());
                }
                this.cachedSize = size;
                return size;
            }

            public Strategy getStrategy() {
                return this.strategy_;
            }

            public boolean hasButton() {
                return this.hasButton;
            }

            public boolean hasCornerMarkUrl() {
                return this.hasCornerMarkUrl;
            }

            public boolean hasMaterialId() {
                return this.hasMaterialId;
            }

            public boolean hasStrategy() {
                return this.hasStrategy;
            }

            public final boolean isInitialized() {
                return true;
            }

            public TravelButton setBubble(int i4, String str) {
                str.getClass();
                this.bubble_.set(i4, str);
                return this;
            }

            public TravelButton setButton(Button button) {
                if (button == null) {
                    return clearButton();
                }
                this.hasButton = true;
                this.button_ = button;
                return this;
            }

            public TravelButton setCornerMarkUrl(String str) {
                this.hasCornerMarkUrl = true;
                this.cornerMarkUrl_ = str;
                return this;
            }

            public TravelButton setMaterialId(int i4) {
                this.hasMaterialId = true;
                this.materialId_ = i4;
                return this;
            }

            public TravelButton setStrategy(Strategy strategy) {
                if (strategy == null) {
                    return clearStrategy();
                }
                this.hasStrategy = true;
                this.strategy_ = strategy;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasMaterialId()) {
                    dVar.s(1, getMaterialId());
                }
                Iterator<String> it = getBubbleList().iterator();
                while (it.hasNext()) {
                    dVar.A(2, it.next());
                }
                if (hasButton()) {
                    dVar.u(3, getButton());
                }
                if (hasStrategy()) {
                    dVar.u(4, getStrategy());
                }
                if (hasCornerMarkUrl()) {
                    dVar.A(5, getCornerMarkUrl());
                }
            }

            public static TravelButton parseFrom(byte[] bArr) throws e {
                return (TravelButton) new TravelButton().mergeFrom(bArr);
            }

            @Override // L1.f
            public TravelButton mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setMaterialId(bVar.k());
                    } else if (iO == 18) {
                        addBubble(bVar.n());
                    } else if (iO == 26) {
                        Button button = new Button();
                        bVar.f(button);
                        setButton(button);
                    } else if (iO == 34) {
                        Strategy strategy = new Strategy();
                        bVar.f(strategy);
                        setStrategy(strategy);
                    } else if (iO == 42) {
                        setCornerMarkUrl(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class VuiProcessData extends f {
            public static final int CHOOSETEMPLATE_FIELD_NUMBER = 5;
            public static final int DYN_REQUEST_FIELD_NUMBER = 1;
            public static final int DYN_RESPONSE_FIELD_NUMBER = 2;
            public static final int DYN_ZHANWEI_FIELD_NUMBER = 3;
            public static final int TRADE_FIELD_NUMBER = 4;
            private boolean hasChooseTemplate;
            private boolean hasDynRequest;
            private boolean hasDynResponse;
            private boolean hasTrade;
            private boolean dynRequest_ = false;
            private boolean dynResponse_ = false;
            private List<Integer> dynZhanwei_ = Collections.emptyList();
            private String trade_ = "";
            private String chooseTemplate_ = "";
            private int cachedSize = -1;

            public static VuiProcessData parseFrom(b bVar) throws IOException {
                return new VuiProcessData().mergeFrom(bVar);
            }

            public VuiProcessData addDynZhanwei(int i4) {
                if (this.dynZhanwei_.isEmpty()) {
                    this.dynZhanwei_ = new ArrayList();
                }
                this.dynZhanwei_.add(Integer.valueOf(i4));
                return this;
            }

            public final VuiProcessData clear() {
                clearDynRequest();
                clearDynResponse();
                clearDynZhanwei();
                clearTrade();
                clearChooseTemplate();
                this.cachedSize = -1;
                return this;
            }

            public VuiProcessData clearChooseTemplate() {
                this.hasChooseTemplate = false;
                this.chooseTemplate_ = "";
                return this;
            }

            public VuiProcessData clearDynRequest() {
                this.hasDynRequest = false;
                this.dynRequest_ = false;
                return this;
            }

            public VuiProcessData clearDynResponse() {
                this.hasDynResponse = false;
                this.dynResponse_ = false;
                return this;
            }

            public VuiProcessData clearDynZhanwei() {
                this.dynZhanwei_ = Collections.emptyList();
                return this;
            }

            public VuiProcessData clearTrade() {
                this.hasTrade = false;
                this.trade_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getChooseTemplate() {
                return this.chooseTemplate_;
            }

            public boolean getDynRequest() {
                return this.dynRequest_;
            }

            public boolean getDynResponse() {
                return this.dynResponse_;
            }

            public int getDynZhanwei(int i4) {
                return this.dynZhanwei_.get(i4).intValue();
            }

            public int getDynZhanweiCount() {
                return this.dynZhanwei_.size();
            }

            public List<Integer> getDynZhanweiList() {
                return this.dynZhanwei_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iA;
                int iF = 0;
                if (hasDynRequest()) {
                    getDynRequest();
                    iA = d.a(1);
                } else {
                    iA = 0;
                }
                if (hasDynResponse()) {
                    getDynResponse();
                    iA += d.a(2);
                }
                Iterator<Integer> it = getDynZhanweiList().iterator();
                while (it.hasNext()) {
                    iF += d.f(it.next().intValue());
                }
                int size = getDynZhanweiList().size() + iA + iF;
                if (hasTrade()) {
                    size += d.l(4, getTrade());
                }
                if (hasChooseTemplate()) {
                    size += d.l(5, getChooseTemplate());
                }
                this.cachedSize = size;
                return size;
            }

            public String getTrade() {
                return this.trade_;
            }

            public boolean hasChooseTemplate() {
                return this.hasChooseTemplate;
            }

            public boolean hasDynRequest() {
                return this.hasDynRequest;
            }

            public boolean hasDynResponse() {
                return this.hasDynResponse;
            }

            public boolean hasTrade() {
                return this.hasTrade;
            }

            public final boolean isInitialized() {
                return true;
            }

            public VuiProcessData setChooseTemplate(String str) {
                this.hasChooseTemplate = true;
                this.chooseTemplate_ = str;
                return this;
            }

            public VuiProcessData setDynRequest(boolean z4) {
                this.hasDynRequest = true;
                this.dynRequest_ = z4;
                return this;
            }

            public VuiProcessData setDynResponse(boolean z4) {
                this.hasDynResponse = true;
                this.dynResponse_ = z4;
                return this;
            }

            public VuiProcessData setDynZhanwei(int i4, int i5) {
                this.dynZhanwei_.set(i4, Integer.valueOf(i5));
                return this;
            }

            public VuiProcessData setTrade(String str) {
                this.hasTrade = true;
                this.trade_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasDynRequest()) {
                    dVar.p(1, getDynRequest());
                }
                if (hasDynResponse()) {
                    dVar.p(2, getDynResponse());
                }
                Iterator<Integer> it = getDynZhanweiList().iterator();
                while (it.hasNext()) {
                    dVar.s(3, it.next().intValue());
                }
                if (hasTrade()) {
                    dVar.A(4, getTrade());
                }
                if (hasChooseTemplate()) {
                    dVar.A(5, getChooseTemplate());
                }
            }

            public static VuiProcessData parseFrom(byte[] bArr) throws e {
                return (VuiProcessData) new VuiProcessData().mergeFrom(bArr);
            }

            @Override // L1.f
            public VuiProcessData mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setDynRequest(bVar.a());
                    } else if (iO == 16) {
                        setDynResponse(bVar.a());
                    } else if (iO == 24) {
                        addDynZhanwei(bVar.k());
                    } else if (iO == 34) {
                        setTrade(bVar.n());
                    } else if (iO == 42) {
                        setChooseTemplate(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public Contents() {
            a aVar = a.f1216c;
            this.cloudTemplate_ = aVar;
            this.button_ = null;
            this.mapPoitag_ = null;
            this.barTemplate_ = aVar;
            this.ismodified_ = 0;
            this.headway_ = "";
            this.interventTips_ = "";
            this.poiRegionType_ = "";
            this.regionType_ = "";
            this.distance_ = "";
            this.stdTag_ = "";
            this.serviceTag_ = "";
            this.areaName_ = "";
            this.photoList_ = "";
            this.headIcon_ = null;
            this.indoorOverLooking_ = 0;
            this.stdTagId_ = "";
            this.vuiProcessData_ = null;
            this.newsgeo_ = null;
            this.attachedAddr_ = 0;
            this.city_ = "";
            this.province_ = "";
            this.recommendType_ = 0;
            this.detailDisplayType_ = 0;
            this.queryGuide_ = "";
            this.indoorGeoz_ = 0;
            this.poiSimilar_ = null;
            this.avocadoForwardParam_ = "";
            this.horizonSlideData_ = "";
            this.buriedPoint_ = "";
            this.infDynRequest_ = 0;
            this.halfKill_ = false;
            this.headIconBubbleInfo_ = null;
            this.thirdParty_ = null;
            this.headResultMsg_ = aVar;
            this.hwBrowseRecords_ = null;
            this.barButton_ = Collections.emptyList();
            this.travelButton_ = null;
            this.cardType_ = 0;
            this.advertiseInfo_ = null;
            this.fourStateSwitch_ = 0;
            this.adsData_ = null;
            this.historyAddress_ = "";
            this.favNum_ = 0;
            this.aispaceAds_ = null;
            this.favBubble_ = "";
            this.guildButton_ = Collections.emptyList();
            this.bound_ = "";
            this.fixedBarButton_ = Collections.emptyList();
            this.groupType_ = "";
            this.cachedSize = -1;
        }

        public static Contents parseFrom(b bVar) throws IOException {
            return new Contents().mergeFrom(bVar);
        }

        public Contents addBarButton(BarButton barButton) {
            if (barButton == null) {
                return this;
            }
            if (this.barButton_.isEmpty()) {
                this.barButton_ = new ArrayList();
            }
            this.barButton_.add(barButton);
            return this;
        }

        public Contents addFixedBarButton(FixedBarButton fixedBarButton) {
            if (fixedBarButton == null) {
                return this;
            }
            if (this.fixedBarButton_.isEmpty()) {
                this.fixedBarButton_ = new ArrayList();
            }
            this.fixedBarButton_.add(fixedBarButton);
            return this;
        }

        public Contents addGuildButton(GuildButton guildButton) {
            if (guildButton == null) {
                return this;
            }
            if (this.guildButton_.isEmpty()) {
                this.guildButton_ = new ArrayList();
            }
            this.guildButton_.add(guildButton);
            return this;
        }

        public Contents addRecReason(String str) {
            str.getClass();
            if (this.recReason_.isEmpty()) {
                this.recReason_ = new ArrayList();
            }
            this.recReason_.add(str);
            return this;
        }

        public final Contents clear() {
            clearShow();
            clearExt();
            clearHeatMap();
            clearSgeo();
            clearGeo();
            clearName();
            clearUid();
            clearAccFlag();
            clearAddr();
            clearDetail();
            clearRecReason();
            clearTel();
            clearPoiType();
            clearPano();
            clearIndoorPano();
            clearAoi();
            clearStartTime();
            clearEndTime();
            clearHasRtbus();
            clearTipRtbus();
            clearRtbusUpdateTime();
            clearFatherSon();
            clearPoiTypeText();
            clearChildCatalog();
            clearPoiChildText();
            clearNewCatalogId();
            clearViewType();
            clearListShow();
            clearShowLevel();
            clearIconId();
            clearKindtype();
            clearBrandIconId();
            clearTag();
            clearRank();
            clearMaxShowLevel();
            clearIndoorFloor();
            clearIndoorParentUid();
            clearCloudTemplate();
            clearButton();
            clearMapPoitag();
            clearBarTemplate();
            clearIsmodified();
            clearHeadway();
            clearInterventTips();
            clearPoiRegionType();
            clearRegionType();
            clearDistance();
            clearStdTag();
            clearServiceTag();
            clearAreaName();
            clearPhotoList();
            clearHeadIcon();
            clearIndoorOverLooking();
            clearStdTagId();
            clearVuiProcessData();
            clearNewsgeo();
            clearAttachedAddr();
            clearCity();
            clearProvince();
            clearRecommendType();
            clearDetailDisplayType();
            clearQueryGuide();
            clearIndoorGeoz();
            clearPoiSimilar();
            clearAvocadoForwardParam();
            clearHorizonSlideData();
            clearBuriedPoint();
            clearInfDynRequest();
            clearHalfKill();
            clearHeadIconBubbleInfo();
            clearThirdParty();
            clearHeadResultMsg();
            clearHwBrowseRecords();
            clearBarButton();
            clearTravelButton();
            clearCardType();
            clearAdvertiseInfo();
            clearFourStateSwitch();
            clearAdsData();
            clearHistoryAddress();
            clearFavNum();
            clearAispaceAds();
            clearFavBubble();
            clearGuildButton();
            clearBound();
            clearFixedBarButton();
            clearGroupType();
            this.cachedSize = -1;
            return this;
        }

        public Contents clearAccFlag() {
            this.hasAccFlag = false;
            this.accFlag_ = 0;
            return this;
        }

        public Contents clearAddr() {
            this.hasAddr = false;
            this.addr_ = "";
            return this;
        }

        public Contents clearAdsData() {
            this.hasAdsData = false;
            this.adsData_ = null;
            return this;
        }

        public Contents clearAdvertiseInfo() {
            this.hasAdvertiseInfo = false;
            this.advertiseInfo_ = null;
            return this;
        }

        public Contents clearAispaceAds() {
            this.hasAispaceAds = false;
            this.aispaceAds_ = null;
            return this;
        }

        public Contents clearAoi() {
            this.hasAoi = false;
            this.aoi_ = "";
            return this;
        }

        public Contents clearAreaName() {
            this.hasAreaName = false;
            this.areaName_ = "";
            return this;
        }

        public Contents clearAttachedAddr() {
            this.hasAttachedAddr = false;
            this.attachedAddr_ = 0;
            return this;
        }

        public Contents clearAvocadoForwardParam() {
            this.hasAvocadoForwardParam = false;
            this.avocadoForwardParam_ = "";
            return this;
        }

        public Contents clearBarButton() {
            this.barButton_ = Collections.emptyList();
            return this;
        }

        public Contents clearBarTemplate() {
            this.hasBarTemplate = false;
            this.barTemplate_ = a.f1216c;
            return this;
        }

        public Contents clearBound() {
            this.hasBound = false;
            this.bound_ = "";
            return this;
        }

        public Contents clearBrandIconId() {
            this.hasBrandIconId = false;
            this.brandIconId_ = 0;
            return this;
        }

        public Contents clearBuriedPoint() {
            this.hasBuriedPoint = false;
            this.buriedPoint_ = "";
            return this;
        }

        public Contents clearButton() {
            this.hasButton = false;
            this.button_ = null;
            return this;
        }

        public Contents clearCardType() {
            this.hasCardType = false;
            this.cardType_ = 0;
            return this;
        }

        public Contents clearChildCatalog() {
            this.hasChildCatalog = false;
            this.childCatalog_ = "";
            return this;
        }

        public Contents clearCity() {
            this.hasCity = false;
            this.city_ = "";
            return this;
        }

        public Contents clearCloudTemplate() {
            this.hasCloudTemplate = false;
            this.cloudTemplate_ = a.f1216c;
            return this;
        }

        public Contents clearDetail() {
            this.hasDetail = false;
            this.detail_ = 0;
            return this;
        }

        public Contents clearDetailDisplayType() {
            this.hasDetailDisplayType = false;
            this.detailDisplayType_ = 0;
            return this;
        }

        public Contents clearDistance() {
            this.hasDistance = false;
            this.distance_ = "";
            return this;
        }

        public Contents clearEndTime() {
            this.hasEndTime = false;
            this.endTime_ = "";
            return this;
        }

        public Contents clearExt() {
            this.hasExt = false;
            this.ext_ = null;
            return this;
        }

        public Contents clearFatherSon() {
            this.hasFatherSon = false;
            this.fatherSon_ = 0;
            return this;
        }

        public Contents clearFavBubble() {
            this.hasFavBubble = false;
            this.favBubble_ = "";
            return this;
        }

        public Contents clearFavNum() {
            this.hasFavNum = false;
            this.favNum_ = 0;
            return this;
        }

        public Contents clearFixedBarButton() {
            this.fixedBarButton_ = Collections.emptyList();
            return this;
        }

        public Contents clearFourStateSwitch() {
            this.hasFourStateSwitch = false;
            this.fourStateSwitch_ = 0;
            return this;
        }

        public Contents clearGeo() {
            this.hasGeo = false;
            this.geo_ = "";
            return this;
        }

        public Contents clearGroupType() {
            this.hasGroupType = false;
            this.groupType_ = "";
            return this;
        }

        public Contents clearGuildButton() {
            this.guildButton_ = Collections.emptyList();
            return this;
        }

        public Contents clearHalfKill() {
            this.hasHalfKill = false;
            this.halfKill_ = false;
            return this;
        }

        public Contents clearHasRtbus() {
            this.hasHasRtbus = false;
            this.hasRtbus_ = 0;
            return this;
        }

        public Contents clearHeadIcon() {
            this.hasHeadIcon = false;
            this.headIcon_ = null;
            return this;
        }

        public Contents clearHeadIconBubbleInfo() {
            this.hasHeadIconBubbleInfo = false;
            this.headIconBubbleInfo_ = null;
            return this;
        }

        public Contents clearHeadResultMsg() {
            this.hasHeadResultMsg = false;
            this.headResultMsg_ = a.f1216c;
            return this;
        }

        public Contents clearHeadway() {
            this.hasHeadway = false;
            this.headway_ = "";
            return this;
        }

        public Contents clearHeatMap() {
            this.hasHeatMap = false;
            this.heatMap_ = null;
            return this;
        }

        public Contents clearHistoryAddress() {
            this.hasHistoryAddress = false;
            this.historyAddress_ = "";
            return this;
        }

        public Contents clearHorizonSlideData() {
            this.hasHorizonSlideData = false;
            this.horizonSlideData_ = "";
            return this;
        }

        public Contents clearHwBrowseRecords() {
            this.hasHwBrowseRecords = false;
            this.hwBrowseRecords_ = null;
            return this;
        }

        public Contents clearIconId() {
            this.hasIconId = false;
            this.iconId_ = 0;
            return this;
        }

        public Contents clearIndoorFloor() {
            this.hasIndoorFloor = false;
            this.indoorFloor_ = "";
            return this;
        }

        public Contents clearIndoorGeoz() {
            this.hasIndoorGeoz = false;
            this.indoorGeoz_ = 0;
            return this;
        }

        public Contents clearIndoorOverLooking() {
            this.hasIndoorOverLooking = false;
            this.indoorOverLooking_ = 0;
            return this;
        }

        public Contents clearIndoorPano() {
            this.hasIndoorPano = false;
            this.indoorPano_ = "";
            return this;
        }

        public Contents clearIndoorParentUid() {
            this.hasIndoorParentUid = false;
            this.indoorParentUid_ = "";
            return this;
        }

        public Contents clearInfDynRequest() {
            this.hasInfDynRequest = false;
            this.infDynRequest_ = 0;
            return this;
        }

        public Contents clearInterventTips() {
            this.hasInterventTips = false;
            this.interventTips_ = "";
            return this;
        }

        public Contents clearIsmodified() {
            this.hasIsmodified = false;
            this.ismodified_ = 0;
            return this;
        }

        public Contents clearKindtype() {
            this.hasKindtype = false;
            this.kindtype_ = 0;
            return this;
        }

        public Contents clearListShow() {
            this.hasListShow = false;
            this.listShow_ = 0;
            return this;
        }

        public Contents clearMapPoitag() {
            this.hasMapPoitag = false;
            this.mapPoitag_ = null;
            return this;
        }

        public Contents clearMaxShowLevel() {
            this.hasMaxShowLevel = false;
            this.maxShowLevel_ = 0;
            return this;
        }

        public Contents clearName() {
            this.hasName = false;
            this.name_ = "";
            return this;
        }

        public Contents clearNewCatalogId() {
            this.hasNewCatalogId = false;
            this.newCatalogId_ = "";
            return this;
        }

        public Contents clearNewsgeo() {
            this.hasNewsgeo = false;
            this.newsgeo_ = null;
            return this;
        }

        public Contents clearPano() {
            this.hasPano = false;
            this.pano_ = 0;
            return this;
        }

        public Contents clearPhotoList() {
            this.hasPhotoList = false;
            this.photoList_ = "";
            return this;
        }

        public Contents clearPoiChildText() {
            this.hasPoiChildText = false;
            this.poiChildText_ = "";
            return this;
        }

        public Contents clearPoiRegionType() {
            this.hasPoiRegionType = false;
            this.poiRegionType_ = "";
            return this;
        }

        public Contents clearPoiSimilar() {
            this.hasPoiSimilar = false;
            this.poiSimilar_ = null;
            return this;
        }

        public Contents clearPoiType() {
            this.hasPoiType = false;
            this.poiType_ = 0;
            return this;
        }

        public Contents clearPoiTypeText() {
            this.hasPoiTypeText = false;
            this.poiTypeText_ = "";
            return this;
        }

        public Contents clearProvince() {
            this.hasProvince = false;
            this.province_ = "";
            return this;
        }

        public Contents clearQueryGuide() {
            this.hasQueryGuide = false;
            this.queryGuide_ = "";
            return this;
        }

        public Contents clearRank() {
            this.hasRank = false;
            this.rank_ = 0;
            return this;
        }

        public Contents clearRecReason() {
            this.recReason_ = Collections.emptyList();
            return this;
        }

        public Contents clearRecommendType() {
            this.hasRecommendType = false;
            this.recommendType_ = 0;
            return this;
        }

        public Contents clearRegionType() {
            this.hasRegionType = false;
            this.regionType_ = "";
            return this;
        }

        public Contents clearRtbusUpdateTime() {
            this.hasRtbusUpdateTime = false;
            this.rtbusUpdateTime_ = 0;
            return this;
        }

        public Contents clearServiceTag() {
            this.hasServiceTag = false;
            this.serviceTag_ = "";
            return this;
        }

        public Contents clearSgeo() {
            this.hasSgeo = false;
            this.sgeo_ = null;
            return this;
        }

        public Contents clearShow() {
            this.hasShow = false;
            this.show_ = null;
            return this;
        }

        public Contents clearShowLevel() {
            this.hasShowLevel = false;
            this.showLevel_ = 0;
            return this;
        }

        public Contents clearStartTime() {
            this.hasStartTime = false;
            this.startTime_ = "";
            return this;
        }

        public Contents clearStdTag() {
            this.hasStdTag = false;
            this.stdTag_ = "";
            return this;
        }

        public Contents clearStdTagId() {
            this.hasStdTagId = false;
            this.stdTagId_ = "";
            return this;
        }

        public Contents clearTag() {
            this.hasTag = false;
            this.tag_ = 0;
            return this;
        }

        public Contents clearTel() {
            this.hasTel = false;
            this.tel_ = "";
            return this;
        }

        public Contents clearThirdParty() {
            this.hasThirdParty = false;
            this.thirdParty_ = null;
            return this;
        }

        public Contents clearTipRtbus() {
            this.hasTipRtbus = false;
            this.tipRtbus_ = "";
            return this;
        }

        public Contents clearTravelButton() {
            this.hasTravelButton = false;
            this.travelButton_ = null;
            return this;
        }

        public Contents clearUid() {
            this.hasUid = false;
            this.uid_ = "";
            return this;
        }

        public Contents clearViewType() {
            this.hasViewType = false;
            this.viewType_ = 0;
            return this;
        }

        public Contents clearVuiProcessData() {
            this.hasVuiProcessData = false;
            this.vuiProcessData_ = null;
            return this;
        }

        public int getAccFlag() {
            return this.accFlag_;
        }

        public String getAddr() {
            return this.addr_;
        }

        public AdsData getAdsData() {
            return this.adsData_;
        }

        public AdvertiseInfo getAdvertiseInfo() {
            return this.advertiseInfo_;
        }

        public AispaceAds getAispaceAds() {
            return this.aispaceAds_;
        }

        public String getAoi() {
            return this.aoi_;
        }

        public String getAreaName() {
            return this.areaName_;
        }

        public int getAttachedAddr() {
            return this.attachedAddr_;
        }

        public String getAvocadoForwardParam() {
            return this.avocadoForwardParam_;
        }

        public BarButton getBarButton(int i4) {
            return this.barButton_.get(i4);
        }

        public int getBarButtonCount() {
            return this.barButton_.size();
        }

        public List<BarButton> getBarButtonList() {
            return this.barButton_;
        }

        public a getBarTemplate() {
            return this.barTemplate_;
        }

        public String getBound() {
            return this.bound_;
        }

        public int getBrandIconId() {
            return this.brandIconId_;
        }

        public String getBuriedPoint() {
            return this.buriedPoint_;
        }

        public Button getButton() {
            return this.button_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public int getCardType() {
            return this.cardType_;
        }

        public String getChildCatalog() {
            return this.childCatalog_;
        }

        public String getCity() {
            return this.city_;
        }

        public a getCloudTemplate() {
            return this.cloudTemplate_;
        }

        public int getDetail() {
            return this.detail_;
        }

        public int getDetailDisplayType() {
            return this.detailDisplayType_;
        }

        public String getDistance() {
            return this.distance_;
        }

        public String getEndTime() {
            return this.endTime_;
        }

        public Ext getExt() {
            return this.ext_;
        }

        public int getFatherSon() {
            return this.fatherSon_;
        }

        public String getFavBubble() {
            return this.favBubble_;
        }

        public int getFavNum() {
            return this.favNum_;
        }

        public FixedBarButton getFixedBarButton(int i4) {
            return this.fixedBarButton_.get(i4);
        }

        public int getFixedBarButtonCount() {
            return this.fixedBarButton_.size();
        }

        public List<FixedBarButton> getFixedBarButtonList() {
            return this.fixedBarButton_;
        }

        public int getFourStateSwitch() {
            return this.fourStateSwitch_;
        }

        public String getGeo() {
            return this.geo_;
        }

        public String getGroupType() {
            return this.groupType_;
        }

        public GuildButton getGuildButton(int i4) {
            return this.guildButton_.get(i4);
        }

        public int getGuildButtonCount() {
            return this.guildButton_.size();
        }

        public List<GuildButton> getGuildButtonList() {
            return this.guildButton_;
        }

        public boolean getHalfKill() {
            return this.halfKill_;
        }

        public int getHasRtbus() {
            return this.hasRtbus_;
        }

        public HeadIcon getHeadIcon() {
            return this.headIcon_;
        }

        public HeadIconBubbleInfo getHeadIconBubbleInfo() {
            return this.headIconBubbleInfo_;
        }

        public a getHeadResultMsg() {
            return this.headResultMsg_;
        }

        public String getHeadway() {
            return this.headway_;
        }

        public HeatMap getHeatMap() {
            return this.heatMap_;
        }

        public String getHistoryAddress() {
            return this.historyAddress_;
        }

        public String getHorizonSlideData() {
            return this.horizonSlideData_;
        }

        public StartPageData getHwBrowseRecords() {
            return this.hwBrowseRecords_;
        }

        public int getIconId() {
            return this.iconId_;
        }

        public String getIndoorFloor() {
            return this.indoorFloor_;
        }

        public int getIndoorGeoz() {
            return this.indoorGeoz_;
        }

        public int getIndoorOverLooking() {
            return this.indoorOverLooking_;
        }

        public String getIndoorPano() {
            return this.indoorPano_;
        }

        public String getIndoorParentUid() {
            return this.indoorParentUid_;
        }

        public int getInfDynRequest() {
            return this.infDynRequest_;
        }

        public String getInterventTips() {
            return this.interventTips_;
        }

        public int getIsmodified() {
            return this.ismodified_;
        }

        public int getKindtype() {
            return this.kindtype_;
        }

        public int getListShow() {
            return this.listShow_;
        }

        public MapPoitag getMapPoitag() {
            return this.mapPoitag_;
        }

        public int getMaxShowLevel() {
            return this.maxShowLevel_;
        }

        public String getName() {
            return this.name_;
        }

        public String getNewCatalogId() {
            return this.newCatalogId_;
        }

        public Sgeo getNewsgeo() {
            return this.newsgeo_;
        }

        public int getPano() {
            return this.pano_;
        }

        public String getPhotoList() {
            return this.photoList_;
        }

        public String getPoiChildText() {
            return this.poiChildText_;
        }

        public String getPoiRegionType() {
            return this.poiRegionType_;
        }

        public PoiSimilar getPoiSimilar() {
            return this.poiSimilar_;
        }

        public int getPoiType() {
            return this.poiType_;
        }

        public String getPoiTypeText() {
            return this.poiTypeText_;
        }

        public String getProvince() {
            return this.province_;
        }

        public String getQueryGuide() {
            return this.queryGuide_;
        }

        public int getRank() {
            return this.rank_;
        }

        public String getRecReason(int i4) {
            return this.recReason_.get(i4);
        }

        public int getRecReasonCount() {
            return this.recReason_.size();
        }

        public List<String> getRecReasonList() {
            return this.recReason_;
        }

        public int getRecommendType() {
            return this.recommendType_;
        }

        public String getRegionType() {
            return this.regionType_;
        }

        public int getRtbusUpdateTime() {
            return this.rtbusUpdateTime_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iM = 0;
            int iL = hasGeo() ? d.l(1, getGeo()) : 0;
            if (hasName()) {
                iL += d.l(2, getName());
            }
            if (hasUid()) {
                iL += d.l(3, getUid());
            }
            if (hasAccFlag()) {
                iL += d.e(4, getAccFlag());
            }
            if (hasAddr()) {
                iL += d.l(5, getAddr());
            }
            if (hasDetail()) {
                iL += d.e(6, getDetail());
            }
            Iterator<String> it = getRecReasonList().iterator();
            while (it.hasNext()) {
                iM += d.m(it.next());
            }
            int size = getRecReasonList().size() + iL + iM;
            if (hasTel()) {
                size += d.l(8, getTel());
            }
            if (hasPoiType()) {
                size += d.e(9, getPoiType());
            }
            if (hasPano()) {
                size += d.e(10, getPano());
            }
            if (hasIndoorPano()) {
                size += d.l(11, getIndoorPano());
            }
            if (hasAoi()) {
                size += d.l(12, getAoi());
            }
            if (hasShow()) {
                size += d.h(13, getShow());
            }
            if (hasExt()) {
                size += d.h(14, getExt());
            }
            if (hasStartTime()) {
                size += d.l(15, getStartTime());
            }
            if (hasEndTime()) {
                size += d.l(16, getEndTime());
            }
            if (hasHasRtbus()) {
                size += d.e(17, getHasRtbus());
            }
            if (hasTipRtbus()) {
                size += d.l(18, getTipRtbus());
            }
            if (hasRtbusUpdateTime()) {
                size += d.e(19, getRtbusUpdateTime());
            }
            if (hasFatherSon()) {
                size += d.e(20, getFatherSon());
            }
            if (hasSgeo()) {
                size += d.h(21, getSgeo());
            }
            if (hasPoiTypeText()) {
                size += d.l(22, getPoiTypeText());
            }
            if (hasHeatMap()) {
                size += d.h(23, getHeatMap());
            }
            if (hasChildCatalog()) {
                size += d.l(24, getChildCatalog());
            }
            if (hasPoiChildText()) {
                size += d.l(25, getPoiChildText());
            }
            if (hasNewCatalogId()) {
                size += d.l(26, getNewCatalogId());
            }
            if (hasViewType()) {
                size += d.e(27, getViewType());
            }
            if (hasListShow()) {
                size += d.e(28, getListShow());
            }
            if (hasShowLevel()) {
                size += d.e(29, getShowLevel());
            }
            if (hasIconId()) {
                size += d.e(30, getIconId());
            }
            if (hasKindtype()) {
                size += d.e(31, getKindtype());
            }
            if (hasBrandIconId()) {
                size += d.e(32, getBrandIconId());
            }
            if (hasTag()) {
                size += d.e(33, getTag());
            }
            if (hasRank()) {
                size += d.e(34, getRank());
            }
            if (hasMaxShowLevel()) {
                size += d.e(35, getMaxShowLevel());
            }
            if (hasIndoorFloor()) {
                size += d.l(36, getIndoorFloor());
            }
            if (hasIndoorParentUid()) {
                size += d.l(37, getIndoorParentUid());
            }
            if (hasCloudTemplate()) {
                size += d.b(38, getCloudTemplate());
            }
            if (hasButton()) {
                size += d.h(39, getButton());
            }
            if (hasMapPoitag()) {
                size += d.h(40, getMapPoitag());
            }
            if (hasBarTemplate()) {
                size += d.b(41, getBarTemplate());
            }
            if (hasIsmodified()) {
                size += d.e(42, getIsmodified());
            }
            if (hasHeadway()) {
                size += d.l(43, getHeadway());
            }
            if (hasInterventTips()) {
                size += d.l(44, getInterventTips());
            }
            if (hasPoiRegionType()) {
                size += d.l(45, getPoiRegionType());
            }
            if (hasRegionType()) {
                size += d.l(46, getRegionType());
            }
            if (hasDistance()) {
                size += d.l(48, getDistance());
            }
            if (hasStdTag()) {
                size += d.l(49, getStdTag());
            }
            if (hasServiceTag()) {
                size += d.l(50, getServiceTag());
            }
            if (hasAreaName()) {
                size += d.l(51, getAreaName());
            }
            if (hasPhotoList()) {
                size += d.l(52, getPhotoList());
            }
            if (hasHeadIcon()) {
                size += d.h(53, getHeadIcon());
            }
            if (hasIndoorOverLooking()) {
                size += d.e(54, getIndoorOverLooking());
            }
            if (hasStdTagId()) {
                size += d.l(55, getStdTagId());
            }
            if (hasVuiProcessData()) {
                size += d.h(56, getVuiProcessData());
            }
            if (hasNewsgeo()) {
                size += d.h(57, getNewsgeo());
            }
            if (hasAttachedAddr()) {
                size += d.e(58, getAttachedAddr());
            }
            if (hasCity()) {
                size += d.l(59, getCity());
            }
            if (hasProvince()) {
                size += d.l(60, getProvince());
            }
            if (hasRecommendType()) {
                size += d.e(61, getRecommendType());
            }
            if (hasDetailDisplayType()) {
                size += d.e(62, getDetailDisplayType());
            }
            if (hasQueryGuide()) {
                size += d.l(63, getQueryGuide());
            }
            if (hasIndoorGeoz()) {
                size += d.e(64, getIndoorGeoz());
            }
            if (hasPoiSimilar()) {
                size += d.h(65, getPoiSimilar());
            }
            if (hasAvocadoForwardParam()) {
                size += d.l(66, getAvocadoForwardParam());
            }
            if (hasHorizonSlideData()) {
                size += d.l(67, getHorizonSlideData());
            }
            if (hasBuriedPoint()) {
                size += d.l(68, getBuriedPoint());
            }
            if (hasInfDynRequest()) {
                size += d.e(69, getInfDynRequest());
            }
            if (hasHalfKill()) {
                getHalfKill();
                size += d.a(70);
            }
            if (hasHeadIconBubbleInfo()) {
                size += d.h(71, getHeadIconBubbleInfo());
            }
            if (hasThirdParty()) {
                size += d.h(72, getThirdParty());
            }
            if (hasHeadResultMsg()) {
                size += d.b(73, getHeadResultMsg());
            }
            if (hasHwBrowseRecords()) {
                size += d.h(74, getHwBrowseRecords());
            }
            Iterator<BarButton> it2 = getBarButtonList().iterator();
            while (it2.hasNext()) {
                size += d.h(75, it2.next());
            }
            if (hasTravelButton()) {
                size += d.h(76, getTravelButton());
            }
            if (hasCardType()) {
                size += d.e(77, getCardType());
            }
            if (hasAdvertiseInfo()) {
                size += d.h(78, getAdvertiseInfo());
            }
            if (hasFourStateSwitch()) {
                size += d.e(79, getFourStateSwitch());
            }
            if (hasAdsData()) {
                size += d.h(80, getAdsData());
            }
            if (hasHistoryAddress()) {
                size += d.l(81, getHistoryAddress());
            }
            if (hasFavNum()) {
                size += d.e(82, getFavNum());
            }
            if (hasAispaceAds()) {
                size += d.h(83, getAispaceAds());
            }
            if (hasFavBubble()) {
                size += d.l(84, getFavBubble());
            }
            Iterator<GuildButton> it3 = getGuildButtonList().iterator();
            while (it3.hasNext()) {
                size += d.h(85, it3.next());
            }
            if (hasBound()) {
                size += d.l(86, getBound());
            }
            Iterator<FixedBarButton> it4 = getFixedBarButtonList().iterator();
            while (it4.hasNext()) {
                size += d.h(87, it4.next());
            }
            if (hasGroupType()) {
                size += d.l(88, getGroupType());
            }
            this.cachedSize = size;
            return size;
        }

        public String getServiceTag() {
            return this.serviceTag_;
        }

        public Sgeo getSgeo() {
            return this.sgeo_;
        }

        public Show getShow() {
            return this.show_;
        }

        public int getShowLevel() {
            return this.showLevel_;
        }

        public String getStartTime() {
            return this.startTime_;
        }

        public String getStdTag() {
            return this.stdTag_;
        }

        public String getStdTagId() {
            return this.stdTagId_;
        }

        public int getTag() {
            return this.tag_;
        }

        public String getTel() {
            return this.tel_;
        }

        public ThirdParty getThirdParty() {
            return this.thirdParty_;
        }

        public String getTipRtbus() {
            return this.tipRtbus_;
        }

        public TravelButton getTravelButton() {
            return this.travelButton_;
        }

        public String getUid() {
            return this.uid_;
        }

        public int getViewType() {
            return this.viewType_;
        }

        public VuiProcessData getVuiProcessData() {
            return this.vuiProcessData_;
        }

        public boolean hasAccFlag() {
            return this.hasAccFlag;
        }

        public boolean hasAddr() {
            return this.hasAddr;
        }

        public boolean hasAdsData() {
            return this.hasAdsData;
        }

        public boolean hasAdvertiseInfo() {
            return this.hasAdvertiseInfo;
        }

        public boolean hasAispaceAds() {
            return this.hasAispaceAds;
        }

        public boolean hasAoi() {
            return this.hasAoi;
        }

        public boolean hasAreaName() {
            return this.hasAreaName;
        }

        public boolean hasAttachedAddr() {
            return this.hasAttachedAddr;
        }

        public boolean hasAvocadoForwardParam() {
            return this.hasAvocadoForwardParam;
        }

        public boolean hasBarTemplate() {
            return this.hasBarTemplate;
        }

        public boolean hasBound() {
            return this.hasBound;
        }

        public boolean hasBrandIconId() {
            return this.hasBrandIconId;
        }

        public boolean hasBuriedPoint() {
            return this.hasBuriedPoint;
        }

        public boolean hasButton() {
            return this.hasButton;
        }

        public boolean hasCardType() {
            return this.hasCardType;
        }

        public boolean hasChildCatalog() {
            return this.hasChildCatalog;
        }

        public boolean hasCity() {
            return this.hasCity;
        }

        public boolean hasCloudTemplate() {
            return this.hasCloudTemplate;
        }

        public boolean hasDetail() {
            return this.hasDetail;
        }

        public boolean hasDetailDisplayType() {
            return this.hasDetailDisplayType;
        }

        public boolean hasDistance() {
            return this.hasDistance;
        }

        public boolean hasEndTime() {
            return this.hasEndTime;
        }

        public boolean hasExt() {
            return this.hasExt;
        }

        public boolean hasFatherSon() {
            return this.hasFatherSon;
        }

        public boolean hasFavBubble() {
            return this.hasFavBubble;
        }

        public boolean hasFavNum() {
            return this.hasFavNum;
        }

        public boolean hasFourStateSwitch() {
            return this.hasFourStateSwitch;
        }

        public boolean hasGeo() {
            return this.hasGeo;
        }

        public boolean hasGroupType() {
            return this.hasGroupType;
        }

        public boolean hasHalfKill() {
            return this.hasHalfKill;
        }

        public boolean hasHasRtbus() {
            return this.hasHasRtbus;
        }

        public boolean hasHeadIcon() {
            return this.hasHeadIcon;
        }

        public boolean hasHeadIconBubbleInfo() {
            return this.hasHeadIconBubbleInfo;
        }

        public boolean hasHeadResultMsg() {
            return this.hasHeadResultMsg;
        }

        public boolean hasHeadway() {
            return this.hasHeadway;
        }

        public boolean hasHeatMap() {
            return this.hasHeatMap;
        }

        public boolean hasHistoryAddress() {
            return this.hasHistoryAddress;
        }

        public boolean hasHorizonSlideData() {
            return this.hasHorizonSlideData;
        }

        public boolean hasHwBrowseRecords() {
            return this.hasHwBrowseRecords;
        }

        public boolean hasIconId() {
            return this.hasIconId;
        }

        public boolean hasIndoorFloor() {
            return this.hasIndoorFloor;
        }

        public boolean hasIndoorGeoz() {
            return this.hasIndoorGeoz;
        }

        public boolean hasIndoorOverLooking() {
            return this.hasIndoorOverLooking;
        }

        public boolean hasIndoorPano() {
            return this.hasIndoorPano;
        }

        public boolean hasIndoorParentUid() {
            return this.hasIndoorParentUid;
        }

        public boolean hasInfDynRequest() {
            return this.hasInfDynRequest;
        }

        public boolean hasInterventTips() {
            return this.hasInterventTips;
        }

        public boolean hasIsmodified() {
            return this.hasIsmodified;
        }

        public boolean hasKindtype() {
            return this.hasKindtype;
        }

        public boolean hasListShow() {
            return this.hasListShow;
        }

        public boolean hasMapPoitag() {
            return this.hasMapPoitag;
        }

        public boolean hasMaxShowLevel() {
            return this.hasMaxShowLevel;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public boolean hasNewCatalogId() {
            return this.hasNewCatalogId;
        }

        public boolean hasNewsgeo() {
            return this.hasNewsgeo;
        }

        public boolean hasPano() {
            return this.hasPano;
        }

        public boolean hasPhotoList() {
            return this.hasPhotoList;
        }

        public boolean hasPoiChildText() {
            return this.hasPoiChildText;
        }

        public boolean hasPoiRegionType() {
            return this.hasPoiRegionType;
        }

        public boolean hasPoiSimilar() {
            return this.hasPoiSimilar;
        }

        public boolean hasPoiType() {
            return this.hasPoiType;
        }

        public boolean hasPoiTypeText() {
            return this.hasPoiTypeText;
        }

        public boolean hasProvince() {
            return this.hasProvince;
        }

        public boolean hasQueryGuide() {
            return this.hasQueryGuide;
        }

        public boolean hasRank() {
            return this.hasRank;
        }

        public boolean hasRecommendType() {
            return this.hasRecommendType;
        }

        public boolean hasRegionType() {
            return this.hasRegionType;
        }

        public boolean hasRtbusUpdateTime() {
            return this.hasRtbusUpdateTime;
        }

        public boolean hasServiceTag() {
            return this.hasServiceTag;
        }

        public boolean hasSgeo() {
            return this.hasSgeo;
        }

        public boolean hasShow() {
            return this.hasShow;
        }

        public boolean hasShowLevel() {
            return this.hasShowLevel;
        }

        public boolean hasStartTime() {
            return this.hasStartTime;
        }

        public boolean hasStdTag() {
            return this.hasStdTag;
        }

        public boolean hasStdTagId() {
            return this.hasStdTagId;
        }

        public boolean hasTag() {
            return this.hasTag;
        }

        public boolean hasTel() {
            return this.hasTel;
        }

        public boolean hasThirdParty() {
            return this.hasThirdParty;
        }

        public boolean hasTipRtbus() {
            return this.hasTipRtbus;
        }

        public boolean hasTravelButton() {
            return this.hasTravelButton;
        }

        public boolean hasUid() {
            return this.hasUid;
        }

        public boolean hasViewType() {
            return this.hasViewType;
        }

        public boolean hasVuiProcessData() {
            return this.hasVuiProcessData;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Contents setAccFlag(int i4) {
            this.hasAccFlag = true;
            this.accFlag_ = i4;
            return this;
        }

        public Contents setAddr(String str) {
            this.hasAddr = true;
            this.addr_ = str;
            return this;
        }

        public Contents setAdsData(AdsData adsData) {
            if (adsData == null) {
                return clearAdsData();
            }
            this.hasAdsData = true;
            this.adsData_ = adsData;
            return this;
        }

        public Contents setAdvertiseInfo(AdvertiseInfo advertiseInfo) {
            if (advertiseInfo == null) {
                return clearAdvertiseInfo();
            }
            this.hasAdvertiseInfo = true;
            this.advertiseInfo_ = advertiseInfo;
            return this;
        }

        public Contents setAispaceAds(AispaceAds aispaceAds) {
            if (aispaceAds == null) {
                return clearAispaceAds();
            }
            this.hasAispaceAds = true;
            this.aispaceAds_ = aispaceAds;
            return this;
        }

        public Contents setAoi(String str) {
            this.hasAoi = true;
            this.aoi_ = str;
            return this;
        }

        public Contents setAreaName(String str) {
            this.hasAreaName = true;
            this.areaName_ = str;
            return this;
        }

        public Contents setAttachedAddr(int i4) {
            this.hasAttachedAddr = true;
            this.attachedAddr_ = i4;
            return this;
        }

        public Contents setAvocadoForwardParam(String str) {
            this.hasAvocadoForwardParam = true;
            this.avocadoForwardParam_ = str;
            return this;
        }

        public Contents setBarButton(int i4, BarButton barButton) {
            if (barButton == null) {
                return this;
            }
            this.barButton_.set(i4, barButton);
            return this;
        }

        public Contents setBarTemplate(a aVar) {
            this.hasBarTemplate = true;
            this.barTemplate_ = aVar;
            return this;
        }

        public Contents setBound(String str) {
            this.hasBound = true;
            this.bound_ = str;
            return this;
        }

        public Contents setBrandIconId(int i4) {
            this.hasBrandIconId = true;
            this.brandIconId_ = i4;
            return this;
        }

        public Contents setBuriedPoint(String str) {
            this.hasBuriedPoint = true;
            this.buriedPoint_ = str;
            return this;
        }

        public Contents setButton(Button button) {
            if (button == null) {
                return clearButton();
            }
            this.hasButton = true;
            this.button_ = button;
            return this;
        }

        public Contents setCardType(int i4) {
            this.hasCardType = true;
            this.cardType_ = i4;
            return this;
        }

        public Contents setChildCatalog(String str) {
            this.hasChildCatalog = true;
            this.childCatalog_ = str;
            return this;
        }

        public Contents setCity(String str) {
            this.hasCity = true;
            this.city_ = str;
            return this;
        }

        public Contents setCloudTemplate(a aVar) {
            this.hasCloudTemplate = true;
            this.cloudTemplate_ = aVar;
            return this;
        }

        public Contents setDetail(int i4) {
            this.hasDetail = true;
            this.detail_ = i4;
            return this;
        }

        public Contents setDetailDisplayType(int i4) {
            this.hasDetailDisplayType = true;
            this.detailDisplayType_ = i4;
            return this;
        }

        public Contents setDistance(String str) {
            this.hasDistance = true;
            this.distance_ = str;
            return this;
        }

        public Contents setEndTime(String str) {
            this.hasEndTime = true;
            this.endTime_ = str;
            return this;
        }

        public Contents setExt(Ext ext) {
            if (ext == null) {
                return clearExt();
            }
            this.hasExt = true;
            this.ext_ = ext;
            return this;
        }

        public Contents setFatherSon(int i4) {
            this.hasFatherSon = true;
            this.fatherSon_ = i4;
            return this;
        }

        public Contents setFavBubble(String str) {
            this.hasFavBubble = true;
            this.favBubble_ = str;
            return this;
        }

        public Contents setFavNum(int i4) {
            this.hasFavNum = true;
            this.favNum_ = i4;
            return this;
        }

        public Contents setFixedBarButton(int i4, FixedBarButton fixedBarButton) {
            if (fixedBarButton == null) {
                return this;
            }
            this.fixedBarButton_.set(i4, fixedBarButton);
            return this;
        }

        public Contents setFourStateSwitch(int i4) {
            this.hasFourStateSwitch = true;
            this.fourStateSwitch_ = i4;
            return this;
        }

        public Contents setGeo(String str) {
            this.hasGeo = true;
            this.geo_ = str;
            return this;
        }

        public Contents setGroupType(String str) {
            this.hasGroupType = true;
            this.groupType_ = str;
            return this;
        }

        public Contents setGuildButton(int i4, GuildButton guildButton) {
            if (guildButton == null) {
                return this;
            }
            this.guildButton_.set(i4, guildButton);
            return this;
        }

        public Contents setHalfKill(boolean z4) {
            this.hasHalfKill = true;
            this.halfKill_ = z4;
            return this;
        }

        public Contents setHasRtbus(int i4) {
            this.hasHasRtbus = true;
            this.hasRtbus_ = i4;
            return this;
        }

        public Contents setHeadIcon(HeadIcon headIcon) {
            if (headIcon == null) {
                return clearHeadIcon();
            }
            this.hasHeadIcon = true;
            this.headIcon_ = headIcon;
            return this;
        }

        public Contents setHeadIconBubbleInfo(HeadIconBubbleInfo headIconBubbleInfo) {
            if (headIconBubbleInfo == null) {
                return clearHeadIconBubbleInfo();
            }
            this.hasHeadIconBubbleInfo = true;
            this.headIconBubbleInfo_ = headIconBubbleInfo;
            return this;
        }

        public Contents setHeadResultMsg(a aVar) {
            this.hasHeadResultMsg = true;
            this.headResultMsg_ = aVar;
            return this;
        }

        public Contents setHeadway(String str) {
            this.hasHeadway = true;
            this.headway_ = str;
            return this;
        }

        public Contents setHeatMap(HeatMap heatMap) {
            if (heatMap == null) {
                return clearHeatMap();
            }
            this.hasHeatMap = true;
            this.heatMap_ = heatMap;
            return this;
        }

        public Contents setHistoryAddress(String str) {
            this.hasHistoryAddress = true;
            this.historyAddress_ = str;
            return this;
        }

        public Contents setHorizonSlideData(String str) {
            this.hasHorizonSlideData = true;
            this.horizonSlideData_ = str;
            return this;
        }

        public Contents setHwBrowseRecords(StartPageData startPageData) {
            if (startPageData == null) {
                return clearHwBrowseRecords();
            }
            this.hasHwBrowseRecords = true;
            this.hwBrowseRecords_ = startPageData;
            return this;
        }

        public Contents setIconId(int i4) {
            this.hasIconId = true;
            this.iconId_ = i4;
            return this;
        }

        public Contents setIndoorFloor(String str) {
            this.hasIndoorFloor = true;
            this.indoorFloor_ = str;
            return this;
        }

        public Contents setIndoorGeoz(int i4) {
            this.hasIndoorGeoz = true;
            this.indoorGeoz_ = i4;
            return this;
        }

        public Contents setIndoorOverLooking(int i4) {
            this.hasIndoorOverLooking = true;
            this.indoorOverLooking_ = i4;
            return this;
        }

        public Contents setIndoorPano(String str) {
            this.hasIndoorPano = true;
            this.indoorPano_ = str;
            return this;
        }

        public Contents setIndoorParentUid(String str) {
            this.hasIndoorParentUid = true;
            this.indoorParentUid_ = str;
            return this;
        }

        public Contents setInfDynRequest(int i4) {
            this.hasInfDynRequest = true;
            this.infDynRequest_ = i4;
            return this;
        }

        public Contents setInterventTips(String str) {
            this.hasInterventTips = true;
            this.interventTips_ = str;
            return this;
        }

        public Contents setIsmodified(int i4) {
            this.hasIsmodified = true;
            this.ismodified_ = i4;
            return this;
        }

        public Contents setKindtype(int i4) {
            this.hasKindtype = true;
            this.kindtype_ = i4;
            return this;
        }

        public Contents setListShow(int i4) {
            this.hasListShow = true;
            this.listShow_ = i4;
            return this;
        }

        public Contents setMapPoitag(MapPoitag mapPoitag) {
            if (mapPoitag == null) {
                return clearMapPoitag();
            }
            this.hasMapPoitag = true;
            this.mapPoitag_ = mapPoitag;
            return this;
        }

        public Contents setMaxShowLevel(int i4) {
            this.hasMaxShowLevel = true;
            this.maxShowLevel_ = i4;
            return this;
        }

        public Contents setName(String str) {
            this.hasName = true;
            this.name_ = str;
            return this;
        }

        public Contents setNewCatalogId(String str) {
            this.hasNewCatalogId = true;
            this.newCatalogId_ = str;
            return this;
        }

        public Contents setNewsgeo(Sgeo sgeo) {
            if (sgeo == null) {
                return clearNewsgeo();
            }
            this.hasNewsgeo = true;
            this.newsgeo_ = sgeo;
            return this;
        }

        public Contents setPano(int i4) {
            this.hasPano = true;
            this.pano_ = i4;
            return this;
        }

        public Contents setPhotoList(String str) {
            this.hasPhotoList = true;
            this.photoList_ = str;
            return this;
        }

        public Contents setPoiChildText(String str) {
            this.hasPoiChildText = true;
            this.poiChildText_ = str;
            return this;
        }

        public Contents setPoiRegionType(String str) {
            this.hasPoiRegionType = true;
            this.poiRegionType_ = str;
            return this;
        }

        public Contents setPoiSimilar(PoiSimilar poiSimilar) {
            if (poiSimilar == null) {
                return clearPoiSimilar();
            }
            this.hasPoiSimilar = true;
            this.poiSimilar_ = poiSimilar;
            return this;
        }

        public Contents setPoiType(int i4) {
            this.hasPoiType = true;
            this.poiType_ = i4;
            return this;
        }

        public Contents setPoiTypeText(String str) {
            this.hasPoiTypeText = true;
            this.poiTypeText_ = str;
            return this;
        }

        public Contents setProvince(String str) {
            this.hasProvince = true;
            this.province_ = str;
            return this;
        }

        public Contents setQueryGuide(String str) {
            this.hasQueryGuide = true;
            this.queryGuide_ = str;
            return this;
        }

        public Contents setRank(int i4) {
            this.hasRank = true;
            this.rank_ = i4;
            return this;
        }

        public Contents setRecReason(int i4, String str) {
            str.getClass();
            this.recReason_.set(i4, str);
            return this;
        }

        public Contents setRecommendType(int i4) {
            this.hasRecommendType = true;
            this.recommendType_ = i4;
            return this;
        }

        public Contents setRegionType(String str) {
            this.hasRegionType = true;
            this.regionType_ = str;
            return this;
        }

        public Contents setRtbusUpdateTime(int i4) {
            this.hasRtbusUpdateTime = true;
            this.rtbusUpdateTime_ = i4;
            return this;
        }

        public Contents setServiceTag(String str) {
            this.hasServiceTag = true;
            this.serviceTag_ = str;
            return this;
        }

        public Contents setSgeo(Sgeo sgeo) {
            if (sgeo == null) {
                return clearSgeo();
            }
            this.hasSgeo = true;
            this.sgeo_ = sgeo;
            return this;
        }

        public Contents setShow(Show show) {
            if (show == null) {
                return clearShow();
            }
            this.hasShow = true;
            this.show_ = show;
            return this;
        }

        public Contents setShowLevel(int i4) {
            this.hasShowLevel = true;
            this.showLevel_ = i4;
            return this;
        }

        public Contents setStartTime(String str) {
            this.hasStartTime = true;
            this.startTime_ = str;
            return this;
        }

        public Contents setStdTag(String str) {
            this.hasStdTag = true;
            this.stdTag_ = str;
            return this;
        }

        public Contents setStdTagId(String str) {
            this.hasStdTagId = true;
            this.stdTagId_ = str;
            return this;
        }

        public Contents setTag(int i4) {
            this.hasTag = true;
            this.tag_ = i4;
            return this;
        }

        public Contents setTel(String str) {
            this.hasTel = true;
            this.tel_ = str;
            return this;
        }

        public Contents setThirdParty(ThirdParty thirdParty) {
            if (thirdParty == null) {
                return clearThirdParty();
            }
            this.hasThirdParty = true;
            this.thirdParty_ = thirdParty;
            return this;
        }

        public Contents setTipRtbus(String str) {
            this.hasTipRtbus = true;
            this.tipRtbus_ = str;
            return this;
        }

        public Contents setTravelButton(TravelButton travelButton) {
            if (travelButton == null) {
                return clearTravelButton();
            }
            this.hasTravelButton = true;
            this.travelButton_ = travelButton;
            return this;
        }

        public Contents setUid(String str) {
            this.hasUid = true;
            this.uid_ = str;
            return this;
        }

        public Contents setViewType(int i4) {
            this.hasViewType = true;
            this.viewType_ = i4;
            return this;
        }

        public Contents setVuiProcessData(VuiProcessData vuiProcessData) {
            if (vuiProcessData == null) {
                return clearVuiProcessData();
            }
            this.hasVuiProcessData = true;
            this.vuiProcessData_ = vuiProcessData;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasGeo()) {
                dVar.A(1, getGeo());
            }
            if (hasName()) {
                dVar.A(2, getName());
            }
            if (hasUid()) {
                dVar.A(3, getUid());
            }
            if (hasAccFlag()) {
                dVar.s(4, getAccFlag());
            }
            if (hasAddr()) {
                dVar.A(5, getAddr());
            }
            if (hasDetail()) {
                dVar.s(6, getDetail());
            }
            Iterator<String> it = getRecReasonList().iterator();
            while (it.hasNext()) {
                dVar.A(7, it.next());
            }
            if (hasTel()) {
                dVar.A(8, getTel());
            }
            if (hasPoiType()) {
                dVar.s(9, getPoiType());
            }
            if (hasPano()) {
                dVar.s(10, getPano());
            }
            if (hasIndoorPano()) {
                dVar.A(11, getIndoorPano());
            }
            if (hasAoi()) {
                dVar.A(12, getAoi());
            }
            if (hasShow()) {
                dVar.u(13, getShow());
            }
            if (hasExt()) {
                dVar.u(14, getExt());
            }
            if (hasStartTime()) {
                dVar.A(15, getStartTime());
            }
            if (hasEndTime()) {
                dVar.A(16, getEndTime());
            }
            if (hasHasRtbus()) {
                dVar.s(17, getHasRtbus());
            }
            if (hasTipRtbus()) {
                dVar.A(18, getTipRtbus());
            }
            if (hasRtbusUpdateTime()) {
                dVar.s(19, getRtbusUpdateTime());
            }
            if (hasFatherSon()) {
                dVar.s(20, getFatherSon());
            }
            if (hasSgeo()) {
                dVar.u(21, getSgeo());
            }
            if (hasPoiTypeText()) {
                dVar.A(22, getPoiTypeText());
            }
            if (hasHeatMap()) {
                dVar.u(23, getHeatMap());
            }
            if (hasChildCatalog()) {
                dVar.A(24, getChildCatalog());
            }
            if (hasPoiChildText()) {
                dVar.A(25, getPoiChildText());
            }
            if (hasNewCatalogId()) {
                dVar.A(26, getNewCatalogId());
            }
            if (hasViewType()) {
                dVar.s(27, getViewType());
            }
            if (hasListShow()) {
                dVar.s(28, getListShow());
            }
            if (hasShowLevel()) {
                dVar.s(29, getShowLevel());
            }
            if (hasIconId()) {
                dVar.s(30, getIconId());
            }
            if (hasKindtype()) {
                dVar.s(31, getKindtype());
            }
            if (hasBrandIconId()) {
                dVar.s(32, getBrandIconId());
            }
            if (hasTag()) {
                dVar.s(33, getTag());
            }
            if (hasRank()) {
                dVar.s(34, getRank());
            }
            if (hasMaxShowLevel()) {
                dVar.s(35, getMaxShowLevel());
            }
            if (hasIndoorFloor()) {
                dVar.A(36, getIndoorFloor());
            }
            if (hasIndoorParentUid()) {
                dVar.A(37, getIndoorParentUid());
            }
            if (hasCloudTemplate()) {
                dVar.q(38, getCloudTemplate());
            }
            if (hasButton()) {
                dVar.u(39, getButton());
            }
            if (hasMapPoitag()) {
                dVar.u(40, getMapPoitag());
            }
            if (hasBarTemplate()) {
                dVar.q(41, getBarTemplate());
            }
            if (hasIsmodified()) {
                dVar.s(42, getIsmodified());
            }
            if (hasHeadway()) {
                dVar.A(43, getHeadway());
            }
            if (hasInterventTips()) {
                dVar.A(44, getInterventTips());
            }
            if (hasPoiRegionType()) {
                dVar.A(45, getPoiRegionType());
            }
            if (hasRegionType()) {
                dVar.A(46, getRegionType());
            }
            if (hasDistance()) {
                dVar.A(48, getDistance());
            }
            if (hasStdTag()) {
                dVar.A(49, getStdTag());
            }
            if (hasServiceTag()) {
                dVar.A(50, getServiceTag());
            }
            if (hasAreaName()) {
                dVar.A(51, getAreaName());
            }
            if (hasPhotoList()) {
                dVar.A(52, getPhotoList());
            }
            if (hasHeadIcon()) {
                dVar.u(53, getHeadIcon());
            }
            if (hasIndoorOverLooking()) {
                dVar.s(54, getIndoorOverLooking());
            }
            if (hasStdTagId()) {
                dVar.A(55, getStdTagId());
            }
            if (hasVuiProcessData()) {
                dVar.u(56, getVuiProcessData());
            }
            if (hasNewsgeo()) {
                dVar.u(57, getNewsgeo());
            }
            if (hasAttachedAddr()) {
                dVar.s(58, getAttachedAddr());
            }
            if (hasCity()) {
                dVar.A(59, getCity());
            }
            if (hasProvince()) {
                dVar.A(60, getProvince());
            }
            if (hasRecommendType()) {
                dVar.s(61, getRecommendType());
            }
            if (hasDetailDisplayType()) {
                dVar.s(62, getDetailDisplayType());
            }
            if (hasQueryGuide()) {
                dVar.A(63, getQueryGuide());
            }
            if (hasIndoorGeoz()) {
                dVar.s(64, getIndoorGeoz());
            }
            if (hasPoiSimilar()) {
                dVar.u(65, getPoiSimilar());
            }
            if (hasAvocadoForwardParam()) {
                dVar.A(66, getAvocadoForwardParam());
            }
            if (hasHorizonSlideData()) {
                dVar.A(67, getHorizonSlideData());
            }
            if (hasBuriedPoint()) {
                dVar.A(68, getBuriedPoint());
            }
            if (hasInfDynRequest()) {
                dVar.s(69, getInfDynRequest());
            }
            if (hasHalfKill()) {
                dVar.p(70, getHalfKill());
            }
            if (hasHeadIconBubbleInfo()) {
                dVar.u(71, getHeadIconBubbleInfo());
            }
            if (hasThirdParty()) {
                dVar.u(72, getThirdParty());
            }
            if (hasHeadResultMsg()) {
                dVar.q(73, getHeadResultMsg());
            }
            if (hasHwBrowseRecords()) {
                dVar.u(74, getHwBrowseRecords());
            }
            Iterator<BarButton> it2 = getBarButtonList().iterator();
            while (it2.hasNext()) {
                dVar.u(75, it2.next());
            }
            if (hasTravelButton()) {
                dVar.u(76, getTravelButton());
            }
            if (hasCardType()) {
                dVar.s(77, getCardType());
            }
            if (hasAdvertiseInfo()) {
                dVar.u(78, getAdvertiseInfo());
            }
            if (hasFourStateSwitch()) {
                dVar.s(79, getFourStateSwitch());
            }
            if (hasAdsData()) {
                dVar.u(80, getAdsData());
            }
            if (hasHistoryAddress()) {
                dVar.A(81, getHistoryAddress());
            }
            if (hasFavNum()) {
                dVar.s(82, getFavNum());
            }
            if (hasAispaceAds()) {
                dVar.u(83, getAispaceAds());
            }
            if (hasFavBubble()) {
                dVar.A(84, getFavBubble());
            }
            Iterator<GuildButton> it3 = getGuildButtonList().iterator();
            while (it3.hasNext()) {
                dVar.u(85, it3.next());
            }
            if (hasBound()) {
                dVar.A(86, getBound());
            }
            Iterator<FixedBarButton> it4 = getFixedBarButtonList().iterator();
            while (it4.hasNext()) {
                dVar.u(87, it4.next());
            }
            if (hasGroupType()) {
                dVar.A(88, getGroupType());
            }
        }

        public static Contents parseFrom(byte[] bArr) throws e {
            return (Contents) new Contents().mergeFrom(bArr);
        }

        @Override // L1.f
        public Contents mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                switch (iO) {
                    case 0:
                        return this;
                    case 10:
                        setGeo(bVar.n());
                        break;
                    case 18:
                        setName(bVar.n());
                        break;
                    case 26:
                        setUid(bVar.n());
                        break;
                    case 32:
                        setAccFlag(bVar.k());
                        break;
                    case 42:
                        setAddr(bVar.n());
                        break;
                    case 48:
                        setDetail(bVar.k());
                        break;
                    case 58:
                        addRecReason(bVar.n());
                        break;
                    case 66:
                        setTel(bVar.n());
                        break;
                    case 72:
                        setPoiType(bVar.k());
                        break;
                    case 80:
                        setPano(bVar.k());
                        break;
                    case 90:
                        setIndoorPano(bVar.n());
                        break;
                    case 98:
                        setAoi(bVar.n());
                        break;
                    case 106:
                        Show show = new Show();
                        bVar.f(show);
                        setShow(show);
                        break;
                    case 114:
                        Ext ext = new Ext();
                        bVar.f(ext);
                        setExt(ext);
                        break;
                    case 122:
                        setStartTime(bVar.n());
                        break;
                    case 130:
                        setEndTime(bVar.n());
                        break;
                    case SyslogConstants.LOG_LOCAL1 /* 136 */:
                        setHasRtbus(bVar.k());
                        break;
                    case 146:
                        setTipRtbus(bVar.n());
                        break;
                    case SyslogConstants.LOG_LOCAL3 /* 152 */:
                        setRtbusUpdateTime(bVar.k());
                        break;
                    case 160:
                        setFatherSon(bVar.k());
                        break;
                    case 170:
                        Sgeo sgeo = new Sgeo();
                        bVar.f(sgeo);
                        setSgeo(sgeo);
                        break;
                    case Opcodes.GETSTATIC /* 178 */:
                        setPoiTypeText(bVar.n());
                        break;
                    case 186:
                        HeatMap heatMap = new HeatMap();
                        bVar.f(heatMap);
                        setHeatMap(heatMap);
                        break;
                    case 194:
                        setChildCatalog(bVar.n());
                        break;
                    case LicenseCode.CODE_LICENSE_SERVICE_LICENSE_SIGN_ERROR /* 202 */:
                        setPoiChildText(bVar.n());
                        break;
                    case 210:
                        setNewCatalogId(bVar.n());
                        break;
                    case 216:
                        setViewType(bVar.k());
                        break;
                    case 224:
                        setListShow(bVar.k());
                        break;
                    case 232:
                        setShowLevel(bVar.k());
                        break;
                    case 240:
                        setIconId(bVar.k());
                        break;
                    case 248:
                        setKindtype(bVar.k());
                        break;
                    case 256:
                        setBrandIconId(bVar.k());
                        break;
                    case 264:
                        setTag(bVar.k());
                        break;
                    case 272:
                        setRank(bVar.k());
                        break;
                    case 280:
                        setMaxShowLevel(bVar.k());
                        break;
                    case 290:
                        setIndoorFloor(bVar.n());
                        break;
                    case 298:
                        setIndoorParentUid(bVar.n());
                        break;
                    case 306:
                        setCloudTemplate(bVar.b());
                        break;
                    case 314:
                        Button button = new Button();
                        bVar.f(button);
                        setButton(button);
                        break;
                    case 322:
                        MapPoitag mapPoitag = new MapPoitag();
                        bVar.f(mapPoitag);
                        setMapPoitag(mapPoitag);
                        break;
                    case 330:
                        setBarTemplate(bVar.b());
                        break;
                    case 336:
                        setIsmodified(bVar.k());
                        break;
                    case 346:
                        setHeadway(bVar.n());
                        break;
                    case 354:
                        setInterventTips(bVar.n());
                        break;
                    case 362:
                        setPoiRegionType(bVar.n());
                        break;
                    case 370:
                        setRegionType(bVar.n());
                        break;
                    case 386:
                        setDistance(bVar.n());
                        break;
                    case 394:
                        setStdTag(bVar.n());
                        break;
                    case 402:
                        setServiceTag(bVar.n());
                        break;
                    case 410:
                        setAreaName(bVar.n());
                        break;
                    case 418:
                        setPhotoList(bVar.n());
                        break;
                    case 426:
                        HeadIcon headIcon = new HeadIcon();
                        bVar.f(headIcon);
                        setHeadIcon(headIcon);
                        break;
                    case 432:
                        setIndoorOverLooking(bVar.k());
                        break;
                    case 442:
                        setStdTagId(bVar.n());
                        break;
                    case 450:
                        VuiProcessData vuiProcessData = new VuiProcessData();
                        bVar.f(vuiProcessData);
                        setVuiProcessData(vuiProcessData);
                        break;
                    case 458:
                        Sgeo sgeo2 = new Sgeo();
                        bVar.f(sgeo2);
                        setNewsgeo(sgeo2);
                        break;
                    case 464:
                        setAttachedAddr(bVar.k());
                        break;
                    case 474:
                        setCity(bVar.n());
                        break;
                    case 482:
                        setProvince(bVar.n());
                        break;
                    case 488:
                        setRecommendType(bVar.k());
                        break;
                    case 496:
                        setDetailDisplayType(bVar.k());
                        break;
                    case 506:
                        setQueryGuide(bVar.n());
                        break;
                    case 512:
                        setIndoorGeoz(bVar.k());
                        break;
                    case 522:
                        PoiSimilar poiSimilar = new PoiSimilar();
                        bVar.f(poiSimilar);
                        setPoiSimilar(poiSimilar);
                        break;
                    case 530:
                        setAvocadoForwardParam(bVar.n());
                        break;
                    case 538:
                        setHorizonSlideData(bVar.n());
                        break;
                    case 546:
                        setBuriedPoint(bVar.n());
                        break;
                    case 552:
                        setInfDynRequest(bVar.k());
                        break;
                    case 560:
                        setHalfKill(bVar.a());
                        break;
                    case 570:
                        HeadIconBubbleInfo headIconBubbleInfo = new HeadIconBubbleInfo();
                        bVar.f(headIconBubbleInfo);
                        setHeadIconBubbleInfo(headIconBubbleInfo);
                        break;
                    case 578:
                        ThirdParty thirdParty = new ThirdParty();
                        bVar.f(thirdParty);
                        setThirdParty(thirdParty);
                        break;
                    case 586:
                        setHeadResultMsg(bVar.b());
                        break;
                    case 594:
                        StartPageData startPageData = new StartPageData();
                        bVar.f(startPageData);
                        setHwBrowseRecords(startPageData);
                        break;
                    case 602:
                        BarButton barButton = new BarButton();
                        bVar.f(barButton);
                        addBarButton(barButton);
                        break;
                    case 610:
                        TravelButton travelButton = new TravelButton();
                        bVar.f(travelButton);
                        setTravelButton(travelButton);
                        break;
                    case 616:
                        setCardType(bVar.k());
                        break;
                    case 626:
                        AdvertiseInfo advertiseInfo = new AdvertiseInfo();
                        bVar.f(advertiseInfo);
                        setAdvertiseInfo(advertiseInfo);
                        break;
                    case 632:
                        setFourStateSwitch(bVar.k());
                        break;
                    case 642:
                        AdsData adsData = new AdsData();
                        bVar.f(adsData);
                        setAdsData(adsData);
                        break;
                    case 650:
                        setHistoryAddress(bVar.n());
                        break;
                    case 656:
                        setFavNum(bVar.k());
                        break;
                    case 666:
                        AispaceAds aispaceAds = new AispaceAds();
                        bVar.f(aispaceAds);
                        setAispaceAds(aispaceAds);
                        break;
                    case 674:
                        setFavBubble(bVar.n());
                        break;
                    case 682:
                        GuildButton guildButton = new GuildButton();
                        bVar.f(guildButton);
                        addGuildButton(guildButton);
                        break;
                    case 690:
                        setBound(bVar.n());
                        break;
                    case 698:
                        FixedBarButton fixedBarButton = new FixedBarButton();
                        bVar.f(fixedBarButton);
                        addFixedBarButton(fixedBarButton);
                        break;
                    case 706:
                        setGroupType(bVar.n());
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

    public static final class CorrectionInfo extends f {
        public static final int ASSIST_INFO_FIELD_NUMBER = 2;
        public static final int CORRECTION_QUERYS_FIELD_NUMBER = 4;
        public static final int CORRECTION_TYPE_FIELD_NUMBER = 3;
        public static final int ORI_WORD_FIELD_NUMBER = 6;
        public static final int TITLE_FIELD_NUMBER = 1;
        public static final int TITLE_H_FIELD_NUMBER = 5;
        private boolean hasAssistInfo;
        private boolean hasCorrectionType;
        private boolean hasOriWord;
        private boolean hasTitle;
        private boolean hasTitleH;
        private String title_ = "";
        private String assistInfo_ = "";
        private int correctionType_ = 0;
        private List<CorrectionQuerys> correctionQuerys_ = Collections.emptyList();
        private String titleH_ = "";
        private String oriWord_ = "";
        private int cachedSize = -1;

        public static final class CorrectionQuerys extends f {
            public static final int QUERY_ASSIST_INFO_FIELD_NUMBER = 2;
            public static final int QUERY_FIELD_NUMBER = 1;
            public static final int QUERY_WORD_FIELD_NUMBER = 3;
            private boolean hasQuery;
            private boolean hasQueryAssistInfo;
            private boolean hasQueryWord;
            private String query_ = "";
            private String queryAssistInfo_ = "";
            private String queryWord_ = "";
            private int cachedSize = -1;

            public static CorrectionQuerys parseFrom(b bVar) throws IOException {
                return new CorrectionQuerys().mergeFrom(bVar);
            }

            public final CorrectionQuerys clear() {
                clearQuery();
                clearQueryAssistInfo();
                clearQueryWord();
                this.cachedSize = -1;
                return this;
            }

            public CorrectionQuerys clearQuery() {
                this.hasQuery = false;
                this.query_ = "";
                return this;
            }

            public CorrectionQuerys clearQueryAssistInfo() {
                this.hasQueryAssistInfo = false;
                this.queryAssistInfo_ = "";
                return this;
            }

            public CorrectionQuerys clearQueryWord() {
                this.hasQueryWord = false;
                this.queryWord_ = "";
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

            public String getQueryAssistInfo() {
                return this.queryAssistInfo_;
            }

            public String getQueryWord() {
                return this.queryWord_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasQuery() ? d.l(1, getQuery()) : 0;
                if (hasQueryAssistInfo()) {
                    iL += d.l(2, getQueryAssistInfo());
                }
                if (hasQueryWord()) {
                    iL += d.l(3, getQueryWord());
                }
                this.cachedSize = iL;
                return iL;
            }

            public boolean hasQuery() {
                return this.hasQuery;
            }

            public boolean hasQueryAssistInfo() {
                return this.hasQueryAssistInfo;
            }

            public boolean hasQueryWord() {
                return this.hasQueryWord;
            }

            public final boolean isInitialized() {
                return true;
            }

            public CorrectionQuerys setQuery(String str) {
                this.hasQuery = true;
                this.query_ = str;
                return this;
            }

            public CorrectionQuerys setQueryAssistInfo(String str) {
                this.hasQueryAssistInfo = true;
                this.queryAssistInfo_ = str;
                return this;
            }

            public CorrectionQuerys setQueryWord(String str) {
                this.hasQueryWord = true;
                this.queryWord_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasQuery()) {
                    dVar.A(1, getQuery());
                }
                if (hasQueryAssistInfo()) {
                    dVar.A(2, getQueryAssistInfo());
                }
                if (hasQueryWord()) {
                    dVar.A(3, getQueryWord());
                }
            }

            public static CorrectionQuerys parseFrom(byte[] bArr) throws e {
                return (CorrectionQuerys) new CorrectionQuerys().mergeFrom(bArr);
            }

            @Override // L1.f
            public CorrectionQuerys mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setQuery(bVar.n());
                    } else if (iO == 18) {
                        setQueryAssistInfo(bVar.n());
                    } else if (iO == 26) {
                        setQueryWord(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static CorrectionInfo parseFrom(b bVar) throws IOException {
            return new CorrectionInfo().mergeFrom(bVar);
        }

        public CorrectionInfo addCorrectionQuerys(CorrectionQuerys correctionQuerys) {
            if (correctionQuerys == null) {
                return this;
            }
            if (this.correctionQuerys_.isEmpty()) {
                this.correctionQuerys_ = new ArrayList();
            }
            this.correctionQuerys_.add(correctionQuerys);
            return this;
        }

        public final CorrectionInfo clear() {
            clearTitle();
            clearAssistInfo();
            clearCorrectionType();
            clearCorrectionQuerys();
            clearTitleH();
            clearOriWord();
            this.cachedSize = -1;
            return this;
        }

        public CorrectionInfo clearAssistInfo() {
            this.hasAssistInfo = false;
            this.assistInfo_ = "";
            return this;
        }

        public CorrectionInfo clearCorrectionQuerys() {
            this.correctionQuerys_ = Collections.emptyList();
            return this;
        }

        public CorrectionInfo clearCorrectionType() {
            this.hasCorrectionType = false;
            this.correctionType_ = 0;
            return this;
        }

        public CorrectionInfo clearOriWord() {
            this.hasOriWord = false;
            this.oriWord_ = "";
            return this;
        }

        public CorrectionInfo clearTitle() {
            this.hasTitle = false;
            this.title_ = "";
            return this;
        }

        public CorrectionInfo clearTitleH() {
            this.hasTitleH = false;
            this.titleH_ = "";
            return this;
        }

        public String getAssistInfo() {
            return this.assistInfo_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public CorrectionQuerys getCorrectionQuerys(int i4) {
            return this.correctionQuerys_.get(i4);
        }

        public int getCorrectionQuerysCount() {
            return this.correctionQuerys_.size();
        }

        public List<CorrectionQuerys> getCorrectionQuerysList() {
            return this.correctionQuerys_;
        }

        public int getCorrectionType() {
            return this.correctionType_;
        }

        public String getOriWord() {
            return this.oriWord_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasTitle() ? d.l(1, getTitle()) : 0;
            if (hasAssistInfo()) {
                iL += d.l(2, getAssistInfo());
            }
            if (hasCorrectionType()) {
                iL += d.e(3, getCorrectionType());
            }
            Iterator<CorrectionQuerys> it = getCorrectionQuerysList().iterator();
            while (it.hasNext()) {
                iL += d.h(4, it.next());
            }
            if (hasTitleH()) {
                iL += d.l(5, getTitleH());
            }
            if (hasOriWord()) {
                iL += d.l(6, getOriWord());
            }
            this.cachedSize = iL;
            return iL;
        }

        public String getTitle() {
            return this.title_;
        }

        public String getTitleH() {
            return this.titleH_;
        }

        public boolean hasAssistInfo() {
            return this.hasAssistInfo;
        }

        public boolean hasCorrectionType() {
            return this.hasCorrectionType;
        }

        public boolean hasOriWord() {
            return this.hasOriWord;
        }

        public boolean hasTitle() {
            return this.hasTitle;
        }

        public boolean hasTitleH() {
            return this.hasTitleH;
        }

        public final boolean isInitialized() {
            return true;
        }

        public CorrectionInfo setAssistInfo(String str) {
            this.hasAssistInfo = true;
            this.assistInfo_ = str;
            return this;
        }

        public CorrectionInfo setCorrectionQuerys(int i4, CorrectionQuerys correctionQuerys) {
            if (correctionQuerys == null) {
                return this;
            }
            this.correctionQuerys_.set(i4, correctionQuerys);
            return this;
        }

        public CorrectionInfo setCorrectionType(int i4) {
            this.hasCorrectionType = true;
            this.correctionType_ = i4;
            return this;
        }

        public CorrectionInfo setOriWord(String str) {
            this.hasOriWord = true;
            this.oriWord_ = str;
            return this;
        }

        public CorrectionInfo setTitle(String str) {
            this.hasTitle = true;
            this.title_ = str;
            return this;
        }

        public CorrectionInfo setTitleH(String str) {
            this.hasTitleH = true;
            this.titleH_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasTitle()) {
                dVar.A(1, getTitle());
            }
            if (hasAssistInfo()) {
                dVar.A(2, getAssistInfo());
            }
            if (hasCorrectionType()) {
                dVar.s(3, getCorrectionType());
            }
            Iterator<CorrectionQuerys> it = getCorrectionQuerysList().iterator();
            while (it.hasNext()) {
                dVar.u(4, it.next());
            }
            if (hasTitleH()) {
                dVar.A(5, getTitleH());
            }
            if (hasOriWord()) {
                dVar.A(6, getOriWord());
            }
        }

        public static CorrectionInfo parseFrom(byte[] bArr) throws e {
            return (CorrectionInfo) new CorrectionInfo().mergeFrom(bArr);
        }

        @Override // L1.f
        public CorrectionInfo mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setTitle(bVar.n());
                } else if (iO == 18) {
                    setAssistInfo(bVar.n());
                } else if (iO == 24) {
                    setCorrectionType(bVar.k());
                } else if (iO == 34) {
                    CorrectionQuerys correctionQuerys = new CorrectionQuerys();
                    bVar.f(correctionQuerys);
                    addCorrectionQuerys(correctionQuerys);
                } else if (iO == 42) {
                    setTitleH(bVar.n());
                } else if (iO == 50) {
                    setOriWord(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class ExpFeedbackButton extends f {
        public static final int ICON_URL_FIELD_NUMBER = 1;
        public static final int JUMP_URL_FIELD_NUMBER = 5;
        public static final int RICH_TEXT_FIELD_NUMBER = 3;
        public static final int SELECTED_ICON_URL_FIELD_NUMBER = 2;
        public static final int SELECTED_RICH_TEXT_FIELD_NUMBER = 4;
        private boolean hasIconUrl;
        private boolean hasJumpUrl;
        private boolean hasRichText;
        private boolean hasSelectedIconUrl;
        private boolean hasSelectedRichText;
        private String iconUrl_ = "";
        private String selectedIconUrl_ = "";
        private String richText_ = "";
        private String selectedRichText_ = "";
        private String jumpUrl_ = "";
        private int cachedSize = -1;

        public static ExpFeedbackButton parseFrom(b bVar) throws IOException {
            return new ExpFeedbackButton().mergeFrom(bVar);
        }

        public final ExpFeedbackButton clear() {
            clearIconUrl();
            clearSelectedIconUrl();
            clearRichText();
            clearSelectedRichText();
            clearJumpUrl();
            this.cachedSize = -1;
            return this;
        }

        public ExpFeedbackButton clearIconUrl() {
            this.hasIconUrl = false;
            this.iconUrl_ = "";
            return this;
        }

        public ExpFeedbackButton clearJumpUrl() {
            this.hasJumpUrl = false;
            this.jumpUrl_ = "";
            return this;
        }

        public ExpFeedbackButton clearRichText() {
            this.hasRichText = false;
            this.richText_ = "";
            return this;
        }

        public ExpFeedbackButton clearSelectedIconUrl() {
            this.hasSelectedIconUrl = false;
            this.selectedIconUrl_ = "";
            return this;
        }

        public ExpFeedbackButton clearSelectedRichText() {
            this.hasSelectedRichText = false;
            this.selectedRichText_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getIconUrl() {
            return this.iconUrl_;
        }

        public String getJumpUrl() {
            return this.jumpUrl_;
        }

        public String getRichText() {
            return this.richText_;
        }

        public String getSelectedIconUrl() {
            return this.selectedIconUrl_;
        }

        public String getSelectedRichText() {
            return this.selectedRichText_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasIconUrl() ? d.l(1, getIconUrl()) : 0;
            if (hasSelectedIconUrl()) {
                iL += d.l(2, getSelectedIconUrl());
            }
            if (hasRichText()) {
                iL += d.l(3, getRichText());
            }
            if (hasSelectedRichText()) {
                iL += d.l(4, getSelectedRichText());
            }
            if (hasJumpUrl()) {
                iL += d.l(5, getJumpUrl());
            }
            this.cachedSize = iL;
            return iL;
        }

        public boolean hasIconUrl() {
            return this.hasIconUrl;
        }

        public boolean hasJumpUrl() {
            return this.hasJumpUrl;
        }

        public boolean hasRichText() {
            return this.hasRichText;
        }

        public boolean hasSelectedIconUrl() {
            return this.hasSelectedIconUrl;
        }

        public boolean hasSelectedRichText() {
            return this.hasSelectedRichText;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ExpFeedbackButton setIconUrl(String str) {
            this.hasIconUrl = true;
            this.iconUrl_ = str;
            return this;
        }

        public ExpFeedbackButton setJumpUrl(String str) {
            this.hasJumpUrl = true;
            this.jumpUrl_ = str;
            return this;
        }

        public ExpFeedbackButton setRichText(String str) {
            this.hasRichText = true;
            this.richText_ = str;
            return this;
        }

        public ExpFeedbackButton setSelectedIconUrl(String str) {
            this.hasSelectedIconUrl = true;
            this.selectedIconUrl_ = str;
            return this;
        }

        public ExpFeedbackButton setSelectedRichText(String str) {
            this.hasSelectedRichText = true;
            this.selectedRichText_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasIconUrl()) {
                dVar.A(1, getIconUrl());
            }
            if (hasSelectedIconUrl()) {
                dVar.A(2, getSelectedIconUrl());
            }
            if (hasRichText()) {
                dVar.A(3, getRichText());
            }
            if (hasSelectedRichText()) {
                dVar.A(4, getSelectedRichText());
            }
            if (hasJumpUrl()) {
                dVar.A(5, getJumpUrl());
            }
        }

        public static ExpFeedbackButton parseFrom(byte[] bArr) throws e {
            return (ExpFeedbackButton) new ExpFeedbackButton().mergeFrom(bArr);
        }

        @Override // L1.f
        public ExpFeedbackButton mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setIconUrl(bVar.n());
                } else if (iO == 18) {
                    setSelectedIconUrl(bVar.n());
                } else if (iO == 26) {
                    setRichText(bVar.n());
                } else if (iO == 34) {
                    setSelectedRichText(bVar.n());
                } else if (iO == 42) {
                    setJumpUrl(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class ExpFeedbackInfo extends f {
        public static final int BUTTONS_FIELD_NUMBER = 2;
        public static final int MORE_TEXT_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 1;
        private boolean hasMoreText;
        private boolean hasTitle;
        private String title_ = "";
        private List<ExpFeedbackButton> buttons_ = Collections.emptyList();
        private String moreText_ = "";
        private int cachedSize = -1;

        public static ExpFeedbackInfo parseFrom(b bVar) throws IOException {
            return new ExpFeedbackInfo().mergeFrom(bVar);
        }

        public ExpFeedbackInfo addButtons(ExpFeedbackButton expFeedbackButton) {
            if (expFeedbackButton == null) {
                return this;
            }
            if (this.buttons_.isEmpty()) {
                this.buttons_ = new ArrayList();
            }
            this.buttons_.add(expFeedbackButton);
            return this;
        }

        public final ExpFeedbackInfo clear() {
            clearTitle();
            clearButtons();
            clearMoreText();
            this.cachedSize = -1;
            return this;
        }

        public ExpFeedbackInfo clearButtons() {
            this.buttons_ = Collections.emptyList();
            return this;
        }

        public ExpFeedbackInfo clearMoreText() {
            this.hasMoreText = false;
            this.moreText_ = "";
            return this;
        }

        public ExpFeedbackInfo clearTitle() {
            this.hasTitle = false;
            this.title_ = "";
            return this;
        }

        public ExpFeedbackButton getButtons(int i4) {
            return this.buttons_.get(i4);
        }

        public int getButtonsCount() {
            return this.buttons_.size();
        }

        public List<ExpFeedbackButton> getButtonsList() {
            return this.buttons_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getMoreText() {
            return this.moreText_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasTitle() ? d.l(1, getTitle()) : 0;
            Iterator<ExpFeedbackButton> it = getButtonsList().iterator();
            while (it.hasNext()) {
                iL += d.h(2, it.next());
            }
            if (hasMoreText()) {
                iL += d.l(3, getMoreText());
            }
            this.cachedSize = iL;
            return iL;
        }

        public String getTitle() {
            return this.title_;
        }

        public boolean hasMoreText() {
            return this.hasMoreText;
        }

        public boolean hasTitle() {
            return this.hasTitle;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ExpFeedbackInfo setButtons(int i4, ExpFeedbackButton expFeedbackButton) {
            if (expFeedbackButton == null) {
                return this;
            }
            this.buttons_.set(i4, expFeedbackButton);
            return this;
        }

        public ExpFeedbackInfo setMoreText(String str) {
            this.hasMoreText = true;
            this.moreText_ = str;
            return this;
        }

        public ExpFeedbackInfo setTitle(String str) {
            this.hasTitle = true;
            this.title_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasTitle()) {
                dVar.A(1, getTitle());
            }
            Iterator<ExpFeedbackButton> it = getButtonsList().iterator();
            while (it.hasNext()) {
                dVar.u(2, it.next());
            }
            if (hasMoreText()) {
                dVar.A(3, getMoreText());
            }
        }

        public static ExpFeedbackInfo parseFrom(byte[] bArr) throws e {
            return (ExpFeedbackInfo) new ExpFeedbackInfo().mergeFrom(bArr);
        }

        @Override // L1.f
        public ExpFeedbackInfo mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setTitle(bVar.n());
                } else if (iO == 18) {
                    ExpFeedbackButton expFeedbackButton = new ExpFeedbackButton();
                    bVar.f(expFeedbackButton);
                    addButtons(expFeedbackButton);
                } else if (iO == 26) {
                    setMoreText(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class FloatIcon extends f {
        public static final int ADD_TO_HOMEPAGE = 3;
        public static final int BACK = 2;
        public static final int BOTTOM_RIGHT = 2;
        public static final int CLICK_KEY_FIELD_NUMBER = 6;
        public static final int HIDE = 0;
        public static final int HIDE_WHEN_SLIDE_FIELD_NUMBER = 4;
        public static final int ICON_IMG_FIELD_NUMBER = 1;
        public static final int JUMP_INFO_FIELD_NUMBER = 3;
        public static final int PARAM_FIELD_NUMBER = 7;
        public static final int POS_FIELD_NUMBER = 2;
        public static final int SHOW_KEY_FIELD_NUMBER = 5;
        public static final int SWITCH_SLIDE_MODE = 1;
        public static final int TOP_LEFT = 1;
        public static final int URL = 0;
        private boolean hasClickKey;
        private boolean hasHideWhenSlide;
        private boolean hasIconImg;
        private boolean hasJumpInfo;
        private boolean hasParam;
        private boolean hasPos;
        private boolean hasShowKey;
        private String iconImg_ = "";
        private IconPosition pos_ = null;
        private JumpInfo jumpInfo_ = null;
        private boolean hideWhenSlide_ = false;
        private String showKey_ = "";
        private String clickKey_ = "";
        private String param_ = "";
        private int cachedSize = -1;

        public static final class IconPosition extends f {
            public static final int LIST_HIDE_FIELD_NUMBER = 2;
            public static final int LIST_NORMAL_FIELD_NUMBER = 1;
            public static final int SLIDE_FIELD_NUMBER = 3;
            private boolean hasListHide;
            private boolean hasListNormal;
            private boolean hasSlide;
            private int listNormal_ = 0;
            private int listHide_ = 0;
            private int slide_ = 0;
            private int cachedSize = -1;

            public static IconPosition parseFrom(b bVar) throws IOException {
                return new IconPosition().mergeFrom(bVar);
            }

            public final IconPosition clear() {
                clearListNormal();
                clearListHide();
                clearSlide();
                this.cachedSize = -1;
                return this;
            }

            public IconPosition clearListHide() {
                this.hasListHide = false;
                this.listHide_ = 0;
                return this;
            }

            public IconPosition clearListNormal() {
                this.hasListNormal = false;
                this.listNormal_ = 0;
                return this;
            }

            public IconPosition clearSlide() {
                this.hasSlide = false;
                this.slide_ = 0;
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getListHide() {
                return this.listHide_;
            }

            public int getListNormal() {
                return this.listNormal_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iE = hasListNormal() ? d.e(1, getListNormal()) : 0;
                if (hasListHide()) {
                    iE += d.e(2, getListHide());
                }
                if (hasSlide()) {
                    iE += d.e(3, getSlide());
                }
                this.cachedSize = iE;
                return iE;
            }

            public int getSlide() {
                return this.slide_;
            }

            public boolean hasListHide() {
                return this.hasListHide;
            }

            public boolean hasListNormal() {
                return this.hasListNormal;
            }

            public boolean hasSlide() {
                return this.hasSlide;
            }

            public final boolean isInitialized() {
                return true;
            }

            public IconPosition setListHide(int i4) {
                this.hasListHide = true;
                this.listHide_ = i4;
                return this;
            }

            public IconPosition setListNormal(int i4) {
                this.hasListNormal = true;
                this.listNormal_ = i4;
                return this;
            }

            public IconPosition setSlide(int i4) {
                this.hasSlide = true;
                this.slide_ = i4;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasListNormal()) {
                    dVar.s(1, getListNormal());
                }
                if (hasListHide()) {
                    dVar.s(2, getListHide());
                }
                if (hasSlide()) {
                    dVar.s(3, getSlide());
                }
            }

            public static IconPosition parseFrom(byte[] bArr) throws e {
                return (IconPosition) new IconPosition().mergeFrom(bArr);
            }

            @Override // L1.f
            public IconPosition mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 8) {
                        setListNormal(bVar.k());
                    } else if (iO == 16) {
                        setListHide(bVar.k());
                    } else if (iO == 24) {
                        setSlide(bVar.k());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class JumpInfo extends f {
            public static final int GROUP_ID_FIELD_NUMBER = 3;
            public static final int GROUP_IMAGE_FIELD_NUMBER = 5;
            public static final int GROUP_NAME_FIELD_NUMBER = 4;
            public static final int TYPE_FIELD_NUMBER = 2;
            public static final int URL_FIELD_NUMBER = 1;
            private boolean hasGroupId;
            private boolean hasGroupImage;
            private boolean hasGroupName;
            private boolean hasType;
            private boolean hasUrl;
            private String url_ = "";
            private int type_ = 0;
            private int groupId_ = 0;
            private String groupName_ = "";
            private String groupImage_ = "";
            private int cachedSize = -1;

            public static JumpInfo parseFrom(b bVar) throws IOException {
                return new JumpInfo().mergeFrom(bVar);
            }

            public final JumpInfo clear() {
                clearUrl();
                clearType();
                clearGroupId();
                clearGroupName();
                clearGroupImage();
                this.cachedSize = -1;
                return this;
            }

            public JumpInfo clearGroupId() {
                this.hasGroupId = false;
                this.groupId_ = 0;
                return this;
            }

            public JumpInfo clearGroupImage() {
                this.hasGroupImage = false;
                this.groupImage_ = "";
                return this;
            }

            public JumpInfo clearGroupName() {
                this.hasGroupName = false;
                this.groupName_ = "";
                return this;
            }

            public JumpInfo clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            public JumpInfo clearUrl() {
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

            public int getGroupId() {
                return this.groupId_;
            }

            public String getGroupImage() {
                return this.groupImage_;
            }

            public String getGroupName() {
                return this.groupName_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasUrl() ? d.l(1, getUrl()) : 0;
                if (hasType()) {
                    iL += d.e(2, getType());
                }
                if (hasGroupId()) {
                    iL += d.e(3, getGroupId());
                }
                if (hasGroupName()) {
                    iL += d.l(4, getGroupName());
                }
                if (hasGroupImage()) {
                    iL += d.l(5, getGroupImage());
                }
                this.cachedSize = iL;
                return iL;
            }

            public int getType() {
                return this.type_;
            }

            public String getUrl() {
                return this.url_;
            }

            public boolean hasGroupId() {
                return this.hasGroupId;
            }

            public boolean hasGroupImage() {
                return this.hasGroupImage;
            }

            public boolean hasGroupName() {
                return this.hasGroupName;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public boolean hasUrl() {
                return this.hasUrl;
            }

            public final boolean isInitialized() {
                return true;
            }

            public JumpInfo setGroupId(int i4) {
                this.hasGroupId = true;
                this.groupId_ = i4;
                return this;
            }

            public JumpInfo setGroupImage(String str) {
                this.hasGroupImage = true;
                this.groupImage_ = str;
                return this;
            }

            public JumpInfo setGroupName(String str) {
                this.hasGroupName = true;
                this.groupName_ = str;
                return this;
            }

            public JumpInfo setType(int i4) {
                this.hasType = true;
                this.type_ = i4;
                return this;
            }

            public JumpInfo setUrl(String str) {
                this.hasUrl = true;
                this.url_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasUrl()) {
                    dVar.A(1, getUrl());
                }
                if (hasType()) {
                    dVar.s(2, getType());
                }
                if (hasGroupId()) {
                    dVar.s(3, getGroupId());
                }
                if (hasGroupName()) {
                    dVar.A(4, getGroupName());
                }
                if (hasGroupImage()) {
                    dVar.A(5, getGroupImage());
                }
            }

            public static JumpInfo parseFrom(byte[] bArr) throws e {
                return (JumpInfo) new JumpInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public JumpInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setUrl(bVar.n());
                    } else if (iO == 16) {
                        setType(bVar.k());
                    } else if (iO == 24) {
                        setGroupId(bVar.k());
                    } else if (iO == 34) {
                        setGroupName(bVar.n());
                    } else if (iO == 42) {
                        setGroupImage(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static FloatIcon parseFrom(b bVar) throws IOException {
            return new FloatIcon().mergeFrom(bVar);
        }

        public final FloatIcon clear() {
            clearIconImg();
            clearPos();
            clearJumpInfo();
            clearHideWhenSlide();
            clearShowKey();
            clearClickKey();
            clearParam();
            this.cachedSize = -1;
            return this;
        }

        public FloatIcon clearClickKey() {
            this.hasClickKey = false;
            this.clickKey_ = "";
            return this;
        }

        public FloatIcon clearHideWhenSlide() {
            this.hasHideWhenSlide = false;
            this.hideWhenSlide_ = false;
            return this;
        }

        public FloatIcon clearIconImg() {
            this.hasIconImg = false;
            this.iconImg_ = "";
            return this;
        }

        public FloatIcon clearJumpInfo() {
            this.hasJumpInfo = false;
            this.jumpInfo_ = null;
            return this;
        }

        public FloatIcon clearParam() {
            this.hasParam = false;
            this.param_ = "";
            return this;
        }

        public FloatIcon clearPos() {
            this.hasPos = false;
            this.pos_ = null;
            return this;
        }

        public FloatIcon clearShowKey() {
            this.hasShowKey = false;
            this.showKey_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getClickKey() {
            return this.clickKey_;
        }

        public boolean getHideWhenSlide() {
            return this.hideWhenSlide_;
        }

        public String getIconImg() {
            return this.iconImg_;
        }

        public JumpInfo getJumpInfo() {
            return this.jumpInfo_;
        }

        public String getParam() {
            return this.param_;
        }

        public IconPosition getPos() {
            return this.pos_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasIconImg() ? d.l(1, getIconImg()) : 0;
            if (hasPos()) {
                iL += d.h(2, getPos());
            }
            if (hasJumpInfo()) {
                iL += d.h(3, getJumpInfo());
            }
            if (hasHideWhenSlide()) {
                getHideWhenSlide();
                iL += d.a(4);
            }
            if (hasShowKey()) {
                iL += d.l(5, getShowKey());
            }
            if (hasClickKey()) {
                iL += d.l(6, getClickKey());
            }
            if (hasParam()) {
                iL += d.l(7, getParam());
            }
            this.cachedSize = iL;
            return iL;
        }

        public String getShowKey() {
            return this.showKey_;
        }

        public boolean hasClickKey() {
            return this.hasClickKey;
        }

        public boolean hasHideWhenSlide() {
            return this.hasHideWhenSlide;
        }

        public boolean hasIconImg() {
            return this.hasIconImg;
        }

        public boolean hasJumpInfo() {
            return this.hasJumpInfo;
        }

        public boolean hasParam() {
            return this.hasParam;
        }

        public boolean hasPos() {
            return this.hasPos;
        }

        public boolean hasShowKey() {
            return this.hasShowKey;
        }

        public final boolean isInitialized() {
            return true;
        }

        public FloatIcon setClickKey(String str) {
            this.hasClickKey = true;
            this.clickKey_ = str;
            return this;
        }

        public FloatIcon setHideWhenSlide(boolean z4) {
            this.hasHideWhenSlide = true;
            this.hideWhenSlide_ = z4;
            return this;
        }

        public FloatIcon setIconImg(String str) {
            this.hasIconImg = true;
            this.iconImg_ = str;
            return this;
        }

        public FloatIcon setJumpInfo(JumpInfo jumpInfo) {
            if (jumpInfo == null) {
                return clearJumpInfo();
            }
            this.hasJumpInfo = true;
            this.jumpInfo_ = jumpInfo;
            return this;
        }

        public FloatIcon setParam(String str) {
            this.hasParam = true;
            this.param_ = str;
            return this;
        }

        public FloatIcon setPos(IconPosition iconPosition) {
            if (iconPosition == null) {
                return clearPos();
            }
            this.hasPos = true;
            this.pos_ = iconPosition;
            return this;
        }

        public FloatIcon setShowKey(String str) {
            this.hasShowKey = true;
            this.showKey_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasIconImg()) {
                dVar.A(1, getIconImg());
            }
            if (hasPos()) {
                dVar.u(2, getPos());
            }
            if (hasJumpInfo()) {
                dVar.u(3, getJumpInfo());
            }
            if (hasHideWhenSlide()) {
                dVar.p(4, getHideWhenSlide());
            }
            if (hasShowKey()) {
                dVar.A(5, getShowKey());
            }
            if (hasClickKey()) {
                dVar.A(6, getClickKey());
            }
            if (hasParam()) {
                dVar.A(7, getParam());
            }
        }

        public static FloatIcon parseFrom(byte[] bArr) throws e {
            return (FloatIcon) new FloatIcon().mergeFrom(bArr);
        }

        @Override // L1.f
        public FloatIcon mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setIconImg(bVar.n());
                } else if (iO == 18) {
                    IconPosition iconPosition = new IconPosition();
                    bVar.f(iconPosition);
                    setPos(iconPosition);
                } else if (iO == 26) {
                    JumpInfo jumpInfo = new JumpInfo();
                    bVar.f(jumpInfo);
                    setJumpInfo(jumpInfo);
                } else if (iO == 32) {
                    setHideWhenSlide(bVar.a());
                } else if (iO == 42) {
                    setShowKey(bVar.n());
                } else if (iO == 50) {
                    setClickKey(bVar.n());
                } else if (iO == 58) {
                    setParam(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class GuideTag extends f {
        public static final int CAPTION_FIELD_NUMBER = 5;
        public static final int CONTENTS_FIELD_NUMBER = 3;
        public static final int GUIDE_CONTENT_FIELD_NUMBER = 6;
        public static final int LOCATION_FIELD_NUMBER = 4;
        public static final int POSITION_FIELD_NUMBER = 1;
        public static final int TITLE_FIELD_NUMBER = 2;
        private boolean hasCaption;
        private boolean hasLocation;
        private boolean hasPosition;
        private boolean hasTitle;
        private int position_ = 0;
        private String title_ = "";
        private List<String> contents_ = Collections.emptyList();
        private int location_ = 0;
        private String caption_ = "";
        private List<GuideContent> guideContent_ = Collections.emptyList();
        private int cachedSize = -1;

        public static final class GuideContent extends f {
            public static final int ALIGNMENT_FIELD_NUMBER = 2;
            public static final int QT_FIELD_NUMBER = 3;
            public static final int TEXT_FIELD_NUMBER = 1;
            public static final int X_FIELD_NUMBER = 4;
            public static final int Y_FIELD_NUMBER = 5;
            private boolean hasAlignment;
            private boolean hasQt;
            private boolean hasText;
            private boolean hasX;
            private boolean hasY;
            private String text_ = "";
            private String alignment_ = "";
            private String qt_ = "";
            private String x_ = "";
            private String y_ = "";
            private int cachedSize = -1;

            public static GuideContent parseFrom(b bVar) throws IOException {
                return new GuideContent().mergeFrom(bVar);
            }

            public final GuideContent clear() {
                clearText();
                clearAlignment();
                clearQt();
                clearX();
                clearY();
                this.cachedSize = -1;
                return this;
            }

            public GuideContent clearAlignment() {
                this.hasAlignment = false;
                this.alignment_ = "";
                return this;
            }

            public GuideContent clearQt() {
                this.hasQt = false;
                this.qt_ = "";
                return this;
            }

            public GuideContent clearText() {
                this.hasText = false;
                this.text_ = "";
                return this;
            }

            public GuideContent clearX() {
                this.hasX = false;
                this.x_ = "";
                return this;
            }

            public GuideContent clearY() {
                this.hasY = false;
                this.y_ = "";
                return this;
            }

            public String getAlignment() {
                return this.alignment_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getQt() {
                return this.qt_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasText() ? d.l(1, getText()) : 0;
                if (hasAlignment()) {
                    iL += d.l(2, getAlignment());
                }
                if (hasQt()) {
                    iL += d.l(3, getQt());
                }
                if (hasX()) {
                    iL += d.l(4, getX());
                }
                if (hasY()) {
                    iL += d.l(5, getY());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getText() {
                return this.text_;
            }

            public String getX() {
                return this.x_;
            }

            public String getY() {
                return this.y_;
            }

            public boolean hasAlignment() {
                return this.hasAlignment;
            }

            public boolean hasQt() {
                return this.hasQt;
            }

            public boolean hasText() {
                return this.hasText;
            }

            public boolean hasX() {
                return this.hasX;
            }

            public boolean hasY() {
                return this.hasY;
            }

            public final boolean isInitialized() {
                return true;
            }

            public GuideContent setAlignment(String str) {
                this.hasAlignment = true;
                this.alignment_ = str;
                return this;
            }

            public GuideContent setQt(String str) {
                this.hasQt = true;
                this.qt_ = str;
                return this;
            }

            public GuideContent setText(String str) {
                this.hasText = true;
                this.text_ = str;
                return this;
            }

            public GuideContent setX(String str) {
                this.hasX = true;
                this.x_ = str;
                return this;
            }

            public GuideContent setY(String str) {
                this.hasY = true;
                this.y_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasText()) {
                    dVar.A(1, getText());
                }
                if (hasAlignment()) {
                    dVar.A(2, getAlignment());
                }
                if (hasQt()) {
                    dVar.A(3, getQt());
                }
                if (hasX()) {
                    dVar.A(4, getX());
                }
                if (hasY()) {
                    dVar.A(5, getY());
                }
            }

            public static GuideContent parseFrom(byte[] bArr) throws e {
                return (GuideContent) new GuideContent().mergeFrom(bArr);
            }

            @Override // L1.f
            public GuideContent mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setText(bVar.n());
                    } else if (iO == 18) {
                        setAlignment(bVar.n());
                    } else if (iO == 26) {
                        setQt(bVar.n());
                    } else if (iO == 34) {
                        setX(bVar.n());
                    } else if (iO == 42) {
                        setY(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static GuideTag parseFrom(b bVar) throws IOException {
            return new GuideTag().mergeFrom(bVar);
        }

        public GuideTag addContents(String str) {
            str.getClass();
            if (this.contents_.isEmpty()) {
                this.contents_ = new ArrayList();
            }
            this.contents_.add(str);
            return this;
        }

        public GuideTag addGuideContent(GuideContent guideContent) {
            if (guideContent == null) {
                return this;
            }
            if (this.guideContent_.isEmpty()) {
                this.guideContent_ = new ArrayList();
            }
            this.guideContent_.add(guideContent);
            return this;
        }

        public final GuideTag clear() {
            clearPosition();
            clearTitle();
            clearContents();
            clearLocation();
            clearCaption();
            clearGuideContent();
            this.cachedSize = -1;
            return this;
        }

        public GuideTag clearCaption() {
            this.hasCaption = false;
            this.caption_ = "";
            return this;
        }

        public GuideTag clearContents() {
            this.contents_ = Collections.emptyList();
            return this;
        }

        public GuideTag clearGuideContent() {
            this.guideContent_ = Collections.emptyList();
            return this;
        }

        public GuideTag clearLocation() {
            this.hasLocation = false;
            this.location_ = 0;
            return this;
        }

        public GuideTag clearPosition() {
            this.hasPosition = false;
            this.position_ = 0;
            return this;
        }

        public GuideTag clearTitle() {
            this.hasTitle = false;
            this.title_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getCaption() {
            return this.caption_;
        }

        public String getContents(int i4) {
            return this.contents_.get(i4);
        }

        public int getContentsCount() {
            return this.contents_.size();
        }

        public List<String> getContentsList() {
            return this.contents_;
        }

        public GuideContent getGuideContent(int i4) {
            return this.guideContent_.get(i4);
        }

        public int getGuideContentCount() {
            return this.guideContent_.size();
        }

        public List<GuideContent> getGuideContentList() {
            return this.guideContent_;
        }

        public int getLocation() {
            return this.location_;
        }

        public int getPosition() {
            return this.position_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iM = 0;
            int iE = hasPosition() ? d.e(1, getPosition()) : 0;
            if (hasTitle()) {
                iE += d.l(2, getTitle());
            }
            Iterator<String> it = getContentsList().iterator();
            while (it.hasNext()) {
                iM += d.m(it.next());
            }
            int size = getContentsList().size() + iE + iM;
            if (hasLocation()) {
                size += d.e(4, getLocation());
            }
            if (hasCaption()) {
                size += d.l(5, getCaption());
            }
            Iterator<GuideContent> it2 = getGuideContentList().iterator();
            while (it2.hasNext()) {
                size += d.h(6, it2.next());
            }
            this.cachedSize = size;
            return size;
        }

        public String getTitle() {
            return this.title_;
        }

        public boolean hasCaption() {
            return this.hasCaption;
        }

        public boolean hasLocation() {
            return this.hasLocation;
        }

        public boolean hasPosition() {
            return this.hasPosition;
        }

        public boolean hasTitle() {
            return this.hasTitle;
        }

        public final boolean isInitialized() {
            return true;
        }

        public GuideTag setCaption(String str) {
            this.hasCaption = true;
            this.caption_ = str;
            return this;
        }

        public GuideTag setContents(int i4, String str) {
            str.getClass();
            this.contents_.set(i4, str);
            return this;
        }

        public GuideTag setGuideContent(int i4, GuideContent guideContent) {
            if (guideContent == null) {
                return this;
            }
            this.guideContent_.set(i4, guideContent);
            return this;
        }

        public GuideTag setLocation(int i4) {
            this.hasLocation = true;
            this.location_ = i4;
            return this;
        }

        public GuideTag setPosition(int i4) {
            this.hasPosition = true;
            this.position_ = i4;
            return this;
        }

        public GuideTag setTitle(String str) {
            this.hasTitle = true;
            this.title_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasPosition()) {
                dVar.s(1, getPosition());
            }
            if (hasTitle()) {
                dVar.A(2, getTitle());
            }
            Iterator<String> it = getContentsList().iterator();
            while (it.hasNext()) {
                dVar.A(3, it.next());
            }
            if (hasLocation()) {
                dVar.s(4, getLocation());
            }
            if (hasCaption()) {
                dVar.A(5, getCaption());
            }
            Iterator<GuideContent> it2 = getGuideContentList().iterator();
            while (it2.hasNext()) {
                dVar.u(6, it2.next());
            }
        }

        public static GuideTag parseFrom(byte[] bArr) throws e {
            return (GuideTag) new GuideTag().mergeFrom(bArr);
        }

        @Override // L1.f
        public GuideTag mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 8) {
                    setPosition(bVar.k());
                } else if (iO == 18) {
                    setTitle(bVar.n());
                } else if (iO == 26) {
                    addContents(bVar.n());
                } else if (iO == 32) {
                    setLocation(bVar.k());
                } else if (iO == 42) {
                    setCaption(bVar.n());
                } else if (iO == 50) {
                    GuideContent guideContent = new GuideContent();
                    bVar.f(guideContent);
                    addGuideContent(guideContent);
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class GuildButton extends f {
        public static final int ACTION_TYPE_FIELD_NUMBER = 1;
        public static final int ACTION_VALUE_FIELD_NUMBER = 2;
        public static final int CLICK_KEY_FIELD_NUMBER = 6;
        public static final int CLICK_PARAM_FIELD_NUMBER = 8;
        public static final int ICON_URL_FIELD_NUMBER = 4;
        public static final int OPENAPI = 0;
        public static final int SHOW_KEY_FIELD_NUMBER = 5;
        public static final int SHOW_PARAM_FIELD_NUMBER = 7;
        public static final int TITLE_FIELD_NUMBER = 3;
        private boolean hasActionType;
        private boolean hasActionValue;
        private boolean hasClickKey;
        private boolean hasClickParam;
        private boolean hasIconUrl;
        private boolean hasShowKey;
        private boolean hasShowParam;
        private boolean hasTitle;
        private int actionType_ = 0;
        private String actionValue_ = "";
        private String title_ = "";
        private String iconUrl_ = "";
        private String showKey_ = "";
        private String clickKey_ = "";
        private String showParam_ = "";
        private String clickParam_ = "";
        private int cachedSize = -1;

        public static GuildButton parseFrom(b bVar) throws IOException {
            return new GuildButton().mergeFrom(bVar);
        }

        public final GuildButton clear() {
            clearActionType();
            clearActionValue();
            clearTitle();
            clearIconUrl();
            clearShowKey();
            clearClickKey();
            clearShowParam();
            clearClickParam();
            this.cachedSize = -1;
            return this;
        }

        public GuildButton clearActionType() {
            this.hasActionType = false;
            this.actionType_ = 0;
            return this;
        }

        public GuildButton clearActionValue() {
            this.hasActionValue = false;
            this.actionValue_ = "";
            return this;
        }

        public GuildButton clearClickKey() {
            this.hasClickKey = false;
            this.clickKey_ = "";
            return this;
        }

        public GuildButton clearClickParam() {
            this.hasClickParam = false;
            this.clickParam_ = "";
            return this;
        }

        public GuildButton clearIconUrl() {
            this.hasIconUrl = false;
            this.iconUrl_ = "";
            return this;
        }

        public GuildButton clearShowKey() {
            this.hasShowKey = false;
            this.showKey_ = "";
            return this;
        }

        public GuildButton clearShowParam() {
            this.hasShowParam = false;
            this.showParam_ = "";
            return this;
        }

        public GuildButton clearTitle() {
            this.hasTitle = false;
            this.title_ = "";
            return this;
        }

        public int getActionType() {
            return this.actionType_;
        }

        public String getActionValue() {
            return this.actionValue_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getClickKey() {
            return this.clickKey_;
        }

        public String getClickParam() {
            return this.clickParam_;
        }

        public String getIconUrl() {
            return this.iconUrl_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iE = hasActionType() ? d.e(1, getActionType()) : 0;
            if (hasActionValue()) {
                iE += d.l(2, getActionValue());
            }
            if (hasTitle()) {
                iE += d.l(3, getTitle());
            }
            if (hasIconUrl()) {
                iE += d.l(4, getIconUrl());
            }
            if (hasShowKey()) {
                iE += d.l(5, getShowKey());
            }
            if (hasClickKey()) {
                iE += d.l(6, getClickKey());
            }
            if (hasShowParam()) {
                iE += d.l(7, getShowParam());
            }
            if (hasClickParam()) {
                iE += d.l(8, getClickParam());
            }
            this.cachedSize = iE;
            return iE;
        }

        public String getShowKey() {
            return this.showKey_;
        }

        public String getShowParam() {
            return this.showParam_;
        }

        public String getTitle() {
            return this.title_;
        }

        public boolean hasActionType() {
            return this.hasActionType;
        }

        public boolean hasActionValue() {
            return this.hasActionValue;
        }

        public boolean hasClickKey() {
            return this.hasClickKey;
        }

        public boolean hasClickParam() {
            return this.hasClickParam;
        }

        public boolean hasIconUrl() {
            return this.hasIconUrl;
        }

        public boolean hasShowKey() {
            return this.hasShowKey;
        }

        public boolean hasShowParam() {
            return this.hasShowParam;
        }

        public boolean hasTitle() {
            return this.hasTitle;
        }

        public final boolean isInitialized() {
            return true;
        }

        public GuildButton setActionType(int i4) {
            this.hasActionType = true;
            this.actionType_ = i4;
            return this;
        }

        public GuildButton setActionValue(String str) {
            this.hasActionValue = true;
            this.actionValue_ = str;
            return this;
        }

        public GuildButton setClickKey(String str) {
            this.hasClickKey = true;
            this.clickKey_ = str;
            return this;
        }

        public GuildButton setClickParam(String str) {
            this.hasClickParam = true;
            this.clickParam_ = str;
            return this;
        }

        public GuildButton setIconUrl(String str) {
            this.hasIconUrl = true;
            this.iconUrl_ = str;
            return this;
        }

        public GuildButton setShowKey(String str) {
            this.hasShowKey = true;
            this.showKey_ = str;
            return this;
        }

        public GuildButton setShowParam(String str) {
            this.hasShowParam = true;
            this.showParam_ = str;
            return this;
        }

        public GuildButton setTitle(String str) {
            this.hasTitle = true;
            this.title_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasActionType()) {
                dVar.s(1, getActionType());
            }
            if (hasActionValue()) {
                dVar.A(2, getActionValue());
            }
            if (hasTitle()) {
                dVar.A(3, getTitle());
            }
            if (hasIconUrl()) {
                dVar.A(4, getIconUrl());
            }
            if (hasShowKey()) {
                dVar.A(5, getShowKey());
            }
            if (hasClickKey()) {
                dVar.A(6, getClickKey());
            }
            if (hasShowParam()) {
                dVar.A(7, getShowParam());
            }
            if (hasClickParam()) {
                dVar.A(8, getClickParam());
            }
        }

        public static GuildButton parseFrom(byte[] bArr) throws e {
            return (GuildButton) new GuildButton().mergeFrom(bArr);
        }

        @Override // L1.f
        public GuildButton mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 8) {
                    setActionType(bVar.k());
                } else if (iO == 18) {
                    setActionValue(bVar.n());
                } else if (iO == 26) {
                    setTitle(bVar.n());
                } else if (iO == 34) {
                    setIconUrl(bVar.n());
                } else if (iO == 42) {
                    setShowKey(bVar.n());
                } else if (iO == 50) {
                    setClickKey(bVar.n());
                } else if (iO == 58) {
                    setShowParam(bVar.n());
                } else if (iO == 66) {
                    setClickParam(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class HorizonSlideResult extends f {
        public static final int DARK_H5_TITLE_FIELD_NUMBER = 3;
        public static final int H5 = 2;
        public static final int H5_TITLE_FIELD_NUMBER = 2;
        public static final int H5_TRANS_PARAM_FIELD_NUMBER = 4;
        public static final int HEAD_DISP_TYPE_FIELD_NUMBER = 5;
        public static final int PIC = 2;
        public static final int SCENE_FIELD_NUMBER = 7;
        public static final int SEARCH = 1;
        public static final int SUPPORT_NA_LIST_FIELD_NUMBER = 6;
        public static final int TEXT = 1;
        public static final int TYPE_FIELD_NUMBER = 1;
        private boolean hasDarkH5Title;
        private boolean hasH5Title;
        private boolean hasH5TransParam;
        private boolean hasHeadDispType;
        private boolean hasScene;
        private boolean hasSupportNaList;
        private boolean hasType;
        private int type_ = 1;
        private String h5Title_ = "";
        private String darkH5Title_ = "";
        private String h5TransParam_ = "";
        private int headDispType_ = 1;
        private int supportNaList_ = 0;
        private String scene_ = "";
        private int cachedSize = -1;

        public static HorizonSlideResult parseFrom(b bVar) throws IOException {
            return new HorizonSlideResult().mergeFrom(bVar);
        }

        public final HorizonSlideResult clear() {
            clearType();
            clearH5Title();
            clearDarkH5Title();
            clearH5TransParam();
            clearHeadDispType();
            clearSupportNaList();
            clearScene();
            this.cachedSize = -1;
            return this;
        }

        public HorizonSlideResult clearDarkH5Title() {
            this.hasDarkH5Title = false;
            this.darkH5Title_ = "";
            return this;
        }

        public HorizonSlideResult clearH5Title() {
            this.hasH5Title = false;
            this.h5Title_ = "";
            return this;
        }

        public HorizonSlideResult clearH5TransParam() {
            this.hasH5TransParam = false;
            this.h5TransParam_ = "";
            return this;
        }

        public HorizonSlideResult clearHeadDispType() {
            this.hasHeadDispType = false;
            this.headDispType_ = 1;
            return this;
        }

        public HorizonSlideResult clearScene() {
            this.hasScene = false;
            this.scene_ = "";
            return this;
        }

        public HorizonSlideResult clearSupportNaList() {
            this.hasSupportNaList = false;
            this.supportNaList_ = 0;
            return this;
        }

        public HorizonSlideResult clearType() {
            this.hasType = false;
            this.type_ = 1;
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getDarkH5Title() {
            return this.darkH5Title_;
        }

        public String getH5Title() {
            return this.h5Title_;
        }

        public String getH5TransParam() {
            return this.h5TransParam_;
        }

        public int getHeadDispType() {
            return this.headDispType_;
        }

        public String getScene() {
            return this.scene_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iE = hasType() ? d.e(1, getType()) : 0;
            if (hasH5Title()) {
                iE += d.l(2, getH5Title());
            }
            if (hasDarkH5Title()) {
                iE += d.l(3, getDarkH5Title());
            }
            if (hasH5TransParam()) {
                iE += d.l(4, getH5TransParam());
            }
            if (hasHeadDispType()) {
                iE += d.e(5, getHeadDispType());
            }
            if (hasSupportNaList()) {
                iE += d.e(6, getSupportNaList());
            }
            if (hasScene()) {
                iE += d.l(7, getScene());
            }
            this.cachedSize = iE;
            return iE;
        }

        public int getSupportNaList() {
            return this.supportNaList_;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasDarkH5Title() {
            return this.hasDarkH5Title;
        }

        public boolean hasH5Title() {
            return this.hasH5Title;
        }

        public boolean hasH5TransParam() {
            return this.hasH5TransParam;
        }

        public boolean hasHeadDispType() {
            return this.hasHeadDispType;
        }

        public boolean hasScene() {
            return this.hasScene;
        }

        public boolean hasSupportNaList() {
            return this.hasSupportNaList;
        }

        public boolean hasType() {
            return this.hasType;
        }

        public final boolean isInitialized() {
            return true;
        }

        public HorizonSlideResult setDarkH5Title(String str) {
            this.hasDarkH5Title = true;
            this.darkH5Title_ = str;
            return this;
        }

        public HorizonSlideResult setH5Title(String str) {
            this.hasH5Title = true;
            this.h5Title_ = str;
            return this;
        }

        public HorizonSlideResult setH5TransParam(String str) {
            this.hasH5TransParam = true;
            this.h5TransParam_ = str;
            return this;
        }

        public HorizonSlideResult setHeadDispType(int i4) {
            this.hasHeadDispType = true;
            this.headDispType_ = i4;
            return this;
        }

        public HorizonSlideResult setScene(String str) {
            this.hasScene = true;
            this.scene_ = str;
            return this;
        }

        public HorizonSlideResult setSupportNaList(int i4) {
            this.hasSupportNaList = true;
            this.supportNaList_ = i4;
            return this;
        }

        public HorizonSlideResult setType(int i4) {
            this.hasType = true;
            this.type_ = i4;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasType()) {
                dVar.s(1, getType());
            }
            if (hasH5Title()) {
                dVar.A(2, getH5Title());
            }
            if (hasDarkH5Title()) {
                dVar.A(3, getDarkH5Title());
            }
            if (hasH5TransParam()) {
                dVar.A(4, getH5TransParam());
            }
            if (hasHeadDispType()) {
                dVar.s(5, getHeadDispType());
            }
            if (hasSupportNaList()) {
                dVar.s(6, getSupportNaList());
            }
            if (hasScene()) {
                dVar.A(7, getScene());
            }
        }

        public static HorizonSlideResult parseFrom(byte[] bArr) throws e {
            return (HorizonSlideResult) new HorizonSlideResult().mergeFrom(bArr);
        }

        @Override // L1.f
        public HorizonSlideResult mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 8) {
                    setType(bVar.k());
                } else if (iO == 18) {
                    setH5Title(bVar.n());
                } else if (iO == 26) {
                    setDarkH5Title(bVar.n());
                } else if (iO == 34) {
                    setH5TransParam(bVar.n());
                } else if (iO == 40) {
                    setHeadDispType(bVar.k());
                } else if (iO == 48) {
                    setSupportNaList(bVar.k());
                } else if (iO == 58) {
                    setScene(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class ImgBanner extends f {
        public static final int H5_URL_FIELD_NUMBER = 2;
        public static final int IMG_URL_FIELD_NUMBER = 1;
        public static final int LOCATION_FIELD_NUMBER = 3;
        public static final int PAGE_NUM_FIELD_NUMBER = 4;
        public static final int STAT_INFO_FIELD_NUMBER = 7;
        public static final int SUB_TEXT_FIELD_NUMBER = 6;
        public static final int TEXT_FIELD_NUMBER = 5;
        private boolean hasH5Url;
        private boolean hasImgUrl;
        private boolean hasLocation;
        private boolean hasPageNum;
        private boolean hasStatInfo;
        private boolean hasSubText;
        private boolean hasText;
        private String imgUrl_ = "";
        private String h5Url_ = "";
        private int location_ = 0;
        private int pageNum_ = 0;
        private String text_ = "";
        private String subText_ = "";
        private String statInfo_ = "";
        private int cachedSize = -1;

        public static ImgBanner parseFrom(b bVar) throws IOException {
            return new ImgBanner().mergeFrom(bVar);
        }

        public final ImgBanner clear() {
            clearImgUrl();
            clearH5Url();
            clearLocation();
            clearPageNum();
            clearText();
            clearSubText();
            clearStatInfo();
            this.cachedSize = -1;
            return this;
        }

        public ImgBanner clearH5Url() {
            this.hasH5Url = false;
            this.h5Url_ = "";
            return this;
        }

        public ImgBanner clearImgUrl() {
            this.hasImgUrl = false;
            this.imgUrl_ = "";
            return this;
        }

        public ImgBanner clearLocation() {
            this.hasLocation = false;
            this.location_ = 0;
            return this;
        }

        public ImgBanner clearPageNum() {
            this.hasPageNum = false;
            this.pageNum_ = 0;
            return this;
        }

        public ImgBanner clearStatInfo() {
            this.hasStatInfo = false;
            this.statInfo_ = "";
            return this;
        }

        public ImgBanner clearSubText() {
            this.hasSubText = false;
            this.subText_ = "";
            return this;
        }

        public ImgBanner clearText() {
            this.hasText = false;
            this.text_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getH5Url() {
            return this.h5Url_;
        }

        public String getImgUrl() {
            return this.imgUrl_;
        }

        public int getLocation() {
            return this.location_;
        }

        public int getPageNum() {
            return this.pageNum_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasImgUrl() ? d.l(1, getImgUrl()) : 0;
            if (hasH5Url()) {
                iL += d.l(2, getH5Url());
            }
            if (hasLocation()) {
                iL += d.e(3, getLocation());
            }
            if (hasPageNum()) {
                iL += d.e(4, getPageNum());
            }
            if (hasText()) {
                iL += d.l(5, getText());
            }
            if (hasSubText()) {
                iL += d.l(6, getSubText());
            }
            if (hasStatInfo()) {
                iL += d.l(7, getStatInfo());
            }
            this.cachedSize = iL;
            return iL;
        }

        public String getStatInfo() {
            return this.statInfo_;
        }

        public String getSubText() {
            return this.subText_;
        }

        public String getText() {
            return this.text_;
        }

        public boolean hasH5Url() {
            return this.hasH5Url;
        }

        public boolean hasImgUrl() {
            return this.hasImgUrl;
        }

        public boolean hasLocation() {
            return this.hasLocation;
        }

        public boolean hasPageNum() {
            return this.hasPageNum;
        }

        public boolean hasStatInfo() {
            return this.hasStatInfo;
        }

        public boolean hasSubText() {
            return this.hasSubText;
        }

        public boolean hasText() {
            return this.hasText;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ImgBanner setH5Url(String str) {
            this.hasH5Url = true;
            this.h5Url_ = str;
            return this;
        }

        public ImgBanner setImgUrl(String str) {
            this.hasImgUrl = true;
            this.imgUrl_ = str;
            return this;
        }

        public ImgBanner setLocation(int i4) {
            this.hasLocation = true;
            this.location_ = i4;
            return this;
        }

        public ImgBanner setPageNum(int i4) {
            this.hasPageNum = true;
            this.pageNum_ = i4;
            return this;
        }

        public ImgBanner setStatInfo(String str) {
            this.hasStatInfo = true;
            this.statInfo_ = str;
            return this;
        }

        public ImgBanner setSubText(String str) {
            this.hasSubText = true;
            this.subText_ = str;
            return this;
        }

        public ImgBanner setText(String str) {
            this.hasText = true;
            this.text_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasImgUrl()) {
                dVar.A(1, getImgUrl());
            }
            if (hasH5Url()) {
                dVar.A(2, getH5Url());
            }
            if (hasLocation()) {
                dVar.s(3, getLocation());
            }
            if (hasPageNum()) {
                dVar.s(4, getPageNum());
            }
            if (hasText()) {
                dVar.A(5, getText());
            }
            if (hasSubText()) {
                dVar.A(6, getSubText());
            }
            if (hasStatInfo()) {
                dVar.A(7, getStatInfo());
            }
        }

        public static ImgBanner parseFrom(byte[] bArr) throws e {
            return (ImgBanner) new ImgBanner().mergeFrom(bArr);
        }

        @Override // L1.f
        public ImgBanner mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setImgUrl(bVar.n());
                } else if (iO == 18) {
                    setH5Url(bVar.n());
                } else if (iO == 24) {
                    setLocation(bVar.k());
                } else if (iO == 32) {
                    setPageNum(bVar.k());
                } else if (iO == 42) {
                    setText(bVar.n());
                } else if (iO == 50) {
                    setSubText(bVar.n());
                } else if (iO == 58) {
                    setStatInfo(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class IndusInfo extends f {
        public static final int AD_POS_FIELD_NUMBER = 4;
        public static final int INDUS_NAME_FIELD_NUMBER = 1;
        public static final int PRIORITY_FIELD_NUMBER = 6;
        public static final int SHOW_NUM_FIELD_NUMBER = 2;
        public static final int USER_COUPON_FIELD_NUMBER = 3;
        private boolean hasAdPos;
        private boolean hasIndusName;
        private boolean hasShowNum;
        private boolean hasUserCoupon;
        private String indusName_ = "";
        private int showNum_ = 0;
        private UserCoupon userCoupon_ = null;
        private AdPos adPos_ = null;
        private List<String> priority_ = Collections.emptyList();
        private int cachedSize = -1;

        public static final class AdPos extends f {
            public static final int POSITION_FIELD_NUMBER = 1;
            private boolean hasPosition;
            private String position_ = "";
            private int cachedSize = -1;

            public static AdPos parseFrom(b bVar) throws IOException {
                return new AdPos().mergeFrom(bVar);
            }

            public final AdPos clear() {
                clearPosition();
                this.cachedSize = -1;
                return this;
            }

            public AdPos clearPosition() {
                this.hasPosition = false;
                this.position_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getPosition() {
                return this.position_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasPosition() ? d.l(1, getPosition()) : 0;
                this.cachedSize = iL;
                return iL;
            }

            public boolean hasPosition() {
                return this.hasPosition;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AdPos setPosition(String str) {
                this.hasPosition = true;
                this.position_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasPosition()) {
                    dVar.A(1, getPosition());
                }
            }

            public static AdPos parseFrom(byte[] bArr) throws e {
                return (AdPos) new AdPos().mergeFrom(bArr);
            }

            @Override // L1.f
            public AdPos mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setPosition(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class UserCoupon extends f {
            public static final int DESC_FIELD_NUMBER = 4;
            public static final int POSITION_FIELD_NUMBER = 3;
            public static final int PRICE_FIELD_NUMBER = 2;
            public static final int TEXT_FIELD_NUMBER = 1;
            private boolean hasDesc;
            private boolean hasPosition;
            private boolean hasPrice;
            private boolean hasText;
            private String text_ = "";
            private String price_ = "";
            private String position_ = "";
            private String desc_ = "";
            private int cachedSize = -1;

            public static UserCoupon parseFrom(b bVar) throws IOException {
                return new UserCoupon().mergeFrom(bVar);
            }

            public final UserCoupon clear() {
                clearText();
                clearPrice();
                clearPosition();
                clearDesc();
                this.cachedSize = -1;
                return this;
            }

            public UserCoupon clearDesc() {
                this.hasDesc = false;
                this.desc_ = "";
                return this;
            }

            public UserCoupon clearPosition() {
                this.hasPosition = false;
                this.position_ = "";
                return this;
            }

            public UserCoupon clearPrice() {
                this.hasPrice = false;
                this.price_ = "";
                return this;
            }

            public UserCoupon clearText() {
                this.hasText = false;
                this.text_ = "";
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

            public String getPosition() {
                return this.position_;
            }

            public String getPrice() {
                return this.price_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasText() ? d.l(1, getText()) : 0;
                if (hasPrice()) {
                    iL += d.l(2, getPrice());
                }
                if (hasPosition()) {
                    iL += d.l(3, getPosition());
                }
                if (hasDesc()) {
                    iL += d.l(4, getDesc());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getText() {
                return this.text_;
            }

            public boolean hasDesc() {
                return this.hasDesc;
            }

            public boolean hasPosition() {
                return this.hasPosition;
            }

            public boolean hasPrice() {
                return this.hasPrice;
            }

            public boolean hasText() {
                return this.hasText;
            }

            public final boolean isInitialized() {
                return true;
            }

            public UserCoupon setDesc(String str) {
                this.hasDesc = true;
                this.desc_ = str;
                return this;
            }

            public UserCoupon setPosition(String str) {
                this.hasPosition = true;
                this.position_ = str;
                return this;
            }

            public UserCoupon setPrice(String str) {
                this.hasPrice = true;
                this.price_ = str;
                return this;
            }

            public UserCoupon setText(String str) {
                this.hasText = true;
                this.text_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasText()) {
                    dVar.A(1, getText());
                }
                if (hasPrice()) {
                    dVar.A(2, getPrice());
                }
                if (hasPosition()) {
                    dVar.A(3, getPosition());
                }
                if (hasDesc()) {
                    dVar.A(4, getDesc());
                }
            }

            public static UserCoupon parseFrom(byte[] bArr) throws e {
                return (UserCoupon) new UserCoupon().mergeFrom(bArr);
            }

            @Override // L1.f
            public UserCoupon mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setText(bVar.n());
                    } else if (iO == 18) {
                        setPrice(bVar.n());
                    } else if (iO == 26) {
                        setPosition(bVar.n());
                    } else if (iO == 34) {
                        setDesc(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static IndusInfo parseFrom(b bVar) throws IOException {
            return new IndusInfo().mergeFrom(bVar);
        }

        public IndusInfo addPriority(String str) {
            str.getClass();
            if (this.priority_.isEmpty()) {
                this.priority_ = new ArrayList();
            }
            this.priority_.add(str);
            return this;
        }

        public final IndusInfo clear() {
            clearIndusName();
            clearShowNum();
            clearUserCoupon();
            clearAdPos();
            clearPriority();
            this.cachedSize = -1;
            return this;
        }

        public IndusInfo clearAdPos() {
            this.hasAdPos = false;
            this.adPos_ = null;
            return this;
        }

        public IndusInfo clearIndusName() {
            this.hasIndusName = false;
            this.indusName_ = "";
            return this;
        }

        public IndusInfo clearPriority() {
            this.priority_ = Collections.emptyList();
            return this;
        }

        public IndusInfo clearShowNum() {
            this.hasShowNum = false;
            this.showNum_ = 0;
            return this;
        }

        public IndusInfo clearUserCoupon() {
            this.hasUserCoupon = false;
            this.userCoupon_ = null;
            return this;
        }

        public AdPos getAdPos() {
            return this.adPos_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getIndusName() {
            return this.indusName_;
        }

        public String getPriority(int i4) {
            return this.priority_.get(i4);
        }

        public int getPriorityCount() {
            return this.priority_.size();
        }

        public List<String> getPriorityList() {
            return this.priority_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iM = 0;
            int iL = hasIndusName() ? d.l(1, getIndusName()) : 0;
            if (hasShowNum()) {
                iL += d.e(2, getShowNum());
            }
            if (hasUserCoupon()) {
                iL += d.h(3, getUserCoupon());
            }
            if (hasAdPos()) {
                iL += d.h(4, getAdPos());
            }
            Iterator<String> it = getPriorityList().iterator();
            while (it.hasNext()) {
                iM += d.m(it.next());
            }
            int size = getPriorityList().size() + iL + iM;
            this.cachedSize = size;
            return size;
        }

        public int getShowNum() {
            return this.showNum_;
        }

        public UserCoupon getUserCoupon() {
            return this.userCoupon_;
        }

        public boolean hasAdPos() {
            return this.hasAdPos;
        }

        public boolean hasIndusName() {
            return this.hasIndusName;
        }

        public boolean hasShowNum() {
            return this.hasShowNum;
        }

        public boolean hasUserCoupon() {
            return this.hasUserCoupon;
        }

        public final boolean isInitialized() {
            return true;
        }

        public IndusInfo setAdPos(AdPos adPos) {
            if (adPos == null) {
                return clearAdPos();
            }
            this.hasAdPos = true;
            this.adPos_ = adPos;
            return this;
        }

        public IndusInfo setIndusName(String str) {
            this.hasIndusName = true;
            this.indusName_ = str;
            return this;
        }

        public IndusInfo setPriority(int i4, String str) {
            str.getClass();
            this.priority_.set(i4, str);
            return this;
        }

        public IndusInfo setShowNum(int i4) {
            this.hasShowNum = true;
            this.showNum_ = i4;
            return this;
        }

        public IndusInfo setUserCoupon(UserCoupon userCoupon) {
            if (userCoupon == null) {
                return clearUserCoupon();
            }
            this.hasUserCoupon = true;
            this.userCoupon_ = userCoupon;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasIndusName()) {
                dVar.A(1, getIndusName());
            }
            if (hasShowNum()) {
                dVar.s(2, getShowNum());
            }
            if (hasUserCoupon()) {
                dVar.u(3, getUserCoupon());
            }
            if (hasAdPos()) {
                dVar.u(4, getAdPos());
            }
            Iterator<String> it = getPriorityList().iterator();
            while (it.hasNext()) {
                dVar.A(6, it.next());
            }
        }

        public static IndusInfo parseFrom(byte[] bArr) throws e {
            return (IndusInfo) new IndusInfo().mergeFrom(bArr);
        }

        @Override // L1.f
        public IndusInfo mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setIndusName(bVar.n());
                } else if (iO == 16) {
                    setShowNum(bVar.k());
                } else if (iO == 26) {
                    UserCoupon userCoupon = new UserCoupon();
                    bVar.f(userCoupon);
                    setUserCoupon(userCoupon);
                } else if (iO == 34) {
                    AdPos adPos = new AdPos();
                    bVar.f(adPos);
                    setAdPos(adPos);
                } else if (iO == 50) {
                    addPriority(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class ListAdsData extends f {
        public static final int FLOAT_ICON_FIELD_NUMBER = 1;
        private boolean hasFloatIcon;
        private AdsListFloatIcon floatIcon_ = null;
        private int cachedSize = -1;

        public static final class AdsListFloatIcon extends f {
            public static final int DATA_FIELD_NUMBER = 1;
            private boolean hasData;
            private String data_ = "";
            private int cachedSize = -1;

            public static AdsListFloatIcon parseFrom(b bVar) throws IOException {
                return new AdsListFloatIcon().mergeFrom(bVar);
            }

            public final AdsListFloatIcon clear() {
                clearData();
                this.cachedSize = -1;
                return this;
            }

            public AdsListFloatIcon clearData() {
                this.hasData = false;
                this.data_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getData() {
                return this.data_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasData() ? d.l(1, getData()) : 0;
                this.cachedSize = iL;
                return iL;
            }

            public boolean hasData() {
                return this.hasData;
            }

            public final boolean isInitialized() {
                return true;
            }

            public AdsListFloatIcon setData(String str) {
                this.hasData = true;
                this.data_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasData()) {
                    dVar.A(1, getData());
                }
            }

            public static AdsListFloatIcon parseFrom(byte[] bArr) throws e {
                return (AdsListFloatIcon) new AdsListFloatIcon().mergeFrom(bArr);
            }

            @Override // L1.f
            public AdsListFloatIcon mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setData(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static ListAdsData parseFrom(b bVar) throws IOException {
            return new ListAdsData().mergeFrom(bVar);
        }

        public final ListAdsData clear() {
            clearFloatIcon();
            this.cachedSize = -1;
            return this;
        }

        public ListAdsData clearFloatIcon() {
            this.hasFloatIcon = false;
            this.floatIcon_ = null;
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public AdsListFloatIcon getFloatIcon() {
            return this.floatIcon_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iH = hasFloatIcon() ? d.h(1, getFloatIcon()) : 0;
            this.cachedSize = iH;
            return iH;
        }

        public boolean hasFloatIcon() {
            return this.hasFloatIcon;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ListAdsData setFloatIcon(AdsListFloatIcon adsListFloatIcon) {
            if (adsListFloatIcon == null) {
                return clearFloatIcon();
            }
            this.hasFloatIcon = true;
            this.floatIcon_ = adsListFloatIcon;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasFloatIcon()) {
                dVar.u(1, getFloatIcon());
            }
        }

        public static ListAdsData parseFrom(byte[] bArr) throws e {
            return (ListAdsData) new ListAdsData().mergeFrom(bArr);
        }

        @Override // L1.f
        public ListAdsData mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    AdsListFloatIcon adsListFloatIcon = new AdsListFloatIcon();
                    bVar.f(adsListFloatIcon);
                    setFloatIcon(adsListFloatIcon);
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class MystiqueList extends f {
        public static final int CARD_TYPE_FIELD_NUMBER = 3;
        public static final int EXP_FEEDBACK_DATA_FIELD_NUMBER = 5;
        public static final int GROUP_TYPE_FIELD_NUMBER = 6;
        public static final int MYSTIQUE_DATA_FIELD_NUMBER = 1;
        public static final int POSITION_FIELD_NUMBER = 2;
        public static final int WEIGHT_FIELD_NUMBER = 4;
        private boolean hasCardType;
        private boolean hasExpFeedbackData;
        private boolean hasGroupType;
        private boolean hasMystiqueData;
        private boolean hasPosition;
        private boolean hasWeight;
        private String mystiqueData_ = "";
        private int position_ = 0;
        private int cardType_ = 0;
        private int weight_ = 0;
        private ExpFeedbackInfo expFeedbackData_ = null;
        private String groupType_ = "";
        private int cachedSize = -1;

        public static MystiqueList parseFrom(b bVar) throws IOException {
            return new MystiqueList().mergeFrom(bVar);
        }

        public final MystiqueList clear() {
            clearMystiqueData();
            clearPosition();
            clearCardType();
            clearWeight();
            clearExpFeedbackData();
            clearGroupType();
            this.cachedSize = -1;
            return this;
        }

        public MystiqueList clearCardType() {
            this.hasCardType = false;
            this.cardType_ = 0;
            return this;
        }

        public MystiqueList clearExpFeedbackData() {
            this.hasExpFeedbackData = false;
            this.expFeedbackData_ = null;
            return this;
        }

        public MystiqueList clearGroupType() {
            this.hasGroupType = false;
            this.groupType_ = "";
            return this;
        }

        public MystiqueList clearMystiqueData() {
            this.hasMystiqueData = false;
            this.mystiqueData_ = "";
            return this;
        }

        public MystiqueList clearPosition() {
            this.hasPosition = false;
            this.position_ = 0;
            return this;
        }

        public MystiqueList clearWeight() {
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

        public int getCardType() {
            return this.cardType_;
        }

        public ExpFeedbackInfo getExpFeedbackData() {
            return this.expFeedbackData_;
        }

        public String getGroupType() {
            return this.groupType_;
        }

        public String getMystiqueData() {
            return this.mystiqueData_;
        }

        public int getPosition() {
            return this.position_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasMystiqueData() ? d.l(1, getMystiqueData()) : 0;
            if (hasPosition()) {
                iL += d.e(2, getPosition());
            }
            if (hasCardType()) {
                iL += d.e(3, getCardType());
            }
            if (hasWeight()) {
                iL += d.e(4, getWeight());
            }
            if (hasExpFeedbackData()) {
                iL += d.h(5, getExpFeedbackData());
            }
            if (hasGroupType()) {
                iL += d.l(6, getGroupType());
            }
            this.cachedSize = iL;
            return iL;
        }

        public int getWeight() {
            return this.weight_;
        }

        public boolean hasCardType() {
            return this.hasCardType;
        }

        public boolean hasExpFeedbackData() {
            return this.hasExpFeedbackData;
        }

        public boolean hasGroupType() {
            return this.hasGroupType;
        }

        public boolean hasMystiqueData() {
            return this.hasMystiqueData;
        }

        public boolean hasPosition() {
            return this.hasPosition;
        }

        public boolean hasWeight() {
            return this.hasWeight;
        }

        public final boolean isInitialized() {
            return true;
        }

        public MystiqueList setCardType(int i4) {
            this.hasCardType = true;
            this.cardType_ = i4;
            return this;
        }

        public MystiqueList setExpFeedbackData(ExpFeedbackInfo expFeedbackInfo) {
            if (expFeedbackInfo == null) {
                return clearExpFeedbackData();
            }
            this.hasExpFeedbackData = true;
            this.expFeedbackData_ = expFeedbackInfo;
            return this;
        }

        public MystiqueList setGroupType(String str) {
            this.hasGroupType = true;
            this.groupType_ = str;
            return this;
        }

        public MystiqueList setMystiqueData(String str) {
            this.hasMystiqueData = true;
            this.mystiqueData_ = str;
            return this;
        }

        public MystiqueList setPosition(int i4) {
            this.hasPosition = true;
            this.position_ = i4;
            return this;
        }

        public MystiqueList setWeight(int i4) {
            this.hasWeight = true;
            this.weight_ = i4;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasMystiqueData()) {
                dVar.A(1, getMystiqueData());
            }
            if (hasPosition()) {
                dVar.s(2, getPosition());
            }
            if (hasCardType()) {
                dVar.s(3, getCardType());
            }
            if (hasWeight()) {
                dVar.s(4, getWeight());
            }
            if (hasExpFeedbackData()) {
                dVar.u(5, getExpFeedbackData());
            }
            if (hasGroupType()) {
                dVar.A(6, getGroupType());
            }
        }

        public static MystiqueList parseFrom(byte[] bArr) throws e {
            return (MystiqueList) new MystiqueList().mergeFrom(bArr);
        }

        @Override // L1.f
        public MystiqueList mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setMystiqueData(bVar.n());
                } else if (iO == 16) {
                    setPosition(bVar.k());
                } else if (iO == 24) {
                    setCardType(bVar.k());
                } else if (iO == 32) {
                    setWeight(bVar.k());
                } else if (iO == 42) {
                    ExpFeedbackInfo expFeedbackInfo = new ExpFeedbackInfo();
                    bVar.f(expFeedbackInfo);
                    setExpFeedbackData(expFeedbackInfo);
                } else if (iO == 50) {
                    setGroupType(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class Option extends f {
        public static final int AI_SEARCH_RESULT_FIELD_NUMBER = 33;
        public static final int BD_SEARCH_ENABLE_FIELD_NUMBER = 20;
        public static final int BD_SEARCH_ORD_FIELD_NUMBER = 19;
        public static final int BD_SEARCH_TAG_FIELD_NUMBER = 21;
        public static final int CARD_SYTLE_MYSTIQUE_FIELD_NUMBER = 32;
        public static final int CITY_REGION_FIELD_NUMBER = 18;
        public static final int CLICK_REC_TIMES_FIELD_NUMBER = 25;
        public static final int CLIENT_SRC_FIELD_NUMBER = 22;
        public static final int DISP_ATTR_FIELD_NUMBER = 16;
        public static final int FILTER_SESSION_ID_FIELD_NUMBER = 29;
        public static final int JUMP_TYPE_FIELD_NUMBER = 31;
        public static final int LANDMARK_FLAG_FIELD_NUMBER = 13;
        public static final int LBS_DIRECT_FLAG_FIELD_NUMBER = 15;
        public static final int LDATA_FIELD_NUMBER = 14;
        public static final int LIST_THIRDKING_FLAG_FIELD_NUMBER = 12;
        public static final int LOC_ATTR_FIELD_NUMBER = 2;
        public static final int MOVE_AND_SEARCH_FLAG_FIELD_NUMBER = 28;
        public static final int NEXT_PAGE_FIELD_NUMBER = 26;
        public static final int OP_ADDR_FIELD_NUMBER = 4;
        public static final int OP_GEL_FIELD_NUMBER = 3;
        public static final int QID_FIELD_NUMBER = 6;
        public static final int REGION_TYPE_FIELD_NUMBER = 17;
        public static final int RES_BOUND_ACC_FIELD_NUMBER = 9;
        public static final int RES_BOUND_FIELD_NUMBER = 8;
        public static final int RES_X_FIELD_NUMBER = 10;
        public static final int RES_Y_FIELD_NUMBER = 11;
        public static final int RP_STRATEGY_FIELD_NUMBER = 5;
        public static final int SESSION_DATA_FIELD_NUMBER = 23;
        public static final int SHOW_CLICK_REC_FIELD_NUMBER = 24;
        public static final int STAT_TRADE_FIELD_NUMBER = 30;
        public static final int THIRD_PARTY_FIELD_NUMBER = 27;
        public static final int TOTAL_BUSLINE_NUM_FIELD_NUMBER = 7;
        public static final int TOTAL_FIELD_NUMBER = 1;
        private boolean hasAiSearchResult;
        private boolean hasBdSearchEnable;
        private boolean hasBdSearchOrd;
        private boolean hasBdSearchTag;
        private boolean hasCardSytleMystique;
        private boolean hasCityRegion;
        private boolean hasClickRecTimes;
        private boolean hasClientSrc;
        private boolean hasDispAttr;
        private boolean hasFilterSessionId;
        private boolean hasJumpType;
        private boolean hasLandmarkFlag;
        private boolean hasLbsDirectFlag;
        private boolean hasLdata;
        private boolean hasListThirdkingFlag;
        private boolean hasLocAttr;
        private boolean hasMoveAndSearchFlag;
        private boolean hasNextPage;
        private boolean hasOpAddr;
        private boolean hasOpGel;
        private boolean hasQid;
        private boolean hasRegionType;
        private boolean hasResBound;
        private boolean hasResBoundAcc;
        private boolean hasResX;
        private boolean hasResY;
        private boolean hasRpStrategy;
        private boolean hasSessionData;
        private boolean hasShowClickRec;
        private boolean hasStatTrade;
        private boolean hasThirdParty;
        private boolean hasTotal;
        private boolean hasTotalBuslineNum;
        private int total_ = 0;
        private int locAttr_ = 0;
        private boolean opGel_ = false;
        private boolean opAddr_ = false;
        private int rpStrategy_ = 0;
        private String qid_ = "";
        private int totalBuslineNum_ = 0;
        private String resBound_ = "";
        private String resBoundAcc_ = "";
        private String resX_ = "";
        private String resY_ = "";
        private int listThirdkingFlag_ = 0;
        private String landmarkFlag_ = "";
        private String ldata_ = "";
        private String lbsDirectFlag_ = "";
        private int dispAttr_ = 0;
        private String regionType_ = "";
        private String cityRegion_ = "";
        private int bdSearchOrd_ = 0;
        private int bdSearchEnable_ = 0;
        private String bdSearchTag_ = "";
        private int clientSrc_ = 0;
        private String sessionData_ = "";
        private boolean showClickRec_ = false;
        private int clickRecTimes_ = 0;
        private int nextPage_ = 0;
        private ThirdParty thirdParty_ = null;
        private String moveAndSearchFlag_ = "";
        private String filterSessionId_ = "";
        private String statTrade_ = "";
        private int jumpType_ = 0;
        private int cardSytleMystique_ = 0;
        private int aiSearchResult_ = 0;
        private int cachedSize = -1;

        public static Option parseFrom(b bVar) throws IOException {
            return new Option().mergeFrom(bVar);
        }

        public final Option clear() {
            clearTotal();
            clearLocAttr();
            clearOpGel();
            clearOpAddr();
            clearRpStrategy();
            clearQid();
            clearTotalBuslineNum();
            clearResBound();
            clearResBoundAcc();
            clearResX();
            clearResY();
            clearListThirdkingFlag();
            clearLandmarkFlag();
            clearLdata();
            clearLbsDirectFlag();
            clearDispAttr();
            clearRegionType();
            clearCityRegion();
            clearBdSearchOrd();
            clearBdSearchEnable();
            clearBdSearchTag();
            clearClientSrc();
            clearSessionData();
            clearShowClickRec();
            clearClickRecTimes();
            clearNextPage();
            clearThirdParty();
            clearMoveAndSearchFlag();
            clearFilterSessionId();
            clearStatTrade();
            clearJumpType();
            clearCardSytleMystique();
            clearAiSearchResult();
            this.cachedSize = -1;
            return this;
        }

        public Option clearAiSearchResult() {
            this.hasAiSearchResult = false;
            this.aiSearchResult_ = 0;
            return this;
        }

        public Option clearBdSearchEnable() {
            this.hasBdSearchEnable = false;
            this.bdSearchEnable_ = 0;
            return this;
        }

        public Option clearBdSearchOrd() {
            this.hasBdSearchOrd = false;
            this.bdSearchOrd_ = 0;
            return this;
        }

        public Option clearBdSearchTag() {
            this.hasBdSearchTag = false;
            this.bdSearchTag_ = "";
            return this;
        }

        public Option clearCardSytleMystique() {
            this.hasCardSytleMystique = false;
            this.cardSytleMystique_ = 0;
            return this;
        }

        public Option clearCityRegion() {
            this.hasCityRegion = false;
            this.cityRegion_ = "";
            return this;
        }

        public Option clearClickRecTimes() {
            this.hasClickRecTimes = false;
            this.clickRecTimes_ = 0;
            return this;
        }

        public Option clearClientSrc() {
            this.hasClientSrc = false;
            this.clientSrc_ = 0;
            return this;
        }

        public Option clearDispAttr() {
            this.hasDispAttr = false;
            this.dispAttr_ = 0;
            return this;
        }

        public Option clearFilterSessionId() {
            this.hasFilterSessionId = false;
            this.filterSessionId_ = "";
            return this;
        }

        public Option clearJumpType() {
            this.hasJumpType = false;
            this.jumpType_ = 0;
            return this;
        }

        public Option clearLandmarkFlag() {
            this.hasLandmarkFlag = false;
            this.landmarkFlag_ = "";
            return this;
        }

        public Option clearLbsDirectFlag() {
            this.hasLbsDirectFlag = false;
            this.lbsDirectFlag_ = "";
            return this;
        }

        public Option clearLdata() {
            this.hasLdata = false;
            this.ldata_ = "";
            return this;
        }

        public Option clearListThirdkingFlag() {
            this.hasListThirdkingFlag = false;
            this.listThirdkingFlag_ = 0;
            return this;
        }

        public Option clearLocAttr() {
            this.hasLocAttr = false;
            this.locAttr_ = 0;
            return this;
        }

        public Option clearMoveAndSearchFlag() {
            this.hasMoveAndSearchFlag = false;
            this.moveAndSearchFlag_ = "";
            return this;
        }

        public Option clearNextPage() {
            this.hasNextPage = false;
            this.nextPage_ = 0;
            return this;
        }

        public Option clearOpAddr() {
            this.hasOpAddr = false;
            this.opAddr_ = false;
            return this;
        }

        public Option clearOpGel() {
            this.hasOpGel = false;
            this.opGel_ = false;
            return this;
        }

        public Option clearQid() {
            this.hasQid = false;
            this.qid_ = "";
            return this;
        }

        public Option clearRegionType() {
            this.hasRegionType = false;
            this.regionType_ = "";
            return this;
        }

        public Option clearResBound() {
            this.hasResBound = false;
            this.resBound_ = "";
            return this;
        }

        public Option clearResBoundAcc() {
            this.hasResBoundAcc = false;
            this.resBoundAcc_ = "";
            return this;
        }

        public Option clearResX() {
            this.hasResX = false;
            this.resX_ = "";
            return this;
        }

        public Option clearResY() {
            this.hasResY = false;
            this.resY_ = "";
            return this;
        }

        public Option clearRpStrategy() {
            this.hasRpStrategy = false;
            this.rpStrategy_ = 0;
            return this;
        }

        public Option clearSessionData() {
            this.hasSessionData = false;
            this.sessionData_ = "";
            return this;
        }

        public Option clearShowClickRec() {
            this.hasShowClickRec = false;
            this.showClickRec_ = false;
            return this;
        }

        public Option clearStatTrade() {
            this.hasStatTrade = false;
            this.statTrade_ = "";
            return this;
        }

        public Option clearThirdParty() {
            this.hasThirdParty = false;
            this.thirdParty_ = null;
            return this;
        }

        public Option clearTotal() {
            this.hasTotal = false;
            this.total_ = 0;
            return this;
        }

        public Option clearTotalBuslineNum() {
            this.hasTotalBuslineNum = false;
            this.totalBuslineNum_ = 0;
            return this;
        }

        public int getAiSearchResult() {
            return this.aiSearchResult_;
        }

        public int getBdSearchEnable() {
            return this.bdSearchEnable_;
        }

        public int getBdSearchOrd() {
            return this.bdSearchOrd_;
        }

        public String getBdSearchTag() {
            return this.bdSearchTag_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public int getCardSytleMystique() {
            return this.cardSytleMystique_;
        }

        public String getCityRegion() {
            return this.cityRegion_;
        }

        public int getClickRecTimes() {
            return this.clickRecTimes_;
        }

        public int getClientSrc() {
            return this.clientSrc_;
        }

        public int getDispAttr() {
            return this.dispAttr_;
        }

        public String getFilterSessionId() {
            return this.filterSessionId_;
        }

        public int getJumpType() {
            return this.jumpType_;
        }

        public String getLandmarkFlag() {
            return this.landmarkFlag_;
        }

        public String getLbsDirectFlag() {
            return this.lbsDirectFlag_;
        }

        public String getLdata() {
            return this.ldata_;
        }

        public int getListThirdkingFlag() {
            return this.listThirdkingFlag_;
        }

        public int getLocAttr() {
            return this.locAttr_;
        }

        public String getMoveAndSearchFlag() {
            return this.moveAndSearchFlag_;
        }

        public int getNextPage() {
            return this.nextPage_;
        }

        public boolean getOpAddr() {
            return this.opAddr_;
        }

        public boolean getOpGel() {
            return this.opGel_;
        }

        public String getQid() {
            return this.qid_;
        }

        public String getRegionType() {
            return this.regionType_;
        }

        public String getResBound() {
            return this.resBound_;
        }

        public String getResBoundAcc() {
            return this.resBoundAcc_;
        }

        public String getResX() {
            return this.resX_;
        }

        public String getResY() {
            return this.resY_;
        }

        public int getRpStrategy() {
            return this.rpStrategy_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iE = hasTotal() ? d.e(1, getTotal()) : 0;
            if (hasLocAttr()) {
                iE += d.e(2, getLocAttr());
            }
            if (hasOpGel()) {
                getOpGel();
                iE += d.a(3);
            }
            if (hasOpAddr()) {
                getOpAddr();
                iE += d.a(4);
            }
            if (hasRpStrategy()) {
                iE += d.e(5, getRpStrategy());
            }
            if (hasQid()) {
                iE += d.l(6, getQid());
            }
            if (hasTotalBuslineNum()) {
                iE += d.e(7, getTotalBuslineNum());
            }
            if (hasResBound()) {
                iE += d.l(8, getResBound());
            }
            if (hasResBoundAcc()) {
                iE += d.l(9, getResBoundAcc());
            }
            if (hasResX()) {
                iE += d.l(10, getResX());
            }
            if (hasResY()) {
                iE += d.l(11, getResY());
            }
            if (hasListThirdkingFlag()) {
                iE += d.e(12, getListThirdkingFlag());
            }
            if (hasLandmarkFlag()) {
                iE += d.l(13, getLandmarkFlag());
            }
            if (hasLdata()) {
                iE += d.l(14, getLdata());
            }
            if (hasLbsDirectFlag()) {
                iE += d.l(15, getLbsDirectFlag());
            }
            if (hasDispAttr()) {
                iE += d.e(16, getDispAttr());
            }
            if (hasRegionType()) {
                iE += d.l(17, getRegionType());
            }
            if (hasCityRegion()) {
                iE += d.l(18, getCityRegion());
            }
            if (hasBdSearchOrd()) {
                iE += d.e(19, getBdSearchOrd());
            }
            if (hasBdSearchEnable()) {
                iE += d.e(20, getBdSearchEnable());
            }
            if (hasBdSearchTag()) {
                iE += d.l(21, getBdSearchTag());
            }
            if (hasClientSrc()) {
                iE += d.e(22, getClientSrc());
            }
            if (hasSessionData()) {
                iE += d.l(23, getSessionData());
            }
            if (hasShowClickRec()) {
                getShowClickRec();
                iE += d.a(24);
            }
            if (hasClickRecTimes()) {
                iE += d.e(25, getClickRecTimes());
            }
            if (hasNextPage()) {
                iE += d.e(26, getNextPage());
            }
            if (hasThirdParty()) {
                iE += d.h(27, getThirdParty());
            }
            if (hasMoveAndSearchFlag()) {
                iE += d.l(28, getMoveAndSearchFlag());
            }
            if (hasFilterSessionId()) {
                iE += d.l(29, getFilterSessionId());
            }
            if (hasStatTrade()) {
                iE += d.l(30, getStatTrade());
            }
            if (hasJumpType()) {
                iE += d.e(31, getJumpType());
            }
            if (hasCardSytleMystique()) {
                iE += d.e(32, getCardSytleMystique());
            }
            if (hasAiSearchResult()) {
                iE += d.e(33, getAiSearchResult());
            }
            this.cachedSize = iE;
            return iE;
        }

        public String getSessionData() {
            return this.sessionData_;
        }

        public boolean getShowClickRec() {
            return this.showClickRec_;
        }

        public String getStatTrade() {
            return this.statTrade_;
        }

        public ThirdParty getThirdParty() {
            return this.thirdParty_;
        }

        public int getTotal() {
            return this.total_;
        }

        public int getTotalBuslineNum() {
            return this.totalBuslineNum_;
        }

        public boolean hasAiSearchResult() {
            return this.hasAiSearchResult;
        }

        public boolean hasBdSearchEnable() {
            return this.hasBdSearchEnable;
        }

        public boolean hasBdSearchOrd() {
            return this.hasBdSearchOrd;
        }

        public boolean hasBdSearchTag() {
            return this.hasBdSearchTag;
        }

        public boolean hasCardSytleMystique() {
            return this.hasCardSytleMystique;
        }

        public boolean hasCityRegion() {
            return this.hasCityRegion;
        }

        public boolean hasClickRecTimes() {
            return this.hasClickRecTimes;
        }

        public boolean hasClientSrc() {
            return this.hasClientSrc;
        }

        public boolean hasDispAttr() {
            return this.hasDispAttr;
        }

        public boolean hasFilterSessionId() {
            return this.hasFilterSessionId;
        }

        public boolean hasJumpType() {
            return this.hasJumpType;
        }

        public boolean hasLandmarkFlag() {
            return this.hasLandmarkFlag;
        }

        public boolean hasLbsDirectFlag() {
            return this.hasLbsDirectFlag;
        }

        public boolean hasLdata() {
            return this.hasLdata;
        }

        public boolean hasListThirdkingFlag() {
            return this.hasListThirdkingFlag;
        }

        public boolean hasLocAttr() {
            return this.hasLocAttr;
        }

        public boolean hasMoveAndSearchFlag() {
            return this.hasMoveAndSearchFlag;
        }

        public boolean hasNextPage() {
            return this.hasNextPage;
        }

        public boolean hasOpAddr() {
            return this.hasOpAddr;
        }

        public boolean hasOpGel() {
            return this.hasOpGel;
        }

        public boolean hasQid() {
            return this.hasQid;
        }

        public boolean hasRegionType() {
            return this.hasRegionType;
        }

        public boolean hasResBound() {
            return this.hasResBound;
        }

        public boolean hasResBoundAcc() {
            return this.hasResBoundAcc;
        }

        public boolean hasResX() {
            return this.hasResX;
        }

        public boolean hasResY() {
            return this.hasResY;
        }

        public boolean hasRpStrategy() {
            return this.hasRpStrategy;
        }

        public boolean hasSessionData() {
            return this.hasSessionData;
        }

        public boolean hasShowClickRec() {
            return this.hasShowClickRec;
        }

        public boolean hasStatTrade() {
            return this.hasStatTrade;
        }

        public boolean hasThirdParty() {
            return this.hasThirdParty;
        }

        public boolean hasTotal() {
            return this.hasTotal;
        }

        public boolean hasTotalBuslineNum() {
            return this.hasTotalBuslineNum;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option setAiSearchResult(int i4) {
            this.hasAiSearchResult = true;
            this.aiSearchResult_ = i4;
            return this;
        }

        public Option setBdSearchEnable(int i4) {
            this.hasBdSearchEnable = true;
            this.bdSearchEnable_ = i4;
            return this;
        }

        public Option setBdSearchOrd(int i4) {
            this.hasBdSearchOrd = true;
            this.bdSearchOrd_ = i4;
            return this;
        }

        public Option setBdSearchTag(String str) {
            this.hasBdSearchTag = true;
            this.bdSearchTag_ = str;
            return this;
        }

        public Option setCardSytleMystique(int i4) {
            this.hasCardSytleMystique = true;
            this.cardSytleMystique_ = i4;
            return this;
        }

        public Option setCityRegion(String str) {
            this.hasCityRegion = true;
            this.cityRegion_ = str;
            return this;
        }

        public Option setClickRecTimes(int i4) {
            this.hasClickRecTimes = true;
            this.clickRecTimes_ = i4;
            return this;
        }

        public Option setClientSrc(int i4) {
            this.hasClientSrc = true;
            this.clientSrc_ = i4;
            return this;
        }

        public Option setDispAttr(int i4) {
            this.hasDispAttr = true;
            this.dispAttr_ = i4;
            return this;
        }

        public Option setFilterSessionId(String str) {
            this.hasFilterSessionId = true;
            this.filterSessionId_ = str;
            return this;
        }

        public Option setJumpType(int i4) {
            this.hasJumpType = true;
            this.jumpType_ = i4;
            return this;
        }

        public Option setLandmarkFlag(String str) {
            this.hasLandmarkFlag = true;
            this.landmarkFlag_ = str;
            return this;
        }

        public Option setLbsDirectFlag(String str) {
            this.hasLbsDirectFlag = true;
            this.lbsDirectFlag_ = str;
            return this;
        }

        public Option setLdata(String str) {
            this.hasLdata = true;
            this.ldata_ = str;
            return this;
        }

        public Option setListThirdkingFlag(int i4) {
            this.hasListThirdkingFlag = true;
            this.listThirdkingFlag_ = i4;
            return this;
        }

        public Option setLocAttr(int i4) {
            this.hasLocAttr = true;
            this.locAttr_ = i4;
            return this;
        }

        public Option setMoveAndSearchFlag(String str) {
            this.hasMoveAndSearchFlag = true;
            this.moveAndSearchFlag_ = str;
            return this;
        }

        public Option setNextPage(int i4) {
            this.hasNextPage = true;
            this.nextPage_ = i4;
            return this;
        }

        public Option setOpAddr(boolean z4) {
            this.hasOpAddr = true;
            this.opAddr_ = z4;
            return this;
        }

        public Option setOpGel(boolean z4) {
            this.hasOpGel = true;
            this.opGel_ = z4;
            return this;
        }

        public Option setQid(String str) {
            this.hasQid = true;
            this.qid_ = str;
            return this;
        }

        public Option setRegionType(String str) {
            this.hasRegionType = true;
            this.regionType_ = str;
            return this;
        }

        public Option setResBound(String str) {
            this.hasResBound = true;
            this.resBound_ = str;
            return this;
        }

        public Option setResBoundAcc(String str) {
            this.hasResBoundAcc = true;
            this.resBoundAcc_ = str;
            return this;
        }

        public Option setResX(String str) {
            this.hasResX = true;
            this.resX_ = str;
            return this;
        }

        public Option setResY(String str) {
            this.hasResY = true;
            this.resY_ = str;
            return this;
        }

        public Option setRpStrategy(int i4) {
            this.hasRpStrategy = true;
            this.rpStrategy_ = i4;
            return this;
        }

        public Option setSessionData(String str) {
            this.hasSessionData = true;
            this.sessionData_ = str;
            return this;
        }

        public Option setShowClickRec(boolean z4) {
            this.hasShowClickRec = true;
            this.showClickRec_ = z4;
            return this;
        }

        public Option setStatTrade(String str) {
            this.hasStatTrade = true;
            this.statTrade_ = str;
            return this;
        }

        public Option setThirdParty(ThirdParty thirdParty) {
            if (thirdParty == null) {
                return clearThirdParty();
            }
            this.hasThirdParty = true;
            this.thirdParty_ = thirdParty;
            return this;
        }

        public Option setTotal(int i4) {
            this.hasTotal = true;
            this.total_ = i4;
            return this;
        }

        public Option setTotalBuslineNum(int i4) {
            this.hasTotalBuslineNum = true;
            this.totalBuslineNum_ = i4;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasTotal()) {
                dVar.s(1, getTotal());
            }
            if (hasLocAttr()) {
                dVar.s(2, getLocAttr());
            }
            if (hasOpGel()) {
                dVar.p(3, getOpGel());
            }
            if (hasOpAddr()) {
                dVar.p(4, getOpAddr());
            }
            if (hasRpStrategy()) {
                dVar.s(5, getRpStrategy());
            }
            if (hasQid()) {
                dVar.A(6, getQid());
            }
            if (hasTotalBuslineNum()) {
                dVar.s(7, getTotalBuslineNum());
            }
            if (hasResBound()) {
                dVar.A(8, getResBound());
            }
            if (hasResBoundAcc()) {
                dVar.A(9, getResBoundAcc());
            }
            if (hasResX()) {
                dVar.A(10, getResX());
            }
            if (hasResY()) {
                dVar.A(11, getResY());
            }
            if (hasListThirdkingFlag()) {
                dVar.s(12, getListThirdkingFlag());
            }
            if (hasLandmarkFlag()) {
                dVar.A(13, getLandmarkFlag());
            }
            if (hasLdata()) {
                dVar.A(14, getLdata());
            }
            if (hasLbsDirectFlag()) {
                dVar.A(15, getLbsDirectFlag());
            }
            if (hasDispAttr()) {
                dVar.s(16, getDispAttr());
            }
            if (hasRegionType()) {
                dVar.A(17, getRegionType());
            }
            if (hasCityRegion()) {
                dVar.A(18, getCityRegion());
            }
            if (hasBdSearchOrd()) {
                dVar.s(19, getBdSearchOrd());
            }
            if (hasBdSearchEnable()) {
                dVar.s(20, getBdSearchEnable());
            }
            if (hasBdSearchTag()) {
                dVar.A(21, getBdSearchTag());
            }
            if (hasClientSrc()) {
                dVar.s(22, getClientSrc());
            }
            if (hasSessionData()) {
                dVar.A(23, getSessionData());
            }
            if (hasShowClickRec()) {
                dVar.p(24, getShowClickRec());
            }
            if (hasClickRecTimes()) {
                dVar.s(25, getClickRecTimes());
            }
            if (hasNextPage()) {
                dVar.s(26, getNextPage());
            }
            if (hasThirdParty()) {
                dVar.u(27, getThirdParty());
            }
            if (hasMoveAndSearchFlag()) {
                dVar.A(28, getMoveAndSearchFlag());
            }
            if (hasFilterSessionId()) {
                dVar.A(29, getFilterSessionId());
            }
            if (hasStatTrade()) {
                dVar.A(30, getStatTrade());
            }
            if (hasJumpType()) {
                dVar.s(31, getJumpType());
            }
            if (hasCardSytleMystique()) {
                dVar.s(32, getCardSytleMystique());
            }
            if (hasAiSearchResult()) {
                dVar.s(33, getAiSearchResult());
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
                    case 16:
                        setLocAttr(bVar.k());
                        break;
                    case 24:
                        setOpGel(bVar.a());
                        break;
                    case 32:
                        setOpAddr(bVar.a());
                        break;
                    case 40:
                        setRpStrategy(bVar.k());
                        break;
                    case 50:
                        setQid(bVar.n());
                        break;
                    case 56:
                        setTotalBuslineNum(bVar.k());
                        break;
                    case 66:
                        setResBound(bVar.n());
                        break;
                    case Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                        setResBoundAcc(bVar.n());
                        break;
                    case Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                        setResX(bVar.n());
                        break;
                    case 90:
                        setResY(bVar.n());
                        break;
                    case 96:
                        setListThirdkingFlag(bVar.k());
                        break;
                    case 106:
                        setLandmarkFlag(bVar.n());
                        break;
                    case 114:
                        setLdata(bVar.n());
                        break;
                    case 122:
                        setLbsDirectFlag(bVar.n());
                        break;
                    case 128:
                        setDispAttr(bVar.k());
                        break;
                    case 138:
                        setRegionType(bVar.n());
                        break;
                    case 146:
                        setCityRegion(bVar.n());
                        break;
                    case SyslogConstants.LOG_LOCAL3 /* 152 */:
                        setBdSearchOrd(bVar.k());
                        break;
                    case 160:
                        setBdSearchEnable(bVar.k());
                        break;
                    case 170:
                        setBdSearchTag(bVar.n());
                        break;
                    case 176:
                        setClientSrc(bVar.k());
                        break;
                    case 186:
                        setSessionData(bVar.n());
                        break;
                    case Opcodes.CHECKCAST /* 192 */:
                        setShowClickRec(bVar.a());
                        break;
                    case 200:
                        setClickRecTimes(bVar.k());
                        break;
                    case 208:
                        setNextPage(bVar.k());
                        break;
                    case 218:
                        ThirdParty thirdParty = new ThirdParty();
                        bVar.f(thirdParty);
                        setThirdParty(thirdParty);
                        break;
                    case 226:
                        setMoveAndSearchFlag(bVar.n());
                        break;
                    case 234:
                        setFilterSessionId(bVar.n());
                        break;
                    case 242:
                        setStatTrade(bVar.n());
                        break;
                    case 248:
                        setJumpType(bVar.k());
                        break;
                    case 256:
                        setCardSytleMystique(bVar.k());
                        break;
                    case 264:
                        setAiSearchResult(bVar.k());
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

    public static final class PlaceInfo extends f {
        public static final int BANNER_INFO_FIELD_NUMBER = 8;
        public static final int D_ACT_CARD_FIELD_NUMBER = 9;
        public static final int D_BUSINESS_ID_FIELD_NUMBER = 5;
        public static final int D_BUSINESS_TYPE_FIELD_NUMBER = 6;
        public static final int D_DATA_TYPE_FIELD_NUMBER = 1;
        public static final int D_FILTERS_SHOW_FLAG_FIELD_NUMBER = 4;
        public static final int D_SORT_RULE_FIELD_NUMBER = 3;
        public static final int D_SORT_TYPE_FIELD_NUMBER = 2;
        public static final int D_SUB_TYPE_FIELD_NUMBER = 10;
        public static final int FILTERS_FIELD_NUMBER = 11;
        public static final int PRE_FILTERS_FIELD_NUMBER = 12;
        public static final int SEARCH_EXT_FIELD_NUMBER = 7;
        public static final int TAB_FILTERS_FIELD_NUMBER = 13;
        private int cachedSize;
        private a filters_;
        private boolean hasBannerInfo;
        private boolean hasDActCard;
        private boolean hasDBusinessId;
        private boolean hasDBusinessType;
        private boolean hasDDataType;
        private boolean hasDFiltersShowFlag;
        private boolean hasDSortRule;
        private boolean hasDSortType;
        private boolean hasDSubType;
        private boolean hasFilters;
        private boolean hasPreFilters;
        private boolean hasTabFilters;
        private a preFilters_;
        private a tabFilters_;
        private List<SearchExt> searchExt_ = Collections.emptyList();
        private DActCard dActCard_ = null;
        private BannerInfo bannerInfo_ = null;
        private String dDataType_ = "";
        private String dSortType_ = "";
        private int dSortRule_ = 0;
        private int dFiltersShowFlag_ = 0;
        private String dBusinessId_ = "";
        private String dBusinessType_ = "";
        private String dSubType_ = "";

        public static final class BannerInfo extends f {
            public static final int ACT_FIELD_NUMBER = 4;
            public static final int ACT_URL_FIELD_NUMBER = 5;
            public static final int DESCRIPTION_FIELD_NUMBER = 6;
            public static final int IMAGE_FIELD_NUMBER = 3;
            public static final int SCORE_FIELD_NUMBER = 2;
            public static final int STAR_FIELD_NUMBER = 7;
            public static final int TITLE_FIELD_NUMBER = 1;
            private boolean hasAct;
            private boolean hasActUrl;
            private boolean hasDescription;
            private boolean hasImage;
            private boolean hasScore;
            private boolean hasStar;
            private boolean hasTitle;
            private String title_ = "";
            private String score_ = "";
            private String image_ = "";
            private String act_ = "";
            private String actUrl_ = "";
            private String description_ = "";
            private String star_ = "";
            private int cachedSize = -1;

            public static BannerInfo parseFrom(b bVar) throws IOException {
                return new BannerInfo().mergeFrom(bVar);
            }

            public final BannerInfo clear() {
                clearTitle();
                clearScore();
                clearImage();
                clearAct();
                clearActUrl();
                clearDescription();
                clearStar();
                this.cachedSize = -1;
                return this;
            }

            public BannerInfo clearAct() {
                this.hasAct = false;
                this.act_ = "";
                return this;
            }

            public BannerInfo clearActUrl() {
                this.hasActUrl = false;
                this.actUrl_ = "";
                return this;
            }

            public BannerInfo clearDescription() {
                this.hasDescription = false;
                this.description_ = "";
                return this;
            }

            public BannerInfo clearImage() {
                this.hasImage = false;
                this.image_ = "";
                return this;
            }

            public BannerInfo clearScore() {
                this.hasScore = false;
                this.score_ = "";
                return this;
            }

            public BannerInfo clearStar() {
                this.hasStar = false;
                this.star_ = "";
                return this;
            }

            public BannerInfo clearTitle() {
                this.hasTitle = false;
                this.title_ = "";
                return this;
            }

            public String getAct() {
                return this.act_;
            }

            public String getActUrl() {
                return this.actUrl_;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getDescription() {
                return this.description_;
            }

            public String getImage() {
                return this.image_;
            }

            public String getScore() {
                return this.score_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasTitle() ? d.l(1, getTitle()) : 0;
                if (hasScore()) {
                    iL += d.l(2, getScore());
                }
                if (hasImage()) {
                    iL += d.l(3, getImage());
                }
                if (hasAct()) {
                    iL += d.l(4, getAct());
                }
                if (hasActUrl()) {
                    iL += d.l(5, getActUrl());
                }
                if (hasDescription()) {
                    iL += d.l(6, getDescription());
                }
                if (hasStar()) {
                    iL += d.l(7, getStar());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getStar() {
                return this.star_;
            }

            public String getTitle() {
                return this.title_;
            }

            public boolean hasAct() {
                return this.hasAct;
            }

            public boolean hasActUrl() {
                return this.hasActUrl;
            }

            public boolean hasDescription() {
                return this.hasDescription;
            }

            public boolean hasImage() {
                return this.hasImage;
            }

            public boolean hasScore() {
                return this.hasScore;
            }

            public boolean hasStar() {
                return this.hasStar;
            }

            public boolean hasTitle() {
                return this.hasTitle;
            }

            public final boolean isInitialized() {
                return true;
            }

            public BannerInfo setAct(String str) {
                this.hasAct = true;
                this.act_ = str;
                return this;
            }

            public BannerInfo setActUrl(String str) {
                this.hasActUrl = true;
                this.actUrl_ = str;
                return this;
            }

            public BannerInfo setDescription(String str) {
                this.hasDescription = true;
                this.description_ = str;
                return this;
            }

            public BannerInfo setImage(String str) {
                this.hasImage = true;
                this.image_ = str;
                return this;
            }

            public BannerInfo setScore(String str) {
                this.hasScore = true;
                this.score_ = str;
                return this;
            }

            public BannerInfo setStar(String str) {
                this.hasStar = true;
                this.star_ = str;
                return this;
            }

            public BannerInfo setTitle(String str) {
                this.hasTitle = true;
                this.title_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasTitle()) {
                    dVar.A(1, getTitle());
                }
                if (hasScore()) {
                    dVar.A(2, getScore());
                }
                if (hasImage()) {
                    dVar.A(3, getImage());
                }
                if (hasAct()) {
                    dVar.A(4, getAct());
                }
                if (hasActUrl()) {
                    dVar.A(5, getActUrl());
                }
                if (hasDescription()) {
                    dVar.A(6, getDescription());
                }
                if (hasStar()) {
                    dVar.A(7, getStar());
                }
            }

            public static BannerInfo parseFrom(byte[] bArr) throws e {
                return (BannerInfo) new BannerInfo().mergeFrom(bArr);
            }

            @Override // L1.f
            public BannerInfo mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setTitle(bVar.n());
                    } else if (iO == 18) {
                        setScore(bVar.n());
                    } else if (iO == 26) {
                        setImage(bVar.n());
                    } else if (iO == 34) {
                        setAct(bVar.n());
                    } else if (iO == 42) {
                        setActUrl(bVar.n());
                    } else if (iO == 50) {
                        setDescription(bVar.n());
                    } else if (iO == 58) {
                        setStar(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class DActCard extends f {
            public static final int IMG_URL_FIELD_NUMBER = 2;
            public static final int LINK_FIELD_NUMBER = 1;
            private boolean hasImgUrl;
            private boolean hasLink;
            private String link_ = "";
            private String imgUrl_ = "";
            private int cachedSize = -1;

            public static DActCard parseFrom(b bVar) throws IOException {
                return new DActCard().mergeFrom(bVar);
            }

            public final DActCard clear() {
                clearLink();
                clearImgUrl();
                this.cachedSize = -1;
                return this;
            }

            public DActCard clearImgUrl() {
                this.hasImgUrl = false;
                this.imgUrl_ = "";
                return this;
            }

            public DActCard clearLink() {
                this.hasLink = false;
                this.link_ = "";
                return this;
            }

            @Override // L1.f
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getImgUrl() {
                return this.imgUrl_;
            }

            public String getLink() {
                return this.link_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasLink() ? d.l(1, getLink()) : 0;
                if (hasImgUrl()) {
                    iL += d.l(2, getImgUrl());
                }
                this.cachedSize = iL;
                return iL;
            }

            public boolean hasImgUrl() {
                return this.hasImgUrl;
            }

            public boolean hasLink() {
                return this.hasLink;
            }

            public final boolean isInitialized() {
                return true;
            }

            public DActCard setImgUrl(String str) {
                this.hasImgUrl = true;
                this.imgUrl_ = str;
                return this;
            }

            public DActCard setLink(String str) {
                this.hasLink = true;
                this.link_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasLink()) {
                    dVar.A(1, getLink());
                }
                if (hasImgUrl()) {
                    dVar.A(2, getImgUrl());
                }
            }

            public static DActCard parseFrom(byte[] bArr) throws e {
                return (DActCard) new DActCard().mergeFrom(bArr);
            }

            @Override // L1.f
            public DActCard mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setLink(bVar.n());
                    } else if (iO == 18) {
                        setImgUrl(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static final class SearchExt extends f {
            public static final int TITLE_FIELD_NUMBER = 1;
            public static final int WD_FIELD_NUMBER = 2;
            private boolean hasTitle;
            private boolean hasWd;
            private String title_ = "";
            private String wd_ = "";
            private int cachedSize = -1;

            public static SearchExt parseFrom(b bVar) throws IOException {
                return new SearchExt().mergeFrom(bVar);
            }

            public final SearchExt clear() {
                clearTitle();
                clearWd();
                this.cachedSize = -1;
                return this;
            }

            public SearchExt clearTitle() {
                this.hasTitle = false;
                this.title_ = "";
                return this;
            }

            public SearchExt clearWd() {
                this.hasWd = false;
                this.wd_ = "";
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
                int iL = hasTitle() ? d.l(1, getTitle()) : 0;
                if (hasWd()) {
                    iL += d.l(2, getWd());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getTitle() {
                return this.title_;
            }

            public String getWd() {
                return this.wd_;
            }

            public boolean hasTitle() {
                return this.hasTitle;
            }

            public boolean hasWd() {
                return this.hasWd;
            }

            public final boolean isInitialized() {
                return true;
            }

            public SearchExt setTitle(String str) {
                this.hasTitle = true;
                this.title_ = str;
                return this;
            }

            public SearchExt setWd(String str) {
                this.hasWd = true;
                this.wd_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasTitle()) {
                    dVar.A(1, getTitle());
                }
                if (hasWd()) {
                    dVar.A(2, getWd());
                }
            }

            public static SearchExt parseFrom(byte[] bArr) throws e {
                return (SearchExt) new SearchExt().mergeFrom(bArr);
            }

            @Override // L1.f
            public SearchExt mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setTitle(bVar.n());
                    } else if (iO == 18) {
                        setWd(bVar.n());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public PlaceInfo() {
            a aVar = a.f1216c;
            this.filters_ = aVar;
            this.preFilters_ = aVar;
            this.tabFilters_ = aVar;
            this.cachedSize = -1;
        }

        public static PlaceInfo parseFrom(b bVar) throws IOException {
            return new PlaceInfo().mergeFrom(bVar);
        }

        public PlaceInfo addSearchExt(SearchExt searchExt) {
            if (searchExt == null) {
                return this;
            }
            if (this.searchExt_.isEmpty()) {
                this.searchExt_ = new ArrayList();
            }
            this.searchExt_.add(searchExt);
            return this;
        }

        public final PlaceInfo clear() {
            clearSearchExt();
            clearDActCard();
            clearBannerInfo();
            clearDDataType();
            clearDSortType();
            clearDSortRule();
            clearDFiltersShowFlag();
            clearDBusinessId();
            clearDBusinessType();
            clearDSubType();
            clearFilters();
            clearPreFilters();
            clearTabFilters();
            this.cachedSize = -1;
            return this;
        }

        public PlaceInfo clearBannerInfo() {
            this.hasBannerInfo = false;
            this.bannerInfo_ = null;
            return this;
        }

        public PlaceInfo clearDActCard() {
            this.hasDActCard = false;
            this.dActCard_ = null;
            return this;
        }

        public PlaceInfo clearDBusinessId() {
            this.hasDBusinessId = false;
            this.dBusinessId_ = "";
            return this;
        }

        public PlaceInfo clearDBusinessType() {
            this.hasDBusinessType = false;
            this.dBusinessType_ = "";
            return this;
        }

        public PlaceInfo clearDDataType() {
            this.hasDDataType = false;
            this.dDataType_ = "";
            return this;
        }

        public PlaceInfo clearDFiltersShowFlag() {
            this.hasDFiltersShowFlag = false;
            this.dFiltersShowFlag_ = 0;
            return this;
        }

        public PlaceInfo clearDSortRule() {
            this.hasDSortRule = false;
            this.dSortRule_ = 0;
            return this;
        }

        public PlaceInfo clearDSortType() {
            this.hasDSortType = false;
            this.dSortType_ = "";
            return this;
        }

        public PlaceInfo clearDSubType() {
            this.hasDSubType = false;
            this.dSubType_ = "";
            return this;
        }

        public PlaceInfo clearFilters() {
            this.hasFilters = false;
            this.filters_ = a.f1216c;
            return this;
        }

        public PlaceInfo clearPreFilters() {
            this.hasPreFilters = false;
            this.preFilters_ = a.f1216c;
            return this;
        }

        public PlaceInfo clearSearchExt() {
            this.searchExt_ = Collections.emptyList();
            return this;
        }

        public PlaceInfo clearTabFilters() {
            this.hasTabFilters = false;
            this.tabFilters_ = a.f1216c;
            return this;
        }

        public BannerInfo getBannerInfo() {
            return this.bannerInfo_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public DActCard getDActCard() {
            return this.dActCard_;
        }

        public String getDBusinessId() {
            return this.dBusinessId_;
        }

        public String getDBusinessType() {
            return this.dBusinessType_;
        }

        public String getDDataType() {
            return this.dDataType_;
        }

        public int getDFiltersShowFlag() {
            return this.dFiltersShowFlag_;
        }

        public int getDSortRule() {
            return this.dSortRule_;
        }

        public String getDSortType() {
            return this.dSortType_;
        }

        public String getDSubType() {
            return this.dSubType_;
        }

        public a getFilters() {
            return this.filters_;
        }

        public a getPreFilters() {
            return this.preFilters_;
        }

        public SearchExt getSearchExt(int i4) {
            return this.searchExt_.get(i4);
        }

        public int getSearchExtCount() {
            return this.searchExt_.size();
        }

        public List<SearchExt> getSearchExtList() {
            return this.searchExt_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasDDataType() ? d.l(1, getDDataType()) : 0;
            if (hasDSortType()) {
                iL += d.l(2, getDSortType());
            }
            if (hasDSortRule()) {
                iL += d.e(3, getDSortRule());
            }
            if (hasDFiltersShowFlag()) {
                iL += d.e(4, getDFiltersShowFlag());
            }
            if (hasDBusinessId()) {
                iL += d.l(5, getDBusinessId());
            }
            if (hasDBusinessType()) {
                iL += d.l(6, getDBusinessType());
            }
            Iterator<SearchExt> it = getSearchExtList().iterator();
            while (it.hasNext()) {
                iL += d.h(7, it.next());
            }
            if (hasBannerInfo()) {
                iL += d.h(8, getBannerInfo());
            }
            if (hasDActCard()) {
                iL += d.h(9, getDActCard());
            }
            if (hasDSubType()) {
                iL += d.l(10, getDSubType());
            }
            if (hasFilters()) {
                iL += d.b(11, getFilters());
            }
            if (hasPreFilters()) {
                iL += d.b(12, getPreFilters());
            }
            if (hasTabFilters()) {
                iL += d.b(13, getTabFilters());
            }
            this.cachedSize = iL;
            return iL;
        }

        public a getTabFilters() {
            return this.tabFilters_;
        }

        public boolean hasBannerInfo() {
            return this.hasBannerInfo;
        }

        public boolean hasDActCard() {
            return this.hasDActCard;
        }

        public boolean hasDBusinessId() {
            return this.hasDBusinessId;
        }

        public boolean hasDBusinessType() {
            return this.hasDBusinessType;
        }

        public boolean hasDDataType() {
            return this.hasDDataType;
        }

        public boolean hasDFiltersShowFlag() {
            return this.hasDFiltersShowFlag;
        }

        public boolean hasDSortRule() {
            return this.hasDSortRule;
        }

        public boolean hasDSortType() {
            return this.hasDSortType;
        }

        public boolean hasDSubType() {
            return this.hasDSubType;
        }

        public boolean hasFilters() {
            return this.hasFilters;
        }

        public boolean hasPreFilters() {
            return this.hasPreFilters;
        }

        public boolean hasTabFilters() {
            return this.hasTabFilters;
        }

        public final boolean isInitialized() {
            return true;
        }

        public PlaceInfo setBannerInfo(BannerInfo bannerInfo) {
            if (bannerInfo == null) {
                return clearBannerInfo();
            }
            this.hasBannerInfo = true;
            this.bannerInfo_ = bannerInfo;
            return this;
        }

        public PlaceInfo setDActCard(DActCard dActCard) {
            if (dActCard == null) {
                return clearDActCard();
            }
            this.hasDActCard = true;
            this.dActCard_ = dActCard;
            return this;
        }

        public PlaceInfo setDBusinessId(String str) {
            this.hasDBusinessId = true;
            this.dBusinessId_ = str;
            return this;
        }

        public PlaceInfo setDBusinessType(String str) {
            this.hasDBusinessType = true;
            this.dBusinessType_ = str;
            return this;
        }

        public PlaceInfo setDDataType(String str) {
            this.hasDDataType = true;
            this.dDataType_ = str;
            return this;
        }

        public PlaceInfo setDFiltersShowFlag(int i4) {
            this.hasDFiltersShowFlag = true;
            this.dFiltersShowFlag_ = i4;
            return this;
        }

        public PlaceInfo setDSortRule(int i4) {
            this.hasDSortRule = true;
            this.dSortRule_ = i4;
            return this;
        }

        public PlaceInfo setDSortType(String str) {
            this.hasDSortType = true;
            this.dSortType_ = str;
            return this;
        }

        public PlaceInfo setDSubType(String str) {
            this.hasDSubType = true;
            this.dSubType_ = str;
            return this;
        }

        public PlaceInfo setFilters(a aVar) {
            this.hasFilters = true;
            this.filters_ = aVar;
            return this;
        }

        public PlaceInfo setPreFilters(a aVar) {
            this.hasPreFilters = true;
            this.preFilters_ = aVar;
            return this;
        }

        public PlaceInfo setSearchExt(int i4, SearchExt searchExt) {
            if (searchExt == null) {
                return this;
            }
            this.searchExt_.set(i4, searchExt);
            return this;
        }

        public PlaceInfo setTabFilters(a aVar) {
            this.hasTabFilters = true;
            this.tabFilters_ = aVar;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasDDataType()) {
                dVar.A(1, getDDataType());
            }
            if (hasDSortType()) {
                dVar.A(2, getDSortType());
            }
            if (hasDSortRule()) {
                dVar.s(3, getDSortRule());
            }
            if (hasDFiltersShowFlag()) {
                dVar.s(4, getDFiltersShowFlag());
            }
            if (hasDBusinessId()) {
                dVar.A(5, getDBusinessId());
            }
            if (hasDBusinessType()) {
                dVar.A(6, getDBusinessType());
            }
            Iterator<SearchExt> it = getSearchExtList().iterator();
            while (it.hasNext()) {
                dVar.u(7, it.next());
            }
            if (hasBannerInfo()) {
                dVar.u(8, getBannerInfo());
            }
            if (hasDActCard()) {
                dVar.u(9, getDActCard());
            }
            if (hasDSubType()) {
                dVar.A(10, getDSubType());
            }
            if (hasFilters()) {
                dVar.q(11, getFilters());
            }
            if (hasPreFilters()) {
                dVar.q(12, getPreFilters());
            }
            if (hasTabFilters()) {
                dVar.q(13, getTabFilters());
            }
        }

        public static PlaceInfo parseFrom(byte[] bArr) throws e {
            return (PlaceInfo) new PlaceInfo().mergeFrom(bArr);
        }

        @Override // L1.f
        public PlaceInfo mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                switch (iO) {
                    case 0:
                        return this;
                    case 10:
                        setDDataType(bVar.n());
                        break;
                    case 18:
                        setDSortType(bVar.n());
                        break;
                    case 24:
                        setDSortRule(bVar.k());
                        break;
                    case 32:
                        setDFiltersShowFlag(bVar.k());
                        break;
                    case 42:
                        setDBusinessId(bVar.n());
                        break;
                    case 50:
                        setDBusinessType(bVar.n());
                        break;
                    case 58:
                        SearchExt searchExt = new SearchExt();
                        bVar.f(searchExt);
                        addSearchExt(searchExt);
                        break;
                    case 66:
                        BannerInfo bannerInfo = new BannerInfo();
                        bVar.f(bannerInfo);
                        setBannerInfo(bannerInfo);
                        break;
                    case Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                        DActCard dActCard = new DActCard();
                        bVar.f(dActCard);
                        setDActCard(dActCard);
                        break;
                    case Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                        setDSubType(bVar.n());
                        break;
                    case 90:
                        setFilters(bVar.b());
                        break;
                    case 98:
                        setPreFilters(bVar.b());
                        break;
                    case 106:
                        setTabFilters(bVar.b());
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

    public static final class PreviousCity extends f {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        private boolean hasCode;
        private boolean hasName;
        private int code_ = 0;
        private String name_ = "";
        private int cachedSize = -1;

        public static PreviousCity parseFrom(b bVar) throws IOException {
            return new PreviousCity().mergeFrom(bVar);
        }

        public final PreviousCity clear() {
            clearCode();
            clearName();
            this.cachedSize = -1;
            return this;
        }

        public PreviousCity clearCode() {
            this.hasCode = false;
            this.code_ = 0;
            return this;
        }

        public PreviousCity clearName() {
            this.hasName = false;
            this.name_ = "";
            return this;
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

        public String getName() {
            return this.name_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iE = hasCode() ? d.e(1, getCode()) : 0;
            if (hasName()) {
                iE += d.l(2, getName());
            }
            this.cachedSize = iE;
            return iE;
        }

        public boolean hasCode() {
            return this.hasCode;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public final boolean isInitialized() {
            return true;
        }

        public PreviousCity setCode(int i4) {
            this.hasCode = true;
            this.code_ = i4;
            return this;
        }

        public PreviousCity setName(String str) {
            this.hasName = true;
            this.name_ = str;
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
        }

        public static PreviousCity parseFrom(byte[] bArr) throws e {
            return (PreviousCity) new PreviousCity().mergeFrom(bArr);
        }

        @Override // L1.f
        public PreviousCity mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 8) {
                    setCode(bVar.k());
                } else if (iO == 18) {
                    setName(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class Psrs extends f {
        public static final int SENUM_FIELD_NUMBER = 1;
        public static final int SERESULT_FIELD_NUMBER = 2;
        private boolean hasSENum;
        private int sENum_ = 0;
        private List<String> sEResult_ = Collections.emptyList();
        private int cachedSize = -1;

        public static Psrs parseFrom(b bVar) throws IOException {
            return new Psrs().mergeFrom(bVar);
        }

        public Psrs addSEResult(String str) {
            str.getClass();
            if (this.sEResult_.isEmpty()) {
                this.sEResult_ = new ArrayList();
            }
            this.sEResult_.add(str);
            return this;
        }

        public final Psrs clear() {
            clearSENum();
            clearSEResult();
            this.cachedSize = -1;
            return this;
        }

        public Psrs clearSENum() {
            this.hasSENum = false;
            this.sENum_ = 0;
            return this;
        }

        public Psrs clearSEResult() {
            this.sEResult_ = Collections.emptyList();
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public int getSENum() {
            return this.sENum_;
        }

        public String getSEResult(int i4) {
            return this.sEResult_.get(i4);
        }

        public int getSEResultCount() {
            return this.sEResult_.size();
        }

        public List<String> getSEResultList() {
            return this.sEResult_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iM = 0;
            int iE = hasSENum() ? d.e(1, getSENum()) : 0;
            Iterator<String> it = getSEResultList().iterator();
            while (it.hasNext()) {
                iM += d.m(it.next());
            }
            int size = getSEResultList().size() + iE + iM;
            this.cachedSize = size;
            return size;
        }

        public boolean hasSENum() {
            return this.hasSENum;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Psrs setSENum(int i4) {
            this.hasSENum = true;
            this.sENum_ = i4;
            return this;
        }

        public Psrs setSEResult(int i4, String str) {
            str.getClass();
            this.sEResult_.set(i4, str);
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasSENum()) {
                dVar.s(1, getSENum());
            }
            Iterator<String> it = getSEResultList().iterator();
            while (it.hasNext()) {
                dVar.A(2, it.next());
            }
        }

        public static Psrs parseFrom(byte[] bArr) throws e {
            return (Psrs) new Psrs().mergeFrom(bArr);
        }

        @Override // L1.f
        public Psrs mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 8) {
                    setSENum(bVar.k());
                } else if (iO == 18) {
                    addSEResult(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class Recommend extends f {
        public static final int REC_CONTENTS_FIELD_NUMBER = 1;
        public static final int TITLE_FIELD_NUMBER = 2;
        private boolean hasTitle;
        private List<RecContents> recContents_ = Collections.emptyList();
        private String title_ = "";
        private int cachedSize = -1;

        public static final class RecContents extends f {
            public static final int CLOUD_TEMPLATE_FIELD_NUMBER = 3;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int UID_FIELD_NUMBER = 1;
            private boolean hasCloudTemplate;
            private boolean hasName;
            private boolean hasUid;
            private String uid_ = "";
            private String name_ = "";
            private a cloudTemplate_ = a.f1216c;
            private int cachedSize = -1;

            public static RecContents parseFrom(b bVar) throws IOException {
                return new RecContents().mergeFrom(bVar);
            }

            public final RecContents clear() {
                clearUid();
                clearName();
                clearCloudTemplate();
                this.cachedSize = -1;
                return this;
            }

            public RecContents clearCloudTemplate() {
                this.hasCloudTemplate = false;
                this.cloudTemplate_ = a.f1216c;
                return this;
            }

            public RecContents clearName() {
                this.hasName = false;
                this.name_ = "";
                return this;
            }

            public RecContents clearUid() {
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

            public a getCloudTemplate() {
                return this.cloudTemplate_;
            }

            public String getName() {
                return this.name_;
            }

            @Override // L1.f
            public int getSerializedSize() {
                int iL = hasUid() ? d.l(1, getUid()) : 0;
                if (hasName()) {
                    iL += d.l(2, getName());
                }
                if (hasCloudTemplate()) {
                    iL += d.b(3, getCloudTemplate());
                }
                this.cachedSize = iL;
                return iL;
            }

            public String getUid() {
                return this.uid_;
            }

            public boolean hasCloudTemplate() {
                return this.hasCloudTemplate;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public final boolean isInitialized() {
                return true;
            }

            public RecContents setCloudTemplate(a aVar) {
                this.hasCloudTemplate = true;
                this.cloudTemplate_ = aVar;
                return this;
            }

            public RecContents setName(String str) {
                this.hasName = true;
                this.name_ = str;
                return this;
            }

            public RecContents setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            @Override // L1.f
            public void writeTo(d dVar) throws IOException {
                if (hasUid()) {
                    dVar.A(1, getUid());
                }
                if (hasName()) {
                    dVar.A(2, getName());
                }
                if (hasCloudTemplate()) {
                    dVar.q(3, getCloudTemplate());
                }
            }

            public static RecContents parseFrom(byte[] bArr) throws e {
                return (RecContents) new RecContents().mergeFrom(bArr);
            }

            @Override // L1.f
            public RecContents mergeFrom(b bVar) throws IOException {
                while (true) {
                    int iO = bVar.o();
                    if (iO == 0) {
                        return this;
                    }
                    if (iO == 10) {
                        setUid(bVar.n());
                    } else if (iO == 18) {
                        setName(bVar.n());
                    } else if (iO == 26) {
                        setCloudTemplate(bVar.b());
                    } else if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                }
            }
        }

        public static Recommend parseFrom(b bVar) throws IOException {
            return new Recommend().mergeFrom(bVar);
        }

        public Recommend addRecContents(RecContents recContents) {
            if (recContents == null) {
                return this;
            }
            if (this.recContents_.isEmpty()) {
                this.recContents_ = new ArrayList();
            }
            this.recContents_.add(recContents);
            return this;
        }

        public final Recommend clear() {
            clearRecContents();
            clearTitle();
            this.cachedSize = -1;
            return this;
        }

        public Recommend clearRecContents() {
            this.recContents_ = Collections.emptyList();
            return this;
        }

        public Recommend clearTitle() {
            this.hasTitle = false;
            this.title_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public RecContents getRecContents(int i4) {
            return this.recContents_.get(i4);
        }

        public int getRecContentsCount() {
            return this.recContents_.size();
        }

        public List<RecContents> getRecContentsList() {
            return this.recContents_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            Iterator<RecContents> it = getRecContentsList().iterator();
            int iL = 0;
            while (it.hasNext()) {
                iL += d.h(1, it.next());
            }
            if (hasTitle()) {
                iL += d.l(2, getTitle());
            }
            this.cachedSize = iL;
            return iL;
        }

        public String getTitle() {
            return this.title_;
        }

        public boolean hasTitle() {
            return this.hasTitle;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Recommend setRecContents(int i4, RecContents recContents) {
            if (recContents == null) {
                return this;
            }
            this.recContents_.set(i4, recContents);
            return this;
        }

        public Recommend setTitle(String str) {
            this.hasTitle = true;
            this.title_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            Iterator<RecContents> it = getRecContentsList().iterator();
            while (it.hasNext()) {
                dVar.u(1, it.next());
            }
            if (hasTitle()) {
                dVar.A(2, getTitle());
            }
        }

        public static Recommend parseFrom(byte[] bArr) throws e {
            return (Recommend) new Recommend().mergeFrom(bArr);
        }

        @Override // L1.f
        public Recommend mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    RecContents recContents = new RecContents();
                    bVar.f(recContents);
                    addRecContents(recContents);
                } else if (iO == 18) {
                    setTitle(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class ShareInfo extends f {
        public static final int CONTENT_FIELD_NUMBER = 3;
        public static final int QUERY_FIELD_NUMBER = 1;
        public static final int TIPS_FIELD_NUMBER = 2;
        public static final int URL_FIELD_NUMBER = 4;
        private boolean hasContent;
        private boolean hasQuery;
        private boolean hasTips;
        private boolean hasUrl;
        private String query_ = "";
        private String tips_ = "";
        private String content_ = "";
        private String url_ = "";
        private int cachedSize = -1;

        public static ShareInfo parseFrom(b bVar) throws IOException {
            return new ShareInfo().mergeFrom(bVar);
        }

        public final ShareInfo clear() {
            clearQuery();
            clearTips();
            clearContent();
            clearUrl();
            this.cachedSize = -1;
            return this;
        }

        public ShareInfo clearContent() {
            this.hasContent = false;
            this.content_ = "";
            return this;
        }

        public ShareInfo clearQuery() {
            this.hasQuery = false;
            this.query_ = "";
            return this;
        }

        public ShareInfo clearTips() {
            this.hasTips = false;
            this.tips_ = "";
            return this;
        }

        public ShareInfo clearUrl() {
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

        public String getContent() {
            return this.content_;
        }

        public String getQuery() {
            return this.query_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasQuery() ? d.l(1, getQuery()) : 0;
            if (hasTips()) {
                iL += d.l(2, getTips());
            }
            if (hasContent()) {
                iL += d.l(3, getContent());
            }
            if (hasUrl()) {
                iL += d.l(4, getUrl());
            }
            this.cachedSize = iL;
            return iL;
        }

        public String getTips() {
            return this.tips_;
        }

        public String getUrl() {
            return this.url_;
        }

        public boolean hasContent() {
            return this.hasContent;
        }

        public boolean hasQuery() {
            return this.hasQuery;
        }

        public boolean hasTips() {
            return this.hasTips;
        }

        public boolean hasUrl() {
            return this.hasUrl;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ShareInfo setContent(String str) {
            this.hasContent = true;
            this.content_ = str;
            return this;
        }

        public ShareInfo setQuery(String str) {
            this.hasQuery = true;
            this.query_ = str;
            return this;
        }

        public ShareInfo setTips(String str) {
            this.hasTips = true;
            this.tips_ = str;
            return this;
        }

        public ShareInfo setUrl(String str) {
            this.hasUrl = true;
            this.url_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasQuery()) {
                dVar.A(1, getQuery());
            }
            if (hasTips()) {
                dVar.A(2, getTips());
            }
            if (hasContent()) {
                dVar.A(3, getContent());
            }
            if (hasUrl()) {
                dVar.A(4, getUrl());
            }
        }

        public static ShareInfo parseFrom(byte[] bArr) throws e {
            return (ShareInfo) new ShareInfo().mergeFrom(bArr);
        }

        @Override // L1.f
        public ShareInfo mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setQuery(bVar.n());
                } else if (iO == 18) {
                    setTips(bVar.n());
                } else if (iO == 26) {
                    setContent(bVar.n());
                } else if (iO == 34) {
                    setUrl(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class StreetImg extends f {
        public static final int ICON_URL_FIELD_NUMBER = 2;
        public static final int JUMP_URL_FIELD_NUMBER = 4;
        public static final int LABEL_URL_FIELD_NUMBER = 3;
        public static final int LINK_FIELD_NUMBER = 1;
        private boolean hasIconUrl;
        private boolean hasJumpUrl;
        private boolean hasLabelUrl;
        private boolean hasLink;
        private String link_ = "";
        private String iconUrl_ = "";
        private String labelUrl_ = "";
        private String jumpUrl_ = "";
        private int cachedSize = -1;

        public static StreetImg parseFrom(b bVar) throws IOException {
            return new StreetImg().mergeFrom(bVar);
        }

        public final StreetImg clear() {
            clearLink();
            clearIconUrl();
            clearLabelUrl();
            clearJumpUrl();
            this.cachedSize = -1;
            return this;
        }

        public StreetImg clearIconUrl() {
            this.hasIconUrl = false;
            this.iconUrl_ = "";
            return this;
        }

        public StreetImg clearJumpUrl() {
            this.hasJumpUrl = false;
            this.jumpUrl_ = "";
            return this;
        }

        public StreetImg clearLabelUrl() {
            this.hasLabelUrl = false;
            this.labelUrl_ = "";
            return this;
        }

        public StreetImg clearLink() {
            this.hasLink = false;
            this.link_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getIconUrl() {
            return this.iconUrl_;
        }

        public String getJumpUrl() {
            return this.jumpUrl_;
        }

        public String getLabelUrl() {
            return this.labelUrl_;
        }

        public String getLink() {
            return this.link_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasLink() ? d.l(1, getLink()) : 0;
            if (hasIconUrl()) {
                iL += d.l(2, getIconUrl());
            }
            if (hasLabelUrl()) {
                iL += d.l(3, getLabelUrl());
            }
            if (hasJumpUrl()) {
                iL += d.l(4, getJumpUrl());
            }
            this.cachedSize = iL;
            return iL;
        }

        public boolean hasIconUrl() {
            return this.hasIconUrl;
        }

        public boolean hasJumpUrl() {
            return this.hasJumpUrl;
        }

        public boolean hasLabelUrl() {
            return this.hasLabelUrl;
        }

        public boolean hasLink() {
            return this.hasLink;
        }

        public final boolean isInitialized() {
            return true;
        }

        public StreetImg setIconUrl(String str) {
            this.hasIconUrl = true;
            this.iconUrl_ = str;
            return this;
        }

        public StreetImg setJumpUrl(String str) {
            this.hasJumpUrl = true;
            this.jumpUrl_ = str;
            return this;
        }

        public StreetImg setLabelUrl(String str) {
            this.hasLabelUrl = true;
            this.labelUrl_ = str;
            return this;
        }

        public StreetImg setLink(String str) {
            this.hasLink = true;
            this.link_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasLink()) {
                dVar.A(1, getLink());
            }
            if (hasIconUrl()) {
                dVar.A(2, getIconUrl());
            }
            if (hasLabelUrl()) {
                dVar.A(3, getLabelUrl());
            }
            if (hasJumpUrl()) {
                dVar.A(4, getJumpUrl());
            }
        }

        public static StreetImg parseFrom(byte[] bArr) throws e {
            return (StreetImg) new StreetImg().mergeFrom(bArr);
        }

        @Override // L1.f
        public StreetImg mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setLink(bVar.n());
                } else if (iO == 18) {
                    setIconUrl(bVar.n());
                } else if (iO == 26) {
                    setLabelUrl(bVar.n());
                } else if (iO == 34) {
                    setJumpUrl(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class SugRecInteractiveInfo extends f {
        public static final int NUM_FIELD_NUMBER = 2;
        public static final int STATUS_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;
        private boolean hasNum;
        private boolean hasStatus;
        private boolean hasType;
        private String type_ = "";
        private int num_ = 0;
        private int status_ = 0;
        private int cachedSize = -1;

        public static SugRecInteractiveInfo parseFrom(b bVar) throws IOException {
            return new SugRecInteractiveInfo().mergeFrom(bVar);
        }

        public final SugRecInteractiveInfo clear() {
            clearType();
            clearNum();
            clearStatus();
            this.cachedSize = -1;
            return this;
        }

        public SugRecInteractiveInfo clearNum() {
            this.hasNum = false;
            this.num_ = 0;
            return this;
        }

        public SugRecInteractiveInfo clearStatus() {
            this.hasStatus = false;
            this.status_ = 0;
            return this;
        }

        public SugRecInteractiveInfo clearType() {
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

        public int getNum() {
            return this.num_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasType() ? d.l(1, getType()) : 0;
            if (hasNum()) {
                iL += d.e(2, getNum());
            }
            if (hasStatus()) {
                iL += d.e(3, getStatus());
            }
            this.cachedSize = iL;
            return iL;
        }

        public int getStatus() {
            return this.status_;
        }

        public String getType() {
            return this.type_;
        }

        public boolean hasNum() {
            return this.hasNum;
        }

        public boolean hasStatus() {
            return this.hasStatus;
        }

        public boolean hasType() {
            return this.hasType;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SugRecInteractiveInfo setNum(int i4) {
            this.hasNum = true;
            this.num_ = i4;
            return this;
        }

        public SugRecInteractiveInfo setStatus(int i4) {
            this.hasStatus = true;
            this.status_ = i4;
            return this;
        }

        public SugRecInteractiveInfo setType(String str) {
            this.hasType = true;
            this.type_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasType()) {
                dVar.A(1, getType());
            }
            if (hasNum()) {
                dVar.s(2, getNum());
            }
            if (hasStatus()) {
                dVar.s(3, getStatus());
            }
        }

        public static SugRecInteractiveInfo parseFrom(byte[] bArr) throws e {
            return (SugRecInteractiveInfo) new SugRecInteractiveInfo().mergeFrom(bArr);
        }

        @Override // L1.f
        public SugRecInteractiveInfo mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setType(bVar.n());
                } else if (iO == 16) {
                    setNum(bVar.k());
                } else if (iO == 24) {
                    setStatus(bVar.k());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class SugRecResult extends f {
        public static final int FAVORITE_FIELD_NUMBER = 5;
        public static final int FILTER_FIELD_NUMBER = 2;
        public static final int MYSTIQUE_DATA_FIELD_NUMBER = 3;
        public static final int SHARE_INFO_FIELD_NUMBER = 4;
        public static final int SUG_REC_INTERACTIVE_INFO_FIELD_NUMBER = 6;
        public static final int TIPS_FIELD_NUMBER = 1;
        private boolean hasFavorite;
        private boolean hasFilter;
        private boolean hasShareInfo;
        private boolean hasTips;
        private String tips_ = "";
        private String filter_ = "";
        private List<String> mystiqueData_ = Collections.emptyList();
        private ShareInfo shareInfo_ = null;
        private String favorite_ = "";
        private List<SugRecInteractiveInfo> sugRecInteractiveInfo_ = Collections.emptyList();
        private int cachedSize = -1;

        public static SugRecResult parseFrom(b bVar) throws IOException {
            return new SugRecResult().mergeFrom(bVar);
        }

        public SugRecResult addMystiqueData(String str) {
            str.getClass();
            if (this.mystiqueData_.isEmpty()) {
                this.mystiqueData_ = new ArrayList();
            }
            this.mystiqueData_.add(str);
            return this;
        }

        public SugRecResult addSugRecInteractiveInfo(SugRecInteractiveInfo sugRecInteractiveInfo) {
            if (sugRecInteractiveInfo == null) {
                return this;
            }
            if (this.sugRecInteractiveInfo_.isEmpty()) {
                this.sugRecInteractiveInfo_ = new ArrayList();
            }
            this.sugRecInteractiveInfo_.add(sugRecInteractiveInfo);
            return this;
        }

        public final SugRecResult clear() {
            clearTips();
            clearFilter();
            clearMystiqueData();
            clearShareInfo();
            clearFavorite();
            clearSugRecInteractiveInfo();
            this.cachedSize = -1;
            return this;
        }

        public SugRecResult clearFavorite() {
            this.hasFavorite = false;
            this.favorite_ = "";
            return this;
        }

        public SugRecResult clearFilter() {
            this.hasFilter = false;
            this.filter_ = "";
            return this;
        }

        public SugRecResult clearMystiqueData() {
            this.mystiqueData_ = Collections.emptyList();
            return this;
        }

        public SugRecResult clearShareInfo() {
            this.hasShareInfo = false;
            this.shareInfo_ = null;
            return this;
        }

        public SugRecResult clearSugRecInteractiveInfo() {
            this.sugRecInteractiveInfo_ = Collections.emptyList();
            return this;
        }

        public SugRecResult clearTips() {
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

        public String getFavorite() {
            return this.favorite_;
        }

        public String getFilter() {
            return this.filter_;
        }

        public String getMystiqueData(int i4) {
            return this.mystiqueData_.get(i4);
        }

        public int getMystiqueDataCount() {
            return this.mystiqueData_.size();
        }

        public List<String> getMystiqueDataList() {
            return this.mystiqueData_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iM = 0;
            int iL = hasTips() ? d.l(1, getTips()) : 0;
            if (hasFilter()) {
                iL += d.l(2, getFilter());
            }
            Iterator<String> it = getMystiqueDataList().iterator();
            while (it.hasNext()) {
                iM += d.m(it.next());
            }
            int size = getMystiqueDataList().size() + iL + iM;
            if (hasShareInfo()) {
                size += d.h(4, getShareInfo());
            }
            if (hasFavorite()) {
                size += d.l(5, getFavorite());
            }
            Iterator<SugRecInteractiveInfo> it2 = getSugRecInteractiveInfoList().iterator();
            while (it2.hasNext()) {
                size += d.h(6, it2.next());
            }
            this.cachedSize = size;
            return size;
        }

        public ShareInfo getShareInfo() {
            return this.shareInfo_;
        }

        public SugRecInteractiveInfo getSugRecInteractiveInfo(int i4) {
            return this.sugRecInteractiveInfo_.get(i4);
        }

        public int getSugRecInteractiveInfoCount() {
            return this.sugRecInteractiveInfo_.size();
        }

        public List<SugRecInteractiveInfo> getSugRecInteractiveInfoList() {
            return this.sugRecInteractiveInfo_;
        }

        public String getTips() {
            return this.tips_;
        }

        public boolean hasFavorite() {
            return this.hasFavorite;
        }

        public boolean hasFilter() {
            return this.hasFilter;
        }

        public boolean hasShareInfo() {
            return this.hasShareInfo;
        }

        public boolean hasTips() {
            return this.hasTips;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SugRecResult setFavorite(String str) {
            this.hasFavorite = true;
            this.favorite_ = str;
            return this;
        }

        public SugRecResult setFilter(String str) {
            this.hasFilter = true;
            this.filter_ = str;
            return this;
        }

        public SugRecResult setMystiqueData(int i4, String str) {
            str.getClass();
            this.mystiqueData_.set(i4, str);
            return this;
        }

        public SugRecResult setShareInfo(ShareInfo shareInfo) {
            if (shareInfo == null) {
                return clearShareInfo();
            }
            this.hasShareInfo = true;
            this.shareInfo_ = shareInfo;
            return this;
        }

        public SugRecResult setSugRecInteractiveInfo(int i4, SugRecInteractiveInfo sugRecInteractiveInfo) {
            if (sugRecInteractiveInfo == null) {
                return this;
            }
            this.sugRecInteractiveInfo_.set(i4, sugRecInteractiveInfo);
            return this;
        }

        public SugRecResult setTips(String str) {
            this.hasTips = true;
            this.tips_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasTips()) {
                dVar.A(1, getTips());
            }
            if (hasFilter()) {
                dVar.A(2, getFilter());
            }
            Iterator<String> it = getMystiqueDataList().iterator();
            while (it.hasNext()) {
                dVar.A(3, it.next());
            }
            if (hasShareInfo()) {
                dVar.u(4, getShareInfo());
            }
            if (hasFavorite()) {
                dVar.A(5, getFavorite());
            }
            Iterator<SugRecInteractiveInfo> it2 = getSugRecInteractiveInfoList().iterator();
            while (it2.hasNext()) {
                dVar.u(6, it2.next());
            }
        }

        public static SugRecResult parseFrom(byte[] bArr) throws e {
            return (SugRecResult) new SugRecResult().mergeFrom(bArr);
        }

        @Override // L1.f
        public SugRecResult mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setTips(bVar.n());
                } else if (iO == 18) {
                    setFilter(bVar.n());
                } else if (iO == 26) {
                    addMystiqueData(bVar.n());
                } else if (iO == 34) {
                    ShareInfo shareInfo = new ShareInfo();
                    bVar.f(shareInfo);
                    setShareInfo(shareInfo);
                } else if (iO == 42) {
                    setFavorite(bVar.n());
                } else if (iO == 50) {
                    SugRecInteractiveInfo sugRecInteractiveInfo = new SugRecInteractiveInfo();
                    bVar.f(sugRecInteractiveInfo);
                    addSugRecInteractiveInfo(sugRecInteractiveInfo);
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

    public static final class TalosData extends f {
        public static final int BIZPARAMS_FIELD_NUMBER = 4;
        public static final int LIST_DATA_FIELD_NUMBER = 1;
        public static final int MAIN_BIZ_NAME_FIELD_NUMBER = 2;
        public static final int MODULE_NAME_FIELD_NUMBER = 3;
        private boolean hasBizparams;
        private boolean hasListData;
        private boolean hasMainBizName;
        private boolean hasModuleName;
        private String listData_ = "";
        private String mainBizName_ = "";
        private String moduleName_ = "";
        private String bizparams_ = "";
        private int cachedSize = -1;

        public static TalosData parseFrom(b bVar) throws IOException {
            return new TalosData().mergeFrom(bVar);
        }

        public final TalosData clear() {
            clearListData();
            clearMainBizName();
            clearModuleName();
            clearBizparams();
            this.cachedSize = -1;
            return this;
        }

        public TalosData clearBizparams() {
            this.hasBizparams = false;
            this.bizparams_ = "";
            return this;
        }

        public TalosData clearListData() {
            this.hasListData = false;
            this.listData_ = "";
            return this;
        }

        public TalosData clearMainBizName() {
            this.hasMainBizName = false;
            this.mainBizName_ = "";
            return this;
        }

        public TalosData clearModuleName() {
            this.hasModuleName = false;
            this.moduleName_ = "";
            return this;
        }

        public String getBizparams() {
            return this.bizparams_;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getListData() {
            return this.listData_;
        }

        public String getMainBizName() {
            return this.mainBizName_;
        }

        public String getModuleName() {
            return this.moduleName_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasListData() ? d.l(1, getListData()) : 0;
            if (hasMainBizName()) {
                iL += d.l(2, getMainBizName());
            }
            if (hasModuleName()) {
                iL += d.l(3, getModuleName());
            }
            if (hasBizparams()) {
                iL += d.l(4, getBizparams());
            }
            this.cachedSize = iL;
            return iL;
        }

        public boolean hasBizparams() {
            return this.hasBizparams;
        }

        public boolean hasListData() {
            return this.hasListData;
        }

        public boolean hasMainBizName() {
            return this.hasMainBizName;
        }

        public boolean hasModuleName() {
            return this.hasModuleName;
        }

        public final boolean isInitialized() {
            return true;
        }

        public TalosData setBizparams(String str) {
            this.hasBizparams = true;
            this.bizparams_ = str;
            return this;
        }

        public TalosData setListData(String str) {
            this.hasListData = true;
            this.listData_ = str;
            return this;
        }

        public TalosData setMainBizName(String str) {
            this.hasMainBizName = true;
            this.mainBizName_ = str;
            return this;
        }

        public TalosData setModuleName(String str) {
            this.hasModuleName = true;
            this.moduleName_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasListData()) {
                dVar.A(1, getListData());
            }
            if (hasMainBizName()) {
                dVar.A(2, getMainBizName());
            }
            if (hasModuleName()) {
                dVar.A(3, getModuleName());
            }
            if (hasBizparams()) {
                dVar.A(4, getBizparams());
            }
        }

        public static TalosData parseFrom(byte[] bArr) throws e {
            return (TalosData) new TalosData().mergeFrom(bArr);
        }

        @Override // L1.f
        public TalosData mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setListData(bVar.n());
                } else if (iO == 18) {
                    setMainBizName(bVar.n());
                } else if (iO == 26) {
                    setModuleName(bVar.n());
                } else if (iO == 34) {
                    setBizparams(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class ThirdParty extends f {
        public static final int FROM_FIELD_NUMBER = 5;
        public static final int NAME_FIELD_NUMBER = 4;
        public static final int NEED_GEO_FIELD_NUMBER = 3;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private boolean hasFrom;
        private boolean hasName;
        private boolean hasNeedGeo;
        private boolean hasX;
        private boolean hasY;
        private String x_ = "";
        private String y_ = "";
        private boolean needGeo_ = false;
        private String name_ = "";
        private String from_ = "";
        private int cachedSize = -1;

        public static ThirdParty parseFrom(b bVar) throws IOException {
            return new ThirdParty().mergeFrom(bVar);
        }

        public final ThirdParty clear() {
            clearX();
            clearY();
            clearNeedGeo();
            clearName();
            clearFrom();
            this.cachedSize = -1;
            return this;
        }

        public ThirdParty clearFrom() {
            this.hasFrom = false;
            this.from_ = "";
            return this;
        }

        public ThirdParty clearName() {
            this.hasName = false;
            this.name_ = "";
            return this;
        }

        public ThirdParty clearNeedGeo() {
            this.hasNeedGeo = false;
            this.needGeo_ = false;
            return this;
        }

        public ThirdParty clearX() {
            this.hasX = false;
            this.x_ = "";
            return this;
        }

        public ThirdParty clearY() {
            this.hasY = false;
            this.y_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getFrom() {
            return this.from_;
        }

        public String getName() {
            return this.name_;
        }

        public boolean getNeedGeo() {
            return this.needGeo_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iL = hasX() ? d.l(1, getX()) : 0;
            if (hasY()) {
                iL += d.l(2, getY());
            }
            if (hasNeedGeo()) {
                getNeedGeo();
                iL += d.a(3);
            }
            if (hasName()) {
                iL += d.l(4, getName());
            }
            if (hasFrom()) {
                iL += d.l(5, getFrom());
            }
            this.cachedSize = iL;
            return iL;
        }

        public String getX() {
            return this.x_;
        }

        public String getY() {
            return this.y_;
        }

        public boolean hasFrom() {
            return this.hasFrom;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public boolean hasNeedGeo() {
            return this.hasNeedGeo;
        }

        public boolean hasX() {
            return this.hasX;
        }

        public boolean hasY() {
            return this.hasY;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ThirdParty setFrom(String str) {
            this.hasFrom = true;
            this.from_ = str;
            return this;
        }

        public ThirdParty setName(String str) {
            this.hasName = true;
            this.name_ = str;
            return this;
        }

        public ThirdParty setNeedGeo(boolean z4) {
            this.hasNeedGeo = true;
            this.needGeo_ = z4;
            return this;
        }

        public ThirdParty setX(String str) {
            this.hasX = true;
            this.x_ = str;
            return this;
        }

        public ThirdParty setY(String str) {
            this.hasY = true;
            this.y_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasX()) {
                dVar.A(1, getX());
            }
            if (hasY()) {
                dVar.A(2, getY());
            }
            if (hasNeedGeo()) {
                dVar.p(3, getNeedGeo());
            }
            if (hasName()) {
                dVar.A(4, getName());
            }
            if (hasFrom()) {
                dVar.A(5, getFrom());
            }
        }

        public static ThirdParty parseFrom(byte[] bArr) throws e {
            return (ThirdParty) new ThirdParty().mergeFrom(bArr);
        }

        @Override // L1.f
        public ThirdParty mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 10) {
                    setX(bVar.n());
                } else if (iO == 18) {
                    setY(bVar.n());
                } else if (iO == 24) {
                    setNeedGeo(bVar.a());
                } else if (iO == 34) {
                    setName(bVar.n());
                } else if (iO == 42) {
                    setFrom(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class VuiProcessData extends f {
        public static final int CHOOSETEMPLATE_FIELD_NUMBER = 5;
        public static final int DYN_REQUEST_FIELD_NUMBER = 1;
        public static final int DYN_RESPONSE_FIELD_NUMBER = 2;
        public static final int DYN_ZHANWEI_FIELD_NUMBER = 3;
        public static final int TRADE_FIELD_NUMBER = 4;
        private boolean hasChooseTemplate;
        private boolean hasDynRequest;
        private boolean hasDynResponse;
        private boolean hasTrade;
        private boolean dynRequest_ = false;
        private boolean dynResponse_ = false;
        private List<Integer> dynZhanwei_ = Collections.emptyList();
        private String trade_ = "";
        private String chooseTemplate_ = "";
        private int cachedSize = -1;

        public static VuiProcessData parseFrom(b bVar) throws IOException {
            return new VuiProcessData().mergeFrom(bVar);
        }

        public VuiProcessData addDynZhanwei(int i4) {
            if (this.dynZhanwei_.isEmpty()) {
                this.dynZhanwei_ = new ArrayList();
            }
            this.dynZhanwei_.add(Integer.valueOf(i4));
            return this;
        }

        public final VuiProcessData clear() {
            clearDynRequest();
            clearDynResponse();
            clearDynZhanwei();
            clearTrade();
            clearChooseTemplate();
            this.cachedSize = -1;
            return this;
        }

        public VuiProcessData clearChooseTemplate() {
            this.hasChooseTemplate = false;
            this.chooseTemplate_ = "";
            return this;
        }

        public VuiProcessData clearDynRequest() {
            this.hasDynRequest = false;
            this.dynRequest_ = false;
            return this;
        }

        public VuiProcessData clearDynResponse() {
            this.hasDynResponse = false;
            this.dynResponse_ = false;
            return this;
        }

        public VuiProcessData clearDynZhanwei() {
            this.dynZhanwei_ = Collections.emptyList();
            return this;
        }

        public VuiProcessData clearTrade() {
            this.hasTrade = false;
            this.trade_ = "";
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getChooseTemplate() {
            return this.chooseTemplate_;
        }

        public boolean getDynRequest() {
            return this.dynRequest_;
        }

        public boolean getDynResponse() {
            return this.dynResponse_;
        }

        public int getDynZhanwei(int i4) {
            return this.dynZhanwei_.get(i4).intValue();
        }

        public int getDynZhanweiCount() {
            return this.dynZhanwei_.size();
        }

        public List<Integer> getDynZhanweiList() {
            return this.dynZhanwei_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iA;
            int iF = 0;
            if (hasDynRequest()) {
                getDynRequest();
                iA = d.a(1);
            } else {
                iA = 0;
            }
            if (hasDynResponse()) {
                getDynResponse();
                iA += d.a(2);
            }
            Iterator<Integer> it = getDynZhanweiList().iterator();
            while (it.hasNext()) {
                iF += d.f(it.next().intValue());
            }
            int size = getDynZhanweiList().size() + iA + iF;
            if (hasTrade()) {
                size += d.l(4, getTrade());
            }
            if (hasChooseTemplate()) {
                size += d.l(5, getChooseTemplate());
            }
            this.cachedSize = size;
            return size;
        }

        public String getTrade() {
            return this.trade_;
        }

        public boolean hasChooseTemplate() {
            return this.hasChooseTemplate;
        }

        public boolean hasDynRequest() {
            return this.hasDynRequest;
        }

        public boolean hasDynResponse() {
            return this.hasDynResponse;
        }

        public boolean hasTrade() {
            return this.hasTrade;
        }

        public final boolean isInitialized() {
            return true;
        }

        public VuiProcessData setChooseTemplate(String str) {
            this.hasChooseTemplate = true;
            this.chooseTemplate_ = str;
            return this;
        }

        public VuiProcessData setDynRequest(boolean z4) {
            this.hasDynRequest = true;
            this.dynRequest_ = z4;
            return this;
        }

        public VuiProcessData setDynResponse(boolean z4) {
            this.hasDynResponse = true;
            this.dynResponse_ = z4;
            return this;
        }

        public VuiProcessData setDynZhanwei(int i4, int i5) {
            this.dynZhanwei_.set(i4, Integer.valueOf(i5));
            return this;
        }

        public VuiProcessData setTrade(String str) {
            this.hasTrade = true;
            this.trade_ = str;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasDynRequest()) {
                dVar.p(1, getDynRequest());
            }
            if (hasDynResponse()) {
                dVar.p(2, getDynResponse());
            }
            Iterator<Integer> it = getDynZhanweiList().iterator();
            while (it.hasNext()) {
                dVar.s(3, it.next().intValue());
            }
            if (hasTrade()) {
                dVar.A(4, getTrade());
            }
            if (hasChooseTemplate()) {
                dVar.A(5, getChooseTemplate());
            }
        }

        public static VuiProcessData parseFrom(byte[] bArr) throws e {
            return (VuiProcessData) new VuiProcessData().mergeFrom(bArr);
        }

        @Override // L1.f
        public VuiProcessData mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 8) {
                    setDynRequest(bVar.a());
                } else if (iO == 16) {
                    setDynResponse(bVar.a());
                } else if (iO == 24) {
                    addDynZhanwei(bVar.k());
                } else if (iO == 34) {
                    setTrade(bVar.n());
                } else if (iO == 42) {
                    setChooseTemplate(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static final class WidgetBar extends f {
        public static final int EXT_FIELD_NUMBER = 3;
        public static final int IS_SHOW_FIELD_NUMBER = 2;
        public static final int WIDGET_CARD_ID_FIELD_NUMBER = 1;
        private boolean hasExt;
        private boolean hasIsShow;
        private boolean hasWidgetCardId;
        private int widgetCardId_ = 0;
        private int isShow_ = 0;
        private String ext_ = "";
        private int cachedSize = -1;

        public static WidgetBar parseFrom(b bVar) throws IOException {
            return new WidgetBar().mergeFrom(bVar);
        }

        public final WidgetBar clear() {
            clearWidgetCardId();
            clearIsShow();
            clearExt();
            this.cachedSize = -1;
            return this;
        }

        public WidgetBar clearExt() {
            this.hasExt = false;
            this.ext_ = "";
            return this;
        }

        public WidgetBar clearIsShow() {
            this.hasIsShow = false;
            this.isShow_ = 0;
            return this;
        }

        public WidgetBar clearWidgetCardId() {
            this.hasWidgetCardId = false;
            this.widgetCardId_ = 0;
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getExt() {
            return this.ext_;
        }

        public int getIsShow() {
            return this.isShow_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iE = hasWidgetCardId() ? d.e(1, getWidgetCardId()) : 0;
            if (hasIsShow()) {
                iE += d.e(2, getIsShow());
            }
            if (hasExt()) {
                iE += d.l(3, getExt());
            }
            this.cachedSize = iE;
            return iE;
        }

        public int getWidgetCardId() {
            return this.widgetCardId_;
        }

        public boolean hasExt() {
            return this.hasExt;
        }

        public boolean hasIsShow() {
            return this.hasIsShow;
        }

        public boolean hasWidgetCardId() {
            return this.hasWidgetCardId;
        }

        public final boolean isInitialized() {
            return true;
        }

        public WidgetBar setExt(String str) {
            this.hasExt = true;
            this.ext_ = str;
            return this;
        }

        public WidgetBar setIsShow(int i4) {
            this.hasIsShow = true;
            this.isShow_ = i4;
            return this;
        }

        public WidgetBar setWidgetCardId(int i4) {
            this.hasWidgetCardId = true;
            this.widgetCardId_ = i4;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasWidgetCardId()) {
                dVar.s(1, getWidgetCardId());
            }
            if (hasIsShow()) {
                dVar.s(2, getIsShow());
            }
            if (hasExt()) {
                dVar.A(3, getExt());
            }
        }

        public static WidgetBar parseFrom(byte[] bArr) throws e {
            return (WidgetBar) new WidgetBar().mergeFrom(bArr);
        }

        @Override // L1.f
        public WidgetBar mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 8) {
                    setWidgetCardId(bVar.k());
                } else if (iO == 16) {
                    setIsShow(bVar.k());
                } else if (iO == 26) {
                    setExt(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static PoiResult parseFrom(b bVar) throws IOException {
        return new PoiResult().mergeFrom(bVar);
    }

    public PoiResult addAddrs(Addrs addrs) {
        if (addrs == null) {
            return this;
        }
        if (this.addrs_.isEmpty()) {
            this.addrs_ = new ArrayList();
        }
        this.addrs_.add(addrs);
        return this;
    }

    public PoiResult addAds(Ads ads) {
        if (ads == null) {
            return this;
        }
        if (this.ads_.isEmpty()) {
            this.ads_ = new ArrayList();
        }
        this.ads_.add(ads);
        return this;
    }

    public PoiResult addChildren(Children children) {
        if (children == null) {
            return this;
        }
        if (this.children_.isEmpty()) {
            this.children_ = new ArrayList();
        }
        this.children_.add(children);
        return this;
    }

    public PoiResult addContents(Contents contents) {
        if (contents == null) {
            return this;
        }
        if (this.contents_.isEmpty()) {
            this.contents_ = new ArrayList();
        }
        this.contents_.add(contents);
        return this;
    }

    public PoiResult addFloatIcons(FloatIcon floatIcon) {
        if (floatIcon == null) {
            return this;
        }
        if (this.floatIcons_.isEmpty()) {
            this.floatIcons_ = new ArrayList();
        }
        this.floatIcons_.add(floatIcon);
        return this;
    }

    public PoiResult addGuideTag(GuideTag guideTag) {
        if (guideTag == null) {
            return this;
        }
        if (this.guideTag_.isEmpty()) {
            this.guideTag_ = new ArrayList();
        }
        this.guideTag_.add(guideTag);
        return this;
    }

    public PoiResult addGuildButton(GuildButton guildButton) {
        if (guildButton == null) {
            return this;
        }
        if (this.guildButton_.isEmpty()) {
            this.guildButton_ = new ArrayList();
        }
        this.guildButton_.add(guildButton);
        return this;
    }

    public PoiResult addMystiqueList(MystiqueList mystiqueList) {
        if (mystiqueList == null) {
            return this;
        }
        if (this.mystiqueList_.isEmpty()) {
            this.mystiqueList_ = new ArrayList();
        }
        this.mystiqueList_.add(mystiqueList);
        return this;
    }

    public PoiResult addSuggestQuery(SuggestQuery suggestQuery) {
        if (suggestQuery == null) {
            return this;
        }
        if (this.suggestQuery_.isEmpty()) {
            this.suggestQuery_ = new ArrayList();
        }
        this.suggestQuery_.add(suggestQuery);
        return this;
    }

    public final PoiResult clear() {
        clearOption();
        clearAddrs();
        clearPsrs();
        clearSuggestQuery();
        clearPlaceInfo();
        clearContents();
        clearChildren();
        clearPreviousCity();
        clearCurrentCity();
        clearBrandBar();
        clearImgeExt();
        clearOffline();
        clearGuideTag();
        clearAds();
        clearAdsExtInfo();
        clearIndusInfo();
        clearRecommend();
        clearCorrectionInfo();
        clearCarPreload();
        clearSpeechFinalWord();
        clearImgBanner();
        clearMystiqueList();
        clearSugRecRes();
        clearHorizonSlideResult();
        clearEmptyResultDynamicCard();
        clearFloatIcons();
        clearSearchBoxBgImg();
        clearPopupWindow();
        clearWidgetBar();
        clearListAdsData();
        clearTalosData();
        clearPreviewCacheKey();
        clearTalosBanner();
        clearGuildButton();
        this.cachedSize = -1;
        return this;
    }

    public PoiResult clearAddrs() {
        this.addrs_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearAds() {
        this.ads_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearAdsExtInfo() {
        this.hasAdsExtInfo = false;
        this.adsExtInfo_ = null;
        return this;
    }

    public PoiResult clearBrandBar() {
        this.hasBrandBar = false;
        this.brandBar_ = null;
        return this;
    }

    public PoiResult clearCarPreload() {
        this.hasCarPreload = false;
        this.carPreload_ = 0;
        return this;
    }

    public PoiResult clearChildren() {
        this.children_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearContents() {
        this.contents_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearCorrectionInfo() {
        this.hasCorrectionInfo = false;
        this.correctionInfo_ = null;
        return this;
    }

    public PoiResult clearCurrentCity() {
        this.hasCurrentCity = false;
        this.currentCity_ = null;
        return this;
    }

    public PoiResult clearEmptyResultDynamicCard() {
        this.hasEmptyResultDynamicCard = false;
        this.emptyResultDynamicCard_ = "";
        return this;
    }

    public PoiResult clearFloatIcons() {
        this.floatIcons_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearGuideTag() {
        this.guideTag_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearGuildButton() {
        this.guildButton_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearHorizonSlideResult() {
        this.hasHorizonSlideResult = false;
        this.horizonSlideResult_ = null;
        return this;
    }

    public PoiResult clearImgBanner() {
        this.hasImgBanner = false;
        this.imgBanner_ = null;
        return this;
    }

    public PoiResult clearImgeExt() {
        this.hasImgeExt = false;
        this.imgeExt_ = a.f1216c;
        return this;
    }

    public PoiResult clearIndusInfo() {
        this.hasIndusInfo = false;
        this.indusInfo_ = null;
        return this;
    }

    public PoiResult clearListAdsData() {
        this.hasListAdsData = false;
        this.listAdsData_ = null;
        return this;
    }

    public PoiResult clearMystiqueList() {
        this.mystiqueList_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearOffline() {
        this.hasOffline = false;
        this.offline_ = 0;
        return this;
    }

    public PoiResult clearOption() {
        this.hasOption = false;
        this.option_ = null;
        return this;
    }

    public PoiResult clearPlaceInfo() {
        this.hasPlaceInfo = false;
        this.placeInfo_ = null;
        return this;
    }

    public PoiResult clearPopupWindow() {
        this.hasPopupWindow = false;
        this.popupWindow_ = "";
        return this;
    }

    public PoiResult clearPreviewCacheKey() {
        this.hasPreviewCacheKey = false;
        this.previewCacheKey_ = "";
        return this;
    }

    public PoiResult clearPreviousCity() {
        this.hasPreviousCity = false;
        this.previousCity_ = null;
        return this;
    }

    public PoiResult clearPsrs() {
        this.hasPsrs = false;
        this.psrs_ = null;
        return this;
    }

    public PoiResult clearRecommend() {
        this.hasRecommend = false;
        this.recommend_ = null;
        return this;
    }

    public PoiResult clearSearchBoxBgImg() {
        this.hasSearchBoxBgImg = false;
        this.searchBoxBgImg_ = "";
        return this;
    }

    public PoiResult clearSpeechFinalWord() {
        this.hasSpeechFinalWord = false;
        this.speechFinalWord_ = "";
        return this;
    }

    public PoiResult clearSugRecRes() {
        this.hasSugRecRes = false;
        this.sugRecRes_ = null;
        return this;
    }

    public PoiResult clearSuggestQuery() {
        this.suggestQuery_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearTalosBanner() {
        this.hasTalosBanner = false;
        this.talosBanner_ = "";
        return this;
    }

    public PoiResult clearTalosData() {
        this.hasTalosData = false;
        this.talosData_ = null;
        return this;
    }

    public PoiResult clearWidgetBar() {
        this.hasWidgetBar = false;
        this.widgetBar_ = null;
        return this;
    }

    public Addrs getAddrs(int i4) {
        return this.addrs_.get(i4);
    }

    public int getAddrsCount() {
        return this.addrs_.size();
    }

    public List<Addrs> getAddrsList() {
        return this.addrs_;
    }

    public Ads getAds(int i4) {
        return this.ads_.get(i4);
    }

    public int getAdsCount() {
        return this.ads_.size();
    }

    public AdsExtInfo getAdsExtInfo() {
        return this.adsExtInfo_;
    }

    public List<Ads> getAdsList() {
        return this.ads_;
    }

    public BrandBar getBrandBar() {
        return this.brandBar_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCarPreload() {
        return this.carPreload_;
    }

    public Children getChildren(int i4) {
        return this.children_.get(i4);
    }

    public int getChildrenCount() {
        return this.children_.size();
    }

    public List<Children> getChildrenList() {
        return this.children_;
    }

    public Contents getContents(int i4) {
        return this.contents_.get(i4);
    }

    public int getContentsCount() {
        return this.contents_.size();
    }

    public List<Contents> getContentsList() {
        return this.contents_;
    }

    public CorrectionInfo getCorrectionInfo() {
        return this.correctionInfo_;
    }

    public CurrentCity getCurrentCity() {
        return this.currentCity_;
    }

    public String getEmptyResultDynamicCard() {
        return this.emptyResultDynamicCard_;
    }

    public FloatIcon getFloatIcons(int i4) {
        return this.floatIcons_.get(i4);
    }

    public int getFloatIconsCount() {
        return this.floatIcons_.size();
    }

    public List<FloatIcon> getFloatIconsList() {
        return this.floatIcons_;
    }

    public GuideTag getGuideTag(int i4) {
        return this.guideTag_.get(i4);
    }

    public int getGuideTagCount() {
        return this.guideTag_.size();
    }

    public List<GuideTag> getGuideTagList() {
        return this.guideTag_;
    }

    public GuildButton getGuildButton(int i4) {
        return this.guildButton_.get(i4);
    }

    public int getGuildButtonCount() {
        return this.guildButton_.size();
    }

    public List<GuildButton> getGuildButtonList() {
        return this.guildButton_;
    }

    public HorizonSlideResult getHorizonSlideResult() {
        return this.horizonSlideResult_;
    }

    public ImgBanner getImgBanner() {
        return this.imgBanner_;
    }

    public a getImgeExt() {
        return this.imgeExt_;
    }

    public IndusInfo getIndusInfo() {
        return this.indusInfo_;
    }

    public ListAdsData getListAdsData() {
        return this.listAdsData_;
    }

    public MystiqueList getMystiqueList(int i4) {
        return this.mystiqueList_.get(i4);
    }

    public int getMystiqueListCount() {
        return this.mystiqueList_.size();
    }

    public List<MystiqueList> getMystiqueListList() {
        return this.mystiqueList_;
    }

    public int getOffline() {
        return this.offline_;
    }

    public Option getOption() {
        return this.option_;
    }

    public PlaceInfo getPlaceInfo() {
        return this.placeInfo_;
    }

    public String getPopupWindow() {
        return this.popupWindow_;
    }

    public String getPreviewCacheKey() {
        return this.previewCacheKey_;
    }

    public PreviousCity getPreviousCity() {
        return this.previousCity_;
    }

    public Psrs getPsrs() {
        return this.psrs_;
    }

    public Recommend getRecommend() {
        return this.recommend_;
    }

    public String getSearchBoxBgImg() {
        return this.searchBoxBgImg_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iH = hasOption() ? d.h(1, getOption()) : 0;
        Iterator<Addrs> it = getAddrsList().iterator();
        while (it.hasNext()) {
            iH += d.h(2, it.next());
        }
        if (hasPsrs()) {
            iH += d.h(3, getPsrs());
        }
        Iterator<SuggestQuery> it2 = getSuggestQueryList().iterator();
        while (it2.hasNext()) {
            iH += d.h(4, it2.next());
        }
        if (hasPlaceInfo()) {
            iH += d.h(5, getPlaceInfo());
        }
        Iterator<Contents> it3 = getContentsList().iterator();
        while (it3.hasNext()) {
            iH += d.h(6, it3.next());
        }
        if (hasCurrentCity()) {
            iH += d.h(7, getCurrentCity());
        }
        Iterator<Children> it4 = getChildrenList().iterator();
        while (it4.hasNext()) {
            iH += d.h(8, it4.next());
        }
        if (hasPreviousCity()) {
            iH += d.h(9, getPreviousCity());
        }
        if (hasBrandBar()) {
            iH += d.h(10, getBrandBar());
        }
        if (hasImgeExt()) {
            iH += d.b(11, getImgeExt());
        }
        if (hasOffline()) {
            iH += d.e(12, getOffline());
        }
        Iterator<GuideTag> it5 = getGuideTagList().iterator();
        while (it5.hasNext()) {
            iH += d.h(13, it5.next());
        }
        Iterator<Ads> it6 = getAdsList().iterator();
        while (it6.hasNext()) {
            iH += d.h(14, it6.next());
        }
        if (hasAdsExtInfo()) {
            iH += d.h(16, getAdsExtInfo());
        }
        if (hasIndusInfo()) {
            iH += d.h(18, getIndusInfo());
        }
        if (hasRecommend()) {
            iH += d.h(19, getRecommend());
        }
        if (hasCorrectionInfo()) {
            iH += d.h(20, getCorrectionInfo());
        }
        if (hasCarPreload()) {
            iH += d.e(21, getCarPreload());
        }
        if (hasSpeechFinalWord()) {
            iH += d.l(22, getSpeechFinalWord());
        }
        if (hasImgBanner()) {
            iH += d.h(23, getImgBanner());
        }
        Iterator<MystiqueList> it7 = getMystiqueListList().iterator();
        while (it7.hasNext()) {
            iH += d.h(24, it7.next());
        }
        if (hasSugRecRes()) {
            iH += d.h(25, getSugRecRes());
        }
        if (hasHorizonSlideResult()) {
            iH += d.h(26, getHorizonSlideResult());
        }
        if (hasEmptyResultDynamicCard()) {
            iH += d.l(27, getEmptyResultDynamicCard());
        }
        Iterator<FloatIcon> it8 = getFloatIconsList().iterator();
        while (it8.hasNext()) {
            iH += d.h(28, it8.next());
        }
        if (hasSearchBoxBgImg()) {
            iH += d.l(29, getSearchBoxBgImg());
        }
        if (hasPopupWindow()) {
            iH += d.l(30, getPopupWindow());
        }
        if (hasWidgetBar()) {
            iH += d.h(31, getWidgetBar());
        }
        if (hasListAdsData()) {
            iH += d.h(32, getListAdsData());
        }
        if (hasTalosData()) {
            iH += d.h(33, getTalosData());
        }
        if (hasPreviewCacheKey()) {
            iH += d.l(34, getPreviewCacheKey());
        }
        if (hasTalosBanner()) {
            iH += d.l(35, getTalosBanner());
        }
        Iterator<GuildButton> it9 = getGuildButtonList().iterator();
        while (it9.hasNext()) {
            iH += d.h(36, it9.next());
        }
        this.cachedSize = iH;
        return iH;
    }

    public String getSpeechFinalWord() {
        return this.speechFinalWord_;
    }

    public SugRecResult getSugRecRes() {
        return this.sugRecRes_;
    }

    public SuggestQuery getSuggestQuery(int i4) {
        return this.suggestQuery_.get(i4);
    }

    public int getSuggestQueryCount() {
        return this.suggestQuery_.size();
    }

    public List<SuggestQuery> getSuggestQueryList() {
        return this.suggestQuery_;
    }

    public String getTalosBanner() {
        return this.talosBanner_;
    }

    public TalosData getTalosData() {
        return this.talosData_;
    }

    public WidgetBar getWidgetBar() {
        return this.widgetBar_;
    }

    public boolean hasAdsExtInfo() {
        return this.hasAdsExtInfo;
    }

    public boolean hasBrandBar() {
        return this.hasBrandBar;
    }

    public boolean hasCarPreload() {
        return this.hasCarPreload;
    }

    public boolean hasCorrectionInfo() {
        return this.hasCorrectionInfo;
    }

    public boolean hasCurrentCity() {
        return this.hasCurrentCity;
    }

    public boolean hasEmptyResultDynamicCard() {
        return this.hasEmptyResultDynamicCard;
    }

    public boolean hasHorizonSlideResult() {
        return this.hasHorizonSlideResult;
    }

    public boolean hasImgBanner() {
        return this.hasImgBanner;
    }

    public boolean hasImgeExt() {
        return this.hasImgeExt;
    }

    public boolean hasIndusInfo() {
        return this.hasIndusInfo;
    }

    public boolean hasListAdsData() {
        return this.hasListAdsData;
    }

    public boolean hasOffline() {
        return this.hasOffline;
    }

    public boolean hasOption() {
        return this.hasOption;
    }

    public boolean hasPlaceInfo() {
        return this.hasPlaceInfo;
    }

    public boolean hasPopupWindow() {
        return this.hasPopupWindow;
    }

    public boolean hasPreviewCacheKey() {
        return this.hasPreviewCacheKey;
    }

    public boolean hasPreviousCity() {
        return this.hasPreviousCity;
    }

    public boolean hasPsrs() {
        return this.hasPsrs;
    }

    public boolean hasRecommend() {
        return this.hasRecommend;
    }

    public boolean hasSearchBoxBgImg() {
        return this.hasSearchBoxBgImg;
    }

    public boolean hasSpeechFinalWord() {
        return this.hasSpeechFinalWord;
    }

    public boolean hasSugRecRes() {
        return this.hasSugRecRes;
    }

    public boolean hasTalosBanner() {
        return this.hasTalosBanner;
    }

    public boolean hasTalosData() {
        return this.hasTalosData;
    }

    public boolean hasWidgetBar() {
        return this.hasWidgetBar;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult setAddrs(int i4, Addrs addrs) {
        if (addrs == null) {
            return this;
        }
        this.addrs_.set(i4, addrs);
        return this;
    }

    public PoiResult setAds(int i4, Ads ads) {
        if (ads == null) {
            return this;
        }
        this.ads_.set(i4, ads);
        return this;
    }

    public PoiResult setAdsExtInfo(AdsExtInfo adsExtInfo) {
        if (adsExtInfo == null) {
            return clearAdsExtInfo();
        }
        this.hasAdsExtInfo = true;
        this.adsExtInfo_ = adsExtInfo;
        return this;
    }

    public PoiResult setBrandBar(BrandBar brandBar) {
        if (brandBar == null) {
            return clearBrandBar();
        }
        this.hasBrandBar = true;
        this.brandBar_ = brandBar;
        return this;
    }

    public PoiResult setCarPreload(int i4) {
        this.hasCarPreload = true;
        this.carPreload_ = i4;
        return this;
    }

    public PoiResult setChildren(int i4, Children children) {
        if (children == null) {
            return this;
        }
        this.children_.set(i4, children);
        return this;
    }

    public PoiResult setContents(int i4, Contents contents) {
        if (contents == null) {
            return this;
        }
        this.contents_.set(i4, contents);
        return this;
    }

    public PoiResult setCorrectionInfo(CorrectionInfo correctionInfo) {
        if (correctionInfo == null) {
            return clearCorrectionInfo();
        }
        this.hasCorrectionInfo = true;
        this.correctionInfo_ = correctionInfo;
        return this;
    }

    public PoiResult setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.hasCurrentCity = true;
        this.currentCity_ = currentCity;
        return this;
    }

    public PoiResult setEmptyResultDynamicCard(String str) {
        this.hasEmptyResultDynamicCard = true;
        this.emptyResultDynamicCard_ = str;
        return this;
    }

    public PoiResult setFloatIcons(int i4, FloatIcon floatIcon) {
        if (floatIcon == null) {
            return this;
        }
        this.floatIcons_.set(i4, floatIcon);
        return this;
    }

    public PoiResult setGuideTag(int i4, GuideTag guideTag) {
        if (guideTag == null) {
            return this;
        }
        this.guideTag_.set(i4, guideTag);
        return this;
    }

    public PoiResult setGuildButton(int i4, GuildButton guildButton) {
        if (guildButton == null) {
            return this;
        }
        this.guildButton_.set(i4, guildButton);
        return this;
    }

    public PoiResult setHorizonSlideResult(HorizonSlideResult horizonSlideResult) {
        if (horizonSlideResult == null) {
            return clearHorizonSlideResult();
        }
        this.hasHorizonSlideResult = true;
        this.horizonSlideResult_ = horizonSlideResult;
        return this;
    }

    public PoiResult setImgBanner(ImgBanner imgBanner) {
        if (imgBanner == null) {
            return clearImgBanner();
        }
        this.hasImgBanner = true;
        this.imgBanner_ = imgBanner;
        return this;
    }

    public PoiResult setImgeExt(a aVar) {
        this.hasImgeExt = true;
        this.imgeExt_ = aVar;
        return this;
    }

    public PoiResult setIndusInfo(IndusInfo indusInfo) {
        if (indusInfo == null) {
            return clearIndusInfo();
        }
        this.hasIndusInfo = true;
        this.indusInfo_ = indusInfo;
        return this;
    }

    public PoiResult setListAdsData(ListAdsData listAdsData) {
        if (listAdsData == null) {
            return clearListAdsData();
        }
        this.hasListAdsData = true;
        this.listAdsData_ = listAdsData;
        return this;
    }

    public PoiResult setMystiqueList(int i4, MystiqueList mystiqueList) {
        if (mystiqueList == null) {
            return this;
        }
        this.mystiqueList_.set(i4, mystiqueList);
        return this;
    }

    public PoiResult setOffline(int i4) {
        this.hasOffline = true;
        this.offline_ = i4;
        return this;
    }

    public PoiResult setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.hasOption = true;
        this.option_ = option;
        return this;
    }

    public PoiResult setPlaceInfo(PlaceInfo placeInfo) {
        if (placeInfo == null) {
            return clearPlaceInfo();
        }
        this.hasPlaceInfo = true;
        this.placeInfo_ = placeInfo;
        return this;
    }

    public PoiResult setPopupWindow(String str) {
        this.hasPopupWindow = true;
        this.popupWindow_ = str;
        return this;
    }

    public PoiResult setPreviewCacheKey(String str) {
        this.hasPreviewCacheKey = true;
        this.previewCacheKey_ = str;
        return this;
    }

    public PoiResult setPreviousCity(PreviousCity previousCity) {
        if (previousCity == null) {
            return clearPreviousCity();
        }
        this.hasPreviousCity = true;
        this.previousCity_ = previousCity;
        return this;
    }

    public PoiResult setPsrs(Psrs psrs) {
        if (psrs == null) {
            return clearPsrs();
        }
        this.hasPsrs = true;
        this.psrs_ = psrs;
        return this;
    }

    public PoiResult setRecommend(Recommend recommend) {
        if (recommend == null) {
            return clearRecommend();
        }
        this.hasRecommend = true;
        this.recommend_ = recommend;
        return this;
    }

    public PoiResult setSearchBoxBgImg(String str) {
        this.hasSearchBoxBgImg = true;
        this.searchBoxBgImg_ = str;
        return this;
    }

    public PoiResult setSpeechFinalWord(String str) {
        this.hasSpeechFinalWord = true;
        this.speechFinalWord_ = str;
        return this;
    }

    public PoiResult setSugRecRes(SugRecResult sugRecResult) {
        if (sugRecResult == null) {
            return clearSugRecRes();
        }
        this.hasSugRecRes = true;
        this.sugRecRes_ = sugRecResult;
        return this;
    }

    public PoiResult setSuggestQuery(int i4, SuggestQuery suggestQuery) {
        if (suggestQuery == null) {
            return this;
        }
        this.suggestQuery_.set(i4, suggestQuery);
        return this;
    }

    public PoiResult setTalosBanner(String str) {
        this.hasTalosBanner = true;
        this.talosBanner_ = str;
        return this;
    }

    public PoiResult setTalosData(TalosData talosData) {
        if (talosData == null) {
            return clearTalosData();
        }
        this.hasTalosData = true;
        this.talosData_ = talosData;
        return this;
    }

    public PoiResult setWidgetBar(WidgetBar widgetBar) {
        if (widgetBar == null) {
            return clearWidgetBar();
        }
        this.hasWidgetBar = true;
        this.widgetBar_ = widgetBar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasOption()) {
            dVar.u(1, getOption());
        }
        Iterator<Addrs> it = getAddrsList().iterator();
        while (it.hasNext()) {
            dVar.u(2, it.next());
        }
        if (hasPsrs()) {
            dVar.u(3, getPsrs());
        }
        Iterator<SuggestQuery> it2 = getSuggestQueryList().iterator();
        while (it2.hasNext()) {
            dVar.u(4, it2.next());
        }
        if (hasPlaceInfo()) {
            dVar.u(5, getPlaceInfo());
        }
        Iterator<Contents> it3 = getContentsList().iterator();
        while (it3.hasNext()) {
            dVar.u(6, it3.next());
        }
        if (hasCurrentCity()) {
            dVar.u(7, getCurrentCity());
        }
        Iterator<Children> it4 = getChildrenList().iterator();
        while (it4.hasNext()) {
            dVar.u(8, it4.next());
        }
        if (hasPreviousCity()) {
            dVar.u(9, getPreviousCity());
        }
        if (hasBrandBar()) {
            dVar.u(10, getBrandBar());
        }
        if (hasImgeExt()) {
            dVar.q(11, getImgeExt());
        }
        if (hasOffline()) {
            dVar.s(12, getOffline());
        }
        Iterator<GuideTag> it5 = getGuideTagList().iterator();
        while (it5.hasNext()) {
            dVar.u(13, it5.next());
        }
        Iterator<Ads> it6 = getAdsList().iterator();
        while (it6.hasNext()) {
            dVar.u(14, it6.next());
        }
        if (hasAdsExtInfo()) {
            dVar.u(16, getAdsExtInfo());
        }
        if (hasIndusInfo()) {
            dVar.u(18, getIndusInfo());
        }
        if (hasRecommend()) {
            dVar.u(19, getRecommend());
        }
        if (hasCorrectionInfo()) {
            dVar.u(20, getCorrectionInfo());
        }
        if (hasCarPreload()) {
            dVar.s(21, getCarPreload());
        }
        if (hasSpeechFinalWord()) {
            dVar.A(22, getSpeechFinalWord());
        }
        if (hasImgBanner()) {
            dVar.u(23, getImgBanner());
        }
        Iterator<MystiqueList> it7 = getMystiqueListList().iterator();
        while (it7.hasNext()) {
            dVar.u(24, it7.next());
        }
        if (hasSugRecRes()) {
            dVar.u(25, getSugRecRes());
        }
        if (hasHorizonSlideResult()) {
            dVar.u(26, getHorizonSlideResult());
        }
        if (hasEmptyResultDynamicCard()) {
            dVar.A(27, getEmptyResultDynamicCard());
        }
        Iterator<FloatIcon> it8 = getFloatIconsList().iterator();
        while (it8.hasNext()) {
            dVar.u(28, it8.next());
        }
        if (hasSearchBoxBgImg()) {
            dVar.A(29, getSearchBoxBgImg());
        }
        if (hasPopupWindow()) {
            dVar.A(30, getPopupWindow());
        }
        if (hasWidgetBar()) {
            dVar.u(31, getWidgetBar());
        }
        if (hasListAdsData()) {
            dVar.u(32, getListAdsData());
        }
        if (hasTalosData()) {
            dVar.u(33, getTalosData());
        }
        if (hasPreviewCacheKey()) {
            dVar.A(34, getPreviewCacheKey());
        }
        if (hasTalosBanner()) {
            dVar.A(35, getTalosBanner());
        }
        Iterator<GuildButton> it9 = getGuildButtonList().iterator();
        while (it9.hasNext()) {
            dVar.u(36, it9.next());
        }
    }

    public static PoiResult parseFrom(byte[] bArr) throws e {
        return (PoiResult) new PoiResult().mergeFrom(bArr);
    }

    @Override // L1.f
    public PoiResult mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            switch (iO) {
                case 0:
                    return this;
                case 10:
                    Option option = new Option();
                    bVar.f(option);
                    setOption(option);
                    break;
                case 18:
                    Addrs addrs = new Addrs();
                    bVar.f(addrs);
                    addAddrs(addrs);
                    break;
                case 26:
                    Psrs psrs = new Psrs();
                    bVar.f(psrs);
                    setPsrs(psrs);
                    break;
                case 34:
                    SuggestQuery suggestQuery = new SuggestQuery();
                    bVar.f(suggestQuery);
                    addSuggestQuery(suggestQuery);
                    break;
                case 42:
                    PlaceInfo placeInfo = new PlaceInfo();
                    bVar.f(placeInfo);
                    setPlaceInfo(placeInfo);
                    break;
                case 50:
                    Contents contents = new Contents();
                    bVar.f(contents);
                    addContents(contents);
                    break;
                case 58:
                    CurrentCity currentCity = new CurrentCity();
                    bVar.f(currentCity);
                    setCurrentCity(currentCity);
                    break;
                case 66:
                    Children children = new Children();
                    bVar.f(children);
                    addChildren(children);
                    break;
                case Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                    PreviousCity previousCity = new PreviousCity();
                    bVar.f(previousCity);
                    setPreviousCity(previousCity);
                    break;
                case Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                    BrandBar brandBar = new BrandBar();
                    bVar.f(brandBar);
                    setBrandBar(brandBar);
                    break;
                case 90:
                    setImgeExt(bVar.b());
                    break;
                case 96:
                    setOffline(bVar.k());
                    break;
                case 106:
                    GuideTag guideTag = new GuideTag();
                    bVar.f(guideTag);
                    addGuideTag(guideTag);
                    break;
                case 114:
                    Ads ads = new Ads();
                    bVar.f(ads);
                    addAds(ads);
                    break;
                case 130:
                    AdsExtInfo adsExtInfo = new AdsExtInfo();
                    bVar.f(adsExtInfo);
                    setAdsExtInfo(adsExtInfo);
                    break;
                case 146:
                    IndusInfo indusInfo = new IndusInfo();
                    bVar.f(indusInfo);
                    setIndusInfo(indusInfo);
                    break;
                case Opcodes.IFNE /* 154 */:
                    Recommend recommend = new Recommend();
                    bVar.f(recommend);
                    setRecommend(recommend);
                    break;
                case 162:
                    CorrectionInfo correctionInfo = new CorrectionInfo();
                    bVar.f(correctionInfo);
                    setCorrectionInfo(correctionInfo);
                    break;
                case SyslogConstants.LOG_LOCAL5 /* 168 */:
                    setCarPreload(bVar.k());
                    break;
                case Opcodes.GETSTATIC /* 178 */:
                    setSpeechFinalWord(bVar.n());
                    break;
                case 186:
                    ImgBanner imgBanner = new ImgBanner();
                    bVar.f(imgBanner);
                    setImgBanner(imgBanner);
                    break;
                case 194:
                    MystiqueList mystiqueList = new MystiqueList();
                    bVar.f(mystiqueList);
                    addMystiqueList(mystiqueList);
                    break;
                case LicenseCode.CODE_LICENSE_SERVICE_LICENSE_SIGN_ERROR /* 202 */:
                    SugRecResult sugRecResult = new SugRecResult();
                    bVar.f(sugRecResult);
                    setSugRecRes(sugRecResult);
                    break;
                case 210:
                    HorizonSlideResult horizonSlideResult = new HorizonSlideResult();
                    bVar.f(horizonSlideResult);
                    setHorizonSlideResult(horizonSlideResult);
                    break;
                case 218:
                    setEmptyResultDynamicCard(bVar.n());
                    break;
                case 226:
                    FloatIcon floatIcon = new FloatIcon();
                    bVar.f(floatIcon);
                    addFloatIcons(floatIcon);
                    break;
                case 234:
                    setSearchBoxBgImg(bVar.n());
                    break;
                case 242:
                    setPopupWindow(bVar.n());
                    break;
                case 250:
                    WidgetBar widgetBar = new WidgetBar();
                    bVar.f(widgetBar);
                    setWidgetBar(widgetBar);
                    break;
                case 258:
                    ListAdsData listAdsData = new ListAdsData();
                    bVar.f(listAdsData);
                    setListAdsData(listAdsData);
                    break;
                case 266:
                    TalosData talosData = new TalosData();
                    bVar.f(talosData);
                    setTalosData(talosData);
                    break;
                case 274:
                    setPreviewCacheKey(bVar.n());
                    break;
                case 282:
                    setTalosBanner(bVar.n());
                    break;
                case 290:
                    GuildButton guildButton = new GuildButton();
                    bVar.f(guildButton);
                    addGuildButton(guildButton);
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
