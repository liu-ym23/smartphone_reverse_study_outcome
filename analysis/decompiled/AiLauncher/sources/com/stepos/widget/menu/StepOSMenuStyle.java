package com.stepos.widget.menu;

import android.content.Context;
import android.content.res.ColorStateList;
import com.stepos.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001e\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001e\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001e\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u001e\u0010*\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000b¨\u00066"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuStyle;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "itemTextAppearance", "", "getItemTextAppearance", "()I", "setItemTextAppearance", "(I)V", "itemSubtitleTextAppearance", "getItemSubtitleTextAppearance", "setItemSubtitleTextAppearance", "itemTextColor", "Landroid/content/res/ColorStateList;", "getItemTextColor", "()Landroid/content/res/ColorStateList;", "setItemTextColor", "(Landroid/content/res/ColorStateList;)V", "itemSubtitleTextColor", "getItemSubtitleTextColor", "setItemSubtitleTextColor", "itemWarningTextColor", "getItemWarningTextColor", "setItemWarningTextColor", "itemIconTint", "getItemIconTint", "setItemIconTint", "itemOverlayColor", "getItemOverlayColor", "setItemOverlayColor", "itemMinHeight", "getItemMinHeight", "setItemMinHeight", "itemPaddingHorizontal", "getItemPaddingHorizontal", "setItemPaddingHorizontal", "itemPaddingVertical", "getItemPaddingVertical", "setItemPaddingVertical", "itemIconSize", "getItemIconSize", "setItemIconSize", "overlayRadius", "", "getOverlayRadius", "()F", "setOverlayRadius", "(F)V", "overlayInsetHorizontal", "getOverlayInsetHorizontal", "setOverlayInsetHorizontal", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSMenuStyle {
    private int itemIconSize;
    private ColorStateList itemIconTint;
    private int itemMinHeight;
    private ColorStateList itemOverlayColor;
    private int itemPaddingHorizontal;
    private int itemPaddingVertical;
    private int itemSubtitleTextAppearance;
    private ColorStateList itemSubtitleTextColor;
    private int itemTextAppearance;
    private ColorStateList itemTextColor;
    private int itemWarningTextColor;
    private int overlayInsetHorizontal;
    private float overlayRadius;

    public StepOSMenuStyle(Context context) {
        p.i(context, "context");
        this.itemTextAppearance = R.style.StepOSTextAppearance_Menu_Item;
        this.itemSubtitleTextAppearance = R.style.StepOSTextAppearance_Menu_Item_Subtitle;
        this.itemTextColor = androidx.core.content.a.d(context, R.color.stepos_menu_item_title_color);
        this.itemSubtitleTextColor = androidx.core.content.a.d(context, R.color.stepos_menu_item_subtitle_color);
        this.itemWarningTextColor = androidx.core.content.a.c(context, R.color.stepos_menu_item_title_warning);
        this.itemIconTint = androidx.core.content.a.d(context, R.color.stepos_menu_item_icon_color);
        this.itemOverlayColor = androidx.core.content.a.d(context, R.color.stepos_menu_item_overlay_color);
        this.itemMinHeight = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_item_min_height);
        this.itemPaddingHorizontal = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_item_padding_horizontal);
        this.itemPaddingVertical = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_item_padding_vertical);
        this.itemIconSize = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_item_icon_size);
        this.overlayRadius = context.getResources().getDimension(R.dimen.stepos_menu_item_overlay_radius);
        this.overlayInsetHorizontal = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_item_overlay_inset_horizontal);
    }

    public final int getItemIconSize() {
        return this.itemIconSize;
    }

    public final ColorStateList getItemIconTint() {
        return this.itemIconTint;
    }

    public final int getItemMinHeight() {
        return this.itemMinHeight;
    }

    public final ColorStateList getItemOverlayColor() {
        return this.itemOverlayColor;
    }

    public final int getItemPaddingHorizontal() {
        return this.itemPaddingHorizontal;
    }

    public final int getItemPaddingVertical() {
        return this.itemPaddingVertical;
    }

    public final int getItemSubtitleTextAppearance() {
        return this.itemSubtitleTextAppearance;
    }

    public final ColorStateList getItemSubtitleTextColor() {
        return this.itemSubtitleTextColor;
    }

    public final int getItemTextAppearance() {
        return this.itemTextAppearance;
    }

    public final ColorStateList getItemTextColor() {
        return this.itemTextColor;
    }

    public final int getItemWarningTextColor() {
        return this.itemWarningTextColor;
    }

    public final int getOverlayInsetHorizontal() {
        return this.overlayInsetHorizontal;
    }

    public final float getOverlayRadius() {
        return this.overlayRadius;
    }

    public final void setItemIconSize(int i10) {
        this.itemIconSize = i10;
    }

    public final void setItemIconTint(ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
    }

    public final void setItemMinHeight(int i10) {
        this.itemMinHeight = i10;
    }

    public final void setItemOverlayColor(ColorStateList colorStateList) {
        this.itemOverlayColor = colorStateList;
    }

    public final void setItemPaddingHorizontal(int i10) {
        this.itemPaddingHorizontal = i10;
    }

    public final void setItemPaddingVertical(int i10) {
        this.itemPaddingVertical = i10;
    }

    public final void setItemSubtitleTextAppearance(int i10) {
        this.itemSubtitleTextAppearance = i10;
    }

    public final void setItemSubtitleTextColor(ColorStateList colorStateList) {
        this.itemSubtitleTextColor = colorStateList;
    }

    public final void setItemTextAppearance(int i10) {
        this.itemTextAppearance = i10;
    }

    public final void setItemTextColor(ColorStateList colorStateList) {
        this.itemTextColor = colorStateList;
    }

    public final void setItemWarningTextColor(int i10) {
        this.itemWarningTextColor = i10;
    }

    public final void setOverlayInsetHorizontal(int i10) {
        this.overlayInsetHorizontal = i10;
    }

    public final void setOverlayRadius(float f10) {
        this.overlayRadius = f10;
    }
}
