package com.bytedance.android.live.room.incentiveinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.view.InterceptFrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001f B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fRN\u0010\u0016\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000e8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/IncentiveInfoLayout;", "", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "getDisplayView", "Lx81/b;", "Lu81/d;", "h", "Lx81/b;", "getItemHolderPool", "()Lx81/b;", "setItemHolderPool", "(Lx81/b;)V", "itemHolderPool", "Lu81/c;", "value", ce.f26395j, "Lu81/c;", "getAdapter", "()Lu81/c;", "setAdapter", "(Lu81/c;)V", "adapter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LayoutParams", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IncentiveInfoLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f99605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f99606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<View> f99607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u81.f f99608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f99609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f99610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CarouselAnimController f99611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x81.b<u81.d> f99612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f99613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public u81.c<? extends Object, ? extends u81.d> f99614j;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/IncentiveInfoLayout$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/content/Context;", "c", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public u81.d f99615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f99616b;

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

    public static final class b implements com.bytedance.android.live.room.incentiveinfo.datamonitor.d<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IncentiveInfoLayout f99617a;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.d
        public final void onChange() {
            WeakReference<View> r100 = this.f99617a.f99607c;
            if (r100 == null) goto L5;
            View r101 = r100.get();
        L6:
            u81.c<? extends Object, ? extends u81.d> r102 = this.f99617a.getAdapter();
            if ((r102 instanceof u81.c) == true) goto L9;
            r102 = null;
        L9:
            int r103 = 0;
            if (r102 == null) goto L12;
            int r104 = r102.getItemSize();
        L13:
            if (r101 == null) goto L85;
            LayoutParams r105 = x81.a.a(r101);
            if (r105 == null) goto L86;
            Object r106 = r105.f99616b;
            if (r106 != 0) goto L19;
            return;
        L19:
            u81.d r107 = r105.f99615a;
            if (r107 != null) goto L23;
            return;
        L23:
            if (r102 == null) goto L25;
            int r108 = r102.getDataPosition(r106);
        L27:
            if (r108 >= 0) goto L68;
            IncentiveInfoLayout r109 = this.f99617a;
            r109.a();
            r109.f99608d = null;
            if (r104 > 0) goto L58;
            ALogger.d("IncentiveInfoLayout", "carousel stop, item size is 0");
            IncentiveInfoLayout r110 = this.f99617a;
            r110.f99607c = null;
            r110.f99606b = -1;
            Iterator<View> r111 = UtilityKotlinExtentionsKt.g(r110).iterator();
        L32:
            if (r111.hasNext() == false) goto L41;
            r111.next().clearAnimation();     // Catch: Exception -> L36
        L36:
            e = move-exception;
            ALogger.e("IncentiveInfoLayout", e);
            if (v.a() == false) goto L32;
            throw e;
        L41:
            IncentiveInfoLayout r112 = this.f99617a;
            r112.getClass();
            Iterator<View> r113 = UtilityKotlinExtentionsKt.g(r112).iterator();
        L43:
            if (r113.hasNext() == false) goto L57;
            View r114 = r113.next();
            LayoutParams r115 = x81.a.a(r114);
            if (r115 == null) goto L56;
            u81.d r116 = r115.f99615a;
            if (r116 == null) goto L56;
            x81.b<u81.d> r117 = r112.f99612h;
            if (r117 == null) goto L56;
            Intrinsics.checkNotNullParameter(r116, "instance");
            LayoutParams r118 = x81.a.a(r116.a());
            if (r118 == null) goto L53;
            r118.f99615a = null;
            r118.f99616b = null;
        L53:
            int r119 = r117.a(r116.getItemType(), r116.b());
            if (r119 == (-1)) goto L56;
            r117.f562884a[r119] = 0;
        L56:
            r114.clearAnimation();
            goto L43
        L57:
            r112.removeAllViews();
            return;
        L58:
            IncentiveInfoLayout r120 = this.f99617a;
            int r121 = r120.f99606b + 1;
            if (r121 < 0) goto L67;
            u81.c<? extends Object, ? extends u81.d> r122 = r120.getAdapter();
            if (r122 == null) goto L63;
            int r123 = r122.getItemSize();
        L64:
            if (r121 >= r123) goto L67;
            r103 = r121;
            goto L67
        L63:
            r123 = 0;
        L67:
            r120.c(r103, true);
            return;
        L68:
            if (r108 != 0) goto L89;
            if (r104 != 1) goto L90;
            r107.d();
            return;
        L90:
            return;
        L89:
            return;
        L25:
            r108 = -1;
            goto L27
        L86:
            return;
        L85:
            return;
        L12:
            r104 = 0;
            goto L13
        L5:
            r101 = null;
            goto L6
        }

        public b(IncentiveInfoLayout r100) {
            this.f99617a = r100;
        }
    }

    static {
    }

    public IncentiveInfoLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IncentiveInfoLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        u81.f r100 = this.f99608d;
        if (r100 == null) goto L20;
        int r101 = r100.a();
        if (r101 <= 0) goto L11;
        if (r101 != 1) goto L15;
        e r102 = this.f99610f;
        if (r102 == null) goto L15;
        if (r100.b(r102) == true) goto L11;
    L15:
        e r103 = this.f99610f;
        if (r103 == null) goto L18;
        r100.c(r103);
    L19:
        if (r103 == null) goto L20;
        return;
    L18:
        r103 = null;
    L11:
        Disposable r104 = this.f99609e;
        if (r104 == null) goto L14;
        r104.dispose();
    L14:
        this.f99609e = null;
    L20:
        Disposable r105 = this.f99609e;
        if (r105 != null) goto L23;
    L28:
        this.f99609e = null;
        Unit r106 = Unit.INSTANCE;
        return;
    L23:
        if ((true ^ r105.isDisposed()) == true) goto L26;
        r105 = null;
    L26:
        if (r105 == null) goto L28;
        r105.dispose();
        goto L28
    }

    public View getDisplayView() {
        WeakReference<View> r100 = this.f99607c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public u81.c<? extends Object, ? extends u81.d> getAdapter() {
        return this.f99614j;
    }

    public final x81.b<u81.d> getItemHolderPool() {
        return this.f99612h;
    }

    public final boolean b(Object r100) {
        WeakReference<View> r101 = this.f99607c;
        if (r101 == null) goto L13;
        View r102 = r101.get();
        if (r102 == null) goto L13;
        LayoutParams r103 = x81.a.a(r102);
        if (r103 == null) goto L13;
        u81.d r104 = r103.f99615a;
        if (r104 == null) goto L11;
        w81.a r105 = x81.a.c(r104);
    L15:
        return Intrinsics.areEqual(r105, r100);
    L11:
        r105 = null;
    L13:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    public final void d(int r100) {
        ALogger.d("IncentiveInfoLayout", "updateCurItemStatus, position is " + r100);
        u81.c<? extends Object, ? extends u81.d> r101 = getAdapter();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getItemSize() > 0) goto L8;
        return;
    L8:
        w81.a r102 = r101.getData(r100);
        r101.getItemViewType(r100);
        if (b(r102) == true) goto L11;
        return;
    L11:
        this.f99606b = r100;
        WeakReference<View> r103 = this.f99607c;
        if (r103 == null) goto L21;
        View r104 = r103.get();
        if (r104 == null) goto L22;
        LayoutParams r105 = x81.a.a(r104);
        if (r105 == null) goto L23;
        u81.d r106 = r105.f99615a;
        if (r106 == null) goto L24;
        r101.a(r106, r100);
        return;
    L24:
        return;
    L23:
        return;
    L22:
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
    public void setAdapter(u81.c<? extends Object, ? extends u81.d> r100) {
        if ((!Intrinsics.areEqual(this.f99614j, r100)) == false) goto L29;
        u81.c<? extends Object, ? extends u81.d> r101 = this.f99614j;
        if ((r101 instanceof u81.c) == true) goto L7;
        r101 = null;
    L7:
        if (r101 == null) goto L9;
        r101.b(null);
    L9:
        removeAllViews();
        x81.b<u81.d> r102 = this.f99612h;
        if (r102 == null) goto L21;
        int r103 = 0;
    L13:
        if (r103 >= 99) goto L21;
        Pair r104 = r102.f562884a[r103];
        if (r104 == null) goto L20;
        u81.d r105 = (u81.d) r104.getSecond();
        if (r105 == null) goto L19;
        r105.onDestroy();
    L19:
        r102.f562884a[r103] = 0;
    L20:
        r103 = r103 + 1;
    L21:
        a();
        this.f99608d = null;
        this.f99607c = null;
        this.f99606b = -1;
        this.f99614j = r100;
        if (r100 != null) goto L24;
        return;
    L24:
        r100.b(this.f99613i);
        return;
    }

    public final void setItemHolderPool(x81.b<u81.d> r100) {
        this.f99612h = r100;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    public final void c(int r110, boolean r111) {
        u81.c<? extends Object, ? extends u81.d> r100 = getAdapter();
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getItemSize() > 0) goto L8;
        return;
    L8:
        this.f99606b = r110;
        w81.a r101 = r100.getData(r110);
        int r102 = r100.getItemViewType(r110);
        c r103 = null;
        if (r100.getItemSize() <= 1) goto L17;
        if ((r101 instanceof w81.a) == true) goto L13;
        w81.a r104 = null;
    L14:
        if (r104 == null) goto L17;
        r104.f558610b = Boolean.FALSE;
        goto L17
    L13:
        r104 = r101;
    L17:
        if (b(r101) == true) goto L161;
        ALogger.d("IncentiveInfoLayout", "obtain view holder, holder type is " + r102);
        x81.b<u81.d> r105 = this.f99612h;
        if (r105 == null) goto L28;
        if (r101 == null) goto L22;
        Intrinsics.checkNotNullParameter(r101, "$this$incentiveData");
        Integer r112 = r101.f558612d;
    L23:
        int r113 = r105.a(r102, r112);
        if (r113 == (-1)) goto L28;
        Pair r106 = r105.f562884a[r113];
        if (r106 == null) goto L28;
        u81.d r107 = (u81.d) r106.getSecond();
    L30:
        if ((r101 instanceof w81.a) == true) goto L32;
        w81.a r114 = null;
    L33:
        if (r114 == null) goto L35;
        String r115 = r114.f558611c;
    L37:
        if (r107 != null) goto L57;
        if (r101 == null) goto L40;
        Intrinsics.checkNotNullParameter(r101, "$this$incentiveData");
        Integer r108 = r101.f558612d;
    L41:
        r107 = r100.c(this, r102, r108);
        r107.onInit();
        r107.f(r115);
        x81.b<u81.d> r109 = this.f99612h;
        if (r109 == null) goto L59;
        Intrinsics.checkNotNullParameter(r107, "instance");
        int r116 = r107.getItemType();
        if (r109.a(r116, r107.b()) != (-1)) goto L59;
        int r117 = 0;
    L47:
        if (r117 >= 99) goto L59;
        Object[] r118 = r109.f562884a;
        if (r118[r117] == null) goto L50;
        r117 = r117 + 1;
        goto L47
    L50:
        int r119 = r116 * 10;
        Integer r120 = r107.b();
        if (r120 == null) goto L53;
        int r121 = r120.intValue();
    L54:
        r118[r117] = new Pair(Integer.valueOf(r119 + r121), r107);
        goto L59
    L53:
        r121 = 0;
    L59:
        u81.d r122 = r107;
        View r123 = r122.a();
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        if (r124 != null) goto L63;
        r124 = generateDefaultLayoutParams();
        r123.setLayoutParams(r124);
    L66:
        if ((r124 instanceof LayoutParams) == true) goto L68;
        r124 = null;
    L68:
        LayoutParams r125 = (LayoutParams) r124;
        if (r125 == null) goto L71;
        r125.f99616b = r101;
        r125.f99615a = r122;
        ALogger.d("IncentiveInfoLayout", "bind holder itemView's layout params data.the itemView:" + r122.a() + ".the itemData:" + r101 + '.');
    L71:
        WeakReference<View> r126 = this.f99607c;
        if (r126 == null) goto L78;
        View r127 = r126.get();
        if (r127 == null) goto L78;
        LayoutParams r128 = x81.a.a(r127);
        if (r128 == null) goto L78;
        u81.d r129 = r128.f99615a;
    L79:
        View r130 = r122.a();
        ViewParent r131 = r130.getParent();
        if ((r131 instanceof ViewGroup) == true) goto L82;
        r131 = null;
    L82:
        ViewGroup r132 = (ViewGroup) r131;
        if (r132 == null) goto L91;
        if ((!Intrinsics.areEqual(r132, this)) == true) goto L88;
        r132 = null;
    L88:
        if (r132 == null) goto L91;
        r132.removeView(r130);
    L91:
        if (r130.getParent() != null) goto L94;
        addView(r130);
    L98:
        Iterator<View> r133 = UtilityKotlinExtentionsKt.g(this).iterator();
    L100:
        if (r133.hasNext() == false) goto L119;
        View r134 = r133.next();
        if (r129 == null) goto L104;
        View r135 = r129.a();
    L106:
        if ((!Intrinsics.areEqual(r134, r135)) == false) goto L100;
        if ((!Intrinsics.areEqual(r134, r130)) == false) goto L100;
        StringBuilder r136 = new StringBuilder("extra view gone and its data is :");
        ViewGroup.LayoutParams r137 = r134.getLayoutParams();
        if ((r137 instanceof LayoutParams) == true) goto L112;
        r137 = null;
    L112:
        LayoutParams r138 = (LayoutParams) r137;
        if (r138 == null) goto L115;
        Object r139 = r138.f99616b;
    L116:
        r136.append(r139);
        ALogger.d("IncentiveInfoLayout", r136.toString());
        UtilityKotlinExtentionsKt.t(r134);
        InterceptFrameLayout r140 = x81.a.b(r134);
        if (r140 == null) goto L100;
        r140.setIntercept(true);
        goto L100
    L115:
        r139 = null;
        goto L116
    L104:
        r135 = null;
        goto L106
    L119:
        if (r111 == false) goto L135;
        CarouselAnimController r141 = this.f99611g;
        u81.b r142 = new u81.b(r100.getItemSize(), r110, r129, r122);
        r141.getClass();
        Intrinsics.checkNotNullParameter(r142, "params");
        List r143 = (List) r141.f99602a.getValue();
        if ((r143 instanceof Collection) == true) goto L123;
    L125:
        Iterator r144 = r143.iterator();
    L127:
        if (r144.hasNext() == false) goto L131;
        if (((u81.a) r144.next()).a(r142) == false) goto L127;
        boolean r145 = true;
    L133:
        if ((!r145) == false) goto L135;
        boolean r146 = true;
    L136:
        ALogger.d("IncentiveInfoLayout", "showItemWithCarousel, position: " + r110 + ", isShowingWithAnim: " + r146);
        a();
        a();
        this.f99608d = null;
        if (this.f99605a == false) goto L139;
        v81.b r147 = r122.e();
        e r148 = new e(r147, this, r130);
        r147.d(r148);
        Unit r149 = Unit.INSTANCE;
        this.f99610f = r148;
        this.f99608d = r147;
        this.f99609e = r147.f();
    L139:
        r100.a(r122, r110);
        CarouselAnimController r150 = this.f99611g;
        if (r146 == true) goto L143;
        r150 = null;
    L143:
        if (r150 == null) goto L154;
        this.f99607c = new WeakReference(r130);
        this.f99605a = true;
        f r151 = new f(r130, this, r122, r129, r100, r101);
        Intrinsics.checkNotNullParameter(r122, "nextHolder");
        Intrinsics.checkNotNullParameter(r151, "listener");
        com.bytedance.android.live.room.incentiveinfo.b r152 = new com.bytedance.android.live.room.incentiveinfo.b(r129, r151, r122);
        if (r129 == null) goto L147;
        View r153 = r129.a();
    L148:
        View r154 = r122.a();
        if (r129 == null) goto L151;
        r103 = r129.c();
    L151:
        c r155 = r122.c();
        if (r155 == null) goto L177;
        r155.e(r154, r152);
        CarouselAnimController.a(false, r153, r103, r152);
        CarouselAnimController.a(true, r154, r155, r152);
        return;
    L177:
        return;
    L147:
        r153 = null;
        goto L148
    L154:
        if (r129 == null) goto L160;
        View r156 = r129.a();
        if (r156 == null) goto L160;
        UtilityKotlinExtentionsKt.t(r156);
        InterceptFrameLayout r157 = x81.a.b(r156);
        if (r157 == null) goto L160;
        r157.setIntercept(true);
    L160:
        this.f99607c = new WeakReference(r130);
        this.f99605a = true;
        return;
    L131:
        r145 = false;
        goto L133
    L123:
        if (r143.isEmpty() == false) goto L125;
    L135:
        r146 = false;
        goto L136
    L94:
        if (Intrinsics.areEqual(r130.getParent(), this) == false) goto L98;
        UtilityKotlinExtentionsKt.w(r130);
        InterceptFrameLayout r158 = x81.a.b(r130);
        if (r158 == null) goto L98;
        r158.setIntercept(false);
    L78:
        r129 = null;
        goto L79
    L63:
        if ((r124 instanceof LayoutParams) == true) goto L66;
        r124 = generateLayoutParams(r124);
        r123.setLayoutParams(r124);
        goto L66
    L40:
        r108 = null;
        goto L41
    L57:
        if (StringsKt.equals$default(r107.getIconUrl(), r115, false, 2, null) == true) goto L59;
        r107.f(r115);
        goto L59
    L35:
        r115 = null;
        goto L37
    L32:
        r114 = r101;
        goto L33
    L22:
        r112 = null;
    L28:
        r107 = null;
        goto L30
    L161:
        d(r110);
    }

    public IncentiveInfoLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f99606b = -1;
        this.f99611g = new CarouselAnimController();
        this.f99613i = new b(this);
    }

    public /* synthetic */ IncentiveInfoLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
