package com.obric.aiagent.skill.virt.impl.a.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LxcVirtServiceClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "Virt/Lxc";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22029a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.impl.a.c.b f22030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IBinder f22031c;

    /* JADX INFO: compiled from: LxcVirtServiceClient.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f22032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f22034c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f22032a == r6.f22032a) goto L12;
            return false;
        L12:
            if (o.a(this.f22033b, r6.f22033b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f22034c, r6.f22034c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f22032a) * 31) + this.f22033b.hashCode()) * 31) + this.f22034c.hashCode();
        }

        public String toString() {
            return "CommandResult(exitCode=" + this.f22032a + ", stdout=" + this.f22033b + ", stderr=" + this.f22034c + ')';
        }

        public a(int r2, String r3, String r4) {
            o.e(r3, "stdout");
            o.e(r4, "stderr");
            this.f22032a = r2;
            this.f22033b = r3;
            this.f22034c = r4;
        }

        public final int a() {
            return this.f22032a;
        }

        public final String b() {
            return this.f22033b;
        }

        public final String c() {
            return this.f22034c;
        }

        public final String d() {
            return "exit=" + this.f22032a + " stdout(" + this.f22033b.length() + ")=[" + this.f22033b + "] stderr(" + this.f22034c.length() + ")=[" + this.f22034c + ']';
        }
    }

    /* JADX INFO: compiled from: LxcVirtServiceClient.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.c.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LxcVirtServiceClient.kt */
    public static final class C0472c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f22035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ParcelFileDescriptor f22036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ParcelFileDescriptor f22037c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ParcelFileDescriptor f22038d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0472c.class) == true) goto L8;
            return false;
        L8:
            C0472c r6 = (C0472c) ZeusTransformUtils.preCheckCast(r5, C0472c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f22035a, r6.f22035a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f22036b, r6.f22036b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f22037c, r6.f22037c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f22038d, r6.f22038d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = this.f22035a.hashCode() * 31;
            ParcelFileDescriptor r1 = this.f22036b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            ParcelFileDescriptor r5 = this.f22037c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            ParcelFileDescriptor r8 = this.f22038d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "StreamingSessionInfo(sessionId=" + this.f22035a + ", stdout=" + this.f22036b + ", stderr=" + this.f22037c + ", proxyFd=" + this.f22038d + ')';
        }

        public C0472c(String r2, ParcelFileDescriptor r3, ParcelFileDescriptor r4, ParcelFileDescriptor r5) {
            o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            this.f22035a = r2;
            this.f22036b = r3;
            this.f22037c = r4;
            this.f22038d = r5;
        }

        public final String a() {
            return this.f22035a;
        }

        public final ParcelFileDescriptor b() {
            return this.f22036b;
        }

        public final ParcelFileDescriptor c() {
            return this.f22037c;
        }

        public final ParcelFileDescriptor d() {
            return this.f22038d;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f22029a = new b(null);
    }

    public static /* synthetic */ x lambda$ElRbpimbN3uHAkzCAe_V6qVGSxM(c r0, String r1, long r2, Parcel r4) {
        return a(r0, r1, r2, r4);
    }

    public c(com.obric.aiagent.skill.virt.impl.a.c.b r3) {
        o.e(r3, "config");
        this.f22030b = r3;
        this.f22031c = (IBinder) ZeusTransformUtils.preCheckCast(new Binder(), IBinder.class, "com.obric.aiagent.plugin");
    }

    public final boolean a() {
        if (d() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        IBinder r2 = d();
        if (r2 != null) goto L32;
        return false;
    L32:
        n.a r4 = n.f38560a;     // Catch: Throwable -> L19
        c r7 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        Parcel r5 = Parcel.obtain();     // Catch: Throwable -> L19
        o.c(r5, "obtain(...)");     // Catch: Throwable -> L19
        Parcel r6 = Parcel.obtain();     // Catch: Throwable -> L19
        o.c(r6, "obtain(...)");     // Catch: Throwable -> L19
        r5.writeInterfaceToken(r7.f22030b.c());     // Catch: Throwable -> L16
        if (r2.transact(13, r5, r6, 0) == false) goto L15;
        r6.readException();     // Catch: Throwable -> L16
        if (r6.readInt() == 0) goto L11;
        boolean r8 = true;
    L12:
        r5.recycle();     // Catch: Throwable -> L19
        r6.recycle();     // Catch: Throwable -> L19
        Object r9 = n.f(Boolean.valueOf(r8));     // Catch: Throwable -> L19
    L21:
        Throwable r0 = n.c(r9);
        if (r0 == null) goto L28;
        if (IAppContext.Companion.isDebug() == false) goto L26;
        ILogDepend.Companion.w(TAG, "isAsyncGatewaySupported failed: " + r0.getClass().getSimpleName(), r0);
        goto L28
    L26:
        ILogDepend.Companion.w(TAG, "isAsyncGatewaySupported failed");
    L28:
        if (n.b(r9) == false) goto L31;
        r9 = false;
    L31:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L11:
        r8 = false;
        goto L12
    L15:
        throw new IllegalStateException("LXC gateway capability transaction failed".toString());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r5.recycle();     // Catch: Throwable -> L19
        r6.recycle();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        n.a r1 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L21
    }

    public final a a(final String r7, final long r8) {
        o.e(r7, "command");
        IBinder r0 = d();
        if (r0 == null) goto L14;
        if (IAppContext.Companion.isDebug() == false) goto L7;
        ILogDepend.Companion.d(TAG, "executeSync >> container=" + this.f22030b.d() + " cmd=" + r7);
    L8:
        a r6 = a(r0, 5, new $$Lambda$c$ElRbpimbN3uHAkzCAe_V6qVGSxM(this, r7, r8));
        if (IAppContext.Companion.isDebug() == false) goto L11;
        ILogDepend.Companion.d(TAG, "executeSync << " + r6.d() + " cmd=" + r7);
    L12:
        return r6;
    L11:
        ILogDepend.Companion.d(TAG, "executeSync finish exitCode=" + r6.a());
        goto L12
    L7:
        ILogDepend.Companion.d(TAG, "executeSync start");
        goto L8
    L14:
        throw new IllegalStateException("VirtService is not available");
    }

    private static final x a(c r2, String r3, long r4, Parcel r6) {
        o.e(r6, "data");
        r6.writeString(r2.f22030b.d());
        r6.writeStringArray(new String[]{r3});
        r6.writeInt(r2.a(r4));
        r6.writeStrongBinder(r2.f22031c);
        r6.writeInt(r2.f22030b.g());
        return x.f38692a;
    }

    public final C0472c a(String r8, Map<String, String> r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "command");
        o.e(r10, "env");
        IBinder r0 = d();
        if (r0 != null) goto L7;
        return null;
    L7:
        if (IAppContext.Companion.isDebug() == false) goto L9;
        ILogDepend.Companion.i(TAG, "execAsync >> container=" + this.f22030b.d() + " envKeys=" + p.m((Iterable) ZeusTransformUtils.preCheckCast(r10.keySet(), Iterable.class, "com.obric.aiagent.plugin")));
    L11:
        return a(r0, r8, a(r10));
    L9:
        ILogDepend.Companion.i(TAG, "execAsync start");
        goto L11
    }

    private final C0472c a(IBinder r11, String r12, String[] r13) {
        IBinder r14 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r11, IBinder.class, "com.obric.aiagent.plugin");
        Object r2 = null;
        n.a r4 = n.f38560a;     // Catch: Throwable -> L49
        c r5 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
        Parcel r6 = Parcel.obtain();     // Catch: Throwable -> L49
        o.c(r6, "obtain(...)");     // Catch: Throwable -> L49
        Parcel r7 = Parcel.obtain();     // Catch: Throwable -> L49
        o.c(r7, "obtain(...)");     // Catch: Throwable -> L49
        r6.writeInterfaceToken(r5.f22030b.c());     // Catch: Throwable -> L42
        r6.writeString(r5.f22030b.d());     // Catch: Throwable -> L42
        boolean r0 = true;
        r6.writeStringArray(new String[]{r12});     // Catch: Throwable -> L42
        r6.writeInt(r5.f22030b.h());     // Catch: Throwable -> L42
        r6.writeStrongBinder(r5.f22031c);     // Catch: Throwable -> L42
        r6.writeInt(r5.f22030b.g());     // Catch: Throwable -> L42
        r6.writeStringArray(r13);     // Catch: Throwable -> L42
        if (r14.transact(12, r6, r7, 0) == false) goto L41;
        r7.readException();     // Catch: Throwable -> L42
        if (r7.readInt() != 0) goto L9;
        C0472c r1 = null;
    L32:
        r6.recycle();     // Catch: Throwable -> L49
        r7.recycle();     // Catch: Throwable -> L49
        Object r15 = n.f(r1);     // Catch: Throwable -> L49
        ParcelFileDescriptor r16 = null;
        ParcelFileDescriptor r17 = null;
        ParcelFileDescriptor r8 = null;
    L52:
        Throwable r3 = n.c(r15);
        if (r3 == null) goto L59;
        if (IAppContext.Companion.isDebug() == false) goto L57;
        ILogDepend.Companion.e(TAG, "execAsync failed: " + r3.getClass().getSimpleName(), r3);
        goto L59
    L57:
        ILogDepend.Companion.e(TAG, "execAsync failed");
    L59:
        if (n.b(r15) == true) goto L62;
        r2 = r15;
    L62:
        C0472c r18 = (C0472c) ZeusTransformUtils.preCheckCast(r2, C0472c.class, "com.obric.aiagent.plugin");
        a(r16);
        a(r17);
        a(r8);
        return (C0472c) ZeusTransformUtils.preCheckCast(r2, C0472c.class, "com.obric.aiagent.plugin");
    L9:
        String r19 = r7.readString();     // Catch: Throwable -> L42
        if (r19 != null) goto L12;
        r19 = "";
    L12:
        r16 = r5.b(r7);     // Catch: Throwable -> L42
        r17 = r5.b(r7);     // Catch: Throwable -> L38
        r8 = r5.b(r7);     // Catch: Throwable -> L36
        StringBuilder r9 = new StringBuilder().append("hasStdout=");     // Catch: Throwable -> L34
        if (r16 == null) goto L18;
        boolean r10 = true;
    L19:
        StringBuilder r20 = r9.append(r10).append(" hasStderr=");     // Catch: Throwable -> L34
        if (r17 == null) goto L22;
        boolean r21 = true;
    L23:
        StringBuilder r22 = r20.append(r21).append(" hasProxyFd=");     // Catch: Throwable -> L34
        if (r8 != null) goto L27;
        r0 = false;
    L27:
        String r23 = r22.append(r0).toString();     // Catch: Throwable -> L34
        if (IAppContext.Companion.isDebug() == false) goto L30;
        ILogDepend.Companion.i(TAG, "execAsync << sessionId=" + r19 + ' ' + r23);     // Catch: Throwable -> L34
    L31:
        r1 = new C0472c(r19, r16, r17, r8);     // Catch: Throwable -> L34
        goto L32
    L30:
        ILogDepend.Companion.i(TAG, "execAsync finish " + r23);     // Catch: Throwable -> L34
        goto L31
    L22:
        r21 = false;
        goto L23
    L18:
        r10 = false;
    L34:
        th = th;
    L71:
        r6.recycle();     // Catch: Throwable -> L47
        r7.recycle();     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L47:
        th = th;
    L51:
        n.a r24 = n.f38560a;
        r15 = n.f(d.o.a(th));
    L36:
        th = th;
        r8 = null;
    L38:
        th = th;
        r17 = null;
    L44:
        r8 = r17;
        goto L71
    L41:
        throw new IllegalStateException("LXC WithEnv streaming transaction failed".toString());     // Catch: Throwable -> L42
    L42:
        th = th;
        r16 = null;
        r17 = null;
    L49:
        th = th;
        r16 = null;
        r17 = null;
        r8 = null;
        goto L51
    }

    public final a a(String r8) {
        o.e(r8, ObricMemoryConstants.KEY_SESSION_ID);
        IBinder r2 = d();
        if (r2 == null) goto L5;
        n.a r5 = n.f38560a;     // Catch: Throwable -> L12
        c r7 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Parcel r6 = Parcel.obtain();     // Catch: Throwable -> L12
        o.c(r6, "obtain(...)");     // Catch: Throwable -> L12
        Parcel r9 = Parcel.obtain();     // Catch: Throwable -> L12
        o.c(r9, "obtain(...)");     // Catch: Throwable -> L12
        r6.writeInterfaceToken(r7.f22030b.c());     // Catch: Throwable -> L9
        r6.writeString(r8);     // Catch: Throwable -> L9
        r2.transact(7, r6, r9, 0);     // Catch: Throwable -> L9
        r9.readException();     // Catch: Throwable -> L9
        a r10 = r7.a(r9);     // Catch: Throwable -> L9
        r6.recycle();     // Catch: Throwable -> L12
        r9.recycle();     // Catch: Throwable -> L12
        Object r11 = n.f(r10);     // Catch: Throwable -> L12
    L15:
        if (n.c(r11) == null) goto L19;
        r11 = new a(-1, "", "shell execution failed");
    L19:
        return (a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.aiagent.plugin");
    L9:
        th = move-exception;
        r6.recycle();     // Catch: Throwable -> L12
        r9.recycle();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        n.a r12 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L15
    L5:
        return new a(-1, "", "VirtService not found");
    }

    public final Object c() {
        IBinder r1 = d();
        if (r1 != null) goto L17;
        n.a r4 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("VirtService not found"), Throwable.class, "com.obric.aiagent.plugin")));
    L17:
        n.a r3 = n.f38560a;     // Catch: Throwable -> L12
        c r5 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Parcel r2 = Parcel.obtain();     // Catch: Throwable -> L12
        o.c(r2, "obtain(...)");     // Catch: Throwable -> L12
        Parcel r6 = Parcel.obtain();     // Catch: Throwable -> L12
        o.c(r6, "obtain(...)");     // Catch: Throwable -> L12
        r2.writeInterfaceToken(r5.f22030b.c());     // Catch: Throwable -> L9
        r2.writeString(r5.f22030b.d());     // Catch: Throwable -> L9
        r1.transact(3, r2, r6, 0);     // Catch: Throwable -> L9
        r6.readException();     // Catch: Throwable -> L9
        r2.recycle();     // Catch: Throwable -> L12
        r6.recycle();     // Catch: Throwable -> L12
        return n.f(x.f38692a);
    L9:
        th = move-exception;
        r2.recycle();     // Catch: Throwable -> L12
        r6.recycle();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        n.a r0 = n.f38560a;
        return n.f(d.o.a(th));
    }

    private final a a(IBinder r5, int r6, d.h.a.b<? super Parcel, x> r7) {
        IBinder r8 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L14
        c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Parcel r2 = Parcel.obtain();     // Catch: Throwable -> L14
        o.c(r2, "obtain(...)");     // Catch: Throwable -> L14
        Parcel r3 = Parcel.obtain();     // Catch: Throwable -> L14
        o.c(r3, "obtain(...)");     // Catch: Throwable -> L14
        r2.writeInterfaceToken(r4.f22030b.c());     // Catch: Throwable -> L11
        r9.invoke(r2);     // Catch: Throwable -> L11
        if (r8.transact(r6, r2, r3, 0) == false) goto L10;
        r3.readException();     // Catch: Throwable -> L11
        a r10 = r4.a(r3);     // Catch: Throwable -> L11
        r2.recycle();     // Catch: Throwable -> L14
        r3.recycle();     // Catch: Throwable -> L14
        Object r11 = n.f(r10);     // Catch: Throwable -> L14
    L16:
        Throwable r12 = n.c(r11);
        if (r12 != null) goto L19;
    L22:
        d.o.a(r11);
        return (a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.aiagent.plugin");
    L19:
        if (IAppContext.Companion.isDebug() == false) goto L21;
        ILogDepend.Companion.e(TAG, "executeSync failed: " + r12.getClass().getSimpleName(), r12);
        goto L22
    L21:
        ILogDepend.Companion.e(TAG, "executeSync failed");
        goto L22
    L10:
        throw new IllegalStateException("LXC sync transaction failed".toString());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r2.recycle();     // Catch: Throwable -> L14
        r3.recycle();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        n.a r13 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L16
    }

    private final a a(Parcel r4) {
        if (r4.readInt() == 0) goto L5;
        boolean r3 = true;
    L6:
        String r0 = "";
        if (r3 == false) goto L9;
        int r1 = r4.readInt();
        String r2 = r4.readString();
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        String r5 = r4.readString();
        if (r5 == null) goto L18;
        r0 = r5;
    L18:
        return new a(r1, r2, r0);
    L9:
        return new a(-1, "", "No result returned");
    L5:
        r3 = false;
        goto L6
    }

    private final IBinder d() {
        Object r1 = null;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L9
        Object r8 = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.aiagent.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin")).f22030b.b()});     // Catch: Throwable -> L9
        if (ZeusTransformUtils.instanceOf(r8, IBinder.class) == false) goto L6;
        IBinder r9 = (IBinder) ZeusTransformUtils.preCheckCast(r8, IBinder.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
    L7:
        Object r10 = n.f(r9);     // Catch: Throwable -> L9
    L12:
        if (n.b(r10) == true) goto L16;
        r1 = r10;
    L16:
        return (IBinder) ZeusTransformUtils.preCheckCast(r1, IBinder.class, "com.obric.aiagent.plugin");
    L6:
        r9 = null;
    L9:
        th = move-exception;
        n.a r3 = n.f38560a;
        r10 = n.f(d.o.a(th));
        goto L12
    }

    private final String[] a(Map<String, String> r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(p.a((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin")).entrySet(), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r4, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r6.add(((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin")) + '=' + ((String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L4
    L7:
        return (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
    }

    private final int a(long r5) {
        return (int) d.l.n.a(((r5 + 1000) - 1) / 1000, 1);
    }

    private final ParcelFileDescriptor b(Parcel r2) {
        if (r2.dataAvail() > 0) goto L7;
        return null;
    L7:
        return (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r2.readParcelable(ParcelFileDescriptor.class.getClassLoader(), ParcelFileDescriptor.class), ParcelFileDescriptor.class, "com.obric.aiagent.plugin");
    }

    private final void a(ParcelFileDescriptor r1) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L8
        if (r1 == null) goto L5;
        r1.close();     // Catch: Throwable -> L8
        x r2 = x.f38692a;     // Catch: Throwable -> L8
    L6:
        n.f(r2);     // Catch: Throwable -> L8
        return;
    L5:
        r2 = null;
    L8:
        th = move-exception;
        n.a r3 = n.f38560a;
        n.f(d.o.a(th));
    }
}
