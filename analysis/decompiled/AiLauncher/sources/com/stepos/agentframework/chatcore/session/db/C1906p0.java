package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
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
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 F2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\rJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b#\u0010\"J\u0017\u0010$\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b$\u0010\"J\u001f\u0010%\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0012H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0012H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0012H\u0016¢\u0006\u0004\b)\u0010&J\u001f\u0010+\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000fH\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010/\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J'\u00104\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020-H\u0016¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u00103\u001a\u00020-H\u0016¢\u0006\u0004\b6\u00107J\u001f\u00109\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u0014H\u0016¢\u0006\u0004\b9\u0010:J\u001f\u0010<\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u000fH\u0016¢\u0006\u0004\b<\u0010=J\u001f\u0010?\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u000fH\u0016¢\u0006\u0004\b?\u0010=J\u000f\u0010@\u001a\u00020\bH\u0016¢\u0006\u0004\b@\u0010AR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010BR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/p0;", "Lcom/stepos/agentframework/chatcore/session/db/Q;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lw4/e;", "title", "LY8/t;", "r", "(Lw4/e;)V", "", "q", "()Ljava/util/List;", "v", "", "p", "()J", "", "titlePattern", "", "limit", "e", "(Ljava/lang/String;I)Ljava/util/List;", "sessionIds", "u", "(Ljava/util/List;)Ljava/util/List;", "sessionId", "c", "(Ljava/lang/String;)Lw4/e;", "w", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", "o", "(Ljava/lang/String;)I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "n", "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)I", "f", "lastReadAt", "k", "(Ljava/lang/String;J)V", "", "failed", "t", "(Ljava/lang/String;Z)I", "oldSessionId", "newSessionId", "isTempSession", "l", "(Ljava/lang/String;Ljava/lang/String;Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Z)V", "sessionKind", Const.INTENT_KEY_UMID, "(Ljava/lang/String;I)V", "lastActiveAt", "m", "(Ljava/lang/String;J)I", "at", "s", Const.INTENT_KEY_APIKEY, "()V", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfConversationTitle", "Landroidx/room/f;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.db.p0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1906p0 implements Q {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1410f<w4.e> __insertAdapterOfConversationTitle;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/p0$a", "Landroidx/room/f;", "Lw4/e;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lw4/e;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.p0$a */
    public static final class a extends AbstractC1410f<w4.e> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `conversation_title` (`id`,`session_id`,`title`,`agent_id`,`device_id`,`create_time`,`last_active_at`,`last_read_at`,`is_temp_session`,`session_kind`,`send_failed`,`title_source`,`delete_status`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, w4.e entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.bindLong(1, entity.getId());
            statement.H(2, entity.getSessionId());
            statement.H(3, entity.getTitle());
            statement.H(4, entity.getAgentId());
            statement.H(5, entity.getDeviceId());
            statement.bindLong(6, entity.getCreateTime());
            statement.bindLong(7, entity.getLastActiveAt());
            statement.bindLong(8, entity.getLastReadAt());
            statement.bindLong(9, entity.getIsTempSession() ? 1L : 0L);
            statement.bindLong(10, entity.getSessionKind());
            statement.bindLong(11, entity.getSendFailed() ? 1L : 0L);
            statement.bindLong(12, entity.getTitleSource());
            statement.bindLong(13, entity.getDeleteStatus());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/p0$b;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.p0$b, reason: from kotlin metadata */
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

    public C1906p0(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfConversationTitle = new a();
    }

    public static final int U(String str, String str2, String str3, InterfaceC4160b _connection) {
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

    public static final int V(String str, String str2, InterfaceC4160b _connection) {
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

    public static final Y8.t W(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t X(String str, InterfaceC4160b _connection) {
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

    public static final List Y(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            int iC = C4039i.c(interfaceC4162dQ1, "id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "title");
            int iC4 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC5 = C4039i.c(interfaceC4162dQ1, Parameters.DEVICE_ID);
            int iC6 = C4039i.c(interfaceC4162dQ1, "create_time");
            int iC7 = C4039i.c(interfaceC4162dQ1, "last_active_at");
            int iC8 = C4039i.c(interfaceC4162dQ1, "last_read_at");
            int iC9 = C4039i.c(interfaceC4162dQ1, "is_temp_session");
            int iC10 = C4039i.c(interfaceC4162dQ1, "session_kind");
            int iC11 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC12 = C4039i.c(interfaceC4162dQ1, "title_source");
            int iC13 = C4039i.c(interfaceC4162dQ1, "delete_status");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                ArrayList arrayList2 = arrayList;
                int i10 = (int) interfaceC4162dQ1.getLong(iC);
                String strX0 = interfaceC4162dQ1.X0(iC2);
                String strX02 = interfaceC4162dQ1.X0(iC3);
                String strX03 = interfaceC4162dQ1.X0(iC4);
                int i11 = iC2;
                int i12 = iC3;
                iC4 = iC4;
                arrayList2.add(new w4.e(i10, strX0, strX02, strX03, interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.getLong(iC6), interfaceC4162dQ1.getLong(iC7), interfaceC4162dQ1.getLong(iC8), ((int) interfaceC4162dQ1.getLong(iC9)) != 0, (int) interfaceC4162dQ1.getLong(iC10), ((int) interfaceC4162dQ1.getLong(iC11)) != 0, (int) interfaceC4162dQ1.getLong(iC12), (int) interfaceC4162dQ1.getLong(iC13)));
                iC2 = i11;
                arrayList = arrayList2;
                iC3 = i12;
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final long Z(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            return interfaceC4162dQ1.n1() ? interfaceC4162dQ1.getLong(0) : 0L;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final w4.e a0(String str, String str2, InterfaceC4160b _connection) {
        w4.e eVar;
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, "id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "title");
            int iC4 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC5 = C4039i.c(interfaceC4162dQ1, Parameters.DEVICE_ID);
            int iC6 = C4039i.c(interfaceC4162dQ1, "create_time");
            int iC7 = C4039i.c(interfaceC4162dQ1, "last_active_at");
            int iC8 = C4039i.c(interfaceC4162dQ1, "last_read_at");
            int iC9 = C4039i.c(interfaceC4162dQ1, "is_temp_session");
            int iC10 = C4039i.c(interfaceC4162dQ1, "session_kind");
            int iC11 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC12 = C4039i.c(interfaceC4162dQ1, "title_source");
            int iC13 = C4039i.c(interfaceC4162dQ1, "delete_status");
            if (interfaceC4162dQ1.n1()) {
                eVar = new w4.e((int) interfaceC4162dQ1.getLong(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.getLong(iC6), interfaceC4162dQ1.getLong(iC7), interfaceC4162dQ1.getLong(iC8), ((int) interfaceC4162dQ1.getLong(iC9)) != 0, (int) interfaceC4162dQ1.getLong(iC10), ((int) interfaceC4162dQ1.getLong(iC11)) != 0, (int) interfaceC4162dQ1.getLong(iC12), (int) interfaceC4162dQ1.getLong(iC13));
            } else {
                eVar = null;
            }
            return eVar;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List b0(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            int iC = C4039i.c(interfaceC4162dQ1, "id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "title");
            int iC4 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC5 = C4039i.c(interfaceC4162dQ1, Parameters.DEVICE_ID);
            int iC6 = C4039i.c(interfaceC4162dQ1, "create_time");
            int iC7 = C4039i.c(interfaceC4162dQ1, "last_active_at");
            int iC8 = C4039i.c(interfaceC4162dQ1, "last_read_at");
            int iC9 = C4039i.c(interfaceC4162dQ1, "is_temp_session");
            int iC10 = C4039i.c(interfaceC4162dQ1, "session_kind");
            int iC11 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC12 = C4039i.c(interfaceC4162dQ1, "title_source");
            int iC13 = C4039i.c(interfaceC4162dQ1, "delete_status");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                ArrayList arrayList2 = arrayList;
                int i10 = (int) interfaceC4162dQ1.getLong(iC);
                String strX0 = interfaceC4162dQ1.X0(iC2);
                String strX02 = interfaceC4162dQ1.X0(iC3);
                String strX03 = interfaceC4162dQ1.X0(iC4);
                int i11 = iC2;
                int i12 = iC3;
                iC4 = iC4;
                arrayList2.add(new w4.e(i10, strX0, strX02, strX03, interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.getLong(iC6), interfaceC4162dQ1.getLong(iC7), interfaceC4162dQ1.getLong(iC8), ((int) interfaceC4162dQ1.getLong(iC9)) != 0, (int) interfaceC4162dQ1.getLong(iC10), ((int) interfaceC4162dQ1.getLong(iC11)) != 0, (int) interfaceC4162dQ1.getLong(iC12), (int) interfaceC4162dQ1.getLong(iC13)));
                iC2 = i11;
                arrayList = arrayList2;
                iC3 = i12;
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List c0(String str, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            int iC = C4039i.c(interfaceC4162dQ1, "id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "title");
            int iC4 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC5 = C4039i.c(interfaceC4162dQ1, Parameters.DEVICE_ID);
            int iC6 = C4039i.c(interfaceC4162dQ1, "create_time");
            int iC7 = C4039i.c(interfaceC4162dQ1, "last_active_at");
            int iC8 = C4039i.c(interfaceC4162dQ1, "last_read_at");
            int iC9 = C4039i.c(interfaceC4162dQ1, "is_temp_session");
            int iC10 = C4039i.c(interfaceC4162dQ1, "session_kind");
            int iC11 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC12 = C4039i.c(interfaceC4162dQ1, "title_source");
            int iC13 = C4039i.c(interfaceC4162dQ1, "delete_status");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                int i11 = iC2;
                int i12 = iC3;
                arrayList.add(new w4.e((int) interfaceC4162dQ1.getLong(iC), interfaceC4162dQ1.X0(i11), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.getLong(iC6), interfaceC4162dQ1.getLong(iC7), interfaceC4162dQ1.getLong(iC8), ((int) interfaceC4162dQ1.getLong(iC9)) != 0, (int) interfaceC4162dQ1.getLong(iC10), ((int) interfaceC4162dQ1.getLong(iC11)) != 0, (int) interfaceC4162dQ1.getLong(iC12), (int) interfaceC4162dQ1.getLong(iC13)));
                iC2 = i11;
                iC3 = i12;
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final List d0(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            int iC = C4039i.c(interfaceC4162dQ1, "id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "title");
            int iC4 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC5 = C4039i.c(interfaceC4162dQ1, Parameters.DEVICE_ID);
            int iC6 = C4039i.c(interfaceC4162dQ1, "create_time");
            int iC7 = C4039i.c(interfaceC4162dQ1, "last_active_at");
            int iC8 = C4039i.c(interfaceC4162dQ1, "last_read_at");
            int iC9 = C4039i.c(interfaceC4162dQ1, "is_temp_session");
            int iC10 = C4039i.c(interfaceC4162dQ1, "session_kind");
            int iC11 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC12 = C4039i.c(interfaceC4162dQ1, "title_source");
            int iC13 = C4039i.c(interfaceC4162dQ1, "delete_status");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                ArrayList arrayList2 = arrayList;
                int i10 = (int) interfaceC4162dQ1.getLong(iC);
                String strX0 = interfaceC4162dQ1.X0(iC2);
                String strX02 = interfaceC4162dQ1.X0(iC3);
                String strX03 = interfaceC4162dQ1.X0(iC4);
                int i11 = iC2;
                int i12 = iC3;
                iC4 = iC4;
                arrayList2.add(new w4.e(i10, strX0, strX02, strX03, interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.getLong(iC6), interfaceC4162dQ1.getLong(iC7), interfaceC4162dQ1.getLong(iC8), ((int) interfaceC4162dQ1.getLong(iC9)) != 0, (int) interfaceC4162dQ1.getLong(iC10), ((int) interfaceC4162dQ1.getLong(iC11)) != 0, (int) interfaceC4162dQ1.getLong(iC12), (int) interfaceC4162dQ1.getLong(iC13)));
                iC2 = i11;
                arrayList = arrayList2;
                iC3 = i12;
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final Y8.t e0(C1906p0 c1906p0, w4.e eVar, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        c1906p0.__insertAdapterOfConversationTitle.d(_connection, eVar);
        return Y8.t.f7040a;
    }

    public static final int f0(String str, String str2, InterfaceC4160b _connection) {
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

    public static final int g0(String str, String str2, InterfaceC4160b _connection) {
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

    public static final Y8.t h0(String str, long j10, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, j10);
            interfaceC4162dQ1.H(2, str2);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t i0(String str, String str2, String str3, InterfaceC4160b _connection) {
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

    public static final Y8.t j0(String str, String str2, String str3, InterfaceC4160b _connection) {
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

    public static final Y8.t k0(String str, String str2, boolean z10, String str3, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.bindLong(2, z10 ? 1L : 0L);
            interfaceC4162dQ1.H(3, str3);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final List l0(String str, String str2, int i10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.bindLong(2, i10);
            int iC = C4039i.c(interfaceC4162dQ1, "id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "title");
            int iC4 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC5 = C4039i.c(interfaceC4162dQ1, Parameters.DEVICE_ID);
            int iC6 = C4039i.c(interfaceC4162dQ1, "create_time");
            int iC7 = C4039i.c(interfaceC4162dQ1, "last_active_at");
            int iC8 = C4039i.c(interfaceC4162dQ1, "last_read_at");
            int iC9 = C4039i.c(interfaceC4162dQ1, "is_temp_session");
            int iC10 = C4039i.c(interfaceC4162dQ1, "session_kind");
            int iC11 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC12 = C4039i.c(interfaceC4162dQ1, "title_source");
            int iC13 = C4039i.c(interfaceC4162dQ1, "delete_status");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                int i11 = iC13;
                ArrayList arrayList2 = arrayList;
                int i12 = (int) interfaceC4162dQ1.getLong(iC);
                int i13 = iC;
                int i14 = iC2;
                int i15 = iC3;
                int i16 = iC4;
                arrayList2.add(new w4.e(i12, interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.getLong(iC6), interfaceC4162dQ1.getLong(iC7), interfaceC4162dQ1.getLong(iC8), ((int) interfaceC4162dQ1.getLong(iC9)) != 0, (int) interfaceC4162dQ1.getLong(iC10), ((int) interfaceC4162dQ1.getLong(iC11)) != 0, (int) interfaceC4162dQ1.getLong(iC12), (int) interfaceC4162dQ1.getLong(i11)));
                arrayList = arrayList2;
                iC3 = i15;
                iC4 = i16;
                iC = i13;
                iC13 = i11;
                iC2 = i14;
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final int m0(String str, long j10, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, j10);
            interfaceC4162dQ1.bindLong(2, j10);
            interfaceC4162dQ1.H(3, str2);
            interfaceC4162dQ1.n1();
            return C4038h.b(_connection);
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final int n0(String str, long j10, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, j10);
            interfaceC4162dQ1.H(2, str2);
            interfaceC4162dQ1.n1();
            return C4038h.b(_connection);
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final int o0(String str, boolean z10, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, z10 ? 1L : 0L);
            interfaceC4162dQ1.H(2, str2);
            interfaceC4162dQ1.bindLong(3, z10 ? 1L : 0L);
            interfaceC4162dQ1.n1();
            return C4038h.b(_connection);
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final Y8.t p0(String str, int i10, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, i10);
            interfaceC4162dQ1.H(2, str2);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t q0(String str, boolean z10, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, z10 ? 1L : 0L);
            interfaceC4162dQ1.H(2, str2);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public void a() {
        final String str = "delete from conversation_title";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.c0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.X(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public int b(final String sessionId, final String title) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(title, "title");
        final String str = "update conversation_title set title = (?), title_source = 1 where session_id = (?) and title_source != 2 and delete_status != 2";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.S
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(C1906p0.U(str, title, sessionId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public w4.e c(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "select * from conversation_title where session_id = (?)";
        return (w4.e) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.m0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.a0(str, sessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public void d(final String sessionId, final int sessionKind) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "update conversation_title set session_kind = (?) where session_id = (?) and delete_status != 2";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.W
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.p0(str, sessionKind, sessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public List<w4.e> e(final String titlePattern, final int limit) {
        kotlin.jvm.internal.p.i(titlePattern, "titlePattern");
        final String str = "select * from conversation_title where is_temp_session = 0 and delete_status = 0 and title != '' and session_id NOT LIKE 'agent:task-%' and session_id NOT LIKE 'cron:%' and not (session_id LIKE 'agent:%:main' and session_id NOT LIKE 'agent:main:%') and LOWER(title) LIKE LOWER(?) ESCAPE '\\' order by last_active_at desc limit ?";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.g0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.l0(str, titlePattern, limit, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public void f(final String sessionId, final String title) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(title, "title");
        final String str = "update conversation_title set title = (?), title_source = 2 where session_id = (?) and delete_status != 2";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.b0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.j0(str, title, sessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public void g(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "delete from conversation_title where session_id = (?)";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.Y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.W(str, sessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public int h(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "update conversation_title set delete_status = 0 where session_id = (?) and delete_status = 1";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.e0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(C1906p0.V(str, sessionId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public int i(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "update conversation_title set delete_status = 2 where session_id = (?) and delete_status != 2";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.Z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(C1906p0.f0(str, sessionId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public void j(final String sessionId, final boolean isTempSession) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "update conversation_title set is_temp_session = (?) where session_id = (?) and delete_status != 2";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.o0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.q0(str, isTempSession, sessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public void k(final String sessionId, final long lastReadAt) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "update conversation_title set last_read_at = max(?, last_active_at) where session_id = (?) and delete_status != 2";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.j0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.h0(str, lastReadAt, sessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public void l(final String oldSessionId, final String newSessionId, final boolean isTempSession) {
        kotlin.jvm.internal.p.i(oldSessionId, "oldSessionId");
        kotlin.jvm.internal.p.i(newSessionId, "newSessionId");
        final String str = "update conversation_title set session_id = (?), is_temp_session = (?) where session_id = (?) and delete_status != 2";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.X
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.k0(str, newSessionId, isTempSession, oldSessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public int m(final String sessionId, final long lastActiveAt) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "update conversation_title set last_active_at = (?) where session_id = (?) and delete_status != 2";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.l0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(C1906p0.n0(str, lastActiveAt, sessionId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public void n(final String sessionId, final String title) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(title, "title");
        final String str = "update conversation_title set title = (?) where session_id = (?) and delete_status != 2";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.V
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.i0(str, title, sessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public int o(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "update conversation_title set delete_status = 1 where session_id = (?) and delete_status = 0";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.U
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(C1906p0.g0(str, sessionId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public long p() {
        final String str = "select coalesce(max(last_active_at), 0) from conversation_title where delete_status = 0";
        return ((Number) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.n0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Long.valueOf(C1906p0.Z(str, (InterfaceC4160b) obj));
            }
        })).longValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public List<w4.e> q() {
        final String str = "select * from conversation_title where delete_status = 0 order by last_active_at desc";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.h0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.b0(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public void r(final w4.e title) {
        kotlin.jvm.internal.p.i(title, "title");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.a0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.e0(this.f22562a, title, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public int s(final String sessionId, final long at) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "update conversation_title set last_active_at = (?), last_read_at = (?) where session_id = (?) and delete_status != 2";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.k0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(C1906p0.m0(str, at, sessionId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public int t(final String sessionId, final boolean failed) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "update conversation_title set send_failed = (?) where session_id = (?) and send_failed != (?) and delete_status != 2";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.i0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(C1906p0.o0(str, failed, sessionId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public List<w4.e> u(final List<String> sessionIds) {
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("select * from conversation_title where delete_status = 0 and session_id in (");
        C4043m.a(sb2, sessionIds.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.f0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.c0(string, sessionIds, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public List<w4.e> v() {
        final String str = "select * from conversation_title where session_id != '' and delete_status = 0 and (is_temp_session = 0 or exists(select 1 from chat_message m where m.session_id = conversation_title.session_id and m.role = 'USER')) and session_id NOT LIKE 'agent:task-%' and session_id NOT LIKE 'cron:%' and not (session_id LIKE 'agent:%:main' and session_id NOT LIKE 'agent:main:%') order by last_active_at desc, create_time desc, session_id asc";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.T
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.d0(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.Q
    public List<w4.e> w() {
        final String str = "select * from conversation_title where delete_status = 1";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.d0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1906p0.Y(str, (InterfaceC4160b) obj);
            }
        });
    }
}
