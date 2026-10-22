package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.provider.c;
import f1.C4031a;
import f1.C4038h;
import f1.C4039i;
import f1.C4043m;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w4.TaskSearchDocumentEntity;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\u00020\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eH\u0016¢\u0006\u0004\b \u0010\u0012J\u001f\u0010#\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/A1;", "Lcom/stepos/agentframework/chatcore/session/db/q1;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lw4/k;", "document", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw4/k;)V", "", "c", "(Lw4/k;)Z", "", "documents", "", "f", "(Ljava/util/List;)I", "e", "", "taskId", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Ljava/lang/Long;", "query", "prefixPattern", "containsPattern", "limit", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/util/List;", "taskIds", Const.INTENT_KEY_UMID, "oldSessionId", "newSessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)I", Const.INTENT_KEY_APIKEY, "()V", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfTaskSearchDocumentEntity", "Landroidx/room/f;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class A1 implements q1 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1410f<TaskSearchDocumentEntity> __insertAdapterOfTaskSearchDocumentEntity;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/A1$a", "Landroidx/room/f;", "Lw4/k;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lw4/k;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1410f<TaskSearchDocumentEntity> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `task_search_document` (`task_id`,`session_id`,`title`,`searchable_text`,`status`,`updated_at`,`read_at`) VALUES (?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, TaskSearchDocumentEntity entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getTaskId());
            statement.H(2, entity.getSessionId());
            statement.H(3, entity.getTitle());
            statement.H(4, entity.getSearchableText());
            statement.H(5, entity.getStatus());
            statement.bindLong(6, entity.getUpdatedAt());
            Long readAt = entity.getReadAt();
            if (readAt == null) {
                statement.bindNull(7);
            } else {
                statement.bindLong(7, readAt.longValue());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/A1$b;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.A1$b, reason: from kotlin metadata */
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

    public A1(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfTaskSearchDocumentEntity = new a();
    }

    public static final boolean A(A1 a12, TaskSearchDocumentEntity taskSearchDocumentEntity, InterfaceC4160b interfaceC4160b) {
        kotlin.jvm.internal.p.i(interfaceC4160b, "<unused var>");
        return super.c(taskSearchDocumentEntity);
    }

    public static final Y8.t s(String str, InterfaceC4160b _connection) {
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

    public static final int t(String str, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            interfaceC4162dQ1.n1();
            int iB = C4038h.b(_connection);
            interfaceC4162dQ1.close();
            return iB;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Long u(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            Long lValueOf = null;
            if (interfaceC4162dQ1.n1() && !interfaceC4162dQ1.isNull(0)) {
                lValueOf = Long.valueOf(interfaceC4162dQ1.getLong(0));
            }
            return lValueOf;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final Y8.t v(A1 a12, TaskSearchDocumentEntity taskSearchDocumentEntity, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        a12.__insertAdapterOfTaskSearchDocumentEntity.d(_connection, taskSearchDocumentEntity);
        return Y8.t.f7040a;
    }

    public static final int w(A1 a12, List list, InterfaceC4160b interfaceC4160b) {
        kotlin.jvm.internal.p.i(interfaceC4160b, "<unused var>");
        return super.e(list);
    }

    public static final int x(String str, String str2, String str3, InterfaceC4160b _connection) {
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

    public static final List y(String str, String str2, String str3, String str4, int i10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.H(2, str2);
            interfaceC4162dQ1.H(3, str3);
            interfaceC4162dQ1.H(4, str4);
            interfaceC4162dQ1.H(5, str2);
            interfaceC4162dQ1.bindLong(6, i10);
            int iC = C4039i.c(interfaceC4162dQ1, "task_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "title");
            int iC4 = C4039i.c(interfaceC4162dQ1, "searchable_text");
            int iC5 = C4039i.c(interfaceC4162dQ1, "status");
            int iC6 = C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT);
            int iC7 = C4039i.c(interfaceC4162dQ1, "read_at");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new TaskSearchDocumentEntity(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.getLong(iC6), interfaceC4162dQ1.isNull(iC7) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC7))));
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final int z(A1 a12, List list, InterfaceC4160b interfaceC4160b) {
        kotlin.jvm.internal.p.i(interfaceC4160b, "<unused var>");
        return super.f(list);
    }

    @Override // com.stepos.agentframework.chatcore.session.db.q1
    public void a() {
        final String str = "DELETE FROM task_search_document";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.s1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return A1.s(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.q1
    public int b(final String oldSessionId, final String newSessionId) {
        kotlin.jvm.internal.p.i(oldSessionId, "oldSessionId");
        kotlin.jvm.internal.p.i(newSessionId, "newSessionId");
        final String str = "UPDATE task_search_document SET session_id = ? WHERE session_id = ?";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.r1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(A1.x(str, newSessionId, oldSessionId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.q1
    public boolean c(final TaskSearchDocumentEntity document) {
        kotlin.jvm.internal.p.i(document, "document");
        return ((Boolean) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.u1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(A1.A(this.f22693a, document, (InterfaceC4160b) obj));
            }
        })).booleanValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.q1
    public int d(final List<String> taskIds) {
        kotlin.jvm.internal.p.i(taskIds, "taskIds");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM task_search_document WHERE task_id IN (");
        C4043m.a(sb2, taskIds.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.y1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(A1.t(string, taskIds, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.q1
    public int e(final List<TaskSearchDocumentEntity> documents) {
        kotlin.jvm.internal.p.i(documents, "documents");
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.z1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(A1.w(this.f22721a, documents, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.q1
    public int f(final List<TaskSearchDocumentEntity> documents) {
        kotlin.jvm.internal.p.i(documents, "documents");
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.w1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(A1.z(this.f22703a, documents, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.q1
    public void g(final TaskSearchDocumentEntity document) {
        kotlin.jvm.internal.p.i(document, "document");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.t1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return A1.v(this.f22687a, document, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.q1
    public List<TaskSearchDocumentEntity> h(final String query, final String prefixPattern, final String containsPattern, final int limit) {
        kotlin.jvm.internal.p.i(query, "query");
        kotlin.jvm.internal.p.i(prefixPattern, "prefixPattern");
        kotlin.jvm.internal.p.i(containsPattern, "containsPattern");
        final String str = "SELECT * FROM task_search_document WHERE session_id != '' AND EXISTS (SELECT 1 FROM conversation_title AS t WHERE t.session_id = task_search_document.session_id AND t.is_temp_session = 0 AND t.delete_status = 0 AND t.session_id NOT LIKE 'agent:task-%' AND t.session_id NOT LIKE 'cron:%') AND (LOWER(title) LIKE LOWER(?) ESCAPE '\\' OR LOWER(searchable_text) LIKE LOWER(?) ESCAPE '\\') ORDER BY CASE WHEN LOWER(title) = LOWER(?) THEN 4 WHEN LOWER(title) LIKE LOWER(?) ESCAPE '\\' THEN 3 WHEN LOWER(title) LIKE LOWER(?) ESCAPE '\\' THEN 2 ELSE 1 END DESC, updated_at DESC, task_id ASC LIMIT ?";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.x1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return A1.y(str, containsPattern, query, prefixPattern, limit, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.q1
    public Long i(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        final String str = "SELECT updated_at FROM task_search_document WHERE task_id = ? LIMIT 1";
        return (Long) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.v1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return A1.u(str, taskId, (InterfaceC4160b) obj);
            }
        });
    }
}
