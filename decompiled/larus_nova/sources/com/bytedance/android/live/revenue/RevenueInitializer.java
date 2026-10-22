package com.bytedance.android.live.revenue;

import android.util.Log;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.t1;
import com.bytedance.android.live.gson.BooleanTypeAdapter;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.revenue.platform.container.impl.JsLongTypeAdapter;
import com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.scope.m;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.aweme.debug.tag.global.solid.OfflineEnvTag;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import e33.l;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J,\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0082\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/revenue/RevenueInitializer;", "", "", "doInit", "initializeDeserializer", "R", "", "name", "Lkotlin/Function0;", "block", "measureWithLiveInitAssistant", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ensureInitialized", "", "initialized", "Z", "com/bytedance/android/live/revenue/RevenueInitializer$a", "isCurThreadIniting", "Lcom/bytedance/android/live/revenue/RevenueInitializer$a;", "<init>", "()V", "revenue-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RevenueInitializer {
    public static final RevenueInitializer INSTANCE = null;
    private static volatile boolean initialized;
    private static final a isCurThreadIniting = null;

    public static final class a extends ThreadLocal<Boolean> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        public final Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    private RevenueInitializer() {
    }

    static {
        INSTANCE = new RevenueInitializer();
        isCurThreadIniting = new a();
    }

    private final void doInit() {
        Map<Class, am3.c> r100 = hz.b.f487665a;
        if (k.f(INetworkService.class) == null) goto L5;
        ((INetworkService) k.f(INetworkService.class)).injectProtoDecoders(r100);
    L5:
        cc.a.call("modelx");
        com.bytedance.android.live.revenue.platform.settings.impl.b.a();
        LiveInitAssistant r101 = LiveInitAssistant.INSTANCE;
        r101.markTimeStart("revenue_service_register_duration");
        cc.a.call("scope-modules");
        l[] r102 = t23.a.f544229a;
        m r103 = m.f163449e;
        t23.a r104 = t23.a.f544230b;
        r103.getClass();
        m.e(r104);
        Unit r105 = Unit.INSTANCE;
        r101.markTimeEnd("revenue_service_register_duration");
        Function0<Unit> r106 = t1.f66404a;
        AnonymousClass2 r107 = AnonymousClass2.INSTANCE;
        Intrinsics.checkNotNullParameter(r107, "onViolation");
        t1.f66404a = r107;
        r101.markTimeStart("revenue_global_scope_enter_duration");
        cy0.e.f465759a.getClass();
        com.bytedance.android.scope.l.a(cy0.e.a.f465760a);
        r101.markTimeEnd("revenue_global_scope_enter_duration");
        if (LocalTestManager.c(new Class[]{OfflineEnvTag.class}) == false) goto L8;
        cc.a.call("settings");
        wo3.a.a();
    L8:
        Gson r108 = GsonHelper.get();
        Gson r109 = l97.a.f508113a;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        l97.a.f508113a = r108;
        GsonBuilder r110 = GsonHelper.get().newBuilder();
        r110.registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapter());
        r110.registerTypeAdapter(Boolean.class, new BooleanTypeAdapter());
        r110.registerTypeAdapter(Long.TYPE, new JsLongTypeAdapter());
        r110.registerTypeAdapter(Long.class, new JsLongTypeAdapter());
        Gson r111 = r110.create();
        Gson r112 = uh7.b.f550102a;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        uh7.b.f550102a = r111;
        initializeDeserializer();
    }

    private final void initializeDeserializer() {
        uh7.c r100 = uh7.c.f550106d;
        IDynamicHostNetworkService.b.C1413b r101 = IDynamicHostNetworkService.b.f91485a;
        r100.getClass();
        uh7.c.c(r101);
        uh7.c.c(IDynamicHostNetworkService.b.a.f91486a);
        uh7.c.c(IDynamicHostNetworkService.d.f91487a);
        uh7.c.c(j01.c.f496786g);
        uh7.c.c(lz0.b.f511340a);
        uh7.c.c(com.bytedance.android.live.profit.redpacket.model.e.f88663a);
    }

    public final void ensureInitialized() {
        if (initialized == false) goto L5;
        return;
    L5:
        a r100 = isCurThreadIniting;
        Boolean r101 = r100.get();
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L8;
        return;
    L8:
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L10:
        if (initialized == false) goto L29;
        monitor-exit(this);
        return;
    L29:
        r100.set(r102);     // Catch: Throwable -> L18
        ALogger.i("RevenueInitializer", "run doInit  " + ThreadMethodProxy.currentThread().getName() + tb2.c.DEFAULT_TEXT + Log.getStackTraceString(new Throwable()) + ' ');     // Catch: Throwable -> L18
        INSTANCE.doInit();     // Catch: Throwable -> L18
        initialized = true;     // Catch: Throwable -> L18
        ALogger.i("RevenueInitializer", "init down");     // Catch: Throwable -> L18
        r100.remove();     // Catch: Throwable -> L26
        ALogger.i("RevenueInitializer", "init finally");     // Catch: Throwable -> L26
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        ALogger.i("RevenueInitializer", "init err " + ThreadMethodProxy.currentThread().getName() + tb2.c.DEFAULT_TEXT + Log.getStackTraceString(th) + ' ');     // Catch: Throwable -> L23
        if ((th instanceof Exception) == false) goto L22;
        LiveInitAssistant.INSTANCE.reportError(th, "RevenueInitializer_ERR", new HashMap());     // Catch: Throwable -> L23
    L22:
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        isCurThreadIniting.remove();     // Catch: Throwable -> L26
        ALogger.i("RevenueInitializer", "init finally");     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    }

    private final <R> R measureWithLiveInitAssistant(String r100, Function0<? extends R> r101) {
        LiveInitAssistant r102 = LiveInitAssistant.INSTANCE;
        r102.markTimeStart(r100);
        R r103 = r101.invoke();
        r102.markTimeEnd(r100);
        return r103;
    }
}
