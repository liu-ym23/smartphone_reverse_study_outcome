package com.stepos.ailauncher.chat.manager;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.manager.ClawVMManager$createVM$1", f = "ClawVMManager.kt", l = {254, 267, 287}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ClawVMManager$createVM$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $inviteCode;
    final /* synthetic */ String $token;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ClawVMManager this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.manager.ClawVMManager$createVM$1$2", f = "ClawVMManager.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.manager.ClawVMManager$createVM$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClawVMManager$createVM$1(ClawVMManager clawVMManager, String str, String str2, InterfaceC4014c<? super ClawVMManager$createVM$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = clawVMManager;
        this.$token = str;
        this.$inviteCode = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ClawVMManager$createVM$1(this.this$0, this.$token, this.$inviteCode, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ClawVMManager$createVM$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x01cf, code lost:
    
        if (Ua.C1056g.j(r1, r2, r14) != r0) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0168 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:11:0x0032, B:35:0x00ff, B:37:0x0133, B:42:0x013d, B:44:0x0168, B:45:0x0173, B:47:0x0179, B:50:0x0185, B:14:0x003a, B:24:0x0077, B:26:0x00cf, B:29:0x00dd, B:32:0x00e9, B:51:0x018f, B:17:0x0041, B:21:0x0052), top: B:58:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0179 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:11:0x0032, B:35:0x00ff, B:37:0x0133, B:42:0x013d, B:44:0x0168, B:45:0x0173, B:47:0x0179, B:50:0x0185, B:14:0x003a, B:24:0x0077, B:26:0x00cf, B:29:0x00dd, B:32:0x00e9, B:51:0x018f, B:17:0x0041, B:21:0x0052), top: B:58:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0185 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:11:0x0032, B:35:0x00ff, B:37:0x0133, B:42:0x013d, B:44:0x0168, B:45:0x0173, B:47:0x0179, B:50:0x0185, B:14:0x003a, B:24:0x0077, B:26:0x00cf, B:29:0x00dd, B:32:0x00e9, B:51:0x018f, B:17:0x0041, B:21:0x0052), top: B:58:0x0011 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ClawVMManager$createVM$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
