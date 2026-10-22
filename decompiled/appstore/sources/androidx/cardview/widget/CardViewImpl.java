package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
interface CardViewImpl {
    ColorStateList getBackgroundColor(CardViewDelegate r10);

    float getElevation(CardViewDelegate r10);

    float getMaxElevation(CardViewDelegate r10);

    float getMinHeight(CardViewDelegate r10);

    float getMinWidth(CardViewDelegate r10);

    float getRadius(CardViewDelegate r10);

    void initStatic();

    void initialize(CardViewDelegate r10, Context r11, ColorStateList r12, float r13, float r14, float r15);

    void onCompatPaddingChanged(CardViewDelegate r10);

    void onPreventCornerOverlapChanged(CardViewDelegate r10);

    void setBackgroundColor(CardViewDelegate r10, @Nullable ColorStateList r11);

    void setElevation(CardViewDelegate r10, float r11);

    void setMaxElevation(CardViewDelegate r10, float r11);

    void setRadius(CardViewDelegate r10, float r11);

    void updatePadding(CardViewDelegate r10);
}
