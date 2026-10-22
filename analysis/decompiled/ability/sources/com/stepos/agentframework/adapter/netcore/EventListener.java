package com.stepos.agentframework.adapter.netcore;

import V4.l;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/EventListener;", "", "LV4/l;", "chatRequestInfo", "LC7/r;", "onOpen", "(LV4/l;)V", "LV4/k;", "chatReplyInfo", "onEvent", "(LV4/l;LV4/k;)V", "onClosed", "", "code", "", "message", "onFailure", "(LV4/l;Ljava/lang/Integer;Ljava/lang/String;)V", "extra", "onHandle", "(Ljava/lang/Object;)V", "netcore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface EventListener {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onClosed(EventListener eventListener, l chatRequestInfo) {
            k.f(chatRequestInfo, "chatRequestInfo");
            EventListener.super.onClosed(chatRequestInfo);
        }

        @Deprecated
        public static void onEvent(EventListener eventListener, l chatRequestInfo, V4.k chatReplyInfo) {
            k.f(chatRequestInfo, "chatRequestInfo");
            k.f(chatReplyInfo, "chatReplyInfo");
            EventListener.super.onEvent(chatRequestInfo, chatReplyInfo);
        }

        @Deprecated
        public static void onFailure(EventListener eventListener, l chatRequestInfo, Integer num, String str) {
            k.f(chatRequestInfo, "chatRequestInfo");
            EventListener.super.onFailure(chatRequestInfo, num, str);
        }

        @Deprecated
        public static void onHandle(EventListener eventListener, Object obj) {
            EventListener.super.onHandle(obj);
        }

        @Deprecated
        public static void onOpen(EventListener eventListener, l chatRequestInfo) {
            k.f(chatRequestInfo, "chatRequestInfo");
            EventListener.super.onOpen(chatRequestInfo);
        }
    }

    default void onClosed(l chatRequestInfo) {
        k.f(chatRequestInfo, "chatRequestInfo");
    }

    default void onEvent(l chatRequestInfo, V4.k chatReplyInfo) {
        k.f(chatRequestInfo, "chatRequestInfo");
        k.f(chatReplyInfo, "chatReplyInfo");
    }

    default void onFailure(l chatRequestInfo, Integer code, String message) {
        k.f(chatRequestInfo, "chatRequestInfo");
    }

    default void onHandle(Object extra) {
    }

    default void onOpen(l chatRequestInfo) {
        k.f(chatRequestInfo, "chatRequestInfo");
    }
}
