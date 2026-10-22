package com.stepos.datacenter.core;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\t\u0010\bJ(\u0010\f\u001a\u00020\u0006\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0086@¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/stepos/datacenter/core/StructuredDataRepository;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "data", "LW6/b;", "e", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, "", "entities", "c", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "Companion", Const.INTENT_KEY_APIKEY, "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StructuredDataRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public static StructuredDataRepository f29977a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/datacenter/core/StructuredDataRepository$a;", "", "<init>", "()V", "Lcom/stepos/datacenter/core/StructuredDataRepository;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/datacenter/core/StructuredDataRepository;", "instance", "Lcom/stepos/datacenter/core/StructuredDataRepository;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.core.StructuredDataRepository$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final StructuredDataRepository a() {
            StructuredDataRepository structuredDataRepository;
            StructuredDataRepository structuredDataRepository2 = StructuredDataRepository.f29977a;
            if (structuredDataRepository2 != null) {
                return structuredDataRepository2;
            }
            synchronized (this) {
                structuredDataRepository = StructuredDataRepository.f29977a;
                if (structuredDataRepository == null) {
                    structuredDataRepository = new StructuredDataRepository(null);
                    StructuredDataRepository.f29977a = structuredDataRepository;
                }
            }
            return structuredDataRepository;
        }

        public Companion() {
        }
    }

    public /* synthetic */ StructuredDataRepository(i iVar) {
        this();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object c(java.util.List<? extends T> r7, e9.InterfaceC4014c<? super W6.StorageResult> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.datacenter.core.StructuredDataRepository$deleteAllData$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.datacenter.core.StructuredDataRepository$deleteAllData$1 r0 = (com.stepos.datacenter.core.StructuredDataRepository$deleteAllData$1) r0
            int r1 = r0.f29981d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29981d = r1
            goto L18
        L13:
            com.stepos.datacenter.core.StructuredDataRepository$deleteAllData$1 r0 = new com.stepos.datacenter.core.StructuredDataRepository$deleteAllData$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r6 = r0.f29979b
            java.lang.Object r8 = f9.C4063a.g()
            int r1 = r0.f29981d
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r7 = r0.f29978a
            java.util.List r7 = (java.util.List) r7
            kotlin.C4849c.b(r6)     // Catch: java.lang.Exception -> L6c
            goto L64
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.C4849c.b(r6)
            Z6.d$a r6 = Z6.d.INSTANCE     // Catch: java.lang.Exception -> L6c
            S6.a r1 = S6.a.f5644a     // Catch: java.lang.Exception -> L6c
            io.objectbox.BoxStore r1 = r1.a()     // Catch: java.lang.Exception -> L6c
            Z6.d r6 = r6.a(r1)     // Catch: java.lang.Exception -> L6c
            java.lang.Object r1 = Z8.F.q0(r7)     // Catch: java.lang.Exception -> L6c
            java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Exception -> L6c
            w9.d r1 = kotlin.jvm.internal.t.b(r1)     // Catch: java.lang.Exception -> L6c
            Z6.a r6 = r6.c(r1)     // Catch: java.lang.Exception -> L6c
            java.lang.String r1 = "null cannot be cast to non-null type com.stepos.datacenter.core.structured.BaseRepository<T of com.stepos.datacenter.core.StructuredDataRepository.deleteAllData>"
            kotlin.jvm.internal.p.g(r6, r1)     // Catch: java.lang.Exception -> L6c
            r0.f29978a = r7     // Catch: java.lang.Exception -> L6c
            r0.f29981d = r2     // Catch: java.lang.Exception -> L6c
            java.lang.Object r6 = r6.b(r7, r0)     // Catch: java.lang.Exception -> L6c
            if (r6 != r8) goto L64
            return r8
        L64:
            W6.b r6 = new W6.b     // Catch: java.lang.Exception -> L6c
            java.lang.String r8 = "Data deleted successfully"
            r6.<init>(r2, r8, r7)     // Catch: java.lang.Exception -> L6c
            return r6
        L6c:
            r0 = move-exception
            r6 = r0
            W6.b r0 = new W6.b
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Delete failed: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            r4 = 4
            r5 = 0
            r1 = 0
            r3 = 0
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.core.StructuredDataRepository.c(java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object d(T r7, e9.InterfaceC4014c<? super W6.StorageResult> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.datacenter.core.StructuredDataRepository$deleteData$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.datacenter.core.StructuredDataRepository$deleteData$1 r0 = (com.stepos.datacenter.core.StructuredDataRepository$deleteData$1) r0
            int r1 = r0.f29985d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29985d = r1
            goto L18
        L13:
            com.stepos.datacenter.core.StructuredDataRepository$deleteData$1 r0 = new com.stepos.datacenter.core.StructuredDataRepository$deleteData$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r6 = r0.f29983b
            java.lang.Object r8 = f9.C4063a.g()
            int r1 = r0.f29985d
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            java.lang.Object r7 = r0.f29982a
            kotlin.C4849c.b(r6)     // Catch: java.lang.Exception -> L66
            goto L5e
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.C4849c.b(r6)
            Z6.d$a r6 = Z6.d.INSTANCE     // Catch: java.lang.Exception -> L66
            S6.a r1 = S6.a.f5644a     // Catch: java.lang.Exception -> L66
            io.objectbox.BoxStore r1 = r1.a()     // Catch: java.lang.Exception -> L66
            Z6.d r6 = r6.a(r1)     // Catch: java.lang.Exception -> L66
            java.lang.Class r1 = r7.getClass()     // Catch: java.lang.Exception -> L66
            w9.d r1 = kotlin.jvm.internal.t.b(r1)     // Catch: java.lang.Exception -> L66
            Z6.a r6 = r6.c(r1)     // Catch: java.lang.Exception -> L66
            java.lang.String r1 = "null cannot be cast to non-null type com.stepos.datacenter.core.structured.BaseRepository<T of com.stepos.datacenter.core.StructuredDataRepository.deleteData>"
            kotlin.jvm.internal.p.g(r6, r1)     // Catch: java.lang.Exception -> L66
            r0.f29982a = r7     // Catch: java.lang.Exception -> L66
            r0.f29985d = r2     // Catch: java.lang.Exception -> L66
            java.lang.Object r6 = r6.a(r7, r0)     // Catch: java.lang.Exception -> L66
            if (r6 != r8) goto L5e
            return r8
        L5e:
            W6.b r6 = new W6.b     // Catch: java.lang.Exception -> L66
            java.lang.String r8 = "Data deleted successfully"
            r6.<init>(r2, r8, r7)     // Catch: java.lang.Exception -> L66
            return r6
        L66:
            r0 = move-exception
            r6 = r0
            W6.b r0 = new W6.b
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Delete failed: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            r4 = 4
            r5 = 0
            r1 = 0
            r3 = 0
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.core.StructuredDataRepository.d(java.lang.Object, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object e(T r7, e9.InterfaceC4014c<? super W6.StorageResult> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.datacenter.core.StructuredDataRepository$storeData$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.datacenter.core.StructuredDataRepository$storeData$1 r0 = (com.stepos.datacenter.core.StructuredDataRepository$storeData$1) r0
            int r1 = r0.f29989d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29989d = r1
            goto L18
        L13:
            com.stepos.datacenter.core.StructuredDataRepository$storeData$1 r0 = new com.stepos.datacenter.core.StructuredDataRepository$storeData$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r6 = r0.f29987b
            java.lang.Object r8 = f9.C4063a.g()
            int r1 = r0.f29989d
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            java.lang.Object r7 = r0.f29986a
            kotlin.C4849c.b(r6)     // Catch: java.lang.Exception -> L66
            goto L5e
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.C4849c.b(r6)
            Z6.d$a r6 = Z6.d.INSTANCE     // Catch: java.lang.Exception -> L66
            S6.a r1 = S6.a.f5644a     // Catch: java.lang.Exception -> L66
            io.objectbox.BoxStore r1 = r1.a()     // Catch: java.lang.Exception -> L66
            Z6.d r6 = r6.a(r1)     // Catch: java.lang.Exception -> L66
            java.lang.Class r1 = r7.getClass()     // Catch: java.lang.Exception -> L66
            w9.d r1 = kotlin.jvm.internal.t.b(r1)     // Catch: java.lang.Exception -> L66
            Z6.a r6 = r6.c(r1)     // Catch: java.lang.Exception -> L66
            java.lang.String r1 = "null cannot be cast to non-null type com.stepos.datacenter.core.structured.BaseRepository<T of com.stepos.datacenter.core.StructuredDataRepository.storeData>"
            kotlin.jvm.internal.p.g(r6, r1)     // Catch: java.lang.Exception -> L66
            r0.f29986a = r7     // Catch: java.lang.Exception -> L66
            r0.f29989d = r2     // Catch: java.lang.Exception -> L66
            java.lang.Object r6 = r6.c(r7, r0)     // Catch: java.lang.Exception -> L66
            if (r6 != r8) goto L5e
            return r8
        L5e:
            W6.b r6 = new W6.b     // Catch: java.lang.Exception -> L66
            java.lang.String r8 = "Data stored successfully"
            r6.<init>(r2, r8, r7)     // Catch: java.lang.Exception -> L66
            return r6
        L66:
            r0 = move-exception
            r6 = r0
            W6.b r0 = new W6.b
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Store failed: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            r4 = 4
            r5 = 0
            r1 = 0
            r3 = 0
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.core.StructuredDataRepository.e(java.lang.Object, e9.c):java.lang.Object");
    }

    public StructuredDataRepository() {
    }
}
