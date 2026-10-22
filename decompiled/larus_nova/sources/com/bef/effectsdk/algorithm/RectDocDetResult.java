package com.bef.effectsdk.algorithm;

/* JADX INFO: loaded from: classes39.dex */
public class RectDocDetResult {
    public static final int DETECT_FAIL = -1;
    public static final int DETECT_SUCCESS = 0;
    private RectDocDetRatio rectDocDetRatio;
    private RectDocDetTargetArea rectDocDetTargetArea;
    private int resultStatus;

    public RectDocDetResult() {
        this.resultStatus = -1;
    }

    public RectDocDetRatio getRectDocDetRatio() {
        return this.rectDocDetRatio;
    }

    public RectDocDetTargetArea getRectDocDetTargetArea() {
        return this.rectDocDetTargetArea;
    }

    public int getResultStatus() {
        return this.resultStatus;
    }

    public RectDocDetResult(RectDocDetTargetArea r100, RectDocDetRatio r101) {
        this.resultStatus = 0;
        this.rectDocDetTargetArea = r100;
        this.rectDocDetRatio = r101;
    }
}
