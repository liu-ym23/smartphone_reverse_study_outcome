package com.stepos.ailauncher.foundation.appstore;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository$hasTask$3", f = "DownloadTaskRepository.kt", l = {90, 91}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class DownloadTaskRepository$hasTask$3 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ InterfaceC5074l<Boolean, t> $onResult;
    final /* synthetic */ String $packageName;
    Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository$hasTask$3$1", f = "DownloadTaskRepository.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository$hasTask$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ InterfaceC5074l<Boolean, t> $onResult;
        final /* synthetic */ String $packageName;
        final /* synthetic */ Set<String> $pkgs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super Boolean, t> interfaceC5074l, Set<String> set, String str, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onResult = interfaceC5074l;
            this.$pkgs = set;
            this.$packageName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$onResult, this.$pkgs, this.$packageName, interfaceC4014c);
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
            this.$onResult.invoke(C4109a.a(this.$pkgs.contains(this.$packageName)));
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadTaskRepository$hasTask$3(InterfaceC5074l<? super Boolean, t> interfaceC5074l, String str, InterfaceC4014c<? super DownloadTaskRepository$hasTask$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$onResult = interfaceC5074l;
        this.$packageName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DownloadTaskRepository$hasTask$3(this.$onResult, this.$packageName, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((DownloadTaskRepository$hasTask$3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        if (Ua.C1056g.j(r1, r3, r7) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r7 = r7.L$0
            java.util.Set r7 = (java.util.Set) r7
            kotlin.C4849c.b(r8)
            goto L4f
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1e:
            kotlin.C4849c.b(r8)
            goto L30
        L22:
            kotlin.C4849c.b(r8)
            com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository r8 = com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository.INSTANCE
            r7.label = r3
            java.lang.Object r8 = com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository.a(r8, r7)
            if (r8 != r0) goto L30
            goto L4e
        L30:
            java.util.Set r8 = (java.util.Set) r8
            Ua.A0 r1 = Ua.Y.c()
            com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository$hasTask$3$1 r3 = new com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository$hasTask$3$1
            p9.l<java.lang.Boolean, Y8.t> r4 = r7.$onResult
            java.lang.String r5 = r7.$packageName
            r6 = 0
            r3.<init>(r4, r8, r5, r6)
            java.lang.Object r8 = g9.h.a(r8)
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r7 = Ua.C1056g.j(r1, r3, r7)
            if (r7 != r0) goto L4f
        L4e:
            return r0
        L4f:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository$hasTask$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
