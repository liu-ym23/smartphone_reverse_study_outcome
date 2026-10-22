package com.stepos.ailauncher.taskstore.database;

import Z8.C1173v;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import i1.InterfaceC4162d;
import java.util.List;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/taskstore/database/b;", "Lcom/stepos/ailauncher/taskstore/database/a;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "Lcom/stepos/ailauncher/taskstore/database/c;", "__insertAdapterOfDownloadedArtifactEntity", "Landroidx/room/f;", "Companion", Const.INTENT_KEY_PKGNAME, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b implements com.stepos.ailauncher.taskstore.database.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1410f<DownloadedArtifactEntity> __insertAdapterOfDownloadedArtifactEntity;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/taskstore/database/b$a", "Landroidx/room/f;", "Lcom/stepos/ailauncher/taskstore/database/c;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lcom/stepos/ailauncher/taskstore/database/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1410f<DownloadedArtifactEntity> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `downloaded_artifacts` (`art_key`,`task_id`,`downloaded_at`) VALUES (?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, DownloadedArtifactEntity entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getArtKey());
            statement.H(2, entity.getTaskId());
            statement.bindLong(3, entity.getDownloadedAt());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/taskstore/database/b$b;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.database.b$b, reason: collision with other inner class name and from kotlin metadata */
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

    public b(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfDownloadedArtifactEntity = new a();
    }
}
