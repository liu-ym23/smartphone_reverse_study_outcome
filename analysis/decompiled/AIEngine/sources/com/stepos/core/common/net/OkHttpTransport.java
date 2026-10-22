package com.stepos.core.common.net;

import ad.l;
import ad.n;
import ad.s;
import bd.d;
import com.stepos.core.common.net.HttpBody;
import dc.e;
import dc.h;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import mb.m;
import mb.t;
import mb.v;
import okhttp3.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OkHttpTransport implements HttpTransport {
    private final n base;

    public OkHttpTransport(n base) {
        g.f(base, "base");
        this.base = base;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> toMap(f fVar) {
        e eVarE0 = h.e0(0, fVar.size());
        int iA0 = v.a0(m.Z(eVarE0, 10));
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        Iterator<Integer> it = eVarE0.iterator();
        while (it.hasNext()) {
            int iNextInt = ((t) it).nextInt();
            linkedHashMap.put(fVar.b(iNextInt), fVar.g(iNextInt));
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final s toOkHttp(HttpBody httpBody) {
        if (httpBody instanceof HttpBody.Text) {
            s.a aVar = s.Companion;
            HttpBody.Text text = (HttpBody.Text) httpBody;
            String content = text.getContent();
            String contentType = text.getContentType();
            g.f(contentType, "<this>");
            l lVarA = d.a(contentType);
            aVar.getClass();
            return s.a.b(content, lVarA);
        }
        if (!(httpBody instanceof HttpBody.Bytes)) {
            throw new NoWhenBranchMatchedException();
        }
        s.a aVar2 = s.Companion;
        HttpBody.Bytes bytes = (HttpBody.Bytes) httpBody;
        byte[] content2 = bytes.getContent();
        String contentType2 = bytes.getContentType();
        g.f(contentType2, "<this>");
        return s.a.c(aVar2, content2, d.a(contentType2), 0, 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.common.net.HttpTransport
    /* renamed from: execute-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo102executegIAlus(com.stepos.core.common.net.HttpRequest r6, qb.b<? super kotlin.Result<com.stepos.core.common.net.HttpResponse>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.core.common.net.OkHttpTransport$execute$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.common.net.OkHttpTransport$execute$1 r0 = (com.stepos.core.common.net.OkHttpTransport$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.common.net.OkHttpTransport$execute$1 r0 = new com.stepos.core.common.net.OkHttpTransport$execute$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r7)
            goto L45
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.c.b(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.common.net.OkHttpTransport$execute$2 r2 = new com.stepos.core.common.net.OkHttpTransport$execute$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.f9987a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.net.OkHttpTransport.mo102executegIAlus(com.stepos.core.common.net.HttpRequest, qb.b):java.lang.Object");
    }
}
