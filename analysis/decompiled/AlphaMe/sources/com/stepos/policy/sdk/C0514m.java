package com.stepos.policy.sdk;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: com.stepos.policy.sdk.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0514m extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f12225a;

    /* renamed from: b, reason: collision with root package name */
    public String f12226b;

    /* renamed from: c, reason: collision with root package name */
    public int f12227c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HashMap f12228d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f12229e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0514m(HashMap map, Context context, Continuation continuation) {
        super(2, continuation);
        this.f12228d = map;
        this.f12229e = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0514m(this.f12228d, this.f12229e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C0514m(this.f12228d, this.f12229e, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0084 -> B:14:0x0087). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f12227c
            java.lang.String r2 = " *************** policyKey = "
            r3 = 1
            java.lang.String r4 = "initSDK"
            if (r1 == 0) goto L1f
            if (r1 != r3) goto L17
            java.lang.String r1 = r9.f12226b
            java.util.Iterator r5 = r9.f12225a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L87
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L1f:
            kotlin.ResultKt.throwOnFailure(r10)
            com.stepos.policy.sdk.PolicyManager r10 = com.stepos.policy.sdk.PolicyManager.INSTANCE
            r1 = 0
            r10.setSyncLocalFileFinished(r1)
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r10 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r5 = "syncLocalFileFinished start time = "
            r1.<init>(r5)
            long r5 = java.lang.System.currentTimeMillis()
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r10.d(r4, r1)
            java.util.HashMap r10 = r9.f12228d
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
            r5 = r10
        L4a:
            boolean r10 = r5.hasNext()
            if (r10 == 0) goto L9e
            java.lang.Object r10 = r5.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r1 = r10.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r10 = r10.getValue()
            java.lang.String r10 = (java.lang.String) r10
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r2)
            r7.append(r1)
            java.lang.String r8 = " start***************"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.d(r4, r7)
            r9.f12225a = r5
            r9.f12226b = r1
            r9.f12227c = r3
            android.content.Context r6 = r9.f12229e
            java.lang.Object r10 = com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(r6, r10, r1, r9)
            if (r10 != r0) goto L87
            return r0
        L87:
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r10 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r2)
            r6.append(r1)
            java.lang.String r1 = " end ***************"
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r10.d(r4, r1)
            goto L4a
        L9e:
            com.stepos.policy.sdk.PolicyManager r9 = com.stepos.policy.sdk.PolicyManager.INSTANCE
            r9.setSyncLocalFileFinished(r3)
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r9 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "syncLocalFileFinished end time = "
            r10.<init>(r0)
            long r0 = java.lang.System.currentTimeMillis()
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.d(r4, r10)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.C0514m.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
