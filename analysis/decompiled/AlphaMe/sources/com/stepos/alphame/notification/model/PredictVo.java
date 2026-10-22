package com.stepos.alphame.notification.model;

/* loaded from: classes.dex */
public class PredictVo {
    private String content;
    private float score;
    private String tag;

    public String getContent() {
        return this.content;
    }

    public float getScore() {
        return this.score;
    }

    public String getTag() {
        return this.tag;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setScore(float f4) {
        this.score = f4;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String toString() {
        return "PredictVo{tag='" + this.tag + "', content='" + this.content + "', score=" + this.score + '}';
    }
}
