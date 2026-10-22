package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import La.H;
import Xa.u;
import Y8.t;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u0003JM\u0010\u0015\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0017\u0010\u0003J\u0019\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0019\u0010\bR\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u001f\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d8\u0006¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R\u001c\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001cR\u001f\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d8\u0006¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u001c\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001cR\u001f\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d8\u0006¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!R\u001c\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001cR\u001f\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d8\u0006¢\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010!R\u001c\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010\u001cR\u001f\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d8\u0006¢\u0006\f\n\u0004\b/\u0010\u001f\u001a\u0004\b0\u0010!R\u001c\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010\u001cR\u001f\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d8\u0006¢\u0006\f\n\u0004\b2\u0010\u001f\u001a\u0004\b3\u0010!R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u0006048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\u0006078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0004048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00106R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0004078\u0006¢\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010;R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\t0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010\u001cR\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8\u0006¢\u0006\f\n\u0004\b@\u0010\u001f\u001a\u0004\bA\u0010!R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\t0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010\u001cR\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8\u0006¢\u0006\f\n\u0004\bC\u0010\u001f\u001a\u0004\bD\u0010!R$\u0010F\u001a\u00020\t2\u0006\u0010E\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR$\u0010K\u001a\u00020J2\u0006\u0010E\u001a\u00020J8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bQ\u0010PR\u0014\u0010R\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bR\u0010PR\u0014\u0010S\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bS\u0010PR\u0014\u0010T\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bT\u0010PR\u0014\u0010U\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bU\u0010P¨\u0006V"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/j;", "", "<init>", "()V", "", "opName", "LY8/t;", "r", "(Ljava/lang/String;)V", "", W4.a.ENABLE_ON, "p", "(Z)V", "o", "q", "newStatus", "newNextActionUrl", "newNextActionType", "newTaskId", "newEnvId", "newFailReason", "s", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "newTraceId", "t", "LXa/k;", "_status", "LXa/k;", "LXa/t;", "status", "LXa/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LXa/t;", "_nextActionUrl", "nextActionUrl", Const.INTENT_KEY_BACKGROUND_COMMAND, "_nextActionType", "nextActionType", "f", "_taskId", "taskId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "_envId", "envId", Const.INTENT_KEY_PKGNAME, "_failReason", "failReason", "c", "_traceId", DidiCardProvider.KEY_TRACE_ID, "k", "LXa/j;", "_snapshotEvents", "LXa/j;", "LXa/o;", "snapshotEvents", "LXa/o;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()LXa/o;", "_networkFailures", "networkFailures", "e", "_isToggling", "isToggling", "n", "_isCancelling", "isCancelling", "m", UxipConstants.f30680s, "userInitiated", "Z", "l", "()Z", "", "lastUserActionAt", "J", Const.INTENT_KEY_UMID, "()J", "STATUS_CONNECTED", "Ljava/lang/String;", "STATUS_DISCONNECTED", "ACTION_TYPE_NONE", "ACTION_TYPE_OPEN_URL", "ACTION_TYPE_RETRY", "ACTION_TYPE_DONE", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class j {
    public static final String ACTION_TYPE_DONE = "done";
    public static final String ACTION_TYPE_NONE = "none";
    public static final String ACTION_TYPE_OPEN_URL = "open_url";
    public static final String ACTION_TYPE_RETRY = "retry";
    public static final j INSTANCE = new j();
    public static final String STATUS_CONNECTED = "connected";
    public static final String STATUS_DISCONNECTED = "disconnected";
    private static final Xa.k<String> _envId;
    private static final Xa.k<String> _failReason;
    private static final Xa.k<Boolean> _isCancelling;
    private static final Xa.k<Boolean> _isToggling;
    private static final Xa.j<String> _networkFailures;
    private static final Xa.k<String> _nextActionType;
    private static final Xa.k<String> _nextActionUrl;
    private static final Xa.j<t> _snapshotEvents;
    private static final Xa.k<String> _status;
    private static final Xa.k<String> _taskId;
    private static final Xa.k<String> _traceId;
    private static final Xa.t<String> envId;
    private static final Xa.t<String> failReason;
    private static final Xa.t<Boolean> isCancelling;
    private static final Xa.t<Boolean> isToggling;
    private static volatile long lastUserActionAt;
    private static final Xa.o<String> networkFailures;
    private static final Xa.t<String> nextActionType;
    private static final Xa.t<String> nextActionUrl;
    private static final Xa.o<t> snapshotEvents;
    private static final Xa.t<String> status;
    private static final Xa.t<String> taskId;
    private static final Xa.t<String> traceId;
    private static volatile boolean userInitiated;

    static {
        Xa.k<String> kVarA = u.a(null);
        _status = kVarA;
        status = Xa.d.c(kVarA);
        Xa.k<String> kVarA2 = u.a(null);
        _nextActionUrl = kVarA2;
        nextActionUrl = Xa.d.c(kVarA2);
        Xa.k<String> kVarA3 = u.a(null);
        _nextActionType = kVarA3;
        nextActionType = Xa.d.c(kVarA3);
        Xa.k<String> kVarA4 = u.a(null);
        _taskId = kVarA4;
        taskId = Xa.d.c(kVarA4);
        Xa.k<String> kVarA5 = u.a(null);
        _envId = kVarA5;
        envId = Xa.d.c(kVarA5);
        Xa.k<String> kVarA6 = u.a(null);
        _failReason = kVarA6;
        failReason = Xa.d.c(kVarA6);
        Xa.k<String> kVarA7 = u.a(null);
        _traceId = kVarA7;
        traceId = Xa.d.c(kVarA7);
        Xa.j<t> jVarB = Xa.p.b(0, 16, null, 4, null);
        _snapshotEvents = jVarB;
        snapshotEvents = Xa.d.b(jVarB);
        Xa.j<String> jVarB2 = Xa.p.b(0, 8, null, 4, null);
        _networkFailures = jVarB2;
        networkFailures = Xa.d.b(jVarB2);
        Boolean bool = Boolean.FALSE;
        Xa.k<Boolean> kVarA8 = u.a(bool);
        _isToggling = kVarA8;
        isToggling = Xa.d.c(kVarA8);
        Xa.k<Boolean> kVarA9 = u.a(bool);
        _isCancelling = kVarA9;
        isCancelling = Xa.d.c(kVarA9);
    }

    public final void a() {
        _status.setValue(null);
        _nextActionUrl.setValue(null);
        _nextActionType.setValue(null);
        _taskId.setValue(null);
        _envId.setValue(null);
        _failReason.setValue(null);
        _traceId.setValue(null);
        Xa.k<Boolean> kVar = _isToggling;
        Boolean bool = Boolean.FALSE;
        kVar.setValue(bool);
        _isCancelling.setValue(bool);
        userInitiated = false;
        lastUserActionAt = 0L;
    }

    public final Xa.t<String> b() {
        return envId;
    }

    public final Xa.t<String> c() {
        return failReason;
    }

    public final long d() {
        return lastUserActionAt;
    }

    public final Xa.o<String> e() {
        return networkFailures;
    }

    public final Xa.t<String> f() {
        return nextActionType;
    }

    public final Xa.t<String> g() {
        return nextActionUrl;
    }

    public final Xa.o<t> h() {
        return snapshotEvents;
    }

    public final Xa.t<String> i() {
        return status;
    }

    public final Xa.t<String> j() {
        return taskId;
    }

    public final Xa.t<String> k() {
        return traceId;
    }

    public final boolean l() {
        return userInitiated;
    }

    public final Xa.t<Boolean> m() {
        return isCancelling;
    }

    public final Xa.t<Boolean> n() {
        return isToggling;
    }

    public final void o(boolean on) {
        _isCancelling.setValue(Boolean.valueOf(on));
    }

    public final void p(boolean on) {
        _isToggling.setValue(Boolean.valueOf(on));
    }

    public final void q() {
        userInitiated = true;
        lastUserActionAt = SystemClock.elapsedRealtime();
    }

    public final void r(String opName) {
        kotlin.jvm.internal.p.i(opName, "opName");
        _networkFailures.a(opName);
    }

    public final void s(String newStatus, String newNextActionUrl, String newNextActionType, String newTaskId, String newEnvId, String newFailReason) {
        _status.setValue(newStatus);
        _nextActionUrl.setValue(newNextActionUrl);
        _nextActionType.setValue(newNextActionType);
        if (newTaskId != null && !H.x0(newTaskId)) {
            _taskId.setValue(newTaskId);
        }
        if (newEnvId != null && !H.x0(newEnvId)) {
            _envId.setValue(newEnvId);
        }
        _failReason.setValue(newFailReason);
        _snapshotEvents.a(t.f7040a);
    }

    public final void t(String newTraceId) {
        if (newTraceId == null || H.x0(newTraceId)) {
            return;
        }
        Xa.k<String> kVar = _traceId;
        String value = kVar.getValue();
        if (value == null || H.x0(value)) {
            kVar.setValue(newTraceId);
        }
    }
}
