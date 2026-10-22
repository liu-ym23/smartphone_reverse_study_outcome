package androidx.room.coroutines;

import Y8.t;
import Z8.C1165m;
import Z8.C1172u;
import Z8.F;
import c1.h;
import com.autonavi.aps.amapapi.config.Const;
import eb.g;
import eb.j;
import i1.InterfaceC4160b;
import io.ktor.http.ContentDisposition;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0004H\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\f2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b$\u0010 R\u0018\u0010(\u001a\u00060%j\u0002`&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010'R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001eR\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010+R\u001c\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u000e058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Landroidx/room/coroutines/Pool;", "", "", "capacity", "Lkotlin/Function0;", "Li1/b;", "connectionFactory", "preparedStatementCacheSize", "<init>", "(ILp9/a;I)V", "Lkotlin/time/a;", "timeout", "LY8/t;", "onTimeout", "Lc1/h;", Const.INTENT_KEY_PKGNAME, "(JLp9/a;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "connection", "e", "(Lc1/h;)V", "c", "()V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", Const.INTENT_KEY_UMID, "(Ljava/lang/StringBuilder;)V", "f", "I", "getCapacity", "()I", "Lp9/a;", "getConnectionFactory", "()Lp9/a;", "getPreparedStatementCacheSize", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", ContentDisposition.Parameters.Size, "", "Z", "isClosed", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "[Lc1/h;", "connections", "Leb/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Leb/g;", "connectionPermits", "LZ8/m;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LZ8/m;", "availableConnections", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Pool {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int capacity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<InterfaceC4160b> connectionFactory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int preparedStatementCacheSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final ReentrantLock lock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int size;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean isClosed;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final h[] connections;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final g connectionPermits;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final C1165m<h> availableConnections;

    /* JADX WARN: Multi-variable type inference failed */
    public Pool(int i10, InterfaceC5063a<? extends InterfaceC4160b> connectionFactory, int i11) {
        p.i(connectionFactory, "connectionFactory");
        this.capacity = i10;
        this.connectionFactory = connectionFactory;
        this.preparedStatementCacheSize = i11;
        this.lock = new ReentrantLock();
        this.connections = new h[i10];
        this.connectionPermits = j.b(i10, 0, 2, null);
        this.availableConnections = new C1165m<>(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(e9.InterfaceC4014c<? super c1.h> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.room.coroutines.Pool$acquire$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.room.coroutines.Pool$acquire$1 r0 = (androidx.room.coroutines.Pool$acquire$1) r0
            int r1 = r0.f14739c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14739c = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquire$1 r0 = new androidx.room.coroutines.Pool$acquire$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f14737a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f14739c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            eb.g r5 = r4.connectionPermits
            r0.f14739c = r3
            java.lang.Object r5 = r5.c(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.util.concurrent.locks.ReentrantLock r5 = r4.lock     // Catch: java.lang.Throwable -> L62
            r5.lock()     // Catch: java.lang.Throwable -> L62
            boolean r0 = r4.isClosed     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L64
            Z8.m<c1.h> r0 = r4.availableConnections     // Catch: java.lang.Throwable -> L54
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L54
            if (r0 == 0) goto L56
            r4.f()     // Catch: java.lang.Throwable -> L54
            goto L56
        L54:
            r0 = move-exception
            goto L71
        L56:
            Z8.m<c1.h> r0 = r4.availableConnections     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.removeLast()     // Catch: java.lang.Throwable -> L54
            c1.h r0 = (c1.h) r0     // Catch: java.lang.Throwable -> L54
            r5.unlock()     // Catch: java.lang.Throwable -> L62
            return r0
        L62:
            r5 = move-exception
            goto L75
        L64:
            java.lang.String r0 = "Connection pool is closed"
            r1 = 21
            i1.C4159a.b(r1, r0)     // Catch: java.lang.Throwable -> L54
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            throw r0     // Catch: java.lang.Throwable -> L54
        L71:
            r5.unlock()     // Catch: java.lang.Throwable -> L62
            throw r0     // Catch: java.lang.Throwable -> L62
        L75:
            eb.g r4 = r4.connectionPermits
            r4.release()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.a(e9.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:45|28|(1:(1:38)(2:34|(1:36)))(1:30)|37|19|43|20|(1:22)(10:23|24|45|28|(0)(0)|37|19|43|20|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r11 = r11;
        r10 = r10;
        r2 = r0;
        r0 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f A[Catch: all -> 0x0073, TryCatch #1 {all -> 0x0073, blocks: (B:28:0x006b, B:30:0x006f, B:34:0x0077, B:38:0x007e), top: B:45:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005a -> B:24:0x005c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r8, p9.InterfaceC5063a<Y8.t> r10, e9.InterfaceC4014c<? super c1.h> r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof androidx.room.coroutines.Pool$acquireWithTimeout$1
            if (r0 == 0) goto L13
            r0 = r11
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = (androidx.room.coroutines.Pool$acquireWithTimeout$1) r0
            int r1 = r0.f14745f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14745f = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = new androidx.room.coroutines.Pool$acquireWithTimeout$1
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.f14743d
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f14745f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            long r8 = r0.f14740a
            java.lang.Object r10 = r0.f14742c
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref$ObjectRef) r10
            java.lang.Object r2 = r0.f14741b
            p9.a r2 = (p9.InterfaceC5063a) r2
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L34
            goto L5c
        L34:
            r11 = move-exception
            goto L66
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            kotlin.C4849c.b(r11)
        L41:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            androidx.room.coroutines.Pool$acquireWithTimeout$2 r2 = new androidx.room.coroutines.Pool$acquireWithTimeout$2     // Catch: java.lang.Throwable -> L61
            r2.<init>(r11, r7, r4)     // Catch: java.lang.Throwable -> L61
            r0.f14741b = r10     // Catch: java.lang.Throwable -> L61
            r0.f14742c = r11     // Catch: java.lang.Throwable -> L61
            r0.f14740a = r8     // Catch: java.lang.Throwable -> L61
            r0.f14745f = r3     // Catch: java.lang.Throwable -> L61
            java.lang.Object r2 = kotlinx.coroutines.TimeoutKt.d(r8, r2, r0)     // Catch: java.lang.Throwable -> L61
            if (r2 != r1) goto L5a
            return r1
        L5a:
            r2 = r10
            r10 = r11
        L5c:
            r11 = r10
            r10 = r2
            r2 = r0
            r0 = r4
            goto L6b
        L61:
            r2 = move-exception
            r6 = r2
            r2 = r10
            r10 = r11
            r11 = r6
        L66:
            r6 = r11
            r11 = r10
            r10 = r2
            r2 = r0
            r0 = r6
        L6b:
            boolean r5 = r0 instanceof kotlinx.coroutines.TimeoutCancellationException     // Catch: java.lang.Throwable -> L73
            if (r5 == 0) goto L75
            r10.invoke()     // Catch: java.lang.Throwable -> L73
            goto L7c
        L73:
            r8 = move-exception
            goto L7f
        L75:
            if (r0 != 0) goto L7e
            T r11 = r11.f34820a     // Catch: java.lang.Throwable -> L73
            if (r11 == 0) goto L7c
            return r11
        L7c:
            r0 = r2
            goto L41
        L7e:
            throw r0     // Catch: java.lang.Throwable -> L73
        L7f:
            T r9 = r11.f34820a
            c1.h r9 = (c1.h) r9
            if (r9 == 0) goto L88
            r7.e(r9)
        L88:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.b(long, p9.a, e9.c):java.lang.Object");
    }

    public final void c() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isClosed = true;
            for (h hVar : this.connections) {
                if (hVar != null) {
                    hVar.close();
                }
            }
            t tVar = t.f7040a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void d(StringBuilder builder) {
        p.i(builder, "builder");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List listC = C1172u.c();
            int size = this.availableConnections.size();
            for (int i10 = 0; i10 < size; i10++) {
                listC.add(this.availableConnections.get(i10));
            }
            List listA = C1172u.a(listC);
            builder.append('\t' + super.toString() + " (");
            builder.append("capacity=" + this.capacity + ", ");
            builder.append("permits=" + this.connectionPermits.a() + ", ");
            builder.append("queue=(size=" + listA.size() + ")[" + F.A0(listA, null, null, null, 0, null, null, 63, null) + ']');
            builder.append(")");
            builder.append('\n');
            h[] hVarArr = this.connections;
            int length = hVarArr.length;
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                h hVar = hVarArr[i12];
                i11++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\t\t[");
                sb2.append(i11);
                sb2.append("] - ");
                sb2.append(hVar != null ? hVar.toString() : null);
                builder.append(sb2.toString());
                builder.append('\n');
                if (hVar != null) {
                    hVar.A(builder);
                }
            }
            t tVar = t.f7040a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void e(h connection) {
        p.i(connection, "connection");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.availableConnections.addLast(connection);
            t tVar = t.f7040a;
            reentrantLock.unlock();
            this.connectionPermits.release();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void f() {
        if (this.size >= this.capacity) {
            return;
        }
        h hVar = new h(this.connectionFactory.invoke(), null, this.preparedStatementCacheSize, 2, null);
        h[] hVarArr = this.connections;
        int i10 = this.size;
        this.size = i10 + 1;
        hVarArr[i10] = hVar;
        this.availableConnections.addLast(hVar);
    }
}
