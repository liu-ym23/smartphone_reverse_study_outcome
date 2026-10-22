package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\u000eB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011J!\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/AutoHideLinearLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "Landroid/view/View;", "viewArray", "", "setHideGroup", "([Landroid/view/View;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AutoHideLinearLayout extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<View>> f153129a;

    public AutoHideLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f153129a = new LinkedHashMap();
    }

    public final List<View> d(View r100) {
        Object r101 = r100.getTag(R.id.ec_auto_hide_linear_layout_tag);
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        String r102 = (String) r101;
        if (r102 != null) goto L8;
        List<View> r103 = CollectionsKt.listOf(r100);
    L12:
        Iterator<T> r104 = r103.iterator();
    L14:
        if (r104.hasNext() == false) goto L16;
        ((View) r104.next()).layout(0, 0, 0, 0);
        goto L14
    L16:
        return r103;
    L8:
        List<View> r105 = (List) ((LinkedHashMap) this.f153129a).get(r102);
        if (r105 != null) goto L11;
        r103 = CollectionsKt.listOf(r100);
        goto L12
    L11:
        r103 = r105;
        goto L12
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getTag(R.id.ec_auto_hide_linear_layout_tag);
    L7:
        if ((r102 instanceof String) == false) goto L10;
        r101 = r102;
    L10:
        String r103 = (String) r101;
        if (r103 != null) goto L13;
        return;
    L13:
        List<View> r104 = this.f153129a.get(r103);
        if (r104 != null) goto L16;
        return;
    L16:
        r104.remove(r100);
        if (r104.isEmpty() == false) goto L20;
        this.f153129a.remove(r103);
        return;
    L20:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void setHideGroup(View... r100) {
        Intrinsics.checkNotNullParameter(r100, "viewArray");
        String r101 = UUID.randomUUID().toString();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100[r103].setTag(R.id.ec_auto_hide_linear_layout_tag, r101);
        r103 = r103 + 1;
        goto L3
    L5:
        this.f153129a.put(r101, ArraysKt.toMutableList(r100));
    }

    public AutoHideLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f153129a = new LinkedHashMap();
    }

    public AutoHideLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f153129a = new LinkedHashMap();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        super.onLayout(r110, r111, r112, r113, r114);
        LinkedHashSet r100 = new LinkedHashSet();
        if (getOrientation() != 0) goto L14;
        int r115 = getChildCount() - 1;
    L5:
        if (r115 < 0) goto L22;
        View r116 = getChildAt(r115);
        if (r116.getVisibility() == 8) goto L13;
        if (r100.contains(r116) == true) goto L13;
        if (e(r116, r110, r111, r112, r113, r114) == false) goto L32;
        r100.addAll(d(r116));
        goto L13
    L32:
        return;
    L13:
        r115 = r115 - 1;
        goto L5
    L22:
        return;
    L14:
        int r117 = getChildCount() - 1;
    L15:
        if (r117 < 0) goto L34;
        View r118 = getChildAt(r117);
        if (r118.getVisibility() == 8) goto L21;
        if (e(r118, r110, r111, r112, r113, r114) == false) goto L33;
        r100.addAll(d(r118));
        goto L21
    L33:
        return;
    L21:
        r117 = r117 - 1;
        goto L15
    }

    public boolean e(View r100, boolean r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (getOrientation() != 0) goto L16;
        int r106 = r100.getMeasuredWidth();
        ViewGroup.LayoutParams r107 = r100.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        int r108 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r107);
    L8:
        int r109 = r106 + r108;
        ViewGroup.LayoutParams r110 = r100.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        int r111 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r110);
    L13:
        if ((r100.getLeft() + (r109 + r111)) <= r104) goto L35;
        return true;
    L35:
        return false;
    L11:
        r111 = 0;
        goto L13
    L7:
        r108 = 0;
        goto L8
    L16:
        int r112 = r100.getMeasuredHeight();
        ViewGroup.LayoutParams r113 = r100.getLayoutParams();
        ViewGroup.LayoutParams r114 = null;
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == true) goto L19;
        r113 = null;
    L19:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r113;
        if (r115 == null) goto L22;
        int r116 = r115.topMargin;
    L23:
        int r117 = r112 + r116;
        ViewGroup.LayoutParams r118 = r100.getLayoutParams();
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        r114 = r118;
    L27:
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r114;
        if (r119 == null) goto L30;
        int r120 = r119.bottomMargin;
    L32:
        if ((r100.getTop() + (r117 + r120)) <= r105) goto L36;
        return true;
    L36:
        return false;
    L30:
        r120 = 0;
        goto L32
    L22:
        r116 = 0;
        goto L23
    }
}
