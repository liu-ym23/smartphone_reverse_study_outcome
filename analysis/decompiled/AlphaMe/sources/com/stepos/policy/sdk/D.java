package com.stepos.policy.sdk;

import android.content.Context;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public final class D extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f11985a;

    /* renamed from: b, reason: collision with root package name */
    public PolicyNewestPathResultBean f11986b;

    /* renamed from: c, reason: collision with root package name */
    public Ref.ObjectRef f11987c;

    /* renamed from: d, reason: collision with root package name */
    public int f11988d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f11989e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f11990f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f11991g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f11992h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f11993i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Function1 f11994j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f11995k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f11996l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(Context context, String str, boolean z4, String str2, String str3, Function1 function1, String str4, String str5, Continuation continuation) {
        super(2, continuation);
        this.f11989e = context;
        this.f11990f = str;
        this.f11991g = z4;
        this.f11992h = str2;
        this.f11993i = str3;
        this.f11994j = function1;
        this.f11995k = str4;
        this.f11996l = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new D(this.f11989e, this.f11990f, this.f11991g, this.f11992h, this.f11993i, this.f11994j, this.f11995k, this.f11996l, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((D) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c0  */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, com.stepos.policy.sdk.bean.PolicySdkResultBean] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.D.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
