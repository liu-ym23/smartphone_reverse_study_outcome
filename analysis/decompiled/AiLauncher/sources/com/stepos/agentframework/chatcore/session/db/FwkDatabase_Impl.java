package com.stepos.agentframework.chatcore.session.db;

import Z8.C1172u;
import Z8.C1173v;
import androidx.room.InvalidationTracker;
import androidx.room.w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import d1.AbstractC3942a;
import f1.C4031a;
import f1.C4044n;
import i1.C4159a;
import i1.InterfaceC4160b;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ)\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\f0\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000b0\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u001a\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000b\u0012\u0004\u0012\u00020\u00100\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0017088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001a088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010:R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001d088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010:R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020 088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010:R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020#088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010:R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020&088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010:R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020)088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010:R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020,088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010:R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020/088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010:R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u000202088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010:R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u000205088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010:¨\u0006E"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase_Impl;", "Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;", "<init>", "()V", "Landroidx/room/w;", "P0", "()Landroidx/room/w;", "Landroidx/room/InvalidationTracker;", "m", "()Landroidx/room/InvalidationTracker;", "", "Lw9/d;", "", "y", "()Ljava/util/Map;", "", "", "w", "()Ljava/util/Set;", "autoMigrationSpecs", "Ld1/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/Map;)Ljava/util/List;", "Lcom/stepos/agentframework/chatcore/session/db/a;", "h0", "()Lcom/stepos/agentframework/chatcore/session/db/a;", "Lcom/stepos/agentframework/chatcore/session/db/f;", "j0", "()Lcom/stepos/agentframework/chatcore/session/db/f;", "Lcom/stepos/agentframework/chatcore/session/db/F;", "m0", "()Lcom/stepos/agentframework/chatcore/session/db/F;", "Lcom/stepos/agentframework/chatcore/session/db/C0;", "k0", "()Lcom/stepos/agentframework/chatcore/session/db/C0;", "Lcom/stepos/agentframework/chatcore/session/db/I0;", "l0", "()Lcom/stepos/agentframework/chatcore/session/db/I0;", "Lcom/stepos/agentframework/chatcore/session/db/q1;", "q0", "()Lcom/stepos/agentframework/chatcore/session/db/q1;", "Lcom/stepos/agentframework/chatcore/session/db/R0;", "n0", "()Lcom/stepos/agentframework/chatcore/session/db/R0;", "Lcom/stepos/agentframework/chatcore/session/db/Q;", "i0", "()Lcom/stepos/agentframework/chatcore/session/db/Q;", "Lcom/stepos/agentframework/chatcore/session/db/B1;", "r0", "()Lcom/stepos/agentframework/chatcore/session/db/B1;", "Lcom/stepos/agentframework/chatcore/session/db/W0;", "o0", "()Lcom/stepos/agentframework/chatcore/session/db/W0;", "Lcom/stepos/agentframework/chatcore/session/db/f1;", "p0", "()Lcom/stepos/agentframework/chatcore/session/db/f1;", "LY8/h;", "_agentInfoDao", "LY8/h;", "_chatMessageDao", "_chatMessageVariantDao", "_messagePartDao", "_messageSearchProjectionDao", "_taskSearchDocumentDao", "_robotInfoDao", "_conversationTitleDao", "_taskSessionLinkDao", "_sessionPendingActionDao", "_taskResultArtifactDao", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FwkDatabase_Impl extends FwkDatabase {
    private final Y8.h<InterfaceC1866a> _agentInfoDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.db.q0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FwkDatabase_Impl.D0(this.f22673a);
        }
    });
    private final Y8.h<InterfaceC1881f> _chatMessageDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.db.t0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FwkDatabase_Impl.E0(this.f22686a);
        }
    });
    private final Y8.h<F> _chatMessageVariantDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.db.u0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FwkDatabase_Impl.F0(this.f22692a);
        }
    });
    private final Y8.h<C0> _messagePartDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.db.v0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FwkDatabase_Impl.H0(this.f22698a);
        }
    });
    private final Y8.h<I0> _messageSearchProjectionDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.db.w0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FwkDatabase_Impl.I0(this.f22702a);
        }
    });
    private final Y8.h<q1> _taskSearchDocumentDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.db.x0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FwkDatabase_Impl.M0(this.f22708a);
        }
    });
    private final Y8.h<R0> _robotInfoDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.db.y0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FwkDatabase_Impl.J0(this.f22716a);
        }
    });
    private final Y8.h<Q> _conversationTitleDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.db.z0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FwkDatabase_Impl.G0(this.f22720a);
        }
    });
    private final Y8.h<B1> _taskSessionLinkDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.db.A0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FwkDatabase_Impl.N0(this.f22472a);
        }
    });
    private final Y8.h<W0> _sessionPendingActionDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.db.r0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FwkDatabase_Impl.K0(this.f22675a);
        }
    });
    private final Y8.h<InterfaceC1883f1> _taskResultArtifactDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.db.s0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FwkDatabase_Impl.L0(this.f22681a);
        }
    });

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/FwkDatabase_Impl$a", "Landroidx/room/w;", "Li1/b;", "connection", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Li1/b;)V", Const.INTENT_KEY_PKGNAME, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/room/w$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Li1/b;)Landroidx/room/w$a;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends androidx.room.w {
        public a() {
            super(10, "616ea022113f70d12482f81a5049e04a", "9747b1fe4361ccb1ca0e49e394bb3fcf");
        }

        @Override // androidx.room.w
        public void a(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `agent_info` (`agent_id` TEXT NOT NULL, `agent_name` TEXT NOT NULL, `description` TEXT NOT NULL, `avatar_url` TEXT NOT NULL, `prologue` TEXT NOT NULL, `suggested_questions` TEXT, PRIMARY KEY(`agent_id`))");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `chat_message` (`message_id` TEXT NOT NULL, `session_id` TEXT NOT NULL, `agent_id` TEXT NOT NULL, `time` INTEGER NOT NULL, `role` TEXT NOT NULL, `view_splite_id` TEXT NOT NULL, `is_like` INTEGER NOT NULL, `is_dislike` INTEGER NOT NULL, `server_item_id` TEXT NOT NULL, `pair_id` TEXT NOT NULL, `trace_id` TEXT NOT NULL, `status` TEXT NOT NULL, `error_code` INTEGER NOT NULL, `error_message` TEXT NOT NULL, `suggestions` TEXT, `hint` INTEGER NOT NULL, `send_failed` INTEGER NOT NULL DEFAULT 0, `approval_request_id` TEXT, `sources` TEXT, `variant_group_id` TEXT NOT NULL DEFAULT '', `variant_index` INTEGER NOT NULL DEFAULT 0, `ui_actions` TEXT, PRIMARY KEY(`message_id`))");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_chat_message_session_id_time_message_id` ON `chat_message` (`session_id`, `time`, `message_id`)");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_chat_message_pair_id` ON `chat_message` (`pair_id`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `chat_message_variant` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `message_id` TEXT NOT NULL, `group_id` TEXT NOT NULL, `variant_index` INTEGER NOT NULL, `session_id` TEXT NOT NULL, `snapshot_json` TEXT NOT NULL, `archived_at` INTEGER NOT NULL)");
            C4159a.a(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_chat_message_variant_group_id_variant_index` ON `chat_message_variant` (`group_id`, `variant_index`)");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_chat_message_variant_session_id` ON `chat_message_variant` (`session_id`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `message_part` (`message_id` TEXT NOT NULL, `part_index` INTEGER NOT NULL, `part_type` TEXT NOT NULL, `payload_json` TEXT NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`message_id`, `part_index`), FOREIGN KEY(`message_id`) REFERENCES `chat_message`(`message_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_message_part_message_id` ON `message_part` (`message_id`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `message_search_document` (`message_id` TEXT NOT NULL, `session_id` TEXT NOT NULL, `agent_id` TEXT NOT NULL, `role` TEXT NOT NULL, `searchable_text` TEXT NOT NULL, `updated_at` INTEGER NOT NULL, `status` TEXT NOT NULL, PRIMARY KEY(`message_id`), FOREIGN KEY(`message_id`) REFERENCES `chat_message`(`message_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_message_search_document_agent_id` ON `message_search_document` (`agent_id`)");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_message_search_document_session_id_updated_at` ON `message_search_document` (`session_id`, `updated_at`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `task_search_document` (`task_id` TEXT NOT NULL, `session_id` TEXT NOT NULL, `title` TEXT NOT NULL, `searchable_text` TEXT NOT NULL, `status` TEXT NOT NULL, `updated_at` INTEGER NOT NULL, `read_at` INTEGER, PRIMARY KEY(`task_id`))");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_task_search_document_session_id` ON `task_search_document` (`session_id`)");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_task_search_document_updated_at` ON `task_search_document` (`updated_at`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `conversation_title` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `session_id` TEXT NOT NULL, `title` TEXT NOT NULL, `agent_id` TEXT NOT NULL, `device_id` TEXT NOT NULL DEFAULT '', `create_time` INTEGER NOT NULL, `last_active_at` INTEGER NOT NULL, `last_read_at` INTEGER NOT NULL, `is_temp_session` INTEGER NOT NULL, `session_kind` INTEGER NOT NULL DEFAULT 0, `send_failed` INTEGER NOT NULL DEFAULT 0, `title_source` INTEGER NOT NULL DEFAULT 0, `delete_status` INTEGER NOT NULL DEFAULT 0)");
            C4159a.a(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_conversation_title_agent_id_session_id` ON `conversation_title` (`agent_id`, `session_id`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `task_robot_info` (`task_id` TEXT NOT NULL, `status` TEXT NOT NULL, `source_from` TEXT NOT NULL, `error_msg` TEXT, `first_run_time` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `task_name` TEXT, `task_desc` TEXT, `latest_screenshot_path` TEXT, PRIMARY KEY(`task_id`))");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `task_session_link` (`sub_session_key` TEXT NOT NULL, `request_session_key` TEXT NOT NULL, `task_id` TEXT NOT NULL, `agent_id` TEXT NOT NULL, `card_time` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`sub_session_key`))");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `session_pending_action` (`request_id` TEXT NOT NULL, `session_id` TEXT NOT NULL, `agent_id` TEXT NOT NULL, `action_kind` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `expires_at` INTEGER, PRIMARY KEY(`request_id`))");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_session_pending_action_session_id` ON `session_pending_action` (`session_id`)");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_session_pending_action_expires_at` ON `session_pending_action` (`expires_at`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `task_result_artifact` (`file_id` TEXT NOT NULL, `session_id` TEXT NOT NULL, `message_id` TEXT NOT NULL, `tool_call_id` TEXT NOT NULL, `task_id` TEXT, `version_id` TEXT, `cloud_path` TEXT, `file_name` TEXT, `title` TEXT, `mime_type` TEXT, `size` INTEGER, `created_at` INTEGER NOT NULL, `availability` INTEGER NOT NULL DEFAULT 0, `checked_at` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`file_id`), FOREIGN KEY(`message_id`) REFERENCES `chat_message`(`message_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_task_result_artifact_session_id_created_at` ON `task_result_artifact` (`session_id`, `created_at`)");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_task_result_artifact_message_id` ON `task_result_artifact` (`message_id`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            C4159a.a(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '616ea022113f70d12482f81a5049e04a')");
        }

        @Override // androidx.room.w
        public void b(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            C4159a.a(connection, "DROP TABLE IF EXISTS `agent_info`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `chat_message`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `chat_message_variant`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `message_part`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `message_search_document`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `task_search_document`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `conversation_title`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `task_robot_info`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `task_session_link`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `session_pending_action`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `task_result_artifact`");
        }

        @Override // androidx.room.w
        public void f(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
        }

        @Override // androidx.room.w
        public void g(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            C4159a.a(connection, "PRAGMA foreign_keys = ON");
            FwkDatabase_Impl.this.K(connection);
        }

        @Override // androidx.room.w
        public void h(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
        }

        @Override // androidx.room.w
        public void i(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            C4031a.a(connection);
        }

        @Override // androidx.room.w
        public w.a j(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("agent_id", new C4044n.a("agent_id", "TEXT", true, 1, null, 1));
            linkedHashMap.put("agent_name", new C4044n.a("agent_name", "TEXT", true, 0, null, 1));
            linkedHashMap.put("description", new C4044n.a("description", "TEXT", true, 0, null, 1));
            linkedHashMap.put("avatar_url", new C4044n.a("avatar_url", "TEXT", true, 0, null, 1));
            linkedHashMap.put("prologue", new C4044n.a("prologue", "TEXT", true, 0, null, 1));
            linkedHashMap.put("suggested_questions", new C4044n.a("suggested_questions", "TEXT", false, 0, null, 1));
            C4044n c4044n = new C4044n("agent_info", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
            C4044n.Companion companion = C4044n.INSTANCE;
            C4044n c4044nA = companion.a(connection, "agent_info");
            if (!c4044n.equals(c4044nA)) {
                return new w.a(false, "agent_info(com.stepos.agentframework.chatcore.session.db.table.AgentInfo).\n Expected:\n" + c4044n + "\n Found:\n" + c4044nA);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put(RequestParameter.META_KEY_MESSAGE_ID, new C4044n.a(RequestParameter.META_KEY_MESSAGE_ID, "TEXT", true, 1, null, 1));
            linkedHashMap2.put("session_id", new C4044n.a("session_id", "TEXT", true, 0, null, 1));
            linkedHashMap2.put("agent_id", new C4044n.a("agent_id", "TEXT", true, 0, null, 1));
            linkedHashMap2.put("time", new C4044n.a("time", "INTEGER", true, 0, null, 1));
            linkedHashMap2.put(BundleContentBridge.KEY_ROLE, new C4044n.a(BundleContentBridge.KEY_ROLE, "TEXT", true, 0, null, 1));
            linkedHashMap2.put("view_splite_id", new C4044n.a("view_splite_id", "TEXT", true, 0, null, 1));
            linkedHashMap2.put("is_like", new C4044n.a("is_like", "INTEGER", true, 0, null, 1));
            linkedHashMap2.put("is_dislike", new C4044n.a("is_dislike", "INTEGER", true, 0, null, 1));
            linkedHashMap2.put("server_item_id", new C4044n.a("server_item_id", "TEXT", true, 0, null, 1));
            linkedHashMap2.put("pair_id", new C4044n.a("pair_id", "TEXT", true, 0, null, 1));
            linkedHashMap2.put("trace_id", new C4044n.a("trace_id", "TEXT", true, 0, null, 1));
            linkedHashMap2.put("status", new C4044n.a("status", "TEXT", true, 0, null, 1));
            linkedHashMap2.put("error_code", new C4044n.a("error_code", "INTEGER", true, 0, null, 1));
            linkedHashMap2.put("error_message", new C4044n.a("error_message", "TEXT", true, 0, null, 1));
            linkedHashMap2.put("suggestions", new C4044n.a("suggestions", "TEXT", false, 0, null, 1));
            linkedHashMap2.put("hint", new C4044n.a("hint", "INTEGER", true, 0, null, 1));
            linkedHashMap2.put("send_failed", new C4044n.a("send_failed", "INTEGER", true, 0, "0", 1));
            linkedHashMap2.put(kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID, new C4044n.a(kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID, "TEXT", false, 0, null, 1));
            linkedHashMap2.put(SystemDeleteBroadcastReceiver.EXTRA_SOURCES, new C4044n.a(SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "TEXT", false, 0, null, 1));
            linkedHashMap2.put("variant_group_id", new C4044n.a("variant_group_id", "TEXT", true, 0, "''", 1));
            linkedHashMap2.put("variant_index", new C4044n.a("variant_index", "INTEGER", true, 0, "0", 1));
            linkedHashMap2.put("ui_actions", new C4044n.a("ui_actions", "TEXT", false, 0, null, 1));
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            linkedHashSet2.add(new C4044n.d("index_chat_message_session_id_time_message_id", false, C1173v.p("session_id", "time", RequestParameter.META_KEY_MESSAGE_ID), C1173v.p("ASC", "ASC", "ASC")));
            linkedHashSet2.add(new C4044n.d("index_chat_message_pair_id", false, C1172u.e("pair_id"), C1172u.e("ASC")));
            C4044n c4044n2 = new C4044n("chat_message", linkedHashMap2, linkedHashSet, linkedHashSet2);
            C4044n c4044nA2 = companion.a(connection, "chat_message");
            if (!c4044n2.equals(c4044nA2)) {
                return new w.a(false, "chat_message(com.stepos.agentframework.chatcore.session.db.table.ChatMessage).\n Expected:\n" + c4044n2 + "\n Found:\n" + c4044nA2);
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put("id", new C4044n.a("id", "INTEGER", true, 1, null, 1));
            linkedHashMap3.put(RequestParameter.META_KEY_MESSAGE_ID, new C4044n.a(RequestParameter.META_KEY_MESSAGE_ID, "TEXT", true, 0, null, 1));
            linkedHashMap3.put("group_id", new C4044n.a("group_id", "TEXT", true, 0, null, 1));
            linkedHashMap3.put("variant_index", new C4044n.a("variant_index", "INTEGER", true, 0, null, 1));
            linkedHashMap3.put("session_id", new C4044n.a("session_id", "TEXT", true, 0, null, 1));
            linkedHashMap3.put("snapshot_json", new C4044n.a("snapshot_json", "TEXT", true, 0, null, 1));
            linkedHashMap3.put("archived_at", new C4044n.a("archived_at", "INTEGER", true, 0, null, 1));
            LinkedHashSet linkedHashSet3 = new LinkedHashSet();
            LinkedHashSet linkedHashSet4 = new LinkedHashSet();
            linkedHashSet4.add(new C4044n.d("index_chat_message_variant_group_id_variant_index", true, C1173v.p("group_id", "variant_index"), C1173v.p("ASC", "ASC")));
            linkedHashSet4.add(new C4044n.d("index_chat_message_variant_session_id", false, C1172u.e("session_id"), C1172u.e("ASC")));
            C4044n c4044n3 = new C4044n("chat_message_variant", linkedHashMap3, linkedHashSet3, linkedHashSet4);
            C4044n c4044nA3 = companion.a(connection, "chat_message_variant");
            if (!c4044n3.equals(c4044nA3)) {
                return new w.a(false, "chat_message_variant(com.stepos.agentframework.chatcore.session.db.table.ChatMessageVariant).\n Expected:\n" + c4044n3 + "\n Found:\n" + c4044nA3);
            }
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            linkedHashMap4.put(RequestParameter.META_KEY_MESSAGE_ID, new C4044n.a(RequestParameter.META_KEY_MESSAGE_ID, "TEXT", true, 1, null, 1));
            linkedHashMap4.put("part_index", new C4044n.a("part_index", "INTEGER", true, 2, null, 1));
            linkedHashMap4.put("part_type", new C4044n.a("part_type", "TEXT", true, 0, null, 1));
            linkedHashMap4.put("payload_json", new C4044n.a("payload_json", "TEXT", true, 0, null, 1));
            linkedHashMap4.put(c.a.COL_UPDATED_AT, new C4044n.a(c.a.COL_UPDATED_AT, "INTEGER", true, 0, null, 1));
            LinkedHashSet linkedHashSet5 = new LinkedHashSet();
            linkedHashSet5.add(new C4044n.c("chat_message", "CASCADE", "NO ACTION", C1172u.e(RequestParameter.META_KEY_MESSAGE_ID), C1172u.e(RequestParameter.META_KEY_MESSAGE_ID)));
            LinkedHashSet linkedHashSet6 = new LinkedHashSet();
            linkedHashSet6.add(new C4044n.d("index_message_part_message_id", false, C1172u.e(RequestParameter.META_KEY_MESSAGE_ID), C1172u.e("ASC")));
            C4044n c4044n4 = new C4044n("message_part", linkedHashMap4, linkedHashSet5, linkedHashSet6);
            C4044n c4044nA4 = companion.a(connection, "message_part");
            if (!c4044n4.equals(c4044nA4)) {
                return new w.a(false, "message_part(com.stepos.agentframework.chatcore.session.db.table.MessagePart).\n Expected:\n" + c4044n4 + "\n Found:\n" + c4044nA4);
            }
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            linkedHashMap5.put(RequestParameter.META_KEY_MESSAGE_ID, new C4044n.a(RequestParameter.META_KEY_MESSAGE_ID, "TEXT", true, 1, null, 1));
            linkedHashMap5.put("session_id", new C4044n.a("session_id", "TEXT", true, 0, null, 1));
            linkedHashMap5.put("agent_id", new C4044n.a("agent_id", "TEXT", true, 0, null, 1));
            linkedHashMap5.put(BundleContentBridge.KEY_ROLE, new C4044n.a(BundleContentBridge.KEY_ROLE, "TEXT", true, 0, null, 1));
            linkedHashMap5.put("searchable_text", new C4044n.a("searchable_text", "TEXT", true, 0, null, 1));
            linkedHashMap5.put(c.a.COL_UPDATED_AT, new C4044n.a(c.a.COL_UPDATED_AT, "INTEGER", true, 0, null, 1));
            linkedHashMap5.put("status", new C4044n.a("status", "TEXT", true, 0, null, 1));
            LinkedHashSet linkedHashSet7 = new LinkedHashSet();
            linkedHashSet7.add(new C4044n.c("chat_message", "CASCADE", "NO ACTION", C1172u.e(RequestParameter.META_KEY_MESSAGE_ID), C1172u.e(RequestParameter.META_KEY_MESSAGE_ID)));
            LinkedHashSet linkedHashSet8 = new LinkedHashSet();
            linkedHashSet8.add(new C4044n.d("index_message_search_document_agent_id", false, C1172u.e("agent_id"), C1172u.e("ASC")));
            linkedHashSet8.add(new C4044n.d("index_message_search_document_session_id_updated_at", false, C1173v.p("session_id", c.a.COL_UPDATED_AT), C1173v.p("ASC", "ASC")));
            C4044n c4044n5 = new C4044n("message_search_document", linkedHashMap5, linkedHashSet7, linkedHashSet8);
            C4044n c4044nA5 = companion.a(connection, "message_search_document");
            if (!c4044n5.equals(c4044nA5)) {
                return new w.a(false, "message_search_document(com.stepos.agentframework.chatcore.session.db.table.MessageSearchProjectionEntity).\n Expected:\n" + c4044n5 + "\n Found:\n" + c4044nA5);
            }
            LinkedHashMap linkedHashMap6 = new LinkedHashMap();
            linkedHashMap6.put("task_id", new C4044n.a("task_id", "TEXT", true, 1, null, 1));
            linkedHashMap6.put("session_id", new C4044n.a("session_id", "TEXT", true, 0, null, 1));
            linkedHashMap6.put("title", new C4044n.a("title", "TEXT", true, 0, null, 1));
            linkedHashMap6.put("searchable_text", new C4044n.a("searchable_text", "TEXT", true, 0, null, 1));
            linkedHashMap6.put("status", new C4044n.a("status", "TEXT", true, 0, null, 1));
            linkedHashMap6.put(c.a.COL_UPDATED_AT, new C4044n.a(c.a.COL_UPDATED_AT, "INTEGER", true, 0, null, 1));
            linkedHashMap6.put("read_at", new C4044n.a("read_at", "INTEGER", false, 0, null, 1));
            LinkedHashSet linkedHashSet9 = new LinkedHashSet();
            LinkedHashSet linkedHashSet10 = new LinkedHashSet();
            linkedHashSet10.add(new C4044n.d("index_task_search_document_session_id", false, C1172u.e("session_id"), C1172u.e("ASC")));
            linkedHashSet10.add(new C4044n.d("index_task_search_document_updated_at", false, C1172u.e(c.a.COL_UPDATED_AT), C1172u.e("ASC")));
            C4044n c4044n6 = new C4044n("task_search_document", linkedHashMap6, linkedHashSet9, linkedHashSet10);
            C4044n c4044nA6 = companion.a(connection, "task_search_document");
            if (!c4044n6.equals(c4044nA6)) {
                return new w.a(false, "task_search_document(com.stepos.agentframework.chatcore.session.db.table.TaskSearchDocumentEntity).\n Expected:\n" + c4044n6 + "\n Found:\n" + c4044nA6);
            }
            LinkedHashMap linkedHashMap7 = new LinkedHashMap();
            linkedHashMap7.put("id", new C4044n.a("id", "INTEGER", true, 1, null, 1));
            linkedHashMap7.put("session_id", new C4044n.a("session_id", "TEXT", true, 0, null, 1));
            linkedHashMap7.put("title", new C4044n.a("title", "TEXT", true, 0, null, 1));
            linkedHashMap7.put("agent_id", new C4044n.a("agent_id", "TEXT", true, 0, null, 1));
            linkedHashMap7.put(Parameters.DEVICE_ID, new C4044n.a(Parameters.DEVICE_ID, "TEXT", true, 0, "''", 1));
            linkedHashMap7.put("create_time", new C4044n.a("create_time", "INTEGER", true, 0, null, 1));
            linkedHashMap7.put("last_active_at", new C4044n.a("last_active_at", "INTEGER", true, 0, null, 1));
            linkedHashMap7.put("last_read_at", new C4044n.a("last_read_at", "INTEGER", true, 0, null, 1));
            linkedHashMap7.put("is_temp_session", new C4044n.a("is_temp_session", "INTEGER", true, 0, null, 1));
            linkedHashMap7.put("session_kind", new C4044n.a("session_kind", "INTEGER", true, 0, "0", 1));
            linkedHashMap7.put("send_failed", new C4044n.a("send_failed", "INTEGER", true, 0, "0", 1));
            linkedHashMap7.put("title_source", new C4044n.a("title_source", "INTEGER", true, 0, "0", 1));
            linkedHashMap7.put("delete_status", new C4044n.a("delete_status", "INTEGER", true, 0, "0", 1));
            LinkedHashSet linkedHashSet11 = new LinkedHashSet();
            LinkedHashSet linkedHashSet12 = new LinkedHashSet();
            linkedHashSet12.add(new C4044n.d("index_conversation_title_agent_id_session_id", true, C1173v.p("agent_id", "session_id"), C1173v.p("ASC", "ASC")));
            C4044n c4044n7 = new C4044n("conversation_title", linkedHashMap7, linkedHashSet11, linkedHashSet12);
            C4044n c4044nA7 = companion.a(connection, "conversation_title");
            if (!c4044n7.equals(c4044nA7)) {
                return new w.a(false, "conversation_title(com.stepos.agentframework.chatcore.session.db.table.ConversationTitle).\n Expected:\n" + c4044n7 + "\n Found:\n" + c4044nA7);
            }
            LinkedHashMap linkedHashMap8 = new LinkedHashMap();
            linkedHashMap8.put("task_id", new C4044n.a("task_id", "TEXT", true, 1, null, 1));
            linkedHashMap8.put("status", new C4044n.a("status", "TEXT", true, 0, null, 1));
            linkedHashMap8.put("source_from", new C4044n.a("source_from", "TEXT", true, 0, null, 1));
            linkedHashMap8.put("error_msg", new C4044n.a("error_msg", "TEXT", false, 0, null, 1));
            linkedHashMap8.put("first_run_time", new C4044n.a("first_run_time", "INTEGER", true, 0, null, 1));
            linkedHashMap8.put("update_time", new C4044n.a("update_time", "INTEGER", true, 0, null, 1));
            linkedHashMap8.put("task_name", new C4044n.a("task_name", "TEXT", false, 0, null, 1));
            linkedHashMap8.put("task_desc", new C4044n.a("task_desc", "TEXT", false, 0, null, 1));
            linkedHashMap8.put("latest_screenshot_path", new C4044n.a("latest_screenshot_path", "TEXT", false, 0, null, 1));
            C4044n c4044n8 = new C4044n("task_robot_info", linkedHashMap8, new LinkedHashSet(), new LinkedHashSet());
            C4044n c4044nA8 = companion.a(connection, "task_robot_info");
            if (!c4044n8.equals(c4044nA8)) {
                return new w.a(false, "task_robot_info(com.stepos.agentframework.chatcore.session.db.table.RobotInfo).\n Expected:\n" + c4044n8 + "\n Found:\n" + c4044nA8);
            }
            LinkedHashMap linkedHashMap9 = new LinkedHashMap();
            linkedHashMap9.put("sub_session_key", new C4044n.a("sub_session_key", "TEXT", true, 1, null, 1));
            linkedHashMap9.put(c.a.COL_REQUEST_SESSION_KEY, new C4044n.a(c.a.COL_REQUEST_SESSION_KEY, "TEXT", true, 0, null, 1));
            linkedHashMap9.put("task_id", new C4044n.a("task_id", "TEXT", true, 0, null, 1));
            linkedHashMap9.put("agent_id", new C4044n.a("agent_id", "TEXT", true, 0, null, 1));
            linkedHashMap9.put("card_time", new C4044n.a("card_time", "INTEGER", true, 0, null, 1));
            linkedHashMap9.put(c.a.COL_UPDATED_AT, new C4044n.a(c.a.COL_UPDATED_AT, "INTEGER", true, 0, null, 1));
            C4044n c4044n9 = new C4044n("task_session_link", linkedHashMap9, new LinkedHashSet(), new LinkedHashSet());
            C4044n c4044nA9 = companion.a(connection, "task_session_link");
            if (!c4044n9.equals(c4044nA9)) {
                return new w.a(false, "task_session_link(com.stepos.agentframework.chatcore.session.db.table.TaskSessionLink).\n Expected:\n" + c4044n9 + "\n Found:\n" + c4044nA9);
            }
            LinkedHashMap linkedHashMap10 = new LinkedHashMap();
            linkedHashMap10.put("request_id", new C4044n.a("request_id", "TEXT", true, 1, null, 1));
            linkedHashMap10.put("session_id", new C4044n.a("session_id", "TEXT", true, 0, null, 1));
            linkedHashMap10.put("agent_id", new C4044n.a("agent_id", "TEXT", true, 0, null, 1));
            linkedHashMap10.put("action_kind", new C4044n.a("action_kind", "TEXT", true, 0, null, 1));
            linkedHashMap10.put(c.a.COL_CREATED_AT, new C4044n.a(c.a.COL_CREATED_AT, "INTEGER", true, 0, null, 1));
            linkedHashMap10.put("expires_at", new C4044n.a("expires_at", "INTEGER", false, 0, null, 1));
            LinkedHashSet linkedHashSet13 = new LinkedHashSet();
            LinkedHashSet linkedHashSet14 = new LinkedHashSet();
            linkedHashSet14.add(new C4044n.d("index_session_pending_action_session_id", false, C1172u.e("session_id"), C1172u.e("ASC")));
            linkedHashSet14.add(new C4044n.d("index_session_pending_action_expires_at", false, C1172u.e("expires_at"), C1172u.e("ASC")));
            C4044n c4044n10 = new C4044n("session_pending_action", linkedHashMap10, linkedHashSet13, linkedHashSet14);
            C4044n c4044nA10 = companion.a(connection, "session_pending_action");
            if (!c4044n10.equals(c4044nA10)) {
                return new w.a(false, "session_pending_action(com.stepos.agentframework.chatcore.session.db.table.SessionPendingActionEntity).\n Expected:\n" + c4044n10 + "\n Found:\n" + c4044nA10);
            }
            LinkedHashMap linkedHashMap11 = new LinkedHashMap();
            linkedHashMap11.put("file_id", new C4044n.a("file_id", "TEXT", true, 1, null, 1));
            linkedHashMap11.put("session_id", new C4044n.a("session_id", "TEXT", true, 0, null, 1));
            linkedHashMap11.put(RequestParameter.META_KEY_MESSAGE_ID, new C4044n.a(RequestParameter.META_KEY_MESSAGE_ID, "TEXT", true, 0, null, 1));
            linkedHashMap11.put("tool_call_id", new C4044n.a("tool_call_id", "TEXT", true, 0, null, 1));
            linkedHashMap11.put("task_id", new C4044n.a("task_id", "TEXT", false, 0, null, 1));
            linkedHashMap11.put("version_id", new C4044n.a("version_id", "TEXT", false, 0, null, 1));
            linkedHashMap11.put("cloud_path", new C4044n.a("cloud_path", "TEXT", false, 0, null, 1));
            linkedHashMap11.put("file_name", new C4044n.a("file_name", "TEXT", false, 0, null, 1));
            linkedHashMap11.put("title", new C4044n.a("title", "TEXT", false, 0, null, 1));
            linkedHashMap11.put("mime_type", new C4044n.a("mime_type", "TEXT", false, 0, null, 1));
            linkedHashMap11.put(ContentDisposition.Parameters.Size, new C4044n.a(ContentDisposition.Parameters.Size, "INTEGER", false, 0, null, 1));
            linkedHashMap11.put(c.a.COL_CREATED_AT, new C4044n.a(c.a.COL_CREATED_AT, "INTEGER", true, 0, null, 1));
            linkedHashMap11.put("availability", new C4044n.a("availability", "INTEGER", true, 0, "0", 1));
            linkedHashMap11.put("checked_at", new C4044n.a("checked_at", "INTEGER", true, 0, "0", 1));
            LinkedHashSet linkedHashSet15 = new LinkedHashSet();
            linkedHashSet15.add(new C4044n.c("chat_message", "CASCADE", "NO ACTION", C1172u.e(RequestParameter.META_KEY_MESSAGE_ID), C1172u.e(RequestParameter.META_KEY_MESSAGE_ID)));
            LinkedHashSet linkedHashSet16 = new LinkedHashSet();
            linkedHashSet16.add(new C4044n.d("index_task_result_artifact_session_id_created_at", false, C1173v.p("session_id", c.a.COL_CREATED_AT), C1173v.p("ASC", "ASC")));
            linkedHashSet16.add(new C4044n.d("index_task_result_artifact_message_id", false, C1172u.e(RequestParameter.META_KEY_MESSAGE_ID), C1172u.e("ASC")));
            C4044n c4044n11 = new C4044n("task_result_artifact", linkedHashMap11, linkedHashSet15, linkedHashSet16);
            C4044n c4044nA11 = companion.a(connection, "task_result_artifact");
            if (c4044n11.equals(c4044nA11)) {
                return new w.a(true, null);
            }
            return new w.a(false, "task_result_artifact(com.stepos.agentframework.chatcore.session.db.table.TaskResultArtifactEntity).\n Expected:\n" + c4044n11 + "\n Found:\n" + c4044nA11);
        }
    }

    public static final C1878e D0(FwkDatabase_Impl fwkDatabase_Impl) {
        return new C1878e(fwkDatabase_Impl);
    }

    public static final E E0(FwkDatabase_Impl fwkDatabase_Impl) {
        return new E(fwkDatabase_Impl);
    }

    public static final P F0(FwkDatabase_Impl fwkDatabase_Impl) {
        return new P(fwkDatabase_Impl);
    }

    public static final C1906p0 G0(FwkDatabase_Impl fwkDatabase_Impl) {
        return new C1906p0(fwkDatabase_Impl);
    }

    public static final H0 H0(FwkDatabase_Impl fwkDatabase_Impl) {
        return new H0(fwkDatabase_Impl);
    }

    public static final Q0 I0(FwkDatabase_Impl fwkDatabase_Impl) {
        return new Q0(fwkDatabase_Impl);
    }

    public static final U0 J0(FwkDatabase_Impl fwkDatabase_Impl) {
        return new U0(fwkDatabase_Impl);
    }

    public static final C1880e1 K0(FwkDatabase_Impl fwkDatabase_Impl) {
        return new C1880e1(fwkDatabase_Impl);
    }

    public static final p1 L0(FwkDatabase_Impl fwkDatabase_Impl) {
        return new p1(fwkDatabase_Impl);
    }

    public static final A1 M0(FwkDatabase_Impl fwkDatabase_Impl) {
        return new A1(fwkDatabase_Impl);
    }

    public static final H1 N0(FwkDatabase_Impl fwkDatabase_Impl) {
        return new H1(fwkDatabase_Impl);
    }

    @Override // androidx.room.RoomDatabase
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public androidx.room.w n() {
        return new a();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.FwkDatabase
    public InterfaceC1866a h0() {
        return this._agentInfoDao.getValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.FwkDatabase
    public Q i0() {
        return this._conversationTitleDao.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public List<AbstractC3942a> j(Map<InterfaceC5745d<Object>, Object> autoMigrationSpecs) {
        kotlin.jvm.internal.p.i(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.FwkDatabase
    public InterfaceC1881f j0() {
        return this._chatMessageDao.getValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.FwkDatabase
    public C0 k0() {
        return this._messagePartDao.getValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.FwkDatabase
    public I0 l0() {
        return this._messageSearchProjectionDao.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker m() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "agent_info", "chat_message", "chat_message_variant", "message_part", "message_search_document", "task_search_document", "conversation_title", "task_robot_info", "task_session_link", "session_pending_action", "task_result_artifact");
    }

    @Override // com.stepos.agentframework.chatcore.session.db.FwkDatabase
    public F m0() {
        return this._chatMessageVariantDao.getValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.FwkDatabase
    public R0 n0() {
        return this._robotInfoDao.getValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.FwkDatabase
    public W0 o0() {
        return this._sessionPendingActionDao.getValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.FwkDatabase
    public InterfaceC1883f1 p0() {
        return this._taskResultArtifactDao.getValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.FwkDatabase
    public q1 q0() {
        return this._taskSearchDocumentDao.getValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.FwkDatabase
    public B1 r0() {
        return this._taskSessionLinkDao.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public Set<InterfaceC5745d<Object>> w() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<InterfaceC5745d<?>, List<InterfaceC5745d<?>>> y() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(kotlin.jvm.internal.t.b(InterfaceC1866a.class), C1878e.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(InterfaceC1881f.class), E.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(F.class), P.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(C0.class), H0.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(I0.class), Q0.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(q1.class), A1.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(R0.class), U0.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(Q.class), C1906p0.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(B1.class), H1.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(W0.class), C1880e1.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(InterfaceC1883f1.class), p1.INSTANCE.a());
        return linkedHashMap;
    }
}
