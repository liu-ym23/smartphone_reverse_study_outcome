package com.bytedance.ai.applet.db;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes43.dex */
public final class f extends EntityDeletionOrUpdateAdapter<i> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE OR ABORT `widget_context_info` SET `card_id` = ?,`message_id` = ?,`conversation_id` = ?,`bot_id` = ? WHERE `card_id` = ?";
    }

    public f(WidgetContextDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, i r101) {
        i r102 = r101;
        String r103 = r102.f34586a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f34587b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f34588c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        String r106 = r102.f34589d;
        if (r106 != null) goto L17;
        r100.bindNull(4);
    L18:
        String r107 = r102.f34586a;
        if (r107 != null) goto L21;
        r100.bindNull(5);
        return;
    L21:
        r100.bindString(5, r107);
        return;
    L17:
        r100.bindString(4, r106);
        goto L18
    L13:
        r100.bindString(3, r105);
        goto L14
    L9:
        r100.bindString(2, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
