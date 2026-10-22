package androidx.room;

import Ua.C1056g;
import Ua.InterfaceC1066l;
import Ua.M;
import Ua.N0;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.concurrent.RejectedExecutionException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0080@¢\u0006\u0004\b\u0006\u0010\u0007\u001a>\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH\u0082@¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0010\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a8\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0080@¢\u0006\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "Lkotlin/Function1;", "Le9/c;", "", "block", "e", "(Landroidx/room/RoomDatabase;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "LUa/M;", "transactionBlock", Const.INTENT_KEY_UMID, "(Landroidx/room/RoomDatabase;Lp9/p;Le9/c;)Ljava/lang/Object;", "Lkotlin/coroutines/c;", "dispatcher", "Lkotlin/coroutines/d;", "c", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/c;)Lkotlin/coroutines/d;", Const.INTENT_KEY_PKGNAME, "room-runtime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "androidx/room/RoomDatabaseKt")
/* loaded from: classes.dex */
public final /* synthetic */ class RoomDatabaseKt__RoomDatabase_androidKt {
    public static final <R> Object b(RoomDatabase roomDatabase, InterfaceC5074l<? super InterfaceC4014c<? super R>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super R> interfaceC4014c) {
        if ((!roomDatabase.F() || !roomDatabase.M() || !roomDatabase.G()) && interfaceC4014c.getContext().get(u.f14847a) != null) {
            return s.e(roomDatabase, interfaceC5074l, interfaceC4014c);
        }
        return interfaceC5074l.invoke(interfaceC4014c);
    }

    public static final kotlin.coroutines.d c(RoomDatabase roomDatabase, kotlin.coroutines.c cVar) {
        kotlin.coroutines.d dVarPlus = cVar.plus(new y(cVar));
        return dVarPlus.plus(N0.a(roomDatabase.B(), dVarPlus));
    }

    public static final <R> Object d(final RoomDatabase roomDatabase, final p9.p<? super M, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super R> interfaceC4014c) {
        final kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        try {
            roomDatabase.D().execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
                @InterfaceC4112d(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1", f = "RoomDatabase.android.kt", l = {2087}, m = "invokeSuspend")
                /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1, reason: invalid class name */
                public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

                    /* renamed from: a, reason: collision with root package name */
                    public int f14534a;

                    /* renamed from: b, reason: collision with root package name */
                    public /* synthetic */ Object f14535b;

                    /* renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ RoomDatabase f14536c;

                    /* renamed from: d, reason: collision with root package name */
                    public final /* synthetic */ InterfaceC1066l<R> f14537d;

                    /* renamed from: e, reason: collision with root package name */
                    public final /* synthetic */ p9.p<M, InterfaceC4014c<? super R>, Object> f14538e;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(RoomDatabase roomDatabase, InterfaceC1066l<? super R> interfaceC1066l, p9.p<? super M, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                        super(2, interfaceC4014c);
                        this.f14536c = roomDatabase;
                        this.f14537d = interfaceC1066l;
                        this.f14538e = pVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f14536c, this.f14537d, this.f14538e, interfaceC4014c);
                        anonymousClass1.f14535b = obj;
                        return anonymousClass1;
                    }

                    @Override // p9.p
                    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                        return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        InterfaceC4014c interfaceC4014c;
                        Object objG = C4063a.g();
                        int i10 = this.f14534a;
                        if (i10 == 0) {
                            C4849c.b(obj);
                            d.b bVar = ((M) this.f14535b).getCoroutineContext().get(kotlin.coroutines.c.INSTANCE);
                            kotlin.jvm.internal.p.f(bVar);
                            kotlin.coroutines.d dVarC = RoomDatabaseKt__RoomDatabase_androidKt.c(this.f14536c, (kotlin.coroutines.c) bVar);
                            InterfaceC4014c interfaceC4014c2 = this.f14537d;
                            Result.Companion companion = Result.INSTANCE;
                            p9.p<M, InterfaceC4014c<? super R>, Object> pVar = this.f14538e;
                            this.f14535b = interfaceC4014c2;
                            this.f14534a = 1;
                            obj = C1056g.j(dVarC, pVar, this);
                            if (obj == objG) {
                                return objG;
                            }
                            interfaceC4014c = interfaceC4014c2;
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            interfaceC4014c = (InterfaceC4014c) this.f14535b;
                            C4849c.b(obj);
                        }
                        interfaceC4014c.resumeWith(Result.b(obj));
                        return Y8.t.f7040a;
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        C1056g.e(cVar.getContext().minusKey(kotlin.coroutines.c.INSTANCE), new AnonymousClass1(roomDatabase, cVar, pVar, null));
                    } catch (Throwable th) {
                        cVar.cancel(th);
                    }
                }
            });
        } catch (RejectedExecutionException e10) {
            cVar.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e10));
        }
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC;
    }

    public static final <R> Object e(RoomDatabase roomDatabase, InterfaceC5074l<? super InterfaceC4014c<? super R>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super R> interfaceC4014c) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(interfaceC5074l, null);
        y yVar = (y) interfaceC4014c.getContext().get(y.INSTANCE);
        kotlin.coroutines.c transactionDispatcher = yVar != null ? yVar.getTransactionDispatcher() : null;
        return transactionDispatcher != null ? C1056g.j(transactionDispatcher, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, interfaceC4014c) : d(roomDatabase, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, interfaceC4014c);
    }
}
