package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class end_button_info extends f {
    public static final int BACKGROUND_COLOR_FIELD_NUMBER = 8;
    public static final int BORDER_COLOR_FIELD_NUMBER = 7;
    public static final int BTN_TITLE_FIELD_NUMBER = 1;
    public static final int CITYID_FIELD_NUMBER = 6;
    public static final int CNAME_FIELD_NUMBER = 5;
    public static final int END_INPUT_FIELD_NUMBER = 2;
    public static final int SHOW_POINT_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 4;
    private int backgroundColor_;
    private int borderColor_;
    private a btnTitle_;
    private int cachedSize;
    private int cityid_;
    private a cname_;
    private a endInput_;
    private boolean hasBackgroundColor;
    private boolean hasBorderColor;
    private boolean hasBtnTitle;
    private boolean hasCityid;
    private boolean hasCname;
    private boolean hasEndInput;
    private boolean hasShowPoint;
    private boolean hasUid;
    private yellow_tip_point showPoint_;
    private a uid_;

    public end_button_info() {
        a aVar = a.f1216c;
        this.btnTitle_ = aVar;
        this.endInput_ = aVar;
        this.showPoint_ = null;
        this.uid_ = aVar;
        this.cname_ = aVar;
        this.cityid_ = 0;
        this.borderColor_ = 0;
        this.backgroundColor_ = 0;
        this.cachedSize = -1;
    }

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
        this.btnTitle_ = a.f1216c;
        return this;
    }

    public end_button_info clearCityid() {
        this.hasCityid = false;
        this.cityid_ = 0;
        return this;
    }

    public end_button_info clearCname() {
        this.hasCname = false;
        this.cname_ = a.f1216c;
        return this;
    }

    public end_button_info clearEndInput() {
        this.hasEndInput = false;
        this.endInput_ = a.f1216c;
        return this;
    }

    public end_button_info clearShowPoint() {
        this.hasShowPoint = false;
        this.showPoint_ = null;
        return this;
    }

    public end_button_info clearUid() {
        this.hasUid = false;
        this.uid_ = a.f1216c;
        return this;
    }

    public int getBackgroundColor() {
        return this.backgroundColor_;
    }

    public int getBorderColor() {
        return this.borderColor_;
    }

    public a getBtnTitle() {
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

    public a getCname() {
        return this.cname_;
    }

    public a getEndInput() {
        return this.endInput_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iB = hasBtnTitle() ? d.b(1, getBtnTitle()) : 0;
        if (hasEndInput()) {
            iB += d.b(2, getEndInput());
        }
        if (hasShowPoint()) {
            iB += d.h(3, getShowPoint());
        }
        if (hasUid()) {
            iB += d.b(4, getUid());
        }
        if (hasCname()) {
            iB += d.b(5, getCname());
        }
        if (hasCityid()) {
            iB += d.e(6, getCityid());
        }
        if (hasBorderColor()) {
            iB += d.e(7, getBorderColor());
        }
        if (hasBackgroundColor()) {
            iB += d.e(8, getBackgroundColor());
        }
        this.cachedSize = iB;
        return iB;
    }

    public yellow_tip_point getShowPoint() {
        return this.showPoint_;
    }

    public a getUid() {
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
        return true;
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

    public end_button_info setBtnTitle(a aVar) {
        this.hasBtnTitle = true;
        this.btnTitle_ = aVar;
        return this;
    }

    public end_button_info setCityid(int i4) {
        this.hasCityid = true;
        this.cityid_ = i4;
        return this;
    }

    public end_button_info setCname(a aVar) {
        this.hasCname = true;
        this.cname_ = aVar;
        return this;
    }

    public end_button_info setEndInput(a aVar) {
        this.hasEndInput = true;
        this.endInput_ = aVar;
        return this;
    }

    public end_button_info setShowPoint(yellow_tip_point yellow_tip_pointVar) {
        if (yellow_tip_pointVar == null) {
            return clearShowPoint();
        }
        this.hasShowPoint = true;
        this.showPoint_ = yellow_tip_pointVar;
        return this;
    }

    public end_button_info setUid(a aVar) {
        this.hasUid = true;
        this.uid_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasBtnTitle()) {
            dVar.q(1, getBtnTitle());
        }
        if (hasEndInput()) {
            dVar.q(2, getEndInput());
        }
        if (hasShowPoint()) {
            dVar.u(3, getShowPoint());
        }
        if (hasUid()) {
            dVar.q(4, getUid());
        }
        if (hasCname()) {
            dVar.q(5, getCname());
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
                setBtnTitle(bVar.b());
            } else if (iO == 18) {
                setEndInput(bVar.b());
            } else if (iO == 26) {
                yellow_tip_point yellow_tip_pointVar = new yellow_tip_point();
                bVar.f(yellow_tip_pointVar);
                setShowPoint(yellow_tip_pointVar);
            } else if (iO == 34) {
                setUid(bVar.b());
            } else if (iO == 42) {
                setCname(bVar.b());
            } else if (iO == 48) {
                setCityid(bVar.d());
            } else if (iO == 56) {
                setBorderColor(bVar.d());
            } else if (iO == 64) {
                setBackgroundColor(bVar.d());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
