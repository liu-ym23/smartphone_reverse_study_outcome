package com.stepos.agentframework.chatui.view;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.view.AssistantImageCardView$bind$1", f = "AssistantImageCardView.kt", l = {50}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AssistantImageCardView$bind$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ p9.p<String, InterfaceC4014c<? super String>, Object> $fetcher;
    final /* synthetic */ String $fileId;
    int label;
    final /* synthetic */ AssistantImageCardView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AssistantImageCardView$bind$1(p9.p<? super String, ? super InterfaceC4014c<? super String>, ? extends Object> pVar, String str, AssistantImageCardView assistantImageCardView, InterfaceC4014c<? super AssistantImageCardView$bind$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fetcher = pVar;
        this.$fileId = str;
        this.this$0 = assistantImageCardView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AssistantImageCardView$bind$1(this.$fetcher, this.$fileId, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AssistantImageCardView$bind$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            p9.p<String, InterfaceC4014c<? super String>, Object> pVar = this.$fetcher;
            String str = this.$fileId;
            this.label = 1;
            obj = pVar.invoke(str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        String str2 = (String) obj;
        if (str2 == null) {
            return Y8.t.f7040a;
        }
        this.this$0.resolvedUrl = str2;
        C2076h.b(this.this$0.imageView, str2, AssistantImageCardView.MAX_WIDTH_DP, 320, 0.0f, 8, null);
        return Y8.t.f7040a;
    }
}
