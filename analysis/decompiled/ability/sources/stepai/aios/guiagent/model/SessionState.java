package stepai.aios.guiagent.model;

import H4.o;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lstepai/aios/guiagent/model/SessionState;", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SessionState {

    /* renamed from: a, reason: collision with root package name */
    public static final SessionState f6031a;
    public static final SessionState b;
    public static final SessionState c;
    public static final SessionState d;
    public static final SessionState e;
    public static final SessionState f;
    public static final SessionState g;
    public static final SessionState h;
    public static final SessionState i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ SessionState[] f6032j;

    static {
        SessionState sessionState = new SessionState("CREATED", 0);
        f6031a = sessionState;
        SessionState sessionState2 = new SessionState("STARTED", 1);
        b = sessionState2;
        SessionState sessionState3 = new SessionState("RUNNING", 2);
        c = sessionState3;
        SessionState sessionState4 = new SessionState("WAITING_FOR_USER_INPUT", 3);
        d = sessionState4;
        SessionState sessionState5 = new SessionState("PAUSED", 4);
        e = sessionState5;
        SessionState sessionState6 = new SessionState("MANUAL_TAKEOVER", 5);
        f = sessionState6;
        SessionState sessionState7 = new SessionState("COMPLETED", 6);
        g = sessionState7;
        SessionState sessionState8 = new SessionState("FAILED", 7);
        h = sessionState8;
        SessionState sessionState9 = new SessionState("CANCELLED", 8);
        i = sessionState9;
        SessionState[] sessionStateArr = {sessionState, sessionState2, sessionState3, sessionState4, sessionState5, sessionState6, sessionState7, sessionState8, sessionState9};
        f6032j = sessionStateArr;
        a.a(sessionStateArr);
    }

    public static SessionState valueOf(String str) {
        return (SessionState) Enum.valueOf(SessionState.class, str);
    }

    public static SessionState[] values() {
        return (SessionState[]) f6032j.clone();
    }

    public final boolean a() {
        return o.N(g, i, h).contains(this);
    }
}
