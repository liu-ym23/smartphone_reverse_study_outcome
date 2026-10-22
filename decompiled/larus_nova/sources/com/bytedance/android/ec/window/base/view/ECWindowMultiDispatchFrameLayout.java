package com.bytedance.android.ec.window.base.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/window/base/view/ECWindowMultiDispatchFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/window/base/view/j;", "Landroid/graphics/Rect;", FilterData.FilterOptionItem.Type.RANGE, "", "setupActiveRange", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowMultiDispatchFrameLayout extends FrameLayout implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f49818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f49819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f49820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<i> f49821d;

    public ECWindowMultiDispatchFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECWindowMultiDispatchFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        if (this.f49821d.isEmpty() == false) goto L5;
        boolean r100 = false;
    L12:
        if (r100 == false) goto L14;
        return true;
    L14:
        if (r110 != null) goto L16;
    L27:
        boolean r101 = false;
    L28:
        if (r101 == false) goto L30;
    L33:
        int r102 = r110.getAction();
        if (r102 == 0) goto L40;
        if (r102 != 1) goto L37;
    L39:
        this.f49820c = false;
    L41:
        int[] r103 = new int[2];
        Iterator<T> r104 = com.bytedance.commerce.base.view.b.a(this).iterator();
        boolean r105 = false;
    L43:
        if (r104.hasNext() == false) goto L59;
        View r106 = (View) r104.next();
        r106.getLocationOnScreen(r103);
        if (r110.getRawX() >= r103[0]) goto L47;
    L53:
        boolean r107 = false;
    L54:
        if (r107 == false) goto L43;
        if (this.f49818a.get(r106.hashCode()) == true) goto L43;
        r105 = r105 | r106.dispatchTouchEvent(r110);
        this.f49818a.put(r106.hashCode(), !r105);
        goto L43
    L47:
        if (r110.getRawX() > (r103[0] + r106.getWidth())) goto L53;
        if (r110.getRawY() < r103[1]) goto L53;
        if (r110.getRawY() > (r103[1] + r106.getHeight())) goto L53;
        r107 = true;
        goto L54
    L59:
        return r105;
    L37:
        if (r102 == 3) goto L39;
    L40:
        this.f49818a.clear();
        this.f49820c = true;
        goto L41
    L30:
        if (this.f49820c == true) goto L33;
        this.f49820c = false;
        return super.dispatchTouchEvent(r110);
    L16:
        if (this.f49819b == null) goto L27;
        float r108 = r110.getRawX();
        Rect r109 = this.f49819b;
        Intrinsics.checkNotNull(r109);
        if (r108 < r109.left) goto L27;
        float r111 = r110.getRawX();
        Rect r112 = this.f49819b;
        Intrinsics.checkNotNull(r112);
        if (r111 > r112.right) goto L27;
        float r113 = r110.getRawY();
        Rect r114 = this.f49819b;
        Intrinsics.checkNotNull(r114);
        if (r113 < r114.top) goto L27;
        float r115 = r110.getRawY();
        Rect r116 = this.f49819b;
        Intrinsics.checkNotNull(r116);
        if (r115 > r116.bottom) goto L27;
        r101 = true;
        goto L28
    L5:
        Iterator<T> r117 = this.f49821d.iterator();
        r100 = false;
    L7:
        if (r117.hasNext() == false) goto L12;
        boolean r118 = ((i) r117.next()).a();
        if (r100 == true) goto L7;
        r100 = r118;
        goto L7
    }

    @Override // com.bytedance.android.ec.window.base.view.j
    public void setupActiveRange(Rect r100) {
        this.f49819b = r100;
    }

    public ECWindowMultiDispatchFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f49818a = new SparseBooleanArray();
        this.f49821d = new LinkedHashSet();
    }

    public /* synthetic */ ECWindowMultiDispatchFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
