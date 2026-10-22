package com.bytedance.security.zenmobile.detect.anchor;

/* JADX INFO: loaded from: classes.dex */
public class MatchRule {
    private boolean inValue;
    private long ruleId;
    private int step;
    private String word;

    public MatchRule(String r1, long r2, boolean r4, int r5) {
        this.word = r1;
        this.ruleId = r2;
        this.inValue = r4;
        this.step = r5;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String r1) {
        this.word = r1;
    }

    public long getRuleId() {
        return this.ruleId;
    }

    public void setRuleId(long r1) {
        this.ruleId = r1;
    }

    public boolean isInValue() {
        return this.inValue;
    }

    public void setInValue(boolean r1) {
        this.inValue = r1;
    }

    public int getStep() {
        return this.step;
    }

    public void setStep(int r1) {
        this.step = r1;
    }
}
