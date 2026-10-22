package com.bytedance.android.livesdk.chatroom.dsl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.dsl.util.DSLLog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import is2.k;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.n;
import yt1.r;

/* JADX INFO: loaded from: classes7.dex */
public final class DSLContainerDynamicProxy implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static b f105879f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yt1.k f105880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f105881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xt1.a f105882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<zt1.b<zt1.a>> f105883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t70.a f105884e;

    public static final class a {
    }

    static {
    }

    @Override // is2.k
    public final ViewGroup c() {
        xt1.a r100 = this.f105882c;
        View r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r100.f565066b, "Root") != true) goto L18;
        Lazy r102 = DSLLog.f122804a;
        DSLLog.a("start createDSLRootView " + this.f105882c.f565065a.f569032b.f569037a);
        a(null);
        yt1.k r103 = this.f105880a;
        if (r103 == null) goto L10;
        View r104 = r103.getView();
    L12:
        if ((r104 instanceof ViewGroup) == false) goto L16;
        r101 = r104;
    L16:
        return (ViewGroup) r101;
    L10:
        r104 = null;
        goto L12
    L18:
        return null;
    }

    @Override // is2.k
    public final void release() {
        yt1.k r100 = this.f105880a;
        View r101 = null;
        if (r100 == null) goto L5;
        View r102 = r100.getView();
    L7:
        if ((r102 instanceof ViewGroup) == false) goto L10;
        r101 = r102;
    L10:
        ViewGroup r103 = (ViewGroup) r101;
        if (r103 == null) goto L13;
        d(r103, AnonymousClass1.INSTANCE);
    L13:
        xt1.a r104 = this.f105882c;
        if (r104 != null) goto L16;
    L24:
        yt1.k r105 = this.f105880a;
        if (r105 == null) goto L32;
        r105.release();
        return;
    L32:
        return;
    L16:
        if (r104.f565068d != true) goto L24;
        o r106 = o3.f();
        if (r106 == null) goto L28;
        j<n> r107 = r106.E1();
        if (r107 == null) goto L29;
        n r108 = r107.getValue();
        if (r108 == null) goto L30;
        r108.a(this.f105882c.f565065a.f569032b, this.f105880a);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final Context getContext() {
        return this.f105881b;
    }

    @Override // is2.k
    public final void a(ViewGroup r100) {
        if (this.f105882c != null) goto L5;
        return;
    L5:
        this.f105884e.h(0);
        xt1.a r101 = this.f105882c;
        Context r102 = this.f105881b;
        DSLContainerDynamicProxy$loadDSLDynamicView$1 r103 = new DSLContainerDynamicProxy$loadDSLDynamicView$1(this);
        DSLContainerDynamicProxy$loadDSLDynamicView$2 r104 = new DSLContainerDynamicProxy$loadDSLDynamicView$2(this);
        o r105 = o3.f();
        if (r105 == null) goto L12;
        j<n> r106 = r105.E1();
        if (r106 == null) goto L12;
        n r107 = r106.getValue();
        if (r107 == null) goto L12;
        yt1.o r108 = r101.f565065a;
        String r109 = r101.f565067c;
        com.bytedance.android.livesdk.chatroom.dsl.a r110 = new com.bytedance.android.livesdk.chatroom.dsl.a(this, r103, r104);
        r r111 = new r();
        r111.f569041b = true;
        Unit r112 = Unit.INSTANCE;
        yt1.k r113 = r107.c(r108, r109, r102, r111, r110);
    L13:
        this.f105880a = r113;
        if (r113 == null) goto L20;
        View r114 = r113.getView();
        if (r114 == null) goto L21;
        if (r100 == null) goto L22;
        r100.addView(r114);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L12:
        r113 = null;
        goto L13
    }

    public static void d(ViewGroup r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$visitViewInViewGroup");
        Intrinsics.checkNotNullParameter(r101, "visitor");
        r101.invoke(r100);
        int r102 = r100.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        View r104 = r100.getChildAt(r103);
        if ((r104 instanceof ViewGroup) == false) goto L7;
        d((ViewGroup) r104, r101);
    L8:
        r103 = r103 + 1;
        goto L3
    L7:
        r101.invoke(r100);
        goto L8
    }

    @Override // is2.k
    public final void b(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        xt1.a r102 = this.f105882c;
        if (r102 == null) goto L5;
        String r103 = r102.getType();
    L7:
        if ((!Intrinsics.areEqual(r103, r100)) == false) goto L10;
        return;
    L10:
        if ((r101 instanceof ViewGroup) == true) goto L12;
        return;
    L12:
        Lazy r104 = DSLLog.f122804a;
        DSLLog.a("start replaceComponentView " + r100 + ' ' + this.f105882c.f565065a.f569032b.f569037a);
        a((ViewGroup) r101);
        return;
    L5:
        r103 = null;
        goto L7
    }

    public DSLContainerDynamicProxy(DataCenter r100, Context r101, xt1.a r102, List r103, Tetris r104) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "functionProvider");
        this.f105881b = r101;
        this.f105882c = r102;
        this.f105883d = r103;
        this.f105884e = r104;
    }
}
