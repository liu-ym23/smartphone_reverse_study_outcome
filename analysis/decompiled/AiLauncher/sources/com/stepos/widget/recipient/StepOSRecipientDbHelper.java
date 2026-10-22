package com.stepos.widget.recipient;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientDbHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/database/sqlite/SQLiteDatabase;", "db", "LY8/t;", "onCreate", "(Landroid/database/sqlite/SQLiteDatabase;)V", "", "oldVersion", "newVersion", "onUpgrade", "(Landroid/database/sqlite/SQLiteDatabase;II)V", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSRecipientDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "recipient_history.db";
    private static final int DATABASE_VERSION = 2;
    public static final String TAG = "RecipientDbHelper";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientDbHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
        kotlin.jvm.internal.p.i(context, "context");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db2) throws SQLException {
        kotlin.jvm.internal.p.i(db2, "db");
        db2.execSQL("CREATE TABLE IF NOT EXISTS email (_id INTEGER PRIMARY KEY,email TEXT,display_name TEXT,frequence INTEGER,last_time INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) throws SQLException {
        kotlin.jvm.internal.p.i(db2, "db");
        Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion);
        if (oldVersion < 2) {
            try {
                db2.execSQL("ALTER TABLE email ADD COLUMN display_name TEXT;");
            } catch (SQLException unused) {
                db2.execSQL("DROP TABLE IF EXISTS email");
                onCreate(db2);
            }
        }
    }
}
