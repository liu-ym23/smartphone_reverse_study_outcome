package com.obric.appstore.buss.apps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.bytedanceos.common.toolbox.j;
import com.obric.appstore.util.k;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.Collections;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.y0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\n\u0010\tJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\r\u0010\tJ\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0011J#\u0010\u0017\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u0004\u0018\u00010!2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0004R8\u0010/\u001a&\u0012\f\u0012\n +*\u0004\u0018\u00010\u000e0\u000e +*\u0012\u0012\f\u0012\n +*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010,0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00103\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010101008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u00102R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000205048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u00106R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u000205088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u000205048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00106R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u000205088\u0006¢\u0006\f\n\u0004\b\u0007\u0010:\u001a\u0004\b?\u0010<R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u000205048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00106R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u000205088\u0006¢\u0006\f\n\u0004\b\u000b\u0010:\u001a\u0004\bB\u0010<R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u0002010C8F¢\u0006\u0006\u001a\u0004\b9\u0010D¨\u0006F"}, d2 = {"Lcom/obric/appstore/buss/apps/AppsManager;", "Ljava/util/Observer;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "", "f", "g", "q", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r", "i", "n", "s", "Lcom/obric/appstore/buss/apps/AppCallback;", "callback", "j", "(Lcom/obric/appstore/buss/apps/AppCallback;)V", "l", "Ljava/util/Observable;", "o", "", "arg", "update", "(Ljava/util/Observable;Ljava/lang/Object;)V", "Landroid/content/Context;", "context", "k", "(Landroid/content/Context;)V", "Landroid/content/Intent;", MemorySourceLinkType.INTENT, "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lcom/bytedanceos/common/model/AppInfo;", "appInfo", "c", "(Lcom/bytedanceos/common/model/AppInfo;)V", "", "packageName", "d", "(Ljava/lang/String;)Lcom/bytedanceos/common/model/AppInfo;", "p", "", "kotlin.jvm.PlatformType", "", "b", "Ljava/util/Set;", "callbacks", "Landroidx/lifecycle/MutableLiveData;", "", "Landroidx/lifecycle/MutableLiveData;", "_updateCount", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_cacheInit", "Lkotlinx/coroutines/flow/StateFlow;", "e", "Lkotlinx/coroutines/flow/StateFlow;", "getCacheInit", "()Lkotlinx/coroutines/flow/StateFlow;", "cacheInit", "_isLocalCacheLoaded", "h", "isLocalCacheLoaded", "_isUpdateCacheLoaded", "isUpdateCacheLoaded", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "updateCount", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppsManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppsManager.kt\ncom/obric/appstore/buss/apps/AppsManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,170:1\n1855#2,2:171\n*S KotlinDebug\n*F\n+ 1 AppsManager.kt\ncom/obric/appstore/buss/apps/AppsManager\n*L\n115#1:171,2\n*E\n"})
public final class AppsManager extends BroadcastReceiver implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppsManager f10585a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f10586b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableLiveData f10587c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableStateFlow f10588d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final StateFlow f10589e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MutableStateFlow f10590f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final StateFlow f10591g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MutableStateFlow f10592h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final StateFlow f10593i = null;

    static {
        f10585a = new AppsManager();
        f10586b = Collections.newSetFromMap(new WeakHashMap());
        f10587c = new MutableLiveData(0);
        Boolean r10 = Boolean.FALSE;
        MutableStateFlow r11 = f1.a(r10);
        f10588d = r11;
        f10589e = r11;
        MutableStateFlow r12 = f1.a(r10);
        f10590f = r12;
        f10591g = r12;
        MutableStateFlow r13 = f1.a(r10);
        f10592h = r13;
        f10593i = r13;
    }

    private AppsManager() {
    }

    public static /* synthetic */ void a() {
        m();
    }

    public static final /* synthetic */ MutableLiveData b() {
        return f10587c;
    }

    public static final void m() {
        f10585a.p();
    }

    public final void c(AppInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        CommonCache r11 = BaseApplication.c().b();
        AppInfo r12 = r11.s(r10.appPackageName);
        if (r12 == null) goto L9;
        r10 = r12;
    L9:
        if (r10.default_check != 50) goto L11;
        r11.t0(r10);
    L12:
        DataBaseManager.DownloadInfoTable.removeDownloadTask(s.e(r10));
        r11.l0(r10.appPackageName);
        r11.m0(r10.appPackageName);
        return;
    L11:
        r11.p0(r10);
        goto L12
    }

    public final AppInfo d(String r10) {
        q.g(r10, "packageName");
        if (r10.length() != 0) goto L7;
        return null;
    L7:
        return BaseApplication.c().b().s(r10);
    }

    public final LiveData e() {
        return f10587c;
    }

    public final void f() {
        j.n("AppsManager init start 1.0.3 (100003070, release, 2026-08-27 00:04:46)");
        BaseApplication.c().b().addObserver(this);
        IntentFilter r10 = new IntentFilter();
        r10.addAction("com.bytedanceos.show.tab.bottom.update.count");
        z.a.b(BaseApplication.c()).c(this, r10);
    }

    public final void g() {
        f10588d.setValue(Boolean.TRUE);
        j.n("AppsManager init initFinish");
        BaseApplication r10 = BaseApplication.c();
        q.f(r10, "getContext(...)");
        k(r10);
    }

    public final StateFlow h() {
        return f10591g;
    }

    public final void i() {
        j.n("AppsManager localCacheLoaded");
        f10590f.setValue(Boolean.TRUE);
    }

    public final void j(AppCallback r10) {
        q.g(r10, "callback");
        Set r11 = f10586b;
        q.f(r11, "callbacks");
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (r11.add(r10) == false) goto L9;
        r10.onAppUpdate();     // Catch: Throwable -> L7
    L9:
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L7
        monitor-exit(r11);
    }

    public final void k(Context r10) {
        q.g(r10, "context");
        if (((Boolean) f10588d.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        Intent r11 = new Intent();
        j.n("[AutoUpdate] AppsManager requestUpdate broadcast ACTION_AUTO_SYNC_UPDATE_APPS_APPSTORE");
        r11.setAction("com.bytedanceos.appstore.sync.update.apps");
        r11.setPackage(r10.getPackageName());
        r10.sendBroadcast(r11);
    }

    public final void l(AppCallback r10) {
        q.g(r10, "callback");
        Set r11 = f10586b;
        q.f(r11, "callbacks");
        monitor-enter(r11);
        r11.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void n() {
        j.n("AppsManager updateCacheLoaded");
        f10592h.setValue(Boolean.TRUE);
    }

    public final void o() {
        h.d(y0.f21772a, l0.b(), null, new AppsManager$updateCount$1(null), 2, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11 == null) goto L5;
        String r12 = r11.getAction();
        if (r12 == null) goto L5;
    L6:
        j.n("AppsManager onReceive " + r12);
        if (q.b("com.bytedanceos.show.tab.bottom.update.count", r12) == false) goto L10;
        o();
        return;
    L10:
        return;
    L5:
        r12 = "";
        goto L6
    }

    public final void p() {
        Set r10 = f10586b;
        q.f(r10, "callbacks");
        monitor-enter(r10);
        j.e("AppsManager update " + r10.size());     // Catch: Throwable -> L8
        q.f(r10, "callbacks");     // Catch: Throwable -> L8
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L8
    L6:
        if (r11.hasNext() == false) goto L10;
        ((AppCallback) r11.next()).onAppUpdate();     // Catch: Throwable -> L8
        goto L6
    L10:
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L8
        monitor-exit(r10);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final Object q(Continuation r10) {
        Object r11 = kotlinx.coroutines.flow.c.v(f10588d, new AppsManager$waitCacheInit$2(null), r10);
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r11;
    L6:
        return Unit.f21064a;
    }

    public final Object r(Continuation r10) {
        Object r11 = kotlinx.coroutines.flow.c.v(f10591g, new AppsManager$waitLocalCacheInitialLoad$2(null), r10);
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r11;
    L6:
        return Unit.f21064a;
    }

    public final Object s(Continuation r10) {
        Object r11 = kotlinx.coroutines.flow.c.v(f10593i, new AppsManager$waitUpdateCacheInitialLoad$2(null), r10);
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r11;
    L6:
        return Unit.f21064a;
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        if (q.b(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        p();
        return;
    L5:
        k.f11081a.d().post(new c());
    }
}
