package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import ch.qos.logback.core.net.SyslogConstants;
import com.baidu.entity.pb.PoiResult;
import com.baidu.platform.comapi.UIMsg;
import com.stepos.activeview.utils.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class yellow_tips_list_t extends f {
    public static final int ALL_PASS_ID_FIELD_NUMBER = 56;
    public static final int ASSIST_INFO_FIELD_NUMBER = 3;
    public static final int BACK_COLOR_ID_FIELD_NUMBER = 6;
    public static final int BUTTON_ACTION_FIELD_NUMBER = 40;
    public static final int CARLIMIT_INFO_ID_FIELD_NUMBER = 43;
    public static final int CITY_ID_FIELD_NUMBER = 34;
    public static final int COPY_WRITINGS_FIELD_NUMBER = 21;
    public static final int DISPLAY_POS_FIELD_NUMBER = 25;
    public static final int DU_TIP_ID_FIELD_NUMBER = 50;
    public static final int DU_TITLE_FIELD_NUMBER = 51;
    public static final int END_BTN_FIELD_NUMBER = 7;
    public static final int EVENT_IDS_FIELD_NUMBER = 53;
    public static final int EVENT_ID_FIELD_NUMBER = 18;
    public static final int EXPALN_TITLE_FIELD_NUMBER = 10;
    public static final int EXPLAIN_BUBBLE_FIELD_NUMBER = 24;
    public static final int EXPLAIN_SUB_TITLE_FIELD_NUMBER = 23;
    public static final int FIRST_LINE_FIELD_NUMBER = 29;
    public static final int GIF_URL_DARK_FIELD_NUMBER = 47;
    public static final int GIF_URL_FIELD_NUMBER = 46;
    public static final int GROUP_ID_FIELD_NUMBER = 32;
    public static final int ICON_ID_FIELD_NUMBER = 5;
    public static final int IDSS_CARD_ID_FIELD_NUMBER = 45;
    public static final int IMAGE_URL_FIELD_NUMBER = 20;
    public static final int JUMP_FLAG_FIELD_NUMBER = 16;
    public static final int LENGTH_FIELD_NUMBER = 12;
    public static final int LITTLE_ACTION_FIELD_NUMBER = 41;
    public static final int MAIN_ACTION_FIELD_NUMBER = 42;
    public static final int NEW_PATTERN_FIELD_NUMBER = 22;
    public static final int PANEL_FLAG_FIELD_NUMBER = 17;
    public static final int PASS_ID_FIELD_NUMBER = 55;
    public static final int PERMIT_INFO_ID_FIELD_NUMBER = 14;
    public static final int ROAD_NAME_FIELD_NUMBER = 11;
    public static final int ROAD_NO_FIELD_NUMBER = 15;
    public static final int ROUTE_PREVIEW_OFF_FIELD_NUMBER = 31;
    public static final int ROUTE_TAG_OFF_FIELD_NUMBER = 33;
    public static final int SECOND_LINE_FIELD_NUMBER = 30;
    public static final int SHOW_PANEL_FIELD_NUMBER = 52;
    public static final int SUB_TITLE_FIELD_NUMBER = 2;
    public static final int TAG_FIELD_NUMBER = 27;
    public static final int TAG_INFO_FIELD_NUMBER = 28;
    public static final int TIME_S_FIELD_NUMBER = 19;
    public static final int TIPS_BROADCAST_FIELD_NUMBER = 9;
    public static final int TIPS_COPY_FIELD_NUMBER = 8;
    public static final int TIPS_TYPE_FIELD_NUMBER = 26;
    public static final int TIP_ID_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int TRAFFIC_LIMIT_INFO_ID_FIELD_NUMBER = 44;
    public static final int TYPE_FIELD_NUMBER = 13;
    public static final int UI_TYPE_FIELD_NUMBER = 48;
    private List<a> allPassId_;
    private a assistInfo_;
    private int backColorId_;
    private action_t buttonAction_;
    private int cachedSize;
    private a carlimitInfoId_;
    private a cityId_;
    private List<a> copyWritings_;
    private int displayPos_;
    private int duTipId_;
    private a duTitle_;
    private List<end_button_info> endBtn_;
    private long eventId_;
    private List<Long> eventIds_;
    private a expalnTitle_;
    private explain_bubble_t explainBubble_;
    private a explainSubTitle_;
    private a firstLine_;
    private a gifUrlDark_;
    private a gifUrl_;
    private int groupId_;
    private boolean hasAssistInfo;
    private boolean hasBackColorId;
    private boolean hasButtonAction;
    private boolean hasCarlimitInfoId;
    private boolean hasCityId;
    private boolean hasDisplayPos;
    private boolean hasDuTipId;
    private boolean hasDuTitle;
    private boolean hasEventId;
    private boolean hasExpalnTitle;
    private boolean hasExplainBubble;
    private boolean hasExplainSubTitle;
    private boolean hasFirstLine;
    private boolean hasGifUrl;
    private boolean hasGifUrlDark;
    private boolean hasGroupId;
    private boolean hasIconId;
    private boolean hasIdssCardId;
    private boolean hasJumpFlag;
    private boolean hasLength;
    private boolean hasLittleAction;
    private boolean hasMainAction;
    private boolean hasNewPattern;
    private boolean hasPanelFlag;
    private boolean hasPermitInfoId;
    private boolean hasRoadName;
    private boolean hasRoadNo;
    private boolean hasRoutePreviewOff;
    private boolean hasRouteTagOff;
    private boolean hasShowPanel;
    private boolean hasSubTitle;
    private boolean hasTag;
    private boolean hasTagInfo;
    private boolean hasTimeS;
    private boolean hasTipId;
    private boolean hasTipsBroadcast;
    private boolean hasTipsCopy;
    private boolean hasTipsType;
    private boolean hasTitle;
    private boolean hasType;
    private boolean hasUiType;
    private int iconId_;
    private int idssCardId_;
    private List<a> imageUrl_;
    private boolean jumpFlag_;
    private int length_;
    private action_t littleAction_;
    private action_t mainAction_;
    private boolean newPattern_;
    private boolean panelFlag_;
    private List<a> passId_;
    private a permitInfoId_;
    private a roadName_;
    private int roadNo_;
    private boolean routePreviewOff_;
    private boolean routeTagOff_;
    private List<a> secondLine_;
    private boolean showPanel_;
    private a subTitle_;
    private a tagInfo_;
    private a tag_;
    private int timeS_;
    private int tipId_;
    private a tipsBroadcast_;
    private a tipsCopy_;
    private int tipsType_;
    private a title_;
    private List<a> trafficLimitInfoId_;
    private int type_;
    private int uiType_;

    public yellow_tips_list_t() {
        a aVar = a.f1216c;
        this.title_ = aVar;
        this.subTitle_ = aVar;
        this.assistInfo_ = aVar;
        this.tipId_ = 0;
        this.iconId_ = 0;
        this.backColorId_ = 0;
        this.endBtn_ = Collections.emptyList();
        this.tipsCopy_ = aVar;
        this.tipsBroadcast_ = aVar;
        this.expalnTitle_ = aVar;
        this.roadName_ = aVar;
        this.length_ = 0;
        this.type_ = 0;
        this.permitInfoId_ = aVar;
        this.roadNo_ = 0;
        this.jumpFlag_ = false;
        this.panelFlag_ = false;
        this.eventId_ = 0L;
        this.timeS_ = 0;
        this.imageUrl_ = Collections.emptyList();
        this.copyWritings_ = Collections.emptyList();
        this.newPattern_ = false;
        this.explainSubTitle_ = aVar;
        this.explainBubble_ = null;
        this.displayPos_ = 0;
        this.tipsType_ = 0;
        this.tag_ = aVar;
        this.tagInfo_ = aVar;
        this.firstLine_ = aVar;
        this.secondLine_ = Collections.emptyList();
        this.routePreviewOff_ = false;
        this.groupId_ = 0;
        this.routeTagOff_ = false;
        this.cityId_ = aVar;
        this.buttonAction_ = null;
        this.littleAction_ = null;
        this.mainAction_ = null;
        this.carlimitInfoId_ = aVar;
        this.trafficLimitInfoId_ = Collections.emptyList();
        this.idssCardId_ = 0;
        this.gifUrl_ = aVar;
        this.gifUrlDark_ = aVar;
        this.uiType_ = 0;
        this.duTipId_ = 0;
        this.duTitle_ = aVar;
        this.showPanel_ = false;
        this.eventIds_ = Collections.emptyList();
        this.passId_ = Collections.emptyList();
        this.allPassId_ = Collections.emptyList();
        this.cachedSize = -1;
    }

    public static yellow_tips_list_t parseFrom(b bVar) throws IOException {
        return new yellow_tips_list_t().mergeFrom(bVar);
    }

    public yellow_tips_list_t addAllPassId(a aVar) {
        aVar.getClass();
        if (this.allPassId_.isEmpty()) {
            this.allPassId_ = new ArrayList();
        }
        this.allPassId_.add(aVar);
        return this;
    }

    public yellow_tips_list_t addCopyWritings(a aVar) {
        aVar.getClass();
        if (this.copyWritings_.isEmpty()) {
            this.copyWritings_ = new ArrayList();
        }
        this.copyWritings_.add(aVar);
        return this;
    }

    public yellow_tips_list_t addEndBtn(end_button_info end_button_infoVar) {
        if (end_button_infoVar == null) {
            return this;
        }
        if (this.endBtn_.isEmpty()) {
            this.endBtn_ = new ArrayList();
        }
        this.endBtn_.add(end_button_infoVar);
        return this;
    }

    public yellow_tips_list_t addEventIds(long j4) {
        if (this.eventIds_.isEmpty()) {
            this.eventIds_ = new ArrayList();
        }
        this.eventIds_.add(Long.valueOf(j4));
        return this;
    }

    public yellow_tips_list_t addImageUrl(a aVar) {
        aVar.getClass();
        if (this.imageUrl_.isEmpty()) {
            this.imageUrl_ = new ArrayList();
        }
        this.imageUrl_.add(aVar);
        return this;
    }

    public yellow_tips_list_t addPassId(a aVar) {
        aVar.getClass();
        if (this.passId_.isEmpty()) {
            this.passId_ = new ArrayList();
        }
        this.passId_.add(aVar);
        return this;
    }

    public yellow_tips_list_t addSecondLine(a aVar) {
        aVar.getClass();
        if (this.secondLine_.isEmpty()) {
            this.secondLine_ = new ArrayList();
        }
        this.secondLine_.add(aVar);
        return this;
    }

    public yellow_tips_list_t addTrafficLimitInfoId(a aVar) {
        aVar.getClass();
        if (this.trafficLimitInfoId_.isEmpty()) {
            this.trafficLimitInfoId_ = new ArrayList();
        }
        this.trafficLimitInfoId_.add(aVar);
        return this;
    }

    public final yellow_tips_list_t clear() {
        clearTitle();
        clearSubTitle();
        clearAssistInfo();
        clearTipId();
        clearIconId();
        clearBackColorId();
        clearEndBtn();
        clearTipsCopy();
        clearTipsBroadcast();
        clearExpalnTitle();
        clearRoadName();
        clearLength();
        clearType();
        clearPermitInfoId();
        clearRoadNo();
        clearJumpFlag();
        clearPanelFlag();
        clearEventId();
        clearTimeS();
        clearImageUrl();
        clearCopyWritings();
        clearNewPattern();
        clearExplainSubTitle();
        clearExplainBubble();
        clearDisplayPos();
        clearTipsType();
        clearTag();
        clearTagInfo();
        clearFirstLine();
        clearSecondLine();
        clearRoutePreviewOff();
        clearGroupId();
        clearRouteTagOff();
        clearCityId();
        clearButtonAction();
        clearLittleAction();
        clearMainAction();
        clearCarlimitInfoId();
        clearTrafficLimitInfoId();
        clearIdssCardId();
        clearGifUrl();
        clearGifUrlDark();
        clearUiType();
        clearDuTipId();
        clearDuTitle();
        clearShowPanel();
        clearEventIds();
        clearPassId();
        clearAllPassId();
        this.cachedSize = -1;
        return this;
    }

    public yellow_tips_list_t clearAllPassId() {
        this.allPassId_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearAssistInfo() {
        this.hasAssistInfo = false;
        this.assistInfo_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearBackColorId() {
        this.hasBackColorId = false;
        this.backColorId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearButtonAction() {
        this.hasButtonAction = false;
        this.buttonAction_ = null;
        return this;
    }

    public yellow_tips_list_t clearCarlimitInfoId() {
        this.hasCarlimitInfoId = false;
        this.carlimitInfoId_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearCityId() {
        this.hasCityId = false;
        this.cityId_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearCopyWritings() {
        this.copyWritings_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearDisplayPos() {
        this.hasDisplayPos = false;
        this.displayPos_ = 0;
        return this;
    }

    public yellow_tips_list_t clearDuTipId() {
        this.hasDuTipId = false;
        this.duTipId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearDuTitle() {
        this.hasDuTitle = false;
        this.duTitle_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearEndBtn() {
        this.endBtn_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearEventId() {
        this.hasEventId = false;
        this.eventId_ = 0L;
        return this;
    }

    public yellow_tips_list_t clearEventIds() {
        this.eventIds_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearExpalnTitle() {
        this.hasExpalnTitle = false;
        this.expalnTitle_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearExplainBubble() {
        this.hasExplainBubble = false;
        this.explainBubble_ = null;
        return this;
    }

    public yellow_tips_list_t clearExplainSubTitle() {
        this.hasExplainSubTitle = false;
        this.explainSubTitle_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearFirstLine() {
        this.hasFirstLine = false;
        this.firstLine_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearGifUrl() {
        this.hasGifUrl = false;
        this.gifUrl_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearGifUrlDark() {
        this.hasGifUrlDark = false;
        this.gifUrlDark_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearGroupId() {
        this.hasGroupId = false;
        this.groupId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearIconId() {
        this.hasIconId = false;
        this.iconId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearIdssCardId() {
        this.hasIdssCardId = false;
        this.idssCardId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearImageUrl() {
        this.imageUrl_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearJumpFlag() {
        this.hasJumpFlag = false;
        this.jumpFlag_ = false;
        return this;
    }

    public yellow_tips_list_t clearLength() {
        this.hasLength = false;
        this.length_ = 0;
        return this;
    }

    public yellow_tips_list_t clearLittleAction() {
        this.hasLittleAction = false;
        this.littleAction_ = null;
        return this;
    }

    public yellow_tips_list_t clearMainAction() {
        this.hasMainAction = false;
        this.mainAction_ = null;
        return this;
    }

    public yellow_tips_list_t clearNewPattern() {
        this.hasNewPattern = false;
        this.newPattern_ = false;
        return this;
    }

    public yellow_tips_list_t clearPanelFlag() {
        this.hasPanelFlag = false;
        this.panelFlag_ = false;
        return this;
    }

    public yellow_tips_list_t clearPassId() {
        this.passId_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearPermitInfoId() {
        this.hasPermitInfoId = false;
        this.permitInfoId_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearRoadName() {
        this.hasRoadName = false;
        this.roadName_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearRoadNo() {
        this.hasRoadNo = false;
        this.roadNo_ = 0;
        return this;
    }

    public yellow_tips_list_t clearRoutePreviewOff() {
        this.hasRoutePreviewOff = false;
        this.routePreviewOff_ = false;
        return this;
    }

    public yellow_tips_list_t clearRouteTagOff() {
        this.hasRouteTagOff = false;
        this.routeTagOff_ = false;
        return this;
    }

    public yellow_tips_list_t clearSecondLine() {
        this.secondLine_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearShowPanel() {
        this.hasShowPanel = false;
        this.showPanel_ = false;
        return this;
    }

    public yellow_tips_list_t clearSubTitle() {
        this.hasSubTitle = false;
        this.subTitle_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearTag() {
        this.hasTag = false;
        this.tag_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearTagInfo() {
        this.hasTagInfo = false;
        this.tagInfo_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearTimeS() {
        this.hasTimeS = false;
        this.timeS_ = 0;
        return this;
    }

    public yellow_tips_list_t clearTipId() {
        this.hasTipId = false;
        this.tipId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearTipsBroadcast() {
        this.hasTipsBroadcast = false;
        this.tipsBroadcast_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearTipsCopy() {
        this.hasTipsCopy = false;
        this.tipsCopy_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearTipsType() {
        this.hasTipsType = false;
        this.tipsType_ = 0;
        return this;
    }

    public yellow_tips_list_t clearTitle() {
        this.hasTitle = false;
        this.title_ = a.f1216c;
        return this;
    }

    public yellow_tips_list_t clearTrafficLimitInfoId() {
        this.trafficLimitInfoId_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearType() {
        this.hasType = false;
        this.type_ = 0;
        return this;
    }

    public yellow_tips_list_t clearUiType() {
        this.hasUiType = false;
        this.uiType_ = 0;
        return this;
    }

    public a getAllPassId(int i4) {
        return this.allPassId_.get(i4);
    }

    public int getAllPassIdCount() {
        return this.allPassId_.size();
    }

    public List<a> getAllPassIdList() {
        return this.allPassId_;
    }

    public a getAssistInfo() {
        return this.assistInfo_;
    }

    public int getBackColorId() {
        return this.backColorId_;
    }

    public action_t getButtonAction() {
        return this.buttonAction_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getCarlimitInfoId() {
        return this.carlimitInfoId_;
    }

    public a getCityId() {
        return this.cityId_;
    }

    public a getCopyWritings(int i4) {
        return this.copyWritings_.get(i4);
    }

    public int getCopyWritingsCount() {
        return this.copyWritings_.size();
    }

    public List<a> getCopyWritingsList() {
        return this.copyWritings_;
    }

    public int getDisplayPos() {
        return this.displayPos_;
    }

    public int getDuTipId() {
        return this.duTipId_;
    }

    public a getDuTitle() {
        return this.duTitle_;
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

    public long getEventId() {
        return this.eventId_;
    }

    public long getEventIds(int i4) {
        return this.eventIds_.get(i4).longValue();
    }

    public int getEventIdsCount() {
        return this.eventIds_.size();
    }

    public List<Long> getEventIdsList() {
        return this.eventIds_;
    }

    public a getExpalnTitle() {
        return this.expalnTitle_;
    }

    public explain_bubble_t getExplainBubble() {
        return this.explainBubble_;
    }

    public a getExplainSubTitle() {
        return this.explainSubTitle_;
    }

    public a getFirstLine() {
        return this.firstLine_;
    }

    public a getGifUrl() {
        return this.gifUrl_;
    }

    public a getGifUrlDark() {
        return this.gifUrlDark_;
    }

    public int getGroupId() {
        return this.groupId_;
    }

    public int getIconId() {
        return this.iconId_;
    }

    public int getIdssCardId() {
        return this.idssCardId_;
    }

    public a getImageUrl(int i4) {
        return this.imageUrl_.get(i4);
    }

    public int getImageUrlCount() {
        return this.imageUrl_.size();
    }

    public List<a> getImageUrlList() {
        return this.imageUrl_;
    }

    public boolean getJumpFlag() {
        return this.jumpFlag_;
    }

    public int getLength() {
        return this.length_;
    }

    public action_t getLittleAction() {
        return this.littleAction_;
    }

    public action_t getMainAction() {
        return this.mainAction_;
    }

    public boolean getNewPattern() {
        return this.newPattern_;
    }

    public boolean getPanelFlag() {
        return this.panelFlag_;
    }

    public a getPassId(int i4) {
        return this.passId_.get(i4);
    }

    public int getPassIdCount() {
        return this.passId_.size();
    }

    public List<a> getPassIdList() {
        return this.passId_;
    }

    public a getPermitInfoId() {
        return this.permitInfoId_;
    }

    public a getRoadName() {
        return this.roadName_;
    }

    public int getRoadNo() {
        return this.roadNo_;
    }

    public boolean getRoutePreviewOff() {
        return this.routePreviewOff_;
    }

    public boolean getRouteTagOff() {
        return this.routeTagOff_;
    }

    public a getSecondLine(int i4) {
        return this.secondLine_.get(i4);
    }

    public int getSecondLineCount() {
        return this.secondLine_.size();
    }

    public List<a> getSecondLineList() {
        return this.secondLine_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iC = 0;
        int iB = hasTitle() ? d.b(1, getTitle()) : 0;
        if (hasSubTitle()) {
            iB += d.b(2, getSubTitle());
        }
        if (hasAssistInfo()) {
            iB += d.b(3, getAssistInfo());
        }
        if (hasTipId()) {
            iB += d.e(4, getTipId());
        }
        if (hasIconId()) {
            iB += d.e(5, getIconId());
        }
        if (hasBackColorId()) {
            iB += d.e(6, getBackColorId());
        }
        Iterator<end_button_info> it = getEndBtnList().iterator();
        while (it.hasNext()) {
            iB += d.h(7, it.next());
        }
        if (hasTipsCopy()) {
            iB += d.b(8, getTipsCopy());
        }
        if (hasTipsBroadcast()) {
            iB += d.b(9, getTipsBroadcast());
        }
        if (hasExpalnTitle()) {
            iB += d.b(10, getExpalnTitle());
        }
        if (hasRoadName()) {
            iB += d.b(11, getRoadName());
        }
        if (hasLength()) {
            iB += d.e(12, getLength());
        }
        if (hasType()) {
            iB += d.e(13, getType());
        }
        if (hasPermitInfoId()) {
            iB += d.b(14, getPermitInfoId());
        }
        if (hasRoadNo()) {
            iB += d.e(15, getRoadNo());
        }
        if (hasJumpFlag()) {
            getJumpFlag();
            iB += d.a(16);
        }
        if (hasPanelFlag()) {
            getPanelFlag();
            iB += d.a(17);
        }
        if (hasEventId()) {
            iB += d.g(18, getEventId());
        }
        if (hasTimeS()) {
            iB += d.e(19, getTimeS());
        }
        Iterator<a> it2 = getImageUrlList().iterator();
        int iC2 = 0;
        while (it2.hasNext()) {
            iC2 += d.c(it2.next());
        }
        int size = (getImageUrlList().size() * 2) + iB + iC2;
        Iterator<a> it3 = getCopyWritingsList().iterator();
        int iC3 = 0;
        while (it3.hasNext()) {
            iC3 += d.c(it3.next());
        }
        int size2 = (getCopyWritingsList().size() * 2) + size + iC3;
        if (hasNewPattern()) {
            getNewPattern();
            size2 += d.a(22);
        }
        if (hasExplainSubTitle()) {
            size2 += d.b(23, getExplainSubTitle());
        }
        if (hasExplainBubble()) {
            size2 += d.h(24, getExplainBubble());
        }
        if (hasDisplayPos()) {
            size2 += d.e(25, getDisplayPos());
        }
        if (hasTipsType()) {
            size2 += d.e(26, getTipsType());
        }
        if (hasTag()) {
            size2 += d.b(27, getTag());
        }
        if (hasTagInfo()) {
            size2 += d.b(28, getTagInfo());
        }
        if (hasFirstLine()) {
            size2 += d.b(29, getFirstLine());
        }
        Iterator<a> it4 = getSecondLineList().iterator();
        int iC4 = 0;
        while (it4.hasNext()) {
            iC4 += d.c(it4.next());
        }
        int size3 = (getSecondLineList().size() * 2) + size2 + iC4;
        if (hasRoutePreviewOff()) {
            getRoutePreviewOff();
            size3 += d.a(31);
        }
        if (hasGroupId()) {
            size3 += d.e(32, getGroupId());
        }
        if (hasRouteTagOff()) {
            getRouteTagOff();
            size3 += d.a(33);
        }
        if (hasCityId()) {
            size3 += d.b(34, getCityId());
        }
        if (hasButtonAction()) {
            size3 += d.h(40, getButtonAction());
        }
        if (hasLittleAction()) {
            size3 += d.h(41, getLittleAction());
        }
        if (hasMainAction()) {
            size3 += d.h(42, getMainAction());
        }
        if (hasCarlimitInfoId()) {
            size3 += d.b(43, getCarlimitInfoId());
        }
        Iterator<a> it5 = getTrafficLimitInfoIdList().iterator();
        int iC5 = 0;
        while (it5.hasNext()) {
            iC5 += d.c(it5.next());
        }
        int size4 = (getTrafficLimitInfoIdList().size() * 2) + size3 + iC5;
        if (hasIdssCardId()) {
            size4 += d.e(45, getIdssCardId());
        }
        if (hasGifUrl()) {
            size4 += d.b(46, getGifUrl());
        }
        if (hasGifUrlDark()) {
            size4 += d.b(47, getGifUrlDark());
        }
        if (hasUiType()) {
            size4 += d.e(48, getUiType());
        }
        if (hasDuTipId()) {
            size4 += d.e(50, getDuTipId());
        }
        if (hasDuTitle()) {
            size4 += d.b(51, getDuTitle());
        }
        if (hasShowPanel()) {
            getShowPanel();
            size4 += d.a(52);
        }
        Iterator<Long> it6 = getEventIdsList().iterator();
        int iJ = 0;
        while (it6.hasNext()) {
            iJ += d.j(it6.next().longValue());
        }
        int size5 = (getEventIdsList().size() * 2) + size4 + iJ;
        Iterator<a> it7 = getPassIdList().iterator();
        int iC6 = 0;
        while (it7.hasNext()) {
            iC6 += d.c(it7.next());
        }
        int size6 = (getPassIdList().size() * 2) + size5 + iC6;
        Iterator<a> it8 = getAllPassIdList().iterator();
        while (it8.hasNext()) {
            iC += d.c(it8.next());
        }
        int size7 = (getAllPassIdList().size() * 2) + size6 + iC;
        this.cachedSize = size7;
        return size7;
    }

    public boolean getShowPanel() {
        return this.showPanel_;
    }

    public a getSubTitle() {
        return this.subTitle_;
    }

    public a getTag() {
        return this.tag_;
    }

    public a getTagInfo() {
        return this.tagInfo_;
    }

    public int getTimeS() {
        return this.timeS_;
    }

    public int getTipId() {
        return this.tipId_;
    }

    public a getTipsBroadcast() {
        return this.tipsBroadcast_;
    }

    public a getTipsCopy() {
        return this.tipsCopy_;
    }

    public int getTipsType() {
        return this.tipsType_;
    }

    public a getTitle() {
        return this.title_;
    }

    public a getTrafficLimitInfoId(int i4) {
        return this.trafficLimitInfoId_.get(i4);
    }

    public int getTrafficLimitInfoIdCount() {
        return this.trafficLimitInfoId_.size();
    }

    public List<a> getTrafficLimitInfoIdList() {
        return this.trafficLimitInfoId_;
    }

    public int getType() {
        return this.type_;
    }

    public int getUiType() {
        return this.uiType_;
    }

    public boolean hasAssistInfo() {
        return this.hasAssistInfo;
    }

    public boolean hasBackColorId() {
        return this.hasBackColorId;
    }

    public boolean hasButtonAction() {
        return this.hasButtonAction;
    }

    public boolean hasCarlimitInfoId() {
        return this.hasCarlimitInfoId;
    }

    public boolean hasCityId() {
        return this.hasCityId;
    }

    public boolean hasDisplayPos() {
        return this.hasDisplayPos;
    }

    public boolean hasDuTipId() {
        return this.hasDuTipId;
    }

    public boolean hasDuTitle() {
        return this.hasDuTitle;
    }

    public boolean hasEventId() {
        return this.hasEventId;
    }

    public boolean hasExpalnTitle() {
        return this.hasExpalnTitle;
    }

    public boolean hasExplainBubble() {
        return this.hasExplainBubble;
    }

    public boolean hasExplainSubTitle() {
        return this.hasExplainSubTitle;
    }

    public boolean hasFirstLine() {
        return this.hasFirstLine;
    }

    public boolean hasGifUrl() {
        return this.hasGifUrl;
    }

    public boolean hasGifUrlDark() {
        return this.hasGifUrlDark;
    }

    public boolean hasGroupId() {
        return this.hasGroupId;
    }

    public boolean hasIconId() {
        return this.hasIconId;
    }

    public boolean hasIdssCardId() {
        return this.hasIdssCardId;
    }

    public boolean hasJumpFlag() {
        return this.hasJumpFlag;
    }

    public boolean hasLength() {
        return this.hasLength;
    }

    public boolean hasLittleAction() {
        return this.hasLittleAction;
    }

    public boolean hasMainAction() {
        return this.hasMainAction;
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

    public boolean hasRoadName() {
        return this.hasRoadName;
    }

    public boolean hasRoadNo() {
        return this.hasRoadNo;
    }

    public boolean hasRoutePreviewOff() {
        return this.hasRoutePreviewOff;
    }

    public boolean hasRouteTagOff() {
        return this.hasRouteTagOff;
    }

    public boolean hasShowPanel() {
        return this.hasShowPanel;
    }

    public boolean hasSubTitle() {
        return this.hasSubTitle;
    }

    public boolean hasTag() {
        return this.hasTag;
    }

    public boolean hasTagInfo() {
        return this.hasTagInfo;
    }

    public boolean hasTimeS() {
        return this.hasTimeS;
    }

    public boolean hasTipId() {
        return this.hasTipId;
    }

    public boolean hasTipsBroadcast() {
        return this.hasTipsBroadcast;
    }

    public boolean hasTipsCopy() {
        return this.hasTipsCopy;
    }

    public boolean hasTipsType() {
        return this.hasTipsType;
    }

    public boolean hasTitle() {
        return this.hasTitle;
    }

    public boolean hasType() {
        return this.hasType;
    }

    public boolean hasUiType() {
        return this.hasUiType;
    }

    public final boolean isInitialized() {
        return this.hasTitle && this.hasTipId;
    }

    public yellow_tips_list_t setAllPassId(int i4, a aVar) {
        aVar.getClass();
        this.allPassId_.set(i4, aVar);
        return this;
    }

    public yellow_tips_list_t setAssistInfo(a aVar) {
        this.hasAssistInfo = true;
        this.assistInfo_ = aVar;
        return this;
    }

    public yellow_tips_list_t setBackColorId(int i4) {
        this.hasBackColorId = true;
        this.backColorId_ = i4;
        return this;
    }

    public yellow_tips_list_t setButtonAction(action_t action_tVar) {
        if (action_tVar == null) {
            return clearButtonAction();
        }
        this.hasButtonAction = true;
        this.buttonAction_ = action_tVar;
        return this;
    }

    public yellow_tips_list_t setCarlimitInfoId(a aVar) {
        this.hasCarlimitInfoId = true;
        this.carlimitInfoId_ = aVar;
        return this;
    }

    public yellow_tips_list_t setCityId(a aVar) {
        this.hasCityId = true;
        this.cityId_ = aVar;
        return this;
    }

    public yellow_tips_list_t setCopyWritings(int i4, a aVar) {
        aVar.getClass();
        this.copyWritings_.set(i4, aVar);
        return this;
    }

    public yellow_tips_list_t setDisplayPos(int i4) {
        this.hasDisplayPos = true;
        this.displayPos_ = i4;
        return this;
    }

    public yellow_tips_list_t setDuTipId(int i4) {
        this.hasDuTipId = true;
        this.duTipId_ = i4;
        return this;
    }

    public yellow_tips_list_t setDuTitle(a aVar) {
        this.hasDuTitle = true;
        this.duTitle_ = aVar;
        return this;
    }

    public yellow_tips_list_t setEndBtn(int i4, end_button_info end_button_infoVar) {
        if (end_button_infoVar == null) {
            return this;
        }
        this.endBtn_.set(i4, end_button_infoVar);
        return this;
    }

    public yellow_tips_list_t setEventId(long j4) {
        this.hasEventId = true;
        this.eventId_ = j4;
        return this;
    }

    public yellow_tips_list_t setEventIds(int i4, long j4) {
        this.eventIds_.set(i4, Long.valueOf(j4));
        return this;
    }

    public yellow_tips_list_t setExpalnTitle(a aVar) {
        this.hasExpalnTitle = true;
        this.expalnTitle_ = aVar;
        return this;
    }

    public yellow_tips_list_t setExplainBubble(explain_bubble_t explain_bubble_tVar) {
        if (explain_bubble_tVar == null) {
            return clearExplainBubble();
        }
        this.hasExplainBubble = true;
        this.explainBubble_ = explain_bubble_tVar;
        return this;
    }

    public yellow_tips_list_t setExplainSubTitle(a aVar) {
        this.hasExplainSubTitle = true;
        this.explainSubTitle_ = aVar;
        return this;
    }

    public yellow_tips_list_t setFirstLine(a aVar) {
        this.hasFirstLine = true;
        this.firstLine_ = aVar;
        return this;
    }

    public yellow_tips_list_t setGifUrl(a aVar) {
        this.hasGifUrl = true;
        this.gifUrl_ = aVar;
        return this;
    }

    public yellow_tips_list_t setGifUrlDark(a aVar) {
        this.hasGifUrlDark = true;
        this.gifUrlDark_ = aVar;
        return this;
    }

    public yellow_tips_list_t setGroupId(int i4) {
        this.hasGroupId = true;
        this.groupId_ = i4;
        return this;
    }

    public yellow_tips_list_t setIconId(int i4) {
        this.hasIconId = true;
        this.iconId_ = i4;
        return this;
    }

    public yellow_tips_list_t setIdssCardId(int i4) {
        this.hasIdssCardId = true;
        this.idssCardId_ = i4;
        return this;
    }

    public yellow_tips_list_t setImageUrl(int i4, a aVar) {
        aVar.getClass();
        this.imageUrl_.set(i4, aVar);
        return this;
    }

    public yellow_tips_list_t setJumpFlag(boolean z4) {
        this.hasJumpFlag = true;
        this.jumpFlag_ = z4;
        return this;
    }

    public yellow_tips_list_t setLength(int i4) {
        this.hasLength = true;
        this.length_ = i4;
        return this;
    }

    public yellow_tips_list_t setLittleAction(action_t action_tVar) {
        if (action_tVar == null) {
            return clearLittleAction();
        }
        this.hasLittleAction = true;
        this.littleAction_ = action_tVar;
        return this;
    }

    public yellow_tips_list_t setMainAction(action_t action_tVar) {
        if (action_tVar == null) {
            return clearMainAction();
        }
        this.hasMainAction = true;
        this.mainAction_ = action_tVar;
        return this;
    }

    public yellow_tips_list_t setNewPattern(boolean z4) {
        this.hasNewPattern = true;
        this.newPattern_ = z4;
        return this;
    }

    public yellow_tips_list_t setPanelFlag(boolean z4) {
        this.hasPanelFlag = true;
        this.panelFlag_ = z4;
        return this;
    }

    public yellow_tips_list_t setPassId(int i4, a aVar) {
        aVar.getClass();
        this.passId_.set(i4, aVar);
        return this;
    }

    public yellow_tips_list_t setPermitInfoId(a aVar) {
        this.hasPermitInfoId = true;
        this.permitInfoId_ = aVar;
        return this;
    }

    public yellow_tips_list_t setRoadName(a aVar) {
        this.hasRoadName = true;
        this.roadName_ = aVar;
        return this;
    }

    public yellow_tips_list_t setRoadNo(int i4) {
        this.hasRoadNo = true;
        this.roadNo_ = i4;
        return this;
    }

    public yellow_tips_list_t setRoutePreviewOff(boolean z4) {
        this.hasRoutePreviewOff = true;
        this.routePreviewOff_ = z4;
        return this;
    }

    public yellow_tips_list_t setRouteTagOff(boolean z4) {
        this.hasRouteTagOff = true;
        this.routeTagOff_ = z4;
        return this;
    }

    public yellow_tips_list_t setSecondLine(int i4, a aVar) {
        aVar.getClass();
        this.secondLine_.set(i4, aVar);
        return this;
    }

    public yellow_tips_list_t setShowPanel(boolean z4) {
        this.hasShowPanel = true;
        this.showPanel_ = z4;
        return this;
    }

    public yellow_tips_list_t setSubTitle(a aVar) {
        this.hasSubTitle = true;
        this.subTitle_ = aVar;
        return this;
    }

    public yellow_tips_list_t setTag(a aVar) {
        this.hasTag = true;
        this.tag_ = aVar;
        return this;
    }

    public yellow_tips_list_t setTagInfo(a aVar) {
        this.hasTagInfo = true;
        this.tagInfo_ = aVar;
        return this;
    }

    public yellow_tips_list_t setTimeS(int i4) {
        this.hasTimeS = true;
        this.timeS_ = i4;
        return this;
    }

    public yellow_tips_list_t setTipId(int i4) {
        this.hasTipId = true;
        this.tipId_ = i4;
        return this;
    }

    public yellow_tips_list_t setTipsBroadcast(a aVar) {
        this.hasTipsBroadcast = true;
        this.tipsBroadcast_ = aVar;
        return this;
    }

    public yellow_tips_list_t setTipsCopy(a aVar) {
        this.hasTipsCopy = true;
        this.tipsCopy_ = aVar;
        return this;
    }

    public yellow_tips_list_t setTipsType(int i4) {
        this.hasTipsType = true;
        this.tipsType_ = i4;
        return this;
    }

    public yellow_tips_list_t setTitle(a aVar) {
        this.hasTitle = true;
        this.title_ = aVar;
        return this;
    }

    public yellow_tips_list_t setTrafficLimitInfoId(int i4, a aVar) {
        aVar.getClass();
        this.trafficLimitInfoId_.set(i4, aVar);
        return this;
    }

    public yellow_tips_list_t setType(int i4) {
        this.hasType = true;
        this.type_ = i4;
        return this;
    }

    public yellow_tips_list_t setUiType(int i4) {
        this.hasUiType = true;
        this.uiType_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasTitle()) {
            dVar.q(1, getTitle());
        }
        if (hasSubTitle()) {
            dVar.q(2, getSubTitle());
        }
        if (hasAssistInfo()) {
            dVar.q(3, getAssistInfo());
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
        if (hasTipsCopy()) {
            dVar.q(8, getTipsCopy());
        }
        if (hasTipsBroadcast()) {
            dVar.q(9, getTipsBroadcast());
        }
        if (hasExpalnTitle()) {
            dVar.q(10, getExpalnTitle());
        }
        if (hasRoadName()) {
            dVar.q(11, getRoadName());
        }
        if (hasLength()) {
            dVar.s(12, getLength());
        }
        if (hasType()) {
            dVar.s(13, getType());
        }
        if (hasPermitInfoId()) {
            dVar.q(14, getPermitInfoId());
        }
        if (hasRoadNo()) {
            dVar.s(15, getRoadNo());
        }
        if (hasJumpFlag()) {
            dVar.p(16, getJumpFlag());
        }
        if (hasPanelFlag()) {
            dVar.p(17, getPanelFlag());
        }
        if (hasEventId()) {
            dVar.t(18, getEventId());
        }
        if (hasTimeS()) {
            dVar.s(19, getTimeS());
        }
        Iterator<a> it2 = getImageUrlList().iterator();
        while (it2.hasNext()) {
            dVar.q(20, it2.next());
        }
        Iterator<a> it3 = getCopyWritingsList().iterator();
        while (it3.hasNext()) {
            dVar.q(21, it3.next());
        }
        if (hasNewPattern()) {
            dVar.p(22, getNewPattern());
        }
        if (hasExplainSubTitle()) {
            dVar.q(23, getExplainSubTitle());
        }
        if (hasExplainBubble()) {
            dVar.u(24, getExplainBubble());
        }
        if (hasDisplayPos()) {
            dVar.s(25, getDisplayPos());
        }
        if (hasTipsType()) {
            dVar.s(26, getTipsType());
        }
        if (hasTag()) {
            dVar.q(27, getTag());
        }
        if (hasTagInfo()) {
            dVar.q(28, getTagInfo());
        }
        if (hasFirstLine()) {
            dVar.q(29, getFirstLine());
        }
        Iterator<a> it4 = getSecondLineList().iterator();
        while (it4.hasNext()) {
            dVar.q(30, it4.next());
        }
        if (hasRoutePreviewOff()) {
            dVar.p(31, getRoutePreviewOff());
        }
        if (hasGroupId()) {
            dVar.s(32, getGroupId());
        }
        if (hasRouteTagOff()) {
            dVar.p(33, getRouteTagOff());
        }
        if (hasCityId()) {
            dVar.q(34, getCityId());
        }
        if (hasButtonAction()) {
            dVar.u(40, getButtonAction());
        }
        if (hasLittleAction()) {
            dVar.u(41, getLittleAction());
        }
        if (hasMainAction()) {
            dVar.u(42, getMainAction());
        }
        if (hasCarlimitInfoId()) {
            dVar.q(43, getCarlimitInfoId());
        }
        Iterator<a> it5 = getTrafficLimitInfoIdList().iterator();
        while (it5.hasNext()) {
            dVar.q(44, it5.next());
        }
        if (hasIdssCardId()) {
            dVar.s(45, getIdssCardId());
        }
        if (hasGifUrl()) {
            dVar.q(46, getGifUrl());
        }
        if (hasGifUrlDark()) {
            dVar.q(47, getGifUrlDark());
        }
        if (hasUiType()) {
            dVar.s(48, getUiType());
        }
        if (hasDuTipId()) {
            dVar.s(50, getDuTipId());
        }
        if (hasDuTitle()) {
            dVar.q(51, getDuTitle());
        }
        if (hasShowPanel()) {
            dVar.p(52, getShowPanel());
        }
        Iterator<Long> it6 = getEventIdsList().iterator();
        while (it6.hasNext()) {
            dVar.t(53, it6.next().longValue());
        }
        Iterator<a> it7 = getPassIdList().iterator();
        while (it7.hasNext()) {
            dVar.q(55, it7.next());
        }
        Iterator<a> it8 = getAllPassIdList().iterator();
        while (it8.hasNext()) {
            dVar.q(56, it8.next());
        }
    }

    public static yellow_tips_list_t parseFrom(byte[] bArr) throws e {
        return (yellow_tips_list_t) new yellow_tips_list_t().mergeFrom(bArr);
    }

    @Override // L1.f
    public yellow_tips_list_t mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            switch (iO) {
                case 0:
                    return this;
                case 10:
                    setTitle(bVar.b());
                    break;
                case 18:
                    setSubTitle(bVar.b());
                    break;
                case 26:
                    setAssistInfo(bVar.b());
                    break;
                case 32:
                    setTipId(bVar.d());
                    break;
                case 40:
                    setIconId(bVar.d());
                    break;
                case 48:
                    setBackColorId(bVar.d());
                    break;
                case 58:
                    end_button_info end_button_infoVar = new end_button_info();
                    bVar.f(end_button_infoVar);
                    addEndBtn(end_button_infoVar);
                    break;
                case 66:
                    setTipsCopy(bVar.b());
                    break;
                case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                    setTipsBroadcast(bVar.b());
                    break;
                case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                    setExpalnTitle(bVar.b());
                    break;
                case 90:
                    setRoadName(bVar.b());
                    break;
                case 96:
                    setLength(bVar.d());
                    break;
                case 104:
                    setType(bVar.d());
                    break;
                case 114:
                    setPermitInfoId(bVar.b());
                    break;
                case SyslogConstants.LOG_CLOCK /* 120 */:
                    setRoadNo(bVar.d());
                    break;
                case 128:
                    setJumpFlag(bVar.a());
                    break;
                case SyslogConstants.LOG_LOCAL1 /* 136 */:
                    setPanelFlag(bVar.a());
                    break;
                case SyslogConstants.LOG_LOCAL2 /* 144 */:
                    setEventId(bVar.e());
                    break;
                case SyslogConstants.LOG_LOCAL3 /* 152 */:
                    setTimeS(bVar.d());
                    break;
                case 162:
                    addImageUrl(bVar.b());
                    break;
                case 170:
                    addCopyWritings(bVar.b());
                    break;
                case 176:
                    setNewPattern(bVar.a());
                    break;
                case 186:
                    setExplainSubTitle(bVar.b());
                    break;
                case 194:
                    explain_bubble_t explain_bubble_tVar = new explain_bubble_t();
                    bVar.f(explain_bubble_tVar);
                    setExplainBubble(explain_bubble_tVar);
                    break;
                case 200:
                    setDisplayPos(bVar.d());
                    break;
                case 208:
                    setTipsType(bVar.d());
                    break;
                case 218:
                    setTag(bVar.b());
                    break;
                case 226:
                    setTagInfo(bVar.b());
                    break;
                case 234:
                    setFirstLine(bVar.b());
                    break;
                case 242:
                    addSecondLine(bVar.b());
                    break;
                case 248:
                    setRoutePreviewOff(bVar.a());
                    break;
                case 256:
                    setGroupId(bVar.d());
                    break;
                case 264:
                    setRouteTagOff(bVar.a());
                    break;
                case 274:
                    setCityId(bVar.b());
                    break;
                case 322:
                    action_t action_tVar = new action_t();
                    bVar.f(action_tVar);
                    setButtonAction(action_tVar);
                    break;
                case 330:
                    action_t action_tVar2 = new action_t();
                    bVar.f(action_tVar2);
                    setLittleAction(action_tVar2);
                    break;
                case 338:
                    action_t action_tVar3 = new action_t();
                    bVar.f(action_tVar3);
                    setMainAction(action_tVar3);
                    break;
                case 346:
                    setCarlimitInfoId(bVar.b());
                    break;
                case 354:
                    addTrafficLimitInfoId(bVar.b());
                    break;
                case 360:
                    setIdssCardId(bVar.d());
                    break;
                case 370:
                    setGifUrl(bVar.b());
                    break;
                case 378:
                    setGifUrlDark(bVar.b());
                    break;
                case 384:
                    setUiType(bVar.d());
                    break;
                case UIMsg.MsgDefine.RENDER_STATE_FIRST_TILE /* 400 */:
                    setDuTipId(bVar.d());
                    break;
                case 410:
                    setDuTitle(bVar.b());
                    break;
                case Constants.RESPONSE_CODE_OVER_RANGE /* 416 */:
                    setShowPanel(bVar.a());
                    break;
                case 424:
                    addEventIds(bVar.e());
                    break;
                case 442:
                    addPassId(bVar.b());
                    break;
                case 450:
                    addAllPassId(bVar.b());
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
