package androidx.room.util;

import Y8.t;
import androidx.room.RoomDatabase;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n"}, d2 = {"<anonymous>", "R"}, k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2", f = "DBUtil.android.kt", l = {260}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DBUtil__DBUtil_androidKt$performInTransactionSuspending$2<R> extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super R>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14911a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomDatabase f14912b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super R>, Object> f14913c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DBUtil__DBUtil_androidKt$performInTransactionSuspending$2(RoomDatabase roomDatabase, InterfaceC5074l<? super InterfaceC4014c<? super R>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super DBUtil__DBUtil_androidKt$performInTransactionSuspending$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f14912b = roomDatabase;
        this.f14913c = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new DBUtil__DBUtil_androidKt$performInTransactionSuspending$2(this.f14912b, this.f14913c, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super R> interfaceC4014c) {
        return ((DBUtil__DBUtil_androidKt$performInTransactionSuspending$2) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f14911a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        RoomDatabase roomDatabase = this.f14912b;
        DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1(true, false, roomDatabase, null, this.f14913c);
        this.f14911a = 1;
        Object objU = roomDatabase.U(false, dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1, this);
        return objU == objG ? objG : objU;
    }
}
