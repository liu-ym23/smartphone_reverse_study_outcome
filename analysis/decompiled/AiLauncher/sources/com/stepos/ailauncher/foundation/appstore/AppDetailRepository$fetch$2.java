package com.stepos.ailauncher.foundation.appstore;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.foundation.appstore.api.AppDetail;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appstore.AppDetailRepository$fetch$2", f = "AppDetailRepository.kt", l = {119, 125}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AppDetailRepository$fetch$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ InterfaceC5074l<AppDetail, t> $onResult;
    final /* synthetic */ String $packageName;
    Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appstore.AppDetailRepository$fetch$2$1", f = "AppDetailRepository.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.foundation.appstore.AppDetailRepository$fetch$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ InterfaceC5074l<AppDetail, t> $onResult;
        final /* synthetic */ AppDetail $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super AppDetail, t> interfaceC5074l, AppDetail appDetail, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onResult = interfaceC5074l;
            this.$result = appDetail;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$onResult, this.$result, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$onResult.invoke(this.$result);
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppDetailRepository$fetch$2(String str, InterfaceC5074l<? super AppDetail, t> interfaceC5074l, InterfaceC4014c<? super AppDetailRepository$fetch$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$packageName = str;
        this.$onResult = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AppDetailRepository$fetch$2(this.$packageName, this.$onResult, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AppDetailRepository$fetch$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0069, code lost:
    
        if (Ua.C1056g.j(r1, r3, r6) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r6 = r6.L$0
            com.stepos.ailauncher.foundation.appstore.api.AppDetail r6 = (com.stepos.ailauncher.foundation.appstore.api.AppDetail) r6
            kotlin.C4849c.b(r7)
            goto L6c
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1e:
            kotlin.C4849c.b(r7)
            goto L32
        L22:
            kotlin.C4849c.b(r7)
            com.stepos.ailauncher.foundation.appstore.AppDetailRepository r7 = com.stepos.ailauncher.foundation.appstore.AppDetailRepository.INSTANCE
            java.lang.String r1 = r6.$packageName
            r6.label = r3
            java.lang.Object r7 = com.stepos.ailauncher.foundation.appstore.AppDetailRepository.c(r7, r1, r6)
            if (r7 != r0) goto L32
            goto L6b
        L32:
            com.stepos.ailauncher.foundation.appstore.api.AppDetail r7 = (com.stepos.ailauncher.foundation.appstore.api.AppDetail) r7
            if (r7 != 0) goto L48
            java.util.concurrent.ConcurrentHashMap r1 = com.stepos.ailauncher.foundation.appstore.AppDetailRepository.f()
            java.lang.String r3 = r6.$packageName
            long r4 = android.os.SystemClock.elapsedRealtime()
            java.lang.Long r4 = g9.C4109a.g(r4)
            r1.put(r3, r4)
            goto L51
        L48:
            java.util.concurrent.ConcurrentHashMap r1 = com.stepos.ailauncher.foundation.appstore.AppDetailRepository.f()
            java.lang.String r3 = r6.$packageName
            r1.remove(r3)
        L51:
            Ua.A0 r1 = Ua.Y.c()
            com.stepos.ailauncher.foundation.appstore.AppDetailRepository$fetch$2$1 r3 = new com.stepos.ailauncher.foundation.appstore.AppDetailRepository$fetch$2$1
            p9.l<com.stepos.ailauncher.foundation.appstore.api.AppDetail, Y8.t> r4 = r6.$onResult
            r5 = 0
            r3.<init>(r4, r7, r5)
            java.lang.Object r7 = g9.h.a(r7)
            r6.L$0 = r7
            r6.label = r2
            java.lang.Object r6 = Ua.C1056g.j(r1, r3, r6)
            if (r6 != r0) goto L6c
        L6b:
            return r0
        L6c:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.AppDetailRepository$fetch$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
