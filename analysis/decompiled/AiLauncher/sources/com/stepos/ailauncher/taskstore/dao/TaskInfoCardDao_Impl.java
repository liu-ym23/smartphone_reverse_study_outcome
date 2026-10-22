package com.stepos.ailauncher.taskstore.dao;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.AbstractC1409e;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity;
import com.stepos.ailauncher.taskstore.provider.c;
import e9.InterfaceC4014c;
import f1.C4031a;
import f1.C4038h;
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

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u0001AB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\f\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000e\u0010\nJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0010\u0010\nJ\u001e\u0010\u0015\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001a2\u0006\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u001d\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u001e\u0010\u0019JG\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u001a2\u0006\u0010\u001d\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010!\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\"\u0010#J&\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b%\u0010&J,\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u001d\u001a\u00020\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0004\b(\u0010)J,\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u001d\u001a\u00020\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0004\b+\u0010)J\u001a\u0010,\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b,\u0010\u0019J(\u0010/\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b/\u00100J \u00102\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b2\u00103J\"\u00105\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u00010\u0012H\u0096@¢\u0006\u0004\b5\u0010&J\"\u00107\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u00010\u0012H\u0096@¢\u0006\u0004\b7\u0010&J \u00109\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u00108\u001a\u00020\bH\u0096@¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b;\u0010\u0019J\u001e\u0010<\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0004\b<\u0010\u0016J\u001e\u0010=\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0004\b=\u0010\u0016J\u001e\u0010>\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0004\b>\u0010\u0016J\u001e\u0010?\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0004\b?\u0010\u0016J\u0010\u0010A\u001a\u00020@H\u0096@¢\u0006\u0004\bA\u0010BR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010CR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00060D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00060G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010I¨\u0006L"}, d2 = {"Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardDao_Impl;", "Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "card", "", "n", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;Le9/c;)Ljava/lang/Object;", "", "y", "Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardUpsertOutcome;", "r", "Lcom/stepos/ailauncher/taskstore/dao/C;", "k", "", "", "taskIds", "", "e", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "taskId", "l", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LXa/b;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)LXa/b;", "uid", "z", "activeExcludedStatuses", "terminalStatuses", "terminalLimit", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;I)LXa/b;", "parentTaskId", "t", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "sessionKeys", "w", "(Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "excludedStatuses", "o", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "oldKey", "newKey", "x", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "hidden", "s", "(Ljava/lang/String;ZLe9/c;)Ljava/lang/Object;", "status", "u", "json", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "readAt", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "q", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "m", "LY8/t;", Const.INTENT_KEY_UMID, "(Le9/c;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfTaskInfoCardEntity", "Landroidx/room/f;", "Landroidx/room/e;", "__deleteAdapterOfTaskInfoCardEntity", "Landroidx/room/e;", "__updateAdapterOfTaskInfoCardEntity", "Companion", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoCardDao_Impl implements TaskInfoCardDao {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1409e<TaskInfoCardEntity> __deleteAdapterOfTaskInfoCardEntity;
    private final AbstractC1410f<TaskInfoCardEntity> __insertAdapterOfTaskInfoCardEntity;
    private final AbstractC1409e<TaskInfoCardEntity> __updateAdapterOfTaskInfoCardEntity;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/taskstore/dao/TaskInfoCardDao_Impl$a", "Landroidx/room/f;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1410f<TaskInfoCardEntity> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `task_info` (`task_id`,`uid`,`event_type`,`seq`,`ts`,`session_key`,`parent_task_id`,`sub_task_ids_json`,`type`,`version`,`version_id`,`task_version`,`active_task_version`,`no_task_detail`,`status`,`title`,`sub_title`,`icon_url`,`progress_json`,`summary`,`request_session_key`,`pending_questions_json`,`intention`,`created_at`,`started_at`,`ended_at`,`updated_at`,`result_json`,`extensions_json`,`sub_tasks_json`,`answer_json`,`is_hidden`,`notification_dismissed_status`,`duration_ms`,`answered_question_texts_json`,`read_at`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, TaskInfoCardEntity entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getTaskId());
            statement.H(2, entity.getUid());
            statement.H(3, entity.getEventType());
            Long seq = entity.getSeq();
            if (seq == null) {
                statement.bindNull(4);
            } else {
                statement.bindLong(4, seq.longValue());
            }
            Long ts = entity.getTs();
            if (ts == null) {
                statement.bindNull(5);
            } else {
                statement.bindLong(5, ts.longValue());
            }
            String sessionKey = entity.getSessionKey();
            if (sessionKey == null) {
                statement.bindNull(6);
            } else {
                statement.H(6, sessionKey);
            }
            String parentTaskId = entity.getParentTaskId();
            if (parentTaskId == null) {
                statement.bindNull(7);
            } else {
                statement.H(7, parentTaskId);
            }
            String subTaskIdsJson = entity.getSubTaskIdsJson();
            if (subTaskIdsJson == null) {
                statement.bindNull(8);
            } else {
                statement.H(8, subTaskIdsJson);
            }
            statement.H(9, entity.getType());
            if (entity.getVersion() == null) {
                statement.bindNull(10);
            } else {
                statement.bindLong(10, r3.intValue());
            }
            String versionId = entity.getVersionId();
            if (versionId == null) {
                statement.bindNull(11);
            } else {
                statement.H(11, versionId);
            }
            statement.bindLong(12, entity.getTaskVersion());
            statement.bindLong(13, entity.getActiveTaskVersion());
            statement.bindLong(14, entity.getNoTaskDetail() ? 1L : 0L);
            statement.H(15, entity.getStatus());
            String title = entity.getTitle();
            if (title == null) {
                statement.bindNull(16);
            } else {
                statement.H(16, title);
            }
            String subTitle = entity.getSubTitle();
            if (subTitle == null) {
                statement.bindNull(17);
            } else {
                statement.H(17, subTitle);
            }
            String iconUrl = entity.getIconUrl();
            if (iconUrl == null) {
                statement.bindNull(18);
            } else {
                statement.H(18, iconUrl);
            }
            String progressJson = entity.getProgressJson();
            if (progressJson == null) {
                statement.bindNull(19);
            } else {
                statement.H(19, progressJson);
            }
            String summary = entity.getSummary();
            if (summary == null) {
                statement.bindNull(20);
            } else {
                statement.H(20, summary);
            }
            String requestSessionKey = entity.getRequestSessionKey();
            if (requestSessionKey == null) {
                statement.bindNull(21);
            } else {
                statement.H(21, requestSessionKey);
            }
            String pendingQuestionsJson = entity.getPendingQuestionsJson();
            if (pendingQuestionsJson == null) {
                statement.bindNull(22);
            } else {
                statement.H(22, pendingQuestionsJson);
            }
            String intention = entity.getIntention();
            if (intention == null) {
                statement.bindNull(23);
            } else {
                statement.H(23, intention);
            }
            statement.bindLong(24, entity.getCreatedAt());
            Long startedAt = entity.getStartedAt();
            if (startedAt == null) {
                statement.bindNull(25);
            } else {
                statement.bindLong(25, startedAt.longValue());
            }
            Long endedAt = entity.getEndedAt();
            if (endedAt == null) {
                statement.bindNull(26);
            } else {
                statement.bindLong(26, endedAt.longValue());
            }
            statement.bindLong(27, entity.getUpdatedAt());
            String resultJson = entity.getResultJson();
            if (resultJson == null) {
                statement.bindNull(28);
            } else {
                statement.H(28, resultJson);
            }
            String extensionsJson = entity.getExtensionsJson();
            if (extensionsJson == null) {
                statement.bindNull(29);
            } else {
                statement.H(29, extensionsJson);
            }
            String subTasksJson = entity.getSubTasksJson();
            if (subTasksJson == null) {
                statement.bindNull(30);
            } else {
                statement.H(30, subTasksJson);
            }
            String answerJson = entity.getAnswerJson();
            if (answerJson == null) {
                statement.bindNull(31);
            } else {
                statement.H(31, answerJson);
            }
            statement.bindLong(32, entity.isHidden() ? 1L : 0L);
            String notificationDismissedStatus = entity.getNotificationDismissedStatus();
            if (notificationDismissedStatus == null) {
                statement.bindNull(33);
            } else {
                statement.H(33, notificationDismissedStatus);
            }
            Long durationMs = entity.getDurationMs();
            if (durationMs == null) {
                statement.bindNull(34);
            } else {
                statement.bindLong(34, durationMs.longValue());
            }
            String answeredQuestionTextsJson = entity.getAnsweredQuestionTextsJson();
            if (answeredQuestionTextsJson == null) {
                statement.bindNull(35);
            } else {
                statement.H(35, answeredQuestionTextsJson);
            }
            Long readAt = entity.getReadAt();
            if (readAt == null) {
                statement.bindNull(36);
            } else {
                statement.bindLong(36, readAt.longValue());
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/taskstore/dao/TaskInfoCardDao_Impl$b", "Landroidx/room/e;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", Const.INTENT_KEY_UMID, "(Li1/d;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AbstractC1409e<TaskInfoCardEntity> {
        @Override // androidx.room.AbstractC1409e
        public String b() {
            return "DELETE FROM `task_info` WHERE `task_id` = ?";
        }

        @Override // androidx.room.AbstractC1409e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, TaskInfoCardEntity entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getTaskId());
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/taskstore/dao/TaskInfoCardDao_Impl$c", "Landroidx/room/e;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", Const.INTENT_KEY_UMID, "(Li1/d;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AbstractC1409e<TaskInfoCardEntity> {
        @Override // androidx.room.AbstractC1409e
        public String b() {
            return "UPDATE OR ABORT `task_info` SET `task_id` = ?,`uid` = ?,`event_type` = ?,`seq` = ?,`ts` = ?,`session_key` = ?,`parent_task_id` = ?,`sub_task_ids_json` = ?,`type` = ?,`version` = ?,`version_id` = ?,`task_version` = ?,`active_task_version` = ?,`no_task_detail` = ?,`status` = ?,`title` = ?,`sub_title` = ?,`icon_url` = ?,`progress_json` = ?,`summary` = ?,`request_session_key` = ?,`pending_questions_json` = ?,`intention` = ?,`created_at` = ?,`started_at` = ?,`ended_at` = ?,`updated_at` = ?,`result_json` = ?,`extensions_json` = ?,`sub_tasks_json` = ?,`answer_json` = ?,`is_hidden` = ?,`notification_dismissed_status` = ?,`duration_ms` = ?,`answered_question_texts_json` = ?,`read_at` = ? WHERE `task_id` = ?";
        }

        @Override // androidx.room.AbstractC1409e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, TaskInfoCardEntity entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getTaskId());
            statement.H(2, entity.getUid());
            statement.H(3, entity.getEventType());
            Long seq = entity.getSeq();
            if (seq == null) {
                statement.bindNull(4);
            } else {
                statement.bindLong(4, seq.longValue());
            }
            Long ts = entity.getTs();
            if (ts == null) {
                statement.bindNull(5);
            } else {
                statement.bindLong(5, ts.longValue());
            }
            String sessionKey = entity.getSessionKey();
            if (sessionKey == null) {
                statement.bindNull(6);
            } else {
                statement.H(6, sessionKey);
            }
            String parentTaskId = entity.getParentTaskId();
            if (parentTaskId == null) {
                statement.bindNull(7);
            } else {
                statement.H(7, parentTaskId);
            }
            String subTaskIdsJson = entity.getSubTaskIdsJson();
            if (subTaskIdsJson == null) {
                statement.bindNull(8);
            } else {
                statement.H(8, subTaskIdsJson);
            }
            statement.H(9, entity.getType());
            if (entity.getVersion() == null) {
                statement.bindNull(10);
            } else {
                statement.bindLong(10, r3.intValue());
            }
            String versionId = entity.getVersionId();
            if (versionId == null) {
                statement.bindNull(11);
            } else {
                statement.H(11, versionId);
            }
            statement.bindLong(12, entity.getTaskVersion());
            statement.bindLong(13, entity.getActiveTaskVersion());
            statement.bindLong(14, entity.getNoTaskDetail() ? 1L : 0L);
            statement.H(15, entity.getStatus());
            String title = entity.getTitle();
            if (title == null) {
                statement.bindNull(16);
            } else {
                statement.H(16, title);
            }
            String subTitle = entity.getSubTitle();
            if (subTitle == null) {
                statement.bindNull(17);
            } else {
                statement.H(17, subTitle);
            }
            String iconUrl = entity.getIconUrl();
            if (iconUrl == null) {
                statement.bindNull(18);
            } else {
                statement.H(18, iconUrl);
            }
            String progressJson = entity.getProgressJson();
            if (progressJson == null) {
                statement.bindNull(19);
            } else {
                statement.H(19, progressJson);
            }
            String summary = entity.getSummary();
            if (summary == null) {
                statement.bindNull(20);
            } else {
                statement.H(20, summary);
            }
            String requestSessionKey = entity.getRequestSessionKey();
            if (requestSessionKey == null) {
                statement.bindNull(21);
            } else {
                statement.H(21, requestSessionKey);
            }
            String pendingQuestionsJson = entity.getPendingQuestionsJson();
            if (pendingQuestionsJson == null) {
                statement.bindNull(22);
            } else {
                statement.H(22, pendingQuestionsJson);
            }
            String intention = entity.getIntention();
            if (intention == null) {
                statement.bindNull(23);
            } else {
                statement.H(23, intention);
            }
            statement.bindLong(24, entity.getCreatedAt());
            Long startedAt = entity.getStartedAt();
            if (startedAt == null) {
                statement.bindNull(25);
            } else {
                statement.bindLong(25, startedAt.longValue());
            }
            Long endedAt = entity.getEndedAt();
            if (endedAt == null) {
                statement.bindNull(26);
            } else {
                statement.bindLong(26, endedAt.longValue());
            }
            statement.bindLong(27, entity.getUpdatedAt());
            String resultJson = entity.getResultJson();
            if (resultJson == null) {
                statement.bindNull(28);
            } else {
                statement.H(28, resultJson);
            }
            String extensionsJson = entity.getExtensionsJson();
            if (extensionsJson == null) {
                statement.bindNull(29);
            } else {
                statement.H(29, extensionsJson);
            }
            String subTasksJson = entity.getSubTasksJson();
            if (subTasksJson == null) {
                statement.bindNull(30);
            } else {
                statement.H(30, subTasksJson);
            }
            String answerJson = entity.getAnswerJson();
            if (answerJson == null) {
                statement.bindNull(31);
            } else {
                statement.H(31, answerJson);
            }
            statement.bindLong(32, entity.isHidden() ? 1L : 0L);
            String notificationDismissedStatus = entity.getNotificationDismissedStatus();
            if (notificationDismissedStatus == null) {
                statement.bindNull(33);
            } else {
                statement.H(33, notificationDismissedStatus);
            }
            Long durationMs = entity.getDurationMs();
            if (durationMs == null) {
                statement.bindNull(34);
            } else {
                statement.bindLong(34, durationMs.longValue());
            }
            String answeredQuestionTextsJson = entity.getAnsweredQuestionTextsJson();
            if (answeredQuestionTextsJson == null) {
                statement.bindNull(35);
            } else {
                statement.H(35, answeredQuestionTextsJson);
            }
            Long readAt = entity.getReadAt();
            if (readAt == null) {
                statement.bindNull(36);
            } else {
                statement.bindLong(36, readAt.longValue());
            }
            statement.H(37, entity.getTaskId());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardDao_Impl$d;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao_Impl$d, reason: from kotlin metadata */
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

    public TaskInfoCardDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfTaskInfoCardEntity = new a();
        this.__deleteAdapterOfTaskInfoCardEntity = new b();
        this.__updateAdapterOfTaskInfoCardEntity = new c();
    }

    public static final int a0(String str, String str2, InterfaceC4160b _connection) {
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

    public static final Y8.t b0(String str, InterfaceC4160b _connection) {
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

    public static final int c0(String str, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            interfaceC4162dQ1.n1();
            int iB = C4038h.b(_connection);
            interfaceC4162dQ1.close();
            return iB;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final int d0(String str, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            interfaceC4162dQ1.n1();
            int iB = C4038h.b(_connection);
            interfaceC4162dQ1.close();
            return iB;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final int e0(String str, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            interfaceC4162dQ1.n1();
            int iB = C4038h.b(_connection);
            interfaceC4162dQ1.close();
            return iB;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final int f0(String str, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            interfaceC4162dQ1.n1();
            int iB = C4038h.b(_connection);
            interfaceC4162dQ1.close();
            return iB;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final long g0(TaskInfoCardDao_Impl taskInfoCardDao_Impl, TaskInfoCardEntity taskInfoCardEntity, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        return taskInfoCardDao_Impl.__insertAdapterOfTaskInfoCardEntity.e(_connection, taskInfoCardEntity);
    }

    public static final int h0(String str, long j10, String str2, InterfaceC4160b _connection) {
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

    public static final Long i0(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            Long lValueOf = null;
            if (interfaceC4162dQ1.n1() && !interfaceC4162dQ1.isNull(0)) {
                lValueOf = Long.valueOf(interfaceC4162dQ1.getLong(0));
            }
            return lValueOf;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final TaskInfoCardEntity j0(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, "task_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "uid");
            int iC3 = C4039i.c(interfaceC4162dQ1, c.a.COL_EVENT_TYPE);
            int iC4 = C4039i.c(interfaceC4162dQ1, c.a.COL_SEQ);
            int iC5 = C4039i.c(interfaceC4162dQ1, "ts");
            int iC6 = C4039i.c(interfaceC4162dQ1, c.a.COL_SESSION_KEY);
            int iC7 = C4039i.c(interfaceC4162dQ1, c.a.COL_PARENT_TASK_ID);
            int iC8 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASK_IDS_JSON);
            int iC9 = C4039i.c(interfaceC4162dQ1, "type");
            int iC10 = C4039i.c(interfaceC4162dQ1, "version");
            int iC11 = C4039i.c(interfaceC4162dQ1, "version_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "task_version");
            int iC13 = C4039i.c(interfaceC4162dQ1, "active_task_version");
            int iC14 = C4039i.c(interfaceC4162dQ1, "no_task_detail");
            int iC15 = C4039i.c(interfaceC4162dQ1, "status");
            int iC16 = C4039i.c(interfaceC4162dQ1, "title");
            int iC17 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TITLE);
            int iC18 = C4039i.c(interfaceC4162dQ1, "icon_url");
            int iC19 = C4039i.c(interfaceC4162dQ1, c.a.COL_PROGRESS_JSON);
            int iC20 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUMMARY);
            int iC21 = C4039i.c(interfaceC4162dQ1, c.a.COL_REQUEST_SESSION_KEY);
            int iC22 = C4039i.c(interfaceC4162dQ1, c.a.COL_PENDING_QUESTIONS_JSON);
            int iC23 = C4039i.c(interfaceC4162dQ1, "intention");
            int iC24 = C4039i.c(interfaceC4162dQ1, c.a.COL_CREATED_AT);
            int iC25 = C4039i.c(interfaceC4162dQ1, c.a.COL_STARTED_AT);
            int iC26 = C4039i.c(interfaceC4162dQ1, c.a.COL_ENDED_AT);
            int iC27 = C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT);
            int iC28 = C4039i.c(interfaceC4162dQ1, c.a.COL_RESULT_JSON);
            int iC29 = C4039i.c(interfaceC4162dQ1, c.a.COL_EXTENSIONS_JSON);
            int iC30 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASKS_JSON);
            int iC31 = C4039i.c(interfaceC4162dQ1, c.a.COL_ANSWER_JSON);
            int iC32 = C4039i.c(interfaceC4162dQ1, "is_hidden");
            int iC33 = C4039i.c(interfaceC4162dQ1, "notification_dismissed_status");
            int iC34 = C4039i.c(interfaceC4162dQ1, "duration_ms");
            int iC35 = C4039i.c(interfaceC4162dQ1, "answered_question_texts_json");
            int iC36 = C4039i.c(interfaceC4162dQ1, "read_at");
            TaskInfoCardEntity taskInfoCardEntity = null;
            if (interfaceC4162dQ1.n1()) {
                taskInfoCardEntity = new TaskInfoCardEntity(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.isNull(iC4) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC4)), interfaceC4162dQ1.isNull(iC5) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC5)), interfaceC4162dQ1.isNull(iC6) ? null : interfaceC4162dQ1.X0(iC6), interfaceC4162dQ1.isNull(iC7) ? null : interfaceC4162dQ1.X0(iC7), interfaceC4162dQ1.isNull(iC8) ? null : interfaceC4162dQ1.X0(iC8), interfaceC4162dQ1.X0(iC9), interfaceC4162dQ1.isNull(iC10) ? null : Integer.valueOf((int) interfaceC4162dQ1.getLong(iC10)), interfaceC4162dQ1.isNull(iC11) ? null : interfaceC4162dQ1.X0(iC11), (int) interfaceC4162dQ1.getLong(iC12), (int) interfaceC4162dQ1.getLong(iC13), ((int) interfaceC4162dQ1.getLong(iC14)) != 0, interfaceC4162dQ1.X0(iC15), interfaceC4162dQ1.isNull(iC16) ? null : interfaceC4162dQ1.X0(iC16), interfaceC4162dQ1.isNull(iC17) ? null : interfaceC4162dQ1.X0(iC17), interfaceC4162dQ1.isNull(iC18) ? null : interfaceC4162dQ1.X0(iC18), interfaceC4162dQ1.isNull(iC19) ? null : interfaceC4162dQ1.X0(iC19), interfaceC4162dQ1.isNull(iC20) ? null : interfaceC4162dQ1.X0(iC20), interfaceC4162dQ1.isNull(iC21) ? null : interfaceC4162dQ1.X0(iC21), interfaceC4162dQ1.isNull(iC22) ? null : interfaceC4162dQ1.X0(iC22), interfaceC4162dQ1.isNull(iC23) ? null : interfaceC4162dQ1.X0(iC23), interfaceC4162dQ1.getLong(iC24), interfaceC4162dQ1.isNull(iC25) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC25)), interfaceC4162dQ1.isNull(iC26) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC26)), interfaceC4162dQ1.getLong(iC27), interfaceC4162dQ1.isNull(iC28) ? null : interfaceC4162dQ1.X0(iC28), interfaceC4162dQ1.isNull(iC29) ? null : interfaceC4162dQ1.X0(iC29), interfaceC4162dQ1.isNull(iC30) ? null : interfaceC4162dQ1.X0(iC30), interfaceC4162dQ1.isNull(iC31) ? null : interfaceC4162dQ1.X0(iC31), ((int) interfaceC4162dQ1.getLong(iC32)) != 0, interfaceC4162dQ1.isNull(iC33) ? null : interfaceC4162dQ1.X0(iC33), interfaceC4162dQ1.isNull(iC34) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC34)), interfaceC4162dQ1.isNull(iC35) ? null : interfaceC4162dQ1.X0(iC35), interfaceC4162dQ1.isNull(iC36) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC36)));
            }
            return taskInfoCardEntity;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List k0(String str, String str2, List list, int i10, List list2, int i11, int i12, InterfaceC4160b _connection) {
        int i13;
        int i14;
        Integer numValueOf;
        String strX0;
        int i15;
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            Iterator it = list.iterator();
            int i16 = 2;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i16, (String) it.next());
                i16++;
            }
            interfaceC4162dQ1.H(i10 + 2, str2);
            int i17 = i10 + 3;
            Iterator it2 = list2.iterator();
            int i18 = i17;
            while (it2.hasNext()) {
                interfaceC4162dQ1.H(i18, (String) it2.next());
                i18++;
            }
            interfaceC4162dQ1.bindLong(i17 + i11, i12);
            int iC = C4039i.c(interfaceC4162dQ1, "task_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "uid");
            int iC3 = C4039i.c(interfaceC4162dQ1, c.a.COL_EVENT_TYPE);
            int iC4 = C4039i.c(interfaceC4162dQ1, c.a.COL_SEQ);
            int iC5 = C4039i.c(interfaceC4162dQ1, "ts");
            int iC6 = C4039i.c(interfaceC4162dQ1, c.a.COL_SESSION_KEY);
            int iC7 = C4039i.c(interfaceC4162dQ1, c.a.COL_PARENT_TASK_ID);
            int iC8 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASK_IDS_JSON);
            int iC9 = C4039i.c(interfaceC4162dQ1, "type");
            int iC10 = C4039i.c(interfaceC4162dQ1, "version");
            int iC11 = C4039i.c(interfaceC4162dQ1, "version_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "task_version");
            int iC13 = C4039i.c(interfaceC4162dQ1, "active_task_version");
            int iC14 = C4039i.c(interfaceC4162dQ1, "no_task_detail");
            int iC15 = C4039i.c(interfaceC4162dQ1, "status");
            int iC16 = C4039i.c(interfaceC4162dQ1, "title");
            int iC17 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TITLE);
            int iC18 = C4039i.c(interfaceC4162dQ1, "icon_url");
            int iC19 = C4039i.c(interfaceC4162dQ1, c.a.COL_PROGRESS_JSON);
            int iC20 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUMMARY);
            int iC21 = C4039i.c(interfaceC4162dQ1, c.a.COL_REQUEST_SESSION_KEY);
            int iC22 = C4039i.c(interfaceC4162dQ1, c.a.COL_PENDING_QUESTIONS_JSON);
            int iC23 = C4039i.c(interfaceC4162dQ1, "intention");
            int iC24 = C4039i.c(interfaceC4162dQ1, c.a.COL_CREATED_AT);
            int iC25 = C4039i.c(interfaceC4162dQ1, c.a.COL_STARTED_AT);
            int iC26 = C4039i.c(interfaceC4162dQ1, c.a.COL_ENDED_AT);
            int iC27 = C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT);
            int iC28 = C4039i.c(interfaceC4162dQ1, c.a.COL_RESULT_JSON);
            int iC29 = C4039i.c(interfaceC4162dQ1, c.a.COL_EXTENSIONS_JSON);
            int iC30 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASKS_JSON);
            int iC31 = C4039i.c(interfaceC4162dQ1, c.a.COL_ANSWER_JSON);
            int iC32 = C4039i.c(interfaceC4162dQ1, "is_hidden");
            int iC33 = C4039i.c(interfaceC4162dQ1, "notification_dismissed_status");
            int iC34 = C4039i.c(interfaceC4162dQ1, "duration_ms");
            int iC35 = C4039i.c(interfaceC4162dQ1, "answered_question_texts_json");
            int iC36 = C4039i.c(interfaceC4162dQ1, "read_at");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                String strX02 = interfaceC4162dQ1.X0(iC);
                String strX03 = interfaceC4162dQ1.X0(iC2);
                String strX04 = interfaceC4162dQ1.X0(iC3);
                Long lValueOf = interfaceC4162dQ1.isNull(iC4) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC4));
                Long lValueOf2 = interfaceC4162dQ1.isNull(iC5) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC5));
                String strX05 = interfaceC4162dQ1.isNull(iC6) ? null : interfaceC4162dQ1.X0(iC6);
                String strX06 = interfaceC4162dQ1.isNull(iC7) ? null : interfaceC4162dQ1.X0(iC7);
                String strX07 = interfaceC4162dQ1.isNull(iC8) ? null : interfaceC4162dQ1.X0(iC8);
                String strX08 = interfaceC4162dQ1.X0(iC9);
                if (interfaceC4162dQ1.isNull(iC10)) {
                    i13 = iC2;
                    i14 = iC3;
                    numValueOf = null;
                } else {
                    i13 = iC2;
                    i14 = iC3;
                    numValueOf = Integer.valueOf((int) interfaceC4162dQ1.getLong(iC10));
                }
                String strX09 = interfaceC4162dQ1.isNull(iC11) ? null : interfaceC4162dQ1.X0(iC11);
                int i19 = (int) interfaceC4162dQ1.getLong(iC12);
                int i20 = (int) interfaceC4162dQ1.getLong(iC13);
                boolean z10 = ((int) interfaceC4162dQ1.getLong(iC14)) != 0;
                int i21 = iC15;
                String strX010 = interfaceC4162dQ1.X0(i21);
                int i22 = iC16;
                String strX011 = interfaceC4162dQ1.isNull(i22) ? null : interfaceC4162dQ1.X0(i22);
                int i23 = iC;
                int i24 = iC17;
                String strX012 = interfaceC4162dQ1.isNull(i24) ? null : interfaceC4162dQ1.X0(i24);
                iC17 = i24;
                int i25 = iC18;
                String strX013 = interfaceC4162dQ1.isNull(i25) ? null : interfaceC4162dQ1.X0(i25);
                iC18 = i25;
                int i26 = iC19;
                String strX014 = interfaceC4162dQ1.isNull(i26) ? null : interfaceC4162dQ1.X0(i26);
                iC19 = i26;
                int i27 = iC20;
                String strX015 = interfaceC4162dQ1.isNull(i27) ? null : interfaceC4162dQ1.X0(i27);
                iC20 = i27;
                int i28 = iC21;
                String strX016 = interfaceC4162dQ1.isNull(i28) ? null : interfaceC4162dQ1.X0(i28);
                iC21 = i28;
                int i29 = iC22;
                String strX017 = interfaceC4162dQ1.isNull(i29) ? null : interfaceC4162dQ1.X0(i29);
                iC22 = i29;
                int i30 = iC23;
                String strX018 = interfaceC4162dQ1.isNull(i30) ? null : interfaceC4162dQ1.X0(i30);
                iC23 = i30;
                int i31 = iC24;
                long j10 = interfaceC4162dQ1.getLong(i31);
                iC24 = i31;
                int i32 = iC25;
                Long lValueOf3 = interfaceC4162dQ1.isNull(i32) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i32));
                iC25 = i32;
                int i33 = iC26;
                Long lValueOf4 = interfaceC4162dQ1.isNull(i33) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i33));
                iC26 = i33;
                int i34 = iC27;
                long j11 = interfaceC4162dQ1.getLong(i34);
                iC27 = i34;
                int i35 = iC28;
                String strX019 = interfaceC4162dQ1.isNull(i35) ? null : interfaceC4162dQ1.X0(i35);
                iC28 = i35;
                int i36 = iC29;
                String strX020 = interfaceC4162dQ1.isNull(i36) ? null : interfaceC4162dQ1.X0(i36);
                iC29 = i36;
                int i37 = iC30;
                String strX021 = interfaceC4162dQ1.isNull(i37) ? null : interfaceC4162dQ1.X0(i37);
                iC30 = i37;
                int i38 = iC31;
                if (interfaceC4162dQ1.isNull(i38)) {
                    strX0 = null;
                    iC31 = i38;
                    i15 = i22;
                } else {
                    strX0 = interfaceC4162dQ1.X0(i38);
                    i15 = i22;
                    iC31 = i38;
                }
                int i39 = iC32;
                boolean z11 = ((int) interfaceC4162dQ1.getLong(i39)) != 0;
                int i40 = iC33;
                String strX022 = interfaceC4162dQ1.isNull(i40) ? null : interfaceC4162dQ1.X0(i40);
                int i41 = iC34;
                Long lValueOf5 = interfaceC4162dQ1.isNull(i41) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i41));
                int i42 = iC35;
                String strX023 = interfaceC4162dQ1.isNull(i42) ? null : interfaceC4162dQ1.X0(i42);
                iC35 = i42;
                int i43 = iC36;
                iC36 = i43;
                arrayList.add(new TaskInfoCardEntity(strX02, strX03, strX04, lValueOf, lValueOf2, strX05, strX06, strX07, strX08, numValueOf, strX09, i19, i20, z10, strX010, strX011, strX012, strX013, strX014, strX015, strX016, strX017, strX018, j10, lValueOf3, lValueOf4, j11, strX019, strX020, strX021, strX0, z11, strX022, lValueOf5, strX023, interfaceC4162dQ1.isNull(i43) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i43))));
                iC = i23;
                iC34 = i41;
                iC15 = i21;
                iC32 = i39;
                iC3 = i14;
                iC16 = i15;
                iC33 = i40;
                iC2 = i13;
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final List l0(String str, String str2, List list, InterfaceC4160b _connection) throws Throwable {
        InterfaceC4162d interfaceC4162d;
        int i10;
        int i11;
        Integer numValueOf;
        String strX0;
        int i12;
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            Iterator it = list.iterator();
            int i13 = 2;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i13, (String) it.next());
                i13++;
            }
            int iC = C4039i.c(interfaceC4162dQ1, "task_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "uid");
            int iC3 = C4039i.c(interfaceC4162dQ1, c.a.COL_EVENT_TYPE);
            int iC4 = C4039i.c(interfaceC4162dQ1, c.a.COL_SEQ);
            int iC5 = C4039i.c(interfaceC4162dQ1, "ts");
            int iC6 = C4039i.c(interfaceC4162dQ1, c.a.COL_SESSION_KEY);
            int iC7 = C4039i.c(interfaceC4162dQ1, c.a.COL_PARENT_TASK_ID);
            int iC8 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASK_IDS_JSON);
            int iC9 = C4039i.c(interfaceC4162dQ1, "type");
            int iC10 = C4039i.c(interfaceC4162dQ1, "version");
            int iC11 = C4039i.c(interfaceC4162dQ1, "version_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "task_version");
            int iC13 = C4039i.c(interfaceC4162dQ1, "active_task_version");
            int iC14 = C4039i.c(interfaceC4162dQ1, "no_task_detail");
            int iC15 = C4039i.c(interfaceC4162dQ1, "status");
            int iC16 = C4039i.c(interfaceC4162dQ1, "title");
            int iC17 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TITLE);
            int iC18 = C4039i.c(interfaceC4162dQ1, "icon_url");
            int iC19 = C4039i.c(interfaceC4162dQ1, c.a.COL_PROGRESS_JSON);
            int iC20 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUMMARY);
            int iC21 = C4039i.c(interfaceC4162dQ1, c.a.COL_REQUEST_SESSION_KEY);
            int iC22 = C4039i.c(interfaceC4162dQ1, c.a.COL_PENDING_QUESTIONS_JSON);
            int iC23 = C4039i.c(interfaceC4162dQ1, "intention");
            int iC24 = C4039i.c(interfaceC4162dQ1, c.a.COL_CREATED_AT);
            int iC25 = C4039i.c(interfaceC4162dQ1, c.a.COL_STARTED_AT);
            int iC26 = C4039i.c(interfaceC4162dQ1, c.a.COL_ENDED_AT);
            int iC27 = C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT);
            int iC28 = C4039i.c(interfaceC4162dQ1, c.a.COL_RESULT_JSON);
            int iC29 = C4039i.c(interfaceC4162dQ1, c.a.COL_EXTENSIONS_JSON);
            int iC30 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASKS_JSON);
            int iC31 = C4039i.c(interfaceC4162dQ1, c.a.COL_ANSWER_JSON);
            int iC32 = C4039i.c(interfaceC4162dQ1, "is_hidden");
            int iC33 = C4039i.c(interfaceC4162dQ1, "notification_dismissed_status");
            int iC34 = C4039i.c(interfaceC4162dQ1, "duration_ms");
            int iC35 = C4039i.c(interfaceC4162dQ1, "answered_question_texts_json");
            int iC36 = C4039i.c(interfaceC4162dQ1, "read_at");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                String strX02 = interfaceC4162dQ1.X0(iC);
                String strX03 = interfaceC4162dQ1.X0(iC2);
                String strX04 = interfaceC4162dQ1.X0(iC3);
                Long lValueOf = interfaceC4162dQ1.isNull(iC4) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC4));
                Long lValueOf2 = interfaceC4162dQ1.isNull(iC5) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC5));
                String strX05 = interfaceC4162dQ1.isNull(iC6) ? null : interfaceC4162dQ1.X0(iC6);
                String strX06 = interfaceC4162dQ1.isNull(iC7) ? null : interfaceC4162dQ1.X0(iC7);
                String strX07 = interfaceC4162dQ1.isNull(iC8) ? null : interfaceC4162dQ1.X0(iC8);
                String strX08 = interfaceC4162dQ1.X0(iC9);
                if (interfaceC4162dQ1.isNull(iC10)) {
                    i10 = iC;
                    i11 = iC2;
                    numValueOf = null;
                } else {
                    i10 = iC;
                    i11 = iC2;
                    numValueOf = Integer.valueOf((int) interfaceC4162dQ1.getLong(iC10));
                }
                String strX09 = interfaceC4162dQ1.isNull(iC11) ? null : interfaceC4162dQ1.X0(iC11);
                int i14 = (int) interfaceC4162dQ1.getLong(iC12);
                int i15 = (int) interfaceC4162dQ1.getLong(iC13);
                boolean z10 = ((int) interfaceC4162dQ1.getLong(iC14)) != 0;
                int i16 = iC15;
                String strX010 = interfaceC4162dQ1.X0(i16);
                int i17 = iC16;
                String strX011 = interfaceC4162dQ1.isNull(i17) ? null : interfaceC4162dQ1.X0(i17);
                int i18 = iC17;
                String strX012 = interfaceC4162dQ1.isNull(i18) ? null : interfaceC4162dQ1.X0(i18);
                iC17 = i18;
                int i19 = iC18;
                String strX013 = interfaceC4162dQ1.isNull(i19) ? null : interfaceC4162dQ1.X0(i19);
                iC18 = i19;
                int i20 = iC19;
                String strX014 = interfaceC4162dQ1.isNull(i20) ? null : interfaceC4162dQ1.X0(i20);
                iC19 = i20;
                int i21 = iC20;
                String strX015 = interfaceC4162dQ1.isNull(i21) ? null : interfaceC4162dQ1.X0(i21);
                iC20 = i21;
                int i22 = iC21;
                String strX016 = interfaceC4162dQ1.isNull(i22) ? null : interfaceC4162dQ1.X0(i22);
                iC21 = i22;
                int i23 = iC22;
                String strX017 = interfaceC4162dQ1.isNull(i23) ? null : interfaceC4162dQ1.X0(i23);
                iC22 = i23;
                int i24 = iC23;
                String strX018 = interfaceC4162dQ1.isNull(i24) ? null : interfaceC4162dQ1.X0(i24);
                iC23 = i24;
                int i25 = iC24;
                long j10 = interfaceC4162dQ1.getLong(i25);
                iC24 = i25;
                int i26 = iC25;
                Long lValueOf3 = interfaceC4162dQ1.isNull(i26) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i26));
                iC25 = i26;
                int i27 = iC26;
                Long lValueOf4 = interfaceC4162dQ1.isNull(i27) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i27));
                iC26 = i27;
                int i28 = iC27;
                long j11 = interfaceC4162dQ1.getLong(i28);
                iC27 = i28;
                int i29 = iC28;
                String strX019 = interfaceC4162dQ1.isNull(i29) ? null : interfaceC4162dQ1.X0(i29);
                iC28 = i29;
                int i30 = iC29;
                String strX020 = interfaceC4162dQ1.isNull(i30) ? null : interfaceC4162dQ1.X0(i30);
                iC29 = i30;
                int i31 = iC30;
                String strX021 = interfaceC4162dQ1.isNull(i31) ? null : interfaceC4162dQ1.X0(i31);
                iC30 = i31;
                int i32 = iC31;
                if (interfaceC4162dQ1.isNull(i32)) {
                    strX0 = null;
                    iC31 = i32;
                    i12 = i17;
                } else {
                    strX0 = interfaceC4162dQ1.X0(i32);
                    i12 = i17;
                    iC31 = i32;
                }
                int i33 = iC32;
                int i34 = iC3;
                boolean z11 = ((int) interfaceC4162dQ1.getLong(i33)) != 0;
                int i35 = iC33;
                String strX022 = interfaceC4162dQ1.isNull(i35) ? null : interfaceC4162dQ1.X0(i35);
                int i36 = iC34;
                Long lValueOf5 = interfaceC4162dQ1.isNull(i36) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i36));
                int i37 = iC35;
                String strX023 = interfaceC4162dQ1.isNull(i37) ? null : interfaceC4162dQ1.X0(i37);
                iC35 = i37;
                int i38 = iC36;
                interfaceC4162d = interfaceC4162dQ1;
                try {
                    arrayList.add(new TaskInfoCardEntity(strX02, strX03, strX04, lValueOf, lValueOf2, strX05, strX06, strX07, strX08, numValueOf, strX09, i14, i15, z10, strX010, strX011, strX012, strX013, strX014, strX015, strX016, strX017, strX018, j10, lValueOf3, lValueOf4, j11, strX019, strX020, strX021, strX0, z11, strX022, lValueOf5, strX023, interfaceC4162dQ1.isNull(i38) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i38))));
                    iC15 = i16;
                    iC36 = i38;
                    interfaceC4162dQ1 = interfaceC4162d;
                    iC = i10;
                    iC16 = i12;
                    iC34 = i36;
                    iC3 = i34;
                    iC32 = i33;
                    iC33 = i35;
                    iC2 = i11;
                } catch (Throwable th) {
                    th = th;
                    interfaceC4162d.close();
                    throw th;
                }
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            interfaceC4162d = interfaceC4162dQ1;
        }
    }

    public static final List m0(String str, String str2, InterfaceC4160b _connection) throws Throwable {
        InterfaceC4162d interfaceC4162d;
        int i10;
        int i11;
        Integer numValueOf;
        String strX0;
        int i12;
        int i13;
        String strX02;
        int i14;
        int i15;
        String strX03;
        int i16;
        int i17;
        String strX04;
        int i18;
        int i19;
        String strX05;
        int i20;
        int i21;
        String strX06;
        int i22;
        int i23;
        String strX07;
        int i24;
        int i25;
        String strX08;
        int i26;
        int i27;
        String strX09;
        int i28;
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, "task_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "uid");
            int iC3 = C4039i.c(interfaceC4162dQ1, c.a.COL_EVENT_TYPE);
            int iC4 = C4039i.c(interfaceC4162dQ1, c.a.COL_SEQ);
            int iC5 = C4039i.c(interfaceC4162dQ1, "ts");
            int iC6 = C4039i.c(interfaceC4162dQ1, c.a.COL_SESSION_KEY);
            int iC7 = C4039i.c(interfaceC4162dQ1, c.a.COL_PARENT_TASK_ID);
            int iC8 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASK_IDS_JSON);
            int iC9 = C4039i.c(interfaceC4162dQ1, "type");
            int iC10 = C4039i.c(interfaceC4162dQ1, "version");
            int iC11 = C4039i.c(interfaceC4162dQ1, "version_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "task_version");
            int iC13 = C4039i.c(interfaceC4162dQ1, "active_task_version");
            int iC14 = C4039i.c(interfaceC4162dQ1, "no_task_detail");
            int iC15 = C4039i.c(interfaceC4162dQ1, "status");
            int iC16 = C4039i.c(interfaceC4162dQ1, "title");
            int iC17 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TITLE);
            int iC18 = C4039i.c(interfaceC4162dQ1, "icon_url");
            int iC19 = C4039i.c(interfaceC4162dQ1, c.a.COL_PROGRESS_JSON);
            int iC20 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUMMARY);
            int iC21 = C4039i.c(interfaceC4162dQ1, c.a.COL_REQUEST_SESSION_KEY);
            int iC22 = C4039i.c(interfaceC4162dQ1, c.a.COL_PENDING_QUESTIONS_JSON);
            int iC23 = C4039i.c(interfaceC4162dQ1, "intention");
            int iC24 = C4039i.c(interfaceC4162dQ1, c.a.COL_CREATED_AT);
            int iC25 = C4039i.c(interfaceC4162dQ1, c.a.COL_STARTED_AT);
            int iC26 = C4039i.c(interfaceC4162dQ1, c.a.COL_ENDED_AT);
            int iC27 = C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT);
            int iC28 = C4039i.c(interfaceC4162dQ1, c.a.COL_RESULT_JSON);
            int iC29 = C4039i.c(interfaceC4162dQ1, c.a.COL_EXTENSIONS_JSON);
            int iC30 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASKS_JSON);
            int iC31 = C4039i.c(interfaceC4162dQ1, c.a.COL_ANSWER_JSON);
            int iC32 = C4039i.c(interfaceC4162dQ1, "is_hidden");
            int iC33 = C4039i.c(interfaceC4162dQ1, "notification_dismissed_status");
            int iC34 = C4039i.c(interfaceC4162dQ1, "duration_ms");
            int iC35 = C4039i.c(interfaceC4162dQ1, "answered_question_texts_json");
            int iC36 = C4039i.c(interfaceC4162dQ1, "read_at");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                String strX010 = interfaceC4162dQ1.X0(iC);
                String strX011 = interfaceC4162dQ1.X0(iC2);
                String strX012 = interfaceC4162dQ1.X0(iC3);
                Long lValueOf = interfaceC4162dQ1.isNull(iC4) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC4));
                Long lValueOf2 = interfaceC4162dQ1.isNull(iC5) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC5));
                String strX013 = interfaceC4162dQ1.isNull(iC6) ? null : interfaceC4162dQ1.X0(iC6);
                String strX014 = interfaceC4162dQ1.isNull(iC7) ? null : interfaceC4162dQ1.X0(iC7);
                String strX015 = interfaceC4162dQ1.isNull(iC8) ? null : interfaceC4162dQ1.X0(iC8);
                String strX016 = interfaceC4162dQ1.X0(iC9);
                if (interfaceC4162dQ1.isNull(iC10)) {
                    i10 = iC;
                    i11 = iC2;
                    numValueOf = null;
                } else {
                    i10 = iC;
                    i11 = iC2;
                    numValueOf = Integer.valueOf((int) interfaceC4162dQ1.getLong(iC10));
                }
                String strX017 = interfaceC4162dQ1.isNull(iC11) ? null : interfaceC4162dQ1.X0(iC11);
                int i29 = (int) interfaceC4162dQ1.getLong(iC12);
                int i30 = (int) interfaceC4162dQ1.getLong(iC13);
                boolean z10 = ((int) interfaceC4162dQ1.getLong(iC14)) != 0;
                int i31 = iC15;
                String strX018 = interfaceC4162dQ1.X0(i31);
                int i32 = iC16;
                if (interfaceC4162dQ1.isNull(i32)) {
                    int i33 = iC17;
                    i12 = i31;
                    i13 = i33;
                    strX0 = null;
                } else {
                    strX0 = interfaceC4162dQ1.X0(i32);
                    int i34 = iC17;
                    i12 = i31;
                    i13 = i34;
                }
                if (interfaceC4162dQ1.isNull(i13)) {
                    int i35 = iC18;
                    i14 = i13;
                    i15 = i35;
                    strX02 = null;
                } else {
                    strX02 = interfaceC4162dQ1.X0(i13);
                    int i36 = iC18;
                    i14 = i13;
                    i15 = i36;
                }
                if (interfaceC4162dQ1.isNull(i15)) {
                    int i37 = iC19;
                    i16 = i15;
                    i17 = i37;
                    strX03 = null;
                } else {
                    strX03 = interfaceC4162dQ1.X0(i15);
                    int i38 = iC19;
                    i16 = i15;
                    i17 = i38;
                }
                if (interfaceC4162dQ1.isNull(i17)) {
                    int i39 = iC20;
                    i18 = i17;
                    i19 = i39;
                    strX04 = null;
                } else {
                    strX04 = interfaceC4162dQ1.X0(i17);
                    int i40 = iC20;
                    i18 = i17;
                    i19 = i40;
                }
                if (interfaceC4162dQ1.isNull(i19)) {
                    int i41 = iC21;
                    i20 = i19;
                    i21 = i41;
                    strX05 = null;
                } else {
                    strX05 = interfaceC4162dQ1.X0(i19);
                    int i42 = iC21;
                    i20 = i19;
                    i21 = i42;
                }
                if (interfaceC4162dQ1.isNull(i21)) {
                    int i43 = iC22;
                    i22 = i21;
                    i23 = i43;
                    strX06 = null;
                } else {
                    strX06 = interfaceC4162dQ1.X0(i21);
                    int i44 = iC22;
                    i22 = i21;
                    i23 = i44;
                }
                if (interfaceC4162dQ1.isNull(i23)) {
                    int i45 = iC23;
                    i24 = i23;
                    i25 = i45;
                    strX07 = null;
                } else {
                    strX07 = interfaceC4162dQ1.X0(i23);
                    int i46 = iC23;
                    i24 = i23;
                    i25 = i46;
                }
                if (interfaceC4162dQ1.isNull(i25)) {
                    int i47 = iC24;
                    i26 = i25;
                    i27 = i47;
                    strX08 = null;
                } else {
                    strX08 = interfaceC4162dQ1.X0(i25);
                    int i48 = iC24;
                    i26 = i25;
                    i27 = i48;
                }
                long j10 = interfaceC4162dQ1.getLong(i27);
                int i49 = i27;
                int i50 = iC25;
                Long lValueOf3 = interfaceC4162dQ1.isNull(i50) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i50));
                iC25 = i50;
                int i51 = iC26;
                Long lValueOf4 = interfaceC4162dQ1.isNull(i51) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i51));
                iC26 = i51;
                int i52 = iC27;
                long j11 = interfaceC4162dQ1.getLong(i52);
                iC27 = i52;
                int i53 = iC28;
                String strX019 = interfaceC4162dQ1.isNull(i53) ? null : interfaceC4162dQ1.X0(i53);
                iC28 = i53;
                int i54 = iC29;
                String strX020 = interfaceC4162dQ1.isNull(i54) ? null : interfaceC4162dQ1.X0(i54);
                iC29 = i54;
                int i55 = iC30;
                String strX021 = interfaceC4162dQ1.isNull(i55) ? null : interfaceC4162dQ1.X0(i55);
                iC30 = i55;
                int i56 = iC31;
                if (interfaceC4162dQ1.isNull(i56)) {
                    strX09 = null;
                    iC31 = i56;
                    i28 = i32;
                } else {
                    strX09 = interfaceC4162dQ1.X0(i56);
                    i28 = i32;
                    iC31 = i56;
                }
                int i57 = iC32;
                int i58 = iC3;
                boolean z11 = ((int) interfaceC4162dQ1.getLong(i57)) != 0;
                int i59 = iC33;
                String strX022 = interfaceC4162dQ1.isNull(i59) ? null : interfaceC4162dQ1.X0(i59);
                int i60 = iC34;
                Long lValueOf5 = interfaceC4162dQ1.isNull(i60) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i60));
                int i61 = iC35;
                String strX023 = interfaceC4162dQ1.isNull(i61) ? null : interfaceC4162dQ1.X0(i61);
                iC35 = i61;
                int i62 = iC36;
                interfaceC4162d = interfaceC4162dQ1;
                try {
                    arrayList.add(new TaskInfoCardEntity(strX010, strX011, strX012, lValueOf, lValueOf2, strX013, strX014, strX015, strX016, numValueOf, strX017, i29, i30, z10, strX018, strX0, strX02, strX03, strX04, strX05, strX06, strX07, strX08, j10, lValueOf3, lValueOf4, j11, strX019, strX020, strX021, strX09, z11, strX022, lValueOf5, strX023, interfaceC4162dQ1.isNull(i62) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i62))));
                    iC36 = i62;
                    iC15 = i12;
                    iC17 = i14;
                    iC18 = i16;
                    iC19 = i18;
                    iC20 = i20;
                    iC21 = i22;
                    iC22 = i24;
                    iC23 = i26;
                    interfaceC4162dQ1 = interfaceC4162d;
                    iC = i10;
                    iC24 = i49;
                    iC34 = i60;
                    iC3 = i58;
                    iC32 = i57;
                    iC16 = i28;
                    iC33 = i59;
                    iC2 = i11;
                } catch (Throwable th) {
                    th = th;
                    interfaceC4162d.close();
                    throw th;
                }
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            interfaceC4162d = interfaceC4162dQ1;
        }
    }

    public static final List n0(String str, String str2, List list, int i10, InterfaceC4160b _connection) throws Throwable {
        InterfaceC4162d interfaceC4162d;
        int i11;
        int i12;
        Integer numValueOf;
        String strX0;
        int i13;
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            Iterator it = list.iterator();
            int i14 = 2;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i14, (String) it.next());
                i14++;
            }
            int i15 = i10 + 2;
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                interfaceC4162dQ1.H(i15, (String) it2.next());
                i15++;
            }
            int iC = C4039i.c(interfaceC4162dQ1, "task_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "uid");
            int iC3 = C4039i.c(interfaceC4162dQ1, c.a.COL_EVENT_TYPE);
            int iC4 = C4039i.c(interfaceC4162dQ1, c.a.COL_SEQ);
            int iC5 = C4039i.c(interfaceC4162dQ1, "ts");
            int iC6 = C4039i.c(interfaceC4162dQ1, c.a.COL_SESSION_KEY);
            int iC7 = C4039i.c(interfaceC4162dQ1, c.a.COL_PARENT_TASK_ID);
            int iC8 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASK_IDS_JSON);
            int iC9 = C4039i.c(interfaceC4162dQ1, "type");
            int iC10 = C4039i.c(interfaceC4162dQ1, "version");
            int iC11 = C4039i.c(interfaceC4162dQ1, "version_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "task_version");
            int iC13 = C4039i.c(interfaceC4162dQ1, "active_task_version");
            int iC14 = C4039i.c(interfaceC4162dQ1, "no_task_detail");
            int iC15 = C4039i.c(interfaceC4162dQ1, "status");
            int iC16 = C4039i.c(interfaceC4162dQ1, "title");
            int iC17 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TITLE);
            int iC18 = C4039i.c(interfaceC4162dQ1, "icon_url");
            int iC19 = C4039i.c(interfaceC4162dQ1, c.a.COL_PROGRESS_JSON);
            int iC20 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUMMARY);
            int iC21 = C4039i.c(interfaceC4162dQ1, c.a.COL_REQUEST_SESSION_KEY);
            int iC22 = C4039i.c(interfaceC4162dQ1, c.a.COL_PENDING_QUESTIONS_JSON);
            int iC23 = C4039i.c(interfaceC4162dQ1, "intention");
            int iC24 = C4039i.c(interfaceC4162dQ1, c.a.COL_CREATED_AT);
            int iC25 = C4039i.c(interfaceC4162dQ1, c.a.COL_STARTED_AT);
            int iC26 = C4039i.c(interfaceC4162dQ1, c.a.COL_ENDED_AT);
            int iC27 = C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT);
            int iC28 = C4039i.c(interfaceC4162dQ1, c.a.COL_RESULT_JSON);
            int iC29 = C4039i.c(interfaceC4162dQ1, c.a.COL_EXTENSIONS_JSON);
            int iC30 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASKS_JSON);
            int iC31 = C4039i.c(interfaceC4162dQ1, c.a.COL_ANSWER_JSON);
            int iC32 = C4039i.c(interfaceC4162dQ1, "is_hidden");
            int iC33 = C4039i.c(interfaceC4162dQ1, "notification_dismissed_status");
            int iC34 = C4039i.c(interfaceC4162dQ1, "duration_ms");
            int iC35 = C4039i.c(interfaceC4162dQ1, "answered_question_texts_json");
            int iC36 = C4039i.c(interfaceC4162dQ1, "read_at");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                String strX02 = interfaceC4162dQ1.X0(iC);
                String strX03 = interfaceC4162dQ1.X0(iC2);
                String strX04 = interfaceC4162dQ1.X0(iC3);
                Long lValueOf = interfaceC4162dQ1.isNull(iC4) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC4));
                Long lValueOf2 = interfaceC4162dQ1.isNull(iC5) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC5));
                String strX05 = interfaceC4162dQ1.isNull(iC6) ? null : interfaceC4162dQ1.X0(iC6);
                String strX06 = interfaceC4162dQ1.isNull(iC7) ? null : interfaceC4162dQ1.X0(iC7);
                String strX07 = interfaceC4162dQ1.isNull(iC8) ? null : interfaceC4162dQ1.X0(iC8);
                String strX08 = interfaceC4162dQ1.X0(iC9);
                if (interfaceC4162dQ1.isNull(iC10)) {
                    i11 = iC;
                    i12 = iC2;
                    numValueOf = null;
                } else {
                    i11 = iC;
                    i12 = iC2;
                    numValueOf = Integer.valueOf((int) interfaceC4162dQ1.getLong(iC10));
                }
                String strX09 = interfaceC4162dQ1.isNull(iC11) ? null : interfaceC4162dQ1.X0(iC11);
                int i16 = (int) interfaceC4162dQ1.getLong(iC12);
                int i17 = (int) interfaceC4162dQ1.getLong(iC13);
                boolean z10 = ((int) interfaceC4162dQ1.getLong(iC14)) != 0;
                int i18 = iC15;
                String strX010 = interfaceC4162dQ1.X0(i18);
                int i19 = iC16;
                String strX011 = interfaceC4162dQ1.isNull(i19) ? null : interfaceC4162dQ1.X0(i19);
                int i20 = iC17;
                String strX012 = interfaceC4162dQ1.isNull(i20) ? null : interfaceC4162dQ1.X0(i20);
                iC17 = i20;
                int i21 = iC18;
                String strX013 = interfaceC4162dQ1.isNull(i21) ? null : interfaceC4162dQ1.X0(i21);
                iC18 = i21;
                int i22 = iC19;
                String strX014 = interfaceC4162dQ1.isNull(i22) ? null : interfaceC4162dQ1.X0(i22);
                iC19 = i22;
                int i23 = iC20;
                String strX015 = interfaceC4162dQ1.isNull(i23) ? null : interfaceC4162dQ1.X0(i23);
                iC20 = i23;
                int i24 = iC21;
                String strX016 = interfaceC4162dQ1.isNull(i24) ? null : interfaceC4162dQ1.X0(i24);
                iC21 = i24;
                int i25 = iC22;
                String strX017 = interfaceC4162dQ1.isNull(i25) ? null : interfaceC4162dQ1.X0(i25);
                iC22 = i25;
                int i26 = iC23;
                String strX018 = interfaceC4162dQ1.isNull(i26) ? null : interfaceC4162dQ1.X0(i26);
                iC23 = i26;
                int i27 = iC24;
                long j10 = interfaceC4162dQ1.getLong(i27);
                iC24 = i27;
                int i28 = iC25;
                Long lValueOf3 = interfaceC4162dQ1.isNull(i28) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i28));
                iC25 = i28;
                int i29 = iC26;
                Long lValueOf4 = interfaceC4162dQ1.isNull(i29) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i29));
                iC26 = i29;
                int i30 = iC27;
                long j11 = interfaceC4162dQ1.getLong(i30);
                iC27 = i30;
                int i31 = iC28;
                String strX019 = interfaceC4162dQ1.isNull(i31) ? null : interfaceC4162dQ1.X0(i31);
                iC28 = i31;
                int i32 = iC29;
                String strX020 = interfaceC4162dQ1.isNull(i32) ? null : interfaceC4162dQ1.X0(i32);
                iC29 = i32;
                int i33 = iC30;
                String strX021 = interfaceC4162dQ1.isNull(i33) ? null : interfaceC4162dQ1.X0(i33);
                iC30 = i33;
                int i34 = iC31;
                if (interfaceC4162dQ1.isNull(i34)) {
                    strX0 = null;
                    iC31 = i34;
                    i13 = i19;
                } else {
                    strX0 = interfaceC4162dQ1.X0(i34);
                    i13 = i19;
                    iC31 = i34;
                }
                int i35 = iC32;
                int i36 = iC3;
                boolean z11 = ((int) interfaceC4162dQ1.getLong(i35)) != 0;
                int i37 = iC33;
                String strX022 = interfaceC4162dQ1.isNull(i37) ? null : interfaceC4162dQ1.X0(i37);
                int i38 = iC34;
                Long lValueOf5 = interfaceC4162dQ1.isNull(i38) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i38));
                int i39 = iC35;
                String strX023 = interfaceC4162dQ1.isNull(i39) ? null : interfaceC4162dQ1.X0(i39);
                iC35 = i39;
                int i40 = iC36;
                interfaceC4162d = interfaceC4162dQ1;
                try {
                    arrayList.add(new TaskInfoCardEntity(strX02, strX03, strX04, lValueOf, lValueOf2, strX05, strX06, strX07, strX08, numValueOf, strX09, i16, i17, z10, strX010, strX011, strX012, strX013, strX014, strX015, strX016, strX017, strX018, j10, lValueOf3, lValueOf4, j11, strX019, strX020, strX021, strX0, z11, strX022, lValueOf5, strX023, interfaceC4162dQ1.isNull(i40) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i40))));
                    iC15 = i18;
                    iC36 = i40;
                    interfaceC4162dQ1 = interfaceC4162d;
                    iC = i11;
                    iC16 = i13;
                    iC34 = i38;
                    iC3 = i36;
                    iC32 = i35;
                    iC33 = i37;
                    iC2 = i12;
                } catch (Throwable th) {
                    th = th;
                    interfaceC4162d.close();
                    throw th;
                }
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            interfaceC4162d = interfaceC4162dQ1;
        }
    }

    public static final TaskInfoCardEntity o0(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, "task_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "uid");
            int iC3 = C4039i.c(interfaceC4162dQ1, c.a.COL_EVENT_TYPE);
            int iC4 = C4039i.c(interfaceC4162dQ1, c.a.COL_SEQ);
            int iC5 = C4039i.c(interfaceC4162dQ1, "ts");
            int iC6 = C4039i.c(interfaceC4162dQ1, c.a.COL_SESSION_KEY);
            int iC7 = C4039i.c(interfaceC4162dQ1, c.a.COL_PARENT_TASK_ID);
            int iC8 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASK_IDS_JSON);
            int iC9 = C4039i.c(interfaceC4162dQ1, "type");
            int iC10 = C4039i.c(interfaceC4162dQ1, "version");
            int iC11 = C4039i.c(interfaceC4162dQ1, "version_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "task_version");
            int iC13 = C4039i.c(interfaceC4162dQ1, "active_task_version");
            int iC14 = C4039i.c(interfaceC4162dQ1, "no_task_detail");
            int iC15 = C4039i.c(interfaceC4162dQ1, "status");
            int iC16 = C4039i.c(interfaceC4162dQ1, "title");
            int iC17 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TITLE);
            int iC18 = C4039i.c(interfaceC4162dQ1, "icon_url");
            int iC19 = C4039i.c(interfaceC4162dQ1, c.a.COL_PROGRESS_JSON);
            int iC20 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUMMARY);
            int iC21 = C4039i.c(interfaceC4162dQ1, c.a.COL_REQUEST_SESSION_KEY);
            int iC22 = C4039i.c(interfaceC4162dQ1, c.a.COL_PENDING_QUESTIONS_JSON);
            int iC23 = C4039i.c(interfaceC4162dQ1, "intention");
            int iC24 = C4039i.c(interfaceC4162dQ1, c.a.COL_CREATED_AT);
            int iC25 = C4039i.c(interfaceC4162dQ1, c.a.COL_STARTED_AT);
            int iC26 = C4039i.c(interfaceC4162dQ1, c.a.COL_ENDED_AT);
            int iC27 = C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT);
            int iC28 = C4039i.c(interfaceC4162dQ1, c.a.COL_RESULT_JSON);
            int iC29 = C4039i.c(interfaceC4162dQ1, c.a.COL_EXTENSIONS_JSON);
            int iC30 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASKS_JSON);
            int iC31 = C4039i.c(interfaceC4162dQ1, c.a.COL_ANSWER_JSON);
            int iC32 = C4039i.c(interfaceC4162dQ1, "is_hidden");
            int iC33 = C4039i.c(interfaceC4162dQ1, "notification_dismissed_status");
            int iC34 = C4039i.c(interfaceC4162dQ1, "duration_ms");
            int iC35 = C4039i.c(interfaceC4162dQ1, "answered_question_texts_json");
            int iC36 = C4039i.c(interfaceC4162dQ1, "read_at");
            TaskInfoCardEntity taskInfoCardEntity = null;
            if (interfaceC4162dQ1.n1()) {
                taskInfoCardEntity = new TaskInfoCardEntity(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.isNull(iC4) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC4)), interfaceC4162dQ1.isNull(iC5) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC5)), interfaceC4162dQ1.isNull(iC6) ? null : interfaceC4162dQ1.X0(iC6), interfaceC4162dQ1.isNull(iC7) ? null : interfaceC4162dQ1.X0(iC7), interfaceC4162dQ1.isNull(iC8) ? null : interfaceC4162dQ1.X0(iC8), interfaceC4162dQ1.X0(iC9), interfaceC4162dQ1.isNull(iC10) ? null : Integer.valueOf((int) interfaceC4162dQ1.getLong(iC10)), interfaceC4162dQ1.isNull(iC11) ? null : interfaceC4162dQ1.X0(iC11), (int) interfaceC4162dQ1.getLong(iC12), (int) interfaceC4162dQ1.getLong(iC13), ((int) interfaceC4162dQ1.getLong(iC14)) != 0, interfaceC4162dQ1.X0(iC15), interfaceC4162dQ1.isNull(iC16) ? null : interfaceC4162dQ1.X0(iC16), interfaceC4162dQ1.isNull(iC17) ? null : interfaceC4162dQ1.X0(iC17), interfaceC4162dQ1.isNull(iC18) ? null : interfaceC4162dQ1.X0(iC18), interfaceC4162dQ1.isNull(iC19) ? null : interfaceC4162dQ1.X0(iC19), interfaceC4162dQ1.isNull(iC20) ? null : interfaceC4162dQ1.X0(iC20), interfaceC4162dQ1.isNull(iC21) ? null : interfaceC4162dQ1.X0(iC21), interfaceC4162dQ1.isNull(iC22) ? null : interfaceC4162dQ1.X0(iC22), interfaceC4162dQ1.isNull(iC23) ? null : interfaceC4162dQ1.X0(iC23), interfaceC4162dQ1.getLong(iC24), interfaceC4162dQ1.isNull(iC25) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC25)), interfaceC4162dQ1.isNull(iC26) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC26)), interfaceC4162dQ1.getLong(iC27), interfaceC4162dQ1.isNull(iC28) ? null : interfaceC4162dQ1.X0(iC28), interfaceC4162dQ1.isNull(iC29) ? null : interfaceC4162dQ1.X0(iC29), interfaceC4162dQ1.isNull(iC30) ? null : interfaceC4162dQ1.X0(iC30), interfaceC4162dQ1.isNull(iC31) ? null : interfaceC4162dQ1.X0(iC31), ((int) interfaceC4162dQ1.getLong(iC32)) != 0, interfaceC4162dQ1.isNull(iC33) ? null : interfaceC4162dQ1.X0(iC33), interfaceC4162dQ1.isNull(iC34) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC34)), interfaceC4162dQ1.isNull(iC35) ? null : interfaceC4162dQ1.X0(iC35), interfaceC4162dQ1.isNull(iC36) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC36)));
            }
            return taskInfoCardEntity;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List p0(String str, String str2, String str3, InterfaceC4160b _connection) throws Throwable {
        InterfaceC4162d interfaceC4162d;
        int i10;
        int i11;
        Integer numValueOf;
        String strX0;
        int i12;
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.H(2, str3);
            int iC = C4039i.c(interfaceC4162dQ1, "task_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "uid");
            int iC3 = C4039i.c(interfaceC4162dQ1, c.a.COL_EVENT_TYPE);
            int iC4 = C4039i.c(interfaceC4162dQ1, c.a.COL_SEQ);
            int iC5 = C4039i.c(interfaceC4162dQ1, "ts");
            int iC6 = C4039i.c(interfaceC4162dQ1, c.a.COL_SESSION_KEY);
            int iC7 = C4039i.c(interfaceC4162dQ1, c.a.COL_PARENT_TASK_ID);
            int iC8 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASK_IDS_JSON);
            int iC9 = C4039i.c(interfaceC4162dQ1, "type");
            int iC10 = C4039i.c(interfaceC4162dQ1, "version");
            int iC11 = C4039i.c(interfaceC4162dQ1, "version_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "task_version");
            int iC13 = C4039i.c(interfaceC4162dQ1, "active_task_version");
            int iC14 = C4039i.c(interfaceC4162dQ1, "no_task_detail");
            int iC15 = C4039i.c(interfaceC4162dQ1, "status");
            int iC16 = C4039i.c(interfaceC4162dQ1, "title");
            int iC17 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TITLE);
            int iC18 = C4039i.c(interfaceC4162dQ1, "icon_url");
            int iC19 = C4039i.c(interfaceC4162dQ1, c.a.COL_PROGRESS_JSON);
            int iC20 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUMMARY);
            int iC21 = C4039i.c(interfaceC4162dQ1, c.a.COL_REQUEST_SESSION_KEY);
            int iC22 = C4039i.c(interfaceC4162dQ1, c.a.COL_PENDING_QUESTIONS_JSON);
            int iC23 = C4039i.c(interfaceC4162dQ1, "intention");
            int iC24 = C4039i.c(interfaceC4162dQ1, c.a.COL_CREATED_AT);
            int iC25 = C4039i.c(interfaceC4162dQ1, c.a.COL_STARTED_AT);
            int iC26 = C4039i.c(interfaceC4162dQ1, c.a.COL_ENDED_AT);
            int iC27 = C4039i.c(interfaceC4162dQ1, c.a.COL_UPDATED_AT);
            int iC28 = C4039i.c(interfaceC4162dQ1, c.a.COL_RESULT_JSON);
            int iC29 = C4039i.c(interfaceC4162dQ1, c.a.COL_EXTENSIONS_JSON);
            int iC30 = C4039i.c(interfaceC4162dQ1, c.a.COL_SUB_TASKS_JSON);
            int iC31 = C4039i.c(interfaceC4162dQ1, c.a.COL_ANSWER_JSON);
            int iC32 = C4039i.c(interfaceC4162dQ1, "is_hidden");
            int iC33 = C4039i.c(interfaceC4162dQ1, "notification_dismissed_status");
            int iC34 = C4039i.c(interfaceC4162dQ1, "duration_ms");
            int iC35 = C4039i.c(interfaceC4162dQ1, "answered_question_texts_json");
            int iC36 = C4039i.c(interfaceC4162dQ1, "read_at");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                String strX02 = interfaceC4162dQ1.X0(iC);
                String strX03 = interfaceC4162dQ1.X0(iC2);
                String strX04 = interfaceC4162dQ1.X0(iC3);
                Long lValueOf = interfaceC4162dQ1.isNull(iC4) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC4));
                Long lValueOf2 = interfaceC4162dQ1.isNull(iC5) ? null : Long.valueOf(interfaceC4162dQ1.getLong(iC5));
                String strX05 = interfaceC4162dQ1.isNull(iC6) ? null : interfaceC4162dQ1.X0(iC6);
                String strX06 = interfaceC4162dQ1.isNull(iC7) ? null : interfaceC4162dQ1.X0(iC7);
                String strX07 = interfaceC4162dQ1.isNull(iC8) ? null : interfaceC4162dQ1.X0(iC8);
                String strX08 = interfaceC4162dQ1.X0(iC9);
                if (interfaceC4162dQ1.isNull(iC10)) {
                    i10 = iC;
                    i11 = iC2;
                    numValueOf = null;
                } else {
                    i10 = iC;
                    i11 = iC2;
                    numValueOf = Integer.valueOf((int) interfaceC4162dQ1.getLong(iC10));
                }
                String strX09 = interfaceC4162dQ1.isNull(iC11) ? null : interfaceC4162dQ1.X0(iC11);
                int i13 = (int) interfaceC4162dQ1.getLong(iC12);
                int i14 = (int) interfaceC4162dQ1.getLong(iC13);
                boolean z10 = ((int) interfaceC4162dQ1.getLong(iC14)) != 0;
                int i15 = iC15;
                String strX010 = interfaceC4162dQ1.X0(i15);
                int i16 = iC16;
                String strX011 = interfaceC4162dQ1.isNull(i16) ? null : interfaceC4162dQ1.X0(i16);
                int i17 = iC17;
                String strX012 = interfaceC4162dQ1.isNull(i17) ? null : interfaceC4162dQ1.X0(i17);
                iC17 = i17;
                int i18 = iC18;
                String strX013 = interfaceC4162dQ1.isNull(i18) ? null : interfaceC4162dQ1.X0(i18);
                iC18 = i18;
                int i19 = iC19;
                String strX014 = interfaceC4162dQ1.isNull(i19) ? null : interfaceC4162dQ1.X0(i19);
                iC19 = i19;
                int i20 = iC20;
                String strX015 = interfaceC4162dQ1.isNull(i20) ? null : interfaceC4162dQ1.X0(i20);
                iC20 = i20;
                int i21 = iC21;
                String strX016 = interfaceC4162dQ1.isNull(i21) ? null : interfaceC4162dQ1.X0(i21);
                iC21 = i21;
                int i22 = iC22;
                String strX017 = interfaceC4162dQ1.isNull(i22) ? null : interfaceC4162dQ1.X0(i22);
                iC22 = i22;
                int i23 = iC23;
                String strX018 = interfaceC4162dQ1.isNull(i23) ? null : interfaceC4162dQ1.X0(i23);
                iC23 = i23;
                int i24 = iC24;
                long j10 = interfaceC4162dQ1.getLong(i24);
                iC24 = i24;
                int i25 = iC25;
                Long lValueOf3 = interfaceC4162dQ1.isNull(i25) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i25));
                iC25 = i25;
                int i26 = iC26;
                Long lValueOf4 = interfaceC4162dQ1.isNull(i26) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i26));
                iC26 = i26;
                int i27 = iC27;
                long j11 = interfaceC4162dQ1.getLong(i27);
                iC27 = i27;
                int i28 = iC28;
                String strX019 = interfaceC4162dQ1.isNull(i28) ? null : interfaceC4162dQ1.X0(i28);
                iC28 = i28;
                int i29 = iC29;
                String strX020 = interfaceC4162dQ1.isNull(i29) ? null : interfaceC4162dQ1.X0(i29);
                iC29 = i29;
                int i30 = iC30;
                String strX021 = interfaceC4162dQ1.isNull(i30) ? null : interfaceC4162dQ1.X0(i30);
                iC30 = i30;
                int i31 = iC31;
                if (interfaceC4162dQ1.isNull(i31)) {
                    strX0 = null;
                    iC31 = i31;
                    i12 = i16;
                } else {
                    strX0 = interfaceC4162dQ1.X0(i31);
                    i12 = i16;
                    iC31 = i31;
                }
                int i32 = iC32;
                int i33 = iC3;
                boolean z11 = ((int) interfaceC4162dQ1.getLong(i32)) != 0;
                int i34 = iC33;
                String strX022 = interfaceC4162dQ1.isNull(i34) ? null : interfaceC4162dQ1.X0(i34);
                int i35 = iC34;
                Long lValueOf5 = interfaceC4162dQ1.isNull(i35) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i35));
                int i36 = iC35;
                String strX023 = interfaceC4162dQ1.isNull(i36) ? null : interfaceC4162dQ1.X0(i36);
                iC35 = i36;
                int i37 = iC36;
                interfaceC4162d = interfaceC4162dQ1;
                try {
                    arrayList.add(new TaskInfoCardEntity(strX02, strX03, strX04, lValueOf, lValueOf2, strX05, strX06, strX07, strX08, numValueOf, strX09, i13, i14, z10, strX010, strX011, strX012, strX013, strX014, strX015, strX016, strX017, strX018, j10, lValueOf3, lValueOf4, j11, strX019, strX020, strX021, strX0, z11, strX022, lValueOf5, strX023, interfaceC4162dQ1.isNull(i37) ? null : Long.valueOf(interfaceC4162dQ1.getLong(i37))));
                    iC15 = i15;
                    iC36 = i37;
                    interfaceC4162dQ1 = interfaceC4162d;
                    iC = i10;
                    iC16 = i12;
                    iC34 = i35;
                    iC3 = i33;
                    iC32 = i32;
                    iC33 = i34;
                    iC2 = i11;
                } catch (Throwable th) {
                    th = th;
                    interfaceC4162d.close();
                    throw th;
                }
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            interfaceC4162d = interfaceC4162dQ1;
        }
    }

    public static final int q0(String str, String str2, String str3, String str4, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.H(2, str3);
            interfaceC4162dQ1.H(3, str2);
            interfaceC4162dQ1.H(4, str3);
            interfaceC4162dQ1.H(5, str4);
            interfaceC4162dQ1.H(6, str2);
            interfaceC4162dQ1.H(7, str2);
            interfaceC4162dQ1.n1();
            return C4038h.b(_connection);
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final int r0(String str, String str2, String str3, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            if (str2 == null) {
                interfaceC4162dQ1.bindNull(1);
            } else {
                interfaceC4162dQ1.H(1, str2);
            }
            interfaceC4162dQ1.H(2, str3);
            interfaceC4162dQ1.n1();
            int iB = C4038h.b(_connection);
            interfaceC4162dQ1.close();
            return iB;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final int s0(String str, boolean z10, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, z10 ? 1L : 0L);
            interfaceC4162dQ1.H(2, str2);
            interfaceC4162dQ1.n1();
            return C4038h.b(_connection);
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final int t0(String str, String str2, String str3, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            if (str2 == null) {
                interfaceC4162dQ1.bindNull(1);
            } else {
                interfaceC4162dQ1.H(1, str2);
            }
            interfaceC4162dQ1.H(2, str3);
            interfaceC4162dQ1.n1();
            int iB = C4038h.b(_connection);
            interfaceC4162dQ1.close();
            return iB;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object A(final List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM task_subtask_snapshots WHERE task_id IN (");
        C4043m.a(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(TaskInfoCardDao_Impl.f0(string, list, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object a(final String str, final long j10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        final String str2 = "UPDATE task_info SET read_at = ? WHERE task_id = ? AND read_at IS NULL";
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(TaskInfoCardDao_Impl.h0(str2, j10, str, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Xa.b<TaskInfoCardEntity> b(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        final String str = "SELECT * FROM task_info WHERE task_id = ? LIMIT 1";
        return FlowUtil.a(this.__db, false, new String[]{c.a.TABLE}, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardDao_Impl.j0(str, taskId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object c(final String str, InterfaceC4014c<? super Integer> interfaceC4014c) {
        final String str2 = "UPDATE task_info SET uid = ? WHERE uid = ''";
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(TaskInfoCardDao_Impl.a0(str2, str, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object d(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        final String str = "DELETE FROM task_info";
        Object objE = C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardDao_Impl.b0(str, (InterfaceC4160b) obj);
            }
        }, interfaceC4014c);
        return objE == C4063a.g() ? objE : Y8.t.f7040a;
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object e(List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C4031a.d(this.__db, new TaskInfoCardDao_Impl$deleteTaskData$2(this, list, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Xa.b<List<TaskInfoCardEntity>> g(final String uid, final List<String> activeExcludedStatuses, final List<String> terminalStatuses, final int terminalLimit) {
        kotlin.jvm.internal.p.i(uid, "uid");
        kotlin.jvm.internal.p.i(activeExcludedStatuses, "activeExcludedStatuses");
        kotlin.jvm.internal.p.i(terminalStatuses, "terminalStatuses");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM task_info WHERE uid = ");
        sb2.append("?");
        sb2.append(" AND (parent_task_id IS NULL OR parent_task_id = '') AND is_hidden = 0 AND status NOT IN (");
        final int size = activeExcludedStatuses.size();
        C4043m.a(sb2, size);
        sb2.append(") UNION ALL SELECT * FROM (SELECT * FROM task_info WHERE uid = ");
        sb2.append("?");
        sb2.append(" AND (parent_task_id IS NULL OR parent_task_id = '') AND is_hidden = 0 AND status IN (");
        final int size2 = terminalStatuses.size();
        C4043m.a(sb2, size2);
        sb2.append(") ORDER BY updated_at DESC LIMIT ");
        sb2.append("?");
        sb2.append(") ORDER BY created_at ASC");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return FlowUtil.a(this.__db, false, new String[]{c.a.TABLE}, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardDao_Impl.k0(string, uid, activeExcludedStatuses, size, terminalStatuses, size2, terminalLimit, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object h(final List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM task_info WHERE task_id IN (");
        C4043m.a(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(TaskInfoCardDao_Impl.c0(string, list, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object i(final String str, InterfaceC4014c<? super Long> interfaceC4014c) {
        final String str2 = "SELECT MAX(updated_at) FROM task_info WHERE uid = ?";
        return C4031a.e(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardDao_Impl.i0(str2, str, (InterfaceC4160b) obj);
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object j(final String str, final String str2, InterfaceC4014c<? super Integer> interfaceC4014c) {
        final String str3 = "UPDATE task_info SET answered_question_texts_json = ? WHERE task_id = ?";
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(TaskInfoCardDao_Impl.r0(str3, str2, str, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object k(TaskInfoCardEntity taskInfoCardEntity, InterfaceC4014c<? super TaskInfoCardUpsertResult> interfaceC4014c) {
        return C4031a.d(this.__db, new TaskInfoCardDao_Impl$upsertWithResult$2(this, taskInfoCardEntity, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object l(final String str, InterfaceC4014c<? super TaskInfoCardEntity> interfaceC4014c) {
        final String str2 = "SELECT * FROM task_info WHERE task_id = ? LIMIT 1";
        return C4031a.e(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardDao_Impl.o0(str2, str, (InterfaceC4160b) obj);
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object m(final List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM downloaded_artifacts WHERE task_id IN (");
        C4043m.a(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(TaskInfoCardDao_Impl.d0(string, list, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object n(final TaskInfoCardEntity taskInfoCardEntity, InterfaceC4014c<? super Long> interfaceC4014c) {
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Long.valueOf(TaskInfoCardDao_Impl.g0(this.f29229a, taskInfoCardEntity, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object o(final String str, final List<String> list, InterfaceC4014c<? super List<TaskInfoCardEntity>> interfaceC4014c) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM task_info WHERE uid = ");
        sb2.append("?");
        sb2.append(" AND status NOT IN (");
        C4043m.a(sb2, list.size());
        sb2.append(") ORDER BY created_at ASC");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return C4031a.e(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardDao_Impl.l0(string, str, list, (InterfaceC4160b) obj);
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object q(final List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM task_result_snapshots WHERE task_id IN (");
        C4043m.a(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(TaskInfoCardDao_Impl.e0(string, list, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object r(TaskInfoCardEntity taskInfoCardEntity, InterfaceC4014c<? super TaskInfoCardUpsertOutcome> interfaceC4014c) {
        return C4031a.d(this.__db, new TaskInfoCardDao_Impl$upsertWithOutcome$2(this, taskInfoCardEntity, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object s(final String str, final boolean z10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        final String str2 = "UPDATE task_info SET is_hidden = ? WHERE task_id = ?";
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(TaskInfoCardDao_Impl.s0(str2, z10, str, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object t(final String str, final String str2, InterfaceC4014c<? super List<TaskInfoCardEntity>> interfaceC4014c) {
        final String str3 = "SELECT * FROM task_info WHERE uid = ? AND parent_task_id = ? ORDER BY created_at ASC";
        return C4031a.e(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardDao_Impl.p0(str3, str, str2, (InterfaceC4160b) obj);
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object u(final String str, final String str2, InterfaceC4014c<? super Integer> interfaceC4014c) {
        final String str3 = "UPDATE task_info SET notification_dismissed_status = ? WHERE task_id = ?";
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(TaskInfoCardDao_Impl.t0(str3, str2, str, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object w(final String str, final List<String> list, InterfaceC4014c<? super List<TaskInfoCardEntity>> interfaceC4014c) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM task_info WHERE uid = ");
        sb2.append("?");
        sb2.append(" AND (session_key IN (");
        final int size = list.size();
        C4043m.a(sb2, size);
        sb2.append(") OR request_session_key IN (");
        C4043m.a(sb2, list.size());
        sb2.append(")) ORDER BY created_at ASC");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return C4031a.e(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardDao_Impl.n0(string, str, list, size, (InterfaceC4160b) obj);
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object x(final String str, final String str2, final String str3, InterfaceC4014c<? super Integer> interfaceC4014c) {
        final String str4 = "UPDATE task_info SET session_key = CASE WHEN session_key = ? THEN ? ELSE session_key END, request_session_key = CASE WHEN request_session_key = ? THEN ? ELSE request_session_key END WHERE uid = ? AND (session_key = ? OR request_session_key = ?)";
        return C4031a.e(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(TaskInfoCardDao_Impl.q0(str4, str2, str3, str, (InterfaceC4160b) obj));
            }
        }, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object y(TaskInfoCardEntity taskInfoCardEntity, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4031a.d(this.__db, new TaskInfoCardDao_Impl$upsert$2(this, taskInfoCardEntity, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao
    public Object z(final String str, InterfaceC4014c<? super List<TaskInfoCardEntity>> interfaceC4014c) {
        final String str2 = "SELECT * FROM task_info WHERE uid = ? ORDER BY created_at ASC";
        return C4031a.e(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.dao.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardDao_Impl.m0(str2, str, (InterfaceC4160b) obj);
            }
        }, interfaceC4014c);
    }
}
