package com.stepos.datacenter.api;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001aD\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u00002\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0080@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "scope", "fallback", "Lkotlin/Function1;", "Le9/c;", "", "block", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/Object;Lp9/l;Le9/c;)Ljava/lang/Object;", "sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispatchKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object a(java.lang.String r4, T r5, p9.InterfaceC5074l<? super e9.InterfaceC4014c<? super T>, ? extends java.lang.Object> r6, e9.InterfaceC4014c<? super T> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.stepos.datacenter.api.DispatchKt$dispatch$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.datacenter.api.DispatchKt$dispatch$1 r0 = (com.stepos.datacenter.api.DispatchKt$dispatch$1) r0
            int r1 = r0.f29847d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29847d = r1
            goto L18
        L13:
            com.stepos.datacenter.api.DispatchKt$dispatch$1 r0 = new com.stepos.datacenter.api.DispatchKt$dispatch$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f29846c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f29847d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f29845b
            java.lang.Object r4 = r0.f29844a
            java.lang.String r4 = (java.lang.String) r4
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L2f
            return r7
        L2f:
            r6 = move-exception
            goto L4a
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.C4849c.b(r7)
            r0.f29844a = r4     // Catch: java.lang.Throwable -> L2f
            r0.f29845b = r5     // Catch: java.lang.Throwable -> L2f
            r0.f29847d = r3     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r4 = r6.invoke(r0)     // Catch: java.lang.Throwable -> L2f
            if (r4 != r1) goto L49
            return r1
        L49:
            return r4
        L4a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r4 = " failed"
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            java.lang.String r7 = "DataCenter"
            android.util.Log.e(r7, r4, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.DispatchKt.a(java.lang.String, java.lang.Object, p9.l, e9.c):java.lang.Object");
    }
}
