package androidx.datastore.core;

import Y8.t;
import androidx.datastore.core.SingleProcessDataStore;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/SingleProcessDataStore$b;", "msg", "LY8/t;", "<anonymous>", "(Landroidx/datastore/core/SingleProcessDataStore$b;)V"}, k = 3, mv = {1, 5, 1})
@InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$actor$3<T> extends SuspendLambda implements p<SingleProcessDataStore.b<T>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f13305a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f13306b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f13307c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$actor$3(SingleProcessDataStore<T> singleProcessDataStore, InterfaceC4014c<? super SingleProcessDataStore$actor$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f13307c = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SingleProcessDataStore$actor$3 singleProcessDataStore$actor$3 = new SingleProcessDataStore$actor$3(this.f13307c, interfaceC4014c);
        singleProcessDataStore$actor$3.f13306b = obj;
        return singleProcessDataStore$actor$3;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SingleProcessDataStore.b<T> bVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SingleProcessDataStore$actor$3) create(bVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (r4.f13307c.r((androidx.datastore.core.SingleProcessDataStore.b.a) r5, r4) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r4.f13307c.s((androidx.datastore.core.SingleProcessDataStore.b.C0162b) r5, r4) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r4.f13305a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L17:
            kotlin.C4849c.b(r5)
            goto L44
        L1b:
            kotlin.C4849c.b(r5)
            java.lang.Object r5 = r4.f13306b
            androidx.datastore.core.SingleProcessDataStore$b r5 = (androidx.datastore.core.SingleProcessDataStore.b) r5
            boolean r1 = r5 instanceof androidx.datastore.core.SingleProcessDataStore.b.a
            if (r1 == 0) goto L33
            androidx.datastore.core.SingleProcessDataStore<T> r1 = r4.f13307c
            androidx.datastore.core.SingleProcessDataStore$b$a r5 = (androidx.datastore.core.SingleProcessDataStore.b.a) r5
            r4.f13305a = r3
            java.lang.Object r4 = androidx.datastore.core.SingleProcessDataStore.h(r1, r5, r4)
            if (r4 != r0) goto L44
            goto L43
        L33:
            boolean r1 = r5 instanceof androidx.datastore.core.SingleProcessDataStore.b.C0162b
            if (r1 == 0) goto L44
            androidx.datastore.core.SingleProcessDataStore<T> r1 = r4.f13307c
            androidx.datastore.core.SingleProcessDataStore$b$b r5 = (androidx.datastore.core.SingleProcessDataStore.b.C0162b) r5
            r4.f13305a = r2
            java.lang.Object r4 = androidx.datastore.core.SingleProcessDataStore.i(r1, r5, r4)
            if (r4 != r0) goto L44
        L43:
            return r0
        L44:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$actor$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
