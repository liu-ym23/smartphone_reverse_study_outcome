package com.baidu.location.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class LinkAttrt extends f {
    public static final int ATTR_FIELD_NUMBER = 6;
    public static final int DIREC_FIELD_NUMBER = 5;
    public static final int ENODE_ID_FIELD_NUMBER = 2;
    public static final int GEO_FIELD_NUMBER = 7;
    public static final int LENGTH_FIELD_NUMBER = 4;
    public static final int LEVEL_FIELD_NUMBER = 3;
    public static final int PARKING_FLOOR_FIELD_NUMBER = 8;
    public static final int PARKING_THEME_FIELD_NUMBER = 9;
    public static final int SNODE_ID_FIELD_NUMBER = 1;
    private int cachedSize;
    private a geo_;
    private boolean hasAttr;
    private boolean hasDirec;
    private boolean hasEnodeId;
    private boolean hasGeo;
    private boolean hasLength;
    private boolean hasLevel;
    private boolean hasParkingFloor;
    private boolean hasParkingTheme;
    private boolean hasSnodeId;
    private a parkingFloor_;
    private int parkingTheme_;
    private int snodeId_ = 0;
    private int enodeId_ = 0;
    private int level_ = 0;
    private int length_ = 0;
    private int direc_ = 0;
    private int attr_ = 0;

    public LinkAttrt() {
        a aVar = a.f1216c;
        this.geo_ = aVar;
        this.parkingFloor_ = aVar;
        this.parkingTheme_ = 0;
        this.cachedSize = -1;
    }

    public static LinkAttrt parseFrom(b bVar) throws IOException {
        return new LinkAttrt().mergeFrom(bVar);
    }

    public final LinkAttrt clear() {
        clearSnodeId();
        clearEnodeId();
        clearLevel();
        clearLength();
        clearDirec();
        clearAttr();
        clearGeo();
        clearParkingFloor();
        clearParkingTheme();
        this.cachedSize = -1;
        return this;
    }

    public LinkAttrt clearAttr() {
        this.hasAttr = false;
        this.attr_ = 0;
        return this;
    }

    public LinkAttrt clearDirec() {
        this.hasDirec = false;
        this.direc_ = 0;
        return this;
    }

    public LinkAttrt clearEnodeId() {
        this.hasEnodeId = false;
        this.enodeId_ = 0;
        return this;
    }

    public LinkAttrt clearGeo() {
        this.hasGeo = false;
        this.geo_ = a.f1216c;
        return this;
    }

    public LinkAttrt clearLength() {
        this.hasLength = false;
        this.length_ = 0;
        return this;
    }

    public LinkAttrt clearLevel() {
        this.hasLevel = false;
        this.level_ = 0;
        return this;
    }

    public LinkAttrt clearParkingFloor() {
        this.hasParkingFloor = false;
        this.parkingFloor_ = a.f1216c;
        return this;
    }

    public LinkAttrt clearParkingTheme() {
        this.hasParkingTheme = false;
        this.parkingTheme_ = 0;
        return this;
    }

    public LinkAttrt clearSnodeId() {
        this.hasSnodeId = false;
        this.snodeId_ = 0;
        return this;
    }

    public int getAttr() {
        return this.attr_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getDirec() {
        return this.direc_;
    }

    public int getEnodeId() {
        return this.enodeId_;
    }

    public a getGeo() {
        return this.geo_;
    }

    public int getLength() {
        return this.length_;
    }

    public int getLevel() {
        return this.level_;
    }

    public a getParkingFloor() {
        return this.parkingFloor_;
    }

    public int getParkingTheme() {
        return this.parkingTheme_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iO = hasSnodeId() ? d.o(1, getSnodeId()) : 0;
        if (hasEnodeId()) {
            iO += d.o(2, getEnodeId());
        }
        if (hasLevel()) {
            iO += d.o(3, getLevel());
        }
        if (hasLength()) {
            iO += d.o(4, getLength());
        }
        if (hasDirec()) {
            iO += d.o(5, getDirec());
        }
        if (hasAttr()) {
            iO += d.o(6, getAttr());
        }
        if (hasGeo()) {
            iO += d.b(7, getGeo());
        }
        if (hasParkingFloor()) {
            iO += d.b(8, getParkingFloor());
        }
        if (hasParkingTheme()) {
            iO += d.e(9, getParkingTheme());
        }
        this.cachedSize = iO;
        return iO;
    }

    public int getSnodeId() {
        return this.snodeId_;
    }

    public boolean hasAttr() {
        return this.hasAttr;
    }

    public boolean hasDirec() {
        return this.hasDirec;
    }

    public boolean hasEnodeId() {
        return this.hasEnodeId;
    }

    public boolean hasGeo() {
        return this.hasGeo;
    }

    public boolean hasLength() {
        return this.hasLength;
    }

    public boolean hasLevel() {
        return this.hasLevel;
    }

    public boolean hasParkingFloor() {
        return this.hasParkingFloor;
    }

    public boolean hasParkingTheme() {
        return this.hasParkingTheme;
    }

    public boolean hasSnodeId() {
        return this.hasSnodeId;
    }

    public final boolean isInitialized() {
        return this.hasSnodeId && this.hasEnodeId && this.hasLevel && this.hasLength && this.hasDirec && this.hasGeo;
    }

    public LinkAttrt setAttr(int i4) {
        this.hasAttr = true;
        this.attr_ = i4;
        return this;
    }

    public LinkAttrt setDirec(int i4) {
        this.hasDirec = true;
        this.direc_ = i4;
        return this;
    }

    public LinkAttrt setEnodeId(int i4) {
        this.hasEnodeId = true;
        this.enodeId_ = i4;
        return this;
    }

    public LinkAttrt setGeo(a aVar) {
        this.hasGeo = true;
        this.geo_ = aVar;
        return this;
    }

    public LinkAttrt setLength(int i4) {
        this.hasLength = true;
        this.length_ = i4;
        return this;
    }

    public LinkAttrt setLevel(int i4) {
        this.hasLevel = true;
        this.level_ = i4;
        return this;
    }

    public LinkAttrt setParkingFloor(a aVar) {
        this.hasParkingFloor = true;
        this.parkingFloor_ = aVar;
        return this;
    }

    public LinkAttrt setParkingTheme(int i4) {
        this.hasParkingTheme = true;
        this.parkingTheme_ = i4;
        return this;
    }

    public LinkAttrt setSnodeId(int i4) {
        this.hasSnodeId = true;
        this.snodeId_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasSnodeId()) {
            dVar.C(1, getSnodeId());
        }
        if (hasEnodeId()) {
            dVar.C(2, getEnodeId());
        }
        if (hasLevel()) {
            dVar.C(3, getLevel());
        }
        if (hasLength()) {
            dVar.C(4, getLength());
        }
        if (hasDirec()) {
            dVar.C(5, getDirec());
        }
        if (hasAttr()) {
            dVar.C(6, getAttr());
        }
        if (hasGeo()) {
            dVar.q(7, getGeo());
        }
        if (hasParkingFloor()) {
            dVar.q(8, getParkingFloor());
        }
        if (hasParkingTheme()) {
            dVar.s(9, getParkingTheme());
        }
    }

    public static LinkAttrt parseFrom(byte[] bArr) throws e {
        return (LinkAttrt) new LinkAttrt().mergeFrom(bArr);
    }

    @Override // L1.f
    public LinkAttrt mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setSnodeId(bVar.k());
            } else if (iO == 16) {
                setEnodeId(bVar.k());
            } else if (iO == 24) {
                setLevel(bVar.k());
            } else if (iO == 32) {
                setLength(bVar.k());
            } else if (iO == 40) {
                setDirec(bVar.k());
            } else if (iO == 48) {
                setAttr(bVar.k());
            } else if (iO == 58) {
                setGeo(bVar.b());
            } else if (iO == 66) {
                setParkingFloor(bVar.b());
            } else if (iO == 72) {
                setParkingTheme(bVar.k());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
