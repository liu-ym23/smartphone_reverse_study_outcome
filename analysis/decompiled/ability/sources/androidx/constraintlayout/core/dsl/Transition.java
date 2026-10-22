package androidx.constraintlayout.core.dsl;

import androidx.compose.foundation.b;

/* loaded from: classes2.dex */
public class Transition {
    private String mConstraintSetEnd;
    private String mConstraintSetStart;
    private String mId;
    private OnSwipe mOnSwipe = null;
    final int UNSET = -1;
    private final int DEFAULT_DURATION = 400;
    private final float DEFAULT_STAGGER = 0.0f;
    private int mDefaultInterpolator = 0;
    private String mDefaultInterpolatorString = null;
    private int mDefaultInterpolatorID = -1;
    private int mDuration = 400;
    private float mStagger = 0.0f;
    private KeyFrames mKeyFrames = new KeyFrames();

    public Transition(String str, String str2) {
        this.mId = null;
        this.mConstraintSetEnd = null;
        this.mConstraintSetStart = null;
        this.mId = "default";
        this.mConstraintSetStart = str;
        this.mConstraintSetEnd = str2;
    }

    public String getId() {
        return this.mId;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setFrom(String str) {
        this.mConstraintSetStart = str;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setKeyFrames(Keys keys) {
        this.mKeyFrames.add(keys);
    }

    public void setOnSwipe(OnSwipe onSwipe) {
        this.mOnSwipe = onSwipe;
    }

    public void setStagger(float f) {
        this.mStagger = f;
    }

    public void setTo(String str) {
        this.mConstraintSetEnd = str;
    }

    public String toJson() {
        return toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mId);
        sb.append(":{\nfrom:'");
        sb.append(this.mConstraintSetStart);
        sb.append("',\nto:'");
        String strQ = B7.a.q(sb, this.mConstraintSetEnd, "',\n");
        if (this.mDuration != 400) {
            strQ = androidx.appfunctions.metadata.a.o(androidx.appfunctions.metadata.a.x(strQ, "duration:"), ",\n", this.mDuration);
        }
        if (this.mStagger != 0.0f) {
            strQ = b.u(androidx.appfunctions.metadata.a.x(strQ, "stagger:"), ",\n", this.mStagger);
        }
        if (this.mOnSwipe != null) {
            StringBuilder sbV = b.v(strQ);
            sbV.append(this.mOnSwipe.toString());
            strQ = sbV.toString();
        }
        StringBuilder sbV2 = b.v(strQ);
        sbV2.append(this.mKeyFrames.toString());
        return androidx.appfunctions.metadata.a.l(sbV2.toString(), "},\n");
    }

    public Transition(String str, String str2, String str3) {
        this.mId = null;
        this.mConstraintSetEnd = null;
        this.mConstraintSetStart = null;
        this.mId = str;
        this.mConstraintSetStart = str2;
        this.mConstraintSetEnd = str3;
    }
}
