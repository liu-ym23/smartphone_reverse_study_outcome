package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class DestDrivingRecInfo extends f {
    public static final int BOARD_ITEMS_FIELD_NUMBER = 5;
    public static final int BROADCAST_CONTENT_FIELD_NUMBER = 4;
    public static final int RECT_BOARD_ITEMS_FIELD_NUMBER = 7;
    public static final int REC_PARKING_TEXT_FIELD_NUMBER = 3;
    public static final int SCENE_TYPE_FIELD_NUMBER = 1;
    public static final int TAB_POI_INFO_FIELD_NUMBER = 2;
    public static final int TRANSHIP_INFO_FIELD_NUMBER = 6;
    private List<DestItems> boardItems_;
    private a broadcastContent_;
    private int cachedSize;
    private boolean hasBroadcastContent;
    private boolean hasRecParkingText;
    private boolean hasSceneType;
    private boolean hasTranshipInfo;
    private a recParkingText_;
    private List<RectBoard> rectBoardItems_;
    private int sceneType_ = 1;
    private List<TabPoiInfo> tabPoiInfo_ = Collections.emptyList();
    private TranshipInfo transhipInfo_;

    public DestDrivingRecInfo() {
        a aVar = a.f1216c;
        this.recParkingText_ = aVar;
        this.broadcastContent_ = aVar;
        this.boardItems_ = Collections.emptyList();
        this.transhipInfo_ = null;
        this.rectBoardItems_ = Collections.emptyList();
        this.cachedSize = -1;
    }

    public static DestDrivingRecInfo parseFrom(b bVar) throws IOException {
        return new DestDrivingRecInfo().mergeFrom(bVar);
    }

    public DestDrivingRecInfo addBoardItems(DestItems destItems) {
        if (destItems == null) {
            return this;
        }
        if (this.boardItems_.isEmpty()) {
            this.boardItems_ = new ArrayList();
        }
        this.boardItems_.add(destItems);
        return this;
    }

    public DestDrivingRecInfo addRectBoardItems(RectBoard rectBoard) {
        if (rectBoard == null) {
            return this;
        }
        if (this.rectBoardItems_.isEmpty()) {
            this.rectBoardItems_ = new ArrayList();
        }
        this.rectBoardItems_.add(rectBoard);
        return this;
    }

    public DestDrivingRecInfo addTabPoiInfo(TabPoiInfo tabPoiInfo) {
        if (tabPoiInfo == null) {
            return this;
        }
        if (this.tabPoiInfo_.isEmpty()) {
            this.tabPoiInfo_ = new ArrayList();
        }
        this.tabPoiInfo_.add(tabPoiInfo);
        return this;
    }

    public final DestDrivingRecInfo clear() {
        clearSceneType();
        clearTabPoiInfo();
        clearRecParkingText();
        clearBroadcastContent();
        clearBoardItems();
        clearTranshipInfo();
        clearRectBoardItems();
        this.cachedSize = -1;
        return this;
    }

    public DestDrivingRecInfo clearBoardItems() {
        this.boardItems_ = Collections.emptyList();
        return this;
    }

    public DestDrivingRecInfo clearBroadcastContent() {
        this.hasBroadcastContent = false;
        this.broadcastContent_ = a.f1216c;
        return this;
    }

    public DestDrivingRecInfo clearRecParkingText() {
        this.hasRecParkingText = false;
        this.recParkingText_ = a.f1216c;
        return this;
    }

    public DestDrivingRecInfo clearRectBoardItems() {
        this.rectBoardItems_ = Collections.emptyList();
        return this;
    }

    public DestDrivingRecInfo clearSceneType() {
        this.hasSceneType = false;
        this.sceneType_ = 1;
        return this;
    }

    public DestDrivingRecInfo clearTabPoiInfo() {
        this.tabPoiInfo_ = Collections.emptyList();
        return this;
    }

    public DestDrivingRecInfo clearTranshipInfo() {
        this.hasTranshipInfo = false;
        this.transhipInfo_ = null;
        return this;
    }

    public DestItems getBoardItems(int i4) {
        return this.boardItems_.get(i4);
    }

    public int getBoardItemsCount() {
        return this.boardItems_.size();
    }

    public List<DestItems> getBoardItemsList() {
        return this.boardItems_;
    }

    public a getBroadcastContent() {
        return this.broadcastContent_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getRecParkingText() {
        return this.recParkingText_;
    }

    public RectBoard getRectBoardItems(int i4) {
        return this.rectBoardItems_.get(i4);
    }

    public int getRectBoardItemsCount() {
        return this.rectBoardItems_.size();
    }

    public List<RectBoard> getRectBoardItemsList() {
        return this.rectBoardItems_;
    }

    public int getSceneType() {
        return this.sceneType_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasSceneType() ? d.e(1, getSceneType()) : 0;
        Iterator<TabPoiInfo> it = getTabPoiInfoList().iterator();
        while (it.hasNext()) {
            iE += d.h(2, it.next());
        }
        if (hasRecParkingText()) {
            iE += d.b(3, getRecParkingText());
        }
        if (hasBroadcastContent()) {
            iE += d.b(4, getBroadcastContent());
        }
        Iterator<DestItems> it2 = getBoardItemsList().iterator();
        while (it2.hasNext()) {
            iE += d.h(5, it2.next());
        }
        if (hasTranshipInfo()) {
            iE += d.h(6, getTranshipInfo());
        }
        Iterator<RectBoard> it3 = getRectBoardItemsList().iterator();
        while (it3.hasNext()) {
            iE += d.h(7, it3.next());
        }
        this.cachedSize = iE;
        return iE;
    }

    public TabPoiInfo getTabPoiInfo(int i4) {
        return this.tabPoiInfo_.get(i4);
    }

    public int getTabPoiInfoCount() {
        return this.tabPoiInfo_.size();
    }

    public List<TabPoiInfo> getTabPoiInfoList() {
        return this.tabPoiInfo_;
    }

    public TranshipInfo getTranshipInfo() {
        return this.transhipInfo_;
    }

    public boolean hasBroadcastContent() {
        return this.hasBroadcastContent;
    }

    public boolean hasRecParkingText() {
        return this.hasRecParkingText;
    }

    public boolean hasSceneType() {
        return this.hasSceneType;
    }

    public boolean hasTranshipInfo() {
        return this.hasTranshipInfo;
    }

    public final boolean isInitialized() {
        Iterator<TabPoiInfo> it = getTabPoiInfoList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return !hasTranshipInfo() || getTranshipInfo().isInitialized();
    }

    public DestDrivingRecInfo setBoardItems(int i4, DestItems destItems) {
        if (destItems == null) {
            return this;
        }
        this.boardItems_.set(i4, destItems);
        return this;
    }

    public DestDrivingRecInfo setBroadcastContent(a aVar) {
        this.hasBroadcastContent = true;
        this.broadcastContent_ = aVar;
        return this;
    }

    public DestDrivingRecInfo setRecParkingText(a aVar) {
        this.hasRecParkingText = true;
        this.recParkingText_ = aVar;
        return this;
    }

    public DestDrivingRecInfo setRectBoardItems(int i4, RectBoard rectBoard) {
        if (rectBoard == null) {
            return this;
        }
        this.rectBoardItems_.set(i4, rectBoard);
        return this;
    }

    public DestDrivingRecInfo setSceneType(int i4) {
        this.hasSceneType = true;
        this.sceneType_ = i4;
        return this;
    }

    public DestDrivingRecInfo setTabPoiInfo(int i4, TabPoiInfo tabPoiInfo) {
        if (tabPoiInfo == null) {
            return this;
        }
        this.tabPoiInfo_.set(i4, tabPoiInfo);
        return this;
    }

    public DestDrivingRecInfo setTranshipInfo(TranshipInfo transhipInfo) {
        if (transhipInfo == null) {
            return clearTranshipInfo();
        }
        this.hasTranshipInfo = true;
        this.transhipInfo_ = transhipInfo;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasSceneType()) {
            dVar.s(1, getSceneType());
        }
        Iterator<TabPoiInfo> it = getTabPoiInfoList().iterator();
        while (it.hasNext()) {
            dVar.u(2, it.next());
        }
        if (hasRecParkingText()) {
            dVar.q(3, getRecParkingText());
        }
        if (hasBroadcastContent()) {
            dVar.q(4, getBroadcastContent());
        }
        Iterator<DestItems> it2 = getBoardItemsList().iterator();
        while (it2.hasNext()) {
            dVar.u(5, it2.next());
        }
        if (hasTranshipInfo()) {
            dVar.u(6, getTranshipInfo());
        }
        Iterator<RectBoard> it3 = getRectBoardItemsList().iterator();
        while (it3.hasNext()) {
            dVar.u(7, it3.next());
        }
    }

    public static DestDrivingRecInfo parseFrom(byte[] bArr) throws e {
        return (DestDrivingRecInfo) new DestDrivingRecInfo().mergeFrom(bArr);
    }

    @Override // L1.f
    public DestDrivingRecInfo mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setSceneType(bVar.d());
            } else if (iO == 18) {
                TabPoiInfo tabPoiInfo = new TabPoiInfo();
                bVar.f(tabPoiInfo);
                addTabPoiInfo(tabPoiInfo);
            } else if (iO == 26) {
                setRecParkingText(bVar.b());
            } else if (iO == 34) {
                setBroadcastContent(bVar.b());
            } else if (iO == 42) {
                DestItems destItems = new DestItems();
                bVar.f(destItems);
                addBoardItems(destItems);
            } else if (iO == 50) {
                TranshipInfo transhipInfo = new TranshipInfo();
                bVar.f(transhipInfo);
                setTranshipInfo(transhipInfo);
            } else if (iO == 58) {
                RectBoard rectBoard = new RectBoard();
                bVar.f(rectBoard);
                addRectBoardItems(rectBoard);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
