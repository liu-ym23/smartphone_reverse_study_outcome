package com.stepos.agentframework.chatcore.session;

import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.MessageManager$updateSendFailedWhenPersisted$1", f = "MessageManager.kt", l = {162, DidiCardView.FINISHED_TITLE_TRAILING_WIDTH_DP}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class MessageManager$updateSendFailedWhenPersisted$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $failed;
    final /* synthetic */ List<String> $messageIds;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ MessageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageManager$updateSendFailedWhenPersisted$1(MessageManager messageManager, List<String> list, boolean z10, InterfaceC4014c<? super MessageManager$updateSendFailedWhenPersisted$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = messageManager;
        this.$messageIds = list;
        this.$failed = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        MessageManager$updateSendFailedWhenPersisted$1 messageManager$updateSendFailedWhenPersisted$1 = new MessageManager$updateSendFailedWhenPersisted$1(this.this$0, this.$messageIds, this.$failed, interfaceC4014c);
        messageManager$updateSendFailedWhenPersisted$1.L$0 = obj;
        return messageManager$updateSendFailedWhenPersisted$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((MessageManager$updateSendFailedWhenPersisted$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e3, code lost:
    
        if (r10.n(r11, r21) == r3) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0128 -> B:43:0x0129). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.MessageManager$updateSendFailedWhenPersisted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
