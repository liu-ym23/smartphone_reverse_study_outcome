package com.bytedance.android.shopping.widget.flow;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class TagFlowLayout extends FlowLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f187431j = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<Integer> f187432i;

    public interface a {
    }

    public interface b {
    }

    public el3.a getAdapter() {
        return null;
    }

    public void setOnSelectListener(a r100) {
    }

    public void setOnTagClickListener(b r100) {
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f187432i);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("key_default", super.onSaveInstanceState());
        StringBuilder r101 = new StringBuilder();
        if (((HashSet) this.f187432i).size() <= 0) goto L9;
        Iterator r102 = ((HashSet) this.f187432i).iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.append(((Integer) r102.next()).intValue());
        r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        goto L6
    L8:
        r101.deleteCharAt(r101.length() - 1);
    L9:
        r100.putString("key_choose_pos", r101.toString());
        return r100;
    }

    public List<List<View>> getAllViews() {
        return this.f187423a;
    }

    public List<Integer> getLineHeight() {
        return this.f187424b;
    }

    public TagFlowLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof Bundle) == false) goto L15;
        Bundle r101 = (Bundle) r100;
        String r102 = r101.getString("key_choose_pos");
        if (TextUtils.isEmpty(r102) == true) goto L13;
        String[] r103 = r102.split("\\|");
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L13;
        int r106 = CastIntegerProtector.parseInt(r103[r105]);
        Set<Integer> r107 = this.f187432i;
        HashSet r108 = (HashSet) r107;
        r108.add(Integer.valueOf(r106));
        el3.b r109 = (el3.b) getChildAt(r106);
        if (r109 != null) goto L11;
        r105 = r105 + 1;
        goto L7
    L11:
        r109.setChecked(true);
        r109.getTagView();
        throw null;
    L13:
        super.onRestoreInstanceState(r101.getParcelable("key_default"));
        return;
    L15:
        super.onRestoreInstanceState(r100);
    }

    public void setAdapter(el3.a r100) {
        throw null;
    }

    public void setMaxSelectCount(int r100) {
        if (((HashSet) this.f187432i).size() <= r100) goto L6;
        ((HashSet) this.f187432i).clear();
        return;
    }

    public TagFlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // com.bytedance.android.shopping.widget.flow.FlowLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        el3.b r104 = (el3.b) getChildAt(r103);
        if (r104.getVisibility() == 8) goto L10;
        if (r104.getTagView().getVisibility() != 8) goto L10;
        r104.setVisibility(8);
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        super.onMeasure(r100, r101);
    }

    public TagFlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f187432i = new HashSet();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.max_select_c, R.attr.tag_gravity_c, R.attr.tag_maxline_c, R.attr.tag_space_horizontal_c, R.attr.tag_space_vertical_c});
        r103.getInt(0, -1);
        r103.recycle();
    }
}
