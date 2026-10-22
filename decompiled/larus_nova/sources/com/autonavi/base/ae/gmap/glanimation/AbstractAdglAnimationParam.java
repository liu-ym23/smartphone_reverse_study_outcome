package com.autonavi.base.ae.gmap.glanimation;

/* JADX INFO: loaded from: classes39.dex */
public abstract class AbstractAdglAnimationParam {
    protected float factor;
    protected boolean hasCheckedParam;
    protected boolean hasFromValue;
    protected boolean hasToValue;
    protected int interpolationType;
    protected float mult;
    protected boolean needToCaculate;
    protected float normalizedTime;

    public static float bounce(float r100) {
        return (r100 * r100) * 8.0f;
    }

    public abstract void checkParam();

    public void reset() {
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    public boolean needToCaculate() {
        if (this.hasCheckedParam == true) goto L6;
        checkParam();
    L6:
        if (this.hasCheckedParam == true) goto L8;
        return false;
    L8:
        if (this.needToCaculate == false) goto L13;
        return true;
    L13:
        return false;
    }

    public AbstractAdglAnimationParam() {
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    public float getCurMult() {
        return this.mult;
    }

    public int getInterpolatorType() {
        return this.interpolationType;
    }

    public void setNormalizedTime(float r100) {
        this.normalizedTime = r100;
        switch(this.interpolationType) {
            case 0: goto L39;
            case 1: goto L37;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        r100 = 0.0f;
        goto L39
    L20:
        float r101 = r100 - 1.0f;
        r100 = ((r101 * r101) * ((r101 * 3.0f) + 2.0f)) + 1.0f;
        goto L39
    L21:
        float r102 = r100 * 1.1226f;
        if (r102 >= 0.3535f) goto L25;
        r100 = bounce(r102);
        goto L39
    L25:
        if (r102 >= 0.7408f) goto L29;
        float r103 = bounce(r102 - 0.54719f);
        float r104 = 0.7f;
    L27:
        r100 = r103 + r104;
        goto L39
    L29:
        if (r102 >= 0.9644f) goto L31;
        r103 = bounce(r102 - 0.8526f);
        r104 = 0.9f;
        goto L27
    L31:
        r103 = bounce(r102 - 1.0435f);
        r104 = 0.95f;
        goto L27
    L32:
        double r105 = (Math.cos(((double) (r100 + 1.0f)) * 3.141592653589793d) / 2.0d) + 0.5d;
    L38:
        r100 = (float) r105;
        goto L39
    L33:
        float r106 = this.factor;
        if (r106 != 1.0f) goto L36;
        float r107 = 1.0f - r100;
        r100 = 1.0f - (r107 * r107);
        goto L39
    L36:
        r100 = (float) (1.0d - Math.pow(1.0f - r100, r106 * 2.0f));
        goto L39
    L37:
        r105 = Math.pow(r100, this.factor * 2.0f);
    L39:
        this.mult = r100;
        return;
    L6:
        if (r100 < 0.0f) goto L4;
        if (r100 >= 0.25f) goto L12;
        r100 = r100 * 4.0f;
        goto L39
    L12:
        if (r100 >= 0.5f) goto L15;
        r100 = 2.0f - (r100 * 4.0f);
        goto L39
    L15:
        if (r100 >= 0.75f) goto L18;
        r100 = (r100 * 4.0f) - 2.0f;
        goto L39
    L18:
        if (r100 > 1.0f) goto L4;
        r100 = 4.0f - (r100 * 4.0f);
        goto L39
    }

    public void setInterpolatorType(int r100, float r101) {
        this.interpolationType = r100;
        this.factor = r101;
    }
}
