package com.bytedance.android.gamecp.business.gamedetail.component.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.platform.comapi.map.MapController;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/tab/GameDetailTabViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", MapController.ITEM_LAYER_TAG, "", "setCurrentItem", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDetailTabViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f55033a;

    public static final class a {
    }

    static {
    }

    public GameDetailTabViewPager(Context r100) {
        this(r100, null);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        r100.getAction();
    L4:
        View r101 = getChildAt(getCurrentItem());
        if (r101 == null) goto L31;
        if (this.f55033a != null) goto L9;
        this.f55033a = (RecyclerView) r101.findViewWithTag("HorizontalListView");
    L9:
        RecyclerView r102 = this.f55033a;
        if (r102 == null) goto L31;
        boolean r103 = true;
        if (r102.canScrollVertically(1) == true) goto L31;
        if (r100 == null) goto L16;
        int r104 = (int) r100.getX();
    L17:
        if (r100 == null) goto L19;
        int r105 = (int) r100.getY();
    L20:
        if (r104 < 0) goto L27;
        if (r105 < 0) goto L27;
        if (r104 >= ((r102.getRight() - r102.getLeft()) + 0)) goto L27;
        if (r105 >= ((r102.getBottom() - r102.getTop()) + 0)) goto L27;
    L28:
        if (r103 == false) goto L31;
        return false;
    L27:
        r103 = false;
        goto L28
    L19:
        r105 = 0;
        goto L20
    L16:
        r104 = 0;
    L31:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r100) {
        super.setCurrentItem(r100, false);
    }

    public GameDetailTabViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        addOnPageChangeListener(new AnonymousClass1(this));
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int r100, boolean r101) {
        super.setCurrentItem(r100, r101);
    }
}
