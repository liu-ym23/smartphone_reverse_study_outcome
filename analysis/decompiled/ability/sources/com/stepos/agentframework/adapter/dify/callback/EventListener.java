package com.stepos.agentframework.adapter.dify.callback;

import F9.M;
import U9.a;
import com.stepos.agentframework.adapter.dify.bean.ChatEventData;
import com.stepos.agentframework.adapter.dify.bean.ErrorResult;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\b\u0010\tJI\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/callback/EventListener;", "", "LU9/a;", "eventSource", "LF9/M;", "response", "tag", "LC7/r;", "onOpen", "(LU9/a;LF9/M;Ljava/lang/Object;)V", "Lcom/stepos/agentframework/adapter/dify/bean/ChatEventData;", "eventData", "", "type", SettingsConfig.KEY_DATA, "conversationId", "onEvent", "(LU9/a;Lcom/stepos/agentframework/adapter/dify/bean/ChatEventData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "onClosed", "(LU9/a;Ljava/lang/Object;)V", "Lcom/stepos/agentframework/adapter/dify/bean/ErrorResult;", "errorResult", "onFailure", "(LU9/a;Lcom/stepos/agentframework/adapter/dify/bean/ErrorResult;LF9/M;Ljava/lang/Object;)V", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface EventListener {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onClosed(EventListener eventListener, a eventSource, Object obj) {
            k.f(eventSource, "eventSource");
            EventListener.super.onClosed(eventSource, obj);
        }

        @Deprecated
        public static void onEvent(EventListener eventListener, a eventSource, ChatEventData chatEventData, String str, String data, Object obj, String str2) {
            k.f(eventSource, "eventSource");
            k.f(data, "data");
            EventListener.super.onEvent(eventSource, chatEventData, str, data, obj, str2);
        }

        @Deprecated
        public static void onFailure(EventListener eventListener, a eventSource, ErrorResult errorResult, M m, Object obj) {
            k.f(eventSource, "eventSource");
            k.f(errorResult, "errorResult");
            EventListener.super.onFailure(eventSource, errorResult, m, obj);
        }

        @Deprecated
        public static void onOpen(EventListener eventListener, a eventSource, M response, Object obj) {
            k.f(eventSource, "eventSource");
            k.f(response, "response");
            EventListener.super.onOpen(eventSource, response, obj);
        }
    }

    static /* synthetic */ void onEvent$default(EventListener eventListener, a aVar, ChatEventData chatEventData, String str, String str2, Object obj, String str3, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEvent");
        }
        if ((i & 32) != 0) {
            str3 = "";
        }
        eventListener.onEvent(aVar, chatEventData, str, str2, obj, str3);
    }

    default void onClosed(a eventSource, Object tag) {
        k.f(eventSource, "eventSource");
    }

    default void onEvent(a eventSource, ChatEventData eventData, String type, String data, Object tag, String conversationId) {
        k.f(eventSource, "eventSource");
        k.f(data, "data");
    }

    default void onFailure(a eventSource, ErrorResult errorResult, M response, Object tag) {
        k.f(eventSource, "eventSource");
        k.f(errorResult, "errorResult");
    }

    default void onOpen(a eventSource, M response, Object tag) {
        k.f(eventSource, "eventSource");
        k.f(response, "response");
    }
}
