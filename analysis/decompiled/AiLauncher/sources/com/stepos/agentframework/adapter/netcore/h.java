package com.stepos.agentframework.adapter.netcore;

import La.K;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import h8.C4148a;
import java.util.List;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.Metadata;
import kotlin.ReferenceSource;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016¢\u0006\u0004\b \u0010!J/\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0016¢\u0006\u0004\b$\u0010%¨\u0006&À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/h;", "", "LK6/n;", "chatRequestInfo", "LY8/t;", "f", "(LK6/n;)V", "LK6/m;", "chatReplyInfo", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK6/n;LK6/m;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "code", "", "message", Const.INTENT_KEY_PKGNAME, "(LK6/n;Ljava/lang/Integer;Ljava/lang/String;)V", "", "success", "c", "(LK6/n;ZLjava/lang/Integer;Ljava/lang/String;)V", Const.INTENT_KEY_UMID, "()V", Const.INTENT_KEY_APIKEY, "extra", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Object;)V", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "", "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "e", "(LK6/n;Ljava/lang/String;Ljava/util/List;)V", "name", "resultJson", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LK6/n;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface h {
    default void a() {
    }

    default void b(C0918n chatRequestInfo, Integer code, String message) {
        kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
    }

    default void c(C0918n chatRequestInfo, boolean success, Integer code, String message) {
        kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
    }

    default void d() {
    }

    default void e(C0918n chatRequestInfo, String runId, List<ReferenceSource> sources) {
        kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
        kotlin.jvm.internal.p.i(runId, "runId");
        kotlin.jvm.internal.p.i(sources, "sources");
    }

    default void f(C0918n chatRequestInfo) {
        kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
    }

    default void g(C0918n chatRequestInfo, C0917m chatReplyInfo) {
        kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
        kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
    }

    default void h(C0918n chatRequestInfo, String runId, String name, String resultJson) {
        kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
        kotlin.jvm.internal.p.i(runId, "runId");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(resultJson, "resultJson");
        C4148a.u("EventListener", "onCard not overridden, late card dropped runId=" + K.R1(runId, 32) + " name=" + name, false, 4, null);
    }

    default void i(Object extra) {
    }

    default void j(C0918n chatRequestInfo) {
        kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
    }
}
