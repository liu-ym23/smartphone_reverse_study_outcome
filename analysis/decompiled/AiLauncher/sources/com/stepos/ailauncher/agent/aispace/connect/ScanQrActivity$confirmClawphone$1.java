package com.stepos.ailauncher.agent.aispace.connect;

import com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity$confirmClawphone$1", f = "ScanQrActivity.kt", l = {575, 587}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ScanQrActivity$confirmClawphone$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ScanQrActivity.c.Clawphone $pair;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ScanQrActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanQrActivity$confirmClawphone$1(ScanQrActivity scanQrActivity, ScanQrActivity.c.Clawphone clawphone, InterfaceC4014c<? super ScanQrActivity$confirmClawphone$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = scanQrActivity;
        this.$pair = clawphone;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ScanQrActivity$confirmClawphone$1 scanQrActivity$confirmClawphone$1 = new ScanQrActivity$confirmClawphone$1(this.this$0, this.$pair, interfaceC4014c);
        scanQrActivity$confirmClawphone$1.L$0 = obj;
        return scanQrActivity$confirmClawphone$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ScanQrActivity$confirmClawphone$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0137, code lost:
    
        if (r0 == r3) goto L34;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 641
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity$confirmClawphone$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
