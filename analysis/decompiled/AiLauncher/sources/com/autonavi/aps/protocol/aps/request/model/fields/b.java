package com.autonavi.aps.protocol.aps.request.model.fields;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private short f18953a = 0;

    public void a(boolean z10) {
        if (z10) {
            this.f18953a = (short) (this.f18953a | 1);
        } else {
            this.f18953a = (short) (this.f18953a & 65534);
        }
    }

    public void b(boolean z10) {
        if (z10) {
            this.f18953a = (short) (this.f18953a & 65533);
        } else {
            this.f18953a = (short) (this.f18953a | 2);
        }
    }

    public void c(boolean z10) {
        if (z10) {
            this.f18953a = (short) (this.f18953a | 4);
        } else {
            this.f18953a = (short) (this.f18953a & 65531);
        }
    }

    public void d(boolean z10) {
        if (z10) {
            this.f18953a = (short) (this.f18953a | 8);
        } else {
            this.f18953a = (short) (this.f18953a & 65527);
        }
    }

    public String toString() {
        return String.valueOf((int) this.f18953a);
    }

    public short a() {
        return this.f18953a;
    }
}
