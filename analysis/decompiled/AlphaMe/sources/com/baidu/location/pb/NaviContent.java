package com.baidu.location.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class NaviContent extends f {
    public static final int CTL_FIELD_NUMBER = 4;
    public static final int ETA_FIELD_NUMBER = 5;
    public static final int INFO_FIELD_NUMBER = 3;
    public static final int OUTTYPE_FIELD_NUMBER = 2;
    public static final int OUT_FIELD_NUMBER = 1;
    public static final int VUI_FIELD_NUMBER = 6;
    private int cachedSize;
    private a ctl_;
    private a eta_;
    private boolean hasCtl;
    private boolean hasEta;
    private boolean hasInfo;
    private boolean hasOut;
    private boolean hasOuttype;
    private boolean hasVui;
    private a info_;
    private a out_;
    private String outtype_;
    private a vui_;

    public NaviContent() {
        a aVar = a.f1216c;
        this.out_ = aVar;
        this.outtype_ = "";
        this.info_ = aVar;
        this.ctl_ = aVar;
        this.eta_ = aVar;
        this.vui_ = aVar;
        this.cachedSize = -1;
    }

    public static NaviContent parseFrom(b bVar) throws IOException {
        return new NaviContent().mergeFrom(bVar);
    }

    public final NaviContent clear() {
        clearOut();
        clearOuttype();
        clearInfo();
        clearCtl();
        clearEta();
        clearVui();
        this.cachedSize = -1;
        return this;
    }

    public NaviContent clearCtl() {
        this.hasCtl = false;
        this.ctl_ = a.f1216c;
        return this;
    }

    public NaviContent clearEta() {
        this.hasEta = false;
        this.eta_ = a.f1216c;
        return this;
    }

    public NaviContent clearInfo() {
        this.hasInfo = false;
        this.info_ = a.f1216c;
        return this;
    }

    public NaviContent clearOut() {
        this.hasOut = false;
        this.out_ = a.f1216c;
        return this;
    }

    public NaviContent clearOuttype() {
        this.hasOuttype = false;
        this.outtype_ = "";
        return this;
    }

    public NaviContent clearVui() {
        this.hasVui = false;
        this.vui_ = a.f1216c;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getCtl() {
        return this.ctl_;
    }

    public a getEta() {
        return this.eta_;
    }

    public a getInfo() {
        return this.info_;
    }

    public a getOut() {
        return this.out_;
    }

    public String getOuttype() {
        return this.outtype_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iB = hasOut() ? d.b(1, getOut()) : 0;
        if (hasOuttype()) {
            iB += d.l(2, getOuttype());
        }
        if (hasInfo()) {
            iB += d.b(3, getInfo());
        }
        if (hasCtl()) {
            iB += d.b(4, getCtl());
        }
        if (hasEta()) {
            iB += d.b(5, getEta());
        }
        if (hasVui()) {
            iB += d.b(6, getVui());
        }
        this.cachedSize = iB;
        return iB;
    }

    public a getVui() {
        return this.vui_;
    }

    public boolean hasCtl() {
        return this.hasCtl;
    }

    public boolean hasEta() {
        return this.hasEta;
    }

    public boolean hasInfo() {
        return this.hasInfo;
    }

    public boolean hasOut() {
        return this.hasOut;
    }

    public boolean hasOuttype() {
        return this.hasOuttype;
    }

    public boolean hasVui() {
        return this.hasVui;
    }

    public final boolean isInitialized() {
        return true;
    }

    public NaviContent setCtl(a aVar) {
        this.hasCtl = true;
        this.ctl_ = aVar;
        return this;
    }

    public NaviContent setEta(a aVar) {
        this.hasEta = true;
        this.eta_ = aVar;
        return this;
    }

    public NaviContent setInfo(a aVar) {
        this.hasInfo = true;
        this.info_ = aVar;
        return this;
    }

    public NaviContent setOut(a aVar) {
        this.hasOut = true;
        this.out_ = aVar;
        return this;
    }

    public NaviContent setOuttype(String str) {
        this.hasOuttype = true;
        this.outtype_ = str;
        return this;
    }

    public NaviContent setVui(a aVar) {
        this.hasVui = true;
        this.vui_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasOut()) {
            dVar.q(1, getOut());
        }
        if (hasOuttype()) {
            dVar.A(2, getOuttype());
        }
        if (hasInfo()) {
            dVar.q(3, getInfo());
        }
        if (hasCtl()) {
            dVar.q(4, getCtl());
        }
        if (hasEta()) {
            dVar.q(5, getEta());
        }
        if (hasVui()) {
            dVar.q(6, getVui());
        }
    }

    public static NaviContent parseFrom(byte[] bArr) throws e {
        return (NaviContent) new NaviContent().mergeFrom(bArr);
    }

    @Override // L1.f
    public NaviContent mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                setOut(bVar.b());
            } else if (iO == 18) {
                setOuttype(bVar.n());
            } else if (iO == 26) {
                setInfo(bVar.b());
            } else if (iO == 34) {
                setCtl(bVar.b());
            } else if (iO == 42) {
                setEta(bVar.b());
            } else if (iO == 50) {
                setVui(bVar.b());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
