package com.stepos.aicgroup.internal;

import android.os.Process;
import android.util.Log;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.common.util.TraceIdKeys;
import h0.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SvipBridge {
    public static final SvipBridge INSTANCE = new SvipBridge();

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, Object> f5715a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static final d f5716b = kotlin.b.b(new b());

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Refl {

        /* renamed from: a, reason: collision with root package name */
        public final Constructor<?> f5717a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f5718b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f5719c;

        /* renamed from: d, reason: collision with root package name */
        public final Method f5720d;

        public Refl(Constructor<?> ctor, Method connect, Method request, Method disconnect) {
            g.f(ctor, "ctor");
            g.f(connect, "connect");
            g.f(request, "request");
            g.f(disconnect, "disconnect");
            this.f5717a = ctor;
            this.f5718b = connect;
            this.f5719c = request;
            this.f5720d = disconnect;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Refl copy$default(Refl refl, Constructor constructor, Method method, Method method2, Method method3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                constructor = refl.f5717a;
            }
            if ((i10 & 2) != 0) {
                method = refl.f5718b;
            }
            if ((i10 & 4) != 0) {
                method2 = refl.f5719c;
            }
            if ((i10 & 8) != 0) {
                method3 = refl.f5720d;
            }
            return refl.copy(constructor, method, method2, method3);
        }

        public final Constructor<?> component1() {
            return this.f5717a;
        }

        public final Method component2() {
            return this.f5718b;
        }

        public final Method component3() {
            return this.f5719c;
        }

        public final Method component4() {
            return this.f5720d;
        }

        public final Refl copy(Constructor<?> ctor, Method connect, Method request, Method disconnect) {
            g.f(ctor, "ctor");
            g.f(connect, "connect");
            g.f(request, "request");
            g.f(disconnect, "disconnect");
            return new Refl(ctor, connect, request, disconnect);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Refl)) {
                return false;
            }
            Refl refl = (Refl) obj;
            return g.b(this.f5717a, refl.f5717a) && g.b(this.f5718b, refl.f5718b) && g.b(this.f5719c, refl.f5719c) && g.b(this.f5720d, refl.f5720d);
        }

        public final Method getConnect() {
            return this.f5718b;
        }

        public final Constructor<?> getCtor() {
            return this.f5717a;
        }

        public final Method getDisconnect() {
            return this.f5720d;
        }

        public final Method getRequest() {
            return this.f5719c;
        }

        public int hashCode() {
            return this.f5720d.hashCode() + ((this.f5719c.hashCode() + ((this.f5718b.hashCode() + (this.f5717a.hashCode() * 31)) * 31)) * 31);
        }

        public String toString() {
            return "Refl(ctor=" + this.f5717a + ", connect=" + this.f5718b + ", request=" + this.f5719c + ", disconnect=" + this.f5720d + ")";
        }
    }

    public static /* synthetic */ boolean acquire$default(SvipBridge svipBridge, int i10, String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            str = "";
        }
        if ((i13 & 4) != 0) {
            i11 = 1;
        }
        if ((i13 & 8) != 0) {
            i12 = 5;
        }
        return svipBridge.acquire(i10, str, i11, i12);
    }

    public final boolean acquire(int i10, String requestTag, int i11, int i12) {
        Refl refl;
        boolean zBooleanValue;
        g.f(requestTag, "requestTag");
        if (i10 > 0 && (refl = (Refl) f5716b.getValue()) != null) {
            release(i10);
            try {
                Object objNewInstance = refl.getCtor().newInstance(null);
                try {
                    Object objInvoke = refl.getConnect().invoke(objNewInstance, 0);
                    g.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                } catch (Throwable th) {
                    a0.a.u("connect perfmain threw tid=", i10, ": ", th.getMessage(), "SvipBridge");
                    zBooleanValue = false;
                }
                if (!zBooleanValue) {
                    Log.w("SvipBridge", "connect perfmain failed tid=" + i10 + "（无加速，不影响业务）");
                    return false;
                }
                int i13 = i12 > 0 ? i11 | 640 | (i12 << 24) : i11 | TraceIdKeys.MAX_LENGTH;
                try {
                    refl.getRequest().invoke(objNewInstance, "speedsched", "setSvip", new int[]{Process.myPid(), i10, i13});
                    f5715a.put(Integer.valueOf(i10), objNewInstance);
                    b1.l(16);
                    String string = Integer.toString(i13, 16);
                    g.e(string, "toString(...)");
                    StringBuilder sbE = e.e("setSvip posted tid=", i10, " svip=0x", string, " tag=");
                    sbE.append(requestTag);
                    sbE.append("（生效以 svip_list 为准）");
                    Log.d("SvipBridge", sbE.toString());
                    return true;
                } catch (Throwable th2) {
                    a0.a.u("setSvip threw tid=", i10, ": ", th2.getMessage(), "SvipBridge");
                    try {
                        refl.getDisconnect().invoke(objNewInstance, null);
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable th3) {
                a0.a.A("new PerfMainClient failed: ", th3.getMessage(), "SvipBridge");
                return false;
            }
        }
        return false;
    }

    public final boolean release(int i10) {
        Object objRemove = f5715a.remove(Integer.valueOf(i10));
        if (objRemove == null) {
            return true;
        }
        Refl refl = (Refl) f5716b.getValue();
        if (refl == null) {
            return false;
        }
        try {
            refl.getRequest().invoke(objRemove, "speedsched", "clearSvip", new int[]{Process.myPid(), i10});
        } catch (Throwable th) {
            a0.a.u("clearSvip threw tid=", i10, ": ", th.getMessage(), "SvipBridge");
        }
        try {
            refl.getDisconnect().invoke(objRemove, null);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public final void releaseAll() {
        Set<Integer> setKeySet = f5715a.keySet();
        g.e(setKeySet, "<get-keys>(...)");
        for (Integer num : kotlin.collections.a.O0(setKeySet)) {
            SvipBridge svipBridge = INSTANCE;
            g.c(num);
            svipBridge.release(num.intValue());
        }
    }
}
