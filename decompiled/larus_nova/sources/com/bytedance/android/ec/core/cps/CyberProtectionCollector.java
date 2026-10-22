package com.bytedance.android.ec.core.cps;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class CyberProtectionCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CyberProtectionCollector f43916a = null;

    public CyberProtectionCollector() {
    }

    static {
        f43916a = new CyberProtectionCollector();
    }

    public final Object a(Continuation<? super String> r100) {
        if ((r100 instanceof CyberProtectionCollector$signHash$1) == false) goto L7;
        CyberProtectionCollector$signHash$1 r101 = (CyberProtectionCollector$signHash$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        String r106 = (String) r103;
        if (com.bytedance.android.shopping.extensions.k.c(r106) == true) goto L22;
        return null;
    L22:
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r101.label = 1;
        r103 = b.i(r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new CyberProtectionCollector$signHash$1(this, r100);
        goto L8
    }
}
