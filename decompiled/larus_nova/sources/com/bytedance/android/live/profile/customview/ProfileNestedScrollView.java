package com.bytedance.android.live.profile.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.ProfileTabsComponent;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0006\u0013B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profile/customview/ProfileNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "getMaxScrollHeight", "getScrolledHeight", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "isMyLiveScroll", "()Z", "setMyLiveScroll", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileNestedScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f85982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<b> f85983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f85984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f85985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OverScroller f85986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Method f85987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f85988g;

    public static final class a {
    }

    public interface b {
        void a(int r100, int r101, int r102);
    }

    static {
    }

    public ProfileNestedScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProfileNestedScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getMaxScrollHeight() {
        if (this.f85984c != null) goto L6;
        this.f85984c = getChildAt(0);
    L6:
        if (this.f85985d != null) goto L8;
        this.f85985d = findViewById(R.id.new_profile_tab_container);
    L8:
        View r100 = this.f85984c;
        if (r100 != null) goto L12;
        ALogger.e("ProfileNestedScrollView", "getMaxScrollHeight, directChild is null");
        return 0;
    L12:
        View r101 = this.f85985d;
        if (r101 != null) goto L16;
        ALogger.e("ProfileNestedScrollView", "getMaxScrollHeight, myLiveChild is null");
        return 0;
    L16:
        int r102 = r100.getHeight() - r101.getHeight();
        int r103 = com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.a.f86610i;
        int r104 = r102 - UtilityKotlinExtentionsKt.i(52);
        int r105 = ProfileTabsComponent.f86573m;
        return r104 + UtilityKotlinExtentionsKt.i(16);
    }

    public final int getScrolledHeight() {
        return getScrollY();
    }

    public static String e(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        return "MotionEvent.ACTION_DOWN";
    L5:
        if (r101 != 1) goto L7;
        return "MotionEvent.ACTION_UP";
    L7:
        if (r101 != 2) goto L9;
        return "MotionEvent.ACTION_MOVE";
    L9:
        if (r101 == 3) goto L11;
        return "";
    L11:
        return "MotionEvent.ACTION_CANCEL";
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f85982a == false) goto L5;
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L14;
        if (r101 != 1) goto L10;
    L12:
        ALogger.i("ProfileNestedScrollView", "onInterceptTouchEvent, eventType = " + e(r100) + ", stop block scroll, reset ignoreCurrentSequence = false");
        this.f85988g = false;
    L19:
        if (this.f85988g == false) goto L23;
        ALogger.i("ProfileNestedScrollView", "onInterceptTouchEvent, eventType = " + e(r100) + ", ignoreCurrentSequence");
        return false;
    L23:
        if (r100.getActionMasked() == 0) goto L58;
    L53:
        boolean r102 = super.onInterceptTouchEvent(r100);
        if (r100.getActionMasked() != 0) goto L56;
        ALogger.e("ProfileNestedScrollView", "onInterceptTouchEvent, eventType = " + e(r100) + ", result = " + r102);
    L57:
        return r102;
    L56:
        ALogger.i("ProfileNestedScrollView", "onInterceptTouchEvent, eventType = " + e(r100) + ", result = " + r102);
        goto L57
    L58:
    L51:
        th = move-exception;
        ALogger.e("ProfileNestedScrollView", "setParentScrollerFinish error, " + th.getMessage());
        goto L53
    L25:
        if (this.f85986e != null) goto L39;
        Field r103 = NestedScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L51
        if (r103 == null) goto L29;
        r103.setAccessible(true);     // Catch: Throwable -> L51
    L29:
        Object r104 = null;
        if (r103 == null) goto L32;
        Object r105 = r103.get(this);     // Catch: Throwable -> L51
    L34:
        if ((r105 instanceof OverScroller) == false) goto L37;
        r104 = r105;
    L37:
        this.f85986e = (OverScroller) r104;     // Catch: Throwable -> L51
        goto L39
    L32:
        r105 = null;
    L39:
        if (this.f85987f != null) goto L43;
        Method r106 = NestedScrollView.class.getDeclaredMethod("abortAnimatedScroll", new Class[0]);     // Catch: Throwable -> L51
        this.f85987f = r106;     // Catch: Throwable -> L51
        if (r106 == null) goto L43;
        r106.setAccessible(true);     // Catch: Throwable -> L51
    L43:
        OverScroller r107 = this.f85986e;     // Catch: Throwable -> L51
        if (r107 != null) goto L46;
    L47:
        ALogger.i("ProfileNestedScrollView", "setParentScrollerFinish set mScroller finish");     // Catch: Throwable -> L51
        Method r108 = this.f85987f;     // Catch: Throwable -> L51
        if (r108 == null) goto L53;
        r108.invoke(this, new Object[0]);     // Catch: Throwable -> L51
        goto L53
    L46:
        if (r107.isFinished() == true) goto L53;
    L10:
        if (r101 == 3) goto L12;
    L14:
        if (getScrollY() < getMaxScrollHeight()) goto L16;
        ALogger.i("ProfileNestedScrollView", "onInterceptTouchEvent, eventType = " + e(r100) + ", block scroll, set ignoreCurrentSequence = true");
        boolean r109 = true;
    L17:
        this.f85988g = r109;
        goto L19
    L16:
        r109 = false;
        goto L17
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        boolean r101 = false;
        if (this.f85982a == false) goto L34;
        int r102 = r100.getActionMasked();
        boolean r103 = true;
        if (r102 == 0) goto L17;
        if (r102 != 1) goto L13;
    L15:
        ALogger.i("ProfileNestedScrollView", "onTouchEvent, eventType = " + e(r100) + ", stop block scroll, reset ignoreCurrentSequence = false");
        this.f85988g = false;
    L22:
        if (this.f85988g == false) goto L36;
        ALogger.i("ProfileNestedScrollView", "onTouchEvent, eventType = " + e(r100) + ", ignoreCurrentSequence");
        return false;
    L36:
        r101 = super.onTouchEvent(r100);     // Catch: Exception -> L27
    L30:
        if (r100.getActionMasked() != 0) goto L32;
        ALogger.e("ProfileNestedScrollView", "onTouchEvent, eventType = " + e(r100) + ", result = " + r101);
    L33:
        return r101;
    L32:
        ALogger.i("ProfileNestedScrollView", "onTouchEvent, eventType = " + e(r100) + ", result = " + r101);
    L27:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        goto L30
    L13:
        if (r102 == 3) goto L15;
    L17:
        if (getScrollY() < getMaxScrollHeight()) goto L19;
        ALogger.i("ProfileNestedScrollView", "onTouchEvent, eventType = " + e(r100) + ", block scroll, set ignoreCurrentSequence = true");
    L20:
        this.f85988g = r103;
        goto L22
    L19:
        r103 = false;
        goto L20
    L34:
        return super.onTouchEvent(r100);
    L6:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        return false;
    }

    public final void setMyLiveScroll(boolean r100) {
        this.f85982a = r100;
    }

    public ProfileNestedScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ProfileNestedScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        List<b> r104 = this.f85983b;
        if (r104 == null) goto L8;
        Iterator r105 = ((ArrayList) r104).iterator();
    L6:
        if (r105.hasNext() == false) goto L10;
        ((b) r105.next()).a(r101, getScrollY(), getMaxScrollHeight());
        goto L6
    L10:
        return;
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (this.f85982a == true) goto L7;
        return super.onStartNestedScroll(r100, r101, r102, r103);
    L7:
        if ((r102 & 2) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        if (this.f85982a == true) goto L6;
        super.onNestedPreScroll(r100, r101, r102, r103, r104);
        return;
    L6:
        int r105 = getScrollY();
        int r106 = getMaxScrollHeight();
        ALogger.i("ProfileNestedScrollView", "onNestedPreScroll, scrolled = " + r105 + ", maxScrollHeight = " + r106);
        if (r102 <= 0) goto L10;
        if (r105 >= r106) goto L13;
        int r107 = Math.min(r102, r106 - r105);
        ALogger.i("ProfileNestedScrollView", "onNestedPreScroll, up, dy = " + r102 + ", canScroll = " + r107);
        smoothScrollBy(0, r107);
        r103[1] = r107;
        return;
    L13:
        return;
    L10:
        if (r105 >= r106) goto L15;
        int r108 = Math.min(Math.abs(r102), r105);
        ALogger.i("ProfileNestedScrollView", "onNestedPreScroll, down, dy = " + r102 + ", canScroll = " + r108);
        int r109 = -r108;
        smoothScrollBy(0, r109);
        r103[1] = r109;
        return;
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r106, "consumed");
        if (this.f85982a == true) goto L6;
        super.onNestedScroll(r100, r101, r102, r103, r104, r105, r106);
        return;
    L6:
        ALogger.i("ProfileNestedScrollView", "onNestedScroll, dyConsumed = " + r102 + ", dyUnconsumed = " + r104);
        if (r104 >= 0) goto L12;
        int r107 = getScrollY();
        if (r107 <= 0) goto L13;
        int r108 = Math.min(Math.abs(r104), r107);
        ALogger.i("ProfileNestedScrollView", "onNestedScroll, down, dyUnconsumed = " + r104 + ", canScroll = " + r108);
        int r109 = -r108;
        smoothScrollBy(0, r109);
        r106[1] = r109;
        return;
    L13:
        return;
    }
}
