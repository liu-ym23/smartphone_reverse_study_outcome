package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public class FlexboxLayout$LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
    public static final Parcelable.Creator<FlexboxLayout$LayoutParams> CREATOR = new a();
    private int mAlignSelf;
    private float mFlexBasisPercent;
    private float mFlexGrow;
    private float mFlexShrink;
    private int mMaxHeight;
    private int mMaxWidth;
    private int mMinHeight;
    private int mMinWidth;
    private int mOrder;
    private boolean mWrapBefore;

    public class a implements Parcelable.Creator<FlexboxLayout$LayoutParams> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FlexboxLayout$LayoutParams createFromParcel(Parcel parcel) {
            return new FlexboxLayout$LayoutParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FlexboxLayout$LayoutParams[] newArray(int i10) {
            return new FlexboxLayout$LayoutParams[i10];
        }
    }

    public FlexboxLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOrder = 1;
        this.mFlexGrow = 0.0f;
        this.mFlexShrink = 1.0f;
        this.mAlignSelf = -1;
        this.mFlexBasisPercent = -1.0f;
        this.mMinWidth = -1;
        this.mMinHeight = -1;
        this.mMaxWidth = 16777215;
        this.mMaxHeight = 16777215;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout_Layout);
        this.mOrder = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_order, 1);
        this.mFlexGrow = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
        this.mFlexShrink = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
        this.mAlignSelf = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
        this.mFlexBasisPercent = typedArrayObtainStyledAttributes.getFraction(R$styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
        this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minWidth, -1);
        this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minHeight, -1);
        this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
        this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
        this.mWrapBefore = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getAlignSelf() {
        return this.mAlignSelf;
    }

    @Override // com.google.android.flexbox.FlexItem
    public float getFlexBasisPercent() {
        return this.mFlexBasisPercent;
    }

    @Override // com.google.android.flexbox.FlexItem
    public float getFlexGrow() {
        return this.mFlexGrow;
    }

    @Override // com.google.android.flexbox.FlexItem
    public float getFlexShrink() {
        return this.mFlexShrink;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getHeight() {
        return ((ViewGroup.MarginLayoutParams) this).height;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getMarginBottom() {
        return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getMarginLeft() {
        return ((ViewGroup.MarginLayoutParams) this).leftMargin;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getMarginRight() {
        return ((ViewGroup.MarginLayoutParams) this).rightMargin;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getMarginTop() {
        return ((ViewGroup.MarginLayoutParams) this).topMargin;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getMinHeight() {
        return this.mMinHeight;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getMinWidth() {
        return this.mMinWidth;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getOrder() {
        return this.mOrder;
    }

    @Override // com.google.android.flexbox.FlexItem
    public int getWidth() {
        return ((ViewGroup.MarginLayoutParams) this).width;
    }

    @Override // com.google.android.flexbox.FlexItem
    public boolean isWrapBefore() {
        return this.mWrapBefore;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setAlignSelf(int i10) {
        this.mAlignSelf = i10;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setFlexBasisPercent(float f10) {
        this.mFlexBasisPercent = f10;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setFlexGrow(float f10) {
        this.mFlexGrow = f10;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setFlexShrink(float f10) {
        this.mFlexShrink = f10;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setHeight(int i10) {
        ((ViewGroup.MarginLayoutParams) this).height = i10;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setMaxHeight(int i10) {
        this.mMaxHeight = i10;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setMaxWidth(int i10) {
        this.mMaxWidth = i10;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setMinHeight(int i10) {
        this.mMinHeight = i10;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setMinWidth(int i10) {
        this.mMinWidth = i10;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setOrder(int i10) {
        this.mOrder = i10;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setWidth(int i10) {
        ((ViewGroup.MarginLayoutParams) this).width = i10;
    }

    @Override // com.google.android.flexbox.FlexItem
    public void setWrapBefore(boolean z10) {
        this.mWrapBefore = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mOrder);
        parcel.writeFloat(this.mFlexGrow);
        parcel.writeFloat(this.mFlexShrink);
        parcel.writeInt(this.mAlignSelf);
        parcel.writeFloat(this.mFlexBasisPercent);
        parcel.writeInt(this.mMinWidth);
        parcel.writeInt(this.mMinHeight);
        parcel.writeInt(this.mMaxWidth);
        parcel.writeInt(this.mMaxHeight);
        parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
        parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
        parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
        parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
        parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
        parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
        parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
    }

    public FlexboxLayout$LayoutParams(FlexboxLayout$LayoutParams flexboxLayout$LayoutParams) {
        super((ViewGroup.MarginLayoutParams) flexboxLayout$LayoutParams);
        this.mOrder = 1;
        this.mFlexGrow = 0.0f;
        this.mFlexShrink = 1.0f;
        this.mAlignSelf = -1;
        this.mFlexBasisPercent = -1.0f;
        this.mMinWidth = -1;
        this.mMinHeight = -1;
        this.mMaxWidth = 16777215;
        this.mMaxHeight = 16777215;
        this.mOrder = flexboxLayout$LayoutParams.mOrder;
        this.mFlexGrow = flexboxLayout$LayoutParams.mFlexGrow;
        this.mFlexShrink = flexboxLayout$LayoutParams.mFlexShrink;
        this.mAlignSelf = flexboxLayout$LayoutParams.mAlignSelf;
        this.mFlexBasisPercent = flexboxLayout$LayoutParams.mFlexBasisPercent;
        this.mMinWidth = flexboxLayout$LayoutParams.mMinWidth;
        this.mMinHeight = flexboxLayout$LayoutParams.mMinHeight;
        this.mMaxWidth = flexboxLayout$LayoutParams.mMaxWidth;
        this.mMaxHeight = flexboxLayout$LayoutParams.mMaxHeight;
        this.mWrapBefore = flexboxLayout$LayoutParams.mWrapBefore;
    }

    public FlexboxLayout$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.mOrder = 1;
        this.mFlexGrow = 0.0f;
        this.mFlexShrink = 1.0f;
        this.mAlignSelf = -1;
        this.mFlexBasisPercent = -1.0f;
        this.mMinWidth = -1;
        this.mMinHeight = -1;
        this.mMaxWidth = 16777215;
        this.mMaxHeight = 16777215;
    }

    public FlexboxLayout$LayoutParams(int i10, int i11) {
        super(new ViewGroup.LayoutParams(i10, i11));
        this.mOrder = 1;
        this.mFlexGrow = 0.0f;
        this.mFlexShrink = 1.0f;
        this.mAlignSelf = -1;
        this.mFlexBasisPercent = -1.0f;
        this.mMinWidth = -1;
        this.mMinHeight = -1;
        this.mMaxWidth = 16777215;
        this.mMaxHeight = 16777215;
    }

    public FlexboxLayout$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.mOrder = 1;
        this.mFlexGrow = 0.0f;
        this.mFlexShrink = 1.0f;
        this.mAlignSelf = -1;
        this.mFlexBasisPercent = -1.0f;
        this.mMinWidth = -1;
        this.mMinHeight = -1;
        this.mMaxWidth = 16777215;
        this.mMaxHeight = 16777215;
    }

    public FlexboxLayout$LayoutParams(Parcel parcel) {
        super(0, 0);
        this.mOrder = 1;
        this.mFlexGrow = 0.0f;
        this.mFlexShrink = 1.0f;
        this.mAlignSelf = -1;
        this.mFlexBasisPercent = -1.0f;
        this.mMinWidth = -1;
        this.mMinHeight = -1;
        this.mMaxWidth = 16777215;
        this.mMaxHeight = 16777215;
        this.mOrder = parcel.readInt();
        this.mFlexGrow = parcel.readFloat();
        this.mFlexShrink = parcel.readFloat();
        this.mAlignSelf = parcel.readInt();
        this.mFlexBasisPercent = parcel.readFloat();
        this.mMinWidth = parcel.readInt();
        this.mMinHeight = parcel.readInt();
        this.mMaxWidth = parcel.readInt();
        this.mMaxHeight = parcel.readInt();
        this.mWrapBefore = parcel.readByte() != 0;
        ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
        ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
        ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
        ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
        ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
        ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
    }
}
