package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.core.ability.converter.BundleContentBridge;
import f1.C4031a;
import f1.C4039i;
import f1.C4043m;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w4.MessageSearchProjectionEntity;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/Q0;", "Lcom/stepos/agentframework/chatcore/session/db/I0;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lw4/g;", "projection", "LY8/t;", "f", "(Lw4/g;)V", "", "projections", Const.INTENT_KEY_UMID, "(Ljava/util/List;)V", "", "pattern", "", "limit", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;I)Ljava/util/List;", "sessionIds", "perSessionLimit", "maxTextLength", "Lcom/stepos/agentframework/chatcore/session/db/V0;", "e", "(Ljava/util/List;II)Ljava/util/List;", "oldSessionId", "newSessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "c", "()V", Const.INTENT_KEY_APIKEY, "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfMessageSearchProjectionEntity", "Landroidx/room/f;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Q0 implements I0 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1410f<MessageSearchProjectionEntity> __insertAdapterOfMessageSearchProjectionEntity;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/Q0$a", "Landroidx/room/f;", "Lw4/g;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lw4/g;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1410f<MessageSearchProjectionEntity> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `message_search_document` (`message_id`,`session_id`,`agent_id`,`role`,`searchable_text`,`updated_at`,`status`) VALUES (?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, MessageSearchProjectionEntity entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getMessageId());
            statement.H(2, entity.getSessionId());
            statement.H(3, entity.getAgentId());
            statement.H(4, entity.getRole());
            statement.H(5, entity.getSearchableText());
            statement.bindLong(6, entity.getUpdatedAt());
            statement.H(7, entity.getStatus());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/Q0$b;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.Q0$b, reason: from kotlin metadata */
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

    public Q0(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfMessageSearchProjectionEntity = new a();
    }

    public static final Y8.t o(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t p(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final List q(String str, int i10, List list, int i11, int i12, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, i10);
            Iterator it = list.iterator();
            int i13 = 2;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i13, (String) it.next());
                i13++;
            }
            interfaceC4162dQ1.bindLong(i11 + 2, i12);
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new SessionOpeningMessageRow(interfaceC4162dQ1.X0(0), interfaceC4162dQ1.X0(1)));
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t r(String str, String str2, String str3, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.H(2, str3);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final List s(String str, String str2, int i10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.H(2, str2);
            interfaceC4162dQ1.bindLong(3, i10);
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, BundleContentBridge.KEY_ROLE);
            int iC5 = C4039i.c(interfaceC4162dQ1, "searchable_text");
            int iC6 = C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT);
            int iC7 = C4039i.c(interfaceC4162dQ1, "status");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new MessageSearchProjectionEntity(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.getLong(iC6), interfaceC4162dQ1.X0(iC7)));
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final Y8.t t(Q0 q02, MessageSearchProjectionEntity messageSearchProjectionEntity, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        q02.__insertAdapterOfMessageSearchProjectionEntity.d(_connection, messageSearchProjectionEntity);
        return Y8.t.f7040a;
    }

    public static final Y8.t u(Q0 q02, List list, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        q02.__insertAdapterOfMessageSearchProjectionEntity.c(_connection, list);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.session.db.I0
    public void a() {
        final String str = "DELETE FROM message_search_document";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.M0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Q0.p(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.I0
    public void b(final String oldSessionId, final String newSessionId) {
        kotlin.jvm.internal.p.i(oldSessionId, "oldSessionId");
        kotlin.jvm.internal.p.i(newSessionId, "newSessionId");
        final String str = "UPDATE message_search_document SET session_id = ? WHERE session_id = ?";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.L0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Q0.r(str, newSessionId, oldSessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.I0
    public void c() {
        final String str = "UPDATE message_search_document SET status = 'CANCELED' WHERE role = 'ASSISTANT' AND status IN ('START', 'TOOL_EXECUTING', 'REPLYING')";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.J0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Q0.o(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.I0
    public void d(final List<MessageSearchProjectionEntity> projections) {
        kotlin.jvm.internal.p.i(projections, "projections");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.O0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Q0.u(this.f22524a, projections, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.I0
    public List<SessionOpeningMessageRow> e(final List<String> sessionIds, final int perSessionLimit, final int maxTextLength) {
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT d.session_id AS sessionId, SUBSTR(d.searchable_text, 1, ");
        sb2.append("?");
        sb2.append(") AS text FROM message_search_document AS d WHERE d.session_id IN (");
        final int size = sessionIds.size();
        C4043m.a(sb2, size);
        sb2.append(") AND d.searchable_text != '' AND d.message_id IN (SELECT d2.message_id FROM message_search_document AS d2 WHERE d2.session_id = d.session_id AND d2.searchable_text != '' ORDER BY d2.updated_at ASC, d2.message_id ASC LIMIT ");
        sb2.append("?");
        sb2.append(") ORDER BY d.updated_at ASC, d.message_id ASC");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.P0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Q0.q(string, maxTextLength, sessionIds, size, perSessionLimit, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.I0
    public void f(final MessageSearchProjectionEntity projection) {
        kotlin.jvm.internal.p.i(projection, "projection");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.K0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Q0.t(this.f22505a, projection, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.I0
    public List<MessageSearchProjectionEntity> g(final String pattern, final int limit) {
        kotlin.jvm.internal.p.i(pattern, "pattern");
        final String str = "SELECT d.* FROM message_search_document AS d INNER JOIN conversation_title AS c ON c.session_id = d.session_id AND c.agent_id = d.agent_id WHERE c.is_temp_session = 0 AND c.delete_status = 0 AND c.session_id NOT LIKE 'agent:task-%' AND c.session_id NOT LIKE 'cron:%' AND NOT (c.session_id LIKE 'agent:%:main' AND c.session_id NOT LIKE 'agent:main:%') AND d.searchable_text != '' AND LOWER(d.searchable_text) LIKE LOWER(?) ESCAPE '\\' AND d.message_id = (SELECT d2.message_id FROM message_search_document AS d2 WHERE d2.session_id = d.session_id AND d2.agent_id = d.agent_id AND d2.searchable_text != '' AND LOWER(d2.searchable_text) LIKE LOWER(?) ESCAPE '\\' ORDER BY d2.updated_at DESC, d2.message_id DESC LIMIT 1) ORDER BY d.updated_at DESC LIMIT ?";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.N0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Q0.s(str, pattern, limit, (InterfaceC4160b) obj);
            }
        });
    }
}
