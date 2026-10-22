package androidx.room.coroutines;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.B;
import androidx.room.Transactor;
import c1.j;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0017BQ\u0012@\u0010\b\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003j\b\u0012\u0002\b\u0003\u0018\u0001`\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ2\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013JH\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0015\u001a\u00020\u00142(\u0010\u0011\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJH\u0010\u001c\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0015\u001a\u00020\u00142(\u0010\u0011\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0082@¢\u0006\u0004\b\u001c\u0010\u0018RQ\u0010\b\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003j\b\u0012\u0002\b\u0003\u0018\u0001`\u00078\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\u00060#j\u0002`$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010(R\u0014\u0010*\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"¨\u0006+"}, d2 = {"Landroidx/room/coroutines/PassthroughConnection;", "Landroidx/room/Transactor;", "Lc1/j;", "Lkotlin/Function2;", "Lkotlin/Function1;", "Le9/c;", "", "Landroidx/room/coroutines/TransactionWrapper;", "transactionWrapper", "Li1/b;", "delegate", "<init>", "(Lp9/p;Li1/b;)V", "R", "", "sql", "Li1/d;", "block", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "Landroidx/room/Transactor$SQLiteTransactionType;", "type", "Landroidx/room/B;", Const.INTENT_KEY_APIKEY, "(Landroidx/room/Transactor$SQLiteTransactionType;Lp9/p;Le9/c;)Ljava/lang/Object;", "", Const.INTENT_KEY_PKGNAME, "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lp9/p;", "getTransactionWrapper", "()Lp9/p;", "Li1/b;", "f", "()Li1/b;", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/room/concurrent/AtomicInt;", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "nestedTransactionCount", "Landroidx/room/Transactor$SQLiteTransactionType;", "currentTransactionType", "rawConnection", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PassthroughConnection implements Transactor, j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final p<InterfaceC5074l<? super InterfaceC4014c<Object>, ? extends Object>, InterfaceC4014c<Object>, Object> transactionWrapper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4160b delegate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public AtomicInteger nestedTransactionCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Transactor.SQLiteTransactionType currentTransactionType;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\f\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00062\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\tH\u0096@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/room/coroutines/PassthroughConnection$a;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/B;", "Lc1/j;", "<init>", "(Landroidx/room/coroutines/PassthroughConnection;)V", "R", "", "sql", "Lkotlin/Function1;", "Li1/d;", "block", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "Li1/b;", "c", "()Li1/b;", "rawConnection", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class a<T> implements B<T>, j {
        public a() {
        }

        @Override // c1.j
        /* renamed from: c */
        public InterfaceC4160b getDelegate() {
            return PassthroughConnection.this.getDelegate();
        }

        @Override // androidx.room.l
        public <R> Object d(String str, InterfaceC5074l<? super InterfaceC4162d, ? extends R> interfaceC5074l, InterfaceC4014c<? super R> interfaceC4014c) {
            return PassthroughConnection.this.d(str, interfaceC5074l, interfaceC4014c);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14701a;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f14701a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PassthroughConnection(p<? super InterfaceC5074l<? super InterfaceC4014c<Object>, ? extends Object>, ? super InterfaceC4014c<Object>, ? extends Object> pVar, InterfaceC4160b delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.transactionWrapper = pVar;
        this.delegate = delegate;
        this.nestedTransactionCount = new AtomicInteger(0);
    }

    @Override // androidx.room.Transactor
    public <R> Object a(Transactor.SQLiteTransactionType sQLiteTransactionType, p<? super B<R>, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super R> interfaceC4014c) {
        p<InterfaceC5074l<? super InterfaceC4014c<Object>, ? extends Object>, InterfaceC4014c<Object>, Object> pVar2 = this.transactionWrapper;
        if (pVar2 == null) {
            return g(sQLiteTransactionType, pVar, interfaceC4014c);
        }
        Object objInvoke = pVar2.invoke(new PassthroughConnection$withTransaction$2(this, sQLiteTransactionType, pVar, null), interfaceC4014c);
        C4063a.g();
        return objInvoke;
    }

    @Override // androidx.room.Transactor
    public Object b(InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(this.currentTransactionType != null || this.delegate.inTransaction());
    }

    @Override // c1.j
    /* renamed from: c, reason: from getter */
    public InterfaceC4160b getDelegate() {
        return this.delegate;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.room.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object d(java.lang.String r6, p9.InterfaceC5074l<? super i1.InterfaceC4162d, ? extends R> r7, e9.InterfaceC4014c<? super R> r8) throws java.lang.Exception {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.room.coroutines.PassthroughConnection$usePrepared$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.coroutines.PassthroughConnection$usePrepared$1 r0 = (androidx.room.coroutines.PassthroughConnection$usePrepared$1) r0
            int r1 = r0.f14710e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14710e = r1
            goto L18
        L13:
            androidx.room.coroutines.PassthroughConnection$usePrepared$1 r0 = new androidx.room.coroutines.PassthroughConnection$usePrepared$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f14708c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f14710e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r8)
            return r8
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r6 = r0.f14707b
            r7 = r6
            p9.l r7 = (p9.InterfaceC5074l) r7
            java.lang.Object r6 = r0.f14706a
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r8)
            goto L51
        L41:
            kotlin.C4849c.b(r8)
            r0.f14706a = r6
            r0.f14707b = r7
            r0.f14710e = r4
            java.lang.Object r8 = r5.b(r0)
            if (r8 != r1) goto L51
            goto L6f
        L51:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r2 = 0
            if (r8 == 0) goto L71
            p9.p<p9.l<? super e9.c<java.lang.Object>, ? extends java.lang.Object>, e9.c<java.lang.Object>, java.lang.Object> r8 = r5.transactionWrapper
            if (r8 == 0) goto L71
            androidx.room.coroutines.PassthroughConnection$usePrepared$2 r4 = new androidx.room.coroutines.PassthroughConnection$usePrepared$2
            r4.<init>(r5, r6, r7, r2)
            r0.f14706a = r2
            r0.f14707b = r2
            r0.f14710e = r3
            java.lang.Object r5 = r8.invoke(r4, r0)
            if (r5 != r1) goto L70
        L6f:
            return r1
        L70:
            return r5
        L71:
            i1.b r5 = r5.delegate
            i1.d r5 = r5.q1(r6)
            java.lang.Object r6 = r7.invoke(r5)     // Catch: java.lang.Throwable -> L7f
            n9.C4946a.a(r5, r2)
            return r6
        L7f:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L81
        L81:
            r7 = move-exception
            n9.C4946a.a(r5, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PassthroughConnection.d(java.lang.String, p9.l, e9.c):java.lang.Object");
    }

    public final InterfaceC4160b f() {
        return this.delegate;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <R> java.lang.Object g(androidx.room.Transactor.SQLiteTransactionType r8, p9.p<? super androidx.room.B<R>, ? super e9.InterfaceC4014c<? super R>, ? extends java.lang.Object> r9, e9.InterfaceC4014c<? super R> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PassthroughConnection.g(androidx.room.Transactor$SQLiteTransactionType, p9.p, e9.c):java.lang.Object");
    }
}
