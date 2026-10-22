package com.stepos.policy.sdk;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class r extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f12245a;

    /* renamed from: b, reason: collision with root package name */
    public int f12246b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f12247c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PolicyManager f12248d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context, PolicyManager policyManager, Continuation continuation) {
        super(2, continuation);
        this.f12247c = context;
        this.f12248d = policyManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new r(this.f12247c, this.f12248d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new r(this.f12247c, this.f12248d, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.f12246b
            java.lang.String r2 = "isNeedReTry= "
            java.lang.String r3 = "reTryUploadRecord"
            android.content.Context r4 = r8.f12247c
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L26
            if (r1 == r6) goto L22
            if (r1 != r5) goto L1a
            int r0 = r8.f12245a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5d
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L22:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L34
        L26:
            kotlin.ResultKt.throwOnFailure(r9)
            com.stepos.policy.sdk.PolicyManager r9 = com.stepos.policy.sdk.PolicyManager.INSTANCE
            r8.f12246b = r6
            java.lang.Object r9 = r9.getPolicyOperate(r4, r8)
            if (r9 != r0) goto L34
            return r0
        L34:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r9 = r9 ^ r6
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r2)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r1.d(r3, r7)
            if (r9 == 0) goto La6
            com.stepos.policy.sdk.PolicyManager r1 = com.stepos.policy.sdk.PolicyManager.INSTANCE
            r8.f12245a = r9
            r8.f12246b = r5
            java.lang.Object r1 = r1.getPolicyOperateJson(r4, r8)
            if (r1 != r0) goto L5b
            return r0
        L5b:
            r0 = r9
            r9 = r1
        L5d:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto La6
            int r1 = r9.length()
            if (r1 <= 0) goto La6
            F1.n r1 = new F1.n
            r1.<init>()
            java.lang.Class<com.stepos.policy.sdk.bean.PolicyRecordRequest> r7 = com.stepos.policy.sdk.bean.PolicyRecordRequest.class
            java.lang.Object r9 = r1.b(r7, r9)
            com.stepos.policy.sdk.bean.PolicyRecordRequest r9 = (com.stepos.policy.sdk.bean.PolicyRecordRequest) r9
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r2)
            if (r0 == 0) goto L7e
            goto L7f
        L7e:
            r6 = 0
        L7f:
            r7.append(r6)
            java.lang.String r0 = r7.toString()
            r1.d(r3, r0)
            com.stepos.policy.sdk.PolicyManager r0 = com.stepos.policy.sdk.PolicyManager.INSTANCE
            java.lang.String r1 = r0.getMAppId()
            java.lang.String r2 = r0.getMAppSecret()
            java.lang.String r0 = r0.getMAppVersionName()
            java.lang.String r3 = "policyRecordRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            androidx.room.b r3 = new androidx.room.b
            com.stepos.policy.sdk.PolicyManager r8 = r8.f12248d
            r3.<init>(r5, r8, r4)
            com.stepos.policy.sdk.PolicyManager.uploadPolicyOperateRecord(r1, r2, r0, r9, r3)
        La6:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.r.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
