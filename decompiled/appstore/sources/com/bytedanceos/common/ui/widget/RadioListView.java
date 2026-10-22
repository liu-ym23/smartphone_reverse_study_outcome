package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.toolbox.j;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class RadioListView extends LinearLayout {
    public static final int TAB_BTN_LEFT = 0;
    public static final int TAB_BTN_MID = 1;
    public static final int TAB_BTN_RIGHT = 2;
    private ViewGroup mContainer;
    public View mDivider;
    private CheckChangedListener mListener;
    private OTabSegmentedLayout mRadioGroup;

    public interface CheckChangedListener {
        void onCheckChanged(int r10);
    }

    public RadioListView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ String[] a(int[] r10, int r11) {
        return lambda$updateTableName$1(r10, r11);
    }

    public static /* synthetic */ String b(RadioListView r10, int r11) {
        return r10.lambda$updateTableName$0(r11);
    }

    private /* synthetic */ String lambda$updateTableName$0(int r10) {
        return getContext().getString(r10);
    }

    private static /* synthetic */ String[] lambda$updateTableName$1(int[] r10, int r11) {
        return new String[r10.length];
    }

    public ViewGroup getContainer() {
        return this.mContainer;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R$layout.radio_list, this);
        this.mDivider = findViewById(R$id.line);
        OTabSegmentedLayout r10 = (OTabSegmentedLayout) findViewById(R$id.radiogroup);
        this.mRadioGroup = r10;
        r10.setOnTabSelectListener(new AnonymousClass1(this));
        this.mContainer = (ViewGroup) findViewById(R$id.container);
    }

    public void setCheckChangedListener(CheckChangedListener r10) {
        this.mListener = r10;
    }

    public void setLeftChecked() {
        this.mRadioGroup.setCurrentTab(0);
    }

    public void setMiddleChecked() {
        if (this.mRadioGroup.getChildCount() != 3) goto L6;
        this.mRadioGroup.setCurrentTab(1);
        return;
    }

    public void setRadioCount(int r10) {
    }

    public void setRadioGroupChecked(int r10) {
        CheckChangedListener r11 = this.mListener;
        if (r11 == null) goto L5;
        r11.onCheckChanged(r10);
    L5:
        OTabSegmentedLayout r12 = this.mRadioGroup;
        if (r12 == null) goto L9;
        r12.setCurrentTab(r10);
        return;
    }

    public void setRightChecked() {
        if (this.mRadioGroup.getChildCount() != 3) goto L6;
        this.mRadioGroup.setCurrentTab(2);
        return;
    }

    public void updateTableName(final int[] r10) {
        if (r10 != null) goto L4;
    L8:
        j.m("res size must equal to child count");
        return;
    L4:
        if (r10.length < 2) goto L8;
        String[] r11 = (String[]) Arrays.stream(r10).mapToObj(new b(this)).toArray(new c(r10));
        this.mRadioGroup.n(r11, null);
    }

    public RadioListView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public RadioListView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
