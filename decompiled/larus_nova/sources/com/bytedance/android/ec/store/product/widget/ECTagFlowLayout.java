package com.bytedance.android.ec.store.product.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.text.TextUtilsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.android.material.internal.FlowLayout;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import xm.d;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0019\u001aB#\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u001b\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0018J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\r\u001a\u00020\b\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\f\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/store/product/widget/ECTagFlowLayout;", "Lcom/google/android/material/internal/FlowLayout;", "", "", "Landroid/view/View;", "getAllViews", "Lcom/bytedance/android/ec/store/product/widget/ECTagFlowLayout$b;", "onTagClickListener", "", "setOnTagClickListener", ExifInterface.GPS_DIRECTION_TRUE, "Lxm/a;", "adapter", "setAdapter", "getAdapter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECTagFlowLayout extends FlowLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f48377m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f48378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f48379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f48380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f48381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f48382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public xm.a<?> f48383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Integer> f48384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f48385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<List<View>> f48386i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Integer> f48387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<Integer> f48388k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<View> f48389l;

    public static final class a {
    }

    public interface b {
        boolean a(View r100, FlowLayout r101);
    }

    static {
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("key_default", super.onSaveInstanceState());
        StringBuilder r101 = new StringBuilder();
        if (((HashSet) this.f48384g).size() <= 0) goto L9;
        Iterator r102 = ((HashSet) this.f48384g).iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.append(((Number) r102.next()).intValue());
        r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        goto L6
    L8:
        r101.deleteCharAt(r101.length() - 1);
    L9:
        r100.putString("key_choose_pos", r101.toString());
        return r100;
    }

    public final xm.a<?> getAdapter() {
        return this.f48383f;
    }

    public final List<List<View>> getAllViews() {
        return this.f48386i;
    }

    public ECTagFlowLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof Bundle) == false) goto L26;
        Bundle r101 = (Bundle) r100;
        String r102 = r101.getString("key_choose_pos");
        if (TextUtils.isEmpty(r102) == true) goto L24;
        if (r102 == null) goto L23;
        List r103 = StringsKt.split$default(r102, new String[]{"\\|"}, false, 0, 6, null);
        if (r103 == null) goto L32;
        int r104 = 0;
        Object[] r105 = r103.toArray(new String[0]);
        if (r105 == null) goto L22;
        String[] r106 = (String[]) r105;
        int r107 = r106.length;
    L12:
        if (r104 >= r107) goto L24;
        int r108 = CastIntegerProtector.parseInt(r106[r104]);
        Set<Integer> r109 = this.f48384g;
        HashSet r110 = (HashSet) r109;
        r110.add(Integer.valueOf(r108));
        View r111 = getChildAt(r108);
        if (r111 == null) goto L20;
        d r112 = (d) r111;
        r112.setChecked(true);
        if (this.f48383f == null) goto L18;
        r112.getTagView();
    L18:
        r104 = r104 + 1;
        goto L12
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.store.product.widget.TagView");
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L32:
        return;
    L23:
        return;
    L24:
        super.onRestoreInstanceState(r101.getParcelable("key_default"));
        return;
    L26:
        super.onRestoreInstanceState(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void setAdapter(xm.a<T> r110) {
        Intrinsics.checkNotNullParameter(r110, "adapter");
        this.f48383f = r110;
        ((HashSet) this.f48384g).clear();
        xm.a<?> r111 = this.f48383f;
        if (r111 == null) goto L23;
        removeAllViews();
        HashSet<Integer> r100 = r111.f564523b;
        int r101 = r111.f564522a.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L17;
        View r103 = r111.a(ListProtector.get(r111.f564522a, r102));
        d r104 = new d(getContext());
        r103.setDuplicateParentStateEnabled(true);
        if (r103.getLayoutParams() == null) goto L10;
        r104.setLayoutParams(r103.getLayoutParams());
    L11:
        r104.addView(r103);
        addView(r104);
        if (r100.contains(Integer.valueOf(r102)) == false) goto L16;
        r104.setChecked(true);
        if (this.f48383f == null) goto L16;
        r104.getTagView();
    L16:
        ListProtector.get(r111.f564522a, r102);
        r103.setClickable(false);
        r104.setOnClickListener(new xm.b(this, r104, r102));
        r102 = r102 + 1;
        goto L6
    L10:
        r104.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        goto L11
    L17:
        this.f48384g.addAll(r100);
        return;
    }

    public final void setOnTagClickListener(b r100) {
        this.f48385h = r100;
    }

    public ECTagFlowLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // com.google.android.material.internal.FlowLayout, android.view.View
    public final void onMeasure(int r210, int r211) {
        int r100 = View.MeasureSpec.getSize(r210);
        int r101 = View.MeasureSpec.getMode(r210);
        int r102 = View.MeasureSpec.getSize(r211);
        int r103 = View.MeasureSpec.getMode(r211);
        int r104 = getChildCount();
        int r105 = 0;
        int r106 = 0;
    L3:
        int r107 = 8;
        if (r106 >= r104) goto L16;
        View r108 = getChildAt(r106);
        if (r108 == null) goto L15;
        d r109 = (d) r108;
        if (r109.getVisibility() == 8) goto L13;
        if (r109.getTagView().getVisibility() != 8) goto L13;
        r109.setVisibility(8);
    L13:
        r106 = r106 + 1;
        goto L3
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.store.product.widget.TagView");
    L16:
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 1;
    L17:
        if (r105 >= r104) goto L42;
        View r115 = getChildAt(r105);
        if (r115.getVisibility() == r107) goto L21;
        measureChild(r115, r210, r211);
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L41;
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
        int r118 = r102;
        int r119 = (r115.getMeasuredWidth() + r117.leftMargin) + r117.rightMargin;
        r113 = (r115.getMeasuredHeight() + r117.topMargin) + r117.bottomMargin;
        if ((r110 + r119) <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L33;
        r111 = RangesKt.coerceAtLeast(r111, r110);
        int r120 = r119 + this.f48380c;
        r112 = r112 + r113;
        r114 = r114 + 1;
        int r121 = this.f48381d;
        if (1 > r121) goto L34;
        if (r114 <= r121) goto L34;
        r113 = r113;
    L43:
        if (r113 <= 0) goto L46;
        r112 = r112 + (((r112 / r113) - 1) * this.f48379b);
    L46:
        if (r101 == 1073741824) goto L49;
        r100 = getPaddingRight() + (r111 + getPaddingLeft());
    L49:
        if (r103 != 1073741824) goto L51;
        int r122 = r118;
    L52:
        setMeasuredDimension(r100, r122);
        return;
    L51:
        r122 = (r112 + getPaddingTop()) + getPaddingBottom();
    L34:
        int r123 = r120;
        if (r105 != (r104 - 1)) goto L38;
        r112 = r112 + r113;
        r111 = RangesKt.coerceAtLeast(r123, r111);
    L38:
        r110 = r123;
    L39:
        r105 = r105 + 1;
        r102 = r118;
        r107 = 8;
        goto L17
    L33:
        r120 = r110 + (r119 + this.f48380c);
        r113 = RangesKt.coerceAtLeast(r113, r113);
        goto L34
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L21:
        if (r105 != (r104 - 1)) goto L23;
        r111 = RangesKt.coerceAtLeast(r110, r111);
        r112 = r112 + r113;
    L23:
        r118 = r102;
        goto L39
    L42:
        r118 = r102;
        goto L43
    }

    public ECTagFlowLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = 1;
        this.f48381d = 1;
        this.f48382e = -1;
        this.f48384g = new HashSet();
        this.f48386i = new ArrayList();
        this.f48387j = new ArrayList();
        this.f48388k = new ArrayList();
        this.f48389l = new ArrayList();
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.auto_select_effect, R.attr.gravity, R.attr.marginOutside, R.attr.maxLines, R.attr.max_select, R.attr.paddingBottom, R.attr.paddingEnd, R.attr.paddingStart, R.attr.paddingTop, R.attr.rowSpacing, R.attr.tag_gravity_ec, R.attr.tag_maxline, R.attr.tag_space_horizontal, R.attr.tag_space_vertical, R.attr.textColor, R.attr.textSize});
        int r105 = r104.getInt(10, -1);
        this.f48378a = r105;
        this.f48380c = r104.getDimensionPixelSize(12, com.bytedance.android.shopping.extensions.b.b(4));
        this.f48379b = r104.getDimensionPixelSize(13, 0);
        this.f48381d = r104.getInteger(11, 1);
        this.f48382e = r104.getInt(4, -1);
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L8;
        if (r105 == (-1)) goto L7;
        r103 = getLeft();
    L7:
        this.f48378a = r103;
    L8:
        r104.recycle();
    }

    @Override // com.google.android.material.internal.FlowLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        ((ArrayList) this.f48386i).clear();
        ((ArrayList) this.f48387j).clear();
        ((ArrayList) this.f48388k).clear();
        this.f48389l.clear();
        int r100 = getWidth();
        int r101 = getChildCount();
        int r102 = 1;
        int r103 = 0;
        int r104 = 0;
        int r105 = 1;
        int r106 = 0;
    L3:
        int r112 = 8;
        if (r103 >= r101) goto L22;
        View r113 = getChildAt(r103);
        if (r113.getVisibility() == 8) goto L19;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L21;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        int r116 = (r113.getMeasuredWidth() + r115.leftMargin) + r115.rightMargin;
        int r117 = (r113.getMeasuredHeight() + r115.topMargin) + r115.bottomMargin;
        if ((r116 + r104) <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L18;
        r105 = r105 + 1;
        int r118 = this.f48381d;
        if (1 > r118) goto L17;
        if (r105 > r118) goto L22;
    L17:
        List<Integer> r107 = this.f48387j;
        ArrayList r108 = (ArrayList) r107;
        r108.add(Integer.valueOf(r106));
        List<List<View>> r109 = this.f48386i;
        ArrayList r119 = (ArrayList) r109;
        r119.add(this.f48389l);
        List<Integer> r120 = this.f48388k;
        ArrayList r121 = (ArrayList) r120;
        r121.add(Integer.valueOf(r104));
        this.f48389l = new ArrayList();
        r106 = r117;
        r104 = 0;
    L18:
        r104 = r104 + (r116 + this.f48380c);
        r106 = RangesKt.coerceAtLeast(r106, r117);
        this.f48389l.add(r113);
        goto L19
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        r103 = r103 + 1;
    L22:
        List<Integer> r122 = this.f48387j;
        ArrayList r123 = (ArrayList) r122;
        r123.add(Integer.valueOf(r106));
        List<Integer> r124 = this.f48388k;
        ArrayList r125 = (ArrayList) r124;
        r125.add(Integer.valueOf(r104));
        List<List<View>> r126 = this.f48386i;
        ArrayList r127 = (ArrayList) r126;
        r127.add(this.f48389l);
        int r128 = getPaddingLeft();
        int r129 = getPaddingTop();
        int r130 = ((ArrayList) this.f48386i).size();
        int r131 = 0;
    L23:
        if (r131 >= r130) goto L44;
        List<View> r132 = (List) ListProtector.get(this.f48386i, r131);
        this.f48389l = r132;
        int r133 = r132.size();
        int r134 = ((Number) ListProtector.get(this.f48387j, r131)).intValue() + this.f48379b;
        int r135 = ((Number) ListProtector.get(this.f48388k, r131)).intValue();
        int r136 = this.f48378a;
        if (r136 == (-1)) goto L31;
        if (r136 == 0) goto L30;
        if (r136 != r102) goto L32;
        r128 = (r100 - (r135 + getPaddingLeft())) - getPaddingRight();
        CollectionsKt.reverse(this.f48389l);
    L32:
        int r137 = 0;
    L33:
        if (r137 >= r133) goto L43;
        View r138 = (View) ListProtector.get(this.f48389l, r137);
        if (r138.getVisibility() == r112) goto L40;
        ViewGroup.LayoutParams r139 = r138.getLayoutParams();
        if (r139 == null) goto L42;
        ViewGroup.MarginLayoutParams r140 = (ViewGroup.MarginLayoutParams) r139;
        int r141 = r140.leftMargin + r128;
        int r142 = r140.topMargin + r129;
        r138.layout(r141, r142, r141 + r138.getMeasuredWidth(), r142 + r138.getMeasuredHeight());
        r128 = r128 + (((r138.getMeasuredWidth() + r140.leftMargin) + r140.rightMargin) + this.f48380c);
        goto L40
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L40:
        r137 = r137 + 1;
        r112 = 8;
        goto L33
    L43:
        r129 = r129 + r134;
        r131 = r131 + 1;
        r102 = 1;
        r112 = 8;
        goto L23
    L30:
        r128 = ((r100 - r135) / 2) + getPaddingLeft();
        goto L32
    L31:
        r128 = getPaddingLeft();
        goto L32
    }
}
