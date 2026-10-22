package com.bytedance.android.livesdk.service;

import com.bytedance.android.live.core.utils.j0;
import com.bytedance.android.live.room.u;
import com.bytedance.android.livesdk.chatroom.record.t;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x;
import com.bytedance.android.livesdk.live.provider.GsonProvider;
import com.bytedance.android.livesdk.pluggableinterface.IShareGuideService;
import com.bytedance.android.livesdk.provideservices.h0;
import com.bytedance.android.livesdk.schema.LiveActionHandlerImpl;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile k f157996b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a<?>> f157997a;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<T> f157998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b.a<T> f157999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f158000c;

        public a() {
            throw null;
        }

        public a(b r100) {
            this.f157998a = r100;
        }
    }

    public interface b<T> {

        public static final class a<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public volatile R f158001a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public volatile boolean f158002b;

            public a() {
            }
        }

        a<T> setup(a<T> r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f158003a;

        public c(k r100) {
            this.f158003a = r100;
        }
    }

    public k() {
        this.f157997a = new ConcurrentHashMap();
        c(Gson.class, new GsonProvider());
        c(u.class, new e3.a());
        c(v.class, new p.a());
        c(x.class, new d0.a());
        c(ILiveActionHandler.class, new LiveActionHandlerImpl.Provider());
        c(i.class, new m.a());
        c(ILiveRecordService.class, new t.a());
        ((m) a(i.class, true)).getClass();
        c(j0.class, new kv2.f.c());
        c(g.class, new com.bytedance.android.livesdk.service.b.a());
        com.bytedance.android.livesdk.service.b r100 = (com.bytedance.android.livesdk.service.b) a(g.class, true);
        r100.f157987a = new c(this);
        r100.b(com.bytedance.android.live.room.t.class, new h0.a());
        r100.b(xo2.a.class, new qt2.h.a());
        r100.b(tm2.a.class, new qt2.c.a());
        r100.b(xo2.e.class, new qt2.d.a());
        r100.b(xo2.g.class, new qt2.g.a());
        r100.b(IShareGuideService.class, new qt2.f.a());
        r100.b(xo2.f.class, new qt2.e.a());
        r100.b(xo2.c.class, new com.bytedance.android.livesdk.gecko.a.C2024a());
    }

    public static <T> T b(Class<T> r100) {
        if (f157996b != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f157996b != null) goto L9;
        f157996b = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return (T) f157996b.a(r100, true);
    }

    public final <T> T a(final Class<T> r100, boolean r101) {
        a r102 = (a) ((ConcurrentHashMap) this.f157997a).get(r100);
        if (r102 != null) goto L7;
        if (r101 == false) goto L6;
        b r103 = new j(r100);
        r102 = new a(r103);
        b.a<T> r104 = new b.a();
        r103.setup(r104);
        r102.f157999b = r104;
        r103.setup(r104);
        r102.f158000c = r104.f158001a;
        ((ConcurrentHashMap) this.f157997a).put(r100, r102);
        goto L7
    L6:
        return null;
    L7:
        b.a<T> r105 = r102.f157999b;
        if (r105 != null) goto L10;
    L11:
        r102.f157999b = r102.f157998a.setup(new b.a());
    L13:
        if (r102.f157999b.f158002b == true) goto L15;
        T r106 = r102.f157999b.f158001a;
        r102.f157999b = null;
        return r106;
    L15:
        if (r102.f158000c != null) goto L27;
        monitor-enter(k.class);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (r102.f158000c != null) goto L21;
        r102.f158000c = r102.f157999b.f158001a;     // Catch: Throwable -> L23
    L21:
        monitor-exit(k.class);     // Catch: Throwable -> L23
    L27:
        return (T) r102.f158000c;
    L10:
        if (r105.f158002b == true) goto L13;
        goto L11
    }

    public final <T> a<T> c(Class<T> r100, b<T> r101) {
        a<T> r102 = new a(r101);
        ((ConcurrentHashMap) this.f157997a).put(r100, r102);
        return r102;
    }
}
