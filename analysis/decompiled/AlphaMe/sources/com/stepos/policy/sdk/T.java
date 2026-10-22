package com.stepos.policy.sdk;

import b3.InterfaceC0379h;
import b3.InterfaceC0380i;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public final class T implements InterfaceC0379h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12053a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0379h f12054b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12055c;

    public /* synthetic */ T(InterfaceC0379h interfaceC0379h, Object obj, int i4) {
        this.f12053a = i4;
        this.f12054b = interfaceC0379h;
        this.f12055c = obj;
    }

    @Override // b3.InterfaceC0379h
    public final Object collect(InterfaceC0380i interfaceC0380i, Continuation continuation) {
        int i4 = this.f12053a;
        InterfaceC0379h interfaceC0379h = this.f12054b;
        Object obj = this.f12055c;
        switch (i4) {
            case 0:
                Object objCollect = interfaceC0379h.collect(new x0.i(1, interfaceC0380i, (V.f) obj), continuation);
                if (objCollect != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    break;
                }
                break;
            case 1:
                Object objCollect2 = interfaceC0379h.collect(new x0.i(2, interfaceC0380i, (String) obj), continuation);
                if (objCollect2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    break;
                }
                break;
            default:
                Object objCollect3 = interfaceC0379h.collect(new b3.t(new Ref.BooleanRef(), interfaceC0380i, (Function2) obj), continuation);
                if (objCollect3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    break;
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
