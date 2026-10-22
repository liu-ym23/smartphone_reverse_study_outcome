package com.bytedance.ai.resource;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes43.dex */
public final class d0 implements AIPackage.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f37481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f37482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f37483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f37484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f37485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, AIPackage> f37486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<a> f37487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f37488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f37489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f37490j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutexImpl f37491k;

    public interface a {
        void a(String r100);
    }

    public final List<Widget> f() {
        ArrayList r100 = new ArrayList();
        Iterator<Map.Entry<String, AIPackage>> r101 = this.f37486f.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<String, AIPackage> r102 = r101.next();
        if (r102.getValue().c() != AIPackage.AIPackageType.WIDGET) goto L4;
        AIPackage r103 = r102.getValue();
        if ((r103 instanceof Widget) == false) goto L10;
        Widget r104 = (Widget) r103;
    L11:
        if (r104 == null) goto L4;
        r100.add(r104);
        goto L4
    L10:
        r104 = null;
        goto L11
    L13:
        return r100;
    }

    public final void i() {
        if (this.f37482b == true) goto L13;
        this.f37488h = false;
        if (this.f37483c == true) goto L7;
        AppletResourceTool r100 = AppletResourceTool.f37276a;
        String r101 = this.f37485e;
        r100.getClass();
        AppletResourceTool.a(r101);
    L7:
        WeakReference<a> r102 = this.f37487g;
        if (r102 == null) goto L14;
        a r103 = r102.get();
        if (r103 == null) goto L15;
        r103.a(this.f37481a);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final AIPackage c(AIPackage r100) {
        if (Intrinsics.areEqual(r100.f36895b, this.f37481a) == true) goto L6;
        return null;
    L6:
        Intrinsics.checkNotNullParameter(this, "listener");
        r100.I = new WeakReference(this);
        AIPackage r101 = this.f37486f.putIfAbsent(r100.a(), r100);
        if (r101 != null) goto L9;
        r101 = r100;
    L9:
        r101.f36917x = this.f37485e;
        if (r101.f36918y == AIPackage.PackageStatus.READY) goto L12;
    L14:
        AIPackage.PackageStatus r102 = r100.f36918y;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f36918y = r102;
    L15:
        return r101;
    L12:
        if (r100.f36918y != AIPackage.PackageStatus.BASE_READY) goto L14;
        com.bytedance.ai.utils.g.f37637a.i("AIManager", "ignore package status downgrade from READY to BASE_READY. packageName: " + r100.f36895b + ", appId: " + r100.a());
        goto L15
    }

    public final Applet d(Applet r100) {
        Intrinsics.checkNotNullParameter(r100, "applet");
        AIPackage r101 = c(r100);
        if ((r101 instanceof Applet) == true) goto L7;
        return null;
    L7:
        return (Applet) r101;
    }

    public final Widget e(Widget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        AIPackage r101 = c(r100);
        if ((r101 instanceof Widget) == true) goto L7;
        return null;
    L7:
        return (Widget) r101;
    }

    public final Applet g(String r100) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Applet r101 = null;
        if (this.f37488h == true) goto L5;
        return null;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.f37488h == false) goto L13;
        AIPackage r102 = this.f37486f.get(r100);     // Catch: Throwable -> L15
        if ((r102 instanceof Applet) == false) goto L11;
        r101 = (Applet) r102;     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
        return r101;
    L13:
        monitor-exit(this);
        return null;
    }

    public final Widget h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Widget r101 = null;
        if (this.f37488h == true) goto L5;
        return null;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.f37488h == false) goto L13;
        AIPackage r102 = this.f37486f.get(r100);     // Catch: Throwable -> L15
        if ((r102 instanceof Widget) == false) goto L11;
        r101 = (Widget) r102;     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
        return r101;
    L13:
        monitor-exit(this);
        return null;
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "newSessionId");
        if (this.f37483c == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f37485e, r100) == true) goto L9;
        AppletResourceTool r101 = AppletResourceTool.f37276a;
        String r102 = this.f37485e;
        r101.getClass();
        AppletResourceTool.a(r102);
        com.bytedance.ai.utils.g.f37637a.d("AIManager", "updateSessionId from " + this.f37485e + " to " + r100);
        this.f37485e = r100;
        return;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage.b
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "appId");
        if (Intrinsics.areEqual(r100, this.f37481a) == true) goto L5;
        return;
    L5:
        if (this.f37488h == false) goto L22;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (this.f37488h == false) goto L13;
        this.f37484d.incrementAndGet();     // Catch: Throwable -> L16
        if (this.f37483c == false) goto L12;
        n5.a.f517985a.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r100, "packageName");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r101, "appId");     // Catch: Throwable -> L16
    L12:
        com.bytedance.ai.utils.g.f37637a.d("AIManager", "-------PackageInfoWithSession " + hashCode() + ": " + r100 + " markInUse: " + this.f37484d.get() + ", isClient:" + this.f37483c);     // Catch: Throwable -> L16
    L13:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage.b
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "appId");
        if (Intrinsics.areEqual(r100, this.f37481a) == true) goto L5;
        return;
    L5:
        if (this.f37488h == false) goto L24;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (this.f37488h == false) goto L15;
        int r102 = this.f37484d.decrementAndGet();     // Catch: Throwable -> L18
        if (this.f37483c == false) goto L12;
        n5.a.f517985a.getClass();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r100, "packageName");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r101, "appId");     // Catch: Throwable -> L18
    L12:
        com.bytedance.ai.utils.g.f37637a.d("AIManager", "-------PackageInfoWithSession " + hashCode() + ": " + r100 + " markOutOfUse: " + this.f37484d.get() + ", isClient:" + this.f37483c);     // Catch: Throwable -> L18
        if (r102 != 0) goto L15;
        i();     // Catch: Throwable -> L18
    L15:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    }

    public d0(String r100, boolean r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "packageName");
        this.f37481a = r100;
        this.f37482b = r101;
        this.f37483c = false;
        this.f37484d = new AtomicInteger(0);
        this.f37485e = AppletResourceTool.s(AppletResourceTool.f37276a);
        this.f37486f = new ConcurrentHashMap();
        this.f37488h = true;
        this.f37491k = kotlinx.coroutines.sync.b.a();
    }
}
