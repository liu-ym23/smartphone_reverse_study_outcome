package com.bytedance.android.live.profit.player;

import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f88313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f88314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, c5> f88315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f88316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f88317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f88318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f88319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Throwable, Unit> f88320h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f88314b, r101.f88314b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88315c, r101.f88315c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f88316d, r101.f88316d) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f88317e, r101.f88317e) == 0) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f88318f, r101.f88318f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f88319g, r101.f88319g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f88320h, r101.f88320h) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f88314b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, c5> r104 = this.f88315c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f88316d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + Float.floatToIntBits(this.f88317e)) * 31;
        Function0<Unit> r110 = this.f88318f;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Function0<Unit> r113 = this.f88319g;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Function1<Throwable, Unit> r116 = this.f88320h;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DressPlayData { playId=" + this.f88313a + ", dressId=" + this.f88314b + ", centerY=" + this.f88317e + " }";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, Map<String, ? extends c5> r101, String r102, float r103, Function0<Unit> r104, Function0<Unit> r105, Function1<? super Throwable, Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "dressId");
        Intrinsics.checkNotNullParameter(r102, "userAvatar");
        Intrinsics.checkNotNullParameter(r104, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(r105, "onFinish");
        Intrinsics.checkNotNullParameter(r106, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f88314b = r100;
        this.f88315c = r101;
        this.f88316d = r102;
        this.f88317e = r103;
        this.f88318f = r104;
        this.f88319g = r105;
        this.f88320h = r106;
        StringBuilder r107 = new StringBuilder();
        r107.append(ThreadMethodProxy.currentThread().getId());
        r107.append(':');
        r107.append(System.nanoTime());
        this.f88313a = r107.toString();
    }
}
