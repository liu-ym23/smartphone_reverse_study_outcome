package com.stepos.agentframework.adapter.agentbus;

import Ua.C1056g;
import Ua.Y;
import a4.Message;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB#\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0004H\u0080@¢\u0006\u0004\b\u000b\u0010\fR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannel;", "", "Lkotlin/Function2;", "", "La4/w;", "LY8/t;", "onMessage", "<init>", "(Lp9/p;)V", "sessionId", "message", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;La4/w;Le9/c;)Ljava/lang/Object;", "Lp9/p;", "Companion", Const.INTENT_KEY_APIKEY, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClawChannel {
    private static final a Companion = new a(null);
    private static final String TAG = "ClawChannel";
    private final p9.p<String, Message, Y8.t> onMessage;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannel$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClawChannel(p9.p<? super String, ? super Message, Y8.t> onMessage) {
        kotlin.jvm.internal.p.i(onMessage, "onMessage");
        this.onMessage = onMessage;
    }

    public final Object b(String str, Message message, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objJ = C1056g.j(Y.a(), new ClawChannel$forwardMessage$2(this, str, message, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : Y8.t.f7040a;
    }
}
