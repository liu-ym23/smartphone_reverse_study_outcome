package com.bytedance.android.live.room.navi.userinfo.flipper.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import i91.c;
import i91.d;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0006RB'\b\u0007\u0012\u0006\u0010L\u001a\u00020K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010O\u001a\u00020\u0005¢\u0006\u0004\bP\u0010QJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\f\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020+8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010.R\"\u00103\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0007\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR$\u00105\u001a\u0004\u0018\u0001048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010ARN\u0010E\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020C\u0018\u00010B2\u0018\u0010D\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020C\u0018\u00010B8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006S"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/flipper/core/BaseTabFlipper;", "Landroid/widget/FrameLayout;", "", "Landroid/view/View;", "getCurDisplayView", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getCurShowPos", "()I", "setCurShowPos", "(I)V", "curShowPos", "", "b", "Z", "getFlipping", "()Z", "setFlipping", "(Z)V", "flipping", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "getDisplayView", "()Ljava/lang/ref/WeakReference;", "setDisplayView", "(Ljava/lang/ref/WeakReference;)V", "displayView", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "getNextTabDisposable", "()Lio/reactivex/disposables/Disposable;", "setNextTabDisposable", "(Lio/reactivex/disposables/Disposable;)V", "nextTabDisposable", "Li91/c;", "f", "Lkotlin/Lazy;", "getAnimController", "()Li91/c;", "animController", "Lj91/b;", ce.f26391f, "getDataObserver", "()Lj91/b;", "dataObserver", "h", "getExpectAdapterCount", "setExpectAdapterCount", "expectAdapterCount", "Li91/a;", "nextTabExecutor", "Li91/a;", "getNextTabExecutor", "()Li91/a;", "setNextTabExecutor", "(Li91/a;)V", "Li91/a$a;", "executorCallback", "Li91/a$a;", "getExecutorCallback", "()Li91/a$a;", "setExecutorCallback", "(Li91/a$a;)V", "Li91/b;", "Li91/d;", "value", "adapter", "Li91/b;", "getAdapter", "()Li91/b;", "setAdapter", "(Li91/b;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LayoutParams", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseTabFlipper extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f99789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f99790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<d> f99791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<View> f99792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f99793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f99794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f99795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f99796h;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/flipper/core/BaseTabFlipper$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/content/Context;", "c", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f99797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f99798b;

        public LayoutParams() {
            super(-2, -2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super(r100);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, "c");
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public BaseTabFlipper(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseTabFlipper(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        Disposable r100 = this.f99793e;
        if (r100 != null) goto L5;
    L10:
        this.f99793e = null;
        Unit r101 = Unit.INSTANCE;
        return;
    L5:
        if ((true ^ r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    public final boolean d() {
        return false;
    }

    public i91.b<? extends Object, ? extends d> getAdapter() {
        return null;
    }

    public c getAnimController() {
        return (c) this.f99794f.getValue();
    }

    public final j91.b<Object> getDataObserver() {
        return (j91.b) this.f99795g.getValue();
    }

    public final i91.a.InterfaceC6243a getExecutorCallback() {
        return null;
    }

    public final i91.a getNextTabExecutor() {
        return null;
    }

    public final void setExecutorCallback(i91.a.InterfaceC6243a r100) {
    }

    public final void setNextTabExecutor(i91.a r100) {
    }

    public void c() {
        WeakReference<View> r100 = this.f99792d;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        getAdapter();
        this.f99796h = 0;
        if (r101 == null) goto L15;
        LayoutParams r102 = com.bytedance.android.live.room.navi.userinfo.flipper.core.a.a(r101);
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.f99798b != null) goto L13;
        return;
    L13:
        b();
        this.f99792d = null;
        this.f99789a = -1;
        a();
        e();
        return;
    L15:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public View getCurDisplayView() {
        WeakReference<View> r100 = this.f99792d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public final void a() {
        Iterator<View> r100 = UtilityKotlinExtentionsKt.g(this).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        r100.next().clearAnimation();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("BaseTabFlipper", e);
        if (v.a() == false) goto L4;
        throw e;
    }

    public final void e() {
        Iterator<View> r100 = UtilityKotlinExtentionsKt.g(this).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        View r101 = r100.next();
        f(r101);
        r101.clearAnimation();
        goto L4
    L6:
        removeAllViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        a();
    }

    public final int getCurShowPos() {
        return this.f99789a;
    }

    public final WeakReference<View> getDisplayView() {
        return this.f99792d;
    }

    public final int getExpectAdapterCount() {
        return this.f99796h;
    }

    public final boolean getFlipping() {
        return this.f99790b;
    }

    public final Disposable getNextTabDisposable() {
        return this.f99793e;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    public final void f(View r100) {
        LayoutParams r101 = com.bytedance.android.live.room.navi.userinfo.flipper.core.a.a(r100);
        if (r101 == null) goto L32;
        d r102 = r101.f99797a;
        if (r102 == null) goto L38;
        b<d> r103 = this.f99791c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "instance");
        int r104 = r102.b();
        ViewGroup.LayoutParams r105 = r102.a().getLayoutParams();
        if ((r105 instanceof LayoutParams) == true) goto L9;
        r105 = null;
    L9:
        LayoutParams r106 = (LayoutParams) r105;
        if (r106 == null) goto L12;
        r106.f99797a = null;
        r106.f99798b = null;
    L12:
        int r107 = 0;
        if (r103.f99804b <= 0) goto L26;
        int r108 = 0;
    L15:
        if (r108 >= 8) goto L23;
        Pair r109 = r103.f99803a[r108];
        if (r109 == null) goto L19;
        d r110 = (d) r109.getSecond();
    L20:
        if (r110 == r102) goto L21;
        r108 = r108 + 1;
        goto L15
    L21:
        boolean r111 = true;
    L24:
        if (r111 == true) goto L26;
    L27:
        if (r107 >= 8) goto L41;
        Object[] r112 = r103.f99803a;
        if (r112[r107] == null) goto L30;
        r107 = r107 + 1;
        goto L27
    L30:
        r112[r107] = new Pair(Integer.valueOf(r104), r102);
        r103.f99804b++;
        return;
    L41:
        return;
    L19:
        r110 = null;
        goto L20
    L23:
        r111 = false;
    L26:
        if (r103.f99804b == 0) goto L27;
        return;
    L38:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == false) goto L6;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L6:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L9:
        return new ViewGroup.LayoutParams(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdapter(i91.b<? extends Object, ? extends d> r100) {
        if ((!Intrinsics.areEqual(null, r100)) == false) goto L19;
        removeAllViews();
        b<d> r101 = this.f99791c;
        r101.getClass();
        int r102 = 0;
    L6:
        if (r102 >= 8) goto L8;
        r101.f99803a[r102] = 0;
        r102 = r102 + 1;
        goto L6
    L8:
        r101.f99804b = 0;
        b();
        this.f99792d = null;
        this.f99789a = -1;
        this.f99796h = 0;
        if (r100 != null) goto L11;
        return;
    L11:
        this.f99796h = r100.getItemSize();
        if (this.f99790b == false) goto L16;
        this.f99789a = -1;
        this.f99790b = true;
        if (d() == true) goto L20;
        getAdapter();
        return;
    L20:
        return;
    L16:
        getAdapter();
        return;
    }

    public final void setCurShowPos(int r100) {
        this.f99789a = r100;
    }

    public final void setDisplayView(WeakReference<View> r100) {
        this.f99792d = r100;
    }

    public final void setExpectAdapterCount(int r100) {
        this.f99796h = r100;
    }

    public final void setFlipping(boolean r100) {
        this.f99790b = r100;
    }

    public final void setNextTabDisposable(Disposable r100) {
        this.f99793e = r100;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    public BaseTabFlipper(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f99789a = -1;
        this.f99790b = true;
        this.f99791c = new b();
        this.f99794f = LazyKt.lazy(BaseTabFlipper$animController$2.INSTANCE);
        this.f99795g = LazyKt.lazy(new BaseTabFlipper$dataObserver$2(this));
        this.f99790b = r100.obtainStyledAttributes(r101, new int[]{R.attr.flipper_auto_start}).getBoolean(0, true);
    }

    public /* synthetic */ BaseTabFlipper(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
