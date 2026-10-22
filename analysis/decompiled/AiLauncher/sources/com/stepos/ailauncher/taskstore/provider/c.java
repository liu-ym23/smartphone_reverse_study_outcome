package com.stepos.ailauncher.taskstore.provider;

import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/provider/c;", "", "<init>", "()V", "", "AUTHORITY", "Ljava/lang/String;", "PERMISSION_ACCESS_TASK_INFO", "Landroid/net/Uri;", "AUTHORITY_URI", "Landroid/net/Uri;", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final String AUTHORITY = "com.stepos.ailauncher.taskstore.provider";
    public static final Uri AUTHORITY_URI;
    public static final c INSTANCE = new c();
    public static final String PERMISSION_ACCESS_TASK_INFO = "com.stepos.ailauncher.taskstore.permission.ACCESS_TASK_INFO";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\nR\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\nR\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\nR\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\nR\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\nR\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\nR\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\nR\u0014\u0010\u001f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\nR\u0014\u0010 \u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\nR\u0014\u0010!\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\nR\u0014\u0010\"\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\nR\u0014\u0010#\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\nR\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\nR\u0014\u0010%\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\nR\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\nR\u0014\u0010'\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\nR\u0014\u0010(\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\nR\u0014\u0010*\u001a\u00020)8\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010\nR\u0014\u0010-\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010\nR\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040.8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/taskstore/provider/c$a;", "", "<init>", "()V", "", "taskId", "Landroid/net/Uri;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Landroid/net/Uri;", "TABLE", "Ljava/lang/String;", "TABLE_ALIAS", "CONTENT_URI", "Landroid/net/Uri;", "CONTENT_URI_ALIAS", "CONTENT_TYPE", "CONTENT_ITEM_TYPE", "COL_TASK_ID", "COL_EVENT_TYPE", "COL_SEQ", "COL_TS", "COL_SESSION_KEY", "COL_PARENT_TASK_ID", "COL_SUB_TASK_IDS_JSON", "COL_TYPE", "COL_VERSION", "COL_STATUS", "COL_TITLE", "COL_SUB_TITLE", "COL_PROGRESS_JSON", "COL_SUMMARY", "COL_REQUEST_SESSION_KEY", "COL_PENDING_QUESTIONS_JSON", "COL_CREATED_AT", "COL_STARTED_AT", "COL_ENDED_AT", "COL_UPDATED_AT", "COL_RESULT_JSON", "COL_EXTENSIONS_JSON", "COL_SUB_TASKS_JSON", "COL_ANSWER_JSON", "", "DEFAULT_VERSION", "I", "DEFAULT_STATUS", "DEFAULT_EVENT_TYPE", "", "REQUIRED_COLUMNS", "[Ljava/lang/String;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public static final String COL_ANSWER_JSON = "answer_json";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_ENDED_AT = "ended_at";
        public static final String COL_EVENT_TYPE = "event_type";
        public static final String COL_EXTENSIONS_JSON = "extensions_json";
        public static final String COL_PARENT_TASK_ID = "parent_task_id";
        public static final String COL_PENDING_QUESTIONS_JSON = "pending_questions_json";
        public static final String COL_PROGRESS_JSON = "progress_json";
        public static final String COL_REQUEST_SESSION_KEY = "request_session_key";
        public static final String COL_RESULT_JSON = "result_json";
        public static final String COL_SEQ = "seq";
        public static final String COL_SESSION_KEY = "session_key";
        public static final String COL_STARTED_AT = "started_at";
        public static final String COL_STATUS = "status";
        public static final String COL_SUB_TASKS_JSON = "sub_tasks_json";
        public static final String COL_SUB_TASK_IDS_JSON = "sub_task_ids_json";
        public static final String COL_SUB_TITLE = "sub_title";
        public static final String COL_SUMMARY = "summary";
        public static final String COL_TASK_ID = "task_id";
        public static final String COL_TITLE = "title";
        public static final String COL_TS = "ts";
        public static final String COL_TYPE = "type";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final String COL_VERSION = "version";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.com.stepos.ailauncher.taskstore.provider.task_info";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.com.stepos.ailauncher.taskstore.provider.task_info";
        public static final Uri CONTENT_URI;
        public static final Uri CONTENT_URI_ALIAS;
        public static final String DEFAULT_EVENT_TYPE = "CREATED";
        public static final String DEFAULT_STATUS = "CREATED";
        public static final int DEFAULT_VERSION = 1;
        public static final a INSTANCE = new a();
        public static final String[] REQUIRED_COLUMNS;
        public static final String TABLE = "task_info";
        public static final String TABLE_ALIAS = "task_info_cards";

        static {
            Uri uri = c.AUTHORITY_URI;
            Uri uriWithAppendedPath = Uri.withAppendedPath(uri, TABLE);
            p.h(uriWithAppendedPath, "withAppendedPath(...)");
            CONTENT_URI = uriWithAppendedPath;
            Uri uriWithAppendedPath2 = Uri.withAppendedPath(uri, TABLE_ALIAS);
            p.h(uriWithAppendedPath2, "withAppendedPath(...)");
            CONTENT_URI_ALIAS = uriWithAppendedPath2;
            REQUIRED_COLUMNS = new String[]{"task_id", "type"};
        }

        public static final Uri a(String taskId) {
            p.i(taskId, "taskId");
            Uri uriWithAppendedPath = Uri.withAppendedPath(CONTENT_URI, taskId);
            p.h(uriWithAppendedPath, "withAppendedPath(...)");
            return uriWithAppendedPath;
        }
    }

    static {
        Uri uri = Uri.parse("content://com.stepos.ailauncher.taskstore.provider");
        p.h(uri, "parse(...)");
        AUTHORITY_URI = uri;
    }
}
