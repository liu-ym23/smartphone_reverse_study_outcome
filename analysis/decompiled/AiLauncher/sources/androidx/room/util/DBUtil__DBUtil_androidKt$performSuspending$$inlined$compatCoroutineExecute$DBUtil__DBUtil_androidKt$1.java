package androidx.room.util;

import Ua.M;
import Y8.t;
import androidx.room.RoomDatabase;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1", f = "DBUtil.android.kt", l = {261}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1<R> extends SuspendLambda implements p<M, InterfaceC4014c<? super R>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14881a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomDatabase f14882b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f14883c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f14884d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5074l f14885e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1(InterfaceC4014c interfaceC4014c, RoomDatabase roomDatabase, boolean z10, boolean z11, InterfaceC5074l interfaceC5074l) {
        super(2, interfaceC4014c);
        this.f14882b = roomDatabase;
        this.f14883c = z10;
        this.f14884d = z11;
        this.f14885e = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1(interfaceC4014c, this.f14882b, this.f14883c, this.f14884d, this.f14885e);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super R> interfaceC4014c) {
        return ((DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f14881a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        RoomDatabase roomDatabase = this.f14882b;
        boolean z10 = this.f14883c;
        DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(this.f14884d, z10, roomDatabase, null, this.f14885e);
        this.f14881a = 1;
        Object objU = roomDatabase.U(z10, dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1, this);
        return objU == objG ? objG : objU;
    }
}
