package com.obric.utils.views.commonitemview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ContactsOCheckBoxLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0012\u001a\u00020\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0014J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0014H\u0016J\u0010\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010#\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010$J\u0010\u0010%\u001a\u00020\u00162\b\b\u0001\u0010&\u001a\u00020\bJ\b\u0010'\u001a\u00020\u0016H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/obric/utils/views/commonitemview/ContactsOCheckBoxLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "value", "checkedState", "getCheckedState", "()I", "setCheckedState", "(I)V", "getCheckBox", "isChecked", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "performClick", "setAlwaysLight", "light", "setChecked", MaterialConfigFormatNames.CHECKED, "setEnabled", "enabled", "setOnCheckedChangeListener", "listener", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "setOnCheckedStateChangedListener", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;", "setPrimaryColor", "color", "toggle", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsOCheckBoxLayout extends FrameLayout implements Checkable {
    private OCheckBox checkBox;

    public ContactsOCheckBoxLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public ContactsOCheckBoxLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ ContactsOCheckBoxLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public ContactsOCheckBoxLayout(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        if (r5 == null) goto L5;
        OCheckBox r2 = new OCheckBox(r4, r5, r6);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.gravity = 17;
        r2.setLayoutParams(r7);
        this.checkBox = r2;
        addView(r2);
        return;
    L5:
        OCheckBox r8 = new OCheckBox(r4);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2);
        r9.gravity = 17;
        r8.setLayoutParams(r9);
        this.checkBox = r8;
        addView(r8);
    }

    @Override // android.view.View
    public boolean performClick() {
        return this.checkBox.performClick();
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.checkBox.setEnabled(r2);
        if (r2 == true) goto L6;
        setBackground(null);
        return;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checkBox.isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        this.checkBox.setChecked(r1);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.checkBox.toggle();
    }

    public final int getCheckedState() {
        return this.checkBox.getCheckedState();
    }

    public final void setCheckedState(int r1) {
        this.checkBox.setCheckedState(r1);
    }

    public final void setOnCheckedChangeListener(OCheckBox.OnCheckedChangeListener r1) {
        this.checkBox.setOnCheckedChangeListener(r1);
    }

    public final void setOnCheckedStateChangedListener(OCheckBox.OnCheckedStateChangedListener r1) {
        this.checkBox.setOnCheckedStateChangedListener(r1);
    }

    public final void setPrimaryColor(int r1) {
        this.checkBox.setPrimaryColor(r1);
    }

    public final void setAlwaysLight(boolean r1) {
        this.checkBox.setAlwaysLight(r1);
    }

    public final OCheckBox getCheckBox() {
        return this.checkBox;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        int r4 = View.MeasureSpec.makeMeasureSpec(MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())), 1073741824);
        super.onMeasure(r4, r4);
    }
}
