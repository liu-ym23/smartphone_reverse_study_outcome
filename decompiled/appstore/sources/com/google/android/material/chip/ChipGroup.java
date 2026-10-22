package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ChipGroup extends FlowLayout {
    private static final int DEF_STYLE_RES = 0;

    @IdRes
    private int checkedId;
    private final CheckedStateTracker checkedStateTracker;

    @Dimension
    private int chipSpacingHorizontal;

    @Dimension
    private int chipSpacingVertical;

    @Nullable
    private OnCheckedChangeListener onCheckedChangeListener;

    @NonNull
    private PassThroughHierarchyChangeListener passThroughListener;
    private boolean protectFromCheckedChange;
    private boolean selectionRequired;
    private boolean singleSelection;

    /* JADX INFO: renamed from: com.google.android.material.chip.ChipGroup$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ ChipGroup this$0;

        private CheckedStateTracker(ChipGroup r10) {
            this.this$0 = r10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(@NonNull CompoundButton r10, boolean r11) {
            if (ChipGroup.access$300(this.this$0) == false) goto L6;
            return;
        L6:
            if (this.this$0.getCheckedChipIds().isEmpty() == true) goto L8;
        L11:
            int r12 = r10.getId();
            if (r11 == false) goto L22;
            if (ChipGroup.access$700(this.this$0) != (-1)) goto L16;
        L20:
            ChipGroup.access$900(this.this$0, r12);
            return;
        L16:
            if (ChipGroup.access$700(this.this$0) == r12) goto L20;
            if (ChipGroup.access$800(this.this$0) == false) goto L20;
            ChipGroup r13 = this.this$0;
            ChipGroup.access$500(r13, ChipGroup.access$700(r13), false);
            goto L20
        L22:
            if (ChipGroup.access$700(this.this$0) != r12) goto L26;
            ChipGroup.access$900(this.this$0, -1);
            return;
        L26:
            return;
        L8:
            if (ChipGroup.access$400(this.this$0) == false) goto L11;
            ChipGroup.access$500(this.this$0, r10.getId(), true);
            ChipGroup.access$600(this.this$0, r10.getId(), false);
        }

        public /* synthetic */ CheckedStateTracker(ChipGroup r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
        }
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(ChipGroup r10, @IdRes int r11);
    }

    public class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
        final /* synthetic */ ChipGroup this$0;

        private PassThroughHierarchyChangeListener(ChipGroup r10) {
            this.this$0 = r10;
        }

        public static /* synthetic */ ViewGroup.OnHierarchyChangeListener access$202(PassThroughHierarchyChangeListener r10, ViewGroup.OnHierarchyChangeListener r11) {
            r10.onHierarchyChangeListener = r11;
            return r11;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r10, View r11) {
            if (r10 == this.this$0) goto L5;
        L13:
            ViewGroup.OnHierarchyChangeListener r12 = this.onHierarchyChangeListener;
            if (r12 == null) goto L17;
            r12.onChildViewAdded(r10, r11);
            return;
        L17:
            return;
        L5:
            if ((r11 instanceof Chip) == false) goto L13;
            if (r11.getId() != (-1)) goto L9;
            r11.setId(ViewCompat.k());
        L9:
            Chip r13 = (Chip) r11;
            if (r13.isChecked() == false) goto L12;
            ((ChipGroup) r10).check(r13.getId());
        L12:
            r13.setOnCheckedChangeListenerInternal(ChipGroup.access$1000(this.this$0));
            goto L13
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r10, View r11) {
            if (r10 == this.this$0) goto L5;
        L7:
            ViewGroup.OnHierarchyChangeListener r12 = this.onHierarchyChangeListener;
            if (r12 == null) goto L11;
            r12.onChildViewRemoved(r10, r11);
            return;
        L11:
            return;
        L5:
            if ((r11 instanceof Chip) == false) goto L7;
            ((Chip) r11).setOnCheckedChangeListenerInternal(null);
            goto L7
        }

        public /* synthetic */ PassThroughHierarchyChangeListener(ChipGroup r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ChipGroup;
    }

    public ChipGroup(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ CheckedStateTracker access$1000(ChipGroup r10) {
        return r10.checkedStateTracker;
    }

    public static /* synthetic */ boolean access$300(ChipGroup r10) {
        return r10.protectFromCheckedChange;
    }

    public static /* synthetic */ boolean access$400(ChipGroup r10) {
        return r10.selectionRequired;
    }

    public static /* synthetic */ void access$500(ChipGroup r10, int r11, boolean r12) {
        r10.setCheckedStateForView(r11, r12);
    }

    public static /* synthetic */ void access$600(ChipGroup r10, int r11, boolean r12) {
        r10.setCheckedId(r11, r12);
    }

    public static /* synthetic */ int access$700(ChipGroup r10) {
        return r10.checkedId;
    }

    public static /* synthetic */ boolean access$800(ChipGroup r10) {
        return r10.singleSelection;
    }

    public static /* synthetic */ void access$900(ChipGroup r10, int r11) {
        r10.setCheckedId(r11);
    }

    private int getChipCount() {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= getChildCount()) goto L9;
        if ((getChildAt(r10) instanceof Chip) == false) goto L8;
        r11 = r11 + 1;
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        return r11;
    }

    private void setCheckedId(int r10) {
        setCheckedId(r10, true);
    }

    private void setCheckedStateForView(@IdRes int r10, boolean r11) {
        View r12 = findViewById(r10);
        if ((r12 instanceof Chip) == false) goto L6;
        this.protectFromCheckedChange = true;
        ((Chip) r12).setChecked(r11);
        this.protectFromCheckedChange = false;
        return;
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        if ((r10 instanceof Chip) == false) goto L12;
        Chip r13 = (Chip) r10;
        if (r13.isChecked() == false) goto L12;
        int r14 = this.checkedId;
        if (r14 != (-1)) goto L9;
    L11:
        setCheckedId(r13.getId());
        goto L12
    L9:
        if (this.singleSelection == false) goto L11;
        setCheckedStateForView(r14, false);
    L12:
        super.addView(r10, r11, r12);
    }

    public void check(@IdRes int r10) {
        int r11 = this.checkedId;
        if (r10 != r11) goto L6;
        return;
    L6:
        if (r11 != (-1)) goto L8;
    L10:
        if (r10 == (-1)) goto L12;
        setCheckedStateForView(r10, true);
    L12:
        setCheckedId(r10);
        return;
    L8:
        if (this.singleSelection == false) goto L10;
        setCheckedStateForView(r11, false);
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if (super.checkLayoutParams(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r10 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    public void clearCheck() {
        this.protectFromCheckedChange = true;
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L9;
        View r11 = getChildAt(r10);
        if ((r11 instanceof Chip) == false) goto L8;
        ((Chip) r11).setChecked(false);
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        this.protectFromCheckedChange = false;
        setCheckedId(-1);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @IdRes
    public int getCheckedChipId() {
        if (this.singleSelection == true) goto L7;
        return -1;
    L7:
        return this.checkedId;
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 >= getChildCount()) goto L13;
        View r12 = getChildAt(r11);
        if ((r12 instanceof Chip) == false) goto L12;
        if (((Chip) r12).isChecked() == false) goto L12;
        r10.add(Integer.valueOf(r12.getId()));
        if (this.singleSelection == false) goto L12;
        return r10;
    L12:
        r11 = r11 + 1;
        goto L4
    L13:
        return r10;
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    @Dimension
    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    public int getIndexOfChip(@Nullable View r10) {
        if ((r10 instanceof Chip) == true) goto L5;
        return -1;
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= getChildCount()) goto L15;
        if ((getChildAt(r11) instanceof Chip) == false) goto L14;
        if (((Chip) getChildAt(r11)) == r10) goto L12;
        r12 = r12 + 1;
        goto L14
    L12:
        return r12;
    L14:
        r11 = r11 + 1;
        goto L7
    L15:
        return -1;
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean isSingleLine() {
        return super.isSingleLine();
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r10 = this.checkedId;
        if (r10 == (-1)) goto L6;
        setCheckedStateForView(r10, true);
        setCheckedId(this.checkedId);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.B0(r10);
        if (isSingleLine() == false) goto L5;
        int r12 = getChipCount();
    L6:
        int r13 = getRowCount();
        if (isSingleSelection() == false) goto L9;
        int r14 = 1;
    L10:
        r11.X(AccessibilityNodeInfoCompat.b.b(r13, r12, false, r14));
        return;
    L9:
        r14 = 2;
        goto L10
    L5:
        r12 = -1;
        goto L6
    }

    public void setChipSpacing(@Dimension int r10) {
        setChipSpacingHorizontal(r10);
        setChipSpacingVertical(r10);
    }

    public void setChipSpacingHorizontal(@Dimension int r10) {
        if (this.chipSpacingHorizontal == r10) goto L6;
        this.chipSpacingHorizontal = r10;
        setItemSpacing(r10);
        requestLayout();
        return;
    }

    public void setChipSpacingHorizontalResource(@DimenRes int r10) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(r10));
    }

    public void setChipSpacingResource(@DimenRes int r10) {
        setChipSpacing(getResources().getDimensionPixelOffset(r10));
    }

    public void setChipSpacingVertical(@Dimension int r10) {
        if (this.chipSpacingVertical == r10) goto L6;
        this.chipSpacingVertical = r10;
        setLineSpacing(r10);
        requestLayout();
        return;
    }

    public void setChipSpacingVerticalResource(@DimenRes int r10) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(r10));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable r10) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable r10) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int r10) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener r10) {
        this.onCheckedChangeListener = r10;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r10) {
        PassThroughHierarchyChangeListener.access$202(this.passThroughListener, r10);
    }

    public void setSelectionRequired(boolean r10) {
        this.selectionRequired = r10;
    }

    @Deprecated
    public void setShowDividerHorizontal(int r10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int r10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean r10) {
        super.setSingleLine(r10);
    }

    public void setSingleSelection(boolean r10) {
        if (this.singleSelection == r10) goto L6;
        this.singleSelection = r10;
        clearCheck();
        return;
    }

    public ChipGroup(Context r10, AttributeSet r11) {
        this(r10, r11, R.attr.chipGroupStyle);
    }

    private void setCheckedId(int r10, boolean r11) {
        this.checkedId = r10;
        OnCheckedChangeListener r12 = this.onCheckedChangeListener;
        if (r12 != null) goto L5;
        return;
    L5:
        if (this.singleSelection == false) goto L10;
        if (r11 == false) goto L11;
        r12.onCheckedChanged(this, r10);
        return;
    L11:
        return;
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new LayoutParams(r10);
    }

    public void setSingleLine(@BoolRes int r10) {
        setSingleLine(getResources().getBoolean(r10));
    }

    public ChipGroup(Context r10, AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        AnonymousClass1 r14 = null;
        this.checkedStateTracker = new CheckedStateTracker(this, r14);
        this.passThroughListener = new PassThroughHierarchyChangeListener(this, r14);
        this.checkedId = -1;
        this.protectFromCheckedChange = false;
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(getContext(), r11, R.styleable.ChipGroup, r12, r13, new int[0]);
        int r16 = r15.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(r15.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, r16));
        setChipSpacingVertical(r15.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, r16));
        setSingleLine(r15.getBoolean(R.styleable.ChipGroup_singleLine, false));
        setSingleSelection(r15.getBoolean(R.styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(r15.getBoolean(R.styleable.ChipGroup_selectionRequired, false));
        int r17 = r15.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
        if (r17 == (-1)) goto L5;
        this.checkedId = r17;
    L5:
        r15.recycle();
        super.setOnHierarchyChangeListener(this.passThroughListener);
        ViewCompat.A0(this, 1);
    }

    public void setSingleSelection(@BoolRes int r10) {
        setSingleSelection(getResources().getBoolean(r10));
    }
}
