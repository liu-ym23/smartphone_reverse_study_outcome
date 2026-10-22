package androidx.room.util;

import Ua.C1056g;
import Ua.M;
import Y8.t;
import androidx.room.RoomDatabase;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import i1.InterfaceC4160b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1", f = "DBUtil.android.kt", l = {72}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DBUtil__DBUtil_androidKt$performBlocking$1<R> extends SuspendLambda implements p<M, InterfaceC4014c<? super R>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14896a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f14897b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RoomDatabase f14898c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f14899d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f14900e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5074l<InterfaceC4160b, R> f14901f;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1$1", f = "DBUtil.android.kt", l = {260}, m = "invokeSuspend")
    /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super R>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f14902a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RoomDatabase f14903b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f14904c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f14905d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<InterfaceC4160b, R> f14906e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(RoomDatabase roomDatabase, boolean z10, boolean z11, InterfaceC5074l<? super InterfaceC4160b, ? extends R> interfaceC5074l, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f14903b = roomDatabase;
            this.f14904c = z10;
            this.f14905d = z11;
            this.f14906e = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.f14903b, this.f14904c, this.f14905d, this.f14906e, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super R> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f14902a;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            boolean z10 = !(this.f14903b.F() && this.f14903b.G()) && this.f14904c;
            RoomDatabase roomDatabase = this.f14903b;
            boolean z11 = this.f14905d;
            DBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1(z10, z11, roomDatabase, null, this.f14906e);
            this.f14902a = 1;
            Object objU = roomDatabase.U(z11, dBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1, this);
            return objU == objG ? objG : objU;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DBUtil__DBUtil_androidKt$performBlocking$1(d dVar, RoomDatabase roomDatabase, boolean z10, boolean z11, InterfaceC5074l<? super InterfaceC4160b, ? extends R> interfaceC5074l, InterfaceC4014c<? super DBUtil__DBUtil_androidKt$performBlocking$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14897b = dVar;
        this.f14898c = roomDatabase;
        this.f14899d = z10;
        this.f14900e = z11;
        this.f14901f = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DBUtil__DBUtil_androidKt$performBlocking$1(this.f14897b, this.f14898c, this.f14899d, this.f14900e, this.f14901f, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super R> interfaceC4014c) {
        return ((DBUtil__DBUtil_androidKt$performBlocking$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f14896a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        d dVar = this.f14897b;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f14898c, this.f14899d, this.f14900e, this.f14901f, null);
        this.f14896a = 1;
        Object objJ = C1056g.j(dVar, anonymousClass1, this);
        return objJ == objG ? objG : objJ;
    }
}
