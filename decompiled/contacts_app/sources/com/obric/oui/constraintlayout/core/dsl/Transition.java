package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public class Transition {
    private final int DEFAULT_DURATION;
    private final float DEFAULT_STAGGER;
    final int UNSET;
    private String mConstraintSetEnd;
    private String mConstraintSetStart;
    private int mDefaultInterpolator;
    private int mDefaultInterpolatorID;
    private String mDefaultInterpolatorString;
    private int mDuration;
    private String mId;
    private KeyFrames mKeyFrames;
    private OnSwipe mOnSwipe;
    private float mStagger;

    public void setOnSwipe(OnSwipe r1) {
        this.mOnSwipe = r1;
    }

    public void setKeyFrames(Keys r1) {
        this.mKeyFrames.add(r1);
    }

    public Transition(String r6, String r7) {
        this.mOnSwipe = null;
        this.UNSET = -1;
        this.DEFAULT_DURATION = 400;
        this.DEFAULT_STAGGER = 0.0f;
        this.mId = null;
        this.mConstraintSetEnd = null;
        this.mConstraintSetStart = null;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = -1;
        this.mDuration = 400;
        this.mStagger = 0.0f;
        this.mKeyFrames = new KeyFrames();
        this.mId = "default";
        this.mConstraintSetStart = r6;
        this.mConstraintSetEnd = r7;
    }

    public Transition(String r6, String r7, String r8) {
        this.mOnSwipe = null;
        this.UNSET = -1;
        this.DEFAULT_DURATION = 400;
        this.DEFAULT_STAGGER = 0.0f;
        this.mId = null;
        this.mConstraintSetEnd = null;
        this.mConstraintSetStart = null;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = -1;
        this.mDuration = 400;
        this.mStagger = 0.0f;
        this.mKeyFrames = new KeyFrames();
        this.mId = r6;
        this.mConstraintSetStart = r7;
        this.mConstraintSetEnd = r8;
    }

    String toJson() {
        return toString();
    }

    public void setId(String r1) {
        this.mId = r1;
    }

    public void setTo(String r1) {
        this.mConstraintSetEnd = r1;
    }

    public void setFrom(String r1) {
        this.mConstraintSetStart = r1;
    }

    public void setDuration(int r1) {
        this.mDuration = r1;
    }

    public void setStagger(float r1) {
        this.mStagger = r1;
    }

    public String toString() {
        String r0 = this.mId + ":{\nfrom:'" + this.mConstraintSetStart + "',\nto:'" + this.mConstraintSetEnd + "',\n";
        if (this.mDuration == 400) goto L6;
        r0 = r0 + "duration:" + this.mDuration + ",\n";
    L6:
        if (this.mStagger == 0.0f) goto L9;
        r0 = r0 + "stagger:" + this.mStagger + ",\n";
    L9:
        if (this.mOnSwipe == null) goto L12;
        r0 = r0 + this.mOnSwipe.toString();
    L12:
        return (r0 + this.mKeyFrames.toString()) + "},\n";
    }

    public String getId() {
        return this.mId;
    }
}
