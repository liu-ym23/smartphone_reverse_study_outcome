package com.stepos.ailauncher.chat.view.ban;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ban.InputBanController$startBanTicker$1", f = "InputBanController.kt", l = {278}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class InputBanController$startBanTicker$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ long $endMillis;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InputBanController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBanController$startBanTicker$1(InputBanController inputBanController, long j10, InterfaceC4014c<? super InputBanController$startBanTicker$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = inputBanController;
        this.$endMillis = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        InputBanController$startBanTicker$1 inputBanController$startBanTicker$1 = new InputBanController$startBanTicker$1(this.this$0, this.$endMillis, interfaceC4014c);
        inputBanController$startBanTicker$1.L$0 = obj;
        return inputBanController$startBanTicker$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((InputBanController$startBanTicker$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0050 -> B:17:0x0053). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = r10.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r10.label
            r3 = 1
            if (r2 == 0) goto L1b
            if (r2 != r3) goto L13
            kotlin.C4849c.b(r11)
            goto L53
        L13:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L1b:
            kotlin.C4849c.b(r11)
        L1e:
            boolean r11 = kotlinx.coroutines.d.h(r0)
            if (r11 == 0) goto La1
            com.stepos.ailauncher.chat.view.ban.InputBanController r11 = r10.this$0
            long r4 = com.stepos.ailauncher.chat.view.ban.InputBanController.j(r11)
            long r6 = r10.$endMillis
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 < 0) goto L40
            com.stepos.ailauncher.chat.view.ban.InputBanController r11 = r10.this$0
            com.stepos.ailauncher.contract.api.account.IAccountStatusService r0 = com.stepos.ailauncher.chat.view.ban.InputBanController.c(r11)
            com.stepos.ailauncher.chat.view.ban.InputBanController r10 = r10.this$0
            java.lang.String r10 = com.stepos.ailauncher.chat.view.ban.InputBanController.b(r10)
            com.stepos.ailauncher.chat.view.ban.InputBanController.h(r11, r0, r10)
            goto La1
        L40:
            r6 = 60000(0xea60, double:2.9644E-319)
            long r8 = r4 % r6
            long r6 = r6 - r8
            r10.L$0 = r0
            r10.J$0 = r4
            r10.label = r3
            java.lang.Object r11 = Ua.U.a(r6, r10)
            if (r11 != r1) goto L53
            return r1
        L53:
            com.stepos.ailauncher.chat.view.ban.InputBanController r11 = r10.this$0
            long r4 = com.stepos.ailauncher.chat.view.ban.InputBanController.j(r11)
            long r6 = r10.$endMillis
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 < 0) goto L6f
            com.stepos.ailauncher.chat.view.ban.InputBanController r11 = r10.this$0
            com.stepos.ailauncher.contract.api.account.IAccountStatusService r0 = com.stepos.ailauncher.chat.view.ban.InputBanController.c(r11)
            com.stepos.ailauncher.chat.view.ban.InputBanController r10 = r10.this$0
            java.lang.String r10 = com.stepos.ailauncher.chat.view.ban.InputBanController.b(r10)
            com.stepos.ailauncher.chat.view.ban.InputBanController.h(r11, r0, r10)
            goto La1
        L6f:
            long r6 = r6 - r4
            double r4 = (double) r6
            r6 = 4678479150791524352(0x40ed4c0000000000, double:60000.0)
            double r4 = r4 / r6
            double r4 = java.lang.Math.ceil(r4)
            int r11 = (int) r4
            int r11 = v9.C5685n.f(r11, r3)
            com.stepos.ailauncher.chat.view.ban.InputBanController r2 = r10.this$0
            android.widget.TextView r2 = com.stepos.ailauncher.chat.view.ban.InputBanController.e(r2)
            if (r2 == 0) goto L1e
            com.stepos.ailauncher.chat.view.ban.InputBanController r4 = r10.this$0
            android.content.Context r4 = com.stepos.ailauncher.chat.view.ban.InputBanController.g(r4)
            int r5 = com.stepos.ailauncher.chat.R$string.account_banned_notice_countdown
            java.lang.Integer r11 = g9.C4109a.f(r11)
            java.lang.Object[] r11 = new java.lang.Object[]{r11}
            java.lang.String r11 = r4.getString(r5, r11)
            r2.setText(r11)
            goto L1e
        La1:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ban.InputBanController$startBanTicker$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
