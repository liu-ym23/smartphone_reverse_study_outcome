package io.modelcontextprotocol.kotlin.sdk.shared;

import e9.InterfaceC4014c;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002H¦@¢\u0006\u0004\b\t\u0010\u0004J\u001d\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0014\u001a\u00020\u00022\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/shared/Transport;", "", "LY8/t;", "start", "(Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "message", "send", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;Le9/c;)Ljava/lang/Object;", "close", "Lkotlin/Function0;", "block", "onClose", "(Lp9/a;)V", "Lkotlin/Function1;", "", "onError", "(Lp9/l;)V", "Lkotlin/Function2;", "Le9/c;", "onMessage", "(Lp9/p;)V", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Transport {
    Object close(InterfaceC4014c<? super Y8.t> interfaceC4014c);

    void onClose(InterfaceC5063a<Y8.t> block);

    void onError(InterfaceC5074l<? super Throwable, Y8.t> block);

    void onMessage(p9.p<? super JSONRPCMessage, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> block);

    Object send(JSONRPCMessage jSONRPCMessage, InterfaceC4014c<? super Y8.t> interfaceC4014c);

    Object start(InterfaceC4014c<? super Y8.t> interfaceC4014c);
}
