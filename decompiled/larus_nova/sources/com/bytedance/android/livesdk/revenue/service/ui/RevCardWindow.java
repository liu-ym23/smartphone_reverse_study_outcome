package com.bytedance.android.livesdk.revenue.service.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class RevCardWindow extends v61.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<a> f157478m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CardConstraint f157479n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MsgWindowPosition f157480o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DataCenter f157481p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f157482q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f157483r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public aq2.a f157484s;

    @Override // v61.a
    public final boolean E() {
        aq2.a r100 = this.f157484s;
        if (r100.f15882c == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.f15883d == true) goto L8;
        return false;
    }

    @Override // v61.a
    public final void I() {
        Iterator r100 = ((ArrayList) this.f157478m).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).onCreate();
        goto L4
    }

    @Override // v61.a
    public final void K() {
        Iterator r100 = ((ArrayList) this.f157478m).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).onHide();
        goto L4
    }

    @Override // v61.a
    public final void L() {
        Iterator r100 = ((ArrayList) this.f157478m).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).onShow();
        goto L4
    }

    @Override // v61.c
    public final x61.h<?, ?> content() {
        x61.h.a r100 = x61.h.f562592a;
        Function1<x61.c.a, View> r101 = new AnonymousClass1(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, WidgetCostModule.TYPE_INFLATE);
        return new x61.f(r101);
    }

    @Override // v61.a
    public final void J() {
        super.J();
        Iterator r100 = ((ArrayList) this.f157478m).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).onDestroy();
        goto L4
    L6:
        ((ArrayList) this.f157478m).clear();
    }

    public final Context getContext() {
        return this.f157482q;
    }

    @Override // v61.a, r61.b
    public final DataCenter getDataCenter() {
        return this.f157481p;
    }

    @Override // v61.a, v61.c
    public final MsgWindowPosition getPosition() {
        return this.f157480o;
    }

    @Override // v61.a
    public final CardConstraint y() {
        return this.f157479n;
    }

    @Override // v61.a
    public final void N(View r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
    }

    @Override // v61.a
    public final void O(CardConstraint r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f157479n = r100;
    }

    public RevCardWindow(DataCenter r100, Context r101, int r102, View r103, aq2.a r104) {
        Intrinsics.checkNotNullParameter(r103, "content");
        Intrinsics.checkNotNullParameter(r104, "config");
        super(r100, "revenue_group", r102);
        this.f157481p = r100;
        this.f157482q = r101;
        this.f157483r = r103;
        this.f157484s = r104;
        this.f157478m = new ArrayList();
        aq2.c r105 = this.f157484s.f15880a;
        CardConstraint r106 = new CardConstraint(r105.f15888a, r105.f15889b);
        aq2.a r107 = this.f157484s;
        aq2.b r108 = r107.f15881b;
        r106.f98975b = r108.f15884a;
        r106.f98976c = r108.f15885b;
        r106.f98977d = r108.f15886c;
        r106.f98978e = r108.f15887d;
        Unit r109 = Unit.INSTANCE;
        this.f157479n = r106;
        if (r107.f15882c == true) goto L5;
        MsgWindowPosition r110 = MsgWindowPosition.TOP_RIGHT;
    L6:
        this.f157480o = r110;
        return;
    L5:
        r110 = MsgWindowPosition.BOTTOM_RIGHT;
        goto L6
    }
}
