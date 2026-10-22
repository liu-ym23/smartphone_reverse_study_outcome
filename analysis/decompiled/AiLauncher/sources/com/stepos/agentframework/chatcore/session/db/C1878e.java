package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.db.converter.ListConverter;
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
import w4.C5732a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/e;", "Lcom/stepos/agentframework/chatcore/session/db/a;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lw4/a;", "agentInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lw4/a;)V", "", "agentId", "c", "(Ljava/lang/String;)Lw4/a;", "", "agentIds", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Ljava/util/List;", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfAgentInfo", "Landroidx/room/f;", "Lcom/stepos/agentframework/chatcore/session/db/converter/ListConverter;", "__listConverter", "Lcom/stepos/agentframework/chatcore/session/db/converter/ListConverter;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.db.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1878e implements InterfaceC1866a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1410f<C5732a> __insertAdapterOfAgentInfo;
    private final ListConverter __listConverter;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/e$a", "Landroidx/room/f;", "Lw4/a;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lw4/a;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.e$a */
    public static final class a extends AbstractC1410f<C5732a> {
        public a() {
        }

        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `agent_info` (`agent_id`,`agent_name`,`description`,`avatar_url`,`prologue`,`suggested_questions`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, C5732a entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getAgentId());
            statement.H(2, entity.getAgentName());
            statement.H(3, entity.getDescription());
            statement.H(4, entity.getAvatarUrl());
            statement.H(5, entity.getPrologue());
            String strA = C1878e.this.__listConverter.a(entity.f());
            if (strA == null) {
                statement.bindNull(6);
            } else {
                statement.H(6, strA);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/e$b;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.e$b, reason: from kotlin metadata */
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

    public C1878e(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__listConverter = new ListConverter();
        this.__db = __db;
        this.__insertAdapterOfAgentInfo = new a();
    }

    public static final C5732a h(String str, String str2, C1878e c1878e, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "agent_name");
            int iC3 = C4039i.c(interfaceC4162dQ1, "description");
            int iC4 = C4039i.c(interfaceC4162dQ1, "avatar_url");
            int iC5 = C4039i.c(interfaceC4162dQ1, "prologue");
            int iC6 = C4039i.c(interfaceC4162dQ1, "suggested_questions");
            C5732a c5732a = null;
            if (interfaceC4162dQ1.n1()) {
                c5732a = new C5732a(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.X0(iC5), c1878e.__listConverter.b(interfaceC4162dQ1.isNull(iC6) ? null : interfaceC4162dQ1.X0(iC6)));
            }
            return c5732a;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List i(String str, List list, C1878e c1878e, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            int iC = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "agent_name");
            int iC3 = C4039i.c(interfaceC4162dQ1, "description");
            int iC4 = C4039i.c(interfaceC4162dQ1, "avatar_url");
            int iC5 = C4039i.c(interfaceC4162dQ1, "prologue");
            int iC6 = C4039i.c(interfaceC4162dQ1, "suggested_questions");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new C5732a(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.X0(iC5), c1878e.__listConverter.b(interfaceC4162dQ1.isNull(iC6) ? null : interfaceC4162dQ1.X0(iC6))));
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t j(C1878e c1878e, C5732a c5732a, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        c1878e.__insertAdapterOfAgentInfo.d(_connection, c5732a);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1866a
    public void a(final C5732a agentInfo) {
        kotlin.jvm.internal.p.i(agentInfo, "agentInfo");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1878e.j(this.f22579a, agentInfo, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1866a
    public List<C5732a> b(final List<String> agentIds) {
        kotlin.jvm.internal.p.i(agentIds, "agentIds");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("select * from agent_info where agent_id in (");
        C4043m.a(sb2, agentIds.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1878e.i(string, agentIds, this, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1866a
    public C5732a c(final String agentId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        final String str = "select * from agent_info where agent_id = (?)";
        return (C5732a) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1878e.h(str, agentId, this, (InterfaceC4160b) obj);
            }
        });
    }
}
