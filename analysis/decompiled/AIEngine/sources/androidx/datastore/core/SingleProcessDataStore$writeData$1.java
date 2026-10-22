package androidx.datastore.core;

import java.io.File;
import java.io.FileOutputStream;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {426}, m = "writeData$datastore_core")
/* loaded from: classes.dex */
final class SingleProcessDataStore$writeData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public c f1666a;

    /* renamed from: b, reason: collision with root package name */
    public File f1667b;

    /* renamed from: c, reason: collision with root package name */
    public FileOutputStream f1668c;

    /* renamed from: d, reason: collision with root package name */
    public FileOutputStream f1669d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f1670e;
    public final /* synthetic */ c<Object> h;

    /* renamed from: j, reason: collision with root package name */
    public int f1671j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$writeData$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.h = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1670e = obj;
        this.f1671j |= Integer.MIN_VALUE;
        return this.h.j(null, this);
    }
}
