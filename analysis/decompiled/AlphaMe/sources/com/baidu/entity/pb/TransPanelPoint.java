package com.baidu.entity.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class TransPanelPoint extends f {
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    private boolean hasX;
    private boolean hasY;
    private int x_ = 0;
    private int y_ = 0;
    private int cachedSize = -1;

    public static TransPanelPoint parseFrom(b bVar) throws IOException {
        return new TransPanelPoint().mergeFrom(bVar);
    }

    public final TransPanelPoint clear() {
        clearX();
        clearY();
        this.cachedSize = -1;
        return this;
    }

    public TransPanelPoint clearX() {
        this.hasX = false;
        this.x_ = 0;
        return this;
    }

    public TransPanelPoint clearY() {
        this.hasY = false;
        this.y_ = 0;
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
        int iE = hasX() ? d.e(1, getX()) : 0;
        if (hasY()) {
            iE += d.e(2, getY());
        }
        this.cachedSize = iE;
        return iE;
    }

    public int getX() {
        return this.x_;
    }

    public int getY() {
        return this.y_;
    }

    public boolean hasX() {
        return this.hasX;
    }

    public boolean hasY() {
        return this.hasY;
    }

    public final boolean isInitialized() {
        return this.hasX && this.hasY;
    }

    public TransPanelPoint setX(int i4) {
        this.hasX = true;
        this.x_ = i4;
        return this;
    }

    public TransPanelPoint setY(int i4) {
        this.hasY = true;
        this.y_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasX()) {
            dVar.s(1, getX());
        }
        if (hasY()) {
            dVar.s(2, getY());
        }
    }

    public static TransPanelPoint parseFrom(byte[] bArr) throws e {
        return (TransPanelPoint) new TransPanelPoint().mergeFrom(bArr);
    }

    @Override // L1.f
    public TransPanelPoint mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setX(bVar.k());
            } else if (iO == 16) {
                setY(bVar.k());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
