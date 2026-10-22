package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class n extends FrameLayout implements SpecItemGroupLayout.e, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f43529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f43530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f43531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f43532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<c> f43533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f43534g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f43535h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f43536i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f43537j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f43538k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SparseArray<List<View>> f43539l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<Integer> f43540m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public GroupTitleLayout f43541n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f43542o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f43543p;

    public static final class a {
    }

    public interface b {
        void a();

        void b(int r100);

        void c();

        void d(int r100, c r101, boolean r102);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f43544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f43545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f43546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f43547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ECUrlModel f43548e;

        public final int hashCode() {
            int r100 = ((this.f43545b.hashCode() * 31) + this.f43546c.hashCode()) * 31;
            int r101 = 1231;
            if (this.f43547d == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            ECUrlModel r104 = this.f43548e;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            if (this.f43544a == true) goto L15;
            r101 = 1237;
        L15:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if ((!Intrinsics.areEqual(c.class, r101)) == false) goto L12;
            return false;
        L12:
            if (r100 == null) goto L30;
            c r102 = (c) r100;
            if ((!Intrinsics.areEqual(this.f43545b, r102.f43545b)) == false) goto L17;
            return false;
        L17:
            if (this.f43544a == r102.f43544a) goto L20;
            return false;
        L20:
            if ((!Intrinsics.areEqual(this.f43546c, r102.f43546c)) == false) goto L23;
            return false;
        L23:
            if (this.f43547d == r102.f43547d) goto L26;
            return false;
        L26:
            if ((!Intrinsics.areEqual(this.f43548e, r102.f43548e)) == false) goto L28;
            return false;
        L28:
            return true;
        L30:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.impl.sku.view.SpecItemLayout.ItemViewInfo");
        L8:
            r101 = null;
            goto L10
        }

        public c(String r100, String r101, boolean r102, ECUrlModel r103) {
            Intrinsics.checkNotNullParameter(r100, "itemId");
            Intrinsics.checkNotNullParameter(r101, "text");
            this.f43545b = r100;
            this.f43546c = r101;
            this.f43547d = r102;
            this.f43548e = r103;
            this.f43544a = true;
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout.e
    public c getCheckedItemViewInfo() {
        return this.f43534g;
    }

    public final GroupTitleLayout getMGroupTitleLayout() {
        return this.f43541n;
    }

    public n(Context r100) {
        this(r100, 4, true);
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.k
    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "itemViewInfo");
        if (this.f43543p == true) goto L5;
        return;
    L5:
        if (r100.f43544a == false) goto L23;
        c r101 = this.f43534g;
        if (r101 == null) goto L13;
        Intrinsics.checkNotNull(r101);
        if (TextUtils.equals(r101.f43545b, r100.f43545b) == false) goto L13;
        f(null);
        this.f43534g = null;
    L17:
        b r102 = this.f43538k;
        if (r102 == null) goto L22;
        r102.d(this.f43537j, this.f43534g, false);
        return;
    L22:
        return;
    L13:
        if (r100.f43544a == false) goto L17;
        f(r100.f43545b);
        this.f43534g = r100;
        b r103 = this.f43538k;
        if (r103 == null) goto L17;
        r103.b(this.f43537j);
        goto L17
    }

    public final int c(float r100) {
        return (int) UIUtils.dip2Px(getContext().getApplicationContext(), r100);
    }

    public final void e(String r100) {
        int r101 = getChildCount();
        int r102 = this.f43536i;
    L3:
        if (r102 >= r101) goto L12;
        View r103 = getChildAt(r102);
        if (r103 == null) goto L11;
        TextView r104 = (TextView) r103;
        int r105 = r102 - this.f43536i;
        if (r105 >= this.f43533f.size()) goto L9;
        b(r104, (c) ListProtector.get(this.f43533f, r105), r100);
    L9:
        r102 = r102 + 1;
        goto L3
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void f(String r100) {
        int r101 = getChildCount();
        int r102 = this.f43536i;
    L3:
        if (r102 >= r101) goto L12;
        View r103 = getChildAt(r102);
        if (r103 == null) goto L11;
        SpecItemView r104 = (SpecItemView) r103;
        int r105 = r102 - this.f43536i;
        if (r105 >= this.f43533f.size()) goto L9;
        r104.y((c) ListProtector.get(this.f43533f, r105), r100);
    L9:
        r102 = r102 + 1;
        goto L3
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.impl.sku.view.SpecItemView");
    }

    public void setCheckedId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Iterator<c> r101 = this.f43533f.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        c r102 = r101.next();
        if (TextUtils.equals(r102.f43545b, r100) == false) goto L4;
        this.f43534g = r102;
        this.f43535h = false;
        e(r100);
        return;
    }

    public final void setCheckedItemViewInfo(c r100) {
        this.f43534g = r100;
    }

    public final void setMGroupTitleLayout(GroupTitleLayout r100) {
        this.f43541n = r100;
    }

    public final void setOnItemCheckedListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "onItemCheckedListener");
        this.f43538k = r100;
    }

    public final c d(String[] r100, cg.g r101) {
        Intrinsics.checkNotNullParameter(r100, "arrayOfStrings");
        View r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        String[] r103 = (String[]) Arrays.copyOf(r100, r100.length);
        int r104 = this.f43533f.size();
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L22;
        c r106 = (c) ListProtector.get(this.f43533f, r105);
        r103[this.f43537j] = r106.f43545b;
        if (r101.a(r103) != true) goto L10;
        boolean r107 = true;
    L11:
        r106.f43544a = r107;
        if (r107 == true) goto L13;
        r105 = r105 + 1;
        goto L6
    L13:
        View r108 = getChildAt(r105 + 1);
        if ((r108 instanceof SpecItemView) == false) goto L17;
        r102 = r108;
    L17:
        SpecItemView r109 = (SpecItemView) r102;
        if (r109 == null) goto L20;
        r109.y(r106, r106.f43545b);
        this.f43534g = r106;
    L20:
        return r106;
    L10:
        r107 = false;
        goto L11
    L22:
        return null;
    }

    public final void g(String[] r100, cg.g r110) {
        Intrinsics.checkNotNullParameter(r100, "checkIdArray");
        String[] r101 = (String[]) Arrays.copyOf(r100, r100.length);
        int r102 = getChildCount();
        int r103 = this.f43536i;
    L3:
        if (r103 >= r102) goto L24;
        int r104 = r103 - this.f43536i;
        if (r110 == null) goto L23;
        if (r104 >= this.f43533f.size()) goto L23;
        c r105 = (c) ListProtector.get(this.f43533f, r104);
        r101[this.f43537j] = r105.f43545b;
        r105.f43544a = r110.a(r101);
        View r106 = getChildAt(r103);
        String r107 = null;
        if ((r106 instanceof SpecItemView) == true) goto L11;
        r106 = null;
    L11:
        SpecItemView r108 = (SpecItemView) r106;
        if (TextUtils.equals(r100[this.f43537j], r105.f43545b) == true) goto L14;
    L18:
        if (r108 == null) goto L23;
        c r109 = this.f43534g;
        if (r109 == null) goto L22;
        r107 = r109.f43545b;
    L22:
        r108.y(r105, r107);
        goto L23
    L14:
        if (r105.f43544a == true) goto L18;
        if (r108 == null) goto L17;
        r108.y(r105, null);
    L17:
        this.f43534g = null;
    L23:
        r103 = r103 + 1;
        goto L3
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r112 = getChildCount();
        if (r112 != 0) goto L5;
        return;
    L5:
        this.f43539l.clear();
        this.f43540m.clear();
        int r113 = 0;
        int r100 = getChildAt(0).getMeasuredHeight();
        int r101 = getMeasuredWidth();
        int r102 = this.f43536i;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r102 >= r112) goto L20;
        View r106 = getChildAt(r102);
        int r107 = r106.getMeasuredWidth();
        r103 = r103 + r107;
        if (r104 <= 0) goto L11;
        r103 = r103 + this.f43529b;
    L11:
        if (r103 <= r101) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L16;
        r105 = r105 + 1;
        r103 = r107;
        r104 = 0;
    L16:
        List<View> r109 = this.f43539l.get(r105);
        if (r109 != null) goto L19;
        r109 = new ArrayList();
        this.f43539l.put(r105, r109);
    L19:
        r109.add(r106);
        r104 = r104 + 1;
        r102 = r102 + 1;
        goto L7
    L13:
        r108 = false;
        goto L14
    L20:
        int r114 = this.f43539l.size();
        int r115 = 0;
    L21:
        if (r115 >= r114) goto L27;
        Iterator<View> r116 = this.f43539l.get(r115).iterator();
        int r117 = 0;
    L24:
        if (r116.hasNext() == false) goto L26;
        r117 = Math.max(r117, r116.next().getMeasuredHeight());
        goto L24
    L26:
        this.f43540m.add(Integer.valueOf(r117));
        r115 = r115 + 1;
        goto L21
    L27:
        Iterator<Integer> r118 = this.f43540m.iterator();
    L29:
        if (r118.hasNext() == false) goto L31;
        r113 = r113 + r118.next().intValue();
        goto L29
    L31:
        int r119 = this.f43539l.size();
        setMeasuredDimension(r101, ((r100 + this.f43532e) + r113) + ((r119 - 1) * this.f43528a));
    }

    public n(Context r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f43542o = r101;
        this.f43543p = r102;
        this.f43533f = CollectionsKt.emptyList();
        this.f43537j = -1;
        this.f43539l = new SparseArray();
        this.f43540m = new ArrayList();
        this.f43532e = c(12.0f);
        if (r101 != 2) goto L5;
        this.f43531d = (int) UIUtils.dip2Px(r100, 5.0f);
        th.a.a(r100, R.color.shopping_std_text_black_3);
        this.f43529b = c(10.0f);
        this.f43530c = c(10.0f);
        this.f43528a = c(10.0f);
        return;
    L5:
        if (r101 != 3) goto L7;
        this.f43531d = (int) UIUtils.dip2Px(r100, 7.0f);
        th.a.a(r100, R.color.commerce_text_reverse_3);
        this.f43529b = c(10.0f);
        this.f43530c = c(10.0f);
        this.f43528a = c(10.0f);
        return;
    L7:
        if (r101 == 4) goto L9;
        this.f43531d = (int) UIUtils.dip2Px(r100, 7.0f);
        th.a.a(r100, R.color.shopping_std_text_black_3);
        this.f43529b = c(10.0f);
        this.f43530c = c(10.0f);
        this.f43528a = c(10.0f);
        return;
    L9:
        this.f43531d = (int) UIUtils.dip2Px(r100, 6.0f);
        th.a.a(r100, R.color.commerce_text_reverse);
        this.f43529b = c(8.0f);
        this.f43530c = c(16.0f);
        this.f43528a = c(8.0f);
    }

    public final void b(TextView r100, c r101, String r102) {
        if (this.f43543p == false) goto L20;
        if (r101.f43544a == false) goto L20;
        if (this.f43534g == null) goto L16;
        if (TextUtils.equals(r102, r101.f43545b) == false) goto L16;
        if (this.f43542o != 4) goto L14;
        r100.setBackgroundResource(R.drawable.shopping_bg_sku_panel_check);
        r100.setTextColor(th.a.a(getContext(), R.color.shopping_std_brand));
        return;
    L14:
        r100.setBackgroundResource(R.drawable.shopping_bg_red_round);
        r100.setTextColor(th.a.a(getContext(), R.color.commerce_bg_primary));
        return;
    L16:
        if (this.f43542o != 4) goto L18;
        r100.setBackgroundResource(R.drawable.shopping_bg_sku_panel_item_un_check);
        r100.setTextColor(th.a.a(getContext(), R.color.shopping_std_text_black_2));
        return;
    L18:
        r100.setBackgroundResource(R.drawable.shopping_bg_sku_tag_border);
        r100.setTextColor(th.a.a(getContext(), R.color.commerce_text_reverse_3));
        return;
    L20:
        if (this.f43542o != 4) goto L22;
        r100.setBackgroundResource(R.drawable.shopping_bg_sku_panel_item_un_check);
    L23:
        r100.setTextColor(th.a.a(getContext(), R.color.shopping_std_text_black_4));
        return;
    L22:
        r100.setBackgroundResource(R.drawable.shopping_bg_sku_tag_border);
        goto L23
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        View r115 = getChildAt(0);
        int r116 = r115.getMeasuredWidth();
        int r117 = r115.getMeasuredHeight();
        r115.layout(0, 0, r116, r117);
        int r118 = this.f43539l.size();
        int r119 = 0;
        int r120 = 0;
    L6:
        if (r119 >= r118) goto L19;
        List<View> r100 = this.f43539l.get(r119);
        int r101 = r100.size();
        if (r119 != 0) goto L10;
        int r102 = this.f43532e + r117;
    L11:
        r120 = r120 + r102;
        int r103 = 0;
        int r104 = 0;
    L12:
        if (r103 >= r101) goto L18;
        View r105 = (View) ListProtector.get(r100, r103);
        int r106 = r105.getMeasuredWidth();
        int r107 = r105.getMeasuredHeight();
        if (r103 <= 0) goto L16;
        int r108 = (this.f43529b * r103) + r104;
    L17:
        r105.layout(r108, r120, r106 + r108, r107 + r120);
        r104 = r104 + r106;
        r103 = r103 + 1;
        goto L12
    L16:
        r108 = 0;
        goto L17
    L18:
        r119 = r119 + 1;
        goto L6
    L10:
        r102 = ((Number) ListProtector.get(this.f43540m, r119 - 1)).intValue() + this.f43528a;
        goto L11
    }
}
