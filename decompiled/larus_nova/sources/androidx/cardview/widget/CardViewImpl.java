package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;

/* JADX INFO: loaded from: classes2.dex */
interface CardViewImpl {
    ColorStateList getBackgroundColor(CardViewDelegate r100);

    float getElevation(CardViewDelegate r100);

    float getMaxElevation(CardViewDelegate r100);

    float getMinHeight(CardViewDelegate r100);

    float getMinWidth(CardViewDelegate r100);

    float getRadius(CardViewDelegate r100);

    void initStatic();

    void initialize(CardViewDelegate r100, Context r101, ColorStateList r102, float r103, float r104, float r105);

    void onCompatPaddingChanged(CardViewDelegate r100);

    void onPreventCornerOverlapChanged(CardViewDelegate r100);

    void setBackgroundColor(CardViewDelegate r100, ColorStateList r101);

    void setElevation(CardViewDelegate r100, float r101);

    void setMaxElevation(CardViewDelegate r100, float r101);

    void setRadius(CardViewDelegate r100, float r101);

    void updatePadding(CardViewDelegate r100);
}
