package com.bytedance.android.shopping.anchorv4.ai;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.base.api.ai.FloatChatWindowState;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class t0 implements xe.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<xe.e> f165684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<xe.b> f165685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f165686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f165687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f165688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FloatChatWindowState f165689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MockAIChatWindowState f165690g;

    public static final class a {
    }

    static {
    }

    @Override // xe.d
    public final void K1(List<Pair<String, String>> r100) {
    }

    @Override // xe.d
    public final void B1() {
        s0.a("notifyRealInputReady called");
    }

    @Override // xe.d
    public final void D3() {
        s0.a("collapseWindow called");
        g(MockAIChatWindowState.COLLAPSED);
    }

    @Override // xe.d
    public final int c9() {
        int r100 = com.bytedance.android.shopping.extensions.b.b(64);
        s0.a("getBottomSafeHeight called, height=" + r100);
        return r100;
    }

    public t0() {
        this.f165684a = new LinkedHashSet();
        this.f165685b = new LinkedHashSet();
        this.f165689f = FloatChatWindowState.COLLAPSED;
        this.f165690g = MockAIChatWindowState.COLLAPSED;
    }

    @Override // xe.d
    public final void a(xe.e r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        s0.a("unregisterMessageChangedObserver called, observer=".concat(r100.getClass().getSimpleName()));
        this.f165684a.remove(r100);
    }

    @Override // xe.d
    public final void b(xe.b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        s0.a("unregisterWindowStateObserver called, observer=".concat(r100.getClass().getSimpleName()));
        this.f165685b.remove(r100);
    }

    @Override // xe.d
    public final void c(xe.c r100) {
        StringBuilder r101 = new StringBuilder("setGUIContextProvider called, provider=");
        if (r100 == null) goto L5;
        String r102 = r100.getClass().getSimpleName();
    L6:
        r101.append(r102);
        s0.a(r101.toString());
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // xe.d
    public final void d(xe.e r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        s0.a("registerMessageChangedObserver called, observer=".concat(r100.getClass().getSimpleName()));
        this.f165684a.add(r100);
    }

    @Override // xe.d
    public final void e(j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        s0.a("registerWindowStateObserver called, observer=" + j0.class.getSimpleName() + ", currentState=" + this.f165689f);
        this.f165685b.add(r100);
        r100.a(this.f165689f);
    }

    public final void f(FloatChatWindowState r100) {
        s0.a("dispatchWindowState called, state=" + r100);
        this.f165689f = r100;
        Iterator<T> r101 = this.f165685b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((xe.b) r101.next()).a(r100);
        goto L4
    }

    public final void g(MockAIChatWindowState r100) {
        s0.a("renderMockState called, state=" + r100);
        this.f165690g = r100;
        View r101 = this.f165686c;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        TextView r102 = this.f165688e;
        if (r102 == null) goto L8;
        r102.setVisibility(0);
    L8:
        int r103 = u0.f165694b[r100.ordinal()];
        if (r103 != 1) goto L11;
        View r104 = this.f165687d;
        if (r104 == null) goto L26;
        r104.setVisibility(8);
    L26:
        h("豆包 AI 输入框 Mock（点击展开）", com.bytedance.android.shopping.extensions.b.b(64));
        f(FloatChatWindowState.COLLAPSED);
        return;
    L11:
        if (r103 != 2) goto L13;
        View r105 = this.f165687d;
        if (r105 == null) goto L22;
        r105.setVisibility(0);
    L22:
        h("展开态：点击蒙层折叠，点击输入框进入思考态", com.bytedance.android.shopping.extensions.b.b(220));
        f(FloatChatWindowState.EXPANDED);
        return;
    L13:
        if (r103 != 3) goto L30;
        View r106 = this.f165687d;
        if (r106 == null) goto L18;
        r106.setVisibility(8);
    L18:
        h("思考中... 商详可交互（点击恢复展开）", com.bytedance.android.shopping.extensions.b.b(64));
        f(FloatChatWindowState.COLLAPSED);
        return;
    }

    @Override // xe.d
    public final void sa(long r100) {
        s0.a("setLazyLoadInputEnabled called, enabled=true, timeoutMillis=" + r100);
    }

    @Override // xe.d
    public final void setVisibility(boolean r100) {
        s0.a("setVisibility called, visible=" + r100 + ", needAnim=false");
        View r101 = this.f165686c;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public final void h(String r100, int r101) {
        TextView r102 = this.f165688e;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setText(r100);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L8;
        r103.height = r101;
        Unit r104 = Unit.INSTANCE;
    L9:
        r102.setLayoutParams(r103);
        return;
    L8:
        r103 = null;
        goto L9
    }
}
