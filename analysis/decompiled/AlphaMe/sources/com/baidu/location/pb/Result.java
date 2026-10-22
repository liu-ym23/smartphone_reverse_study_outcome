package com.baidu.location.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class Result extends f {
    public static final int ERROR_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private boolean hasError;
    private boolean hasType;
    private int type_ = 0;
    private int error_ = 0;
    private int cachedSize = -1;

    public static Result parseFrom(b bVar) throws IOException {
        return new Result().mergeFrom(bVar);
    }

    public final Result clear() {
        clearType();
        clearError();
        this.cachedSize = -1;
        return this;
    }

    public Result clearError() {
        this.hasError = false;
        this.error_ = 0;
        return this;
    }

    public Result clearType() {
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

    public int getError() {
        return this.error_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasType() ? d.e(1, getType()) : 0;
        if (hasError()) {
            iE += d.k(getError()) + d.n(2);
        }
        this.cachedSize = iE;
        return iE;
    }

    public int getType() {
        return this.type_;
    }

    public boolean hasError() {
        return this.hasError;
    }

    public boolean hasType() {
        return this.hasType;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Result setError(int i4) {
        this.hasError = true;
        this.error_ = i4;
        return this;
    }

    public Result setType(int i4) {
        this.hasType = true;
        this.type_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasType()) {
            dVar.s(1, getType());
        }
        if (hasError()) {
            dVar.z(2, getError());
        }
    }

    public static Result parseFrom(byte[] bArr) throws e {
        return (Result) new Result().mergeFrom(bArr);
    }

    @Override // L1.f
    public Result mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setType(bVar.k());
            } else if (iO == 16) {
                setError(bVar.m());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
