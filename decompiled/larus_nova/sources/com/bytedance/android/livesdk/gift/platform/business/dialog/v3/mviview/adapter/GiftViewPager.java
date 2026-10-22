package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.gift.configmodel.r0;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/GiftViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f127787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f127788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f127789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f127790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r0 f127791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f127792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f127793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Method f127794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Field f127795i;

    public GiftViewPager(Context r100) {
        this(r100, null);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L20;
        jy0.b.a("yz-debug-SSGridLayoutManager", "y " + r100.getY() + ", action: " + r100.getAction());
        int r101 = r100.getAction();
        if (r101 != 0) goto L6;
        this.f127787a = r100.getX();
        this.f127788b = r100.getY();
        goto L20
    L6:
        if (r101 != 2) goto L20;
        float r102 = r100.getX();
        float r103 = r100.getY();
        if (Math.abs(this.f127787a - r102) <= this.f127790d) goto L20;
        if ((Math.abs(r102 - this.f127787a) * 0.5f) <= Math.abs(r103 - this.f127788b)) goto L20;
        if (this.f127789c == true) goto L20;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.f130678t0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.f130639a[70])).booleanValue() == false) goto L20;
        return true;
    L20:
        return super.onInterceptTouchEvent(r100);
    }

    public GiftViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f127790d = ViewConfiguration.get(r100).getScaledTouchSlop();
        r0 r102 = (r0) com.bytedance.android.livesdk.gift.platform.core.h.f130686x0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.f130639a[74]);
        this.f127791e = r102;
        if (r102.b() == false) goto L18;
        addOnPageChangeListener(new AnonymousClass1(this));
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        Method r104 = GiftViewPager.class.getDeclaredMethod("infoForChild", new Class[]{View.class});     // Catch: Throwable -> L10
        this.f127794h = r104;     // Catch: Throwable -> L10
        if (r104 == null) goto L8;
        r104.setAccessible(true);     // Catch: Throwable -> L10
    L8:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L13:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L19;
        this.f127794h = null;
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (this.f127791e.e() == false) goto L8;
        if (this.f127791e.a(this.f127792f) == false) goto L8;
        return;
    L8:
        if (this.f127791e.d() == true) goto L10;
    L44:
        super.onDescendantInvalidated(r100, r101);
        return;
    L10:
        if (r100.getParent() != this) goto L44;
        if (r101 == r100) goto L44;
        if (this.f127793g != r101) goto L46;
        return;
    L46:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L35
        Method r103 = this.f127794h;     // Catch: Throwable -> L35
        if (r103 == null) goto L19;
        Object r104 = r103.invoke(this, new Object[]{r100});     // Catch: Throwable -> L35
    L20:
        if (r104 != null) goto L22;
    L30:
        int r105 = -1;
    L48:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L38:
        if (r105 != (-1)) goto L40;
    L43:
        this.f127793g = null;
        goto L44
    L40:
        if (r105 == getCurrentItem()) goto L43;
        this.f127793g = r101;
        return;
    L33:
        th = move-exception;
        int r106 = r105;
        th = th;
    L37:
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        r105 = r106;
        goto L38
    L22:
        if (this.f127795i != null) goto L26;
        Field r108 = r104.getClass().getDeclaredField("position");     // Catch: Throwable -> L35
        this.f127795i = r108;     // Catch: Throwable -> L35
        if (r108 == null) goto L26;
        r108.setAccessible(true);     // Catch: Throwable -> L35
    L26:
        Field r109 = this.f127795i;     // Catch: Throwable -> L35
        if (r109 == null) goto L30;
        r105 = r109.getInt(r104);     // Catch: Throwable -> L35
        goto L48
    L19:
        r104 = null;
    L35:
        th = th;
        r106 = -1;
        goto L37
    }
}
