package com.stepos.agentframework.chatui.history;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.history.DefaultDrawerContent$loadData$1$onLoadConversationTitles$2", f = "DefaultDrawerContent.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class DefaultDrawerContent$loadData$1$onLoadConversationTitles$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ List<DrawerTitleItem<w4.e>> $newList;
    int label;
    final /* synthetic */ DefaultDrawerContent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDrawerContent$loadData$1$onLoadConversationTitles$2(DefaultDrawerContent defaultDrawerContent, List<DrawerTitleItem<w4.e>> list, InterfaceC4014c<? super DefaultDrawerContent$loadData$1$onLoadConversationTitles$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = defaultDrawerContent;
        this.$newList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DefaultDrawerContent$loadData$1$onLoadConversationTitles$2(this.this$0, this.$newList, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((DefaultDrawerContent$loadData$1$onLoadConversationTitles$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        h hVar = this.this$0.adapter;
        if (hVar == null) {
            kotlin.jvm.internal.p.A("adapter");
            hVar = null;
        }
        hVar.d(this.$newList);
        return t.f7040a;
    }
}
