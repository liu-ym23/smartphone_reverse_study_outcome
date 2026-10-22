package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import com.baidu.entity.pb.PoiResult;
import java.io.IOException;

/* loaded from: classes.dex */
public final class TransRouteLabel extends f {
    public static final int AVOID_JAM_TIPS_FIELD_NUMBER = 5;
    public static final int BASE_MAP_TYPE_FIELD_NUMBER = 12;
    public static final int CONTENT_FIELD_NUMBER = 1;
    public static final int ICON_ID_FIELD_NUMBER = 11;
    public static final int LABEL_ORDER_FIELD_NUMBER = 8;
    public static final int LABEL_TYPE_FIELD_NUMBER = 10;
    public static final int SPEED_MARK_FIELD_NUMBER = 3;
    public static final int SUB_CONTENT_FIELD_NUMBER = 2;
    public static final int SWITCH_TIPS_FIELD_NUMBER = 4;
    public static final int TAB_CONTENT_FIELD_NUMBER = 9;
    public static final int THRESHOLD_FIELD_NUMBER = 6;
    public static final int TOLL_TIPS_FIELD_NUMBER = 7;
    public static final int VOICE_TEXT_FIELD_NUMBER = 13;
    public static final int VOICE_TEXT_SIMPLE_FIELD_NUMBER = 14;
    private a avoidJamTips_;
    private int baseMapType_;
    private int cachedSize;
    private a content_;
    private boolean hasAvoidJamTips;
    private boolean hasBaseMapType;
    private boolean hasContent;
    private boolean hasIconId;
    private boolean hasLabelOrder;
    private boolean hasLabelType;
    private boolean hasSpeedMark;
    private boolean hasSubContent;
    private boolean hasSwitchTips;
    private boolean hasTabContent;
    private boolean hasThreshold;
    private boolean hasTollTips;
    private boolean hasVoiceText;
    private boolean hasVoiceTextSimple;
    private a iconId_;
    private int labelOrder_;
    private int labelType_;
    private int speedMark_;
    private a subContent_;
    private a switchTips_;
    private a tabContent_;
    private int threshold_;
    private a tollTips_;
    private a voiceTextSimple_;
    private a voiceText_;

    public TransRouteLabel() {
        a aVar = a.f1216c;
        this.content_ = aVar;
        this.subContent_ = aVar;
        this.speedMark_ = 0;
        this.switchTips_ = aVar;
        this.avoidJamTips_ = aVar;
        this.threshold_ = -1;
        this.tollTips_ = aVar;
        this.labelOrder_ = 0;
        this.tabContent_ = aVar;
        this.labelType_ = 0;
        this.iconId_ = aVar;
        this.baseMapType_ = 0;
        this.voiceText_ = aVar;
        this.voiceTextSimple_ = aVar;
        this.cachedSize = -1;
    }

    public static TransRouteLabel parseFrom(b bVar) throws IOException {
        return new TransRouteLabel().mergeFrom(bVar);
    }

    public final TransRouteLabel clear() {
        clearContent();
        clearSubContent();
        clearSpeedMark();
        clearSwitchTips();
        clearAvoidJamTips();
        clearThreshold();
        clearTollTips();
        clearLabelOrder();
        clearTabContent();
        clearLabelType();
        clearIconId();
        clearBaseMapType();
        clearVoiceText();
        clearVoiceTextSimple();
        this.cachedSize = -1;
        return this;
    }

    public TransRouteLabel clearAvoidJamTips() {
        this.hasAvoidJamTips = false;
        this.avoidJamTips_ = a.f1216c;
        return this;
    }

    public TransRouteLabel clearBaseMapType() {
        this.hasBaseMapType = false;
        this.baseMapType_ = 0;
        return this;
    }

    public TransRouteLabel clearContent() {
        this.hasContent = false;
        this.content_ = a.f1216c;
        return this;
    }

    public TransRouteLabel clearIconId() {
        this.hasIconId = false;
        this.iconId_ = a.f1216c;
        return this;
    }

    public TransRouteLabel clearLabelOrder() {
        this.hasLabelOrder = false;
        this.labelOrder_ = 0;
        return this;
    }

    public TransRouteLabel clearLabelType() {
        this.hasLabelType = false;
        this.labelType_ = 0;
        return this;
    }

    public TransRouteLabel clearSpeedMark() {
        this.hasSpeedMark = false;
        this.speedMark_ = 0;
        return this;
    }

