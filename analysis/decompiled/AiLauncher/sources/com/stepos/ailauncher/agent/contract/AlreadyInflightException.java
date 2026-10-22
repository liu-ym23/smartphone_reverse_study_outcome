package com.stepos.ailauncher.agent.contract;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/agent/contract/AlreadyInflightException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "", "identifier", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlreadyInflightException extends IllegalStateException {
    private final String identifier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlreadyInflightException(String identifier) {
        super("toggle already in-flight: " + identifier);
        p.i(identifier, "identifier");
        this.identifier = identifier;
    }
}
