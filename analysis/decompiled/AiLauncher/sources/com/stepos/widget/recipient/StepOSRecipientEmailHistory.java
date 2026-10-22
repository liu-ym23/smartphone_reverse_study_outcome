package com.stepos.widget.recipient;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEmailHistory;", "", "<init>", "()V", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSRecipientEmailHistory {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DISPLAY_NAME = "display_name";
    public static final String EMAIL = "email";
    public static final String FREQUENCE = "frequence";
    public static final String LAST_TIME = "last_time";
    private static final int MAX_ENTRIES = 500;
    public static final String TABLE_NAME = "email";
    public static final String _ID = "_id";

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u000e\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEmailHistory$Companion;", "", "<init>", "()V", "Landroid/database/sqlite/SQLiteDatabase;", "db", "LY8/t;", "removeExpiredEntries", "(Landroid/database/sqlite/SQLiteDatabase;)V", "Landroid/content/Context;", "context", "", "", "entries", "saveHistory", "(Landroid/content/Context;[Ljava/lang/String;)V", "Lcom/stepos/widget/recipient/StepOSRecipientDbHelper;", "dbHelper", "(Lcom/stepos/widget/recipient/StepOSRecipientDbHelper;[Ljava/lang/String;)V", "clearHistory", "(Landroid/content/Context;)V", "TABLE_NAME", "Ljava/lang/String;", "_ID", "EMAIL", "DISPLAY_NAME", "FREQUENCE", "LAST_TIME", "", "MAX_ENTRIES", "I", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private final void removeExpiredEntries(SQLiteDatabase db2) {
            String str = "_id IN (SELECT _id FROM email ORDER BY " + StepOSRecipientEmailHistory.LAST_TIME + " DESC LIMIT -1 OFFSET 500)";
            kotlin.jvm.internal.p.h(str, "toString(...)");
            db2.delete("email", str, null);
        }

        public final void clearHistory(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            StepOSRecipientDbHelper stepOSRecipientDbHelper = new StepOSRecipientDbHelper(context);
            try {
                SQLiteDatabase writableDatabase = stepOSRecipientDbHelper.getWritableDatabase();
                kotlin.jvm.internal.p.h(writableDatabase, "getWritableDatabase(...)");
                writableDatabase.delete("email", null, null);
            } finally {
                stepOSRecipientDbHelper.close();
            }
        }

        public final void saveHistory(Context context, String... entries) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(entries, "entries");
            StepOSRecipientDbHelper stepOSRecipientDbHelper = new StepOSRecipientDbHelper(context);
            try {
                saveHistory(stepOSRecipientDbHelper, (String[]) Arrays.copyOf(entries, entries.length));
            } finally {
                stepOSRecipientDbHelper.close();
            }
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00bd A[Catch: all -> 0x00bb, TRY_LEAVE, TryCatch #3 {all -> 0x00bb, blocks: (B:37:0x0081, B:39:0x0087, B:42:0x00bd), top: B:69:0x0081 }] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00f5 A[Catch: all -> 0x0057, TryCatch #2 {all -> 0x0057, blocks: (B:8:0x001b, B:10:0x0020, B:45:0x00e3, B:13:0x0026, B:16:0x0043, B:19:0x004d, B:21:0x0053, B:44:0x00e0, B:56:0x00f5, B:57:0x00f8, B:58:0x00f9), top: B:68:0x001b }] */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void saveHistory(com.stepos.widget.recipient.StepOSRecipientDbHelper r18, java.lang.String... r19) {
            /*
                Method dump skipped, instructions count: 266
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.recipient.StepOSRecipientEmailHistory.Companion.saveHistory(com.stepos.widget.recipient.StepOSRecipientDbHelper, java.lang.String[]):void");
        }
    }

    public static final void clearHistory(Context context) {
        INSTANCE.clearHistory(context);
    }

    public static final void saveHistory(Context context, String... strArr) {
        INSTANCE.saveHistory(context, strArr);
    }

    public static final void saveHistory(StepOSRecipientDbHelper stepOSRecipientDbHelper, String... strArr) {
        INSTANCE.saveHistory(stepOSRecipientDbHelper, strArr);
    }
}
