package com.bytedance.android.livesdk.livecommerce.iron.ui.top.dynamic;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b%\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001f\u0010\u0006R\u001a\u0010 \u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u0018\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\rR\u0018\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u001a\u0010&\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u001a\u0010(\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u0018\u0010*\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\rR\u0018\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\rR\u001a\u0010.\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/top/dynamic/ConstraintLayoutParams;", "Ljava/io/Serializable;", "()V", "bottomMargin", "", "getBottomMargin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "bottomPadding", "getBottomPadding", "bottomToBottom", "", "getBottomToBottom", "()Ljava/lang/String;", "bottomToTop", "getBottomToTop", "centerX", "getCenterX", "centerY", "getCenterY", "height", "getHeight", "leftMargin", "getLeftMargin", "leftPadding", "getLeftPadding", "leftToLeft", "getLeftToLeft", "leftToRight", "getLeftToRight", "rightMargin", "getRightMargin", "rightPadding", "getRightPadding", "rightToLeft", "getRightToLeft", "rightToRight", "getRightToRight", "topMargin", "getTopMargin", "topPadding", "getTopPadding", "topToBottom", "getTopToBottom", "topToTop", "getTopToTop", "width", "getWidth", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConstraintLayoutParams implements Serializable {

    @SerializedName("bottom_margin")
    private final Integer bottomMargin;

    @SerializedName("bottom_padding")
    private final Integer bottomPadding;

    @SerializedName("bottom_to_bottom")
    private final String bottomToBottom;

    @SerializedName("bottom_to_top")
    private final String bottomToTop;

    @SerializedName("center_x")
    private final String centerX;

    @SerializedName("center_y")
    private final String centerY;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("left_margin")
    private final Integer leftMargin;

    @SerializedName("left_padding")
    private final Integer leftPadding;

    @SerializedName("left_to_left")
    private final String leftToLeft;

    @SerializedName("left_to_right")
    private final String leftToRight;

    @SerializedName("right_margin")
    private final Integer rightMargin;

    @SerializedName("right_padding")
    private final Integer rightPadding;

    @SerializedName("right_to_left")
    private final String rightToLeft;

    @SerializedName("right_to_right")
    private final String rightToRight;

    @SerializedName("top_margin")
    private final Integer topMargin;

    @SerializedName("top_padding")
    private final Integer topPadding;

    @SerializedName("top_to_bottom")
    private final String topToBottom;

    @SerializedName("top_to_top")
    private final String topToTop;

    @SerializedName("width")
    private final Integer width;

    public ConstraintLayoutParams() {
    }

    public final Integer getBottomMargin() {
        return this.bottomMargin;
    }

    public final Integer getBottomPadding() {
        return this.bottomPadding;
    }

    public final String getBottomToBottom() {
        return this.bottomToBottom;
    }

    public final String getBottomToTop() {
        return this.bottomToTop;
    }

    public final String getCenterX() {
        return this.centerX;
    }

    public final String getCenterY() {
        return this.centerY;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getLeftMargin() {
        return this.leftMargin;
    }

    public final Integer getLeftPadding() {
        return this.leftPadding;
    }

    public final String getLeftToLeft() {
        return this.leftToLeft;
    }

    public final String getLeftToRight() {
        return this.leftToRight;
    }

    public final Integer getRightMargin() {
        return this.rightMargin;
    }

    public final Integer getRightPadding() {
        return this.rightPadding;
    }

    public final String getRightToLeft() {
        return this.rightToLeft;
    }

    public final String getRightToRight() {
        return this.rightToRight;
    }

    public final Integer getTopMargin() {
        return this.topMargin;
    }

    public final Integer getTopPadding() {
        return this.topPadding;
    }

    public final String getTopToBottom() {
        return this.topToBottom;
    }

    public final String getTopToTop() {
        return this.topToTop;
    }

    public final Integer getWidth() {
        return this.width;
    }
}
