package com.bytedance.android.ec.core.widget.flow;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes43.dex */
public class TagFlowLayout extends FlowLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f46096m = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ei.a f46097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f46098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<Integer> f46099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f46100l;

    public interface a {
    }

    public interface b {
        void a(int r100);
    }

    public void setOnSelectListener(a r100) {
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f46099k);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("key_default", super.onSaveInstanceState());
        StringBuilder r101 = new StringBuilder();
        if (((HashSet) this.f46099k).size() <= 0) goto L9;
        Iterator r102 = ((HashSet) this.f46099k).iterator();
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

    public ei.a getAdapter() {
        return this.f46097i;
    }

    public TagFlowLayout(Context r100) {
        this(r100, null);
    }

    public final void a(ei.b r100) {
        r100.setChecked(true);
        ei.a r101 = this.f46097i;
        r100.getTagView();
        r101.getClass();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof Bundle) == false) goto L14;
        Bundle r101 = (Bundle) r100;
        String r102 = r101.getString("key_choose_pos");
        if (TextUtils.isEmpty(r102) == true) goto L12;
        String[] r103 = r102.split("\\|");
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L12;
        int r106 = CastIntegerProtector.parseInt(r103[r105]);
        Set<Integer> r107 = this.f46099k;
        HashSet r108 = (HashSet) r107;
        r108.add(Integer.valueOf(r106));
        ei.b r109 = (ei.b) getChildAt(r106);
        if (r109 == null) goto L11;
        a(r109);
    L11:
        r105 = r105 + 1;
    L12:
        super.onRestoreInstanceState(r101.getParcelable("key_default"));
        return;
    L14:
        super.onRestoreInstanceState(r100);
    }

    public void setAdapter(ei.a r100) {
        this.f46097i = r100;
        r100.getClass();
        ((HashSet) this.f46099k).clear();
        removeAllViews();
        ei.a r101 = this.f46097i;
        HashSet<Integer> r102 = r101.f472756b;
        int r103 = 0;
    L3:
        List<T> r104 = r101.f472755a;
        if (r104 != 0) goto L6;
        int r105 = 0;
    L7:
        if (r103 >= r105) goto L16;
        View r106 = r101.a(ListProtector.get(r101.f472755a, r103));
        ei.b r107 = new ei.b(getContext());
        r106.setDuplicateParentStateEnabled(true);
        if (r106.getLayoutParams() == null) goto L11;
        r107.setLayoutParams(r106.getLayoutParams());
    L12:
        r106.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r107.addView(r106);
        addView(r107);
        if (r102.contains(Integer.valueOf(r103)) == false) goto L15;
        a(r107);
    L15:
        ei.a r108 = this.f46097i;
        ListProtector.get(r101.f472755a, r103);
        r108.getClass();
        r106.setClickable(false);
        r107.setOnClickListener(new com.bytedance.android.ec.core.widget.flow.a(this, r107, r103));
        r103 = r103 + 1;
        goto L3
    L11:
        r107.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        goto L12
    L16:
        this.f46099k.addAll(r102);
        return;
    L6:
        r105 = r104.size();
        goto L7
    }

    public void setMaxSelectCount(int r100) {
        if (((HashSet) this.f46099k).size() <= r100) goto L5;
        ((HashSet) this.f46099k).clear();
    L5:
        this.f46098j = r100;
    }

    public void setOnTagClickListener(b r100) {
        this.f46100l = r100;
    }

    public TagFlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // com.bytedance.android.ec.core.widget.flow.FlowLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        ei.b r104 = (ei.b) getChildAt(r103);
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
        this.f46099k = new HashSet();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.max_select_cc, R.attr.tag_gravity_cc, R.attr.tag_maxline_cc, R.attr.tag_space_horizontal_cc, R.attr.tag_space_vertical_cc});
        this.f46098j = r103.getInt(0, -1);
        r103.recycle();
    }
}
