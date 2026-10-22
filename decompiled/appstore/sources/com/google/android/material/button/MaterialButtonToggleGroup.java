package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.e;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    private static final int DEF_STYLE_RES = 0;
    private static final String LOG_TAG = "MaterialButtonToggleGroup";

    @IdRes
    private int checkedId;
    private final CheckedStateTracker checkedStateTracker;
    private Integer[] childOrder;
    private final Comparator<MaterialButton> childOrderComparator;
    private final LinkedHashSet<OnButtonCheckedListener> onButtonCheckedListeners;
    private final List<CornerData> originalCornerData;
    private final PressedStateTracker pressedStateTracker;
    private boolean selectionRequired;
    private boolean singleSelection;
    private boolean skipCheckedStateTracker;

    public class CheckedStateTracker implements MaterialButton.OnCheckedChangeListener {
        final /* synthetic */ MaterialButtonToggleGroup this$0;

        private CheckedStateTracker(MaterialButtonToggleGroup r10) {
            this.this$0 = r10;
        }

        @Override // com.google.android.material.button.MaterialButton.OnCheckedChangeListener
        public void onCheckedChanged(@NonNull MaterialButton r10, boolean r11) {
            if (MaterialButtonToggleGroup.access$300(this.this$0) == false) goto L6;
            return;
        L6:
            if (MaterialButtonToggleGroup.access$400(this.this$0) == false) goto L13;
            MaterialButtonToggleGroup r12 = this.this$0;
            if (r11 == false) goto L10;
            int r13 = r10.getId();
        L11:
            MaterialButtonToggleGroup.access$502(r12, r13);
            goto L13
        L10:
            r13 = -1;
        L13:
            if (MaterialButtonToggleGroup.access$600(this.this$0, r10.getId(), r11) == false) goto L15;
            MaterialButtonToggleGroup.access$700(this.this$0, r10.getId(), r10.isChecked());
        L15:
            this.this$0.invalidate();
        }

        public /* synthetic */ CheckedStateTracker(MaterialButtonToggleGroup r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public static class CornerData {
        private static final CornerSize noCorner = null;
        CornerSize bottomLeft;
        CornerSize bottomRight;
        CornerSize topLeft;
        CornerSize topRight;

        static {
            noCorner = new AbsoluteCornerSize(0.0f);
        }

        public CornerData(CornerSize r10, CornerSize r11, CornerSize r12, CornerSize r13) {
            this.topLeft = r10;
            this.topRight = r12;
            this.bottomRight = r13;
            this.bottomLeft = r11;
        }

        public static CornerData bottom(CornerData r10) {
            CornerSize r11 = noCorner;
            return new CornerData(r11, r10.bottomLeft, r11, r10.bottomRight);
        }

        public static CornerData end(CornerData r10, View r11) {
            if (ViewUtils.isLayoutRtl(r11) == false) goto L6;
            return left(r10);
        L6:
            return right(r10);
        }

        public static CornerData left(CornerData r10) {
            CornerSize r11 = r10.topLeft;
            CornerSize r12 = r10.bottomLeft;
            CornerSize r13 = noCorner;
            return new CornerData(r11, r12, r13, r13);
        }

        public static CornerData right(CornerData r10) {
            CornerSize r11 = noCorner;
            return new CornerData(r11, r11, r10.topRight, r10.bottomRight);
        }

        public static CornerData start(CornerData r10, View r11) {
            if (ViewUtils.isLayoutRtl(r11) == false) goto L6;
            return right(r10);
        L6:
            return left(r10);
        }

        public static CornerData top(CornerData r10) {
            CornerSize r11 = r10.topLeft;
            CornerSize r12 = noCorner;
            return new CornerData(r11, r12, r10.topRight, r12);
        }
    }

    public interface OnButtonCheckedListener {
        void onButtonChecked(MaterialButtonToggleGroup r10, @IdRes int r11, boolean r12);
    }

    public class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        final /* synthetic */ MaterialButtonToggleGroup this$0;

        private PressedStateTracker(MaterialButtonToggleGroup r10) {
            this.this$0 = r10;
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void onPressedChanged(@NonNull MaterialButton r10, boolean r11) {
            this.this$0.invalidate();
        }

        public /* synthetic */ PressedStateTracker(MaterialButtonToggleGroup r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    }

    public MaterialButtonToggleGroup(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ int access$200(MaterialButtonToggleGroup r10, View r11) {
        return r10.getIndexWithinVisibleButtons(r11);
    }

    public static /* synthetic */ boolean access$300(MaterialButtonToggleGroup r10) {
        return r10.skipCheckedStateTracker;
    }

    public static /* synthetic */ boolean access$400(MaterialButtonToggleGroup r10) {
        return r10.singleSelection;
    }

    public static /* synthetic */ int access$502(MaterialButtonToggleGroup r10, int r11) {
        r10.checkedId = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$600(MaterialButtonToggleGroup r10, int r11, boolean r12) {
        return r10.updateCheckedStates(r11, r12);
    }

    public static /* synthetic */ void access$700(MaterialButtonToggleGroup r10, int r11, boolean r12) {
        r10.dispatchOnButtonChecked(r11, r12);
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int r10 = getFirstVisibleChildIndex();
        if (r10 != (-1)) goto L5;
        return;
    L5:
        int r11 = r10 + 1;
    L7:
        if (r11 >= getChildCount()) goto L13;
        MaterialButton r12 = getChildButton(r11);
        int r13 = Math.min(r12.getStrokeWidth(), getChildButton(r11 - 1).getStrokeWidth());
        LinearLayout.LayoutParams r14 = buildLayoutParams(r12);
        if (getOrientation() != 0) goto L11;
        e.c(r14, 0);
        e.d(r14, -r13);
        r14.topMargin = 0;
    L12:
        r12.setLayoutParams(r14);
        r11 = r11 + 1;
        goto L7
    L11:
        r14.bottomMargin = 0;
        r14.topMargin = -r13;
        e.d(r14, 0);
        goto L12
    L13:
        resetChildMargins(r10);
    }

    @NonNull
    private LinearLayout.LayoutParams buildLayoutParams(@NonNull View r10) {
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof LinearLayout.LayoutParams) == false) goto L7;
        return (LinearLayout.LayoutParams) r11;
    L7:
        return new LinearLayout.LayoutParams(r11.width, r11.height);
    }

    private void checkForced(int r10, boolean r11) {
        MaterialButton r12 = (MaterialButton) findViewById(r10);
        if (r12 == null) goto L6;
        r12.setChecked(r11);
        return;
    }

    private void dispatchOnButtonChecked(@IdRes int r10, boolean r11) {
        Iterator<OnButtonCheckedListener> r12 = this.onButtonCheckedListeners.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().onButtonChecked(this, r10, r11);
        goto L4
    }

    private MaterialButton getChildButton(int r10) {
        return (MaterialButton) getChildAt(r10);
    }

    private int getFirstVisibleChildIndex() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (isChildVisible(r11) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r11;
    L8:
        return -1;
    }

    private int getIndexWithinVisibleButtons(@Nullable View r10) {
        if ((r10 instanceof MaterialButton) == true) goto L5;
        return -1;
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= getChildCount()) goto L17;
        if (getChildAt(r11) == r10) goto L10;
        if ((getChildAt(r11) instanceof MaterialButton) == false) goto L16;
        if (isChildVisible(r11) == false) goto L16;
        r12 = r12 + 1;
    L16:
        r11 = r11 + 1;
        goto L7
    L10:
        return r12;
    L17:
        return -1;
    }

    private int getLastVisibleChildIndex() {
        int r10 = getChildCount() - 1;
    L3:
        if (r10 < 0) goto L8;
        if (isChildVisible(r10) == true) goto L6;
        r10 = r10 - 1;
        goto L3
    L6:
        return r10;
    L8:
        return -1;
    }

    @Nullable
    private CornerData getNewCornerData(int r10, int r11, int r12) {
        CornerData r13 = this.originalCornerData.get(r10);
        if (r11 != r12) goto L6;
        return r13;
    L6:
        if (getOrientation() != 0) goto L8;
        boolean r14 = true;
    L9:
        if (r10 != r11) goto L14;
        if (r14 == false) goto L13;
        return CornerData.start(r13, this);
    L13:
        return CornerData.top(r13);
    L14:
        if (r10 != r12) goto L19;
        if (r14 == false) goto L18;
        return CornerData.end(r13, this);
    L18:
        return CornerData.bottom(r13);
    L19:
        return null;
    L8:
        r14 = false;
        goto L9
    }

    private int getVisibleButtonCount() {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= getChildCount()) goto L11;
        if ((getChildAt(r10) instanceof MaterialButton) == false) goto L10;
        if (isChildVisible(r10) == false) goto L10;
        r11 = r11 + 1;
    L10:
        r10 = r10 + 1;
        goto L4
    L11:
        return r11;
    }

    private boolean isChildVisible(int r10) {
        if (getChildAt(r10).getVisibility() == 8) goto L5;
        return true;
    L5:
        return false;
    }

    private void resetChildMargins(int r10) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L14;
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) getChildButton(r10).getLayoutParams();
        if (getOrientation() != 1) goto L11;
        r11.topMargin = 0;
        r11.bottomMargin = 0;
        return;
    L11:
        e.c(r11, 0);
        e.d(r11, 0);
        r11.leftMargin = 0;
        r11.rightMargin = 0;
        return;
    }

    private void setCheckedId(int r10) {
        this.checkedId = r10;
        dispatchOnButtonChecked(r10, true);
    }

    private void setCheckedStateForView(@IdRes int r10, boolean r11) {
        View r12 = findViewById(r10);
        if ((r12 instanceof MaterialButton) == false) goto L6;
        this.skipCheckedStateTracker = true;
        ((MaterialButton) r12).setChecked(r11);
        this.skipCheckedStateTracker = false;
        return;
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton r10) {
        if (r10.getId() != (-1)) goto L6;
        r10.setId(ViewCompat.k());
        return;
    }

    private void setupButtonChild(@NonNull MaterialButton r10) {
        r10.setMaxLines(1);
        r10.setEllipsize(TextUtils.TruncateAt.END);
        r10.setCheckable(true);
        r10.addOnCheckedChangeListener(this.checkedStateTracker);
        r10.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        r10.setShouldDrawSurfaceColorStroke(true);
    }

    private static void updateBuilderWithCornerData(ShapeAppearanceModel.Builder r10, @Nullable CornerData r11) {
        if (r11 != null) goto L5;
        r10.setAllCornerSizes(0.0f);
        return;
    L5:
        r10.setTopLeftCornerSize(r11.topLeft).setBottomLeftCornerSize(r11.bottomLeft).setTopRightCornerSize(r11.topRight).setBottomRightCornerSize(r11.bottomRight);
    }

    private boolean updateCheckedStates(int r10, boolean r11) {
        List<Integer> r12 = getCheckedButtonIds();
        if (this.selectionRequired == true) goto L5;
    L8:
        if (r11 == true) goto L10;
    L15:
        return true;
    L10:
        if (this.singleSelection == false) goto L15;
        r12.remove(Integer.valueOf(r10));
        Iterator<Integer> r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L15;
        int r14 = r13.next().intValue();
        setCheckedStateForView(r14, false);
        dispatchOnButtonChecked(r14, false);
        goto L13
    L5:
        if (r12.isEmpty() == false) goto L8;
        setCheckedStateForView(r10, true);
        this.checkedId = r10;
        return false;
    }

    private void updateChildOrder() {
        TreeMap r10 = new TreeMap(this.childOrderComparator);
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.put(getChildButton(r12), Integer.valueOf(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        this.childOrder = (Integer[]) r10.values().toArray(new Integer[0]);
    }

    public void addOnButtonCheckedListener(@NonNull OnButtonCheckedListener r10) {
        this.onButtonCheckedListeners.add(r10);
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        if ((r10 instanceof MaterialButton) == true) goto L6;
        Log.e(LOG_TAG, "Child views must be of type MaterialButton.");
        return;
    L6:
        super.addView(r10, r11, r12);
        MaterialButton r13 = (MaterialButton) r10;
        setGeneratedIdIfNeeded(r13);
        setupButtonChild(r13);
        if (r13.isChecked() == false) goto L9;
        updateCheckedStates(r13.getId(), true);
        setCheckedId(r13.getId());
    L9:
        ShapeAppearanceModel r14 = r13.getShapeAppearanceModel();
        this.originalCornerData.add(new CornerData(r14.getTopLeftCornerSize(), r14.getBottomLeftCornerSize(), r14.getTopRightCornerSize(), r14.getBottomRightCornerSize()));
        ViewCompat.p0(r13, new AnonymousClass2(this));
    }

    public void check(@IdRes int r10) {
        if (r10 != this.checkedId) goto L5;
        return;
    L5:
        checkForced(r10, true);
    }

    public void clearChecked() {
        this.skipCheckedStateTracker = true;
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L6;
        MaterialButton r11 = getChildButton(r10);
        r11.setChecked(false);
        dispatchOnButtonChecked(r11.getId(), false);
        r10 = r10 + 1;
        goto L4
    L6:
        this.skipCheckedStateTracker = false;
        setCheckedId(-1);
    }

    public void clearOnButtonCheckedListeners() {
        this.onButtonCheckedListeners.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas r10) {
        updateChildOrder();
        super.dispatchDraw(r10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.singleSelection == true) goto L7;
        return -1;
    L7:
        return this.checkedId;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 >= getChildCount()) goto L9;
        MaterialButton r12 = getChildButton(r11);
        if (r12.isChecked() == false) goto L8;
        r10.add(Integer.valueOf(r12.getId()));
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r10;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r10, int r11) {
        Integer[] r12 = this.childOrder;
        if (r12 != null) goto L5;
    L9:
        Log.w(LOG_TAG, "Child order wasn't updated");
        return r11;
    L5:
        if (r11 >= r12.length) goto L9;
        return r12[r11].intValue();
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r10 = this.checkedId;
        if (r10 == (-1)) goto L6;
        checkForced(r10, true);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.B0(r10);
        int r12 = getVisibleButtonCount();
        if (isSingleSelection() == false) goto L5;
        int r13 = 1;
    L6:
        r11.X(AccessibilityNodeInfoCompat.b.b(1, r12, false, r13));
        return;
    L5:
        r13 = 2;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(r10, r11);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r10) {
        super.onViewRemoved(r10);
        if ((r10 instanceof MaterialButton) == false) goto L5;
        MaterialButton r11 = (MaterialButton) r10;
        r11.removeOnCheckedChangeListener(this.checkedStateTracker);
        r11.setOnPressedChangeListenerInternal(null);
    L5:
        int r12 = indexOfChild(r10);
        if (r12 < 0) goto L8;
        this.originalCornerData.remove(r12);
    L8:
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    public void removeOnButtonCheckedListener(@NonNull OnButtonCheckedListener r10) {
        this.onButtonCheckedListeners.remove(r10);
    }

    public void setSelectionRequired(boolean r10) {
        this.selectionRequired = r10;
    }

    public void setSingleSelection(boolean r10) {
        if (this.singleSelection == r10) goto L6;
        this.singleSelection = r10;
        clearChecked();
        return;
    }

    public void uncheck(@IdRes int r10) {
        checkForced(r10, false);
    }

    @VisibleForTesting
    public void updateChildShapes() {
        int r10 = getChildCount();
        int r11 = getFirstVisibleChildIndex();
        int r12 = getLastVisibleChildIndex();
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L9;
        MaterialButton r14 = getChildButton(r13);
        if (r14.getVisibility() == 8) goto L8;
        ShapeAppearanceModel.Builder r15 = r14.getShapeAppearanceModel().toBuilder();
        updateBuilderWithCornerData(r15, getNewCornerData(r13, r11, r12));
        r14.setShapeAppearanceModel(r15.build());
    L8:
        r13 = r13 + 1;
        goto L3
    }

    public MaterialButtonToggleGroup(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.materialButtonToggleGroupStyle);
    }

    public MaterialButtonToggleGroup(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        this.originalCornerData = new ArrayList();
        AnonymousClass1 r14 = null;
        this.checkedStateTracker = new CheckedStateTracker(this, r14);
        this.pressedStateTracker = new PressedStateTracker(this, r14);
        this.onButtonCheckedListeners = new LinkedHashSet();
        this.childOrderComparator = new AnonymousClass1(this);
        this.skipCheckedStateTracker = false;
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(getContext(), r11, R.styleable.MaterialButtonToggleGroup, r12, r13, new int[0]);
        setSingleSelection(r15.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.checkedId = r15.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.selectionRequired = r15.getBoolean(R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        r15.recycle();
        ViewCompat.A0(this, 1);
    }

    public void setSingleSelection(@BoolRes int r10) {
        setSingleSelection(getResources().getBoolean(r10));
    }
}
