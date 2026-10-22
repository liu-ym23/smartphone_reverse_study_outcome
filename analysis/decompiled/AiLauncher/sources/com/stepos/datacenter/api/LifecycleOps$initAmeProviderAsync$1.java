package com.stepos.datacenter.api;

import Ua.M;
import Y8.t;
import android.content.Context;
import e7.o;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.api.LifecycleOps$initAmeProviderAsync$1", f = "LifecycleOps.kt", l = {67, 83}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LifecycleOps$initAmeProviderAsync$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29882a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29883b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29884c;

    /* renamed from: d, reason: collision with root package name */
    public Object f29885d;

    /* renamed from: e, reason: collision with root package name */
    public int f29886e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Context f29887f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Integer f29888g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleOps$initAmeProviderAsync$1(Context context, Integer num, InterfaceC4014c<? super LifecycleOps$initAmeProviderAsync$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29887f = context;
        this.f29888g = num;
    }

    public static final o h() {
        return DataCenter.INSTANCE.getVectorRegistry$sdk_release();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new LifecycleOps$initAmeProviderAsync$1(this.f29887f, this.f29888g, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((LifecycleOps$initAmeProviderAsync$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0121, code lost:
    
        if (r13 == r0) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010c A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:7:0x0021, B:56:0x0124, B:59:0x012c, B:51:0x0106, B:53:0x010c, B:60:0x0154, B:62:0x0158, B:63:0x018d, B:64:0x0192, B:14:0x0037, B:27:0x0067, B:29:0x006f, B:30:0x007a, B:33:0x0082, B:35:0x0088, B:37:0x0092, B:39:0x00ac, B:41:0x00b3, B:42:0x00b7, B:44:0x00d4, B:45:0x00e3, B:47:0x00e9, B:49:0x00fc, B:50:0x0100), top: B:81:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019b A[DONT_GENERATE, PHI: r12
      0x019b: PHI (r12v9 Ua.u<java.lang.Boolean>) = (r12v6 Ua.u<java.lang.Boolean>), (r12v20 Ua.u<java.lang.Boolean>) binds: [B:71:0x01b3, B:66:0x0199] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0121 -> B:56:0x0124). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.LifecycleOps$initAmeProviderAsync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
