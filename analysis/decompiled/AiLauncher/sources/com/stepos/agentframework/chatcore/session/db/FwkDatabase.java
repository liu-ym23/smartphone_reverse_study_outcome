package com.stepos.agentframework.chatcore.session.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import d1.AbstractC3942a;
import h8.C4148a;
import j1.InterfaceC4756c;
import j1.InterfaceC4757d;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/session/db/a;", "h0", "()Lcom/stepos/agentframework/chatcore/session/db/a;", "Lcom/stepos/agentframework/chatcore/session/db/f;", "j0", "()Lcom/stepos/agentframework/chatcore/session/db/f;", "Lcom/stepos/agentframework/chatcore/session/db/F;", "m0", "()Lcom/stepos/agentframework/chatcore/session/db/F;", "Lcom/stepos/agentframework/chatcore/session/db/C0;", "k0", "()Lcom/stepos/agentframework/chatcore/session/db/C0;", "Lcom/stepos/agentframework/chatcore/session/db/I0;", "l0", "()Lcom/stepos/agentframework/chatcore/session/db/I0;", "Lcom/stepos/agentframework/chatcore/session/db/q1;", "q0", "()Lcom/stepos/agentframework/chatcore/session/db/q1;", "Lcom/stepos/agentframework/chatcore/session/db/R0;", "n0", "()Lcom/stepos/agentframework/chatcore/session/db/R0;", "Lcom/stepos/agentframework/chatcore/session/db/Q;", "i0", "()Lcom/stepos/agentframework/chatcore/session/db/Q;", "Lcom/stepos/agentframework/chatcore/session/db/B1;", "r0", "()Lcom/stepos/agentframework/chatcore/session/db/B1;", "Lcom/stepos/agentframework/chatcore/session/db/W0;", "o0", "()Lcom/stepos/agentframework/chatcore/session/db/W0;", "Lcom/stepos/agentframework/chatcore/session/db/f1;", "p0", "()Lcom/stepos/agentframework/chatcore/session/db/f1;", "Companion", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FwkDatabase extends RoomDatabase {
    private static final String CHANNEL_FEISHU_PREFIX = "agent:main:feishu%";
    private static final String CHANNEL_WECHAT_PREFIX = "agent:main:wechat%";
    private static final String DATABASE_NAME_PREFIX = "agent_framework_";
    private static final String DATABASE_NAME_SUFFIX = ".db";
    private static final String LEGACY_DATABASE_NAME = "agent_framework.db";
    private static final String MAIN_SESSION_ID = "agent:main:main";
    private static final String TAG = "FwkDatabase";
    private static volatile String currentUid;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, FwkDatabase> instances = new HashMap<>();
    private static final Object instanceLock = new Object();
    private static final AbstractC3942a MIGRATION_1_2 = new a();
    private static final AbstractC3942a MIGRATION_2_3 = new b();
    private static final AbstractC3942a MIGRATION_3_4 = new c();
    private static final AbstractC3942a MIGRATION_4_5 = new d();
    private static final AbstractC3942a MIGRATION_5_8 = new e();
    private static final AbstractC3942a MIGRATION_6_8 = new f();
    private static final AbstractC3942a MIGRATION_8_9 = new g();
    private static final AbstractC3942a MIGRATION_9_10 = new h();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatcore/session/db/FwkDatabase$a", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC3942a {
        public a() {
            super(1, 2);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("CREATE INDEX IF NOT EXISTS `index_chat_message_session_id_time_message_id` ON `chat_message` (`session_id`, `time`, `message_id`)");
            db2.execSQL("CREATE INDEX IF NOT EXISTS `index_chat_message_pair_id` ON `chat_message` (`pair_id`)");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatcore/session/db/FwkDatabase$b", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AbstractC3942a {
        public b() {
            super(2, 3);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("CREATE TABLE IF NOT EXISTS `task_result_artifact` (`file_id` TEXT NOT NULL, `session_id` TEXT NOT NULL, `message_id` TEXT NOT NULL, `tool_call_id` TEXT NOT NULL, `task_id` TEXT, `version_id` TEXT, `cloud_path` TEXT, `file_name` TEXT, `title` TEXT, `mime_type` TEXT, `size` INTEGER, `created_at` INTEGER NOT NULL, PRIMARY KEY(`file_id`), FOREIGN KEY(`message_id`) REFERENCES `chat_message`(`message_id`) ON UPDATE NO ACTION ON DELETE CASCADE)");
            db2.execSQL("CREATE INDEX IF NOT EXISTS `index_task_result_artifact_session_id_created_at` ON `task_result_artifact` (`session_id`, `created_at`)");
            db2.execSQL("CREATE INDEX IF NOT EXISTS `index_task_result_artifact_message_id` ON `task_result_artifact` (`message_id`)");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatcore/session/db/FwkDatabase$c", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AbstractC3942a {
        public c() {
            super(3, 4);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            FwkDatabase.INSTANCE.i(db2);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatcore/session/db/FwkDatabase$d", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends AbstractC3942a {
        public d() {
            super(4, 5);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            FwkDatabase.INSTANCE.g(db2);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatcore/session/db/FwkDatabase$e", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends AbstractC3942a {
        public e() {
            super(5, 8);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            Companion companion = FwkDatabase.INSTANCE;
            companion.k(db2);
            companion.q(db2);
            companion.j(db2);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatcore/session/db/FwkDatabase$f", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends AbstractC3942a {
        public f() {
            super(6, 8);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            Companion companion = FwkDatabase.INSTANCE;
            companion.i(db2);
            companion.g(db2);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatcore/session/db/FwkDatabase$g", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends AbstractC3942a {
        public g() {
            super(8, 9);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("ALTER TABLE task_result_artifact RENAME COLUMN unavailable TO availability");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatcore/session/db/FwkDatabase$h", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h extends AbstractC3942a {
        public h() {
            super(9, 10);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            FwkDatabase.INSTANCE.h(db2);
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ'\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010$\u001a\u00020\u0004*\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u0004*\u00020!2\u0006\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020!H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\f2\u0006\u0010(\u001a\u00020!H\u0002¢\u0006\u0004\b+\u0010*J\u0017\u0010,\u001a\u00020\f2\u0006\u0010(\u001a\u00020!H\u0002¢\u0006\u0004\b,\u0010*J\u0017\u0010-\u001a\u00020\f2\u0006\u0010(\u001a\u00020!H\u0002¢\u0006\u0004\b-\u0010*J\u0017\u0010.\u001a\u00020\f2\u0006\u0010(\u001a\u00020!H\u0002¢\u0006\u0004\b.\u0010*J\u0017\u0010/\u001a\u00020\f2\u0006\u0010(\u001a\u00020!H\u0002¢\u0006\u0004\b/\u0010*R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u00105\u001a\u0002008\u0006¢\u0006\f\n\u0004\b5\u00102\u001a\u0004\b6\u00104R\u0017\u00107\u001a\u0002008\u0006¢\u0006\f\n\u0004\b7\u00102\u001a\u0004\b8\u00104R\u0017\u00109\u001a\u0002008\u0006¢\u0006\f\n\u0004\b9\u00102\u001a\u0004\b:\u00104R\u0017\u0010;\u001a\u0002008\u0006¢\u0006\f\n\u0004\b;\u00102\u001a\u0004\b<\u00104R\u0017\u0010=\u001a\u0002008\u0006¢\u0006\f\n\u0004\b=\u00102\u001a\u0004\b>\u00104R\u0017\u0010?\u001a\u0002008\u0006¢\u0006\f\n\u0004\b?\u00102\u001a\u0004\b@\u00104R\u0017\u0010A\u001a\u0002008\u0006¢\u0006\f\n\u0004\bA\u00102\u001a\u0004\bB\u00104R\u0014\u0010C\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010DR\u0014\u0010F\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010DR\u0014\u0010G\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u0010DR\u0014\u0010H\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010DR\u0014\u0010I\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bI\u0010DR\u0014\u0010J\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010DR0\u0010M\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070Kj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007`L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010D¨\u0006R"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase$i;", "", "<init>", "()V", "", "B", "()Z", "Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;", "n", "()Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;", "", "newUid", "LY8/t;", "F", "(Ljava/lang/String;)V", "m", ExifInterface.LONGITUDE_EAST, "()Ljava/lang/String;", "uid", "o", "(Ljava/lang/String;)Ljava/lang/String;", "C", "Ljava/io/File;", "legacy", "target", "suffix", "D", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "main", "p", "(Ljava/io/File;)V", "l", "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;", "Lj1/c;", "table", "column", "z", "(Lj1/c;Ljava/lang/String;Ljava/lang/String;)Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lj1/c;Ljava/lang/String;)Z", "db", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lj1/c;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "q", "Ld1/a;", "MIGRATION_1_2", "Ld1/a;", "r", "()Ld1/a;", "MIGRATION_2_3", "s", "MIGRATION_3_4", "t", "MIGRATION_4_5", "u", "MIGRATION_5_8", "v", "MIGRATION_6_8", "w", "MIGRATION_8_9", "x", "MIGRATION_9_10", "y", "TAG", "Ljava/lang/String;", "LEGACY_DATABASE_NAME", "DATABASE_NAME_PREFIX", "DATABASE_NAME_SUFFIX", "MAIN_SESSION_ID", "CHANNEL_WECHAT_PREFIX", "CHANNEL_FEISHU_PREFIX", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "instances", "Ljava/util/HashMap;", "instanceLock", "Ljava/lang/Object;", "currentUid", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.FwkDatabase$i, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatcore/session/db/FwkDatabase$i$a", "Landroidx/room/RoomDatabase$b;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "f", Const.INTENT_KEY_UMID, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentframework.chatcore.session.db.FwkDatabase$i$a */
        public static final class a extends RoomDatabase.b {
            @Override // androidx.room.RoomDatabase.b
            public void b(InterfaceC4756c db2) {
                kotlin.jvm.internal.p.i(db2, "db");
                super.b(db2);
            }

            @Override // androidx.room.RoomDatabase.b
            public void d(InterfaceC4756c db2) {
                kotlin.jvm.internal.p.i(db2, "db");
                super.d(db2);
            }

            @Override // androidx.room.RoomDatabase.b
            public void f(InterfaceC4756c db2) {
                kotlin.jvm.internal.p.i(db2, "db");
                super.f(db2);
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean A(InterfaceC4756c interfaceC4756c, String str) throws IOException {
            Cursor cursorQuery = interfaceC4756c.query("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{str});
            try {
                boolean zMoveToFirst = cursorQuery.moveToFirst();
                l9.b.a(cursorQuery, null);
                return zMoveToFirst;
            } finally {
            }
        }

        public final boolean B() {
            String strA = FwkDatabase.currentUid;
            if (strA == null) {
                O6.h hVarA = O6.a.INSTANCE.a();
                strA = hVarA != null ? hVarA.a() : null;
            }
            return !(strA == null || strA.length() == 0);
        }

        public final void C(String uid) {
            Context contextC = ChatCoreSdk.INSTANCE.c();
            File databasePath = contextC.getDatabasePath(FwkDatabase.LEGACY_DATABASE_NAME);
            if (databasePath.exists()) {
                File databasePath2 = contextC.getDatabasePath(o(uid));
                if (databasePath2.exists()) {
                    kotlin.jvm.internal.p.f(databasePath);
                    p(databasePath);
                    C4148a.k(FwkDatabase.TAG, "legacy db dropped, per-uid db already exists, uid=" + uid, false, 4, null);
                    return;
                }
                kotlin.jvm.internal.p.f(databasePath);
                kotlin.jvm.internal.p.f(databasePath2);
                D(databasePath, databasePath2, "-wal");
                D(databasePath, databasePath2, "-shm");
                C4148a.k(FwkDatabase.TAG, "legacy db migrated to per-uid, uid=" + uid + ", ok=" + databasePath.renameTo(databasePath2), false, 4, null);
            }
        }

        public final void D(File legacy, File target, String suffix) {
            File file = new File(legacy.getPath() + suffix);
            if (file.exists()) {
                file.renameTo(new File(target.getPath() + suffix));
            }
        }

        public final String E() {
            String strA = FwkDatabase.currentUid;
            if (strA == null) {
                O6.h hVarA = O6.a.INSTANCE.a();
                strA = hVarA != null ? hVarA.a() : null;
            }
            if (strA != null && strA.length() != 0) {
                return strA;
            }
            C4148a.g(FwkDatabase.TAG, "resolveUid: uid not ready (currentUid + AccountHelper both empty). Call ChatCoreSdk.switchUser(uid) or setAccountHelper() before db access.", new Throwable("uid-not-ready stack"), false, 8, null);
            throw new IllegalStateException("FwkDatabase requires a logged-in uid. Make sure AFGlobalUtils.setAccountHelper() and a non-empty uid are ready before chat/message DB access.");
        }

        public final void F(String newUid) {
            Object objB;
            kotlin.jvm.internal.p.i(newUid, "newUid");
            if (newUid.length() == 0) {
                C4148a.u(FwkDatabase.TAG, "switchUser called with empty uid, ignored", false, 4, null);
                return;
            }
            C4148a.k(FwkDatabase.TAG, "switchUser to uid=" + newUid, false, 4, null);
            FwkDatabase.currentUid = newUid;
            synchronized (FwkDatabase.instanceLock) {
                try {
                    ArrayList<FwkDatabase> arrayList = new ArrayList(FwkDatabase.instances.values());
                    FwkDatabase.instances.clear();
                    for (FwkDatabase fwkDatabase : arrayList) {
                        Companion companion = FwkDatabase.INSTANCE;
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            fwkDatabase.i();
                            objB = Result.b(Y8.t.f7040a);
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objB = Result.b(C4849c.a(th));
                        }
                        Throwable thE = Result.e(objB);
                        if (thE != null) {
                            C4148a.u(FwkDatabase.TAG, "close db on switchUser failed: " + thE, false, 4, null);
                        }
                    }
                    Y8.t tVar = Y8.t.f7040a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final void g(InterfaceC4756c db2) throws SQLException {
            if (!z(db2, "task_result_artifact", "unavailable")) {
                db2.execSQL("ALTER TABLE task_result_artifact ADD COLUMN unavailable INTEGER NOT NULL DEFAULT 0");
            }
            if (z(db2, "task_result_artifact", "checked_at")) {
                return;
            }
            db2.execSQL("ALTER TABLE task_result_artifact ADD COLUMN checked_at INTEGER NOT NULL DEFAULT 0");
        }

        public final void h(InterfaceC4756c db2) throws SQLException {
            if (z(db2, "conversation_title", "delete_status")) {
                return;
            }
            db2.execSQL("ALTER TABLE conversation_title ADD COLUMN delete_status INTEGER NOT NULL DEFAULT 0");
        }

        public final void i(InterfaceC4756c db2) throws SQLException {
            if (z(db2, "conversation_title", "title_source")) {
                return;
            }
            db2.execSQL("ALTER TABLE conversation_title ADD COLUMN title_source INTEGER NOT NULL DEFAULT 0");
        }

        public final void j(InterfaceC4756c db2) throws SQLException {
            if (z(db2, "chat_message", "ui_actions")) {
                return;
            }
            db2.execSQL("ALTER TABLE `chat_message` ADD COLUMN `ui_actions` TEXT");
        }

        public final void k(InterfaceC4756c db2) throws SQLException {
            if (!z(db2, "chat_message", "variant_group_id")) {
                db2.execSQL("ALTER TABLE `chat_message` ADD COLUMN `variant_group_id` TEXT NOT NULL DEFAULT ''");
            }
            if (z(db2, "chat_message", "variant_index")) {
                return;
            }
            db2.execSQL("ALTER TABLE `chat_message` ADD COLUMN `variant_index` INTEGER NOT NULL DEFAULT 0");
        }

        public final FwkDatabase l(String uid) {
            InterfaceC4757d.c cVarInvoke;
            C(uid);
            String strO = o(uid);
            ChatCoreSdk chatCoreSdk = ChatCoreSdk.INSTANCE;
            InterfaceC5074l<String, InterfaceC4757d.c> interfaceC5074lD = chatCoreSdk.d();
            if (interfaceC5074lD != null) {
                try {
                    cVarInvoke = interfaceC5074lD.invoke(strO);
                } catch (Throwable th) {
                    C4148a.g(FwkDatabase.TAG, "db cipher factory failed for " + strO, th, false, 8, null);
                    throw th;
                }
            } else {
                cVarInvoke = null;
            }
            if (interfaceC5074lD == null || cVarInvoke != null) {
                RoomDatabase.a aVarA = androidx.room.m.a(chatCoreSdk.c(), FwkDatabase.class, strO);
                if (cVarInvoke != null) {
                    aVarA.e(cVarInvoke);
                }
                return (FwkDatabase) aVarA.a(new a()).f(RoomDatabase.JournalMode.TRUNCATE).b(r(), s(), t(), u(), v(), w(), x(), y()).c();
            }
            throw new IllegalStateException("host cipher factory returned null for " + strO + "; refusing plaintext open");
        }

        public final void m() {
            Object objB;
            C4148a.k(FwkDatabase.TAG, "closeAll on user logout", false, 4, null);
            FwkDatabase.currentUid = null;
            synchronized (FwkDatabase.instanceLock) {
                try {
                    ArrayList<FwkDatabase> arrayList = new ArrayList(FwkDatabase.instances.values());
                    FwkDatabase.instances.clear();
                    for (FwkDatabase fwkDatabase : arrayList) {
                        Companion companion = FwkDatabase.INSTANCE;
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            fwkDatabase.i();
                            objB = Result.b(Y8.t.f7040a);
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objB = Result.b(C4849c.a(th));
                        }
                        Throwable thE = Result.e(objB);
                        if (thE != null) {
                            C4148a.u(FwkDatabase.TAG, "close db on closeAll failed: " + thE, false, 4, null);
                        }
                    }
                    Y8.t tVar = Y8.t.f7040a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final FwkDatabase n() {
            FwkDatabase fwkDatabaseL;
            String strE = E();
            FwkDatabase fwkDatabase = (FwkDatabase) FwkDatabase.instances.get(strE);
            if (fwkDatabase != null) {
                return fwkDatabase;
            }
            synchronized (FwkDatabase.instanceLock) {
                fwkDatabaseL = (FwkDatabase) FwkDatabase.instances.get(strE);
                if (fwkDatabaseL == null) {
                    fwkDatabaseL = FwkDatabase.INSTANCE.l(strE);
                    FwkDatabase.instances.put(strE, fwkDatabaseL);
                }
            }
            return fwkDatabaseL;
        }

        public final String o(String uid) {
            return FwkDatabase.DATABASE_NAME_PREFIX + uid + FwkDatabase.DATABASE_NAME_SUFFIX;
        }

        public final void p(File main) {
            main.delete();
            new File(main.getPath() + "-shm").delete();
            new File(main.getPath() + "-wal").delete();
        }

        public final void q(InterfaceC4756c db2) throws SQLException {
            if (!A(db2, "chat_message_variant")) {
                db2.execSQL("CREATE TABLE IF NOT EXISTS `chat_message_variant` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `message_id` TEXT NOT NULL, `group_id` TEXT NOT NULL, `variant_index` INTEGER NOT NULL, `session_id` TEXT NOT NULL, `snapshot_json` TEXT NOT NULL, `archived_at` INTEGER NOT NULL)");
                db2.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_chat_message_variant_group_id_variant_index` ON `chat_message_variant` (`group_id`, `variant_index`)");
                db2.execSQL("CREATE INDEX IF NOT EXISTS `index_chat_message_variant_session_id` ON `chat_message_variant` (`session_id`)");
            } else {
                if (z(db2, "chat_message_variant", "id")) {
                    return;
                }
                db2.execSQL("ALTER TABLE `chat_message_variant` RENAME TO `chat_message_variant_old`");
                db2.execSQL("DROP INDEX IF EXISTS `index_chat_message_variant_group_id_variant_index`");
                db2.execSQL("DROP INDEX IF EXISTS `index_chat_message_variant_session_id`");
                db2.execSQL("CREATE TABLE IF NOT EXISTS `chat_message_variant` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `message_id` TEXT NOT NULL, `group_id` TEXT NOT NULL, `variant_index` INTEGER NOT NULL, `session_id` TEXT NOT NULL, `snapshot_json` TEXT NOT NULL, `archived_at` INTEGER NOT NULL)");
                db2.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_chat_message_variant_group_id_variant_index` ON `chat_message_variant` (`group_id`, `variant_index`)");
                db2.execSQL("CREATE INDEX IF NOT EXISTS `index_chat_message_variant_session_id` ON `chat_message_variant` (`session_id`)");
                db2.execSQL("INSERT OR REPLACE INTO `chat_message_variant` (`message_id`, `group_id`, `variant_index`, `session_id`, `snapshot_json`, `archived_at`) SELECT `message_id`, `group_id`, `variant_index`, `session_id`, `snapshot_json`, `archived_at` FROM `chat_message_variant_old`");
                db2.execSQL("DROP TABLE `chat_message_variant_old`");
            }
        }

        public final AbstractC3942a r() {
            return FwkDatabase.MIGRATION_1_2;
        }

        public final AbstractC3942a s() {
            return FwkDatabase.MIGRATION_2_3;
        }

        public final AbstractC3942a t() {
            return FwkDatabase.MIGRATION_3_4;
        }

        public final AbstractC3942a u() {
            return FwkDatabase.MIGRATION_4_5;
        }

        public final AbstractC3942a v() {
            return FwkDatabase.MIGRATION_5_8;
        }

        public final AbstractC3942a w() {
            return FwkDatabase.MIGRATION_6_8;
        }

        public final AbstractC3942a x() {
            return FwkDatabase.MIGRATION_8_9;
        }

        public final AbstractC3942a y() {
            return FwkDatabase.MIGRATION_9_10;
        }

        public final boolean z(InterfaceC4756c interfaceC4756c, String str, String str2) throws IOException {
            Cursor cursorQuery = interfaceC4756c.query("PRAGMA table_info(`" + str + "`)");
            try {
                Cursor cursor = cursorQuery;
                int columnIndex = cursor.getColumnIndex("name");
                if (columnIndex < 0) {
                    l9.b.a(cursorQuery, null);
                    return false;
                }
                while (cursor.moveToNext()) {
                    if (kotlin.jvm.internal.p.d(cursor.getString(columnIndex), str2)) {
                        l9.b.a(cursorQuery, null);
                        return true;
                    }
                }
                Y8.t tVar = Y8.t.f7040a;
                l9.b.a(cursorQuery, null);
                return false;
            } finally {
            }
        }

        public Companion() {
        }
    }

    public abstract InterfaceC1866a h0();

    public abstract Q i0();

    public abstract InterfaceC1881f j0();

    public abstract C0 k0();

    public abstract I0 l0();

    public abstract F m0();

    public abstract R0 n0();

    public abstract W0 o0();

    public abstract InterfaceC1883f1 p0();

    public abstract q1 q0();

    public abstract B1 r0();
}
