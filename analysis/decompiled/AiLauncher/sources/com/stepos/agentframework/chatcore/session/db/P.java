package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
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
import w4.ChatMessageVariant;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/P;", "Lcom/stepos/agentframework/chatcore/session/db/F;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lw4/d;", "variant", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw4/d;)V", "", "groupId", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/util/List;", "", "variantIndex", "k", "(Ljava/lang/String;I)Lw4/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)I", "l", "(Ljava/lang/String;)Ljava/lang/Integer;", "groupIds", "Lcom/stepos/agentframework/chatcore/session/db/I1;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;)Ljava/util/List;", "f", "(Ljava/lang/String;I)V", "sessionId", "e", "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "()V", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfChatMessageVariant", "Landroidx/room/f;", "Companion", Const.INTENT_KEY_PKGNAME, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class P implements F {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1410f<ChatMessageVariant> __insertAdapterOfChatMessageVariant;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/P$a", "Landroidx/room/f;", "Lw4/d;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lw4/d;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1410f<ChatMessageVariant> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `chat_message_variant` (`id`,`message_id`,`group_id`,`variant_index`,`session_id`,`snapshot_json`,`archived_at`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, ChatMessageVariant entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.bindLong(1, entity.getId());
            statement.H(2, entity.getMessageId());
            statement.H(3, entity.getGroupId());
            statement.bindLong(4, entity.getVariantIndex());
            statement.H(5, entity.getSessionId());
            statement.H(6, entity.getSnapshotJson());
            statement.bindLong(7, entity.getArchivedAt());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/P$b;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.P$b, reason: from kotlin metadata */
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

    public P(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfChatMessageVariant = new a();
    }

    public static final Integer A(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            Integer numValueOf = null;
            if (interfaceC4162dQ1.n1() && !interfaceC4162dQ1.isNull(0)) {
                numValueOf = Integer.valueOf((int) interfaceC4162dQ1.getLong(0));
            }
            return numValueOf;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final int s(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            return interfaceC4162dQ1.n1() ? (int) interfaceC4162dQ1.getLong(0) : 0;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List t(String str, List list, InterfaceC4160b _connection) {
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
                arrayList.add(new VariantGroupCount(interfaceC4162dQ1.X0(0), (int) interfaceC4162dQ1.getLong(1)));
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t u(String str, InterfaceC4160b _connection) {
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

    public static final Y8.t v(String str, String str2, int i10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.bindLong(2, i10);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t w(String str, String str2, InterfaceC4160b _connection) {
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

    public static final List x(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, "id");
            int iC2 = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC3 = C4039i.c(interfaceC4162dQ1, "group_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "variant_index");
            int iC5 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC6 = C4039i.c(interfaceC4162dQ1, "snapshot_json");
            int iC7 = C4039i.c(interfaceC4162dQ1, "archived_at");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new ChatMessageVariant(interfaceC4162dQ1.getLong(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), (int) interfaceC4162dQ1.getLong(iC4), interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.X0(iC6), interfaceC4162dQ1.getLong(iC7)));
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final ChatMessageVariant y(String str, String str2, int i10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.bindLong(2, i10);
            return interfaceC4162dQ1.n1() ? new ChatMessageVariant(interfaceC4162dQ1.getLong(C4039i.c(interfaceC4162dQ1, "id")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID)), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "group_id")), (int) interfaceC4162dQ1.getLong(C4039i.c(interfaceC4162dQ1, "variant_index")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "session_id")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "snapshot_json")), interfaceC4162dQ1.getLong(C4039i.c(interfaceC4162dQ1, "archived_at"))) : null;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final Y8.t z(P p10, ChatMessageVariant chatMessageVariant, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        p10.__insertAdapterOfChatMessageVariant.d(_connection, chatMessageVariant);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.session.db.F
    public void a() {
        final String str = "delete from chat_message_variant";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.K
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return P.u(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.F
    public void e(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "delete from chat_message_variant where session_id = (?)";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.H
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return P.w(str, sessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.F
    public void f(final String groupId, final int variantIndex) {
        kotlin.jvm.internal.p.i(groupId, "groupId");
        final String str = "delete from chat_message_variant where group_id = (?) and variant_index = (?)";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.M
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return P.v(str, groupId, variantIndex, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.F
    public void g(final ChatMessageVariant variant) {
        kotlin.jvm.internal.p.i(variant, "variant");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.I
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return P.z(this.f22499a, variant, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.F
    public int h(final String groupId) {
        kotlin.jvm.internal.p.i(groupId, "groupId");
        final String str = "select count(*) from chat_message_variant where group_id = (?)";
        return ((Number) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.N
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(P.s(str, groupId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.F
    public List<VariantGroupCount> i(final List<String> groupIds) {
        kotlin.jvm.internal.p.i(groupIds, "groupIds");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("select group_id as groupId, count(*) as count from chat_message_variant where group_id in (");
        C4043m.a(sb2, groupIds.size());
        sb2.append(") group by group_id");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.J
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return P.t(string, groupIds, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.F
    public List<ChatMessageVariant> j(final String groupId) {
        kotlin.jvm.internal.p.i(groupId, "groupId");
        final String str = "select * from chat_message_variant where group_id = (?) order by variant_index asc";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return P.x(str, groupId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.F
    public ChatMessageVariant k(final String groupId, final int variantIndex) {
        kotlin.jvm.internal.p.i(groupId, "groupId");
        final String str = "select * from chat_message_variant where group_id = (?) and variant_index = (?)";
        return (ChatMessageVariant) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.O
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return P.y(str, groupId, variantIndex, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.F
    public Integer l(final String groupId) {
        kotlin.jvm.internal.p.i(groupId, "groupId");
        final String str = "select max(variant_index) from chat_message_variant where group_id = (?)";
        return (Integer) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.L
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return P.A(str, groupId, (InterfaceC4160b) obj);
            }
        });
    }
}
