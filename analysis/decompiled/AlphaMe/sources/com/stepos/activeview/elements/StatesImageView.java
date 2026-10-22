package com.stepos.activeview.elements;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.G;

/* loaded from: classes.dex */
public class StatesImageView extends G {
    private Drawable[] mDrawables;
    private String mState;
    private String[] mStates;

    public StatesImageView(Context context) {
        super(context);
    }

    private int getStateIndex(String str) {
        if (this.mStates != null && str != null) {
            int i4 = 0;
            while (true) {
                String[] strArr = this.mStates;
                if (i4 >= strArr.length) {
                    break;
                }
                if (str.equals(strArr[i4])) {
                    return i4;
                }
                i4++;
            }
        }
        return -1;
    }

    public String getState() {
        return this.mState;
    }

    public void setState(String str) {
        int stateIndex = getStateIndex(str);
        if (-1 != stateIndex) {
            setImageDrawable(this.mDrawables[stateIndex]);
            this.mState = str;
        }
    }

    public void setStates(String[] strArr, Drawable[] drawableArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.mStates = strArr;
        this.mDrawables = drawableArr;
        setState(strArr[0]);
    }

    public StatesImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatesImageView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
