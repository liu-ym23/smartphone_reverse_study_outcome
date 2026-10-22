package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableGroup;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ChipGroup extends FlowLayout {
    private static final int DEF_STYLE_RES = 0;
    private final CheckableGroup<Chip> checkableGroup;
    private int chipSpacingHorizontal;
    private int chipSpacingVertical;
    private final int defaultCheckedId;
    private OnCheckedStateChangeListener onCheckedStateChangeListener;
    private final PassThroughHierarchyChangeListener passThroughListener;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }
    }

    @Deprecated
    public interface OnCheckedChangeListener {
        void onCheckedChanged(ChipGroup r1, int r2);
    }

    public interface OnCheckedStateChangeListener {
        void onCheckedChanged(ChipGroup r1, List<Integer> r2);
    }

    private class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
        final /* synthetic */ ChipGroup this$0;

        private PassThroughHierarchyChangeListener(ChipGroup r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PassThroughHierarchyChangeListener(ChipGroup r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ ViewGroup.OnHierarchyChangeListener access$302(PassThroughHierarchyChangeListener r0, ViewGroup.OnHierarchyChangeListener r1) {
            r0.onHierarchyChangeListener = r1;
            return r1;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r3, View r4) {
            if (r3 == this.this$0) goto L5;
        L10:
            ViewGroup.OnHierarchyChangeListener r2 = this.onHierarchyChangeListener;
            if (r2 == null) goto L14;
            r2.onChildViewAdded(r3, r4);
            return;
        L14:
            return;
        L5:
            if ((r4 instanceof Chip) == false) goto L10;
            if (r4.getId() != (-1)) goto L9;
            r4.setId(ViewCompat.generateViewId());
        L9:
            ChipGroup.access$200(this.this$0).addCheckable((Chip) r4);
            goto L10
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r3, View r4) {
            ChipGroup r0 = this.this$0;
            if (r3 == r0) goto L5;
        L7:
            ViewGroup.OnHierarchyChangeListener r2 = this.onHierarchyChangeListener;
            if (r2 == null) goto L11;
            r2.onChildViewRemoved(r3, r4);
            return;
        L11:
            return;
        L5:
            if ((r4 instanceof Chip) == false) goto L7;
            ChipGroup.access$200(r0).removeCheckable((Chip) r4);
            goto L7
        }
    }

    static /* synthetic */ OnCheckedStateChangeListener access$100(ChipGroup r0) {
        return r0.onCheckedStateChangeListener;
    }

    static /* synthetic */ CheckableGroup access$200(ChipGroup r0) {
        return r0.checkableGroup;
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ChipGroup;
    }

    public ChipGroup(Context r2) {
        this(r2, null);
    }

    public ChipGroup(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.chipGroupStyle);
    }

    public ChipGroup(Context r9, AttributeSet r10, int r11) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r9, r10, r11, r4), r10, r11);
        CheckableGroup<Chip> r12 = new CheckableGroup();
        this.checkableGroup = r12;
        PassThroughHierarchyChangeListener r6 = new PassThroughHierarchyChangeListener(this, null);
        this.passThroughListener = r6;
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(getContext(), r10, R.styleable.ChipGroup, r11, r4, new int[0]);
        int r14 = r13.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(r13.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, r14));
        setChipSpacingVertical(r13.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, r14));
        setSingleLine(r13.getBoolean(R.styleable.ChipGroup_singleLine, false));
        setSingleSelection(r13.getBoolean(R.styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(r13.getBoolean(R.styleable.ChipGroup_selectionRequired, false));
        this.defaultCheckedId = r13.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
        r13.recycle();
        r12.setOnCheckedStateChangeListener(new AnonymousClass1(this));
        super.setOnHierarchyChangeListener(r6);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r4) {
        super.onInitializeAccessibilityNodeInfo(r4);
        AccessibilityNodeInfoCompat r5 = AccessibilityNodeInfoCompat.wrap(r4);
        if (isSingleLine() == false) goto L5;
        int r0 = getVisibleChipCount();
    L6:
        int r1 = getRowCount();
        if (isSingleSelection() == false) goto L9;
        int r3 = 1;
    L10:
        r5.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r1, r0, false, r3));
        return;
    L9:
        r3 = 2;
        goto L10
    L5:
        r0 = -1;
        goto L6
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        if (super.checkLayoutParams(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r1) {
        PassThroughHierarchyChangeListener.access$302(this.passThroughListener, r1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int r0 = this.defaultCheckedId;
        if (r0 == (-1)) goto L6;
        this.checkableGroup.check(r0);
        return;
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable r1) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable r1) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerHorizontal(int r1) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int r1) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int r1) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void check(int r1) {
        this.checkableGroup.check(r1);
    }

    public int getCheckedChipId() {
        return this.checkableGroup.getSingleCheckedId();
    }

    public List<Integer> getCheckedChipIds() {
        return this.checkableGroup.getCheckedIdsSortedByChildOrder(this);
    }

    public void clearCheck() {
        this.checkableGroup.clearCheck();
    }

    @Deprecated
    public void setOnCheckedChangeListener(final OnCheckedChangeListener r2) {
        if (r2 != null) goto L5;
        setOnCheckedStateChangeListener(null);
        return;
    L5:
        setOnCheckedStateChangeListener(new AnonymousClass2(this, r2));
    }

    public void setOnCheckedStateChangeListener(OnCheckedStateChangeListener r1) {
        this.onCheckedStateChangeListener = r1;
    }

    private int getVisibleChipCount() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= getChildCount()) goto L11;
        if ((getChildAt(r0) instanceof Chip) == false) goto L10;
        if (isChildVisible(r0) == false) goto L10;
        r1 = r1 + 1;
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return r1;
    }

    int getIndexOfChip(View r6) {
        if ((r6 instanceof Chip) == true) goto L5;
        return -1;
    L5:
        int r0 = 0;
        int r2 = 0;
    L7:
        if (r0 >= getChildCount()) goto L17;
        View r3 = getChildAt(r0);
        if ((r3 instanceof Chip) == false) goto L16;
        if (isChildVisible(r0) == false) goto L16;
        if (((Chip) r3) == r6) goto L14;
        r2 = r2 + 1;
        goto L16
    L14:
        return r2;
    L16:
        r0 = r0 + 1;
        goto L7
    L17:
        return -1;
    }

    private boolean isChildVisible(int r1) {
        if (getChildAt(r1).getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setChipSpacing(int r1) {
        setChipSpacingHorizontal(r1);
        setChipSpacingVertical(r1);
    }

    public void setChipSpacingResource(int r2) {
        setChipSpacing(getResources().getDimensionPixelOffset(r2));
    }

    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    public void setChipSpacingHorizontal(int r2) {
        if (this.chipSpacingHorizontal == r2) goto L6;
        this.chipSpacingHorizontal = r2;
        setItemSpacing(r2);
        requestLayout();
        return;
    }

    public void setChipSpacingHorizontalResource(int r2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(r2));
    }

    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    public void setChipSpacingVertical(int r2) {
        if (this.chipSpacingVertical == r2) goto L6;
        this.chipSpacingVertical = r2;
        setLineSpacing(r2);
        requestLayout();
        return;
    }

    public void setChipSpacingVerticalResource(int r2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(r2));
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean isSingleLine() {
        return super.isSingleLine();
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean r1) {
        super.setSingleLine(r1);
    }

    public void setSingleLine(int r2) {
        setSingleLine(getResources().getBoolean(r2));
    }

    public boolean isSingleSelection() {
        return this.checkableGroup.isSingleSelection();
    }

    public void setSingleSelection(boolean r1) {
        this.checkableGroup.setSingleSelection(r1);
    }

    public void setSingleSelection(int r2) {
        setSingleSelection(getResources().getBoolean(r2));
    }

    public void setSelectionRequired(boolean r1) {
        this.checkableGroup.setSelectionRequired(r1);
    }

    public boolean isSelectionRequired() {
        return this.checkableGroup.isSelectionRequired();
    }
}
