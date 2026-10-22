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

/* renamed from: com.stepos.policy.sdk.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0522v extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f12271a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12272b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12273c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f12274d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0522v(Context context, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.f12272b = str;
        this.f12273c = str2;
        this.f12274d = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0522v(this.f12274d, this.f12272b, this.f12273c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0522v) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12271a;
        try {
        } catch (Exception e4) {
            PolicySdkLogUtils.INSTANCE.e("saveLocalCategoryMd5", "error =" + e4 + ' ');
        }
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder("the ");
            String str = this.f12272b;
            sb.append(str);
            sb.append(" save local md5 is ");
            String str2 = this.f12273c;
            sb.append(str2);
            companion.d("saveLocalCategoryMd5", sb.toString());
            if (str2 != null) {
                if (str2.length() != 0) {
                    InterfaceC0103i interfaceC0103iA = b0.a(this.f12274d);
                    C0521u c0521u = new C0521u(str, str2, null);
                    this.f12271a = 1;
                    if (AbstractC0557a.r(interfaceC0103iA, c0521u, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }
}
