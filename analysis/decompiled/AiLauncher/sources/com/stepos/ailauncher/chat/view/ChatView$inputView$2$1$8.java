package com.stepos.ailauncher.chat.view;

import androidx.drawerlayout.widget.DrawerLayout;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ChatView$inputView$2$1$8", f = "ChatView.kt", l = {634}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatView$inputView$2$1$8 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Boolean>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ChatView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatView$inputView$2$1$8(ChatView chatView, InterfaceC4014c<? super ChatView$inputView$2$1$8> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.this$0 = chatView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new ChatView$inputView$2$1$8(this.this$0, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((ChatView$inputView$2$1$8) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            C4148a.d("ChatViewSpeech", "onWaked", false, 4, null);
            DrawerLayout drawerLayoutZ1 = this.this$0.Z1();
            if (!this.this$0.B2(drawerLayoutZ1)) {
                return C4109a.a(false);
            }
            if (drawerLayoutZ1 != null) {
                ChatView chatView = this.this$0;
                this.L$0 = g9.h.a(drawerLayoutZ1);
                this.label = 1;
                if (chatView.h1(drawerLayoutZ1, 8388611, this) == objG) {
                    return objG;
                }
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return C4109a.a(true);
    }
}
