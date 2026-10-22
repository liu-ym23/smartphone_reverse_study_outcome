package ck5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.notification.db.NotificationDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM Notification ";
    }

    public d(NotificationDatabase r100) {
        super(r100);
    }
}
