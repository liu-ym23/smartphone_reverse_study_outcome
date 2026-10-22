package ck5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.notification.db.NotificationDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE Notification SET close = 1 WHERE id = ?";
    }

    public f(NotificationDatabase r100) {
        super(r100);
    }
}
