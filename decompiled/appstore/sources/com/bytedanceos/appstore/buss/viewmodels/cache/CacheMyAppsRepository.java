package com.bytedanceos.appstore.buss.viewmodels.cache;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.network.HttpResultHead;
import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.appstore.buss.utilities.d;
import com.bytedanceos.appstore.buss.utilities.j;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.b;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.y0;

/* JADX INFO: loaded from: classes2.dex */
public final class CacheMyAppsRepository extends BaseRepository {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f8997f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f8998g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Job f8999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Job f9000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f9001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f9002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9003e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final CacheMyAppsRepository a() {
            return (CacheMyAppsRepository) CacheMyAppsRepository.f().getValue();
        }

        public a() {
        }
    }

    static {
        f8997f = new a(null);
        f8998g = b.b(CacheMyAppsRepository$Companion$instance$2.INSTANCE);
    }

    public CacheMyAppsRepository() {
        this.f9001c = new MutableLiveData();
        this.f9002d = b.b(CacheMyAppsRepository$mapData$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy f() {
        return f8998g;
    }

    public static final /* synthetic */ ConcurrentHashMap g(CacheMyAppsRepository r10) {
        return r10.j();
    }

    public static final /* synthetic */ Object h(CacheMyAppsRepository r10, Function1 r11, Continuation r12) {
        return r10.e(r11, r12);
    }

    public static final /* synthetic */ void i(CacheMyAppsRepository r10, long r11) {
        r10.f9003e = r11;
    }

    public static /* synthetic */ void o(CacheMyAppsRepository r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = false;
    L5:
        r10.n(r11);
    }

    public final ConcurrentHashMap j() {
        return (ConcurrentHashMap) this.f9002d.getValue();
    }

    public final MutableLiveData k() {
        return this.f9001c;
    }

    public final synchronized void l() {
        monitor-enter(this);
        j().clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void m(List r10) {
        monitor-enter(this);
        q.g(r10, ServerElements.LIST);     // Catch: Throwable -> L10
        if (r10.isEmpty() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        j.f8856a.a(d.a());     // Catch: Throwable -> L10
        Job r11 = this.f9000b;     // Catch: Throwable -> L10
        if (r11 == null) goto L12;
        Job.a.b(r11, null, 1, null);     // Catch: Throwable -> L10
    L12:
        this.f9000b = h.d(y0.f21772a, l0.c(), null, new CacheMyAppsRepository$removeMyApps$1(r10, this, null), 2, null);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void n(boolean r10) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if ((System.currentTimeMillis() - this.f9003e) > 300000) goto L14;
        if (r10 == true) goto L14;
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L11
        r11.addAll(j().values());     // Catch: Throwable -> L11
        List r12 = CommonUtil.f8830a.f(r11);     // Catch: Throwable -> L11
        LinkedHashMap r13 = new LinkedHashMap();     // Catch: Throwable -> L11
        Iterator r14 = r12.iterator();     // Catch: Throwable -> L11
    L9:
        if (r14.hasNext() == false) goto L13;
        CommonAppEntity r15 = (CommonAppEntity) r14.next();     // Catch: Throwable -> L11
        String r16 = r15.getPkg();     // Catch: Throwable -> L11
        q.f(r16, "getPkg(...)");     // Catch: Throwable -> L11
        r13.put(r16, r15);     // Catch: Throwable -> L11
        goto L9
    L13:
        j().clear();     // Catch: Throwable -> L11
        j().putAll(r13);     // Catch: Throwable -> L11
        this.f9001c.p(new com.bytedanceos.appstore.buss.network.h.c(new HttpResultHead(0, "本地数据", null), j(), "本地数据"));     // Catch: Throwable -> L11
    L18:
        monitor-exit(this);
        return;
    L14:
        Job r17 = this.f8999a;     // Catch: Throwable -> L11
        if (r17 == null) goto L17;
        Job.a.b(r17, null, 1, null);     // Catch: Throwable -> L11
    L17:
        this.f8999a = h.d(y0.f21772a, l0.c(), null, new CacheMyAppsRepository$updateMyApps$1(this, null), 2, null);     // Catch: Throwable -> L11
        goto L18
    }
}
