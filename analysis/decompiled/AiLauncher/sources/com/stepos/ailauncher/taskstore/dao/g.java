package com.stepos.ailauncher.taskstore.dao;

import Z8.C1173v;
import androidx.room.AbstractC1409e;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.vector.LauncherVectorEntity;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import f1.C4031a;
import f1.C4039i;
import f1.C4043m;
import f9.C4063a;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\f\u0010\nJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u0015\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/dao/g;", "Lcom/stepos/ailauncher/taskstore/dao/a;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lcom/stepos/ailauncher/taskstore/vector/a;", Const.LBS_FAIL_BD_ENTITY, "", "c", "(Lcom/stepos/ailauncher/taskstore/vector/a;Le9/c;)Ljava/lang/Object;", "LY8/t;", Const.INTENT_KEY_UMID, "", "ids", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "", "bizKey", "e", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "bizType", Const.INTENT_KEY_APIKEY, "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfLauncherVectorEntity", "Landroidx/room/f;", "Landroidx/room/e;", "__deleteAdapterOfLauncherVectorEntity", "Landroidx/room/e;", "Companion", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g implements InterfaceC3710a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1409e<LauncherVectorEntity> __deleteAdapterOfLauncherVectorEntity;
    private final AbstractC1410f<LauncherVectorEntity> __insertAdapterOfLauncherVectorEntity;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/taskstore/dao/g$a", "Landroidx/room/f;", "Lcom/stepos/ailauncher/taskstore/vector/a;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lcom/stepos/ailauncher/taskstore/vector/a;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1410f<LauncherVectorEntity> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `launcher_vector_entities` (`id`,`bizKey`,`bizType`,`entityClassName`,`bizId`,`title`,`content`,`metadata`,`updateTime`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, LauncherVectorEntity entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.bindLong(1, entity.getId());
            statement.H(2, entity.getBizKey());
            statement.H(3, entity.getBizType());
            statement.H(4, entity.getEntityClassName());
            statement.H(5, entity.getBizId());
            statement.H(6, entity.getTitle());
            statement.H(7, entity.getContent());
            statement.H(8, entity.getMetadata());
            statement.bindLong(9, entity.getUpdateTime());
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/taskstore/dao/g$b", "Landroidx/room/e;", "Lcom/stepos/ailauncher/taskstore/vector/a;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", Const.INTENT_KEY_UMID, "(Li1/d;Lcom/stepos/ailauncher/taskstore/vector/a;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AbstractC1409e<LauncherVectorEntity> {
        @Override // androidx.room.AbstractC1409e
        public String b() {
            return "DELETE FROM `launcher_vector_entities` WHERE `id` = ?";
        }

        @Override // androidx.room.AbstractC1409e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, LauncherVectorEntity entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.bindLong(1, entity.getId());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/taskstore/dao/g$c;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.dao.g$c, reason: from kotlin metadata */
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

    public g(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfLauncherVectorEntity = new a();
        this.__deleteAdapterOfLauncherVectorEntity = new b();
    }

    public static final Y8.t k(g gVar, LauncherVectorEntity launcherVectorEntity, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        gVar.__deleteAdapterOfLauncherVectorEntity.c(_connection, launcherVectorEntity);
        return Y8.t.f7040a;
    }

    public static final List l(String str, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.bindLong(i10, ((Number) it.next()).longValue());
                i10++;
            }
            int iC = C4039i.c(interfaceC4162dQ1, "id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "bizKey");
            int iC3 = C4039i.c(interfaceC4162dQ1, "bizType");
            int iC4 = C4039i.c(interfaceC4162dQ1, "entityClassName");
            int iC5 = C4039i.c(interfaceC4162dQ1, "bizId");
            int iC6 = C4039i.c(interfaceC4162dQ1, "title");
            int iC7 = C4039i.c(interfaceC4162dQ1, SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
            int iC8 = C4039i.c(interfaceC4162dQ1, "metadata");
            int iC9 = C4039i.c(interfaceC4162dQ1, "updateTime");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new LauncherVectorEntity(interfaceC4162dQ1.getLong(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.X0(iC6), interfaceC4162dQ1.X0(iC7), interfaceC4162dQ1.X0(iC8), interfaceC4162dQ1.getLong(iC9)));
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final long m(g gVar, LauncherVectorEntity launcherVectorEntity, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        return gVar.__insertAdapterOfLauncherVectorEntity.e(_connection, launcherVectorEntity);
    }

    public static final LauncherVectorEntity n(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            return interfaceC4162dQ1.n1() ? new LauncherVectorEntity(interfaceC4162dQ1.getLong(C4039i.c(interfaceC4162dQ1, "id")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "bizKey")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "bizType")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "entityClassName")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "bizId")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "title")), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, SkillStoreKt.SKILL_DOC_TYPE_CONTENT)), interfaceC4162dQ1.X0(C4039i.c(interfaceC4162dQ1, "metadata")), interfaceC4162dQ1.getLong(C4039i.c(interfaceC4162dQ1, "updateTime"))) : null;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List o(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, "id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "bizKey");
            int iC3 = C4039i.c(interfaceC4162dQ1, "bizType");
            int iC4 = C4039i.c(interfaceC4162dQ1, "entityClassName");
            int iC5 = C4039i.c(interfaceC4162dQ1, "bizId");
            int iC6 = C4039i.c(interfaceC4162dQ1, "title");
            int iC7 = C4039i.c(interfaceC4162dQ1, SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
            int iC8 = C4039i.c(interfaceC4162dQ1, "metadata");
            int iC9 = C4039i.c(interfaceC4162dQ1, "updateTime");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new LauncherVectorEntity(interfaceC4162dQ1.getLong(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.X0(iC5), interfaceC4162dQ1.X0(iC6), interfaceC4162dQ1.X0(iC7), interfaceC4162dQ1.X0(iC8), interfaceC4162dQ1.getLong(iC9)));
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    @Override // com.stepos.ailauncher.taskstore.dao.InterfaceC3710a
    public Object a(final String str, InterfaceC4014c<? super List<LauncherVectorEntity>> interfaceC4014c) {
        final String str2 = "SELECT * FROM launcher_vector_entities WHERE bizType = ? ORDER BY updateTime DESC";
        return C4031a.e(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g.o(str2, str, (InterfaceC4160b) obj);
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.InterfaceC3710a
    public Object b(final List<Long> list, InterfaceC4014c<? super List<LauncherVectorEntity>> interfaceC4014c) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM launcher_vector_entities WHERE id IN (");
        C4043m.a(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return C4031a.e(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g.l(string, list, (InterfaceC4160b) obj);
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.InterfaceC3710a
    public Object c(final LauncherVectorEntity launcherVectorEntity, InterfaceC4014c<? super Long> interfaceC4014c) {
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Long.valueOf(g.m(this.f29197a, launcherVectorEntity, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.InterfaceC3710a
    public Object d(final LauncherVectorEntity launcherVectorEntity, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objE = C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g.k(this.f29195a, launcherVectorEntity, (InterfaceC4160b) obj);
            }
        }, interfaceC4014c);
        return objE == C4063a.g() ? objE : Y8.t.f7040a;
    }

    @Override // com.stepos.ailauncher.taskstore.dao.InterfaceC3710a
    public Object e(final String str, InterfaceC4014c<? super LauncherVectorEntity> interfaceC4014c) {
        final String str2 = "SELECT * FROM launcher_vector_entities WHERE bizKey = ? LIMIT 1";
        return C4031a.e(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g.n(str2, str, (InterfaceC4160b) obj);
            }
        }, interfaceC4014c);
    }
}
