package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.ailauncher.taskstore.provider.c;
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
import w4.MessagePart;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/H0;", "Lcom/stepos/agentframework/chatcore/session/db/C0;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "", "Lw4/f;", "parts", "LY8/t;", "c", "(Ljava/util/List;)V", "", "messageId", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/util/List;", "messageIds", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfMessagePart", "Landroidx/room/f;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class H0 implements C0 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1410f<MessagePart> __insertAdapterOfMessagePart;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/H0$a", "Landroidx/room/f;", "Lw4/f;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lw4/f;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1410f<MessagePart> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `message_part` (`message_id`,`part_index`,`part_type`,`payload_json`,`updated_at`) VALUES (?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, MessagePart entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getMessageId());
            statement.bindLong(2, entity.getPartIndex());
            statement.H(3, entity.getPartType());
            statement.H(4, entity.getPayloadJson());
            statement.bindLong(5, entity.getUpdatedAt());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/H0$b;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.H0$b, reason: from kotlin metadata */
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

    public H0(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfMessagePart = new a();
    }

    public static final Y8.t i(String str, String str2, InterfaceC4160b _connection) {
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

    public static final List j(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "part_index");
            int iC3 = C4039i.c(interfaceC4162dQ1, "part_type");
            int iC4 = C4039i.c(interfaceC4162dQ1, "payload_json");
            int iC5 = C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT);
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new MessagePart(interfaceC4162dQ1.X0(iC), (int) interfaceC4162dQ1.getLong(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.getLong(iC5)));
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List k(String str, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "part_index");
            int iC3 = C4039i.c(interfaceC4162dQ1, "part_type");
            int iC4 = C4039i.c(interfaceC4162dQ1, "payload_json");
            int iC5 = C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT);
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new MessagePart(interfaceC4162dQ1.X0(iC), (int) interfaceC4162dQ1.getLong(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.getLong(iC5)));
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t l(H0 h02, List list, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        h02.__insertAdapterOfMessagePart.c(_connection, list);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.session.db.C0
    public List<MessagePart> a(final List<String> messageIds) {
        kotlin.jvm.internal.p.i(messageIds, "messageIds");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM message_part WHERE message_id IN (");
        C4043m.a(sb2, messageIds.size());
        sb2.append(") ORDER BY message_id, part_index ASC");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.G0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return H0.k(string, messageIds, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.C0
    public void b(final String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        final String str = "DELETE FROM message_part WHERE message_id = ?";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.E0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return H0.i(str, messageId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.C0
    public void c(final List<MessagePart> parts) {
        kotlin.jvm.internal.p.i(parts, "parts");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.F0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return H0.l(this.f22488a, parts, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.C0
    public List<MessagePart> d(final String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        final String str = "SELECT * FROM message_part WHERE message_id = ? ORDER BY part_index ASC";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.D0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return H0.j(str, messageId, (InterfaceC4160b) obj);
            }
        });
    }
}
