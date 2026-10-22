package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.provider.c;
import f1.C4031a;
import f1.C4039i;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w4.TaskSessionLink;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/H1;", "Lcom/stepos/agentframework/chatcore/session/db/B1;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lw4/l;", "link", "LY8/t;", "c", "(Lw4/l;)V", "", "subSessionKey", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lw4/l;", "taskId", "e", Const.INTENT_KEY_UMID, "()Lw4/l;", Const.INTENT_KEY_APIKEY, "()V", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfTaskSessionLink", "Landroidx/room/f;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class H1 implements B1 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1410f<TaskSessionLink> __insertAdapterOfTaskSessionLink;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/H1$a", "Landroidx/room/f;", "Lw4/l;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lw4/l;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1410f<TaskSessionLink> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `task_session_link` (`sub_session_key`,`request_session_key`,`task_id`,`agent_id`,`card_time`,`updated_at`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, TaskSessionLink entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getSubSessionKey());
            statement.H(2, entity.getRequestSessionKey());
            statement.H(3, entity.getTaskId());
            statement.H(4, entity.getAgentId());
            statement.bindLong(5, entity.getCardTime());
            statement.bindLong(6, entity.getUpdatedAt());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/H1$b;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.H1$b, reason: from kotlin metadata */
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

    public H1(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfTaskSessionLink = new a();
    }

    public static final Y8.t k(String str, InterfaceC4160b _connection) {
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

    public static final TaskSessionLink l(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            return interfaceC4162dQ1.n1() ? new TaskSessionLink(interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "sub_session_key")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, c.a.COL_REQUEST_SESSION_KEY)), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "task_id")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "agent_id")), interfaceC4162dQ1.getLong(C4039i.c(interfaceC4162dQ1, "card_time")), interfaceC4162dQ1.getLong(C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT))) : null;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final TaskSessionLink m(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            return interfaceC4162dQ1.n1() ? new TaskSessionLink(interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "sub_session_key")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, c.a.COL_REQUEST_SESSION_KEY)), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "task_id")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "agent_id")), interfaceC4162dQ1.getLong(C4039i.c(interfaceC4162dQ1, "card_time")), interfaceC4162dQ1.getLong(C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT))) : null;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final TaskSessionLink n(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            return interfaceC4162dQ1.n1() ? new TaskSessionLink(interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "sub_session_key")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, c.a.COL_REQUEST_SESSION_KEY)), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "task_id")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "agent_id")), interfaceC4162dQ1.getLong(C4039i.c(interfaceC4162dQ1, "card_time")), interfaceC4162dQ1.getLong(C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT))) : null;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final Y8.t o(H1 h12, TaskSessionLink taskSessionLink, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        h12.__insertAdapterOfTaskSessionLink.d(_connection, taskSessionLink);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.session.db.B1
    public void a() {
        final String str = "delete from task_session_link";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.G1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return H1.k(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.B1
    public TaskSessionLink b(final String subSessionKey) {
        kotlin.jvm.internal.p.i(subSessionKey, "subSessionKey");
        final String str = "select * from task_session_link where sub_session_key = (?)";
        return (TaskSessionLink) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.E1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return H1.l(str, subSessionKey, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.B1
    public void c(final TaskSessionLink link) {
        kotlin.jvm.internal.p.i(link, "link");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.F1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return H1.o(this.f22490a, link, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.B1
    public TaskSessionLink d() {
        final String str = "select * from task_session_link where sub_session_key like 'cron-job:%' order by updated_at desc limit 1";
        return (TaskSessionLink) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.D1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return H1.n(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.B1
    public TaskSessionLink e(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        final String str = "select * from task_session_link where task_id = (?)";
        return (TaskSessionLink) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.C1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return H1.m(str, taskId, (InterfaceC4160b) obj);
            }
        });
    }
}
