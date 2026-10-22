package com.bytedance.android.ec.window.base.product.widget;

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
import ap.e;
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

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001b\u001cB#\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u001aJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0007J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/window/base/product/widget/ECWindowTagFlowLayout;", "Lcom/google/android/material/internal/FlowLayout;", "", "", "spacePx", "", "setTagSpaceHorizontal", "", "Landroid/view/View;", "getAllViews", "Lcom/bytedance/android/ec/window/base/product/widget/ECWindowTagFlowLayout$b;", "onTagClickListener", "setOnTagClickListener", ExifInterface.GPS_DIRECTION_TRUE, "Lap/a;", "adapter", "setAdapter", "getAdapter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECWindowTagFlowLayout extends FlowLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f49428m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f49429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f49432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f49433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ap.a<?> f49434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Integer> f49435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f49436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<List<View>> f49437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Integer> f49438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<Integer> f49439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<View> f49440l;

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
        if (((HashSet) this.f49435g).size() <= 0) goto L9;
        Iterator r102 = ((HashSet) this.f49435g).iterator();
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

    public final ap.a<?> getAdapter() {
        return this.f49434f;
    }

    public final List<List<View>> getAllViews() {
        return this.f49437i;
    }

    public ECWindowTagFlowLayout(Context r100) {
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
        Set<Integer> r109 = this.f49435g;
        HashSet r110 = (HashSet) r109;
        r110.add(Integer.valueOf(r108));
        View r111 = getChildAt(r108);
        if (r111 == null) goto L20;
        e r112 = (e) r111;
        r112.setChecked(true);
        if (this.f49434f == null) goto L18;
        r112.getTagView();
    L18:
        r104 = r104 + 1;
        goto L12
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.product.widget.WindowTagView");
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
    public final <T> void setAdapter(ap.a<T> r110) {
        Intrinsics.checkNotNullParameter(r110, "adapter");
        this.f49434f = r110;
        ((HashSet) this.f49435g).clear();
        ap.a<?> r111 = this.f49434f;
        if (r111 == null) goto L23;
        removeAllViews();
        HashSet<Integer> r100 = r111.f15823b;
        int r101 = r111.f15822a.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L17;
        View r103 = r111.a(CollectionsKt.getOrNull(r111.f15822a, r102));
        e r104 = new e(getContext());
        r103.setDuplicateParentStateEnabled(true);
        if (r103.getLayoutParams() == null) goto L10;
        r104.setLayoutParams(r103.getLayoutParams());
    L11:
        r104.addView(r103);
        addView(r104);
        if (r100.contains(Integer.valueOf(r102)) == false) goto L16;
        r104.setChecked(true);
        if (this.f49434f == null) goto L16;
        r104.getTagView();
    L16:
        CollectionsKt.getOrNull(r111.f15822a, r102);
        r103.setClickable(false);
        r104.setOnClickListener(new ap.b(this, r104, r102));
        r102 = r102 + 1;
        goto L6
    L10:
        r104.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        goto L11
    L17:
        this.f49435g.addAll(r100);
        return;
    }

    public final void setOnTagClickListener(b r100) {
        this.f49436h = r100;
    }

    public final void setTagSpaceHorizontal(int r100) {
        if (this.f49431c == r100) goto L6;
        this.f49431c = r100;
        requestLayout();
        return;
    }

    public ECWindowTagFlowLayout(Context r100, AttributeSet r101) {
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
        e r109 = (e) r108;
        if (r109.getVisibility() == 8) goto L13;
        if (r109.getTagView().getVisibility() != 8) goto L13;
        r109.setVisibility(8);
    L13:
        r106 = r106 + 1;
        goto L3
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.product.widget.WindowTagView");
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
        int r120 = r119 + this.f49431c;
        r112 = r112 + r113;
        r114 = r114 + 1;
        int r121 = this.f49432d;
        if (1 > r121) goto L34;
        if (r114 <= r121) goto L34;
        r113 = r113;
    L43:
        if (r113 <= 0) goto L46;
        r112 = r112 + (((r112 / r113) - 1) * this.f49430b);
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
        r120 = r110 + (r119 + this.f49431c);
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

    public ECWindowTagFlowLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = 1;
        this.f49432d = 1;
        this.f49433e = -1;
        this.f49435g = new HashSet();
        this.f49437i = new ArrayList();
        this.f49438j = new ArrayList();
        this.f49439k = new ArrayList();
        this.f49440l = new ArrayList();
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.auto_select_effect, R.attr.gravity, R.attr.marginOutside, R.attr.maxLines, R.attr.max_select, R.attr.paddingBottom, R.attr.paddingEnd, R.attr.paddingStart, R.attr.paddingTop, R.attr.rowSpacing, R.attr.tag_gravity_ec, R.attr.tag_maxline, R.attr.tag_space_horizontal, R.attr.tag_space_vertical, R.attr.textColor, R.attr.textSize});
        int r105 = r104.getInt(10, -1);
        this.f49429a = r105;
        this.f49431c = r104.getDimensionPixelSize(12, com.bytedance.android.shopping.extensions.b.b(4));
        this.f49430b = r104.getDimensionPixelSize(13, 0);
        this.f49432d = r104.getInteger(11, 1);
        this.f49433e = r104.getInt(4, -1);
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L8;
        if (r105 == (-1)) goto L7;
        r103 = getLeft();
    L7:
        this.f49429a = r103;
    L8:
        r104.recycle();
    }

    @Override // com.google.android.material.internal.FlowLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        ((ArrayList) this.f49437i).clear();
        ((ArrayList) this.f49438j).clear();
        ((ArrayList) this.f49439k).clear();
        this.f49440l.clear();
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
        int r118 = this.f49432d;
        if (1 > r118) goto L17;
        if (r105 > r118) goto L22;
    L17:
        List<Integer> r107 = this.f49438j;
        ArrayList r108 = (ArrayList) r107;
        r108.add(Integer.valueOf(r106));
        List<List<View>> r109 = this.f49437i;
        ArrayList r119 = (ArrayList) r109;
        r119.add(this.f49440l);
        List<Integer> r120 = this.f49439k;
        ArrayList r121 = (ArrayList) r120;
        r121.add(Integer.valueOf(r104));
        this.f49440l = new ArrayList();
        r106 = r117;
        r104 = 0;
    L18:
        r104 = r104 + (r116 + this.f49431c);
        r106 = RangesKt.coerceAtLeast(r106, r117);
        this.f49440l.add(r113);
        goto L19
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        r103 = r103 + 1;
    L22:
        List<Integer> r122 = this.f49438j;
        ArrayList r123 = (ArrayList) r122;
        r123.add(Integer.valueOf(r106));
        List<Integer> r124 = this.f49439k;
        ArrayList r125 = (ArrayList) r124;
        r125.add(Integer.valueOf(r104));
        List<List<View>> r126 = this.f49437i;
        ArrayList r127 = (ArrayList) r126;
        r127.add(this.f49440l);
        int r128 = getPaddingLeft();
        int r129 = getPaddingTop();
        int r130 = ((ArrayList) this.f49437i).size();
        int r131 = 0;
    L23:
        if (r131 >= r130) goto L58;
        List<View> r132 = (List) CollectionsKt.getOrNull(this.f49437i, r131);
        if (r132 == null) goto L27;
        this.f49440l = r132;
    L27:
        int r133 = this.f49440l.size();
        Integer r134 = (Integer) CollectionsKt.getOrNull(this.f49438j, r131);
        if (r134 == null) goto L30;
        int r135 = r134.intValue();
    L31:
        int r136 = r135 + this.f49430b;
        Integer r137 = (Integer) CollectionsKt.getOrNull(this.f49439k, r131);
        if (r137 == null) goto L34;
        int r138 = r137.intValue();
    L35:
        int r139 = this.f49429a;
        if (r139 == (-1)) goto L42;
        if (r139 == 0) goto L41;
        if (r139 != r102) goto L43;
        r128 = (r100 - (r138 + getPaddingLeft())) - getPaddingRight();
        CollectionsKt.reverse(this.f49440l);
    L43:
        int r140 = 0;
    L44:
        if (r140 >= r133) goto L57;
        View r141 = (View) CollectionsKt.getOrNull(this.f49440l, r140);
        if (r141 == null) goto L54;
        if (r141.getVisibility() == r112) goto L54;
        ViewGroup.LayoutParams r142 = r141.getLayoutParams();
        if (r142 == null) goto L56;
        ViewGroup.MarginLayoutParams r143 = (ViewGroup.MarginLayoutParams) r142;
        int r144 = r143.leftMargin + r128;
        int r145 = r143.topMargin + r129;
        r141.layout(r144, r145, r144 + r141.getMeasuredWidth(), r145 + r141.getMeasuredHeight());
        r128 = r128 + (((r141.getMeasuredWidth() + r143.leftMargin) + r143.rightMargin) + this.f49431c);
        goto L54
    L56:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L54:
        r140 = r140 + 1;
        r112 = 8;
        goto L44
    L57:
        r129 = r129 + r136;
        r131 = r131 + 1;
        r102 = 1;
        r112 = 8;
        goto L23
    L41:
        r128 = ((r100 - r138) / 2) + getPaddingLeft();
        goto L43
    L42:
        r128 = getPaddingLeft();
        goto L43
    L34:
        r138 = 0;
        goto L35
    L30:
        r135 = 0;
        goto L31
    }
}
