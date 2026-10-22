package com.stepos.ailauncher.chat.api;

import Ac.a;
import Ac.o;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/api/SafetyReviewApi;", "", "Lcom/stepos/ailauncher/chat/api/SafetyReviewRequest;", "request", "Lcom/stepos/ailauncher/chat/api/SafetyReviewResponse;", "reviewRichText", "(Lcom/stepos/ailauncher/chat/api/SafetyReviewRequest;Le9/c;)Ljava/lang/Object;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SafetyReviewApi {
    @o("cloud-risk-audit/api/v1/inner/risk-audit/rich-text")
    Object reviewRichText(@a SafetyReviewRequest safetyReviewRequest, InterfaceC4014c<? super SafetyReviewResponse> interfaceC4014c);
}
