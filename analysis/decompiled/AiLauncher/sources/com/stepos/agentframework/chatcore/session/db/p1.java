package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.ailauncher.taskstore.provider.c;
import f1.C4031a;
import f1.C4039i;
import f1.C4043m;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w4.ArtifactAvailabilityRow;
import w4.TaskResultArtifactEntity;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0012J}\u0010\"\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010)J'\u0010-\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u001fH\u0016¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010/¨\u00061"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/p1;", "Lcom/stepos/agentframework/chatcore/session/db/f1;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "", "Lw4/j;", "rows", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/util/List;)V", "", "sessionId", "c", "(Ljava/lang/String;)Ljava/util/List;", "sessionIds", "e", "(Ljava/util/List;)Ljava/util/List;", "fileIds", "Lw4/b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "fileId", "messageId", "toolCallId", "taskId", "versionId", "cloudPath", "fileName", "title", "mimeType", "", ContentDisposition.Parameters.Size, "createdAt", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;J)V", "oldSessionId", "newSessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "()V", "", "availability", "checkedAt", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;IJ)V", "Landroidx/room/RoomDatabase;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class p1 implements InterfaceC1883f1 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/p1$a;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.p1$a, reason: from kotlin metadata */
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

    public p1(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
    }

    public static final Y8.t q(String str, InterfaceC4160b _connection) {
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

    public static final List r(String str, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new ArtifactAvailabilityRow(interfaceC4162dQ1.X0(0), (int) interfaceC4162dQ1.getLong(1), interfaceC4162dQ1.getLong(2)));
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final List s(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, "file_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC4 = C4039i.c(interfaceC4162dQ1, "tool_call_id");
            int iC5 = C4039i.c(interfaceC4162dQ1, "task_id");
            int iC6 = C4039i.c(interfaceC4162dQ1, "version_id");
            int iC7 = C4039i.c(interfaceC4162dQ1, "cloud_path");
            int iC8 = C4039i.c(interfaceC4162dQ1, "file_name");
            int iC9 = C4039i.c(interfaceC4162dQ1, "title");
            int iC10 = C4039i.c(interfaceC4162dQ1, "mime_type");
            int iC11 = C4039i.c(interfaceC4162dQ1, ContentDisposition.Parameters.Size);
            int iC12 = C4039i.c(interfaceC4162dQ1, c.a.COL_CREATED_AT);
            int iC13 = C4039i.c(interfaceC4162dQ1, "availability");
            int iC14 = C4039i.c(interfaceC4162dQ1, "checked_at");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                int i10 = iC2;
                int i11 = iC3;
                arrayList.add(new TaskResultArtifactEntity(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.isNull(iC5) ? null : interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.isNull(iC6) ? null : interfaceC4162dQ1.X0(iC6), interfaceC4162dQ1.isNull(iC7) ? null : interfaceC4162dQ1.X0(iC7), interfaceC4162dQ1.isNull(iC8) ? null : interfaceC4162dQ1.X0(iC8), interfaceC4162dQ1.isNull(iC9) ? null : interfaceC4162dQ1.X0(iC9), interfaceC4162dQ1.isNull(iC10) ? null : interfaceC4162dQ1.X0(iC10), interfaceC4162dQ1.isNull(iC11) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC11)), interfaceC4162dQ1.getLong(iC12), (int) interfaceC4162dQ1.getLong(iC13), interfaceC4162dQ1.getLong(iC14)));
                iC2 = i10;
                iC3 = i11;
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final Y8.t t(String str, String str2, String str3, InterfaceC4160b _connection) {
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

    public static final List u(String str, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(interfaceC4162dQ1.X0(0));
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t v(String str, int i10, long j10, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, i10);
            interfaceC4162dQ1.bindLong(2, j10);
            interfaceC4162dQ1.H(3, str2);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t w(p1 p1Var, List list, InterfaceC4160b interfaceC4160b) {
        kotlin.jvm.internal.p.i(interfaceC4160b, "<unused var>");
        super.d(list);
        return Y8.t.f7040a;
    }

    public static final Y8.t x(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l10, long j10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.H(2, str3);
            interfaceC4162dQ1.H(3, str4);
            interfaceC4162dQ1.H(4, str5);
            if (str6 == null) {
                interfaceC4162dQ1.bindNull(5);
            } else {
                interfaceC4162dQ1.H(5, str6);
            }
            if (str7 == null) {
                interfaceC4162dQ1.bindNull(6);
            } else {
                interfaceC4162dQ1.H(6, str7);
            }
            if (str8 == null) {
                interfaceC4162dQ1.bindNull(7);
            } else {
                interfaceC4162dQ1.H(7, str8);
            }
            if (str9 == null) {
                interfaceC4162dQ1.bindNull(8);
            } else {
                interfaceC4162dQ1.H(8, str9);
            }
            if (str10 == null) {
                interfaceC4162dQ1.bindNull(9);
            } else {
                interfaceC4162dQ1.H(9, str10);
            }
            if (str11 == null) {
                interfaceC4162dQ1.bindNull(10);
            } else {
                interfaceC4162dQ1.H(10, str11);
            }
            if (l10 == null) {
                interfaceC4162dQ1.bindNull(11);
            } else {
                interfaceC4162dQ1.bindLong(11, l10.longValue());
            }
            interfaceC4162dQ1.bindLong(12, j10);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1883f1
    public void a() {
        final String str = "DELETE FROM task_result_artifact";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.m1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p1.q(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1883f1
    public void b(final String oldSessionId, final String newSessionId) {
        kotlin.jvm.internal.p.i(oldSessionId, "oldSessionId");
        kotlin.jvm.internal.p.i(newSessionId, "newSessionId");
        final String str = "UPDATE task_result_artifact SET session_id = ? WHERE session_id = ?";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.k1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p1.t(str, newSessionId, oldSessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1883f1
    public List<TaskResultArtifactEntity> c(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "SELECT * FROM task_result_artifact WHERE session_id = ? ORDER BY created_at ASC";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.o1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p1.s(str, sessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1883f1
    public void d(final List<TaskResultArtifactEntity> rows) {
        kotlin.jvm.internal.p.i(rows, "rows");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.h1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p1.w(this.f22597a, rows, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1883f1
    public List<String> e(final List<String> sessionIds) {
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT DISTINCT session_id FROM task_result_artifact WHERE session_id IN (");
        C4043m.a(sb2, sessionIds.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.j1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p1.u(string, sessionIds, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1883f1
    public void f(final String fileId, final String sessionId, final String messageId, final String toolCallId, final String taskId, final String versionId, final String cloudPath, final String fileName, final String title, final String mimeType, final Long size, final long createdAt) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        final String str = "\n        INSERT INTO task_result_artifact (\n            file_id, session_id, message_id, tool_call_id, task_id, version_id,\n            cloud_path, file_name, title, mime_type, size, created_at, availability, checked_at\n        ) VALUES (\n            ?, ?, ?, ?, ?, ?,\n            ?, ?, ?, ?, ?, ?, 0, 0\n        )\n        ON CONFLICT(file_id) DO UPDATE SET\n            session_id = excluded.session_id,\n            message_id = excluded.message_id,\n            tool_call_id = excluded.tool_call_id,\n            task_id = excluded.task_id,\n            version_id = excluded.version_id,\n            cloud_path = excluded.cloud_path,\n            file_name = excluded.file_name,\n            title = excluded.title,\n            mime_type = excluded.mime_type,\n            size = excluded.size,\n            created_at = excluded.created_at\n        ";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.i1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p1.x(str, fileId, sessionId, messageId, toolCallId, taskId, versionId, cloudPath, fileName, title, mimeType, size, createdAt, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1883f1
    public List<ArtifactAvailabilityRow> g(final List<String> fileIds) {
        kotlin.jvm.internal.p.i(fileIds, "fileIds");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT file_id, availability, checked_at FROM task_result_artifact WHERE file_id IN (");
        C4043m.a(sb2, fileIds.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.l1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p1.r(string, fileIds, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1883f1
    public void h(final String fileId, final int availability, final long checkedAt) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        final String str = "UPDATE task_result_artifact SET availability = ?, checked_at = ? WHERE file_id = ?";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.n1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p1.v(str, availability, checkedAt, fileId, (InterfaceC4160b) obj);
            }
        });
    }
}
