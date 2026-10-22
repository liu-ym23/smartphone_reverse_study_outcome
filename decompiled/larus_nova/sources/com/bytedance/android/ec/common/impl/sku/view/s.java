package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s extends FrameLayout implements SpecItemOptimizeGroupLayout.e, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f43556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f43557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<c> f43558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f43559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f43560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f43561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f43562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GroupTitleOptimizeLayout f43563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f43564j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SparseArray<List<View>> f43565k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<Integer> f43566l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f43567m;

    public interface a {
        void a();

        void b(int r100);

        void c();

        void d(int r100, c r101, boolean r102);
    }

    public interface b {
        void a(boolean r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f43568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SkuStatusDetail f43569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f43570c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f43571d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f43572e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f43573f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ECUrlModel f43574g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, String> f43575h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<String, String> f43576i;

        public final c a() {
            c r100 = new c(this.f43570c, this.f43571d, this.f43572e, this.f43573f, this.f43574g, this.f43575h, this.f43576i);
            r100.f43568a = this.f43568a;
            r100.f43569b = this.f43569b;
            return r100;
        }

        public final int hashCode() {
            int r100 = ((this.f43570c.hashCode() * 31) + this.f43571d.hashCode()) * 31;
            String r101 = this.f43572e;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            int r105 = 1231;
            if (this.f43573f == false) goto L9;
            int r106 = 1231;
        L10:
            int r107 = (r104 + r106) * 31;
            ECUrlModel r108 = this.f43574g;
            if (r108 == null) goto L13;
            int r109 = r108.hashCode();
        L14:
            int r110 = (r107 + r109) * 31;
            if (this.f43568a == true) goto L18;
            r105 = 1237;
        L18:
            int r111 = (r110 + r105) * 31;
            Map<String, String> r112 = this.f43575h;
            if (r112 == null) goto L21;
            int r113 = r112.hashCode();
        L22:
            int r114 = (r111 + r113) * 31;
            Map<String, String> r115 = this.f43576i;
            if (r115 == null) goto L25;
            int r116 = r115.hashCode();
        L26:
            int r117 = (r114 + r116) * 31;
            SkuStatusDetail r118 = this.f43569b;
            if (r118 == null) goto L30;
            r102 = r118.hashCode();
        L30:
            return r117 + r102;
        L25:
            r116 = 0;
            goto L26
        L21:
            r113 = 0;
            goto L22
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 1237;
            goto L10
        L5:
            r103 = 0;
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
            if (r100 == null) goto L42;
            c r102 = (c) r100;
            if ((!Intrinsics.areEqual(this.f43570c, r102.f43570c)) == false) goto L17;
            return false;
        L17:
            if (this.f43568a == r102.f43568a) goto L20;
            return false;
        L20:
            if ((!Intrinsics.areEqual(this.f43571d, r102.f43571d)) == false) goto L23;
            return false;
        L23:
            if ((!Intrinsics.areEqual(this.f43572e, r102.f43572e)) == false) goto L26;
            return false;
        L26:
            if (this.f43573f == r102.f43573f) goto L29;
            return false;
        L29:
            if ((!Intrinsics.areEqual(this.f43574g, r102.f43574g)) == false) goto L32;
            return false;
        L32:
            if ((!Intrinsics.areEqual(this.f43575h, r102.f43575h)) == false) goto L35;
            return false;
        L35:
            if ((!Intrinsics.areEqual(this.f43576i, r102.f43576i)) == false) goto L38;
            return false;
        L38:
            if ((!Intrinsics.areEqual(this.f43569b, r102.f43569b)) == false) goto L40;
            return false;
        L40:
            return true;
        L42:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeLayout.ItemViewInfoOptimize");
        L8:
            r101 = null;
            goto L10
        }

        public c(String r100, String r101, String r102, boolean r103, ECUrlModel r104, Map<String, String> r105, Map<String, String> r106) {
            Intrinsics.checkNotNullParameter(r100, "itemId");
            Intrinsics.checkNotNullParameter(r101, "text");
            this.f43570c = r100;
            this.f43571d = r101;
            this.f43572e = r102;
            this.f43573f = r103;
            this.f43574g = r104;
            this.f43575h = r105;
            this.f43576i = r106;
            this.f43568a = true;
        }
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout.e
    public c getCheckedItemViewInfo() {
        return this.f43559e;
    }

    public s(Context r100) {
        this(r100, true);
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.r
    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "itemViewInfo");
        if (this.f43567m == true) goto L5;
        return;
    L5:
        if (r100.f43568a == false) goto L35;
        c r101 = this.f43559e;
        if (r101 == null) goto L13;
        Intrinsics.checkNotNull(r101);
        if (TextUtils.equals(r101.f43570c, r100.f43570c) == false) goto L13;
        this.f43559e = null;
        this.f43560f = false;
        c(null);
    L17:
        GroupTitleOptimizeLayout r102 = this.f43563i;
        if (r102 == null) goto L20;
        r102.f43396f.setVisibility(8);
    L20:
        a r103 = this.f43564j;
        if (r103 == null) goto L23;
        r103.c();
    L23:
        a r104 = this.f43564j;
        if (r104 == null) goto L27;
        r104.d(this.f43562h, this.f43559e, false);
    L27:
        if (this.f43559e == null) goto L33;
        a r105 = this.f43564j;
        if (r105 == null) goto L34;
        r105.a();
        return;
    L34:
        return;
    L33:
        return;
    L13:
        if (r100.f43568a == false) goto L17;
        this.f43559e = r100;
        this.f43560f = true;
        Intrinsics.checkNotNull(r100);
        c(r100.f43570c);
        a r106 = this.f43564j;
        if (r106 == null) goto L17;
        r106.b(this.f43562h);
        goto L17
    }

    public final void b(int r100) {
        if (r100 != 0) goto L7;
        c r101 = this.f43559e;
        if (r101 == null) goto L17;
        a(r101);
        return;
    L17:
        return;
    L7:
        int r102 = r100 - 1;
        if (r102 < this.f43558d.size()) goto L11;
        return;
    L11:
        if (this.f43559e != null) goto L13;
    L15:
        a((c) ListProtector.get(this.f43558d, r102));
        return;
    L13:
        if (Intrinsics.areEqual((c) ListProtector.get(this.f43558d, r102), this.f43559e) == false) goto L15;
    }

    public final void c(String r100) {
        int r101 = getChildCount();
        int r102 = this.f43561g;
    L3:
        if (r102 >= r101) goto L12;
        View r103 = getChildAt(r102);
        if (r103 == null) goto L11;
        SpecItemOptimizeView r104 = (SpecItemOptimizeView) r103;
        int r105 = r102 - this.f43561g;
        if (r105 >= this.f43558d.size()) goto L9;
        r104.S5((c) ListProtector.get(this.f43558d, r105), r100);
    L9:
        r102 = r102 + 1;
        goto L3
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeView");
    }

    public void setCheckedId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Iterator<c> r101 = this.f43558d.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        c r102 = r101.next();
        if (TextUtils.equals(r102.f43570c, r100) == false) goto L4;
        this.f43559e = r102;
        this.f43560f = false;
        c(r100);
        return;
    }

    public final void setOnItemCheckedListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "onItemCheckedListener");
        this.f43564j = r100;
    }

    public s(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f43567m = r101;
        this.f43558d = CollectionsKt.emptyList();
        this.f43562h = -1;
        this.f43565k = new SparseArray();
        this.f43566l = new ArrayList();
        this.f43557c = (int) UIUtils.dip2Px(getContext().getApplicationContext(), 0.0f);
        this.f43556b = (int) UIUtils.dip2Px(getContext().getApplicationContext(), 4.0f);
        this.f43555a = (int) UIUtils.dip2Px(getContext().getApplicationContext(), 4.0f);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r112 = getChildCount();
        if (r112 != 0) goto L5;
        return;
    L5:
        this.f43565k.clear();
        this.f43566l.clear();
        int r113 = 0;
        int r100 = getChildAt(0).getMeasuredHeight();
        int r101 = getMeasuredWidth();
        int r102 = this.f43561g;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r102 >= r112) goto L20;
        View r106 = getChildAt(r102);
        int r107 = r106.getMeasuredWidth();
        r103 = r103 + r107;
        if (r104 <= 0) goto L11;
        r103 = r103 + this.f43556b;
    L11:
        if (r103 <= r101) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L16;
        r105 = r105 + 1;
        r103 = r107;
        r104 = 0;
    L16:
        List<View> r109 = this.f43565k.get(r105);
        if (r109 != null) goto L19;
        r109 = new ArrayList();
        this.f43565k.put(r105, r109);
    L19:
        r109.add(r106);
        r104 = r104 + 1;
        r102 = r102 + 1;
        goto L7
    L13:
        r108 = false;
        goto L14
    L20:
        int r114 = this.f43565k.size();
        int r115 = 0;
    L21:
        if (r115 >= r114) goto L27;
        Iterator<View> r116 = this.f43565k.get(r115).iterator();
        int r117 = 0;
    L24:
        if (r116.hasNext() == false) goto L26;
        r117 = Math.max(r117, r116.next().getMeasuredHeight());
        goto L24
    L26:
        this.f43566l.add(Integer.valueOf(r117));
        r115 = r115 + 1;
        goto L21
    L27:
        Iterator<Integer> r118 = this.f43566l.iterator();
    L29:
        if (r118.hasNext() == false) goto L31;
        r113 = r113 + r118.next().intValue();
        goto L29
    L31:
        int r119 = this.f43565k.size();
        setMeasuredDimension(r101, ((r100 + this.f43557c) + r113) + ((r119 - 1) * this.f43555a));
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
        int r118 = this.f43565k.size();
        int r119 = 0;
        int r120 = 0;
    L6:
        if (r119 >= r118) goto L19;
        List<View> r100 = this.f43565k.get(r119);
        int r101 = r100.size();
        if (r119 != 0) goto L10;
        int r102 = this.f43557c + r117;
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
        int r108 = (this.f43556b * r103) + r104;
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
        r102 = ((Number) ListProtector.get(this.f43566l, r119 - 1)).intValue() + this.f43555a;
        goto L11
    }
}
