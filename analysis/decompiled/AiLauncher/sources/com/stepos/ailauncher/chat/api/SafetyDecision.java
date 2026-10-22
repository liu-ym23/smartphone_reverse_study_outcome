package com.stepos.ailauncher.chat.api;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/api/SafetyDecision;", "", "<init>", "()V", "PASS", "", "BLOCK", SafetyDecision.REVIEW, SafetyDecision.REVERT, SafetyDecision.NEW_CHAT, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafetyDecision {
    public static final String BLOCK = "BLOCK";
    public static final SafetyDecision INSTANCE = new SafetyDecision();
    public static final String NEW_CHAT = "NEW_CHAT";
    public static final String PASS = "PASS";
    public static final String REVERT = "REVERT";
    public static final String REVIEW = "REVIEW";

    private SafetyDecision() {
    }
}
