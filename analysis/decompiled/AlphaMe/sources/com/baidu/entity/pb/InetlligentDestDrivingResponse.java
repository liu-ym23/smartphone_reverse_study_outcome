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
public final class InetlligentDestDrivingResponse extends f {
    public static final int DEST_REC_INFO_FIELD_NUMBER = 2;
    public static final int ERR_NO_FIELD_NUMBER = 1;
    public static final int FIRST_PARKING_SPACE_FIELD_NUMBER = 4;
    public static final int PGUIDING_TRIGGER_DIST_FIELD_NUMBER = 3;
    private boolean hasDestRecInfo;
    private boolean hasErrNo;
    private boolean hasPguidingTriggerDist;
    private int errNo_ = 0;
    private a destRecInfo_ = a.f1216c;
    private int pguidingTriggerDist_ = 0;
    private List<FirstParkingSpace> firstParkingSpace_ = Collections.emptyList();
    private int cachedSize = -1;

    public static InetlligentDestDrivingResponse parseFrom(b bVar) throws IOException {
        return new InetlligentDestDrivingResponse().mergeFrom(bVar);
    }

    public InetlligentDestDrivingResponse addFirstParkingSpace(FirstParkingSpace firstParkingSpace) {
        if (firstParkingSpace == null) {
            return this;
        }
        if (this.firstParkingSpace_.isEmpty()) {
            this.firstParkingSpace_ = new ArrayList();
        }
        this.firstParkingSpace_.add(firstParkingSpace);
        return this;
    }

    public final InetlligentDestDrivingResponse clear() {
        clearErrNo();
        clearDestRecInfo();
        clearPguidingTriggerDist();
        clearFirstParkingSpace();
        this.cachedSize = -1;
        return this;
    }

    public InetlligentDestDrivingResponse clearDestRecInfo() {
        this.hasDestRecInfo = false;
        this.destRecInfo_ = a.f1216c;
        return this;
    }

    public InetlligentDestDrivingResponse clearErrNo() {
        this.hasErrNo = false;
        this.errNo_ = 0;
        return this;
    }

    public InetlligentDestDrivingResponse clearFirstParkingSpace() {
        this.firstParkingSpace_ = Collections.emptyList();
        return this;
    }

    public InetlligentDestDrivingResponse clearPguidingTriggerDist() {
        this.hasPguidingTriggerDist = false;
        this.pguidingTriggerDist_ = 0;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getDestRecInfo() {
        return this.destRecInfo_;
    }

    public int getErrNo() {
        return this.errNo_;
    }

    public FirstParkingSpace getFirstParkingSpace(int i4) {
        return this.firstParkingSpace_.get(i4);
    }

    public int getFirstParkingSpaceCount() {
        return this.firstParkingSpace_.size();
    }

    public List<FirstParkingSpace> getFirstParkingSpaceList() {
        return this.firstParkingSpace_;
    }

    public int getPguidingTriggerDist() {
        return this.pguidingTriggerDist_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasErrNo() ? d.e(1, getErrNo()) : 0;
        if (hasDestRecInfo()) {
            iE += d.b(2, getDestRecInfo());
        }
        if (hasPguidingTriggerDist()) {
            iE += d.e(3, getPguidingTriggerDist());
        }
        Iterator<FirstParkingSpace> it = getFirstParkingSpaceList().iterator();
        while (it.hasNext()) {
            iE += d.h(4, it.next());
        }
        this.cachedSize = iE;
        return iE;
    }

    public boolean hasDestRecInfo() {
        return this.hasDestRecInfo;
    }

    public boolean hasErrNo() {
        return this.hasErrNo;
    }

    public boolean hasPguidingTriggerDist() {
        return this.hasPguidingTriggerDist;
    }

    public final boolean isInitialized() {
        Iterator<FirstParkingSpace> it = getFirstParkingSpaceList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public InetlligentDestDrivingResponse setDestRecInfo(a aVar) {
        this.hasDestRecInfo = true;
        this.destRecInfo_ = aVar;
        return this;
    }

    public InetlligentDestDrivingResponse setErrNo(int i4) {
        this.hasErrNo = true;
        this.errNo_ = i4;
        return this;
    }

    public InetlligentDestDrivingResponse setFirstParkingSpace(int i4, FirstParkingSpace firstParkingSpace) {
        if (firstParkingSpace == null) {
            return this;
        }
        this.firstParkingSpace_.set(i4, firstParkingSpace);
        return this;
    }

    public InetlligentDestDrivingResponse setPguidingTriggerDist(int i4) {
        this.hasPguidingTriggerDist = true;
        this.pguidingTriggerDist_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasErrNo()) {
            dVar.s(1, getErrNo());
        }
        if (hasDestRecInfo()) {
            dVar.q(2, getDestRecInfo());
        }
        if (hasPguidingTriggerDist()) {
            dVar.s(3, getPguidingTriggerDist());
        }
        Iterator<FirstParkingSpace> it = getFirstParkingSpaceList().iterator();
        while (it.hasNext()) {
            dVar.u(4, it.next());
        }
    }

    public static InetlligentDestDrivingResponse parseFrom(byte[] bArr) throws e {
        return (InetlligentDestDrivingResponse) new InetlligentDestDrivingResponse().mergeFrom(bArr);
    }

    @Override // L1.f
    public InetlligentDestDrivingResponse mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setErrNo(bVar.d());
            } else if (iO == 18) {
                setDestRecInfo(bVar.b());
            } else if (iO == 24) {
                setPguidingTriggerDist(bVar.d());
            } else if (iO == 34) {
                FirstParkingSpace firstParkingSpace = new FirstParkingSpace();
                bVar.f(firstParkingSpace);
                addFirstParkingSpace(firstParkingSpace);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
