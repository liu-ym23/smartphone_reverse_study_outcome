package com.bytedance.ai.applet.db;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends EntityInsertionAdapter<i> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `widget_context_info` (`card_id`,`message_id`,`conversation_id`,`bot_id`) VALUES (?,?,?,?)";
    }

    public c(WidgetContextDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
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
        return;
    L17:
        r100.bindString(4, r106);
        return;
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
