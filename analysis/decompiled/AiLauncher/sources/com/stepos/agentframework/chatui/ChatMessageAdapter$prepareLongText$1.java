package com.stepos.agentframework.chatui;

import com.stepos.agentframework.chatui.ChatMessageAdapter;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import z4.LongTextCandidate;
import z4.LongTextKey;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.ChatMessageAdapter$prepareLongText$1", f = "ChatMessageAdapter.kt", l = {204, 213, 248}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ChatMessageAdapter$prepareLongText$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ LongTextCandidate $candidate;
    final /* synthetic */ LongTextKey $key;
    final /* synthetic */ ChatMessageAdapter.c $preparation;
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ ChatMessageAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessageAdapter$prepareLongText$1(ChatMessageAdapter chatMessageAdapter, LongTextKey longTextKey, ChatMessageAdapter.c cVar, LongTextCandidate longTextCandidate, InterfaceC4014c<? super ChatMessageAdapter$prepareLongText$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatMessageAdapter;
        this.$key = longTextKey;
        this.$preparation = cVar;
        this.$candidate = longTextCandidate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatMessageAdapter$prepareLongText$1(this.this$0, this.$key, this.$preparation, this.$candidate, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatMessageAdapter$prepareLongText$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02ec  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.ChatMessageAdapter$prepareLongText$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
