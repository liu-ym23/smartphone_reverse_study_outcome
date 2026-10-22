package com.stepos.datacenter.api;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.datacenter.vector.VectorEntry;
import com.stepos.datacenter.vector.VectorStoreManager;
import e9.InterfaceC4014c;
import g9.C4109a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ*\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/datacenter/api/VectorWriteOps;", "", "<init>", "()V", "Lcom/stepos/datacenter/api/DataCenter;", "inst", "Lcom/stepos/datacenter/vector/VectorEntry;", "entry", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/datacenter/api/DataCenter;Lcom/stepos/datacenter/vector/VectorEntry;Le9/c;)Ljava/lang/Object;", Const.LBS_FAIL_BD_ENTITY, "entityId", Const.INTENT_KEY_UMID, "(Lcom/stepos/datacenter/api/DataCenter;Ljava/lang/Object;Ljava/lang/Long;Le9/c;)Ljava/lang/Object;", "id", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(JLe9/c;)Ljava/lang/Object;", "", "collection", "Lcom/stepos/datacenter/vector/EmbedProvider;", Const.JSON_KEY_PROVIDER, "c", "(Ljava/lang/String;Lcom/stepos/datacenter/vector/EmbedProvider;Le9/c;)Ljava/lang/Object;", "", C3081a.FOCUS_MAP_NAME, "e", "(Ljava/util/Map;)Ljava/lang/String;", "Lcom/stepos/datacenter/vector/VectorStoreManager;", "f", "()Lcom/stepos/datacenter/vector/VectorStoreManager;", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VectorWriteOps {

    /* renamed from: a, reason: collision with root package name */
    public static final VectorWriteOps f29954a = new VectorWriteOps();

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r5, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.datacenter.api.VectorWriteOps$deleteVector$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.datacenter.api.VectorWriteOps$deleteVector$1 r0 = (com.stepos.datacenter.api.VectorWriteOps$deleteVector$1) r0
            int r1 = r0.f29957c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29957c = r1
            goto L18
        L13:
            com.stepos.datacenter.api.VectorWriteOps$deleteVector$1 r0 = new com.stepos.datacenter.api.VectorWriteOps$deleteVector$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f29955a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f29957c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L41
            goto L49
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r7)
            com.stepos.datacenter.vector.VectorStoreManager r4 = r4.f()     // Catch: java.lang.Throwable -> L41
            r0.f29957c = r3     // Catch: java.lang.Throwable -> L41
            java.lang.Object r4 = r4.f(r5, r0)     // Catch: java.lang.Throwable -> L41
            if (r4 != r1) goto L49
            return r1
        L41:
            r4 = move-exception
            java.lang.String r5 = "DataCenter"
            java.lang.String r6 = "deleteVector failed"
            android.util.Log.e(r5, r6, r4)
        L49:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.VectorWriteOps.b(long, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r24, com.stepos.datacenter.vector.EmbedProvider r25, e9.InterfaceC4014c<? super Y8.t> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.VectorWriteOps.c(java.lang.String, com.stepos.datacenter.vector.EmbedProvider, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0174, code lost:
    
        if (r0.d(r14, r6, r7, r8) == r2) goto L96;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0273 A[Catch: all -> 0x02a5, PHI: r0 r1 r3 r4 r12 r15 r16
      0x0273: PHI (r0v44 java.lang.Object) = (r0v40 java.lang.Object), (r0v1 java.lang.Object) binds: [B:91:0x0270, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0273: PHI (r1v12 U6.a$b) = (r1v7 U6.a$b), (r1v22 U6.a$b) binds: [B:91:0x0270, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0273: PHI (r3v11 com.stepos.datacenter.api.DataCenter) = (r3v9 com.stepos.datacenter.api.DataCenter), (r3v18 com.stepos.datacenter.api.DataCenter) binds: [B:91:0x0270, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0273: PHI (r4v11 com.stepos.datacenter.api.VectorWriteOps) = (r4v10 com.stepos.datacenter.api.VectorWriteOps), (r4v18 com.stepos.datacenter.api.VectorWriteOps) binds: [B:91:0x0270, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0273: PHI (r12v14 java.lang.String) = (r12v11 java.lang.String), (r12v19 java.lang.String) binds: [B:91:0x0270, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0273: PHI (r15v10 java.lang.Object) = (r15v9 java.lang.Object), (r15v13 java.lang.Object) binds: [B:91:0x0270, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0273: PHI (r16v13 long) = (r16v10 long), (r16v18 long) binds: [B:91:0x0270, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {all -> 0x02a5, blocks: (B:93:0x0273, B:90:0x025f), top: B:109:0x025f }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a4 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(com.stepos.datacenter.api.DataCenter r31, java.lang.Object r32, java.lang.Long r33, e9.InterfaceC4014c<? super java.lang.Long> r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.VectorWriteOps.d(com.stepos.datacenter.api.DataCenter, java.lang.Object, java.lang.Long, e9.c):java.lang.Object");
    }

    public final String e(Map<String, ? extends Object> map) throws JSONException {
        if (map.isEmpty()) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        String string = jSONObject.toString();
        p.h(string, "toString(...)");
        return string;
    }

    public final VectorStoreManager f() {
        VectorStoreManager vectorStoreManager$sdk_release = DataCenter.INSTANCE.getVectorStoreManager$sdk_release();
        if (vectorStoreManager$sdk_release == null) {
            throw new IllegalStateException("Call DataCenter.initVectorStore(dimension=N) first.");
        }
        if (vectorStoreManager$sdk_release.getInitialized()) {
            return vectorStoreManager$sdk_release;
        }
        throw new IllegalStateException("VectorStore is still initializing. Wait for isVectorStoreEnabled() and manager.isReady().");
    }

    public final Object g(DataCenter dataCenter, VectorEntry vectorEntry, InterfaceC4014c<? super Long> interfaceC4014c) {
        return DispatchKt.a("vector.store", C4109a.g(-1L), new VectorWriteOps$storeVector$2(dataCenter, vectorEntry, null), interfaceC4014c);
    }
}
