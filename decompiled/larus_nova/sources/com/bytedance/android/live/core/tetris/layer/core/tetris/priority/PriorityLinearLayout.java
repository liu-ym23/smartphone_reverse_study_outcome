package com.bytedance.android.live.core.tetris.layer.core.tetris.priority;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002CDB'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\u0007¢\u0006\u0004\bA\u0010BJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR.\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R.\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020+0\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R.\u00103\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006E"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityLinearLayout;", "Landroid/widget/LinearLayout;", "", "Lu70/a;", "mutexSet", "", "setMutexList", "", "c", "I", "getMaxVisibleCount", "()I", "setMaxVisibleCount", "(I)V", "maxVisibleCount", "", "d", "Z", "getAutoDismissChildViewWhenWidthLimit", "()Z", "setAutoDismissChildViewWhenWidthLimit", "(Z)V", "autoDismissChildViewWhenWidthLimit", "e", "getSpaceMargin", "setSpaceMargin", "spaceMargin", "", "Landroid/view/View;", "f", "Ljava/util/Map;", "getPriorityMap", "()Ljava/util/Map;", "setPriorityMap", "(Ljava/util/Map;)V", "priorityMap", ce.f26391f, "Ljava/util/Set;", "getMutexPairSet", "()Ljava/util/Set;", "setMutexPairSet", "(Ljava/util/Set;)V", "mutexPairSet", "", "h", "getViewToIdentifyMap", "setViewToIdentifyMap", "viewToIdentifyMap", RXScreenCaptureService.KEY_INDEX, "getIdentifyToViewMap", "setIdentifyToViewMap", "identifyToViewMap", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityLinearLayout$b;", ce.f26395j, "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityLinearLayout$b;", "getChangeListener", "()Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityLinearLayout$b;", "setChangeListener", "(Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityLinearLayout$b;)V", "changeListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriorityLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View> f65803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<View> f65804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f65805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f65806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f65807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<View, Integer> f65808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set<u70.a> f65809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<View, String> f65810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, View> f65811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f65812j;

    public static final class a {
    }

    public interface b {
        void a(List<? extends View> r100, List<? extends View> r101, List<? extends View> r102);
    }

    public static final class c<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PriorityLinearLayout f65813a;

        public c(PriorityLinearLayout r100) {
            this.f65813a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Map<View, Integer> r102 = this.f65813a.getPriorityMap();
            Integer r103 = r102.get((View) r101);
            Map<View, Integer> r104 = this.f65813a.getPriorityMap();
            return ComparisonsKt.compareValues(r103, r104.get((View) r100));
        }
    }

    static {
    }

    public PriorityLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PriorityLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        if (this.f65805c != (-1)) goto L5;
        return;
    L5:
        ArrayList r100 = new ArrayList();
        r100.addAll(this.f65803a);
        ((ArrayList) this.f65804b).clear();
        ((ArrayList) this.f65803a).clear();
        int r101 = getChildCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L15;
        View r103 = super.getChildAt(r102);
        if (r103.getMeasuredWidth() <= 0) goto L14;
        if (r103.getMeasuredHeight() <= 0) goto L14;
        if (a(r103) == false) goto L14;
        ((ArrayList) this.f65803a).add(r103);
    L14:
        r102 = r102 + 1;
        goto L6
    L15:
        ArrayList r104 = (ArrayList) this.f65803a;
        if (r104.size() <= 1) goto L18;
        CollectionsKt.sortWith(r104, new c(this));
    L18:
        Iterator r105 = ((ArrayList) this.f65803a).iterator();
    L20:
        if (r105.hasNext() == false) goto L32;
        View r106 = (View) r105.next();
        String r107 = this.f65810h.get(r106);
        Intrinsics.checkNotNull(r107);
        String r108 = r107;
        Iterator<T> r109 = this.f65809g.iterator();
    L23:
        if (r109.hasNext() == false) goto L20;
        u70.a r110 = (u70.a) r109.next();
        if (Intrinsics.areEqual(r110.f549030b, r108) == false) goto L23;
        View r111 = this.f65811i.get(r110.f549029a);
        if (CollectionsKt.contains(this.f65803a, r111) == false) goto L23;
        Integer r112 = this.f65808f.get(r111);
        Intrinsics.checkNotNull(r112);
        int r113 = r112.intValue();
        Integer r114 = this.f65808f.get(r106);
        Intrinsics.checkNotNull(r114);
        if (r113 <= r114.intValue()) goto L23;
        r105.remove();
    L32:
        if (((ArrayList) this.f65803a).size() <= this.f65805c) goto L35;
        List<View> r115 = this.f65803a;
        ListProtector.remove(r115, ((ArrayList) r115).size() - 1);
        goto L32
    L35:
        if (this.f65806d == false) goto L47;
        Iterator r116 = ((ArrayList) this.f65803a).iterator();
        int r117 = 0;
    L38:
        if (r116.hasNext() == false) goto L47;
        View r118 = (View) r116.next();
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if ((r119 instanceof ViewGroup.MarginLayoutParams) == true) goto L42;
        r119 = null;
    L42:
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;
        if (r120 == null) goto L38;
        r117 = r117 + ((r118.getMeasuredWidth() + r120.leftMargin) + r120.rightMargin);
        if (r117 <= getWidth()) goto L38;
        r116.remove();
    L47:
        List<View> r121 = this.f65804b;
        ArrayList r122 = (ArrayList) r121;
        r122.addAll(this.f65803a);
        int r123 = getChildCount();
        int r124 = 0;
    L48:
        if (r124 >= r123) goto L53;
        View r125 = super.getChildAt(r124);
        if (((ArrayList) this.f65804b).contains(r125) == true) goto L52;
        ((ArrayList) this.f65804b).add(r125);
    L52:
        r124 = r124 + 1;
        goto L48
    L53:
        ArrayList r126 = new ArrayList();
        Iterator r127 = r100.iterator();
    L55:
        if (r127.hasNext() == false) goto L59;
        View r128 = (View) r127.next();
        if (((ArrayList) this.f65803a).contains(r128) == true) goto L55;
        r126.add(r128);
        goto L55
    L59:
        ArrayList r129 = new ArrayList();
        Iterator r130 = ((ArrayList) this.f65803a).iterator();
    L61:
        if (r130.hasNext() == false) goto L65;
        View r131 = (View) r130.next();
        if (r100.contains(r131) == true) goto L61;
        r129.add(r131);
        goto L61
    L65:
        b r132 = this.f65812j;
        if (r132 == null) goto L68;
        r132.a(this.f65803a, r126, r129);
    L68:
        int r133 = ((ArrayList) this.f65803a).size();
        int r134 = 0;
    L69:
        if (r134 >= r133) goto L95;
        View r135 = getChildAt(r134);
        if (r135 == null) goto L94;
        ViewGroup.LayoutParams r136 = r135.getLayoutParams();
        if (r136 == null) goto L93;
        LinearLayout.LayoutParams r137 = (LinearLayout.LayoutParams) r136;
        if (getOrientation() != 1) goto L84;
        if (r134 == 0) goto L78;
    L80:
        if (r134 == 0) goto L94;
        if (r137.topMargin != 0) goto L94;
        r137.topMargin = this.f65807e;
        r135.setLayoutParams(r137);
        goto L94
    L78:
        if (r137.topMargin == 0) goto L80;
        r137.topMargin = 0;
        r135.setLayoutParams(r137);
        goto L80
    L84:
        if (r134 == 0) goto L86;
    L88:
        if (r134 == 0) goto L94;
        if (r137.leftMargin != 0) goto L94;
        r137.leftMargin = this.f65807e;
        r135.setLayoutParams(r137);
        goto L94
    L86:
        if (r137.leftMargin == 0) goto L88;
        r137.leftMargin = 0;
        r135.setLayoutParams(r137);
        goto L88
    L93:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L94:
        r134 = r134 + 1;
        goto L69
    }

    public final boolean getAutoDismissChildViewWhenWidthLimit() {
        return this.f65806d;
    }

    public final b getChangeListener() {
        return this.f65812j;
    }

    public final Map<String, View> getIdentifyToViewMap() {
        return this.f65811i;
    }

    public final int getMaxVisibleCount() {
        return this.f65805c;
    }

    public final Set<u70.a> getMutexPairSet() {
        return this.f65809g;
    }

    public final Map<View, Integer> getPriorityMap() {
        return this.f65808f;
    }

    public final int getSpaceMargin() {
        return this.f65807e;
    }

    public final Map<View, String> getViewToIdentifyMap() {
        return this.f65810h;
    }

    public static boolean a(View r100) {
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
        if (r101.getVisibility() == 0) goto L13;
        return false;
    L13:
        if (r101.getChildCount() != 0) goto L15;
        return true;
    L15:
        int r102 = r101.getChildCount();
        int r103 = 0;
    L16:
        if (r103 >= r102) goto L23;
        View r104 = r101.getChildAt(r103);
        if (r104.getVisibility() != 0) goto L22;
        if (a(r104) == false) goto L22;
        return true;
    L22:
        r103 = r103 + 1;
        goto L16
    L23:
        return false;
    L5:
        if (r100.getVisibility() == 0) goto L28;
        return false;
    L28:
        return true;
    }

    @Override // android.view.ViewGroup
    public final View getChildAt(int r100) {
        if (this.f65805c == (-1)) goto L10;
        if (r100 >= ((ArrayList) this.f65804b).size()) goto L10;
        return (View) ListProtector.get(this.f65804b, r100);
    L10:
        return super.getChildAt(r100);
    }

    public final void setAutoDismissChildViewWhenWidthLimit(boolean r100) {
        this.f65806d = r100;
    }

    public final void setChangeListener(b r100) {
        this.f65812j = r100;
    }

    public final void setIdentifyToViewMap(Map<String, View> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f65811i = r100;
    }

    public final void setMaxVisibleCount(int r100) {
        this.f65805c = r100;
    }

    public final void setMutexList(Set<u70.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "mutexSet");
        this.f65809g = r100;
        invalidate();
    }

    public final void setMutexPairSet(Set<u70.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f65809g = r100;
    }

    public final void setPriorityMap(Map<View, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f65808f = r100;
    }

    public final void setSpaceMargin(int r100) {
        this.f65807e = r100;
    }

    public final void setViewToIdentifyMap(Map<View, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f65810h = r100;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = 0;
        if (getOrientation() != 1) goto L25;
        int r112 = View.MeasureSpec.getMode(r110);
        int r113 = View.MeasureSpec.getMode(r111);
        int r114 = View.MeasureSpec.getSize(r110);
        int r115 = View.MeasureSpec.getSize(r111);
        int r116 = ((ArrayList) this.f65804b).size();
        int r117 = 0;
    L5:
        if (r117 >= r116) goto L7;
        measureChildWithMargins((View) ListProtector.get(this.f65804b, r117), r110, 0, r111, 0);
        r117 = r117 + 1;
        goto L5
    L7:
        b();
        int r101 = ((ArrayList) this.f65803a).size();
        int r102 = 0;
        int r103 = 0;
    L8:
        if (r100 >= r101) goto L17;
        View r104 = (View) ListProtector.get(this.f65803a, r100);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L16;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        r102 = r102 + ((r104.getMeasuredHeight() + r106.topMargin) + r106.bottomMargin);
        if (r103 >= r104.getMeasuredWidth()) goto L14;
        r103 = r104.getMeasuredWidth();
    L14:
        r100 = r100 + 1;
        goto L8
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L17:
        int r107 = r102 + (getPaddingTop() + getPaddingBottom());
        int r108 = r103 + (getPaddingRight() + getPaddingLeft());
        if (r113 == 1073741824) goto L21;
        r115 = r107;
    L21:
        if (r112 == 1073741824) goto L24;
        r114 = r108;
    L24:
        setMeasuredDimension(r114, r115);
        return;
    L25:
        int r118 = View.MeasureSpec.getMode(r110);
        int r119 = View.MeasureSpec.getMode(r111);
        int r120 = View.MeasureSpec.getSize(r110);
        int r121 = View.MeasureSpec.getSize(r111);
        int r122 = getChildCount();
        int r123 = 0;
    L26:
        if (r123 >= r122) goto L28;
        measureChildWithMargins(super.getChildAt(r123), r110, 0, r111, 0);
        r123 = r123 + 1;
        goto L26
    L28:
        b();
        int r109 = ((ArrayList) this.f65803a).size();
        int r124 = 0;
        int r125 = 0;
    L29:
        if (r100 >= r109) goto L38;
        View r126 = (View) ListProtector.get(this.f65803a, r100);
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
        if (r127 == null) goto L37;
        ViewGroup.MarginLayoutParams r128 = (ViewGroup.MarginLayoutParams) r127;
        r124 = r124 + ((r126.getMeasuredWidth() + r128.leftMargin) + r128.rightMargin);
        if (r125 >= r126.getMeasuredHeight()) goto L35;
        r125 = r126.getMeasuredHeight();
    L35:
        r100 = r100 + 1;
        goto L29
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L38:
        int r129 = r124 + (getPaddingLeft() + getPaddingRight());
        int r130 = r125 + (getPaddingTop() + getPaddingBottom());
        if (r119 == 1073741824) goto L42;
        r121 = r130;
    L42:
        if (r118 == 1073741824) goto L45;
        r120 = r129;
    L45:
        setMeasuredDimension(r120, r121);
    }

    public PriorityLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f65803a = new ArrayList();
        this.f65804b = new ArrayList();
        this.f65805c = -1;
        this.f65808f = new LinkedHashMap();
        this.f65809g = SetsKt.emptySet();
        this.f65810h = new LinkedHashMap();
        this.f65811i = new LinkedHashMap();
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (CollectionsKt.contains(this.f65803a, r101) == true) goto L7;
        return false;
    L7:
        return super.drawChild(r100, r101, r102);
    }

    public /* synthetic */ PriorityLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
