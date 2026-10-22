package androidx.datastore.core;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {ErrorCodes.NOT_SET_VERSION_CODE_ERROR, ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DataMigrationInitializer$Companion$runMigrations$2 extends SuspendLambda implements p<Object, qb.b<Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f1586a;

    /* renamed from: b, reason: collision with root package name */
    public d1.b f1587b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1588c;

    /* renamed from: d, reason: collision with root package name */
    public int f1589d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f1590e;
    public final /* synthetic */ List<d1.b<Object>> h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1591j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$2(List list, ArrayList arrayList, qb.b bVar) {
        super(2, bVar);
        this.h = list;
        this.f1591j = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.h, this.f1591j, bVar);
        dataMigrationInitializer$Companion$runMigrations$2.f1590e = obj;
        return dataMigrationInitializer$Companion$runMigrations$2;
    }

    @Override // zb.p
    public final Object invoke(Object obj, qb.b<Object> bVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2) create(obj, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r8.f1589d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2f
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.util.Iterator r1 = r8.f1586a
            java.lang.Object r4 = r8.f1590e
            java.util.List r4 = (java.util.List) r4
            kotlin.c.b(r9)
            goto L3c
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1e:
            java.lang.Object r1 = r8.f1588c
            d1.b r4 = r8.f1587b
            java.util.Iterator r5 = r8.f1586a
            java.lang.Object r6 = r8.f1590e
            java.util.List r6 = (java.util.List) r6
            kotlin.c.b(r9)
            r7 = r6
            r6 = r4
            r4 = r7
            goto L5e
        L2f:
            kotlin.c.b(r9)
            java.lang.Object r9 = r8.f1590e
            java.util.List<d1.b<java.lang.Object>> r1 = r8.h
            java.util.Iterator r1 = r1.iterator()
            java.util.ArrayList r4 = r8.f1591j
        L3c:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L84
            java.lang.Object r5 = r1.next()
            d1.b r5 = (d1.b) r5
            r8.f1590e = r4
            r8.f1586a = r1
            r8.f1587b = r5
            r8.f1588c = r9
            r8.f1589d = r3
            java.lang.Object r6 = r5.c()
            if (r6 != r0) goto L59
            goto L7f
        L59:
            r7 = r1
            r1 = r9
            r9 = r6
            r6 = r5
            r5 = r7
        L5e:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L82
            androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1 r9 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1
            r1 = 0
            r9.<init>(r6, r1)
            r4.add(r9)
            r8.f1590e = r4
            r8.f1586a = r5
            r8.f1587b = r1
            r8.f1588c = r1
            r8.f1589d = r2
            java.lang.Object r9 = r6.b()
            if (r9 != r0) goto L80
        L7f:
            return r0
        L80:
            r1 = r5
            goto L3c
        L82:
            r9 = r1
            goto L80
        L84:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
