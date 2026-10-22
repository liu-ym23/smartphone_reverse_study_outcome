package com.stepos.policy.sdk;

import android.content.Context;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.stepos.policy.sdk.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0512k extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12205a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f12206b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f12207c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0512k(int i4, Continuation continuation) {
        super(2, continuation);
        this.f12206b = i4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.f12205a) {
            case 0:
                return new C0512k((Context) this.f12207c, continuation);
            default:
                C0512k c0512k = new C0512k(this.f12206b, continuation);
                c0512k.f12207c = obj;
                return c0512k;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f12205a) {
            case 0:
                return new C0512k((Context) this.f12207c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
            default:
                C0512k c0512k = new C0512k(this.f12206b, (Continuation) obj2);
                c0512k.f12207c = (V.b) obj;
                return c0512k.invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.f12205a) {
            case 0:
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i4 = this.f12206b;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    S.y yVar = new S.y(b0.a((Context) this.f12207c).b(), 3);
                    this.f12206b = 1;
                    obj = Z2.I.k(yVar, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Integer num = (Integer) obj;
                return num == null ? Boxing.boxInt(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_DISAGREE) : num;
            default:
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                V.b bVar = (V.b) this.f12207c;
                V.f key = b0.f12128f;
                Integer numBoxInt = Boxing.boxInt(this.f12206b);
                bVar.getClass();
                Intrinsics.checkNotNullParameter(key, "key");
                bVar.d(key, numBoxInt);
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0512k(Context context, Continuation continuation) {
        super(2, continuation);
        this.f12207c = context;
    }
}
