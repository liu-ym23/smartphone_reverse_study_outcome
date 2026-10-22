package com.stepos.policy.sdk;

import android.content.Context;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class N extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f12043a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12044b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f12045c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(Context context, String str, Continuation continuation) {
        super(2, continuation);
        this.f12044b = str;
        this.f12045c = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new N(this.f12045c, this.f12044b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String str = this.f12044b;
        return new N(this.f12045c, str, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12043a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder("result = ");
            String str = this.f12044b;
            sb.append(str);
            companion.d("getCommonDeleteInfoList", sb.toString());
            Context context = this.f12045c;
            if (context != null) {
                PolicyManager policyManager = PolicyManager.INSTANCE;
                V.f fVar = b0.f12129g;
                this.f12043a = 1;
                if (policyManager.saveDataStoreString(context, fVar, str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
