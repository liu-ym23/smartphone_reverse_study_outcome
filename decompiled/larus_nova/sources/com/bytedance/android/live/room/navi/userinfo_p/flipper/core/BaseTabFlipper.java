package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
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
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0006UB'\b\u0007\u0012\u0006\u0010O\u001a\u00020N\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\b\u0002\u0010R\u001a\u00020\u0005¢\u0006\u0004\bS\u0010TJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\f\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010%8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010-8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u0010:\u001a\u0002058TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R!\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020;8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u0010>R\"\u0010C\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0007\u001a\u0004\bA\u0010\t\"\u0004\bB\u0010\u000bRN\u0010M\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020E\u0018\u00010D2\u0018\u0010F\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020E\u0018\u00010D8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006V"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/core/BaseTabFlipper;", "Landroid/widget/FrameLayout;", "", "Landroid/view/View;", "getCurDisplayView", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getCurShowPos", "()I", "setCurShowPos", "(I)V", "curShowPos", "", "b", "Z", "getFlipping", "()Z", "setFlipping", "(Z)V", "flipping", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "getDisplayView", "()Ljava/lang/ref/WeakReference;", "setDisplayView", "(Ljava/lang/ref/WeakReference;)V", "displayView", "Lw91/a;", "e", "Lw91/a;", "getNextTabExecutor", "()Lw91/a;", "setNextTabExecutor", "(Lw91/a;)V", "nextTabExecutor", "Lw91/a$a;", "f", "Lw91/a$a;", "getExecutorCallback", "()Lw91/a$a;", "setExecutorCallback", "(Lw91/a$a;)V", "executorCallback", "Lio/reactivex/disposables/Disposable;", ce.f26391f, "Lio/reactivex/disposables/Disposable;", "getNextTabDisposable", "()Lio/reactivex/disposables/Disposable;", "setNextTabDisposable", "(Lio/reactivex/disposables/Disposable;)V", "nextTabDisposable", "Lw91/d;", "h", "Lkotlin/Lazy;", "getAnimController", "()Lw91/d;", "animController", "Lj91/b;", RXScreenCaptureService.KEY_INDEX, "getDataObserver", "()Lj91/b;", "dataObserver", ce.f26395j, "getExpectAdapterCount", "setExpectAdapterCount", "expectAdapterCount", "Lw91/b;", "Lw91/f;", "value", ce.f26396k, "Lw91/b;", "getAdapter", "()Lw91/b;", "setAdapter", "(Lw91/b;)V", "adapter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LayoutParams", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseTabFlipper extends FrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f100014l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f100015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f100016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h<w91.f> f100017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<View> f100018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w91.a f100019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w91.a.InterfaceC8082a f100020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f100021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f100022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f100023i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f100024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public w91.b<? extends Object, ? extends w91.f> f100025k;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/core/BaseTabFlipper$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/content/Context;", "c", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w91.f f100026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f100027b;

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

    public static final class b implements w91.a.InterfaceC8082a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w91.a f100028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseTabFlipper f100029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f100030c;

        @Override // w91.a.InterfaceC8082a
        public final void a() {
            this.f100028a.d();
            w91.e r100 = e.b(this.f100030c);
            if (Intrinsics.areEqual(this.f100029b.getNextTabExecutor(), this.f100028a) == false) goto L11;
            WeakReference<View> r101 = this.f100029b.getDisplayView();
            if (r101 == null) goto L7;
            View r102 = r101.get();
        L9:
            if (Intrinsics.areEqual(r102, this.f100030c) == false) goto L11;
            this.f100029b.i();
            return;
        L7:
            r102 = null;
        L11:
            int r103 = BaseTabFlipper.f100014l;
            ALogger.i("BaseTabFlipper", "don't execute next because the executor has changed." + r100);
            ALogger.i("BaseTabFlipper", "curPos:" + this.f100029b.getCurShowPos() + "\tthe fipperData" + r100 + "\tisAutoFlip:" + this.f100029b.getFlipping() + "\tisExecutingNext:" + this.f100029b.g());
        }

        public b(w91.a r100, BaseTabFlipper r101, View r102) {
            this.f100028a = r100;
            this.f100029b = r101;
            this.f100030c = r102;
        }
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

    public w91.d getAnimController() {
        return (w91.d) this.f100022h.getValue();
    }

    public final j91.b<Object> getDataObserver() {
        return (j91.b) this.f100023i.getValue();
    }

    public final void a() {
        w91.a r100 = this.f100019e;
        if (r100 == null) goto L25;
        int r101 = r100.a();
        if (r101 <= 0) goto L11;
        if (r101 != 1) goto L20;
        w91.a.InterfaceC8082a r102 = this.f100020f;
        if (r102 == null) goto L20;
        if (r100.c(r102) == true) goto L11;
    L20:
        w91.a.InterfaceC8082a r103 = this.f100020f;
        if (r103 == null) goto L23;
        r100.e(r103);
    L24:
        if (r103 == null) goto L25;
        return;
    L23:
        r103 = null;
    L11:
        Disposable r104 = this.f100021g;
        if (r104 != null) goto L14;
    L19:
        this.f100021g = null;
        goto L20
    L14:
        if ((!r104.isDisposed()) == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L19;
        r104.dispose();
    L25:
        Disposable r105 = this.f100021g;
        if (r105 != null) goto L28;
    L33:
        this.f100021g = null;
        Unit r106 = Unit.INSTANCE;
        return;
    L28:
        if ((true ^ r105.isDisposed()) == true) goto L31;
        r105 = null;
    L31:
        if (r105 == null) goto L33;
        r105.dispose();
        goto L33
    }

    public void d() {
        WeakReference<View> r100 = this.f100018d;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        w91.b<? extends Object, ? extends w91.f> r102 = getAdapter();
        if ((r102 instanceof w91.b) == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L11;
        int r103 = r102.getItemSize();
    L12:
        this.f100024j = r103;
        if (r101 == null) goto L29;
        LayoutParams r104 = e.a(r101);
        if (r104 == null) goto L30;
        Object r105 = r104.f100027b;
        if (r105 != 0) goto L20;
        return;
    L20:
        if (r102 == null) goto L22;
        int r106 = r102.getDataPosition(r105);
    L23:
        if (r106 >= 0) goto L31;
        c();
        if (r103 > 0) goto L27;
        this.f100018d = null;
        this.f100015a = -1;
        b();
        h();
        return;
    L27:
        i();
        return;
    L31:
        return;
    L22:
        r106 = -1;
        goto L23
    L30:
        return;
    L29:
        return;
    L11:
        r103 = 0;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final boolean g() {
        if (this.f100019e == null) goto L9;
        Disposable r100 = this.f100021g;
        if (r100 == null) goto L9;
        if (r100.isDisposed() == true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public View getCurDisplayView() {
        WeakReference<View> r100 = this.f100018d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public final void i() {
        int r100 = this.f100015a + 1;
        if (r100 < 0) goto L9;
        w91.b<? extends Object, ? extends w91.f> r101 = getAdapter();
        if (r101 == null) goto L7;
        int r102 = r101.getItemSize();
    L8:
        if (r100 >= r102) goto L9;
    L10:
        j(r100, true);
        return;
    L7:
        r102 = 0;
    L9:
        r100 = 0;
        goto L10
    }

    public final void b() {
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

    public final void c() {
        a();
        this.f100019e = null;
    }

    public final void h() {
        Iterator<View> r100 = UtilityKotlinExtentionsKt.g(this).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        View r101 = r100.next();
        k(r101);
        r101.clearAnimation();
        goto L4
    L6:
        removeAllViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
        b();
    }

    public w91.b<? extends Object, ? extends w91.f> getAdapter() {
        return this.f100025k;
    }

    public final int getCurShowPos() {
        return this.f100015a;
    }

    public final WeakReference<View> getDisplayView() {
        return this.f100018d;
    }

    public final w91.a.InterfaceC8082a getExecutorCallback() {
        return this.f100020f;
    }

    public final int getExpectAdapterCount() {
        return this.f100024j;
    }

    public final boolean getFlipping() {
        return this.f100016b;
    }

    public final Disposable getNextTabDisposable() {
        return this.f100021g;
    }

    public final w91.a getNextTabExecutor() {
        return this.f100019e;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    public final int f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        Integer r102 = null;
        if ((r101 instanceof LayoutParams) == true) goto L5;
        r101 = null;
    L5:
        LayoutParams r103 = (LayoutParams) r101;
        if (r103 == null) goto L16;
        Object r104 = r103.f100027b;
        if (r104 == 0) goto L16;
        w91.b<? extends Object, ? extends w91.f> r105 = getAdapter();
        if ((r105 instanceof w91.b) == true) goto L12;
        r105 = null;
    L12:
        if (r105 == null) goto L14;
        r102 = Integer.valueOf(r105.getDataPosition(r104));
    L14:
        if (r102 == null) goto L16;
        return r102.intValue();
    L16:
        return -1;
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

    public final void k(View r100) {
        LayoutParams r101 = e.a(r100);
        if (r101 == null) goto L32;
        w91.f r102 = r101.f100026a;
        if (r102 == null) goto L38;
        h<w91.f> r103 = this.f100017c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "instance");
        int r104 = r102.b();
        ViewGroup.LayoutParams r105 = r102.a().getLayoutParams();
        if ((r105 instanceof LayoutParams) == true) goto L9;
        r105 = null;
    L9:
        LayoutParams r106 = (LayoutParams) r105;
        if (r106 == null) goto L12;
        r106.f100026a = null;
        r106.f100027b = null;
    L12:
        int r107 = 0;
        if (r103.f100053b <= 0) goto L26;
        int r108 = 0;
    L15:
        if (r108 >= 8) goto L23;
        Pair r109 = r103.f100052a[r108];
        if (r109 == null) goto L19;
        w91.f r110 = (w91.f) r109.getSecond();
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
        Object[] r112 = r103.f100052a;
        if (r112[r107] == null) goto L30;
        r107 = r107 + 1;
        goto L27
    L30:
        r112[r107] = new Pair(Integer.valueOf(r104), r102);
        r103.f100053b++;
        return;
    L41:
        return;
    L19:
        r110 = null;
        goto L20
    L23:
        r111 = false;
    L26:
        if (r103.f100053b == 0) goto L27;
        return;
    L38:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdapter(w91.b<? extends Object, ? extends w91.f> r100) {
        if ((!Intrinsics.areEqual(this.f100025k, r100)) == false) goto L19;
        w91.b<? extends Object, ? extends w91.f> r101 = this.f100025k;
        if ((r101 instanceof w91.b) == true) goto L7;
        r101 = null;
    L7:
        if (r101 == null) goto L9;
        r101.c(null);
    L9:
        removeAllViews();
        h<w91.f> r102 = this.f100017c;
        r102.getClass();
        int r103 = 0;
    L11:
        if (r103 >= 8) goto L13;
        r102.f100052a[r103] = 0;
        r103 = r103 + 1;
        goto L11
    L13:
        r102.f100053b = 0;
        c();
        this.f100018d = null;
        this.f100015a = -1;
        this.f100025k = r100;
        this.f100024j = 0;
        if (r100 != null) goto L16;
        return;
    L16:
        this.f100024j = r100.getItemSize();
        r100.c(getDataObserver());
        return;
    }

    public final void setCurShowPos(int r100) {
        this.f100015a = r100;
    }

    public final void setDisplayView(WeakReference<View> r100) {
        this.f100018d = r100;
    }

    public final void setExecutorCallback(w91.a.InterfaceC8082a r100) {
        this.f100020f = r100;
    }

    public final void setExpectAdapterCount(int r100) {
        this.f100024j = r100;
    }

    public final void setFlipping(boolean r100) {
        this.f100016b = r100;
    }

    public final void setNextTabDisposable(Disposable r100) {
        this.f100021g = r100;
    }

    public final void setNextTabExecutor(w91.a r100) {
        this.f100019e = r100;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    public void e(w91.f r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "enterHolder");
        Intrinsics.checkNotNullParameter(r101, "enterView");
        ALogger.i("BaseTabFlipper", "start executeNextTabJob,the flipper data is:" + e.b(r101));
        c();
        if (this.f100016b == false) goto L6;
        w91.a r102 = r100.g();
        b r103 = new b(r102, this, r101);
        r102.b(r103);
        Unit r104 = Unit.INSTANCE;
        this.f100020f = r103;
        this.f100019e = r102;
        this.f100021g = r102.execute();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(int r110, boolean r111) {
        w91.b<? extends Object, ? extends w91.f> r100 = getAdapter();
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.getItemSize();
        if (r101 > 0) goto L10;
        ALogger.d("BaseTabFlipper", "当前没有数据要展示");
        return;
    L10:
        if (r101 == this.f100024j) goto L19;
        ALogger.e("BaseTabFlipper", "数据更新不符合预期");
        if (v.a() == false) goto L19;
        String r102 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L16
    L18:
        throw new IllegalStateException("变更ITabAdapter的数据时要请调用notifyDataSetChange()。 Expected adapter item count: " + this.f100024j + ", current item count: " + r101 + " FlipperLayout id: " + r102 + " FlipperLayout class: " + getClass() + " Problematic adapter: " + r100.getClass());
    L16:
        r102 = Integer.toHexString(getId());
    L19:
        this.f100015a = r110;
        boolean r103 = false;
        if (r110 < 0) goto L22;
        if (r110 >= r101) goto L22;
    L23:
        w91.b<? extends Object, ? extends w91.f> r104 = getAdapter();
        if (r104 == null) goto L157;
        int r105 = r104.getItemSize();
        int r106 = this.f100015a;
        if (r106 < 0) goto L138;
        if (r106 >= r105) goto L138;
        if (r105 <= 0) goto L138;
        u91.a r107 = r104.getData(r106);
        Intrinsics.checkNotNullParameter(r104, "adapter");
        WeakReference<View> r108 = this.f100018d;
        w91.d r109 = null;
        if (r108 == null) goto L36;
        View r112 = r108.get();
        if (r112 == null) goto L36;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
    L38:
        if ((r113 instanceof LayoutParams) == true) goto L40;
        r113 = null;
    L40:
        LayoutParams r114 = (LayoutParams) r113;
        if (r114 == null) goto L49;
        w91.f r115 = r114.f100026a;
        if (r115 == null) goto L49;
        if (r115.b() != r104.getItemViewType(r106)) goto L49;
        if (Intrinsics.areEqual(r114.f100027b, r107) == false) goto L49;
        boolean r116 = true;
    L50:
        if (r116 == false) goto L52;
        ALogger.d("BaseTabFlipper", "将要轮播的view已经在展示了");
        return;
    L52:
        ALogger.d("BaseTabFlipper", "show pos:" + this.f100015a);
        Intrinsics.checkNotNullParameter(r104, "adapter");
        int r117 = r104.getItemViewType(r106);
        int r118 = r104.getItemSize();
        Intrinsics.checkNotNullParameter(r104, "adapter");
        h<w91.f> r119 = this.f100017c;
        r119.getClass();
        int r120 = 7;
    L53:
        if (r120 < 0) goto L62;
        if (r119.f100053b <= 0) goto L62;
        Pair r121 = r119.f100052a[r120];
        if (r121 == null) goto L61;
        if (((Number) r121.getFirst()).intValue() != r117) goto L61;
        w91.f r122 = (w91.f) r121.getSecond();
        r119.f100052a[r120] = 0;
        r119.f100053b--;
        w91.f r123 = r122;
    L63:
        ALogger.d("BaseTabFlipper", "obtainTabHolder from pool.the holder is " + r123);
        w91.f r124 = r123;
        if (r123 != null) goto L73;
        CommonTabHolder r125 = r104.b(this, r117);
        r125.e(r117);
        if (r125.f99933f.getParent() != null) goto L68;
    L72:
        r125.m();
        ALogger.d("BaseTabFlipper", "obtainTabHolder from onCreateHolder.the holder is " + r125);
        r124 = r125;
        goto L73
    L68:
        if (v.a() == false) goto L72;
        ALogger.e("BaseTabFlipper", "ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
        throw new IllegalArgumentException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
    L73:
        Intrinsics.checkNotNullParameter(r124, "enterHolder");
        View r126 = r124.a();
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
        if (r127 != null) goto L77;
        r127 = generateDefaultLayoutParams();
        r126.setLayoutParams(r127);
    L80:
        if ((r127 instanceof LayoutParams) == true) goto L82;
        r127 = null;
    L82:
        LayoutParams r128 = (LayoutParams) r127;
        if (r128 == null) goto L85;
        r128.f100027b = r107;
        r128.f100026a = r124;
        ALogger.d("BaseTabFlipper", "bind holder itemView's layout params data.the itemView:" + r124.a() + ".the itemData:" + r107 + '.');
    L85:
        WeakReference<View> r129 = this.f100018d;
        if (r129 == null) goto L90;
        View r130 = r129.get();
        if (r130 == null) goto L90;
        ViewGroup.LayoutParams r131 = r130.getLayoutParams();
    L92:
        if ((r131 instanceof LayoutParams) == true) goto L94;
        r131 = null;
    L94:
        LayoutParams r132 = (LayoutParams) r131;
        if (r132 == null) goto L97;
        w91.f r133 = r132.f100026a;
    L98:
        StringBuilder r134 = new StringBuilder("the exit holder:");
        if (r133 == null) goto L101;
        w91.e r135 = e.c(r133);
    L102:
        r134.append(r135);
        r134.append("\tthe enter holder:");
        r134.append(e.c(r124));
        ALogger.d("BaseTabFlipper", r134.toString());
        View r136 = r124.a();
        ViewParent r137 = r136.getParent();
        if ((r137 instanceof ViewGroup) == true) goto L105;
        r137 = null;
    L105:
        ViewGroup r138 = (ViewGroup) r137;
        if (r138 != null) goto L108;
    L113:
        addView(r136);
        ALogger.d("BaseTabFlipper", "cur childCount is " + getChildCount());
        Iterator<View> r139 = UtilityKotlinExtentionsKt.g(this).iterator();
    L115:
        if (r139.hasNext() == false) goto L125;
        View r140 = r139.next();
        if (r133 == null) goto L119;
        View r141 = r133.a();
    L121:
        if ((!Intrinsics.areEqual(r140, r141)) == false) goto L115;
        if ((!Intrinsics.areEqual(r140, r136)) == false) goto L115;
        ALogger.d("BaseTabFlipper", "remove extra view and its data is :" + e.b(r140));
        Intrinsics.checkNotNullParameter(r140, "view");
        k(r140);
        r140.clearAnimation();
        removeViewInLayout(r140);
        goto L115
    L119:
        r141 = null;
        goto L121
    L125:
        r104.a(r124, r106);
        a();
        w91.d r142 = getAnimController();
        if (r111 == true) goto L128;
    L130:
        if (r103 == false) goto L132;
        r109 = r142;
    L132:
        if (r109 == null) goto L134;
        ALogger.d("BaseTabFlipper", "doAnim");
        this.f100018d = new WeakReference(r136);
        r109.b(r133, r124, new d(r136, r124, this, r133, r104));
        return;
    L134:
        ALogger.d("BaseTabFlipper", "undoAnim");
        if (r133 == null) goto L137;
        View r143 = r133.a();
        Intrinsics.checkNotNullParameter(r143, "view");
        k(r143);
        r143.clearAnimation();
        removeViewInLayout(r143);
    L137:
        this.f100018d = new WeakReference(r136);
        e(r124, r136);
        return;
    L128:
        if (r142.a(new w91.d.b(r118, f(r136), r133, r124)) == false) goto L130;
        r103 = true;
        goto L130
    L108:
        if ((!Intrinsics.areEqual(r138, this)) == true) goto L111;
        r138 = null;
    L111:
        if (r138 == null) goto L113;
        r138.removeView(r136);
        goto L113
    L101:
        r135 = null;
        goto L102
    L97:
        r133 = null;
    L90:
        r131 = null;
        goto L92
    L77:
        if ((r127 instanceof LayoutParams) == true) goto L80;
        r127 = generateLayoutParams(r127);
        r126.setLayoutParams(r127);
    L61:
        r120 = r120 - 1;
    L62:
        r123 = null;
    L49:
        r116 = false;
    L36:
        r113 = null;
    L138:
        ALogger.e("BaseTabFlipper", "the position is invalidate:" + r106 + " and the item size is " + r105);
        return;
    L157:
        return;
    L22:
        ALogger.d("BaseTabFlipper", "wanna show but position is invalidate：" + r110);
        this.f100015a = 0;
        goto L23
    }

    public BaseTabFlipper(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f100015a = -1;
        this.f100016b = true;
        this.f100017c = new h();
        this.f100022h = LazyKt.lazy(BaseTabFlipper$animController$2.INSTANCE);
        this.f100023i = LazyKt.lazy(new BaseTabFlipper$dataObserver$2(this));
        this.f100016b = r100.obtainStyledAttributes(r101, new int[]{R.attr.flipper_auto_start}).getBoolean(0, true);
    }

    public /* synthetic */ BaseTabFlipper(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
