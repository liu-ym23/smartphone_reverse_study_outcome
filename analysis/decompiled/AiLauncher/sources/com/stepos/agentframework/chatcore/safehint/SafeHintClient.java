package com.stepos.agentframework.chatcore.safehint;

import Ua.C1056g;
import Ua.Y;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/chatcore/safehint/SafeHintClient;", "", "<init>", "()V", "", "userInput", "modelOutput", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SafeHintClient {
    public static final SafeHintClient INSTANCE = new SafeHintClient();
    public static final String TAG = "safe-hint-service";

    public final Object a(String str, String str2, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new SafeHintClient$isRisky$2(str2, str, null), interfaceC4014c);
    }
}
