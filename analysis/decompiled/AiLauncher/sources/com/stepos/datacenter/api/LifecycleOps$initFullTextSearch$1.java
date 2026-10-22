package com.stepos.datacenter.api;

import Ua.M;
import Y8.t;
import android.content.Context;
import android.util.Log;
import b7.C1453a;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.api.LifecycleOps$initFullTextSearch$1", f = "LifecycleOps.kt", l = {121}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LifecycleOps$initFullTextSearch$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29889a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f29890b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleOps$initFullTextSearch$1(Context context, InterfaceC4014c<? super LifecycleOps$initFullTextSearch$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29890b = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new LifecycleOps$initFullTextSearch$1(this.f29890b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((LifecycleOps$initFullTextSearch$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f29889a;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                C1453a c1453aA = C1453a.INSTANCE.a(this.f29890b);
                this.f29889a = 1;
                if (c1453aA.e(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            Log.d("DataCenter", "FTS components initialized successfully");
        } catch (Exception e10) {
            Log.e("DataCenter", "FTS initialization failed", e10);
        }
        return t.f7040a;
    }
}
