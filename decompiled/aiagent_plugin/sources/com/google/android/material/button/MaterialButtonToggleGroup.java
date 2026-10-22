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
import androidx.core.view.ViewCompat;
import androidx.core.view.g;
import com.google.android.material.internal.l;
import com.google.android.material.internal.r;
import com.google.android.material.shape.m;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    private static final int DEF_STYLE_RES = 0;
    private static final String LOG_TAG = "MaterialButtonToggleGroup";
    private Set<Integer> checkedIds;
    private Integer[] childOrder;
    private final Comparator<MaterialButton> childOrderComparator;
    private final int defaultCheckId;
    private final LinkedHashSet<b> onButtonCheckedListeners;
    private final List<a> originalCornerData;
    private final c pressedStateTracker;
    private boolean selectionRequired;
    private boolean singleSelection;
    private boolean skipCheckedStateTracker;

    private static class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.android.material.shape.c f13269e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.google.android.material.shape.c f13270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.google.android.material.shape.c f13271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        com.google.android.material.shape.c f13272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.google.android.material.shape.c f13273d;

        static {
            f13269e = new com.google.android.material.shape.a(0.0f);
        }

        a(com.google.android.material.shape.c r3, com.google.android.material.shape.c r4, com.google.android.material.shape.c r5, com.google.android.material.shape.c r6) {
            com.google.android.material.shape.c r7 = (com.google.android.material.shape.c) ZeusTransformUtils.wrapperContextForParams(r3, com.google.android.material.shape.c.class, "com.obric.aiagent.plugin");
            com.google.android.material.shape.c r8 = (com.google.android.material.shape.c) ZeusTransformUtils.wrapperContextForParams(r4, com.google.android.material.shape.c.class, "com.obric.aiagent.plugin");
            com.google.android.material.shape.c r9 = (com.google.android.material.shape.c) ZeusTransformUtils.wrapperContextForParams(r5, com.google.android.material.shape.c.class, "com.obric.aiagent.plugin");
            com.google.android.material.shape.c r10 = (com.google.android.material.shape.c) ZeusTransformUtils.wrapperContextForParams(r6, com.google.android.material.shape.c.class, "com.obric.aiagent.plugin");
            this.f13270a = r7;
            this.f13271b = r9;
            this.f13272c = r10;
            this.f13273d = r8;
        }

        public static a a(a r0, View r1) {
            if (r.a(r1) == false) goto L6;
            return b(r0);
        L6:
            return a(r0);
        }

        public static a b(a r0, View r1) {
            if (r.a(r1) == false) goto L6;
            return a(r0);
        L6:
            return b(r0);
        }

        public static a a(a r3) {
            com.google.android.material.shape.c r1 = r3.f13270a;
            com.google.android.material.shape.c r4 = r3.f13273d;
            com.google.android.material.shape.c r2 = f13269e;
            return new a(r1, r4, r2, r2);
        }

        public static a b(a r3) {
            com.google.android.material.shape.c r1 = f13269e;
            return new a(r1, r1, r3.f13271b, r3.f13272c);
        }

        public static a c(a r3) {
            com.google.android.material.shape.c r1 = r3.f13270a;
            com.google.android.material.shape.c r2 = f13269e;
            return new a(r1, r2, r3.f13271b, r2);
        }

        public static a d(a r3) {
            com.google.android.material.shape.c r1 = f13269e;
            return new a(r1, r3.f13273d, r1, r3.f13272c);
        }
    }

    public interface b {
        void a(MaterialButtonToggleGroup r1, int r2, boolean r3);
    }

    private class c implements MaterialButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialButtonToggleGroup f13274a;

        private c(MaterialButtonToggleGroup r1) {
            this.f13274a = r1;
        }

        /* synthetic */ c(MaterialButtonToggleGroup r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(MaterialButton r1, boolean r2) {
            this.f13274a.invalidate();
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    static /* synthetic */ int access$100(MaterialButtonToggleGroup r0, View r1) {
        return r0.getIndexWithinVisibleButtons(r1);
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, "style", "Widget_MaterialComponents_MaterialButtonToggleGroup");
    }

    public MaterialButtonToggleGroup(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public MaterialButtonToggleGroup(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.materialButtonToggleGroupStyle, "attr", "materialButtonToggleGroupStyle"));
    }

    public MaterialButtonToggleGroup(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        int r6 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r12, r3, r11, r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r11);
        this.originalCornerData = new ArrayList();
        this.pressedStateTracker = new c(this, null);
        this.onButtonCheckedListeners = new LinkedHashSet();
        this.childOrderComparator = new AnonymousClass1(this);
        this.skipCheckedStateTracker = false;
        this.checkedIds = new HashSet();
        TypedArray r13 = l.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, R.styleable.MaterialButtonToggleGroup, r11, r6, new int[0]);
        setSingleSelection(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialButtonToggleGroup_singleSelection, "styleable", "MaterialButtonToggleGroup_singleSelection"), false));
        this.defaultCheckId = r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialButtonToggleGroup_checkedButton, "styleable", "MaterialButtonToggleGroup_checkedButton"), -1);
        this.selectionRequired = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialButtonToggleGroup_selectionRequired, "styleable", "MaterialButtonToggleGroup_selectionRequired"), false);
        setChildrenDrawingOrderEnabled(true);
        r13.recycle();
        ViewCompat.c(this, 1);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r0 = this.defaultCheckId;
        if (r0 == (-1)) goto L6;
        updateCheckedIds(Collections.singleton(Integer.valueOf(r0)));
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r1) {
        updateChildOrder();
        super.dispatchDraw(r1);
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r6, ViewGroup.LayoutParams r7) {
        if (ZeusTransformUtils.instanceOf(r5, MaterialButton.class) == true) goto L6;
        INVOKESTATIC_com_google_android_material_button_MaterialButtonToggleGroup_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOG_TAG, "Child views must be of type MaterialButton.");
        return;
    L6:
        super.addView(r5, r6, r7);
        MaterialButton r8 = (MaterialButton) ZeusTransformUtils.preCheckCast(r5, MaterialButton.class, "com.obric.aiagent.plugin");
        setGeneratedIdIfNeeded(r8);
        setupButtonChild(r8);
        checkInternal(r8.getId(), r8.isChecked());
        m r9 = r8.getShapeAppearanceModel();
        this.originalCornerData.add(new a(r9.f(), r9.i(), r9.g(), r9.h()));
        ViewCompat.a(r8, new AnonymousClass2(this));
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r3) {
        super.onViewRemoved(r3);
        if (ZeusTransformUtils.instanceOf(r3, MaterialButton.class) == false) goto L5;
        ((MaterialButton) ZeusTransformUtils.preCheckCast(r3, MaterialButton.class, "com.obric.aiagent.plugin")).setOnPressedChangeListenerInternal(null);
    L5:
        int r4 = indexOfChild(r3);
        if (r4 < 0) goto L8;
        this.originalCornerData.remove(r4);
    L8:
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r4) {
        super.onInitializeAccessibilityNodeInfo(r4);
        androidx.core.view.accessibility.b r5 = androidx.core.view.accessibility.b.a(r4);
        int r0 = getVisibleButtonCount();
        if (isSingleSelection() == false) goto L5;
        int r3 = 1;
    L6:
        r5.b(androidx.core.view.accessibility.b.f.a(1, r0, false, r3));
        return;
    L5:
        r3 = 2;
        goto L6
    }

    public void check(int r2) {
        checkInternal(r2, true);
    }

    public void uncheck(int r2) {
        checkInternal(r2, false);
    }

    public void clearChecked() {
        updateCheckedIds(new HashSet());
    }

    public int getCheckedButtonId() {
        if (this.singleSelection == true) goto L5;
    L7:
        return -1;
    L5:
        if (this.checkedIds.isEmpty() == true) goto L7;
        return ((Integer) ZeusTransformUtils.preCheckCast(this.checkedIds.iterator().next(), Integer.class, "com.obric.aiagent.plugin")).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L9;
        int r2 = getChildButton(r1).getId();
        if (this.checkedIds.contains(Integer.valueOf(r2)) == false) goto L8;
        r0.add(Integer.valueOf(r2));
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    public void addOnButtonCheckedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.onButtonCheckedListeners.add(r4);
    }

    public void removeOnButtonCheckedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.onButtonCheckedListeners.remove(r4);
    }

    public void clearOnButtonCheckedListeners() {
        this.onButtonCheckedListeners.clear();
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    public void setSingleSelection(boolean r2) {
        if (this.singleSelection == r2) goto L6;
        this.singleSelection = r2;
        clearChecked();
        return;
    }

    public void setSelectionRequired(boolean r1) {
        this.selectionRequired = r1;
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public void setSingleSelection(int r2) {
        setSingleSelection(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getBoolean(r2));
    }

    private void setCheckedStateForView(int r3, boolean r4) {
        View r5 = findViewById(r3);
        if (ZeusTransformUtils.instanceOf(r5, MaterialButton.class) == false) goto L6;
        this.skipCheckedStateTracker = true;
        ((MaterialButton) ZeusTransformUtils.preCheckCast(r5, MaterialButton.class, "com.obric.aiagent.plugin")).setChecked(r4);
        this.skipCheckedStateTracker = false;
        return;
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int r0 = getFirstVisibleChildIndex();
        if (r0 != (-1)) goto L5;
        return;
    L5:
        int r1 = r0 + 1;
    L7:
        if (r1 >= getChildCount()) goto L13;
        MaterialButton r2 = getChildButton(r1);
        int r3 = Math.min(r2.getStrokeWidth(), getChildButton(r1 - 1).getStrokeWidth());
        LinearLayout.LayoutParams r4 = buildLayoutParams(r2);
        if (getOrientation() != 0) goto L11;
        g.b(r4, 0);
        g.a(r4, -r3);
        r4.topMargin = 0;
    L12:
        r2.setLayoutParams(r4);
        r1 = r1 + 1;
        goto L7
    L11:
        r4.bottomMargin = 0;
        r4.topMargin = -r3;
        g.a(r4, 0);
        goto L12
    L13:
        resetChildMargins(r0);
    }

    private MaterialButton getChildButton(int r2) {
        return (MaterialButton) ZeusTransformUtils.preCheckCast(getChildAt(r2), MaterialButton.class, "com.obric.aiagent.plugin");
    }

    private void resetChildMargins(int r3) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        if (r3 == (-1)) goto L14;
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getChildButton(r3).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (getOrientation() != 1) goto L11;
        r4.topMargin = 0;
        r4.bottomMargin = 0;
        return;
    L11:
        g.b(r4, 0);
        g.a(r4, 0);
        r4.leftMargin = 0;
        r4.rightMargin = 0;
        return;
    }

    void updateChildShapes() {
        int r0 = getChildCount();
        int r1 = getFirstVisibleChildIndex();
        int r2 = getLastVisibleChildIndex();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L9;
        MaterialButton r4 = getChildButton(r3);
        if (r4.getVisibility() == 8) goto L8;
        m.a r5 = r4.getShapeAppearanceModel().n();
        updateBuilderWithCornerData(r5, getNewCornerData(r3, r1, r2));
        r4.setShapeAppearanceModel(r5.a());
    L8:
        r3 = r3 + 1;
        goto L3
    }

    private int getFirstVisibleChildIndex() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (isChildVisible(r1) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    private int getLastVisibleChildIndex() {
        int r0 = getChildCount() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (isChildVisible(r0) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    private boolean isChildVisible(int r1) {
        if (getChildAt(r1).getVisibility() == 8) goto L5;
        return true;
    L5:
        return false;
    }

    private int getVisibleButtonCount() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= getChildCount()) goto L11;
        if (ZeusTransformUtils.instanceOf(getChildAt(r0), MaterialButton.class) == false) goto L10;
        if (isChildVisible(r0) == false) goto L10;
        r1 = r1 + 1;
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return r1;
    }

    private int getIndexWithinVisibleButtons(View r6) {
        if (ZeusTransformUtils.instanceOf(r6, MaterialButton.class) == true) goto L5;
        return -1;
    L5:
        int r0 = 0;
        int r2 = 0;
    L7:
        if (r0 >= getChildCount()) goto L17;
        if (getChildAt(r0) == r6) goto L10;
        if (ZeusTransformUtils.instanceOf(getChildAt(r0), MaterialButton.class) == false) goto L16;
        if (isChildVisible(r0) == false) goto L16;
        r2 = r2 + 1;
    L16:
        r0 = r0 + 1;
        goto L7
    L10:
        return r2;
    L17:
        return -1;
    }

    private a getNewCornerData(int r4, int r5, int r6) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.originalCornerData.get(r4), a.class, "com.obric.aiagent.plugin");
        if (r5 != r6) goto L6;
        return r0;
    L6:
        if (getOrientation() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r4 != r5) goto L14;
        if (r1 == false) goto L13;
        return a.a(r0, this);
    L13:
        return a.c(r0);
    L14:
        if (r4 != r6) goto L19;
        if (r1 == false) goto L18;
        return a.b(r0, this);
    L18:
        return a.d(r0);
    L19:
        return null;
    L8:
        r1 = false;
        goto L9
    }

    private static void updateBuilderWithCornerData(m.a r1, a r2) {
        if (r2 != null) goto L5;
        r1.a(0.0f);
        return;
    L5:
        r1.b(r2.f13270a).e(r2.f13273d).c(r2.f13271b).d(r2.f13272c);
    }

    private void checkInternal(int r3, boolean r4) {
        if (r3 != (-1)) goto L6;
        INVOKESTATIC_com_google_android_material_button_MaterialButtonToggleGroup_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOG_TAG, "Button ID is not valid: " + r3);
        return;
    L6:
        HashSet r0 = new HashSet(this.checkedIds);
        if (r4 == true) goto L9;
    L16:
        if (r4 == false) goto L18;
        return;
    L18:
        if (r0.contains(Integer.valueOf(r3)) == true) goto L20;
        return;
    L20:
        if (this.selectionRequired == true) goto L22;
    L23:
        r0.remove(Integer.valueOf(r3));
    L24:
        updateCheckedIds(r0);
        return;
    L22:
        if (r0.size() <= 1) goto L24;
    L9:
        if (r0.contains(Integer.valueOf(r3)) == true) goto L16;
        if (this.singleSelection == true) goto L13;
    L15:
        r0.add(Integer.valueOf(r3));
        goto L24
    L13:
        if (r0.isEmpty() == true) goto L15;
        r0.clear();
        goto L15
    }

    private void updateCheckedIds(Set<Integer> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
        Set<Integer> r0 = this.checkedIds;
        this.checkedIds = new HashSet(r7);
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L9;
        int r2 = getChildButton(r1).getId();
        setCheckedStateForView(r2, r7.contains(Integer.valueOf(r2)));
        if (r0.contains(Integer.valueOf(r2)) == r7.contains(Integer.valueOf(r2))) goto L8;
        dispatchOnButtonChecked(r2, r7.contains(Integer.valueOf(r2)));
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        invalidate();
    }

    private void dispatchOnButtonChecked(int r5, boolean r6) {
        Iterator<b> r0 = this.onButtonCheckedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.aiagent.plugin")).a(this, r5, r6);
        goto L4
    }

    private void setGeneratedIdIfNeeded(MaterialButton r2) {
        if (r2.getId() != (-1)) goto L6;
        r2.setId(ViewCompat.a());
        return;
    }

    private void setupButtonChild(MaterialButton r3) {
        r3.setMaxLines(1);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        r3.setCheckable(true);
        r3.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        r3.setShouldDrawSurfaceColorStroke(true);
    }

    private LinearLayout.LayoutParams buildLayoutParams(View r2) {
        ViewGroup.LayoutParams r1 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, LinearLayout.LayoutParams.class) == false) goto L7;
        return (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L7:
        return new LinearLayout.LayoutParams(r1.width, r1.height);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r1, int r2) {
        Integer[] r0 = this.childOrder;
        if (r0 != null) goto L5;
    L9:
        INVOKESTATIC_com_google_android_material_button_MaterialButtonToggleGroup_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(LOG_TAG, "Child order wasn't updated");
        return r2;
    L5:
        if (r2 >= r0.length) goto L9;
        return r0[r2].intValue();
    }

    private void updateChildOrder() {
        TreeMap r0 = new TreeMap(this.childOrderComparator);
        int r1 = getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.put(getChildButton(r3), Integer.valueOf(r3));
        r3 = r3 + 1;
        goto L3
    L5:
        this.childOrder = (Integer[]) ZeusTransformUtils.preCheckCast(r0.values().toArray(new Integer[0]), Integer[].class, "com.obric.aiagent.plugin");
    }

    void onButtonCheckedStateChanged(MaterialButton r2, boolean r3) {
        if (this.skipCheckedStateTracker == false) goto L5;
        return;
    L5:
        checkInternal(r2.getId(), r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_google_android_material_button_MaterialButtonToggleGroup_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_google_android_material_button_MaterialButtonToggleGroup_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
