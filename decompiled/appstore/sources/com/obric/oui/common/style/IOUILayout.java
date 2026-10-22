package com.obric.oui.common.style;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IOUILayout {
    boolean decideIsNeedUpdatePressedForegroundBySelf();

    List<Shadow> getCurrentShadows();

    int getRadius();

    float getShadowAlpha();

    int getShadowColor();

    int getShadowElevation();

    boolean hasBorder();

    boolean hasBottomSeparator();

    boolean hasLeftSeparator();

    boolean hasRightSeparator();

    boolean hasTopSeparator();

    boolean isEnableShadowWidthRadius();

    default boolean isFakePressed() {
        return false;
    }

    boolean isShadowVisible();

    void onPressAlphaChange(int r10);

    void onlyShowBottomDivider(int r10, int r11, int r12, int r13);

    void onlyShowLeftDivider(int r10, int r11, int r12, int r13);

    void onlyShowRightDivider(int r10, int r11, int r12, int r13);

    void onlyShowTopDivider(int r10, int r11, int r12, int r13);

    void setBorderColor(@ColorInt int r10);

    void setBorderWidth(int r10);

    void setBottomDividerAlpha(int r10);

    void setEnableShadowWidthRadius(boolean r10);

    default void setFakePressed(boolean r10) {
    }

    boolean setHeightLimit(int r10);

    void setLeftDividerAlpha(int r10);

    void setOuterNormalColor(int r10);

    void setOutlineExcludePadding(boolean r10);

    void setOutlineInset(int r10, int r11, int r12, int r13);

    void setRadius(int r10);

    void setRadius(int r10, int r11, int r12, int r13);

    void setRadiusAndShadow(int r10, int r11, float r12);

    void setRadiusAndShadow(int r10, int r11, int r12, float r13);

    void setRightDividerAlpha(int r10);

    default void setShadow(@Nullable Shadow r10, @Nullable Shadow r11) {
        setShadow(r10, r11, false);
    }

    void setShadow(@Nullable Shadow r10, @Nullable Shadow r11, boolean r12);

    void setShadowAlpha(float r10);

    void setShadowColor(int r10);

    void setShadowCornerRadius(int r10);

    void setShadowElevation(int r10);

    void setShadowInsets(int r10, int r11);

    void setShadowStyle(@StyleRes int r10);

    void setShadowVisible(boolean r10, boolean r11);

    void setShowBorderOnlyBeforeL(boolean r10);

    void setTopDividerAlpha(int r10);

    void setUseThemeGeneralShadowElevation();

    boolean setWidthLimit(int r10);

    void setWidthMin(int r10);

    boolean shouldUpdateDividerColorOnPress();

    void updateBottomDivider(int r10, int r11, int r12, int r13);

    void updateBottomSeparatorColor(int r10);

    void updateDividerColorStrength(float r10);

    void updateLeftDivider(int r10, int r11, int r12, int r13);

    void updateLeftSeparatorColor(int r10);

    void updateRightDivider(int r10, int r11, int r12, int r13);

    void updateRightSeparatorColor(int r10);

    void updateShadows(@Nullable List<Shadow> r10);

    void updateTopDivider(int r10, int r11, int r12, int r13);

    void updateTopSeparatorColor(int r10);
}
