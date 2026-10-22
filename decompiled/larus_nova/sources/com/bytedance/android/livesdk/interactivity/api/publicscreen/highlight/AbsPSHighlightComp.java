package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.InteractivityPlatfromContextUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class AbsPSHighlightComp implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f133402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyOwner<IPSHighlightCompLifecycle$State> f133403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f133404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f133405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f133406e;

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m(FailReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
    }

    public void n(InterruptReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
    }

    public void o() {
    }

    public void b() {
        InteractivityPlatfromContextUtils.a(this.f133406e, new AbsPSHighlightComp$dismiss$1(this));
    }

    public final k d() {
        com.bytedance.android.livesdk.interactivity.api.h r100 = com.bytedance.android.livesdk.interactivity.api.i.a(MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.f133406e, 0, 2), this.f133406e);
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.j<k> r101 = r100.getHighlightContext();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    public final boolean g() {
        if (this.f133403b.f64752a != IPSHighlightCompLifecycle$State.Destroyed) goto L5;
        return true;
    L5:
        return false;
    }

    public final void q() {
        InteractivityPlatfromContextUtils.a(this.f133406e, new AbsPSHighlightComp$show$1(this));
    }

    public final z51.e<p42.a> f() {
        k r100 = d();
        if (r100 == null) goto L7;
        l r101 = r100.stateCenter();
        if (r101 == null) goto L7;
        z51.e<p42.a> r102 = r101.lifecycle();
    L9:
        if ((r102 instanceof z51.e) == true) goto L12;
        return null;
    L12:
        return r102;
    L7:
        r102 = null;
        goto L9
    }

    public String e() {
        return this.f133404c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.g
    public n getType() {
        return this.f133405d;
    }

    public final <T> T c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) ((Map) this.f133402a.getValue()).get(r100);
        if ((r101 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r101;
    }

    public final void h(IPSHighlightCompLifecycle$State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f133403b.a(r100);
        int r101 = a.f133428a[r100.ordinal()];
        if (r101 != 2) goto L5;
        z51.e<p42.a> r102 = f();
        if (r102 == null) goto L29;
        int r103 = p42.a.f527648c;
        r102.b(p42.a.C7149a.a(this));
    L29:
        j();
        return;
    L5:
        if (r101 != 3) goto L7;
        i();
        z51.e<p42.a> r104 = f();
        if (r104 == null) goto L36;
        int r105 = p42.a.f527648c;
        r104.b(p42.a.C7149a.a(this));
        return;
    L36:
        return;
    L7:
        if (r101 != 4) goto L9;
        o();
        z51.e<p42.a> r106 = f();
        if (r106 == null) goto L34;
        int r107 = p42.a.f527648c;
        r106.b(p42.a.C7149a.a(this));
        return;
    L34:
        return;
    L9:
        if (r101 != 5) goto L11;
        l();
        z51.e<p42.a> r108 = f();
        if (r108 == null) goto L32;
        int r109 = p42.a.f527648c;
        r108.b(p42.a.C7149a.a(this));
        return;
    L32:
        return;
    L11:
        if (r101 != 6) goto L38;
        z51.e<p42.a> r110 = f();
        if (r110 == null) goto L16;
        int r111 = p42.a.f527648c;
        r110.b(p42.a.C7149a.a(this));
    L16:
        k();
        return;
    }

    public final void p(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ((Map) this.f133402a.getValue()).put(r100, r101);
    }

    public AbsPSHighlightComp(String r100, n r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f133404c = r100;
        this.f133405d = r101;
        this.f133406e = r102;
        this.f133402a = LazyKt.lazy(AbsPSHighlightComp$extras$2.INSTANCE);
        this.f133403b = new PropertyOwner(IPSHighlightCompLifecycle$State.Initialized, AbsPSHighlightComp$_lifecycleObserver$1.INSTANCE);
    }
}
