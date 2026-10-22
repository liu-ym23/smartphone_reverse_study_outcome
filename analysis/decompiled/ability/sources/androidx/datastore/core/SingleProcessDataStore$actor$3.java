package androidx.datastore.core;

import C7.r;
import J7.c;
import S7.n;
import androidx.core.app.NotificationCompat;
import androidx.datastore.core.SingleProcessDataStore;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@c(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/SingleProcessDataStore$Message;", NotificationCompat.CATEGORY_MESSAGE, "LC7/r;", "<anonymous>", "(Landroidx/datastore/core/SingleProcessDataStore$Message;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SingleProcessDataStore$actor$3 extends SuspendLambda implements n {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$actor$3(SingleProcessDataStore<T> singleProcessDataStore, H7.c<? super SingleProcessDataStore$actor$3> cVar) {
        super(2, cVar);
        this.this$0 = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        SingleProcessDataStore$actor$3 singleProcessDataStore$actor$3 = new SingleProcessDataStore$actor$3(this.this$0, cVar);
        singleProcessDataStore$actor$3.L$0 = obj;
        return singleProcessDataStore$actor$3;
    }

    @Override // S7.n
    public final Object invoke(SingleProcessDataStore.Message<T> message, H7.c<? super r> cVar) {
        return ((SingleProcessDataStore$actor$3) create(message, cVar)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        if (r4.this$0.handleRead((androidx.datastore.core.SingleProcessDataStore.Message.Read) r5, r4) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r4.this$0.handleUpdate((androidx.datastore.core.SingleProcessDataStore.Message.Update) r5, r4) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L19
            if (r1 == r3) goto L15
            if (r1 != r2) goto Ld
            goto L15
        Ld:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L15:
            kotlin.b.b(r5)
            goto L42
        L19:
            kotlin.b.b(r5)
            java.lang.Object r5 = r4.L$0
            androidx.datastore.core.SingleProcessDataStore$Message r5 = (androidx.datastore.core.SingleProcessDataStore.Message) r5
            boolean r1 = r5 instanceof androidx.datastore.core.SingleProcessDataStore.Message.Read
            if (r1 == 0) goto L31
            androidx.datastore.core.SingleProcessDataStore<T> r1 = r4.this$0
            androidx.datastore.core.SingleProcessDataStore$Message$Read r5 = (androidx.datastore.core.SingleProcessDataStore.Message.Read) r5
            r4.label = r3
            java.lang.Object r4 = androidx.datastore.core.SingleProcessDataStore.access$handleRead(r1, r5, r4)
            if (r4 != r0) goto L42
            goto L41
        L31:
            boolean r1 = r5 instanceof androidx.datastore.core.SingleProcessDataStore.Message.Update
            if (r1 == 0) goto L42
            androidx.datastore.core.SingleProcessDataStore<T> r1 = r4.this$0
            androidx.datastore.core.SingleProcessDataStore$Message$Update r5 = (androidx.datastore.core.SingleProcessDataStore.Message.Update) r5
            r4.label = r2
            java.lang.Object r4 = androidx.datastore.core.SingleProcessDataStore.access$handleUpdate(r1, r5, r4)
            if (r4 != r0) goto L42
        L41:
            return r0
        L42:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$actor$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
