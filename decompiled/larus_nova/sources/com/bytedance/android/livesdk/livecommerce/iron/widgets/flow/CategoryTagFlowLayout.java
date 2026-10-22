package com.bytedance.android.livesdk.livecommerce.iron.widgets.flow;

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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes10.dex */
public abstract class CategoryTagFlowLayout extends CategoryFlowLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<Integer> f149229j;

    public interface a {
    }

    public interface b {
    }

    public com.bytedance.android.livesdk.livecommerce.iron.widgets.flow.a getAdapter() {
        return null;
    }

    public abstract ei2.a getExpandView();

    public void setContainerWidth(int r100) {
    }

    public void setOnSelectListener(a r100) {
    }

    public void setOnTagClickListener(b r100) {
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f149229j);
    }

    public List<List<View>> getVisibleViews() {
        List<List<View>> r100 = this.f149220a;
        ArrayList r101 = (ArrayList) r100;
        return r101.subList(0, this.f149228i);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("key_default", super.onSaveInstanceState());
        StringBuilder r101 = new StringBuilder();
        if (((HashSet) this.f149229j).size() <= 0) goto L9;
        Iterator r102 = ((HashSet) this.f149229j).iterator();
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

    public CategoryTagFlowLayout(Context r100) {
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
        Set<Integer> r107 = this.f149229j;
        HashSet r108 = (HashSet) r107;
        r108.add(Integer.valueOf(r106));
        ei2.a r109 = (ei2.a) getChildAt(r106);
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

    public void setAdapter(com.bytedance.android.livesdk.livecommerce.iron.widgets.flow.a r100) {
        throw null;
    }

    public void setMaxSelectCount(int r100) {
        if (((HashSet) this.f149229j).size() <= r100) goto L6;
        ((HashSet) this.f149229j).clear();
        return;
    }

    public CategoryTagFlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.widgets.flow.CategoryFlowLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L15;
        View r104 = getChildAt(r103);
        if (r104.getVisibility() == 8) goto L14;
        if ((r104 instanceof ei2.a) == false) goto L14;
        ei2.a r105 = (ei2.a) r104;
        if (r105.getTagView() == null) goto L14;
        if (r105.getTagView().getVisibility() != 8) goto L14;
        r104.setVisibility(8);
    L14:
        r103 = r103 + 1;
        goto L3
    L15:
        super.onMeasure(r100, r101);
    }

    public CategoryTagFlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f149229j = new HashSet();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.max_select_cc, R.attr.tag_gravity_cc, R.attr.tag_maxline_cc, R.attr.tag_space_horizontal_cc, R.attr.tag_space_vertical_cc});
        r103.getInt(0, -1);
        r103.recycle();
    }
}
