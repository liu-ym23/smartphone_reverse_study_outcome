package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.provider.c;
import f1.C4031a;
import f1.C4038h;
import f1.C4039i;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w4.SessionPendingActionEntity;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/e1;", "Lcom/stepos/agentframework/chatcore/session/db/W0;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lw4/i;", "action", "LY8/t;", "c", "(Lw4/i;)V", "", "requestId", "f", "(Ljava/lang/String;)Lw4/i;", "", "getAll", "()Ljava/util/List;", "", "e", "(Ljava/lang/String;)I", "sessionId", Const.INTENT_KEY_UMID, "oldSessionId", "newSessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)I", Const.INTENT_KEY_APIKEY, "()I", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfSessionPendingActionEntity", "Landroidx/room/f;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.db.e1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1880e1 implements W0 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1410f<SessionPendingActionEntity> __insertAdapterOfSessionPendingActionEntity;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/e1$a", "Landroidx/room/f;", "Lw4/i;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lw4/i;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.e1$a */
    public static final class a extends AbstractC1410f<SessionPendingActionEntity> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `session_pending_action` (`request_id`,`session_id`,`agent_id`,`action_kind`,`created_at`,`expires_at`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, SessionPendingActionEntity entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getRequestId());
            statement.H(2, entity.getSessionId());
            statement.H(3, entity.getAgentId());
            statement.H(4, entity.getActionKind());
            statement.bindLong(5, entity.getCreatedAt());
            Long expiresAt = entity.getExpiresAt();
            if (expiresAt == null) {
                statement.bindNull(6);
            } else {
                statement.bindLong(6, expiresAt.longValue());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/e1$b;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.e1$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final List<InterfaceC5745d<?>> a() {
            return C1173v.m();
        }

        public Companion() {
        }
    }

    public C1880e1(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfSessionPendingActionEntity = new a();
    }

    public static final int n(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.n1();
            return C4038h.b(_connection);
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final int o(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.n1();
            return C4038h.b(_connection);
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final int p(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.n1();
            return C4038h.b(_connection);
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final SessionPendingActionEntity q(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, "request_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "action_kind");
            int iC5 = C4039i.c(interfaceC4162dQ1, c.a.COL_CREATED_AT);
            int iC6 = C4039i.c(interfaceC4162dQ1, "expires_at");
            SessionPendingActionEntity sessionPendingActionEntity = null;
            if (interfaceC4162dQ1.n1()) {
                sessionPendingActionEntity = new SessionPendingActionEntity(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.getLong(iC5), interfaceC4162dQ1.isNull(iC6) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC6)));
            }
            return sessionPendingActionEntity;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List r(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            int iC = C4039i.c(interfaceC4162dQ1, "request_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "action_kind");
            int iC5 = C4039i.c(interfaceC4162dQ1, c.a.COL_CREATED_AT);
            int iC6 = C4039i.c(interfaceC4162dQ1, "expires_at");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new SessionPendingActionEntity(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.getLong(iC5), interfaceC4162dQ1.isNull(iC6) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC6))));
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final int s(String str, String str2, String str3, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.H(2, str3);
            interfaceC4162dQ1.n1();
            return C4038h.b(_connection);
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final Y8.t t(C1880e1 c1880e1, SessionPendingActionEntity sessionPendingActionEntity, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        c1880e1.__insertAdapterOfSessionPendingActionEntity.d(_connection, sessionPendingActionEntity);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.session.db.W0
    public int a() {
        final String str = "delete from session_pending_action";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.d1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(C1880e1.n(str, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.W0
    public int b(final String oldSessionId, final String newSessionId) {
        kotlin.jvm.internal.p.i(oldSessionId, "oldSessionId");
        kotlin.jvm.internal.p.i(newSessionId, "newSessionId");
        final String str = "update session_pending_action set session_id = (?) where session_id = (?)";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.Z0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(C1880e1.s(str, newSessionId, oldSessionId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.W0
    public void c(final SessionPendingActionEntity action) {
        kotlin.jvm.internal.p.i(action, "action");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.X0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1880e1.t(this.f22551a, action, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.W0
    public int d(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "delete from session_pending_action where session_id = (?)";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.c1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(C1880e1.p(str, sessionId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.W0
    public int e(final String requestId) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        final String str = "delete from session_pending_action where request_id = (?)";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.a1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(C1880e1.o(str, requestId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.W0
    public SessionPendingActionEntity f(final String requestId) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        final String str = "select * from session_pending_action where request_id = (?)";
        return (SessionPendingActionEntity) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.Y0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1880e1.q(str, requestId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.W0
    public List<SessionPendingActionEntity> getAll() {
        final String str = "select * from session_pending_action order by created_at desc, request_id asc";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.b1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1880e1.r(str, (InterfaceC4160b) obj);
            }
        });
    }
}
