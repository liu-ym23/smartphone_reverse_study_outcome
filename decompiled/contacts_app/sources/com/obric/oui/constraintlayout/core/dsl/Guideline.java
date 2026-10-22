package com.obric.oui.constraintlayout.core.dsl;

import com.bytedance.apm.constant.TraceStatsConsts;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Guideline extends Helper {
    private int mEnd;
    private float mPercent;
    private int mStart;

    Guideline(String r3) {
        super(r3, new Helper.HelperType(""));
        this.mStart = Integer.MIN_VALUE;
        this.mEnd = Integer.MIN_VALUE;
        this.mPercent = Float.NaN;
    }

    public int getStart() {
        return this.mStart;
    }

    public void setStart(int r2) {
        this.mStart = r2;
        this.configMap.put("start", String.valueOf(this.mStart));
    }

    public int getEnd() {
        return this.mEnd;
    }

    public void setEnd(int r2) {
        this.mEnd = r2;
        this.configMap.put(TraceStatsConsts.STATS_KEY_END, String.valueOf(this.mEnd));
    }

    public float getPercent() {
        return this.mPercent;
    }

    public void setPercent(float r2) {
        this.mPercent = r2;
        this.configMap.put("percent", String.valueOf(this.mPercent));
    }
}
