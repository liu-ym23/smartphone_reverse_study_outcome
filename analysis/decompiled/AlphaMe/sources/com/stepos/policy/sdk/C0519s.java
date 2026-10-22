package com.stepos.policy.sdk;

import S.InterfaceC0103i;
import android.content.Context;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import f1.AbstractC0557a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: com.stepos.policy.sdk.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0519s extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f12249a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f12250b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12251c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0519s(Context context, int i4, Continuation continuation) {
        super(2, continuation);
        this.f12250b = context;
        this.f12251c = i4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0519s(this.f12250b, this.f12251c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C0519s(this.f12250b, this.f12251c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12249a;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0103i interfaceC0103iA = b0.a(this.f12250b);
                C0512k c0512k = new C0512k(this.f12251c, (Continuation) null);
                this.f12249a = 1;
                if (AbstractC0557a.r(interfaceC0103iA, c0512k, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e4) {
            PolicySdkLogUtils.INSTANCE.e("savePolicyCategoryVersion", "error =" + e4 + ' ');
        }
        return Unit.INSTANCE;
    }
}
