package org.bouncycastle.asn1.x9;

import p7.h;

/* loaded from: classes.dex */
public abstract class X9ECParametersHolder {
    private h curve;
    private X9ECParameters params;

    public h createCurve() {
        return createParameters().getCurve();
    }

    public abstract X9ECParameters createParameters();

    public synchronized h getCurve() {
        try {
            if (this.curve == null) {
                this.curve = createCurve();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.curve;
    }

    public synchronized X9ECParameters getParameters() {
        try {
            if (this.params == null) {
                this.params = createParameters();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.params;
    }
}
