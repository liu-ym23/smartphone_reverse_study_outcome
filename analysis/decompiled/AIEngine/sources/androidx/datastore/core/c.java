package androidx.datastore.core;

import androidx.datastore.core.c;
import androidx.datastore.preferences.protobuf.b1;
import d1.e;
import d1.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import lb.n;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c<T> implements d1.c<T> {

    /* renamed from: j, reason: collision with root package name */
    public static final LinkedHashSet f1672j = new LinkedHashSet();

    /* renamed from: k, reason: collision with root package name */
    public static final Object f1673k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final zb.a<File> f1674a;

    /* renamed from: b, reason: collision with root package name */
    public final b1 f1675b;

    /* renamed from: c, reason: collision with root package name */
    public final CoroutineScope f1676c;

    /* renamed from: d, reason: collision with root package name */
    public final Flow<T> f1677d = FlowKt.flow(new SingleProcessDataStore$data$1(this, null));

    /* renamed from: e, reason: collision with root package name */
    public final String f1678e = ".tmp";

    /* renamed from: f, reason: collision with root package name */
    public final lb.d f1679f = kotlin.b.b(new zb.a<File>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$file$2

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c<Object> f1619a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.f1619a = this;
        }

        @Override // zb.a
        public final File invoke() {
            File fileInvoke = this.f1619a.f1674a.invoke();
            String it = fileInvoke.getAbsolutePath();
            synchronized (c.f1673k) {
                LinkedHashSet linkedHashSet = c.f1672j;
                if (linkedHashSet.contains(it)) {
                    throw new IllegalStateException(("There are multiple DataStores active for the same file: " + fileInvoke + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                }
                g.e(it, "it");
                linkedHashSet.add(it);
            }
            return fileInvoke;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    public final MutableStateFlow<d1.g<T>> f1680g = StateFlowKt.MutableStateFlow(h.f8262a);
    public List<? extends p<? super e<T>, ? super qb.b<? super n>, ? extends Object>> h;

    /* renamed from: i, reason: collision with root package name */
    public final SimpleActor<a<T>> f1681i;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a<T> {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: androidx.datastore.core.c$a$a, reason: collision with other inner class name */
        public static final class C0011a<T> extends a<T> {

            /* renamed from: a, reason: collision with root package name */
            public final d1.g<T> f1682a;

            public C0011a(d1.g<T> gVar) {
                this.f1682a = gVar;
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class b<T> extends a<T> {

            /* renamed from: a, reason: collision with root package name */
            public final SuspendLambda f1683a;

            /* renamed from: b, reason: collision with root package name */
            public final CompletableDeferred<T> f1684b;

            /* renamed from: c, reason: collision with root package name */
            public final d1.g<T> f1685c;

            /* renamed from: d, reason: collision with root package name */
            public final kotlin.coroutines.d f1686d;

            /* JADX WARN: Multi-variable type inference failed */
            public b(p<? super T, ? super qb.b<? super T>, ? extends Object> pVar, CompletableDeferred<T> ack, d1.g<T> gVar, kotlin.coroutines.d callerContext) {
                g.f(ack, "ack");
                g.f(callerContext, "callerContext");
                this.f1683a = (SuspendLambda) pVar;
                this.f1684b = ack;
                this.f1685c = gVar;
                this.f1686d = callerContext;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        public final FileOutputStream f1687a;

        public b(FileOutputStream fileOutputStream) {
            this.f1687a = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() throws IOException {
            this.f1687a.flush();
        }

        @Override // java.io.OutputStream
        public final void write(int i10) throws IOException {
            this.f1687a.write(i10);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] b10) throws IOException {
            g.f(b10, "b");
            this.f1687a.write(b10);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bytes, int i10, int i11) {
            g.f(bytes, "bytes");
            this.f1687a.write(bytes, i10, i11);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }
    }

    public c(zb.a aVar, List list, b1 b1Var, CoroutineScope coroutineScope) {
        this.f1674a = aVar;
        this.f1675b = b1Var;
        this.f1676c = coroutineScope;
        this.h = kotlin.collections.a.O0(list);
        this.f1681i = new SimpleActor<>(coroutineScope, new l<Throwable, n>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$actor$1

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c<Object> f1609a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f1609a = this;
            }

            @Override // zb.l
            public final n invoke(Throwable th) {
                Throwable th2 = th;
                if (th2 != null) {
                    this.f1609a.f1680g.setValue(new d1.d(th2));
                }
                Object obj = c.f1673k;
                c<Object> cVar = this.f1609a;
                synchronized (obj) {
                    c.f1672j.remove(cVar.c().getAbsolutePath());
                }
                return n.f10413a;
            }
        }, new p<a<Object>, Throwable, n>() { // from class: androidx.datastore.core.SingleProcessDataStore$actor$2
            @Override // zb.p
            public final n invoke(c.a<Object> aVar2, Throwable th) {
                c.a<Object> msg = aVar2;
                Throwable cancellationException = th;
                g.f(msg, "msg");
                if (msg instanceof c.a.b) {
                    CompletableDeferred<T> completableDeferred = ((c.a.b) msg).f1684b;
                    if (cancellationException == null) {
                        cancellationException = new CancellationException("DataStore scope was cancelled before updateData could complete");
                    }
                    completableDeferred.completeExceptionally(cancellationException);
                }
                return n.f10413a;
            }
        }, new SingleProcessDataStore$actor$3(this, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a0, code lost:
    
        if (r8 != r1) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v10, types: [kotlin.coroutines.jvm.internal.SuspendLambda, zb.p] */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.coroutines.jvm.internal.SuspendLambda, zb.p] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(androidx.datastore.core.c r8, androidx.datastore.core.c.a.b r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.c.b(androidx.datastore.core.c, androidx.datastore.core.c$a$b, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // d1.c
    public final Object a(p<? super T, ? super qb.b<? super T>, ? extends Object> pVar, qb.b<? super T> bVar) {
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.f1681i.a(new a.b(pVar, completableDeferredCompletableDeferred$default, this.f1680g.getValue(), bVar.getContext()));
        return completableDeferredCompletableDeferred$default.await(bVar);
    }

    public final File c() {
        return (File) this.f1679f.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.jvm.internal.ContinuationImpl r13) throws androidx.datastore.core.CorruptionException, java.io.FileNotFoundException {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.c.d(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.f1643d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1643d = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f1641b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f1643d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            androidx.datastore.core.c r4 = r0.f1640a
            kotlin.c.b(r5)     // Catch: java.lang.Throwable -> L29
            goto L41
        L29:
            r5 = move-exception
            goto L44
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.c.b(r5)
            r0.f1640a = r4     // Catch: java.lang.Throwable -> L29
            r0.f1643d = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r4.d(r0)     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L41
            return r1
        L41:
            lb.n r4 = lb.n.f10413a
            return r4
        L44:
            kotlinx.coroutines.flow.MutableStateFlow<d1.g<T>> r4 = r4.f1680g
            d1.f r0 = new d1.f
            r0.<init>(r5)
            r4.setValue(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.c.e(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1) r0
            int r1 = r0.f1647d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1647d = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f1645b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f1647d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            androidx.datastore.core.c r4 = r0.f1644a
            kotlin.c.b(r5)     // Catch: java.lang.Throwable -> L29
            goto L4b
        L29:
            r5 = move-exception
            goto L41
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.c.b(r5)
            r0.f1644a = r4     // Catch: java.lang.Throwable -> L29
            r0.f1647d = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r4.d(r0)     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L4b
            return r1
        L41:
            kotlinx.coroutines.flow.MutableStateFlow<d1.g<T>> r4 = r4.f1680g
            d1.f r0 = new d1.f
            r0.<init>(r5)
            r4.setValue(r0)
        L4b:
            lb.n r4 = lb.n.f10413a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.c.f(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.datastore.core.c] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.SingleProcessDataStore$readData$1] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.c] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.io.FileNotFoundException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$readData$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readData$1) r0
            int r1 = r0.f1652e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1652e = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readData$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f1650c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f1652e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.io.FileInputStream r5 = r0.f1649b
            androidx.datastore.core.c r0 = r0.f1648a
            kotlin.c.b(r6)     // Catch: java.lang.Throwable -> L2b
            goto L54
        L2b:
            r6 = move-exception
            goto L60
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.c.b(r6)
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L66
            java.io.File r2 = r5.c()     // Catch: java.io.FileNotFoundException -> L66
            r6.<init>(r2)     // Catch: java.io.FileNotFoundException -> L66
            g1.b r2 = g1.b.f8948a     // Catch: java.lang.Throwable -> L5b
            r0.f1648a = r5     // Catch: java.lang.Throwable -> L5b
            r0.f1649b = r6     // Catch: java.lang.Throwable -> L5b
            r0.f1652e = r3     // Catch: java.lang.Throwable -> L5b
            androidx.datastore.preferences.core.MutablePreferences r0 = r2.a(r6)     // Catch: java.lang.Throwable -> L5b
            if (r0 != r1) goto L50
            return r1
        L50:
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
        L54:
            r1 = 0
            mb.y.q(r5, r1)     // Catch: java.io.FileNotFoundException -> L59
            return r6
        L59:
            r5 = move-exception
            goto L69
        L5b:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
        L60:
            throw r6     // Catch: java.lang.Throwable -> L61
        L61:
            r1 = move-exception
            mb.y.q(r5, r6)     // Catch: java.io.FileNotFoundException -> L59
            throw r1     // Catch: java.io.FileNotFoundException -> L59
        L66:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L69:
            java.io.File r6 = r0.c()
            boolean r6 = r6.exists()
            if (r6 != 0) goto L79
            androidx.datastore.preferences.core.MutablePreferences r5 = new androidx.datastore.preferences.core.MutablePreferences
            r5.<init>(r3, r3)
            return r5
        L79:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.c.g(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws androidx.datastore.core.CorruptionException, java.io.FileNotFoundException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1) r0
            int r1 = r0.f1657e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1657e = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f1655c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f1657e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L66
            if (r2 == r4) goto L5c
            r5 = 3
            if (r2 == r3) goto L3d
            if (r2 != r5) goto L35
            java.lang.Object r5 = r0.f1654b
            java.lang.Object r0 = r0.f1653a
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            kotlin.c.b(r6)     // Catch: java.io.IOException -> L33
            return r5
        L33:
            r5 = move-exception
            goto L58
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            java.lang.Object r2 = r0.f1654b
            androidx.datastore.core.CorruptionException r2 = (androidx.datastore.core.CorruptionException) r2
            java.lang.Object r3 = r0.f1653a
            androidx.datastore.core.c r3 = (androidx.datastore.core.c) r3
            kotlin.c.b(r6)
            r0.f1653a = r2     // Catch: java.io.IOException -> L56
            r0.f1654b = r6     // Catch: java.io.IOException -> L56
            r0.f1657e = r5     // Catch: java.io.IOException -> L56
            java.lang.Object r5 = r3.j(r6, r0)     // Catch: java.io.IOException -> L56
            if (r5 != r1) goto L55
            goto L73
        L55:
            return r6
        L56:
            r5 = move-exception
            r0 = r2
        L58:
            jd.b.c(r0, r5)
            throw r0
        L5c:
            java.lang.Object r5 = r0.f1653a
            androidx.datastore.core.c r5 = (androidx.datastore.core.c) r5
            kotlin.c.b(r6)     // Catch: androidx.datastore.core.CorruptionException -> L64
            return r6
        L64:
            r6 = move-exception
            goto L75
        L66:
            kotlin.c.b(r6)
            r0.f1653a = r5     // Catch: androidx.datastore.core.CorruptionException -> L64
            r0.f1657e = r4     // Catch: androidx.datastore.core.CorruptionException -> L64
            java.lang.Object r5 = r5.g(r0)     // Catch: androidx.datastore.core.CorruptionException -> L64
            if (r5 != r1) goto L74
        L73:
            return r1
        L74:
            return r5
        L75:
            androidx.datastore.preferences.protobuf.b1 r1 = r5.f1675b
            r0.f1653a = r5
            r0.f1654b = r6
            r0.f1657e = r3
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.c.h(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(zb.p r10, kotlin.coroutines.d r11, kotlin.coroutines.jvm.internal.ContinuationImpl r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = (androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.f1661d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.h
            java.lang.String r3 = "Data in DataStore was mutated but DataStore is only compatible with Immutable types."
            r4 = 0
            r5 = 0
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L47
            if (r2 == r7) goto L3b
            if (r2 != r6) goto L33
            java.lang.Object r9 = r0.f1659b
            androidx.datastore.core.c r10 = r0.f1658a
            kotlin.c.b(r12)
            goto La1
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            java.lang.Object r9 = r0.f1660c
            java.lang.Object r10 = r0.f1659b
            d1.a r10 = (d1.a) r10
            androidx.datastore.core.c r11 = r0.f1658a
            kotlin.c.b(r12)
            goto L7b
        L47:
            kotlin.c.b(r12)
            kotlinx.coroutines.flow.MutableStateFlow<d1.g<T>> r12 = r9.f1680g
            java.lang.Object r12 = r12.getValue()
            d1.a r12 = (d1.a) r12
            T r2 = r12.f8258a
            if (r2 == 0) goto L5b
            int r2 = r2.hashCode()
            goto L5c
        L5b:
            r2 = r4
        L5c:
            int r8 = r12.f8259b
            if (r2 != r8) goto Lb8
            T r2 = r12.f8258a
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1 r8 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1
            r8.<init>(r10, r2, r5)
            r0.f1658a = r9
            r0.f1659b = r12
            r0.f1660c = r2
            r0.h = r7
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r11, r8, r0)
            if (r10 != r1) goto L76
            goto L9e
        L76:
            r11 = r12
            r12 = r10
            r10 = r11
            r11 = r9
            r9 = r2
        L7b:
            T r2 = r10.f8258a
            if (r2 == 0) goto L84
            int r2 = r2.hashCode()
            goto L85
        L84:
            r2 = r4
        L85:
            int r10 = r10.f8259b
            if (r2 != r10) goto Lb2
            boolean r10 = kotlin.jvm.internal.g.b(r9, r12)
            if (r10 == 0) goto L90
            return r9
        L90:
            r0.f1658a = r11
            r0.f1659b = r12
            r0.f1660c = r5
            r0.h = r6
            java.lang.Object r9 = r11.j(r12, r0)
            if (r9 != r1) goto L9f
        L9e:
            return r1
        L9f:
            r10 = r11
            r9 = r12
        La1:
            kotlinx.coroutines.flow.MutableStateFlow<d1.g<T>> r10 = r10.f1680g
            d1.a r11 = new d1.a
            if (r9 == 0) goto Lab
            int r4 = r9.hashCode()
        Lab:
            r11.<init>(r9, r4)
            r10.setValue(r11)
            return r9
        Lb2:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r3)
            throw r9
        Lb8:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.c.i(zb.p, kotlin.coroutines.d, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.coroutines.intrinsics.CoroutineSingletons] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.c.j(java.lang.Object, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
