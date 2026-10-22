package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.entity.pb.PoiResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class TransDynamicInfo extends f {
    public static final int ACCI_ROUTES_INFO_FIELD_NUMBER = 17;
    public static final int BLANKING_ROUTE_IDX_FIELD_NUMBER = 9;
    public static final int CHOICE_FIELD_NUMBER = 13;
    public static final int END_MARK_FIELD_NUMBER = 12;
    public static final int INFO_ID_FIELD_NUMBER = 1;
    public static final int JAVIRS_ACTION_INFO_FIELD_NUMBER = 18;
    public static final int MAIN_ROAD_NO_FIELD_NUMBER = 6;
    public static final int NEED_REMIND_FIELD_NUMBER = 10;
    public static final int NEW_ROAD_NO_FIELD_NUMBER = 7;
    public static final int PANEL_FIELD_NUMBER = 4;
    public static final int POINT_PAIR_FIELD_NUMBER = 15;
    public static final int PRIORITY_FIELD_NUMBER = 14;
    public static final int ROUTE_INFO_FIELD_NUMBER = 5;
    public static final int START_MARK_FIELD_NUMBER = 11;
    public static final int TEXT_INFO_FIELD_NUMBER = 8;
    public static final int TRANS_PREFER_INFO_FIELD_NUMBER = 19;
    public static final int TYPE_FIELD_NUMBER = 20;
    public static final int VOICE_BROAD_TYPE_FIELD_NUMBER = 3;
    public static final int VOICE_INFO_FIELD_NUMBER = 2;
    public static final int YAW_SPEAK_FIELD_NUMBER = 16;
    private TransRouteInfo acciRoutesInfo_;
    private a blankingRouteIdx_;
    private int cachedSize;
    private List<TransPanel> choice_;
    private int endMark_;
    private boolean hasAcciRoutesInfo;
    private boolean hasBlankingRouteIdx;
    private boolean hasEndMark;
    private boolean hasInfoId;
    private boolean hasJavirsActionInfo;
    private boolean hasMainRoadNo;
    private boolean hasNeedRemind;
    private boolean hasNewRoadNo;
    private boolean hasPanel;
    private boolean hasPriority;
    private boolean hasStartMark;
    private boolean hasTextInfo;
    private boolean hasTransPreferInfo;
    private boolean hasType;
    private boolean hasVoiceBroadType;
    private boolean hasVoiceInfo;
    private boolean hasYawSpeak;
    private a infoId_;
    private TransJavirsActionInfo javirsActionInfo_;
    private int mainRoadNo_;
    private int needRemind_;
    private int newRoadNo_;
    private TransPanel panel_;
    private List<TransPanelPointPair> pointPair_;
    private int priority_;
    private List<TransRouteInfo> routeInfo_;
    private int startMark_;
    private a textInfo_;
    private TransPreferInfo transPreferInfo_;
    private int type_;
    private int voiceBroadType_;
    private TransVoiceInfo voiceInfo_;
    private a yawSpeak_;

    public TransDynamicInfo() {
        a aVar = a.f1216c;
        this.infoId_ = aVar;
        this.voiceInfo_ = null;
        this.voiceBroadType_ = 0;
        this.panel_ = null;
        this.routeInfo_ = Collections.emptyList();
        this.mainRoadNo_ = 0;
        this.newRoadNo_ = 0;
        this.textInfo_ = aVar;
        this.blankingRouteIdx_ = aVar;
        this.needRemind_ = 0;
        this.startMark_ = 0;
        this.endMark_ = 0;
        this.choice_ = Collections.emptyList();
        this.priority_ = 0;
        this.pointPair_ = Collections.emptyList();
        this.yawSpeak_ = aVar;
        this.acciRoutesInfo_ = null;
        this.javirsActionInfo_ = null;
        this.transPreferInfo_ = null;
        this.type_ = 0;
        this.cachedSize = -1;
    }

    public static TransDynamicInfo parseFrom(b bVar) throws IOException {
        return new TransDynamicInfo().mergeFrom(bVar);
    }

    public TransDynamicInfo addChoice(TransPanel transPanel) {
        if (transPanel == null) {
            return this;
        }
        if (this.choice_.isEmpty()) {
            this.choice_ = new ArrayList();
        }
        this.choice_.add(transPanel);
        return this;
    }

    public TransDynamicInfo addPointPair(TransPanelPointPair transPanelPointPair) {
        if (transPanelPointPair == null) {
            return this;
        }
        if (this.pointPair_.isEmpty()) {
            this.pointPair_ = new ArrayList();
        }
        this.pointPair_.add(transPanelPointPair);
        return this;
    }

    public TransDynamicInfo addRouteInfo(TransRouteInfo transRouteInfo) {
        if (transRouteInfo == null) {
            return this;
        }
        if (this.routeInfo_.isEmpty()) {
            this.routeInfo_ = new ArrayList();
        }
        this.routeInfo_.add(transRouteInfo);
        return this;
    }

    public final TransDynamicInfo clear() {
        clearInfoId();
        clearVoiceInfo();
        clearVoiceBroadType();
        clearPanel();
        clearRouteInfo();
        clearMainRoadNo();
        clearNewRoadNo();
        clearTextInfo();
        clearBlankingRouteIdx();
        clearNeedRemind();
        clearStartMark();
        clearEndMark();
        clearChoice();
        clearPriority();
        clearPointPair();
        clearYawSpeak();
        clearAcciRoutesInfo();
        clearJavirsActionInfo();
        clearTransPreferInfo();
        clearType();
        this.cachedSize = -1;
        return this;
    }

    public TransDynamicInfo clearAcciRoutesInfo() {
        this.hasAcciRoutesInfo = false;
        this.acciRoutesInfo_ = null;
        return this;
    }

    public TransDynamicInfo clearBlankingRouteIdx() {
        this.hasBlankingRouteIdx = false;
        this.blankingRouteIdx_ = a.f1216c;
        return this;
    }

    public TransDynamicInfo clearChoice() {
        this.choice_ = Collections.emptyList();
        return this;
    }

    public TransDynamicInfo clearEndMark() {
        this.hasEndMark = false;
        this.endMark_ = 0;
        return this;
    }

    public TransDynamicInfo clearInfoId() {
        this.hasInfoId = false;
        this.infoId_ = a.f1216c;
        return this;
    }

    public TransDynamicInfo clearJavirsActionInfo() {
        this.hasJavirsActionInfo = false;
        this.javirsActionInfo_ = null;
        return this;
    }

    public TransDynamicInfo clearMainRoadNo() {
        this.hasMainRoadNo = false;
        this.mainRoadNo_ = 0;
        return this;
    }

    public TransDynamicInfo clearNeedRemind() {
        this.hasNeedRemind = false;
        this.needRemind_ = 0;
        return this;
    }

    public TransDynamicInfo clearNewRoadNo() {
        this.hasNewRoadNo = false;
        this.newRoadNo_ = 0;
        return this;
    }

    public TransDynamicInfo clearPanel() {
        this.hasPanel = false;
        this.panel_ = null;
        return this;
    }

    public TransDynamicInfo clearPointPair() {
        this.pointPair_ = Collections.emptyList();
        return this;
    }

    public TransDynamicInfo clearPriority() {
        this.hasPriority = false;
        this.priority_ = 0;
        return this;
    }

    public TransDynamicInfo clearRouteInfo() {
        this.routeInfo_ = Collections.emptyList();
        return this;
    }

    public TransDynamicInfo clearStartMark() {
        this.hasStartMark = false;
        this.startMark_ = 0;
        return this;
    }

    public TransDynamicInfo clearTextInfo() {
        this.hasTextInfo = false;
        this.textInfo_ = a.f1216c;
        return this;
    }

    public TransDynamicInfo clearTransPreferInfo() {
        this.hasTransPreferInfo = false;
        this.transPreferInfo_ = null;
        return this;
    }

    public TransDynamicInfo clearType() {
        this.hasType = false;
        this.type_ = 0;
        return this;
    }

    public TransDynamicInfo clearVoiceBroadType() {
        this.hasVoiceBroadType = false;
        this.voiceBroadType_ = 0;
        return this;
    }

    public TransDynamicInfo clearVoiceInfo() {
        this.hasVoiceInfo = false;
        this.voiceInfo_ = null;
        return this;
    }

    public TransDynamicInfo clearYawSpeak() {
        this.hasYawSpeak = false;
        this.yawSpeak_ = a.f1216c;
        return this;
    }

    public TransRouteInfo getAcciRoutesInfo() {
        return this.acciRoutesInfo_;
    }

    public a getBlankingRouteIdx() {
        return this.blankingRouteIdx_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public TransPanel getChoice(int i4) {
        return this.choice_.get(i4);
    }

    public int getChoiceCount() {
        return this.choice_.size();
    }

    public List<TransPanel> getChoiceList() {
        return this.choice_;
    }

    public int getEndMark() {
        return this.endMark_;
    }

    public a getInfoId() {
        return this.infoId_;
    }

    public TransJavirsActionInfo getJavirsActionInfo() {
        return this.javirsActionInfo_;
    }

    public int getMainRoadNo() {
        return this.mainRoadNo_;
    }

    public int getNeedRemind() {
        return this.needRemind_;
    }

    public int getNewRoadNo() {
        return this.newRoadNo_;
    }

    public TransPanel getPanel() {
        return this.panel_;
    }

    public TransPanelPointPair getPointPair(int i4) {
        return this.pointPair_.get(i4);
    }

    public int getPointPairCount() {
        return this.pointPair_.size();
    }

    public List<TransPanelPointPair> getPointPairList() {
        return this.pointPair_;
    }

    public int getPriority() {
        return this.priority_;
    }

    public TransRouteInfo getRouteInfo(int i4) {
        return this.routeInfo_.get(i4);
    }

    public int getRouteInfoCount() {
        return this.routeInfo_.size();
    }

    public List<TransRouteInfo> getRouteInfoList() {
        return this.routeInfo_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iB = hasInfoId() ? d.b(1, getInfoId()) : 0;
        if (hasVoiceInfo()) {
            iB += d.h(2, getVoiceInfo());
        }
        if (hasVoiceBroadType()) {
            iB += d.e(3, getVoiceBroadType());
        }
        if (hasPanel()) {
            iB += d.h(4, getPanel());
        }
        Iterator<TransRouteInfo> it = getRouteInfoList().iterator();
        while (it.hasNext()) {
            iB += d.h(5, it.next());
        }
        if (hasMainRoadNo()) {
            iB += d.e(6, getMainRoadNo());
        }
        if (hasNewRoadNo()) {
            iB += d.e(7, getNewRoadNo());
        }
        if (hasTextInfo()) {
            iB += d.b(8, getTextInfo());
        }
        if (hasBlankingRouteIdx()) {
            iB += d.b(9, getBlankingRouteIdx());
        }
        if (hasNeedRemind()) {
            iB += d.e(10, getNeedRemind());
        }
        if (hasStartMark()) {
            iB += d.e(11, getStartMark());
        }
        if (hasEndMark()) {
            iB += d.e(12, getEndMark());
        }
        Iterator<TransPanel> it2 = getChoiceList().iterator();
        while (it2.hasNext()) {
            iB += d.h(13, it2.next());
        }
        if (hasPriority()) {
            iB += d.e(14, getPriority());
        }
        Iterator<TransPanelPointPair> it3 = getPointPairList().iterator();
        while (it3.hasNext()) {
            iB += d.h(15, it3.next());
        }
        if (hasYawSpeak()) {
            iB += d.b(16, getYawSpeak());
        }
        if (hasAcciRoutesInfo()) {
            iB += d.h(17, getAcciRoutesInfo());
        }
        if (hasJavirsActionInfo()) {
            iB += d.h(18, getJavirsActionInfo());
        }
        if (hasTransPreferInfo()) {
            iB += d.h(19, getTransPreferInfo());
        }
        if (hasType()) {
            iB += d.e(20, getType());
        }
        this.cachedSize = iB;
        return iB;
    }

    public int getStartMark() {
        return this.startMark_;
    }

    public a getTextInfo() {
        return this.textInfo_;
    }

    public TransPreferInfo getTransPreferInfo() {
        return this.transPreferInfo_;
    }

    public int getType() {
        return this.type_;
    }

    public int getVoiceBroadType() {
        return this.voiceBroadType_;
    }

    public TransVoiceInfo getVoiceInfo() {
        return this.voiceInfo_;
    }

    public a getYawSpeak() {
        return this.yawSpeak_;
    }

    public boolean hasAcciRoutesInfo() {
        return this.hasAcciRoutesInfo;
    }

    public boolean hasBlankingRouteIdx() {
        return this.hasBlankingRouteIdx;
    }

    public boolean hasEndMark() {
        return this.hasEndMark;
    }

    public boolean hasInfoId() {
        return this.hasInfoId;
    }

    public boolean hasJavirsActionInfo() {
        return this.hasJavirsActionInfo;
    }

    public boolean hasMainRoadNo() {
        return this.hasMainRoadNo;
    }

    public boolean hasNeedRemind() {
        return this.hasNeedRemind;
    }

    public boolean hasNewRoadNo() {
        return this.hasNewRoadNo;
    }

    public boolean hasPanel() {
        return this.hasPanel;
    }

    public boolean hasPriority() {
        return this.hasPriority;
    }

    public boolean hasStartMark() {
        return this.hasStartMark;
    }

    public boolean hasTextInfo() {
        return this.hasTextInfo;
    }

    public boolean hasTransPreferInfo() {
        return this.hasTransPreferInfo;
    }

    public boolean hasType() {
        return this.hasType;
    }

    public boolean hasVoiceBroadType() {
        return this.hasVoiceBroadType;
    }

    public boolean hasVoiceInfo() {
        return this.hasVoiceInfo;
    }

    public boolean hasYawSpeak() {
        return this.hasYawSpeak;
    }

    public final boolean isInitialized() {
        return !hasVoiceInfo() || getVoiceInfo().isInitialized();
    }

    public TransDynamicInfo setAcciRoutesInfo(TransRouteInfo transRouteInfo) {
        if (transRouteInfo == null) {
            return clearAcciRoutesInfo();
        }
        this.hasAcciRoutesInfo = true;
        this.acciRoutesInfo_ = transRouteInfo;
        return this;
    }

    public TransDynamicInfo setBlankingRouteIdx(a aVar) {
        this.hasBlankingRouteIdx = true;
        this.blankingRouteIdx_ = aVar;
        return this;
    }

    public TransDynamicInfo setChoice(int i4, TransPanel transPanel) {
        if (transPanel == null) {
            return this;
        }
        this.choice_.set(i4, transPanel);
        return this;
    }

    public TransDynamicInfo setEndMark(int i4) {
        this.hasEndMark = true;
        this.endMark_ = i4;
        return this;
    }

    public TransDynamicInfo setInfoId(a aVar) {
        this.hasInfoId = true;
        this.infoId_ = aVar;
        return this;
    }

    public TransDynamicInfo setJavirsActionInfo(TransJavirsActionInfo transJavirsActionInfo) {
        if (transJavirsActionInfo == null) {
            return clearJavirsActionInfo();
        }
        this.hasJavirsActionInfo = true;
        this.javirsActionInfo_ = transJavirsActionInfo;
        return this;
    }

    public TransDynamicInfo setMainRoadNo(int i4) {
        this.hasMainRoadNo = true;
        this.mainRoadNo_ = i4;
        return this;
    }

    public TransDynamicInfo setNeedRemind(int i4) {
        this.hasNeedRemind = true;
        this.needRemind_ = i4;
        return this;
    }

    public TransDynamicInfo setNewRoadNo(int i4) {
        this.hasNewRoadNo = true;
        this.newRoadNo_ = i4;
        return this;
    }

    public TransDynamicInfo setPanel(TransPanel transPanel) {
        if (transPanel == null) {
            return clearPanel();
        }
        this.hasPanel = true;
        this.panel_ = transPanel;
        return this;
    }

    public TransDynamicInfo setPointPair(int i4, TransPanelPointPair transPanelPointPair) {
        if (transPanelPointPair == null) {
            return this;
        }
        this.pointPair_.set(i4, transPanelPointPair);
        return this;
    }

    public TransDynamicInfo setPriority(int i4) {
        this.hasPriority = true;
        this.priority_ = i4;
        return this;
    }

    public TransDynamicInfo setRouteInfo(int i4, TransRouteInfo transRouteInfo) {
        if (transRouteInfo == null) {
            return this;
        }
        this.routeInfo_.set(i4, transRouteInfo);
        return this;
    }

    public TransDynamicInfo setStartMark(int i4) {
        this.hasStartMark = true;
        this.startMark_ = i4;
        return this;
    }

    public TransDynamicInfo setTextInfo(a aVar) {
        this.hasTextInfo = true;
        this.textInfo_ = aVar;
        return this;
    }

    public TransDynamicInfo setTransPreferInfo(TransPreferInfo transPreferInfo) {
        if (transPreferInfo == null) {
            return clearTransPreferInfo();
        }
        this.hasTransPreferInfo = true;
        this.transPreferInfo_ = transPreferInfo;
        return this;
    }

    public TransDynamicInfo setType(int i4) {
        this.hasType = true;
        this.type_ = i4;
        return this;
    }

    public TransDynamicInfo setVoiceBroadType(int i4) {
        this.hasVoiceBroadType = true;
        this.voiceBroadType_ = i4;
        return this;
    }

    public TransDynamicInfo setVoiceInfo(TransVoiceInfo transVoiceInfo) {
        if (transVoiceInfo == null) {
            return clearVoiceInfo();
        }
        this.hasVoiceInfo = true;
        this.voiceInfo_ = transVoiceInfo;
        return this;
    }

    public TransDynamicInfo setYawSpeak(a aVar) {
        this.hasYawSpeak = true;
        this.yawSpeak_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasInfoId()) {
            dVar.q(1, getInfoId());
        }
        if (hasVoiceInfo()) {
            dVar.u(2, getVoiceInfo());
        }
        if (hasVoiceBroadType()) {
            dVar.s(3, getVoiceBroadType());
        }
        if (hasPanel()) {
            dVar.u(4, getPanel());
        }
        Iterator<TransRouteInfo> it = getRouteInfoList().iterator();
        while (it.hasNext()) {
            dVar.u(5, it.next());
        }
        if (hasMainRoadNo()) {
            dVar.s(6, getMainRoadNo());
        }
        if (hasNewRoadNo()) {
            dVar.s(7, getNewRoadNo());
        }
        if (hasTextInfo()) {
            dVar.q(8, getTextInfo());
        }
        if (hasBlankingRouteIdx()) {
            dVar.q(9, getBlankingRouteIdx());
        }
        if (hasNeedRemind()) {
            dVar.s(10, getNeedRemind());
        }
        if (hasStartMark()) {
            dVar.s(11, getStartMark());
        }
        if (hasEndMark()) {
            dVar.s(12, getEndMark());
        }
        Iterator<TransPanel> it2 = getChoiceList().iterator();
        while (it2.hasNext()) {
            dVar.u(13, it2.next());
        }
        if (hasPriority()) {
            dVar.s(14, getPriority());
        }
        Iterator<TransPanelPointPair> it3 = getPointPairList().iterator();
        while (it3.hasNext()) {
            dVar.u(15, it3.next());
        }
        if (hasYawSpeak()) {
            dVar.q(16, getYawSpeak());
        }
        if (hasAcciRoutesInfo()) {
            dVar.u(17, getAcciRoutesInfo());
        }
        if (hasJavirsActionInfo()) {
            dVar.u(18, getJavirsActionInfo());
        }
        if (hasTransPreferInfo()) {
            dVar.u(19, getTransPreferInfo());
        }
        if (hasType()) {
            dVar.s(20, getType());
        }
    }

    public static TransDynamicInfo parseFrom(byte[] bArr) throws e {
        return (TransDynamicInfo) new TransDynamicInfo().mergeFrom(bArr);
    }

    @Override // L1.f
    public TransDynamicInfo mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            switch (iO) {
                case 0:
                    return this;
                case 10:
                    setInfoId(bVar.b());
                    break;
                case 18:
                    TransVoiceInfo transVoiceInfo = new TransVoiceInfo();
                    bVar.f(transVoiceInfo);
                    setVoiceInfo(transVoiceInfo);
                    break;
                case 24:
                    setVoiceBroadType(bVar.k());
                    break;
                case 34:
                    TransPanel transPanel = new TransPanel();
                    bVar.f(transPanel);
                    setPanel(transPanel);
                    break;
                case 42:
                    TransRouteInfo transRouteInfo = new TransRouteInfo();
                    bVar.f(transRouteInfo);
                    addRouteInfo(transRouteInfo);
                    break;
                case 48:
                    setMainRoadNo(bVar.k());
                    break;
                case 56:
                    setNewRoadNo(bVar.k());
                    break;
                case 66:
                    setTextInfo(bVar.b());
                    break;
                case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                    setBlankingRouteIdx(bVar.b());
                    break;
                case 80:
                    setNeedRemind(bVar.k());
                    break;
                case 88:
                    setStartMark(bVar.k());
                    break;
                case 96:
                    setEndMark(bVar.k());
                    break;
                case 106:
                    TransPanel transPanel2 = new TransPanel();
                    bVar.f(transPanel2);
                    addChoice(transPanel2);
                    break;
                case 112:
                    setPriority(bVar.k());
                    break;
                case 122:
                    TransPanelPointPair transPanelPointPair = new TransPanelPointPair();
                    bVar.f(transPanelPointPair);
                    addPointPair(transPanelPointPair);
                    break;
                case 130:
                    setYawSpeak(bVar.b());
                    break;
                case 138:
                    TransRouteInfo transRouteInfo2 = new TransRouteInfo();
                    bVar.f(transRouteInfo2);
                    setAcciRoutesInfo(transRouteInfo2);
                    break;
                case 146:
                    TransJavirsActionInfo transJavirsActionInfo = new TransJavirsActionInfo();
                    bVar.f(transJavirsActionInfo);
                    setJavirsActionInfo(transJavirsActionInfo);
                    break;
                case Opcodes.IFNE /* 154 */:
                    TransPreferInfo transPreferInfo = new TransPreferInfo();
                    bVar.f(transPreferInfo);
                    setTransPreferInfo(transPreferInfo);
                    break;
                case 160:
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
