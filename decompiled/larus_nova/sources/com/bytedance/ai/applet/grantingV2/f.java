package com.bytedance.ai.applet.grantingV2;

import android.content.Context;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u2.e f34680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<u2.f> f34681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u2.c f34682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f34683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f34684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<Context> f34685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i f34686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public u2.a f34687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppletAuthTaskMonitor.Session f34688i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f34689j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicLong f34690k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f34680a, r101.f34680a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34681b, r101.f34681b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34682c, r101.f34682c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34683d, r101.f34683d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f34684e, r101.f34684e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f34685f, r101.f34685f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f34686g, r101.f34686g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f34687h, r101.f34687h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f34688i, r101.f34688i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f34680a.hashCode() * 31) + this.f34681b.hashCode()) * 31) + this.f34682c.hashCode()) * 31) + this.f34683d.hashCode()) * 31;
        j r101 = this.f34684e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        WeakReference<Context> r105 = this.f34685f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        i r108 = this.f34686g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        u2.a r111 = this.f34687h;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        AppletAuthTaskMonitor.Session r114 = this.f34688i;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "GrantingContext(grantingData=" + this.f34680a + ", sortedGrantingList=" + this.f34681b + ", appletMetaData=" + this.f34682c + ", callback=" + this.f34683d + ", isLastMessage=" + this.f34684e + ", uiContextWk=" + this.f34685f + ", currentStrategy=" + this.f34686g + ", currentCardModel=" + this.f34687h + ", authTaskSession=" + this.f34688i + ')';
    }

    public f(u2.e r100, List r101, u2.c r102, com.bytedance.applet.impl.i r103, com.bytedance.applet.impl.j r104) {
        Intrinsics.checkNotNullParameter(r100, "grantingData");
        Intrinsics.checkNotNullParameter(r101, "sortedGrantingList");
        Intrinsics.checkNotNullParameter(r102, "appletMetaData");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f34680a = r100;
        this.f34681b = r101;
        this.f34682c = r102;
        this.f34683d = r103;
        this.f34684e = r104;
        this.f34685f = null;
        this.f34686g = null;
        this.f34687h = null;
        this.f34688i = null;
        this.f34689j = new AtomicBoolean(false);
        this.f34690k = new AtomicLong(0);
    }
}
