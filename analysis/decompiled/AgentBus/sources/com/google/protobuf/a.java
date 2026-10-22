package com.google.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class a extends FilterInputStream {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2302f;

    /* renamed from: g, reason: collision with root package name */
    public int f2303g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(InputStream inputStream, int i2, int i10) {
        super(inputStream);
        this.f2302f = i10;
        this.f2303g = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        switch (this.f2302f) {
        }
        return Math.min(super.available(), this.f2303g);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        switch (this.f2302f) {
            case 0:
                if (this.f2303g <= 0) {
                    return -1;
                }
                int i2 = super.read();
                if (i2 >= 0) {
                    this.f2303g--;
                }
                return i2;
            default:
                if (this.f2303g <= 0) {
                    return -1;
                }
                int i10 = super.read();
                if (i10 >= 0) {
                    this.f2303g--;
                }
                return i10;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        switch (this.f2302f) {
            case 0:
                int iSkip = (int) super.skip(Math.min(j2, this.f2303g));
                if (iSkip >= 0) {
                    this.f2303g -= iSkip;
                }
                return iSkip;
            default:
                long jSkip = super.skip(Math.min(j2, this.f2303g));
                if (jSkip >= 0) {
                    this.f2303g = (int) (this.f2303g - jSkip);
                }
                return jSkip;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i10) throws IOException {
        switch (this.f2302f) {
            case 0:
                int i11 = this.f2303g;
                if (i11 <= 0) {
                    return -1;
                }
                int i12 = super.read(bArr, i2, Math.min(i10, i11));
                if (i12 >= 0) {
                    this.f2303g -= i12;
                }
                return i12;
            default:
                int i13 = this.f2303g;
                if (i13 <= 0) {
                    return -1;
                }
                int i14 = super.read(bArr, i2, Math.min(i10, i13));
                if (i14 >= 0) {
                    this.f2303g -= i14;
                }
                return i14;
        }
    }
}
