package com.stepos.agentframework.chatcore.search;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore", f = "ConversationSearchSnapshotStore.kt", l = {286}, m = "ensureLegacyMessagesIndexed", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConversationSearchSnapshotStore$ensureLegacyMessagesIndexed$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationSearchSnapshotStore this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationSearchSnapshotStore$ensureLegacyMessagesIndexed$1(ConversationSearchSnapshotStore conversationSearchSnapshotStore, InterfaceC4014c<? super ConversationSearchSnapshotStore$ensureLegacyMessagesIndexed$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = conversationSearchSnapshotStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(this);
    }
}
