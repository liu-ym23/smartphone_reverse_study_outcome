package com.android.contacts.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.common.R;

/* JADX INFO: loaded from: classes.dex */
public class ProportionalLayout extends ViewGroup {
    private Direction mDirection;
    private float mRatio;

    public static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction heightToWidth = null;
        public static final Direction widthToHeight = null;
        public final String XmlName;

        private static /* synthetic */ Direction[] $values() {
            return new Direction[]{widthToHeight, heightToWidth};
        }

        public static Direction valueOf(String r1) {
            return (Direction) Enum.valueOf(Direction.class, r1);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        static {
            widthToHeight = new Direction("widthToHeight", 0, "widthToHeight");
            heightToWidth = new Direction("heightToWidth", 1, "heightToWidth");
            $VALUES = $values();
        }

        private Direction(String r1, int r2, String r3) {
            super(r1, r2);
            this.XmlName = r3;
        }

        public static Direction parse(String r4) {
            Direction r0 = widthToHeight;
            if (r0.XmlName.equals(r4) == false) goto L5;
            return r0;
        L5:
            Direction r1 = heightToWidth;
            if (r1.XmlName.equals(r4) == false) goto L9;
            return r1;
        L9:
            throw new IllegalStateException("direction must be either " + r0.XmlName + " or " + r1.XmlName);
        }
    }

    public ProportionalLayout(Context r1) {
        super(r1);
    }

    public ProportionalLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        initFromAttributes(r1, r2);
    }

    public ProportionalLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        initFromAttributes(r1, r2);
    }

    private void initFromAttributes(Context r2, AttributeSet r3) {
        TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.ProportionalLayout);
        this.mDirection = Direction.parse(r4.getString(R.styleable.ProportionalLayout_direction));
        this.mRatio = r4.getFloat(R.styleable.ProportionalLayout_ratio, 1.0f);
        r4.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int r6, int r7) {
        if (getChildCount() != 1) goto L11;
        View r0 = getChildAt(0);
        measureChild(r0, r6, r7);
        int r1 = r0.getMeasuredWidth();
        int r2 = r0.getMeasuredHeight();
        if (this.mDirection != Direction.heightToWidth) goto L7;
        r1 = Math.round(r2 * this.mRatio);
    L8:
        measureChild(r0, View.MeasureSpec.makeMeasureSpec(r1, 1073741824), View.MeasureSpec.makeMeasureSpec(r2, 1073741824));
        setMeasuredDimension(resolveSize(r1, r6), resolveSize(r2, r7));
        return;
    L7:
        r2 = Math.round(r1 * this.mRatio);
        goto L8
    L11:
        throw new IllegalStateException("ProportionalLayout requires exactly one child");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        if (getChildCount() != 1) goto L7;
        getChildAt(0).layout(0, 0, r5 - r3, r6 - r4);
        return;
    L7:
        throw new IllegalStateException("ProportionalLayout requires exactly one child");
    }

    public Direction getDirection() {
        return this.mDirection;
    }

    public void setDirection(Direction r1) {
        this.mDirection = r1;
    }

    public float getRatio() {
        return this.mRatio;
    }

    public void setRatio(float r1) {
        this.mRatio = r1;
    }
}
