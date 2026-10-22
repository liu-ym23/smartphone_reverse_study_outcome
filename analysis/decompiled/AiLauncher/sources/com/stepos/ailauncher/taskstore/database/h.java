package com.stepos.ailauncher.taskstore.database;

import Z8.C1173v;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f1.C4031a;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/taskstore/database/h;", "Lcom/stepos/ailauncher/taskstore/database/d;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lcom/stepos/ailauncher/taskstore/database/i;", Const.LBS_FAIL_BD_ENTITY, "", "c", "(Lcom/stepos/ailauncher/taskstore/database/i;Le9/c;)Ljava/lang/Object;", "", "taskId", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "version", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfTaskResultSnapshotEntity", "Landroidx/room/f;", "Companion", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h implements d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1410f<TaskResultSnapshotEntity> __insertAdapterOfTaskResultSnapshotEntity;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/taskstore/database/h$a", "Landroidx/room/f;", "Lcom/stepos/ailauncher/taskstore/database/i;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lcom/stepos/ailauncher/taskstore/database/i;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1410f<TaskResultSnapshotEntity> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR IGNORE INTO `task_result_snapshots` (`task_id`,`sequence`,`version`,`result_json`,`saved_at`) VALUES (?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, TaskResultSnapshotEntity entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getTaskId());
            statement.bindLong(2, entity.getSequence());
            if (entity.getVersion() == null) {
                statement.bindNull(3);
            } else {
                statement.bindLong(3, r3.intValue());
            }
            statement.H(4, entity.getResultJson());
            statement.bindLong(5, entity.getSavedAt());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/taskstore/database/h$b;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.database.h$b, reason: from kotlin metadata */
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

    public h(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfTaskResultSnapshotEntity = new a();
    }

    public static final boolean g(String str, String str2, int i10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.bindLong(2, i10);
            boolean z10 = false;
            if (interfaceC4162dQ1.n1()) {
                z10 = ((int) interfaceC4162dQ1.getLong(0)) != 0;
            }
            return z10;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final long h(h hVar, TaskResultSnapshotEntity taskResultSnapshotEntity, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        return hVar.__insertAdapterOfTaskResultSnapshotEntity.e(_connection, taskResultSnapshotEntity);
    }

    public static final int i(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            return interfaceC4162dQ1.n1() ? (int) interfaceC4162dQ1.getLong(0) : 0;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    @Override // com.stepos.ailauncher.taskstore.database.d
    public Object a(final String str, InterfaceC4014c<? super Integer> interfaceC4014c) {
        final String str2 = "SELECT IFNULL(MAX(sequence), -1) + 1 FROM task_result_snapshots WHERE task_id = ?";
        return C4031a.e(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.database.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(h.i(str2, str, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.database.d
    public Object b(final String str, final int i10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        final String str2 = "SELECT EXISTS(SELECT 1 FROM task_result_snapshots WHERE task_id = ? AND version = ?)";
        return C4031a.e(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.database.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(h.g(str2, str, i10, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.database.d
    public Object c(final TaskResultSnapshotEntity taskResultSnapshotEntity, InterfaceC4014c<? super Long> interfaceC4014c) {
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.database.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Long.valueOf(h.h(this.f29251a, taskResultSnapshotEntity, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }
}
