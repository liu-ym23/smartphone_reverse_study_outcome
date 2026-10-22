package com.stepos.datacenter.api;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.core.result.DataCenterResult;
import e7.p;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0086@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/datacenter/api/CollectionOps;", "", "<init>", "()V", "Lcom/stepos/datacenter/vector/CollectionDescriptor;", "descriptor", "Lcom/stepos/datacenter/core/result/DataCenterResult;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/datacenter/vector/CollectionDescriptor;Le9/c;)Ljava/lang/Object;", "", "id", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "c", "(Le9/c;)Ljava/lang/Object;", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CollectionOps {

    /* renamed from: a, reason: collision with root package name */
    public static final CollectionOps f29809a = new CollectionOps();

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(com.stepos.datacenter.vector.CollectionDescriptor r10, e9.InterfaceC4014c<? super com.stepos.datacenter.core.result.DataCenterResult<com.stepos.datacenter.vector.CollectionDescriptor>> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.datacenter.api.CollectionOps$create$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.datacenter.api.CollectionOps$create$1 r0 = (com.stepos.datacenter.api.CollectionOps$create$1) r0
            int r1 = r0.f29814e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29814e = r1
            goto L18
        L13:
            com.stepos.datacenter.api.CollectionOps$create$1 r0 = new com.stepos.datacenter.api.CollectionOps$create$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r9 = r0.f29812c
            java.lang.Object r11 = f9.C4063a.g()
            int r1 = r0.f29814e
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r10 = r0.f29811b
            e7.o r10 = (e7.o) r10
            java.lang.Object r11 = r0.f29810a
            com.stepos.datacenter.vector.CollectionDescriptor r11 = (com.stepos.datacenter.vector.CollectionDescriptor) r11
            kotlin.C4849c.b(r9)
            goto L78
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            kotlin.C4849c.b(r9)
            com.stepos.datacenter.api.DataCenter$Companion r9 = com.stepos.datacenter.api.DataCenter.INSTANCE
            e7.o r1 = r9.getVectorRegistry$sdk_release()
            if (r1 != 0) goto L52
            com.stepos.datacenter.core.result.DataCenterResult$Companion r3 = com.stepos.datacenter.core.result.DataCenterResult.INSTANCE
            com.stepos.datacenter.core.result.DataCenterError r4 = com.stepos.datacenter.core.result.DataCenterError.NOT_INITIALIZED
            r7 = 4
            r8 = 0
            java.lang.String r5 = "VectorRegistry not initialized; call DataCenter.initVectorRegistry first"
            r6 = 0
            com.stepos.datacenter.core.result.DataCenterResult$Failure r9 = com.stepos.datacenter.core.result.DataCenterResult.Companion.failure$default(r3, r4, r5, r6, r7, r8)
            return r9
        L52:
            com.stepos.datacenter.core.result.DataCenterResult r3 = r1.l(r10)
            boolean r4 = r3 instanceof com.stepos.datacenter.core.result.DataCenterResult.Failure
            if (r4 == 0) goto L5b
            return r3
        L5b:
            com.stepos.datacenter.api.DataCenter r9 = r9.getInstance$sdk_release()
            if (r9 == 0) goto L66
            e7.p r9 = r9.getVectorStorageProvider()
            goto L67
        L66:
            r9 = 0
        L67:
            if (r9 == 0) goto L87
            r0.f29810a = r10
            r0.f29811b = r1
            r0.f29814e = r2
            java.lang.Object r9 = r9.c(r10, r0)
            if (r9 != r11) goto L76
            return r11
        L76:
            r11 = r10
            r10 = r1
        L78:
            com.stepos.datacenter.core.result.DataCenterResult r9 = (com.stepos.datacenter.core.result.DataCenterResult) r9
            boolean r0 = r9 instanceof com.stepos.datacenter.core.result.DataCenterResult.Failure
            if (r0 == 0) goto L86
            java.lang.String r11 = r11.getId()
            r10.m(r11)
            return r9
        L86:
            r10 = r11
        L87:
            com.stepos.datacenter.core.result.DataCenterResult$Companion r9 = com.stepos.datacenter.core.result.DataCenterResult.INSTANCE
            com.stepos.datacenter.core.result.DataCenterResult$Success r9 = r9.ok(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.CollectionOps.a(com.stepos.datacenter.vector.CollectionDescriptor, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r10, e9.InterfaceC4014c<? super com.stepos.datacenter.core.result.DataCenterResult<Y8.t>> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.datacenter.api.CollectionOps$drop$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.datacenter.api.CollectionOps$drop$1 r0 = (com.stepos.datacenter.api.CollectionOps$drop$1) r0
            int r1 = r0.f29819e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29819e = r1
            goto L18
        L13:
            com.stepos.datacenter.api.CollectionOps$drop$1 r0 = new com.stepos.datacenter.api.CollectionOps$drop$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r9 = r0.f29817c
            java.lang.Object r11 = f9.C4063a.g()
            int r1 = r0.f29819e
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r10 = r0.f29816b
            e7.o r10 = (e7.o) r10
            java.lang.Object r11 = r0.f29815a
            java.lang.String r11 = (java.lang.String) r11
            kotlin.C4849c.b(r9)
            r1 = r10
            r10 = r11
            goto L6f
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            kotlin.C4849c.b(r9)
            com.stepos.datacenter.api.DataCenter$Companion r9 = com.stepos.datacenter.api.DataCenter.INSTANCE
            e7.o r1 = r9.getVectorRegistry$sdk_release()
            if (r1 != 0) goto L54
            com.stepos.datacenter.core.result.DataCenterResult$Companion r3 = com.stepos.datacenter.core.result.DataCenterResult.INSTANCE
            com.stepos.datacenter.core.result.DataCenterError r4 = com.stepos.datacenter.core.result.DataCenterError.NOT_INITIALIZED
            r7 = 4
            r8 = 0
            java.lang.String r5 = "VectorRegistry not initialized"
            r6 = 0
            com.stepos.datacenter.core.result.DataCenterResult$Failure r9 = com.stepos.datacenter.core.result.DataCenterResult.Companion.failure$default(r3, r4, r5, r6, r7, r8)
            return r9
        L54:
            com.stepos.datacenter.api.DataCenter r9 = r9.getInstance$sdk_release()
            if (r9 == 0) goto L5f
            e7.p r9 = r9.getVectorStorageProvider()
            goto L60
        L5f:
            r9 = 0
        L60:
            if (r9 == 0) goto L76
            r0.f29815a = r10
            r0.f29816b = r1
            r0.f29819e = r2
            java.lang.Object r9 = r9.g(r10, r0)
            if (r9 != r11) goto L6f
            return r11
        L6f:
            com.stepos.datacenter.core.result.DataCenterResult r9 = (com.stepos.datacenter.core.result.DataCenterResult) r9
            boolean r11 = r9 instanceof com.stepos.datacenter.core.result.DataCenterResult.Failure
            if (r11 == 0) goto L76
            return r9
        L76:
            com.stepos.datacenter.core.result.DataCenterResult r9 = r1.m(r10)
            boolean r10 = r9 instanceof com.stepos.datacenter.core.result.DataCenterResult.Failure
            if (r10 == 0) goto L92
            r10 = r9
            com.stepos.datacenter.core.result.DataCenterResult$Failure r10 = (com.stepos.datacenter.core.result.DataCenterResult.Failure) r10
            com.stepos.datacenter.core.result.DataCenterError r10 = r10.getError()
            com.stepos.datacenter.core.result.DataCenterError r11 = com.stepos.datacenter.core.result.DataCenterError.VECTOR_COLLECTION_NOT_FOUND
            if (r10 != r11) goto L91
            com.stepos.datacenter.core.result.DataCenterResult$Companion r9 = com.stepos.datacenter.core.result.DataCenterResult.INSTANCE
            Y8.t r10 = Y8.t.f7040a
            com.stepos.datacenter.core.result.DataCenterResult$Success r9 = r9.ok(r10)
        L91:
            return r9
        L92:
            com.stepos.datacenter.core.result.DataCenterResult$Companion r9 = com.stepos.datacenter.core.result.DataCenterResult.INSTANCE
            Y8.t r10 = Y8.t.f7040a
            com.stepos.datacenter.core.result.DataCenterResult$Success r9 = r9.ok(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.CollectionOps.b(java.lang.String, e9.c):java.lang.Object");
    }

    public final Object c(InterfaceC4014c<? super DataCenterResult<t>> interfaceC4014c) {
        p vectorStorageProvider;
        DataCenter instance$sdk_release = DataCenter.INSTANCE.getInstance$sdk_release();
        return (instance$sdk_release == null || (vectorStorageProvider = instance$sdk_release.getVectorStorageProvider()) == null) ? DataCenterResult.INSTANCE.ok(t.f7040a) : vectorStorageProvider.a(interfaceC4014c);
    }
}