    public TransRouteLabel clearSubContent() {
        this.hasSubContent = false;
        this.subContent_ = a.f1216c;
        return this;
    }

    public TransRouteLabel clearSwitchTips() {
        this.hasSwitchTips = false;
        this.switchTips_ = a.f1216c;
        return this;
    }

    public TransRouteLabel clearTabContent() {
        this.hasTabContent = false;
        this.tabContent_ = a.f1216c;
        return this;
    }

    public TransRouteLabel clearThreshold() {
        this.hasThreshold = false;
        this.threshold_ = -1;
        return this;
    }

    public TransRouteLabel clearTollTips() {
        this.hasTollTips = false;
        this.tollTips_ = a.f1216c;
        return this;
    }

    public TransRouteLabel clearVoiceText() {
        this.hasVoiceText = false;
        this.voiceText_ = a.f1216c;
        return this;
    }

    public TransRouteLabel clearVoiceTextSimple() {
        this.hasVoiceTextSimple = false;
        this.voiceTextSimple_ = a.f1216c;
        return this;
    }

    public a getAvoidJamTips() {
        return this.avoidJamTips_;
    }

    public int getBaseMapType() {
        return this.baseMapType_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getContent() {
        return this.content_;
    }

    public a getIconId() {
        return this.iconId_;
    }

    public int getLabelOrder() {
        return this.labelOrder_;
    }

    public int getLabelType() {
        return this.labelType_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iB = hasContent() ? d.b(1, getContent()) : 0;
        if (hasSubContent()) {
            iB += d.b(2, getSubContent());
        }
        if (hasSpeedMark()) {
            iB += d.e(3, getSpeedMark());
        }
        if (hasSwitchTips()) {
            iB += d.b(4, getSwitchTips());
        }
        if (hasAvoidJamTips()) {
            iB += d.b(5, getAvoidJamTips());
        }
        if (hasThreshold()) {
            iB += d.e(6, getThreshold());
        }
        if (hasTollTips()) {
            iB += d.b(7, getTollTips());
        }
        if (hasLabelOrder()) {
            iB += d.e(8, getLabelOrder());
        }
        if (hasTabContent()) {
            iB += d.b(9, getTabContent());
        }
        if (hasLabelType()) {
            iB += d.e(10, getLabelType());
        }
        if (hasIconId()) {
            iB += d.b(11, getIconId());
        }
        if (hasBaseMapType()) {
            iB += d.e(12, getBaseMapType());
        }
        if (hasVoiceText()) {
            iB += d.b(13, getVoiceText());
        }
        if (hasVoiceTextSimple()) {
            iB += d.b(14, getVoiceTextSimple());
        }
        this.cachedSize = iB;
        return iB;
    }

    public int getSpeedMark() {
        return this.speedMark_;
    }

    public a getSubContent() {
        return this.subContent_;
    }

    public a getSwitchTips() {
        return this.switchTips_;
    }

    public a getTabContent() {
        return this.tabContent_;
    }

    public int getThreshold() {
        return this.threshold_;
    }

    public a getTollTips() {
        return this.tollTips_;
    }

    public a getVoiceText() {
        return this.voiceText_;
    }

    public a getVoiceTextSimple() {
        return this.voiceTextSimple_;
    }

    public boolean hasAvoidJamTips() {
        return this.hasAvoidJamTips;
    }

    public boolean hasBaseMapType() {
        return this.hasBaseMapType;
    }

    public boolean hasContent() {
        return this.hasContent;
    }

    public boolean hasIconId() {
        return this.hasIconId;
    }

    public boolean hasLabelOrder() {
        return this.hasLabelOrder;
    }

    public boolean hasLabelType() {
        return this.hasLabelType;
    }

    public boolean hasSpeedMark() {
        return this.hasSpeedMark;
    }

    public boolean hasSubContent() {
        return this.hasSubContent;
    }

    public boolean hasSwitchTips() {
        return this.hasSwitchTips;
    }

    public boolean hasTabContent() {
        return this.hasTabContent;
    }

    public boolean hasThreshold() {
        return this.hasThreshold;
    }

    public boolean hasTollTips() {
        return this.hasTollTips;
    }

    public boolean hasVoiceText() {
        return this.hasVoiceText;
    }

    public boolean hasVoiceTextSimple() {
        return this.hasVoiceTextSimple;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TransRouteLabel setAvoidJamTips(a aVar) {
        this.hasAvoidJamTips = true;
        this.avoidJamTips_ = aVar;
        return this;
    }

    public TransRouteLabel setBaseMapType(int i4) {
        this.hasBaseMapType = true;
        this.baseMapType_ = i4;
        return this;
    }

    public TransRouteLabel setContent(a aVar) {
        this.hasContent = true;
        this.content_ = aVar;
        return this;
    }

    public TransRouteLabel setIconId(a aVar) {
        this.hasIconId = true;
        this.iconId_ = aVar;
        return this;
    }

    public TransRouteLabel setLabelOrder(int i4) {
        this.hasLabelOrder = true;
        this.labelOrder_ = i4;
        return this;
    }

    public TransRouteLabel setLabelType(int i4) {
        this.hasLabelType = true;
        this.labelType_ = i4;
        return this;
    }

    public TransRouteLabel setSpeedMark(int i4) {
        this.hasSpeedMark = true;
        this.speedMark_ = i4;
        return this;
    }

    public TransRouteLabel setSubContent(a aVar) {
        this.hasSubContent = true;
        this.subContent_ = aVar;
        return this;
    }

    public TransRouteLabel setSwitchTips(a aVar) {
        this.hasSwitchTips = true;
        this.switchTips_ = aVar;
        return this;
    }

    public TransRouteLabel setTabContent(a aVar) {
        this.hasTabContent = true;
        this.tabContent_ = aVar;
        return this;
    }

    public TransRouteLabel setThreshold(int i4) {
        this.hasThreshold = true;
        this.threshold_ = i4;
        return this;
    }

    public TransRouteLabel setTollTips(a aVar) {
        this.hasTollTips = true;
        this.tollTips_ = aVar;
        return this;
    }

    public TransRouteLabel setVoiceText(a aVar) {
        this.hasVoiceText = true;
        this.voiceText_ = aVar;
        return this;
    }

    public TransRouteLabel setVoiceTextSimple(a aVar) {
        this.hasVoiceTextSimple = true;
        this.voiceTextSimple_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasContent()) {
            dVar.q(1, getContent());
        }
        if (hasSubContent()) {
            dVar.q(2, getSubContent());
        }
        if (hasSpeedMark()) {
            dVar.s(3, getSpeedMark());
        }
        if (hasSwitchTips()) {
            dVar.q(4, getSwitchTips());
        }
        if (hasAvoidJamTips()) {
            dVar.q(5, getAvoidJamTips());
        }
        if (hasThreshold()) {
            dVar.s(6, getThreshold());
        }
        if (hasTollTips()) {
            dVar.q(7, getTollTips());
        }
        if (hasLabelOrder()) {
            dVar.s(8, getLabelOrder());
        }
        if (hasTabContent()) {
            dVar.q(9, getTabContent());
        }
        if (hasLabelType()) {
            dVar.s(10, getLabelType());
        }
        if (hasIconId()) {
            dVar.q(11, getIconId());
        }
        if (hasBaseMapType()) {
            dVar.s(12, getBaseMapType());
        }
        if (hasVoiceText()) {
            dVar.q(13, getVoiceText());
        }
        if (hasVoiceTextSimple()) {
            dVar.q(14, getVoiceTextSimple());
        }
    }

    public static TransRouteLabel parseFrom(byte[] bArr) throws e {
        return (TransRouteLabel) new TransRouteLabel().mergeFrom(bArr);
    }

    @Override // L1.f
    public TransRouteLabel mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            switch (iO) {
                case 0:
                    return this;
                case 10:
                    setContent(bVar.b());
                    break;
                case 18:
                    setSubContent(bVar.b());
                    break;
                case 24:
                    setSpeedMark(bVar.k());
                    break;
                case 34:
                    setSwitchTips(bVar.b());
                    break;
                case 42:
                    setAvoidJamTips(bVar.b());
                    break;
                case 48:
                    setThreshold(bVar.k());
                    break;
                case 58:
                    setTollTips(bVar.b());
                    break;
                case 64:
                    setLabelOrder(bVar.k());
                    break;
                case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                    setTabContent(bVar.b());
                    break;
                case 80:
                    setLabelType(bVar.k());
                    break;
                case 90:
                    setIconId(bVar.b());
                    break;
                case 96:
                    setBaseMapType(bVar.k());
                    break;
                case 106:
                    setVoiceText(bVar.b());
                    break;
                case 114:
                    setVoiceTextSimple(bVar.b());
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
