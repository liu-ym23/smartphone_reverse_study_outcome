package com.stepos.policy.sdk;

import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class g0 extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public PolicySdkResultBean f12174a;

    /* renamed from: b, reason: collision with root package name */
    public int f12175b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12176c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Long f12177d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12178e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f12179f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f12180g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Function1 f12181h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f12182i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(String str, Long l4, String str2, String str3, String str4, Function1 function1, String str5, Continuation continuation) {
        super(2, continuation);
        this.f12176c = str;
        this.f12177d = l4;
        this.f12178e = str2;
        this.f12179f = str3;
        this.f12180g = str4;
        this.f12181h = function1;
        this.f12182i = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new g0(this.f12176c, this.f12177d, this.f12178e, this.f12179f, this.f12180g, this.f12181h, this.f12182i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((g0) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|74|(1:(3:5|6|7)(2:10|11))(3:12|13|(5:66|61|54|64|65)(8:19|20|72|21|22|68|23|(1:25)))|26|75|(6:70|28|(1:51)(6:32|33|34|(1:36)|39|(4:41|(1:45)|46|(1:48)))|52|53|54)(0)|64|65|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fe, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013d A[Catch: all -> 0x00fe, TryCatch #5 {all -> 0x00fe, blocks: (B:34:0x00f0, B:36:0x00fb, B:39:0x0103, B:41:0x0109, B:43:0x0113, B:45:0x0119, B:46:0x0123, B:48:0x0129, B:52:0x0148, B:51:0x013d), top: B:75:0x00b4 }] */
    /* JADX WARN: Type inference failed for: r0v18, types: [T, com.stepos.policy.sdk.bean.PolicyNewestResponse] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.stepos.policy.sdk.e0, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.g0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
